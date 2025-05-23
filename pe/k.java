package pe;

import android.app.Activity;
import android.content.Intent;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.util.ad;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import common.config.service.QZoneConfigHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J0\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\u001f"}, d2 = {"Lpe/k;", "Lcom/qzone/reborn/share/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lge/h;", "itemBean", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", "", "r", ReportConstant.COSTREPORT_PREFIX, "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/e;", "shareContext", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", "", DomainData.DOMAIN_NAME, "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "c", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k extends com.qzone.reborn.share.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"pe/k$b", "Lcom/qzone/util/ad$a;", "", "url", "filePath", "", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements ad.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f425983a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.sharepanel.m f425984b;

        b(Activity activity, com.tencent.mobileqq.sharepanel.m mVar) {
            this.f425983a = activity;
            this.f425984b = mVar;
        }

        @Override // com.qzone.util.ad.a
        public void a(String url, String filePath) {
            Intrinsics.checkNotNullParameter(url, "url");
            QLog.d("QzoneFeedProLayerShareRecentAndMoreQQAction", 1, "doAction onLoadSucceed, url=" + url + ", filePath=" + filePath);
            Intent intent = new Intent();
            intent.setClass(this.f425983a, ForwardRecentActivity.class);
            intent.putExtra("forward_type", 1);
            if (filePath == null) {
                filePath = "";
            }
            intent.putExtra(AppConstants.Key.FORWARD_THUMB, filePath);
            intent.putExtra("key_flag_from_plugin", true);
            if (QZoneConfigHelper.v()) {
                intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
                intent.putExtra("isFromShare", true);
                intent.putExtra("sendMultiple", true);
            }
            this.f425984b.a(intent);
        }

        @Override // com.qzone.util.ad.a
        public void b(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            QLog.d("QzoneFeedProLayerShareRecentAndMoreQQAction", 1, "doAction onLoadError, url=" + url);
            this.f425984b.onFail();
        }
    }

    private final void r(Activity activity, ge.h itemBean, com.tencent.mobileqq.sharepanel.m callback) {
        String url;
        RFWLayerItemMediaInfo mediaInfo;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        RFWLayerItemMediaInfo mediaInfo2;
        RFWLayerPicInfo layerPicInfo2;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo;
        ge.i defaultItemBean = itemBean.getDefaultItemBean();
        if (defaultItemBean == null || (mediaInfo2 = defaultItemBean.getMediaInfo()) == null || (layerPicInfo2 = mediaInfo2.getLayerPicInfo()) == null || (downloadPicInfo = layerPicInfo2.getDownloadPicInfo()) == null || (url = downloadPicInfo.getUrl()) == null) {
            ge.i defaultItemBean2 = itemBean.getDefaultItemBean();
            url = (defaultItemBean2 == null || (mediaInfo = defaultItemBean2.getMediaInfo()) == null || (layerPicInfo = mediaInfo.getLayerPicInfo()) == null || (currentPicInfo = layerPicInfo.getCurrentPicInfo()) == null) ? null : currentPicInfo.getUrl();
            if (url == null) {
                url = "";
            }
        }
        QLog.d("QzoneFeedProLayerShareRecentAndMoreQQAction", 1, "doAction, downloadUrl=" + url);
        if (url.length() == 0) {
            callback.onFail();
            return;
        }
        ad adVar = ad.f59766a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(url);
        adVar.d(arrayList, new b(activity, callback));
    }

    private final void s(Activity activity, ge.h itemBean, com.tencent.mobileqq.sharepanel.m callback) {
        callback.onFail();
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QzoneFeedProLayerShareRecentAndMoreQQAction", 2, "share clicked");
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SPECIFIED;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(RecentUser.TABLE_NAME);
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean n(com.qzone.reborn.share.e shareContext, ArrayList<ResultRecord> targetList, com.tencent.mobileqq.sharepanel.m callback) {
        RFWLayerItemMediaInfo mediaInfo;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Object data = shareContext.getData();
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qzone.reborn.feedpro.layer.bean.QzoneFeedProLayerShareBean");
        ge.h hVar = (ge.h) data;
        ge.i defaultItemBean = hVar.getDefaultItemBean();
        boolean z16 = false;
        if (defaultItemBean != null && (mediaInfo = defaultItemBean.getMediaInfo()) != null && mediaInfo.isVideo()) {
            z16 = true;
        }
        if (z16) {
            s(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), hVar, callback);
        } else {
            r(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), hVar, callback);
        }
        return true;
    }
}
