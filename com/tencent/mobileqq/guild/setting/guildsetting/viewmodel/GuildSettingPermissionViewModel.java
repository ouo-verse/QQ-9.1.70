package com.tencent.mobileqq.guild.setting.guildsetting.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.rolegroup.model.data.Permissions;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashSet;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 32\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0'8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0'8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010)R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0'8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010)R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0'8F\u00a2\u0006\u0006\u001a\u0004\b/\u0010)\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingPermissionViewModel;", "Lef1/b;", "", "guildId", "", "X1", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Q1", "account", "onAccountChanged", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "Le12/a;", "", "D", "Le12/a;", "_isShowGuildManage", "E", "_isShowDataBoard", UserInfo.SEX_FEMALE, "_isCanModifyGuildInfo", "G", "_canRemoveMember", "Landroidx/lifecycle/MutableLiveData;", "H", "Landroidx/lifecycle/MutableLiveData;", "getNoticeAuthorityEnd", "()Landroidx/lifecycle/MutableLiveData;", "noticeAuthorityEnd", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "I", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "J", "Lkotlin/Lazy;", "S1", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "Landroidx/lifecycle/LiveData;", "W1", "()Landroidx/lifecycle/LiveData;", "isShowGuildManage", "U1", "isShowDataBoard", "T1", "isCanModifyGuildInfo", "R1", "canRemoveMember", "<init>", "(Ljava/lang/String;)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSettingPermissionViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _isShowGuildManage;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _isShowDataBoard;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _isCanModifyGuildInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _canRemoveMember;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> noticeAuthorityEnd;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy gProObserver;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingPermissionViewModel$1", f = "GuildSettingPermissionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingPermissionViewModel$1, reason: invalid class name */
    /* loaded from: classes14.dex */
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
                GuildSettingPermissionViewModel guildSettingPermissionViewModel = GuildSettingPermissionViewModel.this;
                guildSettingPermissionViewModel.X1(guildSettingPermissionViewModel.guildId);
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

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J,\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\tH\u0014J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingPermissionViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "mGuildId", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "onGuildPermissionChanged", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "channelIds", "onChannelPermissionChanged", "admint", "", "bAdmin", "onAdminChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(@NotNull String mGuildId, @NotNull String admint, boolean bAdmin) {
            Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
            Intrinsics.checkNotNullParameter(admint, "admint");
            super.onAdminChanged(mGuildId, admint, bAdmin);
            QLog.i("GuildSettingPermissionViewModel", 1, "onAdminChanged:" + mGuildId);
            if (TextUtils.equals(mGuildId, GuildSettingPermissionViewModel.this.guildId)) {
                GuildSettingPermissionViewModel.this.X1(mGuildId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(@NotNull String mGuildId, @Nullable HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
            super.onChannelPermissionChanged(mGuildId, channelIds);
            QLog.i("GuildSettingPermissionViewModel", 1, "onChannelPermissionChanged:" + mGuildId);
            if (!TextUtils.equals(mGuildId, GuildSettingPermissionViewModel.this.guildId)) {
                return;
            }
            GuildSettingPermissionViewModel guildSettingPermissionViewModel = GuildSettingPermissionViewModel.this;
            guildSettingPermissionViewModel.X1(guildSettingPermissionViewModel.guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(@NotNull String mGuildId, @Nullable dx permission) {
            Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
            super.onGuildPermissionChanged(mGuildId, permission);
            QLog.i("GuildSettingPermissionViewModel", 1, "onGuildPermissionChanged:" + mGuildId);
            if (TextUtils.equals(mGuildId, GuildSettingPermissionViewModel.this.guildId)) {
                GuildSettingPermissionViewModel.this.X1(mGuildId);
            }
        }
    }

    public GuildSettingPermissionViewModel(@NotNull String guildId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this._isShowGuildManage = new e12.a<>();
        this._isShowDataBoard = new e12.a<>();
        this._isCanModifyGuildInfo = new e12.a<>();
        this._canRemoveMember = new e12.a<>();
        this.noticeAuthorityEnd = new MutableLiveData<>();
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.gProService = (IGPSService) R0;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingPermissionViewModel$gProObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver Q1;
                Q1 = GuildSettingPermissionViewModel.this.Q1();
                return Q1;
            }
        });
        this.gProObserver = lazy;
        this.gProService.addObserver(S1());
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "GuildSettingPermissionViewModel init", null, null, null, new AnonymousClass1(null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver Q1() {
        return new b();
    }

    private final GPServiceObserver S1() {
        return (GPServiceObserver) this.gProObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(String guildId) {
        boolean z16;
        boolean z17;
        boolean z18;
        Permissions guildPermission = r.p().getGuildPermission(guildId);
        boolean n06 = ch.n0(guildId);
        boolean m06 = ch.m0(guildId);
        boolean a16 = guildPermission.a(10003);
        boolean a17 = guildPermission.a(100002);
        boolean a18 = guildPermission.a(90001);
        boolean a19 = guildPermission.a(60001);
        boolean a26 = guildPermission.a(100001);
        boolean z19 = false;
        if (!guildPermission.a(70002) && !guildPermission.i()) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean a27 = guildPermission.a(80002);
        if (ch.o0() && !TextUtils.isEmpty(ch.T())) {
            z17 = false;
        } else {
            z17 = true;
        }
        this._isCanModifyGuildInfo.setValue(Boolean.valueOf(guildPermission.a(10001)));
        boolean a28 = guildPermission.a(50001);
        e12.a<Boolean> aVar = this._isShowDataBoard;
        if (((!n06 && !m06) || z17) && a28) {
            z18 = true;
        } else {
            z18 = false;
        }
        aVar.setValue(Boolean.valueOf(z18));
        boolean a29 = guildPermission.a(30002);
        e12.a<Boolean> aVar2 = this._isShowGuildManage;
        if (z16 || a19 || a27 || a16 || a18 || a17 || a29) {
            z19 = true;
        }
        aVar2.setValue(Boolean.valueOf(z19));
        this._canRemoveMember.setValue(Boolean.valueOf(a26));
        this.noticeAuthorityEnd.setValue(Boolean.TRUE);
    }

    @NotNull
    public final LiveData<Boolean> R1() {
        return this._canRemoveMember;
    }

    @NotNull
    public final LiveData<Boolean> T1() {
        return this._isCanModifyGuildInfo;
    }

    @NotNull
    public final LiveData<Boolean> U1() {
        return this._isShowDataBoard;
    }

    @NotNull
    public final LiveData<Boolean> W1() {
        return this._isShowGuildManage;
    }

    @NotNull
    public final MutableLiveData<Boolean> getNoticeAuthorityEnd() {
        return this.noticeAuthorityEnd;
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        QLog.i("GuildSettingPermissionViewModel", 1, "onAccountChanged");
        this.gProService.deleteObserver(S1());
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.gProService = iGPSService;
        iGPSService.addObserver(S1());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        QLog.i("GuildSettingPermissionViewModel", 1, "onCleared");
        this.gProService.deleteObserver(S1());
    }
}
