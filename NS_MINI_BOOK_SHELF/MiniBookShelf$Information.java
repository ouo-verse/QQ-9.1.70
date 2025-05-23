package NS_MINI_BOOK_SHELF;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniBookShelf$Information extends MessageMicro<MiniBookShelf$Information> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"contentId", "status", "msg", "existStatus"}, new Object[]{"", 0, "", 0}, MiniBookShelf$Information.class);
    public final PBStringField contentId = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f24952msg = PBField.initString("");
    public final PBEnumField existStatus = PBField.initEnum(0);
}
