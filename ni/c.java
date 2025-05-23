package ni;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumInfo;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadRequestParams;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadTaskParams;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.common.bean.CommonAlbumUploadMediaInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumUploadPoiInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.base.n;
import com.qzone.reborn.groupalbum.reship.bean.GroupAIOReshipInitBean;
import com.qzone.reborn.groupalbum.reship.manager.GroupAlbumReshipSendBoxManager;
import com.qzone.reborn.part.publish.common.mediapick.QZoneMediaPickInfo;
import com.qzone.util.ag;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.l;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceQuoteToQunAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTQuoteToQunAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.NTQuoteToQunAlbumRsp;
import com.tencent.qqnt.kernel.nativeinterface.QuoteToQunAlbumUnit;
import com.tencent.qqnt.kernel.nativeinterface.RequestTimelineInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.ForwardGroupAlbumBean;
import cooperation.qzone.model.ForwardMediaInfo;
import cooperation.qzone.model.Size;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import fj.r;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 S2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\u0080\u0001\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\f2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017H\u0002Js\u0010&\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$H\u0002\u00a2\u0006\u0004\b&\u0010'J\b\u0010)\u001a\u00020(H\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010%\u001a\u00020$H\u0002J@\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u001f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\fH\u0002Jt\u0010.\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\f2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\fH\u0002J*\u00101\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u00102\u001a\u00020\u0012*\u00020\u000eH\u0002J \u00104\u001a\u00020 2\u0006\u00103\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u00020\u0004H\u0016J\u000e\u00108\u001a\u00020\u00122\u0006\u00107\u001a\u000206J\u0012\u0010;\u001a\u0004\u0018\u00010:2\b\u0010/\u001a\u0004\u0018\u000109J.\u0010D\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020BR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040I8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006U"}, d2 = {"Lni/c;", "Lcom/qzone/reborn/base/n;", "Landroid/content/Context;", "context", "", "content", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "poiInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/HashMap;", "selectedMediaInfoMap", "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", "selectedVideoInfoMap", "Lcom/qzone/widget/dynamicgridview/DynamicArrayList;", "selectedImageList", "", "f2", "", "errorCode", "c2", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "params", "O1", "b2", "", "batchId", "clientKey", PhotoCategorySinglePicInfo.UPLOAD_TIME, "", "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaWrapperList", "index", "size", "", "isPicTask", "S1", "(JLjava/lang/String;JLcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;Ljava/lang/String;Ljava/util/List;Lcooperation/qzone/LbsDataV2$PoiInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadRequestParams;", "W1", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskParams;", "X1", "Lcom/tencent/qqnt/kernel/nativeinterface/QuoteToQunAlbumUnit;", "R1", "U1", "mediaInfo", QCircleScheme.AttrDetail.VIDEO_INFO, ICustomDataEditor.STRING_ARRAY_PARAM_2, "Q1", "mediaPath", "Z1", "getLogTag", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAIOReshipInitBean;", "initBean", "i2", "Lcooperation/qzone/model/ForwardGroupAlbumBean;", "Lcom/qzone/reborn/part/publish/common/mediapick/QZoneMediaPickInfo;", "P1", "Lcom/qzone/reborn/part/publish/common/inputarea/d;", "inputAreaVm", "Lsl/b;", "locationVm", "Lcom/qzone/reborn/groupalbum/upload/selectalbum/f;", "selectAlbumBarVm", "Ltl/h;", "mediaPickerVm", "d2", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_validAlert", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", SemanticAttributes.DbSystemValues.H2, "()Landroidx/lifecycle/LiveData;", "validAlert", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAIOReshipInitBean;", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends n {

    /* renamed from: C, reason: from kotlin metadata */
    private GroupAIOReshipInitBean initBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<String> _validAlert;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<String> validAlert;

    public c() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._validAlert = mutableLiveData;
        this.validAlert = mutableLiveData;
    }

    private final void O1(GroupAlbumUploadAlbumParams params) {
        z8.f fVar = z8.f.f452141a;
        String uid = LoginData.getInstance().getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "getInstance().uid");
        fVar.a(uid).a(params);
    }

    private final void Q1(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        shuoshuoVideoInfo.setPublishParamsType("INTIMATE_ALBUM");
    }

    private final List<QuoteToQunAlbumUnit> R1(List<String> selectedImageList, HashMap<String, LocalMediaInfo> selectedMediaInfoMap) {
        ArrayList arrayList = new ArrayList();
        for (String str : selectedImageList) {
            if (!(str.length() == 0)) {
                LocalMediaInfo localMediaInfo = selectedMediaInfoMap.get(str);
                if (localMediaInfo == null) {
                    RFWLog.w("GroupAIOReshipAlbumViewModel", RFWLog.USR, "processQuoteToQunAlbumUnitList, mediaInfo is null, mediaPath:" + str);
                } else if (localMediaInfo.mDuration > 0) {
                    QuoteToQunAlbumUnit quoteToQunAlbumUnit = new QuoteToQunAlbumUnit();
                    quoteToQunAlbumUnit.mediaType = 1;
                    quoteToQunAlbumUnit.mediaSize = localMediaInfo.fileSize;
                    quoteToQunAlbumUnit.width = localMediaInfo.mediaWidth;
                    quoteToQunAlbumUnit.height = localMediaInfo.mediaHeight;
                    quoteToQunAlbumUnit.sha1 = "0000000000000000000000000000000000000000";
                    quoteToQunAlbumUnit.mediaName = new File(localMediaInfo.path).getName();
                    Serializable serializable = localMediaInfo.extData.get("storeID");
                    Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type kotlin.Int");
                    quoteToQunAlbumUnit.storeId = ((Integer) serializable).intValue();
                    quoteToQunAlbumUnit.duration = (int) (localMediaInfo.mDuration / 1000);
                    Serializable serializable2 = localMediaInfo.extData.get("uin");
                    Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type kotlin.Long");
                    quoteToQunAlbumUnit.uin = ((Long) serializable2).longValue();
                    quoteToQunAlbumUnit.dittoUin = (String) localMediaInfo.extData.get("dittoUin");
                    quoteToQunAlbumUnit.mediaId = (String) localMediaInfo.extData.get("extFileUUID");
                    quoteToQunAlbumUnit.mediaMd5 = (String) localMediaInfo.extData.get("extVideoMd5");
                    arrayList.add(quoteToQunAlbumUnit);
                } else {
                    QuoteToQunAlbumUnit quoteToQunAlbumUnit2 = new QuoteToQunAlbumUnit();
                    quoteToQunAlbumUnit2.mediaType = 0;
                    quoteToQunAlbumUnit2.mediaSize = localMediaInfo.fileSize;
                    quoteToQunAlbumUnit2.width = localMediaInfo.mediaWidth;
                    quoteToQunAlbumUnit2.height = localMediaInfo.mediaHeight;
                    quoteToQunAlbumUnit2.sha1 = "0000000000000000000000000000000000000000";
                    quoteToQunAlbumUnit2.mediaName = new File(localMediaInfo.path).getName();
                    Serializable serializable3 = localMediaInfo.extData.get("storeID");
                    Intrinsics.checkNotNull(serializable3, "null cannot be cast to non-null type kotlin.Int");
                    quoteToQunAlbumUnit2.storeId = ((Integer) serializable3).intValue();
                    quoteToQunAlbumUnit2.duration = 0;
                    Serializable serializable4 = localMediaInfo.extData.get("uin");
                    Intrinsics.checkNotNull(serializable4, "null cannot be cast to non-null type kotlin.Long");
                    quoteToQunAlbumUnit2.uin = ((Long) serializable4).longValue();
                    quoteToQunAlbumUnit2.dittoUin = (String) localMediaInfo.extData.get("dittoUin");
                    quoteToQunAlbumUnit2.mediaId = (String) localMediaInfo.extData.get("extFileUUID");
                    quoteToQunAlbumUnit2.mediaMd5 = (String) localMediaInfo.extData.get("extImageMd5");
                    arrayList.add(quoteToQunAlbumUnit2);
                }
            }
        }
        return arrayList;
    }

    private final List<MediaWrapper> U1(Context context, String content, List<String> selectedImageList, HashMap<String, LocalMediaInfo> selectedMediaInfoMap, HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap) {
        ArrayList arrayList = new ArrayList();
        for (String str : selectedImageList) {
            if (!(str.length() == 0)) {
                LocalMediaInfo localMediaInfo = selectedMediaInfoMap.get(str);
                if (localMediaInfo == null) {
                    RFWLog.w("GroupAIOReshipAlbumViewModel", RFWLog.USR, "processUploadMediaList, mediaInfo is null, mediaPath:" + str);
                } else if (localMediaInfo.mDuration > 0) {
                    arrayList.add(a2(context, localMediaInfo, selectedVideoInfoMap.get(str), content));
                } else {
                    arrayList.add(Z1(str, localMediaInfo, content));
                }
            }
        }
        return arrayList;
    }

    private final GroupAlbumUploadRequestParams W1() {
        GroupAlbumUploadRequestParams groupAlbumUploadRequestParams = new GroupAlbumUploadRequestParams(0, null, 0, null, null, 0, null, 127, null);
        ConcurrentHashMap<String, String> extendInfo = groupAlbumUploadRequestParams.getExtendInfo();
        GroupAIOReshipInitBean groupAIOReshipInitBean = this.initBean;
        if (groupAIOReshipInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAIOReshipInitBean = null;
        }
        extendInfo.put("group_id", groupAIOReshipInitBean.getGroupId());
        extendInfo.put("uid", LoginData.getInstance().getUid());
        return groupAlbumUploadRequestParams;
    }

    private final GroupAlbumUploadTaskParams X1(boolean isPicTask) {
        return new GroupAlbumUploadTaskParams(isPicTask ? 7 : 28, isPicTask ? 2 : 16);
    }

    private final MediaWrapper Z1(String mediaPath, LocalMediaInfo mediaInfo, String content) {
        ImageInfo imageInfo = new ImageInfo(mediaPath);
        imageInfo.mDescription = content;
        imageInfo.panoramaType = mediaInfo.panoramaPhotoType;
        MediaWrapper mediaWrapper = new MediaWrapper(imageInfo);
        mediaWrapper.setQuality(0);
        return mediaWrapper;
    }

    private final void b2(GroupAlbumUploadAlbumParams params) {
        fj.n nVar = fj.n.f399459a;
        GroupAIOReshipInitBean groupAIOReshipInitBean = this.initBean;
        if (groupAIOReshipInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAIOReshipInitBean = null;
        }
        nVar.h(groupAIOReshipInitBean.getGroupId(), params);
    }

    private final void c2(int errorCode) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("quote_success", Integer.valueOf(errorCode == 0 ? 1 : 0));
        linkedHashMap.put("fail_error_code", Integer.valueOf(errorCode));
        fo.c.c("ev_qun_album_on_aio_quote_to_album", linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(c this$0, Context context, String content, LbsDataV2.PoiInfo poiInfo, CommonAlbumInfo commonAlbumInfo, HashMap selectedMediaInfoMap, HashMap selectedVideoInfoMap, DynamicArrayList dynamicArrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(selectedMediaInfoMap, "$selectedMediaInfoMap");
        Intrinsics.checkNotNullParameter(selectedVideoInfoMap, "$selectedVideoInfoMap");
        Intrinsics.checkNotNullExpressionValue(content, "content");
        this$0.f2(context, content, poiInfo, commonAlbumInfo, selectedMediaInfoMap, selectedVideoInfoMap, dynamicArrayList);
    }

    public final boolean d2(final Context context, com.qzone.reborn.part.publish.common.inputarea.d inputAreaVm, sl.b locationVm, com.qzone.reborn.groupalbum.upload.selectalbum.f selectAlbumBarVm, tl.h mediaPickerVm) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputAreaVm, "inputAreaVm");
        Intrinsics.checkNotNullParameter(locationVm, "locationVm");
        Intrinsics.checkNotNullParameter(selectAlbumBarVm, "selectAlbumBarVm");
        Intrinsics.checkNotNullParameter(mediaPickerVm, "mediaPickerVm");
        final String U1 = inputAreaVm.U1();
        final LbsDataV2.PoiInfo value = locationVm.O1().getValue();
        final CommonAlbumInfo value2 = selectAlbumBarVm.P1().getValue();
        final DynamicArrayList<String> value3 = mediaPickerVm.P1().getValue();
        final HashMap hashMap = new HashMap();
        if (mediaPickerVm.Q1() != null && value3 != null) {
            HashMap<String, LocalMediaInfo> Q1 = mediaPickerVm.Q1();
            Intrinsics.checkNotNullExpressionValue(Q1, "mediaPickerVm.selectedMediaInfoMap");
            for (Map.Entry<String, LocalMediaInfo> entry : Q1.entrySet()) {
                if (value3.contains(entry.getKey())) {
                    String key = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(key, "it.key");
                    LocalMediaInfo value4 = entry.getValue();
                    Intrinsics.checkNotNullExpressionValue(value4, "it.value");
                    hashMap.put(key, value4);
                }
            }
        }
        final HashMap hashMap2 = new HashMap();
        if (mediaPickerVm.R1() != null && value3 != null) {
            HashMap<String, ShuoshuoVideoInfo> R1 = mediaPickerVm.R1();
            Intrinsics.checkNotNullExpressionValue(R1, "mediaPickerVm.selectedVideoInfoMap");
            for (Map.Entry<String, ShuoshuoVideoInfo> entry2 : R1.entrySet()) {
                if (value3.contains(entry2.getKey())) {
                    String key2 = entry2.getKey();
                    Intrinsics.checkNotNullExpressionValue(key2, "it.key");
                    ShuoshuoVideoInfo value5 = entry2.getValue();
                    Intrinsics.checkNotNullExpressionValue(value5, "it.value");
                    hashMap2.put(key2, value5);
                }
            }
        }
        RFWLog.d("GroupAIOReshipAlbumViewModel", RFWLog.USR, "doUpload, albumInfo:" + value2 + ", selectedImageList:" + value3 + ", selectedMediaInfoMap:" + hashMap + ", selectedVideoInfoMap:" + hashMap2);
        if (value2 == null) {
            this._validAlert.postValue(l.a(R.string.f2195566q));
            return false;
        }
        if (value3 == null) {
            return false;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: ni.a
            @Override // java.lang.Runnable
            public final void run() {
                c.e2(c.this, context, U1, value, value2, hashMap, hashMap2, value3);
            }
        });
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAIOReshipAlbumViewModel";
    }

    public final LiveData<String> h2() {
        return this.validAlert;
    }

    public final void i2(GroupAIOReshipInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
    }

    private final GroupAlbumUploadAlbumParams S1(long batchId, String clientKey, long uploadTime, CommonAlbumInfo albumInfo, String content, List<? extends MediaWrapper> mediaWrapperList, LbsDataV2.PoiInfo poiInfo, Integer index, Integer size, Boolean isPicTask) {
        int collectionSizeOrDefault;
        GroupAIOReshipInitBean groupAIOReshipInitBean = this.initBean;
        if (groupAIOReshipInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAIOReshipInitBean = null;
        }
        String groupId = groupAIOReshipInitBean.getGroupId();
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
        GroupAlbumUploadAlbumParams groupAlbumUploadAlbumParams = new GroupAlbumUploadAlbumParams(batchId, clientKey, groupId, a16, content, arrayList, copyOnWriteArrayList, CommonAlbumUploadPoiInfo.INSTANCE.a(poiInfo), uploadTime, 0, 0, W1(), null, 5632, null);
        if (index != null) {
            groupAlbumUploadAlbumParams.setCurNum(index.intValue());
        }
        if (size != null) {
            groupAlbumUploadAlbumParams.setMaxNum(size.intValue());
        }
        if (isPicTask != null) {
            groupAlbumUploadAlbumParams.setTaskParams(X1(isPicTask.booleanValue()));
        }
        return groupAlbumUploadAlbumParams;
    }

    public final QZoneMediaPickInfo P1(ForwardGroupAlbumBean mediaInfo) {
        List<ForwardMediaInfo> list;
        if (mediaInfo == null || (list = mediaInfo.mediaList) == null || list.isEmpty()) {
            return null;
        }
        QZoneMediaPickInfo qZoneMediaPickInfo = new QZoneMediaPickInfo();
        List<ForwardMediaInfo> list2 = mediaInfo.mediaList;
        Intrinsics.checkNotNullExpressionValue(list2, "mediaInfo.mediaList");
        for (ForwardMediaInfo it : list2) {
            qZoneMediaPickInfo.selectMediaPathList.add(it.filePath);
            HashMap<String, LocalMediaInfo> hashMap = qZoneMediaPickInfo.selectedMediaInfoMap;
            Intrinsics.checkNotNullExpressionValue(hashMap, "mediaPickInfo.selectedMediaInfoMap");
            String str = it.filePath;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            hashMap.put(str, fj.c.b(it));
        }
        return qZoneMediaPickInfo;
    }

    private final MediaWrapper a2(Context context, LocalMediaInfo mediaInfo, ShuoshuoVideoInfo videoInfo, String content) {
        ShuoshuoVideoInfo createVideoMediaWrapper$lambda$20;
        Size b16 = f6.b.b(mediaInfo);
        if (videoInfo != null) {
            videoInfo.mVideoWidth = b16.width;
            videoInfo.mVideoHeight = b16.height;
            Q1(videoInfo);
            createVideoMediaWrapper$lambda$20 = videoInfo;
        } else {
            long j3 = mediaInfo._id;
            String str = mediaInfo.path;
            long j16 = mediaInfo.fileSize;
            int i3 = b16.height;
            int i16 = b16.width;
            long j17 = mediaInfo.mDuration;
            createVideoMediaWrapper$lambda$20 = ag.p(context, j3, str, j16, 1, null, i3, i16, 0L, j17, j17, false, null);
            Intrinsics.checkNotNullExpressionValue(createVideoMediaWrapper$lambda$20, "createVideoMediaWrapper$lambda$20");
            Q1(createVideoMediaWrapper$lambda$20);
        }
        MediaWrapper mediaWrapper = new MediaWrapper(createVideoMediaWrapper$lambda$20);
        mediaWrapper.setQuality(0);
        return mediaWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(c this$0, CommonAlbumInfo albumInfo, long j3, String clientKey, DynamicArrayList selectedImageList, HashMap selectedMediaInfoMap, NTQuoteToQunAlbumRsp nTQuoteToQunAlbumRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(albumInfo, "$albumInfo");
        Intrinsics.checkNotNullParameter(clientKey, "$clientKey");
        Intrinsics.checkNotNullParameter(selectedImageList, "$selectedImageList");
        Intrinsics.checkNotNullParameter(selectedMediaInfoMap, "$selectedMediaInfoMap");
        int i3 = RFWLog.USR;
        String str = nTQuoteToQunAlbumRsp.traceId;
        RFWLog.d("GroupAIOReshipAlbumViewModel", i3, "quoteToQunAlbum, rsp traceId:" + str + ", result:" + nTQuoteToQunAlbumRsp.result + ", errMs:" + nTQuoteToQunAlbumRsp.errMs + ", traceid:" + str + " queryStatusInterval:" + nTQuoteToQunAlbumRsp.queryStatusInterval + " queryStatusMaxCount:" + nTQuoteToQunAlbumRsp.queryStatusMaxCount);
        this$0.c2(nTQuoteToQunAlbumRsp.result);
        GroupAlbumReshipSendBoxManager groupAlbumReshipSendBoxManager = GroupAlbumReshipSendBoxManager.f56848a;
        GroupAIOReshipInitBean groupAIOReshipInitBean = this$0.initBean;
        if (groupAIOReshipInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAIOReshipInitBean = null;
        }
        groupAlbumReshipSendBoxManager.s(groupAIOReshipInitBean.getGroupId(), albumInfo.getAlbumId(), j3, clientKey, new ArrayList<>(this$0.R1(selectedImageList, selectedMediaInfoMap)), 0, 5, 2000L);
    }

    private final void f2(Context context, String content, LbsDataV2.PoiInfo poiInfo, final CommonAlbumInfo albumInfo, final HashMap<String, LocalMediaInfo> selectedMediaInfoMap, HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap, final DynamicArrayList<String> selectedImageList) {
        GroupAIOReshipInitBean groupAIOReshipInitBean;
        List<? extends LocalMediaInfo> list;
        List<? extends ShuoshuoVideoInfo> list2;
        List<MediaWrapper> U1 = U1(context, content, selectedImageList, selectedMediaInfoMap, selectedVideoInfoMap);
        if (U1.isEmpty()) {
            RFWLog.w("GroupAIOReshipAlbumViewModel", RFWLog.USR, "doUploadInternal, mediaList is empty ");
            return;
        }
        final long b16 = r7.a.b();
        final String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        RFWLog.d("GroupAIOReshipAlbumViewModel", RFWLog.USR, "doUploadInternal, batchId:" + b16 + ", clientKey:" + uuid + ", size:" + U1.size());
        GroupAlbumUploadAlbumParams T1 = T1(this, b16, uuid, currentTimeMillis, albumInfo, content, U1, poiInfo, null, null, null, 896, null);
        com.tencent.qqnt.kernel.api.g b17 = r.b();
        NTQuoteToQunAlbumReq nTQuoteToQunAlbumReq = new NTQuoteToQunAlbumReq();
        nTQuoteToQunAlbumReq.albumId = albumInfo.getAlbumId();
        nTQuoteToQunAlbumReq.requestTimeLine = new RequestTimelineInfo();
        nTQuoteToQunAlbumReq.batchId = b16;
        GroupAIOReshipInitBean groupAIOReshipInitBean2 = this.initBean;
        if (groupAIOReshipInitBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAIOReshipInitBean2 = null;
        }
        nTQuoteToQunAlbumReq.qunId = groupAIOReshipInitBean2.getGroupId();
        nTQuoteToQunAlbumReq.units = new ArrayList<>(R1(selectedImageList, selectedMediaInfoMap));
        nTQuoteToQunAlbumReq.feed = GroupAlbumUploadAlbumParams.toStFeed$default(T1, yh.a.f450323a.b(T1.getMediaWrapperList()), 0, 2, null);
        if (b17 != null) {
            b17.quoteToQunAlbum(nTQuoteToQunAlbumReq, new IAlbumServiceQuoteToQunAlbumCallback() { // from class: ni.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceQuoteToQunAlbumCallback
                public final void onQuoteToQunAlbum(NTQuoteToQunAlbumRsp nTQuoteToQunAlbumRsp) {
                    c.g2(c.this, albumInfo, b16, uuid, selectedImageList, selectedMediaInfoMap, nTQuoteToQunAlbumRsp);
                }
            });
        }
        GroupAlbumReshipSendBoxManager groupAlbumReshipSendBoxManager = GroupAlbumReshipSendBoxManager.f56848a;
        GroupAIOReshipInitBean groupAIOReshipInitBean3 = this.initBean;
        if (groupAIOReshipInitBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
            groupAIOReshipInitBean = null;
        } else {
            groupAIOReshipInitBean = groupAIOReshipInitBean3;
        }
        String groupId = groupAIOReshipInitBean.getGroupId();
        Collection<LocalMediaInfo> values = selectedMediaInfoMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "selectedMediaInfoMap.values");
        list = CollectionsKt___CollectionsKt.toList(values);
        Collection<ShuoshuoVideoInfo> values2 = selectedVideoInfoMap.values();
        Intrinsics.checkNotNullExpressionValue(values2, "selectedVideoInfoMap.values");
        list2 = CollectionsKt___CollectionsKt.toList(values2);
        groupAlbumReshipSendBoxManager.C(groupId, b16, list, list2, albumInfo);
        O1(T1);
        b2(T1);
    }

    static /* synthetic */ GroupAlbumUploadAlbumParams T1(c cVar, long j3, String str, long j16, CommonAlbumInfo commonAlbumInfo, String str2, List list, LbsDataV2.PoiInfo poiInfo, Integer num, Integer num2, Boolean bool, int i3, Object obj) {
        return cVar.S1(j3, str, j16, commonAlbumInfo, str2, list, poiInfo, (i3 & 128) != 0 ? null : num, (i3 & 256) != 0 ? null : num2, (i3 & 512) != 0 ? null : bool);
    }
}
