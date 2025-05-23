package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.device.AdTAID;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdRelationTargetMatch {
    private static final String INSTALL_STATUS_INSTALLED = "1";
    private static final String INSTALL_STATUS_UNINSTALLED = "0";
    private static final int RELATION_TARGET_INSTALLED = 2;
    private static final int RELATION_TARGET_UNINSTALLED = 1;
    private static final int RELATION_TARGET_UNLIMITED = 0;
    private static final String TAG = "AdRelationTargetMatch";

    public static void handle(@Nullable WeakReference<Context> weakReference, @Nullable Ad ad5) {
        AdLog.i(TAG, "handle begin");
        if (ad5 != null && ad5.isValid()) {
            if (ad5.isAppProductType()) {
                handleApp(weakReference, ad5);
                return;
            } else {
                if (ad5.isJDProductType()) {
                    handleJD(weakReference, ad5);
                    return;
                }
                return;
            }
        }
        AdLog.e(TAG, "handle error. Ad invalid");
    }

    private static void handleApp(@Nullable WeakReference<Context> weakReference, @Nullable Ad ad5) {
        Context context;
        AdLog.i(TAG, "handleApp begin");
        if (ad5 != null && ad5.isValid()) {
            String appPackageName = ad5.getAppPackageName();
            int relationTarget = ad5.getRelationTarget();
            if (!TextUtils.isEmpty(appPackageName) && relationTarget > 0) {
                if (weakReference != null) {
                    context = weakReference.get();
                } else {
                    context = null;
                }
                boolean isInstalled = AdAppUtil.isInstalled(context, appPackageName);
                if (isInstalled && relationTarget == 1) {
                    AdLog.i(TAG, "handleApp \u5df2\u5b89\u88c5 && \u5b9a\u5411\u672a\u5b89\u88c5");
                    report(weakReference, ad5, "1");
                    return;
                } else {
                    if (!isInstalled && relationTarget == 2) {
                        AdLog.i(TAG, "handleApp \u672a\u5b89\u88c5 && \u5b9a\u5411\u5df2\u5b89\u88c5");
                        report(weakReference, ad5, "0");
                        return;
                    }
                    return;
                }
            }
            AdLog.i(TAG, "App packageName empty or relation target unlimited");
            return;
        }
        AdLog.e(TAG, "handleApp error. Ad invalid");
    }

    private static void handleJD(@Nullable WeakReference<Context> weakReference, @Nullable Ad ad5) {
        Context context;
        String str;
        AdLog.i(TAG, "handleJD begin");
        if (ad5 != null && ad5.isValid()) {
            String appPackageName = ad5.getAppPackageName();
            if (TextUtils.isEmpty(appPackageName)) {
                AdLog.i(TAG, "JD packageName empty");
                return;
            }
            if (weakReference != null) {
                context = weakReference.get();
            } else {
                context = null;
            }
            if (AdAppUtil.isInstalled(context, appPackageName)) {
                str = "1";
            } else {
                str = "0";
            }
            AdLog.i(TAG, "handleJD installStatus: " + str);
            report(weakReference, ad5, str);
            return;
        }
        AdLog.e(TAG, "handleJD error. Ad invalid");
    }

    private static void report(@Nullable final WeakReference<Context> weakReference, @Nullable final Ad ad5, final String str) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.statistics.AdRelationTargetMatch.1
            @Override // java.lang.Runnable
            public void run() {
                Context context;
                String str2;
                try {
                    Ad ad6 = Ad.this;
                    if (ad6 != null && ad6.isValid()) {
                        AdTAID adTAID = AdTAID.getInstance();
                        WeakReference weakReference2 = weakReference;
                        String str3 = null;
                        if (weakReference2 != null) {
                            context = (Context) weakReference2.get();
                        } else {
                            context = null;
                        }
                        AdTAID.Entity entity = adTAID.getEntity(context);
                        if (entity != null) {
                            str2 = entity.aidTicket;
                        } else {
                            str2 = null;
                        }
                        if (entity != null) {
                            str3 = entity.taidTicket;
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("package_name", Ad.this.getAppPackageName());
                        jSONObject.put("timestamp", System.currentTimeMillis() + "");
                        jSONObject.put("install_status", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("od", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("td", str3);
                        }
                        AdReporterForSdkMsg.reportMsg(weakReference, Ad.this, 1006, jSONObject);
                        return;
                    }
                    AdLog.e(AdRelationTargetMatch.TAG, "report error. Ad invalid");
                } catch (Throwable th5) {
                    AdLog.e(AdRelationTargetMatch.TAG, "report failed", th5);
                }
            }
        }, 4);
    }
}
