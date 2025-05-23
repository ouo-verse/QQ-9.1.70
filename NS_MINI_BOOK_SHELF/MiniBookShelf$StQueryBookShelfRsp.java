package NS_MINI_BOOK_SHELF;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniBookShelf$StQueryBookShelfRsp extends MessageMicro<MiniBookShelf$StQueryBookShelfRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bookInfo"}, new Object[]{null}, MiniBookShelf$StQueryBookShelfRsp.class);
    public final PBRepeatMessageField<MiniBookShelf$Information> bookInfo = PBField.initRepeatMessage(MiniBookShelf$Information.class);
}
