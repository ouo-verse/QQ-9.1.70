package com.tencent.mobileqq.editor.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

/* loaded from: classes6.dex */
public class EditTakePhotoSource implements EditVideoParams.EditSource {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<EditTakePhotoSource> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final String f204047d;

    /* renamed from: e, reason: collision with root package name */
    public final int f204048e;

    /* renamed from: f, reason: collision with root package name */
    public final int f204049f;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f204050h;

    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<EditTakePhotoSource> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EditTakePhotoSource createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EditTakePhotoSource) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new EditTakePhotoSource(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EditTakePhotoSource[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (EditTakePhotoSource[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new EditTakePhotoSource[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42380);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            CREATOR = new a();
        }
    }

    public EditTakePhotoSource(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f204047d = str;
        this.f204048e = 0;
        this.f204049f = 0;
        this.f204050h = false;
        String checkParam = checkParam();
        if (checkParam != null) {
            throw new IllegalArgumentException(checkParam);
        }
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    public String checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (TextUtils.isEmpty(this.f204047d)) {
            return "sourcePath is empty";
        }
        if (!new File(this.f204047d).exists() && !this.f204050h) {
            return "Can not find file by sourcePath = " + this.f204047d;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f204049f;
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    @NonNull
    public String getSourcePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f204047d;
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f204048e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f204047d);
        parcel.writeInt(this.f204048e);
        parcel.writeInt(this.f204049f);
        parcel.writeInt(this.f204050h ? 1 : 0);
    }

    public EditTakePhotoSource(@NonNull String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            return;
        }
        this.f204047d = str;
        this.f204048e = 0;
        this.f204049f = 0;
        this.f204050h = z16;
        String checkParam = checkParam();
        if (checkParam != null) {
            throw new IllegalArgumentException(checkParam);
        }
    }

    protected EditTakePhotoSource(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) parcel);
            return;
        }
        this.f204047d = parcel.readString();
        this.f204048e = parcel.readInt();
        this.f204049f = parcel.readInt();
        this.f204050h = parcel.readInt() != 0;
    }
}
