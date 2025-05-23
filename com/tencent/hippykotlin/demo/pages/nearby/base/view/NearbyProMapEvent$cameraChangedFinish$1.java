package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NearbyProMapEvent$cameraChangedFinish$1 extends Lambda implements Function1<Object, Unit> {
    public final /* synthetic */ Function1<CameraPosition, Unit> $callbackFn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearbyProMapEvent$cameraChangedFinish$1(Function1<? super CameraPosition, Unit> function1) {
        super(1);
        this.$callbackFn = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Object obj) {
        Function1<CameraPosition, Unit> function1 = this.$callbackFn;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
        e eVar = (e) obj;
        NBPLatLng.Companion companion = NBPLatLng.Companion;
        e m3 = eVar.m("target");
        if (m3 == null) {
            m3 = new e();
        }
        NBPLatLng from = companion.from(m3);
        float i3 = (float) eVar.i("zoomLevel", 0.0d);
        e m16 = eVar.m("topLeftPosition");
        if (m16 == null) {
            m16 = new e();
        }
        NBPLatLng from2 = companion.from(m16);
        e m17 = eVar.m("topRightPosition");
        if (m17 == null) {
            m17 = new e();
        }
        NBPLatLng from3 = companion.from(m17);
        e m18 = eVar.m("bottomLeftPosition");
        if (m18 == null) {
            m18 = new e();
        }
        NBPLatLng from4 = companion.from(m18);
        e m19 = eVar.m("bottomRightPosition");
        if (m19 == null) {
            m19 = new e();
        }
        function1.invoke(new CameraPosition(from, i3, from2, from3, from4, companion.from(m19)));
        return Unit.INSTANCE;
    }
}
