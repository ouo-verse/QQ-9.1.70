package p40;

import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment;
import com.tencent.biz.qqcircle.immersive.floatingwindow.model.QFSSmallWindowGlobalCollect;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static volatile m f425298a;

    m() {
    }

    public static m b() {
        if (f425298a == null) {
            synchronized (m.class) {
                if (f425298a == null) {
                    f425298a = new m();
                }
            }
        }
        return f425298a;
    }

    private boolean c() {
        return QFSSmallWindowGlobalCollect.k().d().c() instanceof QFSLayerPageFragment;
    }

    private boolean d() {
        com.tencent.biz.qqcircle.immersive.floatingwindow.model.a d16 = QFSSmallWindowGlobalCollect.k().d();
        if (d16.d() != null && d16.e() >= 0 && !d16.f()) {
            return true;
        }
        return false;
    }

    private boolean e() {
        if (QFSSmallWindowGlobalCollect.k().d().c() != null) {
            return true;
        }
        return false;
    }

    private void f() {
        com.tencent.biz.qqcircle.immersive.floatingwindow.model.a d16 = QFSSmallWindowGlobalCollect.k().d();
        FrameFragment d17 = d16.d();
        int e16 = d16.e();
        if (d16.f()) {
            QLog.d("QFP-QFSFloatingPageControl", 1, "[recoverBottomTabFrame] unselected tab not execute flow.");
            return;
        }
        if (d16.e() >= 0 && d17 != null) {
            if (d17.mTabIndicator == null) {
                QLog.e("QFP-QFSFloatingPageControl", 1, "[recoverBottomTabFrame] tab host not is empty.");
                return;
            }
            if (e16 == 8 && ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).needShowQzoneFrame(RFWApplication.getApplication(), MobileQQ.sMobileQQ.peekAppRuntime())) {
                QLog.d("QFP-QFSFloatingPageControl", 1, "[recoverBottomTabFrame] current is show qzone frame, not recover: " + e16);
                e16 = 0;
            }
            QLog.d("QFP-QFSFloatingPageControl", 1, "[recoverBottomTabFrame] recoverBottomTabFrameIndex: " + e16);
            d17.mTabIndicator.setCurrentTab(e16);
            return;
        }
        QLog.e("QFP-QFSFloatingPageControl", 1, "[recoverBottomTabFrame] current pre tab index < 0 or frame frame is null.");
    }

    private void g() {
        FragmentActivity activity;
        QCircleBaseFragment c16 = QFSSmallWindowGlobalCollect.k().d().c();
        if (c16 == null) {
            activity = null;
        } else {
            activity = c16.getActivity();
        }
        if (activity == null) {
            QLog.e("QFP-QFSFloatingPageControl", 1, "[recoverPreActivityPage] activity should not be null.");
        } else if (kc0.a.c(activity.getClass().getName())) {
            QLog.e("QFP-QFSFloatingPageControl", 1, "[recoverPreActivityPage] splash should not finish.");
        } else {
            activity.finish();
        }
    }

    public void a() {
        if (d()) {
            if (c()) {
                g();
                QLog.d("QFP-QFSFloatingPageControl", 1, "[callToPrePage] bottom inner fragment out page.");
                return;
            } else {
                f();
                QLog.d("QFP-QFSFloatingPageControl", 1, "[callToPrePage] recover pre bottom tab frame.");
                return;
            }
        }
        if (e()) {
            g();
            QLog.d("QFP-QFSFloatingPageControl", 1, "[callToPrePage] recover pre dynamic inner fragment page.");
            return;
        }
        com.tencent.biz.qqcircle.immersive.floatingwindow.model.a d16 = QFSSmallWindowGlobalCollect.k().d();
        QLog.e("QFP-QFSFloatingPageControl", 1, "[callToPrePage] current pre page fail,mPreTabIndex: " + d16.e() + " | mCurrentInnerDaTongPageId: " + d16.b(), new Exception());
    }
}
