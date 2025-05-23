package com.tencent.mobileqq.guild.feed.link;

import androidx.core.app.NotificationCompat;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchTransThirdPlatformURLReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchTransThirdPlatformURLRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchTransThirdPlatformURCallback;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ9\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/link/LinkApi;", "", "", "", CoverDBCacheData.URLS, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchTransThirdPlatformURLReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchTransThirdPlatformURLRsp;", "Lcom/tencent/mobileqq/guild/feed/link/UrlInfoRequestCallback;", "callback", "", "a", "(Ljava/util/Collection;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LinkApi {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "code", "", NotificationCompat.CATEGORY_ERROR, "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchTransThirdPlatformURLRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a implements IGProBatchTransThirdPlatformURCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Triple<Integer, String, GProBatchTransThirdPlatformURLRsp>> f220103a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Continuation<? super Triple<Integer, String, GProBatchTransThirdPlatformURLRsp>> continuation) {
            this.f220103a = continuation;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchTransThirdPlatformURCallback
        public final void onResult(int i3, String str, GProBatchTransThirdPlatformURLRsp gProBatchTransThirdPlatformURLRsp) {
            Continuation<Triple<Integer, String, GProBatchTransThirdPlatformURLRsp>> continuation = this.f220103a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new Triple(Integer.valueOf(i3), str, gProBatchTransThirdPlatformURLRsp)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(@NotNull Collection<String> collection, @NotNull RequestSenderCallback<GProBatchTransThirdPlatformURLReq, GProBatchTransThirdPlatformURLRsp> requestSenderCallback, @NotNull Continuation<? super Unit> continuation) {
        LinkApi$batchTransThirdPlatformURL$1 linkApi$batchTransThirdPlatformURL$1;
        Object coroutine_suspended;
        int i3;
        RequestSenderCallback<GProBatchTransThirdPlatformURLReq, GProBatchTransThirdPlatformURLRsp> requestSenderCallback2;
        GProBatchTransThirdPlatformURLReq gProBatchTransThirdPlatformURLReq;
        Triple triple;
        if (continuation instanceof LinkApi$batchTransThirdPlatformURL$1) {
            linkApi$batchTransThirdPlatformURL$1 = (LinkApi$batchTransThirdPlatformURL$1) continuation;
            int i16 = linkApi$batchTransThirdPlatformURL$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                linkApi$batchTransThirdPlatformURL$1.label = i16 - Integer.MIN_VALUE;
                Object obj = linkApi$batchTransThirdPlatformURL$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = linkApi$batchTransThirdPlatformURL$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        GProBatchTransThirdPlatformURLReq gProBatchTransThirdPlatformURLReq2 = (GProBatchTransThirdPlatformURLReq) linkApi$batchTransThirdPlatformURL$1.L$1;
                        RequestSenderCallback<GProBatchTransThirdPlatformURLReq, GProBatchTransThirdPlatformURLRsp> requestSenderCallback3 = (RequestSenderCallback) linkApi$batchTransThirdPlatformURL$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        gProBatchTransThirdPlatformURLReq = gProBatchTransThirdPlatformURLReq2;
                        requestSenderCallback2 = requestSenderCallback3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    GProBatchTransThirdPlatformURLReq gProBatchTransThirdPlatformURLReq3 = new GProBatchTransThirdPlatformURLReq();
                    gProBatchTransThirdPlatformURLReq3.urls = new ArrayList<>(collection);
                    LinkApi$batchTransThirdPlatformURL$$inlined$suspendCoroutineWithTimeout$default$1 linkApi$batchTransThirdPlatformURL$$inlined$suspendCoroutineWithTimeout$default$1 = new LinkApi$batchTransThirdPlatformURL$$inlined$suspendCoroutineWithTimeout$default$1(null, gProBatchTransThirdPlatformURLReq3);
                    linkApi$batchTransThirdPlatformURL$1.L$0 = requestSenderCallback;
                    linkApi$batchTransThirdPlatformURL$1.L$1 = gProBatchTransThirdPlatformURLReq3;
                    linkApi$batchTransThirdPlatformURL$1.label = 1;
                    Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(15000L, linkApi$batchTransThirdPlatformURL$$inlined$suspendCoroutineWithTimeout$default$1, linkApi$batchTransThirdPlatformURL$1);
                    if (withTimeoutOrNull == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    requestSenderCallback2 = requestSenderCallback;
                    gProBatchTransThirdPlatformURLReq = gProBatchTransThirdPlatformURLReq3;
                    obj = withTimeoutOrNull;
                }
                triple = (Triple) obj;
                if (triple == null) {
                    triple = new Triple(Boxing.boxInt(1002), "\u7f51\u7edc\u8d85\u65f6", new GProBatchTransThirdPlatformURLRsp());
                }
                int intValue = ((Number) triple.component1()).intValue();
                String str = (String) triple.component2();
                GProBatchTransThirdPlatformURLRsp gProBatchTransThirdPlatformURLRsp = (GProBatchTransThirdPlatformURLRsp) triple.component3();
                QLog.i("LinkApi", 1, "batchTransThirdPlatformURL code: " + intValue + ", err: " + str);
                requestSenderCallback2.b(new com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.a(), intValue, str, gProBatchTransThirdPlatformURLReq, gProBatchTransThirdPlatformURLRsp);
                return Unit.INSTANCE;
            }
        }
        linkApi$batchTransThirdPlatformURL$1 = new LinkApi$batchTransThirdPlatformURL$1(this, continuation);
        Object obj2 = linkApi$batchTransThirdPlatformURL$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = linkApi$batchTransThirdPlatformURL$1.label;
        if (i3 == 0) {
        }
        triple = (Triple) obj2;
        if (triple == null) {
        }
        int intValue2 = ((Number) triple.component1()).intValue();
        String str2 = (String) triple.component2();
        GProBatchTransThirdPlatformURLRsp gProBatchTransThirdPlatformURLRsp2 = (GProBatchTransThirdPlatformURLRsp) triple.component3();
        QLog.i("LinkApi", 1, "batchTransThirdPlatformURL code: " + intValue2 + ", err: " + str2);
        requestSenderCallback2.b(new com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.a(), intValue2, str2, gProBatchTransThirdPlatformURLReq, gProBatchTransThirdPlatformURLRsp2);
        return Unit.INSTANCE;
    }
}
