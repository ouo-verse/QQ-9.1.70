package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes.dex */
public final class INTERFACE$StBatchGetPluginPkgReq extends MessageMicro<INTERFACE$StBatchGetPluginPkgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "pluginPkgInfos"}, new Object[]{null, null}, INTERFACE$StBatchGetPluginPkgReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StPluginPkgInfo> pluginPkgInfos = PBField.initRepeatMessage(INTERFACE$StPluginPkgInfo.class);
}
