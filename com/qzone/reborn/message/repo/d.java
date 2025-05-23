package com.qzone.reborn.message.repo;

import NS_MOBILE_FEEDS.mobile_feeds_rsp;
import NS_MOBILE_FEEDS.operation_del_icfeed_rsp;
import NS_MOBILE_FEEDS.single_feed;
import NS_MOBILE_PHOTO.AllowJoinShareAlbum;
import NS_MOBILE_PHOTO.JoinShareAlbumRsp;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.protocol.QZoneJoinShareAlbumRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneDeleteMyFeedRequest;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.reborn.base.n;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u00172\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\"\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007J\"\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007J\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/message/repo/d;", "", "", "isFromNotify", "", "attachInfo", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "Lcom/qzone/reborn/base/n$a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "dataCallback", "", "f", "k", "j", "feedData", "d", h.F, "a", "Ljava/lang/String;", "mAttachInfo", "<init>", "()V", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String mAttachInfo = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(n.a dataCallback, QZoneTask task) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        Intrinsics.checkNotNullParameter(task, "task");
        QZoneRequest qZoneRequest = task.mRequest;
        JceStruct jceStruct = qZoneRequest != null ? qZoneRequest.rsp : null;
        if (task.succeeded() && (jceStruct instanceof operation_del_icfeed_rsp)) {
            operation_del_icfeed_rsp operation_del_icfeed_rspVar = (operation_del_icfeed_rsp) jceStruct;
            int i3 = operation_del_icfeed_rspVar.ret;
            task.mResultCode = i3;
            String str = operation_del_icfeed_rspVar.f24990msg;
            task.f45835msg = str;
            Intrinsics.checkNotNullExpressionValue(str, "task.msg");
            dataCallback.onSuccess(jceStruct, i3, str, true);
            return;
        }
        dataCallback.onFailure(task.mResultCode, task.f45835msg);
    }

    private final void f(boolean isFromNotify, String attachInfo, final boolean isLoadMore, final n.a<List<BusinessFeedData>> dataCallback) {
        RFWLog.d("QZonePassiveMessageServerRepo", RFWLog.USR, "refresh");
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZonePassiveMessageListRequest(isLoadMore ? 2 : 1, isFromNotify, attachInfo), null, new IQZoneServiceListener() { // from class: com.qzone.reborn.message.repo.a
            @Override // com.qzone.common.business.IQZoneServiceListener
            public final void onTaskResponse(QZoneTask qZoneTask) {
                d.g(d.this, dataCallback, isLoadMore, qZoneTask);
            }
        }, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(d this$0, n.a dataCallback, boolean z16, QZoneTask task) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        Intrinsics.checkNotNullParameter(task, "task");
        QZoneRequest qZoneRequest = task.mRequest;
        JceStruct jceStruct = qZoneRequest != null ? qZoneRequest.rsp : null;
        if (task.succeeded() && (jceStruct instanceof mobile_feeds_rsp)) {
            mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) jceStruct;
            String str = mobile_feeds_rspVar.attach_info;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.attach_info");
            this$0.mAttachInfo = str;
            boolean z17 = mobile_feeds_rspVar.hasmore == 0;
            ArrayList<single_feed> arrayList = mobile_feeds_rspVar.all_feeds_data;
            Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.all_feeds_data");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(BusinessFeedData.createFrom((single_feed) it.next(), 4098));
            }
            long j3 = task.mResultCode;
            String str2 = task.f45835msg;
            Intrinsics.checkNotNullExpressionValue(str2, "task.msg");
            dataCallback.onSuccess(arrayList2, j3, str2, z17);
            RFWLog.d("QZonePassiveMessageServerRepo", RFWLog.USR, "refresh success, size: " + arrayList2.size() + ", isLoadMore: " + z16);
            return;
        }
        dataCallback.onFailure(task.mResultCode, task.f45835msg);
        RFWLog.d("QZonePassiveMessageServerRepo", RFWLog.USR, "refresh fail, code: " + task.mResultCode + ", msg: " + task.f45835msg + ", isLoadMore: " + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(n.a dataCallback, QZoneTask task) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        Intrinsics.checkNotNullParameter(task, "task");
        QZoneRequest qZoneRequest = task.mRequest;
        JceStruct jceStruct = qZoneRequest != null ? qZoneRequest.rsp : null;
        if (task.succeeded() && (jceStruct instanceof JoinShareAlbumRsp)) {
            JoinShareAlbumRsp joinShareAlbumRsp = (JoinShareAlbumRsp) jceStruct;
            int i3 = joinShareAlbumRsp.ret;
            task.mResultCode = i3;
            String str = joinShareAlbumRsp.f25029msg;
            task.f45835msg = str;
            Intrinsics.checkNotNullExpressionValue(str, "task.msg");
            dataCallback.onSuccess(jceStruct, i3, str, true);
            return;
        }
        dataCallback.onFailure(task.mResultCode, task.f45835msg);
    }

    public final void d(BusinessFeedData feedData, final n.a<Object> dataCallback) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneDeleteMyFeedRequest(feedData.getFeedCommInfo().appid, feedData.getUser().uin, feedData.getFeedCommInfo().feedsType, feedData.getFeedCommInfo().feedskey, feedData.getFeedCommInfo().getTime(), feedData.getOperationInfo().busiParam, feedData.getFeedCommInfo().clientkey), null, new IQZoneServiceListener() { // from class: com.qzone.reborn.message.repo.c
            @Override // com.qzone.common.business.IQZoneServiceListener
            public final void onTaskResponse(QZoneTask qZoneTask) {
                d.e(n.a.this, qZoneTask);
            }
        }, 0));
    }

    public final void h(BusinessFeedData feedData, final n.a<Object> dataCallback) {
        Map<String, byte[]> map;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        CellFeedCommInfo feedCommInfoV2 = feedData.getFeedCommInfoV2();
        if ((feedCommInfoV2 == null || (map = feedCommInfoV2.extendInfoData) == null || map.containsKey("photo_invite_jce")) ? false : true) {
            RFWLog.e("QZonePassiveMessageServerRepo", RFWLog.USR, "feedData: " + feedData + " can not join album");
            return;
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneJoinShareAlbumRequest(LoginData.getInstance().getUin(), 2, null, new AllowJoinShareAlbum(1, feedData.getFeedCommInfoV2().extendInfoData.get("photo_invite_jce"))), null, new IQZoneServiceListener() { // from class: com.qzone.reborn.message.repo.b
            @Override // com.qzone.common.business.IQZoneServiceListener
            public final void onTaskResponse(QZoneTask qZoneTask) {
                d.i(n.a.this, qZoneTask);
            }
        }, 0));
    }

    public final void j(boolean isFromNotify, n.a<List<BusinessFeedData>> dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        f(isFromNotify, this.mAttachInfo, true, dataCallback);
    }

    public final void k(boolean isFromNotify, n.a<List<BusinessFeedData>> dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        f(isFromNotify, "", false, dataCallback);
    }
}
