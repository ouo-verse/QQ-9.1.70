package NS_QQ_STORY_CONFIG;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONFIG$StGetStoryConfigRsp extends MessageMicro<CONFIG$StGetStoryConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "intConf"}, new Object[]{null, null}, CONFIG$StGetStoryConfigRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CONFIG$StIntConf> intConf = PBField.initRepeatMessage(CONFIG$StIntConf.class);
}
