package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core;

import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdPositionItem;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class c extends d {

    /* renamed from: o, reason: collision with root package name */
    public String f304044o;

    /* renamed from: p, reason: collision with root package name */
    protected int f304045p;

    /* renamed from: q, reason: collision with root package name */
    protected int f304046q;

    /* renamed from: r, reason: collision with root package name */
    protected String f304047r;

    public c(AdReport adReport, String str, String str2, String str3, String str4, AdOrderItem adOrderItem, String str5) {
        super(adReport, str, str2, str3, str4);
        if (adOrderItem != null) {
            C(adOrderItem);
        }
        this.f304047r = str5;
        B();
    }

    private void C(AdOrderItem adOrderItem) {
        String str;
        if (adOrderItem == null) {
            return;
        }
        AdPositionItem adPositionItem = adOrderItem.positionItem;
        if (adPositionItem != null && (str = adPositionItem.channelId) != null) {
            this.f304044o = str;
        }
        if (adPositionItem != null) {
            this.f304045p = adPositionItem.position;
            this.f304046q = adPositionItem.absPosition;
            this.f304050c = adPositionItem.adSpace;
        }
        this.f304049b = adOrderItem.orderId;
    }

    public Map<String, String> A() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B() {
        Map<String, String> A = A();
        if (!y.i(A)) {
            v(A);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.e(jSONObject);
        this.f304044o = jSONObject.optString("mChannelId", null);
        this.f304045p = jSONObject.optInt("mPos");
        this.f304046q = jSONObject.optInt("mAbsPos");
        this.f304047r = jSONObject.optString("mEncryData", null);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public JSONObject m() {
        JSONObject m3 = super.m();
        try {
            m3.put("mChannelId", this.f304044o);
            m3.put("mPos", this.f304045p);
            m3.put("mAbsPos", this.f304046q);
            m3.put("mEncryData", this.f304047r);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return m3;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public String q() {
        StringBuilder sb5 = new StringBuilder();
        String y16 = y();
        String z16 = z();
        if (z16 != null && z16.length() > 0) {
            sb5.append(z16);
        }
        if (y16 != null && y16.length() > 0) {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            sb5.append(y16);
        }
        return sb5.toString();
    }

    public abstract String y();

    public abstract String z();
}
