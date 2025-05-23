package com.tencent.mobileqq.transfile;

import ConfigPush.BigDataChannel;
import ConfigPush.BigDataIpInfo;
import ConfigPush.BigDataIpList;
import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import ConfigPush.FmtIPInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.api.IRichMediaTransferUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import tencent.im.cs.ptt_apply.ptt_apply$Addr;
import tencent.im.cs.ptt_apply.ptt_apply$QQApplyAuthkeyRsp;

@Deprecated
/* loaded from: classes19.dex */
public final class FMTSrvAddrProvider {
    static IPatchRedirector $redirector_ = null;
    private static final String FMT_SVC_DATABASE = "data";
    private static final String FMT_SVC_INI_FILE_NAME = "srvAddr.ini";
    private static final String FMT_SVC_INI_TMP_FILE_NAME = "fmtSrvAddr.ini";
    public static final int STATE_CLEAR = 2;
    public static final int STATE_INIT = 0;
    public static final int STATE_READY = 1;
    public static final String TAG = "FMT_ADDR";
    public static final int TLV_WIFI_IDENTIFIER_INDEX = 1;
    public static final int TLV_WIFI_IP_LIST_INDEX = 3;
    public static final int TLV_XG_IDENTIFIER_INDEX = 2;
    public static final int TLV_XG_IP_LIST_INDEX = 4;
    private static FMTSrvAddrProvider mSelf;
    private static byte[] mlock;
    private subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf encryptConf;
    private Hashtable<Integer, ArrayList<FileStorageServerListInfo>> mBigDataSvcList;
    private SrvAddrChooser mChooser;
    private Hashtable<Integer, ArrayList<FileStorageServerListInfo>> mDomainSvrList;
    private long mGateIpOper;
    private String mGatewayIp;
    private PttIpList mGroupPttIpList;
    private StructLongMessageIpSaver mLongMsgIpSaver;
    private com.tencent.mobileqq.richmedia.c mRichMediaIpSaver;
    private int mState;
    private FileStoragePushFSSvcList mSvcList;

    /* loaded from: classes19.dex */
    private interface BigDataServiceType {
        public static final int LENGTH = 8;
        public static final int SERVICE_TYPE_CIRCLE = 5;
        public static final int SERVICE_TYPE_DEFAULT = 1;
        public static final int SERVICE_TYPE_HIGHWAY = 10;
        public static final int SERVICE_TYPE_HIGHWAY_HTTPS = 21;
        public static final int SERVICE_TYPE_PICTURUPLOAD = 4;
        public static final int SERVICE_TYPE_QZONE = 2;
        public static final int SERVICE_TYPE_RESERVE = 0;
        public static final int SERVICE_TYPE_SHORTVIDEO = 12;
        public static final int SERVICE_TYPE_WEIBO = 3;
    }

    /* loaded from: classes19.dex */
    private interface DomainIpType {
        public static final int DOMAIN_CMSHOW_GTIMG_CN = 16;
        public static final int DOMAIN_IMGCACHE_GTIME_CN = 2;
        public static final int DOMAIN_IMGCACHE_QQ_COM = 1;
        public static final int DOMAIN_I_GTIME_CN = 3;
        public static final int DOMAIN_JIANKANG_QQ_COM = 7;
        public static final int LENGTH = 5;
    }

    /* loaded from: classes19.dex */
    public interface FMTSrvAddrType {
        public static final int LENGTH = 18;
        public static final int SRV_BIGDATA_CIRCLE = 10;
        public static final int SRV_BIGDATA_DEFAULT = 6;
        public static final int SRV_BIGDATA_PICTURUPLOAD = 9;
        public static final int SRV_BIGDATA_QZONE = 7;
        public static final int SRV_BIGDATA_WEIBO = 8;
        public static final int SRV_C2CPIC_DOWN = 11;
        public static final int SRV_CMSHOW_DOAMIN = 17;
        public static final int SRV_COMMON_DOWN = 1;
        public static final int SRV_COMMON_UP = 0;
        public static final int SRV_ENCODE = 4;
        public static final int SRV_GROUP_DOWN = 2;
        public static final int SRV_GROUP_PTT_DOWN = 16;
        public static final int SRV_QZONE_PROXY = 3;
        public static final int SRV_VAS_CDN_DOMAIN1 = 12;
        public static final int SRV_VAS_CDN_DOMAIN2 = 13;
        public static final int SRV_VAS_CDN_DOMAIN3 = 14;
        public static final int SRV_VAS_CDN_DOMAIN4 = 15;
        public static final int SRV_VIP_EMOTICON = 5;
    }

    /* loaded from: classes19.dex */
    public static class PttIpList {
        static IPatchRedirector $redirector_;
        public ArrayList<FileStorageServerListInfo> groupPttDownloadWifiIPLIst;
        public ArrayList<FileStorageServerListInfo> groupPttDownloadXGIPLIst;
        public int[] wifiError;
        public String wifiIdentifier;
        public int[] xGError;
        public String xGIdentifier;

        public PttIpList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.wifiError = new int[6];
            this.xGError = new int[6];
            this.groupPttDownloadWifiIPLIst = new ArrayList<>();
            this.groupPttDownloadXGIPLIst = new ArrayList<>();
        }

        public ArrayList<FileStorageServerListInfo> getIpList(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            if (str != null && str.equals(this.wifiIdentifier)) {
                return this.groupPttDownloadWifiIPLIst;
            }
            if (str != null && str.equals(this.xGIdentifier)) {
                return this.groupPttDownloadXGIPLIst;
            }
            return null;
        }

        public int[] getPttFailTimesArea(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (int[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            if (str != null && str.equals(this.wifiIdentifier)) {
                return this.wifiError;
            }
            if (str != null && str.equals(this.xGIdentifier)) {
                return this.xGError;
            }
            return null;
        }

        public void initError() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            ArrayList<FileStorageServerListInfo> arrayList = this.groupPttDownloadWifiIPLIst;
            if (arrayList != null && arrayList.size() > 0) {
                this.wifiError = new int[this.groupPttDownloadWifiIPLIst.size()];
            }
            ArrayList<FileStorageServerListInfo> arrayList2 = this.groupPttDownloadXGIPLIst;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.xGError = new int[this.groupPttDownloadXGIPLIst.size()];
            }
        }

        public void onFailed(String str, String str2) {
            ArrayList<FileStorageServerListInfo> arrayList;
            int[] iArr;
            String host;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
                return;
            }
            if (str != null) {
                try {
                    if (str.equals(this.wifiIdentifier)) {
                        arrayList = this.groupPttDownloadWifiIPLIst;
                        iArr = this.wifiError;
                        if (arrayList == null && arrayList.size() > 0 && iArr != null && iArr.length > 0 && (host = new URL(str2).getHost()) != null && host.length() > 0) {
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                String str3 = arrayList.get(i3).sIP;
                                if (str3 != null && str3.equalsIgnoreCase(host)) {
                                    if (iArr.length > i3) {
                                        iArr[i3] = iArr[i3] + 1;
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                } catch (MalformedURLException unused) {
                    return;
                }
            }
            if (str != null && str.equals(this.xGIdentifier)) {
                arrayList = this.groupPttDownloadXGIPLIst;
                iArr = this.xGError;
            } else {
                arrayList = null;
                iArr = null;
            }
            if (arrayList == null) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75960);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            mlock = new byte[1];
        }
    }

    FMTSrvAddrProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.mState = 0;
        this.mBigDataSvcList = new Hashtable<>();
        this.mDomainSvrList = new Hashtable<>();
        this.mGroupPttIpList = new PttIpList();
        this.mGatewayIp = "";
        this.mGateIpOper = -1L;
        this.mRichMediaIpSaver = ((IRichMediaTransferUtils) QRoute.api(IRichMediaTransferUtils.class)).createRichMediaIpSaver();
        this.mSvcList = readFromFile();
        this.mChooser = new SrvAddrChooser();
        this.mLongMsgIpSaver = new StructLongMessageIpSaver();
        parseGroupPttDownloadIPList();
        init();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void decodeSrvAddrs(Map<Integer, HwConfig> map, subcmd0x501.SubCmd0x501Rspbody subCmd0x501Rspbody, List<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs> list) {
        Iterator<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs> it;
        String str;
        FMTSrvAddrProvider fMTSrvAddrProvider = this;
        Map<Integer, HwConfig> map2 = map;
        Iterator<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs> it5 = list.iterator();
        while (it5.hasNext()) {
            subcmd0x501.SubCmd0x501Rspbody.SrvAddrs next = it5.next();
            int i3 = next.uint32_service_type.get();
            boolean isColorLevel = QLog.isColorLevel();
            String str2 = TAG;
            if (isColorLevel) {
                QLog.d(TAG, 2, "GetHighwayConfig   find HwServlet.HIGHWAY_SERVICE_TYPE" + i3);
            }
            if (i3 == 10) {
                HwConfig generateConfig = fMTSrvAddrProvider.generateConfig(next);
                generateConfig.netSegConfList = new ArrayList<>();
                List<subcmd0x501.SubCmd0x501Rspbody.NetSegConf> list2 = next.rpt_msg_netsegconf.get();
                if (list2 != null && list2.size() != 0) {
                    int i16 = 0;
                    while (i16 < list2.size()) {
                        subcmd0x501.SubCmd0x501Rspbody.NetSegConf netSegConf = list2.get(i16);
                        generateConfig.netSegConfList.add(new HwNetSegConf(netSegConf.uint32_net_type.get(), netSegConf.uint32_segsize.get(), netSegConf.uint32_segnum.get(), netSegConf.uint32_curconnnum.get()));
                        i16++;
                        str2 = str2;
                        it5 = it5;
                        list2 = list2;
                    }
                }
                it = it5;
                String str3 = str2;
                if (subCmd0x501Rspbody.msg_ip_learn_conf.has()) {
                    generateConfig.ipConf = subCmd0x501Rspbody.msg_ip_learn_conf.get();
                }
                if (subCmd0x501Rspbody.msg_dyn_timeout_conf.has()) {
                    generateConfig.dtConf = subCmd0x501Rspbody.msg_dyn_timeout_conf.get();
                }
                if (subCmd0x501Rspbody.msg_open_up_conf.has()) {
                    generateConfig.openUpConf = subCmd0x501Rspbody.msg_open_up_conf.get();
                }
                if (subCmd0x501Rspbody.msg_short_video_conf.has()) {
                    generateConfig.videoConf = subCmd0x501Rspbody.msg_short_video_conf;
                } else if (QLog.isColorLevel()) {
                    str = str3;
                    QLog.d(str, 2, "<BDH_LOG> getHighwayConfig from push. rspBody.msg_short_video_conf.has() : false ! ");
                    if (!subCmd0x501Rspbody.msg_ptv_conf.has()) {
                        generateConfig.ptvCof = subCmd0x501Rspbody.msg_ptv_conf;
                    } else if (QLog.isColorLevel()) {
                        QLog.d(str, 2, "<BDH_LOG> getHighwayConfig from push. rspBody.msg_ptv_conf.has() : false ! ");
                    }
                    if (!subCmd0x501Rspbody.uint32_fmt_policy.has()) {
                        generateConfig.fmtIpv6Policy = subCmd0x501Rspbody.uint32_fmt_policy;
                    } else if (QLog.isColorLevel()) {
                        QLog.d(str, 2, "<BDH_LOG> getHighwayConfig from push. rspBody.uint32_fmt_policy.has() : false ! ");
                    }
                    if (!subCmd0x501Rspbody.uint32_bigdata_policy.has()) {
                        generateConfig.bdhIpv6Policy = subCmd0x501Rspbody.uint32_bigdata_policy;
                    } else if (QLog.isColorLevel()) {
                        QLog.d(str, 2, "<BDH_LOG> getHighwayConfig from push. rspBody.uint32_bigdata_policy.has() : false ! ");
                    }
                    if (!subCmd0x501Rspbody.uint32_conn_attempt_delay.has()) {
                        generateConfig.connAttemptDelay = subCmd0x501Rspbody.uint32_conn_attempt_delay;
                    } else if (QLog.isColorLevel()) {
                        QLog.d(str, 2, "<BDH_LOG> getHighwayConfig from push. rspBody.uint32_conn_attempt_delay.has() : false ! ");
                    }
                    map2 = map;
                    map2.put(Integer.valueOf(i3), generateConfig);
                }
                str = str3;
                if (!subCmd0x501Rspbody.msg_ptv_conf.has()) {
                }
                if (!subCmd0x501Rspbody.uint32_fmt_policy.has()) {
                }
                if (!subCmd0x501Rspbody.uint32_bigdata_policy.has()) {
                }
                if (!subCmd0x501Rspbody.uint32_conn_attempt_delay.has()) {
                }
                map2 = map;
                map2.put(Integer.valueOf(i3), generateConfig);
            } else {
                it = it5;
                if (i3 == 21) {
                    fMTSrvAddrProvider = this;
                    map2.put(Integer.valueOf(i3), fMTSrvAddrProvider.generateConfig(next));
                    it5 = it;
                }
            }
            fMTSrvAddrProvider = this;
            it5 = it;
        }
    }

    public static void destroy() {
        FMTSrvAddrProvider fMTSrvAddrProvider = mSelf;
        if (fMTSrvAddrProvider == null) {
            return;
        }
        fMTSrvAddrProvider.onDestroy();
    }

    private void doClearGroupPttDownloadIPList() {
        this.mGroupPttIpList = new PttIpList();
        if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "Clear GroupPtt D-IpList");
        }
    }

    private HwConfig generateConfig(subcmd0x501.SubCmd0x501Rspbody.SrvAddrs srvAddrs) {
        boolean z16;
        boolean z17;
        HwConfig hwConfig = new HwConfig();
        hwConfig.ipList = new ArrayList<>();
        List<subcmd0x501.SubCmd0x501Rspbody.IpAddr> list = srvAddrs.rpt_msg_addrs.get();
        if (list != null && list.size() != 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                subcmd0x501.SubCmd0x501Rspbody.IpAddr ipAddr = list.get(i3);
                ArrayList<EndPoint> arrayList = hwConfig.ipList;
                String spliceCircleUrl = HwServlet.spliceCircleUrl(ipAddr.uint32_ip.get());
                int i16 = ipAddr.uint32_port.get();
                if (ipAddr.uint32_same_isp.get() == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                arrayList.add(new EndPoint(spliceCircleUrl, i16, z17));
            }
        }
        hwConfig.ipv6List = new ArrayList<>();
        List<subcmd0x501.SubCmd0x501Rspbody.Ip6Addr> list2 = srvAddrs.rpt_msg_addrs_v6.get();
        if (list2 != null && list2.size() != 0) {
            for (int i17 = 0; i17 < list2.size(); i17++) {
                subcmd0x501.SubCmd0x501Rspbody.Ip6Addr ip6Addr = list2.get(i17);
                ArrayList<EndPoint> arrayList2 = hwConfig.ipv6List;
                String spliceIpv6Url = HwServlet.spliceIpv6Url(ip6Addr.bytes_ip6.get().toByteArray());
                int i18 = ip6Addr.uint32_port.get();
                if (ip6Addr.uint32_same_isp.get() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                arrayList2.add(new EndPoint(spliceIpv6Url, i18, z16));
            }
        }
        return hwConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBigDataServiceType(int i3) {
        if (i3 == 6) {
            return 1;
        }
        if (i3 == 7) {
            return 2;
        }
        if (i3 == 8) {
            return 3;
        }
        if (i3 == 9) {
            return 4;
        }
        if (i3 != 10) {
            return 1;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<FileStorageServerListInfo> getBigDataSvcList(int i3) {
        BigDataChannel bigDataChannel;
        if (this.mBigDataSvcList.containsKey(Integer.valueOf(i3))) {
            return this.mBigDataSvcList.get(Integer.valueOf(i3));
        }
        FileStoragePushFSSvcList fileStoragePushFSSvcList = this.mSvcList;
        if (fileStoragePushFSSvcList != null && (bigDataChannel = fileStoragePushFSSvcList.bigDataChannel) != null && bigDataChannel.vBigdata_iplists != null) {
            for (int i16 = 0; i16 < this.mSvcList.bigDataChannel.vBigdata_iplists.size(); i16++) {
                BigDataIpList bigDataIpList = this.mSvcList.bigDataChannel.vBigdata_iplists.get(i16);
                if (bigDataIpList.uService_type == i3) {
                    ArrayList<BigDataIpInfo> arrayList = bigDataIpList.vIplist;
                    ArrayList<FileStorageServerListInfo> arrayList2 = new ArrayList<>();
                    for (int i17 = 0; i17 < arrayList.size(); i17++) {
                        FileStorageServerListInfo fileStorageServerListInfo = new FileStorageServerListInfo();
                        fileStorageServerListInfo.sIP = arrayList.get(i17).sIp;
                        fileStorageServerListInfo.iPort = (int) arrayList.get(i17).uPort;
                        arrayList2.add(fileStorageServerListInfo);
                    }
                    this.mBigDataSvcList.put(Integer.valueOf(i3), arrayList2);
                    return arrayList2;
                }
            }
            return null;
        }
        return null;
    }

    private byte[] getBytes(byte[] bArr, byte[] bArr2, byte[][] bArr3, byte[][] bArr4, int i3, byte b16, int i16) {
        byte[] bArr5 = new byte[i3 + 2];
        bArr5[0] = 0;
        int i17 = i16 + 1;
        bArr5[i17] = b16;
        int i18 = i17 + 1;
        if (bArr != null) {
            bArr5[i18] = 1;
            int i19 = i18 + 1;
            byte[] shortToHL = PkgTools.shortToHL((short) bArr.length);
            System.arraycopy(shortToHL, 0, bArr5, i19, shortToHL.length);
            int length = i19 + shortToHL.length;
            System.arraycopy(bArr, 0, bArr5, length, bArr.length);
            i18 = length + bArr.length;
        }
        if (bArr2 != null) {
            bArr5[i18] = 2;
            int i26 = i18 + 1;
            byte[] shortToHL2 = PkgTools.shortToHL((short) bArr2.length);
            System.arraycopy(shortToHL2, 0, bArr5, i26, shortToHL2.length);
            int length2 = i26 + shortToHL2.length;
            System.arraycopy(bArr2, 0, bArr5, length2, bArr2.length);
            i18 = length2 + bArr2.length;
        }
        if (bArr3 != null && bArr3.length > 0) {
            for (int i27 = 0; i27 < bArr3.length; i27++) {
                bArr5[i18] = 3;
                int i28 = i18 + 1;
                byte[] shortToHL3 = PkgTools.shortToHL((short) bArr3[i27].length);
                System.arraycopy(shortToHL3, 0, bArr5, i28, shortToHL3.length);
                int length3 = i28 + shortToHL3.length;
                byte[] bArr6 = bArr3[i27];
                System.arraycopy(bArr6, 0, bArr5, length3, bArr6.length);
                i18 = length3 + bArr3[i27].length;
            }
        }
        if (bArr4 != null && bArr4.length > 0) {
            for (int i29 = 0; i29 < bArr4.length; i29++) {
                bArr5[i18] = 4;
                int i36 = i18 + 1;
                byte[] shortToHL4 = PkgTools.shortToHL((short) bArr4[i29].length);
                System.arraycopy(shortToHL4, 0, bArr5, i36, shortToHL4.length);
                int length4 = i36 + shortToHL4.length;
                byte[] bArr7 = bArr4[i29];
                System.arraycopy(bArr7, 0, bArr5, length4, bArr7.length);
                i18 = length4 + bArr4[i29].length;
            }
        }
        return bArr5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<FileStorageServerListInfo> getDomainSvrList(int i3) {
        DomainIpChannel domainIpChannel;
        if (this.mDomainSvrList.containsKey(Integer.valueOf(i3))) {
            return this.mDomainSvrList.get(Integer.valueOf(i3));
        }
        try {
            FileStoragePushFSSvcList fileStoragePushFSSvcList = this.mSvcList;
            if (fileStoragePushFSSvcList != null && (domainIpChannel = fileStoragePushFSSvcList.domainIpChannel) != null && domainIpChannel.vDomain_iplists != null) {
                for (int i16 = 0; i16 < this.mSvcList.domainIpChannel.vDomain_iplists.size(); i16++) {
                    DomainIpList domainIpList = this.mSvcList.domainIpChannel.vDomain_iplists.get(i16);
                    if (domainIpList.uDomain_type == i3) {
                        ArrayList<DomainIpInfo> arrayList = domainIpList.vIplist;
                        ArrayList<FileStorageServerListInfo> arrayList2 = new ArrayList<>();
                        for (int i17 = 0; i17 < arrayList.size(); i17++) {
                            FileStorageServerListInfo fileStorageServerListInfo = new FileStorageServerListInfo();
                            fileStorageServerListInfo.sIP = NetworkUtil.intAddr2Ip(arrayList.get(i17).uIp);
                            fileStorageServerListInfo.iPort = arrayList.get(i17).uPort;
                            arrayList2.add(fileStorageServerListInfo);
                        }
                        this.mDomainSvrList.put(Integer.valueOf(i3), arrayList2);
                        if (QLog.isColorLevel()) {
                            StringBuffer stringBuffer = new StringBuffer();
                            Iterator<FileStorageServerListInfo> it = arrayList2.iterator();
                            while (it.hasNext()) {
                                FileStorageServerListInfo next = it.next();
                                stringBuffer.append(next.sIP);
                                stringBuffer.append(":");
                                stringBuffer.append(next.iPort);
                                stringBuffer.append(",");
                            }
                            QLog.d(TAG, 2, "Domain type=" + i3 + ",iplist=" + stringBuffer.toString());
                        }
                        return arrayList2;
                    }
                }
                return null;
            }
            return null;
        } catch (NoSuchFieldError e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDomainType(int i3) {
        switch (i3) {
            case 12:
                return 1;
            case 13:
                return 2;
            case 14:
                return 3;
            case 15:
                return 7;
            case 16:
            default:
                return -1;
            case 17:
                return 16;
        }
    }

    public static FMTSrvAddrProvider getInstance() {
        if (mSelf == null) {
            synchronized (mlock) {
                if (mSelf == null) {
                    mSelf = new FMTSrvAddrProvider();
                }
            }
        }
        return mSelf;
    }

    private String getPrivatePath(String str) {
        return TransFileUtil.getsPrivateDir() + "data" + File.separator + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<FileStorageServerListInfo> getSvcList(int i3) {
        FileStoragePushFSSvcList fileStoragePushFSSvcList = this.mSvcList;
        if (fileStoragePushFSSvcList != null) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 != 5) {
                                    switch (i3) {
                                        case 11:
                                            return fileStoragePushFSSvcList.vC2CPicDownList;
                                        case 12:
                                        case 13:
                                        case 14:
                                        case 15:
                                        case 17:
                                            return getDomainSvrList(getDomainType(i3));
                                        case 16:
                                            return this.mGroupPttIpList.getIpList(this.mRichMediaIpSaver.Wd());
                                        default:
                                            return getBigDataSvcList(getBigDataServiceType(i3));
                                    }
                                }
                                return fileStoragePushFSSvcList.vVipEmotionList;
                            }
                            return fileStoragePushFSSvcList.vUrlEncodeServiceList;
                        }
                        return fileStoragePushFSSvcList.vQzoneProxyServiceList;
                    }
                    return fileStoragePushFSSvcList.vGPicDownLoadList;
                }
                return fileStoragePushFSSvcList.vPicDownLoadList;
            }
            return fileStoragePushFSSvcList.vUpLoadList;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getSvcList error,mSvcList=null");
            return null;
        }
        return null;
    }

    private byte[] getTlvByteFromGroupPttIpList(PttIpList pttIpList) {
        byte[][] bArr;
        byte[][] bArr2;
        byte[] bArr3;
        int i3;
        int i16;
        byte[] bArr4;
        if (pttIpList != null) {
            ArrayList<FileStorageServerListInfo> arrayList = pttIpList.groupPttDownloadWifiIPLIst;
            if (arrayList != null && arrayList.size() > 0) {
                bArr = new byte[pttIpList.groupPttDownloadWifiIPLIst.size()];
            } else {
                bArr = null;
            }
            ArrayList<FileStorageServerListInfo> arrayList2 = pttIpList.groupPttDownloadXGIPLIst;
            if (arrayList2 != null && arrayList2.size() > 0) {
                bArr2 = new byte[pttIpList.groupPttDownloadXGIPLIst.size()];
            } else {
                bArr2 = null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                String str = pttIpList.wifiIdentifier;
                if (str != null) {
                    dataOutputStream.writeUTF(str);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.reset();
                    i16 = 1;
                    bArr3 = byteArray;
                    i3 = byteArray.length + 3 + 0;
                } else {
                    bArr3 = null;
                    i3 = 0;
                    i16 = 0;
                }
                String str2 = pttIpList.xGIdentifier;
                if (str2 != null) {
                    dataOutputStream.writeUTF(str2);
                    bArr4 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.reset();
                    i3 += bArr4.length + 3;
                    i16++;
                } else {
                    bArr4 = null;
                }
                ArrayList<FileStorageServerListInfo> arrayList3 = pttIpList.groupPttDownloadWifiIPLIst;
                if (arrayList3 != null && arrayList3.size() > 0) {
                    for (int i17 = 0; i17 < pttIpList.groupPttDownloadWifiIPLIst.size(); i17++) {
                        FileStorageServerListInfo fileStorageServerListInfo = pttIpList.groupPttDownloadWifiIPLIst.get(i17);
                        dataOutputStream.writeInt(fileStorageServerListInfo.iPort);
                        dataOutputStream.writeUTF(fileStorageServerListInfo.sIP);
                        bArr[i17] = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.reset();
                        i3 += bArr[i17].length + 3;
                        i16++;
                    }
                }
                ArrayList<FileStorageServerListInfo> arrayList4 = pttIpList.groupPttDownloadXGIPLIst;
                if (arrayList4 != null && arrayList4.size() > 0) {
                    for (int i18 = 0; i18 < pttIpList.groupPttDownloadXGIPLIst.size(); i18++) {
                        FileStorageServerListInfo fileStorageServerListInfo2 = pttIpList.groupPttDownloadXGIPLIst.get(i18);
                        dataOutputStream.writeInt(fileStorageServerListInfo2.iPort);
                        dataOutputStream.writeUTF(fileStorageServerListInfo2.sIP);
                        bArr2[i18] = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.reset();
                        i3 += bArr2[i18].length + 3;
                        i16++;
                    }
                }
                byte[] bytes = getBytes(bArr3, bArr4, bArr, bArr2, i3, (byte) i16, 0);
                try {
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                } catch (Throwable unused) {
                }
                return bytes;
            } catch (Throwable th5) {
                try {
                    th5.printStackTrace();
                    try {
                        byteArrayOutputStream.close();
                        dataOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                } finally {
                }
            }
        }
        return null;
    }

    private void init() {
        FmtIPInfo fmtIPInfo;
        for (int i3 = 1; i3 < 8; i3++) {
            getBigDataSvcList(i3);
        }
        this.mChooser.init(this.mSvcList);
        FileStoragePushFSSvcList fileStoragePushFSSvcList = this.mSvcList;
        if (fileStoragePushFSSvcList != null && (fmtIPInfo = fileStoragePushFSSvcList.fmtIPInfo) != null) {
            this.mGatewayIp = fmtIPInfo.sGateIp;
            this.mGateIpOper = fmtIPInfo.iGateIpOper;
        }
        if (fileStoragePushFSSvcList == null) {
            this.mGateIpOper = -1L;
            this.mGatewayIp = "";
        }
        downloadEncryptConfInit();
    }

    public static String intToIp(int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append((i3 >> 0) & 255);
        sb5.append('.');
        sb5.append((i3 >> 8) & 255);
        sb5.append('.');
        sb5.append((i3 >> 16) & 255);
        sb5.append('.');
        sb5.append((i3 >> 24) & 255);
        return sb5.toString();
    }

    private void parseGroupPttDownloadIPList() {
        byte[] bArr;
        FileStoragePushFSSvcList fileStoragePushFSSvcList = this.mSvcList;
        if (fileStoragePushFSSvcList != null && (bArr = fileStoragePushFSSvcList.pttlist) != null && bArr.length != 0) {
            this.mGroupPttIpList = getPttIpListFromTlvByte(bArr);
        } else {
            doClearGroupPttDownloadIPList();
        }
    }

    private FileStoragePushFSSvcList readFromFile() {
        FileStoragePushFSSvcList fileStoragePushFSSvcList;
        File createFile;
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    createFile = FileUtils.createFile(getPrivatePath(FMT_SVC_INI_FILE_NAME));
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e16) {
                e = e16;
                fileStoragePushFSSvcList = null;
            }
        } catch (IOException unused) {
        }
        if (createFile.length() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "read file failed, f.length() == 0");
            }
            return null;
        }
        FileInputStream fileInputStream2 = new FileInputStream(createFile);
        try {
            try {
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                JceInputStream jceInputStream = new JceInputStream(byteArrayOutputStream.toByteArray());
                fileStoragePushFSSvcList = new FileStoragePushFSSvcList();
                try {
                    fileStoragePushFSSvcList.readFrom(jceInputStream);
                    fileInputStream2.close();
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "", e);
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return fileStoragePushFSSvcList;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e18) {
            e = e18;
            fileStoragePushFSSvcList = null;
        }
        return fileStoragePushFSSvcList;
    }

    private void writeToFile(FileStoragePushFSSvcList fileStoragePushFSSvcList) {
        File createFile;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    createFile = FileUtils.createFile(getPrivatePath(FMT_SVC_INI_TMP_FILE_NAME));
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e16) {
                e = e16;
            }
        } catch (IOException unused) {
        }
        if (fileStoragePushFSSvcList == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "FMT SERVER writeToFile list==null");
            }
            if (createFile != null && createFile.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "FMT SERVER writeToFile list==null,delete old file?");
                }
                createFile.delete();
                return;
            }
            return;
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        fileStoragePushFSSvcList.writeTo(jceOutputStream);
        byte[] byteArray = jceOutputStream.toByteArray();
        FileOutputStream fileOutputStream2 = new FileOutputStream(createFile, false);
        try {
            fileOutputStream2.write(byteArray);
            File file = new File(getPrivatePath(FMT_SVC_INI_FILE_NAME));
            if (file.exists()) {
                file.delete();
            }
            createFile.renameTo(file);
            fileOutputStream2.close();
        } catch (Exception e17) {
            e = e17;
            fileOutputStream = fileOutputStream2;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "FMT SERVER,writeToFile error", e);
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileStoragePushFSSvcList == null) {
            } else {
                return;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = fileOutputStream2;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
        if (fileStoragePushFSSvcList == null && QLog.isColorLevel()) {
            QLog.d(TAG, 2, "FMT SERVER,writeToFile LIST persist OK");
        }
    }

    public synchronized void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "FMT SERVER LIST CLEARED!!!");
        }
        if (this.mSvcList == null) {
            this.mSvcList = new FileStoragePushFSSvcList();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "bug, not supposed to be null");
            }
        }
        FileStoragePushFSSvcList fileStoragePushFSSvcList = this.mSvcList;
        ArrayList<FileStorageServerListInfo> arrayList = fileStoragePushFSSvcList.vC2CPicDownList;
        ArrayList<FileStorageServerListInfo> arrayList2 = fileStoragePushFSSvcList.vGPicDownLoadList;
        FileStoragePushFSSvcList fileStoragePushFSSvcList2 = new FileStoragePushFSSvcList();
        fileStoragePushFSSvcList2.vC2CPicDownList = arrayList;
        fileStoragePushFSSvcList2.vGPicDownLoadList = arrayList2;
        fileStoragePushFSSvcList2.pttlist = this.mSvcList.pttlist;
        setSvcList(fileStoragePushFSSvcList2);
        this.mChooser.clear();
        this.mBigDataSvcList.clear();
        this.mDomainSvrList.clear();
        FileStoragePushFSSvcList fileStoragePushFSSvcList3 = new FileStoragePushFSSvcList();
        this.mSvcList = fileStoragePushFSSvcList3;
        fileStoragePushFSSvcList3.vC2CPicDownList = arrayList;
        fileStoragePushFSSvcList3.vGPicDownLoadList = arrayList2;
        this.mState = 2;
        init();
    }

    public subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf downloadEncryptConfInit() {
        BigDataChannel bigDataChannel;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        FileStoragePushFSSvcList fileStoragePushFSSvcList = this.mSvcList;
        subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf downloadEncryptConf = null;
        if (fileStoragePushFSSvcList != null && (bigDataChannel = fileStoragePushFSSvcList.bigDataChannel) != null && (bArr = bigDataChannel.vBigdata_pb_buf) != null && bArr.length > 0) {
            subcmd0x501.RspBody rspBody = new subcmd0x501.RspBody();
            try {
                rspBody.mergeFrom(bArr);
            } catch (Exception e16) {
                e16.printStackTrace();
                rspBody = null;
            }
            if (rspBody != null) {
                downloadEncryptConf = rspBody.msg_subcmd_0x501_rsp_body.get().msg_download_encrypt_conf;
                if (QLog.isColorLevel() && downloadEncryptConf != null) {
                    QLog.d(TAG, 2, "picEncryptSwitchInit: pic:" + downloadEncryptConf.bool_enable_encrypted_pic.get() + ",url:" + downloadEncryptConf.bool_enable_encrypt_request.get() + ",ctlFlg:" + downloadEncryptConf.uint32_ctrl_flag.get());
                }
            }
        }
        return downloadEncryptConf;
    }

    public synchronized ArrayList<FileStorageServerListInfo> getAllIpList(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        return getSvcList(i3);
    }

    public synchronized byte[] getBigDataSrvKey(long j3) {
        BigDataChannel bigDataChannel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (byte[]) iPatchRedirector.redirect((short) 15, (Object) this, j3);
        }
        FileStoragePushFSSvcList fileStoragePushFSSvcList = this.mSvcList;
        if (fileStoragePushFSSvcList != null && (bigDataChannel = fileStoragePushFSSvcList.bigDataChannel) != null && bigDataChannel.uSig_Uin == j3) {
            return bigDataChannel.sBigdata_key_session;
        }
        return null;
    }

    public synchronized byte[] getBigDataSrvSign(long j3) {
        BigDataChannel bigDataChannel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (byte[]) iPatchRedirector.redirect((short) 14, (Object) this, j3);
        }
        FileStoragePushFSSvcList fileStoragePushFSSvcList = this.mSvcList;
        if (fileStoragePushFSSvcList != null && (bigDataChannel = fileStoragePushFSSvcList.bigDataChannel) != null && bigDataChannel.uSig_Uin == j3) {
            return bigDataChannel.sBigdata_sig_session;
        }
        return null;
    }

    public synchronized ServerAddr getFirst(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ServerAddr) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        ArrayList<FileStorageServerListInfo> svcList = getSvcList(i3);
        if (svcList != null && svcList.size() > 0) {
            ServerAddr serverAddr = new ServerAddr();
            serverAddr.mIp = svcList.get(0).sIP;
            serverAddr.port = svcList.get(0).iPort;
            return serverAddr;
        }
        return null;
    }

    public long getGateIpOper() {
        FmtIPInfo fmtIPInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        FileStoragePushFSSvcList readFromFile = readFromFile();
        if (readFromFile != null && (fmtIPInfo = readFromFile.fmtIPInfo) != null) {
            return fmtIPInfo.iGateIpOper;
        }
        return -1L;
    }

    public long getGateIpOperFromMemeory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.mGateIpOper;
    }

    public String getGateWayIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.mGatewayIp;
    }

    public HwConfig getHighwayConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (HwConfig) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        Map<Integer, HwConfig> highwayConfigMap = getHighwayConfigMap();
        if (highwayConfigMap != null) {
            return highwayConfigMap.get(10);
        }
        return null;
    }

    public synchronized Map<Integer, HwConfig> getHighwayConfigMap() {
        BigDataChannel bigDataChannel;
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Map) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        HashMap hashMap = new HashMap();
        FileStoragePushFSSvcList fileStoragePushFSSvcList = this.mSvcList;
        if (fileStoragePushFSSvcList != null && (bigDataChannel = fileStoragePushFSSvcList.bigDataChannel) != null) {
            ArrayList<BigDataIpList> arrayList = bigDataChannel.vBigdata_iplists;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("GetHighwayConfig  Has PbBuffer : ");
            if (this.mSvcList.bigDataChannel.vBigdata_pb_buf != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(String.valueOf(z16));
            sb5.append(" IpList : ");
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            QLog.d(TAG, 2, sb5.toString());
            byte[] bArr = this.mSvcList.bigDataChannel.vBigdata_pb_buf;
            if (bArr != null && bArr.length > 0) {
                subcmd0x501.RspBody rspBody = new subcmd0x501.RspBody();
                try {
                    rspBody.mergeFrom(bArr);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    rspBody = null;
                }
                if (rspBody != null) {
                    subcmd0x501.SubCmd0x501Rspbody subCmd0x501Rspbody = rspBody.msg_subcmd_0x501_rsp_body.get();
                    String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                    if (account.equals(String.valueOf(this.mSvcList.bigDataChannel.uSig_Uin))) {
                        SessionInfo.updateSessionInfo(subCmd0x501Rspbody.bytes_httpconn_sig_session.get().toByteArray(), subCmd0x501Rspbody.bytes_session_key.get().toByteArray(), account);
                    }
                    List<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs> list = subCmd0x501Rspbody.rpt_msg_httpconn_addrs.get();
                    if (list != null && list.size() != 0) {
                        decodeSrvAddrs(hashMap, subCmd0x501Rspbody, list);
                    } else if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "GetHighwayConfig srvAddrList == null || srvAddrList.size() == 0");
                    }
                }
            }
        }
        return hashMap;
    }

    public ArrayList<FileStorageServerListInfo> getIpListFromPb(byte[] bArr) {
        List<ptt_apply$Addr> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ArrayList) iPatchRedirector.redirect((short) 25, (Object) this, (Object) bArr);
        }
        ptt_apply$QQApplyAuthkeyRsp ptt_apply_qqapplyauthkeyrsp = new ptt_apply$QQApplyAuthkeyRsp();
        try {
            ptt_apply_qqapplyauthkeyrsp.mergeFrom(bArr);
            if (ptt_apply_qqapplyauthkeyrsp.address.has() && (list = ptt_apply_qqapplyauthkeyrsp.address.get()) != null && list.size() > 0) {
                ArrayList<FileStorageServerListInfo> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    ptt_apply$Addr ptt_apply_addr = list.get(i3);
                    int i16 = ptt_apply_addr.uint32_out_ip.get();
                    if (i16 != 0) {
                        arrayList.add(new FileStorageServerListInfo(intToIp(i16), ptt_apply_addr.uint32_out_port.get()));
                    }
                }
                return arrayList;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public StructLongMessageIpSaver getLongMsgIpSaver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (StructLongMessageIpSaver) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mLongMsgIpSaver;
    }

    public subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf getPicDownEncryptConf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (this.encryptConf == null) {
            this.encryptConf = downloadEncryptConfInit();
        }
        if (QLog.isColorLevel()) {
            if (this.encryptConf != null) {
                QLog.d(TAG, 2, "getPicEncryptSwitch: pic:" + this.encryptConf.bool_enable_encrypted_pic.get() + ",url:" + this.encryptConf.bool_enable_encrypt_request.get() + ",ctlFlag:" + this.encryptConf.uint32_ctrl_flag.get());
            } else {
                QLog.d(TAG, 2, "getPicEncryptSwitch: none!");
            }
        }
        return this.encryptConf;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0117 A[Catch: all -> 0x011a, DONT_GENERATE, TRY_LEAVE, TryCatch #5 {all -> 0x011a, blocks: (B:23:0x0112, B:17:0x0117), top: B:22:0x0112 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe A[Catch: all -> 0x011b, TRY_LEAVE, TryCatch #7 {all -> 0x011b, blocks: (B:61:0x00f9, B:54:0x00fe), top: B:60:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PttIpList getPttIpListFromTlvByte(byte[] bArr) {
        DataInputStream dataInputStream;
        PttIpList pttIpList;
        DataInputStream dataInputStream2;
        DataInputStream dataInputStream3;
        DataInputStream dataInputStream4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (PttIpList) iPatchRedirector.redirect((short) 23, (Object) this, (Object) bArr);
        }
        if (!isTlvByte(bArr)) {
            return new PttIpList();
        }
        ByteArrayInputStream byteArrayInputStream = null;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    pttIpList = new PttIpList();
                    byte b16 = bArr[1];
                    dataInputStream = null;
                    int i3 = 2;
                    for (int i16 = 0; i16 < b16; i16++) {
                        try {
                            byte b17 = bArr[i3];
                            int i17 = i3 + 1;
                            byte[] bArr2 = new byte[2];
                            System.arraycopy(bArr, i17, bArr2, 0, 2);
                            int i18 = i17 + 2;
                            int c16 = Utils.c(bArr2, 0);
                            System.arraycopy(bArr, i18, new byte[c16], 0, c16);
                            if (b17 == 1) {
                                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr, i18, c16);
                                try {
                                    dataInputStream4 = new DataInputStream(byteArrayInputStream2);
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                                try {
                                    pttIpList.wifiIdentifier = dataInputStream4.readUTF();
                                    dataInputStream = dataInputStream4;
                                    byteArrayInputStream = byteArrayInputStream2;
                                } catch (Throwable th6) {
                                    th = th6;
                                    dataInputStream = dataInputStream4;
                                    byteArrayInputStream = byteArrayInputStream2;
                                    try {
                                        th.printStackTrace();
                                        PttIpList pttIpList2 = new PttIpList();
                                        if (byteArrayInputStream != null) {
                                            try {
                                                byteArrayInputStream.close();
                                            } catch (Throwable unused) {
                                                return pttIpList2;
                                            }
                                        }
                                        if (dataInputStream != null) {
                                            dataInputStream.close();
                                            return pttIpList2;
                                        }
                                        return pttIpList2;
                                    } finally {
                                        if (byteArrayInputStream != null) {
                                            try {
                                                byteArrayInputStream.close();
                                            } catch (Throwable unused2) {
                                            }
                                        }
                                        if (dataInputStream != null) {
                                            dataInputStream.close();
                                        }
                                    }
                                }
                            } else if (b17 == 2) {
                                DataInputStream dataInputStream5 = new DataInputStream(new ByteArrayInputStream(bArr, i18, c16));
                                pttIpList.xGIdentifier = dataInputStream5.readUTF();
                                ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr, i18, c16);
                                try {
                                    dataInputStream3 = new DataInputStream(byteArrayInputStream3);
                                } catch (Throwable th7) {
                                    th = th7;
                                    dataInputStream = dataInputStream5;
                                    byteArrayInputStream = byteArrayInputStream3;
                                }
                                try {
                                    pttIpList.xGError[0] = dataInputStream3.readInt();
                                    pttIpList.xGError[1] = dataInputStream3.readInt();
                                    byteArrayInputStream = byteArrayInputStream3;
                                    dataInputStream = dataInputStream3;
                                } catch (Throwable th8) {
                                    th = th8;
                                    byteArrayInputStream = byteArrayInputStream3;
                                    dataInputStream = dataInputStream3;
                                    th.printStackTrace();
                                    PttIpList pttIpList22 = new PttIpList();
                                    if (byteArrayInputStream != null) {
                                    }
                                    if (dataInputStream != null) {
                                    }
                                }
                            } else if (b17 == 3 || b17 == 4) {
                                ByteArrayInputStream byteArrayInputStream4 = new ByteArrayInputStream(bArr, i18, c16);
                                try {
                                    dataInputStream2 = new DataInputStream(byteArrayInputStream4);
                                } catch (Throwable th9) {
                                    th = th9;
                                }
                                try {
                                    int readInt = dataInputStream2.readInt();
                                    String readUTF = dataInputStream2.readUTF();
                                    if (b17 == 3) {
                                        pttIpList.groupPttDownloadWifiIPLIst.add(new FileStorageServerListInfo(readUTF, readInt));
                                    } else {
                                        pttIpList.groupPttDownloadXGIPLIst.add(new FileStorageServerListInfo(readUTF, readInt));
                                    }
                                    dataInputStream = dataInputStream2;
                                    byteArrayInputStream = byteArrayInputStream4;
                                } catch (Throwable th10) {
                                    th = th10;
                                    dataInputStream = dataInputStream2;
                                    byteArrayInputStream = byteArrayInputStream4;
                                    th.printStackTrace();
                                    PttIpList pttIpList222 = new PttIpList();
                                    if (byteArrayInputStream != null) {
                                    }
                                    if (dataInputStream != null) {
                                    }
                                }
                            }
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                            if (dataInputStream != null) {
                                dataInputStream.close();
                            }
                            i3 = i18 + c16;
                        } catch (Throwable th11) {
                            th = th11;
                        }
                    }
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return pttIpList;
                }
            } catch (Throwable th12) {
                th = th12;
                dataInputStream = null;
            }
        }
        pttIpList = null;
        dataInputStream = null;
        return pttIpList;
    }

    public com.tencent.mobileqq.richmedia.c getPttIpSaver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.richmedia.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mRichMediaIpSaver;
    }

    public synchronized String getSrvAddr(int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        FileStorageServerListInfo addr = this.mChooser.getAddr(i3);
        if (addr != null) {
            StringBuffer stringBuffer = new StringBuffer(200);
            stringBuffer.append("http://");
            stringBuffer.append(addr.sIP);
            if (addr.iPort != 80) {
                stringBuffer.append(":");
                stringBuffer.append(addr.iPort);
            }
            stringBuffer.append("/");
            str = stringBuffer.toString();
        } else {
            str = null;
        }
        return str;
    }

    public synchronized String getSrvAddrForPttDownload() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        FileStorageServerListInfo addrForPttDownload = this.mChooser.getAddrForPttDownload();
        if (addrForPttDownload != null) {
            StringBuffer stringBuffer = new StringBuffer(200);
            stringBuffer.append("http://");
            stringBuffer.append(addrForPttDownload.sIP);
            if (addrForPttDownload.iPort != 80) {
                stringBuffer.append(":");
                stringBuffer.append(addrForPttDownload.iPort);
            }
            stringBuffer.append("/");
            str = stringBuffer.toString();
        } else {
            str = null;
        }
        return str;
    }

    public int getState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mState;
    }

    public boolean isTlvByte(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) bArr)).booleanValue();
        }
        if (bArr == null) {
            return false;
        }
        try {
            if (bArr.length == 0 || bArr[0] != 0) {
                return false;
            }
            byte b16 = bArr[1];
            int i3 = 2;
            for (int i16 = 0; i16 < b16; i16++) {
                int i17 = i3 + 1;
                byte[] bArr2 = new byte[2];
                System.arraycopy(bArr, i17, bArr2, 0, 2);
                i3 = i17 + 2 + Utils.c(bArr2, 0);
                if (i3 > bArr.length) {
                    return false;
                }
            }
            if (i3 != bArr.length) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.mRichMediaIpSaver.destroy();
            this.mLongMsgIpSaver.destroy();
        }
    }

    public synchronized void onFailed(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3, (Object) str);
            return;
        }
        if (i3 == 16) {
            this.mGroupPttIpList.onFailed(this.mRichMediaIpSaver.Wd(), str);
            if (QLog.isDevelopLevel()) {
                QLog.d("SPD", 4, "onFailed for GroupPtt: " + str);
            }
        } else {
            this.mChooser.onFailed(i3, str);
        }
    }

    public byte[] replaceWithTLVForPtt(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (byte[]) iPatchRedirector.redirect((short) 22, (Object) this, (Object) bArr);
        }
        ArrayList<FileStorageServerListInfo> ipListFromPb = getIpListFromPb(bArr);
        String Wd = this.mRichMediaIpSaver.Wd();
        boolean isWifi = this.mRichMediaIpSaver.isWifi();
        PttIpList pttIpList = this.mGroupPttIpList;
        if (pttIpList != null) {
            if (isWifi) {
                pttIpList.groupPttDownloadWifiIPLIst = ipListFromPb;
                pttIpList.wifiIdentifier = Wd;
            } else {
                pttIpList.groupPttDownloadXGIPLIst = ipListFromPb;
                pttIpList.xGIdentifier = Wd;
            }
        }
        return getTlvByteFromGroupPttIpList(pttIpList);
    }

    public synchronized void setSvcList(FileStoragePushFSSvcList fileStoragePushFSSvcList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) fileStoragePushFSSvcList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "set svclist" + fileStoragePushFSSvcList);
        }
        this.mSvcList = fileStoragePushFSSvcList;
        this.mState = 1;
        init();
        writeToFile(fileStoragePushFSSvcList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class SrvAddrChooser {
        static IPatchRedirector $redirector_ = null;
        private static final int MAX_FAILED_TIMES = 5;
        private static final int MAX_FAILED_XG_TIMES = 2;
        private int[][] mUrlFailedTimes;
        private Random rand;

        SrvAddrChooser() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FMTSrvAddrProvider.this);
            } else {
                this.rand = new Random(System.currentTimeMillis());
            }
        }

        private int findBestServer(int[] iArr) {
            if (iArr != null) {
                ArrayList arrayList = new ArrayList();
                int i3 = 5;
                for (int i16 = 0; i16 < iArr.length; i16++) {
                    int i17 = iArr[i16];
                    if (i17 < i3) {
                        arrayList.clear();
                        arrayList.add(Integer.valueOf(i16));
                        i3 = i17;
                    } else if (i17 == i3) {
                        arrayList.add(Integer.valueOf(i16));
                    }
                }
                if (arrayList.size() > 0) {
                    return ((Integer) arrayList.get(Math.abs(this.rand.nextInt()) % arrayList.size())).intValue();
                }
            }
            return -1;
        }

        private int findBestServerForPttDown(int[] iArr) {
            int i3;
            if (!FMTSrvAddrProvider.this.mRichMediaIpSaver.isWifi()) {
                i3 = 2;
            } else {
                i3 = 5;
            }
            if (iArr != null) {
                for (int i16 = 0; i16 < iArr.length; i16++) {
                    if (iArr[i16] < i3) {
                        return i16;
                    }
                }
            }
            return -1;
        }

        FileStorageServerListInfo getAddr(int i3) {
            FileStorageServerListInfo fileStorageServerListInfo;
            int findBestServer;
            ArrayList svcList = FMTSrvAddrProvider.this.getSvcList(i3);
            if (svcList != null && svcList.size() > 0 && (findBestServer = findBestServer(getFailedTimesArray(i3))) > -1 && findBestServer < svcList.size()) {
                fileStorageServerListInfo = (FileStorageServerListInfo) svcList.get(findBestServer);
            } else {
                fileStorageServerListInfo = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(FMTSrvAddrProvider.TAG, 2, "getAddr error,ret=null");
            }
            return fileStorageServerListInfo;
        }

        FileStorageServerListInfo getAddrForPttDownload() {
            FileStorageServerListInfo fileStorageServerListInfo;
            int findBestServerForPttDown;
            ArrayList svcList = FMTSrvAddrProvider.this.getSvcList(16);
            if (svcList != null && svcList.size() > 0 && (findBestServerForPttDown = findBestServerForPttDown(FMTSrvAddrProvider.this.mGroupPttIpList.getPttFailTimesArea(FMTSrvAddrProvider.this.mRichMediaIpSaver.Wd()))) > -1 && findBestServerForPttDown < svcList.size()) {
                fileStorageServerListInfo = (FileStorageServerListInfo) svcList.get(findBestServerForPttDown);
            } else {
                fileStorageServerListInfo = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(FMTSrvAddrProvider.TAG, 2, "getAddr error,ret=null");
            }
            return fileStorageServerListInfo;
        }

        int[] getFailedTimesArray(int i3) {
            int[][] iArr = this.mUrlFailedTimes;
            if (iArr == null) {
                return null;
            }
            return iArr[i3];
        }

        ArrayList<FileStorageServerListInfo> getOrderAddrList(int i3) {
            int i16;
            int i17;
            int i18;
            ArrayList svcList = FMTSrvAddrProvider.this.getSvcList(i3);
            if (svcList != null && svcList.size() > 0) {
                int size = svcList.size();
                if (size >= 3) {
                    size = 3;
                }
                ArrayList<FileStorageServerListInfo> arrayList = new ArrayList<>(size);
                int[] failedTimesArray = getFailedTimesArray(i3);
                if (failedTimesArray != null && failedTimesArray.length == svcList.size()) {
                    int i19 = Integer.MAX_VALUE;
                    int i26 = Integer.MAX_VALUE;
                    int i27 = 0;
                    for (int i28 = 0; i28 < failedTimesArray.length; i28++) {
                        int i29 = failedTimesArray[i28];
                        if (i29 < i26) {
                            i27 = i28;
                            i26 = i29;
                        }
                    }
                    arrayList.add(0, (FileStorageServerListInfo) svcList.get(i27));
                    if (size >= 2) {
                        int i36 = Integer.MAX_VALUE;
                        i16 = 0;
                        for (int i37 = 0; i37 < failedTimesArray.length; i37++) {
                            if (i37 != i27 && (i18 = failedTimesArray[i37]) < i36) {
                                i16 = i37;
                                i36 = i18;
                            }
                        }
                        arrayList.add(1, (FileStorageServerListInfo) svcList.get(i16));
                    } else {
                        i16 = 0;
                    }
                    if (size >= 3) {
                        int i38 = 0;
                        for (int i39 = 0; i39 < failedTimesArray.length; i39++) {
                            if (i39 != i27 && i39 != i16 && (i17 = failedTimesArray[i39]) < i19) {
                                i19 = i17;
                                i38 = i39;
                            }
                        }
                        arrayList.add(2, (FileStorageServerListInfo) svcList.get(i38));
                    }
                    return arrayList;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(FMTSrvAddrProvider.TAG, 2, "getAddr error,ret=null");
                return null;
            }
            return null;
        }

        void init(FileStoragePushFSSvcList fileStoragePushFSSvcList) {
            int i3;
            int i16;
            if (fileStoragePushFSSvcList != null) {
                this.mUrlFailedTimes = new int[18];
                ArrayList<FileStorageServerListInfo> arrayList = fileStoragePushFSSvcList.vUrlEncodeServiceList;
                if (arrayList != null && arrayList.size() > 0) {
                    this.mUrlFailedTimes[4] = new int[fileStoragePushFSSvcList.vUrlEncodeServiceList.size()];
                }
                ArrayList<FileStorageServerListInfo> arrayList2 = fileStoragePushFSSvcList.vGPicDownLoadList;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    this.mUrlFailedTimes[2] = new int[fileStoragePushFSSvcList.vGPicDownLoadList.size()];
                }
                ArrayList<FileStorageServerListInfo> arrayList3 = fileStoragePushFSSvcList.vPicDownLoadList;
                if (arrayList3 != null && arrayList3.size() > 0) {
                    this.mUrlFailedTimes[1] = new int[fileStoragePushFSSvcList.vPicDownLoadList.size()];
                }
                ArrayList<FileStorageServerListInfo> arrayList4 = fileStoragePushFSSvcList.vQzoneProxyServiceList;
                if (arrayList4 != null && arrayList4.size() > 0) {
                    this.mUrlFailedTimes[3] = new int[fileStoragePushFSSvcList.vQzoneProxyServiceList.size()];
                }
                ArrayList<FileStorageServerListInfo> arrayList5 = fileStoragePushFSSvcList.vUpLoadList;
                int i17 = 0;
                if (arrayList5 != null && arrayList5.size() > 0) {
                    this.mUrlFailedTimes[0] = new int[fileStoragePushFSSvcList.vUpLoadList.size()];
                }
                ArrayList<FileStorageServerListInfo> arrayList6 = fileStoragePushFSSvcList.vVipEmotionList;
                if (arrayList6 != null && arrayList6.size() > 0) {
                    this.mUrlFailedTimes[5] = new int[fileStoragePushFSSvcList.vVipEmotionList.size()];
                }
                ArrayList<FileStorageServerListInfo> arrayList7 = fileStoragePushFSSvcList.vC2CPicDownList;
                if (arrayList7 != null && arrayList7.size() > 0) {
                    this.mUrlFailedTimes[11] = new int[fileStoragePushFSSvcList.vC2CPicDownList.size()];
                }
                for (int i18 = 6; i18 <= 10; i18++) {
                    FMTSrvAddrProvider fMTSrvAddrProvider = FMTSrvAddrProvider.this;
                    ArrayList bigDataSvcList = fMTSrvAddrProvider.getBigDataSvcList(fMTSrvAddrProvider.getBigDataServiceType(i18));
                    if (bigDataSvcList != null) {
                        i16 = bigDataSvcList.size();
                    } else {
                        i16 = 0;
                    }
                    this.mUrlFailedTimes[i18] = new int[i16];
                }
                for (int i19 = 12; i19 <= 15; i19++) {
                    FMTSrvAddrProvider fMTSrvAddrProvider2 = FMTSrvAddrProvider.this;
                    ArrayList domainSvrList = fMTSrvAddrProvider2.getDomainSvrList(fMTSrvAddrProvider2.getDomainType(i19));
                    if (domainSvrList != null) {
                        i3 = domainSvrList.size();
                    } else {
                        i3 = 0;
                    }
                    this.mUrlFailedTimes[i19] = new int[i3];
                }
                FMTSrvAddrProvider fMTSrvAddrProvider3 = FMTSrvAddrProvider.this;
                ArrayList domainSvrList2 = fMTSrvAddrProvider3.getDomainSvrList(fMTSrvAddrProvider3.getDomainType(17));
                if (domainSvrList2 != null) {
                    i17 = domainSvrList2.size();
                }
                this.mUrlFailedTimes[17] = new int[i17];
            }
            FMTSrvAddrProvider.this.mGroupPttIpList.initError();
        }

        void onFailed(int i3, String str) {
            String host;
            try {
                ArrayList svcList = FMTSrvAddrProvider.this.getSvcList(i3);
                int[] failedTimesArray = getFailedTimesArray(i3);
                if (svcList != null && svcList.size() > 0 && failedTimesArray != null && failedTimesArray.length > 0 && (host = new URL(str).getHost()) != null && host.length() > 0) {
                    for (int i16 = 0; i16 < svcList.size(); i16++) {
                        String str2 = ((FileStorageServerListInfo) svcList.get(i16)).sIP;
                        if (str2 != null && str2.equalsIgnoreCase(host)) {
                            if (failedTimesArray.length > i16) {
                                failedTimesArray[i16] = failedTimesArray[i16] + 1;
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (MalformedURLException unused) {
            }
        }

        void clear() {
        }
    }
}
