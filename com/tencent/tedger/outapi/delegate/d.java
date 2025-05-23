package com.tencent.tedger.outapi.delegate;

import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
        void a(EdgeStatus edgeStatus, List<EdgeItem> list, Map<String, String> map);
    }

    EdgeStatus a(String str, EdgeAction edgeAction, List<EdgeItem> list);

    void b(String str, List<EdgeItem> list, Map<String, Object> map, a aVar);
}
