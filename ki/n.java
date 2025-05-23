package ki;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.n;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqnt.kernel.nativeinterface.ClientFeed;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunFeedDetailCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunFeedDetailReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetQunFeedDetailRsp;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015Ji\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\r\u00a8\u0006\u0016"}, d2 = {"Lki/n;", "", "", "isFromArk", "", "feedId", "groupId", "albumId", "batchId", "llocId", "Lcom/qzone/reborn/base/n$a;", "Lfj/o;", "dataCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "mediaAttach", "", "attachCallback", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class n {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final String groupId, final long j3, final Function1 attachCallback, final n.a dataCallback, final NTGetQunFeedDetailRsp nTGetQunFeedDetailRsp) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(attachCallback, "$attachCallback");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ki.m
            @Override // java.lang.Runnable
            public final void run() {
                n.e(groupId, nTGetQunFeedDetailRsp, j3, attachCallback, dataCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String groupId, NTGetQunFeedDetailRsp nTGetQunFeedDetailRsp, long j3, Function1 attachCallback, n.a dataCallback) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(attachCallback, "$attachCallback");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        RFWLog.e("GroupAlbumFeedDetailServerRepo", RFWLog.USR, "getQunFeedDetail groupId:" + groupId + "  ret\uff1a" + nTGetQunFeedDetailRsp.result + " traceId:" + nTGetQunFeedDetailRsp.traceId + " hasMore:" + nTGetQunFeedDetailRsp.hasmore);
        int i3 = nTGetQunFeedDetailRsp.result;
        fj.v.a(i3 == 0, 1, i3, System.currentTimeMillis() - j3, nTGetQunFeedDetailRsp.traceId);
        int i16 = nTGetQunFeedDetailRsp.result;
        if (i16 == 0) {
            String str = nTGetQunFeedDetailRsp.mediaAttach;
            Intrinsics.checkNotNullExpressionValue(str, "response.mediaAttach");
            attachCallback.invoke(str);
            yh.a aVar = yh.a.f450323a;
            ClientFeed clientFeed = nTGetQunFeedDetailRsp.feed;
            Intrinsics.checkNotNullExpressionValue(clientFeed, "response.feed");
            BusinessFeedData c16 = aVar.c(clientFeed, nTGetQunFeedDetailRsp.extInfo);
            fj.o oVar = new fj.o();
            oVar.c(c16);
            oVar.d(new ArrayList<>());
            oVar.b().addAll(nTGetQunFeedDetailRsp.right.right);
            long j16 = nTGetQunFeedDetailRsp.result;
            String str2 = nTGetQunFeedDetailRsp.attachInfo;
            Intrinsics.checkNotNullExpressionValue(str2, "response.attachInfo");
            dataCallback.onSuccess(oVar, j16, str2, !nTGetQunFeedDetailRsp.hasmore);
            return;
        }
        dataCallback.onFailure(i16, nTGetQunFeedDetailRsp.errMs);
    }

    public final void c(boolean isFromArk, String feedId, final String groupId, String albumId, String batchId, String llocId, final n.a<fj.o> dataCallback, final Function1<? super String, Unit> attachCallback) {
        String str;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(llocId, "llocId");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        Intrinsics.checkNotNullParameter(attachCallback, "attachCallback");
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        NTGetQunFeedDetailReq nTGetQunFeedDetailReq = new NTGetQunFeedDetailReq();
        nTGetQunFeedDetailReq.extInfo = new StCommonExt();
        nTGetQunFeedDetailReq.qunId = groupId;
        if (isFromArk) {
            str = "";
        } else {
            Intrinsics.checkNotNull(feedId);
            str = feedId;
        }
        nTGetQunFeedDetailReq.feedId = str;
        nTGetQunFeedDetailReq.commentCount = 20;
        nTGetQunFeedDetailReq.attachInfo = "";
        nTGetQunFeedDetailReq.albumId = albumId;
        nTGetQunFeedDetailReq.batchId = batchId;
        nTGetQunFeedDetailReq.lloc = llocId;
        nTGetQunFeedDetailReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        final long currentTimeMillis = System.currentTimeMillis();
        if (b16 != null) {
            b16.getQunFeedDetail(nTGetQunFeedDetailReq, new IAlbumServiceGetQunFeedDetailCallback() { // from class: ki.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetQunFeedDetailCallback
                public final void onGetQunFeedDetail(NTGetQunFeedDetailRsp nTGetQunFeedDetailRsp) {
                    n.d(groupId, currentTimeMillis, attachCallback, dataCallback, nTGetQunFeedDetailRsp);
                }
            });
        }
    }
}
