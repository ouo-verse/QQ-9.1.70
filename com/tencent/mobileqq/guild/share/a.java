package com.tencent.mobileqq.guild.share;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.guild.GuildShareActionSheetV2;
import com.tencent.mobileqq.guild.share.shorturl.ShareServiceType;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateShareReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateShareRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProShareInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateShareCallback;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\f\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u00020\u000e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010#\u001a\u0004\u0018\u00010\u001b8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/share/a;", "", "Lcom/tencent/mobileqq/guild/share/b;", "fetchCreateShare", "Lcom/tencent/qqnt/kernel/api/o;", "getFeedService", "()Lcom/tencent/qqnt/kernel/api/o;", "feedService", "Lcom/tencent/mobileqq/guild/share/GuildArkBusiId;", "b", "()Lcom/tencent/mobileqq/guild/share/GuildArkBusiId;", "setBusiId", "(Lcom/tencent/mobileqq/guild/share/GuildArkBusiId;)V", "busiId", "Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;", "e", "()Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;", "setServiceType", "(Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;)V", "serviceType", "Lcom/tencent/mobileqq/guild/share/ArkTemplateStr;", "d", "()Lcom/tencent/mobileqq/guild/share/ArkTemplateStr;", "setArkTemplateStr", "(Lcom/tencent/mobileqq/guild/share/ArkTemplateStr;)V", "arkTemplateStr", "", "", "c", "()Ljava/util/Map;", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "a", "()Ljava/lang/String;", "setResourceId", "(Ljava/lang/String;)V", "resourceId", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.share.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C7906a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCreateShareRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.guild.share.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7907a implements IGProCreateShareCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<b> f234969a;

            /* JADX WARN: Multi-variable type inference failed */
            C7907a(CancellableContinuation<? super b> cancellableContinuation) {
                this.f234969a = cancellableContinuation;
            }

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateShareCallback
            public final void onResult(int i3, String errMsg, GProCreateShareRsp rsp) {
                if (i3 == 0 && rsp != null) {
                    if (this.f234969a.isActive()) {
                        Logger.f235387a.d().i("FetchArkInfo", 1, "fetchCreateShare rsp templateDataLength:" + rsp.templateData.length());
                        CancellableContinuation<b> cancellableContinuation = this.f234969a;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(new b(rsp)));
                        return;
                    }
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    bVar.a().add("fetchCreateShare, continuation is canceled");
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("FetchArkInfo", 1, (String) it.next(), null);
                    }
                    return;
                }
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                String str = "fetchCreateShare, result: " + i3 + ", errMsg: " + errMsg;
                if (str instanceof String) {
                    bVar2.a().add(str);
                }
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("FetchArkInfo", 1, (String) it5.next(), null);
                }
                if (this.f234969a.isActive()) {
                    CancellableContinuation<b> cancellableContinuation2 = this.f234969a;
                    Result.Companion companion2 = Result.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new GuildShareActionSheetV2.RequestThrowable(i3, errMsg, rsp))));
                }
            }
        }

        @Nullable
        public static Object a(@NotNull a aVar, @NotNull Continuation<? super b> continuation) {
            return b(aVar, continuation);
        }

        private static Object b(a aVar, Continuation<? super b> continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            GProCreateShareReq gProCreateShareReq = new GProCreateShareReq();
            gProCreateShareReq.info.busiId = aVar.getBusiId().getId();
            GProShareInfo gProShareInfo = gProCreateShareReq.info;
            String jSONObject = new JSONObject(aVar.c()).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(busiData).toString()");
            byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            gProShareInfo.busiData = bytes;
            GProShareInfo gProShareInfo2 = gProCreateShareReq.info;
            gProShareInfo2.plat = 1;
            String resourceId = aVar.getResourceId();
            if (resourceId == null) {
                resourceId = "";
            }
            gProShareInfo2.resourceId = resourceId;
            gProCreateShareReq.info.stringTemplate = aVar.getArkTemplateStr().getTName();
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("FetchArkInfo", 2, "fetchCreateShare req:" + gProCreateShareReq);
            }
            com.tencent.qqnt.kernel.api.o feedService = aVar.getFeedService();
            if (feedService != null) {
                feedService.createShare(gProCreateShareReq, aVar.getServiceType().getType(), new C7907a(cancellableContinuationImpl));
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        @Nullable
        public static com.tencent.qqnt.kernel.api.o c(@NotNull a aVar) {
            return ((IGProSession) ch.R0(IGProSession.class)).getFeedService();
        }
    }

    @Nullable
    /* renamed from: a */
    String getResourceId();

    @NotNull
    /* renamed from: b */
    GuildArkBusiId getBusiId();

    @NotNull
    Map<String, Object> c();

    @NotNull
    /* renamed from: d */
    ArkTemplateStr getArkTemplateStr();

    @NotNull
    /* renamed from: e */
    ShareServiceType getServiceType();

    @Nullable
    com.tencent.qqnt.kernel.api.o getFeedService();
}
