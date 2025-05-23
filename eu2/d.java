package eu2;

import bu2.TVideoAccountInfo;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvideo.LoginResponse;
import tvideo.RefreshTokenResponse;
import tvideo.TokenInfo;
import tvideo.UserInfo;
import tvideo.VideoToken;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J>\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u001a\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u001a\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000bH\u0002J&\u0010\u0012\u001a\u00020\u000e2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0016\u00a8\u0006\u001a"}, d2 = {"Leu2/d;", "", "Ltvideo/TokenInfo;", "tokenInfo", "Ltvideo/UserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "Ltvideo/VideoToken;", "videoToken", "", "", "extendData", "Lbu2/b;", "d", "account", "", "f", "e", "g", "a", "Ltvideo/LoginResponse;", "response", "b", "Ltvideo/RefreshTokenResponse;", "c", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f397145a = new d();

    d() {
    }

    private final boolean a(Map<String, String> extendData, TVideoAccountInfo account) {
        if (extendData != null && !extendData.keySet().isEmpty()) {
            account.p(String.valueOf(extendData.get("im_token")));
            return true;
        }
        return false;
    }

    private final TVideoAccountInfo d(TokenInfo tokenInfo, UserInfo userInfo, VideoToken videoToken, Map<String, String> extendData) {
        VideoToken videoToken2;
        boolean z16;
        Map<String, String> map;
        boolean z17;
        TVideoAccountInfo tVideoAccountInfo = new TVideoAccountInfo(null, null, null, null, null, null, 0L, 0L, 0L, 0L, null, null, false, false, 16383, null);
        tVideoAccountInfo.u(System.currentTimeMillis());
        boolean e16 = e(tokenInfo, tVideoAccountInfo);
        boolean z18 = false;
        if (!f(userInfo, tVideoAccountInfo) && !e16) {
            videoToken2 = videoToken;
            z16 = false;
        } else {
            videoToken2 = videoToken;
            z16 = true;
        }
        if (!g(videoToken2, tVideoAccountInfo) && !z16) {
            map = extendData;
            z17 = false;
        } else {
            map = extendData;
            z17 = true;
        }
        if (a(map, tVideoAccountInfo) || z17) {
            z18 = true;
        }
        if (z18) {
            return tVideoAccountInfo;
        }
        return null;
    }

    private final boolean e(TokenInfo tokenInfo, TVideoAccountInfo account) {
        if (tokenInfo == null) {
            return false;
        }
        String str = tokenInfo.openid;
        Intrinsics.checkNotNullExpressionValue(str, "tokenInfo.openid");
        account.r(str);
        String str2 = tokenInfo.access_token;
        Intrinsics.checkNotNullExpressionValue(str2, "tokenInfo.access_token");
        account.l(str2);
        String str3 = tokenInfo.refresh_token;
        Intrinsics.checkNotNullExpressionValue(str3, "tokenInfo.refresh_token");
        account.t(str3);
        account.m(tokenInfo.access_token_expire_time * 1000);
        return true;
    }

    private final boolean f(UserInfo userInfo, TVideoAccountInfo account) {
        if (userInfo == null) {
            return false;
        }
        String str = userInfo.face_image_url;
        Intrinsics.checkNotNullExpressionValue(str, "userInfo.face_image_url");
        account.o(str);
        String str2 = userInfo.nick_name;
        Intrinsics.checkNotNullExpressionValue(str2, "userInfo.nick_name");
        account.q(str2);
        return true;
    }

    private final boolean g(VideoToken videoToken, TVideoAccountInfo account) {
        if (videoToken == null) {
            return false;
        }
        account.x(videoToken.video_userid);
        String str = videoToken.video_sessionkey;
        Intrinsics.checkNotNullExpressionValue(str, "videoToken.video_sessionkey");
        account.w(str);
        long j3 = videoToken.expire_time;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (j3 > currentTimeMillis) {
            j3 -= currentTimeMillis;
        }
        account.v(j3 * 1000);
        return true;
    }

    @Nullable
    public final TVideoAccountInfo b(@NotNull LoginResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return d(response.token_info, response.user_info, response.video_token, response.extend_data);
    }

    @Nullable
    public final TVideoAccountInfo c(@NotNull RefreshTokenResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        TVideoAccountInfo d16 = d(response.token_info, response.user_info, response.video_token, response.extend_data);
        if (d16 != null) {
            d16.s(response.is_platform_overdue);
            return d16;
        }
        return null;
    }
}
