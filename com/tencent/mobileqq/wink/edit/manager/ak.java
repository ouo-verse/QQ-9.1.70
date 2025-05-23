package com.tencent.mobileqq.wink.edit.manager;

import androidx.core.util.Consumer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y53.a;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u001aF\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001aF\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\f\u001aN\u0010\u0011\u001a\u00020\n*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001aF\u0010\u0014\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000e2%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0017\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceManager;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "metaMaterial", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "progressCallback", "", "c", "(Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceManager;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "", "url", "savePath", "e", "(Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceManager;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "agentType", "g", "(Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceManager;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "path", "i", "(Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceManager;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ak {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/edit/manager/ak$a", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements ResDownLoadListener {

        /* renamed from: a */
        final /* synthetic */ Continuation<Boolean> f318398a;

        /* renamed from: b */
        final /* synthetic */ Function1<Integer, Unit> f318399b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Boolean> continuation, Function1<? super Integer, Unit> function1) {
            this.f318398a = continuation;
            this.f318399b = function1;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            this.f318398a.resumeWith(Result.m476constructorimpl(Boolean.valueOf(isSuccess)));
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
            Function1<Integer, Unit> function1 = this.f318399b;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(progress));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/edit/manager/ak$b", "Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceDownloader$d;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkEditorResourceDownloader.d {

        /* renamed from: a */
        final /* synthetic */ Continuation<Boolean> f318400a;

        /* renamed from: b */
        final /* synthetic */ Function1<Integer, Unit> f318401b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super Boolean> continuation, Function1<? super Integer, Unit> function1) {
            this.f318400a = continuation;
            this.f318401b = function1;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean isSuccess) {
            this.f318400a.resumeWith(Result.m476constructorimpl(Boolean.valueOf(isSuccess)));
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int progress) {
            Function1<Integer, Unit> function1 = this.f318401b;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(progress));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/edit/manager/ak$c", "Ly53/a$a;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "a", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements a.InterfaceC11592a {

        /* renamed from: a */
        final /* synthetic */ CancellableContinuation<Boolean> f318402a;

        /* renamed from: b */
        final /* synthetic */ String f318403b;

        /* renamed from: c */
        final /* synthetic */ Function1<Integer, Unit> f318404c;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super Boolean> cancellableContinuation, String str, Function1<? super Integer, Unit> function1) {
            this.f318402a = cancellableContinuation;
            this.f318403b = str;
            this.f318404c = function1;
        }

        @Override // y53.a.InterfaceC11592a
        public void a(@Nullable NetResp resp) {
            Integer num;
            if (resp != null && resp.mResult == 0) {
                CancellableContinuation<Boolean> cancellableContinuation = this.f318402a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                return;
            }
            String str = this.f318403b;
            if (resp != null) {
                num = Integer.valueOf(resp.mErrCode);
            } else {
                num = null;
            }
            w53.b.c("WinkEditorResourceManager", "download " + str + " failed, ErrorCode: " + num);
            CancellableContinuation<Boolean> cancellableContinuation2 = this.f318402a;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int progress) {
            Function1<Integer, Unit> function1 = this.f318404c;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(progress));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/wink/edit/manager/ak$d", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d */
        final /* synthetic */ String f318405d;

        /* renamed from: e */
        final /* synthetic */ Continuation<Boolean> f318406e;

        /* renamed from: f */
        final /* synthetic */ Function1<Integer, Unit> f318407f;

        /* JADX WARN: Multi-variable type inference failed */
        d(String str, Continuation<? super Boolean> continuation, Function1<? super Integer, Unit> function1) {
            this.f318405d = str;
            this.f318406e = continuation;
            this.f318407f = function1;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(@Nullable AEResInfo aeResInfo, @Nullable String localFilePath, boolean downloaded, int r46) {
            String str;
            if (aeResInfo != null) {
                str = aeResInfo.agentType;
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, this.f318405d)) {
                return;
            }
            if (r46 != 0 && r46 != 1) {
                w53.b.c("WinkEditorResourceManager", "fetchSingleBundle failed: " + r46);
                Continuation<Boolean> continuation = this.f318406e;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
                return;
            }
            Continuation<Boolean> continuation2 = this.f318406e;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(@Nullable AEResInfo aeResInfo, long currentOffset, long totalLength) {
            int i3 = (int) ((currentOffset / totalLength) * 100);
            Function1<Integer, Unit> function1 = this.f318407f;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/biz/richframework/util/bean/RFWSaveMediaResultBean;", "kotlin.jvm.PlatformType", "insertResult", "", "a", "(Lcom/tencent/biz/richframework/util/bean/RFWSaveMediaResultBean;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e<T> implements Consumer {

        /* renamed from: d */
        final /* synthetic */ Continuation<Boolean> f318408d;

        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super Boolean> continuation) {
            this.f318408d = continuation;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a */
        public final void accept(RFWSaveMediaResultBean rFWSaveMediaResultBean) {
            w53.b.f("WinkEditorResourceManagerUtils", "saveMediaToSystem result " + rFWSaveMediaResultBean.isSuccess);
            Continuation<Boolean> continuation = this.f318408d;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(rFWSaveMediaResultBean.isSuccess)));
        }
    }

    @Nullable
    public static final Object a(@NotNull WinkEditorResourceManager winkEditorResourceManager, @NotNull MetaMaterial metaMaterial, @Nullable Function1<? super Integer, Unit> function1, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        WinkEditorResourceManager.a1().f0(metaMaterial, new a(safeContinuation, function1));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static /* synthetic */ Object b(WinkEditorResourceManager winkEditorResourceManager, MetaMaterial metaMaterial, Function1 function1, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        return a(winkEditorResourceManager, metaMaterial, function1, continuation);
    }

    @Nullable
    public static final Object c(@NotNull WinkEditorResourceManager winkEditorResourceManager, @NotNull MetaMaterial metaMaterial, @Nullable Function1<? super Integer, Unit> function1, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        WinkEditorResourceManager.a1().f(metaMaterial, new b(safeContinuation, function1));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static /* synthetic */ Object d(WinkEditorResourceManager winkEditorResourceManager, MetaMaterial metaMaterial, Function1 function1, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        return c(winkEditorResourceManager, metaMaterial, function1, continuation);
    }

    @Nullable
    public static final Object e(@NotNull WinkEditorResourceManager winkEditorResourceManager, @NotNull String str, @NotNull String str2, @Nullable Function1<? super Integer, Unit> function1, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        y53.a.c().a(str, str2, new c(cancellableContinuationImpl, str, function1));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object f(WinkEditorResourceManager winkEditorResourceManager, String str, String str2, Function1 function1, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        return e(winkEditorResourceManager, str, str2, function1, continuation);
    }

    @Nullable
    public static final Object g(@NotNull WinkEditorResourceManager winkEditorResourceManager, @NotNull String str, @Nullable Function1<? super Integer, Unit> function1, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(str, new d(str, safeContinuation, function1));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static /* synthetic */ Object h(WinkEditorResourceManager winkEditorResourceManager, String str, Function1 function1, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        return g(winkEditorResourceManager, str, function1, continuation);
    }

    @Nullable
    public static final Object i(@NotNull WinkEditorResourceManager winkEditorResourceManager, @NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        try {
            RFWSaveUtil.insertMedia(BaseApplication.context, str, new e(safeContinuation));
        } catch (Throwable th5) {
            w53.b.d("WinkEditorResourceManagerUtils", "saveMediaToSystem save failed ", th5);
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
