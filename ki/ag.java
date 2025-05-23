package ki;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.reborn.base.n;
import com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendPhotoBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMediaListTailTabCallback;
import com.tencent.qqnt.kernel.nativeinterface.MediaType;
import com.tencent.qqnt.kernel.nativeinterface.NTGetMediaListTailTabReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetMediaListTailTabRsp;
import com.tencent.qqnt.kernel.nativeinterface.StImage;
import com.tencent.qqnt.kernel.nativeinterface.StPicUrl;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0005H\u0002J\f\u0010\t\u001a\u00020\u0006*\u00020\bH\u0002J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a8\u0006\u0014"}, d2 = {"Lki/ag;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "Lcom/qzone/album/data/model/AlbumCacheData;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/StImage;", "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/StPicUrl;", tl.h.F, "", "groupId", "currentAlbumId", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/layer/recommendphoto/QZoneFeedxLayerRecommendPhotoBean;", "dataCallback", "", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ag {
    private final AlbumCacheData c(AlbumInfo albumInfo) {
        PictureUrl g16;
        AlbumCacheData albumCacheData = new AlbumCacheData();
        albumCacheData.albumOwner = albumInfo.owner;
        if (albumInfo.cover.type == MediaType.KMEDIATYPEIMAGE.ordinal()) {
            g16 = g(albumInfo.cover.image);
        } else {
            g16 = g(albumInfo.cover.video.cover);
        }
        albumCacheData.coverUrl = g16;
        albumCacheData.bitmap = albumInfo.bitmap;
        albumCacheData.albumnum = (int) albumInfo.uploadNumber;
        albumCacheData.albumname = albumInfo.name;
        albumCacheData.albumdesc = albumInfo.desc;
        albumCacheData.albumid = albumInfo.albumId;
        albumCacheData.allow_share = wx4.d.INSTANCE.b(albumInfo.isShareAlbum);
        return albumCacheData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final String groupId, final n.a dataCallback, final ag this$0, final NTGetMediaListTailTabRsp nTGetMediaListTailTabRsp) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ki.af
            @Override // java.lang.Runnable
            public final void run() {
                ag.f(groupId, nTGetMediaListTailTabRsp, dataCallback, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String groupId, NTGetMediaListTailTabRsp nTGetMediaListTailTabRsp, n.a dataCallback, ag this$0) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.e("GroupAlbumRecommendServerRepo", RFWLog.USR, "getMediaListTailTab groupId:" + groupId + "  ret\uff1a" + nTGetMediaListTailTabRsp.result + " traceId:" + nTGetMediaListTailTabRsp.traceId + " albums:" + nTGetMediaListTailTabRsp.albums.size());
        int i3 = nTGetMediaListTailTabRsp.result;
        if (i3 == 0) {
            QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = new QZoneFeedxLayerRecommendPhotoBean();
            ArrayList arrayList = new ArrayList();
            ArrayList<AlbumInfo> arrayList2 = nTGetMediaListTailTabRsp.albums;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "response.albums");
            for (AlbumInfo it : arrayList2) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(this$0.c(it));
            }
            qZoneFeedxLayerRecommendPhotoBean.albumCacheDataList = arrayList;
            long j3 = nTGetMediaListTailTabRsp.result;
            String str = nTGetMediaListTailTabRsp.errMs;
            Intrinsics.checkNotNullExpressionValue(str, "response.errMs");
            dataCallback.onSuccess(qZoneFeedxLayerRecommendPhotoBean, j3, str, true);
            return;
        }
        dataCallback.onFailure(i3, nTGetMediaListTailTabRsp.errMs);
    }

    private final PictureUrl h(StPicUrl stPicUrl) {
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.url = stPicUrl.url;
        pictureUrl.width = stPicUrl.width;
        pictureUrl.height = stPicUrl.height;
        return pictureUrl;
    }

    public final void d(final String groupId, String currentAlbumId, final n.a<QZoneFeedxLayerRecommendPhotoBean> dataCallback) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(currentAlbumId, "currentAlbumId");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        if (!(groupId.length() == 0)) {
            if (!(currentAlbumId.length() == 0)) {
                com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
                NTGetMediaListTailTabReq nTGetMediaListTailTabReq = new NTGetMediaListTailTabReq();
                nTGetMediaListTailTabReq.currentAlbumId = currentAlbumId;
                nTGetMediaListTailTabReq.qunId = groupId;
                nTGetMediaListTailTabReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
                if (b16 != null) {
                    b16.getMediaListTailTab(nTGetMediaListTailTabReq, new IAlbumServiceGetMediaListTailTabCallback() { // from class: ki.ae
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMediaListTailTabCallback
                        public final void onGetMediaListTailTab(NTGetMediaListTailTabRsp nTGetMediaListTailTabRsp) {
                            ag.e(groupId, dataCallback, this, nTGetMediaListTailTabRsp);
                        }
                    });
                    return;
                }
                return;
            }
        }
        RFWLog.e("GroupAlbumRecommendServerRepo", RFWLog.USR, "groupId or albumId is null");
        dataCallback.onFailure(-1L, "");
    }

    private final PictureUrl g(StImage stImage) {
        StPicUrl l3;
        if (stImage == null || (l3 = yh.b.l(stImage)) == null) {
            return null;
        }
        return h(l3);
    }
}
