package org.light;

import android.os.Parcel;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoClip extends ClipAsset {
    public boolean autoLoop;
    public HashMap<String, long[]> events;
    public float speed;
    public long startOffset;
    public float volume;
    public VolumeEffect[] volumeEffects;

    public VideoClip() {
        this.speed = 1.0f;
        this.volume = 1.0f;
        this.events = new HashMap<>();
        this.autoLoop = false;
        this.type = ClipAsset.VIDEO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VideoClip(Parcel parcel) {
        super(parcel);
        this.speed = 1.0f;
        this.volume = 1.0f;
        this.events = new HashMap<>();
        this.autoLoop = false;
        this.startOffset = parcel.readLong();
        this.speed = parcel.readFloat();
        this.volume = parcel.readFloat();
        this.events = (HashMap) parcel.readSerializable();
        this.autoLoop = parcel.readByte() != 0;
    }
}
