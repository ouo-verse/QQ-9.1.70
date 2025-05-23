package com.tencent.mobileqq.guild.robot.api.model.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes14.dex */
public class RobotShareInGuildParams implements Parcelable {
    public static final Parcelable.Creator<RobotShareInGuildParams> CREATOR = new a();
    private String C;
    private String D;
    private String E;

    /* renamed from: d, reason: collision with root package name */
    private String f232067d;

    /* renamed from: e, reason: collision with root package name */
    private String f232068e;

    /* renamed from: f, reason: collision with root package name */
    private String f232069f;

    /* renamed from: h, reason: collision with root package name */
    private String f232070h;

    /* renamed from: i, reason: collision with root package name */
    private String f232071i;

    /* renamed from: m, reason: collision with root package name */
    private String f232072m;

    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<RobotShareInGuildParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RobotShareInGuildParams createFromParcel(Parcel parcel) {
            return new RobotShareInGuildParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RobotShareInGuildParams[] newArray(int i3) {
            return new RobotShareInGuildParams[i3];
        }
    }

    public RobotShareInGuildParams(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f232067d = str;
        this.f232068e = str2;
        this.f232069f = str3;
        this.f232070h = str4;
        this.f232071i = str5;
        this.f232072m = str6;
        this.C = "\u5feb\u6765\u6dfb\u52a0\u673a\u5668\u4eba\u5230\u9891\u9053";
        this.D = "\u53bb\u6dfb\u52a0";
        this.E = "\u673a\u5668\u4eba";
    }

    private String n(String str) {
        return "#" + str + "#";
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("guildId", n("guildId"));
            jSONObject2.put("channelId", n("channelId"));
            jSONObject2.put("id", n("id"));
            jSONObject2.put("uin", n("uin"));
            jSONObject2.put("name", n("name"));
            jSONObject2.put("desc", n("desc"));
            jSONObject2.put("avatar", n("avatar"));
            jSONObject2.put("app_id", n("app_id"));
            jSONObject2.put("addBtnText", n("addBtnText"));
            jSONObject2.put("remarks", n("remarks"));
            jSONObject2.put("tagText", n("tagText"));
            jSONObject.put(IRobotUtilApi.MMKV_SCENE_ID, jSONObject2);
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e("RobotShareInGuildParams", 1, "generateMetaTemplate exception=", e16);
            return "";
        }
    }

    public String b() {
        return this.D;
    }

    public String c() {
        return "com.tencent.guild.robot";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", k());
            jSONObject2.put("desc", j());
            jSONObject2.put("avatar", g());
            jSONObject2.put("app_id", f());
            jSONObject2.put("remarks", l());
            jSONObject2.put("remarksLogo", "https://tangram-1251316161.file.myqcloud.com/files/20220505/faf0ecb5a61129de2dd672371dfa25ae.png");
            jSONObject.put(IRobotUtilApi.MMKV_SCENE_ID, jSONObject2);
        } catch (Exception e16) {
            QLog.e("RobotShareInGuildParams", 1, "getMetaString exception=", e16);
        }
        return jSONObject.toString();
    }

    public String f() {
        return this.f232072m;
    }

    public String g() {
        return this.f232071i;
    }

    public String j() {
        return this.f232070h;
    }

    public String k() {
        return this.f232069f;
    }

    public String l() {
        return this.C;
    }

    public String m() {
        return this.E;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f232067d);
        parcel.writeString(this.f232068e);
        parcel.writeString(this.f232069f);
        parcel.writeString(this.f232070h);
        parcel.writeString(this.f232071i);
        parcel.writeString(this.f232072m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
    }

    protected RobotShareInGuildParams(Parcel parcel) {
        this.f232067d = parcel.readString();
        this.f232068e = parcel.readString();
        this.f232069f = parcel.readString();
        this.f232070h = parcel.readString();
        this.f232071i = parcel.readString();
        this.f232072m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
    }
}
