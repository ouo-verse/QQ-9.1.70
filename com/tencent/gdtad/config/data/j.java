package com.tencent.gdtad.config.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class j implements IConfigData {

    @SerializedName(QAdVrReportParams.ParamValue.DEEPLINK)
    public String deeplink;

    public String toString() {
        return l.a(this, null);
    }
}
