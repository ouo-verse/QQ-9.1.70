package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.guild.api.IGuildAddQQFriendApi;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.message.api.IDirectMessageNode;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildAddQQFriendApiImpl implements IGuildAddQQFriendApi {
    public static final int APP_CHANNEL_QQ_FRIEND = 1;
    public static final int DEFAULT_INT_VALUE = 0;
    public static final int MAIN_SOURCE_QQ_FRIEND = 1;
    public static final int SUB_SOURCE_APPLY = 1;
    public static final String TAG = "GuildAddQQFriendApiImpl";
    public static HashMap<Integer, String> mainSourceMap = new HashMap<>();
    public static HashMap<Integer, String> subSourceMap = new HashMap<>();
    public static HashMap<Integer, String> appChannelMap = new HashMap<>();

    static {
        subSourceMap.put(0, "default");
        mainSourceMap.put(0, "default");
        appChannelMap.put(0, "default");
        subSourceMap.put(1, "apply");
        mainSourceMap.put(1, "qq_friend");
        appChannelMap.put(1, "qq_friend");
    }

    private boolean isValid(String str, String str2, String str3) {
        if (!nullOrDefault(str) && !nullOrDefault(str2) && !nullOrDefault(str3)) {
            return true;
        }
        Log.d(TAG, "jumpToGuild Fail, subSource = " + str + ", mainSource = " + str2 + ", appChannel = " + str3);
        return false;
    }

    private boolean nullOrDefault(String str) {
        if (str != null && !"default".equals(str)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAddQQFriendApi
    public boolean isFromGuild(int i3, int i16) {
        if (i3 != 3912 && i3 != 2912) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAddQQFriendApi
    public boolean jumpToGuild(Context context, String str) {
        String[] split;
        if (str != null && (split = str.split(ContainerUtils.FIELD_DELIMITER)) != null && split.length > 6) {
            String str2 = split[0];
            String str3 = subSourceMap.get(Integer.valueOf(Integer.parseInt(split[1])));
            String str4 = mainSourceMap.get(Integer.valueOf(Integer.parseInt(split[2])));
            String str5 = appChannelMap.get(Integer.valueOf(Integer.parseInt(split[3])));
            String str6 = split[5];
            if (!isValid(str3, str4, str5) || TextUtils.isEmpty(str6)) {
                return false;
            }
            String messageSourceGuildIdByGuildId = ((IDirectMessageNode) QRoute.api(IDirectMessageNode.class)).getMessageSourceGuildIdByGuildId(str6);
            if (!TextUtils.isEmpty(messageSourceGuildIdByGuildId)) {
                str6 = messageSourceGuildIdByGuildId;
            }
            JumpGuildParam jumpGuildParam = new JumpGuildParam(str6, "");
            jumpGuildParam.setJoinInfoParam(new JumpGuildParam.JoinInfoParam("", str2, str4, str3));
            jumpGuildParam.extras.putString("PGIN_SOURCE_REPORT_KEY", "qq_friend");
            GuildJumpUtil.n(context, jumpGuildParam);
        }
        return true;
    }
}
