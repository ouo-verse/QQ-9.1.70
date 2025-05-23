package com.tencent.state.common.record;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.square.SquareBaseKt;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J,\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/common/record/RecordReportComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "()V", "initPageReport", "", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class RecordReportComponent extends VasBaseFragmentComponent {
    private final void initPageReport(Fragment f16, View v3) {
        String str;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (str = fragment.getPageId()) == null) {
            str = "zplan_square_library_homepage";
        }
        SquareBaseKt.getSquareReporter().setPageInfo(f16, v3, str, new LinkedHashMap());
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        initPageReport(f16, v3);
    }
}
