package k92;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lk92/c;", "Lcom/tencent/qqnt/graytips/handler/b;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/qqnt/graytips/action/f;", "a", "actionInfo", "b", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "Lgv3/a;", "aioAbility", "", "c", "<init>", "()V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c implements com.tencent.qqnt.graytips.handler.b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String str) {
        f.e(str);
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public com.tencent.qqnt.graytips.action.f a(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String optString = jsonObject.optString("friendUin", "");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(KEY_FRIEND_UIN, \"\")");
        return new a(optString);
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public JSONObject b(com.tencent.qqnt.graytips.action.f actionInfo) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        JSONObject jSONObject = new JSONObject();
        a aVar = actionInfo instanceof a ? (a) actionInfo : null;
        if (aVar != null) {
            jSONObject.put("friendUin", aVar.getFriendUin());
        }
        return jSONObject;
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public void c(AppRuntime app, Context context, com.tencent.qqnt.graytips.action.f actionInfo, gv3.a aioAbility) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        a aVar = actionInfo instanceof a ? (a) actionInfo : null;
        final String friendUin = aVar != null ? aVar.getFriendUin() : null;
        if (friendUin == null || friendUin.length() == 0) {
            QLog.e("SpecialCareGrayTipActionHandler", 1, "handleOnClick friendUin is null or empty");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: k92.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.e(friendUin);
                }
            }, 16, null, true);
        }
    }
}
