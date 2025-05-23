package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.utils.BundleParamsUtils;
import com.tencent.state.view.SquareImageView;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J,\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareZPlanEntranceComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", "reporter", "Lcom/tencent/state/square/IReporter;", "initEntranceIcon", "", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareZPlanEntranceComponent extends SquareBaseComponent {
    private static final String TAG = "SquareZplanEntranceComponent";
    private VasSquareFragmentSquareBinding binding;
    private IReporter reporter = Square.INSTANCE.getConfig().getReporter();

    private final void initEntranceIcon() {
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding;
        SquareImageView squareImageView;
        SquareImageView squareImageView2;
        if (SquareBaseComponentKt.getSquareGroupConfig(this).getEmbedOnlinePanel()) {
            VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding2 = this.binding;
            if (vasSquareFragmentSquareBinding2 == null || (squareImageView2 = vasSquareFragmentSquareBinding2.portal) == null) {
                return;
            }
            squareImageView2.setVisibility(8);
            return;
        }
        final QBaseActivity activity = getActivity();
        if (activity == null || (vasSquareFragmentSquareBinding = this.binding) == null || (squareImageView = vasSquareFragmentSquareBinding.portal) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding?.portal ?: return");
        IReporter iReporter = this.reporter;
        if (iReporter != null) {
            iReporter.setElementInfo(squareImageView, "em_zplan_mall_icon", new LinkedHashMap(), false, false);
        }
        Square square = Square.INSTANCE;
        if (square.getConfig().getCommonUtils().checkZplanAccessible(square.getConfig().getCommonUtils().getCurrentAccountUin())) {
            squareImageView.setVisibility(0);
            IReporter iReporter2 = this.reporter;
            if (iReporter2 != null) {
                iReporter2.reportEvent("imp", squareImageView, new LinkedHashMap());
            }
        } else {
            squareImageView.setVisibility(8);
        }
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("entrance visible: ");
        sb5.append(squareImageView.getVisibility() == 0);
        squareLog.i(TAG, sb5.toString());
        squareImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.components.fragment.SquareZPlanEntranceComponent$initEntranceIcon$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                IReporter iReporter3;
                iReporter3 = SquareZPlanEntranceComponent.this.reporter;
                if (iReporter3 != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    iReporter3.reportEvent("clck", it, new LinkedHashMap());
                }
                Square.INSTANCE.getConfig().getRouter().routeToZplanPortal(activity, BundleParamsUtils.INSTANCE.getPortalBundle(), SquareReportConst.SubSource.SQUARE_MALL_SOURCE);
            }
        });
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.binding = VasSquareFragmentSquareBinding.bind(v3);
        initEntranceIcon();
    }
}
