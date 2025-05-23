package com.tencent.state.privacy.components.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.databinding.VasSquareFragmentPrivacyBinding;
import com.tencent.state.square.feeds.SquareQZoneFeedsManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/privacy/components/fragment/PrivacyQZoneComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentPrivacyBinding;", "report", "Lcom/tencent/state/square/IReporter;", "onFragmentViewCreated", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class PrivacyQZoneComponent extends VasBaseFragmentComponent {
    private VasSquareFragmentPrivacyBinding binding;
    private IReporter report;

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        final VasSquareFragmentPrivacyBinding binding = VasSquareFragmentPrivacyBinding.bind(v3);
        IReporter reporter = Square.INSTANCE.getConfig().getReporter();
        this.report = reporter;
        if (reporter != null) {
            Intrinsics.checkNotNullExpressionValue(binding, "binding");
            LinearLayout mContainer = binding.getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
            LinearLayout mContainer2 = binding.getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer2, "binding.root");
            reporter.setPageInfo(mContainer, mContainer2, SquareReportConst.PageId.PAGE_ID_PRIVACY_AUTHORIZATION, new LinkedHashMap());
        }
        IReporter iReporter = this.report;
        if (iReporter != null) {
            FormSwitchItem formSwitchItem = binding.setPrivacy;
            Intrinsics.checkNotNullExpressionValue(formSwitchItem, "binding.setPrivacy");
            iReporter.setElementInfo(formSwitchItem, SquareReportConst.ElementId.ELEMENT_ID_SPACE_AUTHORIZATION_SWITCH, new LinkedHashMap(), false, false);
        }
        FormSwitchItem formSwitchItem2 = binding.setPrivacy;
        Intrinsics.checkNotNullExpressionValue(formSwitchItem2, "binding.setPrivacy");
        formSwitchItem2.setChecked(false);
        SquareQZoneFeedsManager.INSTANCE.queryQZonePrivacy(new Function1<Boolean, Unit>() { // from class: com.tencent.state.privacy.components.fragment.PrivacyQZoneComponent$onFragmentViewCreated$$inlined$also$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IReporter iReporter2;
                Map<String, Object> mutableMapOf;
                FormSwitchItem formSwitchItem3 = VasSquareFragmentPrivacyBinding.this.setPrivacy;
                Intrinsics.checkNotNullExpressionValue(formSwitchItem3, "binding.setPrivacy");
                formSwitchItem3.setChecked(z16);
                iReporter2 = this.report;
                if (iReporter2 != null) {
                    FormSwitchItem formSwitchItem4 = VasSquareFragmentPrivacyBinding.this.setPrivacy;
                    Intrinsics.checkNotNullExpressionValue(formSwitchItem4, "binding.setPrivacy");
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_SWITCH_STATUS, Integer.valueOf(z16 ? 1 : 0)));
                    iReporter2.reportEvent("imp", formSwitchItem4, mutableMapOf);
                }
            }
        });
        FormSwitchItem formSwitchItem3 = binding.setPrivacy;
        Intrinsics.checkNotNullExpressionValue(formSwitchItem3, "binding.setPrivacy");
        formSwitchItem3.getSwitch().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.privacy.components.fragment.PrivacyQZoneComponent$onFragmentViewCreated$$inlined$also$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IReporter iReporter2;
                Map<String, Object> mutableMapOf;
                FormSwitchItem formSwitchItem4 = VasSquareFragmentPrivacyBinding.this.setPrivacy;
                Intrinsics.checkNotNullExpressionValue(formSwitchItem4, "binding.setPrivacy");
                boolean isChecked = formSwitchItem4.isChecked();
                SquareQZoneFeedsManager.INSTANCE.updateQZonePrivacy(isChecked, new Function1<Boolean, Unit>() { // from class: com.tencent.state.privacy.components.fragment.PrivacyQZoneComponent$onFragmentViewCreated$$inlined$also$lambda$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        FormSwitchItem formSwitchItem5 = VasSquareFragmentPrivacyBinding.this.setPrivacy;
                        Intrinsics.checkNotNullExpressionValue(formSwitchItem5, "binding.setPrivacy");
                        if (z16 != formSwitchItem5.isChecked()) {
                            FormSwitchItem formSwitchItem6 = VasSquareFragmentPrivacyBinding.this.setPrivacy;
                            Intrinsics.checkNotNullExpressionValue(formSwitchItem6, "binding.setPrivacy");
                            formSwitchItem6.setChecked(z16);
                        }
                    }
                });
                iReporter2 = this.report;
                if (iReporter2 != null) {
                    FormSwitchItem formSwitchItem5 = VasSquareFragmentPrivacyBinding.this.setPrivacy;
                    Intrinsics.checkNotNullExpressionValue(formSwitchItem5, "binding.setPrivacy");
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_SWITCH_STATUS, Integer.valueOf(isChecked ? 1 : 0)));
                    iReporter2.reportEvent("clck", formSwitchItem5, mutableMapOf);
                }
            }
        });
        Unit unit = Unit.INSTANCE;
        this.binding = binding;
    }
}
