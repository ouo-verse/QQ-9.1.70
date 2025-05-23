package com.tencent.mobileqq.guild.main.channellist;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import ar1.i;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import jr1.a;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0002\u0019\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/main/channellist/a;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onStart", DKHippyEvent.EVENT_STOP, "f", "g", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "Lar1/i;", "d", "Lar1/i;", "exitGuildDetectLogic", "Lcom/tencent/mobileqq/guild/main/channellist/GuildContentParams;", "e", "Lcom/tencent/mobileqq/guild/main/channellist/GuildContentParams;", "param", "Lcom/tencent/mobileqq/guild/main/channellist/a$b;", "Lkotlin/Lazy;", h.F, "()Lcom/tencent/mobileqq/guild/main/channellist/a$b;", "innerViewModelStoreOwner", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements LifecycleOwner, com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i exitGuildDetectLogic;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildContentParams param;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy innerViewModelStoreOwner;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/main/channellist/a$b;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "d", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements ViewModelStoreOwner {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ViewModelStore viewModelStore = new ViewModelStore();

        @Override // androidx.lifecycle.ViewModelStoreOwner
        @NotNull
        public ViewModelStore getViewModelStore() {
            return this.viewModelStore;
        }
    }

    private final void f() {
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        GuildContentParams guildContentParams = this.param;
        GuildContentParams guildContentParams2 = null;
        if (guildContentParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            guildContentParams = null;
        }
        iGPSService.subscribePolling(guildContentParams.getGuildId());
        GuildContentParams guildContentParams3 = this.param;
        if (guildContentParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            guildContentParams2 = guildContentParams3;
        }
        jr1.a.b(new a.AbstractC10609a.ConversationEmbeddedActive(guildContentParams2.getGuildId()));
    }

    private final void g() {
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        GuildContentParams guildContentParams = this.param;
        GuildContentParams guildContentParams2 = null;
        if (guildContentParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            guildContentParams = null;
        }
        iGPSService.unsubscribePolling(guildContentParams.getGuildId());
        GuildContentParams guildContentParams3 = this.param;
        if (guildContentParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            guildContentParams2 = guildContentParams3;
        }
        jr1.a.c(new a.AbstractC10609a.ConversationEmbeddedActive(guildContentParams2.getGuildId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b h() {
        return (b) this.innerViewModelStoreOwner.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPause() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onResume() {
        this.exitGuildDetectLogic.a();
        f();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStop() {
    }
}
