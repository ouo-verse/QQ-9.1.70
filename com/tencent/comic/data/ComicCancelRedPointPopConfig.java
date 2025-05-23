package com.tencent.comic.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ComicCancelRedPointPopConfig implements Serializable, Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<ComicCancelRedPointPopConfig> CREATOR;
    public static final int SWITCH_OFF = 0;
    public static final int SWITCH_ON = 1;
    public int dayCount;
    public int enableLocalCache;
    public int ignoreInteractiveControll;
    public int ignoreRedDot;
    public List<ComicCancelRedPointPopItemData> list;
    public int popSwitch;

    /* loaded from: classes5.dex */
    class a implements Parcelable.Creator<ComicCancelRedPointPopConfig> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ComicCancelRedPointPopConfig createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ComicCancelRedPointPopConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new ComicCancelRedPointPopConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ComicCancelRedPointPopConfig[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ComicCancelRedPointPopConfig[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new ComicCancelRedPointPopConfig[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33796);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public ComicCancelRedPointPopConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.popSwitch = 0;
        this.enableLocalCache = 1;
        this.ignoreRedDot = 0;
        this.dayCount = 1;
        this.ignoreInteractiveControll = 0;
        this.list = new ArrayList();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.popSwitch);
        parcel.writeTypedList(this.list);
        parcel.writeInt(this.enableLocalCache);
    }

    public ComicCancelRedPointPopConfig(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.popSwitch = 0;
        this.enableLocalCache = 1;
        this.ignoreRedDot = 0;
        this.dayCount = 1;
        this.ignoreInteractiveControll = 0;
        this.list = new ArrayList();
        this.popSwitch = parcel.readInt();
        this.list = parcel.createTypedArrayList(ComicCancelRedPointPopItemData.CREATOR);
        this.enableLocalCache = parcel.readInt();
    }
}
