package com.tencent.mobileqq.activity.contacts.topentry;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.config.c;
import com.tencent.mobileqq.data.PYMKBizEntryInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.y;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.ShortCompanionObject;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CTEntryMng implements Manager, c.b {
    static IPatchRedirector $redirector_;
    private boolean C;
    private boolean D;
    private boolean E;
    private final List<com.tencent.mobileqq.activity.contacts.topentry.c> F;
    private int G;
    private boolean H;
    protected int I;
    private boolean J;
    private CardObserver K;
    private ExpandObserver L;
    private od2.a M;
    ar N;

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f181720d;

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray<com.tencent.mobileqq.activity.contacts.topentry.a> f181721e;

    /* renamed from: f, reason: collision with root package name */
    private final List<Integer> f181722f;

    /* renamed from: h, reason: collision with root package name */
    private final SparseArray<e> f181723h;

    /* renamed from: i, reason: collision with root package name */
    private final List<f> f181724i;

    /* renamed from: m, reason: collision with root package name */
    private final com.tencent.mobileqq.activity.contacts.topentry.e f181725m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends CardObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CTEntryMng.this);
            }
        }

        private void a(short[] sArr, Map<Short, Short> map) {
            if (QLog.isColorLevel()) {
                String str = "";
                for (int i3 = 0; map != null && sArr != null && i3 < sArr.length; i3++) {
                    short s16 = sArr[i3];
                    Short sh5 = map.get(Short.valueOf(s16));
                    if (QLog.isColorLevel()) {
                        str = String.format(Locale.getDefault(), "%s, [id: %s, value: %s]", str, Short.valueOf(s16), sh5);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo,  fail, log: %s", str));
                }
            }
        }

        private void b(short s16, short s17) {
            FriendListHandler friendListHandler;
            if (s16 == -23447 && CTEntryMng.this.f181720d != null && (friendListHandler = (FriendListHandler) CTEntryMng.this.f181720d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) != null) {
                friendListHandler.notifyUI(108, true, null);
                if (s17 == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CTEntryMng", 2, "switch state change to on, force to get service enable state");
                    }
                    friendListHandler.getMayKnowRecommend(null, null, 6, null);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
        
            r12.f181727d.I();
            r12.f181727d.B();
         */
        @Override // com.tencent.mobileqq.app.CardObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void onGetCommonSwitchFromDetailInfo(boolean z16, short[] sArr, Map<Short, Short> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), sArr, map);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo isSuccess: %s", Boolean.valueOf(z16)));
            }
            if (z16) {
                String str = "";
                boolean z17 = false;
                for (int i3 = 0; map != null && sArr != null && i3 < sArr.length; i3++) {
                    short s16 = sArr[i3];
                    Short sh5 = map.get(Short.valueOf(s16));
                    f t16 = CTEntryMng.this.t(s16);
                    if (t16 != null && sh5 != null && t16.f181738c != sh5.shortValue()) {
                        t16.f181738c = sh5.shortValue();
                        z17 = true;
                    }
                    if (t16 != null && QLog.isColorLevel()) {
                        str = String.format(Locale.getDefault(), "%s, [id: %s, value: %s]", str, Short.valueOf(s16), sh5);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onGetCommonSwitchFromDetailInfo, needUpdate: %s, log: %s", Boolean.valueOf(z17), str));
                    return;
                }
                return;
            }
            a(sArr, map);
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetCommonSwitchFromDetailInfo(boolean z16, short s16, short s17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Short.valueOf(s16), Short.valueOf(s17));
                return;
            }
            if (z16) {
                f t16 = CTEntryMng.this.t(s16);
                if (t16 != null && t16.f181738c != s17) {
                    t16.f181738c = s17;
                    CTEntryMng.this.I();
                    CTEntryMng.this.B();
                    b(s16, s17);
                }
                if (t16 != null && QLog.isColorLevel()) {
                    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo suc switch_id: %s, switch_value: %s", Short.valueOf(s16), Short.valueOf(s17)));
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo fail switch_id: %s, switch_value: %s", Short.valueOf(s16), Short.valueOf(s17)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends ExpandObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CTEntryMng.this);
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void t(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            com.tencent.mobileqq.activity.contacts.topentry.a l3 = CTEntryMng.this.l(2);
            l3.f181770n = Boolean.valueOf(z16);
            if (l3.f181767k && z16) {
                CTEntryMng.this.B();
            }
            if (QLog.isColorLevel()) {
                QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onResourceStateUpdate [id: %s, canBeShown: %s, isReady: %s]", Integer.valueOf(l3.f181757a), Boolean.valueOf(l3.f181767k), Boolean.valueOf(z16)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements od2.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CTEntryMng.this);
            }
        }

        @Override // od2.a
        public void B7(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
        }

        @Override // od2.a
        public void L1(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
        }

        @Override // od2.a
        public void T2(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }

        @Override // od2.a
        public void Ug(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                CTEntryMng.this.P(false);
                CTEntryMng.this.B();
            }
        }

        @Override // od2.a
        public void e7(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d extends ar {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CTEntryMng.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onMayKnowEntryStateChanged(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("CTEntryMng", 2, "onMayKnowEntryStateChanged isSuccess=" + z16);
            }
            if (z16) {
                CTEntryMng.this.R(true);
                CTEntryMng.this.B();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f181731a;

        /* renamed from: b, reason: collision with root package name */
        public int f181732b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f181733c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f181734d;

        /* renamed from: e, reason: collision with root package name */
        public long f181735e;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
                return;
            }
            if (jSONObject != null) {
                this.f181731a = jSONObject.optInt("entryID");
                this.f181732b = jSONObject.optInt("redDotVersion");
                this.f181733c = jSONObject.optBoolean("showRedDot");
                this.f181734d = jSONObject.optBoolean("userCanceled");
                this.f181735e = jSONObject.optLong("lastCancelTime");
            }
        }

        public JSONObject b() {
            JSONObject jSONObject;
            JSONException e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e17) {
                jSONObject = null;
                e16 = e17;
            }
            try {
                jSONObject.put("entryID", this.f181731a);
                jSONObject.put("redDotVersion", this.f181732b);
                jSONObject.put("showRedDot", this.f181733c);
                jSONObject.put("userCanceled", this.f181734d);
                jSONObject.put("lastCancelTime", this.f181735e);
            } catch (JSONException e18) {
                e16 = e18;
                e16.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f181736a;

        /* renamed from: b, reason: collision with root package name */
        public short f181737b;

        /* renamed from: c, reason: collision with root package name */
        public short f181738c;

        protected f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        boolean a() {
            if (this.f181737b != 0 && this.f181738c == 1) {
                return true;
            }
            return false;
        }

        public void b(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
            } else if (jSONObject != null) {
                this.f181736a = jSONObject.optInt(MttLoader.ENTRY_ID);
                this.f181737b = (short) jSONObject.optInt("flagId");
                this.f181738c = (short) jSONObject.optInt("flagValue");
            }
        }

        public JSONObject c() {
            JSONObject jSONObject;
            Exception e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(MttLoader.ENTRY_ID, this.f181736a);
                    jSONObject.put("flagId", (int) this.f181737b);
                    jSONObject.put("flagValue", (int) this.f181738c);
                } catch (Exception e17) {
                    e16 = e17;
                    e16.printStackTrace();
                    return jSONObject;
                }
            } catch (Exception e18) {
                jSONObject = null;
                e16 = e18;
            }
            return jSONObject;
        }
    }

    public CTEntryMng(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.C = false;
        this.D = false;
        this.E = false;
        this.G = 0;
        this.H = false;
        this.I = 0;
        this.J = false;
        this.K = new a();
        this.L = new b();
        this.M = new c();
        this.N = new d();
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, "CTEntryMng create");
        }
        this.f181720d = qQAppInterface;
        this.f181721e = new SparseArray<>(5);
        this.f181723h = new SparseArray<>(5);
        this.f181722f = Collections.synchronizedList(new ArrayList(5));
        this.F = Collections.synchronizedList(new ArrayList(5));
        this.f181724i = Collections.synchronizedList(new ArrayList(5));
        qQAppInterface.addObserver(this.K);
        qQAppInterface.addObserver(this.L);
        qQAppInterface.addObserver(this.N);
        this.f181725m = new com.tencent.mobileqq.activity.contacts.topentry.e(qQAppInterface);
        com.tencent.mobileqq.config.c configProcess = qQAppInterface.getConfigProcess();
        configProcess.a(AppConstants.Preferences.CONFESS_CONFIG, this);
        configProcess.a(AppConstants.Preferences.CONTACT_TOP_ENTRY_CONFIG, this);
        configProcess.a(AppConstants.Preferences.REGISTER_INVITATION_CONFIG, this);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CTEntryMng.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("CTEntryMng", 2, "read sp and init config");
                }
                CTEntryMng.this.z(false, ea.D(CTEntryMng.this.f181720d.getApp(), CTEntryMng.this.f181720d.getCurrentUin(), AppConstants.Preferences.CONTACT_TOP_ENTRY_CONFIG));
            }
        }, 64, null, false);
        if (this.M != null) {
            ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).addListener(this.M);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        for (int i3 = 0; i3 < this.F.size(); i3++) {
            try {
                com.tencent.mobileqq.activity.contacts.topentry.c cVar = this.F.get(i3);
                if (cVar != null) {
                    cVar.a();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "notifyEntryUpdated [isEntryUIInit: %s, redDotFlag: %s]", Boolean.valueOf(this.J), Integer.valueOf(this.I)));
        }
        if (!this.J) {
            S(m(p()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void D(String str) {
        boolean z16;
        this.f181722f.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("entryList")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("entryList");
                    int i3 = 0;
                    z16 = false;
                    while (jSONArray != null) {
                        try {
                            if (i3 >= jSONArray.length()) {
                                break;
                            }
                            if (!E(jSONArray.getJSONObject(i3)) && !z16) {
                                z16 = false;
                                i3++;
                            }
                            z16 = true;
                            i3++;
                        } catch (JSONException e16) {
                            e = e16;
                            e.printStackTrace();
                            if (!this.f181722f.contains(3)) {
                            }
                            if (this.f181722f.contains(2)) {
                            }
                            if (this.f181722f.contains(3)) {
                            }
                            if (this.f181722f.contains(4)) {
                            }
                            if (this.f181722f.contains(5)) {
                            }
                            if (!z16) {
                            }
                        }
                    }
                } else {
                    z16 = false;
                }
                if (jSONObject.has("entryOrder")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("entryOrder");
                    int i16 = 0;
                    while (jSONArray2 != null) {
                        if (i16 >= jSONArray2.length()) {
                            break;
                        }
                        this.f181722f.add(Integer.valueOf(jSONArray2.getInt(i16)));
                        i16++;
                    }
                }
            } catch (JSONException e17) {
                e = e17;
                z16 = false;
            }
        } else {
            z16 = false;
        }
        if (!this.f181722f.contains(3)) {
            this.f181722f.add(3);
        }
        if (this.f181722f.contains(2)) {
            O(false);
        }
        if (this.f181722f.contains(3)) {
            R(false);
        }
        if (this.f181722f.contains(4)) {
            Q(false);
        }
        if (this.f181722f.contains(5)) {
            P(false);
        }
        if (!z16) {
            H(this.f181723h.clone());
        }
    }

    private boolean E(JSONObject jSONObject) {
        int optInt;
        if (jSONObject == null || (optInt = jSONObject.optInt("id", 0)) == 0) {
            return false;
        }
        com.tencent.mobileqq.activity.contacts.topentry.a l3 = l(optInt);
        l3.f181757a = optInt;
        l3.f181758b = jSONObject.optString("title", l3.f181758b);
        l3.f181760d = jSONObject.optString("AndroidMultiCardsIcon", l3.f181760d);
        l3.f181761e = jSONObject.optString("AndroidSingleCardIcon", l3.f181761e);
        l3.f181762f = jSONObject.optString("url", l3.f181762f);
        l3.f181763g = jSONObject.optBoolean("showRedDot", l3.f181763g);
        l3.f181764h = jSONObject.optInt("redDotVersion", l3.f181764h);
        l3.f181766j = (short) jSONObject.optInt("switchFlag", l3.f181766j);
        int i3 = l3.f181757a;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            l3.f181759c = jSONObject.optString(QQWinkConstants.TAB_SUBTITLE, l3.f181759c);
                            l3.f181765i = false;
                            l3.f181767k = true;
                        } else {
                            l3.f181759c = jSONObject.optString(QQWinkConstants.TAB_SUBTITLE, l3.f181759c);
                            l3.f181765i = false;
                            l3.f181762f = "native";
                            l3.f181766j = ProfileContants.FIELD_CT_ENTRY_BIND_PHONE_SWITCH;
                        }
                    } else {
                        l3.f181759c = jSONObject.optString(QQWinkConstants.TAB_SUBTITLE, l3.f181759c);
                        l3.f181765i = false;
                        l3.f181766j = ProfileContants.FIELD_CT_ENTRY_INVITE_REGISTER;
                    }
                } else {
                    l3.f181765i = true;
                    l3.f181762f = "native";
                    l3.f181766j = ProfileContants.MAY_KNOW_IN_CONTACT_SWITCH_ID;
                }
            } else {
                l3.f181759c = jSONObject.optString(QQWinkConstants.TAB_SUBTITLE, l3.f181759c);
                l3.f181765i = false;
                l3.f181762f = "native";
                l3.f181766j = ProfileContants.FIELD_CT_ENTRY_EXTEND_FRD;
            }
        } else {
            l3.f181759c = jSONObject.optString(QQWinkConstants.TAB_SUBTITLE, l3.f181759c);
            l3.f181765i = false;
            l3.f181766j = ProfileContants.FIELD_CT_ENTRY_CONFESS_SWITCH;
        }
        L(l3);
        e q16 = q(l3.f181757a);
        int i16 = q16.f181732b;
        int i17 = l3.f181764h;
        if (i16 == i17) {
            return false;
        }
        q16.f181732b = i17;
        q16.f181733c = l3.f181763g;
        q16.f181734d = false;
        q16.f181735e = 0L;
        synchronized (this.f181723h) {
            this.f181723h.put(q16.f181731a, q16);
        }
        return true;
    }

    private void H(SparseArray<e> sparseArray) {
        ThreadManagerV2.excute(new Runnable(sparseArray) { // from class: com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ SparseArray f181726d;

            {
                this.f181726d = sparseArray;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) CTEntryMng.this, (Object) sparseArray);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    String r16 = CTEntryMng.this.r(this.f181726d);
                    if (QLog.isColorLevel()) {
                        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "saveEntryRedDot value: %s", r16));
                    }
                    y.c(CTEntryMng.this.f181720d.getApp(), CTEntryMng.this.f181720d.getCurrentUin(), "ct_entry_reddot_info", r16);
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }, 64, null, false);
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, "saveEntryRedDot");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) CTEntryMng.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ArrayList arrayList = new ArrayList(CTEntryMng.this.f181724i);
                String str = "";
                try {
                    if (arrayList.size() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            f fVar = (f) arrayList.get(i3);
                            if (fVar.f181736a > 4 && !CTEntryMng.this.f181722f.contains(Integer.valueOf(fVar.f181736a))) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("CTEntryMng", 2, "saveUserSetting not save id: " + fVar.f181736a);
                                }
                            } else {
                                JSONObject c16 = fVar.c();
                                if (c16 != null) {
                                    jSONArray.mo162put(c16);
                                }
                            }
                        }
                        str = jSONArray.toString();
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                if (QLog.isColorLevel()) {
                    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "saveUserSetting value: %s", str));
                }
                y.c(CTEntryMng.this.f181720d.getApp(), CTEntryMng.this.f181720d.getCurrentUin(), "ct_entry_user_setting", str);
            }
        }, 64, null, false);
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, "saveUserSetting");
        }
    }

    private void L(com.tencent.mobileqq.activity.contacts.topentry.a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f181721e) {
            this.f181721e.put(aVar.f181757a, aVar);
        }
    }

    private void M(boolean z16) {
        if (this.H) {
            return;
        }
        com.tencent.mobileqq.activity.contacts.topentry.a l3 = l(1);
        boolean z17 = l3.f181767k;
        ConfessManager confessManager = (ConfessManager) this.f181720d.getManager(QQManagerFactory.CONFESS_MANAGER);
        if (confessManager == null) {
            return;
        }
        ConfessConfig h16 = confessManager.h();
        if (TextUtils.isEmpty(l3.f181758b)) {
            l3.f181758b = HardCodeUtil.qqStr(R.string.l5f);
        }
        l3.f181767k = h16.a();
        L(l3);
        boolean z18 = l3.f181767k;
        if (z17 != z18 && z18 && z16) {
            u(l3);
        }
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateConfessEntry show: %s, title: %s, sub: %s preValue: %s", Boolean.valueOf(l3.f181767k), l3.f181758b, l3.f181759c, Boolean.valueOf(z17)));
        }
    }

    private void O(boolean z16) {
        ExpandConfig g16;
        if (this.H) {
            return;
        }
        com.tencent.mobileqq.activity.contacts.topentry.a l3 = l(2);
        boolean z17 = l3.f181767k;
        com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) this.f181720d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        if (eVar == null) {
            g16 = null;
        } else {
            g16 = eVar.g();
        }
        if (g16 != null) {
            l3.f181767k = eVar.L(g16);
            l3.f181770n = Boolean.valueOf(eVar.isResourceReady());
        } else {
            l3.f181767k = false;
            l3.f181770n = null;
        }
        L(l3);
        boolean z18 = l3.f181767k;
        if (z17 != z18 && z18 && z16) {
            u(l3);
        }
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateExtendFrdEntry show: %s, title: %s, sub: %s, preValue: %s", Boolean.valueOf(l3.f181767k), l3.f181758b, l3.f181759c, Boolean.valueOf(z17)));
        }
    }

    private void Q(boolean z16) {
        boolean z17;
        if (this.H) {
            return;
        }
        com.tencent.mobileqq.activity.contacts.topentry.a l3 = l(4);
        boolean z18 = l3.f181767k;
        if (BaseApplication.getContext().getSharedPreferences(this.f181720d.getCurrentAccountUin(), 0).getInt("contacts_invite_friend_entry", 0) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        l3.f181767k = z17;
        if (z18 != z17 && z17 && z16) {
            u(l3);
        }
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateInviteFrd show: %s, title: %s, sub: %s, url: %s", Boolean.valueOf(l3.f181767k), l3.f181758b, l3.f181759c, l3.f181762f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(boolean z16) {
        boolean z17;
        if (this.H) {
            return;
        }
        com.tencent.mobileqq.activity.contacts.topentry.a l3 = l(3);
        boolean z18 = l3.f181767k;
        MayknowRecommendManager mayknowRecommendManager = (MayknowRecommendManager) this.f181720d.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        List<PYMKBizEntryInfo> bizEntryInfo = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getBizEntryInfo(4);
        if (mayknowRecommendManager != null && !mayknowRecommendManager.i("sp_mayknow_entry_list_head") && bizEntryInfo.size() <= 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        l3.f181758b = this.f181720d.getApp().getResources().getString(R.string.iyh);
        if (z17) {
            l3.f181767k = true;
        } else {
            l3.f181767k = false;
        }
        if (l3.f181770n == null) {
            l3.f181759c = "";
        }
        L(l3);
        boolean z19 = l3.f181767k;
        if (z18 != z19 && z19 && z16) {
            u(l3);
        }
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateMayKnowEntry show: %s, title: %s, sub: %s, extra: %s", Boolean.valueOf(l3.f181767k), l3.f181758b, l3.f181759c, l3.f181770n));
        }
    }

    private void j(f fVar) {
        if (!this.f181724i.contains(fVar)) {
            this.f181724i.add(fVar);
        }
    }

    public static int m(List<com.tencent.mobileqq.activity.contacts.topentry.a> list) {
        for (int i3 = 0; list != null && i3 < list.size(); i3++) {
            com.tencent.mobileqq.activity.contacts.topentry.a aVar = list.get(i3);
            if (aVar != null && aVar.f181768l) {
                return 1;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String r(SparseArray<e> sparseArray) {
        String str;
        int size;
        if (sparseArray != null && sparseArray.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                e valueAt = sparseArray.valueAt(i3);
                int i16 = valueAt.f181731a;
                if (i16 > 4 && !this.f181722f.contains(Integer.valueOf(i16))) {
                    if (QLog.isColorLevel()) {
                        QLog.i("CTEntryMng", 2, "getEntryRedDotStr not save id: " + valueAt.f181731a);
                    }
                } else {
                    JSONObject b16 = valueAt.b();
                    if (b16 != null) {
                        jSONArray.mo162put(b16);
                    }
                }
            }
            str = jSONArray.toString();
        } else {
            str = "";
        }
        if (QLog.isColorLevel()) {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[2];
            if (sparseArray == null) {
                size = 0;
            } else {
                size = sparseArray.size();
            }
            objArr[0] = Integer.valueOf(size);
            objArr[1] = str;
            QLog.i("CTEntryMng", 2, String.format(locale, "getEntryRedDotStr size: %s, str: %s", objArr));
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f t(short s16) {
        for (int i3 = 0; i3 < this.f181724i.size(); i3++) {
            if (this.f181724i.get(i3).f181737b == s16) {
                return this.f181724i.get(i3);
            }
        }
        return null;
    }

    private void x() {
        if (this.D) {
            return;
        }
        synchronized (this.f181723h) {
            this.f181723h.clear();
        }
        F(y.a(this.f181720d.getApp(), this.f181720d.getCurrentUin(), "ct_entry_reddot_info"));
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, "initEntryRedDot");
        }
        this.D = true;
    }

    private void y() {
        if (this.E) {
            return;
        }
        String a16 = y.a(this.f181720d.getApp(), this.f181720d.getCurrentUin(), "ct_entry_user_setting");
        if (!TextUtils.isEmpty(a16)) {
            try {
                JSONArray jSONArray = new JSONArray(a16);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    f fVar = new f();
                    fVar.b(jSONObject);
                    if (fVar.f181736a != 0 && fVar.f181737b != 0) {
                        j(fVar);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        this.E = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z(boolean z16, String str) {
        if (!z16) {
            if (this.C) {
                return;
            }
        }
        x();
        y();
        D(str);
        v(true);
        this.C = true;
        B();
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "initOrUpdateConfig isFromServer: %s, value: %s uin: %s", Boolean.valueOf(z16), str, this.f181720d.getCurrentUin()));
        }
    }

    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        for (int i3 = 0; i3 < this.f181724i.size(); i3++) {
            if (this.f181724i.get(i3) != null && this.f181724i.get(i3).f181736a == 3) {
                return this.f181724i.get(i3).a();
            }
        }
        return false;
    }

    public void C(String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onConfigUpdatedFromServer tag: %s, localVersion: %s, version: %s, value: %s", str, Integer.valueOf(i3), Integer.valueOf(i16), str2));
        }
        if (AppConstants.Preferences.CONFESS_CONFIG.equals(str)) {
            M(true);
        } else if (AppConstants.Preferences.REGISTER_INVITATION_CONFIG.equals(str)) {
            Q(true);
        } else if (AppConstants.Preferences.CONTACT_TOP_ENTRY_CONFIG.equals(str)) {
            z(true, str2);
        }
    }

    protected void F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                e eVar = new e();
                eVar.a(jSONObject);
                if (eVar.f181731a != 0) {
                    synchronized (this.f181723h) {
                        this.f181723h.put(eVar.f181731a, eVar);
                    }
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "parseEntryRedDot size: %s, str: %s", Integer.valueOf(this.f181723h.size()), str));
        }
    }

    public void G(com.tencent.mobileqq.activity.contacts.topentry.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) cVar);
        } else if (cVar != null) {
            this.F.remove(cVar);
        }
    }

    public void J(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        this.J = z16;
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, "setEntryUIInit  " + z16);
        }
    }

    public void K(boolean z16, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("CTEntryMng", 4, "updateBindPhoneSwitchInfo needShow:" + z16 + " net_gap:" + i3 + " isNewUser:" + z17 + " uin:" + this.f181720d.getCurrentUin());
        }
        ea.G(this.f181720d.getCurrentUin()).edit().putBoolean("contacts_bind_phone_canshow", z16).putInt("contacts_bind_phone_next_gap", i3).putBoolean("contacts_bind_phone_is_new_user", z17).commit();
        P(false);
        B();
    }

    public void N(com.tencent.mobileqq.activity.contacts.topentry.a aVar, short s16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, aVar, Short.valueOf(s16));
            return;
        }
        if (aVar == null) {
            return;
        }
        f t16 = t(aVar.f181766j);
        if (t16 != null && t16.f181738c != s16) {
            t16.f181738c = s16;
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            I();
            B();
        }
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateEntrySetting [id:%s, switch_value: %s, needUpdate: %s]", Integer.valueOf(aVar.f181757a), Short.valueOf(s16), Boolean.valueOf(z16)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void P(boolean z16) {
        String str;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        if (this.H) {
            return;
        }
        com.tencent.mobileqq.activity.contacts.topentry.a l3 = l(5);
        boolean z18 = l3.f181767k;
        int selfBindState = ((IPhoneContactService) this.f181720d.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
        if (QLog.isDevelopLevel()) {
            QLog.i("CTEntryMng", 4, "updateFindFriendEntry selfBindState:" + selfBindState + " uin:" + this.f181720d.getCurrentUin());
        }
        if (selfBindState != 1 && selfBindState != 2) {
            l3.f181767k = false;
        } else {
            SharedPreferences G = ea.G(this.f181720d.getCurrentUin());
            boolean z19 = G.getBoolean("contacts_bind_phone_canshow", false);
            l3.f181767k = z19;
            if (z19) {
                l3.f181770n = Boolean.valueOf(G.getBoolean("contacts_bind_phone_is_new_user", false));
            }
            if (!l3.f181769m) {
                int i3 = G.getInt("contacts_bind_phone_next_gap", 300);
                long j3 = G.getLong("contacts_bind_phone_last_time", -1L);
                long serverTime = NetConnInfoCenter.getServerTime();
                if (!QLog.isDevelopLevel()) {
                    str = "CTEntryMng";
                } else {
                    str = "CTEntryMng";
                    QLog.i(str, 4, "updateFindFriendEntry nextGap:" + i3 + " gap:" + (serverTime - j3) + " uin:" + this.f181720d.getCurrentUin());
                }
                if (j3 < 0 || serverTime - j3 >= i3) {
                    CardHandler cardHandler = (CardHandler) this.f181720d.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
                    if (cardHandler != null) {
                        cardHandler.R2();
                    }
                    SharedPreferences.Editor edit = G.edit();
                    if (edit != null) {
                        edit.putLong("contacts_bind_phone_last_time", serverTime).commit();
                    }
                }
                L(l3);
                z17 = l3.f181767k;
                if (z18 != z17 && z17 && z16) {
                    u(l3);
                }
                if (!QLog.isColorLevel()) {
                    QLog.i(str, 2, String.format(Locale.getDefault(), "updateFindFriendEntry show: %s, title: %s, sub: %s, preValue: %s uin: %s", Boolean.valueOf(l3.f181767k), l3.f181758b, l3.f181759c, Boolean.valueOf(z18), this.f181720d.getCurrentUin()));
                    return;
                }
                return;
            }
        }
        str = "CTEntryMng";
        L(l3);
        z17 = l3.f181767k;
        if (z18 != z17) {
            u(l3);
        }
        if (!QLog.isColorLevel()) {
        }
    }

    public void S(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (this.I == i3) {
            return;
        }
        this.I = i3;
        int i16 = 1;
        if (i3 != 1) {
            i16 = 0;
        }
        com.tencent.mobileqq.activity.contacts.topentry.d.a(this.f181720d, i16);
        IRedTouchServer iRedTouchServer = (IRedTouchServer) this.f181720d.getRuntimeService(IRedTouchServer.class, "");
        if (iRedTouchServer != null) {
            iRedTouchServer.notifyRedTouchUpdate(this.f181720d);
        }
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, "updateRedPoint mRedDotFlag: " + this.I);
        }
    }

    public void k(com.tencent.mobileqq.activity.contacts.topentry.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) cVar);
        } else if (cVar != null && !this.F.contains(cVar)) {
            this.F.add(cVar);
        }
    }

    public com.tencent.mobileqq.activity.contacts.topentry.a l(int i3) {
        com.tencent.mobileqq.activity.contacts.topentry.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mobileqq.activity.contacts.topentry.a) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        synchronized (this.f181721e) {
            aVar = this.f181721e.get(i3);
        }
        if (aVar == null) {
            com.tencent.mobileqq.activity.contacts.topentry.a aVar2 = new com.tencent.mobileqq.activity.contacts.topentry.a();
            aVar2.f181757a = i3;
            aVar2.f181767k = false;
            aVar2.f181769m = false;
            aVar2.f181770n = null;
            return aVar2;
        }
        return aVar;
    }

    public List<com.tencent.mobileqq.activity.contacts.topentry.a> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (!this.C) {
            z(false, ea.D(this.f181720d.getApp(), this.f181720d.getCurrentUin(), AppConstants.Preferences.CONTACT_TOP_ENTRY_CONFIG));
        }
        return o();
    }

    public List<com.tencent.mobileqq.activity.contacts.topentry.a> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new ArrayList();
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPhoneContactService iPhoneContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.H = true;
        this.f181720d.getConfigProcess().h(this);
        this.F.clear();
        this.f181720d.removeObserver(this.K);
        this.f181720d.removeObserver(this.L);
        this.f181720d.removeObserver(this.N);
        this.f181725m.j();
        if (this.M != null && (iPhoneContactService = (IPhoneContactService) this.f181720d.getRuntimeService(IPhoneContactService.class, "")) != null) {
            iPhoneContactService.removeListener(this.M);
        }
        this.M = null;
    }

    @Override // com.tencent.mobileqq.config.c.b
    public void onGetConfig(QQAppInterface qQAppInterface, int i3, String str, c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, qQAppInterface, Integer.valueOf(i3), str, aVar);
        } else if (aVar != null) {
            C(str, aVar.f202860d, aVar.f202857a, aVar.f202858b);
        }
    }

    public List<com.tencent.mobileqq.activity.contacts.topentry.a> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        try {
            com.tencent.mobileqq.activity.contacts.topentry.a l3 = l(3);
            if (l3.a()) {
                l3.f181769m = s(3).a();
                l3.f181768l = false;
                arrayList.add(l3);
            }
            if (QLog.isColorLevel()) {
                QLog.i("CTEntryMng", 2, "getEntryListToShow size:" + arrayList.size() + "  canBeShown:" + l3.f181767k + "  isUserClose:" + l3.f181769m);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("CTEntryMng", 1, "getEntryListToShow error:" + e16.getMessage());
        }
        return arrayList;
    }

    public e q(int i3) {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (e) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        synchronized (this.f181723h) {
            eVar = this.f181723h.get(i3);
        }
        if (eVar == null) {
            e eVar2 = new e();
            eVar2.f181731a = i3;
            return eVar2;
        }
        return eVar;
    }

    public f s(int i3) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (f) iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
        int i16 = 0;
        while (true) {
            if (i16 < this.f181724i.size()) {
                if (this.f181724i.get(i16).f181736a == i3) {
                    fVar = this.f181724i.get(i16);
                    break;
                }
                i16++;
            } else {
                fVar = null;
                break;
            }
        }
        if (fVar == null) {
            fVar = new f();
            fVar.f181736a = i3;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                fVar.f181737b = (short) 0;
                            } else {
                                fVar.f181737b = ProfileContants.FIELD_CT_ENTRY_BIND_PHONE_SWITCH;
                            }
                        } else {
                            fVar.f181737b = ProfileContants.FIELD_CT_ENTRY_INVITE_REGISTER;
                        }
                    } else {
                        fVar.f181737b = ProfileContants.MAY_KNOW_IN_CONTACT_SWITCH_ID;
                    }
                } else {
                    fVar.f181737b = ProfileContants.FIELD_CT_ENTRY_EXTEND_FRD;
                }
            } else {
                fVar.f181737b = ProfileContants.FIELD_CT_ENTRY_CONFESS_SWITCH;
            }
            fVar.f181738c = ShortCompanionObject.MIN_VALUE;
        }
        return fVar;
    }

    public void u(com.tencent.mobileqq.activity.contacts.topentry.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) aVar);
            return;
        }
        if (aVar == null) {
            return;
        }
        short[] sArr = new short[1];
        int i3 = aVar.f181757a;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            sArr[0] = aVar.f181766j;
                        } else {
                            sArr[0] = ProfileContants.FIELD_CT_ENTRY_BIND_PHONE_SWITCH;
                        }
                    } else {
                        sArr[0] = ProfileContants.FIELD_CT_ENTRY_INVITE_REGISTER;
                    }
                } else {
                    sArr[0] = ProfileContants.MAY_KNOW_IN_CONTACT_SWITCH_ID;
                }
            } else {
                sArr[0] = ProfileContants.FIELD_CT_ENTRY_EXTEND_FRD;
            }
        } else {
            sArr[0] = ProfileContants.FIELD_CT_ENTRY_CONFESS_SWITCH;
        }
        f s16 = s(i3);
        s16.f181737b = sArr[0];
        j(s16);
        TempGetProfileDetailProcessor tempGetProfileDetailProcessor = (TempGetProfileDetailProcessor) ProfileServiceUtils.getBusinessProcessor(this.f181720d, TempGetProfileDetailProcessor.class);
        if (tempGetProfileDetailProcessor != null) {
            tempGetProfileDetailProcessor.getCommonSwitch(sArr);
        }
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer [id: %s, switch_id: %s, title: %s]", Integer.valueOf(aVar.f181757a), Short.valueOf(sArr[0]), aVar.f181758b));
        }
    }

    public void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
            return;
        }
        if (z16 && this.G > 20) {
            if (QLog.isColorLevel()) {
                QLog.i("CTEntryMng", 2, "getEntryUserSettingFromServer fromConfig to many times!");
                return;
            }
            return;
        }
        if (z16) {
            this.G++;
        }
        try {
            String str = "";
            List<com.tencent.mobileqq.activity.contacts.topentry.a> o16 = o();
            if (o16.size() > 0) {
                short[] sArr = new short[o16.size()];
                for (int i3 = 0; i3 < o16.size(); i3++) {
                    com.tencent.mobileqq.activity.contacts.topentry.a aVar = o16.get(i3);
                    int i16 = aVar.f181757a;
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                if (i16 != 4) {
                                    if (i16 != 5) {
                                        sArr[i3] = aVar.f181766j;
                                    } else {
                                        sArr[i3] = ProfileContants.FIELD_CT_ENTRY_BIND_PHONE_SWITCH;
                                    }
                                } else {
                                    sArr[i3] = ProfileContants.FIELD_CT_ENTRY_INVITE_REGISTER;
                                }
                            } else {
                                sArr[i3] = ProfileContants.MAY_KNOW_IN_CONTACT_SWITCH_ID;
                            }
                        } else {
                            sArr[i3] = ProfileContants.FIELD_CT_ENTRY_EXTEND_FRD;
                        }
                    } else {
                        sArr[i3] = ProfileContants.FIELD_CT_ENTRY_CONFESS_SWITCH;
                    }
                    f s16 = s(i16);
                    s16.f181737b = sArr[i3];
                    j(s16);
                    if (QLog.isColorLevel()) {
                        str = String.format(Locale.getDefault(), "%s, [id: %s, title: %s, flag: %s]", str, Integer.valueOf(aVar.f181757a), aVar.f181758b, Short.valueOf(sArr[i3]));
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer log: %s", str));
                }
                TempGetProfileDetailProcessor tempGetProfileDetailProcessor = (TempGetProfileDetailProcessor) ProfileServiceUtils.getBusinessProcessor(this.f181720d, TempGetProfileDetailProcessor.class);
                if (tempGetProfileDetailProcessor != null) {
                    tempGetProfileDetailProcessor.getCommonSwitch(sArr);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public com.tencent.mobileqq.activity.contacts.topentry.e w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.activity.contacts.topentry.e) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f181725m;
    }
}
