package com.tencent.gamematrix.gmcg.sdk.nonage.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QtvResouceReflact {
    private static final String TAG = "QtvResouceReflact";
    private static IQtvResourceReflact sQtvResourceReflact;

    public static Activity getActivity() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
        } catch (NoSuchMethodException e19) {
            e19.printStackTrace();
        } catch (InvocationTargetException e26) {
            e26.printStackTrace();
        }
        return null;
    }

    public static int getArrayId(String str) {
        IQtvResourceReflact iQtvResourceReflact = sQtvResourceReflact;
        if (iQtvResourceReflact == null) {
            Log.d(TAG, "getArrayId: fatal sQtvResourceReflact == null");
            return 0;
        }
        return iQtvResourceReflact.getArrayId(str);
    }

    public static int getColorId(String str) {
        IQtvResourceReflact iQtvResourceReflact = sQtvResourceReflact;
        if (iQtvResourceReflact == null) {
            Log.d(TAG, "getColorId: fatal sQtvResourceReflact == null");
            return 0;
        }
        return iQtvResourceReflact.getColorId(str);
    }

    public static Context getContext() {
        IQtvResourceReflact iQtvResourceReflact = sQtvResourceReflact;
        if (iQtvResourceReflact == null) {
            return null;
        }
        return iQtvResourceReflact.getContext();
    }

    public static int getDimenId(String str) {
        IQtvResourceReflact iQtvResourceReflact = sQtvResourceReflact;
        if (iQtvResourceReflact == null) {
            Log.d(TAG, "getDimenId: fatal sQtvResourceReflact == null");
            return 0;
        }
        return iQtvResourceReflact.getDimenId(str);
    }

    public static int getDrawableId(String str) {
        IQtvResourceReflact iQtvResourceReflact = sQtvResourceReflact;
        if (iQtvResourceReflact == null) {
            Log.d(TAG, "getDrawableId: fatal sQtvResourceReflact == null");
            return 0;
        }
        return iQtvResourceReflact.getDrawableId(str);
    }

    public static int getId(String str) {
        IQtvResourceReflact iQtvResourceReflact = sQtvResourceReflact;
        if (iQtvResourceReflact == null) {
            Log.d(TAG, "getId: fatal sQtvResourceReflact == null");
            return 0;
        }
        return iQtvResourceReflact.getId(str);
    }

    public static int getLayoutId(String str) {
        IQtvResourceReflact iQtvResourceReflact = sQtvResourceReflact;
        if (iQtvResourceReflact == null) {
            Log.d(TAG, "getLayoutId: fatal sQtvResourceReflact == null");
            return 0;
        }
        return iQtvResourceReflact.getLayoutId(str);
    }

    public static int getStringId(String str) {
        IQtvResourceReflact iQtvResourceReflact = sQtvResourceReflact;
        if (iQtvResourceReflact == null) {
            Log.d(TAG, "getStringId: fatal sQtvResourceReflact == null");
            return 0;
        }
        return iQtvResourceReflact.getStringId(str);
    }

    public static int getStyleId(String str) {
        IQtvResourceReflact iQtvResourceReflact = sQtvResourceReflact;
        if (iQtvResourceReflact == null) {
            Log.d(TAG, "getStyleId: fatal sQtvResourceReflact == null");
            return 0;
        }
        return iQtvResourceReflact.getStyleId(str);
    }

    public static void init(IQtvResourceReflact iQtvResourceReflact) {
        String str;
        String str2 = TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("init: now set qtvResourceReflact :");
        if (iQtvResourceReflact != null) {
            str = " not null ";
        } else {
            str = "null";
        }
        sb5.append(str);
        Log.d(str2, sb5.toString());
        sQtvResourceReflact = iQtvResourceReflact;
    }
}
