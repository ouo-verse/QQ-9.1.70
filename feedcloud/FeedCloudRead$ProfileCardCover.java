package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$ProfileCardCover extends MessageMicro<FeedCloudRead$ProfileCardCover> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"show_entry", "single_profile_card_infos"}, new Object[]{Boolean.FALSE, null}, FeedCloudRead$ProfileCardCover.class);
    public final PBBoolField show_entry = PBField.initBool(false);
    public final PBRepeatMessageField<FeedCloudRead$SingleProfileCardInfo> single_profile_card_infos = PBField.initRepeatMessage(FeedCloudRead$SingleProfileCardInfo.class);
}
