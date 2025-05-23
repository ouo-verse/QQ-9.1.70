package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXH;
import com.tencent.hippykotlin.demo.pages.vas_base.report.VasCommonReportProxy;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$batchSetBackgroundPhoto$1", f = "UploadBackgroundPage.kt", i = {0, 0, 1, 1}, l = {512, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_MULTI_NETWORK_CARD_STATUS_CHANGE, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_SURFACE_DESTROYED_ASYNC_RESOURCE_RELEASED}, m = "invokeSuspend", n = {"$this$async", "report", "$this$async", "report"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes33.dex */
public final class UpLoadBackgroundPage$batchSetBackgroundPhoto$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ UpLoadBackgroundPage $ctx;
    public final /* synthetic */ com.tencent.kuikly.core.nvi.serialization.json.b $friendArray;
    public /* synthetic */ Object L$0;
    public Function2 L$1;
    public int label;
    public final /* synthetic */ UpLoadBackgroundPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpLoadBackgroundPage$batchSetBackgroundPhoto$1(UpLoadBackgroundPage upLoadBackgroundPage, com.tencent.kuikly.core.nvi.serialization.json.b bVar, UpLoadBackgroundPage upLoadBackgroundPage2, Continuation<? super UpLoadBackgroundPage$batchSetBackgroundPhoto$1> continuation) {
        super(2, continuation);
        this.$ctx = upLoadBackgroundPage;
        this.$friendArray = bVar;
        this.this$0 = upLoadBackgroundPage2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UpLoadBackgroundPage$batchSetBackgroundPhoto$1 upLoadBackgroundPage$batchSetBackgroundPhoto$1 = new UpLoadBackgroundPage$batchSetBackgroundPhoto$1(this.$ctx, this.$friendArray, this.this$0, continuation);
        upLoadBackgroundPage$batchSetBackgroundPhoto$1.L$0 = obj;
        return upLoadBackgroundPage$batchSetBackgroundPhoto$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((UpLoadBackgroundPage$batchSetBackgroundPhoto$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0145  */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.tencent.kuikly.core.nvi.serialization.json.e] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Function2 function2;
        int intValue;
        b bVar;
        b bVar2;
        GXH.Result result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            b bVar3 = (b) this.L$0;
            final long currentTimeStamp = VasBasePage.Companion.getCtx().platformApi.getCoreModule().currentTimeStamp();
            function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$batchSetBackgroundPhoto$1$report$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str) {
                    int intValue2 = num.intValue();
                    String str2 = str;
                    VasBasePage.Companion companion = VasBasePage.Companion;
                    VasCommonReportProxy newVasCommonReport = companion.getCtx().newVasCommonReport("set_uoload_bg");
                    newVasCommonReport.num1 = intValue2;
                    newVasCommonReport.num2 = companion.getCtx().platformApi.getCoreModule().currentTimeStamp() - currentTimeStamp;
                    if (str2 != null) {
                        newVasCommonReport.value1 = str2;
                    }
                    newVasCommonReport.report(false);
                    return Unit.INSTANCE;
                }
            };
            UploadBackgroundRequest uploadBackgroundRequest = new UploadBackgroundRequest();
            UpLoadBackgroundPage upLoadBackgroundPage = this.$ctx;
            com.tencent.kuikly.core.nvi.serialization.json.b bVar4 = this.$friendArray;
            intValue = ((Number) upLoadBackgroundPage.selectedEffectItemID$delegate.getValue(upLoadBackgroundPage, UpLoadBackgroundPage.$$delegatedProperties[0])).intValue();
            this.L$0 = bVar3;
            this.L$1 = function2;
            this.label = 1;
            Object batchSetBackgroundPhoto = uploadBackgroundRequest.batchSetBackgroundPhoto(upLoadBackgroundPage, bVar4, intValue, this);
            if (batchSetBackgroundPhoto == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = bVar3;
            obj = batchSetBackgroundPhoto;
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        BridgeModule.closePage$default(this.$ctx.platformApi.getCoreModule(), null, null, 3);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function2 = this.L$1;
                bVar2 = (b) this.L$0;
                ResultKt.throwOnFailure(obj);
                result = (GXH.Result) obj;
                if (result.result != 0) {
                    function2.invoke(Boxing.boxInt(0), "success");
                    this.$ctx.platformApi.getCoreModule().qToast("\u8bbe\u7f6e\u6210\u529f", QToastMode.Success);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    if (BuildersKt.c(bVar2, 1000, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    BridgeModule.closePage$default(this.$ctx.platformApi.getCoreModule(), null, null, 3);
                    return Unit.INSTANCE;
                }
                function2.invoke(Boxing.boxInt(2), result + ':' + result.message);
                this.$ctx.platformApi.getCoreModule().qToast("\u8bbe\u7f6e\u5931\u8d25 \u9519\u8bef\u7801:" + result, QToastMode.Warning);
                return Unit.INSTANCE;
            }
            function2 = this.L$1;
            bVar = (b) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Pair pair = (Pair) obj;
        if (((Boolean) pair.getFirst()).booleanValue()) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? access$getSelectImageArea = UpLoadBackgroundPage.access$getSelectImageArea(this.this$0);
            objectRef.element = access$getSelectImageArea;
            if (access$getSelectImageArea.d() == 0) {
                function2.invoke(Boxing.boxInt(3), "invalid rect");
            } else {
                final com.tencent.kuikly.core.nvi.serialization.json.b bVar5 = this.$friendArray;
                final UpLoadBackgroundPage upLoadBackgroundPage2 = this.$ctx;
                ((e) objectRef.element).v("batchSet", new com.tencent.kuikly.core.nvi.serialization.json.b(new Function1<com.tencent.kuikly.core.nvi.serialization.json.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$batchSetBackgroundPhoto$1$jsonArray$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.b bVar6) {
                        int intValue2;
                        com.tencent.kuikly.core.nvi.serialization.json.b bVar7 = bVar6;
                        int c16 = com.tencent.kuikly.core.nvi.serialization.json.b.this.c();
                        for (int i16 = 0; i16 < c16; i16++) {
                            e eVar = new e();
                            e l3 = com.tencent.kuikly.core.nvi.serialization.json.b.this.l(i16);
                            if (l3 != null) {
                                UpLoadBackgroundPage upLoadBackgroundPage3 = upLoadBackgroundPage2;
                                Ref.ObjectRef<e> objectRef2 = objectRef;
                                eVar.v("uin", l3.p("uin"));
                                eVar.t("type", l3.j("type"));
                                intValue2 = ((Number) upLoadBackgroundPage3.selectedEffectItemID$delegate.getValue(upLoadBackgroundPage3, UpLoadBackgroundPage.$$delegatedProperties[0])).intValue();
                                eVar.t("effectId", intValue2);
                                if (i16 == 0) {
                                    objectRef2.element.v("friendUin", l3.p("uin"));
                                    objectRef2.element.t("uinType", l3.j("type"));
                                }
                            }
                            bVar7.a(bVar7, eVar);
                        }
                        return Unit.INSTANCE;
                    }
                }));
                e eVar = (e) objectRef.element;
                String str = this.$ctx.imageUrlEncode;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageUrlEncode");
                    str = null;
                }
                eVar.v("imagePath", str);
                UpLoadBackgroundPage upLoadBackgroundPage3 = this.$ctx;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("batchSetBackgroundPhoto local set json\uff1a ");
                m3.append(objectRef.element);
                KLog.INSTANCE.i(upLoadBackgroundPage3.getPageName(), m3.toString());
                GXH gxh = (GXH) this.$ctx.platformApi.getVasModule().$$delegate_2.gxh$delegate.getValue();
                e eVar2 = (e) objectRef.element;
                this.L$0 = bVar;
                this.L$1 = function2;
                this.label = 2;
                obj = gxh.batchSetCustomBg(eVar2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bVar2 = bVar;
                result = (GXH.Result) obj;
                if (result.result != 0) {
                }
            }
        } else {
            function2.invoke(Boxing.boxInt(1), pair.getSecond());
            this.$ctx.platformApi.getCoreModule().qToast("\u670d\u52a1\u65e0\u54cd\u5e94", QToastMode.Warning);
        }
        return Unit.INSTANCE;
    }
}
