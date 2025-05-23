package com.tencent.mobileqq.activity.aio.ecommerce;

import android.text.Spannable;
import android.text.TextUtils;
import com.tencent.luggage.wxa.v6.d;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportConfigProcessor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ECommerceDataReportUtil {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f178647a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f178648b = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(AppRuntime appRuntime, String str, int i3, String str2) {
        for (Map.Entry<String, String> entry : f178647a.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(str)) {
                if (str.contains(key)) {
                    if (i3 != 5 || (!TextUtils.isEmpty(str2) && str2.contains(key))) {
                        String value = entry.getValue();
                        ReportController.o(appRuntime, "dc00898", "", "", value, value, i3, 0, "", "", "", "");
                        if (QLog.isDevelopLevel()) {
                            QLog.d("ECommerceDataReportUtil", 4, "checkAndReport : doReport key -> " + key + ", type => " + i3 + ", reportTag -> " + value + "\uff0c clickUrl -> " + str2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    private static String e(MessageRecord messageRecord) {
        if (messageRecord instanceof MessageForText) {
            CharSequence charSequence = ((MessageForText) messageRecord).charStr;
            if (charSequence instanceof QQText) {
                return ((QQText) charSequence).mSource;
            }
            if (charSequence instanceof Spannable) {
                return charSequence.toString();
            }
            return "";
        }
        if (messageRecord instanceof MessageForMixedMsg) {
            return messageRecord.f203106msg;
        }
        if (messageRecord instanceof MessageForReplyText) {
            return ((MessageForReplyText) messageRecord).getSummaryMsg();
        }
        return "";
    }

    private static boolean f(AppRuntime appRuntime) {
        HashMap<String, String> hashMap = f178647a;
        if (hashMap != null && !hashMap.isEmpty() && appRuntime != null && !TextUtils.isEmpty(f178648b) && f178648b.equals(appRuntime.getCurrentAccountUin())) {
            return true;
        }
        return false;
    }

    private static boolean g(MessageRecord messageRecord) {
        boolean z16;
        if (!(messageRecord instanceof MessageForText) && !(messageRecord instanceof MessageForMixedMsg) && !(messageRecord instanceof MessageForReplyText)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ECommerceDataReportUtil", 4, "isMessageNeedReport : need -> " + z16);
        }
        return z16;
    }

    public static void h(AppRuntime appRuntime, MessageRecord messageRecord, int i3) {
        i(appRuntime, messageRecord, i3, "");
    }

    public static void i(final AppRuntime appRuntime, MessageRecord messageRecord, final int i3, final String str) {
        if (g(messageRecord)) {
            final String e16 = e(messageRecord);
            if (QLog.isDevelopLevel()) {
                QLog.d("ECommerceDataReportUtil", 4, "reportECommerceData  reportConfig -> " + f178647a);
            }
            if (!f(appRuntime)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("ECommerceDataReportUtil", 4, "reportECommerceData load config from QConfigManager");
                }
                final WeakReference weakReference = new WeakReference(appRuntime);
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        HashMap<String, String> hashMap;
                        try {
                            ECommerceDataReportConfigProcessor.a aVar = (ECommerceDataReportConfigProcessor.a) am.s().x(d.CTRL_INDEX);
                            if (aVar != null && (hashMap = aVar.f178646a) != null && !hashMap.isEmpty()) {
                                ECommerceDataReportUtil.f178647a = aVar.f178646a;
                                ECommerceDataReportUtil.f178648b = AppRuntime.this.getCurrentAccountUin();
                                ECommerceDataReportUtil.d((AppRuntime) weakReference.get(), e16, i3, str);
                            }
                        } catch (Throwable th5) {
                            QLog.e("ECommerceDataReportUtil", 1, th5, new Object[0]);
                        }
                    }
                });
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("ECommerceDataReportUtil", 4, "reportECommerceData hit cache");
            }
            d(appRuntime, e16, i3, str);
        }
    }
}
