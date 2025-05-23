package com.tencent.aelight.camera.ae.flashshow.ui;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J2\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00070\u0006H\u0002J\u0014\u0010\f\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006J\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\tH\u0014R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R)\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00070'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0011\u0010/\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowBottomPanelViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/PanelTag;", "tag", "", "show", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "livedata", "", "q2", "without", "p2", "c2", "onCleared", "Lcom/tencent/aelight/camera/ae/flashshow/ui/ds;", "i", "Landroidx/lifecycle/MutableLiveData;", "j2", "()Landroidx/lifecycle/MutableLiveData;", "materialPanelShowLiveData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d2", "beautifyPanelShowLiveData", BdhLogUtil.LogTag.Tag_Conn, SemanticAttributes.DbSystemValues.H2, "filterPanelShowLiveData", "D", "k2", "musicPanelShowLiveData", "E", "getMusicLyricPanelShowLiveData", "musicLyricPanelShowLiveData", UserInfo.SEX_FEMALE, "f2", "cutDownShowLiveData", "G", "m2", "sdkDownloadedLiveData", "Landroidx/lifecycle/MediatorLiveData;", "H", "Landroidx/lifecycle/MediatorLiveData;", "e2", "()Landroidx/lifecycle/MediatorLiveData;", "bottomPanelShowLiveData", "o2", "()Z", "isBottomPanelShow", "<init>", "()V", "I", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEFlashShowBottomPanelViewModel extends ViewModel {

    /* renamed from: I, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MutableLiveData<AEMaterialMetaData> J = new MutableLiveData<>(null);
    private static final MutableLiveData<AEMaterialMetaData> K = new MutableLiveData<>();
    private static final MutableLiveData<Boolean> L = new MutableLiveData<>();
    private static final MutableLiveData<Boolean> M = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> filterPanelShowLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> musicPanelShowLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> musicLyricPanelShowLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> cutDownShowLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> sdkDownloadedLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    private final MediatorLiveData<Pair<PanelTag, Boolean>> bottomPanelShowLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ds> materialPanelShowLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> beautifyPanelShowLiveData;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\tR(\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0005\u0012\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0005\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\u000f\u0010\u0007R&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u0012\u0004\b\u0013\u0010\t\u001a\u0004\b\u0012\u0010\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowBottomPanelViewModel$a;", "", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "selectMaterialLiveData", "Landroidx/lifecycle/MutableLiveData;", "d", "()Landroidx/lifecycle/MutableLiveData;", "getSelectMaterialLiveData$annotations", "()V", "favoriteListChangedLiveData", "a", "getFavoriteListChangedLiveData$annotations", "", "listAlreadyInited", "b", "getListAlreadyInited$annotations", "needDismissed", "c", "getNeedDismissed$annotations", "<init>", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPanelViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MutableLiveData<AEMaterialMetaData> a() {
            return AEFlashShowBottomPanelViewModel.K;
        }

        public final MutableLiveData<Boolean> b() {
            return AEFlashShowBottomPanelViewModel.L;
        }

        public final MutableLiveData<Boolean> c() {
            return AEFlashShowBottomPanelViewModel.M;
        }

        public final MutableLiveData<AEMaterialMetaData> d() {
            return AEFlashShowBottomPanelViewModel.J;
        }

        Companion() {
        }
    }

    public AEFlashShowBottomPanelViewModel() {
        MutableLiveData<ds> mutableLiveData = new MutableLiveData<>();
        this.materialPanelShowLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this.beautifyPanelShowLiveData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this.filterPanelShowLiveData = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this.musicPanelShowLiveData = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this.musicLyricPanelShowLiveData = mutableLiveData5;
        this.cutDownShowLiveData = new MutableLiveData<>();
        this.sdkDownloadedLiveData = new MutableLiveData<>();
        final MediatorLiveData<Pair<PanelTag, Boolean>> mediatorLiveData = new MediatorLiveData<>();
        final Function1<ds, Unit> function1 = new Function1<ds, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPanelViewModel$bottomPanelShowLiveData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ds dsVar) {
                invoke2(dsVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ds dsVar) {
                AEFlashShowBottomPanelViewModel.this.q2(PanelTag.MATERIAL_PANEL, dsVar.getShow(), mediatorLiveData);
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowBottomPanelViewModel.W1(Function1.this, obj);
            }
        });
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPanelViewModel$bottomPanelShowLiveData$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean show) {
                AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = AEFlashShowBottomPanelViewModel.this;
                PanelTag panelTag = PanelTag.BEAUTIFY_PANEL;
                Intrinsics.checkNotNullExpressionValue(show, "show");
                aEFlashShowBottomPanelViewModel.q2(panelTag, show.booleanValue(), mediatorLiveData);
            }
        };
        mediatorLiveData.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowBottomPanelViewModel.X1(Function1.this, obj);
            }
        });
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPanelViewModel$bottomPanelShowLiveData$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean show) {
                AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = AEFlashShowBottomPanelViewModel.this;
                PanelTag panelTag = PanelTag.FILTER_PANEL;
                Intrinsics.checkNotNullExpressionValue(show, "show");
                aEFlashShowBottomPanelViewModel.q2(panelTag, show.booleanValue(), mediatorLiveData);
            }
        };
        mediatorLiveData.addSource(mutableLiveData3, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowBottomPanelViewModel.Z1(Function1.this, obj);
            }
        });
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPanelViewModel$bottomPanelShowLiveData$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean show) {
                AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = AEFlashShowBottomPanelViewModel.this;
                PanelTag panelTag = PanelTag.MUSIC_PANEL;
                Intrinsics.checkNotNullExpressionValue(show, "show");
                aEFlashShowBottomPanelViewModel.q2(panelTag, show.booleanValue(), mediatorLiveData);
            }
        };
        mediatorLiveData.addSource(mutableLiveData4, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowBottomPanelViewModel.a2(Function1.this, obj);
            }
        });
        final Function1<Boolean, Unit> function15 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPanelViewModel$bottomPanelShowLiveData$1$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean show) {
                AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = AEFlashShowBottomPanelViewModel.this;
                PanelTag panelTag = PanelTag.LYRIC_PANEL;
                Intrinsics.checkNotNullExpressionValue(show, "show");
                aEFlashShowBottomPanelViewModel.q2(panelTag, show.booleanValue(), mediatorLiveData);
            }
        };
        mediatorLiveData.addSource(mutableLiveData5, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowBottomPanelViewModel.b2(Function1.this, obj);
            }
        });
        this.bottomPanelShowLiveData = mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final MutableLiveData<AEMaterialMetaData> g2() {
        return INSTANCE.a();
    }

    public static final MutableLiveData<Boolean> i2() {
        return INSTANCE.b();
    }

    public static final MutableLiveData<Boolean> l2() {
        return INSTANCE.c();
    }

    public static final MutableLiveData<AEMaterialMetaData> n2() {
        return INSTANCE.d();
    }

    public final void c2() {
        ds value = this.materialPanelShowLiveData.getValue();
        boolean z16 = false;
        if (value != null && value.getShow()) {
            z16 = true;
        }
        if (z16) {
            this.materialPanelShowLiveData.postValue(new ds(false, null, null, 6, null));
        }
        Boolean value2 = this.beautifyPanelShowLiveData.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value2, bool)) {
            this.beautifyPanelShowLiveData.postValue(Boolean.FALSE);
        }
        if (Intrinsics.areEqual(this.filterPanelShowLiveData.getValue(), bool)) {
            this.filterPanelShowLiveData.postValue(Boolean.FALSE);
        }
        if (Intrinsics.areEqual(this.musicPanelShowLiveData.getValue(), bool)) {
            this.musicPanelShowLiveData.postValue(Boolean.FALSE);
        }
        if (Intrinsics.areEqual(this.musicLyricPanelShowLiveData.getValue(), bool)) {
            this.musicLyricPanelShowLiveData.postValue(Boolean.FALSE);
        }
    }

    public final MutableLiveData<Boolean> d2() {
        return this.beautifyPanelShowLiveData;
    }

    public final MediatorLiveData<Pair<PanelTag, Boolean>> e2() {
        return this.bottomPanelShowLiveData;
    }

    public final MutableLiveData<Boolean> f2() {
        return this.cutDownShowLiveData;
    }

    public final MutableLiveData<Boolean> h2() {
        return this.filterPanelShowLiveData;
    }

    public final MutableLiveData<ds> j2() {
        return this.materialPanelShowLiveData;
    }

    public final MutableLiveData<Boolean> k2() {
        return this.musicPanelShowLiveData;
    }

    public final MutableLiveData<Boolean> m2() {
        return this.sdkDownloadedLiveData;
    }

    public final boolean o2() {
        ds value = this.materialPanelShowLiveData.getValue();
        boolean show = value != null ? value.getShow() : false;
        Boolean value2 = this.beautifyPanelShowLiveData.getValue();
        if (value2 == null) {
            value2 = Boolean.FALSE;
        }
        boolean booleanValue = show | value2.booleanValue();
        Boolean value3 = this.filterPanelShowLiveData.getValue();
        if (value3 == null) {
            value3 = Boolean.FALSE;
        }
        boolean booleanValue2 = booleanValue | value3.booleanValue();
        Boolean value4 = this.musicPanelShowLiveData.getValue();
        if (value4 == null) {
            value4 = Boolean.FALSE;
        }
        boolean booleanValue3 = booleanValue2 | value4.booleanValue();
        Boolean value5 = this.musicLyricPanelShowLiveData.getValue();
        if (value5 == null) {
            value5 = Boolean.FALSE;
        }
        return booleanValue3 | value5.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        J.setValue(null);
        K.setValue(null);
    }

    public final void p2(MutableLiveData<?> without) {
        if (!Intrinsics.areEqual(this.materialPanelShowLiveData, without)) {
            ds value = this.materialPanelShowLiveData.getValue();
            boolean z16 = false;
            if (value != null && value.getShow()) {
                z16 = true;
            }
            if (z16) {
                this.materialPanelShowLiveData.setValue(new ds(false, null, null, 6, null));
            }
        }
        if (!Intrinsics.areEqual(this.beautifyPanelShowLiveData, without) && Intrinsics.areEqual(this.beautifyPanelShowLiveData.getValue(), Boolean.TRUE)) {
            this.beautifyPanelShowLiveData.setValue(Boolean.FALSE);
        }
        if (!Intrinsics.areEqual(this.filterPanelShowLiveData, without) && Intrinsics.areEqual(this.filterPanelShowLiveData.getValue(), Boolean.TRUE)) {
            this.filterPanelShowLiveData.setValue(Boolean.FALSE);
        }
        if (!Intrinsics.areEqual(this.musicPanelShowLiveData, without) && Intrinsics.areEqual(this.musicPanelShowLiveData.getValue(), Boolean.TRUE)) {
            this.musicPanelShowLiveData.setValue(Boolean.FALSE);
        }
        if (Intrinsics.areEqual(this.musicLyricPanelShowLiveData, without) || !Intrinsics.areEqual(this.musicLyricPanelShowLiveData.getValue(), Boolean.TRUE)) {
            return;
        }
        this.musicLyricPanelShowLiveData.setValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q2(PanelTag tag, boolean show, MutableLiveData<Pair<PanelTag, Boolean>> livedata) {
        boolean z16 = show || o2();
        Pair<PanelTag, Boolean> value = livedata.getValue();
        if (value != null && z16 == value.getSecond().booleanValue()) {
            Pair<PanelTag, Boolean> value2 = livedata.getValue();
            if (tag == (value2 != null ? value2.getFirst() : null)) {
                return;
            }
        }
        livedata.setValue(TuplesKt.to(tag, Boolean.valueOf(z16)));
    }
}
