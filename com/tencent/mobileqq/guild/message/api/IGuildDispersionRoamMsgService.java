package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;
import st1.a;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildDispersionRoamMsgService extends IRuntimeService {
    boolean getDispersionRoamMsg(String str, String str2, List<Long> list, a aVar);
}
