package com.tencent.mobileqq.guild.home.viewmodels.header;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildCheckinViewModel;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cg;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.NumberUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.v;
import wh2.dg;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\f\u0018\u0000 C2\u00020\u0001:\u0001DB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u000f\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0014R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010*\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010\u000eR\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020+0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002030/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00101R\u0014\u00108\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00107R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001b098F\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020+098F\u00a2\u0006\u0006\u001a\u0004\b=\u0010;R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u000203098F\u00a2\u0006\u0006\u001a\u0004\b?\u0010;\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildCheckinViewModel;", "Lef1/b;", "", "l2", "p2", "j2", "o2", "X1", "", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Z1", "com/tencent/mobileqq/guild/home/viewmodels/header/GuildCheckinViewModel$c", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildCheckinViewModel$c;", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "q2", "i2", "b2", "", "account", "onAccountChanged", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/a;", "D", "Landroidx/lifecycle/MutableLiveData;", "_checkinEntryInfo", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "E", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "g2", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "G", SemanticAttributes.DbSystemValues.H2, "guildObserver", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildCheckinRsp;", "H", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildCheckinRsp;", "guildCheckInfo", "Lcom/tencent/mobileqq/guild/util/cn;", "I", "Lcom/tencent/mobileqq/guild/util/cn;", "_checkinRsp", "Lcf1/b;", "J", "_toastEvent", "d2", "()Ljava/lang/String;", "activeGuildId", "Landroidx/lifecycle/LiveData;", "e2", "()Landroidx/lifecycle/LiveData;", "checkinEntryInfo", "f2", "checkinRsp", "getToastEvent", "toastEvent", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildCheckinViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private FacadeArgsData facadeArgsData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<CheckinEntryInfo> _checkinEntryInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy gProObserver;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildObserver;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private IGProGuildCheckinRsp guildCheckInfo;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final cn<IGProGuildCheckinRsp> _checkinRsp;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final cn<cf1.b> _toastEvent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/home/viewmodels/header/GuildCheckinViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "b", "onGuildInfoUpdated", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        private final void b(String guildId) {
            if (Intrinsics.areEqual(guildId, GuildCheckinViewModel.this.d2())) {
                GuildCheckinViewModel.this.o2();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@Nullable String guildId) {
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            if (Intrinsics.areEqual(guildId, GuildCheckinViewModel.this.d2())) {
                GuildCheckinViewModel.this.o2();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            b(guildId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/viewmodels/header/GuildCheckinViewModel$c", "Loo1/a;", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildCheckinRsp;", "rsp", "", "g", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends oo1.a {
        c() {
        }

        @Override // oo1.a
        public void g(@NotNull String guildId, @NotNull IGProGuildCheckinRsp rsp) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            if (Intrinsics.areEqual(guildId, GuildCheckinViewModel.this.d2())) {
                GuildCheckinViewModel.this.guildCheckInfo = rsp;
                GuildCheckinViewModel.this.X1();
            }
        }
    }

    public GuildCheckinViewModel(@NotNull FacadeArgsData facadeArgsData) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
        this._checkinEntryInfo = new MutableLiveData<>();
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.gProService = (IGPSService) R0;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.GuildCheckinViewModel$gProObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver Z1;
                Z1 = GuildCheckinViewModel.this.Z1();
                return Z1;
            }
        });
        this.gProObserver = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.GuildCheckinViewModel$guildObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildCheckinViewModel.c invoke() {
                GuildCheckinViewModel.c a26;
                a26 = GuildCheckinViewModel.this.a2();
                return a26;
            }
        });
        this.guildObserver = lazy2;
        this._checkinRsp = new cn<>();
        this._toastEvent = new cn<>();
        this.gProService.addObserver(g2());
        M1().addObserver(h2());
        p2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1() {
        boolean z16;
        if (!n2()) {
            this._checkinEntryInfo.setValue(new CheckinEntryInfo(false, false, 0, 6, null));
            return;
        }
        IGProGuildCheckinRsp iGProGuildCheckinRsp = this.guildCheckInfo;
        if (iGProGuildCheckinRsp == null) {
            Logger.f235387a.d().e("Guild.NewHome.GuildCheckinViewModel", 1, "afterLoadCheckinInfo: guildCheckInfo is null");
            this._checkinEntryInfo.setValue(new CheckinEntryInfo(false, false, 0, 6, null));
            return;
        }
        MutableLiveData<CheckinEntryInfo> mutableLiveData = this._checkinEntryInfo;
        int i3 = 0;
        if (iGProGuildCheckinRsp != null && iGProGuildCheckinRsp.getCheckinStatus() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        IGProGuildCheckinRsp iGProGuildCheckinRsp2 = this.guildCheckInfo;
        if (iGProGuildCheckinRsp2 != null) {
            i3 = iGProGuildCheckinRsp2.getCheckinCnt();
        }
        mutableLiveData.setValue(new CheckinEntryInfo(true, z16, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver Z1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c a2() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(GuildCheckinViewModel this$0, int i3, String str, IGProGuildCheckinRsp iGProGuildCheckinRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("Guild.NewHome.GuildCheckinViewModel", 1, "doGuildCheckin: " + i3 + " - " + str + " - " + iGProGuildCheckinRsp);
        if (i3 != 0) {
            if (i3 == 862002) {
                this$0.j2();
            }
            this$0._toastEvent.setValue(new cf1.b(i3, str));
            if (i3 == 862004) {
                this$0.l2();
                return;
            }
            return;
        }
        this$0._checkinRsp.setValue(iGProGuildCheckinRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d2() {
        String str = this.facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        return str;
    }

    private final GPServiceObserver g2() {
        return (GPServiceObserver) this.gProObserver.getValue();
    }

    private final c h2() {
        return (c) this.guildObserver.getValue();
    }

    private final void j2() {
        cg cgVar = new cg();
        cgVar.b(NumberUtil.stringToLong(d2()));
        this.gProService.getGuildCheckinInfo(cgVar, new dg() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.b
            @Override // wh2.dg
            public final void a(int i3, String str, IGProGuildCheckinRsp iGProGuildCheckinRsp) {
                GuildCheckinViewModel.k2(GuildCheckinViewModel.this, i3, str, iGProGuildCheckinRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(GuildCheckinViewModel this$0, int i3, String str, IGProGuildCheckinRsp iGProGuildCheckinRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().e("Guild.NewHome.GuildCheckinViewModel", 1, "loadCheckinInfo: " + i3 + " - " + str + " - " + iGProGuildCheckinRsp);
        if (i3 != 0) {
            return;
        }
        this$0.guildCheckInfo = iGProGuildCheckinRsp;
        this$0.X1();
    }

    private final void l2() {
        if (!ch.j0(d2())) {
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            ((IGPSService) S0).fetchGuildInfoWithSource(d2(), 106, new v() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.d
                @Override // vh2.v
                public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
                    GuildCheckinViewModel.m2(i3, str, iGProGuildInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(int i3, String str, IGProGuildInfo iGProGuildInfo) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.GuildCheckinViewModel", 2, "loadGuildInfoIfMember fetchGuildInfoWithSource end result:" + i3 + " errMsg:" + str);
        }
    }

    private final boolean n2() {
        boolean z16;
        boolean z17;
        boolean z18;
        IGProGuildInfo guildInfo = this.gProService.getGuildInfo(d2());
        if (guildInfo != null && guildInfo.isMember()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (guildInfo != null && guildInfo.getGuildSignInNotify() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        Logger.a d16 = Logger.f235387a.d();
        if (!z16 && z17) {
            z18 = true;
        } else {
            z18 = false;
        }
        d16.a("Guild.NewHome.GuildCheckinViewModel", 1, "needShowEntry(" + z18 + "): isGuest=" + z16 + ", switchOpen=" + z17);
        if (z16 || !z17) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o2() {
        if (!n2()) {
            this._checkinEntryInfo.setValue(new CheckinEntryInfo(false, false, 0, 6, null));
            return;
        }
        CheckinEntryInfo value = this._checkinEntryInfo.getValue();
        boolean z16 = false;
        if (value != null && !value.getNeedShowEntry()) {
            z16 = true;
        }
        if (z16) {
            j2();
        }
    }

    private final void p2() {
        if (n2()) {
            j2();
        } else {
            this._checkinEntryInfo.setValue(new CheckinEntryInfo(false, false, 0, 6, null));
        }
    }

    public final void b2() {
        ((QQGuildHandler) ch.j(QQGuildHandler.class)).O2(d2(), new dg() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.c
            @Override // wh2.dg
            public final void a(int i3, String str, IGProGuildCheckinRsp iGProGuildCheckinRsp) {
                GuildCheckinViewModel.c2(GuildCheckinViewModel.this, i3, str, iGProGuildCheckinRsp);
            }
        });
    }

    @NotNull
    public final LiveData<CheckinEntryInfo> e2() {
        return this._checkinEntryInfo;
    }

    @NotNull
    public final LiveData<IGProGuildCheckinRsp> f2() {
        return this._checkinRsp;
    }

    @NotNull
    public final LiveData<cf1.b> getToastEvent() {
        return this._toastEvent;
    }

    public final boolean i2() {
        CheckinEntryInfo value = this._checkinEntryInfo.getValue();
        if (value == null || !value.getIsChecked()) {
            return false;
        }
        return true;
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        M1().removeObserver(h2());
        super.onAccountChanged(account);
        M1().addObserver(h2());
        this.gProService.deleteObserver(g2());
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.gProService = iGPSService;
        iGPSService.addObserver(g2());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.gProService.deleteObserver(g2());
        M1().removeObserver(h2());
    }

    public final void q2(@NotNull FacadeArgsData facadeArgsData) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
        p2();
    }
}
