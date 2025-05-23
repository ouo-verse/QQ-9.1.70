package fb4;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsListData;
import iw4.j;
import iw4.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yb4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b \u0010!J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J \u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0016J&\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H\u0016R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lfb4/a;", "Lcom/tencent/mobileqq/mvvm/a;", "", "", "workId", "feedId", "uin", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/h;", "callback", "", "j", "", "pageInfo", "k", "id", "Liw4/l;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "Liw4/j;", "l", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "a", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lyb4/f;", "b", "Lyb4/f;", "service", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final f service;

    public a(ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.service = new f(ZootopiaSource.INSTANCE.j(source));
    }

    public void j(String workId, String feedId, String uin, e<ZootopiaDetailFeedsListData> callback) {
        Intrinsics.checkNotNullParameter(workId, "workId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.e(workId, feedId, uin, callback);
    }

    public void k(byte[] pageInfo, e<ZootopiaDetailFeedsListData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.f(pageInfo, callback);
    }

    public void l(String id5, int showType, e<j> callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.g(id5, showType, callback);
    }

    public void m(String id5, e<l> callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.h(id5, callback);
    }
}
