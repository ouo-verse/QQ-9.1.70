package NS_MINI_APP_SEARCH;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SEARCH$StSearchMiniAppRsp extends MessageMicro<SEARCH$StSearchMiniAppRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"extInfo", "items", "hasmore", "highlightWords"}, new Object[]{null, null, Boolean.FALSE, ""}, SEARCH$StSearchMiniAppRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<SEARCH$StAppSearchItem> items = PBField.initRepeatMessage(SEARCH$StAppSearchItem.class);
    public final PBBoolField hasmore = PBField.initBool(false);
    public final PBRepeatField<String> highlightWords = PBField.initRepeat(PBStringField.__repeatHelper__);
}
