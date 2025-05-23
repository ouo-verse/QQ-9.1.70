package com.tencent.websocket;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WssConfig {
    static IPatchRedirector $redirector_;

    @Keep
    int bz_type;

    @Keep
    int handshake_timeout;

    @Keep
    boolean per_message_deflate;

    @Keep
    int pong_timeout;

    @Keep
    boolean skip_domain_check;

    @Keep
    boolean tcp_no_delay;

    public WssConfig(int i3, int i16, boolean z16, boolean z17, int i17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i17), Boolean.valueOf(z18));
            return;
        }
        this.pong_timeout = i3;
        this.handshake_timeout = i16;
        this.tcp_no_delay = z16;
        this.skip_domain_check = z17;
        this.bz_type = i17;
        this.per_message_deflate = z18;
    }
}
