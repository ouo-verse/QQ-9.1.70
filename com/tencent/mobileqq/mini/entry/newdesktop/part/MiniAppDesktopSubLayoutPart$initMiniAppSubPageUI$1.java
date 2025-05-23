package com.tencent.mobileqq.mini.entry.newdesktop.part;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopIntent;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopEffect;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopSubLayoutPart$initMiniAppSubPageUI$1", f = "MiniAppDesktopSubLayoutPart.kt", i = {}, l = {613}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppDesktopSubLayoutPart$initMiniAppSubPageUI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppDesktopSubLayoutPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppDesktopSubLayoutPart$initMiniAppSubPageUI$1(MiniAppDesktopSubLayoutPart miniAppDesktopSubLayoutPart, Continuation<? super MiniAppDesktopSubLayoutPart$initMiniAppSubPageUI$1> continuation) {
        super(2, continuation);
        this.this$0 = miniAppDesktopSubLayoutPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppDesktopSubLayoutPart$initMiniAppSubPageUI$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<MiniAppDesktopEffect> effect = this.this$0.getMMiniAppDesktopViewModel().getEffect();
            final MiniAppDesktopSubLayoutPart miniAppDesktopSubLayoutPart = this.this$0;
            FlowCollector<MiniAppDesktopEffect> flowCollector = new FlowCollector<MiniAppDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopSubLayoutPart$initMiniAppSubPageUI$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(MiniAppDesktopEffect miniAppDesktopEffect, Continuation<? super Unit> continuation) {
                    ArrayList arrayList;
                    int findIndexFromMineRv;
                    int i16;
                    Object coroutine_suspended2;
                    ArrayList arrayList2;
                    int findIndexFromMineRv2;
                    Object coroutine_suspended3;
                    MiniAppDesktopEffect miniAppDesktopEffect2 = miniAppDesktopEffect;
                    if (miniAppDesktopEffect2 instanceof MiniAppDesktopEffect.OnBottomPartDragDropAdd) {
                        MiniAppDesktopSubLayoutPart miniAppDesktopSubLayoutPart2 = MiniAppDesktopSubLayoutPart.this;
                        MiniAppDesktopEffect.OnBottomPartDragDropAdd onBottomPartDragDropAdd = (MiniAppDesktopEffect.OnBottomPartDragDropAdd) miniAppDesktopEffect2;
                        DesktopAppInfo fromMiniAppInfo = onBottomPartDragDropAdd.getFromMiniAppInfo();
                        arrayList2 = MiniAppDesktopSubLayoutPart.this.mSubLayoutRvDataList;
                        findIndexFromMineRv2 = miniAppDesktopSubLayoutPart2.findIndexFromMineRv(fromMiniAppInfo, arrayList2);
                        if (findIndexFromMineRv2 != -1) {
                            Object sendUserIntent = MiniAppDesktopSubLayoutPart.this.getMMiniAppDesktopViewModel().sendUserIntent(new MiniAppDeskTopIntent.InsertMyMiniApp(onBottomPartDragDropAdd.getFromMiniAppInfo(), 0), continuation);
                            coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (sendUserIntent == coroutine_suspended3) {
                                return sendUserIntent;
                            }
                        }
                    } else if (miniAppDesktopEffect2 instanceof MiniAppDesktopEffect.OnBottomPartDragDropDelete) {
                        MiniAppDesktopEffect.OnBottomPartDragDropDelete onBottomPartDragDropDelete = (MiniAppDesktopEffect.OnBottomPartDragDropDelete) miniAppDesktopEffect2;
                        if (onBottomPartDragDropDelete.getReceiveViewId() == R.id.rcw && onBottomPartDragDropDelete.getStartDragViewId() == R.id.rfb) {
                            MiniAppDesktopSubLayoutPart miniAppDesktopSubLayoutPart3 = MiniAppDesktopSubLayoutPart.this;
                            DesktopAppInfo fromMiniAppInfo2 = onBottomPartDragDropDelete.getFromMiniAppInfo();
                            arrayList = MiniAppDesktopSubLayoutPart.this.mSubLayoutRvDataList;
                            findIndexFromMineRv = miniAppDesktopSubLayoutPart3.findIndexFromMineRv(fromMiniAppInfo2, arrayList);
                            if (findIndexFromMineRv != -1) {
                                MiniAppDeskTopViewModel mMiniAppDesktopViewModel = MiniAppDesktopSubLayoutPart.this.getMMiniAppDesktopViewModel();
                                DesktopAppInfo fromMiniAppInfo3 = onBottomPartDragDropDelete.getFromMiniAppInfo();
                                i16 = MiniAppDesktopSubLayoutPart.this.mType;
                                Object sendUserIntent2 = mMiniAppDesktopViewModel.sendUserIntent(new MiniAppDeskTopIntent.DeleteDesktopMiniApp(fromMiniAppInfo3, i16), continuation);
                                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (sendUserIntent2 == coroutine_suspended2) {
                                    return sendUserIntent2;
                                }
                            }
                        }
                    } else if (miniAppDesktopEffect2 instanceof MiniAppDesktopEffect.SetSubLayoutDesktopDataList) {
                        MiniAppDesktopSubLayoutPart miniAppDesktopSubLayoutPart4 = MiniAppDesktopSubLayoutPart.this;
                        miniAppDesktopSubLayoutPart4.openSubLayout(miniAppDesktopSubLayoutPart4.getPartRootView(), (MiniAppDesktopEffect.SetSubLayoutDesktopDataList) miniAppDesktopEffect2);
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (effect.collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniAppDesktopSubLayoutPart$initMiniAppSubPageUI$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
