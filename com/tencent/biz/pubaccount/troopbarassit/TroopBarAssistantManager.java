package com.tencent.biz.pubaccount.troopbarassit;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class TroopBarAssistantManager {

    /* renamed from: b, reason: collision with root package name */
    protected String f80136b;

    /* renamed from: m, reason: collision with root package name */
    protected List<TroopBarData> f80147m;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f80135a = true;

    /* renamed from: c, reason: collision with root package name */
    protected long f80137c = 0;

    /* renamed from: d, reason: collision with root package name */
    protected int f80138d = 0;

    /* renamed from: e, reason: collision with root package name */
    protected long f80139e = 0;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f80140f = false;

    /* renamed from: g, reason: collision with root package name */
    public int f80141g = 0;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f80142h = false;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f80143i = false;

    /* renamed from: j, reason: collision with root package name */
    protected ConcurrentHashMap<String, Integer> f80144j = new ConcurrentHashMap<>();

    /* renamed from: k, reason: collision with root package name */
    protected boolean f80145k = false;

    /* renamed from: l, reason: collision with root package name */
    private final Object f80146l = new Object();

    /* renamed from: p, reason: collision with root package name */
    protected Object f80150p = new Object();

    /* renamed from: q, reason: collision with root package name */
    Comparator<TroopBarData> f80151q = new a();

    /* renamed from: n, reason: collision with root package name */
    protected final Map<String, TroopBarData> f80148n = new HashMap();

    /* renamed from: o, reason: collision with root package name */
    protected final ConcurrentHashMap<String, PublicAccountInfo> f80149o = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements Comparator<TroopBarData> {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
        
            if (r0 == r9) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
        
            return 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
        
            if (r0 == r2) goto L26;
         */
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int compare(TroopBarData troopBarData, TroopBarData troopBarData2) {
            long max = Math.max(troopBarData.mLastMsgTime, troopBarData.mLastDraftTime);
            long max2 = Math.max(troopBarData2.mLastMsgTime, troopBarData2.mLastDraftTime);
            boolean z16 = troopBarData2.mIsSticky;
            if (z16 && !troopBarData.mIsSticky) {
                return 1;
            }
            if (z16 || !troopBarData.mIsSticky) {
                if (z16 && troopBarData.mIsSticky) {
                    long j3 = troopBarData2.mLastStickyTime;
                    long j16 = troopBarData.mLastStickyTime;
                    if (j3 > j16) {
                        return 1;
                    }
                } else if (max < max2) {
                    return 1;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        static TroopBarAssistantManager f80155a = new TroopBarAssistantManager();
    }

    TroopBarAssistantManager() {
    }

    private void F(QQAppInterface qQAppInterface, String str) {
        RecentUserProxy m3 = qQAppInterface.getProxyManager().m();
        RecentUser findRecentUser = m3.findRecentUser(str, 1008);
        if (findRecentUser != null) {
            m3.delRecentUser(findRecentUser);
        }
    }

    private boolean G(EntityManager entityManager, String str) {
        TroopBarData remove;
        synchronized (this.f80148n) {
            remove = this.f80148n.remove(str);
        }
        synchronized (this.f80150p) {
            List<TroopBarData> list = this.f80147m;
            if (list != null) {
                if (remove == null) {
                    Iterator<TroopBarData> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TroopBarData next = it.next();
                        if (TextUtils.equals(next.mUin, str)) {
                            remove = next;
                            break;
                        }
                    }
                }
                this.f80147m.remove(remove);
            }
        }
        if (remove != null) {
            if (!entityManager.remove(remove)) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopBarAssistantManager", 2, "remove TroopBarData " + remove.mUin + " from em fail");
                }
            } else if (QLog.isColorLevel()) {
                QLog.i("TroopBarAssistantManager", 2, "remove TroopBarData " + remove.mUin + " from em success");
            }
            return true;
        }
        return false;
    }

    private void H(String str, QQAppInterface qQAppInterface) {
        I(str, qQAppInterface, false);
    }

    private void K(final QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager.2
            @Override // java.lang.Runnable
            public void run() {
                JSONArray jSONArray = new JSONArray();
                for (String str : TroopBarAssistantManager.this.f80144j.keySet()) {
                    JSONObject jSONObject = new JSONObject();
                    if (str != null && TroopBarAssistantManager.this.f80144j.get(str) != null) {
                        try {
                            jSONObject.put(str, TroopBarAssistantManager.this.f80144j.get(str));
                            jSONArray.mo162put(jSONObject);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
                String jSONArray2 = jSONArray.toString();
                SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).edit();
                edit.putString("troopbar_assist_new_unread_list", jSONArray2);
                edit.commit();
            }
        });
    }

    private void L(QQAppInterface qQAppInterface, EntityManager entityManager, TroopBarData troopBarData) {
        if (troopBarData == null) {
            return;
        }
        TroopBarData troopBarData2 = this.f80148n.get(troopBarData.mUin);
        synchronized (this.f80148n) {
            this.f80148n.put(troopBarData.mUin, troopBarData);
        }
        synchronized (this.f80150p) {
            List<TroopBarData> list = this.f80147m;
            if (list != null) {
                if (troopBarData2 != null) {
                    list.remove(troopBarData2);
                }
                this.f80147m.remove(troopBarData);
                List<TroopBarData> list2 = this.f80147m;
                list2.add(list2.size(), troopBarData);
                if (QLog.isColorLevel()) {
                    QLog.i("TroopBarAssistantManager", 2, "save TroopBarData " + troopBarData.mUin + " to dataList");
                }
            }
        }
        J();
        ProxyManager proxyManager = (ProxyManager) qQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
        if (troopBarData.getStatus() == 1000) {
            proxyManager.addMsgQueue(qQAppInterface.getAccount(), 0, troopBarData.getTableName(), troopBarData, 3, null);
        } else {
            proxyManager.addMsgQueue(qQAppInterface.getAccount(), 0, troopBarData.getTableName(), troopBarData, 4, null);
        }
    }

    private boolean a(QQAppInterface qQAppInterface, long j3) {
        TroopBarData m3;
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        RecentUserProxy m16 = qQAppInterface.getProxyManager().m();
        boolean z16 = false;
        if (troopManager == null) {
            return false;
        }
        if (this.f80135a && !this.f80142h) {
            z16 = true;
        }
        if (z16) {
            RecentUser findRecentUserByUin = m16.findRecentUserByUin(AppConstants.TROOP_BAR_ASSISTANT_UIN, AppConstants.VALUE.UIN_TYPE_TROOP_BAR_ASSIST);
            if (findRecentUserByUin.lastmsgtime < j3) {
                findRecentUserByUin.lastmsgtime = j3;
            }
            if (!y(qQAppInterface) && (m3 = m(qQAppInterface)) != null) {
                findRecentUserByUin.lastmsgtime = m3.mLastMsgTime;
                findRecentUserByUin.lastmsgdrafttime = m3.mLastDraftTime;
            }
            m16.saveRecentUser(findRecentUserByUin);
        } else {
            RecentUser findRecentUser = m16.findRecentUser(AppConstants.TROOP_BAR_ASSISTANT_UIN, AppConstants.VALUE.UIN_TYPE_TROOP_BAR_ASSIST);
            if (findRecentUser != null) {
                m16.delRecentUser(findRecentUser);
            }
        }
        MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
        if (handler != null) {
            handler.sendEmptyMessage(1009);
        }
        return true;
    }

    private void d(MessageRecord messageRecord, String str, QQAppInterface qQAppInterface) {
        if (!ServiceAccountFolderManager.n(qQAppInterface, str)) {
            return;
        }
        s(qQAppInterface);
        if (messageRecord != null && !messageRecord.isread) {
            if (this.f80144j.containsKey(str)) {
                ConcurrentHashMap<String, Integer> concurrentHashMap = this.f80144j;
                concurrentHashMap.put(str, Integer.valueOf(concurrentHashMap.get(str).intValue() + 1));
            } else {
                this.f80144j.put(str, 1);
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopBarAssistantManager", 2, "add uin " + str + " to newMsgMap");
            }
        }
        K(qQAppInterface);
    }

    private void e(String str, QQAppInterface qQAppInterface) {
        if (!ServiceAccountFolderManager.n(qQAppInterface, str)) {
            return;
        }
        s(qQAppInterface);
        if (qQAppInterface.getConversationFacade().R(str, 1008) > 0) {
            if (this.f80144j.containsKey(str)) {
                ConcurrentHashMap<String, Integer> concurrentHashMap = this.f80144j;
                concurrentHashMap.put(str, Integer.valueOf(concurrentHashMap.get(str).intValue() + 1));
            } else {
                this.f80144j.put(str, 1);
            }
        }
        K(qQAppInterface);
    }

    private void f(QQAppInterface qQAppInterface) {
        if (qQAppInterface != null) {
            if (!qQAppInterface.getAccount().equals(this.f80136b)) {
                synchronized (this.f80146l) {
                    this.f80145k = false;
                }
            }
            this.f80136b = qQAppInterface.getAccount();
            SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0);
            this.f80135a = sharedPreferences.getBoolean("troopbar_assist_show_in_msg", true);
            this.f80137c = sharedPreferences.getLong("troopbar_assist_last_read_time", 0L);
            this.f80142h = sharedPreferences.getBoolean("troopbar_assist_deleted", false);
            synchronized (this.f80150p) {
                this.f80147m = null;
            }
            s(qQAppInterface);
            this.f80140f = false;
        }
    }

    public static synchronized void h() {
        synchronized (TroopBarAssistantManager.class) {
            b.f80155a = null;
        }
    }

    private void i(EntityManager entityManager, QQAppInterface qQAppInterface) {
        try {
            List query = entityManager.query(TroopBarData.class, false, null, null, null, null, "mLastMsgTime desc", null);
            if (query != null && query.size() > 0) {
                Collections.sort(query, this.f80151q);
            }
            synchronized (this.f80150p) {
                this.f80147m = query;
                if (query == null) {
                    this.f80147m = new ArrayList(15);
                } else {
                    long q16 = q(qQAppInterface);
                    for (int i3 = 0; i3 < this.f80147m.size(); i3++) {
                        TroopBarData troopBarData = this.f80147m.get(i3);
                        if (troopBarData == null) {
                            if (QLog.isColorLevel()) {
                                QLog.w("TroopBarAssistantManager", 2, "doInit==> pad == null");
                            }
                            this.f80147m.remove(i3);
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("TroopBarAssistantManager", 2, "doInit==> uin:" + troopBarData.mUin + ", lastMsgTime:" + troopBarData.mLastMsgTime);
                            }
                            if (troopBarData.mLastMsgTime < q16) {
                                this.f80147m.remove(i3);
                            } else {
                                this.f80147m.get(i3).mLatestMessage = qQAppInterface.getMessageFacade().x1(this.f80147m.get(i3).mUin, 1008);
                            }
                        }
                    }
                }
            }
            synchronized (this.f80148n) {
                this.f80148n.clear();
                for (TroopBarData troopBarData2 : this.f80147m) {
                    this.f80148n.put(troopBarData2.mUin, troopBarData2);
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopBarAssistantManager", 2, "initTroopBarAssistRecent doInit error: ", e16);
            }
        }
    }

    private List<TroopBarData> j(QQAppInterface qQAppInterface, List<TroopBarData> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TroopBarData troopBarData : list) {
            if (ServiceAccountFolderManager.n(qQAppInterface, troopBarData.mUin)) {
                arrayList.add(troopBarData);
            }
        }
        return arrayList;
    }

    private TroopBarData k(EntityManager entityManager, QQAppInterface qQAppInterface, String str) {
        TroopBarData troopBarData;
        DraftSummaryInfo draftSummaryInfo;
        v(qQAppInterface);
        synchronized (this.f80148n) {
            troopBarData = this.f80148n.get(str);
            if (troopBarData == null) {
                troopBarData = new TroopBarData();
                troopBarData.mUin = str;
                QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
                if (messageFacade != null && (draftSummaryInfo = messageFacade.getDraftSummaryInfo(str, 1008)) != null) {
                    troopBarData.mLastDraftTime = draftSummaryInfo.getTime();
                }
            }
        }
        return troopBarData;
    }

    private TroopBarData l(QQAppInterface qQAppInterface, String str) {
        TroopBarData troopBarData;
        v(qQAppInterface);
        synchronized (this.f80148n) {
            troopBarData = this.f80148n.get(str);
        }
        return troopBarData;
    }

    public static synchronized TroopBarAssistantManager n() {
        TroopBarAssistantManager troopBarAssistantManager;
        synchronized (TroopBarAssistantManager.class) {
            if (b.f80155a == null) {
                b.f80155a = new TroopBarAssistantManager();
            }
            troopBarAssistantManager = b.f80155a;
        }
        return troopBarAssistantManager;
    }

    private long q(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return 0L;
        }
        if (!this.f80140f) {
            this.f80139e = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).getLong("troopbar_recent_item_last_del_time", 0L);
            this.f80140f = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopBarAssistantManager", 2, "getTroopBarRecentItemLastDelTime, lastDelTime:" + this.f80139e);
        }
        return this.f80139e;
    }

    private void s(QQAppInterface qQAppInterface) {
        if (this.f80145k) {
            return;
        }
        synchronized (this.f80146l) {
            if (!this.f80145k) {
                this.f80144j.clear();
                try {
                    JSONArray jSONArray = new JSONArray(qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).getString("troopbar_assist_new_unread_list", ""));
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        Iterator keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String str = (String) keys.next();
                            if (ServiceAccountFolderManager.n(qQAppInterface, str)) {
                                this.f80144j.put(str, Integer.valueOf(jSONObject.getInt(str)));
                            }
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopBarAssistantManager", 2, "initNewMsgMapIfNeeds:" + e16.toString());
                    }
                }
                this.f80145k = true;
            }
        }
    }

    public boolean A(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            if (this.f80147m == null) {
                synchronized (this.f80149o) {
                    if (this.f80147m == null) {
                        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                        i(createEntityManager, qQAppInterface);
                        createEntityManager.close();
                    }
                }
            }
            return this.f80149o.containsKey(str);
        }
        return false;
    }

    public void B(QQAppInterface qQAppInterface) {
        PublicAccountInfo publicAccountInfo;
        RecentUserProxy m3 = qQAppInterface.getProxyManager().m();
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<RecentUser> recentList = m3.getRecentList(false);
        if (recentList != null && recentList.size() > 0) {
            for (RecentUser recentUser : recentList) {
                if (recentUser.getType() == 1008 && x(qQAppInterface, recentUser.uin, recentUser.getType()) && !com.tencent.mobileqq.activity.recent.msg.b.a(qQAppInterface, recentUser)) {
                    arrayList.add(recentUser);
                }
            }
        }
        v(qQAppInterface);
        synchronized (this.f80150p) {
            List<TroopBarData> list = this.f80147m;
            if (list != null && list.size() > 0) {
                for (TroopBarData troopBarData : this.f80147m) {
                    if (!x(qQAppInterface, troopBarData.mUin, 1008)) {
                        arrayList2.add(troopBarData);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            if (this.f80142h) {
                U(qQAppInterface, false);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                RecentUser recentUser2 = (RecentUser) it.next();
                TroopBarData k3 = k(createEntityManager, qQAppInterface, recentUser2.uin);
                long j3 = recentUser2.lastmsgtime;
                if (j3 == 0) {
                    Message lastMessage = qQAppInterface.getMessageFacade().getLastMessage(k3.mUin, 1008);
                    if (lastMessage != null) {
                        k3.mLastMsgTime = lastMessage.time;
                    }
                } else {
                    k3.mLastMsgTime = j3;
                }
                L(qQAppInterface, createEntityManager, k3);
                m3.delRecentUser(recentUser2);
                e(recentUser2.uin, qQAppInterface);
            }
        }
        if (arrayList2.size() > 0) {
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                TroopBarData troopBarData2 = (TroopBarData) it5.next();
                RecentUser findRecentUserByUin = m3.findRecentUserByUin(troopBarData2.mUin, 1008);
                findRecentUserByUin.uin = troopBarData2.mUin;
                findRecentUserByUin.setType(1008);
                findRecentUserByUin.lastmsgtime = troopBarData2.mLastMsgTime;
                findRecentUserByUin.lastmsgdrafttime = troopBarData2.mLastDraftTime;
                if (G(createEntityManager, troopBarData2.mUin)) {
                    ConcurrentHashMap<String, PublicAccountInfo> concurrentHashMap = this.f80149o;
                    if (concurrentHashMap == null) {
                        publicAccountInfo = null;
                    } else {
                        publicAccountInfo = concurrentHashMap.get(troopBarData2.mUin);
                    }
                    if (publicAccountInfo != null) {
                        m3.saveRecentUser(findRecentUserByUin);
                    }
                    H(troopBarData2.mUin, qQAppInterface);
                }
            }
        }
        TroopBarData m16 = m(qQAppInterface);
        if (m16 != null) {
            a(qQAppInterface, m16.mLastMsgTime);
        }
        if (createEntityManager != null) {
            createEntityManager.close();
        }
    }

    public void C(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopBarAssistManager", 2, "app == null; what happen.");
                return;
            }
            return;
        }
        if (!qQAppInterface.getAccount().equals(this.f80136b)) {
            f(qQAppInterface);
        }
        if (y(qQAppInterface)) {
            T(qQAppInterface, false);
            Q(qQAppInterface, false);
            a(qQAppInterface, NetConnInfoCenter.getServerTime());
        } else {
            TroopBarData m3 = m(qQAppInterface);
            if (m3 != null) {
                a(qQAppInterface, m3.mLastMsgTime);
            }
        }
    }

    public void D(QQAppInterface qQAppInterface, List<PublicAccountInfo> list) {
        if (qQAppInterface == null || !qQAppInterface.getAccount().equals(this.f80136b) || !((IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).isCached()) {
            return;
        }
        this.f80143i = true;
        if (list != null && list.size() > 0) {
            this.f80149o.clear();
            for (PublicAccountInfo publicAccountInfo : list) {
                this.f80149o.put(publicAccountInfo.getUin(), publicAccountInfo);
            }
        }
        B(qQAppInterface);
    }

    public void E(QQAppInterface qQAppInterface) {
        MqqHandler handler = qQAppInterface.getHandler(SubscriptFeedsActivity.class);
        if (handler != null) {
            handler.removeMessages(1002);
            handler.sendEmptyMessage(1002);
            handler.removeMessages(1005);
            handler.sendEmptyMessage(1005);
        }
    }

    public void I(String str, QQAppInterface qQAppInterface, boolean z16) {
        s(qQAppInterface);
        if ((z16 || qQAppInterface.getConversationFacade().R(str, 1008) > 0) && this.f80144j.containsKey(str)) {
            this.f80144j.remove(str);
        }
        K(qQAppInterface);
    }

    public void J() {
        synchronized (this.f80150p) {
            List<TroopBarData> list = this.f80147m;
            if (list != null && list.size() > 0) {
                Collections.sort(this.f80147m, this.f80151q);
            }
        }
    }

    public void M(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return;
        }
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).edit();
        long serverTime = NetConnInfoCenter.getServerTime();
        this.f80139e = serverTime;
        edit.putLong("troopbar_recent_item_last_del_time", serverTime);
        edit.commit();
        if (QLog.isColorLevel()) {
            QLog.d("TroopBarAssistantManager", 2, "saveTroopBarRecentItemLastDelTime, lastDelTime:" + this.f80139e);
        }
    }

    public void N(QQAppInterface qQAppInterface) {
        this.f80144j.clear();
        K(qQAppInterface);
    }

    public void O(QQAppInterface qQAppInterface, boolean z16) {
        qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).edit().putBoolean("first_enter_subscribe", z16).commit();
    }

    public void P(QQAppInterface qQAppInterface, boolean z16) {
        qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).edit().putBoolean("first_enter_subscribe_no_reset", z16).commit();
    }

    public void Q(QQAppInterface qQAppInterface, boolean z16) {
        qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).edit().putBoolean("first_login", z16).commit();
    }

    public void R(QQAppInterface qQAppInterface, long j3) {
        if (!qQAppInterface.getAccount().equals(this.f80136b)) {
            f(qQAppInterface);
        }
        this.f80137c = j3;
        qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).edit().putLong("troopbar_assist_last_read_time", j3).commit();
        RecentUser findRecentUserByUin = qQAppInterface.getProxyManager().m().findRecentUserByUin(AppConstants.TROOP_BAR_ASSISTANT_UIN, AppConstants.VALUE.UIN_TYPE_TROOP_BAR_ASSIST);
        if (findRecentUserByUin != null) {
            findRecentUserByUin.lastmsgtime = j3;
        }
        this.f80144j.clear();
        K(qQAppInterface);
    }

    public void S(QQAppInterface qQAppInterface) {
        long serverTime;
        TroopBarData m3 = m(qQAppInterface);
        if (m3 != null) {
            serverTime = m3.mLastMsgTime;
        } else {
            serverTime = NetConnInfoCenter.getServerTime();
        }
        R(qQAppInterface, serverTime);
    }

    public void T(QQAppInterface qQAppInterface, boolean z16) {
        qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).edit().putBoolean("subscribe_setTop_flag", z16).commit();
    }

    public void U(QQAppInterface qQAppInterface, boolean z16) {
        qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).edit().putBoolean("troopbar_assist_deleted", z16).commit();
        this.f80142h = z16;
    }

    public boolean V(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).getBoolean("init_troopbar_assist", true);
    }

    public void b(MessageRecord messageRecord, QQAppInterface qQAppInterface) {
        boolean z16;
        if (y(qQAppInterface)) {
            if (this.f80135a && !this.f80142h) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (messageRecord.time >= qQAppInterface.getProxyManager().m().findRecentUserByUin(AppConstants.TROOP_BAR_ASSISTANT_UIN, AppConstants.VALUE.UIN_TYPE_TROOP_BAR_ASSIST).lastmsgtime) {
                    T(qQAppInterface, false);
                }
            }
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        c(messageRecord, messageRecord.frienduin, messageRecord.time, createEntityManager, qQAppInterface);
        createEntityManager.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(MessageRecord messageRecord, String str, long j3, EntityManager entityManager, QQAppInterface qQAppInterface) {
        Message lastMessage;
        TroopBarData k3 = k(entityManager, qQAppInterface, str);
        if (messageRecord != null) {
            long j16 = messageRecord.time;
            if (j16 > j3) {
                k3.mLastMsgTime = j16;
                k3.mLatestMessage = messageRecord;
                lastMessage = qQAppInterface.getMessageFacade().getLastMessage(k3.mUin, 1008);
                if (lastMessage != null) {
                    long j17 = lastMessage.time;
                    if (j17 > k3.mLastMsgTime) {
                        k3.mLastMsgTime = j17;
                        k3.mLatestMessage = lastMessage;
                    }
                }
                L(qQAppInterface, entityManager, k3);
                d(messageRecord, str, qQAppInterface);
                if (this.f80142h) {
                    U(qQAppInterface, false);
                }
                F(qQAppInterface, str);
                a(qQAppInterface, j3);
            }
        }
        k3.mLastMsgTime = j3;
        lastMessage = qQAppInterface.getMessageFacade().getLastMessage(k3.mUin, 1008);
        if (lastMessage != null) {
        }
        L(qQAppInterface, entityManager, k3);
        d(messageRecord, str, qQAppInterface);
        if (this.f80142h) {
        }
        F(qQAppInterface, str);
        a(qQAppInterface, j3);
    }

    public void g(final QQAppInterface qQAppInterface) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager.3
            @Override // java.lang.Runnable
            public void run() {
                ConversationFacade conversationFacade = qQAppInterface.getConversationFacade();
                QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
                if (conversationFacade != null && messageFacade != null) {
                    synchronized (TroopBarAssistantManager.this.f80150p) {
                        List<TroopBarData> list = TroopBarAssistantManager.this.f80147m;
                        if (list != null) {
                            for (TroopBarData troopBarData : list) {
                                MessageRecord messageRecord = troopBarData.mLatestMessage;
                                if (messageRecord == null) {
                                    messageRecord = qQAppInterface.getMessageFacade().x1(troopBarData.mUin, 1008);
                                }
                                if (messageRecord != null && conversationFacade.R(messageRecord.frienduin, messageRecord.istroop) > 0) {
                                    int uinType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getUinType(qQAppInterface, messageRecord.frienduin);
                                    RecentUtil.I0(qQAppInterface, messageRecord.frienduin, uinType);
                                    conversationFacade.r(messageRecord.frienduin, uinType, true);
                                }
                            }
                        }
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TroopBarAssistantManager", 2, "clearAllSubscriptionUnreadMsgLite getConversationFacade fail");
                }
            }
        });
    }

    public TroopBarData m(QQAppInterface qQAppInterface) {
        TroopBarData troopBarData;
        v(qQAppInterface);
        synchronized (this.f80150p) {
            List<TroopBarData> list = this.f80147m;
            if (list != null && list.size() > 0) {
                long q16 = q(qQAppInterface);
                Iterator<TroopBarData> it = this.f80147m.iterator();
                while (it.hasNext()) {
                    TroopBarData next = it.next();
                    if (next.mLastMsgTime < q16) {
                        it.remove();
                    } else {
                        DraftSummaryInfo draftSummaryInfo = qQAppInterface.getMessageFacade().getDraftSummaryInfo(next.mUin, 1008);
                        if (draftSummaryInfo != null) {
                            next.mLastDraftTime = draftSummaryInfo.getTime();
                        } else {
                            next.mLastDraftTime = 0L;
                        }
                    }
                }
            }
            J();
            List<TroopBarData> j3 = j(qQAppInterface, this.f80147m);
            if (j3 != null && !j3.isEmpty()) {
                troopBarData = j3.get(0);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.w("TroopBarAssistantManager", 2, "getFirstData return null");
                }
                troopBarData = null;
            }
        }
        return troopBarData;
    }

    public String o(String str) {
        PublicAccountInfo publicAccountInfo;
        ConcurrentHashMap<String, PublicAccountInfo> concurrentHashMap = this.f80149o;
        if (concurrentHashMap != null && (publicAccountInfo = concurrentHashMap.get(str)) != null) {
            return publicAccountInfo.name;
        }
        return "";
    }

    public int p(QQAppInterface qQAppInterface) {
        int i3 = 0;
        if (!qQAppInterface.getAccount().equals(this.f80136b)) {
            return 0;
        }
        synchronized (this.f80146l) {
            if (this.f80145k) {
                Iterator<Integer> it = this.f80144j.values().iterator();
                while (it.hasNext()) {
                    i3 += it.next().intValue();
                }
            }
        }
        return i3;
    }

    public List<TroopBarData> r(QQAppInterface qQAppInterface) {
        ArrayList arrayList = new ArrayList();
        v(qQAppInterface);
        synchronized (this.f80150p) {
            if (this.f80147m != null) {
                long q16 = q(qQAppInterface);
                boolean z16 = false;
                for (int size = this.f80147m.size() - 1; size >= 0; size--) {
                    TroopBarData troopBarData = this.f80147m.get(size);
                    if (troopBarData == null) {
                        this.f80147m.remove(size);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopBarAssistantManager", 2, "getUseTroopBarAssistList==> uin:" + troopBarData.mUin + ", lastMsgTime:" + troopBarData.mLastMsgTime);
                        }
                        if (troopBarData.mLastMsgTime < q16) {
                            this.f80147m.remove(size);
                        } else {
                            MessageRecord x16 = qQAppInterface.getMessageFacade().x1(troopBarData.mUin, 1008);
                            if (x16 == null) {
                                this.f80147m.remove(size);
                            } else if (x16.time > troopBarData.mLastMsgTime) {
                                this.f80147m.get(size).mLastMsgTime = x16.time;
                                z16 = true;
                            }
                        }
                    }
                }
                if (z16) {
                    Collections.sort(this.f80147m, this.f80151q);
                }
                arrayList.addAll(this.f80147m);
            }
        }
        return arrayList;
    }

    public void t(EntityManager entityManager, QQAppInterface qQAppInterface) {
        try {
            v(qQAppInterface);
            RecentUserProxy m3 = qQAppInterface.getProxyManager().m();
            List<RecentUser> recentList = m3.getRecentList(false);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            ArrayList<RecentUser> arrayList = new ArrayList();
            if (recentList != null && recentList.size() > 0) {
                for (RecentUser recentUser : recentList) {
                    if (recentUser.getType() == 1008 || recentUser.getType() == 1024) {
                        if (x(qQAppInterface, recentUser.uin, recentUser.getType())) {
                            arrayList.add(recentUser);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                long j3 = ((RecentUser) arrayList.get(0)).lastmsgtime;
                for (RecentUser recentUser2 : arrayList) {
                    TroopBarData k3 = k(entityManager, qQAppInterface, recentUser2.uin);
                    k3.mLastDraftTime = recentUser2.lastmsgdrafttime;
                    long j16 = recentUser2.lastmsgtime;
                    if (j16 == 0) {
                        Message lastMessage = qQAppInterface.getMessageFacade().getLastMessage(k3.mUin, 1008);
                        if (lastMessage != null) {
                            k3.mLastMsgTime = lastMessage.time;
                        }
                    } else {
                        k3.mLastMsgTime = j16;
                    }
                    L(qQAppInterface, entityManager, k3);
                    m3.delRecentUser(recentUser2);
                    e(k3.mUin, qQAppInterface);
                }
            }
            ((IPublicAccountHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).clearPublicAccountSeq();
            qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).edit().putBoolean("init_troopbar_assist", false).commit();
        } catch (Exception unused) {
        }
    }

    public void u(QQAppInterface qQAppInterface) {
        try {
            f(qQAppInterface);
            if (V(qQAppInterface)) {
                EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                t(createEntityManager, qQAppInterface);
                createEntityManager.close();
            }
            C(qQAppInterface);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void v(QQAppInterface qQAppInterface) {
        boolean z16;
        synchronized (this.f80150p) {
            if (this.f80147m == null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (z16) {
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
            i(createEntityManager, qQAppInterface);
            createEntityManager.close();
            List<PublicAccountInfo> list = (List) ((IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountEqqInfoList();
            if (list != null && list.size() > 0) {
                this.f80149o.clear();
                for (PublicAccountInfo publicAccountInfo : list) {
                    this.f80149o.put(publicAccountInfo.getUin(), publicAccountInfo);
                }
            }
        }
    }

    public boolean w(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).getBoolean("first_enter_subscribe_no_reset", true);
    }

    public boolean x(QQAppInterface qQAppInterface, String str, int i3) {
        if (i3 == 1008 && ServiceAccountFolderManager.n(qQAppInterface, str)) {
            return true;
        }
        return false;
    }

    public boolean y(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0).getBoolean("subscribe_setTop_flag", false);
    }

    public boolean z(String str, QQAppInterface qQAppInterface) {
        TroopBarData l3 = l(qQAppInterface, str);
        if (l3 != null) {
            return l3.mIsSticky;
        }
        return false;
    }
}
