package com.tencent.android.androidbypass.custom;

import android.graphics.Canvas;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010D\u001a\u00020A\u00a2\u0006\u0004\bG\u0010HJ\u001a\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/android/androidbypass/custom/g;", "Lcom/tencent/android/androidbypass/custom/f;", "Landroid/text/Layout;", "oldLayout", "", NodeProps.MAX_WIDTH, "t", "Landroid/text/TextPaint;", "textPaint", "Landroid/text/StaticLayout;", "u", "widthSpec", "heightSpec", "", "measure", "Landroid/graphics/Canvas;", PM.CANVAS, "k", "i", "I", "getMaxLine", "()I", "v", "(I)V", "maxLine", "j", "Landroid/text/Layout;", "textLayout", "Landroid/text/BoringLayout$Metrics;", "Landroid/text/BoringLayout$Metrics;", "boringMetrics", "", "l", UserInfo.SEX_FEMALE, "getSpacingMult", "()F", "setSpacingMult", "(F)V", "spacingMult", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getSpacingAdd", "setSpacingAdd", "spacingAdd", "Landroid/text/Layout$Alignment;", DomainData.DOMAIN_NAME, "Landroid/text/Layout$Alignment;", "getAlignment", "()Landroid/text/Layout$Alignment;", "setAlignment", "(Landroid/text/Layout$Alignment;)V", "alignment", "Landroid/text/TextUtils$TruncateAt;", "o", "Landroid/text/TextUtils$TruncateAt;", "getTruncateAt", "()Landroid/text/TextUtils$TruncateAt;", "setTruncateAt", "(Landroid/text/TextUtils$TruncateAt;)V", "truncateAt", "p", "Landroid/text/TextPaint;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/text/TextPaint;", "setTextPaint", "(Landroid/text/TextPaint;)V", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/CharSequence;", "text", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class g extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int maxLine;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Layout textLayout;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private BoringLayout.Metrics boringMetrics;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float spacingMult;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float spacingAdd;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Layout.Alignment alignment;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextUtils.TruncateAt truncateAt;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextPaint textPaint;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final CharSequence text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull String id5, @NotNull CharSequence text) {
        super(id5);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(text, "text");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) id5, (Object) text);
            return;
        }
        this.text = text;
        this.maxLine = Integer.MAX_VALUE;
        this.spacingMult = 1.0f;
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.truncateAt = TextUtils.TruncateAt.END;
        this.textPaint = new TextPaint();
    }

    private final Layout t(Layout oldLayout, int maxWidth) {
        BoringLayout.Metrics metrics;
        BoringLayout make;
        if (this.maxLine == 1) {
            metrics = BoringLayout.isBoring(this.text, this.textPaint, this.boringMetrics);
        } else {
            metrics = null;
        }
        if (metrics != null) {
            this.boringMetrics = metrics;
            if (oldLayout instanceof BoringLayout) {
                make = ((BoringLayout) oldLayout).replaceOrMake(this.text, this.textPaint, maxWidth, this.alignment, this.spacingMult, this.spacingAdd, metrics, false, this.truncateAt, maxWidth);
            } else {
                make = BoringLayout.make(this.text, this.textPaint, maxWidth, this.alignment, this.spacingMult, this.spacingAdd, metrics, false, this.truncateAt, maxWidth);
            }
            Intrinsics.checkNotNullExpressionValue(make, "if (oldLayout is BoringL\u2026, maxWidth)\n            }");
            return make;
        }
        return u(this.textPaint, maxWidth);
    }

    private final StaticLayout u(TextPaint textPaint, int maxWidth) {
        CharSequence charSequence = this.text;
        StaticLayout build = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, maxWidth).setEllipsize(this.truncateAt).setAlignment(this.alignment).setLineSpacing(this.spacingAdd, this.spacingMult).setMaxLines(this.maxLine).build();
        Intrinsics.checkNotNullExpressionValue(build, "StaticLayout.Builder.obt\u2026\n                .build()");
        return build;
    }

    @Override // com.tencent.android.androidbypass.custom.f
    protected void k(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Layout layout = this.textLayout;
        if (layout != null) {
            layout.draw(canvas);
        }
    }

    @Override // com.tencent.android.androidbypass.custom.d
    public void measure(int widthSpec, int heightSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(widthSpec), Integer.valueOf(heightSpec));
            return;
        }
        int mode = View.MeasureSpec.getMode(widthSpec);
        int size = View.MeasureSpec.getSize(widthSpec);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            p(false);
            return;
        }
        if (!i() && size != f()) {
            Layout t16 = t(this.textLayout, size);
            this.textLayout = t16;
            r(t16.getWidth());
            q(f.INSTANCE.a(t16.getHeight(), heightSpec));
            if (f() <= 0 || e() <= 0) {
                z16 = false;
            }
            p(z16);
        }
    }

    @NotNull
    public final TextPaint s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TextPaint) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.textPaint;
    }

    public final void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.maxLine = i3;
        }
    }
}
