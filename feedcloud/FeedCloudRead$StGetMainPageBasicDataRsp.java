package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetMainPageBasicDataRsp extends MessageMicro<FeedCloudRead$StGetMainPageBasicDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBUInt32Field fansValueStyle = PBField.initUInt32(0);
    public final PBUInt32Field fuelValueStyle = PBField.initUInt32(0);
    public FeedCloudMeta$StShare share = new FeedCloudMeta$StShare();
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField pmBeginShow = PBField.initString("");
    public final PBBoolField isFirstLogin = PBField.initBool(false);
    public final PBUInt32Field isPenguinUser = PBField.initUInt32(0);
    public FeedCloudMeta$StFollowRecomInfo followRecomInfo = new FeedCloudMeta$StFollowRecomInfo();
    public FeedCloudMeta$StExternalMedalWallInfo medalWall = new FeedCloudMeta$StExternalMedalWallInfo();
    public FeedCloudRead$GuildInfo guildInfo = new FeedCloudRead$GuildInfo();
    public final PBRepeatMessageField<FeedCloudRead$StMainPageOperateInfo> operateInfo = PBField.initRepeatMessage(FeedCloudRead$StMainPageOperateInfo.class);
    public final PBStringField penguinModifyGuideURL = PBField.initString("");
    public final PBBoolField isKandianUser = PBField.initBool(false);
    public FeedCloudMeta$StUser kandianUser = new FeedCloudMeta$StUser();
    public FeedCloudRead$TaskEntry taskEntry = new MessageMicro<FeedCloudRead$TaskEntry>() { // from class: feedcloud.FeedCloudRead$TaskEntry
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 80, 96, 106, 114}, new String[]{"mode", "static_default_icon", "static_cover_icon", "static_dark_icon", "active_icon", "jump_url", "count", "red_dot_flag", "icon", "text"}, new Object[]{0, "", "", "", "", "", 0, 0, "", ""}, FeedCloudRead$TaskEntry.class);
        public final PBEnumField mode = PBField.initEnum(0);
        public final PBStringField static_default_icon = PBField.initString("");
        public final PBStringField static_cover_icon = PBField.initString("");
        public final PBStringField static_dark_icon = PBField.initString("");
        public final PBStringField active_icon = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
        public final PBUInt32Field count = PBField.initUInt32(0);
        public final PBInt32Field red_dot_flag = PBField.initInt32(0);
        public final PBStringField icon = PBField.initString("");
        public final PBStringField text = PBField.initString("");
    };
    public FeedCloudRead$RedPoint redPoint = new FeedCloudRead$RedPoint();
    public FeedCloudMeta$CovenantLiteDialog dialog = new FeedCloudMeta$CovenantLiteDialog();
    public FeedCloudRead$CallFollow callFollow = new FeedCloudRead$CallFollow();
    public FeedCloudMeta$StIconInfo magic_icon = new FeedCloudMeta$StIconInfo();
    public FeedCloudRead$TaskEntryNew task_entry_new = new FeedCloudRead$TaskEntryNew();
    public final PBBoolField hasFansEntryRedPoint = PBField.initBool(false);

    static {
        String[] strArr = {"extInfo", QCircleAlphaUserReporter.KEY_USER, "fansValueStyle", "fuelValueStyle", "share", "busiRspData", "pmBeginShow", "isFirstLogin", "isPenguinUser", "followRecomInfo", "medalWall", "guildInfo", "operateInfo", "penguinModifyGuideURL", "isKandianUser", "kandianUser", "taskEntry", "redPoint", "dialog", "callFollow", "magic_icon", "task_entry_new", "hasFansEntryRedPoint"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58, 64, 72, 82, 90, 98, 106, 114, 120, 130, 138, 146, 154, 162, 170, 178, 184}, strArr, new Object[]{null, null, 0, 0, null, ByteStringMicro.EMPTY, "", bool, 0, null, null, null, null, "", bool, null, null, null, null, null, null, null, bool}, FeedCloudRead$StGetMainPageBasicDataRsp.class);
    }
}
