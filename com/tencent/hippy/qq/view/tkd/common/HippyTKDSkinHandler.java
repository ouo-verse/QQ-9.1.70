package com.tencent.hippy.qq.view.tkd.common;

import android.view.View;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.views.common.CommonBorder;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDSkinHandler {
    HippyArray mBackgroundColors;
    HippyArray mBorderBottomColors;
    HippyArray mBorderColors;
    HippyArray mBorderLeftColors;
    HippyArray mBorderRightColors;
    HippyArray mBorderTopColors;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface HippyQBCommonSkin {
        void hippySwitchSkin();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IHippyQBCommonPictureMode {
        void onPictureModeChanage();
    }

    public static int getColor(HippyArray hippyArray) {
        if (hippyArray == null || hippyArray.size() <= 0) {
            return 0;
        }
        int i3 = hippyArray.getInt(0);
        if (ThemeUtil.isNowThemeIsNight(null, false, "") && hippyArray.size() > 1) {
            return hippyArray.getInt(1);
        }
        return i3;
    }

    public static String getSource(HippyArray hippyArray) {
        if (hippyArray == null || hippyArray.size() <= 0) {
            return null;
        }
        String string = hippyArray.getString(0);
        if (ThemeUtil.isNowThemeIsNight(null, false, "") && hippyArray.size() > 1) {
            return hippyArray.getString(1);
        }
        return string;
    }

    public HippyArray getBackgroundColors() {
        return this.mBackgroundColors;
    }

    public void setBackgroundColors(View view, HippyArray hippyArray) {
        this.mBackgroundColors = hippyArray;
        view.setBackgroundColor(getColor(hippyArray));
    }

    public void setBorderBottomColors(CommonBorder commonBorder, HippyArray hippyArray) {
        this.mBorderBottomColors = hippyArray;
        commonBorder.setBorderColor(getColor(hippyArray), CommonBorder.BorderWidthDirection.BOTTOM.ordinal());
    }

    public void setBorderColors(CommonBorder commonBorder, HippyArray hippyArray) {
        this.mBorderColors = hippyArray;
        commonBorder.setBorderColor(getColor(hippyArray), CommonBorder.BorderWidthDirection.ALL.ordinal());
    }

    public void setBorderLeftColors(CommonBorder commonBorder, HippyArray hippyArray) {
        this.mBorderLeftColors = hippyArray;
        commonBorder.setBorderColor(getColor(hippyArray), CommonBorder.BorderWidthDirection.LEFT.ordinal());
    }

    public void setBorderRightColors(CommonBorder commonBorder, HippyArray hippyArray) {
        this.mBorderRightColors = hippyArray;
        commonBorder.setBorderColor(getColor(hippyArray), CommonBorder.BorderWidthDirection.RIGHT.ordinal());
    }

    public void setBorderTopColors(CommonBorder commonBorder, HippyArray hippyArray) {
        this.mBorderTopColors = hippyArray;
        commonBorder.setBorderColor(getColor(hippyArray), CommonBorder.BorderWidthDirection.TOP.ordinal());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void switchSkin(View view) {
        HippyArray hippyArray = this.mBackgroundColors;
        if (hippyArray != null) {
            setBackgroundColors(view, hippyArray);
        }
        HippyArray hippyArray2 = this.mBorderColors;
        if (hippyArray2 != null && (view instanceof CommonBorder)) {
            setBorderColors((CommonBorder) view, hippyArray2);
        }
        HippyArray hippyArray3 = this.mBorderLeftColors;
        if (hippyArray3 != null && (view instanceof CommonBorder)) {
            setBorderLeftColors((CommonBorder) view, hippyArray3);
        }
        HippyArray hippyArray4 = this.mBorderTopColors;
        if (hippyArray4 != null && (view instanceof CommonBorder)) {
            setBorderTopColors((CommonBorder) view, hippyArray4);
        }
        HippyArray hippyArray5 = this.mBorderRightColors;
        if (hippyArray5 != null && (view instanceof CommonBorder)) {
            setBorderRightColors((CommonBorder) view, hippyArray5);
        }
        HippyArray hippyArray6 = this.mBorderBottomColors;
        if (hippyArray6 != null && (view instanceof CommonBorder)) {
            setBorderBottomColors((CommonBorder) view, hippyArray6);
        }
    }
}
