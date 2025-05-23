package com.tencent.upgrade.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes27.dex */
public interface IBasePkgFile {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes27.dex */
    public static final class DiffType {
        private static final /* synthetic */ DiffType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final DiffType DIFF_FROM_APK_WITHOUT_CHANNEL_INI;
        public static final DiffType DIFF_FROM_ORIGIN;
        public static final DiffType DIFF_FROM_ZIP_DATA;
        private int value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8128);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            DiffType diffType = new DiffType("DIFF_FROM_ORIGIN", 0, 1);
            DIFF_FROM_ORIGIN = diffType;
            DiffType diffType2 = new DiffType("DIFF_FROM_ZIP_DATA", 1, 2);
            DIFF_FROM_ZIP_DATA = diffType2;
            DiffType diffType3 = new DiffType("DIFF_FROM_APK_WITHOUT_CHANNEL_INI", 2, 3);
            DIFF_FROM_APK_WITHOUT_CHANNEL_INI = diffType3;
            $VALUES = new DiffType[]{diffType, diffType2, diffType3};
        }

        DiffType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static DiffType valueOf(String str) {
            return (DiffType) Enum.valueOf(DiffType.class, str);
        }

        public static DiffType[] values() {
            return (DiffType[]) $VALUES.clone();
        }

        public int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    DiffType a();
}
