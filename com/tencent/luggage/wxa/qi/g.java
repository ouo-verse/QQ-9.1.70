package com.tencent.luggage.wxa.qi;

import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.y;
import com.tencent.xweb.FileReaderHelper;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static b f138881a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b {
        @Override // com.tencent.luggage.wxa.qi.g.b
        public void loadLibrary(String str, ClassLoader classLoader) {
            System.loadLibrary(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void loadLibrary(String str, ClassLoader classLoader);
    }

    public static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (g.class) {
            f138881a = bVar;
        }
    }

    public static String b(String str, String str2) {
        v vVar = new v(com.tencent.luggage.wxa.db.a.e(), "AudioRecord");
        if (!vVar.e()) {
            vVar.w();
        }
        String a16 = a(str, str2);
        v vVar2 = new v(vVar, a16);
        w.a("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", a16, vVar2.f());
        return vVar2.g();
    }

    public static long c(String str) {
        v vVar = new v(str);
        if (vVar.e()) {
            w.d("MicroMsg.Record.AudioRecordUtil", "exist audio file");
            return vVar.s();
        }
        w.d("MicroMsg.Record.AudioRecordUtil", "audio file not exit, path:%s", str);
        return -1L;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!FileReaderHelper.AAC_EXT.equalsIgnoreCase(str) && !FileReaderHelper.MP3_EXT.equalsIgnoreCase(str) && !FileReaderHelper.WAV_EXT.equalsIgnoreCase(str) && !"pcm".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static boolean e(String str) {
        boolean c16;
        v vVar = new v(str);
        if (!vVar.e()) {
            try {
                w.d("MicroMsg.Record.AudioRecordUtil", "new audio file");
                c16 = vVar.c();
            } catch (IOException e16) {
                w.a("MicroMsg.Record.AudioRecordUtil", e16, "prepareCacheFile", new Object[0]);
                return false;
            } catch (Exception e17) {
                w.a("MicroMsg.Record.AudioRecordUtil", e17, "prepareCacheFile", new Object[0]);
                return false;
            }
        } else {
            w.d("MicroMsg.Record.AudioRecordUtil", "delete audio file");
            vVar.d();
            try {
                c16 = vVar.c();
            } catch (IOException e18) {
                w.a("MicroMsg.Record.AudioRecordUtil", e18, "prepareCacheFile", new Object[0]);
                return false;
            } catch (Exception e19) {
                w.a("MicroMsg.Record.AudioRecordUtil", e19, "prepareCacheFile", new Object[0]);
                return false;
            }
        }
        return c16;
    }

    public static b a() {
        b bVar;
        synchronized (g.class) {
            bVar = f138881a;
        }
        return bVar;
    }

    public static String a(String str, String str2) {
        return "audio" + y.a("" + str2) + b(str);
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : FileReaderHelper.AAC_EXT.equalsIgnoreCase(str) ? FileReaderHelper.M4A_EXT : FileReaderHelper.MP3_EXT.equalsIgnoreCase(str) ? FileReaderHelper.MP3_EXT : FileReaderHelper.WAV_EXT.equalsIgnoreCase(str) ? FileReaderHelper.WAV_EXT : "pcm".equalsIgnoreCase(str) ? "pcm" : "";
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : FileReaderHelper.AAC_EXT.equalsIgnoreCase(str) ? ".m4a" : FileReaderHelper.MP3_EXT.equalsIgnoreCase(str) ? DefaultHlsExtractorFactory.MP3_FILE_EXTENSION : FileReaderHelper.WAV_EXT.equalsIgnoreCase(str) ? ".wav" : "";
    }

    public static short[] a(byte[] bArr, int i3) {
        int i16 = i3 / 2;
        short[] sArr = new short[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = i17 * 2;
            sArr[i17] = (short) (((bArr[i18 + 1] & 255) << 8) | (bArr[i18] & 255));
        }
        return sArr;
    }
}
