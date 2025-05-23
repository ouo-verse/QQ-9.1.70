package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/xinghuan/mask/i;", "", "Lorg/json/JSONObject;", "maskAdJson", "", "c", "", "b", "", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f87158a = new i();

    i() {
    }

    public final long a() {
        try {
            return MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
        } catch (Throwable th5) {
            QLog.e("QFSPublicAccountXingHuanAdMaskManager", 1, "get uin failed, error is " + th5);
            return 0L;
        }
    }

    @NotNull
    public final String b() {
        String h16 = k.a().h("key_qcircle_public_account_preload_xing_huan_ads" + a(), "");
        Intrinsics.checkNotNullExpressionValue(h16, "g().getString(KEY_QCIRCL\u2026DS + getCurrentUin(), \"\")");
        return h16;
    }

    public final void c(@NotNull JSONObject maskAdJson) {
        Intrinsics.checkNotNullParameter(maskAdJson, "maskAdJson");
        k.a().p("key_qcircle_public_account_preload_xing_huan_ads" + f87158a.a(), maskAdJson.toString());
    }
}
