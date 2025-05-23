package com.tencent.mobileqq.transfile.dns;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class IpData implements Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<IpData> CREATOR;
    private static final int DEFAULT_TAG = 80;
    public static final String IP = "i";
    public static final int IPV4 = 1;
    public static final int IPV6 = 28;
    public static final String PORT = "p";
    private static final String TAG = "NtDns.IpData";
    public static final String TYPE = "t";
    public int mFailedCount;
    public String mIp;
    public int mPort;
    public int mType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44045);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new Parcelable.Creator<IpData>() { // from class: com.tencent.mobileqq.transfile.dns.IpData.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public IpData createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new IpData(parcel) : (IpData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public IpData[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new IpData[i3] : (IpData[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public IpData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static String parse(List<IpData> list) {
        if (list == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (IpData ipData : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", ipData.mIp);
                int i3 = ipData.mPort;
                if (i3 != 80) {
                    jSONObject.put("p", i3);
                }
                int i16 = ipData.mType;
                if (i16 != 1) {
                    jSONObject.put("t", i16);
                }
                jSONArray.mo162put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parse error", e16);
            return null;
        }
    }

    public static ArrayList<IpData> unParse(String str) {
        try {
            ArrayList<IpData> arrayList = new ArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                arrayList.add(new IpData(jSONObject.getString("i"), jSONObject.optInt("p", 80), jSONObject.optInt("t", 1)));
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "unParse error", e16);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.mIp);
        parcel.writeInt(this.mPort);
        parcel.writeInt(this.mFailedCount);
        parcel.writeInt(this.mType);
    }

    public IpData(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mIp = str;
        this.mPort = i3;
        this.mType = i16;
    }

    protected IpData(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.mIp = parcel.readString();
        this.mPort = parcel.readInt();
        this.mFailedCount = parcel.readInt();
        this.mType = parcel.readInt();
    }
}
