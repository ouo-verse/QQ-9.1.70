package oc3;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kc3.GameJudgeParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mc3.InsExeExtParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004H\u0004\u00a8\u0006\u0011"}, d2 = {"Loc3/a;", "", "Lmc3/a;", "extParam", "Lkc3/a;", "judgeParams", "", "Lxu4/a;", "instructions", "", "a", "(Lmc3/a;Lkc3/a;[Lxu4/a;)V", "ins", "params", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"oc3/a$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lxu4/e;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: oc3.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10900a implements com.tencent.mobileqq.zootopia.api.e<xu4.e> {
        C10900a() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(xu4.e result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("Minors_BaseInstructionsExecutor", 2, "onResultSuccess ret=" + result.f448725a + " msg=" + result.f448726b);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("Minors_BaseInstructionsExecutor", 2, "onResultFailure err=" + error + " msg=" + message);
        }
    }

    public abstract void a(InsExeExtParam extParam, GameJudgeParams judgeParams, xu4.a[] instructions);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(InsExeExtParam extParam, xu4.a ins, GameJudgeParams params) {
        Intrinsics.checkNotNullParameter(extParam, "extParam");
        Intrinsics.checkNotNullParameter(ins, "ins");
        Intrinsics.checkNotNullParameter(params, "params");
        xu4.f fVar = new xu4.f();
        fVar.f448728a = params.getOpenId();
        fVar.f448729b = ins.f448712h;
        fVar.f448730c = extParam.getTraceId();
        fVar.f448731d = (int) NetConnInfoCenter.getServerTime();
        qc3.a aVar = qc3.a.f428847a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar);
        aVar.c(arrayList, params, new C10900a());
    }
}
