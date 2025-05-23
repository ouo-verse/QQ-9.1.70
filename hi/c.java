package hi;

import android.app.Activity;
import android.content.DialogInterface;
import ci.j;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import fj.p;
import java.util.ArrayList;
import java.util.List;
import ki.g;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001f\u0010 J,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J$\u0010\r\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lhi/c;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lgi/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", "extraInfo", "", "fromAlbumDetail", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lci/j;", "o", "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, DomainData.DOMAIN_NAME, "Lki/g;", "e", "Lki/g;", "getDataRepo", "()Lki/g;", "dataRepo", "<init>", "(Lki/g;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends com.qzone.reborn.albumx.common.share.a<gi.a> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final g dataRepo;

    public c(g gVar) {
        this.dataRepo = gVar;
    }

    private final void m(RFWLayerItemMediaInfo mediaInfo, GroupAlbumLayerExtraInfoBean extraInfo, boolean fromAlbumDetail) {
        j o16 = o(mediaInfo, extraInfo, fromAlbumDetail);
        if (o16 != null) {
            ki.d.f412455a.g(o16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(c this$0, RFWLayerItemMediaInfo rFWLayerItemMediaInfo, GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean, boolean z16, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m(rFWLayerItemMediaInfo, groupAlbumLayerExtraInfoBean, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        dialog1.dismiss();
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void a(gi.a shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        RFWLayerItemMediaInfo layerItemInfo = shareContext.getLayerItemInfo();
        Object extraData = layerItemInfo != null ? layerItemInfo.getExtraData() : null;
        Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean");
        p(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), shareContext.getLayerItemInfo(), (GroupAlbumLayerExtraInfoBean) extraData, shareContext.getFromDetail());
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(40);
        return arrayListOf;
    }

    private final j o(RFWLayerItemMediaInfo mediaInfo, GroupAlbumLayerExtraInfoBean extraInfo, boolean fromAlbumDetail) {
        if (mediaInfo == null || extraInfo == null) {
            return null;
        }
        j jVar = new j();
        jVar.h(fromAlbumDetail ? 4 : 3);
        jVar.f(extraInfo.getGroupId());
        jVar.e(extraInfo.getAlbumId());
        ArrayList<CommonStMedia> arrayList = new ArrayList<>();
        arrayList.add(p.f399467a.a(mediaInfo, extraInfo));
        jVar.g(arrayList);
        jVar.j(this.dataRepo);
        return jVar;
    }

    private final void p(Activity activity, final RFWLayerItemMediaInfo mediaInfo, final GroupAlbumLayerExtraInfoBean extraInfo, final boolean fromAlbumDetail) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, HardCodeUtil.qqStr(R.string.ssh), "\u5220\u9664\u540e\u7fa4\u6210\u5458\u90fd\u5c06\u65e0\u6cd5\u67e5\u770b", HardCodeUtil.qqStr(R.string.sqw), HardCodeUtil.qqStr(R.string.srk), new DialogInterface.OnClickListener() { // from class: hi.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.q(c.this, mediaInfo, extraInfo, fromAlbumDetail, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: hi.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.r(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026nt -> dialog1.dismiss() }");
        createCustomDialog.show();
    }
}
