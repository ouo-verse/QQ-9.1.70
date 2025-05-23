package com.tencent.hippykotlin.demo.pages.foundation.module;

import c45.e;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes31.dex */
public abstract class BaseOIDBRequest<Req extends e, Rsp extends e> {
    public abstract Rsp decodeResponse(byte[] bArr);

    public final String getCmd() {
        int checkRadix;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("OidbSvcTrpcTcp.0x");
        int oidbCmd = getOidbCmd();
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(oidbCmd, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        m3.append(num);
        m3.append(util.base64_pad_url);
        m3.append(getOidbServiceType());
        return m3.toString();
    }

    public abstract int getOidbCmd();

    public abstract int getOidbServiceType();

    public abstract Req getRequest();
}
