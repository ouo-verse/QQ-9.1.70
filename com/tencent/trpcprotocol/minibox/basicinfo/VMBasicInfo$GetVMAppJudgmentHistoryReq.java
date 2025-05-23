package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.transfile.ThemeDIYDownloader;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$GetVMAppJudgmentHistoryReq extends MessageMicro<VMBasicInfo$GetVMAppJudgmentHistoryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"app_context", "page_size", ThemeDIYDownloader.HEADER_PAGEINDEX}, new Object[]{null, 0, 0}, VMBasicInfo$GetVMAppJudgmentHistoryReq.class);
    public VMBasicInfo$VMAppLaunchContext app_context = new VMBasicInfo$VMAppLaunchContext();
    public final PBInt32Field page_size = PBField.initInt32(0);
    public final PBInt32Field page_index = PBField.initInt32(0);
}
