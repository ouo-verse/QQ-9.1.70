package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchBusiHotWord$HotWordItem extends MessageMicro<UnifySearchBusiHotWord$HotWordItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField extension;
    public final PBBytesField word;
    public final PBBytesField word_id;

    static {
        String[] strArr = {"word_id", "word", MimeTypeParser.ATTR_EXTENSION};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, UnifySearchBusiHotWord$HotWordItem.class);
    }

    public UnifySearchBusiHotWord$HotWordItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.word_id = PBField.initBytes(byteStringMicro);
        this.word = PBField.initBytes(byteStringMicro);
        this.extension = PBField.initBytes(byteStringMicro);
    }
}
