package com.tencent.msdk.dns.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f336254a;

    /* renamed from: b, reason: collision with root package name */
    public final int f336255b;

    public f(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        } else {
            if (!TextUtils.isEmpty(str)) {
                if (!a(i3)) {
                    this.f336254a = str;
                    this.f336255b = i3;
                    return;
                }
                throw new IllegalArgumentException(IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY.concat(" is invalid"));
            }
            throw new IllegalArgumentException(WadlProxyConsts.CHANNEL.concat(" can not be empty"));
        }
    }

    public static boolean a(int i3) {
        if (1 != i3 && 2 != i3 && 3 != i3) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f336254a + "Dns(" + this.f336255b + ")";
    }
}
