package com.tencent.mobileqq.transfile.dns;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.ipv6.IpStrategyFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.dns.NtDnsManager;
import com.tencent.qqnt.dns.b;
import com.tencent.qqnt.dns.c;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class InnerDns {
    static IPatchRedirector $redirector_ = null;
    public static final int C2C_PIC_DOWNLOAD = 1004;
    public static final int CFT_DOMAIN = 1011;
    public static final int CMSHOW_GTIMG_DOMAIN = 1015;
    public static final int FACE_DOWNLOAD = 1003;
    public static final int FILE_TRANSFER = 1019;
    public static final int GROUP_PIC_DOWNLOAD = 1000;
    public static final int GUILD_LIVE_DOMAIN = 1020;
    public static final int HTTP_DOWNLOADER = 1010;
    public static final int KANDIAN_HTML_PRELOAD = 1008;
    public static final int KANDIAN_IMAGE_PRELOAD = 1009;
    public static final int KANDIAN_THIRD_VIDEO = 1006;
    public static final String NAME = "InnerDnsModule";
    public static final int NEARBY_IMG_DOWNLOAD = 1001;
    public static final int NOW_DOMAIN = 1017;
    public static final int NT_DEPEND = 1021;
    public static final int OLD_HTTP_ENGINE = 1002;
    public static final int OPEN_CGI_VISIT = 1007;
    public static final int SCRIBBLE_DOMAIN = 1018;
    public static final int SHORT_VIDEO_DOWNLOAD = 1005;
    public static final int STORY_VIDEO_DOWNLOAD = 1012;
    public static final String TAG = "NtDns";
    public static final int VAS_DOWNLOAD_DOMAIN = 1016;
    public static final int VAS_QUICKUPDATE = 1014;
    public static final int WEBVIEW_SONIC = 1013;
    private static volatile InnerDns mInstance;
    private b proxy;

    InnerDns(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.proxy = bVar;
        }
    }

    public static String getHostFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return new URL(str).getHost();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static InnerDns getInstance() {
        if (mInstance == null) {
            synchronized (InnerDns.class) {
                if (mInstance == null) {
                    mInstance = new InnerDns(NtDnsManager.f355947a.a());
                }
            }
        }
        return mInstance;
    }

    public static int getPortFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return new URL(str).getPort();
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public static void onAppDestroy() {
        if (mInstance != null) {
            mInstance.proxy.onAppDestroy();
        }
    }

    public static String replaceDomainWithIp(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str != null) {
            if (str.startsWith("http://")) {
                str3 = "http://" + str2 + "/";
            } else if (str.startsWith("https://")) {
                str3 = "https://" + str2 + "/";
            } else {
                str3 = null;
            }
            return TransFileUtil.replaceIp(str, str3);
        }
        return str;
    }

    public void onReceiveFromServer(FromServiceMsg fromServiceMsg, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, fromServiceMsg, Boolean.valueOf(z16));
            return;
        }
        b bVar = this.proxy;
        if (bVar instanceof c) {
            ((c) bVar).u(fromServiceMsg, true);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "onReceive push log:" + fromServiceMsg.getStringForLog());
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "otherProcess:" + MobileQQ.sProcessId + " get ip domain");
    }

    public void reportBadIp(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Integer.valueOf(i3));
        } else {
            this.proxy.g(str, str2, i3);
        }
    }

    public String reqDns(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
        return this.proxy.h(str, i3);
    }

    public ArrayList<String> reqDnsForIpList(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.proxy.k(str, i3) : (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
    }

    public ArrayList<ServerAddr> reqSerAddrList(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
        }
        ArrayList<ServerAddr> reqSerAddrList = reqSerAddrList(str, i3, 1);
        return IpStrategyFactory.createDownStrategy().selectIpList(reqSerAddrList(str, i3, 28), reqSerAddrList, NetConnInfoCenter.getActiveNetIpFamily(true));
    }

    public void startPullFromServer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        b bVar = this.proxy;
        if (bVar instanceof c) {
            ((c) bVar).w();
        }
    }

    public ArrayList<String> reqDnsForIpList(String str, int i3, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.proxy.l(str, i3, z16, i16) : (ArrayList) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
    }

    public ArrayList<String> reqDnsForIpList(String str, int i3, boolean z16, int i16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.proxy.m(str, i3, z16, i16, z17) : (ArrayList) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Boolean.valueOf(z17));
    }

    public ArrayList<ServerAddr> reqSerAddrList(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        ArrayList<IpData> n3 = this.proxy.n(str, i3, true);
        if (n3 == null) {
            return null;
        }
        ArrayList<ServerAddr> arrayList = new ArrayList<>();
        Iterator<IpData> it = n3.iterator();
        while (it.hasNext()) {
            IpData next = it.next();
            if (next.mType == i16) {
                ServerAddr serverAddr = new ServerAddr();
                serverAddr.mIp = next.mIp;
                serverAddr.port = next.mPort;
                serverAddr.isIpv6 = i16 == 28;
                arrayList.add(serverAddr);
            }
        }
        return arrayList;
    }
}
