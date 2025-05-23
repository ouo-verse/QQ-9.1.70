package com.tencent.mobileqq.qqlive.data.anchor.camera;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes17.dex */
public final class QQLiveAnchorStreamRecordType {
    private static final /* synthetic */ QQLiveAnchorStreamRecordType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final QQLiveAnchorStreamRecordType CAMERA;
    public static final QQLiveAnchorStreamRecordType SCREEN;
    public static final QQLiveAnchorStreamRecordType THIRD_PUSH;
    public static final QQLiveAnchorStreamRecordType THIRD_PUSH_BROADCAST;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56600);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType = new QQLiveAnchorStreamRecordType("CAMERA", 0);
        CAMERA = qQLiveAnchorStreamRecordType;
        QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType2 = new QQLiveAnchorStreamRecordType("SCREEN", 1);
        SCREEN = qQLiveAnchorStreamRecordType2;
        QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType3 = new QQLiveAnchorStreamRecordType("THIRD_PUSH", 2);
        THIRD_PUSH = qQLiveAnchorStreamRecordType3;
        QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType4 = new QQLiveAnchorStreamRecordType("THIRD_PUSH_BROADCAST", 3);
        THIRD_PUSH_BROADCAST = qQLiveAnchorStreamRecordType4;
        $VALUES = new QQLiveAnchorStreamRecordType[]{qQLiveAnchorStreamRecordType, qQLiveAnchorStreamRecordType2, qQLiveAnchorStreamRecordType3, qQLiveAnchorStreamRecordType4};
    }

    QQLiveAnchorStreamRecordType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static QQLiveAnchorStreamRecordType valueOf(String str) {
        return (QQLiveAnchorStreamRecordType) Enum.valueOf(QQLiveAnchorStreamRecordType.class, str);
    }

    public static QQLiveAnchorStreamRecordType[] values() {
        return (QQLiveAnchorStreamRecordType[]) $VALUES.clone();
    }
}
