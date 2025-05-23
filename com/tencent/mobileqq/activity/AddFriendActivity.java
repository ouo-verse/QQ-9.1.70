package com.tencent.mobileqq.activity;

import addcontacts.AccountSearchPb$record;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.g;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: P */
@RoutePage(desc = "\u6dfb\u52a0\u597d\u53cb\u9875\u9762", path = RouterConstants.UI_ROUTE_ADD_FRIEND_ACTIVITY)
/* loaded from: classes9.dex */
public class AddFriendActivity extends IphoneTitleBarActivity implements View.OnClickListener, TextWatcher, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_ALLOWED_TROOP_KEYWORK_LENGTH = 25;
    private static final int MSG_AUTO_ACTION = 1;
    private static final String PARAM_IS_TROOP = "btroop";
    private static final String PARAM_NEED_FINICH = "needFinish";
    private static final String PARAM_PERFORM_AUTO_ACTION = "performAutoAction";
    private static final String PARAM_TROOP_UIN = "troopuin";
    private static final String PARAM_UIN = "uin";
    private static final int REQUEST_CODE_ADD_FRIEND = 100;
    private static final String TAG = "AddFriendActivity";
    private final Pattern VERIFY_DIGITAL_PATTERN;
    private final Pattern VERIFY_EMAIL_PATTERN;
    private Handler handler;
    private boolean isInitialized;
    private boolean isNeedFinish;
    QQProgressDialog mDlgProgress;
    private EditText mEtKeyword;
    private InputMethodManager mIm;
    private boolean mPerformAutoAction;
    String mSearchKeyword;
    private boolean mSearchTroop;
    String mSearchTrpCode;
    private TextView mTvErrMsg;
    private com.tencent.mobileqq.activity.contact.addcontact.g searchFacade;
    g.b searchListener;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements g.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contact.addcontact.g.b
        public void a(int i3, boolean z16, Object obj, int i16, String str, int i17, List<com.tencent.mobileqq.search.model.x> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj, Integer.valueOf(i16), str, Integer.valueOf(i17), list);
            } else if (AddFriendActivity.this.mSearchTroop) {
                AddFriendActivity.this.handleSearchTroopResult(i3, z16, obj, i16, str);
            } else {
                AddFriendActivity.this.handleSearchFrdResult(i3, z16, obj, i16, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements IRelationNTUinAndUidApi.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f174684a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SearchResultItem f174685b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f174686c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f174687d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f174688e;

        b(Activity activity, SearchResultItem searchResultItem, QQAppInterface qQAppInterface, boolean z16, int i3) {
            this.f174684a = activity;
            this.f174685b = searchResultItem;
            this.f174686c = qQAppInterface;
            this.f174687d = z16;
            this.f174688e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, activity, searchResultItem, qQAppInterface, Boolean.valueOf(z16), Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi.d
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                AddFriendActivity.startProfileCardActivity(this.f174684a, this.f174685b, this.f174686c, this.f174687d, this.f174688e, str);
            }
        }
    }

    public AddFriendActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSearchKeyword = "";
        this.mSearchTroop = false;
        this.mPerformAutoAction = true;
        this.isNeedFinish = false;
        this.isInitialized = false;
        this.searchListener = new a();
        this.VERIFY_EMAIL_PATTERN = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
        this.VERIFY_DIGITAL_PATTERN = Pattern.compile("[^0-9]");
        this.handler = new WeakReferenceHandler(this);
    }

    private void dismissJuhua() {
        QQProgressDialog qQProgressDialog = this.mDlgProgress;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.mDlgProgress.dismiss();
        }
    }

    private void doSearchTroop() {
        if (guessIsTroopUin(this.mSearchTrpCode)) {
            this.searchFacade.n(this.mSearchTrpCode, 80000001, 0.0d, 0.0d, 0);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "\u5c11\u4e8e5\u4f4d\u6570\u5b57\uff0c\u76f4\u63a5\u663e\u793a\u627e\u4e0d\u5230\u7fa4\u53f7");
        }
        dismissJuhua();
        showErrMsg(R.string.i8o);
    }

    private static boolean guessIsTroopUin(String str) {
        if (str != null) {
            return str.matches("^\\d{5,}$");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSearchFrdResult(int i3, boolean z16, Object obj, int i16, String str) {
        List<AccountSearchPb$record> list;
        List<AccountSearchPb$record> list2;
        dismissJuhua();
        if (z16 && i16 == 0) {
            try {
                ArrayList arrayList = (ArrayList) obj;
                un2.a aVar = null;
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        un2.a aVar2 = (un2.a) it.next();
                        if (aVar2 != null && aVar2.f439268a == 80000000 && (list2 = aVar2.f439272e) != null && list2.size() != 0) {
                            int i17 = 0;
                            for (AccountSearchPb$record accountSearchPb$record : aVar2.f439272e) {
                                if (accountSearchPb$record != null && accountSearchPb$record.uin.get() != 0) {
                                    i17++;
                                }
                            }
                            if (i17 != 0) {
                                aVar = aVar2;
                            }
                        }
                    }
                }
                if (aVar != null && (list = aVar.f439272e) != null && list.size() != 0) {
                    if (aVar.f439272e.size() == 1) {
                        startProfileCardActivity(this, new SearchResultItem(aVar.f439272e.get(0)), this.app, false, 1);
                        return;
                    } else {
                        startResultListActivity(aVar);
                        return;
                    }
                }
                showErrMsg(R.string.h_t);
                return;
            } catch (Exception e16) {
                showErrMsg(R.string.f170957b93);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onSearchResult | searchType = " + i3 + " | isSuccess = " + z16 + " | rsCode = " + i16 + " | data = " + obj, e16);
                    return;
                }
                return;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            showErrMsg(str);
        } else {
            showErrMsg(R.string.f170957b93);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSearchTroopResult(int i3, boolean z16, Object obj, int i16, String str) {
        List<AccountSearchPb$record> list;
        dismissJuhua();
        if (z16 && obj != null && (obj instanceof ArrayList)) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList.size() == 1 && (list = ((un2.a) arrayList.get(0)).f439272e) != null && list.size() == 1) {
                AccountSearchPb$record accountSearchPb$record = list.get(0);
                int i17 = ((un2.a) arrayList.get(0)).f439268a;
                String valueOf = String.valueOf(accountSearchPb$record.code.get());
                if (i17 == 80000001 && !TextUtils.isEmpty(valueOf) && TextUtils.equals(this.mSearchTrpCode, valueOf)) {
                    TroopUtils.I(this, com.tencent.mobileqq.troop.utils.aq.d(String.valueOf(accountSearchPb$record.code.get()), accountSearchPb$record.bytes_join_group_auth.get().toStringUtf8(), 105), 2);
                    finish();
                    overridePendingTransition(0, 0);
                    return;
                }
            }
        }
        if (!z16) {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                showErrMsg(R.string.ci7);
                return;
            } else {
                showErrMsg(R.string.f170957b93);
                return;
            }
        }
        showErrMsg(R.string.i8o);
    }

    private void initParams() {
        Intent intent = getIntent();
        this.mSearchKeyword = intent.getStringExtra("uin");
        this.mSearchTrpCode = intent.getStringExtra(PARAM_TROOP_UIN);
        this.mSearchTroop = intent.getBooleanExtra(PARAM_IS_TROOP, false);
        this.mPerformAutoAction = intent.getBooleanExtra(PARAM_PERFORM_AUTO_ACTION, true);
        this.isNeedFinish = intent.getBooleanExtra(PARAM_NEED_FINICH, false);
    }

    private void initUI() {
        Button button = (Button) findViewById(R.id.aju);
        TextView textView = (TextView) findViewById(R.id.k8w);
        EditText editText = (EditText) findViewById(R.id.f165112bz0);
        this.mEtKeyword = editText;
        editText.addTextChangedListener(this);
        this.mTvErrMsg = (TextView) findViewById(R.id.k7u);
        if (this.mSearchTroop) {
            setTitle(R.string.h_x);
            textView.setText(R.string.h_n);
            this.mEtKeyword.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
            textView.setVisibility(8);
            findViewById(R.id.ik6).setVisibility(8);
            View findViewById = findViewById(R.id.f164023ha);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = -1;
            findViewById.setLayoutParams(layoutParams);
            View findViewById2 = findViewById(R.id.f164028hg);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
            layoutParams2.height = -1;
            findViewById2.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTvErrMsg.getLayoutParams();
            layoutParams3.addRule(3, 0);
            layoutParams3.addRule(13);
            this.mTvErrMsg.setLayoutParams(layoutParams3);
        } else {
            setTitle(R.string.h_w);
            this.mEtKeyword.setHint(R.string.h_m);
            textView.setText(R.string.h_m);
        }
        this.mTvErrMsg.setVisibility(4);
        button.setOnClickListener(this);
        if (!TextUtils.isEmpty(this.mSearchKeyword)) {
            this.mEtKeyword.setText(this.mSearchKeyword);
            textView.setFocusable(true);
            textView.setFocusableInTouchMode(true);
            textView.requestFocus();
            return;
        }
        if (this.mSearchTroop && !TextUtils.isEmpty(this.mSearchTrpCode)) {
            this.mEtKeyword.setText(this.mSearchTrpCode);
            textView.setFocusable(true);
            textView.setFocusableInTouchMode(true);
            textView.requestFocus();
            return;
        }
        this.mEtKeyword.setText("");
        this.mEtKeyword.requestFocus();
    }

    private void searchFriend() {
        String trim = this.mEtKeyword.getEditableText().toString().trim();
        this.mSearchKeyword = trim;
        String trim2 = trim.trim();
        this.mSearchKeyword = trim2;
        if (trim2.equals("")) {
            showErrMsg(R.string.f170892ay4);
            return;
        }
        if (this.mSearchKeyword.length() < 5) {
            showErrMsg(R.string.b0r);
            return;
        }
        if (this.mSearchKeyword.indexOf("@") != -1) {
            if (!this.VERIFY_EMAIL_PATTERN.matcher(this.mSearchKeyword).matches()) {
                showErrMsg(HardCodeUtil.qqStr(R.string.j4f));
                return;
            }
        } else {
            String replaceAll = this.VERIFY_DIGITAL_PATTERN.matcher(this.mSearchKeyword).replaceAll("");
            this.mSearchKeyword = replaceAll;
            if (replaceAll.length() < 5) {
                showErrMsg(R.string.f170892ay4);
                return;
            }
        }
        if (NetworkUtil.isNetSupport(this)) {
            this.searchFacade.n(this.mSearchKeyword, 80000000, 0.0d, 0.0d, 0);
            showJuhua(R.string.b9c);
            InputMethodManager inputMethodManager = this.mIm;
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.mEtKeyword.getWindowToken(), 0);
                return;
            }
            return;
        }
        QQToast.makeText(this, R.string.f171139ci4, 0).show(getTitleBarHeight());
    }

    private void searchTroop() {
        String obj = this.mEtKeyword.getEditableText().toString();
        this.mSearchTrpCode = obj;
        if (obj.trim().equals("")) {
            showErrMsg(R.string.h_n);
            return;
        }
        if (NetworkUtil.isNetSupport(this)) {
            showJuhua(R.string.haa);
            doSearchTroop();
            InputMethodManager inputMethodManager = this.mIm;
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.mEtKeyword.getWindowToken(), 0);
                return;
            }
            return;
        }
        QQToast.makeText(this, R.string.f171139ci4, 0).show(getTitleBarHeight());
    }

    private void showJuhua(int i3) {
        if (this.mDlgProgress == null) {
            this.mDlgProgress = new QQProgressDialog(this, getTitleBarHeight());
        }
        this.mDlgProgress.setMessage(i3);
        this.mDlgProgress.show();
    }

    public static void startActivity(Context context, boolean z16, String str, boolean z17) {
        Intent intent = new Intent(context, (Class<?>) AddFriendActivity.class);
        intent.putExtra(PARAM_IS_TROOP, z16);
        intent.putExtra(PARAM_PERFORM_AUTO_ACTION, z17);
        if ((context instanceof SplashActivity) || (context instanceof ChatActivity)) {
            intent.addFlags(1073741824);
            intent.putExtra(PARAM_NEED_FINICH, true);
        }
        if (str != null) {
            if (z16) {
                intent.putExtra(PARAM_TROOP_UIN, str);
            } else {
                intent.putExtra("uin", str);
            }
        }
        context.startActivity(intent);
    }

    public static void startProfileCardActivity(Activity activity, SearchResultItem searchResultItem, QQAppInterface qQAppInterface, boolean z16, int i3) {
        if (searchResultItem == null) {
            return;
        }
        ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(searchResultItem.f283460d + "", true, true, new b(activity, searchResultItem, qQAppInterface, z16, i3));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) editable);
        } else {
            this.mTvErrMsg.setVisibility(4);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (i16 == -1 && i3 == 100) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onCreate");
        }
        super.doOnCreate(bundle);
        initParams();
        Window window = getActivity().getWindow();
        if (TextUtils.isEmpty(this.mSearchKeyword) && (!this.mSearchTroop || TextUtils.isEmpty(this.mSearchTrpCode))) {
            window.setSoftInputMode(4);
        } else {
            window.setSoftInputMode(2);
        }
        com.tencent.mobileqq.activity.contact.addcontact.g gVar = new com.tencent.mobileqq.activity.contact.addcontact.g(this.app);
        this.searchFacade = gVar;
        gVar.p(this.searchListener);
        this.mIm = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        super.setContentView(View.inflate(this, R.layout.f167564av, null));
        setContentBackgroundResource(R.drawable.bg_texture);
        initUI();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.searchFacade.h();
        this.searchFacade = null;
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        super.doOnWindowFocusChanged(z16);
        if (z16 && !this.isInitialized) {
            this.isInitialized = true;
            this.handler.sendEmptyMessage(1);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.finish();
        InputMethodManager inputMethodManager = this.mIm;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
            this.mIm = null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1) {
            performAutoAction();
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (view.getId() == R.id.aju) {
            this.mTvErrMsg.setVisibility(4);
            if (!isFinishing()) {
                if (!this.mSearchTroop) {
                    searchFriend();
                } else {
                    searchTroop();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    void performAutoAction() {
        if (!TextUtils.isEmpty(this.mSearchKeyword) && this.mPerformAutoAction) {
            searchFriend();
        }
        if (this.mSearchTroop && !TextUtils.isEmpty(this.mSearchTrpCode) && this.mPerformAutoAction) {
            searchTroop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public String setLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        TextView textView = this.centerView;
        if (textView != null && textView.getText() != null && this.centerView.getText().length() != 0 && !this.isNeedFinish) {
            return this.centerView.getText().toString();
        }
        return getString(R.string.button_back);
    }

    void showErrMsg(int i3) {
        runOnUiThread(new Runnable(i3) { // from class: com.tencent.mobileqq.activity.AddFriendActivity.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f174681d;

            {
                this.f174681d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendActivity.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    AddFriendActivity.this.mTvErrMsg.setText(this.f174681d);
                    AddFriendActivity.this.mTvErrMsg.setVisibility(0);
                }
            }
        });
    }

    void startResultListActivity(un2.a aVar) {
        List<AccountSearchPb$record> list;
        if (aVar != null && (list = aVar.f439272e) != null && list.size() != 0) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(aVar.f439272e.size());
            for (AccountSearchPb$record accountSearchPb$record : aVar.f439272e) {
                if (accountSearchPb$record != null) {
                    arrayList.add(new SearchResultItem(accountSearchPb$record));
                }
            }
            if (arrayList.size() == 0) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) SearchFriendListActivity.class);
            intent.putParcelableArrayListExtra("param_search_result_item_list", arrayList);
            intent.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
            startActivity(intent);
        }
    }

    public static void startProfileCardActivity(Activity activity, SearchResultItem searchResultItem, QQAppInterface qQAppInterface, boolean z16, int i3, String str) {
        String currentAccountUin;
        long j3;
        int i16;
        AllInOne allInOne;
        byte[] bArr;
        long j16 = searchResultItem.f283460d;
        if (qQAppInterface != null && com.tencent.mobileqq.troop.utils.k.l(qQAppInterface, String.valueOf(j16))) {
            com.tencent.mobileqq.troop.utils.k.o(activity, null, String.valueOf(j16));
            return;
        }
        if (qQAppInterface == null) {
            currentAccountUin = "";
        } else {
            try {
                currentAccountUin = qQAppInterface.getCurrentAccountUin();
            } catch (Throwable th5) {
                th5.printStackTrace();
                j3 = 0;
            }
        }
        j3 = Long.parseLong(currentAccountUin);
        int i17 = 3001;
        int i18 = 1;
        if (j16 != 0) {
            if (j16 == j3) {
                i17 = 0;
                i18 = 0;
            } else if (searchResultItem.f283464i == 1) {
                i17 = 0;
            } else if (z16) {
                i18 = 37;
                i17 = 3020;
            } else {
                i18 = 35;
            }
            allInOne = new AllInOne(String.valueOf(j16), i18);
        } else {
            if (searchResultItem.f283465m == 1) {
                i16 = 31;
            } else {
                i16 = 36;
                i17 = 3014;
            }
            allInOne = new AllInOne(searchResultItem.f283463h, i16);
        }
        if (j16 != 0 && i17 != 0 && i3 != 0 && (bArr = searchResultItem.E) != null && bArr.length > 0 && qQAppInterface != null) {
            ((IFriendHandlerService) qQAppInterface.getRuntimeService(IFriendHandlerService.class, "")).cacheToken(String.valueOf(j16), i17, i3, searchResultItem.E);
        }
        if (searchResultItem.F == 0) {
            allInOne.profileEntryType = 98;
        } else {
            allInOne.profileEntryType = 129;
        }
        allInOne.uid = str;
        allInOne.nickname = searchResultItem.f283462f;
        allInOne.chatCookie = searchResultItem.D;
        allInOne.sourceID = i17;
        allInOne.subSourceId = i3;
        if (searchResultItem.G != 0) {
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 8);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, searchResultItem.G);
        }
        int i19 = searchResultItem.H;
        if (i19 != 0) {
            allInOne.extras.putInt("user_type", i19);
        }
        if (activity.getIntent().getStringExtra("param_return_addr") != null) {
            Intent intent = ProfileUtils.getIntent(activity, allInOne);
            intent.putExtra("param_return_addr", activity.getIntent().getStringExtra("param_return_addr"));
            intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
            activity.startActivity(intent);
            return;
        }
        ProfileUtils.openProfileCardForResult(activity, allInOne, 100);
    }

    void showErrMsg(String str) {
        runOnUiThread(new Runnable(str) { // from class: com.tencent.mobileqq.activity.AddFriendActivity.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f174682d;

            {
                this.f174682d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendActivity.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    AddFriendActivity.this.mTvErrMsg.setText(this.f174682d);
                    AddFriendActivity.this.mTvErrMsg.setVisibility(0);
                }
            }
        });
    }
}
