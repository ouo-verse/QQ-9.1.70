package com.tencent.mobileqq.guild.profile.me;

import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.base.repository.RepositoryCallbackConfig;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bz;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000f\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0007J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u000f\u0010\u0010\u001a\u00020\u000fH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u0016\u0010#\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/aj;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Lcom/tencent/mobileqq/guild/base/repository/b;", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/profile/me/ak;", "listener", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "r", tl.h.F, "o", "com/tencent/mobileqq/guild/profile/me/aj$a", "i", "()Lcom/tencent/mobileqq/guild/profile/me/aj$a;", "", "account", "onAccountChanged", "f", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "selfUserProfileInfo", "", "Z", "isFetching", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mListeners", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpsServiceObserver", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "selfAccountUin", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "j", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "gproGlobalService", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "k", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gproService", "Lcom/tencent/mobileqq/guild/base/repository/c;", "a", "()Lcom/tencent/mobileqq/guild/base/repository/c;", "repositoryCallbackConfig", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class aj implements com.tencent.mobileqq.guild.base.repository.a, com.tencent.mobileqq.guild.base.repository.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private static String selfAccountUin;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final aj f231133e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ev selfUserProfileInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isFetching;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<ak> mListeners;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final GPServiceObserver gpsServiceObserver;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.guild.base.repository.d f231138d = new com.tencent.mobileqq.guild.base.repository.d("GuildSelfUserProfileInfoRepository");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/profile/me/aj$a", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "result", "", "errMsg", "guildId", "tinyId", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "info", "", "onUserProfileInfoUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int result, @Nullable String errMsg, @Nullable String guildId, @Nullable String tinyId, @Nullable ev info) {
            if (result != 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "onUserProfileInfoUpdate " + result + " " + errMsg;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.profile.GuildSelfUserProfileInfoRepository", 1, (String) it.next(), null);
                }
                return;
            }
            if (Intrinsics.areEqual("0", guildId)) {
                aj ajVar = aj.f231133e;
                if (Intrinsics.areEqual(ajVar.k().getSelfTinyId(), tinyId) && info != null) {
                    aj.selfUserProfileInfo = info;
                    ajVar.o();
                    Logger.f235387a.d().d("Guild.profile.GuildSelfUserProfileInfoRepository", 1, "onUserProfileInfoUpdate info:" + info.getTinyId() + ", " + cq.w(info.getNickName(), 2) + ", " + info.getAvatarMeta() + " ");
                }
            }
        }
    }

    static {
        aj ajVar = new aj();
        f231133e = ajVar;
        mListeners = new CopyOnWriteArrayList<>();
        gpsServiceObserver = ajVar.i();
        String g16 = ch.g();
        Intrinsics.checkNotNullExpressionValue(g16, "accountUin()");
        selfAccountUin = g16;
        AccountChangedNotifier.f214789d.a(ajVar);
        ajVar.r();
    }

    aj() {
    }

    @JvmStatic
    public static final void g(@NotNull ak listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        mListeners.addIfAbsent(listener);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.profile.GuildSelfUserProfileInfoRepository", 2, "addListener");
        }
    }

    private final void h() {
        j().deleteObserver(gpsServiceObserver);
        isFetching = false;
        selfUserProfileInfo = null;
    }

    private final a i() {
        return new a();
    }

    private final IGProGlobalService j() {
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "Guild.profile.GuildSelfUserProfileInfoRepository");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        return (IGProGlobalService) S0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGPSService k() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "Guild.profile.GuildSelfUserProfileInfoRepository");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        return (IGPSService) S0;
    }

    @JvmStatic
    @Nullable
    public static final ev l() {
        if (!at.c()) {
            Logger.f235387a.d().w("Guild.profile.GuildSelfUserProfileInfoRepository", 1, "getSelfUserProfileInfo isWrapperSessionReady false");
            return null;
        }
        if (selfUserProfileInfo == null) {
            f231133e.m();
        }
        return selfUserProfileInfo;
    }

    private final void m() {
        if (isFetching) {
            return;
        }
        isFetching = true;
        k().loadGProUserProfileInfo("0", k().getSelfTinyId(), new bz() { // from class: com.tencent.mobileqq.guild.profile.me.ai
            @Override // vh2.bz
            public final void a(int i3, String str, ev evVar) {
                aj.n(i3, str, evVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(int i3, String str, ev evVar) {
        isFetching = false;
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "loadGProUserProfileInfo error, result: " + i3 + " errMsg:" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.profile.GuildSelfUserProfileInfoRepository", 1, (String) it.next(), null);
            }
            p();
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.profile.GuildSelfUserProfileInfoRepository", 2, "loadGProUserProfileInfo success, info:" + evVar);
        }
        selfUserProfileInfo = evVar;
        f231133e.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        if (selfUserProfileInfo != null) {
            for (ak akVar : mListeners) {
                ev evVar = selfUserProfileInfo;
                Intrinsics.checkNotNull(evVar);
                akVar.a(evVar);
            }
        }
    }

    @JvmStatic
    public static final void p() {
        if (!at.c()) {
            Logger.f235387a.d().w("Guild.profile.GuildSelfUserProfileInfoRepository", 1, "refreshSelfUserProfileInfo isWrapperSessionReady false");
        } else {
            f231133e.k().refreshGuildUserProfileInfo("0", ch.f());
        }
    }

    @JvmStatic
    public static final void q(@NotNull ak listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        mListeners.remove(listener);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.profile.GuildSelfUserProfileInfoRepository", 2, "removeListener");
        }
    }

    private final void r() {
        j().addObserver(gpsServiceObserver);
        if (!at.c()) {
            Logger.f235387a.d().w("Guild.profile.GuildSelfUserProfileInfoRepository", 1, "setUp isWrapperSessionReady false");
        } else {
            p();
        }
    }

    @Override // com.tencent.mobileqq.guild.base.repository.b
    @NotNull
    /* renamed from: a */
    public RepositoryCallbackConfig getRepositoryCallbackConfig() {
        return this.f231138d.getRepositoryCallbackConfig();
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        selfAccountUin = account;
        h();
        r();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.profile.GuildSelfUserProfileInfoRepository", 2, "onAccountChanged " + selfAccountUin);
        }
    }
}
