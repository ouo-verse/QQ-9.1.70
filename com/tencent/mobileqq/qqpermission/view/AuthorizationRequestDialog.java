package com.tencent.mobileqq.qqpermission.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog;
import com.tencent.mobileqq.qqpermission.base.AuthorizationMessage;
import com.tencent.mobileqq.qqpermission.base.MessageNotificationInfo;
import com.tencent.mobileqq.qqpermission.view.AuthorizationRequestAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AuthorizationRequestDialog extends ReportDialog {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AuthorizationRequestDialog";
    private static int mDialogHeight;
    private TranslateAnimation animation;
    private QUIButton mAllowBtn;
    private QUICheckBox mBottomCheckBox;
    private LinearLayout mBottomLayout;
    private TextView mBottomTv;
    private ViewGroup mContainerView;
    private ListView mDescriptionLv;
    private boolean mDismissFinish;
    private Handler mHandler;
    private ImageView mIconHint;
    private ImageView mIconIv;
    private TextView mIconTextTv;
    private TextView mMessageContentTv;
    private ImageView mMessageIconIv;
    private LinearLayout mMessageLayout;
    private TextView mMessageSupplementTv;
    private View.OnClickListener mOnAllowClickListener;
    private View.OnClickListener mOnRefuseClickListener;
    private QUIButton mRefuseBtn;
    private View mRootView;
    private TextView mSubHeadTv;
    private TextView mSupplementTv;
    private View.OnClickListener mSupplementTvClickListener;
    private TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthorizationRequestDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (AuthorizationRequestDialog.this.mOnRefuseClickListener != null) {
                    AuthorizationRequestDialog.this.mOnRefuseClickListener.onClick(view);
                }
                AuthorizationRequestDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthorizationRequestDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (AuthorizationRequestDialog.this.mOnAllowClickListener != null) {
                    AuthorizationRequestDialog.this.mOnAllowClickListener.onClick(view);
                }
                AuthorizationRequestDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthorizationRequestDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (AuthorizationRequestDialog.this.mSupplementTvClickListener != null) {
                AuthorizationRequestDialog.this.mSupplementTvClickListener.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class d implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthorizationRequestDialog.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (QQAuthorizationDialog.getListener() != null) {
                    QQAuthorizationDialog.getListener().bottomCheck(z16);
                }
                QLog.e(AuthorizationRequestDialog.TAG, 1, "mBottomCheckBox onCheckedChanged");
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f274334d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f274335e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f274336f;

        e(Context context, String str, String str2) {
            this.f274334d = context;
            this.f274335e = str;
            this.f274336f = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AuthorizationRequestDialog.this, context, str, str2);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AuthorizationHintDialog buildHintDialog = AuthorizationHintDialog.buildHintDialog(this.f274334d, this.f274335e, this.f274336f);
                if (QQAuthorizationDialog.getListener() != null) {
                    QQAuthorizationDialog.getListener().onHintDialogShow(buildHintDialog);
                }
                buildHintDialog.setDialogHeight(AuthorizationRequestDialog.mDialogHeight);
                try {
                    buildHintDialog.show();
                } catch (WindowManager.BadTokenException e16) {
                    QLog.e(AuthorizationRequestDialog.TAG, 1, "toShowHintDialog " + e16.getMessage());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class f implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthorizationRequestDialog.this);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                QLog.d(AuthorizationRequestDialog.TAG, 1, "mDescriptionLv item click pos: " + i3);
                ListAdapter adapter = AuthorizationRequestDialog.this.mDescriptionLv.getAdapter();
                if (adapter instanceof AuthorizationRequestAdapter) {
                    AuthorizationRequestAdapter authorizationRequestAdapter = (AuthorizationRequestAdapter) adapter;
                    AuthorizationMessage authorizationMessage = (AuthorizationMessage) authorizationRequestAdapter.getItem(i3);
                    AuthorizationRequestAdapter.AuthorizationRequestViewHolder authorizationRequestViewHolder = (AuthorizationRequestAdapter.AuthorizationRequestViewHolder) view.getTag();
                    int checkedPosition = authorizationRequestAdapter.getCheckedPosition();
                    if (i3 != checkedPosition) {
                        QLog.d(AuthorizationRequestDialog.TAG, 1, "replace check. click pos:" + i3 + " checked pos:" + checkedPosition);
                        AuthorizationRequestAdapter.AuthorizationRequestViewHolder authorizationRequestViewHolder2 = (AuthorizationRequestAdapter.AuthorizationRequestViewHolder) AuthorizationRequestDialog.this.mDescriptionLv.getChildAt(checkedPosition - AuthorizationRequestDialog.this.mDescriptionLv.getFirstVisiblePosition()).getTag();
                        AuthorizationMessage authorizationMessage2 = (AuthorizationMessage) authorizationRequestAdapter.getItem(checkedPosition);
                        authorizationRequestViewHolder2.mCheckIv.setVisibility(8);
                        authorizationRequestViewHolder.mCheckIv.setVisibility(0);
                        authorizationRequestAdapter.setCheckedPosition(i3);
                        authorizationMessage2.isChecked = false;
                        authorizationMessage.isChecked = true;
                    }
                }
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32208);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            mDialogHeight = 0;
        }
    }

    public AuthorizationRequestDialog(@NonNull Context context) {
        this(context, R.style.f243861y);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public static int getDialogHeight() {
        return mDialogHeight;
    }

    private void initViews() {
        this.mContainerView = (ViewGroup) findViewById(R.id.sye);
        this.mIconIv = (ImageView) findViewById(R.id.syc);
        this.mIconTextTv = (TextView) findViewById(R.id.syj);
        this.mIconHint = (ImageView) findViewById(R.id.syf);
        this.mTitleTv = (TextView) findViewById(R.id.syu);
        this.mSubHeadTv = (TextView) findViewById(R.id.sys);
        this.mSupplementTv = (TextView) findViewById(R.id.syt);
        this.mMessageIconIv = (ImageView) findViewById(R.id.syp);
        this.mMessageContentTv = (TextView) findViewById(R.id.syo);
        this.mMessageSupplementTv = (TextView) findViewById(R.id.syq);
        this.mMessageLayout = (LinearLayout) findViewById(R.id.syn);
        this.mBottomLayout = (LinearLayout) findViewById(R.id.sya);
        this.mBottomCheckBox = (QUICheckBox) findViewById(R.id.sy_);
        this.mBottomTv = (TextView) findViewById(R.id.syb);
        this.mRefuseBtn = (QUIButton) findViewById(R.id.syr);
        this.mAllowBtn = (QUIButton) findViewById(R.id.sy9);
        this.mRefuseBtn.setOnClickListener(new a());
        this.mAllowBtn.setOnClickListener(new b());
        this.mSupplementTv.setOnClickListener(new c());
        this.mDescriptionLv = (ListView) findViewById(R.id.syk);
    }

    public void disableAllowButton() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.mAllowBtn.setEnabled(false);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.mDismissFinish) {
            this.mDismissFinish = false;
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqpermission.view.AuthorizationRequestDialog.5
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qqpermission.view.AuthorizationRequestDialog$5$a */
                /* loaded from: classes17.dex */
                class a implements Animation.AnimationListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                        } else {
                            AuthorizationRequestDialog.this.superDismiss();
                            AuthorizationRequestDialog.this.mDismissFinish = true;
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                        }
                    }
                }

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AuthorizationRequestDialog.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AuthorizationRequestDialog.this.animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, AuthorizationRequestDialog.this.mContainerView.getHeight());
                    he0.b.l(AuthorizationRequestDialog.this.animation, R.anim.f154986ut);
                    AuthorizationRequestDialog.this.animation.setFillAfter(true);
                    AuthorizationRequestDialog.this.mContainerView.startAnimation(AuthorizationRequestDialog.this.animation);
                    AuthorizationRequestDialog.this.animation.setAnimationListener(new a());
                }
            }, 0L);
        }
    }

    public void enableAllowButton() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.mAllowBtn.setEnabled(true);
        }
    }

    public ListAdapter getListAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (ListAdapter) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.mDescriptionLv.getAdapter();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.ListAdapter] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.tencent.mobileqq.qqpermission.view.AuthorizationRequestAdapter] */
    public List<Boolean> getListCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (List) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        if (this.mDescriptionLv.getVisibility() == 8) {
            return null;
        }
        ?? listAdapter = getListAdapter();
        ArrayList arrayList = new ArrayList();
        if (listAdapter instanceof AuthorizationRequestAdapter) {
            listAdapter = (AuthorizationRequestAdapter) listAdapter;
            Iterator<AuthorizationMessage> it = listAdapter.getResponsesInfoList().iterator();
            while (it.hasNext()) {
                arrayList.add(Boolean.valueOf(it.next().isChecked));
            }
        }
        if (listAdapter instanceof MessageNotificationAdapter) {
            Iterator<MessageNotificationInfo> it5 = ((MessageNotificationAdapter) listAdapter).getMessageNotificationInfoList().iterator();
            while (it5.hasNext()) {
                arrayList.add(Boolean.valueOf(it5.next().isChecked));
            }
        }
        return arrayList;
    }

    public void hideDescriptionMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        this.mMessageIconIv.setVisibility(8);
        this.mMessageContentTv.setVisibility(8);
        this.mMessageSupplementTv.setVisibility(8);
    }

    public void hideHintImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            this.mIconHint.setVisibility(8);
        }
    }

    public void hideListView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            this.mDescriptionLv.setVisibility(8);
        }
    }

    public void hideMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.mMessageLayout.setVisibility(8);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        window.setAttributes(attributes);
    }

    public void setAllowClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onClickListener);
        } else {
            this.mOnAllowClickListener = onClickListener;
        }
    }

    public int setAndGetDialogHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            mDialogHeight = decorView.getHeight();
        }
        return mDialogHeight;
    }

    public void setBusinessIcon(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            this.mIconIv.setImageResource(i3);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
    }

    public void setIconText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.mIconTextTv.setText(str);
        }
    }

    public void setListViewCheckedListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            this.mDescriptionLv.setOnItemClickListener(new f());
        }
    }

    public void setMessageContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.mMessageContentTv.setText(str);
        }
    }

    public void setMessageIcon(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            this.mMessageIconIv.setImageResource(i3);
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
    }

    public void setMessageSupplement(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            this.mMessageSupplementTv.setText(str);
        }
    }

    public void setRefuseClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onClickListener);
        } else {
            this.mOnRefuseClickListener = onClickListener;
        }
    }

    public void setRequestTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.mTitleTv.setText(str);
        }
    }

    public void setSubHeadTv(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            this.mSubHeadTv.setVisibility(0);
            this.mSubHeadTv.setText(str);
        }
    }

    public void setSupplementTv(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.mSupplementTv.setText(str);
            this.mSupplementTv.setVisibility(0);
        }
    }

    public void setSupplementTvClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onClickListener);
        } else {
            this.mSupplementTvClickListener = onClickListener;
        }
    }

    public void setTextColorSupplementTv(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.mSupplementTv.setTextColor(i3);
        }
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
        this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqpermission.view.AuthorizationRequestDialog.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AuthorizationRequestDialog.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                AuthorizationRequestDialog.this.mRootView.setVisibility(0);
                AuthorizationRequestDialog.this.animation = new TranslateAnimation(0.0f, 0.0f, AuthorizationRequestDialog.this.mContainerView.getHeight(), 0.0f);
                AuthorizationRequestDialog.this.animation.setFillEnabled(true);
                AuthorizationRequestDialog.this.animation.setStartTime(300L);
                he0.b.l(AuthorizationRequestDialog.this.animation, R.anim.f154974uh);
                AuthorizationRequestDialog.this.mDismissFinish = true;
                AuthorizationRequestDialog.this.mContainerView.startAnimation(AuthorizationRequestDialog.this.animation);
            }
        }, 0L);
    }

    public void showBottomCheck(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Boolean.valueOf(z16), str);
            return;
        }
        this.mBottomLayout.setVisibility(0);
        this.mBottomCheckBox.setChecked(z16);
        this.mBottomTv.setText(str);
        this.mBottomCheckBox.setOnCheckedChangeListener(new d());
    }

    public void showHintDialog(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, context, str, str2);
        } else {
            this.mIconHint.setVisibility(0);
            this.mIconHint.setOnClickListener(new e(context, str, str2));
        }
    }

    public void showListView(ListAdapter listAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) listAdapter);
        } else {
            this.mDescriptionLv.setVisibility(0);
            this.mDescriptionLv.setAdapter(listAdapter);
        }
    }

    public void superDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            super.dismiss();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            sy3.a.a(this);
            throw th5;
        }
        sy3.a.a(this);
    }

    public AuthorizationRequestDialog(@NonNull Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            return;
        }
        this.mDismissFinish = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168787gw1, (ViewGroup) null);
        this.mRootView = inflate;
        super.setContentView(inflate);
        initViews();
    }

    public void setBusinessIcon(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.mIconIv.setImageDrawable(drawable);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) drawable);
        }
    }

    public void setMessageIcon(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            this.mMessageIconIv.setImageDrawable(drawable);
        } else {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) drawable);
        }
    }
}
