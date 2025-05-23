package com.tencent.paysdk.api;

import NS_COMM.COMM;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.paysdk.vipauth.requestdata.BaseRequestData;
import com.tencent.paysdk.vipauth.responsedata.VideoPreAuthResponse;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\r\u0006J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\u001c\u0010\f\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/paysdk/api/IAuthTask;", "", "Lcom/tencent/paysdk/api/IAuthTask$a;", "iVideoAuth", "", "d", "a", "g", QCircleLpReportDc05507.KEY_CLEAR, "", "", "map", "f", "AuthType", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public interface IAuthTask {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/paysdk/api/IAuthTask$AuthType;", "", "(Ljava/lang/String;I)V", "TYPE_VOD", "TYPE_AUDIO", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class AuthType {
        private static final /* synthetic */ AuthType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final AuthType TYPE_AUDIO;
        public static final AuthType TYPE_VOD;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(COMM.mini_base_userinfo);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            AuthType authType = new AuthType("TYPE_VOD", 0);
            TYPE_VOD = authType;
            AuthType authType2 = new AuthType("TYPE_AUDIO", 1);
            TYPE_AUDIO = authType2;
            $VALUES = new AuthType[]{authType, authType2};
        }

        AuthType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            }
        }

        public static AuthType valueOf(String str) {
            return (AuthType) Enum.valueOf(AuthType.class, str);
        }

        public static AuthType[] values() {
            return (AuthType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H&J\u001e\u0010\b\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H&J\u001e\u0010\t\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/paysdk/api/IAuthTask$a;", "", "Lcom/tencent/paysdk/vipauth/e;", "Lcom/tencent/paysdk/vipauth/requestdata/BaseRequestData;", "Lcom/tencent/paysdk/vipauth/responsedata/VideoPreAuthResponse;", "result", "", "c", "b", "a", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public interface a {
        void a(@Nullable com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> result);

        void b(@Nullable com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> result);

        void c(@Nullable com.tencent.paysdk.vipauth.e<BaseRequestData, VideoPreAuthResponse> result);
    }

    void a();

    void clear();

    void d(@Nullable a iVideoAuth);

    void f(@NotNull Map<String, String> map);

    void g();
}
