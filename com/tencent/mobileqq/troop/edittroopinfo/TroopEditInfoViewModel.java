package com.tencent.mobileqq.troop.edittroopinfo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.handler.TroopModifyHandler;
import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.e;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b*\u0002\u0098\u0001\u0018\u0000 [2\u00020\u0001:\u0002\u009e\u0001B\t\u00a2\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J(\u0010\u0011\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0014\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0014\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0014\u0010\u0017\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u001a\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0002J\u001a\u0010\u001c\u001a\u00020\u00022\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\rH\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\u001e\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0018H\u0002JD\u0010'\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00132\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010$2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010$H\u0002J\u0018\u0010+\u001a\u00020\u00132\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0013H\u0002J\u0018\u0010.\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010/\u001a\u00020\u0002J\u0018\u00103\u001a\u00020\u00022\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100J\u000e\u00105\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0013J\b\u00107\u001a\u0004\u0018\u000106J\u000e\u00109\u001a\u00020\u00022\u0006\u00108\u001a\u00020\nJ\u001e\u0010=\u001a\u00020\u00022\u0006\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u0006J\u001e\u0010A\u001a\u00020\u00022\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u0006J&\u0010E\u001a\u00020\u00022\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u00130Bj\b\u0012\u0004\u0012\u00020\u0013`C2\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010I\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010K\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010*\u001a\u00020\u00132\u0006\u0010L\u001a\u00020\u00138\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR$\u0010#\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u00188\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0016\u0010V\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010RR$\u0010Y\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u00188\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bW\u0010R\u001a\u0004\bX\u0010TR$\u0010^\u001a\u00020\n2\u0006\u0010L\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R \u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020`0\r0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR#\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020`0\r0d8\u0006\u00a2\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020j0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010bR\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020j0d8\u0006\u00a2\u0006\f\n\u0004\bR\u0010f\u001a\u0004\bm\u0010hR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020\n0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010bR\u001d\u0010s\u001a\b\u0012\u0004\u0012\u00020\n0d8\u0006\u00a2\u0006\f\n\u0004\bq\u0010f\u001a\u0004\br\u0010hR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00130_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010bR\u001d\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00130d8\u0006\u00a2\u0006\f\n\u0004\bv\u0010f\u001a\u0004\bw\u0010hR\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00130_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\by\u0010bR\u001d\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00130d8\u0006\u00a2\u0006\f\n\u0004\b{\u0010f\u001a\u0004\b|\u0010hR\u001a\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00130_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010bR \u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130d8\u0006\u00a2\u0006\u000e\n\u0005\b\u0080\u0001\u0010f\u001a\u0005\b\u0081\u0001\u0010hR\u001c\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130_8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010bR \u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130d8\u0006\u00a2\u0006\u000e\n\u0005\b\u0085\u0001\u0010f\u001a\u0005\b\u0086\u0001\u0010hR\"\u0010\u0089\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0_8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010bR&\u0010\u008c\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0d8\u0006\u00a2\u0006\u000e\n\u0005\b\u008a\u0001\u0010f\u001a\u0005\b\u008b\u0001\u0010hR%\u0010\u0091\u0001\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010\u008e\u0001\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R-\u0010\u0097\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u0092\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0018\u0010\u009b\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u00a8\u0006\u009f\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/TroopEditInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "", NowProxyConstants.AccountInfoKey.A2, Constants.BASE_IN_PLUGIN_VERSION, Constants.MMCCID, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "T1", "S1", "", "isSuc", "y2", "", "", "curList", "coverList", "o2", "N2", "", "showValue", "J2", "L2", "H2", "", "errCode", "errorMsg", "X1", "Q2", "U1", "O2", "target", "z2", "Lcom/tencent/mobileqq/data/troop/b;", IndividuationUrlHelper.UrlId.CARD_HOME, "from", "Lkotlin/Function0;", "onSuccess", "onFail", "q2", "Lcom/tencent/mobileqq/troop/avatar/a;", "info", "troopUin", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroid/content/Intent;", "intent", ICustomDataEditor.NUMBER_PARAM_2, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/mobileqq/data/troop/TroopClipPic;", "picList", "E2", "troopName", "x2", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "g2", "isChecked", "B2", "modifyInfoTroopCard", "newLocation", "owner", "u2", "", "troopClassExt", "classText", "p2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tagList", "w2", "location", "grade", "school", "v2", "intro", "t2", "<set-?>", "i", "Ljava/lang/String;", "m2", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "Z1", "()I", BdhLogUtil.LogTag.Tag_Conn, "nStatOption", "D", "d2", "submitTime", "E", "Z", "b2", "()Z", "returnMsgList", "Li53/b;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/f;", UserInfo.SEX_FEMALE, "Li53/b;", "_troopCoverLiveData", "Landroidx/lifecycle/LiveData;", "G", "Landroidx/lifecycle/LiveData;", "f2", "()Landroidx/lifecycle/LiveData;", "troopCoverLiveData", "", "H", "_troopNameLiveData", "j2", "troopNameLiveData", "J", "_allowMemberModifyTroopName", "K", "W1", "allowMemberModifyTroopName", "L", "_troopIntroLiveData", "M", SemanticAttributes.DbSystemValues.H2, "troopIntroLiveData", "N", "_troopLocationLiveData", "P", "i2", "troopLocationLiveData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "_troopClassifyTextLiveData", BdhLogUtil.LogTag.Tag_Req, "e2", "troopClassifyTextLiveData", ExifInterface.LATITUDE_SOUTH, "_troopSchoolTextLiveData", "T", "k2", "troopSchoolTextLiveData", "U", "_troopTagsLiveData", "V", "l2", "troopTagsLiveData", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Lcom/tencent/common/app/AppInterface;", "W", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "appRef", "Ljava/util/concurrent/ConcurrentHashMap;", "X", "Lkotlin/Lazy;", "c2", "()Ljava/util/concurrent/ConcurrentHashMap;", "schoolGradeMap", "com/tencent/mobileqq/troop/edittroopinfo/TroopEditInfoViewModel$b", "Y", "Lcom/tencent/mobileqq/troop/edittroopinfo/TroopEditInfoViewModel$b;", "troopAvatarObserver", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopEditInfoViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int nStatOption;

    /* renamed from: D, reason: from kotlin metadata */
    private int submitTime;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean returnMsgList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final i53.b<List<f>> _troopCoverLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<f>> troopCoverLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final i53.b<CharSequence> _troopNameLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<CharSequence> troopNameLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final i53.b<Boolean> _allowMemberModifyTroopName;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> allowMemberModifyTroopName;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final i53.b<String> _troopIntroLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> troopIntroLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final i53.b<String> _troopLocationLiveData;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> troopLocationLiveData;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final i53.b<String> _troopClassifyTextLiveData;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> troopClassifyTextLiveData;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final i53.b<String> _troopSchoolTextLiveData;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> troopSchoolTextLiveData;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final i53.b<List<String>> _troopTagsLiveData;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<String>> troopTagsLiveData;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.meta.refresh.c<AppInterface> appRef;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy schoolGradeMap;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final b troopAvatarObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int from;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/TroopEditInfoViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JD\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/troop/edittroopinfo/TroopEditInfoViewModel$b", "Lcom/tencent/mobileqq/troop/api/observer/a;", "", "isSuc", "", "troopUin", "", "result", "errorMsg", "seq", "", "Lcom/tencent/mobileqq/data/troop/TroopClipPic;", "picList", "", "onGetTroopAvatar", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.mobileqq.troop.api.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopEditInfoViewModel.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.a
        public void onGetTroopAvatar(boolean isSuc, @Nullable String troopUin, int result, @Nullable String errorMsg, int seq, @Nullable List<TroopClipPic> picList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuc), troopUin, Integer.valueOf(result), errorMsg, Integer.valueOf(seq), picList);
                return;
            }
            if (!Intrinsics.areEqual(troopUin, TroopEditInfoViewModel.this.m2())) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("EditTroopInfoFragment-VM", 2, "[onGetTroopAvatar] result:" + result + ", errorMsg:" + errorMsg + ", picList:" + picList);
            }
            TroopEditInfoViewModel.this.E2(picList);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31666);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopEditInfoViewModel() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.troopUin = "";
        i53.b<List<f>> bVar = new i53.b<>();
        this._troopCoverLiveData = bVar;
        this.troopCoverLiveData = bVar;
        i53.b<CharSequence> bVar2 = new i53.b<>();
        this._troopNameLiveData = bVar2;
        this.troopNameLiveData = bVar2;
        i53.b<Boolean> bVar3 = new i53.b<>();
        this._allowMemberModifyTroopName = bVar3;
        this.allowMemberModifyTroopName = bVar3;
        i53.b<String> bVar4 = new i53.b<>();
        this._troopIntroLiveData = bVar4;
        this.troopIntroLiveData = bVar4;
        i53.b<String> bVar5 = new i53.b<>();
        this._troopLocationLiveData = bVar5;
        this.troopLocationLiveData = bVar5;
        i53.b<String> bVar6 = new i53.b<>();
        this._troopClassifyTextLiveData = bVar6;
        this.troopClassifyTextLiveData = bVar6;
        i53.b<String> bVar7 = new i53.b<>();
        this._troopSchoolTextLiveData = bVar7;
        this.troopSchoolTextLiveData = bVar7;
        i53.b<List<String>> bVar8 = new i53.b<>();
        this._troopTagsLiveData = bVar8;
        this.troopTagsLiveData = bVar8;
        lazy = LazyKt__LazyJVMKt.lazy(TroopEditInfoViewModel$schoolGradeMap$2.INSTANCE);
        this.schoolGradeMap = lazy;
        this.troopAvatarObserver = new b();
    }

    private final void A2() {
        AppInterface e16 = bg.e();
        this.appRef = new com.tencent.qqnt.avatar.meta.refresh.c<>(e16);
        if (e16 != null) {
            e16.addObserver(this.troopAvatarObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(TroopEditInfoViewModel this$0, boolean z16, int i3, String errMsg) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("EditTroopInfoFragment-VM", 1, "[setNormalMemberCanModifyTroopName] isSuccess:" + z16 + ", errorCode:" + i3 + ", errMsg:" + errMsg);
        if (!z16) {
            e.k(null, 1, "\u8bbe\u7f6e\u5931\u8d25", 0, null, 25, null);
            i53.b<Boolean> bVar = this$0._allowMemberModifyTroopName;
            TroopInfo g26 = this$0.g2();
            if (g26 != null) {
                z17 = g26.normalMemberCanModifyTroopName();
            } else {
                z17 = false;
            }
            bVar.postValue(Boolean.valueOf(z17));
        }
    }

    private final void D2() {
        AppInterface appInterface;
        com.tencent.qqnt.avatar.meta.refresh.c<AppInterface> cVar = this.appRef;
        if (cVar != null && (appInterface = cVar.get()) != null) {
            appInterface.removeObserver(this.troopAvatarObserver);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void F2(TroopEditInfoViewModel troopEditInfoViewModel, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = null;
        }
        troopEditInfoViewModel.E2(list);
    }

    private final void G2() {
        F2(this, null, 1, null);
        N2();
        K2(this, null, 1, null);
        I2(this, null, 1, null);
        R2(this, null, 1, null);
        P2(this, null, 1, null);
        M2(this, null, 1, null);
    }

    private final void H2(String showValue) {
        boolean z16;
        String str;
        if (showValue != null) {
            this._troopClassifyTextLiveData.postValue(showValue);
            return;
        }
        TroopInfo g26 = g2();
        if (g26 == null) {
            return;
        }
        String str2 = g26.mGroupClassExtText;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = HardCodeUtil.qqStr(R.string.f172823ui2);
        } else {
            str = g26.mGroupClassExtText;
        }
        this._troopClassifyTextLiveData.postValue(str);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new TroopEditInfoViewModel$updateTroopClassify$2(g26, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void I2(TroopEditInfoViewModel troopEditInfoViewModel, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        troopEditInfoViewModel.H2(str);
    }

    private final void J2(String showValue) {
        String troopShareDescDefaultWording;
        boolean z16;
        if (showValue != null) {
            i53.b<String> bVar = this._troopIntroLiveData;
            if (showValue.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                showValue = ((ITroopShareUtility) QRoute.api(ITroopShareUtility.class)).getTroopShareDescDefaultWording();
            }
            bVar.postValue(showValue);
            return;
        }
        TroopInfo g26 = g2();
        if (g26 == null) {
            return;
        }
        if (!TextUtils.isEmpty(g26.mRichFingerMemo)) {
            troopShareDescDefaultWording = g26.mRichFingerMemo;
        } else {
            troopShareDescDefaultWording = ((ITroopShareUtility) QRoute.api(ITroopShareUtility.class)).getTroopShareDescDefaultWording();
        }
        this._troopIntroLiveData.postValue(troopShareDescDefaultWording);
    }

    static /* synthetic */ void K2(TroopEditInfoViewModel troopEditInfoViewModel, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        troopEditInfoViewModel.J2(str);
    }

    private final void L2(String showValue) {
        String qqStr;
        boolean z16;
        if (showValue != null) {
            i53.b<String> bVar = this._troopLocationLiveData;
            if (showValue.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                showValue = HardCodeUtil.qqStr(R.string.f172823ui2);
            }
            bVar.postValue(showValue);
            return;
        }
        TroopInfo g26 = g2();
        if (g26 == null) {
            return;
        }
        if (!TextUtils.isEmpty(g26.strLocation)) {
            qqStr = g26.strLocation;
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f172823ui2);
        }
        this._troopLocationLiveData.postValue(qqStr);
    }

    static /* synthetic */ void M2(TroopEditInfoViewModel troopEditInfoViewModel, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        troopEditInfoViewModel.L2(str);
    }

    private final void N2() {
        String troopName = HardCodeUtil.qqStr(R.string.khr);
        TroopInfo g26 = g2();
        if (g26 != null && g26.hasSetNewTroopName) {
            troopName = g26.troopNameFromNT;
        }
        Intrinsics.checkNotNullExpressionValue(troopName, "troopName");
        x2(troopName);
    }

    private final void O2(String showValue) {
        String z26;
        boolean z16;
        if (showValue != null) {
            i53.b<String> bVar = this._troopSchoolTextLiveData;
            if (showValue.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                showValue = HardCodeUtil.qqStr(R.string.f172823ui2);
            }
            bVar.postValue(showValue);
            return;
        }
        TroopInfo g26 = g2();
        if (g26 == null) {
            return;
        }
        if (TextUtils.isEmpty(g26.location)) {
            z26 = HardCodeUtil.qqStr(R.string.f172823ui2);
        } else {
            z26 = z2(g26.grade);
        }
        this._troopSchoolTextLiveData.postValue(z26);
    }

    static /* synthetic */ void P2(TroopEditInfoViewModel troopEditInfoViewModel, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        troopEditInfoViewModel.O2(str);
    }

    private final void Q2(List<String> showValue) {
        List<String> emptyList;
        if (showValue != null) {
            this._troopTagsLiveData.postValue(showValue);
            return;
        }
        TroopInfo g26 = g2();
        if (g26 == null || (emptyList = com.tencent.mobileqq.troop.troopsetting.modules.base.b.f301142a.a(g26)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        if (!o2(this._troopTagsLiveData.getValue(), emptyList)) {
            if (QLog.isColorLevel()) {
                QLog.i("EditTroopInfoFragment-VM", 2, "[updateTroopTags] tags:" + emptyList);
            }
            this._troopTagsLiveData.postValue(emptyList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("EditTroopInfoFragment-VM", 2, "[updateTroopTags] same tags");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void R2(TroopEditInfoViewModel troopEditInfoViewModel, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = null;
        }
        troopEditInfoViewModel.Q2(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopEditInfoViewModel$fetchTroopCover$1(this, null), 3, null);
    }

    private final void T1(LifecycleOwner lifecycleOwner) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new TroopEditInfoViewModel$fetchTroopInfo$1(this, lifecycleOwner, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(LifecycleOwner lifecycleOwner) {
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopTags(this.troopUin, lifecycleOwner, new Function2<Boolean, TroopInfo, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel$fetchTroopTags$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopEditInfoViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                invoke(bool.booleanValue(), troopInfo);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull TroopInfo troopInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), troopInfo);
                    return;
                }
                Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
                if (z16) {
                    TroopInfo g26 = TroopEditInfoViewModel.this.g2();
                    if (g26 != null) {
                        g26.mTags = troopInfo.mTags;
                    }
                    TroopEditInfoViewModel.R2(TroopEditInfoViewModel.this, null, 1, null);
                }
            }
        });
    }

    private final String X1(int errCode, String errorMsg) {
        String qqStr;
        boolean z16;
        boolean z17 = false;
        if (errorMsg != null) {
            if (errorMsg.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (!z17) {
            if (errCode != 1299) {
                if (errCode != 1793) {
                    switch (errCode) {
                        case 1281:
                            qqStr = HardCodeUtil.qqStr(R.string.bvz);
                            break;
                        case 1282:
                            qqStr = HardCodeUtil.qqStr(R.string.f171035bw0);
                            break;
                        case 1283:
                            qqStr = HardCodeUtil.qqStr(R.string.f171036bw1);
                            break;
                        default:
                            qqStr = HardCodeUtil.qqStr(R.string.bvy);
                            break;
                    }
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.iqx);
                }
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.f160441v1);
            }
            errorMsg = qqStr;
            Intrinsics.checkNotNullExpressionValue(errorMsg, "{\n            when (errC\u2026)\n            }\n        }");
        }
        return errorMsg;
    }

    private final String a2(com.tencent.mobileqq.troop.avatar.a info, String troopUin) {
        int i3 = info.f294531c;
        QRouteApi api = QRoute.api(ITroopAvatarUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopAvatarUtilApi::class.java)");
        ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) api;
        if (i3 == 1 && (info.f294529a == null || !new File(info.f294529a).exists())) {
            String avatarAddress = iTroopAvatarUtilApi.getAvatarAddress(info.f294530b, troopUin, 1);
            Intrinsics.checkNotNullExpressionValue(avatarAddress, "troopAvatarUtilApi.getAv\u2026REGULAR_URL\n            )");
            String artWork = iTroopAvatarUtilApi.getArtWork(avatarAddress);
            Intrinsics.checkNotNullExpressionValue(artWork, "troopAvatarUtilApi.getArtWork(path)");
            return artWork;
        }
        if (i3 != 2 && (info.f294529a == null || !new File(info.f294529a).exists())) {
            if (i3 == 3) {
                String avatarAddress2 = iTroopAvatarUtilApi.getAvatarAddress(info.f294530b, troopUin, 0);
                Intrinsics.checkNotNullExpressionValue(avatarAddress2, "troopAvatarUtilApi.getAv\u2026W_GROUP_URL\n            )");
                String artWork2 = iTroopAvatarUtilApi.getArtWork(avatarAddress2);
                Intrinsics.checkNotNullExpressionValue(artWork2, "troopAvatarUtilApi.getArtWork(path)");
                return artWork2;
            }
            return "";
        }
        String str = info.f294529a;
        Intrinsics.checkNotNullExpressionValue(str, "info.localFile");
        return str;
    }

    private final ConcurrentHashMap<Integer, String> c2() {
        return (ConcurrentHashMap) this.schoolGradeMap.getValue();
    }

    private final boolean o2(List<? extends Object> curList, List<? extends Object> coverList) {
        if (curList == null && coverList == null) {
            return true;
        }
        if (curList == null || coverList == null || curList.size() != coverList.size()) {
            return false;
        }
        int size = curList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Intrinsics.areEqual(curList.get(i3), coverList.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private final void q2(com.tencent.mobileqq.data.troop.b card, LifecycleOwner lifecycleOwner, final String from, final Function0<Unit> onSuccess, final Function0<Unit> onFail) {
        if (!NetworkUtil.isNetworkAvailable()) {
            String qqStr = HardCodeUtil.qqStr(R.string.f235097aq);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.troop_network_failure)");
            e.k(null, 1, qqStr, 0, null, 25, null);
        } else {
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopData(this.troopUin, card, lifecycleOwner, "EditTroopInfoFragment-VM-" + from, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troop.edittroopinfo.c
                @Override // com.tencent.qqnt.troop.e
                public final void onResult(boolean z16, int i3, String str) {
                    TroopEditInfoViewModel.s2(from, onSuccess, this, onFail, z16, i3, str);
                }
            });
        }
    }

    static /* synthetic */ void r2(TroopEditInfoViewModel troopEditInfoViewModel, com.tencent.mobileqq.data.troop.b bVar, LifecycleOwner lifecycleOwner, String str, Function0 function0, Function0 function02, int i3, Object obj) {
        Function0 function03;
        Function0 function04;
        if ((i3 & 8) != 0) {
            function03 = null;
        } else {
            function03 = function0;
        }
        if ((i3 & 16) != 0) {
            function04 = null;
        } else {
            function04 = function02;
        }
        troopEditInfoViewModel.q2(bVar, lifecycleOwner, str, function03, function04);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(String from, Function0 function0, TroopEditInfoViewModel this$0, Function0 function02, boolean z16, int i3, String str) {
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("EditTroopInfoFragment-VM", 1, "[modifyTroopData] from:" + from + ", errCode:" + i3 + ", errMsg:" + str);
        if (z16) {
            if (function0 != null) {
                function0.invoke();
            }
        } else {
            e.k(null, 1, this$0.X1(i3, str), 0, null, 25, null);
            this$0.G2();
            if (function02 != null) {
                function02.invoke();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y2(boolean isSuc) {
        if (isSuc) {
            G2();
        }
    }

    private final String z2(int target) {
        String str = c2().get(Integer.valueOf(target));
        if (str == null) {
            return "";
        }
        return str;
    }

    public final void B2(boolean isChecked) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, isChecked);
            return;
        }
        this._allowMemberModifyTroopName.postValue(Boolean.valueOf(isChecked));
        if (isChecked) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateAllowMemberModifyTroopName(this.troopUin, i3, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troop.edittroopinfo.d
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i16, String str) {
                TroopEditInfoViewModel.C2(TroopEditInfoViewModel.this, z16, i16, str);
            }
        });
    }

    public final void E2(@Nullable List<TroopClipPic> picList) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        String a16;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) picList);
            return;
        }
        if (picList == null) {
            picList = new ArrayList<>();
            TroopInfo g26 = g2();
            if (g26 == null) {
                return;
            }
            List<TroopClipPic> list = g26.mTroopPicList;
            Intrinsics.checkNotNullExpressionValue(list, "troopInfo.mTroopPicList");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((TroopClipPic) obj).type != 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(obj);
                }
            }
            picList.addAll(arrayList);
        }
        ArrayList<TroopClipPic> arrayList2 = new ArrayList();
        for (Object obj2 : picList) {
            if (((TroopClipPic) obj2).type == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj2);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList<f> arrayList3 = new ArrayList(collectionSizeOrDefault);
        for (TroopClipPic troopClipPic : arrayList2) {
            com.tencent.mobileqq.troop.avatar.a info = com.tencent.mobileqq.troop.avatar.a.b(troopClipPic, null);
            Intrinsics.checkNotNullExpressionValue(info, "info");
            arrayList3.add(new f(a2(info, this.troopUin), troopClipPic));
        }
        if (!o2(this._troopCoverLiveData.getValue(), arrayList3)) {
            if (QLog.isColorLevel()) {
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
                for (f fVar : arrayList3) {
                    if (fVar.a().length() > 3) {
                        a16 = fVar.a().substring(fVar.a().length() - 3);
                        Intrinsics.checkNotNullExpressionValue(a16, "this as java.lang.String).substring(startIndex)");
                    } else {
                        a16 = fVar.a();
                    }
                    arrayList4.add(a16);
                }
                QLog.i("EditTroopInfoFragment-VM", 2, "[updateCover] coverList:" + arrayList4);
            }
            this._troopCoverLiveData.setValue(arrayList3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("EditTroopInfoFragment-VM", 2, "[updateCover] same list");
        }
    }

    @NotNull
    public final LiveData<Boolean> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.allowMemberModifyTroopName;
    }

    public final int Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.from;
    }

    public final boolean b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.returnMsgList;
    }

    public final int d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.submitTime;
    }

    @NotNull
    public final LiveData<String> e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (LiveData) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.troopClassifyTextLiveData;
    }

    @NotNull
    public final LiveData<List<f>> f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.troopCoverLiveData;
    }

    @Nullable
    public final TroopInfo g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return TroopInfoRepo.INSTANCE.getTroopInfoFromCache(this.troopUin);
    }

    @NotNull
    public final LiveData<String> h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.troopIntroLiveData;
    }

    @NotNull
    public final LiveData<String> i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (LiveData) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.troopLocationLiveData;
    }

    @NotNull
    public final LiveData<CharSequence> j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.troopNameLiveData;
    }

    @NotNull
    public final LiveData<String> k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (LiveData) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.troopSchoolTextLiveData;
    }

    @NotNull
    public final LiveData<List<String>> l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (LiveData) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.troopTagsLiveData;
    }

    @NotNull
    public final String m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public final void n2(@Nullable Intent intent, @NotNull LifecycleOwner lifecycleOwner) {
        Bundle bundle;
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) intent, (Object) lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        String str = null;
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            str = bundle.getString("troop_uin");
        }
        if (str == null) {
            str = "";
        }
        this.troopUin = str;
        boolean z16 = false;
        if (bundle != null) {
            i3 = bundle.getInt(AppConstants.Key.TROOP_INFO_FROM);
        } else {
            i3 = 0;
        }
        this.from = i3;
        if (bundle != null) {
            i16 = bundle.getInt(AppConstants.Key.TROOP_INFO_FROM_EX);
        } else {
            i16 = 0;
        }
        this.nStatOption = i16;
        if (bundle != null) {
            i17 = bundle.getInt(AppConstants.Key.TROOP_INFO_TROOP_AUTH_SUBMIT_TIME);
        } else {
            i17 = 0;
        }
        this.submitTime = i17;
        if (bundle != null) {
            z16 = bundle.getBoolean("returnMsgList", false);
        }
        this.returnMsgList = z16;
        A2();
        G2();
        T1(lifecycleOwner);
    }

    public final void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            D2();
        }
    }

    public final void p2(final long troopClassExt, @NotNull final String classText, @NotNull LifecycleOwner owner) {
        final long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Long.valueOf(troopClassExt), classText, owner);
            return;
        }
        Intrinsics.checkNotNullParameter(classText, "classText");
        Intrinsics.checkNotNullParameter(owner, "owner");
        TroopInfo g26 = g2();
        if (g26 != null) {
            j3 = g26.dwGroupClassExt;
        } else {
            j3 = 0;
        }
        if (QLog.isDebugVersion()) {
            QLog.i("EditTroopInfoFragment-VM", 2, "[modifyTroopClassify] troopClassExt:" + troopClassExt + ", oldGroupClassExt:" + j3 + ", classText:" + classText);
        }
        com.tencent.mobileqq.data.troop.b bVar = new com.tencent.mobileqq.data.troop.b(this.troopUin);
        bVar.q(Long.valueOf(troopClassExt));
        bVar.g(classText);
        r2(this, bVar, owner, "modifyTroopClassify", new Function0<Unit>(j3, troopClassExt, classText) { // from class: com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel$modifyTroopClassify$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $classText;
            final /* synthetic */ long $oldGroupClassExt;
            final /* synthetic */ long $troopClassExt;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$oldGroupClassExt = j3;
                this.$troopClassExt = troopClassExt;
                this.$classText = classText;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopEditInfoViewModel.this, Long.valueOf(j3), Long.valueOf(troopClassExt), classText);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BusinessHandler businessHandler;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopInfo g27 = TroopEditInfoViewModel.this.g2();
                if (g27 != null) {
                    long j16 = this.$troopClassExt;
                    String str = this.$classText;
                    g27.dwGroupClassExt = j16;
                    g27.mGroupClassExtText = str;
                }
                TroopEditInfoViewModel.I2(TroopEditInfoViewModel.this, null, 1, null);
                AppInterface e16 = bg.e();
                if (e16 == null || (businessHandler = e16.getBusinessHandler(TroopModifyHandler.class.getName())) == null) {
                    return;
                }
                businessHandler.notifyUI(com.tencent.mobileqq.troop.api.observer.c.f294316i, true, new Object[]{TroopEditInfoViewModel.this.m2(), Long.valueOf(this.$oldGroupClassExt), Long.valueOf(this.$troopClassExt)});
            }
        }, null, 16, null);
    }

    public final void t2(@NotNull final String intro, @NotNull LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) intro, (Object) lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(intro, "intro");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        J2(intro);
        com.tencent.mobileqq.data.troop.b bVar = new com.tencent.mobileqq.data.troop.b(this.troopUin);
        bVar.s(intro);
        r2(this, bVar, lifecycleOwner, "modifyTroopIntro", new Function0<Unit>(intro) { // from class: com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel$modifyTroopIntro$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $intro;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$intro = intro;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopEditInfoViewModel.this, (Object) intro);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopInfo g26 = TroopEditInfoViewModel.this.g2();
                if (g26 == null) {
                    return;
                }
                g26.mRichFingerMemo = this.$intro;
            }
        }, null, 16, null);
    }

    public final void u2(@NotNull com.tencent.mobileqq.data.troop.b modifyInfoTroopCard, @NotNull final String newLocation, @NotNull LifecycleOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, modifyInfoTroopCard, newLocation, owner);
            return;
        }
        Intrinsics.checkNotNullParameter(modifyInfoTroopCard, "modifyInfoTroopCard");
        Intrinsics.checkNotNullParameter(newLocation, "newLocation");
        Intrinsics.checkNotNullParameter(owner, "owner");
        L2(newLocation);
        r2(this, modifyInfoTroopCard, owner, "modifyTroopLocation", new Function0<Unit>(newLocation) { // from class: com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel$modifyTroopLocation$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $newLocation;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$newLocation = newLocation;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopEditInfoViewModel.this, (Object) newLocation);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopInfo g26 = TroopEditInfoViewModel.this.g2();
                if (g26 == null) {
                    return;
                }
                g26.strLocation = this.$newLocation;
            }
        }, null, 16, null);
    }

    public final void v2(@NotNull final String location, final int grade, @NotNull final String school, @NotNull LifecycleOwner lifecycleOwner) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, location, Integer.valueOf(grade), school, lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(school, "school");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        final TroopInfo g26 = g2();
        if (g26 != null) {
            str = g26.location;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, location) && g26.grade == grade && Intrinsics.areEqual(g26.school, school)) {
            QLog.i("EditTroopInfoFragment-VM", 1, "[modifyTroopSchoolInfo] school info not change");
            return;
        }
        O2(z2(grade));
        com.tencent.mobileqq.data.troop.b bVar = new com.tencent.mobileqq.data.troop.b(this.troopUin);
        bVar.p(location);
        bVar.j(Integer.valueOf(grade));
        bVar.o(school);
        r2(this, bVar, lifecycleOwner, "modifyTroopSchoolInfo", new Function0<Unit>(school, grade, location) { // from class: com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel$modifyTroopSchoolInfo$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $grade;
            final /* synthetic */ String $location;
            final /* synthetic */ String $school;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$school = school;
                this.$grade = grade;
                this.$location = location;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopInfo.this, school, Integer.valueOf(grade), location);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopInfo troopInfo = TroopInfo.this;
                if (troopInfo != null) {
                    String str2 = this.$school;
                    int i3 = this.$grade;
                    String str3 = this.$location;
                    troopInfo.school = str2;
                    troopInfo.grade = i3;
                    troopInfo.location = str3;
                }
            }
        }, null, 16, null);
    }

    public final void w2(@NotNull final ArrayList<String> tagList, @NotNull LifecycleOwner lifecycleOwner) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) tagList, (Object) lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        final TroopInfo g26 = g2();
        if (g26 != null) {
            str = g26.mTags;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, TroopInfo.getTagsString(tagList))) {
            QLog.i("EditTroopInfoFragment-VM", 1, "[modifyTroopTags] tags not change");
            return;
        }
        Q2(tagList);
        com.tencent.mobileqq.data.troop.b bVar = new com.tencent.mobileqq.data.troop.b(this.troopUin);
        bVar.r(tagList);
        r2(this, bVar, lifecycleOwner, "modifyTroopTags", new Function0<Unit>(tagList) { // from class: com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel$modifyTroopTags$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<String> $tagList;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$tagList = tagList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInfo.this, (Object) tagList);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopInfo troopInfo = TroopInfo.this;
                if (troopInfo == null) {
                    return;
                }
                troopInfo.mTags = TroopInfo.getTagsString(this.$tagList);
            }
        }, null, 16, null);
    }

    public final void x2(@NotNull String troopName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) troopName);
            return;
        }
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        this._troopNameLiveData.postValue(((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(troopName, 16));
    }
}
