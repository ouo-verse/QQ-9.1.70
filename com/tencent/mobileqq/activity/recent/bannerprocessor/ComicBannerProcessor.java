package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class ComicBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.b, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185203d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69195);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f185203d = com.tencent.mobileqq.banner.d.G;
        }
    }

    public ComicBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.handler = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(QBaseActivity qBaseActivity, String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "20");
        } catch (Exception unused) {
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(qBaseActivity, RouterConstants.UI_ROUTER_VIPCOMIC);
        activityURIRequest.extra().putString("options", jSONObject.toString());
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145((AppInterface) qBaseActivity.getAppRuntime(), "100007", "2", "40040", str, new String[0]);
        ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_READ, BaseBannerProcessor.TVALUE_CLICK_READ, 2, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
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
        return f185203d;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1000) {
            BannerManager.l().O(f185203d, 0, message);
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
            QLog.d("ComicBar", 2, "initComicBar");
        }
        return QUINoticeBarManager.l().h(baseActivity).setIcon(R.drawable.f160263c45).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        if (message != null && message.what == 1134039) {
            final QBaseActivity baseActivity = getBaseActivity();
            if (baseActivity == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ComicBar", 2, "updateComicBar msg.obj = " + message.obj);
            }
            com.tencent.biz.qui.noticebar.d d16 = QUINoticeBarManager.l().d(aVar.f200243c);
            if (d16 == null) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                String string = bundle.getString("comicName");
                final String string2 = bundle.getString(ComicCancelRedPointPopItemData.JSON_KEY_COMIC_ID);
                int i3 = bundle.getInt("type", -1);
                if (!TextUtils.isEmpty(string)) {
                    DisplayMetrics displayMetrics = baseActivity.getResources().getDisplayMetrics();
                    Paint paint = new Paint();
                    paint.setTextSize(ViewUtils.dip2px(14.0f));
                    int measureText = (int) (paint.measureText(string) / string.length());
                    int i16 = displayMetrics.widthPixels;
                    int i17 = displayMetrics.heightPixels;
                    if (i16 > i17) {
                        i16 = i17;
                    }
                    int i18 = ((int) ((i16 - (displayMetrics.density * 65.0f)) / measureText)) - 8;
                    if (string.length() > i18) {
                        string = string.substring(0, i18) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    }
                    if (i3 >= 100 && i3 <= 300) {
                        d16.setMsg(HardCodeUtil.qqStr(R.string.jvv) + string + "\u300b");
                    } else {
                        d16.setMsg(HardCodeUtil.qqStr(R.string.jw6) + string + "\u300b");
                    }
                    d16.c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.f
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ComicBannerProcessor.f(QBaseActivity.this, string2, view);
                        }
                    });
                    this.handler.removeMessages(1000);
                    this.handler.sendEmptyMessageDelayed(1000, 900000L);
                    ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_READ, BaseBannerProcessor.TVALUE_SHOW_READ, 2, 0, "", "", "", "");
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ComicBar", 2, "updateComicBar msg " + message);
        }
    }
}
