package pd;

import android.app.Activity;
import android.content.Context;
import com.qzone.reborn.feedpro.banner.hotbanner.constant.FeedProHotBannerType;
import com.qzone.reborn.feedpro.banner.hotbanner.item.FeedProBaseHotBanner;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \b2\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\f\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001cR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001c\u00a8\u0006!"}, d2 = {"Lpd/a;", "Lnd/a;", "Lcom/qzone/reborn/feedpro/banner/hotbanner/item/FeedProBaseHotBanner;", "bannerToShow", "Lld/b;", "bannerData", "", "f", "e", "", "targetList", "newBanner", "c", "d", "Landroid/content/Context;", "context", "b", "Lcom/qzone/reborn/feedpro/banner/hotbanner/constant/FeedProHotBannerType;", WadlProxyConsts.BANNER_TYPE, "a", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lnd/b;", "Lnd/b;", "bannerPageIoc", "Ljava/util/List;", "normalBannerList", "residentBannerList", "<init>", "(Landroid/app/Activity;Lnd/b;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements nd.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final nd.b bannerPageIoc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<FeedProBaseHotBanner> normalBannerList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<FeedProBaseHotBanner> residentBannerList;

    public a(Activity activity, nd.b bannerPageIoc) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bannerPageIoc, "bannerPageIoc");
        this.activity = activity;
        this.bannerPageIoc = bannerPageIoc;
        this.normalBannerList = new CopyOnWriteArrayList();
        this.residentBannerList = new CopyOnWriteArrayList();
    }

    private final void d() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.residentBannerList);
        arrayList.addAll(this.normalBannerList);
        this.bannerPageIoc.J(arrayList);
    }

    private final void e(FeedProBaseHotBanner bannerToShow, ld.b bannerData) {
        c(this.normalBannerList, bannerToShow, bannerData);
    }

    private final void f(FeedProBaseHotBanner bannerToShow, ld.b bannerData) {
        c(this.residentBannerList, bannerToShow, bannerData);
    }

    @Override // nd.a
    public void a(FeedProHotBannerType bannerType) {
        List plus;
        Object obj;
        Intrinsics.checkNotNullParameter(bannerType, "bannerType");
        QLog.i("FeedProHotBannerManager", 1, "banner to hide type is " + bannerType.getBannerType());
        this.bannerPageIoc.c0();
        plus = CollectionsKt___CollectionsKt.plus((Collection) this.residentBannerList, (Iterable) this.normalBannerList);
        Iterator it = plus.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((FeedProBaseHotBanner) obj).n0() == bannerType) {
                    break;
                }
            }
        }
        FeedProBaseHotBanner feedProBaseHotBanner = (FeedProBaseHotBanner) obj;
        if (feedProBaseHotBanner != null) {
            if (feedProBaseHotBanner.r0()) {
                this.residentBannerList.remove(feedProBaseHotBanner);
                return;
            } else {
                this.normalBannerList.remove(feedProBaseHotBanner);
                return;
            }
        }
        QLog.e("FeedProHotBannerManager", 1, "cannot find banner to hide: type=" + bannerType);
    }

    @Override // nd.a
    public void b(ld.b bannerData, Context context) {
        Intrinsics.checkNotNullParameter(bannerData, "bannerData");
        FeedProBaseHotBanner f16 = b.INSTANCE.a().f(bannerData.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.BANNER_TYPE java.lang.String().getBannerType(), context);
        if (f16 == null) {
            QLog.e("FeedProHotBannerManager", 1, "banner to show is null, banner type is " + bannerData.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.BANNER_TYPE java.lang.String().getBannerType());
            return;
        }
        QLog.i("FeedProHotBannerManager", 1, "banner to show type is " + bannerData.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.BANNER_TYPE java.lang.String().getBannerType());
        if (f16.r0()) {
            f(f16, bannerData);
        } else {
            e(f16, bannerData);
        }
    }

    private final void c(List<FeedProBaseHotBanner> targetList, FeedProBaseHotBanner newBanner, ld.b bannerData) {
        Object obj;
        Iterator<T> it = targetList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int m06 = ((FeedProBaseHotBanner) next).m0();
                do {
                    Object next2 = it.next();
                    int m07 = ((FeedProBaseHotBanner) next2).m0();
                    if (m06 < m07) {
                        next = next2;
                        m06 = m07;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        FeedProBaseHotBanner feedProBaseHotBanner = (FeedProBaseHotBanner) obj;
        if (feedProBaseHotBanner == null) {
            newBanner.setData(bannerData);
            targetList.add(newBanner);
            d();
            QLog.i("FeedProHotBannerManager", 1, "new banner to show");
            return;
        }
        if (newBanner.m0() > feedProBaseHotBanner.m0()) {
            targetList.clear();
            newBanner.setData(bannerData);
            targetList.add(newBanner);
            d();
            QLog.i("FeedProHotBannerManager", 1, "replace banner to show");
            return;
        }
        if (newBanner.m0() == feedProBaseHotBanner.m0() && newBanner.n0() == feedProBaseHotBanner.n0()) {
            QLog.i("FeedProHotBannerManager", 1, "update current banner");
            feedProBaseHotBanner.setData(bannerData);
            return;
        }
        QLog.i("FeedProHotBannerManager", 1, "priority of banner to show is " + newBanner.m0() + ", lower than " + feedProBaseHotBanner.m0());
    }
}
