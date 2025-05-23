package com.tencent.kuikly.core.render.android.expand.component;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.kuikly.core.render.android.expand.module.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRCanvasView$drawImage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $base64ImageKey;
    final /* synthetic */ float $h;
    final /* synthetic */ Object $imageObj;
    final /* synthetic */ j $module;
    final /* synthetic */ float $w;
    final /* synthetic */ float $x;
    final /* synthetic */ float $y;
    final /* synthetic */ KRCanvasView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRCanvasView$drawImage$1(KRCanvasView kRCanvasView, Object obj, j jVar, String str, float f16, float f17, float f18, float f19) {
        super(0);
        this.this$0 = kRCanvasView;
        this.$imageObj = obj;
        this.$module = jVar;
        this.$base64ImageKey = str;
        this.$x = f16;
        this.$y = f17;
        this.$w = f18;
        this.$h = f19;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Bitmap bitmap;
        RenderingController renderingController;
        Object obj = this.$imageObj;
        boolean z16 = obj instanceof String;
        Object obj2 = obj;
        if (z16) {
            final Bitmap a16 = l01.b.a((String) obj);
            obj2 = a16;
            if (a16 != null) {
                this.this$0.post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRCanvasView$drawImage$1$$special$$inlined$also$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        KRCanvasView$drawImage$1 kRCanvasView$drawImage$1 = this;
                        j jVar = kRCanvasView$drawImage$1.$module;
                        String base64ImageKey = kRCanvasView$drawImage$1.$base64ImageKey;
                        Intrinsics.checkNotNullExpressionValue(base64ImageKey, "base64ImageKey");
                        jVar.l(base64ImageKey, a16);
                    }
                });
                obj2 = a16;
            }
        }
        float f16 = this.$x;
        float f17 = this.$y;
        RectF rectF = new RectF(f16, f17, this.$w + f16, this.$h + f17);
        if (obj2 instanceof Bitmap) {
            bitmap = (Bitmap) obj2;
        } else {
            bitmap = obj2 instanceof BitmapDrawable ? ((BitmapDrawable) obj2).getBitmap() : null;
        }
        renderingController = this.this$0.renderingController;
        renderingController.x(rectF, bitmap);
    }
}
