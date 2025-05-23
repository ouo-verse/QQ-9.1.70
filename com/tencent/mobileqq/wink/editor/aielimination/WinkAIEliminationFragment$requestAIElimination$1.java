package com.tencent.mobileqq.wink.editor.aielimination;

import android.os.Handler;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.editor.aielimination.doodle.view.DoodleView;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationDoActionType;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.wink.view.ag;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "code", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "errorMsg", "", "invoke", "(Ljava/lang/String;JLcom/tencent/mobileqq/wink/editor/aielimination/model/b;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIEliminationFragment$requestAIElimination$1 extends Lambda implements Function4<String, Long, com.tencent.mobileqq.wink.editor.aielimination.model.b, String, Unit> {
    final /* synthetic */ WinkAIEliminationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIEliminationFragment$requestAIElimination$1(WinkAIEliminationFragment winkAIEliminationFragment) {
        super(4);
        this.this$0 = winkAIEliminationFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String requestId, WinkAIEliminationFragment this$0, long j3, com.tencent.mobileqq.wink.editor.aielimination.model.b bVar) {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog;
        ag agVar;
        boolean z16;
        Intrinsics.checkNotNullParameter(requestId, "$requestId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(requestId, this$0.hi().getCurrentRequestId())) {
            qCircleCommonLoadingDialog = this$0.progressDialog;
            ag agVar2 = null;
            String str = null;
            if (qCircleCommonLoadingDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
                qCircleCommonLoadingDialog = null;
            }
            if (qCircleCommonLoadingDialog.isShowing()) {
                ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_AI_ELIMINATE_TOTAL_COST);
                this$0.ri();
                if (j3 == 0) {
                    this$0.hi().W2(bVar);
                    DoodleView doodleView = this$0.doodleView;
                    if (doodleView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("doodleView");
                        doodleView = null;
                    }
                    doodleView.n();
                    if (bVar != null) {
                        str = bVar.getDstMediaPath();
                    }
                    this$0.Ui(str, false);
                    this$0.Wi();
                    this$0.hi().W1(AIEliminationDoActionType.Finish);
                } else if (j3 == 2111) {
                    QQToast.makeText(this$0.getContext(), R.string.f240567pi, 0).show();
                } else if (j3 == 3104) {
                    QQToast.makeText(this$0.getContext(), R.string.f240627po, 0).show();
                } else if (j3 != 2114) {
                    agVar = this$0.loadErrorDialog;
                    if (agVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadErrorDialog");
                    } else {
                        agVar2 = agVar;
                    }
                    agVar2.show();
                } else {
                    QQToast.makeText(this$0.getContext(), R.string.f240747q0, 0).show();
                }
                WinkAiEliminationViewModel hi5 = this$0.hi();
                if (j3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                hi5.T2(z16, false, (int) j3);
            }
        }
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(String str, Long l3, com.tencent.mobileqq.wink.editor.aielimination.model.b bVar, String str2) {
        invoke(str, l3.longValue(), bVar, str2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final String requestId, final long j3, @Nullable final com.tencent.mobileqq.wink.editor.aielimination.model.b bVar, @Nullable String str) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final WinkAIEliminationFragment winkAIEliminationFragment = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.aielimination.t
            @Override // java.lang.Runnable
            public final void run() {
                WinkAIEliminationFragment$requestAIElimination$1.b(requestId, winkAIEliminationFragment, j3, bVar);
            }
        });
    }
}
