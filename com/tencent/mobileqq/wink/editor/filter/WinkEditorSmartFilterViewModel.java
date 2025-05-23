package com.tencent.mobileqq.wink.editor.filter;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gyailib.library.GYVideoClassifyResult;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.api.SmartFilter;
import com.tencent.mobileqq.wink.dect.FrameLabelDetector;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRCacheManager;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.Timeline;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.HDRModel;
import com.tencent.videocut.model.LutFilterModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.light.LightConstants;
import org.light.TimeRange;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0002cdB\t\b\u0000\u00a2\u0006\u0004\b`\u0010aJ \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J(\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\"\u0010\u001f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u000bH\u0002J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J \u0010!\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\tH\u0002J.\u0010)\u001a\u00020\f*\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020\u0012H\u0016J\u0006\u0010+\u001a\u00020\tJ\u000e\u0010,\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010-\u001a\u00020\u0007J\u001a\u0010.\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010/\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u00102\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u000200H\u0016J$\u00103\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u00104\u001a\u00020\tJ\u000e\u00105\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u00107\u001a\u00020\t2\u0006\u00106\u001a\u00020\u0003R(\u0010=\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u0005\u0018\u000109088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R+\u0010C\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u0005\u0018\u0001090>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u000200088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010<R\u001d\u0010H\u001a\b\u0012\u0004\u0012\u0002000>8\u0006\u00a2\u0006\f\n\u0004\bF\u0010@\u001a\u0004\bG\u0010BR$\u0010M\u001a\u0012\u0012\u0004\u0012\u00020\u00120Ij\b\u0012\u0004\u0012\u00020\u0012`J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR \u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001a0T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010XR\u0016\u0010[\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010ZR\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010OR\u0014\u0010_\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b]\u0010^\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/WinkEditorSmartFilterViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/wink/editor/filter/h;", "Lcom/tencent/mobileqq/wink/editor/dr;", "winkTavCutDelegate", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "needRefresh", "", "b2", "", "Lcom/tencent/mobileqq/wink/editor/filter/WinkEditorSmartFilterViewModel$b;", "f2", "Lcom/gyailib/library/GYVideoClassifyResult;", "result", "k2", "c2", "", "typeList", "r2", "Z1", "label", "cvResult", ICustomDataEditor.STRING_ARRAY_PARAM_2, "tag", "Lcom/tencent/mobileqq/wink/api/SmartFilter;", "i2", "q2", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "list", "e2", "x2", ICustomDataEditor.STRING_PARAM_2, "t2", "Lcom/tencent/videocut/model/ResourceModel;", "path", "templatePath", "", "startInWhole", "durationInWhole", "w2", "getLogTag", "m2", "p2", "o2", "W", "k0", "", "intensity", "n0", "d0", "v2", "y2", "cut", "u2", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Lcom/tencent/videocut/model/FilterModel;", "i", "Landroidx/lifecycle/MutableLiveData;", "_filterMaterialLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", SemanticAttributes.DbSystemValues.H2, "()Landroidx/lifecycle/LiveData;", "filterMaterialLiveData", BdhLogUtil.LogTag.Tag_Conn, "_smartFilterProgressLiveData", "D", "j2", "smartFilterProgressLiveData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "currentDetectedLabels", UserInfo.SEX_FEMALE, "I", "currentAppliedLabelIndex", "G", "Ljava/util/List;", "detectInfos", "Ljava/util/concurrent/ConcurrentHashMap;", "H", "Ljava/util/concurrent/ConcurrentHashMap;", "smartFilterMaterialMap", "Lcom/gyailib/library/GYVideoClassifyResult;", "cachedLastResult", "J", "detectFilterBeginTime", "K", "g2", "()Ljava/lang/String;", "currentAppliedLabel", "<init>", "()V", "L", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorSmartFilterViewModel extends BaseViewModel implements h {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean M = QzoneConfig.isUseNewSmartFilter();

    @NotNull
    private static final Lazy<String> N;

    @NotNull
    private static final String[] P;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _smartFilterProgressLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> smartFilterProgressLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<String> currentDetectedLabels;

    /* renamed from: F, reason: from kotlin metadata */
    private int currentAppliedLabelIndex;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<DetectInfo> detectInfos;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, SmartFilter> smartFilterMaterialMap;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private GYVideoClassifyResult cachedLastResult;

    /* renamed from: J, reason: from kotlin metadata */
    private long detectFilterBeginTime;

    /* renamed from: K, reason: from kotlin metadata */
    private int intensity;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<FilterModel, MetaMaterial>> _filterMaterialLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Pair<FilterModel, MetaMaterial>> filterMaterialLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000bR\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u001c8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u001c8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001c8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0014\u0010#\u001a\u00020\u001c8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001eR\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u000bR\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/WinkEditorSmartFilterViewModel$a;", "", "", "c", "", "AUTO_FILTER_PATH$delegate", "Lkotlin/Lazy;", "b", "()Ljava/lang/String;", "AUTO_FILTER_PATH", "AUTO_FILTER_SCENE_JSON", "Ljava/lang/String;", "AUTO_FILTER_TEMPLATE_JSON", "DEFAULT_HISTO_MAX_VALUE", "DEFAULT_HISTO_MIN_VALUE", "ENABLE_SMOOTH_VALUE_DISABLE", "ENABLE_SMOOTH_VALUE_ENABLE", "KEY_ENABLE_SMOOTH", "KEY_HISTO_MAX", "KEY_HISTO_MIN", "", "KEY_LABELS", "[Ljava/lang/String;", "KEY_LABEL_1", "KEY_LABEL_2", "KEY_LABEL_3", "KEY_SMART_SCRIPT_AUTOFILTER_PARAMS", "KEY_STRENGTH", "", "MAX_LABEL_NUM", "I", "STATUS_APLLY_DONE", "STATUS_APPLY_CANCELLED", "STATUS_APPLY_FAILD", "STATUS_DETECT_DONE", "STATUS_DETECT_START", "TAG", "isUseNewSmartFilter", "Z", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.filter.WinkEditorSmartFilterViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b() {
            return (String) WinkEditorSmartFilterViewModel.N.getValue();
        }

        public final boolean c() {
            if (new File(b() + "autoFilterScene.json").exists() && FrameLabelDetector.INSTANCE.a() && ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010(\u001a\u00020\u0011\u0012\b\b\u0002\u0010+\u001a\u00020\u0011\u00a2\u0006\u0004\b,\u0010-J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010%\u001a\u0004\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010(\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010\u0015R\u0017\u0010+\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/WinkEditorSmartFilterViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "path", "b", "getTemplatePath", "templatePath", "", "c", "J", "getSelectStart", "()J", "selectStart", "d", "getSelectDuration", "selectDuration", "Lcom/tencent/videocut/model/SizeF;", "e", "Lcom/tencent/videocut/model/SizeF;", "getSize", "()Lcom/tencent/videocut/model/SizeF;", "size", "Lcom/tencent/videocut/model/RectF;", "f", "Lcom/tencent/videocut/model/RectF;", "getPicClipRect", "()Lcom/tencent/videocut/model/RectF;", "picClipRect", "g", "getStartInWhole", "startInWhole", tl.h.F, "getDurationInWhole", "durationInWhole", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJLcom/tencent/videocut/model/SizeF;Lcom/tencent/videocut/model/RectF;JJ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.filter.WinkEditorSmartFilterViewModel$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class DetectInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String path;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String templatePath;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long selectStart;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long selectDuration;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final SizeF size;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final RectF picClipRect;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final long startInWhole;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final long durationInWhole;

        public DetectInfo() {
            this(null, null, 0L, 0L, null, null, 0L, 0L, 255, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetectInfo)) {
                return false;
            }
            DetectInfo detectInfo = (DetectInfo) other;
            if (Intrinsics.areEqual(this.path, detectInfo.path) && Intrinsics.areEqual(this.templatePath, detectInfo.templatePath) && this.selectStart == detectInfo.selectStart && this.selectDuration == detectInfo.selectDuration && Intrinsics.areEqual(this.size, detectInfo.size) && Intrinsics.areEqual(this.picClipRect, detectInfo.picClipRect) && this.startInWhole == detectInfo.startInWhole && this.durationInWhole == detectInfo.durationInWhole) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((((this.path.hashCode() * 31) + this.templatePath.hashCode()) * 31) + androidx.fragment.app.a.a(this.selectStart)) * 31) + androidx.fragment.app.a.a(this.selectDuration)) * 31;
            SizeF sizeF = this.size;
            int i3 = 0;
            if (sizeF == null) {
                hashCode = 0;
            } else {
                hashCode = sizeF.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            RectF rectF = this.picClipRect;
            if (rectF != null) {
                i3 = rectF.hashCode();
            }
            return ((((i16 + i3) * 31) + androidx.fragment.app.a.a(this.startInWhole)) * 31) + androidx.fragment.app.a.a(this.durationInWhole);
        }

        @NotNull
        public String toString() {
            return "DetectInfo(path=" + this.path + ", templatePath=" + this.templatePath + ", selectStart=" + this.selectStart + ", selectDuration=" + this.selectDuration + ", size=" + this.size + ", picClipRect=" + this.picClipRect + ", startInWhole=" + this.startInWhole + ", durationInWhole=" + this.durationInWhole + ")";
        }

        public DetectInfo(@NotNull String path, @NotNull String templatePath, long j3, long j16, @Nullable SizeF sizeF, @Nullable RectF rectF, long j17, long j18) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(templatePath, "templatePath");
            this.path = path;
            this.templatePath = templatePath;
            this.selectStart = j3;
            this.selectDuration = j16;
            this.size = sizeF;
            this.picClipRect = rectF;
            this.startInWhole = j17;
            this.durationInWhole = j18;
        }

        public /* synthetic */ DetectInfo(String str, String str2, long j3, long j16, SizeF sizeF, RectF rectF, long j17, long j18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) == 0 ? str2 : "", (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? 0L : j16, (i3 & 16) != 0 ? null : sizeF, (i3 & 32) == 0 ? rectF : null, (i3 & 64) != 0 ? 0L : j17, (i3 & 128) == 0 ? j18 : 0L);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\"\u0010\n\u001a\u00020\u00042\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/editor/filter/WinkEditorSmartFilterViewModel$c", "Lcom/tencent/mobileqq/wink/dect/b;", "Lcom/gyailib/library/GYVideoClassifyResult;", "result", "", "b", "", "", "d", "", "a", "Ljava/lang/Exception;", "e", "msg", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements com.tencent.mobileqq.wink.dect.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.dect.e f320347b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ dr f320348c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f320349d;

        c(com.tencent.mobileqq.wink.dect.e eVar, dr drVar, MetaMaterial metaMaterial) {
            this.f320347b = eVar;
            this.f320348c = drVar;
            this.f320349d = metaMaterial;
        }

        @Override // com.tencent.mobileqq.wink.dect.b
        public void a(@NotNull Map<String, ? extends List<String>> result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.wink.dect.b
        public void b(@NotNull GYVideoClassifyResult result) {
            boolean z16;
            Intrinsics.checkNotNullParameter(result, "result");
            Integer num = (Integer) WinkEditorSmartFilterViewModel.this._smartFilterProgressLiveData.getValue();
            if (num != null && num.intValue() == 103) {
                return;
            }
            String str = result.classifyType;
            Intrinsics.checkNotNullExpressionValue(str, "result.classifyType");
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ms.a.a("WinkEditorSmartFilterViewModel", "onResultAvailable failed");
                WinkEditorSmartFilterViewModel.this._smartFilterProgressLiveData.postValue(102);
                WinkEditorSmartFilterViewModel.this._filterMaterialLiveData.postValue(null);
            } else {
                this.f320347b.e();
                WinkEditorSmartFilterViewModel.this.s2(this.f320348c, result, this.f320349d);
            }
        }

        @Override // com.tencent.mobileqq.wink.dect.b
        public void c(@Nullable Exception e16, @NotNull String msg2) {
            String str;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (e16 != null) {
                str = e16.getMessage();
            } else {
                str = null;
            }
            ms.a.a("WinkEditorSmartFilterViewModel", "detect failed " + str);
            WinkEditorSmartFilterViewModel.this._smartFilterProgressLiveData.postValue(102);
            WinkEditorSmartFilterViewModel.this.currentDetectedLabels.clear();
            this.f320347b.e();
        }

        @Override // com.tencent.mobileqq.wink.dect.b
        public void d(@NotNull List<String> result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/editor/filter/WinkEditorSmartFilterViewModel$d", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/tencent/mobileqq/wink/api/SmartFilter;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends TypeToken<Map<String, ? extends SmartFilter>> {
        d() {
        }
    }

    static {
        Lazy<String> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.editor.filter.WinkEditorSmartFilterViewModel$Companion$AUTO_FILTER_PATH$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(AEResInfo.AGENT_TYPE_VIDEO_FILTER) + File.separator;
            }
        });
        N = lazy;
        P = new String[]{"label1", "label2", "label3"};
    }

    public WinkEditorSmartFilterViewModel() {
        List<DetectInfo> emptyList;
        MutableLiveData<Pair<FilterModel, MetaMaterial>> mutableLiveData = new MutableLiveData<>();
        this._filterMaterialLiveData = mutableLiveData;
        this.filterMaterialLiveData = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this._smartFilterProgressLiveData = mutableLiveData2;
        this.smartFilterProgressLiveData = mutableLiveData2;
        this.currentDetectedLabels = new ArrayList<>(3);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.detectInfos = emptyList;
        this.smartFilterMaterialMap = new ConcurrentHashMap<>();
        this.cachedLastResult = new GYVideoClassifyResult();
        this.intensity = -1;
    }

    private final void Z1(dr winkTavCutDelegate, GYVideoClassifyResult result) {
        JSONObject jSONObject = new JSONObject();
        String str = "255";
        String str2 = "0";
        if (y53.c.a() < 3) {
            jSONObject.put("histo_max", "255");
            jSONObject.put("histo_min", "0");
            jSONObject.put("enable_smooth", "0");
        } else {
            String str3 = result.output.get(result.kVideoClassifyOutputKeyHistoMax);
            if (str3 != null) {
                str = str3;
            }
            jSONObject.put("histo_max", str);
            String str4 = result.output.get(result.kVideoClassifyOutputKeyHistoMin);
            if (str4 == null) {
                str4 = "0";
            }
            jSONObject.put("histo_min", str4);
            String str5 = result.output.get(result.kVideoClassifyOutputKeyEnableSmooth);
            if (str5 != null && Intrinsics.areEqual(str5, "true")) {
                str2 = "1";
            }
            jSONObject.put("enable_smooth", str2);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        hashMap.put(LightConstants.EventKey.EVENT_SCRIPT_AUTOFILTER_PARAMS, jSONObject2);
        WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) winkTavCutDelegate;
        if (winkVideoTavCut != null) {
            winkVideoTavCut.G2(hashMap);
        }
    }

    private final void a2(final dr winkTavCutDelegate, String label, MetaMaterial material, GYVideoClassifyResult cvResult) {
        ms.a.a("WinkEditorSmartFilterViewModel", "labelDetect : applySmartFilterByLabel " + label);
        SmartFilter i26 = i2(label);
        if (i26 == null) {
            ms.a.c("WinkEditorSmartFilterViewModel", "applySmartFilterByLabel : can not getSmartFilterInfoByLabel " + label + " ");
            return;
        }
        String str = i26.absoluteTemplatePath;
        ms.a.a("WinkEditorSmartFilterViewModel", "applied material: " + str + ", " + i26.tag + ", " + FileUtils.fileExists(str));
        y2(material);
        x2(material, g2());
        this._smartFilterProgressLiveData.postValue(101);
        String a06 = com.tencent.mobileqq.wink.editor.c.a0(material);
        String str2 = material.f30533id;
        Intrinsics.checkNotNullExpressionValue(str2, "material.id");
        String str3 = i26.absoluteTemplatePath;
        Intrinsics.checkNotNullExpressionValue(str3, "smartFilter.absoluteTemplatePath");
        LutFilterModel lutFilterModel = new LutFilterModel(a06, str2, str3, f.i(material), com.tencent.mobileqq.wink.editor.c.o(material), null, null, 96, null);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this._filterMaterialLiveData.postValue(TuplesKt.to(new FilterModel(uuid, lutFilterModel, null, 0L, TTL.MAX_VALUE, null, 0 == true ? 1 : 0, 108, null), material));
        winkTavCutDelegate.L(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.filter.WinkEditorSmartFilterViewModel$applySmartFilterByLabel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List f26;
                List list;
                String joinToString$default;
                WinkEditorSmartFilterViewModel winkEditorSmartFilterViewModel = WinkEditorSmartFilterViewModel.this;
                f26 = winkEditorSmartFilterViewModel.f2(winkTavCutDelegate);
                winkEditorSmartFilterViewModel.detectInfos = f26;
                list = WinkEditorSmartFilterViewModel.this.detectInfos;
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, null, 63, null);
                ms.a.a("WinkEditorSmartFilterViewModel", "generateDetectInfos: " + joinToString$default);
            }
        });
        Z1(winkTavCutDelegate, cvResult);
    }

    private final void b2(dr winkTavCutDelegate, MetaMaterial material, boolean needRefresh) {
        if (needRefresh) {
            this.currentAppliedLabelIndex = (this.currentAppliedLabelIndex + 1) % this.currentDetectedLabels.size();
        }
        String g26 = g2();
        x2(material, g26);
        a2(winkTavCutDelegate, g26, material, this.cachedLastResult);
    }

    private final void c2(final dr winkTavCutDelegate, final MetaMaterial material) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.ai
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorSmartFilterViewModel.d2(dr.this, this, material);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(dr winkTavCutDelegate, WinkEditorSmartFilterViewModel this$0, MetaMaterial material) {
        com.tencent.mobileqq.wink.dect.e eVar;
        Intrinsics.checkNotNullParameter(winkTavCutDelegate, "$winkTavCutDelegate");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(material, "$material");
        MediaModel V = winkTavCutDelegate.V();
        if (M) {
            eVar = new q(V);
        } else {
            eVar = new com.tencent.mobileqq.wink.dect.e(V);
        }
        eVar.n(com.tencent.mobileqq.wink.dect.c.INSTANCE.b(), new c(eVar, winkTavCutDelegate, material));
    }

    private final boolean e2(dr winkTavCutDelegate, List<ClipSource> list) {
        List<MediaClip> a06;
        List B;
        if (list == null || winkTavCutDelegate == null || (a06 = winkTavCutDelegate.a0()) == null || (B = com.tencent.videocut.render.extension.e.B(a06, false, null, 3, null)) == null || B.size() != list.size()) {
            return true;
        }
        return !B.containsAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DetectInfo> f2(dr winkTavCutDelegate) {
        String joinToString$default;
        String joinToString$default2;
        List<DetectInfo> emptyList;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        long j3;
        List<DetectInfo> emptyList2;
        if (!(winkTavCutDelegate instanceof WinkVideoTavCut)) {
            ms.a.i("WinkEditorSmartFilterViewModel", "generateDetectInfos not video");
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        List<Timeline> F1 = ((WinkVideoTavCut) winkTavCutDelegate).F1();
        ArrayList arrayList = new ArrayList();
        for (Object obj : F1) {
            if (Intrinsics.areEqual(((Timeline) obj).getType(), "VideoSource")) {
                arrayList.add(obj);
            }
        }
        List<MediaClip> g06 = winkTavCutDelegate.g0();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = g06.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null) {
                arrayList2.add(resourceModel);
            }
        }
        if (arrayList.size() != arrayList2.size()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null);
            joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, null, null, null, 0, null, null, 63, null);
            ms.a.i("WinkEditorSmartFilterViewModel", "generateDetectInfos invalid size: " + joinToString$default + "  " + joinToString$default2);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        Collection<HDRModel> values = WinkHDRCacheManager.INSTANCE.a().c().values();
        Intrinsics.checkNotNullExpressionValue(values, "WinkHDRCacheManager.getI\u2026.getHDRResultMap().values");
        Collection<HDRModel> collection = values;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (HDRModel hDRModel : collection) {
            Pair pair = TuplesKt.to(hDRModel.hdrVideoPath, hDRModel.originVideoPath);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        int i3 = 0;
        for (Object obj2 : arrayList2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ResourceModel resourceModel2 = (ResourceModel) obj2;
            Timeline timeline = (Timeline) arrayList.get(i3);
            String templatePath = ((WinkVideoTavCut) winkTavCutDelegate).getTemplatePath();
            if (templatePath == null) {
                templatePath = "";
            }
            String str = templatePath;
            String str2 = (String) linkedHashMap.get(resourceModel2.path);
            TimeRange range = timeline.getRange();
            long j16 = 0;
            if (range != null) {
                j3 = range.startTime;
            } else {
                j3 = 0;
            }
            TimeRange range2 = timeline.getRange();
            if (range2 != null) {
                j16 = range2.duration;
            }
            arrayList3.add(w2(resourceModel2, str2, str, j3, j16));
            i3 = i16;
        }
        return arrayList3;
    }

    private final String g2() {
        String str = this.currentDetectedLabels.get(this.currentAppliedLabelIndex);
        Intrinsics.checkNotNullExpressionValue(str, "currentDetectedLabels[currentAppliedLabelIndex]");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SmartFilter i2(String tag) {
        String str;
        ms.a.a("WinkEditorSmartFilterViewModel", "filter tag" + tag + "smartFilterMap :" + this.smartFilterMaterialMap.size());
        SmartFilter smartFilter = this.smartFilterMaterialMap.get(tag);
        if (smartFilter != null) {
            str = smartFilter.absoluteTemplatePath;
        } else {
            str = null;
        }
        ms.a.a("WinkEditorSmartFilterViewModel", "filter " + tag + " , path :" + str);
        return smartFilter;
    }

    private final void k2(final dr winkTavCutDelegate, final MetaMaterial material, final GYVideoClassifyResult result) {
        boolean z16;
        if (result == null) {
            return;
        }
        String str = result.classifyType;
        Intrinsics.checkNotNullExpressionValue(str, "result.classifyType");
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ms.a.a("WinkEditorSmartFilterViewModel", "labelDetect : onResultAvailable failed");
            this._smartFilterProgressLiveData.postValue(102);
            this._filterMaterialLiveData.postValue(null);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.ah
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorSmartFilterViewModel.l2(WinkEditorSmartFilterViewModel.this, winkTavCutDelegate, result, material);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(WinkEditorSmartFilterViewModel this$0, dr winkTavCutDelegate, GYVideoClassifyResult gYVideoClassifyResult, MetaMaterial material) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(winkTavCutDelegate, "$winkTavCutDelegate");
        Intrinsics.checkNotNullParameter(material, "$material");
        this$0.s2(winkTavCutDelegate, gYVideoClassifyResult, material);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(WinkEditorSmartFilterViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (FileUtils.fileExists(INSTANCE.b() + "autoFilterScene.json")) {
            this$0.q2();
        } else {
            w53.b.c("WinkEditorSmartFilterViewModel", "can not find smart filter path");
        }
    }

    private final void q2() {
        Map map;
        File file = new File(INSTANCE.b() + "autoFilterScene.json");
        HashMap hashMap = new HashMap();
        String h16 = com.tencent.mobileqq.wink.edit.manager.h.h(file);
        if (TextUtils.isEmpty(h16)) {
            return;
        }
        try {
            map = (Map) new Gson().fromJson(h16, new d().getType());
        } catch (Exception e16) {
            w53.b.d("WinkEditorSmartFilterViewModel", "loadFilterListFromFile parse fail", e16);
            map = null;
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                SmartFilter smartFilter = (SmartFilter) entry.getValue();
                String str2 = INSTANCE.b() + smartFilter.path + File.separator + TemplateBean.TEMPLATE_JSON;
                smartFilter.absoluteTemplatePath = str2;
                if (FileUtils.fileExists(str2)) {
                    ms.a.a("WinkEditorSmartFilterViewModel", "smartFilter.absoluteMaterialPath : " + smartFilter.absoluteTemplatePath);
                }
                hashMap.put(str, smartFilter);
            }
            this.smartFilterMaterialMap.clear();
            this.smartFilterMaterialMap.putAll(hashMap);
        }
    }

    private final List<String> r2(List<String> typeList) {
        Sequence asSequence;
        Sequence distinct;
        Sequence map;
        Sequence filter;
        Sequence distinctBy;
        Sequence take;
        Sequence map2;
        List<String> list;
        asSequence = CollectionsKt___CollectionsKt.asSequence(typeList);
        distinct = SequencesKt___SequencesKt.distinct(asSequence);
        map = SequencesKt___SequencesKt.map(distinct, new Function1<String, Pair<? extends SmartFilter, ? extends String>>() { // from class: com.tencent.mobileqq.wink.editor.filter.WinkEditorSmartFilterViewModel$preProcessTagResultList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Pair<SmartFilter, String> invoke(@NotNull String it) {
                SmartFilter i26;
                Intrinsics.checkNotNullParameter(it, "it");
                i26 = WinkEditorSmartFilterViewModel.this.i2(it);
                return TuplesKt.to(i26, it);
            }
        });
        filter = SequencesKt___SequencesKt.filter(map, new Function1<Pair<? extends SmartFilter, ? extends String>, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.filter.WinkEditorSmartFilterViewModel$preProcessTagResultList$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Pair<? extends SmartFilter, ? extends String> pair) {
                return invoke2((Pair<? extends SmartFilter, String>) pair);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(@NotNull Pair<? extends SmartFilter, String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getFirst() != null);
            }
        });
        distinctBy = SequencesKt___SequencesKt.distinctBy(filter, new Function1<Pair<? extends SmartFilter, ? extends String>, String>() { // from class: com.tencent.mobileqq.wink.editor.filter.WinkEditorSmartFilterViewModel$preProcessTagResultList$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Pair<? extends SmartFilter, ? extends String> pair) {
                return invoke2((Pair<? extends SmartFilter, String>) pair);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final String invoke2(@NotNull Pair<? extends SmartFilter, String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SmartFilter first = it.getFirst();
                Intrinsics.checkNotNull(first);
                return first.path;
            }
        });
        take = SequencesKt___SequencesKt.take(distinctBy, 3);
        map2 = SequencesKt___SequencesKt.map(take, new Function1<Pair<? extends SmartFilter, ? extends String>, String>() { // from class: com.tencent.mobileqq.wink.editor.filter.WinkEditorSmartFilterViewModel$preProcessTagResultList$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Pair<? extends SmartFilter, ? extends String> pair) {
                return invoke2((Pair<? extends SmartFilter, String>) pair);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final String invoke2(@NotNull Pair<? extends SmartFilter, String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSecond();
            }
        });
        list = SequencesKt___SequencesKt.toList(map2);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s2(dr winkTavCutDelegate, GYVideoClassifyResult result, MetaMaterial material) {
        List take;
        List<String> c16 = FrameLabelDetector.INSTANCE.c(result);
        if (c16.isEmpty()) {
            this._smartFilterProgressLiveData.postValue(101);
            this._filterMaterialLiveData.postValue(null);
            return;
        }
        if (!o2()) {
            ms.a.a("WinkEditorSmartFilterViewModel", "labelDetect : onResultAvailable failed");
            q2();
        }
        List<String> r26 = r2(c16);
        this.currentDetectedLabels.clear();
        ArrayList<String> arrayList = this.currentDetectedLabels;
        take = CollectionsKt___CollectionsKt.take(r26, 3);
        arrayList.addAll(take);
        this.currentAppliedLabelIndex = 0;
        this._smartFilterProgressLiveData.postValue(100);
        this.cachedLastResult = result;
        t2();
        Integer value = this._smartFilterProgressLiveData.getValue();
        if (value != null && value.intValue() == 103) {
            return;
        }
        a2(winkTavCutDelegate, g2(), material, result);
    }

    private final void t2() {
        long abs = Math.abs(System.currentTimeMillis() - this.detectFilterBeginTime);
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_DETECT_TIME, String.valueOf(abs));
        VideoReport.reportEvent("ev_xsj_camera_action", null, params);
    }

    private final DetectInfo w2(ResourceModel resourceModel, String str, String str2, long j3, long j16) {
        String str3;
        if (str == null) {
            str3 = resourceModel.path;
        } else {
            str3 = str;
        }
        return new DetectInfo(str3, str2, resourceModel.selectStart, resourceModel.selectDuration, resourceModel.size, resourceModel.picClipRect, j3, j16);
    }

    private final void x2(MetaMaterial material, String label) {
        String str;
        SmartFilter i26 = i2(label);
        if (i26 == null) {
            ms.a.c("WinkEditorSmartFilterViewModel", "updateFilterNameText : can not getSmartFilterInfoByLabel " + label + " ");
        }
        String str2 = null;
        if (i26 != null) {
            str = i26.filterName;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        f.x(material, str);
        if (i26 != null) {
            str2 = i26.filterName;
        }
        ms.a.a("WinkEditorSmartFilterViewModel", "materialInfo.filterName:" + str2);
    }

    @Override // com.tencent.mobileqq.wink.editor.filter.h
    public boolean W(@Nullable dr winkTavCutDelegate, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        return true;
    }

    @Override // com.tencent.mobileqq.wink.editor.filter.h
    public void d0(@Nullable dr winkTavCutDelegate, @Nullable MetaMaterial material, boolean needRefresh) {
        ms.a.a("WinkEditorSmartFilterViewModel", "selectFilter:" + com.tencent.mobileqq.wink.utils.r.e());
        if (winkTavCutDelegate != null && material != null) {
            this._smartFilterProgressLiveData.postValue(99);
            this.detectFilterBeginTime = System.currentTimeMillis();
            if (p2(winkTavCutDelegate)) {
                if (!e2(winkTavCutDelegate, winkTavCutDelegate.I())) {
                    ms.a.f("WinkEditorSmartFilterViewModel", "labelDetect : getGYDetectResult  is not null ");
                    k2(winkTavCutDelegate, material, winkTavCutDelegate.getGyResult());
                    return;
                } else {
                    c2(winkTavCutDelegate, material);
                    return;
                }
            }
            b2(winkTavCutDelegate, material, needRefresh);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkEditorSmartFilterViewModel";
    }

    @NotNull
    public final LiveData<Pair<FilterModel, MetaMaterial>> h2() {
        return this.filterMaterialLiveData;
    }

    @NotNull
    public final LiveData<Integer> j2() {
        return this.smartFilterProgressLiveData;
    }

    @Override // com.tencent.mobileqq.wink.editor.filter.h
    public void k0(@Nullable dr winkTavCutDelegate) {
        this._filterMaterialLiveData.postValue(null);
    }

    public final void m2() {
        if (this.smartFilterMaterialMap.size() > 0) {
            w53.b.f("WinkEditorSmartFilterViewModel", "already load smart filter :" + this.smartFilterMaterialMap.size());
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.ag
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorSmartFilterViewModel.n2(WinkEditorSmartFilterViewModel.this);
            }
        }, 64, null, true);
    }

    @Override // com.tencent.mobileqq.wink.editor.filter.h
    public void n0(@Nullable dr winkTavCutDelegate, int intensity) {
        WinkVideoTavCut winkVideoTavCut;
        this.intensity = intensity;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("strength", String.valueOf(intensity / 100.0f));
        HashMap<String, String> hashMap = new HashMap<>();
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        hashMap.put(LightConstants.EventKey.EVENT_SCRIPT_AUTOFILTER_PARAMS, jSONObject2);
        if (winkTavCutDelegate instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) winkTavCutDelegate;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.G2(hashMap);
        }
    }

    public final boolean o2() {
        if (this.smartFilterMaterialMap.size() > 0) {
            return true;
        }
        return false;
    }

    public final boolean p2(@NotNull dr winkTavCutDelegate) {
        List<DetectInfo> emptyList;
        Intrinsics.checkNotNullParameter(winkTavCutDelegate, "winkTavCutDelegate");
        List<DetectInfo> f26 = f2(winkTavCutDelegate);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        if (f26 == emptyList) {
            return true;
        }
        return !Intrinsics.areEqual(f26, this.detectInfos);
    }

    public final void u2(@NotNull dr cut) {
        Intrinsics.checkNotNullParameter(cut, "cut");
        int i3 = this.intensity;
        if (i3 < 0) {
            return;
        }
        n0(cut, i3);
        ms.a.a("WinkEditorSmartFilterViewModel", "restoreFilterIntensity : " + this.intensity);
    }

    public final void v2() {
        this._smartFilterProgressLiveData.postValue(103);
    }

    public final void y2(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        int min = Math.min(P.length, this.currentDetectedLabels.size());
        for (int i3 = 0; i3 < min; i3++) {
            String str = this.currentDetectedLabels.get(i3);
            Intrinsics.checkNotNullExpressionValue(str, "currentDetectedLabels[index]");
            SmartFilter i26 = i2(str);
            if (i26 == null) {
                ms.a.c("WinkEditorSmartFilterViewModel", "updateMaterialLabels : can not getSmartFilterInfoByLabel " + ((Object) this.currentDetectedLabels.get(i3)) + " ");
            } else {
                Map<String, String> map = material.additionalFields;
                Intrinsics.checkNotNullExpressionValue(map, "material.additionalFields");
                map.put(P[i3], i26.tag);
            }
        }
    }
}
