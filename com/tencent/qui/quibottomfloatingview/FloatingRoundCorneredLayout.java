package com.tencent.qui.quibottomfloatingview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0011\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qui/quibottomfloatingview/FloatingRoundCorneredLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "", "d", UserInfo.SEX_FEMALE, "cornerRadius", "Landroid/graphics/Path;", "e", "Landroid/graphics/Path;", "clipPath", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "QUIBottomFloatingView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class FloatingRoundCorneredLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float cornerRadius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Path clipPath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingRoundCorneredLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this.clipPath = new Path();
            a(context);
        }
    }

    private final void a(Context context) {
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this.cornerRadius = 8 * resources.getDisplayMetrics().density;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.save();
        this.clipPath.reset();
        this.clipPath.moveTo(this.cornerRadius, 0.0f);
        float f16 = width;
        this.clipPath.lineTo(f16 - this.cornerRadius, 0.0f);
        this.clipPath.quadTo(f16, 0.0f, f16, this.cornerRadius);
        float f17 = height;
        this.clipPath.lineTo(f16, f17);
        this.clipPath.lineTo(0.0f, f17);
        this.clipPath.lineTo(0.0f, this.cornerRadius);
        this.clipPath.quadTo(0.0f, 0.0f, this.cornerRadius, 0.0f);
        canvas.clipPath(this.clipPath);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingRoundCorneredLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.clipPath = new Path();
            a(context);
        }
    }
}
