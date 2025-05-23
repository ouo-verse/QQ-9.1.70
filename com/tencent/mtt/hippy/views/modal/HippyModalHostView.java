package com.tencent.mtt.hippy.views.modal;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.DimensionsUtil;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyModalHostView extends HippyViewGroup implements HippyInstanceLifecycleEventListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int STYLE_THEME_ANIMATED_FADE_DIALOG;
    private final int STYLE_THEME_ANIMATED_SLIDE_DIALOG;
    private final int STYLE_THEME_ANIMATED_SLIDE_FADE_DIALOG;
    private final int STYLE_THEME_FULL_SCREEN_DIALOG;
    private int mAniType;
    private String mAnimationType;
    private View mContentView;
    private Dialog mDialog;
    private boolean mEnterImmersionStatusBar;
    private final DialogRootViewGroup mHostView;
    OnRequestCloseListener mOnRequestCloseListener;
    private DialogInterface.OnShowListener mOnShowListener;
    private boolean mPropertyRequiresNewDialog;
    private boolean mStatusBarTextDarkColor;
    private boolean mTransparent;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface OnRequestCloseListener {
        void onRequestClose(DialogInterface dialogInterface);
    }

    public HippyModalHostView(Context context) {
        super(context);
        this.STYLE_THEME_FULL_SCREEN_DIALOG = 0;
        this.STYLE_THEME_ANIMATED_FADE_DIALOG = 1;
        this.STYLE_THEME_ANIMATED_SLIDE_DIALOG = 2;
        this.STYLE_THEME_ANIMATED_SLIDE_FADE_DIALOG = 3;
        this.mTransparent = true;
        this.mEnterImmersionStatusBar = false;
        this.mStatusBarTextDarkColor = false;
        this.mAniType = 0;
        ((HippyInstanceContext) context).getEngineContext().addInstanceLifecycleEventListener(this);
        this.mHostView = new DialogRootViewGroup(context);
    }

    private void dismiss() {
        Dialog dialog;
        if (!isActivityFinishing() && (dialog = this.mDialog) != null) {
            dialog.dismiss();
            this.mDialog = null;
            ((ViewGroup) this.mHostView.getParent()).removeViewAt(0);
        }
    }

    private int getScreenHeight() {
        try {
            WindowManager windowManager = (WindowManager) ContextHolder.getAppContext().getSystemService("window");
            if (windowManager.getDefaultDisplay() != null) {
                return windowManager.getDefaultDisplay().getHeight();
            }
            return -1;
        } catch (SecurityException e16) {
            LogUtils.d("HippyModalHostView", "getScreenHeight: " + e16.getMessage());
            return -1;
        }
    }

    private boolean isActivityFinishing() {
        HippyInstanceContext hippyInstanceContext = (HippyInstanceContext) getContext();
        if (hippyInstanceContext == null) {
            return true;
        }
        Context baseContext = hippyInstanceContext.getBaseContext();
        if (!(baseContext instanceof Activity)) {
            return true;
        }
        return ((Activity) baseContext).isFinishing();
    }

    private void updateProperties() {
        if (this.mTransparent) {
            this.mDialog.getWindow().clearFlags(2);
        } else {
            this.mDialog.getWindow().setDimAmount(0.5f);
            this.mDialog.getWindow().setFlags(2, 2);
        }
    }

    @Override // com.tencent.mtt.hippy.views.view.HippyViewGroup, android.view.ViewGroup
    public void addView(View view, int i3) {
        this.mHostView.addView(view, i3);
    }

    protected View createContentView(View view) {
        FrameLayout frameLayout = new FrameLayout(getContext()) { // from class: com.tencent.mtt.hippy.views.modal.HippyModalHostView.4
            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                DimensionsUtil.getStatusBarHeight();
                boolean unused = HippyModalHostView.this.mEnterImmersionStatusBar;
            }
        };
        boolean z16 = this.mEnterImmersionStatusBar;
        frameLayout.addView(view);
        frameLayout.setFitsSystemWindows(false);
        return frameLayout;
    }

    protected Dialog createDialog(Context context) {
        Window window;
        int themeResId = getThemeResId();
        if (context != null) {
            themeResId = context.getResources().getIdentifier("HippyFullScreenDialog", "style", context.getPackageName());
        }
        ReportDialog reportDialog = new ReportDialog(context, themeResId);
        if (themeResId == 0 && (window = reportDialog.getWindow()) != null) {
            window.requestFeature(1);
            window.setBackgroundDrawableResource(17170445);
            window.setLayout(-1, -1);
        }
        return reportDialog;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    protected String getAnimationType() {
        return this.mAnimationType;
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int i3) {
        return this.mHostView.getChildAt(i3);
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        return this.mHostView.getChildCount();
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    protected int getThemeResId() {
        return 0;
    }

    @Override // com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
    public void onInstanceDestroy(int i3) {
        ((HippyInstanceContext) getContext()).getEngineContext().removeInstanceLifecycleEventListener(this);
        dismiss();
    }

    @Override // com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
    public void onInstanceLoad(int i3) {
        showOrUpdate();
    }

    @Override // com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
    public void onInstancePause(int i3) {
        dismiss();
    }

    @Override // com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener
    public void onInstanceResume(int i3) {
        showOrUpdate();
    }

    @Override // com.tencent.mtt.hippy.views.view.HippyViewGroup, android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        this.mHostView.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i3) {
        this.mHostView.removeView(getChildAt(i3));
    }

    public void requestClose() {
        OnRequestCloseListener onRequestCloseListener = this.mOnRequestCloseListener;
        if (onRequestCloseListener != null) {
            onRequestCloseListener.onRequestClose(this.mDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAnimationType(String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case 3135100:
                    if (str.equals(ImageGalleryComponent.AnimationType.FADE)) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 109526449:
                    if (str.equals(WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE)) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 1089157194:
                    if (str.equals("slide_fade")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    this.mAniType = 1;
                    break;
                case 1:
                    this.mAniType = 2;
                    break;
                case 2:
                    this.mAniType = 3;
                    break;
                default:
                    this.mAniType = 0;
                    break;
            }
        }
        this.mAnimationType = str;
        this.mPropertyRequiresNewDialog = true;
    }

    public void setDialogBar(boolean z16) {
        int i3;
        try {
            Window window = this.mDialog.getWindow();
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility() & (-8193) & (-257);
            if (z16) {
                i3 = 8192;
            } else {
                i3 = 256;
            }
            window.getDecorView().setSystemUiVisibility(i3 | systemUiVisibility | 1024);
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(0);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEnterImmersionStatusBar(boolean z16) {
        this.mEnterImmersionStatusBar = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setImmersionStatusBarTextDarkColor(boolean z16) {
        this.mStatusBarTextDarkColor = z16;
    }

    public void setOnRequestCloseListener(OnRequestCloseListener onRequestCloseListener) {
        this.mOnRequestCloseListener = onRequestCloseListener;
    }

    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.mOnShowListener = onShowListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTransparent(boolean z16) {
        this.mTransparent = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showOrUpdate() {
        if (isActivityFinishing()) {
            return;
        }
        if (this.mDialog != null) {
            if (this.mPropertyRequiresNewDialog) {
                dismiss();
            } else {
                updateProperties();
                return;
            }
        }
        this.mPropertyRequiresNewDialog = false;
        this.mDialog = createDialog(getContext());
        View createContentView = createContentView(this.mHostView);
        this.mContentView = createContentView;
        this.mDialog.setContentView(createContentView);
        updateProperties();
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.getWindow() != null && this.mEnterImmersionStatusBar) {
            setDialogBar(this.mStatusBarTextDarkColor);
        }
        this.mDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mtt.hippy.views.modal.HippyModalHostView.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                ObjectAnimator ofFloat;
                HippyModalHostView.this.mOnShowListener.onShow(dialogInterface);
                int i3 = HippyModalHostView.this.mAniType;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            ofFloat = null;
                        } else {
                            ofFloat = ObjectAnimator.ofPropertyValuesHolder(HippyModalHostView.this.mContentView, PropertyValuesHolder.ofFloat(c.f123400v, 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 0.0f));
                        }
                    } else {
                        ofFloat = ObjectAnimator.ofFloat(HippyModalHostView.this.mContentView, "translationY", 0.0f);
                    }
                } else {
                    ofFloat = ObjectAnimator.ofFloat(HippyModalHostView.this.mContentView, c.f123400v, 0.0f, 1.0f);
                }
                if (ofFloat != null) {
                    ofFloat.setDuration(200L);
                    ofFloat.start();
                }
            }
        });
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mtt.hippy.views.modal.HippyModalHostView.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        });
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.mtt.hippy.views.modal.HippyModalHostView.3
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                Activity activity;
                if (keyEvent.getAction() == 1) {
                    if (i3 == 4) {
                        HippyModalHostView.this.mOnRequestCloseListener.onRequestClose(dialogInterface);
                        return true;
                    }
                    if ((((HippyInstanceContext) HippyModalHostView.this.getContext()).getBaseContext() instanceof Activity) && (activity = (Activity) ((HippyInstanceContext) HippyModalHostView.this.getContext()).getBaseContext()) != null) {
                        return activity.onKeyUp(i3, keyEvent);
                    }
                    return false;
                }
                return false;
            }
        });
        this.mDialog.getWindow().setSoftInputMode(16);
        this.mDialog.show();
        int screenHeight = getScreenHeight();
        int i3 = this.mAniType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.mContentView.setAlpha(0.0f);
                    if (screenHeight == -1) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (screenHeight == -1) {
                return;
            }
            this.mContentView.setTranslationY(screenHeight);
            return;
        }
        this.mContentView.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class DialogRootViewGroup extends HippyViewGroup {
        public DialogRootViewGroup(Context context) {
            super(context);
            setFitsSystemWindows(false);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mtt.hippy.views.image.HippyImageView, android.view.View
        public void onSizeChanged(final int i3, final int i16, int i17, int i18) {
            HippyInstanceContext hippyInstanceContext;
            super.onSizeChanged(i3, i16, i17, i18);
            if (getChildCount() > 0 && (hippyInstanceContext = (HippyInstanceContext) getContext()) != null && hippyInstanceContext.getEngineContext() != null) {
                final HippyEngineContext engineContext = hippyInstanceContext.getEngineContext();
                if (engineContext.getThreadExecutor() != null) {
                    final int id5 = getChildAt(0).getId();
                    engineContext.getThreadExecutor().postOnDomThread(new Runnable() { // from class: com.tencent.mtt.hippy.views.modal.HippyModalHostView.DialogRootViewGroup.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (engineContext.getDomManager() != null) {
                                engineContext.getDomManager().b(id5, i3, i16);
                            }
                        }
                    });
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void requestDisallowInterceptTouchEvent(boolean z16) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
    }
}
