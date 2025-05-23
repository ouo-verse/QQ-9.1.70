package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mqq.shared_file_accessor.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public class SharedPreferencesProxy implements SharedPreferences {
    private static final String LOG_TAG = "SharedPreferencesProxy";
    private static String sPkgSpName;
    private WeakReference<Context> mContext;
    private EditorImpl mEditor;
    private String mFileName;
    private ContentProviderClient mProviderPref;
    private boolean mRequestPrivate;
    private SharedPreferences.Editor mSystemEditor;
    private SharedPreferences mSystemPref;
    private Monitor mMonitor = null;
    private Set<SharedPreferences.OnSharedPreferenceChangeListener> mListeners = null;

    /* loaded from: classes21.dex */
    class EditorImpl implements SharedPreferences.Editor, Runnable {
        protected final Map<String, Object> mModifiedCaches = new ConcurrentHashMap();

        EditorImpl() {
        }

        private void monitor() {
            if (SharedPreferencesProxyManager.getInstance().isMonitored()) {
                Utils.StackInfo miniStackInfo = Utils.getMiniStackInfo();
                String str = miniStackInfo.clazz + QbAddrData.DATA_SPLITER + miniStackInfo.method + QbAddrData.DATA_SPLITER + miniStackInfo.stack;
                if (Utils.sIsSameProcessAsCP) {
                    SharedPreferencesProxyManager.getInstance().onModifySp(SharedPreferencesProxy.this.mFileName, Utils.sCurrentProcessName, str);
                    return;
                }
                if (SharedPreferencesProxy.this.mMonitor == null) {
                    SharedPreferencesProxy sharedPreferencesProxy = SharedPreferencesProxy.this;
                    sharedPreferencesProxy.mMonitor = new Monitor(sharedPreferencesProxy.mContext, SharedPreferencesProxy.this.mFileName);
                }
                SharedPreferencesProxy.this.mMonitor.log(str);
            }
        }

        private void notifyListeners(String str) {
            synchronized (SharedPreferencesProxy.this) {
                if (SharedPreferencesProxy.this.mListeners != null) {
                    Iterator it = SharedPreferencesProxy.this.mListeners.iterator();
                    while (it.hasNext()) {
                        ((SharedPreferences.OnSharedPreferenceChangeListener) it.next()).onSharedPreferenceChanged(SharedPreferencesProxy.this, str);
                    }
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            commit(true);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            if (SharedPreferencesProxy.this.mProviderPref != null) {
                SharedPreferencesProxy.this.mProviderPref.clear(null);
            } else {
                this.mModifiedCaches.clear();
                SharedPreferencesProxy.this.mSystemEditor.clear();
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            commit(true);
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z16) {
            if (SharedPreferencesProxy.this.mProviderPref != null) {
                SharedPreferencesProxy.this.mProviderPref.write(str, Boolean.valueOf(z16), CommonConstants.VALUE_TYPE_BOOLEAN);
            } else {
                if (str != null) {
                    this.mModifiedCaches.put(str, Boolean.valueOf(z16));
                }
                SharedPreferencesProxy.this.mSystemEditor.putBoolean(str, z16);
            }
            notifyListeners(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f16) {
            if (SharedPreferencesProxy.this.mProviderPref != null) {
                SharedPreferencesProxy.this.mProviderPref.write(str, Float.valueOf(f16), CommonConstants.VALUE_TYPE_FLOAT);
            } else {
                if (str != null) {
                    this.mModifiedCaches.put(str, Float.valueOf(f16));
                }
                SharedPreferencesProxy.this.mSystemEditor.putFloat(str, f16);
            }
            notifyListeners(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i3) {
            if (SharedPreferencesProxy.this.mProviderPref != null) {
                SharedPreferencesProxy.this.mProviderPref.write(str, Integer.valueOf(i3), CommonConstants.VALUE_TYPE_INT);
            } else {
                if (str != null) {
                    this.mModifiedCaches.put(str, Integer.valueOf(i3));
                }
                SharedPreferencesProxy.this.mSystemEditor.putInt(str, i3);
            }
            notifyListeners(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j3) {
            if (SharedPreferencesProxy.this.mProviderPref != null) {
                SharedPreferencesProxy.this.mProviderPref.write(str, Long.valueOf(j3), CommonConstants.VALUE_TYPE_LONG);
            } else {
                if (str != null) {
                    this.mModifiedCaches.put(str, Long.valueOf(j3));
                }
                SharedPreferencesProxy.this.mSystemEditor.putLong(str, j3);
            }
            notifyListeners(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            if (str != null && str.equals("currentAccount") && !((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion()) {
                try {
                    Long.parseLong(str2);
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("currentAccount \u5b58\u50a8\u503c\u4e0d\u5408\u6cd5\uff1a" + str2 + "---" + Log.getStackTraceString(new Exception()));
                }
            }
            if (SharedPreferencesProxy.this.mProviderPref != null) {
                SharedPreferencesProxy.this.mProviderPref.write(str, str2, CommonConstants.VALUE_TYPE_STRING);
            } else {
                if (str != null) {
                    if (str2 == null) {
                        this.mModifiedCaches.put(str, this);
                    } else {
                        this.mModifiedCaches.put(str, str2);
                    }
                }
                SharedPreferencesProxy.this.mSystemEditor.putString(str, str2);
            }
            notifyListeners(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (SharedPreferencesProxy.this.mProviderPref != null) {
                SharedPreferencesProxy.this.mProviderPref.write(str, set, CommonConstants.VALUE_TYPE_STRSET);
            } else {
                if (str != null) {
                    if (set == null) {
                        this.mModifiedCaches.put(str, this);
                    } else {
                        this.mModifiedCaches.put(str, new HashSet(set));
                    }
                }
                SharedPreferencesProxy.this.mSystemEditor.putStringSet(str, set);
            }
            notifyListeners(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            if (SharedPreferencesProxy.this.mProviderPref != null) {
                SharedPreferencesProxy.this.mProviderPref.delete(str);
            } else {
                if (str != null) {
                    this.mModifiedCaches.put(str, this);
                }
                SharedPreferencesProxy.this.mSystemEditor.remove(str);
            }
            notifyListeners(str);
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            SharedPreferencesProxy.this.mSystemEditor.commit();
            this.mModifiedCaches.clear();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void commit(boolean z16) {
            if (SharedPreferencesProxy.this.mProviderPref != null) {
                SharedPreferencesProxy.this.mProviderPref.commit();
                if (SharedPreferencesProxy.this.mRequestPrivate && z16) {
                    monitor();
                    return;
                }
                return;
            }
            if (Looper.getMainLooper() != Looper.myLooper() || SharedPreferencesProxyManager.sIsCrashing) {
                if ("GCloudCoreSP".equals(SharedPreferencesProxy.this.mFileName) || "BuglySdkInfos".equals(SharedPreferencesProxy.this.mFileName)) {
                    SharedPreferencesProxy.this.mSystemEditor.apply();
                } else {
                    SharedPreferencesProxy.this.mSystemEditor.commit();
                }
            } else {
                PrefEditQueueWork.getInstance().queue(this);
            }
            if (z16) {
                monitor();
            }
        }
    }

    public SharedPreferencesProxy(WeakReference<Context> weakReference, String str, int i3, boolean z16) {
        boolean z17;
        this.mProviderPref = null;
        this.mSystemPref = null;
        this.mSystemEditor = null;
        this.mFileName = null;
        this.mEditor = null;
        this.mRequestPrivate = false;
        this.mContext = weakReference;
        if (i3 != 4) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.mRequestPrivate = z17;
        if (sPkgSpName == null) {
            sPkgSpName = weakReference.get().getPackageName() + "_preferences";
        }
        if (sPkgSpName.equals(str) && i3 != 4 && z16) {
            i3 = 4;
        }
        if ((i3 & 4) == 4 && !Utils.sIsSameProcessAsCP) {
            QLog.i(LOG_TAG, 1, "create new ContentProviderClient: " + str);
            this.mProviderPref = new ContentProviderClient(weakReference, str);
        } else {
            SharedPreferences systemSp = Utils.getSystemSp(weakReference.get(), str, 0);
            this.mSystemPref = systemSp;
            this.mSystemEditor = systemSp.edit();
        }
        this.mFileName = str;
        this.mEditor = new EditorImpl();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        Object obj;
        ContentProviderClient contentProviderClient = this.mProviderPref;
        if (contentProviderClient != null) {
            return ((Boolean) contentProviderClient.read(str, CommonConstants.VALUE_TYPE_ANY, Boolean.FALSE)).booleanValue();
        }
        if (str != null) {
            obj = this.mEditor.mModifiedCaches.get(str);
        } else {
            obj = null;
        }
        if (obj != null) {
            return !obj.equals(this.mEditor);
        }
        return this.mSystemPref.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.mEditor;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap;
        ContentProviderClient contentProviderClient = this.mProviderPref;
        if (contentProviderClient != null) {
            return contentProviderClient.readAll();
        }
        Map<String, ?> all = this.mSystemPref.getAll();
        if (all != null) {
            HashMap hashMap2 = new HashMap(all);
            hashMap2.putAll(this.mEditor.mModifiedCaches);
            hashMap = hashMap2;
        } else {
            hashMap = new HashMap(this.mEditor.mModifiedCaches);
        }
        for (Map.Entry<String, Object> entry : this.mEditor.mModifiedCaches.entrySet()) {
            if (this.mEditor.equals(entry.getValue())) {
                hashMap.remove(entry.getKey());
            }
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        Object obj;
        boolean z17;
        try {
            ContentProviderClient contentProviderClient = this.mProviderPref;
            if (contentProviderClient != null) {
                z17 = ((Boolean) contentProviderClient.read(str, CommonConstants.VALUE_TYPE_BOOLEAN, Boolean.valueOf(z16))).booleanValue();
            } else {
                if (str != null) {
                    obj = this.mEditor.mModifiedCaches.get(str);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (!obj.equals(this.mEditor)) {
                        z17 = ((Boolean) obj).booleanValue();
                    } else {
                        return z16;
                    }
                } else {
                    z17 = this.mSystemPref.getBoolean(str, z16);
                }
            }
            return z17;
        } catch (ClassCastException e16) {
            e16.printStackTrace();
            if (!SharedPreferencesProxyManager.sIsDebugVersion) {
                return z16;
            }
            throw new RuntimeException(e16);
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        Object obj;
        float f17;
        try {
            ContentProviderClient contentProviderClient = this.mProviderPref;
            if (contentProviderClient != null) {
                f17 = ((Float) contentProviderClient.read(str, CommonConstants.VALUE_TYPE_FLOAT, Float.valueOf(f16))).floatValue();
            } else {
                if (str != null) {
                    obj = this.mEditor.mModifiedCaches.get(str);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (!obj.equals(this.mEditor)) {
                        f17 = ((Float) obj).floatValue();
                    } else {
                        return f16;
                    }
                } else {
                    f17 = this.mSystemPref.getFloat(str, f16);
                }
            }
            return f17;
        } catch (ClassCastException e16) {
            e16.printStackTrace();
            if (!SharedPreferencesProxyManager.sIsDebugVersion) {
                return f16;
            }
            throw new RuntimeException(e16);
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        Object obj;
        int i16;
        try {
            ContentProviderClient contentProviderClient = this.mProviderPref;
            if (contentProviderClient != null) {
                i16 = ((Integer) contentProviderClient.read(str, CommonConstants.VALUE_TYPE_INT, Integer.valueOf(i3))).intValue();
            } else {
                if (str != null) {
                    obj = this.mEditor.mModifiedCaches.get(str);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (!obj.equals(this.mEditor)) {
                        i16 = ((Integer) obj).intValue();
                    } else {
                        return i3;
                    }
                } else {
                    i16 = this.mSystemPref.getInt(str, i3);
                }
            }
            return i16;
        } catch (ClassCastException e16) {
            e16.printStackTrace();
            if (!SharedPreferencesProxyManager.sIsDebugVersion) {
                return i3;
            }
            throw new RuntimeException(e16);
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        Object obj;
        long j16;
        try {
            ContentProviderClient contentProviderClient = this.mProviderPref;
            if (contentProviderClient != null) {
                j16 = ((Long) contentProviderClient.read(str, CommonConstants.VALUE_TYPE_LONG, Long.valueOf(j3))).longValue();
            } else {
                if (str != null) {
                    obj = this.mEditor.mModifiedCaches.get(str);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (!obj.equals(this.mEditor)) {
                        j16 = ((Long) obj).longValue();
                    } else {
                        return j3;
                    }
                } else {
                    j16 = this.mSystemPref.getLong(str, j3);
                }
            }
            return j16;
        } catch (ClassCastException e16) {
            e16.printStackTrace();
            if (!SharedPreferencesProxyManager.sIsDebugVersion) {
                return j3;
            }
            throw new RuntimeException(e16);
        }
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object obj;
        String string;
        try {
            ContentProviderClient contentProviderClient = this.mProviderPref;
            if (contentProviderClient != null) {
                string = (String) contentProviderClient.read(str, CommonConstants.VALUE_TYPE_STRING, str2);
            } else {
                if (str != null) {
                    obj = this.mEditor.mModifiedCaches.get(str);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (!obj.equals(this.mEditor)) {
                        return (String) obj;
                    }
                    return str2;
                }
                string = this.mSystemPref.getString(str, str2);
            }
            return string;
        } catch (ClassCastException e16) {
            e16.printStackTrace();
            if (!SharedPreferencesProxyManager.sIsDebugVersion) {
                return str2;
            }
            throw new RuntimeException(e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    @Override // android.content.SharedPreferences
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Set<String> getStringSet(String str, Set<String> set) {
        ContentProviderClient contentProviderClient;
        Object obj;
        Set<String> set2;
        try {
            contentProviderClient = this.mProviderPref;
        } catch (ClassCastException e16) {
            e16.printStackTrace();
            if (SharedPreferencesProxyManager.sIsDebugVersion) {
                throw new RuntimeException(e16);
            }
        }
        if (contentProviderClient != null) {
            Object read = contentProviderClient.read(str, CommonConstants.VALUE_TYPE_STRSET, null);
            set2 = read;
            if (read == 0) {
                if (set != null || !(set instanceof Set)) {
                    return null;
                }
                return set;
            }
        } else {
            if (str != null) {
                obj = this.mEditor.mModifiedCaches.get(str);
            } else {
                obj = null;
            }
            if (obj != null) {
                if (!obj.equals(this.mEditor)) {
                    set = (Set) obj;
                }
                if (set != null) {
                }
                return null;
            }
            set2 = this.mSystemPref.getStringSet(str, set);
        }
        set = set2;
        if (set != null) {
        }
        return null;
    }

    @Override // android.content.SharedPreferences
    public synchronized void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (this.mListeners == null) {
            this.mListeners = new HashSet(2);
        }
        this.mListeners.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public synchronized void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Set<SharedPreferences.OnSharedPreferenceChangeListener> set = this.mListeners;
        if (set != null) {
            set.remove(onSharedPreferenceChangeListener);
        }
    }
}
