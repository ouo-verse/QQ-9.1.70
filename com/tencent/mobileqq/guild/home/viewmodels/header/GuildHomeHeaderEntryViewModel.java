package com.tencent.mobileqq.guild.home.viewmodels.header;

import androidx.lifecycle.LiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderEntryViewModel;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0002\u0018\u0000 %2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0014J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderEntryViewModel;", "Lef1/b;", "com/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderEntryViewModel$b", "S1", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderEntryViewModel$b;", "", "from", "", "U1", "account", "onAccountChanged", "onCleared", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "T1", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "Le12/a;", "", "kotlin.jvm.PlatformType", "D", "Le12/a;", "_isGroupChatShow", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "E", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Q1", "gProObserver", "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "isGroupChatShow", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeHeaderEntryViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private FacadeArgsData facadeArgsData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _isGroupChatShow;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy gProObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderEntryViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onChannelListUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "onGuildPermissionChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String guildId) {
            if (Intrinsics.areEqual(GuildHomeHeaderEntryViewModel.this.facadeArgsData.f227656e, guildId)) {
                GuildHomeHeaderEntryViewModel.this.U1("onChannelListUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(@Nullable String guildId, @Nullable dx permission) {
            if (Intrinsics.areEqual(GuildHomeHeaderEntryViewModel.this.facadeArgsData.f227656e, guildId)) {
                GuildHomeHeaderEntryViewModel.this.U1("onGuildPermissionChanged");
            }
        }
    }

    public GuildHomeHeaderEntryViewModel(@NotNull FacadeArgsData facadeArgsData) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
        this._isGroupChatShow = new e12.a<>(Boolean.FALSE);
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.gProService = (IGPSService) R0;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderEntryViewModel$gProObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeHeaderEntryViewModel.b invoke() {
                GuildHomeHeaderEntryViewModel.b S1;
                S1 = GuildHomeHeaderEntryViewModel.this.S1();
                return S1;
            }
        });
        this.gProObserver = lazy;
        this.gProService.addObserver(Q1());
        U1("init");
    }

    private final b Q1() {
        return (b) this.gProObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b S1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(String from) {
        j jVar = j.f225420a;
        String str = this.facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        boolean a16 = jVar.a(str, from);
        if (!Intrinsics.areEqual(this._isGroupChatShow.getValue(), Boolean.valueOf(a16))) {
            this._isGroupChatShow.setValue(Boolean.valueOf(a16));
        }
    }

    @NotNull
    public final LiveData<Boolean> R1() {
        return this._isGroupChatShow;
    }

    public final void T1(@NotNull FacadeArgsData facadeArgsData) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
        U1("updateGuild");
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.gProService = iGPSService;
        iGPSService.addObserver(Q1());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.gProService.deleteObserver(Q1());
    }
}
