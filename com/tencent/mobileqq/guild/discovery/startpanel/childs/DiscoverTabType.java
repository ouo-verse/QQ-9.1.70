package com.tencent.mobileqq.guild.discovery.startpanel.childs;

import com.tencent.lbssearch.object.result.DrivingResultObject;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "", "tabName", "", "tabType", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getTabName", "()Ljava/lang/String;", "getTabType", "()I", "DEFAULT", "ME", "HOT", DrivingResultObject.RECOMMEND, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public enum DiscoverTabType {
    DEFAULT("", 0),
    ME("\u6211\u7684", 1),
    HOT("\u70ed\u95e8", 2),
    RECOMMEND(QzoneConfig.DefaultValue.DEFAULT_DISCOVERY_TITLE, 3);


    @NotNull
    private final String tabName;
    private final int tabType;

    DiscoverTabType(String str, int i3) {
        this.tabName = str;
        this.tabType = i3;
    }

    @NotNull
    public final String getTabName() {
        return this.tabName;
    }

    public final int getTabType() {
        return this.tabType;
    }
}
