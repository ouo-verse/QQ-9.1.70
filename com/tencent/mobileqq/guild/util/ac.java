package com.tencent.mobileqq.guild.util;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ac {
    public static int a(IGProClientIdentityByteInfo iGProClientIdentityByteInfo) {
        IGProIdentityInfo b16 = b(iGProClientIdentityByteInfo);
        if (b16 != null) {
            return b16.getType();
        }
        return -1;
    }

    public static IGProIdentityInfo b(IGProClientIdentityByteInfo iGProClientIdentityByteInfo) {
        if (iGProClientIdentityByteInfo == null || iGProClientIdentityByteInfo.getClientId() == 0 || iGProClientIdentityByteInfo.getIdentityList() == null || iGProClientIdentityByteInfo.getIdentityList().size() == 0) {
            return null;
        }
        for (IGProIdentityInfo iGProIdentityInfo : iGProClientIdentityByteInfo.getIdentityList()) {
            if (iGProIdentityInfo.getType() == 0 || iGProIdentityInfo.getType() == 1 || iGProIdentityInfo.getType() == 2) {
                return iGProIdentityInfo;
            }
        }
        return null;
    }

    public static boolean c(IGProClientIdentityInfo iGProClientIdentityInfo) {
        if (iGProClientIdentityInfo != null && !TextUtils.equals("0", iGProClientIdentityInfo.getClientId()) && !TextUtils.isEmpty(iGProClientIdentityInfo.getDesc())) {
            return true;
        }
        return false;
    }

    public static void d(AppRuntime appRuntime, TextView textView, IGProRoleManagementTag iGProRoleManagementTag, boolean z16) {
        if (iGProRoleManagementTag != null && !TextUtils.isEmpty(iGProRoleManagementTag.getTagName())) {
            String tagName = iGProRoleManagementTag.getTagName();
            if (z16) {
                tagName = appRuntime.getApplicationContext().getResources().getString(R.string.f155001gb);
            }
            textView.setText(tagName);
            textView.setTextColor(appRuntime.getApplicationContext().getResources().getColor(R.color.f158017al3));
            textView.getBackground().setTint(GuildUIUtils.f235378a.g(iGProRoleManagementTag.getColor()));
            textView.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }
}
