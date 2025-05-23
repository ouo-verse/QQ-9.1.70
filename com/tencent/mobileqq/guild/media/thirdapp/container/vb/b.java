package com.tencent.mobileqq.guild.media.thirdapp.container.vb;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.thirdapp.container.uistate.GuildContainerMaskUIState;
import com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaThirdAppMaskView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mvi.mvvm.BaseVB;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0007:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vb/b;", "Lcom/tencent/mvi/mvvm/BaseVB;", "", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/uistate/GuildContainerMaskUIState;", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVB;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/a;", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "state", "", "c1", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppMaskView;", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppMaskView;", "maskView", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends BaseVB<Object, GuildContainerMaskUIState, com.tencent.base.api.runtime.a<BaseParam>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMediaThirdAppMaskView maskView;

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.guild.media.thirdapp.container.vm.a createVM() {
        return new com.tencent.mobileqq.guild.media.thirdapp.container.vm.a();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildContainerMaskUIState state) {
        GuildMediaThirdAppMaskView guildMediaThirdAppMaskView;
        int i3;
        Intrinsics.checkNotNullParameter(state, "state");
        if ((state instanceof GuildContainerMaskUIState.UpdateMaskViewVisibility) && (guildMediaThirdAppMaskView = this.maskView) != null) {
            if (((GuildContainerMaskUIState.UpdateMaskViewVisibility) state).getIsVisible()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            guildMediaThirdAppMaskView.setVisibility(i3);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        int i3;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerMaskVB", 1, "[onCreateView] ");
        ViewGroup b16 = createViewParams.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) b16;
        this.maskView = new GuildMediaThirdAppMaskView(getMContext());
        boolean hasOpenedMask = j.a().d0().getHasOpenedMask();
        GuildMediaThirdAppMaskView guildMediaThirdAppMaskView = this.maskView;
        if (guildMediaThirdAppMaskView != null) {
            if (hasOpenedMask) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            guildMediaThirdAppMaskView.setVisibility(i3);
        }
        frameLayout.addView(this.maskView, new FrameLayout.LayoutParams(-1, -1));
        GuildMediaThirdAppMaskView guildMediaThirdAppMaskView2 = this.maskView;
        Intrinsics.checkNotNull(guildMediaThirdAppMaskView2);
        return guildMediaThirdAppMaskView2;
    }
}
