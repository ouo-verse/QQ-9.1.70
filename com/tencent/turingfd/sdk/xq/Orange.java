package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Orange {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Cif> f382968a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f382969b;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Orange$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Cif f382970a;

        public Cdo(Cif cif) {
            this.f382970a = cif;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cif);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            FileChannel fileChannel;
            RandomAccessFile randomAccessFile;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            System.currentTimeMillis();
            String cif = this.f382970a.toString();
            synchronized (Celse.class) {
                context = Celse.f383328a;
            }
            File file = new File(context.getDir("turingfd", 0), Sugarcane.f383110f);
            int length = cif.length();
            synchronized (Orange.f382969b) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                FileLock fileLock = null;
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        fileChannel = randomAccessFile.getChannel();
                        try {
                            fileLock = fileChannel.lock();
                            if (randomAccessFile.length() != 0) {
                                ByteBuffer allocate = ByteBuffer.allocate(1024);
                                while (true) {
                                    int read = fileChannel.read(allocate);
                                    if (read <= 0) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(allocate.array(), 0, read);
                                    allocate.clear();
                                }
                                cif = byteArrayOutputStream + "," + cif;
                                if (cif.length() > (length + 1) * 50) {
                                    cif = cif.substring(cif.indexOf(",") + 1);
                                }
                            }
                            fileChannel.position(0L);
                            ByteBuffer wrap = ByteBuffer.wrap(cif.getBytes());
                            while (wrap.hasRemaining()) {
                                fileChannel.write(wrap);
                            }
                            fileChannel.truncate(wrap.position());
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused) {
                                }
                            }
                            Eridanus.a(fileChannel);
                        } catch (Throwable unused2) {
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused3) {
                                }
                            }
                            Eridanus.a(fileChannel);
                            Eridanus.a(randomAccessFile);
                        }
                    } catch (Throwable unused4) {
                        fileChannel = null;
                    }
                } catch (Throwable unused5) {
                    fileChannel = null;
                    randomAccessFile = null;
                }
                Eridanus.a(randomAccessFile);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Orange$if, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static final class Cif {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final long f382971a;

        /* renamed from: b, reason: collision with root package name */
        public final String f382972b;

        public Cif(long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str);
            } else {
                this.f382971a = j3;
                this.f382972b = str;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f382971a + ":" + this.f382972b;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12232);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f382968a = new HashMap<>();
        new AtomicBoolean(false);
        f382969b = new Object();
        new AtomicReference();
    }

    public static void a(long j3, String str) {
        int i3;
        long j16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Cif cif = new Cif(j3, str);
        byte[] bytes = str.getBytes();
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        int length = bytes.length;
        long j17 = (length * (-4132994306676758123L)) ^ 0;
        int i16 = 0;
        int i17 = 0;
        while (i17 < (length >> 3)) {
            int i18 = i16 + (i17 << 3);
            long j18 = ((wrap.get(i18 + 0) & 255) + ((wrap.get(i18 + 1) & 255) << 8) + ((wrap.get(i18 + 2) & 255) << 16) + ((wrap.get(i18 + 3) & 255) << 24) + ((wrap.get(i18 + 4) & 255) << 32) + ((wrap.get(i18 + 5) & 255) << 40) + ((wrap.get(i18 + 6) & 255) << 48) + ((wrap.get(i18 + 7) & 255) << 56)) * (-4132994306676758123L);
            j17 = (j17 ^ ((j18 ^ (j18 >>> 47)) * (-4132994306676758123L))) * (-4132994306676758123L);
            i17++;
            i16 = 0;
        }
        switch (length & 7) {
            case 1:
                i3 = 0;
                long j19 = wrap.get((i3 + length) - r5) ^ j17;
                j16 = -4132994306676758123L;
                j17 = j19 * (-4132994306676758123L);
                break;
            case 2:
                i3 = 0;
                j17 ^= wrap.get(((i3 + length) - r5) + 1) << 8;
                long j192 = wrap.get((i3 + length) - r5) ^ j17;
                j16 = -4132994306676758123L;
                j17 = j192 * (-4132994306676758123L);
                break;
            case 3:
                i3 = 0;
                j17 ^= wrap.get(((i3 + length) - r5) + 2) << 16;
                j17 ^= wrap.get(((i3 + length) - r5) + 1) << 8;
                long j1922 = wrap.get((i3 + length) - r5) ^ j17;
                j16 = -4132994306676758123L;
                j17 = j1922 * (-4132994306676758123L);
                break;
            case 4:
                i3 = 0;
                j17 ^= wrap.get(((i3 + length) - r5) + 3) << 24;
                j17 ^= wrap.get(((i3 + length) - r5) + 2) << 16;
                j17 ^= wrap.get(((i3 + length) - r5) + 1) << 8;
                long j19222 = wrap.get((i3 + length) - r5) ^ j17;
                j16 = -4132994306676758123L;
                j17 = j19222 * (-4132994306676758123L);
                break;
            case 5:
                i3 = 0;
                j17 ^= wrap.get(((i3 + length) - r5) + 4) << 32;
                j17 ^= wrap.get(((i3 + length) - r5) + 3) << 24;
                j17 ^= wrap.get(((i3 + length) - r5) + 2) << 16;
                j17 ^= wrap.get(((i3 + length) - r5) + 1) << 8;
                long j192222 = wrap.get((i3 + length) - r5) ^ j17;
                j16 = -4132994306676758123L;
                j17 = j192222 * (-4132994306676758123L);
                break;
            case 7:
                j17 ^= wrap.get(((length + 0) - r5) + 6) << 48;
            case 6:
                i3 = 0;
                j17 ^= wrap.get(((0 + length) - r5) + 5) << 40;
                j17 ^= wrap.get(((i3 + length) - r5) + 4) << 32;
                j17 ^= wrap.get(((i3 + length) - r5) + 3) << 24;
                j17 ^= wrap.get(((i3 + length) - r5) + 2) << 16;
                j17 ^= wrap.get(((i3 + length) - r5) + 1) << 8;
                long j1922222 = wrap.get((i3 + length) - r5) ^ j17;
                j16 = -4132994306676758123L;
                j17 = j1922222 * (-4132994306676758123L);
                break;
            default:
                j16 = -4132994306676758123L;
                break;
        }
        long j26 = ((j17 >>> 47) ^ j17) * j16;
        String valueOf = String.valueOf(j26 ^ (j26 >>> 47));
        HashMap<String, Cif> hashMap = f382968a;
        synchronized (hashMap) {
            hashMap.put(valueOf, cif);
        }
        Cstrictfp.f383431a.submit(new Cdo(cif));
    }
}
