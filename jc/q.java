package jc;

import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.util.ad;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Ljc/q;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/c;", "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "k", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class q extends com.qzone.reborn.albumx.common.share.a<ic.c> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"jc/q$b", "Lcom/qzone/util/ad$a;", "", "url", "filePath", "", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements ad.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ic.c f409753a;

        b(ic.c cVar) {
            this.f409753a = cVar;
        }

        @Override // com.qzone.util.ad.a
        public void a(String url, String filePath) {
            Intrinsics.checkNotNullParameter(url, "url");
            boolean z16 = true;
            QLog.d("QZAlbumxDetailShareQzoneAction", 1, "doAction onLoadSucceed, url=" + url + ", filePath=" + filePath);
            if (this.f409753a.getLayerItemInfo().isVideo()) {
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
                qZonePublishMoodInitBean.i0(QZoneHelper.Constants.INTENT_ACTION_QZONE_OPEN_SHARE);
                qZonePublishMoodInitBean.B0(userInfo.qzone_uin);
                qZonePublishMoodInitBean.A0(userInfo.nickname);
                qZonePublishMoodInitBean.H0(5);
                qZonePublishMoodInitBean.p0(filePath);
                qZonePublishMoodInitBean.M0(HardCodeUtil.qqStr(R.string.rx9));
                qZonePublishMoodInitBean.w0(Boolean.FALSE);
                ho.g w3 = ho.i.w();
                Intrinsics.checkNotNullExpressionValue(w3, "publish()");
                ho.g.e(w3, this.f409753a.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), qZonePublishMoodInitBean, -1, null, 8, null);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            String existSaveOrEditPath = this.f409753a.getExistSaveOrEditPath();
            if (existSaveOrEditPath != null && existSaveOrEditPath.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                if (filePath == null) {
                    filePath = "";
                }
                arrayList.add(filePath);
            }
            QZonePublishMoodInitBean qZonePublishMoodInitBean2 = new QZonePublishMoodInitBean(System.currentTimeMillis());
            qZonePublishMoodInitBean2.t0(0);
            Boolean bool = Boolean.TRUE;
            qZonePublishMoodInitBean2.v0(bool);
            qZonePublishMoodInitBean2.x0(0);
            qZonePublishMoodInitBean2.y0(arrayList);
            qZonePublishMoodInitBean2.r0(bool);
            ho.i.w().c(this.f409753a.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), qZonePublishMoodInitBean2);
        }

        @Override // com.qzone.util.ad.a
        public void b(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            QLog.d("QZAlbumxDetailShareQzoneAction", 1, "doAction onLoadError, url=" + url);
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.FIRST;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        if (r5 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0027, code lost:
    
        if (r5 != null) goto L9;
     */
    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        String url;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        String str = "";
        if (shareContext.getLayerItemInfo().isVideo()) {
            RFWLayerVideoInfo layerVideoInfo = shareContext.getLayerItemInfo().getLayerVideoInfo();
            if (layerVideoInfo != null) {
                url = layerVideoInfo.getCurrentVideoUrl();
            }
        } else {
            RFWLayerPicInfo layerPicInfo = shareContext.getLayerItemInfo().getLayerPicInfo();
            if (layerPicInfo == null || (downloadPicInfo = layerPicInfo.getDownloadPicInfo()) == null || (url = downloadPicInfo.getUrl()) == null) {
                RFWLayerPicInfo layerPicInfo2 = shareContext.getLayerItemInfo().getLayerPicInfo();
                url = (layerPicInfo2 == null || (currentPicInfo = layerPicInfo2.getCurrentPicInfo()) == null) ? null : currentPicInfo.getUrl();
            }
            str = url;
        }
        QLog.d("QZAlbumxDetailShareQzoneAction", 1, "doAction, downloadUrl=" + str);
        com.qzone.util.ad adVar = com.qzone.util.ad.f59766a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        adVar.d(arrayList, new b(shareContext));
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(3);
        return arrayListOf;
    }
}
