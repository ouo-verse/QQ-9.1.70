package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.guild.message.base.s;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import st1.d;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildMsgFactory extends IRuntimeService {
    s getMessageProcessor(int i3);

    d getMsgCache();
}
