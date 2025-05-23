package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumBatchBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumCommData;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonBatchInfoBanner;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStCommonExt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStTimeLineEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album.AlbumBatchInfoConverterKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album.AlbumStMediaConverterKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.BatchInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b'\u0018\u0000 D2\u00020\u0001:\u0001DB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u000200H\u0002J\u0018\u0010:\u001a\u0002072\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u000200H\u0002J,\u0010;\u001a\u0002072\u0006\u00109\u001a\u0002002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\n2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\nH\u0004J\u001c\u0010@\u001a\u0002072\u0012\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0C0BH&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001dX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\n8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010\rR\u001e\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u0006E"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZAlbumDetailRepo;", "", "()V", "albumInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumInfo;", "getAlbumInfo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumInfo;", "setAlbumInfo", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumInfo;)V", "allBatch", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumBatchBean;", "getAllBatch", "()Ljava/util/List;", "commData", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumCommData;", "getCommData", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumCommData;", "setCommData", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumCommData;)V", "commonExt", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStCommonExt;", "getCommonExt", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStCommonExt;", "setCommonExt", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStCommonExt;)V", "curTimeline", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStTimeLineEvent;", "isTimeLineMode", "", "lastAlbumID", "", "getLastAlbumID", "()Ljava/lang/String;", "setLastAlbumID", "(Ljava/lang/String;)V", "lastIsCache", "getLastIsCache", "()Z", "setLastIsCache", "(Z)V", "lastIsFinish", "getLastIsFinish", "setLastIsFinish", "mediaInfoList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;", "getMediaInfoList", "sortType", "", "getSortType", "()Ljava/lang/Integer;", "setSortType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "generateBatchBannerInfo", "", "batchBean", "requestType", "generateBatchTimeLineId", "polymerizeStMediaListToBatchList", "stMediaList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "batchList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/BatchInfo;", "requestMore", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public abstract class QZAlbumDetailRepo {
    public static final int LOAD_TYPE_DOWN = 2;
    public static final int LOAD_TYPE_REFRESH = 1;
    public static final int LOAD_TYPE_UP = 3;
    public static final String TAG = "QZAlbumDetailRepo";
    private CommonAlbumInfo albumInfo;
    private CommonAlbumCommData commData;
    private CommonStCommonExt commonExt;
    private CommonStTimeLineEvent curTimeline;
    private boolean isTimeLineMode;
    private boolean lastIsCache;
    private boolean lastIsFinish;
    private Integer sortType;
    public static final int $stable = 8;
    private final List<CommonAlbumBatchBean> allBatch = new ArrayList();
    private String lastAlbumID = "";

    private final void generateBatchBannerInfo(CommonAlbumBatchBean batchBean, int requestType) {
        List<CommonAlbumBatchBean> reversed;
        batchBean.setBannerInfo(batchBean.getBatchInfo().getBanner());
        reversed = CollectionsKt___CollectionsKt.reversed(this.allBatch);
        for (CommonAlbumBatchBean commonAlbumBatchBean : reversed) {
            if (commonAlbumBatchBean.getBannerInfo().isSame(batchBean.getBannerInfo())) {
                if (requestType == 3) {
                    commonAlbumBatchBean.getBatchInfo().setBanner(new CommonBatchInfoBanner());
                } else {
                    batchBean.getBatchInfo().setBanner(new CommonBatchInfoBanner());
                }
            }
        }
    }

    private final void generateBatchTimeLineId(CommonAlbumBatchBean batchBean, int requestType) {
        List<CommonAlbumBatchBean> reversed;
        batchBean.setTimeId(batchBean.getBatchInfo().getShowTime());
        reversed = CollectionsKt___CollectionsKt.reversed(this.allBatch);
        for (CommonAlbumBatchBean commonAlbumBatchBean : reversed) {
            if (Intrinsics.areEqual(commonAlbumBatchBean.getTimeId(), batchBean.getBatchInfo().getShowTime())) {
                if (requestType == 3) {
                    commonAlbumBatchBean.getBatchInfo().setShowTime("");
                } else {
                    batchBean.getBatchInfo().setShowTime("");
                }
            }
        }
    }

    public final CommonAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public final List<CommonAlbumBatchBean> getAllBatch() {
        return this.allBatch;
    }

    public final CommonAlbumCommData getCommData() {
        return this.commData;
    }

    public final CommonStCommonExt getCommonExt() {
        return this.commonExt;
    }

    public final String getLastAlbumID() {
        return this.lastAlbumID;
    }

    public final boolean getLastIsCache() {
        return this.lastIsCache;
    }

    public final boolean getLastIsFinish() {
        return this.lastIsFinish;
    }

    public final List<CommonStMedia> getMediaInfoList() {
        ArrayList arrayList = new ArrayList();
        Iterator<CommonAlbumBatchBean> it = this.allBatch.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getBatchInfo().getMedias());
        }
        return arrayList;
    }

    public final Integer getSortType() {
        return this.sortType;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x017f A[LOOP:5: B:59:0x017d->B:60:0x017f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void polymerizeStMediaListToBatchList(int requestType, List<StMedia> stMediaList, List<BatchInfo> batchList) {
        int i3;
        int size;
        Long l3;
        Iterator<T> it = stMediaList.iterator();
        while (true) {
            i3 = 1;
            if (!it.hasNext()) {
                break;
            }
            StMedia stMedia = (StMedia) it.next();
            for (BatchInfo batchInfo : batchList) {
                Integer num = batchInfo.linkType;
                if (num != null && num.intValue() == 1) {
                    l3 = stMedia.linkId;
                } else {
                    l3 = stMedia.batchId;
                }
                if (Intrinsics.areEqual(l3, batchInfo.linkId)) {
                    batchInfo.medias.add(stMedia);
                }
            }
        }
        if (requestType == 3) {
            int size2 = batchList.size();
            if ((!batchList.isEmpty()) && (!this.allBatch.isEmpty())) {
                Long l16 = batchList.get(batchList.size() - 1).linkId;
                long linkId = this.allBatch.get(0).getBatchInfo().getLinkId();
                if (l16 != null && l16.longValue() == linkId) {
                    Iterator<T> it5 = batchList.get(batchList.size() - 1).medias.iterator();
                    while (it5.hasNext()) {
                        this.allBatch.get(0).getBatchInfo().getMedias().add(AlbumStMediaConverterKt.toCommonStMedia((StMedia) it5.next()));
                    }
                    size2 = batchList.size() - 1;
                }
            }
            KLog.INSTANCE.d(TAG, "polymerizeBatchListData  endMergeBatchPos = " + size2);
            for (int i16 = size2 - 1; -1 < i16; i16--) {
                CommonAlbumBatchBean commonAlbumBatchBean = new CommonAlbumBatchBean(AlbumBatchInfoConverterKt.toCommonBatchInfo(batchList.get(i16)));
                generateBatchTimeLineId(commonAlbumBatchBean, requestType);
                generateBatchBannerInfo(commonAlbumBatchBean, requestType);
                this.allBatch.add(0, commonAlbumBatchBean);
            }
            return;
        }
        if ((!batchList.isEmpty()) && (!this.allBatch.isEmpty())) {
            Long l17 = batchList.get(0).linkId;
            List<CommonAlbumBatchBean> list = this.allBatch;
            long linkId2 = list.get(list.size() - 1).getBatchInfo().getLinkId();
            if (l17 != null && l17.longValue() == linkId2) {
                for (StMedia stMedia2 : batchList.get(0).medias) {
                    List<CommonAlbumBatchBean> list2 = this.allBatch;
                    list2.get(list2.size() - 1).getBatchInfo().getMedias().add(AlbumStMediaConverterKt.toCommonStMedia(stMedia2));
                }
                KLog.INSTANCE.d(TAG, "polymerizeBatchListData  startMergeBatchPos = " + i3);
                size = batchList.size();
                while (i3 < size) {
                    CommonAlbumBatchBean commonAlbumBatchBean2 = new CommonAlbumBatchBean(AlbumBatchInfoConverterKt.toCommonBatchInfo(batchList.get(i3)));
                    generateBatchTimeLineId(commonAlbumBatchBean2, requestType);
                    generateBatchBannerInfo(commonAlbumBatchBean2, requestType);
                    this.allBatch.add(commonAlbumBatchBean2);
                    i3++;
                }
            }
        }
        i3 = 0;
        KLog.INSTANCE.d(TAG, "polymerizeBatchListData  startMergeBatchPos = " + i3);
        size = batchList.size();
        while (i3 < size) {
        }
    }

    public abstract void requestMore(DataCallback<List<CommonAlbumBatchBean>> dataCallback);

    public final void setAlbumInfo(CommonAlbumInfo commonAlbumInfo) {
        this.albumInfo = commonAlbumInfo;
    }

    public final void setCommData(CommonAlbumCommData commonAlbumCommData) {
        this.commData = commonAlbumCommData;
    }

    public final void setCommonExt(CommonStCommonExt commonStCommonExt) {
        this.commonExt = commonStCommonExt;
    }

    public final void setLastAlbumID(String str) {
        this.lastAlbumID = str;
    }

    public final void setLastIsCache(boolean z16) {
        this.lastIsCache = z16;
    }

    public final void setLastIsFinish(boolean z16) {
        this.lastIsFinish = z16;
    }

    public final void setSortType(Integer num) {
        this.sortType = num;
    }
}
