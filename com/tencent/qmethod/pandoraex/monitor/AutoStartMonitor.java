package com.tencent.qmethod.pandoraex.monitor;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AutoStartMonitor {
    public static final String BUNDLE_REPLACE_TEXT = "has extras";
    public static final boolean ENABLE;
    private static final AtomicBoolean INIT_LOCK = new AtomicBoolean(false);
    private static final Object LOCK;
    private static final String TAG = "PandoraEx.AutoMonitor";
    public static final int TYPE_ACTIVITY_ON_CREATE = -1;
    public static final int TYPE_PROVIDER_DELETE = 6;
    public static final int TYPE_PROVIDER_GET_TYPE = 9;
    public static final int TYPE_PROVIDER_INSERT = 5;
    public static final int TYPE_PROVIDER_ON_CREATE = 4;
    public static final int TYPE_PROVIDER_QUERY = 8;
    public static final int TYPE_PROVIDER_UPDATE = 7;
    public static final int TYPE_RECEIVER_ON_RECEIVE = 3;
    public static final int TYPE_RELATION_BROADCAST = 10;
    public static final int TYPE_RELATION_PROVIDER = 12;
    public static final int TYPE_RELATION_SERVICE = 11;
    public static final int TYPE_SERVICE_ON_BIND = 1;
    public static final int TYPE_SERVICE_ON_CREATE = 0;
    public static final int TYPE_SERVICE_ON_START = 2;
    private static ComponentStartListener componentStartListener;
    private static AutoStartBean firstStartInfo;
    private static final ArrayList<String> ignoreList;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class AutoStartBean {
        public static final String KEY_ACTION = "KEY_ACTION";
        public static final String KEY_AUTO_CALL_SELF = "AutoCallSelf";
        public static final String KEY_BINDER_PID = "CallingPid";
        public static final String KEY_BINDER_UID = "CallingUid";
        public static final String KEY_CALLEE_PID = "CalleePid";
        public static final String KEY_CALLEE_UID = "CalleeUid";
        public static final String KEY_INTENT = "KEY_INTENT";
        public static final String KEY_PROVIDER_URI = "KEY_PROVIDER_URI";
        public static final String KEY_TRACE = "Trace";
        String componentInfo;
        HashMap<String, Object> extraInfo = new HashMap<>();
        long timeStamp;
        int type;

        public void addExtraInfo(String str, Object obj) {
            this.extraInfo.put(str, obj);
        }

        public String getComponentInfo() {
            return this.componentInfo;
        }

        @Nullable
        public Object getExtraInfo(String str) {
            return this.extraInfo.get(str);
        }

        public long getTimeStamp() {
            return this.timeStamp;
        }

        public int getType() {
            return this.type;
        }

        public void setComponentInfo(String str) {
            this.componentInfo = str;
        }

        public void setTimeStamp(long j3) {
            this.timeStamp = j3;
        }

        public void setType(int i3) {
            this.type = i3;
        }

        @NonNull
        public String toString() {
            return "AutoStartBean{type=" + this.type + ", componentInfo='" + this.componentInfo + "', timeStamp=" + this.timeStamp + ", extraInfo=" + this.extraInfo + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface ComponentStartListener {
        void onFirstStart(AutoStartBean autoStartBean, @Nullable Object obj, @Nullable Object[] objArr);
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        ignoreList = arrayList;
        componentStartListener = null;
        LOCK = new Object();
        firstStartInfo = null;
        ENABLE = autoStartDisable();
        arrayList.add("android.appwidget.action.APPWIDGET_UPDATE");
        arrayList.add("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS");
        arrayList.add("android.appwidget.action.APPWIDGET_ENABLED");
        arrayList.add("com.xiaomi.mipush.RECEIVE_MESSAGE");
        arrayList.add("com.coloros.mcs.action.RECEIVE_MCS_MESSAGE");
        arrayList.add("com.heytap.mcs.action.RECEIVE_MCS_MESSAGE");
        arrayList.add("com.vivo.videopathway.VIDEO_PHONE_ORIGIN_SERVICE");
        arrayList.add("com.huawei.push.msg.NOTIFY_MSG");
        arrayList.add("com.huawei.intent.action.PUSH");
        arrayList.add("com.huawei.android.push.intent.REGISTRATION");
        arrayList.add("com.tencent.tinker.lib.service.TinkerPatchForeService");
        arrayList.add("com.tencent.luggage.wxa.standalone_open_runtime.app.WxaIPCMainService");
        arrayList.add("com.meizu.cloud.pushsdk.NotificationService");
        arrayList.add("com.heytap.msp.push.service.DataMessageCallbackService");
        arrayList.add("com.heytap.msp.push.service.CompatibleDataMessageCallbackService");
        arrayList.add("com.huawei.hms.support.api.push.service.HmsMsgService");
        arrayList.add("com.huawei.hms.support.api.push.PushMsgReceiver");
        arrayList.add("com.huawei.hms.support.api.push.PushReceiver");
        arrayList.add("com.xiaomi.push.service.receivers.PingReceiver");
        arrayList.add("com.xiaomi.push.service.XMPushService");
        arrayList.add("com.tencent.tpns.baseapi.base.SettingsContentProvider");
        arrayList.add("com.tencent.android.tpush.service.XGVipPushService");
        arrayList.add("com.tencent.android.tpush.XGPushProvider");
        arrayList.add("com.tencent.android.tpush.rpc.XGRemoteService");
        arrayList.add("com.tencent.android.tpush.XGPushReceiver");
    }

    AutoStartMonitor() {
    }

    public static void activityOnCreate(Activity activity) {
        ComponentName componentName = activity.getComponentName();
        componentStart(-1, componentName.getPackageName() + "/" + componentName.getClassName(), activity, new Object[0]);
    }

    private static boolean autoStartDisable() {
        return false;
    }

    public static boolean autoStartEnable() {
        return true;
    }

    private static void componentStart(int i3, String str, Object obj, Object... objArr) {
        if (!ENABLE || i3 == 4 || filterComponent(i3, str, obj, objArr) || INIT_LOCK.getAndSet(true)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            StackTraceElement[] stackTrace = new Exception().getStackTrace();
            StringBuilder sb5 = new StringBuilder();
            if (stackTrace.length > 2) {
                StackTraceElement stackTraceElement = stackTrace[2];
                sb5.append(stackTraceElement.getClassName());
                sb5.append(".");
                sb5.append(stackTraceElement.getMethodName());
                if (stackTraceElement.isNativeMethod()) {
                    sb5.append("(Native Method)");
                } else if (stackTraceElement.getFileName() != null) {
                    sb5.append("(");
                    sb5.append(stackTraceElement.getFileName());
                    sb5.append(")");
                } else {
                    sb5.append("(Unknown Source)");
                }
            }
            str = sb5.toString();
        }
        Log.d(TAG, "componentStart, type=" + i3 + ", name=" + str);
        AutoStartBean autoStartBean = new AutoStartBean();
        autoStartBean.type = i3;
        autoStartBean.componentInfo = str;
        autoStartBean.timeStamp = System.currentTimeMillis();
        updateExtraInfo(autoStartBean, i3, obj, objArr);
        synchronized (LOCK) {
            ComponentStartListener componentStartListener2 = componentStartListener;
            if (componentStartListener2 != null) {
                componentStartListener2.onFirstStart(autoStartBean, obj, objArr);
            } else {
                firstStartInfo = autoStartBean;
            }
        }
    }

    private static boolean filterComponent(int i3, String str, Object obj, Object... objArr) {
        String action;
        if (!TextUtils.isEmpty(str) && ignoreList.contains(str)) {
            Log.d(TAG, "filter:" + str);
            return true;
        }
        if ((i3 == 1 || i3 == 2) && objArr.length > 0) {
            Object obj2 = objArr[0];
            if ((obj2 instanceof Intent) && (action = ((Intent) obj2).getAction()) != null && ignoreList.contains(action)) {
                Log.d(TAG, "filter:" + action);
                return true;
            }
        }
        return false;
    }

    public static String getBundleDataShort(Bundle bundle) {
        String str;
        if (bundle == null) {
            return BUNDLE_REPLACE_TEXT;
        }
        StringBuilder sb5 = new StringBuilder("Extra{");
        try {
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = "null";
                }
                sb5.append(str2);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                if (str.length() > 16) {
                    str = str.substring(0, 15);
                }
                sb5.append(str);
            }
        } catch (Throwable th5) {
            Log.e(TAG, "getBundleDataShort error", th5);
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static void providerDelete(ContentProvider contentProvider, Uri uri, String str, String[] strArr) {
        componentStart(6, contentProvider.getClass().getName(), contentProvider, uri, str, strArr);
    }

    public static void providerGetType(ContentProvider contentProvider, Uri uri) {
        componentStart(9, contentProvider.getClass().getName(), contentProvider, uri);
    }

    public static void providerInsert(ContentProvider contentProvider, Uri uri, ContentValues contentValues) {
        componentStart(5, contentProvider.getClass().getName(), contentProvider, uri, contentValues);
    }

    public static void providerOnCreate(ContentProvider contentProvider) {
        componentStart(4, contentProvider.getClass().getName(), contentProvider, new Object[0]);
    }

    public static void providerQuery(ContentProvider contentProvider, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        componentStart(8, contentProvider.getClass().getName(), contentProvider, uri, strArr, str, strArr2, str2);
    }

    public static void providerUpdate(ContentProvider contentProvider, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        componentStart(7, contentProvider.getClass().getName(), contentProvider, uri, contentValues, str, strArr);
    }

    public static void receiveOnReceive(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        componentStart(3, broadcastReceiver.getClass().getName(), broadcastReceiver, context, intent);
    }

    public static void serviceOnBind(Service service, Intent intent) {
        componentStart(1, service.getClass().getName(), service, intent);
    }

    public static void serviceOnCreate(Service service) {
        componentStart(0, service.getClass().getName(), service, new Object[0]);
    }

    public static void serviceOnStartCommand(Service service, Intent intent, int i3, int i16) {
        componentStart(2, service.getClass().getName(), service, intent, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public static void setListener(ComponentStartListener componentStartListener2) {
        AutoStartBean autoStartBean;
        synchronized (LOCK) {
            if (componentStartListener2 != null) {
                if (componentStartListener == null && (autoStartBean = firstStartInfo) != null) {
                    componentStartListener2.onFirstStart(autoStartBean, null, null);
                }
            }
            componentStartListener = componentStartListener2;
        }
    }

    private static void updateBroadcastReceiverExtraInfo(AutoStartBean autoStartBean, int i3, Object[] objArr) {
        if (i3 == 3 && objArr.length == 2) {
            Object obj = objArr[1];
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                String action = intent.getAction();
                if (action != null) {
                    autoStartBean.extraInfo.put(AutoStartBean.KEY_ACTION, action);
                }
                autoStartBean.extraInfo.put(AutoStartBean.KEY_INTENT, intent.toString().replace(BUNDLE_REPLACE_TEXT, getBundleDataShort(intent.getExtras())));
            }
        }
    }

    private static void updateContentProviderExtraInfo(AutoStartBean autoStartBean, Object[] objArr) {
        if (objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof Uri) {
                autoStartBean.extraInfo.put(AutoStartBean.KEY_PROVIDER_URI, obj.toString());
            }
        }
    }

    private static void updateExtraInfo(AutoStartBean autoStartBean, int i3, Object obj, Object[] objArr) {
        if (obj instanceof ContentProvider) {
            updateContentProviderExtraInfo(autoStartBean, objArr);
        } else if (obj instanceof Service) {
            updateServiceProviderExtraInfo(autoStartBean, objArr);
        } else if (obj instanceof BroadcastReceiver) {
            updateBroadcastReceiverExtraInfo(autoStartBean, i3, objArr);
        }
        updateGeneralExtraInfo(autoStartBean);
    }

    private static void updateGeneralExtraInfo(AutoStartBean autoStartBean) {
        int i3;
        try {
            int callingPid = Binder.getCallingPid();
            int myPid = Process.myPid();
            HashMap<String, Object> hashMap = autoStartBean.extraInfo;
            if (callingPid == myPid) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            hashMap.put(AutoStartBean.KEY_AUTO_CALL_SELF, Integer.valueOf(i3));
            autoStartBean.extraInfo.put(AutoStartBean.KEY_BINDER_PID, Integer.valueOf(callingPid));
            autoStartBean.extraInfo.put(AutoStartBean.KEY_BINDER_UID, Integer.valueOf(Binder.getCallingUid()));
            autoStartBean.extraInfo.put(AutoStartBean.KEY_CALLEE_PID, Integer.valueOf(myPid));
            autoStartBean.extraInfo.put(AutoStartBean.KEY_CALLEE_UID, Integer.valueOf(Process.myUid()));
        } catch (Throwable unused) {
        }
    }

    private static void updateServiceProviderExtraInfo(AutoStartBean autoStartBean, Object[] objArr) {
        if (objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                String action = intent.getAction();
                if (action != null) {
                    autoStartBean.extraInfo.put(AutoStartBean.KEY_ACTION, action);
                }
                autoStartBean.extraInfo.put(AutoStartBean.KEY_INTENT, intent.toString().replace(BUNDLE_REPLACE_TEXT, getBundleDataShort(intent.getExtras())));
            }
        }
    }
}
