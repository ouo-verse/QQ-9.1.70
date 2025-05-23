package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tenpay.sdk.util.QWSoterConstans;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchUnite$SearchBusiSortInfo extends MessageMicro<UnifySearchUnite$SearchBusiSortInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{QWSoterConstans.CGI_KEY_BUSI_TYPE}, new Object[]{0}, UnifySearchUnite$SearchBusiSortInfo.class);
    public final PBInt32Field busi_type = PBField.initInt32(0);
}
