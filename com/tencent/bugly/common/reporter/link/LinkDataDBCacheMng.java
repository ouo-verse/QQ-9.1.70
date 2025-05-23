package com.tencent.bugly.common.reporter.link;

import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface LinkDataDBCacheMng {
    List<LinkData> loadFromDB(String str, String str2);

    boolean saveToDB(LinkData linkData);
}
