package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.eb;
import com.tencent.mobileqq.utils.ff;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class HotChatCenterManager implements Manager {
    static IPatchRedirector $redirector_;
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<QQAppInterface> f194746d;

    /* renamed from: e, reason: collision with root package name */
    private CopyOnWriteArrayList<HotChatItemData> f194747e;

    /* renamed from: f, reason: collision with root package name */
    protected Map<String, HotChatItemData> f194748f;

    /* renamed from: h, reason: collision with root package name */
    protected long f194749h;

    /* renamed from: i, reason: collision with root package name */
    protected SharedPreferences f194750i;

    /* renamed from: m, reason: collision with root package name */
    protected Set<String> f194751m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.HotChatCenterManager$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EntityManager f194753d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HotChatItemData f194754e;
        final /* synthetic */ HotChatCenterManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f194753d.remove(this.f194754e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements Comparator<HotChatItemData> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HotChatCenterManager.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(HotChatItemData hotChatItemData, HotChatItemData hotChatItemData2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) hotChatItemData, (Object) hotChatItemData2)).intValue();
            }
            long j3 = hotChatItemData.mMakeTopTime;
            long j16 = hotChatItemData2.mMakeTopTime;
            if (j3 < j16) {
                return 1;
            }
            if (j3 == j16) {
                return 0;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements Comparator<HotChatItemData> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HotChatCenterManager.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(HotChatItemData hotChatItemData, HotChatItemData hotChatItemData2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) hotChatItemData, (Object) hotChatItemData2)).intValue();
            }
            long max = Math.max(hotChatItemData.mLatestMsgSec, hotChatItemData.mDraftSec);
            long max2 = Math.max(hotChatItemData2.mLatestMsgSec, hotChatItemData2.mDraftSec);
            if (max < max2) {
                return 1;
            }
            if (max == max2) {
                return 0;
            }
            return -1;
        }
    }

    public HotChatCenterManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194749h = 0L;
        QLog.i("HotChatCenterManager", 1, "create HotChatFolderManager.");
        this.f194746d = new WeakReference<>(qQAppInterface);
        this.f194747e = new CopyOnWriteArrayList<>();
        this.f194748f = Collections.synchronizedMap(new HashMap());
        this.f194751m = Collections.synchronizedSet(new HashSet());
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getAccount(), 0);
        this.f194750i = sharedPreferences;
        if (sharedPreferences != null) {
            this.f194749h = sharedPreferences.getLong("hotchat_last_read_time", 0L);
            this.C = this.f194750i.getBoolean("troop_assis_show_on_top", false);
        }
    }

    private void c(MessageRecord messageRecord, String str) {
        if (messageRecord != null && !messageRecord.isread && !this.f194751m.contains(str)) {
            this.f194751m.add(str);
        }
        p();
    }

    private void d(String str) {
        HotChatItemData f16;
        if (h() != null && (f16 = f(str)) != null) {
            int i3 = f16.mGameId;
        }
    }

    private void e() {
        QQAppInterface h16;
        if (this.f194747e.size() == 0 || (h16 = h()) == null) {
            return;
        }
        int size = this.f194747e.size();
        EntityManager entityManager = null;
        try {
            entityManager = h16.getEntityManagerFactory().createEntityManager();
            for (int i3 = size - 1; i3 >= 0; i3--) {
                HotChatItemData hotChatItemData = this.f194747e.get(i3);
                d(hotChatItemData.mTroopUin);
                if (hotChatItemData.mGameId == 0) {
                    QLog.i("HotChatCenterManager", 1, hotChatItemData.mHotChatCode + " is invalid.");
                    this.f194748f.remove(hotChatItemData.mTroopUin);
                    this.f194747e.remove(i3);
                    entityManager.remove(hotChatItemData);
                }
            }
        } catch (Throwable th5) {
            try {
                QLog.e("HotChatCenterManager", 1, th5, new Object[0]);
                if (entityManager == null) {
                }
            } finally {
                if (entityManager != null) {
                    entityManager.close();
                }
            }
        }
    }

    private HotChatItemData g(QQAppInterface qQAppInterface, String str) {
        DraftSummaryInfo draftSummaryInfo;
        l();
        HotChatItemData hotChatItemData = this.f194748f.get(str);
        if (hotChatItemData == null) {
            hotChatItemData = new HotChatItemData();
            hotChatItemData.mTroopUin = str;
            QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
            if (messageFacade != null && (draftSummaryInfo = messageFacade.getDraftSummaryInfo(str, 1)) != null) {
                hotChatItemData.mDraftSec = draftSummaryInfo.getTime();
            }
        }
        return hotChatItemData;
    }

    private void m(String str, int i3) {
        RecentUserProxy m3;
        RecentUser findRecentUser;
        QQAppInterface h16 = h();
        if (h16 != null && (findRecentUser = (m3 = h16.getProxyManager().m()).findRecentUser(str, i3)) != null && !com.tencent.mobileqq.activity.recent.msg.b.a(h16, findRecentUser)) {
            m3.delRecentUser(findRecentUser);
        }
    }

    private void n() {
        char c16;
        char c17;
        if (this.f194747e.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<HotChatItemData> arrayList2 = new ArrayList();
        Iterator<HotChatItemData> it = this.f194747e.iterator();
        while (it.hasNext()) {
            HotChatItemData next = it.next();
            if (next.mIsMakeTop) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        Collections.sort(arrayList, new a());
        Collections.sort(arrayList2, new b());
        this.f194747e.clear();
        Iterator it5 = arrayList.iterator();
        while (true) {
            c16 = 4;
            c17 = 3;
            if (!it5.hasNext()) {
                break;
            }
            HotChatItemData hotChatItemData = (HotChatItemData) it5.next();
            this.f194747e.add(hotChatItemData);
            if (QLog.isColorLevel()) {
                QLog.d("HotChatCenterManager", 2, "[sort],", hotChatItemData.mHotChatCode, ",isMakeTop:", Boolean.valueOf(hotChatItemData.mIsMakeTop), ",topTime:", Long.valueOf(hotChatItemData.mMakeTopTime));
            }
        }
        for (HotChatItemData hotChatItemData2 : arrayList2) {
            this.f194747e.add(hotChatItemData2);
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[6];
                objArr[0] = "[sort],";
                objArr[1] = hotChatItemData2.mHotChatCode;
                objArr[2] = ",isMakeTop:";
                objArr[c17] = Boolean.valueOf(hotChatItemData2.mIsMakeTop);
                objArr[c16] = ",topTime:";
                objArr[5] = Long.valueOf(hotChatItemData2.mMakeTopTime);
                QLog.d("HotChatCenterManager", 2, objArr);
            }
            c16 = 4;
            c17 = 3;
        }
    }

    private void o(HotChatItemData hotChatItemData) {
        if (hotChatItemData != null && !TextUtils.isEmpty(hotChatItemData.mTroopUin)) {
            this.f194748f.put(hotChatItemData.mTroopUin, hotChatItemData);
            if (!hotChatItemData.mIsMakeTop) {
                Iterator<HotChatItemData> it = this.f194747e.iterator();
                while (it.hasNext()) {
                    HotChatItemData next = it.next();
                    if (hotChatItemData.mTroopUin.equals(next.mTroopUin)) {
                        this.f194747e.remove(next);
                    }
                }
                int size = this.f194747e.size();
                boolean z16 = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    HotChatItemData hotChatItemData2 = this.f194747e.get(i3);
                    if (!hotChatItemData2.mIsMakeTop && Math.max(hotChatItemData.mLatestMsgSec, hotChatItemData.mDraftSec) > Math.max(hotChatItemData2.mLatestMsgSec, hotChatItemData2.mDraftSec)) {
                        this.f194747e.add(i3, hotChatItemData);
                        z16 = true;
                        break;
                    }
                    i3++;
                }
                if (!z16) {
                    CopyOnWriteArrayList<HotChatItemData> copyOnWriteArrayList = this.f194747e;
                    copyOnWriteArrayList.add(copyOnWriteArrayList.size(), hotChatItemData);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("HotChatCenterManager", 2, "saveHotChatItemData data=" + hotChatItemData);
            }
            ThreadManager.getSubThreadHandler().post(new Runnable(hotChatItemData) { // from class: com.tencent.mobileqq.app.HotChatCenterManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ HotChatItemData f194752d;

                {
                    this.f194752d = hotChatItemData;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) HotChatCenterManager.this, (Object) hotChatItemData);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    QQAppInterface h16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    EntityManager entityManager = null;
                    try {
                        h16 = HotChatCenterManager.this.h();
                    } catch (Throwable th5) {
                        try {
                            QLog.e("HotChatCenterManager", 1, th5, new Object[0]);
                            if (entityManager == null) {
                                return;
                            }
                        } finally {
                            if (0 != 0) {
                                entityManager.close();
                            }
                        }
                    }
                    if (h16 == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("HotChatCenterManager", 2, "saveHotChatItemData app = null");
                            return;
                        }
                        return;
                    }
                    entityManager = h16.getEntityManagerFactory().createEntityManager();
                    if (this.f194752d.getStatus() == 1000) {
                        entityManager.persist(this.f194752d);
                        if (QLog.isColorLevel()) {
                            QLog.d("HotChatCenterManager", 2, "saveHotChatItemData [persist],code:", this.f194752d.mHotChatCode);
                        }
                    } else {
                        entityManager.update(this.f194752d);
                        if (QLog.isColorLevel()) {
                            QLog.d("HotChatCenterManager", 2, "saveHotChatItemData [update],code:", this.f194752d.mHotChatCode);
                        }
                    }
                    if (entityManager == null) {
                    }
                }
            });
        }
    }

    private void p() {
        if (h() == null) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.HotChatCenterManager.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HotChatCenterManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences sharedPreferences;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Object[] objArr = null;
                try {
                    Set<String> set = HotChatCenterManager.this.f194751m;
                    if (set != null && set.size() > 0) {
                        objArr = HotChatCenterManager.this.f194751m.toArray();
                    }
                } catch (Throwable th5) {
                    QLog.e("HotChatCenterManager", 1, th5, new Object[0]);
                }
                if (objArr != null && (sharedPreferences = HotChatCenterManager.this.f194750i) != null) {
                    eb.c(sharedPreferences.edit(), "hotchat_new_unread_list", objArr).commit();
                }
            }
        }, 5, null, false);
    }

    public boolean a(long j3) {
        HotChatItemData hotChatItemData;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, j3)).booleanValue();
        }
        QQAppInterface h16 = h();
        if (h16 == null) {
            return false;
        }
        if (this.f194747e.size() == 0) {
            QLog.w("HotChatCenterManager", 1, "no item in folder, don't add to ru.");
            return false;
        }
        TroopManager troopManager = (TroopManager) h16.getManager(QQManagerFactory.TROOP_MANAGER);
        RecentUserProxy m3 = h16.getProxyManager().m();
        if (troopManager == null) {
            return false;
        }
        String str = AppConstants.HOTCHAT_CENTER_UIN;
        if (!m3.isRecentUserInCache(str, 5001) && (hotChatItemData = this.f194747e.get(0)) != null) {
            QQAppInterface h17 = h();
            if (hotChatItemData.mGameId > 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            ff.T(h17, "cmshow", "Apollo", "reliao_folder_show", i3, 0, new String[0]);
        }
        RecentUser findRecentUserByUin = m3.findRecentUserByUin(str, 5001);
        findRecentUserByUin.uin = str;
        findRecentUserByUin.setType(5001);
        if (findRecentUserByUin.lastmsgtime < j3) {
            findRecentUserByUin.lastmsgtime = j3;
        }
        if (k()) {
            findRecentUserByUin.showUpTime = System.currentTimeMillis() / 1000;
        } else {
            HotChatItemData i16 = i();
            if (i16 != null) {
                findRecentUserByUin.lastmsgtime = i16.mLatestMsgSec;
                findRecentUserByUin.lastmsgdrafttime = i16.mDraftSec;
            }
            findRecentUserByUin.showUpTime = 0L;
        }
        m3.saveRecentUser(findRecentUserByUin);
        return true;
    }

    public void b(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord);
            return;
        }
        QQAppInterface h16 = h();
        if (h16 == null || messageRecord == null || !TextUtils.isEmpty(messageRecord.frienduin)) {
            return;
        }
        try {
            String str = messageRecord.frienduin;
            long j3 = messageRecord.time;
            HotChatItemData g16 = g(h16, str);
            long j16 = messageRecord.time;
            if (j16 > j3) {
                g16.mLatestMsgSec = j16;
            } else {
                g16.mLatestMsgSec = j3;
            }
            Message lastMessage = h16.getMessageFacade().getLastMessage(g16.mTroopUin, 1);
            if (lastMessage != null) {
                long j17 = lastMessage.time;
                if (j17 > g16.mLatestMsgSec) {
                    g16.mLatestMsgSec = j17;
                }
            }
            o(g16);
            c(messageRecord, str);
            m(str, 1);
            a(j3);
        } catch (Throwable th5) {
            QLog.e("HotChatCenterManager", 1, th5, new Object[0]);
        }
    }

    public HotChatItemData f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (HotChatItemData) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<HotChatItemData> it = this.f194747e.iterator();
        while (it.hasNext()) {
            HotChatItemData next = it.next();
            if (str.equals(next.mTroopUin)) {
                return next;
            }
        }
        return null;
    }

    public QQAppInterface h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        WeakReference<QQAppInterface> weakReference = this.f194746d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public HotChatItemData i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (HotChatItemData) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (h() == null) {
            return null;
        }
        l();
        if (this.f194747e.size() <= 0) {
            return null;
        }
        return this.f194747e.get(0);
    }

    public List<HotChatItemData> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (h() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        l();
        if (this.f194747e.size() > 0) {
            arrayList.addAll(this.f194747e);
        }
        return arrayList;
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.C;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (this.f194747e.size() > 0) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HotChatCenterManager", 2, "[loadHotChatDataFromDBIfNeed], threadId:", Long.valueOf(Thread.currentThread().getId()));
        }
        QQAppInterface h16 = h();
        if (h16 == null) {
            return;
        }
        EntityManager entityManager = null;
        try {
            entityManager = h16.getEntityManagerFactory().createEntityManager();
            List<? extends Entity> query = entityManager.query(HotChatItemData.class, false, null, null, null, null, "mLatestMsgSec desc", null);
            if (query != null && query.size() > 0) {
                ArrayList arrayList = (ArrayList) query;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f194747e.add((HotChatItemData) it.next());
                }
                n();
                this.f194748f.clear();
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    HotChatItemData hotChatItemData = (HotChatItemData) it5.next();
                    this.f194748f.put(hotChatItemData.mTroopUin, hotChatItemData);
                }
                e();
                if (QLog.isColorLevel()) {
                    QLog.d("HotChatCenterManager", 2, "mHotChatItemList.size:" + this.f194747e.size());
                    Iterator<HotChatItemData> it6 = this.f194747e.iterator();
                    while (it6.hasNext()) {
                        HotChatItemData next = it6.next();
                        QLog.d("HotChatCenterManager", 2, "gameId:", Integer.valueOf(next.mGameId), ",state:", Integer.valueOf(next.mState), ",code,", next.mHotChatCode);
                    }
                }
            }
        } catch (Throwable th5) {
            try {
                QLog.e("HotChatCenterManager", 1, th5, new Object[0]);
            } finally {
                if (entityManager != null) {
                    entityManager.close();
                }
            }
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        QLog.i("HotChatCenterManager", 1, "destroy HotChatFolderManager.");
        this.f194747e.clear();
        this.f194748f.clear();
        Set<String> set = this.f194751m;
        if (set != null) {
            set.clear();
        }
    }

    public void q(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        if (h() == null) {
            return;
        }
        SharedPreferences sharedPreferences = this.f194750i;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("hotchat_last_read_time", j3).commit();
        }
        this.f194749h = j3;
        Set<String> set = this.f194751m;
        if (set != null) {
            set.clear();
        }
        p();
    }
}
