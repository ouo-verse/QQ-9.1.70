package nearby.nearbyLivebarSvr.nearbyLivebarSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetLiveBarStatusResponse extends MessageMicro<GetLiveBarStatusResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"ret_code", "display_livebar", "anchor_info", "need_livebar", "time_threshold"}, new Object[]{0, 0, null, 0, 0}, GetLiveBarStatusResponse.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBInt32Field display_livebar = PBField.initInt32(0);
    public AnchorInfo anchor_info = new AnchorInfo();
    public final PBInt32Field need_livebar = PBField.initInt32(0);
    public final PBUInt32Field time_threshold = PBField.initUInt32(0);
}
