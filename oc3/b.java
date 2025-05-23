package oc3;

import java.util.HashMap;
import kc3.GameJudgeParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mc3.InsExeExtParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\f\u0010\rR0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Loc3/b;", "", "", "executorType", "Lmc3/a;", "extParam", "Lkc3/a;", "judgeParams", "", "Lxu4/a;", "instructions", "", "a", "(JLmc3/a;Lkc3/a;[Lxu4/a;)V", "Ljava/util/HashMap;", "Loc3/a;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "mExecutorPool", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f422445a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<Long, a> mExecutorPool;

    static {
        HashMap<Long, a> hashMap = new HashMap<>();
        mExecutorPool = hashMap;
        i iVar = new i();
        hashMap.put(Long.valueOf(iVar.i()), iVar);
        p pVar = new p();
        hashMap.put(Long.valueOf(pVar.i()), pVar);
    }

    b() {
    }

    public final void a(long executorType, InsExeExtParam extParam, GameJudgeParams judgeParams, xu4.a[] instructions) {
        Intrinsics.checkNotNullParameter(extParam, "extParam");
        Intrinsics.checkNotNullParameter(judgeParams, "judgeParams");
        Intrinsics.checkNotNullParameter(instructions, "instructions");
        a aVar = mExecutorPool.get(Long.valueOf(executorType));
        if (aVar != null) {
            aVar.a(extParam, judgeParams, instructions);
        }
    }
}
