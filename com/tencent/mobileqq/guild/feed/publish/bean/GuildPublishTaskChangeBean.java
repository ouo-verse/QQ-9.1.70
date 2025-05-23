package com.tencent.mobileqq.guild.feed.publish.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public class GuildPublishTaskChangeBean implements Serializable {
    private final List<String> currentShowMediaList = new ArrayList();
    private final List<String> deleteMediaList = new ArrayList();

    private String a(List<String> list) {
        StringBuilder sb5 = new StringBuilder();
        for (String str : list) {
            sb5.append("taskId=");
            sb5.append(str);
            sb5.append(", ");
        }
        return sb5.toString();
    }

    public List<String> getCurrentShowMediaList() {
        return this.currentShowMediaList;
    }

    public List<String> getDeleteMediaList() {
        return this.deleteMediaList;
    }

    public String toString() {
        return "GuildPublishTaskChangeBean{currentShowMediaList=[" + a(this.currentShowMediaList) + "], deleteMediaList=[" + a(this.deleteMediaList) + "]}";
    }
}
