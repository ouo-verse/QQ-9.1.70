package com.tencent.ecommerce.biz.register;

import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import kotlin.Metadata;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/register/b;", "", "", "a", "", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f103963a = new b();

    b() {
    }

    public final String a() {
        String string = ECLocalConfig.f100650f.getString("mediaId", "", Boolean.TRUE);
        cg0.a.b("ECommerceRegisterUtil", "[getMediaId] mediaId = " + string);
        return string;
    }

    public final boolean b() {
        boolean z16 = ((Number) com.tencent.ecommerce.base.config.service.b.f100655b.a(654, "use_new_register", 1)).intValue() == 1;
        cg0.a.b("ECommerceRegisterUtil", "getRegisterSwitch switchOn = " + z16 + TokenParser.SP);
        return z16;
    }
}
