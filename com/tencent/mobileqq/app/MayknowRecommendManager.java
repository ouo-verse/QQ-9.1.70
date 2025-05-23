package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.ExecSQLTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xc26$EntryDelay;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111$MsgBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MayknowRecommendManager implements Manager {
    static IPatchRedirector $redirector_;
    private final ArrayList<Integer> C;
    boolean D;
    com.tencent.mobileqq.friend.observer.a E;
    ar F;
    private StudyModeChangeListener G;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f194792d;

    /* renamed from: e, reason: collision with root package name */
    private EntityManager f194793e;

    /* renamed from: f, reason: collision with root package name */
    private SharedPreferences f194794f;

    /* renamed from: h, reason: collision with root package name */
    private MqqHandler f194795h;

    /* renamed from: i, reason: collision with root package name */
    Handler.Callback f194796i;

    /* renamed from: m, reason: collision with root package name */
    private Object f194797m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MayknowRecommendManager.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("MayknowRecommendManager", 2, "handleMessage msg.what = " + message.what);
            }
            int i3 = message.what;
            if (i3 == 1) {
                MayknowRecommendManager.this.l();
            } else if (i3 != 5) {
                if (i3 != 8) {
                    if (i3 == 9) {
                        Bundle bundle = (Bundle) message.obj;
                        boolean z16 = bundle.getBoolean("key_is_success");
                        String string = bundle.getString("key_req_uin");
                        if (QLog.isColorLevel()) {
                            QLog.d("MayknowRecommendManager", 2, "isSuccess :" + z16 + " onAddReqStatesChanged: " + string);
                        }
                        ((FriendListHandler) MayknowRecommendManager.this.f194792d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(103, true, null);
                    }
                } else {
                    ((FriendListHandler) MayknowRecommendManager.this.f194792d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(103, true, null);
                }
            } else {
                int i16 = message.arg1;
                Bundle bundle2 = (Bundle) message.obj;
                QLog.i("MayknowRecommendManager", 1, String.format("getMayKnowRecommendRemote, real start, entryType = " + i16, new Object[0]));
                ((FriendListHandler) MayknowRecommendManager.this.f194792d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getMayKnowRecommend(null, null, i16, bundle2);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MayknowRecommendManager.this);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onAddReqStatesChanged(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_success", z16);
            bundle.putString("key_req_uin", str);
            MayknowRecommendManager.this.f194795h.sendMessage(MayknowRecommendManager.this.f194795h.obtainMessage(9, 0, 0, bundle));
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c extends ar {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MayknowRecommendManager.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onAddFriend(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MayknowRecommendManager", 2, "onAddFriend " + str);
            }
            MayknowRecommendManager.this.f194795h.sendMessage(MayknowRecommendManager.this.f194795h.obtainMessage(8, 0, 0, str));
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d implements StudyModeChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MayknowRecommendManager.this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
        public void onChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                ((FriendListHandler) MayknowRecommendManager.this.f194792d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(103, true, null);
            }
        }
    }

    public MayknowRecommendManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194796i = new a();
        this.f194797m = new Object();
        this.D = false;
        this.E = new b();
        this.F = new c();
        this.G = new d();
        this.f194792d = qQAppInterface;
        this.f194793e = qQAppInterface.getEntityManagerFactory().createEntityManager();
        this.C = new ArrayList<>(5);
        this.f194795h = new MqqWeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this.f194796i);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.MayknowRecommendManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MayknowRecommendManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                MayknowRecommendManager mayknowRecommendManager = MayknowRecommendManager.this;
                mayknowRecommendManager.f194794f = mayknowRecommendManager.f194792d.getPreferences();
                MayknowRecommendManager.this.f194795h.sendEmptyMessage(1);
            }
        }, 16, null, true);
        qQAppInterface.addObserver(this.F);
        qQAppInterface.addObserver(this.E);
        StudyModeManager.H(this.G);
    }

    public static void f(QQAppInterface qQAppInterface, byte[] bArr) {
        long j3;
        if (bArr != null) {
            try {
                SubMsgType0x111$MsgBody subMsgType0x111$MsgBody = new SubMsgType0x111$MsgBody();
                subMsgType0x111$MsgBody.mergeFrom(bArr);
                if (subMsgType0x111$MsgBody.uint64_type.has()) {
                    j3 = subMsgType0x111$MsgBody.uint64_type.get();
                } else {
                    j3 = -1;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("MayknowRecommendManager", 2, "decodePush0x210_0x111,type = " + j3);
                }
                FriendListHandler friendListHandler = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                if (j3 == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MayknowRecommendManager", 2, "decodePush0x210_0x111 update list");
                    }
                    friendListHandler.handleMayKnowRecommendPush((int) j3, null);
                    return;
                }
                if (j3 == 1) {
                    ArrayList arrayList = new ArrayList();
                    if (subMsgType0x111$MsgBody.rpt_msg_add_recommend_persons.has()) {
                        arrayList.addAll(MayKnowRecommend.covServerPushDataToLocal(subMsgType0x111$MsgBody.rpt_msg_add_recommend_persons.get(), System.currentTimeMillis()));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MayknowRecommendManager", 2, "decodePush0x210_0x111 add " + arrayList);
                    }
                    friendListHandler.handleMayKnowRecommendPush((int) j3, arrayList);
                    return;
                }
                if (j3 == 2) {
                    ArrayList arrayList2 = new ArrayList();
                    if (subMsgType0x111$MsgBody.rpt_uint64_del_uins.has()) {
                        arrayList2.addAll(subMsgType0x111$MsgBody.rpt_uint64_del_uins.get());
                    }
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        long longValue = ((Long) it.next()).longValue();
                        if (longValue > 0) {
                            arrayList3.add(String.valueOf(longValue));
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MayknowRecommendManager", 2, "decodePush0x210_0x111 del " + arrayList3);
                    }
                    friendListHandler.handleMayKnowRecommendPush((int) j3, arrayList3);
                    return;
                }
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.i("MayknowRecommendManager", 1, "decodePush0x210_0x111 decode error, e=" + e16.toString());
                return;
            }
        }
        QLog.i("MayknowRecommendManager", 1, "decodePush0x210_0x111 pbData = null");
    }

    private SharedPreferences j() {
        if (this.f194794f == null) {
            this.f194794f = this.f194792d.getPreferences();
        }
        return this.f194794f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        boolean z16;
        boolean isLocaleUpdatedByUser = LocaleManager.isLocaleUpdatedByUser();
        if (isLocaleUpdatedByUser) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ExecSQLTransaction("delete from MayKnowRecommend"));
            arrayList.add(new ExecSQLTransaction("delete from MayKnowExposure"));
            z16 = this.f194793e.doMultiDBOperateByTransaction(arrayList);
            j().edit().putLong("pull_interval_conversation_tab", 0L).commit();
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "initData isLocaleIDChange =  " + isLocaleUpdatedByUser + ",isDBOperateSuccess = " + z16);
        }
        m();
    }

    private void m() {
        this.D = i("sp_mayknow_addpage_s_a_vl");
        if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "initParams ,addPageDisplayAsVerticalListItem = " + this.D);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.i("MayknowRecommendManager", 1, "clearEntryReqTimeAndInterval");
        SharedPreferences.Editor edit = j().edit();
        edit.putBoolean("sp_mayknow_entry_list_msg", false);
        edit.putBoolean("sp_mayknow_entry_list_head", false);
        edit.putBoolean("sp_mayknow_entry_list_recommend", false);
        edit.putBoolean("sp_mayknow_entry_list_new", false);
        edit.putBoolean("sp_mayknow_entry_list_add", false);
        edit.putLong("sp_get_mayknow_timestamp_v3_for_card_header", 0L);
        edit.putLong("sp_get_mayknow_timestamp_v2", 0L);
        edit.putLong("pull_interval_conversation_tab", 0L);
        edit.putLong("pull_interval_contact_head", 0L);
        edit.putLong("pull_interval_recommend_tab", 0L);
        edit.putLong("pull_interval_new_friend", 0L);
        edit.putLong("pull_interval_add_page", 0L);
        edit.commit();
    }

    public boolean g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        return h(i3, null);
    }

    public boolean h(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) bundle)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "getMayKnowRecommendRemote entryType = " + i3);
        }
        if (!n(i3)) {
            QLog.i("MayknowRecommendManager", 1, String.format("getMayKnowRecommendRemote, isTimeToObtainRemote is false, entryType = " + i3, new Object[0]));
            return false;
        }
        this.f194795h.sendMessage(this.f194795h.obtainMessage(5, i3, 0, bundle));
        return true;
    }

    public boolean i(String str) {
        boolean z16;
        QQAppInterface qQAppInterface;
        CTEntryMng cTEntryMng;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).booleanValue();
        }
        boolean z17 = false;
        if (!TextUtils.isEmpty(str)) {
            z16 = j().getBoolean(str, false);
        } else {
            z16 = false;
        }
        if (z16 && !TextUtils.equals(str, "sp_mayknow_ml_s_a_vl") && !TextUtils.equals(str, "sp_mayknow_addpage_s_a_vl") && (qQAppInterface = this.f194792d) != null && (cTEntryMng = (CTEntryMng) qQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)) != null && cTEntryMng.A()) {
            if (QLog.isColorLevel()) {
                QLog.i("MayknowRecommendManager", 2, "getSPSwitchState user closed");
            }
        } else {
            z17 = z16;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MayknowRecommendManager", 2, "getSPSwitchState name:" + str + "  open:" + z17);
        }
        return z17;
    }

    public long k(int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
        }
        switch (i3) {
            case 1:
                str = "pull_interval_conversation_tab";
                break;
            case 2:
                str = "pull_interval_contact_head";
                break;
            case 3:
                str = "pull_interval_recommend_tab";
                break;
            case 4:
                str = "pull_interval_new_friend";
                break;
            case 5:
                str = "pull_interval_add_page";
                break;
            case 6:
                return 0L;
            default:
                return Long.MAX_VALUE;
        }
        return j().getLong(str, 43200000L);
    }

    public boolean n(int i3) {
        long j3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        if (i3 == 2) {
            j3 = j().getLong("sp_get_mayknow_timestamp_v3_for_card_header", 0L);
        } else {
            j3 = j().getLong("sp_get_mayknow_timestamp_v2", 0L);
        }
        long k3 = k(i3);
        if (Math.abs(j3 - System.currentTimeMillis()) >= k3) {
            z16 = true;
        } else {
            z16 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(String.format("isTimeToObtainRemote, return=" + z16 + ", lastTime" + j3, new Object[0]));
        sb5.append(", pullInternalTime");
        sb5.append(k3);
        sb5.append(",entryType = ");
        sb5.append(i3);
        QLog.d("MayknowRecommendManager", 1, sb5.toString());
        return z16;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MayknowRecommendManager", 2, "onEnterBackground ");
        }
        if (this.f194795h != null) {
            ContactReportUtils.a();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f194792d.removeObserver(this.F);
        this.f194792d.removeObserver(this.E);
        synchronized (this.f194797m) {
            MqqHandler mqqHandler = this.f194795h;
            if (mqqHandler != null) {
                mqqHandler.removeCallbacksAndMessages(null);
            }
        }
        StudyModeManager.U(this.G);
    }

    public void p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
    }

    public void q(List<Integer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        boolean contains = list.contains(1);
        boolean contains2 = list.contains(2);
        boolean contains3 = list.contains(3);
        boolean contains4 = list.contains(4);
        boolean contains5 = list.contains(5);
        SharedPreferences.Editor edit = j().edit();
        edit.putBoolean("sp_mayknow_entry_list_msg", contains);
        edit.putBoolean("sp_mayknow_entry_list_head", contains2);
        edit.putBoolean("sp_mayknow_entry_list_recommend", contains3);
        edit.putBoolean("sp_mayknow_entry_list_new", contains4);
        edit.putBoolean("sp_mayknow_entry_list_add", contains5);
        edit.commit();
        QLog.i("MayknowRecommendManager", 1, "saveEntryOpenList,MsgEntryOpen=" + contains + ",HeadEntryOpen=" + contains2 + ", RecommendEntryOpen=" + contains3 + ", NewEntryOpen=" + contains4 + ", EntryAdd=" + contains5);
    }

    public void r(List<oidb_0xc26$EntryDelay> list) {
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
            return;
        }
        SharedPreferences.Editor edit = j().edit();
        edit.putLong("sp_get_mayknow_timestamp_v3_for_card_header", System.currentTimeMillis());
        edit.putLong("sp_get_mayknow_timestamp_v2", System.currentTimeMillis());
        int i19 = 0;
        if (list != null && list.size() > 0) {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
            for (oidb_0xc26$EntryDelay oidb_0xc26_entrydelay : list) {
                int i26 = oidb_0xc26_entrydelay.em_entry.get();
                if (i26 != 1) {
                    if (i26 != 2) {
                        if (i26 != 3) {
                            if (i26 != 4) {
                                if (i26 == 5) {
                                    i18 = oidb_0xc26_entrydelay.uint32_delay.get();
                                }
                            } else {
                                i17 = oidb_0xc26_entrydelay.uint32_delay.get();
                            }
                        } else {
                            i16 = oidb_0xc26_entrydelay.uint32_delay.get();
                        }
                    } else {
                        i3 = oidb_0xc26_entrydelay.uint32_delay.get();
                    }
                } else {
                    i19 = oidb_0xc26_entrydelay.uint32_delay.get();
                }
            }
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
        }
        if (i19 > 0) {
            edit.putLong("pull_interval_conversation_tab", i19 * 1000);
        }
        if (i3 > 0) {
            edit.putLong("pull_interval_contact_head", i3 * 1000);
        }
        if (i16 > 0) {
            edit.putLong("pull_interval_recommend_tab", i16 * 1000);
        }
        if (i17 > 0) {
            edit.putLong("pull_interval_new_friend", i17 * 1000);
        }
        if (i18 > 0) {
            edit.putLong("pull_interval_add_page", i18 * 1000);
        }
        edit.commit();
        QLog.i("MayknowRecommendManager", 1, "saveReqTimeAndIntervalInfo,msgIntervel = " + i19 + ",headIntervel = " + i3 + ",recommendIntervel = " + i16 + ",newIntervel = " + i17 + ",addIntervel = " + i18);
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        boolean i3 = i("sp_mayknow_entry_list_new");
        boolean t16 = StudyModeManager.t();
        if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, String.format("shouldShowMayKnowInNewFriend, mayKnowListSwitch: %s, isStudyMode: %s", Boolean.valueOf(i3), Boolean.valueOf(t16)));
        }
        if (i3 && !t16) {
            return true;
        }
        return false;
    }

    public void t(String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        synchronized (this.C) {
            this.C.clear();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("shield_sub_source_id")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("shield_sub_source_id");
                    int i16 = 0;
                    while (jSONArray != null) {
                        if (i16 >= jSONArray.length()) {
                            break;
                        }
                        this.C.add(Integer.valueOf(jSONArray.getInt(i16)));
                        i16++;
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i("MayknowRecommendManager", 2, "updateShieldConfig", e16);
                }
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append("updateShieldConfig config: ");
            sb5.append(str);
            sb5.append("\r\n");
            sb5.append("[");
            synchronized (this.C) {
                for (i3 = 0; i3 < this.C.size(); i3++) {
                    sb5.append(this.C.get(i3));
                    sb5.append(",");
                }
            }
            sb5.append("]");
            QLog.i("MayknowRecommendManager", 2, sb5.toString());
        }
    }
}
