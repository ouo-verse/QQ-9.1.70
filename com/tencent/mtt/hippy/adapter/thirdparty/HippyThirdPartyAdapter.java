package com.tencent.mtt.hippy.adapter.thirdparty;

import com.tencent.mtt.hippy.dom.node.DomNodeRecord;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public abstract class HippyThirdPartyAdapter {
    public ArrayList<DomNodeRecord> domNodeRecordList = new ArrayList<>();

    public abstract String getAppVersion();

    public abstract JSONObject getExtraData();

    public abstract String getPackageName();

    public abstract String getPageUrl();

    public abstract void onRuntimeDestroy();

    public abstract void onRuntimeInit(long j3);

    public abstract void saveInstanceState(ArrayList<DomNodeRecord> arrayList, Object obj);

    public abstract void setExtraData(JSONObject jSONObject);

    public abstract void setPageUrl(String str);
}
