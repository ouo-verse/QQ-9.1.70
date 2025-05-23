package com.tencent.mobileqq.statistics;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b implements IConfigData {
    static IPatchRedirector $redirector_;

    @SerializedName(WadlProxyConsts.CHANNEL)
    private final int channel;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.channel = 1;
        }
    }

    public static boolean a() {
        b bVar = (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("beacon_channel_config");
        if (bVar == null || bVar.channel == 1) {
            return true;
        }
        return false;
    }

    public static b b(String str) {
        QLog.d("BeaconChannelParser", 1, "[parse] content: ", str);
        if (TextUtils.isEmpty(str)) {
            return new b();
        }
        try {
            return (b) new Gson().fromJson(str, b.class);
        } catch (Throwable th5) {
            QLog.e("BeaconChannelParser", 1, "[parse] error: ", th5);
            return new b();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "BeaconChannelConfigBean{channel=" + this.channel + '}';
    }
}
