package p34;

import com.tencent.robot.discoveryv2.common.data.FirstScreenFetchArgs;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryFetchArgs;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryRsp;
import com.tencent.robot.discoveryv2.common.data.b;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J$\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&\u00a8\u0006\u0011"}, d2 = {"Lp34/a;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/robot/discoveryv2/common/data/b;", "c", "Lcom/tencent/robot/discoveryv2/common/data/j;", "d", "Lcom/tencent/robot/discoveryv2/common/data/a;", "fetchArgs", "", "a", "Lcom/tencent/robot/discoveryv2/common/data/f;", "", "svrCookie", "", "svrDataVersion", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {
    void a(@NotNull FirstScreenFetchArgs fetchArgs);

    void b(@NotNull SingleCategoryFetchArgs fetchArgs, @Nullable byte[] svrCookie, @Nullable String svrDataVersion);

    @NotNull
    Flow<b> c();

    @NotNull
    Flow<SingleCategoryRsp> d();
}
