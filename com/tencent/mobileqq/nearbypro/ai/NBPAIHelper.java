package com.tencent.mobileqq.nearbypro.ai;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.nearbypro.ai.NBPAIHelper;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.api.h;
import com.tencent.rdelivery.reshub.api.i;
import com.tencent.rdelivery.reshub.api.n;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002-.B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0019\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 J\u0013\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0082 J\t\u0010\u000b\u001a\u00020\nH\u0082 JL\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2:\u0010\u0013\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eH\u0003JL\u0010\u0015\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2:\u0010\u0013\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eH\u0002J\"\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\nR\u0016\u0010\u001e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010*\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b)\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/ai/NBPAIHelper;", "", "", "modelParam", "modelBin", "", "initDetector", "imagePath", "", "detect", "", QCircleLpReportDc05507.KEY_CLEAR, "", "minVersion", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", "callback", "l", "k", "minSoVersion", "minModelVersion", "Lcom/tencent/mobileqq/nearbypro/ai/NBPAIHelper$a;", "i", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "Z", "isLoadSoSuccess", "c", "isEnvReady", "d", "isRunning", "Lcom/tencent/mobileqq/nearbypro/ai/NBPAIHelper$NBPAIFetcher;", "e", "Lkotlin/Lazy;", h.F, "()Lcom/tencent/mobileqq/nearbypro/ai/NBPAIHelper$NBPAIFetcher;", "soFetcher", "g", "resFetcher", "<init>", "()V", "a", "NBPAIFetcher", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBPAIHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NBPAIHelper f253088a = new NBPAIHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isLoadSoSuccess;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isEnvReady;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isRunning;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy soFetcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy resFetcher;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002JD\u0010\u000e\u001a\u00020\f2:\u0010\r\u001a6\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006H\u0002JJ\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022:\u0010\r\u001a6\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/ai/NBPAIHelper$NBPAIFetcher;", "", "", "f", "", "e", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", "", "callback", "c", "minVersion", "filePath", "d", "Lcom/tencent/rdelivery/reshub/api/i;", "a", "Lcom/tencent/rdelivery/reshub/api/i;", "resHub", "b", "Ljava/lang/String;", "resId", "Lcom/tencent/rdelivery/reshub/api/g;", "Lcom/tencent/rdelivery/reshub/api/g;", "latestResInfo", "<init>", "(Lcom/tencent/rdelivery/reshub/api/i;Ljava/lang/String;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class NBPAIFetcher {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final i resHub;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String resId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private g latestResInfo;

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/nearbypro/ai/NBPAIHelper$NBPAIFetcher$b", "Lcom/tencent/rdelivery/reshub/api/h;", "", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "res", "Lcom/tencent/rdelivery/reshub/api/n;", "error", "", "onComplete", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes15.dex */
        public static final class b implements com.tencent.rdelivery.reshub.api.h {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function2<Boolean, String, Unit> f253099b;

            /* JADX WARN: Multi-variable type inference failed */
            b(Function2<? super Boolean, ? super String, Unit> function2) {
                this.f253099b = function2;
            }

            @Override // com.tencent.rdelivery.reshub.api.h
            public void onComplete(boolean isSuccess, @Nullable g res, @NotNull n error) {
                Intrinsics.checkNotNullParameter(error, "error");
                NBPAIFetcher.this.latestResInfo = res;
                if (isSuccess && res != null) {
                    Function2<Boolean, String, Unit> function2 = this.f253099b;
                    if (function2 != null) {
                        function2.invoke(Boolean.TRUE, null);
                        return;
                    }
                    return;
                }
                Function2<Boolean, String, Unit> function22 = this.f253099b;
                if (function22 != null) {
                    function22.invoke(Boolean.FALSE, "fetchRes error: " + error.b() + ", " + error.message());
                }
            }

            @Override // com.tencent.rdelivery.reshub.api.h
            public void onProgress(float f16) {
                h.a.a(this, f16);
            }
        }

        public NBPAIFetcher(@NotNull i resHub, @NotNull String resId) {
            Intrinsics.checkNotNullParameter(resHub, "resHub");
            Intrinsics.checkNotNullParameter(resId, "resId");
            this.resHub = resHub;
            this.resId = resId;
            this.latestResInfo = i.a.b(resHub, resId, false, 2, null);
        }

        private final void c(Function2<? super Boolean, ? super String, Unit> callback) {
            this.resHub.j(this.resId, new b(callback), true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String e() {
            g gVar = this.latestResInfo;
            if (gVar != null) {
                return gVar.e();
            }
            return null;
        }

        private final long f() {
            g gVar = this.latestResInfo;
            if (gVar != null) {
                return gVar.getVersion();
            }
            return -1L;
        }

        public final void d(long minVersion, @Nullable final Function2<? super Boolean, ? super String, Unit> callback) {
            boolean z16;
            long f16 = f();
            String e16 = e();
            if (f16 > 0 && f16 >= minVersion) {
                if (e16 != null && e16.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    if (callback != null) {
                        callback.invoke(Boolean.TRUE, e16);
                    }
                    c(null);
                    return;
                }
            }
            c(new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.ai.NBPAIHelper$NBPAIFetcher$getFilePath$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                    invoke(bool.booleanValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, @Nullable String str) {
                    String e17;
                    if (z17) {
                        Function2<Boolean, String, Unit> function2 = callback;
                        if (function2 != null) {
                            Boolean bool = Boolean.TRUE;
                            e17 = this.e();
                            function2.invoke(bool, e17);
                            return;
                        }
                        return;
                    }
                    Function2<Boolean, String, Unit> function22 = callback;
                    if (function22 != null) {
                        function22.invoke(Boolean.FALSE, str);
                    }
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/ai/NBPAIHelper$a;", "", "", "onInitSucceed", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface a {
        void onInitSucceed();
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NBPAIFetcher>() { // from class: com.tencent.mobileqq.nearbypro.ai.NBPAIHelper$soFetcher$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NBPAIHelper.NBPAIFetcher invoke() {
                return new NBPAIHelper.NBPAIFetcher(((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance(), "nearbypro_ai");
            }
        });
        soFetcher = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<NBPAIFetcher>() { // from class: com.tencent.mobileqq.nearbypro.ai.NBPAIHelper$resFetcher$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NBPAIHelper.NBPAIFetcher invoke() {
                return new NBPAIHelper.NBPAIFetcher(((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance(), "nearbypro_ai_res");
            }
        });
        resFetcher = lazy2;
    }

    NBPAIHelper() {
    }

    private final native void clear();

    private final native float[] detect(String imagePath);

    private final NBPAIFetcher g() {
        return (NBPAIFetcher) resFetcher.getValue();
    }

    private final NBPAIFetcher h() {
        return (NBPAIFetcher) soFetcher.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean initDetector(String modelParam, String modelBin);

    public static /* synthetic */ void j(NBPAIHelper nBPAIHelper, long j3, long j16, a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        nBPAIHelper.i(j3, j16, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(long minVersion, final Function2<? super Boolean, ? super String, Unit> callback) {
        g().d(minVersion, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.ai.NBPAIHelper$loadModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable String str) {
                boolean z17;
                boolean initDetector;
                j.c().e("NBPAIHelper", "loadModel start");
                z17 = NBPAIHelper.isRunning;
                if (!z17) {
                    Function2<Boolean, String, Unit> function2 = callback;
                    if (function2 != null) {
                        function2.invoke(Boolean.FALSE, "loadModel fail: isRunning false");
                        return;
                    }
                    return;
                }
                if (z16) {
                    if (!(str == null || str.length() == 0)) {
                        try {
                            initDetector = NBPAIHelper.f253088a.initDetector(str + "ncnn.param", str + "/ncnn.bin");
                            if (initDetector) {
                                j.c().e("NBPAIHelper", "loadModel success");
                                Function2<Boolean, String, Unit> function22 = callback;
                                if (function22 != null) {
                                    function22.invoke(Boolean.TRUE, null);
                                }
                            } else {
                                j.c().e("NBPAIHelper", "loadModel fail");
                                Function2<Boolean, String, Unit> function23 = callback;
                                if (function23 != null) {
                                    function23.invoke(Boolean.FALSE, "loadModel fail: init error");
                                }
                            }
                            return;
                        } catch (Exception e16) {
                            j.c().d("NBPAIHelper", "loadModel fail: " + e16.getMessage());
                            return;
                        }
                    }
                }
                Function2<Boolean, String, Unit> function24 = callback;
                if (function24 != null) {
                    function24.invoke(Boolean.FALSE, "loadModel fail: " + str);
                }
            }
        });
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private final void l(long minVersion, final Function2<? super Boolean, ? super String, Unit> callback) {
        if (isLoadSoSuccess) {
            if (callback != null) {
                callback.invoke(Boolean.TRUE, null);
                return;
            }
            return;
        }
        h().d(minVersion, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.ai.NBPAIHelper$loadSo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable String str) {
                boolean z17;
                j.c().e("NBPAIHelper", "loadSo start");
                z17 = NBPAIHelper.isRunning;
                if (!z17) {
                    Function2<Boolean, String, Unit> function2 = callback;
                    if (function2 != null) {
                        function2.invoke(Boolean.FALSE, "loadSo fail: isRunning false");
                        return;
                    }
                    return;
                }
                if (z16) {
                    if (!(str == null || str.length() == 0)) {
                        try {
                            System.load(str);
                            j.c().e("NBPAIHelper", "loadSo success");
                            NBPAIHelper.isLoadSoSuccess = true;
                            Function2<Boolean, String, Unit> function22 = callback;
                            if (function22 != null) {
                                function22.invoke(Boolean.TRUE, null);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            j.c().d("NBPAIHelper", "loadSo fail: " + e16.getMessage());
                            return;
                        }
                    }
                }
                Function2<Boolean, String, Unit> function23 = callback;
                if (function23 != null) {
                    function23.invoke(Boolean.FALSE, "loadSo fail: " + str);
                }
            }
        });
    }

    @Nullable
    public final float[] f(@NotNull String imagePath) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        if (!isEnvReady) {
            return null;
        }
        return detect(imagePath);
    }

    public final void i(long minSoVersion, final long minModelVersion, @Nullable final a callback) {
        isRunning = true;
        if (isEnvReady) {
            if (callback != null) {
                callback.onInitSucceed();
                return;
            }
            return;
        }
        l(minSoVersion, new Function2<Boolean, String, Unit>(minModelVersion, callback) { // from class: com.tencent.mobileqq.nearbypro.ai.NBPAIHelper$initEnv$1
            final /* synthetic */ NBPAIHelper.a $callback;
            final /* synthetic */ long $minModelVersion;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable String str) {
                if (z16) {
                    NBPAIHelper.f253088a.k(this.$minModelVersion, new Function2<Boolean, String, Unit>(null) { // from class: com.tencent.mobileqq.nearbypro.ai.NBPAIHelper$initEnv$1.1
                        final /* synthetic */ NBPAIHelper.a $callback;

                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str2) {
                            invoke(bool.booleanValue(), str2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z17, @Nullable String str2) {
                            if (z17) {
                                NBPAIHelper.isEnvReady = true;
                            }
                        }
                    });
                }
            }
        });
    }

    public final void m() {
        isRunning = false;
        if (isEnvReady) {
            isEnvReady = false;
            clear();
        }
    }
}
