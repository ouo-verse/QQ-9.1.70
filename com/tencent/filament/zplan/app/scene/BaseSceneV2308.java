package com.tencent.filament.zplan.app.scene;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CallSuper;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.impl.FilamentThreadHandler;
import com.tencent.filament.zplan.util.vsync.VSyncScheduler;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.c;
import dl0.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u00012\b&\u0018\u0000 >2\u00020\u0001:\u0001?B\u001f\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010;\u001a\b\u0012\u0004\u0012\u00020706\u00a2\u0006\u0004\b<\u0010=J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017J\b\u0010\n\u001a\u00020\u0003H\u0017J\b\u0010\u000b\u001a\u00020\u0003H\u0017J\b\u0010\f\u001a\u00020\u0003H\u0017J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0017J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0017J \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0017J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0012H\u0017J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0012H\u0017J\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u0004\u0018\u00010.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u000207068\u0006\u00a2\u0006\f\n\u0004\b\b\u00108\u001a\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/filament/zplan/app/scene/BaseSceneV2308;", "Lcom/tencent/filament/zplan/util/vsync/b;", "Lkotlin/Function0;", "", "task", "w", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", DomainData.DOMAIN_NAME, "", "errorCode", "", "errorMessage", "o", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "width", "height", ReportConstant.COSTREPORT_PREFIX, "u", "surface", "v", "t", "", "fps", HippyTKDListViewAdapter.X, "(F)V", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "mainHandler", "Lcom/tencent/filament/zplan/app/impl/FilamentThreadHandler;", "e", "Lkotlin/Lazy;", "k", "()Lcom/tencent/filament/zplan/app/impl/FilamentThreadHandler;", "filamentThreadHandler", "Lcom/tencent/filament/zplan/util/vsync/VSyncScheduler;", "f", "l", "()Lcom/tencent/filament/zplan/util/vsync/VSyncScheduler;", "vSyncScheduler", "Lcom/tencent/zplan/zplantracing/b;", h.F, "Lcom/tencent/zplan/zplantracing/b;", "loadSoSpan", "com/tencent/filament/zplan/app/scene/BaseSceneV2308$b", "i", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2308$b;", "loadSoListener", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "Ljava/lang/ref/WeakReference;", "j", "()Ljava/lang/ref/WeakReference;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public abstract class BaseSceneV2308 implements com.tencent.filament.zplan.util.vsync.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Handler mainHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy filamentThreadHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy vSyncScheduler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.zplan.zplantracing.b loadSoSpan;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final b loadSoListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FilamentNativeAppV2305> app;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/filament/zplan/app/scene/BaseSceneV2308$b", "Lgl0/b;", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class b implements gl0.b {
        b() {
        }

        @Override // gl0.b
        public void a(boolean isSuccess, boolean downloadSo, int errCode, @Nullable String errMsg) {
            FLog.INSTANCE.i("BaseSceneV2308", "load so. isSuccess: " + isSuccess + ", errCode: " + errCode + ", errMsg: " + errMsg);
            com.tencent.zplan.zplantracing.b bVar = BaseSceneV2308.this.loadSoSpan;
            if (bVar != null) {
                bVar.e("download_so", String.valueOf(downloadSo));
            }
            if (!isSuccess) {
                com.tencent.zplan.zplantracing.b bVar2 = BaseSceneV2308.this.loadSoSpan;
                if (bVar2 != null) {
                    bVar2.a(null);
                }
                BaseSceneV2308.this.o(401001, "load so fail. download_so:" + downloadSo);
                return;
            }
            com.tencent.zplan.zplantracing.b bVar3 = BaseSceneV2308.this.loadSoSpan;
            if (bVar3 != null) {
                bVar3.b();
            }
            BaseSceneV2308.this.k().i();
        }
    }

    public BaseSceneV2308(@Nullable c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
        this.mainHandler = new Handler(Looper.getMainLooper());
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FilamentThreadHandler>() { // from class: com.tencent.filament.zplan.app.scene.BaseSceneV2308$filamentThreadHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FilamentThreadHandler invoke() {
                return new FilamentThreadHandler(FilamentFeatureUtil.f106409g.x());
            }
        });
        this.filamentThreadHandler = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<VSyncScheduler>() { // from class: com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "command", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "execute"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2$1, reason: invalid class name */
            /* loaded from: classes6.dex */
            public static final class AnonymousClass1 implements Executor {

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f105611e;

                AnonymousClass1(int i3) {
                    this.f105611e = i3;
                }

                @Override // java.util.concurrent.Executor
                public final void execute(final Runnable runnable) {
                    if (runnable != null) {
                        BaseSceneV2308.this.k().e(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE 
                              (wrap:com.tencent.filament.zplan.app.impl.FilamentThreadHandler:0x0006: INVOKE 
                              (wrap:com.tencent.filament.zplan.app.scene.BaseSceneV2308:0x0004: IGET 
                              (wrap:com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2:0x0002: IGET (r2v0 'this' com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2$1 A[IMMUTABLE_TYPE, THIS]) A[WRAPPED] (LINE:3) com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2.1.d com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2)
                             A[WRAPPED] (LINE:5) com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2.this$0 com.tencent.filament.zplan.app.scene.BaseSceneV2308)
                             VIRTUAL call: com.tencent.filament.zplan.app.scene.BaseSceneV2308.k():com.tencent.filament.zplan.app.impl.FilamentThreadHandler A[MD:():com.tencent.filament.zplan.app.impl.FilamentThreadHandler (m), WRAPPED] (LINE:7))
                              (wrap:kotlin.jvm.functions.Function0<kotlin.Unit>:0x000c: CONSTRUCTOR 
                              (r3v0 'runnable' java.lang.Runnable A[DONT_INLINE])
                              (r2v0 'this' com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2$1 A[DONT_INLINE, IMMUTABLE_TYPE, THIS])
                             A[MD:(java.lang.Runnable, com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2$1):void (m), WRAPPED] (LINE:13) call: com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2$1$$special$$inlined$let$lambda$1.<init>(java.lang.Runnable, com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2$1):void type: CONSTRUCTOR)
                             VIRTUAL call: com.tencent.filament.zplan.app.impl.FilamentThreadHandler.e(kotlin.jvm.functions.Function0):void A[MD:(kotlin.jvm.functions.Function0<kotlin.Unit>):void (m)] (LINE:16) in method: com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2.1.execute(java.lang.Runnable):void, file: classes6.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2$1$$special$$inlined$let$lambda$1, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 23 more
                            */
                        /*
                            this = this;
                            if (r3 == 0) goto L12
                            com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2 r0 = com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2.this
                            com.tencent.filament.zplan.app.scene.BaseSceneV2308 r0 = com.tencent.filament.zplan.app.scene.BaseSceneV2308.this
                            com.tencent.filament.zplan.app.impl.FilamentThreadHandler r0 = r0.k()
                            com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2$1$$special$$inlined$let$lambda$1 r1 = new com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2$1$$special$$inlined$let$lambda$1
                            r1.<init>(r3, r2)
                            r0.e(r1)
                        L12:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.filament.zplan.app.scene.BaseSceneV2308$vSyncScheduler$2.AnonymousClass1.execute(java.lang.Runnable):void");
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final VSyncScheduler invoke() {
                    a configuration;
                    FilamentNativeAppV2305 filamentNativeAppV2305 = BaseSceneV2308.this.j().get();
                    int fps = (filamentNativeAppV2305 == null || (configuration = filamentNativeAppV2305.getConfiguration()) == null) ? 15 : configuration.getFps();
                    return new VSyncScheduler(BaseSceneV2308.this, fps, new AnonymousClass1(fps));
                }
            });
            this.vSyncScheduler = lazy2;
            this.loadSoSpan = ZPlanSpanFactory.INSTANCE.startSpan("loadSo", cVar);
            this.loadSoListener = new b();
            FLog.INSTANCE.i("BaseSceneV2308", "scene init. app:" + app.get());
            m(cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final VSyncScheduler l() {
            return (VSyncScheduler) this.vSyncScheduler.getValue();
        }

        private final void m(c spanContext) {
            d dVar;
            a configuration;
            FilamentNativeAppV2305 filamentNativeAppV2305 = this.app.get();
            if (filamentNativeAppV2305 != null && (configuration = filamentNativeAppV2305.getConfiguration()) != null) {
                dVar = configuration.getLoadSoProxy();
            } else {
                dVar = null;
            }
            if (dVar == null) {
                FLog.INSTANCE.e("BaseSceneV2308", "loadSo() failed. proxy: null");
                com.tencent.zplan.zplantracing.b bVar = this.loadSoSpan;
                if (bVar != null) {
                    bVar.a("proxy is null");
                }
                o(401001, "loadSoProxy is unavailable");
                return;
            }
            dVar.a(new WeakReference<>(this.loadSoListener));
        }

        private final void w(final Function0<Unit> task) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                task.invoke();
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.tencent.filament.zplan.app.scene.BaseSceneV2308$postMainThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Function0.this.invoke();
                    }
                });
            }
        }

        @NotNull
        public final WeakReference<FilamentNativeAppV2305> j() {
            return this.app;
        }

        @NotNull
        public final FilamentThreadHandler k() {
            return (FilamentThreadHandler) this.filamentThreadHandler.getValue();
        }

        @CallSuper
        public void n() {
            w(new Function0<Unit>() { // from class: com.tencent.filament.zplan.app.scene.BaseSceneV2308$onDestroy$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    VSyncScheduler l3;
                    l3 = BaseSceneV2308.this.l();
                    l3.p();
                }
            });
        }

        @CallSuper
        public void o(int errorCode, @Nullable String errorMessage) {
            FLog.INSTANCE.e("BaseSceneV2308", "onError, errorCode:" + errorCode + ", errorMessage:" + errorMessage);
        }

        @CallSuper
        public void q() {
            w(new Function0<Unit>() { // from class: com.tencent.filament.zplan.app.scene.BaseSceneV2308$onPause$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    VSyncScheduler l3;
                    l3 = BaseSceneV2308.this.l();
                    l3.p();
                }
            });
        }

        @CallSuper
        public void r() {
            w(new Function0<Unit>() { // from class: com.tencent.filament.zplan.app.scene.BaseSceneV2308$onResume$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    VSyncScheduler l3;
                    l3 = BaseSceneV2308.this.l();
                    l3.o();
                }
            });
        }

        @CallSuper
        public void s(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        }

        @CallSuper
        public void t(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }

        @CallSuper
        public void u(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        }

        @CallSuper
        public void v(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }

        public final void x(float fps) {
            l().n(fps);
        }

        @CallSuper
        public void p(@Nullable c spanContext) {
        }
    }
