package com.tencent.biz.qqcircle.comment.at;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.util.Consumer;
import com.dataline.util.j;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.immersive.request.QFSGetSearchPageRequest;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.relation.QCircleRelationGroupManager;
import cooperation.qqcircle.relation.entitys.FriendsWrapper;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import uq3.k;
import vd2.GroupInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentAtHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f83470a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f83471b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f83472c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, Integer> f83473d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper$10, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass10 implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetSearchPageRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Consumer f83478a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f83479b;

        AnonymousClass10(Consumer consumer, List list) {
            this.f83478a = consumer;
            this.f83479b = list;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, final FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
            if (z16 && j3 == 0 && feedCloudRead$StGetSearchPageRsp != null) {
                RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final ArrayList arrayList = new ArrayList();
                        for (FeedCloudMeta$StUser feedCloudMeta$StUser : feedCloudRead$StGetSearchPageRsp.searchUserInfo.userList.get()) {
                            o20.c cVar = new o20.c(o20.c.f421787h);
                            String str2 = feedCloudMeta$StUser.f398463id.get();
                            cVar.c(new QFSCommentAtEntity(str2, feedCloudMeta$StUser.icon.iconUrl.get(), feedCloudMeta$StUser.nick.get(), QCirclePluginUtil.getAuthType(feedCloudMeta$StUser)));
                            cVar.d(QFSCommentAtHelper.O(AnonymousClass10.this.f83479b, str2));
                            cVar.h(true);
                            arrayList.add(cVar);
                        }
                        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper.10.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass10.this.f83478a.accept(arrayList);
                            }
                        });
                    }
                });
                return;
            }
            this.f83478a.accept(null);
            RFWLog.e("QFSCommentAtHelper", RFWLog.USR, "loadRemoteUserData error:" + j3 + "  errorMsg:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f83483d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Consumer f83484e;

        AnonymousClass2(List list, Consumer consumer) {
            this.f83483d = list;
            this.f83484e = consumer;
        }

        @Override // java.lang.Runnable
        public void run() {
            final List arrayList = new ArrayList();
            boolean I = QFSCommentAtHelper.I(this.f83483d, arrayList);
            if (!QFSCommentAtHelper.g0() && !QFSCommentAtHelper.h0()) {
                QFSCommentAtHelper.J(this.f83483d, arrayList);
                QFSCommentAtHelper.C(this.f83483d, arrayList);
                QFSCommentAtHelper.E(arrayList);
            } else {
                if (QFSCommentAtHelper.j0()) {
                    QFSCommentAtHelper.s(this.f83483d, arrayList);
                } else {
                    QFSCommentAtHelper.J(this.f83483d, arrayList);
                }
                if (QFSCommentAtHelper.h0()) {
                    QFSCommentAtHelper.K(this.f83483d, arrayList);
                }
                QFSCommentAtHelper.F(this.f83483d, arrayList);
                QFSCommentAtHelper.C(this.f83483d, arrayList);
                QFSCommentAtHelper.D(this.f83483d, arrayList);
                QFSCommentAtHelper.G(this.f83483d, arrayList);
                int W1 = uq3.c.W1();
                if (I) {
                    W1++;
                }
                if (arrayList.size() >= W1) {
                    arrayList = arrayList.subList(0, W1);
                }
                QFSCommentAtHelper.E(arrayList);
            }
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final Consumer consumer = this.f83484e;
            uIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.at.c
                @Override // java.lang.Runnable
                public final void run() {
                    Consumer.this.accept(arrayList);
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends TypeToken<List<QFSCommentAtEntity>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends TypeToken<List<QFSCommentAtEntity>> {
        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class c implements OnPromiseRejected {
        c() {
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
        public void onFail(String str) {
            RFWLog.e("QFSCommentAtHelper", RFWLog.USR, new RuntimeException("ICommentAtIoc  error = " + str));
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class d implements OnPromiseResolved<com.tencent.biz.qqcircle.comment.at.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPromiseResolved f83489a;

        d(OnPromiseResolved onPromiseResolved) {
            this.f83489a = onPromiseResolved;
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(com.tencent.biz.qqcircle.comment.at.a aVar) {
            this.f83489a.onDone(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e extends TypeToken<List<QFSCommentAtEntity>> {
        e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements Consumer<List<Friends>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f83490d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f83491e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f83492f;

        f(CountDownLatch countDownLatch, List list, List list2) {
            this.f83490d = countDownLatch;
            this.f83491e = list;
            this.f83492f = list2;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<Friends> list) {
            if (RFSafeListUtils.isEmpty(list)) {
                this.f83490d.countDown();
                return;
            }
            for (Friends friends : list) {
                String str = friends.uin;
                if (!QFSCommentAtHelper.M(this.f83491e, str)) {
                    o20.c cVar = new o20.c(o20.c.f421787h);
                    cVar.c(new QFSCommentAtEntity(str, null, friends.getFriendNickWithAlias(), 0));
                    cVar.d(QFSCommentAtHelper.O(this.f83492f, str));
                    this.f83491e.add(cVar);
                }
            }
            this.f83490d.countDown();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class g implements Consumer<Map<Groups, List<QFSCommentAtEntity>>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f83493d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f83494e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Consumer f83495f;

        g(String str, List list, Consumer consumer) {
            this.f83493d = str;
            this.f83494e = list;
            this.f83495f = consumer;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map<Groups, List<QFSCommentAtEntity>> map) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<Groups, List<QFSCommentAtEntity>> entry : map.entrySet()) {
                for (QFSCommentAtEntity qFSCommentAtEntity : entry.getValue()) {
                    String str = qFSCommentAtEntity.uin;
                    if (!QFSCommentAtHelper.M(arrayList, str)) {
                        String b16 = qFSCommentAtEntity.b();
                        if (!TextUtils.isEmpty(b16) && (str.contains(this.f83493d) || b16.contains(this.f83493d))) {
                            o20.b bVar = new o20.b();
                            bVar.c(new QFSCommentAtEntity(str, null, b16, 0));
                            bVar.g(entry.getKey());
                            bVar.d(QFSCommentAtHelper.O(this.f83494e, str));
                            arrayList.add(bVar);
                        }
                    }
                }
            }
            this.f83495f.accept(arrayList);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class h implements Consumer<Map<Groups, List<QFSCommentAtEntity>>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f83496d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f83497e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Consumer f83498f;

        h(String str, List list, Consumer consumer) {
            this.f83496d = str;
            this.f83497e = list;
            this.f83498f = consumer;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map<Groups, List<QFSCommentAtEntity>> map) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<Groups, List<QFSCommentAtEntity>> entry : map.entrySet()) {
                for (QFSCommentAtEntity qFSCommentAtEntity : entry.getValue()) {
                    String str = qFSCommentAtEntity.uin;
                    int i3 = qFSCommentAtEntity.uinType;
                    if (!QFSCommentAtHelper.N(arrayList, str, i3)) {
                        String b16 = qFSCommentAtEntity.b();
                        if (!TextUtils.isEmpty(b16) && (str.contains(this.f83496d) || b16.contains(this.f83496d))) {
                            o20.b bVar = new o20.b();
                            bVar.c(new QFSCommentAtEntity(str, null, b16, 0, i3));
                            bVar.g(entry.getKey());
                            bVar.d(QFSCommentAtHelper.P(this.f83497e, str, i3));
                            arrayList.add(bVar);
                        }
                    }
                }
            }
            this.f83498f.accept(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class i implements Consumer<List<Friends>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f83499d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map f83500e;

        i(CountDownLatch countDownLatch, Map map) {
            this.f83499d = countDownLatch;
            this.f83500e = map;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<Friends> list) {
            if (RFSafeListUtils.isEmpty(list)) {
                this.f83499d.countDown();
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Friends friends : list) {
                arrayList.add(new QFSCommentAtEntity(friends.uin, null, friends.getFriendNickWithAlias(), 0));
            }
            Groups groups = new Groups();
            groups.group_id = 1003;
            groups.group_name = com.tencent.biz.qqcircle.utils.h.a(R.string.f173057gz1);
            this.f83500e.put(groups, arrayList);
            this.f83499d.countDown();
        }
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        f83473d = arrayMap;
        arrayMap.put("mutual_group", 1009);
        arrayMap.put("follow_group", 1100);
        arrayMap.put("official_group", 1010);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(Map<Groups, List<QFSCommentAtEntity>> map) {
        ArrayList arrayList = new ArrayList(k0());
        if (h0()) {
            for (QFSCommentAtEntity qFSCommentAtEntity : m0()) {
                if (!arrayList.contains(qFSCommentAtEntity)) {
                    arrayList.add(qFSCommentAtEntity);
                }
            }
        }
        if (RFSafeListUtils.isEmpty(arrayList)) {
            return;
        }
        Groups groups = new Groups();
        groups.group_id = 1011;
        groups.group_name = com.tencent.biz.qqcircle.utils.h.a(R.string.f194514c4);
        map.put(groups, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void B(Map<Groups, List<QFSCommentAtEntity>> map) {
        List<TroopInfo> sortedJoinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getSortedJoinedTroopInfoFromCache();
        if (RFSafeListUtils.isEmpty(sortedJoinedTroopInfoFromCache)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (TroopInfo troopInfo : sortedJoinedTroopInfoFromCache) {
            arrayList.add(new QFSCommentAtEntity(troopInfo.troopuin, null, troopInfo.getTroopDisplayName(), 0, 1));
        }
        Groups groups = new Groups();
        groups.group_id = 1008;
        groups.group_name = com.tencent.biz.qqcircle.utils.h.a(R.string.f1906742q);
        map.put(groups, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(List<HostSelectMemberUtils.QCircleResultData> list, List<o20.c> list2) {
        H(list, list2, "follow_group");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(List<HostSelectMemberUtils.QCircleResultData> list, List<o20.c> list2) {
        Map<Groups, List<Friends>> groupFriendsMap = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getGroupFriendsMap(uq3.c.W1() + 1, true, null);
        if (groupFriendsMap != null && !groupFriendsMap.isEmpty()) {
            Iterator<Map.Entry<Groups, List<Friends>>> it = groupFriendsMap.entrySet().iterator();
            while (it.hasNext()) {
                for (Friends friends : it.next().getValue()) {
                    String str = friends.uin;
                    if (!M(list2, str)) {
                        o20.c cVar = new o20.c(o20.c.f421787h);
                        cVar.c(new QFSCommentAtEntity(str, null, friends.getFriendNickWithAlias(), 0));
                        cVar.d(O(list, str));
                        list2.add(cVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(List<o20.c> list) {
        list.add(new o20.c(o20.c.f421788i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(List<HostSelectMemberUtils.QCircleResultData> list, List<o20.c> list2) {
        H(list, list2, "mutual_group");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(List<HostSelectMemberUtils.QCircleResultData> list, List<o20.c> list2) {
        H(list, list2, "official_group");
    }

    private static void H(List<HostSelectMemberUtils.QCircleResultData> list, List<o20.c> list2, String str) {
        for (Map.Entry<GroupInfo, List<Entity>> entry : QCircleRelationGroupManager.instance().getFriendGroupMap().entrySet()) {
            if (TextUtils.equals(entry.getKey().getGroupId(), str)) {
                List<Entity> value = entry.getValue();
                if (RFSafeListUtils.isEmpty(value)) {
                    return;
                }
                for (Entity entity : value) {
                    if (entity instanceof FriendsWrapper) {
                        FriendsWrapper friendsWrapper = (FriendsWrapper) entity;
                        String str2 = friendsWrapper.uin;
                        if (!M(list2, str2)) {
                            o20.c cVar = new o20.c(o20.c.f421787h);
                            cVar.c(new QFSCommentAtEntity(str2, null, friendsWrapper.getFriendNickWithAlias(), friendsWrapper.authType));
                            cVar.d(O(list, str2));
                            list2.add(cVar);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(List<HostSelectMemberUtils.QCircleResultData> list, List<o20.c> list2) {
        ArrayList arrayList = new ArrayList();
        List<QFSCommentAtEntity> l06 = l0();
        if (RFSafeListUtils.getSize(l06) < 2) {
            return false;
        }
        R(list, l06, arrayList);
        if (RFSafeListUtils.getSize(arrayList) < 2) {
            return false;
        }
        o20.c cVar = new o20.c(o20.c.f421786g);
        cVar.i(arrayList);
        list2.add(cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static void J(List<HostSelectMemberUtils.QCircleResultData> list, List<o20.c> list2) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getRecentFriendsAsync(Integer.MAX_VALUE, true, null, new f(countDownLatch, list2, list));
        try {
            countDownLatch.await();
        } catch (InterruptedException e16) {
            RFWLog.fatal("QFSCommentAtHelper", RFWLog.USR, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(List<HostSelectMemberUtils.QCircleResultData> list, List<o20.c> list2) {
        for (QFSCommentAtEntity qFSCommentAtEntity : m0()) {
            String e16 = qFSCommentAtEntity.e();
            if (!M(list2, e16)) {
                o20.c cVar = new o20.c(o20.c.f421787h);
                cVar.c(qFSCommentAtEntity);
                list2.add(cVar);
                cVar.d(O(list, e16));
            }
        }
    }

    public static boolean L(String str) {
        List<String> list = f83470a;
        if (list.contains(str)) {
            return true;
        }
        list.add(str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean M(List<? extends o20.a> list, String str) {
        return N(list, str, 0);
    }

    public static boolean N(List<? extends o20.a> list, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            RFWLog.fatal("QFSCommentAtHelper", RFWLog.USR, new Throwable("uin invalid:" + str));
            return true;
        }
        for (o20.a aVar : list) {
            if (aVar.a() != null && TextUtils.equals(aVar.a().e(), str) && aVar.a().uinType == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean O(List<HostSelectMemberUtils.QCircleResultData> list, String str) {
        return P(list, str, 0);
    }

    public static boolean P(List<HostSelectMemberUtils.QCircleResultData> list, String str, int i3) {
        for (HostSelectMemberUtils.QCircleResultData qCircleResultData : list) {
            if (TextUtils.equals(qCircleResultData.uin, str) && qCircleResultData.uinType == i3) {
                return true;
            }
        }
        return false;
    }

    public static void Q() {
        f83470a.clear();
    }

    private static void R(List<? extends HostSelectMemberUtils.QCircleResultData> list, List<QFSCommentAtEntity> list2, List<QFSCommentAtEntity> list3) {
        for (QFSCommentAtEntity qFSCommentAtEntity : list2) {
            Iterator<? extends HostSelectMemberUtils.QCircleResultData> it = list.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().uin, qFSCommentAtEntity.e())) {
                    z16 = true;
                }
            }
            if (!z16) {
                list3.add(qFSCommentAtEntity);
            }
        }
    }

    public static void S(List<o20.c> list, String str) {
        Iterator<o20.c> it = list.iterator();
        while (it.hasNext()) {
            o20.c next = it.next();
            if (next.f() == o20.c.f421787h && TextUtils.equals(next.a().e(), str)) {
                it.remove();
            }
        }
    }

    public static void T(List<QFSCommentAtEntity> list, List<HostSelectMemberUtils.QCircleResultData> list2) {
        Iterator<QFSCommentAtEntity> it = list.iterator();
        while (it.hasNext()) {
            QFSCommentAtEntity next = it.next();
            Iterator<HostSelectMemberUtils.QCircleResultData> it5 = list2.iterator();
            while (it5.hasNext()) {
                if (TextUtils.equals(next.e(), it5.next().uin)) {
                    it.remove();
                }
            }
        }
    }

    public static void U(final Consumer<Map<Groups, List<QFSCommentAtEntity>>> consumer) {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper.5
            @Override // java.lang.Runnable
            public void run() {
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (!QFSCommentAtHelper.g0() && !QFSCommentAtHelper.h0()) {
                    QFSCommentAtHelper.z(linkedHashMap);
                    QFSCommentAtHelper.t(linkedHashMap);
                    QFSCommentAtHelper.u(linkedHashMap);
                    QFSCommentAtHelper.w(linkedHashMap);
                } else {
                    if (QFSCommentAtHelper.j0()) {
                        QFSCommentAtHelper.A(linkedHashMap);
                    } else {
                        QFSCommentAtHelper.z(linkedHashMap);
                    }
                    QFSCommentAtHelper.v(linkedHashMap);
                    QFSCommentAtHelper.t(linkedHashMap);
                    QFSCommentAtHelper.u(linkedHashMap);
                    QFSCommentAtHelper.w(linkedHashMap);
                }
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Consumer.this.accept(linkedHashMap);
                    }
                });
            }
        });
    }

    public static void V(String str, List<HostSelectMemberUtils.QCircleResultData> list, Consumer<List<o20.b>> consumer) {
        U(new g(str, list, consumer));
    }

    public static int W(int i3) {
        if (i3 != 1) {
            return 1;
        }
        return 4;
    }

    public static void X(View view, OnPromiseResolved<com.tencent.biz.qqcircle.comment.at.a> onPromiseResolved) {
        RFWIocAbilityProvider.g().getIoc(com.tencent.biz.qqcircle.comment.at.a.class).originView(view).done(new d(onPromiseResolved)).fail(new c()).run();
    }

    public static List<o20.c> Y() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 10; i3++) {
            arrayList.add(new o20.c(o20.c.f421789j));
        }
        return arrayList;
    }

    private static void Z(final String str, final List<HostSelectMemberUtils.QCircleResultData> list, final Consumer<List<o20.c>> consumer) {
        U(new Consumer<Map<Groups, List<QFSCommentAtEntity>>>() { // from class: com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper.1
            @Override // androidx.core.util.Consumer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Map<Groups, List<QFSCommentAtEntity>> map) {
                final ArrayList arrayList = new ArrayList();
                Iterator<List<QFSCommentAtEntity>> it = map.values().iterator();
                while (it.hasNext()) {
                    for (QFSCommentAtEntity qFSCommentAtEntity : it.next()) {
                        String str2 = qFSCommentAtEntity.uin;
                        if (!QFSCommentAtHelper.M(arrayList, str2)) {
                            String b16 = qFSCommentAtEntity.b();
                            if (!TextUtils.isEmpty(b16) && (str2.contains(str) || b16.contains(str))) {
                                o20.c cVar = new o20.c(o20.c.f421787h);
                                cVar.c(new QFSCommentAtEntity(str2, null, b16, 0));
                                cVar.d(QFSCommentAtHelper.O(list, str2));
                                cVar.h(true);
                                arrayList.add(cVar);
                            }
                        }
                    }
                }
                RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        consumer.accept(arrayList);
                    }
                }, 200L);
            }
        });
    }

    private static void a0(List<HostSelectMemberUtils.QCircleResultData> list, Consumer<List<o20.c>> consumer) {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new AnonymousClass2(list, consumer));
    }

    public static void b0(final Consumer<Map<Groups, List<QFSCommentAtEntity>>> consumer) {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper.6
            @Override // java.lang.Runnable
            public void run() {
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                QFSCommentAtHelper.y(linkedHashMap);
                QFSCommentAtHelper.B(linkedHashMap);
                QFSCommentAtHelper.u(linkedHashMap);
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Consumer.this.accept(linkedHashMap);
                    }
                });
            }
        });
    }

    public static void c0(String str, List<HostSelectMemberUtils.QCircleResultData> list, Consumer<List<o20.b>> consumer) {
        b0(new h(str, list, consumer));
    }

    private static void d0(String str, List<HostSelectMemberUtils.QCircleResultData> list, Consumer<List<o20.c>> consumer) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        QFSGetSearchPageRequest b16 = new QFSGetSearchPageRequest.a().l(str).j(1).k(arrayList).b();
        b16.setEnableCache(true);
        VSNetworkHelper.getInstance().sendRequest(b16, new AnonymousClass10(consumer, list));
    }

    public static void e0(String str, List<HostSelectMemberUtils.QCircleResultData> list, Consumer<List<o20.c>> consumer) {
        if (TextUtils.isEmpty(str)) {
            a0(list, consumer);
        } else if (uq3.c.l()) {
            d0(str, list, consumer);
        } else {
            Z(str, list, consumer);
        }
    }

    public static boolean f0() {
        return f83472c;
    }

    public static boolean g0() {
        return TextUtils.equals(k.a().h("key_at_exp_type", null), "1");
    }

    public static boolean h0() {
        return TextUtils.equals(k.a().h("key_at_exp_type", null), "2");
    }

    public static boolean i0() {
        return f83471b;
    }

    public static boolean j0() {
        if (k.a().e("sp_key_max_at_user_count", 0) < uq3.c.V1()) {
            return false;
        }
        return true;
    }

    @NonNull
    private static List<QFSCommentAtEntity> k0() {
        ArrayList arrayList = new ArrayList();
        String h16 = k.a().h("key_at_user_list", null);
        if (TextUtils.isEmpty(h16)) {
            return arrayList;
        }
        try {
            return (List) new Gson().fromJson(h16, new a().getType());
        } catch (Exception e16) {
            RFWLog.fatal("QFSCommentAtHelper", RFWLog.USR, e16);
            return arrayList;
        }
    }

    public static List<QFSCommentAtEntity> l0() {
        ArrayList arrayList = new ArrayList();
        String h16 = k.a().h("key_recent_at", null);
        if (TextUtils.isEmpty(h16)) {
            return arrayList;
        }
        try {
            return (List) new Gson().fromJson(h16, new e().getType());
        } catch (Exception e16) {
            RFWLog.fatal("QFSCommentAtHelper", RFWLog.USR, e16);
            return arrayList;
        }
    }

    @NonNull
    private static List<QFSCommentAtEntity> m0() {
        ArrayList arrayList = new ArrayList();
        String h16 = k.a().h("key_share_user_list", null);
        if (TextUtils.isEmpty(h16)) {
            return arrayList;
        }
        try {
            return (List) new Gson().fromJson(h16, new b().getType());
        } catch (Exception e16) {
            RFWLog.fatal("QFSCommentAtHelper", RFWLog.USR, e16);
            return arrayList;
        }
    }

    public static void n0(String str) {
        if (!TextUtils.equals(k.a().h("key_at_exp_type", null), str)) {
            QCircleRelationGroupManager.instance().loadRelationGroupData(0);
        }
        k.a().p("key_at_exp_type", str);
    }

    private static void o0(@NonNull List<HostSelectMemberUtils.QCircleResultData> list) {
        ArrayList arrayList = new ArrayList(list);
        List<QFSCommentAtEntity> k06 = k0();
        if (!RFSafeListUtils.isEmpty(k06)) {
            Iterator<QFSCommentAtEntity> it = k06.iterator();
            while (it.hasNext()) {
                QFSCommentAtEntity next = it.next();
                if (System.currentTimeMillis() - next.c() > 7776000000L || list.contains(next)) {
                    it.remove();
                }
            }
            arrayList.addAll(k06);
        }
        k.a().p("key_at_user_list", new Gson().toJson(arrayList));
        if (arrayList.size() > k.a().e("sp_key_max_at_user_count", 0)) {
            k.a().m("sp_key_max_at_user_count", arrayList.size());
        }
    }

    public static void p0(List<HostSelectMemberUtils.QCircleResultData> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        o0(list);
        k.a().p("key_recent_at", new Gson().toJson(list));
    }

    public static void q0(HostForwardUtils.ForwardInfoEntity forwardInfoEntity) {
        if (forwardInfoEntity != null && !TextUtils.isEmpty(forwardInfoEntity.getForwardUin()) && forwardInfoEntity.getForwardUinType() == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new QFSCommentAtEntity(forwardInfoEntity.getForwardUin(), null, forwardInfoEntity.getForwardName(), 0));
            List<QFSCommentAtEntity> m06 = m0();
            if (!RFSafeListUtils.isEmpty(m06)) {
                Iterator<QFSCommentAtEntity> it = m06.iterator();
                while (it.hasNext()) {
                    QFSCommentAtEntity next = it.next();
                    if (System.currentTimeMillis() - next.c() > 7776000000L || TextUtils.equals(next.e(), forwardInfoEntity.getForwardUin())) {
                        it.remove();
                    }
                }
                arrayList.addAll(m06);
            }
            k.a().p("key_share_user_list", new Gson().toJson(arrayList));
        }
    }

    public static void r0(boolean z16) {
        f83472c = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(List<HostSelectMemberUtils.QCircleResultData> list, List<o20.c> list2) {
        for (QFSCommentAtEntity qFSCommentAtEntity : k0()) {
            String e16 = qFSCommentAtEntity.e();
            if (!M(list2, e16)) {
                o20.c cVar = new o20.c(o20.c.f421787h);
                cVar.c(qFSCommentAtEntity);
                list2.add(cVar);
                cVar.d(O(list, e16));
            }
        }
    }

    public static void s0(boolean z16) {
        f83471b = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(Map<Groups, List<QFSCommentAtEntity>> map) {
        x(map, "follow_group");
    }

    public static void t0(String str, int i3, QCircleAvatarView qCircleAvatarView) {
        if (qCircleAvatarView != null && qCircleAvatarView.k() != null) {
            if (i3 == 1) {
                Bitmap troopFaceBitmap = ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).getTroopFaceBitmap(str);
                if (troopFaceBitmap == null) {
                    QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
                    qQProAvatarDrawable.q(qCircleAvatarView.getContext(), W(i3), str);
                    qCircleAvatarView.k().setImageDrawable(qQProAvatarDrawable);
                    return;
                }
                qCircleAvatarView.k().setImageDrawable(new BitmapDrawable(troopFaceBitmap));
                return;
            }
            qCircleAvatarView.k().setImageDrawable(QCirclePluginGlobalInfo.q(str, 1));
            return;
        }
        RFWLog.e("QFSCommentAtHelper", RFWLog.USR, "[setQQAvatar] avatarView is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(Map<Groups, List<QFSCommentAtEntity>> map) {
        Map<Groups, List<Friends>> groupFriendsMap = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getGroupFriendsMap(Integer.MAX_VALUE, true, null);
        if (groupFriendsMap != null && !groupFriendsMap.isEmpty()) {
            for (Map.Entry<Groups, List<Friends>> entry : groupFriendsMap.entrySet()) {
                ArrayList arrayList = new ArrayList();
                for (Friends friends : entry.getValue()) {
                    arrayList.add(new QFSCommentAtEntity(friends.uin, null, friends.getFriendNickWithAlias(), 0));
                }
                map.put(entry.getKey(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(Map<Groups, List<QFSCommentAtEntity>> map) {
        x(map, "mutual_group");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(Map<Groups, List<QFSCommentAtEntity>> map) {
        x(map, "official_group");
    }

    private static void x(Map<Groups, List<QFSCommentAtEntity>> map, String str) {
        for (Map.Entry<GroupInfo, List<Entity>> entry : QCircleRelationGroupManager.instance().getFriendGroupMap().entrySet()) {
            GroupInfo key = entry.getKey();
            if (TextUtils.equals(key.getGroupId(), str)) {
                List<Entity> value = entry.getValue();
                if (RFSafeListUtils.isEmpty(value)) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (Entity entity : value) {
                    if (entity instanceof FriendsWrapper) {
                        FriendsWrapper friendsWrapper = (FriendsWrapper) entity;
                        arrayList.add(new QFSCommentAtEntity(friendsWrapper.uin, null, friendsWrapper.getFriendNickWithAlias(), friendsWrapper.authType));
                    }
                }
                Groups groups = new Groups();
                groups.group_id = f83473d.get(str).intValue();
                groups.group_name = j.d(key.getGroupName());
                map.put(groups, arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(Map<Groups, List<QFSCommentAtEntity>> map) {
        List<RecentUser> recentListFromCache = ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentListFromCache();
        if (RFSafeListUtils.isEmpty(recentListFromCache)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : recentListFromCache) {
            String str = recentUser.uin;
            if (recentUser.type == 1) {
                str = recentUser.troopUin;
            }
            arrayList.add(new QFSCommentAtEntity(str, null, recentUser.displayName, 0, recentUser.type));
        }
        Groups groups = new Groups();
        groups.group_id = 1003;
        groups.group_name = com.tencent.biz.qqcircle.utils.h.a(R.string.f1906642p);
        map.put(groups, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(Map<Groups, List<QFSCommentAtEntity>> map) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getRecentFriendsAsync(Integer.MAX_VALUE, true, null, new i(countDownLatch, map));
        try {
            countDownLatch.await();
        } catch (InterruptedException e16) {
            RFWLog.fatal("QFSCommentAtHelper", RFWLog.USR, e16);
        }
    }
}
