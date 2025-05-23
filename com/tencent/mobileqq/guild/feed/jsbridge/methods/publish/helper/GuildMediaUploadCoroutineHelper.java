package com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.publish.event.GuildOnPhotoSelectedEvent;
import com.tencent.mobileqq.guild.feed.publish.result.SelectPhotoResult;
import com.tencent.mobileqq.guild.feed.publish.result.SelectVideoResult;
import com.tencent.mobileqq.guild.feed.util.GuildFeedMediaUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import rk1.n;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ;\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ;\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\fJ7\u0010\u0012\u001a\u00020\u0011*\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J;\u0010\u001b\u001a\u00020\u001a2\u0016\u0010\u0015\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t0\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/publish/helper/GuildMediaUploadCoroutineHelper;", "", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/publish/helper/GuildUploadHelper;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "photoPath", "Lkotlinx/coroutines/Deferred;", "Lcom/tencent/mobileqq/guild/feed/publish/result/SelectPhotoResult;", "f", "(Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/publish/helper/GuildUploadHelper;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "videoPath", "Lcom/tencent/mobileqq/guild/feed/publish/result/SelectVideoResult;", "g", "thumbnailPath", "", "e", "(Lcom/tencent/mobileqq/guild/feed/publish/result/SelectVideoResult;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", ForwardMiniChooseFriendOption.RESULT_LIST, "Lrk1/n;", "publishConfigMethod", "Lcom/tencent/mobileqq/guild/feed/publish/event/GuildOnPhotoSelectedEvent;", "event", "Lkotlinx/coroutines/Job;", "i", "([Lkotlinx/coroutines/Deferred;Lrk1/n;Lcom/tencent/mobileqq/guild/feed/publish/event/GuildOnPhotoSelectedEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", h.F, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildMediaUploadCoroutineHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildMediaUploadCoroutineHelper f220036a = new GuildMediaUploadCoroutineHelper();

    GuildMediaUploadCoroutineHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e(final SelectVideoResult selectVideoResult, final LocalMediaInfo localMediaInfo, final String str, String str2, final String str3, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        GuildFeedMediaUtils.g(str, str2, new GuildFeedMediaUtils.a() { // from class: com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildMediaUploadCoroutineHelper$awaitVideoThumbnailPathSaved$2$onSaveComplete$1
            @Override // com.tencent.mobileqq.guild.feed.util.GuildFeedMediaUtils.a
            public final void onComplete() {
                LocalMediaInfo localMediaInfo2 = LocalMediaInfo.this;
                int i3 = localMediaInfo2.mediaWidth;
                int i16 = localMediaInfo2.mediaHeight;
                int[] f16 = GuildFeedMediaUtils.f(str);
                if (f16 != null) {
                    i3 = f16[0];
                    i16 = f16[1];
                }
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildMediaUploadCoroutineHelper", 1, "awaitVideoThumbnailPathSaved--width:" + i3 + ",height:" + i16);
                }
                selectVideoResult.f(str3, i3, i16);
                if (selectVideoResult.e()) {
                    cancellableContinuationImpl.resume(Unit.INSTANCE, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildMediaUploadCoroutineHelper$awaitVideoThumbnailPathSaved$2$onSaveComplete$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            throw new CancellationException("selectVideoResult is canceled");
                        }
                    });
                } else {
                    cancellableContinuationImpl.cancel(new CancellationException("selectVideoResult is not complete"));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended2) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(GuildUploadHelper guildUploadHelper, LocalMediaInfo localMediaInfo, String str, String str2, Continuation<? super Deferred<? extends SelectPhotoResult>> continuation) {
        return SupervisorKt.supervisorScope(new GuildMediaUploadCoroutineHelper$handleImageProcess$2(guildUploadHelper, localMediaInfo, str, str2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(GuildUploadHelper guildUploadHelper, LocalMediaInfo localMediaInfo, String str, String str2, Continuation<? super Deferred<? extends SelectVideoResult>> continuation) {
        return SupervisorKt.supervisorScope(new GuildMediaUploadCoroutineHelper$handleVideoProcess$2(guildUploadHelper, localMediaInfo, str, str2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(Deferred<Object>[] deferredArr, n nVar, GuildOnPhotoSelectedEvent guildOnPhotoSelectedEvent, Continuation<? super Job> continuation) {
        return SupervisorKt.supervisorScope(new GuildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2(deferredArr, nVar, guildOnPhotoSelectedEvent, null), continuation);
    }

    public final void h(@NotNull GuildOnPhotoSelectedEvent event, @NotNull GuildUploadHelper instance, @NotNull n publishConfigMethod) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(publishConfigMethod, "publishConfigMethod");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1(event, publishConfigMethod, instance, null), 3, null);
    }
}
