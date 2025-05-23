package m63;

import android.graphics.Color;
import android.os.SystemClock;
import androidx.annotation.ColorInt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.effect.EffectStatusManager;
import com.tencent.mobileqq.wink.editor.effect.EffectStatusManagerKt;
import com.tencent.mobileqq.wink.editor.effect.a;
import com.tencent.mobileqq.wink.editor.effect.model.WinkEffectCatType;
import com.tencent.mobileqq.wink.editor.effect.model.WinkEffectOpReportData;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.SpecialEffectModel;
import com.tencent.videocut.model.SpecialEffectModelKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import m63.a;
import m63.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u0097\u00012\u00020\u0001:\u0002\u0098\u0001B\t\u00a2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\u0012\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\u0004H\u0014J\u0006\u0010\u0013\u001a\u00020\u0002J,\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017J4\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u001aJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000bJ\u001e\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0002J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(J\u0006\u0010+\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u001aJ\u0006\u0010/\u001a\u00020\u0004J\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u0004J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0002J\u0006\u00104\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\b2\u0006\u0010)\u001a\u00020(R \u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020807068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R#\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000208070<8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R$\u0010C\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010:R'\u0010F\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f0<8\u0006\u00a2\u0006\f\n\u0004\bD\u0010>\u001a\u0004\bE\u0010@R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010:R\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020<8\u0006\u00a2\u0006\f\n\u0004\bI\u0010>\u001a\u0004\bJ\u0010@R\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010:R\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00020<8\u0006\u00a2\u0006\f\n\u0004\bN\u0010>\u001a\u0004\bO\u0010@R\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010:R\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00020<8\u0006\u00a2\u0006\f\n\u0004\bS\u0010>\u001a\u0004\bT\u0010@R \u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V07068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010:R#\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V070<8\u0006\u00a2\u0006\f\n\u0004\bY\u0010>\u001a\u0004\bZ\u0010@R\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001a068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010:R\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001a0<8\u0006\u00a2\u0006\f\n\u0004\b^\u0010>\u001a\u0004\b_\u0010@R$\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001a\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR(\u0010j\u001a\u0004\u0018\u00010\u000b2\b\u0010e\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u0016\u0010m\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020(068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010:R\u001d\u0010r\u001a\b\u0012\u0004\u0012\u00020(0<8\u0006\u00a2\u0006\f\n\u0004\bp\u0010>\u001a\u0004\bq\u0010@R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010z\u001a\u00020u8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\by\u0010wR0\u0010\u007f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0{j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`|8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010~R2\u0010\u0081\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0{j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`|8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010~R\u0017\u0010\u0082\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010QR!\u0010\u0085\u0001\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001d\u0010\u008b\u0001\u001a\u00030\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0017\u0010\u008e\u0001\u001a\u00020u8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R3\u0010\u0091\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0{j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`|8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0014\u0010\u0094\u0001\u001a\u00020(8F\u00a2\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\u00a8\u0006\u0099\u0001"}, d2 = {"Lm63/d;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "disable", "", "p2", "", "effectId", "", "R1", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "Lcom/tencent/mobileqq/wink/editor/effect/EffectTimeline;", "g2", "getLogTag", "Lcom/tencent/mobileqq/wink/editor/effect/a;", "effectDelegate", "k2", "onCleared", "W1", "id", "name", HippyQQPagViewController.PropertyName.SCALE_MODE, "", "path", "t2", "", "_durationUs", "M1", "endTime", "v2", "appliedEffect", "u2", "startUs", "stopUs", "isLeftSlider", "x2", "z2", ICustomDataEditor.STRING_PARAM_2, "r2", "Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;", "type", "y2", "Q1", "O1", "durationUs", "o2", ICustomDataEditor.NUMBER_PARAM_2, "N1", "B2", "P1", "m2", "l2", "b2", "Landroidx/lifecycle/MutableLiveData;", "Lt73/a;", "Lm63/b;", "i", "Landroidx/lifecycle/MutableLiveData;", "_applyEffectEvent", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "applyEffectEvent", BdhLogUtil.LogTag.Tag_Conn, "_applyEffectTimeline", "D", "T1", "applyEffectTimeline", "E", "_applyingState", UserInfo.SEX_FEMALE, "U1", "applyingState", "G", "_undoEnable", "H", "j2", "undoEnable", "I", "_redoEnable", "J", SemanticAttributes.DbSystemValues.H2, "redoEnable", "Lm63/a;", "K", "_dismissEvent", "L", "X1", "dismissEvent", "M", "_needSelectEffect", "N", "f2", "needSelectEffect", "Lkotlin/Pair;", "P", "Lkotlin/Pair;", "progressingEffect", "<set-?>", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "Z1", "()Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", "editingEffect", BdhLogUtil.LogTag.Tag_Req, "Z", "inited", ExifInterface.LATITUDE_SOUTH, "_effectTypeLiveData", "T", "e2", "effectTypeLiveData", "U", "Lcom/tencent/mobileqq/wink/editor/effect/a;", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager;", "V", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager;", "_effectStatusManagerScreen", "W", "_effectStatusManagerFace", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "X", "Ljava/util/HashMap;", "_effectMapScree", "Y", "_effectMapFace", "currentUseColorIndex", "a0", "Ljava/util/ArrayList;", "currentAppliedEffect", "Lcom/tencent/mobileqq/wink/editor/effect/model/a;", "b0", "Lcom/tencent/mobileqq/wink/editor/effect/model/a;", "i2", "()Lcom/tencent/mobileqq/wink/editor/effect/model/a;", "reportData", "c2", "()Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager;", "effectStatusManager", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Ljava/util/HashMap;", "effectMap", "d2", "()Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;", AIAbilityModel.AI_KEY, "<init>", "()V", "c0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d extends BaseViewModel {

    /* renamed from: d0, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f416307d0;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ArrayList<EffectStatusManager.AppliedEffect>> _applyEffectTimeline;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<ArrayList<EffectStatusManager.AppliedEffect>> applyEffectTimeline;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _applyingState;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> applyingState;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _undoEnable;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> undoEnable;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _redoEnable;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> redoEnable;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<t73.a<a>> _dismissEvent;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<t73.a<a>> dismissEvent;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _needSelectEffect;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Long> needSelectEffect;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private volatile Pair<EffectStatusManager.AppliedEffect, Long> progressingEffect;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private volatile EffectStatusManager.AppliedEffect editingEffect;

    /* renamed from: R, reason: from kotlin metadata */
    private volatile boolean inited;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<WinkEffectCatType> _effectTypeLiveData;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final LiveData<WinkEffectCatType> effectTypeLiveData;

    /* renamed from: U, reason: from kotlin metadata */
    private com.tencent.mobileqq.wink.editor.effect.a effectDelegate;

    /* renamed from: V, reason: from kotlin metadata */
    private EffectStatusManager _effectStatusManagerScreen;

    /* renamed from: W, reason: from kotlin metadata */
    private EffectStatusManager _effectStatusManagerFace;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Integer> _effectMapScree;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Integer> _effectMapFace;

    /* renamed from: Z, reason: from kotlin metadata */
    private int currentUseColorIndex;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<EffectStatusManager.AppliedEffect> currentAppliedEffect;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEffectOpReportData reportData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<t73.a<m63.b>> _applyEffectEvent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<t73.a<m63.b>> applyEffectEvent;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f416312a;

        static {
            int[] iArr = new int[WinkEffectCatType.values().length];
            try {
                iArr[WinkEffectCatType.TypeScreen.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WinkEffectCatType.TypeFace.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f416312a = iArr;
        }
    }

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#CC2D77E5")), Integer.valueOf(Color.parseColor("#CCE57E39")), Integer.valueOf(Color.parseColor("#CC775CE6")), Integer.valueOf(Color.parseColor("#CCE6505C")), Integer.valueOf(Color.parseColor("#CC12BC67")), Integer.valueOf(Color.parseColor("#CC4DB7FF")), Integer.valueOf(Color.parseColor("#CCFFB300")), Integer.valueOf(Color.parseColor("#CC0089E5")), Integer.valueOf(Color.parseColor("#CCE55BA0")), Integer.valueOf(Color.parseColor("#CC5BDE9D"))});
        f416307d0 = listOf;
    }

    public d() {
        MutableLiveData<t73.a<m63.b>> mutableLiveData = new MutableLiveData<>();
        this._applyEffectEvent = mutableLiveData;
        this.applyEffectEvent = mutableLiveData;
        MutableLiveData<ArrayList<EffectStatusManager.AppliedEffect>> mutableLiveData2 = new MutableLiveData<>();
        this._applyEffectTimeline = mutableLiveData2;
        this.applyEffectTimeline = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(Boolean.FALSE);
        this._applyingState = mutableLiveData3;
        this.applyingState = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._undoEnable = mutableLiveData4;
        this.undoEnable = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this._redoEnable = mutableLiveData5;
        this.redoEnable = mutableLiveData5;
        MutableLiveData<t73.a<a>> mutableLiveData6 = new MutableLiveData<>();
        this._dismissEvent = mutableLiveData6;
        this.dismissEvent = mutableLiveData6;
        MutableLiveData<Long> mutableLiveData7 = new MutableLiveData<>();
        this._needSelectEffect = mutableLiveData7;
        this.needSelectEffect = mutableLiveData7;
        MutableLiveData<WinkEffectCatType> mutableLiveData8 = new MutableLiveData<>(WinkEffectCatType.TypeScreen);
        this._effectTypeLiveData = mutableLiveData8;
        this.effectTypeLiveData = mutableLiveData8;
        this._effectMapScree = new HashMap<>();
        this._effectMapFace = new HashMap<>();
        this.currentAppliedEffect = new ArrayList<>();
        this.reportData = new WinkEffectOpReportData(0, 0, 0, 0, 0, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.editor.effect.a aVar = this$0.effectDelegate;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar = null;
        }
        aVar.seek(0L);
    }

    @ColorInt
    private final int R1(String effectId) {
        HashMap<String, Integer> a26 = a2();
        Integer num = a26.get(effectId);
        if (num == null) {
            List<Integer> list = f416307d0;
            int intValue = list.get(this.currentUseColorIndex).intValue();
            this.currentUseColorIndex = (this.currentUseColorIndex + 1) % list.size();
            num = Integer.valueOf(intValue);
            a26.put(effectId, num);
        }
        return num.intValue();
    }

    private final HashMap<String, Integer> a2() {
        int i3 = b.f416312a[d2().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return this._effectMapFace;
            }
            throw new NoWhenBranchMatchedException();
        }
        return this._effectMapScree;
    }

    private final EffectStatusManager c2() {
        EffectStatusManager effectStatusManager;
        int i3 = b.f416312a[d2().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                effectStatusManager = this._effectStatusManagerFace;
                if (effectStatusManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
                    return null;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            effectStatusManager = this._effectStatusManagerScreen;
            if (effectStatusManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
                return null;
            }
        }
        return effectStatusManager;
    }

    private final ArrayList<EffectStatusManager.AppliedEffect> g2() {
        int i3 = b.f416312a[d2().ordinal()];
        EffectStatusManager effectStatusManager = null;
        if (i3 != 1) {
            if (i3 == 2) {
                EffectStatusManager effectStatusManager2 = this._effectStatusManagerScreen;
                if (effectStatusManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
                } else {
                    effectStatusManager = effectStatusManager2;
                }
                return effectStatusManager.h();
            }
            throw new NoWhenBranchMatchedException();
        }
        EffectStatusManager effectStatusManager3 = this._effectStatusManagerFace;
        if (effectStatusManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
        } else {
            effectStatusManager = effectStatusManager3;
        }
        return effectStatusManager.h();
    }

    private final void p2(boolean disable) {
        Boolean valueOf;
        Boolean valueOf2;
        MutableLiveData<Boolean> mutableLiveData = this._undoEnable;
        if (disable) {
            valueOf = Boolean.FALSE;
        } else {
            valueOf = Boolean.valueOf(c2().g());
        }
        mutableLiveData.setValue(valueOf);
        MutableLiveData<Boolean> mutableLiveData2 = this._redoEnable;
        if (disable) {
            valueOf2 = Boolean.FALSE;
        } else {
            valueOf2 = Boolean.valueOf(c2().f());
        }
        mutableLiveData2.setValue(valueOf2);
    }

    static /* synthetic */ void q2(d dVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        dVar.p2(z16);
    }

    public static /* synthetic */ void w2(d dVar, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        dVar.v2(j3);
    }

    public final void B2() {
        com.tencent.mobileqq.wink.editor.effect.a aVar;
        List plus;
        EffectStatusManager effectStatusManager = this._effectStatusManagerFace;
        EffectStatusManager effectStatusManager2 = null;
        if (effectStatusManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
            effectStatusManager = null;
        }
        effectStatusManager.o();
        EffectStatusManager effectStatusManager3 = this._effectStatusManagerScreen;
        if (effectStatusManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
            effectStatusManager3 = null;
        }
        effectStatusManager3.o();
        com.tencent.mobileqq.wink.editor.effect.a aVar2 = this.effectDelegate;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar = null;
        } else {
            aVar = aVar2;
        }
        EffectStatusManager effectStatusManager4 = this._effectStatusManagerFace;
        if (effectStatusManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
            effectStatusManager4 = null;
        }
        ArrayList<EffectStatusManager.AppliedEffect> h16 = effectStatusManager4.h();
        EffectStatusManager effectStatusManager5 = this._effectStatusManagerScreen;
        if (effectStatusManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
        } else {
            effectStatusManager2 = effectStatusManager5;
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) h16, (Iterable) effectStatusManager2.h());
        a.C9024a.a(aVar, plus, 0L, 2, null);
    }

    public final void M1(@NotNull String id5, @NotNull String name, int scaleMode, @NotNull List<String> path, long _durationUs) {
        String joinToString$default;
        List plus;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        if (this.progressingEffect == null && this.editingEffect == null) {
            com.tencent.mobileqq.wink.editor.effect.a aVar = this.effectDelegate;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar = null;
            }
            aVar.setLoop(true);
            com.tencent.mobileqq.wink.editor.effect.a aVar2 = this.effectDelegate;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar2 = null;
            }
            long b16 = aVar2.b();
            com.tencent.mobileqq.wink.editor.effect.a aVar3 = this.effectDelegate;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar3 = null;
            }
            long min = Math.min(aVar3.getDurationUs() - b16, _durationUs);
            com.tencent.mobileqq.wink.editor.effect.a aVar4 = this.effectDelegate;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar4 = null;
            }
            if (min < aVar4.getFrameDuration()) {
                w53.b.a("WinkEffectTimeLineViewModel", "start in end, ignore");
                return;
            }
            int R1 = R1(id5);
            EffectStatusManager.AppliedEffect appliedEffect = new EffectStatusManager.AppliedEffect(EffectStatusManager.AppliedEffect.INSTANCE.a(), id5, b16, min, path, name, scaleMode, R1, false, d2(), 256, null);
            this._applyEffectEvent.setValue(new t73.a<>(new b.Add(appliedEffect.getMaterialId(), appliedEffect.getStartOffsetUs(), appliedEffect.i(), R1, appliedEffect)));
            com.tencent.mobileqq.wink.editor.effect.a aVar5 = this.effectDelegate;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar5 = null;
            }
            aVar5.play();
            Pair c16 = EffectStatusManager.c(c2(), id5, b16, min, path, name, scaleMode, R1, 0L, 128, null);
            EffectStatusManager.AppliedEffect appliedEffect2 = (EffectStatusManager.AppliedEffect) c16.component1();
            ArrayList<EffectStatusManager.AppliedEffect> arrayList = (ArrayList) c16.component2();
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null);
            ms.a.a("effectTest", "applysegment " + joinToString$default);
            this._applyEffectTimeline.setValue(arrayList);
            this._needSelectEffect.setValue(Long.valueOf(appliedEffect2.getId()));
            EffectStatusManager effectStatusManager = this._effectStatusManagerFace;
            if (effectStatusManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
                effectStatusManager = null;
            }
            ArrayList<EffectStatusManager.AppliedEffect> h16 = effectStatusManager.h();
            EffectStatusManager effectStatusManager2 = this._effectStatusManagerScreen;
            if (effectStatusManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
                effectStatusManager2 = null;
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection) h16, (Iterable) effectStatusManager2.h());
            ArrayList arrayList2 = new ArrayList(plus);
            w53.b.a("WinkEffectTimeLineViewModel", "applyEffectSegment timeline: " + EffectStatusManagerKt.c(arrayList2));
            com.tencent.mobileqq.wink.editor.effect.a aVar6 = this.effectDelegate;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar6 = null;
            }
            a.C9024a.a(aVar6, arrayList2, 0L, 2, null);
            p2(false);
            WinkEffectOpReportData winkEffectOpReportData = this.reportData;
            winkEffectOpReportData.g(winkEffectOpReportData.getEffectItemClickNum() + 1);
        }
    }

    public final void N1() {
        List plus;
        Iterable indices;
        boolean z16;
        EffectStatusManager effectStatusManager = this._effectStatusManagerScreen;
        EffectStatusManager effectStatusManager2 = null;
        if (effectStatusManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
            effectStatusManager = null;
        }
        ArrayList<EffectStatusManager.AppliedEffect> h16 = effectStatusManager.h();
        EffectStatusManager effectStatusManager3 = this._effectStatusManagerFace;
        if (effectStatusManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
        } else {
            effectStatusManager2 = effectStatusManager3;
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) h16, (Iterable) effectStatusManager2.h());
        boolean z17 = true;
        if (plus.size() == this.currentAppliedEffect.size()) {
            indices = CollectionsKt__CollectionsKt.getIndices(plus);
            if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                Iterator it = indices.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    if (!Intrinsics.areEqual(plus.get(nextInt), this.currentAppliedEffect.get(nextInt))) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
                z17 = false;
            }
        }
        if (z17) {
            this._dismissEvent.setValue(new t73.a<>(a.b.f416293a));
        } else {
            this._dismissEvent.setValue(new t73.a<>(a.C10767a.f416292a));
        }
    }

    public final void O1() {
        EffectStatusManager effectStatusManager = this._effectStatusManagerFace;
        EffectStatusManager effectStatusManager2 = null;
        if (effectStatusManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
            effectStatusManager = null;
        }
        effectStatusManager.d();
        EffectStatusManager effectStatusManager3 = this._effectStatusManagerScreen;
        if (effectStatusManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
        } else {
            effectStatusManager2 = effectStatusManager3;
        }
        effectStatusManager2.d();
        this._applyEffectTimeline.setValue(c2().h());
        this._applyEffectEvent.setValue(new t73.a<>(b.C10768b.f416299a));
    }

    public final void P1() {
        this._dismissEvent.postValue(new t73.a<>(a.C10767a.f416292a));
    }

    public final void Q1() {
        com.tencent.mobileqq.wink.editor.effect.a aVar = this.effectDelegate;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar = null;
        }
        aVar.setLoop(true);
        this._applyEffectEvent.setValue(new t73.a<>(b.C10768b.f416299a));
    }

    @NotNull
    public final LiveData<t73.a<m63.b>> S1() {
        return this.applyEffectEvent;
    }

    @NotNull
    public final LiveData<ArrayList<EffectStatusManager.AppliedEffect>> T1() {
        return this.applyEffectTimeline;
    }

    @NotNull
    public final LiveData<Boolean> U1() {
        return this.applyingState;
    }

    public final boolean W1() {
        return c2().g();
    }

    @NotNull
    public final LiveData<t73.a<a>> X1() {
        return this.dismissEvent;
    }

    @Nullable
    /* renamed from: Z1, reason: from getter */
    public final EffectStatusManager.AppliedEffect getEditingEffect() {
        return this.editingEffect;
    }

    public final int b2(@NotNull WinkEffectCatType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = b.f416312a[type.ordinal()];
        EffectStatusManager effectStatusManager = null;
        if (i3 != 1) {
            if (i3 == 2) {
                EffectStatusManager effectStatusManager2 = this._effectStatusManagerFace;
                if (effectStatusManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
                } else {
                    effectStatusManager = effectStatusManager2;
                }
                return effectStatusManager.h().size();
            }
            throw new NoWhenBranchMatchedException();
        }
        EffectStatusManager effectStatusManager3 = this._effectStatusManagerScreen;
        if (effectStatusManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
        } else {
            effectStatusManager = effectStatusManager3;
        }
        return effectStatusManager.h().size();
    }

    @NotNull
    public final WinkEffectCatType d2() {
        WinkEffectCatType value = this._effectTypeLiveData.getValue();
        if (value == null) {
            return WinkEffectCatType.TypeScreen;
        }
        return value;
    }

    @NotNull
    public final LiveData<WinkEffectCatType> e2() {
        return this.effectTypeLiveData;
    }

    @NotNull
    public final LiveData<Long> f2() {
        return this.needSelectEffect;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkEffectTimeLineViewModel";
    }

    @NotNull
    public final LiveData<Boolean> h2() {
        return this.redoEnable;
    }

    @NotNull
    /* renamed from: i2, reason: from getter */
    public final WinkEffectOpReportData getReportData() {
        return this.reportData;
    }

    @NotNull
    public final LiveData<Boolean> j2() {
        return this.undoEnable;
    }

    public final void k2(@NotNull com.tencent.mobileqq.wink.editor.effect.a effectDelegate) {
        Intrinsics.checkNotNullParameter(effectDelegate, "effectDelegate");
        if (!this.inited) {
            this.inited = true;
            this.effectDelegate = effectDelegate;
            this._effectStatusManagerScreen = new EffectStatusManager(effectDelegate.getDurationUs(), WinkEffectCatType.TypeScreen);
            this._effectStatusManagerFace = new EffectStatusManager(effectDelegate.getDurationUs(), WinkEffectCatType.TypeFace);
        }
        q2(this, false, 1, null);
    }

    public final void l2() {
        AECameraPrefsUtil.c().h(AECameraPrefsUtil.f318474l, false, 0);
    }

    public final boolean m2() {
        return AECameraPrefsUtil.c().b(AECameraPrefsUtil.f318474l, true, 0);
    }

    public final void n2() {
        List plus;
        com.tencent.mobileqq.wink.editor.effect.a aVar;
        if (!this.inited) {
            return;
        }
        EffectStatusManager effectStatusManager = this._effectStatusManagerFace;
        if (effectStatusManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
            effectStatusManager = null;
        }
        com.tencent.mobileqq.wink.editor.effect.a aVar2 = this.effectDelegate;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar2 = null;
        }
        effectStatusManager.r(aVar2.getDurationUs());
        EffectStatusManager effectStatusManager2 = this._effectStatusManagerScreen;
        if (effectStatusManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
            effectStatusManager2 = null;
        }
        com.tencent.mobileqq.wink.editor.effect.a aVar3 = this.effectDelegate;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar3 = null;
        }
        effectStatusManager2.r(aVar3.getDurationUs());
        EffectStatusManager effectStatusManager3 = this._effectStatusManagerFace;
        if (effectStatusManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
            effectStatusManager3 = null;
        }
        ArrayList<EffectStatusManager.AppliedEffect> h16 = effectStatusManager3.h();
        EffectStatusManager effectStatusManager4 = this._effectStatusManagerScreen;
        if (effectStatusManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
            effectStatusManager4 = null;
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) h16, (Iterable) effectStatusManager4.h());
        com.tencent.mobileqq.wink.editor.effect.a aVar4 = this.effectDelegate;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar = null;
        } else {
            aVar = aVar4;
        }
        a.C9024a.a(aVar, plus, 0L, 2, null);
        this._applyEffectTimeline.postValue(new ArrayList<>(plus));
    }

    public final void o2(long durationUs) {
        List plus;
        com.tencent.mobileqq.wink.editor.effect.a aVar;
        EffectStatusManager effectStatusManager = this._effectStatusManagerScreen;
        if (effectStatusManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
            effectStatusManager = null;
        }
        if (effectStatusManager.getTotalDuration() == durationUs) {
            EffectStatusManager effectStatusManager2 = this._effectStatusManagerFace;
            if (effectStatusManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
                effectStatusManager2 = null;
            }
            if (effectStatusManager2.getTotalDuration() == durationUs) {
                return;
            }
        }
        EffectStatusManager effectStatusManager3 = this._effectStatusManagerScreen;
        if (effectStatusManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
            effectStatusManager3 = null;
        }
        effectStatusManager3.r(durationUs);
        EffectStatusManager effectStatusManager4 = this._effectStatusManagerFace;
        if (effectStatusManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
            effectStatusManager4 = null;
        }
        effectStatusManager4.r(durationUs);
        EffectStatusManager effectStatusManager5 = this._effectStatusManagerFace;
        if (effectStatusManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
            effectStatusManager5 = null;
        }
        ArrayList<EffectStatusManager.AppliedEffect> h16 = effectStatusManager5.h();
        EffectStatusManager effectStatusManager6 = this._effectStatusManagerScreen;
        if (effectStatusManager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
            effectStatusManager6 = null;
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) h16, (Iterable) effectStatusManager6.h());
        com.tencent.mobileqq.wink.editor.effect.a aVar2 = this.effectDelegate;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar = null;
        } else {
            aVar = aVar2;
        }
        a.C9024a.a(aVar, plus, 0L, 2, null);
        this._applyEffectTimeline.setValue(new ArrayList<>(c2().h()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        if (this.inited) {
            com.tencent.mobileqq.wink.editor.effect.a aVar = this.effectDelegate;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar = null;
            }
            aVar.destroy();
        }
        super.onCleared();
    }

    public final void r2() {
        List plus;
        com.tencent.mobileqq.wink.editor.effect.a aVar = this.effectDelegate;
        EffectStatusManager effectStatusManager = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar = null;
        }
        aVar.setLoop(false);
        ArrayList<EffectStatusManager.AppliedEffect> h16 = c2().h();
        c2().j();
        for (EffectStatusManager.AppliedEffect appliedEffect : h16) {
            this._applyEffectEvent.setValue(new t73.a<>(new b.Add(appliedEffect.getMaterialId(), appliedEffect.getStartOffsetUs(), appliedEffect.i(), R1(appliedEffect.getMaterialId()), appliedEffect)));
        }
        this._applyEffectTimeline.setValue(h16);
        this.currentAppliedEffect.clear();
        ArrayList<EffectStatusManager.AppliedEffect> arrayList = this.currentAppliedEffect;
        EffectStatusManager effectStatusManager2 = this._effectStatusManagerScreen;
        if (effectStatusManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
            effectStatusManager2 = null;
        }
        ArrayList<EffectStatusManager.AppliedEffect> h17 = effectStatusManager2.h();
        EffectStatusManager effectStatusManager3 = this._effectStatusManagerFace;
        if (effectStatusManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
            effectStatusManager3 = null;
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) h17, (Iterable) effectStatusManager3.h());
        arrayList.addAll(plus);
        EffectStatusManager effectStatusManager4 = this._effectStatusManagerFace;
        if (effectStatusManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
            effectStatusManager4 = null;
        }
        effectStatusManager4.p();
        EffectStatusManager effectStatusManager5 = this._effectStatusManagerScreen;
        if (effectStatusManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
        } else {
            effectStatusManager = effectStatusManager5;
        }
        effectStatusManager.p();
    }

    public final void s2() {
        EffectStatusManager effectStatusManager;
        List listOfNotNull;
        int i3;
        EffectStatusManager effectStatusManager2;
        List listOfNotNull2;
        int i16;
        com.tencent.mobileqq.wink.editor.effect.a aVar = this.effectDelegate;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar = null;
        }
        List<SpecialEffectModel> a16 = aVar.a();
        ArrayList<SpecialEffectModel> arrayList = new ArrayList();
        for (Object obj : a16) {
            if (SpecialEffectModelKt.getValid((SpecialEffectModel) obj)) {
                arrayList.add(obj);
            }
        }
        for (SpecialEffectModel specialEffectModel : arrayList) {
            ms.a.a("effectTest", "restoreEffects: " + specialEffectModel);
            Integer num = specialEffectModel.effectType;
            int ordinal = WinkEffectCatType.TypeFace.ordinal();
            int i17 = 0;
            if (num != null && num.intValue() == ordinal) {
                EffectStatusManager effectStatusManager3 = this._effectStatusManagerFace;
                if (effectStatusManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
                    effectStatusManager2 = null;
                } else {
                    effectStatusManager2 = effectStatusManager3;
                }
                String str = specialEffectModel.id;
                Intrinsics.checkNotNull(str);
                Long l3 = specialEffectModel.startTimeUs;
                Intrinsics.checkNotNull(l3);
                long longValue = l3.longValue();
                Long l16 = specialEffectModel.durationUs;
                Intrinsics.checkNotNull(l16);
                long longValue2 = l16.longValue();
                String str2 = specialEffectModel.filePath;
                Intrinsics.checkNotNull(str2);
                listOfNotNull2 = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new String[]{str2, specialEffectModel.landscapeFilePath});
                String str3 = specialEffectModel.name;
                Intrinsics.checkNotNull(str3);
                Integer num2 = specialEffectModel.scaleMode;
                if (num2 != null) {
                    i16 = num2.intValue();
                } else {
                    i16 = 0;
                }
                Integer num3 = specialEffectModel.bgColor;
                if (num3 != null) {
                    i17 = num3.intValue();
                }
                EffectStatusManager.c(effectStatusManager2, str, longValue, longValue2, listOfNotNull2, str3, i16, i17, 0L, 128, null);
            } else {
                EffectStatusManager effectStatusManager4 = this._effectStatusManagerScreen;
                if (effectStatusManager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
                    effectStatusManager = null;
                } else {
                    effectStatusManager = effectStatusManager4;
                }
                String str4 = specialEffectModel.id;
                Intrinsics.checkNotNull(str4);
                Long l17 = specialEffectModel.startTimeUs;
                Intrinsics.checkNotNull(l17);
                long longValue3 = l17.longValue();
                Long l18 = specialEffectModel.durationUs;
                Intrinsics.checkNotNull(l18);
                long longValue4 = l18.longValue();
                String str5 = specialEffectModel.filePath;
                Intrinsics.checkNotNull(str5);
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new String[]{str5, specialEffectModel.landscapeFilePath});
                String str6 = specialEffectModel.name;
                Intrinsics.checkNotNull(str6);
                Integer num4 = specialEffectModel.scaleMode;
                if (num4 != null) {
                    i3 = num4.intValue();
                } else {
                    i3 = 0;
                }
                Integer num5 = specialEffectModel.bgColor;
                if (num5 != null) {
                    i17 = num5.intValue();
                }
                EffectStatusManager.c(effectStatusManager, str4, longValue3, longValue4, listOfNotNull, str6, i3, i17, 0L, 128, null);
            }
        }
    }

    public final void t2(@NotNull String id5, @NotNull String name, int scaleMode, @NotNull List<String> path) {
        String joinToString$default;
        Object obj;
        List plus;
        com.tencent.mobileqq.wink.editor.effect.a aVar;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        if (this.progressingEffect != null) {
            return;
        }
        com.tencent.mobileqq.wink.editor.effect.a aVar2 = this.effectDelegate;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar2 = null;
        }
        aVar2.setLoop(false);
        com.tencent.mobileqq.wink.editor.effect.a aVar3 = this.effectDelegate;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar3 = null;
        }
        long b16 = aVar3.b();
        com.tencent.mobileqq.wink.editor.effect.a aVar4 = this.effectDelegate;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar4 = null;
        }
        long durationUs = aVar4.getDurationUs() - b16;
        com.tencent.mobileqq.wink.editor.effect.a aVar5 = this.effectDelegate;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar5 = null;
        }
        if (durationUs < aVar5.getFrameDuration()) {
            w53.b.a("WinkEffectTimeLineViewModel", "start in end, ignore");
            return;
        }
        int R1 = R1(id5);
        Pair<EffectStatusManager.AppliedEffect, Long> pair = TuplesKt.to(new EffectStatusManager.AppliedEffect(EffectStatusManager.AppliedEffect.INSTANCE.a(), id5, b16, -1L, path, name, scaleMode, R1, false, d2(), 256, null), Long.valueOf(SystemClock.elapsedRealtime()));
        this._applyEffectEvent.setValue(new t73.a<>(new b.Start(id5, b16, R1, pair.getFirst())));
        this._applyingState.setValue(Boolean.TRUE);
        this.progressingEffect = pair;
        com.tencent.mobileqq.wink.editor.effect.a aVar6 = this.effectDelegate;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar6 = null;
        }
        aVar6.play();
        Pair c16 = EffectStatusManager.c(c2(), id5, b16, durationUs, path, name, scaleMode, R1, 0L, 128, null);
        EffectStatusManager.AppliedEffect appliedEffect = (EffectStatusManager.AppliedEffect) c16.component1();
        ArrayList arrayList = (ArrayList) c16.component2();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null);
        ms.a.a("effectTest", "applying " + joinToString$default);
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual((EffectStatusManager.AppliedEffect) obj, appliedEffect)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        EffectStatusManager.AppliedEffect appliedEffect2 = (EffectStatusManager.AppliedEffect) obj;
        if (appliedEffect2 != null) {
            appliedEffect2.s(true);
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) g2());
        ArrayList arrayList2 = new ArrayList(plus);
        w53.b.a("WinkEffectTimeLineViewModel", "startApplyEffect timeline: " + EffectStatusManagerKt.c(arrayList2));
        com.tencent.mobileqq.wink.editor.effect.a aVar7 = this.effectDelegate;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar = null;
        } else {
            aVar = aVar7;
        }
        a.C9024a.a(aVar, arrayList2, 0L, 2, null);
        p2(true);
        WinkEffectOpReportData winkEffectOpReportData = this.reportData;
        winkEffectOpReportData.i(winkEffectOpReportData.getEffectItemLongClickNum() + 1);
    }

    public final void u2(@NotNull EffectStatusManager.AppliedEffect appliedEffect) {
        Object obj;
        List plus;
        com.tencent.mobileqq.wink.editor.effect.a aVar;
        Intrinsics.checkNotNullParameter(appliedEffect, "appliedEffect");
        if (this.editingEffect != null) {
            return;
        }
        com.tencent.mobileqq.wink.editor.effect.a aVar2 = this.effectDelegate;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar2 = null;
        }
        long durationUs = aVar2.getDurationUs();
        this._applyingState.setValue(Boolean.TRUE);
        this.editingEffect = appliedEffect;
        Pair<EffectStatusManager.AppliedEffect, ArrayList<EffectStatusManager.AppliedEffect>> e16 = c2().e(appliedEffect.getId(), 0L, durationUs);
        EffectStatusManager.AppliedEffect component1 = e16.component1();
        ArrayList<EffectStatusManager.AppliedEffect> component2 = e16.component2();
        Iterator<T> it = component2.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual((EffectStatusManager.AppliedEffect) obj, component1)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        EffectStatusManager.AppliedEffect appliedEffect2 = (EffectStatusManager.AppliedEffect) obj;
        if (appliedEffect2 != null) {
            appliedEffect2.s(true);
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) component2, (Iterable) g2());
        ArrayList arrayList = new ArrayList(plus);
        w53.b.a("WinkEffectTimeLineViewModel", "startEditEffect timeline: " + EffectStatusManagerKt.c(arrayList));
        com.tencent.mobileqq.wink.editor.effect.a aVar3 = this.effectDelegate;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar = null;
        } else {
            aVar = aVar3;
        }
        a.C9024a.a(aVar, arrayList, 0L, 2, null);
        p2(true);
        WinkEffectOpReportData winkEffectOpReportData = this.reportData;
        winkEffectOpReportData.h(winkEffectOpReportData.getEffectItemEditNum() + 1);
    }

    public final void v2(long endTime) {
        boolean z16;
        long b16;
        long b17;
        EffectStatusManager.AppliedEffect appliedEffect;
        List plus;
        com.tencent.mobileqq.wink.editor.effect.a aVar;
        com.tencent.mobileqq.wink.editor.effect.a aVar2 = this.effectDelegate;
        com.tencent.mobileqq.wink.editor.effect.a aVar3 = null;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar2 = null;
        }
        aVar2.pause();
        if (endTime != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.wink.editor.effect.a aVar4 = this.effectDelegate;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar4 = null;
        }
        long frameDuration = aVar4.getFrameDuration();
        if (z16) {
            b16 = endTime;
        } else {
            com.tencent.mobileqq.wink.editor.effect.a aVar5 = this.effectDelegate;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar5 = null;
            }
            b16 = aVar5.b() + frameDuration;
        }
        com.tencent.mobileqq.wink.editor.effect.a aVar6 = this.effectDelegate;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar6 = null;
        }
        long durationUs = aVar6.getDurationUs();
        if (z16) {
            b17 = endTime;
        } else {
            com.tencent.mobileqq.wink.editor.effect.a aVar7 = this.effectDelegate;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar7 = null;
            }
            b17 = aVar7.b() + (frameDuration * 2);
        }
        long min = Math.min(durationUs, b17);
        Pair<EffectStatusManager.AppliedEffect, Long> pair = this.progressingEffect;
        if (pair == null) {
            return;
        }
        EffectStatusManager.AppliedEffect component1 = pair.component1();
        pair.component2().longValue();
        this.progressingEffect = null;
        Triple<ArrayList<EffectStatusManager.AppliedEffect>, EffectStatusManager.AppliedEffect, EffectStatusManager.AppliedEffect> q16 = c2().q();
        if (q16 != null) {
            appliedEffect = q16.getSecond();
        } else {
            appliedEffect = null;
        }
        long startOffsetUs = b16 - component1.getStartOffsetUs();
        long startOffsetUs2 = min - component1.getStartOffsetUs();
        if (startOffsetUs > 0 && startOffsetUs2 > 0 && appliedEffect != null) {
            this._applyEffectEvent.setValue(new t73.a<>(new b.Stop(component1.getStartOffsetUs() + startOffsetUs)));
            this._applyingState.setValue(Boolean.FALSE);
            Pair<EffectStatusManager.AppliedEffect, ArrayList<EffectStatusManager.AppliedEffect>> b18 = c2().b(component1.getMaterialId(), component1.getStartOffsetUs(), startOffsetUs2, component1.m(), component1.getName(), component1.getScaleMode(), component1.getColor(), appliedEffect.getId());
            EffectStatusManager.AppliedEffect component12 = b18.component1();
            ArrayList<EffectStatusManager.AppliedEffect> component2 = b18.component2();
            EffectStatusManager effectStatusManager = this._effectStatusManagerFace;
            if (effectStatusManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
                effectStatusManager = null;
            }
            ArrayList<EffectStatusManager.AppliedEffect> h16 = effectStatusManager.h();
            EffectStatusManager effectStatusManager2 = this._effectStatusManagerScreen;
            if (effectStatusManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
                effectStatusManager2 = null;
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection) h16, (Iterable) effectStatusManager2.h());
            ArrayList arrayList = new ArrayList(plus);
            w53.b.a("WinkEffectTimeLineViewModel", "stopApplyEffect timeline: " + EffectStatusManagerKt.c(arrayList));
            com.tencent.mobileqq.wink.editor.effect.a aVar8 = this.effectDelegate;
            if (aVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar = null;
            } else {
                aVar = aVar8;
            }
            a.C9024a.a(aVar, arrayList, 0L, 2, null);
            this._applyEffectTimeline.setValue(component2);
            this._needSelectEffect.setValue(Long.valueOf(component12.getId()));
            q2(this, false, 1, null);
            if (!z16) {
                com.tencent.mobileqq.wink.editor.effect.a aVar9 = this.effectDelegate;
                if (aVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                } else {
                    aVar3 = aVar9;
                }
                aVar3.seek(b16);
            }
        }
    }

    public final void x2(long startUs, long stopUs, boolean isLeftSlider) {
        long frameDuration;
        List plus;
        com.tencent.mobileqq.wink.editor.effect.a aVar;
        EffectStatusManager.AppliedEffect appliedEffect = this.editingEffect;
        if (appliedEffect == null) {
            return;
        }
        this.editingEffect = null;
        com.tencent.mobileqq.wink.editor.effect.a aVar2 = this.effectDelegate;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar2 = null;
        }
        com.tencent.mobileqq.wink.editor.effect.a aVar3 = this.effectDelegate;
        if (isLeftSlider) {
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar3 = null;
            }
            frameDuration = startUs + aVar3.getFrameDuration();
        } else {
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar3 = null;
            }
            frameDuration = stopUs - aVar3.getFrameDuration();
        }
        aVar2.seek(frameDuration);
        c2().q();
        this._applyingState.setValue(Boolean.FALSE);
        Pair<EffectStatusManager.AppliedEffect, ArrayList<EffectStatusManager.AppliedEffect>> e16 = c2().e(appliedEffect.getId(), startUs, stopUs - startUs);
        EffectStatusManager.AppliedEffect component1 = e16.component1();
        ArrayList<EffectStatusManager.AppliedEffect> component2 = e16.component2();
        EffectStatusManager effectStatusManager = this._effectStatusManagerFace;
        if (effectStatusManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
            effectStatusManager = null;
        }
        ArrayList<EffectStatusManager.AppliedEffect> h16 = effectStatusManager.h();
        EffectStatusManager effectStatusManager2 = this._effectStatusManagerScreen;
        if (effectStatusManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
            effectStatusManager2 = null;
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) h16, (Iterable) effectStatusManager2.h());
        ArrayList arrayList = new ArrayList(plus);
        w53.b.a("WinkEffectTimeLineViewModel", "stopEditEffect timeline: " + EffectStatusManagerKt.c(arrayList));
        com.tencent.mobileqq.wink.editor.effect.a aVar4 = this.effectDelegate;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar = null;
        } else {
            aVar = aVar4;
        }
        a.C9024a.a(aVar, arrayList, 0L, 2, null);
        this._applyEffectTimeline.setValue(component2);
        if (component1 != null) {
            this._needSelectEffect.setValue(Long.valueOf(component1.getId()));
        }
        q2(this, false, 1, null);
    }

    public final void y2(@NotNull WinkEffectCatType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this._effectTypeLiveData.setValue(type);
        this._applyEffectTimeline.setValue(c2().h());
        q2(this, false, 1, null);
    }

    public final void z2() {
        Triple<ArrayList<EffectStatusManager.AppliedEffect>, EffectStatusManager.AppliedEffect, EffectStatusManager.AppliedEffect> q16;
        String joinToString$default;
        long j3;
        List plus;
        com.tencent.mobileqq.wink.editor.effect.a aVar;
        if (!c2().g() || (q16 = c2().q()) == null) {
            return;
        }
        ArrayList<EffectStatusManager.AppliedEffect> component1 = q16.component1();
        EffectStatusManager.AppliedEffect component2 = q16.component2();
        EffectStatusManager.AppliedEffect component3 = q16.component3();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(component1, null, null, null, 0, null, null, 63, null);
        ms.a.a("effectTest undoEffect", component1 + ", " + joinToString$default + " " + component2);
        q2(this, false, 1, null);
        this._applyEffectEvent.setValue(new t73.a<>(b.C10768b.f416299a));
        for (EffectStatusManager.AppliedEffect appliedEffect : component1) {
            this._applyEffectEvent.setValue(new t73.a<>(new b.Add(appliedEffect.getMaterialId(), appliedEffect.getStartOffsetUs(), appliedEffect.i(), R1(appliedEffect.getMaterialId()), appliedEffect)));
        }
        this._applyEffectTimeline.setValue(component1);
        if (component3 != null) {
            long i3 = component3.i();
            com.tencent.mobileqq.wink.editor.effect.a aVar2 = this.effectDelegate;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar2 = null;
            }
            j3 = i3 - aVar2.getFrameDuration();
        } else {
            j3 = 0;
        }
        EffectStatusManager effectStatusManager = this._effectStatusManagerFace;
        if (effectStatusManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerFace");
            effectStatusManager = null;
        }
        ArrayList<EffectStatusManager.AppliedEffect> h16 = effectStatusManager.h();
        EffectStatusManager effectStatusManager2 = this._effectStatusManagerScreen;
        if (effectStatusManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_effectStatusManagerScreen");
            effectStatusManager2 = null;
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) h16, (Iterable) effectStatusManager2.h());
        ArrayList arrayList = new ArrayList(plus);
        w53.b.a("WinkEffectTimeLineViewModel", "undoEffect timeline: " + EffectStatusManagerKt.c(arrayList));
        com.tencent.mobileqq.wink.editor.effect.a aVar3 = this.effectDelegate;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
            aVar3 = null;
        }
        aVar3.c(arrayList, j3);
        if (component3 != null) {
            com.tencent.mobileqq.wink.editor.effect.a aVar4 = this.effectDelegate;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectDelegate");
                aVar = null;
            } else {
                aVar = aVar4;
            }
            aVar.d(component3.i());
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: m63.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.A2(d.this);
                }
            }, 5L);
        }
        WinkEffectOpReportData winkEffectOpReportData = this.reportData;
        winkEffectOpReportData.j(winkEffectOpReportData.getEffectUndoClickNum() + 1);
    }
}
