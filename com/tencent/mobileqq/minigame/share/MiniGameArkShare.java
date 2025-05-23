package com.tencent.mobileqq.minigame.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameArkShare {

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class GenMiniGameArkJsonReq extends MessageMicro<GenMiniGameArkJsonReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"appid", "title", "desc", "preview", "jump_url"}, new Object[]{"", "", "", "", ""}, GenMiniGameArkJsonReq.class);
        public final PBStringField appid = PBField.initString("");
        public final PBStringField title = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
        public final PBStringField preview = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class GenMiniGameArkJsonRsp extends MessageMicro<GenMiniGameArkJsonRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ark_json"}, new Object[]{""}, GenMiniGameArkJsonRsp.class);
        public final PBStringField ark_json = PBField.initString("");
    }

    MiniGameArkShare() {
    }
}
