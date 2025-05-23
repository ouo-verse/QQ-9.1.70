package pe;

import com.qzone.reborn.feedpro.utils.a;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lpe/l;", "Lcom/qzone/reborn/share/a;", "Lcom/qzone/reborn/share/e;", "shareContext", "", "j", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "<init>", "()V", "c", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class l extends com.qzone.reborn.share.a {
    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QzoneFeedProLayerShareReportAction", 1, "share clicked");
        if (!NetworkState.isNetSupport()) {
            QQToastUtil.showQQToastInUiThread(4, BaseApplication.getContext().getString(R.string.ghi));
            return;
        }
        ge.h c16 = shareContext.c();
        CommonFeed commonFeed = c16 != null ? c16.getCom.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.FEED_INFO java.lang.String() : null;
        if (commonFeed == null) {
            QLog.i("QzoneFeedProLayerShareReportAction", 1, "doAction feedInfo is null");
            return;
        }
        a.Companion companion = com.qzone.reborn.feedpro.utils.a.INSTANCE;
        com.tencent.mobileqq.dt.api.b g16 = companion.g();
        companion.d(g16, commonFeed);
        companion.a(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), g16);
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("report_abuse");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ge.h c16 = shareContext.c();
        CommonFeed commonFeed = c16 != null ? c16.getCom.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.FEED_INFO java.lang.String() : null;
        if (commonFeed != null) {
            return !xd.c.u(commonFeed);
        }
        QLog.i("QzoneFeedProLayerShareReportAction", 2, "needShowItem feedInfo is null");
        return false;
    }
}
