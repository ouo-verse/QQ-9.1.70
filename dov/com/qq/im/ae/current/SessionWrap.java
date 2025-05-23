package dov.com.qq.im.ae.current;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SessionWrap implements Parcelable {
    public static final Parcelable.Creator<SessionWrap> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f394447d;

    /* renamed from: e, reason: collision with root package name */
    public String f394448e;

    /* renamed from: f, reason: collision with root package name */
    public int f394449f;

    /* renamed from: h, reason: collision with root package name */
    public String f394450h;

    /* renamed from: i, reason: collision with root package name */
    public int f394451i;

    /* renamed from: m, reason: collision with root package name */
    public String f394452m;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements Parcelable.Creator<SessionWrap> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SessionWrap createFromParcel(Parcel parcel) {
            return new SessionWrap(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SessionWrap[] newArray(int i3) {
            return new SessionWrap[0];
        }
    }

    public SessionWrap() {
        this.f394452m = "";
    }

    public SessionInfo a() {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = this.f394449f;
        sessionInfo.f179563i = this.f394448e;
        sessionInfo.f179557e = this.f394447d;
        sessionInfo.f179559f = this.f394450h;
        sessionInfo.f178172i0 = this.f394452m;
        return sessionInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        String simpleUinForPrint;
        String simpleUinForPrint2;
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("uin");
        sb5.append(":");
        if (QLog.isColorLevel()) {
            simpleUinForPrint = this.f394447d;
        } else {
            simpleUinForPrint = StringUtil.getSimpleUinForPrint(this.f394447d);
        }
        sb5.append(simpleUinForPrint);
        sb5.append(", ");
        sb5.append("uinType");
        sb5.append(":");
        sb5.append(this.f394449f);
        sb5.append(", ");
        sb5.append("troopUin");
        sb5.append(":");
        if (QLog.isColorLevel()) {
            simpleUinForPrint2 = this.f394450h;
        } else {
            simpleUinForPrint2 = StringUtil.getSimpleUinForPrint(this.f394450h);
        }
        sb5.append(simpleUinForPrint2);
        sb5.append(", ");
        sb5.append("chatType");
        sb5.append(":");
        sb5.append(this.f394451i);
        sb5.append(", ");
        sb5.append("peerUid");
        sb5.append(":");
        sb5.append(this.f394452m);
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f394447d);
        parcel.writeString(this.f394448e);
        parcel.writeInt(this.f394449f);
        parcel.writeString(this.f394450h);
        parcel.writeInt(this.f394451i);
        parcel.writeString(this.f394452m);
    }

    public SessionWrap(String str, String str2, int i3, String str3) {
        this.f394452m = "";
        this.f394447d = str;
        this.f394448e = str2;
        this.f394449f = i3;
        this.f394450h = str3;
    }

    public SessionWrap(Parcel parcel) {
        this.f394452m = "";
        this.f394447d = parcel.readString();
        this.f394448e = parcel.readString();
        this.f394449f = parcel.readInt();
        this.f394450h = parcel.readString();
        this.f394451i = parcel.readInt();
        this.f394452m = parcel.readString();
    }
}
