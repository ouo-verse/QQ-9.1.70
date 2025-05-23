package com.tencent.biz.qcircleshadow.lib.variation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostSelectMemberUtils {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class QCircleResultData {
        public String name;
        public String uin;
        public int uinType;
    }

    public static ArrayList<QCircleResultData> getResultList(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
        if (parcelableArrayListExtra != null) {
            ArrayList<QCircleResultData> arrayList = new ArrayList<>(parcelableArrayListExtra.size());
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                ResultRecord resultRecord = (ResultRecord) it.next();
                QCircleResultData qCircleResultData = new QCircleResultData();
                qCircleResultData.uin = resultRecord.uin;
                qCircleResultData.name = resultRecord.name;
                qCircleResultData.uinType = resultRecord.uinType;
                arrayList.add(qCircleResultData);
            }
            return arrayList;
        }
        return null;
    }

    public static void onAtClick(Context context, boolean z16, int i3, int i16, int i17) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, z16);
        bundle.putInt(ISelectMemberActivityConstants.PARAM_MIN, i3);
        bundle.putInt(ISelectMemberActivityConstants.PARAM_MAX, i16);
        bundle.putInt(ISelectMemberActivityConstants.PARAM_ENTRANCE, 42);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult((Activity) context, bundle, i17);
    }

    public static void onCommentPermissionClick(Context context, ArrayList<String> arrayList, int i3) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(ISelectMemberActivityConstants.PARAM_UIN_SELECTED_FRIENDS, arrayList);
        bundle.putBoolean(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        bundle.putInt(ISelectMemberActivityConstants.PARAM_ENTRANCE, 48);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult((Activity) context, bundle, i3);
    }
}
