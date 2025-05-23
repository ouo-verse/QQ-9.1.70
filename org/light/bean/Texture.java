package org.light.bean;

import android.os.Parcel;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Texture {
    public int height;

    /* renamed from: id, reason: collision with root package name */
    public int f423804id;
    public int width;

    public Texture() {
    }

    protected Texture(Parcel parcel) {
        this.f423804id = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
