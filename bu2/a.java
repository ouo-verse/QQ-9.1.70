package bu2;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0014\u0010 \u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010!\u001a\u00020\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010#\u00a8\u0006$"}, d2 = {"Lbu2/a;", "", "", "isExpired", "()Z", "", "getNickName", "()Ljava/lang/String;", "nickName", "g", "headImageUrl", h.F, "videoSessionKey", "getOpenId", "openId", "a", CommonConstant.KEY_ACCESS_TOKEN, "f", "refreshToken", "", "j", "()J", "accessTokenExpireTime", "c", "videoUserId", "i", "videoExpireTime", "e", "videoCreateTime", "d", "imToken", "b", "isPlatformOverdue", "isVip", "setVip", "(Z)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a {
    @NotNull
    String a();

    boolean b();

    long c();

    @NotNull
    String d();

    long e();

    @NotNull
    String f();

    @NotNull
    String g();

    @NotNull
    String getNickName();

    @NotNull
    String getOpenId();

    @NotNull
    String h();

    long i();

    boolean isExpired();

    boolean isVip();

    long j();
}
