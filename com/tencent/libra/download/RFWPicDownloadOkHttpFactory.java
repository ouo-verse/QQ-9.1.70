package com.tencent.libra.download;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.LibraLogUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* loaded from: classes7.dex */
public class RFWPicDownloadOkHttpFactory {
    public static final int DEFAULT_CONNECT_POOL = 5;
    public static final int DEFAULT_MAX_REQUEST = 64;
    public static final int DEFAULT_MAX_REQUEST_PEER_HOST = 5;
    public static final long ONE_MINUTES = 60;
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("RFWPicDownloadOkHttpFactory");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a extends EventListener {
        a() {
        }

        @Override // okhttp3.EventListener
        public void connectEnd(@NonNull Call call, @NonNull InetSocketAddress inetSocketAddress, @NonNull Proxy proxy, @Nullable Protocol protocol2) {
            super.connectEnd(call, inetSocketAddress, proxy, protocol2);
            RFWPicDownloadOkHttpFactory.log(call, RFWStringBuilderUtils.getString("[connectEnd] url=", call.request().url(), ",inetSocketAddress=", inetSocketAddress, ",proxy=", proxy));
            b.f118670d.d(call, inetSocketAddress);
        }

        @Override // okhttp3.EventListener
        public void connectFailed(@NonNull Call call, @NonNull InetSocketAddress inetSocketAddress, @NonNull Proxy proxy, Protocol protocol2, @NonNull IOException iOException) {
            super.connectFailed(call, inetSocketAddress, proxy, protocol2, iOException);
            RFWPicDownloadOkHttpFactory.log(call, RFWStringBuilderUtils.getString("[connectFailed] url=", call.request().url(), ",inetSocketAddress=", inetSocketAddress, ",IOException=", iOException));
            b.f118670d.b(call, inetSocketAddress, iOException);
        }

        @Override // okhttp3.EventListener
        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            RFWPicDownloadOkHttpFactory.log(call, RFWStringBuilderUtils.getString("[connectStart] url=", call.request().url(), ",inetSocketAddress=", inetSocketAddress, ",proxy=", proxy));
            Option option = (Option) call.request().tag(Option.class);
            if (option != null) {
                com.tencent.libra.util.a.f118813a.z(option, inetSocketAddress.getAddress().getHostAddress());
            }
            b.f118670d.c(call, inetSocketAddress);
        }

        @Override // okhttp3.EventListener
        public void dnsEnd(Call call, String str, List<InetAddress> list) {
            RFWPicDownloadOkHttpFactory.log(call, RFWStringBuilderUtils.getString("[dnsEnd] url=", call.request().url(), ",domainName=", str, ",inetAddressList=", list));
        }
    }

    public static OkHttpClient createDeFaultOKHttpClient() {
        return createOkHttpClient(5, 64, 5, new ArrayList(), new ArrayList(), null);
    }

    public static OkHttpClient createOkHttpClient(int i3, int i16, int i17, List<? extends Interceptor> list, List<? extends Interceptor> list2, @Nullable Dns dns) {
        ConnectionPool connectionPool = new ConnectionPool(i3, 60L, TimeUnit.SECONDS);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(i16);
        dispatcher.setMaxRequestsPerHost(i17);
        OkHttpClient.Builder eventListener = new OkHttpClient().newBuilder().dispatcher(dispatcher).connectionPool(connectionPool).protocols(Arrays.asList(Protocol.HTTP_1_1)).retryOnConnectionFailure(true).eventListener(new a());
        if (list != null && !list.isEmpty()) {
            Iterator<? extends Interceptor> it = list.iterator();
            while (it.hasNext()) {
                eventListener.addInterceptor(it.next());
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            Iterator<? extends Interceptor> it5 = list2.iterator();
            while (it5.hasNext()) {
                eventListener.addNetworkInterceptor(it5.next());
            }
        }
        if (dns != null) {
            eventListener.dns(dns);
        }
        return eventListener.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(Call call, String str) {
        Option option = (Option) call.request().tag(Option.class);
        if (option != null) {
            LibraLogUtil.INSTANCE.i(TAG, RFWLog.CLR, option, str);
        } else {
            RFWLog.d(TAG, RFWLog.CLR, str);
        }
    }
}
