package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_struct$ShareGroupInfo extends MessageMicro<qqstory_struct$ShareGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"basic_info", "ext_info"}, new Object[]{null, null}, qqstory_struct$ShareGroupInfo.class);
    public qqstory_struct$ShareGroupBasicInfo basic_info = new MessageMicro<qqstory_struct$ShareGroupBasicInfo>() { // from class: com.tencent.biz.qqstory.network.pb.qqstory_struct$ShareGroupBasicInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 56, 64, 72}, new String[]{"shared_group_id", "name", "owner", "header_unionid_list", "allow_stranger_visit_and_post", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL, "type", "group_code", "has_disband"}, new Object[]{"", "", "", "", 0, "", 0, 0L, 0}, qqstory_struct$ShareGroupBasicInfo.class);
        public final PBStringField shared_group_id = PBField.initString("");
        public final PBStringField name = PBField.initString("");
        public final PBStringField owner = PBField.initString("");
        public final PBRepeatField<String> header_unionid_list = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBUInt32Field allow_stranger_visit_and_post = PBField.initUInt32(0);
        public final PBStringField background_url = PBField.initString("");
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt32Field has_disband = PBField.initUInt32(0);
    };
    public qqstory_struct$ShareGroupExtInfo ext_info = new MessageMicro<qqstory_struct$ShareGroupExtInfo>() { // from class: com.tencent.biz.qqstory.network.pb.qqstory_struct$ShareGroupExtInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"has_join", "total_members", "total_videos", "owner_type"}, new Object[]{0, 0, 0, 0}, qqstory_struct$ShareGroupExtInfo.class);
        public final PBUInt32Field has_join = PBField.initUInt32(0);
        public final PBUInt32Field total_members = PBField.initUInt32(0);
        public final PBUInt32Field total_videos = PBField.initUInt32(0);
        public final PBUInt32Field owner_type = PBField.initUInt32(0);
    };
}
