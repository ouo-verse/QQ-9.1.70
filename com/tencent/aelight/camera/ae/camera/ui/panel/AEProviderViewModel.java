package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 @2\u00020\u0001:\u0001AB'\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u00a2\u0006\u0004\b>\u0010?J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010$R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0&8\u0006\u00a2\u0006\f\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*R\u001a\u00105\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002020&8\u0006\u00a2\u0006\f\n\u0004\b6\u0010(\u001a\u0004\b7\u0010*R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000b018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00104R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0&8\u0006\u00a2\u0006\f\n\u0004\b;\u0010(\u001a\u0004\b<\u0010*\u00a8\u0006B"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEProviderViewModel;", "Landroidx/lifecycle/ViewModel;", "", "F2", "", "ability", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "K2", "index", "I2", "", "on", "J2", "", "model", "progress", "E2", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "i", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "beautyViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBodyProviderViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBodyProviderViewModel;", "bodyViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/aa;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aelight/camera/ae/camera/ui/panel/aa;", "cosmeticsViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/ac;", "D", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/ac;", "filterViewModel", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "_selectedPanelTabIndex", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "C2", "()Landroidx/lifecycle/LiveData;", "selectedPanelTabIndex", "G", "_aiBeautyToggle", "H", "u2", "aiBeautyToggle", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/ca;", "I", "Landroidx/lifecycle/MediatorLiveData;", "_seekBarOpDataLiveData", "J", NowProxyConstants.AccountInfoKey.A2, "seekBarOpDataLiveData", "K", "_seekBarShowLiveData", "L", "B2", "seekBarShowLiveData", "<init>", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBodyProviderViewModel;Lcom/tencent/aelight/camera/ae/camera/ui/panel/aa;Lcom/tencent/aelight/camera/ae/camera/ui/panel/ac;)V", "M", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEProviderViewModel extends ViewModel {

    /* renamed from: M, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean N = true;
    private static boolean P = true;
    private static boolean Q = true;
    private static final Map<String, Integer> R;
    private static final Map<String, Integer> S;
    private static final Map<BeautyRealConfig.TYPE, Integer> T;
    private static final Map<BeautyRealConfig.TYPE, Integer> U;
    private static final Map<String, Integer> V;
    private static final Map<String, Integer> W;
    private static final Map<String, Integer> X;

    /* renamed from: C, reason: from kotlin metadata */
    private final aa cosmeticsViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private final ac filterViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _selectedPanelTabIndex;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Integer> selectedPanelTabIndex;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _aiBeautyToggle;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<Boolean> aiBeautyToggle;

    /* renamed from: I, reason: from kotlin metadata */
    private final MediatorLiveData<SeekBarOpDataWrapper> _seekBarOpDataLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    private final LiveData<SeekBarOpDataWrapper> seekBarOpDataLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    private final MediatorLiveData<Boolean> _seekBarShowLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    private final LiveData<Boolean> seekBarShowLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final AEBeautyProviderViewModel beautyViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final AEBodyProviderViewModel bodyViewModel;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u000bH\u0007J\u000e\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u000bH\u0007J\u0014\u0010\u0011\u001a\u00020\u0010*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\f\u0010\u0012\u001a\u00020\b*\u00020\u000bH\u0007J\f\u0010\u0013\u001a\u00020\u0010*\u00020\u000bH\u0007J\u0016\u0010\u0015\u001a\u00020\u0004*\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0004H\u0007J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0007J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\bH\u0007J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0004H\u0007J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0007J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0007J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0007R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\"\u0010+\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010#\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u0014\u0010.\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00101\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00102\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b2\u0010/R\u0014\u00103\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b3\u00104R \u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u0004058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00108R \u0010:\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00108R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00108R \u0010<\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00108R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u00108R \u0010>\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u0004058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u00108\u00a8\u0006A"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEProviderViewModel$a;", "", "model", "", "", "o", "(Ljava/lang/Object;)[Ljava/lang/Integer;", "", "", "map", "c", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/b;", DomainData.DOMAIN_NAME, "Lcom/tencent/aelight/camera/ae/camera/ui/panel/f;", "p", "index", "", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", RemoteHandleConst.PARAM_DEFAULT_VALUE, "l", "a", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "b", "id", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "j", "i", "d", "", "ENABLE_SAVE_BEAUTY_VALUE", "Z", "e", "()Z", "setENABLE_SAVE_BEAUTY_VALUE", "(Z)V", "ENABLE_SAVE_FILTER_VALUE", "g", "setENABLE_SAVE_FILTER_VALUE", "ENABLE_SAVE_COSMETIC_VALUE", "f", "setENABLE_SAVE_COSMETIC_VALUE", "TAB_INDEX_BEAUTY", "I", "TAB_INDEX_BODY", "TAB_INDEX_COSMETICS", "TAB_INDEX_FILTER", "TAG", "Ljava/lang/String;", "", "Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;", "beautyConfigAdjustCache", "Ljava/util/Map;", "beautySecondaryConfigAdjustCache", "cosmeticsAdjustCache", "defaultFilterValueMap", "defaultStyleDefaultMap", "filterAdjustCache", "secondarySelectedCache", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int c(Object model, Map<String, Integer> map) {
            Integer num;
            Integer num2;
            if (model instanceof QIMFilterCategoryItem) {
                QIMFilterCategoryItem qIMFilterCategoryItem = (QIMFilterCategoryItem) model;
                if (!map.containsKey(qIMFilterCategoryItem.f66698e) || (num2 = map.get(qIMFilterCategoryItem.f66698e)) == null) {
                    return 100;
                }
                return num2.intValue();
            }
            if (!(model instanceof bj)) {
                return 100;
            }
            bj bjVar = (bj) model;
            if (!map.containsKey(bjVar.getName()) || (num = map.get(bjVar.getName())) == null) {
                return 100;
            }
            return num.intValue();
        }

        @JvmStatic
        private final Integer[] o(Object model) {
            Integer[] o16;
            if (model instanceof b) {
                b bVar = (b) model;
                if (bVar.i().isEmpty()) {
                    return new Integer[]{Integer.valueOf(bVar.getCom.heytap.databaseengine.apiv3.data.Element.ELEMENT_NAME_MIN java.lang.String()), Integer.valueOf(bVar.getMax()), Integer.valueOf(bVar.getCooperation.qzone.remote.logic.RemoteHandleConst.PARAM_DEFAULT_VALUE java.lang.String())};
                }
                f p16 = p(bVar);
                return (p16 == null || (o16 = AEProviderViewModel.INSTANCE.o(p16)) == null) ? new Integer[]{0, 100, 100} : o16;
            }
            if (model instanceof f) {
                f fVar = (f) model;
                return new Integer[]{Integer.valueOf(fVar.getMin()), Integer.valueOf(fVar.getMax()), Integer.valueOf(fVar.getCooperation.qzone.remote.logic.RemoteHandleConst.PARAM_DEFAULT_VALUE java.lang.String())};
            }
            if (model instanceof QIMFilterCategoryItem) {
                return new Integer[]{0, 100, Integer.valueOf(c(model, AEProviderViewModel.S))};
            }
            if (model instanceof bj) {
                return new Integer[]{0, 100, Integer.valueOf(((bj) model).getSlidingValue())};
            }
            return new Integer[]{0, 100, 100};
        }

        @JvmStatic
        public final String a(Object model) {
            String a16;
            Intrinsics.checkNotNullParameter(model, "model");
            if (model instanceof b) {
                if (!e()) {
                    return "";
                }
                b bVar = (b) model;
                if (bVar.i().isEmpty()) {
                    return "sp_key_beauty_transform_key_-" + bVar.getType().value + "-adjust";
                }
                f p16 = p(bVar);
                return (p16 == null || (a16 = AEProviderViewModel.INSTANCE.a(p16)) == null) ? "" : a16;
            }
            if (model instanceof f) {
                if (!e()) {
                    return "";
                }
                return "sp_key_beauty_transform_key_-" + ((f) model).getType() + "-adjust";
            }
            if (model instanceof QIMFilterCategoryItem) {
                if (!g()) {
                    return "";
                }
                return "sp_key_filter_adjust_key_-" + ((QIMFilterCategoryItem) model).f66697d + "-adjust";
            }
            if (model instanceof br) {
                if (!f()) {
                    return "";
                }
                return "sp_key_cosmetic_adjust_key_-" + ((br) model).getId() + "-adjust";
            }
            if (!(model instanceof DYAELocalMaterialItem) || !f()) {
                return "";
            }
            return "sp_key_cosmetic_adjust_key_-" + ((DYAELocalMaterialItem) model).getId() + "-adjust";
        }

        @JvmStatic
        public final int b(Object model) {
            Intrinsics.checkNotNullParameter(model, "model");
            int i3 = -1;
            if (model instanceof b) {
                b bVar = (b) model;
                if (bVar.i().isEmpty()) {
                    Integer num = (Integer) AEProviderViewModel.U.get(bVar.getType());
                    if (num != null) {
                        i3 = num.intValue();
                    }
                } else {
                    f p16 = p(bVar);
                    if (p16 != null) {
                        i3 = AEProviderViewModel.INSTANCE.b(p16);
                    }
                }
            } else if (model instanceof f) {
                Integer num2 = (Integer) AEProviderViewModel.V.get(((f) model).getType());
                if (num2 != null) {
                    i3 = num2.intValue();
                }
            } else if (model instanceof QIMFilterCategoryItem) {
                Integer num3 = (Integer) AEProviderViewModel.W.get(((QIMFilterCategoryItem) model).f66697d);
                if (num3 != null) {
                    i3 = num3.intValue();
                }
            } else if (model instanceof br) {
                Integer num4 = (Integer) AEProviderViewModel.X.get(((br) model).getId());
                if (num4 != null) {
                    i3 = num4.intValue();
                }
            } else if (model instanceof DYAELocalMaterialItem) {
                Integer num5 = (Integer) AEProviderViewModel.X.get(((DYAELocalMaterialItem) model).getId());
                if (num5 != null) {
                    i3 = num5.intValue();
                }
            } else {
                i3 = 100;
            }
            if (i3 >= 0) {
                return i3;
            }
            int k3 = k(model, d(model));
            s(model, k3);
            return k3;
        }

        @JvmStatic
        public final int d(Object model) {
            Intrinsics.checkNotNullParameter(model, "model");
            return o(model)[2].intValue();
        }

        public final boolean e() {
            return AEProviderViewModel.N;
        }

        public final boolean f() {
            return AEProviderViewModel.Q;
        }

        public final boolean g() {
            return AEProviderViewModel.P;
        }

        @JvmStatic
        public final int h(String id5) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Integer num = (Integer) AEProviderViewModel.W.get(id5);
            int intValue = num != null ? num.intValue() : -1;
            if (intValue >= 0) {
                return intValue;
            }
            return AECameraPrefsUtil.f().g("sp_key_filter_adjust_key_-" + id5 + "-adjust", 100, 0);
        }

        @JvmStatic
        public final int i(Object model) {
            Intrinsics.checkNotNullParameter(model, "model");
            return o(model)[1].intValue();
        }

        @JvmStatic
        public final int j(Object model) {
            Intrinsics.checkNotNullParameter(model, "model");
            return o(model)[0].intValue();
        }

        public final int k(Object model, int defaultValue) {
            Intrinsics.checkNotNullParameter(model, "model");
            String a16 = a(model);
            return a16.length() > 0 ? AECameraPrefsUtil.f().g(a16, defaultValue, 0) : defaultValue;
        }

        @JvmStatic
        public final int l(b bVar, int i3) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            String m3 = m(bVar);
            return m3.length() > 0 ? AECameraPrefsUtil.f().g(m3, i3, 0) : i3;
        }

        @JvmStatic
        public final String m(b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            if (e()) {
                return "sp_key_beauty_transform_key_-" + bVar.getType().value + "-secondary-select-index";
            }
            return "";
        }

        @JvmStatic
        public final int n(b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            Integer num = (Integer) AEProviderViewModel.T.get(bVar.getType());
            int intValue = num != null ? num.intValue() : -1;
            if (intValue >= 0) {
                return intValue;
            }
            int l3 = l(bVar, bVar.getSecondarySelectDefault());
            t(bVar, l3);
            return l3;
        }

        @JvmStatic
        public final f p(b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            List<f> i3 = bVar.i();
            if (i3 == null || i3.isEmpty()) {
                return null;
            }
            return bVar.i().get(n(bVar));
        }

        @JvmStatic
        public final void q(Object model, int value) {
            Intrinsics.checkNotNullParameter(model, "model");
            String a16 = a(model);
            if (a16.length() > 0) {
                AECameraPrefsUtil.f().n(a16, value, 0);
            }
        }

        @JvmStatic
        public final void r(b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            String m3 = m(bVar);
            int n3 = n(bVar);
            if (m3.length() > 0) {
                AECameraPrefsUtil.f().n(m3, n3, 0);
            }
        }

        @JvmStatic
        public final void s(Object model, int value) {
            Intrinsics.checkNotNullParameter(model, "model");
            if (model instanceof b) {
                b bVar = (b) model;
                if (bVar.i().isEmpty()) {
                    AEProviderViewModel.U.put(bVar.getType(), Integer.valueOf(value));
                    return;
                } else {
                    f p16 = p(bVar);
                    if (p16 != null) {
                        AEProviderViewModel.INSTANCE.s(p16, value);
                        return;
                    }
                    return;
                }
            }
            if (model instanceof f) {
                AEProviderViewModel.V.put(((f) model).getType(), Integer.valueOf(value));
                return;
            }
            if (model instanceof QIMFilterCategoryItem) {
                Map map = AEProviderViewModel.W;
                String str = ((QIMFilterCategoryItem) model).f66697d;
                Intrinsics.checkNotNullExpressionValue(str, "model.id");
                map.put(str, Integer.valueOf(value));
                return;
            }
            if (model instanceof br) {
                AEProviderViewModel.X.put(((br) model).getId(), Integer.valueOf(value));
            } else {
                if (model instanceof DYAELocalMaterialItem) {
                    AEProviderViewModel.X.put(((DYAELocalMaterialItem) model).getId(), Integer.valueOf(value));
                    return;
                }
                ms.a.c("AEProviderViewModel", "set seek bar value to " + value + " with invalid data object: " + model);
            }
        }

        @JvmStatic
        public final void t(b bVar, int i3) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            AEProviderViewModel.T.put(bVar.getType(), Integer.valueOf(i3));
        }

        Companion() {
        }
    }

    static {
        Map<String, Integer> mapOf;
        Map<String, Integer> mapOf2;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("\u7ea2\u9152", 60), TuplesKt.to("\u751c\u9177", 60), TuplesKt.to("\u5fc3\u673a\u7d20\u989c", 60), TuplesKt.to("\u8d28\u611f", 60), TuplesKt.to("\u8d39\u6d1b\u8499", 60), TuplesKt.to("\u795e\u989c", 80), TuplesKt.to("\u70ed\u7ea2\u9152", 80), TuplesKt.to("\u788e\u94bb", 80), TuplesKt.to("\u5fae\u95ea", 80), TuplesKt.to("\u871c\u6843", 80), TuplesKt.to("\u5976\u51f6", 80), TuplesKt.to("\u767d\u7699", 80), TuplesKt.to("\u4ed9\u6843", 80), TuplesKt.to("\u6e2f\u98ce", 80), TuplesKt.to("\u5357\u6cd5", 80), TuplesKt.to("\u65e0\u8f9c", 80), TuplesKt.to("\u6e2f\u5473", 80), TuplesKt.to("\u6cb9\u753b", 80), TuplesKt.to("\u52a8\u611f\u673a\u8f66", 80), TuplesKt.to("\u6696\u7537", 60), TuplesKt.to("\u6e05\u65b0\u5367\u8695", 60), TuplesKt.to("\u6f6e\u9177", 60), TuplesKt.to("\u6210\u719f", 60), TuplesKt.to("\u6e05\u65b0", 80), TuplesKt.to("\u6e05\u723d", 80), TuplesKt.to("\u6df1\u9083", 70), TuplesKt.to("\u6f6e\u7537", 80));
        R = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("\u81ea\u7136", 80), TuplesKt.to("\u6e05\u900f", 80), TuplesKt.to("\u6e29\u67d4", 80), TuplesKt.to("\u767d\u7699", 100), TuplesKt.to("\u665a\u98ce", 80), TuplesKt.to("\u7cd6\u679c", 65), TuplesKt.to("\u5976\u6cb9", 100), TuplesKt.to("\u6155\u65af", 80), TuplesKt.to("\u661f\u5149", 100), TuplesKt.to("\u7efd\u653e", 80), TuplesKt.to("\u9752\u6625", 80), TuplesKt.to("\u7eda\u70c2", 100), TuplesKt.to("\u6e05\u6668", 80), TuplesKt.to("\u90fd\u5e02", 80), TuplesKt.to("\u90ca\u91ce", 80), TuplesKt.to("\u5e03\u4e01", 80), TuplesKt.to("\u9999\u9187", 80), TuplesKt.to("\u4f18\u683c", 80), TuplesKt.to("\u51b7\u8403", 80), TuplesKt.to("\u4eea\u5f0f\u611f", 80), TuplesKt.to("\u8f7b\u80f6\u7247", 80), TuplesKt.to("\u5c81\u6708", 80), TuplesKt.to("\u6545\u4e8b", 100), TuplesKt.to("\u7535\u5f71", 80), TuplesKt.to("\u7070\u8c03", 100));
        S = mapOf2;
        T = new LinkedHashMap();
        U = new LinkedHashMap();
        V = new LinkedHashMap();
        W = new LinkedHashMap();
        X = new LinkedHashMap();
    }

    public AEProviderViewModel(AEBeautyProviderViewModel beautyViewModel, AEBodyProviderViewModel bodyViewModel, aa cosmeticsViewModel, ac filterViewModel) {
        Intrinsics.checkNotNullParameter(beautyViewModel, "beautyViewModel");
        Intrinsics.checkNotNullParameter(bodyViewModel, "bodyViewModel");
        Intrinsics.checkNotNullParameter(cosmeticsViewModel, "cosmeticsViewModel");
        Intrinsics.checkNotNullParameter(filterViewModel, "filterViewModel");
        this.beautyViewModel = beautyViewModel;
        this.bodyViewModel = bodyViewModel;
        this.cosmeticsViewModel = cosmeticsViewModel;
        this.filterViewModel = filterViewModel;
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(0);
        this._selectedPanelTabIndex = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
        this.selectedPanelTabIndex = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._aiBeautyToggle = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.aiBeautyToggle = mutableLiveData2;
        final MediatorLiveData<SeekBarOpDataWrapper> mediatorLiveData = new MediatorLiveData<>();
        LiveData<QIMFilterCategoryItem> L1 = filterViewModel.L1();
        final Function1<QIMFilterCategoryItem, Unit> function1 = new Function1<QIMFilterCategoryItem, Unit>() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel$_seekBarOpDataLiveData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QIMFilterCategoryItem qIMFilterCategoryItem) {
                invoke2(qIMFilterCategoryItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QIMFilterCategoryItem qIMFilterCategoryItem) {
                ms.a.f("AEProviderViewModel", "seekBarOpDataChange from selectedFilter");
                mediatorLiveData.postValue(new SeekBarOpDataWrapper(1, qIMFilterCategoryItem, false, 4, null));
            }
        };
        mediatorLiveData.addSource(L1, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.ae
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEProviderViewModel.U1(Function1.this, obj);
            }
        });
        LiveData<bj> N1 = cosmeticsViewModel.N1();
        final Function1<bj, Unit> function12 = new Function1<bj, Unit>() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel$_seekBarOpDataLiveData$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(bj bjVar) {
                invoke2(bjVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(bj bjVar) {
                ms.a.f("AEProviderViewModel", "seekBarOpDataChange from cosmetics selectedMaterial");
                mediatorLiveData.postValue(new SeekBarOpDataWrapper(3, bjVar, false, 4, null));
            }
        };
        mediatorLiveData.addSource(N1, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEProviderViewModel.W1(Function1.this, obj);
            }
        });
        LiveData<b> a26 = beautyViewModel.a2();
        final Function1<b, Unit> function13 = new Function1<b, Unit>() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel$_seekBarOpDataLiveData$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(b bVar) {
                ms.a.f("AEProviderViewModel", "seekBarOpDataChange from beautySelectedLiveData");
                mediatorLiveData.postValue(new SeekBarOpDataWrapper(2, bVar, bVar.i().isEmpty()));
            }
        };
        mediatorLiveData.addSource(a26, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEProviderViewModel.X1(Function1.this, obj);
            }
        });
        LiveData<BeautySecondarySelectedWrapper> Z1 = beautyViewModel.Z1();
        final Function1<BeautySecondarySelectedWrapper, Unit> function14 = new Function1<BeautySecondarySelectedWrapper, Unit>() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel$_seekBarOpDataLiveData$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BeautySecondarySelectedWrapper beautySecondarySelectedWrapper) {
                invoke2(beautySecondarySelectedWrapper);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BeautySecondarySelectedWrapper beautySecondarySelectedWrapper) {
                AEBeautyProviderViewModel aEBeautyProviderViewModel;
                ms.a.f("AEProviderViewModel", "seekBarOpDataChange from beautySecondarySelectedLiveData");
                MediatorLiveData<SeekBarOpDataWrapper> mediatorLiveData2 = mediatorLiveData;
                aEBeautyProviderViewModel = this.beautyViewModel;
                mediatorLiveData2.postValue(new SeekBarOpDataWrapper(2, aEBeautyProviderViewModel.a2().getValue(), false, 4, null));
            }
        };
        mediatorLiveData.addSource(Z1, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEProviderViewModel.Z1(Function1.this, obj);
            }
        });
        LiveData<List<b>> U1 = beautyViewModel.U1();
        final Function1<List<? extends b>, Unit> function15 = new Function1<List<? extends b>, Unit>() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel$_seekBarOpDataLiveData$1$5
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
                AEBeautyProviderViewModel aEBeautyProviderViewModel;
                ms.a.f("AEProviderViewModel", "seekBarOpDataChange from beautyConfigSetLiveData");
                MediatorLiveData<SeekBarOpDataWrapper> mediatorLiveData2 = mediatorLiveData;
                aEBeautyProviderViewModel = this.beautyViewModel;
                mediatorLiveData2.postValue(new SeekBarOpDataWrapper(2, aEBeautyProviderViewModel.a2().getValue(), false, 4, null));
            }
        };
        mediatorLiveData.addSource(U1, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEProviderViewModel.a2(Function1.this, obj);
            }
        });
        LiveData<b> U12 = bodyViewModel.U1();
        final Function1<b, Unit> function16 = new Function1<b, Unit>() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel$_seekBarOpDataLiveData$1$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(b bVar) {
                ms.a.f("AEProviderViewModel", "seekBarOpDataChange from beautySelectedLiveData");
                mediatorLiveData.postValue(new SeekBarOpDataWrapper(4, bVar, bVar.i().isEmpty()));
            }
        };
        mediatorLiveData.addSource(U12, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEProviderViewModel.b2(Function1.this, obj);
            }
        });
        final Function1<Integer, Unit> function17 = new Function1<Integer, Unit>() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel$_seekBarOpDataLiveData$1$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                AEBodyProviderViewModel aEBodyProviderViewModel;
                ac acVar;
                aa aaVar;
                AEBeautyProviderViewModel aEBeautyProviderViewModel;
                ms.a.f("AEProviderViewModel", "seekBarOpDataChange from selectedPanelTabIndex, index = " + num);
                if (num != null && num.intValue() == 1) {
                    MediatorLiveData<SeekBarOpDataWrapper> mediatorLiveData2 = mediatorLiveData;
                    aEBeautyProviderViewModel = this.beautyViewModel;
                    mediatorLiveData2.postValue(new SeekBarOpDataWrapper(2, aEBeautyProviderViewModel.a2().getValue(), false));
                    return;
                }
                if (num != null && num.intValue() == 2) {
                    MediatorLiveData<SeekBarOpDataWrapper> mediatorLiveData3 = mediatorLiveData;
                    aaVar = this.cosmeticsViewModel;
                    mediatorLiveData3.postValue(new SeekBarOpDataWrapper(3, aaVar.N1().getValue(), false, 4, null));
                } else if (num != null && num.intValue() == 0) {
                    MediatorLiveData<SeekBarOpDataWrapper> mediatorLiveData4 = mediatorLiveData;
                    acVar = this.filterViewModel;
                    mediatorLiveData4.postValue(new SeekBarOpDataWrapper(1, acVar.L1().getValue(), false, 4, null));
                } else if (num != null && num.intValue() == 3) {
                    MediatorLiveData<SeekBarOpDataWrapper> mediatorLiveData5 = mediatorLiveData;
                    aEBodyProviderViewModel = this.bodyViewModel;
                    mediatorLiveData5.postValue(new SeekBarOpDataWrapper(4, aEBodyProviderViewModel.U1().getValue(), false, 4, null));
                }
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEProviderViewModel.c2(Function1.this, obj);
            }
        });
        this._seekBarOpDataLiveData = mediatorLiveData;
        Intrinsics.checkNotNull(mediatorLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.aelight.camera.ae.camera.ui.panel.SeekBarOpDataWrapper>");
        this.seekBarOpDataLiveData = mediatorLiveData;
        final MediatorLiveData<Boolean> mediatorLiveData2 = new MediatorLiveData<>();
        final Function1<SeekBarOpDataWrapper, Unit> function18 = new Function1<SeekBarOpDataWrapper, Unit>() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel$_seekBarShowLiveData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SeekBarOpDataWrapper seekBarOpDataWrapper) {
                invoke2(seekBarOpDataWrapper);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x00c6, code lost:
            
                if (kotlin.jvm.internal.Intrinsics.areEqual(r5.b2().getValue(), java.lang.Boolean.FALSE) == false) goto L43;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(SeekBarOpDataWrapper seekBarOpDataWrapper) {
                MutableLiveData mutableLiveData3;
                Object obj;
                AEBodyProviderViewModel aEBodyProviderViewModel;
                aa aaVar;
                AEBeautyProviderViewModel aEBeautyProviderViewModel;
                AEBeautyProviderViewModel aEBeautyProviderViewModel2;
                ac acVar;
                mutableLiveData3 = AEProviderViewModel.this._selectedPanelTabIndex;
                Integer num = (Integer) mutableLiveData3.getValue();
                boolean z16 = true;
                if (num != null && num.intValue() == 0) {
                    acVar = AEProviderViewModel.this.filterViewModel;
                    obj = acVar.L1().getValue();
                } else if (num != null && num.intValue() == 1) {
                    aEBeautyProviderViewModel = AEProviderViewModel.this.beautyViewModel;
                    b value = aEBeautyProviderViewModel.a2().getValue();
                    obj = value;
                    if (value != null) {
                        boolean z17 = !value.i().isEmpty();
                        obj = value;
                        if (z17) {
                            obj = AEProviderViewModel.INSTANCE.p(value);
                        }
                    }
                } else if (num != null && num.intValue() == 2) {
                    aaVar = AEProviderViewModel.this.cosmeticsViewModel;
                    obj = aaVar.N1().getValue();
                } else if (num != null && num.intValue() == 3) {
                    aEBodyProviderViewModel = AEProviderViewModel.this.bodyViewModel;
                    obj = aEBodyProviderViewModel.U1().getValue();
                } else {
                    obj = null;
                }
                if (obj != null) {
                    MediatorLiveData<Boolean> mediatorLiveData3 = mediatorLiveData2;
                    boolean z18 = !bk.a(obj);
                    if (obj instanceof bj) {
                        z16 = ((bj) obj).getEnable();
                    } else if (obj instanceof b) {
                        z16 = ((b) obj).getEnable();
                    } else if (obj instanceof f) {
                        if (((f) obj).getEnable()) {
                            aEBeautyProviderViewModel2 = AEProviderViewModel.this.beautyViewModel;
                        }
                        z16 = false;
                    }
                    mediatorLiveData3.postValue(Boolean.valueOf(z18 & z16));
                    return;
                }
                mediatorLiveData2.postValue(Boolean.FALSE);
            }
        };
        mediatorLiveData2.addSource(mediatorLiveData, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEProviderViewModel.d2(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> b26 = beautyViewModel.b2();
        final Function1<Boolean, Unit> function19 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel$_seekBarShowLiveData$1$2
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
            public final void invoke2(Boolean bool) {
                mediatorLiveData2.postValue(bool);
            }
        };
        mediatorLiveData2.addSource(b26, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEProviderViewModel.e2(Function1.this, obj);
            }
        });
        this._seekBarShowLiveData = mediatorLiveData2;
        Intrinsics.checkNotNull(mediatorLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.seekBarShowLiveData = mediatorLiveData2;
    }

    @JvmStatic
    public static final f D2(b bVar) {
        return INSTANCE.p(bVar);
    }

    @JvmStatic
    public static final void G2(Object obj, int i3) {
        INSTANCE.q(obj, i3);
    }

    @JvmStatic
    public static final void H2(Object obj, int i3) {
        INSTANCE.s(obj, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @JvmStatic
    public static final int t2(Object obj) {
        return INSTANCE.b(obj);
    }

    @JvmStatic
    public static final int v2(Object obj) {
        return INSTANCE.d(obj);
    }

    @JvmStatic
    public static final int w2(String str) {
        return INSTANCE.h(str);
    }

    @JvmStatic
    public static final int x2(Object obj) {
        return INSTANCE.i(obj);
    }

    @JvmStatic
    public static final int y2(Object obj) {
        return INSTANCE.j(obj);
    }

    @JvmStatic
    public static final int z2(b bVar) {
        return INSTANCE.n(bVar);
    }

    public final LiveData<SeekBarOpDataWrapper> A2() {
        return this.seekBarOpDataLiveData;
    }

    public final LiveData<Boolean> B2() {
        return this.seekBarShowLiveData;
    }

    public final LiveData<Integer> C2() {
        return this.selectedPanelTabIndex;
    }

    public final void E2(Object model, int progress) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (model instanceof b) {
            b bVar = (b) model;
            if (bVar.i().isEmpty()) {
                this.beautyViewModel.T1().postValue(model);
                this.bodyViewModel.R1().postValue(model);
                return;
            } else {
                f p16 = INSTANCE.p(bVar);
                if (p16 != null) {
                    E2(p16, progress);
                    return;
                }
                return;
            }
        }
        if (model instanceof f) {
            this.beautyViewModel.X1().postValue(model);
        }
    }

    public final void F2() {
        Integer value = this._selectedPanelTabIndex.getValue();
        if (value != null && value.intValue() == 0) {
            this.filterViewModel.M1();
            return;
        }
        if (value != null && value.intValue() == 1) {
            this.beautyViewModel.g2();
            return;
        }
        if (value != null && value.intValue() == 2) {
            this.cosmeticsViewModel.O1();
        } else if (value != null && value.intValue() == 3) {
            this.bodyViewModel.Z1();
        }
    }

    public final void I2(int index) {
        this._selectedPanelTabIndex.postValue(Integer.valueOf(index));
    }

    public final void J2(boolean on5) {
        this._aiBeautyToggle.postValue(Boolean.valueOf(on5));
    }

    public final void K2(int ability, AEMaterialMetaData material) {
        this.cosmeticsViewModel.T1(material);
        this.beautyViewModel.l2(ability, material);
        this.bodyViewModel.b2(ability, material);
    }

    public final LiveData<Boolean> u2() {
        return this.aiBeautyToggle;
    }
}
