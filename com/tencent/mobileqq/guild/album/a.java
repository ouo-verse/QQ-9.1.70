package com.tencent.mobileqq.guild.album;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.filter.MediaFilter;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.model.SelectMediaInfo;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.qqnt.qbasealbum.utils.MediaTypeHelper;
import com.tencent.util.QQToastUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002\u00a2\u0006\u0004\b/\u00100JD\u0010\u000b\u001a\u00020\n2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\u0002JD\u0010\f\u001a\u00020\n2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J(\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011JJ\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bJJ\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bJ\u0010\u0010\u001f\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010 \u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010!\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010\"\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u001c\u0010'\u001a\u00060%j\u0002`&2\u0006\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020\u0013J\u001c\u0010(\u001a\u00020\u001d2\n\u0010#\u001a\u00060%j\u0002`&2\b\b\u0002\u0010$\u001a\u00020\u0013J\u000e\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020\u001dJ$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u0002j\b\u0012\u0004\u0012\u00020\u001d`\u00042\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001d0,\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/album/a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/qbasealbum/model/SelectMediaInfo;", "Lkotlin/collections/ArrayList;", "selectedList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "replaceMediaInfo", "Lcom/tencent/qqnt/qbasealbum/model/Config;", "i", "g", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "o", "", "maxMediaSize", "Landroid/content/Context;", "context", "", "onlyPic", "Landroid/content/Intent;", "k", "Lcom/tencent/mobileqq/guild/temp/api/b;", "albumInput", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "j", tl.h.F, "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "p", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, TtmlNode.ATTR_TTS_ORIGIN, "raw", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/album/LegacyLocalMediaInfo;", "c", "a", "mediaInfo", "", "e", "", "oriInfoList", "f", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f214243a = new a();

    a() {
    }

    private final Config g(ArrayList<SelectMediaInfo> selectedList, HashMap<String, String> replaceMediaInfo) {
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar = new Config.a();
        aVar.f(TabType.TAB_MEDIA);
        aVar.g(9);
        aVar.h(4);
        aVar.o(replaceMediaInfo);
        aVar.b(selectedList);
        aVar.e(4);
        return aVar.a();
    }

    private final Config i(ArrayList<SelectMediaInfo> selectedList, HashMap<String, String> replaceMediaInfo) {
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar = new Config.a();
        aVar.f(TabType.TAB_IMAGE);
        aVar.g(9);
        aVar.h(4);
        aVar.o(replaceMediaInfo);
        aVar.b(selectedList);
        aVar.e(4);
        return aVar.a();
    }

    private final MediaFilter o() {
        MediaFilter.Companion companion = MediaFilter.INSTANCE;
        MediaFilter.a aVar = new MediaFilter.a();
        aVar.b(30000);
        aVar.c(30000);
        aVar.f(ShortVideoConstants.VIDEO_MAX_DURATION);
        aVar.h(1610612736L);
        aVar.d(GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV);
        return aVar.a();
    }

    public final LocalMediaInfo a(com.tencent.mobileqq.activity.photo.LocalMediaInfo origin, boolean raw) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        LocalMediaInfo localMediaInfo = new LocalMediaInfo(false, 1, null);
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
        localMediaInfo.setRwa(raw);
        return localMediaInfo;
    }

    public final com.tencent.mobileqq.activity.photo.LocalMediaInfo c(LocalMediaInfo origin, boolean raw) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        com.tencent.mobileqq.activity.photo.LocalMediaInfo localMediaInfo = new com.tencent.mobileqq.activity.photo.LocalMediaInfo();
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
        localMediaInfo.isRwa = raw;
        return localMediaInfo;
    }

    public final void e(LocalMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        String path = mediaInfo.getPath();
        if (path == null || TextUtils.isEmpty(path) || n(mediaInfo) != 0) {
            return;
        }
        if (new File(path).exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);
            mediaInfo.setMediaWidth(options.outWidth);
            mediaInfo.setMediaHeight(options.outHeight);
            mediaInfo.setMMimeType(options.outMimeType);
            return;
        }
        QLog.d("Guild_DF_ALBUM_UTILS", 1, "Error File does not exist");
    }

    public final ArrayList<LocalMediaInfo> f(List<LocalMediaInfo> oriInfoList) {
        Intrinsics.checkNotNullParameter(oriInfoList, "oriInfoList");
        ArrayList<LocalMediaInfo> arrayList = new ArrayList<>(oriInfoList);
        Iterator<LocalMediaInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            LocalMediaInfo next = it.next();
            if (n(next) == 1) {
                d.a aVar = new d.a();
                com.tencent.mobileqq.shortvideo.util.d.a(next.getPath(), aVar);
                next.setRotation(aVar.f288248a[2]);
                next.setMediaWidth(aVar.f288248a[0]);
                next.setMediaHeight(aVar.f288248a[1]);
            }
        }
        return arrayList;
    }

    public final Intent h(Context context, ArrayList<SelectMediaInfo> selectedList, HashMap<String, String> replaceMediaInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        Intrinsics.checkNotNullParameter(replaceMediaInfo, "replaceMediaInfo");
        Intent e16 = com.tencent.qqnt.qbasealbum.a.e(com.tencent.qqnt.qbasealbum.a.f360732a, context, g(selectedList, replaceMediaInfo), null, GuildAIOPickerCustomization.class, GuildAIOPreviewCustomization.class, 4, null);
        e16.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
        return e16;
    }

    public final Intent j(Context context, ArrayList<SelectMediaInfo> selectedList, HashMap<String, String> replaceMediaInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        Intrinsics.checkNotNullParameter(replaceMediaInfo, "replaceMediaInfo");
        Intent e16 = com.tencent.qqnt.qbasealbum.a.e(com.tencent.qqnt.qbasealbum.a.f360732a, context, i(selectedList, replaceMediaInfo), null, GuildAIOPickerCustomization.class, GuildAIOPreviewCustomization.class, 4, null);
        e16.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
        return e16;
    }

    public final Intent k(int maxMediaSize, Context context, boolean onlyPic) {
        TabType tabType;
        List<SelectMediaInfo> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.g(maxMediaSize);
        if (onlyPic) {
            tabType = TabType.TAB_IMAGE;
        } else {
            tabType = TabType.TAB_MEDIA;
        }
        aVar2.f(tabType);
        aVar2.h(4);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        aVar2.b(emptyList);
        aVar2.d(false);
        aVar2.l(false);
        aVar2.e(4);
        aVar2.o(new HashMap<>());
        aVar2.p(f214243a.o());
        aVar2.j(true);
        Unit unit = Unit.INSTANCE;
        Config a16 = aVar2.a();
        PickerInitBean.Companion companion2 = PickerInitBean.INSTANCE;
        PickerInitBean.a aVar3 = new PickerInitBean.a();
        String string = context.getString(R.string.b9f);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.finish)");
        aVar3.b(string);
        return aVar.d(context, a16, aVar3.a(), GuildFeedPickerCustomization.class, GuildFeedPreviewCustomization.class);
    }

    public final Intent l(int maxMediaSize, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.g(maxMediaSize);
        aVar2.f(TabType.TAB_IMAGE);
        aVar2.h(4);
        aVar2.b(new ArrayList());
        aVar2.d(false);
        aVar2.m(false);
        aVar2.l(false);
        aVar2.e(4);
        aVar2.o(new HashMap<>());
        aVar2.p(f214243a.o());
        aVar2.j(true);
        Unit unit = Unit.INSTANCE;
        Config a16 = aVar2.a();
        PickerInitBean.Companion companion2 = PickerInitBean.INSTANCE;
        PickerInitBean.a aVar3 = new PickerInitBean.a();
        String string = context.getString(R.string.f1518418s);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026ing.guild_pic_select_btn)");
        aVar3.b(string);
        return aVar.d(context, a16, aVar3.a(), GuildFeedPickerCustomization.class, GuildFeedPreviewCustomization.class);
    }

    public final Intent m(int maxMediaSize, Context context, boolean onlyPic, com.tencent.mobileqq.guild.temp.api.b albumInput) {
        Collection emptyList;
        int collectionSizeOrDefault;
        HashMap<String, String> hashMap;
        TabType tabType;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(context, "context");
        List<Object> b16 = albumInput != null ? albumInput.b() : null;
        if (!(b16 instanceof List)) {
            b16 = null;
        }
        if (b16 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<Object> list = b16;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                emptyList.add(b(f214243a, (com.tencent.mobileqq.activity.photo.LocalMediaInfo) it.next(), false, 2, null));
            }
        }
        Collection collection = emptyList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = collection.iterator();
        while (it5.hasNext()) {
            arrayList.add(((LocalMediaInfo) it5.next()).toSelectMediaInfo());
        }
        boolean isQuality = albumInput != null ? albumInput.getIsQuality() : false;
        if (albumInput == null || (hashMap = albumInput.a()) == null) {
            hashMap = new HashMap<>();
        }
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.g(maxMediaSize);
        aVar2.i(0);
        if (onlyPic) {
            tabType = TabType.TAB_IMAGE;
        } else {
            tabType = TabType.TAB_MEDIA;
        }
        aVar2.f(tabType);
        aVar2.h(4);
        aVar2.b(arrayList);
        aVar2.d(false);
        aVar2.l(isQuality);
        aVar2.e(4);
        aVar2.o(hashMap);
        aVar2.p(f214243a.o());
        aVar2.j(true);
        Unit unit = Unit.INSTANCE;
        Config a16 = aVar2.a();
        PickerInitBean.Companion companion2 = PickerInitBean.INSTANCE;
        PickerInitBean.a aVar3 = new PickerInitBean.a();
        String string = context.getString(R.string.b9f);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.finish)");
        aVar3.b(string);
        Intent d16 = aVar.d(context, a16, aVar3.a(), GuildFeedPublishPickerCustomization.class, GuildFeedPublishPreviewCustomization.class);
        if (albumInput != null) {
            d16.putExtra("guild_feed_publish_local_media_key", new ArrayList(emptyList));
        }
        return d16;
    }

    public final int n(LocalMediaInfo info) {
        return MediaTypeHelper.f361628a.a(info);
    }

    public final int p(LocalMediaInfo info) {
        return r(info) ? 2 : 1;
    }

    public final boolean q(LocalMediaInfo info) {
        return MediaTypeHelper.f361628a.a(info) == 0;
    }

    public final boolean r(LocalMediaInfo info) {
        return MediaTypeHelper.f361628a.a(info) == 1;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u0002J)\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u0012\u0010\u0015\u001a\u00020\u00052\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u0003J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\nH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/album/a$a;", "Lcom/tencent/mobileqq/guild/temp/api/e;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/album/LegacyLocalMediaInfo;", "imageInfo", "", "a", "", "strResId", "", "", "reasonReceiver", "", "c", "(I[Ljava/lang/String;)V", "", "mediaInfoModel", "isValidVideo", "(Ljava/lang/Object;[Ljava/lang/String;)I", "isValidImage", "photoInfo", "b", "path", "hasQRCode", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.album.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static final class C7671a implements com.tencent.mobileqq.guild.temp.api.e {

        /* renamed from: d, reason: collision with root package name */
        public static final C7671a f214244d = new C7671a();

        C7671a() {
        }

        public final boolean b(com.tencent.mobileqq.activity.photo.LocalMediaInfo photoInfo) {
            Intrinsics.checkNotNullParameter(photoInfo, "photoInfo");
            try {
                String str = photoInfo.path;
                Intrinsics.checkNotNull(str);
                com.tencent.mobileqq.activity.aio.stickerbubble.frame.c cVar = new com.tencent.mobileqq.activity.aio.stickerbubble.frame.c(new File(str), false);
                long frameCount = cVar.getFrameCount() * photoInfo.mediaHeight * photoInfo.mediaWidth;
                if (cVar.getFrameCount() < 300 && photoInfo.fileSize < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV && photoInfo.mediaWidth < 30000) {
                    if (photoInfo.mediaHeight < 30000 && frameCount < 250000000) {
                        return true;
                    }
                }
            } catch (IOException unused) {
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.temp.api.e
        public boolean hasQRCode(String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            return gg1.a.a(path);
        }

        @Override // com.tencent.mobileqq.guild.temp.api.e
        public int isValidImage(Object mediaInfoModel, String[] reasonReceiver) {
            int i3;
            Intrinsics.checkNotNullParameter(mediaInfoModel, "mediaInfoModel");
            com.tencent.mobileqq.activity.photo.LocalMediaInfo localMediaInfo = mediaInfoModel instanceof com.tencent.mobileqq.activity.photo.LocalMediaInfo ? (com.tencent.mobileqq.activity.photo.LocalMediaInfo) mediaInfoModel : null;
            if (localMediaInfo == null) {
                LocalMediaInfo localMediaInfo2 = mediaInfoModel instanceof LocalMediaInfo ? (LocalMediaInfo) mediaInfoModel : null;
                com.tencent.mobileqq.activity.photo.LocalMediaInfo d16 = localMediaInfo2 != null ? a.d(a.f214243a, localMediaInfo2, false, 2, null) : null;
                if (d16 == null) {
                    return -1;
                }
                localMediaInfo = d16;
            }
            if (localMediaInfo.mediaWidth > 0 && localMediaInfo.mediaHeight > 0) {
                if (a(localMediaInfo)) {
                    if (!b(localMediaInfo)) {
                        c(R.string.f145360r_, reasonReceiver);
                        return 2;
                    }
                } else {
                    if (localMediaInfo.mediaWidth >= 30000 || (i3 = localMediaInfo.mediaHeight) >= 30000 || localMediaInfo.fileSize >= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV || r11 * i3 >= 250000000) {
                        c(R.string.f145360r_, reasonReceiver);
                        return 2;
                    }
                }
                return 0;
            }
            c(R.string.f144380om, reasonReceiver);
            return 1;
        }

        @Override // com.tencent.mobileqq.guild.temp.api.e
        public int isValidVideo(Object mediaInfoModel, String[] reasonReceiver) {
            Intrinsics.checkNotNullParameter(mediaInfoModel, "mediaInfoModel");
            com.tencent.mobileqq.activity.photo.LocalMediaInfo localMediaInfo = mediaInfoModel instanceof com.tencent.mobileqq.activity.photo.LocalMediaInfo ? (com.tencent.mobileqq.activity.photo.LocalMediaInfo) mediaInfoModel : null;
            if (localMediaInfo == null) {
                LocalMediaInfo localMediaInfo2 = mediaInfoModel instanceof LocalMediaInfo ? (LocalMediaInfo) mediaInfoModel : null;
                com.tencent.mobileqq.activity.photo.LocalMediaInfo d16 = localMediaInfo2 != null ? a.d(a.f214243a, localMediaInfo2, false, 2, null) : null;
                if (d16 == null) {
                    return -1;
                }
                localMediaInfo = d16;
            }
            if (localMediaInfo.fileSize < 1610612736 && localMediaInfo.mDuration < ShortVideoConstants.VIDEO_MAX_DURATION) {
                return 0;
            }
            c(R.string.f145360r_, reasonReceiver);
            return 2;
        }

        private final boolean a(com.tencent.mobileqq.activity.photo.LocalMediaInfo imageInfo) {
            return imageInfo != null && Intrinsics.areEqual("image/gif", imageInfo.mMimeType);
        }

        private final void c(int strResId, String[] reasonReceiver) {
            if (reasonReceiver == null) {
                QQToastUtil.showQQToast(strResId);
                return;
            }
            String qqStr = HardCodeUtil.qqStr(strResId);
            if (qqStr == null) {
                qqStr = "";
            }
            reasonReceiver[0] = qqStr;
        }
    }

    public static /* synthetic */ LocalMediaInfo b(a aVar, com.tencent.mobileqq.activity.photo.LocalMediaInfo localMediaInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = localMediaInfo.isRwa;
        }
        return aVar.a(localMediaInfo, z16);
    }

    public static /* synthetic */ com.tencent.mobileqq.activity.photo.LocalMediaInfo d(a aVar, LocalMediaInfo localMediaInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = localMediaInfo.isRwa();
        }
        return aVar.c(localMediaInfo, z16);
    }
}
