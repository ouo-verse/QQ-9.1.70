package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes35.dex */
public class ExpandPublicFragmentActivity extends QPublicFragmentActivity {
    private static final long LAUNCH_FREQ_CTRL_INTERVAL = 1000;
    private static final String TAG = "ExtendFriendPublicFragmentActivity";
    private static volatile long sLastLaunchTime;

    private static void reportExtendFriendEntry(int i3) {
        String str;
        String str2;
        SosoLocation sosoLocation;
        SosoLbsInfo sosoInfo = ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
        String str3 = "";
        if (sosoInfo == null || (sosoLocation = sosoInfo.mLocation) == null) {
            str = "";
            str2 = str;
        } else {
            if (!TextUtils.isEmpty(sosoLocation.city)) {
                str3 = sosoLocation.city;
            }
            str2 = String.format("%s;%s", Double.valueOf(sosoLocation.mLat02), Double.valueOf(sosoLocation.mLon02));
            str = str3;
        }
        ReportController.o(null, "dc00898", "", "", "0X800AD99", "0X800AD99", i3, 0, "", "", str, str2);
    }

    public static void launchExtendFriendNewFragment(Context context, int i3, boolean z16, String str) {
        QLog.d(TAG, 2, String.format("launchExtendFriendNewFragment context=%s source=%s freqCtrl=%s", context, Integer.valueOf(i3), Boolean.valueOf(z16)));
        long currentTimeMillis = System.currentTimeMillis();
        if (z16 && currentTimeMillis - sLastLaunchTime < 1000) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "launchExtendFriendNewFragment launch too often.");
            }
        } else {
            sLastLaunchTime = currentTimeMillis;
            Intent intent = new Intent();
            intent.putExtra(IExpandFragmentRouter.FROM_TYPE, i3);
            intent.putExtra(IExpandFragmentRouter.TYPE_URL, str);
            QPublicFragmentActivity.b.d(intent, ExpandPublicFragmentActivity.class, ExpandNewFragment.class);
            reportExtendFriendEntry(i3);
        }
    }

    public static String getReportFromPage(int i3) {
        if (i3 == 0) {
            return "7";
        }
        if (i3 == 1) {
            return "1";
        }
        if (i3 == 2) {
            return "2";
        }
        if (i3 == 3) {
            return "3";
        }
        if (i3 == 5) {
            return "6";
        }
        if (i3 != 6) {
            return i3 + "";
        }
        return "5";
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity
    protected void initRequestedOrientation() {
    }
}
