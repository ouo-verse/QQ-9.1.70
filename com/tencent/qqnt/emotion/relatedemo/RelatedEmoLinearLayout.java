package com.tencent.qqnt.emotion.relatedemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u001c\u0010\u000f\u001a\b\u0018\u00010\rR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoLinearLayout;", "Landroid/widget/LinearLayout;", "", HippyTKDListViewAdapter.X, "y", "Landroid/view/View;", "d", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "event", "onTouchEvent", "Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoLinearLayout$CheckForLongPress;", "Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoLinearLayout$CheckForLongPress;", "mPendingCheckForLongPress", "e", "Z", "mHasPerformedLongPress", "f", "Landroid/view/View;", "mPointView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CheckForLongPress", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class RelatedEmoLinearLayout extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CheckForLongPress mPendingCheckForLongPress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mHasPerformedLongPress;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mPointView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoLinearLayout$CheckForLongPress;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "e", "Landroid/view/MotionEvent;", "d", "Landroid/view/MotionEvent;", "getEvent", "()Landroid/view/MotionEvent;", "event", "", "I", "getMOriginalWindowAttachCount", "()I", "setMOriginalWindowAttachCount", "(I)V", "mOriginalWindowAttachCount", "<init>", "(Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoLinearLayout;Landroid/view/MotionEvent;)V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public final class CheckForLongPress implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MotionEvent event;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int mOriginalWindowAttachCount;
        final /* synthetic */ RelatedEmoLinearLayout this$0;

        public CheckForLongPress(@NotNull RelatedEmoLinearLayout relatedEmoLinearLayout, MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.this$0 = relatedEmoLinearLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) relatedEmoLinearLayout, (Object) event);
            } else {
                this.event = event;
            }
        }

        public final void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                this.mOriginalWindowAttachCount = this.this$0.getWindowAttachCount();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (this.this$0.getParent() != null && this.mOriginalWindowAttachCount == this.this$0.getWindowAttachCount() && this.this$0.mPointView != null) {
                View view = this.this$0.mPointView;
                if (view != null) {
                    obj = view.getTag();
                } else {
                    obj = null;
                }
                if (((EmoticonInfo) obj) != null) {
                    this.this$0.mHasPerformedLongPress = true;
                    View view2 = this.this$0.mPointView;
                    if (view2 != null) {
                        view2.performLongClick();
                    }
                    this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
                    this.this$0.sendAccessibilityEvent(2);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RelatedEmoLinearLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
    }

    private final View d(float x16, float y16) {
        int childCount = super.getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                View childAt = super.getChildAt(childCount);
                float scrollX = (super.getScrollX() + x16) - childAt.getLeft();
                float scrollY = (super.getScrollY() + y16) - childAt.getTop();
                if (scrollX >= 0.0f && scrollX <= childAt.getWidth() && scrollY >= 0.0f && scrollY < childAt.getHeight() && childAt.getVisibility() == 0) {
                    return childAt;
                }
            } else {
                return null;
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    super.setPressed(false);
                    CheckForLongPress checkForLongPress = this.mPendingCheckForLongPress;
                    if (checkForLongPress != null) {
                        removeCallbacks(checkForLongPress);
                    }
                    View view = this.mPointView;
                    if (view != null) {
                        view.setAlpha(1.0f);
                    }
                    this.mPointView = null;
                }
            } else {
                View view2 = this.mPointView;
                if (view2 != null) {
                    view2.setAlpha(1.0f);
                }
                if (!this.mHasPerformedLongPress) {
                    CheckForLongPress checkForLongPress2 = this.mPendingCheckForLongPress;
                    if (checkForLongPress2 != null) {
                        removeCallbacks(checkForLongPress2);
                    }
                    View view3 = this.mPointView;
                    if (view3 != null) {
                        view3.performClick();
                    }
                }
                this.mPointView = null;
            }
        } else {
            this.mHasPerformedLongPress = false;
            View d16 = d(event.getX(), event.getY());
            this.mPointView = d16;
            if (d16 != null) {
                d16.setAlpha(0.2f);
                if (this.mPendingCheckForLongPress == null) {
                    this.mPendingCheckForLongPress = new CheckForLongPress(this, event);
                }
                CheckForLongPress checkForLongPress3 = this.mPendingCheckForLongPress;
                if (checkForLongPress3 != null) {
                    checkForLongPress3.e();
                }
                d16.postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
            }
        }
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RelatedEmoLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RelatedEmoLinearLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
    }

    public /* synthetic */ RelatedEmoLinearLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
