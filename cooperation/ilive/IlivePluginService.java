package cooperation.ilive;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.report.h;
import com.tencent.mobileqq.qqlive.room.frame.activity.QQliveRoomActivity;
import com.tencent.mobileqq.qqlive.room.frame.activity.QQliveTranslucentRoomActivity;
import com.tencent.mobileqq.qqlive.room.util.a;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.qqlive.sail.ui.QQLiveRoomListFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import java.util.Map;
import mqq.app.Foreground;

/* loaded from: classes28.dex */
public class IlivePluginService extends Service {

    /* renamed from: e, reason: collision with root package name */
    private static IAegisLogApi f390128e = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: d, reason: collision with root package name */
    private long f390129d = 0;

    private void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        QQLiveContext.Companion companion = QQLiveContext.INSTANCE;
        companion.f(companion.d(str));
        if (QLog.isColorLevel()) {
            QLog.d("IlivePluginService", 1, "[ensureLiveContext] cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", traceId=" + str);
        }
    }

    private void b(String str, boolean z16, String str2, boolean z17, Intent intent) {
        if (c.f272176a.d().t()) {
            QQToast.makeText(this, 4, "\u4f60\u6b63\u5728\u76f4\u64ad\u4e2d\uff0c\u6682\u65f6\u65e0\u6cd5\u8fdb\u5165\u5176\u4ed6\u76f4\u64ad\u95f4", 0).show();
            g();
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        if (!z17) {
            intent.addFlags(67108864);
        }
        intent.addFlags(268435456);
        intent.addFlags(131072);
        intent.putExtra("key_intent_app_id", QQLiveBusinessConfig.QQLIVE_APP_ID);
        intent.putExtra(QQLiveReportConstants.INTENT_TRACE_ID, str);
        intent.putExtra("source", str2);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("public_fragment_class", QQLiveRoomListFragment.class.getName());
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QQLIVE_SKIN");
        if (z16) {
            intent.setClass(this, QQliveTranslucentRoomActivity.class);
        } else {
            intent.setClass(this, QQliveRoomActivity.class);
        }
        startActivity(intent);
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra("extra_key_mqq_schema");
        f390128e.i("IlivePluginService", "enterRoom, mqqSchema " + stringExtra);
        Map<String, String> a16 = a.a(stringExtra);
        String str = a16.get("traceId");
        a(str);
        f(intent);
        b(str, Boolean.parseBoolean(a16.get("translucent_page")), a16.get("source"), "1".equals(a16.get("nocleartop")), a.b(a16, stringExtra));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:1|(1:3)(1:39)|4|(15:34|35|7|(1:9)|10|(1:12)|13|(1:15)|16|17|18|(3:20|21|(1:28)(2:25|26))|31|21|(2:23|28)(1:29))|6|7|(0)|10|(0)|13|(0)|16|17|18|(0)|31|21|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00fa, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fb, code lost:
    
        com.tencent.qphone.base.util.QLog.e("IlivePluginService", 1, "parse color error:" + r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f0 A[Catch: IllegalArgumentException -> 0x00fa, TRY_LEAVE, TryCatch #1 {IllegalArgumentException -> 0x00fa, blocks: (B:18:0x00ea, B:20:0x00f0), top: B:17:0x00ea }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(Intent intent) {
        String str;
        int intValue;
        int i3;
        int i16;
        ColorDrawable colorDrawable;
        Activity topActivity;
        String stringExtra = intent.getStringExtra("extra_key_mqq_schema");
        f390128e.i("IlivePluginService", "handleOpenWebView, mqqSchema " + stringExtra);
        Map<String, String> a16 = a.a(stringExtra);
        String str2 = "";
        if (!a16.containsKey("url")) {
            str = "";
        } else {
            str = a16.get("url");
        }
        if (a16.containsKey("top_margin")) {
            try {
                intValue = Integer.valueOf(a16.get("top_margin")).intValue();
            } catch (NumberFormatException e16) {
                f390128e.e("IlivePluginService", "handleOpenWebView error:" + e16);
            }
            if (a16.containsKey("bgColor")) {
                str2 = "#" + a16.get("bgColor");
            }
            String E = ax.E(str);
            f390128e.i("IlivePluginService", "handleOpenWebView, decodedUrl:" + E + ", marginTopDp:" + intValue + ", bgColor:" + str2);
            i3 = x.f(this).f185861b;
            i16 = x.f(this).f185860a;
            int c16 = x.c(this, (float) intValue);
            if (i16 > i3) {
                i3 = i16;
            }
            int h16 = x.h(this, i3 - c16);
            Bundle bundle = new Bundle();
            bundle.putInt("height_web_dialog", h16);
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("webViewBgColor", str2);
            }
            if (!TextUtils.isEmpty(str2)) {
                colorDrawable = new ColorDrawable(Color.parseColor(str2));
                topActivity = Foreground.getTopActivity();
                if (topActivity != null && !topActivity.isFinishing()) {
                    com.tencent.mobileqq.qqlive.base.webview.a.e(topActivity, E, bundle, null, colorDrawable);
                    return;
                }
                return;
            }
            colorDrawable = null;
            topActivity = Foreground.getTopActivity();
            if (topActivity != null) {
                return;
            } else {
                return;
            }
        }
        intValue = 0;
        if (a16.containsKey("bgColor")) {
        }
        String E2 = ax.E(str);
        f390128e.i("IlivePluginService", "handleOpenWebView, decodedUrl:" + E2 + ", marginTopDp:" + intValue + ", bgColor:" + str2);
        i3 = x.f(this).f185861b;
        i16 = x.f(this).f185860a;
        int c162 = x.c(this, (float) intValue);
        if (i16 > i3) {
        }
        int h162 = x.h(this, i3 - c162);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("height_web_dialog", h162);
        if (!TextUtils.isEmpty(str2)) {
        }
        if (!TextUtils.isEmpty(str2)) {
        }
        colorDrawable = null;
        topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
        }
    }

    private void e(Intent intent) {
        long j3 = -1;
        long longExtra = intent.getLongExtra("extra_key_timestamp", -1L);
        this.f390129d = longExtra;
        if (longExtra > 0) {
            j3 = System.currentTimeMillis() - this.f390129d;
        }
        QLog.i("IlivePluginService", 1, "[handlePreload] cost=" + j3);
        ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().eventId(QQLiveReportConstants.Event.E_PRELOAD_PROCESS).cost(String.valueOf(j3)));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(Intent intent) {
        long j3;
        boolean z16;
        QQLiveContext c16;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        long longExtra = intent.getLongExtra("extra_key_timestamp", -1L);
        if (longExtra > 0) {
            j3 = System.currentTimeMillis() - longExtra;
        } else {
            j3 = -1;
        }
        long longExtra2 = intent.getLongExtra("EXTRA_KEY_PRELOAD_TIMESTAMP", -1L);
        if (longExtra2 > 0) {
            long j16 = this.f390129d;
            if (j16 > 0 && longExtra2 == j16) {
                z16 = true;
                c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
                if (c16 == null) {
                    str = c16.l().get("roomid");
                    str3 = c16.l().get("room_type");
                    str4 = c16.n();
                    str5 = c16.j();
                    str2 = c16.m();
                } else {
                    str = "";
                    str2 = "";
                    str3 = str2;
                    str4 = str3;
                    str5 = str4;
                }
                QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder();
                builder.traceId(str4).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_STEP).roomId(str).roomType(str3).cost(String.valueOf(j3)).desc("launch service").ext6(str5).ext7(str2).ext8(String.valueOf(System.currentTimeMillis())).ext11(String.valueOf(z16));
                h.a(builder);
            }
        }
        z16 = false;
        c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 == null) {
        }
        QQLiveQualityReportData.Builder builder2 = new QQLiveQualityReportData.Builder();
        builder2.traceId(str4).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_STEP).roomId(str).roomType(str3).cost(String.valueOf(j3)).desc("launch service").ext6(str5).ext7(str2).ext8(String.valueOf(System.currentTimeMillis())).ext11(String.valueOf(z16));
        h.a(builder2);
    }

    private void g() {
        String str;
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str = c16.n();
        } else {
            str = "";
        }
        ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(str).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_BREAK).desc("living2"));
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        String str;
        if (intent != null && intent.getAction() != null) {
            str = intent.getAction();
        } else {
            str = "";
        }
        f390128e.i("IlivePluginService", "onStartCommand, action " + str);
        if ("action_enter_room".equals(str)) {
            c(intent);
            return 2;
        }
        if ("action_preload".equals(str)) {
            e(intent);
            return 2;
        }
        if ("action_open_web_view".equals(str)) {
            d(intent);
            return 2;
        }
        return 2;
    }
}
