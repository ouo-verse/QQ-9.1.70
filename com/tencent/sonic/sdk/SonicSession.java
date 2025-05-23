package com.tencent.sonic.sdk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.sonic.sdk.SonicChunkDataHelper;
import com.tencent.sonic.sdk.SonicDataHelper;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SonicSession implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    public static final String CHROME_FILE_THREAD = "Chrome_FileThread";
    private static final int CLIENT_CORE_MSG_BEGIN = 4;
    private static final int CLIENT_CORE_MSG_CONNECTION_ERROR = 9;
    private static final int CLIENT_CORE_MSG_DATA_UPDATE = 7;
    private static final int CLIENT_CORE_MSG_END = 11;
    private static final int CLIENT_CORE_MSG_FIRST_LOAD = 6;
    private static final int CLIENT_CORE_MSG_PRE_LOAD = 5;
    private static final int CLIENT_CORE_MSG_SERVICE_UNAVAILABLE = 10;
    private static final int CLIENT_CORE_MSG_TEMPLATE_CHANGE = 8;
    protected static final int CLIENT_MSG_NOTIFY_RESULT = 1;
    protected static final int CLIENT_MSG_ON_WEB_READY = 2;
    protected static final int COMMON_MSG_BEGIN = 0;
    protected static final int COMMON_MSG_END = 4;
    public static final String DATA_UPDATE_BUNDLE_PARAMS_DIFF = "_diff_data_";
    protected static final int FILE_THREAD_MSG_BEGIN = 0;
    protected static final int FILE_THREAD_SAVE_CACHE_ON_SERVER_CLOSE = 1;
    protected static final int FILE_THREAD_SAVE_CACHE_ON_SESSION_FINISHED = 2;
    private static final int FIRST_LOAD_NO_DATA = 1;
    private static final int FIRST_LOAD_WITH_DATA = 2;
    public static final String OFFLINE_MODE_FALSE = "false";
    public static final String OFFLINE_MODE_HTTP = "http";
    public static final String OFFLINE_MODE_STORE = "store";
    public static final String OFFLINE_MODE_TRUE = "true";
    private static final int PRE_LOAD_NO_CACHE = 1;
    private static final int PRE_LOAD_WITH_CACHE = 2;
    protected static final int RESOURCE_INTERCEPT_STATE_IN_FILE_THREAD = 1;
    protected static final int RESOURCE_INTERCEPT_STATE_IN_OTHER_THREAD = 2;
    protected static final int RESOURCE_INTERCEPT_STATE_NONE = 0;
    protected static final int SESSION_MSG_FORCE_DESTROY = 3;
    public static final int SONIC_RESULT_CODE_DATA_UPDATE = 200;
    public static final int SONIC_RESULT_CODE_FIRST_LOAD = 1000;
    public static final int SONIC_RESULT_CODE_HIT_CACHE = 304;
    public static final int SONIC_RESULT_CODE_TEMPLATE_CHANGE = 2000;
    public static final int SONIC_RESULT_CODE_UNKNOWN = -1;
    public static final String SONIC_URL_PARAM_PRELOAD = "_preload";
    public static final String SONIC_URL_PARAM_SESSION_ID = "_sonic_id";
    public static final int STATE_DESTROY = 3;
    public static final int STATE_NONE = 0;
    public static final int STATE_READY = 2;
    public static final int STATE_RUNNING = 1;
    public static final String TAG = "SonicSdk_SonicSession";
    private static final int TEMPLATE_CHANGE_REFRESH = 1;
    public static final String WEB_RESPONSE_CODE = "code";
    public static final String WEB_RESPONSE_DATA = "result";
    public static final String WEB_RESPONSE_EXTRA = "extra";
    public static final String WEB_RESPONSE_LAST_IS_RED_PRELOAD = "isPreload";
    public static final String WEB_RESPONSE_LOCAL_REFRESH_TIME = "local_refresh_time";
    public static final String WEB_RESPONSE_SRC_CODE = "srcCode";
    protected static long sNextSessionLogId;
    protected final AtomicBoolean clientIsReady;
    protected final AtomicBoolean clientIsReload;
    public final SonicSessionConfig config;
    public long createdTime;
    public String currUrl;
    protected SonicDiffDataCallback diffDataCallback;
    protected final Handler fileHandler;
    protected int finalResultCode;

    /* renamed from: id, reason: collision with root package name */
    public final String f369809id;
    protected final Intent intent;
    protected boolean isPreload;
    private boolean isRedPointPreload;
    protected final AtomicBoolean isWaitingForDestroy;
    protected final AtomicBoolean isWaitingForSaveFile;
    protected final AtomicBoolean isWaitingForSessionThread;
    private long lastDateUpdateTime;
    private boolean lastIsRedPointPreload;
    protected final Handler mainHandler;
    private Message pendingClientCoreMessage;
    protected String pendingDiffData;
    protected volatile InputStream pendingWebResourceStream;
    protected List<String> preloadLinks;
    protected final AtomicInteger resourceInterceptState;
    public final long sId;
    protected volatile SonicServer server;
    protected volatile SonicSessionClient sessionClient;
    protected final AtomicInteger sessionState;
    protected int srcResultCode;
    public String srcUrl;
    protected final CopyOnWriteArrayList<WeakReference<Callback>> stateChangedCallbackList;
    protected SonicSessionStatistics statistics;
    protected final AtomicBoolean wasInterceptInvoked;
    private final AtomicBoolean wasLoadDataInvoked;
    private final AtomicBoolean wasLoadUrlInvoked;
    private final AtomicBoolean wasNotified;
    protected final AtomicBoolean wasOnPageFinishInvoked;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface Callback {
        void onSessionStateChange(SonicSession sonicSession, int i3, int i16, Bundle bundle);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10010);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 47)) {
            redirector.redirect((short) 47);
        } else {
            sNextSessionLogId = new Random().nextInt(263167);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SonicSession(String str, String str2, SonicSessionConfig sonicSessionConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, str2, sonicSessionConfig);
            return;
        }
        this.srcResultCode = -1;
        this.finalResultCode = -1;
        this.sessionState = new AtomicInteger(0);
        this.wasInterceptInvoked = new AtomicBoolean(false);
        this.clientIsReady = new AtomicBoolean(false);
        this.wasNotified = new AtomicBoolean(false);
        this.isWaitingForSaveFile = new AtomicBoolean(false);
        this.isWaitingForDestroy = new AtomicBoolean(false);
        this.isWaitingForSessionThread = new AtomicBoolean(false);
        this.wasOnPageFinishInvoked = new AtomicBoolean(false);
        this.resourceInterceptState = new AtomicInteger(0);
        this.clientIsReload = new AtomicBoolean(false);
        this.statistics = new SonicSessionStatistics();
        this.pendingDiffData = "";
        this.mainHandler = new Handler(Looper.getMainLooper(), this);
        this.stateChangedCallbackList = new CopyOnWriteArrayList<>();
        Intent intent = new Intent();
        this.intent = intent;
        this.wasLoadUrlInvoked = new AtomicBoolean(false);
        this.wasLoadDataInvoked = new AtomicBoolean(false);
        this.f369809id = str;
        this.config = sonicSessionConfig;
        long j3 = sNextSessionLogId;
        sNextSessionLogId = 1 + j3;
        this.sId = j3;
        this.statistics.srcUrl = str2.trim();
        String addSonicUrlParam = SonicUtils.addSonicUrlParam(this.statistics.srcUrl, SONIC_URL_PARAM_SESSION_ID, String.valueOf(j3));
        this.srcUrl = addSonicUrlParam;
        this.currUrl = addSonicUrlParam;
        this.createdTime = System.currentTimeMillis();
        this.isRedPointPreload = isRedPointPreload();
        this.fileHandler = new Handler(SonicEngine.getInstance().getRuntime().getFileThreadLooper(), new Handler.Callback() { // from class: com.tencent.sonic.sdk.SonicSession.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SonicSession.this);
                }
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
                }
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 != 2) {
                        return false;
                    }
                    String str3 = (String) message.obj;
                    SonicSession sonicSession = SonicSession.this;
                    sonicSession.doSaveSonicCache(sonicSession.server, str3);
                    return true;
                }
                SonicSession.this.saveSonicCacheOnServerClose((SonicServer) message.obj);
                return true;
            }
        });
        if (SonicEngine.getInstance().getConfig().GET_COOKIE_WHEN_SESSION_CREATE) {
            String cookie = SonicEngine.getInstance().getRuntime().getCookie(this.srcUrl);
            if (!TextUtils.isEmpty(cookie)) {
                intent.putExtra("Cookie", cookie);
            }
        }
        if (SonicUtils.shouldLog(4)) {
            SonicUtils.log(TAG, 4, "session(" + j3 + ") create:id=" + str + ", url = " + str2 + ".");
        }
    }

    private void checkAndClearCacheData() {
        SonicEngine.getInstance().getRuntime().postTaskToThread(new Runnable() { // from class: com.tencent.sonic.sdk.SonicSession.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SonicSession.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (SonicUtils.shouldClearCache(SonicEngine.getInstance().getConfig().SONIC_CACHE_CHECK_TIME_INTERVAL)) {
                    SonicEngine.getInstance().trimSonicCache();
                    SonicUtils.saveClearCacheTime(System.currentTimeMillis());
                }
            }
        }, 50L);
    }

    @Nullable
    private SonicDataHelper.SessionData getSessionData(boolean z16) {
        if (z16) {
            return SonicDataHelper.getSessionData(this.f369809id);
        }
        if (this.server != null) {
            SonicDataHelper.SessionData sessionData = new SonicDataHelper.SessionData();
            sessionData.eTag = this.server.getResponseHeaderField("eTag");
            sessionData.templateTag = this.server.getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG);
            if ((TextUtils.isEmpty(sessionData.eTag) || TextUtils.isEmpty(sessionData.templateTag)) && this.config.SUPPORT_LOCAL_SERVER) {
                this.server.separateTemplateAndData();
                sessionData.eTag = this.server.getResponseHeaderField("eTag");
                sessionData.templateTag = this.server.getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG);
            }
            sessionData.sessionId = this.f369809id;
            return sessionData;
        }
        SonicUtils.log(TAG, 6, "session(" + this.sId + ") runSonicFlow error:server is not valid!");
        return new SonicDataHelper.SessionData();
    }

    private void handleClientCoreMessage_ConnectionError(Message message) {
        if (this.wasLoadUrlInvoked.compareAndSet(false, true)) {
            if (SonicUtils.shouldLog(4)) {
                SonicUtils.log(TAG, 4, "handleClientCoreMessage_ConnectionError: load src url.");
            }
            this.sessionClient.loadUrl(this.srcUrl, null);
        }
    }

    private void handleClientCoreMessage_DataUpdate(Message message) {
        String str = (String) message.obj;
        String string = message.getData().getString(DATA_UPDATE_BUNDLE_PARAMS_DIFF);
        boolean z16 = true;
        if (this.wasLoadDataInvoked.get()) {
            this.pendingDiffData = string;
            if (!TextUtils.isEmpty(string)) {
                SonicUtils.log(TAG, 4, "handleClientCoreMessage_DataUpdate:try to notify web callback.");
                setResult(200, 200, true);
                return;
            } else {
                SonicUtils.log(TAG, 4, "handleClientCoreMessage_DataUpdate:diffData is null, cache-offline = store , do not refresh.");
                setResult(200, 304, true);
                return;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleClientCoreMessage_DataUpdate:oh yeah data update hit 304, now clear pending data ->");
            if (this.pendingDiffData == null) {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(".");
            SonicUtils.log(TAG, 4, sb5.toString());
            this.pendingDiffData = null;
            this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, str, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
            setResult(200, 304, false);
            return;
        }
        SonicUtils.log(TAG, 6, "handleClientCoreMessage_DataUpdate error:call load url.");
        this.sessionClient.loadUrl(this.srcUrl, null);
        setResult(200, 1000, false);
    }

    private void handleClientCoreMessage_FirstLoad(Message message) {
        int i3 = message.arg1;
        if (i3 != 1) {
            if (i3 == 2) {
                if (this.wasLoadUrlInvoked.compareAndSet(false, true)) {
                    SonicUtils.log(TAG, 4, "session(" + this.sId + ") handleClientCoreMessage_FirstLoad:oh yeah, first load hit 304.");
                    this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, (String) message.obj, "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
                    setResult(1000, 304, false);
                    return;
                }
                SonicUtils.log(TAG, 4, "session(" + this.sId + ") FIRST_LOAD_WITH_DATA load url was invoked.");
                setResult(1000, 1000, true);
                return;
            }
            return;
        }
        if (this.wasInterceptInvoked.get()) {
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") handleClientCoreMessage_FirstLoad:FIRST_LOAD_NO_DATA.");
            setResult(1000, 1000, true);
            return;
        }
        SonicUtils.log(TAG, 6, "session(" + this.sId + ") handleClientCoreMessage_FirstLoad:url was not invoked.");
    }

    private void handleClientCoreMessage_PreLoad(Message message) {
        int i3 = message.arg1;
        if (i3 != 1) {
            if (i3 == 2) {
                if (this.wasLoadDataInvoked.compareAndSet(false, true)) {
                    SonicUtils.log(TAG, 4, "session(" + this.sId + ") handleClientCoreMessage_PreLoad:PRE_LOAD_WITH_CACHE load data.");
                    String addTagInfo = SonicUtils.addTagInfo((String) message.obj, String.valueOf(System.currentTimeMillis()), null);
                    SonicSessionClient sonicSessionClient = this.sessionClient;
                    String str = this.srcUrl;
                    sonicSessionClient.loadDataWithBaseUrlAndHeader(str, addTagInfo, "text/html", SonicUtils.DEFAULT_CHARSET, str, getCacheHeaders());
                    return;
                }
                SonicUtils.log(TAG, 6, "session(" + this.sId + ") handleClientCoreMessage_PreLoad:wasLoadDataInvoked = true.");
                return;
            }
            return;
        }
        if (this.wasLoadUrlInvoked.compareAndSet(false, true)) {
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") handleClientCoreMessage_PreLoad:PRE_LOAD_NO_CACHE load url.");
            this.currUrl = SonicUtils.addSonicUrlParam(this.srcUrl, SONIC_URL_PARAM_PRELOAD, "1");
            this.sessionClient.loadUrl(this.currUrl, null);
            return;
        }
        SonicUtils.log(TAG, 6, "session(" + this.sId + ") handleClientCoreMessage_PreLoad:wasLoadUrlInvoked = true.");
    }

    private void handleClientCoreMessage_ServiceUnavailable(Message message) {
        if (this.wasLoadUrlInvoked.compareAndSet(false, true)) {
            if (SonicUtils.shouldLog(4)) {
                SonicUtils.log(TAG, 4, "handleClientCoreMessage_ServiceUnavailable:load src url.");
            }
            this.sessionClient.loadUrl(this.srcUrl, null);
        }
    }

    private void handleClientCoreMessage_TemplateChange(Message message) {
        SonicUtils.log(TAG, 4, "handleClientCoreMessage_TemplateChange wasLoadDataInvoked = " + this.wasLoadDataInvoked.get() + ",msg arg1 = " + message.arg1);
        if (this.wasLoadDataInvoked.get()) {
            boolean z16 = true;
            if (1 == message.arg1) {
                if (TextUtils.isEmpty((String) message.obj)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("handleClientCoreMessage_TemplateChange:load url with preload=2, webCallback is null? ->");
                    if (this.diffDataCallback == null) {
                        z16 = false;
                    }
                    sb5.append(z16);
                    SonicUtils.log(TAG, 4, sb5.toString());
                    this.currUrl = SonicUtils.addSonicUrlParam(this.srcUrl, SONIC_URL_PARAM_PRELOAD, "2");
                    this.sessionClient.loadUrl(this.currUrl, null);
                } else {
                    SonicUtils.log(TAG, 4, "handleClientCoreMessage_TemplateChange:load data.");
                    this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, SonicUtils.addTagInfo((String) message.obj, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis())), "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
                }
                setResult(2000, 2000, false);
            } else {
                SonicUtils.log(TAG, 4, "handleClientCoreMessage_TemplateChange:not refresh.");
                setResult(2000, 304, true);
            }
        } else {
            SonicUtils.log(TAG, 4, "handleClientCoreMessage_TemplateChange:oh yeah template change hit 304.");
            Object obj = message.obj;
            if (obj instanceof String) {
                this.sessionClient.loadDataWithBaseUrlAndHeader(this.srcUrl, SonicUtils.addTagInfo((String) obj, String.valueOf(System.currentTimeMillis()), null), "text/html", getCharsetFromHeaders(), this.srcUrl, getHeaders());
                setResult(2000, 304, false);
            } else {
                SonicUtils.log(TAG, 6, "handleClientCoreMessage_TemplateChange error:call load url.");
                this.sessionClient.loadUrl(this.srcUrl, null);
                setResult(2000, 1000, false);
            }
        }
        this.diffDataCallback = null;
        this.mainHandler.removeMessages(2);
    }

    private boolean isRedPointPreload() {
        Uri parse = Uri.parse(this.srcUrl);
        this.isRedPointPreload = false;
        if (parse != null && parse.isHierarchical()) {
            this.isRedPointPreload = "1".equals(parse.getQueryParameter("_sonic_rp"));
        }
        return this.isRedPointPreload;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runSonicFlow(boolean z16) {
        String str;
        boolean z17;
        if (1 != this.sessionState.get()) {
            SonicUtils.log(TAG, 6, "session(" + this.sId + ") runSonicFlow error:sessionState=" + this.sessionState.get() + ".");
            return;
        }
        this.statistics.sonicFlowStartTime = System.currentTimeMillis();
        SonicDataHelper.SessionData sessionData = getSessionData(z16);
        if (z16) {
            str = SonicCacheInterceptor.getSonicCacheData(this);
            this.statistics.cacheVerifyTime = System.currentTimeMillis();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("session(");
            sb5.append(this.sId);
            sb5.append(") runSonicFlow verify cache cost ");
            SonicSessionStatistics sonicSessionStatistics = this.statistics;
            sb5.append(sonicSessionStatistics.cacheVerifyTime - sonicSessionStatistics.sonicFlowStartTime);
            sb5.append(" ms");
            SonicUtils.log(TAG, 4, sb5.toString());
            handleFlow_LoadLocalCache(str);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str) && z16) {
            z17 = false;
        } else {
            z17 = true;
        }
        SonicRuntime runtime = SonicEngine.getInstance().getRuntime();
        if (!runtime.isNetworkValid()) {
            if (z17 && !TextUtils.isEmpty(this.config.USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST)) {
                runtime.postTaskToMainThread(new Runnable(runtime) { // from class: com.tencent.sonic.sdk.SonicSession.3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ SonicRuntime val$runtime;

                    {
                        this.val$runtime = runtime;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SonicSession.this, (Object) runtime);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else if (SonicSession.this.clientIsReady.get() && !SonicSession.this.isDestroyedOrWaitingForDestroy()) {
                            this.val$runtime.showToast(SonicSession.this.config.USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST, 1);
                        }
                    }
                }, 1500L);
            }
            SonicUtils.log(TAG, 6, "session(" + this.sId + ") runSonicFlow error:network is not valid!");
        } else {
            handleFlow_Connection(z17, sessionData);
            this.statistics.connectionFlowFinishTime = System.currentTimeMillis();
        }
        switchState(1, 2, true);
        this.isWaitingForSessionThread.set(false);
        if (postForceDestroyIfNeed()) {
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") runSonicFlow:send force destroy message.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSonicCacheOnServerClose(SonicServer sonicServer) {
        int i3;
        boolean z16 = false;
        if (isDestroyedOrWaitingForDestroy()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("session(");
            sb5.append(this.sId);
            sb5.append(") doSaveSonicCache: save session files fail. Current session is destroy (");
            sb5.append(isDestroyedOrWaitingForDestroy());
            sb5.append(") or refresh ( ");
            if (sonicServer != this.server) {
                z16 = true;
            }
            sb5.append(z16);
            sb5.append(")");
            SonicUtils.log(TAG, 6, sb5.toString());
            return;
        }
        String responseData = sonicServer.getResponseData(false);
        if (SonicUtils.shouldLog(3)) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("session(");
            sb6.append(this.sId);
            sb6.append(") onClose:htmlString size:");
            if (!TextUtils.isEmpty(responseData)) {
                i3 = responseData.length();
            } else {
                i3 = 0;
            }
            sb6.append(i3);
            SonicUtils.log(TAG, 3, sb6.toString());
        }
        if (!TextUtils.isEmpty(responseData)) {
            long currentTimeMillis = System.currentTimeMillis();
            doSaveSonicCache(sonicServer, responseData);
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") onClose:separate And save ache finish, cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        }
        this.isWaitingForSaveFile.set(false);
        if (postForceDestroyIfNeed()) {
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") onClose: postForceDestroyIfNeed send destroy message.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean addSessionStateChangedCallback(Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) callback)).booleanValue();
        }
        return this.stateChangedCallbackList.add(new WeakReference<>(callback));
    }

    public boolean bindClient(SonicSessionClient sonicSessionClient) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) sonicSessionClient)).booleanValue();
        }
        if (this.sessionClient == null) {
            this.sessionClient = sonicSessionClient;
            sonicSessionClient.bindSession(this);
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") bind client.");
            return true;
        }
        return false;
    }

    protected boolean canDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        if (!this.isWaitingForSessionThread.get() && !this.isWaitingForSaveFile.get()) {
            return true;
        }
        SonicUtils.log(TAG, 4, "session(" + this.sId + ") canDestroy:false, isWaitingForSessionThread=" + this.isWaitingForDestroy.get() + ", isWaitingForSaveFile=" + this.isWaitingForSaveFile.get());
        return false;
    }

    protected void clearSessionData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.pendingClientCoreMessage != null) {
            this.pendingClientCoreMessage = null;
        }
    }

    protected Intent createConnectionIntent(SonicDataHelper.SessionData sessionData) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Intent) iPatchRedirector.redirect((short) 15, (Object) this, (Object) sessionData);
        }
        Intent intent = new Intent();
        boolean z16 = false;
        SonicUtils.log(TAG, 4, String.format("Session (%s) send sonic request, etag=(%s), templateTag=(%s)", this.f369809id, sessionData.eTag, sessionData.templateTag));
        intent.putExtra("eTag", sessionData.eTag);
        intent.putExtra(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG, sessionData.templateTag);
        String hostDirectAddress = SonicEngine.getInstance().getRuntime().getHostDirectAddress(this.srcUrl);
        if (!TextUtils.isEmpty(hostDirectAddress)) {
            intent.putExtra(SonicSessionConnection.DNS_PREFETCH_ADDRESS, hostDirectAddress);
            this.statistics.isDirectAddress = true;
        }
        if (this.config.SUPPORT_SONIC_CHUNK_DATA) {
            long currentTimeMillis = System.currentTimeMillis();
            List<SonicChunkDataHelper.ChunkData> chunkDataList = SonicChunkDataHelper.getChunkDataList(sessionData.sessionId, sessionData.eTag);
            if (chunkDataList.size() > 0) {
                SonicChunkDataHelper.ChunkData chunkData = chunkDataList.get(0);
                StringBuilder sb5 = new StringBuilder(256);
                sb5.append(chunkData.toHeader());
                for (int i3 = 1; i3 < chunkDataList.size(); i3++) {
                    SonicChunkDataHelper.ChunkData chunkData2 = chunkDataList.get(i3);
                    sb5.append(";");
                    sb5.append(chunkData2.toHeader());
                }
                intent.putExtra(SonicSessionConnection.CUSTOM_HEAD_FILED_SONIC_DATA_CHUNK, sb5.toString());
                SonicUtils.log(TAG, 4, String.format("Session (%s) send sonic request with chunk hash, etag=(%s), cost=(%d)", this.f369809id, sessionData.eTag, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            }
        }
        if (sessionData.isRedPointPreload == 1) {
            z16 = true;
        }
        this.lastIsRedPointPreload = z16;
        this.lastDateUpdateTime = sessionData.templateUpdateTime;
        SonicRuntime runtime = SonicEngine.getInstance().getRuntime();
        if (!SonicEngine.getInstance().getConfig().GET_COOKIE_WHEN_SESSION_CREATE) {
            String cookie = runtime.getCookie(this.srcUrl);
            if (!TextUtils.isEmpty(cookie)) {
                intent.putExtra("Cookie", cookie);
            }
        } else {
            intent.putExtra("Cookie", this.intent.getStringExtra("Cookie"));
        }
        String userAgent = runtime.getUserAgent();
        if (!TextUtils.isEmpty(userAgent)) {
            str = userAgent + " Sonic/3.0.2";
        } else {
            str = "Sonic/3.0.2";
        }
        intent.putExtra("User-Agent", str);
        return intent;
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 45)) {
            destroy(false);
        } else {
            iPatchRedirector.redirect((short) 45, (Object) this);
        }
    }

    protected void doSaveSonicCache(SonicServer sonicServer, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) sonicServer, (Object) str);
            return;
        }
        if (!isDestroyedOrWaitingForDestroy() && this.server != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String template = sonicServer.getTemplate();
            String updatedData = sonicServer.getUpdatedData();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(template)) {
                String responseHeaderField = sonicServer.getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_HTML_SHA1);
                if (TextUtils.isEmpty(responseHeaderField)) {
                    responseHeaderField = SonicUtils.getSHA1(str);
                }
                String str2 = responseHeaderField;
                String responseHeaderField2 = sonicServer.getResponseHeaderField("eTag");
                String responseHeaderField3 = sonicServer.getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG);
                Map<String, List<String>> responseHeaderFields = sonicServer.getResponseHeaderFields();
                if (SonicUtils.saveSessionFiles(this.f369809id, str, template, updatedData, responseHeaderFields)) {
                    SonicUtils.saveSonicData(this.f369809id, responseHeaderField2, responseHeaderField3, str2, new File(SonicFileUtils.getSonicHtmlPath(this.f369809id)).length(), this.isRedPointPreload, responseHeaderFields);
                    if (this.config.SUPPORT_SONIC_CHUNK_DATA) {
                        SonicChunkDataHelper.saveChunkData(this.f369809id, responseHeaderField2, updatedData);
                    }
                } else {
                    SonicUtils.log(TAG, 6, "session(" + this.sId + ") doSaveSonicCache: save session files fail.");
                    SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1004);
                }
            } else {
                SonicUtils.log(TAG, 6, "session(" + this.sId + ") doSaveSonicCache: save separate template and data files fail.");
                SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1005);
            }
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") doSaveSonicCache: finish, cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
            return;
        }
        SonicUtils.log(TAG, 6, "session(" + this.sId + ") doSaveSonicCache: save session files fail. Current session is destroy!");
    }

    protected HashMap<String, String> getCacheHeaders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (HashMap) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return SonicUtils.getFilteredHeaders(SonicFileUtils.getHeaderFromLocalCache(SonicFileUtils.getSonicHeaderPath(this.f369809id)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getCharsetFromHeaders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 41)) ? getCharsetFromHeaders(getHeaders()) : (String) iPatchRedirector.redirect((short) 41, (Object) this);
    }

    public String getCurrentUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.srcUrl;
    }

    public int getFinalResultCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.finalResultCode;
    }

    protected HashMap<String, String> getHeaders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (HashMap) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        if (this.server != null) {
            return SonicUtils.getFilteredHeaders(this.server.getResponseHeaderFields());
        }
        return null;
    }

    public SonicSessionClient getSessionClient() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (SonicSessionClient) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return this.sessionClient;
    }

    public int getSrcResultCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.srcResultCode;
    }

    public SonicSessionStatistics getStatistics() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (SonicSessionStatistics) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.statistics;
    }

    protected void handleFlow_Connection(boolean z16, SonicDataHelper.SessionData sessionData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), sessionData);
            return;
        }
        this.statistics.connectionFlowStartTime = System.currentTimeMillis();
        if (this.config.SUPPORT_CACHE_CONTROL && this.statistics.connectionFlowStartTime < sessionData.expiredTime) {
            if (SonicUtils.shouldLog(3)) {
                SonicUtils.log(TAG, 3, "session(" + this.sId + ") won't send any request in " + (sessionData.expiredTime - this.statistics.connectionFlowStartTime) + ".ms");
                return;
            }
            return;
        }
        this.server = new SonicServer(this, createConnectionIntent(sessionData));
        int connect = this.server.connect();
        if (connect == 0) {
            connect = this.server.getResponseCode();
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, List<String>> responseHeaderFields = this.server.getResponseHeaderFields();
            if (SonicUtils.shouldLog(3)) {
                SonicUtils.log(TAG, 3, "session(" + this.sId + ") connection get header fields cost = " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            setCookiesFromHeaders(responseHeaderFields, shouldSetCookieAsynchronous());
            if (SonicUtils.shouldLog(3)) {
                SonicUtils.log(TAG, 3, "session(" + this.sId + ") connection set cookies cost = " + (System.currentTimeMillis() - currentTimeMillis2) + " ms.");
            }
        }
        SonicUtils.log(TAG, 4, "session(" + this.sId + ") handleFlow_Connection: respCode = " + connect + ", cost " + (System.currentTimeMillis() - this.statistics.connectionFlowStartTime) + " ms.");
        if (isDestroyedOrWaitingForDestroy()) {
            SonicUtils.log(TAG, 6, "session(" + this.sId + ") handleFlow_Connection error: destroy before server response!");
            return;
        }
        if (304 == connect) {
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") handleFlow_Connection: Server response is not modified.");
            handleFlow_NotModified();
            return;
        }
        if (200 != connect) {
            handleFlow_HttpError(connect);
            SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, connect);
            SonicUtils.log(TAG, 6, "session(" + this.sId + ") handleFlow_Connection error: response code(" + connect + ") is not OK!");
            return;
        }
        String responseHeaderField = this.server.getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_CACHE_OFFLINE);
        SonicUtils.log(TAG, 4, "session(" + this.sId + ") handleFlow_Connection: cacheOffline is " + responseHeaderField + ".");
        if ("http".equalsIgnoreCase(responseHeaderField)) {
            if (z16) {
                handleFlow_ServiceUnavailable();
            }
            SonicDataHelper.setSonicUnavailableTime(this.f369809id, System.currentTimeMillis() + SonicEngine.getInstance().getConfig().SONIC_UNAVAILABLE_TIME);
            return;
        }
        if (!z16) {
            handleFlow_FirstLoad();
            return;
        }
        if (!TextUtils.isEmpty(responseHeaderField) && !"false".equalsIgnoreCase(responseHeaderField)) {
            String responseHeaderField2 = this.server.getResponseHeaderField("eTag");
            String responseHeaderField3 = this.server.getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_CHANGE);
            if (!TextUtils.isEmpty(responseHeaderField2) && !TextUtils.isEmpty(responseHeaderField3)) {
                if (!"false".equals(responseHeaderField3) && !"0".equals(responseHeaderField3)) {
                    handleFlow_TemplateChange(this.server.getResponseData(this.clientIsReload.get()));
                    return;
                } else {
                    handleFlow_DataUpdate(this.server.getUpdatedData());
                    return;
                }
            }
            SonicUtils.log(TAG, 6, "session(" + this.sId + ") handleFlow_Connection error: eTag is ( " + responseHeaderField2 + " ) , templateChange is ( " + responseHeaderField3 + " )!");
            SonicUtils.removeSessionCache(this.f369809id);
            return;
        }
        SonicUtils.log(TAG, 6, "session(" + this.sId + ") handleFlow_Connection error: Cache-Offline is empty or false!");
        SonicUtils.removeSessionCache(this.f369809id);
    }

    protected void handleFlow_DataUpdate(String str) {
        String responseData;
        String str2;
        String str3;
        String str4;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        String str5 = "session(";
        sb5.append("session(");
        sb5.append(this.sId);
        sb5.append(") handleFlow_DataUpdate: start.");
        SonicUtils.log(TAG, 4, sb5.toString());
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = this.server.getResponseData(true);
                responseData = null;
            } else {
                responseData = this.server.getResponseData(false);
                str2 = str;
            }
            if (TextUtils.isEmpty(str2)) {
                SonicUtils.log(TAG, 6, "handleFlow_DataUpdate:getResponseData error.");
                return;
            }
            String responseHeaderField = this.server.getResponseHeaderField("eTag");
            String responseHeaderField2 = this.server.getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG);
            String responseHeaderField3 = this.server.getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_CACHE_OFFLINE);
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject(str2);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            String optString = jSONObject.optString("html-sha1");
            JSONObject diffData = SonicUtils.getDiffData(this.f369809id, optJSONObject);
            Bundle bundle = new Bundle();
            if (diffData != null) {
                bundle.putString(DATA_UPDATE_BUNDLE_PARAMS_DIFF, diffData.toString());
                str3 = "session(";
                str4 = responseHeaderField2;
            } else {
                SonicUtils.log(TAG, 6, "handleFlow_DataUpdate:getDiffData error.");
                str3 = "session(";
                try {
                    str4 = responseHeaderField2;
                    SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1006);
                } catch (Throwable th5) {
                    th = th5;
                    str5 = str3;
                    SonicUtils.log(TAG, 6, str5 + this.sId + ") handleFlow_DataUpdate error:" + th.getMessage());
                    return;
                }
            }
            if (SonicUtils.shouldLog(3)) {
                SonicUtils.log(TAG, 3, "handleFlow_DataUpdate:getDiffData cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
            }
            if (this.wasLoadDataInvoked.get()) {
                if (SonicUtils.shouldLog(4)) {
                    SonicUtils.log(TAG, 4, "handleFlow_DataUpdate:loadData was invoked, quick notify web data update.");
                }
                Message obtainMessage = this.mainHandler.obtainMessage(7);
                if (!"store".equals(responseHeaderField3)) {
                    obtainMessage.setData(bundle);
                }
                this.mainHandler.sendMessage(obtainMessage);
                z16 = true;
            } else {
                z16 = false;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (TextUtils.isEmpty(responseData)) {
                responseData = SonicUtils.buildHtml(this.f369809id, optJSONObject, optString, str2.length(), this.config.SUPPORT_SONIC_CHUNK_DATA);
            }
            if (SonicUtils.shouldLog(3)) {
                SonicUtils.log(TAG, 3, "handleFlow_DataUpdate:buildHtml cost " + (System.currentTimeMillis() - currentTimeMillis2) + " ms.");
            }
            if (TextUtils.isEmpty(responseData)) {
                SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1008);
            }
            if (!z16) {
                this.mainHandler.removeMessages(5);
                Message obtainMessage2 = this.mainHandler.obtainMessage(7);
                obtainMessage2.obj = responseData;
                this.mainHandler.sendMessage(obtainMessage2);
            }
            if (diffData != null && responseData != null && SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, responseHeaderField3, this.server.getResponseHeaderFields())) {
                switchState(1, 2, true);
                Thread.yield();
                long currentTimeMillis3 = System.currentTimeMillis();
                Map<String, List<String>> responseHeaderFields = this.server.getResponseHeaderFields();
                if (SonicUtils.saveSessionFiles(this.f369809id, responseData, null, optJSONObject.toString(), responseHeaderFields)) {
                    SonicUtils.saveSonicData(this.f369809id, responseHeaderField, str4, optString, new File(SonicFileUtils.getSonicHtmlPath(this.f369809id)).length(), false, responseHeaderFields);
                    if (this.config.SUPPORT_SONIC_CHUNK_DATA) {
                        SonicChunkDataHelper.saveChunkData(this.f369809id, responseHeaderField, optJSONObject.toString());
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str3);
                    sb6.append(this.sId);
                    sb6.append(") handleFlow_DataUpdate: finish save session cache, cost ");
                    sb6.append(System.currentTimeMillis() - currentTimeMillis3);
                    sb6.append(" ms.");
                    SonicUtils.log(TAG, 4, sb6.toString());
                    return;
                }
                SonicUtils.log(TAG, 6, str3 + this.sId + ") handleFlow_DataUpdate: save session files fail.");
                SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1004);
                return;
            }
            SonicUtils.log(TAG, 4, str3 + this.sId + ") handleFlow_DataUpdate: clean session cache.");
            SonicUtils.removeSessionCache(this.f369809id);
        } catch (Throwable th6) {
            th = th6;
        }
    }

    protected void handleFlow_FirstLoad() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.pendingWebResourceStream = this.server.getResponseStream(this.wasInterceptInvoked);
        if (this.pendingWebResourceStream == null) {
            SonicUtils.log(TAG, 6, "session(" + this.sId + ") handleFlow_FirstLoad error:server.getResponseStream is null!");
            return;
        }
        String responseData = this.server.getResponseData(false);
        boolean z16 = !TextUtils.isEmpty(responseData);
        SonicUtils.log(TAG, 4, "session(" + this.sId + ") handleFlow_FirstLoad:hasCompletionData=" + z16 + ".");
        this.mainHandler.removeMessages(5);
        Message obtainMessage = this.mainHandler.obtainMessage(6);
        obtainMessage.obj = responseData;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        obtainMessage.arg1 = i3;
        this.mainHandler.sendMessage(obtainMessage);
        String responseHeaderField = this.server.getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_CACHE_OFFLINE);
        if (SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, responseHeaderField, this.server.getResponseHeaderFields())) {
            if (z16 && !this.wasLoadUrlInvoked.get() && !this.wasInterceptInvoked.get()) {
                switchState(1, 2, true);
                postTaskToSaveSonicCache(responseData);
                return;
            }
            return;
        }
        SonicUtils.log(TAG, 4, "session(" + this.sId + ") handleFlow_FirstLoad:offline->" + responseHeaderField + " , so do not need cache to file.");
    }

    protected void handleFlow_HttpError(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else if (this.config.RELOAD_IN_BAD_NETWORK) {
            this.mainHandler.removeMessages(5);
            Message obtainMessage = this.mainHandler.obtainMessage(9);
            obtainMessage.arg1 = i3;
            this.mainHandler.sendMessage(obtainMessage);
        }
    }

    protected void handleFlow_LoadLocalCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        Message obtainMessage = this.mainHandler.obtainMessage(5);
        if (!TextUtils.isEmpty(str)) {
            obtainMessage.arg1 = 2;
            obtainMessage.obj = str;
        } else {
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") runSonicFlow has no cache, do first load flow.");
            obtainMessage.arg1 = 1;
        }
        this.mainHandler.sendMessage(obtainMessage);
    }

    protected void handleFlow_NotModified() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        Message obtainMessage = this.mainHandler.obtainMessage(1);
        obtainMessage.arg1 = 304;
        obtainMessage.arg2 = 304;
        this.mainHandler.sendMessage(obtainMessage);
    }

    protected void handleFlow_ServiceUnavailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.mainHandler.removeMessages(5);
        this.mainHandler.sendMessage(this.mainHandler.obtainMessage(10));
    }

    protected void handleFlow_TemplateChange(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        try {
            SonicUtils.log(TAG, 4, "handleFlow_TemplateChange.");
            long currentTimeMillis = System.currentTimeMillis();
            if (TextUtils.isEmpty(str)) {
                this.pendingWebResourceStream = this.server.getResponseStream(this.wasOnPageFinishInvoked);
                if (this.pendingWebResourceStream == null) {
                    SonicUtils.log(TAG, 6, "session(" + this.sId + ") handleFlow_TemplateChange error:server.getResponseStream = null!");
                    return;
                }
                str = this.server.getResponseData(this.clientIsReload.get());
            }
            String responseHeaderField = this.server.getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_CACHE_OFFLINE);
            if (!this.clientIsReload.get()) {
                this.mainHandler.removeMessages(5);
                Message obtainMessage = this.mainHandler.obtainMessage(8);
                obtainMessage.obj = str;
                if (!"store".equals(responseHeaderField)) {
                    obtainMessage.arg1 = 1;
                }
                this.mainHandler.sendMessage(obtainMessage);
            } else {
                Message obtainMessage2 = this.mainHandler.obtainMessage(1);
                obtainMessage2.arg1 = 2000;
                obtainMessage2.arg2 = 2000;
                this.mainHandler.sendMessage(obtainMessage2);
            }
            if (SonicUtils.shouldLog(3)) {
                SonicUtils.log(TAG, 3, "session(" + this.sId + ") read byte stream cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms, wasInterceptInvoked: " + this.wasInterceptInvoked.get());
            }
            if (SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, responseHeaderField, this.server.getResponseHeaderFields())) {
                switchState(1, 2, true);
                if (!TextUtils.isEmpty(str)) {
                    postTaskToSaveSonicCache(str);
                    return;
                }
                return;
            }
            if ("false".equals(responseHeaderField)) {
                SonicUtils.removeSessionCache(this.f369809id);
                SonicUtils.log(TAG, 4, "handleClientCoreMessage_TemplateChange:offline mode is 'false', so clean cache.");
                return;
            }
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") handleFlow_TemplateChange:offline->" + responseHeaderField + " , so do not need cache to file.");
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 3, "session(" + this.sId + ") handleFlow_TemplateChange error:" + th5.getMessage());
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, (Object) message)).booleanValue();
        }
        if (3 == message.what) {
            destroy(true);
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") handleMessage:force destroy.");
            return true;
        }
        if (isDestroyedOrWaitingForDestroy()) {
            SonicUtils.log(TAG, 6, "session(" + this.sId + ") handleMessage error: is destroyed or waiting for destroy.");
            return true;
        }
        if (SonicUtils.shouldLog(3)) {
            SonicUtils.log(TAG, 3, "session(" + this.sId + ") handleMessage: msg what = " + message.what + ".");
        }
        int i3 = message.what;
        if (4 < i3 && i3 < 11 && !this.clientIsReady.get()) {
            this.pendingClientCoreMessage = Message.obtain(message);
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") handleMessage: client not ready, core msg = " + message.what + ".");
            return true;
        }
        int i16 = message.what;
        if (i16 != 1) {
            if (i16 != 2) {
                switch (i16) {
                    case 5:
                        handleClientCoreMessage_PreLoad(message);
                        break;
                    case 6:
                        handleClientCoreMessage_FirstLoad(message);
                        break;
                    case 7:
                        handleClientCoreMessage_DataUpdate(message);
                        break;
                    case 8:
                        handleClientCoreMessage_TemplateChange(message);
                        break;
                    case 9:
                        handleClientCoreMessage_ConnectionError(message);
                        break;
                    case 10:
                        handleClientCoreMessage_ServiceUnavailable(message);
                        break;
                    default:
                        if (SonicUtils.shouldLog(3)) {
                            SonicUtils.log(TAG, 3, "session(" + this.sId + ") can not  recognize refresh type: " + message.what);
                            return false;
                        }
                        return false;
                }
            } else {
                this.diffDataCallback = (SonicDiffDataCallback) message.obj;
                setResult(this.srcResultCode, this.finalResultCode, true);
            }
        } else {
            setResult(message.arg1, message.arg2, true);
        }
        return true;
    }

    public boolean isDestroyedOrWaitingForDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        if (3 != this.sessionState.get() && !this.isWaitingForDestroy.get()) {
            return false;
        }
        return true;
    }

    public boolean isMatchCurrentUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, (Object) str)).booleanValue();
        }
        try {
            Uri parse = Uri.parse(this.srcUrl);
            Uri parse2 = Uri.parse(str);
            String str2 = parse.getHost() + parse.getPath();
            String str3 = parse2.getHost() + parse2.getPath();
            if (parse.getHost().equalsIgnoreCase(parse2.getHost())) {
                if (!str2.endsWith("/")) {
                    str2 = str2 + "/";
                }
                if (!str3.endsWith("/")) {
                    str3 = str3 + "/";
                }
                return str2.equalsIgnoreCase(str3);
            }
            return false;
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "isMatchCurrentUrl error:" + th5.getMessage());
            return false;
        }
    }

    public boolean isPreload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.isPreload;
    }

    protected void notifyStateChange(int i3, int i16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16), bundle);
            return;
        }
        Iterator<WeakReference<Callback>> it = this.stateChangedCallbackList.iterator();
        while (it.hasNext()) {
            Callback callback = it.next().get();
            if (callback != null) {
                callback.onSessionStateChange(this, i3, i16, bundle);
            }
        }
    }

    public boolean onClientPageFinished(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this, (Object) str)).booleanValue();
        }
        if (isMatchCurrentUrl(str)) {
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") onClientPageFinished:url=" + str + ".");
            this.wasOnPageFinishInvoked.set(true);
            return true;
        }
        return false;
    }

    public boolean onClientReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        boolean z16 = false;
        if (!this.clientIsReady.compareAndSet(false, true)) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("session(");
        sb5.append(this.sId);
        sb5.append(") onClientReady: have pending client core message ? -> ");
        if (this.pendingClientCoreMessage != null) {
            z16 = true;
        }
        sb5.append(z16);
        sb5.append(".");
        SonicUtils.log(TAG, 4, sb5.toString());
        Message message = this.pendingClientCoreMessage;
        if (message != null) {
            this.pendingClientCoreMessage = null;
            handleMessage(message);
        } else if (this.sessionState.get() == 0) {
            start();
        }
        return true;
    }

    public final Object onClientRequestResource(String str) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return iPatchRedirector.redirect((short) 35, (Object) this, (Object) str);
        }
        if (CHROME_FILE_THREAD.equals(Thread.currentThread().getName())) {
            this.resourceInterceptState.set(1);
        } else {
            this.resourceInterceptState.set(2);
        }
        if (isMatchCurrentUrl(str)) {
            obj = onRequestResource(str);
        } else {
            obj = null;
        }
        this.resourceInterceptState.set(0);
        return obj;
    }

    protected Object onRequestResource(String str) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (!this.wasInterceptInvoked.get() && isMatchCurrentUrl(str)) {
            boolean z16 = false;
            if (!this.wasInterceptInvoked.compareAndSet(false, true)) {
                SonicUtils.log(TAG, 6, "session(" + this.sId + ")  onClientRequestResource error:Intercept was already invoked, url = " + str);
                return null;
            }
            if (SonicUtils.shouldLog(3)) {
                SonicUtils.log(TAG, 3, "session(" + this.sId + ")  onClientRequestResource:url = " + str);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.sessionState.get() == 1) {
                synchronized (this.sessionState) {
                    try {
                        if (this.sessionState.get() == 1) {
                            SonicUtils.log(TAG, 4, "session(" + this.sId + ") now wait for pendingWebResourceStream!");
                            this.sessionState.wait(30000L);
                        }
                    } finally {
                    }
                }
            } else if (SonicUtils.shouldLog(3)) {
                SonicUtils.log(TAG, 3, "session(" + this.sId + ") is not in running state: " + this.sessionState);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("session(");
            sb5.append(this.sId);
            sb5.append(") have pending stream? -> ");
            if (this.pendingWebResourceStream != null) {
                z16 = true;
            }
            sb5.append(z16);
            sb5.append(", cost ");
            sb5.append(System.currentTimeMillis() - currentTimeMillis);
            sb5.append("ms.");
            SonicUtils.log(TAG, 4, sb5.toString());
            if (this.pendingWebResourceStream != null) {
                if (!isDestroyedOrWaitingForDestroy()) {
                    obj = SonicEngine.getInstance().getRuntime().createWebResourceResponse(SonicUtils.getMime(this.srcUrl), getCharsetFromHeaders(), this.pendingWebResourceStream, getHeaders());
                } else {
                    SonicUtils.log(TAG, 6, "session(" + this.sId + ") onClientRequestResource error: session is destroyed!");
                    obj = null;
                }
                this.pendingWebResourceStream = null;
                return obj;
            }
        }
        return null;
    }

    public void onServerClosed(SonicServer sonicServer, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, sonicServer, Boolean.valueOf(z16));
            return;
        }
        if (isDestroyedOrWaitingForDestroy()) {
            return;
        }
        if (this.pendingWebResourceStream != null) {
            this.pendingWebResourceStream = null;
        }
        this.isWaitingForSaveFile.set(true);
        long currentTimeMillis = System.currentTimeMillis();
        if (z16) {
            String responseHeaderField = sonicServer.getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_CACHE_OFFLINE);
            if (SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, responseHeaderField, sonicServer.getResponseHeaderFields())) {
                SonicUtils.log(TAG, 4, "session(" + this.sId + ") onClose:offline->" + responseHeaderField + " , post separateAndSaveCache task.");
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = sonicServer;
                this.fileHandler.sendMessageDelayed(obtain, 1500L);
                return;
            }
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") onClose:offline->" + responseHeaderField + " , so do not need cache to file.");
        } else {
            SonicUtils.log(TAG, 6, "session(" + this.sId + ") onClose error:readComplete = false!");
        }
        this.isWaitingForSaveFile.set(false);
        if (postForceDestroyIfNeed()) {
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") onClose: postForceDestroyIfNeed send destroy message in chromium_io thread.");
        }
        if (SonicUtils.shouldLog(3)) {
            SonicUtils.log(TAG, 6, "session(" + this.sId + ") onClose cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        }
    }

    public boolean onWebReady(SonicDiffDataCallback sonicDiffDataCallback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sonicDiffDataCallback)).booleanValue();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("session(");
        sb5.append(this.sId);
        sb5.append(") onWebReady: webCallback has set ? ->");
        if (this.diffDataCallback != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        SonicUtils.log(TAG, 4, sb5.toString());
        if (this.diffDataCallback != null) {
            this.diffDataCallback = null;
            SonicUtils.log(TAG, 5, "session(" + this.sId + ") onWebReady: call more than once.");
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = sonicDiffDataCallback;
        this.mainHandler.sendMessage(obtain);
        return true;
    }

    protected boolean postForceDestroyIfNeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        if (this.isWaitingForDestroy.get() && canDestroy()) {
            this.mainHandler.sendEmptyMessage(3);
            return true;
        }
        return false;
    }

    protected void postTaskToSaveSonicCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = str;
        this.fileHandler.sendMessageDelayed(obtain, 1500L);
    }

    public boolean refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (!this.sessionState.compareAndSet(2, 1)) {
            SonicUtils.log(TAG, 6, "session(" + this.sId + ") refresh error:sessionState=" + this.sessionState.get() + ".");
            return false;
        }
        this.wasInterceptInvoked.set(false);
        this.clientIsReload.set(true);
        this.finalResultCode = -1;
        this.srcResultCode = -1;
        SonicUtils.log(TAG, 4, "session(" + this.sId + ") now refresh sonic flow task.");
        this.statistics.sonicStartTime = System.currentTimeMillis();
        this.isWaitingForSessionThread.set(true);
        SonicEngine.getInstance().getRuntime().postTaskToSessionThread(new Runnable() { // from class: com.tencent.sonic.sdk.SonicSession.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SonicSession.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    SonicSession.this.runSonicFlow(false);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        notifyStateChange(2, 1, null);
        return true;
    }

    protected boolean removeSessionStateChangedCallback(Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) callback)).booleanValue();
        }
        return this.stateChangedCallbackList.remove(new WeakReference(callback));
    }

    protected boolean setCookiesFromHeaders(Map<String, List<String>> map, boolean z16) {
        List<String> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, this, map, Boolean.valueOf(z16))).booleanValue();
        }
        if (map == null || (list = map.get("Set-Cookie".toLowerCase())) == null || list.size() == 0) {
            return false;
        }
        if (!z16) {
            return SonicEngine.getInstance().getRuntime().setCookie(getCurrentUrl(), list);
        }
        SonicUtils.log(TAG, 4, "setCookiesFromHeaders asynchronous in new thread.");
        SonicEngine.getInstance().getRuntime().postTaskToThread(new Runnable(list) { // from class: com.tencent.sonic.sdk.SonicSession.6
            static IPatchRedirector $redirector_;
            final /* synthetic */ List val$cookies;

            {
                this.val$cookies = list;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SonicSession.this, (Object) list);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    SonicEngine.getInstance().getRuntime().setCookie(SonicSession.this.getCurrentUrl(), this.val$cookies);
                }
            }
        }, 0L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsPreload(String str) {
        this.isPreload = true;
        SonicSessionStatistics sonicSessionStatistics = this.statistics;
        String trim = str.trim();
        sonicSessionStatistics.srcUrl = trim;
        this.srcUrl = trim;
        if (SonicUtils.shouldLog(4)) {
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") is preload, new url=" + str + ".");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x027b, code lost:
    
        if (r4 >= 2000) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void setResult(int i3, int i16, boolean z16) {
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        SonicUtils.log(TAG, 4, "session(" + this.sId + ")  setResult: srcCode=" + i3 + ", finalCode=" + i16 + ".");
        SonicSessionStatistics sonicSessionStatistics = this.statistics;
        this.srcResultCode = i3;
        sonicSessionStatistics.originalMode = i3;
        this.finalResultCode = i16;
        sonicSessionStatistics.finalMode = i16;
        if (!z16) {
            return;
        }
        if (this.wasNotified.get()) {
            SonicUtils.log(TAG, 6, "session(" + this.sId + ")  setResult: notify error -> already has notified!");
        }
        if (this.diffDataCallback == null) {
            SonicUtils.log(TAG, 6, "session(" + this.sId + ")  setResult: notify fail as webCallback is not set, please wait!");
            return;
        }
        if (this.finalResultCode == -1) {
            SonicUtils.log(TAG, 6, "session(" + this.sId + ")  setResult: notify fail finalResultCode is not set, please wait!");
            return;
        }
        this.wasNotified.compareAndSet(false, true);
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.finalResultCode == 200) {
                JSONObject jSONObject2 = new JSONObject(this.pendingDiffData);
                if (!jSONObject2.has(WEB_RESPONSE_LOCAL_REFRESH_TIME)) {
                    SonicUtils.log(TAG, 4, "session(" + this.sId + ") setResult: no any updated data. " + this.pendingDiffData);
                    this.pendingDiffData = "";
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis() - jSONObject2.optLong(WEB_RESPONSE_LOCAL_REFRESH_TIME, 0L);
                if (currentTimeMillis > 30000) {
                    SonicUtils.log(TAG, 6, "session(" + this.sId + ") setResult: notify fail as receive js call too late, " + (currentTimeMillis / 1000.0d) + " s.");
                    this.pendingDiffData = "";
                    return;
                }
                if (SonicUtils.shouldLog(3)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("session(");
                    str = SonicSessionConnection.CUSTOM_HEAD_FILED_CACHE_OFFLINE;
                    sb5.append(this.sId);
                    sb5.append(") setResult: notify receive js call in time: ");
                    sb5.append(currentTimeMillis / 1000.0d);
                    sb5.append(" s.");
                    SonicUtils.log(TAG, 3, sb5.toString());
                } else {
                    str = SonicSessionConnection.CUSTOM_HEAD_FILED_CACHE_OFFLINE;
                }
                if (currentTimeMillis > 0) {
                    jSONObject.put(WEB_RESPONSE_LOCAL_REFRESH_TIME, currentTimeMillis);
                }
                jSONObject2.remove(WEB_RESPONSE_LOCAL_REFRESH_TIME);
                jSONObject.put("result", jSONObject2.toString());
            } else {
                str = SonicSessionConnection.CUSTOM_HEAD_FILED_CACHE_OFFLINE;
            }
            if (this.isRedPointPreload) {
                this.lastIsRedPointPreload = true;
            } else if (System.currentTimeMillis() - this.lastDateUpdateTime > 86400000) {
                this.lastIsRedPointPreload = false;
            }
            jSONObject.put("isPreload", this.lastIsRedPointPreload);
            jSONObject.put("code", this.finalResultCode);
            jSONObject.put(WEB_RESPONSE_SRC_CODE, this.srcResultCode);
            JSONObject jSONObject3 = new JSONObject();
            if (this.server != null) {
                jSONObject3.put("eTag", this.server.getResponseHeaderField("eTag"));
                jSONObject3.put(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG, this.server.getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG));
                String str2 = str;
                jSONObject3.put(str2, this.server.getResponseHeaderField(str2));
            }
            jSONObject3.put("isReload", this.clientIsReload);
            jSONObject.put("extra", jSONObject3);
        } catch (Throwable th5) {
            th5.printStackTrace();
            SonicUtils.log(TAG, 6, "session(" + this.sId + ") setResult: notify error -> " + th5.getMessage());
        }
        if (SonicUtils.shouldLog(3)) {
            String jSONObject4 = jSONObject.toString();
            if (jSONObject4.length() > 512) {
                jSONObject4 = jSONObject4.substring(0, 512);
            }
            SonicUtils.log(TAG, 3, "session(" + this.sId + ") setResult: notify now call jsCallback, jsonStr = " + jSONObject4);
        }
        this.pendingDiffData = null;
        if (this.clientIsReload.get()) {
            j3 = System.currentTimeMillis() - this.statistics.diffDataCallbackTime;
        }
        j3 = 0;
        if (j3 > 0) {
            SonicEngine.getInstance().getRuntime().postTaskToMainThread(new Runnable(jSONObject) { // from class: com.tencent.sonic.sdk.SonicSession.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ JSONObject val$json;

                {
                    this.val$json = jSONObject;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SonicSession.this, (Object) jSONObject);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SonicDiffDataCallback sonicDiffDataCallback = SonicSession.this.diffDataCallback;
                    if (sonicDiffDataCallback != null) {
                        sonicDiffDataCallback.callback(this.val$json.toString());
                        SonicSession.this.statistics.diffDataCallbackTime = System.currentTimeMillis();
                    }
                }
            }, 2000 - j3);
        } else {
            this.diffDataCallback.callback(jSONObject.toString());
            this.statistics.diffDataCallbackTime = System.currentTimeMillis();
        }
    }

    protected boolean shouldSetCookieAsynchronous() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        if (2 == this.resourceInterceptState.get()) {
            return true;
        }
        return false;
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (!this.sessionState.compareAndSet(0, 1)) {
            SonicUtils.log(TAG, 3, "session(" + this.sId + ") start error:sessionState=" + this.sessionState.get() + ".");
            return;
        }
        SonicUtils.log(TAG, 4, "session(" + this.sId + ") now post sonic flow task.");
        this.statistics.sonicStartTime = System.currentTimeMillis();
        this.isWaitingForSessionThread.set(true);
        SonicEngine.getInstance().getRuntime().postTaskToSessionThread(new Runnable() { // from class: com.tencent.sonic.sdk.SonicSession.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SonicSession.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    SonicSession.this.runSonicFlow(true);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        notifyStateChange(0, 1, null);
    }

    protected boolean switchState(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16))).booleanValue();
        }
        if (!this.sessionState.compareAndSet(i3, i16)) {
            return false;
        }
        if (z16) {
            synchronized (this.sessionState) {
                this.sessionState.notify();
            }
        }
        notifyStateChange(i3, i16, null);
        return true;
    }

    protected void destroy(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, z16);
            return;
        }
        int i3 = this.sessionState.get();
        if (3 != i3) {
            if (this.sessionClient != null) {
                this.sessionClient = null;
            }
            if (this.pendingWebResourceStream != null) {
                try {
                    this.pendingWebResourceStream.close();
                } catch (Throwable th5) {
                    SonicUtils.log(TAG, 6, "pendingWebResourceStream.close error:" + th5.getMessage());
                }
                this.pendingWebResourceStream = null;
            }
            if (this.pendingDiffData != null) {
                this.pendingDiffData = null;
            }
            clearSessionData();
            checkAndClearCacheData();
            if (!z16 && !canDestroy()) {
                if (this.isWaitingForDestroy.compareAndSet(false, true)) {
                    this.mainHandler.sendEmptyMessageDelayed(3, 6000L);
                    SonicUtils.log(TAG, 4, "session(" + this.sId + ") waiting for destroy, current state =" + i3 + ".");
                    return;
                }
                return;
            }
            this.sessionState.set(3);
            synchronized (this.sessionState) {
                this.sessionState.notify();
            }
            if (this.server != null && !z16) {
                this.server.disconnect();
                this.server = null;
            }
            notifyStateChange(i3, 3, null);
            this.mainHandler.removeMessages(3);
            this.stateChangedCallbackList.clear();
            this.isWaitingForDestroy.set(false);
            SonicUtils.log(TAG, 4, "session(" + this.sId + ") final destroy, force=" + z16 + ".");
        }
    }

    public String getCharsetFromHeaders(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this, (Object) map);
        }
        String str = SonicUtils.DEFAULT_CHARSET;
        String lowerCase = "Content-Type".toLowerCase();
        if (map == null || !map.containsKey(lowerCase)) {
            return str;
        }
        String str2 = map.get(lowerCase);
        return !TextUtils.isEmpty(str2) ? SonicUtils.getCharset(str2) : str;
    }
}
