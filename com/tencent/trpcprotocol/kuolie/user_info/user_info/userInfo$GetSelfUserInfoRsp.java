package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$GetSelfUserInfoRsp extends MessageMicro<userInfo$GetSelfUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ITVKPlayerEventListener.KEY_USER_INFO}, new Object[]{null}, userInfo$GetSelfUserInfoRsp.class);
    public userInfo$MiniInfo userInfo = new userInfo$MiniInfo();
}
