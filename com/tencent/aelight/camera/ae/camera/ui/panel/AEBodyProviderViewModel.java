package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b5\u00106J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0005J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0016\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR#\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u001fR\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030!8\u0006\u00a2\u0006\f\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%R#\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBodyProviderViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/b;", "beautyConfigList", "", "P1", "", "ability", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "b2", "Q1", "X1", "value", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Z1", "W1", "i", "I", "videoAbility", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "VIDEO_NAME_DIEJIA", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "totalEnableMesh", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "_bodyConfigSetLiveData", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "bodyConfigSetLiveData", UserInfo.SEX_FEMALE, "_bodySelectedLiveData", "G", "U1", "bodySelectedLiveData", "Landroidx/lifecycle/MediatorLiveData;", "H", "Landroidx/lifecycle/MediatorLiveData;", "T1", "()Landroidx/lifecycle/MediatorLiveData;", "bodyConfigSetOnCreateLiveData", "R1", "()Landroidx/lifecycle/MutableLiveData;", "bodyAdjustChangedLiveData", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEBodyProviderViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean totalEnableMesh;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<List<b>> _bodyConfigSetLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private final LiveData<List<b>> bodyConfigSetLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<b> _bodySelectedLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    private final LiveData<b> bodySelectedLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    private final MediatorLiveData<List<b>> bodyConfigSetOnCreateLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<b> bodyAdjustChangedLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int videoAbility;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String VIDEO_NAME_DIEJIA = "video_diejia_";

    public AEBodyProviderViewModel() {
        MutableLiveData<List<b>> mutableLiveData = new MutableLiveData<>();
        this._bodyConfigSetLiveData = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyConfigModel>>");
        this.bodyConfigSetLiveData = mutableLiveData;
        MutableLiveData<b> mutableLiveData2 = new MutableLiveData<>();
        this._bodySelectedLiveData = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyConfigModel>");
        this.bodySelectedLiveData = mutableLiveData2;
        final MediatorLiveData<List<b>> mediatorLiveData = new MediatorLiveData<>();
        final Function1<List<? extends b>, Unit> function1 = new Function1<List<? extends b>, Unit>() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEBodyProviderViewModel$bodyConfigSetOnCreateLiveData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends b> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends b> list) {
                mediatorLiveData.postValue(list);
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEBodyProviderViewModel.O1(Function1.this, obj);
            }
        });
        this.bodyConfigSetOnCreateLiveData = mediatorLiveData;
        this.bodyAdjustChangedLiveData = new MutableLiveData<>();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.h
            @Override // java.lang.Runnable
            public final void run() {
                AEBodyProviderViewModel.N1(AEBodyProviderViewModel.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(AEBodyProviderViewModel this$0) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<b> W1 = this$0.W1();
        this$0._bodyConfigSetLiveData.postValue(W1);
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) W1);
        b bVar = (b) firstOrNull;
        if (bVar != null) {
            this$0.a2(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void P1(List<? extends b> beautyConfigList) {
        Iterator<T> it = beautyConfigList.iterator();
        while (it.hasNext()) {
            AEProviderViewModel.INSTANCE.s((b) it.next(), 0);
        }
    }

    public final void Q1() {
        Object firstOrNull;
        List<b> value = this._bodyConfigSetLiveData.getValue();
        if (value == null) {
            return;
        }
        P1(value);
        this._bodyConfigSetLiveData.postValue(value);
        LiveData liveData = this._bodySelectedLiveData;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) value);
        liveData.postValue(firstOrNull);
    }

    public final MutableLiveData<b> R1() {
        return this.bodyAdjustChangedLiveData;
    }

    public final LiveData<List<b>> S1() {
        return this.bodyConfigSetLiveData;
    }

    public final MediatorLiveData<List<b>> T1() {
        return this.bodyConfigSetOnCreateLiveData;
    }

    public final LiveData<b> U1() {
        return this.bodySelectedLiveData;
    }

    public final List<b> W1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(BeautyItem.NONE, false, 2, null));
        arrayList.add(new b(BeautyItem.AUTOTHIN_BODY, false, 2, null));
        arrayList.add(new b(BeautyItem.SLIM_HEAD, false, 2, null));
        arrayList.add(new b(BeautyItem.SLIM_LEG, false, 2, null));
        arrayList.add(new b(BeautyItem.LONG_LEG, false, 2, null));
        arrayList.add(new b(BeautyItem.SLIM_WAIST, false, 2, null));
        return arrayList;
    }

    public final void X1() {
        List<b> value = this._bodyConfigSetLiveData.getValue();
        if (value == null) {
            return;
        }
        this._bodyConfigSetLiveData.postValue(value);
    }

    public final void Z1() {
        b value = this._bodySelectedLiveData.getValue();
        if (value == null) {
            return;
        }
        a2(value);
    }

    public final void a2(b value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._bodySelectedLiveData.postValue(value);
    }

    public final void b2(int ability, AEMaterialMetaData material) {
        boolean startsWith$default;
        this.videoAbility = ability;
        boolean z16 = (ability & 2) != 0;
        String str = material != null ? material.name : null;
        if (str == null) {
            str = "";
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, this.VIDEO_NAME_DIEJIA, false, 2, null);
        boolean z17 = startsWith$default ? false : z16;
        List<b> value = this._bodyConfigSetLiveData.getValue();
        if (value == null) {
            return;
        }
        Iterator<T> it = value.iterator();
        while (it.hasNext()) {
            ((b) it.next()).p(!z17);
        }
        this.totalEnableMesh = !z17;
        this._bodyConfigSetLiveData.postValue(value);
    }
}
