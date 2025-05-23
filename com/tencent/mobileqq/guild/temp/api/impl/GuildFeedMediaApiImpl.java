package com.tencent.mobileqq.guild.temp.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO;
import com.tencent.mobileqq.guild.album.a;
import com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi;
import com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J*\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0096\u0001\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0096\u0001\u00a2\u0006\u0004\b\u000e\u0010\rJ \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J*\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\"\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u000bH\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/GuildFeedMediaApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/IGuildFeedMediaApi;", "Lcom/tencent/mobileqq/guild/temp/api/e;", "", "path", "", "hasQRCode", "", "mediaInfoModel", "", "reasonReceiver", "", "isValidImage", "(Ljava/lang/Object;[Ljava/lang/String;)I", "isValidVideo", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "maxMediaSize", "onlyPic", "Landroid/content/Intent;", "getOpenNativePublishAlbumIntent", "Lcom/tencent/mobileqq/guild/temp/api/b;", "albumInput", "getOpenSimplifiedNativePublisherAlbumIntent", "getOpenCommentAlbumIntent", "Landroidx/activity/result/ActivityResult;", "result", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "getMediaInfoList", "Lcom/tencent/mobileqq/guild/temp/api/c;", "getAlbumResult", "Landroid/content/Context;", "context", "curMedia", "Lcom/tencent/mobileqq/qroute/route/ActivityURIRequest;", "getPreviewUriRequest", "getTranslucentBrowserType", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildFeedMediaApiImpl implements IGuildFeedMediaApi, com.tencent.mobileqq.guild.temp.api.e {
    private final /* synthetic */ a.C7671a $$delegate_0 = a.C7671a.f214244d;

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi
    public com.tencent.mobileqq.guild.temp.api.c getAlbumResult(ActivityResult result) {
        AlbumResult albumResult;
        ArrayList arrayList;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        if (data == null || (albumResult = (AlbumResult) data.getParcelableExtra("ALBUM_RESULT")) == null) {
            return null;
        }
        List<LocalMediaInfo> e16 = albumResult.e();
        if (e16 != null) {
            List<LocalMediaInfo> list = e16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.mobileqq.guild.album.a.d(com.tencent.mobileqq.guild.album.a.f214243a, (LocalMediaInfo) it.next(), false, 2, null));
            }
        } else {
            arrayList = new ArrayList();
        }
        return new com.tencent.mobileqq.guild.temp.api.c(arrayList, albumResult.g(), albumResult.c());
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi
    public List<com.tencent.mobileqq.activity.photo.LocalMediaInfo> getMediaInfoList(ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        if (data != null) {
            return getMediaInfoList(data);
        }
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi
    public Intent getOpenCommentAlbumIntent(Activity activity, int maxMediaSize) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return com.tencent.mobileqq.guild.album.a.f214243a.l(maxMediaSize, activity);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi
    public Intent getOpenNativePublishAlbumIntent(Activity activity, int maxMediaSize, boolean onlyPic) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return com.tencent.mobileqq.guild.album.a.f214243a.k(maxMediaSize, activity, onlyPic);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi
    public Intent getOpenSimplifiedNativePublisherAlbumIntent(Activity activity, int maxMediaSize, boolean onlyPic, com.tencent.mobileqq.guild.temp.api.b albumInput) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return com.tencent.mobileqq.guild.album.a.f214243a.m(maxMediaSize, activity, onlyPic, albumInput);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi
    public ActivityURIRequest getPreviewUriRequest(Context context, Object curMedia, com.tencent.mobileqq.guild.temp.api.b albumInput) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Map map;
        IntRange indices;
        List list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(curMedia, "curMedia");
        Intrinsics.checkNotNullParameter(albumInput, "albumInput");
        List<Object> b16 = albumInput.b();
        if (!(b16 instanceof List)) {
            b16 = null;
        }
        if (b16 == null) {
            return null;
        }
        com.tencent.mobileqq.activity.photo.LocalMediaInfo localMediaInfo = curMedia instanceof com.tencent.mobileqq.activity.photo.LocalMediaInfo ? (com.tencent.mobileqq.activity.photo.LocalMediaInfo) curMedia : null;
        if (localMediaInfo == null) {
            return null;
        }
        bg bgVar = bg.f302144a;
        List<Object> list2 = b16;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            String str = ((com.tencent.mobileqq.activity.photo.LocalMediaInfo) it.next()).path;
            if (str != null) {
                arrayList.add(str);
            }
        }
        ArrayList<String> n3 = bgVar.n(arrayList);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list2) {
            linkedHashMap.put(((com.tencent.mobileqq.activity.photo.LocalMediaInfo) obj).path, obj);
        }
        map = MapsKt__MapsKt.toMap(linkedHashMap, new HashMap());
        int indexOf = b16.indexOf(localMediaInfo);
        bg bgVar2 = bg.f302144a;
        indices = CollectionsKt__CollectionsKt.getIndices(b16);
        list = CollectionsKt___CollectionsKt.toList(indices);
        ArrayList<Integer> n16 = bgVar2.n(list);
        HashMap<String, String> a16 = albumInput.a();
        boolean isQuality = albumInput.getIsQuality();
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPhotoLogicFactory.PHOTO_PREVIEW_ACTIVITY_URI);
        activityURIRequest.extra().putInt("uintype", 10014);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_SEND_TO_AIO, true);
        activityURIRequest.extra().putString(QAlbumConstants.ALBUM_ID, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID);
        activityURIRequest.extra().putBoolean(QAlbumConstants.SHOW_ALBUM, true);
        activityURIRequest.extra().putStringArrayList("PhotoConst.PHOTO_PATHS", n3);
        activityURIRequest.extra().putSerializable(QAlbumConstants.ALL_MEDIA_PATHS, (HashMap) map);
        activityURIRequest.extra().putInt(QAlbumConstants.CURRENT_SELECTED_INDEX, indexOf);
        activityURIRequest.extra().putStringArrayList("PhotoConst.SELECTED_PATHS", n3);
        activityURIRequest.extra().putIntegerArrayList(QAlbumConstants.SELECTED_INDEXS, n16);
        activityURIRequest.extra().putSerializable(QAlbumConstants.KEY_EDIT_PATHS_MAP, a16);
        activityURIRequest.extra().putInt(PeakConstants.KEY_PIC_TO_EDIT_FROM, 1);
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, ((IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class)).getPhotoListCustomizationGuildAIOClassName());
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, ((IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class)).getPhotoPreviewCustomizationGuildAIOClassName());
        activityURIRequest.setRequestCode(10015);
        activityURIRequest.extra().putInt(QAlbumConstants.CURRENT_QUALITY_TYPE, isQuality ? 2 : 0);
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 9);
        activityURIRequest.extra().putBoolean(QAlbumConstants.KEEP_SELECTED_STATUS_AFTER_FINISH, true);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_OVERLOAD, false);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_JUMPTO_TROOP_ALBUM, false);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 1);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationAIO.f184370j);
        activityURIRequest.extra().putBoolean("PHOTO_PREVIEW_NEED_DRAG_KEY", false);
        activityURIRequest.extra().putBoolean(PeakConstants.VIDEO_EDIT_ENABLED, false);
        activityURIRequest.setFlags(603979776);
        return activityURIRequest;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi
    public int getTranslucentBrowserType() {
        return 4;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi, com.tencent.mobileqq.guild.temp.api.e
    public boolean hasQRCode(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.$$delegate_0.hasQRCode(path);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi, com.tencent.mobileqq.guild.temp.api.e
    public int isValidImage(Object mediaInfoModel, String[] reasonReceiver) {
        Intrinsics.checkNotNullParameter(mediaInfoModel, "mediaInfoModel");
        return this.$$delegate_0.isValidImage(mediaInfoModel, reasonReceiver);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi, com.tencent.mobileqq.guild.temp.api.e
    public int isValidVideo(Object mediaInfoModel, String[] reasonReceiver) {
        Intrinsics.checkNotNullParameter(mediaInfoModel, "mediaInfoModel");
        return this.$$delegate_0.isValidVideo(mediaInfoModel, reasonReceiver);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi
    public List<com.tencent.mobileqq.activity.photo.LocalMediaInfo> getMediaInfoList(Intent result) {
        List<LocalMediaInfo> e16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(result, "result");
        AlbumResult albumResult = (AlbumResult) result.getParcelableExtra("ALBUM_RESULT");
        if (albumResult != null && (e16 = albumResult.e()) != null) {
            List<LocalMediaInfo> list = e16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.mobileqq.guild.album.a.f214243a.c((LocalMediaInfo) it.next(), albumResult.g()));
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
