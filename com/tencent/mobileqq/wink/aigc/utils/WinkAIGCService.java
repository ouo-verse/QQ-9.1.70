package com.tencent.mobileqq.wink.aigc.utils;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.wink.utils.an;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.AIGCClient;
import org.light.aigc.bean.AIGCContentOutput;
import org.light.aigc.bean.AIGCRequest;
import org.light.aigc.bean.ContentInfo;
import org.light.aigc.bean.MediaScene;
import org.light.aigc.net.IGenerateCallback;
import qshadow.ShadowAIGCSafe$SafeCheckReply;
import tl.h;
import w93.e;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ#\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0016\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0010J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/utils/WinkAIGCService;", "", "Lorg/light/aigc/bean/AIGCRequest;", Const.BUNDLE_KEY_REQUEST, "Lorg/light/aigc/bean/AIGCContentOutput;", "g", "(Lorg/light/aigc/bean/AIGCRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "e", h.F, "", "filePath", "c", "bizId", "imageUrl", "b", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "styleId", "safeId", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "imageURL", "i", "", "throwable", "f", "Lorg/light/aigc/AIGCClient;", "a", "Lorg/light/aigc/AIGCClient;", "aigcClient", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIGCService {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIGCClient aigcClient;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/aigc/utils/WinkAIGCService$b", "Lorg/light/aigc/net/IGenerateCallback;", "Lorg/light/aigc/bean/AIGCContentOutput;", "output", "", "onSuccess", "", "errorCode", "", "errorMsg", "onError", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements IGenerateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<AIGCContentOutput> f317936a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super AIGCContentOutput> cancellableContinuation) {
            this.f317936a = cancellableContinuation;
        }

        @Override // org.light.aigc.net.IGenerateCallback
        public void onError(long errorCode, @Nullable String errorMsg) {
            w53.b.c("WinkAIGCService", "requestAigc onError: " + errorCode + ", errorMsg: " + errorMsg);
            if (this.f317936a.isActive() && !this.f317936a.isCancelled()) {
                CancellableContinuation<AIGCContentOutput> cancellableContinuation = this.f317936a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException(errorCode + "," + errorMsg))));
            }
        }

        @Override // org.light.aigc.net.IGenerateCallback
        public void onSuccess(@Nullable AIGCContentOutput output) {
            w53.b.f("WinkAIGCService", "requestAigc onSuccess:" + output);
            if (this.f317936a.isActive() && !this.f317936a.isCancelled()) {
                if (output == null) {
                    CancellableContinuation<AIGCContentOutput> cancellableContinuation = this.f317936a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("empty result"))));
                    return;
                }
                this.f317936a.resumeWith(Result.m476constructorimpl(output));
            }
        }
    }

    private final Object g(AIGCRequest aIGCRequest, Continuation<? super AIGCContentOutput> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AIGCClient aIGCClient = this.aigcClient;
        if (aIGCClient != null) {
            aIGCClient.generateAIGCContent(aIGCRequest, new b(cancellableContinuationImpl));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object b(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object g16 = g(com.tencent.mobileqq.wink.aigc.utils.b.f317941a.d(str, str2), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (g16 == coroutine_suspended) {
            return g16;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final String c(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return an.e(an.f326680a, filePath, 1920, 90, false, 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super String> continuation) {
        WinkAIGCService$generateOpeningEndingAIGCImage$1 winkAIGCService$generateOpeningEndingAIGCImage$1;
        Object coroutine_suspended;
        int i3;
        Iterator<T> it;
        Object obj;
        ContentInfo contentInfo;
        boolean z16;
        if (continuation instanceof WinkAIGCService$generateOpeningEndingAIGCImage$1) {
            winkAIGCService$generateOpeningEndingAIGCImage$1 = (WinkAIGCService$generateOpeningEndingAIGCImage$1) continuation;
            int i16 = winkAIGCService$generateOpeningEndingAIGCImage$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkAIGCService$generateOpeningEndingAIGCImage$1.label = i16 - Integer.MIN_VALUE;
                Object obj2 = winkAIGCService$generateOpeningEndingAIGCImage$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkAIGCService$generateOpeningEndingAIGCImage$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    AIGCRequest h16 = com.tencent.mobileqq.wink.aigc.utils.b.f317941a.h(str, str2, str3);
                    winkAIGCService$generateOpeningEndingAIGCImage$1.label = 1;
                    obj2 = g(h16, winkAIGCService$generateOpeningEndingAIGCImage$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                List<ContentInfo> list = ((AIGCContentOutput) obj2).contentInfos;
                Intrinsics.checkNotNullExpressionValue(list, "result.contentInfos");
                it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = it.next();
                        if (((ContentInfo) obj).scene == MediaScene.SceneResult) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                contentInfo = (ContentInfo) obj;
                if (contentInfo != null) {
                    return null;
                }
                return contentInfo.stringData;
            }
        }
        winkAIGCService$generateOpeningEndingAIGCImage$1 = new WinkAIGCService$generateOpeningEndingAIGCImage$1(this, continuation);
        Object obj22 = winkAIGCService$generateOpeningEndingAIGCImage$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkAIGCService$generateOpeningEndingAIGCImage$1.label;
        if (i3 == 0) {
        }
        List<ContentInfo> list2 = ((AIGCContentOutput) obj22).contentInfos;
        Intrinsics.checkNotNullExpressionValue(list2, "result.contentInfos");
        it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
            }
        }
        contentInfo = (ContentInfo) obj;
        if (contentInfo != null) {
        }
    }

    public final void e() {
        try {
            if (this.aigcClient == null) {
                this.aigcClient = com.tencent.mobileqq.wink.aigc.utils.b.f317941a.i();
            }
        } catch (Throwable th5) {
            w53.b.c("WinkAIGCService", "initAIGCSdk failed: " + th5);
        }
    }

    @NotNull
    public final String f(@NotNull Throwable throwable) {
        List list;
        Object first;
        Object last;
        boolean z16;
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        String message = throwable.getMessage();
        if (message != null) {
            list = StringsKt__StringsKt.split$default((CharSequence) message, new String[]{","}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        if (list != null && list.size() == 2) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            int parseInt = Integer.parseInt((String) first);
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            String str = (String) last;
            boolean z17 = true;
            if (1000 <= parseInt && parseInt < 10000) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 || (parseInt >= -9999 && parseInt <= -1000)) {
                if (str.length() <= 0) {
                    z17 = false;
                }
                if (z17) {
                    return str;
                }
            }
        }
        return "";
    }

    public final void h() {
        AIGCClient aIGCClient = this.aigcClient;
        if (aIGCClient != null) {
            aIGCClient.release();
        }
        this.aigcClient = null;
    }

    @Nullable
    public final Object i(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        final int j3 = e.f445096a.j(com.tencent.mobileqq.wink.aigc.utils.b.f317941a.e(str, str2), new Function5<BaseRequest, Boolean, Long, String, ShadowAIGCSafe$SafeCheckReply, Unit>() { // from class: com.tencent.mobileqq.wink.aigc.utils.WinkAIGCService$triggerSafe$2$seq$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(BaseRequest baseRequest, Boolean bool, Long l3, String str3, ShadowAIGCSafe$SafeCheckReply shadowAIGCSafe$SafeCheckReply) {
                invoke(baseRequest, bool.booleanValue(), l3.longValue(), str3, shadowAIGCSafe$SafeCheckReply);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull BaseRequest baseRequest, boolean z16, long j16, @Nullable String str3, @Nullable ShadowAIGCSafe$SafeCheckReply shadowAIGCSafe$SafeCheckReply) {
                Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
                if (shadowAIGCSafe$SafeCheckReply != null && j16 == 0 && z16) {
                    String str4 = shadowAIGCSafe$SafeCheckReply.msg_id.get();
                    if (str4 == null || str4.length() == 0) {
                        w53.b.c("WinkAIGCService", "triggerSafe: safe id is null");
                    }
                    CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(shadowAIGCSafe$SafeCheckReply.msg_id.get()));
                    return;
                }
                CancellableContinuation<String> cancellableContinuation2 = cancellableContinuationImpl;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("rsp invalid " + shadowAIGCSafe$SafeCheckReply + " " + j16 + " " + str3 + " " + z16))));
            }
        });
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.aigc.utils.WinkAIGCService$triggerSafe$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                VSNetworkHelper.getInstance().cancelRequest(MobileQQ.sMobileQQ, j3);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
