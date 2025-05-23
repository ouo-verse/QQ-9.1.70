package org.light.avatar;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AvatarAIInfo {
    public byte[] body;
    public Map<String, String> events;

    /* renamed from: face, reason: collision with root package name */
    public byte[] f423803face;
    public int frameID;
    public float[] skyBoxTransform;
    public boolean valid;
    public int version;

    public AvatarAIInfo(boolean z16, int i3, int i16, float[] fArr, byte[] bArr, byte[] bArr2, Map<String, String> map) {
        this.valid = z16;
        this.version = i3;
        this.frameID = i16;
        this.skyBoxTransform = fArr;
        this.f423803face = bArr;
        this.body = bArr2;
        this.events = map;
    }
}
