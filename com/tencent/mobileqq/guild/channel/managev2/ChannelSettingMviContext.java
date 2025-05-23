package com.tencent.mobileqq.guild.channel.managev2;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mvi.base.route.VMMessenger;
import com.tencent.mvi.base.route.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "Lcom/tencent/mvi/api/runtime/b;", "Landroidx/fragment/app/Fragment;", "c", "Landroidx/lifecycle/LifecycleOwner;", "d", "Lcom/tencent/mvi/base/route/j;", "e", "Lml3/b;", "b", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingFragment;", "a", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingFragment;", "fragment", "Lcom/tencent/mobileqq/guild/channel/managev2/utils/ChannelSettingUtils$Params;", "Lcom/tencent/mobileqq/guild/channel/managev2/utils/ChannelSettingUtils$Params;", "f", "()Lcom/tencent/mobileqq/guild/channel/managev2/utils/ChannelSettingUtils$Params;", "params", "Lcom/tencent/mvi/base/route/VMMessenger;", "Lcom/tencent/mvi/base/route/VMMessenger;", "mMessenger", "Lcom/tencent/mobileqq/guild/channel/managev2/c;", "Lcom/tencent/mobileqq/guild/channel/managev2/c;", "mEmitter", "<init>", "(Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingFragment;Lcom/tencent/mobileqq/guild/channel/managev2/utils/ChannelSettingUtils$Params;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ChannelSettingMviContext extends com.tencent.mvi.api.runtime.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChannelSettingFragment fragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChannelSettingUtils.Params params;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VMMessenger mMessenger;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mEmitter;

    public ChannelSettingMviContext(@NotNull ChannelSettingFragment fragment, @NotNull ChannelSettingUtils.Params params) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(params, "params");
        this.fragment = fragment;
        this.params = params;
        this.mMessenger = new VMMessenger(false, null, 3, 0 == true ? 1 : 0);
        this.mEmitter = new c();
        fragment.getViewLifecycleOwner().getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                Logger.f235387a.d().d("Guild.mnr.GuildSubChannelSettingMviContext", 1, "onStateChanged " + event);
            }
        });
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public ml3.b b() {
        return this.mEmitter;
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public Fragment c() {
        return this.fragment;
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public LifecycleOwner d() {
        return this.fragment;
    }

    @Override // com.tencent.mvi.api.runtime.b
    @NotNull
    public j e() {
        return this.mMessenger;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final ChannelSettingUtils.Params getParams() {
        return this.params;
    }
}
