package com.tencent.gamecenter.wadl.biz.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import cooperation.qzone.remote.ServiceConst;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class WadlParamsExt implements Parcelable {
    public static final Parcelable.Creator<WadlParamsExt> CREATOR = new a();
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;

    /* renamed from: d, reason: collision with root package name */
    public long f106733d;

    /* renamed from: e, reason: collision with root package name */
    public String f106734e;

    /* renamed from: f, reason: collision with root package name */
    public String f106735f;

    /* renamed from: h, reason: collision with root package name */
    public String f106736h = "4";

    /* renamed from: i, reason: collision with root package name */
    public String f106737i = "";

    /* renamed from: m, reason: collision with root package name */
    public String f106738m = "";
    public String C = "";

    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<WadlParamsExt> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WadlParamsExt createFromParcel(Parcel parcel) {
            WadlParamsExt wadlParamsExt = new WadlParamsExt();
            wadlParamsExt.c(parcel);
            return wadlParamsExt;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WadlParamsExt[] newArray(int i3) {
            return new WadlParamsExt[i3];
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f106736h = jSONObject.optString("ext2", "4");
        this.f106737i = jSONObject.optString(ServiceConst.PARA_SESSION_ID, "");
        this.f106738m = jSONObject.optString(QAdVrReportParams.ParamKey.EXPERIMENT_ID, "");
        this.C = jSONObject.optString("activity_id", "");
        this.D = jSONObject.optString("displayMode", "");
        this.E = jSONObject.optString("ext16", "");
        this.F = jSONObject.optString("ext17", "");
        this.G = jSONObject.optString("ext18", "");
        this.H = jSONObject.optString(QQLiveReportConstants.AttaColumn.EXT19, "");
        this.I = jSONObject.optString("ext20", "");
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f106733d = jSONObject.optLong("appointment_time", 0L);
        this.f106734e = jSONObject.optString("notificationExpId", "");
        this.f106735f = jSONObject.optString("notificationExpValue", "");
        String optString = jSONObject.optString("attaExtraParams");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(optString);
            this.f106736h = jSONObject2.optString(WadlProxyConsts.SCENE_ID, "4");
            this.f106737i = jSONObject2.optString(ServiceConst.PARA_SESSION_ID, "");
            this.f106738m = jSONObject2.optString(QAdVrReportParams.ParamKey.EXPERIMENT_ID, "");
            this.C = jSONObject2.optString("activity_id", "");
            this.D = jSONObject2.optString("displayMode", "");
            this.E = jSONObject2.optString("extParam1", "");
            this.F = jSONObject2.optString("extParam2", "");
            this.G = jSONObject2.optString("extParam3", "");
            this.H = jSONObject2.optString("extParam4", "");
            this.I = jSONObject2.optString("extParam5", "");
        } catch (JSONException e16) {
            QLog.e("WadlParamsExt", 1, "parseFromJson exception", e16);
        }
    }

    public void c(Parcel parcel) {
        if (parcel != null) {
            this.f106733d = parcel.readLong();
            this.f106734e = parcel.readString();
            this.f106735f = parcel.readString();
            this.f106736h = parcel.readString();
            this.f106737i = parcel.readString();
            this.f106738m = parcel.readString();
            this.C = parcel.readString();
            this.D = parcel.readString();
            this.E = parcel.readString();
            this.F = parcel.readString();
            this.G = parcel.readString();
            this.H = parcel.readString();
            this.I = parcel.readString();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel != null) {
            parcel.writeLong(this.f106733d);
            parcel.writeString(this.f106734e);
            parcel.writeString(this.f106735f);
            parcel.writeString(this.f106736h);
            parcel.writeString(this.f106737i);
            parcel.writeString(this.f106738m);
            parcel.writeString(this.C);
            parcel.writeString(this.D);
            parcel.writeString(this.E);
            parcel.writeString(this.F);
            parcel.writeString(this.G);
            parcel.writeString(this.H);
            parcel.writeString(this.I);
        }
    }
}
