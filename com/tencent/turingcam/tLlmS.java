package com.tencent.turingcam;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
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
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class tLlmS {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, SkEpO> f382377a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f382378b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f382379c;

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReference<BfUKf> f382380d;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ShGzN {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f382381a;

        /* renamed from: b, reason: collision with root package name */
        public final String f382382b;

        public ShGzN(int i3, String str, String str2, long j3, String str3, String str4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, Long.valueOf(j3), str3, str4);
                return;
            }
            this.f382381a = i3;
            byte[] bArr = null;
            if (i3 == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sign", str);
                    jSONObject.put("nonce", str2);
                    jSONObject.put("timestamp", j3);
                    jSONObject.put("token", str3);
                    jSONObject.put("signMethod", str4);
                    bArr = jSONObject.toString().getBytes("UTF-8");
                } catch (Throwable unused) {
                }
                if (bArr == null) {
                    this.f382382b = "e1";
                    return;
                } else {
                    this.f382382b = Base64.encodeToString(bArr, 2);
                    return;
                }
            }
            this.f382382b = null;
        }

        public static ShGzN a(int i3) {
            return new ShGzN(i3, null, null, 0L, null, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class SkEpO {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final long f382383a;

        /* renamed from: b, reason: collision with root package name */
        public final String f382384b;

        public SkEpO(long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str);
            } else {
                this.f382383a = j3;
                this.f382384b = str;
            }
        }

        public static SkEpO a(String str) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ":");
            try {
                return new SkEpO(Long.parseLong(stringTokenizer.nextToken()), stringTokenizer.nextToken());
            } catch (Throwable unused) {
                return null;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f382383a + ":" + this.f382384b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SkEpO f382385a;

        public spXPg(SkEpO skEpO) {
            this.f382385a = skEpO;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) skEpO);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.io.File] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.nio.channels.FileChannel] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        @Override // java.lang.Runnable
        public void run() {
            RandomAccessFile randomAccessFile;
            int indexOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            System.currentTimeMillis();
            String skEpO = this.f382385a.toString();
            ?? a16 = tLlmS.a();
            int length = skEpO.length();
            synchronized (tLlmS.f382379c) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                FileLock fileLock = null;
                try {
                    try {
                        randomAccessFile = new RandomAccessFile((File) a16, "rw");
                        try {
                            a16 = randomAccessFile.getChannel();
                            try {
                                fileLock = a16.lock();
                                if (randomAccessFile.length() != 0) {
                                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                                    while (true) {
                                        int read = a16.read(allocate);
                                        if (read <= 0) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(allocate.array(), 0, read);
                                        allocate.clear();
                                    }
                                    skEpO = byteArrayOutputStream + "," + skEpO;
                                    while (skEpO.length() > (length + 1) * 50 && (indexOf = skEpO.indexOf(",")) >= 0) {
                                        SkEpO a17 = SkEpO.a(skEpO.substring(0, indexOf));
                                        if (a17 != null) {
                                            String valueOf = String.valueOf(B9LVG.a(a17.f382384b.getBytes()));
                                            HashMap<String, SkEpO> hashMap = tLlmS.f382377a;
                                            synchronized (hashMap) {
                                                hashMap.remove(valueOf);
                                            }
                                        }
                                        skEpO = skEpO.substring(indexOf + 1);
                                    }
                                }
                                a16.position(0L);
                                ByteBuffer wrap = ByteBuffer.wrap(skEpO.getBytes());
                                while (wrap.hasRemaining()) {
                                    a16.write(wrap);
                                }
                                a16.truncate(wrap.position());
                            } catch (Throwable unused) {
                                if (fileLock != null && fileLock.isValid()) {
                                    fileLock.release();
                                    a16 = a16;
                                }
                                HDnuc.a(a16);
                                HDnuc.a(randomAccessFile);
                            }
                        } catch (Throwable unused2) {
                            a16 = 0;
                        }
                    } catch (Throwable unused3) {
                        a16 = 0;
                        randomAccessFile = null;
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        fileLock.release();
                        a16 = a16;
                    }
                } catch (IOException unused4) {
                }
                HDnuc.a(a16);
                HDnuc.a(randomAccessFile);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17150);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f382377a = new HashMap<>();
        f382378b = new AtomicBoolean(false);
        f382379c = new Object();
        f382380d = new AtomicReference<>();
    }

    public static File a() {
        Context context;
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        return new File(context.getDir("turingfd", 0), CRchv.f381749f);
    }

    public static String b() {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File a16 = a();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        synchronized (f382379c) {
            try {
                randomAccessFile = new RandomAccessFile(a16, "rw");
                try {
                    fileChannel = randomAccessFile.getChannel();
                    try {
                        fileLock = fileChannel.lock();
                    } catch (Throwable unused) {
                        fileLock = null;
                    }
                } catch (Throwable unused2) {
                    fileChannel = null;
                    fileLock = null;
                }
            } catch (Throwable unused3) {
                fileChannel = null;
                randomAccessFile = null;
                fileLock = null;
            }
            try {
                if (randomAccessFile.length() == 0) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused4) {
                        }
                    }
                    HDnuc.a(fileChannel);
                    HDnuc.a(randomAccessFile);
                    return null;
                }
                ByteBuffer allocate = ByteBuffer.allocate(1024);
                while (true) {
                    int read = fileChannel.read(allocate);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(allocate.array(), 0, read);
                    allocate.clear();
                }
                String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused5) {
                    }
                }
                HDnuc.a(fileChannel);
                HDnuc.a(randomAccessFile);
                return byteArrayOutputStream2;
            } catch (Throwable unused6) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused7) {
                    }
                }
                HDnuc.a(fileChannel);
                HDnuc.a(randomAccessFile);
                return null;
            }
        }
    }

    public static void a(long j3, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SkEpO skEpO = new SkEpO(j3, str);
        String valueOf = String.valueOf(B9LVG.a(str.getBytes()));
        HashMap<String, SkEpO> hashMap = f382377a;
        synchronized (hashMap) {
            hashMap.put(valueOf, skEpO);
        }
        zVR7H.f382477b.submit(new spXPg(skEpO));
    }
}
