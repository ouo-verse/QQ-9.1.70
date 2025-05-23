package cooperation.ilive.pb;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class LiveGroupTips$GetLiveGroupTipsRsp extends MessageMicro<LiveGroupTips$GetLiveGroupTipsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, 56, 66, 72}, new String[]{AudienceReportConst.ROOM_ID, "room_title", "room_icon", "room_viewer", "room_schema", "is_living", WidgetCacheConstellationData.INTERVAL, "viewer_text", IPublicAccountBrowser.KEY_PUB_UIN}, new Object[]{0L, "", "", 0L, "", 0, 0, "", 0L}, LiveGroupTips$GetLiveGroupTipsRsp.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBStringField room_title = PBField.initString("");
    public final PBStringField room_icon = PBField.initString("");
    public final PBUInt64Field room_viewer = PBField.initUInt64(0);
    public final PBStringField room_schema = PBField.initString("");
    public final PBUInt32Field is_living = PBField.initUInt32(0);
    public final PBUInt32Field interval = PBField.initUInt32(0);
    public final PBStringField viewer_text = PBField.initString("");
    public final PBUInt64Field puin = PBField.initUInt64(0);
}
