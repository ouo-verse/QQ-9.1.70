package com.tencent.biz.troop;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import h53.QUIInputCountCalculateStrategy;
import h53.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EditUniqueTitleActivity extends IphoneTitleBarActivity implements View.OnClickListener {

    /* renamed from: c0, reason: collision with root package name */
    protected String f96592c0;

    /* renamed from: d0, reason: collision with root package name */
    protected String f96593d0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f96594e0;

    /* renamed from: f0, reason: collision with root package name */
    protected String f96595f0;

    /* renamed from: g0, reason: collision with root package name */
    protected String f96596g0;

    /* renamed from: h0, reason: collision with root package name */
    protected QUISingleLineInputView f96597h0;

    /* renamed from: i0, reason: collision with root package name */
    protected View f96598i0;

    /* renamed from: l0, reason: collision with root package name */
    protected QQProgressDialog f96601l0;

    /* renamed from: a0, reason: collision with root package name */
    protected final int f96590a0 = 6;

    /* renamed from: b0, reason: collision with root package name */
    protected int f96591b0 = 0;

    /* renamed from: j0, reason: collision with root package name */
    boolean f96599j0 = true;

    /* renamed from: k0, reason: collision with root package name */
    protected q f96600k0 = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            EditUniqueTitleActivity.this.K2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f96608d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f96609e;

        d(String str, String str2) {
            this.f96608d = str;
            this.f96609e = str2;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            QLog.i("EditUniqueTitleActivity", 1, "setUniqueTitle, onReceive. type=" + i3 + ", isSuccess=" + z16);
            if (!z16) {
                EditUniqueTitleActivity.this.P2(-1);
            } else {
                EditUniqueTitleActivity.this.T2(this.f96608d, this.f96609e, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f96611a;

        static {
            int[] iArr = new int[BaseAction.values().length];
            f96611a = iArr;
            try {
                iArr[BaseAction.ACTION_LEFT_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f96611a[BaseAction.ACTION_RIGHT_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Intent J2(Context context, int i3, String str, String str2, int i16, String str3) {
        Intent intent = new Intent(context, (Class<?>) EditUniqueTitleActivity.class);
        intent.putExtra("from", String.valueOf(i3));
        intent.putExtra("memberUin", str2);
        intent.putExtra("troopUin", str);
        intent.putExtra("memberRole", i16);
        intent.putExtra("uniqueTitle", str3);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2() {
        String str;
        String str2;
        String charSequence = this.f96597h0.d().toString();
        this.f96596g0 = charSequence;
        int i3 = this.f96594e0;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (!TextUtils.isEmpty(charSequence) && !charSequence.equals(getString(R.string.i8r))) {
                        R2(this.f96593d0, this.f96592c0, this.f96596g0);
                        return;
                    }
                    if ((TextUtils.isEmpty(charSequence) && (str2 = this.f96595f0) != null && str2.equals(getString(R.string.i8r))) || ((TextUtils.isEmpty(this.f96595f0) && charSequence != null && charSequence.equals(getString(R.string.i8r))) || ((!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.f96595f0) && charSequence.equals(getString(R.string.i8r)) && this.f96595f0.equals(charSequence)) || (TextUtils.isEmpty(charSequence) && TextUtils.isEmpty(this.f96595f0))))) {
                        finish();
                        return;
                    } else {
                        this.f96596g0 = "";
                        R2(this.f96593d0, this.f96592c0, "");
                        return;
                    }
                }
                return;
            }
            if (!TextUtils.isEmpty(charSequence) && !charSequence.equals(getString(R.string.c7d))) {
                R2(this.f96593d0, this.f96592c0, this.f96596g0);
                return;
            }
            if ((TextUtils.isEmpty(charSequence) && (str = this.f96595f0) != null && str.equals(getString(R.string.c7d))) || ((TextUtils.isEmpty(this.f96595f0) && charSequence != null && charSequence.equals(getString(R.string.c7d))) || ((!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.f96595f0) && charSequence.equals(getString(R.string.c7d)) && this.f96595f0.equals(charSequence)) || (TextUtils.isEmpty(charSequence) && TextUtils.isEmpty(this.f96595f0))))) {
                finish();
                return;
            } else {
                this.f96596g0 = "";
                R2(this.f96593d0, this.f96592c0, "");
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            R2(this.f96593d0, this.f96592c0, this.f96596g0);
        } else if (TextUtils.isEmpty(this.f96595f0)) {
            finish();
        } else {
            this.f96596g0 = "";
            R2(this.f96593d0, this.f96592c0, "");
        }
    }

    private void L2() {
        this.quiSecNavBar.setCenterType(1);
        this.quiSecNavBar.setCenterText(getString(R.string.dsu));
        this.quiSecNavBar.setLeftType(1);
        this.quiSecNavBar.setLeftText(getString(R.string.cancel));
        this.quiSecNavBar.setRightType(1);
        this.quiSecNavBar.setRightText(getString(R.string.b9f));
        this.quiSecNavBar.setOnBaseTitleBarClickListener(new Function2() { // from class: com.tencent.biz.troop.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit M2;
                M2 = EditUniqueTitleActivity.this.M2((View) obj, (BaseAction) obj2);
                return M2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit M2(View view, BaseAction baseAction) {
        int i3 = e.f96611a[baseAction.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                N2();
                return null;
            }
            return null;
        }
        onBackEvent();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2(int i3) {
        if (this.f96591b0 != 2) {
            hideJuhua();
        }
        QLog.i("EditUniqueTitleActivity", 1, "onSetUniqueTitle, errCode=" + i3);
        if (i3 == 0) {
            ((TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER)).z0(this.f96593d0, this.f96592c0, false);
            ((TroopInfoHandler) this.app.getBusinessHandler(TroopInfoHandler.class.getName())).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_MEMBER_LEVEL_INFO_CHANGED, true, this.f96593d0);
            if (this.f96591b0 == 2) {
                QQToast.makeText(this, getResources().getString(R.string.dvm), 1).show();
            }
            Intent intent = getIntent();
            intent.putExtra("newUniqueTitle", this.f96596g0);
            setResult(-1, intent);
            finish();
            this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_SETTING_HANDLER).notifyUI(com.tencent.mobileqq.troop.troopsetting.api.b.C, true, new Object[]{this.f96593d0, this.f96592c0, this.f96596g0});
            return;
        }
        if (this.f96591b0 == 2) {
            setResult(0, getIntent());
            finish();
            QQToast.makeText(this, getResources().getString(R.string.dvn), 1).show();
        } else if (i3 == 1281) {
            QQToast.makeText(this, getResources().getString(R.string.dvk), 1).show();
        } else {
            QQToast.makeText(this, getResources().getString(R.string.dvo), 1).show();
        }
    }

    public static void Q2(QQAppInterface qQAppInterface, String str, String str2, String str3, BusinessObserver businessObserver) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Oidb_0x8fc$ReqBody oidb_0x8fc$ReqBody = new Oidb_0x8fc$ReqBody();
            Oidb_0x8fc$MemberInfo oidb_0x8fc$MemberInfo = new Oidb_0x8fc$MemberInfo();
            try {
                String troopMemberNickNoEmpty = ((IBizTroopMemberInfoService) qQAppInterface.getRuntimeService(IBizTroopMemberInfoService.class, "")).getTroopMemberNickNoEmpty(str, str2);
                oidb_0x8fc$ReqBody.uint64_group_code.set(Long.parseLong(str));
                oidb_0x8fc$MemberInfo.uint64_uin.set(Long.parseLong(str2));
                oidb_0x8fc$MemberInfo.bytes_uin_name.set(ByteStringMicro.copyFromUtf8(troopMemberNickNoEmpty));
                if (str3 != null) {
                    oidb_0x8fc$MemberInfo.bytes_special_title.set(ByteStringMicro.copyFromUtf8(str3));
                }
                oidb_0x8fc$MemberInfo.uint32_special_title_expire_time.set(-1);
                oidb_0x8fc$ReqBody.rpt_mem_level_info.add(oidb_0x8fc$MemberInfo);
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.uint32_command.set(2300);
                oidb_sso_oidbssopkg.uint32_service_type.set(2);
                oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x8fc$ReqBody.toByteArray()));
                NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), com.tencent.biz.m.class);
                newIntent.putExtra("cmd", "OidbSvc.0x8fc_2");
                newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
                newIntent.setObserver(businessObserver);
                qQAppInterface.startServlet(newIntent);
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("EditUniqueTitleActivity", 2, "setUniqueTitle exp", e16);
                }
            }
        }
    }

    private void R2(String str, String str2, String str3) {
        QLog.i("EditUniqueTitleActivity", 1, "setUniqueTitle, gc=" + str + ", memberUin=" + str2 + ", from=" + this.f96591b0);
        if (str3.equals(this.f96595f0)) {
            if (QLog.isColorLevel()) {
                QLog.d("EditUniqueTitleActivity", 2, "setUniqueTitle, equals and return");
            }
            finish();
        } else {
            if (this.f96591b0 != 2) {
                S2();
            }
            Q2(this.app, str, str2, str3, new d(str, str2));
        }
    }

    private void fillData() {
        if (!TextUtils.isEmpty(this.f96595f0)) {
            this.f96597h0.setContentText(this.f96595f0);
        }
        QUISingleLineInputView qUISingleLineInputView = this.f96597h0;
        qUISingleLineInputView.setTextSelection(qUISingleLineInputView.e());
    }

    private boolean init() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return false;
        }
        try {
            this.f96591b0 = Integer.parseInt(intent.getStringExtra("from"));
            this.f96592c0 = intent.getStringExtra("memberUin");
            this.f96593d0 = intent.getStringExtra("troopUin");
            this.f96594e0 = intent.getIntExtra("memberRole", 1);
            this.f96595f0 = intent.getStringExtra("uniqueTitle");
            if (this.f96591b0 != 2) {
                return true;
            }
            ReportController.o(this.app, "P_CliOper", "Grp_manage", "", "grp_aio", "Clk_expire", 0, 0, this.f96593d0, "", "", "");
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    protected void N2() {
        QLog.i("EditUniqueTitleActivity", 1, "[onCompleteBtnClick] start");
        ReportController.o(this.app, "dc00899", "Grp_title", "", "grp_data", "clk_finish", 0, 0, "", "", "", "");
        String charSequence = this.f96597h0.d().toString();
        if (!TextUtils.isEmpty(this.f96595f0) && TextUtils.isEmpty(charSequence)) {
            DialogUtil.createNoTitleDialog(this, getString(R.string.drj), R.string.cancel, R.string.dri, new b(), new c()).show();
        } else {
            K2();
        }
    }

    public void S2() {
        try {
            if (this.f96601l0 == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
                this.f96601l0 = qQProgressDialog;
                qQProgressDialog.setMessage(R.string.cpr);
                this.f96601l0.setBackAndSearchFilter(false);
            }
            this.f96601l0.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("EditUniqueTitleActivity", 2, e16.toString());
            }
        }
    }

    public void T2(String str, String str2, final Bundle bundle) {
        if (bundle == null) {
            QLog.e("EditUniqueTitleActivity", 1, "bundle is null");
        } else {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(str, str2, true, null, "EditUniqueTitleActivity", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.biz.troop.EditUniqueTitleActivity.5
                @Override // com.tencent.qqnt.troopmemberlist.g
                public void a(@Nullable TroopMemberInfo troopMemberInfo) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EditUniqueTitleActivity", 2, "setUniqueTitle, fetchTroopMemberInfo completed.");
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.troop.EditUniqueTitleActivity.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            byte[] byteArray = bundle.getByteArray("data");
                            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                            try {
                                oidb_sso_oidbssopkg.mergeFrom(byteArray);
                                EditUniqueTitleActivity.this.P2(oidb_sso_oidbssopkg.uint32_result.get());
                            } catch (InvalidProtocolBufferMicroException unused) {
                                EditUniqueTitleActivity.this.P2(-1);
                            }
                        }
                    });
                }
            });
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
        super.doOnCreate(bundle);
        if (!init()) {
            finish();
            return false;
        }
        super.setContentView(R.layout.ahy);
        L2();
        QUISingleLineInputView qUISingleLineInputView = (QUISingleLineInputView) findViewById(R.id.bsi);
        this.f96597h0 = qUISingleLineInputView;
        qUISingleLineInputView.setInputViewWatcher(this.f96600k0);
        this.f96597h0.setCalculateStrategy(new QUIInputCountCalculateStrategy(2.0d, 2.0d, 1.0d, 1.0d));
        this.f96599j0 = "1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
        View findViewById = findViewById(R.id.i8o);
        this.f96598i0 = findViewById;
        findViewById.setOnClickListener(this);
        int i3 = this.f96594e0;
        if (i3 == 2) {
            String string = getString(R.string.c7d);
            if (!TextUtils.isEmpty(this.f96595f0) && !string.equals(this.f96595f0)) {
                ReportController.o(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.f96593d0, "", "", "");
            }
        } else if (i3 == 3) {
            String string2 = getString(R.string.i8r);
            if (!TextUtils.isEmpty(this.f96595f0) && !string2.equals(this.f96595f0)) {
                ReportController.o(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.f96593d0, "", "", "");
            }
        }
        ReportController.o(this.app, "dc00899", "Grp_title", "", "grp_data", "edit_exp", 0, 0, "", "", "", "");
        fillData();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        QUISingleLineInputView qUISingleLineInputView = this.f96597h0;
        if (qUISingleLineInputView != null) {
            qUISingleLineInputView.q();
        }
    }

    public void hideJuhua() {
        try {
            QQProgressDialog qQProgressDialog = this.f96601l0;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.f96601l0.dismiss();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("EditUniqueTitleActivity", 2, e16.toString());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.i8o) {
            this.f96596g0 = "";
            R2(this.f96593d0, this.f96592c0, "");
            ReportController.o(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "suc_title", 0, 0, this.f96593d0, "0", "0", "0");
            ReportController.o(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_default", 0, 0, this.f96593d0, "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements q {
        a() {
        }

        @Override // h53.k
        public void afterTextChanged(Editable editable) {
            int length = EditUniqueTitleActivity.this.f96597h0.d().toString().length();
            ThemeUtil.getCurrentThemeInfo().getString("themeId");
            if (length > 6) {
                EditUniqueTitleActivity.this.quiSecNavBar.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, false);
            } else {
                EditUniqueTitleActivity.this.quiSecNavBar.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, true);
            }
        }

        @Override // h53.q
        public void A4(@Nullable String str) {
        }

        @Override // h53.k
        public void f8(boolean z16) {
        }

        @Override // h53.k
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // h53.k
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
