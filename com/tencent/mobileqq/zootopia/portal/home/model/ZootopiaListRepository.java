package com.tencent.mobileqq.zootopia.portal.home.model;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.service.ZootopiaMapListService;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zb3.ZootopiaMapListData;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/model/ZootopiaListRepository;", "Lcom/tencent/mobileqq/mvvm/a;", "Lcom/tencent/mobileqq/zootopia/b;", "Lzb3/i;", "callback", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "adId", "Lkotlin/Function1;", "Lzb3/c;", DomainData.DOMAIN_NAME, "Lcom/tencent/common/app/AppInterface;", "a", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapListService;", "c", "Lkotlin/Lazy;", "k", "()Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapListService;", "service", "<init>", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaListRepository extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AppInterface app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy service;

    public ZootopiaListRepository(AppInterface app, ZootopiaSource source) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(source, "source");
        this.app = app;
        this.source = source;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaMapListService>() { // from class: com.tencent.mobileqq.zootopia.portal.home.model.ZootopiaListRepository$service$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaMapListService invoke() {
                ZootopiaSource zootopiaSource;
                ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
                zootopiaSource = ZootopiaListRepository.this.source;
                return new ZootopiaMapListService(companion.j(zootopiaSource));
            }
        });
        this.service = lazy;
    }

    private final ZootopiaMapListService k() {
        return (ZootopiaMapListService) this.service.getValue();
    }

    public final void l(com.tencent.mobileqq.zootopia.b<ZootopiaMapListData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        k().f(this.app, callback);
    }

    public final void m(com.tencent.mobileqq.zootopia.b<ZootopiaMapListData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        k().e(this.app, callback);
    }

    public final void n(int adId, Function1<? super zb3.c, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ub3.d.h(ub3.d.f438772a, adId, callback, 0, 4, null);
    }
}
