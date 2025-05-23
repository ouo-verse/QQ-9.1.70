package com.tencent.mobileqq.pad;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes16.dex */
public final class LaunchMode implements Parcelable {
    private static final /* synthetic */ LaunchMode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<LaunchMode> CREATOR;
    public static final LaunchMode singleTask;
    public static final LaunchMode singleTop;
    public static final LaunchMode standard;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44392);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        LaunchMode launchMode = new LaunchMode(KuiklyLaunchParams.SPLIT_MODE_LAUNCH_MODE_STANDARD, 0);
        standard = launchMode;
        LaunchMode launchMode2 = new LaunchMode("singleTop", 1);
        singleTop = launchMode2;
        LaunchMode launchMode3 = new LaunchMode("singleTask", 2);
        singleTask = launchMode3;
        $VALUES = new LaunchMode[]{launchMode, launchMode2, launchMode3};
        CREATOR = new Parcelable.Creator<LaunchMode>() { // from class: com.tencent.mobileqq.pad.LaunchMode.a
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchMode createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (LaunchMode) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return LaunchMode.values()[parcel.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchMode[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (LaunchMode[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new LaunchMode[i3];
            }
        };
    }

    LaunchMode(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static LaunchMode valueOf(String str) {
        return (LaunchMode) Enum.valueOf(LaunchMode.class, str);
    }

    public static LaunchMode[] values() {
        return (LaunchMode[]) $VALUES.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
        } else {
            parcel.writeInt(ordinal());
        }
    }
}
