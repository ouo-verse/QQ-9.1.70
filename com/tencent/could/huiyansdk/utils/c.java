package com.tencent.could.huiyansdk.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f100300a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f100301b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19836);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f100300a = new String[]{"75a80ad03e79ea3e7e164db5a520a898a0b3aedd49e22b2ace5b2ffaf5a46e2a", "5905b7061045df5ef3700cce66f8979576d7a47ce64a7577f81ccefbbaad2d7f", "a36ec5649072f6bb6ebc8916d8660b05f67bcb39361132be4c6bcc5649000d26", "4b4912df72d6c4bb7f551a0f70f6cc25d73a9acae5fd9b8cf0dd9c28b6d6e605", "c0437f33e9a2f2e896dd50ba92a463f96e8e9ffe1c684932155e5462dee81900", "ce612fcee938e2be29be435af2e4bae1cd2b64f507eda9936bb8517ebb0f6591", "d6faa4c19bdf85efa6032f3b004c171e29a14af7f1922bf27e24b04d815b5da7", "484e2c0cedd588fe8b3766d537f37576cbf2f3346a7106551257315c28f656c9", "44f3a61dd7cf65bedd9663596d6c8f57e98a84290be13f7852549955733c0db7", "66c89855d81b8c0a0c6c8c908c8cbcdafda913b3eb9714ef34f811a8bf2a17e0"};
            f100301b = new String[]{"d8f4c7157f26aa4a52dbfe157e500e3b", "d2c5f524d350ad86b1e2f5e7c37dca66", "e45805b6a2bb9bf4790e307d3f874877", "aa4eb8fa561f75b62ff401804b9b6602", "ad6976bbcb2dbab1adc6f67e3b6208f2", "80deb2e275676d12fe164f1e4d00162a", "4f64447e457fcdd64c1f61ae3e6cd4cf", "f0c743177a7662028c090247abd03f14", "85dc1af6db373fcfb39f0bbf810f563e", "305af612dcadffe807ff6022b94fd8a8"};
        }
    }
}
