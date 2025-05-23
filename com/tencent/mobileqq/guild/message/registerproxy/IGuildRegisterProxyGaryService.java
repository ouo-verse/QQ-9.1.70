package com.tencent.mobileqq.guild.message.registerproxy;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildRegisterProxyGaryService extends IRuntimeService {
    boolean getShowGuildTab();
}
