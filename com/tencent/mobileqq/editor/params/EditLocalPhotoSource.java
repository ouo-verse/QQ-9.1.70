package com.tencent.mobileqq.editor.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

/* loaded from: classes6.dex */
public class EditLocalPhotoSource implements EditVideoParams.EditSource {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<EditLocalPhotoSource> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public final String f204041d;

    /* renamed from: e, reason: collision with root package name */
    public final LocalMediaInfo f204042e;

    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<EditLocalPhotoSource> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EditLocalPhotoSource createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EditLocalPhotoSource) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new EditLocalPhotoSource(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EditLocalPhotoSource[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (EditLocalPhotoSource[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new EditLocalPhotoSource[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42350);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            CREATOR = new a();
        }
    }

    public EditLocalPhotoSource(String str, LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) localMediaInfo);
            return;
        }
        this.f204041d = str;
        this.f204042e = localMediaInfo;
        String checkParam = checkParam();
        if (checkParam != null) {
            throw new IllegalArgumentException(checkParam);
        }
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    public String checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (TextUtils.isEmpty(this.f204041d)) {
            return "sourcePath is empty";
        }
        if (!new File(this.f204041d).exists()) {
            return "Can not find file by sourcePath = " + this.f204041d;
        }
        if (this.f204042e == null) {
            return "media info should not be null";
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f204042e.mediaHeight;
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    @NonNull
    public String getSourcePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f204041d;
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f204042e.mediaWidth;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
        } else {
            parcel.writeString(this.f204041d);
            parcel.writeParcelable(this.f204042e, 0);
        }
    }

    protected EditLocalPhotoSource(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
        } else {
            this.f204041d = parcel.readString();
            this.f204042e = (LocalMediaInfo) parcel.readParcelable(LocalMediaInfo.class.getClassLoader());
        }
    }
}
