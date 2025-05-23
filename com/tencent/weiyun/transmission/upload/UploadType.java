package com.tencent.weiyun.transmission.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class UploadType {
    private static final /* synthetic */ UploadType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final UploadType EXIST_COVER;
    public static final UploadType EXIST_ERROR;
    public static final UploadType EXIST_RENAME;
    public static final UploadType EXIST_RESUME;
    public static final UploadType EXIST_RESUME_COVER;
    public static final UploadType EXIST_RESUME_ERROR;
    public static final UploadType EXIST_RESUME_RENAME;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13450);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        UploadType uploadType = new UploadType("EXIST_ERROR", 0);
        EXIST_ERROR = uploadType;
        UploadType uploadType2 = new UploadType("EXIST_COVER", 1);
        EXIST_COVER = uploadType2;
        UploadType uploadType3 = new UploadType("EXIST_RESUME", 2);
        EXIST_RESUME = uploadType3;
        UploadType uploadType4 = new UploadType("EXIST_RESUME_COVER", 3);
        EXIST_RESUME_COVER = uploadType4;
        UploadType uploadType5 = new UploadType("EXIST_RENAME", 4);
        EXIST_RENAME = uploadType5;
        UploadType uploadType6 = new UploadType("EXIST_RESUME_ERROR", 5);
        EXIST_RESUME_ERROR = uploadType6;
        UploadType uploadType7 = new UploadType("EXIST_RESUME_RENAME", 6);
        EXIST_RESUME_RENAME = uploadType7;
        $VALUES = new UploadType[]{uploadType, uploadType2, uploadType3, uploadType4, uploadType5, uploadType6, uploadType7};
    }

    UploadType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static UploadType valueOf(String str) {
        return (UploadType) Enum.valueOf(UploadType.class, str);
    }

    public static UploadType[] values() {
        return (UploadType[]) $VALUES.clone();
    }
}
