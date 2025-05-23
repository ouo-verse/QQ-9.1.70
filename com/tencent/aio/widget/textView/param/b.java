package com.tencent.aio.widget.textView.param;

import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 E2\u00020\u0001:\u0002\n\u0010B\u0099\u0001\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020\u000f\u0012\u0006\u0010(\u001a\u00020\u000f\u0012\u0006\u0010*\u001a\u00020\u000f\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\b\u00102\u001a\u0004\u0018\u00010/\u0012\u0006\u00103\u001a\u00020\u0005\u0012\u0006\u00104\u001a\u00020\u0005\u0012\u0006\u00105\u001a\u00020\u0003\u0012\b\u00107\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010<\u001a\u0004\u0018\u000108\u0012\u0006\u0010?\u001a\u00020\u0005\u0012\u0006\u0010B\u001a\u00020\u0005\u00a2\u0006\u0004\bC\u0010DJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\n\u0010\"R\u0017\u0010&\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u0017\u0010(\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b'\u0010\u0013R\u0017\u0010*\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b)\u0010\u0013R\u0017\u0010.\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b \u0010-R\u0019\u00102\u001a\u0004\u0018\u00010/8\u0006\u00a2\u0006\f\n\u0004\b'\u00100\u001a\u0004\b\u001a\u00101R\u0017\u00103\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b\u0015\u0010\u001dR\u0017\u00104\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b$\u0010\u001dR\u0017\u00105\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b\u0010\u0010-R\u0019\u00107\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b6\u0010\u0016\u001a\u0004\b+\u0010\u0018R\u0019\u0010<\u001a\u0004\u0018\u0001088\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b6\u0010;R\u0017\u0010?\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b=\u0010\u001b\u001a\u0004\b>\u0010\u001dR\u0017\u0010B\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b@\u0010\u001b\u001a\u0004\bA\u0010\u001d\u00a8\u0006F"}, d2 = {"Lcom/tencent/aio/widget/textView/param/b;", "", "other", "", "equals", "", "hashCode", "", "toString", "", "a", "Ljava/lang/CharSequence;", h.F, "()Ljava/lang/CharSequence;", "source", "", "b", UserInfo.SEX_FEMALE, "l", "()F", "textSize", "c", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "textTypeface", "d", "I", "g", "()I", "outerWidth", "Landroid/text/Layout$Alignment;", "e", "Landroid/text/Layout$Alignment;", "()Landroid/text/Layout$Alignment;", "align", "f", "k", "spacingMult", "j", "spacingAdd", "getLetterSpacing", NodeProps.LETTER_SPACING, "i", "Z", "()Z", "includePad", "Landroid/text/TextUtils$TruncateAt;", "Landroid/text/TextUtils$TruncateAt;", "()Landroid/text/TextUtils$TruncateAt;", "ellipsize", "ellipsisWidth", "maxLines", "canContainUrl", DomainData.DOMAIN_NAME, "sourceKey", "Landroid/graphics/Typeface;", "o", "Landroid/graphics/Typeface;", "()Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "p", "getTextColor", "textColor", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getLinkColor", "linkColor", "<init>", "(Ljava/lang/CharSequence;FLjava/lang/String;ILandroid/text/Layout$Alignment;FFFZLandroid/text/TextUtils$TruncateAt;IIZLjava/lang/String;Landroid/graphics/Typeface;II)V", "r", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float textSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String textTypeface;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int outerWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Layout.Alignment align;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float spacingMult;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final float spacingAdd;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float letterSpacing;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean includePad;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TextUtils.TruncateAt ellipsize;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int ellipsisWidth;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int maxLines;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean canContainUrl;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String sourceKey;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Typeface typeface;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final int textColor;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final int linkColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bW\u0010XJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b\f\u0010(R\"\u0010-\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\r\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\"\u00101\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\r\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011R\"\u00104\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\r\u001a\u0004\b3\u0010\u000f\"\u0004\b*\u0010\u0011R\"\u0010:\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u00106\u001a\u0004\b7\u00108\"\u0004\b$\u00109R$\u0010@\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010<\u001a\u0004\b=\u0010>\"\u0004\b\u001c\u0010?R\"\u0010C\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u001d\u001a\u0004\bB\u0010\u001f\"\u0004\b\u0014\u0010!R\"\u0010E\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u001d\u001a\u0004\bD\u0010\u001f\"\u0004\b2\u0010!R\"\u0010H\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u00106\u001a\u0004\bF\u00108\"\u0004\bG\u00109R$\u0010K\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010\u0015\u001a\u0004\bJ\u0010\u0017\"\u0004\bA\u0010\u0019R$\u0010R\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010T\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u001d\u001a\u0004\bS\u0010\u001f\"\u0004\bI\u0010!R\"\u0010V\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010\u001d\u001a\u0004\bU\u0010\u001f\"\u0004\b.\u0010!\u00a8\u0006Y"}, d2 = {"Lcom/tencent/aio/widget/textView/param/b$a;", "", "Lcom/tencent/aio/widget/textView/param/b;", "a", "", "Ljava/lang/CharSequence;", "getSource", "()Ljava/lang/CharSequence;", "j", "(Ljava/lang/CharSequence;)V", "source", "", "b", UserInfo.SEX_FEMALE, "getTextSize", "()F", "o", "(F)V", "textSize", "", "c", "Ljava/lang/String;", "getTextTypeface", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "textTypeface", "", "d", "I", "getOuterWidth", "()I", "i", "(I)V", "outerWidth", "Landroid/text/Layout$Alignment;", "e", "Landroid/text/Layout$Alignment;", "getAlign", "()Landroid/text/Layout$Alignment;", "(Landroid/text/Layout$Alignment;)V", "align", "f", "getSpacingMult", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "spacingMult", "g", "getSpacingAdd", "l", "spacingAdd", h.F, "getLetterSpacing", NodeProps.LETTER_SPACING, "", "Z", "getIncludePad", "()Z", "(Z)V", "includePad", "Landroid/text/TextUtils$TruncateAt;", "Landroid/text/TextUtils$TruncateAt;", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "(Landroid/text/TextUtils$TruncateAt;)V", "ellipsize", "k", "getEllipsisWidth", "ellipsisWidth", "getMaxLines", "maxLines", "getCanContainUrl", "setCanContainUrl", "canContainUrl", DomainData.DOMAIN_NAME, "getSourceKey", "sourceKey", "Landroid/graphics/Typeface;", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroid/graphics/Typeface;)V", TextComponent.SpanStyle.TYPEFACE, "getTextColor", "textColor", "getLinkColor", "linkColor", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public CharSequence source;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float textSize;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String textTypeface;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int outerWidth;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Layout.Alignment align;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float spacingMult;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private float spacingAdd;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private float letterSpacing;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private boolean includePad;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TextUtils.TruncateAt ellipsize;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int ellipsisWidth;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private int maxLines;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private boolean canContainUrl;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String sourceKey;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Typeface typeface;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private int textColor;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        private int linkColor;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
                iPatchRedirector.redirect((short) 36, (Object) this);
                return;
            }
            this.align = Layout.Alignment.ALIGN_NORMAL;
            this.spacingMult = 1.0f;
            this.includePad = true;
            this.ellipsisWidth = this.outerWidth;
            this.maxLines = Integer.MAX_VALUE;
        }

        @NotNull
        public final b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                return (b) iPatchRedirector.redirect((short) 35, (Object) this);
            }
            CharSequence charSequence = this.source;
            if (charSequence == null) {
                Intrinsics.throwUninitializedPropertyAccessException("source");
            }
            return new b(charSequence, this.textSize, this.textTypeface, this.outerWidth, this.align, this.spacingMult, this.spacingAdd, this.letterSpacing, this.includePad, this.ellipsize, this.ellipsisWidth, this.maxLines, this.canContainUrl, this.sourceKey, this.typeface, this.textColor, this.linkColor, null);
        }

        public final void b(@NotNull Layout.Alignment alignment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) alignment);
            } else {
                Intrinsics.checkNotNullParameter(alignment, "<set-?>");
                this.align = alignment;
            }
        }

        public final void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this, i3);
            } else {
                this.ellipsisWidth = i3;
            }
        }

        public final void d(@Nullable TextUtils.TruncateAt truncateAt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, (Object) this, (Object) truncateAt);
            } else {
                this.ellipsize = truncateAt;
            }
        }

        public final void e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, z16);
            } else {
                this.includePad = z16;
            }
        }

        public final void f(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
            } else {
                this.letterSpacing = f16;
            }
        }

        public final void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                iPatchRedirector.redirect((short) 34, (Object) this, i3);
            } else {
                this.linkColor = i3;
            }
        }

        public final void h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, (Object) this, i3);
            } else {
                this.maxLines = i3;
            }
        }

        public final void i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
            } else {
                this.outerWidth = i3;
            }
        }

        public final void j(@NotNull CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
            } else {
                Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
                this.source = charSequence;
            }
        }

        public final void k(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
            } else {
                this.sourceKey = str;
            }
        }

        public final void l(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
            } else {
                this.spacingAdd = f16;
            }
        }

        public final void m(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
            } else {
                this.spacingMult = f16;
            }
        }

        public final void n(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                iPatchRedirector.redirect((short) 32, (Object) this, i3);
            } else {
                this.textColor = i3;
            }
        }

        public final void o(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            } else {
                this.textSize = f16;
            }
        }

        public final void p(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            } else {
                this.textTypeface = str;
            }
        }

        public final void q(@Nullable Typeface typeface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                iPatchRedirector.redirect((short) 30, (Object) this, (Object) typeface);
            } else {
                this.typeface = typeface;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/widget/textView/param/b$b;", "", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.widget.textView.param.b$b, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13180);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    b(CharSequence charSequence, float f16, String str, int i3, Layout.Alignment alignment, float f17, float f18, float f19, boolean z16, TextUtils.TruncateAt truncateAt, int i16, int i17, boolean z17, String str2, Typeface typeface, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, charSequence, Float.valueOf(f16), str, Integer.valueOf(i3), alignment, Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Boolean.valueOf(z16), truncateAt, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z17), str2, typeface, Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        this.source = charSequence;
        this.textSize = f16;
        this.textTypeface = str;
        this.outerWidth = i3;
        this.align = alignment;
        this.spacingMult = f17;
        this.spacingAdd = f18;
        this.letterSpacing = f19;
        this.includePad = z16;
        this.ellipsize = truncateAt;
        this.ellipsisWidth = i16;
        this.maxLines = i17;
        this.canContainUrl = z17;
        this.sourceKey = str2;
        this.typeface = typeface;
        this.textColor = i18;
        this.linkColor = i19;
    }

    @NotNull
    public final Layout.Alignment a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Layout.Alignment) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.align;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.canContainUrl;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.ellipsisWidth;
    }

    @Nullable
    public final TextUtils.TruncateAt d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TextUtils.TruncateAt) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.ellipsize;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.includePad;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(b.class, cls)) {
            return false;
        }
        if (other != null) {
            b bVar = (b) other;
            if (this.textSize == bVar.textSize && !(!Intrinsics.areEqual(this.textTypeface, bVar.textTypeface)) && this.outerWidth == bVar.outerWidth && this.align == bVar.align && this.spacingMult == bVar.spacingMult && this.spacingAdd == bVar.spacingAdd && this.letterSpacing == bVar.letterSpacing && this.includePad == bVar.includePad && this.ellipsize == bVar.ellipsize && this.ellipsisWidth == bVar.ellipsisWidth && this.maxLines == bVar.maxLines && this.canContainUrl == bVar.canContainUrl && !(!Intrinsics.areEqual(this.sourceKey, bVar.sourceKey)) && !(!Intrinsics.areEqual(this.typeface, bVar.typeface)) && this.textColor == bVar.textColor && this.linkColor == bVar.linkColor) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.widget.textView.param.AIOStaticParam");
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.maxLines;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.outerWidth;
    }

    @NotNull
    public final CharSequence h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CharSequence) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.source;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int floatToIntBits = Float.floatToIntBits(this.textSize) * 31;
        String str = this.textTypeface;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int hashCode = (((((((((((((floatToIntBits + i3) * 31) + this.outerWidth) * 31) + this.align.hashCode()) * 31) + Float.floatToIntBits(this.spacingMult)) * 31) + Float.floatToIntBits(this.spacingAdd)) * 31) + Float.floatToIntBits(this.letterSpacing)) * 31) + com.tencent.aio.widget.textView.param.a.a(this.includePad)) * 31;
        TextUtils.TruncateAt truncateAt = this.ellipsize;
        if (truncateAt != null) {
            i16 = truncateAt.hashCode();
        } else {
            i16 = 0;
        }
        int a16 = (((((((hashCode + i16) * 31) + this.ellipsisWidth) * 31) + this.maxLines) * 31) + com.tencent.aio.widget.textView.param.a.a(this.canContainUrl)) * 31;
        String str2 = this.sourceKey;
        if (str2 != null) {
            i17 = str2.hashCode();
        } else {
            i17 = 0;
        }
        int i19 = (a16 + i17) * 31;
        Typeface typeface = this.typeface;
        if (typeface != null) {
            i18 = typeface.hashCode();
        }
        return ((((i19 + i18) * 31) + this.textColor) * 31) + this.linkColor;
    }

    @Nullable
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.sourceKey;
    }

    public final float j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this)).floatValue();
        }
        return this.spacingAdd;
    }

    public final float k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.spacingMult;
    }

    public final float l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.textSize;
    }

    @Nullable
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.textTypeface;
    }

    @Nullable
    public final Typeface n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Typeface) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.typeface;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String str = "textSize" + this.textSize + "textTypeface" + this.textTypeface + "outerWidth" + this.outerWidth + "align" + this.align + "spacingMult" + this.spacingMult + "spacingAdd" + this.spacingAdd + NodeProps.LETTER_SPACING + this.letterSpacing + "includePad" + this.includePad + "ellipsize" + this.ellipsize + "ellipsisWidth" + this.ellipsisWidth + "maxLines" + this.maxLines + "canContainUrl" + this.canContainUrl + "sourceKey" + this.sourceKey + TextComponent.SpanStyle.TYPEFACE + this.typeface + "textColor" + this.textColor + "linkColor" + this.linkColor;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        \u2026)\n            .toString()");
        return str;
    }

    public /* synthetic */ b(CharSequence charSequence, float f16, String str, int i3, Layout.Alignment alignment, float f17, float f18, float f19, boolean z16, TextUtils.TruncateAt truncateAt, int i16, int i17, boolean z17, String str2, Typeface typeface, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, f16, str, i3, alignment, f17, f18, f19, z16, truncateAt, i16, i17, z17, str2, typeface, i18, i19);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
            return;
        }
        iPatchRedirector.redirect((short) 24, this, charSequence, Float.valueOf(f16), str, Integer.valueOf(i3), alignment, Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Boolean.valueOf(z16), truncateAt, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z17), str2, typeface, Integer.valueOf(i18), Integer.valueOf(i19), defaultConstructorMarker);
    }
}
