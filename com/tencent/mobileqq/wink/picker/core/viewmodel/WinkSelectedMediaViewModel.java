package com.tencent.mobileqq.wink.picker.core.viewmodel;

import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper;
import com.tencent.mobileqq.wink.picker.MediaInfo;
import com.tencent.mobileqq.wink.picker.core.repository.WinkSelectedLocalMediaRepository;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 72\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bH\u0010IJ8\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0007J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\b\u0010\u0016\u001a\u00020\nH\u0007J\b\u0010\u0017\u001a\u00020\nH\u0014J\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\nR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006\u00a2\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001c0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u001c008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\"\u0010<\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010@\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00107\u001a\u0004\b>\u00109\"\u0004\b?\u0010;R\"\u0010G\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "", "inputMediaPaths", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "queryMedia", "tempCapturedMedia", "U1", "getLogTag", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "toAddedMedia", "", "insertIndex", "O1", "fromPosInSelectedMediaList", "toPosInSelectedMediaList", "c2", "posInSelectedMediaList", "toRemovedMedia", "d2", "Q1", "onCleared", "X1", "W1", "", "b2", "Le93/a;", "action", "i2", "e2", "Lcom/tencent/mobileqq/wink/picker/core/repository/WinkSelectedLocalMediaRepository;", "i", "Lcom/tencent/mobileqq/wink/picker/core/repository/WinkSelectedLocalMediaRepository;", "selectedLocalMediaRepo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "_selectedMedia", BdhLogUtil.LogTag.Tag_Conn, "getSelectedMedia", "()Ljava/util/List;", "selectedMedia", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "_selectedMediaChangedActionMutableLiveData", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "selectedMediaChangedActionLiveData", UserInfo.SEX_FEMALE, "I", "S1", "()I", "g2", "(I)V", "maxSelectMediaSize", "G", "R1", "f2", "alreadySelectedMediaCount", "H", "Z", "T1", "()Z", SemanticAttributes.DbSystemValues.H2, "(Z)V", "needFaceDetectWhenSelect", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkSelectedMediaViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> selectedMedia;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<e93.a> _selectedMediaChangedActionMutableLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<e93.a> selectedMediaChangedActionLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private int maxSelectMediaSize;

    /* renamed from: G, reason: from kotlin metadata */
    private int alreadySelectedMediaCount;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean needFaceDetectWhenSelect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkSelectedLocalMediaRepository selectedLocalMediaRepo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> _selectedMedia;

    public WinkSelectedMediaViewModel() {
        ArrayList arrayList = new ArrayList();
        this._selectedMedia = arrayList;
        this.selectedMedia = arrayList;
        MutableLiveData<e93.a> mutableLiveData = new MutableLiveData<>();
        this._selectedMediaChangedActionMutableLiveData = mutableLiveData;
        this.selectedMediaChangedActionLiveData = mutableLiveData;
        this.maxSelectMediaSize = 35;
    }

    public static /* synthetic */ void P1(WinkSelectedMediaViewModel winkSelectedMediaViewModel, LocalMediaInfo localMediaInfo, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        winkSelectedMediaViewModel.O1(localMediaInfo, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<LocalMediaInfo> U1(List<String> inputMediaPaths, List<? extends LocalMediaInfo> queryMedia, List<? extends LocalMediaInfo> tempCapturedMedia) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        int mapCapacity2;
        int coerceAtLeast2;
        List<? extends LocalMediaInfo> list = queryMedia;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list) {
            linkedHashMap.put(((LocalMediaInfo) obj).path, obj);
        }
        List<? extends LocalMediaInfo> list2 = tempCapturedMedia;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast2);
        for (Object obj2 : list2) {
            linkedHashMap2.put(((LocalMediaInfo) obj2).path, obj2);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : inputMediaPaths) {
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) linkedHashMap.get(str);
            if (localMediaInfo == null) {
                localMediaInfo = (LocalMediaInfo) linkedHashMap2.get(str);
            }
            if (localMediaInfo != null) {
                arrayList.add(localMediaInfo);
            }
        }
        return arrayList;
    }

    @MainThread
    public final void O1(@NotNull LocalMediaInfo toAddedMedia, int insertIndex) {
        Intrinsics.checkNotNullParameter(toAddedMedia, "toAddedMedia");
        List<LocalMediaInfo> list = this._selectedMedia;
        if (!b2()) {
            return;
        }
        if (insertIndex >= 0 && insertIndex <= list.size()) {
            list.add(insertIndex, toAddedMedia);
        } else {
            list.add(toAddedMedia);
        }
        this._selectedMediaChangedActionMutableLiveData.setValue(new e93.b(list.size() - 1, toAddedMedia, list));
        if (!b2()) {
            this._selectedMediaChangedActionMutableLiveData.postValue(new e93.c());
        }
        if (e93.i.I(toAddedMedia) && !e93.i.E(toAddedMedia)) {
            ExtractCoverHelper.f320276a.l(toAddedMedia);
        }
    }

    @MainThread
    public final void Q1() {
        List emptyList;
        Iterator<T> it = this._selectedMedia.iterator();
        while (it.hasNext()) {
            ((LocalMediaInfo) it.next()).selectStatus = 2;
        }
        this._selectedMedia.clear();
        MutableLiveData<e93.a> mutableLiveData = this._selectedMediaChangedActionMutableLiveData;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.setValue(new e93.h(emptyList));
        ExtractCoverHelper.f320276a.p();
    }

    /* renamed from: R1, reason: from getter */
    public final int getAlreadySelectedMediaCount() {
        return this.alreadySelectedMediaCount;
    }

    /* renamed from: S1, reason: from getter */
    public final int getMaxSelectMediaSize() {
        return this.maxSelectMediaSize;
    }

    /* renamed from: T1, reason: from getter */
    public final boolean getNeedFaceDetectWhenSelect() {
        return this.needFaceDetectWhenSelect;
    }

    public final int W1() {
        List<LocalMediaInfo> list = this._selectedMedia;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (e93.i.G((LocalMediaInfo) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    public final int X1() {
        List<LocalMediaInfo> list = this._selectedMedia;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (e93.i.I((LocalMediaInfo) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    @NotNull
    public final LiveData<e93.a> Z1() {
        return this.selectedMediaChangedActionLiveData;
    }

    public final void a2() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        String str;
        List<MediaInfo> alreadySelectedMedia = com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getAlreadySelectedMedia();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = alreadySelectedMedia.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MediaInfo mediaInfo = (MediaInfo) next;
            if (!mediaInfo.getMediaType().isLocalMedia() && !mediaInfo.getMediaType().isTempCaptured()) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((MediaInfo) it5.next()).getLocalMediaPath());
        }
        List<MediaInfo> alreadySelectedMedia2 = com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getAlreadySelectedMedia();
        ArrayList<MediaInfo> arrayList3 = new ArrayList();
        for (Object obj : alreadySelectedMedia2) {
            if (((MediaInfo) obj).getMediaType().isQZoneMedia()) {
                arrayList3.add(obj);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        for (MediaInfo mediaInfo2 : arrayList3) {
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            e93.i.J(localMediaInfo, mediaInfo2.getAlbumId());
            localMediaInfo.mediaWidth = mediaInfo2.getWidth();
            localMediaInfo.mediaHeight = mediaInfo2.getHeight();
            e93.i.R(localMediaInfo, mediaInfo2.getQZoneMediaSloc());
            e93.i.S(localMediaInfo, mediaInfo2.getQZoneMediaId());
            e93.i.T(localMediaInfo, mediaInfo2.getQZoneMediaThumbUrl());
            localMediaInfo.thumbWidth = mediaInfo2.getQZoneMediaThumbWidth();
            localMediaInfo.thumbHeight = mediaInfo2.getQZoneMediaThumbHeight();
            e93.i.L(localMediaInfo, mediaInfo2.getQZoneMediaDownloadUrl());
            localMediaInfo.mMediaType = !mediaInfo2.getMediaType().isImage() ? 1 : 0;
            if (mediaInfo2.getMediaType().isImage()) {
                str = "image/jpeg";
            } else {
                str = "video/mp4";
            }
            localMediaInfo.mMimeType = str;
            localMediaInfo.mDuration = mediaInfo2.getDuration();
            arrayList4.add(localMediaInfo);
        }
        List<MediaInfo> alreadySelectedMedia3 = com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getAlreadySelectedMedia();
        ArrayList<MediaInfo> arrayList5 = new ArrayList();
        for (Object obj2 : alreadySelectedMedia3) {
            if (((MediaInfo) obj2).getMediaType().isTempCaptured()) {
                arrayList5.add(obj2);
            }
        }
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10);
        ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault3);
        for (MediaInfo mediaInfo3 : arrayList5) {
            LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
            localMediaInfo2.path = mediaInfo3.getLocalMediaPath();
            localMediaInfo2.isCaptured = true;
            arrayList6.add(localMediaInfo2);
        }
        if (arrayList2.isEmpty() && arrayList4.isEmpty()) {
            this._selectedMediaChangedActionMutableLiveData.setValue(new e93.d(this._selectedMedia));
            return;
        }
        if (arrayList2.isEmpty()) {
            this._selectedMedia.addAll(arrayList4);
            this._selectedMediaChangedActionMutableLiveData.setValue(new e93.d(this._selectedMedia));
        } else {
            WinkSelectedLocalMediaRepository winkSelectedLocalMediaRepository = new WinkSelectedLocalMediaRepository();
            winkSelectedLocalMediaRepository.f(arrayList2, new WinkSelectedMediaViewModel$initSelectedMedia$1$1(arrayList4, arrayList6, this, arrayList2));
            this.selectedLocalMediaRepo = winkSelectedLocalMediaRepository;
        }
    }

    public final boolean b2() {
        if (this._selectedMedia.size() + this.alreadySelectedMediaCount < this.maxSelectMediaSize) {
            return true;
        }
        return false;
    }

    @MainThread
    public final void c2(int fromPosInSelectedMediaList, int toPosInSelectedMediaList) {
        List<LocalMediaInfo> list = this._selectedMedia;
        list.add(toPosInSelectedMediaList, list.remove(fromPosInSelectedMediaList));
        this._selectedMediaChangedActionMutableLiveData.postValue(new e93.e(fromPosInSelectedMediaList, toPosInSelectedMediaList, list));
    }

    @MainThread
    public final void d2(int posInSelectedMediaList, @NotNull LocalMediaInfo toRemovedMedia) {
        Object orNull;
        Intrinsics.checkNotNullParameter(toRemovedMedia, "toRemovedMedia");
        List<LocalMediaInfo> list = this._selectedMedia;
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, posInSelectedMediaList);
        if (((LocalMediaInfo) orNull) != null) {
            list.remove(posInSelectedMediaList);
            this._selectedMediaChangedActionMutableLiveData.setValue(new e93.f(posInSelectedMediaList, toRemovedMedia, list));
            ExtractCoverHelper.f320276a.J(toRemovedMedia);
        }
    }

    public final void e2() {
        this._selectedMediaChangedActionMutableLiveData.postValue(new e93.g());
    }

    public final void f2(int i3) {
        this.alreadySelectedMediaCount = i3;
    }

    public final void g2(int i3) {
        this.maxSelectMediaSize = i3;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkSelectedMediaViewModel";
    }

    @NotNull
    public final List<LocalMediaInfo> getSelectedMedia() {
        return this.selectedMedia;
    }

    public final void h2(boolean z16) {
        this.needFaceDetectWhenSelect = z16;
    }

    public final void i2(@NotNull e93.a action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this._selectedMediaChangedActionMutableLiveData.postValue(action);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        WinkSelectedLocalMediaRepository winkSelectedLocalMediaRepository = this.selectedLocalMediaRepo;
        if (winkSelectedLocalMediaRepository != null) {
            winkSelectedLocalMediaRepository.h();
        }
    }
}
