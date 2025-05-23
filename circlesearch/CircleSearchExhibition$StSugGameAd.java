package circlesearch;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StSugGameAd extends MessageMicro<CircleSearchExhibition$StSugGameAd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ad_buffer"}, new Object[]{ByteStringMicro.EMPTY}, CircleSearchExhibition$StSugGameAd.class);
    public final PBBytesField ad_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
}
