package com.tencent.weiyun;

import android.app.Application;
import android.content.Context;
import android.net.NetworkInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.cmd.CommandManager;
import com.tencent.weiyun.poi.PoiManager;
import com.tencent.weiyun.utils.ILog;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import com.tencent.weiyun.utils.WyLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class WeiyunLiteGlobal {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "WeiyunLiteGlobal";
    private static Singleton<WeiyunLiteGlobal, Void> sInstance;
    private CommandManager mCommandManager;
    private Application mContext;
    private HostInterface mHostInterface;
    private PoiManager mPoiManager;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface HostInterface {
        int getCurrentIsp();

        long getCurrentUin();

        NetworkInfo getRecentNetworkInfo();

        void sendRequest(String str, byte[] bArr, IResponseHandler iResponseHandler);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IResponseHandler {
        void receiveResponse(int i3, String str, byte[] bArr);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11361);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            sInstance = new Singleton<WeiyunLiteGlobal, Void>() { // from class: com.tencent.weiyun.WeiyunLiteGlobal.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.weiyun.utils.Singleton
                public WeiyunLiteGlobal create(Void r46) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new WeiyunLiteGlobal(null) : (WeiyunLiteGlobal) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
                }
            };
        }
    }

    /* synthetic */ WeiyunLiteGlobal(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) anonymousClass1);
    }

    public static WeiyunLiteGlobal getInstance() {
        return sInstance.get(null);
    }

    public CommandManager getCommandManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CommandManager) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        CommandManager commandManager = this.mCommandManager;
        if (commandManager != null) {
            return commandManager;
        }
        throw new IllegalStateException("Please call WeiyunLiteGlobal.initLite(...) in advance.");
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mContext;
    }

    public HostInterface getHostInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HostInterface) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mHostInterface;
    }

    public PoiManager getPoiManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PoiManager) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        PoiManager poiManager = this.mPoiManager;
        if (poiManager != null) {
            return poiManager;
        }
        throw new IllegalStateException("Please call WeiyunLiteGlobal.initLite(...) in advance.");
    }

    public synchronized void initLite(Application application, HostInterface hostInterface, ILog iLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, application, hostInterface, iLog);
            return;
        }
        if (application != null && hostInterface != null) {
            this.mContext = application;
            this.mHostInterface = hostInterface;
            WyLog.setLog(iLog);
            NetworkUtils.setNetworkInfoProvider(new NetworkUtils.INetworkInfoProvider() { // from class: com.tencent.weiyun.WeiyunLiteGlobal.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeiyunLiteGlobal.this);
                    }
                }

                @Override // com.tencent.weiyun.utils.NetworkUtils.INetworkInfoProvider
                public NetworkInfo getNetworkInfo(Context context) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (NetworkInfo) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context);
                    }
                    return WeiyunLiteGlobal.this.mHostInterface.getRecentNetworkInfo();
                }
            });
            this.mCommandManager = CommandManager.getInstance();
            PoiManager poiManager = PoiManager.getInstance();
            this.mPoiManager = poiManager;
            poiManager.init();
            return;
        }
        throw new IllegalArgumentException("The params appInfo, context and hostInterface should be no-null.");
    }

    public void resetCommandCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            getCommandManager().resetWeiyunSdk();
        }
    }

    WeiyunLiteGlobal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
