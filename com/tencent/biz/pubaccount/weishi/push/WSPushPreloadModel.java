package com.tencent.biz.pubaccount.weishi.push;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class WSPushPreloadModel implements Parcelable {
    public static final Parcelable.Creator<WSPushPreloadModel> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public boolean f81335d;

    /* renamed from: e, reason: collision with root package name */
    public long f81336e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f81337f;

    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<WSPushPreloadModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WSPushPreloadModel createFromParcel(Parcel parcel) {
            return new WSPushPreloadModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WSPushPreloadModel[] newArray(int i3) {
            return new WSPushPreloadModel[i3];
        }
    }

    public WSPushPreloadModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByte(this.f81335d ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f81336e);
        parcel.writeByte(this.f81337f ? (byte) 1 : (byte) 0);
    }

    protected WSPushPreloadModel(Parcel parcel) {
        this.f81335d = parcel.readByte() != 0;
        this.f81336e = parcel.readLong();
        this.f81337f = parcel.readByte() != 0;
    }

    public static WSPushPreloadModel a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        WSPushPreloadModel wSPushPreloadModel = new WSPushPreloadModel();
        wSPushPreloadModel.f81335d = jSONObject.optBoolean("is_preload_data");
        wSPushPreloadModel.f81336e = jSONObject.optLong("valid_duration");
        wSPushPreloadModel.f81337f = jSONObject.optBoolean("is_preload_out_valid_duration");
        return wSPushPreloadModel;
    }
}
