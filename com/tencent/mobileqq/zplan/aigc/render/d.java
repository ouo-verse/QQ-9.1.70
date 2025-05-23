package com.tencent.mobileqq.zplan.aigc.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.filament.zplan.data.RenderSize;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.aigc.data.AIGCModelRenderTask;
import com.tencent.mobileqq.zplan.aigc.data.FilamentInitParams;
import com.tencent.mobileqq.zplan.aigc.data.TASK_STATUS;
import com.tencent.mobileqq.zplan.aigc.render.d;
import com.tencent.mobileqq.zplan.aigc.render.g;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import com.tencent.mobileqq.zplan.lite.util.ZPlanFilamentLoadSoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0003\u001d!%B-\b\u0016\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00106\u001a\u000204\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b8\u00109J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\"\u0010*\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00101R\u0018\u00103\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010&\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/d;", "", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "renderTask", "Lcom/tencent/mobileqq/zplan/aigc/render/d$c;", "callback", "", "o", "l", tl.h.F, "Lcom/tencent/mobileqq/zplan/aigc/render/d$d;", "i", "task", "", "g", "Ljava/lang/Runnable;", "runnable", "f", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager;", "a", "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager;", "k", "()Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager;", "setZplanFilamentAIGCEditorManager", "(Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentAIGCEditorManager;)V", "zplanFilamentAIGCEditorManager", "Landroid/content/Context;", "b", "Landroid/content/Context;", "context", "Lcom/tencent/filament/zplan/data/RenderSize;", "c", "Lcom/tencent/filament/zplan/data/RenderSize;", "offScreenRenderSize", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "d", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "aigcEditorListener", "e", "Z", "isRunning", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "thumbnailGenerateQueue", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "currentTask", "renderTaskPreviewResourceListener", "", "thumbnailWidth", "thumbnailHeight", "listener", "<init>", "(IILandroid/content/Context;Lcom/tencent/mobileqq/zplan/aigc/render/g;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private RenderSize offScreenRenderSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.aigc.render.g aigcEditorListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isRunning;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentLinkedQueue<Runnable> thumbnailGenerateQueue;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private AIGCModelRenderTask currentTask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.aigc.render.g renderTaskPreviewResourceListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/d$a", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "", "result", "", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements com.tencent.mobileqq.zplan.aigc.render.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.aigc.render.g f330487a;

        a(com.tencent.mobileqq.zplan.aigc.render.g gVar) {
            this.f330487a = gVar;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void a(String str) {
            g.a.b(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void b(int i3) {
            g.a.e(this, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void c(boolean z16) {
            g.a.f(this, z16);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void d(String str) {
            g.a.c(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
            g.a.g(this, z16, aIGCWhiteModel);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void f(int result) {
            com.tencent.mobileqq.zplan.aigc.render.g gVar = this.f330487a;
            if (gVar != null) {
                gVar.f(result);
            }
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void onScreenShotResult(Bitmap bitmap) {
            g.a.d(this, bitmap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/d$c;", "", "", "taskDd", "Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface c {
        void a(int taskDd, TASK_STATUS result);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/d$e", "Lgl0/b;", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements gl0.b {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(d this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.l();
        }

        @Override // gl0.b
        public void a(boolean isSuccess, boolean downloadSo, int errCode, String errMsg) {
            QLog.e("AIGCClothThumbnailRenderer", 1, "onComplete after checkSoAndInitFilament");
            if (isSuccess) {
                QLog.i("AIGCClothThumbnailRenderer", 1, "onComplete after start checkSoAndInitFilament " + isSuccess + ", " + downloadSo);
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final d dVar = d.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.render.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.e.c(d.this);
                    }
                });
                return;
            }
            QLog.e("AIGCClothThumbnailRenderer", 1, "onComplete error, " + downloadSo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/d$f", "Lcom/tencent/mobileqq/zplan/aigc/render/d$c;", "", "taskDd", "Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIGCModelRenderTask f330490b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC9136d f330491c;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/d$f$a", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onScreenShotResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements com.tencent.mobileqq.zplan.aigc.render.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AIGCModelRenderTask f330492a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC9136d f330493b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f330494c;

            a(AIGCModelRenderTask aIGCModelRenderTask, InterfaceC9136d interfaceC9136d, d dVar) {
                this.f330492a = aIGCModelRenderTask;
                this.f330493b = interfaceC9136d;
                this.f330494c = dVar;
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void a(String str) {
                g.a.b(this, str);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void b(int i3) {
                g.a.e(this, i3);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void c(boolean z16) {
                g.a.f(this, z16);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void d(String str) {
                g.a.c(this, str);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
                g.a.g(this, z16, aIGCWhiteModel);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void f(int i3) {
                g.a.a(this, i3);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void onScreenShotResult(Bitmap bitmap) {
                QLog.i("AIGCClothThumbnailRenderer", 1, "aigctest onScreenShotResult " + this.f330492a.getId());
                InterfaceC9136d interfaceC9136d = this.f330493b;
                if (interfaceC9136d != null) {
                    InterfaceC9136d.a.a(interfaceC9136d, bitmap, this.f330492a.getId(), null, 4, null);
                }
                this.f330494c.n(false);
                this.f330494c.p();
            }
        }

        f(AIGCModelRenderTask aIGCModelRenderTask, InterfaceC9136d interfaceC9136d) {
            this.f330490b = aIGCModelRenderTask;
            this.f330491c = interfaceC9136d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(AIGCModelRenderTask renderTask, TASK_STATUS result, InterfaceC9136d interfaceC9136d) {
            Intrinsics.checkNotNullParameter(renderTask, "$renderTask");
            Intrinsics.checkNotNullParameter(result, "$result");
            QLog.e("AIGCClothThumbnailRenderer", 1, "aigctest onTaskComplete " + renderTask.getId() + ", " + result);
            if (interfaceC9136d != null) {
                interfaceC9136d.a(null, renderTask.getId(), result);
            }
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.d.c
        public void a(int taskDd, final TASK_STATUS result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result != TASK_STATUS.TASK_STATUS_SCREEN_SHOT_SUCCESS) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final AIGCModelRenderTask aIGCModelRenderTask = this.f330490b;
                final InterfaceC9136d interfaceC9136d = this.f330491c;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.render.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.f.c(AIGCModelRenderTask.this, result, interfaceC9136d);
                    }
                });
                return;
            }
            ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager = d.this.getZplanFilamentAIGCEditorManager();
            if (zplanFilamentAIGCEditorManager != null) {
                zplanFilamentAIGCEditorManager.L(new a(this.f330490b, this.f330491c, d.this));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/d$g", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "", "result", "", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements com.tencent.mobileqq.zplan.aigc.render.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AIGCModelRenderTask f330495a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f330496b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f330497c;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/d$g$a", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "", "result", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements com.tencent.mobileqq.zplan.aigc.render.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f330498a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AIGCModelRenderTask f330499b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f330500c;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/d$g$a$a", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "", "resourcePath", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.mobileqq.zplan.aigc.render.d$g$a$a, reason: collision with other inner class name */
            /* loaded from: classes35.dex */
            public static final class C9137a implements com.tencent.mobileqq.zplan.aigc.render.g {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ AIGCModelRenderTask f330501a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ c f330502b;

                C9137a(AIGCModelRenderTask aIGCModelRenderTask, c cVar) {
                    this.f330501a = aIGCModelRenderTask;
                    this.f330502b = cVar;
                }

                @Override // com.tencent.mobileqq.zplan.aigc.render.g
                public void a(String resourcePath) {
                    Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
                    this.f330501a.m(resourcePath);
                    c cVar = this.f330502b;
                    if (cVar != null) {
                        cVar.a(this.f330501a.getId(), TASK_STATUS.TASK_STATUS_SCREEN_SHOT_SUCCESS);
                    }
                }

                @Override // com.tencent.mobileqq.zplan.aigc.render.g
                public void b(int i3) {
                    g.a.e(this, i3);
                }

                @Override // com.tencent.mobileqq.zplan.aigc.render.g
                public void c(boolean z16) {
                    g.a.f(this, z16);
                }

                @Override // com.tencent.mobileqq.zplan.aigc.render.g
                public void d(String str) {
                    g.a.c(this, str);
                }

                @Override // com.tencent.mobileqq.zplan.aigc.render.g
                public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
                    g.a.g(this, z16, aIGCWhiteModel);
                }

                @Override // com.tencent.mobileqq.zplan.aigc.render.g
                public void f(int i3) {
                    g.a.a(this, i3);
                }

                @Override // com.tencent.mobileqq.zplan.aigc.render.g
                public void onScreenShotResult(Bitmap bitmap) {
                    g.a.d(this, bitmap);
                }
            }

            a(d dVar, AIGCModelRenderTask aIGCModelRenderTask, c cVar) {
                this.f330498a = dVar;
                this.f330499b = aIGCModelRenderTask;
                this.f330500c = cVar;
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void a(String str) {
                g.a.b(this, str);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void b(int result) {
                this.f330498a.currentTask = this.f330499b;
                if (result != 0) {
                    c cVar = this.f330500c;
                    if (cVar != null) {
                        cVar.a(this.f330499b.getId(), TASK_STATUS.TASK_STATUS_ERROR_ENGINE);
                        return;
                    }
                    return;
                }
                this.f330498a.renderTaskPreviewResourceListener = new C9137a(this.f330499b, this.f330500c);
                ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager = this.f330498a.getZplanFilamentAIGCEditorManager();
                if (zplanFilamentAIGCEditorManager != null) {
                    zplanFilamentAIGCEditorManager.M(String.valueOf(this.f330499b.getId()), new WeakReference<>(this.f330498a.renderTaskPreviewResourceListener));
                }
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void c(boolean z16) {
                g.a.f(this, z16);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void d(String str) {
                g.a.c(this, str);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
                g.a.g(this, z16, aIGCWhiteModel);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void f(int i3) {
                g.a.a(this, i3);
            }

            @Override // com.tencent.mobileqq.zplan.aigc.render.g
            public void onScreenShotResult(Bitmap bitmap) {
                g.a.d(this, bitmap);
            }
        }

        g(AIGCModelRenderTask aIGCModelRenderTask, d dVar, c cVar) {
            this.f330495a = aIGCModelRenderTask;
            this.f330496b = dVar;
            this.f330497c = cVar;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void a(String str) {
            g.a.b(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void b(int i3) {
            g.a.e(this, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void c(boolean result) {
            List<ModelStyle> modelStyles;
            if (result) {
                ModelExtraInfo modelExtraInfo = this.f330495a.getModel().getModelExtraInfo();
                int size = (modelExtraInfo == null || (modelStyles = modelExtraInfo.getModelStyles()) == null) ? 1 : modelStyles.size();
                this.f330495a.l(AIGCHelper.f330685a.v(this.f330495a.getGridIndex(), size));
                QLog.i("AIGCClothThumbnailRenderer", 1, "aigctest onSetWhiteModelFirstFrame " + this.f330495a.getPatternPosType() + ", " + size);
                ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager = this.f330496b.getZplanFilamentAIGCEditorManager();
                if (zplanFilamentAIGCEditorManager != null) {
                    zplanFilamentAIGCEditorManager.V(this.f330495a.getPatternPosType(), this.f330495a.getColor(), 1024, 1024, this.f330495a.getPatternImage().getBitmap(), this.f330495a.getModel(), true, new a(this.f330496b, this.f330495a, this.f330497c));
                    return;
                }
                return;
            }
            QLog.e("AIGCClothThumbnailRenderer", 1, "startAIGCRenderTask TASK_STATUS_ERROR_ENGINE");
            c cVar = this.f330497c;
            if (cVar != null) {
                cVar.a(this.f330495a.getId(), TASK_STATUS.TASK_STATUS_ERROR_ENGINE);
            }
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void d(String str) {
            g.a.c(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
            g.a.g(this, z16, aIGCWhiteModel);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void f(int i3) {
            g.a.a(this, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void onScreenShotResult(Bitmap bitmap) {
            g.a.d(this, bitmap);
        }
    }

    public d(int i3, int i16, Context context, com.tencent.mobileqq.zplan.aigc.render.g gVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.thumbnailGenerateQueue = new ConcurrentLinkedQueue<>();
        this.context = context;
        this.offScreenRenderSize = new RenderSize(i3, i16);
        this.aigcEditorListener = new a(gVar);
        h();
    }

    private final void h() {
        ZPlanFilamentLoadSoUtil.INSTANCE.downloadAndLoadSo(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(d this$0, AIGCModelRenderTask renderTask, InterfaceC9136d interfaceC9136d) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderTask, "$renderTask");
        this$0.o(renderTask, new f(renderTask, interfaceC9136d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        RenderSize renderSize = this.offScreenRenderSize;
        Intrinsics.checkNotNull(renderSize);
        FilamentInitParams filamentInitParams = new FilamentInitParams(false, null, renderSize, "000001");
        Context context = this.context;
        Intrinsics.checkNotNull(context);
        this.zplanFilamentAIGCEditorManager = new ZplanFilamentAIGCEditorManager(context, filamentInitParams, this.aigcEditorListener);
    }

    private final void o(AIGCModelRenderTask renderTask, c callback) {
        ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager = this.zplanFilamentAIGCEditorManager;
        if (zplanFilamentAIGCEditorManager != null) {
            zplanFilamentAIGCEditorManager.W(renderTask.getUgcID());
        }
        ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager2 = this.zplanFilamentAIGCEditorManager;
        if (zplanFilamentAIGCEditorManager2 != null) {
            zplanFilamentAIGCEditorManager2.X(renderTask.getModel(), new g(renderTask, this, callback));
        }
    }

    public final void f(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.thumbnailGenerateQueue.add(runnable);
        p();
    }

    public final boolean g(AIGCModelRenderTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        return task.getPatternImage().getBitmap() != null;
    }

    public final void i(final AIGCModelRenderTask renderTask, final InterfaceC9136d callback) {
        Intrinsics.checkNotNullParameter(renderTask, "renderTask");
        if (g(renderTask)) {
            f(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.render.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.j(d.this, renderTask, callback);
                }
            });
        } else if (callback != null) {
            callback.a(null, renderTask.getId(), TASK_STATUS.TASK_STATUS_ERROR_IMG_NETWORK);
        }
    }

    /* renamed from: k, reason: from getter */
    public final ZplanFilamentAIGCEditorManager getZplanFilamentAIGCEditorManager() {
        return this.zplanFilamentAIGCEditorManager;
    }

    public final void m() {
        this.thumbnailGenerateQueue.clear();
        ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager = this.zplanFilamentAIGCEditorManager;
        if (zplanFilamentAIGCEditorManager != null) {
            zplanFilamentAIGCEditorManager.R();
        }
        this.zplanFilamentAIGCEditorManager = null;
        this.context = null;
        this.aigcEditorListener = null;
    }

    public final void n(boolean z16) {
        this.isRunning = z16;
    }

    public final void p() {
        if (!this.isRunning && this.thumbnailGenerateQueue.size() > 0) {
            this.isRunning = true;
            Runnable poll = this.thumbnailGenerateQueue.poll();
            if (poll != null) {
                poll.run();
                return;
            } else {
                p();
                return;
            }
        }
        if (this.thumbnailGenerateQueue.size() == 0) {
            this.isRunning = false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/d$d;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "id", "Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.render.d$d, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public interface InterfaceC9136d {
        void a(Bitmap bitmap, int id5, TASK_STATUS result);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.zplan.aigc.render.d$d$a */
        /* loaded from: classes35.dex */
        public static final class a {
            public static /* synthetic */ void a(InterfaceC9136d interfaceC9136d, Bitmap bitmap, int i3, TASK_STATUS task_status, int i16, Object obj) {
                if (obj == null) {
                    if ((i16 & 4) != 0) {
                        task_status = TASK_STATUS.TASK_STATUS_SCREEN_SHOT_SUCCESS;
                    }
                    interfaceC9136d.a(bitmap, i3, task_status);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onScreenShot");
            }
        }
    }
}
