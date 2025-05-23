package com.tencent.mobileqq.guild.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildAtEvent extends SimpleBaseEvent {
    public List<IGProUserInfo> userInfo;

    public GuildAtEvent(List<IGProUserInfo> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.userInfo = arrayList;
        arrayList.addAll(list);
    }

    public String toString() {
        return "GuildAtEvent{, userInfo=" + this.userInfo + "} " + super.toString();
    }

    public GuildAtEvent(IGProUserInfo iGProUserInfo) {
        if (iGProUserInfo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.userInfo = arrayList;
        arrayList.add(iGProUserInfo);
    }
}
