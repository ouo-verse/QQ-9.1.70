package com.tencent.mobileqq.guild.discoveryv2.net;

import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsSnapshot;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.eu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/net/c;", "Lcom/tencent/mobileqq/guild/discoveryv2/net/f;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/eu;", "req", "", "d", "c", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProTabContentCommonRsp;", "rsp", "b", "", "Ljava/lang/String;", "backendCookiesKEY", "", "I", "_refreshNum", "_sessionId", "", "[B", "_cookies", "e", "()Ljava/lang/String;", "uin", "key", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String backendCookiesKEY;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int _refreshNum;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String _sessionId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private byte[] _cookies;

    public c(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backendCookiesKEY = key + "_backendCookies_";
        this._sessionId = "";
        this._cookies = new byte[0];
    }

    private final void d(eu req) {
        req.m(this._refreshNum);
        req.n(this._sessionId);
        req.k(this._cookies);
        req.j(TabsSnapshot.f217705a.b().getValue().getBytes(this.backendCookiesKEY + e(), null));
    }

    private final String e() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        if (currentUin == null) {
            return "";
        }
        return currentUin;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.net.f
    public void a(@NotNull eu req) {
        Intrinsics.checkNotNullParameter(req, "req");
        this._refreshNum++;
        d(req);
        req.l(2);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.net.f
    public void b(@NotNull eu req, @NotNull IGProTabContentCommonRsp rsp) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        TabsSnapshot.f217705a.b().getValue().putBytes(this.backendCookiesKEY + e(), rsp.getBackendCookies());
        this._refreshNum = req.e();
        String sessionId = rsp.getSessionId();
        Intrinsics.checkNotNullExpressionValue(sessionId, "rsp.sessionId");
        this._sessionId = sessionId;
        byte[] cookies = rsp.getCookies();
        Intrinsics.checkNotNullExpressionValue(cookies, "rsp.cookies");
        this._cookies = cookies;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.net.f
    public void c(@NotNull eu req) {
        Intrinsics.checkNotNullParameter(req, "req");
        this._refreshNum = 0;
        this._sessionId = "";
        this._cookies = new byte[0];
        d(req);
        req.l(1);
    }
}
