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

/* compiled from: P */
/* loaded from: classes6.dex */
public class EditTakeVideoSource implements EditVideoParams.EditSource {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<EditTakeVideoSource> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final String f204051d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LocalMediaInfo f204052e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final String f204053f;

    /* renamed from: h, reason: collision with root package name */
    public final String f204054h;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<EditTakeVideoSource> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EditTakeVideoSource createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EditTakeVideoSource) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new EditTakeVideoSource(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EditTakeVideoSource[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (EditTakeVideoSource[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new EditTakeVideoSource[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42421);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            CREATOR = new a();
        }
    }

    public EditTakeVideoSource(String str, String str2, LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, localMediaInfo);
            return;
        }
        this.f204051d = str;
        this.f204053f = str2;
        this.f204052e = localMediaInfo;
        this.f204054h = "";
        String checkParam = checkParam();
        if (checkParam != null) {
            throw new IllegalArgumentException(checkParam);
        }
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    public String checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (TextUtils.isEmpty(this.f204051d)) {
            return "sourcePath is empty";
        }
        if (!new File(this.f204051d).exists()) {
            return "Can not find file by sourcePath = " + this.f204051d;
        }
        if (!new File(this.f204053f).exists()) {
            return "Can not find file by audioSourcePath = " + this.f204053f;
        }
        if (this.f204052e == null) {
            return "media info should not be null";
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f204052e.mediaHeight;
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    @NonNull
    public String getSourcePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f204051d;
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f204052e.mediaWidth;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "EditTakeVideoSource: sourcePath=" + this.f204051d + " audioSourcePath=" + this.f204053f + " mediaInfo=" + this.f204052e + " audioBgmSourcePath=" + this.f204054h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f204051d);
        parcel.writeString(this.f204053f);
        parcel.writeParcelable(this.f204052e, 0);
        parcel.writeString(this.f204054h);
    }

    protected EditTakeVideoSource(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel);
            return;
        }
        this.f204051d = parcel.readString();
        this.f204053f = parcel.readString();
        this.f204052e = (LocalMediaInfo) parcel.readParcelable(LocalMediaInfo.class.getClassLoader());
        this.f204054h = parcel.readString();
    }
}
