package oicq.wlogin_sdk.tools;

import android.os.Parcel;
import android.os.Parcelable;
import oicq.wlogin_sdk.tools.InternationMsg;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ErrMsg implements Cloneable, Parcelable {
    public static final Parcelable.Creator<ErrMsg> CREATOR = new Parcelable.Creator<ErrMsg>() { // from class: oicq.wlogin_sdk.tools.ErrMsg.1
        @Override // android.os.Parcelable.Creator
        public ErrMsg createFromParcel(Parcel parcel) {
            return new ErrMsg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ErrMsg[] newArray(int i3) {
            return new ErrMsg[i3];
        }
    };
    private String message;
    private String otherinfo;
    private String title;
    private int type;
    private int version;

    public ErrMsg() {
        this.version = 0;
        this.type = 0;
        this.title = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_0);
        this.message = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_1);
        this.otherinfo = "";
    }

    public Object clone() {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMessage() {
        return this.message;
    }

    public String getOtherinfo() {
        return this.otherinfo;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    public void readFromParcel(Parcel parcel) {
        this.version = parcel.readInt();
        this.type = parcel.readInt();
        this.title = parcel.readString();
        this.message = parcel.readString();
        this.otherinfo = parcel.readString();
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOtherinfo(String str) {
        this.otherinfo = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public void setVersion(int i3) {
        this.version = i3;
    }

    public String toString() {
        Object num;
        Object num2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(");
        int i3 = this.version;
        if (i3 < 0) {
            num = Integer.valueOf(i3);
        } else {
            num = Integer.toString(i3);
        }
        sb5.append(num);
        sb5.append(")(");
        int i16 = this.type;
        if (i16 < 0) {
            num2 = Integer.valueOf(i16);
        } else {
            num2 = Integer.toString(i16);
        }
        sb5.append(num2);
        sb5.append(")[");
        return sb5.toString() + this.title + "]" + this.message + "[" + this.otherinfo + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.version);
        parcel.writeInt(this.type);
        parcel.writeString(this.title);
        parcel.writeString(this.message);
        parcel.writeString(this.otherinfo);
    }

    public ErrMsg(int i3, int i16, String str, String str2, String str3) {
        this.version = i3;
        this.type = i16;
        this.title = str;
        this.message = str2;
        this.otherinfo = str3;
    }

    ErrMsg(Parcel parcel) {
        readFromParcel(parcel);
    }
}
