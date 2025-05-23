package com.tencent.state.privacy.components.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.privacy.StrangerPrivacyManager;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquareFragmentPrivacyBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import wx4.d;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/privacy/components/fragment/PrivacyStrangerComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentPrivacyBinding;", "checkResult", "", "onFragmentViewCreated", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class PrivacyStrangerComponent extends VasBaseFragmentComponent {
    private VasSquareFragmentPrivacyBinding binding;
    private boolean checkResult;

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        final VasSquareFragmentPrivacyBinding binding = VasSquareFragmentPrivacyBinding.bind(v3);
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        LinearLayout mContainer = binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        LinearLayout mContainer2 = binding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer2, "binding.root");
        squareReporter.setPageInfo(mContainer, mContainer2, SquareReportConst.PageId.PAGE_ID_PRIVACY_AUTHORIZATION, new LinkedHashMap());
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        FormSwitchItem formSwitchItem = binding.setStrangerVisible;
        Intrinsics.checkNotNullExpressionValue(formSwitchItem, "binding.setStrangerVisible");
        squareReporter2.setElementInfo(formSwitchItem, SquareReportConst.ElementId.ELEMENT_ID_STRANGER_CAN_SEE, new LinkedHashMap(), false, false);
        VideoReport.setEventDynamicParams(binding.setStrangerVisible, new IDynamicParams() { // from class: com.tencent.state.privacy.components.fragment.PrivacyStrangerComponent$onFragmentViewCreated$$inlined$also$lambda$1
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public Map<String, Object> getDynamicParams(String p06) {
                boolean z16;
                Map<String, Object> mutableMapOf;
                d.Companion companion = d.INSTANCE;
                z16 = PrivacyStrangerComponent.this.checkResult;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_IS_STRANGER_CAN_SEE, Integer.valueOf(companion.b(z16))));
                return mutableMapOf;
            }
        });
        FormSwitchItem formSwitchItem2 = binding.setStrangerVisible;
        Intrinsics.checkNotNullExpressionValue(formSwitchItem2, "binding.setStrangerVisible");
        formSwitchItem2.setChecked(false);
        StrangerPrivacyManager.INSTANCE.queryStrangerVisible(new Function1<Boolean, Unit>() { // from class: com.tencent.state.privacy.components.fragment.PrivacyStrangerComponent$onFragmentViewCreated$$inlined$also$lambda$2
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
                FormSwitchItem formSwitchItem3 = VasSquareFragmentPrivacyBinding.this.setStrangerVisible;
                Intrinsics.checkNotNullExpressionValue(formSwitchItem3, "binding.setStrangerVisible");
                formSwitchItem3.setChecked(z16);
                this.checkResult = z16;
                IReporter squareReporter3 = SquareBaseKt.getSquareReporter();
                FormSwitchItem formSwitchItem4 = VasSquareFragmentPrivacyBinding.this.setStrangerVisible;
                Intrinsics.checkNotNullExpressionValue(formSwitchItem4, "binding.setStrangerVisible");
                squareReporter3.reportEvent("imp", formSwitchItem4, new LinkedHashMap());
            }
        });
        FormSwitchItem formSwitchItem3 = binding.setStrangerVisible;
        Intrinsics.checkNotNullExpressionValue(formSwitchItem3, "binding.setStrangerVisible");
        formSwitchItem3.getSwitch().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.privacy.components.fragment.PrivacyStrangerComponent$onFragmentViewCreated$$inlined$also$lambda$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z16;
                Map<String, Object> mutableMapOf;
                FormSwitchItem formSwitchItem4 = VasSquareFragmentPrivacyBinding.this.setStrangerVisible;
                Intrinsics.checkNotNullExpressionValue(formSwitchItem4, "binding.setStrangerVisible");
                final boolean isChecked = formSwitchItem4.isChecked();
                this.checkResult = isChecked;
                StrangerPrivacyManager.setStrangerVisible$default(StrangerPrivacyManager.INSTANCE, isChecked, false, new Function1<Boolean, Unit>() { // from class: com.tencent.state.privacy.components.fragment.PrivacyStrangerComponent$onFragmentViewCreated$$inlined$also$lambda$3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z17) {
                        if (z17 != isChecked) {
                            FormSwitchItem formSwitchItem5 = VasSquareFragmentPrivacyBinding.this.setStrangerVisible;
                            Intrinsics.checkNotNullExpressionValue(formSwitchItem5, "binding.setStrangerVisible");
                            formSwitchItem5.setChecked(z17);
                            this.checkResult = z17;
                        }
                    }
                }, 2, null);
                IReporter squareReporter3 = SquareBaseKt.getSquareReporter();
                FormSwitchItem formSwitchItem5 = VasSquareFragmentPrivacyBinding.this.setStrangerVisible;
                Intrinsics.checkNotNullExpressionValue(formSwitchItem5, "binding.setStrangerVisible");
                d.Companion companion = d.INSTANCE;
                z16 = this.checkResult;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_IS_STRANGER_CAN_SEE, Integer.valueOf(companion.b(true ^ z16))));
                squareReporter3.reportEvent("clck", formSwitchItem5, mutableMapOf);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.binding = binding;
    }
}
