package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo;

import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonClientAttr;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album.AlbumInfoConverterKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album.QZAlbumxConverterKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.IQZAegisListener;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.base.share_album_meta.ClientAttr;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetAlbumMemberListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZPersonalAlbumMemberListService;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J0\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZPersonalAlbumMemberListRepo;", "", "apiReport", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;)V", "album", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumInfo;", "getAlbum", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumInfo;", "setAlbum", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumInfo;)V", "albumMemberListService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QZPersonalAlbumMemberListService;", "sharers", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonClientAttr;", "getSharers", "()Ljava/util/List;", "requestGetAlbumMemberList", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "albumId", "", "uin", "cacheKey", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZPersonalAlbumMemberListRepo {
    public static final String TAG = "QZPersonalAlbumMemberListRepo";
    private CommonAlbumInfo album;
    private final QZPersonalAlbumMemberListService albumMemberListService;
    private final List<CommonClientAttr> sharers;
    public static final int $stable = 8;

    public QZPersonalAlbumMemberListRepo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final CommonAlbumInfo getAlbum() {
        return this.album;
    }

    public final List<CommonClientAttr> getSharers() {
        return this.sharers;
    }

    public final void requestGetAlbumMemberList(final DataCallback<CommonAlbumInfo> dataCallback, String albumId, String uin, String cacheKey) {
        this.albumMemberListService.fetchAlbumMemberList$qecommerce_biz_release(new DataCallback<GetAlbumMemberListRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo.QZPersonalAlbumMemberListRepo$requestGetAlbumMemberList$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.e(QZPersonalAlbumMemberListRepo.TAG, "fetchAlbumMemberList onFailure, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetAlbumMemberListRsp t16, long retCode, String msg2, boolean isFinish) {
                CommonAlbumInfo commonAlbumInfo;
                int collectionSizeOrDefault;
                QZPersonalAlbumMemberListRepo qZPersonalAlbumMemberListRepo = QZPersonalAlbumMemberListRepo.this;
                AlbumInfo albumInfo = t16.album;
                if (albumInfo == null || (commonAlbumInfo = AlbumInfoConverterKt.toCommonAlbumInfo(albumInfo)) == null) {
                    commonAlbumInfo = new CommonAlbumInfo();
                }
                qZPersonalAlbumMemberListRepo.setAlbum(commonAlbumInfo);
                QZPersonalAlbumMemberListRepo.this.getSharers().clear();
                List<CommonClientAttr> sharers = QZPersonalAlbumMemberListRepo.this.getSharers();
                List<ClientAttr> list = t16.sharers;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(QZAlbumxConverterKt.toCommonClientAttr((ClientAttr) it.next()));
                }
                sharers.addAll(arrayList);
                dataCallback.onSuccess(QZPersonalAlbumMemberListRepo.this.getAlbum(), retCode, msg2, isFinish);
                KLog.INSTANCE.d(QZPersonalAlbumMemberListRepo.TAG, "fetchAlbumMemberList onSuccess");
            }
        }, albumId, uin, cacheKey);
    }

    public final void setAlbum(CommonAlbumInfo commonAlbumInfo) {
        this.album = commonAlbumInfo;
    }

    public QZPersonalAlbumMemberListRepo(IQZAegisListener iQZAegisListener) {
        QZPersonalAlbumMemberListService qZPersonalAlbumMemberListService = new QZPersonalAlbumMemberListService();
        this.albumMemberListService = qZPersonalAlbumMemberListService;
        this.album = new CommonAlbumInfo();
        this.sharers = new ArrayList();
        qZPersonalAlbumMemberListService.setAegisListener(iQZAegisListener);
    }

    public static /* synthetic */ void requestGetAlbumMemberList$default(QZPersonalAlbumMemberListRepo qZPersonalAlbumMemberListRepo, DataCallback dataCallback, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = QQKuiklyPlatformApi.Companion.getUin();
        }
        if ((i3 & 8) != 0) {
            str3 = "";
        }
        qZPersonalAlbumMemberListRepo.requestGetAlbumMemberList(dataCallback, str, str2, str3);
    }

    public /* synthetic */ QZPersonalAlbumMemberListRepo(IQZAegisListener iQZAegisListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : iQZAegisListener);
    }
}
