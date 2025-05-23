package com.tencent.mobileqq.intervideo;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class IVPluginInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<IVPluginInfo> CREATOR;
    public int C;
    public Bundle D;
    public String E;
    public int F;
    public String G;
    public String H;
    public int I;
    public String J;
    public String K;
    public String L;

    /* renamed from: d, reason: collision with root package name */
    public String f238101d;

    /* renamed from: e, reason: collision with root package name */
    public String f238102e;

    /* renamed from: f, reason: collision with root package name */
    public String f238103f;

    /* renamed from: h, reason: collision with root package name */
    public long f238104h;

    /* renamed from: i, reason: collision with root package name */
    public String f238105i;

    /* renamed from: m, reason: collision with root package name */
    public String f238106m;

    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<IVPluginInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IVPluginInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IVPluginInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new IVPluginInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IVPluginInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (IVPluginInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new IVPluginInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24304);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public IVPluginInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f238106m = "";
        this.C = 1;
        this.D = null;
        this.F = 0;
    }

    public static Map<String, IVPluginInfo> a() {
        HashMap hashMap = new HashMap();
        IVPluginInfo iVPluginInfo = new IVPluginInfo();
        iVPluginInfo.C = 1;
        iVPluginInfo.f238101d = "Hy";
        iVPluginInfo.f238103f = "com.tencent.huayang";
        iVPluginInfo.f238102e = "1600000419";
        IVPluginInfo iVPluginInfo2 = new IVPluginInfo();
        iVPluginInfo2.C = 2;
        iVPluginInfo2.f238101d = "Od";
        iVPluginInfo2.f238103f = "com.tencent.od";
        iVPluginInfo2.f238102e = "1104763709";
        iVPluginInfo2.f238106m = "54";
        IVPluginInfo iVPluginInfo3 = new IVPluginInfo();
        iVPluginInfo3.C = 2;
        iVPluginInfo3.f238101d = "Od";
        iVPluginInfo3.f238103f = "com.tencent.gvideo";
        iVPluginInfo3.f238102e = "1104763709";
        iVPluginInfo3.f238106m = "1";
        IVPluginInfo iVPluginInfo4 = new IVPluginInfo();
        iVPluginInfo3.C = 2;
        iVPluginInfo3.f238101d = "Od";
        iVPluginInfo3.f238103f = "com.tencent.huiyin";
        iVPluginInfo3.f238102e = "1104763709";
        iVPluginInfo3.f238106m = "100";
        hashMap.put(iVPluginInfo.f238103f, iVPluginInfo);
        hashMap.put(iVPluginInfo2.f238103f, iVPluginInfo2);
        hashMap.put(iVPluginInfo3.f238103f, iVPluginInfo3);
        hashMap.put(iVPluginInfo4.f238103f, iVPluginInfo4);
        return hashMap;
    }

    public static Map<String, IVPluginInfo> b(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                IVPluginInfo iVPluginInfo = new IVPluginInfo();
                iVPluginInfo.C = jSONObject2.optInt("authType");
                iVPluginInfo.f238103f = jSONObject2.optString("packageName");
                iVPluginInfo.f238106m = jSONObject2.optString("fromId");
                iVPluginInfo.f238101d = jSONObject2.optString("pluginid");
                iVPluginInfo.f238102e = jSONObject2.optString(TangramHippyConstants.LOGIN_APP_ID);
                iVPluginInfo.J = jSONObject2.optString("openType");
                iVPluginInfo.K = jSONObject2.optString("extra");
                iVPluginInfo.f238104h = jSONObject2.optInt("roomId");
                iVPluginInfo.L = jSONObject2.optString("sign");
                hashMap.put(str2, iVPluginInfo);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f238101d);
        parcel.writeString(this.f238102e);
        parcel.writeString(this.f238103f);
        parcel.writeLong(this.f238104h);
        parcel.writeString(this.f238105i);
        parcel.writeString(this.f238106m);
        parcel.writeInt(this.C);
        parcel.writeBundle(this.D);
        parcel.writeString(this.E);
        parcel.writeInt(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
    }

    protected IVPluginInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            return;
        }
        this.f238106m = "";
        this.C = 1;
        this.D = null;
        this.F = 0;
        this.f238101d = parcel.readString();
        this.f238102e = parcel.readString();
        this.f238103f = parcel.readString();
        this.f238104h = parcel.readLong();
        this.f238105i = parcel.readString();
        this.f238106m = parcel.readString();
        this.C = parcel.readInt();
        this.D = parcel.readBundle(getClass().getClassLoader());
        this.E = parcel.readString();
        this.F = parcel.readInt();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readInt();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
    }
}
