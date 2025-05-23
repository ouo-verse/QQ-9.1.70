package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class Id3Frame implements Metadata.Entry {

    /* renamed from: id, reason: collision with root package name */
    public final String f32945id;

    public Id3Frame(String str) {
        this.f32945id = (String) Assertions.checkNotNull(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
