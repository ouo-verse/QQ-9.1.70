package h0;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import t.l;

/* compiled from: P */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f403965a = "0123456789abcdef".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f403966b = new char[64];

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private static volatile Handler f403967c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f403968a;

        static {
            Bitmap.Config config;
            int[] iArr = new int[Bitmap.Config.values().length];
            f403968a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f403968a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f403968a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr2 = f403968a;
                config = Bitmap.Config.RGBA_F16;
                iArr2[config.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f403968a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    k() {
    }

    public static void a() {
        if (q()) {
        } else {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        if (obj instanceof l) {
            return ((l) obj).a(obj2);
        }
        return obj.equals(obj2);
    }

    public static boolean c(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    @NonNull
    private static String d(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i16 = bArr[i3] & 255;
            int i17 = i3 * 2;
            char[] cArr2 = f403965a;
            cArr[i17] = cArr2[i16 >>> 4];
            cArr[i17 + 1] = cArr2[i16 & 15];
        }
        return new String(cArr);
    }

    @NonNull
    public static <T> Queue<T> e(int i3) {
        return new ArrayDeque(i3);
    }

    public static int f(int i3, int i16, @Nullable Bitmap.Config config) {
        return i3 * i16 * h(config);
    }

    @TargetApi(19)
    public static int g(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + HippyTKDListViewAdapter.X + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    private static int h(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i3 = a.f403968a[config.ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2 || i3 == 3) {
            return 2;
        }
        if (i3 != 4) {
            return 4;
        }
        return 8;
    }

    @NonNull
    public static <T> List<T> i(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t16 : collection) {
            if (t16 != null) {
                arrayList.add(t16);
            }
        }
        return arrayList;
    }

    private static Handler j() {
        if (f403967c == null) {
            synchronized (k.class) {
                if (f403967c == null) {
                    f403967c = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f403967c;
    }

    public static int k(float f16) {
        return l(f16, 17);
    }

    public static int l(float f16, int i3) {
        return m(Float.floatToIntBits(f16), i3);
    }

    public static int m(int i3, int i16) {
        return (i16 * 31) + i3;
    }

    public static int n(@Nullable Object obj, int i3) {
        int hashCode;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return m(hashCode, i3);
    }

    public static int o(boolean z16, int i3) {
        return m(z16 ? 1 : 0, i3);
    }

    public static boolean p() {
        return !q();
    }

    public static boolean q() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    private static boolean r(int i3) {
        if (i3 <= 0 && i3 != Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public static boolean s(int i3, int i16) {
        if (r(i3) && r(i16)) {
            return true;
        }
        return false;
    }

    public static void t(Runnable runnable) {
        j().post(runnable);
    }

    public static void u(Runnable runnable) {
        j().removeCallbacks(runnable);
    }

    @NonNull
    public static String v(@NonNull byte[] bArr) {
        String d16;
        char[] cArr = f403966b;
        synchronized (cArr) {
            d16 = d(bArr, cArr);
        }
        return d16;
    }
}
