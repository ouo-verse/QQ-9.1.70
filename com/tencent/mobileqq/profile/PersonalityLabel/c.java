package com.tencent.mobileqq.profile.PersonalityLabel;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onDelPersonalityLabelPhoto(boolean z16, String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    public void onGetPersonalityLabel(boolean z16, String str, ProfilePersonalityLabelInfo profilePersonalityLabelInfo, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, profilePersonalityLabelInfo, bArr, Integer.valueOf(i3));
        }
    }

    public void onGetPersonalityLabelPhotos(boolean z16, String str, long j3, PersonalityLabelInfo personalityLabelInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, Long.valueOf(j3), personalityLabelInfo, Integer.valueOf(i3), bArr);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 == 4) {
                    Object[] objArr = (Object[]) obj;
                    if (z16) {
                        onDelPersonalityLabelPhoto(true, (String) objArr[0], ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue());
                        return;
                    } else {
                        if (objArr != null) {
                            onDelPersonalityLabelPhoto(false, (String) objArr[0], ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            Object[] objArr2 = (Object[]) obj;
            if (z16) {
                onGetPersonalityLabelPhotos(true, (String) objArr2[0], ((Long) objArr2[1]).longValue(), (PersonalityLabelInfo) objArr2[2], ((Integer) objArr2[3]).intValue(), (byte[]) objArr2[4]);
                return;
            } else if (objArr2 != null && objArr2.length > 0) {
                onGetPersonalityLabelPhotos(false, (String) objArr2[0], ((Long) objArr2[1]).longValue(), null, 0, null);
                return;
            } else {
                onGetPersonalityLabelPhotos(false, "", -1L, null, 0, null);
                return;
            }
        }
        if (z16) {
            Object[] objArr3 = (Object[]) obj;
            onGetPersonalityLabel(true, (String) objArr3[0], (ProfilePersonalityLabelInfo) objArr3[1], (byte[]) objArr3[2], ((Integer) objArr3[3]).intValue());
        } else {
            onGetPersonalityLabel(false, null, null, null, 0);
        }
    }
}
