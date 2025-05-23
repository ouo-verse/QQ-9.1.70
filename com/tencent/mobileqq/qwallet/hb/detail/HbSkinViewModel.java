package com.tencent.mobileqq.qwallet.hb.detail;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001FB\u000f\u0012\u0006\u0010B\u001a\u00020A\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0003H\u0007J\b\u0010\u0012\u001a\u00020\u0003H\u0007R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0017\u0010#\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R0\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0$2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0$8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R,\u00102\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000201000$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002030$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010&R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\t068F\u00a2\u0006\u0006\u001a\u0004\b7\u00108R)\u0010;\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020100068F\u00a2\u0006\u0006\u001a\u0004\b:\u00108R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u000203068F\u00a2\u0006\u0006\u001a\u0004\b<\u00108R\u0011\u0010@\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b>\u0010?\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "", "R1", "f2", "", "totalScrollRange", "verticalOffset", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinState;", "d2", "", "c2", "newState", "Q1", "e2", "P1", "onCreate", "onResume", "", "i", "Ljava/lang/String;", "listId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "X1", "()I", "skinId", BdhLogUtil.LogTag.Tag_Conn, "outerSkinId", "D", "skinFrom", "E", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Ljava/lang/String;", "uniqueSkinId", "Landroidx/lifecycle/MutableLiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "_stateLiveData", "<set-?>", "G", "b2", "()Landroidx/lifecycle/MutableLiveData;", "isStoryCoverReady", "H", "Z", "isOnResume", "Lkotlin/Triple;", "", "_scrollInfoLiveData", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "J", "_hbSkinData", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "stateLiveData", "W1", "scrollInfoLiveData", "U1", "hbSkinData", "T1", "()Z", "hasStory", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "K", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinViewModel extends ViewModel implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String outerSkinId;

    /* renamed from: D, reason: from kotlin metadata */
    private final int skinFrom;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String uniqueSkinId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<HbSkinState> _stateLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> isStoryCoverReady;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isOnResume;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Triple<Float, Float, Float>> _scrollInfoLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<HbSkinData> _hbSkinData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String listId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int skinId;

    public HbSkinViewModel(@NotNull SavedStateHandle stateHandle) {
        int intValue;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        String str = (String) stateHandle.get("listid");
        str = str == null ? "" : str;
        this.listId = str;
        Integer num = (Integer) stateHandle.get("skin_id");
        if (num == null) {
            intValue = -1;
        } else {
            intValue = num.intValue();
        }
        this.skinId = intValue;
        String str2 = (String) stateHandle.get("outer_skin_id");
        String str3 = str2 != null ? str2 : "";
        this.outerSkinId = str3;
        Integer num2 = (Integer) stateHandle.get("skin_from");
        int intValue2 = num2 != null ? num2.intValue() : -1;
        this.skinFrom = intValue2;
        this.uniqueSkinId = intValue + ";" + str3 + ";" + intValue2;
        QLog.d("HbSkinViewModel", 2, "init: skinId " + intValue + ", outerSkinId " + str3 + ", skinFrom " + intValue2 + ", listId " + str);
        this._stateLiveData = new MutableLiveData<>();
        this.isStoryCoverReady = new MutableLiveData<>();
        this._scrollInfoLiveData = new MutableLiveData<>();
        this._hbSkinData = new MutableLiveData<>();
        LiveData<HbSkinData> U1 = U1();
        final Function1<HbSkinData, Unit> function1 = new Function1<HbSkinData, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.detail.HbSkinViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinData hbSkinData) {
                invoke2(hbSkinData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HbSkinData hbSkinData) {
                HbSkinViewModel.this.f2();
            }
        };
        U1.observeForever(new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HbSkinViewModel.N1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void R1() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.detail.am
            @Override // java.lang.Runnable
            public final void run() {
                HbSkinViewModel.S1(HbSkinViewModel.this);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(HbSkinViewModel this$0) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            HbSkinData skinDataFromLocal = ((IHbSkinApi) QRoute.apiIPCSync(IHbSkinApi.class)).getSkinDataFromLocal(this$0.skinId, this$0.outerSkinId, this$0.skinFrom);
            if (skinDataFromLocal != null) {
                QLog.d("HbSkinViewModel", 2, "fetchSkinData: hbSkinData " + skinDataFromLocal);
                this$0._hbSkinData.postValue(skinDataFromLocal);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                QLog.w("HbSkinViewModel", 1, "fetchSkinData: hb skin data is null");
            }
        } catch (IllegalStateException e16) {
            QLog.w("HbSkinViewModel", 1, "fetchSkinData error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2() {
        Integer num;
        boolean z16;
        HbSkinData value = U1().getValue();
        boolean z17 = this.isOnResume;
        if (value != null) {
            num = Integer.valueOf(value.getSkinType());
        } else {
            num = null;
        }
        QLog.d("HbSkinViewModel", 2, "updateStoryCoverReady: isOnResume=" + z17 + " skinType=" + num);
        MutableLiveData<Boolean> mutableLiveData = this.isStoryCoverReady;
        if (this.isOnResume && value != null && ((IHbSkinApi) QRoute.api(IHbSkinApi.class)).isSupportSkinStory(value.getSkinType())) {
            z16 = true;
        } else {
            z16 = false;
        }
        mutableLiveData.postValue(Boolean.valueOf(z16));
    }

    public final int P1(int totalScrollRange) {
        float f16;
        if (T1()) {
            f16 = 0.535f;
        } else {
            f16 = 0.495f;
        }
        return (int) (totalScrollRange * (f16 - 1.0f));
    }

    public final void Q1(@NotNull HbSkinState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        MutableLiveData<HbSkinState> mutableLiveData = this._stateLiveData;
        if (!c2()) {
            newState = HbSkinState.COLLAPSED;
        } else if (!T1() && newState == HbSkinState.EXPANDED) {
            newState = HbSkinState.INTERMEDIATE;
        }
        mutableLiveData.setValue(newState);
    }

    public final boolean T1() {
        ArrayList<HbSkinData.StoryRes> t16;
        HbSkinData value = this._hbSkinData.getValue();
        if (value != null && (t16 = value.t()) != null) {
            return !t16.isEmpty();
        }
        return false;
    }

    @NotNull
    public final LiveData<HbSkinData> U1() {
        return this._hbSkinData;
    }

    @NotNull
    public final LiveData<Triple<Float, Float, Float>> W1() {
        return this._scrollInfoLiveData;
    }

    /* renamed from: X1, reason: from getter */
    public final int getSkinId() {
        return this.skinId;
    }

    @NotNull
    public final LiveData<HbSkinState> Z1() {
        return this._stateLiveData;
    }

    @NotNull
    /* renamed from: a2, reason: from getter */
    public final String getUniqueSkinId() {
        return this.uniqueSkinId;
    }

    @NotNull
    public final MutableLiveData<Boolean> b2() {
        return this.isStoryCoverReady;
    }

    public final boolean c2() {
        return ((IHbSkinApi) QRoute.api(IHbSkinApi.class)).isValidRedPocketSkin(this.skinId, this.outerSkinId, this.skinFrom);
    }

    @NotNull
    public final HbSkinState d2(int totalScrollRange, int verticalOffset) {
        HbSkinState hbSkinState;
        int P1 = P1(totalScrollRange);
        if (verticalOffset < ((-totalScrollRange) + P1) / 2) {
            hbSkinState = HbSkinState.COLLAPSED;
        } else if (verticalOffset > P1 / 2) {
            hbSkinState = HbSkinState.EXPANDED;
        } else {
            hbSkinState = HbSkinState.INTERMEDIATE;
        }
        Q1(hbSkinState);
        return hbSkinState;
    }

    public final void e2(int totalScrollRange, int verticalOffset) {
        this._scrollInfoLiveData.setValue(new Triple<>(Float.valueOf(verticalOffset + totalScrollRange), Float.valueOf(P1(totalScrollRange) + totalScrollRange), Float.valueOf(totalScrollRange)));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        QLog.d("HbSkinViewModel", 2, "onCreate: ");
        R1();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        this.isOnResume = true;
    }
}
