package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n01.b;

/* loaded from: classes31.dex */
public final class QRCodeViewPropUpdater implements f {
    public static final QRCodeViewPropUpdater INSTANCE = new QRCodeViewPropUpdater();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.core.f
    public final void setPropToView(ComposeRenderView composeRenderView, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        DeclarativeBaseView<?, ?> b16 = composeRenderView.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView");
        b bVar = (b) ((QRCodeView) b16).getViewAttr();
        if (Intrinsics.areEqual(str, "qrCodeUrl")) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            bVar.i((String) obj, ((Float) obj2).floatValue());
        } else if (Intrinsics.areEqual(str, "qrCodeSize")) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color");
            ReadWriteProperty readWriteProperty = bVar.f417919c;
            KProperty<?>[] kPropertyArr = b.f417916e;
            readWriteProperty.setValue(bVar, kPropertyArr[2], (h) obj);
            bVar.f417920d.setValue(bVar, kPropertyArr[3], (h) obj2);
        }
    }

    @Override // com.tencent.ntcompose.core.f
    public final void resetPropToView(ComposeRenderView composeRenderView, String str) {
    }
}
