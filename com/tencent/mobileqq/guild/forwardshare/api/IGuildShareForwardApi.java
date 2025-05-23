package com.tencent.mobileqq.guild.forwardshare.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes13.dex */
public interface IGuildShareForwardApi extends IRuntimeService {
    public static final String GUILD_SHARE_URL = "detail_url";
    public static final String SHARE_LEAVE_MESSAGE = "share_leave_message";

    void ShareForwardMsg(String str, String str2, Bundle bundle);
}
