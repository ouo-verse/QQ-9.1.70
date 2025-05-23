package ff3;

import android.util.Base64;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler;
import com.tencent.mobileqq.zplan.avatar.api.hippy.HippyUeActionType;
import com.tencent.mobileqq.zplan.avatar.api.hippy.a;
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
import uv4.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u000bB!\u0012\b\b\u0001\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0016"}, d2 = {"Lff3/b;", "Lcom/tencent/mobileqq/zplan/avatar/api/hippy/BaseHippyUeActionHandler;", "Lm94/h;", "", "j", "", "c", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "a", "b", "", "actionType", "Lorg/json/JSONObject;", "param", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "<init>", "(ILorg/json/JSONObject;Lcom/tencent/mtt/hippy/modules/Promise;)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends BaseHippyUeActionHandler implements m94.h {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ff3/b$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/u;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ff3.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10313b implements com.tencent.mobileqq.zootopia.api.e<u> {
        C10313b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(u result) {
            Intrinsics.checkNotNullParameter(result, "result");
            b.this.i(ZPlanHippyResult.Companion.c(ZPlanHippyResult.INSTANCE, null, 1, null));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            b.this.i(ZPlanHippyResult.INSTANCE.a(error + "-" + message));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ff3/b$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/u;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<u> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(u result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            b.this.i(ZPlanHippyResult.INSTANCE.a(error + "-" + message));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@HippyUeActionType int i3, JSONObject param, Promise promise) {
        super(i3, param, promise);
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(promise, "promise");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(com.tencent.mobileqq.zplan.avatar.api.hippy.a aVar, al alVar, b this$0) {
        List<az> list;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        az[] azVarArr = alVar.f440153b;
        Intrinsics.checkNotNullExpressionValue(azVarArr, "storeAvatarInfo.items");
        list = ArraysKt___ArraysKt.toList(azVarArr);
        qu4.a aVar2 = alVar.f440152a;
        Intrinsics.checkNotNullExpressionValue(aVar2, "storeAvatarInfo.avatarCharacter");
        aVar.g(list, aVar2, this$0);
    }

    @Override // m94.h
    public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        QLog.e("ChangeGenderActionHandler_", 1, "onError errorMsg:" + errorMsg);
        i(ZPlanHippyResult.INSTANCE.a(errorMsg.getErrorCode() + "-" + errorMsg.getErrorMsg()));
    }

    @Override // m94.h
    public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.i("ChangeGenderActionHandler_", 1, "onSuccess ");
        i(ZPlanHippyResult.Companion.c(ZPlanHippyResult.INSTANCE, null, 1, null));
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler
    public void c() {
        byte[] bArr;
        UEAvatarGender D = CommonExKt.D(getParam().optInt("targetGender"));
        if (D == null) {
            i(ZPlanHippyResult.INSTANCE.a("gender error"));
            QLog.e("ChangeGenderActionHandler_", 1, "gender error");
            return;
        }
        String fullDressInfo = getParam().optString("fullDressInfo");
        Intrinsics.checkNotNullExpressionValue(fullDressInfo, "fullDressInfo");
        if (fullDressInfo.length() == 0) {
            QLog.e("ChangeGenderActionHandler_", 1, "fullDressInfo isEmpty");
        }
        try {
            bArr = Base64.decode(fullDressInfo, 2);
        } catch (Exception e16) {
            QLog.e("ChangeGenderActionHandler_", 1, "decode error", e16);
            bArr = null;
        }
        final al alVar = (al) CommonExKt.C(bArr, new al());
        if ((alVar != null ? alVar.f440152a : null) == null) {
            QLog.e("ChangeGenderActionHandler_", 1, "storeAvatarInfo error!");
        }
        final com.tencent.mobileqq.zplan.avatar.api.hippy.a d16 = d();
        if (d16 == null) {
            h();
            return;
        }
        QLog.i("ChangeGenderActionHandler_", 1, "dressFullItems ");
        if (alVar == null) {
            a.C9151a.a(d16, D, new C10313b(), null, 4, null);
        } else {
            d16.s0(D, new c(), new Runnable() { // from class: ff3.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.m(com.tencent.mobileqq.zplan.avatar.api.hippy.a.this, alVar, this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler
    public String j() {
        return "ChangeGenderActionHandler_";
    }
}
