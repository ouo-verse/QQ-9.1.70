package com.tencent.mtt.hippy.views.navigator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

/* compiled from: P */
/* loaded from: classes20.dex */
public class Navigator extends HippyViewGroup {
    private static final String DIRECTION_BOTTOM = "bottom";
    private static final String DIRECTION_LEFT = "left";
    private static final String DIRECTION_RIGHT = "right";
    private static final String DIRECTION_TOP = "top";

    public Navigator(Context context) {
        super(context);
    }

    public void init(HippyRootView hippyRootView) {
        addView(hippyRootView);
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        final View view = (View) ((ObjectAnimator) animator).getTarget();
        NavigatorController.destroyInstance(view);
        animator.removeAllListeners();
        post(new Runnable() { // from class: com.tencent.mtt.hippy.views.navigator.Navigator.1
            @Override // java.lang.Runnable
            public void run() {
                Navigator.this.removeView(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        for (int i19 = 0; i19 < childCount; i19++) {
            getChildAt(i19).layout(0, 0, getWidth(), getHeight());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void pop(boolean z16, String str) {
        char c16;
        ObjectAnimator ofFloat;
        View childAt = getChildAt(getChildCount() - 1);
        if (z16) {
            if (str == null) {
                str = "";
            }
            switch (str.hashCode()) {
                case -1383228885:
                    if (str.equals("bottom")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            if (c16 != 0) {
                if (c16 != 1) {
                    if (c16 != 2) {
                        ofFloat = ObjectAnimator.ofFloat(childAt, "translationX", 0.0f, getWidth());
                    } else {
                        ofFloat = ObjectAnimator.ofFloat(childAt, "translationX", 0.0f, -getWidth());
                    }
                } else {
                    ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, getHeight());
                }
            } else {
                ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, -getHeight());
            }
            if (ofFloat != null) {
                ofFloat.addListener(this);
                ofFloat.start();
                return;
            }
            return;
        }
        NavigatorController.destroyInstance(childAt);
        removeView(childAt);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void push(HippyRootView hippyRootView, boolean z16, String str) {
        char c16;
        ObjectAnimator ofFloat;
        addView(hippyRootView);
        hippyRootView.layout(0, 0, getWidth(), getHeight());
        if (z16) {
            if (str == null) {
                str = "";
            }
            switch (str.hashCode()) {
                case -1383228885:
                    if (str.equals("bottom")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            if (c16 != 0) {
                if (c16 != 1) {
                    if (c16 != 2) {
                        ofFloat = ObjectAnimator.ofFloat(hippyRootView, "translationX", getWidth(), 0.0f);
                    } else {
                        ofFloat = ObjectAnimator.ofFloat(hippyRootView, "translationX", -getWidth(), 0.0f);
                    }
                } else {
                    ofFloat = ObjectAnimator.ofFloat(hippyRootView, "translationY", getHeight(), 0.0f);
                }
            } else {
                ofFloat = ObjectAnimator.ofFloat(hippyRootView, "translationY", -getHeight(), 0.0f);
            }
            if (ofFloat != null) {
                ofFloat.start();
            }
        }
    }
}
