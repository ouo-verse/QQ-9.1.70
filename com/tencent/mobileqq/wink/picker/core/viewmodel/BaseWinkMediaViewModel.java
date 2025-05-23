package com.tencent.mobileqq.wink.picker.core.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\"\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00130\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u000fH$J\"\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00130\u00120\u00152\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\b\u0010\u001a\u001a\u00020\u0004H&J\b\u0010\u001b\u001a\u00020\u0004H&J\b\u0010\u001d\u001a\u00020\u001cH&J\u001c\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015J<\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00130\u00122\u001e\u0010!\u001a\u001a\u0012\u0004\u0012\u00020\u0017\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00130\u00120 2\u0006\u0010#\u001a\u00020\"H\u0004J\u0010\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0004J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001cR\u0016\u0010(\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u001c0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010,R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00158\u0006\u00a2\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u00100R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Le93/d;", "action", "", "onMediaInit", "Le93/a;", "onMediaUpdate", "onMediaAdded", "onMediaMoved", "onMediaRemoved", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "updateIndexInSelectedMedia", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "getMediaUIStateLiveData", "Landroidx/lifecycle/LiveData;", "getMediaUIState", "", "albumId", "switchAlbum", "fetchFirstPageMedia", "loadMoreMedia", "", "needLoadMore", "selectedMediaChangedActionLiveData", "observeSelectedMediaChange", "", "albumIdToMediaUIStateData", "Lcom/tencent/mobileqq/wink/picker/core/repository/b;", "mediaRepoData", "localMediaInfo", "updateLocalMediaInfo", "hasPermission", "updateStoragePermission", "isSelectedMediaChangedActionLiveDataAdd", "Z", "Landroidx/lifecycle/MutableLiveData;", "_mediaChangedActionMutableLiveData", "Landroidx/lifecycle/MutableLiveData;", "mediaChangedActionLiveData", "Landroidx/lifecycle/LiveData;", "getMediaChangedActionLiveData", "()Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "mediaFilter", "Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "_mediaStoragePermissionMutableLiveData", "mediaStoragePermissionLiveData", "getMediaStoragePermissionLiveData", "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/text/SimpleDateFormat;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class BaseWinkMediaViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<e93.a> _mediaChangedActionMutableLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _mediaStoragePermissionMutableLiveData;

    @NotNull
    private final SimpleDateFormat dateFormat;
    private boolean isSelectedMediaChangedActionLiveDataAdd;

    @NotNull
    private final LiveData<e93.a> mediaChangedActionLiveData;

    @NotNull
    private final MediaFilter mediaFilter;

    @NotNull
    private final LiveData<Boolean> mediaStoragePermissionLiveData;

    public BaseWinkMediaViewModel() {
        MutableLiveData<e93.a> mutableLiveData = new MutableLiveData<>();
        this._mediaChangedActionMutableLiveData = mutableLiveData;
        this.mediaChangedActionLiveData = mutableLiveData;
        this.mediaFilter = com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getSelectMediaFilter();
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._mediaStoragePermissionMutableLiveData = mutableLiveData2;
        this.mediaStoragePermissionLiveData = mutableLiveData2;
        this.dateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT, Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeSelectedMediaChange$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onMediaAdded(e93.a action) {
        e93.b bVar;
        if (action instanceof e93.b) {
            bVar = (e93.b) action;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.getAddedMedia().selectStatus = 1;
            e93.i.O(bVar.getAddedMedia(), bVar.getIndexInSelectedMedia());
            this._mediaChangedActionMutableLiveData.setValue(new e93.b(bVar.getIndexInSelectedMedia(), bVar.getAddedMedia(), bVar.c()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onMediaInit(e93.d action) {
        if (action != null) {
            int i3 = 0;
            for (Object obj : action.a()) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
                localMediaInfo.selectStatus = 1;
                e93.i.O(localMediaInfo, i3);
                i3 = i16;
            }
            onMediaInit(action.a());
            this._mediaChangedActionMutableLiveData.setValue(new e93.d(action.a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onMediaMoved(e93.a action) {
        e93.e eVar;
        if (action instanceof e93.e) {
            eVar = (e93.e) action;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            updateIndexInSelectedMedia(eVar.c());
            this._mediaChangedActionMutableLiveData.setValue(new e93.h(eVar.c()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onMediaRemoved(e93.a action) {
        e93.f fVar;
        if (action instanceof e93.f) {
            fVar = (e93.f) action;
        } else {
            fVar = null;
        }
        if (fVar != null) {
            if (!fVar.c().contains(fVar.getRemovedMedia())) {
                fVar.getRemovedMedia().selectStatus = 2;
            }
            updateIndexInSelectedMedia(fVar.c());
            this._mediaChangedActionMutableLiveData.setValue(new e93.h(fVar.c()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onMediaUpdate(e93.a action) {
        e93.h hVar;
        if (action instanceof e93.h) {
            hVar = (e93.h) action;
        } else {
            hVar = null;
        }
        if (hVar != null) {
            updateIndexInSelectedMedia(hVar.a());
            this._mediaChangedActionMutableLiveData.setValue(new e93.h(hVar.a()));
        }
    }

    private final void updateIndexInSelectedMedia(List<? extends LocalMediaInfo> selectedMedia) {
        int i3 = 0;
        for (Object obj : selectedMedia) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            e93.i.O((LocalMediaInfo) obj, i3);
            i3 = i16;
        }
    }

    public abstract void fetchFirstPageMedia();

    @NotNull
    public final LiveData<e93.a> getMediaChangedActionLiveData() {
        return this.mediaChangedActionLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getMediaStoragePermissionLiveData() {
        return this.mediaStoragePermissionLiveData;
    }

    @NotNull
    public abstract LiveData<UIStateData<List<LocalMediaInfo>>> getMediaUIState(@NotNull MediaType mediaType);

    @NotNull
    protected abstract MediatorLiveData<UIStateData<List<LocalMediaInfo>>> getMediaUIStateLiveData(@NotNull MediaType mediaType);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final UIStateData<List<LocalMediaInfo>> getMediaUIStateLiveData(@NotNull Map<String, UIStateData<List<LocalMediaInfo>>> albumIdToMediaUIStateData, @NotNull com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData) {
        Intrinsics.checkNotNullParameter(albumIdToMediaUIStateData, "albumIdToMediaUIStateData");
        Intrinsics.checkNotNullParameter(mediaRepoData, "mediaRepoData");
        String albumId = mediaRepoData.getAlbumId();
        UIStateData<List<LocalMediaInfo>> initData = albumIdToMediaUIStateData.get(albumId);
        if (initData == null) {
            initData = UIStateData.obtainEmpty();
            initData.setDataList(new ArrayList());
            Intrinsics.checkNotNullExpressionValue(initData, "initData");
            albumIdToMediaUIStateData.put(albumId, initData);
        }
        UIStateData<List<LocalMediaInfo>> uIStateData = initData;
        uIStateData.setState(3);
        uIStateData.setFinish(!mediaRepoData.getHasMore());
        return uIStateData;
    }

    public abstract void loadMoreMedia();

    public abstract boolean needLoadMore();

    /* JADX WARN: Multi-variable type inference failed */
    public final void observeSelectedMediaChange(@NotNull MediaType mediaType, @NotNull LiveData<e93.a> selectedMediaChangedActionLiveData) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(selectedMediaChangedActionLiveData, "selectedMediaChangedActionLiveData");
        if (this.isSelectedMediaChangedActionLiveDataAdd) {
            return;
        }
        this.isSelectedMediaChangedActionLiveDataAdd = true;
        getMediaUIStateLiveData(mediaType).removeSource(selectedMediaChangedActionLiveData);
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediaUIStateLiveData = getMediaUIStateLiveData(mediaType);
        final Function1<e93.a, Unit> function1 = new Function1<e93.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel$observeSelectedMediaChange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e93.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e93.a action) {
                MutableLiveData mutableLiveData;
                if (action instanceof e93.d) {
                    BaseWinkMediaViewModel.this.onMediaInit((e93.d) action);
                    return;
                }
                if (action instanceof e93.h) {
                    BaseWinkMediaViewModel baseWinkMediaViewModel = BaseWinkMediaViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(action, "action");
                    baseWinkMediaViewModel.onMediaUpdate(action);
                    return;
                }
                if (action instanceof e93.b) {
                    BaseWinkMediaViewModel baseWinkMediaViewModel2 = BaseWinkMediaViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(action, "action");
                    baseWinkMediaViewModel2.onMediaAdded(action);
                } else if (action instanceof e93.e) {
                    BaseWinkMediaViewModel baseWinkMediaViewModel3 = BaseWinkMediaViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(action, "action");
                    baseWinkMediaViewModel3.onMediaMoved(action);
                } else if (action instanceof e93.f) {
                    BaseWinkMediaViewModel baseWinkMediaViewModel4 = BaseWinkMediaViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(action, "action");
                    baseWinkMediaViewModel4.onMediaRemoved(action);
                } else if (action instanceof e93.c) {
                    mutableLiveData = BaseWinkMediaViewModel.this._mediaChangedActionMutableLiveData;
                    mutableLiveData.setValue(new e93.c());
                }
            }
        };
        mediaUIStateLiveData.addSource(selectedMediaChangedActionLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseWinkMediaViewModel.observeSelectedMediaChange$lambda$0(Function1.this, obj);
            }
        });
    }

    public abstract void onMediaInit(@NotNull List<? extends LocalMediaInfo> selectedMedia);

    public abstract void switchAlbum(@Nullable String albumId);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final LocalMediaInfo updateLocalMediaInfo(@NotNull LocalMediaInfo localMediaInfo) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        localMediaInfo.thumbWidth = 300;
        localMediaInfo.thumbHeight = 300;
        e93.i.X(localMediaInfo, d93.b.f393235a.a(localMediaInfo, this.mediaFilter));
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(this.dateFormat.format(Long.valueOf(localMediaInfo.addedDate * 1000)));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        String str = "";
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            m476constructorimpl = "";
        }
        String str2 = (String) m476constructorimpl;
        if (e93.i.G(localMediaInfo)) {
            str = "\u56fe\u7247";
        } else if (e93.i.I(localMediaInfo)) {
            str = "\u89c6\u9891";
        }
        e93.i.K(localMediaInfo, str + "\u521b\u5efa\u4e8e" + str2);
        return localMediaInfo;
    }

    public final void updateStoragePermission(boolean hasPermission) {
        if (!Intrinsics.areEqual(Boolean.valueOf(hasPermission), this._mediaStoragePermissionMutableLiveData.getValue())) {
            this._mediaStoragePermissionMutableLiveData.setValue(Boolean.valueOf(hasPermission));
        }
    }
}
