package com.tencent.mobileqq.gamecenter.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class PadFaceAd extends Entity implements Parcelable {
    public static final Parcelable.Creator<PadFaceAd> CREATOR = new a();
    public String appName;
    public String appVersion;
    public String appView;
    public String arkMeta;
    public long endTime;

    @unique
    public int padFaceId;
    public int redPointId;
    public long startTime;

    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<PadFaceAd> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PadFaceAd createFromParcel(Parcel parcel) {
            return new PadFaceAd(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PadFaceAd[] newArray(int i3) {
            return new PadFaceAd[i3];
        }
    }

    public PadFaceAd() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.appName) && !TextUtils.isEmpty(this.appView)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "PadFaceAd {padFaceId=" + this.padFaceId + ",redPointId=" + this.redPointId + ",appName=" + this.appName + ",appView=" + this.appView + ",appVersion=" + this.appVersion + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.padFaceId);
        parcel.writeInt(this.redPointId);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeString(this.appName);
        parcel.writeString(this.appView);
        parcel.writeString(this.appVersion);
        parcel.writeString(this.arkMeta);
    }

    public PadFaceAd(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.padFaceId = jSONObject.optInt("id");
            this.startTime = jSONObject.optLong("start_time");
            this.endTime = jSONObject.optLong("end_time");
            this.appName = jSONObject.optString("app_name");
            this.appVersion = jSONObject.optString("app_version");
            this.appView = jSONObject.optString("app_view");
            this.arkMeta = jSONObject.optString("ark_meta");
            this.redPointId = jSONObject.optInt(RedTouchWebviewHandler.PLUGIN_NAMESPACE);
        }
    }

    protected PadFaceAd(Parcel parcel) {
        this.padFaceId = parcel.readInt();
        this.redPointId = parcel.readInt();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.appName = parcel.readString();
        this.appView = parcel.readString();
        this.appVersion = parcel.readString();
        this.arkMeta = parcel.readString();
    }
}
