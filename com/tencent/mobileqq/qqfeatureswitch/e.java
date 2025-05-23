package com.tencent.mobileqq.qqfeatureswitch;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.impl.ShiplyImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.rdelivery.data.RDeliveryData;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e implements b {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.b
    public void a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.b
    public Map<String, FeatureSwitch> b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Map) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Map<String, RDeliveryData> allRDeliveryData = ((ShiplyImpl) QRoute.api(IShiply.class)).getAllRDeliveryData();
        HashMap hashMap = new HashMap();
        if (allRDeliveryData == null) {
            return hashMap;
        }
        for (String str : allRDeliveryData.keySet()) {
            RDeliveryData rDeliveryData = allRDeliveryData.get(str);
            FeatureSwitch featureSwitch = new FeatureSwitch();
            if (rDeliveryData != null && Boolean.TRUE.equals(rDeliveryData.getSwitchValue())) {
                z16 = true;
            } else {
                z16 = false;
            }
            featureSwitch.mSwitchEnable = z16;
            featureSwitch.mSwitchName = str;
            hashMap.put(str, featureSwitch);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.b
    public FeatureSwitch c(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FeatureSwitch) iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
        }
        FeatureSwitch featureSwitch = new FeatureSwitch();
        featureSwitch.mSwitchEnable = ((IShiply) QRoute.api(IShiply.class)).isSwitchOn(str, z16);
        featureSwitch.mSwitchName = str;
        return featureSwitch;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.b
    public boolean d(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        return ((IShiply) QRoute.api(IShiply.class)).isSwitchOn(str, z16);
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
