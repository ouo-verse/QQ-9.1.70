package com.qzone.reborn.part.publish.intimate.director;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.model.intimate.IntimateUploadAlbumInfo;
import com.qzone.publish.business.model.intimate.IntimateUploadAlbumParams;
import com.qzone.publish.business.model.intimate.IntimateUploadMediaInfo;
import com.qzone.publish.business.model.intimate.IntimateUploadPoiInfo;
import com.qzone.publish.business.model.intimate.IntimateUploadRequestParams;
import com.qzone.publish.business.model.intimate.IntimateUploadTaskParams;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.business.task.intimate.QZoneIntimateUploadAlbumPicTask;
import com.qzone.publish.business.task.intimate.QZoneIntimateUploadAlbumVideoTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateUploadAlbumInitBean;
import com.qzone.util.ag;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.l;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.Size;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseMeta$StFeed;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 P2\u00020\u0001:\u0001QB\u0007\u00a2\u0006\u0004\bN\u0010OJ\u0080\u0001\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\f2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002JZ\u0010#\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020!H\u0002Js\u0010&\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0$2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H\u0002\u00a2\u0006\u0004\b&\u0010'J\b\u0010)\u001a\u00020(H\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010\"\u001a\u00020!H\u0002Jt\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0$2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040$2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\f2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\fH\u0002J*\u0010/\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u00100\u001a\u00020\u0012*\u00020\u000eH\u0002J \u00102\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u00103\u001a\u00020\u0004H\u0016J\u000e\u00106\u001a\u00020\u00122\u0006\u00105\u001a\u000204J\u000e\u00108\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0004J.\u0010A\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040F8\u0006\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006R"}, d2 = {"Lcom/qzone/reborn/part/publish/intimate/director/h;", "Lcom/qzone/reborn/base/n;", "Landroid/content/Context;", "context", "", "content", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "poiInfo", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "albumInfo", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/HashMap;", "selectedMediaInfoMap", "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", "selectedVideoInfoMap", "Lcom/qzone/widget/dynamicgridview/DynamicArrayList;", "selectedImageList", "", "b2", "Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;", "params", "N1", "X1", "", "batchId", "clientKey", PhotoCategorySinglePicInfo.UPLOAD_TIME, "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaWrapper", "", "index", "size", "", "isPicTask", "c2", "", "mediaWrapperList", "P1", "(JLjava/lang/String;JLqzone/QZoneBaseAlbumMeta$AlbumInfo;Ljava/lang/String;Ljava/util/List;Lcooperation/qzone/LbsDataV2$PoiInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;", "Lcom/qzone/publish/business/model/intimate/IntimateUploadRequestParams;", "S1", "Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskParams;", "T1", "R1", "mediaInfo", QCircleScheme.AttrDetail.VIDEO_INFO, "W1", "O1", "mediaPath", "U1", "getLogTag", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateUploadAlbumInitBean;", "initBean", "e2", "spaceId", "f2", "Lcom/qzone/reborn/part/publish/common/inputarea/d;", "inputAreaVm", "Lsl/b;", "locationVm", "Lcom/qzone/reborn/part/publish/common/selectalbum/c;", "selectAlbumBarVm", "Ltl/h;", "mediaPickerVm", "Z1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_validAlert", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "d2", "()Landroidx/lifecycle/LiveData;", "validAlert", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateUploadAlbumInitBean;", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends n {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneIntimateUploadAlbumInitBean initBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<String> _validAlert;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<String> validAlert;

    public h() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._validAlert = mutableLiveData;
        this.validAlert = mutableLiveData;
    }

    private final void N1(IntimateUploadAlbumParams params) {
        com.qzone.publish.business.publishqueue.intimate.d dVar = com.qzone.publish.business.publishqueue.intimate.d.f51164a;
        String uid = LoginData.getInstance().getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "getInstance().uid");
        dVar.a(uid).a(params);
    }

    private final void O1(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        shuoshuoVideoInfo.setPublishParamsType("INTIMATE_ALBUM");
    }

    private final List<MediaWrapper> R1(Context context, String content, List<String> selectedImageList, HashMap<String, LocalMediaInfo> selectedMediaInfoMap, HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap) {
        ArrayList arrayList = new ArrayList();
        for (String str : selectedImageList) {
            if (!(str.length() == 0)) {
                LocalMediaInfo localMediaInfo = selectedMediaInfoMap.get(str);
                if (localMediaInfo == null) {
                    RFWLog.w("QZoneIntimateUploadAlbumViewModel", RFWLog.USR, "processUploadMediaList, mediaInfo is null, mediaPath:" + str);
                } else {
                    int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
                    if (mediaType == 0) {
                        arrayList.add(U1(str, localMediaInfo, content));
                    } else if (mediaType == 1) {
                        arrayList.add(W1(context, localMediaInfo, selectedVideoInfoMap.get(str), content));
                    }
                }
            }
        }
        return arrayList;
    }

    private final IntimateUploadRequestParams S1() {
        IntimateUploadRequestParams intimateUploadRequestParams = new IntimateUploadRequestParams(0, null, 0, null, null, 0, null, 127, null);
        ConcurrentHashMap<String, String> extendInfo = intimateUploadRequestParams.getExtendInfo();
        QZoneIntimateUploadAlbumInitBean qZoneIntimateUploadAlbumInitBean = this.initBean;
        if (qZoneIntimateUploadAlbumInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            qZoneIntimateUploadAlbumInitBean = null;
        }
        extendInfo.put("spaceID", qZoneIntimateUploadAlbumInitBean.getSpaceId());
        extendInfo.put("uid", LoginData.getInstance().getUid());
        return intimateUploadRequestParams;
    }

    private final IntimateUploadTaskParams T1(boolean isPicTask) {
        return new IntimateUploadTaskParams(isPicTask ? 7 : 28, isPicTask ? 2 : 16);
    }

    private final MediaWrapper U1(String mediaPath, LocalMediaInfo mediaInfo, String content) {
        ImageInfo imageInfo = new ImageInfo(mediaPath);
        imageInfo.mDescription = content;
        imageInfo.panoramaType = mediaInfo.panoramaPhotoType;
        imageInfo.photoWidth = mediaInfo.mediaWidth;
        imageInfo.photoHeight = mediaInfo.mediaHeight;
        MediaWrapper mediaWrapper = new MediaWrapper(imageInfo);
        mediaWrapper.setQuality(0);
        return mediaWrapper;
    }

    private final void X1(IntimateUploadAlbumParams params) {
        QZoneIntimateUploadAlbumInitBean qZoneIntimateUploadAlbumInitBean = null;
        QZoneBaseMeta$StFeed stFeed$default = IntimateUploadAlbumParams.toStFeed$default(params, oj.b.f423009a.a(params.getMediaWrapperList()), 0, 2, null);
        QZoneBaseCommon$StCommonExt c16 = oj.a.f423008a.c();
        QZoneIntimateUploadAlbumInitBean qZoneIntimateUploadAlbumInitBean2 = this.initBean;
        if (qZoneIntimateUploadAlbumInitBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
        } else {
            qZoneIntimateUploadAlbumInitBean = qZoneIntimateUploadAlbumInitBean2;
        }
        sm.h.g(qZoneIntimateUploadAlbumInitBean.getSpaceId(), stFeed$default, c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(h this$0, Context context, String content, LbsDataV2.PoiInfo poiInfo, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo, HashMap selectedMediaInfoMap, HashMap selectedVideoInfoMap, DynamicArrayList dynamicArrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(selectedVideoInfoMap, "$selectedVideoInfoMap");
        Intrinsics.checkNotNullExpressionValue(content, "content");
        Intrinsics.checkNotNullExpressionValue(selectedMediaInfoMap, "selectedMediaInfoMap");
        this$0.b2(context, content, poiInfo, qZoneBaseAlbumMeta$AlbumInfo, selectedMediaInfoMap, selectedVideoInfoMap, dynamicArrayList);
    }

    private final void c2(long batchId, String clientKey, long uploadTime, String content, QZoneBaseAlbumMeta$AlbumInfo albumInfo, MediaWrapper mediaWrapper, LbsDataV2.PoiInfo poiInfo, int index, int size, boolean isPicTask) {
        List<? extends MediaWrapper> listOf;
        QZoneQueueTask qZoneIntimateUploadAlbumVideoTask;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(mediaWrapper);
        IntimateUploadAlbumParams P1 = P1(batchId, clientKey, uploadTime, albumInfo, content, listOf, poiInfo, Integer.valueOf(index), Integer.valueOf(size), Boolean.valueOf(isPicTask));
        if (isPicTask) {
            qZoneIntimateUploadAlbumVideoTask = new QZoneIntimateUploadAlbumPicTask(P1);
        } else {
            qZoneIntimateUploadAlbumVideoTask = new QZoneIntimateUploadAlbumVideoTask(P1);
        }
        qZoneIntimateUploadAlbumVideoTask.addToTaskQueen();
    }

    public final boolean Z1(final Context context, com.qzone.reborn.part.publish.common.inputarea.d inputAreaVm, sl.b locationVm, com.qzone.reborn.part.publish.common.selectalbum.c selectAlbumBarVm, tl.h mediaPickerVm) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputAreaVm, "inputAreaVm");
        Intrinsics.checkNotNullParameter(locationVm, "locationVm");
        Intrinsics.checkNotNullParameter(selectAlbumBarVm, "selectAlbumBarVm");
        Intrinsics.checkNotNullParameter(mediaPickerVm, "mediaPickerVm");
        final String U1 = inputAreaVm.U1();
        final LbsDataV2.PoiInfo value = locationVm.O1().getValue();
        final QZoneBaseAlbumMeta$AlbumInfo value2 = selectAlbumBarVm.P1().getValue();
        final DynamicArrayList<String> value3 = mediaPickerVm.P1().getValue();
        final HashMap<String, LocalMediaInfo> Q1 = mediaPickerVm.Q1();
        HashMap<String, ShuoshuoVideoInfo> R1 = mediaPickerVm.R1();
        if (R1 == null) {
            R1 = new HashMap<>();
        }
        final HashMap<String, ShuoshuoVideoInfo> hashMap = R1;
        RFWLog.d("QZoneIntimateUploadAlbumViewModel", RFWLog.USR, "doUpload, albumInfo:" + value2 + ", selectedImageList:" + value3 + ", selectedMediaInfoMap:" + Q1 + ", selectedVideoInfoMap:" + hashMap);
        if (value2 == null) {
            this._validAlert.postValue(l.a(R.string.f2195566q));
            return false;
        }
        if (value3 == null || Q1 == null) {
            return false;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.part.publish.intimate.director.g
            @Override // java.lang.Runnable
            public final void run() {
                h.a2(h.this, context, U1, value, value2, Q1, hashMap, value3);
            }
        });
        return true;
    }

    public final LiveData<String> d2() {
        return this.validAlert;
    }

    public final void e2(QZoneIntimateUploadAlbumInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
    }

    public final void f2(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        QZoneIntimateUploadAlbumInitBean qZoneIntimateUploadAlbumInitBean = this.initBean;
        if (qZoneIntimateUploadAlbumInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            qZoneIntimateUploadAlbumInitBean = null;
        }
        qZoneIntimateUploadAlbumInitBean.setSpaceId(spaceId);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateUploadAlbumViewModel";
    }

    private final IntimateUploadAlbumParams P1(long batchId, String clientKey, long uploadTime, QZoneBaseAlbumMeta$AlbumInfo albumInfo, String content, List<? extends MediaWrapper> mediaWrapperList, LbsDataV2.PoiInfo poiInfo, Integer index, Integer size, Boolean isPicTask) {
        int collectionSizeOrDefault;
        QZoneIntimateUploadAlbumInitBean qZoneIntimateUploadAlbumInitBean = this.initBean;
        if (qZoneIntimateUploadAlbumInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            qZoneIntimateUploadAlbumInitBean = null;
        }
        String spaceId = qZoneIntimateUploadAlbumInitBean.getSpaceId();
        IntimateUploadAlbumInfo a16 = IntimateUploadAlbumInfo.INSTANCE.a(albumInfo);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(mediaWrapperList);
        Unit unit = Unit.INSTANCE;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        List<? extends MediaWrapper> list = mediaWrapperList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(IntimateUploadMediaInfo.INSTANCE.a((MediaWrapper) it.next()));
        }
        copyOnWriteArrayList.addAll(arrayList2);
        Unit unit2 = Unit.INSTANCE;
        IntimateUploadAlbumParams intimateUploadAlbumParams = new IntimateUploadAlbumParams(batchId, clientKey, spaceId, a16, content, arrayList, copyOnWriteArrayList, IntimateUploadPoiInfo.INSTANCE.a(poiInfo), uploadTime, 0, 0, S1(), null, 5632, null);
        if (index != null) {
            intimateUploadAlbumParams.setCurNum(index.intValue());
        }
        if (size != null) {
            intimateUploadAlbumParams.setMaxNum(size.intValue());
        }
        if (isPicTask != null) {
            intimateUploadAlbumParams.setTaskParams(T1(isPicTask.booleanValue()));
        }
        return intimateUploadAlbumParams;
    }

    private final MediaWrapper W1(Context context, LocalMediaInfo mediaInfo, ShuoshuoVideoInfo videoInfo, String content) {
        ShuoshuoVideoInfo createVideoMediaWrapper$lambda$15;
        Size b16 = f6.b.b(mediaInfo);
        if (videoInfo != null) {
            videoInfo.mVideoWidth = b16.width;
            videoInfo.mVideoHeight = b16.height;
            O1(videoInfo);
            createVideoMediaWrapper$lambda$15 = videoInfo;
        } else {
            long j3 = mediaInfo._id;
            String str = mediaInfo.path;
            long j16 = mediaInfo.fileSize;
            int i3 = b16.height;
            int i16 = b16.width;
            long j17 = mediaInfo.mDuration;
            createVideoMediaWrapper$lambda$15 = ag.p(context, j3, str, j16, 1, null, i3, i16, 0L, j17, j17, false, null);
            Intrinsics.checkNotNullExpressionValue(createVideoMediaWrapper$lambda$15, "createVideoMediaWrapper$lambda$15");
            O1(createVideoMediaWrapper$lambda$15);
        }
        MediaWrapper mediaWrapper = new MediaWrapper(createVideoMediaWrapper$lambda$15);
        mediaWrapper.setQuality(0);
        return mediaWrapper;
    }

    private final void b2(Context context, String content, LbsDataV2.PoiInfo poiInfo, QZoneBaseAlbumMeta$AlbumInfo albumInfo, HashMap<String, LocalMediaInfo> selectedMediaInfoMap, HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap, DynamicArrayList<String> selectedImageList) {
        List<MediaWrapper> R1 = R1(context, content, selectedImageList, selectedMediaInfoMap, selectedVideoInfoMap);
        if (R1.isEmpty()) {
            RFWLog.w("QZoneIntimateUploadAlbumViewModel", RFWLog.USR, "doUploadInternal, mediaList is empty ");
            return;
        }
        long a16 = r7.a.a();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        RFWLog.d("QZoneIntimateUploadAlbumViewModel", RFWLog.USR, "doUploadInternal, batchId:" + a16 + ", clientKey:" + uuid + ", size:" + R1.size());
        IntimateUploadAlbumParams Q1 = Q1(this, a16, uuid, currentTimeMillis, albumInfo, content, R1, poiInfo, null, null, null, 896, null);
        N1(Q1);
        X1(Q1);
        int i3 = 0;
        for (Object obj : R1) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MediaWrapper mediaWrapper = (MediaWrapper) obj;
            c2(a16, uuid, currentTimeMillis, content, albumInfo, mediaWrapper, poiInfo, i3, R1.size(), mediaWrapper.isImage());
            i3 = i16;
        }
    }

    static /* synthetic */ IntimateUploadAlbumParams Q1(h hVar, long j3, String str, long j16, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo, String str2, List list, LbsDataV2.PoiInfo poiInfo, Integer num, Integer num2, Boolean bool, int i3, Object obj) {
        return hVar.P1(j3, str, j16, qZoneBaseAlbumMeta$AlbumInfo, str2, list, poiInfo, (i3 & 128) != 0 ? null : num, (i3 & 256) != 0 ? null : num2, (i3 & 512) != 0 ? null : bool);
    }
}
