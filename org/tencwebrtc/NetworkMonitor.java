package org.tencwebrtc;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.tencwebrtc.NetworkMonitorAutoDetect;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NetworkMonitor {
    private static final String TAG = "NetworkMonitor";

    @Nullable
    private NetworkMonitorAutoDetect autoDetect;
    private final Object autoDetectLock;
    private volatile NetworkMonitorAutoDetect.ConnectionType currentConnectionType;
    private final ArrayList<Long> nativeNetworkObservers;
    private final ArrayList<NetworkObserver> networkObservers;
    private int numObservers;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class InstanceHolder {
        static final NetworkMonitor instance = new NetworkMonitor();

        InstanceHolder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface NetworkObserver {
        void onConnectionTypeChanged(NetworkMonitorAutoDetect.ConnectionType connectionType);
    }

    @Deprecated
    public static void addNetworkObserver(NetworkObserver networkObserver) {
        getInstance().addObserver(networkObserver);
    }

    @CalledByNative
    private static int androidSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    private static void assertIsTrue(boolean z16) {
        if (z16) {
        } else {
            throw new AssertionError("Expected to be true");
        }
    }

    static NetworkMonitorAutoDetect createAndSetAutoDetectForTest(Context context) {
        NetworkMonitor networkMonitor = getInstance();
        NetworkMonitorAutoDetect createAutoDetect = networkMonitor.createAutoDetect(context);
        networkMonitor.autoDetect = createAutoDetect;
        return createAutoDetect;
    }

    private NetworkMonitorAutoDetect createAutoDetect(Context context) {
        return new NetworkMonitorAutoDetect(new NetworkMonitorAutoDetect.Observer() { // from class: org.tencwebrtc.NetworkMonitor.1
            @Override // org.tencwebrtc.NetworkMonitorAutoDetect.Observer
            public void onConnectionTypeChanged(NetworkMonitorAutoDetect.ConnectionType connectionType) {
                NetworkMonitor.this.updateCurrentConnectionType(connectionType);
                Logging.d("NetworkMonitor", "onConnectionTypeChanged: " + connectionType);
            }

            @Override // org.tencwebrtc.NetworkMonitorAutoDetect.Observer
            public void onNetworkConnect(NetworkMonitorAutoDetect.NetworkInformation networkInformation) {
                NetworkMonitor.this.notifyObserversOfNetworkConnect(networkInformation);
                for (int i3 = 0; i3 < networkInformation.ipAddresses.length; i3++) {
                    Logging.d("NetworkMonitor", "onNetworkConnect notifyObserversOfNetworkConnect, " + i3 + " ip, name=" + networkInformation.name + ", handle=" + networkInformation.handle + ", address=" + Arrays.toString(networkInformation.ipAddresses[i3].address));
                }
            }

            @Override // org.tencwebrtc.NetworkMonitorAutoDetect.Observer
            public void onNetworkDisconnect(long j3) {
                NetworkMonitor.this.notifyObserversOfNetworkDisconnect(j3);
                Logging.d("NetworkMonitor", "notifyObserversOfNetworkDisconnect: handle=" + j3);
            }
        }, context);
    }

    private NetworkMonitorAutoDetect.ConnectionType getCurrentConnectionType() {
        return this.currentConnectionType;
    }

    private long getCurrentDefaultNetId() {
        long defaultNetId;
        synchronized (this.autoDetectLock) {
            NetworkMonitorAutoDetect networkMonitorAutoDetect = this.autoDetect;
            if (networkMonitorAutoDetect == null) {
                defaultNetId = -1;
            } else {
                defaultNetId = networkMonitorAutoDetect.getDefaultNetId();
            }
        }
        return defaultNetId;
    }

    @CalledByNative
    public static NetworkMonitor getInstance() {
        return InstanceHolder.instance;
    }

    private List<Long> getNativeNetworkObserversSync() {
        ArrayList arrayList;
        synchronized (this.nativeNetworkObservers) {
            arrayList = new ArrayList(this.nativeNetworkObservers);
        }
        return arrayList;
    }

    public static boolean isOnline() {
        if (getInstance().getCurrentConnectionType() != NetworkMonitorAutoDetect.ConnectionType.CONNECTION_NONE) {
            return true;
        }
        return false;
    }

    private native void nativeNotifyConnectionTypeChanged(long j3);

    private native void nativeNotifyOfActiveNetworkList(long j3, NetworkMonitorAutoDetect.NetworkInformation[] networkInformationArr);

    private native void nativeNotifyOfNetworkConnect(long j3, NetworkMonitorAutoDetect.NetworkInformation networkInformation);

    private native void nativeNotifyOfNetworkDisconnect(long j3, long j16);

    @CalledByNative
    private boolean networkBindingSupported() {
        boolean z16;
        synchronized (this.autoDetectLock) {
            NetworkMonitorAutoDetect networkMonitorAutoDetect = this.autoDetect;
            if (networkMonitorAutoDetect != null && networkMonitorAutoDetect.supportNetworkCallback()) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    private void notifyObserversOfConnectionTypeChange(NetworkMonitorAutoDetect.ConnectionType connectionType) {
        ArrayList arrayList;
        Iterator<Long> it = getNativeNetworkObserversSync().iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue());
        }
        synchronized (this.networkObservers) {
            arrayList = new ArrayList(this.networkObservers);
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((NetworkObserver) it5.next()).onConnectionTypeChanged(connectionType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyObserversOfNetworkConnect(NetworkMonitorAutoDetect.NetworkInformation networkInformation) {
        try {
            Iterator<Long> it = getNativeNetworkObserversSync().iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkConnect(it.next().longValue(), networkInformation);
            }
        } catch (Throwable th5) {
            Logging.d("NetworkMonitor", "notifyObserversOfNetworkDisconnect: " + th5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyObserversOfNetworkDisconnect(long j3) {
        try {
            Iterator<Long> it = getNativeNetworkObserversSync().iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkDisconnect(it.next().longValue(), j3);
            }
        } catch (Throwable th5) {
            Logging.d("NetworkMonitor", "notifyObserversOfNetworkDisconnect: " + th5.toString());
        }
    }

    @Deprecated
    public static void removeNetworkObserver(NetworkObserver networkObserver) {
        getInstance().removeObserver(networkObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentConnectionType(NetworkMonitorAutoDetect.ConnectionType connectionType) {
        this.currentConnectionType = connectionType;
        notifyObserversOfConnectionTypeChange(connectionType);
    }

    private void updateObserverActiveNetworkList(long j3) {
        List<NetworkMonitorAutoDetect.NetworkInformation> activeNetworkList;
        synchronized (this.autoDetectLock) {
            NetworkMonitorAutoDetect networkMonitorAutoDetect = this.autoDetect;
            if (networkMonitorAutoDetect == null) {
                activeNetworkList = null;
            } else {
                activeNetworkList = networkMonitorAutoDetect.getActiveNetworkList();
            }
        }
        if (activeNetworkList != null && activeNetworkList.size() != 0) {
            NetworkMonitorAutoDetect.NetworkInformation[] networkInformationArr = (NetworkMonitorAutoDetect.NetworkInformation[]) activeNetworkList.toArray(new NetworkMonitorAutoDetect.NetworkInformation[activeNetworkList.size()]);
            Logging.d("NetworkMonitor", "updateObserverActiveNetworkList networkInfoList.size()=" + activeNetworkList.size() + ", networkInfos.length=" + networkInformationArr.length);
            nativeNotifyOfActiveNetworkList(j3, networkInformationArr);
            return;
        }
        Logging.w("NetworkMonitor", "updateObserverActiveNetworkList networkInfoList == null || networkInfoList.size() == 0");
    }

    public void addObserver(NetworkObserver networkObserver) {
        synchronized (this.networkObservers) {
            this.networkObservers.add(networkObserver);
        }
    }

    @Nullable
    NetworkMonitorAutoDetect getNetworkMonitorAutoDetect() {
        NetworkMonitorAutoDetect networkMonitorAutoDetect;
        synchronized (this.autoDetectLock) {
            networkMonitorAutoDetect = this.autoDetect;
        }
        return networkMonitorAutoDetect;
    }

    int getNumObservers() {
        int i3;
        synchronized (this.autoDetectLock) {
            i3 = this.numObservers;
        }
        return i3;
    }

    public void removeObserver(NetworkObserver networkObserver) {
        synchronized (this.networkObservers) {
            this.networkObservers.remove(networkObserver);
        }
    }

    public void startMonitoring(Context context) {
        synchronized (this.autoDetectLock) {
            this.numObservers++;
            try {
                if (this.autoDetect == null) {
                    this.autoDetect = createAutoDetect(context);
                }
                NetworkMonitorAutoDetect networkMonitorAutoDetect = this.autoDetect;
                if (networkMonitorAutoDetect == null) {
                    return;
                }
                this.currentConnectionType = NetworkMonitorAutoDetect.getConnectionType(networkMonitorAutoDetect.getCurrentNetworkState());
            } catch (Throwable th5) {
                Logging.d("NetworkMonitor", "Start monitoring with createAutoDetect, numObservers: " + this.numObservers + th5.toString());
            }
        }
    }

    public void stopMonitoring() {
        NetworkMonitorAutoDetect networkMonitorAutoDetect;
        synchronized (this.autoDetectLock) {
            try {
                int i3 = this.numObservers - 1;
                this.numObservers = i3;
                if (i3 == 0 && (networkMonitorAutoDetect = this.autoDetect) != null) {
                    networkMonitorAutoDetect.destroy();
                    this.autoDetect = null;
                }
            } finally {
            }
        }
    }

    NetworkMonitor() {
        this.autoDetectLock = new Object();
        this.nativeNetworkObservers = new ArrayList<>();
        this.networkObservers = new ArrayList<>();
        this.numObservers = 0;
        this.currentConnectionType = NetworkMonitorAutoDetect.ConnectionType.CONNECTION_UNKNOWN;
    }

    @CalledByNative
    private void stopMonitoring(long j3) {
        Logging.d("NetworkMonitor", "Stop monitoring with native observer " + j3);
        stopMonitoring();
        synchronized (this.nativeNetworkObservers) {
            this.nativeNetworkObservers.remove(Long.valueOf(j3));
        }
    }

    @Deprecated
    public void startMonitoring() {
        startMonitoring(ContextUtils.getApplicationContext());
    }

    @CalledByNative
    private void startMonitoring(@Nullable Context context, long j3) {
        try {
            Logging.d("NetworkMonitor", "Start monitoring with native observer " + j3);
            if (context == null) {
                context = ContextUtils.getApplicationContext();
            }
            startMonitoring(context);
            synchronized (this.nativeNetworkObservers) {
                this.nativeNetworkObservers.add(Long.valueOf(j3));
            }
            updateObserverActiveNetworkList(j3);
            notifyObserversOfConnectionTypeChange(this.currentConnectionType);
        } catch (Throwable th5) {
            Logging.d("NetworkMonitor", "stopMonitoring with native observer" + th5.toString());
        }
    }

    @Deprecated
    public static void init(Context context) {
    }
}
