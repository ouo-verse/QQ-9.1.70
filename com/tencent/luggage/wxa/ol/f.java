package com.tencent.luggage.wxa.ol;

import android.text.Editable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends j0 {

    /* renamed from: e, reason: collision with root package name */
    public final String f136717e;

    /* renamed from: f, reason: collision with root package name */
    public final p0 f136718f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, p0 inputComponent) {
        super(Integer.valueOf(inputComponent.getInputId()));
        Intrinsics.checkNotNullParameter(inputComponent, "inputComponent");
        this.f136717e = str;
        this.f136718f = inputComponent;
    }

    @Override // com.tencent.luggage.wxa.ol.s0
    public String a() {
        Editable currentValue = this.f136718f.currentValue();
        if (currentValue != null) {
            return currentValue.toString();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.ol.s0
    public String getInputType() {
        return this.f136717e;
    }
}
