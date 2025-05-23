package com.tencent.mobileqq.nearby.interestTag;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class InterestTagInfo extends Entity implements Parcelable {
    public static final Parcelable.Creator<InterestTagInfo> CREATOR = new a();
    public long bid;
    public String tagBgColor;
    public String tagIconUrl;
    public long tagId;
    public String tagJumpUrl;
    public String tagName;
    public String tagTextColor;
    public int tagType = -1;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<InterestTagInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterestTagInfo createFromParcel(Parcel parcel) {
            return new InterestTagInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InterestTagInfo[] newArray(int i3) {
            return new InterestTagInfo[i3];
        }
    }

    public InterestTagInfo() {
    }

    public JSONObject convertTo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tagId", this.tagId);
            if (!TextUtils.isEmpty(this.tagName)) {
                jSONObject.put("tagName", this.tagName);
            }
            if (!TextUtils.isEmpty(this.tagIconUrl)) {
                jSONObject.put("tagIconUrl", this.tagIconUrl);
            }
            if (!TextUtils.isEmpty(this.tagJumpUrl)) {
                jSONObject.put("tagJumpUrl", this.tagJumpUrl);
            }
            if (!TextUtils.isEmpty(this.tagTextColor)) {
                jSONObject.put("tagTextColor", this.tagTextColor);
            }
            if (!TextUtils.isEmpty(this.tagBgColor)) {
                jSONObject.put("tagBgColor", this.tagBgColor);
            }
            jSONObject.put("bid", this.bid);
            return jSONObject;
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("InterestTag", 2, e16.toString());
            }
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass() || ((InterestTagInfo) obj).tagId != this.tagId) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "[ tagName: " + this.tagName + " tagIconUrl: " + this.tagIconUrl + " tagId: " + this.tagId + " tagBgColor: " + this.tagBgColor + " tagTextColor: " + this.tagTextColor + " iconJumpUrl: " + this.tagJumpUrl + " bid: " + this.bid + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.tagId);
        parcel.writeString(this.tagName);
        parcel.writeString(this.tagIconUrl);
        parcel.writeString(this.tagJumpUrl);
        parcel.writeString(this.tagTextColor);
        parcel.writeString(this.tagBgColor);
        parcel.writeLong(this.bid);
    }

    public InterestTagInfo(Parcel parcel) {
        this.tagId = parcel.readLong();
        this.tagName = parcel.readString();
        this.tagIconUrl = parcel.readString();
        this.tagJumpUrl = parcel.readString();
        this.tagTextColor = parcel.readString();
        this.tagBgColor = parcel.readString();
        this.bid = parcel.readLong();
    }
}
