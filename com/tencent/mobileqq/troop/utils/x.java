package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.haoliyou.orion.XorCipher;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.x;
import com.tencent.mobileqq.troopAddFrd.d;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class x implements d.a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    static final SimpleDateFormat f302220j;

    /* renamed from: k, reason: collision with root package name */
    private static final Comparator<c> f302221k;

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f302222a;

    /* renamed from: b, reason: collision with root package name */
    ConcurrentHashMap<String, Long> f302223b;

    /* renamed from: c, reason: collision with root package name */
    private String f302224c;

    /* renamed from: d, reason: collision with root package name */
    private LifecycleOwner f302225d;

    /* renamed from: e, reason: collision with root package name */
    private MMKVOptionEntity f302226e;

    /* renamed from: f, reason: collision with root package name */
    private String f302227f;

    /* renamed from: g, reason: collision with root package name */
    com.tencent.mobileqq.troop.api.observer.e f302228g;

    /* renamed from: h, reason: collision with root package name */
    com.tencent.mobileqq.troop.observer.i f302229h;

    /* renamed from: i, reason: collision with root package name */
    ConcurrentHashMap<String, com.tencent.mobileqq.troopAddFrd.d> f302230i;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) x.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onBAFSecurityCheckResult(boolean z16, int i3, String str, String str2, long j3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, Long.valueOf(j3), Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onBAFSecurityCheckResult suc_result_troopUin_type_ts=%b_%d_%s_%d_%d", Boolean.valueOf(z16), Integer.valueOf(i3), str, Integer.valueOf(i16), Long.valueOf(j3)));
            }
            if (!com.tencent.mobileqq.troopAddFrd.d.n(i16)) {
                return;
            }
            if (z16 && i3 == 1) {
                x.this.L(str, true, 1);
            } else {
                x.this.H(str, j3, i16);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onTroopBatchAddFrdsDataPrepareErr(boolean z16, String str, long j3, int i3) {
            long longValue;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, Long.valueOf(j3), Integer.valueOf(i3));
                return;
            }
            if (!com.tencent.mobileqq.troopAddFrd.d.n(i3)) {
                return;
            }
            Long remove = x.this.f302223b.remove(str);
            x.this.L(str, false, 0);
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[4];
                objArr[0] = str;
                if (remove == null) {
                    longValue = 0;
                } else {
                    longValue = remove.longValue();
                }
                objArr[1] = Long.valueOf(longValue);
                objArr[2] = Integer.valueOf(i3);
                objArr[3] = Long.valueOf(j3);
                QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onTroopBatchAddFrdsDataPrepareErr troopUin_ts_type_reqTs=%s_%d_%d_%d", objArr));
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onTroopBatchReqMemberCmnFrds(boolean z16, String str, String str2, long j3, int i3, boolean z17, boolean z18, HashMap<String, Integer> hashMap, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18), hashMap, list);
                return;
            }
            Long l3 = x.this.f302223b.get(str);
            if (l3 != null && l3.longValue() != 0 && com.tencent.mobileqq.troopAddFrd.d.n(i3) && j3 == l3.longValue()) {
                if (QLog.isColorLevel()) {
                    QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onTroopBatchReqMemberCmnFrds suc_troopUin_type_ts_curTs_bInc=%b_%s_%d_%d_%d_%b", Boolean.valueOf(z16), str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(l3.longValue()), Boolean.valueOf(z18)));
                }
                if (z17 || !z16) {
                    x.this.f302223b.remove(str);
                }
                if (z16) {
                    x.this.U(str, hashMap);
                    if (z17) {
                        PreferenceManager.getDefaultSharedPreferences(x.this.f302222a.getApp()).edit().putLong(String.format(Locale.getDefault(), "%s_%s_%s", "sp_baf_data_check_flag_cmnfrds", x.this.f302222a.getCurrentAccountUin(), str), j3).apply();
                        x.this.L(str, true, 3);
                        return;
                    }
                    return;
                }
                x.this.H(str, j3, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends com.tencent.mobileqq.troop.observer.i {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) x.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.observer.i
        protected void b(boolean z16, String str, String str2, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, Boolean.valueOf(z17));
            } else if (Long.toString(101509131L).equalsIgnoreCase(str2) && QLog.isColorLevel()) {
                QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onChangeTroopAIORedPoint clear active suc_troopUin_appid_from0x8c2 %b_%s_%s_%b", Boolean.valueOf(z16), str, str2, Boolean.valueOf(z17)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f302232a;

        /* renamed from: b, reason: collision with root package name */
        public long f302233b;

        /* renamed from: c, reason: collision with root package name */
        public int f302234c;

        /* renamed from: d, reason: collision with root package name */
        public long f302235d;

        public c(String str, int i3, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            this.f302232a = str;
            this.f302234c = i3;
            this.f302233b = j3;
            this.f302235d = j16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76708);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            f302220j = new SimpleDateFormat("yyyy_MM_dd");
            f302221k = new Comparator() { // from class: com.tencent.mobileqq.troop.utils.t
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int B;
                    B = x.B((x.c) obj, (x.c) obj2);
                    return B;
                }
            };
        }
    }

    public x(QQAppInterface qQAppInterface, LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) lifecycleOwner);
            return;
        }
        this.f302223b = new ConcurrentHashMap<>();
        this.f302224c = null;
        this.f302226e = null;
        this.f302227f = "batch_add_friend_last_recommend_time_";
        this.f302228g = new a();
        this.f302229h = new b();
        this.f302230i = new ConcurrentHashMap<>();
        qQAppInterface.addObserver(this.f302228g, true);
        qQAppInterface.addObserver(this.f302229h, true);
        this.f302225d = lifecycleOwner;
        this.f302222a = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(String str, long j3, int i3, boolean z16, List list) {
        O(str, z16, new ArrayList(list), j3, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int B(c cVar, c cVar2) {
        return Long.signum(cVar2.f302233b - cVar.f302233b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, boolean z16, int i3) {
        com.tencent.mobileqq.troopAddFrd.d w3;
        if (!TextUtils.isEmpty(str) && (w3 = w(str)) != null) {
            w3.B(z16, i3);
        }
    }

    private void Q(ArrayList<c> arrayList, String str) {
        TroopManager troopManager;
        TroopInfo k3;
        ArrayList<c> arrayList2;
        if (arrayList == null || arrayList.size() == 0 || (k3 = (troopManager = (TroopManager) this.f302222a.getManager(QQManagerFactory.TROOP_MANAGER)).k(str)) == null) {
            return;
        }
        Collections.sort(arrayList, f302221k);
        int i3 = troopManager.o().aor_maxMsgCount;
        if (i3 < 1) {
            i3 = 10;
        }
        if (!TextUtils.isEmpty(k3.extDBInfo.atOrReplyMeUins)) {
            arrayList2 = o(k3.extDBInfo.atOrReplyMeUins);
        } else {
            arrayList2 = null;
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            arrayList.addAll(arrayList2);
        }
        if (arrayList.size() > i3) {
            arrayList = new ArrayList<>(arrayList.subList(0, i3));
        }
        String i16 = i(arrayList);
        if (i16 == null) {
            i16 = "";
        }
        ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateAtOrReplyMeUins(str, i16);
        if (QLog.isColorLevel()) {
            QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markAtOrReplyMeMsgInTroop handled" + str + k3.extDBInfo.atOrReplyMeUins);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(String str, HashMap<String, Integer> hashMap) {
        com.tencent.mobileqq.troopAddFrd.d w3;
        if (!TextUtils.isEmpty(str) && (w3 = w(str)) != null) {
            w3.E(hashMap);
        }
    }

    private void j(ArrayList<c> arrayList, c cVar) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        boolean z16 = false;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = cVar.f302232a;
            if (str != null && str.equals(arrayList.get(i3).f302232a)) {
                if (arrayList.get(i3).f302233b < cVar.f302233b) {
                    arrayList.get(i3).f302233b = cVar.f302233b;
                    arrayList.get(i3).f302235d = cVar.f302235d;
                    arrayList.get(i3).f302234c = cVar.f302234c;
                }
                z16 = true;
            }
        }
        if (!z16) {
            arrayList.add(cVar);
        }
    }

    private ArrayList<c> k(c cVar, String str) {
        TroopInfo k3 = ((TroopManager) this.f302222a.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
        if (k3 == null) {
            return null;
        }
        ArrayList<c> o16 = o(k3.extDBInfo.atOrReplyMeUins);
        j(o16, cVar);
        return o16;
    }

    public static ArrayList<c> o(String str) {
        ArrayList<c> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("list");
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject = (JSONObject) optJSONArray.get(i3);
                if (jSONObject != null) {
                    arrayList.add(new c(jSONObject.optString("mem"), jSONObject.optInt("type"), jSONObject.optLong("time"), jSONObject.optLong("seq")));
                }
            }
        } catch (JSONException e16) {
            QLog.e("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "FlagMsgInfoFromJson " + e16.toString());
        }
        return arrayList;
    }

    private String s() {
        String format;
        SimpleDateFormat simpleDateFormat = f302220j;
        synchronized (simpleDateFormat) {
            format = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
        }
        return format;
    }

    @NonNull
    private MMKVOptionEntity t() {
        if (this.f302226e == null) {
            this.f302226e = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_TROOP);
        }
        return this.f302226e;
    }

    private com.tencent.mobileqq.troopAddFrd.d w(String str) {
        synchronized (this.f302230i) {
            com.tencent.mobileqq.troopAddFrd.d dVar = this.f302230i.get(str);
            if (dVar == null) {
                return null;
            }
            if (!dVar.w()) {
                this.f302230i.remove(str);
                return null;
            }
            return dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str) {
        M(str, null, 2);
    }

    public void C(String str, String str2, int i3, long j3, long j16) {
        ArrayList<c> k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markMultiAtOrReplyMeMsgInTroop single");
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f302224c) && str.equals(this.f302224c)) {
            if (QLog.isColorLevel()) {
                QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markAtOrReplyMeMsgInTroop unhandled when aio opened");
            }
        } else if (l("atMeOrReplyMe") && N(str2) && (k3 = k(new c(str2, i3, j3, j16), str)) != null && k3.size() >= 0) {
            Q(k3, str);
        }
    }

    public void D(ArrayList<MessageRecord> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markAtOrReplyMeMsgInTroop Multi");
        }
        if (arrayList != null && arrayList.size() != 0 && l("atMeOrReplyMe")) {
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                MessageRecord messageRecord = arrayList.get(i3);
                com.tencent.mobileqq.troop.data.c cVar = messageRecord.mMessageInfo;
                if (cVar != null) {
                    String str = messageRecord.frienduin;
                    c cVar2 = new c(messageRecord.senderuin, cVar.f(), messageRecord.time, messageRecord.msgseq);
                    if (hashMap.containsKey(str)) {
                        ((ArrayList) hashMap.get(str)).add(cVar2);
                    } else {
                        hashMap.put(str, new ArrayList());
                    }
                }
            }
            if (hashMap.keySet().size() > 0) {
                for (String str2 : hashMap.keySet()) {
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(this.f302224c) && str2.equals(this.f302224c)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markAtOrReplyMeMsgInTroop unhandled when key aio opened");
                            return;
                        }
                        return;
                    }
                    TroopInfo k3 = ((TroopManager) this.f302222a.getManager(QQManagerFactory.TROOP_MANAGER)).k(str2);
                    if (k3 != null) {
                        ArrayList<c> o16 = o(k3.extDBInfo.atOrReplyMeUins);
                        ArrayList arrayList2 = (ArrayList) hashMap.get(str2);
                        for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                            c cVar3 = (c) arrayList2.get(i16);
                            if (N(cVar3.f302232a)) {
                                j(o16, cVar3);
                            }
                        }
                        Q(o16, str2);
                    } else {
                        return;
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markMultiAtOrReplyMeMsgInTroop no handled");
            }
        }
    }

    public void E(String str, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
            return;
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) this.f302222a.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        if (findTroopInfo == null) {
            return;
        }
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, "markNewMemberIndexAndUinDaily [", str, ",", str2, "]");
        long currentTimeMillis = System.currentTimeMillis();
        String s16 = s();
        SharedPreferences sharedPreferences = this.f302222a.getApplication().getSharedPreferences("troop_gt_af_daily_" + this.f302222a.getCurrentAccountUin() + "_" + s16, 0);
        StringBuilder sb5 = new StringBuilder("troopNewMember_");
        sb5.append(str);
        String sb6 = sb5.toString();
        int i3 = sharedPreferences.getInt(sb6, 0) + 1;
        sharedPreferences.edit().putInt(sb6, i3).apply();
        if (TextUtils.isEmpty(findTroopInfo.extDBInfo.dailyNewMemberUins)) {
            str3 = s16 + "|" + currentTimeMillis + "_" + str2;
        } else if (findTroopInfo.extDBInfo.dailyNewMemberUins.startsWith(s16)) {
            str3 = findTroopInfo.extDBInfo.dailyNewMemberUins + "|" + currentTimeMillis + "_" + str2;
        } else {
            str3 = s16 + "|" + currentTimeMillis + "_" + str2;
        }
        ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateDailyNewMemberUins(findTroopInfo.troopuin, str3);
        if (QLog.isColorLevel()) {
            QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "mark dailyNewMember key = " + sb6 + ",value = " + i3 + ",dailyNewMemberUins = " + findTroopInfo.extDBInfo.dailyNewMemberUins);
        }
    }

    public void F(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, i3);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            t().encodeLong(String.format(Locale.getDefault(), "%s_%s_%d", this.f302227f, str, Integer.valueOf(i3)), NetConnInfoCenter.getServerTimeMillis());
        }
    }

    public boolean G(String str, int i3) {
        int b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, i3)).booleanValue();
        }
        TroopManager troopManager = (TroopManager) this.f302222a.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager == null || (b16 = troopManager.o().b(i3)) == 0) {
            return true;
        }
        boolean z16 = false;
        long decodeLong = t().decodeLong(String.format(Locale.getDefault(), "%s_%s_%d", this.f302227f, str, Integer.valueOf(i3)), 0L);
        if (decodeLong == 0) {
            return true;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (TimeUnit.MICROSECONDS.toDays(serverTimeMillis - decodeLong) < b16) {
            z16 = true;
        }
        if (z16) {
            QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, "[matchRecommendPeriod] lastRecommendTime: " + decodeLong + ", serverTime: " + serverTimeMillis);
        }
        return !z16;
    }

    public void H(String str, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Integer.valueOf(i3));
        } else {
            this.f302222a.getBusinessHandler(BusinessHandlerFactory.TROOP_ADD_FRIEND_HANDLER).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_NOTIFY_BATCH_ADDFRDS_DATA_PREPARE_ERR, false, new Object[]{str, Long.valueOf(j3), Integer.valueOf(i3)});
        }
    }

    public void I(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onActivePush troopUin=%s", str));
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.w
                @Override // java.lang.Runnable
                public final void run() {
                    x.this.y(str);
                }
            }, 16, null, false);
        }
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f302222a.removeObserver(this.f302228g);
        this.f302222a.removeObserver(this.f302229h);
        final String currentAccountUin = this.f302222a.getCurrentAccountUin();
        final String str = this.f302222a.getApplication().getFilesDir().getParent() + File.separator + "shared_prefs";
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.u
            @Override // java.lang.Runnable
            public final void run() {
                x.this.z(str, currentAccountUin);
            }
        }, 64, null, false);
    }

    public void K(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, i3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.mobileqq.troopAddFrd.d w3 = w(str);
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[3];
            boolean z16 = false;
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i3);
            if (w3 != null) {
                z16 = true;
            }
            objArr[2] = Boolean.valueOf(z16);
            QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onStartCheckInAIO [%s,%d] scene exist:%b", objArr));
        }
        if (w3 != null) {
            w3.D();
        }
    }

    public void M(String str, List<String> list, int i3) {
        String str2;
        com.tencent.mobileqq.troopAddFrd.d w3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, list, Integer.valueOf(i3));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (list == null) {
            str2 = "null";
        } else {
            try {
                str2 = XorCipher.encrypt(Arrays.toString(list.toArray()));
            } catch (XorCipherException e16) {
                e16.printStackTrace();
                str2 = null;
            }
        }
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, String.format("onTriggerBatchAddTip troopUin_type=%s_%d [%s]", str, Integer.valueOf(i3), str2));
        com.tencent.mobileqq.troopAddFrd.d w16 = w(str);
        if (w16 != null) {
            QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "[onTriggerBatchAddTip] a task(type:" + w16.f302670b + ") is already running, ignore current(type:" + i3 + ")");
            return;
        }
        if (!com.tencent.mobileqq.troopAddFrd.d.e(this.f302222a, str, i3)) {
            QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format(Locale.getDefault(), "[onTriggerBatchAddTip] checkCommCondition failed. troopUin:%s, type:%d", str, Integer.valueOf(i3)));
            return;
        }
        synchronized (this.f302230i) {
            w3 = w(str);
            if (w3 == null) {
                w3 = new com.tencent.mobileqq.troopAddFrd.d(this.f302222a, str, i3, this, list);
                this.f302230i.put(str, w3);
                z16 = true;
            }
        }
        if (z16) {
            w3.D();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public boolean N(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str)).booleanValue();
        }
        boolean z16 = TextUtils.isEmpty(str);
        if (str.equals(this.f302222a.getCurrentAccountUin())) {
            z16 = 2;
        }
        FriendsManager friendsManager = (FriendsManager) this.f302222a.getManager(QQManagerFactory.FRIENDS_MANAGER);
        ?? r06 = z16;
        if (friendsManager != null) {
            r06 = z16;
            if (friendsManager.c0(str)) {
                r06 = 3;
            }
        }
        int i3 = r06;
        if (k.l(this.f302222a, str)) {
            i3 = 4;
        }
        if (QLog.isColorLevel() && i3 != 0) {
            QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "preCheckUin failed in circumstance:" + i3);
        }
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    protected void O(String str, boolean z16, List<TroopMemberInfo> list, long j3, int i3) {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16), list, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(z16 ? 1 : 0);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Long.valueOf(j3);
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        objArr[4] = Integer.valueOf(size);
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, String.format("onUpdateTroopGetMemberList suc_troopUin_type_ts=%d_%s_%d_%d_%d", objArr));
        if (!com.tencent.mobileqq.troopAddFrd.d.n(i3)) {
            return;
        }
        if (z16) {
            PreferenceManager.getDefaultSharedPreferences(this.f302222a.getApp()).edit().putLong(String.format(Locale.getDefault(), "%s_%s_%s", "sp_baf_data_check_flag_members", this.f302222a.getCurrentAccountUin(), str), j3).apply();
            com.tencent.mobileqq.troopAddFrd.d w3 = w(str);
            if (w3 != null) {
                w3.F(list);
            }
            L(str, true, 2);
            return;
        }
        H(str, j3, i3);
    }

    public void P(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        SharedPreferences sharedPreferences = this.f302222a.getApplication().getSharedPreferences("troop_gt_af_daily_" + this.f302222a.getCurrentAccountUin() + "_" + s(), 0);
        String r16 = r(str);
        sharedPreferences.edit().remove(r16).apply();
        if (QLog.isColorLevel()) {
            QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "removeTroopBAGrayTipsDailyCount key = " + r16 + ",troopUin = " + str);
        }
    }

    public boolean R(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).booleanValue();
        }
        boolean z16 = false;
        int i3 = this.f302222a.getApplication().getSharedPreferences("troop_gt_af_daily_" + this.f302222a.getCurrentAccountUin() + "_" + s(), 0).getInt(q(str), 0);
        com.tencent.mobileqq.relationx.batchAdd.c o16 = ((TroopManager) this.f302222a.getManager(QQManagerFactory.TROOP_MANAGER)).o();
        if (i3 < o16.nm_newMemberIndex) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "shouldCheckNewMember config.nm_newMemberIndex = " + o16.nm_newMemberIndex + ",value = " + i3 + ",result = " + z16);
        }
        return z16;
    }

    public int S(String str, long j3, int i3, boolean z16, List<String> list, List<TroopMemberInfo> list2) {
        long j16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z16), list, list2)).intValue();
        }
        if (list2 != null && list2.size() != 0) {
            ArrayList arrayList = new ArrayList(list2.size());
            for (int i16 = 0; i16 < list2.size(); i16++) {
                if (!list2.get(i16).memberuin.equals(this.f302222a.getCurrentAccountUin()) && Utils.M(list2.get(i16).memberuin) && list2.get(i16).noCommonFrdCnt()) {
                    arrayList.add(list2.get(i16).memberuin);
                }
            }
            if (i3 == 4 && list != null) {
                for (int i17 = 0; i17 < list.size(); i17++) {
                    String str2 = list.get(i17);
                    if (!TextUtils.isEmpty(str2)) {
                        int i18 = 0;
                        while (true) {
                            if (i18 < arrayList.size()) {
                                if (str2.equals((String) arrayList.get(i18))) {
                                    z17 = true;
                                    break;
                                }
                                i18++;
                            } else {
                                z17 = false;
                                break;
                            }
                        }
                        if (!z17) {
                            QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, "startReqCmnFrdCntList add uin unexpected ^_^ " + StringUtil.getSimpleUinForPrint(str2));
                            arrayList.add(str2);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, "startReqCmnFrdCntList dbSize=", Integer.valueOf(list2.size()), " reqSize=", Integer.valueOf(arrayList.size()));
                if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    return -1;
                }
                if (j3 == 0) {
                    j16 = System.currentTimeMillis();
                } else {
                    j16 = j3;
                }
                this.f302223b.put(str, Long.valueOf(j16));
                ((com.tencent.mobileqq.troop.api.handler.a) this.f302222a.getBusinessHandler(BusinessHandlerFactory.TROOP_ADD_FRIEND_HANDLER)).t1(str, arrayList, 0, j16, i3, z16);
                return 0;
            }
            if (QLog.isColorLevel()) {
                QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "startReqCmnFrdCntList no need");
            }
            return 1;
        }
        return -1;
    }

    public int T(final String str, long j3, final int i3) {
        String str2;
        final long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3), Integer.valueOf(i3))).intValue();
        }
        TroopManager troopManager = (TroopManager) ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getManager(QQManagerFactory.TROOP_MANAGER);
        if (str != null && str.length() > 0) {
            TroopInfo k3 = troopManager.k(str);
            if (k3 != null) {
                str2 = k3.troopcode;
            } else {
                str2 = "0";
            }
            if (str2 != null && str2.length() > 0) {
                if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    if (QLog.isColorLevel()) {
                        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("prepareTroopBatchAddFrdData return. net connect err %s", str));
                    }
                    return -1;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("startReqTroopMemberList troopUin_type_ts=%s_%d_%d", str, Integer.valueOf(i3), Long.valueOf(j3)));
                }
                if (j3 == 0) {
                    j16 = System.currentTimeMillis();
                } else {
                    j16 = j3;
                }
                ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberListWithExtInfo(str, this.f302225d, true, "troopBatchAddFrd.TroopBatchAddFriendMgr", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.troop.utils.v
                    @Override // com.tencent.qqnt.troopmemberlist.f
                    public final void a(boolean z16, List list) {
                        x.this.A(str, j16, i3, z16, list);
                    }
                });
                return 0;
            }
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.troopAddFrd.d.a
    public void a(com.tencent.mobileqq.troopAddFrd.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) dVar);
            return;
        }
        if (dVar != null && !TextUtils.isEmpty(dVar.f302669a)) {
            if (QLog.isColorLevel()) {
                QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onFailed troopUin_type_ts=%s_%d_%d", dVar.f302669a, Integer.valueOf(dVar.f302670b), Long.valueOf(dVar.f302672d)));
            }
            if (dVar.f302670b == 2) {
                ((qt2.a) this.f302222a.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).v2(dVar.f302669a, 101509131);
            }
            w(dVar.f302669a);
        }
    }

    @Override // com.tencent.mobileqq.troopAddFrd.d.a
    public void b(com.tencent.mobileqq.troopAddFrd.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) dVar);
            return;
        }
        if (dVar != null && !TextUtils.isEmpty(dVar.f302669a)) {
            String str = dVar.f302669a;
            com.tencent.mobileqq.troopAddFrd.d w3 = w(str);
            if (QLog.isColorLevel()) {
                if (w3 != null) {
                    QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onReadyForInsertTip scene uin_type_ts_valid=%s_%d_%d_%b", str, Integer.valueOf(w3.f302670b), Long.valueOf(w3.f302672d), Boolean.TRUE));
                } else {
                    QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onReadyForInsertTip scene uin_valid=%s_%b", str, Boolean.FALSE));
                }
            }
            if (w3 != null) {
                this.f302222a.getBusinessHandler(BusinessHandlerFactory.TROOP_ADD_FRIEND_HANDLER).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_NOTIFY_READY_FOR_TROOP_BATCHADD_TIP, true, new Object[]{w3.f302669a, Integer.valueOf(w3.f302670b), w3.f302677i});
            }
        }
    }

    public String i(ArrayList<c> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this, (Object) arrayList);
        }
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                c cVar = arrayList.get(i3);
                if (cVar != null && cVar.f302232a != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("mem", cVar.f302232a);
                    jSONObject.put("type", cVar.f302234c);
                    jSONObject.put("time", cVar.f302233b);
                    jSONObject.put("seq", cVar.f302235d);
                    jSONArray.mo162put(jSONObject);
                } else {
                    QLog.e("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "inf memberUin is null ");
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("list", jSONArray);
            return jSONObject2.toString();
        } catch (JSONException e16) {
            QLog.e("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "FlagMsgInfoFromJson " + e16.toString());
            return "";
        }
    }

    public boolean l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).booleanValue();
        }
        return TroopUtils.g(this.f302222a, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void z(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("troop_gt_af_daily_");
            sb5.append(str2);
            sb5.append("_");
            String[] list = new File(str).list();
            if (list == null) {
                return;
            }
            String sb6 = sb5.toString();
            sb5.append(s());
            String sb7 = sb5.toString();
            for (String str3 : list) {
                if (str3.startsWith(sb6) && !str3.startsWith(sb7)) {
                    FileUtils.deleteFile(new File(str + File.separator + str3).getAbsolutePath());
                }
            }
        }
    }

    public boolean n(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).booleanValue();
        }
        synchronized (this.f302230i) {
            if (this.f302230i.get(str) == null) {
                z16 = false;
            } else {
                this.f302230i.remove(str);
                z16 = true;
            }
        }
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, "clearTroopScence " + z16 + " " + str);
        return z16;
    }

    public ArrayList<com.tencent.mobileqq.troopAddFrd.h> p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        String s16 = s();
        TroopInfo findTroopInfo = ((ITroopInfoService) this.f302222a.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        ArrayList<com.tencent.mobileqq.troopAddFrd.h> arrayList = null;
        if (findTroopInfo != null && !TextUtils.isEmpty(findTroopInfo.extDBInfo.dailyNewMemberUins) && findTroopInfo.extDBInfo.dailyNewMemberUins.startsWith(s16)) {
            String[] split = findTroopInfo.extDBInfo.dailyNewMemberUins.split("\\|");
            if (split.length > 1) {
                ArrayList<com.tencent.mobileqq.troopAddFrd.h> arrayList2 = new ArrayList<>();
                for (int length = split.length - 1; length > 0; length--) {
                    String str2 = split[length];
                    if (str2 != null) {
                        String[] split2 = str2.split("_");
                        if (split2.length >= 2) {
                            arrayList2.add(new com.tencent.mobileqq.troopAddFrd.h(split2[1], split2[0]));
                        }
                    }
                }
                arrayList = arrayList2;
            }
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateDailyNewMemberUins(str, "");
        }
        if (QLog.isColorLevel()) {
            QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "getAndClean dailyNewMember  troopUin = " + str + ",resultList = " + arrayList);
        }
        return arrayList;
    }

    String q(String str) {
        return "daily_troop_new_member_tips_count_" + str;
    }

    String r(String str) {
        return "daily_troop_tips_count_" + str;
    }

    String u(String str) {
        return "total_rec_uin_" + str;
    }

    public synchronized void v(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.mobileqq.troopAddFrd.d w3 = w(str);
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            boolean z16 = false;
            objArr[0] = str;
            if (w3 != null) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("insertTip aio %s scene valid:%b", objArr));
        }
        if (w3 != null) {
            w(str);
            if (w3.f302670b == 2) {
                ((qt2.a) this.f302222a.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).v2(w3.f302669a, 101509131);
            }
        }
    }

    public int x(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).intValue();
        }
        int i3 = this.f302222a.getApplication().getSharedPreferences("troop_gt_af_total_" + this.f302222a.getCurrentAccountUin(), 0).getInt(u(str), 0);
        if (i3 >= ((TroopManager) this.f302222a.getManager(QQManagerFactory.TROOP_MANAGER)).o().tipsTotalCountForUin) {
            if (QLog.isColorLevel()) {
                QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, " has recommended exceed the limit ,uin = " + str);
            }
            return -1;
        }
        return i3;
    }
}
