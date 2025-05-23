package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks$QQProtectRisksRequest;
import com.tencent.ims.QQProtectRisks$QQProtectRisksResponse;
import com.tencent.ims.QQProtectRisks$RiskInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsec.account.RiskInfoItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.api.IQPMiscUtilsApi;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

/* compiled from: P */
@RoutePage(desc = "\u8d26\u53f7\u98ce\u9669\u4fe1\u606f\u9875", path = RouterConstants.UI_ROUTER_RISK_INFO)
/* loaded from: classes9.dex */
public class RiskInfoActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final String CONST_ALL_ITEMS = "ALL";
    public static final int ITEM_TYPE_GUIDE_CHANGE_MIBAO_PHONE = 6;
    public static final int ITEM_TYPE_NO_BIND_PHONE = 5;
    public static final int ITEM_TYPE_NO_LOGIN_PROTECT = 1;
    public static final int ITEM_TYPE_NO_SECRET_PHONE = 4;
    private static final int REQ_CODE_PHONE_UNITY_BIND_INFO = 2001;
    private static final String TAG = "RiskInfoDetails";
    private static final int TAG_RISK_INFO_DATA = 2017021601;
    private static final String TARGET_DEVLOCK = "devlock";
    private static final String TARGET_HTTP_URL = "http";
    private static final String TARGET_PHONEBIND = "phonebind";
    private static final String TARGET_PICKPROOF = "pickproof";
    private static final String TARGET_QQIMPROTECT = "qpimprotect";
    private DevlockInfo mDevlockInfo;
    private List<RiskInfoItem> mRiskInfoItems;
    private LinearLayout mRiskInfoListLayout;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RiskInfoActivity.this);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            HashMap hashMap = new HashMap();
            if (i3 == 0 && bArr != null) {
                try {
                    QQProtectRisks$QQProtectRisksResponse qQProtectRisks$QQProtectRisksResponse = new QQProtectRisks$QQProtectRisksResponse();
                    qQProtectRisks$QQProtectRisksResponse.mergeFrom(bArr);
                    if (qQProtectRisks$QQProtectRisksResponse.uint32_sec_cmd.has()) {
                        i16 = qQProtectRisks$QQProtectRisksResponse.uint32_sec_cmd.get();
                    } else {
                        i16 = 0;
                    }
                    if (i16 == 1 && qQProtectRisks$QQProtectRisksResponse.risk_info_list.has() && !qQProtectRisks$QQProtectRisksResponse.risk_info_list.isEmpty()) {
                        for (int i17 = 0; i17 < qQProtectRisks$QQProtectRisksResponse.risk_info_list.size(); i17++) {
                            QQProtectRisks$RiskInfo qQProtectRisks$RiskInfo = qQProtectRisks$QQProtectRisksResponse.risk_info_list.get(i17);
                            if (!qQProtectRisks$RiskInfo.uint32_item_type.has() || qQProtectRisks$RiskInfo.uint32_item_type.get() != 1) {
                                RiskInfoItem riskInfoItem = new RiskInfoItem();
                                riskInfoItem.f274383d = qQProtectRisks$RiskInfo.str_left_text.get();
                                riskInfoItem.f274386h = qQProtectRisks$RiskInfo.str_jump_target.get();
                                if (!TextUtils.isEmpty(riskInfoItem.f274383d) && !TextUtils.isEmpty(riskInfoItem.f274386h)) {
                                    riskInfoItem.f274384e = qQProtectRisks$RiskInfo.str_right_text.get();
                                    riskInfoItem.f274385f = qQProtectRisks$RiskInfo.str_desc_text.get();
                                    riskInfoItem.f274387i = qQProtectRisks$RiskInfo.uint32_click_report_id.get();
                                    if (qQProtectRisks$RiskInfo.uint32_item_id.has()) {
                                        riskInfoItem.f274388m = qQProtectRisks$RiskInfo.uint32_item_id.get();
                                    }
                                    if (qQProtectRisks$RiskInfo.str_right_text_open.has()) {
                                        riskInfoItem.C = qQProtectRisks$RiskInfo.str_right_text_open.get();
                                    }
                                    String valueOf = String.valueOf(riskInfoItem.f274388m);
                                    if (riskInfoItem.f274388m == 0) {
                                        valueOf = riskInfoItem.f274386h;
                                    }
                                    hashMap.put(valueOf, riskInfoItem);
                                    QLog.d(RiskInfoActivity.TAG, 1, String.format("%s, %s, %s, %s, %d, %d, %s", riskInfoItem.f274383d, riskInfoItem.f274384e, riskInfoItem.f274385f, riskInfoItem.f274386h, Integer.valueOf(riskInfoItem.f274387i), Integer.valueOf(riskInfoItem.f274388m), riskInfoItem.C));
                                }
                            }
                        }
                    }
                    z16 = true;
                } catch (InvalidProtocolBufferMicroException unused) {
                    QLog.d(RiskInfoActivity.TAG, 1, "error protobuf content");
                } catch (Throwable th5) {
                    QLog.e(RiskInfoActivity.TAG, 1, th5, new Object[0]);
                }
                RiskInfoActivity.this.updateRiskInfoListUI(hashMap, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(RiskInfoActivity.TAG, 2, "request risks info,onResult error=" + i3 + " data=" + bArr);
            }
            RiskInfoActivity.this.updateRiskInfoListUI(hashMap, false);
        }
    }

    public RiskInfoActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mRiskInfoListLayout = null;
        this.mDevlockInfo = null;
        this.mRiskInfoItems = new ArrayList();
    }

    private void createRiskInfoListUI(List<RiskInfoItem> list) {
        if (list != null && !list.isEmpty()) {
            this.mRiskInfoListLayout.removeAllViews();
            this.mRiskInfoListLayout.setVisibility(0);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                RiskInfoItem riskInfoItem = list.get(i3);
                if (riskInfoItem != null) {
                    this.mRiskInfoListLayout.addView(getFormItemView(riskInfoItem));
                }
            }
            return;
        }
        this.mRiskInfoListLayout.setVisibility(8);
    }

    private View getFormItemView(RiskInfoItem riskInfoItem) {
        View inflate = getLayoutInflater().inflate(R.layout.bb6, (ViewGroup) this.mRiskInfoListLayout, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f166797ib3);
        FormSimpleItem formSimpleItem = (FormSimpleItem) inflate.findViewById(R.id.f166796ib2);
        formSimpleItem.setBgType(0);
        formSimpleItem.setLeftText(riskInfoItem.f274383d);
        formSimpleItem.setRightText(riskInfoItem.f274384e);
        ((TextView) inflate.findViewById(R.id.iaw)).setText(riskInfoItem.f274385f);
        linearLayout.setTag(TAG_RISK_INFO_DATA, riskInfoItem);
        formSimpleItem.setTag(TAG_RISK_INFO_DATA, riskInfoItem);
        formSimpleItem.setClickable(true);
        formSimpleItem.setOnClickListener(this);
        return inflate;
    }

    public static int getRiskInfoCount(List<RiskInfoItem> list) {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static int getRiskType(List<RiskInfoItem> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(0).f274388m;
        }
        return 100;
    }

    private void requestRisksInfo() {
        QQProtectRisks$QQProtectRisksRequest qQProtectRisks$QQProtectRisksRequest = new QQProtectRisks$QQProtectRisksRequest();
        qQProtectRisks$QQProtectRisksRequest.uint32_sec_cmd.set(1);
        qQProtectRisks$QQProtectRisksRequest.str_package_name.set(((IQPMiscUtilsApi) QRoute.api(IQPMiscUtilsApi.class)).getAppPackageName());
        qQProtectRisks$QQProtectRisksRequest.uint32_app_id.set(AppSetting.f());
        setRightText(CONST_ALL_ITEMS, getResources().getString(R.string.f172958g34));
        ProtoUtils.d(this.app, new a(), qQProtectRisks$QQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
    }

    private void setRightText(String str, String str2) {
        FormSimpleItem formSimpleItem;
        RiskInfoItem riskInfoItem;
        String valueOf;
        for (int i3 = 0; i3 < this.mRiskInfoListLayout.getChildCount(); i3++) {
            View childAt = this.mRiskInfoListLayout.getChildAt(i3);
            if (childAt != null && (formSimpleItem = (FormSimpleItem) childAt.findViewById(R.id.f166796ib2)) != null && (riskInfoItem = (RiskInfoItem) formSimpleItem.getTag(TAG_RISK_INFO_DATA)) != null) {
                int i16 = riskInfoItem.f274388m;
                if (i16 == 0) {
                    valueOf = riskInfoItem.f274386h;
                } else {
                    valueOf = String.valueOf(i16);
                }
                if (str.equalsIgnoreCase(CONST_ALL_ITEMS) || str.equalsIgnoreCase(valueOf)) {
                    formSimpleItem.setRightText(str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRiskInfoListUI(Map<String, RiskInfoItem> map, boolean z16) {
        if (z16) {
            for (RiskInfoItem riskInfoItem : this.mRiskInfoItems) {
                String valueOf = String.valueOf(riskInfoItem.f274388m);
                if (riskInfoItem.f274388m == 0) {
                    valueOf = riskInfoItem.f274386h;
                }
                if (map.get(valueOf) != null) {
                    setRightText(valueOf, riskInfoItem.f274384e);
                } else {
                    String str = riskInfoItem.C;
                    if (TextUtils.isEmpty(str)) {
                        str = getResources().getString(R.string.aya);
                    }
                    setRightText(valueOf, str);
                    if (riskInfoItem.f274386h.equalsIgnoreCase(TARGET_DEVLOCK)) {
                        this.mDevlockInfo.DevSetup = 1;
                    }
                }
            }
            return;
        }
        setRightText(CONST_ALL_ITEMS, "");
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.doOnActivityResult(i3, i16, intent);
            requestRisksInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnResume();
        int riskInfoCount = getRiskInfoCount(this.mRiskInfoItems);
        ReportController.o(this.app, "dc00898", "", "", "0X800C290", "0X800C290", getRiskType(this.mRiskInfoItems), 0, String.valueOf(riskInfoCount), "", "", "");
    }

    protected void jumpToTarget(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        QLog.d(TAG, 1, String.format("jump: %s", str));
        if (str.equalsIgnoreCase(TARGET_PHONEBIND)) {
            try {
                Intent intent = new Intent(this, (Class<?>) PhoneUnityBindInfoActivity.class);
                intent.putExtra("kSrouce", 18);
                startActivityForResult(intent, 2001);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        if (str.equalsIgnoreCase(TARGET_PICKPROOF)) {
            try {
                startActivityForResult(new Intent(this, (Class<?>) SecurityPickproofActivity.class), 0);
                return;
            } catch (Exception e17) {
                e17.printStackTrace();
                return;
            }
        }
        if (str.equalsIgnoreCase(TARGET_QQIMPROTECT)) {
            try {
                startActivityForResult(new Intent(this, (Class<?>) SecurityProtectActivity.class), 0);
                return;
            } catch (Exception e18) {
                e18.printStackTrace();
                return;
            }
        }
        if (str.startsWith("http")) {
            try {
                String currentAccountUin = this.app.getCurrentAccountUin();
                Intent intent2 = new Intent(this, (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("uin", currentAccountUin);
                if (str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) == -1) {
                    str2 = str + "?uin=" + currentAccountUin;
                } else {
                    str2 = str + "&uin=" + currentAccountUin;
                }
                intent2.putExtra("url", str2);
                startActivityForResult(intent2, 0);
            } catch (Exception e19) {
                e19.printStackTrace();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            RiskInfoItem riskInfoItem = (RiskInfoItem) view.getTag(TAG_RISK_INFO_DATA);
            QLog.d(TAG, 1, String.format("set jump: %s", riskInfoItem.f274386h));
            jumpToTarget(riskInfoItem.f274386h);
            ReportController.o(this.app, "dc00899", "Safe_RiskInfo", "", riskInfoItem.f274383d, riskInfoItem.f274386h, riskInfoItem.f274387i, 0, "", "", "", "");
            int i3 = riskInfoItem.f274388m;
            if (i3 == 1) {
                ReportController.o(this.app, "dc00898", "", "", "0X800C292", "0X800C292", 0, 0, "", "", "", "");
            } else if (i3 == 5) {
                ReportController.o(this.app, "dc00898", "", "", "0X800C291", "0X800C291", 0, 0, "", "", "", "");
            } else if (i3 == 4) {
                ReportController.o(this.app, "dc00898", "", "", "0X800C2A6", "0X800C2A6", 0, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        super.setContentView(R.layout.bb5);
        setTitle(R.string.f172955g31);
        this.mRiskInfoListLayout = (LinearLayout) findViewById(R.id.h1w);
        Bundle extras = getIntent().getExtras();
        this.mRiskInfoItems = extras.getParcelableArrayList("data");
        this.mDevlockInfo = (DevlockInfo) extras.get(AuthDevOpenUgActivity.KEY_DEVLOCK_INFO);
        createRiskInfoListUI(this.mRiskInfoItems);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
        }
    }
}
