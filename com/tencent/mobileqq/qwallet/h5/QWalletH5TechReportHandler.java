package com.tencent.mobileqq.qwallet.h5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\u000bB\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b!\u0010\u0010J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R#\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5TechReportHandler;", "", "", "key", "time", "b", "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "", "e", h.F, "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "hostUrl", "", "J", "getEnterTime", "()J", "f", "(J)V", "enterTime", "", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "h5ReportParams", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "h5ReportReceiver", "<init>", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletH5TechReportHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String hostUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long enterTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> h5ReportParams = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BroadcastReceiver h5ReportReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qwallet.h5.QWalletH5TechReportHandler$h5ReportReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @Nullable Intent intent) {
            String stringExtra;
            String b16;
            boolean contains$default;
            Intrinsics.checkNotNullParameter(context, "context");
            if (intent == null || (stringExtra = intent.getStringExtra("BROADCAST_KEY_REPORT_DATA")) == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String stringExtra2 = intent.getStringExtra("BROADCAST_KEY_REPORT_URL");
                String hostUrl = QWalletH5TechReportHandler.this.getHostUrl();
                if (hostUrl != null) {
                    boolean z16 = false;
                    if (stringExtra2 != null) {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) stringExtra2, (CharSequence) hostUrl, false, 2, (Object) null);
                        if (contains$default) {
                            z16 = true;
                        }
                    }
                    if (z16) {
                        Iterator keys = jSONObject.keys();
                        Intrinsics.checkNotNullExpressionValue(keys, "reportJsonData.keys()");
                        QWalletH5TechReportHandler qWalletH5TechReportHandler = QWalletH5TechReportHandler.this;
                        while (keys.hasNext()) {
                            String key = (String) keys.next();
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            String optString = jSONObject.optString(key);
                            Intrinsics.checkNotNullExpressionValue(optString, "reportJsonData.optString(key)");
                            b16 = qWalletH5TechReportHandler.b(key, optString);
                            qWalletH5TechReportHandler.c().put(key, b16);
                        }
                        return;
                    }
                }
                QLog.w("QWalletHomeH5ReportHandler", 1, "ignored broadcast, not target: " + hostUrl + ", event" + stringExtra2);
            } catch (JSONException e16) {
                QLog.w("QWalletHomeH5ReportHandler", 1, "h5ReportReceiver error:", e16);
            }
        }
    };

    public QWalletH5TechReportHandler(@Nullable String str) {
        this.hostUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b(String key, String time) {
        boolean endsWith$default;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(key, "Time", false, 2, null);
        if (endsWith$default) {
            try {
                return String.valueOf(Long.parseLong(time) - this.enterTime);
            } catch (NumberFormatException e16) {
                QLog.w("QWalletHomeH5ReportHandler", 1, "changeTimeToCostIfNeed error:", e16);
            }
        }
        return time;
    }

    @NotNull
    public final Map<String, String> c() {
        return this.h5ReportParams;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getHostUrl() {
        return this.hostUrl;
    }

    public final void e(@NotNull QBaseFragment fragment) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("QWALLET_BROADCAST_H5_REPORT_EVENT");
        Context context = fragment.getContext();
        if (context != null && (applicationContext = context.getApplicationContext()) != null) {
            applicationContext.registerReceiver(this.h5ReportReceiver, intentFilter);
        }
    }

    public final void f(long j3) {
        this.enterTime = j3;
    }

    public final void g(@Nullable String str) {
        this.hostUrl = str;
    }

    public final void h(@NotNull QBaseFragment fragment) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        try {
            Context context = fragment.getContext();
            if (context != null && (applicationContext = context.getApplicationContext()) != null) {
                applicationContext.unregisterReceiver(this.h5ReportReceiver);
            }
        } catch (Exception e16) {
            QLog.d("QWalletHomeH5ReportHandler", 2, "unregister catch:", e16);
        }
    }
}
