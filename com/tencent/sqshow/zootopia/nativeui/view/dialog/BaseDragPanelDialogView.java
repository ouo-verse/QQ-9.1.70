package com.tencent.sqshow.zootopia.nativeui.view.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenDefaultHeaderView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 '2\u00020\u0001:\u0001(B/\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\f\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0004J\b\u0010\t\u001a\u00020\u0007H&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006)"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/BaseDragPanelDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/BasePanelDialogView;", "Landroid/view/MotionEvent;", "ev", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "N", "", "dispatchTouchEvent", "", "O", "D", "Z", "isTouchOnHeaderView", "", "E", UserInfo.SEX_FEMALE, "lastY", "initialTop", "Landroid/widget/LinearLayout;", "G", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenDefaultHeaderView;", "H", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenDefaultHeaderView;", "headView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "I", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class BaseDragPanelDialogView extends BasePanelDialogView {

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isTouchOnHeaderView;

    /* renamed from: E, reason: from kotlin metadata */
    private float lastY;

    /* renamed from: F, reason: from kotlin metadata */
    private float initialTop;

    /* renamed from: G, reason: from kotlin metadata */
    private LinearLayout container;

    /* renamed from: H, reason: from kotlin metadata */
    private final QUSHalfScreenDefaultHeaderView headView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDragPanelDialogView(Context context, AttributeSet attributeSet, int i3, j channel) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.container = new LinearLayout(context);
        this.headView = new QUSHalfScreenDefaultHeaderView(context, attributeSet, i3);
    }

    private final void P(MotionEvent ev5) {
        float rawY = ev5.getRawY();
        float f16 = rawY - this.lastY;
        float y16 = this.container.getY();
        float f17 = y16 + f16;
        QLog.d("BaseDragPanelDialogView", 4, "onActionMove curY:" + rawY + " moveY:" + f16 + " top:" + y16 + " targetY:" + f17 + " initialTop:" + this.initialTop + " lastY:" + this.lastY);
        if (f17 > this.initialTop) {
            this.container.setY(f17);
        }
        this.lastY = rawY;
    }

    private final void Q(MotionEvent ev5) {
        float rawY = ev5.getRawY();
        float f16 = rawY - this.lastY;
        float y16 = this.container.getY();
        float f17 = y16 + f16;
        QLog.d("BaseDragPanelDialogView", 4, "onActionUp curY:" + rawY + " moveY:" + f16 + " top:" + y16 + " targetY:" + f17 + " initialTop:" + this.initialTop + " lastY:" + this.lastY);
        if (f17 > this.initialTop + O()) {
            o();
        } else {
            ViewPropertyAnimator translationY = this.container.animate().translationY(0.0f);
            translationY.setDuration(200L);
            translationY.start();
        }
        this.container.setY(f17);
        this.isTouchOnHeaderView = false;
    }

    public abstract View N();

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected final View m() {
        this.container.setOrientation(1);
        this.headView.setBackgroundResource(R.drawable.i5r);
        this.container.addView(this.headView, new FrameLayout.LayoutParams(-1, i.b(36)));
        this.container.addView(N(), new FrameLayout.LayoutParams(-1, -2));
        return this.container;
    }

    public final int O() {
        return i.b(100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        Integer valueOf = ev5 != null ? Integer.valueOf(ev5.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.lastY = ev5.getRawY();
            this.initialTop = this.container.getY();
            Rect rect = new Rect();
            this.headView.getGlobalVisibleRect(rect);
            this.isTouchOnHeaderView = rect.contains((int) ev5.getRawX(), (int) ev5.getRawY());
        } else if (valueOf != null && valueOf.intValue() == 2) {
            if (this.isTouchOnHeaderView) {
                P(ev5);
            }
        } else if (valueOf != null && valueOf.intValue() == 1) {
            Q(ev5);
        }
        return super.dispatchTouchEvent(ev5);
    }
}
