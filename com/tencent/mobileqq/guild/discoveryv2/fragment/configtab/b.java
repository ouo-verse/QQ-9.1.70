package com.tencent.mobileqq.guild.discoveryv2.fragment.configtab;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.discoveryv2.adapters.GuildSubTabFragmentAdapter;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.utils.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/fragment/configtab/b;", "", "Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter$SubTabData;", "tabData", "Landroidx/fragment/app/Fragment;", "b", "", "msg", "", "d", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f217432a = new b();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        Logger.f235387a.d().d("ConfigTabFragmentHelper", 1, "[onTbsCoreInitFinish] ");
    }

    @NotNull
    public final Fragment b(@NotNull GuildSubTabFragmentAdapter.SubTabData tabData) {
        Intrinsics.checkNotNullParameter(tabData, "tabData");
        int subType = tabData.getSubType();
        if (subType != 1) {
            if (subType != 2) {
                if (subType != 3) {
                    return new ConfigBannerTabFragment();
                }
                return new ConfigBannerTabFragment();
            }
            if (d("subType H5")) {
                if (!m.e()) {
                    Logger.f235387a.d().d("ConfigTabFragmentHelper", 1, "[TbsAccelerator.initAsync] start");
                    m.h(new m.a() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.configtab.a
                        @Override // com.tencent.mobileqq.webview.swift.utils.m.a
                        public final void a() {
                            b.c();
                        }
                    });
                }
                return new GuildDiscoveryMainProcessWebFragment();
            }
            return new GuildDiscoveryWebFragment();
        }
        return new GuildDiscoveryKuiklyFragment();
    }

    public final boolean d(@NotNull String msg2) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        boolean k3 = ((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).k();
        boolean enableMainFrameWeb = bs.f235483a.h("105455").getGuildMainWebConfBean().getEnableMainFrameWeb();
        if (k3 && enableMainFrameWeb) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (msg2.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            Logger.f235387a.d().d("ConfigTabFragmentHelper", 1, "[shouldUseMainProcessWeb] " + msg2 + ", isWebViewInMainProcEnabled: " + k3 + ", enableMainFrameWeb: " + enableMainFrameWeb + ", debugForceMainWeb: false, finalUseMainWeb: " + z16);
        }
        return z16;
    }
}
