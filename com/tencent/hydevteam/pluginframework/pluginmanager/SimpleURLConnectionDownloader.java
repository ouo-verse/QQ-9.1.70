package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.common.progress.ProgressFutureImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes7.dex */
class SimpleURLConnectionDownloader implements Downloader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f114771a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleURLConnectionDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f114771a = ProxyExecutors.newSingleThreadExecutor();
        }
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginmanager.Downloader
    public ProgressFuture<File> download(TargetDownloadInfo targetDownloadInfo, File file, File file2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ProgressFuture) iPatchRedirector.redirect((short) 2, this, targetDownloadInfo, file, file2);
        }
        AtomicLong atomicLong = new AtomicLong(0L);
        return new ProgressFutureImpl<File>(this.f114771a.submit(new DownloadTask(targetDownloadInfo, file, file2, atomicLong)), targetDownloadInfo.size, atomicLong) { // from class: com.tencent.hydevteam.pluginframework.pluginmanager.SimpleURLConnectionDownloader.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private /* synthetic */ double f114772a;

            /* renamed from: b, reason: collision with root package name */
            private /* synthetic */ AtomicLong f114773b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r5, null);
                this.f114772a = r6;
                this.f114773b = atomicLong;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, r5, Double.valueOf(r6), atomicLong);
                }
            }

            @Override // com.tencent.hydevteam.common.progress.ProgressFutureImpl, com.tencent.hydevteam.common.progress.Progress
            public double getProgress() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Double) iPatchRedirector2.redirect((short) 2, (Object) this)).doubleValue();
                }
                if (this.f114772a != 0.0d && !isDone()) {
                    return this.f114773b.get() / this.f114772a;
                }
                if (!isDone()) {
                    return 0.0d;
                }
                return 1.0d;
            }
        };
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class DownloadTask implements Callable<File> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final File f114774a;

        /* renamed from: b, reason: collision with root package name */
        private TargetDownloadInfo f114775b;

        /* renamed from: c, reason: collision with root package name */
        private File f114776c;

        /* renamed from: d, reason: collision with root package name */
        private AtomicLong f114777d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DownloadTask(TargetDownloadInfo targetDownloadInfo, File file, File file2, AtomicLong atomicLong) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, targetDownloadInfo, file, file2, atomicLong);
                return;
            }
            this.f114775b = targetDownloadInfo;
            this.f114774a = file;
            this.f114777d = atomicLong;
            this.f114776c = file2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public File call() throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (File) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            a(b());
            return this.f114774a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final HttpURLConnection b() throws IOException {
            String str = this.f114775b.url;
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection instanceof HttpURLConnection) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                if (httpURLConnection.getResponseCode() == 200) {
                    return httpURLConnection;
                }
                throw new Error("\u8fde\u63a5\u8fd4\u56de\u503c\u4e0d\u662f200,\u800c\u4e3a" + httpURLConnection.getResponseCode());
            }
            throw new Error(str + "\u8fde\u63a5\u4e0d\u662fhttp(s)\u534f\u8bae\u7684");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0072 A[Catch: all -> 0x0127, TryCatch #1 {all -> 0x0127, blocks: (B:18:0x0060, B:19:0x006b, B:21:0x0072, B:23:0x007d, B:24:0x0080, B:28:0x0087, B:29:0x008f, B:31:0x0090), top: B:17:0x0060 }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0090 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(HttpURLConnection httpURLConnection) throws Exception {
            MessageDigest messageDigest;
            RandomAccessFile randomAccessFile;
            byte[] bArr;
            BufferedInputStream bufferedInputStream;
            int read;
            if (this.f114776c.exists() && !this.f114776c.delete()) {
                throw new Exception("\u65e0\u6cd5\u5220\u9664" + this.f114776c.getAbsolutePath());
            }
            File parentFile = this.f114776c.getParentFile();
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                this.f114776c.createNewFile();
                RandomAccessFile randomAccessFile2 = null;
                try {
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!this.f114775b.hash.isEmpty()) {
                        try {
                            messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                        } catch (NoSuchAlgorithmException unused) {
                        }
                        randomAccessFile = new RandomAccessFile(this.f114776c, "rw");
                        bArr = new byte[4096];
                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        do {
                            read = bufferedInputStream.read(bArr);
                            if (read <= 0) {
                                randomAccessFile.write(bArr, 0, read);
                                this.f114777d.getAndAdd(read);
                                if (messageDigest != null) {
                                    messageDigest.update(bArr, 0, read);
                                }
                            } else {
                                bufferedInputStream.close();
                                randomAccessFile.close();
                                if (messageDigest != null) {
                                    byte[] digest = messageDigest.digest();
                                    StringBuilder sb5 = new StringBuilder(digest.length << 1);
                                    for (byte b16 : digest) {
                                        sb5.append(Integer.toHexString((b16 & 255) | 256).substring(1, 3));
                                    }
                                    String sb6 = sb5.toString();
                                    if (!sb6.equalsIgnoreCase(this.f114775b.hash)) {
                                        throw new Error("MD5\u68c0\u9a8c\u5931\u8d25expect==" + this.f114775b.hash + " actual==" + sb6);
                                    }
                                }
                                MinFileUtils.a(this.f114774a);
                                if (this.f114776c.renameTo(this.f114774a)) {
                                    return;
                                }
                                throw new Exception("\u91cd\u547d\u540d\u5931\u8d25: " + this.f114776c.getAbsolutePath() + "->" + this.f114774a.getAbsolutePath());
                            }
                        } while (!Thread.interrupted());
                        throw new Error("interrupted");
                    }
                    bArr = new byte[4096];
                    bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    do {
                        read = bufferedInputStream.read(bArr);
                        if (read <= 0) {
                        }
                    } while (!Thread.interrupted());
                    throw new Error("interrupted");
                } catch (Throwable th6) {
                    th = th6;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    throw th;
                }
                messageDigest = null;
                randomAccessFile = new RandomAccessFile(this.f114776c, "rw");
            } else {
                throw new Exception("\u521b\u5efa\u76ee\u5f55\u5931\u8d25:" + parentFile.getAbsolutePath());
            }
        }
    }
}
