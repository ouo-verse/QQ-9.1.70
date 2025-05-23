package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ThemeDIYDownloader;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class sellerMsgReader$MsgCookie extends MessageMicro<sellerMsgReader$MsgCookie> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{ThemeDIYDownloader.HEADER_PAGEINDEX}, new Object[]{0}, sellerMsgReader$MsgCookie.class);
    public final PBUInt32Field page_index = PBField.initUInt32(0);
}
