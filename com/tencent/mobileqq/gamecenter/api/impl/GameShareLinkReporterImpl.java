package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameShareLinkReporter;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameLinkShareReportPB$GetReportRulesReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameLinkShareReportPB$GetReportRulesRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameLinkShareReportPB$ReportItem;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameLinkShareReportPB$ReportReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameLinkShareReportPB$ReportRule;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameShareLinkReporterImpl implements IGameShareLinkReporter, WadlTrpcListener {
    private static final long CONFIG_VALID_TIME = 7200000;
    private static final double DEFAULT_UNMATCH_URL_REPORT_RATE = 0.1d;
    private static final int GET_CONFIG_TIME_OUT = 500;
    private static final String MMKV_KEY_REPORT_BLACK_DOMAIN = "key_game_report_black_domain";
    private static final String MMKV_KEY_REPORT_BLACK_REG = "key_game_report_black_REG";
    private static final String MMKV_KEY_REPORT_CONFIG_TIMESTAMP = "key_game_report_config_timestamp";
    private static final String MMKV_KEY_REPORT_RATE = "key_game_report_rate";
    private static final String MMKV_KEY_REPORT_WHITE_DOMAIN = "key_game_report_white_domain";
    private static final String MMKV_KEY_REPORT_WHITE_REG = "key_game_report_white_reg";
    private static final int MSG_FLUSH_REPORT = 4;
    private static final int MSG_GET_CONFIG = 1;
    private static final int MSG_GET_CONFIG_TIME_OUT = 3;
    private static final int MSG_REPORT = 2;
    private static final long REPORT_INTERVAL_TIME = 1000;
    public static final String TAG = "GameShareLinkReporterImpl";
    private static final String TRPC_CMD_GET_LINK_CONFIG = "/v1/1554";
    private static final String TRPC_CMD_REPORT = "/v1/1555";
    private Handler mHandler;
    private b mLastReport;
    private boolean mReportSwitch;
    private Set<String> mWhiteDomainList = new HashSet();
    private Set<String> mWhiteRegList = new HashSet();
    private Set<String> mBlackDomainList = new HashSet();
    private Set<String> mBlackRegList = new HashSet();
    private long mConfigTimeStamp = 0;
    private double mReportRate = DEFAULT_UNMATCH_URL_REPORT_RATE;
    private ArrayList<b> mReportData = new ArrayList<>();
    private boolean mConfigGetted = false;
    private boolean mConfigGetting = false;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            try {
                int i3 = message.what;
                if (i3 == 1) {
                    GameShareLinkReporterImpl.this.initConfig();
                    return;
                }
                if (i3 != 2) {
                    if (i3 == 3) {
                        GameShareLinkReporterImpl.this.mConfigGetting = false;
                        GameShareLinkReporterImpl.this.mConfigGetted = false;
                        return;
                    } else {
                        if (i3 == 4) {
                            GameShareLinkReporterImpl.this.checkReportInner();
                            return;
                        }
                        return;
                    }
                }
                GameShareLinkReporterImpl.this.mReportData.add((b) message.obj);
                if (QLog.isColorLevel()) {
                    QLog.d(GameShareLinkReporterImpl.TAG, 2, "[MSG_REPORT] mConfigGetted:" + GameShareLinkReporterImpl.this.mConfigGetted + ",time:" + GameShareLinkReporterImpl.this.mConfigTimeStamp);
                }
                if (GameShareLinkReporterImpl.this.mConfigGetted) {
                    GameShareLinkReporterImpl gameShareLinkReporterImpl = GameShareLinkReporterImpl.this;
                    if (gameShareLinkReporterImpl.checkReportIsValid(gameShareLinkReporterImpl.mConfigTimeStamp)) {
                        GameShareLinkReporterImpl.this.checkReportInner();
                        return;
                    }
                }
                if (!GameShareLinkReporterImpl.this.mConfigGetting) {
                    GameShareLinkReporterImpl.this.getReportRuleFromServer();
                }
            } catch (Exception e16) {
                QLog.e(GameShareLinkReporterImpl.TAG, 1, e16, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f211873a;

        /* renamed from: b, reason: collision with root package name */
        public String f211874b;

        /* renamed from: c, reason: collision with root package name */
        public long f211875c;

        b() {
        }

        public String toString() {
            return "ReportParam{url='" + this.f211873a + "', domain='" + this.f211874b + "', timeStamp=" + this.f211875c + '}';
        }
    }

    public GameShareLinkReporterImpl() {
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
        this.mHandler = new a(ThreadManagerV2.getQQCommonThreadLooper());
        boolean isSwitchOn = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.GAME_CENTER_REPORT_GAME_SHARE_LINK_SWITCH, true);
        this.mReportSwitch = isSwitchOn;
        if (isSwitchOn) {
            this.mHandler.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkReportInner() {
        boolean z16;
        boolean z17;
        QLog.d(TAG, 2, "[checkReportInner] check report.");
        Iterator<b> it = this.mReportData.iterator();
        while (it.hasNext()) {
            b next = it.next();
            try {
                String host = new URL(next.f211873a).getHost();
                if (!TextUtils.isEmpty(host)) {
                    Iterator<String> it5 = this.mBlackDomainList.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            if (host.equals(it5.next())) {
                                z16 = true;
                                break;
                            }
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    Iterator<String> it6 = this.mBlackRegList.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            break;
                        } else if (Pattern.compile(it6.next()).matcher(next.f211873a).find()) {
                            z16 = true;
                            break;
                        }
                    }
                    if (z16) {
                        QLog.i(TAG, 2, "[checkReportInner] blacklist matched:" + next.f211873a);
                        return;
                    }
                    Iterator<String> it7 = this.mWhiteDomainList.iterator();
                    while (true) {
                        if (it7.hasNext()) {
                            if (host.equals(it7.next())) {
                                z17 = true;
                                break;
                            }
                        } else {
                            z17 = false;
                            break;
                        }
                    }
                    Iterator<String> it8 = this.mWhiteRegList.iterator();
                    while (true) {
                        if (!it8.hasNext()) {
                            break;
                        }
                        String next2 = it8.next();
                        if (!TextUtils.isEmpty(next2) && Pattern.compile(next2).matcher(next.f211873a).find()) {
                            z17 = true;
                            break;
                        }
                    }
                    if (z17) {
                        doReportInner(next, true);
                    } else if (Math.random() < this.mReportRate) {
                        doReportInner(next, false);
                        QLog.i(TAG, 2, "[checkReportInner] report by random:" + next.f211873a);
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
        this.mReportData.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkReportIsValid(long j3) {
        if (System.currentTimeMillis() - j3 > 7200000) {
            return false;
        }
        return true;
    }

    private void doReportInner(b bVar, boolean z16) {
        GameLinkShareReportPB$ReportReq gameLinkShareReportPB$ReportReq = new GameLinkShareReportPB$ReportReq();
        GameLinkShareReportPB$ReportItem gameLinkShareReportPB$ReportItem = new GameLinkShareReportPB$ReportItem();
        gameLinkShareReportPB$ReportItem.url.set(bVar.f211873a);
        gameLinkShareReportPB$ReportItem.action_time.set(bVar.f211875c);
        gameLinkShareReportPB$ReportItem.scene.set(0);
        gameLinkShareReportPB$ReportItem.material_id.set("");
        gameLinkShareReportPB$ReportItem.imie.set(MobileInfoUtil.getImei());
        gameLinkShareReportPB$ReportItem.f213224ua.set("");
        gameLinkShareReportPB$ReportItem.android_id.set(com.tencent.mobileqq.utils.ah.e());
        gameLinkShareReportPB$ReportItem.device_type.set("android");
        if (z16) {
            gameLinkShareReportPB$ReportItem.type.set(0);
        } else {
            gameLinkShareReportPB$ReportItem.type.set(1);
        }
        gameLinkShareReportPB$ReportItem.link_type.set(0);
        gameLinkShareReportPB$ReportReq.items.add(gameLinkShareReportPB$ReportItem);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(TRPC_CMD_REPORT, false, gameLinkShareReportPB$ReportReq.toByteArray());
        Bundle bundle = new Bundle();
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[doReportInner] report suc :" + bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getReportRuleFromServer() {
        QLog.i(TAG, 2, "[getReportRuleFromServer] get report rule");
        this.mConfigGetting = true;
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(TRPC_CMD_GET_LINK_CONFIG, false, new MessageMicro<GameLinkShareReportPB$GetReportRulesReq>() { // from class: com.tencent.mobileqq.gamecenter.trpcprotocol.GameLinkShareReportPB$GetReportRulesReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GameLinkShareReportPB$GetReportRulesReq.class);
        }.toByteArray());
        Bundle bundle = new Bundle();
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        this.mHandler.sendEmptyMessageDelayed(3, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initConfig() {
        try {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            if (!checkReportIsValid(from.decodeLong(MMKV_KEY_REPORT_CONFIG_TIMESTAMP, 0L))) {
                getReportRuleFromServer();
            } else {
                this.mWhiteDomainList = from.decodeStringSet(MMKV_KEY_REPORT_WHITE_DOMAIN, new HashSet());
                this.mWhiteRegList = from.decodeStringSet(MMKV_KEY_REPORT_WHITE_REG, new HashSet());
                this.mBlackDomainList = from.decodeStringSet(MMKV_KEY_REPORT_BLACK_DOMAIN, new HashSet());
                this.mWhiteRegList = from.decodeStringSet(MMKV_KEY_REPORT_BLACK_REG, new HashSet());
                this.mReportRate = from.decodeDouble(MMKV_KEY_REPORT_RATE, DEFAULT_UNMATCH_URL_REPORT_RATE);
                this.mConfigTimeStamp = from.decodeLong(MMKV_KEY_REPORT_CONFIG_TIMESTAMP, 0L);
                this.mConfigGetted = true;
                this.mConfigGetting = false;
                QLog.i(TAG, 2, "[initConfig] use cache config. size:" + this.mWhiteDomainList.size() + ", " + this.mWhiteRegList.size() + ", " + this.mBlackDomainList.size() + ", " + this.mBlackRegList.size() + ", rate: " + this.mReportRate);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        return new HashSet<String>() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameShareLinkReporterImpl.2
            {
                add(GameShareLinkReporterImpl.TRPC_CMD_GET_LINK_CONFIG);
            }
        };
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        QLog.i(TAG, 2, "[onTrpcRsp] onTrpcRsp ret:" + j3 + ", cmd:" + str);
        this.mHandler.removeMessages(3);
        this.mConfigGetting = false;
        if (intent == null) {
            QLog.i(TAG, 2, "[onTrpcRsp] onTrpcRsp request null.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 2, "[onTrpcRsp] cmd is empty.");
            return;
        }
        if (TRPC_CMD_GET_LINK_CONFIG.equals(str)) {
            if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
                try {
                    QLog.i(TAG, 1, "[onTrpcRsp] TRPC_CMD_GET_LINK_CONFIG suc.");
                    this.mConfigGetted = true;
                    GameLinkShareReportPB$GetReportRulesRsp gameLinkShareReportPB$GetReportRulesRsp = new GameLinkShareReportPB$GetReportRulesRsp();
                    gameLinkShareReportPB$GetReportRulesRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    this.mReportRate = gameLinkShareReportPB$GetReportRulesRsp.sample_rate.get();
                    this.mWhiteDomainList.clear();
                    this.mWhiteRegList.clear();
                    this.mBlackRegList.clear();
                    this.mBlackDomainList.clear();
                    for (GameLinkShareReportPB$ReportRule gameLinkShareReportPB$ReportRule : gameLinkShareReportPB$GetReportRulesRsp.rules.get()) {
                        if (gameLinkShareReportPB$ReportRule.type.get() == 0) {
                            this.mWhiteDomainList.add(gameLinkShareReportPB$ReportRule.full_domain_match.get());
                            this.mWhiteRegList.add(gameLinkShareReportPB$ReportRule.regexp.get());
                        } else {
                            this.mBlackDomainList.add(gameLinkShareReportPB$ReportRule.full_domain_match.get());
                            this.mBlackRegList.add(gameLinkShareReportPB$ReportRule.regexp.get());
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 1, "[onTrpcRsp]rate: " + this.mReportRate + ", whiteList:" + this.mWhiteDomainList + "," + this.mWhiteRegList);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("[onTrpcRsp] blackList:");
                        sb5.append(this.mBlackDomainList);
                        sb5.append(",");
                        sb5.append(this.mBlackRegList);
                        QLog.d(TAG, 1, sb5.toString());
                    }
                    MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                    from.encodeStringSet(MMKV_KEY_REPORT_WHITE_DOMAIN, this.mWhiteDomainList);
                    from.encodeStringSet(MMKV_KEY_REPORT_WHITE_REG, this.mWhiteRegList);
                    from.encodeStringSet(MMKV_KEY_REPORT_BLACK_DOMAIN, this.mBlackDomainList);
                    from.encodeStringSet(MMKV_KEY_REPORT_BLACK_REG, this.mWhiteRegList);
                    from.encodeDouble(MMKV_KEY_REPORT_RATE, this.mReportRate);
                    long currentTimeMillis = System.currentTimeMillis();
                    this.mConfigTimeStamp = currentTimeMillis;
                    from.encodeLong(MMKV_KEY_REPORT_CONFIG_TIMESTAMP, currentTimeMillis);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, e16, new Object[0]);
                }
            } else {
                QLog.e(TAG, 1, "[onTrpcRsp] TRPC_CMD_GET_LINK_CONFIG failed.");
            }
        }
        this.mHandler.sendEmptyMessage(4);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameShareLinkReporter
    public void reportGameShareLink(String str) {
        QLog.i(TAG, 2, "[reportGameShareLink] switch:" + this.mReportSwitch + " report url:" + str);
        if (!this.mReportSwitch) {
            return;
        }
        b bVar = new b();
        bVar.f211873a = str;
        bVar.f211875c = System.currentTimeMillis();
        b bVar2 = this.mLastReport;
        if (bVar2 != null && TextUtils.equals(bVar2.f211873a, bVar.f211873a) && bVar.f211875c - this.mLastReport.f211875c < 1000) {
            QLog.e(TAG, 2, "[MSG_REPORT] same url return.");
            return;
        }
        this.mLastReport = bVar;
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = bVar;
        this.mHandler.sendMessage(obtainMessage);
    }
}
