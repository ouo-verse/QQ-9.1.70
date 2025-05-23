package com.tencent.mobileqq.utils.abtest;

import android.R;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.impl.u;
import com.tencent.mobileqq.qcircle.api.impl.QCircleOnlineExpProviderImpl;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class ABTestUtil {
    public static final String ABTEST_EVENT_CODE = "AbtestEvtExpose";
    public static final int EVT_TYPE_EXPEVENT = 1;
    public static final int EVT_TYPE_EXPOSURE = 0;
    public static final int MILLISECONDS_IN_DAY = 86400000;

    @ConfigInject(configPath = "Foundation/QQCommon/src/main/resources/Inject_Online_TabExpList.yml", version = 1)
    public static ArrayList<Class<? extends IOnlineExpProvider>> sOnlineExpInjector;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes20.dex */
    @interface EventType {
    }

    static {
        ArrayList<Class<? extends IOnlineExpProvider>> arrayList = new ArrayList<>();
        sOnlineExpInjector = arrayList;
        arrayList.add(QCircleOnlineExpProviderImpl.class);
        sOnlineExpInjector.add(yt.d.class);
        sOnlineExpInjector.add(QCommonOnlineExpProviderImpl.class);
        sOnlineExpInjector.add(com.tencent.gdtad.impl.a.class);
        sOnlineExpInjector.add(oi4.a.class);
        sOnlineExpInjector.add(ok2.a.class);
        sOnlineExpInjector.add(u.class);
        sOnlineExpInjector.add(com.tencent.mobileqq.gamecenter.qa.api.impl.a.class);
        sOnlineExpInjector.add(com.tencent.relation.common.abtest.c.class);
    }

    public static List<String> getInjectedExpList() {
        try {
            ArrayList<Class<? extends IOnlineExpProvider>> arrayList = sOnlineExpInjector;
            if (arrayList != null && !arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<Class<? extends IOnlineExpProvider>> it = sOnlineExpInjector.iterator();
                while (it.hasNext()) {
                    Class<? extends IOnlineExpProvider> next = it.next();
                    if (next == null) {
                        log("getInjectedExpList when clazz=null");
                    } else {
                        Constructor<? extends IOnlineExpProvider> declaredConstructor = next.getDeclaredConstructor(new Class[0]);
                        declaredConstructor.setAccessible(true);
                        IOnlineExpProvider newInstance = declaredConstructor.newInstance(new Object[0]);
                        if (newInstance != null) {
                            arrayList2.addAll(newInstance.getRegisterExpNameList());
                        }
                    }
                }
                return arrayList2;
            }
            log("getInjectedExpList sOnlineExpInjector=null or isEmpty");
            return null;
        } catch (Exception e16) {
            log("getInjectedExpList error:" + e16.getMessage());
            return null;
        }
    }

    public static Map<String, String> getInjectedProfiles() {
        try {
            ArrayList<Class<? extends IOnlineExpProvider>> arrayList = sOnlineExpInjector;
            if (arrayList != null && !arrayList.isEmpty()) {
                HashMap hashMap = new HashMap();
                Iterator<Class<? extends IOnlineExpProvider>> it = sOnlineExpInjector.iterator();
                while (it.hasNext()) {
                    Class<? extends IOnlineExpProvider> next = it.next();
                    if (next == null) {
                        log("getInjectedProfiles when clazz=null");
                    } else {
                        Constructor<? extends IOnlineExpProvider> declaredConstructor = next.getDeclaredConstructor(new Class[0]);
                        declaredConstructor.setAccessible(true);
                        IOnlineExpProvider newInstance = declaredConstructor.newInstance(new Object[0]);
                        if (newInstance != null && newInstance.getBusinessProfiles() != null && newInstance.getBusinessProfiles().size() > 0) {
                            hashMap.putAll(newInstance.getBusinessProfiles());
                        }
                    }
                }
                return hashMap;
            }
            log("getInjectedProfiles sOnlineExpInjector=null or isEmpty");
            return null;
        } catch (Exception e16) {
            log("getInjectedProfiles error:" + e16.getMessage());
            return null;
        }
    }

    public static StateListDrawable getStateListDrawable(Drawable drawable, Drawable drawable2) {
        if (drawable != null && drawable2 != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_activated}, drawable2);
            stateListDrawable.addState(new int[]{-16843518}, drawable);
            return stateListDrawable;
        }
        return null;
    }

    public static URLDrawable getUrlDrawable(String str, int i3, int i16) {
        if (!TextUtils.isEmpty(str) && i3 > 0 && i16 > 0 && str.startsWith("https")) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i16;
            obtain.mUseApngImage = false;
            obtain.mUseMemoryCache = true;
            obtain.mLoadingDrawable = new ColorDrawable(0);
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            if (drawable != null) {
                drawable.startDownload();
            }
            return drawable;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOUtils", 2, "getUrlDrawable params error, url:" + str);
            return null;
        }
        return null;
    }

    public static boolean getVideoEditABTest() {
        return getVideoEditABTest(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
    }

    public static boolean isExpUpdatable(ExpEntityInfo expEntityInfo) {
        if (expEntityInfo != null && expEntityInfo.isExpOnline() && isValidExpValue(expEntityInfo.getExpName())) {
            return !isValidExpValue(expEntityInfo.getAssignment());
        }
        return false;
    }

    public static boolean isValidExpValue(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals("default", str)) {
            return true;
        }
        return false;
    }

    public static void log(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ABTestController", 2, str);
        }
    }

    private static boolean moreThan24Hours(long j3) {
        if (System.currentTimeMillis() - j3 > 86400000) {
            return true;
        }
        return false;
    }

    public static boolean getVideoEditABTest(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_NEW_VIDEO_EDIT);
        boolean z16 = !expEntity.isContrast();
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(str + "_" + AppConstants.Preferences.AIO_CONFIG, 0);
        if (moreThan24Hours(sharedPreferences.getLong(AppConstants.Preferences.VIDEO_EDIT_ENABLED_ABTEST_REPORT_TIME, 0L))) {
            expEntity.reportExpExposure();
            sharedPreferences.edit().putLong(AppConstants.Preferences.VIDEO_EDIT_ENABLED_ABTEST_REPORT_TIME, System.currentTimeMillis()).apply();
        }
        return z16;
    }

    public static void log(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }
}
