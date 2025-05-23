package com.tencent.libra.download;

import android.net.ConnectivityManager;
import android.net.Network;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWConnectivityCallbackRegister;
import com.tencent.libra.download.ILibraDownloader;
import com.tencent.libra.download.LightQuicDownloaderWrapper;
import com.tencent.libra.request.Option;
import com.tencent.libra.strategy.ILibraBaseStrategy;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0003\u0010\u0016\u0003B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\fR\u001b\u0010\u0014\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/libra/download/LightQuicDownloaderWrapper;", "", "", "c", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/libra/download/ILibraDownloader$PicDownLoadListener;", "downloadLister", "Lcom/tencent/libra/download/ILibraDownloader;", "fallbackDownloader", "", h.F, "", "g", "i", "Lcom/tencent/libra/download/LightQuicDownloaderWrapper$b;", "a", "Lkotlin/Lazy;", "d", "()Lcom/tencent/libra/download/LightQuicDownloaderWrapper$b;", "networkCallback", "Lcom/tencent/libra/download/RFWQuicDownloader;", "b", "e", "()Lcom/tencent/libra/download/RFWQuicDownloader;", "quicDownloader", "Lcom/tencent/libra/strategy/ILibraBaseStrategy;", "Lcom/tencent/libra/strategy/ILibraBaseStrategy;", "f", "()Lcom/tencent/libra/strategy/ILibraBaseStrategy;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "<init>", "(Lcom/tencent/libra/strategy/ILibraBaseStrategy;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LightQuicDownloaderWrapper {

    /* renamed from: d, reason: collision with root package name */
    private static volatile int f118651d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy networkCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy quicDownloader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ILibraBaseStrategy strategy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/libra/download/LightQuicDownloaderWrapper$b;", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "", "onAvailable", "<init>", "()V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NotNull Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            RFWLog.i("LightQuicDownloaderWrapper", RFWLog.USR, "Network available update quicTotalFailedCount");
            LightQuicDownloaderWrapper.f118651d = 0;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/libra/download/LightQuicDownloaderWrapper$c;", "Lcom/tencent/libra/download/ILibraDownloader$PicDownLoadListener;", "", "success", "", "retCode", "", "onResult", "Lcom/tencent/libra/request/Option;", "a", "Lcom/tencent/libra/request/Option;", "option", "b", "Lcom/tencent/libra/download/ILibraDownloader$PicDownLoadListener;", "realListener", "Lcom/tencent/libra/download/ILibraDownloader;", "c", "Lcom/tencent/libra/download/ILibraDownloader;", "fallbackDownloader", "<init>", "(Lcom/tencent/libra/request/Option;Lcom/tencent/libra/download/ILibraDownloader$PicDownLoadListener;Lcom/tencent/libra/download/ILibraDownloader;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class c extends ILibraDownloader.PicDownLoadListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Option option;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final ILibraDownloader.PicDownLoadListener realListener;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final ILibraDownloader fallbackDownloader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull Option option, @NotNull ILibraDownloader.PicDownLoadListener realListener, @NotNull ILibraDownloader fallbackDownloader) {
            super(option);
            Intrinsics.checkNotNullParameter(option, "option");
            Intrinsics.checkNotNullParameter(realListener, "realListener");
            Intrinsics.checkNotNullParameter(fallbackDownloader, "fallbackDownloader");
            this.option = option;
            this.realListener = realListener;
            this.fallbackDownloader = fallbackDownloader;
        }

        @Override // com.tencent.libra.download.ILibraDownloader.PicDownLoadListener
        public void onResult(boolean success, int retCode) {
            if (success) {
                com.tencent.libra.util.a.f118813a.o(this.option, true);
                this.realListener.onResult(true, retCode);
            } else {
                com.tencent.libra.util.a.f118813a.s(this.option, 1);
                LightQuicDownloaderWrapper.f118651d++;
                this.fallbackDownloader.downLoad(this.option, this.realListener);
            }
        }
    }

    public LightQuicDownloaderWrapper(@NotNull ILibraBaseStrategy strategy) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.strategy = strategy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.libra.download.LightQuicDownloaderWrapper$networkCallback$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LightQuicDownloaderWrapper.b invoke() {
                return new LightQuicDownloaderWrapper.b();
            }
        });
        this.networkCallback = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RFWQuicDownloader>() { // from class: com.tencent.libra.download.LightQuicDownloaderWrapper$quicDownloader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RFWQuicDownloader invoke() {
                RFWConnectivityCallbackRegister.INSTANCE.registerNetworkCallback("LightQuicDownloaderWrapper", LightQuicDownloaderWrapper.this.d());
                return new RFWQuicDownloader(new LibraDns(LightQuicDownloaderWrapper.this.getStrategy()), null, null, null, 14, null);
            }
        });
        this.quicDownloader = lazy2;
    }

    private final int c() {
        return RFWConfig.getConfigValue("quic_global_failed_limit", 6);
    }

    private final RFWQuicDownloader e() {
        return (RFWQuicDownloader) this.quicDownloader.getValue();
    }

    @NotNull
    public final b d() {
        return (b) this.networkCallback.getValue();
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final ILibraBaseStrategy getStrategy() {
        return this.strategy;
    }

    public final void g(@NotNull Option option) {
        Intrinsics.checkNotNullParameter(option, "option");
        e().cancel(option);
    }

    public final boolean h(@NotNull Option option, @NotNull ILibraDownloader.PicDownLoadListener downloadLister, @NotNull ILibraDownloader fallbackDownloader) {
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(downloadLister, "downloadLister");
        Intrinsics.checkNotNullParameter(fallbackDownloader, "fallbackDownloader");
        if (!RFWQuicDownloader.INSTANCE.a(option) || f118651d >= c()) {
            return false;
        }
        e().downLoad(option, new c(option, downloadLister, fallbackDownloader));
        return true;
    }

    public final void i() {
        RFWConnectivityCallbackRegister.INSTANCE.unregisterNetworkCallback("LightQuicDownloaderWrapper", d());
    }
}
