package com.tencent.aio.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aio/widget/DrawableCenterTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onDraw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class DrawableCenterTextView extends TextView {
    static IPatchRedirector $redirector_;

    public DrawableCenterTextView(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            setGravity(16);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable[] compoundDrawables = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(compoundDrawables, "compoundDrawables");
        Drawable drawable = compoundDrawables[0];
        Drawable drawable2 = compoundDrawables[2];
        if (drawable == null && drawable2 == null) {
            super.onDraw(canvas);
            return;
        }
        float measureText = getPaint().measureText(getText().toString()) + getCompoundDrawablePadding();
        if (drawable != null && drawable2 == null) {
            measureText += drawable.getIntrinsicWidth();
        } else if (drawable2 != null && drawable == null) {
            measureText += drawable2.getIntrinsicWidth();
            setPadding(0, 0, (int) (getWidth() - measureText), 0);
        } else if (drawable != null && drawable2 != null) {
            measureText += drawable2.getIntrinsicWidth() + drawable.getIntrinsicWidth() + r5;
            setPadding(0, 0, (int) (getWidth() - measureText), 0);
        }
        canvas.translate((getWidth() - measureText) / 2, 0.0f);
        super.onDraw(canvas);
    }

    public DrawableCenterTextView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            setGravity(16);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
        }
    }
}
