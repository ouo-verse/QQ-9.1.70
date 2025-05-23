package com.tencent.mobileqq.matchfriend.reborn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0013\b\u0016\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u001d\b\u0016\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u0017\u0010\u001bB%\b\u0016\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001c\u001a\u00020\r\u00a2\u0006\u0004\b\u0017\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/widget/GuestFAQRecycleView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/MotionEvent;", "e", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "", "f", UserInfo.SEX_FEMALE, "startX", h.F, "startY", "", "i", "I", "getDirection", "()I", "setDirection", "(I)V", "direction", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuestFAQRecycleView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float startX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float startY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int direction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuestFAQRecycleView(Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e16) {
        ViewParent parent;
        Intrinsics.checkNotNullParameter(e16, "e");
        if (e16.getAction() == 0 && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(e16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        if (e16.getAction() == 0) {
            this.startX = e16.getX();
            this.startY = e16.getY();
            this.direction = 0;
        } else {
            if (e16.getAction() == 2) {
                if (this.direction == 0) {
                    this.direction = Math.abs(e16.getX() - this.startX) > Math.abs(e16.getY() - this.startY) ? 1 : 2;
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(this.direction == 1);
                    }
                }
            } else if (e16.getAction() == 1 || e16.getAction() == 3) {
                this.direction = 0;
                ViewParent parent2 = getParent();
                if (parent2 != null) {
                    parent2.requestDisallowInterceptTouchEvent(false);
                }
            }
        }
        return super.onTouchEvent(e16);
    }

    public final void setDirection(int i3) {
        this.direction = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuestFAQRecycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuestFAQRecycleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNull(context);
    }
}
