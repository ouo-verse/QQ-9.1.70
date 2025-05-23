package com.tencent.trpcprotocol.unite.unifysearch.head_template;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class HeadTemplatePB$SearchSuggestion extends MessageMicro<HeadTemplatePB$SearchSuggestion> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"title", "type", "url"}, new Object[]{"", 0, ""}, HeadTemplatePB$SearchSuggestion.class);
    public final PBStringField title = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField url = PBField.initString("");
}
