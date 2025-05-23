package mqq.app;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AndroidOreoUtils {
    private Activity mActivity;
    private ActivityInfo mActivityInfo = null;

    public AndroidOreoUtils(Activity activity) {
        this.mActivity = activity;
    }

    public boolean fixOrientation() {
        if (Build.VERSION.SDK_INT == 26) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ActivityInfo activityInfo = (ActivityInfo) declaredField.get(this.mActivity);
                if (isFixedOrientation(activityInfo, activityInfo.screenOrientation)) {
                    activityInfo.screenOrientation = -1;
                }
                declaredField.setAccessible(false);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public ActivityInfo getCurrentActivityInfo() {
        if (this.mActivityInfo == null) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                this.mActivityInfo = (ActivityInfo) declaredField.get(this.mActivity);
                declaredField.setAccessible(false);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return this.mActivityInfo;
    }

    public boolean isFixedOrientation(ActivityInfo activityInfo, int i3) {
        boolean z16 = false;
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        try {
            Method method = ActivityInfo.class.getMethod("isFixedOrientation", Integer.TYPE);
            method.setAccessible(true);
            boolean booleanValue = ((Boolean) method.invoke(activityInfo, Integer.valueOf(i3))).booleanValue();
            try {
                method.setAccessible(false);
                return booleanValue;
            } catch (Exception e16) {
                e = e16;
                z16 = booleanValue;
                e.printStackTrace();
                return z16;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public boolean isTranslucentOrFloating() {
        boolean z16 = false;
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        try {
            TypedArray obtainStyledAttributes = this.mActivity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            boolean booleanValue = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
                return booleanValue;
            } catch (Exception e16) {
                e = e16;
                z16 = booleanValue;
                e.printStackTrace();
                return z16;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
