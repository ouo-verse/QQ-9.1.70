package com.tencent.qqnt.qbasealbum.select.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.qqnt.qbasealbum.select.model.b;
import com.tencent.qqnt.qbasealbum.select.model.f;
import com.tencent.qqnt.qbasealbum.select.model.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0002/0B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\t8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001cR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\u0015R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u001cR\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020&0\t8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedPanelStateViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "selectedMediaSize", "", "U1", "T1", "", "getLogTag", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", "selectedMediaChangedActionLiveData", "S1", "Landroidx/lifecycle/MediatorLiveData;", "", "i", "Landroidx/lifecycle/MediatorLiveData;", "_panelVisibleMutableLiveData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "getPanelVisibleLiveData", "()Landroidx/lifecycle/LiveData;", "panelVisibleLiveData", BdhLogUtil.LogTag.Tag_Conn, "Z", "hasMediaDragTipsEverShown", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "_mediaDragTipsVisibleMutableLiveData", "E", "P1", "mediaDragTipsVisibleLiveData", UserInfo.SEX_FEMALE, "_videoTemplateBtnVisibleMutableLiveData", "G", "R1", "videoTemplateBtnVisibleLiveData", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedPanelStateViewModel$b;", "H", "_nextBtnAttrsMutableLiveData", "I", "Q1", "nextBtnAttrsLiveData", "<init>", "()V", "J", "a", "b", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SelectedPanelStateViewModel extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasMediaDragTipsEverShown;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _mediaDragTipsVisibleMutableLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> mediaDragTipsVisibleLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _videoTemplateBtnVisibleMutableLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> videoTemplateBtnVisibleLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<b> _nextBtnAttrsMutableLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<b> nextBtnAttrsLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediatorLiveData<Boolean> _panelVisibleMutableLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> panelVisibleLiveData;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedPanelStateViewModel$a;", "", "", "HAS_MEDIA_DRAG_TIPS_HAS_EVER_SHOWN", "Ljava/lang/String;", "NEXT_STEP_TEXT", "TAG", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedPanelStateViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\t\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedPanelStateViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "enable", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "text", "I", "()I", "backgroundResId", "<init>", "(ZLjava/lang/String;I)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean enable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String text;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int backgroundResId;

        public b(boolean z16, @NotNull String text, int i3) {
            Intrinsics.checkNotNullParameter(text, "text");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), text, Integer.valueOf(i3));
                return;
            }
            this.enable = z16;
            this.text = text;
            this.backgroundResId = i3;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.backgroundResId;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.enable;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.text;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.enable == bVar.enable && Intrinsics.areEqual(this.text, bVar.text) && this.backgroundResId == bVar.backgroundResId) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            boolean z16 = this.enable;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.text.hashCode()) * 31) + this.backgroundResId;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "NextBtnAttrs(enable=" + this.enable + ", text=" + this.text + ", backgroundResId=" + this.backgroundResId + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45050);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SelectedPanelStateViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        this._panelVisibleMutableLiveData = mediatorLiveData;
        this.panelVisibleLiveData = mediatorLiveData;
        this.hasMediaDragTipsEverShown = true;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._mediaDragTipsVisibleMutableLiveData = mutableLiveData;
        this.mediaDragTipsVisibleLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(Boolean.FALSE);
        this._videoTemplateBtnVisibleMutableLiveData = mutableLiveData2;
        this.videoTemplateBtnVisibleLiveData = mutableLiveData2;
        MutableLiveData<b> mutableLiveData3 = new MutableLiveData<>();
        this._nextBtnAttrsMutableLiveData = mutableLiveData3;
        this.nextBtnAttrsLiveData = mutableLiveData3;
        g gVar = g.f361234b;
        if (gVar.isCameraResReady()) {
            mutableLiveData2.postValue(Boolean.TRUE);
        }
        this.hasMediaDragTipsEverShown = gVar.getBoolean("ae_camera_is_show_tip", false, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(int selectedMediaSize) {
        if (!this.hasMediaDragTipsEverShown && selectedMediaSize >= 2) {
            this.hasMediaDragTipsEverShown = true;
            this._mediaDragTipsVisibleMutableLiveData.setValue(Boolean.TRUE);
            g.f361234b.putBoolean("ae_camera_is_show_tip", true, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(int selectedMediaSize) {
        if (selectedMediaSize > 0) {
            this._nextBtnAttrsMutableLiveData.postValue(new b(true, "\u53d1\u9001(" + selectedMediaSize + ")", R.drawable.f161270k92));
            return;
        }
        this._nextBtnAttrsMutableLiveData.postValue(new b(false, "\u53d1\u9001", R.drawable.f161267k91));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeSelectedMediaChange$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @NotNull
    public final LiveData<Boolean> P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mediaDragTipsVisibleLiveData;
    }

    @NotNull
    public final LiveData<b> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.nextBtnAttrsLiveData;
    }

    @NotNull
    public final LiveData<Boolean> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.videoTemplateBtnVisibleLiveData;
    }

    public final void S1(@NotNull LiveData<com.tencent.qqnt.qbasealbum.select.model.a> selectedMediaChangedActionLiveData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) selectedMediaChangedActionLiveData);
            return;
        }
        Intrinsics.checkNotNullParameter(selectedMediaChangedActionLiveData, "selectedMediaChangedActionLiveData");
        this._panelVisibleMutableLiveData.removeSource(selectedMediaChangedActionLiveData);
        MediatorLiveData<Boolean> mediatorLiveData = this._panelVisibleMutableLiveData;
        final Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit> function1 = new Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit>() { // from class: com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedPanelStateViewModel$observeSelectedMediaChange$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectedPanelStateViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.select.model.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.qbasealbum.select.model.a aVar) {
                MediatorLiveData mediatorLiveData2;
                MediatorLiveData mediatorLiveData3;
                MediatorLiveData mediatorLiveData4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                if (aVar instanceof f) {
                    mediatorLiveData4 = SelectedPanelStateViewModel.this._panelVisibleMutableLiveData;
                    mediatorLiveData4.setValue(Boolean.valueOf(!r4.a().isEmpty()));
                    SelectedPanelStateViewModel.this.U1(((f) aVar).a().size());
                    return;
                }
                if (aVar instanceof b) {
                    mediatorLiveData3 = SelectedPanelStateViewModel.this._panelVisibleMutableLiveData;
                    mediatorLiveData3.setValue(Boolean.TRUE);
                    b bVar = (b) aVar;
                    SelectedPanelStateViewModel.this.U1(bVar.c().size());
                    SelectedPanelStateViewModel.this.T1(bVar.c().size());
                    return;
                }
                if (aVar instanceof h) {
                    mediatorLiveData2 = SelectedPanelStateViewModel.this._panelVisibleMutableLiveData;
                    mediatorLiveData2.setValue(Boolean.valueOf(!r4.c().isEmpty()));
                    SelectedPanelStateViewModel.this.U1(((h) aVar).c().size());
                }
            }
        };
        mediatorLiveData.addSource(selectedMediaChangedActionLiveData, new Observer() { // from class: com.tencent.qqnt.qbasealbum.select.viewmodel.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SelectedPanelStateViewModel.observeSelectedMediaChange$lambda$0(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "SelectedPanelStateViewModel";
    }

    @NotNull
    public final LiveData<Boolean> getPanelVisibleLiveData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.panelVisibleLiveData;
    }
}
