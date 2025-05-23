package com.tencent.mobileqq.stt.util;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private MediaExtractor f290864a;

    /* renamed from: b, reason: collision with root package name */
    private FileInputStream f290865b;

    /* renamed from: c, reason: collision with root package name */
    private MediaFormat f290866c;

    /* renamed from: d, reason: collision with root package name */
    private long f290867d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        boolean a(byte[] bArr, int i3, int i16);

        boolean b(MediaFormat mediaFormat);
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f290867d = 0L;
        }
    }

    private void a() {
        MediaExtractor mediaExtractor = this.f290864a;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.f290864a = null;
        }
        b(this.f290865b);
    }

    private static void b(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e16) {
            Log.i("AudioExtractor", "close EXCEPTION:" + e16);
        }
    }

    private static MediaExtractor c(FileDescriptor fileDescriptor) {
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(fileDescriptor);
            return mediaExtractor;
        } catch (IOException e16) {
            Log.i("AudioExtractor", "fail to create media extractor, " + e16);
            return null;
        }
    }

    private FileDescriptor g(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            this.f290865b = fileInputStream;
            return fileInputStream.getFD();
        } catch (IOException unused) {
            Log.i("AudioExtractor", "failed to get fd, path is " + str);
            return null;
        }
    }

    private static MediaFormat h(MediaExtractor mediaExtractor) {
        String string;
        int trackCount = mediaExtractor.getTrackCount();
        for (int i3 = 0; i3 < trackCount; i3++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
            if (trackFormat != null && (string = trackFormat.getString("mime")) != null && string.startsWith("audio/")) {
                mediaExtractor.selectTrack(i3);
                return trackFormat;
            }
        }
        return null;
    }

    int d(@NonNull MediaExtractor mediaExtractor, @NonNull a aVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8192);
        byte[] bArr = new byte[8192];
        while (true) {
            int readSampleData = mediaExtractor.readSampleData(allocate, 0);
            if (readSampleData < 0) {
                return 0;
            }
            allocate.get(bArr, 0, readSampleData);
            allocate.flip();
            this.f290867d += mediaExtractor.getSampleTime();
            if (!aVar.a(bArr, 0, readSampleData)) {
                return 6;
            }
            mediaExtractor.advance();
        }
    }

    public MediaFormat e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MediaFormat) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f290866c;
    }

    public long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        MediaFormat mediaFormat = this.f290866c;
        if (mediaFormat != null) {
            return mediaFormat.getLong("durationUs") / 1000;
        }
        return this.f290867d;
    }

    public int i(@NonNull String str, @NonNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) aVar)).intValue();
        }
        try {
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                FileDescriptor g16 = g(str);
                if (g16 == null) {
                    Log.i("AudioExtractor", "failed to open file, path is " + str);
                    a();
                    return 2;
                }
                MediaExtractor c16 = c(g16);
                this.f290864a = c16;
                if (c16 == null) {
                    Log.i("AudioExtractor", "fail to create media extractor, path is " + str);
                    a();
                    return 3;
                }
                MediaFormat h16 = h(c16);
                this.f290866c = h16;
                if (h16 == null) {
                    Log.i("AudioExtractor", "fail to select audio track, path is " + str);
                    return 4;
                }
                if (!aVar.b(h16)) {
                    Log.i("AudioExtractor", "fail to start decoding, path is " + str);
                    a();
                    return 5;
                }
                int d16 = d(this.f290864a, aVar);
                if (d16 != 0) {
                    Log.i("AudioExtractor", "fail to extract audio, path is " + str);
                }
                return d16;
            }
            Log.i("AudioExtractor", "file not exist, path is " + str);
            a();
            return 1;
        } finally {
            a();
        }
    }
}
