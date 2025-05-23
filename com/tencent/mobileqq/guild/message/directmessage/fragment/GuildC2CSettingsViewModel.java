package com.tencent.mobileqq.guild.message.directmessage.fragment;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ef1.c;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bz;
import vh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 I2\u00020\u0001:\u0001JB7\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010!\u001a\u00020\n\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0014R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010#R\u001b\u0010)\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u0010.\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\n0\n0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\n0/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u00106\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\n0\n0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010-R\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\n0/8\u0006\u00a2\u0006\f\n\u0004\b7\u00101\u001a\u0004\b8\u00103R\u001b\u0010>\u001a\u00020:8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010&\u001a\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/fragment/GuildC2CSettingsViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "b2", "", SemanticAttributes.DbSystemValues.H2, "", "o2", "e2", "c2", "", "isChecked", "k2", "isBlack", "q2", "account", "onAccountChanged", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "guildId", "D", "sourceGuildId", "E", "channelId", UserInfo.SEX_FEMALE, "targetTinyId", "", "G", "I", "directMsgType", "H", "Z", "isMsgNotDisturb", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "J", "Lkotlin/Lazy;", "g2", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "K", "Landroidx/lifecycle/MutableLiveData;", "_isMsgNotDisturbLiveData", "Landroidx/lifecycle/LiveData;", "L", "Landroidx/lifecycle/LiveData;", ICustomDataEditor.NUMBER_PARAM_2, "()Landroidx/lifecycle/LiveData;", "isMsgNotDisturbLiveData", "M", "_isDirectBlock", "N", "m2", "isDirectBlock", "Lcom/tencent/mobileqq/guild/robot/components/console/RobotInfo;", "P", "i2", "()Lcom/tencent/mobileqq/guild/robot/components/console/RobotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotInfoRsp;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotInfoRsp;", "j2", "()Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotInfoRsp;", "setRobotInfoRsp", "(Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotInfoRsp;)V", "robotInfoRsp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", BdhLogUtil.LogTag.Tag_Req, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildC2CSettingsViewModel extends ef1.b {

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String sourceGuildId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String targetTinyId;

    /* renamed from: G, reason: from kotlin metadata */
    private final int directMsgType;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isMsgNotDisturb;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy gProObserver;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isMsgNotDisturbLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> isMsgNotDisturbLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isDirectBlock;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> isDirectBlock;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy robotInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private GProGuildRobotInfoRsp robotInfoRsp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/fragment/GuildC2CSettingsViewModel$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "", "guildId", "sourceGuildId", "channelId", "targetTinyId", "", "directMsgType", "", "isMsgNotDisturb", "Lcom/tencent/mobileqq/guild/message/directmessage/fragment/GuildC2CSettingsViewModel;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.message.directmessage.fragment.GuildC2CSettingsViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.message.directmessage.fragment.GuildC2CSettingsViewModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7850a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f230391a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f230392b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f230393c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f230394d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f230395e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f230396f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ boolean f230397g;

            public C7850a(ViewModelStoreOwner viewModelStoreOwner, String str, String str2, String str3, String str4, int i3, boolean z16) {
                this.f230391a = viewModelStoreOwner;
                this.f230392b = str;
                this.f230393c = str2;
                this.f230394d = str3;
                this.f230395e = str4;
                this.f230396f = i3;
                this.f230397g = z16;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new GuildC2CSettingsViewModel(this.f230392b, this.f230393c, this.f230394d, this.f230395e, this.f230396f, this.f230397g), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
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

        @JvmStatic
        @NotNull
        public final GuildC2CSettingsViewModel a(@NotNull ViewModelStoreOwner owner, @NotNull String guildId, @NotNull String sourceGuildId, @NotNull String channelId, @NotNull String targetTinyId, int directMsgType, boolean isMsgNotDisturb) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(sourceGuildId, "sourceGuildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(targetTinyId, "targetTinyId");
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C7850a(owner, guildId, sourceGuildId, channelId, targetTinyId, directMsgType, isMsgNotDisturb)).get(GuildC2CSettingsViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (GuildC2CSettingsViewModel) viewModel;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J8\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/message/directmessage/fragment/GuildC2CSettingsViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "tinyId", "", "isBlack", "", "onDirectMsgBlackChanged", "", "result", "errMsg", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "info", "onUserProfileInfoUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDirectMsgBlackChanged(@Nullable String tinyId, boolean isBlack) {
            if (TextUtils.equals(GuildC2CSettingsViewModel.this.targetTinyId, tinyId)) {
                Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsViewModel", 1, "[onDirectMsgBlackChanged] isBlack:" + isBlack);
                GuildC2CSettingsViewModel.this._isDirectBlock.setValue(Boolean.valueOf(isBlack));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int result, @Nullable String errMsg, @Nullable String guildId, @Nullable String tinyId, @Nullable ev info) {
            if (result == 0 && TextUtils.equals(GuildC2CSettingsViewModel.this.targetTinyId, tinyId) && TextUtils.equals(GuildC2CSettingsViewModel.this.sourceGuildId, guildId) && info != null) {
                GuildC2CSettingsViewModel.this._isDirectBlock.setValue(Boolean.valueOf(info.n()));
                Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsViewModel", 1, "[onUserProfileInfoUpdate] isBlack:" + info.n());
            }
        }
    }

    public GuildC2CSettingsViewModel(@NotNull String guildId, @NotNull String sourceGuildId, @NotNull String channelId, @NotNull String targetTinyId, int i3, boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(sourceGuildId, "sourceGuildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(targetTinyId, "targetTinyId");
        this.guildId = guildId;
        this.sourceGuildId = sourceGuildId;
        this.channelId = channelId;
        this.targetTinyId = targetTinyId;
        this.directMsgType = i3;
        this.isMsgNotDisturb = z16;
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.gProService = (IGPSService) R0;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.GuildC2CSettingsViewModel$gProObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver b26;
                b26 = GuildC2CSettingsViewModel.this.b2();
                return b26;
            }
        });
        this.gProObserver = lazy;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.valueOf(this.isMsgNotDisturb));
        this._isMsgNotDisturbLiveData = mutableLiveData;
        this.isMsgNotDisturbLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(Boolean.FALSE);
        this._isDirectBlock = mutableLiveData2;
        this.isDirectBlock = mutableLiveData2;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RobotInfo>() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.GuildC2CSettingsViewModel$robotInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotInfo invoke() {
                String str;
                String str2;
                RobotInfo robotInfo = new RobotInfo();
                GuildC2CSettingsViewModel guildC2CSettingsViewModel = GuildC2CSettingsViewModel.this;
                str = guildC2CSettingsViewModel.guildId;
                robotInfo.p(MiscKt.l(str));
                str2 = guildC2CSettingsViewModel.channelId;
                robotInfo.n(MiscKt.l(str2));
                robotInfo.t(MiscKt.l(guildC2CSettingsViewModel.targetTinyId));
                robotInfo.u(0L);
                robotInfo.o(2);
                return robotInfo;
            }
        });
        this.robotInfo = lazy2;
        this.gProService.addObserver(g2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver b2() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(GuildC2CSettingsViewModel this$0, int i3, String str, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsViewModel", 1, "[fetchRobotDirectMsgBlack] result:" + i3 + ", errMsg:" + str + ", isBlack:" + z16);
        if (i3 == 0) {
            this$0._isDirectBlock.setValue(Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(GuildC2CSettingsViewModel this$0, int i3, String str, GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsViewModel", 1, "[fetchRobotInfo] result:" + i3 + ", errMsg:" + str + " ");
        if (i3 == 0 && gProGuildRobotInfoRsp != null) {
            this$0.robotInfoRsp = gProGuildRobotInfoRsp;
        }
    }

    private final GPServiceObserver g2() {
        return (GPServiceObserver) this.gProObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(GuildC2CSettingsViewModel this$0, boolean z16, int i3, int i16, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        logger.d().d("Guild.C2C.AIO.GuildC2CSettingsViewModel", 1, "[handleToggleNotifyTypeSwitch] isChecked:" + z16 + ", type:" + i3 + ", result=" + i16 + ", errMsg=" + str);
        if (i16 != 0) {
            this$0.isMsgNotDisturb = !z16;
            this$0._isMsgNotDisturbLiveData.setValue(Boolean.valueOf(!z16));
            logger.d().w("Guild.C2C.AIO.GuildC2CSettingsViewModel", 1, "[handleToggleNotifyTypeSwitch] set fail reset to isMsgNotDisturb:" + this$0.isMsgNotDisturb);
            SecurityTipHelperKt.F(ch.i(), i16, str, iGProSecurityResult, "", null, 32, null);
            return;
        }
        this$0.isMsgNotDisturb = z16;
        DirectMessageNodeRepository.f230483e.O(this$0.channelId, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(GuildC2CSettingsViewModel this$0, int i3, String str, ev evVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        logger.d().d("Guild.C2C.AIO.GuildC2CSettingsViewModel", 1, "[loadUserInfo] sourceGuildId:" + this$0.sourceGuildId + ", targetTinyId:" + this$0.targetTinyId + ", result:" + i3 + " errMsg:" + str);
        if (i3 != 0) {
            Logger.b bVar = new Logger.b();
            bVar.a().add("[loadUserInfo] loadGProUserProfileInfo error");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.AIO.GuildC2CSettingsViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        if (evVar != null) {
            logger.d().d("Guild.C2C.AIO.GuildC2CSettingsViewModel", 1, "[loadUserInfo] isDirectMsgBlack:" + evVar.n());
            this$0._isDirectBlock.setValue(Boolean.valueOf(evVar.n()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(GuildC2CSettingsViewModel this$0, boolean z16, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsViewModel", 1, "[setDirectMsgBlack] isBlack:" + z16 + " result:" + i3 + " errMsg:" + str);
        if (i3 != 0) {
            Logger.b bVar = new Logger.b();
            String str2 = "[setDirectMsgBlack] error, result:" + i3 + " errMsg:" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.AIO.GuildC2CSettingsViewModel", 1, (String) it.next(), null);
            }
            this$0._isDirectBlock.setValue(Boolean.valueOf(!z16));
            SecurityTipHelperKt.F(ch.i(), i3, str, iGProSecurityResult, "", null, 32, null);
        }
    }

    public final void c2() {
        this.gProService.fetchDirectMsgBlack(this.targetTinyId, new vh2.q() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.w
            @Override // vh2.q
            public final void onResult(int i3, String str, boolean z16) {
                GuildC2CSettingsViewModel.d2(GuildC2CSettingsViewModel.this, i3, str, z16);
            }
        });
    }

    public final void e2() {
        GuildChannel guildChannel = new GuildChannel();
        guildChannel.e(MiscKt.l(this.guildId));
        guildChannel.c(MiscKt.l(this.channelId));
        GProGuildRobotInfoReq b16 = sx1.f.b(guildChannel, i2(), 1);
        Intrinsics.checkNotNullExpressionValue(b16, "constructFetchGuildRobot\u2026Scene.MORE_INFO\n        )");
        Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsViewModel", 1, "[fetchRobotInfo] req:" + b16);
        ac g16 = sx1.f.g();
        if (g16 != null) {
            g16.fetchGuildRobotInfo(b16, new IGProFetchGuildRobotInfoCallback() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.y
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback
                public final void onFetchGuildRobotInfo(int i3, String str, GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
                    GuildC2CSettingsViewModel.f2(GuildC2CSettingsViewModel.this, i3, str, gProGuildRobotInfoRsp);
                }
            });
        }
    }

    @NotNull
    public final String h2() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        String guildUserDisplayName = ((IGPSService) S0).getGuildUserDisplayName(this.sourceGuildId, this.targetTinyId);
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "IGPSService::class.get()\u2026rceGuildId, targetTinyId)");
        return guildUserDisplayName;
    }

    @NotNull
    public final RobotInfo i2() {
        return (RobotInfo) this.robotInfo.getValue();
    }

    @Nullable
    /* renamed from: j2, reason: from getter */
    public final GProGuildRobotInfoRsp getRobotInfoRsp() {
        return this.robotInfoRsp;
    }

    public final void k2(final boolean isChecked) {
        final int i3;
        if (isChecked) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        this.gProService.setDirectMsgNotifyType(this.targetTinyId, i3, new cd() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.aa
            @Override // vh2.cd
            public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult) {
                GuildC2CSettingsViewModel.l2(GuildC2CSettingsViewModel.this, isChecked, i3, i16, str, iGProSecurityResult);
            }
        });
    }

    @NotNull
    public final LiveData<Boolean> m2() {
        return this.isDirectBlock;
    }

    @NotNull
    public final LiveData<Boolean> n2() {
        return this.isMsgNotDisturbLiveData;
    }

    public final void o2() {
        this.gProService.loadGProUserProfileInfo(this.sourceGuildId, this.targetTinyId, new bz() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.x
            @Override // vh2.bz
            public final void a(int i3, String str, ev evVar) {
                GuildC2CSettingsViewModel.p2(GuildC2CSettingsViewModel.this, i3, str, evVar);
            }
        });
        this.gProService.refreshGuildUserProfileInfo(this.sourceGuildId, this.targetTinyId);
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
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
    }

    public final void q2(final boolean isBlack) {
        this.gProService.setDirectMsgBlack(this.targetTinyId, isBlack, new cd() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.z
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                GuildC2CSettingsViewModel.r2(GuildC2CSettingsViewModel.this, isBlack, i3, str, iGProSecurityResult);
            }
        });
    }
}
