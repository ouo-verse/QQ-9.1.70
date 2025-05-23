package lg;

import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Llg/e;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Lcom/qzone/business/favorite/service/QzoneFavoriteService$d;", "listener", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f414458a = new e();

    e() {
    }

    public final void a(BusinessFeedData feedData, QzoneFavoriteService.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!com.qzone.reborn.configx.g.f53821a.b().e0() || feedData == null || feedData.getFeedCommInfo() == null) {
            return;
        }
        QzoneFavoriteService.M().S(listener, feedData.getFeedCommInfo().ugckey);
    }
}
