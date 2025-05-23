package com.tencent.luggage.wxa.fd;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum a {
    ShareToWeWork(0),
    ShareToFriend(1),
    CopyShortLink(2),
    SecFlagForSinglePageMode(3),
    ShowTradeComplaint(4),
    ScreenshotJumpWxaBtn(5),
    PosterJumpWxaBtn(6);


    /* renamed from: a, reason: collision with root package name */
    public int f125626a;

    a(int i3) {
        this.f125626a = i3;
    }

    public static /* synthetic */ int a(a aVar, com.tencent.luggage.wxa.j4.g gVar, int i3, int i16, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getControlByte");
        }
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return aVar.a(gVar, i3);
    }

    public final int a(com.tencent.luggage.wxa.j4.g config, int i3) {
        Intrinsics.checkNotNullParameter(config, "config");
        byte[] bArr = config.f130835k0;
        if (!com.tencent.luggage.wxa.h6.d.b(bArr)) {
            int length = bArr.length - 1;
            int i16 = this.f125626a;
            if (length >= i16) {
                byte b16 = bArr[i16];
                if (b16 >= 0 && b16 < 4) {
                    i3 = b16;
                }
            }
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.ActionSheetControlIndex", "getControlByte for " + name() + " [" + i3 + ']');
        return i3;
    }
}
