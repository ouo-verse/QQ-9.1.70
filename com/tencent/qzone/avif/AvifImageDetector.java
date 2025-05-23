package com.tencent.qzone.avif;

import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.hippy.qq.adapter.image.decoder.ImageDetector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes25.dex */
public class AvifImageDetector {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface Reader {

        /* compiled from: P */
        /* loaded from: classes25.dex */
        public static final class EndOfFileException extends IOException {
            static IPatchRedirector $redirector_ = null;
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        int getInt32BE() throws IOException;

        int read(byte[] bArr, int i3) throws IOException;
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f364004a;

        /* renamed from: b, reason: collision with root package name */
        public final int f364005b;

        /* renamed from: c, reason: collision with root package name */
        public final int f364006c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f364007d;

        a(int i3, int i16, int i17, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), iArr);
                return;
            }
            this.f364004a = i3;
            this.f364005b = i16;
            this.f364006c = i17;
            this.f364007d = iArr;
        }

        public boolean a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
            }
            for (int i16 : this.f364007d) {
                if (i16 == i3) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "AvifFileType{ftyp=" + this.f364004a + ", majorBrand=" + this.f364005b + ", minorVersion=" + this.f364006c + ", compatibleBrands=" + Arrays.toString(this.f364007d) + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class b implements Reader {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f364008a;

        b(ByteBuffer byteBuffer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) byteBuffer);
            } else {
                this.f364008a = byteBuffer;
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
            }
        }

        public int a() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (this.f364008a.remaining() >= 1) {
                return this.f364008a.get();
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.tencent.qzone.avif.AvifImageDetector.Reader
        public int getInt32BE() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return (a() << 24) | (a() << 16) | (a() << 8) | a();
        }

        @Override // com.tencent.qzone.avif.AvifImageDetector.Reader
        public int read(byte[] bArr, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr, i3)).intValue();
            }
            int min = Math.min(i3, this.f364008a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f364008a.get(bArr, 0, min);
            return min;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class c implements Reader {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f364009a;

        c(InputStream inputStream) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputStream);
            } else {
                this.f364009a = inputStream;
            }
        }

        public int a() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            int read = this.f364009a.read();
            if (read != -1) {
                return read;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.tencent.qzone.avif.AvifImageDetector.Reader
        public int getInt32BE() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return (a() << 24) | (a() << 16) | (a() << 8) | a();
        }

        @Override // com.tencent.qzone.avif.AvifImageDetector.Reader
        public int read(byte[] bArr, int i3) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr, i3)).intValue();
            }
            int i16 = 0;
            int i17 = 0;
            while (i16 < i3 && (i17 = this.f364009a.read(bArr, i16, i3 - i16)) != -1) {
                i16 += i17;
            }
            if (i16 == 0 && i17 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i16;
        }
    }

    private static int a(byte[] bArr, int i3) {
        return bArr[i3 + 3] | (bArr[i3] << 24) | (bArr[i3 + 1] << RegisterType.UNINIT_REF) | (bArr[i3 + 2] << 8);
    }

    public static boolean b(InputStream inputStream) {
        int i3;
        a e16 = e(inputStream);
        ImageManagerLog.d("AVIF_", "isAvif parseAvifFileType, avifFileType:" + e16);
        if (e16 != null && ((i3 = e16.f364005b) == 1635150182 || i3 == 1635150195 || e16.a(ImageDetector.AVIF_AVIF) || e16.a(ImageDetector.AVIF_AVIS))) {
            return true;
        }
        return false;
    }

    public static boolean c(ByteBuffer byteBuffer) {
        a f16 = f(byteBuffer);
        if (f16 != null && (f16.f364005b == 1635150195 || f16.a(ImageDetector.AVIF_AVIS))) {
            return true;
        }
        return false;
    }

    private static a d(Reader reader) {
        try {
            int int32BE = reader.getInt32BE();
            int int32BE2 = reader.getInt32BE();
            ImageManagerLog.d(ImageDetector.TAG, "parseAvifFileType, type:" + int32BE2);
            if (int32BE2 != 1718909296) {
                return null;
            }
            int int32BE3 = reader.getInt32BE();
            int int32BE4 = reader.getInt32BE();
            int i3 = int32BE - 16;
            if (i3 % 4 != 0) {
                return null;
            }
            byte[] bArr = new byte[i3];
            if (reader.read(bArr, i3) != i3) {
                return null;
            }
            int i16 = i3 / 4;
            int[] iArr = new int[i16];
            for (int i17 = 0; i17 < i16; i17++) {
                iArr[i17] = a(bArr, i17 * 4);
            }
            return new a(int32BE2, int32BE3, int32BE4, iArr);
        } catch (IOException e16) {
            ImageManagerLog.e(ImageDetector.TAG, "parseAvifFileType, e:" + e16);
            return null;
        }
    }

    public static a e(InputStream inputStream) {
        return d(new c(inputStream));
    }

    public static a f(ByteBuffer byteBuffer) {
        return d(new b(byteBuffer));
    }
}
