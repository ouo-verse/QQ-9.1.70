package NS_MINI_SHARE;

import NS_COMM.COMM;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class MiniProgramShare$StAdaptShareInfoReq extends MessageMicro<MiniProgramShare$StAdaptShareInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 64, 74, 82, 90, 98, 104, 112, 122, 128, 138, 146, 154, 162, 168, 176}, new String[]{"extInfo", "appid", "title", "desc", "time", "scene", "templetType", "businessType", "picUrl", "vidUrl", WadlProxyConsts.KEY_JUMP_URL, "iconUrl", "verType", "shareType", "versionId", "withShareTicket", "webURL", "appidRich", "template", "rcvOpenId", "usingComponentArk", TtmlNode.ATTR_TTS_ORIGIN}, new Object[]{null, "", "", "", 0, 0, 0, 0, "", "", "", "", 0, 0, "", 0, "", "", null, "", Boolean.FALSE, 0}, MiniProgramShare$StAdaptShareInfoReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field time = PBField.initUInt32(0);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBEnumField templetType = PBField.initEnum(0);
    public final PBEnumField businessType = PBField.initEnum(0);
    public final PBStringField picUrl = PBField.initString("");
    public final PBStringField vidUrl = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField iconUrl = PBField.initString("");
    public final PBEnumField verType = PBField.initEnum(0);
    public final PBInt32Field shareType = PBField.initInt32(0);
    public final PBStringField versionId = PBField.initString("");
    public final PBInt32Field withShareTicket = PBField.initInt32(0);
    public final PBStringField webURL = PBField.initString("");
    public final PBStringField appidRich = PBField.initString("");
    public MiniProgramShare$StTemplateInfo template = new MiniProgramShare$StTemplateInfo();
    public final PBStringField rcvOpenId = PBField.initString("");
    public final PBBoolField usingComponentArk = PBField.initBool(false);
    public final PBEnumField origin = PBField.initEnum(0);
}
