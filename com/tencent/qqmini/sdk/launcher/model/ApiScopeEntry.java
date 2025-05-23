package com.tencent.qqmini.sdk.launcher.model;

import NS_MINI_USERAUTH.MiniUserAuth$StApiNameItem;
import NS_MINI_USERAUTH.MiniUserAuth$StApiScopeEntry;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ApiScopeEntry implements Parcelable, Serializable {
    public static final Parcelable.Creator<ApiScopeEntry> CREATOR = new Parcelable.Creator<ApiScopeEntry>() { // from class: com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApiScopeEntry createFromParcel(Parcel parcel) {
            return new ApiScopeEntry(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApiScopeEntry[] newArray(int i3) {
            return new ApiScopeEntry[i3];
        }
    };
    public String apiName;
    public String eventName;
    public String scope;

    public ApiScopeEntry() {
    }

    public static ApiScopeEntry from(MiniUserAuth$StApiScopeEntry miniUserAuth$StApiScopeEntry) {
        ApiScopeEntry apiScopeEntry = new ApiScopeEntry();
        if (miniUserAuth$StApiScopeEntry == null) {
            return apiScopeEntry;
        }
        MiniUserAuth$StApiNameItem miniUserAuth$StApiNameItem = miniUserAuth$StApiScopeEntry.api.get();
        if (miniUserAuth$StApiNameItem != null) {
            apiScopeEntry.eventName = miniUserAuth$StApiNameItem.eventName.get();
            apiScopeEntry.apiName = miniUserAuth$StApiNameItem.apiName.get();
        }
        apiScopeEntry.scope = miniUserAuth$StApiScopeEntry.scope.get();
        return apiScopeEntry;
    }

    public static ApiScopeEntry fromJson(JSONObject jSONObject) {
        ApiScopeEntry apiScopeEntry = new ApiScopeEntry();
        if (jSONObject != null) {
            apiScopeEntry.eventName = jSONObject.optString(AdMetricTag.EVENT_NAME);
            apiScopeEntry.apiName = jSONObject.optString("apiName");
            apiScopeEntry.scope = jSONObject.optString("scope");
        }
        return apiScopeEntry;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AdMetricTag.EVENT_NAME, this.eventName);
            jSONObject.put("apiName", this.apiName);
            jSONObject.put("scope", this.scope);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "ApiScopeEntry{eventName='" + this.eventName + "', apiName='" + this.apiName + "', scope='" + this.scope + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.eventName);
        parcel.writeString(this.apiName);
        parcel.writeString(this.scope);
    }

    protected ApiScopeEntry(Parcel parcel) {
        this.eventName = parcel.readString();
        this.apiName = parcel.readString();
        this.scope = parcel.readString();
    }
}
