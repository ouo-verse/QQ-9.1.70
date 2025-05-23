package l32;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.icgame.framework.component.i;
import com.tencent.mobileqq.icgame.framework.exception.ParentViewErrorException;
import com.tencent.mobileqq.icgame.framework.pagefacotry.ComponentNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Ll32/d;", "Ll32/c;", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "cn", "", "d", "Landroid/view/View;", "c", "node", "b", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/icgame/framework/page/manager/c;", "extInterfaceManager", "", "a", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d extends c {
    private final View c(ComponentNode cn5) {
        com.tencent.mobileqq.icgame.framework.component.e eVar;
        com.tencent.mobileqq.icgame.framework.pagefacotry.a<com.tencent.mobileqq.icgame.framework.component.e> g16;
        ComponentNode parentNode = cn5.getParentNode();
        if (parentNode != null && (g16 = parentNode.g()) != null) {
            eVar = g16.d();
        } else {
            eVar = null;
        }
        if (!(eVar instanceof i)) {
            return null;
        }
        return ((i) eVar).l();
    }

    private final boolean d(ComponentNode cn5) {
        if (cn5 == null) {
            return false;
        }
        com.tencent.mobileqq.icgame.framework.component.e d16 = cn5.g().d();
        if (d16 instanceof i) {
            i iVar = (i) d16;
            if (!iVar.a() && !iVar.getViewLoadStatus()) {
                return true;
            }
        }
        return d(cn5.getParentNode());
    }

    @Override // l32.c
    public void a(@NotNull ComponentNode node, @NotNull ViewGroup rootView, @NotNull com.tencent.mobileqq.icgame.framework.page.manager.c extInterfaceManager) {
        View view;
        String str;
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(extInterfaceManager, "extInterfaceManager");
        com.tencent.mobileqq.icgame.framework.component.e d16 = node.g().d();
        if (d16 instanceof i) {
            i iVar = (i) d16;
            if (!iVar.getRequestLoadView() && !iVar.a()) {
                j32.b.f409197a.i("ICGameUIComponentHandler", "injectView: " + node.i().getSimpleName() + " UI\u4e0d\u81ea\u52a8\u52a0\u8f7d");
                return;
            }
            if (iVar.m() != e32.a.d()) {
                if (d(node.getParentNode())) {
                    j32.b.f409197a.i("ICGameUIComponentHandler", "injectView: parent component is not inject view,wait...");
                    return;
                }
                view = c(node);
                if (view != null) {
                    if (!(view instanceof ViewGroup)) {
                        e32.c.d(new ParentViewErrorException(node.i().getSimpleName() + " parentView is a View"));
                        return;
                    }
                } else {
                    throw new ParentViewErrorException(node.i().getSimpleName() + " no parent view");
                }
            } else {
                view = rootView;
            }
            long currentTimeMillis = System.currentTimeMillis();
            e eVar = e.f413777a;
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            eVar.a(context, (ViewGroup) view, iVar.g(), iVar.m(), iVar.f());
            long currentTimeMillis2 = System.currentTimeMillis();
            String simpleName = d16.getClass().getSimpleName();
            if (TextUtils.equals(simpleName, d16.getKey())) {
                str = "";
            } else {
                str = "_" + d16.getKey();
            }
            String str2 = simpleName + str;
            j32.b.f409197a.i(e32.a.c(), "inject view " + str2 + " cost time: " + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    @Override // l32.c
    public boolean b(@NotNull ComponentNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        return node.g().d() instanceof i;
    }
}
