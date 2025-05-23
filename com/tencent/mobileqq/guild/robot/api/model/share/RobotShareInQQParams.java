package com.tencent.mobileqq.guild.robot.api.model.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes14.dex */
public class RobotShareInQQParams implements Parcelable {
    public static final Parcelable.Creator<RobotShareInQQParams> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private String f232073d;

    /* renamed from: e, reason: collision with root package name */
    private String f232074e;

    /* renamed from: f, reason: collision with root package name */
    private String f232075f;

    /* renamed from: h, reason: collision with root package name */
    private String f232076h;

    /* renamed from: i, reason: collision with root package name */
    private String f232077i;

    /* renamed from: m, reason: collision with root package name */
    private String f232078m;

    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<RobotShareInQQParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RobotShareInQQParams createFromParcel(Parcel parcel) {
            return new RobotShareInQQParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RobotShareInQQParams[] newArray(int i3) {
            return new RobotShareInQQParams[i3];
        }
    }

    public RobotShareInQQParams(String str, String str2, String str3, String str4) {
        this.f232073d = str;
        this.f232074e = str2;
        this.f232075f = str3;
        this.f232076h = str4;
        this.f232077i = "QQ\u673a\u5668\u4eba";
        this.f232078m = "https://tangram-1251316161.file.myqcloud.com/files/20220505/faf0ecb5a61129de2dd672371dfa25ae.png";
    }

    private String l(String str) {
        return "#" + str + "#";
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", l("name"));
            jSONObject2.put("desc", l("desc"));
            jSONObject2.put("avatar", l("avatar"));
            jSONObject2.put("app_id", l("app_id"));
            jSONObject2.put("remarks", l("remarks"));
            jSONObject2.put("remarksLogo", l("remarksLogo"));
            jSONObject.put(IRobotUtilApi.MMKV_SCENE_ID, jSONObject2);
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e("RobotShareInQQParams", 1, "generateMetaTemplate exception=", e16);
            return "";
        }
    }

    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", g());
            jSONObject2.put("desc", f());
            jSONObject2.put("avatar", e());
            jSONObject2.put("app_id", c());
            jSONObject2.put("remarks", j());
            jSONObject2.put("remarksLogo", k());
            jSONObject.put(IRobotUtilApi.MMKV_SCENE_ID, jSONObject2);
        } catch (Exception e16) {
            QLog.e("RobotShareInQQParams", 1, "getMetaString exception=", e16);
        }
        return jSONObject.toString();
    }

    public String c() {
        return this.f232076h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f232075f;
    }

    public String f() {
        return this.f232074e;
    }

    public String g() {
        return this.f232073d;
    }

    public String j() {
        return this.f232077i;
    }

    public String k() {
        return this.f232078m;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f232073d);
        parcel.writeString(this.f232074e);
        parcel.writeString(this.f232075f);
        parcel.writeString(this.f232076h);
        parcel.writeString(this.f232077i);
        parcel.writeString(this.f232078m);
    }

    protected RobotShareInQQParams(Parcel parcel) {
        this.f232073d = parcel.readString();
        this.f232074e = parcel.readString();
        this.f232075f = parcel.readString();
        this.f232076h = parcel.readString();
        this.f232077i = parcel.readString();
        this.f232078m = parcel.readString();
    }
}
