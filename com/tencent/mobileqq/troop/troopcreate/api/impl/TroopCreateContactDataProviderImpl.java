package com.tencent.mobileqq.troop.troopcreate.api.impl;

import QQService.EVIPSPEC;
import android.content.Context;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.VipTypeParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateContactDataProvider;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qidian.api.IQidianManagerApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001d\u001e\u001fB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJX\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u001c\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n0\u00072\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\nH\u0002JL\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u001c\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n0\u00072\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\nH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002JT\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\bj\b\u0012\u0004\u0012\u00020\u0015`\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u001c\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n0\u0007H\u0002JD\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\bj\b\u0012\u0004\u0012\u00020\u0015`\n2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\nH\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/api/impl/TroopCreateContactDataProviderImpl;", "Lcom/tencent/mobileqq/troop/troopcreate/api/ITroopCreateContactDataProvider;", "Landroid/content/Context;", "context", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "groups", "Landroid/util/SparseArray;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "members", "", "uinsToHide", "", "addRecentGroup", "addGroupFriend", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "f", "", "getFriendPriority", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "robotList", "addRobotGroup", "Lcom/tencent/mobileqq/troop/troopcreate/api/ITroopCreateContactDataProvider$a;", "loadContactData", "<init>", "()V", "Companion", "a", "b", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopCreateContactDataProviderImpl implements ITroopCreateContactDataProvider {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TroopCreateContactDataProviderImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/api/impl/TroopCreateContactDataProviderImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreateContactDataProviderImpl$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/api/impl/TroopCreateContactDataProviderImpl$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "a", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "()Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", GuildMsgItem.NICK_FRIEND, "b", "I", "()I", "setPriority", "(I)V", "priority", "<init>", "(Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.ntrelation.friendsinfo.bean.d friend;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int priority;

        public b(@NotNull com.tencent.qqnt.ntrelation.friendsinfo.bean.d friend, int i3) {
            Intrinsics.checkNotNullParameter(friend, "friend");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) friend, i3);
            } else {
                this.friend = friend;
                this.priority = i3;
            }
        }

        @NotNull
        public final com.tencent.qqnt.ntrelation.friendsinfo.bean.d a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.friend;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.priority;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.friend, bVar.friend) && this.priority == bVar.priority) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return (this.friend.hashCode() * 31) + this.priority;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "FriendHolder(friend=" + this.friend + ", priority=" + this.priority + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/api/impl/TroopCreateContactDataProviderImpl$c;", "Ljava/util/Comparator;", "Lcom/tencent/mobileqq/troop/troopcreate/api/impl/TroopCreateContactDataProviderImpl$b;", "Lkotlin/Comparator;", "l", "r", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements Comparator<b> {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(@NotNull b l3, @NotNull b r16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) l3, (Object) r16)).intValue();
            }
            Intrinsics.checkNotNullParameter(l3, "l");
            Intrinsics.checkNotNullParameter(r16, "r");
            return l3.b() - r16.b();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57465);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopCreateContactDataProviderImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void addGroupFriend(List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> groups, SparseArray<ArrayList<Object>> members, ArrayList<String> uinsToHide) {
        ITroopRobotService iTroopRobotService;
        IQidianManagerApi iQidianManagerApi;
        long currentTimeMillis = System.currentTimeMillis();
        Class<IFriendsInfoService> cls = IFriendsInfoService.class;
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> friendsCategoryBaseInfo = ((IFriendsInfoService) QRoute.api(cls)).getFriendsCategoryBaseInfo(TAG);
        AppInterface e16 = bg.e();
        if (e16 == null || (iTroopRobotService = (ITroopRobotService) bg.l(ITroopRobotService.class)) == null || (iQidianManagerApi = (IQidianManagerApi) bg.l(IQidianManagerApi.class)) == null) {
            return;
        }
        c cVar = new c();
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> it = friendsCategoryBaseInfo.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b friendsCategoryInfo = ((IFriendsInfoService) QRoute.api(cls)).getFriendsCategoryInfo(String.valueOf(it.next().a()), TAG);
            if (friendsCategoryInfo != null) {
                groups.add(friendsCategoryInfo);
                ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> b16 = friendsCategoryInfo.b();
                ArrayList arrayList = new ArrayList();
                Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it5 = b16.iterator();
                while (it5.hasNext()) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d buddy = it5.next();
                    Intrinsics.checkNotNullExpressionValue(buddy, "buddy");
                    arrayList.add(new b(buddy, getFriendPriority(buddy)));
                    cls = cls;
                    it = it;
                }
                Class<IFriendsInfoService> cls2 = cls;
                Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> it6 = it;
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, cVar);
                b16.clear();
                Iterator it7 = arrayList.iterator();
                while (it7.hasNext()) {
                    b16.add(((b) it7.next()).a());
                }
                ArrayList<Object> arrayList2 = new ArrayList<>();
                String currentAccountUin = e16.getCurrentAccountUin();
                int size = b16.size();
                for (int i3 = 0; i3 < size; i3++) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = b16.get(i3);
                    Intrinsics.checkNotNullExpressionValue(dVar, "buddyList[i]");
                    String x16 = dVar.x();
                    if (!Intrinsics.areEqual(x16, currentAccountUin) && !uinsToHide.contains(x16) && !Utils.G(x16) && !iTroopRobotService.isRobotUin(x16) && !iQidianManagerApi.isQidianMaster(x16)) {
                        arrayList2.add(b16.get(i3));
                    }
                }
                members.put(friendsCategoryInfo.d(), arrayList2);
                cls = cls2;
                it = it6;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addGroupFriend: timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private final void addRecentGroup(Context context, List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> groups, SparseArray<ArrayList<Object>> members, ArrayList<String> uinsToHide) {
        boolean z16 = true;
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> recentFriends = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getRecentFriends(Integer.MAX_VALUE, true, uinsToHide);
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> list = recentFriends;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        }
        if (!z16) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b(0, null, 0, 0, (byte) 0, null, null, 127, null);
            bVar.j(1003);
            bVar.l(context.getString(R.string.f173057gz1));
            bVar.k(recentFriends.size());
            groups.add(bVar);
            members.put(bVar.d(), new ArrayList<>(recentFriends));
        }
    }

    private final void addRobotGroup(Context context, ArrayList<RobotCoreInfo> robotList, List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> groups, SparseArray<ArrayList<Object>> members) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b(0, null, 0, 0, (byte) 0, null, null, 127, null);
        bVar.j(1012);
        bVar.l(context.getString(R.string.f222106cm));
        bVar.k(robotList.size());
        groups.add(bVar);
        members.put(bVar.d(), new ArrayList<>(robotList));
    }

    private final int getFriendPriority(com.tencent.qqnt.ntrelation.friendsinfo.bean.d f16) {
        int i3;
        int i16;
        long B;
        int i17;
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(f16.getUid(), TAG);
        if (onlineStatusSimpleInfoWithUid == null) {
            onlineStatusSimpleInfoWithUid = new com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c(f16.getUid(), f16.x());
        }
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(f16.getUid(), f16.x());
        if (vasSimpleInfoWithUid == null) {
            vasSimpleInfoWithUid = new NTVasSimpleInfo(f16.getUid(), f16.x());
        }
        int a16 = com.tencent.mobileqq.friend.status.b.a(onlineStatusSimpleInfoWithUid.u(), onlineStatusSimpleInfoWithUid.z());
        if (a16 != 6 && a16 != 0) {
            i3 = 65536;
        } else {
            i3 = 131072;
        }
        VipTypeParam vipTypeParam = new VipTypeParam(vasSimpleInfoWithUid.qqVipInfo, vasSimpleInfoWithUid.superQqInfo, vasSimpleInfoWithUid.superVipInfo, vasSimpleInfoWithUid.bigClubInfo);
        EVIPSPEC E_SP_SUPERVIP = EVIPSPEC.E_SP_SUPERVIP;
        Intrinsics.checkNotNullExpressionValue(E_SP_SUPERVIP, "E_SP_SUPERVIP");
        if (vipTypeParam.isServiceEnabled(E_SP_SUPERVIP)) {
            i16 = 4096;
        } else {
            EVIPSPEC E_SP_QQVIP = EVIPSPEC.E_SP_QQVIP;
            Intrinsics.checkNotNullExpressionValue(E_SP_QQVIP, "E_SP_QQVIP");
            if (vipTypeParam.isServiceEnabled(E_SP_QQVIP)) {
                i16 = 8192;
            } else {
                EVIPSPEC E_SP_SUPERQQ = EVIPSPEC.E_SP_SUPERQQ;
                Intrinsics.checkNotNullExpressionValue(E_SP_SUPERQQ, "E_SP_SUPERQQ");
                if (vipTypeParam.isServiceEnabled(E_SP_SUPERQQ)) {
                    i16 = 12288;
                } else {
                    i16 = 16384;
                }
            }
        }
        if (a16 != 0) {
            if (a16 != 1) {
                if (a16 != 2) {
                    if (a16 != 3 && a16 != 4) {
                        if (a16 != 6) {
                            if (a16 != 7) {
                                B = onlineStatusSimpleInfoWithUid.B();
                                i17 = ((int) B) | i16;
                            }
                        }
                    } else {
                        i17 = i16 | 1;
                    }
                }
                i17 = i16 | 3;
            } else {
                i17 = i16 | 2;
            }
            return i17 | i3;
        }
        B = onlineStatusSimpleInfoWithUid.B();
        i17 = ((int) B) | i16;
        return i17 | i3;
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateContactDataProvider
    @NotNull
    public ITroopCreateContactDataProvider.a loadContactData(@NotNull Context context, @NotNull ArrayList<RobotCoreInfo> robotList, @Nullable ArrayList<String> uinsToHide) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ITroopCreateContactDataProvider.a) iPatchRedirector.redirect((short) 2, this, context, robotList, uinsToHide);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotList, "robotList");
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        SparseArray<ArrayList<Object>> sparseArray = new SparseArray<>();
        addRecentGroup(context, arrayList, sparseArray, uinsToHide);
        if (uinsToHide == null) {
            uinsToHide = new ArrayList<>();
        }
        addGroupFriend(arrayList, sparseArray, uinsToHide);
        addRobotGroup(context, robotList, arrayList, sparseArray);
        return new ITroopCreateContactDataProvider.a(arrayList, sparseArray, currentTimeMillis);
    }
}
