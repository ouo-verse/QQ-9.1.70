package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CloudStorage$StModifyFriendInteractiveStorageReq extends MessageMicro<CloudStorage$StModifyFriendInteractiveStorageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 64, 72, 82}, new String[]{"ext", "appid", "toUser", "shareId", "opNum", QCircleDaTongConstant.ElementParamValue.OPERATION, "KVDataList", "version", "quiet", "desc"}, new Object[]{null, "", "", "", 0, "", null, 0, 0, null}, CloudStorage$StModifyFriendInteractiveStorageReq.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBStringField toUser = PBField.initString("");
    public final PBStringField shareId = PBField.initString("");
    public final PBInt32Field opNum = PBField.initInt32(0);
    public final PBStringField operation = PBField.initString("");
    public final PBRepeatMessageField<CloudStorage$StKVData> KVDataList = PBField.initRepeatMessage(CloudStorage$StKVData.class);
    public final PBInt32Field version = PBField.initInt32(0);
    public final PBInt32Field quiet = PBField.initInt32(0);
    public CloudStorage$StInteractiveTemplate desc = new CloudStorage$StInteractiveTemplate();
}
