package com.tencent.biz.pubaccount.accountdetail.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse;

/* loaded from: classes32.dex */
public class PubAccountMoreInfoActivity extends IphoneTitleBarActivity {

    /* renamed from: a0, reason: collision with root package name */
    PublicAccountDetailImpl f78847a0;

    /* renamed from: b0, reason: collision with root package name */
    String f78848b0;

    /* renamed from: c0, reason: collision with root package name */
    AccountDetailGroupListContainer f78849c0;

    /* renamed from: d0, reason: collision with root package name */
    ScrollView f78850d0;

    /* renamed from: e0, reason: collision with root package name */
    float f78851e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f78852f0;

    /* renamed from: g0, reason: collision with root package name */
    protected NewIntent f78853g0;

    /* renamed from: h0, reason: collision with root package name */
    protected BusinessObserver f78854h0;

    /* renamed from: i0, reason: collision with root package name */
    mobileqq_mp$GetPublicAccountDetailInfoResponse f78855i0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements BusinessObserver {
        a() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            boolean convert0xcf8ToMobileMP;
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountMoreInfoActivity", 2, "success:" + String.valueOf(z16));
            }
            if (!z16) {
                PubAccountMoreInfoActivity.this.displayToast(R.string.d6b);
                return;
            }
            try {
                byte[] byteArray = bundle.getByteArray("data");
                int i16 = bundle.getInt("type", 0);
                if (byteArray != null) {
                    mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse = new mobileqq_mp$GetPublicAccountDetailInfoResponse();
                    oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse oidb_cmd0xcf8_getpublicaccountdetailinforesponse = new oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse();
                    if (i16 == 0) {
                        mobileqq_mp_getpublicaccountdetailinforesponse.mergeFrom(byteArray);
                        convert0xcf8ToMobileMP = true;
                    } else {
                        convert0xcf8ToMobileMP = PublicAccountUtilImpl.convert0xcf8ToMobileMP(byteArray, oidb_cmd0xcf8_getpublicaccountdetailinforesponse, mobileqq_mp_getpublicaccountdetailinforesponse);
                    }
                    if (convert0xcf8ToMobileMP) {
                        if (mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.get() == 0) {
                            if (PubAccountMoreInfoActivity.this.f78847a0 == null || (mobileqq_mp_getpublicaccountdetailinforesponse.seqno.has() && mobileqq_mp_getpublicaccountdetailinforesponse.seqno.get() != PubAccountMoreInfoActivity.this.f78847a0.seqno)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("PubAccountMoreInfoActivity", 2, "sendPublicAccountDetailInfoRequest: need update local data , new seqno = " + mobileqq_mp_getpublicaccountdetailinforesponse.seqno.get());
                                }
                                PubAccountMoreInfoActivity pubAccountMoreInfoActivity = PubAccountMoreInfoActivity.this;
                                pubAccountMoreInfoActivity.f78855i0 = mobileqq_mp_getpublicaccountdetailinforesponse;
                                pubAccountMoreInfoActivity.f78847a0 = new PublicAccountDetailImpl();
                                PubAccountMoreInfoActivity pubAccountMoreInfoActivity2 = PubAccountMoreInfoActivity.this;
                                pubAccountMoreInfoActivity2.f78847a0.init(pubAccountMoreInfoActivity2.f78855i0);
                                PubAccountMoreInfoActivity.this.updateView();
                                return;
                            }
                            return;
                        }
                        PubAccountMoreInfoActivity.this.displayToast(R.string.d6b);
                    }
                }
            } catch (Exception unused) {
                PubAccountMoreInfoActivity.this.displayToast(R.string.d6b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        AccountDetailGroupListContainer accountDetailGroupListContainer = new AccountDetailGroupListContainer(this.app, this, this.f78848b0, this.f78847a0, true);
        this.f78849c0 = accountDetailGroupListContainer;
        this.f78850d0.addView(accountDetailGroupListContainer.L());
    }

    public void displayToast(int i3) {
        QQToast.makeText(getApplicationContext(), i3, 0).show();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        init();
        initView();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        AccountDetailGroupListContainer accountDetailGroupListContainer = this.f78849c0;
        if (accountDetailGroupListContainer != null) {
            accountDetailGroupListContainer.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
    }

    protected void init() {
        if (QLog.isColorLevel()) {
            QLog.d("PubAccountMoreInfoActivity", 2, "init");
        }
        Intent intent = getIntent();
        this.app = (QQAppInterface) super.getAppRuntime();
        if (intent != null) {
            this.f78848b0 = intent.getStringExtra("uin");
        }
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null) {
            this.f78847a0 = (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfo(this.f78848b0);
        }
        if (this.f78847a0 == null) {
            sendPublicAccountDetailInfoRequest();
        }
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    void sendPublicAccountDetailInfoRequest() {
        if (QLog.isColorLevel()) {
            QLog.d("PubAccountMoreInfoActivity", 2, "sendPublicAccountDetailInfoRequest");
        }
        NewIntent newIntent = this.f78853g0;
        if (newIntent != null) {
            newIntent.setObserver(null);
        }
        NewIntent newIntent2 = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
        this.f78853g0 = newIntent2;
        newIntent2.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_DETAIL_INFO);
        mobileqq_mp$GetPublicAccountDetailInfoRequest mobileqq_mp_getpublicaccountdetailinforequest = new mobileqq_mp$GetPublicAccountDetailInfoRequest();
        mobileqq_mp_getpublicaccountdetailinforequest.versionInfo.set(AppSetting.f99551k + ",3," + AppSetting.f99542b);
        mobileqq_mp_getpublicaccountdetailinforequest.version.set(1);
        PublicAccountDetailImpl publicAccountDetailImpl = this.f78847a0;
        if (publicAccountDetailImpl != null) {
            mobileqq_mp_getpublicaccountdetailinforequest.seqno.set(publicAccountDetailImpl.seqno);
        } else {
            mobileqq_mp_getpublicaccountdetailinforequest.seqno.set(0);
        }
        try {
            mobileqq_mp_getpublicaccountdetailinforequest.uin.set((int) Long.parseLong(this.f78848b0));
        } catch (Exception unused) {
        }
        this.f78853g0.putExtra("data", mobileqq_mp_getpublicaccountdetailinforequest.toByteArray());
        a aVar = new a();
        this.f78854h0 = aVar;
        this.f78853g0.setObserver(aVar);
        this.app.startServlet(this.f78853g0);
    }

    private void initView() {
        super.setContentView(R.layout.f167515e);
        this.f78850d0 = (ScrollView) super.findViewById(R.id.if5);
        setTitle(getResources().getString(R.string.d6_));
        this.f78852f0 = super.findViewById(R.id.gmw);
        if (QQTheme.isNowThemeIsNight()) {
            View view = this.f78852f0;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this.f78852f0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        this.f78851e0 = super.getResources().getDisplayMetrics().density;
        PublicAccountDetailImpl publicAccountDetailImpl = this.f78847a0;
        if (publicAccountDetailImpl != null) {
            AccountDetailGroupListContainer accountDetailGroupListContainer = new AccountDetailGroupListContainer(this.app, this, this.f78848b0, publicAccountDetailImpl, true);
            this.f78849c0 = accountDetailGroupListContainer;
            this.f78850d0.addView(accountDetailGroupListContainer.L());
        }
    }
}
