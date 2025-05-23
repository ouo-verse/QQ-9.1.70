package com.tencent.mobileqq.guild.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class z {

    /* renamed from: b, reason: collision with root package name */
    private static Bundle f235709b;

    /* renamed from: c, reason: collision with root package name */
    private static int f235710c;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f235711a;

    @Deprecated
    public z(IGProChannelInfo iGProChannelInfo, IGProGuildInfo iGProGuildInfo) {
        a(iGProChannelInfo);
    }

    private void a(IGProChannelInfo iGProChannelInfo) {
        int i3;
        HashMap<String, Object> hashMap = new HashMap<>();
        this.f235711a = hashMap;
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        GLiveChannelStartParams s16 = GLiveChannelCore.f226698a.s();
        int i16 = 2;
        if (s16.getAnchorIsSelf()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (!s16.isLiving()) {
            i16 = 1;
        }
        this.f235711a.put("sgrp_stream_status", Integer.valueOf(i16));
        this.f235711a.put("sgrp_stream_aio_type", Integer.valueOf(i3));
        this.f235711a.put("sgrp_stream_pgin_source", Integer.valueOf(f235710c));
        this.f235711a.put("sgrp_subchannel_session_id", s16.getLiveRoomProgramId());
        this.f235711a.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(s16.getGuildId())));
        this.f235711a.put("sgrp_sub_channel_id", s16.getChannelId());
        this.f235711a.put("sgrp_channel_id", s16.getGuildId());
        this.f235711a.put("sgrp_subchannel_type", 5);
        if (iGProChannelInfo != null) {
            this.f235711a.put("sgrp_sub_channel_limit", Integer.toString(iGProChannelInfo.getTalkPermission()));
            this.f235711a.put(QCircleDaTongConstant.ElementParamKey.SGRP_CHANNEL_NAME, iGProChannelInfo.getChannelName());
            this.f235711a.put("sgrp_channel_groupname", iGProChannelInfo.getCategoryName());
            this.f235711a.put("sgrp_announcement_state", Integer.valueOf(!iGProChannelInfo.getTopMsgList().isEmpty() ? 1 : 0));
        }
        GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) s16.getBundle().getParcelable("GuildAppReportSourceInfo");
        if (guildAppReportSourceInfo != null) {
            String str = guildAppReportSourceInfo.getReportInfoMap().get(JumpGuildParam.EXTRA_KEY_TRACE_ID);
            if (!TextUtils.isEmpty(str)) {
                this.f235711a.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, str);
            } else {
                QLog.w("QGL.GuildLiveDtUtil", 1, "createParams, traceId is null.");
            }
        } else {
            QLog.w("QGL.GuildLiveDtUtil", 1, "createParams, GuildAppReportSourceInfo is null.");
        }
        com.tencent.mobileqq.guild.data.w.b(this.f235711a);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setOpenGuildSourceParams(f235709b, this.f235711a);
        this.f235711a.putAll(com.tencent.mobileqq.guild.report.b.d());
    }

    public static void c(int i3) {
        com.tencent.mobileqq.guild.safety.j.d("GuildLiveDtUtil", "openLiveSource: " + i3);
        f235710c = i3;
    }

    public static void d(Bundle bundle) {
        f235709b = bundle;
    }

    public HashMap<String, Object> b() {
        return this.f235711a;
    }

    public z() {
        a(GLiveChannelCore.f226698a.s().getChannelInfo());
    }
}
