package cooperation.qzone.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes28.dex */
public class SDCardMountMonitorReceiver extends BroadcastReceiver {
    private static SDCardMountMonitorReceiver mInstance;
    private boolean mIsRegisteReceiver = false;
    private boolean mIsSDCardMount = false;
    private boolean canWrite = false;
    private boolean isWriteRead = false;
    private boolean isMountRead = false;
    private List<SDCardMountStateListener> observers = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface SDCardMountStateListener {
        void onSDCardMountStateChange(boolean z16);
    }

    SDCardMountMonitorReceiver() {
    }

    public static SDCardMountMonitorReceiver getInstance() {
        if (mInstance == null) {
            mInstance = new SDCardMountMonitorReceiver();
        }
        return mInstance;
    }

    private boolean isCanWrite() {
        if (!this.isWriteRead) {
            this.canWrite = Environment.getExternalStorageDirectory().canWrite();
            this.isWriteRead = true;
        }
        return this.canWrite;
    }

    private void notifyObservers(boolean z16) {
        int size;
        SDCardMountStateListener[] sDCardMountStateListenerArr;
        synchronized (this.observers) {
            size = this.observers.size();
            sDCardMountStateListenerArr = new SDCardMountStateListener[size];
            this.observers.toArray(sDCardMountStateListenerArr);
        }
        for (int i3 = 0; i3 < size; i3++) {
            sDCardMountStateListenerArr[i3].onSDCardMountStateChange(z16);
        }
    }

    public void addListener(SDCardMountStateListener sDCardMountStateListener) {
        if (sDCardMountStateListener == null) {
            return;
        }
        synchronized (this.observers) {
            if (!this.observers.contains(sDCardMountStateListener)) {
                this.observers.add(sDCardMountStateListener);
            }
        }
    }

    public boolean isSDCardCanWrite() {
        if (isSDCardMount() && isCanWrite()) {
            return true;
        }
        return false;
    }

    public boolean isSDCardMount() {
        if (!this.isMountRead) {
            try {
                this.mIsSDCardMount = "mounted".equals(Environment.getExternalStorageState());
                this.isMountRead = true;
            } catch (Exception e16) {
                QLog.w(CacheManager.TAG, 2, "getExternalStorageState error:" + e16.getMessage());
            }
        }
        return this.mIsSDCardMount;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean equals = "mounted".equals(Environment.getExternalStorageState());
        this.mIsSDCardMount = equals;
        if (equals) {
            this.canWrite = Environment.getExternalStorageDirectory().canWrite();
            this.isWriteRead = true;
        }
        this.isMountRead = true;
        CacheManager.onStorageMountChange();
        notifyObservers(this.mIsSDCardMount);
        QLog.i(CacheManager.TAG, 1, "SDCardMountMonitorReceiver onReceive mIsSDCardMount:" + this.mIsSDCardMount + ",canWrite" + this.canWrite);
    }

    public void registerReceiver() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addDataScheme("file");
            BaseApplication.getContext().registerReceiver(this, intentFilter);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.mIsRegisteReceiver = true;
    }

    public void removeListener(SDCardMountStateListener sDCardMountStateListener) {
        synchronized (this.observers) {
            this.observers.remove(sDCardMountStateListener);
        }
    }

    public void unregisterReceiver() {
        SDCardMountMonitorReceiver sDCardMountMonitorReceiver = mInstance;
        if (sDCardMountMonitorReceiver != null && sDCardMountMonitorReceiver.mIsRegisteReceiver) {
            BaseApplication.getContext().unregisterReceiver(mInstance);
            mInstance.mIsRegisteReceiver = false;
        }
    }
}
