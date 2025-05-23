package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetExpandAppListRsp extends MessageMicro<INTERFACE$StGetExpandAppListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"extInfo", "expandTitle", "expandItemList", "totalNum", "cacheTime"}, new Object[]{null, "", null, 0, 0}, INTERFACE$StGetExpandAppListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField expandTitle = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE$StExpandItem> expandItemList = PBField.initRepeatMessage(INTERFACE$StExpandItem.class);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBUInt32Field cacheTime = PBField.initUInt32(0);
}
