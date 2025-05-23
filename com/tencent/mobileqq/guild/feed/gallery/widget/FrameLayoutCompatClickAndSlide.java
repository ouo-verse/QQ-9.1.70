package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014B\u001d\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0013\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/FrameLayoutCompatClickAndSlide;", "Landroid/widget/LinearLayout;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "", "d", "I", "downPosX", "e", "downPosY", "f", "touchSlop", tl.h.F, "Z", "isSlideGesture", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FrameLayoutCompatClickAndSlide extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int downPosX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int downPosY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int touchSlop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isSlideGesture;

    public FrameLayoutCompatClickAndSlide(@Nullable Context context) {
        super(context);
        this.downPosX = Integer.MAX_VALUE;
        this.downPosY = Integer.MAX_VALUE;
        this.touchSlop = 10;
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        Integer num;
        if (ev5 != null) {
            num = Integer.valueOf(ev5.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            this.downPosX = (int) ev5.getRawX();
            this.downPosY = (int) ev5.getRawY();
            this.isSlideGesture = false;
        } else if (num != null && num.intValue() == 2) {
            float abs = Math.abs(ev5.getRawX() - this.downPosX);
            float abs2 = Math.abs(ev5.getRawY() - this.downPosY);
            int i3 = this.touchSlop;
            if (abs > i3 || abs2 > i3) {
                this.isSlideGesture = true;
            }
        } else if (num != null && num.intValue() == 1) {
            QLog.i("FrameLayoutCompatClickAndSlide", 1, "EventUp isSlideGesture=" + this.isSlideGesture);
            if (this.isSlideGesture) {
                MotionEvent obtain = MotionEvent.obtain(ev5);
                obtain.setAction(3);
                super.dispatchTouchEvent(obtain);
                return false;
            }
        } else {
            this.downPosX = Integer.MAX_VALUE;
            this.downPosY = Integer.MAX_VALUE;
            this.isSlideGesture = false;
        }
        return super.dispatchTouchEvent(ev5);
    }

    public FrameLayoutCompatClickAndSlide(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downPosX = Integer.MAX_VALUE;
        this.downPosY = Integer.MAX_VALUE;
        this.touchSlop = 10;
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
