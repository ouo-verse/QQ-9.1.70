package com.tencent.mobileqq.exportfile.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001e\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\u001e\u0010\n\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\b\u00a8\u0006\u000b"}, d2 = {"Landroidx/fragment/app/Fragment;", "", "path", "Landroid/os/Bundle;", "extras", "", "b", "title", "", "isConnect", "a", "wifiphoto_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {
    public static final void a(@NotNull Fragment fragment, @NotNull String title, boolean z16) {
        BaseExportFileFragment baseExportFileFragment;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        if (fragment instanceof BaseExportFileFragment) {
            baseExportFileFragment = (BaseExportFileFragment) fragment;
        } else {
            baseExportFileFragment = null;
        }
        if (baseExportFileFragment == null) {
            return;
        }
        title.length();
        BaseExportFileFragment baseExportFileFragment2 = (BaseExportFileFragment) fragment;
        baseExportFileFragment2.th().f416191f.setText(title);
        if (z16) {
            baseExportFileFragment2.th().f416189d.setVisibility(0);
        } else {
            baseExportFileFragment2.th().f416189d.setVisibility(8);
        }
    }

    public static final void b(@NotNull Fragment fragment, @NotNull String path, @Nullable Bundle bundle) {
        BaseExportFileFragment baseExportFileFragment;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        if (fragment instanceof BaseExportFileFragment) {
            baseExportFileFragment = (BaseExportFileFragment) fragment;
        } else {
            baseExportFileFragment = null;
        }
        if (baseExportFileFragment == null) {
            return;
        }
        QBaseFragment qBaseFragment = (QBaseFragment) QRoute.createNavigator(fragment.requireContext(), path).requestWithReturn();
        if (bundle != null) {
            qBaseFragment.setArguments(bundle);
        }
        ((BaseExportFileFragment) fragment).getChildFragmentManager().beginTransaction().replace(baseExportFileFragment.th().f416187b.getId(), qBaseFragment).commit();
    }

    public static /* synthetic */ void c(Fragment fragment, String str, Bundle bundle, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        b(fragment, str, bundle);
    }
}
