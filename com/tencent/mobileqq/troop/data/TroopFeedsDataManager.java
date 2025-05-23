package com.tencent.mobileqq.troop.data;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFeedsDataManager extends Observable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f294798a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f294799b;

    /* renamed from: c, reason: collision with root package name */
    public int f294800c;

    /* renamed from: d, reason: collision with root package name */
    public List<TroopFeedItem> f294801d;

    /* renamed from: e, reason: collision with root package name */
    protected TroopFeedItem f294802e;

    /* renamed from: f, reason: collision with root package name */
    protected QQAppInterface f294803f;

    /* renamed from: g, reason: collision with root package name */
    protected Long f294804g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f294805h;

    /* renamed from: i, reason: collision with root package name */
    Handler f294806i;

    /* renamed from: j, reason: collision with root package name */
    protected e.a f294807j;

    /* renamed from: k, reason: collision with root package name */
    protected LinkedHashMap<String, Integer> f294808k;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFeedsDataManager.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            TroopFeedsDataManager.this.setChanged();
                            TroopFeedsDataManager.this.notifyObservers(1010);
                            return;
                        } else {
                            if (i3 == 6) {
                                TroopFeedsDataManager.this.setChanged();
                                TroopFeedsDataManager.this.notifyObservers(103);
                                return;
                            }
                            return;
                        }
                    }
                    TroopFeedsDataManager troopFeedsDataManager = TroopFeedsDataManager.this;
                    troopFeedsDataManager.f294801d = (List) message.obj;
                    troopFeedsDataManager.setChanged();
                    TroopFeedsDataManager.this.notifyObservers(105);
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, "end auto pull down feed");
                        return;
                    }
                    return;
                }
                TroopFeedsDataManager troopFeedsDataManager2 = TroopFeedsDataManager.this;
                troopFeedsDataManager2.f294801d = (List) message.obj;
                troopFeedsDataManager2.setChanged();
                TroopFeedsDataManager.this.notifyObservers(101);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopFeedsDataManager", 2, "end load feed: " + System.currentTimeMillis());
                    return;
                }
                return;
            }
            TroopFeedsDataManager troopFeedsDataManager3 = TroopFeedsDataManager.this;
            troopFeedsDataManager3.f294801d = (List) message.obj;
            troopFeedsDataManager3.m(1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements sd2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f294815a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f294816b;

        b(String str, e eVar) {
            this.f294815a = str;
            this.f294816b = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopFeedsDataManager.this, str, eVar);
            }
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopFeedsDataManager", 2, "addPskeyToCookie onFail errMsg: " + str);
            }
            e eVar = this.f294816b;
            if (eVar != null) {
                eVar.onFail(str);
            }
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopFeedsDataManager", 2, "addPskeyToCookie onSuccess");
            }
            String str2 = map.get(this.f294815a);
            String currentAccountUin = TroopFeedsDataManager.this.f294803f.getCurrentAccountUin();
            if (StringUtil.isEmpty(str2) || str2.length() < 10) {
                str = "";
            } else {
                str = str2.substring(0, 10);
            }
            if (TextUtils.isEmpty(str)) {
                QLog.d("TroopFeedsDataManager", 1, "addPsKeyToCookie skey is null");
            }
            if (TextUtils.isEmpty(str2)) {
                QLog.d("TroopFeedsDataManager", 1, "addPsKeyToCookie pSkey is null");
            }
            String str3 = "uin=o" + currentAccountUin + ";skey=" + str + ";p_uin=o" + currentAccountUin + ";p_skey=" + str2;
            String str4 = "" + TroopUtils.h(str);
            e eVar = this.f294816b;
            if (eVar != null) {
                eVar.onSuccess(str3, str4);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f294818a;

        c(int i3) {
            this.f294818a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFeedsDataManager.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.troop.data.TroopFeedsDataManager.e
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else if (QLog.isColorLevel()) {
                QLog.d("TroopFeedsDataManager", 2, "getRecentNoticeFromServer addPskeyToCookie fail : " + str);
            }
        }

        @Override // com.tencent.mobileqq.troop.data.TroopFeedsDataManager.e
        public void onSuccess(@NonNull String str, @NonNull String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("qid", "" + TroopFeedsDataManager.this.f294804g);
            bundle.putString("ft", "23");
            bundle.putString("ni", "1");
            if (this.f294818a == 1003) {
                bundle.putString("is_getinst", "1");
            }
            bundle.putString(DomainData.DOMAIN_NAME, "1");
            bundle.putString("i", "1");
            bundle.putString(ReportConstant.COSTREPORT_PREFIX, "-1");
            bundle.putString("log_read", "1");
            bundle.putString("ver", "" + AppSetting.d());
            bundle.putString("platform", "1");
            bundle.putString("bkn", str2);
            bundle.putString("Cookie", str);
            HashMap hashMap = new HashMap();
            hashMap.put("BUNDLE", bundle);
            TroopFeedsDataManager.this.f294803f.getApplication();
            hashMap.put("CONTEXT", BaseApplication.getContext());
            new com.tencent.mobileqq.troop.utils.e("https://web.qun.qq.com/cgi-bin/announce/get_t_list", "GET", TroopFeedsDataManager.this.f294807j, this.f294818a, null, true).execute(hashMap);
            if (QLog.isColorLevel()) {
                QLog.d("TroopFeedsDataManager", 2, "getRecentNoticeFromServer start: " + System.currentTimeMillis());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d implements e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f294820a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f294821b;

        d(String str, int i3) {
            this.f294820a = str;
            this.f294821b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopFeedsDataManager.this, str, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.troop.data.TroopFeedsDataManager.e
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else if (QLog.isColorLevel()) {
                QLog.d("TroopFeedsDataManager", 2, "getNoticeFromServer addPskeyToCookie fail : " + str);
            }
        }

        @Override // com.tencent.mobileqq.troop.data.TroopFeedsDataManager.e
        public void onSuccess(@NonNull String str, @NonNull String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("qid", "" + TroopFeedsDataManager.this.f294804g);
            bundle.putString(Utils.KEY_BUSINESS_ID, "" + this.f294820a);
            bundle.putString("ver", "" + AppSetting.f99551k);
            bundle.putString("platform", "1");
            bundle.putString("bkn", str2);
            bundle.putString("Cookie", str);
            HashMap hashMap = new HashMap();
            hashMap.put("BUNDLE", bundle);
            TroopFeedsDataManager.this.f294803f.getApplication();
            hashMap.put("CONTEXT", BaseApplication.getContext());
            new com.tencent.mobileqq.troop.utils.e("https://web.qun.qq.com/cgi-bin/announce/get_feed", "GET", TroopFeedsDataManager.this.f294807j, this.f294821b, null, true).execute(hashMap);
            if (QLog.isColorLevel()) {
                QLog.d("TroopFeedsDataManager", 2, "getNoticeFromServer start: " + System.currentTimeMillis() + ", feedId: " + this.f294820a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface e {
        void onFail(@NonNull String str);

        void onSuccess(@NonNull String str, @NonNull String str2);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f294823a;

        /* renamed from: b, reason: collision with root package name */
        public String f294824b;

        /* renamed from: c, reason: collision with root package name */
        public String f294825c;

        /* renamed from: d, reason: collision with root package name */
        public String f294826d;

        /* renamed from: e, reason: collision with root package name */
        public String f294827e;

        /* renamed from: f, reason: collision with root package name */
        public int f294828f;

        /* renamed from: g, reason: collision with root package name */
        public int f294829g;

        /* renamed from: h, reason: collision with root package name */
        public String f294830h;

        /* renamed from: i, reason: collision with root package name */
        public String f294831i;

        /* renamed from: j, reason: collision with root package name */
        public String f294832j;

        /* renamed from: k, reason: collision with root package name */
        public String f294833k;

        /* renamed from: l, reason: collision with root package name */
        public long f294834l;

        /* renamed from: m, reason: collision with root package name */
        public String f294835m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f294836n;

        /* renamed from: o, reason: collision with root package name */
        public int f294837o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f294838p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f294839q;

        /* renamed from: r, reason: collision with root package name */
        public String f294840r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f294841s;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f294823a = 1;
            this.f294824b = null;
            this.f294825c = null;
            this.f294826d = null;
            this.f294827e = null;
            this.f294828f = 0;
            this.f294829g = 0;
            this.f294830h = null;
            this.f294831i = null;
            this.f294832j = null;
            this.f294833k = null;
            this.f294834l = 0L;
            this.f294835m = null;
            this.f294836n = false;
            this.f294837o = 0;
            this.f294838p = true;
            this.f294839q = false;
            this.f294840r = null;
            this.f294841s = false;
        }

        public static f a(JSONObject jSONObject) {
            boolean z16;
            boolean z17;
            JSONObject optJSONObject;
            boolean z18;
            if (jSONObject != null && jSONObject.has("msg")) {
                f fVar = new f();
                fVar.f294824b = jSONObject.optString(Utils.KEY_BUSINESS_ID);
                boolean z19 = true;
                if (jSONObject.has("is_read")) {
                    if (jSONObject.optInt("is_read") != 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    fVar.f294841s = z18;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("msg");
                if (optJSONObject2 == null) {
                    return null;
                }
                String optString = optJSONObject2.optString("text_face");
                fVar.f294826d = optString;
                if (optString != null) {
                    fVar.f294826d = optString.replace("&#10;", "<br/>");
                }
                String optString2 = optJSONObject2.optString("title");
                fVar.f294825c = optString2;
                if (optString2 != null) {
                    fVar.f294825c = optString2.replace("&#10;", "<br/>");
                }
                if (fVar.f294825c != null && fVar.f294826d != null) {
                    fVar.f294840r = jSONObject.optString(Utils.KEY_BUSINESS_ID);
                    JSONArray optJSONArray = optJSONObject2.optJSONArray(s4.c.PICS);
                    if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106033", true)) {
                            fVar.f294827e = "https://gdynamic.qpic.cn/gdynamic/" + optJSONObject.optString("id") + "/";
                        } else {
                            fVar.f294827e = "https://gdynamic.qpic.cn/gdynamic/" + optJSONObject.optString("id") + "/628";
                        }
                        fVar.f294830h = "https://gdynamic.qpic.cn/gdynamic/" + optJSONObject.optString("id") + "/";
                        try {
                            fVar.f294828f = Integer.parseInt(optJSONObject.optString("w"));
                            fVar.f294829g = Integer.parseInt(optJSONObject.optString(tl.h.F));
                        } catch (Exception e16) {
                            QLog.e("TroopFeedsDataManager", 1, "parseTroopNotify: parse pic size error", e16);
                        }
                    }
                    JSONObject optJSONObject3 = jSONObject.optJSONObject(QCircleDaTongConstant.ElementParamValue.SETTINGS);
                    if (optJSONObject3 != null) {
                        if (optJSONObject3.optInt("is_show_edit_card", 0) == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        fVar.f294836n = z16;
                        if (optJSONObject3.optInt("tip_window_type", 0) == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        fVar.f294838p = z17;
                        if (optJSONObject3.optInt("confirm_required", 0) != 1) {
                            z19 = false;
                        }
                        fVar.f294839q = z19;
                    }
                    if (optJSONObject2.has("v")) {
                        JSONObject optJSONObject4 = optJSONObject2.optJSONObject("v");
                        fVar.f294831i = optJSONObject4.optString("l");
                        fVar.f294827e = optJSONObject4.optString("bi");
                    }
                    fVar.f294832j = jSONObject.optString("u");
                    fVar.f294834l = jSONObject.optLong("pubt");
                    fVar.f294837o = jSONObject.optInt("read_num");
                    return fVar;
                }
            }
            return null;
        }
    }

    public TroopFeedsDataManager(QQAppInterface qQAppInterface, Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) l3);
            return;
        }
        this.f294798a = null;
        this.f294799b = null;
        this.f294800c = 0;
        this.f294801d = Collections.synchronizedList(new ArrayList());
        this.f294802e = null;
        this.f294805h = false;
        this.f294806i = new a(Looper.getMainLooper());
        this.f294807j = new e.a() { // from class: com.tencent.mobileqq.troop.data.TroopFeedsDataManager.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFeedsDataManager.this);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:96:0x003a, code lost:
            
                if (r13.optInt("ec") != 0) goto L22;
             */
            /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x008d  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x01c9  */
            /* JADX WARN: Removed duplicated region for block: B:70:0x01d4  */
            /* JADX WARN: Removed duplicated region for block: B:72:0x01e2  */
            /* JADX WARN: Removed duplicated region for block: B:80:0x021e  */
            /* JADX WARN: Removed duplicated region for block: B:82:0x01ce  */
            @Override // com.tencent.mobileqq.troop.utils.e.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
                boolean z16;
                boolean z17;
                long optLong;
                JSONObject jSONObject2;
                long j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                boolean z18 = true;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, jSONObject, Integer.valueOf(i3), bundle);
                    return;
                }
                if (jSONObject != null) {
                    try {
                        if (jSONObject.optInt("retcode") != 0) {
                        }
                        z16 = true;
                        if (!z16) {
                            if (i3 == 1000 || i3 == 1002) {
                                TroopFeedsDataManager.this.setChanged();
                                TroopFeedsDataManager.this.notifyObservers(103);
                                if (i3 == 1002) {
                                    TroopFeedsDataManager.this.f294808k.clear();
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("TroopFeedsDataManager", 2, "cgi end(failed): " + System.currentTimeMillis());
                                return;
                            }
                            return;
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopFeedsDataManager", 2, "cgi end(suc): " + System.currentTimeMillis());
                    }
                    if (i3 != 1000) {
                        ThreadManager.getSubThreadHandler().post(new Runnable(jSONObject) { // from class: com.tencent.mobileqq.troop.data.TroopFeedsDataManager.5.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ JSONObject f294810d;

                            {
                                this.f294810d = jSONObject;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) jSONObject);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Object[] c16 = m.c(this.f294810d, "" + TroopFeedsDataManager.this.f294804g, TroopFeedsDataManager.this.f294803f.getCurrentAccountUin());
                                List<String> list = (List) c16[0];
                                List<TroopFeedItem> list2 = (List) c16[1];
                                list2.addAll(TroopFeedsDataManager.this.f294801d);
                                Message obtainMessage = TroopFeedsDataManager.this.f294806i.obtainMessage(3);
                                obtainMessage.obj = TroopFeedsDataManager.this.k(list, list2);
                                TroopFeedsDataManager.this.f294806i.sendMessage(obtainMessage);
                            }
                        });
                        return;
                    }
                    if (i3 == 1002) {
                        ThreadManager.getSubThreadHandler().post(new Runnable(jSONObject) { // from class: com.tencent.mobileqq.troop.data.TroopFeedsDataManager.5.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ JSONObject f294812d;

                            {
                                this.f294812d = jSONObject;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) jSONObject);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Object[] c16 = m.c(this.f294812d, "" + TroopFeedsDataManager.this.f294804g, TroopFeedsDataManager.this.f294803f.getCurrentAccountUin());
                                List<String> list = (List) c16[0];
                                List<TroopFeedItem> list2 = (List) c16[1];
                                if (list != null && list2 != null) {
                                    String obj = list.toString();
                                    for (int size = list.size() - 1; size >= 0; size--) {
                                        String str = list.get(size);
                                        if (!TroopFeedsDataManager.this.f294808k.containsKey(str)) {
                                            list.remove(str);
                                        }
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, "cgi callback ids, beforeFilter:" + obj + "|afterFilter ids:" + list.toString());
                                    }
                                    TroopFeedsDataManager.this.f294808k.clear();
                                    Message obtainMessage = TroopFeedsDataManager.this.f294806i.obtainMessage(4);
                                    obtainMessage.obj = TroopFeedsDataManager.this.k(list, list2);
                                    TroopFeedsDataManager.this.f294806i.sendMessage(obtainMessage);
                                }
                            }
                        });
                        return;
                    }
                    if (i3 == 1007) {
                        TroopFeedsDataManager troopFeedsDataManager = TroopFeedsDataManager.this;
                        troopFeedsDataManager.f294799b = jSONObject;
                        troopFeedsDataManager.setChanged();
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopFeedsDataManager", 2, "cgi return. requestCode: GET_TROOP_NOTICE, msg = NOTIFY_REMIND_NOTICE");
                        }
                        TroopFeedsDataManager.this.notifyObservers(1011);
                        return;
                    }
                    if (i3 != 1004 && i3 != 1003) {
                        if (i3 == 1005 || i3 == 1006) {
                            Object[] c16 = m.c(jSONObject, "" + TroopFeedsDataManager.this.f294804g, TroopFeedsDataManager.this.f294803f.getCurrentAccountUin());
                            List<TroopFeedItem> list = (List) c16[1];
                            TroopFeedsDataManager troopFeedsDataManager2 = TroopFeedsDataManager.this;
                            troopFeedsDataManager2.f294801d = list;
                            troopFeedsDataManager2.setChanged();
                            if (i3 == 1005) {
                                TroopFeedsDataManager.this.notifyObservers(1008);
                                return;
                            } else {
                                TroopFeedsDataManager.this.notifyObservers(1009);
                                return;
                            }
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopFeedsDataManager", 2, "cgi return. requestCode: GET_NOR_NOTICE");
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("feeds");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("inst");
                    if (optJSONArray != null && optJSONArray.length() == 1) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                        TroopFeedsDataManager troopFeedsDataManager3 = TroopFeedsDataManager.this;
                        troopFeedsDataManager3.f294799b = optJSONObject;
                        troopFeedsDataManager3.f294800c = jSONObject.optInt("ad");
                    } else if (optJSONArray != null && optJSONArray.length() == 2) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                        JSONObject optJSONObject3 = optJSONArray.optJSONObject(1);
                        if (optJSONObject2.optLong("pubt") >= optJSONObject3.optLong("pubt")) {
                            TroopFeedsDataManager troopFeedsDataManager4 = TroopFeedsDataManager.this;
                            troopFeedsDataManager4.f294799b = optJSONObject2;
                            troopFeedsDataManager4.f294800c = jSONObject.optInt("ad");
                        } else {
                            TroopFeedsDataManager troopFeedsDataManager5 = TroopFeedsDataManager.this;
                            troopFeedsDataManager5.f294799b = optJSONObject3;
                            troopFeedsDataManager5.f294800c = jSONObject.optInt("ad");
                        }
                    } else {
                        z17 = false;
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            JSONObject optJSONObject4 = optJSONArray2.optJSONObject(0);
                            optLong = optJSONObject4.optLong("pubt");
                            jSONObject2 = TroopFeedsDataManager.this.f294799b;
                            if (jSONObject2 == null) {
                                j3 = jSONObject2.optLong("pubt");
                            } else {
                                j3 = 0;
                            }
                            if (optLong > j3) {
                                TroopFeedsDataManager troopFeedsDataManager6 = TroopFeedsDataManager.this;
                                troopFeedsDataManager6.f294799b = optJSONObject4;
                                troopFeedsDataManager6.f294800c = jSONObject.optInt("ad");
                                if (z18) {
                                    TroopFeedsDataManager.this.setChanged();
                                    if (QLog.isColorLevel()) {
                                        QLog.d("TroopFeedsDataManager", 2, "cgi return. NOTIFY_NOR_NOTICE");
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("TroopFeedsDataManager", 2, "NOTIFY_NOR_NOTICE : " + TroopFeedsDataManager.this.countObservers());
                                    }
                                    TroopFeedsDataManager.this.notifyObservers(1007);
                                    return;
                                }
                                TroopFeedsDataManager.this.setChanged();
                                TroopFeedsDataManager.this.notifyObservers(1012);
                                return;
                            }
                        }
                        z18 = z17;
                        if (z18) {
                        }
                    }
                    z17 = true;
                    if (optJSONArray2 != null) {
                        JSONObject optJSONObject42 = optJSONArray2.optJSONObject(0);
                        optLong = optJSONObject42.optLong("pubt");
                        jSONObject2 = TroopFeedsDataManager.this.f294799b;
                        if (jSONObject2 == null) {
                        }
                        if (optLong > j3) {
                        }
                    }
                    z18 = z17;
                    if (z18) {
                    }
                }
                z16 = false;
                if (!z16) {
                }
                if (QLog.isColorLevel()) {
                }
                if (i3 != 1000) {
                }
            }
        };
        this.f294808k = new LinkedHashMap<>();
        this.f294803f = qQAppInterface;
        this.f294804g = l3;
    }

    private void j(e eVar) {
        ((IPskeyManager) this.f294803f.getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{FlockBaseRequest.QUN_DOMAIN}, new b(FlockBaseRequest.QUN_DOMAIN, eVar));
    }

    public List<TroopFeedItem> k(List<String> list, List<TroopFeedItem> list2) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) list2);
        }
        ArrayList arrayList = new ArrayList();
        if (this.f294802e != null) {
            Iterator<TroopFeedItem> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TroopFeedItem next = it.next();
                TroopFeedItem troopFeedItem = this.f294802e;
                if (troopFeedItem != null && next.f203122id.equalsIgnoreCase(troopFeedItem.f203122id)) {
                    this.f294802e = next;
                    break;
                }
            }
            arrayList.add(this.f294802e);
            i3 = 0;
        } else {
            i3 = 1;
        }
        for (String str : list) {
            if (i3 <= 0) {
                break;
            }
            TroopFeedItem troopFeedItem2 = this.f294802e;
            if (troopFeedItem2 == null || !str.equalsIgnoreCase(troopFeedItem2.f203122id)) {
                Iterator<TroopFeedItem> it5 = list2.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        TroopFeedItem next2 = it5.next();
                        if (str.equalsIgnoreCase(next2.f203122id)) {
                            arrayList.add(next2);
                            i3--;
                            break;
                        }
                    }
                }
            }
        }
        this.f294802e = null;
        return arrayList;
    }

    public void l(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
        } else {
            if (str == null) {
                return;
            }
            j(new d(str, i3));
        }
    }

    public void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            j(new c(i3));
        }
    }

    public void o(String str, Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) num);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, "setTroopNotificationCenterAutoPullDownFlag, troopUin:" + this.f294804g + ",feedsId:" + str + ",status:" + num);
        }
        if (num.intValue() != 1) {
            return;
        }
        this.f294808k.put(str, num);
    }
}
