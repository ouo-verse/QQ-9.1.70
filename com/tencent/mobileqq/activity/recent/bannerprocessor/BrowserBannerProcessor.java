package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class BrowserBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.b, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185202d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69193);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f185202d = com.tencent.mobileqq.banner.d.H;
        }
    }

    public BrowserBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.handler = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Bundle bundle, QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Class<?> cls = null;
        BannerManager.l().O(f185202d, 0, null);
        String str = (String) bundle.getCharSequence(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (!TextUtils.isEmpty(str)) {
            try {
                cls = Class.forName(str);
            } catch (ClassNotFoundException unused) {
            }
            if (cls != null) {
                Intent intent = new Intent(qBaseActivity.getApplicationContext(), cls);
                String str2 = (String) bundle.getCharSequence("action");
                if (!TextUtils.isEmpty(str2)) {
                    intent.setAction(str2);
                }
                String str3 = (String) bundle.getCharSequence("category");
                if (!TextUtils.isEmpty(str3)) {
                    intent.addCategory(str3);
                }
                intent.setFlags(bundle.getInt(WadlProxyConsts.FLAGS, 0));
                qBaseActivity.startActivity(intent);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
        } else {
            this.handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int defaultTipsBarType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return super.defaultTipsBarType();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return f185202d;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1000) {
            BannerManager.l().O(f185202d, 0, null);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BrowserBar", 2, "initBrowserBar");
        }
        return QUINoticeBarManager.l().h(baseActivity).setIcon(R.drawable.c4b).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        if (message != null && ((i3 = message.what) == 1134041 || i3 == 1134042)) {
            if (QLog.isColorLevel()) {
                QLog.d("BrowserBar", 2, "updateBrowserBar msg.obj = " + message.obj);
            }
            final QBaseActivity baseActivity = getBaseActivity();
            if (baseActivity == null) {
                return;
            }
            if (message.what == 1134042) {
                aVar.f200243c.setVisibility(8);
                return;
            }
            com.tencent.biz.qui.noticebar.d d16 = QUINoticeBarManager.l().d(aVar.f200243c);
            if (d16 == null) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                final Bundle bundle = (Bundle) obj;
                String str = (String) bundle.getCharSequence("tips");
                int i16 = bundle.getInt("icon");
                if (i16 != -1) {
                    d16.setIcon(i16);
                }
                if (!TextUtils.isEmpty(str)) {
                    d16.setMsg(str);
                    d16.c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BrowserBannerProcessor.f(bundle, baseActivity, view);
                        }
                    });
                    this.handler.removeMessages(1000);
                    this.handler.sendEmptyMessageDelayed(1000, bundle.getInt("timeout", 120000));
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BrowserBar", 2, "updateBrowserBar msg " + message);
        }
    }
}
