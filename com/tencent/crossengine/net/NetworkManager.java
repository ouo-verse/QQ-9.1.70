package com.tencent.crossengine.net;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
abstract class NetworkManager {
    private static NetworkManager mManager;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class Callback {
        public static final int HTTP_VERSION_1 = 1;
        public static final int HTTP_VERSION_1_1 = 2;
        public static final int HTTP_VERSION_2 = 3;
        public static final int HTTP_VERSION_3 = 4;
        private final long mNativeInstance;

        private static native void nativeFinalize(long j3);

        private static native void nativeOnCancel(long j3);

        private static native void nativeOnError(long j3, String str);

        private static native void nativeOnHeader(long j3, String[] strArr);

        private static native void nativeOnProgress(long j3, long j16, long j17, long j18, long j19);

        private static native void nativeOnResponse(long j3, String str, int i3, String[] strArr, int i16);

        private static native long nativeWriteResponse(long j3, byte[] bArr, int i3);

        protected void finalize() throws Throwable {
            super.finalize();
            nativeFinalize(this.mNativeInstance);
        }

        public void onCancel() {
            nativeOnCancel(this.mNativeInstance);
        }

        public void onError(String str) {
            nativeOnError(this.mNativeInstance, str);
        }

        public void onHeader(List<Pair<String, String>> list) {
            nativeOnHeader(this.mNativeInstance, NetworkManager.convertHeader(list));
        }

        public void onResponse(String str, int i3, List<Pair<String, String>> list, int i16) {
            nativeOnResponse(this.mNativeInstance, str, i3, NetworkManager.convertHeader(list), i16);
        }

        public long writeResponseContent(byte[] bArr, int i3) {
            return nativeWriteResponse(this.mNativeInstance, bArr, i3);
        }

        Callback(long j3) {
            this.mNativeInstance = j3;
        }

        public void onProgress(long j3, long j16, long j17, long j18) {
            nativeOnProgress(this.mNativeInstance, j3, j16, j17, j18);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface HttpRequest {
        void cancel();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class HttpRequestData {
        public static final int AUTU_BAISC = 1;
        public static final int AUTU_DIGEST = 2;
        public static final int AUTU_NEGOTIATE = 3;
        public static final int AUTU_NTLM = 4;
        public static final int HTTP_METHOD_GET = 0;
        public static final int HTTP_METHOD_POST = 1;
        public int authMethod;
        public String authPass;
        public String authUser;
        public Callback callback;
        public long connectionTimeout;
        public boolean followRedirect;
        public int maxRedirects;
        public int method;
        public String postBody;
        public String proxyPass;
        public String proxyUrl;
        public String proxyUser;
        public String referrer;
        public long timeout;
        public String url;
        public String userAgent;
        public final List<Pair<String, String>> cookies = new ArrayList();
        public final List<Pair<String, String>> header = new ArrayList();
        public final List<Object> multiParts = new ArrayList();

        private void addMultiPartData(String str, String str2, byte[] bArr) {
            b bVar = new b();
            bVar.f100480a = str;
            bVar.f100481b = str2;
            bVar.f100482c = bArr;
            this.multiParts.add(bVar);
        }

        private void addMultiPartFile(String str, String str2, String str3, String str4) {
            c cVar = new c();
            cVar.f100483a = str;
            cVar.f100484b = str2;
            cVar.f100485c = str3;
            cVar.f100486d = str4;
            this.multiParts.add(cVar);
        }

        private void addMultiPartString(String str, String str2, String str3) {
            d dVar = new d();
            dVar.f100487a = str;
            dVar.f100488b = str2;
            dVar.f100489c = str3;
            this.multiParts.add(dVar);
        }

        private static void addPairList(List<Pair<String, String>> list, String str, String str2) {
            list.add(new Pair<>(str, str2));
        }

        private void setCallback(long j3) {
            this.callback = new Callback(j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface WebSocket {
        void close(int i3, String str);

        void sendMessage(String str);

        void sendMessage(byte[] bArr, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class WebSocketDelegate {
        private final long mNativeInstance;

        private static native void nativeOnClose(long j3, int i3, String str);

        private static native void nativeOnError(long j3, String str);

        private static native void nativeOnMessage(long j3, String str);

        private static native void nativeOnMessageBinary(long j3, byte[] bArr, int i3);

        private static native void nativeOnOpen(long j3, String[] strArr);

        public void onClose(int i3, String str) {
            nativeOnClose(this.mNativeInstance, i3, str);
        }

        public void onError(String str) {
            nativeOnError(this.mNativeInstance, str);
        }

        public void onMessage(String str) {
            nativeOnMessage(this.mNativeInstance, str);
        }

        public void onOpen(List<Pair<String, String>> list) {
            nativeOnOpen(this.mNativeInstance, NetworkManager.convertHeader(list));
        }

        WebSocketDelegate(long j3) {
            this.mNativeInstance = j3;
        }

        public void onMessage(byte[] bArr, int i3) {
            nativeOnMessageBinary(this.mNativeInstance, bArr, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class WebSocketRequestData {
        public WebSocketDelegate delegate;
        public final List<Pair<String, String>> header = new ArrayList();
        public final List<String> protocols = new ArrayList();
        public long timeout;
        public String url;
        public String userAgent;

        private void addProtocol(String str) {
            this.protocols.add(str);
        }

        private void setDelegate(long j3) {
            this.delegate = new WebSocketDelegate(j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        String f100480a;

        /* renamed from: b, reason: collision with root package name */
        String f100481b;

        /* renamed from: c, reason: collision with root package name */
        byte[] f100482c;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        String f100483a;

        /* renamed from: b, reason: collision with root package name */
        String f100484b;

        /* renamed from: c, reason: collision with root package name */
        String f100485c;

        /* renamed from: d, reason: collision with root package name */
        String f100486d;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        String f100487a;

        /* renamed from: b, reason: collision with root package name */
        String f100488b;

        /* renamed from: c, reason: collision with root package name */
        String f100489c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] convertHeader(List<Pair<String, String>> list) {
        String[] strArr = new String[list.size() * 2];
        for (int i3 = 0; i3 < list.size(); i3++) {
            int i16 = i3 * 2;
            strArr[i16] = (String) list.get(i3).first;
            strArr[i16 + 1] = (String) list.get(i3).second;
        }
        return strArr;
    }

    private static synchronized NetworkManager getManager() {
        NetworkManager networkManager;
        synchronized (NetworkManager.class) {
            if (mManager == null) {
                mManager = new com.tencent.crossengine.net.a();
            }
            networkManager = mManager;
        }
        return networkManager;
    }

    public static synchronized void setManager(NetworkManager networkManager) {
        synchronized (NetworkManager.class) {
            mManager = networkManager;
        }
    }

    public abstract HttpRequest performHttpRequest(HttpRequestData httpRequestData);

    public abstract WebSocket performWebSocketRequest(WebSocketRequestData webSocketRequestData);
}
