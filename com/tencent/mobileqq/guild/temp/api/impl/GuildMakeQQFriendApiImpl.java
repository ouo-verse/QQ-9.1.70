package com.tencent.mobileqq.guild.temp.api.impl;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.guild.temp.api.IGuildMakeQQFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildMakeQQFriendApiImpl implements IGuildMakeQQFriendApi {
    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMakeQQFriendApi
    public void makeQQFriend(Context context, IGuildMakeQQFriendApi.a aVar) {
        if (context == null) {
            QLog.w(IGuildMakeQQFriendApi.TAG, 1, "makeQQFriend error for context is null");
            return;
        }
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(context, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(context, 3, aVar.f235226i, String.valueOf(IGuildMakeQQFriendApi.APP_ID), 3912, 3, aVar.f235228k, String.format(context.getResources().getString(R.string.f132493k), aVar.f235224g, aVar.f235227j), aVar.a()));
        HashMap hashMap = new HashMap();
        hashMap.put("to_openid", aVar.f235226i);
        hashMap.put("sgrp_channel_id", aVar.f235223f);
        hashMap.put("sgrp_scene_id", Integer.valueOf(aVar.f235229l));
        hashMap.put("sgrp_stream_pgin_source_name", com.tencent.mobileqq.guild.report.b.c());
        hashMap.put("sgrp_session_id", com.tencent.mobileqq.guild.report.b.e());
        hashMap.put("sgrp_visit_from", com.tencent.mobileqq.guild.report.b.f());
        VideoReport.reportEvent("ev_sgrp_add_addfriend_jump", hashMap);
    }
}
