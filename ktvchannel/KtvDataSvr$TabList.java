package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvDataSvr$TabList extends MessageMicro<KtvDataSvr$TabList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tab_list"}, new Object[]{null}, KtvDataSvr$TabList.class);
    public final PBRepeatMessageField<KtvDataSvr$TabItem> tab_list = PBField.initRepeatMessage(KtvDataSvr$TabItem.class);
}
