package he;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendPhotoBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMediaLayerManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetLayerTailpageRecommendRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.RecommendItem;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo;
import com.tencent.qphone.base.util.QLog;
import ef.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\r"}, d2 = {"Lhe/a;", "", "", "albumId", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "owner", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/layer/recommendphoto/QZoneFeedxLayerRecommendPhotoBean;", "dataCallback", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f404779a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"he/a$a", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/GetLayerTailpageRecommendRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "rsp", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: he.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10431a implements DataCallback<GetLayerTailpageRecommendRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<QZoneFeedxLayerRecommendPhotoBean> f404780a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonUser f404781b;

        C10431a(n.a<QZoneFeedxLayerRecommendPhotoBean> aVar, CommonUser commonUser) {
            this.f404780a = aVar;
            this.f404781b = commonUser;
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(GetLayerTailpageRecommendRsp rsp, long retCode, String msg2, boolean isFinish) {
            AlbumCacheData Q;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = new QZoneFeedxLayerRecommendPhotoBean();
            qZoneFeedxLayerRecommendPhotoBean.albumOwnerUin = d.k(this.f404781b.getUin());
            qZoneFeedxLayerRecommendPhotoBean.albumOwnerTitle = rsp.title;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = rsp.recommandList.iterator();
            while (it.hasNext()) {
                AlbumInfo albumInfo = ((RecommendItem) it.next()).album;
                if (albumInfo != null && (Q = je.a.Q(albumInfo)) != null) {
                    arrayList.add(Q);
                }
            }
            qZoneFeedxLayerRecommendPhotoBean.albumCacheDataList = arrayList;
            this.f404780a.onSuccess(qZoneFeedxLayerRecommendPhotoBean, retCode, msg2, true);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QLog.d("QzoneFeedProLayerTailPageRepo", 1, "fetch layer recommend info error, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
            this.f404780a.onFailure(errorCode, errorMsg);
        }
    }

    a() {
    }

    public final void a(String albumId, CommonUser owner, n.a<QZoneFeedxLayerRecommendPhotoBean> dataCallback) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        new QzoneMediaLayerManager().fetchLayerTailPageRecommendReq(albumId, owner, new C10431a(dataCallback, owner));
    }
}
