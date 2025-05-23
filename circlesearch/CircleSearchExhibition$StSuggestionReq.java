package circlesearch;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StSuggestionReq extends MessageMicro<CircleSearchExhibition$StSuggestionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"ext_info", "input_word", "adRequest"}, new Object[]{null, "", ByteStringMicro.EMPTY}, CircleSearchExhibition$StSuggestionReq.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBStringField input_word = PBField.initString("");
    public final PBBytesField adRequest = PBField.initBytes(ByteStringMicro.EMPTY);
}
