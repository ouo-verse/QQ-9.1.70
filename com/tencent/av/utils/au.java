package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    public static String f77059a = "ShareUtils";

    public static com.tencent.mobileqq.utils.ax a(com.tencent.mobileqq.utils.ax axVar, Context context, String str) {
        Intent intent;
        if ((context instanceof JumpActivity) && (intent = ((JumpActivity) context).getIntent()) != null) {
            axVar.r("from_url_InternalCheck", intent.getStringExtra("url"));
        }
        String[] d16 = bi.d(str, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        String str2 = d16[0];
        String str3 = d16[1];
        String[] split = str2.split("//");
        if (split.length != 2) {
            return null;
        }
        axVar.f307438c = str;
        axVar.f307439d = "mqqavshare://";
        axVar.f307440e = split[1];
        StringBuilder sb5 = new StringBuilder("parser, jumpStr[" + str + "], server_name[" + axVar.f307439d + "], action_name[" + axVar.f307440e + "]");
        String[] split2 = str3.split(ContainerUtils.FIELD_DELIMITER);
        int length = split2.length;
        for (int i3 = 0; i3 < length; i3++) {
            String[] split3 = split2[i3].split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split3.length == 2) {
                String a16 = bi.a(split3[1], false);
                axVar.r(split3[0], a16);
                sb5.append(", [");
                sb5.append(split3[0]);
                sb5.append("]=[");
                sb5.append(a16);
                sb5.append("]");
            }
        }
        QLog.w(f77059a, 1, sb5.toString());
        return axVar;
    }

    public static void b(AppInterface appInterface, Context context, String str, String str2, String str3, String str4) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("image_url", arrayList);
        bundle.putString("title", str2);
        bundle.putString("desc", str3);
        bundle.putLong("req_share_id", 0L);
        bundle.putString("detail_url", str4);
        QZoneShareManager.jumpToQzoneShare(appInterface, context, bundle, null);
        if (QLog.isColorLevel()) {
            QLog.i(f77059a, 2, "shareToQzone. title:" + str2 + " desc:" + str3 + " shareLink:" + str4 + " icon:" + str);
        }
    }
}
