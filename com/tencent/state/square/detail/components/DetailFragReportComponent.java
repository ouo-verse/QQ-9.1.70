package com.tencent.state.square.detail.components;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.components.fragment.SquareBaseComponent;
import com.tencent.state.square.databinding.VasSquareFragmentBinding;
import com.tencent.state.square.detail.DetailBaseSelectFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/detail/components/DetailFragReportComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentBinding;", "onFragmentViewCreated", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentVisibilityChanged", "isVisible", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailFragReportComponent extends SquareBaseComponent {
    private VasSquareFragmentBinding binding;

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.binding = VasSquareFragmentBinding.bind(v3);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentVisibilityChanged(FragmentManager fm5, Fragment f16, boolean isVisible) {
        FrameLayout it;
        Map<String, Object> linkedHashMap;
        String str;
        String str2;
        String str3;
        String sourceFrom;
        Intrinsics.checkNotNullParameter(f16, "f");
        VasSquareFragmentBinding vasSquareFragmentBinding = this.binding;
        if (vasSquareFragmentBinding == null || (it = vasSquareFragmentBinding.getMContainer()) == null) {
            return;
        }
        VasBaseFragment fragment = getFragment();
        if (!(fragment instanceof DetailBaseSelectFragment)) {
            fragment = null;
        }
        DetailBaseSelectFragment detailBaseSelectFragment = (DetailBaseSelectFragment) fragment;
        if (detailBaseSelectFragment == null || (linkedHashMap = detailBaseSelectFragment.getDetailCommonPageInfo()) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        VasBaseFragment fragment2 = getFragment();
        String str4 = "";
        if (fragment2 == null || (str = fragment2.getPageId()) == null) {
            str = "";
        }
        linkedHashMap.put("pgid", str);
        VasBaseFragment fragment3 = getFragment();
        if (fragment3 == null || (str2 = fragment3.getPageId()) == null) {
            str2 = "";
        }
        linkedHashMap.put("dt_pgid", str2);
        QBaseActivity activity = getActivity();
        if (activity != null && (sourceFrom = SquareGroupReportComponentKt.getSourceFrom(activity)) != null) {
            str4 = sourceFrom;
        }
        linkedHashMap.put(SquareReportConst.Key.KEY_DETAIL_ENTRANCE_SOURCE, str4);
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        if (isVisible) {
            str3 = "pgin";
        } else {
            str3 = "pgout";
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        squareReporter.reportEvent(str3, it, linkedHashMap);
    }
}
