package com.tencent.mobileqq.guild.mainframe.create.removemember;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.mainframe.create.InviteFriendsData;
import com.tencent.mobileqq.guild.profile.me.aj;
import com.tencent.mobileqq.guild.profile.me.ak;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\"\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0014\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007J\b\u0010\u000f\u001a\u00020\u0004H\u0014R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00070\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00070&8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110&8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010(\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/removemember/d;", "Lef1/b;", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "profileInfo", "", "T1", "S1", "", "Lcom/tencent/mobileqq/guild/mainframe/create/InviteFriendsData;", "memberList", "R1", "", "uin", "U1", "O1", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_selectCountLiveData", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/a;", "D", "_memberListLiveData", "", "E", "Ljava/util/List;", "", UserInfo.SEX_FEMALE, "Ljava/util/Set;", "selectedUins", "G", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "mySelfGuildProfile", "com/tencent/mobileqq/guild/mainframe/create/removemember/d$b", "H", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/d$b;", "profileChangeListener", "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "memberListLiveData", "Q1", "selectCountLiveData", "<init>", "()V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends ef1.b {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _selectCountLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<a>> _memberListLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<InviteFriendsData> memberList = new ArrayList();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Set<String> selectedUins = new LinkedHashSet();

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ev mySelfGuildProfile;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final b profileChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/removemember/d$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/d;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.create.removemember.d$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.mainframe.create.removemember.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7827a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f227396a;

            public C7827a(ViewModelStoreOwner viewModelStoreOwner) {
                this.f227396a = viewModelStoreOwner;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new d(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                }
                return (T) timedValue.getValue();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final d a(@NotNull ViewModelStoreOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C7827a(owner)).get(d.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (d) viewModel;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/mainframe/create/removemember/d$b", "Lcom/tencent/mobileqq/guild/profile/me/ak;", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "profileInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements ak {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.profile.me.ak
        public void a(@NotNull ev profileInfo) {
            Intrinsics.checkNotNullParameter(profileInfo, "profileInfo");
            d.this.T1(profileInfo);
        }
    }

    public d() {
        b bVar = new b();
        this.profileChangeListener = bVar;
        this.mySelfGuildProfile = aj.l();
        aj.g(bVar);
    }

    private final void S1() {
        int i3;
        ArrayList arrayList = new ArrayList();
        ev evVar = this.mySelfGuildProfile;
        if (evVar != null) {
            String tinyId = evVar.getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId, "it.tinyId");
            String displayName = evVar.getDisplayName();
            Intrinsics.checkNotNullExpressionValue(displayName, "it.displayName");
            arrayList.add(new SelfData(tinyId, displayName));
        }
        for (InviteFriendsData inviteFriendsData : this.memberList) {
            if (this.selectedUins.contains(inviteFriendsData.getUin())) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            arrayList.add(new MemberData(inviteFriendsData.getUin(), inviteFriendsData.getName(), i3));
        }
        this._memberListLiveData.setValue(arrayList);
        this._selectCountLiveData.setValue(Integer.valueOf(this.selectedUins.size()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(ev profileInfo) {
        this.mySelfGuildProfile = profileInfo;
        S1();
    }

    @NotNull
    public final List<String> O1() {
        List<String> list;
        list = CollectionsKt___CollectionsKt.toList(this.selectedUins);
        return list;
    }

    @NotNull
    public final LiveData<List<a>> P1() {
        return this._memberListLiveData;
    }

    @NotNull
    public final LiveData<Integer> Q1() {
        return this._selectCountLiveData;
    }

    public final void R1(@NotNull List<InviteFriendsData> memberList) {
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        this.memberList.clear();
        this.memberList.addAll(memberList);
        List<InviteFriendsData> list = this.memberList;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (hashSet.add(((InviteFriendsData) obj).getUin())) {
                arrayList.add(obj);
            }
        }
        S1();
    }

    public final void U1(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (this.selectedUins.contains(uin)) {
            this.selectedUins.remove(uin);
        } else {
            this.selectedUins.add(uin);
        }
        S1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        aj.q(this.profileChangeListener);
    }
}
