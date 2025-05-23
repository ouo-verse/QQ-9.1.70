package com.tencent.guild.aio.util;

import kotlin.Metadata;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0002\u001a\u00020\u0000*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"", "b", "a", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {
    public static final int a(int i3) {
        return (int) (i3 / MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density);
    }

    public static final int b(int i3) {
        return (int) ((i3 * MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
