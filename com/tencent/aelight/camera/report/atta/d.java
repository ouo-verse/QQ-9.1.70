package com.tencent.aelight.camera.report.atta;

import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QUA;
import java.net.URLEncoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J0\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/aelight/camera/report/atta/d;", "", "", "eventCode", "", AppConstants.Key.COLUMN_EXT_STR, "", AppConstants.Key.COLUMN_EXT_INT, "", "d", "Lcom/tencent/aelight/camera/report/atta/b;", "event", "c", "b", "f", "Ljava/lang/String;", "uin", "qua", "appId", "e", "os", "brand", "g", "model", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String qua;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static String appId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final String brand;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final String model;

    /* renamed from: a, reason: collision with root package name */
    public static final d f69032a = new d();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final String os = "Android " + Build.VERSION.SDK_INT;

    static {
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        brand = BRAND;
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        model = MODEL;
    }

    d() {
    }

    private final String b(AttaEvent event) {
        StringBuilder sb5 = new StringBuilder("event_code=" + event.getEventCode() + "&event_time=" + event.getEventCode() + "&duration=" + event.getDuration() + "&result=" + event.getResult() + "&code=" + event.getCode() + "&msg=" + URLEncoder.encode(event.getMsg(), "UTF-8") + "&uin=" + uin + "&qua=" + qua + "&os=" + os + "&appid=" + URLEncoder.encode(appId, "UTF-8") + "&brand=" + URLEncoder.encode(brand, "UTF-8") + "&model=" + URLEncoder.encode(model, "UTF-8"));
        int i3 = 0;
        int i16 = 0;
        for (Object obj : event.e()) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            sb5.append("&ext_str" + i17 + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode((String) obj, "UTF-8"));
            i16 = i17;
        }
        for (Object obj2 : event.d()) {
            int i18 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            sb5.append("&ext_int" + i18 + ContainerUtils.KEY_VALUE_DELIMITER + ((Number) obj2).longValue());
            i3 = i18;
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
        return sb6;
    }

    @JvmStatic
    public static final void c(final AttaEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.aelight.camera.report.atta.c
            @Override // java.lang.Runnable
            public final void run() {
                d.e(AttaEvent.this);
            }
        });
    }

    @JvmStatic
    public static final void d(String eventCode, List<String> extStr, List<Long> extInt) {
        List<String> list;
        List<Long> list2;
        List<Long> emptyList;
        List<String> emptyList2;
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        long currentTimeMillis = System.currentTimeMillis();
        if (extStr == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList2;
        } else {
            list = extStr;
        }
        if (extInt == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = extInt;
        }
        c(new AttaEvent(eventCode, currentTimeMillis, 0L, null, 0L, null, list, list2, 60, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AttaEvent event) {
        Intrinsics.checkNotNullParameter(event, "$event");
        try {
            d dVar = f69032a;
            dVar.f();
            Dispatcher dispatcher = Dispatcher.f69018a;
            String b16 = dVar.b(event);
            ms.a.a("AttaReport", b16);
            dispatcher.b(b16);
        } catch (Throwable th5) {
            ms.a.e("AttaReport", th5);
        }
    }

    private final void f() {
        String str = uin;
        boolean z16 = true;
        if (str == null || str.length() == 0) {
            AppInterface a16 = com.tencent.aelight.camera.aebase.a.a();
            String currentAccountUin = a16 != null ? a16.getCurrentAccountUin() : null;
            uin = currentAccountUin;
            ms.a.a("AttaReport", "init uin = " + currentAccountUin);
        }
        String str2 = appId;
        if (str2 == null || str2.length() == 0) {
            BaseApplication baseApplication = BaseApplication.context;
            String str3 = InstalledAppListMonitor.getPackageInfo(baseApplication.getPackageManager(), baseApplication.getPackageName(), 0).versionName;
            appId = str3;
            ms.a.a("AttaReport", "init appId = " + str3);
        }
        String str4 = qua;
        if (str4 != null && str4.length() != 0) {
            z16 = false;
        }
        if (z16) {
            String qua3 = QUA.getQUA3();
            qua = qua3;
            ms.a.a("AttaReport", "init qua = " + qua3);
        }
    }
}
