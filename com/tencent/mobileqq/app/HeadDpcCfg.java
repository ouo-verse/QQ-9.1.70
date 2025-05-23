package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class HeadDpcCfg {
    static IPatchRedirector $redirector_ = null;
    private static final String DPC_NAME;
    private static final String TAG = "HeadDpcCfg";
    public static final int VALUE_COUNT = 1;
    private static HeadDpcCfg sInstance;
    private DPCObserver mDpcObserver;
    private int mDualStackPrefIpv6;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements DPCObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeadDpcCfg.this);
            }
        }

        @Override // com.tencent.mobileqq.dpc.DPCObserver
        public void onDpcPullFinished(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else if (z16) {
                HeadDpcCfg.this.loadConfig();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34096);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            DPC_NAME = DPCNames.headDpcCfg.name();
        }
    }

    HeadDpcCfg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mDualStackPrefIpv6 = 1;
        this.mDpcObserver = new a();
        ((IDPCApi) QRoute.api(IDPCApi.class)).addObserver(this.mDpcObserver);
        loadConfig();
    }

    public static HeadDpcCfg get() {
        if (sInstance == null) {
            synchronized (HeadDpcCfg.class) {
                if (sInstance == null) {
                    sInstance = new HeadDpcCfg();
                }
            }
        }
        return sInstance;
    }

    public boolean isPreferIpv6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        QLog.d(TAG, 1, String.format("preferIpv6 mDualStackPrefIpv6=%d", Integer.valueOf(this.mDualStackPrefIpv6)));
        if (this.mDualStackPrefIpv6 != 0) {
            return true;
        }
        return false;
    }

    public void loadConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPC_NAME);
        if (!TextUtils.isEmpty(featureValueWithoutAccountManager)) {
            String[] split = featureValueWithoutAccountManager.split("\\|");
            if (split.length >= 1) {
                try {
                    this.mDualStackPrefIpv6 = Integer.valueOf(split[0]).intValue();
                } catch (Exception e16) {
                    QLog.d(TAG, 1, "loadConfig exception :" + e16.getMessage());
                    this.mDualStackPrefIpv6 = 1;
                }
            }
        } else {
            this.mDualStackPrefIpv6 = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("loadConfig, mDualStackPrefIpv6: %s, dpc=%s", Integer.valueOf(this.mDualStackPrefIpv6), featureValueWithoutAccountManager));
        }
    }
}
