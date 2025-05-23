package pe;

import android.text.TextUtils;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lpe/b;", "Lcom/qzone/reborn/share/a;", "Lcom/qzone/reborn/share/e;", "shareContext", "", "j", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "<init>", "()V", "c", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends com.qzone.reborn.share.a {
    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo;
        ge.i defaultItemBean;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        ge.h c16 = shareContext.c();
        String str = null;
        RFWLayerItemMediaInfo mediaInfo = (c16 == null || (defaultItemBean = c16.getDefaultItemBean()) == null) ? null : defaultItemBean.getMediaInfo();
        if (mediaInfo == null) {
            QLog.i("QzoneFeedProLayerShareCoverAction", 1, "doAction media is null");
            return;
        }
        RFWLayerPicInfo layerPicInfo = mediaInfo.getLayerPicInfo();
        String url = (layerPicInfo == null || (bigPicInfo = layerPicInfo.getBigPicInfo()) == null) ? null : bigPicInfo.getUrl();
        if (TextUtils.isEmpty(url)) {
            RFWLayerPicInfo layerPicInfo2 = mediaInfo.getLayerPicInfo();
            url = (layerPicInfo2 == null || (originPicInfo = layerPicInfo2.getOriginPicInfo()) == null) ? null : originPicInfo.getUrl();
        }
        if (TextUtils.isEmpty(url)) {
            RFWLayerPicInfo layerPicInfo3 = mediaInfo.getLayerPicInfo();
            if (layerPicInfo3 != null && (currentPicInfo = layerPicInfo3.getCurrentPicInfo()) != null) {
                str = currentPicInfo.getUrl();
            }
            url = str;
        }
        QLog.i("QzoneFeedProLayerShareCoverAction", 1, "doAction share clicked url:" + url);
        vo.c.D(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), url);
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("set_background");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean j(com.qzone.reborn.share.e shareContext) {
        ge.i defaultItemBean;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ge.h c16 = shareContext.c();
        if (((c16 == null || (defaultItemBean = c16.getDefaultItemBean()) == null) ? null : defaultItemBean.getMediaInfo()) == null) {
            QLog.i("QzoneFeedProLayerShareCoverAction", 2, "needShowItem media is null");
            return false;
        }
        return !r3.isVideo();
    }
}
