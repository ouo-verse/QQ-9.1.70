package com.tencent.pb.getpreload;

import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class PreloadInfoCheckUpdate$PreloadResult extends MessageMicro<PreloadInfoCheckUpdate$PreloadResult> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBInt32Field preload_switch = PBField.initInt32(0);
    public final PBBoolField preload = PBField.initBool(false);
    public final PBBoolField preload_data = PBField.initBool(false);
    public final PBInt32Field mem_limit = PBField.initInt32(0);
    public final PBStringField ext1 = PBField.initString("");

    static {
        String[] strArr = {"appid", IQQComicPluginUtil.PPP_PRELOAD_SWITCH, "preload", IQQComicPluginUtil.PPP_PRELOAD_DATA, IQQComicPluginUtil.PPP_MEM_LIMIT, "ext1"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, strArr, new Object[]{0, 0, bool, bool, 0, ""}, PreloadInfoCheckUpdate$PreloadResult.class);
    }
}
