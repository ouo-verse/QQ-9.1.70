package com.tencent.smartparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes25.dex */
public class ParcelableListWrapper implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ParcelableListWrapper> CREATOR;

    /* renamed from: e, reason: collision with root package name */
    private static ParcelableListWrapper[] f368888e;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList f368889d;

    /* loaded from: classes25.dex */
    class a implements Parcelable.Creator<ParcelableListWrapper> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableListWrapper createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ParcelableListWrapper) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            ArrayList<? extends com.tencent.smartparcelable.a> a16 = ParcelableListWrapper.a(parcel, getClass().getClassLoader());
            if (a16 != null) {
                return new ParcelableListWrapper(a16);
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableListWrapper[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ParcelableListWrapper[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41548);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f368888e = new ParcelableListWrapper[5];
            CREATOR = new a();
        }
    }

    ParcelableListWrapper(ArrayList<? extends com.tencent.smartparcelable.a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) arrayList);
        } else {
            this.f368889d = arrayList;
        }
    }

    public static ArrayList<? extends com.tencent.smartparcelable.a> a(Parcel parcel, ClassLoader classLoader) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList<? extends com.tencent.smartparcelable.a> arrayList = new ArrayList<>(readInt);
        b(parcel, arrayList, readInt, classLoader);
        return arrayList;
    }

    private static void b(Parcel parcel, List list, int i3, ClassLoader classLoader) {
        while (i3 > 0) {
            list.add(((ParcelableWrapper) parcel.readValue(classLoader)).j());
            i3--;
        }
    }

    public static void c(Parcel parcel, List<? extends com.tencent.smartparcelable.a> list) {
        if (list == null) {
            parcel.writeInt(-1);
            return;
        }
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            ParcelableWrapper m3 = ParcelableWrapper.m(list.get(i3));
            parcel.writeValue(m3);
            ParcelableWrapper.s(m3);
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
        } else {
            c(parcel, this.f368889d);
        }
    }
}
