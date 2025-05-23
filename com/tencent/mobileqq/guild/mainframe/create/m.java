package com.tencent.mobileqq.guild.mainframe.create;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.profile.me.aj;
import com.tencent.mobileqq.guild.profile.me.ak;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreateGuildRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.ac;
import com.tencent.mobileqq.qqguildsdk.data.genc.eo;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ef1.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt___StringsKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ur1.GuildCreateMemberData;
import wh2.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f*\u00011\u0018\u0000 B2\u00020\u0001:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0014\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0014\u0010\u000f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\tJ\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rJ\b\u0010\u0014\u001a\u00020\u0002H\u0014R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010!\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u0017R \u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\t0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001d\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\t058F\u00a2\u0006\u0006\u001a\u0004\b6\u00107R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\"058F\u00a2\u0006\u0006\u001a\u0004\b9\u00107R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\r0\t8F\u00a2\u0006\u0006\u001a\u0004\b;\u0010<R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\t8F\u00a2\u0006\u0006\u001a\u0004\b>\u0010<\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/m;", "Lef1/b;", "", "d2", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "profileInfo", "i2", "e2", "S1", "", "Lcom/tencent/mobileqq/guild/mainframe/create/InviteFriendsData;", "inviteFriends", "R1", "", "uins", "f2", "", "b2", "name", "g2", "onCleared", "Lcom/tencent/mobileqq/guild/util/cn;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/util/cn;", "X1", "()Lcom/tencent/mobileqq/guild/util/cn;", "initGuildNameEvent", "", "D", "c2", "showLoadingDialogEvent", "E", "Z", "isCreating", "Lcom/tencent/mobileqq/guild/mainframe/create/a;", UserInfo.SEX_FEMALE, "_createResultEvent", "Landroidx/lifecycle/MutableLiveData;", "Lur1/e;", "G", "Landroidx/lifecycle/MutableLiveData;", "_memberListLiveData", "", "H", "Ljava/util/List;", "_memberList", "I", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "mySelfGuildProfile", "com/tencent/mobileqq/guild/mainframe/create/m$b", "J", "Lcom/tencent/mobileqq/guild/mainframe/create/m$b;", "profileChangeListener", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "memberListLiveData", "U1", "createResultEvent", "W1", "()Ljava/util/List;", "currentMemberUinList", ICustomDataEditor.STRING_ARRAY_PARAM_2, "memberUinList", "<init>", "()V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class m extends ef1.b {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isCreating;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ev mySelfGuildProfile;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b profileChangeListener;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final cn<String> initGuildNameEvent = new cn<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> showLoadingDialogEvent = new cn<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final cn<CreateResult> _createResultEvent = new cn<>();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<GuildCreateMemberData>> _memberListLiveData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final List<InviteFriendsData> _memberList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/m$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lcom/tencent/mobileqq/guild/mainframe/create/m;", "a", "", "DELAY_LOADING_TIME_MS", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.create.m$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.mainframe.create.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7826a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f227388a;

            public C7826a(ViewModelStoreOwner viewModelStoreOwner) {
                this.f227388a = viewModelStoreOwner;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new m(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
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
        public final m a(@NotNull ViewModelStoreOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C7826a(owner)).get(m.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (m) viewModel;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/mainframe/create/m$b", "Lcom/tencent/mobileqq/guild/profile/me/ak;", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "profileInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements ak {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.profile.me.ak
        public void a(@NotNull ev profileInfo) {
            Intrinsics.checkNotNullParameter(profileInfo, "profileInfo");
            m.this.i2(profileInfo);
        }
    }

    public m() {
        b bVar = new b();
        this.profileChangeListener = bVar;
        d2();
        aj.g(bVar);
    }

    private final void S1() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.create.l
            @Override // java.lang.Runnable
            public final void run() {
                m.T1(m.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isCreating) {
            Logger.f235387a.d().i("GuildCreateViewModel", 1, "isCreating: false");
        } else {
            this$0.showLoadingDialogEvent.setValue(Boolean.TRUE);
        }
    }

    private final void d2() {
        i2(aj.l());
    }

    private final void e2() {
        int collectionSizeOrDefault;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        ev evVar = this.mySelfGuildProfile;
        if (evVar != null) {
            String tinyId = evVar.getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId, "it.tinyId");
            String displayName = evVar.getDisplayName();
            Intrinsics.checkNotNullExpressionValue(displayName, "it.displayName");
            arrayList.add(new GuildCreateMemberData(tinyId, displayName, 1, "0", false, 16, null));
        }
        List<InviteFriendsData> list = this._memberList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (InviteFriendsData inviteFriendsData : list) {
            arrayList2.add(new GuildCreateMemberData(inviteFriendsData.getUin(), inviteFriendsData.getName(), 2, null, false, 24, null));
        }
        arrayList.addAll(arrayList2);
        if (b2() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        arrayList.add(new GuildCreateMemberData("", "\u6dfb\u52a0", 3, null, z16, 8, null));
        if (!this._memberList.isEmpty()) {
            arrayList.add(new GuildCreateMemberData("", "\u79fb\u9664", 4, null, false, 24, null));
        }
        this._memberListLiveData.setValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0063, code lost:
    
        if (com.tencent.mobileqq.guild.util.ch.p(r0) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void h2(m this$0, int i3, String errMsg, IGProCreateGuildRsp iGProCreateGuildRsp) {
        Long l3;
        IGProSecurityResult iGProSecurityResult;
        IGProSecurityResult iGProSecurityResult2;
        IGProSecurityResult iGProSecurityResult3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.a d16 = Logger.f235387a.d();
        String str = null;
        if (iGProCreateGuildRsp != null) {
            l3 = Long.valueOf(iGProCreateGuildRsp.getGuildId());
        } else {
            l3 = null;
        }
        if (iGProCreateGuildRsp != null) {
            iGProSecurityResult = iGProCreateGuildRsp.getSecRet();
        } else {
            iGProSecurityResult = null;
        }
        d16.d("GuildCreateViewModel", 1, "[createGuild] " + i3 + " - " + errMsg + ", guildId " + l3 + ", secRet " + iGProSecurityResult);
        if (i3 == 0) {
            if (iGProCreateGuildRsp != null) {
                iGProSecurityResult3 = iGProCreateGuildRsp.getSecRet();
            } else {
                iGProSecurityResult3 = null;
            }
        }
        this$0.isCreating = false;
        cn<CreateResult> cnVar = this$0._createResultEvent;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        if (iGProCreateGuildRsp != null) {
            iGProSecurityResult2 = iGProCreateGuildRsp.getSecRet();
        } else {
            iGProSecurityResult2 = null;
        }
        if (iGProCreateGuildRsp != null) {
            str = Long.valueOf(iGProCreateGuildRsp.getGuildId()).toString();
        }
        cnVar.setValue(new CreateResult(i3, errMsg, iGProSecurityResult2, str));
        com.tencent.mobileqq.guild.util.report.b.a("guild_create_result_code").setResultCode(i3).setResultMsg(errMsg).report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i2(ev profileInfo) {
        this.mySelfGuildProfile = profileInfo;
        e2();
        ev evVar = this.mySelfGuildProfile;
        if (evVar != null) {
            String str = evVar.getDisplayName() + "\u7684\u9891\u9053";
            if (!Intrinsics.areEqual(this.initGuildNameEvent.getValue(), str)) {
                this.initGuildNameEvent.setValue(str);
            }
        }
    }

    public final void R1(@NotNull List<InviteFriendsData> inviteFriends) {
        String str;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(inviteFriends, "inviteFriends");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(inviteFriends, ",", null, null, 0, null, null, 62, null);
            Log.d("GuildCreateViewModel", "addMemberList: " + joinToString$default);
        }
        List<InviteFriendsData> list = this._memberList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : inviteFriends) {
            String uin = ((InviteFriendsData) obj).getUin();
            ev evVar = this.mySelfGuildProfile;
            if (evVar != null) {
                str = evVar.getUin();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(uin, str)) {
                arrayList.add(obj);
            }
        }
        list.addAll(arrayList);
        List<InviteFriendsData> list2 = this._memberList;
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (hashSet.add(((InviteFriendsData) obj2).getUin())) {
                arrayList2.add(obj2);
            }
        }
        e2();
    }

    @NotNull
    public final LiveData<CreateResult> U1() {
        return this._createResultEvent;
    }

    @NotNull
    public final List<String> W1() {
        int collectionSizeOrDefault;
        List<InviteFriendsData> list = this._memberList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((InviteFriendsData) it.next()).getUin());
        }
        return arrayList;
    }

    @NotNull
    public final cn<String> X1() {
        return this.initGuildNameEvent;
    }

    @NotNull
    public final LiveData<List<GuildCreateMemberData>> Z1() {
        return this._memberListLiveData;
    }

    @NotNull
    public final List<InviteFriendsData> a2() {
        return this._memberList;
    }

    public final int b2() {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(bs.f235483a.h("105748").getGuildInviteFriendsConfBean().getGuildMemberScaleLimit() - this._memberList.size(), 0);
        return coerceAtLeast;
    }

    @NotNull
    public final cn<Boolean> c2() {
        return this.showLoadingDialogEvent;
    }

    public final void f2(@NotNull List<String> uins) {
        Intrinsics.checkNotNullParameter(uins, "uins");
        Iterator<InviteFriendsData> it = this._memberList.iterator();
        while (it.hasNext()) {
            if (uins.contains(it.next().getUin())) {
                it.remove();
            }
        }
        e2();
    }

    public final void g2(@NotNull String name) {
        String take;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(name, "name");
        Logger.a d16 = Logger.f235387a.d();
        take = StringsKt___StringsKt.take(name, 2);
        d16.d("GuildCreateViewModel", 1, "[sendCreateGuildRequest] name: " + take + "(" + name.length() + "), isCreating: " + this.isCreating);
        if (this.isCreating) {
            return;
        }
        this.isCreating = true;
        S1();
        eo eoVar = new eo();
        eoVar.l(0L);
        eoVar.k(0L);
        eoVar.j("mvp_plus");
        eoVar.h("463448973");
        eoVar.i("android");
        eoVar.g("qq_native");
        ac acVar = new ac();
        acVar.h(name);
        acVar.l(0);
        acVar.k(1);
        acVar.m(eoVar);
        acVar.i(1);
        bg bgVar = bg.f302144a;
        List<InviteFriendsData> list = this._memberList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(az.d(((InviteFriendsData) it.next()).getUin(), 0L)));
        }
        acVar.j(bgVar.n(arrayList));
        ((IGPSService) ch.R0(IGPSService.class)).createGuild(acVar, new o() { // from class: com.tencent.mobileqq.guild.mainframe.create.k
            @Override // wh2.o
            public final void a(int i3, String str, IGProCreateGuildRsp iGProCreateGuildRsp) {
                m.h2(m.this, i3, str, iGProCreateGuildRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        aj.q(this.profileChangeListener);
    }
}
