package com.tencent.mapsdk.engine.jni;

import android.support.annotation.Keep;
import java.util.Arrays;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class JNIEvent {
    public byte[] data;
    public Object extra;

    /* renamed from: id, reason: collision with root package name */
    public int f147664id;
    public String name;

    public String toString() {
        return "JNIEvent{id=" + this.f147664id + ", name='" + this.name + "', data=" + Arrays.toString(this.data) + ", extra=" + this.extra + '}';
    }
}
