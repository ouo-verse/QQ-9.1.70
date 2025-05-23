package com.tencent.mobileqq.guild.media.pic.config.api.impl;

import com.tencent.mobileqq.guild.media.pic.config.api.IGuildDownRequest;
import com.tencent.mobileqq.pic.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildDownRequestImpl implements IGuildDownRequest {
    List<p> mGuildRequests;

    @Override // com.tencent.mobileqq.guild.media.pic.config.api.IGuildDownRequest
    public void clearRequest() {
        List<p> list = this.mGuildRequests;
        if (list == null) {
            return;
        }
        synchronized (list) {
            this.mGuildRequests.clear();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.pic.config.api.IGuildDownRequest
    public List<p> getRequest() {
        if (this.mGuildRequests == null) {
            this.mGuildRequests = Collections.synchronizedList(new LinkedList());
        }
        return this.mGuildRequests;
    }
}
