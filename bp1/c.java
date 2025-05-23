package bp1;

import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\"\u001b\u0010\n\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lbp1/a;", "", "c", "d", "b", "", "a", "(Lbp1/a;)I", "getStateType$annotations", "(Lbp1/a;)V", "stateType", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {
    public static final int a(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar instanceof NormalState) {
            return 0;
        }
        if (aVar instanceof CollapsingAnimateState) {
            return 3;
        }
        if (aVar instanceof HeaderCollapsedState) {
            return 2;
        }
        if (aVar instanceof HeaderCollapsingState) {
            return 1;
        }
        if (aVar instanceof PullDownRefreshingState) {
            return 4;
        }
        if (aVar instanceof RefreshAnimateState) {
            return 5;
        }
        if (aVar instanceof RestorePullRefreshAnimateState) {
            return 7;
        }
        if (aVar instanceof StartRefreshAnimateState) {
            return 6;
        }
        if (aVar instanceof FinishRefreshAnimateState) {
            return 8;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean b(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (!(aVar instanceof RefreshAnimateState) && !(aVar instanceof RestorePullRefreshAnimateState) && !(aVar instanceof CollapsingAnimateState)) {
            return false;
        }
        return true;
    }

    public static final boolean c(@NotNull a aVar) {
        HeaderCollapsedState headerCollapsedState;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar instanceof HeaderCollapsedState) {
            headerCollapsedState = (HeaderCollapsedState) aVar;
        } else {
            headerCollapsedState = null;
        }
        if (headerCollapsedState != null) {
            return headerCollapsedState.getExtraStageCollapsed();
        }
        return false;
    }

    public static final boolean d(@NotNull a aVar) {
        HeaderCollapsingState headerCollapsingState;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar instanceof HeaderCollapsingState) {
            headerCollapsingState = (HeaderCollapsingState) aVar;
        } else {
            headerCollapsingState = null;
        }
        if (headerCollapsingState == null) {
            return false;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("HeaderCollapsingState", "shouldCollapsed state:" + headerCollapsingState);
        }
        if ((-headerCollapsingState.getOffset()) < headerCollapsingState.getStartCollapsingOffset() || headerCollapsingState.getRatio() >= 1.0f) {
            return false;
        }
        return true;
    }
}
