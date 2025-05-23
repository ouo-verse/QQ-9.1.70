package NS_MINI_BOOK_SHELF;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniBookShelf$StUpdateBookShelfReadTimeReq extends MessageMicro<MiniBookShelf$StUpdateBookShelfReadTimeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"appid", "category", "contentId"}, new Object[]{"", "", ""}, MiniBookShelf$StUpdateBookShelfReadTimeReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField category = PBField.initString("");
    public final PBStringField contentId = PBField.initString("");
}
