package a94;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\t\u0018\u0000 \u00052\u00020\u0001:\u0001\u0016B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"La94/b;", "La94/d;", "Landroidx/fragment/app/Fragment;", "fragment", "", "d", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "containerId", "", "isReplaceAdd", "g", "f", "", "c", "Ljava/util/Collection;", "e", "()Ljava/util/Collection;", "fragments", "<init>", "(Ljava/util/Collection;)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b extends d {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Collection<Fragment> fragments;

    public b(Collection<Fragment> fragments) {
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        this.fragments = fragments;
    }

    public final void d(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (this.fragments.contains(fragment)) {
            return;
        }
        this.fragments.add(fragment);
    }

    public final Collection<Fragment> e() {
        return this.fragments;
    }

    public final void f(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.d("ZootopiaFragmentHelper", 2, "removeAllFragment");
        try {
            FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "activity.supportFragmentManager.beginTransaction()");
            for (Fragment fragment : this.fragments) {
                if (fragment.isAdded()) {
                    beginTransaction.remove(fragment);
                    QLog.d("ZootopiaFragmentHelper", 2, "remove fragment " + fragment);
                }
            }
            beginTransaction.commitNowAllowingStateLoss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public final void g(FragmentActivity activity, int containerId, Fragment fragment, boolean isReplaceAdd) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        QLog.i("ZootopiaFragmentHelper", 2, "switchFragment fragment=" + fragment + ", added=" + fragment.isAdded() + ", current=" + getCurrent() + ", isReplaceAdd=" + isReplaceAdd);
        if (Intrinsics.areEqual(fragment, getCurrent())) {
            return;
        }
        FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "activity.supportFragmentManager.beginTransaction()");
        for (Fragment fragment2 : this.fragments) {
            if (!Intrinsics.areEqual(fragment2, fragment) && fragment2.isVisible()) {
                beginTransaction.hide(fragment2);
            }
        }
        if (fragment.isAdded()) {
            QLog.i("ZootopiaFragmentHelper", 2, "show " + fragment);
            beginTransaction.show(fragment);
        } else {
            QLog.i("ZootopiaFragmentHelper", 2, "add " + fragment);
            if (isReplaceAdd) {
                beginTransaction.replace(containerId, fragment);
            } else {
                beginTransaction.add(containerId, fragment);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        c(fragment);
    }
}
