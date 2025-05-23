package aq2;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectfriend.relationlist.d;
import com.tencent.mobileqq.selectfriend.relationlist.vm.ListType;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010$\u001a\u00020\u0014\u00a2\u0006\u0004\b%\u0010&J<\u0010\r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J,\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u001a\u0010\u0017\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t\u0012\u0004\u0012\u00020\f0\u0016H\u0016J4\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00072\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0004J.\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00072\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\tH\u0004J\u0012\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010 \u001a\u00020\u0010H\u0016R\u0014\u0010$\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Laq2/a;", "Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "allList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectfriend/relationlist/d;", "Lkotlin/collections/ArrayList;", "sharedNodeCategoryInfoList", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", QZoneCheckSendGiftServlet.PARAM_FRINED_LIST, "", "j", "l", "o", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/selectfriend/relationlist/vm/ListType;", "b", "", "fromNet", "Lkotlin/Function1;", "callback", "c", "simpleInfos", "", "categoryId", "k", "", "userList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "sharedNode", "Landroid/graphics/drawable/Drawable;", "a", "Z", "showRobotGroup", "<init>", "(Z)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a extends com.tencent.mobileqq.selectfriend.relationlist.model.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static int f26749c = 1003;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean showRobotGroup;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Laq2/a$a;", "", "", "currentRecentId", "I", "a", "()I", "b", "(I)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: aq2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return a.f26749c;
        }

        public final void b(int i3) {
            a.f26749c = i3;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"aq2/a$b", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<List<d>, Unit> f26752b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super List<d>, Unit> function1) {
            this.f26752b = function1;
        }

        @Override // hx3.b
        public void onQueryResult(e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> responseData) {
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> b16;
            ArrayList arrayList = new ArrayList();
            if (responseData == null || responseData.a() != 0 || responseData.b() == null || (b16 = responseData.b()) == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b(0, null, 0, 0, (byte) 0, null, null, 127, null);
            Companion companion = a.INSTANCE;
            companion.b(b16.isEmpty() ^ true ? 1003 : 0);
            bVar.j(companion.a());
            bVar.l(HardCodeUtil.qqStr(R.string.mov));
            arrayList2.add(0, bVar);
            arrayList2.addAll(b16);
            a.this.j(arrayList2, arrayList, ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("GroupFriendListModel"));
            d o16 = a.this.o();
            if (o16 != null) {
                arrayList.add(o16);
            }
            d l3 = a.this.l();
            if (l3 != null) {
                arrayList.add(l3);
            }
            this.f26752b.invoke(arrayList);
        }
    }

    public a(boolean z16) {
        this.showRobotGroup = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> allList, ArrayList<d> sharedNodeCategoryInfoList, List<? extends com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendList) {
        ListIterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> listIterator = allList.listIterator();
        while (listIterator.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b next = listIterator.next();
            if (next.d() == ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getSpecialCareCategoryId()) {
                listIterator.remove();
            } else if (next.d() == f26749c) {
                ArrayList<SharedNode> n3 = n();
                if (n3 != null) {
                    sharedNodeCategoryInfoList.add(new d(next.f(), String.valueOf(n3.size()), next.h(), n3));
                }
            } else {
                ArrayList<SharedNode> k3 = k(friendList, next.d());
                if (k3 != null) {
                    sharedNodeCategoryInfoList.add(new d(next.f(), String.valueOf(k3.size()), next.h(), k3));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d l() {
        List<Object> bindNonfriendListInObject;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IPhoneContactService iPhoneContactService = peekAppRuntime != null ? (IPhoneContactService) peekAppRuntime.getRuntimeService(IPhoneContactService.class, "") : null;
        if (iPhoneContactService == null) {
            return null;
        }
        int selfBindState = iPhoneContactService.getSelfBindState();
        if ((!iPhoneContactService.isBindContactOk() && selfBindState != 8) || (bindNonfriendListInObject = iPhoneContactService.getBindNonfriendListInObject()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : bindNonfriendListInObject) {
            if (obj instanceof PhoneContact) {
                arrayList.add(com.tencent.mobileqq.selectfriend.relationlist.a.f285557a.j((PhoneContact) obj));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new d(HardCodeUtil.qqStr(R.string.csf), String.valueOf(arrayList.size()), (byte) 0, arrayList);
    }

    private final ArrayList<SharedNode> n() {
        return m(((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentListFromCacheInObject());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d o() {
        ac robotService;
        if (!this.showRobotGroup || (robotService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getRobotService()) == null) {
            return null;
        }
        ArrayList<RobotCoreInfo> allRobotFriendsFromCache = robotService.getAllRobotFriendsFromCache();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("addRobotGroup: size=");
        sb5.append(allRobotFriendsFromCache != null ? allRobotFriendsFromCache.size() : 0);
        QLog.i("GroupFriendListModel", 1, sb5.toString());
        if (allRobotFriendsFromCache == null) {
            allRobotFriendsFromCache = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<RobotCoreInfo> it = allRobotFriendsFromCache.iterator();
        while (it.hasNext()) {
            RobotCoreInfo robotCoreInfo = it.next();
            com.tencent.mobileqq.selectfriend.relationlist.a aVar = com.tencent.mobileqq.selectfriend.relationlist.a.f285557a;
            Intrinsics.checkNotNullExpressionValue(robotCoreInfo, "robotCoreInfo");
            arrayList.add(aVar.l(robotCoreInfo));
        }
        return new d(HardCodeUtil.qqStr(R.string.f222106cm), String.valueOf(arrayList.size()), (byte) 0, arrayList);
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.model.a
    public Drawable a(SharedNode sharedNode) {
        Intrinsics.checkNotNullParameter(sharedNode, "sharedNode");
        return null;
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.model.a
    public ListType b() {
        return ListType.GROUPED;
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.model.a
    public void c(boolean fromNet, Function1<? super List<d>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryCacheInfoV2(RelationListReqType.NORMAL, false, "GroupFriendListModel", false, new b(callback));
    }

    protected final ArrayList<SharedNode> k(List<? extends com.tencent.qqnt.ntrelation.friendsinfo.bean.d> simpleInfos, int categoryId) {
        List<? extends com.tencent.qqnt.ntrelation.friendsinfo.bean.d> list = simpleInfos;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<SharedNode> arrayList = new ArrayList<>();
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : simpleInfos) {
            try {
                Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type com.tencent.qqnt.ntrelation.friendsinfo.bean.NTFriendSimpleInfo");
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 = dVar;
                IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopRobotService.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ant.ALL\n                )");
                if (!((ITroopRobotService) runtimeService).isRobotUin(dVar2.x()) && dVar2.f() == categoryId && !Utils.G(dVar2.x())) {
                    arrayList.add(com.tencent.mobileqq.selectfriend.relationlist.a.f285557a.i(dVar2));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return arrayList;
    }

    protected final ArrayList<SharedNode> m(List<? extends Object> userList) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid;
        if (userList == null || userList.size() == 0) {
            return null;
        }
        ArrayList<SharedNode> arrayList = new ArrayList<>();
        for (Object obj : userList) {
            if (obj instanceof RecentUser) {
                RecentUser recentUser = (RecentUser) obj;
                if (!Utils.J(recentUser.uin) && recentUser.getType() == 0 && !Utils.I(recentUser.uin)) {
                    String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(recentUser.uin);
                    IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                    Intrinsics.checkNotNullExpressionValue(uid, "uid");
                    if (iFriendsInfoService.isFriend(uid, "GroupFriendListModel") && (friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uid, "GroupFriendListModel")) != null) {
                        arrayList.add(com.tencent.mobileqq.selectfriend.relationlist.a.f285557a.i(friendsSimpleInfoWithUid));
                    }
                }
            }
        }
        return arrayList;
    }
}
