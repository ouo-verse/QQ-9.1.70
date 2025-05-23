package com.tencent.tmediacodec.reuse;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes26.dex */
public final class ReusePolicy {
    static IPatchRedirector $redirector_ = null;
    public static final ReusePolicy DEFAULT;
    public static final int DEFAULT_INIT_HEIGHT = 1920;
    public static final int DEFAULT_INIT_WIDTH = 1920;
    public EraseType eraseType;
    public int initHeight;
    public int initWidth;
    public boolean reConfigByRealFormat;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes26.dex */
    public static final class EraseType {
        private static final /* synthetic */ EraseType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final EraseType First;
        public static final EraseType SAME;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61686);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            EraseType eraseType = new EraseType("First", 0);
            First = eraseType;
            EraseType eraseType2 = new EraseType("SAME", 1);
            SAME = eraseType2;
            $VALUES = new EraseType[]{eraseType, eraseType2};
        }

        EraseType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static EraseType valueOf(String str) {
            return (EraseType) Enum.valueOf(EraseType.class, str);
        }

        public static EraseType[] values() {
            return (EraseType[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61708);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            DEFAULT = new ReusePolicy(1920, 1920);
        }
    }

    public ReusePolicy(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.initWidth = i3;
        this.initHeight = i16;
        this.reConfigByRealFormat = true;
        this.eraseType = EraseType.First;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "[initWidth:" + this.initWidth + ", initHeight:" + this.initHeight + ", reConfigByRealFormat:" + this.reConfigByRealFormat + ']';
    }
}
