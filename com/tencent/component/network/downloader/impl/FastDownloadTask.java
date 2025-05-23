package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.impl.DownloadTask;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import com.tencent.component.network.module.common.NetworkStatus;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.SDCardUtil;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.net.Proxy;
import java.net.UnknownHostException;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HttpContext;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FastDownloadTask extends DownloadTask {
    int connect_retry;
    long connect_time;
    int exe_retry;
    long exe_time;
    private boolean mAPNProxy;
    private boolean mAllowProxy;
    private String mDomainWithPort;
    private int mOrigPort;
    private String mRealUrl;
    private String mRefer;
    private final long mTimeStamp;
    long send_req_time;
    private Proxy triedNetworkProxy;

    public FastDownloadTask(Context context, OkHttpClient okHttpClient, QZoneHttpClient qZoneHttpClient, String str, String str2, boolean z16, boolean z17) {
        super(context, okHttpClient, qZoneHttpClient, str, str2, z16, z17);
        this.mTimeStamp = SystemClock.uptimeMillis();
        this.mOrigPort = 0;
        this.connect_time = 0L;
        this.connect_retry = 0;
        this.exe_time = 0L;
        this.exe_retry = 0;
        this.send_req_time = 0L;
    }

    private boolean setStrategy(int i3) throws UnknownHostException {
        int i16;
        boolean z16;
        boolean z17;
        DownloadGlobalStrategy.StrategyInfo strategyInfo;
        DownloadGlobalStrategy.StrategyInfo strategyInfo2;
        String domain = getDomain();
        if (this.pDownloadStrategyLib == null) {
            this.pDownloadStrategyLib = DownloadGlobalStrategy.getInstance(this.mContext).getStrategyLib(getUrl(), getDomain(), this.mIsHttp2);
        }
        this.pOldStrategyInfo = this.pCurrStrategyInfo;
        if (this.pDownloadStrategyLib.getStrategyList() != null) {
            i16 = this.pDownloadStrategyLib.getStrategyList().size();
        } else {
            i16 = 0;
        }
        if (i16 == 0) {
            return false;
        }
        this.pCurrStrategyInfo = this.pDownloadStrategyLib.getStrategyInfo(this.attemptStrategyCount % i16);
        while (true) {
            z16 = this.mIsHttp2;
            if (!z16 || (strategyInfo = this.pCurrStrategyInfo) == null || (strategyInfo2 = this.pOldStrategyInfo) == null || strategyInfo.f99899id != strategyInfo2.f99899id) {
                break;
            }
            int i17 = this.attemptStrategyCount + 1;
            this.attemptStrategyCount = i17;
            this.pCurrStrategyInfo = this.pDownloadStrategyLib.getStrategyInfo(i17 % i16);
        }
        int i18 = this.attemptStrategyCount + 1;
        this.attemptStrategyCount = i18;
        int i19 = 80;
        if (z16 && i18 > i16) {
            this.mIsHttp2 = false;
            this.pDownloadStrategyLib.setPort(80);
        }
        if (this.mIsHttp2) {
            i19 = WebSocketImpl.DEFAULT_WSS_PORT;
        }
        this.mStandardPort = i19;
        if (QDLog.isInfoEnable()) {
            QDLog.i("downloader_strategy", "downloader strategy: " + this.pCurrStrategyInfo.toString() + " currAttempCount:" + i3 + " attemptStrategyCount:" + this.attemptStrategyCount + " ,best:" + this.pDownloadStrategyLib.getBestId() + " url:" + getUrl() + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
        }
        DownloadGlobalStrategy.StrategyInfo strategyInfo3 = this.pCurrStrategyInfo;
        this.mAllowProxy = strategyInfo3.allowProxy;
        this.mAPNProxy = strategyInfo3.useConfigApn;
        int port = this.pDownloadStrategyLib.getPort();
        if (!Utils.isPortValid(port)) {
            this.pDownloadStrategyLib.setPort(this.mStandardPort);
            port = this.mStandardPort;
        }
        int i26 = DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id;
        int i27 = this.pCurrStrategyInfo.f99899id;
        if (i26 == i27) {
            DownloadGlobalStrategy.StrategyInfo strategyInfo4 = this.pOldStrategyInfo;
            if (strategyInfo4 != null && i26 == strategyInfo4.f99899id) {
                PortConfigStrategy portConfigStrategy = this.pPortConfigStrategy;
                if (portConfigStrategy != null && portConfigStrategy.supportExtraPort(domain)) {
                    int changePort = this.pPortConfigStrategy.changePort(domain, port);
                    if (changePort != port && Utils.isPortValid(changePort)) {
                        port = changePort;
                    } else {
                        if (QDLog.isInfoEnable()) {
                            QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! port:" + port + " newport:" + changePort + " threadId:" + Thread.currentThread().getId());
                        }
                        return false;
                    }
                } else {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
                    }
                    return false;
                }
            }
            String backupIP = this.pDownloadStrategyLib.getBackupIP();
            IPStrategy iPStrategy = this.pBackupIPConfigStrategy;
            if (iPStrategy != null && !iPStrategy.isIPValid(domain, backupIP)) {
                this.pDownloadStrategyLib.setBackupIP(null);
                backupIP = this.pBackupIPConfigStrategy.resolveIP(domain);
                if (!TextUtils.isEmpty(backupIP)) {
                    this.pDownloadStrategyLib.setBackupIP(backupIP);
                } else {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
                    }
                    return false;
                }
            }
            DownloadGlobalStrategy.StrategyInfo m107clone = this.pCurrStrategyInfo.m107clone();
            this.pCurrStrategyInfo = m107clone;
            m107clone.setIPInfo(new IPInfo(backupIP, port));
        } else {
            int i28 = DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.f99899id;
            if (i28 == i27) {
                DownloadGlobalStrategy.StrategyInfo strategyInfo5 = this.pOldStrategyInfo;
                if (strategyInfo5 != null && i28 == strategyInfo5.f99899id) {
                    PortConfigStrategy portConfigStrategy2 = this.pPortConfigStrategy;
                    if (portConfigStrategy2 != null && portConfigStrategy2.supportExtraPort(domain)) {
                        int changePort2 = this.pPortConfigStrategy.changePort(domain, port);
                        if (changePort2 != port && Utils.isPortValid(changePort2)) {
                            port = changePort2;
                        } else {
                            if (QDLog.isInfoEnable()) {
                                QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! port:" + port + " newport:" + changePort2 + " threadId:" + Thread.currentThread().getId());
                            }
                            return false;
                        }
                    } else {
                        if (QDLog.isInfoEnable()) {
                            QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
                        }
                        return false;
                    }
                }
                String domainIP = DnsService.getInstance().getDomainIP(domain);
                if (TextUtils.isEmpty(domainIP)) {
                    domainIP = DnsService.getInstance().getDomainIP(domain);
                }
                if (domainIP != null && !domainIP.equals(this.pDownloadStrategyLib.getBackupIP()) && !domainIP.equals(this.pDownloadStrategyLib.getDirectIP())) {
                    this.pDownloadStrategyLib.setDnsIP(domainIP);
                    DownloadGlobalStrategy.StrategyInfo m107clone2 = this.pCurrStrategyInfo.m107clone();
                    this.pCurrStrategyInfo = m107clone2;
                    m107clone2.setIPInfo(new IPInfo(domainIP, port));
                } else {
                    this.pDownloadStrategyLib.setDnsIP(null);
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! Domain IP \u91cd\u590d. threadId:" + Thread.currentThread().getId());
                    }
                    return false;
                }
            } else {
                int i29 = DownloadGlobalStrategy.Strategy_DomainDirect.f99899id;
                if (i29 == i27) {
                    DownloadGlobalStrategy.StrategyInfo strategyInfo6 = this.pOldStrategyInfo;
                    if (strategyInfo6 != null && i29 == strategyInfo6.f99899id) {
                        PortConfigStrategy portConfigStrategy3 = this.pPortConfigStrategy;
                        if (portConfigStrategy3 != null && portConfigStrategy3.supportExtraPort(domain)) {
                            int changePort3 = this.pPortConfigStrategy.changePort(domain, port);
                            if (changePort3 != port && Utils.isPortValid(changePort3)) {
                                port = changePort3;
                            } else {
                                if (QDLog.isInfoEnable()) {
                                    QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! port:" + port + " newport:" + changePort3 + " threadId:" + Thread.currentThread().getId());
                                }
                                return false;
                            }
                        } else {
                            if (QDLog.isInfoEnable()) {
                                QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! Not support !" + this.mStandardPort + ". threadId:" + Thread.currentThread().getId());
                            }
                            return false;
                        }
                    }
                } else if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.f99899id == i27 || DownloadGlobalStrategy.Strategy_DomainProxy_CON.f99899id == i27) {
                    Context context = this.mContext;
                    if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.f99899id == i27) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    Proxy proxy = NetworkUtils.getProxy(context, z17);
                    if (proxy == null) {
                        if (QDLog.isInfoEnable()) {
                            QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
                        }
                        return false;
                    }
                    if (proxy.equals(this.triedNetworkProxy)) {
                        if (QDLog.isInfoEnable()) {
                            QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: proxy \u91cd\u590d. Pass! threadId:" + Thread.currentThread().getId());
                        }
                        return false;
                    }
                    this.triedNetworkProxy = proxy;
                    return true;
                }
                String directIP = this.pDownloadStrategyLib.getDirectIP();
                IPStrategy iPStrategy2 = this.pDirectIPConfigStrategy;
                if (iPStrategy2 != null && !iPStrategy2.isIPValid(domain, directIP)) {
                    this.pDownloadStrategyLib.setDirectIP(null);
                    directIP = this.pDirectIPConfigStrategy.resolveIP(domain);
                    if (!TextUtils.isEmpty(directIP)) {
                        this.pDownloadStrategyLib.setDirectIP(directIP);
                    } else {
                        if (QDLog.isInfoEnable()) {
                            QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
                        }
                        return false;
                    }
                }
                if (directIP != null && !directIP.equals(this.pDownloadStrategyLib.getBackupIP()) && !directIP.equals(this.pDownloadStrategyLib.getDnsIP())) {
                    DownloadGlobalStrategy.StrategyInfo m107clone3 = this.pCurrStrategyInfo.m107clone();
                    this.pCurrStrategyInfo = m107clone3;
                    m107clone3.setIPInfo(new IPInfo(directIP, port));
                } else {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! Domain IP \u91cd\u590d. threadId:" + Thread.currentThread().getId());
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(1:(1:1158)(6:1159|621|622|623|(4:640|641|642|(3:645|646|(3:648|649|(13:651|(1:814)(1:655)|656|(4:806|807|808|809)(1:658)|659|(1:805)|663|(21:665|(13:667|(1:672)|673|(1:675)(1:778)|676|(1:678)(1:777)|679|(1:681)(1:776)|682|(1:684)(1:775)|685|(1:687)|688)(11:779|(1:784)|785|(1:787)(1:801)|788|(1:790)(1:800)|791|(1:793)(1:799)|794|(1:796)(1:798)|797)|(1:690)|691|(1:693)(1:774)|694|(1:696)(1:773)|697|(1:772)(3:703|704|(4:706|707|708|709)(1:768))|710|711|(3:717|718|(1:720)(1:721))|(4:726|(1:763)(2:729|(2:731|732))|762|732)(1:764)|733|(1:735)(1:761)|736|(1:760)(1:740)|741|(1:745)|746|(1:748))(1:802)|749|(3:751|(1:753)|754)(3:756|(1:758)|759)|755|23|(0)(0))(11:815|816|(1:981)(1:820)|821|(4:973|974|976|977)(1:823)|824|(1:972)|828|(21:830|(13:832|(1:837)|838|(1:840)(1:934)|841|(1:843)(1:933)|844|(1:846)(1:932)|847|(1:849)(1:931)|850|(1:852)|853)(11:935|(1:940)|941|(1:943)(1:957)|944|(1:946)(1:956)|947|(1:949)(1:955)|950|(1:952)(1:954)|953)|(1:855)|856|(1:858)(1:930)|859|(1:861)(1:929)|862|(1:928)(5:868|869|870|(3:872|873|874)(1:923)|875)|876|877|(4:883|884|(1:886)(1:889)|887)|(4:893|(1:919)(2:896|(2:898|899))|918|899)(1:920)|900|(1:902)(1:917)|903|(1:916)(1:907)|908|(1:912)|913|(1:915))|958|(4:960|(1:962)|963|964)(1:965)))(11:985|986|(1:1146)(1:990)|991|(4:1138|1139|1141|1142)(1:993)|994|(1:1137)|998|(21:1000|(13:1002|(1:1007)|1008|(1:1010)(1:1104)|1011|(1:1013)(1:1103)|1014|(1:1016)(1:1102)|1017|(1:1019)(1:1101)|1020|(1:1022)|1023)(11:1105|(1:1110)|1111|(1:1113)(1:1127)|1114|(1:1116)(1:1126)|1117|(1:1119)(1:1125)|1120|(1:1122)(1:1124)|1123)|(1:1025)|1026|(1:1028)(1:1100)|1029|(1:1031)(1:1099)|1032|(1:1098)(5:1038|1039|1040|(3:1042|1043|1044)(1:1093)|1045)|1046|1047|(4:1053|1054|(1:1056)(1:1059)|1057)|(4:1063|(1:1089)(2:1066|(2:1068|1069))|1088|1069)(1:1090)|1070|(1:1072)(1:1087)|1073|(1:1086)(1:1077)|1078|(1:1082)|1083|(1:1085))|1128|(4:1130|(1:1132)|963|964)(1:1133)))(1:644))(5:627|(2:638|639)(1:629)|630|(1:632)|633)|634))(1:619)|620|621|622|623|(1:625)|640|641|642|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(26:(7:390|391|(2:1279|1280)(1:393)|394|395|396|397)|(3:1193|1194|(33:1204|(2:1206|(10:1226|1227|(1:1229)(1:1237)|1230|(1:1232)|1233|(1:1235)|1236|1210|(5:1213|1214|1215|1216|1217)(1:1212))(4:1208|1209|1210|(0)(0)))(6:1241|(1:1244)|1245|(8:1247|(1:1249)(1:1258)|1250|(1:1252)|1253|1254|1255|(1:1257))(3:1259|(2:1261|(6:1263|(1:1265)(1:1272)|1266|(1:1268)|1269|(1:1271)))|1209)|1210|(0)(0))|419|420|(1:422)|423|(1:1188)(1:426)|427|(1:429)|430|431|432|433|434|435|436|(7:1165|1166|(1:1168)|1169|1170|1171|1172)(2:438|(2:440|441)(1:1164))|442|443|(10:(1:(1:1158)(6:1159|621|622|623|(4:640|641|642|(3:645|646|(3:648|649|(13:651|(1:814)(1:655)|656|(4:806|807|808|809)(1:658)|659|(1:805)|663|(21:665|(13:667|(1:672)|673|(1:675)(1:778)|676|(1:678)(1:777)|679|(1:681)(1:776)|682|(1:684)(1:775)|685|(1:687)|688)(11:779|(1:784)|785|(1:787)(1:801)|788|(1:790)(1:800)|791|(1:793)(1:799)|794|(1:796)(1:798)|797)|(1:690)|691|(1:693)(1:774)|694|(1:696)(1:773)|697|(1:772)(3:703|704|(4:706|707|708|709)(1:768))|710|711|(3:717|718|(1:720)(1:721))|(4:726|(1:763)(2:729|(2:731|732))|762|732)(1:764)|733|(1:735)(1:761)|736|(1:760)(1:740)|741|(1:745)|746|(1:748))(1:802)|749|(3:751|(1:753)|754)(3:756|(1:758)|759)|755|23|(0)(0))(11:815|816|(1:981)(1:820)|821|(4:973|974|976|977)(1:823)|824|(1:972)|828|(21:830|(13:832|(1:837)|838|(1:840)(1:934)|841|(1:843)(1:933)|844|(1:846)(1:932)|847|(1:849)(1:931)|850|(1:852)|853)(11:935|(1:940)|941|(1:943)(1:957)|944|(1:946)(1:956)|947|(1:949)(1:955)|950|(1:952)(1:954)|953)|(1:855)|856|(1:858)(1:930)|859|(1:861)(1:929)|862|(1:928)(5:868|869|870|(3:872|873|874)(1:923)|875)|876|877|(4:883|884|(1:886)(1:889)|887)|(4:893|(1:919)(2:896|(2:898|899))|918|899)(1:920)|900|(1:902)(1:917)|903|(1:916)(1:907)|908|(1:912)|913|(1:915))|958|(4:960|(1:962)|963|964)(1:965)))(11:985|986|(1:1146)(1:990)|991|(4:1138|1139|1141|1142)(1:993)|994|(1:1137)|998|(21:1000|(13:1002|(1:1007)|1008|(1:1010)(1:1104)|1011|(1:1013)(1:1103)|1014|(1:1016)(1:1102)|1017|(1:1019)(1:1101)|1020|(1:1022)|1023)(11:1105|(1:1110)|1111|(1:1113)(1:1127)|1114|(1:1116)(1:1126)|1117|(1:1119)(1:1125)|1120|(1:1122)(1:1124)|1123)|(1:1025)|1026|(1:1028)(1:1100)|1029|(1:1031)(1:1099)|1032|(1:1098)(5:1038|1039|1040|(3:1042|1043|1044)(1:1093)|1045)|1046|1047|(4:1053|1054|(1:1056)(1:1059)|1057)|(4:1063|(1:1089)(2:1066|(2:1068|1069))|1088|1069)(1:1090)|1070|(1:1072)(1:1087)|1073|(1:1086)(1:1077)|1078|(1:1082)|1083|(1:1085))|1128|(4:1130|(1:1132)|963|964)(1:1133)))(1:644))(5:627|(2:638|639)(1:629)|630|(1:632)|633)|634))(1:619)|620|621|622|623|(1:625)|640|641|642|(0)(0))(2:446|447)|448|(1:611)(1:452)|453|(4:603|604|606|607)(1:455)|456|(1:602)|460|(21:462|(13:464|(1:469)|470|(1:472)(1:575)|473|(1:475)(1:574)|476|(1:478)(1:573)|479|(1:481)(1:572)|482|(1:484)|485)(11:576|(1:581)|582|(1:584)(1:598)|585|(1:587)(1:597)|588|(1:590)(1:596)|591|(1:593)(1:595)|594)|(1:487)|488|(1:490)(1:571)|491|(1:493)(1:570)|494|(1:569)(3:500|501|(4:503|504|505|506)(1:565))|507|508|(3:514|515|(1:517)(1:518))|(4:523|(1:560)(2:526|(2:528|529))|559|529)(1:561)|530|(1:532)(1:558)|533|(1:557)(1:537)|538|(1:542)|543|(1:545))(1:599)|546|(3:548|(1:550)|551)(3:553|(1:555)|556)|552|23|(0)(0)))|399|400|(8:406|(1:408)(1:418)|409|(1:411)|412|(1:414)|415|(1:417))|419|420|(0)|423|(0)|1188|427|(0)|430|431|432|433|434|435|436|(0)(0)|442|443|(0)|(1:617)|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(32:390|391|(2:1279|1280)(1:393)|394|395|396|397|(3:1193|1194|(33:1204|(2:1206|(10:1226|1227|(1:1229)(1:1237)|1230|(1:1232)|1233|(1:1235)|1236|1210|(5:1213|1214|1215|1216|1217)(1:1212))(4:1208|1209|1210|(0)(0)))(6:1241|(1:1244)|1245|(8:1247|(1:1249)(1:1258)|1250|(1:1252)|1253|1254|1255|(1:1257))(3:1259|(2:1261|(6:1263|(1:1265)(1:1272)|1266|(1:1268)|1269|(1:1271)))|1209)|1210|(0)(0))|419|420|(1:422)|423|(1:1188)(1:426)|427|(1:429)|430|431|432|433|434|435|436|(7:1165|1166|(1:1168)|1169|1170|1171|1172)(2:438|(2:440|441)(1:1164))|442|443|(10:(1:(1:1158)(6:1159|621|622|623|(4:640|641|642|(3:645|646|(3:648|649|(13:651|(1:814)(1:655)|656|(4:806|807|808|809)(1:658)|659|(1:805)|663|(21:665|(13:667|(1:672)|673|(1:675)(1:778)|676|(1:678)(1:777)|679|(1:681)(1:776)|682|(1:684)(1:775)|685|(1:687)|688)(11:779|(1:784)|785|(1:787)(1:801)|788|(1:790)(1:800)|791|(1:793)(1:799)|794|(1:796)(1:798)|797)|(1:690)|691|(1:693)(1:774)|694|(1:696)(1:773)|697|(1:772)(3:703|704|(4:706|707|708|709)(1:768))|710|711|(3:717|718|(1:720)(1:721))|(4:726|(1:763)(2:729|(2:731|732))|762|732)(1:764)|733|(1:735)(1:761)|736|(1:760)(1:740)|741|(1:745)|746|(1:748))(1:802)|749|(3:751|(1:753)|754)(3:756|(1:758)|759)|755|23|(0)(0))(11:815|816|(1:981)(1:820)|821|(4:973|974|976|977)(1:823)|824|(1:972)|828|(21:830|(13:832|(1:837)|838|(1:840)(1:934)|841|(1:843)(1:933)|844|(1:846)(1:932)|847|(1:849)(1:931)|850|(1:852)|853)(11:935|(1:940)|941|(1:943)(1:957)|944|(1:946)(1:956)|947|(1:949)(1:955)|950|(1:952)(1:954)|953)|(1:855)|856|(1:858)(1:930)|859|(1:861)(1:929)|862|(1:928)(5:868|869|870|(3:872|873|874)(1:923)|875)|876|877|(4:883|884|(1:886)(1:889)|887)|(4:893|(1:919)(2:896|(2:898|899))|918|899)(1:920)|900|(1:902)(1:917)|903|(1:916)(1:907)|908|(1:912)|913|(1:915))|958|(4:960|(1:962)|963|964)(1:965)))(11:985|986|(1:1146)(1:990)|991|(4:1138|1139|1141|1142)(1:993)|994|(1:1137)|998|(21:1000|(13:1002|(1:1007)|1008|(1:1010)(1:1104)|1011|(1:1013)(1:1103)|1014|(1:1016)(1:1102)|1017|(1:1019)(1:1101)|1020|(1:1022)|1023)(11:1105|(1:1110)|1111|(1:1113)(1:1127)|1114|(1:1116)(1:1126)|1117|(1:1119)(1:1125)|1120|(1:1122)(1:1124)|1123)|(1:1025)|1026|(1:1028)(1:1100)|1029|(1:1031)(1:1099)|1032|(1:1098)(5:1038|1039|1040|(3:1042|1043|1044)(1:1093)|1045)|1046|1047|(4:1053|1054|(1:1056)(1:1059)|1057)|(4:1063|(1:1089)(2:1066|(2:1068|1069))|1088|1069)(1:1090)|1070|(1:1072)(1:1087)|1073|(1:1086)(1:1077)|1078|(1:1082)|1083|(1:1085))|1128|(4:1130|(1:1132)|963|964)(1:1133)))(1:644))(5:627|(2:638|639)(1:629)|630|(1:632)|633)|634))(1:619)|620|621|622|623|(1:625)|640|641|642|(0)(0))(2:446|447)|448|(1:611)(1:452)|453|(4:603|604|606|607)(1:455)|456|(1:602)|460|(21:462|(13:464|(1:469)|470|(1:472)(1:575)|473|(1:475)(1:574)|476|(1:478)(1:573)|479|(1:481)(1:572)|482|(1:484)|485)(11:576|(1:581)|582|(1:584)(1:598)|585|(1:587)(1:597)|588|(1:590)(1:596)|591|(1:593)(1:595)|594)|(1:487)|488|(1:490)(1:571)|491|(1:493)(1:570)|494|(1:569)(3:500|501|(4:503|504|505|506)(1:565))|507|508|(3:514|515|(1:517)(1:518))|(4:523|(1:560)(2:526|(2:528|529))|559|529)(1:561)|530|(1:532)(1:558)|533|(1:557)(1:537)|538|(1:542)|543|(1:545))(1:599)|546|(3:548|(1:550)|551)(3:553|(1:555)|556)|552|23|(0)(0)))|399|400|(8:406|(1:408)(1:418)|409|(1:411)|412|(1:414)|415|(1:417))|419|420|(0)|423|(0)|1188|427|(0)|430|431|432|433|434|435|436|(0)(0)|442|443|(0)|(1:617)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:1134:0x1c2b, code lost:
    
        if (r0 != null) goto L523;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1151:0x23e5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1152:0x23e6, code lost:
    
        r1 = r14;
        r3 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r15 = ", localAddress=";
        r68 = ", redirectURI=";
        r67 = "https";
        r22 = r35;
        r5 = r41;
        r9 = ", dns=";
        r12 = ", contentType=";
        r24 = r10;
        r10 = " , requestHttp2=";
        r8 = ", protocol=";
        r13 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
        r11 = r0;
        r69 = r16;
        r14 = r11;
        r4 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1153:0x242b, code lost:
    
        r70 = r22;
        r6 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1155:0x2409, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1156:0x240a, code lost:
    
        r16 = r3;
        r9 = ", dns=";
        r1 = r14;
        r3 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r15 = ", localAddress=";
        r68 = ", redirectURI=";
        r12 = ", contentType=";
        r67 = "https";
        r24 = r5;
        r22 = r10;
        r5 = r41;
        r10 = " , requestHttp2=";
        r8 = ", protocol=";
        r13 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
        r11 = r0;
        r69 = r16;
        r14 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1161:0x2431, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1162:0x2432, code lost:
    
        r9 = ", dns=";
        r1 = r14;
        r3 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r15 = ", localAddress=";
        r68 = ", redirectURI=";
        r12 = ", contentType=";
        r67 = "https";
        r24 = r5;
        r5 = r41;
        r10 = " , requestHttp2=";
        r8 = ", protocol=";
        r13 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
        r11 = r0;
        r14 = r6;
        r70 = r10;
        r6 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1163:0x24d2, code lost:
    
        r69 = 0;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1181:0x2455, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1182:0x2456, code lost:
    
        r9 = ", dns=";
        r1 = r14;
        r3 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r15 = ", localAddress=";
        r68 = ", redirectURI=";
        r12 = ", contentType=";
        r67 = "https";
        r5 = r41;
        r10 = " , requestHttp2=";
        r8 = ", protocol=";
        r13 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
        r11 = r0;
        r70 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1183:0x24cf, code lost:
    
        r4 = null;
        r6 = null;
        r14 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1185:0x246f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1186:0x2470, code lost:
    
        r10 = " , requestHttp2=";
        r9 = ", dns=";
        r8 = ", protocol=";
        r1 = r14;
        r3 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r15 = ", localAddress=";
        r68 = ", redirectURI=";
        r12 = ", contentType=";
        r67 = "https";
        r13 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
        r5 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1187:0x24cc, code lost:
    
        r11 = r0;
        r70 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1190:0x2484, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1191:0x2485, code lost:
    
        r31 = r1;
        r10 = " , requestHttp2=";
        r67 = "https";
        r9 = ", dns=";
        r8 = ", protocol=";
        r3 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r15 = ", localAddress=";
        r68 = ", redirectURI=";
        r12 = ", contentType=";
        r1 = r2;
        r34 = r39;
        r5 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1192:0x24cb, code lost:
    
        r13 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:966:0x148c, code lost:
    
        if (r0 != null) goto L523;
     */
    /* JADX WARN: Code restructure failed: missing block: B:967:0x148e, code lost:
    
        r0.abort();
        r86.request = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:968:0x1493, code lost:
    
        cleanExpireConnection();
     */
    /* JADX WARN: Code restructure failed: missing block: B:969:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1056:0x1af9 A[Catch: Exception -> 0x1b25, TryCatch #32 {Exception -> 0x1b25, blocks: (B:1054:0x1af3, B:1056:0x1af9, B:1059:0x1b0c), top: B:1053:0x1af3 }] */
    /* JADX WARN: Removed duplicated region for block: B:1059:0x1b0c A[Catch: Exception -> 0x1b25, TRY_LEAVE, TryCatch #32 {Exception -> 0x1b25, blocks: (B:1054:0x1af3, B:1056:0x1af9, B:1059:0x1b0c), top: B:1053:0x1af3 }] */
    /* JADX WARN: Removed duplicated region for block: B:1063:0x1b2e  */
    /* JADX WARN: Removed duplicated region for block: B:1072:0x1b74  */
    /* JADX WARN: Removed duplicated region for block: B:1085:0x1c16  */
    /* JADX WARN: Removed duplicated region for block: B:1087:0x1b77  */
    /* JADX WARN: Removed duplicated region for block: B:1090:0x1b57  */
    /* JADX WARN: Removed duplicated region for block: B:1130:0x1c1f  */
    /* JADX WARN: Removed duplicated region for block: B:1133:0x1c28  */
    /* JADX WARN: Removed duplicated region for block: B:1158:0x0524 A[Catch: all -> 0x0506, TRY_LEAVE, TryCatch #39 {all -> 0x0506, blocks: (B:447:0x04cb, B:617:0x04f7, B:619:0x04fd, B:1158:0x0524), top: B:446:0x04cb }] */
    /* JADX WARN: Removed duplicated region for block: B:1159:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x2b7f A[Catch: Exception -> 0x2bab, TryCatch #22 {Exception -> 0x2bab, blocks: (B:113:0x2b79, B:115:0x2b7f, B:116:0x2b92), top: B:112:0x2b79 }] */
    /* JADX WARN: Removed duplicated region for block: B:1165:0x0469 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x2b92 A[Catch: Exception -> 0x2bab, TRY_LEAVE, TryCatch #22 {Exception -> 0x2bab, blocks: (B:113:0x2b79, B:115:0x2b7f, B:116:0x2b92), top: B:112:0x2b79 }] */
    /* JADX WARN: Removed duplicated region for block: B:1212:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:1213:0x027b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x2bb4  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x2bfb  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x2ca0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x2caf  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x2cbb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x2bfe  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x2bdd  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x2ca5  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x25a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x251a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x2cd5 A[LOOP:0: B:2:0x001e->B:25:0x2cd5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x2cd4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x334e A[Catch: Exception -> 0x337a, TryCatch #14 {Exception -> 0x337a, blocks: (B:286:0x3348, B:288:0x334e, B:291:0x3361), top: B:285:0x3348 }] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x3361 A[Catch: Exception -> 0x337a, TRY_LEAVE, TryCatch #14 {Exception -> 0x337a, blocks: (B:286:0x3348, B:288:0x334e, B:291:0x3361), top: B:285:0x3348 }] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x3383  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x33ca  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x346d  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x33cd  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x33ac  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x3476  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x3482  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x03d1 A[Catch: all -> 0x03b2, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x03b2, blocks: (B:1217:0x02ad, B:422:0x03d1, B:426:0x03e3, B:429:0x0418, B:402:0x030d, B:406:0x0319, B:408:0x032e, B:409:0x033f, B:412:0x0347, B:414:0x0366, B:415:0x036e, B:417:0x037c, B:418:0x0337), top: B:1216:0x02ad }] */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0418 A[Catch: all -> 0x03b2, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x03b2, blocks: (B:1217:0x02ad, B:422:0x03d1, B:426:0x03e3, B:429:0x0418, B:402:0x030d, B:406:0x0319, B:408:0x032e, B:409:0x033f, B:412:0x0347, B:414:0x0366, B:415:0x036e, B:417:0x037c, B:418:0x0337), top: B:1216:0x02ad }] */
    /* JADX WARN: Removed duplicated region for block: B:438:0x04a4 A[Catch: all -> 0x2455, TRY_ENTER, TRY_LEAVE, TryCatch #13 {all -> 0x2455, blocks: (B:436:0x045f, B:438:0x04a4), top: B:435:0x045f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x2589  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x2295 A[Catch: Exception -> 0x22c1, TryCatch #54 {Exception -> 0x22c1, blocks: (B:515:0x228f, B:517:0x2295, B:518:0x22a8), top: B:514:0x228f }] */
    /* JADX WARN: Removed duplicated region for block: B:518:0x22a8 A[Catch: Exception -> 0x22c1, TRY_LEAVE, TryCatch #54 {Exception -> 0x22c1, blocks: (B:515:0x228f, B:517:0x2295, B:518:0x22a8), top: B:514:0x228f }] */
    /* JADX WARN: Removed duplicated region for block: B:523:0x22ca  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x2310  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x25be  */
    /* JADX WARN: Removed duplicated region for block: B:545:0x23b5  */
    /* JADX WARN: Removed duplicated region for block: B:548:0x23c4  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x23d0  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x2313  */
    /* JADX WARN: Removed duplicated region for block: B:561:0x22f3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x25e1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x25fc  */
    /* JADX WARN: Removed duplicated region for block: B:644:0x1c53  */
    /* JADX WARN: Removed duplicated region for block: B:645:0x05ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:720:0x0be2 A[Catch: Exception -> 0x0c0c, TryCatch #10 {Exception -> 0x0c0c, blocks: (B:718:0x0bdc, B:720:0x0be2, B:721:0x0bf4), top: B:717:0x0bdc }] */
    /* JADX WARN: Removed duplicated region for block: B:721:0x0bf4 A[Catch: Exception -> 0x0c0c, TRY_LEAVE, TryCatch #10 {Exception -> 0x0c0c, blocks: (B:718:0x0bdc, B:720:0x0be2, B:721:0x0bf4), top: B:717:0x0bdc }] */
    /* JADX WARN: Removed duplicated region for block: B:726:0x0c15  */
    /* JADX WARN: Removed duplicated region for block: B:735:0x0c59  */
    /* JADX WARN: Removed duplicated region for block: B:748:0x0cfb  */
    /* JADX WARN: Removed duplicated region for block: B:751:0x0d0b  */
    /* JADX WARN: Removed duplicated region for block: B:756:0x0d16  */
    /* JADX WARN: Removed duplicated region for block: B:761:0x0c5b  */
    /* JADX WARN: Removed duplicated region for block: B:764:0x0c3c  */
    /* JADX WARN: Removed duplicated region for block: B:886:0x1357 A[Catch: Exception -> 0x1382, TryCatch #15 {Exception -> 0x1382, blocks: (B:884:0x1351, B:886:0x1357, B:889:0x1369), top: B:883:0x1351 }] */
    /* JADX WARN: Removed duplicated region for block: B:889:0x1369 A[Catch: Exception -> 0x1382, TRY_LEAVE, TryCatch #15 {Exception -> 0x1382, blocks: (B:884:0x1351, B:886:0x1357, B:889:0x1369), top: B:883:0x1351 }] */
    /* JADX WARN: Removed duplicated region for block: B:893:0x138b  */
    /* JADX WARN: Removed duplicated region for block: B:902:0x13d1  */
    /* JADX WARN: Removed duplicated region for block: B:915:0x1473  */
    /* JADX WARN: Removed duplicated region for block: B:917:0x13d4  */
    /* JADX WARN: Removed duplicated region for block: B:920:0x13b4  */
    /* JADX WARN: Removed duplicated region for block: B:960:0x147d  */
    /* JADX WARN: Removed duplicated region for block: B:965:0x1489  */
    /* JADX WARN: Type inference failed for: r0v130, types: [com.tencent.component.network.downloader.DownloadResult$Process] */
    /* JADX WARN: Type inference failed for: r0v208, types: [com.tencent.component.network.downloader.DownloadResult$Process] */
    /* JADX WARN: Type inference failed for: r0v41, types: [com.tencent.component.network.downloader.DownloadResult$Process] */
    /* JADX WARN: Type inference failed for: r10v18, types: [long] */
    /* JADX WARN: Type inference failed for: r10v94 */
    /* JADX WARN: Type inference failed for: r10v95 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v35, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v37, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v53, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v96 */
    /* JADX WARN: Type inference failed for: r12v98 */
    /* JADX WARN: Type inference failed for: r13v127 */
    /* JADX WARN: Type inference failed for: r13v136 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v46, types: [long] */
    /* JADX WARN: Type inference failed for: r13v47 */
    /* JADX WARN: Type inference failed for: r13v55 */
    /* JADX WARN: Type inference failed for: r13v56 */
    /* JADX WARN: Type inference failed for: r13v57 */
    /* JADX WARN: Type inference failed for: r13v58 */
    /* JADX WARN: Type inference failed for: r13v59 */
    /* JADX WARN: Type inference failed for: r13v60 */
    /* JADX WARN: Type inference failed for: r13v85 */
    /* JADX WARN: Type inference failed for: r13v86 */
    /* JADX WARN: Type inference failed for: r14v18, types: [long] */
    /* JADX WARN: Type inference failed for: r14v45, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r14v50, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r14v84 */
    /* JADX WARN: Type inference failed for: r14v85 */
    /* JADX WARN: Type inference failed for: r29v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r3v224, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v226, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v242, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r41v0 */
    /* JADX WARN: Type inference failed for: r41v1 */
    /* JADX WARN: Type inference failed for: r41v2 */
    /* JADX WARN: Type inference failed for: r41v3 */
    /* JADX WARN: Type inference failed for: r5v125, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v352 */
    /* JADX WARN: Type inference failed for: r5v353 */
    /* JADX WARN: Type inference failed for: r6v154 */
    /* JADX WARN: Type inference failed for: r6v155 */
    /* JADX WARN: Type inference failed for: r6v57, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v36, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v57, types: [java.lang.StringBuilder] */
    @Override // com.tencent.component.network.downloader.impl.DownloadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(ThreadPool.JobContext jobContext, DownloadResult downloadResult) {
        int i3;
        boolean z16;
        DownloadReport downloadReport;
        long j3;
        int i16;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Throwable th5;
        long j16;
        HttpContext httpContext;
        HttpResponse httpResponse;
        int i17;
        HttpUtil.RequestOptions requestOptions;
        Proxy customProxy;
        Response response;
        boolean isIpV6Stack;
        boolean enableIpv6Debug;
        DownloadGlobalStrategy.StrategyInfo strategyInfo;
        int i18;
        String str12;
        StringBuilder sb5;
        String str13;
        DownloadGlobalStrategy.StrategyInfo strategyInfo2;
        ResumeTransfer resumeTransfer;
        HttpResponse httpResponse2;
        HttpContext createHttpContext;
        HttpResponse execute;
        Response response2;
        int i19;
        int code;
        int i26;
        long j17;
        String str14;
        String str15;
        ResumeTransfer resumeTransfer2;
        HttpGet httpGet;
        HttpGet httpGet2;
        HttpResponse httpResponse3;
        String str16;
        String str17;
        String str18;
        boolean z17;
        int i27;
        String str19;
        String str20;
        NetworkUtils.DNS dns;
        String str21;
        Response response3;
        String str22;
        String str23;
        ?? r132;
        String str24;
        long j18;
        DownloadReport downloadReport2;
        String str25;
        String str26;
        String str27;
        String str28;
        DownloadGlobalStrategy.StrategyInfo strategyInfo3;
        String str29;
        Response response4;
        boolean z18;
        int i28;
        int retcode;
        String str30;
        String str31;
        ResumeTransfer resumeTransfer3;
        HttpResponse httpResponse4;
        String str32;
        boolean z19;
        String str33;
        int i29;
        String str34;
        String str35;
        String str36;
        NetworkUtils.DNS dns2;
        String str37;
        Response response5;
        String str38;
        String str39;
        long j19;
        DownloadReport downloadReport3;
        String str40;
        String str41;
        String str42;
        DownloadGlobalStrategy.StrategyInfo strategyInfo4;
        String str43;
        Response response6;
        boolean z26;
        String str44;
        String str45;
        String str46;
        ResumeTransfer resumeTransfer4;
        ThreadPool.JobContext jobContext2;
        DownloadResult downloadResult2;
        int i36;
        long j26;
        ThreadPool.JobContext jobContext3;
        DownloadResult downloadResult3;
        HttpResponse httpResponse5;
        String str47;
        String str48;
        boolean z27;
        String str49;
        String str50;
        int i37;
        String str51;
        String str52;
        NetworkUtils.DNS dns3;
        String str53;
        Response response7;
        String str54;
        String str55;
        String str56;
        DownloadReport downloadReport4;
        String str57;
        String str58;
        String str59;
        DownloadGlobalStrategy.StrategyInfo strategyInfo5;
        String str60;
        Response response8;
        boolean z28;
        String str61;
        long j27;
        String str62;
        String str63;
        String str64;
        String str65;
        String str66;
        String str67;
        String str68;
        String str69;
        HttpContext httpContext2;
        String str70;
        HttpResponse httpResponse6;
        String str71;
        String str72;
        Response response9;
        int i38;
        String str73;
        HttpResponse httpResponse7;
        Response response10;
        String str74;
        Response response11;
        HttpResponse httpResponse8;
        String str75;
        ?? r65;
        ?? r56;
        String str76;
        String str77;
        ResumeTransfer resumeTransfer5;
        ThreadPool.JobContext jobContext4;
        DownloadResult downloadResult4;
        long j28;
        String str78;
        boolean z29;
        HttpResponse httpResponse9;
        Response response12;
        int i39;
        String str79;
        String str80;
        String str81;
        String str82;
        NetworkUtils.DNS dns4;
        String str83;
        String str84;
        DownloadReport downloadReport5;
        String str85;
        String str86;
        String str87;
        DownloadGlobalStrategy.StrategyInfo strategyInfo6;
        String str88;
        Response response13;
        boolean z36;
        String str89;
        String str90;
        String str91;
        HttpContext httpContext3;
        String str92;
        Response response14;
        String str93;
        String str94;
        String str95;
        String str96;
        String str97;
        String str98;
        String str99;
        String str100;
        int i46;
        long j29;
        long j36;
        HttpResponse httpResponse10;
        String str101;
        String str102;
        Throwable th6;
        Throwable th7;
        String str103;
        String str104;
        ResumeTransfer resumeTransfer6;
        HttpResponse httpResponse11;
        String str105;
        String str106;
        String str107;
        Throwable th8;
        boolean z37;
        int i47;
        String str108;
        String str109;
        String str110;
        NetworkUtils.DNS dns5;
        String str111;
        Response response15;
        String str112;
        String str113;
        long j37;
        DownloadReport downloadReport6;
        String str114;
        String str115;
        DownloadGlobalStrategy.StrategyInfo strategyInfo7;
        String str116;
        Response response16;
        boolean z38;
        int i48;
        String str117;
        int i49;
        String str118;
        String str119;
        ResumeTransfer resumeTransfer7;
        long j38;
        boolean z39;
        HttpResponse httpResponse12;
        Throwable th9;
        String str120;
        String str121;
        String str122;
        long j39;
        String str123;
        int i56;
        String str124;
        String str125;
        NetworkUtils.DNS dns6;
        String str126;
        Response response17;
        String str127;
        String str128;
        String str129;
        DownloadReport downloadReport7;
        String str130;
        String str131;
        String str132;
        DownloadGlobalStrategy.StrategyInfo strategyInfo8;
        String str133;
        Response response18;
        boolean z46;
        ThreadPool.JobContext jobContext5 = jobContext;
        DownloadResult downloadResult5 = downloadResult;
        int i57 = 1;
        int generateRandomId = DownloadTask.TaskHelper.generateRandomId(getUrl(), downloadResult5);
        boolean isSdCardHasEnoughCapability = SDCardUtil.isSdCardHasEnoughCapability();
        int i58 = 0;
        long j46 = 0;
        while (!jobContext.isCancelled()) {
            if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                if (i58 == this.mAttemptTotalCount - i57) {
                    downloadResult.getStatus().setFailed(6);
                    return;
                } else {
                    try {
                        LockMethodProxy.sleep(1000L);
                    } catch (Exception unused) {
                        QDLog.d(QDLog.TAG_DOWNLOAD, "no network sleep interruptted!");
                    }
                }
            }
            if (!isSdCardHasEnoughCapability) {
                downloadResult.getStatus().setFailed(2);
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            DownloadReport downloadReport8 = new DownloadReport();
            downloadReport8.f99895id = generateRandomId;
            downloadReport8.url = getUrl();
            downloadReport8.domain = getDomain();
            downloadReport8.startTime = System.currentTimeMillis();
            this.request = null;
            this.okRequestBuilder = null;
            long currentTimeMillis = System.currentTimeMillis();
            try {
            } catch (UnknownHostException e16) {
                e = e16;
            }
            if (setStrategy(getCurrAttemptCount())) {
                e = null;
                i3 = generateRandomId;
                ?? r122 = ", dns=";
                String str134 = "http1.1";
                z16 = isSdCardHasEnoughCapability;
                ?? r133 = ", protocol=";
                String str135 = " , requestHttp2=";
                String str136 = ", size=";
                String str137 = ", contentLength=";
                String str138 = ", totalDuration=";
                String str139 = ", duration=";
                try {
                    try {
                        if (e == null) {
                            try {
                                downloadResult.reset();
                                requestOptions = DownloadTask.sRequestOptions.get();
                                requestOptions.allowProxy = this.mAllowProxy;
                                requestOptions.apnProxy = this.mAPNProxy;
                                DownloadTask.DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
                                if (downloadTaskHandler != null) {
                                    try {
                                        customProxy = downloadTaskHandler.getCustomProxy();
                                    } catch (Throwable th10) {
                                        th5 = th10;
                                        downloadReport = downloadReport8;
                                        j3 = uptimeMillis;
                                        i16 = i58;
                                        str = " , requestHttp2=";
                                        str2 = "https";
                                        str3 = ", dns=";
                                        str4 = ", protocol=";
                                        str5 = ",";
                                        str6 = ", remoteAddress=";
                                        j16 = j46;
                                        str7 = QDLog.TAG_DOWNLOAD_RESULT;
                                        str8 = ", localAddress=";
                                        str9 = ", redirectURI=";
                                        str10 = ", contentType=";
                                        response = null;
                                        httpResponse = null;
                                        i17 = 0;
                                        str11 = QDLog.TAG_DOWNLOAD;
                                        httpContext = null;
                                        str90 = str10;
                                        QDLog.e(str11, "", th5);
                                        downloadResult.getStatus().setFailed(th5);
                                        str117 = this.mRealUrl;
                                        str93 = "";
                                        if (str117 != null) {
                                        }
                                        i49 = i16;
                                        int i59 = i49 + 1;
                                        String str140 = str11;
                                        downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                        NetworkUtils.DNS dns7 = NetworkStatus.getInstance(this.mContext).getDNS();
                                        DownloadGlobalStrategy.StrategyInfo strategyInfo9 = this.pCurrStrategyInfo;
                                        if (strategyInfo9 != null) {
                                        }
                                        String parserHttpHeaderInfo = parserHttpHeaderInfo(this.request, httpResponse, response);
                                        if (httpContext == null) {
                                        }
                                        downloadResult.getContent().redirectUrl = str118;
                                        Throwable th11 = th5;
                                        String str141 = str118;
                                        this.connect_time = 0L;
                                        this.connect_retry = 0;
                                        this.exe_time = 0L;
                                        this.exe_retry = 0;
                                        if (downloadResult.getStatus().isSucceed()) {
                                        }
                                        resumeTransfer7.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse, response);
                                        if (jobContext.isCancelled()) {
                                        }
                                        if (this.mIsHttp2) {
                                        }
                                        i58 = i59;
                                        j46 = j38;
                                        if (canAttempt()) {
                                        }
                                    }
                                } else {
                                    customProxy = null;
                                }
                                requestOptions.mobileProxy = customProxy;
                                downloadReport8.currAttempCount = i58;
                                downloadReport8.refer = this.mRefer;
                                this.mRealUrl = prepareUrl(getUrl());
                                isIpV6Stack = Config.isIpV6Stack();
                                enableIpv6Debug = enableIpv6Debug();
                                try {
                                } catch (Throwable th12) {
                                    th = th12;
                                    downloadReport = downloadReport8;
                                    i16 = i58;
                                    str = " , requestHttp2=";
                                    str2 = "https";
                                    str3 = ", dns=";
                                    str4 = ", protocol=";
                                    str5 = ",";
                                    str6 = ", remoteAddress=";
                                    str7 = QDLog.TAG_DOWNLOAD_RESULT;
                                    str8 = ", localAddress=";
                                    str9 = ", redirectURI=";
                                    str10 = ", contentType=";
                                    j3 = uptimeMillis;
                                }
                            } catch (Throwable th13) {
                                th = th13;
                                downloadReport = downloadReport8;
                                j3 = uptimeMillis;
                                i16 = i58;
                                str = " , requestHttp2=";
                                str2 = "https";
                                str3 = ", dns=";
                                str4 = ", protocol=";
                                str5 = ",";
                                str6 = ", remoteAddress=";
                                str7 = QDLog.TAG_DOWNLOAD_RESULT;
                                str8 = ", localAddress=";
                                str9 = ", redirectURI=";
                                str10 = ", contentType=";
                            }
                            if (requestOptions.mobileProxy == null) {
                                try {
                                } catch (Throwable th14) {
                                    th5 = th14;
                                    downloadReport = downloadReport8;
                                    i16 = i58;
                                    str = " , requestHttp2=";
                                    str2 = "https";
                                    str3 = ", dns=";
                                    str4 = ", protocol=";
                                    str5 = ",";
                                    str6 = ", remoteAddress=";
                                    j16 = j46;
                                    str7 = QDLog.TAG_DOWNLOAD_RESULT;
                                    str8 = ", localAddress=";
                                    str9 = ", redirectURI=";
                                    str10 = ", contentType=";
                                    j3 = uptimeMillis;
                                }
                                if ((!this.mRealUrl.startsWith("https") || this.mIsHttp2) && (strategyInfo = this.pCurrStrategyInfo) != null && strategyInfo.getIPInfo() != null && !TextUtils.isEmpty(this.pCurrStrategyInfo.getIPInfo().f99897ip)) {
                                    String str142 = this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                    String domain = getDomain();
                                    int count = Utils.count(str142, ':');
                                    if (isIpV6Stack) {
                                        i18 = i58;
                                        if (count < 2 && enableIpv6Debug) {
                                            str142 = "240e:ff:f040:28::23";
                                        }
                                        if (Utils.count(str142, ':') >= 2) {
                                            int i65 = this.mOrigPort;
                                            if (i65 > 0) {
                                                this.pCurrStrategyInfo.getIPInfo().port = i65;
                                            } else {
                                                i65 = this.pCurrStrategyInfo.getIPInfo().port;
                                            }
                                            if (!Utils.isPortValid(i65)) {
                                                i65 = 80;
                                            }
                                            StringBuilder sb6 = new StringBuilder();
                                            str5 = ",";
                                            sb6.append("[");
                                            sb6.append(str142);
                                            sb6.append("]:");
                                            sb6.append(i65);
                                            str12 = sb6.toString();
                                            String str143 = this.mDomainWithPort;
                                            if (str143 != null) {
                                                this.mRealUrl = this.mRealUrl.replaceFirst(str143, str12);
                                            }
                                        } else {
                                            str5 = ",";
                                            if (Config.getNetworkStackType() == 3) {
                                                DownloadGlobalStrategy.StrategyInfo strategyInfo10 = this.pCurrStrategyInfo;
                                                if (strategyInfo10.f99899id != DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.f99899id) {
                                                    int i66 = this.mOrigPort;
                                                    if (i66 > 0) {
                                                        strategyInfo10.getIPInfo().port = i66;
                                                    } else {
                                                        i66 = strategyInfo10.getIPInfo().port;
                                                    }
                                                    if (!Utils.isPortValid(i66)) {
                                                        i66 = 80;
                                                    }
                                                    str12 = str142 + ":" + i66;
                                                    String str144 = this.mDomainWithPort;
                                                    if (str144 != null) {
                                                        this.mRealUrl = this.mRealUrl.replaceFirst(str144, str12);
                                                    }
                                                }
                                            }
                                            str12 = domain;
                                        }
                                        downloadReport8.strategyInfo = this.pCurrStrategyInfo.toString();
                                        if (QDLog.isDebugEnable()) {
                                        }
                                    } else {
                                        i18 = i58;
                                        if (count < 2) {
                                            try {
                                                int i67 = this.mOrigPort;
                                                if (i67 > 0) {
                                                    this.pCurrStrategyInfo.getIPInfo().port = i67;
                                                } else {
                                                    i67 = this.pCurrStrategyInfo.getIPInfo().port;
                                                }
                                                if (!Utils.isPortValid(i67)) {
                                                    i67 = 80;
                                                }
                                                str12 = str142 + ":" + i67;
                                                String str145 = this.mDomainWithPort;
                                                if (str145 != null) {
                                                    this.mRealUrl = this.mRealUrl.replaceFirst(str145, str12);
                                                }
                                                str5 = ",";
                                                downloadReport8.strategyInfo = this.pCurrStrategyInfo.toString();
                                                if (QDLog.isDebugEnable()) {
                                                    try {
                                                        sb5 = new StringBuilder();
                                                        sb5.append("downloader strategy run: ");
                                                        sb5.append(downloadReport8.strategyInfo);
                                                        sb5.append(" domain:");
                                                        sb5.append(str12);
                                                        sb5.append(" url:");
                                                        sb5.append(getUrl());
                                                        sb5.append(" threadId:");
                                                        str13 = ", remoteAddress=";
                                                    } catch (Throwable th15) {
                                                        th5 = th15;
                                                        downloadReport = downloadReport8;
                                                        str = " , requestHttp2=";
                                                        str2 = "https";
                                                        str3 = ", dns=";
                                                        str4 = ", protocol=";
                                                        str6 = ", remoteAddress=";
                                                        j16 = j46;
                                                        str7 = QDLog.TAG_DOWNLOAD_RESULT;
                                                        str8 = ", localAddress=";
                                                        str9 = ", redirectURI=";
                                                        str10 = ", contentType=";
                                                        j3 = uptimeMillis;
                                                        i16 = i18;
                                                        response = null;
                                                        httpResponse = null;
                                                        i17 = 0;
                                                        str11 = QDLog.TAG_DOWNLOAD;
                                                        httpContext = null;
                                                        str90 = str10;
                                                        QDLog.e(str11, "", th5);
                                                        downloadResult.getStatus().setFailed(th5);
                                                        str117 = this.mRealUrl;
                                                        str93 = "";
                                                        if (str117 != null) {
                                                        }
                                                        i49 = i16;
                                                        int i592 = i49 + 1;
                                                        String str1402 = str11;
                                                        downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                        NetworkUtils.DNS dns72 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo92 = this.pCurrStrategyInfo;
                                                        if (strategyInfo92 != null) {
                                                        }
                                                        String parserHttpHeaderInfo2 = parserHttpHeaderInfo(this.request, httpResponse, response);
                                                        if (httpContext == null) {
                                                        }
                                                        downloadResult.getContent().redirectUrl = str118;
                                                        Throwable th112 = th5;
                                                        String str1412 = str118;
                                                        this.connect_time = 0L;
                                                        this.connect_retry = 0;
                                                        this.exe_time = 0L;
                                                        this.exe_retry = 0;
                                                        if (downloadResult.getStatus().isSucceed()) {
                                                        }
                                                        resumeTransfer7.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse, response);
                                                        if (jobContext.isCancelled()) {
                                                        }
                                                        if (this.mIsHttp2) {
                                                        }
                                                        i58 = i592;
                                                        j46 = j38;
                                                        if (canAttempt()) {
                                                        }
                                                    }
                                                    try {
                                                        sb5.append(Thread.currentThread().getId());
                                                        QDLog.d(QDLog.TAG_DOWNLOAD, sb5.toString());
                                                    } catch (Throwable th16) {
                                                        th5 = th16;
                                                        downloadReport = downloadReport8;
                                                        str = " , requestHttp2=";
                                                        str2 = "https";
                                                        str3 = ", dns=";
                                                        str4 = ", protocol=";
                                                        j16 = j46;
                                                        str7 = QDLog.TAG_DOWNLOAD_RESULT;
                                                        str8 = ", localAddress=";
                                                        str9 = ", redirectURI=";
                                                        str10 = ", contentType=";
                                                        j3 = uptimeMillis;
                                                        i16 = i18;
                                                        str6 = str13;
                                                        response = null;
                                                        httpResponse = null;
                                                        i17 = 0;
                                                        str11 = QDLog.TAG_DOWNLOAD;
                                                        httpContext = null;
                                                        str90 = str10;
                                                        QDLog.e(str11, "", th5);
                                                        downloadResult.getStatus().setFailed(th5);
                                                        str117 = this.mRealUrl;
                                                        str93 = "";
                                                        if (str117 != null) {
                                                        }
                                                        i49 = i16;
                                                        int i5922 = i49 + 1;
                                                        String str14022 = str11;
                                                        downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                        NetworkUtils.DNS dns722 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo922 = this.pCurrStrategyInfo;
                                                        if (strategyInfo922 != null) {
                                                        }
                                                        String parserHttpHeaderInfo22 = parserHttpHeaderInfo(this.request, httpResponse, response);
                                                        if (httpContext == null) {
                                                        }
                                                        downloadResult.getContent().redirectUrl = str118;
                                                        Throwable th1122 = th5;
                                                        String str14122 = str118;
                                                        this.connect_time = 0L;
                                                        this.connect_retry = 0;
                                                        this.exe_time = 0L;
                                                        this.exe_retry = 0;
                                                        if (downloadResult.getStatus().isSucceed()) {
                                                        }
                                                        resumeTransfer7.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse, response);
                                                        if (jobContext.isCancelled()) {
                                                        }
                                                        if (this.mIsHttp2) {
                                                        }
                                                        i58 = i5922;
                                                        j46 = j38;
                                                        if (canAttempt()) {
                                                        }
                                                    }
                                                } else {
                                                    str13 = ", remoteAddress=";
                                                }
                                            } catch (Throwable th17) {
                                                th5 = th17;
                                                downloadReport = downloadReport8;
                                                str = " , requestHttp2=";
                                                str2 = "https";
                                                str3 = ", dns=";
                                                str4 = ", protocol=";
                                                str5 = ",";
                                                str6 = ", remoteAddress=";
                                                j16 = j46;
                                                str7 = QDLog.TAG_DOWNLOAD_RESULT;
                                                str8 = ", localAddress=";
                                                str9 = ", redirectURI=";
                                                str10 = ", contentType=";
                                                j3 = uptimeMillis;
                                                i16 = i18;
                                                response = null;
                                                httpResponse = null;
                                                i17 = 0;
                                                str11 = QDLog.TAG_DOWNLOAD;
                                                httpContext = null;
                                                str90 = str10;
                                                QDLog.e(str11, "", th5);
                                                downloadResult.getStatus().setFailed(th5);
                                                str117 = this.mRealUrl;
                                                str93 = "";
                                                if (str117 != null) {
                                                }
                                                i49 = i16;
                                                int i59222 = i49 + 1;
                                                String str140222 = str11;
                                                downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                                downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                NetworkUtils.DNS dns7222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                DownloadGlobalStrategy.StrategyInfo strategyInfo9222 = this.pCurrStrategyInfo;
                                                if (strategyInfo9222 != null) {
                                                }
                                                String parserHttpHeaderInfo222 = parserHttpHeaderInfo(this.request, httpResponse, response);
                                                if (httpContext == null) {
                                                }
                                                downloadResult.getContent().redirectUrl = str118;
                                                Throwable th11222 = th5;
                                                String str141222 = str118;
                                                this.connect_time = 0L;
                                                this.connect_retry = 0;
                                                this.exe_time = 0L;
                                                this.exe_retry = 0;
                                                if (downloadResult.getStatus().isSucceed()) {
                                                }
                                                resumeTransfer7.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse, response);
                                                if (jobContext.isCancelled()) {
                                                }
                                                if (this.mIsHttp2) {
                                                }
                                                i58 = i59222;
                                                j46 = j38;
                                                if (canAttempt()) {
                                                }
                                            }
                                        } else {
                                            str5 = ",";
                                            str12 = domain;
                                            downloadReport8.strategyInfo = this.pCurrStrategyInfo.toString();
                                            if (QDLog.isDebugEnable()) {
                                            }
                                        }
                                    }
                                    strategyInfo2 = this.pCurrStrategyInfo;
                                    if (strategyInfo2 != null) {
                                        downloadReport8.strategyInfo = strategyInfo2.toString();
                                        downloadReport8.strategyId = this.pCurrStrategyInfo.f99899id;
                                    }
                                    if (!this.mIsHttp2 && !isIpV6Stack) {
                                        this.okRequestBuilder = HttpUtil.createOkHttpGet(this.mContext, getUrl(), getDomain(), this.mRealUrl, this.mRefer);
                                    } else {
                                        this.request = HttpUtil.createHttpGet(this.mContext, getUrl(), getDomain(), this.mRealUrl, this.mRefer, requestOptions);
                                    }
                                    resumeTransfer = this.pResumeTransfer;
                                    if (resumeTransfer != null) {
                                        resumeTransfer.prepareRequest(this.request, this.okRequestBuilder, getUrl(), getDomain());
                                    }
                                    prepareRequest(getUrl(), getDomain(), this.request, this.okRequestBuilder);
                                    downloadReport = downloadReport8;
                                    ?? r142 = uptimeMillis;
                                    i16 = i18;
                                    applyKeepAliveStrategy(getUrl(), getDomain(), this.request, this.okRequestBuilder, requestOptions);
                                    ?? currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                    this.send_req_time = 0L;
                                    long uptimeMillis2 = SystemClock.uptimeMillis();
                                    if (this.request == null) {
                                        try {
                                            if (this.pHttpClient == null) {
                                                this.pHttpClient = HttpUtil.CreateDefaultHttpClient();
                                            }
                                            createHttpContext = HttpUtil.createHttpContext();
                                        } catch (Throwable th18) {
                                            th = th18;
                                            httpContext = null;
                                            httpResponse2 = null;
                                        }
                                        try {
                                            execute = this.pHttpClient.execute(this.request, createHttpContext);
                                            httpContext = createHttpContext;
                                            response2 = null;
                                        } catch (Throwable th19) {
                                            th = th19;
                                            httpContext = createHttpContext;
                                            httpResponse2 = null;
                                            j16 = currentTimeMillis2;
                                            j3 = r142;
                                            str7 = QDLog.TAG_DOWNLOAD_RESULT;
                                            str8 = ", localAddress=";
                                            str9 = ", redirectURI=";
                                            str2 = "https";
                                            str6 = str13;
                                            i17 = 0;
                                            th5 = th;
                                            str = " , requestHttp2=";
                                            httpResponse = httpResponse2;
                                            str3 = ", dns=";
                                            str4 = ", protocol=";
                                            str10 = ", contentType=";
                                            str11 = QDLog.TAG_DOWNLOAD;
                                            response = httpResponse2;
                                            str90 = str10;
                                            QDLog.e(str11, "", th5);
                                            downloadResult.getStatus().setFailed(th5);
                                            str117 = this.mRealUrl;
                                            str93 = "";
                                            if (str117 != null) {
                                            }
                                            i49 = i16;
                                            int i592222 = i49 + 1;
                                            String str1402222 = str11;
                                            downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                            NetworkUtils.DNS dns72222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                            DownloadGlobalStrategy.StrategyInfo strategyInfo92222 = this.pCurrStrategyInfo;
                                            if (strategyInfo92222 != null) {
                                            }
                                            String parserHttpHeaderInfo2222 = parserHttpHeaderInfo(this.request, httpResponse, response);
                                            if (httpContext == null) {
                                            }
                                            downloadResult.getContent().redirectUrl = str118;
                                            Throwable th112222 = th5;
                                            String str1412222 = str118;
                                            this.connect_time = 0L;
                                            this.connect_retry = 0;
                                            this.exe_time = 0L;
                                            this.exe_retry = 0;
                                            if (downloadResult.getStatus().isSucceed()) {
                                            }
                                            resumeTransfer7.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse, response);
                                            if (jobContext.isCancelled()) {
                                            }
                                            if (this.mIsHttp2) {
                                            }
                                            i58 = i592222;
                                            j46 = j38;
                                            if (canAttempt()) {
                                            }
                                        }
                                    } else {
                                        Request.Builder builder = this.okRequestBuilder;
                                        if (builder != null) {
                                            Call newCall = this.pokHttpClient.newCall(builder.build());
                                            this.okRequestCall = newCall;
                                            response2 = newCall.execute();
                                            httpContext = null;
                                            execute = null;
                                        } else {
                                            httpContext = null;
                                            response2 = null;
                                            execute = null;
                                        }
                                    }
                                    this.send_req_time = SystemClock.uptimeMillis() - uptimeMillis2;
                                    if (execute != null && response2 == null) {
                                        try {
                                            downloadResult.getStatus().setFailed(3);
                                            j17 = currentTimeMillis2;
                                            str70 = ", dns=";
                                            str62 = QDLog.TAG_DOWNLOAD_RESULT;
                                            str63 = ", localAddress=";
                                            str64 = ", redirectURI=";
                                            str71 = ", contentType=";
                                            str65 = ", ";
                                            str67 = str138;
                                            i38 = 0;
                                            r122 = execute;
                                            currentTimeMillis2 = " , requestHttp2=";
                                            str135 = ", protocol=";
                                            execute = str139;
                                            r133 = response2;
                                            response2 = str13;
                                            httpContext2 = httpContext;
                                            j27 = r142;
                                            r142 = str137;
                                            r56 = response2;
                                            r65 = execute;
                                            str75 = currentTimeMillis2;
                                            httpResponse8 = r122;
                                            response11 = r133;
                                            str74 = r142;
                                        } catch (Throwable th20) {
                                            th = th20;
                                            j16 = currentTimeMillis2;
                                            str3 = r122;
                                            j3 = r142;
                                            str7 = QDLog.TAG_DOWNLOAD_RESULT;
                                            str8 = ", localAddress=";
                                            str9 = ", redirectURI=";
                                            str10 = ", contentType=";
                                            str2 = "https";
                                            i17 = 0;
                                            response10 = response2;
                                            httpResponse7 = execute;
                                            str73 = r133;
                                            th5 = th;
                                            httpResponse = httpResponse7;
                                            str = str135;
                                            str4 = str73;
                                            str11 = QDLog.TAG_DOWNLOAD;
                                            response = response10;
                                            str6 = str13;
                                            str90 = str10;
                                            QDLog.e(str11, "", th5);
                                            downloadResult.getStatus().setFailed(th5);
                                            str117 = this.mRealUrl;
                                            str93 = "";
                                            if (str117 != null) {
                                            }
                                            i49 = i16;
                                            int i5922222 = i49 + 1;
                                            String str14022222 = str11;
                                            downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                            NetworkUtils.DNS dns722222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                            DownloadGlobalStrategy.StrategyInfo strategyInfo922222 = this.pCurrStrategyInfo;
                                            if (strategyInfo922222 != null) {
                                            }
                                            String parserHttpHeaderInfo22222 = parserHttpHeaderInfo(this.request, httpResponse, response);
                                            if (httpContext == null) {
                                            }
                                            downloadResult.getContent().redirectUrl = str118;
                                            Throwable th1122222 = th5;
                                            String str14122222 = str118;
                                            this.connect_time = 0L;
                                            this.connect_retry = 0;
                                            this.exe_time = 0L;
                                            this.exe_retry = 0;
                                            if (downloadResult.getStatus().isSucceed()) {
                                            }
                                            resumeTransfer7.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse, response);
                                            if (jobContext.isCancelled()) {
                                            }
                                            if (this.mIsHttp2) {
                                            }
                                            i58 = i5922222;
                                            j46 = j38;
                                            if (canAttempt()) {
                                            }
                                        }
                                    } else {
                                        if (execute == null && execute.getStatusLine() != null) {
                                            code = execute.getStatusLine().getStatusCode();
                                        } else if (response2 == null) {
                                            code = response2.code();
                                        } else {
                                            i19 = 0;
                                            downloadResult.getStatus().httpStatus = i19;
                                            if (200 == i19 && 206 != i19) {
                                                if (416 == i19) {
                                                    try {
                                                        removeHttpParam("Range");
                                                        downloadResult.getStatus().setFailed(7);
                                                    } catch (Throwable th21) {
                                                        th = th21;
                                                        i17 = i19;
                                                        j16 = currentTimeMillis2;
                                                        str3 = ", dns=";
                                                        j3 = r142;
                                                        str7 = QDLog.TAG_DOWNLOAD_RESULT;
                                                        str8 = ", localAddress=";
                                                        str9 = ", redirectURI=";
                                                        str10 = ", contentType=";
                                                        str2 = "https";
                                                        response10 = response2;
                                                        httpResponse7 = execute;
                                                        str73 = r133;
                                                        th5 = th;
                                                        httpResponse = httpResponse7;
                                                        str = str135;
                                                        str4 = str73;
                                                        str11 = QDLog.TAG_DOWNLOAD;
                                                        response = response10;
                                                        str6 = str13;
                                                        str90 = str10;
                                                        QDLog.e(str11, "", th5);
                                                        downloadResult.getStatus().setFailed(th5);
                                                        str117 = this.mRealUrl;
                                                        str93 = "";
                                                        if (str117 != null) {
                                                        }
                                                        i49 = i16;
                                                        int i59222222 = i49 + 1;
                                                        String str140222222 = str11;
                                                        downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                        NetworkUtils.DNS dns7222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo9222222 = this.pCurrStrategyInfo;
                                                        if (strategyInfo9222222 != null) {
                                                        }
                                                        String parserHttpHeaderInfo222222 = parserHttpHeaderInfo(this.request, httpResponse, response);
                                                        if (httpContext == null) {
                                                        }
                                                        downloadResult.getContent().redirectUrl = str118;
                                                        Throwable th11222222 = th5;
                                                        String str141222222 = str118;
                                                        this.connect_time = 0L;
                                                        this.connect_retry = 0;
                                                        this.exe_time = 0L;
                                                        this.exe_retry = 0;
                                                        if (downloadResult.getStatus().isSucceed()) {
                                                        }
                                                        resumeTransfer7.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse, response);
                                                        if (jobContext.isCancelled()) {
                                                        }
                                                        if (this.mIsHttp2) {
                                                        }
                                                        i58 = i59222222;
                                                        j46 = j38;
                                                        if (canAttempt()) {
                                                        }
                                                    }
                                                } else {
                                                    downloadResult.getStatus().setFailed(3);
                                                }
                                                ResumeTransfer resumeTransfer8 = this.pResumeTransfer;
                                                if (resumeTransfer8 != null) {
                                                    resumeTransfer8.onDownloadResult(getUrl(), true);
                                                }
                                                i26 = i19;
                                                j17 = currentTimeMillis2;
                                                str70 = ", dns=";
                                                str62 = QDLog.TAG_DOWNLOAD_RESULT;
                                                str63 = ", localAddress=";
                                                str64 = ", redirectURI=";
                                                str71 = ", contentType=";
                                                str65 = ", ";
                                                str67 = str138;
                                                httpResponse6 = execute;
                                                str72 = " , requestHttp2=";
                                                str135 = ", protocol=";
                                                str68 = str139;
                                                response9 = response2;
                                                str69 = str13;
                                                httpContext2 = httpContext;
                                                j27 = r142;
                                                str66 = str137;
                                            } else {
                                                i26 = i19;
                                                HttpContext httpContext4 = httpContext;
                                                j17 = currentTimeMillis2;
                                                Response response19 = response2;
                                                HttpResponse httpResponse13 = execute;
                                                if (handleResponse(execute, response2, downloadResult, jobContext, i26)) {
                                                    j27 = r142;
                                                    str62 = QDLog.TAG_DOWNLOAD_RESULT;
                                                    str63 = ", localAddress=";
                                                    str64 = ", redirectURI=";
                                                    str65 = ", ";
                                                    str66 = str137;
                                                    str67 = str138;
                                                    str68 = str139;
                                                    str69 = str13;
                                                    httpContext2 = httpContext4;
                                                    str70 = ", dns=";
                                                    httpResponse6 = httpResponse13;
                                                    str71 = ", contentType=";
                                                    str72 = " , requestHttp2=";
                                                    str135 = ", protocol=";
                                                    response9 = response19;
                                                } else {
                                                    try {
                                                        downloadResult.getStatus().setSucceed();
                                                    } catch (Throwable th22) {
                                                        str6 = str13;
                                                        str3 = ", dns=";
                                                        str = " , requestHttp2=";
                                                        str4 = ", protocol=";
                                                        th5 = th22;
                                                        j3 = r142;
                                                        httpResponse = httpResponse13;
                                                        response = response19;
                                                        httpContext = httpContext4;
                                                        i17 = i26;
                                                        str7 = QDLog.TAG_DOWNLOAD_RESULT;
                                                        str8 = ", localAddress=";
                                                        str9 = ", redirectURI=";
                                                        str10 = ", contentType=";
                                                        str2 = "https";
                                                        str11 = QDLog.TAG_DOWNLOAD;
                                                        j16 = j17;
                                                    }
                                                    if (downloadResult.getContent().noCache) {
                                                        try {
                                                            retcode = getRetcode(httpResponse13, response19);
                                                            downloadResult.getContent().retCode = retcode;
                                                        } catch (Throwable th23) {
                                                            str4 = ", protocol=";
                                                            str6 = str13;
                                                            httpResponse = httpResponse13;
                                                            th5 = th23;
                                                            str = " , requestHttp2=";
                                                            response = response19;
                                                            j3 = r142;
                                                            httpContext = httpContext4;
                                                            i17 = i26;
                                                            str8 = ", localAddress=";
                                                            str9 = ", redirectURI=";
                                                            str10 = ", contentType=";
                                                            str2 = "https";
                                                            str11 = QDLog.TAG_DOWNLOAD;
                                                            j16 = j17;
                                                            str3 = ", dns=";
                                                            str7 = QDLog.TAG_DOWNLOAD_RESULT;
                                                        }
                                                        if (Config.canRetCodeRetry(retcode)) {
                                                            int i68 = i16 + 1;
                                                            downloadResult.getProcess().setDuration(r142, SystemClock.uptimeMillis());
                                                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                            NetworkUtils.DNS dns8 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                            DownloadGlobalStrategy.StrategyInfo strategyInfo11 = this.pCurrStrategyInfo;
                                                            String str146 = (strategyInfo11 == null || strategyInfo11.getIPInfo() == null) ? null : this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                                            String parserHttpHeaderInfo3 = parserHttpHeaderInfo(this.request, httpResponse13, response19);
                                                            if (httpContext4 != null) {
                                                                try {
                                                                    str45 = (String) httpContext4.getAttribute("RedirectURI");
                                                                } catch (Exception unused2) {
                                                                    str45 = "";
                                                                }
                                                                try {
                                                                    str46 = (String) httpContext4.getAttribute("RealRemoteAddr");
                                                                } catch (Exception unused3) {
                                                                    str46 = "";
                                                                }
                                                            } else {
                                                                str45 = "";
                                                                str46 = str45;
                                                            }
                                                            downloadResult.getContent().redirectUrl = str45;
                                                            this.connect_time = 0L;
                                                            this.connect_retry = 0;
                                                            this.exe_time = 0L;
                                                            this.exe_retry = 0;
                                                            if ((!downloadResult.getStatus().isSucceed() || jobContext.isCancelled()) && (resumeTransfer4 = this.pResumeTransfer) != null) {
                                                                resumeTransfer4.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse13, response19);
                                                            }
                                                            if (jobContext.isCancelled()) {
                                                                jobContext2 = jobContext;
                                                                downloadResult2 = downloadResult;
                                                                i36 = i68;
                                                                j26 = j17;
                                                            } else {
                                                                boolean isNetworkAvailable = NetworkUtils.isNetworkAvailable(this.mContext);
                                                                if (!downloadResult.getStatus().isSucceed()) {
                                                                    ?? sb7 = new StringBuilder();
                                                                    sb7.append("Downloader, fail to download:");
                                                                    sb7.append(getUrl());
                                                                    sb7.append(" , requestHttp2=");
                                                                    sb7.append(this.mIsHttp2);
                                                                    sb7.append(", protocol=");
                                                                    if (this.mIsHttp2 && response19 != null && response19.protocol() != null) {
                                                                        str134 = response19.protocol().getProtocol();
                                                                    }
                                                                    sb7.append(str134);
                                                                    sb7.append(", dns=");
                                                                    sb7.append(dns8);
                                                                    sb7.append(str13);
                                                                    sb7.append(str146);
                                                                    sb7.append(", localAddress=");
                                                                    sb7.append(null);
                                                                    sb7.append(", thread=");
                                                                    sb7.append(Thread.currentThread().getId());
                                                                    sb7.append(", apn=");
                                                                    sb7.append(NetworkManager.getApnValue());
                                                                    sb7.append(", allowProxy=");
                                                                    sb7.append(this.mAllowProxy);
                                                                    sb7.append(", apnProxy=");
                                                                    sb7.append(this.mAPNProxy);
                                                                    sb7.append(", useProxy=");
                                                                    sb7.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                                    sb7.append(", netAvailable=");
                                                                    sb7.append(isNetworkAvailable);
                                                                    sb7.append(", realRemoteAddr=");
                                                                    sb7.append(str46);
                                                                    sb7.append(", IpStack=");
                                                                    sb7.append(Config.getNetworkStackType());
                                                                    sb7.append(", contentType=");
                                                                    sb7.append(downloadResult.getContent().type);
                                                                    sb7.append(str139);
                                                                    sb7.append(downloadResult.getProcess().duration);
                                                                    sb7.append(str138);
                                                                    sb7.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                                    sb7.append(str137);
                                                                    sb7.append(downloadResult.getContent().length);
                                                                    sb7.append(str136);
                                                                    sb7.append(downloadResult.getContent().size);
                                                                    sb7.append(", realsize=");
                                                                    sb7.append(downloadResult.getContent().realsize);
                                                                    sb7.append(", retry=(");
                                                                    sb7.append(getCurrAttemptCount());
                                                                    String str147 = str5;
                                                                    sb7.append(str147);
                                                                    sb7.append(getTotalAttemptCount());
                                                                    sb7.append("), reason=");
                                                                    sb7.append(downloadResult.getStatus().getFailReason());
                                                                    sb7.append(", httpStatus=");
                                                                    sb7.append(i26);
                                                                    i36 = i68;
                                                                    sb7.append(", ");
                                                                    sb7.append(parserHttpHeaderInfo3);
                                                                    httpResponse5 = httpResponse13;
                                                                    sb7.append(", redirectURI=");
                                                                    sb7.append(str45);
                                                                    sb7.append(", ipUrl:");
                                                                    String str148 = this.mRealUrl;
                                                                    if (str148 != null) {
                                                                        str61 = str136;
                                                                        str148 = str148.substring(0, 30);
                                                                    } else {
                                                                        str61 = str136;
                                                                    }
                                                                    sb7.append(str148);
                                                                    sb7.append(", strategyId=");
                                                                    DownloadGlobalStrategy.StrategyInfo strategyInfo12 = this.pCurrStrategyInfo;
                                                                    sb7.append(strategyInfo12 != null ? strategyInfo12.f99899id : 0);
                                                                    sb7.append(", clientip=");
                                                                    sb7.append(downloadResult.getContent().clientip);
                                                                    sb7.append(", getIP=");
                                                                    sb7.append(j17);
                                                                    sb7.append(", connect:(");
                                                                    sb7.append(this.connect_time);
                                                                    sb7.append(str147);
                                                                    sb7.append(this.connect_retry);
                                                                    sb7.append("), exeReqest:(");
                                                                    sb7.append(this.exe_time);
                                                                    sb7.append(str147);
                                                                    sb7.append(this.exe_retry);
                                                                    sb7.append("), sendReq=");
                                                                    sb7.append(this.send_req_time);
                                                                    sb7.append(", recvData=");
                                                                    sb7.append(this.t_recv_data);
                                                                    sb7.append(", Concurrent:(");
                                                                    sb7.append(getTaskConcurrentCount());
                                                                    sb7.append("), mobileProxy=");
                                                                    DownloadTask.DownloadTaskHandler downloadTaskHandler2 = this.mDownloadTaskHandler;
                                                                    sb7.append(downloadTaskHandler2 != null ? downloadTaskHandler2.getCustomProxy() : null);
                                                                    String sb8 = sb7.toString();
                                                                    downloadReport.logInfo = sb8;
                                                                    QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb8, null);
                                                                    if (this.mRealUrl != null) {
                                                                        QDLog.d("FastDownloadTask", "fast force dns first is " + Config.isForceDNSFirst());
                                                                        CustomDnsResolve.setIPDirectEnable(getDomain(), Config.isForceDNSFirst());
                                                                    }
                                                                    dns3 = dns8;
                                                                    str53 = str45;
                                                                    z27 = isNetworkAvailable;
                                                                    str56 = ", ";
                                                                    response7 = response19;
                                                                    i37 = i26;
                                                                    str51 = ", contentType=";
                                                                    str49 = str61;
                                                                    str50 = str139;
                                                                    str54 = str46;
                                                                    downloadReport4 = downloadReport;
                                                                    str52 = ", redirectURI=";
                                                                    str47 = str137;
                                                                    str48 = str138;
                                                                    str55 = parserHttpHeaderInfo3;
                                                                } else {
                                                                    httpResponse5 = httpResponse13;
                                                                    str47 = str137;
                                                                    str48 = str138;
                                                                    String str149 = str13;
                                                                    String str150 = str45;
                                                                    z27 = isNetworkAvailable;
                                                                    str49 = str136;
                                                                    i36 = i68;
                                                                    str50 = str139;
                                                                    StringBuilder sb9 = new StringBuilder();
                                                                    sb9.append("Downloader, succeed to download:");
                                                                    sb9.append(getUrl());
                                                                    sb9.append(" , requestHttp2=");
                                                                    sb9.append(this.mIsHttp2);
                                                                    sb9.append(", protocol=");
                                                                    if (this.mIsHttp2 && response19 != null && response19.protocol() != null) {
                                                                        str134 = response19.protocol().getProtocol();
                                                                    }
                                                                    sb9.append(str134);
                                                                    sb9.append(", dns=");
                                                                    sb9.append(dns8);
                                                                    sb9.append(str149);
                                                                    sb9.append(str146);
                                                                    sb9.append(", localAddress=");
                                                                    sb9.append((String) null);
                                                                    sb9.append(", thread=");
                                                                    sb9.append(Thread.currentThread().getId());
                                                                    sb9.append(", apn=");
                                                                    sb9.append(NetworkManager.getApnValue());
                                                                    sb9.append(", allowProxy=");
                                                                    sb9.append(this.mAllowProxy);
                                                                    sb9.append(", apnProxy=");
                                                                    sb9.append(this.mAPNProxy);
                                                                    sb9.append(", useProxy=");
                                                                    sb9.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                                    sb9.append(", IpStack=");
                                                                    sb9.append(Config.getNetworkStackType());
                                                                    sb9.append(", realRemoteAddr=");
                                                                    sb9.append(str46);
                                                                    sb9.append(str50);
                                                                    sb9.append(downloadResult.getProcess().duration);
                                                                    sb9.append(str48);
                                                                    sb9.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                                    sb9.append(str47);
                                                                    sb9.append(downloadResult.getContent().length);
                                                                    sb9.append(str49);
                                                                    sb9.append(downloadResult.getContent().size);
                                                                    sb9.append(", realsize=");
                                                                    sb9.append(downloadResult.getContent().realsize);
                                                                    sb9.append(", retry=(");
                                                                    sb9.append(getCurrAttemptCount());
                                                                    String str151 = str5;
                                                                    sb9.append(str151);
                                                                    sb9.append(getTotalAttemptCount());
                                                                    sb9.append("), httpStatus=");
                                                                    i37 = i26;
                                                                    sb9.append(i37);
                                                                    sb9.append(", ");
                                                                    sb9.append(parserHttpHeaderInfo3);
                                                                    str51 = ", contentType=";
                                                                    sb9.append(str51);
                                                                    sb9.append(downloadResult.getContent().type);
                                                                    str52 = ", redirectURI=";
                                                                    sb9.append(str52);
                                                                    dns3 = dns8;
                                                                    str53 = str150;
                                                                    sb9.append(str53);
                                                                    response7 = response19;
                                                                    sb9.append(", ipUrl:");
                                                                    String str152 = this.mRealUrl;
                                                                    str54 = str46;
                                                                    if (str152 != null) {
                                                                        str55 = parserHttpHeaderInfo3;
                                                                        str152 = str152.substring(0, 30);
                                                                    } else {
                                                                        str55 = parserHttpHeaderInfo3;
                                                                    }
                                                                    sb9.append(str152);
                                                                    sb9.append(", strategyId=");
                                                                    DownloadGlobalStrategy.StrategyInfo strategyInfo13 = this.pCurrStrategyInfo;
                                                                    sb9.append(strategyInfo13 != null ? strategyInfo13.f99899id : 0);
                                                                    sb9.append(", clientip=");
                                                                    sb9.append(downloadResult.getContent().clientip);
                                                                    sb9.append(", getIP=");
                                                                    str56 = ", ";
                                                                    sb9.append(j17);
                                                                    sb9.append(", connect:(");
                                                                    j17 = j17;
                                                                    sb9.append(this.connect_time);
                                                                    sb9.append(str151);
                                                                    sb9.append(this.connect_retry);
                                                                    sb9.append("), exeReqest:(");
                                                                    sb9.append(this.exe_time);
                                                                    sb9.append(str151);
                                                                    sb9.append(this.exe_retry);
                                                                    sb9.append("), sendReq=");
                                                                    sb9.append(this.send_req_time);
                                                                    sb9.append(", recvData=");
                                                                    sb9.append(this.t_recv_data);
                                                                    sb9.append(", Concurrent:(");
                                                                    sb9.append(getTaskConcurrentCount());
                                                                    sb9.append("), mobileProxy=");
                                                                    DownloadTask.DownloadTaskHandler downloadTaskHandler3 = this.mDownloadTaskHandler;
                                                                    sb9.append(downloadTaskHandler3 != null ? downloadTaskHandler3.getCustomProxy() : null);
                                                                    String sb10 = sb9.toString();
                                                                    downloadReport4 = downloadReport;
                                                                    downloadReport4.logInfo = sb10;
                                                                    QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb10, null);
                                                                }
                                                                if (!z27) {
                                                                    this.mShouldReport = false;
                                                                }
                                                                DownloadResult.Status status = downloadResult.getStatus();
                                                                StringBuilder sb11 = new StringBuilder();
                                                                sb11.append(getUrl());
                                                                sb11.append(" sip=");
                                                                sb11.append(str146);
                                                                sb11.append(", client=");
                                                                sb11.append(downloadResult.getContent().clientip);
                                                                sb11.append(", ipType=");
                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo14 = this.pCurrStrategyInfo;
                                                                sb11.append(strategyInfo14 != null ? strategyInfo14.f99899id : 0);
                                                                sb11.append(", httpStatus=");
                                                                sb11.append(i37);
                                                                sb11.append(str51);
                                                                sb11.append(downloadResult.getContent().type);
                                                                sb11.append(str47);
                                                                sb11.append(downloadResult.getContent().length);
                                                                sb11.append(str49);
                                                                sb11.append(downloadResult.getContent().size);
                                                                sb11.append(str50);
                                                                sb11.append(downloadResult.getProcess().duration);
                                                                sb11.append(str48);
                                                                sb11.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                                if (TextUtils.isEmpty(str53)) {
                                                                    str57 = "";
                                                                } else {
                                                                    str57 = str52 + str53;
                                                                }
                                                                sb11.append(str57);
                                                                sb11.append(str56);
                                                                sb11.append(str55);
                                                                status.detailDownloadInfo = sb11.toString();
                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo15 = this.pCurrStrategyInfo;
                                                                if (strategyInfo15 == null || DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id != strategyInfo15.f99899id || this.pBackupIPConfigStrategy == null) {
                                                                    str58 = str54;
                                                                } else {
                                                                    try {
                                                                        if (!TextUtils.isEmpty(str54)) {
                                                                            str58 = str54;
                                                                            try {
                                                                                this.pBackupIPConfigStrategy.onIPAccessResult(getDomain(), str58, downloadResult.getStatus().isSucceed());
                                                                            } catch (Exception e17) {
                                                                                e = e17;
                                                                                str59 = QDLog.TAG_DOWNLOAD;
                                                                                QDLog.w(str59, "Strategy_BACKUPIP ", e);
                                                                                strategyInfo5 = this.pCurrStrategyInfo;
                                                                                if (strategyInfo5 != null) {
                                                                                    try {
                                                                                        if (TextUtils.isEmpty(str58)) {
                                                                                        }
                                                                                    } catch (Exception e18) {
                                                                                        QDLog.w(str59, "Strategy_DomainDirect ", e18);
                                                                                    }
                                                                                }
                                                                                if (z27) {
                                                                                }
                                                                                downloadReport4.endTime = System.currentTimeMillis();
                                                                                downloadReport4.fileSize = getContentLength();
                                                                                downloadReport4.response = httpResponse5;
                                                                                response8 = response7;
                                                                                downloadReport4.okResponse = response8;
                                                                                downloadReport4.httpStatus = i37;
                                                                                downloadReport4.exception = null;
                                                                                downloadReport4.dns = dns3 != null ? null : dns3.toString();
                                                                                downloadReport4.localAddress = null;
                                                                                downloadReport4.clientip = downloadResult.getContent().clientip;
                                                                                downloadReport4.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                                                downloadReport4.downloadTime = downloadResult.getProcess().duration;
                                                                                downloadReport4.t_wait = downloadReport4.totaltime - downloadResult.getProcess().duration;
                                                                                j26 = j17;
                                                                                downloadReport4.t_prepare = j26;
                                                                                downloadReport4.t_conn = this.connect_time;
                                                                                downloadReport4.t_recvrsp = this.send_req_time;
                                                                                downloadReport4.t_recvdata = this.t_recv_data;
                                                                                downloadReport4.t_process = 0L;
                                                                                downloadReport4.concurrent = getTaskConcurrentCount();
                                                                                downloadReport4.content_type = downloadResult.getContent().type;
                                                                                downloadReport4.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                                                downloadReport4.isHttp2 = this.mIsHttp2;
                                                                                String str153 = this.mRealUrl;
                                                                                downloadReport4.isHttps = str153 == null && str153.startsWith(str60);
                                                                                downloadReport4.isSucceed = downloadResult.getStatus().isSucceed();
                                                                                downloadReport4.downloadMode = Downloader.DownloadMode.FastMode.ordinal();
                                                                                if (response8 != null) {
                                                                                    downloadReport4.f99896protocol = response8.protocol().getProtocol();
                                                                                }
                                                                                downloadResult2 = downloadResult;
                                                                                downloadResult2.setReport(downloadReport4);
                                                                                jobContext2 = jobContext;
                                                                                if (downloadResult.getStatus().isSucceed()) {
                                                                                }
                                                                                if (!this.mIsHttp2) {
                                                                                }
                                                                                i58 = i36;
                                                                                j46 = j26;
                                                                                jobContext3 = jobContext2;
                                                                                downloadResult3 = downloadResult2;
                                                                                if (canAttempt()) {
                                                                                }
                                                                            }
                                                                        } else {
                                                                            str58 = str54;
                                                                            this.pBackupIPConfigStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                                        }
                                                                    } catch (Exception e19) {
                                                                        e = e19;
                                                                        str58 = str54;
                                                                    }
                                                                }
                                                                str59 = QDLog.TAG_DOWNLOAD;
                                                                strategyInfo5 = this.pCurrStrategyInfo;
                                                                if (strategyInfo5 != null && DownloadGlobalStrategy.Strategy_DomainDirect.f99899id == strategyInfo5.f99899id && this.pDirectIPConfigStrategy != null) {
                                                                    if (TextUtils.isEmpty(str58)) {
                                                                        this.pDirectIPConfigStrategy.onIPAccessResult(getDomain(), str58, downloadResult.getStatus().isSucceed());
                                                                    } else {
                                                                        this.pDirectIPConfigStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                                    }
                                                                }
                                                                if (z27) {
                                                                    str60 = "https";
                                                                } else {
                                                                    DownloadGlobalStrategy downloadGlobalStrategy = DownloadGlobalStrategy.getInstance(this.mContext);
                                                                    String str154 = this.mRealUrl;
                                                                    if (!this.mIsHttp2 || str154 == null) {
                                                                        str60 = "https";
                                                                    } else {
                                                                        str60 = "https";
                                                                        if (str154.startsWith(str60)) {
                                                                            z28 = true;
                                                                            downloadGlobalStrategy.reportHttps(str154, z28, downloadResult.getStatus().isSucceed());
                                                                        }
                                                                    }
                                                                    z28 = false;
                                                                    downloadGlobalStrategy.reportHttps(str154, z28, downloadResult.getStatus().isSucceed());
                                                                }
                                                                downloadReport4.endTime = System.currentTimeMillis();
                                                                downloadReport4.fileSize = getContentLength();
                                                                downloadReport4.response = httpResponse5;
                                                                response8 = response7;
                                                                downloadReport4.okResponse = response8;
                                                                downloadReport4.httpStatus = i37;
                                                                downloadReport4.exception = null;
                                                                downloadReport4.dns = dns3 != null ? null : dns3.toString();
                                                                downloadReport4.localAddress = null;
                                                                downloadReport4.clientip = downloadResult.getContent().clientip;
                                                                downloadReport4.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                                downloadReport4.downloadTime = downloadResult.getProcess().duration;
                                                                downloadReport4.t_wait = downloadReport4.totaltime - downloadResult.getProcess().duration;
                                                                j26 = j17;
                                                                downloadReport4.t_prepare = j26;
                                                                downloadReport4.t_conn = this.connect_time;
                                                                downloadReport4.t_recvrsp = this.send_req_time;
                                                                downloadReport4.t_recvdata = this.t_recv_data;
                                                                downloadReport4.t_process = 0L;
                                                                downloadReport4.concurrent = getTaskConcurrentCount();
                                                                downloadReport4.content_type = downloadResult.getContent().type;
                                                                downloadReport4.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                                downloadReport4.isHttp2 = this.mIsHttp2;
                                                                String str1532 = this.mRealUrl;
                                                                downloadReport4.isHttps = str1532 == null && str1532.startsWith(str60);
                                                                downloadReport4.isSucceed = downloadResult.getStatus().isSucceed();
                                                                downloadReport4.downloadMode = Downloader.DownloadMode.FastMode.ordinal();
                                                                if (response8 != null && response8.protocol() != null) {
                                                                    downloadReport4.f99896protocol = response8.protocol().getProtocol();
                                                                }
                                                                downloadResult2 = downloadResult;
                                                                downloadResult2.setReport(downloadReport4);
                                                                jobContext2 = jobContext;
                                                                if (downloadResult.getStatus().isSucceed()) {
                                                                    handleDownloadReportForTask(jobContext2, downloadResult2, downloadReport4);
                                                                }
                                                            }
                                                            if (!this.mIsHttp2) {
                                                                Call call = this.okRequestCall;
                                                                if (call != null) {
                                                                    call.cancel();
                                                                }
                                                                this.okRequestBuilder = null;
                                                            } else {
                                                                HttpGet httpGet3 = this.request;
                                                                if (httpGet3 != null) {
                                                                    httpGet3.abort();
                                                                    this.request = null;
                                                                }
                                                                cleanExpireConnection();
                                                            }
                                                            i58 = i36;
                                                            j46 = j26;
                                                            jobContext3 = jobContext2;
                                                            downloadResult3 = downloadResult2;
                                                            if (canAttempt()) {
                                                            }
                                                        } else {
                                                            String str155 = str13;
                                                            downloadResult.getProcess().setDuration(r142, SystemClock.uptimeMillis());
                                                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                            NetworkUtils.DNS dns9 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                            DownloadGlobalStrategy.StrategyInfo strategyInfo16 = this.pCurrStrategyInfo;
                                                            String str156 = (strategyInfo16 == null || strategyInfo16.getIPInfo() == null) ? null : this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                                            String parserHttpHeaderInfo4 = parserHttpHeaderInfo(this.request, httpResponse13, response19);
                                                            if (httpContext4 != null) {
                                                                try {
                                                                    str30 = (String) httpContext4.getAttribute("RedirectURI");
                                                                } catch (Exception unused4) {
                                                                    str30 = "";
                                                                }
                                                                try {
                                                                    str31 = (String) httpContext4.getAttribute("RealRemoteAddr");
                                                                } catch (Exception unused5) {
                                                                    str31 = "";
                                                                }
                                                            } else {
                                                                str31 = "";
                                                                str30 = str31;
                                                            }
                                                            downloadResult.getContent().redirectUrl = str30;
                                                            String str157 = str30;
                                                            this.connect_time = 0L;
                                                            this.connect_retry = 0;
                                                            this.exe_time = 0L;
                                                            this.exe_retry = 0;
                                                            if ((!downloadResult.getStatus().isSucceed() || jobContext.isCancelled()) && (resumeTransfer3 = this.pResumeTransfer) != null) {
                                                                resumeTransfer3.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse13, response19);
                                                            }
                                                            if (!jobContext.isCancelled()) {
                                                                boolean isNetworkAvailable2 = NetworkUtils.isNetworkAvailable(this.mContext);
                                                                if (!downloadResult.getStatus().isSucceed()) {
                                                                    ?? sb12 = new StringBuilder();
                                                                    sb12.append("Downloader, fail to download:");
                                                                    sb12.append(getUrl());
                                                                    sb12.append(" , requestHttp2=");
                                                                    sb12.append(this.mIsHttp2);
                                                                    sb12.append(", protocol=");
                                                                    if (this.mIsHttp2 && response19 != null && response19.protocol() != null) {
                                                                        str134 = response19.protocol().getProtocol();
                                                                    }
                                                                    sb12.append(str134);
                                                                    sb12.append(", dns=");
                                                                    sb12.append(dns9);
                                                                    sb12.append(str155);
                                                                    sb12.append(str156);
                                                                    sb12.append(", localAddress=");
                                                                    sb12.append(null);
                                                                    sb12.append(", thread=");
                                                                    sb12.append(Thread.currentThread().getId());
                                                                    sb12.append(", apn=");
                                                                    sb12.append(NetworkManager.getApnValue());
                                                                    sb12.append(", allowProxy=");
                                                                    sb12.append(this.mAllowProxy);
                                                                    sb12.append(", apnProxy=");
                                                                    sb12.append(this.mAPNProxy);
                                                                    sb12.append(", useProxy=");
                                                                    sb12.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                                    sb12.append(", netAvailable=");
                                                                    sb12.append(isNetworkAvailable2);
                                                                    sb12.append(", realRemoteAddr=");
                                                                    sb12.append(str31);
                                                                    sb12.append(", IpStack=");
                                                                    sb12.append(Config.getNetworkStackType());
                                                                    sb12.append(", contentType=");
                                                                    sb12.append(downloadResult.getContent().type);
                                                                    sb12.append(str139);
                                                                    sb12.append(downloadResult.getProcess().duration);
                                                                    sb12.append(str138);
                                                                    httpResponse4 = httpResponse13;
                                                                    sb12.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                                    sb12.append(str137);
                                                                    sb12.append(downloadResult.getContent().length);
                                                                    str32 = str136;
                                                                    sb12.append(str32);
                                                                    sb12.append(downloadResult.getContent().size);
                                                                    sb12.append(", realsize=");
                                                                    sb12.append(downloadResult.getContent().realsize);
                                                                    sb12.append(", retry=(");
                                                                    sb12.append(getCurrAttemptCount());
                                                                    String str158 = str5;
                                                                    sb12.append(str158);
                                                                    sb12.append(getTotalAttemptCount());
                                                                    sb12.append("), reason=");
                                                                    sb12.append(downloadResult.getStatus().getFailReason());
                                                                    sb12.append(", httpStatus=");
                                                                    sb12.append(i26);
                                                                    sb12.append(", ");
                                                                    sb12.append(parserHttpHeaderInfo4);
                                                                    sb12.append(", redirectURI=");
                                                                    z19 = isNetworkAvailable2;
                                                                    sb12.append(str157);
                                                                    sb12.append(", ipUrl:");
                                                                    String str159 = this.mRealUrl;
                                                                    if (str159 != null) {
                                                                        str44 = ", ";
                                                                        str159 = str159.substring(0, 30);
                                                                    } else {
                                                                        str44 = ", ";
                                                                    }
                                                                    sb12.append(str159);
                                                                    sb12.append(", strategyId=");
                                                                    DownloadGlobalStrategy.StrategyInfo strategyInfo17 = this.pCurrStrategyInfo;
                                                                    sb12.append(strategyInfo17 != null ? strategyInfo17.f99899id : 0);
                                                                    sb12.append(", clientip=");
                                                                    sb12.append(downloadResult.getContent().clientip);
                                                                    sb12.append(", getIP=");
                                                                    sb12.append(j17);
                                                                    sb12.append(", connect:(");
                                                                    j19 = j17;
                                                                    sb12.append(this.connect_time);
                                                                    sb12.append(str158);
                                                                    sb12.append(this.connect_retry);
                                                                    sb12.append("), exeReqest:(");
                                                                    sb12.append(this.exe_time);
                                                                    sb12.append(str158);
                                                                    sb12.append(this.exe_retry);
                                                                    sb12.append("), sendReq=");
                                                                    sb12.append(this.send_req_time);
                                                                    sb12.append(", recvData=");
                                                                    sb12.append(this.t_recv_data);
                                                                    sb12.append(", Concurrent:(");
                                                                    sb12.append(getTaskConcurrentCount());
                                                                    sb12.append("), mobileProxy=");
                                                                    DownloadTask.DownloadTaskHandler downloadTaskHandler4 = this.mDownloadTaskHandler;
                                                                    sb12.append(downloadTaskHandler4 != null ? downloadTaskHandler4.getCustomProxy() : null);
                                                                    String sb13 = sb12.toString();
                                                                    downloadReport.logInfo = sb13;
                                                                    QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb13, null);
                                                                    if (this.mRealUrl != null) {
                                                                        QDLog.d("FastDownloadTask", "fast force dns first is " + Config.isForceDNSFirst());
                                                                        CustomDnsResolve.setIPDirectEnable(getDomain(), Config.isForceDNSFirst());
                                                                    }
                                                                    str38 = parserHttpHeaderInfo4;
                                                                    dns2 = dns9;
                                                                    str37 = str157;
                                                                    response5 = response19;
                                                                    str39 = str31;
                                                                    downloadReport3 = downloadReport;
                                                                    str36 = ", redirectURI=";
                                                                    str35 = ", contentType=";
                                                                    str34 = str44;
                                                                    i29 = i26;
                                                                    str33 = str138;
                                                                } else {
                                                                    httpResponse4 = httpResponse13;
                                                                    str32 = str136;
                                                                    z19 = isNetworkAvailable2;
                                                                    str33 = str138;
                                                                    ?? sb14 = new StringBuilder();
                                                                    sb14.append("Downloader, succeed to download:");
                                                                    sb14.append(getUrl());
                                                                    sb14.append(" , requestHttp2=");
                                                                    sb14.append(this.mIsHttp2);
                                                                    sb14.append(", protocol=");
                                                                    if (this.mIsHttp2 && response19 != null && response19.protocol() != null) {
                                                                        str134 = response19.protocol().getProtocol();
                                                                    }
                                                                    sb14.append(str134);
                                                                    sb14.append(", dns=");
                                                                    sb14.append(dns9);
                                                                    sb14.append(str155);
                                                                    sb14.append(str156);
                                                                    sb14.append(", localAddress=");
                                                                    sb14.append(null);
                                                                    sb14.append(", thread=");
                                                                    sb14.append(Thread.currentThread().getId());
                                                                    sb14.append(", apn=");
                                                                    sb14.append(NetworkManager.getApnValue());
                                                                    sb14.append(", allowProxy=");
                                                                    sb14.append(this.mAllowProxy);
                                                                    sb14.append(", apnProxy=");
                                                                    sb14.append(this.mAPNProxy);
                                                                    sb14.append(", useProxy=");
                                                                    sb14.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                                    sb14.append(", IpStack=");
                                                                    sb14.append(Config.getNetworkStackType());
                                                                    sb14.append(", realRemoteAddr=");
                                                                    sb14.append(str31);
                                                                    sb14.append(str139);
                                                                    sb14.append(downloadResult.getProcess().duration);
                                                                    sb14.append(str33);
                                                                    sb14.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                                    sb14.append(str137);
                                                                    sb14.append(downloadResult.getContent().length);
                                                                    sb14.append(str32);
                                                                    sb14.append(downloadResult.getContent().size);
                                                                    sb14.append(", realsize=");
                                                                    sb14.append(downloadResult.getContent().realsize);
                                                                    sb14.append(", retry=(");
                                                                    sb14.append(getCurrAttemptCount());
                                                                    String str160 = str5;
                                                                    sb14.append(str160);
                                                                    sb14.append(getTotalAttemptCount());
                                                                    sb14.append("), httpStatus=");
                                                                    i29 = i26;
                                                                    sb14.append(i29);
                                                                    str34 = ", ";
                                                                    sb14.append(str34);
                                                                    sb14.append(parserHttpHeaderInfo4);
                                                                    str35 = ", contentType=";
                                                                    sb14.append(str35);
                                                                    sb14.append(downloadResult.getContent().type);
                                                                    str36 = ", redirectURI=";
                                                                    sb14.append(str36);
                                                                    dns2 = dns9;
                                                                    str37 = str157;
                                                                    sb14.append(str37);
                                                                    response5 = response19;
                                                                    sb14.append(", ipUrl:");
                                                                    String str161 = this.mRealUrl;
                                                                    if (str161 != null) {
                                                                        str39 = str31;
                                                                        str38 = parserHttpHeaderInfo4;
                                                                        str161 = str161.substring(0, 30);
                                                                    } else {
                                                                        str38 = parserHttpHeaderInfo4;
                                                                        str39 = str31;
                                                                    }
                                                                    sb14.append(str161);
                                                                    sb14.append(", strategyId=");
                                                                    DownloadGlobalStrategy.StrategyInfo strategyInfo18 = this.pCurrStrategyInfo;
                                                                    sb14.append(strategyInfo18 != null ? strategyInfo18.f99899id : 0);
                                                                    sb14.append(", clientip=");
                                                                    sb14.append(downloadResult.getContent().clientip);
                                                                    sb14.append(", getIP=");
                                                                    sb14.append(j17);
                                                                    sb14.append(", connect:(");
                                                                    j19 = j17;
                                                                    sb14.append(this.connect_time);
                                                                    sb14.append(str160);
                                                                    sb14.append(this.connect_retry);
                                                                    sb14.append("), exeReqest:(");
                                                                    sb14.append(this.exe_time);
                                                                    sb14.append(str160);
                                                                    sb14.append(this.exe_retry);
                                                                    sb14.append("), sendReq=");
                                                                    sb14.append(this.send_req_time);
                                                                    sb14.append(", recvData=");
                                                                    sb14.append(this.t_recv_data);
                                                                    sb14.append(", Concurrent:(");
                                                                    sb14.append(getTaskConcurrentCount());
                                                                    sb14.append("), mobileProxy=");
                                                                    DownloadTask.DownloadTaskHandler downloadTaskHandler5 = this.mDownloadTaskHandler;
                                                                    sb14.append(downloadTaskHandler5 != null ? downloadTaskHandler5.getCustomProxy() : null);
                                                                    String sb15 = sb14.toString();
                                                                    downloadReport3 = downloadReport;
                                                                    downloadReport3.logInfo = sb15;
                                                                    QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb15, null);
                                                                }
                                                                if (!z19) {
                                                                    this.mShouldReport = false;
                                                                }
                                                                DownloadResult.Status status2 = downloadResult.getStatus();
                                                                ?? sb16 = new StringBuilder();
                                                                sb16.append(getUrl());
                                                                sb16.append(" sip=");
                                                                sb16.append(str156);
                                                                sb16.append(", client=");
                                                                sb16.append(downloadResult.getContent().clientip);
                                                                sb16.append(", ipType=");
                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo19 = this.pCurrStrategyInfo;
                                                                sb16.append(strategyInfo19 != null ? strategyInfo19.f99899id : 0);
                                                                sb16.append(", httpStatus=");
                                                                sb16.append(i29);
                                                                sb16.append(str35);
                                                                sb16.append(downloadResult.getContent().type);
                                                                sb16.append(str137);
                                                                ?? r134 = downloadResult.getContent().length;
                                                                sb16.append(r134);
                                                                sb16.append(str32);
                                                                sb16.append(downloadResult.getContent().size);
                                                                sb16.append(str139);
                                                                sb16.append(downloadResult.getProcess().duration);
                                                                sb16.append(str33);
                                                                sb16.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                                if (TextUtils.isEmpty(str37)) {
                                                                    str40 = "";
                                                                } else {
                                                                    str40 = str36 + str37;
                                                                }
                                                                sb16.append(str40);
                                                                sb16.append(str34);
                                                                sb16.append(str38);
                                                                status2.detailDownloadInfo = sb16.toString();
                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo20 = this.pCurrStrategyInfo;
                                                                if (strategyInfo20 == null || DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id != strategyInfo20.f99899id || this.pBackupIPConfigStrategy == null) {
                                                                    r134 = str39;
                                                                } else {
                                                                    try {
                                                                        try {
                                                                            if (!TextUtils.isEmpty(str39)) {
                                                                                String str162 = str39;
                                                                                this.pBackupIPConfigStrategy.onIPAccessResult(getDomain(), str162, downloadResult.getStatus().isSucceed());
                                                                                r134 = str162;
                                                                            } else {
                                                                                r134 = str39;
                                                                                this.pBackupIPConfigStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                                            }
                                                                        } catch (Exception e26) {
                                                                            e = e26;
                                                                            str42 = QDLog.TAG_DOWNLOAD;
                                                                            QDLog.w(str42, "Strategy_BACKUPIP ", e);
                                                                            str41 = r134;
                                                                            strategyInfo4 = this.pCurrStrategyInfo;
                                                                            if (strategyInfo4 != null) {
                                                                                try {
                                                                                    if (TextUtils.isEmpty(str41)) {
                                                                                    }
                                                                                } catch (Exception e27) {
                                                                                    QDLog.w(str42, "Strategy_DomainDirect ", e27);
                                                                                }
                                                                            }
                                                                            if (z19) {
                                                                            }
                                                                            downloadReport3.endTime = System.currentTimeMillis();
                                                                            downloadReport3.fileSize = getContentLength();
                                                                            downloadReport3.response = httpResponse4;
                                                                            response6 = response5;
                                                                            downloadReport3.okResponse = response6;
                                                                            downloadReport3.httpStatus = i29;
                                                                            downloadReport3.exception = null;
                                                                            downloadReport3.dns = dns2 != null ? null : dns2.toString();
                                                                            downloadReport3.localAddress = null;
                                                                            downloadReport3.clientip = downloadResult.getContent().clientip;
                                                                            downloadReport3.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                                            downloadReport3.downloadTime = downloadResult.getProcess().duration;
                                                                            downloadReport3.t_wait = downloadReport3.totaltime - downloadResult.getProcess().duration;
                                                                            downloadReport3.t_prepare = j19;
                                                                            downloadReport3.t_conn = this.connect_time;
                                                                            downloadReport3.t_recvrsp = this.send_req_time;
                                                                            downloadReport3.t_recvdata = this.t_recv_data;
                                                                            downloadReport3.t_process = 0L;
                                                                            downloadReport3.concurrent = getTaskConcurrentCount();
                                                                            downloadReport3.content_type = downloadResult.getContent().type;
                                                                            downloadReport3.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                                            downloadReport3.isHttp2 = this.mIsHttp2;
                                                                            String str163 = this.mRealUrl;
                                                                            downloadReport3.isHttps = str163 == null && str163.startsWith(str43);
                                                                            downloadReport3.isSucceed = downloadResult.getStatus().isSucceed();
                                                                            downloadReport3.downloadMode = Downloader.DownloadMode.FastMode.ordinal();
                                                                            if (response6 != null) {
                                                                                downloadReport3.f99896protocol = response6.protocol().getProtocol();
                                                                            }
                                                                            downloadResult.setReport(downloadReport3);
                                                                            if (downloadResult.getStatus().isSucceed()) {
                                                                            }
                                                                            if (!this.mIsHttp2) {
                                                                            }
                                                                        }
                                                                    } catch (Exception e28) {
                                                                        e = e28;
                                                                        r134 = str39;
                                                                    }
                                                                }
                                                                str42 = QDLog.TAG_DOWNLOAD;
                                                                str41 = r134;
                                                                strategyInfo4 = this.pCurrStrategyInfo;
                                                                if (strategyInfo4 != null && DownloadGlobalStrategy.Strategy_DomainDirect.f99899id == strategyInfo4.f99899id && this.pDirectIPConfigStrategy != null) {
                                                                    if (TextUtils.isEmpty(str41)) {
                                                                        this.pDirectIPConfigStrategy.onIPAccessResult(getDomain(), str41, downloadResult.getStatus().isSucceed());
                                                                    } else {
                                                                        this.pDirectIPConfigStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                                    }
                                                                }
                                                                if (z19) {
                                                                    str43 = "https";
                                                                } else {
                                                                    DownloadGlobalStrategy downloadGlobalStrategy2 = DownloadGlobalStrategy.getInstance(this.mContext);
                                                                    String str164 = this.mRealUrl;
                                                                    if (!this.mIsHttp2 || str164 == null) {
                                                                        str43 = "https";
                                                                    } else {
                                                                        str43 = "https";
                                                                        if (str164.startsWith(str43)) {
                                                                            z26 = true;
                                                                            downloadGlobalStrategy2.reportHttps(str164, z26, downloadResult.getStatus().isSucceed());
                                                                        }
                                                                    }
                                                                    z26 = false;
                                                                    downloadGlobalStrategy2.reportHttps(str164, z26, downloadResult.getStatus().isSucceed());
                                                                }
                                                                downloadReport3.endTime = System.currentTimeMillis();
                                                                downloadReport3.fileSize = getContentLength();
                                                                downloadReport3.response = httpResponse4;
                                                                response6 = response5;
                                                                downloadReport3.okResponse = response6;
                                                                downloadReport3.httpStatus = i29;
                                                                downloadReport3.exception = null;
                                                                downloadReport3.dns = dns2 != null ? null : dns2.toString();
                                                                downloadReport3.localAddress = null;
                                                                downloadReport3.clientip = downloadResult.getContent().clientip;
                                                                downloadReport3.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                                downloadReport3.downloadTime = downloadResult.getProcess().duration;
                                                                downloadReport3.t_wait = downloadReport3.totaltime - downloadResult.getProcess().duration;
                                                                downloadReport3.t_prepare = j19;
                                                                downloadReport3.t_conn = this.connect_time;
                                                                downloadReport3.t_recvrsp = this.send_req_time;
                                                                downloadReport3.t_recvdata = this.t_recv_data;
                                                                downloadReport3.t_process = 0L;
                                                                downloadReport3.concurrent = getTaskConcurrentCount();
                                                                downloadReport3.content_type = downloadResult.getContent().type;
                                                                downloadReport3.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                                downloadReport3.isHttp2 = this.mIsHttp2;
                                                                String str1632 = this.mRealUrl;
                                                                downloadReport3.isHttps = str1632 == null && str1632.startsWith(str43);
                                                                downloadReport3.isSucceed = downloadResult.getStatus().isSucceed();
                                                                downloadReport3.downloadMode = Downloader.DownloadMode.FastMode.ordinal();
                                                                if (response6 != null && response6.protocol() != null) {
                                                                    downloadReport3.f99896protocol = response6.protocol().getProtocol();
                                                                }
                                                                downloadResult.setReport(downloadReport3);
                                                                if (downloadResult.getStatus().isSucceed()) {
                                                                    handleDownloadReportForTask(jobContext, downloadResult, downloadReport3);
                                                                }
                                                            }
                                                            if (!this.mIsHttp2) {
                                                                Call call2 = this.okRequestCall;
                                                                if (call2 != null) {
                                                                    call2.cancel();
                                                                }
                                                                this.okRequestBuilder = null;
                                                                return;
                                                            }
                                                            httpGet = null;
                                                            httpGet2 = this.request;
                                                        }
                                                    } else {
                                                        String str165 = str13;
                                                        downloadResult.getProcess().setDuration(r142, SystemClock.uptimeMillis());
                                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                        NetworkUtils.DNS dns10 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo21 = this.pCurrStrategyInfo;
                                                        String str166 = (strategyInfo21 == null || strategyInfo21.getIPInfo() == null) ? null : this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                                        String parserHttpHeaderInfo5 = parserHttpHeaderInfo(this.request, httpResponse13, response19);
                                                        if (httpContext4 != null) {
                                                            try {
                                                                str14 = (String) httpContext4.getAttribute("RedirectURI");
                                                            } catch (Exception unused6) {
                                                                str14 = "";
                                                            }
                                                            try {
                                                                str15 = (String) httpContext4.getAttribute("RealRemoteAddr");
                                                            } catch (Exception unused7) {
                                                                str15 = "";
                                                            }
                                                        } else {
                                                            str14 = "";
                                                            str15 = str14;
                                                        }
                                                        downloadResult.getContent().redirectUrl = str14;
                                                        String str167 = str14;
                                                        this.connect_time = 0L;
                                                        this.connect_retry = 0;
                                                        this.exe_time = 0L;
                                                        this.exe_retry = 0;
                                                        if ((!downloadResult.getStatus().isSucceed() || jobContext.isCancelled()) && (resumeTransfer2 = this.pResumeTransfer) != null) {
                                                            resumeTransfer2.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse13, response19);
                                                        }
                                                        if (!jobContext.isCancelled()) {
                                                            boolean isNetworkAvailable3 = NetworkUtils.isNetworkAvailable(this.mContext);
                                                            if (!downloadResult.getStatus().isSucceed()) {
                                                                ?? sb17 = new StringBuilder();
                                                                sb17.append("Downloader, fail to download:");
                                                                sb17.append(getUrl());
                                                                sb17.append(" , requestHttp2=");
                                                                sb17.append(this.mIsHttp2);
                                                                sb17.append(", protocol=");
                                                                if (this.mIsHttp2 && response19 != null && response19.protocol() != null) {
                                                                    str134 = response19.protocol().getProtocol();
                                                                }
                                                                sb17.append(str134);
                                                                sb17.append(", dns=");
                                                                sb17.append(dns10);
                                                                sb17.append(str165);
                                                                sb17.append(str166);
                                                                sb17.append(", localAddress=");
                                                                sb17.append(null);
                                                                sb17.append(", thread=");
                                                                sb17.append(Thread.currentThread().getId());
                                                                sb17.append(", apn=");
                                                                sb17.append(NetworkManager.getApnValue());
                                                                sb17.append(", allowProxy=");
                                                                sb17.append(this.mAllowProxy);
                                                                sb17.append(", apnProxy=");
                                                                sb17.append(this.mAPNProxy);
                                                                sb17.append(", useProxy=");
                                                                sb17.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                                sb17.append(", netAvailable=");
                                                                sb17.append(isNetworkAvailable3);
                                                                sb17.append(", realRemoteAddr=");
                                                                sb17.append(str15);
                                                                sb17.append(", IpStack=");
                                                                sb17.append(Config.getNetworkStackType());
                                                                sb17.append(", contentType=");
                                                                sb17.append(downloadResult.getContent().type);
                                                                sb17.append(str139);
                                                                sb17.append(downloadResult.getProcess().duration);
                                                                str18 = str138;
                                                                sb17.append(str18);
                                                                sb17.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                                sb17.append(str137);
                                                                sb17.append(downloadResult.getContent().length);
                                                                sb17.append(str136);
                                                                sb17.append(downloadResult.getContent().size);
                                                                sb17.append(", realsize=");
                                                                sb17.append(downloadResult.getContent().realsize);
                                                                sb17.append(", retry=(");
                                                                sb17.append(getCurrAttemptCount());
                                                                String str168 = str5;
                                                                sb17.append(str168);
                                                                sb17.append(getTotalAttemptCount());
                                                                sb17.append("), reason=");
                                                                sb17.append(downloadResult.getStatus().getFailReason());
                                                                sb17.append(", httpStatus=");
                                                                sb17.append(i26);
                                                                sb17.append(", ");
                                                                httpResponse3 = httpResponse13;
                                                                sb17.append(parserHttpHeaderInfo5);
                                                                z17 = isNetworkAvailable3;
                                                                sb17.append(", redirectURI=");
                                                                sb17.append(str167);
                                                                sb17.append(", ipUrl:");
                                                                String str169 = this.mRealUrl;
                                                                if (str169 != null) {
                                                                    i28 = i26;
                                                                    str169 = str169.substring(0, 30);
                                                                } else {
                                                                    i28 = i26;
                                                                }
                                                                sb17.append(str169);
                                                                sb17.append(", strategyId=");
                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo22 = this.pCurrStrategyInfo;
                                                                sb17.append(strategyInfo22 != null ? strategyInfo22.f99899id : 0);
                                                                sb17.append(", clientip=");
                                                                sb17.append(downloadResult.getContent().clientip);
                                                                sb17.append(", getIP=");
                                                                sb17.append(j17);
                                                                sb17.append(", connect:(");
                                                                j18 = j17;
                                                                sb17.append(this.connect_time);
                                                                sb17.append(str168);
                                                                sb17.append(this.connect_retry);
                                                                sb17.append("), exeReqest:(");
                                                                sb17.append(this.exe_time);
                                                                sb17.append(str168);
                                                                sb17.append(this.exe_retry);
                                                                sb17.append("), sendReq=");
                                                                sb17.append(this.send_req_time);
                                                                sb17.append(", recvData=");
                                                                sb17.append(this.t_recv_data);
                                                                sb17.append(", Concurrent:(");
                                                                sb17.append(getTaskConcurrentCount());
                                                                sb17.append("), mobileProxy=");
                                                                DownloadTask.DownloadTaskHandler downloadTaskHandler6 = this.mDownloadTaskHandler;
                                                                sb17.append(downloadTaskHandler6 != null ? downloadTaskHandler6.getCustomProxy() : null);
                                                                String sb18 = sb17.toString();
                                                                downloadReport.logInfo = sb18;
                                                                QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb18, null);
                                                                if (this.mRealUrl != null) {
                                                                    QDLog.d("FastDownloadTask", "fast force dns first is " + Config.isForceDNSFirst());
                                                                    CustomDnsResolve.setIPDirectEnable(getDomain(), Config.isForceDNSFirst());
                                                                }
                                                                str19 = ", contentType=";
                                                                str24 = ", ";
                                                                response3 = response19;
                                                                downloadReport2 = downloadReport;
                                                                str23 = str15;
                                                                str22 = parserHttpHeaderInfo5;
                                                                i27 = i28;
                                                                str20 = ", redirectURI=";
                                                                str16 = str136;
                                                                str17 = str137;
                                                                dns = dns10;
                                                                str21 = str167;
                                                                str25 = str15;
                                                            } else {
                                                                httpResponse3 = httpResponse13;
                                                                str16 = str136;
                                                                str17 = str137;
                                                                str18 = str138;
                                                                z17 = isNetworkAvailable3;
                                                                ?? sb19 = new StringBuilder();
                                                                sb19.append("Downloader, succeed to download:");
                                                                sb19.append(getUrl());
                                                                sb19.append(" , requestHttp2=");
                                                                sb19.append(this.mIsHttp2);
                                                                sb19.append(", protocol=");
                                                                if (this.mIsHttp2 && response19 != null && response19.protocol() != null) {
                                                                    str134 = response19.protocol().getProtocol();
                                                                }
                                                                sb19.append(str134);
                                                                sb19.append(", dns=");
                                                                sb19.append(dns10);
                                                                sb19.append(str165);
                                                                sb19.append(str166);
                                                                sb19.append(", localAddress=");
                                                                sb19.append(null);
                                                                sb19.append(", thread=");
                                                                sb19.append(Thread.currentThread().getId());
                                                                sb19.append(", apn=");
                                                                sb19.append(NetworkManager.getApnValue());
                                                                sb19.append(", allowProxy=");
                                                                sb19.append(this.mAllowProxy);
                                                                sb19.append(", apnProxy=");
                                                                sb19.append(this.mAPNProxy);
                                                                sb19.append(", useProxy=");
                                                                sb19.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                                sb19.append(", IpStack=");
                                                                sb19.append(Config.getNetworkStackType());
                                                                sb19.append(", realRemoteAddr=");
                                                                sb19.append(str15);
                                                                sb19.append(str139);
                                                                sb19.append(downloadResult.getProcess().duration);
                                                                sb19.append(str18);
                                                                sb19.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                                sb19.append(str17);
                                                                sb19.append(downloadResult.getContent().length);
                                                                sb19.append(str16);
                                                                sb19.append(downloadResult.getContent().size);
                                                                sb19.append(", realsize=");
                                                                sb19.append(downloadResult.getContent().realsize);
                                                                sb19.append(", retry=(");
                                                                sb19.append(getCurrAttemptCount());
                                                                String str170 = str5;
                                                                sb19.append(str170);
                                                                sb19.append(getTotalAttemptCount());
                                                                sb19.append("), httpStatus=");
                                                                i27 = i26;
                                                                sb19.append(i27);
                                                                sb19.append(", ");
                                                                sb19.append(parserHttpHeaderInfo5);
                                                                str19 = ", contentType=";
                                                                sb19.append(str19);
                                                                sb19.append(downloadResult.getContent().type);
                                                                str20 = ", redirectURI=";
                                                                sb19.append(str20);
                                                                dns = dns10;
                                                                str21 = str167;
                                                                sb19.append(str21);
                                                                response3 = response19;
                                                                sb19.append(", ipUrl:");
                                                                String str171 = this.mRealUrl;
                                                                if (str171 != null) {
                                                                    str23 = str15;
                                                                    r132 = 30;
                                                                    str22 = parserHttpHeaderInfo5;
                                                                    str171 = str171.substring(0, 30);
                                                                } else {
                                                                    str22 = parserHttpHeaderInfo5;
                                                                    str23 = str15;
                                                                    r132 = str15;
                                                                }
                                                                sb19.append(str171);
                                                                sb19.append(", strategyId=");
                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo23 = this.pCurrStrategyInfo;
                                                                sb19.append(strategyInfo23 != null ? strategyInfo23.f99899id : 0);
                                                                sb19.append(", clientip=");
                                                                sb19.append(downloadResult.getContent().clientip);
                                                                sb19.append(", getIP=");
                                                                str24 = ", ";
                                                                sb19.append(j17);
                                                                sb19.append(", connect:(");
                                                                j18 = j17;
                                                                sb19.append(this.connect_time);
                                                                sb19.append(str170);
                                                                sb19.append(this.connect_retry);
                                                                sb19.append("), exeReqest:(");
                                                                sb19.append(this.exe_time);
                                                                sb19.append(str170);
                                                                sb19.append(this.exe_retry);
                                                                sb19.append("), sendReq=");
                                                                sb19.append(this.send_req_time);
                                                                sb19.append(", recvData=");
                                                                sb19.append(this.t_recv_data);
                                                                sb19.append(", Concurrent:(");
                                                                sb19.append(getTaskConcurrentCount());
                                                                sb19.append("), mobileProxy=");
                                                                DownloadTask.DownloadTaskHandler downloadTaskHandler7 = this.mDownloadTaskHandler;
                                                                sb19.append(downloadTaskHandler7 != null ? downloadTaskHandler7.getCustomProxy() : null);
                                                                String sb20 = sb19.toString();
                                                                downloadReport2 = downloadReport;
                                                                downloadReport2.logInfo = sb20;
                                                                QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb20, null);
                                                                str25 = r132;
                                                            }
                                                            if (!z17) {
                                                                this.mShouldReport = false;
                                                            }
                                                            DownloadResult.Status status3 = downloadResult.getStatus();
                                                            ?? sb21 = new StringBuilder();
                                                            sb21.append(getUrl());
                                                            sb21.append(" sip=");
                                                            sb21.append(str166);
                                                            sb21.append(", client=");
                                                            sb21.append(downloadResult.getContent().clientip);
                                                            sb21.append(", ipType=");
                                                            DownloadGlobalStrategy.StrategyInfo strategyInfo24 = this.pCurrStrategyInfo;
                                                            sb21.append(strategyInfo24 != null ? strategyInfo24.f99899id : 0);
                                                            sb21.append(", httpStatus=");
                                                            sb21.append(i27);
                                                            sb21.append(str19);
                                                            sb21.append(downloadResult.getContent().type);
                                                            sb21.append(str17);
                                                            sb21.append(downloadResult.getContent().length);
                                                            sb21.append(str16);
                                                            sb21.append(downloadResult.getContent().size);
                                                            sb21.append(str139);
                                                            sb21.append(downloadResult.getProcess().duration);
                                                            sb21.append(str18);
                                                            sb21.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                            if (TextUtils.isEmpty(str21)) {
                                                                str26 = "";
                                                            } else {
                                                                str26 = str20 + str21;
                                                            }
                                                            sb21.append(str26);
                                                            sb21.append(str24);
                                                            sb21.append(str22);
                                                            status3.detailDownloadInfo = sb21.toString();
                                                            DownloadGlobalStrategy.StrategyInfo strategyInfo25 = this.pCurrStrategyInfo;
                                                            if (strategyInfo25 == null || DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id != strategyInfo25.f99899id || this.pBackupIPConfigStrategy == null) {
                                                                str25 = str23;
                                                            } else {
                                                                try {
                                                                } catch (Exception e29) {
                                                                    e = e29;
                                                                    str25 = str23;
                                                                }
                                                                try {
                                                                    if (!TextUtils.isEmpty(str23)) {
                                                                        String str172 = str23;
                                                                        this.pBackupIPConfigStrategy.onIPAccessResult(getDomain(), str172, downloadResult.getStatus().isSucceed());
                                                                        str25 = str172;
                                                                    } else {
                                                                        str25 = str23;
                                                                        this.pBackupIPConfigStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                                    }
                                                                } catch (Exception e36) {
                                                                    e = e36;
                                                                    str28 = QDLog.TAG_DOWNLOAD;
                                                                    QDLog.w(str28, "Strategy_BACKUPIP ", e);
                                                                    str27 = str25;
                                                                    strategyInfo3 = this.pCurrStrategyInfo;
                                                                    if (strategyInfo3 != null) {
                                                                        try {
                                                                            if (TextUtils.isEmpty(str27)) {
                                                                            }
                                                                        } catch (Exception e37) {
                                                                            QDLog.w(str28, "Strategy_DomainDirect ", e37);
                                                                        }
                                                                    }
                                                                    if (z17) {
                                                                    }
                                                                    downloadReport2.endTime = System.currentTimeMillis();
                                                                    downloadReport2.fileSize = getContentLength();
                                                                    downloadReport2.response = httpResponse3;
                                                                    response4 = response3;
                                                                    downloadReport2.okResponse = response4;
                                                                    downloadReport2.httpStatus = i27;
                                                                    downloadReport2.exception = null;
                                                                    downloadReport2.dns = dns != null ? null : dns.toString();
                                                                    downloadReport2.localAddress = null;
                                                                    downloadReport2.clientip = downloadResult.getContent().clientip;
                                                                    downloadReport2.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                                    downloadReport2.downloadTime = downloadResult.getProcess().duration;
                                                                    downloadReport2.t_wait = downloadReport2.totaltime - downloadResult.getProcess().duration;
                                                                    downloadReport2.t_prepare = j18;
                                                                    downloadReport2.t_conn = this.connect_time;
                                                                    downloadReport2.t_recvrsp = this.send_req_time;
                                                                    downloadReport2.t_recvdata = this.t_recv_data;
                                                                    downloadReport2.t_process = 0L;
                                                                    downloadReport2.concurrent = getTaskConcurrentCount();
                                                                    downloadReport2.content_type = downloadResult.getContent().type;
                                                                    downloadReport2.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                                    downloadReport2.isHttp2 = this.mIsHttp2;
                                                                    String str173 = this.mRealUrl;
                                                                    downloadReport2.isHttps = str173 == null && str173.startsWith(str29);
                                                                    downloadReport2.isSucceed = downloadResult.getStatus().isSucceed();
                                                                    downloadReport2.downloadMode = Downloader.DownloadMode.FastMode.ordinal();
                                                                    if (response4 != null) {
                                                                        downloadReport2.f99896protocol = response4.protocol().getProtocol();
                                                                    }
                                                                    downloadResult.setReport(downloadReport2);
                                                                    if (downloadResult.getStatus().isSucceed()) {
                                                                    }
                                                                    if (!this.mIsHttp2) {
                                                                    }
                                                                }
                                                            }
                                                            str28 = QDLog.TAG_DOWNLOAD;
                                                            str27 = str25;
                                                            strategyInfo3 = this.pCurrStrategyInfo;
                                                            if (strategyInfo3 != null && DownloadGlobalStrategy.Strategy_DomainDirect.f99899id == strategyInfo3.f99899id && this.pDirectIPConfigStrategy != null) {
                                                                if (TextUtils.isEmpty(str27)) {
                                                                    this.pDirectIPConfigStrategy.onIPAccessResult(getDomain(), str27, downloadResult.getStatus().isSucceed());
                                                                } else {
                                                                    this.pDirectIPConfigStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                                }
                                                            }
                                                            if (z17) {
                                                                str29 = "https";
                                                            } else {
                                                                DownloadGlobalStrategy downloadGlobalStrategy3 = DownloadGlobalStrategy.getInstance(this.mContext);
                                                                String str174 = this.mRealUrl;
                                                                if (!this.mIsHttp2 || str174 == null) {
                                                                    str29 = "https";
                                                                } else {
                                                                    str29 = "https";
                                                                    if (str174.startsWith(str29)) {
                                                                        z18 = true;
                                                                        downloadGlobalStrategy3.reportHttps(str174, z18, downloadResult.getStatus().isSucceed());
                                                                    }
                                                                }
                                                                z18 = false;
                                                                downloadGlobalStrategy3.reportHttps(str174, z18, downloadResult.getStatus().isSucceed());
                                                            }
                                                            downloadReport2.endTime = System.currentTimeMillis();
                                                            downloadReport2.fileSize = getContentLength();
                                                            downloadReport2.response = httpResponse3;
                                                            response4 = response3;
                                                            downloadReport2.okResponse = response4;
                                                            downloadReport2.httpStatus = i27;
                                                            downloadReport2.exception = null;
                                                            downloadReport2.dns = dns != null ? null : dns.toString();
                                                            downloadReport2.localAddress = null;
                                                            downloadReport2.clientip = downloadResult.getContent().clientip;
                                                            downloadReport2.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                            downloadReport2.downloadTime = downloadResult.getProcess().duration;
                                                            downloadReport2.t_wait = downloadReport2.totaltime - downloadResult.getProcess().duration;
                                                            downloadReport2.t_prepare = j18;
                                                            downloadReport2.t_conn = this.connect_time;
                                                            downloadReport2.t_recvrsp = this.send_req_time;
                                                            downloadReport2.t_recvdata = this.t_recv_data;
                                                            downloadReport2.t_process = 0L;
                                                            downloadReport2.concurrent = getTaskConcurrentCount();
                                                            downloadReport2.content_type = downloadResult.getContent().type;
                                                            downloadReport2.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                            downloadReport2.isHttp2 = this.mIsHttp2;
                                                            String str1732 = this.mRealUrl;
                                                            downloadReport2.isHttps = str1732 == null && str1732.startsWith(str29);
                                                            downloadReport2.isSucceed = downloadResult.getStatus().isSucceed();
                                                            downloadReport2.downloadMode = Downloader.DownloadMode.FastMode.ordinal();
                                                            if (response4 != null && response4.protocol() != null) {
                                                                downloadReport2.f99896protocol = response4.protocol().getProtocol();
                                                            }
                                                            downloadResult.setReport(downloadReport2);
                                                            if (downloadResult.getStatus().isSucceed()) {
                                                                handleDownloadReportForTask(jobContext, downloadResult, downloadReport2);
                                                            }
                                                        }
                                                        if (!this.mIsHttp2) {
                                                            Call call3 = this.okRequestCall;
                                                            if (call3 != null) {
                                                                call3.cancel();
                                                            }
                                                            this.okRequestBuilder = null;
                                                            return;
                                                        }
                                                        httpGet = null;
                                                        httpGet2 = this.request;
                                                    }
                                                }
                                            }
                                            i38 = i26;
                                            r56 = str69;
                                            r65 = str68;
                                            str75 = str72;
                                            httpResponse8 = httpResponse6;
                                            response11 = response9;
                                            str74 = str66;
                                        }
                                        i19 = code;
                                        downloadResult.getStatus().httpStatus = i19;
                                        if (200 == i19) {
                                        }
                                        i26 = i19;
                                        HttpContext httpContext42 = httpContext;
                                        j17 = currentTimeMillis2;
                                        Response response192 = response2;
                                        HttpResponse httpResponse132 = execute;
                                        if (handleResponse(execute, response2, downloadResult, jobContext, i26)) {
                                        }
                                    }
                                    int i69 = i16 + 1;
                                    String str175 = str67;
                                    String str176 = str63;
                                    downloadResult.getProcess().setDuration(j27, SystemClock.uptimeMillis());
                                    downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                    downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                    NetworkUtils.DNS dns11 = NetworkStatus.getInstance(this.mContext).getDNS();
                                    DownloadGlobalStrategy.StrategyInfo strategyInfo26 = this.pCurrStrategyInfo;
                                    String str177 = (strategyInfo26 == null || strategyInfo26.getIPInfo() == null) ? null : this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                    String parserHttpHeaderInfo6 = parserHttpHeaderInfo(this.request, httpResponse8, response11);
                                    if (httpContext2 != null) {
                                        try {
                                            str76 = (String) httpContext2.getAttribute("RedirectURI");
                                        } catch (Exception unused8) {
                                            str76 = "";
                                        }
                                        try {
                                            str77 = (String) httpContext2.getAttribute("RealRemoteAddr");
                                        } catch (Exception unused9) {
                                            str77 = "";
                                        }
                                    } else {
                                        str76 = "";
                                        str77 = str76;
                                    }
                                    downloadResult.getContent().redirectUrl = str76;
                                    String str178 = str76;
                                    this.connect_time = 0L;
                                    this.connect_retry = 0;
                                    this.exe_time = 0L;
                                    this.exe_retry = 0;
                                    if ((!downloadResult.getStatus().isSucceed() || jobContext.isCancelled()) && (resumeTransfer5 = this.pResumeTransfer) != null) {
                                        resumeTransfer5.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse8, response11);
                                    }
                                    if (jobContext.isCancelled()) {
                                        jobContext4 = jobContext;
                                        downloadResult4 = downloadResult;
                                        j28 = j17;
                                    } else {
                                        boolean isNetworkAvailable4 = NetworkUtils.isNetworkAvailable(this.mContext);
                                        if (!downloadResult.getStatus().isSucceed()) {
                                            ?? sb22 = new StringBuilder();
                                            sb22.append("Downloader, fail to download:");
                                            sb22.append(getUrl());
                                            sb22.append(str75);
                                            sb22.append(this.mIsHttp2);
                                            sb22.append(str135);
                                            if (this.mIsHttp2 && response11 != null && response11.protocol() != null) {
                                                str134 = response11.protocol().getProtocol();
                                            }
                                            sb22.append(str134);
                                            sb22.append(str70);
                                            sb22.append(dns11);
                                            sb22.append(r56);
                                            sb22.append(str177);
                                            sb22.append(str176);
                                            sb22.append(null);
                                            sb22.append(", thread=");
                                            sb22.append(Thread.currentThread().getId());
                                            sb22.append(", apn=");
                                            sb22.append(NetworkManager.getApnValue());
                                            sb22.append(", allowProxy=");
                                            sb22.append(this.mAllowProxy);
                                            sb22.append(", apnProxy=");
                                            sb22.append(this.mAPNProxy);
                                            sb22.append(", useProxy=");
                                            sb22.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                            sb22.append(", netAvailable=");
                                            sb22.append(isNetworkAvailable4);
                                            sb22.append(", realRemoteAddr=");
                                            sb22.append(str77);
                                            sb22.append(", IpStack=");
                                            sb22.append(Config.getNetworkStackType());
                                            sb22.append(str71);
                                            sb22.append(downloadResult.getContent().type);
                                            sb22.append(r65);
                                            sb22.append(downloadResult.getProcess().duration);
                                            sb22.append(str175);
                                            String str179 = str71;
                                            sb22.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                            sb22.append(str74);
                                            sb22.append(downloadResult.getContent().length);
                                            str78 = str136;
                                            sb22.append(str78);
                                            sb22.append(downloadResult.getContent().size);
                                            sb22.append(", realsize=");
                                            sb22.append(downloadResult.getContent().realsize);
                                            sb22.append(", retry=(");
                                            sb22.append(getCurrAttemptCount());
                                            String str180 = str5;
                                            sb22.append(str180);
                                            sb22.append(getTotalAttemptCount());
                                            sb22.append("), reason=");
                                            sb22.append(downloadResult.getStatus().getFailReason());
                                            sb22.append(", httpStatus=");
                                            int i75 = i38;
                                            sb22.append(i75);
                                            String str181 = str65;
                                            sb22.append(str181);
                                            sb22.append(parserHttpHeaderInfo6);
                                            httpResponse9 = httpResponse8;
                                            String str182 = str64;
                                            sb22.append(str182);
                                            z29 = isNetworkAvailable4;
                                            sb22.append(str178);
                                            sb22.append(", ipUrl:");
                                            String str183 = this.mRealUrl;
                                            if (str183 != null) {
                                                str89 = str181;
                                                str183 = str183.substring(0, 30);
                                            } else {
                                                str89 = str181;
                                            }
                                            sb22.append(str183);
                                            sb22.append(", strategyId=");
                                            DownloadGlobalStrategy.StrategyInfo strategyInfo27 = this.pCurrStrategyInfo;
                                            sb22.append(strategyInfo27 != null ? strategyInfo27.f99899id : 0);
                                            sb22.append(", clientip=");
                                            sb22.append(downloadResult.getContent().clientip);
                                            sb22.append(", getIP=");
                                            sb22.append(j17);
                                            sb22.append(", connect:(");
                                            sb22.append(this.connect_time);
                                            sb22.append(str180);
                                            sb22.append(this.connect_retry);
                                            sb22.append("), exeReqest:(");
                                            sb22.append(this.exe_time);
                                            sb22.append(str180);
                                            sb22.append(this.exe_retry);
                                            sb22.append("), sendReq=");
                                            sb22.append(this.send_req_time);
                                            sb22.append(", recvData=");
                                            sb22.append(this.t_recv_data);
                                            sb22.append(", Concurrent:(");
                                            sb22.append(getTaskConcurrentCount());
                                            sb22.append("), mobileProxy=");
                                            DownloadTask.DownloadTaskHandler downloadTaskHandler8 = this.mDownloadTaskHandler;
                                            sb22.append(downloadTaskHandler8 != null ? downloadTaskHandler8.getCustomProxy() : null);
                                            String sb23 = sb22.toString();
                                            downloadReport.logInfo = sb23;
                                            QDLog.e(str62, sb23, null);
                                            if (this.mRealUrl != null) {
                                                QDLog.d("FastDownloadTask", "fast force dns first is " + Config.isForceDNSFirst());
                                                CustomDnsResolve.setIPDirectEnable(getDomain(), Config.isForceDNSFirst());
                                            }
                                            dns4 = dns11;
                                            str83 = str77;
                                            str81 = str182;
                                            response12 = response11;
                                            str80 = str179;
                                            str79 = str89;
                                            str84 = parserHttpHeaderInfo6;
                                            str82 = str178;
                                            downloadReport5 = downloadReport;
                                            i39 = i75;
                                        } else {
                                            String str184 = str71;
                                            str78 = str136;
                                            long j47 = j17;
                                            String str185 = str62;
                                            String str186 = str64;
                                            String str187 = str65;
                                            int i76 = i38;
                                            z29 = isNetworkAvailable4;
                                            httpResponse9 = httpResponse8;
                                            ?? sb24 = new StringBuilder();
                                            sb24.append("Downloader, succeed to download:");
                                            sb24.append(getUrl());
                                            sb24.append(str75);
                                            sb24.append(this.mIsHttp2);
                                            sb24.append(str135);
                                            if (this.mIsHttp2 && response11 != null && response11.protocol() != null) {
                                                str134 = response11.protocol().getProtocol();
                                            }
                                            sb24.append(str134);
                                            sb24.append(str70);
                                            sb24.append(dns11);
                                            sb24.append(r56);
                                            sb24.append(str177);
                                            sb24.append(str176);
                                            sb24.append(null);
                                            sb24.append(", thread=");
                                            sb24.append(Thread.currentThread().getId());
                                            sb24.append(", apn=");
                                            sb24.append(NetworkManager.getApnValue());
                                            sb24.append(", allowProxy=");
                                            sb24.append(this.mAllowProxy);
                                            sb24.append(", apnProxy=");
                                            sb24.append(this.mAPNProxy);
                                            sb24.append(", useProxy=");
                                            sb24.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                            sb24.append(", IpStack=");
                                            sb24.append(Config.getNetworkStackType());
                                            sb24.append(", realRemoteAddr=");
                                            sb24.append(str77);
                                            sb24.append(r65);
                                            sb24.append(downloadResult.getProcess().duration);
                                            sb24.append(str175);
                                            response12 = response11;
                                            sb24.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                            sb24.append(str74);
                                            sb24.append(downloadResult.getContent().length);
                                            sb24.append(str78);
                                            sb24.append(downloadResult.getContent().size);
                                            sb24.append(", realsize=");
                                            sb24.append(downloadResult.getContent().realsize);
                                            sb24.append(", retry=(");
                                            sb24.append(getCurrAttemptCount());
                                            String str188 = str5;
                                            sb24.append(str188);
                                            sb24.append(getTotalAttemptCount());
                                            sb24.append("), httpStatus=");
                                            i39 = i76;
                                            sb24.append(i39);
                                            str79 = str187;
                                            sb24.append(str79);
                                            sb24.append(parserHttpHeaderInfo6);
                                            str80 = str184;
                                            sb24.append(str80);
                                            sb24.append(downloadResult.getContent().type);
                                            str81 = str186;
                                            sb24.append(str81);
                                            str82 = str178;
                                            sb24.append(str82);
                                            dns4 = dns11;
                                            sb24.append(", ipUrl:");
                                            String str189 = this.mRealUrl;
                                            str83 = str77;
                                            if (str189 != null) {
                                                str84 = parserHttpHeaderInfo6;
                                                str189 = str189.substring(0, 30);
                                            } else {
                                                str84 = parserHttpHeaderInfo6;
                                            }
                                            sb24.append(str189);
                                            sb24.append(", strategyId=");
                                            DownloadGlobalStrategy.StrategyInfo strategyInfo28 = this.pCurrStrategyInfo;
                                            sb24.append(strategyInfo28 != null ? strategyInfo28.f99899id : 0);
                                            sb24.append(", clientip=");
                                            sb24.append(downloadResult.getContent().clientip);
                                            sb24.append(", getIP=");
                                            str175 = str175;
                                            sb24.append(j47);
                                            sb24.append(", connect:(");
                                            j17 = j47;
                                            sb24.append(this.connect_time);
                                            sb24.append(str188);
                                            sb24.append(this.connect_retry);
                                            sb24.append("), exeReqest:(");
                                            sb24.append(this.exe_time);
                                            sb24.append(str188);
                                            sb24.append(this.exe_retry);
                                            sb24.append("), sendReq=");
                                            sb24.append(this.send_req_time);
                                            sb24.append(", recvData=");
                                            sb24.append(this.t_recv_data);
                                            sb24.append(", Concurrent:(");
                                            sb24.append(getTaskConcurrentCount());
                                            sb24.append("), mobileProxy=");
                                            DownloadTask.DownloadTaskHandler downloadTaskHandler9 = this.mDownloadTaskHandler;
                                            sb24.append(downloadTaskHandler9 != null ? downloadTaskHandler9.getCustomProxy() : null);
                                            String sb25 = sb24.toString();
                                            downloadReport5 = downloadReport;
                                            downloadReport5.logInfo = sb25;
                                            QDLog.w(str185, sb25, null);
                                        }
                                        if (!z29) {
                                            this.mShouldReport = false;
                                        }
                                        DownloadResult.Status status4 = downloadResult.getStatus();
                                        ?? sb26 = new StringBuilder();
                                        sb26.append(getUrl());
                                        sb26.append(" sip=");
                                        sb26.append(str177);
                                        sb26.append(", client=");
                                        sb26.append(downloadResult.getContent().clientip);
                                        sb26.append(", ipType=");
                                        DownloadGlobalStrategy.StrategyInfo strategyInfo29 = this.pCurrStrategyInfo;
                                        sb26.append(strategyInfo29 != null ? strategyInfo29.f99899id : 0);
                                        sb26.append(", httpStatus=");
                                        sb26.append(i39);
                                        sb26.append(str80);
                                        sb26.append(downloadResult.getContent().type);
                                        sb26.append(str74);
                                        sb26.append(downloadResult.getContent().length);
                                        sb26.append(str78);
                                        sb26.append(downloadResult.getContent().size);
                                        sb26.append(r65);
                                        sb26.append(downloadResult.getProcess().duration);
                                        sb26.append(str175);
                                        sb26.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                        if (TextUtils.isEmpty(str82)) {
                                            str85 = "";
                                        } else {
                                            str85 = str81 + str82;
                                        }
                                        sb26.append(str85);
                                        sb26.append(str79);
                                        sb26.append(str84);
                                        status4.detailDownloadInfo = sb26.toString();
                                        DownloadGlobalStrategy.StrategyInfo strategyInfo30 = this.pCurrStrategyInfo;
                                        if (strategyInfo30 == null || DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id != strategyInfo30.f99899id || this.pBackupIPConfigStrategy == null) {
                                            str86 = str83;
                                        } else {
                                            try {
                                                if (!TextUtils.isEmpty(str83)) {
                                                    str86 = str83;
                                                    try {
                                                        this.pBackupIPConfigStrategy.onIPAccessResult(getDomain(), str86, downloadResult.getStatus().isSucceed());
                                                    } catch (Exception e38) {
                                                        e = e38;
                                                        str87 = QDLog.TAG_DOWNLOAD;
                                                        QDLog.w(str87, "Strategy_BACKUPIP ", e);
                                                        strategyInfo6 = this.pCurrStrategyInfo;
                                                        if (strategyInfo6 != null) {
                                                            try {
                                                                if (TextUtils.isEmpty(str86)) {
                                                                }
                                                            } catch (Exception e39) {
                                                                QDLog.w(str87, "Strategy_DomainDirect ", e39);
                                                            }
                                                        }
                                                        if (z29) {
                                                        }
                                                        downloadReport5.endTime = System.currentTimeMillis();
                                                        downloadReport5.fileSize = getContentLength();
                                                        downloadReport5.response = httpResponse9;
                                                        response13 = response12;
                                                        downloadReport5.okResponse = response13;
                                                        downloadReport5.httpStatus = i39;
                                                        downloadReport5.exception = null;
                                                        downloadReport5.dns = dns4 != null ? null : dns4.toString();
                                                        downloadReport5.localAddress = null;
                                                        downloadReport5.clientip = downloadResult.getContent().clientip;
                                                        downloadReport5.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadReport5.downloadTime = downloadResult.getProcess().duration;
                                                        downloadReport5.t_wait = downloadReport5.totaltime - downloadResult.getProcess().duration;
                                                        j28 = j17;
                                                        downloadReport5.t_prepare = j28;
                                                        downloadReport5.t_conn = this.connect_time;
                                                        downloadReport5.t_recvrsp = this.send_req_time;
                                                        downloadReport5.t_recvdata = this.t_recv_data;
                                                        downloadReport5.t_process = 0L;
                                                        downloadReport5.concurrent = getTaskConcurrentCount();
                                                        downloadReport5.content_type = downloadResult.getContent().type;
                                                        downloadReport5.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                        downloadReport5.isHttp2 = this.mIsHttp2;
                                                        String str190 = this.mRealUrl;
                                                        downloadReport5.isHttps = str190 == null && str190.startsWith(str88);
                                                        downloadReport5.isSucceed = downloadResult.getStatus().isSucceed();
                                                        downloadReport5.downloadMode = Downloader.DownloadMode.FastMode.ordinal();
                                                        if (response13 != null) {
                                                            downloadReport5.f99896protocol = response13.protocol().getProtocol();
                                                        }
                                                        downloadResult.setReport(downloadReport5);
                                                        downloadResult4 = downloadResult;
                                                        jobContext4 = jobContext;
                                                        if (downloadResult.getStatus().isSucceed()) {
                                                        }
                                                        if (!this.mIsHttp2) {
                                                        }
                                                        jobContext3 = jobContext4;
                                                        downloadResult3 = downloadResult4;
                                                        i58 = i69;
                                                        j46 = j28;
                                                        if (canAttempt()) {
                                                        }
                                                    }
                                                } else {
                                                    str86 = str83;
                                                    this.pBackupIPConfigStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                }
                                            } catch (Exception e46) {
                                                e = e46;
                                                str86 = str83;
                                            }
                                        }
                                        str87 = QDLog.TAG_DOWNLOAD;
                                        strategyInfo6 = this.pCurrStrategyInfo;
                                        if (strategyInfo6 != null && DownloadGlobalStrategy.Strategy_DomainDirect.f99899id == strategyInfo6.f99899id && this.pDirectIPConfigStrategy != null) {
                                            if (TextUtils.isEmpty(str86)) {
                                                this.pDirectIPConfigStrategy.onIPAccessResult(getDomain(), str86, downloadResult.getStatus().isSucceed());
                                            } else {
                                                this.pDirectIPConfigStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                            }
                                        }
                                        if (z29) {
                                            str88 = "https";
                                        } else {
                                            DownloadGlobalStrategy downloadGlobalStrategy4 = DownloadGlobalStrategy.getInstance(this.mContext);
                                            String str191 = this.mRealUrl;
                                            if (!this.mIsHttp2 || str191 == null) {
                                                str88 = "https";
                                            } else {
                                                str88 = "https";
                                                if (str191.startsWith(str88)) {
                                                    z36 = true;
                                                    downloadGlobalStrategy4.reportHttps(str191, z36, downloadResult.getStatus().isSucceed());
                                                }
                                            }
                                            z36 = false;
                                            downloadGlobalStrategy4.reportHttps(str191, z36, downloadResult.getStatus().isSucceed());
                                        }
                                        downloadReport5.endTime = System.currentTimeMillis();
                                        downloadReport5.fileSize = getContentLength();
                                        downloadReport5.response = httpResponse9;
                                        response13 = response12;
                                        downloadReport5.okResponse = response13;
                                        downloadReport5.httpStatus = i39;
                                        downloadReport5.exception = null;
                                        downloadReport5.dns = dns4 != null ? null : dns4.toString();
                                        downloadReport5.localAddress = null;
                                        downloadReport5.clientip = downloadResult.getContent().clientip;
                                        downloadReport5.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                        downloadReport5.downloadTime = downloadResult.getProcess().duration;
                                        downloadReport5.t_wait = downloadReport5.totaltime - downloadResult.getProcess().duration;
                                        j28 = j17;
                                        downloadReport5.t_prepare = j28;
                                        downloadReport5.t_conn = this.connect_time;
                                        downloadReport5.t_recvrsp = this.send_req_time;
                                        downloadReport5.t_recvdata = this.t_recv_data;
                                        downloadReport5.t_process = 0L;
                                        downloadReport5.concurrent = getTaskConcurrentCount();
                                        downloadReport5.content_type = downloadResult.getContent().type;
                                        downloadReport5.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                        downloadReport5.isHttp2 = this.mIsHttp2;
                                        String str1902 = this.mRealUrl;
                                        downloadReport5.isHttps = str1902 == null && str1902.startsWith(str88);
                                        downloadReport5.isSucceed = downloadResult.getStatus().isSucceed();
                                        downloadReport5.downloadMode = Downloader.DownloadMode.FastMode.ordinal();
                                        if (response13 != null && response13.protocol() != null) {
                                            downloadReport5.f99896protocol = response13.protocol().getProtocol();
                                        }
                                        downloadResult.setReport(downloadReport5);
                                        downloadResult4 = downloadResult;
                                        jobContext4 = jobContext;
                                        if (downloadResult.getStatus().isSucceed()) {
                                            handleDownloadReportForTask(jobContext4, downloadResult4, downloadReport5);
                                        }
                                    }
                                    if (!this.mIsHttp2) {
                                        Call call4 = this.okRequestCall;
                                        if (call4 != null) {
                                            call4.cancel();
                                        }
                                        this.okRequestBuilder = null;
                                    } else {
                                        HttpGet httpGet4 = this.request;
                                        if (httpGet4 != null) {
                                            httpGet4.abort();
                                            this.request = null;
                                        }
                                        cleanExpireConnection();
                                    }
                                    jobContext3 = jobContext4;
                                    downloadResult3 = downloadResult4;
                                    i58 = i69;
                                    j46 = j28;
                                    if (canAttempt()) {
                                    }
                                }
                            }
                            i18 = i58;
                            str5 = ",";
                            str13 = ", remoteAddress=";
                            if (this.pCurrStrategyInfo != null && this.mRealUrl.startsWith("https") && isIpV6Stack && enableIpv6Debug) {
                                this.mRealUrl = this.mRealUrl.replaceFirst("https://", "http://");
                                int i77 = this.mOrigPort;
                                if (i77 > 0) {
                                    this.pCurrStrategyInfo.getIPInfo().port = i77;
                                } else {
                                    i77 = this.pCurrStrategyInfo.getIPInfo().port;
                                }
                                if (!Utils.isPortValid(i77)) {
                                    i77 = 80;
                                }
                                String str192 = "[240e:ff:f040:28::23]:" + i77;
                                String str193 = this.mDomainWithPort;
                                if (str193 != null) {
                                    this.mRealUrl = this.mRealUrl.replaceFirst(str193, str192);
                                }
                                downloadReport8.strategyInfo = this.pCurrStrategyInfo.toString();
                                if (QDLog.isDebugEnable()) {
                                    QDLog.d(QDLog.TAG_DOWNLOAD, "downloader strategy run: " + downloadReport8.strategyInfo + " domain: url:" + getUrl() + " threadId:" + Thread.currentThread().getId());
                                }
                            }
                            strategyInfo2 = this.pCurrStrategyInfo;
                            if (strategyInfo2 != null) {
                            }
                            if (!this.mIsHttp2) {
                            }
                            this.request = HttpUtil.createHttpGet(this.mContext, getUrl(), getDomain(), this.mRealUrl, this.mRefer, requestOptions);
                            resumeTransfer = this.pResumeTransfer;
                            if (resumeTransfer != null) {
                            }
                            prepareRequest(getUrl(), getDomain(), this.request, this.okRequestBuilder);
                            downloadReport = downloadReport8;
                            ?? r1422 = uptimeMillis;
                            i16 = i18;
                            applyKeepAliveStrategy(getUrl(), getDomain(), this.request, this.okRequestBuilder, requestOptions);
                            ?? currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                            this.send_req_time = 0L;
                            long uptimeMillis22 = SystemClock.uptimeMillis();
                            if (this.request == null) {
                            }
                            this.send_req_time = SystemClock.uptimeMillis() - uptimeMillis22;
                            if (execute != null) {
                            }
                            if (execute == null) {
                            }
                            if (response2 == null) {
                            }
                        } else {
                            downloadReport = downloadReport8;
                            j3 = uptimeMillis;
                            i16 = i58;
                            str = " , requestHttp2=";
                            str2 = "https";
                            str3 = ", dns=";
                            str4 = ", protocol=";
                            str5 = ",";
                            str6 = ", remoteAddress=";
                            str7 = QDLog.TAG_DOWNLOAD_RESULT;
                            str8 = ", localAddress=";
                            str9 = ", redirectURI=";
                            str10 = ", contentType=";
                            str11 = QDLog.TAG_DOWNLOAD;
                            try {
                                throw e;
                                break;
                            } catch (Throwable th24) {
                                str138 = str138;
                                str139 = str139;
                                str136 = str136;
                                str137 = str137;
                                j16 = j46;
                                httpContext = null;
                                response = null;
                                httpResponse = null;
                                i17 = 0;
                                th5 = th24;
                            }
                        }
                        downloadResult.getStatus().setFailed(th5);
                        str117 = this.mRealUrl;
                        str93 = "";
                        if (str117 != null) {
                            try {
                                if (str117.startsWith("https:")) {
                                    this.disableHttps = true;
                                    i49 = i16 - 1;
                                    QDLog.e(str7, "https exception, disable it and retry! ");
                                    int i592222222 = i49 + 1;
                                    String str1402222222 = str11;
                                    downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                    downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                    downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                    NetworkUtils.DNS dns72222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                    DownloadGlobalStrategy.StrategyInfo strategyInfo92222222 = this.pCurrStrategyInfo;
                                    String str194 = (strategyInfo92222222 != null || strategyInfo92222222.getIPInfo() == null) ? null : this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                    String parserHttpHeaderInfo2222222 = parserHttpHeaderInfo(this.request, httpResponse, response);
                                    if (httpContext == null) {
                                        try {
                                            str118 = (String) httpContext.getAttribute("RedirectURI");
                                        } catch (Exception unused10) {
                                            str118 = str93;
                                        }
                                        try {
                                            str119 = (String) httpContext.getAttribute("RealRemoteAddr");
                                        } catch (Exception unused11) {
                                            str119 = str93;
                                        }
                                    } else {
                                        str119 = str93;
                                        str118 = str119;
                                    }
                                    downloadResult.getContent().redirectUrl = str118;
                                    Throwable th112222222 = th5;
                                    String str1412222222 = str118;
                                    this.connect_time = 0L;
                                    this.connect_retry = 0;
                                    this.exe_time = 0L;
                                    this.exe_retry = 0;
                                    if ((downloadResult.getStatus().isSucceed() || jobContext.isCancelled()) && (resumeTransfer7 = this.pResumeTransfer) != null) {
                                        resumeTransfer7.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse, response);
                                    }
                                    if (jobContext.isCancelled()) {
                                        boolean isNetworkAvailable5 = NetworkUtils.isNetworkAvailable(this.mContext);
                                        if (!downloadResult.getStatus().isSucceed()) {
                                            StringBuilder sb27 = new StringBuilder();
                                            sb27.append("Downloader, fail to download:");
                                            sb27.append(getUrl());
                                            sb27.append(str);
                                            sb27.append(this.mIsHttp2);
                                            sb27.append(str4);
                                            if (this.mIsHttp2 && response != null && response.protocol() != null) {
                                                str134 = response.protocol().getProtocol();
                                            }
                                            sb27.append(str134);
                                            sb27.append(str3);
                                            sb27.append(dns72222222);
                                            sb27.append(str6);
                                            sb27.append(str194);
                                            sb27.append(str8);
                                            sb27.append((String) null);
                                            sb27.append(", thread=");
                                            sb27.append(Thread.currentThread().getId());
                                            sb27.append(", apn=");
                                            sb27.append(NetworkManager.getApnValue());
                                            sb27.append(", allowProxy=");
                                            sb27.append(this.mAllowProxy);
                                            sb27.append(", apnProxy=");
                                            sb27.append(this.mAPNProxy);
                                            sb27.append(", useProxy=");
                                            sb27.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                            sb27.append(", netAvailable=");
                                            sb27.append(isNetworkAvailable5);
                                            sb27.append(", realRemoteAddr=");
                                            sb27.append(str119);
                                            sb27.append(", IpStack=");
                                            sb27.append(Config.getNetworkStackType());
                                            sb27.append(str90);
                                            sb27.append(downloadResult.getContent().type);
                                            sb27.append(str139);
                                            sb27.append(downloadResult.getProcess().duration);
                                            sb27.append(str138);
                                            httpResponse12 = httpResponse;
                                            sb27.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                            str121 = str137;
                                            sb27.append(str121);
                                            sb27.append(downloadResult.getContent().length);
                                            sb27.append(str136);
                                            sb27.append(downloadResult.getContent().size);
                                            sb27.append(", realsize=");
                                            sb27.append(downloadResult.getContent().realsize);
                                            sb27.append(", retry=(");
                                            sb27.append(getCurrAttemptCount());
                                            String str195 = str5;
                                            sb27.append(str195);
                                            sb27.append(getTotalAttemptCount());
                                            sb27.append("), reason=");
                                            sb27.append(downloadResult.getStatus().getFailReason());
                                            sb27.append(", httpStatus=");
                                            int i78 = i17;
                                            sb27.append(i78);
                                            sb27.append(", ");
                                            sb27.append(parserHttpHeaderInfo2222222);
                                            String str196 = str9;
                                            sb27.append(str196);
                                            z39 = isNetworkAvailable5;
                                            sb27.append(str1412222222);
                                            sb27.append(", ipUrl:");
                                            String str197 = this.mRealUrl;
                                            if (str197 != null) {
                                                str129 = ", ";
                                                str197 = str197.substring(0, 30);
                                            } else {
                                                str129 = ", ";
                                            }
                                            sb27.append(str197);
                                            sb27.append(", strategyId=");
                                            DownloadGlobalStrategy.StrategyInfo strategyInfo31 = this.pCurrStrategyInfo;
                                            sb27.append(strategyInfo31 != null ? strategyInfo31.f99899id : 0);
                                            sb27.append(", clientip=");
                                            sb27.append(downloadResult.getContent().clientip);
                                            sb27.append(", getIP=");
                                            long j48 = j16;
                                            sb27.append(j48);
                                            sb27.append(", connect:(");
                                            sb27.append(this.connect_time);
                                            sb27.append(str195);
                                            sb27.append(this.connect_retry);
                                            sb27.append("), exeReqest:(");
                                            sb27.append(this.exe_time);
                                            sb27.append(str195);
                                            sb27.append(this.exe_retry);
                                            sb27.append("), sendReq=");
                                            sb27.append(this.send_req_time);
                                            sb27.append(", recvData=");
                                            sb27.append(this.t_recv_data);
                                            sb27.append(", Concurrent:(");
                                            sb27.append(getTaskConcurrentCount());
                                            sb27.append("), mobileProxy=");
                                            DownloadTask.DownloadTaskHandler downloadTaskHandler10 = this.mDownloadTaskHandler;
                                            sb27.append(downloadTaskHandler10 != null ? downloadTaskHandler10.getCustomProxy() : null);
                                            String sb28 = sb27.toString();
                                            DownloadReport downloadReport9 = downloadReport;
                                            downloadReport9.logInfo = sb28;
                                            QDLog.e(str7, sb28, th112222222);
                                            if (this.mRealUrl != null) {
                                                QDLog.d("FastDownloadTask", "fast force dns first is " + Config.isForceDNSFirst());
                                                CustomDnsResolve.setIPDirectEnable(getDomain(), Config.isForceDNSFirst());
                                            }
                                            dns6 = dns72222222;
                                            str128 = parserHttpHeaderInfo2222222;
                                            str127 = str119;
                                            th9 = th112222222;
                                            str126 = str1412222222;
                                            downloadReport7 = downloadReport9;
                                            str124 = str90;
                                            str125 = str196;
                                            i56 = i78;
                                            str120 = str136;
                                            str122 = str138;
                                            str123 = str139;
                                            j39 = j48;
                                            response17 = response;
                                        } else {
                                            String str198 = str7;
                                            z39 = isNetworkAvailable5;
                                            httpResponse12 = httpResponse;
                                            th9 = th112222222;
                                            str120 = str136;
                                            str121 = str137;
                                            str122 = str138;
                                            String str199 = str9;
                                            int i79 = i17;
                                            j39 = j16;
                                            str123 = str139;
                                            StringBuilder sb29 = new StringBuilder();
                                            sb29.append("Downloader, succeed to download:");
                                            sb29.append(getUrl());
                                            sb29.append(str);
                                            sb29.append(this.mIsHttp2);
                                            sb29.append(str4);
                                            if (this.mIsHttp2 && response != null && response.protocol() != null) {
                                                str134 = response.protocol().getProtocol();
                                            }
                                            sb29.append(str134);
                                            sb29.append(str3);
                                            sb29.append(dns72222222);
                                            sb29.append(str6);
                                            sb29.append(str194);
                                            sb29.append(str8);
                                            sb29.append((String) null);
                                            sb29.append(", thread=");
                                            sb29.append(Thread.currentThread().getId());
                                            sb29.append(", apn=");
                                            sb29.append(NetworkManager.getApnValue());
                                            sb29.append(", allowProxy=");
                                            sb29.append(this.mAllowProxy);
                                            sb29.append(", apnProxy=");
                                            sb29.append(this.mAPNProxy);
                                            sb29.append(", useProxy=");
                                            sb29.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                            sb29.append(", IpStack=");
                                            sb29.append(Config.getNetworkStackType());
                                            sb29.append(", realRemoteAddr=");
                                            sb29.append(str119);
                                            sb29.append(str123);
                                            sb29.append(downloadResult.getProcess().duration);
                                            sb29.append(str122);
                                            sb29.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                            sb29.append(str121);
                                            sb29.append(downloadResult.getContent().length);
                                            sb29.append(str120);
                                            sb29.append(downloadResult.getContent().size);
                                            sb29.append(", realsize=");
                                            sb29.append(downloadResult.getContent().realsize);
                                            sb29.append(", retry=(");
                                            sb29.append(getCurrAttemptCount());
                                            String str200 = str5;
                                            sb29.append(str200);
                                            sb29.append(getTotalAttemptCount());
                                            sb29.append("), httpStatus=");
                                            i56 = i79;
                                            sb29.append(i56);
                                            sb29.append(", ");
                                            sb29.append(parserHttpHeaderInfo2222222);
                                            str124 = str90;
                                            sb29.append(str124);
                                            sb29.append(downloadResult.getContent().type);
                                            str125 = str199;
                                            sb29.append(str125);
                                            dns6 = dns72222222;
                                            str126 = str1412222222;
                                            sb29.append(str126);
                                            response17 = response;
                                            sb29.append(", ipUrl:");
                                            String str201 = this.mRealUrl;
                                            str127 = str119;
                                            if (str201 != null) {
                                                str128 = parserHttpHeaderInfo2222222;
                                                str201 = str201.substring(0, 30);
                                            } else {
                                                str128 = parserHttpHeaderInfo2222222;
                                            }
                                            sb29.append(str201);
                                            sb29.append(", strategyId=");
                                            DownloadGlobalStrategy.StrategyInfo strategyInfo32 = this.pCurrStrategyInfo;
                                            sb29.append(strategyInfo32 != null ? strategyInfo32.f99899id : 0);
                                            sb29.append(", clientip=");
                                            sb29.append(downloadResult.getContent().clientip);
                                            sb29.append(", getIP=");
                                            str129 = ", ";
                                            sb29.append(j39);
                                            sb29.append(", connect:(");
                                            sb29.append(this.connect_time);
                                            sb29.append(str200);
                                            sb29.append(this.connect_retry);
                                            sb29.append("), exeReqest:(");
                                            sb29.append(this.exe_time);
                                            sb29.append(str200);
                                            sb29.append(this.exe_retry);
                                            sb29.append("), sendReq=");
                                            sb29.append(this.send_req_time);
                                            sb29.append(", recvData=");
                                            sb29.append(this.t_recv_data);
                                            sb29.append(", Concurrent:(");
                                            sb29.append(getTaskConcurrentCount());
                                            sb29.append("), mobileProxy=");
                                            DownloadTask.DownloadTaskHandler downloadTaskHandler11 = this.mDownloadTaskHandler;
                                            sb29.append(downloadTaskHandler11 != null ? downloadTaskHandler11.getCustomProxy() : null);
                                            String sb30 = sb29.toString();
                                            downloadReport7 = downloadReport;
                                            downloadReport7.logInfo = sb30;
                                            QDLog.w(str198, sb30, null);
                                        }
                                        if (!z39) {
                                            this.mShouldReport = false;
                                        }
                                        DownloadResult.Status status5 = downloadResult.getStatus();
                                        StringBuilder sb31 = new StringBuilder();
                                        sb31.append(getUrl());
                                        sb31.append(" sip=");
                                        sb31.append(str194);
                                        sb31.append(", client=");
                                        sb31.append(downloadResult.getContent().clientip);
                                        sb31.append(", ipType=");
                                        DownloadGlobalStrategy.StrategyInfo strategyInfo33 = this.pCurrStrategyInfo;
                                        sb31.append(strategyInfo33 != null ? strategyInfo33.f99899id : 0);
                                        sb31.append(", httpStatus=");
                                        sb31.append(i56);
                                        sb31.append(str124);
                                        sb31.append(downloadResult.getContent().type);
                                        sb31.append(str121);
                                        sb31.append(downloadResult.getContent().length);
                                        sb31.append(str120);
                                        sb31.append(downloadResult.getContent().size);
                                        sb31.append(str123);
                                        sb31.append(downloadResult.getProcess().duration);
                                        sb31.append(str122);
                                        sb31.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                        if (TextUtils.isEmpty(str126)) {
                                            str130 = str93;
                                        } else {
                                            str130 = str125 + str126;
                                        }
                                        sb31.append(str130);
                                        sb31.append(str129);
                                        sb31.append(str128);
                                        status5.detailDownloadInfo = sb31.toString();
                                        DownloadGlobalStrategy.StrategyInfo strategyInfo34 = this.pCurrStrategyInfo;
                                        if (strategyInfo34 == null || DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id != strategyInfo34.f99899id || this.pBackupIPConfigStrategy == null) {
                                            str131 = str127;
                                        } else {
                                            try {
                                                if (!TextUtils.isEmpty(str127)) {
                                                    str131 = str127;
                                                    try {
                                                        this.pBackupIPConfigStrategy.onIPAccessResult(getDomain(), str131, downloadResult.getStatus().isSucceed());
                                                    } catch (Exception e47) {
                                                        e = e47;
                                                        str132 = str1402222222;
                                                        QDLog.w(str132, "Strategy_BACKUPIP ", e);
                                                        strategyInfo8 = this.pCurrStrategyInfo;
                                                        if (strategyInfo8 != null) {
                                                            try {
                                                                if (TextUtils.isEmpty(str131)) {
                                                                }
                                                            } catch (Exception e48) {
                                                                QDLog.w(str132, "Strategy_DomainDirect ", e48);
                                                            }
                                                        }
                                                        if (z39) {
                                                        }
                                                        downloadReport7.endTime = System.currentTimeMillis();
                                                        downloadReport7.fileSize = getContentLength();
                                                        downloadReport7.response = httpResponse12;
                                                        response18 = response17;
                                                        downloadReport7.okResponse = response18;
                                                        downloadReport7.httpStatus = i56;
                                                        downloadReport7.exception = th9;
                                                        downloadReport7.dns = dns6 != null ? null : dns6.toString();
                                                        downloadReport7.localAddress = null;
                                                        downloadReport7.clientip = downloadResult.getContent().clientip;
                                                        downloadReport7.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadReport7.downloadTime = downloadResult.getProcess().duration;
                                                        downloadReport7.t_wait = downloadReport7.totaltime - downloadResult.getProcess().duration;
                                                        j38 = j39;
                                                        downloadReport7.t_prepare = j38;
                                                        downloadReport7.t_conn = this.connect_time;
                                                        downloadReport7.t_recvrsp = this.send_req_time;
                                                        downloadReport7.t_recvdata = this.t_recv_data;
                                                        downloadReport7.t_process = 0L;
                                                        downloadReport7.concurrent = getTaskConcurrentCount();
                                                        downloadReport7.content_type = downloadResult.getContent().type;
                                                        downloadReport7.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                        downloadReport7.isHttp2 = this.mIsHttp2;
                                                        String str202 = this.mRealUrl;
                                                        downloadReport7.isHttps = str202 == null && str202.startsWith(str133);
                                                        downloadReport7.isSucceed = downloadResult.getStatus().isSucceed();
                                                        downloadReport7.downloadMode = Downloader.DownloadMode.FastMode.ordinal();
                                                        if (response18 != null) {
                                                            downloadReport7.f99896protocol = response18.protocol().getProtocol();
                                                        }
                                                        downloadResult3 = downloadResult;
                                                        downloadResult3.setReport(downloadReport7);
                                                        jobContext3 = jobContext;
                                                        if (downloadResult.getStatus().isSucceed()) {
                                                        }
                                                        if (this.mIsHttp2) {
                                                        }
                                                        i58 = i592222222;
                                                        j46 = j38;
                                                        if (canAttempt()) {
                                                        }
                                                    }
                                                } else {
                                                    str131 = str127;
                                                    this.pBackupIPConfigStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                }
                                            } catch (Exception e49) {
                                                e = e49;
                                                str131 = str127;
                                            }
                                        }
                                        str132 = str1402222222;
                                        strategyInfo8 = this.pCurrStrategyInfo;
                                        if (strategyInfo8 != null && DownloadGlobalStrategy.Strategy_DomainDirect.f99899id == strategyInfo8.f99899id && this.pDirectIPConfigStrategy != null) {
                                            if (TextUtils.isEmpty(str131)) {
                                                this.pDirectIPConfigStrategy.onIPAccessResult(getDomain(), str131, downloadResult.getStatus().isSucceed());
                                            } else {
                                                this.pDirectIPConfigStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                            }
                                        }
                                        if (z39) {
                                            str133 = str2;
                                        } else {
                                            DownloadGlobalStrategy downloadGlobalStrategy5 = DownloadGlobalStrategy.getInstance(this.mContext);
                                            String str203 = this.mRealUrl;
                                            if (!this.mIsHttp2 || str203 == null) {
                                                str133 = str2;
                                            } else {
                                                str133 = str2;
                                                if (str203.startsWith(str133)) {
                                                    z46 = true;
                                                    downloadGlobalStrategy5.reportHttps(str203, z46, downloadResult.getStatus().isSucceed());
                                                }
                                            }
                                            z46 = false;
                                            downloadGlobalStrategy5.reportHttps(str203, z46, downloadResult.getStatus().isSucceed());
                                        }
                                        downloadReport7.endTime = System.currentTimeMillis();
                                        downloadReport7.fileSize = getContentLength();
                                        downloadReport7.response = httpResponse12;
                                        response18 = response17;
                                        downloadReport7.okResponse = response18;
                                        downloadReport7.httpStatus = i56;
                                        downloadReport7.exception = th9;
                                        downloadReport7.dns = dns6 != null ? null : dns6.toString();
                                        downloadReport7.localAddress = null;
                                        downloadReport7.clientip = downloadResult.getContent().clientip;
                                        downloadReport7.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                        downloadReport7.downloadTime = downloadResult.getProcess().duration;
                                        downloadReport7.t_wait = downloadReport7.totaltime - downloadResult.getProcess().duration;
                                        j38 = j39;
                                        downloadReport7.t_prepare = j38;
                                        downloadReport7.t_conn = this.connect_time;
                                        downloadReport7.t_recvrsp = this.send_req_time;
                                        downloadReport7.t_recvdata = this.t_recv_data;
                                        downloadReport7.t_process = 0L;
                                        downloadReport7.concurrent = getTaskConcurrentCount();
                                        downloadReport7.content_type = downloadResult.getContent().type;
                                        downloadReport7.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                        downloadReport7.isHttp2 = this.mIsHttp2;
                                        String str2022 = this.mRealUrl;
                                        downloadReport7.isHttps = str2022 == null && str2022.startsWith(str133);
                                        downloadReport7.isSucceed = downloadResult.getStatus().isSucceed();
                                        downloadReport7.downloadMode = Downloader.DownloadMode.FastMode.ordinal();
                                        if (response18 != null && response18.protocol() != null) {
                                            downloadReport7.f99896protocol = response18.protocol().getProtocol();
                                        }
                                        downloadResult3 = downloadResult;
                                        downloadResult3.setReport(downloadReport7);
                                        jobContext3 = jobContext;
                                        if (downloadResult.getStatus().isSucceed()) {
                                            handleDownloadReportForTask(jobContext3, downloadResult3, downloadReport7);
                                        }
                                    } else {
                                        jobContext3 = jobContext;
                                        downloadResult3 = downloadResult;
                                        j38 = j16;
                                    }
                                    if (this.mIsHttp2) {
                                        Call call5 = this.okRequestCall;
                                        if (call5 != null) {
                                            call5.cancel();
                                        }
                                        this.okRequestBuilder = null;
                                    } else {
                                        HttpGet httpGet5 = this.request;
                                        if (httpGet5 != null) {
                                            httpGet5.abort();
                                            this.request = null;
                                        }
                                        cleanExpireConnection();
                                    }
                                    i58 = i592222222;
                                    j46 = j38;
                                    if (canAttempt()) {
                                    }
                                }
                            } catch (Throwable th25) {
                                th6 = th25;
                                str91 = str7;
                                httpContext3 = httpContext;
                                response14 = response;
                                th7 = th5;
                                str94 = str11;
                                str95 = str90;
                                str96 = ", ";
                                str97 = str136;
                                str98 = str138;
                                str99 = str2;
                                str100 = str9;
                                i46 = i17;
                                j29 = j16;
                                str92 = str6;
                                j36 = j3;
                                httpResponse10 = httpResponse;
                                str101 = str137;
                                str102 = str139;
                                String str204 = str98;
                                String str205 = str101;
                                downloadResult.getProcess().setDuration(j36, SystemClock.uptimeMillis());
                                downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                NetworkUtils.DNS dns12 = NetworkStatus.getInstance(this.mContext).getDNS();
                                DownloadGlobalStrategy.StrategyInfo strategyInfo35 = this.pCurrStrategyInfo;
                                String str206 = (strategyInfo35 == null || strategyInfo35.getIPInfo() == null) ? null : this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                String parserHttpHeaderInfo7 = parserHttpHeaderInfo(this.request, httpResponse10, response14);
                                if (httpContext3 != null) {
                                    try {
                                        str103 = (String) httpContext3.getAttribute("RedirectURI");
                                    } catch (Exception unused12) {
                                        str103 = str93;
                                    }
                                    try {
                                        str104 = (String) httpContext3.getAttribute("RealRemoteAddr");
                                    } catch (Exception unused13) {
                                        str104 = str93;
                                    }
                                } else {
                                    str104 = str93;
                                    str103 = str104;
                                }
                                downloadResult.getContent().redirectUrl = str103;
                                String str207 = str103;
                                this.connect_time = 0L;
                                this.connect_retry = 0;
                                this.exe_time = 0L;
                                this.exe_retry = 0;
                                if ((!downloadResult.getStatus().isSucceed() || jobContext.isCancelled()) && (resumeTransfer6 = this.pResumeTransfer) != null) {
                                    resumeTransfer6.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse10, response14);
                                }
                                if (!jobContext.isCancelled()) {
                                    boolean isNetworkAvailable6 = NetworkUtils.isNetworkAvailable(this.mContext);
                                    if (!downloadResult.getStatus().isSucceed()) {
                                        StringBuilder sb32 = new StringBuilder();
                                        sb32.append("Downloader, fail to download:");
                                        sb32.append(getUrl());
                                        sb32.append(str);
                                        sb32.append(this.mIsHttp2);
                                        sb32.append(str4);
                                        if (this.mIsHttp2 && response14 != null && response14.protocol() != null) {
                                            str134 = response14.protocol().getProtocol();
                                        }
                                        sb32.append(str134);
                                        sb32.append(str3);
                                        sb32.append(dns12);
                                        sb32.append(str92);
                                        sb32.append(str206);
                                        sb32.append(str8);
                                        sb32.append((String) null);
                                        sb32.append(", thread=");
                                        sb32.append(Thread.currentThread().getId());
                                        sb32.append(", apn=");
                                        sb32.append(NetworkManager.getApnValue());
                                        sb32.append(", allowProxy=");
                                        sb32.append(this.mAllowProxy);
                                        sb32.append(", apnProxy=");
                                        sb32.append(this.mAPNProxy);
                                        sb32.append(", useProxy=");
                                        sb32.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                        sb32.append(", netAvailable=");
                                        sb32.append(isNetworkAvailable6);
                                        sb32.append(", realRemoteAddr=");
                                        sb32.append(str104);
                                        sb32.append(", IpStack=");
                                        sb32.append(Config.getNetworkStackType());
                                        sb32.append(str95);
                                        sb32.append(downloadResult.getContent().type);
                                        sb32.append(str102);
                                        sb32.append(downloadResult.getProcess().duration);
                                        str107 = str204;
                                        sb32.append(str107);
                                        sb32.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                        sb32.append(str205);
                                        sb32.append(downloadResult.getContent().length);
                                        String str208 = str97;
                                        sb32.append(str208);
                                        sb32.append(downloadResult.getContent().size);
                                        sb32.append(", realsize=");
                                        sb32.append(downloadResult.getContent().realsize);
                                        sb32.append(", retry=(");
                                        sb32.append(getCurrAttemptCount());
                                        String str209 = str5;
                                        sb32.append(str209);
                                        sb32.append(getTotalAttemptCount());
                                        sb32.append("), reason=");
                                        sb32.append(downloadResult.getStatus().getFailReason());
                                        sb32.append(", httpStatus=");
                                        int i85 = i46;
                                        sb32.append(i85);
                                        String str210 = str96;
                                        sb32.append(str210);
                                        httpResponse11 = httpResponse10;
                                        sb32.append(parserHttpHeaderInfo7);
                                        z37 = isNetworkAvailable6;
                                        String str211 = str100;
                                        sb32.append(str211);
                                        sb32.append(str207);
                                        sb32.append(", ipUrl:");
                                        String str212 = this.mRealUrl;
                                        if (str212 != null) {
                                            i48 = i85;
                                            str212 = str212.substring(0, 30);
                                        } else {
                                            i48 = i85;
                                        }
                                        sb32.append(str212);
                                        sb32.append(", strategyId=");
                                        DownloadGlobalStrategy.StrategyInfo strategyInfo36 = this.pCurrStrategyInfo;
                                        sb32.append(strategyInfo36 != null ? strategyInfo36.f99899id : 0);
                                        sb32.append(", clientip=");
                                        sb32.append(downloadResult.getContent().clientip);
                                        sb32.append(", getIP=");
                                        long j49 = j29;
                                        sb32.append(j49);
                                        sb32.append(", connect:(");
                                        j37 = j49;
                                        sb32.append(this.connect_time);
                                        sb32.append(str209);
                                        sb32.append(this.connect_retry);
                                        sb32.append("), exeReqest:(");
                                        sb32.append(this.exe_time);
                                        sb32.append(str209);
                                        sb32.append(this.exe_retry);
                                        sb32.append("), sendReq=");
                                        sb32.append(this.send_req_time);
                                        sb32.append(", recvData=");
                                        sb32.append(this.t_recv_data);
                                        sb32.append(", Concurrent:(");
                                        sb32.append(getTaskConcurrentCount());
                                        sb32.append("), mobileProxy=");
                                        DownloadTask.DownloadTaskHandler downloadTaskHandler12 = this.mDownloadTaskHandler;
                                        sb32.append(downloadTaskHandler12 != null ? downloadTaskHandler12.getCustomProxy() : null);
                                        String sb33 = sb32.toString();
                                        DownloadReport downloadReport10 = downloadReport;
                                        downloadReport10.logInfo = sb33;
                                        Throwable th26 = th7;
                                        QDLog.e(str91, sb33, th26);
                                        if (this.mRealUrl != null) {
                                            QDLog.d("FastDownloadTask", "fast force dns first is " + Config.isForceDNSFirst());
                                            CustomDnsResolve.setIPDirectEnable(getDomain(), Config.isForceDNSFirst());
                                        }
                                        str113 = parserHttpHeaderInfo7;
                                        str112 = str104;
                                        dns5 = dns12;
                                        str111 = str207;
                                        th8 = th26;
                                        str109 = str95;
                                        str108 = str210;
                                        i47 = i48;
                                        str110 = str211;
                                        str105 = str208;
                                        str106 = str205;
                                        response15 = response14;
                                        downloadReport6 = downloadReport10;
                                    } else {
                                        httpResponse11 = httpResponse10;
                                        String str213 = str95;
                                        str105 = str97;
                                        str106 = str205;
                                        str107 = str204;
                                        String str214 = str91;
                                        long j56 = j29;
                                        String str215 = str100;
                                        String str216 = str96;
                                        th8 = th7;
                                        z37 = isNetworkAvailable6;
                                        StringBuilder sb34 = new StringBuilder();
                                        sb34.append("Downloader, succeed to download:");
                                        sb34.append(getUrl());
                                        sb34.append(str);
                                        sb34.append(this.mIsHttp2);
                                        sb34.append(str4);
                                        if (this.mIsHttp2 && response14 != null && response14.protocol() != null) {
                                            str134 = response14.protocol().getProtocol();
                                        }
                                        sb34.append(str134);
                                        sb34.append(str3);
                                        sb34.append(dns12);
                                        sb34.append(str92);
                                        sb34.append(str206);
                                        sb34.append(str8);
                                        sb34.append((String) null);
                                        sb34.append(", thread=");
                                        sb34.append(Thread.currentThread().getId());
                                        sb34.append(", apn=");
                                        sb34.append(NetworkManager.getApnValue());
                                        sb34.append(", allowProxy=");
                                        sb34.append(this.mAllowProxy);
                                        sb34.append(", apnProxy=");
                                        sb34.append(this.mAPNProxy);
                                        sb34.append(", useProxy=");
                                        sb34.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                        sb34.append(", IpStack=");
                                        sb34.append(Config.getNetworkStackType());
                                        sb34.append(", realRemoteAddr=");
                                        sb34.append(str104);
                                        sb34.append(str102);
                                        sb34.append(downloadResult.getProcess().duration);
                                        sb34.append(str107);
                                        sb34.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                        sb34.append(str106);
                                        sb34.append(downloadResult.getContent().length);
                                        sb34.append(str105);
                                        sb34.append(downloadResult.getContent().size);
                                        sb34.append(", realsize=");
                                        sb34.append(downloadResult.getContent().realsize);
                                        sb34.append(", retry=(");
                                        sb34.append(getCurrAttemptCount());
                                        String str217 = str5;
                                        sb34.append(str217);
                                        sb34.append(getTotalAttemptCount());
                                        sb34.append("), httpStatus=");
                                        i47 = i46;
                                        sb34.append(i47);
                                        str108 = str216;
                                        sb34.append(str108);
                                        sb34.append(parserHttpHeaderInfo7);
                                        str109 = str213;
                                        sb34.append(str109);
                                        sb34.append(downloadResult.getContent().type);
                                        str110 = str215;
                                        sb34.append(str110);
                                        dns5 = dns12;
                                        str111 = str207;
                                        sb34.append(str111);
                                        response15 = response14;
                                        sb34.append(", ipUrl:");
                                        String str218 = this.mRealUrl;
                                        str112 = str104;
                                        if (str218 != null) {
                                            str113 = parserHttpHeaderInfo7;
                                            str218 = str218.substring(0, 30);
                                        } else {
                                            str113 = parserHttpHeaderInfo7;
                                        }
                                        sb34.append(str218);
                                        sb34.append(", strategyId=");
                                        DownloadGlobalStrategy.StrategyInfo strategyInfo37 = this.pCurrStrategyInfo;
                                        sb34.append(strategyInfo37 != null ? strategyInfo37.f99899id : 0);
                                        sb34.append(", clientip=");
                                        sb34.append(downloadResult.getContent().clientip);
                                        sb34.append(", getIP=");
                                        sb34.append(j56);
                                        sb34.append(", connect:(");
                                        j37 = j56;
                                        sb34.append(this.connect_time);
                                        sb34.append(str217);
                                        sb34.append(this.connect_retry);
                                        sb34.append("), exeReqest:(");
                                        sb34.append(this.exe_time);
                                        sb34.append(str217);
                                        sb34.append(this.exe_retry);
                                        sb34.append("), sendReq=");
                                        sb34.append(this.send_req_time);
                                        sb34.append(", recvData=");
                                        sb34.append(this.t_recv_data);
                                        sb34.append(", Concurrent:(");
                                        sb34.append(getTaskConcurrentCount());
                                        sb34.append("), mobileProxy=");
                                        DownloadTask.DownloadTaskHandler downloadTaskHandler13 = this.mDownloadTaskHandler;
                                        sb34.append(downloadTaskHandler13 != null ? downloadTaskHandler13.getCustomProxy() : null);
                                        String sb35 = sb34.toString();
                                        downloadReport6 = downloadReport;
                                        downloadReport6.logInfo = sb35;
                                        QDLog.w(str214, sb35, null);
                                    }
                                    if (!z37) {
                                        this.mShouldReport = false;
                                    }
                                    DownloadResult.Status status6 = downloadResult.getStatus();
                                    StringBuilder sb36 = new StringBuilder();
                                    sb36.append(getUrl());
                                    sb36.append(" sip=");
                                    sb36.append(str206);
                                    sb36.append(", client=");
                                    sb36.append(downloadResult.getContent().clientip);
                                    sb36.append(", ipType=");
                                    DownloadGlobalStrategy.StrategyInfo strategyInfo38 = this.pCurrStrategyInfo;
                                    sb36.append(strategyInfo38 != null ? strategyInfo38.f99899id : 0);
                                    sb36.append(", httpStatus=");
                                    sb36.append(i47);
                                    sb36.append(str109);
                                    sb36.append(downloadResult.getContent().type);
                                    sb36.append(str106);
                                    sb36.append(downloadResult.getContent().length);
                                    sb36.append(str105);
                                    sb36.append(downloadResult.getContent().size);
                                    sb36.append(str102);
                                    sb36.append(downloadResult.getProcess().duration);
                                    sb36.append(str107);
                                    sb36.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                    if (TextUtils.isEmpty(str111)) {
                                        str114 = str93;
                                    } else {
                                        str114 = str110 + str111;
                                    }
                                    sb36.append(str114);
                                    sb36.append(str108);
                                    sb36.append(str113);
                                    status6.detailDownloadInfo = sb36.toString();
                                    DownloadGlobalStrategy.StrategyInfo strategyInfo39 = this.pCurrStrategyInfo;
                                    if (strategyInfo39 == null || DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id != strategyInfo39.f99899id || this.pBackupIPConfigStrategy == null) {
                                        str111 = str112;
                                    } else {
                                        try {
                                        } catch (Exception e56) {
                                            e = e56;
                                            str111 = str112;
                                        }
                                        try {
                                            if (!TextUtils.isEmpty(str112)) {
                                                str111 = str112;
                                                this.pBackupIPConfigStrategy.onIPAccessResult(getDomain(), str111, downloadResult.getStatus().isSucceed());
                                            } else {
                                                str111 = str112;
                                                this.pBackupIPConfigStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                            }
                                        } catch (Exception e57) {
                                            e = e57;
                                            str115 = str94;
                                            QDLog.w(str115, "Strategy_BACKUPIP ", e);
                                            strategyInfo7 = this.pCurrStrategyInfo;
                                            if (strategyInfo7 != null) {
                                                try {
                                                    if (TextUtils.isEmpty(str111)) {
                                                    }
                                                } catch (Exception e58) {
                                                    QDLog.w(str115, "Strategy_DomainDirect ", e58);
                                                }
                                            }
                                            if (z37) {
                                            }
                                            downloadReport6.endTime = System.currentTimeMillis();
                                            downloadReport6.fileSize = getContentLength();
                                            downloadReport6.response = httpResponse11;
                                            response16 = response15;
                                            downloadReport6.okResponse = response16;
                                            downloadReport6.httpStatus = i47;
                                            downloadReport6.exception = th8;
                                            downloadReport6.dns = dns5 != null ? null : dns5.toString();
                                            downloadReport6.localAddress = null;
                                            downloadReport6.clientip = downloadResult.getContent().clientip;
                                            downloadReport6.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                            downloadReport6.downloadTime = downloadResult.getProcess().duration;
                                            downloadReport6.t_wait = downloadReport6.totaltime - downloadResult.getProcess().duration;
                                            downloadReport6.t_prepare = j37;
                                            downloadReport6.t_conn = this.connect_time;
                                            downloadReport6.t_recvrsp = this.send_req_time;
                                            downloadReport6.t_recvdata = this.t_recv_data;
                                            downloadReport6.t_process = 0L;
                                            downloadReport6.concurrent = getTaskConcurrentCount();
                                            downloadReport6.content_type = downloadResult.getContent().type;
                                            downloadReport6.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                            downloadReport6.isHttp2 = this.mIsHttp2;
                                            String str219 = this.mRealUrl;
                                            downloadReport6.isHttps = str219 == null && str219.startsWith(str116);
                                            downloadReport6.isSucceed = downloadResult.getStatus().isSucceed();
                                            downloadReport6.downloadMode = Downloader.DownloadMode.FastMode.ordinal();
                                            if (response16 != null) {
                                                downloadReport6.f99896protocol = response16.protocol().getProtocol();
                                            }
                                            downloadResult.setReport(downloadReport6);
                                            if (downloadResult.getStatus().isSucceed()) {
                                            }
                                            if (!this.mIsHttp2) {
                                            }
                                        }
                                    }
                                    str115 = str94;
                                    strategyInfo7 = this.pCurrStrategyInfo;
                                    if (strategyInfo7 != null && DownloadGlobalStrategy.Strategy_DomainDirect.f99899id == strategyInfo7.f99899id && this.pDirectIPConfigStrategy != null) {
                                        if (TextUtils.isEmpty(str111)) {
                                            this.pDirectIPConfigStrategy.onIPAccessResult(getDomain(), str111, downloadResult.getStatus().isSucceed());
                                        } else {
                                            this.pDirectIPConfigStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                        }
                                    }
                                    if (z37) {
                                        str116 = str99;
                                    } else {
                                        DownloadGlobalStrategy downloadGlobalStrategy6 = DownloadGlobalStrategy.getInstance(this.mContext);
                                        String str220 = this.mRealUrl;
                                        if (!this.mIsHttp2 || str220 == null) {
                                            str116 = str99;
                                        } else {
                                            str116 = str99;
                                            if (str220.startsWith(str116)) {
                                                z38 = true;
                                                downloadGlobalStrategy6.reportHttps(str220, z38, downloadResult.getStatus().isSucceed());
                                            }
                                        }
                                        z38 = false;
                                        downloadGlobalStrategy6.reportHttps(str220, z38, downloadResult.getStatus().isSucceed());
                                    }
                                    downloadReport6.endTime = System.currentTimeMillis();
                                    downloadReport6.fileSize = getContentLength();
                                    downloadReport6.response = httpResponse11;
                                    response16 = response15;
                                    downloadReport6.okResponse = response16;
                                    downloadReport6.httpStatus = i47;
                                    downloadReport6.exception = th8;
                                    downloadReport6.dns = dns5 != null ? null : dns5.toString();
                                    downloadReport6.localAddress = null;
                                    downloadReport6.clientip = downloadResult.getContent().clientip;
                                    downloadReport6.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                    downloadReport6.downloadTime = downloadResult.getProcess().duration;
                                    downloadReport6.t_wait = downloadReport6.totaltime - downloadResult.getProcess().duration;
                                    downloadReport6.t_prepare = j37;
                                    downloadReport6.t_conn = this.connect_time;
                                    downloadReport6.t_recvrsp = this.send_req_time;
                                    downloadReport6.t_recvdata = this.t_recv_data;
                                    downloadReport6.t_process = 0L;
                                    downloadReport6.concurrent = getTaskConcurrentCount();
                                    downloadReport6.content_type = downloadResult.getContent().type;
                                    downloadReport6.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                    downloadReport6.isHttp2 = this.mIsHttp2;
                                    String str2192 = this.mRealUrl;
                                    downloadReport6.isHttps = str2192 == null && str2192.startsWith(str116);
                                    downloadReport6.isSucceed = downloadResult.getStatus().isSucceed();
                                    downloadReport6.downloadMode = Downloader.DownloadMode.FastMode.ordinal();
                                    if (response16 != null && response16.protocol() != null) {
                                        downloadReport6.f99896protocol = response16.protocol().getProtocol();
                                    }
                                    downloadResult.setReport(downloadReport6);
                                    if (downloadResult.getStatus().isSucceed()) {
                                        handleDownloadReportForTask(jobContext, downloadResult, downloadReport6);
                                    }
                                }
                                if (!this.mIsHttp2) {
                                    Call call6 = this.okRequestCall;
                                    if (call6 != null) {
                                        call6.cancel();
                                    }
                                    this.okRequestBuilder = null;
                                    throw th6;
                                }
                                HttpGet httpGet6 = this.request;
                                if (httpGet6 != null) {
                                    httpGet6.abort();
                                    this.request = null;
                                }
                                cleanExpireConnection();
                                throw th6;
                            }
                        }
                        i49 = i16;
                        int i5922222222 = i49 + 1;
                        String str14022222222 = str11;
                        downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                        NetworkUtils.DNS dns722222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                        DownloadGlobalStrategy.StrategyInfo strategyInfo922222222 = this.pCurrStrategyInfo;
                        if (strategyInfo922222222 != null) {
                        }
                        String parserHttpHeaderInfo22222222 = parserHttpHeaderInfo(this.request, httpResponse, response);
                        if (httpContext == null) {
                        }
                        downloadResult.getContent().redirectUrl = str118;
                        Throwable th1122222222 = th5;
                        String str14122222222 = str118;
                        this.connect_time = 0L;
                        this.connect_retry = 0;
                        this.exe_time = 0L;
                        this.exe_retry = 0;
                        if (downloadResult.getStatus().isSucceed()) {
                        }
                        resumeTransfer7.addCacheTmpFile(getUrl(), downloadResult.getPath(), httpResponse, response);
                        if (jobContext.isCancelled()) {
                        }
                        if (this.mIsHttp2) {
                        }
                        i58 = i5922222222;
                        j46 = j38;
                        if (canAttempt()) {
                        }
                    } catch (Throwable th27) {
                        str91 = str7;
                        httpContext3 = httpContext;
                        response14 = response;
                        Throwable th28 = th5;
                        str93 = "";
                        str94 = str11;
                        str95 = str90;
                        str96 = ", ";
                        str97 = str136;
                        str98 = str138;
                        str99 = str2;
                        str100 = str9;
                        i46 = i17;
                        j29 = j16;
                        str92 = str6;
                        j36 = j3;
                        httpResponse10 = httpResponse;
                        str101 = str137;
                        str102 = str139;
                        th7 = th28;
                        th6 = th27;
                    }
                    QDLog.e(str11, "", th5);
                } catch (Throwable th29) {
                    str91 = str7;
                    httpContext3 = httpContext;
                    str92 = str6;
                    response14 = response;
                    str93 = "";
                    str94 = str11;
                    str95 = str90;
                    str96 = ", ";
                    str97 = str136;
                    str98 = str138;
                    str99 = str2;
                    str100 = str9;
                    i46 = i17;
                    j29 = j16;
                    j36 = j3;
                    httpResponse10 = httpResponse;
                    str101 = str137;
                    str102 = str139;
                    th6 = th29;
                    th7 = null;
                }
                str90 = str10;
            } else {
                jobContext3 = jobContext5;
                downloadResult3 = downloadResult5;
                i3 = generateRandomId;
                z16 = isSdCardHasEnoughCapability;
                if (canAttempt()) {
                    return;
                }
                downloadResult5 = downloadResult3;
                jobContext5 = jobContext3;
                generateRandomId = i3;
                isSdCardHasEnoughCapability = z16;
                i57 = 1;
            }
        }
        handleDownloadReportForTask(jobContext5, downloadResult5, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.network.downloader.impl.DownloadTask
    public void initTask() {
        super.initTask();
        this.mDomainWithPort = Utils.getDominWithPort(getUrl());
        this.mOrigPort = Utils.getPort(getUrl());
        this.mRefer = HttpUtil.prepareRefer(getUrl());
        if (!DownloadGlobalStrategy.getInstance(this.mContext).supportHttps()) {
            this.mIsHttp2 = false;
            this.mOriginalIsHttp2 = false;
        }
    }
}
