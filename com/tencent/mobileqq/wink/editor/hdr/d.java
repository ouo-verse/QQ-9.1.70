package com.tencent.mobileqq.wink.editor.hdr;

import android.content.Context;
import androidx.annotation.FloatRange;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 32\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b1\u00102J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\rR\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\"\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0016\u001a\u0004\b\u0015\u0010\"\"\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010,\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010.\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010'R\u0016\u00100\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010'\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/d;", "", "", "progress", "Lkotlin/Pair;", "", "a", "", "needDeLogo", "needDeBlur", "needDeFace", "", "durationUs", "", "c", "", "e", "d", "Landroid/content/Context;", "Landroid/content/Context;", "context", "b", "Ljava/lang/String;", "deLogoPreText", "deLogoText", "deBlurPreText", "deBlurText", "f", "deFacePreText", "g", "deFaceText", tl.h.F, "durationText", "i", "()Ljava/lang/String;", "setStartText", "(Ljava/lang/String;)V", "startText", "j", UserInfo.SEX_FEMALE, "durationPart", "k", "deLogoPart", "l", "deBlurPart", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "deFacePart", DomainData.DOMAIN_NAME, "dealProgress", "<init>", "(Landroid/content/Context;)V", "o", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String deLogoPreText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String deLogoText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String deBlurPreText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String deBlurText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String deFacePreText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String deFaceText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String durationText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String startText;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float durationPart;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private float deLogoPart;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float deBlurPart;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float deFacePart;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private float dealProgress;

    public d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        String string = context.getString(R.string.f239487ml);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026itor_hdr_de_logo_pre_tip)");
        this.deLogoPreText = string;
        String string2 = context.getString(R.string.f239497mm);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026k_editor_hdr_de_logo_tip)");
        this.deLogoText = string2;
        String string3 = context.getString(R.string.f239447mh);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026itor_hdr_de_blur_pre_tip)");
        this.deBlurPreText = string3;
        String string4 = context.getString(R.string.f239457mi);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026k_editor_hdr_de_blur_tip)");
        this.deBlurText = string4;
        String string5 = context.getString(R.string.f239467mj);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri\u2026itor_hdr_de_face_pre_tip)");
        this.deFacePreText = string5;
        String string6 = context.getString(R.string.f239477mk);
        Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri\u2026k_editor_hdr_de_face_tip)");
        this.deFaceText = string6;
        this.durationText = "";
        this.startText = string;
    }

    private final Pair<Integer, String> a(int progress) {
        int coerceIn;
        boolean z16;
        int i3;
        boolean z17;
        boolean z18;
        boolean z19 = false;
        coerceIn = RangesKt___RangesKt.coerceIn(progress, 0, 100);
        float f16 = this.durationPart;
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = ((int) (100 * f16)) + 0;
            if (coerceIn < i3) {
                return TuplesKt.to(Integer.valueOf(coerceIn), this.durationText);
            }
        } else {
            i3 = 0;
        }
        float f17 = this.deLogoPart;
        if (f17 == 0.0f) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            int i16 = (int) (100 * f17);
            i3 += i16;
            if (coerceIn < (i3 - i16) + 8) {
                return TuplesKt.to(Integer.valueOf(coerceIn), this.deLogoPreText);
            }
            if (coerceIn < i3) {
                return TuplesKt.to(Integer.valueOf(coerceIn), this.deLogoText);
            }
        }
        float f18 = this.deBlurPart;
        if (f18 == 0.0f) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            int i17 = (int) (100 * f18);
            i3 += i17;
            if (coerceIn < (i3 - i17) + 8) {
                return TuplesKt.to(Integer.valueOf(coerceIn), this.deBlurPreText);
            }
            if (coerceIn < i3) {
                return TuplesKt.to(Integer.valueOf(coerceIn), this.deBlurText);
            }
        }
        float f19 = this.deFacePart;
        if (f19 == 0.0f) {
            z19 = true;
        }
        if (!z19) {
            int i18 = (int) (100 * f19);
            int i19 = i3 + i18;
            if (coerceIn < (i19 - i18) + 8) {
                return TuplesKt.to(Integer.valueOf(coerceIn), this.deFacePreText);
            }
            if (coerceIn < i19) {
                return TuplesKt.to(Integer.valueOf(coerceIn), this.deFaceText);
            }
        }
        return TuplesKt.to(Integer.valueOf(coerceIn), this.deFaceText);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getStartText() {
        return this.startText;
    }

    public final void c(boolean needDeLogo, boolean needDeBlur, boolean needDeFace, long durationUs) {
        float f16;
        String str;
        String string;
        w53.b.a("ProgressUpdater", "needDeLogo = " + needDeLogo + ", needDeBlur = " + needDeBlur + ", needDeFace = " + needDeFace);
        d();
        int i3 = (int) (((float) (durationUs / ((long) 1000000))) * 0.7f);
        boolean z16 = false;
        if (i3 > 30) {
            if (i3 > 60) {
                string = this.context.getString(R.string.f239517mo, Integer.valueOf(i3 / 60));
                Intrinsics.checkNotNullExpressionValue(string, "{\n                contex\u2026tTime / 60)\n            }");
            } else {
                string = this.context.getString(R.string.f239527mp, Integer.valueOf(i3));
                Intrinsics.checkNotNullExpressionValue(string, "{\n                contex\u2026, costTime)\n            }");
            }
            this.durationText = string;
            z16 = true;
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        if (needDeBlur) {
            f16 += 1.0f;
        }
        if (needDeFace) {
            f16 += 1.0f;
        }
        if (needDeLogo) {
            f16 += 1.0f;
        }
        if (f16 <= 0.0f) {
            return;
        }
        float f17 = 1 / f16;
        if (z16) {
            this.durationPart = f17;
        }
        if (needDeLogo) {
            this.deLogoPart = f17;
        }
        if (needDeBlur) {
            this.deBlurPart = f17;
        }
        if (needDeFace) {
            this.deFacePart = f17;
        }
        float f18 = this.durationPart;
        if (f18 > 0.0f) {
            str = this.durationText;
        } else if (this.deLogoPart > 0.0f) {
            str = this.deLogoPreText;
        } else if (this.deBlurPart > 0.0f) {
            str = this.deBlurPreText;
        } else {
            str = this.deFacePreText;
        }
        this.startText = str;
        w53.b.a("ProgressUpdater", "durationPart = " + f18 + ", deFacePart = " + this.deFacePart + ", deLogoPart = " + this.deLogoPart + ", deBlurPart = " + this.deBlurPart);
    }

    public final void d() {
        this.dealProgress = 0.0f;
        this.durationPart = 0.0f;
        this.deLogoPart = 0.0f;
        this.deBlurPart = 0.0f;
        this.deFacePart = 0.0f;
    }

    @NotNull
    public final Pair<Integer, String> e(@FloatRange(from = 0.0d, to = 1.0d) float progress) {
        this.dealProgress = progress;
        return a((int) (progress * 100));
    }
}
