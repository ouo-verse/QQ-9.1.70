package com.tencent.mobileqq.guild.temp.api;

import android.text.TextUtils;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes14.dex */
public class CombineGrayTipFilter {

    /* renamed from: a, reason: collision with root package name */
    private static final HashSet<Long> f235217a = new HashSet<Long>() { // from class: com.tencent.mobileqq.guild.temp.api.CombineGrayTipFilter.1
        {
            add(802L);
            add(803L);
        }
    };

    public static long a(MessageForUniteGrayTip messageForUniteGrayTip) {
        if (messageForUniteGrayTip == null) {
            return 0L;
        }
        String extInfoFromExtStr = messageForUniteGrayTip.getExtInfoFromExtStr(IGuildUniteGrayTipUtilApi.GUILD_UNITE_GRAYTIP_BUSI_ID);
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            return 0L;
        }
        return Long.parseLong(extInfoFromExtStr);
    }

    public static boolean b(MessageForUniteGrayTip messageForUniteGrayTip) {
        if (messageForUniteGrayTip == null) {
            return false;
        }
        return f235217a.contains(Long.valueOf(a(messageForUniteGrayTip)));
    }
}
