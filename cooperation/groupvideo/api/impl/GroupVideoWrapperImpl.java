package cooperation.groupvideo.api.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GVideoProxyService;
import cooperation.groupvideo.api.IGroupVideoWrapper;
import qu.a;

/* compiled from: P */
/* loaded from: classes38.dex */
public class GroupVideoWrapperImpl implements IGroupVideoWrapper {
    public static final String TAG = "GroupVideoRemoteManager";
    AppInterface mApp;
    qu.a mGvProxy = null;
    IGroupVideoWrapper.a mOnReadyListener = null;
    a mSerConn = new a();

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGroupVideoWrapper.a aVar;
            if (QLog.isColorLevel()) {
                QLog.d(GroupVideoWrapperImpl.TAG, 2, "Qav Service connected!");
            }
            GroupVideoWrapperImpl.this.mGvProxy = a.AbstractBinderC11098a.j(iBinder);
            GroupVideoWrapperImpl groupVideoWrapperImpl = GroupVideoWrapperImpl.this;
            if (groupVideoWrapperImpl.mGvProxy != null && (aVar = groupVideoWrapperImpl.mOnReadyListener) != null) {
                aVar.a(groupVideoWrapperImpl);
            } else if (QLog.isColorLevel()) {
                QLog.d(GroupVideoWrapperImpl.TAG, 2, "mQavProxy == null or mOnReadyListener == null");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (QLog.isColorLevel()) {
                QLog.d(GroupVideoWrapperImpl.TAG, 2, "Qav Service disconnected!");
            }
            GroupVideoWrapperImpl.this.mGvProxy = null;
        }
    }

    @Override // cooperation.groupvideo.api.IGroupVideoWrapper
    public int getPstnUserNumberInMAV(long j3, int i3) {
        qu.a aVar = this.mGvProxy;
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "mQavProxy == null");
            }
            return 0;
        }
        try {
            return aVar.getPstnUserNumberInMAV(j3, i3);
        } catch (RemoteException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "RemoteException", e16);
            }
            return 0;
        }
    }

    @Override // cooperation.groupvideo.api.IGroupVideoWrapper
    public void init(AppInterface appInterface) {
        this.mApp = appInterface;
    }

    @Override // cooperation.groupvideo.api.IGroupVideoWrapper
    public void initialize(IGroupVideoWrapper.a aVar) {
        this.mOnReadyListener = aVar;
        if (this.mGvProxy == null) {
            cooperation.groupvideo.a.a(this.mApp, GVideoProxyService.class, this.mSerConn, "com.gvideo.com.tencent.av.service.GVServiceForQQ");
        }
    }

    @Override // cooperation.groupvideo.api.IGroupVideoWrapper
    public void onUpdateTroopList() {
        qu.a aVar = this.mGvProxy;
        if (aVar != null) {
            try {
                aVar.onUpdateTroopList();
            } catch (RemoteException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // cooperation.groupvideo.api.IGroupVideoWrapper
    public void processS2C(byte[] bArr) {
        qu.a aVar = this.mGvProxy;
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "mQavProxy == null");
            }
        } else {
            try {
                aVar.processS2C(bArr);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "RemoteException", e16);
                }
            }
        }
    }

    @Override // cooperation.groupvideo.api.IGroupVideoWrapper
    public void uninitialize() {
        cooperation.groupvideo.a.f(this.mApp, this.mSerConn);
        this.mGvProxy = null;
        this.mOnReadyListener = null;
    }

    @Override // cooperation.groupvideo.api.IGroupVideoWrapper
    public qu.a getProxy() {
        return this.mGvProxy;
    }
}
