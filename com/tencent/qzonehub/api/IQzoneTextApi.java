package com.tencent.qzonehub.api;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneTextApi extends QRouteApi {
    SpannableStringBuilder createQzoneTextBuilder(String str);

    Editable.Factory getEmoctationFacory();

    String toPlainText(Editable editable);

    String toPlainText(Editable editable, boolean z16);
}
