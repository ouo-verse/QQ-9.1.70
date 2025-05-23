package com.tencent.mobileqq.zplan.minihome;

import com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper;
import com.tencent.mobileqq.zplan.minihome.data.DecorateMode;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.util.QQToastUtil;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$doRequestSaveRoom$1", f = "EditMiniHomeFragment.kt", i = {1, 2}, l = {1427, 1434, 1434}, m = "invokeSuspend", n = {"roomHash", "roomHash"}, s = {"L$0", "L$0"})
/* loaded from: classes34.dex */
public final class EditMiniHomeFragment$doRequestSaveRoom$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isBuy;
    final /* synthetic */ byte[] $output;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ EditMiniHomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditMiniHomeFragment$doRequestSaveRoom$1(EditMiniHomeFragment editMiniHomeFragment, byte[] bArr, boolean z16, Continuation<? super EditMiniHomeFragment$doRequestSaveRoom$1> continuation) {
        super(2, continuation);
        this.this$0 = editMiniHomeFragment;
        this.$output = bArr;
        this.$isBuy = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditMiniHomeFragment$doRequestSaveRoom$1(this.this$0, this.$output, this.$isBuy, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0091, code lost:
    
        r1 = r10.this$0.sampleRoomSource;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean Ui;
        final String str;
        int i3;
        DecorateMode decorateMode;
        MutableStateFlow mutableStateFlow;
        String str2;
        String str3;
        y Ji;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("EditMiniHomeFragment", 1, "start requestGetCandidateList");
            Ui = this.this$0.Ui();
            if (!Ui) {
                return Unit.INSTANCE;
            }
            byte[] bArr = this.$output;
            this.label = 1;
            obj = MiniHomeNetworkKt.m(bArr, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        str3 = (String) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        str = str3;
                        Ji = this.this$0.Ji();
                        final EditMiniHomeFragment editMiniHomeFragment = this.this$0;
                        final boolean z16 = this.$isBuy;
                        Ji.n(true, new IMiniHomeMessageCallback() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$doRequestSaveRoom$1.1
                            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
                            public void onMiniHomeMessage(String dataJson) {
                                AtomicBoolean atomicBoolean;
                                int i17;
                                QLog.i("EditMiniHomeFragment", 1, "getRoomConfig complete, onMiniHomeLoadResult " + dataJson);
                                if (dataJson == null) {
                                    return;
                                }
                                atomicBoolean = EditMiniHomeFragment.this.hasEdited;
                                atomicBoolean.set(false);
                                String roomHash = str;
                                Intrinsics.checkNotNullExpressionValue(roomHash, "roomHash");
                                ao aoVar = new ao(roomHash, "", "", dataJson);
                                QLog.i("EditMiniHomeFragment", 1, "save roomDesc: " + aoVar);
                                EditMiniHomeFragment.this.xj(aoVar);
                                EditMiniHomeFragment editMiniHomeFragment2 = EditMiniHomeFragment.this;
                                i17 = editMiniHomeFragment2.curTotalPrice;
                                editMiniHomeFragment2.Ei(aoVar, i17 > 0);
                                ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).setTemporaryRoomDesc(String.valueOf(bb.f335811a.e()), aoVar);
                                final EditMiniHomeFragment editMiniHomeFragment3 = EditMiniHomeFragment.this;
                                final boolean z17 = z16;
                                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$doRequestSaveRoom$1$1$onMiniHomeMessage$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        DecorateMode decorateMode2;
                                        ConcurrentHashMap concurrentHashMap;
                                        decorateMode2 = EditMiniHomeFragment.this.decorateMode;
                                        if (decorateMode2 != DecorateMode.SAMPLE_ROOM) {
                                            concurrentHashMap = EditMiniHomeFragment.this.curSelectedFurnitureMap;
                                            concurrentHashMap.clear();
                                            EditMiniHomeFragment.this.curTotalNum = 0;
                                            EditMiniHomeFragment.this.curTotalPrice = 0;
                                            EditMiniHomeFragment.this.Aj("\u5b8c\u6210");
                                            EditMiniHomeFragment.this.uj();
                                            return;
                                        }
                                        if (!z17) {
                                            QQToastUtil.showQQToast(2, "\u88c5\u4fee\u5b8c\u6210");
                                        }
                                        EditMiniHomeFragment.this.onBackEvent();
                                    }
                                });
                            }
                        });
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableStateFlow = (MutableStateFlow) this.L$1;
                str2 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = str2;
                this.L$1 = null;
                this.label = 3;
                if (mutableStateFlow.emit(obj, this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                str3 = str2;
                str = str3;
                Ji = this.this$0.Ji();
                final EditMiniHomeFragment editMiniHomeFragment2 = this.this$0;
                final boolean z162 = this.$isBuy;
                Ji.n(true, new IMiniHomeMessageCallback() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$doRequestSaveRoom$1.1
                    @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
                    public void onMiniHomeMessage(String dataJson) {
                        AtomicBoolean atomicBoolean;
                        int i17;
                        QLog.i("EditMiniHomeFragment", 1, "getRoomConfig complete, onMiniHomeLoadResult " + dataJson);
                        if (dataJson == null) {
                            return;
                        }
                        atomicBoolean = EditMiniHomeFragment.this.hasEdited;
                        atomicBoolean.set(false);
                        String roomHash = str;
                        Intrinsics.checkNotNullExpressionValue(roomHash, "roomHash");
                        ao aoVar = new ao(roomHash, "", "", dataJson);
                        QLog.i("EditMiniHomeFragment", 1, "save roomDesc: " + aoVar);
                        EditMiniHomeFragment.this.xj(aoVar);
                        EditMiniHomeFragment editMiniHomeFragment22 = EditMiniHomeFragment.this;
                        i17 = editMiniHomeFragment22.curTotalPrice;
                        editMiniHomeFragment22.Ei(aoVar, i17 > 0);
                        ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).setTemporaryRoomDesc(String.valueOf(bb.f335811a.e()), aoVar);
                        final EditMiniHomeFragment editMiniHomeFragment3 = EditMiniHomeFragment.this;
                        final boolean z17 = z162;
                        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$doRequestSaveRoom$1$1$onMiniHomeMessage$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                DecorateMode decorateMode2;
                                ConcurrentHashMap concurrentHashMap;
                                decorateMode2 = EditMiniHomeFragment.this.decorateMode;
                                if (decorateMode2 != DecorateMode.SAMPLE_ROOM) {
                                    concurrentHashMap = EditMiniHomeFragment.this.curSelectedFurnitureMap;
                                    concurrentHashMap.clear();
                                    EditMiniHomeFragment.this.curTotalNum = 0;
                                    EditMiniHomeFragment.this.curTotalPrice = 0;
                                    EditMiniHomeFragment.this.Aj("\u5b8c\u6210");
                                    EditMiniHomeFragment.this.uj();
                                    return;
                                }
                                if (!z17) {
                                    QQToastUtil.showQQToast(2, "\u88c5\u4fee\u5b8c\u6210");
                                }
                                EditMiniHomeFragment.this.onBackEvent();
                            }
                        });
                    }
                });
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        m55.d dVar = (m55.d) obj;
        int i17 = dVar.f416287a;
        String str4 = dVar.f416288b;
        str = dVar.f416289c;
        QLog.i("EditMiniHomeFragment", 1, "requestUpdateMinihome, errorCode: " + i17 + ", errMsg: " + str4 + ", roomHash: " + str);
        if (i17 == 0) {
            decorateMode = this.this$0.decorateMode;
            if (decorateMode == DecorateMode.FURNITURE && mutableStateFlow != null) {
                this.L$0 = str;
                this.L$1 = mutableStateFlow;
                this.label = 2;
                Object f16 = MiniHomeNetworkKt.f(1, this);
                if (f16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str2 = str;
                obj = f16;
                this.L$0 = str2;
                this.L$1 = null;
                this.label = 3;
                if (mutableStateFlow.emit(obj, this) != coroutine_suspended) {
                }
            }
            Ji = this.this$0.Ji();
            final EditMiniHomeFragment editMiniHomeFragment22 = this.this$0;
            final boolean z1622 = this.$isBuy;
            Ji.n(true, new IMiniHomeMessageCallback() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$doRequestSaveRoom$1.1
                @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
                public void onMiniHomeMessage(String dataJson) {
                    AtomicBoolean atomicBoolean;
                    int i172;
                    QLog.i("EditMiniHomeFragment", 1, "getRoomConfig complete, onMiniHomeLoadResult " + dataJson);
                    if (dataJson == null) {
                        return;
                    }
                    atomicBoolean = EditMiniHomeFragment.this.hasEdited;
                    atomicBoolean.set(false);
                    String roomHash = str;
                    Intrinsics.checkNotNullExpressionValue(roomHash, "roomHash");
                    ao aoVar = new ao(roomHash, "", "", dataJson);
                    QLog.i("EditMiniHomeFragment", 1, "save roomDesc: " + aoVar);
                    EditMiniHomeFragment.this.xj(aoVar);
                    EditMiniHomeFragment editMiniHomeFragment222 = EditMiniHomeFragment.this;
                    i172 = editMiniHomeFragment222.curTotalPrice;
                    editMiniHomeFragment222.Ei(aoVar, i172 > 0);
                    ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).setTemporaryRoomDesc(String.valueOf(bb.f335811a.e()), aoVar);
                    final EditMiniHomeFragment editMiniHomeFragment3 = EditMiniHomeFragment.this;
                    final boolean z17 = z1622;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$doRequestSaveRoom$1$1$onMiniHomeMessage$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            DecorateMode decorateMode2;
                            ConcurrentHashMap concurrentHashMap;
                            decorateMode2 = EditMiniHomeFragment.this.decorateMode;
                            if (decorateMode2 != DecorateMode.SAMPLE_ROOM) {
                                concurrentHashMap = EditMiniHomeFragment.this.curSelectedFurnitureMap;
                                concurrentHashMap.clear();
                                EditMiniHomeFragment.this.curTotalNum = 0;
                                EditMiniHomeFragment.this.curTotalPrice = 0;
                                EditMiniHomeFragment.this.Aj("\u5b8c\u6210");
                                EditMiniHomeFragment.this.uj();
                                return;
                            }
                            if (!z17) {
                                QQToastUtil.showQQToast(2, "\u88c5\u4fee\u5b8c\u6210");
                            }
                            EditMiniHomeFragment.this.onBackEvent();
                        }
                    });
                }
            });
            return Unit.INSTANCE;
        }
        QQToastUtil.showQQToastInUiThread(1, "\u4fdd\u5b58\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
        EditMiniHomeFragment editMiniHomeFragment3 = this.this$0;
        i3 = editMiniHomeFragment3.curTotalPrice;
        editMiniHomeFragment3.hj("clck", "", i3 > 0);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EditMiniHomeFragment$doRequestSaveRoom$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
