package com.qzone.publish.ui.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.qzone.business.tianshu.model.QZoneBubbleInfo;
import com.qzone.business.tianshu.o;
import com.qzone.common.account.LoginData;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import u5.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneSyncBubbleController {

    /* renamed from: a, reason: collision with root package name */
    private Runnable f51885a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f51886b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private QZoneBubbleInfo f51887c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, Integer> f51888d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f51889e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f51890f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f51891g;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void a();

        void b(String str, String str2, String str3);
    }

    public QZoneSyncBubbleController() {
        this.f51888d = new HashMap<>();
        long uin = LoginData.getInstance().getUin();
        this.f51888d = c();
        this.f51889e = LocalMultiProcConfig.getBoolean4Uin(LocalMultiProcConfig.QZONE_MOOD_SYNC_QCIRCLE_SYNCED, false, uin);
    }

    private void b(final a aVar) {
        QZoneBubbleInfo qZoneBubbleInfo = this.f51887c;
        if (qZoneBubbleInfo == null || TextUtils.isEmpty(qZoneBubbleInfo.getWords()) || aVar == null) {
            return;
        }
        aVar.b(this.f51887c.getWords(), this.f51887c.getArrowUrl(), this.f51887c.getBackgroundUrl());
        Runnable runnable = new Runnable() { // from class: com.qzone.publish.ui.controller.QZoneSyncBubbleController.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    aVar.a();
                } catch (Throwable th5) {
                    QLog.e("QZoneSpringFestivalBubbleController", 1, "hideBubble error ", th5);
                }
            }
        };
        this.f51885a = runnable;
        this.f51886b.removeCallbacks(runnable);
        this.f51886b.postDelayed(this.f51885a, 6000L);
    }

    private void h() {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(586, 61, 1), false, false);
    }

    public void a(a aVar) {
        if (this.f51890f || !l()) {
            return;
        }
        this.f51890f = true;
        b(aVar);
    }

    public HashMap<String, Integer> c() {
        String string4Uin = LocalMultiProcConfig.getString4Uin(LocalMultiProcConfig.QZONE_MOOD_SYNC_QCIRCLE_BUBBLE_SHOWN_COUNT, "", LoginData.getInstance().getUin());
        if (TextUtils.isEmpty(string4Uin)) {
            return new HashMap<>();
        }
        byte[] decode = Base64.decode(string4Uin, 0);
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            hashMap = ParcelableWrapper.readHashMap(obtain, b.class.getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            return hashMap;
        } catch (Throwable th5) {
            QZLog.w(th5);
            return hashMap;
        }
    }

    public boolean d() {
        return this.f51891g;
    }

    public void e() {
        Integer num = this.f51888d.get(this.f51887c.getId());
        if (num == null) {
            num = 0;
        }
        Integer valueOf = Integer.valueOf(num.intValue() + 1);
        this.f51888d.put(this.f51887c.getId(), valueOf);
        i(this.f51888d);
        QLog.d("QZoneSpringFestivalBubbleController", 1, "doShowBubble: " + this.f51887c.getWords() + ", count: " + valueOf);
        h();
    }

    public void g() {
        Runnable runnable = this.f51885a;
        if (runnable != null) {
            this.f51886b.removeCallbacks(runnable);
        }
    }

    public void j(boolean z16) {
        this.f51891g = z16;
    }

    public void k() {
        Integer num;
        QZoneBubbleInfo qZoneBubbleInfo = this.f51887c;
        if (qZoneBubbleInfo == null || (num = this.f51888d.get(qZoneBubbleInfo.getId())) == null || num.intValue() <= 0 || this.f51889e) {
            return;
        }
        this.f51889e = true;
        LocalMultiProcConfig.putBoolean4Uin(LocalMultiProcConfig.QZONE_MOOD_SYNC_QCIRCLE_SYNCED, true, LoginData.getInstance().getUin());
    }

    public boolean l() {
        QZoneBubbleInfo j3 = o.i().j();
        this.f51887c = j3;
        if (j3 == null) {
            QLog.d("QZoneSpringFestivalBubbleController", 1, "mBubbleDataBean is null");
            return false;
        }
        Integer num = this.f51888d.get(j3.getId());
        if (num != null && num.intValue() > 0 && this.f51889e) {
            QLog.d("QZoneSpringFestivalBubbleController", 1, "have synced, don't show");
            return false;
        }
        if (!f(this.f51887c)) {
            QLog.d("QZoneSpringFestivalBubbleController", 1, "is not Valid Time");
            return false;
        }
        if (num != null && num.intValue() >= this.f51887c.getMaxTimes()) {
            QLog.d("QZoneSpringFestivalBubbleController", 1, "show count reach total limit, show count: " + this.f51888d + ", limit: " + this.f51887c.getMaxTimes());
            return false;
        }
        if (!TextUtils.isEmpty(this.f51887c.getWords())) {
            return true;
        }
        QLog.d("QZoneSpringFestivalBubbleController", 1, "text is empty");
        return false;
    }

    public void i(HashMap<String, Integer> hashMap) {
        if (hashMap == null || hashMap.size() == 0) {
            return;
        }
        HashMap hashMap2 = new HashMap(hashMap);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeMap(obtain, hashMap2);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.QZONE_MOOD_SYNC_QCIRCLE_BUBBLE_SHOWN_COUNT, Base64.encodeToString(marshall, 0), LoginData.getInstance().getUin());
    }

    public static boolean f(QZoneBubbleInfo qZoneBubbleInfo) {
        if (qZoneBubbleInfo == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return qZoneBubbleInfo.getStartTime() > 0 && currentTimeMillis >= qZoneBubbleInfo.getStartTime() * 1000 && qZoneBubbleInfo.getEndTime() > 0 && currentTimeMillis < qZoneBubbleInfo.getEndTime() * 1000;
    }
}
