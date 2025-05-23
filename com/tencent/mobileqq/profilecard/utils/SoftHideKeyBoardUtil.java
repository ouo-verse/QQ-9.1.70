package com.tencent.mobileqq.profilecard.utils;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SoftHideKeyBoardUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String BRAND_OPPO = "oppo";
    private int contentHeight;
    private FrameLayout.LayoutParams frameLayoutParams;
    private boolean isfirst;
    private final ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private View mChildOfContent;
    private int usableHeightPrevious;

    SoftHideKeyBoardUtil(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.isfirst = true;
        this.layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.profilecard.utils.SoftHideKeyBoardUtil.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoftHideKeyBoardUtil.this);
                }
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (SoftHideKeyBoardUtil.this.isfirst) {
                    SoftHideKeyBoardUtil softHideKeyBoardUtil = SoftHideKeyBoardUtil.this;
                    softHideKeyBoardUtil.contentHeight = softHideKeyBoardUtil.mChildOfContent.getHeight();
                    SoftHideKeyBoardUtil.this.isfirst = false;
                }
                SoftHideKeyBoardUtil.this.possiblyResizeChildOfContent();
            }
        };
        View childAt = ((FrameLayout) activity.findViewById(R.id.content)).getChildAt(0);
        this.mChildOfContent = childAt;
        childAt.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tencent.mobileqq.profilecard.utils.SoftHideKeyBoardUtil.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoftHideKeyBoardUtil.this);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    SoftHideKeyBoardUtil.this.mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(SoftHideKeyBoardUtil.this.layoutListener);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) view);
                } else {
                    SoftHideKeyBoardUtil.this.mChildOfContent.getViewTreeObserver().removeOnGlobalLayoutListener(SoftHideKeyBoardUtil.this.layoutListener);
                }
            }
        });
        this.frameLayoutParams = (FrameLayout.LayoutParams) this.mChildOfContent.getLayoutParams();
    }

    public static void assistActivity(Activity activity) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("soft_hide_key_board_util_valid", true) && !isOppoManufacture()) {
            new SoftHideKeyBoardUtil(activity);
        }
    }

    private int computeUsableHeight() {
        Rect rect = new Rect();
        this.mChildOfContent.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    private static boolean isOppoManufacture() {
        String str = Build.MANUFACTURER;
        if (str != null && BRAND_OPPO.equals(str.toLowerCase())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        int computeUsableHeight = computeUsableHeight();
        if (computeUsableHeight != this.usableHeightPrevious) {
            int height = this.mChildOfContent.getRootView().getHeight();
            int i3 = height - computeUsableHeight;
            if (i3 > height / 4) {
                this.frameLayoutParams.height = (height - i3) + RFWImmersiveUtils.getStatusBarHeight();
            } else {
                this.frameLayoutParams.height = this.contentHeight;
            }
            this.mChildOfContent.requestLayout();
            this.usableHeightPrevious = computeUsableHeight;
        }
    }
}
