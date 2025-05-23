package er3;

import android.content.Context;
import com.tencent.mobileqq.nativememorymonitor.library.IDexMonitor;
import com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor;
import com.tencent.qmethod.pandoraex.api.r;
import com.tencent.qmethod.pandoraex.core.o;
import cr3.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f397070a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements IDexMonitor {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f397071a;

        a(Context context) {
            this.f397071a = context;
        }

        @Override // com.tencent.mobileqq.nativememorymonitor.library.IDexMonitor
        public String[] onOpenDexFile(String str, String str2, int i3, ClassLoader classLoader, Object[] objArr) {
            String str3;
            if (classLoader != null) {
                str3 = classLoader.getClass().getName();
            } else {
                str3 = "null";
            }
            o.a("OpenDexHook", "onDexFileOpen: " + str + " classLoader: " + str3);
            c c16 = er3.a.c();
            if (c16 != null && !c16.a(str, str2, classLoader)) {
                return null;
            }
            File file = new File(this.f397071a.getDir("dex_transformed", 0), new File(str).getName());
            String c17 = b.c(this.f397071a, str2);
            o.a("OpenDexHook", "output: " + c17);
            o.a("OpenDexHook", "transformedDex.exists:" + file.exists());
            if (b.e(this.f397071a, str) && file.exists()) {
                o.a("OpenDexHook", "dex has transformed. dex_transform:" + file.getAbsolutePath() + " dex newOutput:" + c17);
                if (!cr3.a.a(this.f397071a, str, classLoader)) {
                    int i16 = b.f397070a;
                    if (i16 != 0) {
                        if (i16 == 1) {
                            cr3.a.b(this.f397071a, classLoader);
                        }
                    } else {
                        o.a("OpenDexHook", "not do load Transformed Dex");
                        return null;
                    }
                }
                return new String[]{file.getAbsolutePath(), c17};
            }
            if (r.c(this.f397071a, "key_transform_list").booleanValue()) {
                List f16 = r.f(this.f397071a, "key_transform_list", String.class);
                if (f16 == null) {
                    f16 = new ArrayList();
                }
                if (!f16.contains(str)) {
                    f16.add(str);
                    r.q(this.f397071a, "key_transform_list", f16);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                r.q(this.f397071a, "key_transform_list", arrayList);
            }
            o.a("OpenDexHook", str + " dex add TransformList");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Context context, String str) {
        if (str == null) {
            return null;
        }
        return new File(context.getDir("dex_transformed_opt", 0), new File(str).getName()).getAbsolutePath();
    }

    public static void d(Context context) {
        NativeMemoryMonitor.getInstance().setupOpenDexFileHook(new a(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(Context context, String str) {
        File file = new File(str);
        if (r.c(context, str).booleanValue() && r.d(context, str).booleanValue()) {
            o.a("OpenDexHook", "Dex path:" + file.getAbsolutePath());
            o.a("OpenDexHook", "Dex length:" + file.length() + " lastModified:" + file.lastModified());
            if (file.length() == r.g(context, "length." + str).longValue()) {
                if (file.lastModified() == r.g(context, "lastModified." + str).longValue()) {
                    return true;
                }
            }
            if (!r.c(context, "status." + str).booleanValue()) {
                r.m(context, str, Boolean.FALSE);
            }
        }
        return false;
    }

    public static void f(int i3) {
        f397070a = i3;
    }
}
