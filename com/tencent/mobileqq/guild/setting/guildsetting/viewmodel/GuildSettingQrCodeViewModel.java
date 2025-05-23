package com.tencent.mobileqq.guild.setting.guildsetting.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.share.GuildShareWrapper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.ey;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import ef1.c;
import java.io.File;
import java.util.ArrayList;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.at;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 D2\u00020\u0001:\u0001EB\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0014R\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010!R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010!R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u001aR\u001b\u00101\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0019\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f068F\u00a2\u0006\u0006\u001a\u0004\b7\u00108R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0006068F\u00a2\u0006\u0006\u001a\u0004\b:\u00108R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0006068F\u00a2\u0006\u0006\u001a\u0004\b<\u00108R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u0013068F\u00a2\u0006\u0006\u001a\u0004\b>\u00108R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020\u0006068F\u00a2\u0006\u0006\u001a\u0004\b@\u00108\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingQrCodeViewModel;", "Lef1/b;", "", "fetchShareInfo", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "S1", "", "qrCodeType", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/ey;", "Lkotlin/collections/ArrayList;", "getUrlParams", "Landroid/content/Context;", "context", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lyz1/p;", "shareHelper", "d2", "", "isDownload", "c2", "account", "onAccountChanged", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Le12/a;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "D", "Le12/a;", "_guildInfo", "E", "_guildQrCodeUrl", UserInfo.SEX_FEMALE, "_qrCodeShareInfo", "G", "_download", "H", "_attaContentId", "I", "mQrCodeType", "J", "Lkotlin/Lazy;", "X1", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "K", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "guildInfo", ICustomDataEditor.STRING_ARRAY_PARAM_2, "guildQrCodeUrl", "b2", "qrCodeShareInfo", "W1", "downloadBitmap", "U1", "attaContentId", "<init>", "(Ljava/lang/String;)V", "L", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSettingQrCodeViewModel extends ef1.b {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e12.a<IGProGuildInfo> _guildInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final e12.a<String> _guildQrCodeUrl;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final e12.a<String> _qrCodeShareInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _download;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final e12.a<String> _attaContentId;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String mQrCodeType;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy gProObserver;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingQrCodeViewModel$1", f = "GuildSettingQrCodeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingQrCodeViewModel$1, reason: invalid class name */
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
                GuildSettingQrCodeViewModel.this._guildInfo.setValue(ch.L(GuildSettingQrCodeViewModel.this.getGuildId()));
                GuildSettingQrCodeViewModel.this.fetchShareInfo();
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingQrCodeViewModel$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "", "guildId", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingQrCodeViewModel;", "a", "MAIN_SOURCE_KEY", "Ljava/lang/String;", "MAIN_SOURCE_VALUE", "SUB_SOURCE_KEY", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingQrCodeViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingQrCodeViewModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7901a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f234521a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f234522b;

            public C7901a(ViewModelStoreOwner viewModelStoreOwner, String str) {
                this.f234521a = viewModelStoreOwner;
                this.f234522b = str;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new GuildSettingQrCodeViewModel(this.f234522b), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
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
        public final GuildSettingQrCodeViewModel a(@NotNull ViewModelStoreOwner owner, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C7901a(owner, guildId)).get(GuildSettingQrCodeViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (GuildSettingQrCodeViewModel) viewModel;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingQrCodeViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "mGuildId", "", "onGuildInfoUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String mGuildId) {
            if (Intrinsics.areEqual(mGuildId, GuildSettingQrCodeViewModel.this.getGuildId())) {
                GuildSettingQrCodeViewModel.this._guildInfo.setValue(ch.L(mGuildId));
            }
        }
    }

    public GuildSettingQrCodeViewModel(@NotNull String guildId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this._guildInfo = new e12.a<>();
        this._guildQrCodeUrl = new e12.a<>();
        this._qrCodeShareInfo = new e12.a<>();
        this._download = new e12.a<>();
        this._attaContentId = new e12.a<>();
        this.mQrCodeType = "pic4";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingQrCodeViewModel$gProObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver S1;
                S1 = GuildSettingQrCodeViewModel.this.S1();
                return S1;
            }
        });
        this.gProObserver = lazy;
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.gProService = iGPSService;
        iGPSService.addObserver(X1());
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "GuildSettingQrCodeViewModel init", null, null, null, new AnonymousClass1(null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver S1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(GuildSettingQrCodeViewModel this$0, int i3, String errMsg, String shareUrl, String shareInfo, IGProSecurityResult security, long j3, IGProQRCodeShareInfo iGProQRCodeShareInfo, IGProShareExtendInfo shareExtendInfo, String attaContentId) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        Intrinsics.checkNotNullParameter(security, "security");
        Intrinsics.checkNotNullParameter(shareExtendInfo, "shareExtendInfo");
        Intrinsics.checkNotNullParameter(attaContentId, "attaContentId");
        String str3 = "fetchShareInfo result: " + i3 + ", errMsg: " + errMsg + ", shareUrl: " + shareUrl + ", shareInfo: " + shareInfo + "security:" + security + ", shareExpiredTime: " + j3 + "qrCodeShareInfo:" + iGProQRCodeShareInfo + ", shareExtendInfo: " + shareExtendInfo + ", attaContentId " + attaContentId;
        boolean z16 = true;
        if (i3 == 0 && !TextUtils.isEmpty(shareUrl) && iGProQRCodeShareInfo != null) {
            if (QLog.isColorLevel()) {
                QLog.i("GuildSettingQrCodeViewModel", 2, str3);
            }
            boolean k3 = com.tencent.mobileqq.guild.share.shorturl.a.k(shareUrl);
            String a16 = com.tencent.mobileqq.guild.share.util.c.a(shareUrl, "5");
            e12.a<String> aVar = this$0._guildQrCodeUrl;
            if (k3) {
                str = a16;
            } else {
                str = shareUrl;
            }
            aVar.setValue(str);
            e12.a<String> aVar2 = this$0._qrCodeShareInfo;
            if (shareInfo.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                str2 = StringsKt__StringsJVMKt.replace$default(shareInfo, shareUrl, a16, false, 4, (Object) null);
            } else {
                str2 = shareInfo;
            }
            aVar2.setValue(str2);
            this$0._attaContentId.setValue(attaContentId);
            return;
        }
        QLog.e("GuildSettingQrCodeViewModel", 1, str3);
        if (!TextUtils.isEmpty(errMsg)) {
            aa.b(errMsg);
        }
    }

    private final GPServiceObserver X1() {
        return (GPServiceObserver) this.gProObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(yz1.p shareHelper, Bitmap bitmap, Context context) {
        Intrinsics.checkNotNullParameter(shareHelper, "$shareHelper");
        Intrinsics.checkNotNullParameter(context, "$context");
        File n3 = shareHelper.n(false);
        if (bitmap != null && !bitmap.isRecycled()) {
            if (!com.tencent.mobileqq.guild.util.p.d(n3, bitmap)) {
                QQToastUtil.showQQToastInUiThread(1, "\u4fdd\u5b58\u56fe\u7247\u5931\u8d25");
                QLog.e("GuildSettingQrCodeViewModel", 1, "saveFileToLocal writeBitmapToFile error");
                return;
            } else {
                ((IFileDepend) QRoute.api(IFileDepend.class)).saveToAlbum(context, n3.getAbsolutePath());
                return;
            }
        }
        QQToastUtil.showQQToastInUiThread(1, "\u4fdd\u5b58\u56fe\u7247\u5931\u8d25");
        QLog.e("GuildSettingQrCodeViewModel", 1, "saveFileToLocal bitmap get error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchShareInfo() {
        if (TextUtils.isEmpty(this.guildId)) {
            QLog.w("GuildSettingQrCodeViewModel", 1, "guildId is null");
        } else {
            GuildShareWrapper.g(this.guildId, "", 5, null, getUrlParams(this.mQrCodeType), new at() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.m
                @Override // vh2.at
                public final void a(int i3, String str, String str2, String str3, IGProSecurityResult iGProSecurityResult, long j3, IGProQRCodeShareInfo iGProQRCodeShareInfo, IGProShareExtendInfo iGProShareExtendInfo, String str4) {
                    GuildSettingQrCodeViewModel.T1(GuildSettingQrCodeViewModel.this, i3, str, str2, str3, iGProSecurityResult, j3, iGProQRCodeShareInfo, iGProShareExtendInfo, str4);
                }
            });
        }
    }

    private final ArrayList<ey> getUrlParams(String qrCodeType) {
        ArrayList<ey> arrayList = new ArrayList<>();
        ey eyVar = new ey();
        eyVar.c("mainSourceId");
        eyVar.d(QCircleDaTongConstant.ElementParamValue.QRCODE);
        ey eyVar2 = new ey();
        eyVar2.c("subSourceId");
        eyVar2.d(qrCodeType);
        ey eyVar3 = new ey();
        eyVar3.c("from");
        eyVar3.d("246611");
        arrayList.add(eyVar);
        arrayList.add(eyVar2);
        arrayList.add(eyVar3);
        return arrayList;
    }

    @NotNull
    public final LiveData<String> U1() {
        return this._attaContentId;
    }

    @NotNull
    public final LiveData<Boolean> W1() {
        return this._download;
    }

    @NotNull
    public final LiveData<IGProGuildInfo> Z1() {
        return this._guildInfo;
    }

    @NotNull
    public final LiveData<String> a2() {
        return this._guildQrCodeUrl;
    }

    @NotNull
    public final LiveData<String> b2() {
        return this._qrCodeShareInfo;
    }

    public final void c2(boolean isDownload) {
        this._download.setValue(Boolean.valueOf(isDownload));
    }

    public final void d2(@NotNull final Context context, @Nullable final Bitmap bitmap, @NotNull final yz1.p shareHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shareHelper, "shareHelper");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.n
            @Override // java.lang.Runnable
            public final void run() {
                GuildSettingQrCodeViewModel.e2(yz1.p.this, bitmap, context);
            }
        }, 64, null, true);
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        this.gProService.deleteObserver(X1());
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.gProService = iGPSService;
        iGPSService.addObserver(X1());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.gProService.deleteObserver(X1());
    }
}
