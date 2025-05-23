package com.tencent.pb.getpreload;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class PreloadInfoCheckUpdate$PreloadInfoRsp extends MessageMicro<PreloadInfoCheckUpdate$PreloadInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48, 56, 66}, new String[]{"head", IQQComicPluginUtil.PPP_PRELOAD_SWITCH, "preload", WidgetCacheConstellationData.INTERVAL, "applist", "red_ram", "click_ram", "preload_result"}, new Object[]{null, 0, Boolean.FALSE, 0, "", 0, 0, null}, PreloadInfoCheckUpdate$PreloadInfoRsp.class);
    public PreloadInfoCheckUpdate$ControlRspHead head = new PreloadInfoCheckUpdate$ControlRspHead();
    public final PBInt32Field preload_switch = PBField.initInt32(0);
    public final PBBoolField preload = PBField.initBool(false);
    public final PBInt32Field interval = PBField.initInt32(0);
    public final PBRepeatField<String> applist = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field red_ram = PBField.initInt32(0);
    public final PBInt32Field click_ram = PBField.initInt32(0);
    public final PBRepeatMessageField<PreloadInfoCheckUpdate$PreloadResult> preload_result = PBField.initRepeatMessage(PreloadInfoCheckUpdate$PreloadResult.class);
}
