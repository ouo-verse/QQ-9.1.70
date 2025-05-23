package com.tencent.kuikly.core.render.android.expand;

import com.tencent.kuikly.core.render.android.KuiklyRenderView;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderNativeMethod;
import com.tencent.kuikly.core.render.android.context.e;
import com.tencent.kuikly.core.render.android.context.f;
import com.tencent.kuikly.core.render.android.context.h;
import com.tencent.kuikly.core.render.android.core.KuiklyRenderCore;
import com.tencent.kuikly.core.render.android.css.animation.KRCSSAnimation;
import com.tencent.kuikly.core.render.android.css.animation.n;
import com.tencent.kuikly.core.render.android.css.decoration.KRViewDecoration;
import com.tencent.kuikly.core.render.android.css.gesture.a;
import com.tencent.kuikly.core.render.android.css.ktx.b;
import com.tencent.kuikly.core.render.android.expand.component.KRAPNGView;
import com.tencent.kuikly.core.render.android.expand.component.KRActivityIndicatorView;
import com.tencent.kuikly.core.render.android.expand.component.KRCanvasView;
import com.tencent.kuikly.core.render.android.expand.component.KRHoverView;
import com.tencent.kuikly.core.render.android.expand.component.KRImageView;
import com.tencent.kuikly.core.render.android.expand.component.KRRichTextShadow;
import com.tencent.kuikly.core.render.android.expand.component.KRRichTextView;
import com.tencent.kuikly.core.render.android.expand.component.KRTextFieldView;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.kuikly.core.render.android.expand.component.KRWrapperImageView;
import com.tencent.kuikly.core.render.android.expand.component.blur.KRBlurView;
import com.tencent.kuikly.core.render.android.expand.component.d;
import com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerContentView;
import com.tencent.kuikly.core.render.android.expand.component.list.KRRecyclerView;
import com.tencent.kuikly.core.render.android.expand.component.pag.KRPAGView;
import com.tencent.kuikly.core.render.android.expand.module.KRLogModule;
import com.tencent.kuikly.core.render.android.expand.module.j;
import com.tencent.kuikly.core.render.android.expand.module.q;
import com.tencent.kuikly.core.render.android.expand.vendor.KRFileManager;
import com.tencent.kuikly.core.render.android.layer.KuiklyRenderLayerHandler;
import com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler;
import com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayCacheManager;
import com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayDiffPatch;
import com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayNode;
import com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayNodeMethod;
import com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayProp;
import com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayShadow;
import com.tencent.kuikly.core.render.android.turbo.KuiklyTurboDisplayRenderLayerHandler;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import d01.n;
import d01.u;
import d01.w;
import e01.c;
import f01.b;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0003J\u001c\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tR\u0016\u0010\r\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/KuiklyRenderClassLoad;", "", "Lkotlin/Function0;", "", "task", "a", "d", "Ljava/lang/ClassLoader;", "classLoader", "", "forceOnSubThread", "b", "Z", "didLoadRenderClass", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KuiklyRenderClassLoad {

    /* renamed from: a, reason: from kotlin metadata */
    private static boolean didLoadRenderClass;

    /* renamed from: b */
    @NotNull
    public static final KuiklyRenderClassLoad f117708b;

    static {
        KuiklyRenderClassLoad kuiklyRenderClassLoad = new KuiklyRenderClassLoad();
        f117708b = kuiklyRenderClassLoad;
        kuiklyRenderClassLoad.d();
    }

    KuiklyRenderClassLoad() {
    }

    private final void a(final Function0<Unit> task) {
        n k3 = u.f392615m.k();
        if (k3 != null) {
            k3.a(task);
        } else {
            final ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
            newSingleThreadExecutor.execute(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderClassLoad$executeOnSubThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    Function0.this.invoke();
                    newSingleThreadExecutor.shutdown();
                }
            });
        }
    }

    public static /* synthetic */ void c(KuiklyRenderClassLoad kuiklyRenderClassLoad, ClassLoader classLoader, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            classLoader = null;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        kuiklyRenderClassLoad.b(classLoader, z16);
    }

    public final void b(@Nullable final ClassLoader classLoader, boolean forceOnSubThread) {
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderClassLoad$loadCoreClass$loadClassAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                try {
                    ClassLoader classLoader2 = classLoader;
                    if (classLoader2 == null) {
                        classLoader2 = KuiklyRenderClassLoad.f117708b.getClass().getClassLoader();
                    }
                    Class.forName("com.tencent.kuikly.core.global.a", true, classLoader2).newInstance();
                } catch (Throwable th5) {
                    w.f392617a.b("KuiklyRenderClassLoad", "loadCoreClassException:" + b.u(th5));
                }
            }
        };
        if (!b.l() && !forceOnSubThread) {
            function0.invoke();
        } else {
            a(function0);
        }
    }

    public final void d() {
        if (didLoadRenderClass) {
            return;
        }
        didLoadRenderClass = true;
        a(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.KuiklyRenderClassLoad$loadRenderClassIfNeed$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    KuiklyRenderView.Companion companion = KuiklyRenderView.INSTANCE;
                    KuiklyRenderCore.a aVar = KuiklyRenderCore.f117544l;
                    e.a aVar2 = e.Companion;
                    KuiklyRenderLayerHandler.a aVar3 = KuiklyRenderLayerHandler.f118120g;
                    h.a aVar4 = h.f117540d;
                    KuiklyRenderCoreUIScheduler.Companion companion2 = KuiklyRenderCoreUIScheduler.INSTANCE;
                    f.a aVar5 = f.f117530d;
                    KRTurboDisplayCacheManager.Companion companion3 = KRTurboDisplayCacheManager.INSTANCE;
                    KRTurboDisplayDiffPatch.a aVar6 = KRTurboDisplayDiffPatch.f118210d;
                    KRTurboDisplayNode.Companion companion4 = KRTurboDisplayNode.INSTANCE;
                    KRTurboDisplayNodeMethod.Companion companion5 = KRTurboDisplayNodeMethod.INSTANCE;
                    KRTurboDisplayProp.Companion companion6 = KRTurboDisplayProp.INSTANCE;
                    KRTurboDisplayShadow.Companion companion7 = KRTurboDisplayShadow.INSTANCE;
                    KuiklyTurboDisplayRenderLayerHandler.a aVar7 = KuiklyTurboDisplayRenderLayerHandler.f118235u;
                    KuiklyRenderClassLoad.c(KuiklyRenderClassLoad.f117708b, null, false, 3, null);
                    KRView.Companion companion8 = KRView.INSTANCE;
                    KRImageView.Companion companion9 = KRImageView.INSTANCE;
                    KRRichTextView.Companion companion10 = KRRichTextView.INSTANCE;
                    KRRichTextShadow.Companion companion11 = KRRichTextShadow.INSTANCE;
                    d.Companion companion12 = d.INSTANCE;
                    b.Companion companion13 = f01.b.INSTANCE;
                    KRViewDecoration.Companion companion14 = KRViewDecoration.INSTANCE;
                    c cVar = c.f395305a;
                    KRHoverView.Companion companion15 = KRHoverView.INSTANCE;
                    KRBlurView.Companion companion16 = KRBlurView.INSTANCE;
                    n.Companion companion17 = com.tencent.kuikly.core.render.android.css.animation.n.INSTANCE;
                    KRLogModule.Companion companion18 = KRLogModule.INSTANCE;
                    try {
                        KRRecyclerView.Companion companion19 = KRRecyclerView.INSTANCE;
                    } catch (Throwable unused) {
                    }
                    KRWrapperImageView.Companion companion20 = KRWrapperImageView.INSTANCE;
                    a.Companion companion21 = com.tencent.kuikly.core.render.android.css.gesture.a.INSTANCE;
                    KRActivityIndicatorView.Companion companion22 = KRActivityIndicatorView.INSTANCE;
                    KRTextFieldView.Companion companion23 = KRTextFieldView.INSTANCE;
                    e01.b bVar = e01.b.f395304a;
                    KRCanvasView.Companion companion24 = KRCanvasView.INSTANCE;
                    e01.a aVar8 = e01.a.f395303a;
                    KRRecyclerContentView.Companion companion25 = KRRecyclerContentView.INSTANCE;
                    KRCSSAnimation.Companion companion26 = KRCSSAnimation.INSTANCE;
                    w wVar = w.f392617a;
                    KuiklyRenderNativeMethod kuiklyRenderNativeMethod = KuiklyRenderNativeMethod.KuiklyRenderNativeMethodUnknown;
                    j.Companion companion27 = j.INSTANCE;
                    q.Companion companion28 = q.INSTANCE;
                    KRFileManager kRFileManager = KRFileManager.f118087b;
                    KRAPNGView.a aVar9 = KRAPNGView.R;
                    KRPAGView.a aVar10 = KRPAGView.S;
                } catch (Throwable th5) {
                    w.f392617a.b("KuiklyRenderClassLoad", "exception:" + com.tencent.kuikly.core.render.android.css.ktx.b.u(th5));
                }
            }
        });
    }
}
