package ff3;

import android.util.Base64;
import com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler;
import com.tencent.mobileqq.zplan.avatar.api.hippy.HippyUeActionType;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.NormalDressStrategy;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l13.ZPlanHippyResult;
import m94.DressErrorMsg;
import org.json.JSONArray;
import org.json.JSONObject;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u000bB!\u0012\b\b\u0001\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0016"}, d2 = {"Lff3/c;", "Lcom/tencent/mobileqq/zplan/avatar/api/hippy/BaseHippyUeActionHandler;", "Lm94/h;", "", "j", "", "c", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "a", "b", "", "actionType", "Lorg/json/JSONObject;", "param", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "<init>", "(ILorg/json/JSONObject;Lcom/tencent/mtt/hippy/modules/Promise;)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends BaseHippyUeActionHandler implements m94.h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@HippyUeActionType int i3, JSONObject param, Promise promise) {
        super(i3, param, promise);
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(promise, "promise");
    }

    @Override // m94.h
    public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        QLog.e("DressItemsActionHandler_", 1, "onError errorMsg:" + errorMsg);
        i(ZPlanHippyResult.INSTANCE.a(errorMsg.getErrorCode() + "-" + errorMsg.getErrorMsg()));
    }

    @Override // m94.h
    public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.i("DressItemsActionHandler_", 1, "onSuccess ");
        i(ZPlanHippyResult.Companion.c(ZPlanHippyResult.INSTANCE, null, 1, null));
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler
    public void c() {
        JSONArray optJSONArray = getParam().optJSONArray("storeItemArray");
        if (optJSONArray == null) {
            i(ZPlanHippyResult.INSTANCE.a("storeItemArray is null"));
            return;
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        if (length == 0) {
            i(ZPlanHippyResult.Companion.c(ZPlanHippyResult.INSTANCE, null, 1, null));
            return;
        }
        for (int i3 = 0; i3 < length; i3++) {
            az azVar = (az) CommonExKt.C(Base64.decode(optJSONArray.getString(i3), 2), new az());
            if (azVar != null) {
                arrayList.add(azVar);
            }
        }
        com.tencent.mobileqq.zplan.avatar.api.hippy.a d16 = d();
        if (d16 == null) {
            h();
            return;
        }
        QLog.i("DressItemsActionHandler_", 1, "dressItems: " + r94.c.y(arrayList));
        d16.b(arrayList, this, NormalDressStrategy.ON_OR_OFF);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler
    public String j() {
        return "DressItemsActionHandler_";
    }
}
