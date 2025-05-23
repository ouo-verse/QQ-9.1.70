package com.tencent.mobileqq.troop.troopidentity.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityInteractionTag;

/* loaded from: classes19.dex */
public final class ParcelIdentityInteractionTag implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ParcelIdentityInteractionTag> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public String f300341d;

    /* renamed from: e, reason: collision with root package name */
    public String f300342e;

    /* renamed from: f, reason: collision with root package name */
    public String f300343f;

    /* renamed from: h, reason: collision with root package name */
    public String f300344h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f300345i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f300346m;

    /* loaded from: classes19.dex */
    class a implements Parcelable.Creator<ParcelIdentityInteractionTag> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelIdentityInteractionTag createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ParcelIdentityInteractionTag) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new ParcelIdentityInteractionTag(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelIdentityInteractionTag[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ParcelIdentityInteractionTag[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new ParcelIdentityInteractionTag[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65030);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            CREATOR = new a();
        }
    }

    public ParcelIdentityInteractionTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f300341d = "";
        this.f300342e = "";
        this.f300343f = "";
        this.f300344h = "";
    }

    public static ParcelIdentityInteractionTag a(GroupIdentityInteractionTag groupIdentityInteractionTag) {
        ParcelIdentityInteractionTag parcelIdentityInteractionTag = new ParcelIdentityInteractionTag();
        parcelIdentityInteractionTag.f300341d = groupIdentityInteractionTag.interactionTagId;
        parcelIdentityInteractionTag.f300342e = groupIdentityInteractionTag.name;
        parcelIdentityInteractionTag.f300343f = groupIdentityInteractionTag.icon;
        parcelIdentityInteractionTag.f300344h = groupIdentityInteractionTag.rule;
        parcelIdentityInteractionTag.f300345i = groupIdentityInteractionTag.isObtained;
        parcelIdentityInteractionTag.f300346m = groupIdentityInteractionTag.isSet;
        return parcelIdentityInteractionTag;
    }

    public static GroupIdentityInteractionTag b(ParcelIdentityInteractionTag parcelIdentityInteractionTag) {
        GroupIdentityInteractionTag groupIdentityInteractionTag = new GroupIdentityInteractionTag();
        groupIdentityInteractionTag.interactionTagId = parcelIdentityInteractionTag.f300341d;
        groupIdentityInteractionTag.name = parcelIdentityInteractionTag.f300342e;
        groupIdentityInteractionTag.icon = parcelIdentityInteractionTag.f300343f;
        groupIdentityInteractionTag.rule = parcelIdentityInteractionTag.f300344h;
        groupIdentityInteractionTag.isObtained = parcelIdentityInteractionTag.f300345i;
        groupIdentityInteractionTag.isSet = parcelIdentityInteractionTag.f300346m;
        return groupIdentityInteractionTag;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "ParcelIdentityInteractionTag{interactionTagId=" + this.f300341d + ",name=" + this.f300342e + ",icon=" + this.f300343f + ",rule=" + this.f300344h + ",isObtained=" + this.f300345i + ",isSet=" + this.f300346m + ",}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f300341d);
        parcel.writeString(this.f300342e);
        parcel.writeString(this.f300343f);
        parcel.writeString(this.f300344h);
        parcel.writeByte(this.f300345i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f300346m ? (byte) 1 : (byte) 0);
    }

    ParcelIdentityInteractionTag(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f300341d = "";
        this.f300342e = "";
        this.f300343f = "";
        this.f300344h = "";
        this.f300341d = parcel.readString();
        this.f300342e = parcel.readString();
        this.f300343f = parcel.readString();
        this.f300344h = parcel.readString();
        this.f300345i = parcel.readByte() != 0;
        this.f300346m = parcel.readByte() != 0;
    }
}
