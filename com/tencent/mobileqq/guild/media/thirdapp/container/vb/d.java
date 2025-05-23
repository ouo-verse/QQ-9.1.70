package com.tencent.mobileqq.guild.media.thirdapp.container.vb;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.vm.GuildContainerRootVM;
import com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaNestedFrameLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0006:\u0001\u001dB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\b\u001a\u00020\u0007H\u0016JJ\u0010\u000e\u001a<\u00128\u00126\u0012\u0006\b\u0001\u0012\u00020\f\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0001j\u0012\u0012\u0006\b\u0001\u0012\u00020\f\u0012\u0006\b\u0001\u0012\u00020\r`\u00060\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vb/d;", "Lcom/tencent/mvi/mvvm/BaseVB;", "", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVB;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerRootVM;", "b1", "Landroid/view/View;", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "startParams", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "containerView", "<init>", "(Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;)V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends BaseVB<Object, Object, com.tencent.base.api.runtime.a<BaseParam>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildOpenContainerLauncher.StartParams startParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout containerView;

    public d(@NotNull GuildOpenContainerLauncher.StartParams startParams) {
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        this.startParams = startParams;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public GuildContainerRootVM createVM() {
        return new GuildContainerRootVM();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.base.api.runtime.a<BaseParam>>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.base.api.runtime.a<BaseParam>>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new BaseVB[]{new f(this.startParams), new a(), new c(), new b()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerRootVB", 1, "[onCreateView] ");
        GuildMediaNestedFrameLayout guildMediaNestedFrameLayout = new GuildMediaNestedFrameLayout(createViewParams.a());
        this.containerView = guildMediaNestedFrameLayout;
        guildMediaNestedFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 1));
        FrameLayout frameLayout = this.containerView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            return null;
        }
        return frameLayout;
    }
}
