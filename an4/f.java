package an4;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lan4/f;", "", "", "teamId", "Landroid/content/Intent;", "b", "", "isCPDD", "a", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "d", "Ljava/lang/String;", "appName", QQCustomArkDialogUtil.APP_VIEW, "version", "e", QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT, "f", "shareAppName", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f26362a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String appName = "com.tencent.yes.fleetcard";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String appView = "fleetcard";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String version = "1.0.9.0";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String promptText = "[QQ\u53d1\u73b0]\u738b\u8005\u5f00\u9ed1\u7ec4\u961f";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String shareAppName = "\u5f00\u9ed1\u4ea4\u53cb\u5927\u5385";

    f() {
    }

    private final String a(String teamId, boolean isCPDD) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("team_id", teamId);
        String str = "1";
        jSONObject2.put("roomtype", "1");
        jSONObject2.put("entryscene", "1");
        if (isCPDD) {
            str = "2";
        }
        jSONObject2.put("destscene", str);
        jSONObject.put(DownloadInfo.spKey_Config, jSONObject2);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "json.toString()");
        return jSONObject3;
    }

    private final Intent b(String teamId) {
        Intent intent = new Intent();
        intent.putExtra("app_name", shareAppName);
        intent.putExtras(c(teamId));
        return intent;
    }

    private final Intent c(String teamId) {
        Intent intent = new Intent();
        String a16 = a(teamId, false);
        intent.putExtra("forward_type", 27);
        intent.putExtra("is_ark_display_share", true);
        String str = appName;
        intent.putExtra("forward_ark_app_name", str);
        String str2 = appView;
        intent.putExtra("forward_ark_app_view", str2);
        String str3 = version;
        intent.putExtra("forward_ark_app_ver", str3);
        intent.putExtra("forward_ark_app_prompt", promptText);
        intent.putExtra("forward_ark_app_meta", a16);
        com.tencent.timi.game.utils.l.i("FleetCPDDArkShareUtil", "getShareArkIntent " + a16 + " " + teamId);
        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, "{\n        \"forward\":1,\n        \"autosize\":0,\n        \"type\":\"normal\"\n    }");
        intent.putExtra("appName", str);
        intent.putExtra(QQCustomArkDialogUtil.APP_VIEW, str2);
        intent.putExtra(QQCustomArkDialogUtil.APP_MIN_VERSION, str3);
        intent.putExtra(QQCustomArkDialogUtil.META_DATA, a16);
        return intent;
    }

    public final void d(@NotNull Activity activity, @NotNull String teamId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(teamId, "teamId");
        RouteUtils.startActivityForResult(activity, b(teamId), RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, 1);
    }
}
