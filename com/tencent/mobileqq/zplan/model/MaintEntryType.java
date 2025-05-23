package com.tencent.mobileqq.zplan.model;

import com.tencent.sqshow.zootopia.publish.page.samestyle.SameStyleContentPageFrom;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/MaintEntryType;", "", "mTypeKey", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMTypeKey", "()Ljava/lang/String;", "ALL", "COIN", "MALL", SameStyleContentPageFrom.FROM_SAME_STYLE, "MAKEUP", "AI_MAKEUP", "ACTIVITY_CENTRAL", "PLAYGROUND_GALLARY", "SMALL_HOME", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum MaintEntryType {
    ALL("zplanAll"),
    COIN("coin"),
    MALL("mall"),
    SAME_STYLE("samestyle"),
    MAKEUP(com.tencent.luggage.wxa.c8.c.N),
    AI_MAKEUP("aimakeup"),
    ACTIVITY_CENTRAL("activityCentral"),
    PLAYGROUND_GALLARY("playgroundGallery"),
    SMALL_HOME("projectg");


    @NotNull
    private final String mTypeKey;

    MaintEntryType(String str) {
        this.mTypeKey = str;
    }

    @NotNull
    public final String getMTypeKey() {
        return this.mTypeKey;
    }
}
