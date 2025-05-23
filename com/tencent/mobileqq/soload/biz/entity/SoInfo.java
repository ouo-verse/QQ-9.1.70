package com.tencent.mobileqq.soload.biz.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.util.e;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<SoInfo> CREATOR;
    public SoDetailInfo arm32Info;
    public SoDetailInfo arm64Info;
    public String name;
    public String ver;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class CompareModel {
        static IPatchRedirector $redirector_;
        public int diff;
        public int index;

        CompareModel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<SoInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SoInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SoInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new SoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SoInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SoInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new SoInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33757);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new a();
        }
    }

    public SoInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private static int compareVersion(String str, String str2) {
        try {
            if (TextUtils.equals(str, str2)) {
                return 0;
            }
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            CompareModel index = getIndex(split, split2);
            int i3 = index.diff;
            if (i3 == 0) {
                return compareVersionInner(index, split, split2);
            }
            if (i3 > 0) {
                return 1;
            }
            return -1;
        } catch (Throwable unused) {
            return 1;
        }
    }

    private static int compareVersionInner(CompareModel compareModel, String[] strArr, String[] strArr2) {
        for (int i3 = compareModel.index; i3 < strArr.length; i3++) {
            if (safeParseInt(strArr[i3]) > 0) {
                return 1;
            }
        }
        for (int i16 = compareModel.index; i16 < strArr2.length; i16++) {
            if (safeParseInt(strArr2[i16]) > 0) {
                return -1;
            }
        }
        return 0;
    }

    public static SoInfo create(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("ver", AEResManagerConfigBean.DEFAULT_VERSION);
        RelatedFileInfo create = RelatedFileInfo.create(jSONObject.optJSONObject("relatedFile"));
        int optInt = jSONObject.optInt("testFlag");
        boolean z16 = true;
        if (jSONObject.optInt("flowControl") != 1) {
            z16 = false;
        }
        SoDetailInfo create2 = SoDetailInfo.create(jSONObject.optJSONObject(ResourceAttributes.HostArchValues.ARM32), optString2, create, optInt, z16);
        SoDetailInfo create3 = SoDetailInfo.create(jSONObject.optJSONObject(ResourceAttributes.HostArchValues.ARM64), optString2, create, optInt, z16);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        if (create2 == null && create3 == null) {
            return null;
        }
        SoInfo soInfo = new SoInfo();
        soInfo.name = optString;
        soInfo.ver = optString2;
        soInfo.arm32Info = create2;
        soInfo.arm64Info = create3;
        return soInfo;
    }

    private static CompareModel getIndex(String[] strArr, String[] strArr2) {
        CompareModel compareModel = new CompareModel();
        int min = Math.min(strArr.length, strArr2.length);
        while (true) {
            int i3 = compareModel.index;
            if (i3 >= min) {
                break;
            }
            int safeParseInt = safeParseInt(strArr[i3]) - safeParseInt(strArr2[compareModel.index]);
            compareModel.diff = safeParseInt;
            if (safeParseInt != 0) {
                break;
            }
            compareModel.index++;
        }
        return compareModel;
    }

    public static int getReportCode(SoInfo soInfo) {
        if (soInfo == null) {
            return 1;
        }
        if (e.d()) {
            if (soInfo.arm64Info == null) {
                return 1;
            }
            return 0;
        }
        if (soInfo.arm32Info == null) {
            return 1;
        }
        return 0;
    }

    private SoInfo mergeWhenVersionEqual(SoInfo soInfo) {
        SoDetailInfo soDetailInfo;
        SoDetailInfo soDetailInfo2 = this.arm32Info;
        if (soDetailInfo2 != null && this.arm64Info != null) {
            return this;
        }
        SoDetailInfo soDetailInfo3 = soInfo.arm32Info;
        if (soDetailInfo3 != null && soInfo.arm64Info != null) {
            return soInfo;
        }
        if (soDetailInfo2 == null && soDetailInfo3 != null) {
            this.arm32Info = soDetailInfo3;
        }
        if (this.arm64Info == null && (soDetailInfo = soInfo.arm64Info) != null) {
            this.arm64Info = soDetailInfo;
        }
        return this;
    }

    private static int safeParseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return 0;
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

    public SoInfo merge(SoInfo soInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SoInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) soInfo);
        }
        if (soInfo == null) {
            return this;
        }
        int compareVersion = compareVersion(this.ver, soInfo.ver);
        if (compareVersion > 0) {
            return this;
        }
        if (compareVersion < 0) {
            return soInfo;
        }
        return mergeWhenVersionEqual(soInfo);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "SoInfo{name='" + this.name + "', arm32Info=" + this.arm32Info + ", arm64Info=" + this.arm64Info + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.name);
        parcel.writeString(this.ver);
        parcel.writeParcelable(this.arm32Info, 0);
        parcel.writeParcelable(this.arm64Info, 0);
    }

    protected SoInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.name = parcel.readString();
        this.ver = parcel.readString();
        this.arm32Info = (SoDetailInfo) parcel.readParcelable(SoDetailInfo.class.getClassLoader());
        this.arm64Info = (SoDetailInfo) parcel.readParcelable(SoDetailInfo.class.getClassLoader());
    }
}
