package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import unify.search.UnifySearchCommon$ResultItemGroup;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifyTabSearch$RspBody extends MessageMicro<UnifyTabSearch$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie;
    public final PBUInt32Field dont_need_merge;
    public final PBUInt32Field exhibition_flags;
    public final PBBytesField extension;
    public final PBRepeatMessageField<UnifyTabSearch$SubHotWord> hot_words;
    public final PBUInt32Field key_word_prop;
    public final PBRepeatField<ByteStringMicro> origin_rpt_highlight_words;
    public final PBRepeatMessageField<UnifyTabSearch$ProcessData> process_datas;
    public final PBBytesField search_ver;
    public final PBBytesField sub_hot_top_wording;
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBStringField error_msg = PBField.initString("");
    public final PBRepeatMessageField<UnifySearchCommon$ResultItemGroup> item_groups = PBField.initRepeatMessage(UnifySearchCommon$ResultItemGroup.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);

    static {
        String[] strArr = {"result_code", "error_msg", "item_groups", "is_end", "cookie", "search_ver", "hot_words", "sub_hot_top_wording", "dont_need_merge", "exhibition_flags", MimeTypeParser.ATTR_EXTENSION, "process_datas", "key_word_prop", "origin_rpt_highlight_words"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66, 72, 80, 810, 818, 1608, 8002}, strArr, new Object[]{0, "", null, 0, byteStringMicro, byteStringMicro, null, byteStringMicro, 0, 0, byteStringMicro, null, 0, byteStringMicro}, UnifyTabSearch$RspBody.class);
    }

    public UnifyTabSearch$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.cookie = PBField.initBytes(byteStringMicro);
        this.search_ver = PBField.initBytes(byteStringMicro);
        this.hot_words = PBField.initRepeatMessage(UnifyTabSearch$SubHotWord.class);
        this.sub_hot_top_wording = PBField.initBytes(byteStringMicro);
        this.dont_need_merge = PBField.initUInt32(0);
        this.exhibition_flags = PBField.initUInt32(0);
        this.origin_rpt_highlight_words = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.extension = PBField.initBytes(byteStringMicro);
        this.process_datas = PBField.initRepeatMessage(UnifyTabSearch$ProcessData.class);
        this.key_word_prop = PBField.initUInt32(0);
    }
}
