package com.tencent.mobileqq.guild.feed.preload.detail;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailCacheData;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailCacheResponse;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.guild.feed.preload.detail.data.ResponseCode;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchGetFeedDetailReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchGetFeedDetailRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedParam;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchGetFeedDetailCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/c;", "Lcom/tencent/mobileqq/guild/feed/preload/detail/d;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feedList", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchGetFeedDetailReq;", "d", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailPreloadParams;", "params", "Lcom/tencent/mobileqq/guild/feed/preload/detail/g;", "callback", "", "a", "", "J", "start", "<init>", "()V", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long start;

    private final GProBatchGetFeedDetailReq d(List<GProStFeed> feedList) {
        GProBatchGetFeedDetailReq gProBatchGetFeedDetailReq = new GProBatchGetFeedDetailReq();
        if (feedList.isEmpty()) {
            return gProBatchGetFeedDetailReq;
        }
        GProStChannelInfo gProStChannelInfo = feedList.get(0).channelInfo;
        if (gProStChannelInfo == null) {
            return gProBatchGetFeedDetailReq;
        }
        Intrinsics.checkNotNullExpressionValue(gProStChannelInfo, "feedList[0].channelInfo ?: return this");
        gProBatchGetFeedDetailReq.channelSign = gProStChannelInfo.sign;
        gProBatchGetFeedDetailReq.from = 0;
        gProBatchGetFeedDetailReq.detailType = 1;
        ArrayList<GProFeedParam> arrayList = gProBatchGetFeedDetailReq.feedParamList;
        for (GProStFeed gProStFeed : feedList) {
            GProFeedParam gProFeedParam = new GProFeedParam();
            gProFeedParam.userId = gProStFeed.poster.idd;
            gProFeedParam.feedId = gProStFeed.idd;
            gProFeedParam.createTime = gProStFeed.createTime;
            arrayList.add(gProFeedParam);
        }
        return gProBatchGetFeedDetailReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final c this$0, final g gVar, final int i3, final String str, final boolean z16, final GProBatchGetFeedDetailRsp gProBatchGetFeedDetailRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.preload.detail.b
            @Override // java.lang.Runnable
            public final void run() {
                c.f(i3, str, z16, this$0, gProBatchGetFeedDetailRsp, gVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, String str, boolean z16, c this$0, GProBatchGetFeedDetailRsp gProBatchGetFeedDetailRsp, g gVar) {
        boolean z17;
        boolean z18;
        List emptyList;
        List list;
        ArrayList<GProFeedInfo> arrayList;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z19 = false;
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.i("FeedDetailMsfTask", 1, "[getFeedDetailFromNet]  onReceive isSuccess:" + z17 + " errMsg:" + str + " isDbCache:" + z16);
        long currentTimeMillis = System.currentTimeMillis() - this$0.start;
        if (z17 && gProBatchGetFeedDetailRsp != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (gProBatchGetFeedDetailRsp == null || (arrayList = gProBatchGetFeedDetailRsp.feeds) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        } else {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (GProFeedInfo gProFeedInfo : arrayList) {
                String str2 = gProFeedInfo.feedId;
                Intrinsics.checkNotNullExpressionValue(str2, "it.feedId");
                byte[] bArr = gProFeedInfo.feed;
                Intrinsics.checkNotNullExpressionValue(bArr, "it.feed");
                arrayList2.add(new GuildFeedDetailCacheData(str2, new String(bArr, Charsets.UTF_8), null, gProFeedInfo.lastModifiedTime, 4, null));
            }
            list = arrayList2;
        }
        GuildFeedDetailCacheResponse guildFeedDetailCacheResponse = new GuildFeedDetailCacheResponse(list, currentTimeMillis, new ResponseCode(i3, "retCode: " + i3 + ", retMsg: " + str), 2);
        if (gVar != null) {
            if (z18 && guildFeedDetailCacheResponse.isValid()) {
                z19 = true;
            }
            gVar.a(z19, guildFeedDetailCacheResponse);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.preload.detail.d
    public void a(@NotNull List<GuildFeedDetailPreloadParams> params, @Nullable final g callback) {
        boolean z16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(params, "params");
        if (!params.isEmpty()) {
            List<GuildFeedDetailPreloadParams> list = params;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (!((GuildFeedDetailPreloadParams) it.next()).isValid()) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
                this.start = System.currentTimeMillis();
                GuildFeedDetailPreloadParams guildFeedDetailPreloadParams = params.get(0);
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it5 = list.iterator();
                while (it5.hasNext()) {
                    GProStFeed covertToStFeed = ((GuildFeedDetailPreloadParams) it5.next()).covertToStFeed();
                    covertToStFeed.channelInfo.sign.channelId = guildFeedDetailPreloadParams.getChannelId();
                    covertToStFeed.channelInfo.sign.guildId = guildFeedDetailPreloadParams.getGuildId();
                    arrayList.add(covertToStFeed);
                }
                GProBatchGetFeedDetailReq d16 = d(arrayList);
                o c16 = l.c();
                if (c16 != null) {
                    c16.batchGetFeedDetail(d16, new IGProBatchGetFeedDetailCallback() { // from class: com.tencent.mobileqq.guild.feed.preload.detail.a
                        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchGetFeedDetailCallback
                        public final void onResult(int i3, String str, boolean z17, GProBatchGetFeedDetailRsp gProBatchGetFeedDetailRsp) {
                            c.e(c.this, callback, i3, str, z17, gProBatchGetFeedDetailRsp);
                        }
                    });
                    return;
                }
                return;
            }
        }
        Logger.f235387a.d().d("FeedDetailMsfTask", 1, "FeedDetailMsfTask param list is empty or invalid");
        if (callback != null) {
            callback.a(false, new GuildFeedDetailCacheResponse(null, 0L, new ResponseCode(-7, "params size over"), 0, 11, null));
        }
    }
}
