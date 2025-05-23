package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StSmartMatchMusicReq extends MessageMicro<CLIENT$StSmartMatchMusicReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBBytesField videoBuff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field videoDuration = PBField.initUInt32(0);
    public final PBUInt32Field dataType = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> vecPicBuff = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBDoubleField fLat = PBField.initDouble(0.0d);
    public final PBDoubleField fLon = PBField.initDouble(0.0d);
    public final PBUInt32Field videoType = PBField.initUInt32(0);
    public final PBUInt32Field cameraType = PBField.initUInt32(0);
    public final PBDoubleField videoLat = PBField.initDouble(0.0d);
    public final PBDoubleField videoLon = PBField.initDouble(0.0d);
    public final PBUInt64Field videoTime = PBField.initUInt64(0);

    static {
        String[] strArr = {"extInfo", "videoBuff", "videoDuration", "dataType", "vecPicBuff", "fLat", "fLon", "videoType", ShortVideoConstants.PARAM_KEY_CAMERA_TYPE, "videoLat", "videoLon", QFSEdgeItem.KEY_VIDEO_TIME};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 49, 57, 64, 72, 81, 89, 96}, strArr, new Object[]{null, byteStringMicro, 0, 0, byteStringMicro, valueOf, valueOf, 0, 0, valueOf, valueOf, 0L}, CLIENT$StSmartMatchMusicReq.class);
    }
}
