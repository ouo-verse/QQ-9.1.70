package jc;

import com.qzone.business.share.ShareUtils;
import com.qzone.reborn.albumx.common.convert.bean.CommonStShare;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.util.ad;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import oo.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"Ljc/af;", "Ljc/ad;", "", "", "c", "Lic/c;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "p", "o", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class af extends ad {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"jc/af$b", "Loo/b$b;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "urlList", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements b.InterfaceC10931b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"jc/af$b$a", "Lcom/qzone/util/ad$a;", "", "url", "filePath", "", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes38.dex */
        public static final class a implements ad.a {
            a() {
            }

            @Override // com.qzone.util.ad.a
            public void a(String url, String filePath) {
                Intrinsics.checkNotNullParameter(url, "url");
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), filePath, com.qzone.util.image.c.i(filePath), 0);
            }

            @Override // com.qzone.util.ad.a
            public void b(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
            }
        }

        b() {
        }

        @Override // oo.b.InterfaceC10931b
        public void a(ArrayList<String> urlList) {
            Intrinsics.checkNotNullParameter(urlList, "urlList");
            com.qzone.util.ad.f59766a.d(urlList, new a());
        }
    }

    @Override // jc.ad
    public void o(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        RFWLayerPicInfo layerPicInfo = shareContext.getLayerItemInfo().getLayerPicInfo();
        String url = (layerPicInfo == null || (currentPicInfo = layerPicInfo.getCurrentPicInfo()) == null) ? null : currentPicInfo.getUrl();
        if (!(url == null || url.length() == 0) && oo.b.l() && !m(shareContext)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(url);
            oo.b.f(null, 1, arrayList, new b());
            return;
        }
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), shareContext.getExistSaveOrEditPath(), com.qzone.util.image.c.i(shareContext.getExistSaveOrEditPath()), 1);
    }

    @Override // jc.ad
    public void p(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        CommonStShare shareInfo;
        ShareUtils.g dVar;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QZAlbumxLayerExtraInfoBean extraInfoBean = shareContext.getExtraInfoBean();
        if (extraInfoBean == null || (shareInfo = extraInfoBean.getShareInfo()) == null) {
            return;
        }
        boolean a16 = ShareUtils.a(shareInfo.getCom.tencent.mobileqq.vas.webview.VasWebConstants.REPORT_ORIGIN java.lang.String().getWxMiniApp().getAppName(), shareInfo.getCom.tencent.mobileqq.vas.webview.VasWebConstants.REPORT_ORIGIN java.lang.String().getWxMiniApp().getPath());
        if (a16) {
            dVar = new ShareUtils.g();
        } else {
            dVar = new ShareUtils.d();
            dVar.f44744e = shareInfo.getCom.tencent.mobileqq.vas.webview.VasWebConstants.REPORT_ORIGIN java.lang.String().getWxMiniApp().getAppName();
            dVar.f44745f = shareInfo.getCom.tencent.mobileqq.vas.webview.VasWebConstants.REPORT_ORIGIN java.lang.String().getWxMiniApp().getPath();
            dVar.f44746g = "";
        }
        RFWLayerVideoInfo layerVideoInfo = shareContext.getLayerItemInfo().getLayerVideoInfo();
        dVar.f44743d = layerVideoInfo != null ? layerVideoInfo.getCurrentVideoUrl() : null;
        dVar.f44740a = shareInfo.getCom.tencent.mobileqq.vas.webview.VasWebConstants.REPORT_ORIGIN java.lang.String().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String();
        dVar.f44741b = shareContext.getExtraInfoBean().getAlbumName();
        dVar.f44742c = shareContext.getExtraInfoBean().getDesc();
        ShareUtils.r(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), 9, dVar, a16 ? 1 : 0);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(9);
        return listOf;
    }
}
