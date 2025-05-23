package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album.AlbumInfoConverterKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.IQZAegisListener;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media.GetAlbumListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZQunAlbumListService;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J6\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZQunAlbumListRepo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZAlbumListRepo;", "apiReport", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;)V", "albumListService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QZQunAlbumListService;", "requestGetAlbumList", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumInfo;", "qunId", "", FeedManager.LOAD_MORE, "", "cacheKey", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZQunAlbumListRepo extends QZAlbumListRepo {
    public static final String TAG = "QZQunAlbumListRepo";
    private final QZQunAlbumListService albumListService;
    public static final int $stable = 8;

    public QZQunAlbumListRepo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void requestGetAlbumList(final DataCallback<List<CommonAlbumInfo>> dataCallback, String qunId, final boolean loadMore, String cacheKey) {
        this.albumListService.fetchAlbumList$qecommerce_biz_release(new DataCallback<GetAlbumListRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo.QZQunAlbumListRepo$requestGetAlbumList$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.e(QZQunAlbumListRepo.TAG, "onFailure, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetAlbumListRsp t16, long retCode, String msg2, boolean isFinish) {
                int collectionSizeOrDefault;
                if (!loadMore) {
                    this.getAllAlbumList().clear();
                }
                List<CommonAlbumInfo> allAlbumList = this.getAllAlbumList();
                List<AlbumInfo> list = t16.albumList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(AlbumInfoConverterKt.toCommonAlbumInfo((AlbumInfo) it.next()));
                }
                allAlbumList.addAll(arrayList);
                dataCallback.onSuccess(this.getAllAlbumList(), retCode, msg2, isFinish);
                KLog kLog = KLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onSuccess isFinish:");
                sb5.append(isFinish);
                sb5.append(TokenParser.SP);
                sb5.append(this.getAllAlbumList().size());
                sb5.append(TokenParser.SP);
                NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(sb5, loadMore, kLog, QZQunAlbumListRepo.TAG);
            }
        }, qunId, loadMore, cacheKey);
    }

    public QZQunAlbumListRepo(IQZAegisListener iQZAegisListener) {
        QZQunAlbumListService qZQunAlbumListService = new QZQunAlbumListService();
        this.albumListService = qZQunAlbumListService;
        qZQunAlbumListService.setAegisListener(iQZAegisListener);
    }

    public /* synthetic */ QZQunAlbumListRepo(IQZAegisListener iQZAegisListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : iQZAegisListener);
    }

    public static /* synthetic */ void requestGetAlbumList$default(QZQunAlbumListRepo qZQunAlbumListRepo, DataCallback dataCallback, String str, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            str2 = "";
        }
        qZQunAlbumListRepo.requestGetAlbumList(dataCallback, str, z16, str2);
    }
}
