package com.tencent.biz.richframework.util;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWTypefaceUtil {
    public static final int RETRY_COUNT = 3;
    private static final String TAG = "RFWTypefaceUtil";
    private static final ConcurrentHashMap<String, Typeface> cache = new ConcurrentHashMap<>();

    public static Typeface getTypeface(Context context, String str) {
        if (!cache.containsKey(str)) {
            for (int i3 = 0; i3 < 3; i3++) {
                try {
                    Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s.ttf", str));
                    cache.put(str, createFromAsset);
                    return createFromAsset;
                } catch (Throwable unused) {
                }
            }
        }
        return cache.get(str);
    }

    public static void preloadTypeface(final String str) {
        if (!cache.containsKey(str)) {
            RFWDownloaderFactory.getDownloader(vq3.a.a()).download(str, new RFWDownloader.RFWDownloadListener() { // from class: com.tencent.biz.richframework.util.RFWTypefaceUtil.3
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
                public /* synthetic */ void dnsEnd(Call call, String str2, List list) {
                    v.i(this, call, str2, list);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void dnsStart(Call call, String str2) {
                    v.j(this, call, str2);
                }

                @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
                public void onRspCallback(boolean z16, String str2) {
                    if (z16) {
                        for (int i3 = 0; i3 < 3; i3++) {
                            try {
                                RFWTypefaceUtil.cache.put(str, Typeface.createFromFile(str2));
                                return;
                            } catch (Throwable unused) {
                            }
                        }
                    }
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
                public void onDownloadProgress(float f16, long j3, long j16) {
                }
            });
        }
    }

    public static void setNumberTypeface(TextView textView, boolean z16) {
        if (textView == null) {
            return;
        }
        if (z16) {
            setNumberTypeface(textView, "https://downv6.qq.com/video_story/qcircle/ttf/qvideo-digit-BoldItalic.ttf");
        } else {
            setNumberTypeface(textView, "https://downv6.qq.com/video_story/qcircle/ttf/qvideo-digit-Bold.ttf");
        }
    }

    public static void setNumberTypeface(final TextView textView, final String str) {
        ConcurrentHashMap<String, Typeface> concurrentHashMap = cache;
        if (!concurrentHashMap.containsKey(str)) {
            RFWDownloaderFactory.getDownloader(vq3.a.a()).download(str, new RFWDownloader.RFWDownloadListener() { // from class: com.tencent.biz.richframework.util.RFWTypefaceUtil.1
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
                public /* synthetic */ void dnsEnd(Call call, String str2, List list) {
                    v.i(this, call, str2, list);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void dnsStart(Call call, String str2) {
                    v.j(this, call, str2);
                }

                @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
                public void onRspCallback(boolean z16, String str2) {
                    if (z16) {
                        for (int i3 = 0; i3 < 3; i3++) {
                            try {
                                final Typeface createFromFile = Typeface.createFromFile(str2);
                                RFWTypefaceUtil.cache.put(str, createFromFile);
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.biz.richframework.util.RFWTypefaceUtil.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        textView.setTypeface(createFromFile);
                                    }
                                });
                                return;
                            } catch (Throwable unused) {
                            }
                        }
                    }
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
                public void onDownloadProgress(float f16, long j3, long j16) {
                }
            });
        } else {
            textView.setTypeface(concurrentHashMap.get(str));
        }
    }

    public static void setNumberTypeface(Paint paint, boolean z16) {
        if (z16) {
            setNumberTypeface(paint, "https://downv6.qq.com/video_story/qcircle/ttf/qvideo-digit-BoldItalic.ttf");
        } else {
            setNumberTypeface(paint, "https://downv6.qq.com/video_story/qcircle/ttf/qvideo-digit-Bold.ttf");
        }
    }

    public static void setNumberTypeface(final Paint paint, final String str) {
        ConcurrentHashMap<String, Typeface> concurrentHashMap = cache;
        if (!concurrentHashMap.containsKey(str)) {
            RFWDownloaderFactory.getDownloader(vq3.a.a()).download(str, new RFWDownloader.RFWDownloadListener() { // from class: com.tencent.biz.richframework.util.RFWTypefaceUtil.2
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
                public /* synthetic */ void dnsEnd(Call call, String str2, List list) {
                    v.i(this, call, str2, list);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void dnsStart(Call call, String str2) {
                    v.j(this, call, str2);
                }

                @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
                public void onRspCallback(boolean z16, String str2) {
                    if (z16) {
                        for (int i3 = 0; i3 < 3; i3++) {
                            try {
                                Typeface createFromFile = Typeface.createFromFile(str2);
                                RFWTypefaceUtil.cache.put(str, createFromFile);
                                paint.setTypeface(createFromFile);
                                return;
                            } catch (Throwable unused) {
                            }
                        }
                    }
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
                public void onDownloadProgress(float f16, long j3, long j16) {
                }
            });
        } else {
            paint.setTypeface(concurrentHashMap.get(str));
        }
    }
}
