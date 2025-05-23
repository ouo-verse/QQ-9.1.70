package com.tencent.gamematrix.gmcg.sdk.view;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.gamematrix.gmcg.api.GmCgImeInputController;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.webrtc.CgTextEditor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGImeInputControllerInternal implements GmCgImeInputController {

    @Nullable
    private Activity mActivity;
    private CgTextEditor mCgTextEditor;
    private final int mGameScreenOrientation;
    private Handler mHandler;
    private GmCgImeInputController.GmCgImeInputEvtListener mImeInputEventListener;

    @Nullable
    private FrameLayout mPlayContainerView;
    private boolean mEnableImeInput = false;
    private final Rect mLastContent = new Rect();
    private long mStartImeTs = -1;
    private final Runnable mHideInputRunnable = new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.view.d
        @Override // java.lang.Runnable
        public final void run() {
            CGImeInputControllerInternal.this.doImeInputCloudFinish();
        }
    };

    public CGImeInputControllerInternal(@Nullable FrameLayout frameLayout, int i3) {
        this.mPlayContainerView = frameLayout;
        this.mGameScreenOrientation = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doImeInputCloudFinish() {
        CgTextEditor cgTextEditor;
        CGLog.i("doImeInputCloudFinish");
        this.mStartImeTs = -1L;
        if (this.mEnableImeInput && (cgTextEditor = this.mCgTextEditor) != null) {
            cgTextEditor.setVisibility(4);
            Activity activity = this.mActivity;
            if (activity != null) {
                CGSystemUtil.forceHideInputMethod(activity, this.mCgTextEditor);
            }
        }
    }

    private int getPlayRenderHeight() {
        FrameLayout frameLayout = this.mPlayContainerView;
        if (frameLayout != null) {
            return frameLayout.getHeight();
        }
        return 0;
    }

    private int getPlayRenderWidth() {
        FrameLayout frameLayout = this.mPlayContainerView;
        if (frameLayout != null) {
            return frameLayout.getWidth();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enableImeInput$0() {
        GmCgImeInputController.GmCgImeInputEvtListener gmCgImeInputEvtListener;
        int i3;
        if (this.mActivity == null) {
            CGLog.w("onGlobalLayout mActivity is null!!!");
            return;
        }
        Point point = new Point();
        this.mActivity.getWindowManager().getDefaultDisplay().getRealSize(point);
        CGLog.i("get real size: (" + point.x + ", " + point.y + ")");
        Rect rect = new Rect();
        this.mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i16 = rect.bottom;
        Rect rect2 = this.mLastContent;
        if (i16 != rect2.bottom) {
            rect2.bottom = i16;
            CGLog.i("screenSize.width=" + point.x + ", screenSize.height=" + point.y);
            CGLog.i("r.left=" + rect.left + ", r.top=" + rect.top + ", r.right=" + rect.right + ", r.bottom=" + rect.bottom);
            int i17 = point.y;
            int i18 = rect.bottom;
            if (i17 != i18 && i17 > i18) {
                int identifier = this.mActivity.getResources().getIdentifier("status_bar_height", "dimen", "android");
                int i19 = 0;
                if (identifier > 0) {
                    i3 = this.mActivity.getResources().getDimensionPixelSize(identifier);
                } else {
                    i3 = 0;
                }
                CGLog.i("statusBar height=" + i3);
                if (rect.top == i3) {
                    CGLog.i("status bar is visible");
                } else {
                    CGLog.i("status bar is invisible, set top to " + rect.top);
                    i19 = rect.top;
                }
                if (1 == this.mGameScreenOrientation) {
                    CGLog.i("portrait mode, set top to " + rect.top);
                    i19 = rect.top;
                }
                int i26 = point.y;
                int playRenderHeight = getPlayRenderHeight();
                CGLog.i("play render height=" + playRenderHeight + ", play render width=" + getPlayRenderWidth());
                if (i26 < playRenderHeight) {
                    i26 = playRenderHeight;
                }
                int i27 = i26 - (rect.bottom - i19);
                float f16 = (i27 * 1.0f) / i26;
                CGLog.i("softkeyboardHeight=" + i27 + ", screenSize.height= " + i26 + ", ratio=" + f16);
                if (this.mImeInputEventListener != null) {
                    CGLog.i("mCgLocalImeInputListener != null");
                    this.mImeInputEventListener.onImeInputEvtSizeRatioGot(f16);
                    return;
                }
                return;
            }
            CGLog.i("(screenSize.y == r.bottom) || (screenSize.height <= r.bottom)");
            if (this.mCgTextEditor.isShown() && (gmCgImeInputEvtListener = this.mImeInputEventListener) != null) {
                gmCgImeInputEvtListener.onImeInputEvtHide();
            }
        }
    }

    private void setupCgTextEditor() {
        if (this.mPlayContainerView == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.mPlayContainerView.getChildCount()) {
                break;
            }
            if (this.mPlayContainerView.getChildAt(i3) instanceof CgTextEditor) {
                this.mPlayContainerView.removeViewAt(i3);
                break;
            }
            i3++;
        }
        if (this.mActivity == null) {
            CGLog.w("setupCgTextEditor, mActivity is null!!!");
            return;
        }
        CgTextEditor cgTextEditor = new CgTextEditor(this.mActivity);
        this.mCgTextEditor = cgTextEditor;
        cgTextEditor.setBackgroundColor(ContextCompat.getColor(this.mActivity, 17170445));
        this.mCgTextEditor.setSingleLine(true);
        this.mCgTextEditor.setImeOptions(268435456);
        this.mCgTextEditor.setFocusable(true);
        this.mCgTextEditor.setFocusableInTouchMode(true);
        this.mCgTextEditor.setCursorVisible(false);
        this.mCgTextEditor.setHorizontallyScrolling(false);
        this.mCgTextEditor.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        this.mPlayContainerView.addView(this.mCgTextEditor, layoutParams);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgImeInputController
    public void closeImeInput() {
        this.mImeInputEventListener = null;
        this.mActivity = null;
        this.mPlayContainerView = null;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgImeInputController
    public void enableImeInput(boolean z16, Activity activity, FrameLayout frameLayout, GmCgImeInputController.GmCgImeInputEvtListener gmCgImeInputEvtListener) {
        try {
            this.mEnableImeInput = z16;
            this.mActivity = activity;
            this.mImeInputEventListener = gmCgImeInputEvtListener;
            this.mPlayContainerView = frameLayout;
            if (z16 && activity != null && frameLayout != null) {
                CGSystemUtil.getRootView(activity).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.gamematrix.gmcg.sdk.view.e
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        CGImeInputControllerInternal.this.lambda$enableImeInput$0();
                    }
                });
                setupCgTextEditor();
            }
        } catch (RuntimeException e16) {
            CGLog.w("failed to enableImeInput: " + e16.toString());
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgImeInputController
    public void onImeInputCloudFinish() {
        if (!CGGlbConfig.sEnableImeAntiFlash) {
            CGLog.i("anti ime flash is disabled");
            doImeInputCloudFinish();
            return;
        }
        CGLog.i("onImeInputCloudFinish mStartImeTs = " + this.mStartImeTs);
        if (this.mStartImeTs < 0) {
            doImeInputCloudFinish();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mStartImeTs;
        CGLog.i("onImeInputCloudFinish gapInputStart = " + currentTimeMillis + " THRESHOLD_IME_ANTI_FLASH = " + CGGlbConfig.THRESHOLD_IME_ANTI_FLASH);
        if (currentTimeMillis < CGGlbConfig.THRESHOLD_IME_ANTI_FLASH) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.removeCallbacks(this.mHideInputRunnable);
            this.mHandler.postDelayed(this.mHideInputRunnable, CGGlbConfig.THRESHOLD_IME_ANTI_FLASH);
            return;
        }
        doImeInputCloudFinish();
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgImeInputController
    public void onImeInputCloudStart() {
        if (this.mPlayContainerView == null) {
            CGLog.w("mPlayContainerView is null, onImeInputCloudStart is not work!");
            return;
        }
        if (this.mEnableImeInput && this.mCgTextEditor != null) {
            this.mStartImeTs = System.currentTimeMillis();
            CGLog.i("onImeInputCloudStart at " + this.mStartImeTs);
            this.mCgTextEditor.setVisibility(0);
            this.mCgTextEditor.requestFocus();
            Activity activity = this.mActivity;
            if (activity != null) {
                CGSystemUtil.forceShowInputMethod(activity, this.mCgTextEditor);
            }
        }
    }
}
