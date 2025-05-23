package com.google.android.vending.expansion.downloader.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.util.Log;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.tencent.hippy.qq.update.qarchive.tools.zip.UnixStat;
import com.tencent.luggage.wxa.gf.i;
import com.tencent.luggage.wxa.ig.l;
import com.tencent.luggage.wxa.ig.s;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SyncFailedException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import n1.d;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DownloadThread {

    /* renamed from: a, reason: collision with root package name */
    private Context f34541a;

    /* renamed from: b, reason: collision with root package name */
    private com.google.android.vending.expansion.downloader.impl.a f34542b;

    /* renamed from: c, reason: collision with root package name */
    private DownloaderService f34543c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.vending.expansion.downloader.impl.c f34544d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.android.vending.expansion.downloader.impl.b f34545e;

    /* renamed from: f, reason: collision with root package name */
    private String f34546f;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class RetryDownload extends Throwable {
        private static final long serialVersionUID = 6196036036517540229L;

        RetryDownload() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f34547a;

        /* renamed from: b, reason: collision with root package name */
        public int f34548b;

        /* renamed from: c, reason: collision with root package name */
        public String f34549c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f34550d;

        /* renamed from: e, reason: collision with root package name */
        public String f34551e;

        /* renamed from: f, reason: collision with root package name */
        public String f34552f;

        /* renamed from: g, reason: collision with root package name */
        public String f34553g;

        /* renamed from: h, reason: collision with root package name */
        public int f34554h;

        /* renamed from: i, reason: collision with root package name */
        public long f34555i;

        b() {
            this.f34547a = 0;
            this.f34548b = 0;
            this.f34550d = false;
            this.f34554h = 0;
            this.f34555i = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f34556a;

        /* renamed from: b, reason: collision with root package name */
        public FileOutputStream f34557b;

        /* renamed from: e, reason: collision with root package name */
        public int f34560e;

        /* renamed from: g, reason: collision with root package name */
        public String f34562g;

        /* renamed from: c, reason: collision with root package name */
        public boolean f34558c = false;

        /* renamed from: d, reason: collision with root package name */
        public int f34559d = 0;

        /* renamed from: f, reason: collision with root package name */
        public boolean f34561f = false;

        public c(com.google.android.vending.expansion.downloader.impl.a aVar, DownloaderService downloaderService) {
            this.f34560e = 0;
            this.f34560e = aVar.f34582l;
            this.f34562g = aVar.f34571a;
            this.f34556a = downloaderService.q(aVar.f34573c);
        }
    }

    public DownloadThread(com.google.android.vending.expansion.downloader.impl.a aVar, DownloaderService downloaderService, com.google.android.vending.expansion.downloader.impl.b bVar) {
        this.f34541a = downloaderService;
        this.f34542b = aVar;
        this.f34543c = downloaderService;
        this.f34545e = bVar;
        this.f34544d = com.google.android.vending.expansion.downloader.impl.c.a(downloaderService);
        this.f34546f = "APKXDL (Linux; U; Android " + Build.VERSION.RELEASE + ";" + Locale.getDefault().toString() + "; " + Build.DEVICE + "/" + Build.ID + ")" + downloaderService.getPackageName();
    }

    private void A(int i3, boolean z16, int i16, int i17, boolean z17, String str) {
        com.google.android.vending.expansion.downloader.impl.a aVar = this.f34542b;
        aVar.f34578h = i3;
        aVar.f34581k = i16;
        aVar.f34582l = i17;
        aVar.f34577g = System.currentTimeMillis();
        if (!z16) {
            this.f34542b.f34580j = 0;
        } else if (z17) {
            this.f34542b.f34580j = 1;
        } else {
            this.f34542b.f34580j++;
        }
        this.f34544d.j(this.f34542b);
    }

    private String B() {
        return this.f34546f;
    }

    private void C(c cVar, byte[] bArr, int i3) throws StopRequest {
        try {
            if (cVar.f34557b == null) {
                cVar.f34557b = new FileOutputStream(cVar.f34556a, true);
            }
            cVar.f34557b.write(bArr, 0, i3);
            f(cVar);
        } catch (IOException e16) {
            if (d.j()) {
                if (d.d(d.g(cVar.f34556a)) < i3) {
                    throw new StopRequest(l.CTRL_INDEX, "insufficient space while writing destination file", e16);
                }
                throw new StopRequest(i.CTRL_INDEX, "while writing destination file: " + e16.toString(), e16);
            }
            throw new StopRequest(s.CTRL_INDEX, "external media not mounted while writing destination file");
        }
    }

    private void a(b bVar, HttpURLConnection httpURLConnection) {
        if (bVar.f34550d) {
            String str = bVar.f34549c;
            if (str != null) {
                httpURLConnection.setRequestProperty(HttpHeaders.IF_MATCH, str);
            }
            httpURLConnection.setRequestProperty("Range", "bytes=" + bVar.f34547a + "-");
        }
    }

    private boolean b(b bVar) {
        if (bVar.f34547a > 0 && bVar.f34549c == null) {
            return true;
        }
        return false;
    }

    private void c(c cVar) throws StopRequest {
        int t16 = this.f34543c.t(this.f34544d);
        if (t16 != 2) {
            if (t16 != 3) {
                if (t16 != 5) {
                    if (t16 != 6) {
                        return;
                    } else {
                        throw new StopRequest(196, "waiting for wifi or for download over cellular to be authorized");
                    }
                }
                throw new StopRequest(195, "roaming is not allowed");
            }
            throw new StopRequest(197, "waiting for wifi");
        }
        throw new StopRequest(195, "waiting for network to return");
    }

    private void d(c cVar) throws StopRequest {
        if (this.f34543c.s() == 1 && this.f34543c.w() == 193) {
            throw new StopRequest(this.f34543c.w(), "download paused");
        }
    }

    private void e(c cVar, int i3) {
        f(cVar);
        if (cVar.f34556a != null && DownloaderService.B(i3)) {
            new File(cVar.f34556a).delete();
            cVar.f34556a = null;
        }
    }

    private void f(c cVar) {
        try {
            FileOutputStream fileOutputStream = cVar.f34557b;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                cVar.f34557b = null;
            }
        } catch (IOException unused) {
        }
    }

    private void g(c cVar, HttpURLConnection httpURLConnection) throws StopRequest, RetryDownload {
        b bVar = new b();
        d(cVar);
        w(cVar, bVar);
        a(bVar, httpURLConnection);
        c(cVar);
        this.f34545e.a(3);
        k(cVar, bVar, httpURLConnection, v(cVar, httpURLConnection));
        q(cVar, bVar, httpURLConnection);
        InputStream p16 = p(cVar, httpURLConnection);
        this.f34545e.a(4);
        y(cVar, bVar, new byte[4096], p16);
    }

    private void h(c cVar) throws StopRequest {
        x(cVar);
        String str = cVar.f34556a;
        String c16 = d.c(this.f34543c, this.f34542b.f34573c);
        if (!cVar.f34556a.equals(c16)) {
            File file = new File(str);
            File file2 = new File(c16);
            com.google.android.vending.expansion.downloader.impl.a aVar = this.f34542b;
            long j3 = aVar.f34575e;
            if (j3 != -1 && aVar.f34576f == j3) {
                if (!file.renameTo(file2)) {
                    throw new StopRequest(i.CTRL_INDEX, "unable to finalize destination file");
                }
                return;
            }
            throw new StopRequest(487, "file delivered with incorrect size. probably due to network not browser configured");
        }
    }

    private int i(c cVar) {
        if (this.f34543c.t(this.f34544d) != 1) {
            return 195;
        }
        if (this.f34542b.f34580j < 5) {
            cVar.f34558c = true;
            return 194;
        }
        Log.w("LVLDL", "reached max retries for " + this.f34542b.f34580j);
        return 495;
    }

    private void j(c cVar, b bVar) throws StopRequest {
        boolean z16;
        com.google.android.vending.expansion.downloader.impl.a aVar = this.f34542b;
        aVar.f34576f = bVar.f34547a;
        this.f34544d.j(aVar);
        String str = bVar.f34551e;
        if (str != null && bVar.f34547a != Integer.parseInt(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (b(bVar)) {
                throw new StopRequest(489, "mismatched content length");
            }
            throw new StopRequest(i(cVar), "closed socket before end of file");
        }
    }

    private void k(c cVar, b bVar, HttpURLConnection httpURLConnection, int i3) throws StopRequest, RetryDownload {
        int i16;
        if (i3 == 503 && this.f34542b.f34580j < 5) {
            m(cVar, httpURLConnection);
        }
        if (bVar.f34550d) {
            i16 = 206;
        } else {
            i16 = 200;
        }
        if (i3 != i16) {
            l(cVar, bVar, i3);
        } else {
            cVar.f34560e = 0;
        }
    }

    private void l(c cVar, b bVar, int i3) throws StopRequest {
        int i16;
        if (!DownloaderService.B(i3)) {
            if (i3 >= 300 && i3 < 400) {
                i16 = UnixStat.DEFAULT_DIR_PERM;
            } else if (bVar.f34550d && i3 == 200) {
                i16 = 489;
            } else {
                i16 = 494;
            }
        } else {
            i16 = i3;
        }
        throw new StopRequest(i16, "http error " + i3);
    }

    private void m(c cVar, HttpURLConnection httpURLConnection) throws StopRequest {
        cVar.f34558c = true;
        String headerField = httpURLConnection.getHeaderField("Retry-After");
        if (headerField != null) {
            try {
                int parseInt = Integer.parseInt(headerField);
                cVar.f34559d = parseInt;
                if (parseInt >= 0) {
                    if (parseInt >= 30) {
                        if (parseInt > 86400) {
                            cVar.f34559d = 86400;
                        }
                    } else {
                        cVar.f34559d = 30;
                    }
                    cVar.f34559d = (cVar.f34559d + d.f417977a.nextInt(31)) * 1000;
                } else {
                    cVar.f34559d = 0;
                }
            } catch (NumberFormatException unused) {
            }
        }
        throw new StopRequest(194, "got 503 Service Unavailable, will retry later");
    }

    private void n() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Net ");
        if (this.f34543c.t(this.f34544d) == 1) {
            str = "Up";
        } else {
            str = "Down";
        }
        sb5.append(str);
        Log.i("LVLDL", sb5.toString());
    }

    private void o(int i3, boolean z16, int i16, int i17, boolean z17, String str) {
        A(i3, z16, i16, i17, z17, str);
        DownloaderService.A(i3);
    }

    private InputStream p(c cVar, HttpURLConnection httpURLConnection) throws StopRequest {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException e16) {
            n();
            throw new StopRequest(i(cVar), "while getting entity: " + e16.toString(), e16);
        }
    }

    private void q(c cVar, b bVar, HttpURLConnection httpURLConnection) throws StopRequest {
        if (bVar.f34550d) {
            return;
        }
        s(cVar, bVar, httpURLConnection);
        try {
            DownloaderService downloaderService = this.f34543c;
            com.google.android.vending.expansion.downloader.impl.a aVar = this.f34542b;
            cVar.f34556a = downloaderService.p(aVar.f34573c, aVar.f34575e);
            try {
                cVar.f34557b = new FileOutputStream(cVar.f34556a);
            } catch (FileNotFoundException e16) {
                try {
                    if (new File(d.h(this.f34543c)).mkdirs()) {
                        cVar.f34557b = new FileOutputStream(cVar.f34556a);
                    }
                } catch (Exception unused) {
                    throw new StopRequest(i.CTRL_INDEX, "while opening destination file: " + e16.toString(), e16);
                }
            }
            z(cVar, bVar);
            c(cVar);
        } catch (DownloaderService.GenerateSaveFileError e17) {
            throw new StopRequest(e17.mStatus, e17.mMessage);
        }
    }

    private int r(c cVar, b bVar, byte[] bArr, InputStream inputStream) throws StopRequest {
        try {
            return inputStream.read(bArr);
        } catch (IOException e16) {
            n();
            this.f34542b.f34576f = bVar.f34547a;
            this.f34544d.j(this.f34542b);
            if (b(bVar)) {
                throw new StopRequest(489, "while reading response: " + e16.toString() + ", can't resume interrupted download with no ETag", e16);
            }
            throw new StopRequest(i(cVar), "while reading response: " + e16.toString(), e16);
        }
    }

    private void s(c cVar, b bVar, HttpURLConnection httpURLConnection) throws StopRequest {
        boolean z16;
        String headerField = httpURLConnection.getHeaderField(HttpHeader.RSP.CONTENT_DISPOSITION);
        if (headerField != null) {
            bVar.f34552f = headerField;
        }
        String headerField2 = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_LOCATION);
        if (headerField2 != null) {
            bVar.f34553g = headerField2;
        }
        String headerField3 = httpURLConnection.getHeaderField("ETag");
        if (headerField3 != null) {
            bVar.f34549c = headerField3;
        }
        String headerField4 = httpURLConnection.getHeaderField("Transfer-Encoding");
        if (headerField4 == null) {
            headerField4 = null;
        }
        String headerField5 = httpURLConnection.getHeaderField("Content-Type");
        if (headerField5 != null && !headerField5.equals("application/vnd.android.obb")) {
            throw new StopRequest(487, "file delivered with incorrect Mime type");
        }
        if (headerField4 == null) {
            long contentLength = httpURLConnection.getContentLength();
            if (headerField5 != null) {
                if (contentLength != -1 && contentLength != this.f34542b.f34575e) {
                    Log.e("LVLDL", "Incorrect file size delivered.");
                } else {
                    bVar.f34551e = Long.toString(contentLength);
                }
            }
        }
        if (bVar.f34551e == null && (headerField4 == null || !headerField4.equalsIgnoreCase("chunked"))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
        } else {
            throw new StopRequest(495, "can't know size of download, giving up");
        }
    }

    private void t(c cVar, b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = bVar.f34547a;
        if (i3 - bVar.f34554h > 4096 && currentTimeMillis - bVar.f34555i > 1000) {
            com.google.android.vending.expansion.downloader.impl.a aVar = this.f34542b;
            aVar.f34576f = i3;
            this.f34544d.l(aVar);
            bVar.f34554h = bVar.f34547a;
            bVar.f34555i = currentTimeMillis;
            long j3 = bVar.f34548b;
            DownloaderService downloaderService = this.f34543c;
            downloaderService.C(j3 + downloaderService.M);
        }
    }

    private int v(c cVar, HttpURLConnection httpURLConnection) throws StopRequest {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e16) {
            n();
            throw new StopRequest(i(cVar), "while trying to execute request: " + e16.toString(), e16);
        } catch (IllegalArgumentException e17) {
            throw new StopRequest(495, "while trying to execute request: " + e17.toString(), e17);
        }
    }

    private void w(c cVar, b bVar) throws StopRequest {
        String str = cVar.f34556a;
        if (str != null) {
            if (d.k(str)) {
                File file = new File(cVar.f34556a);
                if (file.exists()) {
                    long length = file.length();
                    if (length == 0) {
                        file.delete();
                        cVar.f34556a = null;
                    } else if (this.f34542b.f34574d != null) {
                        try {
                            cVar.f34557b = new FileOutputStream(cVar.f34556a, true);
                            bVar.f34547a = (int) length;
                            long j3 = this.f34542b.f34575e;
                            if (j3 != -1) {
                                bVar.f34551e = Long.toString(j3);
                            }
                            bVar.f34549c = this.f34542b.f34574d;
                            bVar.f34550d = true;
                        } catch (FileNotFoundException e16) {
                            throw new StopRequest(i.CTRL_INDEX, "while opening destination for resuming: " + e16.toString(), e16);
                        }
                    } else {
                        file.delete();
                        throw new StopRequest(489, "Trying to resume a download that can't be resumed");
                    }
                }
            } else {
                throw new StopRequest(i.CTRL_INDEX, "found invalid internal destination filename");
            }
        }
        if (cVar.f34557b != null) {
            f(cVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.io.SyncFailedException] */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.io.FileNotFoundException] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x00bd -> B:11:0x00bd). Please report as a decompilation issue!!! */
    private void x(c cVar) {
        FileOutputStream fileOutputStream;
        ?? e16 = 0;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        e16 = 0;
        e16 = 0;
        try {
        } catch (Throwable th5) {
            th = th5;
            e16 = fileOutputStream;
        }
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(cVar.f34556a, true);
                    try {
                        FileDescriptor fd5 = fileOutputStream.getFD();
                        fd5.sync();
                        fileOutputStream.close();
                        e16 = fd5;
                        fileOutputStream = fileOutputStream;
                    } catch (FileNotFoundException e17) {
                        e16 = e17;
                        Log.w("LVLDL", "file " + cVar.f34556a + " not found: " + e16);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (SyncFailedException e18) {
                        e16 = e18;
                        Log.w("LVLDL", "file " + cVar.f34556a + " sync failed: " + e16);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (IOException e19) {
                        e = e19;
                        fileOutputStream2 = fileOutputStream;
                        ?? sb5 = new StringBuilder();
                        sb5.append("IOException trying to sync ");
                        sb5.append(cVar.f34556a);
                        sb5.append(MsgSummary.STR_COLON);
                        sb5.append(e);
                        Log.w("LVLDL", sb5.toString());
                        e16 = fileOutputStream2;
                        fileOutputStream = sb5;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                            e16 = fileOutputStream2;
                            fileOutputStream = sb5;
                        }
                    } catch (RuntimeException e26) {
                        e = e26;
                        fileOutputStream3 = fileOutputStream;
                        Log.w("LVLDL", "exception while syncing file: ", e);
                        e16 = fileOutputStream3;
                        fileOutputStream = fileOutputStream;
                        if (fileOutputStream3 != null) {
                            fileOutputStream3.close();
                            e16 = fileOutputStream3;
                            fileOutputStream = fileOutputStream;
                        }
                    }
                } catch (FileNotFoundException e27) {
                    fileOutputStream = null;
                    e16 = e27;
                } catch (SyncFailedException e28) {
                    fileOutputStream = null;
                    e16 = e28;
                } catch (IOException e29) {
                    e = e29;
                } catch (RuntimeException e36) {
                    e = e36;
                }
            } catch (IOException e37) {
                Log.w("LVLDL", "IOException while closing synced file: ", e37);
                e16 = e16;
                fileOutputStream = fileOutputStream;
            } catch (RuntimeException e38) {
                Log.w("LVLDL", "exception while closing file: ", e38);
                e16 = e16;
                fileOutputStream = fileOutputStream;
            }
        } catch (Throwable th6) {
            th = th6;
            if (e16 != 0) {
                try {
                    e16.close();
                } catch (IOException e39) {
                    Log.w("LVLDL", "IOException while closing synced file: ", e39);
                } catch (RuntimeException e46) {
                    Log.w("LVLDL", "exception while closing file: ", e46);
                }
            }
            throw th;
        }
    }

    private void y(c cVar, b bVar, byte[] bArr, InputStream inputStream) throws StopRequest {
        while (true) {
            int r16 = r(cVar, bVar, bArr, inputStream);
            if (r16 == -1) {
                j(cVar, bVar);
                return;
            }
            cVar.f34561f = true;
            C(cVar, bArr, r16);
            bVar.f34547a += r16;
            bVar.f34548b += r16;
            t(cVar, bVar);
            d(cVar);
        }
    }

    private void z(c cVar, b bVar) {
        com.google.android.vending.expansion.downloader.impl.a aVar = this.f34542b;
        aVar.f34574d = bVar.f34549c;
        this.f34544d.j(aVar);
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public void u() {
        Process.setThreadPriority(10);
        c cVar = new c(this.f34542b, this.f34543c);
        PowerManager.WakeLock wakeLock = null;
        try {
            try {
                wakeLock = ((PowerManager) this.f34541a.getSystemService("power")).newWakeLock(1, "LVLDL");
                wakeLock.acquire();
                boolean z16 = false;
                while (!z16) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(cVar.f34562g).openConnection();
                    httpURLConnection.setRequestProperty("User-Agent", B());
                    try {
                        g(cVar, httpURLConnection);
                        httpURLConnection.disconnect();
                        z16 = true;
                    } catch (RetryDownload unused) {
                        httpURLConnection.disconnect();
                    } catch (Throwable th5) {
                        httpURLConnection.disconnect();
                        throw th5;
                    }
                }
                h(cVar);
                wakeLock.release();
                e(cVar, 200);
                o(200, cVar.f34558c, cVar.f34559d, cVar.f34560e, cVar.f34561f, cVar.f34556a);
            } catch (StopRequest e16) {
                Log.w("LVLDL", "Aborting request for download " + this.f34542b.f34573c + MsgSummary.STR_COLON + e16.getMessage());
                e16.printStackTrace();
                int i3 = e16.mFinalStatus;
                if (wakeLock != null) {
                    wakeLock.release();
                }
                e(cVar, i3);
                o(i3, cVar.f34558c, cVar.f34559d, cVar.f34560e, cVar.f34561f, cVar.f34556a);
            } catch (Throwable th6) {
                Log.w("LVLDL", "Exception for " + this.f34542b.f34573c + MsgSummary.STR_COLON + th6);
            }
        } finally {
            if (wakeLock != null) {
                wakeLock.release();
            }
            e(cVar, com.tencent.luggage.wxa.fg.d.CTRL_INDEX);
            o(com.tencent.luggage.wxa.fg.d.CTRL_INDEX, cVar.f34558c, cVar.f34559d, cVar.f34560e, cVar.f34561f, cVar.f34556a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class StopRequest extends Throwable {
        private static final long serialVersionUID = 6338592678988347973L;
        public int mFinalStatus;

        public StopRequest(int i3, String str) {
            super(str);
            this.mFinalStatus = i3;
        }

        public StopRequest(int i3, String str, Throwable th5) {
            super(str, th5);
            this.mFinalStatus = i3;
        }
    }
}
