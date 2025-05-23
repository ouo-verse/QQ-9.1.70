package com.qzone.reborn.albumx.qzone.base.media.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import da.c;
import da.d;
import da.e;
import da.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u000b\b\u0016\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u001e\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R&\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0(0'0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R)\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0(0'0\u00138\u0006\u00a2\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b-\u0010$\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/base/media/viewmodel/MediaViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lda/a;", "action", "", "W1", "X1", "b2", "Z1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "validStatus", "c2", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "updateIndexInSelectedMedia", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/LiveData;", "selectedMediaChangedActionLiveData", "T1", "S1", "", "getLogTag", "", "i", "Z", "isSelectedMediaChangedActionLiveDataAdd", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_mediaChangedActionMutableLiveData", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "getMediaChangedActionLiveData", "()Landroidx/lifecycle/LiveData;", "mediaChangedActionLiveData", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "D", "Landroidx/lifecycle/MediatorLiveData;", "_mediaMediatorLiveData", "E", "getMediaMediatorLiveData", "mediaMediatorLiveData", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class MediaViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<da.a> mediaChangedActionLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    private final MediatorLiveData<UIStateData<List<LocalMediaInfo>>> _mediaMediatorLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private final LiveData<UIStateData<List<LocalMediaInfo>>> mediaMediatorLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isSelectedMediaChangedActionLiveDataAdd;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<da.a> _mediaChangedActionMutableLiveData;

    public MediaViewModel() {
        MutableLiveData<da.a> mutableLiveData = new MutableLiveData<>();
        this._mediaChangedActionMutableLiveData = mutableLiveData;
        this.mediaChangedActionLiveData = mutableLiveData;
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediatorLiveData = new MediatorLiveData<>();
        this._mediaMediatorLiveData = mediatorLiveData;
        this.mediaMediatorLiveData = mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1(da.a action) {
        da.b bVar = action instanceof da.b ? (da.b) action : null;
        if (bVar != null) {
            bVar.getAddedMedia().selectStatus = 1;
            ea.a.i(bVar.getAddedMedia(), bVar.getIndexInSelectedMedia());
            if (bVar.getValidStatus() != -10000) {
                c2(((da.b) action).getValidStatus());
            }
            this._mediaChangedActionMutableLiveData.setValue(new da.b(bVar.getIndexInSelectedMedia(), bVar.getAddedMedia(), bVar.c(), bVar.getValidStatus()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(da.a action) {
        c cVar = action instanceof c ? (c) action : null;
        if (cVar != null) {
            updateIndexInSelectedMedia(cVar.b());
            Iterator<T> it = cVar.a().iterator();
            while (it.hasNext()) {
                ((LocalMediaInfo) it.next()).selectStatus = 1;
            }
            if (cVar.getValidStatus() != -10000) {
                c2(((c) action).getValidStatus());
            }
            this._mediaChangedActionMutableLiveData.setValue(new c(cVar.a(), cVar.b(), cVar.getValidStatus()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(da.a action) {
        d dVar = action instanceof d ? (d) action : null;
        if (dVar != null) {
            updateIndexInSelectedMedia(dVar.b());
            Iterator<T> it = dVar.a().iterator();
            while (it.hasNext()) {
                ((LocalMediaInfo) it.next()).selectStatus = 2;
            }
            if (dVar.getValidStatus() != -10000) {
                c2(((d) action).getValidStatus());
            }
            this._mediaChangedActionMutableLiveData.setValue(new d(dVar.a(), dVar.b(), dVar.getValidStatus()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2() {
        for (LocalMediaInfo localMediaInfo : S1()) {
            ea.a.i(localMediaInfo, 0);
            localMediaInfo.selectStatus = 0;
            ea.a.j(localMediaInfo, 0);
        }
        this._mediaChangedActionMutableLiveData.setValue(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(da.a action) {
        f fVar = action instanceof f ? (f) action : null;
        if (fVar != null) {
            updateIndexInSelectedMedia(fVar.c());
            fVar.getRemovedMedia().selectStatus = 2;
            if (fVar.getValidStatus() != -10000) {
                c2(((f) action).getValidStatus());
            }
            this._mediaChangedActionMutableLiveData.setValue(new f(fVar.getIndexInSelectedMedia(), fVar.getRemovedMedia(), fVar.c(), fVar.getValidStatus()));
        }
    }

    private final void c2(int validStatus) {
        Iterator<T> it = S1().iterator();
        while (it.hasNext()) {
            ea.a.j((LocalMediaInfo) it.next(), validStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeSelectedMediaChange$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void updateIndexInSelectedMedia(List<? extends LocalMediaInfo> selectedMedia) {
        int i3 = 0;
        for (Object obj : selectedMedia) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ea.a.i((LocalMediaInfo) obj, i3);
            i3 = i16;
        }
    }

    public List<LocalMediaInfo> S1() {
        List<LocalMediaInfo> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    public final void T1(LifecycleOwner owner, LiveData<da.a> selectedMediaChangedActionLiveData) {
        Intrinsics.checkNotNullParameter(selectedMediaChangedActionLiveData, "selectedMediaChangedActionLiveData");
        if (this.isSelectedMediaChangedActionLiveDataAdd) {
            return;
        }
        this.isSelectedMediaChangedActionLiveDataAdd = true;
        this._mediaMediatorLiveData.removeSource(selectedMediaChangedActionLiveData);
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediatorLiveData = this._mediaMediatorLiveData;
        final Function1<da.a, Unit> function1 = new Function1<da.a, Unit>() { // from class: com.qzone.reborn.albumx.qzone.base.media.viewmodel.MediaViewModel$observeSelectedMediaChange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(da.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(da.a action) {
                if (action instanceof da.b) {
                    MediaViewModel mediaViewModel = MediaViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(action, "action");
                    mediaViewModel.W1(action);
                    return;
                }
                if (action instanceof c) {
                    MediaViewModel mediaViewModel2 = MediaViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(action, "action");
                    mediaViewModel2.X1(action);
                } else if (action instanceof f) {
                    MediaViewModel mediaViewModel3 = MediaViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(action, "action");
                    mediaViewModel3.b2(action);
                } else if (action instanceof d) {
                    MediaViewModel mediaViewModel4 = MediaViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(action, "action");
                    mediaViewModel4.Z1(action);
                } else if (action instanceof e) {
                    MediaViewModel.this.a2();
                }
            }
        };
        mediatorLiveData.addSource(selectedMediaChangedActionLiveData, new Observer() { // from class: com.qzone.reborn.albumx.qzone.base.media.viewmodel.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediaViewModel.observeSelectedMediaChange$lambda$0(Function1.this, obj);
            }
        });
        if (owner != null) {
            LiveData<UIStateData<List<LocalMediaInfo>>> liveData = this.mediaMediatorLiveData;
            final Function1<UIStateData<List<LocalMediaInfo>>, Unit> function12 = new Function1<UIStateData<List<LocalMediaInfo>>, Unit>() { // from class: com.qzone.reborn.albumx.qzone.base.media.viewmodel.MediaViewModel$observeSelectedMediaChange$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<LocalMediaInfo>> uIStateData) {
                    invoke2(uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<List<LocalMediaInfo>> uIStateData) {
                    QLog.d(MediaViewModel.this.getTAG(), 1, "[observeSelectedMediaChange] active mediaMediatorLiveData");
                }
            };
            liveData.observe(owner, new Observer() { // from class: com.qzone.reborn.albumx.qzone.base.media.viewmodel.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MediaViewModel.U1(Function1.this, obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MediaViewModel";
    }

    public final LiveData<da.a> getMediaChangedActionLiveData() {
        return this.mediaChangedActionLiveData;
    }
}
