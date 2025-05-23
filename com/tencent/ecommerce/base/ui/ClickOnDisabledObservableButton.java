package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0007\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R*\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ClickOnDisabledObservableButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lcom/tencent/ecommerce/base/ui/OnClickWhenDisabledListener;", "listener", "setOnClickWhenDisabledListener", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onClickWhenDisabledListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ClickOnDisabledObservableButton extends AppCompatImageView {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Function1<? super View, Unit> onClickWhenDisabledListener;

    public ClickOnDisabledObservableButton(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    public final void setOnClickWhenDisabledListener(Function1<? super View, Unit> listener) {
        this.onClickWhenDisabledListener = listener;
    }

    public /* synthetic */ ClickOnDisabledObservableButton(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    public ClickOnDisabledObservableButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Function1<? super View, Unit> function1;
        if (event != null && event.getAction() == 0 && !isEnabled() && (function1 = this.onClickWhenDisabledListener) != null) {
            function1.invoke(this);
        }
        return super.onTouchEvent(event);
    }
}
