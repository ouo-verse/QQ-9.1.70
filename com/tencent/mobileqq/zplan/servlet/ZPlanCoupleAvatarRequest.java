package com.tencent.mobileqq.zplan.servlet;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J3\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0017J\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0016\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/ZPlanCoupleAvatarRequest;", "", "", "friendUin", "", "fieldId", "Lj55/a;", "profile", "", "isNeedNotifyPeer", "g", "(JILj55/a;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lk55/a;", "switchInfo", "f", "(JLk55/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSceneId", "needPush", "e", "(JIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Li55/a;", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "entryType", "", "idList", "Lcom/tencent/mobileqq/zplan/servlet/b;", "observer", "", "a", "", SquareJSConst.Params.PARAMS_UIN_LIST, "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanCoupleAvatarRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanCoupleAvatarRequest f335363a = new ZPlanCoupleAvatarRequest();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanCoupleAvatarRequest$a", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<List<i55.a>> f335364d;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super List<i55.a>> continuation) {
            this.f335364d = continuation;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            i55.c cVar;
            i55.a[] aVarArr;
            QLog.i("ZPlanCoupleAvatarRequest", 1, "requestGetAvatarBubble onUpdate, type " + type + ", success: " + isSuccess);
            if (!isSuccess) {
                Continuation<List<i55.a>> continuation = this.f335364d;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("requestGetAvatarBubble failed"))));
                return;
            }
            List list = null;
            try {
                cVar = i55.c.c(data instanceof byte[] ? (byte[]) data : null);
            } catch (Exception e16) {
                QLog.e("ZPlanCoupleAvatarRequest", 1, "requestGetAvatarBubble failed.", e16);
                cVar = null;
            }
            if (cVar != null && (aVarArr = cVar.f407263a) != null) {
                list = ArraysKt___ArraysKt.toList(aVarArr);
            }
            List list2 = list;
            if (list2 == null || list2.isEmpty()) {
                QLog.e("ZPlanCoupleAvatarRequest", 1, "requestGetAvatarBubble failed, bubbleList empty.");
                Continuation<List<i55.a>> continuation2 = this.f335364d;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("requestGetAvatarBubble failed"))));
                return;
            }
            this.f335364d.resumeWith(Result.m476constructorimpl(list));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanCoupleAvatarRequest$b", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<List<i55.a>> f335365d;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super List<i55.a>> continuation) {
            this.f335365d = continuation;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            i55.e eVar;
            i55.a[] aVarArr;
            QLog.i("ZPlanCoupleAvatarRequest", 1, "requestGetSettingPageBubble onUpdate, type " + type + ", success: " + isSuccess);
            if (!isSuccess) {
                Continuation<List<i55.a>> continuation = this.f335365d;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("requestGetSettingPageBubble failed"))));
                return;
            }
            List list = null;
            try {
                eVar = i55.e.c(data instanceof byte[] ? (byte[]) data : null);
            } catch (Exception e16) {
                QLog.e("ZPlanCoupleAvatarRequest", 1, "requestGetSettingPageBubble failed.", e16);
                eVar = null;
            }
            if (eVar != null && (aVarArr = eVar.f407264a) != null) {
                list = ArraysKt___ArraysKt.toList(aVarArr);
            }
            List list2 = list;
            if (list2 == null || list2.isEmpty()) {
                QLog.e("ZPlanCoupleAvatarRequest", 1, "requestGetSettingPageBubble failed, bubbleList empty.");
                Continuation<List<i55.a>> continuation2 = this.f335365d;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("requestGetSettingPageBubble failed"))));
                return;
            }
            this.f335365d.resumeWith(Result.m476constructorimpl(list));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanCoupleAvatarRequest$c", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f335366d;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super Boolean> continuation) {
            this.f335366d = continuation;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            Object m476constructorimpl;
            QLog.i("ZPlanCoupleAvatarRequest", 1, "requestSetProfile onUpdate, type " + type + ", success: " + isSuccess);
            Continuation<Boolean> continuation = this.f335366d;
            if (isSuccess) {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(Boolean.TRUE);
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(new Exception("requestSetProfile failed")));
            }
            continuation.resumeWith(m476constructorimpl);
        }
    }

    ZPlanCoupleAvatarRequest() {
    }

    private final Object g(long j3, int i3, j55.a aVar, boolean z16, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QLog.i("ZPlanCoupleAvatarRequest", 1, "requestSetProfile, uin: " + com.tencent.mobileqq.qcall.g.a(j3) + ", fieldId: " + i3 + ", profile: " + aVar);
        c cVar = new c(safeContinuation);
        j55.b bVar = new j55.b();
        bVar.f409505a = j3;
        bVar.f409506b = i3;
        bVar.f409507c = aVar;
        bVar.f409508d = z16;
        bVar.f409509e = System.currentTimeMillis();
        byte[] byteArray = MessageNano.toByteArray(bVar);
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("trpc.zplan.aio_profile.ProfileManager.SsoSetProfile", byteArray, cVar);
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void a(int entryType, int[] idList, com.tencent.mobileqq.zplan.servlet.b observer) {
        Intrinsics.checkNotNullParameter(idList, "idList");
        Intrinsics.checkNotNullParameter(observer, "observer");
        QLog.i("ZPlanCoupleAvatarRequest", 1, "requestBatchSceneConfig, entryType: " + entryType + ", idList: " + idList);
        ku4.f fVar = new ku4.f();
        fVar.f413103a = entryType;
        fVar.f413104b = AppSetting.f99551k + "." + AppSetting.f99542b;
        fVar.f413105c = idList;
        byte[] byteArray = MessageNano.toByteArray(fVar);
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("trpc.zplan.aio_avatar.Mobile.SsoBatchGetSceneConfig", byteArray, observer);
        }
    }

    public final void b(long[] uinList, com.tencent.mobileqq.zplan.servlet.b observer) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(observer, "observer");
        QLog.i("ZPlanCoupleAvatarRequest", 1, "requestBothSceneInfosByUinList uinList: " + uinList);
        wv4.a aVar = new wv4.a();
        aVar.f446591a = uinList;
        byte[] byteArray = MessageNano.toByteArray(aVar);
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("trpc.zplan.aio_profile.SsoProfileProviderV2.SsoGetAIOAvatarBothScene", byteArray, observer);
        }
    }

    public final Object c(Continuation<? super List<i55.a>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QLog.i("ZPlanCoupleAvatarRequest", 1, "requestGetAvatarBubble");
        a aVar = new a(safeContinuation);
        byte[] byteArray = MessageNano.toByteArray(new i55.b());
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("trpc.zplan.aio_bubble.BubbleManager.SsoGetAvatarBubble", byteArray, aVar);
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object d(Continuation<? super List<i55.a>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QLog.i("ZPlanCoupleAvatarRequest", 1, "requestGetSettingPageBubble");
        b bVar = new b(safeContinuation);
        byte[] byteArray = MessageNano.toByteArray(new i55.d());
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("trpc.zplan.aio_bubble.BubbleManager.SsoGetSettingPageBubble", byteArray, bVar);
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(5:19|(1:30)(1:23)|(1:25)(1:29)|26|(1:28))|12|13|14))|32|6|7|(0)(0)|12|13|14) */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(long j3, int i3, boolean z16, Continuation<? super Boolean> continuation) {
        ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1 zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1;
        Object coroutine_suspended;
        int i16;
        if (continuation instanceof ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1) {
            zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1 = (ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1) continuation;
            int i17 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1.label = i17 - Integer.MIN_VALUE;
                ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1 zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$12 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1;
                Object obj = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$12.label;
                boolean z17 = false;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    j55.a aVar = new j55.a();
                    aVar.f409504b = i3;
                    boolean z18 = z16 && ZPlanQQMC.INSTANCE.enableAIOSceneLinkage();
                    zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$12.J$0 = j3;
                    zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$12.I$0 = i3;
                    zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$12.label = 1;
                    obj = g(j3, 2, aVar, z18, zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i16 == 1) {
                    i3 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$12.I$0;
                    j3 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$12.J$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z17 = ((Boolean) obj).booleanValue();
                QLog.i("ZPlanCoupleAvatarRequest", 1, "requestSetCoupleAvatarSceneId success: " + z17 + ", friendUin: " + j3 + ", updatedSceneId: " + i3);
                return Boxing.boxBoolean(z17);
            }
        }
        zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1 = new ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1(this, continuation);
        ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1 zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$122 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$1;
        Object obj2 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSceneId$122.label;
        boolean z172 = false;
        if (i16 != 0) {
        }
        z172 = ((Boolean) obj2).booleanValue();
        QLog.i("ZPlanCoupleAvatarRequest", 1, "requestSetCoupleAvatarSceneId success: " + z172 + ", friendUin: " + j3 + ", updatedSceneId: " + i3);
        return Boxing.boxBoolean(z172);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(3:19|20|(1:22))|12|13|14))|24|6|7|(0)(0)|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
    
        r13 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(long j3, k55.a aVar, Continuation<? super Boolean> continuation) {
        ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1 zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1) {
            zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1 = (ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1) continuation;
            int i16 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1.label = i16 - Integer.MIN_VALUE;
                ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1 zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$12 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1;
                Object obj = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    j55.a aVar2 = new j55.a();
                    aVar2.f409503a = aVar;
                    zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$12.L$0 = aVar;
                    zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$12.J$0 = j3;
                    zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$12.label = 1;
                    obj = g(j3, 1, aVar2, false, zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    j3 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$12.J$0;
                    aVar = (k55.a) zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$12.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z16 = ((Boolean) obj).booleanValue();
                QLog.i("ZPlanCoupleAvatarRequest", 1, "requestSetCoupleAvatarSwitch success: " + z16 + ", friendUin: " + j3 + ", switchInfoStatus: " + aVar.f411718b);
                return Boxing.boxBoolean(z16);
            }
        }
        zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1 = new ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1(this, continuation);
        ZPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1 zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$122 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$1;
        Object obj2 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanCoupleAvatarRequest$requestSetCoupleAvatarSwitch$122.label;
        if (i3 != 0) {
        }
        boolean z162 = ((Boolean) obj2).booleanValue();
        QLog.i("ZPlanCoupleAvatarRequest", 1, "requestSetCoupleAvatarSwitch success: " + z162 + ", friendUin: " + j3 + ", switchInfoStatus: " + aVar.f411718b);
        return Boxing.boxBoolean(z162);
    }
}
