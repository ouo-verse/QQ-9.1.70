package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.magicAvatar.model.AvatarCountInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.ClipBitmapInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarDataSource;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarGenerateInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarPicAndStyles;
import com.tencent.mobileqq.wink.magicAvatar.model.f;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.a;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.ttpic.openapi.filter.LightConstants;
import i83.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bF\u0018\u0000 \u009e\u00012\u00020\u0001:\u0002\u009f\u0001B\t\u00a2\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0013\u0010\t\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J4\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u001b\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001b\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001dJ#\u0010\u001f\u001a\u00020\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\u001b\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$J\u001a\u0010(\u001a\u00020!2\u0006\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010%H\u0002J\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010*\u001a\u00020\u0007J\u0010\u0010-\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010+J\u000e\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020.J\u0006\u00101\u001a\u00020\u0007J\u0006\u00102\u001a\u00020\u0007J\u0018\u00106\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00152\b\u00105\u001a\u0004\u0018\u000104J\u0006\u00107\u001a\u00020\u0007J\u0006\u00108\u001a\u00020\u0015J\u0006\u00109\u001a\u00020\u0007J\u0006\u0010:\u001a\u00020\u0007J\u000e\u0010;\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010<\u001a\u00020!J\u0006\u0010=\u001a\u00020\u0007J\u000e\u0010?\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0013R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001c\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E0D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u001f\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E0I8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020O0D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010GR\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020O0I8\u0006\u00a2\u0006\f\n\u0004\bR\u0010K\u001a\u0004\bS\u0010MR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u001d\u0010_\u001a\b\u0012\u0004\u0012\u00020V0Z8\u0006\u00a2\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R$\u0010f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u001a\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010hR\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020!0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010XR\u001d\u0010p\u001a\b\u0012\u0004\u0012\u00020!0Z8\u0006\u00a2\u0006\f\n\u0004\bn\u0010\\\u001a\u0004\bo\u0010^R\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00070U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010XR\u001d\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00070Z8\u0006\u00a2\u0006\f\n\u0004\bs\u0010\\\u001a\u0004\bt\u0010^R\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020!0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010XR\u001d\u0010z\u001a\b\u0012\u0004\u0012\u00020!0Z8\u0006\u00a2\u0006\f\n\u0004\bx\u0010\\\u001a\u0004\by\u0010^R\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020!0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010XR\u001d\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020!0Z8\u0006\u00a2\u0006\f\n\u0004\b}\u0010\\\u001a\u0004\b~\u0010^R(\u0010\u0085\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0080\u0001\u0010g\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0088\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R)\u0010\u008f\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R)\u0010\u0091\u0001\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0087\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R5\u0010\u009b\u0001\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+8\u0006@FX\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00a0\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;", "t2", "T2", "styles", "", "L2", "U2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "list", "l2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "oldList", "", "newList", "u2", "", com.tencent.luggage.wxa.c8.c.G, "", "hasGenerate", "R2", "S2", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "J2", "curr", "v2", "(Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e3", "P2", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/f;", "state", "f3", "(Lcom/tencent/mobileqq/wink/magicAvatar/model/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/a;", "info", "vipInfo", ICustomDataEditor.NUMBER_PARAM_2, "m2", "Y2", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;", "value", "M2", "", "path", "N2", "V2", "q2", "isPreview", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "x2", "w2", "p2", "O2", "o2", ICustomDataEditor.STRING_PARAM_2, "z2", "r2", "avatarSource", "K2", "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/MutableStateFlow;", "_generateEvent", "Lkotlinx/coroutines/flow/StateFlow;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/StateFlow;", "C2", "()Lkotlinx/coroutines/flow/StateFlow;", "generateEvent", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/f;", "D", "_styleList", "E", "H2", "styleList", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/ClipBitmapInfo;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_getClipPath", "Lkotlinx/coroutines/flow/SharedFlow;", "G", "Lkotlinx/coroutines/flow/SharedFlow;", Constants.BASE_IN_PLUGIN_VERSION, "()Lkotlinx/coroutines/flow/SharedFlow;", "getClipPath", "H", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;", NowProxyConstants.AccountInfoKey.A2, "()Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;", ICustomDataEditor.STRING_ARRAY_PARAM_3, "(Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;)V", "currentSelectMaterial", "I", "Ljava/util/List;", "femaleList", "J", "maleList", "K", "_buttonState", "L", "y2", "buttonState", "M", "_refreshButtonState", "N", "F2", "refreshButtonState", "P", "_textCountState", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I2", "textCountState", BdhLogUtil.LogTag.Tag_Req, "_styleFragmentButtonState", ExifInterface.LATITUDE_SOUTH, Constants.MMCCID, "styleFragmentButtonState", "T", "B2", "()I", "setFrom", "(I)V", "from", "U", "Z", "hasInitCountSuccess", "V", "Lcom/tencent/mobileqq/wink/magicAvatar/model/f;", "getLastUserCountState", "()Lcom/tencent/mobileqq/wink/magicAvatar/model/f;", "d3", "(Lcom/tencent/mobileqq/wink/magicAvatar/model/f;)V", "lastUserCountState", "W", "isInLoading", "()Z", "b3", "(Z)V", "X", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;", "E2", "()Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;", "c3", "(Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;)V", "infoFromPicker", "<init>", "()V", "Y", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarCropViewModel extends ViewModel {

    @Nullable
    private static volatile AvatarCountInfo Z;

    /* renamed from: a0, reason: collision with root package name */
    @Nullable
    private static volatile AvatarCountInfo f323590a0;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final StateFlow<a> generateEvent;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<StylesEvent> _styleList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final StateFlow<StylesEvent> styleList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<ClipBitmapInfo> _getClipPath;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<ClipBitmapInfo> getClipPath;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private MagicAvatarMaterialInfo currentSelectMaterial;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final List<MagicAvatarMaterialInfo> femaleList;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final List<MagicAvatarMaterialInfo> maleList;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> _buttonState;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> buttonState;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<Unit> _refreshButtonState;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<Unit> refreshButtonState;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> _textCountState;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> textCountState;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> _styleFragmentButtonState;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> styleFragmentButtonState;

    /* renamed from: T, reason: from kotlin metadata */
    private int from;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean hasInitCountSuccess;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.wink.magicAvatar.model.f lastUserCountState;

    /* renamed from: W, reason: from kotlin metadata */
    private volatile boolean isInLoading;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private MagicAvatarGenerateInfo infoFromPicker;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableStateFlow<a> _generateEvent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel$b", "Li83/g;", "", "onSuccess", "onFailed", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements g {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c() {
            QQToast.makeText(MobileQQ.sMobileQQ, "\u4fdd\u5b58\u5931\u8d25\uff0c\u7a0d\u540e\u518d\u8bd5", 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d() {
            QQToast.makeText(MobileQQ.sMobileQQ, "\u56fe\u7247\u5df2\u4fdd\u5b58", 0).show();
        }

        @Override // i83.g
        public void onFailed() {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicAvatar.viewmodel.c
                @Override // java.lang.Runnable
                public final void run() {
                    MagicAvatarCropViewModel.b.c();
                }
            });
        }

        @Override // i83.g
        public void onSuccess() {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicAvatar.viewmodel.d
                @Override // java.lang.Runnable
                public final void run() {
                    MagicAvatarCropViewModel.b.d();
                }
            });
        }
    }

    public MagicAvatarCropViewModel() {
        List emptyList;
        MutableStateFlow<a> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._generateEvent = MutableStateFlow;
        this.generateEvent = MutableStateFlow;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MutableStateFlow<StylesEvent> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new StylesEvent(emptyList));
        this._styleList = MutableStateFlow2;
        this.styleList = MutableStateFlow2;
        MutableSharedFlow<ClipBitmapInfo> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._getClipPath = MutableSharedFlow$default;
        this.getClipPath = MutableSharedFlow$default;
        this.femaleList = new ArrayList();
        this.maleList = new ArrayList();
        MutableSharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._buttonState = MutableSharedFlow$default2;
        this.buttonState = MutableSharedFlow$default2;
        MutableSharedFlow<Unit> MutableSharedFlow$default3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._refreshButtonState = MutableSharedFlow$default3;
        this.refreshButtonState = MutableSharedFlow$default3;
        MutableSharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> MutableSharedFlow$default4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._textCountState = MutableSharedFlow$default4;
        this.textCountState = MutableSharedFlow$default4;
        MutableSharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> MutableSharedFlow$default5 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._styleFragmentButtonState = MutableSharedFlow$default5;
        this.styleFragmentButtonState = MutableSharedFlow$default5;
        this.lastUserCountState = f.d.f323523a;
        this.isInLoading = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean J2(int pos) {
        Object orNull;
        boolean z16;
        orNull = CollectionsKt___CollectionsKt.getOrNull(t2(), pos);
        MagicAvatarMaterialInfo magicAvatarMaterialInfo = (MagicAvatarMaterialInfo) orNull;
        if (magicAvatarMaterialInfo == null || magicAvatarMaterialInfo.getType() != 0) {
            return false;
        }
        if (magicAvatarMaterialInfo.getLocalPicPath().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    private final void L2(List<MagicAvatarMaterialInfo> styles) {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarCropViewModel$initStyles$1(this, styles, null), 3, null);
    }

    private final Object P2(List<MagicAvatarMaterialInfo> list, Continuation<? super Unit> continuation) {
        int collectionSizeOrDefault;
        Object coroutine_suspended;
        List<MagicAvatarMaterialInfo> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((MagicAvatarMaterialInfo) it.next()).copy());
        }
        Object emit = this._styleList.emit(new StylesEvent(arrayList), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (emit == coroutine_suspended) {
            return emit;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object Q2(MagicAvatarCropViewModel magicAvatarCropViewModel, List list, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = magicAvatarCropViewModel.t2();
        }
        return magicAvatarCropViewModel.P2(list, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R2(int pos, boolean hasGenerate) {
        if (!p2()) {
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarCropViewModel$onStyleClicked$1(this, pos, hasGenerate, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object S2(int i3, Continuation<? super Unit> continuation) {
        Object orNull;
        Object coroutine_suspended;
        orNull = CollectionsKt___CollectionsKt.getOrNull(t2(), i3);
        MagicAvatarMaterialInfo magicAvatarMaterialInfo = (MagicAvatarMaterialInfo) orNull;
        if (magicAvatarMaterialInfo == null) {
            return Unit.INSTANCE;
        }
        if (magicAvatarMaterialInfo.getType() == 0) {
            this.currentSelectMaterial = magicAvatarMaterialInfo;
            Object e36 = e3(magicAvatarMaterialInfo, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (e36 == coroutine_suspended) {
                return e36;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final List<MagicAvatarMaterialInfo> T2() {
        if (M2(this.infoFromPicker)) {
            return this.maleList;
        }
        return this.femaleList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object U2(Continuation<? super Unit> continuation) {
        MagicAvatarCropViewModel$requestMoreStyles$1 magicAvatarCropViewModel$requestMoreStyles$1;
        Object coroutine_suspended;
        int i3;
        MagicAvatarCropViewModel magicAvatarCropViewModel;
        List emptyList;
        if (continuation instanceof MagicAvatarCropViewModel$requestMoreStyles$1) {
            magicAvatarCropViewModel$requestMoreStyles$1 = (MagicAvatarCropViewModel$requestMoreStyles$1) continuation;
            int i16 = magicAvatarCropViewModel$requestMoreStyles$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                magicAvatarCropViewModel$requestMoreStyles$1.label = i16 - Integer.MIN_VALUE;
                Object obj = magicAvatarCropViewModel$requestMoreStyles$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = magicAvatarCropViewModel$requestMoreStyles$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    ResultKt.throwOnFailure(obj);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        magicAvatarCropViewModel = (MagicAvatarCropViewModel) magicAvatarCropViewModel$requestMoreStyles$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        MagicAvatarPicAndStyles magicAvatarPicAndStyles = (MagicAvatarPicAndStyles) obj;
                        if (!magicAvatarCropViewModel.t2().isEmpty()) {
                            ArrayList<MagicAvatarMaterialInfo> materials = magicAvatarPicAndStyles.getMaterials();
                            if (materials != null) {
                                magicAvatarCropViewModel.l2(materials);
                                Boxing.boxBoolean(magicAvatarCropViewModel.t2().addAll(materials));
                            }
                            magicAvatarCropViewModel$requestMoreStyles$1.L$0 = null;
                            magicAvatarCropViewModel$requestMoreStyles$1.label = 3;
                            if (Q2(magicAvatarCropViewModel, null, magicAvatarCropViewModel$requestMoreStyles$1, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        ArrayList<MagicAvatarMaterialInfo> arrayList = new ArrayList<>(magicAvatarCropViewModel.t2());
                        CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                        List<MagicAvatarMaterialInfo> materials2 = magicAvatarPicAndStyles.getMaterials();
                        if (materials2 == null) {
                            materials2 = CollectionsKt__CollectionsKt.emptyList();
                        }
                        List<MagicAvatarMaterialInfo> u26 = magicAvatarCropViewModel.u2(arrayList, materials2);
                        magicAvatarCropViewModel.l2(u26);
                        magicAvatarCropViewModel.t2().clear();
                        magicAvatarCropViewModel.t2().addAll(u26);
                        magicAvatarCropViewModel$requestMoreStyles$1.L$0 = null;
                        magicAvatarCropViewModel$requestMoreStyles$1.label = 4;
                        if (Q2(magicAvatarCropViewModel, null, magicAvatarCropViewModel$requestMoreStyles$1, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                MagicAvatarGenerateInfo magicAvatarGenerateInfo = this.infoFromPicker;
                if (magicAvatarGenerateInfo == null) {
                    w53.b.f("MagicAvatarCropViewModel", "requestMoreStyles infoFromPicker == null ");
                    MutableStateFlow<StylesEvent> mutableStateFlow = this._styleList;
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    StylesEvent stylesEvent = new StylesEvent(emptyList);
                    magicAvatarCropViewModel$requestMoreStyles$1.label = 1;
                    if (mutableStateFlow.emit(stylesEvent, magicAvatarCropViewModel$requestMoreStyles$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                MagicAvatarDataSource magicAvatarDataSource = MagicAvatarDataSource.f323499a;
                String gender = magicAvatarGenerateInfo.getGender();
                boolean glass = magicAvatarGenerateInfo.getGlass();
                String originStyleName = magicAvatarGenerateInfo.getOriginStyleName();
                magicAvatarCropViewModel$requestMoreStyles$1.L$0 = this;
                magicAvatarCropViewModel$requestMoreStyles$1.label = 2;
                obj = magicAvatarDataSource.t(gender, glass, originStyleName, magicAvatarCropViewModel$requestMoreStyles$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                magicAvatarCropViewModel = this;
                MagicAvatarPicAndStyles magicAvatarPicAndStyles2 = (MagicAvatarPicAndStyles) obj;
                if (!magicAvatarCropViewModel.t2().isEmpty()) {
                }
            }
        }
        magicAvatarCropViewModel$requestMoreStyles$1 = new MagicAvatarCropViewModel$requestMoreStyles$1(this, continuation);
        Object obj2 = magicAvatarCropViewModel$requestMoreStyles$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = magicAvatarCropViewModel$requestMoreStyles$1.label;
        if (i3 == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W2() {
        QQToast.makeText(MobileQQ.sMobileQQ, "\u4fdd\u5b58\u5931\u8d25\uff0c\u7a0d\u540e\u518d\u8bd5", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e3(MagicAvatarMaterialInfo magicAvatarMaterialInfo, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        for (MagicAvatarMaterialInfo magicAvatarMaterialInfo2 : t2()) {
            magicAvatarMaterialInfo2.setSelected(Intrinsics.areEqual(magicAvatarMaterialInfo2.getMaterialId(), magicAvatarMaterialInfo.getMaterialId()));
        }
        Object Q2 = Q2(this, null, continuation, 1, null);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (Q2 == coroutine_suspended) {
            return Q2;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f3(com.tencent.mobileqq.wink.magicAvatar.model.f fVar, Continuation<? super Unit> continuation) {
        MagicAvatarCropViewModel$updateState$1 magicAvatarCropViewModel$updateState$1;
        Object coroutine_suspended;
        int i3;
        MagicAvatarCropViewModel magicAvatarCropViewModel;
        MutableStateFlow<a> mutableStateFlow;
        a.d dVar;
        if (continuation instanceof MagicAvatarCropViewModel$updateState$1) {
            magicAvatarCropViewModel$updateState$1 = (MagicAvatarCropViewModel$updateState$1) continuation;
            int i16 = magicAvatarCropViewModel$updateState$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                magicAvatarCropViewModel$updateState$1.label = i16 - Integer.MIN_VALUE;
                Object obj = magicAvatarCropViewModel$updateState$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = magicAvatarCropViewModel$updateState$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    fVar = (com.tencent.mobileqq.wink.magicAvatar.model.f) magicAvatarCropViewModel$updateState$1.L$1;
                    magicAvatarCropViewModel = (MagicAvatarCropViewModel) magicAvatarCropViewModel$updateState$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    MutableSharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> mutableSharedFlow = this._textCountState;
                    magicAvatarCropViewModel$updateState$1.L$0 = this;
                    magicAvatarCropViewModel$updateState$1.L$1 = fVar;
                    magicAvatarCropViewModel$updateState$1.label = 1;
                    if (mutableSharedFlow.emit(fVar, magicAvatarCropViewModel$updateState$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    magicAvatarCropViewModel = this;
                }
                if (!magicAvatarCropViewModel.T2().isEmpty() && ((fVar instanceof f.b) || (fVar instanceof f.e))) {
                    MutableStateFlow<a> mutableStateFlow2 = magicAvatarCropViewModel._generateEvent;
                    a.c cVar = a.c.f323597a;
                    magicAvatarCropViewModel$updateState$1.L$0 = null;
                    magicAvatarCropViewModel$updateState$1.L$1 = null;
                    magicAvatarCropViewModel$updateState$1.label = 2;
                    if (mutableStateFlow2.emit(cVar, magicAvatarCropViewModel$updateState$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                mutableStateFlow = magicAvatarCropViewModel._generateEvent;
                dVar = a.d.f323598a;
                magicAvatarCropViewModel$updateState$1.L$0 = null;
                magicAvatarCropViewModel$updateState$1.L$1 = null;
                magicAvatarCropViewModel$updateState$1.label = 3;
                if (mutableStateFlow.emit(dVar, magicAvatarCropViewModel$updateState$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        magicAvatarCropViewModel$updateState$1 = new MagicAvatarCropViewModel$updateState$1(this, continuation);
        Object obj2 = magicAvatarCropViewModel$updateState$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = magicAvatarCropViewModel$updateState$1.label;
        if (i3 == 0) {
        }
        if (!magicAvatarCropViewModel.T2().isEmpty()) {
        }
        mutableStateFlow = magicAvatarCropViewModel._generateEvent;
        dVar = a.d.f323598a;
        magicAvatarCropViewModel$updateState$1.L$0 = null;
        magicAvatarCropViewModel$updateState$1.L$1 = null;
        magicAvatarCropViewModel$updateState$1.label = 3;
        if (mutableStateFlow.emit(dVar, magicAvatarCropViewModel$updateState$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2(List<MagicAvatarMaterialInfo> list) {
        MagicAvatarMaterialInfo magicAvatarMaterialInfo = new MagicAvatarMaterialInfo();
        magicAvatarMaterialInfo.setMaterialId("addMore");
        magicAvatarMaterialInfo.setType(1);
        list.add(magicAvatarMaterialInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.wink.magicAvatar.model.f n2(AvatarCountInfo info, AvatarCountInfo vipInfo) {
        int i3;
        if (info.getVipLevel() > 0) {
            if (info.getFreeCount() + info.getVipCount() > 0) {
                return new f.C9055f(info.getFreeCount(), info.getVipCount(), info.getVipLevel());
            }
            return f.e.f323524a;
        }
        if (info.getFreeCount() > 0) {
            return new f.c(info.getFreeCount(), info.getVipCount(), info.getVipLevel());
        }
        if (vipInfo != null) {
            i3 = vipInfo.getVipTotalCount();
        } else {
            i3 = 0;
        }
        return new f.b(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MagicAvatarMaterialInfo> t2() {
        if (M2(this.infoFromPicker)) {
            return this.femaleList;
        }
        return this.maleList;
    }

    private final List<MagicAvatarMaterialInfo> u2(ArrayList<MagicAvatarMaterialInfo> oldList, List<MagicAvatarMaterialInfo> newList) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = oldList.size();
        for (MagicAvatarMaterialInfo item : oldList.subList(size - 8, size)) {
            String materialId = item.getMaterialId();
            Intrinsics.checkNotNullExpressionValue(item, "item");
            linkedHashMap.put(materialId, item);
        }
        ArrayList arrayList = new ArrayList();
        for (MagicAvatarMaterialInfo magicAvatarMaterialInfo : newList) {
            if (!linkedHashMap.containsKey(magicAvatarMaterialInfo.getMaterialId())) {
                arrayList.add(magicAvatarMaterialInfo);
            }
        }
        w53.b.f("MagicAvatarCropViewModel", "requestMoreStyles deduplication newSize = " + arrayList.size() + ", oldsize = " + size);
        oldList.addAll(arrayList);
        return oldList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(9:5|6|7|(1:(1:(1:(1:(3:13|14|15)(2:17|18))(5:19|20|21|14|15))(6:23|24|25|26|27|(1:29)(4:30|21|14|15)))(3:37|38|39))(4:53|54|55|(1:57)(1:58))|40|41|(1:50)|45|(1:47)(4:48|26|27|(0)(0))))|63|6|7|(0)(0)|40|41|(1:43)|50|45|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e4, code lost:
    
        r12 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e5, code lost:
    
        r1 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0063, code lost:
    
        r12 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object v2(MagicAvatarMaterialInfo magicAvatarMaterialInfo, Continuation<? super Unit> continuation) {
        MagicAvatarCropViewModel$generateAvatar$1 magicAvatarCropViewModel$generateAvatar$1;
        Object coroutine_suspended;
        MagicAvatarCropViewModel magicAvatarCropViewModel;
        MutableStateFlow<a> mutableStateFlow;
        a.C9058a c9058a;
        MagicAvatarCropViewModel magicAvatarCropViewModel2;
        MagicAvatarGenerateInfo magicAvatarGenerateInfo;
        Object o16;
        MagicAvatarCropViewModel magicAvatarCropViewModel3;
        if (continuation instanceof MagicAvatarCropViewModel$generateAvatar$1) {
            magicAvatarCropViewModel$generateAvatar$1 = (MagicAvatarCropViewModel$generateAvatar$1) continuation;
            int i3 = magicAvatarCropViewModel$generateAvatar$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                magicAvatarCropViewModel$generateAvatar$1.label = i3 - Integer.MIN_VALUE;
                Object obj = magicAvatarCropViewModel$generateAvatar$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                magicAvatarCropViewModel = magicAvatarCropViewModel$generateAvatar$1.label;
                if (magicAvatarCropViewModel == 0) {
                    if (magicAvatarCropViewModel != 1) {
                        if (magicAvatarCropViewModel != 2) {
                            if (magicAvatarCropViewModel != 3) {
                                if (magicAvatarCropViewModel == 4) {
                                    ResultKt.throwOnFailure(obj);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            magicAvatarMaterialInfo = (MagicAvatarMaterialInfo) magicAvatarCropViewModel$generateAvatar$1.L$1;
                            MagicAvatarCropViewModel magicAvatarCropViewModel4 = (MagicAvatarCropViewModel) magicAvatarCropViewModel$generateAvatar$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            magicAvatarCropViewModel = magicAvatarCropViewModel4;
                            magicAvatarMaterialInfo.setLocalPicPath((String) obj);
                            magicAvatarCropViewModel.r2();
                            return Unit.INSTANCE;
                        }
                        magicAvatarMaterialInfo = (MagicAvatarMaterialInfo) magicAvatarCropViewModel$generateAvatar$1.L$1;
                        MagicAvatarCropViewModel magicAvatarCropViewModel5 = (MagicAvatarCropViewModel) magicAvatarCropViewModel$generateAvatar$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        magicAvatarCropViewModel3 = magicAvatarCropViewModel5;
                        try {
                            Pair pair = (Pair) obj;
                            String str = (String) pair.component1();
                            String str2 = (String) pair.component2();
                            magicAvatarMaterialInfo.setGenerateUrl(str);
                            magicAvatarMaterialInfo.setGenerateQRUrl(str2);
                            MagicStudioDataSource magicStudioDataSource = MagicStudioDataSource.f323652a;
                            String generateUrl = magicAvatarMaterialInfo.getGenerateUrl();
                            magicAvatarCropViewModel$generateAvatar$1.L$0 = magicAvatarCropViewModel3;
                            magicAvatarCropViewModel$generateAvatar$1.L$1 = magicAvatarMaterialInfo;
                            magicAvatarCropViewModel$generateAvatar$1.label = 3;
                            obj = MagicStudioDataSource.s(magicStudioDataSource, generateUrl, false, null, magicAvatarCropViewModel$generateAvatar$1, 6, null);
                        } catch (Exception e16) {
                            e = e16;
                            magicAvatarCropViewModel = magicAvatarCropViewModel3;
                            mutableStateFlow = magicAvatarCropViewModel._generateEvent;
                            c9058a = new a.C9058a(e);
                            magicAvatarCropViewModel$generateAvatar$1.L$0 = null;
                            magicAvatarCropViewModel$generateAvatar$1.L$1 = null;
                            magicAvatarCropViewModel$generateAvatar$1.label = 4;
                            if (mutableStateFlow.emit(c9058a, magicAvatarCropViewModel$generateAvatar$1) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        }
                        if (obj != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        magicAvatarCropViewModel = magicAvatarCropViewModel3;
                        magicAvatarMaterialInfo.setLocalPicPath((String) obj);
                        magicAvatarCropViewModel.r2();
                        return Unit.INSTANCE;
                    }
                    magicAvatarMaterialInfo = (MagicAvatarMaterialInfo) magicAvatarCropViewModel$generateAvatar$1.L$1;
                    MagicAvatarCropViewModel magicAvatarCropViewModel6 = (MagicAvatarCropViewModel) magicAvatarCropViewModel$generateAvatar$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    magicAvatarCropViewModel2 = magicAvatarCropViewModel6;
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        MutableStateFlow<a> mutableStateFlow2 = this._generateEvent;
                        a.g gVar = a.g.f323601a;
                        magicAvatarCropViewModel$generateAvatar$1.L$0 = this;
                        magicAvatarCropViewModel$generateAvatar$1.L$1 = magicAvatarMaterialInfo;
                        magicAvatarCropViewModel$generateAvatar$1.label = 1;
                        if (mutableStateFlow2.emit(gVar, magicAvatarCropViewModel$generateAvatar$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        magicAvatarCropViewModel2 = this;
                    } catch (Exception e17) {
                        e = e17;
                        magicAvatarCropViewModel = this;
                        mutableStateFlow = magicAvatarCropViewModel._generateEvent;
                        c9058a = new a.C9058a(e);
                        magicAvatarCropViewModel$generateAvatar$1.L$0 = null;
                        magicAvatarCropViewModel$generateAvatar$1.L$1 = null;
                        magicAvatarCropViewModel$generateAvatar$1.label = 4;
                        if (mutableStateFlow.emit(c9058a, magicAvatarCropViewModel$generateAvatar$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                MagicAvatarDataSource magicAvatarDataSource = MagicAvatarDataSource.f323499a;
                magicAvatarGenerateInfo = magicAvatarCropViewModel2.infoFromPicker;
                if (magicAvatarGenerateInfo != null || (r3 = magicAvatarGenerateInfo.getUploadUrl()) == null) {
                    String str3 = "";
                }
                String styleName = magicAvatarMaterialInfo.getStyleName();
                String materialUrl = magicAvatarMaterialInfo.getMaterialUrl();
                String materialId = magicAvatarMaterialInfo.getMaterialId();
                magicAvatarCropViewModel$generateAvatar$1.L$0 = magicAvatarCropViewModel2;
                magicAvatarCropViewModel$generateAvatar$1.L$1 = magicAvatarMaterialInfo;
                magicAvatarCropViewModel$generateAvatar$1.label = 2;
                o16 = magicAvatarDataSource.o(str3, styleName, materialUrl, materialId, magicAvatarCropViewModel$generateAvatar$1);
                if (o16 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                magicAvatarCropViewModel3 = magicAvatarCropViewModel2;
                obj = o16;
                Pair pair2 = (Pair) obj;
                String str4 = (String) pair2.component1();
                String str22 = (String) pair2.component2();
                magicAvatarMaterialInfo.setGenerateUrl(str4);
                magicAvatarMaterialInfo.setGenerateQRUrl(str22);
                MagicStudioDataSource magicStudioDataSource2 = MagicStudioDataSource.f323652a;
                String generateUrl2 = magicAvatarMaterialInfo.getGenerateUrl();
                magicAvatarCropViewModel$generateAvatar$1.L$0 = magicAvatarCropViewModel3;
                magicAvatarCropViewModel$generateAvatar$1.L$1 = magicAvatarMaterialInfo;
                magicAvatarCropViewModel$generateAvatar$1.label = 3;
                obj = MagicStudioDataSource.s(magicStudioDataSource2, generateUrl2, false, null, magicAvatarCropViewModel$generateAvatar$1, 6, null);
                if (obj != coroutine_suspended) {
                }
            }
        }
        magicAvatarCropViewModel$generateAvatar$1 = new MagicAvatarCropViewModel$generateAvatar$1(this, continuation);
        Object obj2 = magicAvatarCropViewModel$generateAvatar$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        magicAvatarCropViewModel = magicAvatarCropViewModel$generateAvatar$1.label;
        if (magicAvatarCropViewModel == 0) {
        }
        MagicAvatarDataSource magicAvatarDataSource2 = MagicAvatarDataSource.f323499a;
        magicAvatarGenerateInfo = magicAvatarCropViewModel2.infoFromPicker;
        if (magicAvatarGenerateInfo != null) {
        }
        String str32 = "";
        String styleName2 = magicAvatarMaterialInfo.getStyleName();
        String materialUrl2 = magicAvatarMaterialInfo.getMaterialUrl();
        String materialId2 = magicAvatarMaterialInfo.getMaterialId();
        magicAvatarCropViewModel$generateAvatar$1.L$0 = magicAvatarCropViewModel2;
        magicAvatarCropViewModel$generateAvatar$1.L$1 = magicAvatarMaterialInfo;
        magicAvatarCropViewModel$generateAvatar$1.label = 2;
        o16 = magicAvatarDataSource2.o(str32, styleName2, materialUrl2, materialId2, magicAvatarCropViewModel$generateAvatar$1);
        if (o16 != coroutine_suspended) {
        }
    }

    @Nullable
    /* renamed from: A2, reason: from getter */
    public final MagicAvatarMaterialInfo getCurrentSelectMaterial() {
        return this.currentSelectMaterial;
    }

    /* renamed from: B2, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    @NotNull
    public final StateFlow<a> C2() {
        return this.generateEvent;
    }

    @NotNull
    public final SharedFlow<ClipBitmapInfo> D2() {
        return this.getClipPath;
    }

    @Nullable
    /* renamed from: E2, reason: from getter */
    public final MagicAvatarGenerateInfo getInfoFromPicker() {
        return this.infoFromPicker;
    }

    @NotNull
    public final SharedFlow<Unit> F2() {
        return this.refreshButtonState;
    }

    @NotNull
    public final SharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> G2() {
        return this.styleFragmentButtonState;
    }

    @NotNull
    public final StateFlow<StylesEvent> H2() {
        return this.styleList;
    }

    @NotNull
    public final SharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> I2() {
        return this.textCountState;
    }

    public final void K2(int avatarSource) {
        int i3 = 1;
        if (avatarSource != 1) {
            i3 = 2;
        }
        this.from = i3;
        w53.b.f("MagicAvatarCropViewModel", "initFrom from = " + i3);
    }

    public final boolean M2(@Nullable MagicAvatarGenerateInfo value) {
        String str;
        if (value != null) {
            str = value.getGender();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, LightConstants.FEMALE);
    }

    public final void N2(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        w53.b.f("MagicAvatarCropViewModel", "loadBitmap path = " + path);
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarCropViewModel$loadBitmap$1(path, this, null), 3, null);
    }

    public final void O2() {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarCropViewModel$notifyEmptyList$1(this, null), 3, null);
    }

    public final void V2() {
        boolean z16;
        MagicAvatarMaterialInfo magicAvatarMaterialInfo = this.currentSelectMaterial;
        if (magicAvatarMaterialInfo != null) {
            if (magicAvatarMaterialInfo.getGenerateQRUrl().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                MagicStudioDataSource.f323652a.C(0, magicAvatarMaterialInfo.getGenerateQRUrl(), new b());
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicAvatar.viewmodel.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        MagicAvatarCropViewModel.W2();
                    }
                });
            }
        }
    }

    public final void Y2() {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarCropViewModel$setCropLoading$1(this, null), 3, null);
    }

    public final void a3(@Nullable MagicAvatarMaterialInfo magicAvatarMaterialInfo) {
        this.currentSelectMaterial = magicAvatarMaterialInfo;
    }

    public final void b3(boolean z16) {
        this.isInLoading = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c3(@Nullable MagicAvatarGenerateInfo magicAvatarGenerateInfo) {
        ArrayList<MagicAvatarMaterialInfo> materials;
        ArrayList<MagicAvatarMaterialInfo> materials2;
        this.infoFromPicker = magicAvatarGenerateInfo;
        this.isInLoading = false;
        MagicAvatarMaterialInfo magicAvatarMaterialInfo = null;
        if (magicAvatarGenerateInfo != null && (materials2 = magicAvatarGenerateInfo.getMaterials()) != null) {
            Iterator<T> it = materials2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((MagicAvatarMaterialInfo) next).getIsSelected()) {
                    magicAvatarMaterialInfo = next;
                    break;
                }
            }
            magicAvatarMaterialInfo = magicAvatarMaterialInfo;
        }
        this.currentSelectMaterial = magicAvatarMaterialInfo;
        if (magicAvatarGenerateInfo != null && (materials = magicAvatarGenerateInfo.getMaterials()) != null) {
            L2(materials);
        }
    }

    public final void d3(@NotNull com.tencent.mobileqq.wink.magicAvatar.model.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<set-?>");
        this.lastUserCountState = fVar;
    }

    public final void m2() {
        if (!p2()) {
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarCropViewModel$changeGender$1(this, null), 3, null);
        }
    }

    public final void o2() {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarCropViewModel$checkCount$1(this, null), 3, null);
    }

    public final boolean p2() {
        if (!this.isInLoading) {
            return false;
        }
        QQToast.makeText(MobileQQ.sMobileQQ, "\u6b63\u5728\u751f\u6210\u4e2d\uff0c\u8bf7\u7a0d\u5019~", 0).show();
        return true;
    }

    public final void q2() {
        if (!this.isInLoading) {
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarCropViewModel$checkNeedGenerate$1(this, null), 3, null);
        } else {
            w53.b.f("MagicAvatarCropViewModel", "checkNeedGenerate isInLoading");
        }
    }

    public final void r2() {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarCropViewModel$consumeTimes$1(this, null), 3, null);
    }

    public final void s2(int pos) {
        w53.b.f("MagicAvatarCropViewModel", "consumeWithCachedUserCountState info is: " + Z + ", vipInfo is: " + f323590a0);
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarCropViewModel$consumeWithCachedUserCountState$1(this, pos, null), 3, null);
    }

    public final void w2() {
        MagicAvatarMaterialInfo magicAvatarMaterialInfo;
        if (!p2() && (magicAvatarMaterialInfo = this.currentSelectMaterial) != null) {
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarCropViewModel$generateAvatarWithCurrent$1$1(this, magicAvatarMaterialInfo, null), 3, null);
        }
    }

    public final void x2(boolean isPreview, @Nullable Bitmap bitmap) {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new MagicAvatarCropViewModel$getBitmapFile$1(bitmap, this, isPreview, null), 3, null);
    }

    @NotNull
    public final SharedFlow<com.tencent.mobileqq.wink.magicAvatar.model.f> y2() {
        return this.buttonState;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.magicAvatar.model.f z2() {
        w53.b.f("MagicAvatarCropViewModel", "getCachedUserState info is: " + Z + ", vipInfo is: " + f323590a0);
        if (Z != null) {
            AvatarCountInfo avatarCountInfo = Z;
            Intrinsics.checkNotNull(avatarCountInfo);
            return n2(avatarCountInfo, f323590a0);
        }
        return f.d.f323523a;
    }
}
