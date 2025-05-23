package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CloudStorage$StGetUserCloudStorageRsp extends MessageMicro<CloudStorage$StGetUserCloudStorageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext", "KVDataList"}, new Object[]{null, null}, CloudStorage$StGetUserCloudStorageRsp.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBRepeatMessageField<CloudStorage$StKVData> KVDataList = PBField.initRepeatMessage(CloudStorage$StKVData.class);
}
