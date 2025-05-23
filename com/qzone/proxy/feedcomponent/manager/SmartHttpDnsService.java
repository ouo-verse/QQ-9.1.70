package com.qzone.proxy.feedcomponent.manager;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.oskplayer.service.DNSService;
import com.tencent.oskplayer.util.PlayerUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SmartHttpDnsService implements DNSService, NetworkState.NetworkStateListener {

    /* renamed from: f, reason: collision with root package name */
    private static String[] f50193f = {"182.254.116.117", "182.254.118.119"};

    /* renamed from: h, reason: collision with root package name */
    private static volatile String f50194h = "";

    /* renamed from: d, reason: collision with root package name */
    private int f50195d;

    /* renamed from: e, reason: collision with root package name */
    private LruCache<String, b> f50196e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class DnsResolver implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private String f50199f;

        /* renamed from: e, reason: collision with root package name */
        private int f50198e = 0;

        /* renamed from: d, reason: collision with root package name */
        private String[] f50197d = (String[]) SmartHttpDnsService.f50193f.clone();

        public DnsResolver(String str) {
            this.f50199f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            HttpURLConnection httpURLConnection;
            ArrayList arrayList = null;
            String str = "";
            HttpURLConnection httpURLConnection2 = null;
            do {
                try {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("http://");
                    String[] strArr = this.f50197d;
                    int i16 = this.f50198e;
                    this.f50198e = i16 + 1;
                    sb5.append(strArr[i16]);
                    sb5.append("/d?dn=");
                    sb5.append(this.f50199f);
                    sb5.append("&ttl=1");
                    URL url = new URL(sb5.toString());
                    try {
                        try {
                            httpURLConnection = (HttpURLConnection) url.openConnection();
                        } catch (Exception unused) {
                            httpURLConnection2 = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                    try {
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.connect();
                        if (httpURLConnection.getContentLength() > 0 && httpURLConnection.getResponseCode() == 200) {
                            StringBuilder sb6 = new StringBuilder();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                } else {
                                    sb6.append(readLine);
                                }
                            }
                            httpURLConnection.disconnect();
                            str = sb6.toString();
                        }
                        SmartHttpDnsService.f50194h = this.f50197d[this.f50198e];
                        httpURLConnection.disconnect();
                        httpURLConnection2 = httpURLConnection;
                        if (httpURLConnection2 != null) {
                            break;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        httpURLConnection2 = httpURLConnection;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (MalformedURLException e16) {
                    com.qzone.proxy.feedcomponent.util.j.f("HttpDnsService", "httpdns failed " + e16.toString() + ",hostname=" + this.f50199f);
                    return;
                }
            } while (this.f50198e < this.f50197d.length);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                String[] split = str.split(",");
                int intValue = split.length > 1 ? Integer.valueOf(split[1]).intValue() : 300;
                String[] split2 = split[0].split(";");
                if (split2.length > 0) {
                    for (String str2 : split2) {
                        if (PlayerUtils.isIPV4Address(str2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(str2);
                        }
                    }
                }
                if (arrayList != null) {
                    SmartHttpDnsService.this.f50196e.put(this.f50199f, new b(arrayList, intValue));
                }
            } catch (Exception e17) {
                com.qzone.proxy.feedcomponent.util.j.f("HttpDnsService", "httpdns failed " + e17.toString() + ",hostname=" + this.f50199f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements ThreadExcutor.IThreadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f50203d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f50204e;

        a(String str, CountDownLatch countDownLatch) {
            this.f50203d = str;
            this.f50204e = countDownLatch;
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onAdded() {
            com.qzone.proxy.feedcomponent.util.j.a("HttpDnsService", 4, "onAdded " + this.f50203d);
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPostRun() {
            com.qzone.proxy.feedcomponent.util.j.f("HttpDnsService", "onPostRun " + this.f50203d);
            this.f50204e.countDown();
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPreRun() {
            com.qzone.proxy.feedcomponent.util.j.f("HttpDnsService", "onPreRun " + this.f50203d);
        }
    }

    public SmartHttpDnsService() {
        this(10);
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SMART_DNSSERVICE, QzoneConfig.DEFAULT_SMART_DNSSERVICE);
        f50193f = config.split("\\|");
        com.qzone.proxy.feedcomponent.util.j.f("HttpDnsService", "smartHttpDNSServer=" + config);
    }

    public static boolean d() {
        String str;
        if (!TextUtils.isEmpty(f50194h)) {
            str = f50194h;
        } else {
            str = f50193f[0];
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        NetProbeRunnable netProbeRunnable = new NetProbeRunnable(str);
        ThreadManagerV2.postImmediately(netProbeRunnable, null, false);
        try {
            countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        return netProbeRunnable.e();
    }

    private void e() {
        for (String str : this.f50196e.snapshot().keySet()) {
            com.qzone.proxy.feedcomponent.util.j.f("HttpDnsService", "refreshAll " + str);
            ThreadManagerV2.post(new DnsResolver(str), 5, null, true);
        }
    }

    @Override // com.tencent.oskplayer.service.DNSService
    public String fastResolve(String str) {
        b bVar = this.f50196e.get(str);
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // com.tencent.oskplayer.service.DNSService
    public boolean isNetReachable() {
        return d();
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public synchronized void onNetworkConnect(boolean z16) {
        com.qzone.proxy.feedcomponent.util.j.f("HttpDnsService", "onNetworkConnect networkchange start refresh DNS isConnected" + z16);
        if (z16 && NetworkState.getNetworkType() != this.f50195d) {
            com.qzone.proxy.feedcomponent.util.j.f("HttpDnsService", "onNetworkConnect refreshAll");
            e();
        }
    }

    @Override // com.tencent.oskplayer.service.DNSService
    public String resolve(String str, long j3, TimeUnit timeUnit) {
        if (this.f50196e.get(str) == null) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ThreadManagerV2.post(new DnsResolver(str), 5, new a(str, countDownLatch), true);
            if (j3 > 0) {
                try {
                    countDownLatch.await(j3, timeUnit);
                } catch (InterruptedException e16) {
                    com.qzone.proxy.feedcomponent.util.j.i("HttpDnsService", "InterruptedException when resolve " + str + e16);
                }
            } else {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e17) {
                    com.qzone.proxy.feedcomponent.util.j.i("HttpDnsService", "InterruptedException when resolve " + str + e17);
                }
            }
        }
        return fastResolve(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class NetProbeRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        String f50200d;

        /* renamed from: e, reason: collision with root package name */
        int f50201e = 80;

        /* renamed from: f, reason: collision with root package name */
        boolean f50202f = false;

        public NetProbeRunnable(String str) {
            this.f50200d = str;
        }

        public boolean e() {
            return this.f50202f;
        }

        @Override // java.lang.Runnable
        public void run() {
            SocketChannel socketChannel = null;
            try {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f50200d, this.f50201e);
                socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(true);
                this.f50202f = socketChannel.connect(inetSocketAddress);
            } catch (Throwable th5) {
                try {
                    com.qzone.proxy.feedcomponent.util.j.a("HttpDnsService", 1, "NetProbeRunnable to " + this.f50200d + " failed. " + th5.toString());
                    if (socketChannel == null) {
                        return;
                    }
                } catch (Throwable th6) {
                    if (socketChannel != null) {
                        try {
                            socketChannel.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th6;
                }
            }
            try {
                socketChannel.close();
            } catch (Exception unused2) {
            }
        }
    }

    public SmartHttpDnsService(int i3) {
        this.f50195d = 0;
        NetworkState.addListener(this);
        this.f50196e = new LruCache<>(i3);
        this.f50195d = NetworkState.getNetworkType();
    }

    @Override // com.tencent.oskplayer.service.DNSService
    public String resolve(String str) {
        return resolve(str, 0L, TimeUnit.SECONDS);
    }
}
