package com.tencent.sonic.sdk;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sonic.sdk.SonicDataHelper;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class SonicCacheInterceptor {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SonicSdk_SonicCacheInterceptor";
    private final SonicCacheInterceptor nextInterceptor;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class SonicCacheInterceptorDefaultImpl {
        static IPatchRedirector $redirector_ = null;
        public static final String TAG = "SonicSdk_DefaultSonicCacheInterceptor";

        SonicCacheInterceptorDefaultImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static String getCacheData(SonicSession sonicSession) {
            if (sonicSession == null) {
                SonicUtils.log(TAG, 4, "getCache is null");
                return null;
            }
            SonicDataHelper.SessionData sessionData = SonicDataHelper.getSessionData(sonicSession.f369809id);
            boolean z16 = true;
            String str = "";
            if (!TextUtils.isEmpty(sessionData.eTag) && !TextUtils.isEmpty(sessionData.htmlSha1)) {
                SonicDataHelper.updateSonicCacheHitCount(sonicSession.f369809id);
                File file = new File(SonicFileUtils.getSonicHtmlPath(sonicSession.f369809id));
                String readFile = SonicFileUtils.readFile(file);
                boolean isEmpty = TextUtils.isEmpty(readFile);
                if (isEmpty) {
                    SonicUtils.log(TAG, 6, "session(" + sonicSession.sId + ") runSonicFlow error:cache data is null.");
                } else if (SonicEngine.getInstance().getConfig().VERIFY_CACHE_FILE_WITH_SHA1) {
                    if (!SonicFileUtils.verifyData(readFile, sessionData.htmlSha1)) {
                        SonicEngine.getInstance().getRuntime().notifyError(sonicSession.sessionClient, sonicSession.srcUrl, -1001);
                        SonicUtils.log(TAG, 6, "session(" + sonicSession.sId + ") runSonicFlow error:verify html cache with sha1 fail.");
                    } else {
                        SonicUtils.log(TAG, 4, "session(" + sonicSession.sId + ") runSonicFlow verify html cache with sha1 success.");
                    }
                } else if (sessionData.htmlSize != file.length()) {
                    SonicEngine.getInstance().getRuntime().notifyError(sonicSession.sessionClient, sonicSession.srcUrl, -1001);
                    SonicUtils.log(TAG, 6, "session(" + sonicSession.sId + ") runSonicFlow error:verify html cache with size fail.");
                }
                str = readFile;
                z16 = isEmpty;
            } else {
                SonicUtils.log(TAG, 4, "session(" + sonicSession.sId + ") runSonicFlow : session data is empty.");
            }
            if (z16) {
                long currentTimeMillis = System.currentTimeMillis();
                SonicUtils.removeSessionCache(sonicSession.f369809id);
                sessionData.reset();
                SonicUtils.log(TAG, 4, "session(" + sonicSession.sId + ") runSonicFlow:verify error so remove session cache, cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
            }
            return str;
        }
    }

    public SonicCacheInterceptor(SonicCacheInterceptor sonicCacheInterceptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sonicCacheInterceptor);
        } else {
            this.nextInterceptor = sonicCacheInterceptor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSonicCacheData(SonicSession sonicSession) {
        SonicCacheInterceptor sonicCacheInterceptor = sonicSession.config.cacheInterceptor;
        if (sonicCacheInterceptor == null) {
            return SonicCacheInterceptorDefaultImpl.getCacheData(sonicSession);
        }
        String str = null;
        while (sonicCacheInterceptor != null) {
            str = sonicCacheInterceptor.getCacheData(sonicSession);
            if (str != null) {
                break;
            }
            sonicCacheInterceptor = sonicCacheInterceptor.next();
        }
        return str;
    }

    public abstract String getCacheData(SonicSession sonicSession);

    public SonicCacheInterceptor next() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SonicCacheInterceptor) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.nextInterceptor;
    }
}
