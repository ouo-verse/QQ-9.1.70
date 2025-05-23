package com.tencent.state.library.components.fragments;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.library.focus.FocusDialogTips;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.template.map.component.TemplateSchemeComponent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibrarySchemeComponent;", "Lcom/tencent/state/template/map/component/TemplateSchemeComponent;", "()V", "reporter", "Lcom/tencent/state/square/IReporter;", "onShowUserHasLeaveDialog", "", "context", "Landroid/content/Context;", "friendName", "", "callback", "Lkotlin/Function0;", "reportDeskHavePeople", "showHasOwnerTips", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "showSitingTips", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibrarySchemeComponent extends TemplateSchemeComponent {
    private IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();

    @Override // com.tencent.state.template.map.component.TemplateSchemeComponent
    public void onShowUserHasLeaveDialog(Context context, String friendName, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendName, "friendName");
        FocusDialogTips.INSTANCE.hasLeaveDeskDialog(context, friendName, callback);
    }

    @Override // com.tencent.state.template.map.component.TemplateSchemeComponent
    public void reportDeskHavePeople() {
        Map<String, Object> mutableMapOf;
        IReporter iReporter = this.reporter;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_event_source_parameters", 1));
        iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_FOCUS_HAVE_PEOPLE_TOAST, mutableMapOf);
    }

    @Override // com.tencent.state.template.map.component.TemplateSchemeComponent
    public void showHasOwnerTips(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Square.INSTANCE.getConfig().getCommonUtils().showToast(activity, activity.getString(R.string.xge), 0);
    }

    @Override // com.tencent.state.template.map.component.TemplateSchemeComponent
    public void showSitingTips(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Square.INSTANCE.getConfig().getCommonUtils().showToast(activity, activity.getString(R.string.xgl), 0);
    }
}
