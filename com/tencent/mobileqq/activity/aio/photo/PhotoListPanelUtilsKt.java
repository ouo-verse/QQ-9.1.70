package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.activity.aio.photo.PhotoListPanelUtilsKt;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.album.api.IAlbumApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/photo/PhotoListPanelUtilsKt;", "", "a", "Companion", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class PhotoListPanelUtilsKt {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f179710b = "PhotoListPanelUtilsKt";

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J9\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022'\u0010\u000b\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004H\u0007J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H\u0007J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0007R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/photo/PhotoListPanelUtilsKt$Companion;", "", "", "chatType", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/ParameterName;", "name", "data", "", "callback", "d", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "newMediaInfoList", "", "b", "a", "", "TAG", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final LocalMediaInfo a(@NotNull com.tencent.qqnt.qbasealbum.model.LocalMediaInfo newMediaInfoList) {
            Intrinsics.checkNotNullParameter(newMediaInfoList, "newMediaInfoList");
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo._id = newMediaInfoList.get_id();
            localMediaInfo.path = newMediaInfoList.getPath();
            localMediaInfo.fileSize = newMediaInfoList.getFileSize();
            localMediaInfo.addedDate = newMediaInfoList.getAddedDate();
            localMediaInfo.modifiedDate = newMediaInfoList.getModifiedDate();
            localMediaInfo.orientation = newMediaInfoList.getOrientation();
            localMediaInfo.mDuration = com.tencent.qqnt.qbasealbum.ktx.b.f(newMediaInfoList);
            localMediaInfo.mStartTime = newMediaInfoList.getMStartTime();
            localMediaInfo.mTotalDuration = newMediaInfoList.getMTotalDuration();
            localMediaInfo.mChecked = newMediaInfoList.getMChecked();
            localMediaInfo.needProcess = newMediaInfoList.getNeedProcess();
            localMediaInfo.isSegment = newMediaInfoList.isSegment();
            localMediaInfo.fakeVid = newMediaInfoList.getFakeVid();
            localMediaInfo.mVideoType = newMediaInfoList.getMVideoType();
            localMediaInfo.thumbRect = newMediaInfoList.getThumbRect();
            localMediaInfo.isRecord = newMediaInfoList.isRecord();
            localMediaInfo.thumbnailPath = newMediaInfoList.getThumbnailPath();
            localMediaInfo.thumbnailProgress = newMediaInfoList.getThumbnailProgress();
            localMediaInfo.isProgressThumbnail = newMediaInfoList.isProgressThumbnail();
            localMediaInfo.selectStatus = newMediaInfoList.getSelectStatus();
            localMediaInfo.rotation = newMediaInfoList.getRotation();
            localMediaInfo.latitude = newMediaInfoList.getLatitude();
            localMediaInfo.longitude = newMediaInfoList.getLongitude();
            localMediaInfo.isMakeVideo = newMediaInfoList.isMakeVideo();
            localMediaInfo.isSyncToWeishi = newMediaInfoList.isSyncToWeishi();
            localMediaInfo.isVideoReady = newMediaInfoList.isVideoReady();
            localMediaInfo.missionID = newMediaInfoList.getMissionID();
            localMediaInfo.aiTextLabel = newMediaInfoList.getAiTextLabel();
            localMediaInfo.mCloudPhotoOwnerUin = newMediaInfoList.getMCloudPhotoOwnerUin();
            localMediaInfo.mCloudPhotoOwnerAlbumId = newMediaInfoList.getMCloudPhotoOwnerAlbumId();
            localMediaInfo.mCloudPhotoId = newMediaInfoList.getMCloudPhotoId();
            localMediaInfo.thumbWidth = newMediaInfoList.getThumbWidth();
            localMediaInfo.thumbHeight = newMediaInfoList.getThumbHeight();
            localMediaInfo.index = newMediaInfoList.getIndex();
            localMediaInfo.position = Integer.valueOf(newMediaInfoList.getPosition());
            localMediaInfo.mMimeType = newMediaInfoList.getMMimeType();
            localMediaInfo.mMediaType = newMediaInfoList.getMMediaType();
            localMediaInfo.mTransferPosList = newMediaInfoList.getMTransferPosList();
            localMediaInfo.mediaWidth = newMediaInfoList.getMediaWidth();
            localMediaInfo.mediaHeight = newMediaInfoList.getMediaHeight();
            localMediaInfo.mediaBitrate = newMediaInfoList.getMediaBitrate();
            localMediaInfo.mediaOriginWidth = newMediaInfoList.getMediaOriginWidth();
            localMediaInfo.mediaOriginHeight = newMediaInfoList.getMediaOriginHeight();
            localMediaInfo.mediaOriginSize = newMediaInfoList.getMediaOriginSize();
            localMediaInfo.mediaOriginBitrate = newMediaInfoList.getMediaOriginBitrate();
            localMediaInfo.mOriginPath = newMediaInfoList.getMOriginPath();
            localMediaInfo.materialID = newMediaInfoList.getMaterialID();
            localMediaInfo.materialName = newMediaInfoList.getMaterialName();
            localMediaInfo.filterID = newMediaInfoList.getFilterID();
            localMediaInfo.scheme = newMediaInfoList.getScheme();
            localMediaInfo.showCircleTakeSame = newMediaInfoList.getShowCircleTakeSame();
            localMediaInfo.mKuolieId = newMediaInfoList.getMKuolieId();
            localMediaInfo.mKuolieCenterX = newMediaInfoList.getMKuolieCenterX();
            localMediaInfo.mKuolieCenterY = newMediaInfoList.getMKuolieCenterY();
            localMediaInfo.mKuolieRotate = newMediaInfoList.getMKuolieRotate();
            localMediaInfo.mKuolieWidthScale = newMediaInfoList.getMKuolieWidthScale();
            localMediaInfo.mKuolieHeightScale = newMediaInfoList.getMKuolieHeightScale();
            localMediaInfo.mHashTagList = newMediaInfoList.getMHashTagList();
            localMediaInfo.isRwa = newMediaInfoList.isRwa();
            localMediaInfo.picPathBeforeEdit = newMediaInfoList.getPicPathBeforeEdit();
            localMediaInfo.videoMimeType = newMediaInfoList.getVideoMimeType();
            localMediaInfo.isHDRVideo = newMediaInfoList.isHDRVideo();
            localMediaInfo.isSegment = newMediaInfoList.isSegment();
            localMediaInfo.isVideoShareToQZone = newMediaInfoList.isVideoShareToQZone();
            return localMediaInfo;
        }

        @JvmStatic
        @NotNull
        public final List<LocalMediaInfo> b(@NotNull List<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> newMediaInfoList) {
            Intrinsics.checkNotNullParameter(newMediaInfoList, "newMediaInfoList");
            ArrayList arrayList = new ArrayList();
            Iterator<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> it = newMediaInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return arrayList;
        }

        @NotNull
        public final String c() {
            return PhotoListPanelUtilsKt.f179710b;
        }

        @JvmStatic
        public final void d(int chatType, @NotNull final Function1<? super List<? extends LocalMediaInfo>, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
            QLog.d(c(), 1, "queryMediaTask start!");
            ((IAlbumApi) QRoute.api(IAlbumApi.class)).queryMediaTask(CoroutineScope, chatType, new Function1<List<? extends com.tencent.qqnt.qbasealbum.model.LocalMediaInfo>, Unit>() { // from class: com.tencent.mobileqq.activity.aio.photo.PhotoListPanelUtilsKt$Companion$queryMediaTask$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> list) {
                    invoke2((List<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    PhotoListPanelUtilsKt.Companion companion = PhotoListPanelUtilsKt.INSTANCE;
                    QLog.d(companion.c(), 1, "queryMediaTask, size: " + it.size());
                    callback.invoke(companion.b(it));
                }
            });
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final void b(int i3, @NotNull Function1<? super List<? extends LocalMediaInfo>, Unit> function1) {
        INSTANCE.d(i3, function1);
    }
}
