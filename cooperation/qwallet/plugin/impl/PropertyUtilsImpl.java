package cooperation.qwallet.plugin.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.al;
import cooperation.qwallet.plugin.IPropertyUtils;

/* loaded from: classes28.dex */
public class PropertyUtilsImpl implements IPropertyUtils {
    private static String mNetworkType;
    private static int mScreenWidth;
    private static int mTitleBarHeight;
    private static int mToastOffset;

    /* loaded from: classes28.dex */
    interface NetType {
        public static final int CABLE = 5;
        public static final int G2 = 2;
        public static final int G3 = 3;
        public static final int G4 = 4;
        public static final int NONE = 0;
        public static final int WIFI = 1;
    }

    @Override // cooperation.qwallet.plugin.IPropertyUtils
    public String getNetworkType(Context context) {
        if (context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(mNetworkType)) {
            return mNetworkType;
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(context.getApplicationContext());
        if (systemNetwork == 1) {
            mNetworkType = Global.TRACKING_WIFI;
        } else if (systemNetwork == 2) {
            mNetworkType = "2G";
        } else if (systemNetwork == 3) {
            mNetworkType = "3G";
        } else if (systemNetwork == 4) {
            mNetworkType = "4G";
        } else {
            mNetworkType = "unknown";
        }
        return mNetworkType;
    }

    @Override // cooperation.qwallet.plugin.IPropertyUtils
    public int getScreenWidth(Activity activity) {
        int i3 = mScreenWidth;
        if (i3 > 0) {
            return i3;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i16 = displayMetrics.widthPixels;
        mScreenWidth = i16;
        return i16;
    }

    @Override // cooperation.qwallet.plugin.IPropertyUtils
    public int getTitleBarHeight(Activity activity) {
        int i3 = mTitleBarHeight;
        if (i3 > 0) {
            return i3;
        }
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        mTitleBarHeight = dimensionPixelSize;
        return dimensionPixelSize;
    }

    @Override // cooperation.qwallet.plugin.IPropertyUtils
    public int getToastOffset(Context context) {
        int i3 = mToastOffset;
        if (i3 > 0) {
            return i3;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) al.a(context, 5.0f));
        mToastOffset = dimensionPixelSize;
        return dimensionPixelSize;
    }
}
