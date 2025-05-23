package com.tencent.filament.zplan.scene.record;

import com.tencent.filament.zplan.app.impl.FilamentThreadHandler;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.engine.RenderCallback;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001\u000eB9\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J(\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016R\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/filament/zplan/scene/record/FrameRecorder;", "Lcom/tencent/filament/zplan/engine/RenderCallback;", "", "j", "", "checkFrameIndex", "i", "k", "", "pixelsAddress", "pixelsSize", "width", "height", "onFrameRendered", "a", "I", "currentFrameIndex", "b", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "c", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "Lcom/tencent/filament/zplan/app/impl/FilamentThreadHandler;", "d", "Lcom/tencent/filament/zplan/app/impl/FilamentThreadHandler;", "filamentThreadHandler", "e", "totalFrameCount", "", "f", "D", "frameDuration", "Lcom/tencent/filament/zplan/scene/record/a;", "g", "Lcom/tencent/filament/zplan/scene/record/a;", "listener", "<init>", "(ILcom/tencent/filament/zplan/engine/FilamentViewerV2305;Lcom/tencent/filament/zplan/app/impl/FilamentThreadHandler;IDLcom/tencent/filament/zplan/scene/record/a;)V", h.F, "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FrameRecorder implements RenderCallback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int currentFrameIndex;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int taskId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final FilamentViewerV2305 viewer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final FilamentThreadHandler filamentThreadHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int totalFrameCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final double frameDuration;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final a listener;

    public FrameRecorder(int i3, @Nullable FilamentViewerV2305 filamentViewerV2305, @NotNull FilamentThreadHandler filamentThreadHandler, int i16, double d16, @NotNull a listener) {
        Intrinsics.checkNotNullParameter(filamentThreadHandler, "filamentThreadHandler");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.taskId = i3;
        this.viewer = filamentViewerV2305;
        this.filamentThreadHandler = filamentThreadHandler;
        this.totalFrameCount = i16;
        this.frameDuration = d16;
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(final int checkFrameIndex) {
        this.filamentThreadHandler.f(100L, new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.record.FrameRecorder$checkFrameRenderTimeout$1
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
                int i3;
                int i16;
                int i17;
                i3 = FrameRecorder.this.currentFrameIndex;
                i16 = FrameRecorder.this.totalFrameCount;
                if (i3 >= i16) {
                    return;
                }
                int i18 = checkFrameIndex;
                i17 = FrameRecorder.this.currentFrameIndex;
                if (i18 == i17) {
                    FLog.INSTANCE.d("[zplan][MemePlayer-SDK][FrameRecorder]", "checkFrame: retry " + checkFrameIndex);
                    FrameRecorder.this.j();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        this.filamentThreadHandler.d("[zplan][MemePlayer-SDK][FrameRecorder].recordCurrentFrame", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.record.FrameRecorder$recordCurrentFrame$1
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
                int i3;
                int i16;
                int i17;
                double d16;
                a aVar;
                int i18;
                FilamentViewerV2305 filamentViewerV2305;
                FilamentViewerV2305 filamentViewerV23052;
                int i19;
                i3 = FrameRecorder.this.currentFrameIndex;
                i16 = FrameRecorder.this.totalFrameCount;
                if (i3 >= i16) {
                    return;
                }
                i17 = FrameRecorder.this.currentFrameIndex;
                d16 = FrameRecorder.this.frameDuration;
                double d17 = i17 * d16;
                aVar = FrameRecorder.this.listener;
                i18 = FrameRecorder.this.taskId;
                aVar.a(i18, d17);
                filamentViewerV2305 = FrameRecorder.this.viewer;
                if (filamentViewerV2305 != null) {
                    filamentViewerV2305.flushAndWait();
                }
                filamentViewerV23052 = FrameRecorder.this.viewer;
                if (!Intrinsics.areEqual(filamentViewerV23052 != null ? Boolean.valueOf(filamentViewerV23052.render((c) null, FrameRecorder.this)) : null, Boolean.TRUE)) {
                    FrameRecorder.this.j();
                    return;
                }
                FrameRecorder frameRecorder = FrameRecorder.this;
                i19 = frameRecorder.currentFrameIndex;
                frameRecorder.i(i19);
            }
        });
    }

    public final void k() {
        j();
    }

    @Override // com.tencent.filament.zplan.engine.RenderCallback
    public void onFrameRendered(long pixelsAddress, long pixelsSize, int width, int height) {
        FLog fLog = FLog.INSTANCE;
        fLog.d("[zplan][MemePlayer-SDK][FrameRecorder]", "onFrameRendered: " + this.currentFrameIndex + '/' + this.totalFrameCount);
        this.listener.b(this.taskId, pixelsAddress, pixelsSize, width, height);
        int i3 = this.currentFrameIndex + 1;
        this.currentFrameIndex = i3;
        int i16 = this.totalFrameCount;
        if (i3 == i16) {
            fLog.d("[zplan][MemePlayer-SDK][FrameRecorder]", "recordOneFrame: end");
            this.listener.c(this.taskId);
        } else {
            if (i3 > i16) {
                return;
            }
            j();
        }
    }
}
