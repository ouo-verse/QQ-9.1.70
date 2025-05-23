package jc;

import android.content.Intent;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Ljc/i;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/b;", "Lnc/u;", "l", "shareContext", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "k", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "intent", tl.h.F, "e", "Lic/b;", "getContext", "()Lic/b;", "setContext", "(Lic/b;)V", "context", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i extends com.qzone.reborn.albumx.common.share.a<ic.b> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ic.b context;

    private final nc.u l() {
        ViewModel viewModel = getViewModel();
        if (viewModel instanceof nc.u) {
            return (nc.u) viewModel;
        }
        return null;
    }

    private final void m(ic.b shareContext) {
        if (shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String() != null && shareContext.getRsp() != null) {
            this.context = shareContext;
            ho.i.c().q(new QZoneCommentPanelParams.a().y(1003).q(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getString(R.string.glb)).getParams(), shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), shareContext.getRsp().getAlbumInfo());
            return;
        }
        QZLog.d("QZAlbumxDetailShareQzoneAction", 2, "activity is recycled or rsp is null");
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.FIRST;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public void h(int requestCode, int resultCode, Intent intent) {
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean;
        nc.u l3;
        xa.c rsp;
        CommonAlbumInfo albumInfo;
        CommonStMedia cover;
        xa.c rsp2;
        CommonAlbumInfo albumInfo2;
        xa.c rsp3;
        CommonAlbumInfo albumInfo3;
        super.h(requestCode, resultCode, intent);
        if (resultCode != -1 || intent == null || requestCode != 1003 || (qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) intent.getParcelableExtra("comment_panel_result_bean")) == null || (l3 = l()) == null) {
            return;
        }
        ic.b bVar = this.context;
        String str = null;
        String albumId = (bVar == null || (rsp3 = bVar.getRsp()) == null || (albumInfo3 = rsp3.getAlbumInfo()) == null) ? null : albumInfo3.getAlbumId();
        ic.b bVar2 = this.context;
        CommonStUser creator = (bVar2 == null || (rsp2 = bVar2.getRsp()) == null || (albumInfo2 = rsp2.getAlbumInfo()) == null) ? null : albumInfo2.getCreator();
        ic.b bVar3 = this.context;
        if (bVar3 != null && (rsp = bVar3.getRsp()) != null && (albumInfo = rsp.getAlbumInfo()) != null && (cover = albumInfo.getCover()) != null) {
            str = k9.a.e(cover, 0, 1, null);
        }
        l3.R1(albumId, creator, str, qZoneCommentPanelResultBean.getInputContent());
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void a(ic.b shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.i("QZAlbumxDetailShareQzoneAction", 2, "share clicked");
        m(shareContext);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(3);
        return arrayListOf;
    }
}
