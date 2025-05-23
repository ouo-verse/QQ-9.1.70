package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.Map;
import mqq.app.MobileQQ;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class LoginDevicesBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final int f185224h;

    /* renamed from: i, reason: collision with root package name */
    private static final Map<Integer, Integer> f185225i;

    /* renamed from: d, reason: collision with root package name */
    private long f185226d;

    /* renamed from: e, reason: collision with root package name */
    private String f185227e;

    /* renamed from: f, reason: collision with root package name */
    private String f185228f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69208);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f185224h = com.tencent.mobileqq.banner.d.F;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f185225i = linkedHashMap;
        linkedHashMap.put(1, Integer.valueOf(R.drawable.qui_computer_icon_secondary_01));
        linkedHashMap.put(2, Integer.valueOf(R.drawable.qui_pad_icon_secondary_01));
        linkedHashMap.put(3, Integer.valueOf(R.drawable.qui_watch_icon_secondary_01));
        linkedHashMap.put(4, Integer.valueOf(R.drawable.qui_computer_more_icon_secondary_01));
        linkedHashMap.put(5, Integer.valueOf(R.drawable.qui_pad_watch_icon_secondary_01));
        linkedHashMap.put(6, Integer.valueOf(R.drawable.qui_computer_watch_icon_secondary_01));
    }

    public LoginDevicesBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        }
    }

    private Drawable g(int i3) {
        return MobileQQ.sMobileQQ.getResources().getDrawable(h(f185225i, i3, R.drawable.qui_computer_more_icon_secondary_01));
    }

    private int h(Map<Integer, Integer> map, int i3, int i16) {
        if (map.get(Integer.valueOf(i3)) != null) {
            return map.get(Integer.valueOf(i3)).intValue();
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.i("Q.recent.banner", 1, "onItemClick carAppId=" + this.f185227e);
        String str = this.f185227e;
        if (str != null && "1600000104".equals(str.trim())) {
            f();
        } else {
            Intent intent = new Intent(qBaseActivity, (Class<?>) QRLoginMgrActivity.class);
            intent.putExtra("qrlogin_position", this.f185228f);
            intent.putExtra("qrlogin_appid", this.f185226d);
            qBaseActivity.startActivity(intent);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        BannerManager l3 = BannerManager.l();
        int i3 = f185224h;
        if (l3.n(i3)) {
            this.f185228f = null;
            BannerManager.l().D(PCOnlineBannerProcessor.D, 2004);
            BannerManager.l().O(i3, 0, null);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return f185224h;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
        final QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        return QUINoticeBarManager.l().h(baseActivity).setIcon(R.drawable.qui_computer_more_icon_secondary_01).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginDevicesBannerProcessor.this.i(baseActivity, view);
            }
        }).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            f();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onMessage(Message message, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, message, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        switch (message.what) {
            case 2000:
                f();
                return;
            case 2001:
                this.f185226d = message.getData().getLong("loginDevAppid");
                return;
            case 2002:
                this.f185228f = message.getData().getString("pcLoginInfo");
                return;
            case 2003:
                this.f185228f = null;
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        com.tencent.biz.qui.noticebar.d d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (d16 = QUINoticeBarManager.l().d(aVar.f200243c)) == null) {
            return;
        }
        rd0.g gVar = (rd0.g) baseActivity.getAppRuntime().getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER);
        String h16 = gVar.h();
        if (TextUtils.isEmpty(h16)) {
            f();
        } else {
            d16.setMsg(h16).setIcon(g(gVar.g()));
        }
    }
}
