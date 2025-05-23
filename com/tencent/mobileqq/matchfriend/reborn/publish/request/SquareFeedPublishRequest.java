package com.tencent.mobileqq.matchfriend.reborn.publish.request;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.reborn.publish.upload.PicUploadResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.servlet.b;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$PublishFeedReq;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$PublishFeedRsp;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$StImage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ1\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/request/SquareFeedPublishRequest;", "", "", "text", "", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/upload/a;", "pickInfoList", "", "source", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/request/a;", "a", "(Ljava/lang/String;Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SquareFeedPublishRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final SquareFeedPublishRequest f245346a = new SquareFeedPublishRequest();

    SquareFeedPublishRequest() {
    }

    public final Object a(String str, List<PicUploadResult> list, int i3, Continuation<? super SquareFeedPublishResult> continuation) {
        Continuation intercepted;
        int i16;
        int collectionSizeOrDefault;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if ((str.length() == 0) && list.isEmpty()) {
            cancellableContinuationImpl.resume(new SquareFeedPublishResult(false, -1, "text and url empty.", null, 8, null), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.request.SquareFeedPublishRequest$reqPublish$2$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }
            });
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface == null) {
                QLog.e("SquareFeedPublishRequest", 1, "[reqPublish] but app is null.");
                cancellableContinuationImpl.resume(new SquareFeedPublishResult(false, -1, "app is null.", null, 8, null), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.request.SquareFeedPublishRequest$reqPublish$2$2
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                QLog.i("SquareFeedPublishRequest", 1, "[reqPublish] start. pickInfoList size = " + list.size());
                Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
                com.tencent.relation.common.servlet.a aVar = (com.tencent.relation.common.servlet.a) businessHandler;
                FeedPB$PublishFeedReq feedPB$PublishFeedReq = new FeedPB$PublishFeedReq();
                if (!list.isEmpty()) {
                    List<PicUploadResult> list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (PicUploadResult picUploadResult : list2) {
                        FeedPB$StImage feedPB$StImage = new FeedPB$StImage();
                        feedPB$StImage.url.set(picUploadResult.getUrl());
                        feedPB$StImage.width.set(picUploadResult.getWidth());
                        feedPB$StImage.high.set(picUploadResult.getHeight());
                        arrayList.add(feedPB$StImage);
                    }
                    feedPB$PublishFeedReq.pics.set(arrayList);
                    i16 = 2;
                } else {
                    i16 = 1;
                }
                feedPB$PublishFeedReq.feed_type.set(i16);
                feedPB$PublishFeedReq.text_content.set(ByteStringMicro.copyFromUtf8(str));
                if (i3 == 1) {
                    feedPB$PublishFeedReq.publish_scene.set(1);
                }
                aVar.Z0("QQStranger.FeedSvr.SsoFeedPublish", feedPB$PublishFeedReq.toByteArray(), new b() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.request.SquareFeedPublishRequest$reqPublish$2$4
                    @Override // com.tencent.mobileqq.app.BusinessObserver
                    public final void onUpdate(int i17, boolean z16, Object obj) {
                        if (z16 && (obj instanceof byte[])) {
                            FeedPB$PublishFeedRsp feedPB$PublishFeedRsp = new FeedPB$PublishFeedRsp();
                            try {
                                feedPB$PublishFeedRsp.mergeFrom((byte[]) obj);
                                int i18 = feedPB$PublishFeedRsp.ret_code.get();
                                if (i18 != 0) {
                                    QLog.e("SquareFeedPublishRequest", 1, "[reqPublish] onReceive. ret_code=" + i18);
                                }
                                String str2 = feedPB$PublishFeedRsp.feed.feed_id.get();
                                cancellableContinuationImpl.resume(new SquareFeedPublishResult(i18 == 0, 0, "", str2 == null || str2.length() == 0 ? null : feedPB$PublishFeedRsp.feed.get()), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.request.SquareFeedPublishRequest$reqPublish$2$4.3
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Throwable it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                        invoke2(th5);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return;
                            } catch (InvalidProtocolBufferMicroException e16) {
                                QLog.e("SquareFeedPublishRequest", 1, "[reqPublish] parse rsp error.", e16);
                                cancellableContinuationImpl.resume(new SquareFeedPublishResult(false, -1, "parse rsp error.", null, 8, null), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.request.SquareFeedPublishRequest$reqPublish$2$4.2
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Throwable it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                        invoke2(th5);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return;
                            }
                        }
                        QLog.e("SquareFeedPublishRequest", 1, "[reqPublish] server fail.");
                        cancellableContinuationImpl.resume(new SquareFeedPublishResult(false, -1, "server fail.", null, 8, null), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.request.SquareFeedPublishRequest$reqPublish$2$4.1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
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
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
