package com.tencent.mobileqq.guild.message.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;
import tencent.im.group_pro_proto.common.common$Msg;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildFillMsgHoleService extends IRuntimeService {
    public static final int FROM_NONE = 0;
    public static final int FROM_OFFLINE_PUSH = 2;
    public static final int FROM_ONLINE_PUSH = 1;

    boolean checkNeedFillMsgHole(List<common$Msg> list, int i3, Bundle bundle);

    void handleFillMsgHoleResp(String str, boolean z16, List<common$Msg> list, Bundle bundle);
}
