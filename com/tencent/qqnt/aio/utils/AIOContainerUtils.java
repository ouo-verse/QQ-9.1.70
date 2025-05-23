package com.tencent.qqnt.aio.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\t\u0010\nR\u001b\u0010\u000e\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/utils/AIOContainerUtils;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "c", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/tencent/qqnt/aio/e;", "a", "(Landroidx/fragment/app/FragmentManager;)Lcom/tencent/qqnt/aio/e;", "b", "Lkotlin/Lazy;", "()Z", "fragmentStatusCheck", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOContainerUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIOContainerUtils f352240a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy fragmentStatusCheck;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52466);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f352240a = new AIOContainerUtils();
        lazy = LazyKt__LazyJVMKt.lazy(AIOContainerUtils$fragmentStatusCheck$2.INSTANCE);
        fragmentStatusCheck = lazy;
    }

    AIOContainerUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b() {
        return ((Boolean) fragmentStatusCheck.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final com.tencent.qqnt.aio.e a(@NotNull FragmentManager fragmentManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.aio.e) iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragmentManager);
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        List<Fragment> fragments = fragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragmentManager.fragments");
        for (Fragment fragment : fragments) {
            if (fragment instanceof com.tencent.qqnt.aio.e) {
                return (com.tencent.qqnt.aio.e) fragment;
            }
            if (fragment.isAdded() || !f352240a.b()) {
                try {
                    AIOContainerUtils aIOContainerUtils = f352240a;
                    FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "it.childFragmentManager");
                    com.tencent.qqnt.aio.e a16 = aIOContainerUtils.a(childFragmentManager);
                    if (a16 != null) {
                        return a16;
                    }
                } catch (Exception e16) {
                    QLog.e("AIOContainerUtils", 1, "[getAIOContainer]: exception", e16);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c(@NotNull FragmentActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof com.tencent.qqnt.aio.e) {
            return ((com.tencent.qqnt.aio.e) activity).isScale();
        }
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        com.tencent.qqnt.aio.e a16 = a(supportFragmentManager);
        if (a16 != null) {
            return a16.isScale();
        }
        QLog.i("AIOContainerUtils", 1, "[isScaleChat]: activity not have aioContainer");
        return false;
    }
}
