package jc;

import com.qzone.business.share.ShareUtils;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Ljc/l;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/b;", "shareContext", "", "l", "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "k", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class l extends com.qzone.reborn.albumx.common.share.a<ic.b> {
    private final void l(ic.b shareContext) {
        ShareUtils.g gVar = new ShareUtils.g();
        gVar.f44741b = shareContext.getRsp().getShareInfo().getTitle();
        gVar.f44742c = shareContext.getRsp().getShareInfo().getSummary();
        CommonStPicUrl f16 = k9.a.f(shareContext.getRsp().getAlbumInfo());
        String str = null;
        String url = f16 != null ? f16.getUrl() : null;
        if (url == null || url.length() == 0) {
            str = k9.a.e(shareContext.getRsp().getAlbumInfo().getCover(), 0, 1, null);
        } else {
            CommonStPicUrl f17 = k9.a.f(shareContext.getRsp().getAlbumInfo());
            if (f17 != null) {
                str = f17.getUrl();
            }
        }
        gVar.f44743d = str;
        gVar.f44740a = shareContext.getRsp().getShareInfo().getCom.tencent.mobileqq.vas.webview.VasWebConstants.REPORT_ORIGIN java.lang.String().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String();
        gVar.f44744e = shareContext.getRsp().getShareInfo().getCom.tencent.mobileqq.vas.webview.VasWebConstants.REPORT_ORIGIN java.lang.String().getWxMiniApp().getAppName();
        gVar.f44745f = shareContext.getRsp().getShareInfo().getCom.tencent.mobileqq.vas.webview.VasWebConstants.REPORT_ORIGIN java.lang.String().getWxMiniApp().getPath();
        gVar.f44746g = shareContext.getRsp().getShareInfo().getShareKey();
        ShareUtils.r(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), 10, gVar, 1);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.FIRST;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void a(ic.b shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QZAlbumxDetailShareWXFriendsAction", 2, "share clicked");
        if (shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String() == null) {
            QLog.e("QZAlbumxDetailShareWXFriendsAction", 1, "doAction activity null");
        } else {
            l(shareContext);
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(10);
        return arrayListOf;
    }
}
