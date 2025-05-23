package com.tencent.mobileqq.troop.essencemsg;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import tencent.im.oidb.cmd0x857.TroopTips0x857$QQGroupDigestMsg;
import tencent.im.oidb.cmd0x857.TroopTips0x857$QQGroupDigestMsgSummary;
import tencent.im.oidb.cmd0xeac.oidb_0xeac$BatchRspBody;
import tencent.im.oidb.cmd0xeac.oidb_0xeac$MsgProcessInfo;
import tencent.im.oidb.cmd0xeac.oidb_0xeac$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopEssenceMsgManager implements Manager {
    static IPatchRedirector $redirector_;
    private Object C;
    protected HashSet<c> D;
    protected HashSet<com.tencent.mobileqq.troop.essencemsg.a> E;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f295292d;

    /* renamed from: e, reason: collision with root package name */
    private EntityManager f295293e;

    /* renamed from: f, reason: collision with root package name */
    protected is2.a f295294f;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.observer.f f295295h;

    /* renamed from: i, reason: collision with root package name */
    protected ConcurrentHashMap<Long, HashMap<TroopEssenceMsgItem.b, TroopEssenceMsgItem.c>> f295296i;

    /* renamed from: m, reason: collision with root package name */
    protected ConcurrentHashMap<Long, ArrayList<WeakReference<b>>> f295297m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.troop.observer.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopEssenceMsgManager.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.observer.f
        protected void a(boolean z16, long j3, Object obj, Object obj2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                TroopEssenceMsgManager.this.F(z16, j3, obj, obj2, i3);
            } else {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3), obj, obj2, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.troop.observer.f
        protected void e(boolean z16, Object obj, Object obj2, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopEssenceMsgManager.this.I(z16, obj, obj2, i3, i16);
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj, obj2, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(long j3, HashMap<TroopEssenceMsgItem.b, TroopEssenceMsgItem.c> hashMap);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f295302a;

        /* renamed from: b, reason: collision with root package name */
        public long f295303b;

        c(String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopEssenceMsgManager.this, str, Long.valueOf(j3));
            } else {
                this.f295302a = str;
                this.f295303b = j3;
            }
        }

        public boolean equals(@Nullable Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
            }
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (TextUtils.isEmpty(this.f295302a) || !this.f295302a.equals(cVar.f295302a) || this.f295303b != cVar.f295303b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            String str = this.f295302a;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return hashCode + ((int) this.f295303b);
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "troopUin = " + this.f295302a + ", uniSeq = " + this.f295303b;
        }
    }

    public TroopEssenceMsgManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f295296i = new ConcurrentHashMap<>();
        this.f295297m = new ConcurrentHashMap<>();
        this.C = new Object();
        this.E = new HashSet<>();
        this.f295292d = qQAppInterface;
        this.f295293e = qQAppInterface.getEntityManagerFactory().createEntityManager();
        a aVar = new a();
        this.f295295h = aVar;
        this.f295292d.addObserver(aVar);
        this.f295294f = (is2.a) this.f295292d.getBusinessHandler(BusinessHandlerFactory.TROOP_ESSENCE_MSG_HANDLER);
    }

    private SharedPreferences B() {
        return QMMKV.fromSpAdapter(BaseApplication.getContext(), "essenceMsgShortBarLatestClickTime", QMMKVFile.FILE_TROOP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(boolean z16, long j3, Object obj, Object obj2, int i3) {
        Iterator<oidb_0xeac$MsgProcessInfo> it;
        if (obj != null && obj2 != null && (obj instanceof List) && (obj2 instanceof oidb_0xeac$BatchRspBody)) {
            try {
                oidb_0xeac$BatchRspBody oidb_0xeac_batchrspbody = (oidb_0xeac$BatchRspBody) obj2;
                List<TroopEssenceMsgItem> list = (List) obj;
                if (list.isEmpty()) {
                    return;
                }
                new HashSet(list);
                int i16 = oidb_0xeac_batchrspbody.error_code.get();
                s.f(this.f295292d, j3, i16 == 0);
                s.g(this.f295292d, j3, i16 == 0);
                String str = oidb_0xeac_batchrspbody.wording.get();
                if (QLog.isColorLevel()) {
                    QLog.i("TroopEssenceMsgManager", 1, "handleBatchSetTroopEssenceMsg isSuccess:" + z16 + " oidbErrCode:" + i3 + " errCode:" + i16 + " wording:" + str);
                }
                int i17 = (i16 != 0 || z16) ? i16 : -1;
                H(j3, i17, str);
                HashMap hashMap = new HashMap(list.size());
                for (TroopEssenceMsgItem troopEssenceMsgItem : list) {
                    if (troopEssenceMsgItem != null) {
                        hashMap.put(new TroopEssenceMsgItem.b(troopEssenceMsgItem.troopUin, troopEssenceMsgItem.msgSeq, troopEssenceMsgItem.msgRandom), troopEssenceMsgItem);
                    }
                }
                ArrayList<TroopEssenceMsgItem> arrayList = new ArrayList<>(hashMap.size());
                Iterator<oidb_0xeac$MsgProcessInfo> it5 = oidb_0xeac_batchrspbody.msg_proc_infos.get().iterator();
                while (it5.hasNext()) {
                    oidb_0xeac$MsgProcessInfo next = it5.next();
                    if (next != null && next.f435996msg.has()) {
                        int i18 = next.error_code.get();
                        if (i18 != 0 && i18 != 11002 && i18 != 11007) {
                            it = it5;
                            it5 = it;
                        }
                        it = it5;
                        TroopEssenceMsgItem troopEssenceMsgItem2 = (TroopEssenceMsgItem) hashMap.get(new TroopEssenceMsgItem.b(j3, next.f435996msg.msg_seq.get(), next.f435996msg.msg_random.get()));
                        if (troopEssenceMsgItem2 != null) {
                            troopEssenceMsgItem2.opTime = 0L;
                            if (oidb_0xeac_batchrspbody.digest_time.has()) {
                                troopEssenceMsgItem2.opTime = oidb_0xeac_batchrspbody.digest_time.get();
                            }
                            if ((i17 == 11002 || i17 == 11007) && next.digest_uin.has()) {
                                troopEssenceMsgItem2.opUin = String.valueOf(next.digest_uin.get());
                            }
                            arrayList.add(troopEssenceMsgItem2);
                        }
                        it5 = it;
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                n0(j3, arrayList);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.i("TroopEssenceMsgManager", 1, "handleBatchSetTroopEssenceMsg exception:" + e16);
                return;
            }
        }
        H(j3, -1, null);
    }

    private void H(long j3, int i3, String str) {
        if (i3 != 0) {
            if (TextUtils.isEmpty(str)) {
                str = BaseApplication.getContext().getResources().getString(R.string.f2329675z);
            }
            if (i3 != 11002 && i3 != 11007) {
                QQToast.makeText(this.f295292d.getApp(), 1, str, 0).show();
            } else {
                QQToast.makeText(this.f295292d.getApp(), str, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(boolean z16, Object obj, Object obj2, int i3, int i16) {
        boolean z17;
        boolean z18;
        if ((obj2 instanceof oidb_0xeac$RspBody) && (obj instanceof TroopEssenceMsgItem)) {
            oidb_0xeac$RspBody oidb_0xeac_rspbody = (oidb_0xeac$RspBody) obj2;
            TroopEssenceMsgItem troopEssenceMsgItem = (TroopEssenceMsgItem) obj;
            int i17 = oidb_0xeac_rspbody.error_code.get();
            if (troopEssenceMsgItem.opType == 1) {
                boolean z19 = false;
                if (i16 == 1) {
                    QQAppInterface qQAppInterface = this.f295292d;
                    long j3 = troopEssenceMsgItem.troopUin;
                    int i18 = troopEssenceMsgItem.msgType;
                    if (i17 == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    s.k(qQAppInterface, j3, i18, z18, 1);
                } else if (i16 == 2) {
                    QQAppInterface qQAppInterface2 = this.f295292d;
                    long j16 = troopEssenceMsgItem.troopUin;
                    int i19 = troopEssenceMsgItem.msgType;
                    if (i17 == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    s.i(qQAppInterface2, j16, i19, z17);
                    QQAppInterface qQAppInterface3 = this.f295292d;
                    long j17 = troopEssenceMsgItem.troopUin;
                    int i26 = troopEssenceMsgItem.msgType;
                    if (i17 == 0) {
                        z19 = true;
                    }
                    s.j(qQAppInterface3, j17, i26, z19);
                }
            }
            String str = oidb_0xeac_rspbody.wording.get();
            QLog.i("TroopEssenceMsgManager", 1, "handlerSetTroopEssenceMsg isSuccess:" + z16 + " oidbErrCode:" + i3 + " errCode:" + i17 + " wording:" + str);
            if (i17 == 0 && !z16) {
                i17 = -1;
            }
            H(troopEssenceMsgItem.troopUin, i17, str);
            if (i17 == 0 || i17 == 11002 || i17 == 11007) {
                troopEssenceMsgItem.opTime = 0L;
                if (i17 == 11002 || i17 == 11007) {
                    if (oidb_0xeac_rspbody.digest_uin.has()) {
                        troopEssenceMsgItem.opUin = String.valueOf(oidb_0xeac_rspbody.digest_uin.get());
                    }
                    if (oidb_0xeac_rspbody.digest_time.has()) {
                        troopEssenceMsgItem.opTime = oidb_0xeac_rspbody.digest_time.get();
                    }
                }
                q0(troopEssenceMsgItem);
                return;
            }
            return;
        }
        QLog.e("TroopEssenceMsgManager", 1, "handlerSetTroopEssenceMsg isSuccess=" + z16 + " oidbErrCode=" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(TroopTips0x857$QQGroupDigestMsg troopTips0x857$QQGroupDigestMsg) {
        if (troopTips0x857$QQGroupDigestMsg.ext_info.has()) {
            int i3 = troopTips0x857$QQGroupDigestMsg.ext_info.get();
            if (QLog.isColorLevel()) {
                QLog.i("TroopEssenceMsgManager", 2, "handleEssenceMsgGroupPushMain, ext_info: " + i3);
            }
            if (i3 == 3) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean L(TroopEssenceMsgItem.c cVar) {
        if (cVar == null || cVar.f295274a != 1) {
            return false;
        }
        return true;
    }

    private boolean M(TroopEssenceMsgItem troopEssenceMsgItem) {
        if (troopEssenceMsgItem == null) {
            return false;
        }
        TroopEssenceMsgItem.b bVar = new TroopEssenceMsgItem.b(troopEssenceMsgItem.troopUin, troopEssenceMsgItem.msgSeq, troopEssenceMsgItem.msgRandom);
        HashMap<TroopEssenceMsgItem.b, TroopEssenceMsgItem.c> hashMap = this.f295296i.get(Long.valueOf(bVar.f295271a));
        if (hashMap == null) {
            return false;
        }
        TroopEssenceMsgItem.c cVar = hashMap.get(bVar);
        if (cVar != null && cVar.f295277d >= troopEssenceMsgItem.opTime) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(TroopEssenceMsgItem.d dVar, int i3, long j3) {
        r0(dVar.f295279a, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(final TroopEssenceMsgItem.d dVar) {
        boolean M = M(dVar.f295279a);
        if (QLog.isDebugVersion()) {
            QLog.d("TroopEssenceMsgManager", 4, "[AddEssenceMsgGrayTipAndUpdate], OPTYPE_ADD. msgItem: " + dVar + ", isNewPush: " + M);
        }
        if (M) {
            g0(dVar);
            u.b(this.f295292d, dVar, new IAddJsonGrayTipMsgCallback() { // from class: com.tencent.mobileqq.troop.essencemsg.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
                public final void onResult(int i3, long j3) {
                    TroopEssenceMsgManager.this.N(dVar, i3, j3);
                }
            });
        }
        p0(dVar.f295279a, "OPTYPE_ADD", M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(final TroopEssenceMsgItem.d dVar, String str) {
        dVar.f295282d = str;
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.essencemsg.p
            @Override // java.lang.Runnable
            public final void run() {
                TroopEssenceMsgManager.this.O(dVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(final TroopEssenceMsgItem.d dVar, long j3, HashMap hashMap) {
        if (hashMap == null) {
            return;
        }
        TroopEssenceMsgItem troopEssenceMsgItem = dVar.f295279a;
        int i3 = troopEssenceMsgItem.opType;
        if (i3 == 1) {
            if (!M(troopEssenceMsgItem)) {
                if (QLog.isDebugVersion()) {
                    QLog.d("TroopEssenceMsgManager", 4, "[AddEssenceMsgGrayTipAndUpdate]  no need to insert. msgItem:" + dVar);
                }
                p0(dVar.f295279a, "noInsert", false);
                return;
            }
            u.m(this.f295292d, String.valueOf(dVar.f295279a.troopUin), String.valueOf(dVar.f295279a.msgSenderUin), dVar.f295282d, new com.tencent.mobileqq.troop.e() { // from class: com.tencent.mobileqq.troop.essencemsg.o
                @Override // com.tencent.mobileqq.troop.e
                public final void a(String str) {
                    TroopEssenceMsgManager.this.P(dVar, str);
                }
            });
            return;
        }
        if (i3 == 2) {
            boolean M = M(troopEssenceMsgItem);
            if (QLog.isDebugVersion()) {
                QLog.i("TroopEssenceMsgManager", 4, "[AddEssenceMsgGrayTipAndUpdate], OPTYPE_CANCEL. msgItem: " + dVar + ", isNewPush: " + M);
            }
            if (M) {
                g0(dVar);
            }
            p0(dVar.f295279a, "OPTYPE_CANCEL", M);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(TroopEssenceMsgItem.a aVar, long j3, HashMap hashMap) {
        if (hashMap == null) {
            return;
        }
        ArrayList<TroopEssenceMsgItem> arrayList = new ArrayList<>();
        Iterator<TroopEssenceMsgItem> it = aVar.f295268b.iterator();
        while (it.hasNext()) {
            TroopEssenceMsgItem next = it.next();
            if (next != null && M(next)) {
                arrayList.add(next);
            }
        }
        MessageForUniteGrayTip e16 = u.e(this.f295292d, aVar);
        if (e16 != null) {
            w(this.f295292d, e16);
        }
        n0(aVar.f295267a, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(long j3, HashMap hashMap) {
        this.f295296i.put(Long.valueOf(j3), hashMap);
        ArrayList<WeakReference<b>> arrayList = this.f295297m.get(Long.valueOf(j3));
        if (arrayList != null) {
            synchronized (this.C) {
                Iterator<WeakReference<b>> it = arrayList.iterator();
                while (it.hasNext()) {
                    b bVar = it.next().get();
                    if (bVar != null) {
                        bVar.a(j3, hashMap);
                    }
                }
            }
            this.f295297m.remove(Long.valueOf(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(final long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        final HashMap<TroopEssenceMsgItem.b, TroopEssenceMsgItem.c> e06 = e0(j3);
        if (QLog.isColorLevel()) {
            QLog.i("TroopEssenceMsgManager", 2, "readEntity costTime" + (System.currentTimeMillis() - currentTimeMillis));
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.essencemsg.n
            @Override // java.lang.Runnable
            public final void run() {
                TroopEssenceMsgManager.this.T(j3, e06);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(TroopEssenceMsgItem.b bVar, long j3, HashMap hashMap) {
        TroopEssenceMsgItem.c cVar;
        if (hashMap != null && (cVar = (TroopEssenceMsgItem.c) hashMap.get(bVar)) != null && cVar.f295274a == 1) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopEssenceMsgManager", 2, "isEssenceMsg refreshAio key:" + j3);
            }
            f0(j3, bVar.f295272b, bVar.f295273c, L(cVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(SharedPreferences sharedPreferences, String str) {
        QMMKV.migrateToSpAdapter(BaseApplication.getContext(), "essenceMsgShortBarLatestClickTime", QMMKVFile.FILE_TROOP);
        sharedPreferences.edit().putBoolean(str, true).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(ArrayList arrayList, long j3, HashMap hashMap) {
        TroopEssenceMsgManager troopEssenceMsgManager = this;
        if (hashMap == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TroopEssenceMsgItem troopEssenceMsgItem = (TroopEssenceMsgItem) it.next();
            if (troopEssenceMsgItem != null) {
                TroopEssenceMsgItem.b bVar = new TroopEssenceMsgItem.b(troopEssenceMsgItem.troopUin, troopEssenceMsgItem.msgSeq, troopEssenceMsgItem.msgRandom);
                TroopEssenceMsgItem.c cVar = (TroopEssenceMsgItem.c) hashMap.get(bVar);
                if (cVar != null) {
                    if (cVar.f295274a == troopEssenceMsgItem.opType) {
                        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByBatchSet \u672c\u5730\u5df2\u7ecf\u5b58\u5728\u4e14\u72b6\u6001\u4e00\u81f4 \u76f4\u63a5\u4e22\u5f03");
                        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByBatchSet key:" + bVar.toString() + " oldValue:" + cVar.toString());
                        return;
                    }
                    if (troopEssenceMsgItem.opTime == 0) {
                        troopEssenceMsgItem.opTime = cVar.f295277d;
                    }
                    troopEssenceMsgItem.graytipuniseq = cVar.f295278e;
                }
                TroopEssenceMsgItem.c cVar2 = new TroopEssenceMsgItem.c(troopEssenceMsgItem.opType, troopEssenceMsgItem.msgSenderUin, troopEssenceMsgItem.opUin, troopEssenceMsgItem.opTime, troopEssenceMsgItem.graytipuniseq);
                hashMap.put(bVar, cVar2);
                QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByBatchSet key:" + bVar.toString() + " value:" + cVar2.toString());
                troopEssenceMsgManager = this;
                troopEssenceMsgManager.j0(new TroopEssenceMsgItem(bVar, cVar2));
                f0(j3, bVar.f295272b, (long) bVar.f295273c, troopEssenceMsgManager.L(cVar2));
            }
        }
        troopEssenceMsgManager.f295292d.getBusinessHandler(BusinessHandlerFactory.TROOP_ESSENCE_MSG_HANDLER).notifyUI(com.tencent.mobileqq.troop.observer.f.C, true, Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(TroopEssenceMsgItem troopEssenceMsgItem, String str, boolean z16, long j3, HashMap hashMap) {
        if (hashMap == null) {
            return;
        }
        TroopEssenceMsgItem.b bVar = new TroopEssenceMsgItem.b(troopEssenceMsgItem.troopUin, troopEssenceMsgItem.msgSeq, troopEssenceMsgItem.msgRandom);
        TroopEssenceMsgItem.c cVar = new TroopEssenceMsgItem.c(troopEssenceMsgItem.opType, troopEssenceMsgItem.msgSenderUin, troopEssenceMsgItem.opUin, troopEssenceMsgItem.opTime, troopEssenceMsgItem.graytipuniseq);
        QLog.i("TroopEssenceMsgManager", 1, "[updateEssenceMsgInfosByPush] type:" + str + ", isNewPush:" + z16 + ", msgInfo:" + troopEssenceMsgItem);
        TroopEssenceMsgItem.c cVar2 = (TroopEssenceMsgItem.c) hashMap.get(bVar);
        if (cVar2 != null && cVar.f295277d <= cVar2.f295277d) {
            QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosByPush oldValue.opTime:" + cVar2.f295277d);
            return;
        }
        hashMap.put(bVar, cVar);
        f0(troopEssenceMsgItem.troopUin, bVar.f295272b, bVar.f295273c, L(cVar));
        j0(new TroopEssenceMsgItem(bVar, cVar));
        this.f295292d.getBusinessHandler(BusinessHandlerFactory.TROOP_ESSENCE_MSG_HANDLER).notifyUI(com.tencent.mobileqq.troop.observer.f.C, true, Long.valueOf(troopEssenceMsgItem.troopUin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(TroopEssenceMsgItem troopEssenceMsgItem, long j3, HashMap hashMap) {
        if (hashMap == null) {
            return;
        }
        TroopEssenceMsgItem.b bVar = new TroopEssenceMsgItem.b(troopEssenceMsgItem.troopUin, troopEssenceMsgItem.msgSeq, troopEssenceMsgItem.msgRandom);
        TroopEssenceMsgItem.c cVar = (TroopEssenceMsgItem.c) hashMap.get(bVar);
        if (cVar != null) {
            if (cVar.f295274a == troopEssenceMsgItem.opType) {
                QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet \u672c\u5730\u5df2\u7ecf\u5b58\u5728\u4e14\u72b6\u6001\u4e00\u81f4 \u76f4\u63a5\u4e22\u5f03");
                QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet key:" + bVar.toString() + " oldValue:" + cVar.toString());
                return;
            }
            if (troopEssenceMsgItem.opTime == 0) {
                troopEssenceMsgItem.opTime = cVar.f295277d;
            }
            troopEssenceMsgItem.graytipuniseq = cVar.f295278e;
        }
        TroopEssenceMsgItem.c cVar2 = new TroopEssenceMsgItem.c(troopEssenceMsgItem.opType, troopEssenceMsgItem.msgSenderUin, troopEssenceMsgItem.opUin, troopEssenceMsgItem.opTime, troopEssenceMsgItem.graytipuniseq);
        hashMap.put(bVar, cVar2);
        QLog.i("TroopEssenceMsgManager", 1, "updateEssenceMsgInfosBySet key:" + bVar.toString() + " value:" + cVar2.toString());
        f0(troopEssenceMsgItem.troopUin, bVar.f295272b, (long) bVar.f295273c, L(cVar2));
        j0(new TroopEssenceMsgItem(bVar, cVar2));
        this.f295292d.getBusinessHandler(BusinessHandlerFactory.TROOP_ESSENCE_MSG_HANDLER).notifyUI(com.tencent.mobileqq.troop.observer.f.C, true, Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(TroopEssenceMsgItem troopEssenceMsgItem, long j3, long j16, HashMap hashMap) {
        if (hashMap == null) {
            return;
        }
        TroopEssenceMsgItem.b bVar = new TroopEssenceMsgItem.b(troopEssenceMsgItem.troopUin, troopEssenceMsgItem.msgSeq, troopEssenceMsgItem.msgRandom);
        TroopEssenceMsgItem.c cVar = new TroopEssenceMsgItem.c(troopEssenceMsgItem.opType, troopEssenceMsgItem.msgSenderUin, troopEssenceMsgItem.opUin, troopEssenceMsgItem.opTime, j3);
        QLog.i("TroopEssenceMsgManager", 1, "[updateGrayTipMsgId] msgInfo:" + troopEssenceMsgItem + ", graytip msgId: " + j3);
        TroopEssenceMsgItem.c cVar2 = (TroopEssenceMsgItem.c) hashMap.get(bVar);
        if (cVar2 != null && cVar.f295277d < cVar2.f295277d) {
            QLog.i("TroopEssenceMsgManager", 1, "[updateGrayTipMsgId] msgInfo: " + troopEssenceMsgItem + ", oldValue.opTime:" + cVar2.f295277d + ", newOpTime: " + cVar.f295277d);
            return;
        }
        hashMap.put(bVar, cVar);
        j0(new TroopEssenceMsgItem(bVar, cVar));
    }

    private void d0() {
        final SharedPreferences B = B();
        final String str = "sp_key_has_migrate_essenceMsgShortBarLatestClickTime";
        if (B.getBoolean("sp_key_has_migrate_essenceMsgShortBarLatestClickTime", false)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.essencemsg.h
            @Override // java.lang.Runnable
            public final void run() {
                TroopEssenceMsgManager.W(B, str);
            }
        }, 64, null, true);
    }

    private void f0(long j3, long j16, long j17, boolean z16) {
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.qqnt.bus.event.h(String.valueOf(j3), j16, j17, z16));
    }

    private void g0(TroopEssenceMsgItem.d dVar) {
        String cVar;
        if (dVar != null && dVar.f295279a != null) {
            if (QLog.isDebugVersion()) {
                QLog.i("TroopEssenceMsgManager", 4, "[removeEssenceMsgGrayTip] msgItem:" + dVar);
            }
            TroopEssenceMsgItem troopEssenceMsgItem = dVar.f295279a;
            TroopEssenceMsgItem.b bVar = new TroopEssenceMsgItem.b(troopEssenceMsgItem.troopUin, troopEssenceMsgItem.msgSeq, troopEssenceMsgItem.msgRandom);
            HashMap<TroopEssenceMsgItem.b, TroopEssenceMsgItem.c> hashMap = this.f295296i.get(Long.valueOf(bVar.f295271a));
            if (hashMap != null) {
                TroopEssenceMsgItem.c cVar2 = hashMap.get(bVar);
                if ((cVar2 == null || cVar2.f295278e == 0) && QLog.isDebugVersion()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[removeEssenceMsgGrayTip] Fail. key: ");
                    sb5.append(bVar);
                    sb5.append(", value: ");
                    if (cVar2 == null) {
                        cVar = "null";
                    } else {
                        cVar = cVar2.toString();
                    }
                    sb5.append(cVar);
                    QLog.d("TroopEssenceMsgManager", 4, sb5.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m0(Entity entity) {
        if (this.f295293e.isOpen()) {
            if (entity.getStatus() == 1000) {
                this.f295293e.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return this.f295293e.update(entity);
            }
        }
        return false;
    }

    private void n0(long j3, final ArrayList<TroopEssenceMsgItem> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            y(j3, new b() { // from class: com.tencent.mobileqq.troop.essencemsg.l
                @Override // com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.b
                public final void a(long j16, HashMap hashMap) {
                    TroopEssenceMsgManager.this.X(arrayList, j16, hashMap);
                }
            });
        }
    }

    private void p0(final TroopEssenceMsgItem troopEssenceMsgItem, final String str, final boolean z16) {
        y(troopEssenceMsgItem.troopUin, new b() { // from class: com.tencent.mobileqq.troop.essencemsg.e
            @Override // com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.b
            public final void a(long j3, HashMap hashMap) {
                TroopEssenceMsgManager.this.Y(troopEssenceMsgItem, str, z16, j3, hashMap);
            }
        });
    }

    private void q0(final TroopEssenceMsgItem troopEssenceMsgItem) {
        y(troopEssenceMsgItem.troopUin, new b() { // from class: com.tencent.mobileqq.troop.essencemsg.m
            @Override // com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.b
            public final void a(long j3, HashMap hashMap) {
                TroopEssenceMsgManager.this.a0(troopEssenceMsgItem, j3, hashMap);
            }
        });
    }

    private void r0(final TroopEssenceMsgItem troopEssenceMsgItem, final long j3) {
        y(troopEssenceMsgItem.troopUin, new b() { // from class: com.tencent.mobileqq.troop.essencemsg.g
            @Override // com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.b
            public final void a(long j16, HashMap hashMap) {
                TroopEssenceMsgManager.this.b0(troopEssenceMsgItem, j3, j16, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final TroopEssenceMsgItem.d dVar) {
        TroopEssenceMsgItem troopEssenceMsgItem;
        if (dVar != null && (troopEssenceMsgItem = dVar.f295279a) != null) {
            y(troopEssenceMsgItem.troopUin, new b() { // from class: com.tencent.mobileqq.troop.essencemsg.k
                @Override // com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.b
                public final void a(long j3, HashMap hashMap) {
                    TroopEssenceMsgManager.this.Q(dVar, j3, hashMap);
                }
            });
        }
    }

    private void u(final TroopEssenceMsgItem.a aVar) {
        ArrayList<TroopEssenceMsgItem> arrayList;
        if (aVar != null && (arrayList = aVar.f295268b) != null && !arrayList.isEmpty()) {
            y(aVar.f295267a, new b() { // from class: com.tencent.mobileqq.troop.essencemsg.i
                @Override // com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.b
                public final void a(long j3, HashMap hashMap) {
                    TroopEssenceMsgManager.this.R(aVar, j3, hashMap);
                }
            });
        }
    }

    private void w(final AppRuntime appRuntime, final MessageForUniteGrayTip messageForUniteGrayTip) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.essencemsg.q
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.graytip.f.a(AppRuntime.this, messageForUniteGrayTip);
            }
        }, 32, null, true);
    }

    public long A(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this, j3)).longValue();
        }
        HashMap<TroopEssenceMsgItem.b, TroopEssenceMsgItem.c> hashMap = this.f295296i.get(Long.valueOf(j3));
        long j16 = 0;
        if (hashMap != null && !hashMap.isEmpty()) {
            Iterator<Map.Entry<TroopEssenceMsgItem.b, TroopEssenceMsgItem.c>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                TroopEssenceMsgItem.c value = it.next().getValue();
                if (value.f295274a == 1) {
                    long j17 = value.f295277d;
                    if (j17 > j16) {
                        j16 = j17;
                    }
                }
            }
        }
        return j16;
    }

    public TroopEssenceMsgItem.c C(TroopEssenceMsgItem.b bVar) {
        HashMap<TroopEssenceMsgItem.b, TroopEssenceMsgItem.c> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TroopEssenceMsgItem.c) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        }
        if (bVar == null || (hashMap = this.f295296i.get(Long.valueOf(bVar.f295271a))) == null) {
            return null;
        }
        return hashMap.get(bVar);
    }

    public void D(long j3, TroopTips0x857$QQGroupDigestMsgSummary troopTips0x857$QQGroupDigestMsgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), troopTips0x857$QQGroupDigestMsgSummary);
        } else {
            if (troopTips0x857$QQGroupDigestMsgSummary == null) {
                return;
            }
            ThreadManager.getUIHandler().post(new Runnable(j3, troopTips0x857$QQGroupDigestMsgSummary) { // from class: com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f295299d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TroopTips0x857$QQGroupDigestMsgSummary f295300e;

                {
                    this.f295299d = j3;
                    this.f295300e = troopTips0x857$QQGroupDigestMsgSummary;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopEssenceMsgManager.this, Long.valueOf(j3), troopTips0x857$QQGroupDigestMsgSummary);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TroopEssenceMsgManager.this.E(this.f295299d, this.f295300e);
                    }
                }
            });
        }
    }

    public void E(long j3, TroopTips0x857$QQGroupDigestMsgSummary troopTips0x857$QQGroupDigestMsgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), troopTips0x857$QQGroupDigestMsgSummary);
        } else {
            u(u.c(j3, troopTips0x857$QQGroupDigestMsgSummary));
        }
    }

    public void G(TroopTips0x857$QQGroupDigestMsg troopTips0x857$QQGroupDigestMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) troopTips0x857$QQGroupDigestMsg);
        } else {
            if (troopTips0x857$QQGroupDigestMsg == null) {
                return;
            }
            ThreadManager.getUIHandler().post(new Runnable(troopTips0x857$QQGroupDigestMsg) { // from class: com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TroopTips0x857$QQGroupDigestMsg f295298d;

                {
                    this.f295298d = troopTips0x857$QQGroupDigestMsg;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopEssenceMsgManager.this, (Object) troopTips0x857$QQGroupDigestMsg);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (TroopEssenceMsgManager.this.J(this.f295298d)) {
                        return;
                    }
                    TroopEssenceMsgItem.d d16 = u.d(this.f295298d);
                    QLog.i("TroopEssenceMsgManager", 2, "handleEssenceMsgGroupPush msgItem:" + d16.toString());
                    TroopEssenceMsgManager.this.t(d16);
                }
            });
        }
    }

    public boolean K(TroopEssenceMsgItem.b bVar) {
        HashMap<TroopEssenceMsgItem.b, TroopEssenceMsgItem.c> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar)).booleanValue();
        }
        if (bVar == null || c0(bVar) || (hashMap = this.f295296i.get(Long.valueOf(bVar.f295271a))) == null) {
            return false;
        }
        return L(hashMap.get(bVar));
    }

    public boolean c0(final TroopEssenceMsgItem.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar)).booleanValue();
        }
        if (this.f295296i.get(Long.valueOf(bVar.f295271a)) == null) {
            y(bVar.f295271a, new b() { // from class: com.tencent.mobileqq.troop.essencemsg.d
                @Override // com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.b
                public final void a(long j3, HashMap hashMap) {
                    TroopEssenceMsgManager.this.V(bVar, j3, hashMap);
                }
            });
            return true;
        }
        return false;
    }

    protected HashMap<TroopEssenceMsgItem.b, TroopEssenceMsgItem.c> e0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (HashMap) iPatchRedirector.redirect((short) 19, (Object) this, j3);
        }
        HashMap<TroopEssenceMsgItem.b, TroopEssenceMsgItem.c> hashMap = new HashMap<>();
        try {
            List<? extends Entity> query = this.f295293e.query(TroopEssenceMsgItem.class, false, "troopUin=?", new String[]{String.valueOf(j3)}, null, null, null, null);
            if (query != null) {
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    TroopEssenceMsgItem troopEssenceMsgItem = (TroopEssenceMsgItem) it.next();
                    hashMap.put(new TroopEssenceMsgItem.b(troopEssenceMsgItem.troopUin, troopEssenceMsgItem.msgSeq, troopEssenceMsgItem.msgRandom), new TroopEssenceMsgItem.c(troopEssenceMsgItem.opType, troopEssenceMsgItem.msgSenderUin, troopEssenceMsgItem.opUin, troopEssenceMsgItem.opTime, troopEssenceMsgItem.graytipuniseq));
                }
            }
        } catch (Exception e16) {
            QLog.e("TroopEssenceMsgManager", 1, "readEntity exception + " + e16.getMessage(), e16);
        }
        return hashMap;
    }

    public void h0(com.tencent.mobileqq.troop.essencemsg.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.E.remove(aVar);
        }
    }

    public void i0(TroopEssenceMsgItem troopEssenceMsgItem, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) troopEssenceMsgItem, i3);
            return;
        }
        if (troopEssenceMsgItem == null) {
            return;
        }
        is2.a aVar = this.f295294f;
        if (aVar != null) {
            aVar.Y(troopEssenceMsgItem, i3);
        }
        QLog.i("TroopEssenceMsgManager", 1, "reqSetTroopEssenceMsg:" + troopEssenceMsgItem.toString());
    }

    protected void j0(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) entity);
        } else {
            ThreadManagerV2.excute(new Runnable(entity) { // from class: com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Entity f295301d;

                {
                    this.f295301d = entity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopEssenceMsgManager.this, (Object) entity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    TroopEssenceMsgManager.this.m0(this.f295301d);
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopEssenceMsgManager", 2, "updateEntity costTime" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            }, 32, null, true);
        }
    }

    public void k0(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Boolean.valueOf(z16));
            return;
        }
        is2.a aVar = this.f295294f;
        if (aVar != null) {
            aVar.n0(str, z16);
        }
        QLog.i("TroopEssenceMsgManager", 1, "setEssentialMsgPrilivegeSwitch troopUin:" + str.toString() + " isChecked:" + z16);
    }

    public void l0(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            if (z(j3) > j16) {
                return;
            }
            B().edit().putLong(String.valueOf(j3), j16).apply();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        this.f295292d.removeObserver(this.f295295h);
        this.f295292d.getMessageFacade();
        this.f295296i.clear();
        this.f295297m.clear();
        EntityManager entityManager = this.f295293e;
        if (entityManager != null) {
            entityManager.close();
        }
    }

    public void v(com.tencent.mobileqq.troop.essencemsg.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.E.add(aVar);
        }
    }

    public void x(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3));
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.D == null) {
                this.D = new HashSet<>();
            }
            this.D.add(new c(str, j3));
        }
    }

    public void y(final long j3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        if (this.f295296i.containsKey(Long.valueOf(j3))) {
            bVar.a(j3, this.f295296i.get(Long.valueOf(j3)));
            return;
        }
        if (!this.f295297m.containsKey(Long.valueOf(j3))) {
            ArrayList<WeakReference<b>> arrayList = new ArrayList<>();
            arrayList.add(new WeakReference<>(bVar));
            this.f295297m.put(Long.valueOf(j3), arrayList);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.essencemsg.j
                @Override // java.lang.Runnable
                public final void run() {
                    TroopEssenceMsgManager.this.U(j3);
                }
            }, 32, null, true);
            return;
        }
        synchronized (this.C) {
            ArrayList<WeakReference<b>> arrayList2 = this.f295297m.get(Long.valueOf(j3));
            if (arrayList2 != null) {
                arrayList2.add(new WeakReference<>(bVar));
            }
        }
    }

    public long z(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, j3)).longValue();
        }
        d0();
        return B().getLong(String.valueOf(j3), 0L);
    }
}
