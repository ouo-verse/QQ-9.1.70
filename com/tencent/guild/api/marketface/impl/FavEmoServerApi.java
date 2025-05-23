package com.tencent.guild.api.marketface.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.guild.temp.api.IMarketFaceDiffApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\u000bJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/api/marketface/impl/FavEmoServerApi;", "", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "d", "Lcom/tencent/mobileqq/emoticon/api/IEmojiManagerService;", "e", "", EmojiManagerServiceProxy.EPID, "Lcom/tencent/qqnt/msg/api/c;", "Lcom/tencent/mobileqq/data/EmoticonPackage;", "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "Lcom/tencent/mobileqq/data/Emoticon;", "emoticon", "Lcom/tencent/mobileqq/data/EmoticonResp;", "f", "(Lcom/tencent/mobileqq/data/Emoticon;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class FavEmoServerApi {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FavEmoServerApi f112580a = new FavEmoServerApi();

    FavEmoServerApi() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseQQAppInterface d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        return (BaseQQAppInterface) peekAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IEmojiManagerService e() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IEmojiManagerService.class, "");
        }
        return (IEmojiManagerService) iRuntimeService;
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull Continuation<? super com.tencent.qqnt.msg.api.c<EmoticonPackage>> continuation) {
        Continuation intercepted;
        AppInterface appInterface;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IEmoticonManagerService.class, "");
        }
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) iRuntimeService;
        if (iEmoticonManagerService != null) {
            iEmoticonManagerService.asyncFindEmoticonPackage(str, new QueryCallback() { // from class: com.tencent.guild.api.marketface.impl.FavEmoServerApi$asyncFindEmoticonPackage$2$1
                @Override // com.tencent.mobileqq.emoticonview.QueryCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void postQuery(EmoticonPackage emoticonPackage) {
                    String str2;
                    int i3;
                    if (emoticonPackage == null) {
                        str2 = "find empty";
                    } else {
                        str2 = "";
                    }
                    if (emoticonPackage == null) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    cancellableContinuationImpl.resume(new com.tencent.qqnt.msg.api.c<>(emoticonPackage, i3, str2), new Function1<Throwable, Unit>() { // from class: com.tencent.guild.api.marketface.impl.FavEmoServerApi$asyncFindEmoticonPackage$2$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object f(@NotNull Emoticon emoticon, @NotNull Continuation<? super com.tencent.qqnt.msg.api.c<EmoticonResp>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        f112580a.d().addObserver(new EmoticonObserver() { // from class: com.tencent.guild.api.marketface.impl.FavEmoServerApi$startAuth$2$observer$1
            /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
            @Override // com.tencent.mobileqq.app.EmoticonObserver, com.tencent.mobileqq.app.BusinessObserver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onUpdate(int type, boolean isSuccess, @NotNull Object data) {
                EmoticonResp emoticonResp;
                int i3;
                String str;
                boolean z16;
                Intrinsics.checkNotNullParameter(data, "data");
                if (type == 6) {
                    FavEmoServerApi.f112580a.d().removeObserver(this);
                    if (data instanceof EmoticonResp) {
                        emoticonResp = (EmoticonResp) data;
                    } else {
                        emoticonResp = null;
                    }
                    if (isSuccess && emoticonResp != null) {
                        String str2 = emoticonResp.emoticonId;
                        i3 = 0;
                        if (str2 != null && str2.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            str = "";
                            if (emoticonResp == null) {
                                emoticonResp = new EmoticonResp();
                            }
                            cancellableContinuationImpl.resume(new com.tencent.qqnt.msg.api.c<>(emoticonResp, i3, str), new Function1<Throwable, Unit>() { // from class: com.tencent.guild.api.marketface.impl.FavEmoServerApi$startAuth$2$observer$1$onUpdate$1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                    }
                    i3 = -1;
                    str = "\u670d\u52a1\u5668\u5fd9\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
                    if (emoticonResp == null) {
                    }
                    cancellableContinuationImpl.resume(new com.tencent.qqnt.msg.api.c<>(emoticonResp, i3, str), new Function1<Throwable, Unit>() { // from class: com.tencent.guild.api.marketface.impl.FavEmoServerApi$startAuth$2$observer$1$onUpdate$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                }
            }
        });
        ((IMarketFaceDiffApi) QRoute.api(IMarketFaceDiffApi.class)).authDownloadEmoticonByFav(emoticon.epId, emoticon.eId);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull Continuation<? super com.tencent.qqnt.msg.api.c<EmoticonPackage>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IEmojiListenerManager emojiListenerManager;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        FavEmoServerApi favEmoServerApi = f112580a;
        IEmojiManagerService e16 = favEmoServerApi.e();
        if (e16 != null && (emojiListenerManager = e16.getEmojiListenerManager()) != null) {
            emojiListenerManager.addEmotionJsonDownloadListener(new EmotionJsonDownloadListener() { // from class: com.tencent.guild.api.marketface.impl.FavEmoServerApi$startDownloadEmoticonJson$2$1
                @Override // com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener
                public void onJsonComplete(@Nullable EmoticonPackage ep5, int resultCode, @Nullable Bundle params) {
                    if (ep5 == null) {
                        ep5 = new EmoticonPackage();
                    }
                    cancellableContinuationImpl.resume(new com.tencent.qqnt.msg.api.c<>(ep5, resultCode, ""), new Function1<Throwable, Unit>() { // from class: com.tencent.guild.api.marketface.impl.FavEmoServerApi$startDownloadEmoticonJson$2$1$onJsonComplete$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                }
            });
        }
        IEmojiManagerService e17 = favEmoServerApi.e();
        if (e17 != null) {
            e17.startDownloadEmosmJson(str, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
