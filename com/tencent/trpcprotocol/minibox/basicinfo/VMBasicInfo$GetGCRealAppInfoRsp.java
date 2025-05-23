package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$GetGCRealAppInfoRsp extends MessageMicro<VMBasicInfo$GetGCRealAppInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"info", DownloadInfo.spKey_Config}, new Object[]{null, null}, VMBasicInfo$GetGCRealAppInfoRsp.class);
    public VMBasicInfo$GCRealAppInfo info = new VMBasicInfo$GCRealAppInfo();
    public VMBasicInfo$UIConfig config = new VMBasicInfo$UIConfig();
}
