package com.tencent.tmdownloader;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TMAssistantDownloadManager {
    static IPatchRedirector $redirector_ = null;
    protected static final String TAG = "TMAssistantDownloadManager";
    protected static TMAssistantDownloadManager mInstance;
    protected static ArrayList<TMAssistantDownloadClient> mSDKClientList;
    protected static TMAssistantDownloadSettingClient mSDKSettingClient;
    protected Context mContext;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            mSDKClientList = new ArrayList<>();
            mSDKSettingClient = null;
        }
    }

    protected TMAssistantDownloadManager(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mContext = context;
        }
    }

    public static synchronized void closeAllService(Context context) {
        synchronized (TMAssistantDownloadManager.class) {
            if (context == null) {
                return;
            }
            if (mInstance == null) {
                return;
            }
            ArrayList<TMAssistantDownloadClient> arrayList = mSDKClientList;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<TMAssistantDownloadClient> it = mSDKClientList.iterator();
                while (it.hasNext()) {
                    TMAssistantDownloadClient next = it.next();
                    if (next != null) {
                        next.unInitTMAssistantDownloadSDK();
                    }
                }
                mSDKClientList.clear();
            }
            MobileQQCloseServiceReceiver.a().e(context);
            TMAssistantDownloadSettingClient tMAssistantDownloadSettingClient = mSDKSettingClient;
            if (tMAssistantDownloadSettingClient != null) {
                tMAssistantDownloadSettingClient.unInitTMAssistantDownloadSDK();
                mSDKSettingClient = null;
            }
            mInstance = null;
        }
    }

    public static synchronized TMAssistantDownloadManager getInstance(Context context) {
        TMAssistantDownloadManager tMAssistantDownloadManager;
        synchronized (TMAssistantDownloadManager.class) {
            if (mInstance == null) {
                mInstance = new TMAssistantDownloadManager(context);
                try {
                    MobileQQCloseServiceReceiver.a().d(context);
                } catch (Throwable unused) {
                }
                if (!l.e()) {
                    if (GlobalUtil.getInstance().getContext() == null) {
                        GlobalUtil.getInstance().setContext(context);
                    }
                    c.a();
                }
            }
            tMAssistantDownloadManager = mInstance;
        }
        return tMAssistantDownloadManager;
    }

    public synchronized TMAssistantDownloadClient getDownloadSDKClient(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TMAssistantDownloadClient) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        l.a();
        if (str != null && str.length() > 0) {
            Iterator<TMAssistantDownloadClient> it = mSDKClientList.iterator();
            while (it.hasNext()) {
                TMAssistantDownloadClient next = it.next();
                if (next.mClientKey.equals(str)) {
                    next.toString();
                    return next;
                }
            }
            TMAssistantDownloadClient tMAssistantDownloadClient = new TMAssistantDownloadClient(this.mContext, str);
            tMAssistantDownloadClient.initTMAssistantDownloadSDK();
            mSDKClientList.add(tMAssistantDownloadClient);
            if (this.mContext == null) {
                this.mContext = GlobalUtil.getInstance().getContext();
            }
            return tMAssistantDownloadClient;
        }
        return null;
    }

    public synchronized TMAssistantDownloadSettingClient getDownloadSDKSettingClient() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TMAssistantDownloadSettingClient) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        l.a();
        if (mSDKSettingClient == null) {
            TMAssistantDownloadSettingClient tMAssistantDownloadSettingClient = new TMAssistantDownloadSettingClient(this.mContext, "TMAssistantDownloadSDKManager");
            mSDKSettingClient = tMAssistantDownloadSettingClient;
            tMAssistantDownloadSettingClient.initTMAssistantDownloadSDK();
        }
        Objects.toString(mSDKSettingClient);
        return mSDKSettingClient;
    }

    public void hookAM4Install() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            com.tencent.tmassistantbase.util.t.d.b().a(this.mContext);
        }
    }

    public synchronized boolean releaseDownloadSDKClient(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        Iterator<TMAssistantDownloadClient> it = mSDKClientList.iterator();
        while (it.hasNext()) {
            TMAssistantDownloadClient next = it.next();
            if (next != null && next.mClientKey.equals(str)) {
                next.unInitTMAssistantDownloadSDK();
                it.remove();
                return true;
            }
        }
        TMAssistantDownloadSettingClient tMAssistantDownloadSettingClient = mSDKSettingClient;
        if (tMAssistantDownloadSettingClient != null && tMAssistantDownloadSettingClient.mClientKey.equals(str)) {
            mSDKSettingClient.unInitTMAssistantDownloadSDK();
            mSDKSettingClient = null;
            return true;
        }
        return false;
    }
}
