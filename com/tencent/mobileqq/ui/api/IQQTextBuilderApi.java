package com.tencent.mobileqq.ui.api;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IQQTextBuilderApi extends QRouteApi {
    String toPlainText(SpannableStringBuilder spannableStringBuilder);
}
