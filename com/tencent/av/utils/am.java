package com.tencent.av.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes3.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean[] f76982a;

    private static void a() {
        f76982a = new Boolean[4];
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qavUseSurface.name(), "1|1|1|1");
        if (!TextUtils.isEmpty(featureValue)) {
            String[] split = featureValue.split("\\|");
            int i3 = 0;
            while (true) {
                Boolean[] boolArr = f76982a;
                if (i3 >= boolArr.length) {
                    break;
                }
                if (i3 < split.length) {
                    boolArr[i3] = Boolean.valueOf("1".equals(split[i3]));
                } else {
                    boolArr[i3] = Boolean.FALSE;
                }
                i3++;
            }
        } else {
            Arrays.fill(f76982a, Boolean.FALSE);
        }
        if (QLog.isColorLevel()) {
            QLog.i("QavDpcUtil", 2, "initQavSurfaceDpc, dpcValue[" + featureValue + "]");
        }
    }

    public static boolean b(int i3) {
        Boolean bool;
        if (f76982a == null) {
            a();
        }
        Boolean[] boolArr = f76982a;
        if (boolArr == null || i3 >= boolArr.length || (bool = boolArr[i3]) == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }
}
