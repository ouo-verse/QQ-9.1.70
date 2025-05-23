package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import gp3.e;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class GameBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.b, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185210d;

    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f185211d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f185212e;

        a(Bundle bundle, QBaseActivity qBaseActivity) {
            this.f185211d = bundle;
            this.f185212e = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, GameBannerProcessor.this, bundle, qBaseActivity);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Class<?> cls;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (((BaseBannerProcessor) GameBannerProcessor.this).handler != null) {
                    ((BaseBannerProcessor) GameBannerProcessor.this).handler.sendEmptyMessageDelayed(1000, 2500L);
                }
                String string = this.f185211d.getString(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        cls = Class.forName(string);
                    } catch (ClassNotFoundException unused) {
                        cls = null;
                    }
                    if (cls != null) {
                        Intent intent = new Intent(this.f185212e.getApplicationContext(), cls);
                        String string2 = this.f185211d.getString("action");
                        if (!TextUtils.isEmpty(string2)) {
                            intent.setAction(string2);
                        }
                        String string3 = this.f185211d.getString("category");
                        if (!TextUtils.isEmpty(string3)) {
                            intent.addCategory(string3);
                        }
                        String string4 = this.f185211d.getString("url");
                        if (!TextUtils.isEmpty(string4)) {
                            intent.putExtra("url", string4);
                        }
                        intent.setFlags(this.f185211d.getInt(WadlProxyConsts.FLAGS, 0));
                        intent.putExtra("force_no_reload", true);
                        this.f185212e.startActivity(intent);
                    }
                }
                ReportController.r(this.f185212e.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_READ, BaseBannerProcessor.TVALUE_CLICK_READ, 4, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements e.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f185214d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Message f185215e;

        b(Bundle bundle, Message message) {
            this.f185214d = bundle;
            this.f185215e = message;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, GameBannerProcessor.this, bundle, message);
            }
        }

        @Override // gp3.e.b
        public void onImageLoaded(String str, Bitmap bitmap, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, bitmap, str2);
                return;
            }
            this.f185214d.putParcelable("iconURLBitmap", bitmap);
            BannerManager.l().O(GameBannerProcessor.f185210d, 2, this.f185215e);
            this.f185215e.recycle();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69202);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f185210d = com.tencent.mobileqq.banner.d.J;
        }
    }

    public GameBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.handler = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.handler.sendEmptyMessage(1000);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
        } else {
            this.handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return f185210d;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1000) {
            BannerManager.l().O(f185210d, 0, message);
            return true;
        }
        if (i3 == 1134049) {
            i(message);
            return true;
        }
        return true;
    }

    public void i(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) message);
            return;
        }
        Bundle bundle = (Bundle) message.obj;
        String string = bundle.getString(MiniBoxNoticeInfo.KEY_ICON_URL);
        if (!TextUtils.isEmpty(string)) {
            gp3.e.a().c(string, new b(bundle, Message.obtain(message)));
        } else {
            BannerManager.l().O(f185210d, 2, message);
        }
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
        if (QLog.isColorLevel()) {
            QLog.d(QzoneConfig.SECONDARY_GAMEBAR, 2, "initGameBar");
        }
        return QUINoticeBarManager.l().h(baseActivity).setIcon(R.drawable.c47).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            BannerManager.l().K(f185210d, 0);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        if (message != null && ((i3 = message.what) == 1134049 || i3 == 1134050)) {
            if (QLog.isColorLevel()) {
                QLog.d(QzoneConfig.SECONDARY_GAMEBAR, 2, "updateGameBar msg.obj = " + message.obj);
            }
            QBaseActivity baseActivity = getBaseActivity();
            if (baseActivity == null) {
                return;
            }
            if (message.what == 1134050) {
                aVar.f200243c.setVisibility(8);
                return;
            }
            com.tencent.biz.qui.noticebar.d d16 = QUINoticeBarManager.l().d(aVar.f200243c);
            if (d16 != null && (message.obj instanceof Bundle)) {
                aVar.f200243c.setVisibility(0);
                Bundle bundle = (Bundle) message.obj;
                String str = (String) bundle.getCharSequence("tips");
                int i16 = bundle.getInt("icon");
                if (bundle.containsKey("iconURLBitmap")) {
                    d16.setIcon(new BitmapDrawable((Bitmap) bundle.getParcelable("iconURLBitmap")));
                } else if (i16 != 1) {
                    d16.setIcon(baseActivity.getResources().getDrawable(i16));
                }
                if (!TextUtils.isEmpty(str)) {
                    d16.setMsg(str);
                    d16.c(new a(bundle, baseActivity));
                    d16.k(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GameBannerProcessor.this.h(view);
                        }
                    });
                    this.handler.removeMessages(1000);
                    this.handler.sendEmptyMessageDelayed(1000, bundle.getInt("timeout", 900000));
                    ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_READ, BaseBannerProcessor.TVALUE_SHOW_READ, 4, 0, "", "", "", "");
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(QzoneConfig.SECONDARY_GAMEBAR, 2, "updateGameBar msg " + message);
        }
    }
}
