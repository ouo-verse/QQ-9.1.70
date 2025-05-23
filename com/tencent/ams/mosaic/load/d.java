package com.tencent.ams.mosaic.load;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static String f71509e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, d> f71510f;

    /* renamed from: g, reason: collision with root package name */
    private static final Comparator<String> f71511g;

    /* renamed from: a, reason: collision with root package name */
    public final String f71512a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f71513b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, List<e>> f71514c;

    /* renamed from: d, reason: collision with root package name */
    private List<c> f71515d;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Comparator<String> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            return MosaicUtils.i(str2, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final byte[] f71516a;

        /* renamed from: b, reason: collision with root package name */
        private static volatile Boolean f71517b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59096);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f71516a = new byte[0];
            }
        }

        public static boolean a(Context context) {
            if (f71517b != null) {
                return f71517b.booleanValue();
            }
            synchronized (f71516a) {
                if (f71517b != null) {
                    return f71517b.booleanValue();
                }
                f71517b = Boolean.valueOf(b(context));
                return f71517b.booleanValue();
            }
        }

        @SuppressLint({"ObsoleteSdkInt"})
        private static boolean b(Context context) {
            return Process.is64Bit();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59101);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f71509e = "QuickJSSoConfig";
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f71510f = concurrentHashMap;
        f71511g = new a();
        d a16 = com.tencent.ams.mosaic.load.a.a();
        concurrentHashMap.put(a16.f71512a, a16);
    }

    public d(String str, List<e> list, List<e> list2, List<e> list3, List<e> list4, List<e> list5) {
        this(str, false, list, list2, list3, list4, list5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, list, list2, list3, list4, list5);
    }

    private synchronized List<c> a(Context context) {
        List<e> list;
        String[] b16 = b();
        ArrayList arrayList = new ArrayList();
        if (b16 != null && b16.length != 0) {
            if (!TextUtils.isEmpty(b16[0])) {
                com.tencent.ams.mosaic.utils.f.e(f71509e, "getBestSo abiTypes: " + Arrays.toString(b16));
                int length = b16.length;
                for (int i3 = 0; i3 < length; i3++) {
                    String str = b16[i3];
                    if (!TextUtils.isEmpty(str) && (!str.contains(ResourceAttributes.HostArchValues.ARM64) || b.a(context))) {
                        Map<String, List<e>> map = this.f71514c;
                        if (map != null) {
                            list = map.get(str.toLowerCase());
                        } else {
                            list = null;
                        }
                        if (list != null) {
                            Collections.sort(list);
                            for (int i16 = 0; i16 < list.size(); i16++) {
                                c cVar = new c(list.get(i16), str, i16);
                                com.tencent.ams.mosaic.utils.f.e(f71509e, "getBestSo success: " + cVar);
                                arrayList.add(cVar);
                            }
                            return arrayList;
                        }
                    }
                }
                com.tencent.ams.mosaic.utils.f.h(f71509e, "getBestSo failed: so url not found");
                arrayList.add(new c(3));
                return arrayList;
            }
        }
        com.tencent.ams.mosaic.utils.f.h(f71509e, "getBestSo failed: abi type not get");
        arrayList.add(new c(2));
        return arrayList;
    }

    private String[] b() {
        return Build.SUPPORTED_ABIS;
    }

    public static synchronized d c(Context context) {
        d dVar;
        synchronized (d.class) {
            Iterator<String> it = e().iterator();
            while (true) {
                if (it.hasNext()) {
                    dVar = f71510f.get(it.next());
                    if (f.a(context, dVar)) {
                        break;
                    }
                } else {
                    dVar = null;
                    break;
                }
            }
            com.tencent.ams.mosaic.utils.f.e(f71509e, "getLatestConfig, config: " + dVar);
        }
        return dVar;
    }

    private static List<String> e() {
        ArrayList arrayList = new ArrayList(f71510f.keySet());
        Collections.sort(arrayList, f71511g);
        return arrayList;
    }

    public static List<d> f() {
        return new ArrayList(f71510f.values());
    }

    public static synchronized d g(Context context) {
        d dVar;
        synchronized (d.class) {
            Iterator<String> it = e().iterator();
            dVar = null;
            while (it.hasNext()) {
                d dVar2 = f71510f.get(it.next());
                if (!f.a(context, dVar2)) {
                    com.tencent.ams.mosaic.utils.f.e(f71509e, "not effective config, config: " + dVar2);
                } else {
                    if (dVar == null) {
                        dVar = dVar2;
                    }
                    if (dVar2.f71513b) {
                        com.tencent.ams.mosaic.utils.f.e(f71509e, "select force update config, " + dVar2);
                    } else if (f.b(context, dVar2)) {
                    }
                    dVar = dVar2;
                    break;
                }
            }
            com.tencent.ams.mosaic.utils.f.e(f71509e, "selectQuickJSSoConfig, config: " + dVar);
        }
        return dVar;
    }

    public static synchronized void h(List<d> list) {
        synchronized (d.class) {
            if (list != null) {
                try {
                    for (d dVar : list) {
                        if (dVar != null && !TextUtils.isEmpty(dVar.f71512a)) {
                            f71510f.put(dVar.f71512a, dVar);
                        }
                    }
                } catch (Throwable th5) {
                    com.tencent.ams.mosaic.utils.f.c(f71509e, "setQuickJSSoConfig error.", th5);
                }
            }
        }
    }

    public List<c> d(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        if (this.f71515d == null) {
            try {
                this.f71515d = a(context);
            } catch (Throwable th5) {
                com.tencent.ams.mosaic.utils.f.c(f71509e, "filter quick so item list error.", th5);
            }
        }
        return this.f71515d;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "QuickJSSoConfig{version='" + this.f71512a + "', isForceUpdate='" + this.f71513b + "', abiSoMap='" + this.f71514c + '}';
    }

    public d(String str, boolean z16, List<e> list, List<e> list2, List<e> list3, List<e> list4, List<e> list5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), list, list2, list3, list4, list5);
            return;
        }
        this.f71512a = str;
        this.f71513b = z16;
        HashMap hashMap = new HashMap();
        this.f71514c = hashMap;
        hashMap.put("arm64-v8a", list);
        hashMap.put("armeabi-v7a", list2);
        hashMap.put("armeabi", list3);
        hashMap.put(ResourceAttributes.HostArchValues.X86, list4);
        hashMap.put("x86_64", list5);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f71518a;

        /* renamed from: b, reason: collision with root package name */
        public String f71519b;

        /* renamed from: c, reason: collision with root package name */
        public String f71520c;

        /* renamed from: d, reason: collision with root package name */
        public String f71521d;

        /* renamed from: e, reason: collision with root package name */
        int f71522e;

        /* renamed from: f, reason: collision with root package name */
        public int f71523f;

        /* renamed from: g, reason: collision with root package name */
        volatile int f71524g;

        public c(e eVar, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, eVar, str, Integer.valueOf(i3));
                return;
            }
            if (eVar != null) {
                this.f71518a = eVar.f71525d;
                this.f71519b = eVar.f71526e;
                this.f71520c = eVar.f71527f;
            }
            this.f71521d = str;
            this.f71523f = i3;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "SoItem{url='" + this.f71518a + "', md5='" + this.f71519b + "', abiType='" + this.f71521d + "', index='" + this.f71523f + "', failReason=" + this.f71522e + '}';
        }

        public c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.f71522e = i3;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }
    }

    public d(String str, Map<String, List<e>> map) {
        this(str, false, map);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) map);
    }

    public d(String str, boolean z16, Map<String, List<e>> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16), map);
            return;
        }
        this.f71512a = str;
        this.f71513b = z16;
        this.f71514c = map;
    }
}
