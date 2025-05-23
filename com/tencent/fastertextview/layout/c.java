package com.tencent.fastertextview.layout;

import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\nBk\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\u0006\u0010'\u001a\u00020\u001f\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010,\u0012\u0006\u00100\u001a\u00020\u0005\u0012\u0006\u00101\u001a\u00020\u0005\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u0005\u00a2\u0006\u0004\b5\u00106J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\n\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010'\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#R\u0017\u0010+\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b%\u0010*R\u0019\u0010/\u001a\u0004\u0018\u00010,8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b \u0010.R\u0017\u00100\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u00101\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b(\u0010\u0018R\u0017\u00102\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\"\u0010)\u001a\u0004\b\u0015\u0010*R\u0017\u00104\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b3\u0010\u0016\u001a\u0004\b\u0010\u0010\u0018\u00a8\u00067"}, d2 = {"Lcom/tencent/fastertextview/layout/c;", "", "other", "", "equals", "", "hashCode", "", "toString", "", "a", "Ljava/lang/CharSequence;", "i", "()Ljava/lang/CharSequence;", "source", "Landroid/text/TextPaint;", "b", "Landroid/text/TextPaint;", "getTextPaint", "()Landroid/text/TextPaint;", "textPaint", "c", "I", h.F, "()I", "outerWidth", "Landroid/text/Layout$Alignment;", "d", "Landroid/text/Layout$Alignment;", "()Landroid/text/Layout$Alignment;", "align", "", "e", UserInfo.SEX_FEMALE, "k", "()F", "spacingMult", "f", "j", "spacingAdd", "g", "Z", "()Z", "includePad", "Landroid/text/TextUtils$TruncateAt;", "Landroid/text/TextUtils$TruncateAt;", "()Landroid/text/TextUtils$TruncateAt;", "ellipsize", "ellipsisWidth", "maxLines", "canContainUrl", "l", NodeProps.BREAK_STRATEGY, "<init>", "(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;IIZI)V", "FasterView_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextPaint textPaint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int outerWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Layout.Alignment align;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float spacingMult;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float spacingAdd;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean includePad;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TextUtils.TruncateAt ellipsize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int ellipsisWidth;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int maxLines;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final boolean canContainUrl;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int breakStrategy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001a\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00109\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00105\u001a\u0004\b6\u00107\"\u0004\b-\u00108R\"\u0010<\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0013\u001a\u0004\b;\u0010\u0015\"\u0004\b(\u0010\u0017R\"\u0010>\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b=\u0010\u0015\"\u0004\b:\u0010\u0017R\"\u0010A\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010.\u001a\u0004\b?\u00100\"\u0004\b@\u00102R\"\u0010C\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0013\u001a\u0004\bB\u0010\u0015\"\u0004\b!\u0010\u0017\u00a8\u0006F"}, d2 = {"Lcom/tencent/fastertextview/layout/c$a;", "", "Lcom/tencent/fastertextview/layout/c;", "a", "", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "k", "(Ljava/lang/CharSequence;)V", "source", "Landroid/text/TextPaint;", "Landroid/text/TextPaint;", "c", "()Landroid/text/TextPaint;", DomainData.DOMAIN_NAME, "(Landroid/text/TextPaint;)V", "textPaint", "", "I", "getOuterWidth", "()I", "j", "(I)V", "outerWidth", "Landroid/text/Layout$Alignment;", "d", "Landroid/text/Layout$Alignment;", "getAlign", "()Landroid/text/Layout$Alignment;", "(Landroid/text/Layout$Alignment;)V", "align", "", "e", UserInfo.SEX_FEMALE, "getSpacingMult", "()F", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(F)V", "spacingMult", "f", "getSpacingAdd", "l", "spacingAdd", "", "g", "Z", "getIncludePad", "()Z", h.F, "(Z)V", "includePad", "Landroid/text/TextUtils$TruncateAt;", "Landroid/text/TextUtils$TruncateAt;", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "(Landroid/text/TextUtils$TruncateAt;)V", "ellipsize", "i", "getEllipsisWidth", "ellipsisWidth", "getMaxLines", "maxLines", "getCanContainUrl", "setCanContainUrl", "canContainUrl", "getBreakStrategy", NodeProps.BREAK_STRATEGY, "<init>", "()V", "FasterView_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public CharSequence source;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public TextPaint textPaint;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int outerWidth;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Layout.Alignment align;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float spacingMult;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float spacingAdd;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean includePad;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TextUtils.TruncateAt ellipsize;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int ellipsisWidth;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private int maxLines;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private boolean canContainUrl;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private int breakStrategy;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.align = Layout.Alignment.ALIGN_NORMAL;
            this.spacingMult = 1.0f;
            this.includePad = true;
            this.ellipsisWidth = this.outerWidth;
            this.maxLines = Integer.MAX_VALUE;
        }

        @NotNull
        public final c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (c) iPatchRedirector.redirect((short) 26, (Object) this);
            }
            return new c(b(), c(), this.outerWidth, this.align, this.spacingMult, this.spacingAdd, this.includePad, this.ellipsize, this.ellipsisWidth, this.maxLines, this.canContainUrl, this.breakStrategy, null);
        }

        @NotNull
        public final CharSequence b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            CharSequence charSequence = this.source;
            if (charSequence != null) {
                return charSequence;
            }
            Intrinsics.throwUninitializedPropertyAccessException("source");
            throw null;
        }

        @NotNull
        public final TextPaint c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TextPaint) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            TextPaint textPaint = this.textPaint;
            if (textPaint != null) {
                return textPaint;
            }
            Intrinsics.throwUninitializedPropertyAccessException("textPaint");
            throw null;
        }

        public final void d(@NotNull Layout.Alignment alignment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) alignment);
            } else {
                Intrinsics.checkNotNullParameter(alignment, "<set-?>");
                this.align = alignment;
            }
        }

        public final void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, (Object) this, i3);
            } else {
                this.breakStrategy = i3;
            }
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, i3);
            } else {
                this.ellipsisWidth = i3;
            }
        }

        public final void g(@Nullable TextUtils.TruncateAt truncateAt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) truncateAt);
            } else {
                this.ellipsize = truncateAt;
            }
        }

        public final void h(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, z16);
            } else {
                this.includePad = z16;
            }
        }

        public final void i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this, i3);
            } else {
                this.maxLines = i3;
            }
        }

        public final void j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                this.outerWidth = i3;
            }
        }

        public final void k(@NotNull CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) charSequence);
            } else {
                Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
                this.source = charSequence;
            }
        }

        public final void l(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            } else {
                this.spacingAdd = f16;
            }
        }

        public final void m(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
            } else {
                this.spacingMult = f16;
            }
        }

        public final void n(@NotNull TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) textPaint);
            } else {
                Intrinsics.checkNotNullParameter(textPaint, "<set-?>");
                this.textPaint = textPaint;
            }
        }
    }

    public /* synthetic */ c(CharSequence charSequence, TextPaint textPaint, int i3, Layout.Alignment alignment, float f16, float f17, boolean z16, TextUtils.TruncateAt truncateAt, int i16, int i17, boolean z17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, textPaint, i3, alignment, f16, f17, z16, truncateAt, i16, i17, z17, i18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, this, charSequence, textPaint, Integer.valueOf(i3), alignment, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), truncateAt, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z17), Integer.valueOf(i18), defaultConstructorMarker);
    }

    @NotNull
    public final Layout.Alignment a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Layout.Alignment) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.align;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.breakStrategy;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.canContainUrl;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.ellipsisWidth;
    }

    @Nullable
    public final TextUtils.TruncateAt e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TextUtils.TruncateAt) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.ellipsize;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (other == null) {
            cls = null;
        } else {
            cls = other.getClass();
        }
        if (!Intrinsics.areEqual(c.class, cls)) {
            return false;
        }
        if (other != null) {
            c cVar = (c) other;
            if (this.outerWidth != cVar.outerWidth || this.align != cVar.align) {
                return false;
            }
            if (this.spacingMult == cVar.spacingMult) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            if (this.spacingAdd == cVar.spacingAdd) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && this.includePad == cVar.includePad && this.ellipsize == cVar.ellipsize && this.ellipsisWidth == cVar.ellipsisWidth && this.maxLines == cVar.maxLines && this.canContainUrl == cVar.canContainUrl && Intrinsics.areEqual(this.source, cVar.source) && this.breakStrategy == cVar.breakStrategy && Intrinsics.areEqual(this.textPaint, cVar.textPaint)) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.fastertextview.layout.StaticLayoutParam");
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.includePad;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.maxLines;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.outerWidth;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        int hashCode2 = ((((((((((this.textPaint.hashCode() * 31) + this.outerWidth) * 31) + this.align.hashCode()) * 31) + Float.floatToIntBits(this.spacingMult)) * 31) + Float.floatToIntBits(this.spacingAdd)) * 31) + com.tencent.aio.widget.textView.param.a.a(this.includePad)) * 31;
        TextUtils.TruncateAt truncateAt = this.ellipsize;
        if (truncateAt == null) {
            hashCode = 0;
        } else {
            hashCode = truncateAt.hashCode();
        }
        return ((((((((((hashCode2 + hashCode) * 31) + this.ellipsisWidth) * 31) + this.maxLines) * 31) + com.tencent.aio.widget.textView.param.a.a(this.canContainUrl)) * 31) + this.source.hashCode()) * 31) + this.breakStrategy;
    }

    @NotNull
    public final CharSequence i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.source;
    }

    public final float j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return this.spacingAdd;
    }

    public final float k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.spacingMult;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.source.toString();
    }

    c(CharSequence charSequence, TextPaint textPaint, int i3, Layout.Alignment alignment, float f16, float f17, boolean z16, TextUtils.TruncateAt truncateAt, int i16, int i17, boolean z17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, charSequence, textPaint, Integer.valueOf(i3), alignment, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), truncateAt, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z17), Integer.valueOf(i18));
            return;
        }
        this.source = charSequence;
        this.textPaint = textPaint;
        this.outerWidth = i3;
        this.align = alignment;
        this.spacingMult = f16;
        this.spacingAdd = f17;
        this.includePad = z16;
        this.ellipsize = truncateAt;
        this.ellipsisWidth = i16;
        this.maxLines = i17;
        this.canContainUrl = z17;
        this.breakStrategy = i18;
    }
}
