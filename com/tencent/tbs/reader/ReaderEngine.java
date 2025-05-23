package com.tencent.tbs.reader;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.tbs.logger.e;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneConfigurationKeys;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.tbsfile.BuildConfig;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import re4.a;
import re4.c;
import re4.d;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ReaderEngine {
    private static final int COMPONENT_LOAD_LIMIT = -2;
    private static final int COMPONENT_LOAD_NOT_ENABLE = -3;
    private static final int COMPONENT_LOAD_SUCC = 0;
    private static final String COMPONENT_NAME = "file";
    private static final int COMPONENT_NULL_READER_ENTRY = -1;
    private static final int CONTEXT_IS_NULL = -4;
    private static final String FILE_COMPONENT_RECORD_PATH = "reader_record_paths";
    private static final String FILE_COMPONENT_RECORD_TIME = "reader_record_times";
    private static final String FILE_COMPONENT_SP_NAME = "reader_sdk_settings";
    private static final String FILE_SDK_KEY_ABI_TYPE = "key_abi_type";
    private static final String FILE_SDK_SP_NAME = "tbs_file_sdk_env";
    private static final String TAG = "ReaderEngine";
    private static volatile ReaderEngine mInstance;
    protected TBSOneComponent mComponent;
    protected ITbsReaderEntry mReaderEntry;
    private int mVersionCode;
    private String mVersionName;
    private String mPolicy = null;
    private Map mMapSettings = null;
    private boolean mReaderEntryInit = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tbs.reader.ReaderEngine$1, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class AnonymousClass1 extends TBSOneCallback<TBSOneComponent> {
        final Handler handler;
        final /* synthetic */ ITbsReaderCallback val$callBackListener;
        final /* synthetic */ Context val$context;
        final /* synthetic */ TBSOneManager val$manager;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.tbs.reader.ReaderEngine$1$a */
        /* loaded from: classes26.dex */
        public class a implements ITbsReaderCallback {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ITbsReaderEntry f375108d;

            a(ITbsReaderEntry iTbsReaderEntry) {
                this.f375108d = iTbsReaderEntry;
            }

            @Override // com.tencent.tbs.reader.ITbsReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("initReaderEntryAsync, ITbsReaderCallback:onCallBackAction authenticateAsync actionType: ");
                sb5.append(num);
                sb5.append(", retCode: ");
                Integer num2 = (Integer) obj;
                sb5.append(num2);
                sb5.append(", msg: ");
                sb5.append(obj2);
                String sb6 = sb5.toString();
                e.i(ReaderEngine.TAG, sb6);
                re4.b.d(ReaderEngine.TAG, sb6);
                if (num.intValue() == 7003 && (obj instanceof Integer)) {
                    int intValue = num2.intValue();
                    if (intValue == 0) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        intValue = ReaderEngine.this.doInit(anonymousClass1.val$manager, this.f375108d);
                    }
                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                    ITbsReaderCallback iTbsReaderCallback = anonymousClass12.val$callBackListener;
                    if (iTbsReaderCallback != null) {
                        anonymousClass12.postMainUI(iTbsReaderCallback, Integer.valueOf(intValue), obj2);
                    }
                }
            }
        }

        AnonymousClass1(Context context, ITbsReaderCallback iTbsReaderCallback, TBSOneManager tBSOneManager) {
            this.val$context = context;
            this.val$callBackListener = iTbsReaderCallback;
            this.val$manager = tBSOneManager;
            this.handler = new Handler(context.getMainLooper());
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        public void onError(int i3, String str) {
            int parseInt = Integer.parseInt(i3 + "00");
            String str2 = "initReaderEntryAsync, TBSOneCallback:onError:" + i3 + ",description:" + str;
            e.g(ReaderEngine.TAG, str2);
            re4.b.b(ReaderEngine.TAG, str2);
            ReaderEngine.this.report(1000, String.format("tbs:onError,code=%d, des=%s", Integer.valueOf(i3), str), null);
            ITbsReaderCallback iTbsReaderCallback = this.val$callBackListener;
            if (iTbsReaderCallback != null) {
                postMainUI(iTbsReaderCallback, Integer.valueOf(parseInt), str);
            }
        }

        void postMainUI(final ITbsReaderCallback iTbsReaderCallback, final Object obj, final Object obj2) {
            this.handler.post(new Runnable() { // from class: com.tencent.tbs.reader.ReaderEngine.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ITbsReaderCallback iTbsReaderCallback2 = iTbsReaderCallback;
                    if (iTbsReaderCallback2 != null) {
                        iTbsReaderCallback2.onCallBackAction(7002, obj, obj2);
                        String str = "initReaderEntryAsync, finish postMainUI ret:" + obj + ", msg:" + obj2;
                        e.i(ReaderEngine.TAG, str);
                        re4.b.d(ReaderEngine.TAG, str);
                        Log.i(ReaderEngine.TAG, str);
                    }
                }
            });
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        public void onCompleted(TBSOneComponent tBSOneComponent) {
            e.i(ReaderEngine.TAG, "initReaderEntryAsync, TBSOneCallback:onCompleted");
            re4.b.d(ReaderEngine.TAG, "initReaderEntryAsync, TBSOneCallback:onCompleted");
            ITbsReaderEntry createReaderEntry = ReaderEngine.this.createReaderEntry(tBSOneComponent);
            if (createReaderEntry == null) {
                postMainUI(this.val$callBackListener, -1, "null entry");
            } else {
                ReaderEngine.this.authenticateAsync(this.val$context, new a(createReaderEntry));
            }
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        public void onProgressChanged(int i3, int i16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements ITBSFileComponentLoggingHandler {
        a() {
        }

        @Override // com.tencent.tbs.reader.ITBSFileComponentLoggingHandler
        public void log(String str, String str2) {
            c b16 = d.a().b();
            if (b16 != null) {
                b16.log(str, str2);
            } else {
                e.i(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b extends TBSOneCallback<File> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ TBSOneCallback f375111g;

        b(TBSOneCallback tBSOneCallback) {
            this.f375111g = tBSOneCallback;
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCompleted(File file) {
            Log.d(ReaderEngine.TAG, "fileEnginePreLoad, TBSOneCallback:onCompleted");
            re4.b.d(ReaderEngine.TAG, "fileEnginePreLoad, TBSOneCallback:onCompleted");
            ReaderEngine.this.report(1003, "tbs:onCompleted", null);
            TBSOneCallback tBSOneCallback = this.f375111g;
            if (tBSOneCallback != null) {
                tBSOneCallback.onCompleted(file);
            }
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        public void onError(int i3, String str) {
            String str2 = "fileEnginePreLoad, TBSOneCallback:onError:" + i3 + "description:" + str;
            Log.e(ReaderEngine.TAG, str2);
            re4.b.b(ReaderEngine.TAG, str2);
            ReaderEngine.this.report(1004, String.format("tbs:onError,code=%d, des=%s", Integer.valueOf(i3), str), null);
            TBSOneCallback tBSOneCallback = this.f375111g;
            if (tBSOneCallback != null) {
                tBSOneCallback.onError(i3, str);
            }
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        public void onProgressChanged(int i3, int i16) {
            TBSOneCallback tBSOneCallback = this.f375111g;
            if (tBSOneCallback != null) {
                tBSOneCallback.onProgressChanged(i3, i16);
            }
        }
    }

    private int authenticate(Context context) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authenticateAsync(Context context, ITbsReaderCallback iTbsReaderCallback) {
        iTbsReaderCallback.onCallBackAction(7003, 0, "buildinFirst");
    }

    private boolean canAutoUpdate(TBSOneManager.Policy policy) {
        if (isLocalPolicy(policy)) {
            return false;
        }
        return BuildConfig.SDK_CAN_AUTO_UPDATE.booleanValue();
    }

    private void clearOldEngineAndSetAbi(Context context, SharedPreferences sharedPreferences, String str) {
        try {
            com.tencent.tbs.reader.a.b(new File(context.getDir("tbs", 0).getAbsolutePath(), "home/default"));
        } catch (Throwable th5) {
            String str2 = "clearOldEngineAndSetAbi, Failed: " + th5.getMessage();
            Log.e(TAG, str2);
            re4.b.b(TAG, str2);
        }
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(FILE_SDK_KEY_ABI_TYPE, str);
            edit.commit();
        } catch (Throwable th6) {
            String str3 = "clearOldEngineAndSetAbi, Failed: " + th6.getMessage();
            Log.e(TAG, str3);
            re4.b.b(TAG, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ITbsReaderEntry createReaderEntry(TBSOneComponent tBSOneComponent) {
        re4.b.d(TAG, "createReaderEntry");
        ITbsReaderEntry iTbsReaderEntry = null;
        if (tBSOneComponent == null) {
            return null;
        }
        this.mComponent = tBSOneComponent;
        try {
            Object entryObject = tBSOneComponent.getEntryObject();
            this.mVersionName = tBSOneComponent.getVersionName();
            this.mVersionCode = tBSOneComponent.getVersionCode();
            if (entryObject instanceof ITbsReaderEntry) {
                iTbsReaderEntry = (ITbsReaderEntry) entryObject;
            }
            try {
                iTbsReaderEntry.initSettings(this.mMapSettings);
            } catch (Throwable th5) {
                String str = "createReaderEntry, initSettings Throwable: " + th5.getMessage();
                Log.d(TAG, str);
                re4.b.b(TAG, str);
            }
            return iTbsReaderEntry;
        } catch (Throwable th6) {
            report(1000, "loadFileEngine", th6);
            String str2 = "createReaderEntry, get Entry Throwable: " + th6.getMessage();
            e.g(TAG, str2);
            re4.b.b(TAG, str2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int doInit(TBSOneManager tBSOneManager, ITbsReaderEntry iTbsReaderEntry) {
        this.mReaderEntry = iTbsReaderEntry;
        iTbsReaderEntry.initRuntimeEnvironment();
        this.mReaderEntryInit = true;
        if (!this.mReaderEntry.isSupportCurrentPlatform()) {
            this.mReaderEntry = null;
            this.mReaderEntryInit = false;
            re4.b.f(TAG, "doInit, Not SupportCurrentPlatform");
            e.i(TAG, "doInit, Not SupportCurrentPlatform");
            return -3;
        }
        if (TbsFileInterfaceImpl.getVersionCode() >= 5070080 && d.a().c()) {
            re4.b.d(TAG, "doInit, setTBSFileComponentLoggingHandler");
            this.mReaderEntry.setTBSFileComponentLoggingHandler(new a());
        }
        boolean canAutoUpdate = canAutoUpdate(getInstallPolicy());
        String str = "doInit, canAutoUpdate:" + canAutoUpdate;
        Log.d(TAG, str);
        re4.b.d(TAG, str);
        if (canAutoUpdate) {
            try {
                ITbsReaderEntry iTbsReaderEntry2 = this.mReaderEntry;
                if (iTbsReaderEntry2 == null) {
                    tBSOneManager.setAutoUpdateEnabled(true);
                } else {
                    tBSOneManager.setAutoUpdateEnabled(iTbsReaderEntry2.canAutoUpdate());
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                try {
                    tBSOneManager.setAutoUpdateEnabled(true);
                } catch (Throwable unused) {
                }
            }
        }
        return 0;
    }

    public static String getComponentName() {
        return "file";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private TBSOneManager.Policy getInstallPolicy() {
        char c16;
        re4.b.d(TAG, "getInstallPolicy, mPolicy=" + this.mPolicy + "BC.POLICY=buildinFirst");
        String str = this.mPolicy;
        if (str == null) {
            str = "buildinFirst";
        }
        re4.b.d(TAG, "getInstallPolicy, policy=" + str);
        switch (str.hashCode()) {
            case -1417854369:
                if (str.equals(ITbsReader.POLICY_BUILTIN_ONLY)) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1205353033:
                if (str.equals("localOnly")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1012267427:
                if (str.equals("buildinFirst")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -908777766:
                if (str.equals(ITbsReader.POLICY_BUILTIN_ASSETS_FIRST)) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1280306693:
                if (str.equals(ITbsReader.POLICY_LOCAL_FIRST)) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1633525314:
                if (str.equals(ITbsReader.POLICY_BUILTIN_ASSETS_ONLY)) {
                    c16 = 5;
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
                    if (c16 != 3) {
                        if (c16 != 4) {
                            return TBSOneManager.Policy.BUILTIN_ASSETS_ONLY;
                        }
                        return TBSOneManager.Policy.BUILTIN_ASSETS_FIRST;
                    }
                    return TBSOneManager.Policy.LOCAL_ONLY;
                }
                return TBSOneManager.Policy.LOCAL_FIRST;
            }
            return TBSOneManager.Policy.BUILTIN_ONLY;
        }
        return TBSOneManager.Policy.BUILTIN_FIRST;
    }

    public static ReaderEngine getInstance() {
        if (mInstance == null) {
            synchronized (ReaderEngine.class) {
                if (mInstance == null) {
                    mInstance = new ReaderEngine();
                }
            }
        }
        return mInstance;
    }

    private TBSOneDelegate getTBSOneDelegate() {
        return new TBSOneDelegate() { // from class: com.tencent.tbs.reader.ReaderEngine.2
            @Override // com.tencent.tbs.one.TBSOneDelegate
            public String shouldOverrideLibrarySearchPath(String str, String str2, int i3, String str3, String str4) {
                String str5;
                String parent = new File(str3).getParent();
                if (Build.CPU_ABI.matches("armeabi.*")) {
                    str5 = parent + File.separator + "libs/armeabi-v7a";
                } else {
                    str5 = parent + File.separator + "libs/arm64-v8a";
                }
                File file = new File(str5);
                if (!file.exists()) {
                    com.tencent.tbs.reader.a.c(file);
                }
                return str4 + File.pathSeparator + str5;
            }
        };
    }

    private Object invokeComponentMethod(String str, Object obj, Class<?>[] clsArr, Object... objArr) {
        TBSOneComponent tBSOneComponent = this.mComponent;
        if (tBSOneComponent != null) {
            try {
                Method method = tBSOneComponent.getEntryClassLoader().loadClass("com.tencent.tbs.ug.component.TbsReaderEntry").getMethod(str, clsArr);
                method.setAccessible(true);
                return method.invoke(obj, objArr);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return null;
    }

    private boolean isLocalPolicy(TBSOneManager.Policy policy) {
        if (policy != TBSOneManager.Policy.BUILTIN_ASSETS_ONLY && policy != TBSOneManager.Policy.BUILTIN_ONLY && policy != TBSOneManager.Policy.LOCAL_ONLY) {
            return false;
        }
        return true;
    }

    public void cleanAllFileRecord(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_COMPONENT_SP_NAME, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(FILE_COMPONENT_RECORD_PATH, "");
                edit.putString(FILE_COMPONENT_RECORD_TIME, "");
                edit.commit();
            }
        } catch (Throwable th5) {
            String str = "cleanAllFileRecord, Failed: " + th5.getMessage();
            Log.e(TAG, str);
            re4.b.b(TAG, str);
        }
    }

    public View createDebugView(Context context) {
        TBSOneManager defaultInstance = TBSOneManager.getDefaultInstance(context);
        if (defaultInstance != null) {
            defaultInstance.getDebugger().setDebuggerPolicy(getInstallPolicy());
            return defaultInstance.getDebugger().createPanelView(context);
        }
        return null;
    }

    public ITbsReader createTbsReader(Context context, Integer num, ITbsReaderCallback iTbsReaderCallback) {
        ITbsReader iTbsReader;
        String str;
        ITbsReaderEntry iTbsReaderEntry = this.mReaderEntry;
        if (iTbsReaderEntry != null) {
            iTbsReader = (ITbsReader) iTbsReaderEntry.createTbsReader(context, num, iTbsReaderCallback);
        } else {
            iTbsReader = null;
        }
        if (iTbsReader == null) {
            str = "createTbsReader, Failed. return null";
            re4.b.b(TAG, "createTbsReader, Failed. return null");
            report(1001, "createTbsReader:" + num, null);
        } else {
            str = "createTbsReader, Success";
            re4.b.d(TAG, "createTbsReader, Success");
        }
        Log.d(TAG, str);
        return iTbsReader;
    }

    public boolean fileEnginePreCheck(Context context) {
        String str;
        try {
            if (Build.CPU_ABI.matches("armeabi.*")) {
                str = "armeabi";
            } else {
                str = ResourceAttributes.HostArchValues.ARM64;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_SDK_SP_NAME, 0);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(FILE_SDK_KEY_ABI_TYPE, "");
                if (TextUtils.isEmpty(string) || !string.equals(str)) {
                    clearOldEngineAndSetAbi(context, sharedPreferences, str);
                    return true;
                }
                return true;
            }
            return true;
        } catch (Throwable th5) {
            String str2 = "fileEnginePreCheck, Failed: " + th5.getMessage();
            Log.e(TAG, str2);
            re4.b.b(TAG, str2);
            return false;
        }
    }

    public boolean fileEnginePreLoad(Context context, TBSOneCallback tBSOneCallback, boolean z16) {
        String str = "fileEnginePreLoad, isForeground:" + z16;
        Log.d(TAG, str);
        re4.b.d(TAG, str);
        TBSOneManager defaultInstance = TBSOneManager.getDefaultInstance(context);
        defaultInstance.setPolicy(getInstallPolicy());
        defaultInstance.configure(TBSOneConfigurationKeys.ENABLE_DEX_SOFT_LINK, Boolean.TRUE);
        boolean z17 = false;
        try {
            z17 = defaultInstance.isComponentInstalled("file");
            if (!z17) {
                Log.d(TAG, "fileEnginePreLoad, {file} not installed, try to load component using TBSOneManager.installComponent()");
                re4.b.d(TAG, "fileEnginePreLoad, {file} not installed, try to load component using TBSOneManager.installComponent()");
                if (z16) {
                    b bVar = new b(tBSOneCallback);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_WIFI_STATE, true);
                    bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_FREQUENCY_LIMITATION, true);
                    bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_FLOW_CONTROL, true);
                    defaultInstance.installComponent("file", bundle, bVar);
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean(TBSOneConfigurationKeys.IGNORE_WIFI_STATE, true);
                    defaultInstance.installComponent("file", bundle2, tBSOneCallback);
                }
            }
        } catch (Throwable th5) {
            re4.b.b(TAG, "fileEnginePreLoad, Exception, Fail to TBSOneManager.installComponent");
            Log.e(TAG, "fileEnginePreLoad, Exception, Fail to TBSOneManager.installComponent");
            th5.printStackTrace();
        }
        if (z17) {
            try {
                defaultInstance.setAutoUpdateEnabled(true);
            } catch (Throwable unused) {
            }
        }
        return z17;
    }

    public String getLicenseToken() {
        try {
            return (String) invokeComponentMethod("getLicenseToken", null, null, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public String getOneLogPath() {
        Map map = this.mMapSettings;
        if (map != null && map.containsKey("onelog")) {
            return String.valueOf(this.mMapSettings.get("onelog"));
        }
        return "";
    }

    public ITbsReaderEntry getReaderEntry() {
        return this.mReaderEntry;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String getVersionName() {
        return this.mVersionName;
    }

    public int initReaderEntry(Context context) {
        TBSOneComponent tBSOneComponent;
        re4.b.d(TAG, "initReaderEntry, start");
        if (this.mReaderEntry != null) {
            return 0;
        }
        if (context == null) {
            return -4;
        }
        if (isLocalPolicy(getInstallPolicy())) {
            TBSOneManager.setNeedReportEvent(false);
        }
        String oneLogPath = getOneLogPath();
        if (!TextUtils.isEmpty(oneLogPath)) {
            e.m(oneLogPath);
        }
        TBSOneManager defaultInstance = TBSOneManager.getDefaultInstance(context);
        defaultInstance.setPolicy(getInstallPolicy());
        defaultInstance.configure(TBSOneConfigurationKeys.ENABLE_DEX_SOFT_LINK, Boolean.TRUE);
        defaultInstance.setDelegate(getTBSOneDelegate());
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_WIFI_STATE, true);
            bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_FLOW_CONTROL, true);
            if (!defaultInstance.isComponentInstalled("file")) {
                bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_FREQUENCY_LIMITATION, true);
            }
            tBSOneComponent = defaultInstance.loadComponentSync("file", bundle, 20000L);
        } catch (Throwable th5) {
            th5.printStackTrace();
            report(1000, "initReaderEntry", th5);
            tBSOneComponent = null;
        }
        ITbsReaderEntry createReaderEntry = createReaderEntry(tBSOneComponent);
        if (createReaderEntry == null) {
            return -1;
        }
        int authenticate = authenticate(context);
        if (authenticate != 0) {
            return authenticate;
        }
        int doInit = doInit(defaultInstance, createReaderEntry);
        String str = "initReaderEntry, finished ret:" + doInit;
        re4.b.d(TAG, str);
        e.i(TAG, str);
        Log.i(TAG, str);
        return doInit;
    }

    public void initReaderEntryAsync(Context context, ITbsReaderCallback iTbsReaderCallback) {
        re4.b.d(TAG, "initReaderEntryAsync, start");
        if (this.mReaderEntry != null) {
            if (iTbsReaderCallback != null) {
                iTbsReaderCallback.onCallBackAction(7002, 0, "success");
                return;
            }
            return;
        }
        if (context == null) {
            if (iTbsReaderCallback != null) {
                iTbsReaderCallback.onCallBackAction(7002, -4, "context can not be null");
                return;
            }
            return;
        }
        if (isLocalPolicy(getInstallPolicy())) {
            TBSOneManager.setNeedReportEvent(false);
        }
        String oneLogPath = getOneLogPath();
        if (!TextUtils.isEmpty(oneLogPath)) {
            e.m(oneLogPath);
        }
        TBSOneManager defaultInstance = TBSOneManager.getDefaultInstance(context);
        defaultInstance.setPolicy(getInstallPolicy());
        defaultInstance.configure(TBSOneConfigurationKeys.ENABLE_DEX_SOFT_LINK, Boolean.TRUE);
        defaultInstance.setDelegate(getTBSOneDelegate());
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_WIFI_STATE, true);
            bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_FLOW_CONTROL, true);
            if (!defaultInstance.isComponentInstalled("file")) {
                bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_FREQUENCY_LIMITATION, true);
            }
            defaultInstance.loadComponentAsync("file", bundle, new AnonymousClass1(context, iTbsReaderCallback, defaultInstance));
        } catch (Throwable th5) {
            re4.b.b(TAG, "initReaderEntryAsync, Exception, Fail to TBSOneManager.loadComponentAsync");
            Log.e(TAG, "initReaderEntryAsync, Exception, Fail to TBSOneManager.loadComponentAsync");
            th5.printStackTrace();
            report(1000, "initReaderEntry", th5);
        }
    }

    public boolean isEngineLoaded() {
        if (this.mReaderEntry != null && this.mReaderEntryInit) {
            return true;
        }
        return false;
    }

    public boolean isLicenseUpdateNeeded() {
        try {
            return ((Boolean) invokeComponentMethod("isLicenseUpdateNeeded", null, null, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isSupportExt(int i3, String str) {
        ITbsReaderEntry iTbsReaderEntry = this.mReaderEntry;
        if (iTbsReaderEntry == null) {
            Log.d(TAG, "isSupportExt, mReaderEntry == null");
            e.i(TAG, "isSupportExt, mReaderEntry == null");
            re4.b.d(TAG, "isSupportExt, mReaderEntry == null");
            return false;
        }
        boolean isSupportExt = iTbsReaderEntry.isSupportExt(i3, str);
        if (!isSupportExt) {
            report(1002, str, null);
        }
        return isSupportExt;
    }

    public void loadLibsInNativeLibraryDir(Context context, LinkedHashSet<String> linkedHashSet) {
        try {
            invokeComponentMethod("loadLibsInNativeLibraryDir", null, new Class[]{Context.class, LinkedHashSet.class}, context, linkedHashSet);
        } catch (Throwable unused) {
        }
    }

    public void saveLicense(String str) {
        try {
            invokeComponentMethod("saveLicense", null, new Class[]{String.class}, str);
        } catch (Throwable unused) {
        }
    }

    public void setConfigSetting(Map map) {
        if (this.mMapSettings == null) {
            this.mMapSettings = new HashMap();
        }
        if (map != null) {
            this.mMapSettings.putAll(map);
        }
    }

    public void setInstallPolicy(String str) {
        re4.b.d(TAG, "setInstallPolicy, set mPolicy=" + str);
        this.mPolicy = str;
    }

    public void setLoggingHandler(Context context, c cVar) {
        setLoggingHandler(context, cVar, new a.b(context).f());
    }

    public void setLoggingHandler(Context context, c cVar, re4.a aVar) {
        d.a().d(cVar, aVar);
    }

    public void report(int i3, String str, Throwable th5) {
    }
}
