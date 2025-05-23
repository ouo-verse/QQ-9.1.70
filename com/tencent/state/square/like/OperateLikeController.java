package com.tencent.state.square.like;

import android.view.View;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.flower.AddFlowerReason;
import com.tencent.state.square.flower.FlowerManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nJ\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/like/OperateLikeController;", "", "view", "Lcom/tencent/state/square/like/OperateLikePanel;", "(Lcom/tencent/state/square/like/OperateLikePanel;)V", "doingRequest", "", "service", "Lcom/tencent/state/square/like/LikeService;", "uin", "", "cancelLike", "", "type", "", "initData", IProfileProtocolConst.PARAM_TARGET_UIN, "like", "onItemClick", "itemView", "Landroid/view/View;", "itemType", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class OperateLikeController {
    private static final String TAG = "OperateLikeController";
    private boolean doingRequest;
    private final LikeService service;
    private long uin;
    private final OperateLikePanel view;

    public OperateLikeController(OperateLikePanel view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.service = new LikeService();
        this.uin = -1L;
    }

    public final void initData(long targetUin) {
        this.uin = targetUin;
        if (targetUin == -1) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "uin is -1, ignore", null, 4, null);
        }
    }

    public final void onItemClick(View itemView, int itemType) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        if (this.uin == -1 || this.doingRequest) {
            return;
        }
        if (itemView.isSelected()) {
            cancelLike(itemType);
        } else {
            like(itemType);
        }
    }

    private final void cancelLike(final int type) {
        this.doingRequest = true;
        this.view.cancelLikeType(type);
        FlowerManager.addFlower$default(FlowerManager.INSTANCE, String.valueOf(this.uin), AddFlowerReason.Like, 0, 4, null);
        this.service.likeStatus(this.uin, type, true, new Function1<LikeResult, Unit>() { // from class: com.tencent.state.square.like.OperateLikeController$cancelLike$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LikeResult likeResult) {
                invoke2(likeResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LikeResult result) {
                long j3;
                OperateLikePanel operateLikePanel;
                OperateLikePanel operateLikePanel2;
                OperateLikePanel operateLikePanel3;
                long j16;
                long j17;
                OperateLikePanel operateLikePanel4;
                Intrinsics.checkNotNullParameter(result, "result");
                FlowerManager flowerManager = FlowerManager.INSTANCE;
                j3 = OperateLikeController.this.uin;
                flowerManager.syncFlowerInfo(String.valueOf(j3));
                if (result.getErrorCode() != 0) {
                    operateLikePanel4 = OperateLikeController.this.view;
                    OperateLikePanel.setSelectLikeType$default(operateLikePanel4, type, false, false, 6, null);
                } else {
                    operateLikePanel = OperateLikeController.this.view;
                    Stickers stickers = operateLikePanel.getStickers();
                    if (stickers != null) {
                        stickers.unlike();
                        operateLikePanel2 = OperateLikeController.this.view;
                        operateLikePanel2.updateView();
                        operateLikePanel3 = OperateLikeController.this.view;
                        IStickersChangedListener callback = operateLikePanel3.getCallback();
                        if (callback != null) {
                            j16 = OperateLikeController.this.uin;
                            callback.onStickersChanged(String.valueOf(j16), stickers);
                        }
                    }
                }
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                j17 = OperateLikeController.this.uin;
                sb5.append(j17);
                sb5.append(" cancel like result: ");
                sb5.append(result);
                squareLog.i("OperateLikeController", sb5.toString());
                OperateLikeController.this.doingRequest = false;
            }
        });
    }

    private final void like(final int type) {
        this.doingRequest = true;
        final int currentSelectedType = this.view.getCurrentSelectedType();
        this.view.setSelectLikeType(type, true, true);
        FlowerManager.addFlower$default(FlowerManager.INSTANCE, String.valueOf(this.uin), AddFlowerReason.Like, 0, 4, null);
        this.service.likeStatus(this.uin, type, false, new Function1<LikeResult, Unit>() { // from class: com.tencent.state.square.like.OperateLikeController$like$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LikeResult likeResult) {
                invoke2(likeResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LikeResult result) {
                long j3;
                OperateLikePanel operateLikePanel;
                Map<String, Object> mutableMapOf;
                OperateLikePanel operateLikePanel2;
                OperateLikePanel operateLikePanel3;
                long j16;
                long j17;
                OperateLikePanel operateLikePanel4;
                OperateLikePanel operateLikePanel5;
                OperateLikePanel operateLikePanel6;
                OperateLikePanel operateLikePanel7;
                OperateLikePanel operateLikePanel8;
                long j18;
                OperateLikePanel operateLikePanel9;
                OperateLikePanel operateLikePanel10;
                Intrinsics.checkNotNullParameter(result, "result");
                FlowerManager flowerManager = FlowerManager.INSTANCE;
                j3 = OperateLikeController.this.uin;
                flowerManager.syncFlowerInfo(String.valueOf(j3));
                if (result.getErrorCode() == 0) {
                    operateLikePanel = OperateLikeController.this.view;
                    Stickers stickers = operateLikePanel.getStickers();
                    if (stickers != null) {
                        stickers.like(type);
                        operateLikePanel2 = OperateLikeController.this.view;
                        operateLikePanel2.updateView();
                        operateLikePanel3 = OperateLikeController.this.view;
                        IStickersChangedListener callback = operateLikePanel3.getCallback();
                        if (callback != null) {
                            j16 = OperateLikeController.this.uin;
                            callback.onStickersChanged(String.valueOf(j16), stickers);
                        }
                    }
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_SOURCE, 1));
                    squareReporter.reportEvent("ev_zplan_dynamic_square_status_like", mutableMapOf);
                } else if (currentSelectedType != -1) {
                    operateLikePanel10 = OperateLikeController.this.view;
                    OperateLikePanel.setSelectLikeType$default(operateLikePanel10, currentSelectedType, false, false, 6, null);
                } else {
                    operateLikePanel4 = OperateLikeController.this.view;
                    operateLikePanel4.cancelLikeType(type);
                    operateLikePanel5 = OperateLikeController.this.view;
                    if (operateLikePanel5.getStickers() != null) {
                        operateLikePanel6 = OperateLikeController.this.view;
                        operateLikePanel6.getStickers().unlike();
                        operateLikePanel7 = OperateLikeController.this.view;
                        operateLikePanel7.updateView();
                        operateLikePanel8 = OperateLikeController.this.view;
                        IStickersChangedListener callback2 = operateLikePanel8.getCallback();
                        if (callback2 != null) {
                            j18 = OperateLikeController.this.uin;
                            String valueOf = String.valueOf(j18);
                            operateLikePanel9 = OperateLikeController.this.view;
                            callback2.onStickersChanged(valueOf, operateLikePanel9.getStickers());
                        }
                    }
                }
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                j17 = OperateLikeController.this.uin;
                sb5.append(j17);
                sb5.append(" like result: ");
                sb5.append(result);
                squareLog.i("OperateLikeController", sb5.toString());
                OperateLikeController.this.doingRequest = false;
            }
        });
    }
}
