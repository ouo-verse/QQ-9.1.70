package com.tencent.mobileqq.zplan.aigc.helper;

import android.view.ViewGroup;
import com.tencent.mobileqq.zplan.aigc.view.dialog.UGCPickColorDialogView;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import qu4.p;
import w74.UgcColorInfoData;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper$initAvatarPanelChannel$1$onModifyColorInfo$1", f = "ZplanUgcDyeingDialogHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class ZplanUgcDyeingDialogHelper$initAvatarPanelChannel$1$onModifyColorInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $addToHistory;
    final /* synthetic */ qu4.c $colorInfo;
    final /* synthetic */ ViewGroup $container;
    final /* synthetic */ int $slotId;
    int label;
    final /* synthetic */ ZplanUgcDyeingDialogHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanUgcDyeingDialogHelper$initAvatarPanelChannel$1$onModifyColorInfo$1(ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper, qu4.c cVar, int i3, boolean z16, ViewGroup viewGroup, Continuation<? super ZplanUgcDyeingDialogHelper$initAvatarPanelChannel$1$onModifyColorInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = zplanUgcDyeingDialogHelper;
        this.$colorInfo = cVar;
        this.$slotId = i3;
        this.$addToHistory = z16;
        this.$container = viewGroup;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZplanUgcDyeingDialogHelper$initAvatarPanelChannel$1$onModifyColorInfo$1(this.this$0, this.$colorInfo, this.$slotId, this.$addToHistory, this.$container, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i3;
        int i16;
        int i17;
        int i18;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i(this.this$0.TAG, 1, "onModifyColorInfo begin");
            qu4.d[] slotArr = this.$colorInfo.f429581b;
            Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
            int i19 = this.$slotId;
            boolean z16 = this.$addToHistory;
            ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper = this.this$0;
            ViewGroup viewGroup = this.$container;
            for (qu4.d dVar : slotArr) {
                if (dVar.f429583a == i19) {
                    if (z16) {
                        g colorEditHistoryHelper = zplanUgcDyeingDialogHelper.getColorEditHistoryHelper();
                        p pVar = dVar.f429585c;
                        Intrinsics.checkNotNullExpressionValue(pVar, "colorSlotInfo.singleColor");
                        i17 = zplanUgcDyeingDialogHelper.circleItemIndex;
                        if (colorEditHistoryHelper.n(pVar, i17)) {
                            UGCPickColorDialogView uGCPickColorDialogView = zplanUgcDyeingDialogHelper.pickColorDialog;
                            if (uGCPickColorDialogView != null) {
                                uGCPickColorDialogView.T(true);
                            }
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            i18 = zplanUgcDyeingDialogHelper.circleItemIndex;
                            linkedHashMap.put("color_block_id", Boxing.boxInt(i18));
                            zplanUgcDyeingDialogHelper.dtReporter.t(viewGroup, "em_zplan_dyeing_operation_panel", linkedHashMap);
                        }
                    }
                    UgcColorInfoData c16 = zplanUgcDyeingDialogHelper.getColorEditHistoryHelper().c();
                    if (c16 != null) {
                        if (!z16) {
                            i3 = zplanUgcDyeingDialogHelper.circleItemIndex;
                            if (i3 >= 0) {
                                ArrayList<p> b16 = c16.b();
                                i16 = zplanUgcDyeingDialogHelper.circleItemIndex;
                                b16.set(i16, dVar.f429585c);
                            }
                        }
                        SuitCustomColorVewModel.A3(zplanUgcDyeingDialogHelper.vm, c16.b(), zplanUgcDyeingDialogHelper.filamentRender, null, 4, null);
                    }
                    p pVar2 = dVar.f429585c;
                    Intrinsics.checkNotNullExpressionValue(pVar2, "colorSlotInfo.singleColor");
                    zplanUgcDyeingDialogHelper.currentColor = pVar2;
                    QLog.i(zplanUgcDyeingDialogHelper.TAG, 1, "onModifyColorInfo end color: " + dVar.f429585c.f429637b);
                    return Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZplanUgcDyeingDialogHelper$initAvatarPanelChannel$1$onModifyColorInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
