package com.tencent.state.square.detail;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.view.SquareEndInviteDialog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/detail/DetailDialogs;", "", "()V", "SOURCE_DETAIL", "", "TAG", "", "checkAndPublishMultiStatus", "", "context", "Landroid/content/Context;", "source", "onPublishAction", "Lkotlin/Function0;", "onCancelAction", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailDialogs {
    public static final DetailDialogs INSTANCE = new DetailDialogs();
    public static final int SOURCE_DETAIL = 0;
    private static final String TAG = "DetailDialogs";

    DetailDialogs() {
    }

    public final void checkAndPublishMultiStatus(Context context, int source, final Function0<Unit> onPublishAction, final Function0<Unit> onCancelAction) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onPublishAction, "onPublishAction");
        Intrinsics.checkNotNullParameter(onCancelAction, "onCancelAction");
        if (!IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.KEY_PUBLISH_WITHOUT_TIP, false, null, false, 12, null)) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_SQUARE_POPUP_WINDOW_SOURCE, Integer.valueOf(source)));
            SquareEndInviteDialog squareEndInviteDialog = new SquareEndInviteDialog(context, false, R.string.xhc, R.string.xhb, R.string.xhe, SquareReportConst.CustomEventId.EVENT_ID_MULTI_ACTION_PUBLISH, mutableMapOf);
            squareEndInviteDialog.setPositiveCallback(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailDialogs$checkAndPublishMultiStatus$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    Function0.this.invoke();
                    if (z16) {
                        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.DetailMe.KEY_PUBLISH_WITHOUT_TIP, true, null, false, 12, null);
                    }
                }
            });
            squareEndInviteDialog.setNegativeCallback(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailDialogs$checkAndPublishMultiStatus$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    SquareBaseKt.getSquareLog().i("DetailDialogs", "user canceled publish multi action.");
                    Function0.this.invoke();
                }
            });
            squareEndInviteDialog.show();
            return;
        }
        onPublishAction.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkAndPublishMultiStatus$default(DetailDialogs detailDialogs, Context context, int i3, Function0 function0, Function0 function02, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            function02 = new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailDialogs$checkAndPublishMultiStatus$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        detailDialogs.checkAndPublishMultiStatus(context, i3, function0, function02);
    }
}
