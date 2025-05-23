package NS_MINI_INTERFACE;

import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StAppMode extends MessageMicro<INTERFACE$StAppMode> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField interMode = PBField.initBool(false);
    public final PBBoolField authoritySilent = PBField.initBool(false);
    public final PBBoolField keepOffPullList = PBField.initBool(false);
    public final PBBoolField closeTopRightCapsule = PBField.initBool(false);
    public final PBBoolField openNativeApi = PBField.initBool(false);
    public final PBBoolField hideAppSearch = PBField.initBool(false);
    public final PBBoolField isAppStore = PBField.initBool(false);
    public final PBBoolField isWangKa = PBField.initBool(false);
    public final PBBoolField interLoading = PBField.initBool(false);
    public final PBBoolField closeWebviewBounce = PBField.initBool(false);
    public final PBBoolField isLimitedAccess = PBField.initBool(false);
    public final PBBoolField isPayForFriend = PBField.initBool(false);
    public final PBBoolField useAppInfoWhenNavigate = PBField.initBool(false);
    public final PBBoolField disableAddToMyApp = PBField.initBool(false);
    public final PBBoolField disableAddToMyFavor = PBField.initBool(false);
    public final PBBoolField reloadWithFirstPageChange = PBField.initBool(false);
    public final PBBoolField unlimitedApiRight = PBField.initBool(false);
    public final PBBoolField disableShareToAIO = PBField.initBool(false);
    public final PBBoolField disableShareToQZone = PBField.initBool(false);
    public final PBBoolField disableShareToWeChat = PBField.initBool(false);
    public final PBBoolField disableShareToGuild = PBField.initBool(false);

    static {
        String[] strArr = {"interMode", "authoritySilent", "keepOffPullList", "closeTopRightCapsule", "openNativeApi", "hideAppSearch", "isAppStore", "isWangKa", "interLoading", "closeWebviewBounce", "isLimitedAccess", "isPayForFriend", "useAppInfoWhenNavigate", MiniChatConstants.MINI_APP_DISABLE_ADD_TO_MYAPP, MiniChatConstants.MINI_APP_DISABLE_ADD_TO_MYFAVOR, "reloadWithFirstPageChange", "unlimitedApiRight", "disableShareToAIO", "disableShareToQZone", "disableShareToWeChat", "disableShareToGuild"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168}, strArr, new Object[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool}, INTERFACE$StAppMode.class);
    }
}
