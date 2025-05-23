package QC;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AioBubbleRecom$SetRecommendItemReq extends MessageMicro<AioBubbleRecom$SetRecommendItemReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"loginInfo", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME}, new Object[]{null, null}, AioBubbleRecom$SetRecommendItemReq.class);
    public AioBubbleRecom$LoginInfo loginInfo = new AioBubbleRecom$LoginInfo();
    public final PBRepeatMessageField<AioBubbleRecom$ItemInfo> item = PBField.initRepeatMessage(AioBubbleRecom$ItemInfo.class);
}
