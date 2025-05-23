package com.tencent.ams.mosaic.jsengine.component.image.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface a extends Animatable {

    /* compiled from: P */
    /* renamed from: com.tencent.ams.mosaic.jsengine.component.image.drawable.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0691a {
    }

    Drawable getDrawable();

    boolean isAnimatable();

    void s(InterfaceC0691a interfaceC0691a);

    void setAutoPlay(boolean z16);

    void setRepeatCount(int i3);
}
