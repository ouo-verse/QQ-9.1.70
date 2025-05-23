package com.tencent.mobileqq.wink.editor.draft;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.export.u;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.TransitionModel;
import com.tencent.videocut.picker.MediaData;
import common.config.service.QzoneConfig;
import e93.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0000\u001a$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\t\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0000\u001a\u0016\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f*\u00020\u0000\u001a\f\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\u0000\u001a\f\u0010\u0012\u001a\u0004\u0018\u00010\r*\u00020\u0000\u001a\f\u0010\u0013\u001a\u0004\u0018\u00010\r*\u00020\u0010\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0014\u001a\n\u0010\u0016\u001a\u00020\u0001*\u00020\u0014\u001a\n\u0010\u0017\u001a\u00020\u0001*\u00020\u0014\u001a\n\u0010\u0018\u001a\u00020\r*\u00020\u0014\u001a\u0018\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019*\u00020\u0014\u001a\u0014\u0010\u001d\u001a\u00020\u0001*\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u001a\n\u0010\u001e\u001a\u00020\u0001*\u00020\u0014\u001a\n\u0010\u001f\u001a\u00020\u0001*\u00020\u0014\u001a\n\u0010 \u001a\u00020\u0001*\u00020\u0014\u001a\n\u0010!\u001a\u00020\r*\u00020\u0014\u001a \u0010&\u001a\u00020%2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00032\b\b\u0002\u0010$\u001a\u00020\u0001\u001a\u0016\u0010'\u001a\u00020%2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0003\u001a6\u0010,\u001a\u00020\u00142\u001a\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\"\u0018\u00010(j\n\u0012\u0004\u0012\u00020\"\u0018\u0001`)2\b\b\u0002\u0010*\u001a\u00020\u001a2\b\b\u0002\u0010+\u001a\u00020\u001a\u001a@\u0010-\u001a\u00020\u00142\u001a\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\"\u0018\u00010(j\n\u0012\u0004\u0012\u00020\"\u0018\u0001`)2\b\b\u0002\u0010*\u001a\u00020\u001a2\b\b\u0002\u0010+\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020\u0001\u001a\u001a\u00102\u001a\u00020\u0000*\u00020\u00002\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200\u001a\f\u00104\u001a\u0004\u0018\u000103*\u00020\u0014\u001a\u001a\u00105\u001a\u0012\u0012\u0004\u0012\u00020\"0(j\b\u0012\u0004\u0012\u00020\"`)*\u00020\u0014\u001a\u0016\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u0014\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "", "B", "", "Lcom/tencent/videocut/model/MediaClip;", "t", "editDatas", "isVideoTavCut", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/dr;", "l", "w", "", "", "Lcom/tencent/videocut/model/TransitionModel;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "D", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "v", "j", "Landroid/util/Pair;", "", "u", "winkTavCutDelegate", "a", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "r", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfoList", "isTransitionAllImages", "Lcom/tencent/mobileqq/wink/editor/draft/b;", h.F, "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "editMode", "fromEntrance", "d", "e", "Lcom/tencent/videocut/model/MediaModel;", "mediaModel", "", "newDuration", "b", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "k", DomainData.DOMAIN_NAME, "o", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u00a8\u0006\u0003"}, d2 = {"com/tencent/mobileqq/wink/editor/draft/c$a", "Lcom/google/gson/reflect/TypeToken;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends TypeToken<LAKRenderModel> {
        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u00a8\u0006\u0003"}, d2 = {"com/tencent/mobileqq/wink/editor/draft/c$b", "Lcom/google/gson/reflect/TypeToken;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends TypeToken<LAKRenderModel> {
        b() {
        }
    }

    public static final boolean A(@NotNull WinkEditDataWrapper winkEditDataWrapper) {
        boolean equals;
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        ArrayList<LocalMediaInfo> originMediaInfos = winkEditDataWrapper.getOriginMediaInfos();
        if (originMediaInfos != null && originMediaInfos.size() == 1) {
            equals = StringsKt__StringsJVMKt.equals(originMediaInfos.get(0).mMimeType, "video/mp4", true);
            if (!equals) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static final boolean B(@NotNull WinkEditData winkEditData) {
        Intrinsics.checkNotNullParameter(winkEditData, "<this>");
        WinkEditStretchedData stretchData = winkEditData.getStretchData();
        if (stretchData == null || !stretchData.isStretched()) {
            return false;
        }
        return true;
    }

    public static final boolean C(@NotNull WinkEditDataWrapper winkEditDataWrapper) {
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        if (!winkEditDataWrapper.getEditDatas().isEmpty()) {
            MediaModel mediaModel = winkEditDataWrapper.getEditDatas().get(0).getMediaModel();
            if (!mediaModel.videos.isEmpty()) {
                ResourceModel resourceModel = mediaModel.videos.get(0).resource;
                Intrinsics.checkNotNull(resourceModel);
                if (resourceModel.path.length() > 0) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @Nullable
    public static final String D(@NotNull LAKRenderModel lAKRenderModel) {
        Intrinsics.checkNotNullParameter(lAKRenderModel, "<this>");
        try {
            String json = new Gson().toJson(lAKRenderModel, new b().getType());
            ms.a.a("LAKRenderModel", "LAKRenderModel json:\n" + json);
            return json;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final boolean a(@NotNull WinkEditDataWrapper winkEditDataWrapper, @Nullable dr drVar) {
        WinkEditData copy;
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        if (drVar == null) {
            return false;
        }
        List<MediaModel> J = drVar.J();
        if (winkEditDataWrapper.getEditDatas().size() != J.size()) {
            return false;
        }
        int size = J.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
            WinkEditData winkEditData = winkEditDataWrapper.getEditDatas().get(i3);
            Intrinsics.checkNotNullExpressionValue(winkEditData, "editDatas[index]");
            copy = r7.copy((r37 & 1) != 0 ? r7.mediaModel : null, (r37 & 2) != 0 ? r7.durationUs : 0L, (r37 & 4) != 0 ? r7.stickerModelMap : null, (r37 & 8) != 0 ? r7.filterModelMap : null, (r37 & 16) != 0 ? r7.filterMaterialMap : null, (r37 & 32) != 0 ? r7.stickerExtraMap : null, (r37 & 64) != 0 ? r7.openHDR : false, (r37 & 128) != 0 ? r7.effectModelMap : null, (r37 & 256) != 0 ? r7.renderModelStr : null, (r37 & 512) != 0 ? r7.templateMaterialMap : null, (r37 & 1024) != 0 ? r7.stretchData : null, (r37 & 2048) != 0 ? r7.assetData : null, (r37 & 4096) != 0 ? r7.isLakData : false, (r37 & 8192) != 0 ? r7.mosaicData : null, (r37 & 16384) != 0 ? r7.challengeData : null, (r37 & 32768) != 0 ? r7.manualDeletedChallengeTag : null, (r37 & 65536) != 0 ? r7.isAIElimination : false, (r37 & 131072) != 0 ? winkEditData.aiTemplate : null);
            editDatas.set(i3, copy);
            winkEditDataWrapper.getEditDatas().get(i3).setMediaModel(J.get(i3));
        }
        return true;
    }

    @NotNull
    public static final WinkEditData b(@NotNull WinkEditData winkEditData, @NotNull MediaModel mediaModel, long j3) {
        WinkEditData copy;
        Intrinsics.checkNotNullParameter(winkEditData, "<this>");
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        copy = winkEditData.copy((r37 & 1) != 0 ? winkEditData.mediaModel : mediaModel, (r37 & 2) != 0 ? winkEditData.durationUs : j3, (r37 & 4) != 0 ? winkEditData.stickerModelMap : null, (r37 & 8) != 0 ? winkEditData.filterModelMap : null, (r37 & 16) != 0 ? winkEditData.filterMaterialMap : null, (r37 & 32) != 0 ? winkEditData.stickerExtraMap : null, (r37 & 64) != 0 ? winkEditData.openHDR : false, (r37 & 128) != 0 ? winkEditData.effectModelMap : null, (r37 & 256) != 0 ? winkEditData.renderModelStr : null, (r37 & 512) != 0 ? winkEditData.templateMaterialMap : null, (r37 & 1024) != 0 ? winkEditData.stretchData : null, (r37 & 2048) != 0 ? winkEditData.assetData : null, (r37 & 4096) != 0 ? winkEditData.isLakData : false, (r37 & 8192) != 0 ? winkEditData.mosaicData : null, (r37 & 16384) != 0 ? winkEditData.challengeData : null, (r37 & 32768) != 0 ? winkEditData.manualDeletedChallengeTag : null, (r37 & 65536) != 0 ? winkEditData.isAIElimination : false, (r37 & 131072) != 0 ? winkEditData.aiTemplate : null);
        return copy;
    }

    @NotNull
    public static final WinkEditDataListResult c(@Nullable List<? extends LocalMediaInfo> list) {
        boolean z16;
        List filterNotNull;
        int collectionSizeOrDefault;
        Collection collection;
        List<MediaData> listOf;
        List<? extends LocalMediaInfo> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(list);
            ArrayList<LocalMediaInfo> arrayList = new ArrayList();
            for (Object obj : filterNotNull) {
                if (i.G((LocalMediaInfo) obj)) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (LocalMediaInfo localMediaInfo : arrayList) {
                if (localMediaInfo.mediaWidth == 0 || localMediaInfo.mediaHeight == 0) {
                    ms.a.c("genImageWinkEditDataList", "[genImageMediaModels] invalid image sizze");
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(localMediaInfo.path, options);
                    localMediaInfo.mediaWidth = options.outWidth;
                    localMediaInfo.mediaHeight = options.outHeight;
                }
                WinkImageTavCut.Companion companion = WinkImageTavCut.INSTANCE;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(i.d(localMediaInfo, 10000000L));
                arrayList2.add(companion.a(listOf));
            }
            collection = CollectionsKt___CollectionsKt.toCollection(arrayList2, new ArrayList());
            return new WinkEditDataListResult(0L, (ArrayList) collection, false, 4, null);
        }
        return new WinkEditDataListResult(0L, new ArrayList(), false, 4, null);
    }

    @NotNull
    public static final WinkEditDataWrapper d(@Nullable ArrayList<LocalMediaInfo> arrayList, int i3, int i16) {
        WinkEditDataListResult c16;
        boolean z16;
        if (i3 == 0) {
            c16 = i(arrayList, false, 2, null);
        } else {
            c16 = c(arrayList);
        }
        String d26 = u.d2();
        long duration = c16.getDuration();
        if (i16 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new WinkEditDataWrapper(d26, Integer.valueOf(i3), c16.c(), arrayList, null, Integer.valueOf(i16), null, duration, z16, null, 0, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, "", false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -274728880, 4095, null);
    }

    @NotNull
    public static final WinkEditDataWrapper e(@Nullable ArrayList<LocalMediaInfo> arrayList, int i3, int i16, boolean z16) {
        WinkEditDataListResult c16;
        boolean z17;
        if (i3 == 0) {
            c16 = h(arrayList, z16);
        } else {
            c16 = c(arrayList);
        }
        String d26 = u.d2();
        long duration = c16.getDuration();
        if (i16 == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        return new WinkEditDataWrapper(d26, Integer.valueOf(i3), c16.c(), arrayList, null, Integer.valueOf(i16), null, duration, z17, null, 0, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, "", false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -274728880, 4095, null);
    }

    public static /* synthetic */ WinkEditDataWrapper f(ArrayList arrayList, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        return d(arrayList, i3, i16);
    }

    public static /* synthetic */ WinkEditDataWrapper g(ArrayList arrayList, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        if ((i17 & 8) != 0) {
            z16 = true;
        }
        return e(arrayList, i3, i16, z16);
    }

    @NotNull
    public static final WinkEditDataListResult h(@Nullable List<? extends LocalMediaInfo> list, boolean z16) {
        boolean z17;
        boolean z18;
        long j3;
        int collectionSizeOrDefault;
        ArrayList arrayList;
        long j16;
        long j17;
        MediaData d16;
        ArrayList arrayListOf;
        List<? extends LocalMediaInfo> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return new WinkEditDataListResult(0L, new ArrayList(), false, 4, null);
        }
        if (i.H(list)) {
            LocalMediaInfo localMediaInfo = list.get(0);
            Intrinsics.checkNotNull(localMediaInfo);
            j16 = 10000000;
            arrayList = CollectionsKt__CollectionsKt.arrayListOf(i.d(localMediaInfo, 10000000L));
            z18 = false;
        } else {
            if (z16 && i.B(list) && QzoneConfig.getWinkTransitionSwitch()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                j3 = QQWinkConstants.DEFAULT_MULTI_PIC_DURATION_US;
            } else {
                j3 = 2500000;
            }
            List<? extends LocalMediaInfo> list3 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            long j18 = 0;
            int i3 = 0;
            for (Object obj : list3) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) obj;
                if (i.E(localMediaInfo2)) {
                    w53.b.f("WinkEditData", "downloadUrl " + i.j(localMediaInfo2) + ", path " + localMediaInfo2.path + " , mMimeType " + localMediaInfo2.mMimeType + ", type " + QAlbumUtil.getMediaType(localMediaInfo2));
                }
                if (i.I(localMediaInfo2)) {
                    j18 += localMediaInfo2.mDuration * 1000;
                    d16 = i.g(localMediaInfo2, false, 2, null);
                } else {
                    if (z18 && (i3 == 0 || i3 == list.size() - 1)) {
                        j17 = j3 - 500000;
                    } else {
                        j17 = j3;
                    }
                    j18 += j17;
                    d16 = i.d(localMediaInfo2, j17);
                }
                arrayList2.add(d16);
                i3 = i16;
            }
            if (z18) {
                j16 = 2500000 * arrayList2.size();
                arrayList = arrayList2;
            } else {
                arrayList = arrayList2;
                j16 = j18;
            }
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WinkVideoTavCut.INSTANCE.d(arrayList, j16));
        return new WinkEditDataListResult(j16, arrayListOf, z18);
    }

    public static /* synthetic */ WinkEditDataListResult i(List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return h(list, z16);
    }

    @NotNull
    public static final String j(@NotNull WinkEditDataWrapper winkEditDataWrapper) {
        int i3;
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isUneditedSingleVideo", WinkExportUtils.N(winkEditDataWrapper));
            jSONObject.put("singleVideo", A(winkEditDataWrapper));
            int i16 = 1;
            if (winkEditDataWrapper.getDuration() >= WinkConfig.f317649a.b()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.put("duration", i3);
            if (TextUtils.isEmpty(winkEditDataWrapper.getTemplateFilePath())) {
                i16 = 0;
            }
            jSONObject.put("template", i16);
            jSONObject.put("isMusicQuick", WinkExportUtils.J(winkEditDataWrapper));
            jSONObject.put("bgmVolumeType", winkEditDataWrapper.getBgmVolumeType());
            jSONObject.put("bgmVolume", Float.valueOf(winkEditDataWrapper.getBgmVolume()));
            jSONObject.put("originVolume", Float.valueOf(winkEditDataWrapper.getOriginVolume()));
            com.tencent.mobileqq.wink.editor.model.a.n(winkEditDataWrapper.getEditDatas().get(0).getMediaModel(), jSONObject);
            String jSONObject2 = jSONObject.toString();
            w53.b.c("WinkEditDataUtils", "getReportEditInfo:" + jSONObject2);
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "{\n        JSONObject().a\u2026$result\")\n        }\n    }");
            return jSONObject2;
        } catch (Exception e16) {
            w53.b.e("WinkEditDataUtils", e16);
            return "";
        }
    }

    @Nullable
    public static final MetaMaterial k(@NotNull WinkEditDataWrapper winkEditDataWrapper) {
        Object orNull;
        Map<String, MetaMaterial> map;
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        orNull = CollectionsKt___CollectionsKt.getOrNull(winkEditDataWrapper.getEditDatas(), 0);
        WinkEditData winkEditData = (WinkEditData) orNull;
        if (winkEditData != null) {
            map = winkEditData.getTemplateMaterialMap();
        } else {
            map = null;
        }
        if (map != null) {
            Iterator<Map.Entry<String, MetaMaterial>> it = map.entrySet().iterator();
            if (it.hasNext()) {
                return it.next().getValue();
            }
        }
        return null;
    }

    @NotNull
    public static final List<MediaClip> l(@NotNull dr drVar) {
        Intrinsics.checkNotNullParameter(drVar, "<this>");
        return m(drVar.n(), drVar instanceof WinkVideoTavCut);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        if (r1 != null) goto L30;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<MediaClip> m(@Nullable List<WinkEditData> list, boolean z16) {
        List<MediaClip> emptyList;
        Object orNull;
        ArrayList arrayList = new ArrayList();
        if (z16) {
            if (list != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
                WinkEditData winkEditData = (WinkEditData) orNull;
                if (winkEditData != null) {
                    emptyList = t(winkEditData);
                }
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            arrayList.addAll(emptyList);
        } else if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.addAll(t((WinkEditData) it.next()));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final ArrayList<LocalMediaInfo> n(@NotNull WinkEditDataWrapper winkEditDataWrapper) {
        Collection collection;
        int collectionSizeOrDefault;
        String str;
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
        if (editDatas != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = editDatas.iterator();
            while (it.hasNext()) {
                List<MediaClip> list = ((WinkEditData) it.next()).getMediaModel().videos;
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it5 = list.iterator();
                while (it5.hasNext()) {
                    ResourceModel resourceModel = ((MediaClip) it5.next()).resource;
                    if (resourceModel != null) {
                        str = resourceModel.path;
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        arrayList2.add(str);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList2) {
                    if (FileUtils.fileExists((String) obj)) {
                        arrayList3.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
                Iterator it6 = arrayList3.iterator();
                while (it6.hasNext()) {
                    arrayList4.add(WinkExportUtils.b((String) it6.next()));
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList4);
            }
            collection = CollectionsKt___CollectionsKt.toCollection(arrayList, new ArrayList());
            ArrayList<LocalMediaInfo> arrayList5 = (ArrayList) collection;
            if (arrayList5 != null) {
                return arrayList5;
            }
        }
        return new ArrayList<>();
    }

    @NotNull
    public static final Pair<Integer, Integer> o(@NotNull WinkEditDataWrapper winkEditDataWrapper) {
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        int i3 = 0;
        int i16 = 0;
        for (WinkEditData winkEditData : winkEditDataWrapper.getEditDatas()) {
            i3 += com.tencent.mobileqq.wink.editor.model.a.p(winkEditData.getMediaModel());
            i16 += com.tencent.mobileqq.wink.editor.model.a.s(winkEditData.getMediaModel());
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Nullable
    public static final String p(@NotNull WinkEditData winkEditData) {
        Intrinsics.checkNotNullParameter(winkEditData, "<this>");
        if (winkEditData.isLakData() && winkEditData.getRenderModelStr() != null) {
            return winkEditData.getRenderModelStr();
        }
        return null;
    }

    @Nullable
    public static final LAKRenderModel q(@NotNull WinkEditData winkEditData) {
        Intrinsics.checkNotNullParameter(winkEditData, "<this>");
        String renderModelStr = winkEditData.getRenderModelStr();
        if (renderModelStr != null) {
            Object fromJson = new Gson().fromJson(renderModelStr, new a().getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson<LAKRenderModel>(it, autoTestBeans)");
            return (LAKRenderModel) fromJson;
        }
        return null;
    }

    @NotNull
    public static final String r(@NotNull WinkEditDataWrapper winkEditDataWrapper) {
        boolean z16;
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        String templateFilePath = winkEditDataWrapper.getTemplateFilePath();
        if (templateFilePath != null && templateFilePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String w3 = WinkExportUtils.w();
            Intrinsics.checkNotNullExpressionValue(w3, "{\n        getDefaultTemplateDir()\n    }");
            return w3;
        }
        String templateFilePath2 = winkEditDataWrapper.getTemplateFilePath();
        Intrinsics.checkNotNull(templateFilePath2);
        String D = WinkExportUtils.D(templateFilePath2);
        if (D == null) {
            D = WinkExportUtils.w();
        }
        Intrinsics.checkNotNullExpressionValue(D, "{\n        WinkExportUtil\u2026efaultTemplateDir()\n    }");
        return D;
    }

    @NotNull
    public static final Map<String, TransitionModel> s(@NotNull WinkEditData winkEditData) {
        Intrinsics.checkNotNullParameter(winkEditData, "<this>");
        return winkEditData.getMediaModel().transitions;
    }

    @NotNull
    public static final List<MediaClip> t(@NotNull WinkEditData winkEditData) {
        Intrinsics.checkNotNullParameter(winkEditData, "<this>");
        return winkEditData.getMediaModel().videos;
    }

    @Nullable
    public static final Pair<Integer, Integer> u(@NotNull WinkEditDataWrapper winkEditDataWrapper) {
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        try {
            MediaModel mediaModel = winkEditDataWrapper.getEditDatas().get(0).getMediaModel();
            BackgroundModel backgroundModel = mediaModel.backgroundModel;
            Intrinsics.checkNotNull(backgroundModel);
            SizeF sizeF = backgroundModel.renderSize;
            Intrinsics.checkNotNull(sizeF);
            int i3 = (int) sizeF.width;
            SizeF sizeF2 = mediaModel.backgroundModel.renderSize;
            Intrinsics.checkNotNull(sizeF2);
            int i16 = (int) sizeF2.height;
            if (i3 == 0 || i16 == 0) {
                i16 = 1280;
                i3 = 720;
            }
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
        } catch (Exception e16) {
            ms.a.e("WinkExportManager", e16);
            return new Pair<>(720, 1280);
        }
    }

    public static final boolean v(@NotNull WinkEditDataWrapper winkEditDataWrapper) {
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        ArrayList<LocalMediaInfo> originMediaInfos = winkEditDataWrapper.getOriginMediaInfos();
        if (originMediaInfos != null) {
            for (LocalMediaInfo localMediaInfo : originMediaInfos) {
                if (com.tencent.mobileqq.wink.editor.export.a.f320174a.d(localMediaInfo.mediaWidth, localMediaInfo.mediaHeight)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static final boolean w(@NotNull WinkEditData winkEditData) {
        Intrinsics.checkNotNullParameter(winkEditData, "<this>");
        return com.tencent.mobileqq.wink.editor.model.a.v(winkEditData.getMediaModel());
    }

    public static final boolean x(@NotNull WinkEditDataWrapper winkEditDataWrapper) {
        boolean z16;
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        if (winkEditDataWrapper.getDuration() > dr.INSTANCE.c() || !TextUtils.isEmpty(winkEditDataWrapper.getTemplateFilePath())) {
            return true;
        }
        ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
        if (!(editDatas instanceof Collection) || !editDatas.isEmpty()) {
            Iterator<T> it = editDatas.iterator();
            while (it.hasNext()) {
                if (com.tencent.mobileqq.wink.editor.model.a.y(((WinkEditData) it.next()).getMediaModel())) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            return true;
        }
        return false;
    }

    public static final boolean y(@NotNull WinkEditDataWrapper winkEditDataWrapper) {
        boolean z16;
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        if (!TextUtils.isEmpty(winkEditDataWrapper.getTemplateFilePath())) {
            return true;
        }
        ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
        if (!(editDatas instanceof Collection) || !editDatas.isEmpty()) {
            Iterator<T> it = editDatas.iterator();
            while (it.hasNext()) {
                if (com.tencent.mobileqq.wink.editor.model.a.y(((WinkEditData) it.next()).getMediaModel())) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            return true;
        }
        return false;
    }

    public static final boolean z(@NotNull WinkEditDataWrapper winkEditDataWrapper) {
        boolean z16;
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "<this>");
        if (!TextUtils.isEmpty(winkEditDataWrapper.getTemplateFilePath())) {
            return false;
        }
        ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
        if (!(editDatas instanceof Collection) || !editDatas.isEmpty()) {
            Iterator<T> it = editDatas.iterator();
            while (it.hasNext()) {
                if (com.tencent.mobileqq.wink.editor.model.a.z(((WinkEditData) it.next()).getMediaModel())) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z16) {
            return false;
        }
        return true;
    }
}
