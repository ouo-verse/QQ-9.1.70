package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.HashMap;

/* compiled from: P */
@ExperimentalRoomApi
/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {
    int mMaxClientId = 0;
    final HashMap<Integer, String> mClientNames = new HashMap<>();
    final RemoteCallbackList<IMultiInstanceInvalidationCallback> mCallbackList = new RemoteCallbackList<IMultiInstanceInvalidationCallback>() { // from class: androidx.room.MultiInstanceInvalidationService.1
        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
            MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    };
    private final IMultiInstanceInvalidationService.Stub mBinder = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService.2
        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int i3, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                String str = MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(i3));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.mCallbackList.beginBroadcast();
                for (int i16 = 0; i16 < beginBroadcast; i16++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.mCallbackList.getBroadcastCookie(i16)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(intValue));
                        if (i3 != intValue && str.equals(str2)) {
                            try {
                                MultiInstanceInvalidationService.this.mCallbackList.getBroadcastItem(i16).onInvalidation(strArr);
                            } catch (RemoteException e16) {
                                Log.w("ROOM", "Error invoking a remote callback", e16);
                            }
                        }
                    } finally {
                        MultiInstanceInvalidationService.this.mCallbackList.finishBroadcast();
                    }
                }
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i3 = multiInstanceInvalidationService.mMaxClientId + 1;
                multiInstanceInvalidationService.mMaxClientId = i3;
                if (multiInstanceInvalidationService.mCallbackList.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i3))) {
                    MultiInstanceInvalidationService.this.mClientNames.put(Integer.valueOf(i3), str);
                    return i3;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.mMaxClientId--;
                return 0;
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i3) {
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                MultiInstanceInvalidationService.this.mCallbackList.unregister(iMultiInstanceInvalidationCallback);
                MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(i3));
            }
        }
    };

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NonNull Intent intent) {
        return this.mBinder;
    }
}
