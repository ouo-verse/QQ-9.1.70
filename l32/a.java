package l32;

import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.icgame.framework.pagefacotry.ComponentNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Ll32/a;", "Ll32/c;", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "node", "", "b", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/icgame/framework/page/manager/c;", "extInterfaceManager", "", "a", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends c {
    @Override // l32.c
    public void a(@NotNull ComponentNode node, @NotNull ViewGroup rootView, @NotNull com.tencent.mobileqq.icgame.framework.page.manager.c extInterfaceManager) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(extInterfaceManager, "extInterfaceManager");
        com.tencent.mobileqq.icgame.framework.page.manager.d.f237352a.a(extInterfaceManager, node.g().d());
    }

    @Override // l32.c
    public boolean b(@NotNull ComponentNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        return true;
    }
}
