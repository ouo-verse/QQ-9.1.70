package com.tencent.mobileqq.vashealth;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ads.data.AdParam;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ad;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.lp.LpReportInfo_dc00307;
import cooperation.qzone.report.lp.LpReportManager;
import gp3.e;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClassConstructor
/* loaded from: classes20.dex */
public class RunningBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.b, Handler.Callback {

    /* renamed from: e, reason: collision with root package name */
    public static final int f312172e = com.tencent.mobileqq.banner.d.K;

    /* renamed from: d, reason: collision with root package name */
    private boolean f312173d = true;

    /* loaded from: classes20.dex */
    class a implements e.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f312180d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Message f312181e;

        a(Bundle bundle, Message message) {
            this.f312180d = bundle;
            this.f312181e = message;
        }

        @Override // gp3.e.b
        public void onImageLoaded(String str, Bitmap bitmap, String str2) {
            this.f312180d.putParcelable("icon", bitmap);
            BannerManager.l().O(RunningBannerProcessor.f312172e, 2, this.f312181e);
        }
    }

    public RunningBannerProcessor(QBaseActivity qBaseActivity) {
        this.handler = new ad(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.handler.sendEmptyMessage(3000);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        this.handler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        return f312172e;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 3000) {
            BannerManager.l().O(f312172e, 0, message);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RunningBar", 2, "initRunningBar");
        }
        return QUINoticeBarManager.l().h(baseActivity).setIcon(R.drawable.c4c).e(R.string.jw_).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        BannerManager.l().K(f312172e, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0128 A[Catch: JSONException -> 0x01a0, TryCatch #0 {JSONException -> 0x01a0, blocks: (B:29:0x0065, B:33:0x00ad, B:35:0x0112, B:37:0x0128, B:38:0x013a, B:40:0x0148, B:41:0x015f, B:44:0x00c6, B:46:0x00d0, B:47:0x00ea, B:49:0x00f2), top: B:28:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0148 A[Catch: JSONException -> 0x01a0, TryCatch #0 {JSONException -> 0x01a0, blocks: (B:29:0x0065, B:33:0x00ad, B:35:0x0112, B:37:0x0128, B:38:0x013a, B:40:0x0148, B:41:0x015f, B:44:0x00c6, B:46:0x00d0, B:47:0x00ea, B:49:0x00f2), top: B:28:0x0065 }] */
    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        com.tencent.biz.qui.noticebar.d d16;
        final String str;
        String str2;
        String str3;
        if (message == null) {
            if (QLog.isColorLevel()) {
                QLog.d("runningState", 2, "updateRunningBar msg " + message);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RunningBar", 2, "updateRunningBar msg.obj = " + message.obj);
        }
        final QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (d16 = QUINoticeBarManager.l().d(aVar.f200243c)) == null) {
            return;
        }
        Object obj = message.obj;
        if (obj instanceof JSONObject) {
            try {
                final Long valueOf = Long.valueOf(((JSONObject) obj).getLong("runningState"));
                String string = ((JSONObject) message.obj).getString("cookieUrl");
                String optString = ((JSONObject) message.obj).optString("title");
                ((JSONObject) message.obj).optInt(AdParam.ACTID);
                final int optInt = ((JSONObject) message.obj).optInt("appid");
                String str4 = null;
                if (valueOf.longValue() == 1) {
                    d16.setMsg(HardCodeUtil.qqStr(R.string.jw7));
                    str3 = string + "&ADTAG=aio.run.click";
                } else if (valueOf.longValue() == 2) {
                    d16.setMsg(HardCodeUtil.qqStr(R.string.jvz));
                    str3 = string + "&ADTAG=aio.run.click";
                } else if (valueOf.longValue() == 3) {
                    d16.setMsg(optString);
                    str3 = string + "&ADTAG=qqlist.tongzhi.hongbao.click";
                    str4 = ((JSONObject) message.obj).optString("icon");
                } else {
                    str = null;
                    str2 = null;
                    d16.c(new View.OnClickListener() { // from class: com.tencent.mobileqq.vashealth.RunningBannerProcessor.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            if (RunningBannerProcessor.this.f312173d) {
                                RunningBannerProcessor.this.f312173d = false;
                                new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vashealth.RunningBannerProcessor.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        RunningBannerProcessor.this.f312173d = true;
                                    }
                                }, 1000L);
                                String currentAccountUin = baseActivity.getAppRuntime().getCurrentAccountUin();
                                StringBuilder sb5 = new StringBuilder(str);
                                sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                                sb5.append("uin=");
                                sb5.append(currentAccountUin);
                                sb5.append("&plat=1");
                                sb5.append("&app=1");
                                sb5.append("&version=" + AppSetting.f99554n);
                                sb5.append("&device=" + URLEncoder.encode(Build.DEVICE));
                                sb5.append("&system=" + Build.VERSION.RELEASE);
                                sb5.append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
                                String sb6 = sb5.toString();
                                Intent intent = new Intent();
                                intent.putExtra("portraitOnly", true);
                                intent.putExtra("url", sb6);
                                intent.putExtra("uin", currentAccountUin);
                                intent.putExtra("hide_operation_bar", true);
                                intent.putExtra("hide_more_button", true);
                                VasWebviewUtil.openQQBrowserActivity(baseActivity, sb6, 32768L, intent, false, -1);
                                if (valueOf.longValue() == 3) {
                                    ((BaseBannerProcessor) RunningBannerProcessor.this).handler.sendEmptyMessage(3000);
                                    LpReportManager.getInstance().reportToDC00307(new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_CLICK, optInt), false, true);
                                }
                                ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_READ, BaseBannerProcessor.TVALUE_CLICK_READ, 9, 0, "", "", "", "");
                            }
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                    if (valueOf.longValue() == 3) {
                        LpReportManager.getInstance().reportToDC00307(new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_EXPOSURE, optInt), false, true);
                    }
                    d16.k(new View.OnClickListener() { // from class: com.tencent.mobileqq.vashealth.s
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RunningBannerProcessor.this.i(view);
                        }
                    });
                    if (!TextUtils.isEmpty(str2)) {
                        Bundle bundle = new Bundle();
                        message.obj = bundle;
                        gp3.e.a().c(str2, new a(bundle, Message.obtain(message)));
                    }
                    ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_READ, BaseBannerProcessor.TVALUE_SHOW_READ, 9, 0, "", "", "", "");
                    return;
                }
                str = str3;
                str2 = str4;
                d16.c(new View.OnClickListener() { // from class: com.tencent.mobileqq.vashealth.RunningBannerProcessor.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        if (RunningBannerProcessor.this.f312173d) {
                            RunningBannerProcessor.this.f312173d = false;
                            new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vashealth.RunningBannerProcessor.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    RunningBannerProcessor.this.f312173d = true;
                                }
                            }, 1000L);
                            String currentAccountUin = baseActivity.getAppRuntime().getCurrentAccountUin();
                            StringBuilder sb5 = new StringBuilder(str);
                            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                            sb5.append("uin=");
                            sb5.append(currentAccountUin);
                            sb5.append("&plat=1");
                            sb5.append("&app=1");
                            sb5.append("&version=" + AppSetting.f99554n);
                            sb5.append("&device=" + URLEncoder.encode(Build.DEVICE));
                            sb5.append("&system=" + Build.VERSION.RELEASE);
                            sb5.append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
                            String sb6 = sb5.toString();
                            Intent intent = new Intent();
                            intent.putExtra("portraitOnly", true);
                            intent.putExtra("url", sb6);
                            intent.putExtra("uin", currentAccountUin);
                            intent.putExtra("hide_operation_bar", true);
                            intent.putExtra("hide_more_button", true);
                            VasWebviewUtil.openQQBrowserActivity(baseActivity, sb6, 32768L, intent, false, -1);
                            if (valueOf.longValue() == 3) {
                                ((BaseBannerProcessor) RunningBannerProcessor.this).handler.sendEmptyMessage(3000);
                                LpReportManager.getInstance().reportToDC00307(new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_CLICK, optInt), false, true);
                            }
                            ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_READ, BaseBannerProcessor.TVALUE_CLICK_READ, 9, 0, "", "", "", "");
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                if (valueOf.longValue() == 3) {
                }
                d16.k(new View.OnClickListener() { // from class: com.tencent.mobileqq.vashealth.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RunningBannerProcessor.this.i(view);
                    }
                });
                if (!TextUtils.isEmpty(str2)) {
                }
                ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_READ, BaseBannerProcessor.TVALUE_SHOW_READ, 9, 0, "", "", "", "");
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        if (obj instanceof Bundle) {
            Bundle bundle2 = (Bundle) obj;
            if (bundle2.containsKey("icon")) {
                d16.setIcon(new BitmapDrawable((Bitmap) bundle2.getParcelable("icon")));
            }
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onPause() {
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onResume() {
    }
}
