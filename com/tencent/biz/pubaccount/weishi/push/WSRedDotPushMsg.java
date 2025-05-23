package com.tencent.biz.pubaccount.weishi.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class WSRedDotPushMsg extends com.tencent.biz.pubaccount.weishi.push.a implements Parcelable {
    public static final Parcelable.Creator<WSRedDotPushMsg> CREATOR = new a();
    public String mDramaId;
    public String mFeedIds;
    public IWSPushBaseStrategy mStrategyInfo;

    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<WSRedDotPushMsg> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WSRedDotPushMsg createFromParcel(Parcel parcel) {
            return new WSRedDotPushMsg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WSRedDotPushMsg[] newArray(int i3) {
            return new WSRedDotPushMsg[i3];
        }
    }

    WSRedDotPushMsg(String str) {
        super(str);
    }

    public static WSRedDotPushMsg getInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new WSRedDotPushMsg(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.push.a
    protected void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        this.mFeedIds = jSONObject.optString("feedids");
        this.mDramaId = jSONObject.optString("dramaid");
        this.mStrategyInfo = WSPushStrategyInfo.getInstance(jSONObject.optJSONObject("strategy_info"));
    }

    public String toString() {
        return "WSRedDotPushMsg{mStrategyInfo=" + this.mStrategyInfo + ", mPushId='" + this.mPushId + "', mMsgData='" + this.mMsgData + "'}";
    }

    @Override // com.tencent.biz.pubaccount.weishi.push.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.mFeedIds);
        parcel.writeString(this.mDramaId);
        parcel.writeParcelable(this.mStrategyInfo, i3);
    }

    protected WSRedDotPushMsg(Parcel parcel) {
        super(parcel);
        this.mFeedIds = parcel.readString();
        this.mDramaId = parcel.readString();
        this.mStrategyInfo = (IWSPushBaseStrategy) parcel.readParcelable(WSPushStrategyInfo.class.getClassLoader());
    }
}
