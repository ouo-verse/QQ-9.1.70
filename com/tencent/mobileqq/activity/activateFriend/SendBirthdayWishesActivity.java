package com.tencent.mobileqq.activity.activateFriend;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SendBirthdayWishesActivity extends IphoneTitleBarActivity implements View.OnClickListener, TextWatcher, XPanelContainer.g, EmoticonCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    ActivateFriendsManager f177923a0;

    /* renamed from: b0, reason: collision with root package name */
    ImageButton f177924b0;

    /* renamed from: c0, reason: collision with root package name */
    Button f177925c0;

    /* renamed from: d0, reason: collision with root package name */
    EditText f177926d0;

    /* renamed from: e0, reason: collision with root package name */
    XPanelContainer f177927e0;

    /* renamed from: f0, reason: collision with root package name */
    View f177928f0;

    /* renamed from: g0, reason: collision with root package name */
    TextView f177929g0;

    /* renamed from: h0, reason: collision with root package name */
    ActivateFriendGrid f177930h0;

    /* renamed from: i0, reason: collision with root package name */
    int f177931i0;

    /* renamed from: j0, reason: collision with root package name */
    long[] f177932j0;

    /* renamed from: k0, reason: collision with root package name */
    long[] f177933k0;

    /* renamed from: l0, reason: collision with root package name */
    private MqqHandler f177934l0;

    /* renamed from: m0, reason: collision with root package name */
    QQProgressDialog f177935m0;

    /* renamed from: n0, reason: collision with root package name */
    com.tencent.mobileqq.app.activateFriends.b f177936n0;

    /* renamed from: o0, reason: collision with root package name */
    private Runnable f177937o0;

    /* renamed from: p0, reason: collision with root package name */
    boolean f177938p0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SendBirthdayWishesActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(SendBirthdayWishesActivity.this.app, "CliOper", "", "", "0X8004E0A", "0X8004E0A", 0, 0, "", "", "", "");
                SendBirthdayWishesActivity.this.setResult(0);
                SendBirthdayWishesActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends com.tencent.mobileqq.app.activateFriends.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SendBirthdayWishesActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.activateFriends.b
        public void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            SendBirthdayWishesActivity.this.dismissWaittingDialog();
            SendBirthdayWishesActivity.this.J2(i3);
            SendBirthdayWishesActivity sendBirthdayWishesActivity = SendBirthdayWishesActivity.this;
            sendBirthdayWishesActivity.f177926d0.removeTextChangedListener(sendBirthdayWishesActivity);
            SendBirthdayWishesActivity.this.f177926d0.setText("");
            if (SendBirthdayWishesActivity.this.f177927e0.m() != 0) {
                SendBirthdayWishesActivity.this.f177927e0.s();
            }
            if (i3 != 2) {
                SendBirthdayWishesActivity.this.f177934l0.removeCallbacks(SendBirthdayWishesActivity.this.f177937o0);
                SendBirthdayWishesActivity.this.f177934l0.postDelayed(SendBirthdayWishesActivity.this.f177937o0, 600L);
            }
        }
    }

    public SendBirthdayWishesActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177931i0 = 1;
        this.f177934l0 = new MqqHandler(Looper.getMainLooper());
        this.f177936n0 = new b();
        this.f177937o0 = new Runnable() { // from class: com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SendBirthdayWishesActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (!SendBirthdayWishesActivity.this.isFinishing()) {
                    SendBirthdayWishesActivity.this.setResult(-1);
                    SendBirthdayWishesActivity.this.finish();
                }
            }
        };
        this.f177938p0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2(int i3) {
        int i16;
        int i17 = this.f177931i0;
        int i18 = 2;
        if (i17 == 2) {
            if (i3 == 0) {
                if (i17 == 1) {
                    i16 = R.string.f170152hg;
                } else {
                    i16 = R.string.f170150he;
                }
            } else if (i3 == 1) {
                i16 = R.string.f170169hx;
                i18 = 0;
            } else if (i3 == 2) {
                i16 = R.string.f170164hs;
                i18 = 1;
            } else {
                i16 = 0;
                i18 = 0;
            }
            QQToast.makeText(this, i18, i16, 1).show(getTitleBarHeight());
        }
    }

    private void fillData() {
        String string;
        int i3 = 0;
        if (this.f177931i0 == 1) {
            string = String.format(getString(R.string.f170165ht), getIntent().getStringExtra("key_roam_city"));
        } else {
            try {
                string = ActivateFriendsManager.o(this);
            } catch (Exception unused) {
                string = getString(R.string.f170158hm);
            }
        }
        this.f177926d0.setText(string);
        this.f177926d0.setSelection(string.length());
        this.f177926d0.addTextChangedListener(this);
        ArrayList<ActivateFriendItem> arrayList = new ArrayList<>(this.f177932j0.length);
        while (true) {
            long[] jArr = this.f177932j0;
            if (i3 < jArr.length) {
                ActivateFriendItem activateFriendItem = new ActivateFriendItem(this.f177931i0, jArr[i3]);
                if (this.f177931i0 == 2) {
                    activateFriendItem.birthSendTime = this.f177933k0[i3];
                }
                arrayList.add(activateFriendItem);
                i3++;
            } else {
                this.f177930h0.setData(this.app, arrayList);
                return;
            }
        }
    }

    private void initViews() {
        String string;
        Drawable drawable;
        int i3;
        int i16;
        setRightHighlightButton(R.string.cancel, new a());
        int i17 = this.f177931i0;
        if (i17 == 1) {
            if (this.f177932j0.length == 1) {
                i16 = R.string.f170167hv;
            } else {
                i16 = R.string.f170168hw;
            }
            string = getString(i16);
        } else if (i17 == 3) {
            string = "";
        } else {
            string = getString(R.string.f170166hu);
        }
        setTitle(string);
        enableRightHighlight(true);
        this.leftView.setVisibility(8);
        EditText editText = (EditText) findViewById(R.id.input);
        this.f177926d0 = editText;
        editText.setMaxLines(8);
        this.f177926d0.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        XPanelContainer xPanelContainer = (XPanelContainer) findViewById(R.id.root);
        this.f177927e0 = xPanelContainer;
        xPanelContainer.setOnPanelChangeListener(this);
        this.f177927e0.c(this.f177926d0);
        try {
            drawable = getResources().getDrawable(R.drawable.chat_bg_texture);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
            drawable = getResources().getDrawable(R.drawable.gub);
        }
        this.f177927e0.setBackgroundDrawable(drawable);
        ImageButton imageButton = (ImageButton) findViewById(R.id.emo_btn);
        this.f177924b0 = imageButton;
        imageButton.setOnClickListener(this);
        Button button = (Button) findViewById(R.id.fun_btn);
        this.f177925c0 = button;
        button.setOnClickListener(this);
        View findViewById = findViewById(R.id.ivTitleBtnLeft);
        this.f177928f0 = findViewById;
        findViewById.setOnClickListener(this);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.skin_aio_send_button_pressed));
        stateListDrawable.addState(new int[0], getResources().getDrawable(R.drawable.skin_aio_send_button_normal));
        this.f177925c0.setBackgroundDrawable(stateListDrawable);
        boolean booleanValue = ((Boolean) SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue();
        View findViewById2 = findViewById(R.id.inputBar);
        if (booleanValue) {
            View findViewById3 = findViewById2.findViewById(R.id.ix5);
            findViewById3.setBackgroundResource(R.drawable.chat_input_bar_bg_big);
            findViewById3.setVisibility(0);
            findViewById2.getBackground().setVisible(false, false);
        } else {
            findViewById2.getBackground().setVisible(true, false);
            findViewById2.findViewById(R.id.ix5).setVisibility(8);
        }
        TextView textView = (TextView) findViewById(R.id.ink);
        this.f177929g0 = textView;
        if (this.f177931i0 == 1) {
            i3 = R.string.f170171hz;
        } else {
            i3 = R.string.f170170hy;
        }
        textView.setText(i3);
        this.f177929g0.setBackgroundColor(getResources().getColor(R.color.skin_activate_tips));
        ActivateFriendGrid activateFriendGrid = (ActivateFriendGrid) findViewById(R.id.cnn);
        this.f177930h0 = activateFriendGrid;
        activateFriendGrid.setCheckAbilityEnable(false);
        this.f177930h0.setSkinable(true);
        View findViewById4 = findViewById(R.id.f165299cp0);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f177929g0.getText());
        for (long j3 : this.f177932j0) {
            sb5.append(com.tencent.mobileqq.utils.ac.y(this.app, String.valueOf(j3)));
            sb5.append(",");
        }
        findViewById4.setContentDescription(sb5.toString());
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            ((IAIOEmoticonPanelService) QRoute.api(IAIOEmoticonPanelService.class)).removeStickerMask(this.f177927e0.n());
        }
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public View E2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        if (i3 == 2) {
            SystemEmoticonPanel systemEmoticonPanel = new SystemEmoticonPanel(this, this);
            View findViewById = systemEmoticonPanel.findViewById(R.id.f166754hv2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.bottomMargin = BaseAIOUtils.f(15.0f, getResources());
            findViewById.setLayoutParams(layoutParams);
            systemEmoticonPanel.setBackgroundResource(R.drawable.qfav_entry_emo_bg);
            return systemEmoticonPanel;
        }
        return null;
    }

    void K2() {
        if (this.f177935m0 == null) {
            this.f177935m0 = new QQProgressDialog(this, getTitleBarHeight());
        }
        this.f177935m0.setMessage(R.string.f170005co);
        this.f177935m0.show();
        this.f177935m0.setCancelable(false);
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public boolean T(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, i3)).booleanValue();
        }
        return false;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) editable);
        } else if (!this.f177938p0) {
            ReportController.o(this.app, "CliOper", "", "", "0X8004E0B", "0X8004E0B", 0, 0, "", "", "", "");
            this.f177938p0 = true;
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.f177926d0.getSelectionStart() == 0) {
            return;
        }
        try {
            Editable editableText = this.f177926d0.getEditableText();
            int selectionStart = this.f177926d0.getSelectionStart();
            int offsetBefore = TextUtils.getOffsetBefore(this.f177926d0.getText(), selectionStart);
            if (selectionStart != offsetBefore) {
                editableText.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    void dismissWaittingDialog() {
        QQProgressDialog qQProgressDialog = this.f177935m0;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.aqm);
        getWindow().setBackgroundDrawable(null);
        getWindow().setSoftInputMode(20);
        this.f177923a0 = (ActivateFriendsManager) this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        this.f177931i0 = getIntent().getIntExtra("key_msg_type", this.f177931i0);
        this.f177932j0 = getIntent().getLongArrayExtra("key_friend_list");
        long[] longArrayExtra = getIntent().getLongArrayExtra("key_time_list");
        this.f177933k0 = longArrayExtra;
        long[] jArr = this.f177932j0;
        if (jArr != null && jArr.length != 0 && (this.f177931i0 != 2 || (longArrayExtra != null && jArr.length == longArrayExtra.length))) {
            initViews();
            fillData();
            this.app.registObserver(this.f177936n0);
            return true;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("intent data is invaild, msgType = ");
            sb5.append(this.f177931i0);
            sb5.append(" | uin count = ");
            long[] jArr2 = this.f177932j0;
            int i16 = -1;
            if (jArr2 != null) {
                i3 = jArr2.length;
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            sb5.append(" | time count = ");
            long[] jArr3 = this.f177933k0;
            if (jArr3 != null) {
                i16 = jArr3.length;
            }
            sb5.append(i16);
            QLog.d("ActivateFriend.SendActivity", 2, sb5.toString());
        }
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        this.app.unRegistObserver(this.f177936n0);
        this.f177930h0.i();
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(0, R.anim.f154423k);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (this.f177927e0.m() != 0) {
            this.f177927e0.s();
            return true;
        }
        ReportController.o(this.app, "CliOper", "", "", "0X8004E0A", "0X8004E0A", 0, 0, "", "", "", "");
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (view == this.f177924b0) {
            if (this.f177927e0.m() == 2) {
                this.f177927e0.N(1);
            } else {
                this.f177927e0.N(2);
            }
        } else if (view == this.f177925c0) {
            String obj = this.f177926d0.getEditableText().toString();
            if (obj.length() != 0) {
                if (!NetworkUtil.isNetSupport(this)) {
                    QQToast.makeText(this, R.string.f171139ci4, 0).show(getTitleBarHeight());
                } else {
                    ArrayList<String> a06 = BusinessUtils.a0(obj, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA, 20, null, new ArrayList());
                    if (QLog.isColorLevel() && a06.size() > 1) {
                        QLog.d("ActivateFriend.SendActivity", 2, "onclick | bytes = " + obj.getBytes().length + " | partArray.size = " + a06.size());
                    }
                    if (a06.size() > 1) {
                        QQToast.makeText(this, R.string.her, 0).show(getTitleBarHeight());
                    } else {
                        this.f177923a0.J(this.f177931i0, this.f177932j0, this.f177933k0, obj);
                        ReportController.o(this.app, "CliOper", "", "", "0X8004E09", "0X8004E09", 0, 0, this.f177932j0.length + "", "", "", "");
                        ReportController.o(this.app, "dc00898", "", "", "0X8007AE9", "0X8007AE9", this.f177932j0.length, 0, "", "", "", "");
                        K2();
                    }
                }
            }
        } else if (view == this.f177928f0) {
            if (this.f177927e0.m() == 1) {
                this.f177927e0.s();
            }
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onHidePopup(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) emoticonInfo);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public boolean onLongClick(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) emoticonInfo)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public void onPanelChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i16 == 2) {
            ((IAIOEmoticonPanelService) QRoute.api(IAIOEmoticonPanelService.class)).setOpenStartTime(System.currentTimeMillis());
            ei.a(null, "AIO_EmoticonPanel_OpenDuration");
        }
        this.f177934l0.post(new Runnable(i16) { // from class: com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f177939d;

            {
                this.f177939d = i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SendBirthdayWishesActivity.this, i16);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (this.f177939d == 2) {
                    SendBirthdayWishesActivity.this.f177924b0.setImageResource(R.drawable.f160147bi);
                    SendBirthdayWishesActivity.this.f177924b0.setContentDescription(HardCodeUtil.qqStr(R.string.t_w));
                } else {
                    SendBirthdayWishesActivity.this.f177924b0.setImageResource(R.drawable.asw);
                    SendBirthdayWishesActivity.this.f177924b0.setContentDescription(HardCodeUtil.qqStr(R.string.t_x));
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, emoticonInfo, emoticonInfo2, drawable);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) emoticonInfo);
            return;
        }
        if (emoticonInfo instanceof SystemEmoticonInfo) {
            int selectionStart = this.f177926d0.getSelectionStart();
            int selectionEnd = this.f177926d0.getSelectionEnd();
            if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                return;
            }
            this.f177926d0.getEditableText().replace(selectionStart, selectionEnd, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo) emoticonInfo).code));
        }
    }
}
