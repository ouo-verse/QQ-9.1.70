package NS_MINI_BOOK_SHELF;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniBookShelf$StQueryBookShelfReq extends MessageMicro<MiniBookShelf$StQueryBookShelfReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"appid", "contentIds"}, new Object[]{"", ""}, MiniBookShelf$StQueryBookShelfReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBRepeatField<String> contentIds = PBField.initRepeat(PBStringField.__repeatHelper__);
}
