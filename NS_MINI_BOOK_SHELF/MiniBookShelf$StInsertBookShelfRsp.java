package NS_MINI_BOOK_SHELF;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniBookShelf$StInsertBookShelfRsp extends MessageMicro<MiniBookShelf$StInsertBookShelfRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"info"}, new Object[]{null}, MiniBookShelf$StInsertBookShelfRsp.class);
    public final PBRepeatMessageField<MiniBookShelf$Information> info = PBField.initRepeatMessage(MiniBookShelf$Information.class);
}
