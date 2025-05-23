package com.tencent.mobileqq.emoticonview;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.VasExtensionDownloaderConstant;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.regex.Pattern;

/* loaded from: classes12.dex */
public class IPSiteUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "IPSiteUtil";

    public IPSiteUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SpannableString dealIPSiteString(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(" ");
            SpannableString spannableString = new SpannableString(str);
            for (int i3 = 0; i3 < split.length; i3++) {
                String str2 = split[i3];
                if (isNumeric(str2)) {
                    int i16 = 0;
                    for (int i17 = i3 - 1; i17 >= 0; i17--) {
                        i16 = i16 + split[i17].length() + 1;
                    }
                    spannableString.setSpan(new ForegroundColorSpan(-15550475), i16, str2.length() + i16, 33);
                }
            }
            return spannableString;
        }
        return new SpannableString("");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006b A[Catch: Exception -> 0x0080, TryCatch #1 {Exception -> 0x0080, blocks: (B:33:0x0007, B:3:0x0010, B:10:0x006b, B:12:0x0071, B:13:0x0079, B:7:0x0064, B:26:0x0051, B:31:0x002e, B:23:0x0043, B:28:0x0020), top: B:32:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Drawable getIPSiteDrawable(String str, boolean z16, boolean z17, URLDrawable.URLDrawableListener uRLDrawableListener, Drawable drawable) {
        URLDrawable drawable2;
        URLDrawable uRLDrawable = null;
        if (drawable == null) {
            try {
                drawable = new ColorDrawable(-1513240);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getIPSiteDrawable error url = " + str + "error msg = " + e16);
            }
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        if (z16) {
            try {
                drawable2 = URLDrawable.getDrawable(new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.COMIC_IP_SITE_ROUND_IMAGE, str), obtain);
                uRLDrawable = drawable2;
            } catch (Exception e17) {
                QLog.e(TAG, 1, "getIPSiteDrawable error = " + e17);
            }
            if (uRLDrawable != null) {
                if (uRLDrawable.getTag() == null) {
                    uRLDrawable.setTag(0);
                }
                uRLDrawable.setURLDrawableListener(uRLDrawableListener);
                uRLDrawable.setAutoDownload(true);
            }
            return uRLDrawable != null ? drawable : uRLDrawable;
        }
        if (z17) {
            try {
                drawable2 = URLDrawable.getDrawable(new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.COMIC_IPSITE_GAME_IMAGE, str), obtain);
            } catch (Exception e18) {
                QLog.e(TAG, 1, "getIPSiteDrawable error = " + e18);
            }
        } else {
            drawable2 = URLDrawable.getDrawable(str, obtain);
        }
        uRLDrawable = drawable2;
        if (uRLDrawable != null) {
        }
        if (uRLDrawable != null) {
        }
    }

    private static boolean isNumeric(String str) {
        return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
    }

    public static Drawable getIPSiteDrawable(String str, URLDrawable.URLDrawableListener uRLDrawableListener, Drawable drawable) {
        return getIPSiteDrawable(str, false, false, uRLDrawableListener, drawable);
    }
}
