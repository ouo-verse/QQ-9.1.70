package com.tencent.mobileqq.wink.editor.crop.viewmodel;

import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorCropRatioView;
import com.tencent.mobileqq.wink.editor.crop.model.WinkCropUIData;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 q2\u00020\u0001:\u0003rstB\u0007\u00a2\u0006\u0004\bo\u0010pJ \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\f\u0010\n\u001a\u00020\t*\u00020\u0002H\u0002J\f\u0010\u000b\u001a\u00020\t*\u00020\u0002H\u0002J$\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011J\u0018\u0010\u0017\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0003J\u001c\u0010\u001b\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u001a\u001a\u00020\u0003J\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003J\u000e\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u000e\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020\u0003J\u000e\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0003JN\u00104\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020/J\u001e\u00105\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020/J.\u00108\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0018\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020/060\u0018J\u001c\u00109\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018J\u001a\u0010:\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u000e\u0010=\u001a\u00020\t2\u0006\u0010<\u001a\u00020;J\u000e\u0010>\u001a\u00020\t2\u0006\u0010<\u001a\u00020;J\u0006\u0010?\u001a\u00020\tJ\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018J\u0006\u0010A\u001a\u00020\tJ\u0006\u0010B\u001a\u00020\tJ\u0006\u0010C\u001a\u00020\tJ\u0006\u0010D\u001a\u00020\tJ\u0006\u0010E\u001a\u00020\tR\u0016\u0010H\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00030K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00030O8\u0006\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR8\u0010V\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020/060\u0018\u0012\u0004\u0012\u00020\u0003060K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010MR;\u0010Y\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020/060\u0018\u0012\u0004\u0012\u00020\u0003060O8\u0006\u00a2\u0006\f\n\u0004\bW\u0010Q\u001a\u0004\bX\u0010SR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010MR\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00030O8\u0006\u00a2\u0006\f\n\u0004\b\\\u0010Q\u001a\u0004\b]\u0010SR\u0014\u0010a\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010`RH\u0010h\u001a6\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020/060dj\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020/06`e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gRH\u0010j\u001a6\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020/060dj\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020/06`e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010gR\u0016\u0010\u001a\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010n\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010l\u00a8\u0006u"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel$a;", "", "isImage", "", "", "Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel$CropInfo;", "Q1", "", "c2", "g2", "id", "cropInfo", "p2", "S1", "getLogTag", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavcut", "U1", "Lcom/tencent/videocut/model/MediaClip;", "mediaClip", "isDelay", "W1", "", "mediaClips", "isFromClipping", ICustomDataEditor.STRING_PARAM_2, "show", "m2", "needShow", "o2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "isFrom", ICustomDataEditor.NUMBER_PARAM_2, "b2", "isChange", "k2", "Z1", "isCropShow", "l2", "Landroid/graphics/Matrix;", "matrix", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "ratioType", "", "rotateDegree", "Landroid/graphics/RectF;", "cropRect", "isRotate90", "angle", CanvasView.ACTION_RECT, "r2", "q2", "Lkotlin/Pair;", "clipDataList", "N1", SemanticAttributes.DbSystemValues.H2, "T1", "Lcom/tencent/mobileqq/wink/editor/crop/model/WinkCropUIData;", "uiDraft", "f2", "X1", "M1", "R1", "d2", "i2", "e2", "j2", "L1", "i", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCutManager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/crop/model/WinkCropUIData;", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_cropPageShowLiveData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "getCropPageShowLiveData", "()Landroidx/lifecycle/LiveData;", "cropPageShowLiveData", "E", "_changedClipLiveData", UserInfo.SEX_FEMALE, "O1", "changedClipLiveData", "G", "_cropFragmentShowLiveData", "H", "P1", "cropFragmentShowLiveData", "I", "Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel$a;", "storedCropInfo", "J", "storedCropInfoForClip", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "K", "Ljava/util/HashMap;", "storedCLipData", "L", "storedCLipDataForClip", "M", "Z", "N", "isChanged", "<init>", "()V", "P", "a", "b", "CropInfo", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorCropViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _cropPageShowLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> cropPageShowLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<List<Pair<Matrix, RectF>>, Boolean>> _changedClipLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Pair<List<Pair<Matrix, RectF>>, Boolean>> changedClipLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _cropFragmentShowLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> cropFragmentShowLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final a storedCropInfo;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final a storedCropInfoForClip;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Pair<Matrix, RectF>> storedCLipData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Pair<Matrix, RectF>> storedCLipDataForClip;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isFromClipping;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isChanged;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private dr tavCutManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkCropUIData uiDraft;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u000bH\u00c6\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020$H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel$CropInfo;", "Ljava/io/Serializable;", "matrix", "Landroid/graphics/Matrix;", "ratioType", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "rotateDegree", "", "cropRect", "Landroid/graphics/RectF;", "isRotate90", "", "isEmpty", "(Landroid/graphics/Matrix;Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;FLandroid/graphics/RectF;ZZ)V", "getCropRect", "()Landroid/graphics/RectF;", "()Z", "getMatrix", "()Landroid/graphics/Matrix;", "getRatioType", "()Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "getRotateDegree", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final /* data */ class CropInfo implements Serializable {

        @NotNull
        private final RectF cropRect;
        private final boolean isEmpty;
        private final boolean isRotate90;

        @NotNull
        private final Matrix matrix;

        @NotNull
        private final WinkEditorCropRatioView.RatioType ratioType;
        private final float rotateDegree;

        public CropInfo() {
            this(null, null, 0.0f, null, false, false, 63, null);
        }

        public static /* synthetic */ CropInfo copy$default(CropInfo cropInfo, Matrix matrix, WinkEditorCropRatioView.RatioType ratioType, float f16, RectF rectF, boolean z16, boolean z17, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                matrix = cropInfo.matrix;
            }
            if ((i3 & 2) != 0) {
                ratioType = cropInfo.ratioType;
            }
            WinkEditorCropRatioView.RatioType ratioType2 = ratioType;
            if ((i3 & 4) != 0) {
                f16 = cropInfo.rotateDegree;
            }
            float f17 = f16;
            if ((i3 & 8) != 0) {
                rectF = cropInfo.cropRect;
            }
            RectF rectF2 = rectF;
            if ((i3 & 16) != 0) {
                z16 = cropInfo.isRotate90;
            }
            boolean z18 = z16;
            if ((i3 & 32) != 0) {
                z17 = cropInfo.isEmpty;
            }
            return cropInfo.copy(matrix, ratioType2, f17, rectF2, z18, z17);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Matrix getMatrix() {
            return this.matrix;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final WinkEditorCropRatioView.RatioType getRatioType() {
            return this.ratioType;
        }

        /* renamed from: component3, reason: from getter */
        public final float getRotateDegree() {
            return this.rotateDegree;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final RectF getCropRect() {
            return this.cropRect;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsRotate90() {
            return this.isRotate90;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsEmpty() {
            return this.isEmpty;
        }

        @NotNull
        public final CropInfo copy(@NotNull Matrix matrix, @NotNull WinkEditorCropRatioView.RatioType ratioType, float rotateDegree, @NotNull RectF cropRect, boolean isRotate90, boolean isEmpty) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            Intrinsics.checkNotNullParameter(ratioType, "ratioType");
            Intrinsics.checkNotNullParameter(cropRect, "cropRect");
            return new CropInfo(matrix, ratioType, rotateDegree, cropRect, isRotate90, isEmpty);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CropInfo)) {
                return false;
            }
            CropInfo cropInfo = (CropInfo) other;
            if (Intrinsics.areEqual(this.matrix, cropInfo.matrix) && this.ratioType == cropInfo.ratioType && Float.compare(this.rotateDegree, cropInfo.rotateDegree) == 0 && Intrinsics.areEqual(this.cropRect, cropInfo.cropRect) && this.isRotate90 == cropInfo.isRotate90 && this.isEmpty == cropInfo.isEmpty) {
                return true;
            }
            return false;
        }

        @NotNull
        public final RectF getCropRect() {
            return this.cropRect;
        }

        @NotNull
        public final Matrix getMatrix() {
            return this.matrix;
        }

        @NotNull
        public final WinkEditorCropRatioView.RatioType getRatioType() {
            return this.ratioType;
        }

        public final float getRotateDegree() {
            return this.rotateDegree;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((this.matrix.hashCode() * 31) + this.ratioType.hashCode()) * 31) + Float.floatToIntBits(this.rotateDegree)) * 31) + this.cropRect.hashCode()) * 31;
            boolean z16 = this.isRotate90;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.isEmpty;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i17 + i3;
        }

        public final boolean isEmpty() {
            return this.isEmpty;
        }

        public final boolean isRotate90() {
            return this.isRotate90;
        }

        @NotNull
        public String toString() {
            return "CropInfo(matrix=" + this.matrix + ", ratioType=" + this.ratioType + ", rotateDegree=" + this.rotateDegree + ", cropRect=" + this.cropRect + ", isRotate90=" + this.isRotate90 + ", isEmpty=" + this.isEmpty + ")";
        }

        public CropInfo(@NotNull Matrix matrix, @NotNull WinkEditorCropRatioView.RatioType ratioType, float f16, @NotNull RectF cropRect, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            Intrinsics.checkNotNullParameter(ratioType, "ratioType");
            Intrinsics.checkNotNullParameter(cropRect, "cropRect");
            this.matrix = matrix;
            this.ratioType = ratioType;
            this.rotateDegree = f16;
            this.cropRect = cropRect;
            this.isRotate90 = z16;
            this.isEmpty = z17;
        }

        public /* synthetic */ CropInfo(Matrix matrix, WinkEditorCropRatioView.RatioType ratioType, float f16, RectF rectF, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new Matrix() : matrix, (i3 & 2) != 0 ? WinkEditorCropRatioView.RatioType.FreeRatio : ratioType, (i3 & 4) != 0 ? 0.0f : f16, (i3 & 8) != 0 ? new RectF() : rectF, (i3 & 16) != 0 ? false : z16, (i3 & 32) != 0 ? true : z17);
        }
    }

    public WinkEditorCropViewModel() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._cropPageShowLiveData = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.cropPageShowLiveData = mutableLiveData;
        MutableLiveData<Pair<List<Pair<Matrix, RectF>>, Boolean>> mutableLiveData2 = new MutableLiveData<>();
        this._changedClipLiveData = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Pair<kotlin.collections.List<kotlin.Pair<android.graphics.Matrix, android.graphics.RectF>>, kotlin.Boolean>>");
        this.changedClipLiveData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._cropFragmentShowLiveData = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.cropFragmentShowLiveData = mutableLiveData3;
        this.storedCropInfo = new a(null, null, null, false, 15, null);
        this.storedCropInfoForClip = new a(null, null, null, false, 15, null);
        this.storedCLipData = new HashMap<>();
        this.storedCLipDataForClip = new HashMap<>();
    }

    private final Map<String, CropInfo> Q1(a aVar, boolean z16) {
        if (z16) {
            return aVar.a();
        }
        return aVar.c();
    }

    private final CropInfo S1(a aVar, boolean z16, String str) {
        return Q1(aVar, z16).get(str);
    }

    private final void c2(a aVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (String str : aVar.c().keySet()) {
            CropInfo cropInfo = aVar.c().get(str);
            Intrinsics.checkNotNull(cropInfo);
            linkedHashMap.put(str, CropInfo.copy$default(cropInfo, null, null, 0.0f, null, false, false, 63, null));
        }
        for (String str2 : aVar.a().keySet()) {
            CropInfo cropInfo2 = aVar.a().get(str2);
            Intrinsics.checkNotNull(cropInfo2);
            linkedHashMap2.put(str2, CropInfo.copy$default(cropInfo2, null, null, 0.0f, null, false, false, 63, null));
        }
        aVar.f(new a(linkedHashMap, linkedHashMap2, null, false, 12, null));
    }

    private final void g2(a aVar) {
        if (aVar.getLockedClipUIInfo() != null) {
            aVar.c().clear();
            Map<String, CropInfo> c16 = aVar.c();
            a lockedClipUIInfo = aVar.getLockedClipUIInfo();
            Intrinsics.checkNotNull(lockedClipUIInfo);
            c16.putAll(lockedClipUIInfo.c());
            aVar.a().clear();
            Map<String, CropInfo> a16 = aVar.a();
            a lockedClipUIInfo2 = aVar.getLockedClipUIInfo();
            Intrinsics.checkNotNull(lockedClipUIInfo2);
            a16.putAll(lockedClipUIInfo2.a());
            aVar.f(null);
        }
    }

    private final void p2(a aVar, boolean z16, String str, CropInfo cropInfo) {
        Q1(aVar, z16).put(str, cropInfo);
    }

    public final void L1() {
        if (this.storedCropInfoForClip.getIsLocked()) {
            this.storedCropInfoForClip.c().clear();
            this.storedCropInfoForClip.a().clear();
            this.storedCLipDataForClip.clear();
            this.storedCropInfoForClip.e(false);
        }
    }

    public final void M1() {
        this.storedCLipData.clear();
    }

    public final boolean N1(@NotNull List<? extends MediaClip> mediaClips, @NotNull List<? extends Pair<? extends Matrix, ? extends RectF>> clipDataList) {
        Object orNull;
        String str;
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        Intrinsics.checkNotNullParameter(clipDataList, "clipDataList");
        if (mediaClips.size() != clipDataList.size()) {
            return false;
        }
        int i3 = 0;
        for (Object obj : clipDataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            orNull = CollectionsKt___CollectionsKt.getOrNull(mediaClips, i3);
            MediaClip mediaClip = (MediaClip) orNull;
            if (mediaClip == null) {
                return false;
            }
            HashMap<String, Pair<Matrix, RectF>> hashMap = this.storedCLipData;
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null) {
                str = resourceModel.id;
            } else {
                str = null;
            }
            Pair<Matrix, RectF> pair2 = hashMap.get(str);
            if (pair2 != null) {
                Matrix matrix = (Matrix) pair.getFirst();
                Matrix first = pair2.getFirst();
                if (Math.abs(com.tencent.mobileqq.wink.editor.crop.a.b(matrix) - com.tencent.mobileqq.wink.editor.crop.a.b(first)) <= 0.1f && Math.abs(com.tencent.mobileqq.wink.editor.crop.a.c(matrix) - com.tencent.mobileqq.wink.editor.crop.a.c(first)) <= 0.01f && Math.abs(com.tencent.mobileqq.wink.editor.crop.a.f(matrix) - com.tencent.mobileqq.wink.editor.crop.a.f(first)) <= 0.1f && Math.abs(com.tencent.mobileqq.wink.editor.crop.a.g(matrix) - com.tencent.mobileqq.wink.editor.crop.a.g(first)) <= 0.1f) {
                    RectF rectF = (RectF) pair.getSecond();
                    RectF second = pair2.getSecond();
                    if (Math.abs(rectF.left - second.left) <= 2.0f && Math.abs(rectF.right - second.right) <= 2.0f && Math.abs(rectF.top - second.top) <= 2.0f && Math.abs(rectF.bottom - second.bottom) <= 2.0f) {
                        Unit unit = Unit.INSTANCE;
                    }
                }
                return false;
            }
            i3 = i16;
        }
        return true;
    }

    @NotNull
    public final LiveData<Pair<List<Pair<Matrix, RectF>>, Boolean>> O1() {
        return this.changedClipLiveData;
    }

    @NotNull
    public final LiveData<Boolean> P1() {
        return this.cropFragmentShowLiveData;
    }

    @NotNull
    public final List<MediaClip> R1(@NotNull List<? extends MediaClip> mediaClips) {
        int collectionSizeOrDefault;
        String str;
        ResourceModel resourceModel;
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        ResourceModel copy;
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        List<? extends MediaClip> list = mediaClips;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list) {
            HashMap<String, Pair<Matrix, RectF>> hashMap = this.storedCLipData;
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                str = resourceModel2.id;
            } else {
                str = null;
            }
            Pair<Matrix, RectF> pair = hashMap.get(str);
            if (pair != null) {
                Matrix first = pair.getFirst();
                RectF second = pair.getSecond();
                List<Float> a16 = com.tencent.mobileqq.wink.editor.crop.a.a(first);
                ResourceModel resourceModel3 = mediaClip.resource;
                if (resourceModel3 != null) {
                    roundToInt = MathKt__MathJVMKt.roundToInt(second.left);
                    roundToInt2 = MathKt__MathJVMKt.roundToInt(second.top);
                    roundToInt3 = MathKt__MathJVMKt.roundToInt(second.right);
                    roundToInt4 = MathKt__MathJVMKt.roundToInt(second.bottom);
                    copy = resourceModel3.copy((r35 & 1) != 0 ? resourceModel3.id : null, (r35 & 2) != 0 ? resourceModel3.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel3.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel3.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel3.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel3.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel3.selectDuration) : null, (r35 & 128) != 0 ? resourceModel3.type : null, (r35 & 256) != 0 ? resourceModel3.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel3.volume) : null, (r35 & 1024) != 0 ? resourceModel3.extras : null, (r35 & 2048) != 0 ? resourceModel3.picClipRect : new com.tencent.videocut.model.RectF(roundToInt, roundToInt2, roundToInt3, roundToInt4, null, 16, null), (r35 & 4096) != 0 ? resourceModel3.reversePath : null, (r35 & 8192) != 0 ? resourceModel3.normalPath : null, (r35 & 16384) != 0 ? resourceModel3.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel3.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel3.unknownFields() : null);
                    resourceModel = copy;
                } else {
                    resourceModel = null;
                }
                MediaClip copy$default = MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, a16, null, 94, null);
                if (copy$default != null) {
                    mediaClip = copy$default;
                }
            }
            arrayList.add(mediaClip);
        }
        return arrayList;
    }

    @Nullable
    public final CropInfo T1(boolean isImage, @Nullable MediaClip mediaClip) {
        ResourceModel resourceModel;
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null && resourceModel.path != null) {
            return S1(this.storedCropInfo, isImage, resourceModel.id);
        }
        return null;
    }

    public final void U1(@NotNull dr tavcut) {
        Intrinsics.checkNotNullParameter(tavcut, "tavcut");
        this.tavCutManager = tavcut;
    }

    public final void W1(@Nullable MediaClip mediaClip, boolean isDelay) {
        MediaClip mediaClip2;
        WinkVideoTavCut winkVideoTavCut;
        List<? extends MediaClip> listOf;
        List<? extends MediaClip> listOf2;
        List emptyList;
        ResourceModel resourceModel;
        dr drVar = null;
        if (mediaClip != null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : null, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
            } else {
                resourceModel = null;
            }
            mediaClip2 = MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, emptyList, null, 90, null);
        } else {
            mediaClip2 = null;
        }
        if (mediaClip2 != null) {
            dr drVar2 = this.tavCutManager;
            if (drVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tavCutManager");
                drVar2 = null;
            }
            if (drVar2 instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) drVar2;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut != null) {
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(mediaClip2);
                winkVideoTavCut.e0(listOf2);
                return;
            }
            dr drVar3 = this.tavCutManager;
            if (drVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tavCutManager");
            } else {
                drVar = drVar3;
            }
            listOf = CollectionsKt__CollectionsJVMKt.listOf(mediaClip2);
            drVar.e0(listOf);
        }
    }

    public final void X1(@NotNull WinkCropUIData uiDraft) {
        Intrinsics.checkNotNullParameter(uiDraft, "uiDraft");
        this.uiDraft = uiDraft;
    }

    /* renamed from: Z1, reason: from getter */
    public final boolean getIsChanged() {
        return this.isChanged;
    }

    public final boolean a2() {
        return AECameraPrefsUtil.c().b(AECameraPrefsUtil.f318472j, true, 0);
    }

    /* renamed from: b2, reason: from getter */
    public final boolean getIsFromClipping() {
        return this.isFromClipping;
    }

    public final void d2() {
        c2(this.storedCropInfo);
    }

    public final void e2() {
        this.storedCropInfoForClip.c().clear();
        this.storedCropInfoForClip.c().putAll(this.storedCropInfo.c());
        this.storedCropInfoForClip.a().clear();
        this.storedCropInfoForClip.a().putAll(this.storedCropInfo.a());
        this.storedCLipDataForClip.clear();
        this.storedCLipDataForClip.putAll(this.storedCLipData);
        this.storedCropInfoForClip.e(true);
    }

    public final void f2(@NotNull WinkCropUIData uiDraft) {
        Intrinsics.checkNotNullParameter(uiDraft, "uiDraft");
        this.storedCropInfo.a().clear();
        this.storedCropInfo.a().putAll(uiDraft.getCropInfoMap(true));
        this.storedCropInfo.c().putAll(uiDraft.getCropInfoMap(false));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkEditorCropViewModel";
    }

    public final void h2(boolean isImage, @NotNull List<? extends MediaClip> mediaClips) {
        String str;
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        Iterator<T> it = mediaClips.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = ((MediaClip) it.next()).resource;
            if (resourceModel != null && (str = resourceModel.id) != null && S1(this.storedCropInfo, isImage, str) == null) {
                String b16 = l63.a.b(str);
                b.a("wink_crop_WinkEditorCropViewModel", "restoreCropInfoFromParent, search parent id: " + str + " -> " + b16);
                if (b16 != null) {
                    CropInfo S1 = S1(this.storedCropInfo, isImage, b16);
                    if (S1 != null) {
                        b.a("wink_crop_WinkEditorCropViewModel", "restoreCropInfoFromParent, save parent info");
                        p2(this.storedCropInfo, isImage, str, CropInfo.copy$default(S1, null, null, 0.0f, null, false, false, 63, null));
                    } else {
                        b.a("wink_crop_WinkEditorCropViewModel", "restoreCropInfoFromParent, save empty info");
                        p2(this.storedCropInfo, isImage, str, new CropInfo(null, null, 0.0f, null, false, false, 63, null));
                    }
                }
            }
        }
    }

    public final void i2() {
        g2(this.storedCropInfo);
    }

    public final void j2() {
        if (this.storedCropInfoForClip.getIsLocked()) {
            this.storedCropInfo.f(new a(this.storedCropInfoForClip.c(), this.storedCropInfoForClip.a(), null, false, 12, null));
            g2(this.storedCropInfo);
            this.storedCLipData.clear();
            this.storedCLipData.putAll(this.storedCLipDataForClip);
            this.storedCLipDataForClip.clear();
            this.storedCropInfoForClip.e(false);
        }
    }

    public final void k2(boolean isChange) {
        this.isChanged = isChange;
    }

    public final void l2(boolean isCropShow) {
        this._cropFragmentShowLiveData.postValue(Boolean.valueOf(isCropShow));
    }

    public final void m2(boolean show) {
        this._cropPageShowLiveData.postValue(Boolean.valueOf(show));
    }

    public final void n2(boolean isFrom) {
        this.isFromClipping = isFrom;
    }

    public final void o2(boolean needShow) {
        AECameraPrefsUtil.c().h(AECameraPrefsUtil.f318472j, needShow, 0);
    }

    public final void q2(@NotNull MediaClip mediaClip, float angle, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(mediaClip, "mediaClip");
        Intrinsics.checkNotNullParameter(rect, "rect");
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null && resourceModel.path != null) {
            Matrix matrix = new Matrix();
            matrix.setRotate(angle);
            this.storedCLipData.put(mediaClip.resource.id, TuplesKt.to(matrix, rect));
        }
    }

    public final void r2(boolean isImage, @NotNull MediaClip mediaClip, @NotNull Matrix matrix, @NotNull WinkEditorCropRatioView.RatioType ratioType, float rotateDegree, @NotNull RectF cropRect, boolean isRotate90, float angle, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(mediaClip, "mediaClip");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(ratioType, "ratioType");
        Intrinsics.checkNotNullParameter(cropRect, "cropRect");
        Intrinsics.checkNotNullParameter(rect, "rect");
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null && resourceModel.path != null) {
            CropInfo cropInfo = new CropInfo(new Matrix(matrix), ratioType, rotateDegree, cropRect, isRotate90, false);
            p2(this.storedCropInfo, isImage, mediaClip.resource.id, cropInfo);
            Matrix matrix2 = new Matrix();
            matrix2.setRotate(angle);
            this.storedCLipData.put(mediaClip.resource.id, TuplesKt.to(matrix2, rect));
            WinkCropUIData winkCropUIData = this.uiDraft;
            if (winkCropUIData != null) {
                winkCropUIData.storeCropInfo(isImage, mediaClip.resource.id, CropInfo.copy$default(cropInfo, null, null, 0.0f, null, false, false, 63, null));
            }
        }
    }

    public final void s2(@NotNull List<? extends MediaClip> mediaClips, boolean isFromClipping) {
        int collectionSizeOrDefault;
        String str;
        ResourceModel resourceModel;
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        List<? extends MediaClip> list = mediaClips;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MediaClip mediaClip : list) {
            HashMap<String, Pair<Matrix, RectF>> hashMap = this.storedCLipData;
            if (mediaClip != null && (resourceModel = mediaClip.resource) != null) {
                str = resourceModel.id;
            } else {
                str = null;
            }
            arrayList.add(hashMap.get(str));
        }
        this._changedClipLiveData.postValue(new Pair<>(arrayList, Boolean.valueOf(isFromClipping)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001BI\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u0005\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\n\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel$a;", "", "", "", "Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel$CropInfo;", "a", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "videoCropInfoByID", "b", "imageCropInfoByID", "Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel$a;", "()Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel$a;", "f", "(Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel$a;)V", "lockedClipUIInfo", "", "d", "Z", "()Z", "e", "(Z)V", "isLocked", "<init>", "(Ljava/util/Map;Ljava/util/Map;Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel$a;Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, CropInfo> videoCropInfoByID;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, CropInfo> imageCropInfoByID;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private a lockedClipUIInfo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isLocked;

        public a(@NotNull Map<String, CropInfo> videoCropInfoByID, @NotNull Map<String, CropInfo> imageCropInfoByID, @Nullable a aVar, boolean z16) {
            Intrinsics.checkNotNullParameter(videoCropInfoByID, "videoCropInfoByID");
            Intrinsics.checkNotNullParameter(imageCropInfoByID, "imageCropInfoByID");
            this.videoCropInfoByID = videoCropInfoByID;
            this.imageCropInfoByID = imageCropInfoByID;
            this.lockedClipUIInfo = aVar;
            this.isLocked = z16;
        }

        @NotNull
        public final Map<String, CropInfo> a() {
            return this.imageCropInfoByID;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final a getLockedClipUIInfo() {
            return this.lockedClipUIInfo;
        }

        @NotNull
        public final Map<String, CropInfo> c() {
            return this.videoCropInfoByID;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsLocked() {
            return this.isLocked;
        }

        public final void e(boolean z16) {
            this.isLocked = z16;
        }

        public final void f(@Nullable a aVar) {
            this.lockedClipUIInfo = aVar;
        }

        public /* synthetic */ a(Map map, Map map2, a aVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new LinkedHashMap() : map, (i3 & 2) != 0 ? new LinkedHashMap() : map2, (i3 & 4) != 0 ? null : aVar, (i3 & 8) != 0 ? false : z16);
        }
    }
}
