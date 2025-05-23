package com.tencent.mobileqq.zplan.proxy.channel.request;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.NewIntent;
import oj3.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u000212B\u0011\u0012\b\u0010%\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b.\u0010/J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J \u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J&\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0016\u0018\u00010\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0016J \u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nJ(\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dR\u0019\u0010%\u001a\u0004\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\n0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/channel/request/ChannelRequestHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "", "data", "", Constants.BASE_IN_PLUGIN_VERSION, "Lcom/tencent/mobileqq/zplan/proxy/channel/request/ChannelBusinessObserver;", "observer", "", "rspData", "", "E2", "F2", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "res", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "cmd", "reqBytes", Constants.MMCCID, "", "timeoutMillis", "H2", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "", "e", "Ljava/util/Map;", "observerMap", "Ljava/util/concurrent/locks/ReentrantLock;", "f", "Ljava/util/concurrent/locks/ReentrantLock;", "observerLock", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", h.F, "ResponseRunnable", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ChannelRequestHandler extends BusinessHandler {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final AtomicLong f334973i = new AtomicLong(0);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AppInterface app;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Map<String, ChannelBusinessObserver> observerMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock observerLock;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B7\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/channel/request/ChannelRequestHandler$ResponseRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lcom/tencent/mobileqq/zplan/proxy/channel/request/ChannelBusinessObserver;", "d", "Lcom/tencent/mobileqq/zplan/proxy/channel/request/ChannelBusinessObserver;", "getObserver", "()Lcom/tencent/mobileqq/zplan/proxy/channel/request/ChannelBusinessObserver;", "observer", "", "e", "I", "getSsoResultCode", "()I", "ssoResultCode", "f", "getTrpcRspFuncRetCode", "trpcRspFuncRetCode", "", h.F, "[B", "getTrpcRspErrorMsg", "()[B", "trpcRspErrorMsg", "", "i", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "data", "<init>", "(Lcom/tencent/mobileqq/zplan/proxy/channel/request/ChannelBusinessObserver;II[BLjava/lang/Object;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class ResponseRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final ChannelBusinessObserver observer;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int ssoResultCode;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int trpcRspFuncRetCode;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final byte[] trpcRspErrorMsg;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final Object data;

        public ResponseRunnable(ChannelBusinessObserver channelBusinessObserver, int i3, int i16, byte[] bArr, Object obj) {
            this.observer = channelBusinessObserver;
            this.ssoResultCode = i3;
            this.trpcRspFuncRetCode = i16;
            this.trpcRspErrorMsg = bArr;
            this.data = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] bArr = this.trpcRspErrorMsg;
                String str = null;
                if (bArr != null) {
                    if (!(!(bArr.length == 0))) {
                        bArr = null;
                    }
                    if (bArr != null) {
                        str = new String(bArr, Charsets.UTF_8);
                    }
                }
                ChannelBusinessObserver channelBusinessObserver = this.observer;
                if (channelBusinessObserver != null) {
                    channelBusinessObserver.onResponse(this.ssoResultCode, this.trpcRspFuncRetCode, str, this.data);
                }
            } catch (Throwable th5) {
                QLog.e("ChannelRequestHandler", 1, "UpdateRunnable is error : " + th5);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/channel/request/ChannelRequestHandler$a;", "", "Lcom/tencent/mobileqq/zplan/proxy/channel/request/ChannelRequestHandler;", "a", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicLong;", "seqIndex", "Ljava/util/concurrent/atomic/AtomicLong;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.proxy.channel.request.ChannelRequestHandler$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChannelRequestHandler a() {
            AppInterface c16 = bb.f335811a.c();
            if (c16 == null) {
                return null;
            }
            BusinessHandler businessHandler = c16.getBusinessHandler(ChannelRequestHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.proxy.channel.request.ChannelRequestHandler");
            return (ChannelRequestHandler) businessHandler;
        }

        Companion() {
        }
    }

    public ChannelRequestHandler(AppInterface appInterface) {
        super(appInterface);
        this.app = appInterface;
        this.observerMap = new LinkedHashMap();
        this.observerLock = new ReentrantLock();
    }

    private final boolean D2(Intent request, FromServiceMsg response, byte[] data) {
        String stringExtra = request.getStringExtra("__cmd_seq__");
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        ReentrantLock reentrantLock = this.observerLock;
        reentrantLock.lock();
        try {
            Map<String, ChannelBusinessObserver> map = this.observerMap;
            Intrinsics.checkNotNull(stringExtra);
            ChannelBusinessObserver remove = map.remove(stringExtra);
            if (remove == null) {
                return false;
            }
            reentrantLock.unlock();
            QLog.d("ChannelRequestHandler", 1, "handleObserverResponse, cmd: " + stringExtra + ", sso errCode: " + response.getBusinessFailCode() + ", sso errMsg: " + response.getBusinessFailMsg() + ",trpc errCode: " + response.getTrpcRspFuncRetCode() + "trpc errMsg: " + response.getTrpcRspErrorMsg());
            Class cls = (Class) request.getSerializableExtra("__rspClass__");
            if (cls == null) {
                E2(response, remove, data);
                return true;
            }
            try {
                Object newInstance = cls.newInstance();
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.pb.MessageMicro<*>");
                MessageMicro messageMicro = (MessageMicro) newInstance;
                messageMicro.mergeFrom(data);
                E2(response, remove, messageMicro);
                return true;
            } catch (Exception e16) {
                QLog.e("ChannelRequestHandler", 1, "response is error", e16);
                return false;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void E2(FromServiceMsg response, ChannelBusinessObserver observer, Object rspData) {
        ThreadManagerV2.excute(new ResponseRunnable(observer, response.getResultCode(), response.getTrpcRspFuncRetCode(), response.getTrpcRspErrorMsg(), rspData), 16, null, true);
    }

    public final void F2(Intent request, FromServiceMsg response, byte[] data) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        if (D2(request, response, data)) {
            return;
        }
        QLog.e("ChannelRequestHandler", 1, "handleResponse error " + request.getStringExtra("cmd"));
    }

    public final void G2(String cmd, byte[] reqBytes, ChannelBusinessObserver observer) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(observer, "observer");
        H2(cmd, reqBytes, observer, 30000L);
    }

    public final void H2(String cmd, byte[] reqBytes, ChannelBusinessObserver observer, long timeoutMillis) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(observer, "observer");
        QLog.i("ChannelRequestHandler", 1, "request, cmd : " + cmd);
        AppInterface appInterface = this.app;
        NewIntent newIntent = new NewIntent(appInterface != null ? appInterface.getApp() : null, a.class);
        String str = cmd + "_" + f334973i.incrementAndGet();
        newIntent.putExtra("cmd", cmd);
        newIntent.putExtra("data", reqBytes);
        newIntent.putExtra("timeout", timeoutMillis);
        newIntent.putExtra("__cmd_seq__", str);
        ReentrantLock reentrantLock = this.observerLock;
        reentrantLock.lock();
        try {
            this.observerMap.put(str, observer);
            reentrantLock.unlock();
            AppInterface appInterface2 = this.app;
            if (appInterface2 != null) {
                appInterface2.startServlet(newIntent);
            }
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        QLog.i("ChannelRequestHandler", 1, "onDestroy, clear observer map");
        ReentrantLock reentrantLock = this.observerLock;
        reentrantLock.lock();
        try {
            this.observerMap.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg req, FromServiceMsg res, Object data) {
    }
}
