package com.tencent.biz.qcircleshadow.lib;

import android.text.Editable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneTextApi;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleHostTextBuilder {
    public static Editable.Factory getEmoctationFacory() {
        return ((IQzoneTextApi) QRoute.api(IQzoneTextApi.class)).getEmoctationFacory();
    }

    public static String toPlainText(Editable editable, boolean z16) {
        return ((IQzoneTextApi) QRoute.api(IQzoneTextApi.class)).toPlainText(editable, z16);
    }
}
