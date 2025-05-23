package com.tencent.thumbplayer.report.reportv1;

import com.tencent.thumbplayer.report.ITPReportProperties;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public interface ITPReportParams {
    void paramsToJson(JSONObject jSONObject);

    void paramsToProperties(ITPReportProperties iTPReportProperties);

    void reset();
}
