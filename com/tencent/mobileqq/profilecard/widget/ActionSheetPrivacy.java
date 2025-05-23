package com.tencent.mobileqq.profilecard.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.PrivacyTextUtils;
import com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes16.dex */
public class ActionSheetPrivacy extends ReportDialog {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ActionSheetPrivacy";
    private TranslateAnimation animation;
    protected ViewGroup mContainerView;
    protected Context mContext;
    private boolean mDismissFinish;
    protected Handler mHandler;
    protected Resources mResources;
    protected View mRootView;
    private ActionSheetProfileEdit.OnPrivacyListener onPrivacyListener;
    private TextView option1Text;
    private ImageView option1Tick;
    private TextView option2Text;
    private ImageView option2Tick;
    private TextView option3Text;
    private ImageView option3Tick;

    protected ActionSheetPrivacy(Context context) {
        super(context, R.style.MenuDialogStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mDismissFinish = true;
        this.mContext = context;
        this.mResources = context.getResources();
        this.mHandler = new Handler(Looper.getMainLooper());
        initWindow();
        initUI();
    }

    public static ActionSheetPrivacy createActionSheet(Context context) {
        return new ActionSheetPrivacy(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClick(int i3) {
        if (u.a().b()) {
            return;
        }
        updateContentDescription(i3);
        ActionSheetProfileEdit.OnPrivacyListener onPrivacyListener = this.onPrivacyListener;
        if (onPrivacyListener != null) {
            onPrivacyListener.onConfirm(i3);
        }
        dismiss();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.gxc, (ViewGroup) null);
        this.mRootView = inflate;
        super.setContentView(inflate);
        this.mContainerView = (ViewGroup) this.mRootView.findViewById(R.id.b8q);
        RelativeLayout relativeLayout = (RelativeLayout) this.mRootView.findViewById(R.id.f212000d);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.mRootView.findViewById(R.id.f212300g);
        RelativeLayout relativeLayout3 = (RelativeLayout) this.mRootView.findViewById(R.id.f212600j);
        RelativeLayout relativeLayout4 = (RelativeLayout) this.mRootView.findViewById(R.id.cancel);
        this.option1Text = (TextView) relativeLayout.findViewById(R.id.f212100e);
        this.option2Text = (TextView) relativeLayout2.findViewById(R.id.f212400h);
        this.option3Text = (TextView) relativeLayout3.findViewById(R.id.f212700k);
        this.option1Text.setText(PrivacyTextUtils.getPrivacyText(0));
        this.option2Text.setText(PrivacyTextUtils.getPrivacyText(1));
        this.option3Text.setText(PrivacyTextUtils.getPrivacyText(2));
        this.option1Tick = (ImageView) relativeLayout.findViewById(R.id.f212200f);
        this.option2Tick = (ImageView) relativeLayout2.findViewById(R.id.f212500i);
        this.option3Tick = (ImageView) relativeLayout3.findViewById(R.id.f212800l);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetPrivacy.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheetPrivacy.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ActionSheetPrivacy.this.handleClick(3);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mContainerView.setOnClickListener(null);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetPrivacy.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheetPrivacy.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ActionSheetPrivacy.this.handleClick(0);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetPrivacy.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheetPrivacy.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ActionSheetPrivacy.this.handleClick(1);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetPrivacy.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheetPrivacy.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ActionSheetPrivacy.this.handleClick(2);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        relativeLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetPrivacy.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheetPrivacy.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ActionSheetPrivacy.this.handleClick(3);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    private void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void updateContentDescription(int i3) {
        this.option1Text.setContentDescription(PrivacyTextUtils.DESCRIPTION_VISIBLE_STATE_ALL);
        this.option2Tick.setContentDescription(PrivacyTextUtils.DESCRIPTION_VISIBLE_STATE_ONLY_FRIEND);
        this.option3Tick.setContentDescription(PrivacyTextUtils.DESCRIPTION_VISIBLE_STATE_ALL_NOT);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.option3Tick.setContentDescription("\u6240\u6709\u4eba\u4e0d\u53ef\u89c1\uff0c\u5df2\u9009\u4e2d");
                    return;
                }
                return;
            }
            this.option2Tick.setContentDescription("\u4ec5\u597d\u53cb\u53ef\u89c1\uff0c\u5df2\u9009\u4e2d");
            return;
        }
        this.option1Text.setContentDescription("\u6240\u6709\u4eba\u53ef\u89c1\uff0c\u5df2\u9009\u4e2d");
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.mDismissFinish) {
            this.mDismissFinish = false;
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetPrivacy.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionSheetPrivacy.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ActionSheetPrivacy.this.animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, ActionSheetPrivacy.this.mContainerView.getHeight());
                    ActionSheetPrivacy.this.animation.setDuration(200L);
                    ActionSheetPrivacy.this.animation.setFillAfter(true);
                    ActionSheetPrivacy actionSheetPrivacy = ActionSheetPrivacy.this;
                    actionSheetPrivacy.mContainerView.startAnimation(actionSheetPrivacy.animation);
                    ActionSheetPrivacy.this.animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetPrivacy.7.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ActionSheetPrivacy.this.mDismissFinish = true;
                                ActionSheetPrivacy.super.dismiss();
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this, (Object) animation);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 3)) {
                                iPatchRedirector3.redirect((short) 3, (Object) this, (Object) animation);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 4)) {
                                iPatchRedirector3.redirect((short) 4, (Object) this, (Object) animation);
                            }
                        }
                    });
                }
            }, 0L);
        }
    }

    @SuppressLint({"WrongConstant"})
    public void hideSystemStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.addFlags(1024);
        window.addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onBackPressed();
            handleClick(3);
        }
    }

    public void setBackgroundColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mRootView.setBackgroundColor(i3);
        }
    }

    public void setOnPrivacyListener(ActionSheetProfileEdit.OnPrivacyListener onPrivacyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onPrivacyListener);
        } else {
            this.onPrivacyListener = onPrivacyListener;
        }
    }

    public void setOptionTick(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        this.option1Tick.setVisibility(8);
        this.option2Tick.setVisibility(8);
        this.option3Tick.setVisibility(8);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.option3Tick.setVisibility(0);
                }
            } else {
                this.option2Tick.setVisibility(0);
            }
        } else {
            this.option1Tick.setVisibility(0);
        }
        updateContentDescription(i3);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mRootView.setVisibility(4);
        super.show();
        this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetPrivacy.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionSheetPrivacy.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ActionSheetPrivacy.this.mRootView.setVisibility(0);
                ActionSheetPrivacy.this.animation = new TranslateAnimation(0.0f, 0.0f, ActionSheetPrivacy.this.mContainerView.getHeight(), 0.0f);
                ActionSheetPrivacy.this.animation.setFillEnabled(true);
                ActionSheetPrivacy.this.animation.setStartTime(300L);
                ActionSheetPrivacy.this.animation.setDuration(300L);
                ActionSheetPrivacy.this.mDismissFinish = true;
                ActionSheetPrivacy actionSheetPrivacy = ActionSheetPrivacy.this;
                actionSheetPrivacy.mContainerView.startAnimation(actionSheetPrivacy.animation);
            }
        }, 0L);
    }
}
