package com.tencent.relation.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRelationNTUinAndUidApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface a {
        void a(HashMap<String, String> hashMap);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface b {
        void a(ArrayList<String> arrayList);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface c {
        void a(Map<String, String> map);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface d {
        void a(String str);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface e {
        void a(String str);
    }

    void fetchUid2UinMap(List<String> list, boolean z16, boolean z17, a aVar);

    void fetchUidFromUin(List<String> list, boolean z16, boolean z17, b bVar);

    void fetchUin2UidMap(List<String> list, boolean z16, boolean z17, c cVar);

    String getFriendUidFromUin(String str);

    String getFriendUinFromUid(String str);

    String getUidFromUin(String str);

    void getUidFromUin(String str, boolean z16, boolean z17, d dVar);

    String getUinFromUid(String str);

    void getUinFromUid(String str, boolean z16, boolean z17, e eVar);

    boolean isValidUin(String str);

    void saveUidByUin(String str, String str2);
}
