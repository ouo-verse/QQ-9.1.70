package com.tencent.biz.pubaccount.weishi.recommend;

import UserGrowth.stGlobalConfig;
import UserGrowth.stNotificationRsp;
import UserGrowth.stSimpleMetaFeed;
import java.util.List;
import mz.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface e extends v00.b<List<stSimpleMetaFeed>> {
    void C();

    boolean D();

    void D7(List<stSimpleMetaFeed> list, boolean z16);

    void G7(boolean z16);

    void Ic(stNotificationRsp stnotificationrsp, com.tencent.biz.pubaccount.weishi.net.d dVar);

    String Id();

    void Jg();

    void L8(boolean z16, boolean z17);

    void M6();

    void N6();

    boolean U9();

    void We(String str);

    void Za(boolean z16);

    void b1(stGlobalConfig stglobalconfig);

    void c(List<stSimpleMetaFeed> list);

    int e5();

    List<stSimpleMetaFeed> getDataList();

    void h7();

    void ub(g gVar, boolean z16);
}
