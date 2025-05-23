package NS_STORE_APP_CLIENT;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes.dex */
public final class MiniAppStore$StGetFirstPageByTypeRsp extends MessageMicro<MiniAppStore$StGetFirstPageByTypeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "vecAppInfo", "vecAppRecommendCard"}, new Object[]{null, null, null}, MiniAppStore$StGetFirstPageByTypeRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StUserAppInfo> vecAppInfo = PBField.initRepeatMessage(INTERFACE$StUserAppInfo.class);
    public final PBRepeatMessageField<MiniAppStore$StAppRecommendCard> vecAppRecommendCard = PBField.initRepeatMessage(MiniAppStore$StAppRecommendCard.class);
}
