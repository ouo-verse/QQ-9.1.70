package com.tencent.mobileqq.weiyun.sdk.upload;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.weiyun.channel.HttpChannel;
import com.tencent.mobileqq.weiyun.sdk.upload.c;
import com.tencent.mobileqq.weiyun.utils.e;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.weiyun.transmission.ErrorCode;
import com.tencent.weiyun.transmission.utils.ErrorCodeUtil;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.utils.NetworkUtils;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import mqq.app.MobileQQ;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final UploadRequest f315274a;

    /* renamed from: b, reason: collision with root package name */
    protected final WyUploadJob f315275b;

    /* renamed from: c, reason: collision with root package name */
    protected final byte[] f315276c;

    /* renamed from: d, reason: collision with root package name */
    protected final byte[] f315277d;

    /* renamed from: e, reason: collision with root package name */
    protected DefaultHttpClient f315278e;

    /* renamed from: f, reason: collision with root package name */
    protected int f315279f;

    /* renamed from: g, reason: collision with root package name */
    protected int f315280g;

    /* renamed from: h, reason: collision with root package name */
    protected int f315281h;

    /* renamed from: i, reason: collision with root package name */
    protected int f315282i;

    /* renamed from: j, reason: collision with root package name */
    private long f315283j;

    /* renamed from: k, reason: collision with root package name */
    private long f315284k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<SoftReference<a>> f315285l;

    /* renamed from: m, reason: collision with root package name */
    private final c.a f315286m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f315287a;

        a(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr);
            } else {
                this.f315287a = bArr;
            }
        }
    }

    public d(UploadRequest uploadRequest, WyUploadJob wyUploadJob) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) uploadRequest, (Object) wyUploadJob);
            return;
        }
        this.f315278e = null;
        this.f315279f = 0;
        this.f315280g = 0;
        this.f315281h = 0;
        this.f315282i = 4;
        this.f315285l = new ArrayList<>();
        this.f315274a = uploadRequest;
        this.f315275b = wyUploadJob;
        this.f315276c = e.c(uploadRequest.checkKey());
        this.f315277d = e.c(uploadRequest.sha());
        this.f315283j = 0L;
        this.f315284k = uploadRequest.size();
        c.a aVar = new c.a();
        this.f315286m = aVar;
        try {
            aVar.f315271d = g().toString();
        } catch (MalformedURLException unused) {
        }
        c.a aVar2 = this.f315286m;
        aVar2.f315268a = i(aVar2.f315271d, this);
        this.f315286m.f315269b = SystemClock.uptimeMillis();
    }

    private void d() {
        DefaultHttpClient defaultHttpClient = this.f315278e;
        if (defaultHttpClient != null) {
            defaultHttpClient.getConnectionManager().shutdown();
            this.f315278e = null;
        }
    }

    private HttpPost e(URL url) {
        HttpPost httpPost = new HttpPost(url.toString());
        httpPost.addHeader("Accept", "*/*");
        httpPost.addHeader("User-Agent", "QdiskAndroid1.1.0");
        httpPost.addHeader("Accept-Language", "zh-CN");
        httpPost.addHeader("Referer", "http://udisk.qq.com/android");
        httpPost.addHeader(HttpHeader.RSP.CHARSET, "UTF-8");
        httpPost.addHeader("Proxy-Connection", "Keep-Alive");
        httpPost.addHeader("Pragma", "no-cache");
        httpPost.addHeader(FileUploadBase.CONTENT_TYPE, "text/octet");
        if (this.f315278e == null) {
            this.f315278e = HttpChannel.d();
        }
        HttpChannel.c(this.f315278e, this.f315279f);
        return httpPost;
    }

    private URL g() throws MalformedURLException {
        if (NetConnInfoCenter.getActiveNetIpFamily(true) == 2) {
            return new URL("https", "upload.weiyun.com", k(31532));
        }
        return new URL("http", this.f315274a.serverIp(), this.f315274a.serverPort(), k(31532));
    }

    public static int i(Object... objArr) {
        int i3 = 17;
        if (objArr != null) {
            for (Object obj : objArr) {
                if (obj != null) {
                    i3 = (i3 * 31) + obj.hashCode();
                }
            }
        }
        return (i3 * 31) + new Random().nextInt();
    }

    public static int j(Context context) {
        int networkType = NetworkUtils.getNetworkType(context);
        if (networkType == 2) {
            return 32768;
        }
        if (networkType == 1) {
            return 16384;
        }
        if (networkType == 3) {
            return 65536;
        }
        return -1;
    }

    private static String k(int i3) {
        return String.format("/ftn_handler/?cn=%d&cv=%d", Integer.valueOf(NetworkUtils.getNetworkType(MobileQQ.sMobileQQ)), Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.weiyun.sdk.upload.c
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return m();
    }

    void b(b bVar, long j3) {
        if (j3 != bVar.d()) {
            this.f315283j = bVar.d();
        } else {
            this.f315283j = j3;
        }
        this.f315275b.h(this.f315283j, this.f315284k);
    }

    void c(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
        }
    }

    public synchronized a f() {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        int size = this.f315285l.size();
        while (true) {
            if (size > 0) {
                aVar = this.f315285l.remove(size - 1).get();
                if (aVar != null) {
                    break;
                }
                size--;
            } else {
                aVar = null;
                break;
            }
        }
        if (aVar == null) {
            aVar = new a(new byte[40960]);
        }
        return aVar;
    }

    public synchronized void h(a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, aVar, Boolean.valueOf(z16));
        } else {
            if (this.f315285l.size() > 10) {
                return;
            }
            this.f315285l.add(new SoftReference<>(aVar));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a7, code lost:
    
        if (r5.getEntity() != null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int l(b bVar, URL url, byte[] bArr, int i3, int i16) throws IOException {
        int i17;
        boolean z16;
        boolean z17;
        a f16 = f();
        int i18 = 0;
        this.f315279f = 0;
        HttpResponse httpResponse = null;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        while (true) {
            if (i26 >= 3 && (i27 == 0 || i28 >= 3)) {
                break;
            }
            if (!this.f315275b.g()) {
                i19 = ErrorCode.TRAN_USER_CANCELED;
                break;
            }
            if (i16 > 8192) {
                try {
                    try {
                        i17 = Math.max(i16 / ((int) Math.pow(2.0d, i26)), 8192);
                    } catch (IOException e16) {
                        e = e16;
                        this.f315286m.f315270c = e;
                        i19 = ErrorCodeUtil.getErrorCode4IOException(e);
                        if (httpResponse != null) {
                        }
                        this.f315281h = i18;
                        this.f315282i = (int) (this.f315282i * 1.25d);
                        if (i19 != 1830002) {
                        }
                        if (i19 == 1830001) {
                        }
                        if (NetworkUtils.isNetworkAvailable(MobileQQ.sMobileQQ)) {
                        }
                        if (i19 == 0) {
                        }
                        h(f16, z17);
                        return i19;
                    } catch (Exception e17) {
                        e = e17;
                        this.f315286m.f315270c = e;
                        if (httpResponse != null) {
                        }
                        i19 = ErrorCode.TRAN_UNKNOWN_EXCEPTION;
                        this.f315281h = i18;
                        this.f315282i = (int) (this.f315282i * 1.25d);
                        if (i19 != 1830002) {
                        }
                        if (i19 == 1830001) {
                        }
                        if (NetworkUtils.isNetworkAvailable(MobileQQ.sMobileQQ)) {
                        }
                        if (i19 == 0) {
                        }
                        h(f16, z17);
                        return i19;
                    }
                } finally {
                    if (httpResponse != null && httpResponse.getEntity() != null) {
                        httpResponse.getEntity().consumeContent();
                    }
                }
            } else {
                i17 = i16;
            }
            int a16 = bVar.a(this.f315283j, i17, bArr, 0, i3);
            try {
                HttpPost e18 = e(url);
                try {
                    e18.setEntity(new com.tencent.mobileqq.weiyun.sdk.upload.a(bArr, i18, a16 + i17));
                    try {
                        httpResponse = this.f315278e.execute(e18);
                        if (httpResponse == null) {
                            d();
                        } else {
                            int statusCode = httpResponse.getStatusLine().getStatusCode();
                            if (statusCode != 200) {
                                i19 = statusCode + ErrorCode.HTTP_ERROR_BASE;
                                try {
                                    Header[] headers = httpResponse.getHeaders(HttpMsg.USERRETURNCODE);
                                    if (headers != null && headers.length > 0) {
                                        i19 = Integer.parseInt(headers[i18].getValue());
                                    }
                                } catch (Throwable unused) {
                                }
                                d();
                            } else {
                                int read = new BufferedInputStream(httpResponse.getEntity().getContent()).read(f16.f315287a);
                                if (read <= 0) {
                                    if (httpResponse.getEntity() != null) {
                                        httpResponse.getEntity().consumeContent();
                                    }
                                    i19 = ErrorCode.TRAN_HTTP_READ_CONTENT_ERROR;
                                } else {
                                    if (statusCode == 200) {
                                        z16 = true;
                                    } else {
                                        z16 = i18;
                                    }
                                    try {
                                        i19 = bVar.e(z16, f16.f315287a, read);
                                        if (i19 == 0) {
                                            this.f315279f = i18;
                                            this.f315280g = i17;
                                            if (i26 == 0) {
                                                int i29 = this.f315281h + 1;
                                                this.f315281h = i29;
                                                if (i29 >= this.f315282i) {
                                                    this.f315280g = i17 + 8192;
                                                    this.f315281h = i18;
                                                }
                                            }
                                            int i36 = this.f315280g;
                                            if (i36 < 8192) {
                                                this.f315280g = 8192;
                                            } else if (i36 > 65536) {
                                                this.f315280g = 65536;
                                            }
                                            if (httpResponse.getEntity() != null) {
                                                httpResponse.getEntity().consumeContent();
                                            }
                                            i19 = i18;
                                        } else if (100002 == i19) {
                                            if (httpResponse.getEntity() != null) {
                                                httpResponse.getEntity().consumeContent();
                                            }
                                        } else if (httpResponse.getEntity() != null) {
                                            httpResponse.getEntity().consumeContent();
                                        }
                                    } catch (IOException e19) {
                                        e = e19;
                                        i27 = i18;
                                        this.f315286m.f315270c = e;
                                        i19 = ErrorCodeUtil.getErrorCode4IOException(e);
                                        if (httpResponse != null && httpResponse.getEntity() != null) {
                                            httpResponse.getEntity().consumeContent();
                                        }
                                        this.f315281h = i18;
                                        this.f315282i = (int) (this.f315282i * 1.25d);
                                        if (i19 != 1830002) {
                                            this.f315279f++;
                                        } else {
                                            this.f315279f = i18;
                                        }
                                        if (i19 == 1830001 && i19 != 1830002 && i19 != 1830010 && i19 != 1830014 && i19 != 1830015 && i19 != 1830018 && i19 != 1830023 && i19 != 1830027) {
                                            i18 = i27;
                                        } else {
                                            if (NetworkUtils.isNetworkAvailable(MobileQQ.sMobileQQ)) {
                                                i19 = ErrorCode.TRAN_NO_NETWORK;
                                                break;
                                            }
                                            i28++;
                                            HttpResponse httpResponse2 = httpResponse;
                                            try {
                                                LockMethodProxy.sleep((long) ((Math.pow(i26, 0.5d) + 2.0d) * 2500.0d));
                                                i18 = 1;
                                                httpResponse = httpResponse2;
                                            } catch (InterruptedException unused2) {
                                            }
                                            if (i19 == 0) {
                                            }
                                            h(f16, z17);
                                            return i19;
                                        }
                                        i26++;
                                        i27 = i18;
                                        i18 = 0;
                                    } catch (Exception e26) {
                                        e = e26;
                                        i27 = i18;
                                        this.f315286m.f315270c = e;
                                        if (httpResponse != null && httpResponse.getEntity() != null) {
                                            httpResponse.getEntity().consumeContent();
                                        }
                                        i19 = ErrorCode.TRAN_UNKNOWN_EXCEPTION;
                                        this.f315281h = i18;
                                        this.f315282i = (int) (this.f315282i * 1.25d);
                                        if (i19 != 1830002) {
                                        }
                                        if (i19 == 1830001) {
                                        }
                                        if (NetworkUtils.isNetworkAvailable(MobileQQ.sMobileQQ)) {
                                        }
                                        if (i19 == 0) {
                                        }
                                        h(f16, z17);
                                        return i19;
                                    }
                                }
                            }
                        }
                    } catch (IOException e27) {
                        e = e27;
                    } catch (Exception e28) {
                        e = e28;
                    }
                } catch (IOException e29) {
                    e = e29;
                } catch (Exception e36) {
                    e = e36;
                }
            } catch (IOException e37) {
                e = e37;
                this.f315286m.f315270c = e;
                i19 = ErrorCodeUtil.getErrorCode4IOException(e);
                if (httpResponse != null) {
                    httpResponse.getEntity().consumeContent();
                }
                this.f315281h = i18;
                this.f315282i = (int) (this.f315282i * 1.25d);
                if (i19 != 1830002) {
                }
                if (i19 == 1830001) {
                }
                if (NetworkUtils.isNetworkAvailable(MobileQQ.sMobileQQ)) {
                }
                if (i19 == 0) {
                }
                h(f16, z17);
                return i19;
            } catch (Exception e38) {
                e = e38;
                this.f315286m.f315270c = e;
                if (httpResponse != null) {
                    httpResponse.getEntity().consumeContent();
                }
                i19 = ErrorCode.TRAN_UNKNOWN_EXCEPTION;
                this.f315281h = i18;
                this.f315282i = (int) (this.f315282i * 1.25d);
                if (i19 != 1830002) {
                }
                if (i19 == 1830001) {
                }
                if (NetworkUtils.isNetworkAvailable(MobileQQ.sMobileQQ)) {
                }
                if (i19 == 0) {
                }
                h(f16, z17);
                return i19;
            }
            i26++;
            i27 = i18;
            i18 = 0;
        }
        if (i19 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        h(f16, z17);
        return i19;
    }

    int m() {
        b bVar;
        long j3;
        int i3;
        try {
            URL g16 = g();
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.f315274a.path(), "r");
            try {
                long j16 = this.f315284k;
                int i16 = 0;
                if (j16 > 4294967296L) {
                    bVar = new b(1007, this.f315277d, j16, this.f315276c, 0);
                } else {
                    bVar = new b(1000, this.f315277d, j16, this.f315276c, 0);
                }
                b bVar2 = bVar;
                byte[] bArr = new byte[66560];
                int i17 = 0;
                while (this.f315275b.g()) {
                    try {
                        try {
                            if (this.f315280g <= 0) {
                                int j17 = j(MobileQQ.sMobileQQ);
                                if (j17 < 0) {
                                    c(randomAccessFile);
                                    d();
                                    return ErrorCode.TRAN_NO_NETWORK;
                                }
                                this.f315280g = j17;
                            }
                            long uptimeMillis = SystemClock.uptimeMillis();
                            long j18 = this.f315283j;
                            randomAccessFile.seek(j18);
                            int b16 = bVar2.b();
                            int read = randomAccessFile.read(bArr, b16, this.f315280g);
                            if (read <= 0) {
                                j3 = uptimeMillis;
                                if (this.f315283j < this.f315284k) {
                                    c(randomAccessFile);
                                    d();
                                    return ErrorCode.TRAN_FILE_MODIFIED;
                                }
                            } else {
                                j3 = uptimeMillis;
                            }
                            if (read <= 0 && this.f315283j == this.f315284k) {
                                i3 = i16;
                            } else {
                                int i18 = i17 + 1;
                                bVar2.f(i18);
                                i3 = i16;
                                int l3 = l(bVar2, g16, bArr, b16, read);
                                if (l3 != 0) {
                                    return l3;
                                }
                                if (!this.f315275b.g()) {
                                    c(randomAccessFile);
                                    d();
                                    return ErrorCode.TRAN_USER_CANCELED;
                                }
                                n(bVar2, read);
                                this.f315286m.f315272e += SystemClock.uptimeMillis() - j3;
                                c.a aVar = this.f315286m;
                                long j19 = aVar.f315273f;
                                long j26 = this.f315283j;
                                aVar.f315273f = j19 + (j26 - j18);
                                long j27 = this.f315284k;
                                if (j26 != j27) {
                                    if (j26 > j27) {
                                        c(randomAccessFile);
                                        d();
                                        return ErrorCode.TRAN_OFFSET_IS_WRONG;
                                    }
                                    i17 = i18;
                                    i16 = i3;
                                }
                            }
                            return i3;
                        } catch (IOException e16) {
                            this.f315286m.f315270c = e16;
                            c(randomAccessFile);
                            d();
                            return ErrorCode.TRAN_LOCAL_PERMISSION_DENIED;
                        } catch (Exception e17) {
                            this.f315286m.f315270c = e17;
                            c(randomAccessFile);
                            d();
                            return ErrorCode.TRAN_UNKNOWN_EXCEPTION;
                        }
                    } finally {
                        c(randomAccessFile);
                        d();
                    }
                }
                return ErrorCode.TRAN_USER_CANCELED;
            } catch (IllegalArgumentException e18) {
                this.f315286m.f315270c = e18;
                return ErrorCode.TRAN_INVALID_PARAMETER;
            }
        } catch (FileNotFoundException e19) {
            this.f315286m.f315270c = e19;
            return ErrorCode.TRAN_LOCAL_FILE_NOT_EXIST;
        } catch (MalformedURLException e26) {
            this.f315286m.f315270c = e26;
            return ErrorCode.TRAN_HTTP_INVALID_URL;
        }
    }

    void n(b bVar, int i3) {
        short c16 = bVar.c();
        if (c16 != 0) {
            if (c16 != 1) {
                if (c16 != 2) {
                    return;
                }
            } else {
                long j3 = this.f315284k;
                this.f315283j = j3;
                this.f315275b.h(j3, j3);
                return;
            }
        }
        b(bVar, this.f315283j + i3);
    }
}
