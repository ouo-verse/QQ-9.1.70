package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$GuessWantItem extends MessageMicro<UnifySearchDiscovery$GuessWantItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField extension;
    public final PBBytesField reportData;
    public final PBUInt32Field type;
    public final PBBytesField word;
    public final PBBytesField word_id;

    static {
        String[] strArr = {"word_id", "word", MimeTypeParser.ATTR_EXTENSION, "reportData", "type"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0}, UnifySearchDiscovery$GuessWantItem.class);
    }

    public UnifySearchDiscovery$GuessWantItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.word_id = PBField.initBytes(byteStringMicro);
        this.word = PBField.initBytes(byteStringMicro);
        this.extension = PBField.initBytes(byteStringMicro);
        this.reportData = PBField.initBytes(byteStringMicro);
        this.type = PBField.initUInt32(0);
    }
}
