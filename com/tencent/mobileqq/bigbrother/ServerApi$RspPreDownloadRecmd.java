package com.tencent.mobileqq.bigbrother;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tenpay.sdk.util.UinConfigManager;

/* loaded from: classes11.dex */
public final class ServerApi$RspPreDownloadRecmd extends MessageMicro<ServerApi$RspPreDownloadRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58}, new String[]{"err_info", "start_time", "end_time", WidgetCacheConstellationData.INTERVAL, UinConfigManager.KEY_ADS_HB_DAILY_NUM, "quota_num", "download_url"}, new Object[]{null, 0, 0, 0, 0, 0, ""}, ServerApi$RspPreDownloadRecmd.class);
    public ServerApi$ErrorInfo err_info = new ServerApi$ErrorInfo();
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBUInt32Field interval = PBField.initUInt32(0);
    public final PBUInt32Field daily_num = PBField.initUInt32(0);
    public final PBUInt32Field quota_num = PBField.initUInt32(0);
    public final PBStringField download_url = PBField.initString("");
}
