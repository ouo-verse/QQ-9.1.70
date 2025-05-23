package com.tencent.mobileqq.transfile.http2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ConfigAwareInstance {
    static IPatchRedirector $redirector_ = null;
    private static final long CONNECTION_POOL_KEEP_ALIVE_DURATION_MINUTES = 5;
    private static final int CONNECTION_POOL_MAX_IDLE_CONNECTIONS = 5;
    private static final ConfigAwareInstance sInstance;
    private volatile OkHttpClient mOkHttpClient;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40018);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            sInstance = new ConfigAwareInstance();
        }
    }

    public ConfigAwareInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ConfigAwareInstance getInstance() {
        return sInstance;
    }

    public OkHttpClient getOkHttpClient() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (OkHttpClient) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.mOkHttpClient == null) {
            synchronized (ConfigAwareInstance.class) {
                if (this.mOkHttpClient == null) {
                    this.mOkHttpClient = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 5L, TimeUnit.MINUTES)).protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)).build();
                }
            }
        }
        return this.mOkHttpClient.newBuilder().build();
    }
}
