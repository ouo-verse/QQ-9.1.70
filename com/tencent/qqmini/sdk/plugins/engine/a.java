package com.tencent.qqmini.sdk.plugins.engine;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0002\t\u000bB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqmini/sdk/plugins/engine/a;", "Lcom/tencent/qqmini/sdk/plugins/engine/f;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/qqmini/sdk/plugins/engine/e;", "permissionCallback", "", "a", "Lcom/tencent/qqmini/sdk/plugins/engine/a$b;", "b", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "mPermissionRecordMap", "<init>", "()V", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, b> mPermissionRecordMap = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0006\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqmini/sdk/plugins/engine/a$b;", "", "", "d", "c", "", "a", "Z", "b", "()Z", "setHasDenied", "(Z)V", "hasDenied", "e", "f", "isRequesting", "Ljava/util/LinkedList;", "Lcom/tencent/qqmini/sdk/plugins/engine/e;", "Ljava/util/LinkedList;", "()Ljava/util/LinkedList;", "setCallbacks", "(Ljava/util/LinkedList;)V", "callbacks", "<init>", "()V", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private volatile boolean hasDenied;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private volatile boolean isRequesting;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private LinkedList<e> callbacks = new LinkedList<>();

        @NotNull
        public final LinkedList<e> a() {
            return this.callbacks;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getHasDenied() {
            return this.hasDenied;
        }

        public final synchronized void c() {
            this.isRequesting = false;
            this.hasDenied = true;
            Iterator<T> it = this.callbacks.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onFailed();
            }
            this.callbacks.clear();
        }

        public final synchronized void d() {
            this.isRequesting = false;
            this.hasDenied = false;
            Iterator<T> it = this.callbacks.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onSucceed();
            }
            this.callbacks.clear();
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsRequesting() {
            return this.isRequesting;
        }

        public final void f(boolean z16) {
            this.isRequesting = z16;
        }
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.f
    @RequiresApi(23)
    public void a(@NotNull Activity activity, @NotNull String permission, @NotNull e permissionCallback) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(permission, "permission");
        Intrinsics.checkParameterIsNotNull(permissionCallback, "permissionCallback");
        if (activity.checkSelfPermission(permission) == 0) {
            permissionCallback.onSucceed();
            return;
        }
        b b16 = b(permission);
        synchronized (b16) {
            if (b16.getIsRequesting()) {
                b16.a().add(permissionCallback);
                QMLog.i("LowFrequencyPermissionReqImpl", "requestPermission isRequesting, perm=" + permission);
                return;
            }
            if (b16.getHasDenied() && !activity.shouldShowRequestPermissionRationale(permission)) {
                permissionCallback.onFailed();
                return;
            }
            b16.f(true);
            b16.a().add(permissionCallback);
            QMLog.i("LowFrequencyPermissionReqImpl", "requestPermission doRequest, perm=" + permission);
            ((IPermissionManagerProxy) ProxyManager.get(IPermissionManagerProxy.class)).requestForPermission(activity, permission, new c(b16));
        }
    }

    @NotNull
    public final b b(@NotNull String permission) {
        b bVar;
        Intrinsics.checkParameterIsNotNull(permission, "permission");
        synchronized (this.mPermissionRecordMap) {
            HashMap<String, b> hashMap = this.mPermissionRecordMap;
            b bVar2 = hashMap.get(permission);
            if (bVar2 == null) {
                bVar2 = new b();
                hashMap.put(permission, bVar2);
            }
            bVar = bVar2;
        }
        return bVar;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqmini/sdk/plugins/engine/a$c", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/RequestPermissionCallback;", "", "onSuccess", "onFail", "onPartialGrant", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class c implements RequestPermissionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f348297a;

        c(b bVar) {
            this.f348297a = bVar;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onFail() {
            this.f348297a.c();
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onSuccess() {
            this.f348297a.d();
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onPartialGrant() {
        }
    }
}
