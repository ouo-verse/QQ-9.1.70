package e34;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVB;
import com.tencent.robot.slash.dialog.content.root.SlashRootUIState;
import com.tencent.robot.widget.list.vb.CommonListVB;
import i64.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u54.c;
import w64.e;
import x64.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J2\u0010\u0012\u001a$\u0012 \u0012\u001e\u0012\u0006\b\u0001\u0012\u00020\u0010\u0012\u0006\b\u0001\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u000f0\u000e2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0019"}, d2 = {"Le34/a;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVB;", "", "Lcom/tencent/robot/slash/dialog/content/root/SlashRootUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVB;", "", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Le34/b;", "c1", "<init>", "()V", "e", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends SlashDialogVB<Object, SlashRootUIState, e<c>> {
    private final int d1() {
        j jVar = (j) getMStrategyService().b(j.class);
        if (jVar != null) {
            return jVar.g();
        }
        return 0;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public b createVM() {
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, e<c>>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, e<c>>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        z64.b bVar = new z64.b();
        bVar.h1(R.color.qui_common_bg_middle_light);
        bVar.i1(ViewUtils.f352270a.b(32));
        bVar.g1(R.color.qui_common_icon_tertiary);
        Unit unit = Unit.INSTANCE;
        z64.a aVar = new z64.a();
        aVar.d1(d1());
        aVar.c1(R.color.qui_common_bg_middle_light);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new BaseVB[]{bVar, new d(true), new CommonListVB(new com.tencent.robot.at.dialog.content.list.mvidelegate.a()), aVar});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        LinearLayout linearLayout = new LinearLayout(createViewParams.a());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        return linearLayout;
    }
}
