package com.tencent.luggage.wxa.nh;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public String f135829a = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;

    /* renamed from: b, reason: collision with root package name */
    public List f135830b = null;

    public JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f135830b.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(((e) it.next()).b());
        }
        return jSONArray;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mErrorMsg:");
        sb5.append(this.f135829a);
        sb5.append(" mWifiList:");
        List list = this.f135830b;
        if (list != null && list.size() > 0) {
            for (e eVar : this.f135830b) {
                sb5.append(" WiFiItem:");
                sb5.append(eVar);
            }
        } else {
            sb5.append("null:");
        }
        return sb5.toString();
    }
}
