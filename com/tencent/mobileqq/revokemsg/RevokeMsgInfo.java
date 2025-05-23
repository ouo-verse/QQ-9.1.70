package com.tencent.mobileqq.revokemsg;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RevokeMsgInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<RevokeMsgInfo> CREATOR;
    public long C;
    public String D;
    public int E;
    public int F;
    public int G;
    public String H;
    public int I;
    public int J;
    public boolean K;
    public int L;
    public String M;

    /* renamed from: d, reason: collision with root package name */
    public int f281286d;

    /* renamed from: e, reason: collision with root package name */
    public long f281287e;

    /* renamed from: f, reason: collision with root package name */
    public String f281288f;

    /* renamed from: h, reason: collision with root package name */
    public String f281289h;

    /* renamed from: i, reason: collision with root package name */
    public String f281290i;

    /* renamed from: m, reason: collision with root package name */
    public long f281291m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<RevokeMsgInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RevokeMsgInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RevokeMsgInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            RevokeMsgInfo revokeMsgInfo = new RevokeMsgInfo();
            revokeMsgInfo.f281286d = parcel.readInt();
            revokeMsgInfo.f281287e = parcel.readLong();
            revokeMsgInfo.f281288f = parcel.readString();
            revokeMsgInfo.D = parcel.readString();
            revokeMsgInfo.f281291m = parcel.readLong();
            revokeMsgInfo.C = parcel.readLong();
            revokeMsgInfo.H = parcel.readString();
            revokeMsgInfo.I = parcel.readInt();
            revokeMsgInfo.J = parcel.readInt();
            boolean z16 = true;
            if (parcel.readInt() != 1) {
                z16 = false;
            }
            revokeMsgInfo.K = z16;
            revokeMsgInfo.L = parcel.readInt();
            revokeMsgInfo.M = parcel.readString();
            return revokeMsgInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RevokeMsgInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RevokeMsgInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new RevokeMsgInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40066);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public RevokeMsgInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.J = 0;
        this.K = true;
        this.L = 0;
        this.M = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return 0;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return String.format("RevokeMsgInfo[istroop= %d, shmsgseq= %d, frienduin= %s, fromuin= %s msguid= %d, time= %d, senduin= %s, longmsgid= %d, longmsgcount=%d longmsgindex=%d, showGrayTips = %s, grayTipsWordingId = %d, grayTipsWording = %s", Integer.valueOf(this.f281286d), Long.valueOf(this.f281287e), this.f281288f, this.f281289h, Long.valueOf(this.f281291m), Long.valueOf(this.C), this.D, Integer.valueOf(this.E), Integer.valueOf(this.F), Integer.valueOf(this.G), Boolean.valueOf(this.K), Integer.valueOf(this.L), this.M);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        try {
            parcel.writeInt(this.f281286d);
            parcel.writeLong(this.f281287e);
            parcel.writeString(this.f281288f);
            parcel.writeString(this.D);
            parcel.writeLong(this.f281291m);
            parcel.writeLong(this.C);
            parcel.writeString(this.H);
            parcel.writeInt(this.I);
            parcel.writeInt(this.J);
            if (this.K) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            parcel.writeInt(i16);
            parcel.writeInt(this.L);
            parcel.writeString(this.M);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("revokeMsg", 2, "revokeMsgInfo writeToParcel failed");
            }
        }
    }

    public RevokeMsgInfo(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageRecord);
            return;
        }
        this.J = 0;
        this.K = true;
        this.L = 0;
        this.M = "";
        this.f281286d = messageRecord.istroop;
        this.f281288f = messageRecord.frienduin;
        this.f281287e = messageRecord.shmsgseq;
        this.f281291m = messageRecord.msgUid;
        this.C = messageRecord.time;
        this.D = messageRecord.senderuin;
        this.E = messageRecord.longMsgId;
        this.F = messageRecord.longMsgCount;
        this.G = messageRecord.longMsgIndex;
    }
}
