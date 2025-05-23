package com.tencent.mobileqq.addfriend.ui.fornt.verify;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.addfriend.part.OpenAddFriendPart;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendCheckOpenidStatePart;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendGroupAndRemarkPart;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendSendPart;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendTitleBarPart;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.part.l;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.part.m;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.part.o;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.part.p;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.part.r;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.f;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.e;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AddFriendVerifyFragmentForNT extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    public static final boolean T;
    private static boolean U;
    private String C;
    private int D;
    private Intent E;
    private int F;
    protected InputMethodManager G;
    KplRoleInfo.WZRYUIinfo H;
    private BounceScrollView I;
    private EditText J;
    private ClearableEditText K;
    private OpenAddFriendPart L;
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a M;
    private f N;
    private g P;
    private boolean Q;
    private ViewTreeObserver.OnGlobalLayoutListener R;
    private ProfileCardObserver S;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragmentForNT.this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver == null) {
                QLog.d("AddFriendVerifyFragmentForNT", 1, "onViewAttachedToWindow viewTreeObserver is null");
                return;
            }
            if (!viewTreeObserver.isAlive()) {
                QLog.d("AddFriendVerifyFragmentForNT", 1, "onViewAttachedToWindow viewTreeObserver is notAlive");
            }
            if (AddFriendVerifyFragmentForNT.this.R != null) {
                viewTreeObserver.addOnGlobalLayoutListener(AddFriendVerifyFragmentForNT.this.R);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
                return;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver == null) {
                QLog.d("AddFriendVerifyFragmentForNT", 1, "onViewAttachedToWindow viewTreeObserver is null");
                return;
            }
            if (!viewTreeObserver.isAlive()) {
                QLog.d("AddFriendVerifyFragmentForNT", 1, "onViewAttachedToWindow viewTreeObserver is notAlive");
            }
            if (AddFriendVerifyFragmentForNT.this.R != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(AddFriendVerifyFragmentForNT.this.R);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragmentForNT.this);
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
                    inputMethodManager.hideSoftInputFromWindow(AddFriendVerifyFragmentForNT.this.getActivity().getWindow().getDecorView().getWindowToken(), 0);
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragmentForNT.this);
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
            if (AddFriendVerifyFragmentForNT.this.yh()) {
                return;
            }
            Rect rect = new Rect();
            AddFriendVerifyFragmentForNT.this.getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            DisplayMetrics displayMetrics = AddFriendVerifyFragmentForNT.this.getResources().getDisplayMetrics();
            int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            if (max - (rect.bottom - rect.top) > max / 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            View currentFocus = AddFriendVerifyFragmentForNT.this.getActivity().getCurrentFocus();
            if (!z16) {
                if (currentFocus instanceof EditText) {
                    ((EditText) currentFocus).setCursorVisible(false);
                }
                if (currentFocus instanceof ClearableEditText) {
                    ((ClearableEditText) currentFocus).setClearButtonVisible(false);
                    return;
                }
                return;
            }
            if (z16) {
                if (currentFocus instanceof ClearableEditText) {
                    ClearableEditText clearableEditText = (ClearableEditText) currentFocus;
                    if (!AddFriendVerifyFragmentForNT.U && clearableEditText.equals(AddFriendVerifyFragmentForNT.this.K)) {
                        AddFriendVerifyFragmentForNT.this.K.setTextColor(AddFriendVerifyFragmentForNT.this.getResources().getColor(R.color.skin_black));
                        boolean unused = AddFriendVerifyFragmentForNT.U = true;
                    }
                    if (clearableEditText.getText().toString() != null && clearableEditText.getText().toString().length() > 0) {
                        clearableEditText.setClearButtonVisible(true);
                    } else {
                        clearableEditText.setClearButtonVisible(false);
                    }
                }
                if (currentFocus instanceof EditText) {
                    ((EditText) currentFocus).setCursorVisible(true);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendVerifyFragmentForNT.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean z16, Object obj) {
            ContactCard contactCard;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (!AddFriendVerifyFragmentForNT.this.yh() && z16 && obj != null) {
                IProfileCardBusinessApi iProfileCardBusinessApi = (IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class);
                if (obj instanceof Card) {
                    Card card = (Card) obj;
                    String str2 = card.uin;
                    if (str2 != null && str2.equals(AddFriendVerifyFragmentForNT.this.C)) {
                        iProfileCardBusinessApi.makeSexAgeArea(AddFriendVerifyFragmentForNT.this.getActivity(), card.shGender, card.age, card.strCountry, card.strProvince, card.strCity);
                        AddFriendVerifyFragmentForNT addFriendVerifyFragmentForNT = AddFriendVerifyFragmentForNT.this;
                        if (addFriendVerifyFragmentForNT.H != null) {
                            iProfileCardBusinessApi.makeSexAgeArea(addFriendVerifyFragmentForNT.getActivity(), card.shGender, 0, "", "", "");
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ((obj instanceof ContactCard) && (str = (contactCard = (ContactCard) obj).mobileNo) != null && str.equals(AddFriendVerifyFragmentForNT.this.C)) {
                    iProfileCardBusinessApi.makeSexAgeArea(AddFriendVerifyFragmentForNT.this.getActivity(), contactCard.bSex, contactCard.bAge, contactCard.strCountry, contactCard.strProvince, contactCard.strCity);
                    AddFriendVerifyFragmentForNT addFriendVerifyFragmentForNT2 = AddFriendVerifyFragmentForNT.this;
                    if (addFriendVerifyFragmentForNT2.H != null) {
                        iProfileCardBusinessApi.makeSexAgeArea(addFriendVerifyFragmentForNT2.getActivity(), contactCard.bSex, 0, "", "", "");
                    }
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26615);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            T = AppSetting.f99565y;
            U = false;
        }
    }

    public AddFriendVerifyFragmentForNT() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.G = null;
        this.Q = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105861", false);
        this.R = new c();
        this.S = new d();
    }

    private void doCallback(int i3, String str) {
        OpenAddFriendPart openAddFriendPart = this.L;
        if (openAddFriendPart == null) {
            return;
        }
        openAddFriendPart.z9(i3, str);
    }

    private <T extends View> T findViewById(int i3) {
        return (T) ((QIphoneTitleBarFragment) this).mContentView.findViewById(i3);
    }

    private AppInterface getAppInterface() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendVerifyFragmentForNT", 2, "getAppInterface MobileQQ peek NULL!!!");
            }
            return null;
        }
        if (!(MobileQQ.sMobileQQ.peekAppRuntime() instanceof AppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendVerifyFragmentForNT", 2, "getAppInterface MobileQQ peek not AppInterface!!!");
            }
            return null;
        }
        return (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private void initUI() {
        BounceScrollView bounceScrollView = (BounceScrollView) findViewById(R.id.adt);
        this.I = bounceScrollView;
        bounceScrollView.setOnTouchListener(new b());
        this.J = (EditText) findViewById(R.id.f166785i82);
        this.K = (ClearableEditText) findViewById(R.id.bz4);
    }

    private void vh() {
        IProfileProtocolService iProfileProtocolService = (IProfileProtocolService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IProfileProtocolService.class, "");
        if (friendlist.a.a(this.E.getIntExtra("sort_id", 0))) {
            iProfileProtocolService.requestProfileCard(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), "0", 16, 0L, (byte) 0, 0L, 0L, null, this.C, 0L, 10004, null, (byte) 0);
        } else {
            iProfileProtocolService.requestProfileCard(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), this.C, 12, 0L, (byte) 0, 0L, 0L, null, "", 0L, 10004, null, (byte) 0);
        }
    }

    private Intent wh() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            return new Intent();
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            Parcelable parcelable = arguments.getParcelable("add_friend_intent");
            if (parcelable instanceof Intent) {
                return (Intent) parcelable;
            }
        }
        Intent intent = qBaseActivity.getIntent();
        if (intent == null) {
            return new Intent();
        }
        return intent;
    }

    private void xh(Bundle bundle) {
        Intent wh5 = wh();
        this.E = wh5;
        this.C = wh5.getStringExtra("uin");
        this.D = this.E.getIntExtra("k_uin_type", 1);
        this.F = this.E.getIntExtra("source_id", BuddySource.DEFAULT);
        if (this.E.hasExtra(IProfileCardConst.KEY_WZRY_DATA)) {
            this.H = (KplRoleInfo.WZRYUIinfo) this.E.getSerializableExtra(IProfileCardConst.KEY_WZRY_DATA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yh() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            return false;
        }
        return true;
    }

    private boolean zh() {
        if (e.a() != SplitViewState.STATE_FLAT && (getActivity() instanceof QPublicFragmentActivity)) {
            QLog.i("AddFriendVerifyFragmentForNT", 1, "isPadOnAddFriendFinished QFragmentContainerManager.currentSplitViewState() == SplitViewState.STATE_FLAT is false");
            return false;
        }
        QLog.i("AddFriendVerifyFragmentForNT", 1, "isPadOnAddFriendFinished QFragmentContainerManager.currentSplitViewState() == SplitViewState.STATE_FLAT is true");
        getActivity().onKeyDown(4, new KeyEvent(4, 4));
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.M = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a) getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a.class);
        this.N = (f) getViewModel(f.class);
        this.P = (g) getViewModel(g.class);
        ArrayList arrayList = new ArrayList();
        OpenAddFriendPart openAddFriendPart = new OpenAddFriendPart();
        this.L = openAddFriendPart;
        arrayList.add(openAddFriendPart);
        arrayList.add(new com.tencent.mobileqq.addfriend.ui.fornt.verify.part.f());
        arrayList.add(new AddFriendCheckOpenidStatePart());
        arrayList.add(new m());
        arrayList.add(new AddFriendTitleBarPart());
        arrayList.add(new l());
        arrayList.add(new AddFriendGroupAndRemarkPart());
        arrayList.add(new p());
        arrayList.add(new r());
        arrayList.add(new AddFriendSendPart());
        arrayList.add(new o());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (yh()) {
            return;
        }
        xh(bundle);
        initUI();
        vh();
        Window window = getActivity().getWindow();
        if (window != null) {
            QLog.i("AddFriendVerifyFragmentForNT", 1, "addOnGlobalLayoutListenerSwitch = " + this.Q);
            if (this.Q) {
                this.I.addOnAttachStateChangeListener(new a());
            } else {
                window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.R);
            }
            window.setSoftInputMode(32);
        }
        AppInterface appInterface = getAppInterface();
        if (appInterface != null) {
            appInterface.addObserver(this.S);
        }
        U = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.h7y;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doOnActivityResult, requestCode=");
            sb5.append(i3);
            sb5.append(",resultCode=");
            sb5.append(i16);
            sb5.append(",data=");
            if (intent != null) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("AddFriendVerifyFragmentForNT", 2, sb5.toString());
        }
        if (yh()) {
            return;
        }
        if (i3 == 0 && i16 == -1) {
            getActivity().setResult(i16, intent);
            getActivity().finish();
        }
        if (i3 != 1002) {
            if (i3 == 1004) {
                if (intent != null) {
                    str = intent.getStringExtra("ticket");
                } else {
                    str = null;
                }
                this.N.T1().postValue(str);
                return;
            }
            return;
        }
        if (intent != null) {
            this.M.L1().postValue(Integer.valueOf(intent.getByteExtra("result", (byte) 0)));
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            boolean z16 = false;
            if (e.a() == SplitViewState.STATE_FLAT) {
                com.tencent.mobileqq.pad.m.b(activity);
                return false;
            }
            if (zh()) {
                doCallback(4, "");
                return false;
            }
            doCallback(4, "");
            this.N.X1(activity, this.E);
            if (this.E.getBooleanExtra("need_jumpto_splash", false)) {
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).jumpToSplash(getActivity());
                return super.onBackEvent();
            }
            if (this.D != 4) {
                String obj = this.J.getText().toString();
                g gVar = this.P;
                if (4 == this.D) {
                    z16 = true;
                }
                gVar.O1(activity, obj, z16);
                if (getString(R.string.axv).equals(obj) && !this.P.M1(activity)) {
                    this.P.N1(activity);
                }
            }
            if (!TextUtils.isEmpty(this.E.getStringExtra("webImVisitId"))) {
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00899", "Qidian", this.C, "0X8008802", "ClickAddFriendButton", 0, 0, "2", "", "", "");
            }
            return super.onBackEvent();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendVerifyFragmentForNT", 2, "Add Friend by NT");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ProfileCardObserver profileCardObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        AppInterface appInterface = getAppInterface();
        if (appInterface != null && (profileCardObserver = this.S) != null) {
            appInterface.removeObserver(profileCardObserver);
        }
        if (getActivity() != null && !this.Q) {
            getActivity().getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.R);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onFinish();
        if (getActivity() == null) {
            return;
        }
        ((InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.titleRoot.getWindowToken(), 0);
        getActivity().getWindow().setSoftInputMode(2);
        if (this.D != 4) {
            getActivity().overridePendingTransition(0, R.anim.f154458a7);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
    }
}
