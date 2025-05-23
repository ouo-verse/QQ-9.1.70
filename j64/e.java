package j64;

import com.tencent.robot.slash.businessapi.SearchSessionParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u0010"}, d2 = {"Lj64/e;", "Lj64/i;", "Lj64/g;", "searchContext", "", "e", "Lcom/tencent/robot/slash/businessapi/d;", "searchSessionParams", "Lj64/d;", tl.h.F, "Lj64/h;", "mSearchResultListener", "<init>", "(Lj64/h;)V", "f", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e extends i {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull h mSearchResultListener) {
        super(mSearchResultListener);
        Intrinsics.checkNotNullParameter(mSearchResultListener, "mSearchResultListener");
    }

    @Override // j64.i
    protected void e(@NotNull g searchContext) {
        Intrinsics.checkNotNullParameter(searchContext, "searchContext");
        if (!getMCancel() && !searchContext.e()) {
            getMSearchResultListener().f(searchContext, searchContext.d());
        }
    }

    @NotNull
    public final d h(@NotNull SearchSessionParams searchSessionParams) {
        Intrinsics.checkNotNullParameter(searchSessionParams, "searchSessionParams");
        d dVar = new d(searchSessionParams);
        f(dVar);
        return dVar;
    }
}
