package com.tencent.sonic.sdk;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sonic.sdk.SonicSession;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SonicEngine {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SonicSdk_SonicEngine";
    private static SonicEngine sInstance;
    private final SonicConfig config;
    private final ConcurrentHashMap<String, SonicSession> preloadSessionPool;
    private final ConcurrentHashMap<String, SonicSession> runningSessionHashMap;
    private final SonicRuntime runtime;
    private final SonicSession.Callback sessionCallback;

    SonicEngine(SonicRuntime sonicRuntime, SonicConfig sonicConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sonicRuntime, (Object) sonicConfig);
            return;
        }
        this.preloadSessionPool = new ConcurrentHashMap<>(5);
        this.runningSessionHashMap = new ConcurrentHashMap<>(5);
        this.sessionCallback = new SonicSession.Callback() { // from class: com.tencent.sonic.sdk.SonicEngine.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SonicEngine.this);
                }
            }

            @Override // com.tencent.sonic.sdk.SonicSession.Callback
            public void onSessionStateChange(SonicSession sonicSession, int i3, int i16, Bundle bundle) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, sonicSession, Integer.valueOf(i3), Integer.valueOf(i16), bundle);
                    return;
                }
                SonicUtils.log(SonicEngine.TAG, 3, "onSessionStateChange:session(" + sonicSession.sId + ") from state " + i3 + " -> " + i16);
                if (i16 != 1) {
                    if (i16 == 3) {
                        SonicEngine.this.runningSessionHashMap.remove(sonicSession.f369809id);
                        return;
                    }
                    return;
                }
                SonicEngine.this.runningSessionHashMap.put(sonicSession.f369809id, sonicSession);
            }
        };
        this.runtime = sonicRuntime;
        this.config = sonicConfig;
    }

    public static synchronized SonicEngine createInstance(@NonNull SonicRuntime sonicRuntime, @NonNull SonicConfig sonicConfig) {
        SonicEngine sonicEngine;
        synchronized (SonicEngine.class) {
            if (sInstance == null) {
                SonicEngine sonicEngine2 = new SonicEngine(sonicRuntime, sonicConfig);
                sInstance = sonicEngine2;
                if (sonicConfig.AUTO_INIT_DB_WHEN_CREATE) {
                    sonicEngine2.initSonicDB();
                }
            }
            sonicEngine = sInstance;
        }
        return sonicEngine;
    }

    public static synchronized SonicEngine getInstance() {
        SonicEngine sonicEngine;
        synchronized (SonicEngine.class) {
            sonicEngine = sInstance;
            if (sonicEngine == null) {
                throw new IllegalStateException("SonicEngine::createInstance() needs to be called before SonicEngine::getInstance()");
            }
        }
        return sonicEngine;
    }

    private SonicSession internalCreateSession(String str, String str2, SonicSessionConfig sonicSessionConfig) {
        if (!this.runningSessionHashMap.containsKey(str)) {
            SonicSession sonicSession = new SonicSession(str, str2, sonicSessionConfig);
            sonicSession.addSessionStateChangedCallback(this.sessionCallback);
            if (sonicSessionConfig.AUTO_START_WHEN_CREATE) {
                sonicSession.start();
            }
            return sonicSession;
        }
        if (this.runtime.shouldLog(6)) {
            this.runtime.log(TAG, 6, "internalCreateSession error:sessionId(" + str + ") is running now.");
            return null;
        }
        return null;
    }

    public static synchronized boolean isGetInstanceAllowed() {
        boolean z16;
        synchronized (SonicEngine.class) {
            if (sInstance != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    private boolean isSessionAvailable(String str) {
        long lastSonicUnavailableTime = SonicDataHelper.getLastSonicUnavailableTime(str);
        if (System.currentTimeMillis() > lastSonicUnavailableTime) {
            return true;
        }
        if (this.runtime.shouldLog(6)) {
            this.runtime.log(TAG, 6, "sessionId(" + str + ") is unavailable and unavailable time until " + lastSonicUnavailableTime + ".");
            return false;
        }
        return false;
    }

    private SonicSession lookupSession(SonicSessionConfig sonicSessionConfig, String str, boolean z16) {
        if (TextUtils.isEmpty(str) || sonicSessionConfig == null) {
            return null;
        }
        SonicSession sonicSession = this.preloadSessionPool.get(str);
        if (sonicSession != null) {
            if (sonicSessionConfig.equals(sonicSession.config) && (sonicSession.config.PRELOAD_SESSION_EXPIRED_TIME <= 0 || System.currentTimeMillis() - sonicSession.createdTime <= sonicSession.config.PRELOAD_SESSION_EXPIRED_TIME)) {
                if (z16) {
                    this.preloadSessionPool.remove(str);
                }
            } else {
                if (this.runtime.shouldLog(6)) {
                    this.runtime.log(TAG, 6, "lookupSession error:sessionId(" + str + ") is expired.");
                }
                this.preloadSessionPool.remove(str);
                sonicSession.destroy();
                return null;
            }
        }
        return sonicSession;
    }

    public static String makeSessionId(String str, boolean z16) {
        return getInstance().getRuntime().makeSessionId(str, z16);
    }

    public synchronized boolean cleanCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (!this.preloadSessionPool.isEmpty()) {
            this.runtime.log(TAG, 4, "cleanCache: remove all preload sessions, size=" + this.preloadSessionPool.size() + ".");
            Iterator<SonicSession> it = this.preloadSessionPool.values().iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.preloadSessionPool.clear();
        }
        if (!this.runningSessionHashMap.isEmpty()) {
            this.runtime.log(TAG, 6, "cleanCache fail, running session map's size is " + this.runningSessionHashMap.size() + ".");
            return false;
        }
        this.runtime.log(TAG, 4, "cleanCache: remove all sessions cache.");
        return SonicUtils.removeAllSessionCache();
    }

    public synchronized SonicSession createSession(@NonNull String str, @NonNull SonicSessionConfig sonicSessionConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SonicSession) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) sonicSessionConfig);
        }
        if (isSonicAvailable()) {
            String makeSessionId = makeSessionId(str, sonicSessionConfig.IS_ACCOUNT_RELATED);
            if (!TextUtils.isEmpty(makeSessionId)) {
                SonicSession lookupSession = lookupSession(sonicSessionConfig, makeSessionId, true);
                if (lookupSession != null) {
                    lookupSession.setIsPreload(str);
                } else if (isSessionAvailable(makeSessionId)) {
                    lookupSession = internalCreateSession(makeSessionId, str, sonicSessionConfig);
                }
                return lookupSession;
            }
        } else {
            this.runtime.log(TAG, 6, "createSession fail for sonic service is unavailable!");
        }
        return null;
    }

    public SonicConfig getConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SonicConfig) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.config;
    }

    public SonicRuntime getRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SonicRuntime) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.runtime;
    }

    public void initSonicDB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            SonicDBHelper createInstance = SonicDBHelper.createInstance(getRuntime().getContext());
            if (Looper.getMainLooper() == Looper.myLooper()) {
                getRuntime().postTaskToSessionThread(new Runnable(createInstance) { // from class: com.tencent.sonic.sdk.SonicEngine.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ SonicDBHelper val$helper;

                    {
                        this.val$helper = createInstance;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SonicEngine.this, (Object) createInstance);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            this.val$helper.getWritableDatabase();
                        } catch (Throwable th5) {
                            SonicUtils.log(SonicEngine.TAG, 6, "initSonicDB getWritableDatabase encounter error." + th5.getMessage());
                        }
                    }
                });
            } else {
                createInstance.getWritableDatabase();
            }
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "initSonicDB getWritableDatabase encounter error." + th5.getMessage());
        }
    }

    public boolean isSonicAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return !SonicDBHelper.getInstance().isUpgrading();
    }

    public synchronized boolean preCreateSession(@NonNull String str, @NonNull SonicSessionConfig sonicSessionConfig) {
        SonicSession internalCreateSession;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) sonicSessionConfig)).booleanValue();
        }
        if (isSonicAvailable()) {
            String makeSessionId = makeSessionId(str, sonicSessionConfig.IS_ACCOUNT_RELATED);
            if (!TextUtils.isEmpty(makeSessionId)) {
                if (lookupSession(sonicSessionConfig, makeSessionId, false) != null) {
                    this.runtime.log(TAG, 6, "preCreateSession\uff1asessionId(" + makeSessionId + ") is already in preload pool.");
                    return false;
                }
                if (this.preloadSessionPool.size() < this.config.MAX_PRELOAD_SESSION_COUNT) {
                    if (isSessionAvailable(makeSessionId) && this.runtime.isNetworkValid() && (internalCreateSession = internalCreateSession(makeSessionId, str, sonicSessionConfig)) != null) {
                        this.preloadSessionPool.put(makeSessionId, internalCreateSession);
                        return true;
                    }
                } else {
                    this.runtime.log(TAG, 6, "create id(" + makeSessionId + ") fail for preload size is bigger than " + this.config.MAX_PRELOAD_SESSION_COUNT + ".");
                }
            }
        } else {
            this.runtime.log(TAG, 6, "preCreateSession fail for sonic service is unavailable!");
        }
        return false;
    }

    public void removeExpiredSessionCache(@NonNull Map<String, Long> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) map);
            return;
        }
        for (String str : map.keySet()) {
            long longValue = map.get(str).longValue();
            long templateUpdateTime = SonicDataHelper.getTemplateUpdateTime(str);
            if (SonicUtils.shouldLog(3)) {
                SonicUtils.log(TAG, 3, "removeExpiredSessionCache sessionId(" + str + ") newTemplateUpdateTime = " + longValue + ", curTemplateUpdateTime = " + templateUpdateTime);
            }
            if (0 != templateUpdateTime && templateUpdateTime < longValue) {
                removeSessionCache(str);
            }
        }
    }

    public synchronized boolean removeSessionCache(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).booleanValue();
        }
        SonicSession sonicSession = this.preloadSessionPool.get(str);
        if (sonicSession != null) {
            sonicSession.destroy();
            this.preloadSessionPool.remove(str);
            this.runtime.log(TAG, 4, "sessionId(" + str + ") removeSessionCache: remove preload session.");
        }
        if (!this.runningSessionHashMap.containsKey(str)) {
            this.runtime.log(TAG, 4, "sessionId(" + str + ") removeSessionCache success.");
            SonicUtils.removeSessionCache(str);
            return true;
        }
        this.runtime.log(TAG, 6, "sessionId(" + str + ") removeSessionCache fail: session is running.");
        return false;
    }

    public void trimSonicCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            SonicFileUtils.checkAndTrimCache();
            SonicFileUtils.checkAndTrimResourceCache();
        }
    }

    public synchronized boolean preCreateSession(@NonNull String str, @NonNull SonicSessionConfig sonicSessionConfig, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, str, sonicSessionConfig, Long.valueOf(j3), Integer.valueOf(i3))).booleanValue();
        }
        if (isSonicAvailable()) {
            String makeSessionId = makeSessionId(str, sonicSessionConfig.IS_ACCOUNT_RELATED);
            if (new File(SonicFileUtils.getSonicHtmlPath(makeSessionId)).exists()) {
                if (SonicDataHelper.getTemplateUpdateTime(makeSessionId) > j3) {
                    return false;
                }
                return preCreateSession(str, sonicSessionConfig);
            }
            if (i3 == 0) {
                return false;
            }
            return preCreateSession(str, sonicSessionConfig);
        }
        this.runtime.log(TAG, 6, "preCreateSession fail for sonic service is unavailable!");
        return false;
    }
}
