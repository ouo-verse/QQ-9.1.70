package com.tencent.qqnt.avatar.business.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.avatar.business.bitmap.layout.b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u00a2\u0006\u0004\b@\u0010\u001bJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u001d\u0010\u0012\u001a\u00020\u00002\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0015\u001a\u00020\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b&\u0010 \"\u0004\b)\u0010\"R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b'\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R*\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b1\u00105\u001a\u0004\b#\u00106\"\u0004\b7\u00108R4\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020:090\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010;\u001a\u0004\b\u001d\u0010<\"\u0004\b=\u0010>\u00a8\u0006A"}, d2 = {"Lcom/tencent/qqnt/avatar/business/bitmap/a;", "", "", "size", "r", "gap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "gapColor", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/avatar/business/bitmap/layout/b;", "layoutManager", "o", "Lsv3/a;", "progressListener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Landroid/graphics/Bitmap;", "bitmaps", "k", "([Landroid/graphics/Bitmap;)Lcom/tencent/qqnt/avatar/business/bitmap/a;", "", "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "b", "I", "i", "()I", "setSize", "(I)V", "c", "e", "setGap", "d", "f", "setGapColor", "setCount", "count", "Lcom/tencent/qqnt/avatar/business/bitmap/layout/b;", "g", "()Lcom/tencent/qqnt/avatar/business/bitmap/layout/b;", "p", "(Lcom/tencent/qqnt/avatar/business/bitmap/layout/b;)V", "Lsv3/a;", h.F, "()Lsv3/a;", "setProgressListener", "(Lsv3/a;)V", "[Landroid/graphics/Bitmap;", "()[Landroid/graphics/Bitmap;", "l", "([Landroid/graphics/Bitmap;)V", "Lkotlin/Pair;", "", "[Lkotlin/Pair;", "()[Lkotlin/Pair;", "j", "([Lkotlin/Pair;)V", "bitmapSize", "<init>", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int size;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int gap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int gapColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int count;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public b layoutManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private sv3.a progressListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public Bitmap[] bitmaps;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public Pair<Float, Float>[] bitmapSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/avatar/business/bitmap/a$a;", "", "Landroid/content/Context;", "context", "", "dipValue", "", "a", "<init>", "()V", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.business.bitmap.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a(@NotNull Context context, float dipValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, context, Float.valueOf(dipValue))).intValue();
            }
            Intrinsics.checkNotNullParameter(context, "context");
            return (int) ((dipValue * context.getResources().getDisplayMetrics().density) + 0.5f);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38834);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.context = context;
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            rv3.a.f432564a.a(this);
        }
    }

    @NotNull
    public final Pair<Float, Float>[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Pair[]) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        Pair<Float, Float>[] pairArr = this.bitmapSize;
        if (pairArr != null) {
            return pairArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bitmapSize");
        return null;
    }

    @NotNull
    public final Bitmap[] c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Bitmap[]) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        Bitmap[] bitmapArr = this.bitmaps;
        if (bitmapArr != null) {
            return bitmapArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bitmaps");
        return null;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.count;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.gap;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.gapColor;
    }

    @NotNull
    public final b g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (b) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        b bVar = this.layoutManager;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        return null;
    }

    @Nullable
    public final sv3.a h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (sv3.a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.progressListener;
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.size;
    }

    public final void j(@NotNull Pair<Float, Float>[] pairArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) pairArr);
        } else {
            Intrinsics.checkNotNullParameter(pairArr, "<set-?>");
            this.bitmapSize = pairArr;
        }
    }

    @NotNull
    public final a k(@NotNull Bitmap[] bitmaps) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (a) iPatchRedirector.redirect((short) 25, (Object) this, (Object) bitmaps);
        }
        Intrinsics.checkNotNullParameter(bitmaps, "bitmaps");
        l(bitmaps);
        this.count = bitmaps.length;
        return this;
    }

    public final void l(@NotNull Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bitmapArr);
        } else {
            Intrinsics.checkNotNullParameter(bitmapArr, "<set-?>");
            this.bitmaps = bitmapArr;
        }
    }

    @NotNull
    public final a m(int gap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (a) iPatchRedirector.redirect((short) 21, (Object) this, gap);
        }
        this.gap = INSTANCE.a(this.context, gap);
        return this;
    }

    @NotNull
    public final a n(@ColorInt int gapColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (a) iPatchRedirector.redirect((short) 22, (Object) this, gapColor);
        }
        this.gapColor = gapColor;
        return this;
    }

    @NotNull
    public final a o(@NotNull b layoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (a) iPatchRedirector.redirect((short) 23, (Object) this, (Object) layoutManager);
        }
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        p(layoutManager);
        return this;
    }

    public final void p(@NotNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.layoutManager = bVar;
        }
    }

    @NotNull
    public final a q(@Nullable sv3.a progressListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (a) iPatchRedirector.redirect((short) 24, (Object) this, (Object) progressListener);
        }
        this.progressListener = progressListener;
        return this;
    }

    @NotNull
    public final a r(int size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (a) iPatchRedirector.redirect((short) 20, (Object) this, size);
        }
        this.size = INSTANCE.a(this.context, size);
        return this;
    }
}
