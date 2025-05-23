package pe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadSelectAlbumInitBean;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.util.image.NetImageInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionIDKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUserKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMediaLayerManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.CloneBatchMediaRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n5.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J2\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\"\u0010#\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0010H\u0016R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lpe/j;", "Lcom/qzone/reborn/share/a;", "", "albumId", "Lcom/qzone/common/business/service/QZoneWriteOperationService$p;", "params", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", QCircleScheme.AttrDetail.FEED_INFO, "", "u", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/e;", "shareContext", "", "i", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "extraInfo", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ln5/d$g;", "listener", "v", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "l", NodeProps.VISIBLE, "k", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMediaLayerManager;", "c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMediaLayerManager;", "mediaLayerManager", "d", "Z", "listenerResultCode", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class j extends com.qzone.reborn.share.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final QzoneMediaLayerManager mediaLayerManager = new QzoneMediaLayerManager();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean listenerResultCode;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(j this$0, com.qzone.reborn.share.e shareContext, QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean, BusinessAlbumInfo businessAlbumInfo) {
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
            albumId = qzoneFeedProLayerExtraInfoBean.getAlbumId();
        }
        bVar.n(activity, QZoneContant.QZ_SELECT_ALBUM, new QZAlbumxUploadSelectAlbumInitBean(accountId, albumId));
    }

    private final void u(String albumId, QZoneWriteOperationService.p params, CommonFeed feedInfo) {
        List<String> mutableList;
        CommonUnionID unionId;
        ArrayList<String> arrayList = params.f45775g;
        if (arrayList == null) {
            QQToastUtil.showQQToastInUiThread(4, com.qzone.util.l.a(R.string.s7u));
            QZLog.e("QzoneFeedProLayerShareQzoneAlbumAction", "doReshipReal photo isEmpty");
            return;
        }
        CommonUser l3 = xd.c.l(feedInfo);
        UnionID unionID = null;
        StUser pb5 = l3 != null ? CommonUserKt.toPb(l3) : null;
        CommonCellCommon cellCommon = feedInfo.getCellCommon();
        if (cellCommon != null && (unionId = cellCommon.getUnionId()) != null) {
            unionID = CommonUnionIDKt.toPb(unionId);
        }
        QzoneMediaLayerManager qzoneMediaLayerManager = this.mediaLayerManager;
        String str = params.f45774f;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        qzoneMediaLayerManager.cloneBatchMedia(str, mutableList, albumId, pb5, unionID, new b(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(j this$0, CommonFeed feedInfo, String albumId, QZoneWriteOperationService.p params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feedInfo, "$feedInfo");
        Intrinsics.checkNotNullExpressionValue(albumId, "albumId");
        Intrinsics.checkNotNullExpressionValue(params, "params");
        this$0.u(albumId, params, feedInfo);
    }

    @Override // com.qzone.reborn.share.a
    public void b(final com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        ge.i defaultItemBean;
        ge.i defaultItemBean2;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        ge.h c16 = shareContext.c();
        RFWLayerItemMediaInfo mediaInfo = (c16 == null || (defaultItemBean2 = c16.getDefaultItemBean()) == null) ? null : defaultItemBean2.getMediaInfo();
        final QzoneFeedProLayerExtraInfoBean extraInfo = (c16 == null || (defaultItemBean = c16.getDefaultItemBean()) == null) ? null : defaultItemBean.getExtraInfo();
        CommonFeed commonFeed = c16 != null ? c16.getCom.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.FEED_INFO java.lang.String() : null;
        if (mediaInfo == null || extraInfo == null) {
            QLog.i("QzoneFeedProLayerShareQzoneAlbumAction", 1, "doAction media is null");
        } else if (commonFeed == null) {
            QLog.i("QzoneFeedProLayerShareQzoneAlbumAction", 1, "doAction feed is null");
        } else {
            v(mediaInfo, extraInfo, commonFeed, shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), new d.g() { // from class: pe.h
                @Override // n5.d.g
                public final void a(BusinessAlbumInfo businessAlbumInfo) {
                    j.t(j.this, shareContext, extraInfo, businessAlbumInfo);
                }
            });
        }
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.FIRST;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QCircleScheme.AttrQQPublish.PICKER_QZONE_ALBUM);
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean i(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return false;
    }

    @Override // com.qzone.reborn.share.a
    public void k(com.qzone.reborn.share.e shareContext, boolean visible) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        super.k(shareContext, visible);
        if (visible) {
            return;
        }
        n5.d.l().t(null);
    }

    @Override // com.qzone.reborn.share.a
    public void l(int requestCode, int resultCode, Intent data) {
        Bundle extras;
        super.l(requestCode, resultCode, data);
        if (requestCode == 37679 && this.listenerResultCode) {
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

    public final void v(RFWLayerItemMediaInfo mediaInfo, QzoneFeedProLayerExtraInfoBean extraInfo, final CommonFeed feedInfo, Activity activity, d.g listener) {
        String str;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(feedInfo, "feedInfo");
        NetImageInfo netImageInfo = new NetImageInfo(mediaInfo.getExistSaveOrEditPath(), mediaInfo.getExistSaveOrEditPath(), extraInfo.getAlbumId());
        netImageInfo.lloc = extraInfo.getLLoc();
        ArrayList<NetImageInfo> arrayList = new ArrayList<>();
        arrayList.add(netImageInfo);
        n5.d.l().s(1);
        n5.d.l().r(listener);
        n5.d.l().u(new hc.b());
        n5.d.l().t(new d.h() { // from class: pe.i
            @Override // n5.d.h
            public final void a(String str2, QZoneWriteOperationService.p pVar) {
                j.w(j.this, feedInfo, str2, pVar);
            }
        });
        CommonUser l3 = xd.c.l(feedInfo);
        if (l3 == null || (str = l3.getUin()) == null) {
            str = "";
        }
        n5.d l16 = n5.d.l();
        long k3 = ef.d.k(str);
        d.e eVar = new d.e();
        eVar.f418370c = "\u8f6c\u8f7d\u5230";
        Unit unit = Unit.INSTANCE;
        BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo(extraInfo.getAlbumId());
        businessAlbumInfo.mTitle = extraInfo.getAlbumName();
        l16.q(activity, arrayList, 4, k3, null, eVar, businessAlbumInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"pe/j$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/CloneBatchMediaRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements DataCallback<CloneBatchMediaRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f425981a;

        b(ArrayList<String> arrayList) {
            this.f425981a = arrayList;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(CloneBatchMediaRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QQToastUtil.showQQToastInUiThread(5, com.qzone.util.l.a(R.string.f170824al0));
            RFWLog.d("QzoneFeedProLayerShareQzoneAlbumAction", RFWLog.USR, "doReshipReal succeed size:" + this.f425981a.size());
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QQToastUtil.showQQToastInUiThread(4, com.qzone.util.l.a(R.string.s7u));
            RFWLog.e("QzoneFeedProLayerShareQzoneAlbumAction", RFWLog.USR, "doReshipReal not succeed " + errorCode + ", msg:" + errorMsg);
        }
    }
}
