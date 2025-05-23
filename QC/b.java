package qc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneFontPanel;
import com.qzone.common.activities.base.QZoneFontTabView;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.publish.business.task.qzonealbumx.QZAlbumxUploadPicTask;
import com.qzone.publish.business.task.qzonealbumx.QZAlbumxUploadVideoTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.publish.ui.model.PersonalFontData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadPicTaskParams;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadVideoTaskParams;
import com.qzone.reborn.albumx.qzonex.utils.k;
import com.qzone.reborn.base.n;
import com.qzone.reborn.repair.utils.QZonePhotoRepairUploadManger;
import com.qzone.util.ag;
import com.qzone.util.ak;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.l;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.file.FileType;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import lc.i;
import lc.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\u0018\u0000 O2\u00020\u0001:\u0001lB\u0007\u00a2\u0006\u0004\bj\u0010kJ\u008a\u0001\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\f2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J,\u0010\u0017\u001a\u00020\u00142\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\fH\u0002Jz\u0010\"\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\f2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010 H\u0002J\u009a\u0001\u0010(\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020\u001b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010'\u001a\u00020&2\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\f2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010 H\u0002J\u0092\u0001\u0010)\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020\u001b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\f2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010 H\u0002J\u0018\u0010*\u001a\u00020&2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\u0014H\u0002J\b\u0010,\u001a\u00020\u0014H\u0002J.\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002Jt\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\f2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\fH\u0002J*\u00101\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u00102\u001a\u00020\u0014*\u00020\u000eH\u0002JJ\u00104\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fH\u0002J\b\u00105\u001a\u00020\u0004H\u0016J\u0018\u0010:\u001a\u00020\u00142\u0006\u00107\u001a\u0002062\b\u00109\u001a\u0004\u0018\u000108J.\u0010C\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?2\u0006\u0010B\u001a\u00020AR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00040H8\u0006\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\"\u0010T\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010X\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010O\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR(\u0010^\u001a\b\u0012\u0004\u0012\u00020&0D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010F\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0014\u0010a\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010i\u00a8\u0006m"}, d2 = {"Lqc/b;", "Lcom/qzone/reborn/base/n;", "Landroid/content/Context;", "context", "", "content", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "poiInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/HashMap;", "selectedMediaInfoMap", "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", "selectedVideoInfoMap", "Lcom/qzone/widget/dynamicgridview/DynamicArrayList;", "selectedImageList", "Lcom/qzone/common/activities/base/QZoneFontTabView;", "fontTabView", "", "T1", "extendInfo", "U1", "", "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaList", "", "videoNum", "clientKey", "", PhotoCategorySinglePicInfo.UPLOAD_TIME, "", "shootParams", "W1", "batchId", "mediaWrapper", "index", "", "isVideoMix", "i2", "j2", SemanticAttributes.DbSystemValues.H2, "f2", "e2", "b2", "O1", "mediaInfo", QCircleScheme.AttrDetail.VIDEO_INFO, "Q1", "N1", "mediaPath", "P1", "getLogTag", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "initBean", "Landroid/os/Bundle;", "bundle", "g2", "Lcom/qzone/reborn/part/publish/common/inputarea/d;", "inputAreaVm", "Lsl/b;", "locationVm", "Lqc/e;", "selectAlbumBarVm", "Ltl/h;", "mediaPickerVm", "R1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_validAlert", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "d2", "()Landroidx/lifecycle/LiveData;", "validAlert", BdhLogUtil.LogTag.Tag_Conn, "I", "X1", "()I", "k2", "(I)V", "currentImageUploadQuality", "D", "Z1", "l2", "currentVideoUploadQuality", "E", "c2", "()Landroidx/lifecycle/MutableLiveData;", "setUploadQualityBarVisibility", "(Landroidx/lifecycle/MutableLiveData;)V", "uploadQualityBarVisibility", UserInfo.SEX_FEMALE, "J", "UPLOAD_RAW_VIDEO_MAX_SIZE", "G", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "m2", "(Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;)V", "H", "Landroid/os/Bundle;", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends n {

    /* renamed from: C, reason: from kotlin metadata */
    private int currentImageUploadQuality;

    /* renamed from: D, reason: from kotlin metadata */
    private int currentVideoUploadQuality;

    /* renamed from: E, reason: from kotlin metadata */
    private MutableLiveData<Boolean> uploadQualityBarVisibility;

    /* renamed from: F, reason: from kotlin metadata */
    private final long UPLOAD_RAW_VIDEO_MAX_SIZE;

    /* renamed from: G, reason: from kotlin metadata */
    public QZAlbumxUploadAlbumInitBean initBean;

    /* renamed from: H, reason: from kotlin metadata */
    private Bundle bundle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<String> _validAlert;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<String> validAlert;

    public b() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._validAlert = mutableLiveData;
        this.validAlert = mutableLiveData;
        this.uploadQualityBarVisibility = new MutableLiveData<>(Boolean.FALSE);
        this.UPLOAD_RAW_VIDEO_MAX_SIZE = QzoneConfig.getUploadRawVideoByte();
    }

    private final void N1(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        shuoshuoVideoInfo.setPublishParamsType("INTIMATE_ALBUM");
    }

    private final List<MediaWrapper> O1(Context context, String content, List<String> selectedImageList, HashMap<String, LocalMediaInfo> selectedMediaInfoMap, HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap) {
        boolean equals;
        boolean equals2;
        boolean equals3;
        boolean equals4;
        boolean equals5;
        boolean equals6;
        boolean equals7;
        boolean equals8;
        ArrayList arrayList = new ArrayList();
        for (String str : selectedImageList) {
            if (!(str.length() == 0)) {
                LocalMediaInfo localMediaInfo = selectedMediaInfoMap.get(str);
                if (localMediaInfo == null) {
                    RFWLog.w("QZPublishX_QZAlbumxUploadAlbumViewModel", RFWLog.USR, "processUploadMediaList, mediaInfo is null, mediaPath:" + str);
                    String fileExtensionFromFileHeader = RFWFileUtils.getFileExtensionFromFileHeader(str);
                    equals = StringsKt__StringsJVMKt.equals(FileType.JPEG.name(), fileExtensionFromFileHeader, true);
                    if (!equals) {
                        equals2 = StringsKt__StringsJVMKt.equals(FileType.PNG.name(), fileExtensionFromFileHeader, true);
                        if (!equals2) {
                            equals3 = StringsKt__StringsJVMKt.equals(FileType.GIF.name(), fileExtensionFromFileHeader, true);
                            if (!equals3) {
                                equals4 = StringsKt__StringsJVMKt.equals(FileType.BMP.name(), fileExtensionFromFileHeader, true);
                                if (!equals4) {
                                    equals5 = StringsKt__StringsJVMKt.equals(FileType.HEIF.name(), fileExtensionFromFileHeader, true);
                                    if (!equals5) {
                                        equals6 = StringsKt__StringsJVMKt.equals(FileType.HEIC.name(), fileExtensionFromFileHeader, true);
                                        if (!equals6) {
                                            equals7 = StringsKt__StringsJVMKt.equals(FileType.AVIF.name(), fileExtensionFromFileHeader, true);
                                            if (!equals7) {
                                                equals8 = StringsKt__StringsJVMKt.equals(FileType.WEBP.name(), fileExtensionFromFileHeader, true);
                                                if (equals8) {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    arrayList.add(P1(str, null, content, selectedMediaInfoMap));
                } else {
                    int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
                    if (mediaType == 0) {
                        arrayList.add(P1(str, localMediaInfo, content, selectedMediaInfoMap));
                    } else if (mediaType == 1) {
                        arrayList.add(Q1(context, localMediaInfo, selectedVideoInfoMap.get(str), content));
                    }
                }
            }
        }
        return arrayList;
    }

    private final MediaWrapper P1(String mediaPath, LocalMediaInfo mediaInfo, String content, HashMap<String, LocalMediaInfo> selectedMediaInfoMap) {
        LocalMediaInfo localMediaInfo;
        ImageInfo imageInfo = new ImageInfo(mediaPath);
        imageInfo.mDescription = content;
        imageInfo.panoramaType = mediaInfo != null ? mediaInfo.panoramaPhotoType : 0;
        if (selectedMediaInfoMap != null && selectedMediaInfoMap.containsKey(mediaPath) && (localMediaInfo = selectedMediaInfoMap.get(mediaPath)) != null && imageInfo.mGpsInfo == null) {
            imageInfo.mGpsInfo = new GpsInfo4LocalImage(localMediaInfo.latitude, localMediaInfo.longitude);
        }
        MediaWrapper mediaWrapper = new MediaWrapper(imageInfo);
        mediaWrapper.setQuality(this.currentImageUploadQuality);
        if (mediaWrapper.getQuality() == 3) {
            u5.b.q0("photo_quality_sp_key_" + LoginData.getInstance().getUin(), 1);
        }
        return mediaWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(b this$0, Context context, String content, LbsDataV2.PoiInfo poiInfo, CommonAlbumInfo commonAlbumInfo, HashMap selectedMediaInfoMap, HashMap selectedVideoInfoMap, DynamicArrayList dynamicArrayList, com.qzone.reborn.part.publish.common.inputarea.d inputAreaVm) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(selectedVideoInfoMap, "$selectedVideoInfoMap");
        Intrinsics.checkNotNullParameter(inputAreaVm, "$inputAreaVm");
        Intrinsics.checkNotNullExpressionValue(content, "content");
        Intrinsics.checkNotNullExpressionValue(selectedMediaInfoMap, "selectedMediaInfoMap");
        this$0.T1(context, content, poiInfo, commonAlbumInfo, selectedMediaInfoMap, selectedVideoInfoMap, dynamicArrayList, inputAreaVm.S1());
        this$0.f2();
        this$0.e2();
    }

    private final void U1(HashMap<String, String> extendInfo) {
        if (a2().getFromType() == 6 && a2().getIsPhotoRepairByOpr()) {
            extendInfo.put(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, QZoneHelper.QZoneUploadPhotoConstants.DEFAULT_UPLOAD_SR_BY_OPR);
        }
    }

    private final HashMap<String, String> b2(QZoneFontTabView fontTabView) {
        QZoneFontPanel qZoneFontPanel;
        HashMap<String, String> hashMap = new HashMap<>();
        if (fontTabView != null && (qZoneFontPanel = fontTabView.f45368i) != null) {
            PersonalFontData.FontInfo selectFontInfo = qZoneFontPanel.R();
            if (selectFontInfo != null) {
                Intrinsics.checkNotNullExpressionValue(selectFontInfo, "selectFontInfo");
                int i3 = selectFontInfo.f51895id;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(i3);
                hashMap.put("diy_font_id", sb5.toString());
                int i16 = selectFontInfo.fontFormatType;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(i16);
                hashMap.put("diy_font_type", sb6.toString());
                String str = selectFontInfo.fontUrl;
                Intrinsics.checkNotNullExpressionValue(str, "info.fontUrl");
                hashMap.put("diy_font_url", str);
                if (!TextUtils.isEmpty(selectFontInfo.strBackgroundFileJson)) {
                    String str2 = selectFontInfo.strBackgroundFileJson;
                    Intrinsics.checkNotNullExpressionValue(str2, "info.strBackgroundFileJson");
                    hashMap.put("diy_font_bgurl", str2);
                } else {
                    hashMap.put("diy_font_bgurl", "");
                }
            }
            qZoneFontPanel.g0();
        }
        hashMap.put(QZonePublishMoodRequest.KEY_APPID_FOR_CLIENT_FAKE_FEED, "4");
        return hashMap;
    }

    private final void e2() {
        if (TextUtils.isEmpty(a2().getClassifyId())) {
            return;
        }
        QZoneUploadRecommendDirector a16 = QZoneUploadRecommendDirector.INSTANCE.a();
        String classifyId = a2().getClassifyId();
        Intrinsics.checkNotNull(classifyId);
        a16.v(classifyId);
    }

    private final void f2() {
        if (TextUtils.isEmpty(a2().getTianShuAdId())) {
            return;
        }
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(ak.b(140, a2().getTianShuAdId(), ""));
    }

    private final boolean h2(CommonAlbumInfo albumInfo, String content) {
        if (a2().getFromType() != 6 || a2().getIsPhotoRepairByOpr()) {
            return false;
        }
        QZonePhotoRepairUploadManger.INSTANCE.a().f(a2().getPhotoRepairTaskId(), albumInfo.getAlbumId(), Long.valueOf(r7.a.b()), content, a2().getPhotoRepairSrUrl());
        return true;
    }

    private final void i2(long batchId, String clientKey, long uploadTime, String content, CommonAlbumInfo albumInfo, MediaWrapper mediaWrapper, LbsDataV2.PoiInfo poiInfo, int index, List<? extends MediaWrapper> mediaList, boolean isVideoMix, HashMap<String, String> extendInfo, Map<String, String> shootParams) {
        String str;
        String string;
        QZAlbumxUploadPicTaskParams qZAlbumxUploadPicTaskParams = new QZAlbumxUploadPicTaskParams();
        qZAlbumxUploadPicTaskParams.target = 0;
        qZAlbumxUploadPicTaskParams.panoramaType = mediaWrapper.getImageInfo().panoramaType;
        qZAlbumxUploadPicTaskParams.photoName = mediaWrapper.getImageInfo().mName;
        qZAlbumxUploadPicTaskParams.photoFilePath = mediaWrapper.getImageInfo().mPath;
        qZAlbumxUploadPicTaskParams.lastModifyTime = mediaWrapper.getImageInfo().mModifiedDate;
        qZAlbumxUploadPicTaskParams.albumId = k.f53414a.a(albumInfo);
        qZAlbumxUploadPicTaskParams.albumName = albumInfo.getName();
        qZAlbumxUploadPicTaskParams.photoDescription = content;
        qZAlbumxUploadPicTaskParams.picQuality = mediaWrapper.getQuality();
        qZAlbumxUploadPicTaskParams.poiInfo = poiInfo;
        qZAlbumxUploadPicTaskParams.maxNum = mediaList.size();
        qZAlbumxUploadPicTaskParams.curNum = index;
        qZAlbumxUploadPicTaskParams.batchId = batchId;
        qZAlbumxUploadPicTaskParams.uploadTime = uploadTime;
        qZAlbumxUploadPicTaskParams.clientKey = clientKey;
        Bundle bundle = this.bundle;
        String str2 = "";
        if (bundle == null || (str = bundle.getString("refer")) == null) {
            str = "";
        }
        qZAlbumxUploadPicTaskParams.refer = str;
        qZAlbumxUploadPicTaskParams.shootParams = shootParams;
        Bundle bundle2 = this.bundle;
        qZAlbumxUploadPicTaskParams.uploadEntrance = bundle2 != null ? bundle2.getInt("UploadPhoto.key_upload_entrance", 14) : 0;
        Bundle bundle3 = this.bundle;
        if (bundle3 != null && (string = bundle3.getString(QZoneShareManager.QZONE_SHARE_HULIAN_APPID)) != null) {
            str2 = string;
        }
        qZAlbumxUploadPicTaskParams.openAppId = str2;
        qZAlbumxUploadPicTaskParams.extendInfo = extendInfo;
        qZAlbumxUploadPicTaskParams.isVideoMix = isVideoMix;
        qZAlbumxUploadPicTaskParams.externalData = mediaWrapper.getImageInfo().mExternalData;
        qZAlbumxUploadPicTaskParams.photoTagExtendInfo = mediaWrapper.getImageInfo().mPhotoTagInfo;
        new QZAlbumxUploadPicTask(qZAlbumxUploadPicTaskParams).addToTaskQueen();
    }

    private final void j2(long batchId, String clientKey, long uploadTime, String content, CommonAlbumInfo albumInfo, MediaWrapper mediaWrapper, LbsDataV2.PoiInfo poiInfo, int index, List<? extends MediaWrapper> mediaList, HashMap<String, String> extendInfo, Map<String, String> shootParams) {
        String str;
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams = new QZAlbumxUploadVideoTaskParams();
        qZAlbumxUploadVideoTaskParams.shuoshuoVideoInfo = mediaWrapper.getVideoInfo();
        Bundle bundle = this.bundle;
        if (bundle == null || (str = bundle.getString("refer")) == null) {
            str = "";
        }
        qZAlbumxUploadVideoTaskParams.refer = str;
        qZAlbumxUploadVideoTaskParams.uploadTime = uploadTime;
        qZAlbumxUploadVideoTaskParams.clientKey = clientKey;
        qZAlbumxUploadVideoTaskParams.poiInfo = poiInfo;
        qZAlbumxUploadVideoTaskParams.maxNum = mediaList.size();
        qZAlbumxUploadVideoTaskParams.curNum = index;
        qZAlbumxUploadVideoTaskParams.shootParams = shootParams;
        qZAlbumxUploadVideoTaskParams.content = content;
        Bundle bundle2 = this.bundle;
        qZAlbumxUploadVideoTaskParams.uploadEntrance = bundle2 != null ? bundle2.getInt("UploadPhoto.key_upload_entrance", 14) : 0;
        qZAlbumxUploadVideoTaskParams.albumId = k.f53414a.a(albumInfo);
        qZAlbumxUploadVideoTaskParams.albumName = albumInfo.getName();
        qZAlbumxUploadVideoTaskParams.albumTypeId = albumInfo.getQzAlbumType();
        qZAlbumxUploadVideoTaskParams.batchId = batchId;
        qZAlbumxUploadVideoTaskParams.exifTime = mediaWrapper.getVideoInfo().mTakenTime;
        extendInfo.put(FSUploadConst.KEY_MIX_FEED, "1");
        qZAlbumxUploadVideoTaskParams.stExternalMapExt = extendInfo;
        m mVar = m.f414350a;
        qZAlbumxUploadVideoTaskParams.lbsAddress = mVar.a(poiInfo);
        VideoInfo h16 = mVar.h(mediaWrapper.getVideoInfo());
        h16.isFakeFeed = true;
        h16.isUploading = true;
        qZAlbumxUploadVideoTaskParams.videoInfo = h16;
        new QZAlbumxUploadVideoTask(qZAlbumxUploadVideoTaskParams).addToTaskQueen();
    }

    /* renamed from: X1, reason: from getter */
    public final int getCurrentImageUploadQuality() {
        return this.currentImageUploadQuality;
    }

    /* renamed from: Z1, reason: from getter */
    public final int getCurrentVideoUploadQuality() {
        return this.currentVideoUploadQuality;
    }

    public final QZAlbumxUploadAlbumInitBean a2() {
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = this.initBean;
        if (qZAlbumxUploadAlbumInitBean != null) {
            return qZAlbumxUploadAlbumInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    public final MutableLiveData<Boolean> c2() {
        return this.uploadQualityBarVisibility;
    }

    public final LiveData<String> d2() {
        return this.validAlert;
    }

    public final void g2(QZAlbumxUploadAlbumInitBean initBean, Bundle bundle) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        m2(initBean);
        this.bundle = bundle;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZPublishX_QZAlbumxUploadAlbumViewModel";
    }

    public final void k2(int i3) {
        this.currentImageUploadQuality = i3;
    }

    public final void l2(int i3) {
        this.currentVideoUploadQuality = i3;
    }

    public final void m2(QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean) {
        Intrinsics.checkNotNullParameter(qZAlbumxUploadAlbumInitBean, "<set-?>");
        this.initBean = qZAlbumxUploadAlbumInitBean;
    }

    private final void W1(List<? extends MediaWrapper> mediaList, int videoNum, String clientKey, long uploadTime, CommonAlbumInfo albumInfo, LbsDataV2.PoiInfo poiInfo, HashMap<String, String> extendInfo, Map<String, String> shootParams) {
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            le.b.f414397d.a(poiInfo, mediaList, clientKey, shootParams, albumInfo);
            return;
        }
        if (mediaList.size() == 1 && videoNum == 1) {
            i.f414345a.g(clientKey, uploadTime, albumInfo, poiInfo, mediaList.get(0), extendInfo, shootParams);
        } else if (videoNum == 0) {
            i.f414345a.f(clientKey, uploadTime, albumInfo, poiInfo, mediaList, extendInfo, shootParams);
        } else {
            i.f414345a.h(clientKey, uploadTime, albumInfo, poiInfo, mediaList, extendInfo, shootParams);
        }
    }

    public final boolean R1(final Context context, final com.qzone.reborn.part.publish.common.inputarea.d inputAreaVm, sl.b locationVm, e selectAlbumBarVm, tl.h mediaPickerVm) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputAreaVm, "inputAreaVm");
        Intrinsics.checkNotNullParameter(locationVm, "locationVm");
        Intrinsics.checkNotNullParameter(selectAlbumBarVm, "selectAlbumBarVm");
        Intrinsics.checkNotNullParameter(mediaPickerVm, "mediaPickerVm");
        final String content = inputAreaVm.U1();
        final LbsDataV2.PoiInfo value = locationVm.O1().getValue();
        if (value != null) {
            value.show_poi = 1;
        }
        final CommonAlbumInfo value2 = selectAlbumBarVm.Q1().getValue();
        final DynamicArrayList<String> value3 = mediaPickerVm.P1().getValue();
        final HashMap<String, LocalMediaInfo> Q1 = mediaPickerVm.Q1();
        HashMap<String, ShuoshuoVideoInfo> R1 = mediaPickerVm.R1();
        if (R1 == null) {
            R1 = new HashMap<>();
        }
        final HashMap<String, ShuoshuoVideoInfo> hashMap = R1;
        RFWLog.d("QZPublishX_QZAlbumxUploadAlbumViewModel", RFWLog.USR, "doUpload, albumInfo:" + value2 + ", selectedImageList:" + value3 + ", selectedMediaInfoMap:" + Q1 + ", selectedVideoInfoMap:" + hashMap);
        if (value2 == null) {
            this._validAlert.postValue(l.a(R.string.f2195566q));
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(content, "content");
        if (h2(value2, content)) {
            return true;
        }
        if (value3 == null || Q1 == null) {
            return false;
        }
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: qc.a
            @Override // java.lang.Runnable
            public final void run() {
                b.S1(b.this, context, content, value, value2, Q1, hashMap, value3, inputAreaVm);
            }
        });
        return true;
    }

    private final MediaWrapper Q1(Context context, LocalMediaInfo mediaInfo, ShuoshuoVideoInfo videoInfo, String content) {
        ShuoshuoVideoInfo createVideoMediaWrapper$lambda$12;
        Size b16 = f6.b.b(mediaInfo);
        if (videoInfo != null) {
            videoInfo.mVideoWidth = b16.width;
            videoInfo.mVideoHeight = b16.height;
            videoInfo.mDesc = content;
            N1(videoInfo);
            createVideoMediaWrapper$lambda$12 = videoInfo;
        } else {
            long j3 = mediaInfo._id;
            String str = mediaInfo.path;
            long j16 = mediaInfo.fileSize;
            int i3 = b16.height;
            int i16 = b16.width;
            long j17 = mediaInfo.mDuration;
            createVideoMediaWrapper$lambda$12 = ag.p(context, j3, str, j16, 1, null, i3, i16, 0L, j17, j17, false, null);
            Intrinsics.checkNotNullExpressionValue(createVideoMediaWrapper$lambda$12, "createVideoMediaWrapper$lambda$12");
            N1(createVideoMediaWrapper$lambda$12);
        }
        MediaWrapper mediaWrapper = new MediaWrapper(createVideoMediaWrapper$lambda$12);
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

    private final void T1(Context context, String content, LbsDataV2.PoiInfo poiInfo, CommonAlbumInfo albumInfo, HashMap<String, LocalMediaInfo> selectedMediaInfoMap, HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap, DynamicArrayList<String> selectedImageList, QZoneFontTabView fontTabView) {
        HashMap<String, String> hashMap;
        String str;
        long j3;
        List<MediaWrapper> O1 = O1(context, content, selectedImageList, selectedMediaInfoMap, selectedVideoInfoMap);
        if (O1.isEmpty()) {
            RFWLog.w("QZPublishX_QZAlbumxUploadAlbumViewModel", RFWLog.USR, "doUploadInternal, mediaList is empty ");
            return;
        }
        long b16 = r7.a.b();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<MediaWrapper> it = O1.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().isVideo()) {
                i3++;
            }
        }
        HashMap<String, String> b26 = b2(fontTabView);
        Map<String, String> b17 = m.f414350a.b(poiInfo);
        RFWLog.d("QZPublishX_QZAlbumxUploadAlbumViewModel", RFWLog.USR, "doUploadInternal, batchId:" + b16 + ", clientKey:" + uuid + ", size:" + O1.size() + ", videoNum:" + i3);
        lc.n.a(b16, O1.size());
        int i16 = i3;
        W1(O1, i3, uuid, currentTimeMillis, albumInfo, poiInfo, b26, b17);
        HashMap<String, String> hashMap2 = b26;
        U1(hashMap2);
        long j16 = currentTimeMillis;
        int i17 = 0;
        for (Object obj : O1) {
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MediaWrapper mediaWrapper = (MediaWrapper) obj;
            if (j16 != 0) {
                j16--;
            }
            long j17 = j16;
            if (mediaWrapper.isImage()) {
                hashMap = hashMap2;
                str = uuid;
                j3 = b16;
                i2(b16, uuid, j17, content, albumInfo, mediaWrapper, poiInfo, i17, O1, i16 > 0, hashMap, b17);
            } else {
                hashMap = hashMap2;
                str = uuid;
                j3 = b16;
                j2(j3, str, j17, content, albumInfo, mediaWrapper, poiInfo, i17, O1, hashMap, b17);
            }
            i17 = i18;
            j16 = j17;
            hashMap2 = hashMap;
            uuid = str;
            b16 = j3;
        }
    }
}
