package com.tencent.mobileqq.dynamic_search;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class mobileqq_dynamic_search$ResponseBody extends MessageMicro<mobileqq_dynamic_search$ResponseBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie;
    public final PBUInt32Field hotwords_cache_timeout;
    public final PBRepeatMessageField<mobileqq_dynamic_search$ResultItemGroup> item_groups;
    public mobileqq_dynamic_search$JumpInfo jump_info;
    public final PBBytesField key_word;
    public mobileqq_dynamic_search$MoreWordInfo more_word_info;
    public final PBUInt64Field search_id;
    public final PBBytesField search_ver;
    public final PBRepeatMessageField<mobileqq_dynamic_search$TabItemGroup> tab_groups;
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBInt32Field retcode = PBField.initInt32(0);

    static {
        String[] strArr = {"cmd", "retcode", QCircleSchemeAttr.Detail.KEY_WORD, "item_groups", "search_id", "hotwords_cache_timeout", "more_word_info", "tab_groups", "jump_info", "bytes_cookie", "search_ver"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 58, 66, 74, 82, 802}, strArr, new Object[]{0, 0, byteStringMicro, null, 0L, 0, null, null, null, byteStringMicro, byteStringMicro}, mobileqq_dynamic_search$ResponseBody.class);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search$MoreWordInfo] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search$JumpInfo] */
    public mobileqq_dynamic_search$ResponseBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.key_word = PBField.initBytes(byteStringMicro);
        this.item_groups = PBField.initRepeatMessage(mobileqq_dynamic_search$ResultItemGroup.class);
        this.search_id = PBField.initUInt64(0L);
        this.hotwords_cache_timeout = PBField.initUInt32(0);
        this.more_word_info = new MessageMicro<mobileqq_dynamic_search$MoreWordInfo>() { // from class: com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search$MoreWordInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField jmp_url;
            public final PBBytesField show_words;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"show_words", "jmp_url"}, new Object[]{byteStringMicro2, byteStringMicro2}, mobileqq_dynamic_search$MoreWordInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.show_words = PBField.initBytes(byteStringMicro2);
                this.jmp_url = PBField.initBytes(byteStringMicro2);
            }
        };
        this.tab_groups = PBField.initRepeatMessage(mobileqq_dynamic_search$TabItemGroup.class);
        this.jump_info = new MessageMicro<mobileqq_dynamic_search$JumpInfo>() { // from class: com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search$JumpInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBInt32Field flag;
            public final PBBytesField title;
            public final PBBytesField url;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"url", "title", "flag"}, new Object[]{byteStringMicro2, byteStringMicro2, 0}, mobileqq_dynamic_search$JumpInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.url = PBField.initBytes(byteStringMicro2);
                this.title = PBField.initBytes(byteStringMicro2);
                this.flag = PBField.initInt32(0);
            }
        };
        this.bytes_cookie = PBField.initBytes(byteStringMicro);
        this.search_ver = PBField.initBytes(byteStringMicro);
    }
}
