package com.tencent.mobileqq.gamecenter.data;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class PadFaceManager {

    /* renamed from: l, reason: collision with root package name */
    public static final String f211970l = HardCodeUtil.qqStr(R.string.f172270oz0);

    /* renamed from: m, reason: collision with root package name */
    private static final Comparator<PadFaceAd> f211971m = new a();

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f211972a;

    /* renamed from: b, reason: collision with root package name */
    private EntityManager f211973b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f211974c;

    /* renamed from: d, reason: collision with root package name */
    private int f211975d;

    /* renamed from: e, reason: collision with root package name */
    private long f211976e;

    /* renamed from: g, reason: collision with root package name */
    private long f211978g;

    /* renamed from: h, reason: collision with root package name */
    private long f211979h;

    /* renamed from: i, reason: collision with root package name */
    private SharedPreferences f211980i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f211981j;

    /* renamed from: f, reason: collision with root package name */
    private List<PadFaceAd> f211977f = new ArrayList(4);

    /* renamed from: k, reason: collision with root package name */
    private SparseIntArray f211982k = new SparseIntArray();

    /* loaded from: classes12.dex */
    class a implements Comparator<PadFaceAd> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PadFaceAd padFaceAd, PadFaceAd padFaceAd2) {
            long j3 = padFaceAd.startTime;
            long j16 = padFaceAd2.startTime;
            if (j3 < j16) {
                return -1;
            }
            if (j3 == j16) {
                return 0;
            }
            return 1;
        }
    }

    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f211983a;

        /* renamed from: b, reason: collision with root package name */
        public long f211984b;

        /* renamed from: c, reason: collision with root package name */
        public String f211985c;
    }

    public PadFaceManager(AppInterface appInterface) {
        this.f211972a = appInterface;
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.data.PadFaceManager.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                synchronized (PadFaceManager.this) {
                    PadFaceManager padFaceManager = PadFaceManager.this;
                    padFaceManager.f211980i = padFaceManager.f211972a.getApp().getSharedPreferences("gamecenter_sp" + PadFaceManager.this.f211972a.getCurrentAccountUin(), 4);
                    PadFaceManager padFaceManager2 = PadFaceManager.this;
                    padFaceManager2.f211979h = padFaceManager2.f211980i.getLong("last_pad_face_request_time", 0L);
                    PadFaceManager padFaceManager3 = PadFaceManager.this;
                    if (padFaceManager3.f211980i.getInt("pad_face_ad_enabled", 1) == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    padFaceManager3.f211974c = z16;
                    PadFaceManager padFaceManager4 = PadFaceManager.this;
                    padFaceManager4.f211975d = padFaceManager4.f211980i.getInt("last_id_pad_face_shown", 0);
                    PadFaceManager padFaceManager5 = PadFaceManager.this;
                    padFaceManager5.f211976e = padFaceManager5.f211980i.getLong("last_time_pad_face_shown", 0L);
                    PadFaceManager.this.f211978g = r1.f211980i.getInt("request_interval", 2) * 3600000;
                    PadFaceManager padFaceManager6 = PadFaceManager.this;
                    padFaceManager6.f211973b = padFaceManager6.f211972a.getEntityManagerFactory().createEntityManager();
                    PadFaceManager.this.r();
                    PadFaceManager.this.f211981j = true;
                }
            }
        });
    }

    public static b m(AppInterface appInterface) {
        SharedPreferences sharedPreferences = appInterface.getApp().getSharedPreferences("gamecenter_sp" + appInterface.getCurrentAccountUin(), 4);
        b bVar = new b();
        bVar.f211984b = sharedPreferences.getLong("pwa_version", 0L);
        bVar.f211983a = sharedPreferences.getLong("last_pwa_version", 0L);
        bVar.f211985c = sharedPreferences.getString("pwa_url", "");
        return bVar;
    }

    public static int n(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        if (appInfo == null) {
            return 0;
        }
        if (appInfo.iNewFlag.get() == 0 && !z16) {
            return 0;
        }
        String str = appInfo.buffer.get();
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String optString = new JSONObject(str).optString("_show_mission");
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            return Integer.parseInt(optString);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static PadFaceAd p(Intent intent) {
        PadFaceAd padFaceAd = (PadFaceAd) intent.getParcelableExtra("pad_face_ad");
        if (padFaceAd != null) {
            intent.removeExtra("pad_face_ad");
        }
        return padFaceAd;
    }

    private PadFaceAd q(int i3) {
        for (PadFaceAd padFaceAd : this.f211977f) {
            if (padFaceAd.padFaceId == i3) {
                this.f211977f.remove(padFaceAd);
                return padFaceAd;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ArrayList arrayList = (ArrayList) this.f211973b.query(PadFaceAd.class);
        this.f211977f.clear();
        if (arrayList != null) {
            this.f211977f.addAll(arrayList);
        }
        Collections.sort(this.f211977f, f211971m);
    }

    public static void t(AppInterface appInterface, long j3) {
        appInterface.getApp().getSharedPreferences("gamecenter_sp" + appInterface.getCurrentAccountUin(), 4).edit().putLong("last_pwa_version", j3);
    }

    public static Intent u(PadFaceAd padFaceAd, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("pad_face_ad", padFaceAd);
        return intent;
    }

    public PadFaceAd l(int i3) {
        synchronized (this) {
            for (PadFaceAd padFaceAd : this.f211977f) {
                if (padFaceAd.redPointId == i3) {
                    return padFaceAd;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040 A[Catch: all -> 0x0085, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x0007, B:10:0x0018, B:13:0x0020, B:16:0x0040, B:17:0x005f, B:23:0x0027, B:25:0x002d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(BusinessInfoCheckUpdate.AppInfo appInfo) {
        boolean z16;
        long j3;
        int i3;
        synchronized (this) {
            if (!this.f211981j) {
                return;
            }
            int n3 = n(appInfo, false);
            int i16 = this.f211982k.get(n3);
            if (n3 > 0 && l(n3) == null && i16 < 2) {
                this.f211982k.put(n3, i16 + 1);
            } else if (this.f211979h != 0 && System.currentTimeMillis() - this.f211979h <= this.f211978g) {
                z16 = false;
                if (!z16) {
                    this.f211979h = System.currentTimeMillis();
                    this.f211980i.edit().putLong("last_pad_face_request_time", this.f211979h).commit();
                    i3 = this.f211975d;
                    j3 = this.f211976e;
                } else {
                    j3 = 0;
                    i3 = 0;
                }
                if (!z16) {
                    QLog.e("PadFaceManager", 2, "pullPadFace, mLastRequestTime=", Long.valueOf(this.f211979h));
                    ((com.tencent.mobileqq.apollo.handler.b) this.f211972a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).X1(n3, i3, j3);
                    return;
                }
                return;
            }
            z16 = true;
            if (!z16) {
            }
            if (!z16) {
            }
        }
    }

    public void s(int i3) {
        synchronized (this) {
            if (!this.f211981j) {
                return;
            }
            PadFaceAd q16 = q(i3);
            if (q16 != null) {
                this.f211975d = i3;
                this.f211976e = NetConnInfoCenter.getServerTime();
            }
            if (q16 != null) {
                this.f211973b.remove(q16);
                this.f211980i.edit().putInt("last_id_pad_face_shown", this.f211975d).putLong("last_time_pad_face_shown", this.f211976e).commit();
                ((com.tencent.mobileqq.apollo.handler.b) this.f211972a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).m(i3);
            }
        }
    }
}
