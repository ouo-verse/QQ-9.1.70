package com.tencent.mobileqq.wink.picker.core.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.picker.TabType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0014\u0010\u0012\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001bR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001fR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001bR\"\u0010/\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00102\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u00010\u000b0\u000b0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010\u001fR\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0006\u00a2\u0006\f\n\u0004\b3\u0010\u0019\u001a\u0004\b4\u0010\u001bR\u0014\u00107\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00103\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaSelectionPanelStateViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "", "Z1", "", "selectedMediaSize", "X1", "W1", "", "Q1", "R1", "getLogTag", "Landroidx/lifecycle/LiveData;", "Le93/a;", "selectedMediaChangedActionLiveData", "T1", "Landroidx/lifecycle/MediatorLiveData;", "", "i", "Landroidx/lifecycle/MediatorLiveData;", "_panelState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "panelState", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_actionBtnEnable", "D", "N1", "actionBtnEnable", "E", "_appendText", UserInfo.SEX_FEMALE, "O1", "appendText", "G", "Ljava/lang/String;", "getInitHintContent", "()Ljava/lang/String;", "U1", "(Ljava/lang/String;)V", "initHintContent", "kotlin.jvm.PlatformType", "H", "_hintContent", "I", "P1", "hintContent", "J", "startCountNum", "<init>", "()V", "K", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMediaSelectionPanelStateViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _actionBtnEnable;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> actionBtnEnable;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _appendText;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> appendText;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String initHintContent;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _hintContent;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> hintContent;

    /* renamed from: J, reason: from kotlin metadata */
    private final int startCountNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediatorLiveData<Boolean> _panelState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> panelState;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324813a;

        static {
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.ONLY_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.ONLY_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f324813a = iArr;
        }
    }

    public WinkMediaSelectionPanelStateViewModel() {
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        this._panelState = mediatorLiveData;
        this.panelState = mediatorLiveData;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._actionBtnEnable = mutableLiveData;
        this.actionBtnEnable = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._appendText = mutableLiveData2;
        this.appendText = mutableLiveData2;
        this.initHintContent = Q1();
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>(this.initHintContent);
        this._hintContent = mutableLiveData3;
        this.hintContent = mutableLiveData3;
        this.startCountNum = com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getStartCountNum();
    }

    private final String Q1() {
        com.tencent.mobileqq.wink.picker.core.c cVar = com.tencent.mobileqq.wink.picker.core.c.f324480a;
        int i3 = b.f324813a[cVar.b().getLocalMediaTabType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return "\u53ef\u540c\u65f6\u9009\u53d6\u56fe\u7247\u4e0e\u89c6\u9891";
            }
            return "\u53ef\u9009\u53d6\u89c6\u9891";
        }
        if (Intrinsics.areEqual(cVar.b().getFrom(), AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER_FROM_AI_AVATAR_CP)) {
            return "\u5df2\u9009\u62e91\u5f20\u56fe\u7247";
        }
        return "\u53ef\u9009\u53d6\u56fe\u7247";
    }

    private final String R1(int selectedMediaSize) {
        if (Intrinsics.areEqual(com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getFrom(), AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER_FROM_AI_AVATAR_CP)) {
            return "\u5df2\u9009\u62e9" + selectedMediaSize + "\u5f20\u56fe\u7247";
        }
        return "\u62d6\u52a8\u7d20\u6750\u53ef\u66f4\u6362\u987a\u5e8f";
    }

    private final void W1(int selectedMediaSize) {
        if (selectedMediaSize > 0) {
            this._actionBtnEnable.postValue(Boolean.TRUE);
            this._appendText.postValue("(" + (selectedMediaSize + this.startCountNum) + ")");
            return;
        }
        this._actionBtnEnable.postValue(Boolean.FALSE);
        this._appendText.postValue("");
    }

    private final void X1(int selectedMediaSize) {
        if (selectedMediaSize >= 2) {
            this._hintContent.postValue(R1(selectedMediaSize));
        } else {
            this._hintContent.postValue(this.initHintContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(List<? extends LocalMediaInfo> selectedMedia) {
        this._panelState.setValue(Boolean.valueOf(!selectedMedia.isEmpty()));
        int size = selectedMedia.size();
        X1(size);
        W1(size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeSelectedMediaChange$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @NotNull
    public final LiveData<Boolean> N1() {
        return this.actionBtnEnable;
    }

    @NotNull
    public final LiveData<String> O1() {
        return this.appendText;
    }

    @NotNull
    public final LiveData<String> P1() {
        return this.hintContent;
    }

    @NotNull
    public final LiveData<Boolean> S1() {
        return this.panelState;
    }

    public final void T1(@NotNull LiveData<e93.a> selectedMediaChangedActionLiveData) {
        Intrinsics.checkNotNullParameter(selectedMediaChangedActionLiveData, "selectedMediaChangedActionLiveData");
        this._panelState.removeSource(selectedMediaChangedActionLiveData);
        MediatorLiveData<Boolean> mediatorLiveData = this._panelState;
        final Function1<e93.a, Unit> function1 = new Function1<e93.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaSelectionPanelStateViewModel$observeSelectedMediaChange$1
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
                if (aVar instanceof e93.h) {
                    WinkMediaSelectionPanelStateViewModel.this.Z1(((e93.h) aVar).a());
                    return;
                }
                if (aVar instanceof e93.b) {
                    WinkMediaSelectionPanelStateViewModel.this.Z1(((e93.b) aVar).c());
                } else if (aVar instanceof e93.f) {
                    WinkMediaSelectionPanelStateViewModel.this.Z1(((e93.f) aVar).c());
                } else if (aVar instanceof e93.d) {
                    WinkMediaSelectionPanelStateViewModel.this.Z1(((e93.d) aVar).a());
                }
            }
        };
        mediatorLiveData.addSource(selectedMediaChangedActionLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMediaSelectionPanelStateViewModel.observeSelectedMediaChange$lambda$0(Function1.this, obj);
            }
        });
    }

    public final void U1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.initHintContent = str;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkSelectionPanelStateViewModel";
    }
}
