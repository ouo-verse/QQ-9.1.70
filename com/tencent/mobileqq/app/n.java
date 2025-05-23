package com.tencent.mobileqq.app;

import QQService.AddDiscussMemberInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.DeleteTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.RemoveTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class n implements Manager {
    static IPatchRedirector $redirector_;
    public Map<String, String[]> C;
    public Set<String> D;
    private final ConcurrentHashMap<String, String> E;
    private final ConcurrentHashMap<String, String> F;
    private final ConcurrentHashMap<String, Long> G;
    ArrayList<DiscussionInfo> H;
    private String I;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f196363d;

    /* renamed from: e, reason: collision with root package name */
    private EntityManager f196364e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f196365f;

    /* renamed from: h, reason: collision with root package name */
    private QQConcurrentHashMap<String, DiscussionInfo> f196366h;

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, DiscussionInfo> f196367i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.cache.api.collection.a<String, Map<String, DiscussionMemberInfo>> f196368m;

    public n(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f196365f = false;
        Business business = Business.Conversation;
        this.f196366h = new QQConcurrentHashMap<>(business, "DiscussionInfo");
        this.f196367i = new QQConcurrentHashMap(business, "HideDiscussionInfo");
        this.f196368m = new com.tencent.cache.api.collection.a<>(business, "DiscussionMemberInfo", 100);
        this.C = new ConcurrentHashMap();
        this.D = Collections.synchronizedSet(new HashSet());
        this.E = new ConcurrentHashMap<>();
        this.F = new ConcurrentHashMap<>();
        this.G = new ConcurrentHashMap<>();
        this.H = new ArrayList<>();
        this.f196363d = qQAppInterface;
        this.f196364e = qQAppInterface.getEntityManagerFactory().createEntityManager();
    }

    private void B() {
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (i3 >= 5) {
                break;
            }
            sb5.append(stackTraceElement.getFileName());
            sb5.append("-");
            sb5.append(stackTraceElement.getMethodName());
            sb5.append(";");
            i3++;
        }
        this.I = sb5.toString();
    }

    private void J(int i3, int i16) {
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        if (!iUnitedConfigManager.isSwitchOn("102024", true)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "tryDiscussionReport: switch off");
            }
        } else if (i3 > 0) {
            g(i3, i16);
        } else if (iUnitedConfigManager.isSwitchOn("102025", false)) {
            g(i3, i16);
        }
    }

    private synchronized void b() {
        int size;
        if (QLog.isColorLevel()) {
            QLog.w("Q.contacttab.dscs", 1, "buildDiscussUI, begin, discussList[" + this.H.size() + "], hideDiscussCache[" + this.f196367i.size() + "]");
        }
        QQConcurrentHashMap qQConcurrentHashMap = new QQConcurrentHashMap(Business.Conversation, "HideDiscussionInfo");
        ArrayList<DiscussionInfo> arrayList = new ArrayList<>();
        QQConcurrentHashMap<String, DiscussionInfo> qQConcurrentHashMap2 = this.f196366h;
        if (qQConcurrentHashMap2 != null && (size = qQConcurrentHashMap2.size()) > 0) {
            arrayList.ensureCapacity(size);
            for (DiscussionInfo discussionInfo : this.f196366h.values()) {
                String str = discussionInfo.mCompareSpell;
                if (str == null || str.length() == 0) {
                    j.f(discussionInfo);
                }
                if (discussionInfo.isHidden()) {
                    qQConcurrentHashMap.put(discussionInfo.uin, discussionInfo);
                } else {
                    arrayList.add(discussionInfo);
                }
            }
        }
        synchronized (DiscussionInfo.class) {
            this.H = arrayList;
            this.f196367i = qQConcurrentHashMap;
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.contacttab.dscs", 1, "buildDiscussUI, end, discussList[" + this.H.size() + "], hideDiscussCache[" + this.f196367i.size() + "]");
        }
    }

    private void g(final int i3, final int i16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.m
            @Override // java.lang.Runnable
            public final void run() {
                n.this.z(i16, i3);
            }
        }, 128, null, true);
    }

    private void w() {
        int i3;
        BaseTransaction t16;
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "initDisscussCache begin");
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        boolean z16 = true;
        if (!from.decodeBool("KEY_LOCAL_DB_HAS_DATA", true)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "initDisscussCache end: local db dont have data");
                return;
            }
            return;
        }
        ArrayList arrayList = (ArrayList) this.f196364e.query(DiscussionInfo.class, false, null, null, null, null, null, null);
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(i3);
        if (arrayList != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "initDisscussCache disList.size: " + arrayList.size());
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                DiscussionInfo discussionInfo = (DiscussionInfo) arrayList.get(i16);
                concurrentHashMap.put(discussionInfo.uin, discussionInfo);
                if (com.tencent.mobileqq.utils.ac.r0(this.f196363d, discussionInfo)) {
                    if (com.tencent.mobileqq.utils.ac.B0(this.f196363d, discussionInfo.uin, discussionInfo, n(discussionInfo.uin), false) && (t16 = t(discussionInfo)) != null) {
                        arrayList2.add(t16);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "initDisscussCache, transactionList = " + arrayList2.size());
            }
            if (!arrayList2.isEmpty()) {
                this.f196364e.doMultiDBOperateByTransaction(arrayList2);
            }
        }
        this.f196366h.putAll(concurrentHashMap);
        if (this.f196366h.size() <= 0) {
            z16 = false;
        }
        from.encodeBool("KEY_LOCAL_DB_HAS_DATA", z16);
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "initDisscussCache end: " + concurrentHashMap.size());
        }
    }

    public static boolean x(QQAppInterface qQAppInterface, String str, int i3) {
        if (i3 == 3000) {
            n nVar = (n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            DiscussionInfo i16 = nVar.i(str, true);
            if (i16 == null || i16.isHidden()) {
                return true;
            }
            DiscussionMemberInfo l3 = nVar.l(str, qQAppInterface.getCurrentAccountUin());
            if (l3 != null) {
                if ((l3.flag & 1) != 1) {
                    return false;
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxyUtils", 2, String.format("isDiscussionFilter, discuss meminfo not find, uin:%s, uinType: %d ", str, Integer.valueOf(i3)));
            }
        }
        return false;
    }

    public static boolean y() {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null) {
            QLog.d("Q.contacttab.dscs", 1, "isSupportDelete MobileQQ.sMobileQQ == null");
            return false;
        }
        AppRuntime peekAppRuntime = mobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d("Q.contacttab.dscs", 1, "isSupportDelete appRuntime == null");
            return false;
        }
        boolean z16 = !((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("discussion_to_troop_by_server");
        QLog.d("Q.contacttab.dscs", 1, "discussion_to_troop_by_server isSupportDelete : " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(int i3, int i16) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("selectorName", "reportDiscussion2");
            hashMap.put("functionCallTime", this.I);
            hashMap.put("qq", this.f196363d.getCurrentUin());
            hashMap.put("frontViewController", String.valueOf(i3));
            QQBeaconReport.reportWithAppKey("0S200MNJT807V3GE", this.f196363d.getCurrentUin(), "groupFunctionCall", hashMap);
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "doDiscussionReport: size=" + i16);
            }
        } catch (Exception e16) {
            QLog.e("Q.contacttab.dscs", 2, "reportDiscussion: ", e16);
        }
    }

    public boolean A(String str) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str)).booleanValue();
        }
        DiscussionInfo h16 = h(str);
        boolean z18 = false;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("reShowDiscuss begin, uin[");
            sb5.append(str);
            sb5.append("], info[");
            if (h16 != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            sb5.append(z17);
            sb5.append("], discussList[");
            sb5.append(this.H.size());
            sb5.append("], hideDiscussCache[");
            sb5.append(this.f196367i.size());
            sb5.append("]");
            QLog.w("Q.contacttab.dscs", 1, sb5.toString());
        }
        if (h16 != null) {
            synchronized (DiscussionInfo.class) {
                this.f196367i.remove(h16.uin);
                Iterator<DiscussionInfo> it = this.H.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().uin == h16.uin) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    this.H.add(h16);
                }
            }
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("reShowDiscuss end, uin[");
            sb6.append(str);
            sb6.append("], info[");
            if (h16 != null) {
                z18 = true;
            }
            sb6.append(z18);
            sb6.append("], bExist[");
            sb6.append(z16);
            sb6.append("], discussList[");
            sb6.append(this.H.size());
            sb6.append("], hideDiscussCache[");
            sb6.append(this.f196367i.size());
            sb6.append("]");
            QLog.w("Q.contacttab.dscs", 1, sb6.toString());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C(ArrayList<DiscussionInfo> arrayList, long j3, boolean z16) {
        boolean z17 = false;
        try {
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null && arrayList.size() > 0) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    DiscussionInfo discussionInfo = arrayList.get(i3);
                    this.f196366h.put(discussionInfo.uin, discussionInfo);
                    BaseTransaction t16 = t(discussionInfo);
                    if (t16 != null) {
                        arrayList2.add(t16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.contacttab.dscs", 2, "disUin=" + discussionInfo.uin.substring(0, 4) + " has been updated");
                    }
                }
            }
            if (z16) {
                Iterator<Map.Entry<String, DiscussionInfo>> it = this.f196366h.entrySet().iterator();
                while (it.hasNext()) {
                    DiscussionInfo value = it.next().getValue();
                    if (value.timeSec < j3) {
                        it.remove();
                        arrayList2.add(new RemoveTransaction(value));
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.contacttab.dscs", 2, "disUin=" + value.uin.substring(0, 4) + " has been removed");
                        }
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                this.f196364e.doMultiDBOperateByTransaction(arrayList2);
            }
            z17 = true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.contacttab.dscs", 2, "saveAllDiscussions exception:", e16);
            }
        }
        b();
        return z17;
    }

    public void D(DiscussionInfo discussionInfo) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) discussionInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("saveDiscussInfo ");
            if (discussionInfo != null) {
                obj = discussionInfo.uin;
            } else {
                obj = -1;
            }
            sb5.append(obj);
            QLog.d("Q.contacttab.dscs", 2, sb5.toString());
        }
        if (discussionInfo == null) {
            return;
        }
        QQConcurrentHashMap<String, DiscussionInfo> qQConcurrentHashMap = this.f196366h;
        if (qQConcurrentHashMap != null) {
            qQConcurrentHashMap.put(discussionInfo.uin, discussionInfo);
        }
        N(discussionInfo);
        ProxyManager proxyManager = this.f196363d.getProxyManager();
        RecentUser findRecentUserByUin = proxyManager.m().findRecentUserByUin(discussionInfo.uin, 3000);
        if (findRecentUserByUin.getStatus() == 1001) {
            findRecentUserByUin.displayName = discussionInfo.discussionName;
            proxyManager.m().saveRecentUser(findRecentUserByUin);
        }
        b();
    }

    public void E(DiscussionMemberInfo discussionMemberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) discussionMemberInfo);
            return;
        }
        if (discussionMemberInfo != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfo " + discussionMemberInfo);
            }
            Map<String, DiscussionMemberInfo> n3 = n(discussionMemberInfo.discussionUin);
            if (n3 != null) {
                n3.put(discussionMemberInfo.memberUin, discussionMemberInfo);
            }
            N(discussionMemberInfo);
            DiscussionInfo h16 = h(discussionMemberInfo.discussionUin);
            if (h16 != null && com.tencent.mobileqq.utils.ac.B0(this.f196363d, discussionMemberInfo.discussionUin, h16, n3, false)) {
                N(h16);
            }
        }
    }

    public void F(List<DiscussionMemberInfo> list) {
        StringBuffer stringBuffer;
        BaseTransaction t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList");
        }
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                E(list.get(0));
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArraySet<String> arraySet = new ArraySet();
            HashSet hashSet = new HashSet();
            try {
                if (QLog.isColorLevel()) {
                    stringBuffer = new StringBuffer();
                } else {
                    stringBuffer = null;
                }
                for (DiscussionMemberInfo discussionMemberInfo : list) {
                    String str = discussionMemberInfo.discussionUin + "_" + discussionMemberInfo.memberUin;
                    if (QLog.isColorLevel()) {
                        stringBuffer.append(str);
                        stringBuffer.append(";");
                    }
                    if (!hashSet.contains(str)) {
                        BaseTransaction t17 = t(discussionMemberInfo);
                        if (t17 != null) {
                            arrayList.add(t17);
                            arraySet.add(discussionMemberInfo.discussionUin);
                        }
                        hashSet.add(str);
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f196364e.doMultiDBOperateByTransaction(arrayList);
                }
                arrayList.clear();
                for (String str2 : arraySet) {
                    Map<String, DiscussionMemberInfo> n3 = n(str2);
                    DiscussionInfo h16 = h(str2);
                    if (h16 != null && com.tencent.mobileqq.utils.ac.B0(this.f196363d, str2, h16, n3, false) && (t16 = t(h16)) != null) {
                        arrayList.add(t16);
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f196364e.doMultiDBOperateByTransaction(arrayList);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList info=" + stringBuffer.toString());
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList ex=", e16);
                }
            }
        }
    }

    public void G(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, str, Long.valueOf(j3));
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (j3 == 0) {
                this.G.remove(str);
            } else {
                this.G.put(str, Long.valueOf(j3));
            }
        }
    }

    public void H(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            this.E.remove(str);
        } else {
            this.E.put(str, str2);
            this.F.put(str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public DiscussionInfo I(@NonNull List<AddDiscussMemberInfo> list) {
        Map<String, DiscussionMemberInfo> n3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (DiscussionInfo) iPatchRedirector.redirect((short) 32, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, DiscussionInfo>> it = this.f196366h.entrySet().iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            DiscussionInfo value = it.next().getValue();
            if (!value.isDiscussHrMeeting() && (n3 = n(value.uin)) != null && list.size() + 1 == n3.size()) {
                Iterator<AddDiscussMemberInfo> it5 = list.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        if (!n3.containsKey(String.valueOf(it5.next().getUin()))) {
                            break;
                        }
                    } else {
                        z16 = true;
                        break;
                    }
                }
                if (z16) {
                    arrayList.add(value);
                }
            }
        }
        DiscussionInfo discussionInfo = null;
        if (arrayList.size() == 0) {
            return null;
        }
        if (arrayList.size() == 1) {
            return (DiscussionInfo) arrayList.get(0);
        }
        Iterator it6 = arrayList.iterator();
        long j3 = 0;
        while (it6.hasNext()) {
            DiscussionInfo discussionInfo2 = (DiscussionInfo) it6.next();
            long j16 = discussionInfo2.createTime;
            if (j16 > j3) {
                discussionInfo = discussionInfo2;
                j3 = j16;
            }
        }
        return discussionInfo;
    }

    public void K(DiscussionInfo discussionInfo) {
        ArrayList<DiscussionInfo> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) discussionInfo);
            return;
        }
        if (discussionInfo != null && (arrayList = this.H) != null) {
            Iterator<DiscussionInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                DiscussionInfo next = it.next();
                if (next.uin.equals(discussionInfo.uin)) {
                    next.hasCollect = discussionInfo.hasCollect;
                    return;
                }
            }
        }
    }

    public void L(String str, DiscussionInfo discussionInfo, long j3, Map<String, DiscussionMemberInfo> map, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, discussionInfo, Long.valueOf(j3), map, Long.valueOf(j16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionVerify", 2, "updateDiscussionMemberByTimestamp disUin=" + str + " list size=" + map.size() + " time=" + j16);
        }
        Map<String, DiscussionMemberInfo> f16 = this.f196368m.f(str, map);
        if (f16 != null && QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "updateDiscussionMemberByTimestamp change cache member list oldsize=" + f16.size() + " newsize=" + map.size());
        }
        HashSet hashSet = new HashSet();
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, DiscussionMemberInfo>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                DiscussionMemberInfo value = it.next().getValue();
                String str2 = value.discussionUin + "_" + value.memberUin;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.contacttab.dscs", 2, "updateDiscussionMemberByTimestamp info=" + str2);
                }
                if (!hashSet.contains(str2)) {
                    hashSet.add(str2);
                    BaseTransaction t16 = t(discussionInfo);
                    if (t16 != null) {
                        arrayList.add(t16);
                    }
                }
            }
            if (this.f196363d.getWritableDatabase() != null) {
                arrayList.add(new DeleteTransaction(new DiscussionMemberInfo().getTableName(), "discussionUin=? and dataTime<?", new String[]{str, String.valueOf(j16)}));
            }
            discussionInfo.infoSeq = j3;
            QQConcurrentHashMap<String, DiscussionInfo> qQConcurrentHashMap = this.f196366h;
            if (qQConcurrentHashMap != null) {
                qQConcurrentHashMap.put(discussionInfo.uin, discussionInfo);
            }
            BaseTransaction t17 = t(discussionInfo);
            if (t17 != null) {
                arrayList.add(t17);
            }
            if (!arrayList.isEmpty()) {
                this.f196364e.doMultiDBOperateByTransaction(arrayList);
            }
            com.tencent.mobileqq.utils.ac.B0(this.f196363d, str, discussionInfo, map, false);
            ProxyManager proxyManager = this.f196363d.getProxyManager();
            RecentUser findRecentUserByUin = proxyManager.m().findRecentUserByUin(discussionInfo.uin, 3000);
            if (findRecentUserByUin.getStatus() == 1001) {
                findRecentUserByUin.displayName = discussionInfo.discussionName;
                proxyManager.m().saveRecentUser(findRecentUserByUin);
            }
            b();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "updateDiscussionMemberByTimestamp update db error=", e16);
            }
        }
    }

    public void M(String str, String str2) {
        BaseTransaction t16;
        DiscussionMemberInfo discussionMemberInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ArrayList arrayList = (ArrayList) this.f196364e.query(DiscussionMemberInfo.class, false, "memberUin=?", new String[]{str}, null, null, "memberUin", null);
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str3 = ((DiscussionMemberInfo) it.next()).discussionUin;
                    DiscussionInfo h16 = h(str3);
                    Map<String, DiscussionMemberInfo> n3 = n(str3);
                    if (n3 != null && (discussionMemberInfo = n3.get(str)) != null) {
                        discussionMemberInfo.inteRemark = str2;
                        discussionMemberInfo.inteRemarkSource = 128L;
                        arrayList2.add(new UpdateTransaction(discussionMemberInfo));
                    }
                    if (h16 != null) {
                        h16.DiscussionFlag |= 536870912;
                        if (com.tencent.mobileqq.utils.ac.B0(this.f196363d, str3, h16, n3, false) && (t16 = t(h16)) != null) {
                            arrayList2.add(t16);
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    this.f196364e.doMultiDBOperateByTransaction(arrayList2);
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.contacttab.dscs", 2, "updateDiscussionMemberAll ex=", e16);
            }
        }
    }

    public boolean N(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) entity)).booleanValue();
        }
        if (entity.getStatus() == 1000) {
            this.f196364e.persistOrReplace(entity);
            if (entity.getStatus() != 1001) {
                return false;
            }
            return true;
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return false;
        }
        return this.f196364e.update(entity);
    }

    public boolean c(RecentUserProxy recentUserProxy, String str) {
        RecentUser findRecentUserByUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) recentUserProxy, (Object) str)).booleanValue();
        }
        if (this.f196363d == null) {
            return false;
        }
        d(str);
        if (recentUserProxy == null) {
            recentUserProxy = ((IRecentUserProxyService) this.f196363d.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        }
        if (recentUserProxy == null || (findRecentUserByUin = recentUserProxy.findRecentUserByUin(str, 3000)) == null) {
            return false;
        }
        recentUserProxy.delRecentUser(findRecentUserByUin, true);
        return true;
    }

    public boolean d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str)).booleanValue();
        }
        DiscussionInfo h16 = h(str);
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "deleteDiscuss uin=" + str);
        }
        if (h16 != null) {
            this.f196366h.remove(str);
            this.f196368m.g(str);
            DBMethodProxy.execSQL(this.f196364e, "delete from DiscussionMemberInfo where discussionUin='" + str + "'");
            this.f196364e.remove(h16);
            b();
            return true;
        }
        return true;
    }

    public void e(String str, String str2) {
        DiscussionMemberInfo discussionMemberInfo;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMember disUin=" + str + " memberUin=" + str2);
        }
        Map<String, DiscussionMemberInfo> e16 = this.f196368m.e(str);
        if (e16 != null) {
            discussionMemberInfo = e16.remove(str2);
            if (QLog.isColorLevel()) {
                if (("removed from cache " + discussionMemberInfo) != null) {
                    str3 = "true";
                } else {
                    str3 = "false";
                }
                QLog.d("Q.contacttab.dscs", 2, str3);
            }
        } else {
            discussionMemberInfo = null;
        }
        if (discussionMemberInfo == null) {
            discussionMemberInfo = (DiscussionMemberInfo) DBMethodProxy.find(this.f196364e, (Class<? extends Entity>) DiscussionMemberInfo.class, str, str2);
        }
        if (discussionMemberInfo != null) {
            this.f196364e.remove(discussionMemberInfo);
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "removed from db ");
            }
        }
    }

    public void f(String str, Set<String> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) set);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMembers disuin=" + str);
        }
        if (DiscussionInfo.isValidDisUin(str) && set != null && set.size() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                Map<String, DiscussionMemberInfo> n3 = n(str);
                if (n3 != null) {
                    StringBuilder sb5 = new StringBuilder(set.size() * 8);
                    if (QLog.isColorLevel()) {
                        sb5.append("remove member=");
                    }
                    for (String str2 : set) {
                        DiscussionMemberInfo remove = n3.remove(str2);
                        if (remove != null) {
                            arrayList.add(new RemoveTransaction(remove));
                            if (QLog.isColorLevel()) {
                                sb5.append(str2.substring(0, 4));
                                sb5.append("|");
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.contacttab.dscs", 2, sb5.toString());
                    }
                }
                DiscussionInfo h16 = h(str);
                if (com.tencent.mobileqq.utils.ac.B0(this.f196363d, str, h16, n3, false)) {
                    arrayList.add(new UpdateTransaction(h16));
                }
                if (!arrayList.isEmpty()) {
                    this.f196364e.doMultiDBOperateByTransaction(arrayList);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMembers exp disUin=" + str, e16);
                }
            }
        }
    }

    public DiscussionInfo h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (DiscussionInfo) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        return i(str, false);
    }

    public DiscussionInfo i(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (DiscussionInfo) iPatchRedirector.redirect((short) 18, this, str, Boolean.valueOf(z16));
        }
        if (!DiscussionInfo.isValidDisUin(str)) {
            return null;
        }
        DiscussionInfo discussionInfo = this.f196366h.get(str);
        if (discussionInfo == null && !z16 && !this.f196365f) {
            discussionInfo = (DiscussionInfo) DBMethodProxy.find(this.f196364e, (Class<? extends Entity>) DiscussionInfo.class, str);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("findDiscussionInfoByID db ");
                if (discussionInfo == null) {
                    z17 = false;
                }
                sb5.append(z17);
                QLog.d("Q.contacttab.dscs", 2, sb5.toString());
            }
            if (discussionInfo != null) {
                this.f196366h.put(str, discussionInfo);
            }
        }
        return discussionInfo;
    }

    @Nullable
    public String j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
        }
        return this.E.get(str);
    }

    public ArrayList<DiscussionInfo> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (!this.f196365f) {
            B();
            v();
        }
        return this.H;
    }

    public DiscussionMemberInfo l(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (DiscussionMemberInfo) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) str2);
        }
        Map<String, DiscussionMemberInfo> n3 = n(str);
        if (n3 != null) {
            return n3.get(str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfo null");
        }
        return null;
    }

    public ArrayList<DiscussionMemberInfo> m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        Map<String, DiscussionMemberInfo> n3 = n(str);
        ArrayList<DiscussionMemberInfo> arrayList = new ArrayList<>();
        if (n3 != null && n3.size() > 0) {
            arrayList.addAll(n3.values());
        }
        return arrayList;
    }

    public Map<String, DiscussionMemberInfo> n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Map) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin param is null");
            }
            return null;
        }
        Map<String, DiscussionMemberInfo> e16 = this.f196368m.e(str);
        if (e16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin from map list disUin=" + str + " size=" + e16.size());
                return e16;
            }
            return e16;
        }
        List<? extends Entity> query = this.f196364e.query(DiscussionMemberInfo.class, false, "discussionUin=? ", new String[]{str}, null, null, "memberUin", null);
        if (query == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin from DB list is null disUin=" + str);
            }
            return null;
        }
        HashMap hashMap = new HashMap(query.size());
        Iterator<? extends Entity> it = query.iterator();
        while (it.hasNext()) {
            DiscussionMemberInfo discussionMemberInfo = (DiscussionMemberInfo) it.next();
            hashMap.put(discussionMemberInfo.memberUin, discussionMemberInfo);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin from db list disUin=" + str + " size=" + hashMap.size());
        }
        this.f196368m.f(str, hashMap);
        return hashMap;
    }

    public ArrayList<String> o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (ArrayList) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<DiscussionMemberInfo> m3 = m(str);
        if (m3 != null) {
            Iterator<DiscussionMemberInfo> it = m3.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().memberUin);
            }
            arrayList = GroupIconHelper.H(arrayList);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(this.f196363d.getCurrentAccountUin());
        }
        return arrayList;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f196364e.close();
        }
    }

    public Map<String, ArrayList<DiscussionMemberInfo>> p(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this, (Object) strArr);
        }
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, new ArrayList());
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("discussionUin in (");
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (i3 != 0) {
                sb5.append(",");
            }
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        }
        sb5.append(")");
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i16 = 0; i16 < length; i16++) {
            strArr2[i16] = SecurityUtile.encode(strArr[i16]);
        }
        List<? extends Entity> query = this.f196364e.query(DiscussionMemberInfo.class, false, sb5.toString(), strArr2, "memberUin", null, "memberUin", null);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                DiscussionMemberInfo discussionMemberInfo = (DiscussionMemberInfo) it.next();
                ((List) hashMap.get(discussionMemberInfo.discussionUin)).add(discussionMemberInfo);
            }
        }
        return hashMap;
    }

    public int q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).intValue();
        }
        Map<String, DiscussionMemberInfo> n3 = n(str);
        if (n3 != null) {
            return n3.size();
        }
        return 0;
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int i3 = 0;
        if (this.f196365f) {
            Iterator<DiscussionInfo> it = this.H.iterator();
            while (it.hasNext()) {
                if (it.next().hasCollect) {
                    i3++;
                }
            }
        }
        return i3;
    }

    public long s(String str) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Long) iPatchRedirector.redirect((short) 35, (Object) this, (Object) str)).longValue();
        }
        if (TextUtils.isEmpty(str) || (l3 = this.G.get(str)) == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public BaseTransaction t(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (BaseTransaction) iPatchRedirector.redirect((short) 28, (Object) this, (Object) entity);
        }
        if (entity.getStatus() == 1000) {
            return new PersistOrReplaceTransaction(entity);
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return null;
        }
        return new UpdateTransaction(entity);
    }

    public boolean u(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str)).booleanValue();
        }
        DiscussionInfo h16 = h(str);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("hideDiscuss begin, uin[");
            sb5.append(str);
            sb5.append("], info[");
            if (h16 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("], discussList[");
            sb5.append(this.H.size());
            sb5.append("], hideDiscussCache[");
            sb5.append(this.f196367i.size());
            sb5.append("]");
            QLog.w("Q.contacttab.dscs", 1, sb5.toString());
        }
        if (h16 != null) {
            synchronized (DiscussionInfo.class) {
                this.f196367i.put(h16.uin, h16);
                this.H.remove(h16);
            }
            if (QLog.isColorLevel()) {
                QLog.w("Q.contacttab.dscs", 1, "hideDiscuss end, uin[" + str + "], discussList[" + this.H.size() + "], hideDiscussCache[" + this.f196367i.size() + "]");
            }
        }
        return true;
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        w();
        b();
        J(this.f196366h.size(), this.H.size());
        this.f196365f = true;
    }
}
