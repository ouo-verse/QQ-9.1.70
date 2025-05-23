package jc;

import android.content.Intent;
import com.qzone.reborn.albumx.common.convert.bean.CommonStShare;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.util.ad;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import common.config.service.QZoneConfigHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0012"}, d2 = {"Ljc/ac;", "Ljc/ad;", "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lic/c;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "p", "o", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class ac extends ad {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"jc/ac$b", "Lcom/qzone/util/ad$a;", "", "url", "filePath", "", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements ad.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareActionSheetBuilder.ActionSheetItem f409730a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ic.c f409731b;

        b(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ic.c cVar) {
            this.f409730a = actionSheetItem;
            this.f409731b = cVar;
        }

        @Override // com.qzone.util.ad.a
        public void a(String url, String filePath) {
            Intrinsics.checkNotNullParameter(url, "url");
            QLog.d("QZAlbumxShareToMoreAndSpecifiedAction", 1, "doAction onLoadSucceed, url=" + url + ", filePath=" + filePath);
            Intent intent = new Intent();
            if (this.f409730a.action == 73) {
                intent.setClass(this.f409731b.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), ForwardRecentActivity.class);
                intent.putExtra("key_flag_from_plugin", true);
                if (QZoneConfigHelper.v()) {
                    intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
                    intent.putExtra("isFromShare", true);
                    intent.putExtra("sendMultiple", true);
                }
            } else {
                intent.setClass(this.f409731b.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), DirectForwardActivity.class);
                intent.putExtra("toUin", this.f409730a.uin.toString());
                intent.putExtra("uinType", this.f409730a.uinType);
                intent.putExtra("nickName", this.f409730a.label);
            }
            intent.putExtra("forward_type", 1);
            if (filePath == null) {
                filePath = "";
            }
            intent.putExtra(AppConstants.Key.FORWARD_THUMB, filePath);
            intent.putExtra("key_flag_from_plugin", true);
            this.f409731b.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().startActivityForResult(intent, 1000);
        }

        @Override // com.qzone.util.ad.a
        public void b(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            QLog.d("QZAlbumxShareToMoreAndSpecifiedAction", 1, "doAction onLoadError, url=" + url);
        }
    }

    @Override // jc.ad, com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.NONE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        if (r0 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0027, code lost:
    
        if (r0 != null) goto L9;
     */
    @Override // jc.ad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
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
        QLog.d("QZAlbumxShareToMoreAndSpecifiedAction", 1, "doAction, downloadUrl=" + str);
        com.qzone.util.ad adVar = com.qzone.util.ad.f59766a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        adVar.d(arrayList, new b(item, shareContext));
    }

    @Override // jc.ad
    public void p(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        CommonStShare shareInfo;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QZAlbumxLayerExtraInfoBean extraInfoBean = shareContext.getExtraInfoBean();
        if (extraInfoBean == null || (shareInfo = extraInfoBean.getShareInfo()) == null) {
            return;
        }
        Intent intent = new Intent(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), (Class<?>) DirectForwardActivity.class);
        l(shareContext, item, shareInfo, intent);
        intent.putExtra("toUin", item.uin);
        intent.putExtra("uinType", item.uinType);
        intent.putExtra("nickName", item.label);
        intent.putExtra("key_direct_show_uin_type", item.uinType);
        intent.putExtra("key_direct_show_uin", item.uin);
        shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().startActivity(intent);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{73, 72});
        return listOf;
    }
}
