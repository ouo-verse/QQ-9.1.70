package js2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.graytips.action.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Ljs2/a;", "Lcom/tencent/qqnt/graytips/handler/b;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/qqnt/graytips/action/f;", "a", "actionInfo", "b", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "Lgv3/a;", "aioAbility", "", "c", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements com.tencent.qqnt.graytips.handler.b {
    @Override // com.tencent.qqnt.graytips.handler.b
    public f a(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        long optLong = jsonObject.optLong("troopUin");
        String url = jsonObject.optString("url");
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return new LaunchEssenceDetailsActionInfo(optLong, url);
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public JSONObject b(f actionInfo) {
        Object obj;
        String url;
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        JSONObject jSONObject = new JSONObject();
        boolean z16 = actionInfo instanceof LaunchEssenceDetailsActionInfo;
        LaunchEssenceDetailsActionInfo launchEssenceDetailsActionInfo = z16 ? (LaunchEssenceDetailsActionInfo) actionInfo : null;
        String str = "";
        if (launchEssenceDetailsActionInfo == null) {
            obj = "";
        } else {
            obj = Long.valueOf(launchEssenceDetailsActionInfo.getTroopUin());
        }
        jSONObject.put("troopUin", obj);
        LaunchEssenceDetailsActionInfo launchEssenceDetailsActionInfo2 = z16 ? (LaunchEssenceDetailsActionInfo) actionInfo : null;
        if (launchEssenceDetailsActionInfo2 != null && (url = launchEssenceDetailsActionInfo2.getUrl()) != null) {
            str = url;
        }
        jSONObject.put("url", str);
        return jSONObject;
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public void c(AppRuntime app, Context context, f actionInfo, gv3.a aioAbility) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        LaunchEssenceDetailsActionInfo launchEssenceDetailsActionInfo = actionInfo instanceof LaunchEssenceDetailsActionInfo ? (LaunchEssenceDetailsActionInfo) actionInfo : null;
        if (launchEssenceDetailsActionInfo == null) {
            return;
        }
        String url = launchEssenceDetailsActionInfo.getUrl();
        String valueOf = String.valueOf(launchEssenceDetailsActionInfo.getTroopUin());
        QLog.i("EssGrayTipDetailsActionHandler", 1, "[handleOnClick] actionInfo: " + actionInfo);
        if (TextUtils.isEmpty(url)) {
            QLog.e("EssGrayTipDetailsActionHandler", 1, "[handleOnClick] invalid url: " + actionInfo);
            return;
        }
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).clearTroopShortCutBarAppRedPoint(app, valueOf, 101886235L);
        ((IAIOJumpAction) QRoute.api(IAIOJumpAction.class)).openBrowser(context, url);
    }
}
