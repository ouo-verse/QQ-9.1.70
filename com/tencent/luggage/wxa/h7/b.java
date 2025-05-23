package com.tencent.luggage.wxa.h7;

import com.tencent.luggage.wxa.r4.f;
import com.tencent.luggage.wxa.xd.n;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0005B!\b\u0016\u0012\u0016\u0010\r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/luggage/wxa/h7/b;", "Lcom/tencent/luggage/wxa/a6/a;", "Lorg/json/JSONObject;", DownloadInfo.spKey_Config, "", "a", "d", "V", "Lcom/tencent/luggage/wxa/xd/n;", "f", "Ljava/lang/Class;", "Lcom/tencent/luggage/wxa/r4/f;", "Lcom/tencent/luggage/wxa/r4/d;", "logicImpl", "<init>", "(Ljava/lang/Class;)V", "X", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.a6.a {

    /* renamed from: X, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.h7.b$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            return new b(c.class);
        }

        public final b b() {
            return new b(d.class);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Class<? extends f> logicImpl) {
        super(logicImpl);
        Intrinsics.checkNotNullParameter(logicImpl, "logicImpl");
    }

    @Override // com.tencent.luggage.wxa.r4.d, com.tencent.luggage.wxa.ic.l
    public void V() {
        super.V();
        com.tencent.luggage.wxa.p5.f runtime = getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.luggage.wxa.standalone_open_runtime.runtime.WxaRuntime");
        a(new com.tencent.luggage.wxa.z6.c((com.tencent.luggage.wxa.g7.d) runtime, this));
    }

    @Override // com.tencent.luggage.wxa.a6.a, com.tencent.luggage.wxa.r4.d, com.tencent.luggage.wxa.ic.l, com.tencent.luggage.wxa.xd.j
    public void a(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        super.a(config);
        com.tencent.luggage.wxa.s6.b.f140072a.a(config);
    }

    @Override // com.tencent.luggage.wxa.r4.d
    public void d(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        super.d(config);
        String str = getRuntime().j0().J.f130847h;
        if (str != null) {
            a(config, "thirdPlatformApiPermissionBytes", str);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public n f() {
        return new a(this);
    }
}
