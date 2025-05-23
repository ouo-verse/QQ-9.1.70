package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import s4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$VMAppInfo extends MessageMicro<VMBasicInfo$VMAppInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField app_id = PBField.initString("");
    public final PBStringField app_icon = PBField.initString("");
    public final PBStringField app_name = PBField.initString("");
    public final PBStringField app_tag = PBField.initString("");
    public final PBStringField app_desc = PBField.initString("");
    public final PBStringField app_version = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
    public VMBasicInfo$AppPkgInfo pkg_info = new MessageMicro<VMBasicInfo$AppPkgInfo>() { // from class: com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$AppPkgInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"name"}, new Object[]{""}, VMBasicInfo$AppPkgInfo.class);
        public final PBStringField name = PBField.initString("");
    };
    public VMBasicInfo$AppVideoInfo video_info = new MessageMicro<VMBasicInfo$AppVideoInfo>() { // from class: com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$AppVideoInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"video", c.PICS}, new Object[]{null, null}, VMBasicInfo$AppVideoInfo.class);
        public VMBasicInfo$AppMediaInfo video = new VMBasicInfo$AppMediaInfo();
        public final PBRepeatMessageField<VMBasicInfo$AppMediaInfo> pics = PBField.initRepeatMessage(VMBasicInfo$AppMediaInfo.class);
    };
    public VMBasicInfo$AppMediaInfo cover_info = new VMBasicInfo$AppMediaInfo();
    public final PBBoolField is_blocked = PBField.initBool(false);
    public final PBBoolField is_multi_login = PBField.initBool(false);
    public final PBBoolField is_support_pay = PBField.initBool(false);
    public final PBRepeatMessageField<VMBasicInfo$AppMediaInfo> covers = PBField.initRepeatMessage(VMBasicInfo$AppMediaInfo.class);
    public final PBRepeatMessageField<VMBasicInfo$AppCommentInfo> comments = PBField.initRepeatMessage(VMBasicInfo$AppCommentInfo.class);

    static {
        String[] strArr = {"app_id", MiniConst.WxMiniAppInfoConst.EXTRA_ICON, "app_name", "app_tag", MiniConst.WxMiniAppInfoConst.EXTRA_DESC, "app_version", "download_url", "pkg_info", "video_info", "cover_info", "is_blocked", "is_multi_login", "is_support_pay", "covers", "comments"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, 96, 104, 114, 122}, strArr, new Object[]{"", "", "", "", "", "", "", null, null, null, bool, bool, bool, null, null}, VMBasicInfo$VMAppInfo.class);
    }
}
