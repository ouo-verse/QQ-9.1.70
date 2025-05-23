package com.tencent.biz.pubaccount.weishi.push;

import android.os.Parcel;
import com.tencent.biz.pubaccount.weishi.util.x;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {
    public String mMsgData;
    public String mPushId;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str) {
        this.mMsgData = str;
        try {
            parseJson(new JSONObject(str));
        } catch (JSONException e16) {
            x.d("WSPushMsgActionData parse failed : " + e16.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseJson(JSONObject jSONObject) {
        this.mPushId = jSONObject.optString("pushid");
    }

    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mPushId);
        parcel.writeString(this.mMsgData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Parcel parcel) {
        this.mPushId = parcel.readString();
        this.mMsgData = parcel.readString();
    }
}
