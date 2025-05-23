package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class v extends com.tencent.mobileqq.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public MutableLiveData<Boolean> f185029h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f185030i;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Observer<Boolean> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) v.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            RedTouch q16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                return;
            }
            if (!TianshuRedTouch.INSTANCE.j() && bool.booleanValue()) {
                for (QQSettingMeBizBean qQSettingMeBizBean : com.tencent.mobileqq.qqsettingme.a.d().values()) {
                    if (!v.this.f185030i && (q16 = qQSettingMeBizBean.q()) != null) {
                        q16.clearRedTouch();
                    }
                    RedTouchTextView p16 = qQSettingMeBizBean.p();
                    if (p16 == null) {
                        return;
                    }
                    BusinessInfoCheckUpdate.AppInfo h16 = p16.h();
                    if (h16 != null && h16.exposure_max.get() <= 0) {
                        h16.iNewFlag.set(0);
                        p16.setAppInfo(h16);
                    }
                }
            }
        }
    }

    public v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185029h = new MutableLiveData<>(Boolean.FALSE);
            this.f185030i = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("drawer_red_touch_on_measure_anr_bugfix", true);
        }
    }

    private boolean n() {
        if (1 == QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TIANSHU_FEATURE, QzoneConfig.SECONDARY_KEY_TIANSHU_FEATURE_RED_TOUCH_DISMISS, 1)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f185029h.observe(this.f259743d, new a());
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            VipInfoHandler.H2(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
            PrivacyPolicyHelper.preloadSP();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        if ((view.getId() == R.id.f165026um4 || view.getId() == R.id.f165025um3) && FrameHelperActivity.Gi()) {
            FrameHelperActivity.gj(true, "QQSettingMeDrawerProcessor");
            FrameHelperActivity.Zh();
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "CliOper", "", "", "0X8009C4E", "0X8009C4E", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onPause();
            this.f185029h.setValue(Boolean.valueOf(n()));
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        super.onResume();
        if (ImmersiveUtils.isSupporImmersive() != 0 && ImmersiveUtils.couldSetStatusTextColor() && !QQTheme.isNowThemeIsNight() && SimpleUIUtil.getSimpleUISwitch()) {
            ImmersiveUtils.setStatusTextColorNew(true, qBaseActivity.getWindow());
        }
        AbstractGifImage.resumeAll();
        AbstractVideoImage.resumeAll();
        ApngImage.playByTag(1);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_common";
    }
}
