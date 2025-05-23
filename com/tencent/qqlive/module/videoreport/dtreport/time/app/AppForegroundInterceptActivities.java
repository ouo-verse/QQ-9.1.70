package com.tencent.qqlive.module.videoreport.dtreport.time.app;

import android.app.Activity;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AppForegroundInterceptActivities {
    private static final String ACTIVITIES_DELIMITER = ",";
    private LinkedHashSet<String> mInterceptActivitiesSet = new LinkedHashSet<>();

    private String join(Collection collection, String str) {
        StringBuilder sb5 = new StringBuilder();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (sb5.length() != 0) {
                sb5.append(str);
            }
            sb5.append(str2);
        }
        return sb5.toString();
    }

    public void clear() {
        this.mInterceptActivitiesSet.clear();
    }

    public String get() {
        return join(this.mInterceptActivitiesSet, ",");
    }

    public void onIntercept(Activity activity) {
        if (activity == null) {
            return;
        }
        this.mInterceptActivitiesSet.add(activity.getClass().getCanonicalName());
    }
}
