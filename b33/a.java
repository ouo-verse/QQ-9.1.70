package b33;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.api.ISquarePushListener;
import com.tencent.state.square.record.CloudRecordResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ0\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\nJ0\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lb33/a;", "Lcom/tencent/state/square/api/ISquarePushListener;", "", "actionId", "", "dressKey", "type", "width", "height", "a", "", "c", "d", "Lb33/c;", "listener", "f", "e", "Lcom/tencent/state/square/record/CloudRecordResult;", "b", "", "data", "onResult", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "cloudRecordResultMap", "Lb33/c;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements ISquarePushListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, CloudRecordResult> cloudRecordResultMap = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private c listener;

    private final String a(int actionId, String dressKey, int type, int width, int height) {
        return actionId + "_" + dressKey + "_" + type + "_" + width + "_" + height;
    }

    public final CloudRecordResult b(int actionId, String dressKey, int type, int width, int height) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        return this.cloudRecordResultMap.get(a(actionId, dressKey, type, width, height));
    }

    public final void c() {
        f33.a.f397786a.a(1, this);
    }

    public final void d() {
        this.cloudRecordResultMap.clear();
        f33.a.f397786a.c(1, this);
        this.listener = null;
    }

    public final void f(c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // com.tencent.state.square.api.ISquarePushListener
    public void onResult(byte[] data) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("CloudRecordResultPushManager", 2, "onReceivePush");
        try {
            cu4.c result = cu4.c.c(data);
            boolean z16 = (TextUtils.isEmpty(result.f391875f) || result.f391876g == null) ? false : true;
            int i3 = result.f391870a;
            if (i3 == 0 && z16) {
                Intrinsics.checkNotNullExpressionValue(result, "result");
                CloudRecordResult a16 = b.a(result);
                int i16 = result.f391873d;
                String str = result.f391874e;
                Intrinsics.checkNotNullExpressionValue(str, "result.dressKey");
                int i17 = result.f391872c;
                hs4.b bVar = result.f391876g;
                String a17 = a(i16, str, i17, bVar.f406127a, bVar.f406128b);
                this.cloudRecordResultMap.put(a17, a16);
                c cVar = this.listener;
                if (cVar != null) {
                    cVar.a(a16);
                }
                QLog.i("CloudRecordResultPushManager", 1, "onReceivePush key:" + a17 + " cloudRecordResult:" + a16);
            } else {
                QLog.w("CloudRecordResultPushManager", 2, "onReceivePush data valid: " + z16 + ", " + i3 + " ");
            }
        } catch (Exception e16) {
            QLog.e("CloudRecordResultPushManager", 1, "onReceivePush parseFrom error:" + e16);
        }
        com.tencent.mobileqq.zplan.report.c cVar2 = com.tencent.mobileqq.zplan.report.c.f335070a;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("zplan_operation_id", "em_zplan_operation_record_push");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        pairArr[1] = TuplesKt.to("zplan_touin", currentAccountUin);
        pairArr[2] = TuplesKt.to("zplan_operation_value", "1");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        cVar2.a("ev_zplan_terminal_technology", mutableMapOf);
    }

    public final void e() {
        this.listener = null;
    }
}
