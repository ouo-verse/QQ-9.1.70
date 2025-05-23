package com.tencent.mobileqq.guild.homev2.live.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.channel.joinchannel.h;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0014R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/b;", "Lef1/b;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "P1", "", "from", "", "T1", "Landroid/content/Context;", "context", "R1", "account", "onAccountChanged", "onCleared", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "mJumpGuildParam", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "D", "Landroidx/lifecycle/MutableLiveData;", "_guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "E", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "guildInfo", "<init>", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final JumpGuildParam mJumpGuildParam;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<IGProGuildInfo> _guildInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gProObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/homev2/live/viewmodel/b$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onGuildInfoUpdated", "onGuildListUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.homev2.live.viewmodel.b$b, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7804b extends GPServiceObserver {
        C7804b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            if (Intrinsics.areEqual(guildId, b.this.mJumpGuildParam.guildId)) {
                b.this.T1("onGuildInfoUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildListUpdated() {
            b.this.T1("onGuildListUpdated");
        }
    }

    public b(@NotNull JumpGuildParam mJumpGuildParam) {
        Intrinsics.checkNotNullParameter(mJumpGuildParam, "mJumpGuildParam");
        this.mJumpGuildParam = mJumpGuildParam;
        this._guildInfo = new MutableLiveData<>();
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        this.gProService = (IGPSService) S0;
        GPServiceObserver P1 = P1();
        this.gProObserver = P1;
        this.gProService.addObserver(P1);
    }

    private final GPServiceObserver P1() {
        return new C7804b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(Context context, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Logger.f235387a.d().i("GuildLiveGuildStateViewModel", 1, "addGuild result:" + i3 + " msg:" + str + " security:" + iGProSecurityResult);
        if (!h.d(i3, iGProSecurityResult)) {
            h.c(context, i3, str, iGProSecurityResult);
        }
    }

    @NotNull
    public final LiveData<IGProGuildInfo> Q1() {
        return this._guildInfo;
    }

    public final void R1(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
        jumpParam.c(false);
        jumpParam.a(1);
        jumpParam.d(!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected());
        Logger.f235387a.d().i("GuildLiveGuildStateViewModel", 1, "addGuild guildId:" + this.mJumpGuildParam + ".guildId");
        h.a(context, this.mJumpGuildParam, jumpParam, "GuildLiveGuildStateViewModel", new bv() { // from class: com.tencent.mobileqq.guild.homev2.live.viewmodel.a
            @Override // vh2.bv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                b.S1(context, i3, str, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
    }

    public final void T1(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildLiveGuildStateViewModel", 1, "updateData from:" + from);
        }
        this._guildInfo.setValue(this.gProService.getGuildInfo(this.mJumpGuildParam.guildId));
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
