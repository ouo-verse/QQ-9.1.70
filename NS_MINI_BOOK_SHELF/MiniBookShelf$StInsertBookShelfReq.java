package NS_MINI_BOOK_SHELF;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniBookShelf$StInsertBookShelfReq extends MessageMicro<MiniBookShelf$StInsertBookShelfReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"appid", "category", "contentIds"}, new Object[]{"", "", ""}, MiniBookShelf$StInsertBookShelfReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField category = PBField.initString("");
    public final PBRepeatField<String> contentIds = PBField.initRepeat(PBStringField.__repeatHelper__);
}
