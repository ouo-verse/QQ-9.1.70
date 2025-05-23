package i24;

import com.tencent.robot.aio.bottombar.model.OptionType;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import h24.b;
import h24.d;
import h24.e;
import h24.f;
import h24.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Li24/a;", "", "Lcom/tencent/robot/aio/bottombar/model/a;", "itemData", "", "a", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "Lcom/tencent/robot/aio/bottombar/model/OptionType;", "Lh24/a;", "b", "Ljava/util/Map;", "optionTypeToHandlerMap", "<init>", "(Lcom/tencent/aio/api/runtime/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<OptionType, h24.a> optionTypeToHandlerMap;

    public a(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Map<OptionType, h24.a> mapOf;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.aioContext = aioContext;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(OptionType.OPTION_UNKNOWN, new b()), TuplesKt.to(OptionType.OPTION_OPEN_HALF_SCREEN_VIEW, new b()), TuplesKt.to(OptionType.OPTION_MORE, new d()), TuplesKt.to(OptionType.OPTION_SUB_MENU, new e()), TuplesKt.to(OptionType.OPTION_OPEN_URL_PAGE, new f()), TuplesKt.to(OptionType.OPTION_SEND_MESSAGE, new i()));
        this.optionTypeToHandlerMap = mapOf;
    }

    public final void a(@NotNull RobotBottomBarItemModel itemData) {
        h24.a aVar;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (this.optionTypeToHandlerMap.containsKey(itemData.getOptionType()) && (aVar = this.optionTypeToHandlerMap.get(itemData.getOptionType())) != null) {
            aVar.a(this.aioContext, itemData);
        }
    }
}
