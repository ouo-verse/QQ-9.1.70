package NS_STORE_APP_SEARCH;

import NS_COMM.COMM;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppSearch$StGetHotSearchAppsV2Rsp extends MessageMicro<MiniAppSearch$StGetHotSearchAppsV2Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50}, new String[]{"extInfo", "title", "ranks", "defaultRankIndex", "style", WadlProxyConsts.KEY_JUMP_URL}, new Object[]{null, "", null, 0, 0, ""}, MiniAppSearch$StGetHotSearchAppsV2Rsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<MiniAppSearch$RankInfo> ranks = PBField.initRepeatMessage(MiniAppSearch$RankInfo.class);
    public final PBUInt32Field defaultRankIndex = PBField.initUInt32(0);
    public final PBUInt32Field style = PBField.initUInt32(0);
    public final PBStringField jumpUrl = PBField.initString("");
}
