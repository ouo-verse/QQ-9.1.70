package nd4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tab.tabmonitor.export.config.TabAggregateType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nd4.g;
import nd4.j;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes26.dex */
final class u {

    /* renamed from: a, reason: collision with root package name */
    private static String f420029a;

    /* renamed from: b, reason: collision with root package name */
    private static String f420030b;

    /* renamed from: c, reason: collision with root package name */
    private static final Set<String> f420031c = new HashSet();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f420032a;

        static {
            int[] iArr = new int[TabAggregateType.values().length];
            f420032a = iArr;
            try {
                iArr[TabAggregateType.SUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f420032a[TabAggregateType.AVG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f420032a[TabAggregateType.MAX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f420032a[TabAggregateType.MIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        Set<String> set = f420031c;
        if (set.contains(str)) {
            return true;
        }
        if (((Integer) Class.forName("android.support.v4.content.ContextCompat").getMethod("checkSelfPermission", Context.class, String.class).invoke(null, l.a(), str)).intValue() != 0) {
            Log.d("TAB.TabMetricsUtils", "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"" + str + "\" />");
            return false;
        }
        set.add(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(List<String> list, Map<String, String> map) {
        int size = list.size();
        if (size != map.size()) {
            return false;
        }
        if (size == 0) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static String c() {
        String str = f420030b;
        if (str != null) {
            return str;
        }
        String packageName = l.a().getPackageName();
        f420030b = packageName;
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        return f420030b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        String str = f420029a;
        if (str != null) {
            return str;
        }
        String c16 = c();
        f420030b = c16;
        if (TextUtils.isEmpty(c16)) {
            return null;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(l.a().getPackageManager(), f420030b, 0);
            String str2 = packageInfo.versionName;
            f420029a = str2;
            int i3 = packageInfo.versionCode;
            if (TextUtils.isEmpty(str2)) {
                f420029a = String.valueOf(i3);
            }
            String replace = f420029a.trim().replace('\n', TokenParser.SP).replace('\r', TokenParser.SP).replace("|", "%7C");
            f420029a = replace;
            return replace;
        } catch (Exception e16) {
            Log.e("TAB.TabMetricsUtils", "getAppVersion---" + e16);
            return f420029a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g e(g gVar, g gVar2) {
        if (!h(gVar, gVar2)) {
            return gVar;
        }
        List<j> d16 = gVar.d();
        List<j> d17 = gVar2.d();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < d16.size(); i3++) {
            j jVar = d16.get(i3);
            j jVar2 = d17.get(i3);
            if (!TextUtils.equals(jVar.c(), jVar2.c())) {
                return gVar;
            }
            if (jVar.a() != jVar2.a()) {
                return gVar;
            }
            float d18 = jVar.d();
            float d19 = jVar2.d();
            int i16 = a.f420032a[jVar.a().ordinal()];
            if (i16 != 1 && i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 4) {
                        d18 = Math.min(d18, d19);
                    }
                } else {
                    d18 = Math.max(d18, d19);
                }
            } else {
                d18 += d19;
            }
            arrayList.add(new j.a().j(jVar, d18, jVar.b() + jVar2.b()));
        }
        return new g.b().i(gVar, arrayList, gVar2.f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    private static boolean h(g gVar, g gVar2) {
        if (gVar == null || gVar2 == null || !TextUtils.equals(gVar.e(), gVar2.e())) {
            return false;
        }
        if (gVar.d().size() != gVar2.d().size()) {
            return false;
        }
        return true;
    }
}
