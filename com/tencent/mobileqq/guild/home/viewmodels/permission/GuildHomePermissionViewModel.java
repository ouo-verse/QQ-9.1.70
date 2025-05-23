package com.tencent.mobileqq.guild.home.viewmodels.permission;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.guild.rolegroup.model.data.Permissions;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoAndMemberListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cj;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.C11736d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ap;
import yz1.q;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 72\u00020\u0001:\u000289B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JB\u0010\r\u001a\u00020\f28\u0010\u000b\u001a4\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u0006j\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\bj\b\u0012\u0004\u0012\u00020\u0007`\n`\tH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\f0-8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\f0-8F\u00a2\u0006\u0006\u001a\u0004\b1\u0010/R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100-8F\u00a2\u0006\u0006\u001a\u0004\b3\u0010/\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", "Lef1/b;", "", "guildId", "", "f2", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "channelIdMap", "", "e2", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "W1", "", WidgetCacheConstellationData.NUM, "X1", "g2", "account", "onAccountChanged", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "Le12/a;", "D", "Le12/a;", "_showFeed", "E", "_showCategoryChannel", UserInfo.SEX_FEMALE, "_totalMemberCnt", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "G", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "H", "Lkotlin/Lazy;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "I", "Z", "needAddObserver", "Landroidx/lifecycle/LiveData;", "c2", "()Landroidx/lifecycle/LiveData;", "showFeed", "b2", "showCategoryChannel", "d2", "totalMemberCnt", "<init>", "(Ljava/lang/String;)V", "J", "a", "InitRunnable", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomePermissionViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _showFeed;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _showCategoryChannel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Integer> _totalMemberCnt;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy gProObserver;

    /* renamed from: I, reason: from kotlin metadata */
    private volatile boolean needAddObserver;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.home.viewmodels.permission.GuildHomePermissionViewModel$1", f = "GuildHomePermissionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.home.viewmodels.permission.GuildHomePermissionViewModel$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                IGProGuildInfo L = ch.L(GuildHomePermissionViewModel.this.guildId);
                boolean z16 = false;
                if (L != null && L.isMember()) {
                    z16 = true;
                }
                if (z16) {
                    q qVar = q.f451648a;
                    GuildHomePermissionViewModel.this.X1(qVar.a(qVar.b(bi.d())));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel$InitRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "viewModelRef", "viewModel", "<init>", "(Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class InitRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<GuildHomePermissionViewModel> viewModelRef;

        public InitRunnable(@NotNull GuildHomePermissionViewModel viewModel) {
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            this.viewModelRef = new WeakReference<>(viewModel);
        }

        @Override // java.lang.Runnable
        public void run() {
            GuildHomePermissionViewModel guildHomePermissionViewModel = this.viewModelRef.get();
            if (guildHomePermissionViewModel != null) {
                QLog.iAsync("Guild.NewHome.GuildHomePermissionViewModel", 1, "InitRunnable, needAddObserver:" + guildHomePermissionViewModel.needAddObserver);
                if (guildHomePermissionViewModel.needAddObserver) {
                    guildHomePermissionViewModel.gProService.addObserver(guildHomePermissionViewModel.a2());
                    guildHomePermissionViewModel.f2(guildHomePermissionViewModel.guildId);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J,\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\tH\u0014J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "onGuildPermissionChanged", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "channelIds", "onChannelPermissionChanged", "admint", "", "bAdmin", "onAdminChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
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
            QLog.iAsync("Guild.NewHome.GuildHomePermissionViewModel", 1, "onAdminChanged:" + guildId);
            if (TextUtils.equals(guildId, GuildHomePermissionViewModel.this.guildId)) {
                GuildHomePermissionViewModel.this.f2(guildId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(@NotNull String guildId, @Nullable HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            super.onChannelPermissionChanged(guildId, channelIds);
            QLog.iAsync("Guild.NewHome.GuildHomePermissionViewModel", 1, "onChannelPermissionChanged:" + guildId);
            if (TextUtils.equals(guildId, GuildHomePermissionViewModel.this.guildId)) {
                GuildHomePermissionViewModel.this.f2(guildId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(@NotNull String guildId, @Nullable dx permission) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            super.onGuildPermissionChanged(guildId, permission);
            QLog.iAsync("Guild.NewHome.GuildHomePermissionViewModel", 1, "onGuildPermissionChanged:" + guildId);
            if (TextUtils.equals(guildId, GuildHomePermissionViewModel.this.guildId)) {
                GuildHomePermissionViewModel.this.f2(guildId);
            }
        }
    }

    public GuildHomePermissionViewModel(@NotNull String guildId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this._showFeed = new e12.a<>();
        this._showCategoryChannel = new e12.a<>();
        this._totalMemberCnt = new e12.a<>();
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.gProService = (IGPSService) R0;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.permission.GuildHomePermissionViewModel$gProObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver W1;
                W1 = GuildHomePermissionViewModel.this.W1();
                return W1;
            }
        });
        this.gProObserver = lazy;
        this.needAddObserver = true;
        C11736d.b(150, new InitRunnable(this));
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Guild.NewHome.GuildHomePermissionViewModel init", null, null, null, new AnonymousClass1(null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver W1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(int num) {
        cj cjVar = new cj();
        cjVar.g(Long.parseLong(this.guildId));
        cjVar.f(num * 3);
        ((IGPSService) ch.R0(IGPSService.class)).fetchGuildInfoAndMemberList(cjVar, new ap() { // from class: com.tencent.mobileqq.guild.home.viewmodels.permission.a
            @Override // wh2.ap
            public final void a(int i3, String str, IGProGuildInfoAndMemberListRsp iGProGuildInfoAndMemberListRsp) {
                GuildHomePermissionViewModel.Z1(GuildHomePermissionViewModel.this, i3, str, iGProGuildInfoAndMemberListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(GuildHomePermissionViewModel this$0, int i3, String str, IGProGuildInfoAndMemberListRsp iGProGuildInfoAndMemberListRsp) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            ArrayList<IGProUserInfo> memberList = iGProGuildInfoAndMemberListRsp.getMemberList();
            if (memberList != null && !memberList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                this$0._totalMemberCnt.setValue(Integer.valueOf(iGProGuildInfoAndMemberListRsp.getGuildInfo().getUserNum()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver a2() {
        return (GPServiceObserver) this.gProObserver.getValue();
    }

    private final boolean e2(HashMap<Long, ArrayList<Long>> channelIdMap) {
        for (Map.Entry<Long, ArrayList<Long>> entry : channelIdMap.entrySet()) {
            long longValue = entry.getKey().longValue();
            Iterator<Long> it = entry.getValue().iterator();
            while (it.hasNext()) {
                if (r.p().getChannelPermission(String.valueOf(longValue), String.valueOf(it.next().longValue())).d()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(String guildId) {
        boolean z16;
        boolean z17;
        boolean z18;
        Permissions guildPermission = r.p().getGuildPermission(guildId);
        boolean n06 = ch.n0(guildId);
        boolean m06 = ch.m0(guildId);
        boolean h16 = guildPermission.h();
        boolean j3 = guildPermission.j();
        boolean z19 = false;
        if (!n06 && !m06 && !h16) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!n06 && !m06 && !j3) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z16) {
            this._showFeed.setValue(Boolean.valueOf(z16));
            QLog.iAsync("Guild.NewHome.GuildHomePermissionViewModel", 1, "isCreator " + n06 + "  isCreatorOrAdmin " + m06 + "  isCustomAdmin " + h16);
        } else {
            HashMap<Long, ArrayList<Long>> channelPermission = this.gProService.getChannelPermission(guildId, 7);
            if (channelPermission != null) {
                z18 = e2(channelPermission);
            } else {
                QLog.iAsync("Guild.NewHome.GuildHomePermissionViewModel", 1, "getChannelPermission is null");
                z18 = false;
            }
            this._showFeed.setValue(Boolean.valueOf(z18));
            QLog.i("Guild.NewHome.GuildHomePermissionViewModel", 1, "isManageBoard " + z18 + " isActiveManage " + z17);
        }
        this._showCategoryChannel.setValue(Boolean.valueOf(m06));
        if (n06 || m06 || h16) {
            z19 = true;
        }
        QLog.iAsync("Guild.NewHome.GuildHomePermissionViewModel", 1, "isChannelManage " + z16 + "  isAdminManage " + z19);
    }

    @NotNull
    public final LiveData<Boolean> b2() {
        return this._showCategoryChannel;
    }

    @NotNull
    public final LiveData<Boolean> c2() {
        return this._showFeed;
    }

    @NotNull
    public final LiveData<Integer> d2() {
        return this._totalMemberCnt;
    }

    public final void g2(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        f2(guildId);
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        QLog.iAsync("Guild.NewHome.GuildHomePermissionViewModel", 1, "onAccountChanged " + account);
        this.needAddObserver = false;
        this.gProService.deleteObserver(a2());
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.gProService = iGPSService;
        iGPSService.addObserver(a2());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.needAddObserver = false;
        this.gProService.deleteObserver(a2());
    }
}
