package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001\u0003B\u001d\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0016\u0010\u001a\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/DragLinearLayout;", "Landroid/widget/LinearLayout;", "", "a", "Landroid/view/MotionEvent;", "ev", "b", "Landroid/view/View;", "d", "Landroid/view/View;", "headView", "e", "firstVisibleContentView", "", "f", "I", "startX", tl.h.F, "startY", "i", "endX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "endY", BdhLogUtil.LogTag.Tag_Conn, "dX", "D", "dY", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "E", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DragLinearLayout extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int dX;

    /* renamed from: D, reason: from kotlin metadata */
    private int dY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View headView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View firstVisibleContentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int startX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int startY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int endX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int endY;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DragLinearLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        this.headView = getChildAt(0);
        this.firstVisibleContentView = getChildAt(1);
    }

    public final void b(@NotNull MotionEvent ev5) {
        boolean z16;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        View view = this.firstVisibleContentView;
        if (view != null && view.getVisibility() == 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.firstVisibleContentView = getChildAt(2);
        }
        if (this.headView != null && this.firstVisibleContentView != null) {
            int action = ev5.getAction();
            if (action != 0) {
                ViewGroup.LayoutParams layoutParams2 = null;
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return;
                        }
                    } else {
                        this.endX = (int) ev5.getX();
                        int y16 = (int) ev5.getY();
                        this.endY = y16;
                        int i3 = this.endX - this.startX;
                        this.dX = i3;
                        this.dY = y16 - this.startY;
                        if (Math.abs(i3) < Math.abs(this.dY)) {
                            if (this.dY > 0) {
                                View view2 = this.headView;
                                if (view2 != null) {
                                    layoutParams2 = view2.getLayoutParams();
                                }
                                if (layoutParams2 != null) {
                                    layoutParams2.height = Math.min(this.dY, ViewUtils.dpToPx(100.0f));
                                }
                                View view3 = this.headView;
                                if (view3 != null) {
                                    view3.setLayoutParams(layoutParams2);
                                    return;
                                }
                                return;
                            }
                            View view4 = this.firstVisibleContentView;
                            if (view4 != null) {
                                layoutParams2 = view4.getLayoutParams();
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                            if (marginLayoutParams != null) {
                                marginLayoutParams.topMargin = -Math.min(Math.abs(this.dY), ViewUtils.dpToPx(100.0f));
                            }
                            View view5 = this.firstVisibleContentView;
                            if (view5 != null) {
                                view5.setLayoutParams(marginLayoutParams);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                View view6 = this.headView;
                if (view6 != null) {
                    layoutParams = view6.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    layoutParams.height = 0;
                }
                View view7 = this.headView;
                if (view7 != null) {
                    view7.setLayoutParams(layoutParams);
                }
                View view8 = this.firstVisibleContentView;
                if (view8 != null) {
                    layoutParams2 = view8.getLayoutParams();
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.topMargin = 0;
                }
                View view9 = this.firstVisibleContentView;
                if (view9 != null) {
                    view9.setLayoutParams(marginLayoutParams2);
                    return;
                }
                return;
            }
            this.startX = (int) ev5.getX();
            this.startY = (int) ev5.getY();
            return;
        }
        QLog.d("DragLinearLayout", 1, "onDispatchTouchEvent null");
    }

    public /* synthetic */ DragLinearLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DragLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
