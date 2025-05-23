package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StGetWatermarkDictRsp extends MessageMicro<CLIENT$StGetWatermarkDictRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "vecWatermarkDict"}, new Object[]{null, null}, CLIENT$StGetWatermarkDictRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CLIENT$StWatermarkDict> vecWatermarkDict = PBField.initRepeatMessage(CLIENT$StWatermarkDict.class);
}
