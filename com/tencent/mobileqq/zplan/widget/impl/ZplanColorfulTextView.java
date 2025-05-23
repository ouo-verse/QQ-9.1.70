package com.tencent.mobileqq.zplan.widget.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u0000 22\u00020\u0001:\u000234B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b.\u0010/B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b.\u00100B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b.\u00101J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0014\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0014J0\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0014J\u0012\u0010 \u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\u000e\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!R\u0018\u0010&\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/zplan/widget/impl/ZplanColorfulTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "", "f", "", "g", "e", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "", "text", "Landroid/widget/TextView$BufferType;", "type", IECSearchBar.METHOD_SET_TEXT, "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Lcom/tencent/mobileqq/zplan/widget/impl/ZplanColorfulTextView$b;", "res", "setTextRes", h.F, "Landroidx/appcompat/widget/AppCompatTextView;", "strokeTextView", "", "i", UserInfo.SEX_FEMALE, "strokeWidthValue", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "strokeColorRes", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanColorfulTextView extends AppCompatTextView {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AppCompatTextView strokeTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float strokeWidthValue;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int strokeColorRes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/zplan/widget/impl/ZplanColorfulTextView$b;", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final /* data */ class b {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanColorfulTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.strokeWidthValue = 15.0f;
        this.strokeColorRes = -16711936;
        f(context, null, 0);
    }

    private final int e() {
        return getGravity();
    }

    private final void f(Context context, AttributeSet attrs, int defStyleAttr) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context, attrs, defStyleAttr);
        this.strokeTextView = appCompatTextView;
        TextPaint paint = appCompatTextView.getPaint();
        if (paint != null) {
            paint.setStrokeWidth(this.strokeWidthValue);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            setTextColor(this.strokeColorRes);
            setGravity(e());
        }
    }

    private final boolean g() {
        AppCompatTextView appCompatTextView = this.strokeTextView;
        return appCompatTextView != null && appCompatTextView.getVisibility() == 0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        AppCompatTextView appCompatTextView;
        if (g() && (appCompatTextView = this.strokeTextView) != null) {
            appCompatTextView.draw(canvas);
        }
        super.onDraw(canvas);
        QLog.d("ColorFulTextView", 1, "onDraw: ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        AppCompatTextView appCompatTextView;
        super.onLayout(changed, left, top, right, bottom);
        if (g() && (appCompatTextView = this.strokeTextView) != null) {
            appCompatTextView.layout(left, top, right, bottom);
        }
        QLog.d("ColorFulTextView", 1, "onLayout: " + getPaint().getShader());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        AppCompatTextView appCompatTextView;
        if (g()) {
            AppCompatTextView appCompatTextView2 = this.strokeTextView;
            if (!Intrinsics.areEqual(appCompatTextView2 != null ? appCompatTextView2.getText() : null, getText())) {
                AppCompatTextView appCompatTextView3 = this.strokeTextView;
                if (appCompatTextView3 != null) {
                    appCompatTextView3.setText(getText());
                }
                postInvalidate();
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (g() && (appCompatTextView = this.strokeTextView) != null) {
            appCompatTextView.measure(widthMeasureSpec, heightMeasureSpec);
        }
        QLog.d("ColorFulTextView", 1, "onMeasure: " + getPaint().getShader());
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        AppCompatTextView appCompatTextView = this.strokeTextView;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setLayoutParams(params);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        super.setText(text, type);
        AppCompatTextView appCompatTextView = this.strokeTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setText(text, type);
        }
        QLog.d("ColorFulTextView", 1, "setText: " + ((Object) text));
    }

    public final void setTextRes(b res) {
        Intrinsics.checkNotNullParameter(res, "res");
        throw null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanColorfulTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.strokeWidthValue = 15.0f;
        this.strokeColorRes = -16711936;
        f(context, attrs, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanColorfulTextView(Context context, AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.strokeWidthValue = 15.0f;
        this.strokeColorRes = -16711936;
        f(context, attrs, i3);
    }
}
