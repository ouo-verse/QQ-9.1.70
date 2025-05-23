package com.tencent.mobileqq.guild.message.api;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.guild.data.l;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.group_pro_proto.msgpush.servtype$CommGrayTips;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildUniteGrayTipUtilApi extends QRouteApi {
    public static final String GUILD_CANCEL_TOP_MESSAGE = "660";
    public static final String GUILD_EMO_REPLAY = "emotionReply";
    public static final int GUILD_MSG_DECODE_APP = 1;
    public static final int GUILD_MSG_DECODE_MSGTIME = 2;
    public static final int GUILD_MSG_DECODE_ROAM = 3;
    public static final String GUILD_TOP_MESSAGE = "659";
    public static final String GUILD_UNITE_GRAYTIP_BUSI_ID = "guild_graytip_uint64_busi_id";
    public static final String GUILD_UNITE_GRAYTIP_BUSI_TYPE = "guild_graytip_uint64_busi_type";
    public static final String GUILD_UNITE_GRAYTIP_CONTENT = "guild_graytip_bytes_content";
    public static final String GUILD_UNITE_GRAYTIP_RESERVE_DATA = "guild_graytip_reserve_data";
    public static final String GUILD_UNITE_GRAYTIP_SEQ_ID = "guild_graytip_uint64_tips_seq_id";
    public static final String GUILD_UNITE_GRAYTIP_SUMMERY = "guild_graytip_summery";
    public static final String GUILD_UNITE_GRAYTIP_TEMPL_ID = "guild_graytip_uint64_templ_id";
    public static final String GUILD_UNITE_GRAYTIP_TEMPL_PARAM = "guild_graytip_rpt_msg_templ_param";
    public static final String ICON_TAG = "icon";

    MessageForUniteGrayTip createUniteGrayTip(AppRuntime appRuntime, String str, String str2, int i3, int i16, long j3, String str3);

    String getBusiId(MessageRecord messageRecord);

    String getBytesContent(MessageRecord messageRecord);

    SpannableStringBuilder getHighlightMsgText(l lVar);

    int getMsgType(int i3, boolean z16);

    String getTemplParamsJson(List<servtype$CommGrayTips.TemplParam> list);

    boolean isGrayTipMsg(MessageRecord messageRecord);

    UniteEntity parseXML(String str);

    void rebuildUniteTipsContent(AppRuntime appRuntime, MessageForUniteGrayTip messageForUniteGrayTip, boolean z16);
}
