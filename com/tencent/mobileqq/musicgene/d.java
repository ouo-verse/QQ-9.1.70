package com.tencent.mobileqq.musicgene;

import android.text.TextUtils;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f251951a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73237);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f251951a = "";
        }
    }

    public static String a() {
        if (TextUtils.isEmpty(f251951a)) {
            try {
                f251951a = QQPlayerService.Y(6, "MusicPendantUtil");
            } catch (Exception e16) {
                QLog.e("MusicPendantUtil", 1, "MusicPendantManager() exception", e16);
            }
        }
        return f251951a;
    }
}
