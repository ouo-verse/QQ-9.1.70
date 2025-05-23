package com.qzone.reborn.groupalbum.upload;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumInfo;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadRequestParams;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadTaskParams;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.business.task.groupalbum.GroupAlbumUploadAlbumPicTask;
import com.qzone.publish.business.task.groupalbum.GroupAlbumUploadAlbumVideoTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.common.bean.CommonAlbumUploadMediaInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumUploadPoiInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.base.n;
import com.qzone.reborn.groupalbum.bean.init.GroupUploadAlbumInitBean;
import com.qzone.reborn.groupalbum.event.GroupAlbumStartPublishNotifyEvent;
import com.qzone.reborn.part.publish.common.inputarea.d;
import com.qzone.util.ag;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.l;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import common.config.service.QzoneConfig;
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
import tl.h;
import z8.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 ^2\u00020\u0001:\u0001_B\u0007\u00a2\u0006\u0004\b\\\u0010]J\u0080\u0001\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\f2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0002JZ\u0010$\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\"H\u0002J}\u0010(\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0%2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010'\u001a\u00020\u001fH\u0002\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020*2\u0006\u0010'\u001a\u00020\u001fH\u0002J\u0010\u0010-\u001a\u00020,2\u0006\u0010#\u001a\u00020\"H\u0002Jt\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001d0%2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040%2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\f2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\fH\u0002J*\u00101\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u00102\u001a\u00020\u0012*\u00020\u000eH\u0002J \u00104\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u00020\u0004H\u0016J\u000e\u00108\u001a\u00020\u00122\u0006\u00107\u001a\u000206J.\u0010A\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040F8\u0006\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\"\u0010R\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010V\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010M\u001a\u0004\bT\u0010O\"\u0004\bU\u0010QR\u0014\u0010Y\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[\u00a8\u0006`"}, d2 = {"Lcom/qzone/reborn/groupalbum/upload/c;", "Lcom/qzone/reborn/base/n;", "Landroid/content/Context;", "context", "", "content", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "poiInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/HashMap;", "selectedMediaInfoMap", "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", "selectedVideoInfoMap", "Lcom/qzone/widget/dynamicgridview/DynamicArrayList;", "selectedImageList", "", "b2", SemanticAttributes.DbSystemValues.H2, "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "params", "N1", "X1", "", "batchId", "clientKey", PhotoCategorySinglePicInfo.UPLOAD_TIME, "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaWrapper", "", "index", "size", "", "isPicTask", "c2", "", "mediaWrapperList", "picQuality", "P1", "(JLjava/lang/String;JLcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;Ljava/lang/String;Ljava/util/List;Lcooperation/qzone/LbsDataV2$PoiInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;I)Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadRequestParams;", "S1", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskParams;", "T1", "R1", "mediaInfo", QCircleScheme.AttrDetail.VIDEO_INFO, "W1", "O1", "mediaPath", "U1", "getLogTag", "Lcom/qzone/reborn/groupalbum/bean/init/GroupUploadAlbumInitBean;", "initBean", "g2", "Lcom/qzone/reborn/part/publish/common/inputarea/d;", "inputAreaVm", "Lsl/b;", "locationVm", "Lcom/qzone/reborn/groupalbum/upload/selectalbum/f;", "selectAlbumBarVm", "Ltl/h;", "mediaPickerVm", "Z1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_validAlert", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "f2", "()Landroidx/lifecycle/LiveData;", "validAlert", BdhLogUtil.LogTag.Tag_Conn, "I", "d2", "()I", "i2", "(I)V", "currentImageUploadQuality", "D", "e2", "j2", "currentVideoUploadQuality", "E", "J", "UPLOAD_RAW_VIDEO_MAX_SIZE", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/groupalbum/bean/init/GroupUploadAlbumInitBean;", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends n {

    /* renamed from: C, reason: from kotlin metadata */
    private int currentImageUploadQuality;

    /* renamed from: D, reason: from kotlin metadata */
    private int currentVideoUploadQuality;

    /* renamed from: E, reason: from kotlin metadata */
    private final long UPLOAD_RAW_VIDEO_MAX_SIZE;

    /* renamed from: F, reason: from kotlin metadata */
    private GroupUploadAlbumInitBean initBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<String> _validAlert;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<String> validAlert;

    public c() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._validAlert = mutableLiveData;
        this.validAlert = mutableLiveData;
        this.UPLOAD_RAW_VIDEO_MAX_SIZE = QzoneConfig.getUploadRawVideoByte();
    }

    private final void N1(GroupAlbumUploadAlbumParams params) {
        f fVar = f.f452141a;
        String uid = LoginData.getInstance().getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "getInstance().uid");
        fVar.a(uid).a(params);
    }

    private final void O1(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        shuoshuoVideoInfo.setPublishParamsType("INTIMATE_ALBUM");
    }

    private final GroupAlbumUploadAlbumParams P1(long batchId, String clientKey, long uploadTime, CommonAlbumInfo albumInfo, String content, List<? extends MediaWrapper> mediaWrapperList, LbsDataV2.PoiInfo poiInfo, Integer index, Integer size, Boolean isPicTask, int picQuality) {
        int collectionSizeOrDefault;
        GroupUploadAlbumInitBean groupUploadAlbumInitBean = this.initBean;
        if (groupUploadAlbumInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupUploadAlbumInitBean = null;
        }
        String groupId = groupUploadAlbumInitBean.getGroupId();
        GroupAlbumUploadAlbumInfo a16 = GroupAlbumUploadAlbumInfo.INSTANCE.a(albumInfo);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(mediaWrapperList);
        Unit unit = Unit.INSTANCE;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        List<? extends MediaWrapper> list = mediaWrapperList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(CommonAlbumUploadMediaInfo.INSTANCE.a((MediaWrapper) it.next()));
        }
        copyOnWriteArrayList.addAll(arrayList2);
        Unit unit2 = Unit.INSTANCE;
        GroupAlbumUploadAlbumParams groupAlbumUploadAlbumParams = new GroupAlbumUploadAlbumParams(batchId, clientKey, groupId, a16, content, arrayList, copyOnWriteArrayList, CommonAlbumUploadPoiInfo.INSTANCE.a(poiInfo), uploadTime, 0, 0, S1(picQuality), null, 5632, null);
        if (index != null) {
            groupAlbumUploadAlbumParams.setCurNum(index.intValue());
        }
        if (size != null) {
            groupAlbumUploadAlbumParams.setMaxNum(size.intValue());
        }
        if (isPicTask != null) {
            groupAlbumUploadAlbumParams.setTaskParams(T1(isPicTask.booleanValue()));
        }
        return groupAlbumUploadAlbumParams;
    }

    static /* synthetic */ GroupAlbumUploadAlbumParams Q1(c cVar, long j3, String str, long j16, CommonAlbumInfo commonAlbumInfo, String str2, List list, LbsDataV2.PoiInfo poiInfo, Integer num, Integer num2, Boolean bool, int i3, int i16, Object obj) {
        return cVar.P1(j3, str, j16, commonAlbumInfo, str2, list, poiInfo, (i16 & 128) != 0 ? null : num, (i16 & 256) != 0 ? null : num2, (i16 & 512) != 0 ? null : bool, (i16 & 1024) != 0 ? 0 : i3);
    }

    private final List<MediaWrapper> R1(Context context, String content, List<String> selectedImageList, HashMap<String, LocalMediaInfo> selectedMediaInfoMap, HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap) {
        ArrayList arrayList = new ArrayList();
        for (String str : selectedImageList) {
            if (!(str.length() == 0)) {
                LocalMediaInfo localMediaInfo = selectedMediaInfoMap.get(str);
                if (localMediaInfo == null) {
                    RFWLog.w("GroupUploadAlbumViewModel", RFWLog.USR, "processUploadMediaList, mediaInfo is null, mediaPath:" + str);
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

    private final GroupAlbumUploadRequestParams S1(int picQuality) {
        GroupAlbumUploadRequestParams groupAlbumUploadRequestParams = new GroupAlbumUploadRequestParams(0, null, 0, null, null, 0, null, 127, null);
        ConcurrentHashMap<String, String> extendInfo = groupAlbumUploadRequestParams.getExtendInfo();
        GroupUploadAlbumInitBean groupUploadAlbumInitBean = this.initBean;
        if (groupUploadAlbumInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupUploadAlbumInitBean = null;
        }
        extendInfo.put("group_id", groupUploadAlbumInitBean.getGroupId());
        extendInfo.put("uid", LoginData.getInstance().getUid());
        groupAlbumUploadRequestParams.setPicQuality(picQuality);
        return groupAlbumUploadRequestParams;
    }

    private final GroupAlbumUploadTaskParams T1(boolean isPicTask) {
        return new GroupAlbumUploadTaskParams(isPicTask ? 7 : 28, isPicTask ? 2 : 16);
    }

    private final MediaWrapper U1(String mediaPath, LocalMediaInfo mediaInfo, String content) {
        ImageInfo imageInfo = new ImageInfo(mediaPath);
        imageInfo.mDescription = content;
        imageInfo.panoramaType = mediaInfo.panoramaPhotoType;
        imageInfo.photoWidth = mediaInfo.mediaWidth;
        imageInfo.photoHeight = mediaInfo.mediaHeight;
        MediaWrapper mediaWrapper = new MediaWrapper(imageInfo);
        mediaWrapper.setQuality(this.currentImageUploadQuality);
        if (mediaWrapper.getQuality() == 3) {
            u5.b.q0("photo_quality_sp_key_" + LoginData.getInstance().getUin(), 1);
        }
        return mediaWrapper;
    }

    private final void X1(GroupAlbumUploadAlbumParams params) {
        fj.n nVar = fj.n.f399459a;
        GroupUploadAlbumInitBean groupUploadAlbumInitBean = this.initBean;
        if (groupUploadAlbumInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupUploadAlbumInitBean = null;
        }
        nVar.h(groupUploadAlbumInitBean.getGroupId(), params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(c this$0, Context context, String content, LbsDataV2.PoiInfo poiInfo, CommonAlbumInfo commonAlbumInfo, HashMap selectedMediaInfoMap, HashMap selectedVideoInfoMap, DynamicArrayList dynamicArrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(selectedVideoInfoMap, "$selectedVideoInfoMap");
        Intrinsics.checkNotNullExpressionValue(content, "content");
        Intrinsics.checkNotNullExpressionValue(selectedMediaInfoMap, "selectedMediaInfoMap");
        this$0.b2(context, content, poiInfo, commonAlbumInfo, selectedMediaInfoMap, selectedVideoInfoMap, dynamicArrayList);
    }

    private final void c2(long batchId, String clientKey, long uploadTime, String content, CommonAlbumInfo albumInfo, MediaWrapper mediaWrapper, LbsDataV2.PoiInfo poiInfo, int index, int size, boolean isPicTask) {
        List<? extends MediaWrapper> listOf;
        QZoneQueueTask groupAlbumUploadAlbumVideoTask;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(mediaWrapper);
        GroupAlbumUploadAlbumParams P1 = P1(batchId, clientKey, uploadTime, albumInfo, content, listOf, poiInfo, Integer.valueOf(index), Integer.valueOf(size), Boolean.valueOf(isPicTask), mediaWrapper.getQuality());
        if (isPicTask) {
            groupAlbumUploadAlbumVideoTask = new GroupAlbumUploadAlbumPicTask(P1);
        } else {
            groupAlbumUploadAlbumVideoTask = new GroupAlbumUploadAlbumVideoTask(P1);
        }
        groupAlbumUploadAlbumVideoTask.addToTaskQueen();
    }

    private final void h2() {
        SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumStartPublishNotifyEvent());
    }

    public final boolean Z1(final Context context, d inputAreaVm, sl.b locationVm, com.qzone.reborn.groupalbum.upload.selectalbum.f selectAlbumBarVm, h mediaPickerVm) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputAreaVm, "inputAreaVm");
        Intrinsics.checkNotNullParameter(locationVm, "locationVm");
        Intrinsics.checkNotNullParameter(selectAlbumBarVm, "selectAlbumBarVm");
        Intrinsics.checkNotNullParameter(mediaPickerVm, "mediaPickerVm");
        final String U1 = inputAreaVm.U1();
        final LbsDataV2.PoiInfo value = locationVm.O1().getValue();
        final CommonAlbumInfo value2 = selectAlbumBarVm.P1().getValue();
        final DynamicArrayList<String> value3 = mediaPickerVm.P1().getValue();
        final HashMap<String, LocalMediaInfo> Q1 = mediaPickerVm.Q1();
        HashMap<String, ShuoshuoVideoInfo> R1 = mediaPickerVm.R1();
        if (R1 == null) {
            R1 = new HashMap<>();
        }
        final HashMap<String, ShuoshuoVideoInfo> hashMap = R1;
        RFWLog.d("GroupUploadAlbumViewModel", RFWLog.USR, "doUpload, albumInfo:" + value2 + ", selectedImageList:" + value3 + ", selectedMediaInfoMap:" + Q1 + ", selectedVideoInfoMap:" + hashMap);
        if (value2 == null) {
            this._validAlert.postValue(l.a(R.string.f2195566q));
            return false;
        }
        if (value3 == null || Q1 == null) {
            return false;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.groupalbum.upload.b
            @Override // java.lang.Runnable
            public final void run() {
                c.a2(c.this, context, U1, value, value2, Q1, hashMap, value3);
            }
        });
        return true;
    }

    /* renamed from: d2, reason: from getter */
    public final int getCurrentImageUploadQuality() {
        return this.currentImageUploadQuality;
    }

    /* renamed from: e2, reason: from getter */
    public final int getCurrentVideoUploadQuality() {
        return this.currentVideoUploadQuality;
    }

    public final LiveData<String> f2() {
        return this.validAlert;
    }

    public final void g2(GroupUploadAlbumInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupUploadAlbumViewModel";
    }

    public final void i2(int i3) {
        this.currentImageUploadQuality = i3;
    }

    public final void j2(int i3) {
        this.currentVideoUploadQuality = i3;
    }

    private final MediaWrapper W1(Context context, LocalMediaInfo mediaInfo, ShuoshuoVideoInfo videoInfo, String content) {
        ShuoshuoVideoInfo createVideoMediaWrapper$lambda$15;
        Size b16 = f6.b.b(mediaInfo);
        if (videoInfo != null) {
            videoInfo.mVideoWidth = b16.width;
            videoInfo.mVideoHeight = b16.height;
            videoInfo.mDesc = content;
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
        int i17 = this.currentVideoUploadQuality;
        if (i17 == 3) {
            ShuoshuoVideoInfo videoInfo2 = mediaWrapper.getVideoInfo();
            Intrinsics.checkNotNull(videoInfo2);
            if (videoInfo2.mSize <= this.UPLOAD_RAW_VIDEO_MAX_SIZE) {
                mediaWrapper.getVideoInfo().mIsUploadOrigin = true;
                mediaWrapper.setQuality(this.currentVideoUploadQuality);
            } else {
                mediaWrapper.getVideoInfo().mIsUploadOrigin = false;
                mediaWrapper.setQuality(0);
            }
        } else {
            mediaWrapper.setQuality(i17);
        }
        return mediaWrapper;
    }

    private final void b2(Context context, String content, LbsDataV2.PoiInfo poiInfo, CommonAlbumInfo albumInfo, HashMap<String, LocalMediaInfo> selectedMediaInfoMap, HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap, DynamicArrayList<String> selectedImageList) {
        List<MediaWrapper> R1 = R1(context, content, selectedImageList, selectedMediaInfoMap, selectedVideoInfoMap);
        if (R1.isEmpty()) {
            RFWLog.w("GroupUploadAlbumViewModel", RFWLog.USR, "doUploadInternal, mediaList is empty ");
            return;
        }
        long b16 = r7.a.b();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        RFWLog.d("GroupUploadAlbumViewModel", RFWLog.USR, "doUploadInternal, batchId:" + b16 + ", clientKey:" + uuid + ", size:" + R1.size());
        GroupAlbumUploadAlbumParams Q1 = Q1(this, b16, uuid, currentTimeMillis, albumInfo, content, R1, poiInfo, null, null, null, 0, 1920, null);
        N1(Q1);
        X1(Q1);
        h2();
        int i3 = 0;
        for (Object obj : R1) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MediaWrapper mediaWrapper = (MediaWrapper) obj;
            c2(b16, uuid, currentTimeMillis, content, albumInfo, mediaWrapper, poiInfo, i3, R1.size(), mediaWrapper.isImage());
            i3 = i16;
        }
    }
}
