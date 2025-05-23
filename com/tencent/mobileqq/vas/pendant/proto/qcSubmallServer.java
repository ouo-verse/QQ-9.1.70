package com.tencent.mobileqq.vas.pendant.proto;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class qcSubmallServer {
    public static final int DISCOUNT_EVERY = 2;
    public static final int DISCOUNT_NONE = 0;
    public static final int DISCOUNT_OVER = 1;
    public static final int DISCOUNT_SVIP_FREE = 6;
    public static final int DISCOUNT_SVIP_PAY = 5;
    public static final int FIXED_RATE_NUM = 4;
    public static final int FIXED_RATE_PRICE = 3;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class DiscountInfo extends MessageMicro<DiscountInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"acts", "itemDiscount"}, new Object[]{null, null}, DiscountInfo.class);
        public final PBRepeatMessageField<Item> acts = PBField.initRepeatMessage(Item.class);
        public ItemDiscount itemDiscount = new ItemDiscount();

        /* compiled from: P */
        /* loaded from: classes20.dex */
        public static final class Item extends MessageMicro<Item> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"act_id", "type", "text", "subtraction"}, new Object[]{0, 0, "", ""}, Item.class);
            public final PBInt32Field act_id = PBField.initInt32(0);
            public final PBEnumField type = PBField.initEnum(0);
            public final PBStringField text = PBField.initString("");
            public final PBStringField subtraction = PBField.initString("");
        }
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
    public static final class ExtraImageInfo extends MessageMicro<ExtraImageInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"isdynamic", "images"}, new Object[]{0, ""}, ExtraImageInfo.class);
        public final PBInt32Field isdynamic = PBField.initInt32(0);
        public final PBRepeatField<String> images = PBField.initRepeat(PBStringField.__repeatHelper__);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class ExtraItemInfo extends MessageMicro<ExtraItemInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"price", "sourceId", MessageForRichState.SIGN_MSG_FONT_TYPE}, new Object[]{0, 0L, 0}, ExtraItemInfo.class);
        public final PBUInt32Field price = PBField.initUInt32(0);
        public final PBUInt64Field sourceId = PBField.initUInt64(0);
        public final PBInt32Field fontType = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class GetChiefListReply extends MessageMicro<GetChiefListReply> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "modData", "extParams"}, new Object[]{0, "", null, null}, GetChiefListReply.class);
        public final PBInt32Field ret = PBField.initInt32(0);
        public final PBStringField errmsg = PBField.initString("");
        public final PBRepeatMessageField<ModuleData> modData = PBField.initRepeatMessage(ModuleData.class);
        public final PBRepeatMessageField<MapEntry> extParams = PBField.initRepeatMessage(MapEntry.class);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class GetChiefListRequest extends MessageMicro<GetChiefListRequest> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"stLogin", "appid", "locationtype", "lUid", "mParams"}, new Object[]{null, 0, 0, 0L, null}, GetChiefListRequest.class);
        public LoginInfo stLogin = new LoginInfo();
        public final PBUInt32Field appid = PBField.initUInt32(0);
        public final PBInt32Field locationtype = PBField.initInt32(0);
        public final PBUInt64Field lUid = PBField.initUInt64(0);
        public final PBRepeatMessageField<MapEntry> mParams = PBField.initRepeatMessage(MapEntry.class);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class GetMoreListReply extends MessageMicro<GetMoreListReply> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "nextIndex", "isListEnd", VideoTemplateParser.ITEM_LIST, "extParams"}, new Object[]{0, "", 0, 0, null, null}, GetMoreListReply.class);
        public final PBInt32Field ret = PBField.initInt32(0);
        public final PBStringField errmsg = PBField.initString("");
        public final PBUInt32Field nextIndex = PBField.initUInt32(0);
        public final PBInt32Field isListEnd = PBField.initInt32(0);
        public final PBRepeatMessageField<SubmallPreviewItem> itemList = PBField.initRepeatMessage(SubmallPreviewItem.class);
        public final PBRepeatMessageField<MapEntry> extParams = PBField.initRepeatMessage(MapEntry.class);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class GetMoreListRequest extends MessageMicro<GetMoreListRequest> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58, 66}, new String[]{"stLogin", "appid", "locationtype", "lUid", "listindex", "pagesize", "mParams", "modName"}, new Object[]{null, 0, 0, 0L, 0, 0, null, ""}, GetMoreListRequest.class);
        public LoginInfo stLogin = new LoginInfo();
        public final PBUInt32Field appid = PBField.initUInt32(0);
        public final PBInt32Field locationtype = PBField.initInt32(0);
        public final PBUInt64Field lUid = PBField.initUInt64(0);
        public final PBUInt32Field listindex = PBField.initUInt32(0);
        public final PBUInt32Field pagesize = PBField.initUInt32(0);
        public final PBRepeatMessageField<MapEntry> mParams = PBField.initRepeatMessage(MapEntry.class);
        public final PBStringField modName = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class ItemDiscount extends MessageMicro<ItemDiscount> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"type", "discountPrice", "userCanDiscount"}, new Object[]{0, 0, Boolean.FALSE}, ItemDiscount.class);
        public final PBEnumField type = PBField.initEnum(0);
        public final PBInt32Field discountPrice = PBField.initInt32(0);
        public final PBBoolField userCanDiscount = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class LoginInfo extends MessageMicro<LoginInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50}, new String[]{"lUin", "iKeyType", "sSKey", "sClientIp", "iOpplat", "sClientVer"}, new Object[]{0L, 0, "", "", 0, ""}, LoginInfo.class);
        public final PBUInt64Field lUin = PBField.initUInt64(0);
        public final PBInt32Field iKeyType = PBField.initInt32(0);
        public final PBStringField sSKey = PBField.initString("");
        public final PBStringField sClientIp = PBField.initString("");
        public final PBInt32Field iOpplat = PBField.initInt32(0);
        public final PBStringField sClientVer = PBField.initString("");
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
    public static final class ModuleData extends MessageMicro<ModuleData> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"cname", "vitem", "extModParams"}, new Object[]{"", null, null}, ModuleData.class);
        public final PBStringField cname = PBField.initString("");
        public final PBRepeatMessageField<SubmallPreviewItem> vitem = PBField.initRepeatMessage(SubmallPreviewItem.class);
        public final PBRepeatMessageField<MapEntry> extModParams = PBField.initRepeatMessage(MapEntry.class);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class RankInfo extends MessageMicro<RankInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"info", LocalPhotoFaceInfo.SCORE, "ranking", "rankID", "grayPolicyID"}, new Object[]{"", 0, 0, 0, ""}, RankInfo.class);
        public final PBStringField info = PBField.initString("");
        public final PBUInt32Field score = PBField.initUInt32(0);
        public final PBUInt32Field ranking = PBField.initUInt32(0);
        public final PBUInt32Field rankID = PBField.initUInt32(0);
        public final PBStringField grayPolicyID = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class SubmallPreviewItem extends MessageMicro<SubmallPreviewItem> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58, 64, 74, 82, 90, 98, 106, 114, 122}, new String[]{"appId", "itemId", "name", VipFunCallConstants.KEY_FEET_TYPE, "itemBgColor", "image", "extrainfo", "isSetup", "extraappinfo", "triggerInfo", "rankInfo", "extInfo", "extraimage", "discountInfo", WadlProxyConsts.KEY_JUMP_URL}, new Object[]{0, 0, "", 0, "", "", null, 0, null, "", null, null, null, null, ""}, SubmallPreviewItem.class);
        public final PBUInt32Field appId = PBField.initUInt32(0);
        public final PBUInt32Field itemId = PBField.initUInt32(0);
        public final PBStringField name = PBField.initString("");
        public final PBUInt32Field feeType = PBField.initUInt32(0);
        public final PBStringField itemBgColor = PBField.initString("");
        public final PBStringField image = PBField.initString("");
        public ExtraItemInfo extrainfo = new ExtraItemInfo();
        public final PBInt32Field isSetup = PBField.initInt32(0);
        public ExtraAppInfo extraappinfo = new ExtraAppInfo();
        public final PBStringField triggerInfo = PBField.initString("");
        public RankInfo rankInfo = new RankInfo();
        public ExtraItemInfo extInfo = new ExtraItemInfo();
        public ExtraImageInfo extraimage = new ExtraImageInfo();
        public DiscountInfo discountInfo = new DiscountInfo();
        public final PBStringField jumpUrl = PBField.initString("");
    }

    qcSubmallServer() {
    }
}
