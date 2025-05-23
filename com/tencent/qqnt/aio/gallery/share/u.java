package com.tencent.qqnt.aio.gallery.share;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qzonehub.api.IQZoneForwardGroupAlbumApi;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.utils.IQZoneGroupAlbumPermissionUtil;
import cooperation.qzone.model.ForwardGroupAlbumBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/u;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "i", "j", "k", "", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "", "c", "a", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class u extends a {
    private final void i(NTShareContext shareContext) {
        if (shareContext.getMediaType() == 1) {
            j(shareContext);
        } else if (shareContext.getMediaType() == 3) {
            k(shareContext);
        }
    }

    private final void j(NTShareContext shareContext) {
        ForwardGroupAlbumBean forwardGroupAlbumBean = new ForwardGroupAlbumBean();
        forwardGroupAlbumBean.context = shareContext.getActivity();
        MsgRecord msgRecord = shareContext.getMsgRecord();
        forwardGroupAlbumBean.groupId = msgRecord != null ? msgRecord.peerUid : null;
        forwardGroupAlbumBean.isSingleMedia = true;
        ArrayList arrayList = new ArrayList();
        MsgRecord msgRecord2 = shareContext.getMsgRecord();
        if (msgRecord2 != null) {
            arrayList.add(msgRecord2);
        }
        forwardGroupAlbumBean.mediaList = ((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).msgRecordToMediaInfo(arrayList);
        ((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).forwardToGroupAlbum(forwardGroupAlbumBean, 2);
    }

    private final void k(NTShareContext shareContext) {
        ForwardGroupAlbumBean forwardGroupAlbumBean = new ForwardGroupAlbumBean();
        forwardGroupAlbumBean.context = shareContext.getActivity();
        MsgRecord msgRecord = shareContext.getMsgRecord();
        forwardGroupAlbumBean.groupId = msgRecord != null ? msgRecord.peerUid : null;
        forwardGroupAlbumBean.isSingleMedia = true;
        ArrayList arrayList = new ArrayList();
        MsgRecord msgRecord2 = shareContext.getMsgRecord();
        if (msgRecord2 != null) {
            arrayList.add(msgRecord2);
        }
        forwardGroupAlbumBean.mediaList = ((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).msgRecordToMediaInfo(arrayList);
        ((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).forwardToGroupAlbum(forwardGroupAlbumBean, 2);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void a(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        i(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        i(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<String> c() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("groupalbum");
        return listOf;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.FIRST;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).isMediaExpired(shareContext.getMsgRecord())) {
            return false;
        }
        IQZoneGroupAlbumPermissionUtil iQZoneGroupAlbumPermissionUtil = (IQZoneGroupAlbumPermissionUtil) QRoute.api(IQZoneGroupAlbumPermissionUtil.class);
        MsgRecord msgRecord = shareContext.getMsgRecord();
        boolean z16 = iQZoneGroupAlbumPermissionUtil.isSupportForwardToGroupAlbum(msgRecord != null ? msgRecord.peerUid : null) && ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).isAIOPanelShareSwitch();
        if (shareContext.getMediaType() != 1 && shareContext.getMediaType() != 3) {
            return false;
        }
        MsgRecord msgRecord2 = shareContext.getMsgRecord();
        return (msgRecord2 != null && msgRecord2.chatType == 2) && z16;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(51);
        return arrayListOf;
    }
}
