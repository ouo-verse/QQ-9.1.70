package com.tencent.luggage.wxa.b6;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mars.mmdns.MMDnsLogic;
import com.tencent.xweb.ISharedPreferenceProvider;
import com.tencent.xweb.WebViewReporterInterface;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.util.WebViewExtensionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static IXWebLogClient f121879a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static WebViewReporterInterface f121880b = new C6033b();

    /* renamed from: c, reason: collision with root package name */
    public static ISharedPreferenceProvider f121881c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static WebViewExtensionListener f121882d = new d();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements IXWebLogClient {
        @Override // com.tencent.xweb.util.IXWebLogClient
        public void d(String str, String str2) {
            w.a(str, str2);
        }

        @Override // com.tencent.xweb.util.IXWebLogClient
        public void e(String str, String str2) {
            w.b(str, str2);
        }

        @Override // com.tencent.xweb.util.IXWebLogClient
        public void i(String str, String str2) {
            w.d(str, str2);
        }

        @Override // com.tencent.xweb.util.IXWebLogClient
        public void v(String str, String str2) {
            w.e(str, str2);
        }

        @Override // com.tencent.xweb.util.IXWebLogClient
        public void w(String str, String str2) {
            w.f(str, str2);
        }

        @Override // com.tencent.xweb.util.IXWebLogClient
        public void e(String str, String str2, Throwable th5) {
            w.b(str, str2, th5);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b6.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6033b extends WebViewReporterInterface {

        /* renamed from: a, reason: collision with root package name */
        public final String f121883a = "XWeb.Wxa.Report";

        @Override // com.tencent.xweb.WebViewReporterInterface
        public void idkeyForPair(int i3, int i16, int i17, int i18, int i19, int i26) {
            w.e("XWeb.Wxa.Report", "callback: idkeyForPair:" + i3 + ", " + i17 + ", " + i19 + ", " + i16 + ", " + i18 + ", " + i26);
        }

        @Override // com.tencent.xweb.WebViewReporterInterface
        public void idkeyStat(long j3, long j16, long j17) {
            w.e("XWeb.Wxa.Report", "callback: idkeyStat:" + j3 + ", " + j16 + ", " + j17);
        }

        @Override // com.tencent.xweb.WebViewReporterInterface
        public void kvStat(int i3, String str) {
            w.e("XWeb.Wxa.Report", "callback: kvStat:" + i3 + ", " + str);
            if (i3 == 10124 || i3 == 10125 || i3 == 10126 || i3 == 10127 || i3 == 10128 || i3 == 10129) {
                w.d("XWeb.Wxa.Report", "xweb kv report, id:" + i3 + ", value:" + str);
                com.tencent.luggage.wxa.zj.f fVar = com.tencent.luggage.wxa.zj.f.f146728a;
                boolean z16 = com.tencent.luggage.wxa.tn.e.f141559a;
                fVar.a(i3, str, true, z16, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements ISharedPreferenceProvider {
        @Override // com.tencent.xweb.ISharedPreferenceProvider
        public SharedPreferences getSharedPreference(Context context, String str, int i3, boolean z16) {
            int i16;
            if (i3 == 4) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            f0 c16 = f0.c(str, i16);
            if (c16 == null) {
                return null;
            }
            return new com.tencent.luggage.wxa.b6.d(c16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends WebViewExtensionListener {
        @Override // com.tencent.xweb.util.WebViewExtensionListener
        public Object onMiscCallBack(String str, Object... objArr) {
            if (ConstValue.EXTENSION_ADD_FILTER_RESOURCES.equals(str)) {
                w.d("XWeb.MM.WebViewExtensionListener", "onMiscCallBack, AddFilterResources");
                com.tencent.luggage.wxa.ho.a.a((Resources) objArr[0], (Map) objArr[1]);
                return Boolean.TRUE;
            }
            if (ConstValue.EXTENSION_AUTO_CHECK_UPDATE.equals(str)) {
                w.f("XWeb.MM.WebViewExtensionListener", "unsupported EXTENSION_AUTO_CHECK_UPDATE");
                return Boolean.FALSE;
            }
            if (ConstValue.EXTENSION_GET_HOST_NAME_FROM_NEW.equals(str)) {
                String str2 = (String) objArr[0];
                List list = (List) objArr[1];
                w.d("XWeb.MM.WebViewExtensionListener", "onMiscCallBack, getHostByNameFromNew, hostName:" + str2);
                Bundle bundle = (Bundle) com.tencent.luggage.wxa.qa.f.a(z.g(), new com.tencent.luggage.wxa.va.d(str2), f.class);
                if (list == null || bundle == null) {
                    return 0;
                }
                list.clear();
                ArrayList<String> stringArrayList = bundle.getStringArrayList("ipList");
                int i3 = bundle.getInt("result");
                list.addAll(stringArrayList);
                return Integer.valueOf(i3);
            }
            if (ConstValue.EXTENSION_GET_HOST_NAME_FROM_HTTP.equals(str)) {
                String str3 = (String) objArr[0];
                List list2 = (List) objArr[1];
                w.d("XWeb.MM.WebViewExtensionListener", "onMiscCallBack, getHostByNameFromHttp, hostName:" + str3);
                Bundle bundle2 = (Bundle) com.tencent.luggage.wxa.qa.f.a(z.g(), new com.tencent.luggage.wxa.va.d(str3), e.class);
                if (list2 == null || bundle2 == null) {
                    return 0;
                }
                list2.clear();
                ArrayList<String> stringArrayList2 = bundle2.getStringArrayList("ipList");
                int i16 = bundle2.getInt("result");
                list2.addAll(stringArrayList2);
                return Integer.valueOf(i16);
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements r {
        e() {
        }

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bundle invoke(com.tencent.luggage.wxa.va.d dVar) {
            int i3;
            Bundle bundle = new Bundle();
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (!w0.c(dVar.f143315a)) {
                    com.tencent.msdk.dns.core.c e16 = com.tencent.msdk.dns.c.h().e(dVar.f143315a);
                    String[] strArr = e16.f336250c;
                    if (strArr != null) {
                        int length = strArr.length;
                        int i16 = 0;
                        i3 = 0;
                        while (i16 < length) {
                            arrayList.add(strArr[i16]);
                            i16++;
                            i3 = 4;
                        }
                    } else {
                        i3 = 0;
                    }
                    String[] strArr2 = e16.f336248a;
                    if (strArr2 != null) {
                        int length2 = strArr2.length;
                        int i17 = 0;
                        while (i17 < length2) {
                            arrayList.add(strArr2[i17]);
                            i17++;
                            i3 = 4;
                        }
                    }
                    String[] strArr3 = e16.f336249b;
                    if (strArr3 != null) {
                        int length3 = strArr3.length;
                        int i18 = 0;
                        while (i18 < length3) {
                            arrayList.add(strArr3[i18]);
                            i18++;
                            i3 = 4;
                        }
                    }
                } else {
                    i3 = 0;
                }
                bundle.putStringArrayList("ipList", arrayList);
                bundle.putInt("result", i3);
                w.d("XWeb.MM.GetHostByNameFromHttpTask", "GetHostByNameFromHttpTask, result:" + i3 + ", ipList:" + arrayList);
                return bundle;
            } catch (Exception e17) {
                w.a("XWeb.MM.GetHostByNameFromHttpTask", e17, "GetHostByNameFromHttpTask error", new Object[0]);
                return bundle;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements r {
        f() {
        }

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bundle invoke(com.tencent.luggage.wxa.va.d dVar) {
            Bundle bundle = new Bundle();
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (!w0.c(dVar.f143315a)) {
                    arrayList.addAll(MMDnsLogic.getHost(dVar.f143315a));
                }
                bundle.putStringArrayList("ipList", arrayList);
                w.d("XWeb.MM.GetHostByNameFromNewTask", "GetHostByNameFromNewTask: ipList:" + arrayList);
                return bundle;
            } catch (Exception | UnsatisfiedLinkError e16) {
                w.a("XWeb.MM.GetHostByNameFromNewTask", e16, "GetHostByNameFromNewTask error", new Object[0]);
                return bundle;
            }
        }
    }
}
