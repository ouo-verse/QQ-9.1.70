package k24;

import android.view.View;
import com.tencent.aio.api.factory.i;
import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.api.IAIOUniversalPanelVB;
import com.tencent.qqnt.aio.api.IPttPanelApi;
import com.tencent.qqnt.pluspanel.api.IPlusPanelApi;
import com.tencent.robot.aio.panel.menu.RobotMenuPanelVB;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lk24/c;", "Lcom/tencent/aio/api/factory/i;", "", "panelId", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements i {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lk24/c$a;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a extends com.tencent.aio.base.mvvm.a<at.c, PanelUIState> {
        @Override // com.tencent.mvi.mvvm.b
        @NotNull
        public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
            Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
            return new View(createViewParams.a());
        }
    }

    @Override // com.tencent.aio.api.factory.i
    @NotNull
    public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> a(int panelId) {
        if (panelId != 1000) {
            if (panelId != 1001) {
                if (panelId != 1003) {
                    if (panelId != 1006) {
                        if (panelId != 1011) {
                            return new a();
                        }
                        return new RobotMenuPanelVB();
                    }
                    return ((IPlusPanelApi) QRoute.api(IPlusPanelApi.class)).getPanelVB(1006);
                }
                return ((IAIOUniversalPanelVB) QRoute.api(IAIOUniversalPanelVB.class)).getPhotoPanelVB();
            }
            return ((IAIOUniversalPanelVB) QRoute.api(IAIOUniversalPanelVB.class)).getEmojiPanelVB();
        }
        return ((IPttPanelApi) QRoute.api(IPttPanelApi.class)).getPanelVB();
    }
}
