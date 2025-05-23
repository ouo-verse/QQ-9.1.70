package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class DX7Nf {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static PublicKey f381783a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12281);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            try {
                f381783a = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Z8Pvx.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtZX4OooO48FiYa3fwzU+fhPHO3YsMBP1MiV1Kp+osNDDPtf4EPCjuzI75ea+8Dbq8uQeCXWszSpWUWH1c2F0khl5BOCzDLyd166i4Hnh3jWW3PNu9ETh81aZh9c353U+c2fok/nPcepmGm3jl3GZrcxpN9/2wYcCl+t0TWRz+PuTNn0X8/Uf4inmxUJDWclZhao8oYKZM09rH6LRYZiszAV9HpO3b9OFd0+/BARTqd+qUbfObMh3jGvIQUjsbpIT+ttPlqS4RyiVPUVG1gyYuS+/XNXbB59MkMlorIzj7esvC96F5OY5nKl7hvruFfHvEpbo4OL4jmveAMUgu4cSJQIDAQAB", 0)));
            } catch (Exception unused) {
            }
        }
    }
}
