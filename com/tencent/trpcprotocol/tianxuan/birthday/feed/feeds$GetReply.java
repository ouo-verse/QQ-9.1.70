package com.tencent.trpcprotocol.tianxuan.birthday.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class feeds$GetReply extends MessageMicro<feeds$GetReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"show", "act_id", "rule_id"}, new Object[]{null, "", ""}, feeds$GetReply.class);
    public feeds$Show show = new MessageMicro<feeds$Show>() { // from class: com.tencent.trpcprotocol.tianxuan.birthday.feed.feeds$Show
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"title", "bg_img", "head_img", "shuoshuo_img", "bday_icon_img", "more_deco_url"}, new Object[]{"", "", "", "", "", ""}, feeds$Show.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField bg_img = PBField.initString("");
        public final PBStringField head_img = PBField.initString("");
        public final PBStringField shuoshuo_img = PBField.initString("");
        public final PBStringField bday_icon_img = PBField.initString("");
        public final PBStringField more_deco_url = PBField.initString("");
    };
    public final PBStringField act_id = PBField.initString("");
    public final PBStringField rule_id = PBField.initString("");
}
