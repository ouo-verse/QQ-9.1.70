package com.tencent.mobileqq.guild.home.viewmodels.net;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import ef1.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0004H\u0014R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/net/GuildNetViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/guild/nt/misc/api/INetworkStateApi$a;", "P1", "", "onResume", "onCleared", "Lko4/a;", "", BdhLogUtil.LogTag.Tag_Conn, "Lko4/a;", "_onReconnectLivedata", "D", "Z", "isLastNetConnected", "E", "Lkotlin/Lazy;", "R1", "()Lcom/tencent/mobileqq/guild/nt/misc/api/INetworkStateApi$a;", "networkConnectListener", "Landroidx/lifecycle/MutableLiveData;", "S1", "()Landroidx/lifecycle/MutableLiveData;", "onReconnectLivedata", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNetViewModel extends b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ko4.a<Boolean> _onReconnectLivedata = new ko4.a<>();

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isLastNetConnected = true;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy networkConnectListener;

    public GuildNetViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<INetworkStateApi.a>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.net.GuildNetViewModel$networkConnectListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final INetworkStateApi.a invoke() {
                INetworkStateApi.a P1;
                P1 = GuildNetViewModel.this.P1();
                return P1;
            }
        });
        this.networkConnectListener = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final INetworkStateApi.a P1() {
        return new INetworkStateApi.a() { // from class: com.tencent.mobileqq.guild.home.viewmodels.net.a
            @Override // com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi.a
            public final void onNetworkConnect(boolean z16) {
                GuildNetViewModel.Q1(GuildNetViewModel.this, z16);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(GuildNetViewModel this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().a("Guild.NewHome.GuildNetViewModel", 1, "ConnectStateListener isConnect:" + z16);
        if (this$0.isLastNetConnected != z16 && z16) {
            this$0._onReconnectLivedata.setValue(Boolean.TRUE);
        }
        this$0.isLastNetConnected = z16;
    }

    private final INetworkStateApi.a R1() {
        return (INetworkStateApi.a) this.networkConnectListener.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> S1() {
        return this._onReconnectLivedata;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).removeConnectStateListener(R1());
    }

    public final void onResume() {
        this.isLastNetConnected = ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).isNetworkAvailable();
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).addConnectStateListener(R1());
    }
}
