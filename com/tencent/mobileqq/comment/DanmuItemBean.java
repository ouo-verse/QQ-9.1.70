package com.tencent.mobileqq.comment;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DanmuItemBean implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<DanmuItemBean> CREATOR;
    public boolean C;
    public String D;
    public int E;

    /* renamed from: d, reason: collision with root package name */
    public long f201729d;

    /* renamed from: e, reason: collision with root package name */
    public long f201730e;

    /* renamed from: f, reason: collision with root package name */
    public long f201731f;

    /* renamed from: h, reason: collision with root package name */
    public String f201732h;

    /* renamed from: i, reason: collision with root package name */
    public String f201733i;

    /* renamed from: m, reason: collision with root package name */
    public long f201734m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Parcelable.Creator<DanmuItemBean> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DanmuItemBean createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DanmuItemBean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            DanmuItemBean danmuItemBean = new DanmuItemBean();
            danmuItemBean.f201729d = parcel.readLong();
            danmuItemBean.f201730e = parcel.readLong();
            danmuItemBean.f201734m = parcel.readLong();
            danmuItemBean.f201731f = parcel.readLong();
            danmuItemBean.f201732h = parcel.readString();
            danmuItemBean.f201733i = parcel.readString();
            boolean z16 = true;
            if (parcel.readInt() != 1) {
                z16 = false;
            }
            danmuItemBean.C = z16;
            danmuItemBean.D = parcel.readString();
            danmuItemBean.E = parcel.readInt();
            return danmuItemBean;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DanmuItemBean[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (DanmuItemBean[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new DanmuItemBean[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23556);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public DanmuItemBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f201732h = "";
        this.f201733i = "";
        this.D = "";
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "DanmuItemBean{commentUin=" + this.f201729d + ", commentSeq=" + this.f201730e + ", createTime=" + this.f201734m + ", location=" + this.f201731f + ", content=" + this.f201732h + ", nickName='" + this.f201733i + ", createTime=" + this.f201734m + ", anonymousFlag=" + this.C + ", anonymousNick=" + this.D + ", anonymousHeadPortrait=" + this.E + '}';
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
            parcel.writeLong(this.f201729d);
            parcel.writeLong(this.f201730e);
            parcel.writeLong(this.f201734m);
            parcel.writeLong(this.f201731f);
            parcel.writeString(this.f201732h);
            parcel.writeString(this.f201733i);
            if (this.C) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            parcel.writeInt(i16);
            parcel.writeString(this.D);
            parcel.writeInt(this.E);
        } catch (Exception e16) {
            QLog.d("DanmuItemBean", 1, "writeToParcel failed, ", e16);
        }
    }

    public DanmuItemBean(long j3, long j16, long j17, long j18, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), str, str2);
            return;
        }
        this.D = "";
        this.f201729d = j3;
        this.f201730e = j16;
        this.f201734m = j17;
        this.f201731f = j18;
        this.f201732h = str;
        this.f201733i = str2;
    }
}
