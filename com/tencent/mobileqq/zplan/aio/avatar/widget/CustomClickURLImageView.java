package com.tencent.mobileqq.zplan.aio.avatar.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/avatar/widget/CustomClickURLImageView;", "Lcom/tencent/image/URLImageView;", "Landroid/graphics/Rect;", "bounds", "", "setTouchArea", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "d", "Landroid/graphics/Rect;", "mBounds", "e", "Z", "mDelegateTargeted", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CustomClickURLImageView extends URLImageView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Rect mBounds;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mDelegateTargeted;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomClickURLImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int x16 = (int) event.getX();
        int y16 = (int) event.getY();
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            Rect rect = this.mBounds;
            this.mDelegateTargeted = rect != null ? rect.contains(x16, y16) : false;
        } else if (actionMasked == 3) {
            this.mDelegateTargeted = false;
        }
        if (this.mBounds == null || this.mDelegateTargeted) {
            return super.onTouchEvent(event);
        }
        return false;
    }

    public final void setTouchArea(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.mBounds = bounds;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomClickURLImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CustomClickURLImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomClickURLImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
