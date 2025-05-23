package com.tencent.mobileqq.zootopia.portal.detail;

import com.tencent.mobileqq.zootopia.service.ZootopiaMapDetailService;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zb3.ZootopiaMapCommentResp;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J&\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0016R\u0017\u0010\u0011\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/ai;", "Lcom/tencent/mobileqq/mvvm/a;", "Lcom/tencent/mobileqq/zootopia/portal/detail/a;", "", "mapId", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/m;", "callback", "", "j", "count", "Lzb3/h;", "e", "a", "I", "getSource", "()I", "source", "Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapDetailService;", "b", "Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapDetailService;", "service", "<init>", "(I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ai extends com.tencent.mobileqq.mvvm.a implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaMapDetailService service;

    public ai(int i3) {
        this.source = i3;
        this.service = new ZootopiaMapDetailService(i3);
    }

    @Override // com.tencent.mobileqq.zootopia.portal.detail.a
    public void e(int mapId, int count, com.tencent.mobileqq.zootopia.api.e<ZootopiaMapCommentResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.i(mapId, count, callback);
    }

    public void j(int mapId, com.tencent.mobileqq.zootopia.api.e<ZootopiaMapDetail> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.j(mapId, callback);
    }
}
