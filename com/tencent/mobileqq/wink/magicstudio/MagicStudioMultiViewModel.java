package com.tencent.mobileqq.wink.magicstudio;

import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.gyailib.library.FaceDetectorFeature;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.ak;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgInfo;
import com.tencent.mobileqq.wink.magicstudio.model.State;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0080\u00012\u00020\u0001:\u0004\u0081\u0001\u0082\u0001B\u0007\u00a2\u0006\u0004\b~\u0010\u007fJ#\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0014\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0007J\u0016\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bJ\u001a\u0010\"\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 J\u001e\u0010&\u001a\u00020\u000e2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\t0#j\b\u0012\u0004\u0012\u00020\t`$J\b\u0010'\u001a\u00020\u000eH\u0014R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020-018\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R(\u00109\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001b070,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010/R+\u0010<\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001b07018\u0006\u00a2\u0006\f\n\u0004\b:\u00103\u001a\u0004\b;\u00105R\"\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R.\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010?\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\f0=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010?R(\u0010L\u001a\b\u0012\u0004\u0012\u00020\f0=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010?\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010ER*\u0010N\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002070=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010?R6\u0010R\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002070=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010?\u001a\u0004\bP\u0010C\"\u0004\bQ\u0010ER\"\u0010Y\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010]\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010T\u001a\u0004\b[\u0010V\"\u0004\b\\\u0010XR\"\u0010_\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010T\u001a\u0004\b_\u0010V\"\u0004\b`\u0010XR$\u0010h\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR$\u0010o\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010s\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010j\u001a\u0004\bq\u0010l\"\u0004\br\u0010nR\"\u0010y\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010I\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\"\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel;", "Landroidx/lifecycle/ViewModel;", "", "imagePath", "ratio", "S1", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "index", "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "generateInfo", "Lkotlinx/coroutines/flow/Flow;", "", "j2", "", "g2", "Lcom/tencent/mobileqq/wink/magicstudio/model/d;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "y2", "", "generates", "o2", com.tencent.luggage.wxa.c8.c.G, "l2", "i2", "scene", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "buttonINfo", "x2", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "magicStudioStyle", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "originImage", "m2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "generateInfoList", "p2", "onCleared", "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_event", "Lkotlinx/coroutines/flow/SharedFlow;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/SharedFlow;", "X1", "()Lkotlinx/coroutines/flow/SharedFlow;", "event", "Lkotlin/Pair;", "D", "_buttonInfo", "E", "U1", "buttonInfo", "Landroidx/lifecycle/MutableLiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "_allAigcFlow", "G", "T1", "()Landroidx/lifecycle/MutableLiveData;", "setAllAigcFlow", "(Landroidx/lifecycle/MutableLiveData;)V", "allAigcFlow", "H", "_saveImageResult", "I", "d2", "setSaveImageResult", "saveImageResult", "J", "_updateLoadingViewRatio", "K", "f2", "setUpdateLoadingViewRatio", "updateLoadingViewRatio", "L", "Z", "c2", "()Z", "t2", "(Z)V", "picMode", "M", SemanticAttributes.DbSystemValues.H2, "v2", "isSupportMultiSelected", "N", "isVertical", "w2", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "P", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "W1", "()Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "q2", "(Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;)V", "currentImg", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "e2", "()Ljava/lang/String;", "u2", "(Ljava/lang/String;)V", "styleId", BdhLogUtil.LogTag.Tag_Req, "b2", ICustomDataEditor.STRING_PARAM_2, DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, ExifInterface.LATITUDE_SOUTH, "Z1", "()I", "r2", "(I)V", "generateLoadStatus", "Landroidx/lifecycle/Observer;", "T", "Landroidx/lifecycle/Observer;", "observer", "<init>", "()V", "U", "a", "b", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicStudioMultiViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<b> event;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<Pair<Integer, MagicStudioButtonInfo>> _buttonInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<Pair<Integer, MagicStudioButtonInfo>> buttonInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<List<GenerateInfo>> _allAigcFlow;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<List<GenerateInfo>> allAigcFlow;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> _saveImageResult;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> saveImageResult;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<String, String>> _updateLoadingViewRatio;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<String, String>> updateLoadingViewRatio;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean picMode;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isSupportMultiSelected;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isVertical;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private MagicStudioUploadImgInfo currentImg;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private String styleId;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private String materialId;

    /* renamed from: S, reason: from kotlin metadata */
    private int generateLoadStatus;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private Observer<List<GenerateInfo>> observer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<b> _event;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel$b;", "", "<init>", "()V", "a", "b", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel$b$a;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel$b$b;", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static abstract class b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel$b$a;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "Ljava/util/List;", "()Ljava/util/List;", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "<init>", "(Ljava/util/List;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel$b$a, reason: from toString */
        /* loaded from: classes21.dex */
        public static final /* data */ class GotoOutputRouter extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final List<LocalMediaInfo> localMediaInfos;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public GotoOutputRouter(@NotNull List<? extends LocalMediaInfo> localMediaInfos) {
                super(null);
                Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
                this.localMediaInfos = localMediaInfos;
            }

            @NotNull
            public final List<LocalMediaInfo> a() {
                return this.localMediaInfos;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if ((other instanceof GotoOutputRouter) && Intrinsics.areEqual(this.localMediaInfos, ((GotoOutputRouter) other).localMediaInfos)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return this.localMediaInfos.hashCode();
            }

            @NotNull
            public String toString() {
                return "GotoOutputRouter(localMediaInfos=" + this.localMediaInfos + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel$b$b;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "show", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel$b$b, reason: collision with other inner class name and from toString */
        /* loaded from: classes21.dex */
        public static final /* data */ class ProgressLoading extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final boolean show;

            /* renamed from: a, reason: from getter */
            public final boolean getShow() {
                return this.show;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if ((other instanceof ProgressLoading) && this.show == ((ProgressLoading) other).show) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                boolean z16 = this.show;
                if (z16) {
                    return 1;
                }
                return z16 ? 1 : 0;
            }

            @NotNull
            public String toString() {
                return "ProgressLoading(show=" + this.show + ")";
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        b() {
        }
    }

    public MagicStudioMultiViewModel() {
        MutableSharedFlow<b> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._event = MutableSharedFlow$default;
        this.event = MutableSharedFlow$default;
        MutableSharedFlow<Pair<Integer, MagicStudioButtonInfo>> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._buttonInfo = MutableSharedFlow$default2;
        this.buttonInfo = MutableSharedFlow$default2;
        MutableLiveData<List<GenerateInfo>> mutableLiveData = new MutableLiveData<>();
        this._allAigcFlow = mutableLiveData;
        this.allAigcFlow = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._saveImageResult = mutableLiveData2;
        this.saveImageResult = mutableLiveData2;
        MutableLiveData<Pair<String, String>> mutableLiveData3 = new MutableLiveData<>();
        this._updateLoadingViewRatio = mutableLiveData3;
        this.updateLoadingViewRatio = mutableLiveData3;
        this.isVertical = true;
        this.generateLoadStatus = 1;
        this.observer = new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MagicStudioMultiViewModel.k2(MagicStudioMultiViewModel.this, (List) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object S1(String str, String str2, Continuation<? super String> continuation) {
        MagicStudioMultiViewModel$cropFaceRegion$1 magicStudioMultiViewModel$cropFaceRegion$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        Object obj2;
        List split$default;
        int max;
        Pair pair;
        if (continuation instanceof MagicStudioMultiViewModel$cropFaceRegion$1) {
            magicStudioMultiViewModel$cropFaceRegion$1 = (MagicStudioMultiViewModel$cropFaceRegion$1) continuation;
            int i16 = magicStudioMultiViewModel$cropFaceRegion$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                magicStudioMultiViewModel$cropFaceRegion$1.label = i16 - Integer.MIN_VALUE;
                MagicStudioMultiViewModel$cropFaceRegion$1 magicStudioMultiViewModel$cropFaceRegion$12 = magicStudioMultiViewModel$cropFaceRegion$1;
                obj = magicStudioMultiViewModel$cropFaceRegion$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = magicStudioMultiViewModel$cropFaceRegion$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        str2 = (String) magicStudioMultiViewModel$cropFaceRegion$12.L$1;
                        str = (String) magicStudioMultiViewModel$cropFaceRegion$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    WinkEditorResourceManager a16 = WinkEditorResourceManager.a1();
                    Intrinsics.checkNotNullExpressionValue(a16, "getInstance()");
                    magicStudioMultiViewModel$cropFaceRegion$12.L$0 = str;
                    magicStudioMultiViewModel$cropFaceRegion$12.L$1 = str2;
                    magicStudioMultiViewModel$cropFaceRegion$12.label = 1;
                    obj = ak.h(a16, "FACE_AGENT", null, magicStudioMultiViewModel$cropFaceRegion$12, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                String str3 = str2;
                if (((Boolean) obj).booleanValue()) {
                    w53.b.c("MagicStudioMultiViewModel", "cropFaceRegion bundle fetch failed");
                    return str;
                }
                String N = MagicStudioDataSource.f323652a.N(str);
                if (N == null) {
                    N = "";
                }
                Bitmap c16 = com.tencent.mobileqq.wink.utils.f.c(N);
                if (c16 == null) {
                    return str;
                }
                List<FaceDetectorFeature> a17 = com.tencent.mobileqq.wink.utils.j.f326712a.a(c16);
                List<FaceDetectorFeature> list = a17;
                int i17 = 0;
                if (list != null && !list.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    w53.b.c("MagicStudioMultiViewModel", "cropFaceRegion defect no face");
                    return N;
                }
                Iterator<T> it = a17.iterator();
                if (!it.hasNext()) {
                    obj2 = null;
                } else {
                    Object next = it.next();
                    if (it.hasNext()) {
                        FaceDetectorFeature faceDetectorFeature = (FaceDetectorFeature) next;
                        int i18 = faceDetectorFeature.boundsW * faceDetectorFeature.boundsH;
                        do {
                            Object next2 = it.next();
                            FaceDetectorFeature faceDetectorFeature2 = (FaceDetectorFeature) next2;
                            int i19 = faceDetectorFeature2.boundsW * faceDetectorFeature2.boundsH;
                            if (i18 < i19) {
                                next = next2;
                                i18 = i19;
                            }
                        } while (it.hasNext());
                    }
                    obj2 = next;
                }
                if (((FaceDetectorFeature) obj2) != null) {
                    split$default = StringsKt__StringsKt.split$default((CharSequence) str3, new String[]{":"}, false, 0, 6, (Object) null);
                    float parseFloat = Float.parseFloat((String) split$default.get(0)) / Float.parseFloat((String) split$default.get(1));
                    int width = c16.getWidth();
                    int height = c16.getHeight();
                    float f16 = width;
                    float f17 = height;
                    if (f16 / f17 > parseFloat) {
                        float f18 = f17 * parseFloat;
                        int max2 = Math.max(0, (int) Math.min((r12.boundsX + (r12.boundsW / 2)) - (f18 / 2), f16 - f18));
                        pair = new Pair(Boxing.boxFloat(f18), Boxing.boxInt(height));
                        i17 = max2;
                        max = 0;
                    } else {
                        float f19 = f16 / parseFloat;
                        max = Math.max(0, (int) Math.min((r12.boundsY + (r12.boundsH / 2)) - (f19 / 2), f17 - f19));
                        pair = new Pair(Boxing.boxInt(width), Boxing.boxFloat(f19));
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(c16, i17, max, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).intValue());
                    String str4 = MagicStudioDataSource.f323652a.L() + System.nanoTime() + ".jpg";
                    com.tencent.mobileqq.wink.utils.f.t(str4, createBitmap);
                    createBitmap.recycle();
                    return str4;
                }
                w53.b.c("MagicStudioMultiViewModel", "cropFaceRegion defect no face");
                return N;
            }
        }
        magicStudioMultiViewModel$cropFaceRegion$1 = new MagicStudioMultiViewModel$cropFaceRegion$1(this, continuation);
        MagicStudioMultiViewModel$cropFaceRegion$1 magicStudioMultiViewModel$cropFaceRegion$122 = magicStudioMultiViewModel$cropFaceRegion$1;
        obj = magicStudioMultiViewModel$cropFaceRegion$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = magicStudioMultiViewModel$cropFaceRegion$122.label;
        if (i3 == 0) {
        }
        String str32 = str2;
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<Boolean> j2(int index, GenerateInfo generateInfo) {
        return FlowKt.flowOn(FlowKt.cancellable(FlowKt.flow(new MagicStudioMultiViewModel$makeSaveFlow$1(generateInfo, index, null))), WinkCoroutineScopes.f317652a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(MagicStudioMultiViewModel this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._allAigcFlow.setValue(list);
        this$0.y2();
    }

    @NotNull
    public final MutableLiveData<List<GenerateInfo>> T1() {
        return this.allAigcFlow;
    }

    @NotNull
    public final SharedFlow<Pair<Integer, MagicStudioButtonInfo>> U1() {
        return this.buttonInfo;
    }

    @Nullable
    /* renamed from: W1, reason: from getter */
    public final MagicStudioUploadImgInfo getCurrentImg() {
        return this.currentImg;
    }

    @NotNull
    public final SharedFlow<b> X1() {
        return this.event;
    }

    /* renamed from: Z1, reason: from getter */
    public final int getGenerateLoadStatus() {
        return this.generateLoadStatus;
    }

    @Nullable
    public final JumpInfo a2() {
        return MagicStudioDataSource.f323652a.Q();
    }

    @Nullable
    /* renamed from: b2, reason: from getter */
    public final String getMaterialId() {
        return this.materialId;
    }

    /* renamed from: c2, reason: from getter */
    public final boolean getPicMode() {
        return this.picMode;
    }

    @NotNull
    public final MutableLiveData<Boolean> d2() {
        return this.saveImageResult;
    }

    @Nullable
    /* renamed from: e2, reason: from getter */
    public final String getStyleId() {
        return this.styleId;
    }

    @NotNull
    public final MutableLiveData<Pair<String, String>> f2() {
        return this.updateLoadingViewRatio;
    }

    public final void g2() {
        MagicStudioDataSource.f323652a.G().observeForever(this.observer);
    }

    /* renamed from: h2, reason: from getter */
    public final boolean getIsSupportMultiSelected() {
        return this.isSupportMultiSelected;
    }

    public final void i2() {
        GenerateInfo generateInfo;
        Object obj;
        boolean z16;
        List<GenerateInfo> value = this.allAigcFlow.getValue();
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((GenerateInfo) obj).getState() == State.Loading) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            generateInfo = (GenerateInfo) obj;
        } else {
            generateInfo = null;
        }
        if (generateInfo != null) {
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_MAGIC_GALLERY_SELECT_TO_COMPLETE_FRAME);
        }
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioMultiViewModel$jumpOutputRouter$2(this, null), 3, null);
    }

    public final void l2(int pos) {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioMultiViewModel$onImgClicked$1(this, pos, null), 3, null);
    }

    public final void m2(@Nullable MagicStudioPicStyle magicStudioStyle, @Nullable LocalMediaInfo originImage) {
        boolean z16;
        if (magicStudioStyle != null && originImage != null) {
            String str = originImage.path;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new MagicStudioMultiViewModel$parseOriginImage$1(magicStudioStyle, this, originImage, null), 3, null);
            }
        }
    }

    public final void n2(int scene) {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioMultiViewModel$requestButtonInfo$1(scene, this, null), 3, null);
    }

    public final void o2(@NotNull List<GenerateInfo> generates) {
        Intrinsics.checkNotNullParameter(generates, "generates");
        if (m83.a.f416440a.e()) {
            MagicStudioUploadImgInfo magicStudioUploadImgInfo = this.currentImg;
            boolean z16 = false;
            if (magicStudioUploadImgInfo != null && !magicStudioUploadImgInfo.getIsFromCamera()) {
                z16 = true;
            }
            if (z16) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new MagicStudioMultiViewModel$saveAIGCHistory$1(generates, this, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        MagicStudioDataSource.f323652a.G().removeObserver(this.observer);
        CoroutineScopeKt.cancel$default(this.viewModelScope, null, 1, null);
    }

    public final void p2(@NotNull ArrayList<GenerateInfo> generateInfoList) {
        Intrinsics.checkNotNullParameter(generateInfoList, "generateInfoList");
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioMultiViewModel$saveImageFile$1(generateInfoList, this, null), 3, null);
    }

    public final void q2(@Nullable MagicStudioUploadImgInfo magicStudioUploadImgInfo) {
        this.currentImg = magicStudioUploadImgInfo;
    }

    public final void r2(int i3) {
        this.generateLoadStatus = i3;
    }

    public final void s2(@Nullable String str) {
        this.materialId = str;
    }

    public final void t2(boolean z16) {
        this.picMode = z16;
    }

    public final void u2(@Nullable String str) {
        this.styleId = str;
    }

    public final void v2(boolean z16) {
        this.isSupportMultiSelected = z16;
    }

    public final void w2(boolean z16) {
        this.isVertical = z16;
    }

    public final void x2(int scene, @NotNull MagicStudioButtonInfo buttonINfo) {
        Intrinsics.checkNotNullParameter(buttonINfo, "buttonINfo");
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicStudioMultiViewModel$updateButtonInfo$1(this, scene, buttonINfo, null), 3, null);
    }

    public final void y2() {
        ArrayList<GenerateInfo> c16;
        List<GenerateInfo> value = this.allAigcFlow.getValue();
        if (value == null) {
            return;
        }
        o2(value);
        JumpInfo Q = MagicStudioDataSource.f323652a.Q();
        if (Q != null && (c16 = Q.c()) != null) {
            c16.clear();
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (((GenerateInfo) obj).getIsSelected()) {
                    arrayList.add(obj);
                }
            }
            c16.addAll(arrayList);
        }
    }
}
