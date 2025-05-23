package com.tenpay.sdk.apilogic;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tenpay.api.QFuncProxy;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiUtil {
    public static int CHOOSE_FRIENDS_RESULT_CODE = 6666;

    public static void chooseFriends(Activity activity, String str, String str2, String str3, String str4, int i3, int i16, ResultReceiver resultReceiver) {
        if (resultReceiver == null) {
            return;
        }
        Parcel obtain = Parcel.obtain();
        resultReceiver.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, i16);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        intent.putExtra("choose_friend_subcontent", str2 + HardCodeUtil.qqStr(R.string.rki));
        intent.putExtra("choose_friend_content", str3);
        intent.putExtra("iPayFrom", i3);
        intent.putExtra("choose_friend_total_fee", str4);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, str);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_AAPAY_RESULT_RECEIVER, resultReceiver2);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 33);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(activity, intent, CHOOSE_FRIENDS_RESULT_CODE);
    }

    public static void enterSDK(String str) {
        QFuncProxy.setUin(str);
    }
}
