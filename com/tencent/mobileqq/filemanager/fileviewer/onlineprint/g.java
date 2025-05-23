package com.tencent.mobileqq.filemanager.fileviewer.onlineprint;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\u0013\u0010\nR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\n\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileviewer/onlineprint/g;", "Lcom/tencent/freesia/IConfigData;", "", "content", "f", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMiniAppName", "(Ljava/lang/String;)V", MiniChatConstants.MINI_APP_NAME, "e", "b", "setMiniAppID", "miniAppID", "setMiniAppPath", "miniAppPath", tl.h.F, "setServiceProvider", "serviceProvider", "i", "a", "setEnVersion", "enVersion", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqfile-filebrowser-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String miniAppName = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String miniAppID = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String miniAppPath = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String serviceProvider = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String enVersion = "";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getEnVersion() {
        return this.enVersion;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMiniAppID() {
        return this.miniAppID;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMiniAppName() {
        return this.miniAppName;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getMiniAppPath() {
        return this.miniAppPath;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getServiceProvider() {
        return this.serviceProvider;
    }

    @NotNull
    public final g f(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("OnlinePrintConfigBean", 1, "configs parse\uff1a" + content);
        if (TextUtils.isEmpty(content)) {
            return this;
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            String optString = jSONObject.optString("miniapp_name", "");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"miniapp_name\", \"\")");
            this.miniAppName = optString;
            String optString2 = jSONObject.optString("miniapp_id", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"miniapp_id\", \"\")");
            this.miniAppID = optString2;
            String optString3 = jSONObject.optString("miniapp_path", "");
            Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"miniapp_path\", \"\")");
            this.miniAppPath = optString3;
            String optString4 = jSONObject.optString("service_provider", "");
            Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"service_provider\", \"\")");
            this.serviceProvider = optString4;
            String optString5 = jSONObject.optString("en_version", "");
            Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"en_version\", \"\")");
            this.enVersion = optString5;
        } catch (JSONException e16) {
            QLog.e("OnlinePrintConfigBean", 1, e16, new Object[0]);
        }
        return this;
    }
}
