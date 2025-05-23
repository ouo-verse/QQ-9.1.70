package cooperation.qqcircle.report;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import uq3.g;

/* loaded from: classes28.dex */
public abstract class BaseMultiProcessSingleton {
    private static final String ACTION_MULTI_PROCESS_SINGLETON = "action_multi_process_singleton";
    private static final String KEY_PROCESS_DATA_UPDATE = "key_process_data_update_";
    private static final String TAG = "BaseMultiProcessSingleton";
    private ConcurrentHashMap<String, Object> mDataMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public class MultiProcessBroadcastReceiver extends BroadcastReceiver {
        MultiProcessBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle bundleExtra;
            if (intent != null && TextUtils.equals(intent.getAction(), BaseMultiProcessSingleton.ACTION_MULTI_PROCESS_SINGLETON) && (bundleExtra = intent.getBundleExtra(BaseMultiProcessSingleton.KEY_PROCESS_DATA_UPDATE)) != null) {
                BaseMultiProcessSingleton.this.updateDataMap(bundleExtra);
                BaseMultiProcessSingleton.this.updateSpData(bundleExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseMultiProcessSingleton() {
        initBroadcast();
    }

    private void initBroadcast() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_init_broadcast_on_sub_thread", true)) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qqcircle.report.BaseMultiProcessSingleton.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseMultiProcessSingleton.this.realInitBroadcast();
                }
            });
        } else {
            realInitBroadcast();
        }
    }

    private synchronized void putDataMap(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.mDataMap.put(str, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realInitBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_MULTI_PROCESS_SINGLETON);
        MobileQQ.sMobileQQ.registerReceiver(new MultiProcessBroadcastReceiver(), intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDataMap(Bundle bundle) {
        try {
            if (bundle == null) {
                QLog.e(TAG, 1, "updateDataMap  bundle == null");
                return;
            }
            for (String str : bundle.keySet()) {
                putDataMap(str, bundle.get(str));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "updateDataMap exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpData(final Bundle bundle) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.BaseMultiProcessSingleton.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bundle bundle2 = bundle;
                    if (bundle2 == null) {
                        QLog.e(BaseMultiProcessSingleton.TAG, 1, "updateSpData  bundle == null");
                        return;
                    }
                    for (String str : bundle2.keySet()) {
                        g.e(BaseMultiProcessSingleton.KEY_PROCESS_DATA_UPDATE + str, bundle.get(str));
                    }
                    QLog.i(BaseMultiProcessSingleton.TAG, 1, "onReceive  bundle = " + bundle);
                } catch (Exception e16) {
                    QLog.e(BaseMultiProcessSingleton.TAG, 1, "updateSpData exception", e16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getMultiProcessData(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "getMultiProcessData  key == null");
            return obj;
        }
        Object obj2 = this.mDataMap.get(str);
        if (obj2 == null) {
            Object d16 = g.d(KEY_PROCESS_DATA_UPDATE + str, obj);
            putDataMap(str, d16);
            return d16;
        }
        return obj2;
    }

    protected void realUpdateMultiProcessData(Bundle bundle) {
        if (bundle == null) {
            QLog.e(TAG, 1, "updateMultiProcessData  bundle == null");
            return;
        }
        updateDataMap(bundle);
        Intent intent = new Intent();
        intent.setAction(ACTION_MULTI_PROCESS_SINGLETON);
        intent.putExtra(KEY_PROCESS_DATA_UPDATE, bundle);
        MobileQQ.sMobileQQ.sendBroadcast(intent);
        updateSpData(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateMultiProcessData(final Bundle bundle) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_init_broadcast_on_sub_thread", true)) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qqcircle.report.BaseMultiProcessSingleton.2
                @Override // java.lang.Runnable
                public void run() {
                    BaseMultiProcessSingleton.this.realUpdateMultiProcessData(bundle);
                }
            });
        } else {
            realUpdateMultiProcessData(bundle);
        }
    }
}
