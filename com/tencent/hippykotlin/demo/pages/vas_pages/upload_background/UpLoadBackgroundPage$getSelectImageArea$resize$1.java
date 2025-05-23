package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes33.dex */
public final class UpLoadBackgroundPage$getSelectImageArea$resize$1 extends Lambda implements Function1<Float, Float> {
    public static final UpLoadBackgroundPage$getSelectImageArea$resize$1 INSTANCE = new UpLoadBackgroundPage$getSelectImageArea$resize$1();

    @Override // kotlin.jvm.functions.Function1
    public final Float invoke(Float f16) {
        return Float.valueOf(Math.min(Math.max(0.0f, f16.floatValue()), 1.0f));
    }

    public UpLoadBackgroundPage$getSelectImageArea$resize$1() {
        super(1);
    }
}
