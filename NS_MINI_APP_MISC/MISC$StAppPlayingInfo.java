package NS_MINI_APP_MISC;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;

/* loaded from: classes.dex */
public final class MISC$StAppPlayingInfo extends MessageMicro<MISC$StAppPlayingInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, "myRank", "friendRank", "appMetaInfo"}, new Object[]{0, 0, 0, null}, MISC$StAppPlayingInfo.class);
    public final PBUInt32Field playType = PBField.initUInt32(0);
    public final PBUInt32Field myRank = PBField.initUInt32(0);
    public final PBUInt32Field friendRank = PBField.initUInt32(0);
    public INTERFACE$StApiAppInfo appMetaInfo = new INTERFACE$StApiAppInfo();
}
