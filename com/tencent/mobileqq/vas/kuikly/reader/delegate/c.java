package com.tencent.mobileqq.vas.kuikly.reader.delegate;

import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/c;", "", "", "f", "Landroid/graphics/Bitmap;", "candidate", "", "width", "height", "", "b", "Landroid/graphics/Bitmap$Config;", DownloadInfo.spKey_Config, "c", MimeHelper.IMAGE_SUBTYPE_BITMAP, "e", "d", "", "Ljava/util/Set;", "reusableBitmaps", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f309915a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<Bitmap> reusableBitmaps;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f309917a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f309917a = iArr;
        }
    }

    static {
        Set<Bitmap> hashSet;
        if (Build.VERSION.SDK_INT >= 24) {
            hashSet = ConcurrentHashMap.newKeySet();
            Intrinsics.checkNotNullExpressionValue(hashSet, "{\n        ConcurrentHashMap.newKeySet()\n    }");
        } else {
            hashSet = new HashSet<>();
        }
        reusableBitmaps = hashSet;
    }

    c() {
    }

    private final boolean b(Bitmap candidate, int width, int height) {
        if (width * height * c(candidate.getConfig()) <= candidate.getAllocationByteCount()) {
            return true;
        }
        return false;
    }

    private final int c(Bitmap.Config config) {
        int i3;
        if (config == null) {
            i3 = -1;
        } else {
            i3 = a.f309917a[config.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                return 1;
            }
            return 2;
        }
        return 4;
    }

    private final void f() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.reader.delegate.b
            @Override // java.lang.Runnable
            public final void run() {
                c.g();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        Iterator<Bitmap> it = reusableBitmaps.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Bitmap next = it.next();
            if (i3 > 67108864) {
                it.remove();
                next.recycle();
            } else {
                i3 += next.getByteCount();
            }
        }
    }

    @NotNull
    public final Bitmap d(int width, int height) {
        Set<Bitmap> set = reusableBitmaps;
        if (set.isEmpty()) {
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, heig\u2026 Bitmap.Config.ARGB_8888)");
            return createBitmap;
        }
        Iterator<Bitmap> it = set.iterator();
        while (it.hasNext()) {
            Bitmap next = it.next();
            if (next.isMutable()) {
                if (b(next, width, height)) {
                    it.remove();
                    next.reconfigure(width, height, Bitmap.Config.ARGB_8888);
                    return next;
                }
            } else {
                it.remove();
            }
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap2, "createBitmap(width, heig\u2026 Bitmap.Config.ARGB_8888)");
        return createBitmap2;
    }

    public final void e(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        reusableBitmaps.add(bitmap);
        f();
    }
}
