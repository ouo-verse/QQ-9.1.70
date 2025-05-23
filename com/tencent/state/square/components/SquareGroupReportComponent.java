package com.tencent.state.square.components;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.report.PerformanceReportConst;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J,\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/components/SquareGroupReportComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "()V", "initReport", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "reportDeviceInfo", "reportSchemeJump", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareGroupReportComponent extends VasBaseFragmentComponent {
    private static final String TAG = "SquareReportComponent";

    private final void initReport(View rootView) {
        VasBaseFragment fragment = getFragment();
        if (fragment != null) {
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(getActivity()));
            Unit unit = Unit.INSTANCE;
            squareReporter.setPageInfo(fragment, rootView, checkNearby, linkedHashMap);
        }
    }

    private final void reportDeviceInfo() {
        SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.square.components.SquareGroupReportComponent$reportDeviceInfo$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map<String, Object> covertDeviceInfo = PerformanceReportConst.INSTANCE.covertDeviceInfo(Square.INSTANCE.getConfig().getCommonUtils().getSquareDeviceInfo());
                if (covertDeviceInfo.isEmpty()) {
                    if (SquareBaseKt.getSquareLog().isColorLevel()) {
                        SquareBaseKt.getSquareLog().d("SquareReportComponent", "reportDeviceInfo, ignore");
                        return;
                    }
                    return;
                }
                SquareBaseKt.getSquareReporter().reportEvent(PerformanceReportConst.CustomEventId.EVENT_ID_PERFORMANCE_HARDWARE_INFO, covertDeviceInfo);
            }
        });
    }

    private final void reportSchemeJump() {
        Intent intent;
        Bundle extras;
        Integer intOrNull;
        Integer intOrNull2;
        Long longOrNull;
        Map<String, Object> mutableMapOf;
        QBaseActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(extras, "activity?.intent?.extras ?: return");
        if (extras.containsKey("gray_type")) {
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to("zplan_action_type", "click");
            String string = extras.getString("gray_type", "");
            Intrinsics.checkNotNullExpressionValue(string, "extras.getString(\"gray_type\", \"\")");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(string);
            pairArr[1] = TuplesKt.to("zplan_square_aiogray_type", Integer.valueOf(intOrNull != null ? intOrNull.intValue() : -1));
            String string2 = extras.getString("zhutai_ketai", "");
            Intrinsics.checkNotNullExpressionValue(string2, "extras.getString(\"zhutai_ketai\", \"\")");
            intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(string2);
            pairArr[2] = TuplesKt.to("zplan_zhutai_ketai", Integer.valueOf(intOrNull2 != null ? intOrNull2.intValue() : -1));
            String string3 = extras.getString("other_user_qq", "");
            Intrinsics.checkNotNullExpressionValue(string3, "extras.getString(\"other_user_qq\", \"\")");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(string3);
            pairArr[3] = TuplesKt.to("zplan_other_user_qq", Long.valueOf(longOrNull != null ? longOrNull.longValue() : -1L));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            squareReporter.reportEvent("ev_zplan_square_gray_impclck", mutableMapOf);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        initReport(v3);
        reportDeviceInfo();
        reportSchemeJump();
    }
}
