package com.tencent.mobileqq.editor.params;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import ss.d;

/* loaded from: classes6.dex */
public class EditVideoParams implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<EditVideoParams> CREATOR;
    public int C;
    public int D;
    public long E;

    /* renamed from: d, reason: collision with root package name */
    public int f204055d;

    /* renamed from: e, reason: collision with root package name */
    public int f204056e;

    /* renamed from: f, reason: collision with root package name */
    public final int f204057f;

    /* renamed from: h, reason: collision with root package name */
    public final Bundle f204058h;

    /* renamed from: i, reason: collision with root package name */
    public EditSource f204059i;

    /* renamed from: m, reason: collision with root package name */
    public int f204060m;

    /* loaded from: classes6.dex */
    public interface EditSource extends Parcelable {
        String checkParam();

        int getHeight();

        @NonNull
        String getSourcePath();

        int getWidth();
    }

    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<EditVideoParams> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EditVideoParams createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EditVideoParams) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new EditVideoParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EditVideoParams[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (EditVideoParams[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new EditVideoParams[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42470);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            CREATOR = new a();
        }
    }

    public EditVideoParams(int i3, int i16, EditSource editSource, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), editSource, bundle);
            return;
        }
        this.f204060m = 0;
        this.C = 0;
        this.D = -1;
        this.E = 0L;
        this.f204055d = i3;
        this.f204057f = i16;
        this.f204059i = editSource;
        this.f204058h = bundle;
    }

    public static boolean u(int i3) {
        if (i3 != 126 && i3 != 127 && i3 != 128 && i3 != 129 && i3 != 130 && i3 != 134) {
            return false;
        }
        return true;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        int i3 = this.f204055d;
        if (i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5 && i3 != 6 && i3 != 11 && i3 != 12 && i3 != 14 && i3 != 15) {
            return "Unknown Business id " + this.f204055d;
        }
        EditSource editSource = this.f204059i;
        if (editSource == null) {
            return "Can not find edit source";
        }
        return editSource.checkParam();
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        Bundle bundle = this.f204058h;
        if (bundle != null && bundle.getBoolean("extra_photo_list_to_edit")) {
            return true;
        }
        return false;
    }

    public boolean c(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        Bundle bundle = this.f204058h;
        if (bundle != null) {
            return bundle.getBoolean(str, z16);
        }
        return z16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return 0;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        int i3 = this.f204055d;
        Bundle bundle = this.f204058h;
        if (bundle != null && i3 == 2) {
            int i16 = bundle.getInt("qq_sub_business_id");
            if (i16 == 0) {
                return 2;
            }
            return i16;
        }
        return i3;
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        Bundle bundle = this.f204058h;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean("enable_hw_encode");
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        Bundle bundle = this.f204058h;
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean("extra_enable_revert", true);
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        Bundle bundle = this.f204058h;
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean("extra_enable_slow", true);
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        Bundle bundle = this.f204058h;
        if (bundle == null) {
            return 99;
        }
        return bundle.getInt("entrance_type", 99);
    }

    public int l(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3)).intValue();
        }
        Bundle bundle = this.f204058h;
        if (bundle != null) {
            return bundle.getInt(str, i3);
        }
        return i3;
    }

    public String m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        Bundle bundle = this.f204058h;
        if (bundle != null) {
            return bundle.getString(str);
        }
        return null;
    }

    public String n(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
        Bundle bundle = this.f204058h;
        if (bundle != null) {
            return bundle.getString(str, str2);
        }
        return str2;
    }

    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        Bundle bundle = this.f204058h;
        if (bundle != null && this.f204055d == 2) {
            return bundle.getInt("qq_sub_business_id");
        }
        return 0;
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        EditSource editSource = this.f204059i;
        if (!(editSource instanceof EditTakePhotoSource) && !(editSource instanceof EditTakeVideoSource)) {
            return false;
        }
        return true;
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        EditSource editSource = this.f204059i;
        if (!(editSource instanceof EditLocalVideoSource) && !(editSource instanceof EditLocalPhotoSource)) {
            return false;
        }
        return true;
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        EditSource editSource = this.f204059i;
        if (!(editSource instanceof EditTakePhotoSource) && !(editSource instanceof EditLocalPhotoSource)) {
            return false;
        }
        return true;
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        EditSource editSource = this.f204059i;
        if (!(editSource instanceof EditLocalVideoSource) && !(editSource instanceof EditTakeVideoSource)) {
            return false;
        }
        return true;
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        Bundle bundle = this.f204058h;
        if (bundle != null && bundle.getBoolean("key_multi_edit_pic")) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return "EditVideoParams{mBusinessId=" + this.f204055d + ", mEnableMasks=" + this.f204057f + ", mEditSource=" + this.f204059i + ", entranceType=" + k() + ", mExtra=" + d.f434421a.a(this.f204058h) + ", entryType=" + this.D + '}';
    }

    public void v(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, j3);
        } else {
            this.E = j3;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f204055d);
        parcel.writeInt(this.f204057f);
        parcel.writeParcelable(this.f204059i, i3);
        parcel.writeBundle(this.f204058h);
        parcel.writeInt(this.f204060m);
        parcel.writeInt(this.C);
        parcel.writeInt(this.f204056e);
        parcel.writeInt(this.D);
        parcel.writeLong(this.E);
    }

    protected EditVideoParams(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) parcel);
            return;
        }
        this.f204060m = 0;
        this.C = 0;
        this.D = -1;
        this.E = 0L;
        this.f204055d = parcel.readInt();
        this.f204057f = parcel.readInt();
        this.f204059i = (EditSource) parcel.readParcelable(EditSource.class.getClassLoader());
        this.f204058h = parcel.readBundle(getClass().getClassLoader());
        this.f204060m = parcel.readInt();
        this.C = parcel.readInt();
        this.f204056e = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readLong();
    }
}
