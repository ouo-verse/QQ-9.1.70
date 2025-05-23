package dov.com.qq.im.video;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes28.dex */
public class GifEncoder {

    /* renamed from: e, reason: collision with root package name */
    private static int f394500e;

    /* renamed from: f, reason: collision with root package name */
    private static int f394501f;

    /* renamed from: g, reason: collision with root package name */
    private static int f394502g;

    /* renamed from: h, reason: collision with root package name */
    private static int f394503h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f394504i;

    /* renamed from: a, reason: collision with root package name */
    private long f394505a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f394506b = Math.max(2, Math.min(f394504i - 1, 4));

    /* renamed from: c, reason: collision with root package name */
    private int f394507c;

    /* renamed from: d, reason: collision with root package name */
    private int f394508d;

    static {
        try {
            ((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).init();
            System.load(new File(FeatureManager.getSoDir(), "libgiftools.so").getPath());
        } catch (Exception e16) {
            QLog.e("GifEncoder", 4, "load libgiftools.so fail, msg = " + e16.getMessage());
        }
        f394500e = 0;
        f394501f = 1;
        f394502g = 2;
        f394503h = 3;
        f394504i = Runtime.getRuntime().availableProcessors();
    }

    private native void nativeClose(long j3);

    private native boolean nativeEncodeFrame(long j3, Bitmap bitmap, int i3);

    private native long nativeInit(int i3, int i16, String str, int i17, int i18);

    private native void nativeSetDither(long j3, boolean z16);

    private native void nativeSetThreadCount(long j3, int i3);

    public void a() {
        nativeClose(this.f394505a);
        this.f394505a = 0L;
    }

    public boolean b(Bitmap bitmap, int i3) {
        if (0 == this.f394505a) {
            return false;
        }
        if (bitmap.getWidth() == this.f394507c && bitmap.getHeight() == this.f394508d) {
            nativeEncodeFrame(this.f394505a, bitmap, i3);
            return true;
        }
        throw new RuntimeException(String.format(Locale.ENGLISH, "The size specified at initialization differs from the size of the image.\n expected:(%d, %d) actual:(%d,%d)", Integer.valueOf(this.f394507c), Integer.valueOf(this.f394508d), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
    }

    public void c(int i3, int i16, String str) throws FileNotFoundException {
        d(i3, i16, str, f394501f);
    }

    public void d(int i3, int i16, String str, int i17) throws FileNotFoundException {
        if (0 != this.f394505a) {
            a();
        }
        this.f394507c = i3;
        this.f394508d = i16;
        QLog.d("GifEncoder", 4, "GifEncoder init, with = ", Integer.valueOf(i3), ", height = ", Integer.valueOf(i16), ", path = ", str, ", encodingType = ", Integer.valueOf(i17), ", threadCount = ", Integer.valueOf(this.f394506b));
        long nativeInit = nativeInit(i3, i16, str, i17, this.f394506b);
        this.f394505a = nativeInit;
        if (0 != nativeInit) {
        } else {
            throw new FileNotFoundException();
        }
    }

    public void e(boolean z16) {
        long j3 = this.f394505a;
        if (0 == j3) {
            return;
        }
        nativeSetDither(j3, z16);
    }
}
