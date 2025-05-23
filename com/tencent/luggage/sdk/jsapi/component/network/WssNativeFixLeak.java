package com.tencent.luggage.sdk.jsapi.component.network;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.sdk.jsapi.component.network.WssNativeFixLeak;
import com.tencent.luggage.wxa.ei.n;
import com.tencent.mm.websocket.libwcwss.WcwssNative;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class WssNativeFixLeak {

    /* renamed from: a, reason: collision with root package name */
    public static final WssNativeFixLeak f120192a = new WssNativeFixLeak();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ProxyReportListener implements WcwssNative.IWcWssReportListener {

        /* renamed from: a, reason: collision with root package name */
        public WcwssNative.IWcWssReportListener f120193a;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a implements n.a {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.ei.n.a
            public final void onDestroy() {
                ProxyReportListener.this.f120193a = null;
            }
        }

        public ProxyReportListener(WcwssNative.IWcWssReportListener iWcWssReportListener, n lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            this.f120193a = iWcWssReportListener;
            lifecycleOwner.b(new a());
        }

        @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener
        public int getNetworkType() {
            WcwssNative.IWcWssReportListener iWcWssReportListener = this.f120193a;
            if (iWcWssReportListener != null) {
                return iWcWssReportListener.getNetworkType();
            }
            return 0;
        }

        @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener
        public void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3) {
            WcwssNative.IWcWssReportListener iWcWssReportListener = this.f120193a;
            if (iWcWssReportListener != null) {
                iWcWssReportListener.onIdKeyStat(iArr, iArr2, iArr3);
            }
        }

        @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener
        public void onKvStat(int i3, String str) {
            WcwssNative.IWcWssReportListener iWcWssReportListener = this.f120193a;
            if (iWcWssReportListener != null) {
                iWcWssReportListener.onKvStat(i3, str);
            }
        }

        public final void a(final LifecycleOwner lifecycleOwner) {
            if (lifecycleOwner == null) {
                return;
            }
            com.tencent.luggage.wxa.rn.a.a(new Function0() { // from class: com.tencent.luggage.sdk.jsapi.component.network.WssNativeFixLeak$ProxyReportListener$injectAppRuntimeLifecycleOwner$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final void a() {
                    Lifecycle lifecycle = LifecycleOwner.this.getLifecycle();
                    final WssNativeFixLeak.ProxyReportListener proxyReportListener = this;
                    lifecycle.addObserver(new LifecycleObserver() { // from class: com.tencent.luggage.sdk.jsapi.component.network.WssNativeFixLeak$ProxyReportListener$injectAppRuntimeLifecycleOwner$1.1
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroyed() {
                            WssNativeFixLeak.ProxyReportListener.this.f120193a = null;
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ProxySocketListener implements WcwssNative.IWcWssWebSocketListener {

        /* renamed from: a, reason: collision with root package name */
        public WcwssNative.IWcWssWebSocketListener f120198a;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a implements n.a {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.ei.n.a
            public final void onDestroy() {
                ProxySocketListener.this.f120198a = null;
            }
        }

        public ProxySocketListener(WcwssNative.IWcWssWebSocketListener iWcWssWebSocketListener, n lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            this.f120198a = iWcWssWebSocketListener;
            lifecycleOwner.b(new a());
        }

        @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener
        public WcwssNative.IWcWssWebSocketListener.BindAndDnsReturn bindSocketToCellularAndDnsByCellular(int i3, String str) {
            WcwssNative.IWcWssWebSocketListener iWcWssWebSocketListener = this.f120198a;
            if (iWcWssWebSocketListener != null) {
                return iWcWssWebSocketListener.bindSocketToCellularAndDnsByCellular(i3, str);
            }
            return null;
        }

        @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener
        public int doCertificateVerify(String str, long j3, String str2, byte[][] bArr) {
            WcwssNative.IWcWssWebSocketListener iWcWssWebSocketListener = this.f120198a;
            if (iWcWssWebSocketListener != null) {
                return iWcWssWebSocketListener.doCertificateVerify(str, j3, str2, bArr);
            }
            return 0;
        }

        @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener
        public void onStateChange(String str, long j3, int i3) {
            WcwssNative.IWcWssWebSocketListener iWcWssWebSocketListener = this.f120198a;
            if (iWcWssWebSocketListener != null) {
                iWcWssWebSocketListener.onStateChange(str, j3, i3);
            }
        }

        public final void a(final LifecycleOwner lifecycleOwner) {
            if (lifecycleOwner == null) {
                return;
            }
            com.tencent.luggage.wxa.rn.a.a(new Function0() { // from class: com.tencent.luggage.sdk.jsapi.component.network.WssNativeFixLeak$ProxySocketListener$injectAppRuntimeLifecycleOwner$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final void a() {
                    Lifecycle lifecycle = LifecycleOwner.this.getLifecycle();
                    final WssNativeFixLeak.ProxySocketListener proxySocketListener = this;
                    lifecycle.addObserver(new LifecycleObserver() { // from class: com.tencent.luggage.sdk.jsapi.component.network.WssNativeFixLeak$ProxySocketListener$injectAppRuntimeLifecycleOwner$1.1
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroyed() {
                            WssNativeFixLeak.ProxySocketListener.this.f120198a = null;
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public static final WcwssNative.IWcWssReportListener a(WcwssNative.IWcWssReportListener iWcWssReportListener, n lifecycleOwner) {
        Intrinsics.checkNotNullParameter(iWcWssReportListener, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        return new ProxyReportListener(iWcWssReportListener, lifecycleOwner);
    }

    public static final WcwssNative.IWcWssWebSocketListener a(WcwssNative.IWcWssWebSocketListener iWcWssWebSocketListener, n lifecycleOwner) {
        Intrinsics.checkNotNullParameter(iWcWssWebSocketListener, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        return new ProxySocketListener(iWcWssWebSocketListener, lifecycleOwner);
    }
}
