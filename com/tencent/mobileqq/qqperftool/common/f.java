package com.tencent.mobileqq.qqperftool.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import java.text.SimpleDateFormat;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f274254a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_CLIP_START);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f274254a = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS");
        }
    }

    public static boolean a(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }
}
