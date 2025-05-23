package com.tencent.mobileqq.vas.pendant.proto;

import com.tencent.ecommerce.biz.pay.api.IECVasRechargeApi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.vas.VasUserData;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class qcUserinfoServer {
    public static final int AIO = 1;
    public static final int NONE = 0;
    public static final int SUMMARY_CARD = 2;
    public static final int TOFU = 3;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class CheckItemReq extends MessageMicro<CheckItemReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"stLogin", "rptItem"}, new Object[]{null, null}, CheckItemReq.class);
        public LoginInfo stLogin = new LoginInfo();
        public final PBRepeatMessageField<ItemBasic> rptItem = PBField.initRepeatMessage(ItemBasic.class);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class CheckItemRsp extends MessageMicro<CheckItemRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18}, new String[]{"rptItem"}, new Object[]{null}, CheckItemRsp.class);
        public final PBRepeatMessageField<ItemCheckInfo> rptItem = PBField.initRepeatMessage(ItemCheckInfo.class);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class ExtraAppInfo extends MessageMicro<ExtraAppInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"specialType", "multOperationType"}, new Object[]{0, 0}, ExtraAppInfo.class);
        public final PBInt32Field specialType = PBField.initInt32(0);
        public final PBRepeatField<Integer> multOperationType = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class ExtraItemInfo extends MessageMicro<ExtraItemInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"price", "sourceId"}, new Object[]{0, 0L}, ExtraItemInfo.class);
        public final PBUInt32Field price = PBField.initUInt32(0);
        public final PBUInt64Field sourceId = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class GetUserOrFriendUsingReq extends MessageMicro<GetUserOrFriendUsingReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64}, new String[]{"stLogin", IProfileProtocolConst.PARAM_IS_FRIEND, "uid", "bubbleItemID", "fontItemID", "specialFontID", "resource_from", "appid_from"}, new Object[]{null, Boolean.FALSE, 0L, 0, 0, 0, 0, 0}, GetUserOrFriendUsingReq.class);
        public LoginInfo stLogin = new LoginInfo();
        public final PBBoolField isFriend = PBField.initBool(false);
        public final PBInt64Field uid = PBField.initInt64(0);
        public final PBInt32Field bubbleItemID = PBField.initInt32(0);
        public final PBInt32Field fontItemID = PBField.initInt32(0);
        public final PBInt32Field specialFontID = PBField.initInt32(0);
        public final PBEnumField resource_from = PBField.initEnum(0);
        public final PBInt32Field appid_from = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class GetUserOrFriendUsingRsp extends MessageMicro<GetUserOrFriendUsingRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"usingItemList"}, new Object[]{null}, GetUserOrFriendUsingRsp.class);
        public final PBRepeatMessageField<UserItemDetail> usingItemList = PBField.initRepeatMessage(UserItemDetail.class);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class GetUserSplendidReq extends MessageMicro<GetUserSplendidReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"appid", "start_index", "page_size"}, new Object[]{0, 0, 0}, GetUserSplendidReq.class);
        public final PBInt32Field appid = PBField.initInt32(0);
        public final PBInt32Field start_index = PBField.initInt32(0);
        public final PBInt32Field page_size = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class GetUserSplendidRsp extends MessageMicro<GetUserSplendidRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"splendid_items", IECVasRechargeApi.EXT_PARAMS, "next_index", "is_end"}, new Object[]{null, null, 0, Boolean.FALSE}, GetUserSplendidRsp.class);
        public final PBRepeatMessageField<SplendidItem> splendid_items = PBField.initRepeatMessage(SplendidItem.class);
        public final PBRepeatMessageField<MapEntry> ext_params = PBField.initRepeatMessage(MapEntry.class);
        public final PBInt32Field next_index = PBField.initInt32(0);
        public final PBBoolField is_end = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class ItemBasic extends MessageMicro<ItemBasic> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"appid", "itemid"}, new Object[]{0, 0L}, ItemBasic.class);
        public final PBInt32Field appid = PBField.initInt32(0);
        public final PBInt64Field itemid = PBField.initInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class ItemCheckInfo extends MessageMicro<ItemCheckInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56}, new String[]{"appid", "itemid", "ret", "validts", "url", "text", "isSetup"}, new Object[]{0, 0L, 0, 0L, "", "", Boolean.FALSE}, ItemCheckInfo.class);
        public final PBInt32Field appid = PBField.initInt32(0);
        public final PBInt64Field itemid = PBField.initInt64(0);
        public final PBInt32Field ret = PBField.initInt32(0);
        public final PBInt64Field validts = PBField.initInt64(0);
        public final PBStringField url = PBField.initString("");
        public final PBStringField text = PBField.initString("");
        public final PBBoolField isSetup = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class LoginInfo extends MessageMicro<LoginInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"opplat", VasUserData.Key.QQ_VER}, new Object[]{0, ""}, LoginInfo.class);
        public final PBInt32Field opplat = PBField.initInt32(0);
        public final PBStringField qqVer = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class MapEntry extends MessageMicro<MapEntry> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, MapEntry.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class SplendidItem extends MessageMicro<SplendidItem> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"value_n", QCircleLpReportDc05507.KEY_ITEM_DETAIL, "operate_id"}, new Object[]{0L, null, ""}, SplendidItem.class);
        public final PBInt64Field value_n = PBField.initInt64(0);
        public UserItemDetail item_detail = new UserItemDetail();
        public final PBStringField operate_id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class SsoGetProfileReq extends MessageMicro<SsoGetProfileReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SsoGetProfileReq.class);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class SsoGetProfileRsp extends MessageMicro<SsoGetProfileRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"hasSeted"}, new Object[]{Boolean.FALSE}, SsoGetProfileRsp.class);
        public final PBBoolField hasSeted = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class UserItemDetail extends MessageMicro<UserItemDetail> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58, 64, 74, 80}, new String[]{"appId", "itemId", "name", VipFunCallConstants.KEY_FEET_TYPE, "itemBgColor", "image", "extrainfo", "isSetup", "extraappinfo", "validts"}, new Object[]{0, 0, "", 0, "", "", null, 0, null, 0L}, UserItemDetail.class);
        public final PBUInt32Field appId = PBField.initUInt32(0);
        public final PBUInt32Field itemId = PBField.initUInt32(0);
        public final PBStringField name = PBField.initString("");
        public final PBUInt32Field feeType = PBField.initUInt32(0);
        public final PBStringField itemBgColor = PBField.initString("");
        public final PBStringField image = PBField.initString("");
        public ExtraItemInfo extrainfo = new ExtraItemInfo();
        public final PBInt32Field isSetup = PBField.initInt32(0);
        public ExtraAppInfo extraappinfo = new ExtraAppInfo();
        public final PBInt64Field validts = PBField.initInt64(0);
    }

    qcUserinfoServer() {
    }
}
