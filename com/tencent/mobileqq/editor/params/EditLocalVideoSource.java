package com.tencent.mobileqq.editor.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EditLocalVideoSource implements EditVideoParams.EditSource {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<EditLocalVideoSource> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final String f204043d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LocalMediaInfo f204044e;

    /* renamed from: f, reason: collision with root package name */
    public int f204045f;

    /* renamed from: h, reason: collision with root package name */
    public final int f204046h;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<EditLocalVideoSource> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EditLocalVideoSource createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EditLocalVideoSource) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new EditLocalVideoSource(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EditLocalVideoSource[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (EditLocalVideoSource[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new EditLocalVideoSource[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_QQCIRCLE_SWITCH);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            CREATOR = new a();
        }
    }

    public EditLocalVideoSource(String str, LocalMediaInfo localMediaInfo, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, localMediaInfo, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f204043d = str;
        this.f204044e = localMediaInfo;
        this.f204045f = i3;
        this.f204046h = i16;
        String checkParam = checkParam();
        if (checkParam != null) {
            throw new IllegalArgumentException(checkParam);
        }
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    public String checkParam() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (TextUtils.isEmpty(this.f204043d)) {
            return "sourcePath is empty";
        }
        if (!new File(this.f204043d).exists()) {
            return "Can not find file by sourcePath = " + this.f204043d;
        }
        if (this.f204044e == null) {
            return "media info should not be null";
        }
        int i16 = this.f204045f;
        if (i16 >= 0 && (i3 = this.f204046h) >= 0 && i3 >= i16) {
            return null;
        }
        return "startTime(" + this.f204045f + ") or endTime(" + this.f204046h + ") is illegal";
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
        return this.f204044e.mediaHeight;
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    @NonNull
    public String getSourcePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f204043d;
    }

    @Override // com.tencent.mobileqq.editor.params.EditVideoParams.EditSource
    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f204044e.mediaWidth;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f204043d);
        parcel.writeParcelable(this.f204044e, 0);
        parcel.writeInt(this.f204045f);
        parcel.writeInt(this.f204046h);
    }

    protected EditLocalVideoSource(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            return;
        }
        this.f204043d = parcel.readString();
        this.f204044e = (LocalMediaInfo) parcel.readParcelable(LocalMediaInfo.class.getClassLoader());
        this.f204045f = parcel.readInt();
        this.f204046h = parcel.readInt();
    }
}
