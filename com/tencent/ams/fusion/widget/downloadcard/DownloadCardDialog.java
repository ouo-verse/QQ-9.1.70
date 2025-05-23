package com.tencent.ams.fusion.widget.downloadcard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadCardDialog extends FrameLayout implements DialogInterface, IDownloadCardView {
    static IPatchRedirector $redirector_ = null;
    private static final int DIALOG_HEIGHT_DP = 400;
    private static final String TAG = "DownloadCardDialog";
    private boolean mCancelable;
    private boolean mIsCanceledOnTouchOutside;
    private DownloadCardListener mListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private final View mShadowView;
    protected boolean mShowing;

    @NonNull
    private final DownloadCardView mView;
    private WindowManager mWindowManager;

    public DownloadCardDialog(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mIsCanceledOnTouchOutside = true;
        this.mCancelable = true;
        this.mShowing = false;
        this.mShadowView = new View(context);
        initBgShadowView(context);
        DownloadCardView downloadCardView = new DownloadCardView(context);
        this.mView = downloadCardView;
        initCardView();
        this.mWindowManager = getWindowManager(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) Utils.dp2px(400.0f));
        layoutParams.gravity = 80;
        addView(downloadCardView, layoutParams);
    }

    private WindowManager getWindowManager(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    private WindowManager.LayoutParams getWindowParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 99, 256, -2);
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        return layoutParams;
    }

    private void initBgShadowView(Context context) {
        int i3;
        View view = this.mShadowView;
        if (ViewUtils.isDarkMode()) {
            i3 = -1090519040;
        } else {
            i3 = TextNode.DEFAULT_TEXT_SHADOW_COLOR;
        }
        view.setBackgroundColor(i3);
        this.mShadowView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardDialog.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadCardDialog.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2);
                } else if (DownloadCardDialog.this.mIsCanceledOnTouchOutside) {
                    DownloadCardDialog.this.dismiss();
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        addView(this.mShadowView, new FrameLayout.LayoutParams(-1, -1));
    }

    private void initCardView() {
        this.mView.setBackground(ViewUtils.createCornerBackground());
        this.mView.setListener(new DownloadCardListener() { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardDialog.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadCardDialog.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onAgreementWebViewDismiss() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    iPatchRedirector.redirect((short) 10, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onAgreementWebViewDismiss();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onAgreementWebViewShow() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    iPatchRedirector.redirect((short) 9, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onAgreementWebViewShow();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onCancelViewCancelButtonClick() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                    iPatchRedirector.redirect((short) 12, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onCancelViewCancelButtonClick();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onCancelViewConfirmButtonClick() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                    iPatchRedirector.redirect((short) 13, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onCancelViewConfirmButtonClick();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onCancelViewShow() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    iPatchRedirector.redirect((short) 11, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onCancelViewShow();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onFeatureListWebViewDismiss() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onFeatureListWebViewDismiss();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onFeatureListWebViewShow() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onFeatureListWebViewShow();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onOpenAppClick() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                    iPatchRedirector.redirect((short) 17, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onOpenAppClick();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onPermissionWebViewDismiss() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    iPatchRedirector.redirect((short) 8, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onPermissionWebViewShow();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onPermissionWebViewShow() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onPermissionWebViewShow();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onResumeDownloadClick() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                    iPatchRedirector.redirect((short) 15, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onResumeDownloadClick();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onStartDownloadClick() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                    iPatchRedirector.redirect((short) 14, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onStartDownloadClick();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onStartInstallClick() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                    iPatchRedirector.redirect((short) 16, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onStartInstallClick();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onViewClick(int i3, float f16, float f17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17));
                    return;
                }
                if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onViewClick(i3, f16, f17);
                }
                if (i3 == 7) {
                    DownloadCardDialog.this.dismiss();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onViewDismiss() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onViewDismiss();
                }
            }

            @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadCardListener
            public void onViewShow() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (DownloadCardDialog.this.mListener != null) {
                    DownloadCardDialog.this.mListener.onViewShow();
                }
            }
        });
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            dismiss();
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.mView.destroy();
        }
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.mShowing) {
            this.mShowing = false;
            hideCardView();
            hideShadowView();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) keyEvent)).booleanValue();
        }
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && this.mCancelable) {
            dismiss();
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideCardView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "translationY", 0.0f, Utils.dp2px(400.0f));
        try {
            ofFloat.setInterpolator(new PathInterpolator(0.39f, 0.0f, 0.95f, 0.44f));
        } catch (Throwable unused) {
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, c.f123400v, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardDialog.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DownloadCardDialog.this);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animator);
                    return;
                }
                DownloadCardDialog.this.mView.hide();
                if (DownloadCardDialog.this.mWindowManager != null) {
                    try {
                        DownloadCardDialog.this.mWindowManager.removeView(DownloadCardDialog.this);
                    } catch (Throwable unused2) {
                    }
                }
                DownloadCardDialog.this.mWindowManager = null;
                DownloadCardDialog.this.mListener = null;
                if (DownloadCardDialog.this.mOnDismissListener != null) {
                    DownloadCardDialog.this.mOnDismissListener.onDismiss(DownloadCardDialog.this);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) animator);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideShadowView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mShadowView, c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    public void setCancelable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.mCancelable = z16;
        }
    }

    public void setCanceledOnTouchOutside(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.mIsCanceledOnTouchOutside = z16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.IDownloadCardView
    public void setDownloadHandler(DownloadHandler downloadHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) downloadHandler);
        } else {
            this.mView.setDownloadHandler(downloadHandler);
        }
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.IDownloadCardView
    public void setDownloadInfo(DownloadInfo downloadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) downloadInfo);
        } else {
            this.mView.setDownloadInfo(downloadInfo);
        }
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.IDownloadCardView
    public void setListener(DownloadCardListener downloadCardListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) downloadCardListener);
        } else {
            this.mListener = downloadCardListener;
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) onDismissListener);
        } else {
            this.mOnDismissListener = onDismissListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.IDownloadCardView
    public void setThemeColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mView.setThemeColor(i3);
        }
    }

    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.mWindowManager != null) {
            try {
                this.mWindowManager.addView(this, getWindowParams());
            } catch (Throwable th5) {
                Logger.e(TAG, th5);
            }
            showCardView();
            showShadowView();
            this.mShowing = true;
            return;
        }
        Logger.w(TAG, "show failed: windowManager is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showCardView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "translationY", Utils.dp2px(400.0f), 0.0f);
        try {
            ofFloat.setInterpolator(new PathInterpolator(0.04f, 0.75f, 0.63f, 1.0f));
        } catch (Throwable unused) {
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, c.f123400v, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(270L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.ams.fusion.widget.downloadcard.DownloadCardDialog.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DownloadCardDialog.this);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animator);
                } else {
                    DownloadCardDialog.this.mView.setVisibility(0);
                    DownloadCardDialog.this.mView.show();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) animator);
                } else {
                    DownloadCardDialog.this.mView.setVisibility(4);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showShadowView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mShadowView, c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(270L);
        ofFloat.start();
    }
}
