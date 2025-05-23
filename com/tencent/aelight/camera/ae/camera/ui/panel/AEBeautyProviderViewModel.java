package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\bM\u0010NJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0002J\u0016\u0010\f\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0002J\u001e\u0010\u000e\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001cJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\bR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b&\u0010'R \u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R#\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010+R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0006\u00a2\u0006\f\n\u0004\b5\u0010/\u001a\u0004\b6\u00101R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u0002080)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010+R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u0002080-8\u0006\u00a2\u0006\f\n\u0004\b#\u0010/\u001a\u0004\b;\u00101R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040)8\u0006\u00a2\u0006\f\n\u0004\b=\u0010+\u001a\u0004\b>\u0010?R#\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0A8\u0006\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00020)8\u0006\u00a2\u0006\f\n\u0004\bG\u0010+\u001a\u0004\bH\u0010?R\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001c0)8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010+\u001a\u0004\bK\u0010?\u00a8\u0006O"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/b;", DownloadInfo.spKey_Config, "", "enableMakeup", "enableMesh", "e2", "", "beautyConfigList", "", SemanticAttributes.DbSystemValues.H2, "P1", "enable", "R1", "d2", "", "ability", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "l2", "i2", "Q1", "S1", "f2", "value", "j2", "g2", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/f;", "k2", "c2", "i", "Z", "needBeautyImprovement", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "videoAbility", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "VIDEO_NAME_DIEJIA", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "_beautyConfigSetLiveData", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "U1", "()Landroidx/lifecycle/LiveData;", "beautyConfigSetLiveData", UserInfo.SEX_FEMALE, "_beautySelectedLiveData", "G", ICustomDataEditor.STRING_ARRAY_PARAM_2, "beautySelectedLiveData", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/ap;", "H", "_beautySecondarySelectedLiveData", "Z1", "beautySecondarySelectedLiveData", "J", "b2", "()Landroidx/lifecycle/MutableLiveData;", "secondaryBeautyListOpenLiveData", "Landroidx/lifecycle/MediatorLiveData;", "K", "Landroidx/lifecycle/MediatorLiveData;", "W1", "()Landroidx/lifecycle/MediatorLiveData;", "beautyConfigSetOnCreateLiveData", "L", "T1", "beautyAdjustChangedLiveData", "M", "X1", "beautySecondaryAdjustChangedLiveData", "<init>", "(Z)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEBeautyProviderViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final String VIDEO_NAME_DIEJIA;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<List<b>> _beautyConfigSetLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private final LiveData<List<b>> beautyConfigSetLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<b> _beautySelectedLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    private final LiveData<b> beautySelectedLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<BeautySecondarySelectedWrapper> _beautySecondarySelectedLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    private final LiveData<BeautySecondarySelectedWrapper> beautySecondarySelectedLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> secondaryBeautyListOpenLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    private final MediatorLiveData<List<b>> beautyConfigSetOnCreateLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    private final MutableLiveData<b> beautyAdjustChangedLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    private final MutableLiveData<f> beautySecondaryAdjustChangedLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean needBeautyImprovement;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int videoAbility;

    public AEBeautyProviderViewModel() {
        this(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(AEBeautyProviderViewModel this$0) {
        List<b> c26;
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.needBeautyImprovement) {
            c26 = this$0.d2();
        } else {
            c26 = this$0.c2();
        }
        this$0._beautyConfigSetLiveData.postValue(c26);
        Iterator<T> it = c26.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            b bVar = (b) obj;
            if ((bk.a(bVar) || bVar.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String() == BeautyItem.RESET) ? false : true) {
                break;
            }
        }
        b bVar2 = (b) obj;
        if (bVar2 != null) {
            this$0.j2(bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void P1(List<? extends b> beautyConfigList) {
        for (b bVar : beautyConfigList) {
            if (bVar.i().isEmpty()) {
                AEProviderViewModel.Companion companion = AEProviderViewModel.INSTANCE;
                companion.s(bVar, 0);
                companion.q(bVar, 0);
            } else {
                AEProviderViewModel.Companion companion2 = AEProviderViewModel.INSTANCE;
                companion2.t(bVar, bVar.getSecondarySelectDefault());
                companion2.r(bVar);
                for (f fVar : bVar.i()) {
                    AEProviderViewModel.Companion companion3 = AEProviderViewModel.INSTANCE;
                    companion3.s(fVar, 0);
                    companion3.q(fVar, 0);
                }
            }
        }
    }

    private final void R1(List<? extends b> beautyConfigList, boolean enable) {
        for (b bVar : beautyConfigList) {
            if (bVar.i().isEmpty()) {
                bVar.p(enable);
            } else {
                for (f fVar : bVar.i()) {
                    bVar.p(enable);
                }
            }
        }
    }

    private final List<b> d2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(BeautyItem.NONE, false, 2, null));
        arrayList.add(new b(BeautyItem.RESET, false, 2, null));
        arrayList.add(new b(BeautyItem.SKIN, false, 2, null));
        BeautyItem beautyItem = BeautyItem.BASICFACE;
        beautyItem.setDefaultValue(50);
        arrayList.add(new b(beautyItem, true));
        arrayList.add(new b(BeautyItem.EYE, false, 2, null));
        if (AEOfflineConfig.getPhonePerfLevel() >= 3) {
            arrayList.add(new b(BeautyItem.EYE_MAKEUP, false, 2, null));
        }
        arrayList.add(new b(BeautyItem.LUT_CLEAR_ALPHA, false, 2, null));
        arrayList.add(new b(BeautyItem.LUT_FOUNDATION_ALPHA, false, 2, null));
        BeautyItem beautyItem2 = BeautyItem.FACE_SMALLER;
        beautyItem2.setDefaultValue(20);
        arrayList.add(new b(beautyItem2, true));
        arrayList.add(new b(BeautyItem.FACE_THIN, false, 2, null));
        BeautyItem beautyItem3 = BeautyItem.CHEEKBONE_THIN;
        beautyItem3.setDefaultValue(30);
        arrayList.add(new b(beautyItem3, true));
        BeautyItem beautyItem4 = BeautyItem.NOSE;
        beautyItem4.setDefaultValue(40);
        arrayList.add(new b(beautyItem4, true));
        arrayList.add(new b(BeautyItem.MOUTH_SHAPE, false, 2, null));
        arrayList.add(new b(BeautyItem.FOREHEAD, false, 2, null));
        if (AEOfflineConfig.getPhonePerfLevel() >= 3) {
            arrayList.add(new b(BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA, false, 2, null));
            arrayList.add(new b(BeautyItem.FACE_FEATURE_REDCHEEK, false, 2, null));
            BeautyItem beautyItem5 = BeautyItem.FACE_FEATURE_SOFT;
            beautyItem5.setDefaultValue(50);
            arrayList.add(new b(beautyItem5, true));
            arrayList.add(new b(BeautyItem.TOOTH_WHITEN, false, 2, null));
            BeautyItem beautyItem6 = BeautyItem.REMOVE_POUNCH;
            beautyItem6.setDefaultValue(100);
            arrayList.add(new b(beautyItem6, true));
            BeautyItem beautyItem7 = BeautyItem.REMOVE_WRINKLES2;
            beautyItem7.setDefaultValue(100);
            arrayList.add(new b(beautyItem7, true));
        }
        return arrayList;
    }

    private final void h2(List<? extends b> beautyConfigList) {
        for (b bVar : beautyConfigList) {
            if (bVar.i().isEmpty()) {
                AEProviderViewModel.Companion companion = AEProviderViewModel.INSTANCE;
                companion.s(bVar, bVar.getCooperation.qzone.remote.logic.RemoteHandleConst.PARAM_DEFAULT_VALUE java.lang.String());
                companion.q(bVar, bVar.getCooperation.qzone.remote.logic.RemoteHandleConst.PARAM_DEFAULT_VALUE java.lang.String());
            } else {
                AEProviderViewModel.Companion companion2 = AEProviderViewModel.INSTANCE;
                companion2.t(bVar, bVar.getSecondarySelectDefault());
                companion2.r(bVar);
                for (f fVar : bVar.i()) {
                    AEProviderViewModel.Companion companion3 = AEProviderViewModel.INSTANCE;
                    companion3.s(fVar, fVar.getCooperation.qzone.remote.logic.RemoteHandleConst.PARAM_DEFAULT_VALUE java.lang.String());
                    companion3.q(fVar, fVar.getCooperation.qzone.remote.logic.RemoteHandleConst.PARAM_DEFAULT_VALUE java.lang.String());
                }
            }
        }
    }

    public final void Q1() {
        Object firstOrNull;
        List<b> value = this._beautyConfigSetLiveData.getValue();
        if (value == null) {
            return;
        }
        P1(value);
        this._beautyConfigSetLiveData.postValue(value);
        LiveData liveData = this._beautySelectedLiveData;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) value);
        liveData.postValue(firstOrNull);
    }

    public final void S1(boolean enable) {
        Object firstOrNull;
        List<b> value = this._beautyConfigSetLiveData.getValue();
        if (value == null) {
            return;
        }
        R1(value, enable);
        this._beautyConfigSetLiveData.postValue(value);
        LiveData liveData = this._beautySelectedLiveData;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) value);
        liveData.postValue(firstOrNull);
    }

    public final MutableLiveData<b> T1() {
        return this.beautyAdjustChangedLiveData;
    }

    public final LiveData<List<b>> U1() {
        return this.beautyConfigSetLiveData;
    }

    public final MediatorLiveData<List<b>> W1() {
        return this.beautyConfigSetOnCreateLiveData;
    }

    public final MutableLiveData<f> X1() {
        return this.beautySecondaryAdjustChangedLiveData;
    }

    public final LiveData<BeautySecondarySelectedWrapper> Z1() {
        return this.beautySecondarySelectedLiveData;
    }

    public final LiveData<b> a2() {
        return this.beautySelectedLiveData;
    }

    public final MutableLiveData<Boolean> b2() {
        return this.secondaryBeautyListOpenLiveData;
    }

    public final List<b> c2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(BeautyItem.NONE, false, 2, null));
        arrayList.add(new b(BeautyItem.RESET, false, 2, null));
        arrayList.add(new b(BeautyItem.SKIN, false, 2, null));
        arrayList.add(new b(BeautyItem.BASICFACE, false, 2, null));
        arrayList.add(new b(BeautyItem.EYE, false, 2, null));
        arrayList.add(new b(BeautyItem.LUT_CLEAR_ALPHA, false, 2, null));
        arrayList.add(new b(BeautyItem.LUT_FOUNDATION_ALPHA, false, 2, null));
        arrayList.add(new b(BeautyItem.FACE_SMALLER, false, 2, null));
        arrayList.add(new b(BeautyItem.FACE_THIN, false, 2, null));
        arrayList.add(new b(BeautyItem.CHEEKBONE_THIN, false, 2, null));
        arrayList.add(new b(BeautyItem.NOSE, false, 2, null));
        arrayList.add(new b(BeautyItem.MOUTH_SHAPE, false, 2, null));
        arrayList.add(new b(BeautyItem.FOREHEAD, false, 2, null));
        if (AEOfflineConfig.getPhonePerfLevel() >= 3) {
            arrayList.add(new b(BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA, false, 2, null));
            arrayList.add(new b(BeautyItem.FACE_FEATURE_REDCHEEK, false, 2, null));
            arrayList.add(new b(BeautyItem.FACE_FEATURE_SOFT, false, 2, null));
            arrayList.add(new b(BeautyItem.TOOTH_WHITEN, false, 2, null));
            arrayList.add(new b(BeautyItem.REMOVE_POUNCH, false, 2, null));
            arrayList.add(new b(BeautyItem.REMOVE_WRINKLES2, false, 2, null));
        }
        return arrayList;
    }

    public final void f2() {
        List<b> value = this._beautyConfigSetLiveData.getValue();
        if (value == null) {
            return;
        }
        this._beautyConfigSetLiveData.postValue(value);
    }

    public final void g2() {
        b value = this._beautySelectedLiveData.getValue();
        if (value == null) {
            return;
        }
        j2(value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i2() {
        List<b> value = this._beautyConfigSetLiveData.getValue();
        if (value == null) {
            return;
        }
        h2(value);
        this._beautyConfigSetLiveData.postValue(value);
        if (bk.a(this._beautySelectedLiveData.getValue())) {
            List<b> value2 = this._beautyConfigSetLiveData.getValue();
            b bVar = null;
            if (value2 != null) {
                Iterator<T> it = value2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    b bVar2 = (b) next;
                    if ((bk.a(bVar2) || bVar2.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String() == BeautyItem.RESET) ? false : true) {
                        bVar = next;
                        break;
                    }
                }
                bVar = bVar;
            }
            if (bVar != null) {
                this._beautySelectedLiveData.postValue(bVar);
            }
        }
    }

    public final void j2(b value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._beautySelectedLiveData.postValue(value);
    }

    public final void k2(f value) {
        Intrinsics.checkNotNullParameter(value, "value");
        b value2 = this.beautySelectedLiveData.getValue();
        if (value2 == null) {
            return;
        }
        Iterator<f> it = value2.i().iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (Intrinsics.areEqual(value.getType(), it.next().getType())) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            this._beautySecondarySelectedLiveData.postValue(new BeautySecondarySelectedWrapper(value2, value, i3));
            AEProviderViewModel.Companion companion = AEProviderViewModel.INSTANCE;
            companion.t(value2, i3);
            companion.r(value2);
        }
    }

    public final void l2(int ability, AEMaterialMetaData material) {
        boolean startsWith$default;
        this.videoAbility = ability;
        boolean z16 = (ability & 1) != 0;
        boolean z17 = (ability & 2) != 0;
        String str = material != null ? material.name : null;
        if (str == null) {
            str = "";
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, this.VIDEO_NAME_DIEJIA, false, 2, null);
        boolean z18 = startsWith$default ? false : z17;
        List<b> value = this._beautyConfigSetLiveData.getValue();
        if (value == null) {
            return;
        }
        for (b bVar : value) {
            bVar.p(e2(bVar, z16, z18));
            Iterator<T> it = bVar.i().iterator();
            while (it.hasNext()) {
                ((f) it.next()).l(bVar.getEnable());
            }
        }
        this._beautyConfigSetLiveData.postValue(value);
    }

    public AEBeautyProviderViewModel(boolean z16) {
        this.needBeautyImprovement = z16;
        this.VIDEO_NAME_DIEJIA = "video_diejia_";
        MutableLiveData<List<b>> mutableLiveData = new MutableLiveData<>();
        this._beautyConfigSetLiveData = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyConfigModel>>");
        this.beautyConfigSetLiveData = mutableLiveData;
        MutableLiveData<b> mutableLiveData2 = new MutableLiveData<>();
        this._beautySelectedLiveData = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyConfigModel>");
        this.beautySelectedLiveData = mutableLiveData2;
        MutableLiveData<BeautySecondarySelectedWrapper> mutableLiveData3 = new MutableLiveData<>();
        this._beautySecondarySelectedLiveData = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.aelight.camera.ae.camera.ui.panel.BeautySecondarySelectedWrapper>");
        this.beautySecondarySelectedLiveData = mutableLiveData3;
        this.secondaryBeautyListOpenLiveData = new MutableLiveData<>(Boolean.FALSE);
        final MediatorLiveData<List<b>> mediatorLiveData = new MediatorLiveData<>();
        final Function1<List<? extends b>, Unit> function1 = new Function1<List<? extends b>, Unit>() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderViewModel$beautyConfigSetOnCreateLiveData$1$1
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
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEBeautyProviderViewModel.O1(Function1.this, obj);
            }
        });
        this.beautyConfigSetOnCreateLiveData = mediatorLiveData;
        this.beautyAdjustChangedLiveData = new MutableLiveData<>();
        this.beautySecondaryAdjustChangedLiveData = new MutableLiveData<>();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.d
            @Override // java.lang.Runnable
            public final void run() {
                AEBeautyProviderViewModel.N1(AEBeautyProviderViewModel.this);
            }
        });
    }

    private final boolean e2(b config, boolean enableMakeup, boolean enableMesh) {
        if (enableMakeup && (config.getType() == BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA.getType() || config.getType() == BeautyItem.FACE_FEATURE_REDCHEEK.getType() || config.getType() == BeautyItem.FACE_FEATURE_SOFT.getType() || config.getType() == BeautyItem.EYE_MAKEUP.getType())) {
            return false;
        }
        if (enableMesh) {
            return (config.getType() == BeautyItem.EYE.getType() || config.getType() == BeautyItem.CHEEKBONE_THIN.getType() || config.getType() == BeautyItem.NOSE.getType() || config.getType() == BeautyItem.MOUTH_SHAPE.getType() || config.getType() == BeautyItem.FOREHEAD.getType() || config.getType() == BeautyItem.BASICFACE.getType() || config.getType() == BeautyItem.FACE_SMALLER.getType() || config.getType() == BeautyItem.FACE_THIN.getType()) ? false : true;
        }
        return true;
    }

    public /* synthetic */ AEBeautyProviderViewModel(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
