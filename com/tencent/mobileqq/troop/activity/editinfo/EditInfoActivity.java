package com.tencent.mobileqq.troop.activity.editinfo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.QZoneContant;
import java.lang.reflect.Constructor;
import java.util.HashMap;

/* compiled from: P */
@RoutePage(desc = "\u7f16\u8f91\u63d0\u4ea4\u754c\u9762", path = RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY)
/* loaded from: classes19.dex */
public class EditInfoActivity extends QIphoneTitleBarActivity implements com.tencent.mobileqq.troop.activity.editinfo.a, InputMethodLinearLayout.a {
    static IPatchRedirector $redirector_ = null;
    public static final int EDIT_NORMAL_HEIGHT = 149;
    public static final String PARAMS_KEY_NEED_HIDE_COUSER_WHEN_EMOJ = "key_need_hide_couser_when_emoj";
    private static final String TAG = "EditInfoActivity";

    @QAutoInjectJustClazz(configPath = "/AutoInjectYml/Business/Troop/Inject_editInfo_map.yml", version = 4)
    public static HashMap<String, Class<? extends com.tencent.mobileqq.troop.activity.editinfo.b>> mInjectEditInfos;
    com.tencent.mobileqq.troop.activity.editinfo.b editInfoApi;
    private boolean mCanPostNull;
    private int mCountType;
    private String mDefStr;
    private EditText mEditInfo;
    private int mEditMode;
    LinearLayout mEmojLayout;
    SystemAndEmojiUniversalPanel mEmojPanel;
    protected int mFromFlag;
    private String mHitStr;
    private boolean mIsEditMode;
    boolean mIsFullScreen;
    private boolean mIsKeyboardOpen;
    protected boolean mIsShowEmojiboard;
    private int mMaxLimitMode;
    private int mMaxNum;
    boolean mNeedEmo;
    private TextView mNum;
    private String mRightStr;
    InputMethodLinearLayout mRoot;
    protected int mSubType;
    ImageView mSwitchButton;
    private String mTitleStr;
    protected int mType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditInfoActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                EditInfoActivity.this.editInfoApi.i().onItemSelect(view, 2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditInfoActivity.this);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c extends Editable.Factory {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditInfoActivity.this);
            }
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Editable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
            }
            if (charSequence instanceof QQTextBuilder) {
                return (Editable) charSequence;
            }
            return new QQTextBuilder(charSequence, 3, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditInfoActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                EditInfoActivity editInfoActivity = EditInfoActivity.this;
                boolean z16 = !editInfoActivity.mIsShowEmojiboard;
                editInfoActivity.mIsShowEmojiboard = z16;
                if (z16) {
                    editInfoActivity.hideInputMethod();
                    if (EditInfoActivity.this.getIntent().getBooleanExtra(EditInfoActivity.PARAMS_KEY_NEED_HIDE_COUSER_WHEN_EMOJ, false)) {
                        EditInfoActivity.this.mEditInfo.setCursorVisible(false);
                    }
                    EditInfoActivity.this.mSwitchButton.setImageResource(R.drawable.f160147bi);
                    EditInfoActivity.this.mSwitchButton.setContentDescription(HardCodeUtil.qqStr(R.string.lvl));
                    EditInfoActivity editInfoActivity2 = EditInfoActivity.this;
                    LinearLayout linearLayout = editInfoActivity2.mEmojLayout;
                    if (linearLayout != null) {
                        if (editInfoActivity2.mType == 2) {
                            if (!editInfoActivity2.mIsKeyboardOpen) {
                                EditInfoActivity.this.mEmojLayout.setVisibility(0);
                            }
                        } else {
                            linearLayout.setVisibility(0);
                        }
                    }
                } else {
                    editInfoActivity.mEditInfo.setCursorVisible(true);
                    LinearLayout linearLayout2 = EditInfoActivity.this.mEmojLayout;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                    EditInfoActivity.this.mSwitchButton.setImageResource(R.drawable.asw);
                    EditInfoActivity.this.mSwitchButton.setContentDescription(HardCodeUtil.qqStr(R.string.lvb));
                    EditInfoActivity.this.showInputMethod();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditInfoActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                EditInfoActivity.this.mEditInfo.setCursorVisible(true);
                EditInfoActivity.this.mEmojLayout.setVisibility(8);
                EditInfoActivity.this.mSwitchButton.setImageResource(R.drawable.asw);
                EditInfoActivity.this.mSwitchButton.setContentDescription(HardCodeUtil.qqStr(R.string.lvg));
                EditInfoActivity.this.mIsShowEmojiboard = false;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f implements View.OnFocusChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f293711d;

        f(ImageView imageView) {
            this.f293711d = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditInfoActivity.this, (Object) imageView);
            }
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
            } else if (!TextUtils.isEmpty(EditInfoActivity.this.mEditInfo.getText()) && z16 && EditInfoActivity.this.mIsEditMode) {
                this.f293711d.setVisibility(0);
            } else {
                this.f293711d.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditInfoActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                EditInfoActivity.this.mEditInfo.setText("");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class h implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f293714d;

        h(ImageView imageView) {
            this.f293714d = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditInfoActivity.this, (Object) imageView);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) editable);
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            EditInfoActivity.this.updateEditTextAndNum(charSequence);
            com.tencent.mobileqq.troop.activity.editinfo.b bVar = EditInfoActivity.this.editInfoApi;
            if (bVar != null) {
                bVar.onTextChanged();
            }
            String obj = EditInfoActivity.this.mEditInfo.getText().toString();
            if (EditInfoActivity.this.mEditInfo instanceof ColorClearableEditText) {
                if (!TextUtils.isEmpty(obj) && EditInfoActivity.this.mIsEditMode) {
                    this.f293714d.setVisibility(0);
                } else {
                    this.f293714d.setVisibility(8);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63771);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        HashMap<String, Class<? extends com.tencent.mobileqq.troop.activity.editinfo.b>> hashMap = new HashMap<>();
        mInjectEditInfos = hashMap;
        hashMap.put("5", EditTroopMemberNickService.class);
        mInjectEditInfos.put("4", com.tencent.mobileqq.activity.editservice.d.class);
        mInjectEditInfos.put("3", com.tencent.mobileqq.activity.editservice.g.class);
        mInjectEditInfos.put("2", com.tencent.mobileqq.troop.activity.editservice.a.class);
        mInjectEditInfos.put("1", com.tencent.mobileqq.troop.activity.editservice.b.class);
    }

    public EditInfoActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mEditMode = 0;
        this.mMaxNum = 90;
        this.mMaxLimitMode = 0;
        this.mCountType = 0;
        this.mIsKeyboardOpen = false;
        this.mEmojLayout = null;
        this.mEmojPanel = null;
        this.mIsShowEmojiboard = false;
        this.mType = -1;
        this.mSubType = -1;
        this.mFromFlag = -1;
        this.mNeedEmo = false;
        this.mIsFullScreen = false;
    }

    private void dispatchEvent(int i3) {
        com.tencent.mobileqq.troop.activity.editinfo.b bVar = this.editInfoApi;
        if (bVar != null) {
            bVar.b(i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "editInfoApi == null type = " + getIntent().getIntExtra(QZoneContant.KEY_EDIT_TYPE, 0));
        }
        finish();
    }

    public static com.tencent.mobileqq.troop.activity.editinfo.b getApi(int i3) {
        String valueOf = String.valueOf(i3);
        HashMap<String, Class<? extends com.tencent.mobileqq.troop.activity.editinfo.b>> hashMap = mInjectEditInfos;
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        Class<? extends com.tencent.mobileqq.troop.activity.editinfo.b> cls = mInjectEditInfos.get(valueOf);
        if (cls == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getApi, clazz=null, type=" + valueOf);
            }
            return null;
        }
        try {
            Constructor<? extends com.tencent.mobileqq.troop.activity.editinfo.b> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "getApi Exception" + e16);
            return null;
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.editInfoApi.f(intent);
        this.mEditMode = intent.getIntExtra("edit_mode", this.mEditMode);
        this.mMaxNum = intent.getIntExtra("max_num", this.mMaxNum);
        this.mDefStr = intent.getStringExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT);
        this.mHitStr = intent.getStringExtra("default_hint");
        this.mTitleStr = intent.getStringExtra("title");
        this.mIsFullScreen = intent.getBooleanExtra("full_screen", false);
        this.mRightStr = intent.getStringExtra("right_btn");
        this.mCountType = intent.getIntExtra("count_type", 0);
        this.mCanPostNull = intent.getBooleanExtra("canPostNull", true);
        this.mIsEditMode = intent.getBooleanExtra("edit_mode", true);
        this.mNeedEmo = intent.getBooleanExtra("support_emotion", false);
        this.mType = intent.getIntExtra(QZoneContant.KEY_EDIT_TYPE, 0);
        this.mMaxLimitMode = intent.getIntExtra("max_limit_mode", 0);
    }

    private void initEditInfo() {
        int i3 = this.mEditMode;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    finish();
                    return;
                }
                showAutoEditer();
            } else {
                showMultiEditer();
            }
        } else {
            showSingEditer();
        }
        this.mEditInfo.setOnClickListener(this.editInfoApi.a());
        this.mEditInfo.setOnEditorActionListener(this.editInfoApi.h());
        if (!this.mIsEditMode) {
            noEdit();
        }
    }

    private void initEditInfoApi() {
        Intent intent = getIntent();
        com.tencent.mobileqq.troop.activity.editinfo.b api = getApi(intent.getIntExtra(QZoneContant.KEY_EDIT_TYPE, 0));
        this.editInfoApi = api;
        if (api != null) {
            api.g(this);
            dispatchEvent(0);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "initEditInfoApi error:" + intent.getIntExtra(QZoneContant.KEY_EDIT_TYPE, 0));
        }
        finish();
    }

    private void initEditNum() {
        this.mEditInfo = (EditText) super.findViewById(R.id.btm);
        ImageView imageView = (ImageView) findViewById(R.id.txl);
        EditText editText = this.mEditInfo;
        if (editText instanceof ColorClearableEditText) {
            ((ColorClearableEditText) editText).setClearButtonStyle(1);
            this.mEditInfo.setOnFocusChangeListener(new f(imageView));
            imageView.setOnClickListener(new g());
        }
        TextView textView = (TextView) super.findViewById(R.id.btp);
        this.mNum = textView;
        textView.setText(String.format("%d\u5b57", Integer.valueOf(this.mMaxNum)));
        this.mEditInfo.addTextChangedListener(new h(imageView));
        initEditStr();
    }

    private void initTitleBar() {
        String str;
        if (this.quiSecNavBar == null) {
            QLog.i(TAG, 1, "[initTitleBar] quiSecNavBar == null");
            return;
        }
        String str2 = "";
        if (!this.mIsEditMode) {
            str = "";
        } else {
            str = this.mRightStr;
            if (str == null) {
                str = getString(R.string.f1787737k);
            }
        }
        this.quiSecNavBar.setCenterType(1);
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        String str3 = this.mTitleStr;
        if (str3 != null) {
            str2 = str3;
        }
        qUISecNavBar.setCenterText(str2);
        this.quiSecNavBar.setRightType(1);
        this.quiSecNavBar.setRightText(str);
        this.quiSecNavBar.setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new a());
    }

    private void initUi() {
        initEditInfo();
        initTitleBar();
        RelativeLayout relativeLayout = (RelativeLayout) super.findViewById(R.id.uqm);
        RelativeLayout relativeLayout2 = (RelativeLayout) super.findViewById(R.id.uqb);
        setContentBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        this.editInfoApi.c(relativeLayout, this.mEditInfo, relativeLayout2);
    }

    private void noEdit() {
        this.mNum.setVisibility(4);
        this.mEditInfo.clearFocus();
        this.mEditInfo.setFocusable(false);
        this.mEditInfo.setFocusableInTouchMode(false);
        this.mEditInfo.setOnLongClickListener(new b());
        this.mEditInfo.setLongClickable(false);
        this.mEditInfo.setTextIsSelectable(false);
        this.mEditInfo.setCustomSelectionActionModeCallback(null);
    }

    private void showAutoEditer() {
        showSingEditer();
    }

    private void showMultiEditer() {
        Window window;
        super.setContentView(R.layout.f167926mx);
        InputMethodLinearLayout inputMethodLinearLayout = (InputMethodLinearLayout) super.findViewById(R.id.root);
        this.mRoot = inputMethodLinearLayout;
        inputMethodLinearLayout.setOnSizeChangedListenner(this);
        initEditNum();
        if (!this.mIsFullScreen) {
            this.mEditInfo.getLayoutParams().height = (int) al.a(this, 149.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRoot.findViewById(R.id.bt8).getLayoutParams();
            layoutParams.height = (int) al.a(this, 151.0f);
            layoutParams.weight = 0.0f;
        } else if (this.mType == 2 && (window = getWindow()) != null) {
            window.setSoftInputMode(16);
        }
        this.mEditInfo.setEditableFactory(new c());
        if (this.mNeedEmo) {
            initEmoj();
        }
    }

    private void showSingEditer() {
        super.setContentView(R.layout.f167927my);
        initEditNum();
    }

    private void updateRightViewTextEnable(boolean z16) {
        this.quiSecNavBar.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, z16);
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        com.tencent.mobileqq.troop.activity.editinfo.b bVar = this.editInfoApi;
        if (bVar != null) {
            bVar.onActivityResult(i3, i16, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        initEditInfoApi();
        if (this.editInfoApi == null) {
            finish();
            return false;
        }
        initData();
        initUi();
        if (!this.mIsEditMode) {
            getWindow().setSoftInputMode(3);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.doOnDestroy();
        QLog.i(TAG, 1, "[doOnDestroy] ");
        com.tencent.mobileqq.troop.activity.editinfo.b bVar = this.editInfoApi;
        if (bVar != null) {
            bVar.b(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.doOnPause();
            dispatchEvent(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnResume();
        if (this.mIsEditMode) {
            this.mEditInfo.requestFocus();
            showInputMethod();
        } else {
            hideInputMethod();
        }
        dispatchEvent(1);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "[finish] ");
        if (this.editInfoApi != null) {
            dispatchEvent(3);
        }
        hideInputMethod();
        super.finish();
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.a
    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Context) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.a
    public int getLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        String text = getText();
        if (TextUtils.isEmpty(text)) {
            return 0;
        }
        return getLength(new QQText(new SpannableStringBuilder(text), 3));
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.a
    public int getMaxLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mMaxNum;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.a
    public String getText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        EditText editText = this.mEditInfo;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.a
    public TextView getTipsView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (TextView) findViewById(R.id.f165057ur3);
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.a
    public void hideInputMethod() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        EditText editText = this.mEditInfo;
        if (editText != null) {
            editText.clearFocus();
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        View peekDecorView = getWindow().peekDecorView();
        if (peekDecorView != null && peekDecorView.getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
        }
    }

    void initEditStr() {
        this.mEditInfo.setHint(this.mHitStr);
        if (!TextUtils.isEmpty(this.mDefStr)) {
            CharSequence spannableStringFromColorNickText = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(this.mDefStr, 16);
            EditText editText = this.mEditInfo;
            if (TextUtils.isEmpty(spannableStringFromColorNickText)) {
                spannableStringFromColorNickText = this.mDefStr;
            }
            editText.setText(spannableStringFromColorNickText);
            Selection.setSelection(this.mEditInfo.getEditableText(), this.mEditInfo.getText().length());
        }
    }

    void initEmoj() {
        this.mEmojLayout = (LinearLayout) super.findViewById(R.id.bv_);
        ImageView imageView = (ImageView) findViewById(R.id.j9_);
        this.mSwitchButton = imageView;
        imageView.setVisibility(0);
        this.mSwitchButton.setOnClickListener(new d());
        SystemAndEmojiUniversalPanel create = new SystemAndEmojiUniversalPanel.Builder(this).setFilterSysFaceBeyond255Enable(true).setEmoticonCallback(this.editInfoApi.e()).setShowDeleteButton(this.mEditInfo).create(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(getAppRuntime()));
        this.mEmojPanel = create;
        create.setVisibility(0);
        if (ThemeUtil.isNowThemeIsNight(getAppRuntime(), true, null)) {
            this.mEmojPanel.setBackgroundResource(R.drawable.bg_texture);
        }
        this.mEmojLayout.addView(this.mEmojPanel);
        this.mEditInfo.setOnClickListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.a
    public void loadingProgress(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            updateRightViewTextEnable(!z16);
        }
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.a
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            QLog.i(TAG, 1, "[onFinish] ");
            finish();
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.a
    public void onFinishForResult(int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) intent);
            return;
        }
        if (intent != null) {
            intent.putExtra(QZoneContant.KEY_EDIT_TYPE, this.mType);
        }
        setResult(i3, intent);
        finish();
    }

    @Override // com.tencent.mobileqq.widget.InputMethodLinearLayout.a
    public void onSizeChange(boolean z16) {
        LinearLayout linearLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        if (this.mRoot == null) {
            return;
        }
        this.mIsKeyboardOpen = z16;
        if (z16) {
            LinearLayout linearLayout2 = this.mEmojLayout;
            if (linearLayout2 != null && this.mSwitchButton != null) {
                linearLayout2.setVisibility(8);
                this.mIsShowEmojiboard = false;
                this.mSwitchButton.setImageResource(R.drawable.asw);
                this.mSwitchButton.setContentDescription(HardCodeUtil.qqStr(R.string.lvg));
                return;
            }
            return;
        }
        if (this.mIsShowEmojiboard && (linearLayout = this.mEmojLayout) != null) {
            linearLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity
    public boolean secNavBarNeedImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.a
    public void showInputMethod() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (this.mEditInfo != null && this.mIsEditMode) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "showInputMethod()");
            }
            inputMethodManager.showSoftInput(this.mEditInfo, 2);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.a
    public void updateEditTextAndNum(CharSequence charSequence) {
        String charSequence2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) charSequence);
            return;
        }
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence.toString();
        }
        QQText qQText = new QQText(new SpannableStringBuilder(charSequence2), 3);
        boolean z16 = false;
        if (TextUtils.isEmpty(qQText)) {
            this.mNum.setText(String.format("%d\u5b57", Integer.valueOf(this.mMaxNum)));
            this.mNum.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
            updateRightViewTextEnable(this.mCanPostNull);
            return;
        }
        int length = getLength(qQText);
        if (this.mMaxLimitMode == 1 && length > this.mMaxNum && (charSequence instanceof Editable)) {
            try {
                com.tencent.mobileqq.text.TextUtils.backspace(this.mEditInfo);
                return;
            } catch (Throwable th5) {
                QLog.i(TAG, 1, th5.toString());
            }
        }
        this.mNum.setText(String.format("%d/%d\u5b57", Integer.valueOf(length), Integer.valueOf(this.mMaxNum)));
        if (length >= this.mMaxNum) {
            this.mNum.setTextColor(getResources().getColor(R.color.qui_common_feedback_error));
        } else {
            this.mNum.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        }
        if (length <= this.mMaxNum) {
            z16 = true;
        }
        updateRightViewTextEnable(z16);
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return true;
    }

    private int getLength(QQText qQText) {
        com.tencent.mobileqq.troop.activity.editinfo.b bVar;
        int length;
        if (qQText == null || (bVar = this.editInfoApi) == null) {
            return 0;
        }
        try {
            int i3 = this.mCountType;
            if (i3 == 2) {
                length = bVar.d();
            } else if (i3 == 0) {
                length = qQText.toString().getBytes("utf-8").length;
            } else {
                length = qQText.toString().length();
            }
            return length;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return 0;
            }
            QLog.e(TAG, 2, "getLength error" + e16);
            return 0;
        }
    }
}
