package com.tencent.aelight.camera.ae.flashshow;

import com.tencent.aelight.camera.ae.flashshow.LSCameraMaterialJSServiceManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import java.util.Iterator;
import java.util.List;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aelight.camera.ae.flashshow.LSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1", f = "LSCameraMaterialJSServiceManager.kt", i = {0}, l = {94}, m = "invokeSuspend", n = {"index"}, s = {"I$0"})
/* loaded from: classes32.dex */
final class LSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $length;
    final /* synthetic */ LSCameraMaterialJSServiceManager.b $listener;
    final /* synthetic */ JSONArray $paths;
    final /* synthetic */ List<String> $urls;
    final /* synthetic */ String $uuid;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1(int i3, JSONArray jSONArray, List<String> list, String str, LSCameraMaterialJSServiceManager.b bVar, Continuation<? super LSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1> continuation) {
        super(2, continuation);
        this.$length = i3;
        this.$paths = jSONArray;
        this.$urls = list;
        this.$uuid = str;
        this.$listener = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1(this.$length, this.$paths, this.$urls, this.$uuid, this.$listener, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x005f -> B:5:0x0062). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        LSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1 lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1;
        int i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1 = this;
            i3 = 0;
            if (i3 < lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1.$length) {
            }
        } else if (i16 == 1) {
            i3 = this.I$0;
            ResultKt.throwOnFailure(obj);
            Object b16 = obj;
            lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1 = this;
            String str = (String) b16;
            lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1.$urls.add(str);
            ms.a.a("AECameraMaterialJSServiceManager", "compressImageUrl " + str);
            i3++;
            if (i3 < lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1.$length) {
                Object obj2 = lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1.$paths.get(i3);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                String c16 = com.tencent.mobileqq.wink.utils.an.c(com.tencent.mobileqq.wink.utils.an.f326680a, (String) obj2, 1920, 90, false, 8, null);
                if (c16 == null) {
                    c16 = "";
                }
                String str2 = c16;
                com.tencent.mobileqq.wink.utils.al alVar = com.tencent.mobileqq.wink.utils.al.f326675a;
                lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1.I$0 = i3;
                lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1.label = 1;
                b16 = com.tencent.mobileqq.wink.utils.al.b(alVar, str2, false, lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1, 2, null);
                if (b16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String str3 = (String) b16;
                lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1.$urls.add(str3);
                ms.a.a("AECameraMaterialJSServiceManager", "compressImageUrl " + str3);
                i3++;
                if (i3 < lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1.$length) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("Uuid", lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1.$uuid);
                    jSONObject.put("Ret", 0);
                    jSONObject.put(AECameraConstants.REQ_EXTRA, "{}");
                    JSONArray jSONArray = new JSONArray();
                    Iterator<String> it = lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1.$urls.iterator();
                    while (it.hasNext()) {
                        jSONArray.mo162put(it.next());
                    }
                    jSONObject.put("URLs", jSONArray);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("lightCameraResUploadRsp", jSONObject);
                    ms.a.a("AECameraMaterialJSServiceManager", "result ~~~ " + jSONObject2);
                    LSCameraMaterialJSServiceManager.b bVar = lSCameraMaterialJSServiceManager$handleCameraAIGCMaterialJceRequest$1.$listener;
                    String jSONObject3 = jSONObject2.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "res.toString()");
                    bVar.a(jSONObject3);
                    return Unit.INSTANCE;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
