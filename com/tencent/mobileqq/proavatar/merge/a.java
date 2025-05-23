package com.tencent.mobileqq.proavatar.merge;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.proavatar.merge.layout.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\f\b\u0000\u0018\u0000 32\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0013\u00a2\u0006\u0004\b;\u0010\u0018J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u001b\u0010\r\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bR\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010\u001fR\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b'\u0010+\u001a\u0004\b \u0010,\"\u0004\b-\u0010.R4\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002000/0\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u00101\u001a\u0004\b\u001a\u00102\"\u0004\b3\u00104R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b6\u00108\"\u0004\b9\u0010:\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/proavatar/merge/a;", "", "", "size", "p", "gap", "l", "Lcom/tencent/mobileqq/proavatar/merge/layout/b;", "layoutManager", DomainData.DOMAIN_NAME, "", "Landroid/graphics/Bitmap;", "bitmaps", "j", "([Landroid/graphics/Bitmap;)Lcom/tencent/mobileqq/proavatar/merge/a;", "", RedTouchConst.PicDownload.ISCIRCLE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "b", "I", "g", "()I", "setSize", "(I)V", "c", "e", "setGap", "d", "setCount", "count", "Lcom/tencent/mobileqq/proavatar/merge/layout/b;", "f", "()Lcom/tencent/mobileqq/proavatar/merge/layout/b;", "o", "(Lcom/tencent/mobileqq/proavatar/merge/layout/b;)V", "[Landroid/graphics/Bitmap;", "()[Landroid/graphics/Bitmap;", "k", "([Landroid/graphics/Bitmap;)V", "Lkotlin/Pair;", "", "[Lkotlin/Pair;", "()[Lkotlin/Pair;", "i", "([Lkotlin/Pair;)V", "bitmapSize", h.F, "Z", "()Z", "setCircle", "(Z)V", "<init>", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
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
    private int count;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public b layoutManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Bitmap[] bitmaps;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public Pair<Float, Float>[] bitmapSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isCircle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/proavatar/merge/a$a;", "", "Landroid/content/Context;", "context", "", "dipValue", "", "a", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.merge.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18048);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
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
            this.isCircle = true;
        }
    }

    @Nullable
    public final Bitmap a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (Bitmap) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return pd2.a.f425932a.a(this);
    }

    @NotNull
    public final Pair<Float, Float>[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Pair[]) iPatchRedirector.redirect((short) 16, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Bitmap[]) iPatchRedirector.redirect((short) 14, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
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

    @NotNull
    public final b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        b bVar = this.layoutManager;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        return null;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.size;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.isCircle;
    }

    public final void i(@NotNull Pair<Float, Float>[] pairArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) pairArr);
        } else {
            Intrinsics.checkNotNullParameter(pairArr, "<set-?>");
            this.bitmapSize = pairArr;
        }
    }

    @NotNull
    public final a j(@NotNull Bitmap[] bitmaps) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (a) iPatchRedirector.redirect((short) 24, (Object) this, (Object) bitmaps);
        }
        Intrinsics.checkNotNullParameter(bitmaps, "bitmaps");
        k(bitmaps);
        this.count = bitmaps.length;
        return this;
    }

    public final void k(@NotNull Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bitmapArr);
        } else {
            Intrinsics.checkNotNullParameter(bitmapArr, "<set-?>");
            this.bitmaps = bitmapArr;
        }
    }

    @NotNull
    public final a l(int gap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (a) iPatchRedirector.redirect((short) 21, (Object) this, gap);
        }
        this.gap = INSTANCE.a(this.context, gap);
        return this;
    }

    @NotNull
    public final a m(boolean isCircle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (a) iPatchRedirector.redirect((short) 25, (Object) this, isCircle);
        }
        this.isCircle = isCircle;
        return this;
    }

    @NotNull
    public final a n(@NotNull b layoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (a) iPatchRedirector.redirect((short) 22, (Object) this, (Object) layoutManager);
        }
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        o(layoutManager);
        return this;
    }

    public final void o(@NotNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.layoutManager = bVar;
        }
    }

    @NotNull
    public final a p(int size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (a) iPatchRedirector.redirect((short) 20, (Object) this, size);
        }
        this.size = size;
        return this;
    }
}
