package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvDataSvr$KSongList extends MessageMicro<KtvDataSvr$KSongList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"item_list"}, new Object[]{null}, KtvDataSvr$KSongList.class);
    public final PBRepeatMessageField<KtvCommon$KVItem> item_list = PBField.initRepeatMessage(KtvCommon$KVItem.class);
}
