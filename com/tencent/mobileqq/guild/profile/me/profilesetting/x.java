package com.tencent.mobileqq.guild.profile.me.profilesetting;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetProfileSwitchRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalPrivacySwitchGroup;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ef1.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wh2.cu;
import wh2.de;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\f\u0010\r\u001a\u00020\u0005*\u00020\u0003H\u0002J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005J\b\u0010\u0017\u001a\u00020\tH\u0014R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR=\u0010'\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005 $*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010#0#0\u00078\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001bR\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u001bR\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010\u001bR\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00078\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u0019\u001a\u0004\b0\u0010\u001bR\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006\u00a2\u0006\f\n\u0004\b2\u0010\u0019\u001a\u0004\b3\u0010\u001bR\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006\u00a2\u0006\f\n\u0004\b5\u0010\u0019\u001a\u0004\b6\u0010\u001b\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/profilesetting/x;", "Lef1/b;", "Lwp1/a;", "", "switchType", "", "show", "Landroidx/lifecycle/MutableLiveData;", "liveData", "", ICustomDataEditor.NUMBER_PARAM_2, "T1", "W1", "i2", "q2", "p2", "r2", "open", "j2", "l2", "switchStatus", "X7", ICustomDataEditor.STRING_PARAM_2, "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "e2", "()Landroidx/lifecycle/MutableLiveData;", "publishedFeedShowSwitchLiveData", "D", "c2", "joinedGuildShowSwitchLiveData", "E", "f2", "qqProfileShowSwitchLiveData", "Lkotlin/Pair;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Z1", "addFriendSwitchLiveData", "G", SemanticAttributes.DbSystemValues.H2, "sendDirectMsgSwitchLiveData", "H", "g2", "sendCommentSwitchLiveData", "Lri1/a;", "I", "b2", "guildError", "J", ICustomDataEditor.STRING_ARRAY_PARAM_2, "globalSwitchEnableLiveData", "K", "d2", "profileSwitchEnableLiveData", "<init>", "()V", "L", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class x extends ef1.b implements wp1.a {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> publishedFeedShowSwitchLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> joinedGuildShowSwitchLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> qqProfileShowSwitchLiveData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Boolean, Boolean>> addFriendSwitchLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> sendDirectMsgSwitchLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> sendCommentSwitchLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ri1.a> guildError;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> globalSwitchEnableLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> profileSwitchEnableLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/profilesetting/x$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lcom/tencent/mobileqq/guild/profile/me/profilesetting/x;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.me.profilesetting.x$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.profile.me.profilesetting.x$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7864a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f231277a;

            public C7864a(ViewModelStoreOwner viewModelStoreOwner) {
                this.f231277a = viewModelStoreOwner;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new x(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
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
        public final x a(@NotNull ViewModelStoreOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C7864a(owner)).get(x.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (x) viewModel;
        }

        Companion() {
        }
    }

    public x() {
        Boolean bool = Boolean.FALSE;
        this.addFriendSwitchLiveData = new MutableLiveData<>(new Pair(bool, bool));
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.sendDirectMsgSwitchLiveData = mutableLiveData;
        this.sendCommentSwitchLiveData = new MutableLiveData<>();
        this.guildError = new MutableLiveData<>();
        this.globalSwitchEnableLiveData = new MutableLiveData<>();
        this.profileSwitchEnableLiveData = new MutableLiveData<>();
        T1();
        W1();
        mutableLiveData.setValue(Boolean.valueOf(wp1.c.p()));
        wp1.c.f446014e.g(this);
    }

    private final void T1() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).fetchGlobalPrivacySwitch(new de() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.r
            @Override // wh2.de
            public final void a(int i3, String str, IGProGlobalPrivacySwitchGroup iGProGlobalPrivacySwitchGroup) {
                x.U1(x.this, i3, str, iGProGlobalPrivacySwitchGroup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(x this$0, int i3, String str, IGProGlobalPrivacySwitchGroup switchGroup) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(switchGroup, "switchGroup");
        Logger.f235387a.d().i("Guild.profile.GuildProfileSettingDialogViewModel", 1, "fetchGlobalPrivacySwitch: " + i3 + " - " + str + ", feed(" + switchGroup.getPublishedFeedShowSwitch() + "), guild(" + switchGroup.getJoinedGuildShowSwitch() + ")");
        this$0.globalSwitchEnableLiveData.setValue(Boolean.TRUE);
        if (i3 != 0) {
            return;
        }
        this$0.publishedFeedShowSwitchLiveData.setValue(Boolean.valueOf(this$0.i2(switchGroup.getPublishedFeedShowSwitch())));
        this$0.joinedGuildShowSwitchLiveData.setValue(Boolean.valueOf(this$0.i2(switchGroup.getJoinedGuildShowSwitch())));
        this$0.qqProfileShowSwitchLiveData.setValue(Boolean.valueOf(this$0.i2(switchGroup.getQqProfileShowSwitch())));
        this$0.addFriendSwitchLiveData.setValue(new Pair<>(Boolean.valueOf(this$0.i2(switchGroup.getAllSwitch())), Boolean.valueOf(this$0.i2(switchGroup.getAddFriendSwitch()))));
    }

    private final void W1() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).getProfileSwitch(new cu() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.s
            @Override // wh2.cu
            public final void a(int i3, String str, IGProGetProfileSwitchRsp iGProGetProfileSwitchRsp) {
                x.X1(x.this, i3, str, iGProGetProfileSwitchRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(x this$0, int i3, String str, IGProGetProfileSwitchRsp iGProGetProfileSwitchRsp) {
        ArrayList<Integer> arrayList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("Guild.profile.GuildProfileSettingDialogViewModel", 1, "fetchProfile " + i3 + " - " + str + ", " + iGProGetProfileSwitchRsp);
        this$0.profileSwitchEnableLiveData.setValue(Boolean.TRUE);
        if (i3 == 0) {
            if (iGProGetProfileSwitchRsp != null) {
                arrayList = iGProGetProfileSwitchRsp.getOpenSwitch();
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                this$0.sendCommentSwitchLiveData.setValue(Boolean.valueOf(iGProGetProfileSwitchRsp.getOpenSwitch().contains(3)));
            }
        }
    }

    private final boolean i2(int i3) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(x this$0, boolean z16, int i3, String str, IGProGlobalPrivacySwitchGroup switchGroup) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(switchGroup, "switchGroup");
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "setAddFriendSwitch result = " + i3 + ", errMsg=" + str + ", switchGroup=" + switchGroup;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.profile.GuildProfileSettingDialogViewModel", 1, (String) it.next(), null);
            }
            MutableLiveData<Pair<Boolean, Boolean>> mutableLiveData = this$0.addFriendSwitchLiveData;
            Pair<Boolean, Boolean> value = mutableLiveData.getValue();
            if (value != null) {
                z17 = value.getFirst().booleanValue();
            } else {
                z17 = true;
            }
            mutableLiveData.setValue(new Pair<>(Boolean.valueOf(z17), Boolean.valueOf(!z16)));
            MutableLiveData<ri1.a> mutableLiveData2 = this$0.guildError;
            if (str == null) {
                str = "";
            }
            mutableLiveData2.setValue(ri1.a.b(i3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(x this$0, ri1.a error, Boolean bool) {
        IGProSecurityResult iGProSecurityResult;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "error");
        Logger.f235387a.d().d("Guild.profile.GuildProfileSettingDialogViewModel", 1, "setMsgNotifyStatus " + error + " " + bool);
        if (!error.d()) {
            Context i3 = ch.i();
            int i16 = error.f431477a;
            String str = error.f431478b;
            Object obj = error.f431479c;
            if (obj instanceof IGProSecurityResult) {
                iGProSecurityResult = (IGProSecurityResult) obj;
            } else {
                iGProSecurityResult = null;
            }
            SecurityTipHelperKt.F(i3, i16, str, iGProSecurityResult, null, null, 48, null);
            this$0.sendDirectMsgSwitchLiveData.setValue(Boolean.valueOf(wp1.c.p()));
        }
    }

    private final void n2(int switchType, final boolean show, final MutableLiveData<Boolean> liveData) {
        int i3;
        liveData.setValue(Boolean.valueOf(show));
        if (show) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).setGlobalPrivacySwitch(i3, switchType, new de() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.t
            @Override // wh2.de
            public final void a(int i16, String str, IGProGlobalPrivacySwitchGroup iGProGlobalPrivacySwitchGroup) {
                x.o2(MutableLiveData.this, show, this, i16, str, iGProGlobalPrivacySwitchGroup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(MutableLiveData liveData, boolean z16, x this$0, int i3, String str, IGProGlobalPrivacySwitchGroup switchGroup) {
        Intrinsics.checkNotNullParameter(liveData, "$liveData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(switchGroup, "switchGroup");
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "result = " + i3 + ", errMsg=" + str + ", switchGroup=" + switchGroup;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.profile.GuildProfileSettingDialogViewModel", 1, (String) it.next(), null);
            }
            liveData.setValue(Boolean.valueOf(!z16));
            MutableLiveData<ri1.a> mutableLiveData = this$0.guildError;
            if (str == null) {
                str = "";
            }
            mutableLiveData.setValue(ri1.a.b(i3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(x this$0, boolean z16, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "setSendCommentSwitch result = " + i3 + ", errMsg=" + str;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.profile.GuildProfileSettingDialogViewModel", 1, (String) it.next(), null);
        }
        if (i3 != 0) {
            this$0.sendCommentSwitchLiveData.setValue(Boolean.valueOf(!z16));
            this$0.guildError.setValue(ri1.a.b(i3, str));
        }
    }

    @Override // wp1.a
    public void X7(int switchStatus) {
        this.sendDirectMsgSwitchLiveData.setValue(Boolean.valueOf(wp1.c.p()));
    }

    @NotNull
    public final MutableLiveData<Pair<Boolean, Boolean>> Z1() {
        return this.addFriendSwitchLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> a2() {
        return this.globalSwitchEnableLiveData;
    }

    @NotNull
    public final MutableLiveData<ri1.a> b2() {
        return this.guildError;
    }

    @NotNull
    public final MutableLiveData<Boolean> c2() {
        return this.joinedGuildShowSwitchLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> d2() {
        return this.profileSwitchEnableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> e2() {
        return this.publishedFeedShowSwitchLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> f2() {
        return this.qqProfileShowSwitchLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> g2() {
        return this.sendCommentSwitchLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> h2() {
        return this.sendDirectMsgSwitchLiveData;
    }

    public final void j2(final boolean open) {
        boolean z16;
        MutableLiveData<Pair<Boolean, Boolean>> mutableLiveData = this.addFriendSwitchLiveData;
        Pair<Boolean, Boolean> value = mutableLiveData.getValue();
        int i3 = 1;
        if (value != null) {
            z16 = value.getFirst().booleanValue();
        } else {
            z16 = true;
        }
        mutableLiveData.setValue(new Pair<>(Boolean.valueOf(z16), Boolean.valueOf(open)));
        if (open) {
            i3 = 2;
        }
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).setGlobalPrivacySwitch(i3, 0, new de() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.u
            @Override // wh2.de
            public final void a(int i16, String str, IGProGlobalPrivacySwitchGroup iGProGlobalPrivacySwitchGroup) {
                x.k2(x.this, open, i16, str, iGProGlobalPrivacySwitchGroup);
            }
        });
    }

    public final void l2(boolean open) {
        int i3;
        this.sendDirectMsgSwitchLiveData.setValue(Boolean.valueOf(open));
        if (open) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        wp1.c.t(i3, new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.w
            @Override // com.tencent.mobileqq.guild.base.repository.h
            public final void a(ri1.a aVar, Object obj) {
                x.m2(x.this, aVar, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        wp1.c.f446014e.r(this);
    }

    public final void p2(boolean show) {
        n2(2, show, this.joinedGuildShowSwitchLiveData);
    }

    public final void q2(boolean show) {
        n2(3, show, this.publishedFeedShowSwitchLiveData);
    }

    public final void r2(boolean show) {
        n2(1, show, this.qqProfileShowSwitchLiveData);
    }

    public final void s2(final boolean open) {
        this.sendCommentSwitchLiveData.setValue(Boolean.valueOf(open));
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).setProfileSwitch(3, open, new em() { // from class: com.tencent.mobileqq.guild.profile.me.profilesetting.v
            @Override // wh2.em
            public final void onResult(int i3, String str) {
                x.t2(x.this, open, i3, str);
            }
        });
    }
}
