package lc3;

import kc3.GameJudgeParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bH&J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0018"}, d2 = {"Llc3/a;", "", "Lkc3/a;", "judgeParams", "", "c", "", "mapId", "f", "", "exitCode", "", "msg", "e", "from", "url", "d", "Lxu4/a;", "instruction", "", "a", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a {
    public boolean a(long from, xu4.a instruction) {
        Intrinsics.checkNotNullParameter(instruction, "instruction");
        return false;
    }

    public boolean b(long from, xu4.a instruction) {
        Intrinsics.checkNotNullParameter(instruction, "instruction");
        return false;
    }

    public final void c(GameJudgeParams judgeParams) {
        Intrinsics.checkNotNullParameter(judgeParams, "judgeParams");
        f(judgeParams.getMapId());
    }

    public abstract void d(long from, int mapId, String url);

    public abstract void e(int mapId, long exitCode, String msg2);

    public void f(int mapId) {
    }
}
