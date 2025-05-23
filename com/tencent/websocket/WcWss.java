package com.tencent.websocket;

import android.util.Pair;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mars.comm.MultiNetLinkWaysUtil;
import com.tencent.mars.smc.IDKey;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WcWss {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static HashMap f384450a;

    /* compiled from: P */
    @Keep
    /* loaded from: classes27.dex */
    public static class BindAndDnsReturn {
        static IPatchRedirector $redirector_;
        public String hostIpStr;
        public int resultCode;

        public BindAndDnsReturn() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface a {
        int a(String str, byte[][] bArr);

        void a(String str, int i3, int i16, String str2);

        void a(String str, int i3, boolean z16, String[] strArr, String[] strArr2, int i16, String str2, String[] strArr3, String[] strArr4);

        void a(String str, int i3, byte[] bArr, boolean z16);

        void a(String str, int i3, String[] strArr, String[] strArr2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62930);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            h.h("wcwss");
            f384450a = new HashMap();
        }
    }

    public static int a() {
        try {
            int d16 = h0.d(z.c());
            if (d16 == -1) {
                return -1;
            }
            if (h0.f(z.c())) {
                return 3;
            }
            if (h0.g(z.c())) {
                return 4;
            }
            if (h0.h(z.c())) {
                return 5;
            }
            if (h0.b(d16)) {
                return 1;
            }
            if (h0.a(d16)) {
                return 2;
            }
            return 6;
        } catch (Exception e16) {
            w.a("MicroMsg.WcWss", e16, "getStatisticsNetType_", new Object[0]);
            return -1;
        }
    }

    public static int b(a aVar, String str, String str2, Object[] objArr, Object[] objArr2, Object[] objArr3, Object obj, Object[] objArr4) {
        int connectSocket = connectSocket(str, str2, objArr, objArr2, objArr3, obj, objArr4);
        if (connectSocket > 0) {
            w.d("MicroMsg.WcWss", "connect wss pair(%s, %d)", str, Integer.valueOf(connectSocket));
            Pair pair = new Pair(str, Integer.valueOf(connectSocket));
            if (f384450a.containsKey(pair)) {
                w.b("MicroMsg.WcWss", "already exists pair(%s, %d)", str, Integer.valueOf(connectSocket));
                return -1;
            }
            f384450a.put(pair, aVar);
        }
        return connectSocket;
    }

    @Keep
    public static BindAndDnsReturn bindSocketToCellularAndDnsByCellular(int i3, String str) {
        MultiNetLinkWaysUtil.BindAndDnsReturnKt bindSocketToCellularAndDnsByCellular = MultiNetLinkWaysUtil.INSTANCE.instance().bindSocketToCellularAndDnsByCellular(i3, str, z.c());
        BindAndDnsReturn bindAndDnsReturn = new BindAndDnsReturn();
        bindAndDnsReturn.hostIpStr = bindSocketToCellularAndDnsByCellular.getHostIpStr();
        bindAndDnsReturn.resultCode = bindSocketToCellularAndDnsByCellular.getResultCode();
        return bindAndDnsReturn;
    }

    public static void c() {
        w.d("MicroMsg.WcWss", "initWcWss");
        init();
    }

    public static native void closeSocket(String str, int i3, int i16, String str2);

    private static native int connectSocket(String str, String str2, Object[] objArr, Object[] objArr2, Object[] objArr3, Object obj, Object[] objArr4);

    @Keep
    public static int doCertificateVerify(String str, int i3, String str2, byte[][] bArr) {
        w.d("MicroMsg.WcWss", "doCertificateVerify group:%s,wssId:%s,hostname:%s", str, Integer.valueOf(i3), str2);
        Pair pair = new Pair(str, Integer.valueOf(i3));
        if (f384450a.containsKey(pair)) {
            return ((a) f384450a.get(pair)).a(str2, bArr);
        }
        w.b("MicroMsg.WcWss", "onMessage callback is null");
        return -1;
    }

    @Keep
    public static int getNetworkType() {
        return a();
    }

    public static native void init();

    @Keep
    public static void onClose(String str, int i3, int i16, String str2) {
        w.d("MicroMsg.WcWss", "onClose group:%s,id:%s, reason:%s, code:%s", str, Integer.valueOf(i3), str2, Integer.valueOf(i16));
        Pair pair = new Pair(str, Integer.valueOf(i3));
        if (f384450a.containsKey(pair)) {
            ((a) f384450a.get(pair)).a(str, i3, i16, str2);
            f384450a.remove(pair);
        } else {
            w.b("MicroMsg.WcWss", "onClose callback is null");
        }
    }

    @Keep
    public static void onHandShake(String str, int i3, String[] strArr, String[] strArr2) {
        w.d("MicroMsg.WcWss", "onHandShake group:%s, wssId:%s", str, Integer.valueOf(i3));
        Pair pair = new Pair(str, Integer.valueOf(i3));
        if (f384450a.containsKey(pair)) {
            ((a) f384450a.get(pair)).a(str, i3, strArr, strArr2);
        } else {
            w.b("MicroMsg.WcWss", "onHandShake callback is null");
        }
    }

    @Keep
    public static void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3) {
        w.e("MicroMsg.WcWss", "onIdKeyStat");
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < iArr.length; i3++) {
            arrayList.add(new IDKey(iArr[i3], iArr2[i3], iArr3[i3]));
        }
    }

    @Keep
    public static void onKvStat(int i3, String str) {
        w.d("MicroMsg.WcWss", "onKvStat logId:%s", Integer.valueOf(i3));
    }

    @Keep
    public static void onMessage(String str, int i3, byte[] bArr, boolean z16) {
        w.a("MicroMsg.WcWss", "onMessage group:%s,wssId:%s,isText:%s", str, Integer.valueOf(i3), Boolean.valueOf(z16));
        Pair pair = new Pair(str, Integer.valueOf(i3));
        if (f384450a.containsKey(pair)) {
            ((a) f384450a.get(pair)).a(str, i3, bArr, z16);
        } else {
            w.b("MicroMsg.WcWss", "onMessage callback is null");
        }
    }

    @Keep
    public static void onOpen(String str, int i3, boolean z16, String[] strArr, String[] strArr2, int i16, String str2, String[] strArr3, String[] strArr4) {
        w.d("MicroMsg.WcWss", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", str, Boolean.valueOf(z16), str2, Integer.valueOf(i16), Integer.valueOf(i3));
        Pair pair = new Pair(str, Integer.valueOf(i3));
        if (f384450a.containsKey(pair)) {
            ((a) f384450a.get(pair)).a(str, i3, z16, strArr, strArr2, i16, str2, strArr3, strArr4);
            if (!z16) {
                f384450a.remove(pair);
                return;
            }
            return;
        }
        w.b("MicroMsg.WcWss", "onOpen callback is null");
    }

    public static native int sendBuffer(String str, int i3, byte[] bArr, boolean z16);
}
