package com.tencent.qqnt.rich;

import android.content.res.ColorStateList;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001\nBW\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u001b\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u001b\u0012\b\b\u0002\u0010)\u001a\u00020\u001b\u0012\b\b\u0002\u0010+\u001a\u00020\u0004\u00a2\u0006\u0004\b,\u0010-J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019R\"\u0010'\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\u0015\u0010\u001f\"\u0004\b&\u0010!R\"\u0010)\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001c\u0010\u001f\"\u0004\b(\u0010!R\"\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0016\u001a\u0004\b\n\u0010\u0017\"\u0004\b*\u0010\u0019\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/rich/p;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/content/res/ColorStateList;", "a", "Landroid/content/res/ColorStateList;", "g", "()Landroid/content/res/ColorStateList;", DomainData.DOMAIN_NAME, "(Landroid/content/res/ColorStateList;)V", "textColor", "b", "e", "l", "linkColor", "c", "I", "()I", "j", "(I)V", "highLightColor", "", "d", UserInfo.SEX_FEMALE, "f", "()F", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(F)V", "size", tl.h.F, "o", "unit", "k", "lineSpacingAdd", "setLineSpacingMult", "lineSpacingMult", "i", NodeProps.BREAK_STRATEGY, "<init>", "(Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;IFIFFI)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class p {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorStateList textColor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorStateList linkColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int highLightColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float size;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int unit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float lineSpacingAdd;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float lineSpacingMult;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int breakStrategy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/rich/p$a;", "", "", "DEFAULT_TEXT_SIZE", UserInfo.SEX_FEMALE, "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.rich.p$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36346);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public p() {
        this(null, null, 0, 0.0f, 0, 0.0f, 0.0f, 0, 255, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            return;
        }
        iPatchRedirector.redirect((short) 31, (Object) this);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.breakStrategy;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.highLightColor;
    }

    public final float c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Float) iPatchRedirector.redirect((short) 13, (Object) this)).floatValue();
        }
        return this.lineSpacingAdd;
    }

    public final float d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Float) iPatchRedirector.redirect((short) 15, (Object) this)).floatValue();
        }
        return this.lineSpacingMult;
    }

    @NotNull
    public final ColorStateList e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.linkColor;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof p)) {
            return false;
        }
        p pVar = (p) other;
        if (Intrinsics.areEqual(this.textColor, pVar.textColor) && Intrinsics.areEqual(this.linkColor, pVar.linkColor) && this.highLightColor == pVar.highLightColor && Float.compare(this.size, pVar.size) == 0 && this.unit == pVar.unit && Float.compare(this.lineSpacingAdd, pVar.lineSpacingAdd) == 0 && Float.compare(this.lineSpacingMult, pVar.lineSpacingMult) == 0 && this.breakStrategy == pVar.breakStrategy) {
            return true;
        }
        return false;
    }

    public final float f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return this.size;
    }

    @NotNull
    public final ColorStateList g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.textColor;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.unit;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return (((((((((((((this.textColor.hashCode() * 31) + this.linkColor.hashCode()) * 31) + this.highLightColor) * 31) + Float.floatToIntBits(this.size)) * 31) + this.unit) * 31) + Float.floatToIntBits(this.lineSpacingAdd)) * 31) + Float.floatToIntBits(this.lineSpacingMult)) * 31) + this.breakStrategy;
    }

    public final void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.breakStrategy = i3;
        }
    }

    public final void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.highLightColor = i3;
        }
    }

    public final void k(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
        } else {
            this.lineSpacingAdd = f16;
        }
    }

    public final void l(@NotNull ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) colorStateList);
        } else {
            Intrinsics.checkNotNullParameter(colorStateList, "<set-?>");
            this.linkColor = colorStateList;
        }
    }

    public final void m(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        } else {
            this.size = f16;
        }
    }

    public final void n(@NotNull ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) colorStateList);
        } else {
            Intrinsics.checkNotNullParameter(colorStateList, "<set-?>");
            this.textColor = colorStateList;
        }
    }

    public final void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.unit = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return "TextInfo(textColor=" + this.textColor + ", linkColor=" + this.linkColor + ", highLightColor=" + this.highLightColor + ", size=" + this.size + ", unit=" + this.unit + ", lineSpacingAdd=" + this.lineSpacingAdd + ", lineSpacingMult=" + this.lineSpacingMult + ", breakStrategy=" + this.breakStrategy + ')';
    }

    public p(@NotNull ColorStateList textColor, @NotNull ColorStateList linkColor, int i3, float f16, int i16, float f17, float f18, int i17) {
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(linkColor, "linkColor");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, textColor, linkColor, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16), Float.valueOf(f17), Float.valueOf(f18), Integer.valueOf(i17));
            return;
        }
        this.textColor = textColor;
        this.linkColor = linkColor;
        this.highLightColor = i3;
        this.size = f16;
        this.unit = i16;
        this.lineSpacingAdd = f17;
        this.lineSpacingMult = f18;
        this.breakStrategy = i17;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ p(ColorStateList colorStateList, ColorStateList colorStateList2, int i3, float f16, int i16, float f17, float f18, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? 17.0f : f16, (i18 & 16) != 0 ? 2 : i16, (i18 & 32) != 0 ? 0.0f : f17, (i18 & 64) != 0 ? 1.0f : f18, (i18 & 128) != 0 ? 1 : i17);
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        if ((i18 & 1) != 0) {
            ColorStateList colorStateList5 = BaseApplication.getContext().getColorStateList(R.color.qui_common_text_primary);
            Intrinsics.checkNotNullExpressionValue(colorStateList5, "getContext().getColorSta\u2026.qui_common_text_primary)");
            colorStateList3 = colorStateList5;
        } else {
            colorStateList3 = colorStateList;
        }
        if ((i18 & 2) != 0) {
            ColorStateList colorStateList6 = BaseApplication.getContext().getColorStateList(R.color.qui_common_text_link);
            Intrinsics.checkNotNullExpressionValue(colorStateList6, "getContext().getColorSta\u2026lor.qui_common_text_link)");
            colorStateList4 = colorStateList6;
        } else {
            colorStateList4 = colorStateList2;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, colorStateList, colorStateList2, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16), Float.valueOf(f17), Float.valueOf(f18), Integer.valueOf(i17), Integer.valueOf(i18), defaultConstructorMarker);
    }
}
