package com.tencent.sqshow.zootopia.recommend.characterV2.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.recommend.characterV2.data.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\tB'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/view/ZPlanRoleMidTouchTap;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", "ev", "", "c", "Lbb4/h;", "l", "setListener", "a", "b", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "Landroid/graphics/PointF;", "d", "Landroid/graphics/PointF;", "mLastDownPoint", "e", "Z", "needTouchAnalysis", "f", "Lbb4/h;", "mListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRoleMidTouchTap extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private PointF mLastDownPoint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needTouchAnalysis;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private bb4.h mListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanRoleMidTouchTap(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c(MotionEvent ev5) {
        bb4.h hVar;
        int action = ev5.getAction();
        if (action == 0) {
            this.mLastDownPoint = new PointF(ev5.getRawX(), ev5.getRawY());
            QLog.i("ZPlanRoleMidTouchTap_", 1, "handleTouchEvent ACTION_DOWN " + ev5);
            return;
        }
        if (action == 1 || action == 3) {
            float rawX = ev5.getRawX() - this.mLastDownPoint.x;
            float rawY = ev5.getRawY() - this.mLastDownPoint.y;
            double sqrt = Math.sqrt(Math.pow(rawX, 2.0d) + Math.pow(rawY, 2.0d));
            QLog.i("ZPlanRoleMidTouchTap_", 1, "handleTouchEvent ACTION_UP/CANCEL dx:" + rawX + ", dy:" + rawY + ", dis:" + sqrt);
            if (sqrt <= 10.0d) {
                bb4.h hVar2 = this.mListener;
                if (hVar2 != null) {
                    hVar2.onClick();
                    return;
                }
                return;
            }
            if (rawX < 0.0f) {
                bb4.h hVar3 = this.mListener;
                if (hVar3 != null) {
                    hVar3.q();
                    return;
                }
                return;
            }
            if (rawX <= 0.0f || (hVar = this.mListener) == null) {
                return;
            }
            hVar.w();
        }
    }

    public final void setListener(bb4.h l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListener = l3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanRoleMidTouchTap(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        this.needTouchAnalysis = false;
    }

    public final void b() {
        this.needTouchAnalysis = true;
    }

    public /* synthetic */ ZPlanRoleMidTouchTap(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        if (ev5 != null) {
            boolean booleanValue = c.f372487a.b().b().booleanValue();
            if (this.needTouchAnalysis && booleanValue) {
                c(ev5);
            }
        }
        return super.onInterceptTouchEvent(ev5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanRoleMidTouchTap(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLastDownPoint = new PointF(0.0f, 0.0f);
    }
}
