package com.tencent.sqshow.zootopia.nativeui.view.customerface;

import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$PinchFaceUiInfo;
import com.tencent.image.URLImageView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import n74.bp;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.nativeui.view.customerface.ZPlanPinchFaceFragment$showUiInfo$1", f = "ZPlanPinchFaceFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanPinchFaceFragment$showUiInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PinchFaceEvent$PinchFaceUiInfo $uiInfo;
    int label;
    final /* synthetic */ ZPlanPinchFaceFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanPinchFaceFragment$showUiInfo$1(ZPlanPinchFaceFragment zPlanPinchFaceFragment, PinchFaceEvent$PinchFaceUiInfo pinchFaceEvent$PinchFaceUiInfo, Continuation<? super ZPlanPinchFaceFragment$showUiInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanPinchFaceFragment;
        this.$uiInfo = pinchFaceEvent$PinchFaceUiInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanPinchFaceFragment$showUiInfo$1(this.this$0, this.$uiInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Map map;
        bp bpVar;
        bp bpVar2;
        Map map2;
        bp bpVar3;
        bp bpVar4;
        Map map3;
        bp bpVar5;
        bp bpVar6;
        Map map4;
        bp bpVar7;
        bp bpVar8;
        Map map5;
        bp bpVar9;
        bp bpVar10;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanPinchFaceFragment zPlanPinchFaceFragment = this.this$0;
            String str = this.$uiInfo.cp_name.get();
            Intrinsics.checkNotNullExpressionValue(str, "uiInfo.cp_name.get()");
            zPlanPinchFaceFragment.hi(str);
            this.this$0.bi(this.$uiInfo.can_undo.get());
            this.this$0.ai(this.$uiInfo.can_redo.get());
            int i3 = this.$uiInfo.select_point.get();
            bp bpVar11 = null;
            if (i3 == 0) {
                map = this.this$0.selectedImageUrls;
                if (map == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedImageUrls");
                    map = null;
                }
                bpVar = this.this$0.binding;
                if (bpVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bpVar = null;
                }
                String str2 = (String) map.get(bpVar.f418882h);
                if (str2 != null) {
                    ZPlanPinchFaceFragment zPlanPinchFaceFragment2 = this.this$0;
                    bpVar2 = zPlanPinchFaceFragment2.binding;
                    if (bpVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        bpVar11 = bpVar2;
                    }
                    URLImageView uRLImageView = bpVar11.f418882h;
                    Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.pinchFaceFaceIcon");
                    zPlanPinchFaceFragment2.gi(uRLImageView, str2);
                }
            } else if (i3 == 1) {
                map2 = this.this$0.selectedImageUrls;
                if (map2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedImageUrls");
                    map2 = null;
                }
                bpVar3 = this.this$0.binding;
                if (bpVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bpVar3 = null;
                }
                String str3 = (String) map2.get(bpVar3.f418881g);
                if (str3 != null) {
                    ZPlanPinchFaceFragment zPlanPinchFaceFragment3 = this.this$0;
                    bpVar4 = zPlanPinchFaceFragment3.binding;
                    if (bpVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        bpVar11 = bpVar4;
                    }
                    URLImageView uRLImageView2 = bpVar11.f418881g;
                    Intrinsics.checkNotNullExpressionValue(uRLImageView2, "binding.pinchFaceEyebrowIcon");
                    zPlanPinchFaceFragment3.gi(uRLImageView2, str3);
                }
            } else if (i3 == 2) {
                map3 = this.this$0.selectedImageUrls;
                if (map3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedImageUrls");
                    map3 = null;
                }
                bpVar5 = this.this$0.binding;
                if (bpVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bpVar5 = null;
                }
                String str4 = (String) map3.get(bpVar5.f418880f);
                if (str4 != null) {
                    ZPlanPinchFaceFragment zPlanPinchFaceFragment4 = this.this$0;
                    bpVar6 = zPlanPinchFaceFragment4.binding;
                    if (bpVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        bpVar11 = bpVar6;
                    }
                    URLImageView uRLImageView3 = bpVar11.f418880f;
                    Intrinsics.checkNotNullExpressionValue(uRLImageView3, "binding.pinchFaceEyeIcon");
                    zPlanPinchFaceFragment4.gi(uRLImageView3, str4);
                }
            } else if (i3 == 3) {
                map4 = this.this$0.selectedImageUrls;
                if (map4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedImageUrls");
                    map4 = null;
                }
                bpVar7 = this.this$0.binding;
                if (bpVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bpVar7 = null;
                }
                String str5 = (String) map4.get(bpVar7.f418883i);
                if (str5 != null) {
                    ZPlanPinchFaceFragment zPlanPinchFaceFragment5 = this.this$0;
                    bpVar8 = zPlanPinchFaceFragment5.binding;
                    if (bpVar8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        bpVar11 = bpVar8;
                    }
                    URLImageView uRLImageView4 = bpVar11.f418883i;
                    Intrinsics.checkNotNullExpressionValue(uRLImageView4, "binding.pinchFaceMouthIcon");
                    zPlanPinchFaceFragment5.gi(uRLImageView4, str5);
                }
            } else if (i3 == 4) {
                map5 = this.this$0.selectedImageUrls;
                if (map5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedImageUrls");
                    map5 = null;
                }
                bpVar9 = this.this$0.binding;
                if (bpVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bpVar9 = null;
                }
                String str6 = (String) map5.get(bpVar9.f418884j);
                if (str6 != null) {
                    ZPlanPinchFaceFragment zPlanPinchFaceFragment6 = this.this$0;
                    bpVar10 = zPlanPinchFaceFragment6.binding;
                    if (bpVar10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        bpVar11 = bpVar10;
                    }
                    URLImageView uRLImageView5 = bpVar11.f418884j;
                    Intrinsics.checkNotNullExpressionValue(uRLImageView5, "binding.pinchFaceNoseIcon");
                    zPlanPinchFaceFragment6.gi(uRLImageView5, str6);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanPinchFaceFragment$showUiInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
