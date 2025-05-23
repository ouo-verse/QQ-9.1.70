package com.tencent.mobileqq.guild.homev2.live.viewmodel;

import androidx.lifecycle.LiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.rolegroup.model.data.Permissions;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u00020\u0001:\u0001*B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0014R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150!8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/d;", "Lef1/b;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "P1", "", "from", "", "S1", "account", "onAccountChanged", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mGuildId", "D", "mCategoryId", "", "E", "I", "mSceneType", "Lko4/a;", "", UserInfo.SEX_FEMALE, "Lko4/a;", "_canCreateLiveChannel", "G", "_canManageLiveChannel", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "H", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "canCreateLiveChannel", "R1", "canManageLiveChannel", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String mGuildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String mCategoryId;

    /* renamed from: E, reason: from kotlin metadata */
    private final int mSceneType;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ko4.a<Boolean> _canCreateLiveChannel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ko4.a<Boolean> _canManageLiveChannel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gProObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0014J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/homev2/live/viewmodel/d$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "onGuildPermissionChanged", "Ljava/util/HashSet;", "channelIds", "onChannelPermissionChanged", "onGuildInfoUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(@NotNull String guildId, @NotNull HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            if (!Intrinsics.areEqual(guildId, d.this.mGuildId)) {
                return;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildLivePermissionViewModel", 1, "onGuildPermissionChanged channelIds:" + channelIds);
            }
            d.this.S1("onChannelPermissionChanged");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            if (!Intrinsics.areEqual(guildId, d.this.mGuildId)) {
                return;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildLivePermissionViewModel", 1, "onGuildInfoUpdated");
            }
            d.this.S1("onGuildInfoUpdated");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(@NotNull String guildId, @NotNull dx permission) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(permission, "permission");
            if (!Intrinsics.areEqual(guildId, d.this.mGuildId)) {
                return;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildLivePermissionViewModel", 1, "onGuildPermissionChanged");
            }
            d.this.S1("onGuildPermissionChanged");
        }
    }

    public d(@NotNull String mGuildId, @NotNull String mCategoryId, int i3) {
        Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
        Intrinsics.checkNotNullParameter(mCategoryId, "mCategoryId");
        this.mGuildId = mGuildId;
        this.mCategoryId = mCategoryId;
        this.mSceneType = i3;
        this._canCreateLiveChannel = new ko4.a<>();
        this._canManageLiveChannel = new ko4.a<>();
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        this.gProService = (IGPSService) S0;
        GPServiceObserver P1 = P1();
        this.gProObserver = P1;
        this.gProService.addObserver(P1);
    }

    private final GPServiceObserver P1() {
        return new b();
    }

    @NotNull
    public final LiveData<Boolean> Q1() {
        return this._canCreateLiveChannel;
    }

    @NotNull
    public final LiveData<Boolean> R1() {
        return this._canManageLiveChannel;
    }

    public final void S1(@NotNull String from) {
        boolean z16;
        Integer num;
        Intrinsics.checkNotNullParameter(from, "from");
        Logger logger = Logger.f235387a;
        boolean z17 = true;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildLivePermissionViewModel", 1, "updateEntrancePermission from:" + from + " mSceneType:" + this.mSceneType);
        }
        if (this.mSceneType == 1) {
            ko4.a<Boolean> aVar = this._canCreateLiveChannel;
            Boolean bool = Boolean.FALSE;
            aVar.setValue(bool);
            this._canManageLiveChannel.setValue(bool);
            return;
        }
        Permissions guildPermission = r.p().getGuildPermission(this.mGuildId);
        Permissions categoryPermission = r.p().getCategoryPermission(this.mGuildId, this.mCategoryId);
        if (!guildPermission.a(20001) && !categoryPermission.a(20001)) {
            z16 = false;
        } else {
            z16 = true;
        }
        this._canCreateLiveChannel.setValue(Boolean.valueOf(z16));
        IGProGuildInfo guildInfo = this.gProService.getGuildInfo(this.mGuildId);
        if (guildInfo != null) {
            num = Integer.valueOf(guildInfo.getUserType());
        } else {
            num = null;
        }
        ko4.a<Boolean> aVar2 = this._canManageLiveChannel;
        if ((num == null || num.intValue() != 2) && (num == null || num.intValue() != 1)) {
            z17 = false;
        }
        aVar2.setValue(Boolean.valueOf(z17));
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
