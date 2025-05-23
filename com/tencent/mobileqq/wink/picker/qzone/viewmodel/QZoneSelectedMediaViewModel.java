package com.tencent.mobileqq.wink.picker.qzone.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.wink.picker.qzone.b;
import com.tencent.mobileqq.wink.picker.qzone.c;
import com.tencent.mobileqq.wink.picker.qzone.d;
import com.tencent.mobileqq.wink.picker.qzone.e;
import com.tencent.mobileqq.wink.picker.qzone.f;
import com.tencent.mobileqq.wink.picker.qzone.q;
import com.tencent.mobileqq.wink.picker.qzone.r;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import e93.h;
import e93.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\t8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010!R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\t8\u0006\u00a2\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020&0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020&0\t8\u0006\u00a2\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b.\u0010%R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010,R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006\u00a2\u0006\f\n\u0004\b0\u0010#\u001a\u0004\b1\u0010%R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020&0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010,R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020&0\t8\u0006\u00a2\u0006\f\n\u0004\b3\u0010#\u001a\u0004\b4\u0010%R\u001b\u00107\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/viewmodel/QZoneSelectedMediaViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "changeBtnStatus", "dismissButtons", "", "getLogTag", "", "alreadySelectedCount", "Landroidx/lifecycle/LiveData;", "Le93/a;", "mediaChangeLiveData", "observeSelectedMediaChanged", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "initBean", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "", "isSelectedMediaChangedObserved", "Z", "_alreadySelectedCount", "I", "<set-?>", "curSelectedSize", "getCurSelectedSize", "()I", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "Ljava/util/List;", "getSelectedMedia", "()Ljava/util/List;", "Landroidx/lifecycle/MediatorLiveData;", "_panelVisibleMutableLiveData", "Landroidx/lifecycle/MediatorLiveData;", "panelVisibleLiveData", "Landroidx/lifecycle/LiveData;", "getPanelVisibleLiveData", "()Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/wink/picker/qzone/f;", "_btnVisibilityLiveData", "btnVisibilityLiveData", "getBtnVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "_nextStepBtnStatusLiveData", "Landroidx/lifecycle/MutableLiveData;", "nextStepBtnStatusLiveData", "getNextStepBtnStatusLiveData", "_nextBtnTextLiveData", "nextBtnTextLiveData", "getNextBtnTextLiveData", "_videoTempBtnStatusLiveData", "videoTempBtnStatusLiveData", "getVideoTempBtnStatusLiveData", "isCameraResReady$delegate", "Lkotlin/Lazy;", "isCameraResReady", "()Z", "<init>", "(Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;)V", "Companion", "QZoneSelectedViewModelFactory", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZoneSelectedMediaViewModel extends BaseViewModel {

    @NotNull
    private static final String NEXT_STEP_TEXT = "\u4e0b\u4e00\u6b65";

    @NotNull
    private static final String TAG = "WinkSelectedMediaViewModel";
    private int _alreadySelectedCount;

    @NotNull
    private final MediatorLiveData<f> _btnVisibilityLiveData;

    @NotNull
    private final MutableLiveData<String> _nextBtnTextLiveData;

    @NotNull
    private final MutableLiveData<f> _nextStepBtnStatusLiveData;

    @NotNull
    private final MediatorLiveData<Boolean> _panelVisibleMutableLiveData;

    @NotNull
    private final MutableLiveData<f> _videoTempBtnStatusLiveData;

    @NotNull
    private final LiveData<f> btnVisibilityLiveData;
    private int curSelectedSize;

    @NotNull
    private final QZoneInitBean initBean;

    /* renamed from: isCameraResReady$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isCameraResReady;
    private boolean isSelectedMediaChangedObserved;

    @NotNull
    private final LiveData<String> nextBtnTextLiveData;

    @NotNull
    private final LiveData<f> nextStepBtnStatusLiveData;

    @NotNull
    private final LiveData<Boolean> panelVisibleLiveData;

    @NotNull
    private List<? extends LocalMediaInfo> selectedMedia;

    @NotNull
    private final LiveData<f> videoTempBtnStatusLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J'\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/viewmodel/QZoneSelectedMediaViewModel$QZoneSelectedViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initBean", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "(Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;)V", OperateCustomButton.OPERATE_CREATE, "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class QZoneSelectedViewModelFactory implements ViewModelProvider.Factory {

        @NotNull
        private final QZoneInitBean initBean;

        public QZoneSelectedViewModelFactory(@NotNull QZoneInitBean initBean) {
            Intrinsics.checkNotNullParameter(initBean, "initBean");
            this.initBean = initBean;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return modelClass.getConstructor(QZoneInitBean.class).newInstance(this.initBean);
        }
    }

    public QZoneSelectedMediaViewModel(@NotNull QZoneInitBean initBean) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
        this.selectedMedia = new ArrayList();
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        this._panelVisibleMutableLiveData = mediatorLiveData;
        this.panelVisibleLiveData = mediatorLiveData;
        MediatorLiveData<f> mediatorLiveData2 = new MediatorLiveData<>();
        this._btnVisibilityLiveData = mediatorLiveData2;
        this.btnVisibilityLiveData = mediatorLiveData2;
        MutableLiveData<f> mutableLiveData = new MutableLiveData<>();
        this._nextStepBtnStatusLiveData = mutableLiveData;
        this.nextStepBtnStatusLiveData = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._nextBtnTextLiveData = mutableLiveData2;
        this.nextBtnTextLiveData = mutableLiveData2;
        MutableLiveData<f> mutableLiveData3 = new MutableLiveData<>();
        this._videoTempBtnStatusLiveData = mutableLiveData3;
        this.videoTempBtnStatusLiveData = mutableLiveData3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.picker.qzone.viewmodel.QZoneSelectedMediaViewModel$isCameraResReady$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady());
            }
        });
        this.isCameraResReady = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
    
        if (r4 == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void changeBtnStatus() {
        ArrayList arrayList;
        boolean z16;
        boolean z17;
        if (this.curSelectedSize < this.initBean.getNextStepMinMediaNum()) {
            this._nextStepBtnStatusLiveData.setValue(new c());
        } else {
            this._nextStepBtnStatusLiveData.setValue(new e());
        }
        if (this.curSelectedSize < this.initBean.getVideoTemplateMinMediaNum()) {
            this._videoTempBtnStatusLiveData.postValue(new b());
        } else if (this.initBean.getShowVideoTemplateButton()) {
            List<? extends LocalMediaInfo> list = this.selectedMedia;
            if (list != null) {
                arrayList = new ArrayList();
                for (Object obj : list) {
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
                    if (!i.F(localMediaInfo)) {
                        z16 = false;
                        if (i.I(localMediaInfo)) {
                            String str = localMediaInfo.missionID;
                            if (str != null && str.length() != 0) {
                                z17 = false;
                            } else {
                                z17 = true;
                            }
                        }
                        if (!z16) {
                            arrayList.add(obj);
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                if (!(!arrayList.isEmpty()) && isCameraResReady()) {
                    this._videoTempBtnStatusLiveData.postValue(new d());
                } else {
                    this._videoTempBtnStatusLiveData.postValue(new b());
                }
            }
        }
        int i3 = this.curSelectedSize;
        if (i3 > 0) {
            this._nextBtnTextLiveData.postValue("\u4e0b\u4e00\u6b65(" + (i3 + this._alreadySelectedCount) + ")");
            return;
        }
        this._nextBtnTextLiveData.postValue(NEXT_STEP_TEXT);
    }

    private final void dismissButtons() {
        if (!this.initBean.getShowNextStepButton() && this.initBean.getShowVideoTemplateButton()) {
            this._btnVisibilityLiveData.setValue(new q());
        }
        if ((!this.initBean.getShowVideoTemplateButton() && this.initBean.getShowNextStepButton()) || !isCameraResReady()) {
            this._btnVisibilityLiveData.setValue(new r());
        }
    }

    private final boolean isCameraResReady() {
        return ((Boolean) this.isCameraResReady.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeSelectedMediaChanged$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @NotNull
    public final LiveData<f> getBtnVisibilityLiveData() {
        return this.btnVisibilityLiveData;
    }

    public final int getCurSelectedSize() {
        return this.curSelectedSize;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return TAG;
    }

    @NotNull
    public final LiveData<String> getNextBtnTextLiveData() {
        return this.nextBtnTextLiveData;
    }

    @NotNull
    public final LiveData<f> getNextStepBtnStatusLiveData() {
        return this.nextStepBtnStatusLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getPanelVisibleLiveData() {
        return this.panelVisibleLiveData;
    }

    @NotNull
    public final List<LocalMediaInfo> getSelectedMedia() {
        return this.selectedMedia;
    }

    @NotNull
    public final LiveData<f> getVideoTempBtnStatusLiveData() {
        return this.videoTempBtnStatusLiveData;
    }

    public final void observeSelectedMediaChanged(int alreadySelectedCount, @NotNull LiveData<e93.a> mediaChangeLiveData) {
        Intrinsics.checkNotNullParameter(mediaChangeLiveData, "mediaChangeLiveData");
        this._alreadySelectedCount = alreadySelectedCount;
        dismissButtons();
        changeBtnStatus();
        if (this.isSelectedMediaChangedObserved) {
            return;
        }
        this.isSelectedMediaChangedObserved = true;
        MediatorLiveData<f> mediatorLiveData = this._btnVisibilityLiveData;
        final Function1<e93.a, Unit> function1 = new Function1<e93.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qzone.viewmodel.QZoneSelectedMediaViewModel$observeSelectedMediaChanged$1
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
            public final void invoke2(e93.a aVar) {
                MediatorLiveData mediatorLiveData2;
                if (aVar instanceof e93.d) {
                    e93.d dVar = (e93.d) aVar;
                    QZoneSelectedMediaViewModel.this.curSelectedSize = dVar.a().size();
                    QZoneSelectedMediaViewModel.this.selectedMedia = dVar.a();
                } else if (aVar instanceof e93.b) {
                    QZoneSelectedMediaViewModel qZoneSelectedMediaViewModel = QZoneSelectedMediaViewModel.this;
                    qZoneSelectedMediaViewModel.curSelectedSize = qZoneSelectedMediaViewModel.getCurSelectedSize() + 1;
                    QZoneSelectedMediaViewModel.this.selectedMedia = ((e93.b) aVar).c();
                } else if (aVar instanceof e93.f) {
                    QZoneSelectedMediaViewModel.this.curSelectedSize = r0.getCurSelectedSize() - 1;
                    QZoneSelectedMediaViewModel.this.selectedMedia = ((e93.f) aVar).c();
                } else if (aVar instanceof h) {
                    QZoneSelectedMediaViewModel.this.selectedMedia = ((h) aVar).a();
                }
                QZoneSelectedMediaViewModel.this.changeBtnStatus();
                mediatorLiveData2 = QZoneSelectedMediaViewModel.this._panelVisibleMutableLiveData;
                mediatorLiveData2.setValue(Boolean.valueOf(QZoneSelectedMediaViewModel.this.getCurSelectedSize() > 0));
            }
        };
        mediatorLiveData.addSource(mediaChangeLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.viewmodel.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneSelectedMediaViewModel.observeSelectedMediaChanged$lambda$0(Function1.this, obj);
            }
        });
    }
}
