package com.tencent.av.gaudio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.app.QuaReportInfo;
import com.tencent.av.q;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.ae;
import com.tencent.av.utils.ba;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.AVBizServerQIPCModule;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.od.api.IODQShadowLoadApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.r;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsFreControlHelper;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;
import tencent.im.s2c.msgtype0x210.submsgtype0x126.submsgtype0x126$MsgBody;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVNotifyCenter extends Observable {
    private static boolean I = false;
    private Map<String, j> A;
    private Map<String, j> B;
    Runnable C;
    HashMap<String, f> D;
    Runnable E;
    long F;
    boolean G;
    int H;

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f73755a;

    /* renamed from: b, reason: collision with root package name */
    String f73756b;

    /* renamed from: f, reason: collision with root package name */
    MqqHandler f73760f;

    /* renamed from: i, reason: collision with root package name */
    private PhoneStatusMonitor f73763i;

    /* renamed from: r, reason: collision with root package name */
    private final c f73772r;

    /* renamed from: s, reason: collision with root package name */
    private c f73773s;

    /* renamed from: t, reason: collision with root package name */
    ConcurrentHashMap<Long, b> f73774t;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<g> f73775u;

    /* renamed from: v, reason: collision with root package name */
    private int f73776v;

    /* renamed from: w, reason: collision with root package name */
    private int f73777w;

    /* renamed from: x, reason: collision with root package name */
    private String f73778x;

    /* renamed from: y, reason: collision with root package name */
    private String f73779y;

    /* renamed from: z, reason: collision with root package name */
    private Map<String, i> f73780z;

    /* renamed from: c, reason: collision with root package name */
    boolean f73757c = true;

    /* renamed from: d, reason: collision with root package name */
    Map f73758d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    Map f73759e = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private boolean f73761g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f73762h = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f73764j = false;

    /* renamed from: k, reason: collision with root package name */
    private ConcurrentHashMap<Long, e> f73765k = new ConcurrentHashMap<>();

    /* renamed from: l, reason: collision with root package name */
    private ConcurrentHashMap<Long, e> f73766l = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private HashMap<Long, AVPhoneUserInfo> f73767m = new HashMap<>();

    /* renamed from: n, reason: collision with root package name */
    public Map<String, String> f73768n = new HashMap();

    /* renamed from: o, reason: collision with root package name */
    public Map<String, Integer> f73769o = new ConcurrentHashMap();

    /* renamed from: p, reason: collision with root package name */
    private long f73770p = 0;

    /* renamed from: q, reason: collision with root package name */
    private HashMap<String, c> f73771q = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class UpdateChattingTime implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<AVNotifyCenter> f73781d;

        public UpdateChattingTime(AVNotifyCenter aVNotifyCenter) {
            this.f73781d = new WeakReference<>(aVNotifyCenter);
        }

        @Override // java.lang.Runnable
        public void run() {
            AVNotifyCenter aVNotifyCenter = this.f73781d.get();
            if (aVNotifyCenter == null) {
                return;
            }
            if (aVNotifyCenter.i0(String.valueOf(aVNotifyCenter.f73773s.f73791h))) {
                aVNotifyCenter.E = null;
                return;
            }
            MqqHandler mqqHandler = aVNotifyCenter.f73760f;
            if (mqqHandler != null) {
                mqqHandler.postDelayed(this, 2000L);
            }
            if (aVNotifyCenter.G) {
                String formatTime = ba.formatTime(aVNotifyCenter.F);
                if (aVNotifyCenter.f73773s.f73786c == 3) {
                    aVNotifyCenter.p0(29, 0, Long.toString(aVNotifyCenter.f73773s.f73791h), formatTime);
                } else {
                    aVNotifyCenter.p0(29, 0, aVNotifyCenter.f73773s.f73788e, formatTime);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class a implements PhoneStatusMonitor.a {
        a() {
        }

        @Override // com.tencent.av.utils.PhoneStatusMonitor.a
        public void a(boolean z16) {
            AVBizServerQIPCModule.getInstance().onSystemPhoneStatusChange(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f73782a;

        /* renamed from: b, reason: collision with root package name */
        public int f73783b;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final String f73784a;

        /* renamed from: b, reason: collision with root package name */
        boolean f73785b = true;

        /* renamed from: c, reason: collision with root package name */
        int f73786c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f73787d = 0;

        /* renamed from: e, reason: collision with root package name */
        String f73788e = null;

        /* renamed from: f, reason: collision with root package name */
        String f73789f = null;

        /* renamed from: g, reason: collision with root package name */
        boolean f73790g = false;

        /* renamed from: h, reason: collision with root package name */
        long f73791h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f73792i = 0;

        /* renamed from: j, reason: collision with root package name */
        boolean f73793j = false;

        /* renamed from: k, reason: collision with root package name */
        boolean f73794k = false;

        /* renamed from: l, reason: collision with root package name */
        boolean f73795l = false;

        c(String str, long j3) {
            this.f73784a = "AvChatData_" + str + "_" + j3;
        }

        public String toString() {
            return this.f73784a + ", mRelationId[" + this.f73791h + "], mRelationType[" + this.f73792i + "], mUinType[" + this.f73787d + "], mPeerUin[" + this.f73788e + "], mIsChating[" + this.f73794k + "], mIsWaitting[" + this.f73793j + "]";
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class d extends MqqHandler {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<AVNotifyCenter> f73796d;

        public d(Looper looper, AVNotifyCenter aVNotifyCenter) {
            super(looper);
            this.f73796d = new WeakReference<>(aVNotifyCenter);
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            AVNotifyCenter aVNotifyCenter = this.f73796d.get();
            if (aVNotifyCenter == null || !aVNotifyCenter.g0()) {
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.w("AVNotifyCenter", 1, "handleMessage, msg[" + message.what + "]");
            }
            int i3 = message.what;
            if (i3 >= 10003 && i3 <= 10009) {
                Intent intent = new Intent("tencent.video.q2v.MultiVideo");
                intent.putExtra("type", 35);
                intent.setPackage(aVNotifyCenter.f73755a.getApp().getPackageName());
                aVNotifyCenter.f73755a.getApp().sendBroadcast(intent);
            }
            int i16 = message.what;
            if (i16 != 10010) {
                if (i16 != 10011) {
                    switch (i16) {
                        case 10002:
                            aVNotifyCenter.j();
                            return;
                        case 10003:
                            Intent intent2 = new Intent("tencent.video.q2v.MultiVideo");
                            intent2.putExtra("type", 26);
                            intent2.putExtra("discussId", ((Long) message.obj).longValue());
                            intent2.putExtra("memberUin", aVNotifyCenter.f73755a.getCurrentAccountUin());
                            intent2.setPackage(aVNotifyCenter.f73755a.getApp().getPackageName());
                            aVNotifyCenter.f73755a.getApp().sendBroadcast(intent2);
                            return;
                        case 10004:
                            Object[] objArr = (Object[]) message.obj;
                            Intent intent3 = new Intent("tencent.video.q2v.MultiVideo");
                            intent3.putExtra("type", 24);
                            intent3.putExtra("discussId", ((Long) objArr[0]).longValue());
                            intent3.putExtra("cmdUin", (String) objArr[1]);
                            intent3.putExtra("uins", (String[]) objArr[2]);
                            intent3.setPackage(aVNotifyCenter.f73755a.getApp().getPackageName());
                            aVNotifyCenter.f73755a.getApp().sendBroadcast(intent3);
                            return;
                        case 10005:
                            Object[] objArr2 = (Object[]) message.obj;
                            Intent intent4 = new Intent("tencent.video.q2v.MultiVideo");
                            intent4.putExtra("type", 31);
                            intent4.putExtra("discussId", ((Long) objArr2[0]).longValue());
                            intent4.putExtra("cmdUin", (String) objArr2[1]);
                            intent4.putExtra("uins", (String[]) objArr2[2]);
                            intent4.setPackage(aVNotifyCenter.f73755a.getApp().getPackageName());
                            aVNotifyCenter.f73755a.getApp().sendBroadcast(intent4);
                            return;
                        default:
                            return;
                    }
                }
                Intent intent5 = new Intent("tencent.video.q2v.MultiVideo");
                intent5.putExtra("type", 34);
                intent5.putExtra("relationId", ((Long) message.obj).longValue());
                intent5.setPackage(aVNotifyCenter.f73755a.getApp().getPackageName());
                aVNotifyCenter.f73755a.getApp().sendBroadcast(intent5);
                return;
            }
            aVNotifyCenter.M0(((Boolean) message.obj).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        public long f73797a = 0;

        /* renamed from: b, reason: collision with root package name */
        public Vector<h> f73798b = null;

        public e() {
        }

        public String toString() {
            Object valueOf;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("roomNum[");
            sb5.append(this.f73797a);
            sb5.append("], list[");
            Vector<h> vector = this.f73798b;
            if (vector == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(vector.size());
            }
            sb5.append(valueOf);
            sb5.append("]");
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class f {

        /* renamed from: a, reason: collision with root package name */
        public long f73800a;

        /* renamed from: b, reason: collision with root package name */
        public int f73801b;

        f(long j3, int i3) {
            this.f73800a = j3;
            this.f73801b = i3;
        }

        public String toString() {
            return "OtherTerChatingRoomInfo:mRoomId=" + this.f73800a + ", mSessionType=" + this.f73801b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class g {

        /* renamed from: a, reason: collision with root package name */
        public String f73802a;

        /* renamed from: b, reason: collision with root package name */
        public String f73803b;

        /* renamed from: c, reason: collision with root package name */
        public String f73804c;

        public g(String str, String str2, String str3) {
            this.f73802a = str;
            this.f73803b = str2;
            this.f73804c = str3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public long f73805a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f73806b = false;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        final long f73807a = com.tencent.av.utils.e.d();

        /* renamed from: b, reason: collision with root package name */
        public long f73808b;

        /* renamed from: c, reason: collision with root package name */
        public int f73809c;

        /* renamed from: d, reason: collision with root package name */
        public int f73810d;

        /* renamed from: e, reason: collision with root package name */
        public int f73811e;

        /* renamed from: f, reason: collision with root package name */
        public int f73812f;

        /* renamed from: g, reason: collision with root package name */
        public int f73813g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f73814h;

        /* renamed from: i, reason: collision with root package name */
        public int f73815i;

        /* renamed from: j, reason: collision with root package name */
        public long f73816j;

        i() {
        }

        public boolean a() {
            int i3;
            QLog.iAsync("AVNotifyCenter", 1, "[isGroupMultiVideo] roomInfo = " + this);
            int i16 = this.f73810d;
            if (i16 == 2 && (((i3 = this.f73812f) == 1 || i3 == 2) && this.f73813g == 0)) {
                return true;
            }
            if (i16 == 2 && this.f73812f == 2 && this.f73813g == 4 && this.f73811e == 1) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (this.f73810d == 2 && this.f73812f == 2 && this.f73813g == 4 && this.f73811e == 0) {
                return true;
            }
            return false;
        }

        public boolean c() {
            if (this.f73810d == 2 && this.f73812f == 2 && this.f73813g == 5 && this.f73811e == 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "seq[" + this.f73807a + "], relationId[" + this.f73808b + "], avtype[" + this.f73810d + "], roomMode[" + this.f73812f + "], gameId[" + this.f73813g + "], liveExtraMode[" + this.f73811e + "], memberNum[" + this.f73809c + "], event[" + this.f73815i + "], time[" + this.f73816j + "]";
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public long f73817a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f73818b;

        /* renamed from: c, reason: collision with root package name */
        public int f73819c = 0;

        public String toString() {
            return "relationId[" + this.f73817a + "], isOffLine[" + this.f73818b + "], avType[" + this.f73819c + "]";
        }
    }

    public AVNotifyCenter(QQAppInterface qQAppInterface) {
        this.f73755a = null;
        this.f73756b = null;
        this.f73760f = null;
        c cVar = new c("default", 0L);
        this.f73772r = cVar;
        this.f73773s = cVar;
        this.f73774t = new ConcurrentHashMap<>();
        this.f73776v = 0;
        this.f73777w = 0;
        this.f73778x = null;
        this.f73779y = null;
        this.f73780z = new HashMap();
        this.A = new HashMap();
        this.B = new HashMap();
        this.C = new Runnable() { // from class: com.tencent.av.gaudio.AVNotifyCenter.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = AVNotifyCenter.this.f73765k.keySet().iterator();
                while (it.hasNext()) {
                    long longValue = ((Long) it.next()).longValue();
                    AVNotifyCenter aVNotifyCenter = AVNotifyCenter.this;
                    aVNotifyCenter.W0(longValue, 2, aVNotifyCenter.l(longValue), false);
                    AVNotifyCenter.this.I0(1, 2, longValue, null, 0L);
                    AVNotifyCenter.this.m0(21, 2, longValue, 0L);
                    it.remove();
                }
                Iterator it5 = AVNotifyCenter.this.f73766l.keySet().iterator();
                while (it5.hasNext()) {
                    long longValue2 = ((Long) it5.next()).longValue();
                    AVNotifyCenter aVNotifyCenter2 = AVNotifyCenter.this;
                    aVNotifyCenter2.W0(longValue2, 1, aVNotifyCenter2.l(longValue2), false);
                    AVNotifyCenter.this.Z0(1, longValue2, 10, 0, 0, 21, 0);
                    AVNotifyCenter.this.I0(2, 1, longValue2, null, 0L);
                    AVNotifyCenter.this.m0(21, 1, longValue2, 0L);
                    it5.remove();
                }
            }
        };
        this.D = new HashMap<>();
        this.F = 0L;
        this.G = true;
        this.H = 0;
        if (qQAppInterface != null) {
            this.f73755a = qQAppInterface;
            this.f73756b = qQAppInterface.getCurrentAccountUin();
            this.f73760f = new d(Looper.getMainLooper(), this);
            this.f73755a.setHandler(getClass(), this.f73760f);
            this.f73755a.runOnUiThread(new Runnable() { // from class: com.tencent.av.gaudio.AVNotifyCenter.1
                @Override // java.lang.Runnable
                public void run() {
                    AVNotifyCenter aVNotifyCenter = AVNotifyCenter.this;
                    QQAppInterface qQAppInterface2 = aVNotifyCenter.f73755a;
                    if (qQAppInterface2 != null) {
                        aVNotifyCenter.f73763i = new PhoneStatusMonitor(qQAppInterface2.getApp(), new a());
                    }
                }
            });
            l0();
        }
    }

    private void T0(int i3, int i16, String str, int i17, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.iAsync("AVNotifyCenter", 1, "setSessionType[" + i3 + "], relationId[" + str + "], relaitonType[" + i16 + "], sessionType[" + i17 + "], isDouble[" + z16 + "]");
        }
        if (i17 == 0) {
            w0(str);
            return;
        }
        c m3 = m(str, true);
        if (m3 != null) {
            m3.f73785b = z16;
            m3.f73786c = i17;
            try {
                m3.f73791h = Long.parseLong(str);
            } catch (Exception e16) {
                QLog.w("AVNotifyCenter", 1, "setSessionType, relationId[" + str + "]", e16);
            }
            m3.f73792i = i16;
        }
    }

    public static boolean V() {
        return I;
    }

    private void f(String str, c cVar) {
        c cVar2 = this.f73773s;
        if (this.f73771q.size() == 1) {
            Iterator<String> it = this.f73771q.keySet().iterator();
            c cVar3 = null;
            while (it.hasNext()) {
                cVar3 = this.f73771q.get(it.next());
            }
            if (cVar3 != null) {
                this.f73773s = cVar3;
            } else {
                this.f73773s = this.f73772r;
            }
            cVar = cVar3;
        } else if (this.f73771q.size() == 0) {
            this.f73773s = this.f73772r;
        } else if (cVar == null) {
            Iterator<String> it5 = this.f73771q.keySet().iterator();
            while (it5.hasNext()) {
                cVar = this.f73771q.get(it5.next());
            }
            if (cVar != null) {
                this.f73773s = cVar;
            } else {
                this.f73773s = this.f73772r;
            }
        } else if (cVar.f73794k && !this.f73773s.f73794k) {
            this.f73773s = cVar;
        } else {
            c cVar4 = this.f73773s;
            if (cVar4.f73791h == 0 && TextUtils.isEmpty(cVar4.f73788e)) {
                this.f73773s = cVar;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("AVNotifyCenter", 2, "checkAndUpdateActive, from[" + str + "], data[" + cVar + "], last[" + cVar2 + "], active[" + this.f73773s + "]");
        }
    }

    private void l0() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
        if (sharedPreferences != null) {
            this.f73761g = sharedPreferences.getBoolean("group_video_push_cfg_txt." + this.f73755a.getAccount() + ".mutex", true);
        }
    }

    public int A(String str) {
        Integer num = this.f73769o.get(str);
        if (num == null) {
            return 2;
        }
        return num.intValue();
    }

    @TargetApi(11)
    public void A0(long j3, boolean z16, int i3) {
        String valueOf = String.valueOf(j3);
        Set<String> hashSet = new HashSet<>();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f73755a.getApp());
        String str = "ADD_FRIEND_DIALOG" + this.f73755a.getCurrentAccountUin();
        if (defaultSharedPreferences.contains(str)) {
            hashSet = defaultSharedPreferences.getStringSet(str, hashSet);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AVNotifyCenter", 2, "setAddFriendNotifyMaps-->uin=" + j3 + " bNotify=" + z16 + " srcId=" + i3 + " size=" + hashSet.size() + " info=" + hashSet.toString());
        }
        if (hashSet.size() >= 3 || hashSet.contains(valueOf)) {
            return;
        }
        if (this.f73774t.containsKey(Long.valueOf(j3))) {
            this.f73774t.remove(Long.valueOf(j3));
        }
        if (!z16) {
            hashSet.add(valueOf);
            defaultSharedPreferences.edit().putStringSet(str, hashSet).commit();
        } else {
            b bVar = new b();
            bVar.f73783b = i3;
            bVar.f73782a = j3;
            this.f73774t.put(Long.valueOf(j3), bVar);
        }
    }

    void B(ArrayList<Long> arrayList) {
        NewIntent newIntent = new NewIntent(this.f73755a.getApplication(), r.class);
        newIntent.putExtra("reqType", 15);
        newIntent.putExtra("tinyid_list", arrayList);
        try {
            this.f73755a.startServlet(newIntent);
        } catch (Exception unused) {
            QLog.e("AVNotifyCenter", 2, "getOpenIdFromTinyId --> StartServlet Error");
        }
    }

    public void B0(int i3, long j3, int i16) {
        long d16 = com.tencent.av.utils.e.d();
        if (com.tencent.av.utils.e.k()) {
            QLog.w("AVNotifyCenter", 1, "setAvtype[" + i3 + "], groupid[" + j3 + "], type[" + i16 + "], seq[" + d16 + "]");
        }
        if (i16 == 0) {
            this.f73755a.getAVNotifyCenter().Y0(d16, false);
        }
        this.f73758d.put(Long.valueOf(j3), Integer.valueOf(i16));
    }

    public int C(String str) {
        synchronized (this.D) {
            if (this.D.containsKey(str)) {
                f fVar = this.D.get(str);
                QLog.d("AVNotifyCenter", 1, "getOtherTermianlAvChatingType roomInfo.mSessionType=" + fVar.f73801b + ", peerUin=" + str);
                return fVar.f73801b;
            }
            return 0;
        }
    }

    public void C0(boolean z16) {
        I = z16;
    }

    public long D(String str) {
        synchronized (this.D) {
            if (this.D.containsKey(str)) {
                return this.D.get(str).f73800a;
            }
            return 0L;
        }
    }

    public void D0(int i3, Long l3, boolean z16) {
        if (com.tencent.av.utils.e.k()) {
            QLog.w("AVNotifyCenter", 1, "setChating, relationType[" + i3 + "], relationId[" + l3 + "], isChating[" + z16 + "], mActiveChatData[" + this.f73773s + "]");
        }
        String valueOf = String.valueOf(l3);
        if (z16) {
            c m3 = m(valueOf, true);
            if (m3 == null) {
                if (com.tencent.av.utils.e.k()) {
                    QLog.w("AVNotifyCenter", 1, "setChating, data is null");
                    return;
                }
                return;
            }
            m3.f73785b = false;
            m3.f73791h = l3.longValue();
            m3.f73792i = i3;
            if (i3 == 1) {
                m3.f73787d = 1;
            } else if (i3 == 2) {
                m3.f73787d = 3000;
            } else if (i3 == 3) {
                m3.f73787d = 0;
            } else if (i3 == 12) {
                m3.f73787d = 0;
            }
            m3.f73794k = z16;
            if (z16 && this.f73773s != m3) {
                f("setChating.1", m3);
            }
            if (com.tencent.av.utils.e.k()) {
                QLog.w("AVNotifyCenter", 1, "setChating, end, data[" + m3 + "], mActiveChatData[" + this.f73773s + "]");
            }
        }
    }

    public String E(long j3) {
        synchronized (this.D) {
            for (String str : this.D.keySet()) {
                if (this.D.get(str).f73800a == j3) {
                    return str;
                }
            }
            return "";
        }
    }

    public void E0(int i3, String str, String str2, boolean z16) {
        c m3 = m(str, false);
        if (m3 != null) {
            m3.f73785b = true;
            m3.f73787d = i3;
            m3.f73788e = str;
            m3.f73789f = str2;
            m3.f73790g = z16;
            m3.f73792i = 0;
            m3.f73791h = AVUtil.q(str);
        }
        QLog.w("AVNotifyCenter", 1, "setChating, uinType[" + i3 + "], peerUin[" + str + "], extraUin[" + str2 + "], isReceiver[" + z16 + "], AvChatData[" + m3 + "], mActiveChatData[" + this.f73773s + "]");
    }

    public String F() {
        return this.f73773s.f73788e;
    }

    public void F0(long j3) {
        this.F = j3;
    }

    String G(String str) {
        String str2;
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f73755a.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService == null) {
            if (QLog.isColorLevel()) {
                QLog.e("AVNotifyCenter", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
            }
            return null;
        }
        PhoneContact queryPhoneContactByMobile = iPhoneContactService.queryPhoneContactByMobile(str);
        if (queryPhoneContactByMobile != null && (str2 = queryPhoneContactByMobile.name) != null) {
            return str2;
        }
        if (QLog.isColorLevel()) {
            QLog.e("AVNotifyCenter", 2, "getPhoneNameByPhoneNum --> can not get phoneContact Or Name");
        }
        return null;
    }

    public void G0(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AVNotifyCenter", 2, "setDoubleVideoMeetingFlag-->isDoubleVideoMeeting = " + z16);
        }
        c m3 = m(str, false);
        if (m3 != null) {
            m3.f73795l = z16;
        }
    }

    public int H() {
        return this.f73777w;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        if (r4 != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void H0(long j3, int i3, int i16) {
        i iVar;
        boolean z16;
        String str = this.f73768n.get(Long.valueOf(j3));
        String str2 = "0;0";
        if (str == null) {
            str = "0;0";
        }
        if (i16 > 0) {
            if (i3 == 2) {
                iVar = Q(j3, 10);
            } else if (i3 == 10) {
                iVar = Q(j3, 2);
            } else {
                iVar = null;
                z16 = false;
                if (iVar == null) {
                    if (iVar.f73809c > 0) {
                        str = "1;" + (iVar.f73809c + i16);
                        str2 = str;
                    }
                }
            }
            z16 = true;
            if (iVar == null) {
            }
        }
        this.f73768n.put(String.valueOf(j3), str2);
        if (com.tencent.av.utils.e.k()) {
            QLog.w("AVNotifyCenter", 1, "setMultiBarFlagInfo, groupId[" + j3 + "], avtype[" + i3 + "], memberNum[" + i16 + "], old[" + str2 + "], new[" + str2 + "]");
        }
    }

    public String I() {
        return this.f73778x;
    }

    public void I0(int i3, int i16, long j3, long[] jArr, long j16) {
        QLog.w("AVNotifyCenter", 1, "setMultiRoomMember[" + i3 + "], relationType[" + i16 + "], relationId[" + j3 + "], memberList[" + Arrays.toString(jArr) + "], roomUserNum[" + j16 + "]");
        int i17 = 0;
        if (i16 == 2) {
            if (this.f73765k.containsKey(Long.valueOf(j3))) {
                this.f73765k.remove(Long.valueOf(j3));
            }
            if (j16 != 0 && jArr != null) {
                Vector<h> vector = new Vector<>();
                int length = jArr.length;
                while (i17 < length) {
                    h hVar = new h();
                    hVar.f73805a = jArr[i17];
                    vector.add(hVar);
                    i17++;
                }
                e eVar = new e();
                eVar.f73797a = j16;
                eVar.f73798b = vector;
                this.f73765k.put(Long.valueOf(j3), eVar);
                return;
            }
            return;
        }
        if (i16 == 1) {
            if (this.f73766l.containsKey(Long.valueOf(j3))) {
                this.f73766l.remove(Long.valueOf(j3));
            }
            if (j16 == 0) {
                return;
            }
            e eVar2 = new e();
            eVar2.f73797a = j16;
            eVar2.f73798b = null;
            if (jArr != null) {
                Vector<h> vector2 = new Vector<>();
                while (i17 < jArr.length) {
                    h hVar2 = new h();
                    hVar2.f73805a = jArr[i17];
                    vector2.add(hVar2);
                    i17++;
                }
                eVar2.f73798b = vector2;
            }
            this.f73766l.put(Long.valueOf(j3), eVar2);
        }
    }

    public int J() {
        return this.f73776v;
    }

    public void J0(int i3, long j3, long[] jArr) {
        ConcurrentHashMap<Long, e> concurrentHashMap;
        if (i3 == 2) {
            concurrentHashMap = this.f73765k;
        } else if (i3 == 1) {
            concurrentHashMap = this.f73766l;
        } else {
            return;
        }
        if (com.tencent.av.utils.e.k()) {
            QLog.w("AVNotifyCenter", 1, "setMultiRoomMember, relationType[" + i3 + "], relationId[" + j3 + "], roomInfos[" + concurrentHashMap.size() + "], memberList[" + jArr.length + "]");
        }
        if (concurrentHashMap.containsKey(Long.valueOf(j3))) {
            concurrentHashMap.remove(Long.valueOf(j3));
        }
        Vector<h> vector = new Vector<>();
        int i16 = 0;
        for (long j16 : jArr) {
            h hVar = new h();
            hVar.f73805a = j16;
            vector.add(hVar);
            i16++;
        }
        e eVar = new e();
        eVar.f73797a = i16;
        eVar.f73798b = vector;
        concurrentHashMap.put(Long.valueOf(j3), eVar);
    }

    public long K() {
        return this.f73770p;
    }

    public void K0(int i3, long j3, long[] jArr, int[] iArr, long j16) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setMultiRoomMember, relationId[");
            sb5.append(j3);
            sb5.append("], relationType[");
            sb5.append(i3);
            sb5.append("], states[");
            sb5.append(iArr);
            sb5.append("], roomUserNum[");
            sb5.append(j16);
            sb5.append("], memberList[");
            if (jArr != null) {
                z18 = true;
            } else {
                z18 = false;
            }
            sb5.append(z18);
            sb5.append("]");
            QLog.w("AVNotifyCenter", 1, sb5.toString());
        }
        if (i3 == 2) {
            if (this.f73765k.containsKey(Long.valueOf(j3))) {
                this.f73765k.remove(Long.valueOf(j3));
            }
            if (j16 != 0 && jArr != null && iArr != null && jArr.length == iArr.length) {
                Vector<h> vector = new Vector<>();
                int length = jArr.length;
                ArrayList<Long> arrayList = new ArrayList<>();
                for (int i16 = 0; i16 < length; i16++) {
                    h hVar = new h();
                    long j17 = jArr[i16];
                    hVar.f73805a = j17;
                    if (iArr[i16] == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    hVar.f73806b = z17;
                    if (z17 && !this.f73767m.containsKey(Long.valueOf(j17))) {
                        arrayList.add(Long.valueOf(hVar.f73805a));
                    }
                    vector.add(hVar);
                }
                B(arrayList);
                e eVar = new e();
                eVar.f73797a = j16;
                eVar.f73798b = vector;
                this.f73765k.put(Long.valueOf(j3), eVar);
                return;
            }
            return;
        }
        if (i3 == 1) {
            if (this.f73766l.containsKey(Long.valueOf(j3))) {
                this.f73766l.remove(Long.valueOf(j3));
            }
            if (j16 == 0) {
                return;
            }
            Vector<h> vector2 = new Vector<>();
            if (jArr != null) {
                int length2 = jArr.length;
                for (int i17 = 0; i17 < length2; i17++) {
                    h hVar2 = new h();
                    hVar2.f73805a = jArr[i17];
                    if (iArr[i17] == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    hVar2.f73806b = z16;
                    vector2.add(hVar2);
                }
            }
            e eVar2 = new e();
            eVar2.f73797a = j16;
            eVar2.f73798b = vector2;
            this.f73766l.put(Long.valueOf(j3), eVar2);
        }
    }

    public int L() {
        return this.f73773s.f73786c;
    }

    public void L0(boolean z16) {
        this.f73764j = z16;
    }

    public int M(String str) {
        c m3 = m(str, false);
        if (m3 == null) {
            return 0;
        }
        return m3.f73786c;
    }

    public void M0(boolean z16) {
        MqqHandler mqqHandler;
        MqqHandler mqqHandler2;
        if (QLog.isColorLevel() || this.f73757c != z16) {
            QLog.wAsync("AVNotifyCenter", 1, "setNetworkState, mNetworkDown[" + this.f73757c + "->" + z16 + "]");
        }
        if (this.f73757c != z16 && !z16 && (mqqHandler2 = this.f73760f) != null) {
            mqqHandler2.removeCallbacks(this.C);
            this.f73760f.postDelayed(this.C, 5000L);
        }
        if (z16 && (mqqHandler = this.f73760f) != null) {
            mqqHandler.removeCallbacks(this.C);
        }
        this.f73757c = z16;
    }

    public int N() {
        return this.H;
    }

    public void N0(String str, int i3) {
        this.f73769o.put(str, Integer.valueOf(i3));
    }

    public boolean O(long j3) {
        Boolean bool = (Boolean) this.f73759e.get(Long.valueOf(j3));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void O0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.iAsync("AVNotifyCenter", 2, "setNotifyUpdateTime-->bNotify" + z16);
        }
        this.G = z16;
    }

    public int P() {
        int i3 = this.f73773s.f73787d;
        if (i3 == 21) {
            return 1011;
        }
        return i3;
    }

    public void P0(ArrayList<AVPhoneUserInfo> arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator<AVPhoneUserInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            AVPhoneUserInfo next = it.next();
            long j3 = next.account;
            if (!this.f73767m.containsKey(Long.valueOf(j3))) {
                this.f73767m.put(Long.valueOf(j3), next);
            }
        }
    }

    public i Q(long j3, int i3) {
        return this.f73780z.get(String.valueOf(j3) + String.valueOf(i3));
    }

    public void Q0(String str, String str2, String str3) {
        if (this.f73775u == null) {
            this.f73775u = new ArrayList<>();
        }
        this.f73775u.add(new g(str, str2, str3));
    }

    public boolean R(int i3, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("AVNotifyCenter", 2, "hasMultiVideo --> RelationType = " + i3 + " ,RelationId = " + j3);
        }
        if (i3 == 2) {
            if (this.f73765k.size() != 0 && this.f73765k.containsKey(Long.valueOf(j3))) {
                return true;
            }
            return false;
        }
        if (i3 == 1) {
            if (this.f73766l.size() != 0 && this.f73766l.containsKey(Long.valueOf(j3))) {
                return true;
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("AVNotifyCenter", 2, "hasMultiVideo --> RelationType is Wrong");
        }
        return false;
    }

    public void R0(int i3, int i16) {
        ArrayList<g> arrayList;
        this.f73776v = i3;
        this.f73777w = i16;
        if (i3 == 0 && (arrayList = this.f73775u) != null) {
            arrayList.clear();
            this.f73775u = null;
        }
    }

    public boolean S(long j3) {
        i Q;
        i Q2;
        int l3 = this.f73755a.getAVNotifyCenter().l(j3);
        boolean z16 = true;
        if (l3 != 2 && (l3 != 0 || (Q2 = this.f73755a.getAVNotifyCenter().Q(j3, 2)) == null || Q2.f73809c <= 0)) {
            z16 = false;
        }
        if (z16 && (Q = this.f73755a.getAVNotifyCenter().Q(j3, 10)) != null && Q.f73809c > 0) {
            return false;
        }
        return z16;
    }

    public void S0(int i3, int i16, long j3, int i17) {
        T0(i3, i16, String.valueOf(j3), i17, false);
    }

    public boolean T() {
        if (o() == 12 && U()) {
            return true;
        }
        return false;
    }

    public boolean U() {
        c cVar = this.f73773s;
        if (cVar.f73786c == 0 || !cVar.f73794k) {
            return false;
        }
        return true;
    }

    public void U0(int i3, String str, int i16) {
        T0(i3, 0, str, i16, true);
    }

    public void V0(long j3, int i3) {
        QLog.w("SmallScreen", 1, "setSmallScreenState, smallScreenState[" + this.H + "->" + i3 + "], seq[" + j3 + "]");
        this.H = i3;
    }

    public boolean W(int i3, long j3) {
        return Y(com.tencent.av.utils.e.d(), String.valueOf(j3));
    }

    public void W0(long j3, int i3, int i16, boolean z16) {
        j jVar;
        j jVar2 = null;
        if (i3 == 2) {
            if (this.A.containsKey(Long.valueOf(j3))) {
                jVar2 = this.A.remove(Long.valueOf(j3));
            }
            jVar = new j();
            jVar.f73817a = j3;
            jVar.f73818b = z16;
            this.A.put(String.valueOf(j3), jVar);
        } else if (i3 == 1) {
            if (this.B.containsKey(Long.valueOf(j3))) {
                jVar2 = this.B.remove(Long.valueOf(j3));
            }
            j jVar3 = new j();
            jVar3.f73817a = j3;
            jVar3.f73818b = z16;
            jVar3.f73819c = i16;
            this.B.put(String.valueOf(j3), jVar3);
            jVar = jVar3;
        } else {
            jVar = null;
        }
        if (QLog.isColorLevel()) {
            QLog.w("AVNotifyCenter", 1, "setTipsRoomInfo, relationId[" + j3 + "], relationType[" + i3 + "], old[" + jVar2 + "], new[" + jVar + "]");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setTipsRoomInfo relationId:");
            sb5.append(j3);
            sb5.append("relationType:");
            sb5.append(i3);
            QLog.d("AVNotifyCenter", 2, sb5.toString());
        }
    }

    public boolean X(int i3, long j3, int i16) {
        c m3;
        if (i3 == 2) {
            return W(i3, j3);
        }
        int l3 = l(j3);
        if (l3 < 0 || (m3 = m(String.valueOf(j3), false)) == null || i16 != l3) {
            return false;
        }
        return m3.f73794k;
    }

    public void X0(long j3, boolean z16) {
        this.f73759e.put(Long.valueOf(j3), Boolean.valueOf(z16));
        if (!z16 && this.f73755a != null) {
            Intent intent = new Intent("tencent.video.q2v.close_invite_msg_box");
            intent.putExtra("groupId", j3);
            this.f73755a.getApp().sendBroadcast(intent);
        }
    }

    public boolean Y(long j3, String str) {
        c m3 = m(str, false);
        if (m3 == null) {
            return false;
        }
        return m3.f73794k;
    }

    public void Y0(long j3, boolean z16) {
        if (com.tencent.av.utils.e.k() || z16 != this.f73762h) {
            QLog.w("AVNotifyCenter", 1, "setVideoRequestStatus, isVideoRequest[" + this.f73762h + "->" + z16 + "], seq[" + j3 + "]");
        }
        this.f73762h = z16;
    }

    public boolean Z(String str) {
        boolean z16 = false;
        c m3 = m(str, false);
        if (m3 != null) {
            z16 = m3.f73795l;
        } else if (QLog.isColorLevel()) {
            QLog.e("AVNotifyCenter", 2, "isDoubleVideoMeeting --> can not get data from uin --> peerUin = " + str);
        }
        if (QLog.isColorLevel()) {
            QLog.e("AVNotifyCenter", 2, "isDoubleVideoMeeting --> isDoubleVideoMeeting = " + z16);
        }
        return z16;
    }

    public void Z0(int i3, long j3, int i16, int i17, int i18, int i19, int i26) {
        a1(i3, j3, i16, i17, i18, -1, i19, i26);
    }

    public boolean a0() {
        return ((IODQShadowLoadApi) QRoute.api(IODQShadowLoadApi.class)).isInTroophomeworkRoom();
    }

    public void a1(int i3, long j3, int i16, int i17, int i18, int i19, int i26, int i27) {
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(String.valueOf(j3));
        if (troopInfoFromCache != null && troopInfoFromCache.hadJoinTroop()) {
            i iVar = new i();
            iVar.f73808b = j3;
            iVar.f73810d = i16;
            iVar.f73815i = i26;
            iVar.f73812f = i17;
            iVar.f73813g = i18;
            iVar.f73811e = i19;
            iVar.f73809c = i27;
            iVar.f73816j = System.currentTimeMillis();
            String str = String.valueOf(j3) + String.valueOf(i16);
            i iVar2 = this.f73780z.get(str);
            this.f73780z.put(str, iVar);
            if (com.tencent.av.utils.e.k()) {
                QLog.w("AVNotifyCenter", 1, "setVideoRoomInfo[" + i3 + "], \nOld[" + iVar2 + "], \nNew[" + iVar + "]");
                return;
            }
            return;
        }
        y0(j3);
        if (QLog.isColorLevel()) {
            QLog.d("AVNotifyCenter", 2, "setVideoRoomInfo, but group is exited, groupid: " + j3);
        }
    }

    public boolean b0() {
        return this.f73761g;
    }

    public void b1(int i3, long j3, boolean z16, boolean z17) {
        c1(i3, String.valueOf(j3), z16, z17);
    }

    public boolean c0() {
        return this.f73764j;
    }

    public void c1(int i3, String str, boolean z16, boolean z17) {
        c m3 = m(str, false);
        QLog.w("AVNotifyCenter", 1, "setWaittingState, sessionId[" + str + "], relationType[" + i3 + "], IsWaitting[" + z16 + "], isReceiver[" + z17 + "], AvChatData[" + m3 + "]");
        if (m3 != null) {
            m3.f73793j = z16;
            if (z16) {
                if (z17) {
                    m3.f73794k = false;
                } else {
                    m3.f73794k = true;
                }
            } else {
                m3.f73794k = true;
            }
            if (m3.f73794k && m3 != this.f73773s) {
                f("setWaittingState", m3);
            }
            QLog.w("AVNotifyCenter", 1, "setWaittingState, end, AvChatData[" + m3 + "]");
        }
    }

    public boolean d0(String str) {
        synchronized (this.D) {
            if (this.D.containsKey(str)) {
                return true;
            }
            return false;
        }
    }

    public void d1(boolean z16) {
        Runnable runnable;
        MqqHandler mqqHandler;
        if (QLog.isColorLevel()) {
            QLog.d("AVNotifyCenter", 2, "startOrStopGAudioTimer start: " + z16);
        }
        if (z16) {
            if (!this.f73773s.f73794k) {
                this.F = 0L;
            }
            MqqHandler mqqHandler2 = this.f73760f;
            if (mqqHandler2 != null) {
                Runnable runnable2 = this.E;
                if (runnable2 == null) {
                    this.E = new UpdateChattingTime(this);
                } else {
                    mqqHandler2.removeCallbacks(runnable2);
                }
                this.f73760f.postDelayed(this.E, 2000L);
                return;
            }
            return;
        }
        if (!U() && (runnable = this.E) != null && (mqqHandler = this.f73760f) != null) {
            mqqHandler.removeCallbacks(runnable);
            this.E = null;
        }
    }

    public void e(String str, long j3, int i3) {
        synchronized (this.D) {
            QLog.d("AVNotifyCenter", 1, "addOtherTerminalAvChating peerUin = " + str + ",roomid = " + j3 + ",sessionType = " + i3);
            this.D.put(str, new f(j3, i3));
        }
    }

    public boolean e0() {
        PhoneStatusMonitor phoneStatusMonitor = this.f73763i;
        if (phoneStatusMonitor != null) {
            return phoneStatusMonitor.m();
        }
        return false;
    }

    public boolean f0() {
        return this.f73773s.f73790g;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(Context context, int i3, int i16, String str) {
        boolean Y;
        String str2;
        boolean z16;
        String format;
        if (context == null) {
            return false;
        }
        if (i16 == 1) {
            Y = Y(1L, str);
        } else if (i16 == 3000) {
            Y = Y(2L, str);
        } else {
            Y = Y(3L, str);
            if (!Y) {
                Y = Y(100L, str);
            }
        }
        if (!Y) {
            str2 = AVBizModuleFactory.getModuleByName(Constants.Business.QQ_RTC).checkAVFocus();
            if (!"true".equals(str2) && !TextUtils.equals(Constants.Business.QQ_CIRCLE_WINDOW, str2)) {
                z16 = true;
                if (z16) {
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
                    if (TextUtils.equals(Constants.Business.SYSTEM_PHONE, str2)) {
                        format = context.getString(R.string.dg9);
                    } else {
                        format = String.format(context.getString(R.string.z_k), str2);
                    }
                    QQToast.makeText(context, format, 1).show(dimensionPixelSize);
                    VideoUtil.l(this.f73756b, str, str2);
                    Intent intent = new Intent("action_av_block");
                    intent.putExtra("extra_block_business", str2);
                    try {
                        MobileQQ.sMobileQQ.sendBroadcast(intent);
                    } catch (Throwable th5) {
                        QLog.e("AVNotifyCenter", 1, "checkBlockAVChat, send block broascast exception=", th5);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("AVNotifyCenter", 2, "checkBlockAVChat, avEnterType[" + i3 + "], uinType[" + i16 + "], uin[" + str + "], isChatting[" + Y + "], block[" + z16 + "]");
                }
                return z16;
            }
        } else {
            str2 = "";
        }
        z16 = false;
        if (z16) {
        }
        if (QLog.isColorLevel()) {
        }
        return z16;
    }

    boolean g0() {
        return true;
    }

    public boolean h(Context context, int i3, String str, boolean z16) {
        int i16;
        int i17;
        int i18;
        boolean z17 = false;
        if (context == null) {
            return false;
        }
        int uinType2AVRelationType = ba.uinType2AVRelationType(i3);
        try {
            long parseLong = Long.parseLong(str);
            if (W(uinType2AVRelationType, parseLong)) {
                i16 = 0;
            } else {
                i16 = -1;
            }
            i Q = Q(parseLong, 10);
            if (Q != null && Q.f73809c > 0) {
                i16 = 0;
            }
            if (i16 < 0) {
                i Q2 = Q(parseLong, 2);
                if (Q2 == null) {
                    Q2 = Q(parseLong, 12);
                }
                if (Q2 != null && Q2.f73809c > 0) {
                    i16 = 2;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("AVNotifyCenter", 2, "checkBlockTroopAVChat, relationType[" + uinType2AVRelationType + "], relationId[" + parseLong + "], ret[" + i16 + "]");
            }
            if (i16 > 0) {
                z17 = true;
            }
            if (z17) {
                int i19 = R.string.w3_;
                if (i16 == 1) {
                    QQAppInterface qQAppInterface = this.f73755a;
                    if (z16) {
                        i18 = 4;
                    } else {
                        i18 = 3;
                    }
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X800AB81", "0X800AB81", i18, 0, "", "", "", "");
                } else if (i16 == 2) {
                    QQAppInterface qQAppInterface2 = this.f73755a;
                    if (z16) {
                        i17 = 4;
                    } else {
                        i17 = 3;
                    }
                    ReportController.o(qQAppInterface2, "CliOper", "", "", "0X800AB83", "0X800AB83", i17, 0, "", "", "", "");
                    i19 = R.string.w3b;
                }
                QQToast.makeText(context, i19, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
            return z17;
        } catch (NumberFormatException unused) {
            QLog.e("AVNotifyCenter", 2, "checkBlockTroopAVChat NumberFormatException uin: " + str);
            return true;
        }
    }

    public boolean h0() {
        if (this.E != null) {
            return true;
        }
        return false;
    }

    public boolean i(Context context, String str) {
        long j3;
        int i3;
        if (context == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            j3 = com.tencent.mobileqq.qcall.g.c(str);
        } else {
            j3 = 0;
        }
        if (!U() && !this.f73755a.isVideoChatting()) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        if (i3 < 0 && j3 != 0) {
            i Q = Q(j3, 2);
            if (Q == null) {
                Q = Q(j3, 12);
            }
            if (Q != null && Q.f73809c > 0) {
                i3 = 0;
            } else {
                i Q2 = Q(j3, 10);
                if (Q2 != null && Q2.f73809c > 0) {
                    i3 = 2;
                }
            }
        }
        if (i3 == 1) {
            QQToast.makeText(context, R.string.dkm, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            ReportController.o(this.f73755a, "CliOper", "", "", "0X800AB80", "0X800AB80", 0, 0, "", "", "", "");
        } else if (i3 == 2) {
            QQToast.makeText(context, R.string.w3a, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            ReportController.o(this.f73755a, "CliOper", "", "", "0X800AB82", "0X800AB82", 0, 0, "", "", "", "");
        } else if (i3 == 3) {
            QQToast.makeText(context, R.string.f170541zc4, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        if (QLog.isColorLevel()) {
            QLog.i("AVNotifyCenter", 2, "checkForTroopVideo, ret[" + i3 + "], groupId[" + str + "]");
        }
        if (i3 <= 0) {
            return false;
        }
        return true;
    }

    public boolean i0(String str) {
        String str2 = this.f73768n.get(str);
        if (str2 == null) {
            return false;
        }
        return str2.split(";")[0].equals("1");
    }

    void j() {
        QLog.d("AVNotifyCenter", 1, "clearMultiRoomInfos, AvChatData[" + this.f73773s + "]");
        c cVar = this.f73773s;
        cVar.f73792i = 0;
        cVar.f73791h = 0L;
        cVar.f73794k = false;
        this.f73765k.clear();
        this.f73773s = this.f73772r;
    }

    public boolean j0() {
        return this.f73762h;
    }

    public boolean k(String str, String str2, int i3, int i16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (str2.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                    str2 = str2.substring(1);
                }
                if (this.f73771q.containsKey(str2) && !TextUtils.isEmpty(this.f73771q.get(str2).f73788e) && this.f73771q.get(str2).f73788e.equals(str2) && U()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AVNotifyCenter", 2, "Do not report qua, because this chatting is active!");
                    }
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.i("AVNotifyCenter", 2, "start do qua report : peer uin = " + str2 + " , timestamp = " + currentTimeMillis);
                }
                SharedPreferences h16 = vu.a.h(q.f74192c, 4);
                Map<String, ?> all = h16.getAll();
                SharedPreferences.Editor edit = h16.edit();
                if (all.size() > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AVNotifyCenter", 2, "Qua report map contains report buffer, move to exception map : size = " + all.size());
                    }
                    SharedPreferences.Editor edit2 = vu.a.h(q.f74193d, 4).edit();
                    for (String str3 : all.keySet()) {
                        edit2.putString(str3, (String) all.get(str3));
                    }
                    edit2.commit();
                    edit.clear().commit();
                }
                QuaReportInfo quaReportInfo = new QuaReportInfo();
                quaReportInfo.uintype = i16;
                quaReportInfo.busytype = i3;
                quaReportInfo.peerUin = str2;
                quaReportInfo.selfUin = str;
                edit.putString(String.valueOf(System.currentTimeMillis()), quaReportInfo.toString());
                edit.commit();
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AVNotifyCenter", 2, "do qua report error : " + e16);
                }
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("AVNotifyCenter", 2, "do qua report error : selfuin = " + str + " , peeruin =" + str2);
        }
        return false;
    }

    public boolean k0() {
        return this.f73773s.f73793j;
    }

    public int l(long j3) {
        Integer num = (Integer) this.f73758d.get(Long.valueOf(j3));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public synchronized c m(String str, boolean z16) {
        c cVar;
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "0")) {
            if (this.f73771q.containsKey(str)) {
                return this.f73771q.get(str);
            }
            if (z16) {
                long d16 = com.tencent.av.utils.e.d();
                cVar = new c("normal", d16);
                this.f73771q.put(str, cVar);
                f("getChatSession", cVar);
                QLog.w("AVNotifyCenter", 1, "getChatSession, create sessionId[" + str + "], mAvChatDataMap[" + this.f73771q.size() + "], data[" + cVar + "], mActiveChatData[" + this.f73773s + "], seq[" + d16 + "]");
                return cVar;
            }
            cVar = null;
            return cVar;
        }
        QLog.i("AVNotifyCenter", 1, "getChatSession, illegal session id with zero.");
        cVar = null;
        return cVar;
    }

    public synchronized void m0(int i3, int i16, long j3, long j16) {
        setChanged();
        notifyObservers(new Object[]{Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16)});
        if (i3 == 21) {
            v0(String.valueOf(j3), ba.avRelationType2UinType(i16));
        }
    }

    public long n() {
        return this.f73773s.f73791h;
    }

    public synchronized void n0(int i3, int i16, long j3, long j16, int i17) {
        setChanged();
        notifyObservers(new Object[]{Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i17)});
    }

    public int o() {
        return this.f73773s.f73792i;
    }

    public synchronized void o0(int i3, int i16, long j3, long j16, String str) {
        setChanged();
        notifyObservers(new Object[]{Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), str});
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0095, code lost:
    
        if (r2.f73809c > 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x007e, code lost:
    
        if (r6 == 10) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i p(long j3) {
        String str = String.valueOf(j3) + String.valueOf(2);
        String str2 = String.valueOf(j3) + String.valueOf(10);
        i iVar = this.f73780z.get(str);
        i iVar2 = this.f73780z.get(str2);
        i iVar3 = this.f73780z.get(String.valueOf(j3) + String.valueOf(12));
        int l3 = l(j3);
        if (l3 != 0 && this.f73755a.getAVNotifyCenter().W(1, j3)) {
            if (l3 != 12) {
                iVar3 = null;
            }
            if (l3 != 2) {
                iVar = iVar3;
            }
        } else {
            if (iVar3 == null || iVar3.f73809c <= 0) {
                iVar3 = null;
            }
            if (iVar == null || iVar.f73809c <= 0) {
                iVar = iVar3;
            }
            if (iVar2 != null) {
            }
            iVar2 = iVar;
        }
        if (com.tencent.av.utils.e.k()) {
            QLog.iAsync("AVNotifyCenter", 1, "getChoosedRoom, groupid[" + j3 + "], avtype[" + l3 + "], VideoRoomInfo[" + iVar2 + "]");
        }
        return iVar2;
    }

    public synchronized void p0(int i3, int i16, String str, String str2) {
        setChanged();
        notifyObservers(new Object[]{Integer.valueOf(i3), Integer.valueOf(i16), str, str2});
        if (i3 == 28) {
            v0(str, i16);
            if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, str)) {
                v0(str2, i16);
            }
        }
    }

    public String q() {
        return ba.formatTime(this.F);
    }

    public synchronized void q0(String str) {
        setChanged();
        notifyObservers(new Object[]{800, str});
    }

    public String r() {
        return this.f73773s.f73789f;
    }

    public void r0() {
        PhoneStatusMonitor phoneStatusMonitor = this.f73763i;
        if (phoneStatusMonitor != null) {
            phoneStatusMonitor.n();
            this.f73763i = null;
        }
    }

    public Vector<h> s(long j3) {
        e eVar;
        Vector<h> vector;
        ConcurrentHashMap<Long, e> concurrentHashMap = this.f73766l;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Long.valueOf(j3)) && (eVar = this.f73766l.get(Long.valueOf(j3))) != null && (vector = eVar.f73798b) != null) {
            return vector;
        }
        return null;
    }

    public void s0(int i3, long j3) {
        ConcurrentHashMap<Long, e> concurrentHashMap;
        String str;
        if (this.f73755a == null) {
            return;
        }
        String str2 = "onSelfEnterRoom, relationType[" + i3 + "], relationId[" + j3;
        if (i3 == 2) {
            concurrentHashMap = this.f73765k;
        } else if (i3 == 1) {
            concurrentHashMap = this.f73766l;
        } else {
            return;
        }
        long longValue = Long.valueOf(this.f73755a.getCurrentAccountUin()).longValue();
        e eVar = concurrentHashMap.get(Long.valueOf(j3));
        if (eVar != null) {
            String str3 = str2 + "], containsKey[true";
            Vector<h> vector = eVar.f73798b;
            boolean z16 = false;
            z16 = false;
            if (vector != null && vector.size() > 0) {
                int size = vector.size();
                boolean z17 = false;
                for (int i16 = 0; i16 < size; i16++) {
                    if (longValue == vector.elementAt(i16).f73805a) {
                        z17 = true;
                    }
                }
                z16 = z17;
            }
            str = str3 + "], exist[" + z16 + "], last[" + eVar;
            if (vector != null && !z16) {
                h hVar = new h();
                hVar.f73805a = longValue;
                vector.add(hVar);
                eVar.f73797a++;
                str = str + "], cur[" + eVar;
            }
        } else {
            Vector<h> vector2 = new Vector<>();
            h hVar2 = new h();
            hVar2.f73805a = longValue;
            vector2.add(hVar2);
            e eVar2 = new e();
            eVar2.f73797a = 1L;
            eVar2.f73798b = vector2;
            concurrentHashMap.put(Long.valueOf(j3), eVar2);
            str = (str2 + "], containsKey[false") + "], cur[" + eVar2;
        }
        this.f73770p = System.currentTimeMillis();
        QLog.w("AVNotifyCenter", 1, str + "], timeRoomCreateTime[" + this.f73770p + "]");
    }

    public String t() {
        return this.f73779y;
    }

    public void t0(int i3, long j3, int i16) {
        ConcurrentHashMap<Long, e> concurrentHashMap;
        if (this.f73755a == null) {
            return;
        }
        String str = "onSelfLeaveRoom, relationId[" + j3 + "], relationType[" + i3 + "], avtype[" + i16;
        if (i3 == 2) {
            concurrentHashMap = this.f73765k;
        } else if (i3 == 1) {
            concurrentHashMap = this.f73766l;
        } else {
            return;
        }
        long longValue = Long.valueOf(this.f73755a.getCurrentAccountUin()).longValue();
        if (concurrentHashMap.containsKey(Long.valueOf(j3))) {
            e eVar = concurrentHashMap.get(Long.valueOf(j3));
            String str2 = (str + "], containsKey[true") + "], last[" + eVar;
            Vector<h> vector = eVar.f73798b;
            long j16 = eVar.f73797a - 1;
            eVar.f73797a = j16;
            if (j16 == 0) {
                concurrentHashMap.remove(Long.valueOf(j3));
                str = str2 + "], delete[true";
            } else {
                if (vector != null && vector.size() > 0) {
                    int size = vector.size();
                    int i17 = 0;
                    while (true) {
                        if (i17 >= size) {
                            break;
                        }
                        if (longValue == vector.elementAt(i17).f73805a) {
                            vector.remove(i17);
                            break;
                        }
                        i17++;
                    }
                }
                str = str2 + "], cur[" + eVar;
            }
        }
        QLog.w("AVNotifyCenter", 1, str + "]");
    }

    public long u() {
        return 0L;
    }

    public void u0(submsgtype0x126$MsgBody submsgtype0x126_msgbody) {
        String str;
        byte[] byteArray;
        String str2;
        QQAppInterface qQAppInterface = this.f73755a;
        if (submsgtype0x126_msgbody != null && qQAppInterface != null) {
            long j3 = submsgtype0x126_msgbody.uint64_msg_seq.get();
            int i3 = submsgtype0x126_msgbody.uint32_msg_type.get();
            QQServiceForAV qQServiceForAV = null;
            if (i3 == 2) {
                str = "avChatRoom";
                if (submsgtype0x126_msgbody.str_msg_info.has()) {
                    byteArray = submsgtype0x126_msgbody.str_msg_info.get().toByteArray();
                }
                byteArray = null;
            } else if (i3 == 4) {
                if (submsgtype0x126_msgbody.bytes_ext_info.has()) {
                    byteArray = submsgtype0x126_msgbody.bytes_ext_info.get().toByteArray();
                    str = null;
                }
                byteArray = null;
                str = null;
            } else if (i3 == 5) {
                str = "avScreenShareAsk";
                if (submsgtype0x126_msgbody.bytes_ext_info.has()) {
                    byteArray = submsgtype0x126_msgbody.str_msg_info.get().toByteArray();
                }
                byteArray = null;
            } else {
                if (i3 == 6) {
                    str = "avScreenShareAnswer";
                    if (submsgtype0x126_msgbody.bytes_ext_info.has()) {
                        byteArray = submsgtype0x126_msgbody.str_msg_info.get().toByteArray();
                    }
                    byteArray = null;
                }
                byteArray = null;
                str = null;
            }
            boolean z16 = false;
            if (byteArray != null && byteArray.length > 0) {
                WeakReference<QQServiceForAV> weakReference = qQAppInterface.mQQServiceRef;
                if (weakReference != null) {
                    qQServiceForAV = weakReference.get();
                }
                if (qQServiceForAV != null) {
                    z16 = qQServiceForAV.U(str, i3, byteArray);
                }
                if (!z16) {
                    Intent intent = new Intent("tencent.video.q2v.avReceivePushMsg");
                    intent.putExtra("msg_key", str);
                    intent.putExtra("msg_seq", j3);
                    intent.putExtra(QQHealthReportApiImpl.MSG_TYPE_KEY, i3);
                    intent.putExtra("msg_content", byteArray);
                    qQAppInterface.getApp().sendBroadcast(intent);
                    str2 = "useBroadcast";
                } else {
                    str2 = "useQQServiceForAV";
                }
            } else {
                str2 = "";
            }
            if (QLog.isColorLevel()) {
                QLog.i("AVNotifyCenter", 2, "processQavPush ret[" + z16 + "], tag[" + str2 + "]");
            }
        }
    }

    public int v() {
        return 0;
    }

    public void v0(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("AVNotifyCenter", 2, "refreshRecentList, uin[" + str + "], uinType[" + i3 + "]");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int l3 = com.tencent.nt.adapter.session.c.l(i3);
        if (l3 == 1) {
            str = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        }
        ((IChatsFreControlHelper) QRoute.api(IChatsFreControlHelper.class)).notifyRefreshSummary(str, l3);
    }

    public h w(int i3, long j3) {
        ConcurrentHashMap<Long, e> concurrentHashMap;
        Vector<h> vector;
        if (i3 == 2 && (concurrentHashMap = this.f73765k) != null && concurrentHashMap.containsKey(Long.valueOf(j3)) && (vector = this.f73765k.get(Long.valueOf(j3)).f73798b) != null && vector.size() > 0) {
            return vector.get(0);
        }
        return null;
    }

    public synchronized boolean w0(String str) {
        MqqHandler mqqHandler;
        boolean containsKey = this.f73771q.containsKey(str);
        if (com.tencent.av.utils.e.k()) {
            QLog.w("AVNotifyCenter", 1, "removeChatSession, sessionId[" + str + "], exist[" + containsKey + "], mAvChatDataMap[" + this.f73771q.size() + "]");
        }
        if (!containsKey) {
            return false;
        }
        this.f73771q.remove(str);
        c cVar = this.f73773s;
        f("removeChatSession", null);
        if (this.f73771q.isEmpty()) {
            this.F = 0L;
            Runnable runnable = this.E;
            if (runnable != null && (mqqHandler = this.f73760f) != null) {
                mqqHandler.removeCallbacks(runnable);
            }
        }
        if (com.tencent.av.utils.e.k()) {
            QLog.w("AVNotifyCenter", 1, "removeChatSession, end, sessionId[" + str + "], exist[" + containsKey + "], mAvChatDataMap[" + this.f73771q.size() + "], lastChatData[" + cVar + "], mActiveChatData[" + this.f73773s + "]");
        }
        return true;
    }

    public Vector<h> x(int i3, long j3) {
        ConcurrentHashMap<Long, e> concurrentHashMap;
        Vector<h> vector;
        if (i3 == 2 && (concurrentHashMap = this.f73765k) != null && concurrentHashMap.containsKey(Long.valueOf(j3)) && (vector = this.f73765k.get(Long.valueOf(j3)).f73798b) != null && vector.size() > 0) {
            return vector;
        }
        return null;
    }

    public void x0(String str) {
        QLog.d("AVNotifyCenter", 1, "removeOtherTerminalAvChating peerUin = " + str);
        synchronized (this.D) {
            if (this.D.containsKey(str)) {
                QLog.d("AVNotifyCenter", 1, "removeOtherTerminalAvChating remove true");
                this.D.remove(str);
            }
        }
    }

    public long y(int i3, long j3) {
        e eVar;
        if (i3 == 2) {
            if (this.f73765k.containsKey(Long.valueOf(j3))) {
                eVar = this.f73765k.get(Long.valueOf(j3));
            }
            eVar = null;
        } else {
            if (i3 == 1 && this.f73766l.containsKey(Long.valueOf(j3))) {
                eVar = this.f73766l.get(Long.valueOf(j3));
            }
            eVar = null;
        }
        if (eVar != null) {
            return eVar.f73797a;
        }
        return 0L;
    }

    public void y0(long j3) {
        String str = String.valueOf(j3) + 10;
        String str2 = String.valueOf(j3) + 2;
        Map<String, i> map = this.f73780z;
        if (map != null) {
            map.remove(str);
            this.f73780z.remove(str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AVNotifyCenter", 2, String.format("removeVideoRoomInfo, groupid: %s", Long.valueOf(j3)));
        }
    }

    public String z(long j3) {
        if (this.f73767m.containsKey(Long.valueOf(j3))) {
            String str = this.f73767m.get(Long.valueOf(j3)).telInfo.mobile;
            String G = G(str);
            if (G == null) {
                return ae.g(str, 4);
            }
            return G;
        }
        return null;
    }

    public void z0(QQAppInterface qQAppInterface, String str, int i3) {
        ea.c4(qQAppInterface.getApplication(), i3, qQAppInterface.getAccount());
        boolean z16 = false;
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit();
        edit.putString("group_video_push_cfg_txt." + qQAppInterface.getAccount(), str).commit();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("mav");
            if (jSONObject != null) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("relationType1");
                if (jSONObject2 != null) {
                    if (jSONObject2.getInt("mutex") != 0) {
                        z16 = true;
                    }
                    this.f73761g = z16;
                    edit.putBoolean("group_video_push_cfg_txt." + qQAppInterface.getAccount() + ".mutex", this.f73761g);
                }
                JSONObject jSONObject3 = jSONObject.getJSONObject("noiseCtrl");
                if (jSONObject3 != null) {
                    int i16 = jSONObject3.getInt("level");
                    int i17 = jSONObject3.getInt("sendDura");
                    int i18 = jSONObject3.getInt("validDura");
                    edit.putInt("group_video_push_cfg_txt." + qQAppInterface.getAccount() + ".level", i16);
                    edit.putInt("group_video_push_cfg_txt." + qQAppInterface.getAccount() + ".sendDura", i17);
                    edit.putInt("group_video_push_cfg_txt." + qQAppInterface.getAccount() + ".validDura", i18);
                }
                edit.commit();
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }
}
