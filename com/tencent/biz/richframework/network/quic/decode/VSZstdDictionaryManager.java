package com.tencent.biz.richframework.network.quic.decode;

import android.text.TextUtils;
import com.github.luben.zstd.Zstd;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import vq3.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSZstdDictionaryManager {
    private static VSZstdDictionaryManager INSTANCE = null;
    private static final String TAG = "QUIC-VSZstdDictionaryManager";
    private static final String ZSTD_DICTIONARY_URL = "https://down.qq.com/video_story/qcircle/quic/ref/QDuanDict.zst";
    private byte[] mDecodeZstdDictionaryBytes;
    private b mDownloadStrategy;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnVSZstdDictionaryCallback {
        void onZstdDictionary(byte[] bArr);
    }

    VSZstdDictionaryManager() {
    }

    private byte[] decodeDict(byte[] bArr) {
        try {
            return Zstd.a(bArr, (int) Zstd.c(bArr));
        } catch (Throwable unused) {
            return null;
        }
    }

    private void download(OnVSZstdDictionaryCallback onVSZstdDictionaryCallback) {
        RFWDownloaderFactory.getDownloader(getDownloadStrategy()).download(ZSTD_DICTIONARY_URL, new RFWDownloader.RFWDownloadListener() { // from class: com.tencent.biz.richframework.network.quic.decode.VSZstdDictionaryManager.1
            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void callEnd(Call call) {
                v.a(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void callFailed(Call call, IOException iOException) {
                v.b(this, call, iOException);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void callStart(Call call) {
                v.c(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
                v.d(this, call, inetSocketAddress, proxy, protocol2);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
                v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
                v.f(this, call, inetSocketAddress, proxy);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
                v.g(this, call, connection);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void connectionReleased(Call call, Connection connection) {
                v.h(this, call, connection);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void dnsEnd(Call call, String str, List list) {
                v.i(this, call, str, list);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void dnsStart(Call call, String str) {
                v.j(this, call, str);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void requestBodyEnd(Call call, long j3) {
                v.k(this, call, j3);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void requestBodyStart(Call call) {
                v.l(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
                v.m(this, call, request);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void requestHeadersStart(Call call) {
                v.n(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void responseBodyEnd(Call call, long j3) {
                v.o(this, call, j3);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void responseBodyStart(Call call) {
                v.p(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
                v.q(this, call, response);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void responseHeadersStart(Call call) {
                v.r(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
                v.s(this, call, handshake);
            }

            @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
            public /* synthetic */ void secureConnectStart(Call call) {
                v.t(this, call);
            }

            @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
            public void onRspCallback(boolean z16, String str) {
            }

            @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
            public void onDownloadProgress(float f16, long j3, long j16) {
            }
        });
    }

    private String getDictionaryCallback(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "[getImagePath] url should not be null.");
            return "";
        }
        return RFWDownloaderFactory.getDownloader(getDownloadStrategy()).getDefaultSavePath(str);
    }

    private RFWDownloadStrategy getDownloadStrategy() {
        if (this.mDownloadStrategy == null) {
            this.mDownloadStrategy = new b();
        }
        return this.mDownloadStrategy;
    }

    public static VSZstdDictionaryManager instance() {
        if (INSTANCE == null) {
            synchronized (VSZstdDictionaryManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new VSZstdDictionaryManager();
                }
            }
        }
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadZstdDictionary$0(OnVSZstdDictionaryCallback onVSZstdDictionaryCallback) {
        String dictionaryCallback = getDictionaryCallback(ZSTD_DICTIONARY_URL);
        try {
            if (new File(dictionaryCallback).exists()) {
                notifyFileDownloadFinish(onVSZstdDictionaryCallback, dictionaryCallback);
                return;
            }
            if (!RFWDownloaderFactory.getDownloader(getDownloadStrategy()).isFileDownLoading(ZSTD_DICTIONARY_URL)) {
                download(onVSZstdDictionaryCallback);
            }
            notifyVSZstdDictionaryCallback(onVSZstdDictionaryCallback, null);
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[loadZstdDictionary] ex: ", th5);
        }
    }

    private void notifyFileDownloadFinish(OnVSZstdDictionaryCallback onVSZstdDictionaryCallback, String str) {
        if (TextUtils.isEmpty(str)) {
            notifyVSZstdDictionaryCallback(onVSZstdDictionaryCallback, null);
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[(int) new File(str).length()];
            fileInputStream.read(bArr);
            notifyVSZstdDictionaryCallback(onVSZstdDictionaryCallback, decodeDict(bArr));
        } catch (Throwable th5) {
            notifyVSZstdDictionaryCallback(onVSZstdDictionaryCallback, null);
            QLog.e(TAG, 1, "[notifyFileDownload] ex: ", th5);
        }
    }

    private void notifyVSZstdDictionaryCallback(OnVSZstdDictionaryCallback onVSZstdDictionaryCallback, byte[] bArr) {
        if (onVSZstdDictionaryCallback == null) {
            QLog.d(TAG, 1, "[notifyVSZstdDictionaryCallback] callback should not be null.");
            return;
        }
        try {
            this.mDecodeZstdDictionaryBytes = bArr;
            onVSZstdDictionaryCallback.onZstdDictionary(bArr);
        } catch (Throwable unused) {
            onVSZstdDictionaryCallback.onZstdDictionary(null);
        }
    }

    public void loadZstdDictionary(final OnVSZstdDictionaryCallback onVSZstdDictionaryCallback) {
        if (onVSZstdDictionaryCallback == null) {
            QLog.w(TAG, 1, "[loadZstdDictionary] callback should not be null.");
            return;
        }
        byte[] bArr = this.mDecodeZstdDictionaryBytes;
        if (bArr != null && bArr.length > 0) {
            notifyVSZstdDictionaryCallback(onVSZstdDictionaryCallback, bArr);
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.network.quic.decode.a
                @Override // java.lang.Runnable
                public final void run() {
                    VSZstdDictionaryManager.this.lambda$loadZstdDictionary$0(onVSZstdDictionaryCallback);
                }
            });
        }
    }
}
