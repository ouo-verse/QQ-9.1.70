package com.tencent.mobileqq.zootopia.portal.detail;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zb3.ZootopiaRankHeadNickData;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ6\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J*\u0010\u0011\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000e0\tH\u0016R\u0017\u0010\u0016\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/ao;", "Lcom/tencent/mobileqq/mvvm/a;", "", "", "mapId", "rankId", "showSwitch", "", "clientKey", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzb3/k;", "callback", "", "j", "", "openIdList", "Lzb3/l;", "k", "a", "I", "getSource", "()I", "source", "Lcom/tencent/mobileqq/zootopia/service/f;", "b", "Lcom/tencent/mobileqq/zootopia/service/f;", "service", "<init>", "(I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ao extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.service.f service;

    public ao(int i3) {
        this.source = i3;
        this.service = new com.tencent.mobileqq.zootopia.service.f(i3);
    }

    public void j(int mapId, int rankId, int showSwitch, String clientKey, com.tencent.mobileqq.zootopia.api.e<zb3.k> callback) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.l(mapId, rankId, showSwitch, clientKey, callback);
    }

    public void k(List<String> openIdList, com.tencent.mobileqq.zootopia.api.e<List<ZootopiaRankHeadNickData>> callback) {
        Intrinsics.checkNotNullParameter(openIdList, "openIdList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.j(openIdList, callback);
    }
}
