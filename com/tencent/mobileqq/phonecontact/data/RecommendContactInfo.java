package com.tencent.mobileqq.phonecontact.data;

import SecurityAccountServer.RecommendedContactInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RecommendContactInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<RecommendContactInfo> CREATOR;
    public String C;
    public String D;
    public String E;

    /* renamed from: d, reason: collision with root package name */
    public int f258446d;

    /* renamed from: e, reason: collision with root package name */
    public int f258447e;

    /* renamed from: f, reason: collision with root package name */
    public String f258448f;

    /* renamed from: h, reason: collision with root package name */
    public int f258449h;

    /* renamed from: i, reason: collision with root package name */
    public String f258450i;

    /* renamed from: m, reason: collision with root package name */
    public long f258451m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<RecommendContactInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendContactInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecommendContactInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new RecommendContactInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RecommendContactInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RecommendContactInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new RecommendContactInfo[0];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31960);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            CREATOR = new a();
        }
    }

    public RecommendContactInfo(RecommendedContactInfo recommendedContactInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recommendedContactInfo);
            return;
        }
        this.f258450i = "";
        this.f258451m = 0L;
        this.f258446d = recommendedContactInfo.age;
        this.f258447e = recommendedContactInfo.sex;
        this.f258448f = recommendedContactInfo.personalSign;
        this.f258449h = recommendedContactInfo.eNetworkType;
        this.f258450i = recommendedContactInfo.faceUrl;
        this.f258451m = recommendedContactInfo.faceFlag;
    }

    public JSONObject a() {
        String qqStr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceType.DeviceCategory.MOBILE, this.C);
            jSONObject.put("name", this.D);
            jSONObject.put("age", this.f258446d);
            jSONObject.put("sex", this.f258447e);
            jSONObject.put("signature", this.f258448f);
            if (this.f258449h != 0) {
                qqStr = HardCodeUtil.qqStr(R.string.hpt);
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.hps);
            }
            jSONObject.put(TPReportKeys.Common.COMMON_ONLINE, qqStr);
            jSONObject.put("url", this.E);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "LoginWelcomeContactInfo{age=" + this.f258446d + ", sex=" + this.f258447e + ", personalSign='" + this.f258448f + "', eNetworkType=" + this.f258449h + ", unicode='" + this.C + "', name='" + this.D + "', url='" + this.E + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f258446d);
        parcel.writeInt(this.f258447e);
        parcel.writeString(this.f258448f);
        parcel.writeInt(this.f258449h);
    }

    public RecommendContactInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f258450i = "";
            this.f258451m = 0L;
        }
    }

    public RecommendContactInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel);
            return;
        }
        this.f258450i = "";
        this.f258451m = 0L;
        this.f258446d = parcel.readInt();
        this.f258447e = parcel.readInt();
        this.f258448f = parcel.readString();
        this.f258449h = parcel.readInt();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
    }
}
