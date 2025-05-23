package cooperation.vip.manager;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class h {

    /* renamed from: d, reason: collision with root package name */
    private static h f391296d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f391297a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f391298b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f391299c = 0;

    h() {
        this.f391297a = false;
        this.f391297a = BaseApplicationImpl.getApplication().getSharedPreferences("PackageUpdateManager", 4).getBoolean("HAS_PULL", false);
    }

    private int b() {
        if (this.f391298b) {
            return this.f391299c;
        }
        this.f391298b = true;
        if (e(BaseApplicationImpl.getApplication()) > d(BaseApplicationImpl.getApplication())) {
            this.f391299c = 1;
        } else {
            this.f391299c = 0;
        }
        return this.f391299c;
    }

    public static h c() {
        if (f391296d == null) {
            synchronized (h.class) {
                if (f391296d == null) {
                    f391296d = new h();
                }
            }
        }
        return f391296d;
    }

    public static long d(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).firstInstallTime;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static long e(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).lastUpdateTime;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    private void f() {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("PackageUpdateManager", 4).edit();
        edit.putBoolean("HAS_PULL", this.f391297a);
        edit.apply();
    }

    public void a(QQAppInterface qQAppInterface) {
        if (this.f391297a) {
            QLog.d("PackageUpdateManager", 1, "checkUpgrade has pulll");
        } else if (b() == 1) {
            this.f391297a = true;
            QLog.d("PackageUpdateManager", 1, "checkUpgrade need pull friendlist ");
            ((FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true);
            f();
        }
    }
}
