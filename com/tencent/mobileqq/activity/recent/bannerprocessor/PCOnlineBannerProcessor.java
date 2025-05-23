package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class PCOnlineBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;
    public static final int D;
    public long C;

    /* renamed from: d, reason: collision with root package name */
    private long f185244d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f185245e;

    /* renamed from: f, reason: collision with root package name */
    private String f185246f;

    /* renamed from: h, reason: collision with root package name */
    private int f185247h;

    /* renamed from: i, reason: collision with root package name */
    private String f185248i;

    /* renamed from: m, reason: collision with root package name */
    private String f185249m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69222);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            D = com.tencent.mobileqq.banner.d.f200261n;
        }
    }

    public PCOnlineBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.f185245e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String str = this.f185248i;
        if (str != null && "1600000104".equals(str.trim())) {
            if (this.f185244d == 77313) {
                this.f185245e = true;
            }
            g();
        } else {
            Intent intent = new Intent(qBaseActivity, (Class<?>) QRLoginMgrActivity.class);
            intent.putExtra("loginInfo", this.f185249m);
            intent.putExtra("appType", this.f185247h);
            intent.putExtra("subappid", this.C);
            intent.putExtra("clientType", this.f185244d);
            qBaseActivity.startActivity(intent);
            ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_COMMON, BaseBannerProcessor.TVALUE_CLICK_COMMON, 10, 0, "", "", "", "");
            if (this.f185244d == 77313) {
                ReportController.o(qBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8008880", "0X8008880", 0, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f185244d == 77313) {
            this.f185245e = true;
        }
        g();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int defaultTipsBarType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        BannerManager l3 = BannerManager.l();
        int i3 = D;
        if (l3.n(i3)) {
            BannerManager.l().K(i3, 0);
            this.f185249m = null;
            BannerManager.l().D(LoginDevicesBannerProcessor.f185224h, 2003);
            this.f185247h = -1;
            this.f185246f = null;
            this.f185244d = 0L;
            BannerManager.l().A(-1, null);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return D;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        final QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        return QUINoticeBarManager.l().h(baseActivity).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PCOnlineBannerProcessor.this.h(baseActivity, view);
            }
        }).k(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PCOnlineBannerProcessor.this.i(view);
            }
        }).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            g();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onMessage(Message message, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, message, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        switch (message.what) {
            case 2000:
                this.f185246f = null;
                return;
            case 2001:
                this.f185247h = -1;
                return;
            case 2002:
                this.C = message.getData().getLong("loginAppType");
                return;
            case 2003:
                this.f185249m = message.getData().getString("pcLoginInfo");
                return;
            case 2004:
                this.f185249m = null;
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        com.tencent.biz.qui.noticebar.d d16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (d16 = QUINoticeBarManager.l().d(aVar.f200243c)) == null) {
            return;
        }
        String str = this.f185248i;
        if (str != null && "1600000104".equals(str.trim())) {
            d16.e(R.string.f170693z3);
            return;
        }
        if (rd0.h.e(this.f185247h) && TextUtils.isEmpty(this.f185246f)) {
            this.f185246f = HardCodeUtil.qqStr(R.string.f173402t2);
        }
        if (!TextUtils.isEmpty(this.f185246f)) {
            d16.setMsg(this.f185246f);
        } else {
            String qqStr = HardCodeUtil.qqStr(R.string.f173392t1);
            if (this.f185244d == 77313) {
                qqStr = HardCodeUtil.qqStr(R.string.f173382t0);
            }
            d16.setMsg(String.format(baseActivity.getString(R.string.cqz), qqStr));
        }
        int i16 = this.f185247h;
        if (i16 == 5) {
            d16.setIcon(R.drawable.ccr);
        } else if (rd0.h.e(i16)) {
            d16.setIcon(R.drawable.ccs);
        } else {
            d16.setIcon(R.drawable.chat_icon_pconline);
        }
        if (this.f185247h == 4) {
            i3 = 23;
        } else {
            i3 = 10;
        }
        ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_COMMON, BaseBannerProcessor.TVALUE_SHOW_COMMON, i3, 0, "", "", "", "");
    }
}
