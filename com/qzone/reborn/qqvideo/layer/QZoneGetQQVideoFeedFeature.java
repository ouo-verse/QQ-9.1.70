package com.qzone.reborn.qqvideo.layer;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.request.QFSConvertToXWorldRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudConvertidClient$ConvertToXWorldRsp;
import feedcloud.FeedCloudConvertidClient$IDItem;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002Ja\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2(\u0010\u0012\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00102\u001c\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u000bR\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/qqvideo/layer/QZoneGetQQVideoFeedFeature;", "", "", "i", "k", "", "j", "", "feedId", "", h.F, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lfeedcloud/FeedCloudConvertidClient$ConvertToXWorldRsp;", "rsp", "l", "T", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "predicate", "Lkotlin/Function1;", "block", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", DomainData.DOMAIN_NAME, "a", "I", "checkFeedCount", "<init>", "()V", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneGetQQVideoFeedFeature {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int checkFeedCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/qqvideo/layer/QZoneGetQQVideoFeedFeature$a;", "", "", "a", "", "TAG_PREFIX", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.qqvideo.layer.QZoneGetQQVideoFeedFeature$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QQ_VIDEO_ENABLE_CONVERT_FEED_ID, true);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\n0\n2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\f0\fH\n\u00a2\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "isSuccess", "", "retCode", "", "errMsg", "", "rsp", "", "onReceive"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public static final class b<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSConvertToXWorldRequest f58789a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f58790b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f58791c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QZoneGetQQVideoFeedFeature f58792d;

        /* JADX WARN: Multi-variable type inference failed */
        b(QFSConvertToXWorldRequest qFSConvertToXWorldRequest, String str, CancellableContinuation<? super Boolean> cancellableContinuation, QZoneGetQQVideoFeedFeature qZoneGetQQVideoFeedFeature) {
            this.f58789a = qFSConvertToXWorldRequest;
            this.f58790b = str;
            this.f58791c = cancellableContinuation;
            this.f58792d = qZoneGetQQVideoFeedFeature;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            QLog.i("upload2-QZoneGetQQVideoFeedFeature", 1, "[doCheckFeedDetail][onReceive] isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str + ", traceId: " + this.f58789a.getTraceId() + "\uff0cfeedId:" + this.f58790b);
            if (this.f58791c.isActive()) {
                if (z16 && j3 == 0) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type feedcloud.FeedCloudConvertidClient.ConvertToXWorldRsp");
                    FeedCloudConvertidClient$ConvertToXWorldRsp feedCloudConvertidClient$ConvertToXWorldRsp = (FeedCloudConvertidClient$ConvertToXWorldRsp) obj;
                    boolean l3 = this.f58792d.l(feedCloudConvertidClient$ConvertToXWorldRsp);
                    QLog.i("upload2-QZoneGetQQVideoFeedFeature", 1, "[doCheckFeedDetail][onReceive] itemInfo size:" + feedCloudConvertidClient$ConvertToXWorldRsp.id_items.size() + ",rspSuccess:" + l3);
                    CancellableContinuation<Boolean> cancellableContinuation = this.f58791c;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(l3)));
                    return;
                }
                CancellableContinuation<Boolean> cancellableContinuation2 = this.f58791c;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h(String str, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QFSConvertToXWorldRequest qFSConvertToXWorldRequest = new QFSConvertToXWorldRequest(str);
        VSNetworkHelper.getInstance().sendRequest(qFSConvertToXWorldRequest, new b(qFSConvertToXWorldRequest, str, cancellableContinuationImpl, this));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long i() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QQ_VIDEO_GET_REAL_FEED_DELAY, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QQ_VIDEO_GET_REAL_FEED_MAX_RETRY_COUNT, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long k() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QQ_VIDEO_GET_REAL_FEED_RETRY_DELAY, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(FeedCloudConvertidClient$ConvertToXWorldRsp rsp) {
        PBRepeatMessageField<FeedCloudConvertidClient$IDItem> pBRepeatMessageField = rsp.id_items;
        if (pBRepeatMessageField.isEmpty()) {
            QLog.i("upload2-QZoneGetQQVideoFeedFeature", 1, "[isRspSuccess]idItems is empty");
            return false;
        }
        String str = pBRepeatMessageField.get(0).feedsid.get();
        int i3 = pBRepeatMessageField.get(0).status.get();
        QLog.i("upload2-QZoneGetQQVideoFeedFeature", 1, "[isRspSuccess]feedsid:" + str + ",status:" + i3);
        return !TextUtils.isEmpty(str) && i3 == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0093 -> B:11:0x009b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object m(Function3<? super Integer, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        QZoneGetQQVideoFeedFeature$retryWithResult$1 qZoneGetQQVideoFeedFeature$retryWithResult$1;
        Object coroutine_suspended;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        Function3<? super Integer, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function32;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        Object invoke;
        Object invoke2;
        boolean z16;
        if (continuation instanceof QZoneGetQQVideoFeedFeature$retryWithResult$1) {
            qZoneGetQQVideoFeedFeature$retryWithResult$1 = (QZoneGetQQVideoFeedFeature$retryWithResult$1) continuation;
            int i26 = qZoneGetQQVideoFeedFeature$retryWithResult$1.label;
            if ((i26 & Integer.MIN_VALUE) != 0) {
                qZoneGetQQVideoFeedFeature$retryWithResult$1.label = i26 - Integer.MIN_VALUE;
                Object obj = qZoneGetQQVideoFeedFeature$retryWithResult$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qZoneGetQQVideoFeedFeature$retryWithResult$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    i16 = 10;
                    i17 = 0;
                    qZoneGetQQVideoFeedFeature$retryWithResult$1.L$0 = function3;
                    qZoneGetQQVideoFeedFeature$retryWithResult$1.L$1 = function1;
                    qZoneGetQQVideoFeedFeature$retryWithResult$1.L$2 = null;
                    qZoneGetQQVideoFeedFeature$retryWithResult$1.I$0 = i17;
                    qZoneGetQQVideoFeedFeature$retryWithResult$1.I$1 = i16;
                    qZoneGetQQVideoFeedFeature$retryWithResult$1.label = 1;
                    invoke2 = function1.invoke(qZoneGetQQVideoFeedFeature$retryWithResult$1);
                    if (invoke2 != coroutine_suspended) {
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            int i27 = qZoneGetQQVideoFeedFeature$retryWithResult$1.I$1;
                            i18 = qZoneGetQQVideoFeedFeature$retryWithResult$1.I$0;
                            Object obj2 = qZoneGetQQVideoFeedFeature$retryWithResult$1.L$2;
                            Function1<? super Continuation<? super T>, ? extends Object> function13 = (Function1) qZoneGetQQVideoFeedFeature$retryWithResult$1.L$1;
                            Function3<? super Integer, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function33 = (Function3) qZoneGetQQVideoFeedFeature$retryWithResult$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            QZoneGetQQVideoFeedFeature$retryWithResult$1 qZoneGetQQVideoFeedFeature$retryWithResult$12 = qZoneGetQQVideoFeedFeature$retryWithResult$1;
                            int i28 = i27;
                            function3 = function33;
                            Object obj3 = obj2;
                            function12 = function13;
                            Object obj4 = coroutine_suspended;
                            QZoneGetQQVideoFeedFeature$retryWithResult$1 qZoneGetQQVideoFeedFeature$retryWithResult$13 = qZoneGetQQVideoFeedFeature$retryWithResult$12;
                            if (((Boolean) obj).booleanValue()) {
                                z16 = false;
                            } else {
                                QLog.d("upload2-QZoneGetQQVideoFeedFeature-retryWithResult", 1, "attempt=" + i18 + ", result=" + obj3);
                                i18++;
                                z16 = true;
                            }
                            if (z16 || i18 >= i28) {
                                return obj3;
                            }
                            i16 = i28;
                            qZoneGetQQVideoFeedFeature$retryWithResult$1 = qZoneGetQQVideoFeedFeature$retryWithResult$13;
                            coroutine_suspended = obj4;
                            Function1<? super Continuation<? super T>, ? extends Object> function14 = function12;
                            i17 = i18;
                            function1 = function14;
                            qZoneGetQQVideoFeedFeature$retryWithResult$1.L$0 = function3;
                            qZoneGetQQVideoFeedFeature$retryWithResult$1.L$1 = function1;
                            qZoneGetQQVideoFeedFeature$retryWithResult$1.L$2 = null;
                            qZoneGetQQVideoFeedFeature$retryWithResult$1.I$0 = i17;
                            qZoneGetQQVideoFeedFeature$retryWithResult$1.I$1 = i16;
                            qZoneGetQQVideoFeedFeature$retryWithResult$1.label = 1;
                            invoke2 = function1.invoke(qZoneGetQQVideoFeedFeature$retryWithResult$1);
                            if (invoke2 != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function32 = function3;
                            i19 = i16;
                            obj = invoke2;
                            int i29 = i17;
                            function12 = function1;
                            i18 = i29;
                            Integer boxInt = Boxing.boxInt(i18);
                            qZoneGetQQVideoFeedFeature$retryWithResult$1.L$0 = function32;
                            qZoneGetQQVideoFeedFeature$retryWithResult$1.L$1 = function12;
                            qZoneGetQQVideoFeedFeature$retryWithResult$1.L$2 = obj;
                            qZoneGetQQVideoFeedFeature$retryWithResult$1.I$0 = i18;
                            qZoneGetQQVideoFeedFeature$retryWithResult$1.I$1 = i19;
                            qZoneGetQQVideoFeedFeature$retryWithResult$1.label = 2;
                            invoke = function32.invoke(boxInt, obj, qZoneGetQQVideoFeedFeature$retryWithResult$1);
                            if (invoke != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            QZoneGetQQVideoFeedFeature$retryWithResult$1 qZoneGetQQVideoFeedFeature$retryWithResult$14 = qZoneGetQQVideoFeedFeature$retryWithResult$1;
                            i28 = i19;
                            function3 = function32;
                            obj4 = coroutine_suspended;
                            qZoneGetQQVideoFeedFeature$retryWithResult$13 = qZoneGetQQVideoFeedFeature$retryWithResult$14;
                            obj3 = obj;
                            obj = invoke;
                            if (((Boolean) obj).booleanValue()) {
                            }
                            if (z16) {
                            }
                            return obj3;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i19 = qZoneGetQQVideoFeedFeature$retryWithResult$1.I$1;
                    i18 = qZoneGetQQVideoFeedFeature$retryWithResult$1.I$0;
                    function12 = (Function1) qZoneGetQQVideoFeedFeature$retryWithResult$1.L$1;
                    function32 = (Function3) qZoneGetQQVideoFeedFeature$retryWithResult$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    Integer boxInt2 = Boxing.boxInt(i18);
                    qZoneGetQQVideoFeedFeature$retryWithResult$1.L$0 = function32;
                    qZoneGetQQVideoFeedFeature$retryWithResult$1.L$1 = function12;
                    qZoneGetQQVideoFeedFeature$retryWithResult$1.L$2 = obj;
                    qZoneGetQQVideoFeedFeature$retryWithResult$1.I$0 = i18;
                    qZoneGetQQVideoFeedFeature$retryWithResult$1.I$1 = i19;
                    qZoneGetQQVideoFeedFeature$retryWithResult$1.label = 2;
                    invoke = function32.invoke(boxInt2, obj, qZoneGetQQVideoFeedFeature$retryWithResult$1);
                    if (invoke != coroutine_suspended) {
                    }
                }
            }
        }
        qZoneGetQQVideoFeedFeature$retryWithResult$1 = new QZoneGetQQVideoFeedFeature$retryWithResult$1(this, continuation);
        Object obj5 = qZoneGetQQVideoFeedFeature$retryWithResult$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qZoneGetQQVideoFeedFeature$retryWithResult$1.label;
        if (i3 != 0) {
        }
    }

    public final Object n(String str, Continuation<? super Boolean> continuation) {
        QLog.i("upload2-QZoneGetQQVideoFeedFeature", 1, "[tryCheckFeedComplete]");
        this.checkFeedCount = 0;
        return m(new QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$2(this, null), new QZoneGetQQVideoFeedFeature$tryCheckFeedComplete$3(this, str, null), continuation);
    }
}
