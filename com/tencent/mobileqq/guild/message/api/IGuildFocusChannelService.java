package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.guild.message.f;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashSet;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildFocusChannelService extends IRuntimeService {
    void addHugeChannel(HashSet<String> hashSet);

    void addHugeGuild(HashSet<String> hashSet);

    String getCurActiveChannelId();

    boolean isHugeChannel(String str);

    boolean isHugeGuild(String str);

    void removeHugeChannel(HashSet<String> hashSet);

    void removeHugeGuild(HashSet<String> hashSet);

    void reportGuildFocusInfo();

    void updateFocusChannel(f fVar);
}
