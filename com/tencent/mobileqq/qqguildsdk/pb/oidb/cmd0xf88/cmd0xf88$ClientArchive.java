package com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class cmd0xf88$ClientArchive extends MessageMicro<cmd0xf88$ClientArchive> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 8010, MessageHandlerConstants.NOTIFY_TYPE_REQ_BLESS_DIRTY_TEXT_CHECK, 8026, MessageHandlerConstants.NOTIFY_TYPE_DANCE_MACHINE, MessageHandlerConstants.NOTIFY_TYPE_QQGAME_MSG_RSP, MessageHandlerConstants.NOTIFY_TYPE_SQUARE_CHAT_ERROR_RSP, 80008}, new String[]{CommonConstant.ReqAccessTokenParam.CLIENT_ID, "archive_name", "template_id", "bg_img_url", "template_1", "template_2", "template_3", "template_4", "template_5", "template_6", "update_timestamp"}, new Object[]{0, "", 0, "", null, null, null, null, null, null, 0L}, cmd0xf88$ClientArchive.class);
    public final PBUInt32Field client_id = PBField.initUInt32(0);
    public final PBStringField archive_name = PBField.initString("");
    public final PBUInt32Field template_id = PBField.initUInt32(0);
    public final PBStringField bg_img_url = PBField.initString("");
    public cmd0xf88$SmobaArchiveTemplate template_1 = new MessageMicro<cmd0xf88$SmobaArchiveTemplate>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$SmobaArchiveTemplate
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 88, 106, 114, 122, 130, 138, 146}, new String[]{"grade_level", "star_cnt", "total_num", "mvp_num", "win_rate", "good_branch", "good_hero_icon_list", "vip_level_icon", "honor_icon", "honor_desc", "max_grade_of_rank", "highlight_icon", "highlight_desc", "highlight_logo", "wang_zhe_cnt_icon", "wang_zhe_cnt", "jump_url"}, new Object[]{0, 0, "", "", "", "", "", "", "", "", 0, "", "", "", "", "", ""}, cmd0xf88$SmobaArchiveTemplate.class);
        public final PBUInt32Field grade_level = PBField.initUInt32(0);
        public final PBUInt32Field star_cnt = PBField.initUInt32(0);
        public final PBStringField total_num = PBField.initString("");
        public final PBStringField mvp_num = PBField.initString("");
        public final PBStringField win_rate = PBField.initString("");
        public final PBStringField good_branch = PBField.initString("");
        public final PBRepeatField<String> good_hero_icon_list = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField vip_level_icon = PBField.initString("");
        public final PBStringField honor_icon = PBField.initString("");
        public final PBStringField honor_desc = PBField.initString("");
        public final PBUInt32Field max_grade_of_rank = PBField.initUInt32(0);
        public final PBStringField highlight_icon = PBField.initString("");
        public final PBStringField highlight_desc = PBField.initString("");
        public final PBStringField highlight_logo = PBField.initString("");
        public final PBStringField wang_zhe_cnt_icon = PBField.initString("");
        public final PBStringField wang_zhe_cnt = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
    };
    public cmd0xf88$ArchiveTemplate2 template_2 = new MessageMicro<cmd0xf88$ArchiveTemplate2>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$ArchiveTemplate2
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130}, new String[]{"title1", "desc1", "title2", "desc2", "title3", "desc3", "title4", "desc4", "title5", "desc5", "title6", "desc6", "title7", "desc7", "icon", "icon_name"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, cmd0xf88$ArchiveTemplate2.class);
        public final PBStringField title1 = PBField.initString("");
        public final PBStringField desc1 = PBField.initString("");
        public final PBStringField title2 = PBField.initString("");
        public final PBStringField desc2 = PBField.initString("");
        public final PBStringField title3 = PBField.initString("");
        public final PBStringField desc3 = PBField.initString("");
        public final PBStringField title4 = PBField.initString("");
        public final PBStringField desc4 = PBField.initString("");
        public final PBStringField title5 = PBField.initString("");
        public final PBStringField desc5 = PBField.initString("");
        public final PBStringField title6 = PBField.initString("");
        public final PBStringField desc6 = PBField.initString("");
        public final PBStringField title7 = PBField.initString("");
        public final PBStringField desc7 = PBField.initString("");
        public final PBStringField icon = PBField.initString("");
        public final PBStringField icon_name = PBField.initString("");
    };
    public cmd0xf88$ArchiveTemplate3 template_3 = new MessageMicro<cmd0xf88$ArchiveTemplate3>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$ArchiveTemplate3
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90}, new String[]{"icon1", "icon1_name", "icon2", "title1", "desc1", "title2", "desc2", "title3", "desc3", "title4", "desc4"}, new Object[]{"", "", "", "", "", "", "", "", "", "", ""}, cmd0xf88$ArchiveTemplate3.class);
        public final PBStringField icon1 = PBField.initString("");
        public final PBStringField icon1_name = PBField.initString("");
        public final PBStringField icon2 = PBField.initString("");
        public final PBStringField title1 = PBField.initString("");
        public final PBStringField desc1 = PBField.initString("");
        public final PBStringField title2 = PBField.initString("");
        public final PBStringField desc2 = PBField.initString("");
        public final PBStringField title3 = PBField.initString("");
        public final PBStringField desc3 = PBField.initString("");
        public final PBStringField title4 = PBField.initString("");
        public final PBStringField desc4 = PBField.initString("");
    };
    public cmd0xf88$ArchiveTemplate4 template_4 = new MessageMicro<cmd0xf88$ArchiveTemplate4>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$ArchiveTemplate4
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"icon1", "title1", "desc1", "title2", "desc2", "title3", "desc3", "title4", "icon4"}, new Object[]{"", "", "", "", "", "", "", "", ""}, cmd0xf88$ArchiveTemplate4.class);
        public final PBStringField icon1 = PBField.initString("");
        public final PBStringField title1 = PBField.initString("");
        public final PBStringField desc1 = PBField.initString("");
        public final PBStringField title2 = PBField.initString("");
        public final PBStringField desc2 = PBField.initString("");
        public final PBStringField title3 = PBField.initString("");
        public final PBStringField desc3 = PBField.initString("");
        public final PBStringField title4 = PBField.initString("");
        public final PBStringField icon4 = PBField.initString("");
    };
    public cmd0xf88$ArchiveTemplate5 template_5 = new MessageMicro<cmd0xf88$ArchiveTemplate5>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$ArchiveTemplate5
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122}, new String[]{"title1", "desc1", "title2", "desc2", "title3", "desc3", "title4", "desc4", "icon_main", "title_main", "sub_desc1", "sub_desc2", "icon1", "icon2", "icon3"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, cmd0xf88$ArchiveTemplate5.class);
        public final PBStringField title1 = PBField.initString("");
        public final PBStringField desc1 = PBField.initString("");
        public final PBStringField title2 = PBField.initString("");
        public final PBStringField desc2 = PBField.initString("");
        public final PBStringField title3 = PBField.initString("");
        public final PBStringField desc3 = PBField.initString("");
        public final PBStringField title4 = PBField.initString("");
        public final PBStringField desc4 = PBField.initString("");
        public final PBStringField icon_main = PBField.initString("");
        public final PBStringField title_main = PBField.initString("");
        public final PBStringField sub_desc1 = PBField.initString("");
        public final PBStringField sub_desc2 = PBField.initString("");
        public final PBStringField icon1 = PBField.initString("");
        public final PBStringField icon2 = PBField.initString("");
        public final PBStringField icon3 = PBField.initString("");
    };
    public cmd0xf88$ArchiveTemplate6 template_6 = new MessageMicro<cmd0xf88$ArchiveTemplate6>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$ArchiveTemplate6
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"archive_name", "flollowers_title", "following_title", "total_stars_earned_title", "total_commits_title", "total_commits_desc", "total_prs_title", "total_issues_title", "contributed_to_title"}, new Object[]{"", "", "", "", "", "", "", "", ""}, cmd0xf88$ArchiveTemplate6.class);
        public final PBStringField archive_name = PBField.initString("");
        public final PBStringField flollowers_title = PBField.initString("");
        public final PBStringField following_title = PBField.initString("");
        public final PBStringField total_stars_earned_title = PBField.initString("");
        public final PBStringField total_commits_title = PBField.initString("");
        public final PBStringField total_commits_desc = PBField.initString("");
        public final PBStringField total_prs_title = PBField.initString("");
        public final PBStringField total_issues_title = PBField.initString("");
        public final PBStringField contributed_to_title = PBField.initString("");
    };
    public final PBInt64Field update_timestamp = PBField.initInt64(0);
}
