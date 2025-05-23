package com.tencent.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import cooperation.qzone.QzoneIPCModule;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 &2\u00020\u0001:\u0004%&'(B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\fJ\u0006\u0010\u001f\u001a\u00020\u0010J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0017H\u0002J\u0010\u0010$\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/tencent/mars/comm/MultiNetLinkWaysUtil;", "", "()V", "kBindFail", "", "kDnsFail", "kNoCellularNetwork", "kSuccess", "mLock", "Ljava/lang/Object;", "mMobileNetId", "mMobileNetwork", "Landroid/net/Network;", "mMobileNetworkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "activeMobileNetwork", "", "context", "Landroid/content/Context;", "bindSocketToCellularAndDnsByCellular", "Lcom/tencent/mars/comm/MultiNetLinkWaysUtil$BindAndDnsReturnKt;", "socketFd", "hostDomain", "", "bindSocketToMobile", "", "bindSocketToMobileImpl", "delayUnregister", "negativeMobileNetwork", "onMobileNetworkReady", "network", "onMobileUnAvailable", "reflectCallBind", "resolveHostByCellular", "resolveHostByCellularImpl", "host", "syncActiveMobileNetwork", "BindAndDnsReturnKt", "Companion", "DelayUnregister", "MobileNetworkCallback", "wechat-commons-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class MultiNetLinkWaysUtil {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "MultiNetLinkWaysUtil";

    @Nullable
    private static MultiNetLinkWaysUtil mInstance;
    private final int kBindFail;
    private final int kDnsFail;
    private final int kNoCellularNetwork;
    private final int kSuccess;

    @NotNull
    private Object mLock;
    private int mMobileNetId;

    @Nullable
    private Network mMobileNetwork;

    @Nullable
    private ConnectivityManager.NetworkCallback mMobileNetworkCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mars/comm/MultiNetLinkWaysUtil$BindAndDnsReturnKt;", "", "_hostIpStr", "", "_resultCode", "", "(Ljava/lang/String;I)V", "hostIpStr", "getHostIpStr", "()Ljava/lang/String;", QzoneIPCModule.RESULT_CODE, "getResultCode", "()I", "wechat-commons-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class BindAndDnsReturnKt {
        static IPatchRedirector $redirector_;

        @NotNull
        private final String hostIpStr;
        private final int resultCode;

        public BindAndDnsReturnKt(@NotNull String _hostIpStr, int i3) {
            Intrinsics.checkNotNullParameter(_hostIpStr, "_hostIpStr");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) _hostIpStr, i3);
            } else {
                this.resultCode = i3;
                this.hostIpStr = _hostIpStr;
            }
        }

        @NotNull
        public final String getHostIpStr() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.hostIpStr;
        }

        public final int getResultCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.resultCode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mars/comm/MultiNetLinkWaysUtil$Companion;", "", "()V", "TAG", "", "mInstance", "Lcom/tencent/mars/comm/MultiNetLinkWaysUtil;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "wechat-commons-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @NotNull
        public final MultiNetLinkWaysUtil instance() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MultiNetLinkWaysUtil) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            if (MultiNetLinkWaysUtil.mInstance == null) {
                MultiNetLinkWaysUtil.mInstance = new MultiNetLinkWaysUtil(null);
            }
            MultiNetLinkWaysUtil multiNetLinkWaysUtil = MultiNetLinkWaysUtil.mInstance;
            Intrinsics.checkNotNull(multiNetLinkWaysUtil);
            return multiNetLinkWaysUtil;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mars/comm/MultiNetLinkWaysUtil$DelayUnregister;", "Ljava/util/TimerTask;", "receiver", "Lcom/tencent/mars/comm/MultiNetLinkWaysUtil;", "context", "Landroid/content/Context;", "(Lcom/tencent/mars/comm/MultiNetLinkWaysUtil;Landroid/content/Context;)V", "()V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mReceiver", "getMReceiver", "()Lcom/tencent/mars/comm/MultiNetLinkWaysUtil;", "setMReceiver", "(Lcom/tencent/mars/comm/MultiNetLinkWaysUtil;)V", TencentLocation.RUN_MODE, "", "wechat-commons-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class DelayUnregister extends TimerTask {
        static IPatchRedirector $redirector_;

        @Nullable
        private Context mContext;

        @Nullable
        private MultiNetLinkWaysUtil mReceiver;

        public DelayUnregister() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Nullable
        public final Context getMContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Context) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.mContext;
        }

        @Nullable
        public final MultiNetLinkWaysUtil getMReceiver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MultiNetLinkWaysUtil) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.mReceiver;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            MultiNetLinkWaysUtil multiNetLinkWaysUtil = this.mReceiver;
            if (multiNetLinkWaysUtil != null) {
                multiNetLinkWaysUtil.negativeMobileNetwork(this.mContext);
            }
        }

        public final void setMContext(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            } else {
                this.mContext = context;
            }
        }

        public final void setMReceiver(@Nullable MultiNetLinkWaysUtil multiNetLinkWaysUtil) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) multiNetLinkWaysUtil);
            } else {
                this.mReceiver = multiNetLinkWaysUtil;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DelayUnregister(@NotNull MultiNetLinkWaysUtil receiver, @Nullable Context context) {
            this();
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) receiver, (Object) context);
            } else {
                this.mReceiver = receiver;
                this.mContext = context;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mars/comm/MultiNetLinkWaysUtil$MobileNetworkCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "receiver", "Lcom/tencent/mars/comm/MultiNetLinkWaysUtil;", "(Lcom/tencent/mars/comm/MultiNetLinkWaysUtil;)V", "()V", "mReceiver", "getMReceiver", "()Lcom/tencent/mars/comm/MultiNetLinkWaysUtil;", "setMReceiver", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "onUnavailable", "wechat-commons-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class MobileNetworkCallback extends ConnectivityManager.NetworkCallback {
        static IPatchRedirector $redirector_;

        @Nullable
        private MultiNetLinkWaysUtil mReceiver;

        public MobileNetworkCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Nullable
        public final MultiNetLinkWaysUtil getMReceiver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MultiNetLinkWaysUtil) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.mReceiver;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NotNull Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) network);
                return;
            }
            Intrinsics.checkNotNullParameter(network, "network");
            w.d(MultiNetLinkWaysUtil.TAG, "network available " + network);
            MultiNetLinkWaysUtil multiNetLinkWaysUtil = this.mReceiver;
            if (multiNetLinkWaysUtil != null) {
                multiNetLinkWaysUtil.onMobileNetworkReady(network);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NotNull Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) network);
                return;
            }
            Intrinsics.checkNotNullParameter(network, "network");
            w.d(MultiNetLinkWaysUtil.TAG, "network onLost");
            MultiNetLinkWaysUtil multiNetLinkWaysUtil = this.mReceiver;
            if (multiNetLinkWaysUtil != null) {
                multiNetLinkWaysUtil.onMobileUnAvailable();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            w.d(MultiNetLinkWaysUtil.TAG, "network onUnavailable");
            MultiNetLinkWaysUtil multiNetLinkWaysUtil = this.mReceiver;
            if (multiNetLinkWaysUtil != null) {
                multiNetLinkWaysUtil.onMobileUnAvailable();
            }
        }

        public final void setMReceiver(@Nullable MultiNetLinkWaysUtil multiNetLinkWaysUtil) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) multiNetLinkWaysUtil);
            } else {
                this.mReceiver = multiNetLinkWaysUtil;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MobileNetworkCallback(@NotNull MultiNetLinkWaysUtil receiver) {
            this();
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.mReceiver = receiver;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) receiver);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59040);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ MultiNetLinkWaysUtil(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    private final int bindSocketToMobileImpl(int socketFd) {
        w.d(TAG, "Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT);
        try {
            FileDescriptor fileDescriptor = new FileDescriptor();
            Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            declaredField.setInt(fileDescriptor, socketFd);
            Network network = this.mMobileNetwork;
            if (network != null) {
                network.bindSocket(fileDescriptor);
            }
            w.d(TAG, "bind socket success, fd: " + socketFd);
            return 0;
        } catch (Exception e16) {
            w.b(TAG, "bind socket failed: " + e16.getMessage() + ", fd: " + socketFd);
            return -1;
        }
    }

    private final void delayUnregister(Context context) {
        BaseTimer baseTimer = new BaseTimer();
        MultiNetLinkWaysUtil multiNetLinkWaysUtil = mInstance;
        Intrinsics.checkNotNull(multiNetLinkWaysUtil);
        baseTimer.schedule(new DelayUnregister(multiNetLinkWaysUtil, context), 30000L);
    }

    private final int reflectCallBind(int socketFd) {
        w.d(TAG, "try to call reflection version");
        try {
            Class<?> cls = Class.forName("android.net.NetworkUtils");
            Object newInstance = cls.newInstance();
            Class<?> cls2 = Integer.TYPE;
            Object invoke = cls.getDeclaredMethod("bindSocketToNetwork", cls2, cls2).invoke(newInstance, Integer.valueOf(socketFd), Integer.valueOf(this.mMobileNetId));
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) invoke).intValue();
            w.d(TAG, "call reflection bind ret: " + intValue);
            return intValue;
        } catch (Exception e16) {
            w.b(TAG, "call reflection bind error: " + e16.getMessage());
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.String] */
    private final String resolveHostByCellularImpl(final String host) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new String();
        final Object obj = new Object();
        synchronized (obj) {
            ThreadsKt.thread$default(false, false, null, null, 0, new Function0<Unit>(host, objectRef, obj) { // from class: com.tencent.mars.comm.MultiNetLinkWaysUtil$resolveHostByCellularImpl$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Object $dnsTimer;
                final /* synthetic */ String $host;
                final /* synthetic */ Ref.ObjectRef<String> $ip;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$host = host;
                    this.$ip = objectRef;
                    this.$dnsTimer = obj;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, MultiNetLinkWaysUtil.this, host, objectRef, obj);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.Object, java.lang.String] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Network network;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        network = MultiNetLinkWaysUtil.this.mMobileNetwork;
                        Intrinsics.checkNotNull(network);
                        InetAddress byName = network.getByName(this.$host);
                        if (byName != null && byName.getHostAddress() != null) {
                            Ref.ObjectRef<String> objectRef2 = this.$ip;
                            ?? hostAddress = byName.getHostAddress();
                            Intrinsics.checkNotNull(hostAddress);
                            objectRef2.element = hostAddress;
                        }
                    } catch (Exception e16) {
                        w.b("MultiNetLinkWaysUtil", "mMobileNetwork!!.getByName error msg:" + e16.getMessage());
                    }
                    Object obj2 = this.$dnsTimer;
                    synchronized (obj2) {
                        obj2.notifyAll();
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }, 31, null);
            try {
                obj.wait(2000L);
            } catch (Exception e16) {
                w.b(TAG, "dns by cellular fail: " + e16);
            }
            Unit unit = Unit.INSTANCE;
        }
        w.d(TAG, "host:" + host + ", ip:" + ((String) objectRef.element));
        return (String) objectRef.element;
    }

    public final void activeMobileNetwork(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        if (context == null) {
            w.f(TAG, "activeMobileNetwork context is null");
            return;
        }
        w.d(TAG, "start active mobile network");
        if (this.mMobileNetworkCallback == null) {
            this.mMobileNetworkCallback = new MobileNetworkCallback(this);
        }
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12);
        builder.addTransportType(0);
        NetworkRequest build = builder.build();
        ConnectivityManager.NetworkCallback networkCallback = this.mMobileNetworkCallback;
        Intrinsics.checkNotNull(networkCallback);
        ((ConnectivityManager) systemService).requestNetwork(build, networkCallback);
    }

    @NotNull
    public final BindAndDnsReturnKt bindSocketToCellularAndDnsByCellular(int socketFd, @NotNull String hostDomain, @Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (BindAndDnsReturnKt) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(socketFd), hostDomain, context);
        }
        Intrinsics.checkNotNullParameter(hostDomain, "hostDomain");
        if (!syncActiveMobileNetwork(context)) {
            return new BindAndDnsReturnKt(new String(), this.kNoCellularNetwork);
        }
        String resolveHostByCellularImpl = resolveHostByCellularImpl(hostDomain);
        if (resolveHostByCellularImpl.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return new BindAndDnsReturnKt(new String(), this.kDnsFail);
        }
        if (bindSocketToMobileImpl(socketFd) != 0) {
            return new BindAndDnsReturnKt(new String(), this.kBindFail);
        }
        return new BindAndDnsReturnKt(resolveHostByCellularImpl, this.kSuccess);
    }

    public final boolean bindSocketToMobile(int socketFd, @Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, socketFd, (Object) context)).booleanValue();
        }
        if (!syncActiveMobileNetwork(context) || bindSocketToMobileImpl(socketFd) != 0) {
            return false;
        }
        return true;
    }

    public final void negativeMobileNetwork(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        w.d(TAG, "cronet negativeMobileNetwork");
        if (context == null) {
            w.f(TAG, "negativeMobileNetwork context == null");
            return;
        }
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        synchronized (this.mLock) {
            ConnectivityManager.NetworkCallback networkCallback = this.mMobileNetworkCallback;
            if (networkCallback == null) {
                w.d(TAG, "cronet already negativeMobileNetwork");
                return;
            }
            try {
                Intrinsics.checkNotNull(networkCallback);
                connectivityManager.unregisterNetworkCallback(networkCallback);
                this.mMobileNetworkCallback = null;
                this.mMobileNetwork = null;
            } catch (Exception unused) {
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void onMobileNetworkReady(@NotNull Network network) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) network);
            return;
        }
        Intrinsics.checkNotNullParameter(network, "network");
        this.mMobileNetwork = network;
        this.mMobileNetId = network.hashCode() / 11;
        w.d(TAG, "receive net id is " + this.mMobileNetId);
        synchronized (this.mLock) {
            this.mLock.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void onMobileUnAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.mMobileNetwork = null;
        this.mMobileNetworkCallback = null;
        synchronized (this.mLock) {
            this.mLock.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final String resolveHostByCellular(@NotNull String hostDomain, @Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) hostDomain, (Object) context);
        }
        Intrinsics.checkNotNullParameter(hostDomain, "hostDomain");
        if (!syncActiveMobileNetwork(context)) {
            return "";
        }
        return resolveHostByCellularImpl(hostDomain);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        if (r5.mMobileNetwork != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        delayUnregister(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        if (r5.mMobileNetwork == null) goto L28;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean syncActiveMobileNetwork(@Nullable Context context) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context)).booleanValue();
        }
        synchronized (this.mLock) {
            if (this.mMobileNetwork == null) {
                activeMobileNetwork(context);
                try {
                    try {
                        this.mLock.wait(1000L);
                    } catch (Throwable th5) {
                        if (this.mMobileNetwork != null) {
                            delayUnregister(context);
                        }
                        throw th5;
                    }
                } catch (Exception e16) {
                    w.b(TAG, "cronet activeMobileNetwork error: " + e16);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("get mobile network success: ");
        if (this.mMobileNetwork != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        w.d(TAG, sb5.toString());
        if (this.mMobileNetwork != null) {
            return true;
        }
        return false;
    }

    MultiNetLinkWaysUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mMobileNetId = -1;
        this.mLock = new Object();
        this.kNoCellularNetwork = 1;
        this.kDnsFail = 2;
        this.kBindFail = 3;
    }
}
