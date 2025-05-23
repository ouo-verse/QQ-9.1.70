package com.tencent.mobileqq.search.business.contact;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bless.api.IBlessApi;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.fts.data.troop.TroopIndex;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$Friend;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qcircle.api.IQCircleFollowApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.ag;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.y;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.ntrelation.api.IFriendDataTransApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import com.tencent.util.NumberUtil;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import vd2.GroupInfo;
import wn2.f;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ContactSearchEngine implements on2.b<com.tencent.mobileqq.search.model.k> {
    private static final Comparator<com.tencent.mobileqq.search.model.k> Y = new a();
    private static final Comparator<RecentUser> Z = new b();
    private String C;
    protected int D;
    private String E;
    private Set<String> F;
    private long G;
    private long H;
    private long I;
    private int J;
    private g[] K;
    private long L;
    private long M;
    private long N;
    private long P;
    private ConcurrentHashMap<String, com.tencent.mobileqq.search.business.contact.entity.b> Q;
    private Queue<f> R;
    private Queue<f> S;
    private List<WeakReference<d>> T;
    private Object U;
    boolean V;
    private boolean W;
    private on2.d<com.tencent.mobileqq.search.model.k> X;

    /* renamed from: d, reason: collision with root package name */
    protected AppInterface f282844d;

    /* renamed from: e, reason: collision with root package name */
    private List<com.tencent.mobileqq.search.model.k> f282845e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, ArrayList<DiscussionMemberInfo>> f282846f;

    /* renamed from: h, reason: collision with root package name */
    private List<ArrayList<DiscussionMemberInfo>> f282847h;

    /* renamed from: i, reason: collision with root package name */
    private int f282848i;

    /* renamed from: m, reason: collision with root package name */
    private String f282849m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Comparator<com.tencent.mobileqq.search.model.k> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.search.model.k kVar, com.tencent.mobileqq.search.model.k kVar2) {
            int signum = Long.signum(kVar2.I() - kVar.I());
            if (signum == 0) {
                return ContactSearchEngine.k(kVar, kVar2);
            }
            return signum;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements Comparator<RecentUser> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(RecentUser recentUser, RecentUser recentUser2) {
            long j3 = recentUser2.lastmsgtime;
            long j16 = recentUser.lastmsgtime;
            if (j3 > j16) {
                return 1;
            }
            if (j3 < j16) {
                return -1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements RecentContactListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f282853a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f282854b;

        c(List list, CountDownLatch countDownLatch) {
            this.f282853a = list;
            this.f282854b = countDownLatch;
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(@NonNull List<RecentUser> list) {
            if (!list.isEmpty()) {
                this.f282853a.addAll(list);
            }
            this.f282854b.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        boolean f282855a;

        public d(boolean z16) {
            this.f282855a = z16;
        }

        public synchronized boolean a() {
            return this.f282855a;
        }

        public synchronized void b(boolean z16) {
            this.f282855a = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class e implements Comparator<com.tencent.mobileqq.search.model.k> {

        /* renamed from: d, reason: collision with root package name */
        private final List<com.tencent.mobileqq.search.model.k> f282857d;

        /* renamed from: e, reason: collision with root package name */
        private final List<MsgRecord> f282858e = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        private List<RecentContactInfo> f282859f;

        /* renamed from: h, reason: collision with root package name */
        private final AppInterface f282860h;

        e(AppInterface appInterface, List<com.tencent.mobileqq.search.model.k> list) {
            this.f282860h = appInterface;
            if (list == null) {
                this.f282857d = Collections.emptyList();
            } else {
                this.f282857d = list;
                i();
            }
        }

        private long c(com.tencent.mobileqq.search.model.k kVar) {
            int M = kVar.M();
            int i3 = 1;
            if (M != 0 && M != 1) {
                return 0L;
            }
            long stringToLong = NumberUtil.stringToLong(kVar.getUin());
            if (stringToLong == 0) {
                return 0L;
            }
            if (M != 0) {
                i3 = 2;
            }
            long e16 = e(stringToLong, i3);
            if (e16 == 0) {
                return d(stringToLong, i3);
            }
            return e16;
        }

        private long d(long j3, int i3) {
            if (this.f282859f == null) {
                h();
            }
            for (RecentContactInfo recentContactInfo : this.f282859f) {
                if (recentContactInfo.getChatType() == i3 && recentContactInfo.getPeerUin() == j3) {
                    return recentContactInfo.getMsgTime();
                }
            }
            return 0L;
        }

        private long e(long j3, int i3) {
            for (MsgRecord msgRecord : this.f282858e) {
                if (msgRecord.getChatType() == i3 && msgRecord.getPeerUin() == j3) {
                    return msgRecord.getMsgTime();
                }
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(CountDownLatch countDownLatch, int i3, String str, ArrayList arrayList) {
            this.f282858e.addAll(arrayList);
            countDownLatch.countDown();
        }

        @Nullable
        private static Contact g(IRelationNTUinAndUidApi iRelationNTUinAndUidApi, com.tencent.mobileqq.search.model.k kVar) {
            int M = kVar.M();
            int i3 = 1;
            if (M != 0 && M != 1) {
                QLog.d("ContactSearchEngine", 1, "#parseContact uinType=" + M + ", name=" + kVar.getTitle() + ", uin=" + kVar.getUin());
                return null;
            }
            long stringToLong = NumberUtil.stringToLong(kVar.getUin());
            if (stringToLong == 0) {
                QLog.d("ContactSearchEngine", 1, "#parseContact uinType=" + M + ", name=" + kVar.getTitle() + ", uin is 0");
                return null;
            }
            String valueOf = String.valueOf(stringToLong);
            if (M == 0) {
                valueOf = iRelationNTUinAndUidApi.getUidFromUin(valueOf);
            }
            if (TextUtils.isEmpty(valueOf)) {
                QLog.d("ContactSearchEngine", 1, "#parseContact fail to get uid, uinType=" + M + ", name=" + kVar.getTitle() + ", uin is 0");
                return null;
            }
            if (M != 0) {
                i3 = 2;
            }
            Contact contact = new Contact();
            contact.setChatType(i3);
            contact.setPeerUid(valueOf);
            return contact;
        }

        private void h() {
            aa recentContactService;
            AppInterface appInterface = this.f282860h;
            if (appInterface != null && (recentContactService = ((IKernelService) appInterface.getRuntimeService(IKernelService.class, "")).getRecentContactService()) != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f282859f = recentContactService.a();
                QLog.d("ContactSearchEngine", 1, "#queryLatestMsgFromBiz costTime=" + (System.currentTimeMillis() - currentTimeMillis));
            }
            if (this.f282859f == null) {
                this.f282859f = Collections.emptyList();
            }
        }

        private void i() {
            IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
            ArrayList<Contact> arrayList = new ArrayList<>();
            Iterator<com.tencent.mobileqq.search.model.k> it = this.f282857d.iterator();
            while (it.hasNext()) {
                Contact g16 = g(iRelationNTUinAndUidApi, it.next());
                if (g16 != null) {
                    arrayList.add(g16);
                }
            }
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null && !arrayList.isEmpty()) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                long currentTimeMillis = System.currentTimeMillis();
                e16.getLastMessageList(arrayList, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.search.business.contact.d
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                    public final void onResult(int i3, String str, ArrayList arrayList2) {
                        ContactSearchEngine.e.this.f(countDownLatch, i3, str, arrayList2);
                    }
                });
                try {
                    QLog.d("ContactSearchEngine", 1, "#queryLatestMsgFromNt costTime=" + (System.currentTimeMillis() - currentTimeMillis) + ", size=" + this.f282858e.size() + ", result=" + countDownLatch.await(2L, TimeUnit.SECONDS));
                } catch (InterruptedException e17) {
                    QLog.w("ContactSearchEngine", 1, "#queryLatestMsgFromNt: " + e17.getMessage(), e17);
                }
            }
        }

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.search.model.k kVar, com.tencent.mobileqq.search.model.k kVar2) {
            int signum = Long.signum(kVar2.I() - kVar.I());
            if (signum == 0) {
                signum = Long.signum(kVar2.J() - kVar.J());
            }
            if (signum == 0) {
                signum = Long.signum(c(kVar2) - c(kVar));
            }
            if (signum == 0) {
                return ContactSearchEngine.k(kVar, kVar2);
            }
            return signum;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        String f282861a;

        /* renamed from: b, reason: collision with root package name */
        List<com.tencent.mobileqq.search.model.k> f282862b;

        public f(String str, List<com.tencent.mobileqq.search.model.k> list) {
            this.f282861a = str;
            this.f282862b = list;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        int f282864a;

        /* renamed from: b, reason: collision with root package name */
        long f282865b;

        /* renamed from: c, reason: collision with root package name */
        int f282866c;

        /* renamed from: d, reason: collision with root package name */
        long f282867d;

        /* renamed from: e, reason: collision with root package name */
        String f282868e;

        public g(int i3, String str) {
            this.f282864a = i3;
            this.f282868e = str;
        }
    }

    public ContactSearchEngine(AppInterface appInterface, int i3, int i16, Set<String> set) {
        this(appInterface, i3, i16, null, set);
    }

    private void A(List<com.tencent.mobileqq.search.model.k> list) {
        List<RecentContactInfo> M;
        aa recentContactService = ((IKernelService) this.f282844d.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null || (M = recentContactService.M(4)) == null) {
            return;
        }
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) this.f282844d.getRuntimeService(IGameMsgBoxManager.class, "");
        ArrayList arrayList = new ArrayList();
        Iterator<RecentContactInfo> it = M.iterator();
        while (it.hasNext()) {
            String obtainConvertUinByPeerUid = iGameMsgBoxManager.obtainConvertUinByPeerUid(it.next().getPeerUid());
            gd1.a findGameDetailInfoByConvertUin = iGameMsgBoxManager.findGameDetailInfoByConvertUin(obtainConvertUinByPeerUid);
            if (findGameDetailInfoByConvertUin != null) {
                arrayList.add(new wn2.e(this.f282844d, this.D, r(obtainConvertUinByPeerUid), obtainConvertUinByPeerUid, findGameDetailInfoByConvertUin));
            }
        }
        list.addAll(arrayList);
    }

    private void B() {
        AppInterface appInterface = this.f282844d;
        if (appInterface == null) {
            return;
        }
        List<RecentUser> recentList = ((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().getRecentList(true, true, false);
        List<ag> troopAssistantSearchInfos = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getTroopAssistantSearchInfos(this.f282844d);
        if (recentList != null && troopAssistantSearchInfos != null) {
            int size = recentList.size();
            int size2 = troopAssistantSearchInfos.size();
            ArrayList arrayList = new ArrayList(size + size2);
            arrayList.addAll(recentList);
            for (int i3 = 0; i3 < size2; i3++) {
                RecentUser recentUser = new RecentUser();
                recentUser.uin = troopAssistantSearchInfos.get(i3).f282722a;
                recentUser.lastmsgtime = troopAssistantSearchInfos.get(i3).f282723b;
                arrayList.add(recentUser);
            }
            Collections.sort(arrayList, Z);
            int size3 = arrayList.size();
            for (int i16 = 0; i16 < size3 && i16 < 999; i16++) {
                RecentUser recentUser2 = (RecentUser) arrayList.get(i16);
                String str = recentUser2.uin;
                if (str != null) {
                    this.Q.put(str, new com.tencent.mobileqq.search.business.contact.entity.b(Integer.valueOf(999 - i16), Long.valueOf(recentUser2.lastmsgtime)));
                }
            }
        }
    }

    private boolean D() {
        if (!y.a() && (this.f282848i & 4) != 0) {
            return true;
        }
        return false;
    }

    private boolean E(String str) {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ContactSearchEngine");
    }

    private boolean F() {
        if (!y.a() && (131072 & this.f282848i) != 0) {
            return true;
        }
        return false;
    }

    private boolean G() {
        if (!y.a() && (4194304 & this.f282848i) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(List list, String str, long j3, CountDownLatch countDownLatch, boolean z16, List list2) {
        if (z16) {
            list.addAll(list2);
        }
        QLog.i("ContactSearchEngine", 1, "[getAllTroopMembers] groupCode=" + str + ", cost time=" + (System.currentTimeMillis() - j3));
        countDownLatch.countDown();
    }

    private void I(final Collection<wn2.c> collection) {
        if (collection.isEmpty()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.business.contact.ContactSearchEngine.5
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb5 = new StringBuilder();
                QLog.i("ContactSearchEngine", 1, "#printFriends: begin");
                Iterator it = collection.iterator();
                loop0: while (true) {
                    int i3 = 0;
                    while (it.hasNext()) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d S = ((wn2.c) it.next()).S();
                        if (S != null) {
                            sb5.append('(');
                            sb5.append(S.r());
                            sb5.append(',');
                            sb5.append(S.p());
                            sb5.append(',');
                            sb5.append(S.c());
                            sb5.append(')');
                            i3++;
                            if (i3 >= 50) {
                                break;
                            }
                        }
                    }
                    ContactSearchEngine.J("#printFriends: ", sb5.toString());
                    sb5.delete(0, sb5.length());
                }
                if (sb5.length() > 0) {
                    ContactSearchEngine.J("#printFriends: ", sb5.toString());
                }
                QLog.i("ContactSearchEngine", 1, "#printFriends: end");
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J(String str, String str2) {
        QLog.i("ContactSearchEngine", 1, str + PluginBaseInfoHelper.Base64Helper.encodeToString(str2.getBytes(StandardCharsets.UTF_8), 0));
    }

    private void K(final Collection<wn2.q> collection) {
        if (collection.isEmpty()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.business.contact.ContactSearchEngine.4
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb5 = new StringBuilder();
                QLog.i("ContactSearchEngine", 1, "#printTroopList: begin");
                loop0: while (true) {
                    int i3 = 0;
                    for (wn2.q qVar : collection) {
                        TroopInfo a16 = qVar.a();
                        if (a16 != null) {
                            sb5.append('[');
                            sb5.append(a16.getTroopUin());
                            sb5.append(',');
                            sb5.append(qVar.getTitle());
                            sb5.append(',');
                            sb5.append(a16.troopRemark);
                            sb5.append(',');
                            sb5.append(a16.isNewTroop);
                            sb5.append(']');
                            i3++;
                            if (i3 >= 50) {
                                break;
                            }
                        }
                    }
                    ContactSearchEngine.J("#printTroopList: ", sb5.toString());
                    sb5.delete(0, sb5.length());
                }
                if (sb5.length() > 0) {
                    ContactSearchEngine.J("#printTroopList: ", sb5.toString());
                }
                QLog.i("ContactSearchEngine", 1, "#printTroopList: end");
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.tencent.mobileqq.search.model.k> L(pn2.a aVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        List<com.tencent.mobileqq.search.model.k> list;
        d dVar = new d(false);
        synchronized (this.U) {
            this.T.add(new WeakReference<>(dVar));
        }
        this.f282849m = aVar.f426495a;
        Bundle bundle = aVar.f426496b;
        if (bundle != null) {
            z16 = bundle.getBoolean("searchRequestFromHome", false);
        } else {
            z16 = false;
        }
        String str = this.f282849m;
        List<com.tencent.mobileqq.search.model.k> list2 = null;
        if (dVar.a()) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + str);
            }
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        List<com.tencent.mobileqq.search.model.k> M = M(dVar);
        this.J = 0;
        if ((65536 & this.f282848i) == 0 && !F() && (2097152 & this.f282848i) == 0 && !G()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (M != null && z17 && z16) {
            HashSet hashSet = new HashSet();
            long j3 = com.tencent.mobileqq.search.j.f283435w + com.tencent.mobileqq.search.j.C + com.tencent.mobileqq.search.j.f283415d0;
            Iterator<com.tencent.mobileqq.search.model.k> it = M.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mobileqq.search.model.k next = it.next();
                if (dVar.a()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + str);
                    }
                    return list2;
                }
                if ((next instanceof wn2.a) || (next instanceof wn2.q)) {
                    this.J++;
                }
                if (next.I() > j3) {
                    hashSet.add(next.G());
                }
                if (hashSet.size() > 5 && !this.W) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ContactSearchEngine", 2, "searchContact no need to search troop member, keyword = " + str);
                    }
                    z17 = false;
                } else {
                    list2 = null;
                }
            }
        }
        if (dVar.a()) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + str);
                return null;
            }
            return null;
        }
        Bundle bundle2 = aVar.f426496b;
        if (bundle2 != null && bundle2.containsKey("searchTroopMember")) {
            z18 = aVar.f426496b.getBoolean("searchTroopMember");
        } else {
            z18 = true;
        }
        if (z17) {
            if (!z18 && (!this.W || !y.b())) {
                aVar.f426496b.putBoolean("searchTroopMember", true);
            } else {
                list = N(dVar);
                if (!dVar.a()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + str);
                        return null;
                    }
                    return null;
                }
                if (M != null) {
                    arrayList.addAll(M);
                }
                if (list != null) {
                    arrayList.addAll(list);
                }
                ArrayList arrayList2 = new ArrayList();
                if (l(arrayList, arrayList2, dVar, str)) {
                    return null;
                }
                ArrayList<com.tencent.mobileqq.search.model.k> arrayList3 = new ArrayList();
                int i3 = 0;
                for (com.tencent.mobileqq.search.model.k kVar : arrayList2) {
                    if (kVar instanceof wn2.f) {
                        i3++;
                        if (i3 <= 200) {
                            arrayList3.add(kVar);
                        }
                    } else {
                        arrayList3.add(kVar);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() troopCount:" + i3);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() type = " + this.C + " ; cost time : " + (currentTimeMillis2 - currentTimeMillis) + " ; size = " + arrayList3.size() + " ; keyword = " + str);
                    for (int i16 = 0; i16 < this.K.length; i16++) {
                        QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() type = " + this.K[i16].f282868e + " ; cost time : " + this.K[i16].f282867d + " ; size = " + this.K[i16].f282866c + " ; keyword = " + str);
                    }
                }
                this.G = currentTimeMillis2 - currentTimeMillis;
                this.H = arrayList3.size();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("result_size", String.valueOf(arrayList3.size()));
                for (int i17 = 0; i17 < 5; i17++) {
                    if (i17 < arrayList3.size()) {
                        hashMap.put("result_top_" + i17, String.valueOf(((com.tencent.mobileqq.search.model.k) arrayList3.get(i17)).I()));
                    } else {
                        hashMap.put("result_top_" + i17, "0");
                    }
                }
                this.V = false;
                for (com.tencent.mobileqq.search.model.k kVar2 : arrayList3) {
                    kVar2.V = hashMap;
                    if ("9970".equals(kVar2.getUin())) {
                        this.V = true;
                    }
                }
                return arrayList3;
            }
        }
        list = null;
        if (!dVar.a()) {
        }
    }

    private List<com.tencent.mobileqq.search.model.k> M(d dVar) {
        int i3 = 0;
        while (true) {
            g[] gVarArr = this.K;
            if (i3 >= gVarArr.length) {
                break;
            }
            if (!"global_troop_member".equals(Integer.valueOf(gVarArr[i3].f282864a))) {
                this.K[i3].f282867d = -1L;
            }
            i3++;
        }
        String str = this.f282849m;
        List<com.tencent.mobileqq.search.model.k> o16 = o(str, false);
        if (o16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactSearchEngine", 2, "searchContactWithoutTroopMember use cache, keyword = " + str);
            }
        } else {
            o16 = this.f282845e;
        }
        if (o16 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < o16.size(); i16++) {
            if (dVar.a()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ContactSearchEngine", 2, "searchContactWithoutTroopMember canceled, keyword = " + str);
                }
                return null;
            }
            com.tencent.mobileqq.search.model.k kVar = o16.get(i16);
            long nanoTime = System.nanoTime();
            synchronized (kVar) {
                kVar.O(str);
            }
            long nanoTime2 = System.nanoTime();
            int y16 = y(kVar);
            if (y16 != -1) {
                this.K[y16].f282867d += nanoTime2 - nanoTime;
            }
            if (kVar.I() != Long.MIN_VALUE) {
                arrayList.add(kVar);
            }
        }
        int i17 = 0;
        while (true) {
            g[] gVarArr2 = this.K;
            if (i17 < gVarArr2.length) {
                gVarArr2[i17].f282867d /= 1000000;
                i17++;
            } else {
                i(str, arrayList, false);
                return arrayList;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0392  */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<com.tencent.mobileqq.search.model.k> N(d dVar) {
        boolean z16;
        int i3;
        long j3;
        int i16;
        ArrayList arrayList;
        int i17;
        int i18;
        int i19;
        long j16;
        int i26;
        List<com.tencent.mobileqq.search.model.k> list = null;
        if ((this.f282848i & 65536) == 0 && !F() && (this.f282848i & 2097152) == 0 && !G()) {
            return null;
        }
        String str = this.f282849m;
        List<com.tencent.mobileqq.search.model.k> o16 = o(str, true);
        int i27 = 2;
        if (o16 != null && o16.size() < 100) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactSearchEngine", 2, "searchTroopMember use cache, keyword = " + str);
            }
        } else {
            ArrayList arrayList2 = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList3 = new ArrayList();
            if (dVar.a()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
                }
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            int x16 = x(131072);
            this.K[x16].f282867d = currentTimeMillis2 * 1000000;
            this.N = currentTimeMillis2;
            int size = arrayList3.size();
            if (QLog.isColorLevel()) {
                QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.TroopGlobalquery cost time : " + currentTimeMillis2 + "; size : " + size + "; keyWord: " + str);
            }
            if ((this.f282848i & 65536) == 0 && !F()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (arrayList3.size() > 0) {
                ArrayList arrayList4 = new ArrayList();
                int i28 = 0;
                while (i28 < arrayList3.size()) {
                    if (dVar.a()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
                        }
                        return list;
                    }
                    TroopIndex troopIndex = (TroopIndex) arrayList3.get(i28);
                    if (SearchUtils.x0(this.f282844d, String.valueOf(troopIndex.mTroopUin)) != GroupMsgMask.SHIELD) {
                        if (z16) {
                            arrayList4.add(troopIndex);
                        } else if (w(String.valueOf(troopIndex.mTroopUin)).isNewTroop()) {
                            arrayList4.add(troopIndex);
                        }
                    }
                    i28++;
                    list = null;
                }
                if (arrayList4.size() > 0) {
                    if (!F() && !G()) {
                        i3 = size;
                        j3 = currentTimeMillis2;
                        i16 = x16;
                        arrayList = arrayList2;
                        i18 = 0;
                        i17 = 0;
                    } else {
                        ArrayList arrayList5 = new ArrayList();
                        this.f282844d.getCurrentAccountUin();
                        int i29 = 0;
                        while (i29 < arrayList4.size()) {
                            if (dVar.a()) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("ContactSearchEngine", i27, "searchTroopMember canceled, keyword = " + str);
                                    return null;
                                }
                                return null;
                            }
                            TroopIndex troopIndex2 = (TroopIndex) arrayList4.get(i29);
                            if (!"50000000".equals(troopIndex2.mMemberUin)) {
                                if (TextUtils.isEmpty(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(troopIndex2.mMemberUin))) {
                                    QLog.d("ContactSearchEngine", 1, "#searchTroopMember: no uid for " + troopIndex2.mMemberName);
                                } else {
                                    if (!w(String.valueOf(troopIndex2.mTroopUin)).isNewTroop()) {
                                        i19 = size;
                                        i26 = x16;
                                        j16 = currentTimeMillis2;
                                        arrayList5.add(new wn2.g(this.f282844d, this.D, troopIndex2.mTroopUin, troopIndex2.mMemberUin, troopIndex2.mMemberCard, troopIndex2.mMemberName, troopIndex2.mMemberNick));
                                    } else {
                                        i19 = size;
                                        j16 = currentTimeMillis2;
                                        i26 = x16;
                                        arrayList5.add(new wn2.j(this.f282844d, this.D, troopIndex2.mTroopUin, troopIndex2.mMemberUin, troopIndex2.mMemberCard, troopIndex2.mMemberName, troopIndex2.mMemberNick));
                                    }
                                    i29++;
                                    size = i19;
                                    x16 = i26;
                                    currentTimeMillis2 = j16;
                                    i27 = 2;
                                }
                            }
                            i19 = size;
                            j16 = currentTimeMillis2;
                            i26 = x16;
                            i29++;
                            size = i19;
                            x16 = i26;
                            currentTimeMillis2 = j16;
                            i27 = 2;
                        }
                        i3 = size;
                        j3 = currentTimeMillis2;
                        i16 = x16;
                        arrayList = arrayList2;
                        arrayList.addAll(arrayList5);
                        i18 = 0;
                        i17 = 0 + arrayList5.size();
                    }
                    int i36 = this.f282848i;
                    if ((65536 & i36) != 0 || (i36 & 2097152) != 0) {
                        ArrayList arrayList6 = new ArrayList();
                        HashMap hashMap = new HashMap();
                        for (int i37 = i18; i37 < arrayList4.size(); i37++) {
                            if (dVar.a()) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
                                    return null;
                                }
                                return null;
                            }
                            TroopIndex troopIndex3 = (TroopIndex) arrayList4.get(i37);
                            f.b bVar = new f.b(troopIndex3.mMemberCard, troopIndex3.mMemberName, troopIndex3.mMemberUin, troopIndex3.mMemberNick);
                            if (!hashMap.containsKey(troopIndex3.mTroopUin)) {
                                ArrayList arrayList7 = new ArrayList();
                                arrayList7.add(bVar);
                                hashMap.put(troopIndex3.mTroopUin, arrayList7);
                            } else {
                                ArrayList arrayList8 = (ArrayList) hashMap.get(troopIndex3.mTroopUin);
                                arrayList8.add(bVar);
                                hashMap.put(troopIndex3.mTroopUin, arrayList8);
                            }
                        }
                        for (String str2 : hashMap.keySet()) {
                            if (!w(String.valueOf(str2)).isNewTroop()) {
                                arrayList6.add(new wn2.f(this.f282844d, this.D, str2, (List) hashMap.get(str2), r(r7.troopuin)));
                            } else {
                                arrayList6.add(new wn2.i(this.f282844d, this.D, str2, (List) hashMap.get(str2), r(r7.troopuin)));
                            }
                        }
                        arrayList.addAll(arrayList6);
                        i17 += arrayList6.size();
                    }
                    long currentTimeMillis3 = (System.currentTimeMillis() - currentTimeMillis) - j3;
                    g gVar = this.K[i16];
                    gVar.f282866c = i17;
                    gVar.f282865b = currentTimeMillis3;
                    this.P = System.currentTimeMillis() - currentTimeMillis;
                    this.L = i3;
                    if (QLog.isColorLevel()) {
                        QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.troopGlobalDataProcess cost time : " + currentTimeMillis3 + "; size : " + i17 + "; keyWord: " + str);
                    }
                    o16 = arrayList;
                }
            }
            i3 = size;
            j3 = currentTimeMillis2;
            i16 = x16;
            arrayList = arrayList2;
            i17 = 0;
            long currentTimeMillis32 = (System.currentTimeMillis() - currentTimeMillis) - j3;
            g gVar2 = this.K[i16];
            gVar2.f282866c = i17;
            gVar2.f282865b = currentTimeMillis32;
            this.P = System.currentTimeMillis() - currentTimeMillis;
            this.L = i3;
            if (QLog.isColorLevel()) {
            }
            o16 = arrayList;
        }
        ArrayList arrayList9 = new ArrayList();
        for (int i38 = 0; i38 < o16.size(); i38++) {
            if (dVar.a()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
                    return null;
                }
                return null;
            }
            com.tencent.mobileqq.search.model.k kVar = o16.get(i38);
            synchronized (kVar) {
                kVar.O(str);
            }
            if (kVar.I() != Long.MIN_VALUE) {
                arrayList9.add(kVar);
            }
        }
        if (arrayList9.size() < 100) {
            i(str, arrayList9, true);
        }
        return arrayList9;
    }

    private List<com.tencent.mobileqq.search.model.k> O(pn2.a aVar) {
        d dVar = new d(false);
        synchronized (this.U) {
            this.T.add(new WeakReference<>(dVar));
        }
        this.f282849m = aVar.f426495a;
        return N(dVar);
    }

    private void i(String str, List<com.tencent.mobileqq.search.model.k> list, boolean z16) {
        Queue<f> queue;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && !str.trim().contains(" ") && list != null) {
                if (z16) {
                    queue = this.S;
                } else {
                    queue = this.R;
                }
                while (queue.size() > 2) {
                    queue.poll();
                }
                if (queue.size() == 2) {
                    if (!list.isEmpty()) {
                        queue.poll();
                    } else {
                        Iterator<f> it = queue.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            f next = it.next();
                            if (next.f282862b.isEmpty()) {
                                queue.remove(next);
                                break;
                            }
                        }
                        if (queue.size() == 2) {
                            queue.poll();
                        }
                    }
                }
                queue.add(new f(str, list));
            }
        }
    }

    private void j(List<com.tencent.mobileqq.search.model.k> list) {
        List<Entity> value;
        Map<GroupInfo, List<Entity>> circleFriendMap = ((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).getCircleFriendMap();
        if (circleFriendMap != null && !circleFriendMap.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<GroupInfo, List<Entity>> entry : circleFriendMap.entrySet()) {
                GroupInfo key = entry.getKey();
                if (TextUtils.equals("mutual_group", key.getGroupId()) && (value = entry.getValue()) != null && !value.isEmpty()) {
                    for (Entity entity : value) {
                        if (entity instanceof Friends) {
                            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendConvertToFriendsSimpleInfo = ((IFriendDataTransApi) QRoute.api(IFriendDataTransApi.class)).friendConvertToFriendsSimpleInfo((Friends) entity, null);
                            arrayList.add(new wn2.c(this.f282844d, this.D, friendConvertToFriendsSimpleInfo, key.getGroupName(), s(friendConvertToFriendsSimpleInfo.x())));
                        }
                    }
                }
            }
            list.addAll(arrayList);
            return;
        }
        QLog.d("ContactSearchEngine", 1, "[addCircleFriendGroupList] current result is empty.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(com.tencent.mobileqq.search.model.k kVar, com.tencent.mobileqq.search.model.k kVar2) {
        int i3;
        if (kVar2.getTitle() != null && kVar.getTitle() != null) {
            i3 = kVar2.getTitle().toString().compareTo(kVar.getTitle().toString());
        } else {
            i3 = 0;
        }
        if (i3 == 0 && kVar2.K() != null && kVar.K() != null) {
            return kVar2.K().toString().compareTo(kVar.K().toString());
        }
        return i3;
    }

    @Deprecated
    private static List<TroopMemberInfo> n(final String str) {
        final ArrayList arrayList = new ArrayList();
        final long currentTimeMillis = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberListWithExtInfo(str, null, false, "ContactSearchEngine", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.search.business.contact.c
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z16, List list) {
                ContactSearchEngine.H(arrayList, str, currentTimeMillis, countDownLatch, z16, list);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e16) {
            QLog.e("ContactSearchEngine", 1, "[getAllTroopMembers] error:" + e16.getMessage());
        }
        return arrayList;
    }

    private List<com.tencent.mobileqq.search.model.k> o(String str, boolean z16) {
        Queue<f> queue;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && !str.trim().contains(" ")) {
                if (z16) {
                    queue = this.S;
                } else {
                    queue = this.R;
                }
                int i3 = Integer.MIN_VALUE;
                f fVar = null;
                for (f fVar2 : queue) {
                    if (str.startsWith(fVar2.f282861a) && fVar2.f282861a.length() > i3) {
                        i3 = fVar2.f282861a.length();
                        fVar = fVar2;
                    }
                }
                if (fVar != null && fVar.f282862b != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ContactSearchEngine", 2, "getBestCache hit cache, cur keyword = " + str + " , cache keyword = " + fVar.f282861a + " , cache size = " + fVar.f282862b.size());
                    }
                    return fVar.f282862b;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ContactSearchEngine", 2, "getBestCache miss cache, cur keyword = " + str);
                }
                return null;
            }
            return null;
        }
    }

    private List<ArrayList<DiscussionMemberInfo>> p() {
        z();
        return this.f282847h;
    }

    private Map<String, ArrayList<DiscussionMemberInfo>> q() {
        z();
        return this.f282846f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mobileqq.search.business.contact.entity.b s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Q.get(str);
    }

    private static List<RecentUser> t() {
        ArrayList arrayList = new ArrayList();
        List<RecentUser> recentListFromCache = ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentListFromCache();
        if (recentListFromCache != null && !recentListFromCache.isEmpty()) {
            QLog.d("ContactSearchEngine", 1, "#getRecentUserList: get from cache");
            arrayList.addAll(recentListFromCache);
        } else {
            QLog.d("ContactSearchEngine", 1, "#getRecentUserList: get from db");
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(MobileQQ.sMobileQQ.peekAppRuntime(), new c(arrayList, countDownLatch), false);
            try {
                countDownLatch.await(2L, TimeUnit.SECONDS);
            } catch (InterruptedException e16) {
                QLog.e("ContactSearchEngine", 1, e16, new Object[0]);
            }
        }
        QLog.d("ContactSearchEngine", 1, "#getRecentUserList: size=" + arrayList.size());
        return arrayList;
    }

    public static int x(int i3) {
        if (i3 != 1) {
            if (i3 != 4) {
                if (i3 != 8) {
                    if (i3 == 16) {
                        return 4;
                    }
                    if (i3 != 32) {
                        if (i3 == 768) {
                            return 1;
                        }
                        if (i3 != 2048) {
                            if (i3 == 131072) {
                                return 8;
                            }
                            if (i3 != 8388608) {
                                if (i3 != 16777216) {
                                    return -1;
                                }
                                return 10;
                            }
                            return 9;
                        }
                        return 7;
                    }
                    return 5;
                }
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public static int y(com.tencent.mobileqq.search.model.k kVar) {
        if (kVar instanceof wn2.c) {
            return 0;
        }
        if (kVar instanceof wn2.m) {
            return 1;
        }
        if (kVar instanceof wn2.b) {
            return 2;
        }
        if (kVar instanceof wn2.a) {
            return 3;
        }
        if (kVar instanceof wn2.q) {
            return 4;
        }
        if (kVar instanceof wn2.n) {
            return 5;
        }
        return -1;
    }

    private synchronized void z() {
        String str;
        if (this.f282846f == null) {
            ArrayList<DiscussionInfo> arrayList = (ArrayList) ((IDiscussionService) this.f282844d.getRuntimeService(IDiscussionService.class, "")).getDiscussList();
            int size = arrayList.size();
            String[] strArr = new String[size];
            int i3 = 0;
            for (DiscussionInfo discussionInfo : arrayList) {
                if (discussionInfo != null && (str = discussionInfo.uin) != null && str.length() > 0) {
                    strArr[i3] = discussionInfo.uin;
                    i3++;
                }
            }
            Map<String, ArrayList<DiscussionMemberInfo>> map = (Map) ((IDiscussionService) this.f282844d.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberMapByUins(strArr);
            ArrayList arrayList2 = new ArrayList(size);
            for (int i16 = 0; i16 < size; i16++) {
                arrayList2.add(map.get(strArr[i16]));
            }
            this.f282846f = map;
            this.f282847h = arrayList2;
        }
    }

    protected List<com.tencent.mobileqq.search.model.k> C(int i3) {
        Class<ISearchPieceFetcher> cls;
        String str;
        String str2;
        int i16;
        List<com.tencent.mobileqq.search.model.k> list;
        com.tencent.mobileqq.search.model.y rVar;
        List<ArrayList<DiscussionMemberInfo>> list2;
        List<PhoneContact> contactListForSelector;
        List<PhoneContact> contactListForPhoneSelector;
        List<List<PhoneContact>> contactListForDisplay;
        List<PhoneContact> list3;
        List<List<PhoneContact>> contactListForDisplay2;
        ISearchPieceFetcher iSearchPieceFetcher;
        Class<ISearchPieceFetcher> cls2;
        String str3;
        String str4;
        String d16;
        int i17 = 0;
        while (true) {
            g[] gVarArr = this.K;
            if (i17 >= gVarArr.length) {
                break;
            }
            g gVar = gVarArr[i17];
            gVar.f282866c = 0;
            gVar.f282865b = 0L;
            i17++;
        }
        B();
        List<com.tencent.mobileqq.search.model.k> arrayList = new ArrayList<>();
        if ((i3 & 32) != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList2 = new ArrayList();
            List<RecentUser> t16 = t();
            if (t16 != null) {
                for (RecentUser recentUser : t16) {
                    if (!TextUtils.isEmpty(recentUser.uin) && !"50000000".equals(recentUser.uin)) {
                        int type = recentUser.getType();
                        if (type != 1000) {
                            switch (type) {
                            }
                        }
                        if (!E(recentUser.uin)) {
                            arrayList2.add(new wn2.n(this.f282844d, this.D, recentUser, r(recentUser.uin)));
                        }
                    }
                }
            }
            arrayList.addAll(arrayList2);
            long currentTimeMillis2 = System.currentTimeMillis();
            g gVar2 = this.K[x(32)];
            gVar2.f282865b = currentTimeMillis2 - currentTimeMillis;
            gVar2.f282866c = arrayList2.size();
        }
        Class<ISearchPieceFetcher> cls3 = ISearchPieceFetcher.class;
        String str5 = "";
        if ((i3 & 1) != 0) {
            long currentTimeMillis3 = System.currentTimeMillis();
            ISearchPieceFetcher iSearchPieceFetcher2 = (ISearchPieceFetcher) QRoute.api(cls3);
            Map<Integer, com.tencent.qqnt.ntrelation.friendsinfo.bean.a> m16 = SearchUtils.m1();
            List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> s16 = SearchUtils.s();
            String string = MobileQQ.sMobileQQ.getApplicationContext().getResources().getString(R.string.f173238ia0);
            ArrayList arrayList3 = new ArrayList(s16.size());
            ArrayList arrayList4 = new ArrayList(s16.size());
            Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it = s16.iterator();
            while (it.hasNext()) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d next = it.next();
                Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it5 = it;
                if (iSearchPieceFetcher2.filterQidianMasterSearch(this.f282844d, next, this.D)) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.a aVar = m16.get(Integer.valueOf(next.f()));
                    arrayList4.add(next.getUid());
                    iSearchPieceFetcher = iSearchPieceFetcher2;
                    AppInterface appInterface = this.f282844d;
                    str4 = string;
                    int i18 = this.D;
                    cls2 = cls3;
                    str3 = str5;
                    if (next.n().byteValue() == 1) {
                        d16 = str4;
                    } else {
                        d16 = aVar != null ? aVar.d() : str3;
                    }
                    arrayList3.add(new wn2.c(appInterface, i18, next, d16, s(next.x())));
                } else {
                    iSearchPieceFetcher = iSearchPieceFetcher2;
                    cls2 = cls3;
                    str3 = str5;
                    str4 = string;
                }
                it = it5;
                iSearchPieceFetcher2 = iSearchPieceFetcher;
                string = str4;
                cls3 = cls2;
                str5 = str3;
            }
            cls = cls3;
            str = str5;
            com.tencent.mobileqq.search.business.contact.e.a(this.f282844d, this.D, arrayList3, m16, new Function1() { // from class: com.tencent.mobileqq.search.business.contact.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    com.tencent.mobileqq.search.business.contact.entity.b s17;
                    s17 = ContactSearchEngine.this.s((String) obj);
                    return s17;
                }
            });
            I(arrayList3);
            arrayList.addAll(arrayList3);
            SearchUtils.y(arrayList4, arrayList3);
            long currentTimeMillis4 = System.currentTimeMillis();
            g gVar3 = this.K[x(1)];
            gVar3.f282865b = currentTimeMillis4 - currentTimeMillis3;
            gVar3.f282866c = arrayList3.size();
            QLog.i("ContactSearchEngine", 1, "FriendCost: " + (System.currentTimeMillis() - currentTimeMillis3) + " ms");
        } else {
            cls = cls3;
            str = "";
        }
        if ((33554432 & i3) != 0) {
            try {
                A(arrayList);
            } catch (Exception e16) {
                QLog.e("ContactSearchEngine", 1, e16, new Object[0]);
            }
        }
        if ((134217728 & i3) != 0) {
            ArrayList arrayList5 = new ArrayList();
            List<GameFriendSelectorSvr$Friend> gameFriendsInfo = ((IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class)).getGameFriendsInfo();
            if (gameFriendsInfo != null && gameFriendsInfo.size() > 0) {
                Iterator<GameFriendSelectorSvr$Friend> it6 = gameFriendsInfo.iterator();
                while (it6.hasNext()) {
                    arrayList5.add(new wn2.d(this.f282844d, this.D, r(r12.f213219id.get()), it6.next()));
                }
            }
            arrayList.addAll(arrayList5);
        }
        if ((8388608 & i3) != 0) {
            j(arrayList);
        }
        if ((i3 & 256) != 0) {
            long currentTimeMillis5 = System.currentTimeMillis();
            ArrayList arrayList6 = new ArrayList();
            str2 = str;
            IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f282844d.getRuntimeService(IPhoneContactService.class, str2);
            if (iPhoneContactService == null || (contactListForDisplay2 = iPhoneContactService.getContactListForDisplay()) == null || contactListForDisplay2.size() <= 0) {
                i16 = 0;
            } else {
                i16 = 0;
                List<PhoneContact> list4 = contactListForDisplay2.get(0);
                if (list4 != null) {
                    Iterator<PhoneContact> it7 = list4.iterator();
                    while (it7.hasNext()) {
                        arrayList6.add(new wn2.m(this.f282844d, this.D, it7.next()));
                    }
                }
            }
            arrayList.addAll(arrayList6);
            long currentTimeMillis6 = System.currentTimeMillis();
            g gVar4 = this.K[x(768)];
            gVar4.f282865b = currentTimeMillis6 - currentTimeMillis5;
            gVar4.f282866c = arrayList6.size();
        } else {
            str2 = str;
            i16 = 0;
        }
        if ((i3 & 512) != 0) {
            long currentTimeMillis7 = System.currentTimeMillis();
            ArrayList arrayList7 = new ArrayList();
            IPhoneContactService iPhoneContactService2 = (IPhoneContactService) this.f282844d.getRuntimeService(IPhoneContactService.class, str2);
            if (iPhoneContactService2 != null && (contactListForDisplay = iPhoneContactService2.getContactListForDisplay()) != null && contactListForDisplay.size() > 1 && (list3 = contactListForDisplay.get(1)) != null) {
                Iterator<PhoneContact> it8 = list3.iterator();
                while (it8.hasNext()) {
                    arrayList7.add(new wn2.m(this.f282844d, this.D, it8.next()));
                }
            }
            arrayList.addAll(arrayList7);
            long currentTimeMillis8 = System.currentTimeMillis();
            g gVar5 = this.K[x(768)];
            gVar5.f282865b = currentTimeMillis8 - currentTimeMillis7;
            gVar5.f282866c = arrayList7.size();
        }
        if ((i3 & 16384) != 0) {
            long currentTimeMillis9 = System.currentTimeMillis();
            ArrayList arrayList8 = new ArrayList();
            IPhoneContactService iPhoneContactService3 = (IPhoneContactService) this.f282844d.getRuntimeService(IPhoneContactService.class, str2);
            if (iPhoneContactService3 != null && (contactListForPhoneSelector = iPhoneContactService3.getContactListForPhoneSelector()) != null) {
                Iterator<PhoneContact> it9 = contactListForPhoneSelector.iterator();
                while (it9.hasNext()) {
                    arrayList8.add(new wn2.m(this.f282844d, this.D, it9.next()));
                }
            }
            arrayList.addAll(arrayList8);
            long currentTimeMillis10 = System.currentTimeMillis();
            g gVar6 = this.K[x(768)];
            gVar6.f282865b = currentTimeMillis10 - currentTimeMillis9;
            gVar6.f282866c = arrayList8.size();
        }
        if ((32768 & i3) != 0) {
            long currentTimeMillis11 = System.currentTimeMillis();
            ArrayList arrayList9 = new ArrayList();
            IPhoneContactService iPhoneContactService4 = (IPhoneContactService) this.f282844d.getRuntimeService(IPhoneContactService.class, str2);
            if (iPhoneContactService4 != null && (contactListForSelector = iPhoneContactService4.getContactListForSelector()) != null) {
                Iterator<PhoneContact> it10 = contactListForSelector.iterator();
                while (it10.hasNext()) {
                    arrayList9.add(new wn2.m(this.f282844d, this.D, it10.next()));
                }
            }
            arrayList.addAll(arrayList9);
            long currentTimeMillis12 = System.currentTimeMillis();
            g gVar7 = this.K[x(768)];
            gVar7.f282865b = currentTimeMillis12 - currentTimeMillis11;
            gVar7.f282866c = arrayList9.size();
        }
        if (D()) {
            long currentTimeMillis13 = System.currentTimeMillis();
            ArrayList arrayList10 = new ArrayList();
            List<ArrayList<DiscussionMemberInfo>> p16 = p();
            HashSet hashSet = new HashSet();
            this.f282844d.getCurrentAccountUin();
            int i19 = i16;
            while (i19 < p16.size()) {
                int i26 = i16;
                while (i26 < p16.get(i19).size()) {
                    DiscussionMemberInfo discussionMemberInfo = p16.get(i19).get(i26);
                    String str6 = discussionMemberInfo.memberUin + discussionMemberInfo.inteRemark + discussionMemberInfo.memberName;
                    if (hashSet.contains(str6) || E(discussionMemberInfo.memberUin)) {
                        list2 = p16;
                    } else {
                        hashSet.add(str6);
                        list2 = p16;
                        arrayList10.add(new wn2.b(this.f282844d, this.D, discussionMemberInfo));
                    }
                    i26++;
                    p16 = list2;
                }
                i19++;
                i16 = 0;
            }
            arrayList.addAll(arrayList10);
            long currentTimeMillis14 = System.currentTimeMillis();
            g gVar8 = this.K[x(4)];
            gVar8.f282865b = currentTimeMillis14 - currentTimeMillis13;
            gVar8.f282866c = arrayList10.size();
        }
        if ((i3 & 8) != 0) {
            long currentTimeMillis15 = System.currentTimeMillis();
            ArrayList arrayList11 = new ArrayList();
            ArrayList<DiscussionInfo> arrayList12 = (ArrayList) ((IDiscussionService) this.f282844d.getRuntimeService(IDiscussionService.class, str2)).getDiscussList();
            if (arrayList12 != null) {
                for (DiscussionInfo discussionInfo : arrayList12) {
                    Map<String, ArrayList<DiscussionMemberInfo>> q16 = q();
                    arrayList11.add(new wn2.a(this.f282844d, this.D, discussionInfo, q16 != null ? q16.get(discussionInfo.uin) : null, r(discussionInfo.uin)));
                }
            }
            arrayList.addAll(arrayList11);
            long currentTimeMillis16 = System.currentTimeMillis();
            g gVar9 = this.K[x(8)];
            gVar9.f282865b = currentTimeMillis16 - currentTimeMillis15;
            gVar9.f282866c = arrayList11.size();
        }
        if ((i3 & 16) != 0) {
            long currentTimeMillis17 = System.currentTimeMillis();
            ArrayList arrayList13 = new ArrayList();
            ((ISearchPieceFetcher) QRoute.api(cls)).initAssistTroopCache(this.f282844d);
            List<TroopInfo> joinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache();
            if (joinedTroopInfoFromCache != null) {
                Iterator<TroopInfo> it11 = joinedTroopInfoFromCache.iterator();
                while (it11.hasNext()) {
                    arrayList13.add(new wn2.q(this.f282844d, this.D, it11.next(), r(r11.troopuin)));
                    arrayList = arrayList;
                }
            }
            list = arrayList;
            list.addAll(arrayList13);
            long currentTimeMillis18 = System.currentTimeMillis();
            g gVar10 = this.K[x(16)];
            gVar10.f282865b = currentTimeMillis18 - currentTimeMillis17;
            gVar10.f282866c = arrayList13.size();
            K(arrayList13);
        } else {
            list = arrayList;
        }
        if ((i3 & 64) != 0) {
            ArrayList arrayList14 = new ArrayList();
            arrayList14.add(new wn2.p(this.f282844d, this.D, String.valueOf(AppConstants.DATALINE_PC_UIN_LONGVALUE), 6000, r(String.valueOf(AppConstants.DATALINE_PC_UIN_LONGVALUE))));
            arrayList14.add(new wn2.p(this.f282844d, this.D, String.valueOf(9973L), 9002, r(String.valueOf(9973L))));
            arrayList14.add(new wn2.p(this.f282844d, this.D, String.valueOf(AppConstants.EC_SHOP_ASSISTANT_UIN_LONGVALUE), AppConstants.VALUE.UIN_TYPE_EC_SHOP_ASSIST, r(String.valueOf(AppConstants.EC_SHOP_ASSISTANT_UIN_LONGVALUE))));
            arrayList14.add(new wn2.p(this.f282844d, this.D, AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, AppConstants.VALUE.UIN_TYPE_SERVICE_ACCOUNT_FOLDER, r(String.valueOf(r31))));
            arrayList14.add(new wn2.p(this.f282844d, this.D, String.valueOf(AppConstants.TROOP_NOTIFICATION_UIN_LONGVALUE), 9000, r(String.valueOf(AppConstants.TROOP_NOTIFICATION_UIN_LONGVALUE))));
            arrayList14.add(new wn2.p(this.f282844d, this.D, String.valueOf(AppConstants.TROOP_ASSISTANT_UIN_LONGVALUE), 5000, r(String.valueOf(AppConstants.TROOP_ASSISTANT_UIN_LONGVALUE))));
            arrayList14.add(new wn2.p(this.f282844d, this.D, String.valueOf(AppConstants.SUBACCOUNT_ASSISTANT_UIN_LONGVALUE), 7000, r(String.valueOf(AppConstants.SUBACCOUNT_ASSISTANT_UIN_LONGVALUE))));
            if (((IBlessApi) QRoute.api(IBlessApi.class)).isSearchable(this.f282844d)) {
                arrayList14.add(new wn2.p(this.f282844d, this.D, String.valueOf(AppConstants.SEND_BLESS_UIN_LONGVALUE), 9003, r(String.valueOf(AppConstants.SEND_BLESS_UIN_LONGVALUE))));
                if (QLog.isColorLevel()) {
                    QLog.d("ContactSearchEngine", 2, "Bless model is added.");
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("ContactSearchEngine", 2, "Bless model is not added.");
            }
            arrayList14.add(new wn2.p(this.f282844d, this.D, String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN), 4000, r(String.valueOf(r8))));
            List<RecentUser> recentList = ((IRecentUserProxyService) this.f282844d.getRuntimeService(IRecentUserProxyService.class, str2)).getRecentUserCache().getRecentList(true);
            if (recentList != null) {
                for (RecentUser recentUser2 : recentList) {
                    int type2 = recentUser2.getType();
                    if (type2 == 1001 || type2 == 5000 || type2 == 7000 || type2 == 7120 || type2 == 7230 || type2 == 9000 || type2 == 10002 || type2 == 10004) {
                        if (!TextUtils.isEmpty(recentUser2.uin)) {
                            arrayList14.add(new wn2.p(this.f282844d, this.D, recentUser2.uin, recentUser2.getType(), r(recentUser2.uin)));
                        }
                    }
                }
            }
            list.addAll(arrayList14);
        }
        if ((i3 & 4096) != 0) {
            ArrayList arrayList15 = new ArrayList();
            Map<String, ArrayList<DiscussionMemberInfo>> q17 = q();
            ArrayList<DiscussionMemberInfo> arrayList16 = q17 != null ? q17.get(this.E) : null;
            if (arrayList16 != null) {
                this.f282844d.getCurrentAccountUin();
                for (int i27 = 0; i27 < arrayList16.size(); i27++) {
                    arrayList15.add(new wn2.b(this.f282844d, this.D, arrayList16.get(i27)));
                }
                list.addAll(arrayList15);
            }
        }
        if ((i3 & 8192) != 0 || (i3 & 262144) != 0 || (i3 & 1048576) != 0) {
            ArrayList arrayList17 = new ArrayList();
            List<TroopMemberInfo> n3 = n(this.E);
            TroopInfo m3 = m(this.E);
            String str7 = m3 == null ? str2 : m3.troopcode;
            if (n3 != null) {
                for (TroopMemberInfo troopMemberInfo : n3) {
                    if (Utils.M(troopMemberInfo.memberuin) && ((i3 & 262144) == 0 || m3 == null || m3.isTroopAdmin(troopMemberInfo.memberuin) || m3.isTroopOwner(troopMemberInfo.memberuin))) {
                        if ((i3 & 1048576) != 0) {
                            rVar = new wn2.s(this.f282844d, this.D, troopMemberInfo, str7);
                        } else {
                            rVar = new wn2.r(this.f282844d, this.D, troopMemberInfo);
                        }
                        arrayList17.add(rVar);
                    }
                }
            }
            list.addAll(arrayList17);
        }
        if ((524288 & i3) != 0) {
            long currentTimeMillis19 = System.currentTimeMillis();
            ArrayList arrayList18 = new ArrayList();
            List<PhoneContact> bindAllFriendList = ((IPhoneContactService) this.f282844d.getRuntimeService(IPhoneContactService.class, str2)).getBindAllFriendList();
            if (bindAllFriendList != null) {
                Iterator<PhoneContact> it12 = bindAllFriendList.iterator();
                while (it12.hasNext()) {
                    arrayList18.add(new wn2.m(this.f282844d, this.D, it12.next()));
                }
            }
            list.addAll(arrayList18);
            long currentTimeMillis20 = System.currentTimeMillis();
            g gVar11 = this.K[x(768)];
            gVar11.f282865b = currentTimeMillis20 - currentTimeMillis19;
            gVar11.f282866c = arrayList18.size();
        }
        Set<String> set = this.F;
        if (set == null || set.isEmpty()) {
            return list;
        }
        ArrayList arrayList19 = new ArrayList();
        for (com.tencent.mobileqq.search.model.k kVar : list) {
            if (!this.F.contains(kVar.getUin())) {
                arrayList19.add(kVar);
            }
        }
        return arrayList19;
    }

    @Override // on2.b
    public List<com.tencent.mobileqq.search.model.k> a(pn2.a aVar) {
        boolean z16;
        Bundle bundle = aVar.f426496b;
        boolean z17 = false;
        if (bundle != null) {
            z16 = bundle.getBoolean("searchTroopMember", false);
        } else {
            z16 = false;
        }
        if (this.f282848i != 64) {
            z17 = z16;
        }
        QLog.d("ContactSearchEngine", 1, "search searchTroopMember=" + z17);
        if (z17) {
            return O(aVar);
        }
        return L(aVar);
    }

    @Override // on2.b
    public void c(final pn2.a aVar, on2.d<com.tencent.mobileqq.search.model.k> dVar) {
        this.X = dVar;
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.search.business.contact.ContactSearchEngine.3
            @Override // java.lang.Runnable
            public void run() {
                List L = ContactSearchEngine.this.L(aVar);
                on2.d dVar2 = ContactSearchEngine.this.X;
                if (dVar2 != null && L != null) {
                    dVar2.onFinish(L, new pn2.b(aVar.f426495a, 1));
                }
            }
        }, null, true);
    }

    @Override // on2.b
    public void cancel() {
        synchronized (this.U) {
            ArrayList arrayList = new ArrayList();
            for (WeakReference<d> weakReference : this.T) {
                d dVar = weakReference.get();
                if (dVar != null) {
                    dVar.b(true);
                    arrayList.add(weakReference);
                }
            }
            this.T = arrayList;
        }
        this.X = null;
    }

    @Override // on2.b
    public void destroy() {
        if (this.G != -1) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", this.C);
            String str = this.f282849m;
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            hashMap.put("totalSize", String.valueOf(this.I));
            for (int i3 = 0; i3 < this.K.length; i3++) {
                hashMap.put("time_" + this.K[i3].f282868e, String.valueOf(this.K[i3].f282867d));
                hashMap.put("size_" + this.K[i3].f282868e, String.valueOf(this.K[i3].f282866c));
            }
            hashMap.put("time_global_troop_member", String.valueOf(this.N));
            hashMap.put("size_global_troop_member", String.valueOf(this.L));
            hashMap.put("time_global_troop_member_total", String.valueOf(this.P));
            hashMap.put("size_global_troop_member_total", String.valueOf(this.M));
            StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(this.f282844d.getCurrentAccountUin(), "ContactSearchEngineSearch", true, this.G, this.H, hashMap, "", false);
            if (this.V) {
                ReportController.o(this.f282844d, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Pv_Searchshopfolder", 0, 0, "", "", "", "");
                this.V = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ContactSearchEngineSearch", 2, "troopMemberSearchTime = " + this.P + " ; troopMemberQueryTime = " + this.N + " ; troopMemberTotalSize = " + this.M + " ; troopMemberResultSize = " + this.L);
            }
        }
        if (this.J > 0) {
            new rn2.c(this.f282844d).f("dc00899").a("Grp_listNew").d("search_result").c("exp_grp").b(String.valueOf(this.J)).e();
        }
    }

    @Override // on2.b
    public void init() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f282845e = C(this.f282848i);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.init() type = " + this.C + " ; cost time : " + (currentTimeMillis2 - currentTimeMillis) + " ; size = " + this.f282845e.size());
            for (int i3 = 0; i3 < this.K.length; i3++) {
                QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.init() type = " + this.K[i3].f282868e + " ; cost time : " + this.K[i3].f282865b + " ; size = " + this.K[i3].f282866c);
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("type", this.C);
        for (int i16 = 0; i16 < this.K.length; i16++) {
            hashMap.put("time_" + this.K[i16].f282868e, String.valueOf(this.K[i16].f282865b));
            hashMap.put("size_" + this.K[i16].f282868e, String.valueOf(this.K[i16].f282866c));
        }
        StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(this.f282844d.getCurrentAccountUin(), "ContactSearchEngineInit", true, currentTimeMillis2 - currentTimeMillis, this.f282845e.size(), hashMap, "", false);
    }

    public boolean l(List<com.tencent.mobileqq.search.model.k> list, List<com.tencent.mobileqq.search.model.k> list2, d dVar, String str) {
        if (dVar == null) {
            dVar = new d(false);
            synchronized (this.U) {
                this.T.add(new WeakReference<>(dVar));
            }
        }
        HashMap hashMap = new HashMap();
        for (com.tencent.mobileqq.search.model.k kVar : list) {
            com.tencent.mobileqq.search.model.k kVar2 = (com.tencent.mobileqq.search.model.k) hashMap.get(kVar.G());
            if (dVar.a()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + str);
                }
                return true;
            }
            if (kVar2 == null || kVar2.I() < kVar.I()) {
                hashMap.put(kVar.G(), kVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.search.model.k kVar3 : hashMap.values()) {
            if (dVar.a()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + str);
                }
                return true;
            }
            com.tencent.mobileqq.search.model.k kVar4 = (com.tencent.mobileqq.search.model.k) kVar3.clone();
            if (kVar4 != null) {
                arrayList.add(kVar4);
            }
        }
        try {
            Collections.sort(arrayList, Y);
        } catch (Throwable unused) {
        }
        int min = Math.min(arrayList.size(), 30);
        List subList = arrayList.subList(0, min);
        Comparator<com.tencent.mobileqq.search.model.k> u16 = u();
        if (u16 == null) {
            Collections.sort(subList, new e(this.f282844d, subList));
        }
        list2.addAll(subList);
        list2.addAll(arrayList.subList(min, arrayList.size()));
        if (u16 != null) {
            Collections.sort(list2, u16);
        }
        return false;
    }

    TroopInfo m(String str) {
        return ((ITroopInfoService) this.f282844d.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int r(String str) {
        return com.tencent.mobileqq.search.business.contact.entity.b.a(s(str));
    }

    public Comparator<com.tencent.mobileqq.search.model.k> u() {
        return null;
    }

    public int v() {
        return this.f282848i;
    }

    TroopInfo w(String str) {
        return ((ITroopInfoService) this.f282844d.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
    }

    public ContactSearchEngine(AppInterface appInterface, int i3, int i16, String str, Set<String> set) {
        this.f282848i = 0;
        this.G = -1L;
        this.K = new g[]{new g(1, GuildMsgItem.NICK_FRIEND), new g(768, "phone_contact"), new g(4, "discussion_member"), new g(8, "discussion"), new g(16, "troop"), new g(32, "recent_user"), new g(64, "tool"), new g(2048, "circle_buddy"), new g(131072, "global_troop_member"), new g(8388608, "qcircle_friends"), new g(16777216, "qcircle_official_account")};
        this.L = -1L;
        this.M = -1L;
        this.N = -1L;
        this.P = -1L;
        this.Q = new ConcurrentHashMap<>();
        this.R = new ConcurrentLinkedQueue();
        this.S = new ConcurrentLinkedQueue();
        this.T = new ArrayList();
        this.U = new Object();
        this.V = false;
        this.f282844d = appInterface;
        this.f282848i = i16;
        this.D = i3;
        this.F = set;
        this.E = str;
        if (i16 == 29) {
            this.C = "msg";
        } else {
            if (i16 != 100860733) {
                return;
            }
            this.C = SearchConfig.ENGINE_PEOPLE;
        }
    }

    @Override // on2.b
    public void pause() {
    }

    @Override // on2.b
    public void resume() {
    }
}
