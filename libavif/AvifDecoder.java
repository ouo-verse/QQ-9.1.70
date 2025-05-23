package libavif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AvifDecoder {

    /* renamed from: a, reason: collision with root package name */
    private volatile long f414843a;

    AvifDecoder(long j3) {
        this.f414843a = j3;
    }

    private void a() {
        if (this.f414843a != 0) {
        } else {
            throw new IllegalStateException("Native Decoder already destroyed");
        }
    }

    public static AvifDecoder c(byte[] bArr) {
        return d(bArr, 0, bArr.length);
    }

    private static native long createDecoderByteArray0(@NonNull byte[] bArr, int i3, int i16);

    private static native long createDecoderByteBuffer0(@NonNull ByteBuffer byteBuffer, int i3, int i16);

    public static AvifDecoder d(byte[] bArr, int i3, int i16) {
        long createDecoderByteArray0 = createDecoderByteArray0(bArr, i3, i16);
        if (createDecoderByteArray0 == 0) {
            return null;
        }
        return new AvifDecoder(createDecoderByteArray0);
    }

    private static native void destroy0(long j3);

    public static AvifDecoder e(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            if (!byteBuffer.isDirect()) {
                if (byteBuffer.hasArray()) {
                    return d(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                }
                throw new IllegalArgumentException("Cannot have non-direct ByteBuffer with no byte array");
            }
            long createDecoderByteBuffer0 = createDecoderByteBuffer0(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
            if (createDecoderByteBuffer0 == 0) {
                return null;
            }
            return new AvifDecoder(createDecoderByteBuffer0);
        }
        throw new IllegalArgumentException("buffer==null");
    }

    private static native int getFrame0(long j3, @NonNull Bitmap bitmap);

    private static native long getImage0(long j3);

    private static native int getImageCount0(long j3);

    private static native int getImageIndex0(long j3);

    private static native int getImageLimit0(long j3);

    private static native boolean nextImage0(long j3);

    private static native void reset0(long j3);

    public void b() {
        synchronized (this) {
            if (this.f414843a != 0) {
                destroy0(this.f414843a);
                this.f414843a = 0L;
            }
        }
    }

    public int f(@NonNull Bitmap bitmap) {
        a();
        return getFrame0(this.f414843a, bitmap);
    }

    protected void finalize() throws Throwable {
        try {
            b();
        } finally {
            super.finalize();
        }
    }

    @NonNull
    public AvifImage g() {
        a();
        return new AvifImage(getImage0(this.f414843a));
    }

    public int h() {
        a();
        return getImageCount0(this.f414843a);
    }

    public int i() {
        a();
        return getImageIndex0(this.f414843a);
    }

    public boolean j() {
        a();
        return nextImage0(this.f414843a);
    }

    public void k() {
        a();
        reset0(this.f414843a);
    }
}
