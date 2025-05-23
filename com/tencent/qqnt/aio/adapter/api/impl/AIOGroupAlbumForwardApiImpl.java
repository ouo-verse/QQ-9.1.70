package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.IAIOGroupAlbumForwardApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qzonehub.api.IQZoneForwardGroupAlbumApi;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.utils.IQZoneGroupAlbumPermissionUtil;
import cooperation.qzone.model.ForwardGroupAlbumBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOGroupAlbumForwardApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOGroupAlbumForwardApi;", "()V", "chatHistorySave2GroupAlbum", "", "context", "Landroid/content/Context;", "msgRecordList", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "forwardGroupAlbum", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "needShowAIOMenuGroupAlbumEntry", "", "peerUid", "", "needShowChatHistoryGroupAlbumEntry", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AIOGroupAlbumForwardApiImpl implements IAIOGroupAlbumForwardApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOGroupAlbumForwardApi
    public void chatHistorySave2GroupAlbum(Context context, List<MsgRecord> msgRecordList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        ForwardGroupAlbumBean forwardGroupAlbumBean = new ForwardGroupAlbumBean();
        forwardGroupAlbumBean.context = context;
        forwardGroupAlbumBean.isSingleMedia = true;
        if (true ^ msgRecordList.isEmpty()) {
            forwardGroupAlbumBean.groupId = msgRecordList.get(0).peerUid;
        }
        forwardGroupAlbumBean.mediaList = ((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).msgRecordToMediaInfo(msgRecordList);
        ((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).forwardToGroupAlbum(forwardGroupAlbumBean, 4);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOGroupAlbumForwardApi
    public void forwardGroupAlbum(Context context, AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ForwardGroupAlbumBean forwardGroupAlbumBean = new ForwardGroupAlbumBean();
        forwardGroupAlbumBean.context = context;
        forwardGroupAlbumBean.groupId = msgItem.getMsgRecord().peerUid;
        forwardGroupAlbumBean.isSingleMedia = true;
        ArrayList arrayList = new ArrayList();
        MsgRecord msgRecord = msgItem.getMsgRecord();
        if (msgRecord != null) {
            arrayList.add(msgRecord);
        }
        forwardGroupAlbumBean.mediaList = ((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).msgRecordToMediaInfo(arrayList);
        ((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).forwardToGroupAlbum(forwardGroupAlbumBean, 1);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOGroupAlbumForwardApi
    public boolean needShowAIOMenuGroupAlbumEntry(String peerUid, AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return !((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).isMediaExpired(msgItem.getMsgRecord()) && ((IQZoneGroupAlbumPermissionUtil) QRoute.api(IQZoneGroupAlbumPermissionUtil.class)).isSupportForwardToGroupAlbum(peerUid) && ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).isAIOLongPressExptOn();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOGroupAlbumForwardApi
    public boolean needShowChatHistoryGroupAlbumEntry(String peerUid) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        return ((IQZoneGroupAlbumPermissionUtil) QRoute.api(IQZoneGroupAlbumPermissionUtil.class)).isSupportForwardToGroupAlbum(peerUid) && ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).isChatRecordExpOn();
    }
}
