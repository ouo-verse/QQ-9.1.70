package com.tencent.guild.aio.reserve2.busi.network;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.reserve2.busi.network.GuildNetworkMsgUIState;
import com.tencent.guild.aio.reserve2.busi.network.a;
import com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/network/d;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/guild/aio/reserve2/busi/network/a;", "Lcom/tencent/guild/aio/reserve2/busi/network/GuildNetworkMsgUIState;", "", DomainData.DOMAIN_NAME, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "l", "Lcom/tencent/mobileqq/guild/nt/misc/api/INetworkStateApi$a;", "d", "Lcom/tencent/mobileqq/guild/nt/misc/api/INetworkStateApi$a;", "mNetworkListener", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends com.tencent.aio.base.mvvm.b<a, GuildNetworkMsgUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final INetworkStateApi.a mNetworkListener = new INetworkStateApi.a() { // from class: com.tencent.guild.aio.reserve2.busi.network.c
        @Override // com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi.a
        public final void onNetworkConnect(boolean z16) {
            d.m(d.this, z16);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(d this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n();
    }

    private final void n() {
        updateUI(new GuildNetworkMsgUIState.NetworkStatusState(((INetworkStateApi) QRoute.api(INetworkStateApi.class)).isNetworkAvailable()));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C1212a) {
            n();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).removeConnectStateListener(this.mNetworkListener);
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).addConnectStateListener(this.mNetworkListener);
    }
}
