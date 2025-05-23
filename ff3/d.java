package ff3;

import android.util.Base64;
import com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler;
import com.tencent.mobileqq.zplan.avatar.api.hippy.HippyUeActionType;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import l13.ZPlanHippyResult;
import m94.DressErrorMsg;
import org.json.JSONObject;
import uv4.al;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u000bB!\u0012\b\b\u0001\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0016"}, d2 = {"Lff3/d;", "Lcom/tencent/mobileqq/zplan/avatar/api/hippy/BaseHippyUeActionHandler;", "Lm94/h;", "", "j", "", "c", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "a", "b", "", "actionType", "Lorg/json/JSONObject;", "param", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "<init>", "(ILorg/json/JSONObject;Lcom/tencent/mtt/hippy/modules/Promise;)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends BaseHippyUeActionHandler implements m94.h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@HippyUeActionType int i3, JSONObject param, Promise promise) {
        super(i3, param, promise);
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(promise, "promise");
    }

    @Override // m94.h
    public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        QLog.e("FullDressActionHandler_", 1, "onError errorMsg:" + errorMsg);
        i(ZPlanHippyResult.INSTANCE.a(errorMsg.getErrorCode() + "-" + errorMsg.getErrorMsg()));
    }

    @Override // m94.h
    public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.i("FullDressActionHandler_", 1, "onSuccess ");
        i(ZPlanHippyResult.Companion.c(ZPlanHippyResult.INSTANCE, null, 1, null));
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler
    public void c() {
        List<az> list;
        String fullDressInfo = getParam().optString("fullDressInfo");
        Intrinsics.checkNotNullExpressionValue(fullDressInfo, "fullDressInfo");
        if (fullDressInfo.length() == 0) {
            i(ZPlanHippyResult.INSTANCE.a("fullDressInfo isEmpty"));
            QLog.e("FullDressActionHandler_", 1, "fullDressInfo isEmpty");
            return;
        }
        al alVar = (al) CommonExKt.C(Base64.decode(fullDressInfo, 2), new al());
        if ((alVar != null ? alVar.f440152a : null) == null) {
            i(ZPlanHippyResult.INSTANCE.a("storeAvatarInfo error!"));
            QLog.e("FullDressActionHandler_", 1, "storeAvatarInfo error!");
            return;
        }
        com.tencent.mobileqq.zplan.avatar.api.hippy.a d16 = d();
        if (d16 == null) {
            h();
            return;
        }
        QLog.i("FullDressActionHandler_", 1, "dressFullItems ");
        az[] azVarArr = alVar.f440153b;
        Intrinsics.checkNotNullExpressionValue(azVarArr, "storeAvatarInfo.items");
        list = ArraysKt___ArraysKt.toList(azVarArr);
        qu4.a aVar = alVar.f440152a;
        Intrinsics.checkNotNullExpressionValue(aVar, "storeAvatarInfo.avatarCharacter");
        d16.g(list, aVar, this);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler
    public String j() {
        return "FullDressActionHandler_";
    }
}
