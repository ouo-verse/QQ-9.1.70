package com.tencent.mobileqq.guild.media.thirdapp.container.vb;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.h;
import com.tencent.mobileqq.guild.media.thirdapp.container.uistate.GuildMiniViewUIState;
import com.tencent.mobileqq.guild.media.thirdapp.container.vm.GuildStandAlongMiniViewVM;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.mini.api.MiniContainerHolder;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.qqmini.container.core.MiniView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0007:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\n0\u001bj\b\u0012\u0004\u0012\u00020\n`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vb/i;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/h;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/uistate/GuildMiniViewUIState;", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVB;", "", "b1", "Lcom/tencent/mobileqq/mini/api/MiniContainerHolder;", "miniViewContainer", "", "targetHeight", "e1", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAlongMiniViewVM;", "c1", "state", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "miniViewRoot", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "miniContainerList", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i extends BaseVB<com.tencent.mobileqq.guild.media.thirdapp.container.intent.h, GuildMiniViewUIState, com.tencent.base.api.runtime.a<BaseParam>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout miniViewRoot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MiniContainerHolder> miniContainerList = new ArrayList<>();

    private final void b1() {
        int lastIndex;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.miniContainerList);
        if (lastIndex < 0) {
            return;
        }
        View view = this.miniContainerList.remove(lastIndex).getView();
        FrameLayout frameLayout = this.miniViewRoot;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniViewRoot");
            frameLayout = null;
        }
        frameLayout.removeView(view);
        if (view instanceof MiniView) {
            ((MiniView) view).onDestroy();
        }
        sendIntent(new h.NotifyMiniViewSize(this.miniContainerList.size()));
    }

    private final void e1(MiniContainerHolder miniViewContainer, int targetHeight) {
        int lastIndex;
        this.miniContainerList.add(miniViewContainer);
        ArrayList<MiniContainerHolder> arrayList = this.miniContainerList;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        View view = arrayList.get(lastIndex).getView();
        view.setBackgroundColor(0);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, targetHeight);
        FrameLayout frameLayout = this.miniViewRoot;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniViewRoot");
            frameLayout = null;
        }
        frameLayout.addView(view, -1, layoutParams);
        view.setNestedScrollingEnabled(true);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public GuildStandAlongMiniViewVM createVM() {
        return new GuildStandAlongMiniViewVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildMiniViewUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAlongMiniViewVB", 1, "[handleUIState] state " + state);
        if (state instanceof GuildMiniViewUIState.UpdateMiniView) {
            GuildMiniViewUIState.UpdateMiniView updateMiniView = (GuildMiniViewUIState.UpdateMiniView) state;
            e1(updateMiniView.getMiniViewContainer(), updateMiniView.getTargetHeight());
        } else if (state instanceof GuildMiniViewUIState.RemoveLastMiniView) {
            b1();
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAlongMiniViewVB", 1, "[onCreateView] ");
        View findViewById = createViewParams.b().findViewById(R.id.f166285zb0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "createViewParams.parent.\u2026ById(R.id.mini_view_root)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.miniViewRoot = frameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniViewRoot");
            return null;
        }
        return frameLayout;
    }
}
