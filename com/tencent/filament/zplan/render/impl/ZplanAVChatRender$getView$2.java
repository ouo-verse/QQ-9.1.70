package com.tencent.filament.zplan.render.impl;

import android.view.Surface;
import com.tencent.filament.zplan.engine.ZplanAVChatViewer;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import uk0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/filament/zplan/render/impl/ZplanAVChatRender$getView$2", "Luk0/c;", "Landroid/view/Surface;", "surface", "", "width", "height", "", "b", "a", "onSurfaceDestroyed", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZplanAVChatRender$getView$2 implements uk0.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ZplanAVChatRender f105909a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZplanAVChatRender$getView$2(ZplanAVChatRender zplanAVChatRender) {
        this.f105909a = zplanAVChatRender;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // uk0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NotNull Surface surface, int width, int height) {
        int i3;
        boolean z16;
        uk0.c cVar;
        boolean z17;
        int i16;
        Intrinsics.checkNotNullParameter(surface, "surface");
        c.a.a(this, surface, width, height);
        i3 = this.f105909a.surfaceWidth;
        if (i3 == width) {
            i16 = this.f105909a.surfaceHeight;
            if (i16 == height) {
                z16 = false;
                if (z16) {
                    FLog.INSTANCE.d("FilamentAVChatRender", "onSurfaceChanged size change.");
                    ZplanAVChatRender zplanAVChatRender = this.f105909a;
                    z17 = zplanAVChatRender.isDoubleHorizontal;
                    zplanAVChatRender.i(z17);
                }
                this.f105909a.surfaceWidth = width;
                this.f105909a.surfaceHeight = height;
                cVar = this.f105909a.filamentRenderListener;
                if (cVar != null) {
                    cVar.a(surface, width, height);
                }
                FLog.INSTANCE.d("FilamentAVChatRender", "onSurfaceChanged");
            }
        }
        z16 = true;
        if (z16) {
        }
        this.f105909a.surfaceWidth = width;
        this.f105909a.surfaceHeight = height;
        cVar = this.f105909a.filamentRenderListener;
        if (cVar != null) {
        }
        FLog.INSTANCE.d("FilamentAVChatRender", "onSurfaceChanged");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003c  */
    @Override // uk0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(@NotNull final Surface surface, int width, int height) {
        int i3;
        boolean z16;
        uk0.c cVar;
        int i16;
        int i17;
        boolean z17;
        int i18;
        Intrinsics.checkNotNullParameter(surface, "surface");
        c.a.b(this, surface, width, height);
        i3 = this.f105909a.surfaceWidth;
        if (i3 == width) {
            i18 = this.f105909a.surfaceHeight;
            if (i18 == height) {
                z16 = false;
                this.f105909a.surfaceWidth = width;
                this.f105909a.surfaceHeight = height;
                this.f105909a.B0("onSurfaceCreate", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$getView$2$onSurfaceCreate$1
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
                        ZplanAVChatViewer zplanAVChatViewer;
                        zplanAVChatViewer = ZplanAVChatRender$getView$2.this.f105909a.filamentViewer;
                        if (zplanAVChatViewer != null) {
                            zplanAVChatViewer.createSwapChain(surface);
                        }
                        ZplanAVChatRender$getView$2.this.f105909a.renderSurface = surface;
                    }
                });
                cVar = this.f105909a.filamentRenderListener;
                if (cVar != null) {
                    cVar.b(surface, width, height);
                }
                if (z16) {
                    FLog.INSTANCE.d("FilamentAVChatRender", "onSurfaceCreate size change.");
                    ZplanAVChatRender zplanAVChatRender = this.f105909a;
                    z17 = zplanAVChatRender.isDoubleHorizontal;
                    zplanAVChatRender.i(z17);
                }
                FLog fLog = FLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onSurfaceCreate ");
                i16 = this.f105909a.surfaceWidth;
                sb5.append(i16);
                sb5.append(TokenParser.SP);
                i17 = this.f105909a.surfaceHeight;
                sb5.append(i17);
                fLog.d("FilamentAVChatRender", sb5.toString());
            }
        }
        z16 = true;
        this.f105909a.surfaceWidth = width;
        this.f105909a.surfaceHeight = height;
        this.f105909a.B0("onSurfaceCreate", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.ZplanAVChatRender$getView$2$onSurfaceCreate$1
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
                ZplanAVChatViewer zplanAVChatViewer;
                zplanAVChatViewer = ZplanAVChatRender$getView$2.this.f105909a.filamentViewer;
                if (zplanAVChatViewer != null) {
                    zplanAVChatViewer.createSwapChain(surface);
                }
                ZplanAVChatRender$getView$2.this.f105909a.renderSurface = surface;
            }
        });
        cVar = this.f105909a.filamentRenderListener;
        if (cVar != null) {
        }
        if (z16) {
        }
        FLog fLog2 = FLog.INSTANCE;
        StringBuilder sb52 = new StringBuilder();
        sb52.append("onSurfaceCreate ");
        i16 = this.f105909a.surfaceWidth;
        sb52.append(i16);
        sb52.append(TokenParser.SP);
        i17 = this.f105909a.surfaceHeight;
        sb52.append(i17);
        fLog2.d("FilamentAVChatRender", sb52.toString());
    }

    @Override // uk0.c
    public void onSurfaceDestroyed(@NotNull Surface surface) {
        uk0.c cVar;
        Intrinsics.checkNotNullParameter(surface, "surface");
        c.a.c(this, surface);
        cVar = this.f105909a.filamentRenderListener;
        if (cVar != null) {
            cVar.onSurfaceDestroyed(surface);
        }
        FLog.INSTANCE.d("FilamentAVChatRender", "onSurfaceDestroyed");
    }
}
