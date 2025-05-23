package com.tencent.state.square.chatland.view.chatLandChooseActionDialog;

import android.widget.FrameLayout;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquareChatLandChooseActionDialogBinding;
import com.tencent.state.template.data.InteractionMotionAction;
import com.tencent.state.template.data.InteractionMotionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/state/square/chatland/view/chatLandChooseActionDialog/ActionDialog$initData$1", "Lcom/tencent/state/service/ResultCallback;", "", "Lcom/tencent/state/template/data/InteractionMotionInfo;", "onResultFailure", "", "error", "", "message", "", "onResultSuccess", "result", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ActionDialog$initData$1 implements ResultCallback<List<? extends InteractionMotionInfo>> {
    final /* synthetic */ ActionDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActionDialog$initData$1(ActionDialog actionDialog) {
        this.this$0 = actionDialog;
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str, String str2) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
    }

    @Override // com.tencent.state.service.ResultCallback
    public /* bridge */ /* synthetic */ void onResultSuccess(List<? extends InteractionMotionInfo> list) {
        onResultSuccess2((List<InteractionMotionInfo>) list);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int error, String message) {
        ResultCallback.DefaultImpls.onResultFailure(this, error, message);
        SquareBaseKt.getSquareCommon().showToastSafely(this.this$0.getContext(), message, 1);
        this.this$0.dismiss();
    }

    /* renamed from: onResultSuccess, reason: avoid collision after fix types in other method */
    public void onResultSuccess2(List<InteractionMotionInfo> result) {
        ListAdapter listAdapter;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(result, "result");
        listAdapter = this.this$0.adapter;
        List<InteractionMotionInfo> list = result;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new InteractionMotionAction((InteractionMotionInfo) it.next(), new Function1<InteractionMotionAction, Unit>() { // from class: com.tencent.state.square.chatland.view.chatLandChooseActionDialog.ActionDialog$initData$1$onResultSuccess$$inlined$map$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InteractionMotionAction interactionMotionAction) {
                    invoke2(interactionMotionAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InteractionMotionAction it5) {
                    Function1 function1;
                    VasSquareChatLandChooseActionDialogBinding vasSquareChatLandChooseActionDialogBinding;
                    Map<String, Object> mutableMapOf;
                    Intrinsics.checkNotNullParameter(it5, "it");
                    function1 = ActionDialog$initData$1.this.this$0.chooseCallBack;
                    function1.invoke(it5);
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    vasSquareChatLandChooseActionDialogBinding = ActionDialog$initData$1.this.this$0.binding;
                    FrameLayout frameLayout = vasSquareChatLandChooseActionDialogBinding.container;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.container");
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_FIT_ID, Integer.valueOf(it5.getMotionId())));
                    squareReporter.reportEvent("clck", frameLayout, mutableMapOf);
                    ActionDialog$initData$1.this.this$0.dismiss();
                }
            }));
        }
        listAdapter.appendList(arrayList);
        this.this$0.showImp();
    }
}
