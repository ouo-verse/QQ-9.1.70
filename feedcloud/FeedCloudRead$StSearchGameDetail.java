package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchGameDetail extends MessageMicro<FeedCloudRead$StSearchGameDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 64, 72, 82, 90, 98, 106, 114, 122, 130, 138}, new String[]{CrashRtInfoHolder.BeaconKey.GAME_NAME, "game_icon", "game_detail_url", "game_download_url", "game_slogan", "game_download_total", "game_tag", "game_publish_type", "game_status", "developer_info", "game_version", "purview_info", "privacy_policy_url", "management_subject", "ios_pkg_size", "android_pkg_size", "pkg_name"}, new Object[]{"", "", "", "", "", 0, "", 0, 0, "", "", "", "", "", "", "", ""}, FeedCloudRead$StSearchGameDetail.class);
    public final PBStringField game_name = PBField.initString("");
    public final PBStringField game_icon = PBField.initString("");
    public final PBStringField game_detail_url = PBField.initString("");
    public final PBStringField game_download_url = PBField.initString("");
    public final PBStringField game_slogan = PBField.initString("");
    public final PBInt32Field game_download_total = PBField.initInt32(0);
    public final PBRepeatField<String> game_tag = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField game_publish_type = PBField.initEnum(0);
    public final PBEnumField game_status = PBField.initEnum(0);
    public final PBStringField developer_info = PBField.initString("");
    public final PBStringField game_version = PBField.initString("");
    public final PBStringField purview_info = PBField.initString("");
    public final PBStringField privacy_policy_url = PBField.initString("");
    public final PBStringField management_subject = PBField.initString("");
    public final PBStringField ios_pkg_size = PBField.initString("");
    public final PBStringField android_pkg_size = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
}
