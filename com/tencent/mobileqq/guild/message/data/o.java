package com.tencent.mobileqq.guild.message.data;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.GrayTipsMessageConstants$HighlightItem;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class o extends com.tencent.mobileqq.guild.message.base.n {

    /* renamed from: a, reason: collision with root package name */
    private static String f230377a = "GuildUniteGrayTipRedPacketClickHandler";

    @Override // com.tencent.mobileqq.guild.message.base.n
    public boolean a(AppRuntime appRuntime, Context context, GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem, Bundle bundle) {
        String str;
        if (grayTipsMessageConstants$HighlightItem.actionType != 3) {
            return false;
        }
        if (!TextUtils.isEmpty(grayTipsMessageConstants$HighlightItem.mMsgActionData) && !TextUtils.equals("null", grayTipsMessageConstants$HighlightItem.mMsgActionData)) {
            str = grayTipsMessageConstants$HighlightItem.mMsgActionData;
        } else {
            str = grayTipsMessageConstants$HighlightItem.mMsgAActionData;
        }
        if (TextUtils.isEmpty(str) || !str.startsWith(TenpayJumpActivity.TENPAY_SCHEME)) {
            return false;
        }
        QLog.d(f230377a, 2, "handleOnClick.  url = " + str);
        try {
            ax c16 = bi.c((QQAppInterface) appRuntime, context, str);
            if (c16 == null) {
                return false;
            }
            c16.r("grouptype", "11");
            c16.r("name", ((QQAppInterface) appRuntime).getCurrentNickname());
            c16.r("guild_id", bundle.getString("guild_id", ""));
            c16.r("sub_guild_id", bundle.getString("channelId", ""));
            c16.r("tinyid", ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId());
            c16.z();
            return c16.b();
        } catch (Exception e16) {
            QLog.e(f230377a, 1, e16.getMessage(), e16);
            return false;
        }
    }
}
