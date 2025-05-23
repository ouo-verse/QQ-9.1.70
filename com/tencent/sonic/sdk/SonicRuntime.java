package com.tencent.sonic.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class SonicRuntime {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SonicSdk_SonicRuntime";
    protected static volatile HandlerThread fileHandlerThread;
    protected final Context context;

    public SonicRuntime(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            if (context != null) {
                this.context = context;
                return;
            }
            throw new NullPointerException("SonicRuntime context con not be null!");
        }
    }

    public abstract Object createWebResourceResponse(String str, String str2, InputStream inputStream, Map<String, String> map);

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    public abstract String getCookie(String str);

    public abstract String getCurrentUserAccount();

    public Looper getFileThreadLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Looper) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (fileHandlerThread == null) {
            fileHandlerThread = new BaseHandlerThread("SonicSdk_FileThread");
            fileHandlerThread.start();
        }
        return fileHandlerThread.getLooper();
    }

    public String getHostDirectAddress(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        return null;
    }

    public Set<String> getQueryParameterNames(Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uri);
        }
        if (uri == null) {
            return Collections.emptySet();
        }
        if (!uri.isOpaque()) {
            String encodedQuery = uri.getEncodedQuery();
            if (encodedQuery == null) {
                return Collections.emptySet();
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i3 = 0;
            do {
                int indexOf = encodedQuery.indexOf(38, i3);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                int indexOf2 = encodedQuery.indexOf(61, i3);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i3, indexOf2)));
                i3 = indexOf + 1;
            } while (i3 < encodedQuery.length());
            return Collections.unmodifiableSet(linkedHashSet);
        }
        throw new UnsupportedOperationException("This isn't a hierarchical URI.");
    }

    public File getSonicCacheDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (File) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String str = this.context.getFilesDir() + "/Sonic/";
        File file = new File(str.trim());
        if (!file.exists() && !file.mkdir()) {
            log(TAG, 6, "getSonicCacheDir error:make dir(" + file.getAbsolutePath() + ") fail!");
            notifyError(null, str, -1003);
        }
        return file;
    }

    public File getSonicResourceCacheDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (File) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        File file = new File(Environment.getExternalStorageDirectory(), "/SonicResource/");
        if (!file.exists() && !file.mkdir()) {
            log(TAG, 6, "getSonicResourceCacheDir error:make dir(" + file.getAbsolutePath() + ") fail!");
            notifyError(null, file.getAbsolutePath(), -1003);
        }
        return file;
    }

    public SharedPreferences getSonicSharedPreferences() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.context.getSharedPreferences("sonic", 0);
    }

    public abstract String getUserAgent();

    public abstract boolean isNetworkValid();

    public abstract boolean isSonicUrl(String str);

    public abstract void log(String str, int i3, String str2);

    public String makeSessionId(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
        }
        if (isSonicUrl(str)) {
            StringBuilder sb5 = new StringBuilder();
            try {
                Uri parse = Uri.parse(str);
                sb5.append(parse.getAuthority());
                sb5.append(parse.getPath());
                if (parse.isHierarchical()) {
                    String queryParameter = parse.getQueryParameter(SonicConstants.SONIC_REMAIN_PARAMETER_NAMES);
                    TreeSet treeSet = new TreeSet();
                    if (!TextUtils.isEmpty(queryParameter)) {
                        Collections.addAll(treeSet, queryParameter.split(";"));
                    }
                    TreeSet treeSet2 = new TreeSet(getQueryParameterNames(parse));
                    if (!treeSet.isEmpty()) {
                        treeSet2.remove(SonicConstants.SONIC_REMAIN_PARAMETER_NAMES);
                    }
                    Iterator it = treeSet2.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        if (!TextUtils.isEmpty(str2) && (str2.startsWith(SonicConstants.SONIC_PARAMETER_NAME_PREFIX) || treeSet.contains(str2))) {
                            sb5.append(str2);
                            sb5.append(parse.getQueryParameter(str2));
                        }
                    }
                }
            } catch (Throwable th5) {
                log(TAG, 6, "makeSessionId error:" + th5.getMessage() + ", url=" + str);
                sb5.setLength(0);
                sb5.append(str);
            }
            if (z16) {
                return getCurrentUserAccount() + "_" + SonicUtils.getMD5(sb5.toString());
            }
            return SonicUtils.getMD5(sb5.toString());
        }
        return null;
    }

    public abstract void notifyError(SonicSessionClient sonicSessionClient, String str, int i3);

    public void postTaskToMainThread(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, runnable, Long.valueOf(j3));
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(runnable, j3);
        }
    }

    public void postTaskToSessionThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) runnable);
        } else {
            SonicSessionThreadPool.postTask(runnable);
        }
    }

    public abstract void postTaskToThread(Runnable runnable, long j3);

    public abstract boolean setCookie(String str, List<String> list);

    public boolean shouldLog(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        return true;
    }

    public abstract void showToast(CharSequence charSequence, int i3);
}
