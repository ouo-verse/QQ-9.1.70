package com.tencent.biz.coupon;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.m;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.protofile.coupon.CouponProto$MarkBusinessFavourUpdateReq;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CouponActivity extends QQBrowserActivity {

    /* renamed from: b0, reason: collision with root package name */
    static String f78475b0 = "https://web.p.qq.com/qqmpmobile/coupon/shop.html?_bid=108";

    /* renamed from: a0, reason: collision with root package name */
    public int f78476a0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class CouponWebViewFragment extends WebViewFragment {
        boolean C = false;
        int D = 0;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a extends com.tencent.mobileqq.webview.swift.proxy.a {
            a(t tVar) {
                super(tVar);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public String getUAMark() {
                if (((WebViewFragment) CouponWebViewFragment.this).intent.hasExtra("source")) {
                    return "PA MyCoupon";
                }
                return "PA Coupon";
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onFinalState(Bundle bundle) {
                super.onFinalState(bundle);
                if (!((WebViewFragment) CouponWebViewFragment.this).intent.hasExtra("source")) {
                    CouponWebViewFragment.this.getSwiftTitleUI().E.setVisibility(8);
                    CouponWebViewFragment.this.getSwiftTitleUI().C.setVisibility(0);
                    CouponWebViewFragment.this.getSwiftTitleUI().C.setText(R.string.f171284dq4);
                    CouponWebViewFragment.this.getSwiftTitleUI().C.setOnClickListener(CouponWebViewFragment.this);
                    return;
                }
                ((WebViewFragment) CouponWebViewFragment.this).intent.removeExtra("source");
                CouponWebViewFragment.this.getSwiftTitleUI().E.setVisibility(8);
                CouponWebViewFragment.this.getSwiftTitleUI().C.setVisibility(8);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onInitTitleBar(Bundle bundle) {
                super.onInitTitleBar(bundle);
                if (!((WebViewFragment) CouponWebViewFragment.this).intent.hasExtra("source")) {
                    CouponWebViewFragment.this.getSwiftTitleUI().E.setVisibility(8);
                    CouponWebViewFragment.this.getSwiftTitleUI().C.setVisibility(0);
                    CouponWebViewFragment.this.getSwiftTitleUI().C.setText(R.string.f171284dq4);
                    CouponWebViewFragment.this.getSwiftTitleUI().C.setClickable(false);
                    return;
                }
                CouponWebViewFragment.this.getSwiftTitleUI().E.setVisibility(8);
                CouponWebViewFragment.this.getSwiftTitleUI().C.setVisibility(8);
            }
        }

        private void th() {
            NewIntent newIntent = new NewIntent(super.getQBaseActivity(), m.class);
            newIntent.putExtra("cmd", "CouponSvr.coup_markBizupdate");
            newIntent.putExtra("data", new MessageMicro<CouponProto$MarkBusinessFavourUpdateReq>() { // from class: com.tencent.protofile.coupon.CouponProto$MarkBusinessFavourUpdateReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], CouponProto$MarkBusinessFavourUpdateReq.class);
            }.toByteArray());
            if (getAppRuntime() == null) {
                this.mApp = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
            }
            getAppRuntime().startServlet(newIntent);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public void doOnActivityResult(int i3, int i16, Intent intent) {
            int i17;
            super.doOnActivityResult(i3, i16, intent);
            if (intent != null && intent.getExtras() != null) {
                i17 = intent.getExtras().getInt("toPage");
            } else {
                i17 = 0;
            }
            if (i17 != 0 && (this.D & i17) == 0) {
                Intent intent2 = new Intent();
                intent2.putExtra("toPage", i17);
                super.getQBaseActivity().setResult(-1, intent2);
                super.getQBaseActivity().finish();
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public boolean doOnCreate(Bundle bundle) {
            String str;
            String string = this.intent.getExtras().getString("url");
            this.D = this.intent.getIntExtra("from", 10);
            this.intent.putExtra("webStyle", "noBottomBar");
            if (TextUtils.isEmpty(string)) {
                this.intent.putExtra("title", super.getResources().getString(R.string.dq7));
                this.C = true;
            } else {
                this.intent.removeExtra("title");
            }
            super.doOnCreate(bundle);
            if (this.C) {
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    String stringExtra = this.intent.getStringExtra("jsonParams");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        Iterator keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String str2 = (String) keys.next();
                            stringBuffer.append(ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(str2).toString());
                        }
                    }
                } catch (JSONException unused) {
                }
                if ((this.D & 5) == 0) {
                    str = CouponActivity.f78475b0 + "&stype=2" + stringBuffer.toString();
                } else {
                    str = CouponActivity.f78475b0 + stringBuffer.toString();
                }
                this.intent.putExtra("url", str);
            }
            this.intent.putExtra("from", (this.D & 28) | 16);
            th();
            ReportController.o(null, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "coupon.activity.show", 0, 0, "", "", "", "");
            return true;
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public t getWebViewKernelCallBack() {
            return new a(this.webViewSurface);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view == getSwiftTitleUI().C) {
                if ((this.D & 4) != 0) {
                    Intent intent = new Intent();
                    intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
                    intent.putExtra("toPage", 1);
                    super.getQBaseActivity().setResult(-1, intent);
                    super.getQBaseActivity().finish();
                } else {
                    Intent intent2 = new Intent(super.getQBaseActivity(), (Class<?>) CouponActivity.class);
                    intent2.putExtra("url", "https://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108");
                    intent2.putExtra("source", "2");
                    intent2.putExtra("from", (this.D & 12) | 5);
                    super.getQBaseActivity().startActivityForResult(intent2, 100);
                }
            } else {
                super.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public CouponActivity() {
        this.mFragmentClass = CouponWebViewFragment.class;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.f78476a0 = getIntent().getIntExtra("from", 10);
        return super.doOnCreate(bundle);
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
