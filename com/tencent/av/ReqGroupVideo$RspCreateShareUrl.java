package com.tencent.av;

import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ReqGroupVideo$RspCreateShareUrl extends MessageMicro<ReqGroupVideo$RspCreateShareUrl> {
    static final MessageMicro.FieldMap __fieldMap__;
    public common$ErrorInfo result = new common$ErrorInfo();
    public final PBBytesField share_url;
    public final PBBytesField share_url_with_no_sig;

    static {
        String[] strArr = {"result", GetGuildJoinUrlServlet.BUNDLE_KEY_URL, "share_url_with_no_sig"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, strArr, new Object[]{null, byteStringMicro, byteStringMicro}, ReqGroupVideo$RspCreateShareUrl.class);
    }

    public ReqGroupVideo$RspCreateShareUrl() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.share_url = PBField.initBytes(byteStringMicro);
        this.share_url_with_no_sig = PBField.initBytes(byteStringMicro);
    }
}
