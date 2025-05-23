package com.tencent.filament.zplan.app.scene;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.app.view.FilamentTextureViewV2305;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.zplantracing.c;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 %2\u00020\u0001:\u0001&B\u001f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 \u00a2\u0006\u0004\b#\u0010$J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0012\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00188\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006'"}, d2 = {"Lcom/tencent/filament/zplan/app/scene/BaseSceneV2305;", "Lcom/tencent/filament/zplan/app/scene/BaseSceneV2308;", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "width", "height", "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "u", "surface", "t", "", "B", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "D", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;)V", "viewer", "Ljava/util/concurrent/atomic/AtomicBoolean;", "E", "Ljava/util/concurrent/atomic/AtomicBoolean;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/concurrent/atomic/AtomicBoolean;", "attached", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/ref/WeakReference;)V", UserInfo.SEX_FEMALE, "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public abstract class BaseSceneV2305 extends BaseSceneV2308 {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private FilamentViewerV2305 viewer;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean attached;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSceneV2305(@Nullable c cVar, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        super(cVar, app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.attached = new AtomicBoolean(false);
        k().e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.app.scene.BaseSceneV2305.1
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
                BaseSceneV2305.this.D(new FilamentViewerV2305(BaseSceneV2305.this.k().c()));
            }
        });
    }

    private final void y(final SurfaceTexture surfaceTexture, final int width, final int height) {
        k().d("BaseScene.attachSurface", new Function0<Unit>() { // from class: com.tencent.filament.zplan.app.scene.BaseSceneV2305$attachSurface$1
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
                FilamentViewerV2305 viewer = BaseSceneV2305.this.getViewer();
                if (viewer != null) {
                    viewer.attach(new Surface(surfaceTexture), surfaceTexture, width, height);
                }
                FilamentViewerV2305 viewer2 = BaseSceneV2305.this.getViewer();
                if (viewer2 != null) {
                    viewer2.setViewPort(width, height);
                }
                BaseSceneV2305.this.getAttached().set(true);
            }
        });
    }

    private final void z() {
        final FilamentViewerV2305 filamentViewerV2305 = this.viewer;
        if (filamentViewerV2305 != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            k().d("BaseScene.flushAndWait", new Function0<Unit>() { // from class: com.tencent.filament.zplan.app.scene.BaseSceneV2305$flushAndWait$1
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
                    FilamentViewerV2305.this.flushAndWait();
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(B(), TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: A, reason: from getter */
    public final AtomicBoolean getAttached() {
        return this.attached;
    }

    public long B() {
        return FilamentFeatureUtil.f106409g.D().getSurfaceDestroyTimeout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: C, reason: from getter */
    public final FilamentViewerV2305 getViewer() {
        return this.viewer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D(@Nullable FilamentViewerV2305 filamentViewerV2305) {
        this.viewer = filamentViewerV2305;
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void n() {
        final FilamentNativeAppV2305 filamentNativeAppV2305;
        super.n();
        FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
        long sceneDestroyDelayTimeMillis = filamentFeatureUtil.D().getSceneDestroyDelayTimeMillis();
        if (filamentFeatureUtil.n()) {
            filamentNativeAppV2305 = j().get();
        } else {
            filamentNativeAppV2305 = null;
        }
        k().g("BaseScene.onDestroy", sceneDestroyDelayTimeMillis, new Function0<Unit>() { // from class: com.tencent.filament.zplan.app.scene.BaseSceneV2305$onDestroy$1
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
                FilamentTextureViewV2305 a16;
                FilamentViewerV2305 viewer = BaseSceneV2305.this.getViewer();
                if (viewer != null) {
                    viewer.destroy();
                }
                BaseSceneV2305.this.D(null);
                FilamentNativeAppV2305 filamentNativeAppV23052 = filamentNativeAppV2305;
                if (filamentNativeAppV23052 == null) {
                    filamentNativeAppV23052 = BaseSceneV2305.this.j().get();
                }
                if (filamentNativeAppV23052 != null && (a16 = filamentNativeAppV23052.a()) != null) {
                    a16.a();
                }
                FLog fLog = FLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("viewerHandlerThread quitSafely, scene:");
                sb5.append(BaseSceneV2305.this);
                sb5.append(", app:");
                sb5.append(filamentNativeAppV23052);
                sb5.append(", ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb5.append(currentThread.getId());
                sb5.append(", ");
                Thread currentThread2 = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
                sb5.append(currentThread2.getName());
                fLog.i("BaseSceneV2305", sb5.toString());
                BaseSceneV2305.this.k().j();
            }
        });
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void s(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        super.s(surfaceTexture, width, height);
        y(surfaceTexture, width, height);
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void t(@NotNull SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        super.t(surface);
        this.attached.set(false);
        z();
    }

    @Override // com.tencent.filament.zplan.app.scene.BaseSceneV2308
    public void u(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        super.u(surfaceTexture, width, height);
        y(surfaceTexture, width, height);
    }
}
