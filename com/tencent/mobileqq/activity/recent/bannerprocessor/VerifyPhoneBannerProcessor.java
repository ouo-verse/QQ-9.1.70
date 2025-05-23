package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class VerifyPhoneBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.b, Handler.Callback, TianShuGetAdvCallback, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static final int f185283i;

    /* renamed from: d, reason: collision with root package name */
    volatile String f185284d;

    /* renamed from: e, reason: collision with root package name */
    String f185285e;

    /* renamed from: f, reason: collision with root package name */
    String f185286f;

    /* renamed from: h, reason: collision with root package name */
    int f185287h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements TianShuGetAdvCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<VerifyPhoneBannerProcessor> f185288d;

        a(VerifyPhoneBannerProcessor verifyPhoneBannerProcessor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) verifyPhoneBannerProcessor);
            } else {
                this.f185288d = new WeakReference<>(verifyPhoneBannerProcessor);
            }
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), getAdsRsp);
                return;
            }
            VerifyPhoneBannerProcessor verifyPhoneBannerProcessor = this.f185288d.get();
            if (verifyPhoneBannerProcessor != null) {
                verifyPhoneBannerProcessor.onGetAdvs(z16, getAdsRsp);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f185283i = com.tencent.mobileqq.banner.d.f200266s;
        }
    }

    public VerifyPhoneBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
            return;
        }
        this.f185284d = "";
        this.f185285e = "";
        this.f185286f = "";
        this.handler = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
    }

    private void f() {
        BannerManager l3 = BannerManager.l();
        int i3 = f185283i;
        if (l3.o(i3)) {
            BannerManager.l().O(i3, 0, null);
        }
    }

    private void g() {
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mActionId = 102;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mItemId = String.valueOf(this.f185287h);
        tianShuReportData.mTraceId = String.valueOf(NetConnInfoCenter.getServerTime());
        tianShuReportData.mOperTime = NetConnInfoCenter.getServerTime();
        TianShuManager.getInstance().report(tianShuReportData);
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        } else {
            this.handler.removeCallbacksAndMessages(null);
        }
    }

    protected boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return ((IFeatureRuntimeService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("Secure_VerfifyPhone_864441577");
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return f185283i;
    }

    protected void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 768;
        tianShuAdPosItemData.mNeedCnt = 1;
        arrayList.add(tianShuAdPosItemData);
        TianShuManager.getInstance().requestAdv(arrayList, new a(this));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        if (!e()) {
            QLog.d("VerifyPhoneBannerProcessor", 1, "feature switch state is false, return");
            return true;
        }
        if (message.what == 3000) {
            h();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        ReportController.o(null, "dc00898", "", "", "0X800BC91", "0X800BC91", 0, 0, this.f185286f, "", this.f185284d, this.f185285e);
        return QUINoticeBarManager.l().h(baseActivity).setMsg(this.f185284d).getView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            QBaseActivity baseActivity = getBaseActivity();
            if (baseActivity != null) {
                ax c16 = bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), baseActivity, this.f185285e);
                if (c16 != null) {
                    c16.b();
                } else if (HttpUtil.isValidUrl(this.f185285e)) {
                    Intent intent = new Intent(baseActivity, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", this.f185285e);
                    baseActivity.startActivity(intent);
                } else {
                    QLog.d("VerifyPhoneBannerProcessor", 1, "jump fail, link is " + this.f185285e);
                }
                f();
                g();
                ReportController.o(null, "dc00898", "", "", "0X800BC92", "0X800BC92", 0, 0, this.f185286f, "", this.f185284d, this.f185285e);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
    public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.RspEntry> list;
        List<TianShuAccess.AdItem> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), getAdsRsp);
            return;
        }
        if (getAdsRsp.mapAds.has()) {
            list = getAdsRsp.mapAds.get();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            TianShuAccess.RspEntry rspEntry = list.get(0);
            if (rspEntry.value.lst.has()) {
                list2 = rspEntry.value.lst.get();
            } else {
                list2 = null;
            }
            if (list2 != null && !list2.isEmpty()) {
                TianShuAccess.AdItem adItem = list2.get(0);
                for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
                    if (mapEntry.key.get().equals("scene")) {
                        this.f185286f = mapEntry.value.get();
                    } else if (mapEntry.key.get().equals("wording")) {
                        this.f185284d = mapEntry.value.get();
                    } else if (mapEntry.key.get().equals(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK)) {
                        this.f185285e = mapEntry.value.get();
                    }
                }
                this.f185287h = adItem.iAdId.get();
                if (!TextUtils.isEmpty(this.f185284d) && !TextUtils.isEmpty(this.f185285e)) {
                    BannerManager.l().O(f185283i, 2, null);
                    return;
                }
                f();
                QLog.d("VerifyPhoneBannerProcessor", 1, "onGetAdvs hide banner, mword is " + this.f185284d + " mLink is " + this.f185285e);
                return;
            }
            QLog.d("VerifyPhoneBannerProcessor", 1, "onGetAdvs failed adItemList == null || adItemList.isEmpty()");
            f();
            return;
        }
        QLog.d("VerifyPhoneBannerProcessor", 1, "onGetAdvs failed rspEntries == null || rspEntries.isEmpty()");
        f();
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
