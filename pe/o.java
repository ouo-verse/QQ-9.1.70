package pe;

import android.app.Activity;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.util.ad;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u001b"}, d2 = {"Lpe/o;", "Lcom/qzone/reborn/share/a;", "", "r", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lge/h;", "itemBean", "", ReportConstant.COSTREPORT_PREFIX, "t", "Lcom/qzone/reborn/share/e;", "shareContext", "j", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "i", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "c", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class o extends com.qzone.reborn.share.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"pe/o$b", "Lcom/qzone/util/ad$a;", "", "url", "filePath", "", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements ad.a {
        b() {
        }

        @Override // com.qzone.util.ad.a
        public void a(String url, String filePath) {
            Intrinsics.checkNotNullParameter(url, "url");
            boolean z16 = true;
            QLog.d("QzoneFeedProLayerShareWXAction", 1, "doAction onLoadSucceed, url=" + url + ", filePath=" + filePath);
            if (filePath != null && filePath.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), filePath, com.qzone.util.image.c.i(filePath), 0);
        }

        @Override // com.qzone.util.ad.a
        public void b(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            QLog.d("QzoneFeedProLayerShareWXAction", 1, "doAction onLoadError, url=" + url);
        }
    }

    private final boolean r() {
        return true;
    }

    private final void s(Activity activity, ge.h itemBean) {
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
        QLog.d("QzoneFeedProLayerShareWXAction", 1, "doAction, downloadUrl=" + url);
        if (url.length() == 0) {
            return;
        }
        ad adVar = ad.f59766a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(url);
        adVar.d(arrayList, new b());
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        RFWLayerItemMediaInfo mediaInfo;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        Object data = shareContext.getData();
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qzone.reborn.feedpro.layer.bean.QzoneFeedProLayerShareBean");
        ge.h hVar = (ge.h) data;
        ge.i defaultItemBean = hVar.getDefaultItemBean();
        boolean z16 = false;
        if (defaultItemBean != null && (mediaInfo = defaultItemBean.getMediaInfo()) != null && mediaInfo.isVideo()) {
            z16 = true;
        }
        if (z16) {
            t(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), hVar);
        } else {
            s(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), hVar);
        }
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.FIRST;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("weixincircle");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean i(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return false;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return r();
    }

    private final void t(Activity activity, ge.h itemBean) {
    }
}
