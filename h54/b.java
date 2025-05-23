package h54;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lh54/b;", "Lcom/tencent/freesia/IConfigData;", "", "configStr", "", "b", "Lh54/a;", "d", "Lh54/a;", "a", "()Lh54/a;", "setRobotConfigData", "(Lh54/a;)V", "robotConfigData", "<init>", "()V", "e", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RobotShareToWXConfigData robotConfigData;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final RobotShareToWXConfigData getRobotConfigData() {
        return this.robotConfigData;
    }

    public final void b(@NotNull String configStr) {
        Intrinsics.checkNotNullParameter(configStr, "configStr");
        try {
            JSONObject jSONObject = new JSONObject(configStr);
            String optString = jSONObject.optString("appId", "");
            Intrinsics.checkNotNullExpressionValue(optString, "configJson.optString(KEY_APPID, \"\")");
            String optString2 = jSONObject.optString("originId", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "configJson.optString(KEY_ORIGIN_PATH, \"\")");
            String optString3 = jSONObject.optString("frontTitle", "");
            Intrinsics.checkNotNullExpressionValue(optString3, "configJson.optString(KEY_FRONT_TITLE, \"\")");
            String optString4 = jSONObject.optString("frontIconUrl", "");
            Intrinsics.checkNotNullExpressionValue(optString4, "configJson.optString(KEY_FRONT_ICONURL, \"\")");
            String optString5 = jSONObject.optString("frontPath", "");
            Intrinsics.checkNotNullExpressionValue(optString5, "configJson.optString(KEY_FRONT_PATH, \"\")");
            String optString6 = jSONObject.optString("aioPath", "");
            Intrinsics.checkNotNullExpressionValue(optString6, "configJson.optString(KEY_AIO_PATH, \"\")");
            this.robotConfigData = new RobotShareToWXConfigData(optString, optString2, optString3, optString4, optString5, optString6);
            QLog.i("robotShareInfoBean", 1, "[parse]: success");
        } catch (Exception e16) {
            QLog.i("robotShareInfoBean", 1, "[parse]: " + e16);
        }
    }
}
