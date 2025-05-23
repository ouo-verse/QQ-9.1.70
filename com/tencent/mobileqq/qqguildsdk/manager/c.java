package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.mobileqq.qqguildsdk.config.GProSdkTjgConfigParser;
import com.tencent.mobileqq.qqguildsdk.config.GuildPicDomainNameConfigParser;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qqguildsdk.util.h;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static c f268450a;

    /* renamed from: b, reason: collision with root package name */
    private static GuildPicDomainNameConfigParser.Config f268451b;

    /* renamed from: c, reason: collision with root package name */
    private static GProSdkTjgConfigParser.Config f268452c;

    public static c d() {
        if (f268450a == null) {
            synchronized (c.class) {
                if (f268450a == null) {
                    f268450a = new c();
                }
            }
        }
        return f268450a;
    }

    public String a() {
        return b().getCoverDomain();
    }

    public GuildPicDomainNameConfigParser.Config b() {
        if (f268451b == null) {
            f268451b = GuildPicDomainNameConfigParser.INSTANCE.a();
            h.u("GProConfigManager", true, DownloadInfo.spKey_Config, "getGuildPicDomainConfig=" + f268451b);
        }
        return f268451b;
    }

    public String c() {
        return b().getHeadDomain();
    }

    public GProSdkTjgConfigParser.Config e() {
        if (f268452c == null) {
            f268452c = GProSdkTjgConfigParser.INSTANCE.a();
            h.u("GProConfigManager", true, DownloadInfo.spKey_Config, "getTjgConfig=" + f268452c);
        }
        return f268452c;
    }

    public void f(GuildPicDomainNameConfigParser.Config config) {
        if (config == null) {
            return;
        }
        f268451b = config;
        fk.f266041j = config.getHeadDomain();
    }

    public void g(GProSdkTjgConfigParser.Config config) {
        if (config == null) {
            return;
        }
        f268452c = config;
    }
}
