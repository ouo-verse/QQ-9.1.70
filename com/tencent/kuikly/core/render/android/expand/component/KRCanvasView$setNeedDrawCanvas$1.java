package com.tencent.kuikly.core.render.android.expand.component;

import android.graphics.Bitmap;
import com.tencent.kuikly.core.render.android.scheduler.KRSubThreadScheduler;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRCanvasView$setNeedDrawCanvas$1 implements Runnable {
    final /* synthetic */ KRCanvasView this$0;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.KRCanvasView$setNeedDrawCanvas$1$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ int $drawFlag;
        final /* synthetic */ int $h;
        final /* synthetic */ int $w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i3, int i16, int i17) {
            super(0);
            this.$drawFlag = i3;
            this.$w = i16;
            this.$h = i17;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            int i3;
            RenderingController renderingController;
            int i16 = this.$drawFlag;
            i3 = KRCanvasView$setNeedDrawCanvas$1.this.this$0.drawCancelFlag;
            if (i16 != i3) {
                return;
            }
            renderingController = KRCanvasView$setNeedDrawCanvas$1.this.this$0.renderingController;
            final Bitmap z16 = renderingController.z(this.$w, this.$h);
            if (z16 != null) {
                KRCanvasView$setNeedDrawCanvas$1.this.this$0.post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRCanvasView$setNeedDrawCanvas$1$1$$special$$inlined$also$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        KRCanvasView$setNeedDrawCanvas$1.this.this$0.setImageBitmap(z16);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KRCanvasView$setNeedDrawCanvas$1(KRCanvasView kRCanvasView) {
        this.this$0 = kRCanvasView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3;
        int i16;
        RenderingController renderingController;
        int i17;
        RenderingController renderingController2;
        this.this$0.needDrawCanvas = false;
        KRCanvasView kRCanvasView = this.this$0;
        i3 = kRCanvasView.drawCancelFlag;
        kRCanvasView.drawCancelFlag = i3 + 1;
        i16 = kRCanvasView.drawCancelFlag;
        int h16 = com.tencent.kuikly.core.render.android.css.ktx.b.h(this.this$0);
        int g16 = com.tencent.kuikly.core.render.android.css.ktx.b.g(this.this$0);
        renderingController = this.this$0.renderingController;
        if (!renderingController.getIsDiffPatchDrawMode()) {
            i17 = this.this$0.drawCancelFlag;
            if (i16 == i17) {
                renderingController2 = this.this$0.renderingController;
                Bitmap z16 = renderingController2.z(h16, g16);
                if (z16 != null) {
                    this.this$0.setImageBitmap(z16);
                    return;
                }
                return;
            }
            return;
        }
        KRSubThreadScheduler.f118174c.e(new AnonymousClass1(i16, h16, g16));
    }
}
