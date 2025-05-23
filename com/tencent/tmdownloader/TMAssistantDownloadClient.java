package com.tencent.tmdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.aidl.a;
import com.tencent.tmassistant.aidl.b;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantbase.common.TMAssistantDownloadContentType;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.q;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TMAssistantDownloadClient extends com.tencent.tmdownloader.a {
    static IPatchRedirector $redirector_ = null;
    protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmdownloader.TMAssistantDownloadService";
    public static final String SP_KEY_YYB_DOWNLOAD_RECORD = "sp_key_yyb_download_record";
    protected static final String TAG = "TMAssistantDownloadSDKClient";
    private BroadcastReceiver mAppInstallBroadcastReceiver;
    protected ReferenceQueue<ITMAssistantDownloadClientListener> mListenerReferenceQueue;
    private com.tencent.tmassistantbase.util.f mLogListener;
    ReferenceQueue<ITMAssistantDownloadLogListener> mLogListenerReferenceQueue;
    protected ArrayList<WeakReference<ITMAssistantDownloadClientListener>> mWeakListenerArrayList;
    ArrayList<WeakReference<ITMAssistantDownloadLogListener>> mWeakLogListenerArrayList;
    boolean registered;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TMAssistantDownloadClient.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            Uri data;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            try {
                if (("android.intent.action.PACKAGE_ADDED".equals(intent.getAction()) || "android.intent.action.PACKAGE_REPLACED".equals(intent.getAction())) && (data = intent.getData()) != null) {
                    final String schemeSpecificPart = data.getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(schemeSpecificPart)) {
                        com.tencent.tmassistantbase.util.e.a().post(new Runnable() { // from class: com.tencent.tmdownloader.g
                            @Override // java.lang.Runnable
                            public final void run() {
                                TMAssistantDownloadClient.a.this.a(context, schemeSpecificPart);
                            }
                        });
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Context context, String str) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(TMAssistantDownloadClient.SP_KEY_YYB_DOWNLOAD_RECORD, 0);
            String string = sharedPreferences.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                TMAssistantDownloadClient.this.deleteDownloadTask(string);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            sharedPreferences.edit().remove(str).apply();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements com.tencent.tmassistantbase.util.f {
        static IPatchRedirector $redirector_;

        c(TMAssistantDownloadClient tMAssistantDownloadClient) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) tMAssistantDownloadClient);
            }
        }
    }

    public TMAssistantDownloadClient(Context context, String str) {
        super(context, str, DOWNDLOADSDKSERVICENAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            return;
        }
        this.mAppInstallBroadcastReceiver = new a();
        this.registered = false;
        this.mLogListener = new c(this);
        long currentTimeMillis = System.currentTimeMillis();
        Objects.toString(context);
        this.mListenerReferenceQueue = new ReferenceQueue<>();
        this.mWeakListenerArrayList = new ArrayList<>();
        this.mServiceCallback = new b();
        if (GlobalUtil.getInstance().getAutoDeleteSwitch()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme("package");
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                this.mContext.registerReceiver(this.mAppInstallBroadcastReceiver, intentFilter);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        q.a(this.mServiceName + "TMAssistantDownloadClient <init> end, timeCost = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<TMAssistantDownloadLogInfo> convert2LogInfo(List<String> list) {
        String[] split;
        ArrayList<TMAssistantDownloadLogInfo> arrayList = new ArrayList<>();
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && (split = str.split(ContainerUtils.FIELD_DELIMITER)) != null) {
                    TMAssistantDownloadLogInfo tMAssistantDownloadLogInfo = null;
                    for (String str2 : split) {
                        String[] split2 = str2.split("'");
                        if (split2 != null && split2.length == 2) {
                            if (tMAssistantDownloadLogInfo == null) {
                                tMAssistantDownloadLogInfo = new TMAssistantDownloadLogInfo();
                            }
                            if (!TextUtils.isEmpty(split2[0])) {
                                String str3 = split2[0];
                                String str4 = split2[1];
                                if (str3.equals("LL")) {
                                    if (!TextUtils.isEmpty(str4)) {
                                        tMAssistantDownloadLogInfo.logLevel = str4;
                                    } else {
                                        tMAssistantDownloadLogInfo.logLevel = "D";
                                    }
                                } else if (str3.equals("LT")) {
                                    if (!TextUtils.isEmpty(str4)) {
                                        tMAssistantDownloadLogInfo.logTag = str4;
                                    } else {
                                        tMAssistantDownloadLogInfo.logTag = " TMAssistantDownloadSDK";
                                    }
                                } else if (str3.equals("LTS")) {
                                    if (!TextUtils.isEmpty(str4)) {
                                        tMAssistantDownloadLogInfo.logTime = Long.valueOf(str4).longValue();
                                    } else {
                                        tMAssistantDownloadLogInfo.logTime = 0L;
                                    }
                                } else if (str3.equals("LM")) {
                                    if (!TextUtils.isEmpty(str4)) {
                                        tMAssistantDownloadLogInfo.logMsg = str4;
                                    } else {
                                        tMAssistantDownloadLogInfo.logMsg = " msg lost!!!";
                                    }
                                } else if (str3.equals("LW")) {
                                    if (!TextUtils.isEmpty(str4)) {
                                        tMAssistantDownloadLogInfo.logThrowableMsg = str4;
                                    } else {
                                        tMAssistantDownloadLogInfo.logThrowableMsg = " log ThrowableMsg lost!!!";
                                    }
                                }
                            }
                        }
                    }
                    if (tMAssistantDownloadLogInfo != null) {
                        arrayList.add(tMAssistantDownloadLogInfo);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTMAssistantDownloadSDK$0() {
        try {
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SP_KEY_YYB_DOWNLOAD_RECORD, 0);
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                String key = entry.getKey();
                String str = (String) entry.getValue();
                if (InstalledAppListMonitor.getPackageInfo(this.mContext.getPackageManager(), key, 0) != null) {
                    try {
                        deleteDownloadTask(str);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    sharedPreferences.edit().remove(key).apply();
                }
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public synchronized void cancelDownloadTask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        if (str != null) {
            com.tencent.tmassistant.aidl.b bVar = (com.tencent.tmassistant.aidl.b) super.getServiceInterface();
            if (bVar != null) {
                bVar.e(this.mClientKey, str);
            } else {
                super.initTMAssistantDownloadSDK();
            }
            return;
        }
        r.a(TAG, "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
    }

    public synchronized void deleteDownloadTask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (str != null) {
            com.tencent.tmassistant.aidl.b bVar = (com.tencent.tmassistant.aidl.b) super.getServiceInterface();
            if (bVar != null) {
                bVar.a(this.mClientKey, str);
            } else {
                super.initTMAssistantDownloadSDK();
            }
            return;
        }
        r.a(TAG, "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
    }

    @Override // com.tencent.tmdownloader.a
    protected Intent getBindServiceIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Intent) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return new Intent(this.mContext, Class.forName(this.mServiceName));
    }

    public synchronized List<TMAssistantDownloadTaskInfo> getDownloadTaskInfosByVia(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        if (str != null) {
            com.tencent.tmassistant.aidl.b bVar = (com.tencent.tmassistant.aidl.b) super.getServiceInterface();
            if (bVar != null) {
                List<TMAssistantDownloadTaskInfo> f16 = bVar.f(str);
                Objects.toString(f16);
                return f16;
            }
            super.initTMAssistantDownloadSDK();
            return null;
        }
        r.a(TAG, "exception: TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
    }

    public synchronized TMAssistantDownloadTaskInfo getDownloadTaskState(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TMAssistantDownloadTaskInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (str != null) {
            com.tencent.tmassistant.aidl.b bVar = (com.tencent.tmassistant.aidl.b) super.getServiceInterface();
            if (bVar != null) {
                TMAssistantDownloadTaskInfo d16 = bVar.d(this.mClientKey, str);
                Objects.toString(d16);
                return d16;
            }
            super.initTMAssistantDownloadSDK();
            return null;
        }
        r.a(TAG, "exception: TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
    }

    @Override // com.tencent.tmdownloader.a
    public boolean initTMAssistantDownloadSDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean initTMAssistantDownloadSDK = super.initTMAssistantDownloadSDK();
        if (GlobalUtil.getInstance().getAutoDeleteSwitch()) {
            com.tencent.tmassistantbase.util.e.a().postDelayed(new Runnable() { // from class: com.tencent.tmdownloader.f
                @Override // java.lang.Runnable
                public final void run() {
                    TMAssistantDownloadClient.this.lambda$initTMAssistantDownloadSDK$0();
                }
            }, 1000L);
        }
        q.a(this.mServiceName + "TMAssistantDownloadClient initTMAssistantDownloadSDK end, timeCost = " + (System.currentTimeMillis() - currentTimeMillis));
        return initTMAssistantDownloadSDK;
    }

    @Override // com.tencent.tmdownloader.a
    protected void onDownloadSDKServiceInvalid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Iterator<WeakReference<ITMAssistantDownloadClientListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            d.a().a(this, it.next().get());
        }
    }

    public synchronized void pauseDownloadTask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        if (str != null) {
            com.tencent.tmassistant.aidl.b bVar = (com.tencent.tmassistant.aidl.b) super.getServiceInterface();
            if (bVar != null) {
                bVar.c(this.mClientKey, str);
            } else {
                super.initTMAssistantDownloadSDK();
            }
            return;
        }
        r.a(TAG, "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
    }

    public synchronized boolean registerDownloadTaskListener(ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) iTMAssistantDownloadClientListener)).booleanValue();
        }
        if (iTMAssistantDownloadClientListener == null) {
            return false;
        }
        while (true) {
            Reference<? extends ITMAssistantDownloadClientListener> poll = this.mListenerReferenceQueue.poll();
            if (poll == null) {
                break;
            }
            this.mWeakListenerArrayList.remove(poll);
        }
        Iterator<WeakReference<ITMAssistantDownloadClientListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == iTMAssistantDownloadClientListener) {
                return true;
            }
        }
        this.mWeakListenerArrayList.add(new WeakReference<>(iTMAssistantDownloadClientListener, this.mListenerReferenceQueue));
        return true;
    }

    public synchronized boolean registerLogListener(ITMAssistantDownloadLogListener iTMAssistantDownloadLogListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) iTMAssistantDownloadLogListener)).booleanValue();
        }
        if (iTMAssistantDownloadLogListener == null) {
            return false;
        }
        if (this.mWeakLogListenerArrayList == null) {
            this.mWeakLogListenerArrayList = new ArrayList<>();
        }
        if (this.mLogListenerReferenceQueue == null) {
            this.mLogListenerReferenceQueue = new ReferenceQueue<>();
        }
        while (true) {
            Reference<? extends ITMAssistantDownloadLogListener> poll = this.mLogListenerReferenceQueue.poll();
            if (poll != null) {
                this.mWeakLogListenerArrayList.remove(poll);
            } else {
                try {
                    break;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        com.tencent.tmassistant.aidl.b bVar = (com.tencent.tmassistant.aidl.b) super.getServiceInterface();
        if (bVar != null) {
            bVar.a();
        } else {
            super.initTMAssistantDownloadSDK();
        }
        Iterator<WeakReference<ITMAssistantDownloadLogListener>> it = this.mWeakLogListenerArrayList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == iTMAssistantDownloadLogListener) {
                return true;
            }
        }
        this.mWeakLogListenerArrayList.add(new WeakReference<>(iTMAssistantDownloadLogListener, this.mLogListenerReferenceQueue));
        if (!this.registered) {
            this.registered = true;
            r.a(this.mLogListener);
        }
        return true;
    }

    @Override // com.tencent.tmdownloader.a
    protected void registerServiceCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            ((com.tencent.tmassistant.aidl.b) this.mServiceInterface).a(this.mClientKey, (com.tencent.tmassistant.aidl.a) this.mServiceCallback);
        }
    }

    public synchronized int startDownloadTask(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return startDownloadTask(str, 0, str2, null, null);
        }
        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2)).intValue();
    }

    @Override // com.tencent.tmdownloader.a
    protected void stubAsInterface(IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) iBinder);
        } else {
            this.mServiceInterface = b.a.a(iBinder);
        }
    }

    public synchronized boolean unRegisterDownloadTaskListener(ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) iTMAssistantDownloadClientListener)).booleanValue();
        }
        if (iTMAssistantDownloadClientListener == null) {
            return false;
        }
        Iterator<WeakReference<ITMAssistantDownloadClientListener>> it = this.mWeakListenerArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<ITMAssistantDownloadClientListener> next = it.next();
            if (next.get() == iTMAssistantDownloadClientListener) {
                this.mWeakListenerArrayList.remove(next);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unRegisterLogListener(ITMAssistantDownloadLogListener iTMAssistantDownloadLogListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) iTMAssistantDownloadLogListener)).booleanValue();
        }
        if (iTMAssistantDownloadLogListener == null) {
            return false;
        }
        Iterator<WeakReference<ITMAssistantDownloadLogListener>> it = this.mWeakLogListenerArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<ITMAssistantDownloadLogListener> next = it.next();
            if (next.get() == iTMAssistantDownloadLogListener) {
                this.mWeakLogListenerArrayList.remove(next);
                if (this.mWeakLogListenerArrayList.size() == 0) {
                    r.b(this.mLogListener);
                    try {
                        com.tencent.tmassistant.aidl.b bVar = (com.tencent.tmassistant.aidl.b) super.getServiceInterface();
                        if (bVar != null) {
                            bVar.g();
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.tmdownloader.a
    protected void unRegisterServiceCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            ((com.tencent.tmassistant.aidl.b) this.mServiceInterface).b(this.mClientKey, (com.tencent.tmassistant.aidl.a) this.mServiceCallback);
        }
    }

    public synchronized int startDownloadTask(String str, String str2, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, str, str2, map)).intValue();
        }
        if (map != null) {
            map.size();
        }
        return startDownloadTask(str, 0, str2, null, map);
    }

    public synchronized int startDownloadTask(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, str, str2, str3)).intValue();
        }
        toString();
        return startDownloadTask(str, 0, str2, str3, null);
    }

    public synchronized int startDownloadTask(String str, int i3, String str2, String str3, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2, str3, map)).intValue();
        }
        if (map != null) {
            map.size();
        }
        if (str != null) {
            if (str2.equals(TMAssistantDownloadContentType.CONTENT_TYPE_OTHERS) && TextUtils.isEmpty(str3)) {
                r.a(TAG, "exception: if contentType is others, filename shouldn't be null!");
                throw new IllegalArgumentException("if contentType is others, filename shouldn't be null!");
            }
            com.tencent.tmassistant.aidl.b bVar = (com.tencent.tmassistant.aidl.b) super.getServiceInterface();
            if (bVar != null) {
                if (map == null) {
                    map = new HashMap<>();
                }
                Map<String, String> map2 = map;
                map2.put(TMAssistantDownloadConst.PARAM_CALL_STACK, Log.getStackTraceString(new Throwable()));
                return bVar.a(this.mClientKey, str, 0, str2, str3, map2);
            }
            super.initTMAssistantDownloadSDK();
            return 0;
        }
        r.a(TAG, "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b extends a.AbstractBinderC9989a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TMAssistantDownloadClient.this);
            }
        }

        @Override // com.tencent.tmassistant.aidl.a
        public void a(String str, String str2, int i3, int i16, String str3) {
            PackageInfo packageArchiveInfo;
            ApplicationInfo applicationInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3);
                return;
            }
            Iterator<WeakReference<ITMAssistantDownloadClientListener>> it = TMAssistantDownloadClient.this.mWeakListenerArrayList.iterator();
            while (it.hasNext()) {
                WeakReference<ITMAssistantDownloadClientListener> next = it.next();
                ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener = next.get();
                if (iTMAssistantDownloadClientListener != null) {
                    iTMAssistantDownloadClientListener.toString();
                    next.toString();
                }
                d.a().a(TMAssistantDownloadClient.this, iTMAssistantDownloadClientListener, str2, i3, i16, str3);
                if (GlobalUtil.getInstance().getAutoDeleteSwitch() && 4 == i3) {
                    try {
                        Context context = TMAssistantDownloadClient.this.mContext;
                        if (context != null) {
                            PackageManager packageManager = context.getPackageManager();
                            TMAssistantDownloadTaskInfo downloadTaskState = TMAssistantDownloadClient.this.getDownloadTaskState(str2);
                            if (downloadTaskState != null && !TextUtils.isEmpty(downloadTaskState.mSavePath) && (packageArchiveInfo = packageManager.getPackageArchiveInfo(downloadTaskState.mSavePath, 1)) != null && (applicationInfo = packageArchiveInfo.applicationInfo) != null && !TextUtils.isEmpty(applicationInfo.packageName)) {
                                TMAssistantDownloadClient.this.mContext.getSharedPreferences(TMAssistantDownloadClient.SP_KEY_YYB_DOWNLOAD_RECORD, 0).edit().putString(packageArchiveInfo.applicationInfo.packageName, str2).apply();
                            }
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }

        @Override // com.tencent.tmassistant.aidl.a
        public void a(String str, String str2, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, str2, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            Iterator<WeakReference<ITMAssistantDownloadClientListener>> it = TMAssistantDownloadClient.this.mWeakListenerArrayList.iterator();
            while (it.hasNext()) {
                d.a().a(TMAssistantDownloadClient.this, it.next().get(), str2, j3, j16);
            }
        }

        @Override // com.tencent.tmassistant.aidl.a
        public void a(List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
                return;
            }
            ArrayList<WeakReference<ITMAssistantDownloadLogListener>> arrayList = TMAssistantDownloadClient.this.mWeakLogListenerArrayList;
            if (arrayList != null) {
                Iterator<WeakReference<ITMAssistantDownloadLogListener>> it = arrayList.iterator();
                while (it.hasNext()) {
                    ITMAssistantDownloadLogListener iTMAssistantDownloadLogListener = it.next().get();
                    if (iTMAssistantDownloadLogListener != null) {
                        iTMAssistantDownloadLogListener.onLog(TMAssistantDownloadClient.this.convert2LogInfo(list));
                    }
                }
            }
        }
    }
}
