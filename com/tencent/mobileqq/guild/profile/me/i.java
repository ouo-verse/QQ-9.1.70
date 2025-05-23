package com.tencent.mobileqq.guild.profile.me;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.em;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import vh2.bz;
import wh2.ck;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0+8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\n0+8F\u00a2\u0006\u0006\u001a\u0004\b/\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/i;", "Lef1/b;", "", "addObserver", "removeObserver", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "createGpServiceObserver", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "info", "dealProfileInfo", "", "X1", "", "date", "date2", "", "getDateDiffDays", "S1", "onResume", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_guildInfoLiveData", "D", "_guildNumLiveData", "E", "_isSignLiveData", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "G", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "serviceHolder", "H", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpServiceObserver", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "U1", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gproService", "Landroidx/lifecycle/LiveData;", "W1", "()Landroidx/lifecycle/LiveData;", "guildNumLiveData", "Z1", "isSignLiveData", "<init>", "()V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i extends ef1.b {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _guildInfoLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _guildNumLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isSignLiveData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String guildId = "0";

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpServiceObserver = createGpServiceObserver();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ServiceCache$LazyHolder serviceHolder = new ServiceCache$LazyHolder("Guild.profile.GuildMeNewViewModel");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/i$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lcom/tencent/mobileqq/guild/profile/me/i;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.me.i$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.profile.me.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7863a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f231239a;

            public C7863a(ViewModelStoreOwner viewModelStoreOwner) {
                this.f231239a = viewModelStoreOwner;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new i(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                }
                return (T) timedValue.getValue();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final i a(@NotNull ViewModelStoreOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C7863a(owner)).get(i.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (i) viewModel;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/profile/me/i$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "result", "", "errMsg", "guildId", "tinyId", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "info", "", "onUserProfileInfoUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int result, @NotNull String errMsg, @NotNull String guildId, @NotNull String tinyId, @NotNull ev info) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onUserProfileInfoUpdate(result, errMsg, guildId, tinyId, info);
            if (result != 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "onUserProfileInfoUpdate failed:" + result + " - " + errMsg;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.profile.GuildMeNewViewModel", 1, (String) it.next(), null);
                }
                return;
            }
            if (TextUtils.equals(i.this.U1().getSelfTinyId(), tinyId)) {
                i.this.dealProfileInfo(info);
            }
        }
    }

    public i() {
        U1().refreshGuildUserProfileInfo("0", U1().getSelfTinyId());
        addObserver();
        U1().loadGProUserProfileInfo("0", U1().getSelfTinyId(), new bz() { // from class: com.tencent.mobileqq.guild.profile.me.h
            @Override // vh2.bz
            public final void a(int i3, String str, ev evVar) {
                i.P1(i.this, i3, str, evVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(i this$0, int i3, String str, ev evVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            Logger.f235387a.d().i("Guild.profile.GuildMeNewViewModel", 1, "loadGProUserProfileInfo error, result: " + i3 + " errMsg:" + str);
            return;
        }
        if (evVar != null) {
            this$0.dealProfileInfo(evVar);
        } else {
            Logger.f235387a.d().w("Guild.profile.GuildMeNewViewModel", 1, "init nickname: userProfileInfo is null");
        }
    }

    private final void S1() {
        U1().getGuildsInContact(new ck() { // from class: com.tencent.mobileqq.guild.profile.me.g
            @Override // wh2.ck
            public final void onGetGuildsInContact(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
                i.T1(i.this, arrayList, arrayList2, arrayList3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(i this$0, ArrayList createdGuilds, ArrayList managedGuilds, ArrayList joinedGuilds) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(createdGuilds, "createdGuilds");
        Intrinsics.checkNotNullParameter(managedGuilds, "managedGuilds");
        Intrinsics.checkNotNullParameter(joinedGuilds, "joinedGuilds");
        Logger.f235387a.d().i("Guild.profile.GuildMeNewViewModel", 1, "fetchGuildNum: " + createdGuilds.size() + "-" + managedGuilds.size() + "-" + joinedGuilds.size());
        this$0._guildNumLiveData.postValue(Integer.valueOf(createdGuilds.size() + managedGuilds.size() + joinedGuilds.size()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGPSService U1() {
        return this.serviceHolder.b();
    }

    private final boolean X1(ev info) {
        em s16 = info.s();
        if (s16 == null) {
            return false;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        if (s16.getStartTime() <= 0 || s16.getEndTime() <= 0 || serverTimeMillis <= s16.getStartTime() || serverTimeMillis >= s16.getEndTime()) {
            return false;
        }
        return true;
    }

    private final void addObserver() {
        U1().addObserver(this.gpServiceObserver);
    }

    private final GPServiceObserver createGpServiceObserver() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealProfileInfo(ev info) {
        int i3;
        String str;
        if (info.q() > 0) {
            i3 = getDateDiffDays(info.q() * 1000, NetConnInfoCenter.getServerTimeMillis());
        } else {
            i3 = 0;
        }
        MutableLiveData<String> mutableLiveData = this._guildInfoLiveData;
        if (i3 > 0) {
            str = "\u52a0\u5165\u9891\u9053" + i3 + "\u5929";
        } else {
            str = "\u521a\u521a\u52a0\u5165\u9891\u9053";
        }
        mutableLiveData.setValue(str);
        this._isSignLiveData.setValue(Boolean.valueOf(X1(info)));
    }

    private final int getDateDiffDays(long date, long date2) {
        if (date > 0 && date2 > 0) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().c("Guild.profile.GuildMeNewViewModel", 2, "date: " + com.tencent.mobileqq.remind.e.a(date) + " - date2: " + com.tencent.mobileqq.remind.e.a(date2));
            }
            long abs = Math.abs(date - date2) / 1000;
            long j3 = 60;
            return (int) (((abs / j3) / j3) / 24);
        }
        return -1;
    }

    private final void removeObserver() {
        U1().deleteObserver(this.gpServiceObserver);
    }

    @NotNull
    public final LiveData<Integer> W1() {
        return this._guildNumLiveData;
    }

    @NotNull
    public final LiveData<Boolean> Z1() {
        return this._isSignLiveData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        removeObserver();
    }

    public final void onResume() {
        S1();
    }
}
