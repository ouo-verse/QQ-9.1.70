package com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.rightlist.cover;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.rightlist.cover.GuildCoverViewModel;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import e12.e;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.Job;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b5\u00106J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0014R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020/8F\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0019\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190/8F\u00a2\u0006\u0006\u001a\u0004\b3\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/rightlist/cover/GuildCoverViewModel;", "Lef1/b;", "", "guildId", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "Z1", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "T1", "", "S1", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "banner", ICustomDataEditor.STRING_ARRAY_PARAM_2, "account", "onAccountChanged", "onCleared", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "facadeType", "Le12/e;", "D", "Le12/e;", "_coverUrl", "Le12/a;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "E", "Le12/a;", "_guildInfo", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "G", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "gProService", "H", "Lkotlin/Lazy;", "W1", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "Lmqq/util/WeakReference;", "I", "Lmqq/util/WeakReference;", "bannerViewRef", "J", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "activeGuildQJob", "Landroidx/lifecycle/LiveData;", "U1", "()Landroidx/lifecycle/LiveData;", "coverUrl", "X1", "guildInfo", "<init>", "(Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCoverViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildFacadeType facadeType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e<String> _coverUrl;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final e12.a<IGProGuildInfo> _guildInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private IGProGlobalService gProService;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy gProObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private WeakReference<GuildHomeCoverBelowList> bannerViewRef;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b activeGuildQJob;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\u0004H\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/mainframe/startpanel/rightpart/rightlist/cover/GuildCoverViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", h.F, "onGuildInfoUpdated", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "onGuildListUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f() {
            QQToastUtil.showQQToast(1, "\u4f60\u5df2\u88ab\u79fb\u51fa\u9891\u9053");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g() {
            QQToastUtil.showQQToast(1, "\u5f53\u524d\u9891\u9053\u5df2\u88ab\u5220\u9664");
        }

        private final void h(String guildId) {
            if (Intrinsics.areEqual(guildId, GuildCoverViewModel.this.guildId)) {
                GuildCoverViewModel.this._guildInfo.setValue(ch.L(guildId));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            if (Intrinsics.areEqual(guildId, GuildCoverViewModel.this.guildId) && GuildCoverViewModel.this.facadeType.isStandaloneStyle()) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.rightlist.cover.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildCoverViewModel.b.f();
                    }
                }, 200L);
            }
            h(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@Nullable String guildId) {
            if (Intrinsics.areEqual(guildId, GuildCoverViewModel.this.guildId) && GuildCoverViewModel.this.facadeType.isStandaloneStyle()) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.rightlist.cover.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildCoverViewModel.b.g();
                    }
                }, 200L);
            }
            h(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            h(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            GuildHomeCoverBelowList guildHomeCoverBelowList;
            if (Intrinsics.areEqual(guildId, GuildCoverViewModel.this.guildId)) {
                GuildCoverViewModel.this._guildInfo.setValue(ch.L(guildId));
                WeakReference weakReference = GuildCoverViewModel.this.bannerViewRef;
                if (weakReference != null && (guildHomeCoverBelowList = (GuildHomeCoverBelowList) weakReference.get()) != null) {
                    GuildCoverViewModel.this.a2(guildHomeCoverBelowList);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildListUpdated() {
            boolean isBlank;
            isBlank = StringsKt__StringsJVMKt.isBlank(GuildCoverViewModel.this.guildId);
            if (!isBlank) {
                GuildCoverViewModel.this._guildInfo.setValue(ch.L(GuildCoverViewModel.this.guildId));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            h(guildId);
        }
    }

    public GuildCoverViewModel(@NotNull GuildFacadeType facadeType) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(facadeType, "facadeType");
        this.facadeType = facadeType;
        this._coverUrl = new e<>();
        this._guildInfo = new e12.a<>();
        this.guildId = "";
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        this.gProService = (IGProGlobalService) S0;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.rightlist.cover.GuildCoverViewModel$gProObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver T1;
                T1 = GuildCoverViewModel.this.T1();
                return T1;
            }
        });
        this.gProObserver = lazy;
        this.gProService.addObserver(W1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver T1() {
        return new b();
    }

    private final GPServiceObserver W1() {
        return (GPServiceObserver) this.gProObserver.getValue();
    }

    private final com.tencent.mobileqq.qcoroutine.api.coroutine.b Z1(String guildId) {
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Guild.MF.Rt.GuildCoverViewModel realActiveGuild", null, null, null, new GuildCoverViewModel$realActiveGuild$1(this, guildId, null), 14, null);
    }

    public final void S1(@NotNull String guildId) {
        Job a16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.activeGuildQJob;
        if (bVar != null && (a16 = bVar.a()) != null) {
            Job.DefaultImpls.cancel$default(a16, (CancellationException) null, 1, (Object) null);
        }
        this.guildId = guildId;
        this.activeGuildQJob = Z1(guildId);
    }

    @NotNull
    public final LiveData<String> U1() {
        return this._coverUrl;
    }

    @NotNull
    public final LiveData<IGProGuildInfo> X1() {
        return this._guildInfo;
    }

    public final void a2(@NotNull GuildHomeCoverBelowList banner) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(banner, "banner");
        this.bannerViewRef = new WeakReference<>(banner);
        isBlank = StringsKt__StringsJVMKt.isBlank(this.guildId);
        if (isBlank) {
            this._coverUrl.setValue("");
            return;
        }
        IGProGuildInfo L = ch.L(this.guildId);
        if (L == null) {
            this._coverUrl.setValue("");
        } else {
            int f16 = banner.f();
            this._coverUrl.setValue(L.getCoverUrl(f16, (int) (f16 * 0.46629214f)));
        }
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        this.gProService.deleteObserver(W1());
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProGlobalService iGProGlobalService = (IGProGlobalService) S0;
        this.gProService = iGProGlobalService;
        iGProGlobalService.addObserver(W1());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.gProService.deleteObserver(W1());
    }
}
