package com.tencent.mobileqq.guild.message.data;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.data.GrayTipsMessageConstants$HighlightItem;
import com.tencent.mobileqq.guild.message.api.IDirectMessageNode;
import com.tencent.mobileqq.guild.temp.api.IGuildMakeQQFriendApi;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class n extends com.tencent.mobileqq.guild.message.base.n {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(String str, String str2, String str3, String str4, String str5, Context context, int i3, String str6, String str7, String str8, String str9) {
        if (i3 != 0) {
            QLog.w("GuildUniteGrayTipAddQQFriendClickHandler", 1, "fetchAddGuildInfo error, guildId:" + str + " errMsg:" + str6);
            return;
        }
        IGuildMakeQQFriendApi.a aVar = new IGuildMakeQQFriendApi.a();
        aVar.f235218a = str9;
        aVar.f235219b = "1";
        aVar.f235220c = "1";
        aVar.f235221d = "1";
        aVar.f235222e = 2;
        aVar.f235223f = str;
        aVar.f235224g = str2;
        aVar.f235225h = 2;
        aVar.f235226i = str3;
        aVar.f235227j = str4;
        aVar.f235228k = str5;
        aVar.f235229l = 1;
        ((IGuildMakeQQFriendApi) QRoute.api(IGuildMakeQQFriendApi.class)).makeQQFriend(context, aVar);
    }

    @Override // com.tencent.mobileqq.guild.message.base.n
    public boolean a(AppRuntime appRuntime, final Context context, GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem, Bundle bundle) {
        String str = grayTipsMessageConstants$HighlightItem.mMsgActionData;
        if (str != null && str.startsWith("mqqapi://guild/add_friend") && grayTipsMessageConstants$HighlightItem.mMsgAActionData != null) {
            QLog.d("GuildUniteGrayTipAddQQFriendClickHandler", 2, "handleOnClick.  url = " + str);
            String[] split = grayTipsMessageConstants$HighlightItem.mMsgAActionData.split(ContainerUtils.FIELD_DELIMITER);
            if (split != null && split.length >= 3) {
                final String str2 = split[0];
                String str3 = split[1];
                String str4 = split[2];
                final String srcGuildName = ((IDirectMessageNode) QRoute.api(IDirectMessageNode.class)).getSrcGuildName(str3);
                final String remarkName = ((IDirectMessageNode) QRoute.api(IDirectMessageNode.class)).getRemarkName(str3);
                final String srcGuildId = ((IDirectMessageNode) QRoute.api(IDirectMessageNode.class)).getSrcGuildId(str3);
                IGPSService iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "");
                final String guildUserDisplayName = iGPSService.getGuildUserDisplayName(srcGuildId, iGPSService.getSelfTinyId());
                iGPSService.fetchAddGuildInfo(1, az.d(srcGuildId, 0L), new wh2.a() { // from class: com.tencent.mobileqq.guild.message.data.m
                    @Override // wh2.a
                    public final void onResult(int i3, String str5, String str6, String str7, String str8) {
                        n.c(srcGuildId, srcGuildName, str2, guildUserDisplayName, remarkName, context, i3, str5, str6, str7, str8);
                    }
                });
            }
        }
        return false;
    }
}
