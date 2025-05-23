package com.tencent.mobileqq.redtouch;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RedDisplayInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<RedDisplayInfo> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<RedTypeInfo> f280243d;

    /* renamed from: e, reason: collision with root package name */
    private RedTypeInfo f280244e;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements Parcelable.Creator<RedDisplayInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RedDisplayInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RedDisplayInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            RedDisplayInfo redDisplayInfo = new RedDisplayInfo();
            redDisplayInfo.f280243d = parcel.readArrayList(RedTypeInfo.class.getClassLoader());
            redDisplayInfo.f280244e = (RedTypeInfo) parcel.readSerializable();
            return redDisplayInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RedDisplayInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RedDisplayInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new RedDisplayInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34225);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            CREATOR = new a();
        }
    }

    public RedDisplayInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public RedTypeInfo b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RedTypeInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f280244e;
    }

    public List<RedTypeInfo> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f280243d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    public void e(RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) redTypeInfo);
        } else {
            this.f280244e = redTypeInfo;
        }
    }

    public void f(ArrayList<RedTypeInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) arrayList);
        } else {
            this.f280243d = arrayList;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
        } else {
            parcel.writeList(this.f280243d);
            parcel.writeSerializable(this.f280244e);
        }
    }
}
