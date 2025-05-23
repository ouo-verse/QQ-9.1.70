package com.tencent.ecommerce.biz.hr.module;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.biz.comment.BatchUploader;
import com.tencent.ecommerce.biz.comment.UploadFailedException;
import com.tencent.ecommerce.biz.hr.module.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.hr.module.HRBridgeModule$uploadSinglePhotoFromAlbum$1$onAlbumSelectedResultCallback$1", f = "HRBridgeModule.kt", i = {}, l = {478, 481}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class HRBridgeModule$uploadSinglePhotoFromAlbum$1$onAlbumSelectedResultCallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $medias;
    int label;
    final /* synthetic */ HRBridgeModule$uploadSinglePhotoFromAlbum$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HRBridgeModule$uploadSinglePhotoFromAlbum$1$onAlbumSelectedResultCallback$1(HRBridgeModule$uploadSinglePhotoFromAlbum$1 hRBridgeModule$uploadSinglePhotoFromAlbum$1, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = hRBridgeModule$uploadSinglePhotoFromAlbum$1;
        this.$medias = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HRBridgeModule$uploadSinglePhotoFromAlbum$1$onAlbumSelectedResultCallback$1(this.this$0, this.$medias, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HRBridgeModule$uploadSinglePhotoFromAlbum$1$onAlbumSelectedResultCallback$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00b4  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object first;
        Function1 function1;
        Object first2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                String optString = this.this$0.f102602c.optString("notificationName");
                if (optString.length() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(AdMetricTag.EVENT_NAME, optString);
                    cg0.a.b("HRBridgeModule", "[uploadSinglePhotoFromAlbum] onNotify posted");
                    this.this$0.f102600a.B().call("postNotify", jSONObject.toString(), (Function1<Object, Unit>) null);
                }
                BatchUploader batchUploader = this.this$0.f102603d;
                List<ECMediaInfo> list = this.$medias;
                this.label = 1;
                if (batchUploader.k(list, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        List list2 = (List) obj;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("[uploadSinglePhotoFromAlbum] getUrls, size:");
                        sb5.append(list2.size());
                        sb5.append(", first url:");
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list2);
                        sb5.append((String) first);
                        cg0.a.b("HRBridgeModule", sb5.toString());
                        function1 = this.this$0.f102604e;
                        if (function1 != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("success", true);
                            if (!list2.isEmpty()) {
                                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list2);
                                jSONObject2.put("url", first2);
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                        this.this$0.f102603d.i();
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            f.Companion companion = f.INSTANCE;
            BatchUploader batchUploader2 = this.this$0.f102603d;
            this.label = 2;
            obj = batchUploader2.h(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            List list22 = (List) obj;
            StringBuilder sb52 = new StringBuilder();
            sb52.append("[uploadSinglePhotoFromAlbum] getUrls, size:");
            sb52.append(list22.size());
            sb52.append(", first url:");
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list22);
            sb52.append((String) first);
            cg0.a.b("HRBridgeModule", sb52.toString());
            function1 = this.this$0.f102604e;
            if (function1 != null) {
            }
            this.this$0.f102603d.i();
            return Unit.INSTANCE;
        } catch (UploadFailedException e16) {
            cg0.a.a("HRBridgeModule", "uploadSinglePhotoFromAlbum", "UploadFailedException e:" + e16);
            Function1 function12 = this.this$0.f102604e;
            if (function12 != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("success", false);
                Unit unit2 = Unit.INSTANCE;
            }
            this.this$0.f102603d.i();
            return Unit.INSTANCE;
        }
    }
}
