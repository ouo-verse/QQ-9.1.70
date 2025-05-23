package com.tencent.mobileqq.mediafocus;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MediaFocusStackItem implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<MediaFocusStackItem> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    private int f245789d;

    /* renamed from: e, reason: collision with root package name */
    private long f245790e;

    /* renamed from: f, reason: collision with root package name */
    private String f245791f;

    /* renamed from: h, reason: collision with root package name */
    private String f245792h;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<MediaFocusStackItem> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaFocusStackItem createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MediaFocusStackItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new MediaFocusStackItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaFocusStackItem[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MediaFocusStackItem[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new MediaFocusStackItem[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36653);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            CREATOR = new a();
        }
    }

    public MediaFocusStackItem(int i3, long j3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), str, str2);
            return;
        }
        this.f245789d = i3;
        this.f245790e = j3;
        this.f245791f = str;
        this.f245792h = str2;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f245791f;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f245789d;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f245792h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "MediaFocusStackItem{type='" + this.f245789d + "', time='" + this.f245790e + "', id='" + this.f245791f + "', pname='" + this.f245792h + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f245789d);
        parcel.writeLong(this.f245790e);
        parcel.writeString(this.f245791f);
        parcel.writeString(this.f245792h);
    }

    protected MediaFocusStackItem(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f245789d = parcel.readInt();
        this.f245790e = parcel.readLong();
        this.f245791f = parcel.readString();
        this.f245792h = parcel.readString();
    }
}
