package com.tencent.robot.slash.dialog.content.avatarbar;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.robot.slash.dialog.content.avatarbar.AvatarBarUIState;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVB;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0016\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00120\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarVB;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVB;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/d;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVB;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarUIState$SelectPosition;", "state", "", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Ljava/lang/Class;", "getObserverStates", "f1", "Lcom/tencent/robot/slash/dialog/content/avatarbar/c;", "d1", "", "isHalfMode", "", "accumulatedValue", "totalAvailableHint", "w0", "Lcom/tencent/robot/slash/dialog/content/avatarbar/b;", "e", "Lcom/tencent/robot/slash/dialog/content/avatarbar/b;", "mAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "mAvatarBarView", "<init>", "()V", h.F, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AvatarBarVB extends SlashDialogVB<AvatarClickIntent, AvatarBarUIState, e<u54.c>> {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final a f368438h = new a(null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAdapter = new b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mAvatarBarView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarVB$a;", "", "", "AVATAR_BAR_LAYOUT_HEIGHT_DP", "I", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final void e1(AvatarBarUIState.SelectPosition state) {
        boolean z16;
        this.mAdapter.w0(state.getPosition());
        Integer valueOf = Integer.valueOf(state.getPosition());
        int intValue = valueOf.intValue();
        if (intValue >= 0 && intValue < this.mAdapter.getItemCount()) {
            z16 = true;
        } else {
            z16 = false;
        }
        RecyclerView recyclerView = null;
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue2 = valueOf.intValue();
            RecyclerView recyclerView2 = this.mAvatarBarView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarBarView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.scrollToPosition(intValue2);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        this.mAdapter.setOnItemClickListener(new Function2<View, Integer, Unit>() { // from class: com.tencent.robot.slash.dialog.content.avatarbar.AvatarBarVB$bindViewAndData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                invoke(view, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view, int i3) {
                b bVar;
                b bVar2;
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                AvatarBarVB avatarBarVB = AvatarBarVB.this;
                bVar = avatarBarVB.mAdapter;
                avatarBarVB.sendIntent(new AvatarClickIntent(i3, bVar.m0().get(i3)));
                bVar2 = AvatarBarVB.this.mAdapter;
                bVar2.w0(i3);
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public c createVM() {
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AvatarBarUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AvatarBarUIState.SubmitList) {
            b.z0(this.mAdapter, ((AvatarBarUIState.SubmitList) state).a(), false, 2, null);
        } else if (state instanceof AvatarBarUIState.SelectPosition) {
            e1((AvatarBarUIState.SelectPosition) state);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends AvatarBarUIState>> getObserverStates() {
        List<Class<? extends AvatarBarUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{AvatarBarUIState.SubmitList.class, AvatarBarUIState.SelectPosition.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        RecyclerView recyclerView = new RecyclerView(createViewParams.a());
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        recyclerView.setBackground(new ColorDrawable(recyclerView.getContext().getColor(R.color.qui_common_bg_middle_light)));
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(this.mAdapter);
        this.mAvatarBarView = recyclerView;
        return recyclerView;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        this.mAdapter.setOnItemClickListener(null);
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVB, x64.m
    public int w0(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        return ViewUtils.f352270a.b(44);
    }
}
