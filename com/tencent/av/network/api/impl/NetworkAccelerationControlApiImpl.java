package com.tencent.av.network.api.impl;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.network.api.INetworkAccelerationControlApi;
import com.tencent.avcore.jni.net.SocketInfo;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes32.dex */
public class NetworkAccelerationControlApiImpl implements INetworkAccelerationControlApi {
    private static final int[] CLIENT_SUPPORT_MANUFACTURE_TAG = {1, 2};
    private static final int MSG_BIND_SOCKET_ACCELERATE = 258;
    private static final int MSG_INIT = 256;
    private static final int MSG_REFRESH_CONFIG = 261;
    private static final int MSG_REGISTER_EVENT = 262;
    private static final int MSG_SET_SOCKET_BANDWIDTH = 260;
    private static final int MSG_SUBMIT_REQUEST_TO_SYS = 257;
    private static final int MSG_UNBIND_SOCKET_ACCELERATE = 259;
    private static final int MSG_UNREGISTER_EVENT = 263;
    private static final String TAG = "NetworkAccelerationControlApiImpl";
    private Boolean mIsSupportNetworkAcceleration;
    private wu.a mNetworkAccelerationCall;
    private wu.b mNetworkConfigurationCall;
    private int mCurManufacture = -1;
    private boolean mInit = false;
    private final AtomicInteger mState = new AtomicInteger(0);
    private final CopyOnWriteArraySet<WeakReference<zu.a>> mListeners = new CopyOnWriteArraySet<>();
    private final a mCustomHandler = new a(gv.a.a().c());

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = (b) message.obj;
            switch (message.what) {
                case 256:
                    NetworkAccelerationControlApiImpl.this.initAsyncInternal();
                    return;
                case 257:
                    NetworkAccelerationControlApiImpl.this.notifyAPPStateToSysInternal(((Integer) bVar.f73850a).intValue());
                    return;
                case 258:
                    NetworkAccelerationControlApiImpl.this.bindToNetInterfaceInternal((SocketInfo) bVar.f73850a);
                    return;
                case 259:
                    NetworkAccelerationControlApiImpl.this.unBindToNetInterfaceInternal((SocketInfo) bVar.f73850a);
                    return;
                case 260:
                    NetworkAccelerationControlApiImpl.this.setAppBandwidthInternal(((Integer) bVar.f73850a).intValue(), ((Integer) bVar.f73851b).intValue());
                    return;
                case 261:
                    NetworkAccelerationControlApiImpl.this.refreshConfigCacheInternal();
                    return;
                case 262:
                    NetworkAccelerationControlApiImpl.this.registerNetworkEventListenerInternal((zu.b) bVar.f73850a);
                    return;
                case 263:
                    NetworkAccelerationControlApiImpl.this.unRegisterNetworkEventListenerInternal((zu.b) bVar.f73850a);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public Object f73850a;

        /* renamed from: b, reason: collision with root package name */
        public Object f73851b;

        /* renamed from: c, reason: collision with root package name */
        public Object f73852c;

        b() {
        }

        public static b a(Object obj) {
            b bVar = new b();
            bVar.f73850a = obj;
            bVar.f73851b = null;
            bVar.f73852c = null;
            return bVar;
        }

        public static b b(Object obj, Object obj2) {
            b bVar = new b();
            bVar.f73850a = obj;
            bVar.f73851b = obj2;
            bVar.f73852c = null;
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindToNetInterfaceInternal(SocketInfo socketInfo) {
        this.mNetworkAccelerationCall.bindToNetInterface(socketInfo);
    }

    private void doInitStepStageOne() {
        wu.a netWorkAcceleration = getNetWorkAcceleration();
        this.mNetworkAccelerationCall = netWorkAcceleration;
        int curManufacture = netWorkAcceleration.getCurManufacture();
        this.mCurManufacture = curManufacture;
        xu.a aVar = new xu.a(curManufacture);
        this.mNetworkConfigurationCall = aVar;
        aVar.b();
        this.mState.set(2);
        QLog.d(TAG, 1, "doInitStepStageOne finish");
    }

    private void doInitStepStageTwo() {
        CopyOnWriteArraySet<WeakReference<zu.a>> copyOnWriteArraySet = this.mListeners;
        if (copyOnWriteArraySet != null) {
            Iterator<WeakReference<zu.a>> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                zu.a aVar = it.next().get();
                if (aVar != null) {
                    aVar.a(this.mState.get());
                }
            }
            this.mListeners.clear();
        }
    }

    private static final wu.a getNetWorkAcceleration() {
        String str = Build.MANUFACTURER;
        if (str.equalsIgnoreCase("OPPO")) {
            return new dv.b();
        }
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR)) {
            return new bv.b();
        }
        return new fv.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAsyncInternal() {
        if (this.mInit) {
            return;
        }
        this.mInit = true;
        doInitStepStageOne();
        doInitStepStageTwo();
    }

    private boolean isClientSupport() {
        boolean z16;
        int[] iArr = CLIENT_SUPPORT_MANUFACTURE_TAG;
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z16 = false;
                break;
            }
            if (iArr[i3] == this.mCurManufacture) {
                QLog.e(TAG, 1, "client check ready");
                z16 = true;
                break;
            }
            i3++;
        }
        return z16 && Build.VERSION.SDK_INT >= 31;
    }

    private synchronized boolean isSupportNetworkAccelerationInternal() {
        if (this.mIsSupportNetworkAcceleration == null) {
            this.mIsSupportNetworkAcceleration = Boolean.valueOf(isClientSupport() && !this.mNetworkConfigurationCall.a() && this.mNetworkAccelerationCall.isSupportNetworkAcceleration());
            QLog.d(TAG, 1, "isSupportNetworkAccelerationInternal " + this.mIsSupportNetworkAcceleration);
        }
        return this.mIsSupportNetworkAcceleration.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAPPStateToSysInternal(int i3) {
        this.mNetworkAccelerationCall.notifyAPPStateToSys(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshConfigCacheInternal() {
        this.mNetworkConfigurationCall.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerNetworkEventListenerInternal(zu.b bVar) {
        this.mNetworkAccelerationCall.registerNetworkEventListener(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppBandwidthInternal(int i3, int i16) {
        this.mNetworkAccelerationCall.setAppBandwidth(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unBindToNetInterfaceInternal(SocketInfo socketInfo) {
        this.mNetworkAccelerationCall.unBindToNetInterface(socketInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterNetworkEventListenerInternal(zu.b bVar) {
        this.mNetworkAccelerationCall.unRegisterNetworkEventListener(bVar);
    }

    @Override // com.tencent.av.network.api.INetworkAccelerationControlApi, wu.a
    public void bindToNetInterface(SocketInfo socketInfo) {
        this.mCustomHandler.obtainMessage(258, b.a(socketInfo)).sendToTarget();
    }

    @Override // com.tencent.av.network.api.INetworkAccelerationControlApi, wu.a
    public int getCurManufacture() {
        return this.mCurManufacture;
    }

    @Override // com.tencent.av.network.api.INetworkAccelerationControlApi, wu.a
    public boolean hasFeature(int i3) {
        return this.mNetworkAccelerationCall.hasFeature(i3);
    }

    @Override // com.tencent.av.network.api.INetworkAccelerationControlApi
    public boolean hasInit() {
        return this.mState.get() == 2;
    }

    @Override // com.tencent.av.network.api.INetworkAccelerationControlApi
    public void initAsync(zu.a aVar) {
        if (this.mState.get() == 2) {
            aVar.a(this.mState.get());
            return;
        }
        if (this.mState.get() == 1) {
            this.mListeners.add(new WeakReference<>(aVar));
            return;
        }
        this.mState.set(1);
        this.mListeners.add(new WeakReference<>(aVar));
        if (this.mCustomHandler.hasMessages(256)) {
            this.mCustomHandler.removeMessages(256);
        }
        this.mCustomHandler.sendEmptyMessage(256);
    }

    @Override // com.tencent.av.network.api.INetworkAccelerationControlApi, wu.a
    public boolean isSupportNetworkAcceleration() {
        return isSupportNetworkAccelerationInternal();
    }

    @Override // com.tencent.av.network.api.INetworkAccelerationControlApi, wu.a
    public void notifyAPPStateToSys(int i3) {
        this.mCustomHandler.obtainMessage(257, b.a(Integer.valueOf(i3))).sendToTarget();
    }

    public void refreshConfigCache() {
        this.mCustomHandler.sendEmptyMessage(261);
    }

    @Override // com.tencent.av.network.api.INetworkAccelerationControlApi, wu.a
    public void setAppBandwidth(int i3, int i16) {
        this.mCustomHandler.obtainMessage(260, b.b(Integer.valueOf(i3), Integer.valueOf(i16))).sendToTarget();
    }

    @Override // com.tencent.av.network.api.INetworkAccelerationControlApi, wu.a
    public void unBindToNetInterface(SocketInfo socketInfo) {
        this.mCustomHandler.obtainMessage(259, b.a(socketInfo)).sendToTarget();
    }

    @Override // com.tencent.av.network.api.INetworkAccelerationControlApi, wu.a
    public void registerNetworkEventListener(zu.b bVar) {
        if (bVar == null) {
            return;
        }
        this.mCustomHandler.obtainMessage(262, b.a(bVar));
    }

    @Override // com.tencent.av.network.api.INetworkAccelerationControlApi, wu.a
    public void unRegisterNetworkEventListener(zu.b bVar) {
        if (bVar == null) {
            return;
        }
        this.mCustomHandler.obtainMessage(263, b.a(bVar));
    }
}
