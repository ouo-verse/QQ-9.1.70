package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar;

import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007\u00a8\u0006\u0004"}, d2 = {"", "isFromStateClick", "", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {
    @JvmOverloads
    public static final void a() {
        c(false, 1, null);
    }

    @JvmOverloads
    public static final void b(boolean z16) {
        ((IGPSService) ch.S0(IGPSService.class, "")).stopPollingForDiscoverState(z16);
    }

    public static /* synthetic */ void c(boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        b(z16);
    }
}
