package p13;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasMultiMotionService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
import vs4.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0002J&\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"Lp13/b;", "Lcom/tencent/mobileqq/ark/module/g;", "", "params", "", "e", "", "code", "senderStatus", "receiverStatus", "billNum", "c", "appName", AdMetricTag.EVENT_NAME, "", "notify", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b implements g {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"p13/b$b", "Lcom/tencent/state/service/ResultCallback;", "Lvs4/j;", "", "error", "", "message", "", "onResultFailure", "result", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: p13.b$b, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static final class C10973b implements ResultCallback<j> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f424895b;

        C10973b(String str) {
            this.f424895b = str;
        }

        @Override // com.tencent.state.service.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(j result) {
            Intrinsics.checkNotNullParameter(result, "result");
            b bVar = b.this;
            int i3 = result.f443319a;
            int i16 = result.f443320b;
            String billNum = this.f424895b;
            Intrinsics.checkNotNullExpressionValue(billNum, "billNum");
            bVar.c(0, i3, i16, billNum);
        }

        @Override // com.tencent.state.service.ResultCallback
        public void onResultFailure(int i3, String str, String str2) {
            ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
        }

        @Override // com.tencent.state.service.ResultCallback
        public void onResultFailure(int error, String message) {
            b bVar = b.this;
            String billNum = this.f424895b;
            Intrinsics.checkNotNullExpressionValue(billNum, "billNum");
            bVar.c(error, 0, 0, billNum);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int code, int senderStatus, int receiverStatus, String billNum) {
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        jSONObject.put("billNum", billNum);
        jSONObject.put("senderStatus", senderStatus);
        jSONObject.put("receiverStatus", receiverStatus);
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread("com.tencent.zplan.motioninvite", new Runnable() { // from class: p13.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d(JSONObject.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(JSONObject statusObject) {
        Intrinsics.checkNotNullParameter(statusObject, "$statusObject");
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.zplan.motioninvite", "", "getInviteStatus", statusObject.toString());
    }

    private final void e(String params) {
        boolean isBlank;
        if (QLog.isColorLevel()) {
            QLog.d("SquareInviteArkNotify", 2, "queryInviteStatus  params: " + params);
        }
        if (params != null) {
            try {
                String billNum = new JSONObject(params).optString("billNum");
                Intrinsics.checkNotNullExpressionValue(billNum, "billNum");
                isBlank = StringsKt__StringsJVMKt.isBlank(billNum);
                if (isBlank) {
                    QLog.e("SquareInviteArkNotify", 2, "billNum is blank");
                } else {
                    VasMultiMotionService.INSTANCE.getInviteStatus(billNum, new C10973b(billNum));
                }
            } catch (Throwable th5) {
                QLog.e("SquareInviteArkNotify", 1, th5, new Object[0]);
            }
        }
    }

    @Override // com.tencent.mobileqq.ark.module.g
    public boolean notify(String appName, String eventName, String params) {
        if (QLog.isColorLevel()) {
            QLog.d("SquareInviteArkNotify", 2, "notify --->  appName: " + appName + ", eventName: " + eventName + ", params: " + params);
        }
        if (!TextUtils.equals(appName, "com.tencent.zplan.motioninvite") || !Intrinsics.areEqual(eventName, "getInviteStatus")) {
            return true;
        }
        e(params);
        return true;
    }
}
