package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXH;
import com.tencent.hippykotlin.demo.pages.vas_base.report.VasCommonReportProxy;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.List;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$singleSetBackgroundPhoto$1", f = "UploadBackgroundPage.kt", i = {0, 0}, l = {428, 444}, m = "invokeSuspend", n = {"$this$async", "report"}, s = {"L$0", "L$1"})
/* loaded from: classes33.dex */
public final class UpLoadBackgroundPage$singleSetBackgroundPhoto$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ UpLoadBackgroundPage $ctx;
    public /* synthetic */ Object L$0;
    public UpLoadBackgroundPage$singleSetBackgroundPhoto$1$report$1 L$1;
    public int label;
    public final /* synthetic */ UpLoadBackgroundPage this$0;

    @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$singleSetBackgroundPhoto$1$1", f = "UploadBackgroundPage.kt", i = {}, l = {NotificationUtil.Constants.NOTIFY_ID_MSF_PUSH_AVMSG}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$singleSetBackgroundPhoto$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<String, String, Continuation<? super Unit>, Object> {
        public final /* synthetic */ b $$this$async;
        public final /* synthetic */ UpLoadBackgroundPage $ctx;
        public final /* synthetic */ Function2<Integer, String, Unit> $report;
        public /* synthetic */ String L$0;
        public /* synthetic */ String L$1;
        public int label;

        @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$singleSetBackgroundPhoto$1$1$1", f = "UploadBackgroundPage.kt", i = {}, l = {450}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$singleSetBackgroundPhoto$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes33.dex */
        public static final class C58061 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
            public final /* synthetic */ UpLoadBackgroundPage $ctx;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C58061(UpLoadBackgroundPage upLoadBackgroundPage, Continuation<? super C58061> continuation) {
                super(2, continuation);
                this.$ctx = upLoadBackgroundPage;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C58061(this.$ctx, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
                return ((C58061) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    GXH gxh = (GXH) this.$ctx.platformApi.getVasModule().$$delegate_2.gxh$delegate.getValue();
                    this.label = 1;
                    obj = gxh.getCustomBgList(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List<GXH.CustomBgItemInfo> list = (List) obj;
                Ref.IntRef intRef = new Ref.IntRef();
                int size = list.size();
                intRef.element = size;
                if (size > 0) {
                    for (GXH.CustomBgItemInfo customBgItemInfo : list) {
                        if (customBgItemInfo instanceof GXH.CustomBgItemInfo) {
                            if (customBgItemInfo.uin.length() == 0) {
                                intRef.element--;
                            }
                        }
                    }
                }
                if (intRef.element == 0) {
                    this.$ctx.platformApi.getCoreModule().qToast("\u88c5\u626e\u6210\u529f", QToastMode.Success);
                } else {
                    BridgeModule bridgeModule = (BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule");
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4f60\u6709");
                    m3.append(intRef.element);
                    m3.append("\u4e2a\u804a\u5929\u8bbe\u7f6e\u4e86\u6307\u5b9a\u80cc\u666f\uff0c\u4e0d\u4f1a\u88ab\u66f4\u6362\uff0c\u5982\u679c\u60f3\u8981\u66f4\u6362\u8bf7\u70b9\u51fb");
                    bridgeModule.showAlert("\u88c5\u626e\u6210\u529f", m3.toString(), "\u6211\u77e5\u9053\u4e86", "\u53bb\u7ba1\u7406", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.singleSetBackgroundPhoto.1.1.1.2
                        /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
                        
                            if (r3.j("index") == 1) goto L8;
                         */
                        @Override // kotlin.jvm.functions.Function1
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(e eVar) {
                            boolean z16;
                            e eVar2 = eVar;
                            if (eVar2 != null) {
                                z16 = true;
                            }
                            z16 = false;
                            if (z16) {
                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.openPage$default("https://zb.vip.qq.com/v2/pages/newMinePage?appid=8&_nav_titleclr=000000&_nav_txtclr=000000&_wv=16777216", false, 6);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function2<? super Integer, ? super String, Unit> function2, UpLoadBackgroundPage upLoadBackgroundPage, b bVar, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$report = function2;
            this.$ctx = upLoadBackgroundPage;
            this.$$this$async = bVar;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(String str, String str2, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$report, this.$ctx, this.$$this$async, continuation);
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = str2;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                String str = this.L$0;
                String str2 = this.L$1;
                if (Intrinsics.areEqual(str, "0")) {
                    this.$report.invoke(Boxing.boxInt(0), "success");
                    if (Intrinsics.areEqual(this.$ctx.getFrom(), "home")) {
                        String str3 = this.$ctx.friendUin;
                        if (str3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                            str3 = null;
                        }
                        if (str3.length() == 0) {
                            BuildersKt.b(VasBasePage.Companion.getCtx().getPageScope(), null, null, new C58061(this.$ctx, null), 3, null);
                        }
                    }
                    this.$ctx.platformApi.getCoreModule().qToast("\u88c5\u626e\u6210\u529f", QToastMode.Success);
                    b bVar = this.$$this$async;
                    this.L$0 = null;
                    this.label = 1;
                    if (BuildersKt.c(bVar, 1000, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.$report.invoke(Boxing.boxInt(2), str + ':' + str2);
                    this.$ctx.platformApi.getCoreModule().qToast(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("\u88c5\u626e\u5931\u8d25 \u9519\u8bef\u7801:", str), QToastMode.Warning);
                }
                return Unit.INSTANCE;
            }
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            BridgeModule.closePage$default(this.$ctx.platformApi.getCoreModule(), null, null, 3);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpLoadBackgroundPage$singleSetBackgroundPhoto$1(UpLoadBackgroundPage upLoadBackgroundPage, UpLoadBackgroundPage upLoadBackgroundPage2, Continuation<? super UpLoadBackgroundPage$singleSetBackgroundPhoto$1> continuation) {
        super(2, continuation);
        this.$ctx = upLoadBackgroundPage;
        this.this$0 = upLoadBackgroundPage2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UpLoadBackgroundPage$singleSetBackgroundPhoto$1 upLoadBackgroundPage$singleSetBackgroundPhoto$1 = new UpLoadBackgroundPage$singleSetBackgroundPhoto$1(this.$ctx, this.this$0, continuation);
        upLoadBackgroundPage$singleSetBackgroundPhoto$1.L$0 = obj;
        return upLoadBackgroundPage$singleSetBackgroundPhoto$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((UpLoadBackgroundPage$singleSetBackgroundPhoto$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$singleSetBackgroundPhoto$1$report$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int intValue;
        Object callUniSet;
        b bVar;
        UpLoadBackgroundPage$singleSetBackgroundPhoto$1$report$1 upLoadBackgroundPage$singleSetBackgroundPhoto$1$report$1;
        int intValue2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            b bVar2 = (b) this.L$0;
            final long currentTimeStamp = VasBasePage.Companion.getCtx().platformApi.getCoreModule().currentTimeStamp();
            ?? r122 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$singleSetBackgroundPhoto$1$report$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str) {
                    int intValue3 = num.intValue();
                    String str2 = str;
                    VasBasePage.Companion companion = VasBasePage.Companion;
                    VasCommonReportProxy newVasCommonReport = companion.getCtx().newVasCommonReport("set_uoload_bg");
                    newVasCommonReport.num1 = intValue3;
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
            String str = upLoadBackgroundPage.friendUin;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                str = null;
            }
            UpLoadBackgroundPage upLoadBackgroundPage2 = this.$ctx;
            int i16 = upLoadBackgroundPage2.uinType;
            intValue = ((Number) upLoadBackgroundPage2.selectedEffectItemID$delegate.getValue(upLoadBackgroundPage2, UpLoadBackgroundPage.$$delegatedProperties[0])).intValue();
            this.L$0 = bVar2;
            this.L$1 = r122;
            this.label = 1;
            callUniSet = uploadBackgroundRequest.callUniSet(upLoadBackgroundPage, str, i16, intValue, this);
            if (callUniSet == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = bVar2;
            upLoadBackgroundPage$singleSetBackgroundPhoto$1$report$1 = r122;
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            UpLoadBackgroundPage$singleSetBackgroundPhoto$1$report$1 upLoadBackgroundPage$singleSetBackgroundPhoto$1$report$12 = this.L$1;
            bVar = (b) this.L$0;
            ResultKt.throwOnFailure(obj);
            upLoadBackgroundPage$singleSetBackgroundPhoto$1$report$1 = upLoadBackgroundPage$singleSetBackgroundPhoto$1$report$12;
            callUniSet = obj;
        }
        Pair pair = (Pair) callUniSet;
        if (((Boolean) pair.getFirst()).booleanValue()) {
            e access$getSelectImageArea = UpLoadBackgroundPage.access$getSelectImageArea(this.this$0);
            if (access$getSelectImageArea.d() == 0) {
                upLoadBackgroundPage$singleSetBackgroundPhoto$1$report$1.invoke(Boxing.boxInt(3), "invalid rect");
            } else {
                String str2 = this.$ctx.friendUin;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                    str2 = null;
                }
                access$getSelectImageArea.v("friendUin", str2);
                access$getSelectImageArea.t("uinType", this.$ctx.uinType);
                String str3 = this.$ctx.imageUrlEncode;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageUrlEncode");
                    str3 = null;
                }
                access$getSelectImageArea.v("imagePath", str3);
                intValue2 = ((Number) r2.selectedEffectItemID$delegate.getValue(this.$ctx, UpLoadBackgroundPage.$$delegatedProperties[0])).intValue();
                access$getSelectImageArea.t("effectID", intValue2);
                VasModule vasModule = this.$ctx.platformApi.getVasModule();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(upLoadBackgroundPage$singleSetBackgroundPhoto$1$report$1, this.$ctx, bVar, null);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (vasModule.setBackgroundPhoto(access$getSelectImageArea, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            upLoadBackgroundPage$singleSetBackgroundPhoto$1$report$1.invoke(Boxing.boxInt(1), pair.getSecond());
            this.$ctx.platformApi.getCoreModule().qToast("\u670d\u52a1\u65e0\u54cd\u5e94", QToastMode.Warning);
        }
        return Unit.INSTANCE;
    }
}
