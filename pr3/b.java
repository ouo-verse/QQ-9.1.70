package pr3;

import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.qmethod.monitor.base.PMonitorInitParam;
import com.tencent.qmethod.monitor.base.util.AppInfo;
import com.tencent.qmethod.monitor.base.util.NetworkUtil;
import com.tencent.qmethod.monitor.base.util.g;
import com.tencent.qmethod.pandoraex.core.o;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nr3.UserMeta;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\f\u0010\t\u001a\u00020\u0004*\u00020\u0004H\u0002J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\fR\u001c\u0010\u0012\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lpr3/b;", "", "Lorg/json/JSONObject;", "g", "", "originOSVersion", "b", "d", "c", "a", "baseType", QCircleLpReportDc010001.KEY_SUBTYPE, "", "event_time", "e", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "Ljava/util/regex/Pattern;", "OS_FORMAT_PATTERN", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f427061b = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Pattern OS_FORMAT_PATTERN = Pattern.compile("(([1-9]\\d*|0)\\.){0,2}([1-9]\\d*)");

    b() {
    }

    private final String a(@NotNull String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        return str;
    }

    private final String b(String originOSVersion) {
        String str;
        int i3;
        boolean z16;
        int length = originOSVersion.length() - 1;
        int i16 = 0;
        boolean z17 = false;
        while (i16 <= length) {
            if (!z17) {
                i3 = i16;
            } else {
                i3 = length;
            }
            if (originOSVersion.charAt(i3) <= ' ') {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z17) {
                if (!z16) {
                    z17 = true;
                } else {
                    i16++;
                }
            } else {
                if (!z16) {
                    break;
                }
                length--;
            }
        }
        String obj = originOSVersion.subSequence(i16, length + 1).toString();
        if (TextUtils.isEmpty(obj)) {
            return "unknown";
        }
        Matcher matcher = OS_FORMAT_PATTERN.matcher(obj);
        if (matcher.find()) {
            str = matcher.group();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return obj;
    }

    private final String c() {
        return AppInfo.INSTANCE.a().getPackageName();
    }

    private final String d() {
        return g.b(UUID.randomUUID().toString() + System.currentTimeMillis());
    }

    public static /* synthetic */ JSONObject f(b bVar, String str, String str2, long j3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j3 = System.currentTimeMillis() / 1000;
        }
        return bVar.e(str, str2, j3);
    }

    private final JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ReportDataBuilder.KEY_HARDWARE_OS, "android");
            com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
            String d16 = aVar.d(PMonitorInitParam.Property.SYS_VERSION_INT);
            if ((!Intrinsics.areEqual("unknown", d16)) && !TextUtils.isEmpty(d16)) {
                jSONObject.put("os_version", f427061b.b(d16));
            }
            String d17 = aVar.d(PMonitorInitParam.Property.SYS_MODEL);
            if ((!Intrinsics.areEqual("unknown", d17)) && !TextUtils.isEmpty(d17)) {
                jSONObject.put("model", d17);
            }
            UserMeta userMeta = nr3.a.f421180b;
            jSONObject.put("unique_id", userMeta.a());
            String d18 = aVar.d(PMonitorInitParam.Property.SYS_BRAND);
            if (!Intrinsics.areEqual("unknown", d18)) {
                jSONObject.put("brand", d18);
            }
            String str = userMeta.uin;
            if (!Intrinsics.areEqual("unknown", str)) {
                jSONObject.put(ReportDataBuilder.KEY_ACCOUNT_ID, str);
            }
        } catch (Throwable th5) {
            o.e("ReportDataBuilder", th5.getMessage());
        }
        return jSONObject;
    }

    @NotNull
    public final JSONObject e(@NotNull String baseType, @NotNull String subType, long event_time) {
        Intrinsics.checkParameterIsNotNull(baseType, "baseType");
        Intrinsics.checkParameterIsNotNull(subType, "subType");
        if (!TextUtils.isEmpty(baseType) && !TextUtils.isEmpty(subType)) {
            JSONObject jSONObject = new JSONObject();
            try {
                b bVar = f427061b;
                UserMeta userMeta = nr3.a.f421180b;
                jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, bVar.a(userMeta.appId));
                jSONObject.put("app_key", userMeta.appKey);
                jSONObject.put("event_time", event_time);
                jSONObject.put(ReportDataBuilder.KEY_BASE_TYPE, bVar.a(baseType));
                jSONObject.put("sub_type", bVar.a(subType));
                jSONObject.put("app_version", bVar.a(userMeta.appVersion));
                jSONObject.put("sdk_version", bVar.a(userMeta.sdkVersion));
                jSONObject.put(ReportDataBuilder.KEY_BUNDLE_ID, bVar.c());
                jSONObject.put(ReportDataBuilder.KEY_BUILD_NUMBER, userMeta.uuid);
                jSONObject.put(ReportDataBuilder.KEY_CLIENT_IDENTIFY, bVar.a(bVar.d()));
                jSONObject.put("platform", "Android");
                NetworkUtil networkUtil = NetworkUtil.f343513c;
                String jSONObject2 = bVar.g().toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "makeResource().toString()");
                jSONObject.put(ReportDataBuilder.KEY_RESOURCE, networkUtil.a(jSONObject2));
                jSONObject.put(ReportDataBuilder.KEY_LAUNCH_ID, tr3.a.f437217d.c(AppInfo.INSTANCE.a()));
            } catch (Throwable th5) {
                o.c("ReportDataBuilder", th5.getMessage());
            }
            return jSONObject;
        }
        return new JSONObject();
    }
}
