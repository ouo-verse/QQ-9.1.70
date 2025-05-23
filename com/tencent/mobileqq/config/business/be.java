package com.tencent.mobileqq.config.business;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class be implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private final List<String> f202602d = Arrays.asList(FileReaderHelper.DOC_EXT, "sheet", WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE, FileReaderHelper.PDF_EXT, "form", "smartsheet", "smartcanvas", "flowchart", "mind", "aio", "board");

    /* renamed from: e, reason: collision with root package name */
    private List<String> f202603e = new ArrayList();

    public static be b(String str) {
        be beVar = new be();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("supportOpenDocsByMiniApp")) {
                JSONArray jSONArray = jSONObject.getJSONArray("supportOpenDocsByMiniApp");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    beVar.f202603e.add(jSONArray.getString(i3));
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TencentDocsIsDetailPageBean", 1, "exception = " + e16.toString());
            }
        }
        return beVar;
    }

    public List<String> a() {
        if (this.f202603e.isEmpty()) {
            return this.f202602d;
        }
        return this.f202603e;
    }
}
