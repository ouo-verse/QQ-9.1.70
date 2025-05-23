package com.epicgames.ue4.network;

import android.os.Handler;
import com.epicgames.ue4.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class NetworkChangedManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f32592a = {"https://example.com/", "https://google.com/", "https://www.samsung.com/"};

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f32593b = new Logger("UE4", "NetworkChangedManager");

    /* compiled from: P */
    /* renamed from: com.epicgames.ue4.network.NetworkChangedManager$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ NetworkChangedManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            NetworkChangedManager.f32593b.verbose("Attempting to check for network connectivity again.");
            NetworkChangedManager.f(null);
            NetworkChangedManager.g(null, false);
            NetworkChangedManager.e(null);
        }
    }

    /* compiled from: P */
    /* renamed from: com.epicgames.ue4.network.NetworkChangedManager$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ExecutorService f32594d;
        final /* synthetic */ NetworkChangedManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            NetworkChangedManager.f32593b.verbose("Unable to connect to: " + NetworkChangedManager.h(null));
            NetworkChangedManager.i(null, false);
            this.f32594d.shutdownNow();
            NetworkChangedManager.j(null, ConnectivityState.NO_CONNECTION);
            NetworkChangedManager.k(null);
        }
    }

    /* compiled from: P */
    /* renamed from: com.epicgames.ue4.network.NetworkChangedManager$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f32595d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ExecutorService f32596e;
        final /* synthetic */ NetworkChangedManager this$0;

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00d9, code lost:
        
            if (r4 == null) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00b8, code lost:
        
            com.epicgames.ue4.network.NetworkChangedManager.b(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b5, code lost:
        
            r4.disconnect();
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00b3, code lost:
        
            if (r4 == null) goto L25;
         */
        /* JADX WARN: Removed duplicated region for block: B:9:0x00e2  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            HttpURLConnection httpURLConnection;
            Exception e16;
            HttpURLConnection httpURLConnection2 = null;
            int i3 = 0;
            while (true) {
                if (i3 < NetworkChangedManager.f32592a.length) {
                    try {
                        NetworkChangedManager.f32593b.verbose("Verifying internet connection with host: " + NetworkChangedManager.h(null));
                        httpURLConnection = (HttpURLConnection) new URL(NetworkChangedManager.h(null)).openConnection();
                    } catch (MalformedURLException unused) {
                    } catch (IOException unused2) {
                    } catch (Exception e17) {
                        httpURLConnection = httpURLConnection2;
                        e16 = e17;
                    }
                    try {
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestMethod("HEAD");
                        httpURLConnection.setConnectTimeout(2000);
                        httpURLConnection.setReadTimeout(2000);
                        httpURLConnection.getInputStream().close();
                        httpURLConnection.disconnect();
                        z16 = true;
                        break;
                    } catch (MalformedURLException unused3) {
                        httpURLConnection2 = httpURLConnection;
                        NetworkChangedManager.f32593b.error("Malformed URL, this should never happen. Please fix, url: " + NetworkChangedManager.h(null));
                    } catch (IOException unused4) {
                        httpURLConnection2 = httpURLConnection;
                        try {
                            NetworkChangedManager.f32593b.verbose("Unable to connect to: " + NetworkChangedManager.h(null));
                        } catch (Throwable th5) {
                            th = th5;
                            if (httpURLConnection2 != null) {
                            }
                            NetworkChangedManager.b(null);
                            throw th;
                        }
                    } catch (Exception e18) {
                        e16 = e18;
                        try {
                            NetworkChangedManager.f32593b.verbose("Unable to connect to: " + NetworkChangedManager.h(null) + ", exception: " + e16.toString());
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            NetworkChangedManager.b(null);
                            httpURLConnection2 = httpURLConnection;
                            i3++;
                        } catch (Throwable th6) {
                            th = th6;
                            httpURLConnection2 = httpURLConnection;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            NetworkChangedManager.b(null);
                            throw th;
                        }
                    }
                } else {
                    z16 = false;
                    break;
                }
                i3++;
            }
            NetworkChangedManager.c(null).removeCallbacks(this.f32595d);
            NetworkChangedManager.i(null, false);
            if (z16) {
                NetworkChangedManager.j(null, ConnectivityState.CONNECTION_AVAILABLE);
            } else {
                NetworkChangedManager.j(null, ConnectivityState.NO_CONNECTION);
                NetworkChangedManager.k(null);
            }
            NetworkChangedManager.f32593b.verbose("Full network check complete. State: " + NetworkChangedManager.d(null));
            this.f32596e.shutdownNow();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private enum ConnectivityState {
        CONNECTION_AVAILABLE,
        NO_CONNECTION
    }

    static /* synthetic */ void b(NetworkChangedManager networkChangedManager) {
        throw null;
    }

    static /* synthetic */ Handler c(NetworkChangedManager networkChangedManager) {
        throw null;
    }

    static /* synthetic */ ConnectivityState d(NetworkChangedManager networkChangedManager) {
        throw null;
    }

    static /* synthetic */ void e(NetworkChangedManager networkChangedManager) {
        throw null;
    }

    static /* synthetic */ int f(NetworkChangedManager networkChangedManager) {
        throw null;
    }

    static /* synthetic */ boolean g(NetworkChangedManager networkChangedManager, boolean z16) {
        throw null;
    }

    static /* synthetic */ String h(NetworkChangedManager networkChangedManager) {
        throw null;
    }

    static /* synthetic */ boolean i(NetworkChangedManager networkChangedManager, boolean z16) {
        throw null;
    }

    static /* synthetic */ void j(NetworkChangedManager networkChangedManager, ConnectivityState connectivityState) {
        throw null;
    }

    static /* synthetic */ void k(NetworkChangedManager networkChangedManager) {
        throw null;
    }
}
