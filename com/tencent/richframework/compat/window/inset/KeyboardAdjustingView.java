package com.tencent.richframework.compat.window.inset;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.richframework.compat.window.inset.KeyboardAdjustingView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001,\u0018\u0000 52\u00020\u00012\u00020\u0002:\u000256B\u0017\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J0\u0010\u0012\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0014J\b\u0010\u0013\u001a\u00020\u0005H\u0014J\b\u0010\u0014\u001a\u00020\u0005H\u0014J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000bJ\u001a\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0016\u0010#\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010$R\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010&\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010!R\u0016\u0010'\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001fR\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00067"}, d2 = {"Lcom/tencent/richframework/compat/window/inset/KeyboardAdjustingView;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "", "getContentHeight", "", "removeRunnable", "setWindowListener", "calculateBottomInWindow", "calculateParentBottomInWindow", "scroll", "", "changed", "", "left", "top", "right", "bottom", "onLayout", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/richframework/compat/window/inset/KeyboardAdjustingView$KeyboardEventListener;", "listener", "setKeyboardListener", h.f248218g, "enableOpen", "Landroid/view/View;", "v", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", "Z", "currentBottomLocation", UserInfo.SEX_FEMALE, "isDismiss", "isFollowDrop", "Lcom/tencent/richframework/compat/window/inset/KeyboardAdjustingView$KeyboardEventListener;", "keyboardCurrentY", "keyboardHeight", "isStartAnimation", "Ljava/lang/Runnable;", "dropRunnable", "Ljava/lang/Runnable;", "upRunnable", "com/tencent/richframework/compat/window/inset/KeyboardAdjustingView$windowInsetsAnimation$1", "windowInsetsAnimation", "Lcom/tencent/richframework/compat/window/inset/KeyboardAdjustingView$windowInsetsAnimation$1;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "KeyboardEventListener", "compat-window-inset_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class KeyboardAdjustingView extends FrameLayout implements OnApplyWindowInsetsListener {
    private static String TAG = "KeyboardAdjustingView";
    private float currentBottomLocation;
    private final Runnable dropRunnable;
    private boolean isDismiss;
    private boolean isFollowDrop;
    private boolean isOpen;
    private boolean isStartAnimation;
    private float keyboardCurrentY;
    private float keyboardHeight;
    private KeyboardEventListener listener;
    private final Runnable upRunnable;
    private KeyboardAdjustingView$windowInsetsAnimation$1 windowInsetsAnimation;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/compat/window/inset/KeyboardAdjustingView$KeyboardEventListener;", "", "onDrop", "", "onProcess", "currentKeyboardHeight", "", "onShow", "keyboardHeight", "compat-window-inset_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public interface KeyboardEventListener {
        void onDrop();

        void onProcess(float currentKeyboardHeight);

        void onShow(float keyboardHeight);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r7v7, types: [com.tencent.richframework.compat.window.inset.KeyboardAdjustingView$windowInsetsAnimation$1] */
    public KeyboardAdjustingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        boolean configValue = RFWConfig.getConfigValue("rfw_keyboard_adjust_view_switch", true);
        final int i3 = 0;
        RFWLog.d(TAG, RFWLog.USR, "isOpen:" + configValue);
        Unit unit = Unit.INSTANCE;
        this.isOpen = configValue;
        this.isFollowDrop = attrs.getAttributeBooleanValue(R.attr.f155269zp, true);
        this.dropRunnable = new Runnable() { // from class: com.tencent.richframework.compat.window.inset.KeyboardAdjustingView$dropRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                z16 = KeyboardAdjustingView.this.isStartAnimation;
                if (z16) {
                    return;
                }
                KeyboardAdjustingView.this.setTranslationY(0.0f);
            }
        };
        this.upRunnable = new Runnable() { // from class: com.tencent.richframework.compat.window.inset.KeyboardAdjustingView$upRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                float contentHeight;
                float f16;
                String str;
                float f17;
                float f18;
                z16 = KeyboardAdjustingView.this.isStartAnimation;
                if (z16) {
                    return;
                }
                KeyboardAdjustingView keyboardAdjustingView = KeyboardAdjustingView.this;
                contentHeight = keyboardAdjustingView.getContentHeight();
                f16 = KeyboardAdjustingView.this.keyboardHeight;
                keyboardAdjustingView.keyboardCurrentY = contentHeight - f16;
                str = KeyboardAdjustingView.TAG;
                int i16 = RFWLog.DEV;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("upRunnable, keyboardCurrentY:");
                f17 = KeyboardAdjustingView.this.keyboardCurrentY;
                sb5.append(f17);
                sb5.append(", currentBottomLocation:");
                f18 = KeyboardAdjustingView.this.currentBottomLocation;
                sb5.append(f18);
                RFWLog.d(str, i16, sb5.toString());
                KeyboardAdjustingView.this.scroll();
            }
        };
        this.windowInsetsAnimation = new WindowInsetsAnimationCompat.Callback(i3) { // from class: com.tencent.richframework.compat.window.inset.KeyboardAdjustingView$windowInsetsAnimation$1
            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public void onEnd(WindowInsetsAnimationCompat animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onEnd(animation);
                KeyboardAdjustingView.this.isStartAnimation = false;
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
                KeyboardAdjustingView.KeyboardEventListener keyboardEventListener;
                Intrinsics.checkNotNullParameter(insets, "insets");
                Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
                float f16 = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
                KeyboardAdjustingView keyboardAdjustingView = KeyboardAdjustingView.this;
                View rootView = keyboardAdjustingView.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                keyboardAdjustingView.keyboardCurrentY = rootView.getHeight() - f16;
                KeyboardAdjustingView.this.scroll();
                keyboardEventListener = KeyboardAdjustingView.this.listener;
                if (keyboardEventListener != null) {
                    keyboardEventListener.onProcess(f16);
                }
                return insets;
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
                boolean z16;
                KeyboardAdjustingView.KeyboardEventListener keyboardEventListener;
                float f16;
                float calculateBottomInWindow;
                String str;
                boolean z17;
                KeyboardAdjustingView.KeyboardEventListener keyboardEventListener2;
                Intrinsics.checkNotNullParameter(animation, "animation");
                Intrinsics.checkNotNullParameter(bounds, "bounds");
                KeyboardAdjustingView.this.isStartAnimation = true;
                z16 = KeyboardAdjustingView.this.isDismiss;
                if (z16) {
                    keyboardEventListener2 = KeyboardAdjustingView.this.listener;
                    if (keyboardEventListener2 != null) {
                        keyboardEventListener2.onDrop();
                    }
                } else {
                    keyboardEventListener = KeyboardAdjustingView.this.listener;
                    if (keyboardEventListener != null) {
                        f16 = KeyboardAdjustingView.this.keyboardHeight;
                        keyboardEventListener.onShow(f16);
                    }
                }
                KeyboardAdjustingView keyboardAdjustingView = KeyboardAdjustingView.this;
                calculateBottomInWindow = keyboardAdjustingView.calculateBottomInWindow();
                keyboardAdjustingView.currentBottomLocation = calculateBottomInWindow;
                str = KeyboardAdjustingView.TAG;
                int i16 = RFWLog.DEV;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onStart:isDrop:");
                z17 = KeyboardAdjustingView.this.isDismiss;
                sb5.append(z17);
                RFWLog.d(str, i16, sb5.toString());
                WindowInsetsAnimationCompat.BoundsCompat onStart = super.onStart(animation, bounds);
                Intrinsics.checkNotNullExpressionValue(onStart, "super.onStart(animation, bounds)");
                return onStart;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float calculateBottomInWindow() {
        return calculateParentBottomInWindow() + getHeight();
    }

    private final float calculateParentBottomInWindow() {
        float top = getTop();
        Object parent = getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            top += view.getY();
            parent = view.getParent();
        }
        return top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getContentHeight() {
        if (getRootView().findViewById(android.R.id.content) != null) {
            return r0.getHeight();
        }
        return calculateBottomInWindow();
    }

    private final void removeRunnable() {
        removeCallbacks(this.dropRunnable);
        removeCallbacks(this.upRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scroll() {
        float f16 = this.currentBottomLocation;
        if (f16 < this.keyboardCurrentY) {
            setTranslationY(0.0f);
            return;
        }
        float translationY = f16 + getTranslationY();
        String str = TAG;
        int i3 = RFWLog.DEV;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onProgress, keyboardCurrentY:");
        sb5.append(this.keyboardCurrentY);
        sb5.append(", viewCurrentY:");
        sb5.append(translationY);
        sb5.append(", rootView:");
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        sb5.append(rootView.getHeight());
        RFWLog.d(str, i3, sb5.toString());
        if (!this.isDismiss || this.isFollowDrop) {
            float f17 = this.keyboardCurrentY;
            float f18 = this.currentBottomLocation;
            if (f17 >= f18) {
                setTranslationY(0.0f);
            } else {
                setTranslationY(f17 - f18);
            }
        }
    }

    private final void setWindowListener() {
        ViewCompat.setWindowInsetsAnimationCallback(getRootView(), this.windowInsetsAnimation);
    }

    public final void enableOpen(boolean isOpen) {
        this.isOpen = isOpen;
        if (!isOpen) {
            ViewCompat.setWindowInsetsAnimationCallback(getRootView(), null);
        } else {
            ViewCompat.setWindowInsetsAnimationCallback(getRootView(), this.windowInsetsAnimation);
        }
    }

    /* renamed from: isOpen, reason: from getter */
    public final boolean getIsOpen() {
        return this.isOpen;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View v3, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (!this.isOpen) {
            return insets;
        }
        removeRunnable();
        this.keyboardHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        boolean isVisible = insets.isVisible(WindowInsetsCompat.Type.ime());
        RFWLog.d(TAG, RFWLog.USR, "onApplyWindowInsets, keyboardHeight:" + this.keyboardHeight + ", isVisible:" + isVisible);
        boolean z16 = this.keyboardHeight <= ((float) 200);
        this.isDismiss = z16;
        if (this.isStartAnimation) {
            return insets;
        }
        if (z16) {
            postDelayed(this.dropRunnable, 200L);
        } else {
            postDelayed(this.upRunnable, 200L);
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isOpen) {
            setWindowListener();
            ViewCompat.setOnApplyWindowInsetsListener(this, this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.isOpen) {
            removeRunnable();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.isOpen) {
            float calculateBottomInWindow = calculateBottomInWindow();
            this.currentBottomLocation = calculateBottomInWindow;
            float f16 = this.keyboardCurrentY;
            float f17 = 0.0f;
            if (f16 != 0.0f && f16 < calculateBottomInWindow) {
                f17 = f16 - calculateBottomInWindow;
            }
            setTranslationY(f17);
        }
    }

    public final void setKeyboardListener(KeyboardEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }
}
