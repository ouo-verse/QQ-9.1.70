package com.tencent.mobileqq.troop.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troop.i;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopRemarkEditFragment extends IphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    public static String P;
    public static String Q;
    public static String R;
    public static String S;
    public static int T;
    private ClearableEditText C;
    private IFaceDecoder D;
    private TextView E;
    private Button F;
    private QQAppInterface G;
    private String H;
    private SpannableString I;
    private String J;
    private String K;
    private ImageView L;
    private final View.OnClickListener M;
    private final View.OnClickListener N;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopRemarkEditFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopRemarkEditFragment.this.C.setText(TroopRemarkEditFragment.this.I);
                ReportController.o(TroopRemarkEditFragment.this.G, "dc00899", "Grp_set_new", "", "groupnameRemarks", "filling", 0, 0, TroopRemarkEditFragment.this.H, "", "", "");
                try {
                    TroopRemarkEditFragment.this.C.setSelection(TroopRemarkEditFragment.this.I.length());
                    if (TroopRemarkEditFragment.this.I.toString().getBytes("utf-8").length > 60) {
                        TextUtils.backspace(TroopRemarkEditFragment.this.C);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopRemarkEditFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(boolean z16, int i3) {
            TroopRemarkEditFragment.this.zh(z16, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(final boolean z16, final int i3, String str) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.fragment.c
                @Override // java.lang.Runnable
                public final void run() {
                    TroopRemarkEditFragment.b.this.c(z16, i3);
                }
            });
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QQText qQText;
            String qQText2;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopRemarkEditFragment troopRemarkEditFragment = TroopRemarkEditFragment.this;
                troopRemarkEditFragment.Ah(troopRemarkEditFragment.C);
                if (!NetworkUtil.isNetSupport(TroopRemarkEditFragment.this.getActivity())) {
                    QQToast.makeText(TroopRemarkEditFragment.this.getActivity(), 1, R.string.f171139ci4, 0).show();
                    ReportController.o(TroopRemarkEditFragment.this.G, "dc00899", "Grp_set_new", "", "groupnameRemarks", "sub_failure", 0, 0, TroopRemarkEditFragment.this.H, "1", "", "");
                } else {
                    Editable text = TroopRemarkEditFragment.this.C.getText();
                    if (text != null && text.length() > 0) {
                        qQText = new QQText(text.toString(), 3);
                    } else {
                        qQText = null;
                    }
                    if (qQText == null) {
                        qQText2 = "";
                    } else {
                        qQText2 = qQText.toString();
                    }
                    String str = qQText2;
                    if (!android.text.TextUtils.equals(str, TroopRemarkEditFragment.this.J)) {
                        TroopRemarkEditFragment.this.K = str;
                        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyGroupRemark(TroopRemarkEditFragment.this.H, str, TroopRemarkEditFragment.this, "TroopRemarkEditFragment", new i() { // from class: com.tencent.mobileqq.troop.fragment.b
                            @Override // com.tencent.qqnt.troop.i
                            public final void onResult(boolean z16, int i3, String str2) {
                                TroopRemarkEditFragment.b.this.d(z16, i3, str2);
                            }
                        });
                        TroopRemarkEditFragment.this.startTitleProgress();
                    } else {
                        FragmentActivity activity = TroopRemarkEditFragment.this.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements InputFilter {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopRemarkEditFragment.this);
            }
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), spanned, Integer.valueOf(i17), Integer.valueOf(i18));
            }
            if (charSequence.toString().contains("\n")) {
                return charSequence.toString().replace("\n", "");
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements TextWatcher {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopRemarkEditFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            try {
                if (new QQText(charSequence, 3).toString().getBytes("utf-8").length > TroopRemarkEditFragment.T && (charSequence instanceof Editable)) {
                    TextUtils.backspace(TroopRemarkEditFragment.this.C);
                }
            } catch (UnsupportedEncodingException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopRemarkEditFragment", 2, "UnsupportedEncodingException" + e16.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopRemarkEditFragment.this);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (accessibilityNodeInfoCompat != null) {
                accessibilityNodeInfoCompat.setClassName(Button.class.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopRemarkEditFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (TroopRemarkEditFragment.this.C != null) {
                    TroopRemarkEditFragment troopRemarkEditFragment = TroopRemarkEditFragment.this;
                    troopRemarkEditFragment.Ah(troopRemarkEditFragment.C);
                }
                FragmentActivity activity = TroopRemarkEditFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76465);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        P = "param_troopuin";
        Q = "param_troopcode";
        R = "param_troopname";
        S = "param_old_troopremark";
        T = 60;
    }

    public TroopRemarkEditFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.M = new a();
            this.N = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah(EditText editText) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            QLog.i("TroopRemarkEditFragment", 1, "[hideInputMethod] activity is null");
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager.isActive()) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopRemarkEditFragment", 2, "hideInputMethod()");
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bh(int i3, int i16, String str, Bitmap bitmap) {
        if (android.text.TextUtils.equals(str, this.H)) {
            this.L.setImageBitmap(bitmap);
        }
    }

    private void Ch() {
        FragmentActivity activity;
        if ((!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) && (activity = getActivity()) != null) {
            ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
        }
    }

    private void Dh() {
        this.C.setInputType(131072);
        this.C.setCanMultiLine(true);
        this.C.setClearButtonStyle(1);
        this.C.setSingleLine(false);
        this.C.setFilters(new InputFilter[]{new c()});
        if (!android.text.TextUtils.isEmpty(this.J)) {
            this.C.setText(this.J);
            this.C.setSelection(this.J.length());
        }
        this.C.addTextChangedListener(new d());
    }

    private void initData(Intent intent) {
        this.G = getBaseActivity().app;
        this.H = intent.getStringExtra(P);
        this.I = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(intent.getStringExtra(R), 16);
        this.J = intent.getStringExtra(S);
        this.D = ((IQQAvatarService) this.G.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.G);
        this.C = (ClearableEditText) findViewById(R.id.f1035460w);
        this.E = (TextView) findViewById(R.id.f627831r);
        this.F = (Button) findViewById(R.id.f627931s);
    }

    private void initListener() {
        TextView textView = this.E;
        if (textView != null) {
            textView.setOnClickListener(this.M);
        }
        Button button = this.F;
        if (button != null) {
            button.setOnClickListener(this.N);
        }
    }

    private void updateTitle() {
        hideTitleBar();
        ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        textView.setContentDescription(getString(R.string.f171146cj4));
        ViewCompat.setAccessibilityDelegate(textView, new e());
        textView.setOnClickListener(new f());
    }

    private Drawable yh() {
        Bitmap bitmapFromCache = this.D.getBitmapFromCache(4, this.H);
        if (bitmapFromCache == null && !this.D.isPausing()) {
            this.D.requestDecodeFace(this.H, 4, true);
            this.D.setDecodeTaskCompletionListener(new DecodeTaskCompletionListener() { // from class: com.tencent.mobileqq.troop.fragment.a
                @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
                public final void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
                    TroopRemarkEditFragment.this.Bh(i3, i16, str, bitmap);
                }
            });
        }
        if (bitmapFromCache == null) {
            bitmapFromCache = BaseImageUtil.getDefaultFaceBitmap();
        }
        return new BitmapDrawable(bitmapFromCache);
    }

    void Eh(EditText editText) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            try {
                ((InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(editText, 0);
                return;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopRemarkEditFragment", 2, "showInputMethod error");
                    return;
                }
                return;
            }
        }
        QLog.e("TroopRemarkEditFragment", 1, "showInputMethod error! activity is invalid!");
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        FlingHandler flingHandler = GestureActivityModule.getFlingHandler(getQBaseActivity());
        if (flingHandler instanceof FlingGestureHandler) {
            return ((FlingGestureHandler) flingHandler).mTopLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && getBaseActivity().app != null) {
            initData(activity.getIntent());
            initUI();
            initListener();
            ReportController.o(this.G, "dc00899", "Grp_set_new", "", "groupnameRemarks", "exp", 0, 0, this.H, "", "", "");
        }
    }

    protected final <T extends View> T findViewById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return (T) ((IphoneTitleBarFragment) this).mContentView.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return R.layout.i0l;
    }

    protected void initUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.titleRoot.setFitsSystemWindows(false);
            this.titleRoot.setPadding(0, 0, 0, 0);
        }
        updateTitle();
        Dh();
        ImageView imageView = (ImageView) findViewById(R.id.f1035560x);
        this.L = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(yh());
        }
        TextView textView = (TextView) findViewById(R.id.f627731q);
        if (textView != null) {
            textView.setText(((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(String.format("%s %s ", getString(R.string.f2062357r), this.I), 16));
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment
    public boolean needDispatchTouchEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        Ah(this.C);
        IFaceDecoder iFaceDecoder = this.D;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        Ch();
        ClearableEditText clearableEditText = this.C;
        if (clearableEditText != null) {
            clearableEditText.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopRemarkEditFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    TroopRemarkEditFragment.this.C.requestFocus();
                    TroopRemarkEditFragment troopRemarkEditFragment = TroopRemarkEditFragment.this;
                    troopRemarkEditFragment.Eh(troopRemarkEditFragment.C);
                }
            }, 100L);
        }
    }

    protected void zh(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        QLog.i("TroopRemarkEditFragment", 1, "[handleModifyTroopRemarkResult] isSuc:" + z16 + ", result:" + i3);
        Ah(this.C);
        FragmentActivity activity = getActivity();
        if (z16 && i3 == 0) {
            ReportController.o(this.G, "dc00899", "Grp_set_new", "", "groupnameRemarks", "sub_success", 0, 0, this.H, "", "", "");
            Intent intent = new Intent();
            intent.putExtra("result", this.K);
            if (activity != null) {
                activity.setResult(-1, intent);
                activity.finish();
                return;
            }
            return;
        }
        if (activity != null) {
            QQToast.makeText(activity, R.string.f2065558m, 0).show(getQBaseActivity().getTitleBarHeight());
        }
        ReportController.o(this.G, "dc00899", "Grp_set_new", "", "groupnameRemarks", "sub_failure", 0, 0, this.H, "1", "", "");
    }
}
