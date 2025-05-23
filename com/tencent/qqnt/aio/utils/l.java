package com.tencent.qqnt.aio.utils;

import kotlin.Metadata;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\"\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\"\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"", "b", "(I)I", "px", "", "a", "(F)F", "aio_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class l {
    public static final float a(float f16) {
        return f16 * MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density;
    }

    public static final int b(int i3) {
        return (int) ((i3 * MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
