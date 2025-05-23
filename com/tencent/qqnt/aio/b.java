package com.tencent.qqnt.aio;

import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/b;", "", "", "exceptionInfo", "", "b", "Landroidx/fragment/app/FragmentManager;", "fm", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f349763a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63262);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f349763a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(String exceptionInfo) {
        QQBeaconReport.report("aioFragmentCheck");
    }

    public final void a(@NotNull FragmentManager fm5) {
        SplashAIOFragment splashAIOFragment;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fm5);
            return;
        }
        Intrinsics.checkNotNullParameter(fm5, "fm");
        try {
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aiofragment_check_8980", true)) {
                QLog.i("AIOFragmentChecker", 1, "[checkAIOFragment]: switch off");
                return;
            }
            if (!Looper.getMainLooper().isCurrentThread()) {
                QLog.i("AIOFragmentChecker", 1, QLog.getStackTraceString(new Throwable("openaio thread is illegal")));
                b("checkAIOFragment in subThread");
                return;
            }
            Fragment findFragmentByTag = fm5.findFragmentByTag(SplashAIOFragment.class.getName());
            if (findFragmentByTag == null) {
                return;
            }
            List<Fragment> fragments = fm5.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "fm.fragments");
            ArrayList<Fragment> arrayList = new ArrayList();
            for (Object obj : fragments) {
                Fragment fragment = (Fragment) obj;
                if ((fragment instanceof SplashAIOFragment) && fragment != findFragmentByTag) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            QLog.i("AIOFragmentChecker", 1, "[checkAIOFragment]: validAIOFragment hashCode is " + findFragmentByTag.hashCode() + ", invalidAIOFragment size is " + arrayList.size());
            for (Fragment fragment2 : arrayList) {
                int hashCode = fragment2.hashCode();
                AIOContact aIOContact = null;
                if (fragment2 instanceof SplashAIOFragment) {
                    splashAIOFragment = (SplashAIOFragment) fragment2;
                } else {
                    splashAIOFragment = null;
                }
                if (splashAIOFragment != null) {
                    aIOContact = splashAIOFragment.getAIOContact();
                }
                QLog.i("AIOFragmentChecker", 1, "[checkAIOFragment]: invalidFragment hashCode is " + hashCode + " contact is " + aIOContact);
            }
            b("aio size more than one");
        } catch (Throwable th5) {
            QLog.i("AIOFragmentChecker", 1, "[checkAIOFragment]: ", th5);
        }
    }
}
