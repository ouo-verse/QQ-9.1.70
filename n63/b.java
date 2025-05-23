package n63;

import android.media.MediaCodec;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f418522a;

    /* renamed from: b, reason: collision with root package name */
    private final ByteBuffer f418523b;

    /* renamed from: c, reason: collision with root package name */
    private final MediaCodec.BufferInfo f418524c;

    public b(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.f418522a = i3;
        this.f418523b = byteBuffer;
        this.f418524c = bufferInfo;
    }

    public MediaCodec.BufferInfo a() {
        return this.f418524c;
    }

    public ByteBuffer b() {
        return this.f418523b;
    }

    public int c() {
        return this.f418522a;
    }
}
