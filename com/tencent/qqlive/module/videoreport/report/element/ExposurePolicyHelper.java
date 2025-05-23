package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.page.ViewContainerBinder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes22.dex */
public class ExposurePolicyHelper {
    public static final String TAG = "ExposurePolicy";

    public static void clearEleExposureMap(Object obj) {
        getEleExposureMap(obj).clear();
    }

    private static EleExposeInfo getCacheEleExposeInfo(Object obj, View view, String str, boolean z16) {
        Object obj2 = getEleExposureMap(obj).get(getReExposeKey(obj, view, str, z16));
        if (obj2 instanceof EleExposeInfo) {
            return (EleExposeInfo) obj2;
        }
        return null;
    }

    @Nullable
    public static EleExposeInfo getEleExposeInfo(Object obj, View view, String str, boolean z16) {
        Object pageOrContainer = getPageOrContainer(obj, view);
        if (pageOrContainer == null) {
            return null;
        }
        return getCacheEleExposeInfo(pageOrContainer, view, str, z16);
    }

    @NonNull
    private static Map<String, Object> getEleExposureMap(Object obj) {
        Object innerParam = DataRWProxy.getInnerParam(obj, InnerKey.ELEMENT_EXPOSURE_MAP);
        if (!(innerParam instanceof Map)) {
            HashMap hashMap = new HashMap();
            DataRWProxy.setInnerParam(obj, InnerKey.ELEMENT_EXPOSURE_MAP, hashMap);
            return hashMap;
        }
        return (Map) innerParam;
    }

    private static Object getPageOrContainer(Object obj, View view) {
        Object boundContainer;
        if (obj == null) {
            if (view == null || (boundContainer = ViewContainerBinder.getInstance().getBoundContainer(view.getRootView())) == null) {
                return null;
            }
            return boundContainer;
        }
        return obj;
    }

    public static String getReExposeKey(Object obj, View view, String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            str = "";
            if (view != null) {
                str = view.hashCode() + "";
            }
        }
        if (z16) {
            str = DTConstants.IDENTIFIER_SCROLL_PRIEF + str;
        }
        return obj.hashCode() + str;
    }

    public static void putEleExposeInfo(Object obj, View view, String str, EleExposeInfo eleExposeInfo, boolean z16) {
        Object pageOrContainer = getPageOrContainer(obj, view);
        if (pageOrContainer == null) {
            return;
        }
        putEleExposeInfo(pageOrContainer, getReExposeKey(pageOrContainer, view, str, z16), eleExposeInfo);
    }

    private static void putEleExposeInfo(Object obj, String str, EleExposeInfo eleExposeInfo) {
        getEleExposureMap(obj).put(str, eleExposeInfo);
    }
}
