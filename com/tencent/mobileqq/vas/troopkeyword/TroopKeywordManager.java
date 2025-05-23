package com.tencent.mobileqq.vas.troopkeyword;

import QC.GetUsrKeyWordInfoRsp;
import QC.OneKeyWordItemClient;
import QC.UniLoginCheckRsp;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopKeyWord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.DropTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TroopKeywordManager {

    /* renamed from: g, reason: collision with root package name */
    private static int f311031g = -1;

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f311032a;

    /* renamed from: b, reason: collision with root package name */
    private EntityManager f311033b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f311034c;

    /* renamed from: d, reason: collision with root package name */
    private Object f311035d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, List<TroopKeyWord>> f311036e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private long f311037f = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<TroopKeywordManager> f311038d;

        public a(TroopKeywordManager troopKeywordManager) {
            this.f311038d = new WeakReference<>(troopKeywordManager);
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            TroopKeywordManager troopKeywordManager = this.f311038d.get();
            if (troopKeywordManager != null && (obj instanceof UniLoginCheckRsp)) {
                troopKeywordManager.l(((UniLoginCheckRsp) obj).stKeyWord);
            }
        }
    }

    public TroopKeywordManager(QQAppInterface qQAppInterface, EntityManager entityManager) {
        this.f311032a = qQAppInterface;
        this.f311033b = entityManager;
    }

    public static TroopKeywordManager e(AppRuntime appRuntime) {
        return ((ao) appRuntime.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).D;
    }

    public static boolean h() {
        int i3 = f311031g;
        if (i3 == 0) {
            return false;
        }
        if (i3 == 1) {
            return true;
        }
        f311031g = QVipConfigManager.getBoolean((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), QVipConfigManager.KEY_BOOLEAN_TROOP_KEYWORD_OPEN, true) ? 1 : 0;
        if (QLog.isColorLevel()) {
            QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "isEnable = " + f311031g);
        }
        if (f311031g != 1) {
            return false;
        }
        return true;
    }

    public static boolean i(MessageRecord messageRecord) {
        if (!(messageRecord instanceof Message) || ((Message) messageRecord).bizType != 17) {
            return false;
        }
        return true;
    }

    private void n() {
        if (this.f311034c) {
            return;
        }
        synchronized (this.f311036e) {
            if (this.f311034c) {
                return;
            }
            List<? extends Entity> query = this.f311033b.query(TroopKeyWord.class);
            HashMap hashMap = new HashMap();
            if (query != null) {
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    TroopKeyWord troopKeyWord = (TroopKeyWord) it.next();
                    List list = (List) hashMap.get(troopKeyWord.troopUin);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(troopKeyWord.troopUin, list);
                    }
                    list.add(troopKeyWord);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, "syncLoad: " + hashMap);
            }
            this.f311036e.putAll(hashMap);
            this.f311034c = true;
        }
    }

    private void o(HashMap<String, List<TroopKeyWord>> hashMap) {
        synchronized (this.f311036e) {
            for (String str : this.f311036e.keySet()) {
                if (!hashMap.containsKey(str)) {
                    this.f311036e.remove(str);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, "updateKeywords: " + hashMap);
            }
            this.f311036e.putAll(hashMap);
            this.f311034c = true;
        }
        p();
    }

    private void p() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TroopKeywordManager.this.f311035d) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new DropTransaction((Class<? extends Entity>) TroopKeyWord.class));
                        Iterator it = TroopKeywordManager.this.f311036e.values().iterator();
                        while (it.hasNext()) {
                            Iterator it5 = ((List) it.next()).iterator();
                            while (it5.hasNext()) {
                                arrayList.add(new PersistOrReplaceTransaction((TroopKeyWord) it5.next()));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            TroopKeywordManager.this.f311033b.doMultiDBOperateByTransaction(arrayList);
                        }
                    } catch (Exception e16) {
                        QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "writeToDB fail", e16);
                    }
                }
            }
        }, 32, null, true);
    }

    public boolean d(String str, String str2) {
        if (!h() || TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "containsKeyword, troopUin is empty");
            return false;
        }
        n();
        List<TroopKeyWord> list = this.f311036e.get(str2);
        if (list != null && !list.isEmpty()) {
            String lowerCase = str.toLowerCase();
            for (TroopKeyWord troopKeyWord : list) {
                if (troopKeyWord.enable && lowerCase.contains(troopKeyWord.keyword)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, "containsKeyword: " + troopKeyWord.keyword);
                    }
                    ReportController.n(null, "dc00898", "", str2, QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A8FD", 0, 1, 0, "", "", troopKeyWord.keyword, "");
                    return true;
                }
            }
        }
        return false;
    }

    public com.tencent.mobileqq.troop.a f(String str) {
        String string;
        boolean z16;
        int i3;
        com.tencent.mobileqq.troop.a aVar = new com.tencent.mobileqq.troop.a();
        if (!TextUtils.isEmpty(str) && h()) {
            n();
            Resources resources = BaseApplication.getContext().getResources();
            List<TroopKeyWord> list = this.f311036e.get(str);
            if (list != null && !list.isEmpty()) {
                ExpireSet expireSet = new ExpireSet();
                int i16 = 0;
                int i17 = 0;
                for (TroopKeyWord troopKeyWord : list) {
                    int i18 = troopKeyWord.expiredFlag;
                    if (i18 == 3) {
                        i16++;
                        expireSet.add(Long.valueOf(troopKeyWord.wordId));
                    } else if (i18 == 2) {
                        i17++;
                        expireSet.add(Long.valueOf(troopKeyWord.wordId));
                    }
                }
                aVar.f293502d = i16;
                aVar.f293503e = i17;
                aVar.f293500b = expireSet.toJson();
                String string2 = QVipConfigManager.getString(this.f311032a, QVipConfigManager.KEY_STRING_LAST_TROOP_KEYWORD_EXPIRE_LIST + str, null);
                boolean containsAll = ExpireSet.fromJson(string2).containsAll(expireSet) ^ true;
                if (containsAll) {
                    QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "expireList hasNewExpiredId, last:" + string2 + " now:" + aVar.f293500b);
                } else {
                    QVipConfigManager.setString(this.f311032a, QVipConfigManager.KEY_STRING_LAST_TROOP_KEYWORD_EXPIRE_LIST + str, aVar.f293500b);
                }
                if (i16 > 0) {
                    string = resources.getString(R.string.vvp, Integer.valueOf(i16));
                    z16 = containsAll;
                    i3 = 5;
                } else if (i17 > 0) {
                    string = resources.getString(R.string.vvu);
                    z16 = containsAll;
                    i3 = 4;
                } else {
                    string = resources.getString(R.string.vvq, Integer.valueOf(list.size()));
                    i3 = 3;
                    z16 = false;
                }
            } else {
                string = resources.getString(R.string.f171000bk1);
                if (!QVipConfigManager.getBoolean(this.f311032a, QVipConfigManager.KEY_BOOLEAN_KEYWORD_GUIDE_CLICKED, false) && this.f311036e.isEmpty()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, "getTips, troopUin=", str, " tips=", string, " red=", Boolean.valueOf(z16));
            }
            aVar.f293499a = string;
            aVar.f293501c = z16;
            aVar.f293504f = i3;
            return aVar;
        }
        aVar.f293499a = "";
        aVar.f293501c = false;
        aVar.f293504f = 1;
        QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "getTips error, troopUin=", str, " enable=", Boolean.valueOf(h()));
        return aVar;
    }

    public boolean g(String str) {
        if (!h()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "hasKeyword, troopUin is empty");
            return false;
        }
        List<TroopKeyWord> list = this.f311036e.get(str);
        if (list == null || list.size() <= 0) {
            return false;
        }
        return true;
    }

    public void k() {
        QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "onKeywordChangePush");
        ((ISVIPHandler) this.f311032a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).gxhLoginCheckForTroopKeywork(new a(this), true);
    }

    public void l(GetUsrKeyWordInfoRsp getUsrKeyWordInfoRsp) {
        boolean z16;
        boolean z17;
        QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "onKeyworkRsp");
        if (getUsrKeyWordInfoRsp == null) {
            QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "rsp == null");
            return;
        }
        if (1 == getUsrKeyWordInfoRsp.iShowEntry) {
            z16 = true;
        } else {
            z16 = false;
        }
        m(z16);
        HashMap<String, List<TroopKeyWord>> hashMap = new HashMap<>();
        ArrayList[] arrayListArr = {getUsrKeyWordInfoRsp.vBaseWord, getUsrKeyWordInfoRsp.vVaWord};
        for (int i3 = 0; i3 < 2; i3++) {
            ArrayList arrayList = arrayListArr[i3];
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    OneKeyWordItemClient oneKeyWordItemClient = (OneKeyWordItemClient) it.next();
                    TroopKeyWord troopKeyWord = new TroopKeyWord();
                    troopKeyWord.wordId = oneKeyWordItemClient.uWordId;
                    troopKeyWord.keyword = oneKeyWordItemClient.sKeyWordContent.toLowerCase();
                    troopKeyWord.troopUin = String.valueOf(oneKeyWordItemClient.uGroupNum);
                    long j3 = oneKeyWordItemClient.uWordExpiredFlag;
                    troopKeyWord.expiredFlag = (int) j3;
                    if (oneKeyWordItemClient.uWordStatus == 2 && (j3 == 1 || j3 == 2)) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    troopKeyWord.enable = z17;
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, troopKeyWord.toString());
                    }
                    List<TroopKeyWord> list = hashMap.get(troopKeyWord.troopUin);
                    if (list == null) {
                        list = new ArrayList<>();
                        hashMap.put(troopKeyWord.troopUin, list);
                    }
                    list.add(troopKeyWord);
                }
            }
        }
        o(hashMap);
    }

    public void m(boolean z16) {
        QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "setEnable = " + z16);
        QVipConfigManager.setBoolean((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), QVipConfigManager.KEY_BOOLEAN_TROOP_KEYWORD_OPEN, z16);
        f311031g = z16 ? 1 : 0;
        if (!z16) {
            VasLogReporter.getTroopKeyWord().report("set enable = false");
        }
    }

    public void j() {
    }
}
