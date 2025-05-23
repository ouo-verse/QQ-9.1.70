package com.tencent.mobileqq.wink.publish.util;

import android.text.Editable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneTextApi;

/* compiled from: P */
/* loaded from: classes21.dex */
public class e {
    public static Editable.Factory a() {
        return ((IQzoneTextApi) QRoute.api(IQzoneTextApi.class)).getEmoctationFacory();
    }

    public static String b(Editable editable) {
        return ((IQzoneTextApi) QRoute.api(IQzoneTextApi.class)).toPlainText(editable);
    }
}
