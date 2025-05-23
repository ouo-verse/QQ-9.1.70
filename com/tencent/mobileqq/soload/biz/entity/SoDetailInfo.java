package com.tencent.mobileqq.soload.biz.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoDetailInfo implements Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<SoDetailInfo> CREATOR;
    public static final int TEST_FLAG_NOT_EXIST_CHECK_EXIST_IPC = 8;
    public static final int TEST_FLAG_NOT_EXIST_IS_FILE = 1;
    public static final int TEST_FLAG_NOT_EXIST_LOAD_ANYWAY = 4;
    public static final int TEST_FLAG_NOT_EXIST_OPEN = 15;
    public static final int TEST_FLAG_NOT_EXIST_WAIT_AND_CHECK_EXIST = 2;
    public long crc;
    public boolean isFlowControl;
    public String md5;
    public RelatedFileInfo relatedFileInfo;
    public int testFlag;
    public String url;
    public String ver;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<SoDetailInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SoDetailInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SoDetailInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new SoDetailInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SoDetailInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SoDetailInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new SoDetailInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33744);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public SoDetailInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.crc = -1L;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SoDetailInfo create(JSONObject jSONObject, String str, RelatedFileInfo relatedFileInfo, int i3, boolean z16) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("md5");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        SoDetailInfo soDetailInfo = new SoDetailInfo();
        soDetailInfo.md5 = optString2;
        soDetailInfo.url = optString;
        soDetailInfo.ver = str;
        soDetailInfo.crc = jSONObject.optLong("so_crc", -1L);
        soDetailInfo.relatedFileInfo = relatedFileInfo;
        soDetailInfo.testFlag = i3;
        soDetailInfo.isFlowControl = z16;
        return soDetailInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "SDInfo{url='" + this.url + "', md5='" + this.md5 + "', v='" + this.ver + "', c='" + this.crc + ", r='" + this.relatedFileInfo + ",f=" + this.isFlowControl + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.url);
        parcel.writeString(this.md5);
        parcel.writeString(this.ver);
        parcel.writeLong(this.crc);
        parcel.writeParcelable(this.relatedFileInfo, 0);
        parcel.writeInt(this.testFlag);
        parcel.writeByte(this.isFlowControl ? (byte) 1 : (byte) 0);
    }

    protected SoDetailInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.crc = -1L;
        this.url = parcel.readString();
        this.md5 = parcel.readString();
        this.ver = parcel.readString();
        this.crc = parcel.readLong();
        this.relatedFileInfo = (RelatedFileInfo) parcel.readParcelable(RelatedFileInfo.class.getClassLoader());
        this.testFlag = parcel.readInt();
        this.isFlowControl = parcel.readByte() != 0;
    }
}
