package com.tencent.mobileqq.aio.longshot;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\t\u0010\u0017R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0010\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/longshot/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "needMosaic", "Landroidx/collection/LruCache;", "Landroid/graphics/Bitmap;", "b", "Landroidx/collection/LruCache;", "c", "()Landroidx/collection/LruCache;", "msgBitmapCache", "Landroid/graphics/Bitmap;", "f", "()Landroid/graphics/Bitmap;", "titleBitmap", "bottomBlurBitmap", "e", "inputBarBitmap", "shortcutBarBitmap", "g", "waterMarkBitmap", "<init>", "(ZLandroidx/collection/LruCache;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean needMosaic;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<String, Bitmap> msgBitmapCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bitmap titleBitmap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bitmap bottomBlurBitmap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bitmap inputBarBitmap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bitmap shortcutBarBitmap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bitmap waterMarkBitmap;

    public c(boolean z16, @NotNull LruCache<String, Bitmap> msgBitmapCache, @Nullable Bitmap bitmap, @Nullable Bitmap bitmap2, @Nullable Bitmap bitmap3, @Nullable Bitmap bitmap4, @Nullable Bitmap bitmap5) {
        Intrinsics.checkNotNullParameter(msgBitmapCache, "msgBitmapCache");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), msgBitmapCache, bitmap, bitmap2, bitmap3, bitmap4, bitmap5);
            return;
        }
        this.needMosaic = z16;
        this.msgBitmapCache = msgBitmapCache;
        this.titleBitmap = bitmap;
        this.bottomBlurBitmap = bitmap2;
        this.inputBarBitmap = bitmap3;
        this.shortcutBarBitmap = bitmap4;
        this.waterMarkBitmap = bitmap5;
    }

    @Nullable
    public final Bitmap a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.bottomBlurBitmap;
    }

    @Nullable
    public final Bitmap b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.inputBarBitmap;
    }

    @NotNull
    public final LruCache<String, Bitmap> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LruCache) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgBitmapCache;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.needMosaic;
    }

    @Nullable
    public final Bitmap e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.shortcutBarBitmap;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (this.needMosaic == cVar.needMosaic && Intrinsics.areEqual(this.msgBitmapCache, cVar.msgBitmapCache) && Intrinsics.areEqual(this.titleBitmap, cVar.titleBitmap) && Intrinsics.areEqual(this.bottomBlurBitmap, cVar.bottomBlurBitmap) && Intrinsics.areEqual(this.inputBarBitmap, cVar.inputBarBitmap) && Intrinsics.areEqual(this.shortcutBarBitmap, cVar.shortcutBarBitmap) && Intrinsics.areEqual(this.waterMarkBitmap, cVar.waterMarkBitmap)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Bitmap f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.titleBitmap;
    }

    @Nullable
    public final Bitmap g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.waterMarkBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        boolean z16 = this.needMosaic;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode5 = ((r06 * 31) + this.msgBitmapCache.hashCode()) * 31;
        Bitmap bitmap = this.titleBitmap;
        int i3 = 0;
        if (bitmap == null) {
            hashCode = 0;
        } else {
            hashCode = bitmap.hashCode();
        }
        int i16 = (hashCode5 + hashCode) * 31;
        Bitmap bitmap2 = this.bottomBlurBitmap;
        if (bitmap2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = bitmap2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Bitmap bitmap3 = this.inputBarBitmap;
        if (bitmap3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = bitmap3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Bitmap bitmap4 = this.shortcutBarBitmap;
        if (bitmap4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = bitmap4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        Bitmap bitmap5 = this.waterMarkBitmap;
        if (bitmap5 != null) {
            i3 = bitmap5.hashCode();
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "LongShotInfo(needMosaic=" + this.needMosaic + ", msgBitmapCache=" + this.msgBitmapCache + ", titleBitmap=" + this.titleBitmap + ", bottomBlurBitmap=" + this.bottomBlurBitmap + ", inputBarBitmap=" + this.inputBarBitmap + ", shortcutBarBitmap=" + this.shortcutBarBitmap + ", waterMarkBitmap=" + this.waterMarkBitmap + ")";
    }
}
