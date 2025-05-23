package com.heytap.databaseengine.apiv2.common;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.text.TextUtils;
import com.heytap.databaseengine.IBinderPool;
import com.heytap.databaseengine.apiv2.IAuthorityManager;
import com.heytap.databaseengine.apiv2.ISportHealthManager;
import com.heytap.databaseengine.apiv2.IUserInfoManager;
import com.heytap.databaseengine.apiv2._HeytapHealth;
import com.heytap.databaseengine.apiv2.common.util.InstallUtils;
import com.heytap.databaseengine.apiv2.device.IDeviceInfoManager;
import com.heytap.databaseengine.apiv2.device.game.IDeviceGame;
import com.heytap.databaseengine.constant.AppType;
import com.heytap.databaseengine.constant.InterfaceName;
import com.heytap.databaseengine.utils.HLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HRemoteService {
    private static final String ACTION_DATA = "com.heytap.health.dataservice";
    private static final String ACTION_DEVICE = "com.heytap.health.deviceservice";
    private static final String TAG = "HRemoteService";
    private IBinderPool mBinderPool;
    private HashMap<String, IInterface> mRemoteServiceMap;
    private HashMap<String, String> mServiceActionMap;
    private final Object waitBindSuccessLock;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class Holder {
        private static final HRemoteService sInstance = new HRemoteService();

        Holder() {
        }
    }

    private <T extends IInterface> void bind(Intent intent, final Class<T> cls) {
        HLog.i(TAG, "start bind service");
        _HeytapHealth.getContext().bindService(intent, new ServiceConnection() { // from class: com.heytap.databaseengine.apiv2.common.HRemoteService.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                char c16;
                HLog.i(HRemoteService.TAG, "onServiceConnected: enter");
                String str = (String) HRemoteService.this.mServiceActionMap.get(cls.getName());
                if (str != null && !TextUtils.isEmpty(str)) {
                    HRemoteService.this.mBinderPool = IBinderPool.Stub.asInterface(iBinder);
                    str.hashCode();
                    if (!str.equals(HRemoteService.ACTION_DATA)) {
                        if (str.equals(HRemoteService.ACTION_DEVICE)) {
                            HRemoteService.this.mRemoteServiceMap.put(IDeviceGame.class.getName(), IDeviceGame.Stub.asInterface(iBinder));
                        }
                    } else {
                        try {
                            String simpleName = cls.getSimpleName();
                            switch (simpleName.hashCode()) {
                                case -305179232:
                                    if (simpleName.equals(InterfaceName.I_DEVICE_MANAGER_NAME)) {
                                        c16 = 1;
                                        break;
                                    }
                                    c16 = '\uffff';
                                    break;
                                case 1167015627:
                                    if (simpleName.equals(InterfaceName.I_USER_INFO_MANAGER_NAME)) {
                                        c16 = 2;
                                        break;
                                    }
                                    c16 = '\uffff';
                                    break;
                                case 1223364947:
                                    if (simpleName.equals(InterfaceName.I_AUTHORITY_MANAGER_NAME)) {
                                        c16 = 3;
                                        break;
                                    }
                                    c16 = '\uffff';
                                    break;
                                case 1689839302:
                                    if (simpleName.equals(InterfaceName.I_SPORT_HEALTH_MANAGER_NAME)) {
                                        c16 = 0;
                                        break;
                                    }
                                    c16 = '\uffff';
                                    break;
                                default:
                                    c16 = '\uffff';
                                    break;
                            }
                            if (c16 != 0) {
                                if (c16 != 1) {
                                    if (c16 != 2) {
                                        if (c16 == 3) {
                                            HRemoteService.this.mRemoteServiceMap.put(cls.getName(), IAuthorityManager.Stub.asInterface(HRemoteService.this.mBinderPool.queryBinder(cls.getSimpleName())));
                                        }
                                    } else {
                                        HRemoteService.this.mRemoteServiceMap.put(cls.getName(), IUserInfoManager.Stub.asInterface(HRemoteService.this.mBinderPool.queryBinder(cls.getSimpleName())));
                                    }
                                } else {
                                    HRemoteService.this.mRemoteServiceMap.put(cls.getName(), IDeviceInfoManager.Stub.asInterface(HRemoteService.this.mBinderPool.queryBinder(cls.getSimpleName())));
                                }
                            } else {
                                HRemoteService.this.mRemoteServiceMap.put(cls.getName(), ISportHealthManager.Stub.asInterface(HRemoteService.this.mBinderPool.queryBinder(cls.getSimpleName())));
                            }
                        } catch (RemoteException e16) {
                            HLog.e(HRemoteService.TAG, e16.toString());
                        }
                    }
                    if (HRemoteService.this.mRemoteServiceMap.get(cls.getName()) == null) {
                        HLog.w(HRemoteService.TAG, "bind object is null!");
                    }
                    synchronized (HRemoteService.this.waitBindSuccessLock) {
                        HRemoteService.this.waitBindSuccessLock.notifyAll();
                    }
                    HLog.i(HRemoteService.TAG, "onServiceConnected success name is: " + componentName + " time is: " + System.currentTimeMillis());
                    return;
                }
                HLog.e(HRemoteService.TAG, "action is null");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                HLog.d(HRemoteService.TAG, "onServiceDisconnected: enter");
                HRemoteService.this.mRemoteServiceMap.remove(cls.getName());
            }
        }, 1);
    }

    private synchronized <T extends IInterface> void bindService(Class<T> cls) throws PackageManager.NameNotFoundException {
        if (this.mRemoteServiceMap.get(cls.getName()) != null) {
            return;
        }
        if (InstallUtils.isAppInstalled(_HeytapHealth.getContext(), AppType.HEALTH_PACKAGE_NAME)) {
            if (InstalledAppListMonitor.getPackageInfo(_HeytapHealth.getContext().getPackageManager(), AppType.HEALTH_PACKAGE_NAME, 0).versionCode >= 3180000) {
                Intent intent = new Intent(this.mServiceActionMap.get(cls.getName()));
                intent.setPackage(AppType.HEALTH_PACKAGE_NAME);
                if (createExplicitIntent(intent) != null) {
                    bind(intent, cls);
                    synchronized (this.waitBindSuccessLock) {
                        try {
                        } catch (InterruptedException e16) {
                            HLog.e(TAG, "bindService() InterruptedException = " + e16.getMessage());
                        }
                        if (this.mRemoteServiceMap.get(cls.getName()) != null) {
                            HLog.i(TAG, "bind object is not null = " + this.mRemoteServiceMap.get(cls.getName()));
                            return;
                        }
                        this.waitBindSuccessLock.wait(10000L);
                        HLog.i(TAG, "bindService bind over bind object is: " + this.mRemoteServiceMap.get(cls.getName()) + " endTime is: " + System.currentTimeMillis());
                        return;
                    }
                }
                HLog.w(TAG, "bindService: explicitIntent is null!");
                throw new NullPointerException("explicitIntent is null");
            }
            throw new IllegalStateException("Health APP version is too low.");
        }
        throw new PackageManager.NameNotFoundException("call method InstallUtils.DownloadApp to start install health app");
    }

    private Intent createExplicitIntent(Intent intent) {
        if (InstalledAppListMonitor.queryIntentServices(_HeytapHealth.getContext().getPackageManager(), intent, 0).size() != 1) {
            return null;
        }
        return intent;
    }

    public static HRemoteService getInstance() {
        return Holder.sInstance;
    }

    public HashMap<String, IInterface> getmRemoteServiceMap() {
        return this.mRemoteServiceMap;
    }

    public <T extends IInterface> T remoteApi(Class<T> cls) throws PackageManager.NameNotFoundException {
        if (this.mRemoteServiceMap.get(cls.getName()) == null) {
            bindService(cls);
        }
        return (T) this.mRemoteServiceMap.get(cls.getName());
    }

    HRemoteService() {
        this.waitBindSuccessLock = new Object();
        this.mRemoteServiceMap = new HashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        this.mServiceActionMap = hashMap;
        hashMap.put(ISportHealthManager.class.getName(), ACTION_DATA);
        this.mServiceActionMap.put(IDeviceInfoManager.class.getName(), ACTION_DATA);
        this.mServiceActionMap.put(IUserInfoManager.class.getName(), ACTION_DATA);
        this.mServiceActionMap.put(IAuthorityManager.class.getName(), ACTION_DATA);
        this.mServiceActionMap.put(IDeviceGame.class.getName(), ACTION_DEVICE);
    }
}
