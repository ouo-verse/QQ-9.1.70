package com.tencent.paysdk.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.sqshow.zootopia.avatar.EngineLoadingScene;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/paysdk/api/IUserInfoProvider;", "", "Lcom/tencent/paysdk/api/j;", "getUserInfo", "Lcom/tencent/paysdk/api/IUserInfoProvider$UserType;", "type", "UserType", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public interface IUserInfoProvider {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/paysdk/api/IUserInfoProvider$UserType;", "", "(Ljava/lang/String;I)V", EngineLoadingScene.UNDEFINE, "QQ", "WX", "QQ_SKEY", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class UserType {
        private static final /* synthetic */ UserType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final UserType QQ;
        public static final UserType QQ_SKEY;
        public static final UserType UNDEFINE;
        public static final UserType WX;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10436);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            UserType userType = new UserType(EngineLoadingScene.UNDEFINE, 0);
            UNDEFINE = userType;
            UserType userType2 = new UserType("QQ", 1);
            QQ = userType2;
            UserType userType3 = new UserType("WX", 2);
            WX = userType3;
            UserType userType4 = new UserType("QQ_SKEY", 3);
            QQ_SKEY = userType4;
            $VALUES = new UserType[]{userType, userType2, userType3, userType4};
        }

        UserType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            }
        }

        public static UserType valueOf(String str) {
            return (UserType) Enum.valueOf(UserType.class, str);
        }

        public static UserType[] values() {
            return (UserType[]) $VALUES.clone();
        }
    }

    @NotNull
    j getUserInfo();

    @NotNull
    UserType type();
}
