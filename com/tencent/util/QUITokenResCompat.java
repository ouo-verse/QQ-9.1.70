package com.tencent.util;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QUITokenResCompat {
    static IPatchRedirector $redirector_ = null;
    private static final String SWITCH_QUI_TOKEN_RES_MAPPING = "qui_token_res_mapping";
    private static final String TAG = "QUITokenResCompat";
    private static Map<Integer, Integer> sSuperResMapping;
    private static volatile Boolean sTokenResMappingSwitchOn;
    private static Map<Integer, Integer> sVasResMapping;

    public QUITokenResCompat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getDrawableResId(int i3) {
        Integer num;
        Map<Integer, Integer> map;
        Map<Integer, Integer> map2;
        if (isTokenResMappingSwitchOn()) {
            return i3;
        }
        try {
            if (QQTheme.isNowThemeIsSuperTheme() && (map2 = sSuperResMapping) != null) {
                num = map2.get(Integer.valueOf(i3));
            } else {
                num = null;
            }
            if (num == null && QQTheme.isVasTheme() && (map = sVasResMapping) != null) {
                num = map.get(Integer.valueOf(i3));
            }
            if (num != null && num.intValue() != 0) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(TAG, 4, "getDrawableResId tokenResId = " + i3 + " mappingResId = " + num);
                }
                return num.intValue();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 2, "getDrawableResId exception", e16);
        }
        return i3;
    }

    public static StateListDrawable getStateListDrawable(Context context, int[][] iArr, int[] iArr2) {
        if (iArr != null && iArr2 != null && iArr.length == iArr2.length) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            for (int i3 = 0; i3 < iArr.length; i3++) {
                stateListDrawable.addState(iArr[i3], ContextCompat.getDrawable(context, getDrawableResId(iArr2[i3])));
            }
            return stateListDrawable;
        }
        return null;
    }

    public static boolean isTokenResMappingSwitchOn() {
        if (sTokenResMappingSwitchOn != null) {
            return sTokenResMappingSwitchOn.booleanValue();
        }
        sTokenResMappingSwitchOn = Boolean.valueOf(((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn(SWITCH_QUI_TOKEN_RES_MAPPING, true));
        return sTokenResMappingSwitchOn.booleanValue();
    }

    public static void updateMappingConfig(Map<Integer, Integer> map, Map<Integer, Integer> map2) {
        sVasResMapping = map;
        sSuperResMapping = map2;
    }
}
