package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes17.dex */
public interface PropDownloadIconStatusListener {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes17.dex */
    public static final class IconType {
        private static final /* synthetic */ IconType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final IconType ICON_DOWNLOAD;
        public static final IconType ICON_NULL;
        public static final IconType ICON_PROGRESS;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55126);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            IconType iconType = new IconType("ICON_NULL", 0);
            ICON_NULL = iconType;
            IconType iconType2 = new IconType("ICON_DOWNLOAD", 1);
            ICON_DOWNLOAD = iconType2;
            IconType iconType3 = new IconType("ICON_PROGRESS", 2);
            ICON_PROGRESS = iconType3;
            $VALUES = new IconType[]{iconType, iconType2, iconType3};
        }

        IconType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static IconType valueOf(String str) {
            return (IconType) Enum.valueOf(IconType.class, str);
        }

        public static IconType[] values() {
            return (IconType[]) $VALUES.clone();
        }
    }

    void a(@NonNull com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar, IconType iconType);
}
