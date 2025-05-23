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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.PrivacyTextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes16.dex */
public class ActionSheetProfileEdit extends ReportDialog {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ActionSheetProfileEdit";
    private TranslateAnimation animation;
    private TextView cancelButton;
    private TextView confirmButton;
    protected ViewGroup mContainerView;
    private RelativeLayout mContentWrapper;
    protected Context mContext;
    private boolean mDismissFinish;
    protected Handler mHandler;
    private RelativeLayout mPrivacyWrapper;
    protected Resources mResources;
    protected View mRootView;
    private OnActionSheetListener onActionSheetListener;
    private OnPrivacyChangeListener onPrivacyChangeListener;
    private OnPrivacyListener onPrivacyListener;
    private int privacy;
    private TextView privacyText;
    private TextView title;

    /* loaded from: classes16.dex */
    public interface OnActionSheetListener {
        void onConfirm();

        void onDismiss();
    }

    /* loaded from: classes16.dex */
    public interface OnPrivacyChangeListener {
        void onChange(int i3);
    }

    /* loaded from: classes16.dex */
    public interface OnPrivacyListener {
        void onConfirm(int i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ActionSheetProfileEdit(Context context) {
        super(context, R.style.MenuDialogStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mDismissFinish = true;
        this.privacy = 0;
        this.mContext = context;
        this.mResources = context.getResources();
        this.mHandler = new Handler(Looper.getMainLooper());
        initWindow();
        initUI();
    }

    public static ActionSheetProfileEdit createActionSheet(Context context) {
        return new ActionSheetProfileEdit(context);
    }

    public static ActionSheetProfileEdit createLocationMenuDialog(Context context) {
        return createActionSheet(context, LayoutInflater.from(context).inflate(R.layout.f168845h14, (ViewGroup) null));
    }

    public static ActionSheetProfileEdit createSelectDialog(Context context) {
        return createActionSheet(context, LayoutInflater.from(context).inflate(R.layout.f168843h12, (ViewGroup) null));
    }

    private void initUI() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.gxd, (ViewGroup) null);
        this.mRootView = inflate;
        super.setContentView(inflate);
        this.mContentWrapper = (RelativeLayout) this.mRootView.findViewById(R.id.leh);
        this.mContainerView = (ViewGroup) this.mRootView.findViewById(R.id.b8q);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheetProfileEdit.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    if (ActionSheetProfileEdit.this.onActionSheetListener != null) {
                        ActionSheetProfileEdit.this.onActionSheetListener.onDismiss();
                    }
                    ActionSheetProfileEdit.this.dismiss();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        ViewGroup viewGroup = this.mContainerView;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(null);
        }
        TextView textView = (TextView) this.mRootView.findViewById(R.id.cancel);
        this.cancelButton = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheetProfileEdit.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    if (ActionSheetProfileEdit.this.onActionSheetListener != null) {
                        ActionSheetProfileEdit.this.onActionSheetListener.onDismiss();
                    }
                    ActionSheetProfileEdit.this.dismiss();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        TextView textView2 = (TextView) this.mRootView.findViewById(R.id.b7m);
        this.confirmButton = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheetProfileEdit.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    if (ActionSheetProfileEdit.this.onActionSheetListener != null) {
                        ActionSheetProfileEdit.this.onActionSheetListener.onConfirm();
                    }
                    if (ActionSheetProfileEdit.this.onPrivacyListener != null) {
                        ActionSheetProfileEdit.this.onPrivacyListener.onConfirm(ActionSheetProfileEdit.this.privacy);
                    }
                    ActionSheetProfileEdit.this.dismiss();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) this.mRootView.findViewById(R.id.f27710gz);
        this.mPrivacyWrapper = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheetProfileEdit.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (!u.a().b()) {
                    ActionSheetProfileEdit actionSheetProfileEdit = ActionSheetProfileEdit.this;
                    actionSheetProfileEdit.showPrivacyActionSheet(actionSheetProfileEdit.privacy);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.title = (TextView) this.mRootView.findViewById(R.id.title);
        this.privacyText = (TextView) this.mPrivacyWrapper.findViewById(R.id.f27670gv);
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

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (this.mDismissFinish) {
            this.mDismissFinish = false;
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionSheetProfileEdit.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ActionSheetProfileEdit actionSheetProfileEdit = ActionSheetProfileEdit.this;
                    if (actionSheetProfileEdit.mContainerView != null) {
                        actionSheetProfileEdit.animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, ActionSheetProfileEdit.this.mContainerView.getHeight());
                        ActionSheetProfileEdit.this.animation.setDuration(200L);
                        ActionSheetProfileEdit.this.animation.setFillAfter(true);
                        ActionSheetProfileEdit actionSheetProfileEdit2 = ActionSheetProfileEdit.this;
                        actionSheetProfileEdit2.mContainerView.startAnimation(actionSheetProfileEdit2.animation);
                        ActionSheetProfileEdit.this.animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.7.1
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
                                    ActionSheetProfileEdit.this.mDismissFinish = true;
                                    ActionSheetProfileEdit.super.dismiss();
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
                }
            }, 0L);
        }
    }

    public OnActionSheetListener getOnActionSheetListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (OnActionSheetListener) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.onActionSheetListener;
    }

    public OnPrivacyListener getOnPrivacyListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (OnPrivacyListener) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.onPrivacyListener;
    }

    @SuppressLint({"WrongConstant"})
    public void hideSystemStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
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

    public boolean isHide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.privacy == 2) {
            return true;
        }
        return false;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onBackPressed();
        OnActionSheetListener onActionSheetListener = this.onActionSheetListener;
        if (onActionSheetListener != null) {
            onActionSheetListener.onDismiss();
        }
        dismiss();
    }

    public void setContentWrapperView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else if (view != null) {
            this.mContentWrapper.removeAllViews();
            this.mContentWrapper.addView(view);
        }
    }

    public void setOnActionSheetListener(OnActionSheetListener onActionSheetListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onActionSheetListener);
        } else {
            this.onActionSheetListener = onActionSheetListener;
        }
    }

    public void setOnPrivacyChangeListener(OnPrivacyChangeListener onPrivacyChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) onPrivacyChangeListener);
        } else {
            this.onPrivacyChangeListener = onPrivacyChangeListener;
        }
    }

    public void setOnPrivacyListener(OnPrivacyListener onPrivacyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) onPrivacyListener);
        } else {
            this.onPrivacyListener = onPrivacyListener;
        }
    }

    public void setPrivacy(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        this.privacy = i3;
        this.privacyText.setText(PrivacyTextUtils.getPrivacyText(i3));
        OnPrivacyChangeListener onPrivacyChangeListener = this.onPrivacyChangeListener;
        if (onPrivacyChangeListener != null) {
            onPrivacyChangeListener.onChange(i3);
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.title.setText(str);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mRootView.setVisibility(4);
        super.show();
        this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionSheetProfileEdit.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ActionSheetProfileEdit.this.mRootView.setVisibility(0);
                ActionSheetProfileEdit actionSheetProfileEdit = ActionSheetProfileEdit.this;
                if (actionSheetProfileEdit.mContainerView != null) {
                    actionSheetProfileEdit.animation = new TranslateAnimation(0.0f, 0.0f, ActionSheetProfileEdit.this.mContainerView.getHeight(), 0.0f);
                    ActionSheetProfileEdit.this.animation.setFillEnabled(true);
                    ActionSheetProfileEdit.this.animation.setStartTime(300L);
                    ActionSheetProfileEdit.this.animation.setDuration(300L);
                    ActionSheetProfileEdit.this.mDismissFinish = true;
                    ActionSheetProfileEdit actionSheetProfileEdit2 = ActionSheetProfileEdit.this;
                    actionSheetProfileEdit2.mContainerView.startAnimation(actionSheetProfileEdit2.animation);
                }
            }
        }, 0L);
    }

    public void showPrivacyActionSheet(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        ActionSheetPrivacy createActionSheet = ActionSheetPrivacy.createActionSheet(this.mContext);
        createActionSheet.setOptionTick(i3);
        createActionSheet.setOnPrivacyListener(new OnPrivacyListener(createActionSheet) { // from class: com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.5
            static IPatchRedirector $redirector_;
            final /* synthetic */ ActionSheetPrivacy val$sheet;

            {
                this.val$sheet = createActionSheet;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionSheetProfileEdit.this, (Object) createActionSheet);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnPrivacyListener
            public void onConfirm(int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i16);
                    return;
                }
                if (i16 >= 0 && i16 < 3) {
                    ActionSheetProfileEdit.this.setPrivacy(i16);
                }
                this.val$sheet.dismiss();
                ActionSheetProfileEdit.this.show();
            }
        });
        createActionSheet.show();
        dismiss();
    }

    public static ActionSheetProfileEdit createActionSheet(Context context, View view) {
        ActionSheetProfileEdit createActionSheet = createActionSheet(context);
        createActionSheet.setContentWrapperView(view);
        return createActionSheet;
    }
}
