package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.abtest.api.IAddFriendTabApi;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.participle.api.IParticipleUIApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqperf.opt.suspendthread.SuspendThreadManager;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MainService;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AutoRemarkActivity extends DialogBaseActivity implements View.OnClickListener, TextWatcher {
    static IPatchRedirector $redirector_;
    private ViewTreeObserver.OnGlobalLayoutListener A0;

    /* renamed from: a0, reason: collision with root package name */
    int f175003a0;

    /* renamed from: b0, reason: collision with root package name */
    String f175004b0;

    /* renamed from: c0, reason: collision with root package name */
    int f175005c0;

    /* renamed from: d0, reason: collision with root package name */
    int f175006d0;

    /* renamed from: e0, reason: collision with root package name */
    boolean f175007e0;

    /* renamed from: f0, reason: collision with root package name */
    Bundle f175008f0;

    /* renamed from: g0, reason: collision with root package name */
    int f175009g0;

    /* renamed from: h0, reason: collision with root package name */
    private Button f175010h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f175011i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f175012j0;

    /* renamed from: k0, reason: collision with root package name */
    EditText f175013k0;

    /* renamed from: l0, reason: collision with root package name */
    TextView f175014l0;

    /* renamed from: m0, reason: collision with root package name */
    BounceScrollView f175015m0;

    /* renamed from: n0, reason: collision with root package name */
    private RelativeLayout f175016n0;

    /* renamed from: o0, reason: collision with root package name */
    private ImageView f175017o0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f175018p0;

    /* renamed from: q0, reason: collision with root package name */
    private TextView f175019q0;

    /* renamed from: r0, reason: collision with root package name */
    FriendListHandler f175020r0;

    /* renamed from: s0, reason: collision with root package name */
    private e f175021s0;

    /* renamed from: t0, reason: collision with root package name */
    Dialog f175022t0;

    /* renamed from: u0, reason: collision with root package name */
    boolean f175023u0;

    /* renamed from: v0, reason: collision with root package name */
    private LinearLayout f175024v0;

    /* renamed from: w0, reason: collision with root package name */
    FrameLayout f175025w0;

    /* renamed from: x0, reason: collision with root package name */
    private Boolean f175026x0;

    /* renamed from: y0, reason: collision with root package name */
    private Boolean f175027y0;

    /* renamed from: z0, reason: collision with root package name */
    private com.tencent.mobileqq.friend.observer.a f175028z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AutoRemarkActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if ((motionEvent.getAction() & 255) == 2) {
                InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(AutoRemarkActivity.this.getWindow().getDecorView().getWindowToken(), 0);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AutoRemarkActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Dialog dialog = AutoRemarkActivity.this.f175022t0;
                if (dialog != null && dialog.isShowing() && AutoRemarkActivity.this.f175022t0.getWindow() != null) {
                    try {
                        AutoRemarkActivity.this.f175022t0.dismiss();
                    } catch (Throwable unused) {
                    }
                    AutoRemarkActivity.this.f175022t0 = null;
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AutoRemarkActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onGetAutoInfo(boolean z16, String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3));
                return;
            }
            if (!TextUtils.equals(AutoRemarkActivity.this.f175004b0, str)) {
                return;
            }
            String b16 = com.tencent.mobileqq.util.ay.b(str);
            if (!TextUtils.isEmpty(b16)) {
                str2 = b16;
            }
            if (z16) {
                if (!((IAddFriendApi) QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(AutoRemarkActivity.this.f175005c0) && !AutoRemarkActivity.this.f175023u0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AutoRemarkActivity", 2, "onGetAutoInfo remark = " + com.tencent.qqnt.kernel.nativeinterface.cq.w(str2, 0));
                    }
                    AutoRemarkActivity.this.f175013k0.setText(str2);
                    AutoRemarkActivity.this.f175013k0.setTextColor(Color.parseColor("#999999"));
                    try {
                        EditText editText = AutoRemarkActivity.this.f175013k0;
                        editText.setSelection(editText.getText().length());
                    } catch (IndexOutOfBoundsException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AutoRemarkActivity", 2, "onGetAutoInfo | IndexOutOfBoundsException");
                        }
                    }
                }
                AutoRemarkActivity autoRemarkActivity = AutoRemarkActivity.this;
                autoRemarkActivity.f175006d0 = i3;
                TextView textView = autoRemarkActivity.f175014l0;
                IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
                AutoRemarkActivity autoRemarkActivity2 = AutoRemarkActivity.this;
                textView.setText(iAddFriendApi.getGroupName(autoRemarkActivity2.app, autoRemarkActivity2.f175006d0));
                return;
            }
            AutoRemarkActivity autoRemarkActivity3 = AutoRemarkActivity.this;
            autoRemarkActivity3.f175006d0 = 0;
            TextView textView2 = autoRemarkActivity3.f175014l0;
            IAddFriendApi iAddFriendApi2 = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
            AutoRemarkActivity autoRemarkActivity4 = AutoRemarkActivity.this;
            textView2.setText(iAddFriendApi2.getGroupName(autoRemarkActivity4.app, autoRemarkActivity4.f175006d0));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
                return;
            }
            if (!TextUtils.equals(str, AutoRemarkActivity.this.f175004b0)) {
                return;
            }
            if (!z16) {
                AutoRemarkActivity.this.dismissProgressDialog();
                AutoRemarkActivity autoRemarkActivity = AutoRemarkActivity.this;
                autoRemarkActivity.Z2(autoRemarkActivity.getString(R.string.f173065h22));
                if (QLog.isColorLevel()) {
                    QLog.d("AutoRemarkActivity", 2, "add friend response error and isSuccuss = NO");
                    return;
                }
                return;
            }
            if (bundle.getInt(QzoneIPCModule.RESULT_CODE) != 0) {
                AutoRemarkActivity.this.dismissProgressDialog();
                String string = bundle.getString("ErrorString");
                if (QLog.isColorLevel()) {
                    QLog.d("AutoRemarkActivity", 2, "add friend response error and ErroString = " + string);
                }
                if (TextUtils.isEmpty(string)) {
                    string = AutoRemarkActivity.this.getString(R.string.f173065h22);
                }
                AutoRemarkActivity.this.Z2(string);
                return;
            }
            int i3 = bundle.getInt("friend_setting");
            bundle.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            if (i3 == 0 || i3 == 100) {
                AutoRemarkActivity.this.dismissProgressDialog();
                QQToast.makeText(AutoRemarkActivity.this, 2, R.string.f170041dp, 0).show(AutoRemarkActivity.this.getTitleBarHeight());
                AutoRemarkActivity.this.U2();
            } else {
                AutoRemarkActivity.this.dismissProgressDialog();
                QQToast.makeText(AutoRemarkActivity.this, 2, R.string.heo, 0).show(AutoRemarkActivity.this.getTitleBarHeight());
                AutoRemarkActivity.this.U2();
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onUpdateSetFriendPermission(boolean z16, HashMap<String, Integer> hashMap, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), hashMap, Integer.valueOf(i3));
                return;
            }
            if (z16 && hashMap != null && QLog.isColorLevel()) {
                QLog.d("AutoRemarkActivity", 2, "uin: " + AutoRemarkActivity.this.f175004b0 + "| Qzone Permission is " + i3 + " result:" + hashMap.get(AutoRemarkActivity.this.f175004b0));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AutoRemarkActivity.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Rect rect = new Rect();
            AutoRemarkActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            DisplayMetrics displayMetrics = AutoRemarkActivity.this.getResources().getDisplayMetrics();
            int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            if (max - (rect.bottom - rect.top) > max / 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            View currentFocus = AutoRemarkActivity.this.getCurrentFocus();
            if (!z16) {
                if (currentFocus != null && (currentFocus instanceof EditText)) {
                    ((EditText) currentFocus).setCursorVisible(false);
                    ((ClearableEditText) currentFocus).setClearButtonVisible(false);
                    return;
                }
                return;
            }
            if (currentFocus != null && (currentFocus instanceof EditText)) {
                ((EditText) currentFocus).setCursorVisible(true);
                if (AutoRemarkActivity.this.f175013k0.getText().toString().length() > 0) {
                    ((ClearableEditText) currentFocus).setClearButtonVisible(true);
                }
                if (QQTheme.isNowThemeIsNight()) {
                    AutoRemarkActivity.this.f175013k0.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    AutoRemarkActivity.this.f175013k0.setTextColor(Color.parseColor("#000000"));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class e extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AutoRemarkActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetComment(boolean z16, String str, String str2, byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, Byte.valueOf(b16));
                return;
            }
            AutoRemarkActivity autoRemarkActivity = AutoRemarkActivity.this;
            if (autoRemarkActivity.f175003a0 == 1 && TextUtils.equals(str, autoRemarkActivity.f175004b0)) {
                AutoRemarkActivity.this.getIntent().getLongExtra("k_msg_key", 0L);
                if (z16 && NetworkUtil.isNetSupport(AutoRemarkActivity.this)) {
                    AutoRemarkActivity autoRemarkActivity2 = AutoRemarkActivity.this;
                    autoRemarkActivity2.f175009g0 = 0;
                    autoRemarkActivity2.f175004b0 = str;
                    autoRemarkActivity2.f175020r0.moveFriendToGroup(str, (byte) autoRemarkActivity2.f175006d0, (byte) 0);
                    return;
                }
                AutoRemarkActivity autoRemarkActivity3 = AutoRemarkActivity.this;
                if (autoRemarkActivity3.f175009g0 == 2 || !NetworkUtil.isNetSupport(autoRemarkActivity3)) {
                    AutoRemarkActivity.this.dismissProgressDialog();
                    AutoRemarkActivity autoRemarkActivity4 = AutoRemarkActivity.this;
                    autoRemarkActivity4.Z2(autoRemarkActivity4.getString(R.string.f173065h22));
                } else {
                    AutoRemarkActivity autoRemarkActivity5 = AutoRemarkActivity.this;
                    autoRemarkActivity5.f175009g0++;
                    autoRemarkActivity5.f175020r0.setFriendComment(str, autoRemarkActivity5.f175013k0.getText().toString(), false);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateMoveGroup(String str, byte b16, byte b17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Byte.valueOf(b16), Byte.valueOf(b17));
                return;
            }
            AutoRemarkActivity autoRemarkActivity = AutoRemarkActivity.this;
            if (autoRemarkActivity.f175003a0 == 1) {
                if (str == null) {
                    autoRemarkActivity.dismissProgressDialog();
                    AutoRemarkActivity autoRemarkActivity2 = AutoRemarkActivity.this;
                    autoRemarkActivity2.Z2(autoRemarkActivity2.getString(R.string.f173065h22));
                } else if (str.equals(autoRemarkActivity.f175004b0)) {
                    AutoRemarkActivity.this.Q2();
                    if (AutoRemarkActivity.this.f175026x0.booleanValue()) {
                        AutoRemarkActivity.this.setResult(-1);
                        AutoRemarkActivity.this.finish();
                    } else {
                        AutoRemarkActivity.this.T2();
                        AutoRemarkActivity.this.setResult(-1);
                        AutoRemarkActivity.this.finish();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Activity> f175034d;

        /* renamed from: e, reason: collision with root package name */
        private String f175035e;

        public f(WeakReference<Activity> weakReference, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference, (Object) str);
            } else {
                this.f175034d = weakReference;
                this.f175035e = str;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                WeakReference<Activity> weakReference = this.f175034d;
                if (weakReference != null && (activity = weakReference.get()) != null) {
                    Intent intent = new Intent();
                    intent.putExtra(IParticipleUIApi.ORIGIN_WORDS, this.f175035e);
                    intent.putExtra("max_length", 32);
                    ((IParticipleUIApi) QRoute.api(IParticipleUIApi.class)).startFragmentForResult(activity, 1002, intent);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public AutoRemarkActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175006d0 = 0;
        this.f175011i0 = null;
        this.f175012j0 = null;
        this.f175013k0 = null;
        this.f175014l0 = null;
        this.f175021s0 = new e();
        this.f175023u0 = false;
        Boolean bool = Boolean.FALSE;
        this.f175026x0 = bool;
        this.f175027y0 = bool;
        this.f175028z0 = new c();
        this.A0 = new d();
    }

    private void V2() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.AutoRemarkActivity.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AutoRemarkActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (!TextUtils.isEmpty(AutoRemarkActivity.this.f175004b0) && ((FriendsManager) AutoRemarkActivity.this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(AutoRemarkActivity.this.f175004b0) == null) {
                    ((FriendListHandler) AutoRemarkActivity.this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(AutoRemarkActivity.this.f175004b0);
                }
            }
        });
    }

    private void W2() {
        this.f175019q0 = (TextView) findViewById(R.id.f82504h2);
        ArrayList arrayList = new ArrayList();
        String string = this.f175008f0.getString("verfy_msg");
        String string2 = getString(R.string.ykf);
        if (!TextUtils.isEmpty(string) && !"\u8bf7\u6c42\u52a0\u4e3a\u597d\u53cb".equals(string) && !"\u5df2\u6dfb\u52a0\u4f60\u4e3a\u597d\u53cb".equals(string)) {
            this.f175019q0.setVisibility(0);
            arrayList.add(new RichTextHelper.RichTextData(string2, (View.OnClickListener) new f(new WeakReference(this), string), true));
            this.f175019q0.setMovementMethod(RichTextHelper.getMovementMethodInstance());
            this.f175019q0.setText(RichTextHelper.buildSpannable("\"" + string + "\"  " + string2, this, false, arrayList));
        }
    }

    private void Y2(int i3) {
        String qqStr;
        String string;
        boolean z16;
        if (this.f175003a0 == 0) {
            qqStr = getString(R.string.ca8);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.ju9);
        }
        setTitle(qqStr);
        this.f175011i0 = findViewById(R.id.idd);
        this.f175012j0 = findViewById(R.id.ici);
        this.f175013k0 = (EditText) findViewById(R.id.bz4);
        TextView textView = (TextView) findViewById(R.id.k8i);
        this.f175014l0 = textView;
        textView.setText(((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(this.app, this.f175006d0));
        this.f175012j0.setContentDescription(HardCodeUtil.qqStr(R.string.ju5) + ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(this.app, this.f175006d0));
        this.f175013k0.addTextChangedListener(this);
        this.f175012j0.setOnClickListener(this);
        if (Utils.G(this.f175004b0)) {
            this.f175011i0.setVisibility(8);
        } else {
            this.f175011i0.setVisibility(0);
        }
        if (((IAddFriendApi) QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(this.f175005c0)) {
            string = getIntent().getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            if (QLog.isColorLevel()) {
                QLog.d("AutoRemarkActivity", 2, "initUI remark = " + string + ", source id=" + this.f175005c0);
            }
        } else {
            Bundle bundle = this.f175008f0;
            string = (bundle == null || !this.f175023u0) ? "" : bundle.getString("base_nick");
        }
        String b16 = com.tencent.mobileqq.util.ay.b(this.f175004b0);
        if (!TextUtils.isEmpty(b16)) {
            this.f175013k0.setText(b16);
        } else {
            this.f175013k0.setText(string);
        }
        if (!TextUtils.isEmpty(string)) {
            this.f175013k0.setSelection(string.length());
            if (QQTheme.isNowThemeIsNight()) {
                this.f175013k0.setTextColor(Color.parseColor("#8E8E93"));
            } else if (QQTheme.isNowSimpleUI()) {
                this.f175013k0.setTextColor(getResources().getColor(R.color.f156965gb));
            } else {
                this.f175013k0.setTextColor(Color.parseColor("#B0B3Bf"));
            }
        }
        if (!friendlist.a.a(this.f175005c0) && this.f175005c0 != 3016) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f175007e0 = z16;
        if (!z16) {
            findViewById(R.id.fl7).setVisibility(8);
            this.f175025w0 = ((IAddFriendTabApi) QRoute.api(IAddFriendTabApi.class)).createPermissionSwitchGeneral(getBaseContext());
            this.f175025w0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (!this.f175027y0.booleanValue()) {
                ((IAddFriendTabApi) QRoute.api(IAddFriendTabApi.class)).showBlockLayoutOnly(this.f175025w0);
            }
            this.f175024v0.addView(this.f175025w0);
        }
        if (this.f175003a0 == 0) {
            setRightHighlightButton(R.string.hen, this);
            enableRightHighlight(true);
            setLeftViewName(getIntent());
        } else {
            setLeftButton(R.string.cancel, this);
            if (this.f175003a0 == 1) {
                this.leftView.setVisibility(8);
            }
        }
        Resources resources = getResources();
        TextView textView2 = this.rightViewText;
        if (textView2 != null && resources != null) {
            textView2.setTextColor(resources.getColorStateList(R.color.qui_common_text_nav_secondary_selector));
        }
        TextView textView3 = this.leftViewNotBack;
        if (textView3 != null && resources != null) {
            textView3.setTextColor(resources.getColorStateList(R.color.qui_common_text_nav_secondary_selector));
        }
        this.f175016n0 = (RelativeLayout) findViewById(R.id.ibq);
        this.f175017o0 = (ImageView) findViewById(R.id.fxg);
        this.f175018p0 = (TextView) findViewById(R.id.nickname);
        if (this.f175008f0 != null) {
            this.f175016n0.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f175011i0.getLayoutParams();
            layoutParams.topMargin = BaseAIOUtils.f(0.0f, getResources());
            this.f175011i0.setLayoutParams(layoutParams);
            String string2 = this.f175008f0.getString("base_uin");
            String string3 = this.f175008f0.getString("base_nick");
            this.f175017o0.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, string2));
            this.f175018p0.setText(string3);
        } else {
            this.f175016n0.setVisibility(8);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f175011i0.getLayoutParams();
            layoutParams2.topMargin = BaseAIOUtils.f(10.0f, getResources());
            this.f175011i0.setLayoutParams(layoutParams2);
        }
        this.f175015m0 = (BounceScrollView) findViewById(R.id.adt);
        W2();
        this.f175015m0.setOnTouchListener(new a());
        if (AppSetting.f99565y) {
            AccessibilityUtil.n(this.f175015m0, false);
            AccessibilityUtil.n(this.f175024v0, false);
            AccessibilityUtil.n(findViewById(R.id.ads), false);
            this.leftView.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0) + this.leftView.getText().toString() + HardCodeUtil.qqStr(R.string.ju7));
            this.f175013k0.setContentDescription(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(String str) {
        Dialog dialog = this.f175022t0;
        if (dialog != null && dialog.isShowing() && this.f175022t0.getWindow() != null) {
            try {
                this.f175022t0.dismiss();
            } catch (Throwable unused) {
            }
        }
        Dialog createContentOnlyDialog = DialogUtil.createContentOnlyDialog(this, str, 0, R.string.f171151ok, null, new b());
        this.f175022t0 = createContentOnlyDialog;
        try {
            createContentOnlyDialog.show();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("AutoRemarkActivity", 2, "showErrorTipsDlg, tips dialog show failed", th5);
            }
        }
    }

    public static void startRemarkAfterAgree(Activity activity, int i3, String str, long j3, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("AutoRemarkActivity", 2, "startAutoRemarkActivity, " + str);
        }
        Intent intent = new Intent(activity, (Class<?>) AutoRemarkActivity.class);
        intent.putExtra("param_mode", 1);
        intent.putExtra("uin", str);
        intent.putExtra("k_msg_key", j3);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivityForResult(intent, i3);
        activity.overridePendingTransition(R.anim.f155030h6, R.anim.f154442w);
    }

    public void P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (this.leftViewNotBack != null) {
            HashMap hashMap = new HashMap();
            VideoReport.setElementParams(this.leftViewNotBack, hashMap);
            VideoReport.reportEvent("dt_clck", this.leftViewNotBack, hashMap);
        }
    }

    public void Q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (this.f175010h0 != null) {
            HashMap hashMap = new HashMap();
            if (!this.f175007e0) {
                hashMap.put("kl_new_add_request", Integer.valueOf(((IAddFriendTabApi) QRoute.api(IAddFriendTabApi.class)).getReportParam(this.f175025w0)));
            }
            VideoReport.setElementParams(this.f175010h0, hashMap);
            VideoReport.reportEvent("dt_clck", this.f175010h0, hashMap);
            return;
        }
        if (this.rightHighLView.getVisibility() == 0) {
            HashMap hashMap2 = new HashMap();
            VideoReport.setElementParams(this.rightHighLView, hashMap2);
            VideoReport.reportEvent("dt_clck", this.rightHighLView, hashMap2);
        }
    }

    public void R2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        VideoReport.setPageId(this, "pg_user_setting");
        TextView textView = this.leftViewNotBack;
        if (textView != null && (textView instanceof TextView)) {
            VideoReport.setElementId(textView, "em_user_setting_cancel");
            VideoReport.setElementExposePolicy(this.leftViewNotBack, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(this.leftViewNotBack, ClickPolicy.REPORT_NONE);
        }
        Button button = this.f175010h0;
        if (button != null) {
            VideoReport.setElementId(button, "em_user_setting_complete");
            VideoReport.setElementExposePolicy(this.f175010h0, ExposurePolicy.REPORT_FIRST);
            VideoReport.setElementClickPolicy(this.f175010h0, ClickPolicy.REPORT_NONE);
        } else if (this.rightHighLView.getVisibility() == 0) {
            VideoReport.setElementId(this.rightHighLView, "em_user_setting_complete");
            VideoReport.setElementExposePolicy(this.rightHighLView, ExposurePolicy.REPORT_FIRST);
            VideoReport.setElementClickPolicy(this.rightHighLView, ClickPolicy.REPORT_NONE);
        }
    }

    public void S2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("to_uin", this.f175004b0);
        VideoReport.setPageParams(this, new PageParams(hashMap));
        VideoReport.reportEvent("dt_imp", this.leftViewNotBack, hashMap);
    }

    public void T2() {
        String charSequence;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("uin", this.f175004b0);
        bundle.putInt("uintype", 0);
        bundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
        bundle.putInt("aio_msg_source", 15);
        com.tencent.mobileqq.utils.ei.a(null, "Recent_clk_enterchat");
        SuspendThreadManager.I().R();
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClassName(getBaseContext(), ChatActivity.class.getName());
        Intent m3 = BaseAIOUtils.m(intent, new int[]{1});
        if (CrmUtils.r(this.app, this.f175004b0)) {
            ReportController.o(this.app, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, this.f175004b0, "0", "", "");
            m3.putExtra("uintype", 1024);
        } else {
            m3.putExtra("uintype", 0);
        }
        m3.putExtra("uin", this.f175004b0);
        if (this.f175013k0.getText().toString().trim().length() > 0) {
            charSequence = this.f175013k0.getText().toString().trim();
        } else {
            charSequence = this.f175018p0.getText().toString();
        }
        m3.putExtra("uinname", charSequence);
        if (isFinishing()) {
            QLog.i("AutoRemarkActivity", 1, "enterChatAIO is error! this.isFinishing()!");
        } else {
            startActivity(m3);
            com.tencent.mobileqq.utils.ei.a("Recent_clk_enterchat", null);
        }
    }

    void U2() {
        String stringExtra = getIntent().getStringExtra("param_return_addr");
        if (QLog.isColorLevel()) {
            QLog.d("AutoRemarkActivity", 2, "goBack | retAddr = " + stringExtra);
        }
        if (stringExtra != null) {
            try {
                Class<?> profileCardActivityClass = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
                Class<?> cls = Class.forName(stringExtra);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(MainService.QQPROCESSNAME, cls.getName()));
                if (cls.equals(profileCardActivityClass) || cls.equals(QidianProfileCardActivity.class)) {
                    ProfileActivity.F2(this, this.f175004b0, intent);
                }
                intent.setFlags(67108864);
                intent.putExtra("key_back_from_add_friend", true);
                startActivity(intent);
                return;
            } catch (ClassNotFoundException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AutoRemarkActivity", 2, "goBack | exception = ", e16);
                }
                e16.printStackTrace();
                setResult(-1);
                finish();
                return;
            }
        }
        if (getIntent().getBooleanExtra("from_newer_guide", false)) {
            Intent intent2 = new Intent();
            intent2.putExtra("has_operation", true);
            intent2.putExtra("uin", this.f175004b0);
            setResult(-1, intent2);
        } else {
            setResult(-1);
        }
        finish();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) editable);
            return;
        }
        String obj = this.f175013k0.getText().toString();
        if (((IAddFriendApi) QRoute.api(IAddFriendApi.class)).countByByte(obj) > 32) {
            int selectionStart = this.f175013k0.getSelectionStart();
            String remark = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getRemark(obj);
            this.f175013k0.setText(remark);
            if (selectionStart >= remark.length()) {
                this.f175013k0.setSelection(remark.length());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 != -1) {
            return;
        }
        if (i3 != 1001) {
            if (i3 == 1002) {
                String stringExtra = intent.getStringExtra(IParticipleUIApi.SELECTED_WORDS);
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.f175013k0.setText(stringExtra);
                    this.f175019q0.setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        byte byteExtra = intent.getByteExtra("result", (byte) 0);
        this.f175006d0 = byteExtra;
        this.f175014l0.setText(((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(this.app, byteExtra));
        if (AppSetting.f99565y) {
            this.f175012j0.setContentDescription(HardCodeUtil.qqStr(R.string.ju6) + ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(this.app, byteExtra));
        }
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        this.f175003a0 = intent.getIntExtra("param_mode", 0);
        this.f175004b0 = intent.getStringExtra("uin");
        this.f175005c0 = getIntent().getIntExtra("source_id", BuddySource.DEFAULT);
        Bundle extras = intent.getExtras();
        this.f175008f0 = extras;
        this.f175023u0 = extras.getBoolean("isFromWzry", false);
        this.f175026x0 = Boolean.valueOf(getIntent().getBooleanExtra("param_go_back_after_setting_done", false));
        this.f175027y0 = Boolean.valueOf(((IAddFriendTabApi) QRoute.api(IAddFriendTabApi.class)).isAddQZonePermissionSwitch(1));
        super.setContentView(R.layout.dpt);
        Button button = (Button) findViewById(R.id.f9064531);
        this.f175010h0 = button;
        button.setOnClickListener(this);
        this.f175024v0 = (LinearLayout) findViewById(R.id.yiv);
        setContentBackgroundResource(R.drawable.bg_texture);
        this.f175020r0 = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        Y2(this.f175005c0);
        this.app.addObserver(this.f175021s0);
        this.app.addObserver(this.f175028z0);
        if (bundle == null || this.f175003a0 == 1) {
            if (NetworkUtil.isNetSupport(this) && ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).shouldReqAutoInfo(this.f175005c0, this.f175004b0)) {
                ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).requestAutoInfo(this.f175004b0, this.f175005c0, getIntent().getIntExtra("sub_source_id", 0));
            }
            getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.A0);
        }
        V2();
        R2();
        return true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Dialog dialog = this.f175022t0;
        if (dialog != null && dialog.isShowing() && this.f175022t0.getWindow() != null) {
            try {
                this.f175022t0.dismiss();
            } catch (Throwable unused) {
            }
        }
        getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.A0);
        super.doOnDestroy();
        this.app.removeObserver(this.f175021s0);
        this.app.removeObserver(this.f175028z0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        P2();
        setResult(-1);
        finish();
        overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ici) {
                Intent putExtra = new Intent(this, (Class<?>) MoveToGroupActivity.class).putExtra("friendUin", this.f175004b0).putExtra("mgid", (byte) this.f175006d0);
                putExtra.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
                startActivityForResult(putExtra, 1001);
            } else if (id5 != R.id.ivTitleBtnRightText && id5 != R.id.f9064531) {
                setResult(-1);
                finish();
                overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
            } else if (!NetworkUtil.isNetSupport(this)) {
                QQToast.makeText(this.app.getApp(), 1, getString(R.string.cjm), 0).show(getTitleBarHeight());
            } else {
                showProgressDialog(R.string.hex, 1000L, true);
                int i3 = this.f175003a0;
                if (i3 == 0) {
                    Intent intent = getIntent();
                    int intExtra = intent.getIntExtra("sub_source_id", 0);
                    int intExtra2 = intent.getIntExtra("friend_setting", 0);
                    if (intExtra2 == 3) {
                        intExtra2 = 100;
                    }
                    boolean booleanExtra = intent.getBooleanExtra("contact_bothway", false);
                    String stringExtra = intent.getStringExtra("src_name");
                    IFriendHandlerService iFriendHandlerService = (IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class);
                    if (!this.f175007e0) {
                        int switchResult = ((IAddFriendTabApi) QRoute.api(IAddFriendTabApi.class)).getSwitchResult(this.f175025w0);
                        Bundle bundleExtra = intent.getBundleExtra("flc_extra_param");
                        if (bundleExtra == null) {
                            bundleExtra = new Bundle();
                        }
                        bundleExtra.putInt("friend_permission", switchResult);
                        intent.putExtra("flc_extra_param", bundleExtra);
                    }
                    iFriendHandlerService.requestAddFriendWithMyCard(this.f175004b0, intent.getStringExtra("extra"), intExtra2, (byte) this.f175006d0, intent.getStringExtra("msg"), this.f175005c0, intExtra, true, intent.getByteArrayExtra(PreloadTRTCPlayerParams.KEY_SIG), booleanExtra, this.f175013k0.getText().toString(), stringExtra, intent.getByteExtra("show_my_card", (byte) 0), "", intent.getBundleExtra("flc_extra_param"), false);
                    if (!((IAddFriendApi) QRoute.api(IAddFriendApi.class)).couldAddFriendSuccessDirectly(intExtra2, this.f175005c0, booleanExtra)) {
                        ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).y0(this.f175004b0, true);
                    }
                } else if (i3 == 1) {
                    if (this.f175025w0 != null) {
                        ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class, "")).setFriendPermission(this.f175004b0, ((IAddFriendTabApi) QRoute.api(IAddFriendTabApi.class)).getSwitchResult(this.f175025w0));
                    }
                    this.f175009g0 = 0;
                    String trim = this.f175013k0.getText().toString().trim();
                    if (trim.length() != 0) {
                        this.f175020r0.setFriendComment(this.f175004b0, trim, false);
                    } else {
                        this.f175020r0.moveFriendToGroup(this.f175004b0, (byte) this.f175006d0, (byte) 0);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onResume();
            S2();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }
}
