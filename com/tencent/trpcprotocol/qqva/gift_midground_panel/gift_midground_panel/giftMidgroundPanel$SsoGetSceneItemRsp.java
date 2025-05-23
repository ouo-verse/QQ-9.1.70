package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$SsoGetSceneItemRsp extends MessageMicro<giftMidgroundPanel$SsoGetSceneItemRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 58}, new String[]{"code", "msg", "cache_time", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "ext_info", "show_package_tab", "welfare_info"}, new Object[]{0, "", 0L, null, null, Boolean.FALSE, null}, giftMidgroundPanel$SsoGetSceneItemRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381629msg = PBField.initString("");
    public final PBInt64Field cache_time = PBField.initInt64(0);
    public giftMidgroundPanel$SceneItem item = new giftMidgroundPanel$SceneItem();
    public final PBRepeatMessageField<giftMidgroundPanel$ExtendInfo> ext_info = PBField.initRepeatMessage(giftMidgroundPanel$ExtendInfo.class);
    public final PBBoolField show_package_tab = PBField.initBool(false);
    public giftMidgroundPanel$WelfareInfo welfare_info = new giftMidgroundPanel$WelfareInfo();
}
