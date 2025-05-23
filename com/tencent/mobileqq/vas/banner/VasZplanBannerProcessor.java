package com.tencent.mobileqq.vas.banner;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.ad;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import z23.f;

/* loaded from: classes35.dex */
public class VasZplanBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.b, Handler.Callback {

    /* renamed from: f, reason: collision with root package name */
    public static final int f308826f = com.tencent.mobileqq.banner.d.M;

    /* renamed from: d, reason: collision with root package name */
    private VasZplanUserCallbackTabInfo f308827d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f308828e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class a implements e<VasZplanUserCallbackTabInfo> {
        a() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(VasZplanUserCallbackTabInfo vasZplanUserCallbackTabInfo) {
            Message message = new Message();
            message.what = 3124101;
            message.obj = vasZplanUserCallbackTabInfo;
            VasZplanBannerProcessor.this.f308828e = false;
            if (vasZplanUserCallbackTabInfo != null && !TextUtils.isEmpty(vasZplanUserCallbackTabInfo.getIcon()) && !TextUtils.isEmpty(vasZplanUserCallbackTabInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String())) {
                VasZplanBannerProcessor.this.f308827d = vasZplanUserCallbackTabInfo;
                if (VasZplanBannerProcessor.this.n().booleanValue()) {
                    QLog.d("Q.recent.banner", 2, "isShow: " + vasZplanUserCallbackTabInfo.getIsShowSilenceText() + ",  isSilent: " + VasZplanBannerHelper.f308822d.d() + ", textStr: " + vasZplanUserCallbackTabInfo.getText() + ", silentTextStr: " + vasZplanUserCallbackTabInfo.getSilenceText());
                    VasZplanBannerProcessor.this.t(message);
                    return;
                }
                return;
            }
            QLog.e("Q.recent.banner", 2, "getSmallHomeTabInfo error url is null");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int i3, String str) {
            VasZplanBannerProcessor.this.f308828e = false;
            QLog.e("Q.recent.banner", 2, "getSmallHomeTabInfo error:" + str);
        }
    }

    /* loaded from: classes35.dex */
    class b implements Function1<Boolean, Unit> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            QLog.i("Q.recent.banner", 1, "VasZplanBannerHelper#needShowBanner result = " + bool);
            if (bool.booleanValue()) {
                if (VasZplanBannerProcessor.this.f308828e) {
                    return null;
                }
                ((BaseBannerProcessor) VasZplanBannerProcessor.this).handler.sendEmptyMessageDelayed(4000, 3000L);
                VasZplanBannerProcessor.this.f308828e = true;
                return null;
            }
            ((BaseBannerProcessor) VasZplanBannerProcessor.this).handler.sendEmptyMessageDelayed(5000, 3000L);
            return null;
        }
    }

    public VasZplanBannerProcessor(QBaseActivity qBaseActivity) {
        this.handler = new ad(Looper.getMainLooper(), this);
        QLog.d("Q.recent.banner", 1, VasZplanBannerHelper.f308822d.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean n() {
        if (this.f308827d == null) {
            return Boolean.FALSE;
        }
        VasZplanBannerHelper vasZplanBannerHelper = VasZplanBannerHelper.f308822d;
        if (vasZplanBannerHelper.d()) {
            if (!this.f308827d.getIsShowSilenceText() || this.f308827d.getSilenceText().isEmpty()) {
                QLog.d("Q.recent.banner", 2, "isShow is false" + this.f308827d.getSilenceText());
                return Boolean.FALSE;
            }
        } else if (this.f308827d.getText().isEmpty()) {
            QLog.d("Q.recent.banner", 2, "text isEmpty");
            return Boolean.FALSE;
        }
        if (vasZplanBannerHelper.b(this.f308827d.getExposureTime())) {
            QLog.d("Q.recent.banner", 2, "checkBannerShow is over Exposure");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private void o() {
        AppInterface c16 = bb.f335811a.c();
        f fVar = new f();
        if (c16 != null) {
            fVar.a(c16, 0, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        r("ev_zplan_message_guidelines_btn", "click");
        this.handler.sendEmptyMessage(5000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(QBaseActivity qBaseActivity, VasZplanUserCallbackTabInfo vasZplanUserCallbackTabInfo, View view) {
        r("ev_zplan_external_entrance_action", "click");
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(qBaseActivity, vasZplanUserCallbackTabInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String());
        VasZplanBannerHelper.f308822d.e();
        BannerManager.l().O(com.tencent.mobileqq.banner.d.M, 0, null);
    }

    private void r(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_action_type", str2);
        if (str.equals("ev_zplan_external_entrance_action")) {
            hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_message_guidelines");
        }
        com.tencent.mobileqq.zplan.report.c.f335070a.a(str, hashMap);
    }

    private void s(VasZplanUserCallbackTabInfo vasZplanUserCallbackTabInfo) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        HashMap hashMap = new HashMap();
        hashMap.put("A71", ABTestController.APPID_8881);
        hashMap.put("tab_business_id", ABTestController.APPID_8881);
        hashMap.put("A70", peekAppRuntime.getCurrentUin());
        hashMap.put("tab_sdk_version", "4.4.0");
        hashMap.put("user_type", "0");
        hashMap.put("A148", Long.toString(vasZplanUserCallbackTabInfo.getExpId()));
        hashMap.put("A149", vasZplanUserCallbackTabInfo.getGroupKey());
        hashMap.put("exp_percentage", Float.toString(vasZplanUserCallbackTabInfo.getPercentage()));
        hashMap.put("exp_bucket", "-1");
        hashMap.put("exp_platform", "Android");
        QQBeaconReport.reportWithAppKey("0DOU0FJX7W40ANTK", peekAppRuntime.getCurrentUin(), "rqd_expimpression", hashMap);
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        this.handler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        return f308826f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 4000) {
            if (i3 == 5000) {
                Message message2 = new Message();
                message2.what = 3124102;
                BannerManager.l().O(com.tencent.mobileqq.banner.d.M, 0, message2);
                return true;
            }
            if (i3 != 6000) {
                return true;
            }
            QLog.d("Q.recent.banner", 2, "MSG_SMALL_HOME_NOTICE_CLICK");
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "onDelayRefreshSmallHomeNotice");
        }
        if (this.f308827d == null) {
            o();
            return true;
        }
        this.f308828e = false;
        Message message3 = new Message();
        message3.what = 3124101;
        message3.obj = this.f308827d;
        if (!n().booleanValue()) {
            return false;
        }
        t(message3);
        return true;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "initGameNoticeBar");
        }
        return QUINoticeBarManager.l().h(baseActivity).setIcon(R.drawable.ibf).e(R.string.xuy).k(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.banner.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasZplanBannerProcessor.this.p(view);
            }
        }).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        BannerManager.l().O(com.tencent.mobileqq.banner.d.M, 0, new Message());
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onResume() {
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "onDelayRefreshSmallHomeNotice");
        }
        VasZplanBannerHelper.f308822d.f(new b());
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        com.tencent.biz.qui.noticebar.d d16;
        if (message == null) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.recent.banner", 2, "VasZplanBannerProcessor updateBanner msg is null");
                return;
            }
            return;
        }
        final QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (d16 = QUINoticeBarManager.l().d(aVar.f200243c)) == null || message.what != 3124101) {
            return;
        }
        final VasZplanUserCallbackTabInfo vasZplanUserCallbackTabInfo = (VasZplanUserCallbackTabInfo) message.obj;
        if (this.f308827d.getIsShowSilenceText()) {
            d16.setMsg(vasZplanUserCallbackTabInfo.getSilenceText());
        } else {
            d16.setMsg(vasZplanUserCallbackTabInfo.getText());
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = baseActivity.getResources().getDrawable(R.drawable.ibf);
        obtain.mLoadingDrawable = baseActivity.getResources().getDrawable(R.drawable.ibf);
        try {
            d16.setIcon(URLDrawable.getDrawable(vasZplanUserCallbackTabInfo.getIcon(), obtain));
        } catch (Exception e16) {
            QLog.e("Q.recent.banner", 2, "updateBanner:" + e16);
        }
        r("ev_zplan_external_entrance_action", "imp");
        r("ev_zplan_message_guidelines_btn", "imp");
        d16.c(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.banner.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasZplanBannerProcessor.this.q(baseActivity, vasZplanUserCallbackTabInfo, view);
            }
        });
        VasZplanBannerHelper.f308822d.g();
        s(vasZplanUserCallbackTabInfo);
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onPause() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Message message) {
    }
}
