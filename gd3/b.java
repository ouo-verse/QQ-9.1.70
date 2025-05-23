package gd3;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.service.ZootopiaNewParadiseService;
import com.tencent.sqshow.zootopia.data.ZootopiaMainRecommendListData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lgd3/b;", "Lcom/tencent/mobileqq/mvvm/a;", "", "", "param", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/k;", "callback", "", "j", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "a", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/mobileqq/zootopia/service/ZootopiaNewParadiseService;", "b", "Lcom/tencent/mobileqq/zootopia/service/ZootopiaNewParadiseService;", "service", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaNewParadiseService service;

    public b(ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.service = new ZootopiaNewParadiseService(ZootopiaSource.INSTANCE.j(source));
    }

    public void j(String param, e<ZootopiaMainRecommendListData> callback) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.h(param, callback);
    }
}
