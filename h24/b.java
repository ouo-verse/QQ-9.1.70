package h24;

import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.aio.bottombar.model.HalfScreenOptID;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lh24/b;", "Lh24/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/robot/aio/bottombar/model/a;", "itemData", "", "a", "", "Lcom/tencent/robot/aio/bottombar/model/HalfScreenOptID;", "Ljava/util/Map;", "halfScreenHandlerMap", "<init>", "()V", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<HalfScreenOptID, a> halfScreenHandlerMap;

    public b() {
        Map<HalfScreenOptID, a> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(HalfScreenOptID.OPT_ID_AI_DRAW, new c()), TuplesKt.to(HalfScreenOptID.OPT_ID_AI_WRITE, new k()), TuplesKt.to(HalfScreenOptID.OPT_ID_SWITCH_PLOT, new j()), TuplesKt.to(HalfScreenOptID.OPT_ID_AI_SEARCH, new h()), TuplesKt.to(HalfScreenOptID.OPT_ID_SIMPLE_FUNCTION, new g()));
        this.halfScreenHandlerMap = mapOf;
    }

    @Override // h24.a
    public void a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull RobotBottomBarItemModel itemData) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        HalfScreenOptID a16 = HalfScreenOptID.INSTANCE.a(itemData.getOptID());
        if (this.halfScreenHandlerMap.containsKey(a16)) {
            a aVar = this.halfScreenHandlerMap.get(a16);
            if (aVar != null) {
                aVar.a(aioContext, itemData);
                return;
            }
            return;
        }
        QLog.i("RobotBottomHalfScreenHandler", 1, "unknown optID: " + itemData.getOptID());
    }
}
