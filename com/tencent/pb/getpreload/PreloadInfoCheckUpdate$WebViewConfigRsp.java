package com.tencent.pb.getpreload;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class PreloadInfoCheckUpdate$WebViewConfigRsp extends MessageMicro<PreloadInfoCheckUpdate$WebViewConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public PreloadInfoCheckUpdate$ControlRspHead head = new PreloadInfoCheckUpdate$ControlRspHead();
    public final PBBoolField url_check = PBField.initBool(false);
    public final PBRepeatField<String> url_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBBoolField js_report = PBField.initBool(false);
    public final PBInt32Field interval = PBField.initInt32(0);

    static {
        String[] strArr = {"head", "url_check", "url_list", "js_report", WidgetCacheConstellationData.INTERVAL};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, strArr, new Object[]{null, bool, "", bool, 0}, PreloadInfoCheckUpdate$WebViewConfigRsp.class);
    }
}
