package c62;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.f;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f30395b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f30396a = false;

    /* compiled from: P */
    /* renamed from: c62.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0171a implements OnLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b62.a f30397a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f30398b;

        C0171a(b62.a aVar, String str) {
            this.f30397a = aVar;
            this.f30398b = str;
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            QLog.i("PTSSoLoader", 1, "[onLoadResult], resCode = " + i3);
            b62.a aVar = this.f30397a;
            if (aVar != null) {
                aVar.a(i3);
            }
            if (i3 == 0) {
                String initVer = SoLoadManager.getInstance().getInitVer(this.f30398b);
                QLog.i("PTSSoLoader", 1, "[onLoadResult], load so succeeded, name = " + this.f30398b + ", currentVersion = " + initVer);
                if (a.this.g(initVer, "1.1.4")) {
                    a.this.f30396a = true;
                }
            }
            a.this.i(this.f30398b, i3, SoLoadManager.getInstance().getInitVer(this.f30398b));
        }
    }

    a() {
    }

    public static a d() {
        if (f30395b == null) {
            synchronized (a.class) {
                if (f30395b == null) {
                    f30395b = new a();
                }
            }
        }
        return f30395b;
    }

    private List<Integer> e(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        String[] split = str.split("\\.");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
            } catch (NumberFormatException e16) {
                QLog.e("PTSSoLoader", 1, "[getVersionList] error, e = " + e16);
                return new ArrayList();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str, String str2) {
        QLog.i("PTSSoLoader", 1, "[isVersionValid], currentVersion = " + str + ", supportMinVersion = " + str2);
        List<Integer> e16 = e(str);
        List<Integer> e17 = e(str2);
        if (str.length() <= 0) {
            QLog.i("PTSSoLoader", 1, "[isVersionValid] false, currentVersion = " + str);
            return false;
        }
        int min = Math.min(e16.size(), e17.size());
        for (int i3 = 0; i3 < min; i3++) {
            if (e16.get(i3).intValue() < e17.get(i3).intValue()) {
                QLog.i("PTSSoLoader", 1, "[isVersionValid] = false");
                return false;
            }
            if (e16.get(i3).intValue() > e17.get(i3).intValue()) {
                QLog.i("PTSSoLoader", 1, "[isVersionValid] = true");
                return true;
            }
        }
        boolean z16 = e16.size() >= e17.size();
        QLog.i("PTSSoLoader", 1, "[isVersionValid] = " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, int i3, String str2) {
        String b16 = new f.a().a("name", str).a("resCode", "" + i3).a("version", str2).b();
        if (i3 == 0) {
            f.a("0X800A832", "", "", "", b16);
        } else {
            f.a("0X800A833", "", "", "", b16);
        }
    }

    public boolean f() {
        return this.f30396a;
    }

    public void h(String str, b62.a aVar) {
        QLog.i("PTSSoLoader", 1, "[load], name = " + str);
        SoLoadManager.getInstance().load(str, new C0171a(aVar, str));
    }
}
