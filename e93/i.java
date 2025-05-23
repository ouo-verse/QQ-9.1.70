package e93;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.editor.export.VideoFormatInfo;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.picker.MediaFilteringCode;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.utils.MediaCompressUtils;
import com.tencent.mobileqq.winkpublish.util.LocalMediaInfoGenerator;
import com.tencent.videocut.picker.MediaData;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a%\u0010\u0005\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a \u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a%\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\n\u001a\n\u0010\u000b\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\f\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\r\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\b*\u00020\u0000\u001a\n\u0010\u0010\u001a\u00020\b*\u00020\u0000\u001a\u0012\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011\u001a\n\u0010\u0016\u001a\u00020\u0015*\u00020\u0000\u001a\n\u0010\u0017\u001a\u00020\u0000*\u00020\u0000\u001a\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0007\u001a\u0016\u0010\u001c\u001a\u00020\b2\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u001a\u001a\u0016\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e\u001a\u001a\u0010#\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\bH\u0007\u001a\u0016\u0010$\u001a\u00020\b2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001a\"5\u0010*\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010&0%j\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010&`'*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\",\u00100\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\",\u00103\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/\",\u00106\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/\",\u00109\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/\",\u0010<\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/\"(\u0010A\u001a\u00020\b*\u00020\u00002\u0006\u0010+\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\"(\u0010F\u001a\u00020\u0003*\u00020\u00002\u0006\u0010+\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E\"(\u0010I\u001a\u00020\u0003*\u00020\u00002\u0006\u0010+\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bG\u0010C\"\u0004\bH\u0010E\"(\u0010L\u001a\u00020\u0003*\u00020\u00002\u0006\u0010+\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010E\"(\u0010O\u001a\u00020\u0003*\u00020\u00002\u0006\u0010+\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bM\u0010C\"\u0004\bN\u0010E\"(\u0010R\u001a\u00020\u0003*\u00020\u00002\u0006\u0010+\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bP\u0010C\"\u0004\bQ\u0010E\",\u0010X\u001a\u0004\u0018\u00010S*\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010S8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W\"(\u0010[\u001a\u00020\u0003*\u00020\u00002\u0006\u0010+\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bY\u0010C\"\u0004\bZ\u0010E\",\u0010^\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\\\u0010-\"\u0004\b]\u0010/\"(\u0010a\u001a\u00020\u0001*\u00020\u00002\u0006\u0010+\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b_\u0010-\"\u0004\b`\u0010/\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "l", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Ljava/lang/String;I)Ljava/lang/Integer;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "k", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Ljava/lang/String;Z)Ljava/lang/Boolean;", "E", "G", "I", UserInfo.SEX_FEMALE, "D", "c", "Lcom/tencent/mobileqq/wink/picker/MediaFilteringCode;", "mediaFilteringCode", "", "X", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "r", "b", "localMediaInfo", "a", "", "mediaInfoList", "H", "mediaInfo", "", "duration", "Lcom/tencent/videocut/picker/MediaData;", "d", "needFixWidthAndHeight", "f", "B", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Ljava/util/HashMap;", "nonNullExtData", "value", tl.h.F, "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Ljava/lang/String;", "J", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Ljava/lang/String;)V", "albumId", "v", ExifInterface.LATITUDE_SOUTH, "qZonePhotoId", "u", BdhLogUtil.LogTag.Tag_Req, "qZoneMediaSloc", "w", "T", "thumbUrl", "j", "L", "downloadUrl", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Z", "M", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Z)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "p", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)I", "O", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;I)V", "indexInSelectedMedia", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "P", "mediaLayoutPosition", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "W", "videoLayoutPosition", "o", "N", "imageLayoutPosition", HippyTKDListViewAdapter.X, "U", "validStatus", "Lcom/tencent/mobileqq/wink/editor/export/VideoFormatInfo;", "y", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Lcom/tencent/mobileqq/wink/editor/export/VideoFormatInfo;", "V", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Lcom/tencent/mobileqq/wink/editor/export/VideoFormatInfo;)V", "videoFormatInfo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setVideoRate", "videoRate", "t", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "picName", "i", "K", "contentDescription", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f396010a;

        static {
            int[] iArr = new int[MediaFilteringCode.values().length];
            try {
                iArr[MediaFilteringCode.IMAGE_INVALID_RESOLUTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaFilteringCode.IMAGE_INVALID_RATIO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaFilteringCode.IMAGE_EXCEED_SIZE_LIMIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaFilteringCode.VIDEO_INVALID_RESOLUTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MediaFilteringCode.VIDEO_INVALID_RATIO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MediaFilteringCode.VIDEO_EXCEED_SIZE_LIMIT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MediaFilteringCode.VIDEO_INVALID_MIN_DURATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MediaFilteringCode.VIDEO_INVALID_MAX_DURATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MediaFilteringCode.VIDEO_INVALID_VIDEO_UN_SUPPORT_4K.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f396010a = iArr;
        }
    }

    public static final int A(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Integer l3 = l(localMediaInfo, "videoRate", 0);
        if (l3 == null) {
            return 0;
        }
        return l3.intValue();
    }

    public static final boolean B(@Nullable List<? extends LocalMediaInfo> list) {
        if (list == null) {
            return false;
        }
        List<? extends LocalMediaInfo> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (!G((LocalMediaInfo) it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final boolean C(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Boolean k3 = k(localMediaInfo, "extDownloadStatus", false);
        if (k3 == null) {
            return false;
        }
        return k3.booleanValue();
    }

    public static final boolean D(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return Intrinsics.areEqual(localMediaInfo.mMimeType, LocalMediaInfoGenerator.MEDIA_MIME_TYPE_EMPTY_PLACEHOLDER);
    }

    public static final boolean E(@NotNull LocalMediaInfo localMediaInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        String v3 = v(localMediaInfo);
        if (v3 != null && v3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    public static final boolean F(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return QAlbumUtil.isGif(localMediaInfo);
    }

    public static final boolean G(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        if (QAlbumUtil.getMediaType(localMediaInfo) == 0) {
            return true;
        }
        return false;
    }

    public static final boolean H(@NotNull List<? extends LocalMediaInfo> mediaInfoList) {
        LocalMediaInfo localMediaInfo;
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        if (mediaInfoList.size() != 1 || (localMediaInfo = mediaInfoList.get(0)) == null) {
            return false;
        }
        return !I(localMediaInfo);
    }

    public static final boolean I(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        if (QAlbumUtil.getMediaType(localMediaInfo) == 1) {
            return true;
        }
        return false;
    }

    public static final void J(@NotNull LocalMediaInfo localMediaInfo, @Nullable String str) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("extAlbumId", str);
    }

    public static final void K(@NotNull LocalMediaInfo localMediaInfo, @NotNull String value) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            Result.Companion companion = Result.INSTANCE;
            s(localMediaInfo).put("contentDescription", value);
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    public static final void L(@NotNull LocalMediaInfo localMediaInfo, @Nullable String str) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("extDownloadUrl", str);
    }

    public static final void M(@NotNull LocalMediaInfo localMediaInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("extDownloadStatus", Boolean.valueOf(z16));
    }

    public static final void N(@NotNull LocalMediaInfo localMediaInfo, int i3) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("extImageLayoutPosition", Integer.valueOf(i3));
    }

    public static final void O(@NotNull LocalMediaInfo localMediaInfo, int i3) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("extIndexInSelectedMedia", Integer.valueOf(i3));
    }

    public static final void P(@NotNull LocalMediaInfo localMediaInfo, int i3) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("extMediaLayoutPosition", Integer.valueOf(i3));
    }

    public static final void Q(@NotNull LocalMediaInfo localMediaInfo, @Nullable String str) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("picname", str);
    }

    public static final void R(@NotNull LocalMediaInfo localMediaInfo, @Nullable String str) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("extQZoneMediaSloc", str);
    }

    public static final void S(@NotNull LocalMediaInfo localMediaInfo, @Nullable String str) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("extQZonePhotoId", str);
    }

    public static final void T(@NotNull LocalMediaInfo localMediaInfo, @Nullable String str) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("extThunbUrl", str);
    }

    public static final void U(@NotNull LocalMediaInfo localMediaInfo, int i3) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("extStatus", Integer.valueOf(i3));
    }

    public static final void V(@NotNull LocalMediaInfo localMediaInfo, @Nullable VideoFormatInfo videoFormatInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("extVideoFormatInfo", videoFormatInfo);
    }

    public static final void W(@NotNull LocalMediaInfo localMediaInfo, int i3) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        s(localMediaInfo).put("extVideoLayoutPosition", Integer.valueOf(i3));
    }

    public static final void X(@NotNull LocalMediaInfo localMediaInfo, @NotNull MediaFilteringCode mediaFilteringCode) {
        int i3;
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Intrinsics.checkNotNullParameter(mediaFilteringCode, "mediaFilteringCode");
        switch (a.f396010a[mediaFilteringCode.ordinal()]) {
            case 1:
            case 2:
            case 3:
                i3 = -1;
                break;
            case 4:
            case 5:
            case 6:
                i3 = -5;
                break;
            case 7:
                i3 = -3;
                break;
            case 8:
                i3 = -4;
                break;
            case 9:
                i3 = -7;
                break;
            default:
                i3 = 0;
                break;
        }
        U(localMediaInfo, i3);
    }

    @Deprecated(message = "\u4f7f\u7528LocalMediaInfo.copy()\u66ff\u6362")
    @NotNull
    public static final LocalMediaInfo a(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
        localMediaInfo2._id = localMediaInfo._id;
        localMediaInfo2.path = localMediaInfo.path;
        localMediaInfo2.fileSize = localMediaInfo.fileSize;
        localMediaInfo2.addedDate = localMediaInfo.addedDate;
        localMediaInfo2.modifiedDate = localMediaInfo.modifiedDate;
        localMediaInfo2.orientation = localMediaInfo.orientation;
        localMediaInfo2.mDuration = localMediaInfo.mDuration;
        localMediaInfo2.mStartTime = localMediaInfo.mStartTime;
        localMediaInfo2.mTotalDuration = localMediaInfo.mTotalDuration;
        localMediaInfo2.mChecked = localMediaInfo.mChecked;
        localMediaInfo2.needProcess = localMediaInfo.needProcess;
        localMediaInfo2.fakeVid = localMediaInfo.fakeVid;
        localMediaInfo2.mVideoType = localMediaInfo.mVideoType;
        localMediaInfo2.thumbRect = localMediaInfo.thumbRect;
        localMediaInfo2.isRecord = localMediaInfo.isRecord;
        localMediaInfo2.thumbnailPath = localMediaInfo.thumbnailPath;
        localMediaInfo2.thumbnailProgress = localMediaInfo.thumbnailProgress;
        localMediaInfo2.isProgressThumbnail = localMediaInfo.isProgressThumbnail;
        localMediaInfo2.selectStatus = localMediaInfo.selectStatus;
        localMediaInfo2.isSegment = localMediaInfo.isSegment;
        localMediaInfo2.rotation = localMediaInfo.rotation;
        localMediaInfo2.latitude = localMediaInfo.latitude;
        localMediaInfo2.longitude = localMediaInfo.longitude;
        localMediaInfo2.isMakeVideo = localMediaInfo.isMakeVideo;
        localMediaInfo2.isSyncToWeishi = localMediaInfo.isSyncToWeishi;
        localMediaInfo2.isVideoReady = localMediaInfo.isVideoReady;
        localMediaInfo2.missionID = localMediaInfo.missionID;
        localMediaInfo2.aiTextLabel = localMediaInfo.aiTextLabel;
        localMediaInfo2.mCloudPhotoOwnerUin = localMediaInfo.mCloudPhotoOwnerUin;
        localMediaInfo2.mCloudPhotoOwnerAlbumId = localMediaInfo.mCloudPhotoOwnerAlbumId;
        localMediaInfo2.mCloudPhotoId = localMediaInfo.mCloudPhotoId;
        localMediaInfo2.thumbWidth = localMediaInfo.thumbWidth;
        localMediaInfo2.thumbHeight = localMediaInfo.thumbHeight;
        localMediaInfo2.index = localMediaInfo.index;
        localMediaInfo2.position = localMediaInfo.position;
        localMediaInfo2.mMimeType = localMediaInfo.mMimeType;
        localMediaInfo2.mMediaType = localMediaInfo.mMediaType;
        localMediaInfo2.mTransferPosList = localMediaInfo.mTransferPosList;
        localMediaInfo2.mediaWidth = localMediaInfo.mediaWidth;
        localMediaInfo2.mediaHeight = localMediaInfo.mediaHeight;
        localMediaInfo2.mediaBitrate = localMediaInfo.mediaBitrate;
        localMediaInfo2.mediaOriginWidth = localMediaInfo.mediaOriginWidth;
        localMediaInfo2.mediaOriginHeight = localMediaInfo.mediaOriginHeight;
        localMediaInfo2.mediaOriginSize = localMediaInfo.mediaOriginSize;
        localMediaInfo2.mediaOriginBitrate = localMediaInfo.mediaOriginBitrate;
        localMediaInfo2.mOriginPath = localMediaInfo.mOriginPath;
        localMediaInfo2.materialID = localMediaInfo.materialID;
        localMediaInfo2.materialName = localMediaInfo.materialName;
        localMediaInfo2.filterID = localMediaInfo.filterID;
        localMediaInfo2.scheme = localMediaInfo.scheme;
        localMediaInfo2.showCircleTakeSame = localMediaInfo.showCircleTakeSame;
        localMediaInfo2.mKuolieId = localMediaInfo.mKuolieId;
        localMediaInfo2.mKuolieCenterX = localMediaInfo.mKuolieCenterX;
        localMediaInfo2.mKuolieCenterY = localMediaInfo.mKuolieCenterY;
        localMediaInfo2.mKuolieRotate = localMediaInfo.mKuolieRotate;
        localMediaInfo2.mKuolieWidthScale = localMediaInfo.mKuolieWidthScale;
        localMediaInfo2.mKuolieHeightScale = localMediaInfo.mKuolieHeightScale;
        localMediaInfo2.mHashTagList = localMediaInfo.mHashTagList;
        localMediaInfo2.isSystemMeidaStore = localMediaInfo.isSystemMeidaStore;
        localMediaInfo2.isRegionThumbUseNewDecoder = localMediaInfo.isRegionThumbUseNewDecoder;
        localMediaInfo2.mIsUploadOrigin = localMediaInfo.mIsUploadOrigin;
        localMediaInfo2.visableTime = localMediaInfo.visableTime;
        localMediaInfo2.listViewPosition = localMediaInfo.listViewPosition;
        localMediaInfo2.thumbSize = localMediaInfo.thumbSize;
        localMediaInfo2.panoramaPhotoType = localMediaInfo.panoramaPhotoType;
        localMediaInfo2.mAudioPath = localMediaInfo.mAudioPath;
        localMediaInfo2.mHasAudioTrack = localMediaInfo.mHasAudioTrack;
        localMediaInfo2.mSampleRate = localMediaInfo.mSampleRate;
        localMediaInfo2.mAlbumName = localMediaInfo.mAlbumName;
        localMediaInfo2.mTransId = localMediaInfo.mTransId;
        localMediaInfo2.mTextId = localMediaInfo.mTextId;
        localMediaInfo2.mTextStr = localMediaInfo.mTextStr;
        localMediaInfo2.isRwa = localMediaInfo.isRwa;
        localMediaInfo2.videoMimeType = localMediaInfo.videoMimeType;
        localMediaInfo2.picPathBeforeEdit = localMediaInfo.picPathBeforeEdit;
        if (localMediaInfo.extData != null) {
            localMediaInfo2.extData = new HashMap<>(localMediaInfo.extData);
        }
        return localMediaInfo2;
    }

    @NotNull
    public static final LocalMediaInfo b(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return a(localMediaInfo);
    }

    public static final boolean c(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        if (TextUtils.isEmpty(localMediaInfo.path)) {
            return false;
        }
        return new File(localMediaInfo.path).exists();
    }

    @NotNull
    public static final MediaData d(@NotNull LocalMediaInfo mediaInfo, long j3) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (mediaInfo.mediaWidth == 0 || mediaInfo.mediaHeight == 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(mediaInfo.path, options);
            mediaInfo.mediaWidth = options.outWidth;
            mediaInfo.mediaHeight = options.outHeight;
        }
        if (mediaInfo.mediaWidth == 0 || mediaInfo.mediaHeight == 0) {
            mediaInfo.mediaWidth = 720;
            mediaInfo.mediaHeight = 1280;
        }
        String str = MediaCompressUtils.f325262a.n().get(mediaInfo.path);
        String str2 = mediaInfo.mMimeType;
        if (str2 == null) {
            str2 = "image/*";
        }
        String str3 = str2;
        int i3 = mediaInfo.mediaWidth;
        int i16 = mediaInfo.mediaHeight;
        if (str == null) {
            str = mediaInfo.path;
        }
        if (str == null) {
            str = "";
        }
        return new MediaData(1, str3, i3, i16, 0L, 0L, j3, str, mediaInfo.path, mediaInfo.mAlbumName);
    }

    @JvmOverloads
    @NotNull
    public static final MediaData e(@NotNull LocalMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return g(mediaInfo, false, 2, null);
    }

    @JvmOverloads
    @NotNull
    public static final MediaData f(@NotNull LocalMediaInfo mediaInfo, boolean z16) {
        int i3;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (z16) {
            WinkExportUtils.m(mediaInfo);
        }
        int i18 = mediaInfo.mediaWidth;
        int i19 = mediaInfo.mediaHeight;
        if (z16 && ((i17 = mediaInfo.rotation) == 90 || i17 == 270)) {
            i16 = i18;
            i3 = i19;
        } else {
            i3 = i18;
            i16 = i19;
        }
        String str = MediaCompressUtils.f325262a.n().get(mediaInfo.path);
        String str2 = mediaInfo.mMimeType;
        if (str2 == null) {
            str2 = "video/*";
        }
        String str3 = str2;
        long j3 = 1000;
        long j16 = mediaInfo.mStartTime * j3;
        long j17 = mediaInfo.mDuration * j3;
        if (str == null) {
            str = mediaInfo.path;
        }
        if (str == null) {
            str = "";
        }
        return new MediaData(0, str3, i3, i16, j16, 0L, j17, str, mediaInfo.path, mediaInfo.mAlbumName);
    }

    public static /* synthetic */ MediaData g(LocalMediaInfo localMediaInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return f(localMediaInfo, z16);
    }

    @Nullable
    public static final String h(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return n(localMediaInfo, "extAlbumId", null, 2, null);
    }

    @NotNull
    public static final String i(@NotNull LocalMediaInfo localMediaInfo) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            String n3 = n(localMediaInfo, "contentDescription", null, 2, null);
            if (n3 == null) {
                n3 = "";
            }
            m476constructorimpl = Result.m476constructorimpl(n3);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (!Result.m482isFailureimpl(m476constructorimpl)) {
            obj = m476constructorimpl;
        }
        String str = (String) obj;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Nullable
    public static final String j(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return m(localMediaInfo, "extDownloadUrl", "");
    }

    @Nullable
    public static final Boolean k(@NotNull LocalMediaInfo localMediaInfo, @NotNull String key, boolean z16) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        HashMap<String, Serializable> hashMap = localMediaInfo.extData;
        if (hashMap != null) {
            Serializable serializable2 = hashMap.get(key);
            if (serializable2 == null) {
                serializable2 = Boolean.valueOf(z16);
            }
            serializable = serializable2;
        } else {
            serializable = null;
        }
        if (!(serializable instanceof Boolean)) {
            return null;
        }
        return (Boolean) serializable;
    }

    @Nullable
    public static final Integer l(@NotNull LocalMediaInfo localMediaInfo, @NotNull String key, int i3) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        HashMap<String, Serializable> hashMap = localMediaInfo.extData;
        if (hashMap != null) {
            Serializable serializable2 = hashMap.get(key);
            if (serializable2 == null) {
                serializable2 = Integer.valueOf(i3);
            }
            serializable = serializable2;
        } else {
            serializable = null;
        }
        if (!(serializable instanceof Integer)) {
            return null;
        }
        return (Integer) serializable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object] */
    @Nullable
    public static final String m(@NotNull LocalMediaInfo localMediaInfo, @NotNull String key, @Nullable String str) {
        String str2;
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        HashMap<String, Serializable> hashMap = localMediaInfo.extData;
        if (hashMap != null) {
            ?? r16 = hashMap.get(key);
            if (r16 != 0) {
                str = r16;
            }
            str2 = str;
        } else {
            str2 = null;
        }
        if (!(str2 instanceof String)) {
            return null;
        }
        return str2;
    }

    public static /* synthetic */ String n(LocalMediaInfo localMediaInfo, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return m(localMediaInfo, str, str2);
    }

    public static final int o(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Integer l3 = l(localMediaInfo, "extImageLayoutPosition", 0);
        if (l3 == null) {
            return 0;
        }
        return l3.intValue();
    }

    public static final int p(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Integer l3 = l(localMediaInfo, "extIndexInSelectedMedia", 0);
        if (l3 == null) {
            return 0;
        }
        return l3.intValue();
    }

    public static final int q(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Integer l3 = l(localMediaInfo, "extMediaLayoutPosition", 0);
        if (l3 == null) {
            return 0;
        }
        return l3.intValue();
    }

    @NotNull
    public static final MediaType r(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
        if (E(localMediaInfo)) {
            if (mediaType == 0) {
                return MediaType.QZONE_IMAGE;
            }
            return MediaType.QZONE_VIDEO;
        }
        if (mediaType == 0) {
            return MediaType.LOCAL_IMAGE;
        }
        return MediaType.LOCAL_VIDEO;
    }

    @NotNull
    public static final HashMap<String, Serializable> s(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        if (localMediaInfo.extData == null) {
            localMediaInfo.extData = new HashMap<>();
        }
        HashMap<String, Serializable> extData = localMediaInfo.extData;
        Intrinsics.checkNotNullExpressionValue(extData, "extData");
        return extData;
    }

    @Nullable
    public static final String t(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return n(localMediaInfo, "picname", null, 2, null);
    }

    @Nullable
    public static final String u(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return n(localMediaInfo, "extQZoneMediaSloc", null, 2, null);
    }

    @Nullable
    public static final String v(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return n(localMediaInfo, "extQZonePhotoId", null, 2, null);
    }

    @Nullable
    public static final String w(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return n(localMediaInfo, "extThunbUrl", null, 2, null);
    }

    public static final int x(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Integer l3 = l(localMediaInfo, "extStatus", 0);
        if (l3 == null) {
            return 0;
        }
        return l3.intValue();
    }

    @Nullable
    public static final VideoFormatInfo y(@NotNull LocalMediaInfo localMediaInfo) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        HashMap<String, Serializable> hashMap = localMediaInfo.extData;
        if (hashMap != null) {
            serializable = hashMap.get("extVideoFormatInfo");
        } else {
            serializable = null;
        }
        if (!(serializable instanceof VideoFormatInfo)) {
            return null;
        }
        return (VideoFormatInfo) serializable;
    }

    public static final int z(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Integer l3 = l(localMediaInfo, "extVideoLayoutPosition", 0);
        if (l3 == null) {
            return 0;
        }
        return l3.intValue();
    }
}
