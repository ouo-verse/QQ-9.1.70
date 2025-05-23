package or3;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import nr3.UserMeta;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J>\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lor3/a;", "", "", "eventCode", "eventValue", "param1", "param2", "param3", "param4", "b", "Lorg/json/JSONArray;", CacheTable.TABLE_NAME, "", "a", "Lcom/tencent/qmethod/pandoraex/core/collector/a;", "Lcom/tencent/qmethod/pandoraex/core/collector/a;", "attaReporter", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f423465b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.qmethod.pandoraex.core.collector.a attaReporter = new com.tencent.qmethod.pandoraex.core.collector.a("00a00068027", "4958356373");

    a() {
    }

    public static /* synthetic */ String c(a aVar, String str, String str2, String str3, String str4, String str5, String str6, int i3, Object obj) {
        String str7;
        String str8;
        String str9;
        String str10;
        if ((i3 & 4) != 0) {
            str7 = "";
        } else {
            str7 = str3;
        }
        if ((i3 & 8) != 0) {
            str8 = "";
        } else {
            str8 = str4;
        }
        if ((i3 & 16) != 0) {
            str9 = "";
        } else {
            str9 = str5;
        }
        if ((i3 & 32) != 0) {
            str10 = "";
        } else {
            str10 = str6;
        }
        return aVar.b(str, str2, str7, str8, str9, str10);
    }

    public final void a(@NotNull JSONArray reportInfo) {
        Intrinsics.checkParameterIsNotNull(reportInfo, "reportInfo");
        attaReporter.c(reportInfo);
    }

    @NotNull
    public final String b(@NotNull String eventCode, @NotNull String eventValue, @NotNull String param1, @NotNull String param2, @NotNull String param3, @NotNull String param4) {
        Intrinsics.checkParameterIsNotNull(eventCode, "eventCode");
        Intrinsics.checkParameterIsNotNull(eventValue, "eventValue");
        Intrinsics.checkParameterIsNotNull(param1, "param1");
        Intrinsics.checkParameterIsNotNull(param2, "param2");
        Intrinsics.checkParameterIsNotNull(param3, "param3");
        Intrinsics.checkParameterIsNotNull(param4, "param4");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("platform=");
        sb5.append("Android");
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("app_id=");
        UserMeta userMeta = nr3.a.f421180b;
        sb5.append(userMeta.appId);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("app_version=");
        sb5.append(userMeta.appVersion);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("app_name=");
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        sb5.append(aVar.g().getContext().getPackageName());
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("sdk_name=");
        sb5.append(aVar.g().getAppKey());
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("sdk_version=");
        sb5.append("0.9.15-rc2+build.1");
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("eventCode=");
        sb5.append(eventCode);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("eventValue=");
        sb5.append(eventValue);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("param1=");
        Charset charset = Charsets.UTF_8;
        sb5.append(URLEncoder.encode(param1, charset.toString()));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("param2=");
        sb5.append(URLEncoder.encode(param2, charset.toString()));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("param3=");
        sb5.append(URLEncoder.encode(param3, charset.toString()));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("param4=");
        sb5.append(URLEncoder.encode(param4, charset.toString()));
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "sb.toString()");
        return sb6;
    }
}
