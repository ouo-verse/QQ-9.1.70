package com.tencent.mobileqq.emoticonview;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExtAniStickerEmoticonInfo extends SystemAndEmojiEmoticonInfo {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<SystemAndEmojiEmoticonInfo> CREATOR;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34776);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            CREATOR = new Parcelable.Creator<SystemAndEmojiEmoticonInfo>() { // from class: com.tencent.mobileqq.emoticonview.ExtAniStickerEmoticonInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SystemAndEmojiEmoticonInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new ExtAniStickerEmoticonInfo(parcel) : (SystemAndEmojiEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SystemAndEmojiEmoticonInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new ExtAniStickerEmoticonInfo[i3] : (SystemAndEmojiEmoticonInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public ExtAniStickerEmoticonInfo(int i3, int i16, int i17, String str, boolean z16) {
        super(i3, i16, i17, str, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, Boolean.valueOf(z16));
    }

    protected ExtAniStickerEmoticonInfo(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
    }
}
