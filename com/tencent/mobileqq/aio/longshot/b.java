package com.tencent.mobileqq.aio.longshot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.collection.LruCache;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 02\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\"\u001a\u00020\u001e\u0012\u0006\u0010'\u001a\u00020#\u00a2\u0006\u0004\b.\u0010/J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ,\u0010\u0015\u001a\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J$\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0004J-\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u00072\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u001a\"\u00020\nH\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010&R$\u0010-\u001a\u0004\u0018\u00010\f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/aio/longshot/b;", "", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "", "j", "", "msgWidth", "msgHeight", "Landroid/graphics/Bitmap;", "a", "Lcom/tencent/mobileqq/aio/longshot/c;", "longShotInfo", "i", "Landroidx/collection/LruCache;", "", "bitmapCache", "backgroundBitmap", "", "offset", "b", "width", "Landroid/graphics/Bitmap$Config;", DownloadInfo.spKey_Config, "c", "", "bitmapList", h.F, "(I[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "Landroid/content/Context;", "Landroid/content/Context;", "f", "()Landroid/content/Context;", "context", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "e", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/longshot/c;", "g", "()Lcom/tencent/mobileqq/aio/longshot/c;", "setShotInfo", "(Lcom/tencent/mobileqq/aio/longshot/c;)V", "shotInfo", "<init>", "(Landroid/content/Context;Lcom/tencent/aio/api/runtime/a;)V", "d", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c shotInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/longshot/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.longshot.b$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57085);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aioContext);
        } else {
            this.context = context;
            this.aioContext = aioContext;
        }
    }

    public static /* synthetic */ Bitmap d(b bVar, int i3, int i16, Bitmap.Config config, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 4) != 0) {
                config = Bitmap.Config.ARGB_8888;
            }
            return bVar.c(i3, i16, config);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateBitmap");
    }

    @Nullable
    public abstract Bitmap a(int msgWidth, int msgHeight);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Bitmap b(@NotNull LruCache<String, Bitmap> bitmapCache, @NotNull Bitmap backgroundBitmap, float offset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, this, bitmapCache, backgroundBitmap, Float.valueOf(offset));
        }
        Intrinsics.checkNotNullParameter(bitmapCache, "bitmapCache");
        Intrinsics.checkNotNullParameter(backgroundBitmap, "backgroundBitmap");
        Paint paint = new Paint();
        Canvas canvas = new Canvas(backgroundBitmap);
        canvas.setDensity(MobileQQ.sMobileQQ.getResources().getDisplayMetrics().densityDpi);
        int size = bitmapCache.size();
        for (int i3 = 0; i3 < size; i3++) {
            Bitmap bitmap = bitmapCache.get(String.valueOf(i3));
            Intrinsics.checkNotNull(bitmap);
            Bitmap bitmap2 = bitmap;
            canvas.drawBitmap(bitmap2, 0.0f, offset, paint);
            offset += bitmap2.getHeight();
            bitmap2.recycle();
        }
        return backgroundBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Bitmap c(int width, int msgHeight, @NotNull Bitmap.Config config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(width), Integer.valueOf(msgHeight), config);
        }
        Intrinsics.checkNotNullParameter(config, "config");
        try {
            return Bitmap.createBitmap(width, msgHeight, config);
        } catch (OutOfMemoryError e16) {
            QLog.e("BaseLongShotBuilder", 1, "try create background bitmap error: " + e16);
            return null;
        }
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.aioContext;
    }

    @NotNull
    public final Context f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final c g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.shotInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Bitmap h(int width, @NotNull Bitmap... bitmapList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, (Object) this, width, (Object) bitmapList);
        }
        Intrinsics.checkNotNullParameter(bitmapList, "bitmapList");
        int i3 = 0;
        for (Bitmap bitmap : bitmapList) {
            i3 += bitmap.getHeight();
        }
        Bitmap d16 = d(this, width, i3, null, 4, null);
        if (d16 == null) {
            return null;
        }
        Canvas canvas = new Canvas(d16);
        int i16 = 0;
        for (Bitmap bitmap2 : bitmapList) {
            canvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Rect(0, i16, width, bitmap2.getHeight() + i16), (Paint) null);
            i16 += bitmap2.getHeight();
        }
        return d16;
    }

    public final void i(@NotNull c longShotInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) longShotInfo);
        } else {
            Intrinsics.checkNotNullParameter(longShotInfo, "longShotInfo");
            this.shotInfo = longShotInfo;
        }
    }

    public abstract void j(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList);
}
