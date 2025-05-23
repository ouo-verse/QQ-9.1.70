package jc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadSelectAlbumInitBean;
import com.qzone.util.image.NetImageInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.BusinessAlbumInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import n5.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\"\u0010\u0018\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Ljc/aa;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lic/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", tl.h.F, "shareContext", "", DomainData.DOMAIN_NAME, "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "l", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ln5/d$g;", "listener", "o", "e", "Z", "listenerResultCode", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class aa extends com.qzone.reborn.albumx.common.share.a<ic.c> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean listenerResultCode;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(aa this$0, ic.c shareContext, BusinessAlbumInfo businessAlbumInfo) {
        String albumId;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        this$0.listenerResultCode = true;
        vb.b bVar = (vb.b) ho.i.t(vb.b.class);
        Activity activity = shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
        String accountId = RFWApplication.getAccountId();
        if (accountId == null) {
            accountId = "";
        }
        BusinessAlbumInfo k3 = n5.d.l().k();
        if (k3 == null || (albumId = k3.mAlbumId) == null) {
            QZAlbumxLayerExtraInfoBean extraInfoBean = shareContext.getExtraInfoBean();
            albumId = extraInfoBean != null ? extraInfoBean.getAlbumId() : null;
        }
        bVar.n(activity, QZoneContant.QZ_SELECT_ALBUM, new QZAlbumxUploadSelectAlbumInitBean(accountId, albumId));
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.FIRST;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public void h(int requestCode, int resultCode, Intent data) {
        Bundle extras;
        super.h(requestCode, resultCode, data);
        if (this.listenerResultCode) {
            this.listenerResultCode = false;
            Object obj = (data == null || (extras = data.getExtras()) == null) ? null : extras.get("SELECTED_ALBUM_INFO");
            CommonAlbumInfo commonAlbumInfo = obj instanceof CommonAlbumInfo ? (CommonAlbumInfo) obj : null;
            if (commonAlbumInfo == null) {
                return;
            }
            n5.d l3 = n5.d.l();
            BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo(commonAlbumInfo.getAlbumId());
            businessAlbumInfo.mTitle = commonAlbumInfo.getName();
            businessAlbumInfo.mPrivacy = commonAlbumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType();
            businessAlbumInfo.mCover = commonAlbumInfo.getCover().l();
            l3.v(businessAlbumInfo);
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void a(final ic.c shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        o(shareContext, shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), new d.g() { // from class: jc.z
            @Override // n5.d.g
            public final void a(BusinessAlbumInfo businessAlbumInfo) {
                aa.m(aa.this, shareContext, businessAlbumInfo);
            }
        });
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public boolean f(ic.c shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return true;
    }

    public final void o(ic.c shareContext, Activity activity, d.g listener) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Object extraData = shareContext.getLayerItemInfo().getExtraData();
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = extraData instanceof QZAlbumxLayerExtraInfoBean ? (QZAlbumxLayerExtraInfoBean) extraData : null;
        if (qZAlbumxLayerExtraInfoBean == null) {
            return;
        }
        NetImageInfo netImageInfo = new NetImageInfo(shareContext.getExistSaveOrEditPath(), shareContext.getExistSaveOrEditPath(), qZAlbumxLayerExtraInfoBean.getAlbumId());
        netImageInfo.lloc = qZAlbumxLayerExtraInfoBean.getLLoc();
        ArrayList<NetImageInfo> arrayList = new ArrayList<>();
        arrayList.add(netImageInfo);
        n5.d.l().s(1);
        n5.d.l().r(listener);
        n5.d.l().u(new hc.b());
        n5.d l3 = n5.d.l();
        long k3 = ef.d.k(qZAlbumxLayerExtraInfoBean.getUploadUid());
        d.e eVar = new d.e();
        eVar.f418370c = "\u8f6c\u8f7d\u5230";
        Unit unit = Unit.INSTANCE;
        BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo(qZAlbumxLayerExtraInfoBean.getAlbumId());
        businessAlbumInfo.mTitle = qZAlbumxLayerExtraInfoBean.getAlbumName();
        l3.q(activity, arrayList, 4, k3, null, eVar, businessAlbumInfo);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(100);
        return listOf;
    }
}
