package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchGroupDiscovery$GuessWantItem extends MessageMicro<UnifySearchGroupDiscovery$GuessWantItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField extension;
    public final PBBytesField reportData;
    public final PBBytesField word;
    public final PBBytesField word_id;

    static {
        String[] strArr = {"word_id", "word", MimeTypeParser.ATTR_EXTENSION, "reportData"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, UnifySearchGroupDiscovery$GuessWantItem.class);
    }

    public UnifySearchGroupDiscovery$GuessWantItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.word_id = PBField.initBytes(byteStringMicro);
        this.word = PBField.initBytes(byteStringMicro);
        this.extension = PBField.initBytes(byteStringMicro);
        this.reportData = PBField.initBytes(byteStringMicro);
    }
}
