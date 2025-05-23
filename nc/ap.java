package nc;

import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxBatchLayerSelectedMediaInfoBean;
import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadQueueTaskInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MediaSortType;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012J,\u0010\u001a\u001a\u00020\b2\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lnc/ap;", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "stMedia", "", "o2", "Lo9/f;", "requestBean", "", "T1", "id", "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueResultListener;", "listener", "g2", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueTaskInfo;", "taskInfo", "N1", "", "", "q2", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxBatchLayerSelectedMediaInfoBean;", "Lkotlin/collections/ArrayList;", "selectorResult", "mediaWhenResult", "r2", "", "L", "Ljava/util/List;", "p2", "()Ljava/util/List;", "selectedModifyLocationBatchMedias", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ap extends com.qzone.reborn.albumx.common.viewmodel.e {

    /* renamed from: L, reason: from kotlin metadata */
    private final List<CommonStMedia> selectedModifyLocationBatchMedias = new ArrayList();

    private final String o2(CommonStMedia stMedia) {
        if (stMedia.u()) {
            return stMedia.getVideo().getCover().getLloc();
        }
        return stMedia.getImage().getLloc();
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.e
    public void N1(RFWDownloadQueueTaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        kc.b a16 = kc.b.INSTANCE.a();
        if (a16 != null) {
            a16.d(taskInfo);
        }
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.e
    public void T1(o9.f requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        if (requestBean instanceof wa.a) {
            ub.d.f438671a.g((wa.a) requestBean);
        }
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.e
    public void g2(String id5, RFWDownloadQueueResultListener listener) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(listener, "listener");
        kc.b a16 = kc.b.INSTANCE.a();
        if (a16 != null) {
            a16.r(id5, this);
        }
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.e
    public void n2(String id5, RFWDownloadQueueResultListener listener) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(listener, "listener");
        kc.b a16 = kc.b.INSTANCE.a();
        if (a16 != null) {
            a16.s(id5, this);
        }
    }

    public final List<CommonStMedia> p2() {
        return this.selectedModifyLocationBatchMedias;
    }

    public final void r2(ArrayList<QZAlbumxBatchLayerSelectedMediaInfoBean> selectorResult, QZAlbumxBatchLayerSelectedMediaInfoBean mediaWhenResult) {
        if (selectorResult == null) {
            QLog.e("CommonAlbumOperateViewModel", 1, "updateSelectedMedia selector result is null");
            return;
        }
        QLog.d("CommonAlbumOperateViewModel", 4, "updateSelectedMedia selector result size: " + selectorResult.size());
        h2();
        if (mediaWhenResult != null && selectorResult.size() == 0) {
            selectorResult.add(mediaWhenResult);
        }
        for (QZAlbumxBatchLayerSelectedMediaInfoBean qZAlbumxBatchLayerSelectedMediaInfoBean : selectorResult) {
            for (com.qzone.reborn.albumx.common.bean.a aVar : U1()) {
                String timeId = aVar.getTimeId();
                Iterator<CommonStMedia> it = aVar.getBatchInfo().j().iterator();
                while (true) {
                    if (it.hasNext()) {
                        CommonStMedia next = it.next();
                        if (Intrinsics.areEqual(qZAlbumxBatchLayerSelectedMediaInfoBean.getLloc(), o2(next))) {
                            O1(timeId, next);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final Map<Integer, Integer> q2() {
        Map<Integer, Integer> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(new Pair(Integer.valueOf(R.string.jim), Integer.valueOf(MediaSortType.KMEDIASORTTYPESHOOTTIMEDESC.ordinal())), new Pair(Integer.valueOf(R.string.jil), Integer.valueOf(MediaSortType.KMEDIASORTTYPESHOOTTIMEASC.ordinal())), new Pair(Integer.valueOf(R.string.jiq), Integer.valueOf(MediaSortType.KMEDIASORTTYPEUPLOADTIMEDESC.ordinal())), new Pair(Integer.valueOf(R.string.jip), Integer.valueOf(MediaSortType.KMEDIASORTTYPEUPLOADTIMEASC.ordinal())));
        return mapOf;
    }
}
