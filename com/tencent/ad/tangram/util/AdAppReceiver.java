package com.tencent.ad.tangram.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.statistics.AdReporterOfDeeplink;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdClickUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@AdKeep
@Deprecated
/* loaded from: classes3.dex */
final class AdAppReceiver extends BroadcastReceiver {
    private static final String TAG = "AdAppReceiver";

    @NonNull
    private final Map<String, Item> data = new HashMap();
    private volatile boolean registered = false;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Item {
        public AdClickUtil.Params params;

        @Nullable
        public AdClickUtil.Result result;

        protected Item(@Nullable AdClickUtil.Params params, @Nullable AdClickUtil.Result result) {
            this.params = params;
            this.result = result;
        }
    }

    AdAppReceiver() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerImpl(@Nullable Context context) {
        if (context != null && !this.registered) {
            synchronized (this) {
                if (this.registered) {
                    return;
                }
                this.registered = true;
                AdLog.i(TAG, "registerImpl");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                try {
                    context.registerReceiver(this, intentFilter);
                } catch (Throwable th5) {
                    AdLog.e(TAG, "registerImpl", th5);
                }
            }
        }
    }

    private void unObserve(String str) {
        this.data.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterImpl(@Nullable Context context) {
        if (context != null && this.registered) {
            synchronized (this) {
                if (!this.registered) {
                    return;
                }
                this.registered = false;
                AdLog.i(TAG, "unregisterImpl");
                try {
                    context.unregisterReceiver(this);
                } catch (Throwable th5) {
                    AdLog.e(TAG, "unregisterImpl", th5);
                }
            }
        }
    }

    @Nullable
    protected Item getItem(String str) {
        if (this.data.containsKey(str)) {
            return this.data.get(str);
        }
        return null;
    }

    public void observe(@Nullable AdClickUtil.Params params, @Nullable AdClickUtil.Result result) {
        if (params != null && params.isValidForApp()) {
            AdLog.i(TAG, String.format("observe %s", params.f61334ad.getAppPackageName()));
            this.data.put(params.f61334ad.getAppPackageName(), new Item(params, result));
        } else {
            AdLog.e(TAG, "observe error");
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (context != null && intent != null) {
            AdLog.i(TAG, "onReceive");
            if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED")) {
                onReceivePackageAdded(context, intent);
                return;
            }
            return;
        }
        AdLog.e(TAG, "onReceive error");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onReceivePackageAdded(@Nullable Context context, @Nullable Intent intent) {
        final AdClickUtil.Params params;
        int i3;
        int i16;
        if (context != null && intent != null && TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED") && intent.getData() != null && !TextUtils.isEmpty(intent.getData().getSchemeSpecificPart())) {
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            int i17 = 1;
            AdLog.i(TAG, String.format("onReceivePackageAdded %s", schemeSpecificPart));
            Item item = getItem(schemeSpecificPart);
            AdClickUtil.Result result = null;
            if (item != null) {
                params = item.params;
            } else {
                params = null;
            }
            if (item != null) {
                result = item.result;
            }
            if (params == null) {
                return;
            }
            unObserve(schemeSpecificPart);
            if (params.isValidForApp()) {
                AdReporterForEffect.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, 286);
            }
            if (result != null && !TextUtils.isEmpty(params.f61334ad.getAppMarketDeeplink())) {
                int appMarketJumpType = params.f61334ad.getAppMarketJumpType();
                if (appMarketJumpType == 1 && result.action == 8) {
                    i16 = sdk_event_log.SdkEventDimension.EVENT_APP_INSTALL_SUCCESS_FROM_APP_MARKET;
                } else if (appMarketJumpType == 2) {
                    i16 = sdk_event_log.SdkEventDimension.EVENT_APP_INSTALL_SUCCESS_FROM_APP_MARKET_BY_XIJING;
                    i17 = 3;
                } else {
                    i3 = Integer.MIN_VALUE;
                    i17 = 0;
                    if (i3 != Integer.MIN_VALUE) {
                        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
                        reportBiz.download_scene = i17;
                        AdReporterForLinkEvent.getInstance().reportAsync(params.activity.get(), i3, params.f61334ad, reportBiz, null);
                    }
                }
                i3 = i16;
                if (i3 != Integer.MIN_VALUE) {
                }
            }
            if (params.isValidForApp()) {
                AdThreadManager.getInstance().postDelayed(new Runnable() { // from class: com.tencent.ad.tangram.util.AdAppReceiver.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AdClickUtil.Params params2 = params;
                        if (!TextUtils.isEmpty(params2.f61334ad.getAppDeeplink(params2.clickLocationParams))) {
                            AdReporterOfDeeplink.report(params, AdClickUtil.handleAppWithDeeplink(params, 1, true), true);
                        } else {
                            AdClickUtil.handleApp(params, true);
                        }
                    }
                }, 0, 1000L);
                return;
            }
            return;
        }
        AdLog.e(TAG, "onReceivePackageAdded error");
    }

    public void register(@Nullable Context context) {
        if (context != null && !this.registered) {
            final WeakReference weakReference = new WeakReference(context);
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.util.AdAppReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    AdAppReceiver.this.registerImpl((Context) weakReference.get());
                }
            }, 3);
        }
    }

    public void unregister(@Nullable Context context) {
        if (context != null && this.registered) {
            final WeakReference weakReference = new WeakReference(context);
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.util.AdAppReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    AdAppReceiver.this.unregisterImpl((Context) weakReference.get());
                }
            }, 3);
        }
    }
}
