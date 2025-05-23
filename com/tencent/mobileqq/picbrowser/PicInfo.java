package com.tencent.mobileqq.picbrowser;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class PicInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<PicInfo> CREATOR;
    public String C;
    public String D;

    /* renamed from: d, reason: collision with root package name */
    public int f258916d;

    /* renamed from: e, reason: collision with root package name */
    public String f258917e;

    /* renamed from: f, reason: collision with root package name */
    public String f258918f;

    /* renamed from: h, reason: collision with root package name */
    public String f258919h;

    /* renamed from: i, reason: collision with root package name */
    public String f258920i;

    /* renamed from: m, reason: collision with root package name */
    public String f258921m;

    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<PicInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PicInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PicInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new PicInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PicInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PicInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new PicInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73596);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new a();
        }
    }

    public PicInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f258916d = -1;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static List<PicInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                PicInfo picInfo = new PicInfo();
                if (jSONObject.has("photoId")) {
                    picInfo.f258916d = jSONObject.getInt("photoId");
                }
                if (jSONObject.has("localPath")) {
                    picInfo.f258919h = jSONObject.getString("localPath");
                }
                if (jSONObject.has("thumbUrl")) {
                    picInfo.f258918f = jSONObject.getString("thumbUrl");
                }
                if (jSONObject.has("bigPicUrl")) {
                    picInfo.f258917e = jSONObject.getString("bigPicUrl");
                }
                if (jSONObject.has(AppConstants.Key.KEY_QZONE_VIDEO_URL)) {
                    picInfo.f258920i = jSONObject.getString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
                }
                if (jSONObject.has("videoLocalPath")) {
                    picInfo.f258921m = jSONObject.getString("videoLocalPath");
                }
                if (jSONObject.has("videoId")) {
                    picInfo.C = jSONObject.getString("videoId");
                }
                arrayList.add(picInfo);
            }
            return arrayList;
        } catch (JSONException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.i(LogTag.NEARBY_PEOPLE_CARD, 4, "picInfo convertFrom exception : " + e16.getMessage());
            }
            return null;
        }
    }

    public JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (JSONObject) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("photoId", this.f258916d);
            if (!TextUtils.isEmpty(this.f258919h)) {
                jSONObject.put("localPath", this.f258919h);
            }
            if (!TextUtils.isEmpty(this.f258918f)) {
                jSONObject.put("thumbUrl", this.f258918f);
            }
            if (!TextUtils.isEmpty(this.f258917e)) {
                jSONObject.put("bigPicUrl", this.f258917e);
            }
            if (!TextUtils.isEmpty(this.f258920i)) {
                jSONObject.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, this.f258920i);
            }
            if (!TextUtils.isEmpty(this.f258921m)) {
                jSONObject.put("videoLocalPath", this.f258921m);
            }
            if (!TextUtils.isEmpty(this.C)) {
                jSONObject.put("videoId", this.C);
            }
            return jSONObject;
        } catch (JSONException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.i(LogTag.NEARBY_PEOPLE_CARD, 4, "picInfo convert2Json exception : " + e16.getMessage());
                return null;
            }
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "photoId:" + this.f258916d + ",localPath:" + this.f258919h + " ,thumbUrl:" + this.f258918f + " ,bigPicUrl:" + this.f258917e + " ,videoUrl:" + this.f258920i + " ,videoLocalPath:" + this.f258921m + " ,videoId:" + this.C + " ,picType:" + this.D;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f258916d);
        parcel.writeString(this.f258917e);
        parcel.writeString(this.f258918f);
        parcel.writeString(this.f258919h);
        parcel.writeString(this.f258920i);
        parcel.writeString(this.f258921m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
    }

    public PicInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f258916d = -1;
        this.f258916d = parcel.readInt();
        this.f258917e = parcel.readString();
        this.f258918f = parcel.readString();
        this.f258919h = parcel.readString();
        this.f258920i = parcel.readString();
        this.f258921m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
    }
}
