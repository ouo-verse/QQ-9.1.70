package com.tencent.mobileqq.qqlive.business;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.GuildBusinessConfig;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f271158a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f271159b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f271160c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f271161d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f271162e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51973);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        GuildBusinessConfig guildBusinessConfig = GuildBusinessConfig.f271163b;
        f271158a = guildBusinessConfig.a().c();
        f271159b = guildBusinessConfig.a().d();
        f271160c = guildBusinessConfig.a().e();
        f271161d = guildBusinessConfig.a().h();
        f271162e = guildBusinessConfig.a().j();
    }
}
