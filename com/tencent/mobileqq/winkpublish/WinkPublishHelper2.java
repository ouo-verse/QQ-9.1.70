package com.tencent.mobileqq.winkpublish;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.api.IPublishApi;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.api.IWinkPublishService;
import com.tencent.mobileqq.winkpublish.compact.WinkPublishServiceReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002!\"B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007J\u001a\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\tJ\"\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2;", "", "()V", "TAG", "", "pendingCallbacksMap", "", "", "", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "serviceConnectionMap", "", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$MyServiceConnection;", "serviceProxyMap", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "addExportTask", "", "params", "Landroid/os/Bundle;", "addTask", "addTaskListener", "listener", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener;", "businessType", "bindService", "callback", "forceBind", "", "flushPendingCallback", "service", "getQfsService", "getService", "unBindService", "Callback", "MyServiceConnection", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkPublishHelper2 {

    @NotNull
    private static final String TAG = "Service-WinkPublishHelper2";

    @NotNull
    public static final WinkPublishHelper2 INSTANCE = new WinkPublishHelper2();

    @NotNull
    private static final Map<Integer, WinkPublishServiceProxy2> serviceProxyMap = new LinkedHashMap();

    @NotNull
    private static final Map<Integer, List<Callback>> pendingCallbacksMap = new LinkedHashMap();

    @NotNull
    private static final Set<MyServiceConnection> serviceConnectionMap = new LinkedHashSet();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "", "onServiceConnected", "", "service", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public interface Callback {
        void onServiceConnected(@NotNull WinkPublishServiceProxy2 service);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$MyServiceConnection;", "Landroid/content/ServiceConnection;", "start", "", "businessType", "", "(JI)V", "getBusinessType", "()I", "getStart", "()J", "setStart", "(J)V", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "binder", "Landroid/os/IBinder;", "onServiceDisconnected", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class MyServiceConnection implements ServiceConnection {
        private final int businessType;
        private long start;

        public MyServiceConnection(long j3, int i3) {
            this.start = j3;
            this.businessType = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v7, types: [T, com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2] */
        public static final void onServiceConnected$lambda$1(final MyServiceConnection this$0, IBinder binder) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binder, "$binder");
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this$0.start;
            long j16 = currentTimeMillis - j3;
            QLog.i(WinkPublishHelper2.TAG, 1, "[onServiceConnected] start=" + j3 + ", cost=" + j16 + ", businessType=" + this$0.businessType + ", binder=" + binder + ", id=" + this$0);
            WinkPublishServiceReporter.reportOperation(2, this$0.businessType);
            WinkPublishServiceReporter.reportCost(j16, this$0.businessType);
            IWinkPublishService asInterface = IWinkPublishService.Stub.asInterface(binder);
            if (asInterface == null) {
                QLog.w(WinkPublishHelper2.TAG, 1, "[onServiceConnected] invalid service");
                return;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? r16 = WinkPublishHelper2.serviceProxyMap.get(Integer.valueOf(this$0.businessType));
            objectRef.element = r16;
            WinkPublishServiceProxy2 winkPublishServiceProxy2 = (WinkPublishServiceProxy2) r16;
            if (winkPublishServiceProxy2 != null) {
                bool = Boolean.valueOf(winkPublishServiceProxy2.isBinderAlive());
            } else {
                bool = null;
            }
            QLog.i(WinkPublishHelper2.TAG, 1, "[onServiceConnected] check proxy, " + bool);
            T t16 = objectRef.element;
            if (t16 == 0 || !((WinkPublishServiceProxy2) t16).isBinderAlive()) {
                objectRef.element = new WinkPublishServiceProxy2(this$0.businessType, asInterface);
                WinkPublishHelper2.serviceProxyMap.put(Integer.valueOf(this$0.businessType), objectRef.element);
            }
            ((WinkPublishServiceProxy2) objectRef.element).init();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.winkpublish.b
                @Override // java.lang.Runnable
                public final void run() {
                    WinkPublishHelper2.MyServiceConnection.onServiceConnected$lambda$1$lambda$0(WinkPublishHelper2.MyServiceConnection.this, objectRef);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void onServiceConnected$lambda$1$lambda$0(MyServiceConnection this$0, Ref.ObjectRef proxy) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(proxy, "$proxy");
            WinkPublishHelper2.INSTANCE.flushPendingCallback(this$0.businessType, (WinkPublishServiceProxy2) proxy.element);
        }

        public final int getBusinessType() {
            return this.businessType;
        }

        public final long getStart() {
            return this.start;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@NotNull ComponentName name, @NotNull final IBinder binder) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(binder, "binder");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.winkpublish.a
                @Override // java.lang.Runnable
                public final void run() {
                    WinkPublishHelper2.MyServiceConnection.onServiceConnected$lambda$1(WinkPublishHelper2.MyServiceConnection.this, binder);
                }
            }, 16, null, true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@NotNull ComponentName name) {
            Intrinsics.checkNotNullParameter(name, "name");
            QLog.i(WinkPublishHelper2.TAG, 1, "[onServiceDisconnected] ");
            WinkPublishServiceReporter.reportOperation(4, this.businessType);
            BaseApplication.getContext().unbindService(this);
            WinkPublishHelper2.serviceProxyMap.remove(Integer.valueOf(this.businessType));
            WinkPublishHelper2.bindService$default(WinkPublishHelper2.INSTANCE, this.businessType, null, 2, null);
            this.start = System.currentTimeMillis();
        }

        public final void setStart(long j3) {
            this.start = j3;
        }
    }

    WinkPublishHelper2() {
    }

    public static /* synthetic */ void bindService$default(WinkPublishHelper2 winkPublishHelper2, int i3, Callback callback, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            callback = null;
        }
        winkPublishHelper2.bindService(i3, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushPendingCallback(int businessType, WinkPublishServiceProxy2 service) {
        Integer num;
        Map<Integer, List<Callback>> map = pendingCallbacksMap;
        List<Callback> list = map.get(Integer.valueOf(businessType));
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        QLog.i(TAG, 1, "[flushPendingCallback] pending callback size=" + num);
        List<Callback> list2 = map.get(Integer.valueOf(businessType));
        if (list2 != null) {
            for (Callback callback : list2) {
                if (callback != null) {
                    callback.onServiceConnected(service);
                }
            }
        }
        Map<Integer, List<Callback>> map2 = pendingCallbacksMap;
        List<Callback> list3 = map2.get(Integer.valueOf(businessType));
        if (list3 != null) {
            list3.clear();
        }
        map2.remove(Integer.valueOf(businessType));
    }

    public final void addExportTask(@Nullable Bundle params) {
        ((IPublishApi) QRoute.api(IPublishApi.class)).addExportTask(params);
    }

    public final void addTask(@NotNull Bundle params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ((IPublishApi) QRoute.api(IPublishApi.class)).addTask(params);
    }

    public final void addTaskListener(@NotNull ITaskListener listener, int businessType) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ((IPublishApi) QRoute.api(IPublishApi.class)).addTaskListener(listener, businessType);
    }

    public final void bindService(int businessType, @Nullable Callback callback) {
        bindService(businessType, callback, false);
    }

    @Nullable
    public final WinkPublishServiceProxy2 getQfsService() {
        QLog.i(TAG, 1, "[getQFSService]");
        return getService(1);
    }

    @Nullable
    public final WinkPublishServiceProxy2 getService(int businessType) {
        WinkPublishServiceReporter.reportOperation(5, businessType);
        WinkPublishServiceProxy2 winkPublishServiceProxy2 = serviceProxyMap.get(Integer.valueOf(businessType));
        if (winkPublishServiceProxy2 == null) {
            QLog.w(TAG, 1, "[getService] not ready ", new RuntimeException());
            WinkPublishServiceReporter.reportOperation(6, businessType);
            return winkPublishServiceProxy2;
        }
        if (!winkPublishServiceProxy2.isBinderAlive()) {
            QLog.w(TAG, 1, "[getService] not alive ", new RuntimeException());
            WinkPublishServiceReporter.reportOperation(7, businessType);
            return null;
        }
        return winkPublishServiceProxy2;
    }

    public final void unBindService() {
        for (MyServiceConnection myServiceConnection : serviceConnectionMap) {
            QLog.i(TAG, 1, "unBindService id:" + myServiceConnection);
            try {
                BaseApplication.getContext().unbindService(myServiceConnection);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
    }

    public static /* synthetic */ void bindService$default(WinkPublishHelper2 winkPublishHelper2, int i3, Callback callback, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            callback = null;
        }
        winkPublishHelper2.bindService(i3, callback, z16);
    }

    public final void bindService(int businessType, @Nullable Callback callback, boolean forceBind) {
        QLog.i(TAG, 1, "bindService");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WinkPublishHelper2$bindService$1(businessType, callback, forceBind, null), 3, null);
    }
}
