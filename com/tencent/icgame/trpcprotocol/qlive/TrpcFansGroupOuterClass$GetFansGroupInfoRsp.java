package com.tencent.icgame.trpcprotocol.qlive;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileVipReport;
import com.tencent.tuxmeterqui.config.TuxDialogBundleKey;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class TrpcFansGroupOuterClass$GetFansGroupInfoRsp extends MessageMicro<TrpcFansGroupOuterClass$GetFansGroupInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"retcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, ProfileVipReport.LEVEL_MODULE_ID, "group_info", TuxDialogBundleKey.WEB_URL}, new Object[]{0, "", null, null, ""}, TrpcFansGroupOuterClass$GetFansGroupInfoRsp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public TrpcFansGroupOuterClass$LevelInfo level_info = new TrpcFansGroupOuterClass$LevelInfo();
    public TrpcFansGroupOuterClass$FansGroupInfo group_info = new TrpcFansGroupOuterClass$FansGroupInfo();
    public final PBStringField web_url = PBField.initString("");
}
