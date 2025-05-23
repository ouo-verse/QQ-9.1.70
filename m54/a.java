package m54;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVB;
import com.tencent.robot.slash.dialog.content.root.SlashRootUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u54.c;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J2\u0010\u0010\u001a$\u0012 \u0012\u001e\u0012\u0006\b\u0001\u0012\u00020\u000e\u0012\u0006\b\u0001\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\r0\f2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0017"}, d2 = {"Lm54/a;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVB;", "", "Lcom/tencent/robot/slash/dialog/content/root/SlashRootUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVB;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lm54/b;", "c1", "<init>", "()V", "e", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends SlashDialogVB<Object, SlashRootUIState, e<c>> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final C10766a f416278e = new C10766a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lm54/a$a;", "", "", "BOTTOM_INSET_HEIGHT_DP", "I", "LITTLE_TONGUE_HEIGHT_DP", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: m54.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    private static final class C10766a {
        public /* synthetic */ C10766a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        C10766a() {
        }
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
        ViewUtils viewUtils = ViewUtils.f352270a;
        bVar.i1(viewUtils.b(14));
        bVar.g1(R.color.qui_common_icon_tertiary);
        Unit unit = Unit.INSTANCE;
        z64.a aVar = new z64.a();
        aVar.d1(viewUtils.b(86));
        aVar.c1(R.color.qui_common_bg_middle_light);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new BaseVB[]{bVar, new com.tencent.robot.slash.dialog.content.middle.b(), aVar});
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
