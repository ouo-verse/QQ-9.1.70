package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;

/* loaded from: classes13.dex */
public class GuildOnPhotoSelectedEvent extends SimpleBaseEvent {
    public List<LocalMediaInfo> localMediaInfos;
    public final boolean originalPic;

    public GuildOnPhotoSelectedEvent(List<LocalMediaInfo> list, boolean z16) {
        this.localMediaInfos = list;
        this.originalPic = z16;
    }

    public String toString() {
        return "GuildOnPhotoSelectedEvent{localMediaInfos=" + this.localMediaInfos + "} " + super.toString();
    }
}
