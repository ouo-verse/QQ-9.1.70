package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class l {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<CheckBox> f306783d;

        a(CheckBox checkBox) {
            this.f306783d = new WeakReference<>(checkBox);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CheckBox checkBox = this.f306783d.get();
            if (checkBox != null) {
                checkBox.performClick();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private static void a(Context context) {
        try {
            Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(50L);
            }
        } catch (Exception e16) {
            QLog.e("CheckBoxClauseUtil", 1, "exception when doVibrate.", e16);
        }
    }

    public static List<RichTextHelper.RichTextData> b(CheckBox checkBox) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RichTextHelper.RichTextData(HardCodeUtil.qqStr(R.string.f211305kg), (String) null, new a(checkBox)));
        if (AppSetting.f99565y) {
            arrayList.clear();
        }
        arrayList.add(new RichTextHelper.RichTextData(HardCodeUtil.qqStr(R.string.f211325ki), com.tencent.mobileqq.loginregister.z.h(d(AppConstants.URL.SERVICE_PROTOCOL))));
        arrayList.add(new RichTextHelper.RichTextData(HardCodeUtil.qqStr(R.string.f211315kh), com.tencent.mobileqq.loginregister.z.h(d(AppConstants.URL.PRIVATE_PROTOCOL))));
        return arrayList;
    }

    public static String c() {
        return HardCodeUtil.qqStr(R.string.f211305kg) + HardCodeUtil.qqStr(R.string.f211325ki) + HardCodeUtil.qqStr(R.string.f211295kf) + HardCodeUtil.qqStr(R.string.f211315kh);
    }

    public static String d(String str) {
        return URLUtil.addParameter(str, "_wv", String.valueOf(2L));
    }

    public static void e(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("url", d(str));
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    public static void f(Context context, View view) {
        if (context != null && view != null) {
            try {
                view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.f155059vh));
                a(context);
                if (AppSetting.f99565y) {
                    view.announceForAccessibility("\u8bf7\u52fe\u9009\u534f\u8bae");
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e("CheckBoxClauseUtil", 1, "exception when triggerAgreementWarning.", th5);
                return;
            }
        }
        QLog.d("CheckBoxClauseUtil", 1, "context or view is null");
    }
}
