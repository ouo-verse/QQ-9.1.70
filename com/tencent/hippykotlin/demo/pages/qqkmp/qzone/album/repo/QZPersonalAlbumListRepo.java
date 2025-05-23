package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonPageEndMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album.AlbumInfoConverterKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album.QZAlbumxConverterKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.IQZAegisListener;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.AlbumPageInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetAlbumListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.PageEndMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZPersonalAlbumListService;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.httpcore.message.TokenParser;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J8\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZPersonalAlbumListRepo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZAlbumListRepo;", "apiReport", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;)V", "albumListService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QZPersonalAlbumListService;", "endMsg", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonPageEndMsg;", "getEndMsg", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonPageEndMsg;", "setEndMsg", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonPageEndMsg;)V", "pageInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/AlbumPageInfo;", "getPageInfo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/AlbumPageInfo;", "setPageInfo", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/AlbumPageInfo;)V", "requestGetAlbumList", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumInfo;", "uin", "", FeedManager.LOAD_MORE, "", "cacheKey", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZPersonalAlbumListRepo extends QZAlbumListRepo {
    public static final String TAG = "QZPersonalAlbumListRepo";
    private final QZPersonalAlbumListService albumListService;
    private CommonPageEndMsg endMsg;
    private AlbumPageInfo pageInfo;
    public static final int $stable = 8;

    public QZPersonalAlbumListRepo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final CommonPageEndMsg getEndMsg() {
        return this.endMsg;
    }

    public final AlbumPageInfo getPageInfo() {
        return this.pageInfo;
    }

    public final void requestGetAlbumList(final DataCallback<List<CommonAlbumInfo>> dataCallback, String uin, final boolean loadMore, String cacheKey) {
        this.albumListService.fetchAlbumList$qecommerce_biz_release(new DataCallback<GetAlbumListRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo.QZPersonalAlbumListRepo$requestGetAlbumList$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.e(QZPersonalAlbumListRepo.TAG, "onFailure, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetAlbumListRsp t16, long retCode, String msg2, boolean isFinish) {
                int collectionSizeOrDefault;
                if (!loadMore) {
                    this.setPageInfo(t16.pageInfo);
                    this.getAllAlbumList().clear();
                }
                List<CommonAlbumInfo> allAlbumList = this.getAllAlbumList();
                List<AlbumInfo> list = t16.album;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(AlbumInfoConverterKt.toCommonAlbumInfo((AlbumInfo) it.next()));
                }
                allAlbumList.addAll(arrayList);
                QZPersonalAlbumListRepo qZPersonalAlbumListRepo = this;
                PageEndMsg pageEndMsg = t16.endMsg;
                qZPersonalAlbumListRepo.setEndMsg(pageEndMsg != null ? QZAlbumxConverterKt.toCommonPageEndMsg(pageEndMsg) : null);
                dataCallback.onSuccess(this.getAllAlbumList(), retCode, msg2, isFinish);
                KLog kLog = KLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onSuccess isFinish:");
                sb5.append(isFinish);
                sb5.append(TokenParser.SP);
                sb5.append(this.getAllAlbumList().size());
                sb5.append(TokenParser.SP);
                NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(sb5, loadMore, kLog, QZPersonalAlbumListRepo.TAG);
            }
        }, uin, loadMore, cacheKey);
    }

    public final void setEndMsg(CommonPageEndMsg commonPageEndMsg) {
        this.endMsg = commonPageEndMsg;
    }

    public final void setPageInfo(AlbumPageInfo albumPageInfo) {
        this.pageInfo = albumPageInfo;
    }

    public QZPersonalAlbumListRepo(IQZAegisListener iQZAegisListener) {
        QZPersonalAlbumListService qZPersonalAlbumListService = new QZPersonalAlbumListService();
        this.albumListService = qZPersonalAlbumListService;
        qZPersonalAlbumListService.setAegisListener(iQZAegisListener);
    }

    public /* synthetic */ QZPersonalAlbumListRepo(IQZAegisListener iQZAegisListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : iQZAegisListener);
    }

    public static /* synthetic */ void requestGetAlbumList$default(QZPersonalAlbumListRepo qZPersonalAlbumListRepo, DataCallback dataCallback, String str, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = QQKuiklyPlatformApi.Companion.getUin();
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            str2 = "";
        }
        qZPersonalAlbumListRepo.requestGetAlbumList(dataCallback, str, z16, str2);
    }
}
