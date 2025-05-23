package com.tencent.mobileqq.soso.location;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SosoInterfaceModule extends QIPCModule {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_GET_LBS_INFO = "get_lbs_info";
    public static final String ACTION_SET_LBS_INFO = "set_lbs_info";
    public static final String NAME = "soso_interface";
    private static final String TAG = "SOSO.LBS.SosoInterfaceModule";
    private static Object sLock;
    private static volatile SosoInterfaceModule sSosoInterfaceModule;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37091);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            sLock = new Object();
        }
    }

    SosoInterfaceModule(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static SosoInterfaceModule getInterface() {
        if (sSosoInterfaceModule != null) {
            return sSosoInterfaceModule;
        }
        synchronized (sLock) {
            if (sSosoInterfaceModule != null) {
                return sSosoInterfaceModule;
            }
            sSosoInterfaceModule = new SosoInterfaceModule(NAME);
            return sSosoInterfaceModule;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ef  */
    @Override // eipc.EIPCModule
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onCall s: " + str);
        }
        SosoLbsInfo sosoLbsInfo = null;
        if (ACTION_GET_LBS_INFO.equals(str)) {
            boolean z17 = bundle.getBoolean("req_location");
            long j16 = bundle.getLong("max_cache_interval");
            boolean z18 = bundle.getBoolean("goon");
            int i16 = bundle.getInt("level");
            try {
                j3 = j16;
                try {
                    sosoLbsInfo = ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).getCanUsedLbsInfoCache(j16, z18, i16, z17);
                } catch (Exception e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, Log.getStackTraceString(e));
                    }
                    if (QLog.isColorLevel()) {
                    }
                    Bundle bundle2 = new Bundle();
                    EIPCResult eIPCResult = new EIPCResult();
                    eIPCResult.data = bundle2;
                    if (sosoLbsInfo == null) {
                    }
                    return eIPCResult;
                }
            } catch (Exception e17) {
                e = e17;
                j3 = j16;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onCall action on get lbs info : maxCacheInterval: ");
                sb5.append(j3);
                sb5.append(" goonListener: ");
                sb5.append(z18);
                sb5.append(" level: ");
                sb5.append(i16);
                sb5.append(" reqLocation:");
                sb5.append(z17);
                sb5.append(" lbsInfo is null: ");
                if (sosoLbsInfo != null) {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.i(TAG, 2, sb5.toString());
            }
            Bundle bundle22 = new Bundle();
            EIPCResult eIPCResult2 = new EIPCResult();
            eIPCResult2.data = bundle22;
            if (sosoLbsInfo == null) {
                eIPCResult2.code = 0;
                bundle22.putParcelable("soso_lbs_info", sosoLbsInfo);
            } else {
                eIPCResult2.code = -102;
            }
            return eIPCResult2;
        }
        if (!ACTION_SET_LBS_INFO.equals(str)) {
            return null;
        }
        bundle.setClassLoader(((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).getSosoInterfaceClassLoader());
        boolean z19 = bundle.getBoolean("req_location");
        Bundle bundle3 = new Bundle();
        EIPCResult eIPCResult3 = new EIPCResult();
        eIPCResult3.data = bundle3;
        try {
            if (z19) {
                ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).updateMainProcessCachedLocation(bundle.getInt("level"), (SosoLbsInfo) bundle.getParcelable("soso_lbs_info"));
            } else {
                ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).updateRawData(bundle.getString("prodiver"), bundle.getByteArray("raw_data"));
            }
        } catch (Exception e18) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, Log.getStackTraceString(e18));
            }
        }
        eIPCResult3.code = 0;
        return eIPCResult3;
    }
}
