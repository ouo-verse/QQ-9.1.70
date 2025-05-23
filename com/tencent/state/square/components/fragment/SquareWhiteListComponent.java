package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasStatusSquareWhiteService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.components.SquareBlockDialogUtils;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.data.SquareWhiteListDialogInfo;
import com.tencent.state.square.data.SquareWhitelist;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J,\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010\u0016\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH\u0002J)\u0010\u001d\u001a\u00020\f2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\f0\u001fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareWhiteListComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", "hasShow", "", "source", "", "squareWhitelist", "Lcom/tencent/state/square/data/SquareWhitelist;", "addWhiteList", "", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentVisibilityChanged", "isVisible", "queryWhiteList", "reportData", "btnType", "", "eventType", "showWhiteDialog", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareWhiteListComponent extends SquareBaseComponent {
    private static final String TAG = "SquareWhiteListComp";
    private VasSquareFragmentSquareBinding binding;
    private boolean hasShow;
    private String source;
    private SquareWhitelist squareWhitelist;

    /* JADX INFO: Access modifiers changed from: private */
    public final void addWhiteList() {
        String str;
        SquareWhitelist squareWhitelist = this.squareWhitelist;
        if (squareWhitelist == null || !squareWhitelist.getShowDialog() || (str = this.source) == null) {
            return;
        }
        VasStatusSquareWhiteService.addWhiteList$default(new VasStatusSquareWhiteService(), str, null, 2, null);
    }

    private final void queryWhiteList() {
        String str = this.source;
        if (str != null) {
            new VasStatusSquareWhiteService().queryUserWhite(str, new ResultCallback<SquareWhitelist>() { // from class: com.tencent.state.square.components.fragment.SquareWhiteListComponent$queryWhiteList$$inlined$let$lambda$1
                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str2) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str2);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str2, String str3) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str2, str3);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultSuccess(SquareWhitelist result) {
                    SquareWhiteListComponent.this.squareWhitelist = result;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportData(int btnType, String eventType) {
        Map<String, Object> mutableMapOf;
        IReporter reporter = Square.INSTANCE.getConfig().getReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", eventType), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, Integer.valueOf(btnType)));
        reporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_ZPLAN_MESSAGE_ENTRANCE_CHANGE_POPUP_WINDOW, mutableMapOf);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.binding = VasSquareFragmentSquareBinding.bind(v3);
        QBaseActivity activity = getActivity();
        this.source = activity != null ? SquareGroupReportComponentKt.getSourceFrom(activity) : null;
        if (SquareBlockDialogUtils.INSTANCE.isBlockDialog(getActivity())) {
            queryWhiteList();
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentVisibilityChanged(FragmentManager fm5, Fragment f16, boolean isVisible) {
        FrameLayout it;
        String str;
        Intrinsics.checkNotNullParameter(f16, "f");
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
        if (vasSquareFragmentSquareBinding == null || (it = vasSquareFragmentSquareBinding.getMContainer()) == null) {
            return;
        }
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        if (isVisible) {
            str = "pgin";
        } else {
            str = "pgout";
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(getActivity()));
        Unit unit = Unit.INSTANCE;
        squareReporter.reportEvent(str, it, linkedHashMap);
    }

    public final void showWhiteDialog(final Function1<? super Boolean, Unit> callback) {
        String str;
        String str2;
        String str3;
        SquareWhiteListDialogInfo dialogInfo;
        SquareWhiteListDialogInfo dialogInfo2;
        SquareWhiteListDialogInfo dialogInfo3;
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareWhitelist squareWhitelist = this.squareWhitelist;
        if (!(squareWhitelist != null ? squareWhitelist.getShowDialog() : false)) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        if (this.hasShow) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        QBaseActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            reportData(0, "imp");
            reportData(1, "imp");
            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
            SquareWhitelist squareWhitelist2 = this.squareWhitelist;
            if (squareWhitelist2 == null || (dialogInfo3 = squareWhitelist2.getDialogInfo()) == null || (str = dialogInfo3.getText()) == null) {
                str = "";
            }
            SquareWhitelist squareWhitelist3 = this.squareWhitelist;
            if (squareWhitelist3 == null || (dialogInfo2 = squareWhitelist3.getDialogInfo()) == null || (str2 = dialogInfo2.getRightButtonText()) == null) {
                str2 = "";
            }
            SquareWhitelist squareWhitelist4 = this.squareWhitelist;
            if (squareWhitelist4 == null || (dialogInfo = squareWhitelist4.getDialogInfo()) == null || (str3 = dialogInfo.getLeftButtonText()) == null) {
                str3 = "";
            }
            squareCommon.showDialog(activity, str, str2, str3, (String) null, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareWhiteListComponent$showWhiteDialog$1
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
                    if (z16) {
                        SquareWhiteListComponent.this.reportData(1, "click");
                        SquareWhiteListComponent.this.addWhiteList();
                    } else {
                        SquareWhiteListComponent.this.reportData(0, "click");
                    }
                    callback.invoke(Boolean.TRUE);
                    SquareWhiteListComponent.this.hasShow = true;
                }
            });
            return;
        }
        callback.invoke(Boolean.FALSE);
    }
}
