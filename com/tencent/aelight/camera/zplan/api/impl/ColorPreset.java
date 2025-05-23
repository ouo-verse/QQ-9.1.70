package com.tencent.aelight.camera.zplan.api.impl;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/g;", "Lcom/tencent/aelight/camera/zplan/api/impl/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "colorInt", "<init>", "(I)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.aelight.camera.zplan.api.impl.g, reason: from toString */
/* loaded from: classes32.dex */
final /* data */ class ColorPreset extends f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int colorInt;

    /* renamed from: a, reason: from getter */
    public final int getColorInt() {
        return this.colorInt;
    }

    public int hashCode() {
        return this.colorInt;
    }

    public String toString() {
        return "ColorPreset(colorInt=" + this.colorInt + ")";
    }

    public ColorPreset(int i3) {
        super(null);
        this.colorInt = i3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ColorPreset) && this.colorInt == ((ColorPreset) other).colorInt;
    }
}
