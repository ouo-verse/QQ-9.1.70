package com.tencent.mobileqq.qwallet.hb.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0013\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015B\u001d\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0018B#\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u0014\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/view/MediumBoldTextView;", "Landroid/widget/TextView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "d", UserInfo.SEX_FEMALE, "strokeWidth", "", "e", "Z", "getEnableBold", "()Z", "setEnableBold", "(Z)V", "enableBold", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "a", "qqpay-ui_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MediumBoldTextView extends TextView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float strokeWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean enableBold;

    public MediumBoldTextView(@Nullable Context context) {
        super(context);
        this.strokeWidth = 0.9f;
        this.enableBold = true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        if (this.enableBold) {
            TextPaint paint = getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            paint.setStrokeWidth(this.strokeWidth);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        super.onDraw(canvas);
    }

    public final void setEnableBold(boolean z16) {
        this.enableBold = z16;
    }

    public MediumBoldTextView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.strokeWidth = 0.9f;
        this.enableBold = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediumBoldTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.strokeWidth = 0.9f;
        this.enableBold = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, gj2.a.X1, i3, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026extView, defStyleAttr, 0)");
        this.strokeWidth = obtainStyledAttributes.getFloat(gj2.a.Y1, 0.9f);
        obtainStyledAttributes.recycle();
    }
}
