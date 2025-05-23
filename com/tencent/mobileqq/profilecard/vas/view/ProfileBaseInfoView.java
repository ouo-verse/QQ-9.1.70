package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes16.dex */
public class ProfileBaseInfoView extends LinearLayout implements IProfileContentKey {
    private static final String TAG = "ProfileMoreInfoView";
    private float mDensity;
    private float mLeftSpace;
    private final HashMap<String, View> mMoreInfoMap;

    public ProfileBaseInfoView(Context context) {
        super(context);
        this.mMoreInfoMap = new HashMap<>();
        init(context);
    }

    private boolean checkAndAddDivider(int i3, View view) {
        int i16;
        boolean z16;
        String[] strArr = IProfileContentKey.KEY_MAP_HAS_TOP_DIVIDER;
        int length = strArr.length;
        int i17 = 0;
        while (true) {
            i16 = 1;
            if (i17 < length) {
                if (view == this.mMoreInfoMap.get(strArr[i17])) {
                    z16 = true;
                    break;
                }
                i17++;
            } else {
                z16 = false;
                break;
            }
        }
        if (QQTheme.isNowSimpleUI()) {
            z16 = false;
        }
        if (z16 && getChildCount() == 0) {
            z16 = false;
        }
        if (z16) {
            String format = String.format("%s_%s", IProfileContentKey.MAP_KEY_DIVIDER, Integer.valueOf(i3));
            View view2 = this.mMoreInfoMap.get(format);
            if (view2 == null || view2.getParent() != null) {
                if (view2 != null) {
                    QLog.e(TAG, 1, String.format("checkAndAddDivider dividerView=%s viewParent=%s", view2, view2.getParent()));
                }
                int i18 = (int) (this.mDensity * 0.75f);
                if (i18 >= 1) {
                    i16 = i18;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i16);
                layoutParams.leftMargin = (int) this.mLeftSpace;
                float f16 = this.mDensity;
                layoutParams.topMargin = (int) (f16 * 6.0f);
                layoutParams.bottomMargin = (int) (f16 * 6.0f);
                view2 = new View(getContext());
                view2.setLayoutParams(layoutParams);
                view2.setBackgroundResource(R.drawable.f162459hj3);
                this.mMoreInfoMap.put(format, view2);
            }
            addView(view2);
        }
        return z16;
    }

    private void init(Context context) {
        this.mDensity = context.getResources().getDisplayMetrics().density;
        this.mLeftSpace = r4.getDimensionPixelSize(R.dimen.f159041uo) + r4.getDimensionPixelSize(R.dimen.a07) + r4.getDimensionPixelSize(R.dimen.a08);
    }

    private boolean isDefaultProfile(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo == null || profileCardInfo.curUseStyleId != ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) {
            return false;
        }
        return true;
    }

    public HashMap<String, View> getMoreInfoMap() {
        return this.mMoreInfoMap;
    }

    public void rebuildProfileContent(ProfileCardInfo profileCardInfo) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "rebuildProfileContent");
        }
        removeAllViews();
        ArrayList arrayList = new ArrayList();
        for (String[] strArr : IProfileContentKey.COMPONENT_ADD_LIST_NORMAL) {
            for (String str : strArr) {
                View view = this.mMoreInfoMap.get(str);
                if (view != null) {
                    arrayList.add(view);
                }
                if (QLog.isDebugVersion()) {
                    QLog.d(TAG, 2, String.format("rebuildProfileContent key==%s view=%s", str, view));
                }
            }
        }
        int size = arrayList.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            View view2 = (View) arrayList.get(i16);
            if (isDefaultProfile(profileCardInfo) && checkAndAddDivider(i3, view2)) {
                i3++;
            }
            ViewParent parent = view2.getParent();
            if (parent != null) {
                QLog.e(TAG, 1, String.format("updateMoreInfo itemView=%s viewParent=%s", view2, parent));
                for (String str2 : this.mMoreInfoMap.keySet()) {
                    QLog.e(TAG, 1, String.format("updateMoreInfo key=%s view=%s", str2, this.mMoreInfoMap.get(str2)));
                }
            }
            addView(view2);
        }
    }

    public ProfileBaseInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMoreInfoMap = new HashMap<>();
        init(context);
    }
}
