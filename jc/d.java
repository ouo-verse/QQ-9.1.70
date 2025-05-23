package jc;

import android.content.DialogInterface;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Ljc/d;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/c;", "shareContext", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", QAdVrReportParams.ParamKey.MEDIA, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "", "", "c", "", "r", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "e", "Ljava/lang/Object;", "getDataRepo", "()Ljava/lang/Object;", "dataRepo", "<init>", "(Ljava/lang/Object;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends com.qzone.reborn.albumx.common.share.a<ic.c> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Object dataRepo;

    public d(Object obj) {
        this.dataRepo = obj;
    }

    private final void m(final ic.c shareContext, final QZAlbumxLayerExtraInfoBean media) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), 230, HardCodeUtil.qqStr(R.string.ssh), HardCodeUtil.qqStr(R.string.f134749n), HardCodeUtil.qqStr(R.string.sqw), HardCodeUtil.qqStr(R.string.srk), new DialogInterface.OnClickListener() { // from class: jc.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d.n(d.this, shareContext, media, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: jc.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d.o(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(share\u2026nt -> dialog1.dismiss() }");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(d this$0, ic.c shareContext, QZAlbumxLayerExtraInfoBean media, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        Intrinsics.checkNotNullParameter(media, "$media");
        this$0.p(shareContext, media);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        dialog1.dismiss();
    }

    private final void p(ic.c shareContext, QZAlbumxLayerExtraInfoBean media) {
        CommonEnumMediaType commonEnumMediaType;
        wa.a aVar = new wa.a();
        aVar.f(media.getUploadUid());
        aVar.e(media.getAlbumId());
        ArrayList<CommonStMedia> arrayList = new ArrayList<>();
        CommonStMedia commonStMedia = new CommonStMedia();
        commonStMedia.v(ef.d.k(media.getBatchId()));
        commonStMedia.B(media.getLinkId());
        CommonStImage image = commonStMedia.getImage();
        String lLoc = media.getLLoc();
        if (lLoc == null) {
            lLoc = "";
        }
        image.l(lLoc);
        CommonStImage cover = commonStMedia.getVideo().getCover();
        String lLoc2 = media.getLLoc();
        cover.l(lLoc2 != null ? lLoc2 : "");
        if (media.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) {
            commonEnumMediaType = CommonEnumMediaType.VIDEO;
        } else {
            commonEnumMediaType = CommonEnumMediaType.IMAGE;
        }
        commonStMedia.E(commonEnumMediaType.ordinal());
        arrayList.add(commonStMedia);
        aVar.g(arrayList);
        aVar.h(0);
        Object obj = this.dataRepo;
        aVar.j(obj instanceof ub.a ? (ub.a) obj : null);
        ub.d.f438671a.g(aVar);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void a(ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        RFWLayerItemMediaInfo layerItemInfo = shareContext.getLayerItemInfo();
        Object extraData = layerItemInfo != null ? layerItemInfo.getExtraData() : null;
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = extraData instanceof QZAlbumxLayerExtraInfoBean ? (QZAlbumxLayerExtraInfoBean) extraData : null;
        if (qZAlbumxLayerExtraInfoBean == null) {
            return;
        }
        ub.d dVar = ub.d.f438671a;
        String uploadUid = qZAlbumxLayerExtraInfoBean.getUploadUid();
        if (uploadUid == null) {
            uploadUid = "";
        }
        if (dVar.f(uploadUid)) {
            m(shareContext, qZAlbumxLayerExtraInfoBean);
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public boolean f(ic.c shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        RFWLayerItemMediaInfo layerItemInfo = shareContext.getLayerItemInfo();
        Object extraData = layerItemInfo != null ? layerItemInfo.getExtraData() : null;
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = extraData instanceof QZAlbumxLayerExtraInfoBean ? (QZAlbumxLayerExtraInfoBean) extraData : null;
        if (qZAlbumxLayerExtraInfoBean == null) {
            return false;
        }
        ub.d dVar = ub.d.f438671a;
        String uploadUid = qZAlbumxLayerExtraInfoBean.getUploadUid();
        if (uploadUid == null) {
            uploadUid = "";
        }
        return dVar.f(uploadUid);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(40);
        return arrayListOf;
    }
}
