package com.tencent.mobileqq.guild.home.subhome;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.home.viewmodels.permission.GuildHomePermissionViewModel;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.entry.util.DeviceUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeChannels;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import so1.h;
import so1.j;
import so1.l;
import vh2.bb;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u00016B'\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0014R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010+R\u001d\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0-8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\b0-8F\u00a2\u0006\u0006\u001a\u0004\b1\u0010/\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/home/subhome/e;", "Lef1/b;", "", "guildId", "", "categoryId", "", "Z1", "", "R1", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "S1", "T1", "account", "onAccountChanged", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "currentGuildId", "D", "J", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "E", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", "guildHomePermissionViewModel", "Landroidx/lifecycle/MutableLiveData;", "", "Lso1/h;", "G", "Landroidx/lifecycle/MutableLiveData;", "_liveAudioChannelList", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "H", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "I", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "Le12/a;", "Le12/a;", "_canCreateSubChannel", "Landroidx/lifecycle/LiveData;", "X1", "()Landroidx/lifecycle/LiveData;", "liveAudioChannelList", "W1", "canCreateSubChannel", "<init>", "(Ljava/lang/String;JLcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String currentGuildId;

    /* renamed from: D, reason: from kotlin metadata */
    private final long categoryId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final FacadeArgsData facadeArgsData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final GuildHomePermissionViewModel guildHomePermissionViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<h>> _liveAudioChannelList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gProObserver;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _canCreateSubChannel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0014J\u0018\u0010\f\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nH\u0014J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nH\u0014J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0014\u00a8\u0006\u001a"}, d2 = {"com/tencent/mobileqq/guild/home/subhome/e$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "channelId", "", "oldVisibleType", "newVisibleType", "", "onChannelVisibleChanged", "Ljava/util/HashSet;", "changedGuildIdSet", "onPollingLiveAudioChannelPresence", "onChannelListUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/g;", "channelSimpleInfo", "onChannelUpdatedWithSimpleInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "onGuildPermissionChanged", "channelIds", "onChannelPermissionChanged", "admint", "", "bAdmin", "onAdminChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(@NotNull String guildId, @NotNull String admint, boolean bAdmin) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(admint, "admint");
            super.onAdminChanged(guildId, admint, bAdmin);
            QLog.i("Guild.NewHome.content.active.GuildHomeSubLiveChannelViewModel", 1, "onAdminChanged:" + guildId);
            if (!TextUtils.equals(guildId, e.this.facadeArgsData.f227656e)) {
                return;
            }
            e eVar = e.this;
            eVar.Z1(guildId, eVar.facadeArgsData.f227657f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String guildId) {
            QLog.i("Guild.NewHome.content.active.GuildHomeSubLiveChannelViewModel", 1, "onChannelListUpdated, currentGuildId:" + e.this.currentGuildId + ", param guildId:" + guildId);
            if (!Intrinsics.areEqual(guildId, e.this.currentGuildId)) {
                return;
            }
            e.this.T1();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(@NotNull String guildId, @Nullable HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            super.onChannelPermissionChanged(guildId, channelIds);
            QLog.i("Guild.NewHome.content.active.GuildHomeSubLiveChannelViewModel", 1, "onChannelPermissionChanged:" + guildId);
            if (!TextUtils.equals(guildId, e.this.facadeArgsData.f227656e)) {
                return;
            }
            e eVar = e.this;
            eVar.Z1(guildId, eVar.facadeArgsData.f227657f);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelUpdatedWithSimpleInfo(@Nullable com.tencent.mobileqq.qqguildsdk.data.g channelSimpleInfo) {
            QLog.i("Guild.NewHome.content.active.GuildHomeSubLiveChannelViewModel", 1, "onChannelUpdatedWithSimpleInfo, currentGuildId:" + e.this.currentGuildId + ", channelSimpleInfo:" + channelSimpleInfo);
            if (channelSimpleInfo != null) {
                e eVar = e.this;
                if (Intrinsics.areEqual(channelSimpleInfo.d(), eVar.currentGuildId)) {
                    if (channelSimpleInfo.c() == 5 || channelSimpleInfo.c() == 2) {
                        eVar.T1();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelVisibleChanged(@Nullable String guildId, @Nullable String channelId, int oldVisibleType, int newVisibleType) {
            QLog.i("Guild.NewHome.content.active.GuildHomeSubLiveChannelViewModel", 1, "onChannelVisibleChanged, currentGuildId:" + e.this.currentGuildId + ", param guildId:" + guildId);
            if (!Intrinsics.areEqual(guildId, e.this.currentGuildId)) {
                return;
            }
            e.this.T1();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(@NotNull String guildId, @Nullable dx permission) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            super.onGuildPermissionChanged(guildId, permission);
            QLog.i("Guild.NewHome.content.active.GuildHomeSubLiveChannelViewModel", 1, "onGuildPermissionChanged:" + guildId);
            if (!TextUtils.equals(guildId, e.this.facadeArgsData.f227656e)) {
                return;
            }
            e eVar = e.this;
            eVar.Z1(guildId, eVar.facadeArgsData.f227657f);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPollingLiveAudioChannelPresence(@Nullable HashSet<String> changedGuildIdSet) {
            QLog.i("Guild.NewHome.content.active.GuildHomeSubLiveChannelViewModel", 1, "onPollingLiveAudioChannelPresence, currentGuildId:" + e.this.currentGuildId);
            if (changedGuildIdSet != null) {
                e eVar = e.this;
                if (changedGuildIdSet.contains(eVar.currentGuildId)) {
                    QLog.i("Guild.NewHome.content.active.GuildHomeSubLiveChannelViewModel", 1, "onPollingLiveAudioChannelPresence\uff0cset contains current guildId:" + eVar.currentGuildId);
                    eVar.T1();
                }
            }
        }
    }

    public e(@NotNull String currentGuildId, long j3, @NotNull FacadeArgsData facadeArgsData, @NotNull GuildHomePermissionViewModel guildHomePermissionViewModel) {
        Intrinsics.checkNotNullParameter(currentGuildId, "currentGuildId");
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        Intrinsics.checkNotNullParameter(guildHomePermissionViewModel, "guildHomePermissionViewModel");
        this.currentGuildId = currentGuildId;
        this.categoryId = j3;
        this.facadeArgsData = facadeArgsData;
        this.guildHomePermissionViewModel = guildHomePermissionViewModel;
        this._liveAudioChannelList = new MutableLiveData<>();
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        this.gProService = (IGPSService) S0;
        GPServiceObserver S1 = S1();
        this.gProObserver = S1;
        e12.a<Boolean> aVar = new e12.a<>();
        this._canCreateSubChannel = aVar;
        this.gProService.addObserver(S1);
        aVar.setValue(Boolean.valueOf(R1(currentGuildId, j3)));
        T1();
    }

    private final boolean R1(String guildId, long categoryId) {
        if (!r.p().getGuildPermission(guildId).a(20001) && !r.p().getCategoryPermission(guildId, String.valueOf(categoryId)).a(20001)) {
            return false;
        }
        return true;
    }

    private final GPServiceObserver S1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(e this$0, GProRealTimeChannels gProRealTimeChannels) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (gProRealTimeChannels == null) {
            Logger.f235387a.d().w("Guild.NewHome.content.active.GuildHomeSubLiveChannelViewModel", 1, "getLiveAudioPollingCtx guildId:" + this$0.currentGuildId + " isNull, return");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<GProRealTimeChannel> arrayList2 = gProRealTimeChannels.channels;
        if (arrayList2 != null) {
            for (GProRealTimeChannel it : arrayList2) {
                so1.a aVar = so1.a.f434027a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                String str = this$0.currentGuildId;
                String str2 = it.channelId;
                Intrinsics.checkNotNullExpressionValue(str2, "it.channelId");
                h c16 = aVar.c(it, str, str2);
                if (c16 != null) {
                    arrayList.add(c16);
                }
            }
        }
        if (arrayList.size() == 0) {
            String str3 = this$0.currentGuildId;
            long j3 = this$0.categoryId;
            Boolean value = this$0.W1().getValue();
            if (value == null) {
                value = Boolean.FALSE;
            }
            arrayList.add(new j(str3, null, null, j3, value.booleanValue(), 6, null));
        }
        if (DeviceUtils.isPad(BaseApplication.context)) {
            i3 = 4;
        } else {
            i3 = 2;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            arrayList.add(new l());
        }
        this$0._liveAudioChannelList.setValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(String guildId, long categoryId) {
        boolean R1 = R1(guildId, categoryId);
        if (!Intrinsics.areEqual(W1().getValue(), Boolean.valueOf(R1))) {
            this._canCreateSubChannel.setValue(Boolean.valueOf(R1));
            T1();
        }
    }

    public final void T1() {
        this.gProService.getLiveAudioPollingCtx(this.currentGuildId, String.valueOf(this.categoryId), new bb() { // from class: com.tencent.mobileqq.guild.home.subhome.d
            @Override // vh2.bb
            public final void onResult(GProRealTimeChannels gProRealTimeChannels) {
                e.U1(e.this, gProRealTimeChannels);
            }
        });
    }

    @NotNull
    public final LiveData<Boolean> W1() {
        return this._canCreateSubChannel;
    }

    @NotNull
    public final LiveData<List<h>> X1() {
        return this._liveAudioChannelList;
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.gProService.deleteObserver(this.gProObserver);
        super.onAccountChanged(account);
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        this.gProService = iGPSService;
        iGPSService.addObserver(this.gProObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.gProService.deleteObserver(this.gProObserver);
    }
}
