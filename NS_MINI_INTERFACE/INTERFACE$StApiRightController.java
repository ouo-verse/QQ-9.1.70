package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StApiRightController extends MessageMicro<INTERFACE$StApiRightController> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"whiteLst", "blackLst", "secondApiRights"}, new Object[]{"", "", null}, INTERFACE$StApiRightController.class);
    public final PBRepeatField<String> blackLst;
    public final PBRepeatMessageField<INTERFACE$StApiRightItem> secondApiRights;
    public final PBRepeatField<String> whiteLst;

    public INTERFACE$StApiRightController() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.whiteLst = PBField.initRepeat(pBStringField);
        this.blackLst = PBField.initRepeat(pBStringField);
        this.secondApiRights = PBField.initRepeatMessage(INTERFACE$StApiRightItem.class);
    }
}
