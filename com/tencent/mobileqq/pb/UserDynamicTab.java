package com.tencent.mobileqq.pb;

import com.qzone.widget.u;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.pb.MessageMicro;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class UserDynamicTab {
    public static final int FROM_TYPE_BACKEND = 2;
    public static final int FROM_TYPE_SSO = 1;
    public static final int FROM_TYPE_UNSPECIFIED = 0;
    public static final int MODEL_TYPE_DEFAULT = 1;
    public static final int MODEL_TYPE_OLD = 4;
    public static final int MODEL_TYPE_SIMPLE = 2;
    public static final int MODEL_TYPE_TEEN = 3;
    public static final int MODEL_TYPE_UNSPECIFIED = 0;
    public static final int RET_CODE_DATA_NULL = 20001;
    public static final int RET_CODE_DOWNSTREAM_ERROR = 20002;
    public static final int RET_CODE_INTERNAL_ERROR = 10001;
    public static final int RET_CODE_PARAMS_INVALID = 20003;
    public static final int RET_CODE_SUCCESS_UNSPECIFIED = 0;
    public static final int TAB_ID_CHANNEL = 2;
    public static final int TAB_ID_KANDIAN = 3;
    public static final int TAB_ID_TINY_WORLD = 1;
    public static final int TAB_ID_UNSPECIFIED = 0;
    public static final int TAB_ID_YUANMENG = 4;
    public static final int TAB_STATUS_CLOSE = 2;
    public static final int TAB_STATUS_OPEN = 1;
    public static final int TAB_STATUS_UNSPECIFIED = 0;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class EntranceTabID extends MessageMicro<EntranceTabID> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"init_tab", "real_init_tab"}, new Object[]{0, 0}, EntranceTabID.class);
        public final PBEnumField init_tab = PBField.initEnum(0);
        public final PBEnumField real_init_tab = PBField.initEnum(0);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class GetTabListRequest extends MessageMicro<GetTabListRequest> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"sequence", "kandian_data", "qua", "device_info"}, new Object[]{0L, null, "", ""}, GetTabListRequest.class);
        public final PBUInt64Field sequence = PBField.initUInt64(0);
        public TabData kandian_data = new TabData();
        public final PBStringField qua = PBField.initString("");
        public final PBStringField device_info = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class GetTabListResponse extends MessageMicro<GetTabListResponse> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"tab_data", "sequence", "reson_code", "model_rule", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE}, new Object[]{null, 0L, 0, null, null}, GetTabListResponse.class);
        public final PBRepeatMessageField<TabData> tab_data = PBField.initRepeatMessage(TabData.class);
        public final PBUInt64Field sequence = PBField.initUInt64(0);
        public final PBUInt32Field reson_code = PBField.initUInt32(0);
        public final PBRepeatMessageField<ModelRule> model_rule = PBField.initRepeatMessage(ModelRule.class);
        public EntranceTabID entrance = new EntranceTabID();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class ModelRule extends MessageMicro<ModelRule> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"model_type", u.COLUMN_TAB_ID}, new Object[]{0, null}, ModelRule.class);
        public final PBEnumField model_type = PBField.initEnum(0);
        public final PBRepeatMessageField<ModelTabId> tab_id = PBField.initRepeatMessage(ModelTabId.class);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class ModelTabId extends MessageMicro<ModelTabId> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16}, new String[]{u.COLUMN_TAB_ID}, new Object[]{0}, ModelTabId.class);
        public final PBUInt32Field tab_id = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class SetTabListRequest extends MessageMicro<SetTabListRequest> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"tab_data", "from_type", "uin", QFSEdgeItem.KEY_EXTEND}, new Object[]{null, 0, "", ByteStringMicro.EMPTY}, SetTabListRequest.class);
        public final PBRepeatMessageField<TabData> tab_data = PBField.initRepeatMessage(TabData.class);
        public final PBEnumField from_type = PBField.initEnum(0);
        public final PBStringField uin = PBField.initString("");
        public final PBBytesField extend = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class SetTabListResponse extends MessageMicro<SetTabListResponse> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"sequence", "reson_code"}, new Object[]{0L, 0}, SetTabListResponse.class);
        public final PBUInt64Field sequence = PBField.initUInt64(0);
        public final PBUInt32Field reson_code = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class TabData extends MessageMicro<TabData> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field tab_id = PBField.initUInt32(0);
        public final PBEnumField tab_status = PBField.initEnum(0);
        public final PBBoolField gray_status = PBField.initBool(false);
        public final PBBoolField first_show = PBField.initBool(false);
        public final PBBoolField sheild_in_setpage = PBField.initBool(false);

        static {
            String[] strArr = {u.COLUMN_TAB_ID, "tab_status", "gray_status", "first_show", "sheild_in_setpage"};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, strArr, new Object[]{0, 0, bool, bool, bool}, TabData.class);
        }
    }

    UserDynamicTab() {
    }
}
