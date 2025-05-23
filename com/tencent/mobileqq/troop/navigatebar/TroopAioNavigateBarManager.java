package com.tencent.mobileqq.troop.navigatebar;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.BaseMessageNavigateInfo;
import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IDBUtilApi;
import com.tencent.mobileqq.troop.navigatebar.b;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioNavigateBarManager extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected final ConcurrentHashMap<String, List<TroopMessageNavigateInfo>> f297979e;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f297980f;

    public TroopAioNavigateBarManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f297979e = new ConcurrentHashMap<>();
            this.f297980f = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String g(String str, int i3) {
        if (i3 == 1) {
            return str;
        }
        if (i3 == 3000) {
            return str + ContainerUtils.FIELD_DELIMITER + 3000;
        }
        return str;
    }

    private TroopMessageNavigateInfo i(TroopMessageNavigateInfo troopMessageNavigateInfo, List<TroopMessageNavigateInfo> list) {
        if (list == null || list.isEmpty() || troopMessageNavigateInfo == null) {
            return null;
        }
        if (list.contains(troopMessageNavigateInfo)) {
            return troopMessageNavigateInfo;
        }
        for (TroopMessageNavigateInfo troopMessageNavigateInfo2 : list) {
            if (troopMessageNavigateInfo2.shmsgseq == troopMessageNavigateInfo.shmsgseq) {
                return troopMessageNavigateInfo2;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.b
    public synchronized void b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAioNavigateBarManager", 2, "clearTroopMsgNavigateInfo: troopCode = " + str + ", type = " + i3);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f297979e.containsKey(str)) {
            List<TroopMessageNavigateInfo> list = this.f297979e.get(str);
            if (bl.b(list)) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                TroopMessageNavigateInfo troopMessageNavigateInfo = list.get(size);
                if (i3 == troopMessageNavigateInfo.type || i3 == 0) {
                    if (troopMessageNavigateInfo.status == BaseMessageNavigateInfo.STATUS_ADD) {
                        list.remove(size);
                    } else {
                        troopMessageNavigateInfo.status = BaseMessageNavigateInfo.STATUS_DELETE;
                    }
                }
            }
            if (list.isEmpty()) {
                this.f297979e.remove(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.b
    public synchronized List<Long> c(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
        }
        m();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder("getMultiNavigateSeqList, troopUin = ");
        sb5.append(str);
        sb5.append(", type = ");
        sb5.append(i3);
        sb5.append(", seqList = ");
        if (this.f297979e.containsKey(str)) {
            List<TroopMessageNavigateInfo> list = this.f297979e.get(str);
            if (bl.b(list)) {
                sb5.append("null");
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAioNavigateBarManager", 2, " getMultiNavigateSeqList " + sb5.toString());
                }
                return arrayList;
            }
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                TroopMessageNavigateInfo troopMessageNavigateInfo = list.get(i16);
                if (troopMessageNavigateInfo.status != BaseMessageNavigateInfo.STATUS_DELETE && troopMessageNavigateInfo.type == i3) {
                    arrayList.add(Long.valueOf(troopMessageNavigateInfo.msgseq));
                    sb5.append(troopMessageNavigateInfo.msgseq);
                    sb5.append(",");
                }
            }
        }
        if (QLog.isColorLevel() && arrayList.size() > 0) {
            QLog.d("TroopAioNavigateBarManager", 2, " getMultiNavigateSeqList " + sb5.toString());
        }
        return arrayList;
    }

    public synchronized TroopMessageNavigateInfo e(String str, int i3, long j3, long j16, String str2, int i16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopMessageNavigateInfo) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2, Integer.valueOf(i16), obj);
        }
        TroopMessageNavigateInfo troopMessageNavigateInfo = null;
        if (i3 <= 0) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAioNavigateBarManager", 2, "addTroopMsgNavigateInfo, troopCode = " + str + ", navType = " + i3 + ", shMsgSeq = " + j3 + " ,uinseq = " + j16 + " ,summary = " + str2 + ", flowersCount = " + i16);
        }
        TroopMessageNavigateInfo troopMessageNavigateInfo2 = new TroopMessageNavigateInfo();
        troopMessageNavigateInfo2.type = i3;
        troopMessageNavigateInfo2.troopCode = str;
        troopMessageNavigateInfo2.shmsgseq = j3;
        troopMessageNavigateInfo2.msgseq = j16;
        troopMessageNavigateInfo2.summary = str2;
        troopMessageNavigateInfo2.extObj = obj;
        List<TroopMessageNavigateInfo> list = this.f297979e.get(str);
        if (!bl.b(list)) {
            if (h.a(i3)) {
                TroopMessageNavigateInfo i17 = i(troopMessageNavigateInfo2, list);
                if (i17 == null) {
                    troopMessageNavigateInfo2.status = BaseMessageNavigateInfo.STATUS_ADD;
                    list.add(troopMessageNavigateInfo2);
                    q(str);
                } else {
                    if (b.a(troopMessageNavigateInfo2.type, i17.type) > 0) {
                        i17.status = BaseMessageNavigateInfo.STATUS_MODIFY;
                        i17.type = troopMessageNavigateInfo2.type;
                        i17.extObj = obj;
                    }
                    troopMessageNavigateInfo2 = i17;
                }
            } else {
                int size = list.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    if (i3 == list.get(size).type) {
                        troopMessageNavigateInfo = list.get(size);
                        break;
                    }
                    size--;
                }
                int a16 = NavConstants.a(i3);
                if (i3 != 1 && troopMessageNavigateInfo != null && troopMessageNavigateInfo.status != BaseMessageNavigateInfo.STATUS_DELETE) {
                    TroopMessageNavigateInfo troopMessageNavigateInfo3 = troopMessageNavigateInfo;
                    if (!com.tencent.mobileqq.troop.data.d.f(NavConstants.a(troopMessageNavigateInfo.type), troopMessageNavigateInfo.shmsgseq, a16, j3)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopAioNavigateBarManager", 2, "addTroopMsgNavigateInfo, but do not need update, shMsgSeq = " + j3);
                        }
                        troopMessageNavigateInfo2.receivedFlowserCount = i16;
                        r(troopMessageNavigateInfo2, troopMessageNavigateInfo3, i3, troopMessageNavigateInfo3.receivedFlowserCount);
                    } else {
                        troopMessageNavigateInfo = troopMessageNavigateInfo3;
                    }
                }
                if (size >= 0) {
                    list.remove(size);
                }
                d(troopMessageNavigateInfo, troopMessageNavigateInfo2, i3);
                r(troopMessageNavigateInfo, troopMessageNavigateInfo2, i3, i16);
                list.add(troopMessageNavigateInfo2);
                q(str);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAioNavigateBarManager", 2, "addTroopMsgNavigateInfo,  param= " + troopMessageNavigateInfo2);
            }
            troopMessageNavigateInfo2.status = BaseMessageNavigateInfo.STATUS_ADD;
            if (i3 == 26) {
                troopMessageNavigateInfo2.receivedFlowserCount = i16;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(troopMessageNavigateInfo2);
            this.f297979e.put(str, arrayList);
        }
        return troopMessageNavigateInfo2;
    }

    public synchronized void f(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (!n(i3)) {
                return;
            }
            b(g(str, i3), i16);
        }
    }

    protected String h() {
        int size;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mapTroopNavigateInfo: size = ");
        sb5.append(this.f297979e.size());
        sb5.append(" {");
        int i3 = 0;
        for (Map.Entry<String, List<TroopMessageNavigateInfo>> entry : this.f297979e.entrySet()) {
            List<TroopMessageNavigateInfo> value = entry.getValue();
            sb5.append(entry.getKey());
            sb5.append(": size = ");
            if (value == null) {
                size = 0;
            } else {
                size = value.size();
            }
            sb5.append(size);
            sb5.append("->{ ");
            if (value != null) {
                int i16 = 0;
                for (TroopMessageNavigateInfo troopMessageNavigateInfo : value) {
                    sb5.append(troopMessageNavigateInfo.toString());
                    sb5.append("|extName=");
                    Object obj = troopMessageNavigateInfo.extObj;
                    if (obj != null) {
                        str = obj.getClass().getSimpleName();
                    } else {
                        str = "None";
                    }
                    sb5.append(str);
                    sb5.append(" ");
                    i16++;
                    if (i16 >= 10) {
                        break;
                    }
                }
            }
            sb5.append(" } ");
            i3++;
            if (i3 >= 20) {
                break;
            }
        }
        sb5.append(" }");
        return sb5.toString();
    }

    @Nullable
    public synchronized TroopMessageNavigateInfo j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TroopMessageNavigateInfo) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        m();
        if (this.f297979e.containsKey(str)) {
            List<TroopMessageNavigateInfo> list = this.f297979e.get(str);
            if (bl.b(list)) {
                return null;
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                TroopMessageNavigateInfo troopMessageNavigateInfo = list.get(i3);
                if (troopMessageNavigateInfo.status != BaseMessageNavigateInfo.STATUS_DELETE) {
                    return troopMessageNavigateInfo;
                }
            }
        }
        return null;
    }

    public synchronized long k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).longValue();
        }
        TroopMessageNavigateInfo j3 = j(str);
        if (j3 != null) {
            return j3.msgseq;
        }
        return 0L;
    }

    public synchronized void l() {
        int i3;
        int i16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f297980f) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAioNavigateBarManager", 2, "initTroopMessageNavigateInfo before, " + h());
        }
        EntityManager createEntityManager = this.f297981d.getEntityManagerFactory().createEntityManager();
        ArrayList arrayList = (ArrayList) createEntityManager.query(TroopMessageNavigateInfo.class, false, null, null, null, null, null, null);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TroopMessageNavigateInfo troopMessageNavigateInfo = (TroopMessageNavigateInfo) ((Entity) it.next());
                if (troopMessageNavigateInfo != null && troopMessageNavigateInfo.getId() < 0) {
                    troopMessageNavigateInfo.status = BaseMessageNavigateInfo.STATUS_DELETE;
                    createEntityManager.remove(troopMessageNavigateInfo);
                } else if (troopMessageNavigateInfo != null && !TextUtils.isEmpty(troopMessageNavigateInfo.troopCode)) {
                    boolean z17 = false;
                    if (troopMessageNavigateInfo.extObjType == 1 && !TextUtils.isEmpty(troopMessageNavigateInfo.extObjJsonStr)) {
                        troopMessageNavigateInfo.extObj = ((IDBUtilApi) QRoute.api(IDBUtilApi.class)).transJsonToAioNavMsg(troopMessageNavigateInfo.extObjJsonStr);
                        if (QLog.isDebugVersion()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("toTrans : ");
                            sb5.append(troopMessageNavigateInfo.extObjJsonStr);
                            sb5.append(", ext is null ? ");
                            if (troopMessageNavigateInfo.extObj == null) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            sb5.append(z16);
                            QLog.d("TroopAioNavigateBarManager", 1, sb5.toString());
                        }
                    }
                    List<TroopMessageNavigateInfo> list = this.f297979e.get(troopMessageNavigateInfo.troopCode);
                    if (list != null) {
                        for (TroopMessageNavigateInfo troopMessageNavigateInfo2 : list) {
                            if (troopMessageNavigateInfo2 != null && ((i3 = troopMessageNavigateInfo2.type) == (i16 = troopMessageNavigateInfo.type) || b.a(i3, i16) > 0)) {
                                long j3 = troopMessageNavigateInfo2.shmsgseq;
                                if (j3 == 0 || j3 != troopMessageNavigateInfo.shmsgseq) {
                                    long j16 = troopMessageNavigateInfo2.msgseq;
                                    if (j16 != 0 && j16 == troopMessageNavigateInfo.msgseq) {
                                    }
                                }
                                troopMessageNavigateInfo2.status = BaseMessageNavigateInfo.STATUS_MODIFY;
                                troopMessageNavigateInfo2.setId(troopMessageNavigateInfo.getId());
                                troopMessageNavigateInfo2.setStatus(troopMessageNavigateInfo.getStatus());
                                z17 = true;
                                break;
                            }
                        }
                    } else {
                        list = new ArrayList<>();
                        this.f297979e.put(troopMessageNavigateInfo.troopCode, list);
                    }
                    if (!z17) {
                        troopMessageNavigateInfo.status = BaseMessageNavigateInfo.STATUS_NORMAL;
                        list.add(troopMessageNavigateInfo);
                        q(troopMessageNavigateInfo.troopCode);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAioNavigateBarManager", 2, "initTroopMessageNavigateInfo after, " + h());
        }
        this.f297980f = true;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (this.f297980f) {
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAioNavigateBarManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TroopAioNavigateBarManager.this.l();
                    }
                }
            }, 32, null, false);
        }
    }

    protected boolean n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, i3)).booleanValue();
        }
        if (i3 == 1 || i3 == 3000) {
            return true;
        }
        return false;
    }

    public synchronized int o(String str, @NonNull List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str, (Object) list)).intValue();
        }
        List<TroopMessageNavigateInfo> list2 = this.f297979e.get(str);
        int i3 = 0;
        if (list2 != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet(list);
            int i16 = 0;
            for (TroopMessageNavigateInfo troopMessageNavigateInfo : list2) {
                if (hashSet.contains(Long.valueOf(troopMessageNavigateInfo.msgseq)) || hashSet.contains(Long.valueOf(troopMessageNavigateInfo.shmsgseq))) {
                    int i17 = troopMessageNavigateInfo.status;
                    int i18 = BaseMessageNavigateInfo.STATUS_DELETE;
                    if (i17 != i18) {
                        troopMessageNavigateInfo.status = i18;
                        i16++;
                    }
                }
                i3++;
            }
            QLog.i("TroopAioNavigateBarManager", 1, "removeTroopMsgNavigateInfo, troopUin=" + str + ", msgSeq=" + list + ", delete=" + i16 + ", listSize=" + i3);
            return i16;
        }
        return 0;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            if (!this.f297980f) {
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAioNavigateBarManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        TroopAioNavigateBarManager.this.p();
                    } catch (Throwable th5) {
                        QLog.d("TroopAioNavigateBarManager", 1, th5, new Object[0]);
                    }
                }
            }, 32, null, false);
        }
    }

    protected synchronized void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!this.f297980f) {
            return;
        }
        l();
        if (QLog.isDebugVersion()) {
            QLog.d("TroopAioNavigateBarManager", 4, "saveToDB before, " + h());
        }
        boolean c16 = com.tencent.mobileqq.troop.navigatebar.expriment.a.c();
        boolean z16 = false;
        for (Map.Entry<String, List<TroopMessageNavigateInfo>> entry : this.f297979e.entrySet()) {
            List<TroopMessageNavigateInfo> value = entry.getValue();
            Iterator<TroopMessageNavigateInfo> it = value.iterator();
            while (it.hasNext()) {
                TroopMessageNavigateInfo next = it.next();
                if (next != null) {
                    if (!c16) {
                        next.extObjType = 0;
                        next.extObjJsonStr = "";
                    }
                    int i3 = next.status;
                    if (i3 == BaseMessageNavigateInfo.STATUS_ADD) {
                        this.f297981d.getProxyManagerInner().doAddMsgQueue(next.troopCode, 1, next.getTableName(), next, 3, null);
                    } else if (i3 == BaseMessageNavigateInfo.STATUS_MODIFY) {
                        this.f297981d.getProxyManagerInner().doAddMsgQueue(next.troopCode, 1, next.getTableName(), next, 4, null);
                    } else if (i3 == BaseMessageNavigateInfo.STATUS_DELETE) {
                        it.remove();
                        this.f297981d.getProxyManagerInner().doAddMsgQueue(next.troopCode, 1, next.getTableName(), next, 5, null);
                    }
                    z16 = true;
                }
            }
            if (value.isEmpty()) {
                this.f297979e.remove(entry.getKey());
            }
        }
        if (z16) {
            this.f297981d.getProxyManagerInner().saveNotify();
        }
    }

    protected synchronized void q(String str) {
        List<TroopMessageNavigateInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str) && (list = this.f297979e.get(str)) != null) {
            try {
                Collections.sort(list, new b.a());
            } catch (Exception e16) {
                QLog.d("TroopAioNavigateBarManager", 1, "sortNavigationList error: ", e16);
            }
        }
    }

    protected void r(@Nullable TroopMessageNavigateInfo troopMessageNavigateInfo, TroopMessageNavigateInfo troopMessageNavigateInfo2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, troopMessageNavigateInfo, troopMessageNavigateInfo2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 != 26) {
            return;
        }
        if (troopMessageNavigateInfo != null && troopMessageNavigateInfo.status != BaseMessageNavigateInfo.STATUS_DELETE) {
            troopMessageNavigateInfo2.receivedFlowserCount = troopMessageNavigateInfo.receivedFlowserCount + i16;
        } else {
            troopMessageNavigateInfo2.receivedFlowserCount = i16;
        }
    }

    public TroopAioNavigateBarManager(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
            return;
        }
        this.f297979e = new ConcurrentHashMap<>();
        this.f297980f = false;
        m();
    }
}
