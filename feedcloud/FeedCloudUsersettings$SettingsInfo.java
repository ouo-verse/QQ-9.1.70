package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import cooperation.qqcircle.report.QCircleLpReportDc010001;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudUsersettings$SettingsInfo extends MessageMicro<FeedCloudUsersettings$SettingsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{QCircleLpReportDc010001.KEY_MAINTYPE, "bizData"}, new Object[]{0, ByteStringMicro.EMPTY}, FeedCloudUsersettings$SettingsInfo.class);
    public final PBEnumField mainType = PBField.initEnum(0);
    public final PBBytesField bizData = PBField.initBytes(ByteStringMicro.EMPTY);
}
