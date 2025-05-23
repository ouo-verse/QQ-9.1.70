package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, IHuayangDowanloadHelper> f238256a = new HashMap<>();

    public static synchronized IHuayangDowanloadHelper a(Context context, String str, String str2) {
        IHuayangDowanloadHelper iHuayangDowanloadHelper;
        synchronized (b.class) {
            String str3 = str2 + str;
            iHuayangDowanloadHelper = f238256a.get(str3);
            if (iHuayangDowanloadHelper == null) {
                iHuayangDowanloadHelper = ((IHuayangDowanloadHelper) QRoute.api(IHuayangDowanloadHelper.class)).init(context, str, str2);
                f238256a.put(str3, iHuayangDowanloadHelper);
            }
        }
        return iHuayangDowanloadHelper;
    }
}
