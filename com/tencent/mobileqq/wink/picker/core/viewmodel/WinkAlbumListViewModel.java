package com.tencent.mobileqq.wink.picker.core.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.picker.core.repository.e;
import e93.QZoneAlbumInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0014\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0005J\b\u0010\u0012\u001a\u00020\u0011H\u0016R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\n8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001aR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001eR\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001aR\u0018\u0010*\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkAlbumListViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "X1", "", "Lcom/tencent/mobileqq/data/QQAlbumInfo;", "albumInfoList", "W1", "", "Z1", "Landroidx/lifecycle/LiveData;", "Le93/j;", "qzoneAlbumLiveData", "Q1", "b2", "albumInfo", "c2", "", "getLogTag", "Landroidx/lifecycle/MediatorLiveData;", "i", "Landroidx/lifecycle/MediatorLiveData;", "_albumList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "albumList", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_albumListVisible", "D", "T1", "albumListVisible", "E", "_curSelectedAlbumId", UserInfo.SEX_FEMALE, "U1", "curSelectedAlbumId", "G", "Le93/j;", "qzoneAlbumInfo", "<init>", "()V", "H", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAlbumListViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _albumListVisible;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> albumListVisible;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<QQAlbumInfo> _curSelectedAlbumId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<QQAlbumInfo> curSelectedAlbumId;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QZoneAlbumInfo qzoneAlbumInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediatorLiveData<List<QQAlbumInfo>> _albumList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<List<QQAlbumInfo>> albumList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/picker/core/viewmodel/WinkAlbumListViewModel$b", "Lcom/tencent/mobileqq/wink/picker/core/repository/e$a;", "", "Lcom/tencent/mobileqq/data/QQAlbumInfo;", "albums", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements e.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.repository.e.a
        public void a(@NotNull List<? extends QQAlbumInfo> albums) {
            Intrinsics.checkNotNullParameter(albums, "albums");
            WinkAlbumListViewModel.this._albumList.postValue(WinkAlbumListViewModel.this.W1(albums));
        }
    }

    public WinkAlbumListViewModel() {
        MediatorLiveData<List<QQAlbumInfo>> mediatorLiveData = new MediatorLiveData<>();
        this._albumList = mediatorLiveData;
        this.albumList = mediatorLiveData;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._albumListVisible = mutableLiveData;
        this.albumListVisible = mutableLiveData;
        MutableLiveData<QQAlbumInfo> mutableLiveData2 = new MutableLiveData<>();
        this._curSelectedAlbumId = mutableLiveData2;
        this.curSelectedAlbumId = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<QQAlbumInfo> W1(List<? extends QQAlbumInfo> albumInfoList) {
        Object obj;
        List<QQAlbumInfo> mutableListOf;
        Iterator it = albumInfoList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((QQAlbumInfo) obj).f203112id, "qzone_album")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            w53.b.f("WinkAlbumListViewModel", "already contains qzone album");
            return albumInfoList;
        }
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady()) {
            w53.b.f("WinkAlbumListViewModel", "camera res not ready");
            return albumInfoList;
        }
        QZoneAlbumInfo qZoneAlbumInfo = this.qzoneAlbumInfo;
        if (qZoneAlbumInfo != null && qZoneAlbumInfo.getAlbumMediaTotalNum() > 0 && (!qZoneAlbumInfo.a().isEmpty())) {
            QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
            qQAlbumInfo.f203112id = "qzone_album";
            qQAlbumInfo.name = "\u7a7a\u95f4\u76f8\u518c";
            qQAlbumInfo.mMediaFileCount = qZoneAlbumInfo.getAlbumMediaTotalNum();
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(qQAlbumInfo);
            mutableListOf.addAll(albumInfoList);
            return mutableListOf;
        }
        return albumInfoList;
    }

    private final boolean X1() {
        boolean z16;
        Object firstOrNull;
        List<QQAlbumInfo> value = this._albumList.getValue();
        if (value != null && (!value.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        String str = null;
        this.qzoneAlbumInfo = null;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) value);
        QQAlbumInfo qQAlbumInfo = (QQAlbumInfo) firstOrNull;
        if (qQAlbumInfo != null) {
            str = qQAlbumInfo.f203112id;
        }
        if (Intrinsics.areEqual(str, "qzone_album")) {
            this._albumList.postValue(value.subList(1, value.size()));
        } else {
            this._albumList.postValue(value);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(WinkAlbumListViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new com.tencent.mobileqq.wink.picker.core.repository.e().i(Integer.MAX_VALUE, new b());
    }

    public final void Q1(@NotNull LiveData<QZoneAlbumInfo> qzoneAlbumLiveData) {
        Intrinsics.checkNotNullParameter(qzoneAlbumLiveData, "qzoneAlbumLiveData");
        this._albumList.removeSource(qzoneAlbumLiveData);
        MediatorLiveData<List<QQAlbumInfo>> mediatorLiveData = this._albumList;
        final Function1<QZoneAlbumInfo, Unit> function1 = new Function1<QZoneAlbumInfo, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.WinkAlbumListViewModel$addSourceToAlbumListLiveData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZoneAlbumInfo qZoneAlbumInfo) {
                invoke2(qZoneAlbumInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QZoneAlbumInfo qZoneAlbumInfo) {
                WinkAlbumListViewModel.this.qzoneAlbumInfo = qZoneAlbumInfo;
                List list = (List) WinkAlbumListViewModel.this._albumList.getValue();
                if (list != null) {
                    WinkAlbumListViewModel winkAlbumListViewModel = WinkAlbumListViewModel.this;
                    winkAlbumListViewModel._albumList.setValue(winkAlbumListViewModel.W1(list));
                }
            }
        };
        mediatorLiveData.addSource(qzoneAlbumLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAlbumListViewModel.R1(Function1.this, obj);
            }
        });
    }

    @NotNull
    public final LiveData<List<QQAlbumInfo>> S1() {
        return this.albumList;
    }

    @NotNull
    public final LiveData<Boolean> T1() {
        return this.albumListVisible;
    }

    @NotNull
    public final LiveData<QQAlbumInfo> U1() {
        return this.curSelectedAlbumId;
    }

    public final void Z1() {
        if (X1()) {
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.d
            @Override // java.lang.Runnable
            public final void run() {
                WinkAlbumListViewModel.a2(WinkAlbumListViewModel.this);
            }
        });
    }

    public final void b2() {
        if (this._albumListVisible.getValue() != null) {
            this._albumListVisible.setValue(Boolean.valueOf(!r0.booleanValue()));
        } else {
            this._albumListVisible.setValue(Boolean.TRUE);
        }
    }

    public final void c2(@NotNull QQAlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this._curSelectedAlbumId.setValue(albumInfo);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkAlbumListViewModel";
    }
}
