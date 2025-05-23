package kf2;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b%\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0017\u0010\nR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0007\u001a\u0004\b\f\u0010\b\"\u0004\b\u001d\u0010\nR$\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010 \u001a\u0004\b\u001c\u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lkf2/b;", "", "", "params", "", "i", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appId", "b", "c", "setChannelId", "channelId", "f", "setPkgName", PushClientConstants.TAG_PKG_NAME, "d", "e", "setName", "name", "setIcon", "icon", h.F, "setUrl", "url", "g", "setAppSize", "appSize", "Lkf2/c;", "Lkf2/c;", "()Lkf2/c;", "setReportInfo", "(Lkf2/c;)V", CacheTable.TABLE_NAME, "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String appId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String channelId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String pkgName = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String name = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String icon = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String url = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String appSize = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private c reportInfo;

    /* renamed from: a, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAppSize() {
        return this.appSize;
    }

    /* renamed from: c, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: d, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: f, reason: from getter */
    public final String getPkgName() {
        return this.pkgName;
    }

    /* renamed from: g, reason: from getter */
    public final c getReportInfo() {
        return this.reportInfo;
    }

    /* renamed from: h, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final void i(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("appId");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"appId\")");
            this.appId = optString;
            String optString2 = jSONObject.optString("channelId");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"channelId\")");
            this.channelId = optString2;
            String optString3 = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"pkgName\")");
            this.pkgName = optString3;
            String optString4 = jSONObject.optString("name");
            Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"name\")");
            this.name = optString4;
            String optString5 = jSONObject.optString("icon");
            Intrinsics.checkNotNullExpressionValue(optString5, "optString(\"icon\")");
            this.icon = optString5;
            String optString6 = jSONObject.optString("url");
            Intrinsics.checkNotNullExpressionValue(optString6, "optString(\"url\")");
            this.url = optString6;
            String optString7 = jSONObject.optString("appSize");
            Intrinsics.checkNotNullExpressionValue(optString7, "optString(\"appSize\")");
            this.appSize = optString7;
            JSONObject optJSONObject = jSONObject.optJSONObject("reportData");
            if (optJSONObject != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(\"reportData\")");
                c cVar = new c();
                cVar.b(optJSONObject);
                this.reportInfo = cVar;
            }
        } catch (JSONException e16) {
            QLog.w("ECGameAppInfo", 1, e16.getMessage(), e16);
        }
    }
}
