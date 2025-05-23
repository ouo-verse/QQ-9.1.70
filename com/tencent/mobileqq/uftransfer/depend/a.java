package com.tencent.mobileqq.uftransfer.depend;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.api.IFileUtil;
import com.tencent.mobileqq.filemanager.api.IQFileUtils;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.mobileqq.uftransfer.api.j;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.b;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.IProxyIpService;
import qb1.h;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.uftransfer.depend.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C8866a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f305123a;

        /* renamed from: b, reason: collision with root package name */
        public final int f305124b;

        /* renamed from: c, reason: collision with root package name */
        public final int f305125c;

        public C8866a(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.f305123a = i3;
            this.f305124b = i16;
            this.f305125c = i17;
        }
    }

    public static boolean A() {
        return NetworkUtil.isNetSupport(BaseApplication.getContext());
    }

    public static void B(Runnable runnable, int i3, boolean z16) {
        ThreadManagerV2.post(runnable, i3, null, z16);
    }

    public static String C(byte[] bArr) {
        return MD5.toMD5(bArr);
    }

    public static void D(AppRuntime appRuntime) {
        HwServlet.getConfig(appRuntime, appRuntime.getCurrentUin());
    }

    public static String a(byte[] bArr) {
        return HexUtil.bytes2HexStr(bArr);
    }

    public static void b(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, str2, z16, j3, j16, hashMap, str3);
    }

    public static void c(byte[] bArr, int i3, byte[] bArr2, int i16) {
        PkgTools.copyData(bArr, i3, bArr2, i16);
    }

    public static void d(byte[] bArr, int i3, long j3) {
        PkgTools.dWord2Byte(bArr, i3, j3);
    }

    public static byte[] e(String str) {
        byte[] bArr;
        synchronized (SessionInfo.class) {
            SessionInfo sessionInfo = SessionInfo.getInstance(str);
            if (sessionInfo.getHttpconn_sig_session() != null) {
                int length = sessionInfo.getHttpconn_sig_session().length;
                bArr = new byte[length];
                System.arraycopy(sessionInfo.getHttpconn_sig_session(), 0, bArr, 0, length);
            } else {
                bArr = null;
            }
        }
        return bArr;
    }

    public static int f(AppRuntime appRuntime, boolean z16, int i3, List<j> list) {
        ArrayList<h> arrayList = new ArrayList();
        if (appRuntime == null) {
            c.b("[UFTTransfer] UFTDependFeatureApi", 1, "getBigDataHostList. app = null");
            return -1;
        }
        IQQFileEngine iQQFileEngine = (IQQFileEngine) appRuntime.getRuntimeService(IQQFileEngine.class, "");
        if (iQQFileEngine == null) {
            c.b("[UFTTransfer] UFTDependFeatureApi", 1, "getBigDataHostList. fileEngine = null");
            return -1;
        }
        int bigDataHostList = iQQFileEngine.getBigDataHostList(z16, i3, arrayList);
        if (arrayList.size() > 0) {
            for (h hVar : arrayList) {
                list.add(new j(hVar.f428779a, hVar.f428780b));
            }
        }
        return bigDataHostList;
    }

    public static String g(String str) {
        return ((IFileUtil) QRoute.api(IFileUtil.class)).getExtension(str);
    }

    public static C8866a h(String str) {
        int[] fileMediaInfo = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFileMediaInfo(str);
        if (fileMediaInfo != null && fileMediaInfo.length == 3) {
            return new C8866a(fileMediaInfo[0], fileMediaInfo[1], fileMediaInfo[2]);
        }
        return null;
    }

    public static String i(String str) {
        return FileUtils.getFileName(str);
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0084: MOVE (r4 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:133), block:B:31:0x0084 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] j(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file = new File(str);
        FileInputStream fileInputStream3 = null;
        if (!file.exists()) {
            return null;
        }
        long length = file.length();
        try {
            try {
                fileInputStream = new FileInputStream(str);
                if (length >= 10002432) {
                    length = 10002432;
                }
            } catch (IOException e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream3 != null) {
                }
                throw th;
            }
            try {
                byte[] partfileMd5 = MD5.getPartfileMd5(str, length);
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    c.b("[UFTTransfer] UFTDependFeatureApi", 1, "getFilePre10MMd5 close exception:" + e17.toString());
                }
                return partfileMd5;
            } catch (IOException e18) {
                e = e18;
                c.b("[UFTTransfer] UFTDependFeatureApi", 1, "getFilePre10MMd5 exception:" + e.toString());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e19) {
                        c.b("[UFTTransfer] UFTDependFeatureApi", 1, "getFilePre10MMd5 close exception:" + e19.toString());
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (IOException e26) {
                    c.b("[UFTTransfer] UFTDependFeatureApi", 1, "getFilePre10MMd5 close exception:" + e26.toString());
                }
            }
            throw th;
        }
    }

    public static byte[] k(String str) {
        return ah.D0(str);
    }

    public static String l(String str) {
        return ((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).getFileSuffix(str);
    }

    public static List<b.a> m(AppRuntime appRuntime) {
        ArrayList arrayList = null;
        if (appRuntime == null) {
            c.b("[UFTTransfer] UFTDependFeatureApi", 1, "getHttpFileProxy. app = null");
            return null;
        }
        IProxyIpService iProxyIpService = (IProxyIpService) appRuntime.getRuntimeService(IProxyIpService.class, "all");
        if (iProxyIpService == null) {
            c.b("[UFTTransfer] UFTDependFeatureApi", 1, "getHttpFileProxy. IProxyIpService = null");
            return null;
        }
        List<IProxyIpService.ProxyIp> proxyIp = iProxyIpService.getProxyIp(5);
        if (proxyIp != null) {
            arrayList = new ArrayList();
            for (int i3 = 0; i3 < proxyIp.size(); i3++) {
                IProxyIpService.ProxyIp proxyIp2 = proxyIp.get(i3);
                b.a aVar = new b.a();
                aVar.f305118a = proxyIp2.f417211ip;
                aVar.f305119b = proxyIp2.port;
                aVar.f305120c = proxyIp2.type;
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static int n() {
        return ((IQFileUtils) QRoute.api(IQFileUtils.class)).getIPStackType();
    }

    public static int o(AppRuntime appRuntime, String str, int i3, int i16, List<String> list) {
        if (appRuntime == null) {
            c.b("[UFTTransfer] UFTDependFeatureApi", 1, "getIPv6HostsFromDns. app = null");
            return -1;
        }
        IQQFileEngine iQQFileEngine = (IQQFileEngine) appRuntime.getRuntimeService(IQQFileEngine.class, "");
        if (iQQFileEngine == null) {
            c.b("[UFTTransfer] UFTDependFeatureApi", 1, "getIPv6HostsFromDns. fileEngine = null");
            return -1;
        }
        return iQQFileEngine.getIPv6HostsFromDns(str, i3, i16, list);
    }

    public static int p(String str) {
        return ((IQFileUtils) QRoute.api(IQFileUtils.class)).getIpAddrType(str);
    }

    public static int q(String str) {
        return ((IQFileUtils) QRoute.api(IQFileUtils.class)).getIpAddrTypeOfUrl(str);
    }

    public static int r() {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getMsfConnectedNetType();
    }

    public static String s() {
        int mobileInfo;
        if (!AppNetConnInfo.isNetSupport()) {
            return "none";
        }
        if (AppNetConnInfo.isWifiConn()) {
            return "wifi";
        }
        if (!AppNetConnInfo.isMobileConn() || (mobileInfo = AppNetConnInfo.getMobileInfo()) == -1) {
            return "none";
        }
        if (mobileInfo != 0 && mobileInfo != 1) {
            if (mobileInfo != 2) {
                if (mobileInfo != 3) {
                    return "unkonw";
                }
                return QADNetStatus.G_4;
            }
            return QADNetStatus.G_3;
        }
        return QADNetStatus.G_2;
    }

    public static int t() {
        return NetworkUtil.getNetworkType(BaseApplication.getContext());
    }

    public static int u() {
        return ((IQFileUtils) QRoute.api(IQFileUtils.class)).getReportIPStackType();
    }

    public static int v() {
        return ((IQFileUtils) QRoute.api(IQFileUtils.class)).getReportLoginIPStackType();
    }

    public static String w() {
        return AppSetting.l();
    }

    public static String x() {
        return AppSetting.n();
    }

    public static byte[] y(String str) {
        return HexUtil.hexStr2Bytes(str);
    }

    public static String z(byte[] bArr) {
        return ah.Q0(bArr);
    }
}
