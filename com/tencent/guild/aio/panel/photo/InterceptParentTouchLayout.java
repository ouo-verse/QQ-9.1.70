package com.tencent.guild.aio.panel.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0013\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u001d\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0010\u0010\u0014B%\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/InterceptParentTouchLayout;", "Landroid/widget/RelativeLayout;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "changed", "", "l", "t", "r", "b", "", "onLayout", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class InterceptParentTouchLayout extends RelativeLayout {
    public InterceptParentTouchLayout(@Nullable Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        ViewGroup viewGroup;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        ViewParent parent2 = getParent();
        ViewGroup viewGroup2 = null;
        if (parent2 instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent2;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
        ViewParent parent3 = getParent();
        if (parent3 instanceof ViewGroup) {
            viewGroup2 = (ViewGroup) parent3;
        }
        if (viewGroup2 != null) {
            viewGroup2.setClipToPadding(false);
        }
        super.dispatchTouchEvent(ev5);
        return true;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        super.onLayout(changed, l3, t16, r16, b16);
        if (QLog.isColorLevel()) {
            QLog.i("InterceptParentTouchLayout", 2, "l " + l3 + " t " + t16 + " r " + r16 + " b " + b16);
        }
    }

    public InterceptParentTouchLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InterceptParentTouchLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
