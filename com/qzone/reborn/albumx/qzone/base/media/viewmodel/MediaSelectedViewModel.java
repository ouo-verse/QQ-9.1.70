package com.qzone.reborn.albumx.qzone.base.media.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import da.c;
import da.d;
import da.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J\"\u0010\u0013\u001a\u00020\u00072\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\tH\u0007J\u0018\u0010\u0015\u001a\u00020\u00072\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0007J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0007J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010 R \u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R#\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010$R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020,0&8\u0006\u00a2\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b0\u0010*R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\t0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010$R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0&8\u0006\u00a2\u0006\f\n\u0004\b4\u0010(\u001a\u0004\b5\u0010*R\"\u0010;\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/base/media/viewmodel/MediaSelectedViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "sourceData", "", "targetData", "", "Q1", "", "isSelectMode", "Z1", "U1", "toAddedMedia", "", "insertIndex", "L1", "toAddedMediaList", "isAddFirst", "N1", "toRemovedMediaList", "P1", "posInSelectedMediaList", "toRemovedMedia", "X1", "", "getLogTag", "i", "Ljava/util/List;", "_selectedMedia", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getSelectedMedia", "()Ljava/util/List;", "selectedMedia", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_selectMediaMutableLiveData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "selectMediaLiveData", "Lda/a;", "E", "_selectedMediaChangedActionMutableLiveData", UserInfo.SEX_FEMALE, "T1", "selectedMediaChangedActionLiveData", "G", "_isSelectMode", "H", "W1", "I", "R1", "()I", "setMaxSelectMediaSize", "(I)V", "maxSelectMediaSize", "<init>", "()V", "J", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class MediaSelectedViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<List<LocalMediaInfo>> _selectMediaMutableLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<List<LocalMediaInfo>> selectMediaLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<da.a> _selectedMediaChangedActionMutableLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<da.a> selectedMediaChangedActionLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isSelectMode;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<Boolean> isSelectMode;

    /* renamed from: I, reason: from kotlin metadata */
    private int maxSelectMediaSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<LocalMediaInfo> _selectedMedia;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<LocalMediaInfo> selectedMedia;

    public MediaSelectedViewModel() {
        ArrayList arrayList = new ArrayList();
        this._selectedMedia = arrayList;
        this.selectedMedia = arrayList;
        MutableLiveData<List<LocalMediaInfo>> mutableLiveData = new MutableLiveData<>();
        this._selectMediaMutableLiveData = mutableLiveData;
        this.selectMediaLiveData = mutableLiveData;
        MutableLiveData<da.a> mutableLiveData2 = new MutableLiveData<>();
        this._selectedMediaChangedActionMutableLiveData = mutableLiveData2;
        this.selectedMediaChangedActionLiveData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(Boolean.TRUE);
        this._isSelectMode = mutableLiveData3;
        this.isSelectMode = mutableLiveData3;
        this.maxSelectMediaSize = 500;
    }

    private final void Q1(List<LocalMediaInfo> sourceData, List<? extends LocalMediaInfo> targetData) {
        final Set set;
        set = CollectionsKt___CollectionsKt.toSet(targetData);
        CollectionsKt__MutableCollectionsKt.removeAll((List) sourceData, (Function1) new Function1<LocalMediaInfo, Boolean>() { // from class: com.qzone.reborn.albumx.qzone.base.media.viewmodel.MediaSelectedViewModel$filterSourceDataDuplicateElements$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LocalMediaInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(set.contains(it));
            }
        });
    }

    public final void L1(LocalMediaInfo toAddedMedia, int insertIndex) {
        Intrinsics.checkNotNullParameter(toAddedMedia, "toAddedMedia");
        List<LocalMediaInfo> list = this._selectedMedia;
        if (!U1()) {
            RFWLog.d(getLogTag(), RFWLog.USR, "[addSelectedMedia] is not enable select");
            return;
        }
        if (list.contains(toAddedMedia)) {
            RFWLog.d(getLogTag(), RFWLog.USR, "[addSelectedMedia] selectedMedia has container, path=" + toAddedMedia.path);
            return;
        }
        if (insertIndex >= 0 && insertIndex <= list.size()) {
            list.add(insertIndex, toAddedMedia);
        } else {
            list.add(toAddedMedia);
            insertIndex = list.size() - 1;
        }
        int i3 = !U1() ? -5 : -10000;
        RFWLog.d(getLogTag(), RFWLog.USR, "[addSelectedMedia] size=" + list.size() + ", validStatus=" + i3 + ", path=" + toAddedMedia.path);
        this._selectedMediaChangedActionMutableLiveData.setValue(new da.b(insertIndex, toAddedMedia, list, i3));
        this._selectMediaMutableLiveData.setValue(this.selectedMedia);
    }

    /* renamed from: R1, reason: from getter */
    public final int getMaxSelectMediaSize() {
        return this.maxSelectMediaSize;
    }

    public final LiveData<List<LocalMediaInfo>> S1() {
        return this.selectMediaLiveData;
    }

    public final LiveData<da.a> T1() {
        return this.selectedMediaChangedActionLiveData;
    }

    public final boolean U1() {
        return this._selectedMedia.size() < this.maxSelectMediaSize;
    }

    public final LiveData<Boolean> W1() {
        return this.isSelectMode;
    }

    public final void X1(int posInSelectedMediaList, LocalMediaInfo toRemovedMedia) {
        Object orNull;
        Intrinsics.checkNotNullParameter(toRemovedMedia, "toRemovedMedia");
        List<LocalMediaInfo> list = this._selectedMedia;
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, posInSelectedMediaList);
        if (((LocalMediaInfo) orNull) != null) {
            int i3 = U1() ? -10000 : 0;
            list.remove(posInSelectedMediaList);
            RFWLog.d(getLogTag(), RFWLog.USR, "[removeSelectedMedia] validStatus=" + i3 + ", size=" + list.size() + ", path=" + toRemovedMedia.path);
            this._selectedMediaChangedActionMutableLiveData.setValue(new f(posInSelectedMediaList, toRemovedMedia, list, i3));
            this._selectMediaMutableLiveData.setValue(this.selectedMedia);
        }
    }

    public final void Z1(boolean isSelectMode) {
        this._isSelectMode.postValue(Boolean.valueOf(isSelectMode));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneAlbumxSelectedMediaViewModel";
    }

    public final List<LocalMediaInfo> getSelectedMedia() {
        return this.selectedMedia;
    }

    public final void N1(List<? extends LocalMediaInfo> toAddedMediaList, boolean isAddFirst) {
        int i3;
        List<? extends LocalMediaInfo> list;
        List<? extends LocalMediaInfo> list2 = toAddedMediaList;
        if (list2 == null || list2.isEmpty()) {
            RFWLog.d(getLogTag(), RFWLog.USR, "[batchAddSelectedMedia] toAddedMediaList is empty");
            return;
        }
        if (!this._selectedMedia.isEmpty()) {
            Q1(this._selectedMedia, toAddedMediaList);
        }
        List<LocalMediaInfo> list3 = this._selectedMedia;
        if (list3.size() >= this.maxSelectMediaSize) {
            RFWLog.d(getLogTag(), RFWLog.USR, "[batchAddSelectedMedia] stock, is not enable select");
            return;
        }
        int size = list3.size() + toAddedMediaList.size();
        int i16 = this.maxSelectMediaSize;
        if (size > i16) {
            list = toAddedMediaList.subList(0, i16 - list3.size());
            i3 = -5;
        } else {
            i3 = -10000;
            list = toAddedMediaList;
        }
        RFWLog.d(getLogTag(), RFWLog.USR, "[batchAddSelectedMedia] stock.size=" + list3.size() + ", increase.size=" + toAddedMediaList.size() + ", maxSelectSize=" + this.maxSelectMediaSize + ", validStatus=" + i3 + ", isAddFirst=" + isAddFirst);
        if (isAddFirst) {
            list3.addAll(0, list);
        } else {
            list3.addAll(list);
        }
        this._selectedMediaChangedActionMutableLiveData.setValue(new c(list, list3, i3));
        this._selectMediaMutableLiveData.setValue(this.selectedMedia);
    }

    public final void P1(List<? extends LocalMediaInfo> toRemovedMediaList) {
        final Set set;
        boolean removeAll;
        if (toRemovedMediaList != null) {
            boolean U1 = U1();
            List<LocalMediaInfo> list = this._selectedMedia;
            set = CollectionsKt___CollectionsKt.toSet(toRemovedMediaList);
            removeAll = CollectionsKt__MutableCollectionsKt.removeAll((List) list, (Function1) new Function1<LocalMediaInfo, Boolean>() { // from class: com.qzone.reborn.albumx.qzone.base.media.viewmodel.MediaSelectedViewModel$batchRemoveSelectedMedia$1$1$hashRemove$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LocalMediaInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(set.contains(it));
                }
            });
            int i3 = (U1 || !removeAll) ? -10000 : 0;
            RFWLog.d(getLogTag(), RFWLog.USR, "[batchRemoveSelectedMedia] beforeRemoveIsSelectEnable=" + U1 + ", hashRemove=" + removeAll);
            this._selectedMediaChangedActionMutableLiveData.setValue(new d(toRemovedMediaList, list, i3));
            this._selectMediaMutableLiveData.setValue(this.selectedMedia);
        }
    }

    public static /* synthetic */ void M1(MediaSelectedViewModel mediaSelectedViewModel, LocalMediaInfo localMediaInfo, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        mediaSelectedViewModel.L1(localMediaInfo, i3);
    }

    public static /* synthetic */ void O1(MediaSelectedViewModel mediaSelectedViewModel, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        mediaSelectedViewModel.N1(list, z16);
    }
}
