package com.tencent.sqshow.servlet;

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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
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
import mqq.app.NewIntent;
import o74.a;
import o74.b;
import o74.c;
import t74.e;
import tl.h;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 42\u00020\u0001:\u000256B\u0011\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b2\u00103J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J$\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J&\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0016J \u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nJ(\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cR\u0019\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\n0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00067"}, d2 = {"Lcom/tencent/sqshow/servlet/ZPlanRequestHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "", "data", "", "E2", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observer", "", "rsp", "", "F2", Constants.BASE_IN_PLUGIN_VERSION, Constants.MMCCID, "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "res", "onReceive", "Ljava/lang/Class;", "observerClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "cmd", "reqBytes", "", "timeoutMillis", "H2", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "Lt74/e;", "Lo74/b;", "e", "Lt74/e;", "dispatcher", "", "f", "Ljava/util/Map;", "observerMap", "Ljava/util/concurrent/locks/ReentrantLock;", h.F, "Ljava/util/concurrent/locks/ReentrantLock;", "observerLock", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "i", "UpdateRunnable", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRequestHandler extends BusinessHandler {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static final AtomicLong f369836m = new AtomicLong(0);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AppInterface app;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final e<b> dispatcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Map<String, BusinessObserver> observerMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock observerLock;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/servlet/ZPlanRequestHandler$UpdateRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lcom/tencent/mobileqq/app/BusinessObserver;", "d", "Lcom/tencent/mobileqq/app/BusinessObserver;", "getObserver", "()Lcom/tencent/mobileqq/app/BusinessObserver;", "observer", "", "e", "Z", "isSuccess", "()Z", "", "f", "Ljava/lang/Object;", "getRsp", "()Ljava/lang/Object;", "rsp", "<init>", "(Lcom/tencent/mobileqq/app/BusinessObserver;ZLjava/lang/Object;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class UpdateRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final BusinessObserver observer;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final Object rsp;

        public UpdateRunnable(BusinessObserver businessObserver, boolean z16, Object obj) {
            this.observer = businessObserver;
            this.isSuccess = z16;
            this.rsp = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BusinessObserver businessObserver = this.observer;
                if (businessObserver != null) {
                    businessObserver.onUpdate(0, this.isSuccess, this.rsp);
                }
            } catch (Throwable th5) {
                QLog.e("[zplan]_ZPlanRequestHandler", 1, "UpdateRunnable is error : " + th5);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/servlet/ZPlanRequestHandler$a;", "", "Lcom/tencent/sqshow/servlet/ZPlanRequestHandler;", "a", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicLong;", "seqIndex", "Ljava/util/concurrent/atomic/AtomicLong;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.servlet.ZPlanRequestHandler$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanRequestHandler a() {
            AppInterface appInterface = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getAppInterface();
            if (appInterface == null) {
                return null;
            }
            BusinessHandler businessHandler = appInterface.getBusinessHandler(ZPlanRequestHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.sqshow.servlet.ZPlanRequestHandler");
            return (ZPlanRequestHandler) businessHandler;
        }

        Companion() {
        }
    }

    public ZPlanRequestHandler(AppInterface appInterface) {
        super(appInterface);
        this.app = appInterface;
        e<b> eVar = new e<>();
        this.dispatcher = eVar;
        this.observerMap = new LinkedHashMap();
        this.observerLock = new ReentrantLock();
        eVar.c(a.class);
    }

    private final boolean D2(Intent request, FromServiceMsg response, byte[] data) {
        String stringExtra = request.getStringExtra("cmd");
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        b bVar = new b();
        bVar.request = request;
        bVar.response = response;
        bVar.data = data;
        bVar.handler = this;
        bVar.appInterface = this.app;
        return this.dispatcher.a(stringExtra, bVar);
    }

    private final boolean E2(Intent request, FromServiceMsg response, byte[] data) {
        String stringExtra = request.getStringExtra("__cmd_seq__");
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        ReentrantLock reentrantLock = this.observerLock;
        reentrantLock.lock();
        try {
            Map<String, BusinessObserver> map = this.observerMap;
            Intrinsics.checkNotNull(stringExtra);
            BusinessObserver remove = map.remove(stringExtra);
            if (remove == null) {
                return false;
            }
            reentrantLock.unlock();
            QLog.i("[zplan]_ZPlanRequestHandler", 2, "handleObserverResponse, cmd: " + stringExtra + ", errCode: " + response.getBusinessFailCode() + ", errMsg: " + response.getBusinessFailMsg());
            Class cls = (Class) request.getSerializableExtra("__rspClass__");
            if (cls == null) {
                F2(response, remove, data);
                return true;
            }
            try {
                Object newInstance = cls.newInstance();
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.pb.MessageMicro<*>");
                MessageMicro messageMicro = (MessageMicro) newInstance;
                messageMicro.mergeFrom(data);
                F2(response, remove, messageMicro);
                return true;
            } catch (Exception e16) {
                QLog.e("[zplan]_ZPlanRequestHandler", 1, "response is error", e16);
                return false;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void F2(FromServiceMsg response, BusinessObserver observer, Object rsp) {
        ThreadManagerV2.excute(new UpdateRunnable(observer, response.isSuccess(), rsp), 16, null, true);
    }

    public final void G2(Intent request, FromServiceMsg response, byte[] data) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        if (E2(request, response, data) || D2(request, response, data)) {
            return;
        }
        QLog.e("[zplan]_ZPlanRequestHandler", 1, "handleResponse error " + request.getStringExtra("cmd"));
    }

    public final void H2(String cmd, byte[] reqBytes, BusinessObserver observer, long timeoutMillis) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(observer, "observer");
        QLog.i("[zplan]_ZPlanRequestHandler", 1, "request, cmd : " + cmd);
        AppInterface appInterface = this.app;
        NewIntent newIntent = new NewIntent(appInterface != null ? appInterface.getApp() : null, c.class);
        String str = cmd + "_" + f369836m.incrementAndGet();
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
        return com.tencent.mobileqq.zplan.servlet.b.class;
    }

    public final void request(String cmd, byte[] reqBytes, BusinessObserver observer) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(observer, "observer");
        H2(cmd, reqBytes, observer, 30000L);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        QLog.i("[zplan]_ZPlanRequestHandler", 1, "onDestroy, clear observer map");
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
