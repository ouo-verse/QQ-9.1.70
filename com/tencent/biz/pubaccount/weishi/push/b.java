package com.tencent.biz.pubaccount.weishi.push;

import UserGrowth.cnst.sMapExtKeyABTest;
import android.os.Parcel;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {
    public String mAbTest;
    public int mType;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(JSONObject jSONObject) {
        this.mType = jSONObject.optInt("type");
        this.mAbTest = jSONObject.optString(sMapExtKeyABTest.value);
        parseJson(jSONObject);
    }

    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mType);
        parcel.writeString(this.mAbTest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Parcel parcel) {
        this.mType = parcel.readInt();
        this.mAbTest = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseJson(JSONObject jSONObject) {
    }
}
