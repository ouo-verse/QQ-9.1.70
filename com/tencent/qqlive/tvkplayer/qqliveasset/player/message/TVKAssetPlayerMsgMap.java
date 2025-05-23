package com.tencent.qqlive.tvkplayer.qqliveasset.player.message;

import android.util.SparseArray;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.qqlive.tvkplayer.logic.TVKPlayerManager;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
public class TVKAssetPlayerMsgMap {
    private static final int MSG_INFO_DEFAULT = -1;
    private static final String TAG = "TVKPlayer[TVKAssetPlayerMsgMap]";
    private static final SparseArray<Integer> sTPOnInfoIDToAssetPlayerMsgMap = new SparseArray<>();
    private static final SparseArray<Integer> sAssetPlayerMsgToTVKMsgMap = new SparseArray<>();
    private static final Map<Class<?>, SparseArray<Method>> sMsgDealMethodMap = new HashMap();

    @Target({ElementType.METHOD, ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes23.dex */
    public @interface DealWithMsg {
        int[] msg() default {};
    }

    @Target({ElementType.FIELD, ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes23.dex */
    public @interface MapMsgInfo {
        int msg() default 20;

        int tpOnInfoID() default -1;
    }

    static {
        initMsgMap();
        initDealMethodsMap(TVKPlayerManager.class);
        initDealMethodsMap(TVKPlayerMsgHandler.class);
    }

    public static int convertToAssetPlayerMsg(int i3) {
        return sTPOnInfoIDToAssetPlayerMsgMap.get(i3, 0).intValue();
    }

    public static int convertToPlayerMsg(int i3) {
        return sAssetPlayerMsgToTVKMsgMap.get(i3, 20).intValue();
    }

    public static boolean getMethodAndInvoke(Class<?> cls, int i3, Object obj, Object obj2) {
        Method methodForMsg = getMethodForMsg(cls, i3);
        if (methodForMsg == null) {
            return false;
        }
        invokeMethod(methodForMsg, obj, obj2);
        return true;
    }

    private static Method getMethodForMsg(Class<?> cls, int i3) {
        SparseArray<Method> sparseArray = sMsgDealMethodMap.get(cls);
        if (sparseArray != null && sparseArray.size() != 0) {
            Method method = sparseArray.get(i3, null);
            if (method == null) {
                return sparseArray.get(-1);
            }
            return method;
        }
        TVKLogUtil.e(TAG, "getDealMethods is null, not has methods with @DealMsg, class:" + cls.getName());
        return null;
    }

    private static void initDealMethodsMap(Class<?> cls) {
        try {
            SparseArray<Method> sparseArray = new SparseArray<>();
            for (Method method : cls.getDeclaredMethods()) {
                method.setAccessible(true);
                DealWithMsg dealWithMsg = (DealWithMsg) method.getAnnotation(DealWithMsg.class);
                if (dealWithMsg != null) {
                    int[] msg2 = dealWithMsg.msg();
                    if (msg2.length == 0) {
                        sparseArray.put(-1, method);
                    } else {
                        for (int i3 : msg2) {
                            sparseArray.put(i3, method);
                        }
                    }
                }
            }
            sMsgDealMethodMap.put(cls, sparseArray);
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, "initDealMethodsMap has exception:" + th5.toString());
        }
    }

    private static void initMsgMap() {
        try {
            Class<?> cls = Class.forName(TVKQQLiveAssetPlayerMsg.class.getName());
            for (Field field : cls.getDeclaredFields()) {
                if (PoiListCacheRecord.WEIGHT_TYPE.equals(field.getType().toString())) {
                    field.setAccessible(true);
                    MapMsgInfo mapMsgInfo = (MapMsgInfo) field.getAnnotation(MapMsgInfo.class);
                    if (mapMsgInfo != null) {
                        sAssetPlayerMsgToTVKMsgMap.put(field.getInt(cls), Integer.valueOf(mapMsgInfo.msg()));
                        if (mapMsgInfo.tpOnInfoID() != -1) {
                            sTPOnInfoIDToAssetPlayerMsgMap.put(mapMsgInfo.tpOnInfoID(), Integer.valueOf(field.getInt(cls)));
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, "initMsgMap has exception:" + th5.toString());
        }
    }

    private static void invokeMethod(Method method, Object obj, Object obj2) {
        if (obj == null) {
            return;
        }
        try {
            if (method.getParameterTypes().length == 0) {
                method.invoke(obj, new Object[0]);
            } else {
                method.invoke(obj, obj2);
            }
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, "instance=" + obj.getClass().getName() + ", method=" + method.getName() + ", invokeMethod has exception: " + e16.getCause());
        }
    }

    public static void init() {
    }
}
