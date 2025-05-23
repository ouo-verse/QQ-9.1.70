package com.tencent.mobileqq.highway.config;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import com.tencent.mobileqq.highway.iplearning.IpLearningImpl;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.PTVUpConfigInfo;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HwServlet extends MSFServlet {
    static IPatchRedirector $redirector_ = null;
    private static final String CMD_GET_IP_LIST = "HttpConn.0x6ff_501";
    private static final int CMD_ID_GET_CONFIG = 181;
    private static final int CMD_ID_REPORT_TRAFFIC = 182;
    private static final String CMD_PIC_UP = "LongConn.OffPicUp";
    public static final int HIGHWAY_SERVICE_HTTPS = 21;
    public static final int HIGHWAY_SERVICE_TYPE = 10;
    private static final String PARAM_FLAG = "flag";
    private static final String PARAM_IP = "ip";
    private static final String PARAM_NETWORKTYPE = "networktype";
    private static final String PARAM_PORT = "port";
    private static final String PARAM_REQUEST_TYPE = "param_req_type";
    private static final String PARAM_SIZE = "buffersize";
    private static final String PARAM_TYPE = "mType";
    private static final String PARAM_UIN = "param_uin";
    private static final String TAG = "HWConfigManager";
    public static WeakReference<OnGetConfigListener> mGetConfigListener;
    private static AtomicBoolean mHasStart;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface OnGetConfigListener {
        void onGetConfig();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9214);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            mHasStart = new AtomicBoolean(false);
        }
    }

    public HwServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private HwConfig generateConfig(subcmd0x501.SubCmd0x501Rspbody.SrvAddrs srvAddrs) {
        boolean z16;
        boolean z17;
        HwConfig hwConfig = new HwConfig();
        hwConfig.ipList = new ArrayList<>();
        hwConfig.netSegConfList = new ArrayList<>();
        hwConfig.shortVideoSegConfList = new ArrayList<>();
        List<subcmd0x501.SubCmd0x501Rspbody.IpAddr> list = srvAddrs.rpt_msg_addrs.get();
        if (list != null && list.size() != 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                subcmd0x501.SubCmd0x501Rspbody.IpAddr ipAddr = list.get(i3);
                ArrayList<EndPoint> arrayList = hwConfig.ipList;
                String spliceCircleUrl = spliceCircleUrl(ipAddr.uint32_ip.get());
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
                String spliceIpv6Url = spliceIpv6Url(ip6Addr.bytes_ip6.get().toByteArray());
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

    public static void getConfig(AppRuntime appRuntime, String str) {
        getConfig(appRuntime, str, null);
    }

    private void handleIpv6Cfg(subcmd0x501.RspBody rspBody) {
        int i3;
        boolean z16;
        int i16;
        boolean z17 = true;
        int i17 = 0;
        if (rspBody.msg_subcmd_0x501_rsp_body.uint32_fmt_policy.has()) {
            i3 = rspBody.msg_subcmd_0x501_rsp_body.uint32_fmt_policy.get();
            z16 = true;
        } else {
            i3 = 0;
            z16 = false;
        }
        if (rspBody.msg_subcmd_0x501_rsp_body.uint32_bigdata_policy.has()) {
            i16 = rspBody.msg_subcmd_0x501_rsp_body.uint32_bigdata_policy.get();
            z16 = true;
        } else {
            i16 = 0;
        }
        if (rspBody.msg_subcmd_0x501_rsp_body.uint32_conn_attempt_delay.has()) {
            i17 = rspBody.msg_subcmd_0x501_rsp_body.uint32_conn_attempt_delay.get();
        } else {
            z17 = z16;
        }
        if (z17) {
            Ipv6Config.updateCfgFromSrv(BaseApplication.getContext(), i3, i16, i17);
        }
    }

    public static boolean isNetworkTypeMobile(int i3) {
        if (i3 != 0 && i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5) {
            return false;
        }
        return true;
    }

    public static void reportTraffic(AppRuntime appRuntime, String str, int i3, String str2, boolean z16, long j3) {
        if (appRuntime != null && j3 > 0) {
            int i16 = 0;
            try {
                int type = NetworkMonitor.getType(((ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo());
                if (type == 1) {
                    i16 = 2;
                } else {
                    if (type != 0 && !isNetworkTypeMobile(type)) {
                        i16 = NetConnInfoCenterImpl.getSystemNetworkType();
                    }
                    i16 = 1;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            NewIntent newIntent = new NewIntent(appRuntime.getApplication(), HwServlet.class);
            newIntent.putExtra("param_req_type", 182);
            newIntent.putExtra("ip", str);
            newIntent.putExtra("port", i3);
            newIntent.putExtra("mType", str2);
            newIntent.putExtra("flag", !z16 ? 1 : 0);
            newIntent.putExtra(PARAM_SIZE, j3);
            newIntent.putExtra("networktype", i16);
            appRuntime.startServlet(newIntent);
        }
    }

    public static void reportTraffic4PicUp(AppRuntime appRuntime, String str, int i3, boolean z16, long j3) {
        reportTraffic(appRuntime, str, i3, "LongConn.OffPicUp", z16, j3);
    }

    private boolean reqGetIPList(Intent intent, Packet packet) {
        long longExtra = intent.getLongExtra("param_uin", 0L);
        if (longExtra == 0) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "HwServlet.reqGetIPList() fail due to uin=0");
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "HwServlet.reqGetIPList() req get ip list..");
        subcmd0x501.SubCmd0x501ReqBody subCmd0x501ReqBody = new subcmd0x501.SubCmd0x501ReqBody();
        subCmd0x501ReqBody.uint64_uin.set(longExtra);
        subCmd0x501ReqBody.uint32_idc_id.set(0);
        subCmd0x501ReqBody.uint32_appid.set(16);
        subCmd0x501ReqBody.uint32_login_sig_type.set(1);
        subCmd0x501ReqBody.uint32_request_flag.set(3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(21);
        subCmd0x501ReqBody.rpt_uint32_service_types.set(arrayList);
        subCmd0x501ReqBody.uint32_plat.set(9);
        subcmd0x501.ReqBody reqBody = new subcmd0x501.ReqBody();
        reqBody.msg_subcmd_0x501_req_body.set(subCmd0x501ReqBody);
        packet.setSSOCommand("HttpConn.0x6ff_501");
        byte[] byteArray = reqBody.toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4);
        allocate.put(byteArray);
        packet.putSendData(allocate.array());
        return true;
    }

    public static void resetStartMask() {
        mHasStart.set(false);
    }

    private void respGetIPList(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        Iterator<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs> it;
        String str2;
        int i3;
        HwServlet hwServlet = this;
        String str3 = BdhLogUtil.LogTag.Tag_Conn;
        boolean isSuccess = fromServiceMsg.isSuccess();
        long longExtra = intent.getLongExtra("param_uin", 0L);
        QLog.d(BdhLogUtil.Tag, 1, "HwServlet.respGetIPList() result:" + isSuccess + " uin:" + longExtra);
        if (!fromServiceMsg.isSuccess() || longExtra <= 0) {
            return;
        }
        ConfigManager configManager = ConfigManager.getInstance(null, null);
        subcmd0x501.RspBody rspBody = new subcmd0x501.RspBody();
        try {
            byte[] bArr = new byte[r4.getInt() - 4];
            ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
            rspBody.mergeFrom(bArr);
            subcmd0x501.SubCmd0x501Rspbody subCmd0x501Rspbody = rspBody.msg_subcmd_0x501_rsp_body.get();
            SessionInfo.updateSessionInfo(subCmd0x501Rspbody.bytes_httpconn_sig_session.get().toByteArray(), subCmd0x501Rspbody.bytes_session_key.get().toByteArray(), String.valueOf(longExtra));
            List<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs> list = subCmd0x501Rspbody.rpt_msg_httpconn_addrs.get();
            if (list != null && list.size() != 0) {
                Iterator<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs> it5 = list.iterator();
                while (it5.hasNext()) {
                    subcmd0x501.SubCmd0x501Rspbody.SrvAddrs next = it5.next();
                    int i16 = next.uint32_service_type.get();
                    if (i16 == 10) {
                        HwConfig generateConfig = hwServlet.generateConfig(next);
                        List<subcmd0x501.SubCmd0x501Rspbody.NetSegConf> list2 = next.rpt_msg_netsegconf.get();
                        if (list2 != null) {
                            try {
                                if (list2.size() != 0) {
                                    int i17 = 0;
                                    while (i17 < list2.size()) {
                                        subcmd0x501.SubCmd0x501Rspbody.NetSegConf netSegConf = list2.get(i17);
                                        Iterator<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs> it6 = it5;
                                        List<subcmd0x501.SubCmd0x501Rspbody.NetSegConf> list3 = list2;
                                        str = str3;
                                        try {
                                            generateConfig.netSegConfList.add(new HwNetSegConf(netSegConf.uint32_net_type.get(), netSegConf.uint32_segsize.get(), netSegConf.uint32_segnum.get(), netSegConf.uint32_curconnnum.get()));
                                            i17++;
                                            it5 = it6;
                                            list2 = list3;
                                            str3 = str;
                                        } catch (InvalidProtocolBufferMicroException e16) {
                                            e = e16;
                                            str3 = str;
                                            BdhLogUtil.LogException(str3, "respGetIPList", e);
                                            return;
                                        }
                                    }
                                }
                            } catch (InvalidProtocolBufferMicroException e17) {
                                e = e17;
                                BdhLogUtil.LogException(str3, "respGetIPList", e);
                                return;
                            }
                        }
                        String str4 = str3;
                        it = it5;
                        if (configManager != null) {
                            configManager.onSrvAddrSsoGet(generateConfig);
                            str2 = str4;
                        } else {
                            str2 = str4;
                            BdhLogUtil.LogEvent(str2, "HwServlet.respGetIPList() cfg == null");
                        }
                        if (rspBody.msg_subcmd_0x501_rsp_body.msg_ip_learn_conf.has()) {
                            subcmd0x501.SubCmd0x501Rspbody.IpLearnConf ipLearnConf = rspBody.msg_subcmd_0x501_rsp_body.msg_ip_learn_conf.get();
                            if (ipLearnConf.uint32_refresh_cached_ip.has() && ipLearnConf.uint32_refresh_cached_ip.get() == 1 && configManager != null) {
                                IpContainer.refreshIpLearning();
                            }
                            if (ipLearnConf.uint32_enable_ip_learn.has() && ipLearnConf.uint32_enable_ip_learn.get() == 1) {
                                IpLearningImpl.sEnableIpLearning = 1;
                                i3 = 0;
                            }
                            i3 = 0;
                            IpLearningImpl.sEnableIpLearning = 0;
                        } else {
                            i3 = 0;
                        }
                        if (rspBody.msg_subcmd_0x501_rsp_body.msg_dyn_timeout_conf.has()) {
                            BdhSegTimeoutUtil.updateFromSrv(rspBody.msg_subcmd_0x501_rsp_body.msg_dyn_timeout_conf.get());
                        }
                        if (rspBody.msg_subcmd_0x501_rsp_body.msg_open_up_conf.has()) {
                            OpenUpConfig.updateFromSrv(rspBody.msg_subcmd_0x501_rsp_body.msg_open_up_conf.get());
                        }
                        if (rspBody.msg_subcmd_0x501_rsp_body.msg_short_video_conf.has()) {
                            List<subcmd0x501.SubCmd0x501Rspbody.NetSegConf> list4 = rspBody.msg_subcmd_0x501_rsp_body.msg_short_video_conf.get().rpt_msg_netsegconf.get();
                            if (list4 != null && list4.size() != 0) {
                                int i18 = i3;
                                while (i18 < list4.size()) {
                                    subcmd0x501.SubCmd0x501Rspbody.NetSegConf netSegConf2 = list4.get(i18);
                                    List<subcmd0x501.SubCmd0x501Rspbody.NetSegConf> list5 = list4;
                                    String str5 = str2;
                                    HwConfig hwConfig = generateConfig;
                                    generateConfig.shortVideoSegConfList.add(new HwNetSegConf(netSegConf2.uint32_net_type.get(), netSegConf2.uint32_segsize.get(), netSegConf2.uint32_segnum.get(), netSegConf2.uint32_curconnnum.get()));
                                    i18++;
                                    list4 = list5;
                                    generateConfig = hwConfig;
                                    str2 = str5;
                                }
                            }
                            str = str2;
                            VideoUpConfigInfo.updateFromSrc(rspBody.msg_subcmd_0x501_rsp_body.msg_short_video_conf);
                        } else {
                            str = str2;
                        }
                        if (rspBody.msg_subcmd_0x501_rsp_body.msg_ptv_conf.has()) {
                            PTVUpConfigInfo.updateFromSrc(rspBody.msg_subcmd_0x501_rsp_body.msg_ptv_conf.get());
                        }
                        hwServlet = this;
                        try {
                            hwServlet.handleIpv6Cfg(rspBody);
                        } catch (InvalidProtocolBufferMicroException e18) {
                            e = e18;
                            str3 = str;
                            BdhLogUtil.LogException(str3, "respGetIPList", e);
                            return;
                        }
                    } else {
                        str = str3;
                        it = it5;
                        if (i16 == 21) {
                            HwConfig generateConfig2 = hwServlet.generateConfig(next);
                            if (configManager != null) {
                                configManager.onOtherTypeSrvAddrGet(generateConfig2, i16);
                            }
                        }
                    }
                    it5 = it;
                    str3 = str;
                }
                BdhLogUtil.LogEvent(str3, "HwServlet.respGetIPList() cannot find HwServlet.HIGHWAY_SERVICE_TYPE");
                return;
            }
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "HwServlet.respGetIPList() srvAddrList == null || srvAddrList.size() == 0");
        } catch (InvalidProtocolBufferMicroException e19) {
            e = e19;
        }
    }

    public static String spliceCircleUrl(int i3) {
        return (i3 & 255) + "." + ((i3 >> 8) & 255) + "." + ((i3 >> 16) & 255) + "." + ((i3 >> 24) & 255);
    }

    public static String spliceIpv6Url(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (UnknownHostException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        OnGetConfigListener onGetConfigListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        resetStartMask();
        fromServiceMsg.getResultCode();
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (serviceCmd == null) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "cmd == null");
            return;
        }
        if (serviceCmd.equals("HttpConn.0x6ff_501")) {
            respGetIPList(intent, fromServiceMsg);
            WeakReference<OnGetConfigListener> weakReference = mGetConfigListener;
            if (weakReference != null && (onGetConfigListener = weakReference.get()) != null) {
                onGetConfigListener.onGetConfig();
                mGetConfigListener = null;
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        int i3 = extras.getInt("param_req_type", 0);
        if (i3 != 181) {
            if (i3 == 182) {
                sendToMSF(intent, MsfServiceSdk.get().getReportTrafficeMsg4Highway(intent));
                return;
            }
            return;
        }
        reqGetIPList(intent, packet);
    }

    public static void getConfig(AppRuntime appRuntime, String str, OnGetConfigListener onGetConfigListener) {
        if (str == null || appRuntime == null) {
            return;
        }
        if (onGetConfigListener != null) {
            mGetConfigListener = new WeakReference<>(onGetConfigListener);
        }
        if (mHasStart.get()) {
            return;
        }
        mHasStart.set(true);
        QLog.d(BdhLogUtil.Tag, 1, "HwServlet.getConfig() uin:" + str);
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), HwServlet.class);
        newIntent.putExtra("param_req_type", 181);
        newIntent.putExtra("param_uin", Long.parseLong(str));
        appRuntime.startServlet(newIntent);
    }
}
