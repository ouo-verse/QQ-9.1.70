package com.tencent.mobileqq.wink.picker.core.viewmodel;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.repository.a;
import com.tencent.richframework.data.base.UIStateData;
import e93.QZoneAlbumInfo;
import e93.QZoneAlbumStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010%\n\u0002\b\u0012\u0018\u0000 G2\u00020\u0001:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0003J\b\u0010\f\u001a\u00020\u0002H\u0016J\"\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\"\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u00142\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0016\u0010\u0018\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0006\u0010\u001f\u001a\u00020\u0004R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010&R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0006\u00a2\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R \u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R \u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00109R,\u0010>\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u00109R&\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R)\u0010D\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u00148\u0006\u00a2\u0006\f\n\u0004\bB\u0010)\u001a\u0004\bC\u0010+\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;", "", "newAlbumId", "", "T1", "Le93/j;", "qZoneAlbumInfo", "S1", "Lcom/tencent/mobileqq/wink/picker/core/repository/b;", "mediaRepoData", "U1", "getLogTag", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "getMediaUIStateLiveData", "Landroidx/lifecycle/LiveData;", "getMediaUIState", "", "selectedMedia", "onMediaInit", "albumId", "switchAlbum", "fetchFirstPageMedia", "loadMoreMedia", "", "needLoadMore", "O1", "Lcom/tencent/mobileqq/wink/picker/core/repository/m;", "i", "Lcom/tencent/mobileqq/wink/picker/core/repository/m;", "qZoneMediaRepository", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_qZoneAlbumMutableLiveData", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "qZoneAlbumLiveData", "D", "_queryAlbumFinishMutableLiveData", "E", "R1", "queryAlbumFinishLiveData", UserInfo.SEX_FEMALE, "Le93/j;", "G", "Ljava/lang/String;", "currentAlbumId", "", "H", "Ljava/util/Map;", "albumIdToLoadingStatus", "I", "qZoneIdToLocalMedia", "J", "albumIdToMediaUIStateData", "K", "Landroidx/lifecycle/MediatorLiveData;", "mediaMediatorLiveData", "L", "P1", "mediaUIStateLiveData", "<init>", "()V", "M", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class v extends BaseWinkMediaViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<QZoneAlbumInfo> qZoneAlbumLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<QZoneAlbumInfo> _queryAlbumFinishMutableLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<QZoneAlbumInfo> queryAlbumFinishLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QZoneAlbumInfo qZoneAlbumInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String currentAlbumId;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Map<String, Boolean> albumIdToLoadingStatus;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Map<String, LocalMediaInfo> qZoneIdToLocalMedia;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Map<String, UIStateData<List<LocalMediaInfo>>> albumIdToMediaUIStateData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediaMediatorLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<LocalMediaInfo>>> mediaUIStateLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.picker.core.repository.m qZoneMediaRepository;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<QZoneAlbumInfo> _qZoneAlbumMutableLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/core/viewmodel/v$a", "Lcom/tencent/mobileqq/wink/picker/core/repository/a$b;", "Le93/j;", "qZoneAlbumInfo", "", "a", "Lcom/tencent/mobileqq/wink/picker/core/repository/b;", "mediaRepoData", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements a.b {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.repository.a.b
        public void a(@NotNull QZoneAlbumInfo qZoneAlbumInfo) {
            Intrinsics.checkNotNullParameter(qZoneAlbumInfo, "qZoneAlbumInfo");
            v.this.S1(qZoneAlbumInfo);
        }

        @Override // com.tencent.mobileqq.wink.picker.core.repository.a.b
        public void b(@NotNull com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData) {
            Intrinsics.checkNotNullParameter(mediaRepoData, "mediaRepoData");
            v.this.U1(mediaRepoData);
        }
    }

    public v() {
        com.tencent.mobileqq.wink.picker.core.repository.m mVar = new com.tencent.mobileqq.wink.picker.core.repository.m();
        this.qZoneMediaRepository = mVar;
        MutableLiveData<QZoneAlbumInfo> mutableLiveData = new MutableLiveData<>();
        this._qZoneAlbumMutableLiveData = mutableLiveData;
        this.qZoneAlbumLiveData = mutableLiveData;
        MutableLiveData<QZoneAlbumInfo> mutableLiveData2 = new MutableLiveData<>();
        this._queryAlbumFinishMutableLiveData = mutableLiveData2;
        this.queryAlbumFinishLiveData = mutableLiveData2;
        this.currentAlbumId = "";
        this.albumIdToLoadingStatus = new LinkedHashMap();
        this.qZoneIdToLocalMedia = new LinkedHashMap();
        this.albumIdToMediaUIStateData = new LinkedHashMap();
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediatorLiveData = new MediatorLiveData<>();
        this.mediaMediatorLiveData = mediatorLiveData;
        this.mediaUIStateLiveData = mediatorLiveData;
        mVar.mediaQueryListener = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(QZoneAlbumInfo qZoneAlbumInfo) {
        if (qZoneAlbumInfo.a().isEmpty()) {
            return;
        }
        this._qZoneAlbumMutableLiveData.postValue(qZoneAlbumInfo);
        this._queryAlbumFinishMutableLiveData.postValue(qZoneAlbumInfo);
        this.qZoneAlbumInfo = qZoneAlbumInfo;
        if ((!qZoneAlbumInfo.a().isEmpty()) && qZoneAlbumInfo.getAlbumMediaTotalNum() > 0) {
            qZoneAlbumInfo.a().get(0).g(true);
        }
    }

    private final void T1(String newAlbumId) {
        List<QZoneAlbumStruct> a16;
        this.currentAlbumId = newAlbumId;
        QZoneAlbumInfo value = this._qZoneAlbumMutableLiveData.getValue();
        if (value != null && (a16 = value.a()) != null) {
            for (QZoneAlbumStruct qZoneAlbumStruct : a16) {
                qZoneAlbumStruct.g(Intrinsics.areEqual(qZoneAlbumStruct.getAlbumId(), this.currentAlbumId));
            }
        }
        MutableLiveData<QZoneAlbumInfo> mutableLiveData = this._qZoneAlbumMutableLiveData;
        mutableLiveData.setValue(mutableLiveData.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void U1(com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List<LocalMediaInfo> list;
        this.albumIdToLoadingStatus.put(mediaRepoData.getAlbumId(), Boolean.FALSE);
        if (!mediaRepoData.getIsSuccess()) {
            return;
        }
        if (this.qZoneIdToLocalMedia.isEmpty()) {
            Iterator<T> it = mediaRepoData.e().iterator();
            while (it.hasNext()) {
                updateLocalMediaInfo((LocalMediaInfo) it.next());
            }
            list = mediaRepoData.e();
        } else {
            List<LocalMediaInfo> e16 = mediaRepoData.e();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(e16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (LocalMediaInfo localMediaInfo : e16) {
                LocalMediaInfo localMediaInfo2 = this.qZoneIdToLocalMedia.get(e93.i.v(localMediaInfo));
                if (localMediaInfo2 == null) {
                    Map<String, LocalMediaInfo> map = this.qZoneIdToLocalMedia;
                    String v3 = e93.i.v(localMediaInfo);
                    Intrinsics.checkNotNull(v3);
                    map.put(v3, localMediaInfo);
                } else {
                    localMediaInfo = localMediaInfo2;
                }
                arrayList.add(localMediaInfo);
            }
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                arrayList2.add(updateLocalMediaInfo((LocalMediaInfo) it5.next()));
            }
            list = CollectionsKt___CollectionsKt.toList(arrayList2);
        }
        com.tencent.mobileqq.wink.picker.core.repository.b b16 = com.tencent.mobileqq.wink.picker.core.repository.b.b(mediaRepoData, null, list, false, false, null, 29, null);
        UIStateData<List<LocalMediaInfo>> mediaUIStateLiveData = getMediaUIStateLiveData(this.albumIdToMediaUIStateData, b16);
        mediaUIStateLiveData.getData().addAll(b16.e());
        if (mediaUIStateLiveData.getData().isEmpty()) {
            mediaUIStateLiveData.setState(0);
        }
        if (Intrinsics.areEqual(b16.getAlbumId(), this.currentAlbumId)) {
            this.mediaMediatorLiveData.postValue(mediaUIStateLiveData);
        }
    }

    public final void O1() {
        w53.b.f("WinkQZoneMediaViewModel", "[fetchQZoneAlbum] ==> start");
        this.qZoneMediaRepository.e();
    }

    @NotNull
    public final LiveData<UIStateData<List<LocalMediaInfo>>> P1() {
        return this.mediaUIStateLiveData;
    }

    @NotNull
    public final LiveData<QZoneAlbumInfo> Q1() {
        return this.qZoneAlbumLiveData;
    }

    @NotNull
    public final LiveData<QZoneAlbumInfo> R1() {
        return this.queryAlbumFinishLiveData;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    public void fetchFirstPageMedia() {
        String str;
        List<QZoneAlbumStruct> a16;
        Object orNull;
        QZoneAlbumInfo qZoneAlbumInfo = this.qZoneAlbumInfo;
        if (qZoneAlbumInfo != null && (a16 = qZoneAlbumInfo.a()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(a16, 0);
            QZoneAlbumStruct qZoneAlbumStruct = (QZoneAlbumStruct) orNull;
            if (qZoneAlbumStruct != null) {
                str = qZoneAlbumStruct.getAlbumId();
                switchAlbum(str);
            }
        }
        str = null;
        switchAlbum(str);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkQZoneMediaViewModel";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    @NotNull
    public LiveData<UIStateData<List<LocalMediaInfo>>> getMediaUIState(@NotNull MediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        return getMediaUIStateLiveData(mediaType);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    @NotNull
    protected MediatorLiveData<UIStateData<List<LocalMediaInfo>>> getMediaUIStateLiveData(@NotNull MediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        return this.mediaMediatorLiveData;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    public void loadMoreMedia() {
        if (needLoadMore()) {
            this.albumIdToLoadingStatus.put(this.currentAlbumId, Boolean.TRUE);
            com.tencent.mobileqq.wink.picker.core.repository.a.b(this.qZoneMediaRepository, this.currentAlbumId, 0, null, 6, null);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    public boolean needLoadMore() {
        boolean z16;
        UIStateData<List<LocalMediaInfo>> value = this.mediaMediatorLiveData.getValue();
        if (value != null && !value.getIsFinish()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Map<String, Boolean> map = this.albumIdToLoadingStatus;
            String str = this.currentAlbumId;
            Boolean bool = map.get(str);
            if (bool == null) {
                bool = Boolean.FALSE;
                map.put(str, bool);
            }
            if (!bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        if (r3 == false) goto L17;
     */
    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMediaInit(@NotNull List<? extends LocalMediaInfo> selectedMedia) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        boolean z16;
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = selectedMedia.iterator();
        while (true) {
            boolean z17 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) next;
            if (e93.i.E(localMediaInfo)) {
                String v3 = e93.i.v(localMediaInfo);
                if (v3 != null && v3.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
            }
            z17 = false;
            if (z17) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Map<String, LocalMediaInfo> map = this.qZoneIdToLocalMedia;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : arrayList) {
                String v16 = e93.i.v((LocalMediaInfo) obj);
                Intrinsics.checkNotNull(v16);
                linkedHashMap.put(v16, obj);
            }
            map.putAll(linkedHashMap);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    public void switchAlbum(@Nullable String albumId) {
        boolean z16;
        if (albumId != null && albumId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.mediaMediatorLiveData.setValue(UIStateData.obtainError(""));
            O1();
        } else {
            if (Intrinsics.areEqual(this.currentAlbumId, albumId)) {
                return;
            }
            T1(albumId);
            UIStateData<List<LocalMediaInfo>> uIStateData = this.albumIdToMediaUIStateData.get(this.currentAlbumId);
            if (uIStateData == null) {
                this.mediaMediatorLiveData.setValue(UIStateData.obtainEmpty());
                com.tencent.mobileqq.wink.picker.core.repository.a.b(this.qZoneMediaRepository, this.currentAlbumId, 0, null, 6, null);
            } else {
                this.mediaMediatorLiveData.setValue(uIStateData);
            }
        }
    }
}
