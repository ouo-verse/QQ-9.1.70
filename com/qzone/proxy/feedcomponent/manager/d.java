package com.qzone.proxy.feedcomponent.manager;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface d {
    void close();

    void l(BusinessFeedData businessFeedData, String str, boolean z16);

    void notify(int i3, Object... objArr);

    void o(long j3, long j16);

    void p(c cVar);

    BusinessFeedData queryWithMem(String str, String str2, String str3);

    void u(String str, String[] strArr, boolean z16);

    void w(BusinessFeedData businessFeedData);

    void z(String str, boolean z16);
}
