package com.tencent.sqshow.zootopia.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qzone.QZoneTopGestureLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0012\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0016\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0014\u00a8\u0006$"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/ZootopiaRecycleView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "dx", "dy", "", UserInfo.SEX_FEMALE, "Landroid/view/MotionEvent;", "event", "", "E", "isIntercept", BdhLogUtil.LogTag.Tag_Conn, "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "D", "", "f", "I", "scaledTouchSlop", h.F, "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "topGestureLayout", "i", "downX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "downY", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class ZootopiaRecycleView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int scaledTouchSlop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TopGestureLayout topGestureLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int downX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int downY;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaRecycleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void C(boolean isIntercept) {
        TopGestureLayout D = D();
        if (D != null) {
            D.requestDisallowInterceptTouchEvent(isIntercept);
        }
    }

    private final void E(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (F(Math.abs(rawX - this.downX), Math.abs(rawY - this.downY))) {
                        C(true);
                        return;
                    }
                    return;
                } else if (action != 3) {
                    return;
                }
            }
            C(false);
            TopGestureLayout D = D();
            if (D != null) {
                D.setIsInterceptChildEventWhenScroll(true);
            }
            QZoneTopGestureLayout.shouldInterceptEvent(true);
            return;
        }
        this.downX = rawX;
        this.downY = rawY;
        TopGestureLayout D2 = D();
        if (D2 != null) {
            D2.setIsInterceptChildEventWhenScroll(false);
        }
        QZoneTopGestureLayout.shouldInterceptEvent(false);
    }

    private final boolean F(float dx5, float dy5) {
        int i3 = this.scaledTouchSlop;
        return (dx5 > ((float) i3) || dy5 > ((float) i3)) && dx5 > ((float) i3) && dy5 / dx5 < 0.6f;
    }

    public final TopGestureLayout D() {
        TopGestureLayout topGestureLayout = this.topGestureLayout;
        if (topGestureLayout != null) {
            return topGestureLayout;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return null;
        }
        View decorView = activity.getWindow().getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        KeyEvent.Callback callback = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            callback = viewGroup.getChildAt(i3);
            boolean z16 = callback instanceof DragFrameLayout;
            if (z16) {
                DragFrameLayout dragFrameLayout = z16 ? (DragFrameLayout) callback : null;
                callback = dragFrameLayout != null ? dragFrameLayout.getChildAt(0) : null;
            }
            if (callback instanceof TopGestureLayout) {
                break;
            }
        }
        TopGestureLayout topGestureLayout2 = callback instanceof TopGestureLayout ? (TopGestureLayout) callback : null;
        this.topGestureLayout = topGestureLayout2;
        return topGestureLayout2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        E(ev5);
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        E(ev5);
        return super.onTouchEvent(ev5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaRecycleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaRecycleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaRecycleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
