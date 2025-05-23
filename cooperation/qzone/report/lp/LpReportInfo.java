package cooperation.qzone.report.lp;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface LpReportInfo {
    public static final String KEY_NEW_FEED = "newfeed";
    public static final String KEY_NEW_LAYER = "newlayer";
    public static final int NEW_FEED_FALSE = 0;
    public static final int NEW_FEED_TRUE = 1;

    String getSimpleInfo();

    Map<String, String> toMap();
}
