package com.tencent.guild.api.media.album.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.guild.aio.panel.photo.QueryMediaTask;
import com.tencent.guild.api.media.album.AlbumResult;
import com.tencent.guild.api.media.album.INTGuildAlbumApi;
import com.tencent.guild.api.media.album.e;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.qbasealbum.filter.MediaFilter;
import com.tencent.qqnt.qbasealbum.model.SelectMediaInfo;
import cooperation.peak.PeakConstants;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J5\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2%\u0010\r\u001a!\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\fH\u0002J5\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2%\u0010\r\u001a!\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u00a3\u0001\u0010'\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001f2&\u0010#\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2%\u0010\r\u001a!\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\fH\u0016J*\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020$2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u000b0\u0006H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020\u0014H\u0016J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020.H\u0016J2\u00102\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\b\u00101\u001a\u0004\u0018\u00010\u001f2\u0006\u0010%\u001a\u00020$H\u0016J9\u00104\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020$2'\u00103\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000b0\u0006H\u0016J\b\u00105\u001a\u00020\u000bH\u0016J\u009b\u0001\u00109\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\b\u00108\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u001e\u0010#\u001a\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010!j\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u0001`\"2%\u0010\r\u001a!\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\fH\u0016J[\u0010>\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020<2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030\u00132%\u0010\r\u001a!\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\fH\u0016J\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u0013H\u0016J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020?0\u00132\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00140BH\u0016J\u001e\u0010G\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000b0EH\u0016\u00a8\u0006J"}, d2 = {"Lcom/tencent/guild/api/media/album/impl/NTGuildAlbumApiImpl;", "Lcom/tencent/guild/api/media/album/INTGuildAlbumApi;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", TtmlNode.ATTR_TTS_ORIGIN, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "convertMediaInfo", "Lkotlin/Function1;", "Lcom/tencent/guild/api/media/album/a;", "Lkotlin/ParameterName;", "name", "albumResult", "", "Lcom/tencent/guild/api/media/album/StartAlbumCB;", "cb", "Landroidx/activity/result/ActivityResultCallback;", "Landroidx/activity/result/ActivityResult;", "activityResultCallback", "newActivityResultCallback", "convertOldMediaInfoToNew", "", "Lcom/tencent/guild/api/media/album/e;", "selectedList", "Lcom/tencent/qqnt/qbasealbum/model/SelectMediaInfo;", "getSelectedList", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lts/a;", "launch", "", "channelId", "guildId", "Landroid/content/Intent;", "data", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "replaceMediaInfo", "", "directMessage", "showFinishBtn", "openNewAlbumFromPhotoPanel", "showVideo", "Lcom/tencent/guild/aio/panel/photo/QueryMediaTask;", "queryMediaTask", "info", "Ljava/net/URL;", "generateAlbumThumbURL", "", "time", "formatTimeToString", "openAioIntent", "openCameraSendMsg", "callback", "queryMediaTaskNew", "peakPreload", "paths", "selectPaths", "currentPath", "photoPanelItemClick", "Landroid/content/Context;", "context", "", "mDatas", "postMediaItemClick", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgs", "msgElement2MediaInfo", "", "photos", "guildMediaInfo2MsgElement", "Lkotlin/Function0;", "allGranted", "checkAIOAlbumPermission", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class NTGuildAlbumApiImpl implements INTGuildAlbumApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/api/media/album/impl/NTGuildAlbumApiImpl$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f112606a;

        a(Function0<Unit> function0) {
            this.f112606a = function0;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            this.f112606a.invoke();
        }
    }

    private final ActivityResultCallback<ActivityResult> activityResultCallback(final Function1<? super AlbumResult, Unit> cb5) {
        return new ActivityResultCallback() { // from class: com.tencent.guild.api.media.album.impl.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                NTGuildAlbumApiImpl.activityResultCallback$lambda$12(Function1.this, (ActivityResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void activityResultCallback$lambda$12(Function1 cb5, ActivityResult result) {
        ArrayList arrayList;
        HashMap hashMap;
        Serializable serializableExtra;
        ArrayList<LocalMediaInfo> parcelableArrayListExtra;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intent data = result.getData();
        if (data != null && (parcelableArrayListExtra = data.getParcelableArrayListExtra(PeakConstants.GUILD_ALBUM_SELECT_PHOTOS)) != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(parcelableArrayListExtra, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            for (LocalMediaInfo it : parcelableArrayListExtra) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(new com.tencent.guild.api.media.album.impl.a(it));
            }
        } else {
            arrayList = new ArrayList();
        }
        Intent data2 = result.getData();
        if (data2 != null && (serializableExtra = data2.getSerializableExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP)) != null) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = new HashMap();
        }
        Intent data3 = result.getData();
        boolean z16 = false;
        if (data3 != null && data3.getBooleanExtra(PeakConstants.GUILD_ALBUM_QUALITY, false)) {
            z16 = true;
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        cb5.invoke(new AlbumResult(result, arrayList, hashMap, z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalMediaInfo convertMediaInfo(com.tencent.qqnt.qbasealbum.model.LocalMediaInfo origin) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo._id = origin.get_id();
        localMediaInfo.path = origin.getPath();
        localMediaInfo.fileSize = origin.getFileSize();
        localMediaInfo.addedDate = origin.getAddedDate();
        localMediaInfo.modifiedDate = origin.getModifiedDate();
        localMediaInfo.orientation = origin.getOrientation();
        localMediaInfo.mDuration = com.tencent.qqnt.qbasealbum.ktx.b.f(origin);
        localMediaInfo.mChecked = origin.getMChecked();
        localMediaInfo.isSegment = origin.isSegment();
        localMediaInfo.selectStatus = origin.getSelectStatus();
        localMediaInfo.rotation = origin.getRotation();
        localMediaInfo.thumbWidth = origin.getThumbWidth();
        localMediaInfo.thumbHeight = origin.getThumbHeight();
        localMediaInfo.index = origin.getIndex();
        localMediaInfo.position = Integer.valueOf(origin.getPosition());
        localMediaInfo.mMimeType = origin.getMMimeType();
        localMediaInfo.mediaWidth = origin.getMediaWidth();
        localMediaInfo.mediaHeight = origin.getMediaHeight();
        localMediaInfo.mediaBitrate = origin.getMediaBitrate();
        localMediaInfo.isSystemMeidaStore = origin.isSystemMeidaStore();
        localMediaInfo.isRegionThumbUseNewDecoder = origin.isRegionThumbUseNewDecoder();
        localMediaInfo.panoramaPhotoType = origin.getPanoramaPhotoType();
        localMediaInfo.mMediaType = origin.getMMediaType();
        localMediaInfo.isVideoReady = origin.isVideoReady();
        localMediaInfo.materialID = origin.getMaterialID();
        localMediaInfo.materialName = origin.getMaterialName();
        localMediaInfo.filterID = origin.getFilterID();
        localMediaInfo.scheme = origin.getScheme();
        localMediaInfo.showCircleTakeSame = origin.getShowCircleTakeSame();
        localMediaInfo.missionID = origin.getMissionID();
        localMediaInfo.thumbnailProgress = origin.getThumbnailProgress();
        localMediaInfo.mediaOriginWidth = origin.getMediaOriginWidth();
        localMediaInfo.mediaOriginHeight = origin.getMediaOriginHeight();
        localMediaInfo.mediaOriginSize = origin.getMediaOriginSize();
        localMediaInfo.mediaOriginBitrate = origin.getMediaOriginBitrate();
        localMediaInfo.mOriginPath = origin.getMOriginPath();
        localMediaInfo.mKuolieId = origin.getMKuolieId();
        localMediaInfo.mKuolieCenterX = origin.getMKuolieCenterX();
        localMediaInfo.mKuolieCenterY = origin.getMKuolieCenterY();
        localMediaInfo.mKuolieRotate = origin.getMKuolieRotate();
        localMediaInfo.mKuolieWidthScale = origin.getMKuolieWidthScale();
        localMediaInfo.mKuolieHeightScale = origin.getMKuolieHeightScale();
        localMediaInfo.picPathBeforeEdit = origin.getPicPathBeforeEdit();
        localMediaInfo.videoMimeType = origin.getVideoMimeType();
        localMediaInfo.isHDRVideo = origin.isHDRVideo();
        return localMediaInfo;
    }

    private final com.tencent.qqnt.qbasealbum.model.LocalMediaInfo convertOldMediaInfoToNew(LocalMediaInfo origin) {
        com.tencent.qqnt.qbasealbum.model.LocalMediaInfo localMediaInfo = new com.tencent.qqnt.qbasealbum.model.LocalMediaInfo(false, 1, null);
        localMediaInfo.set_id(origin._id);
        localMediaInfo.setPath(origin.path);
        localMediaInfo.setFileSize(origin.fileSize);
        localMediaInfo.setAddedDate(origin.addedDate);
        localMediaInfo.setModifiedDate(origin.modifiedDate);
        localMediaInfo.setOrientation(origin.orientation);
        com.tencent.qqnt.qbasealbum.ktx.b.t(localMediaInfo, origin.mDuration);
        localMediaInfo.setMChecked(origin.mChecked);
        localMediaInfo.setSegment(origin.isSegment);
        localMediaInfo.setSelectStatus(origin.selectStatus);
        localMediaInfo.setRotation(origin.rotation);
        localMediaInfo.setThumbWidth(origin.thumbWidth);
        localMediaInfo.setThumbHeight(origin.thumbHeight);
        localMediaInfo.setIndex(origin.index);
        Integer num = origin.position;
        Intrinsics.checkNotNullExpressionValue(num, "origin.position");
        localMediaInfo.setPosition(num.intValue());
        localMediaInfo.setMMimeType(origin.mMimeType);
        localMediaInfo.setMediaWidth(origin.mediaWidth);
        localMediaInfo.setMediaHeight(origin.mediaHeight);
        localMediaInfo.setMediaBitrate(origin.mediaBitrate);
        localMediaInfo.setSystemMeidaStore(origin.isSystemMeidaStore);
        localMediaInfo.setRegionThumbUseNewDecoder(origin.isRegionThumbUseNewDecoder);
        localMediaInfo.setPanoramaPhotoType(origin.panoramaPhotoType);
        localMediaInfo.setMMediaType(origin.mMediaType);
        localMediaInfo.setVideoReady(origin.isVideoReady);
        localMediaInfo.setMaterialID(origin.materialID);
        localMediaInfo.setMaterialName(origin.materialName);
        localMediaInfo.setFilterID(origin.filterID);
        localMediaInfo.setScheme(origin.scheme);
        localMediaInfo.setShowCircleTakeSame(origin.showCircleTakeSame);
        localMediaInfo.setMissionID(origin.missionID);
        localMediaInfo.setThumbnailProgress(origin.thumbnailProgress);
        localMediaInfo.setMediaOriginWidth(origin.mediaOriginWidth);
        localMediaInfo.setMediaOriginHeight(origin.mediaOriginHeight);
        localMediaInfo.setMediaOriginSize(origin.mediaOriginSize);
        localMediaInfo.setMediaOriginBitrate(origin.mediaOriginBitrate);
        localMediaInfo.setMOriginPath(origin.mOriginPath);
        localMediaInfo.setMKuolieId(origin.mKuolieId);
        localMediaInfo.setMKuolieCenterX(origin.mKuolieCenterX);
        localMediaInfo.setMKuolieCenterY(origin.mKuolieCenterY);
        localMediaInfo.setMKuolieRotate(origin.mKuolieRotate);
        localMediaInfo.setMKuolieWidthScale(origin.mKuolieWidthScale);
        localMediaInfo.setMKuolieHeightScale(origin.mKuolieHeightScale);
        localMediaInfo.setPicPathBeforeEdit(origin.picPathBeforeEdit);
        localMediaInfo.setVideoMimeType(origin.videoMimeType);
        localMediaInfo.setHDRVideo(origin.isHDRVideo);
        return localMediaInfo;
    }

    private final List<SelectMediaInfo> getSelectedList(List<? extends e> selectedList) {
        int collectionSizeOrDefault;
        List<? extends e> list = selectedList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object d16 = ((e) it.next()).d();
            Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.mobileqq.activity.photo.LocalMediaInfo");
            arrayList.add(convertOldMediaInfoToNew((LocalMediaInfo) d16).toSelectMediaInfo());
        }
        return arrayList;
    }

    private final ActivityResultCallback<ActivityResult> newActivityResultCallback(final Function1<? super AlbumResult, Unit> cb5) {
        return new ActivityResultCallback() { // from class: com.tencent.guild.api.media.album.impl.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                NTGuildAlbumApiImpl.newActivityResultCallback$lambda$14(Function1.this, this, (ActivityResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newActivityResultCallback$lambda$14(Function1 cb5, NTGuildAlbumApiImpl this$0, ActivityResult result) {
        com.tencent.qqnt.qbasealbum.model.AlbumResult albumResult;
        List<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> e16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent data = result.getData();
        if (data != null) {
            albumResult = (com.tencent.qqnt.qbasealbum.model.AlbumResult) data.getParcelableExtra("ALBUM_RESULT");
        } else {
            albumResult = null;
        }
        if (albumResult != null && (e16 = albumResult.e()) != null) {
            List<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> list = e16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.guild.api.media.album.impl.a(this$0.convertMediaInfo((com.tencent.qqnt.qbasealbum.model.LocalMediaInfo) it.next())));
            }
            Intrinsics.checkNotNullExpressionValue(result, "result");
            cb5.invoke(new AlbumResult(result, arrayList, albumResult.c(), albumResult.g()));
        }
    }

    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    public void checkAIOAlbumPermission(@NotNull Activity activity, @NotNull Function0<Unit> allGranted) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(allGranted, "allGranted");
        if (activity.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && activity.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            allGranted.invoke();
        } else {
            QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AIO_ALBUM, QQPermissionConstants.Business.SCENE.OPEN_AIO_ALBUM)).requestPermissions(QQPermissionConstants.Permission.GROUP_STORAGE, 2, new a(allGranted));
        }
    }

    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    @NotNull
    public String formatTimeToString(long time) {
        String formatTimeToString = QAlbumUtil.formatTimeToString(time);
        Intrinsics.checkNotNullExpressionValue(formatTimeToString, "formatTimeToString(time)");
        return formatTimeToString;
    }

    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    @NotNull
    public URL generateAlbumThumbURL(@NotNull e info) {
        Intrinsics.checkNotNullParameter(info, "info");
        URL generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(((com.tencent.guild.api.media.album.impl.a) info).getRealInfo(), "FLOW_THUMB");
        Intrinsics.checkNotNullExpressionValue(generateAlbumThumbURL, "generateAlbumThumbURL(in\u2026r.ALBUM_THUMB_FLOW_THUMB)");
        return generateAlbumThumbURL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0011 A[SYNTHETIC] */
    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<MsgElement> guildMediaInfo2MsgElement(@NotNull List<e> photos) {
        LocalMediaInfo localMediaInfo;
        String str;
        LocalMediaInfo localMediaInfo2;
        Intrinsics.checkNotNullParameter(photos, "photos");
        ArrayList arrayList = new ArrayList();
        for (e eVar : photos) {
            int type = eVar.getType();
            String str2 = "";
            String str3 = null;
            if (type == com.tencent.guild.api.media.album.c.a()) {
                MsgElement msgElement = new MsgElement();
                msgElement.elementType = 2;
                msgElement.picElement = new PicElement();
                Object d16 = eVar.d();
                if (d16 instanceof LocalMediaInfo) {
                    localMediaInfo2 = (LocalMediaInfo) d16;
                } else {
                    localMediaInfo2 = null;
                }
                if (localMediaInfo2 != null) {
                    str3 = localMediaInfo2.toJsonString();
                }
                if (str3 != null) {
                    Intrinsics.checkNotNullExpressionValue(str3, "(it.realMediaInfo() as? \u2026fo)?.toJsonString() ?: \"\"");
                    str2 = str3;
                }
                byte[] bytes = str2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                msgElement.extBufForUI = bytes;
                str = msgElement;
            } else {
                if (type == com.tencent.guild.api.media.album.c.b()) {
                    MsgElement msgElement2 = new MsgElement();
                    msgElement2.elementType = 5;
                    msgElement2.videoElement = new VideoElement();
                    Object d17 = eVar.d();
                    if (d17 instanceof LocalMediaInfo) {
                        localMediaInfo = (LocalMediaInfo) d17;
                    } else {
                        localMediaInfo = null;
                    }
                    if (localMediaInfo != null) {
                        str3 = localMediaInfo.toJsonString();
                    }
                    if (str3 != null) {
                        Intrinsics.checkNotNullExpressionValue(str3, "(it.realMediaInfo() as? \u2026fo)?.toJsonString() ?: \"\"");
                        str2 = str3;
                    }
                    byte[] bytes2 = str2.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                    msgElement2.extBufForUI = bytes2;
                    str = msgElement2;
                }
                if (str3 == null) {
                    arrayList.add(str3);
                }
            }
            str3 = str;
            if (str3 == null) {
            }
        }
        return arrayList;
    }

    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    @NotNull
    public List<e> msgElement2MediaInfo(@NotNull List<MsgElement> msgs) {
        com.tencent.guild.api.media.album.impl.a aVar;
        Intrinsics.checkNotNullParameter(msgs, "msgs");
        ArrayList arrayList = new ArrayList();
        for (MsgElement msgElement : msgs) {
            int i3 = msgElement.elementType;
            if (i3 != 2 && i3 != 5) {
                aVar = null;
            } else {
                byte[] bArr = msgElement.extBufForUI;
                Intrinsics.checkNotNullExpressionValue(bArr, "it.extBufForUI");
                LocalMediaInfo localMediaInfo = LocalMediaInfo.formObjectByJsonString(new String(bArr, Charsets.UTF_8));
                Intrinsics.checkNotNullExpressionValue(localMediaInfo, "localMediaInfo");
                aVar = new com.tencent.guild.api.media.album.impl.a(localMediaInfo);
            }
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    public void openCameraSendMsg(@NotNull String channelId, @NotNull String guildId, @NotNull Activity activity, @Nullable Intent openAioIntent, boolean directMessage) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (openAioIntent == null || (bundle = openAioIntent.getExtras()) == null) {
            bundle = new Bundle();
        }
        bundle.putParcelable(PeakConstants.GUILD_OPEN_AIO_INTENT, openAioIntent);
        bundle.putInt(AECameraConstants.AECAMERA_MODE, 204);
        if (directMessage) {
            bundle.putInt("ability_flag", 2);
            bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        }
        ((IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class)).openCamera(activity, channelId, guildId, bundle);
    }

    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    public void openNewAlbumFromPhotoPanel(@NotNull Activity activity, @NotNull ts.a launch, @NotNull List<? extends e> selectedList, @Nullable String channelId, @Nullable String guildId, @Nullable Intent data, @Nullable HashMap<String, String> replaceMediaInfo, boolean directMessage, boolean showFinishBtn, @NotNull Function1<? super AlbumResult, Unit> cb5) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(launch, "launch");
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        Intent intent = ((IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class)).getOpenAlbumIntent(activity, new ArrayList<>(getSelectedList(selectedList)), channelId, guildId, data, directMessage, showFinishBtn, replaceMediaInfo);
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        launch.a(intent, newActivityResultCallback(cb5));
    }

    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    public void peakPreload() {
        ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(MobileQQ.sMobileQQ);
    }

    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    public void photoPanelItemClick(@NotNull ts.a launch, @NotNull List<? extends e> paths, @NotNull List<String> selectPaths, @Nullable String currentPath, @Nullable String channelId, @Nullable String guildId, @Nullable Intent data, @Nullable HashMap<?, ?> replaceMediaInfo, @NotNull Function1<? super AlbumResult, Unit> cb5) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(launch, "launch");
        Intrinsics.checkNotNullParameter(paths, "paths");
        Intrinsics.checkNotNullParameter(selectPaths, "selectPaths");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        IGuildAIOMediaApi iGuildAIOMediaApi = (IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class);
        List<? extends e> list = paths;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((e) it.next()).getPath());
        }
        ArrayList<String> arrayList2 = new ArrayList<>(arrayList);
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (e eVar : list) {
            Pair pair = new Pair(eVar.getPath(), eVar.d());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        ActivityURIRequest photoPreviewFromPhotoPanelURIReq = iGuildAIOMediaApi.getPhotoPreviewFromPhotoPanelURIReq(arrayList2, new HashMap(linkedHashMap), new ArrayList<>(selectPaths), currentPath, channelId, guildId, data, replaceMediaInfo);
        String path = photoPreviewFromPhotoPanelURIReq.getURI().getPath();
        Intrinsics.checkNotNull(path);
        launch.b(path, activityResultCallback(cb5), photoPreviewFromPhotoPanelURIReq.extra());
    }

    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    public void postMediaItemClick(@NotNull ts.a launch, @NotNull Context context, @NotNull String channelId, @NotNull Object data, @NotNull List<?> mDatas, @NotNull Function1<? super AlbumResult, Unit> cb5) {
        Intrinsics.checkNotNullParameter(launch, "launch");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(mDatas, "mDatas");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ActivityURIRequest postMediaItemClickURIReq = ((IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class)).getPostMediaItemClickURIReq(context, channelId, data, mDatas);
        if (postMediaItemClickURIReq == null) {
            return;
        }
        String path = postMediaItemClickURIReq.getURI().getPath();
        Intrinsics.checkNotNull(path);
        launch.b(path, activityResultCallback(cb5), postMediaItemClickURIReq.extra());
    }

    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    public /* bridge */ /* synthetic */ Runnable queryMediaTask(boolean z16, Function1 function1) {
        return queryMediaTask(z16, (Function1<? super List<? extends e>, Unit>) function1);
    }

    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    public void queryMediaTaskNew(boolean showVideo, @NotNull final Function1<? super List<? extends e>, Unit> callback) {
        MediaFilter a16;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!showVideo) {
            MediaFilter.Companion companion = MediaFilter.INSTANCE;
            MediaFilter.a aVar = new MediaFilter.a();
            aVar.g(-1);
            a16 = aVar.a();
        } else {
            MediaFilter.Companion companion2 = MediaFilter.INSTANCE;
            a16 = new MediaFilter.a().a();
        }
        com.tencent.qqnt.qbasealbum.a.f360732a.k(a16, 50, new Function1<List<? extends com.tencent.qqnt.qbasealbum.model.LocalMediaInfo>, Unit>() { // from class: com.tencent.guild.api.media.album.impl.NTGuildAlbumApiImpl$queryMediaTaskNew$1
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
            public final void invoke2(@NotNull List<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> localMediaList) {
                int collectionSizeOrDefault;
                LocalMediaInfo convertMediaInfo;
                Intrinsics.checkNotNullParameter(localMediaList, "localMediaList");
                List<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> list = localMediaList;
                NTGuildAlbumApiImpl nTGuildAlbumApiImpl = this;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    convertMediaInfo = nTGuildAlbumApiImpl.convertMediaInfo((com.tencent.qqnt.qbasealbum.model.LocalMediaInfo) it.next());
                    arrayList.add(new a(convertMediaInfo));
                }
                callback.invoke(arrayList);
            }
        });
    }

    @Override // com.tencent.guild.api.media.album.INTGuildAlbumApi
    @NotNull
    public QueryMediaTask queryMediaTask(boolean showVideo, @NotNull Function1<? super List<? extends e>, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        return new QueryMediaTask(showVideo, cb5);
    }
}
