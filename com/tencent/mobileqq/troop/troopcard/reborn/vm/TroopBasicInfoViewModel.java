package com.tencent.mobileqq.troop.troopcard.reborn.vm;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo;
import com.tencent.mobileqq.troop.troopcard.reborn.repo.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFlameData;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ab;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.state.data.SquareJSConst;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f*\u00069=AE\u008e\u0001\u0018\u0000 \u00a3\u00012\u00020\u0001:\u0002\u00a4\u0001B\t\u00a2\u0006\u0006\b\u00a1\u0001\u0010\u00a2\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001b\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0010H\u0002J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0010H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J+\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010)R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00100,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\b008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u0010008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00102R\u001a\u00108\u001a\b\u0012\u0004\u0012\u000206008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00102R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR \u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u00102R#\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I0M8\u0006\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001c\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010S008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u00102R\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0M8\u0006\u00a2\u0006\f\n\u0004\bW\u0010O\u001a\u0004\bX\u0010QR\u001d\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00100M8\u0006\u00a2\u0006\f\n\u0004\bZ\u0010O\u001a\u0004\b[\u0010QR\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020]0M8\u0006\u00a2\u0006\f\n\u0004\b^\u0010O\u001a\u0004\b_\u0010QR\u001d\u0010d\u001a\b\u0012\u0004\u0012\u00020a0M8\u0006\u00a2\u0006\f\n\u0004\bb\u0010O\u001a\u0004\bc\u0010QR\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020e0M8\u0006\u00a2\u0006\f\n\u0004\bf\u0010O\u001a\u0004\bg\u0010QR\u001d\u0010l\u001a\b\u0012\u0004\u0012\u00020i0M8\u0006\u00a2\u0006\f\n\u0004\bj\u0010O\u001a\u0004\bk\u0010QR \u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100I008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u00102R#\u0010q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100I0M8\u0006\u00a2\u0006\f\n\u0004\bo\u0010O\u001a\u0004\bp\u0010QR\u001d\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00100M8\u0006\u00a2\u0006\f\n\u0004\br\u0010O\u001a\u0004\bs\u0010QR\u001d\u0010x\u001a\b\u0012\u0004\u0012\u00020u0M8\u0006\u00a2\u0006\f\n\u0004\bv\u0010O\u001a\u0004\bw\u0010QR\u001c\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010y008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00102R\u001f\u0010}\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010y0M8\u0006\u00a2\u0006\f\n\u0004\b{\u0010O\u001a\u0004\b|\u0010QR\u001f\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020~0M8\u0006\u00a2\u0006\r\n\u0004\b\u007f\u0010O\u001a\u0005\b\u0080\u0001\u0010QR \u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\n0M8\u0006\u00a2\u0006\u000e\n\u0005\b\u0082\u0001\u0010O\u001a\u0005\b\u0083\u0001\u0010QR \u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\n0M8\u0006\u00a2\u0006\u000e\n\u0005\b\u0085\u0001\u0010O\u001a\u0005\b\u0086\u0001\u0010QR \u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\n0M8\u0006\u00a2\u0006\u000e\n\u0005\b\u0088\u0001\u0010O\u001a\u0005\b\u0089\u0001\u0010QR \u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\n0M8\u0006\u00a2\u0006\u000e\n\u0005\b\u008b\u0001\u0010O\u001a\u0005\b\u008c\u0001\u0010QR\u0018\u0010\u0091\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0013\u0010\u0019\u001a\u00020\u00108F\u00a2\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0014\u0010\u0098\u0001\u001a\u00020\n8F\u00a2\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001b\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020\u00100\u0099\u00018F\u00a2\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0016\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00108F\u00a2\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u0093\u0001R\u0014\u0010\u00a0\u0001\u001a\u00020\n8F\u00a2\u0006\b\u001a\u0006\b\u009f\u0001\u0010\u0097\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00a5\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "m3", "Lcom/tencent/common/app/AppInterface;", "appInterface", "Lcom/tencent/mobileqq/troop/data/v;", "troopInfoWrapper", "", "isFromGame", "O2", "P2", "T2", "l3", "", "newTroopName", ICustomDataEditor.NUMBER_PARAM_3, "hok", "o2", "p2", "(Lcom/tencent/mobileqq/troop/data/v;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$e;", "troopAvatarListResult", "troopUin", "N2", "Lcom/tencent/mobileqq/troop/avatar/a;", "info", "v2", "U2", "k3", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$a;", "result", "M2", "(Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/a$a;Lcom/tencent/mobileqq/troop/data/v;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo;", "i", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/TroopCardRepo;", "repo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", BdhLogUtil.LogTag.Tag_Conn, "_isTroopDeleteOrBlock", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "D", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_toastEvent", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "_troopInfoLiveData", UserInfo.SEX_FEMALE, "_cacheNTTroopName", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/l;", "G", "_troopLiveStatus", "com/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$troopLiveStatusObserver$1", "H", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$troopLiveStatusObserver$1;", "troopLiveStatusObserver", "com/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$c", "I", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$c;", "troopEssenceMsgObserver", "com/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$d", "J", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$d;", "troopGameObserver", "com/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$e", "K", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$e;", "troopInfoObserver", "", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/f;", "L", "_troopCoverLiveData", "Landroidx/lifecycle/LiveData;", "M", "Landroidx/lifecycle/LiveData;", NowProxyConstants.AccountInfoKey.A2, "()Landroidx/lifecycle/LiveData;", "troopCoverLiveData", "Lcom/tencent/mobileqq/data/troop/TroopClipPic;", "N", "_troopTroopClipPicInfo", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/d;", "P", "z2", "troopAvatarLiveData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I2", "troopNameLiveData", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtFlameData;", BdhLogUtil.LogTag.Tag_Req, "C2", "troopFlameLiveData", "", ExifInterface.LATITUDE_SOUTH, "B2", "troopCreateTimeLiveData", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/r;", "T", "L2", "troopUinLiveData", "", "U", "H2", "troopMemberCountLiveData", "V", "_troopMemberAvatarLiveData", "W", Constants.MMCCID, "troopMemberAvatarLiveData", "X", "E2", "troopIntroLiveData", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/q;", "Y", "J2", "troopTagsLiveData", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/p;", "_troopMemDistributionLiveData", "a0", "F2", "troopMemDistributionLiveData", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/a;", "b0", "q2", "bottomBtnTypeLiveData", "c0", "t2", "needShowEssenceGuideLiveData", "d0", "u2", "needShowEssenceLiveData", "e0", "w2", "showGameCardPart", "f0", "x2", "showMetaDreamGameCardPart", "com/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$b", "g0", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$b;", "fireMemberObserver", "K2", "()Ljava/lang/String;", Constants.BASE_IN_PLUGIN_VERSION, "()Lcom/tencent/mobileqq/troop/data/v;", "Q2", "()Z", "isTroopMember", "Lkotlinx/coroutines/flow/SharedFlow;", "y2", "()Lkotlinx/coroutines/flow/SharedFlow;", "toastEvent", "r2", "cacheNTTroopName", ICustomDataEditor.STRING_PARAM_2, "hasSetCover", "<init>", "()V", "h0", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopBasicInfoViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean _isTroopDeleteOrBlock;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<String> _toastEvent;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.data.v> _troopInfoLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _cacheNTTroopName;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.l> _troopLiveStatus;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TroopBasicInfoViewModel$troopLiveStatusObserver$1 troopLiveStatusObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final c troopEssenceMsgObserver;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final d troopGameObserver;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final e troopInfoObserver;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f>> _troopCoverLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f>> troopCoverLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopClipPic> _troopTroopClipPicInfo;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d> troopAvatarLiveData;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> troopNameLiveData;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final LiveData<GroupExtFlameData> troopFlameLiveData;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Long> troopCreateTimeLiveData;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.r> troopUinLiveData;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> troopMemberCountLiveData;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<String>> _troopMemberAvatarLiveData;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<String>> troopMemberAvatarLiveData;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> troopIntroLiveData;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.q> troopTagsLiveData;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.p> _troopMemDistributionLiveData;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.p> troopMemDistributionLiveData;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a> bottomBtnTypeLiveData;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> needShowEssenceGuideLiveData;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> needShowEssenceLiveData;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showGameCardPart;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showMetaDreamGameCardPart;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b fireMemberObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopCardRepo repo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isFromGame;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$a;", "", "", "DEFAULT_TROOP_COVER_URL", "Ljava/lang/String;", "TAG", "", "TOP_N_MEMBER_UIN", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$b", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", "isSuccess", "", "errorCode", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "troopuin", "", "onDeleteTroopMember", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopBasicInfoViewModel.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onDeleteTroopMember(boolean isSuccess, int errorCode, @Nullable ArrayList<String> uinList, @Nullable String troopuin) {
            AppRuntime peekAppRuntime;
            com.tencent.mobileqq.troop.data.v vVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Integer.valueOf(errorCode), uinList, troopuin);
                return;
            }
            if (troopuin == null || !Intrinsics.areEqual(troopuin, TroopBasicInfoViewModel.this.K2()) || !isSuccess || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                return;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026nt.MAIN\n                )");
            TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(TroopBasicInfoViewModel.this.K2());
            if (findTroopInfo != null) {
                MutableLiveData mutableLiveData = TroopBasicInfoViewModel.this._troopInfoLiveData;
                com.tencent.mobileqq.troop.data.v vVar2 = (com.tencent.mobileqq.troop.data.v) TroopBasicInfoViewModel.this._troopInfoLiveData.getValue();
                if (vVar2 != null) {
                    vVar = com.tencent.mobileqq.troop.data.v.b(vVar2, findTroopInfo, false, null, 0, 0, null, 0, 0, null, 510, null);
                } else {
                    vVar = null;
                }
                mutableLiveData.setValue(vVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$c", "Lcom/tencent/mobileqq/troop/observer/f;", "", "isSuccess", "", "troopUinResult", "isCheck", "", "f", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends com.tencent.mobileqq.troop.observer.f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopBasicInfoViewModel.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.troop.observer.f
        protected void f(boolean isSuccess, @Nullable String troopUinResult, boolean isCheck) {
            com.tencent.mobileqq.troop.data.v vVar;
            TroopInfo i3;
            com.tencent.mobileqq.troop.data.v vVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUinResult, Boolean.valueOf(isCheck));
                return;
            }
            if (Intrinsics.areEqual(TroopBasicInfoViewModel.this.K2(), troopUinResult) && (vVar = (com.tencent.mobileqq.troop.data.v) TroopBasicInfoViewModel.this._troopInfoLiveData.getValue()) != null && (i3 = vVar.i()) != null) {
                i3.groupExt.essentialMsgSwitch = isCheck ? 1 : 0;
                MutableLiveData mutableLiveData = TroopBasicInfoViewModel.this._troopInfoLiveData;
                com.tencent.mobileqq.troop.data.v vVar3 = (com.tencent.mobileqq.troop.data.v) TroopBasicInfoViewModel.this._troopInfoLiveData.getValue();
                if (vVar3 != null) {
                    vVar2 = com.tencent.mobileqq.troop.data.v.b(vVar3, i3, false, null, 0, 0, null, 0, 0, null, 510, null);
                } else {
                    vVar2 = null;
                }
                mutableLiveData.setValue(vVar2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$d", "Lcom/tencent/mobileqq/troop/troopgame/api/b;", "", "isSuccess", "", "uin", "errCode", "", "errInfo", "", "onModifyTroopGameCardSwitch", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d extends com.tencent.mobileqq.troop.troopgame.api.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopBasicInfoViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.api.b
        protected void onModifyTroopGameCardSwitch(boolean isSuccess, long uin, long errCode, @Nullable String errInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Long.valueOf(uin), Long.valueOf(errCode), errInfo);
            } else {
                TroopBasicInfoViewModel.this._troopInfoLiveData.setValue(TroopBasicInfoViewModel.this._troopInfoLiveData.getValue());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel$e", "Lcom/tencent/qqnt/troop/ab;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class e implements ab {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopBasicInfoViewModel.this);
            }
        }

        @Override // com.tencent.qqnt.troop.ab
        public void a(@NotNull TroopInfo troopInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
            if (Intrinsics.areEqual(troopInfo.getTroopUin(), TroopBasicInfoViewModel.this.K2()) && !TextUtils.isEmpty(troopInfo.troopNameFromNT) && !Intrinsics.areEqual(troopInfo.troopNameFromNT, TroopBasicInfoViewModel.this.r2())) {
                TroopBasicInfoViewModel.this._cacheNTTroopName.postValue(troopInfo.troopNameFromNT);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57366);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopLiveStatusObserver$1] */
    public TroopBasicInfoViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.repo = new TroopCardRepo();
        this._toastEvent = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        MutableLiveData<com.tencent.mobileqq.troop.data.v> mutableLiveData = new MutableLiveData<>();
        this._troopInfoLiveData = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._cacheNTTroopName = mutableLiveData2;
        MutableLiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.l> mutableLiveData3 = new MutableLiveData<>();
        this._troopLiveStatus = mutableLiveData3;
        this.troopLiveStatusObserver = new com.tencent.mobileqq.troop.api.observer.f() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopLiveStatusObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopBasicInfoViewModel.this);
                }
            }

            @Override // com.tencent.mobileqq.troop.api.observer.f
            protected void e(@Nullable String troopUin, boolean isLiving) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                boolean z16 = false;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, troopUin, Boolean.valueOf(isLiving));
                    return;
                }
                QLog.i("TroopBasicInfoViewModel", 1, "onTroopLiveStatusChanged push, troopUin=" + troopUin + ", isLiving=" + isLiving);
                if (troopUin == null || troopUin.length() == 0) {
                    z16 = true;
                }
                if (!z16 && Intrinsics.areEqual(troopUin, TroopBasicInfoViewModel.this.K2())) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(TroopBasicInfoViewModel.this), null, null, new TroopBasicInfoViewModel$troopLiveStatusObserver$1$onTroopLiveStatusChanged$1(TroopBasicInfoViewModel.this, troopUin, null), 3, null);
                }
            }
        };
        this.troopEssenceMsgObserver = new c();
        this.troopGameObserver = new d();
        this.troopInfoObserver = new e();
        MutableLiveData<List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f>> mutableLiveData4 = new MutableLiveData<>();
        this._troopCoverLiveData = mutableLiveData4;
        this.troopCoverLiveData = mutableLiveData4;
        MutableLiveData<TroopClipPic> mutableLiveData5 = new MutableLiveData<>();
        this._troopTroopClipPicInfo = mutableLiveData5;
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function1 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopAvatarLiveData$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
            
                if (r4 == null) goto L21;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(com.tencent.mobileqq.troop.data.v vVar) {
                com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d dVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) vVar);
                    return;
                }
                com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d value = this.$this_apply.getValue();
                if (value != null) {
                    String troopUin = vVar.i().getTroopUin();
                    if (troopUin == null) {
                        troopUin = "";
                    }
                    dVar = com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d.b(value, troopUin, vVar.i().hasSetNewTroopHead, vVar.i().isMember(), vVar.i().isOwnerOrAdmin() && vVar.i().hadJoinTroop(), null, null, 48, null);
                }
                String troopUin2 = vVar.i().getTroopUin();
                dVar = new com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d(troopUin2 == null ? "" : troopUin2, vVar.i().hasSetNewTroopHead, vVar.i().isMember(), vVar.i().isOwnerOrAdmin() && vVar.i().hadJoinTroop(), null, null, 48, null);
                com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this.$this_apply, dVar);
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.Y2(Function1.this, obj);
            }
        });
        final Function1<TroopClipPic, Unit> function12 = new Function1<TroopClipPic, Unit>(mediatorLiveData) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopAvatarLiveData$1$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopClipPic troopClipPic) {
                invoke2(troopClipPic);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TroopClipPic troopClipPic) {
                com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d b16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopClipPic);
                    return;
                }
                com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d value = this.$this_apply.getValue();
                if (value == null || (b16 = com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d.b(value, null, false, false, false, null, troopClipPic, 31, null)) == null) {
                    return;
                }
                com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this.$this_apply, b16);
            }
        };
        mediatorLiveData.addSource(mutableLiveData5, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.a3(Function1.this, obj);
            }
        });
        final Function1<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.l, Unit> function13 = new Function1<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.l, Unit>(mediatorLiveData) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopAvatarLiveData$1$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.l lVar) {
                invoke2(lVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.l livingUIModel) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) livingUIModel);
                    return;
                }
                com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d value = this.$this_apply.getValue();
                if (value != null) {
                    Intrinsics.checkNotNullExpressionValue(livingUIModel, "livingUIModel");
                    com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d b16 = com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d.b(value, null, false, false, false, livingUIModel, null, 47, null);
                    if (b16 != null) {
                        com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this.$this_apply, b16);
                    }
                }
            }
        };
        mediatorLiveData.addSource(mutableLiveData3, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.b3(Function1.this, obj);
            }
        });
        this.troopAvatarLiveData = mediatorLiveData;
        final MediatorLiveData mediatorLiveData2 = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function14 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData2) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopNameLiveData$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<String> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopBasicInfoViewModel.this, (Object) mediatorLiveData2);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.data.v vVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) vVar);
                    return;
                }
                String str = (String) TroopBasicInfoViewModel.this._cacheNTTroopName.getValue();
                if (str == null) {
                    str = "";
                }
                com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this.$this_apply, com.tencent.mobileqq.troop.troopsetting.modules.base.b.c(vVar.i(), str));
            }
        };
        mediatorLiveData2.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.g3(Function1.this, obj);
            }
        });
        final Function1<String, Unit> function15 = new Function1<String, Unit>(mediatorLiveData2) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopNameLiveData$1$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<String> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopBasicInfoViewModel.this, (Object) mediatorLiveData2);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String ntCachedName) {
                TroopInfo i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) ntCachedName);
                    return;
                }
                com.tencent.mobileqq.troop.data.v D2 = TroopBasicInfoViewModel.this.D2();
                if (D2 == null || (i3 = D2.i()) == null) {
                    return;
                }
                MediatorLiveData<String> mediatorLiveData3 = this.$this_apply;
                Intrinsics.checkNotNullExpressionValue(ntCachedName, "ntCachedName");
                com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(mediatorLiveData3, com.tencent.mobileqq.troop.troopsetting.modules.base.b.c(i3, ntCachedName));
            }
        };
        mediatorLiveData2.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.h3(Function1.this, obj);
            }
        });
        this.troopNameLiveData = mediatorLiveData2;
        final MediatorLiveData mediatorLiveData3 = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function16 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData3) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopFlameLiveData$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<GroupExtFlameData> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData3);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.data.v vVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) vVar);
                } else {
                    com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this.$this_apply, vVar.i().groupExt.groupExtFlameData);
                }
            }
        };
        mediatorLiveData3.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.d3(Function1.this, obj);
            }
        });
        this.troopFlameLiveData = mediatorLiveData3;
        final MediatorLiveData mediatorLiveData4 = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function17 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData4) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopCreateTimeLiveData$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<Long> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData4);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.data.v vVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this.$this_apply, Long.valueOf(vVar.i().troopCreateTime));
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) vVar);
                }
            }
        };
        mediatorLiveData4.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.c3(Function1.this, obj);
            }
        });
        this.troopCreateTimeLiveData = mediatorLiveData4;
        final MediatorLiveData mediatorLiveData5 = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function18 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData5) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopUinLiveData$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.r> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.data.v vVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this.$this_apply, com.tencent.mobileqq.troop.troopcard.reborn.uimodel.k.a(vVar.i()));
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) vVar);
                }
            }
        };
        mediatorLiveData5.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.j3(Function1.this, obj);
            }
        });
        this.troopUinLiveData = mediatorLiveData5;
        final MediatorLiveData mediatorLiveData6 = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function19 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData6) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopMemberCountLiveData$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<Integer> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData6);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.data.v vVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this.$this_apply, Integer.valueOf(vVar.i().wMemberNum));
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) vVar);
                }
            }
        };
        mediatorLiveData6.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.f3(Function1.this, obj);
            }
        });
        this.troopMemberCountLiveData = mediatorLiveData6;
        MutableLiveData<List<String>> mutableLiveData6 = new MutableLiveData<>();
        this._troopMemberAvatarLiveData = mutableLiveData6;
        this.troopMemberAvatarLiveData = mutableLiveData6;
        final MediatorLiveData mediatorLiveData7 = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function110 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData7) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopIntroLiveData$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<String> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData7;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData7);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.data.v vVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) vVar);
                    return;
                }
                MediatorLiveData<String> mediatorLiveData8 = this.$this_apply;
                String str = vVar.i().mRichFingerMemo;
                if (str == null) {
                    str = "";
                }
                com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(mediatorLiveData8, str);
            }
        };
        mediatorLiveData7.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.e3(Function1.this, obj);
            }
        });
        this.troopIntroLiveData = mediatorLiveData7;
        final MediatorLiveData mediatorLiveData8 = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function111 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData8) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$troopTagsLiveData$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.q> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData8;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData8);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.data.v troopInfoWrapper) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopInfoWrapper);
                    return;
                }
                com.tencent.mobileqq.troop.troopsetting.modules.base.b bVar = com.tencent.mobileqq.troop.troopsetting.modules.base.b.f301142a;
                List<String> a16 = bVar.a(troopInfoWrapper.i());
                Intrinsics.checkNotNullExpressionValue(troopInfoWrapper, "troopInfoWrapper");
                com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this.$this_apply, new com.tencent.mobileqq.troop.troopcard.reborn.uimodel.q(a16, com.tencent.mobileqq.troop.troopcard.reborn.uimodel.s.a(troopInfoWrapper), bVar.f(troopInfoWrapper.i())));
            }
        };
        mediatorLiveData8.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.i3(Function1.this, obj);
            }
        });
        this.troopTagsLiveData = mediatorLiveData8;
        MutableLiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.p> mutableLiveData7 = new MutableLiveData<>();
        this._troopMemDistributionLiveData = mutableLiveData7;
        this.troopMemDistributionLiveData = mutableLiveData7;
        final MediatorLiveData mediatorLiveData9 = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function112 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData9, this) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$bottomBtnTypeLiveData$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a> $this_apply;
            final /* synthetic */ TroopBasicInfoViewModel this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData9;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData9, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.data.v troopInfoWrapper) {
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopInfoWrapper);
                    return;
                }
                MediatorLiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a> mediatorLiveData10 = this.$this_apply;
                Intrinsics.checkNotNullExpressionValue(troopInfoWrapper, "troopInfoWrapper");
                z16 = this.this$0.isFromGame;
                com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(mediatorLiveData10, com.tencent.mobileqq.troop.troopcard.reborn.uimodel.b.a(troopInfoWrapper, z16));
            }
        };
        mediatorLiveData9.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.n2(Function1.this, obj);
            }
        });
        this.bottomBtnTypeLiveData = mediatorLiveData9;
        final MediatorLiveData mediatorLiveData10 = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function113 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData10) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$needShowEssenceGuideLiveData$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<Boolean> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData10;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData10);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.data.v vVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) vVar);
                    return;
                }
                boolean z16 = false;
                boolean z17 = vVar.i().groupExt.essentialMsgSwitch != 0;
                boolean isOwnerOrAdmin = vVar.i().isOwnerOrAdmin();
                boolean a16 = com.tencent.mobileqq.troop.troopcard.reborn.ktx.d.a();
                QLog.i("TroopBasicInfoViewModel", 1, "needShowEssenceGuideLiveData, essenceSwitch=" + z17 + ",isAdmin=" + isOwnerOrAdmin + ",showTroopInfoEssenceGuide=" + a16);
                MediatorLiveData<Boolean> mediatorLiveData11 = this.$this_apply;
                if (!z17 && isOwnerOrAdmin && a16) {
                    z16 = true;
                }
                com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(mediatorLiveData11, Boolean.valueOf(z16));
            }
        };
        mediatorLiveData10.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.R2(Function1.this, obj);
            }
        });
        this.needShowEssenceGuideLiveData = mediatorLiveData10;
        final MediatorLiveData mediatorLiveData11 = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function114 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData11) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$needShowEssenceLiveData$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<Boolean> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData11;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData11);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.data.v vVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) vVar);
                } else {
                    com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this.$this_apply, Boolean.valueOf(vVar.i().groupExt.essentialMsgSwitch == 1));
                }
            }
        };
        mediatorLiveData11.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.S2(Function1.this, obj);
            }
        });
        this.needShowEssenceLiveData = mediatorLiveData11;
        final MediatorLiveData mediatorLiveData12 = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function115 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData12, this) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$showGameCardPart$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<Boolean> $this_apply;
            final /* synthetic */ TroopBasicInfoViewModel this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData12;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData12, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.data.v it) {
                boolean o26;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                MediatorLiveData<Boolean> mediatorLiveData13 = this.$this_apply;
                TroopBasicInfoViewModel troopBasicInfoViewModel = this.this$0;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                o26 = troopBasicInfoViewModel.o2(true, it);
                com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(mediatorLiveData13, Boolean.valueOf(o26));
            }
        };
        mediatorLiveData12.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.V2(Function1.this, obj);
            }
        });
        this.showGameCardPart = mediatorLiveData12;
        final MediatorLiveData mediatorLiveData13 = new MediatorLiveData();
        final Function1<com.tencent.mobileqq.troop.data.v, Unit> function116 = new Function1<com.tencent.mobileqq.troop.data.v, Unit>(mediatorLiveData13, this) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$showMetaDreamGameCardPart$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MediatorLiveData<Boolean> $this_apply;
            final /* synthetic */ TroopBasicInfoViewModel this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = mediatorLiveData13;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData13, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.data.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.data.v it) {
                boolean o26;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                MediatorLiveData<Boolean> mediatorLiveData14 = this.$this_apply;
                TroopBasicInfoViewModel troopBasicInfoViewModel = this.this$0;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                o26 = troopBasicInfoViewModel.o2(false, it);
                com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(mediatorLiveData14, Boolean.valueOf(o26));
            }
        };
        mediatorLiveData13.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBasicInfoViewModel.W2(Function1.this, obj);
            }
        });
        this.showMetaDreamGameCardPart = mediatorLiveData13;
        this.fireMemberObserver = new b();
    }

    private final Object M2(a.C8792a c8792a, com.tencent.mobileqq.troop.data.v vVar, String str, Continuation<? super Unit> continuation) {
        com.tencent.mobileqq.troop.data.v vVar2;
        List mutableList;
        List shuffled;
        List<String> take;
        Object coroutine_suspended;
        this._isTroopDeleteOrBlock = c8792a.c();
        String str2 = "";
        if (c8792a.c()) {
            MutableLiveData<String> mutableLiveData = this._cacheNTTroopName;
            String str3 = c8792a.b().troopNameFromNT;
            if (str3 != null) {
                str2 = str3;
            }
            mutableLiveData.postValue(str2);
            MutableSharedFlow<String> mutableSharedFlow = this._toastEvent;
            String string = MobileQQ.sMobileQQ.getApplicationContext().getString(R.string.bnu);
            Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.applicationCon\u2026oup_not_exit_or_dissolve)");
            Object emit = mutableSharedFlow.emit(string, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (emit == coroutine_suspended) {
                return emit;
            }
            return Unit.INSTANCE;
        }
        if (!c8792a.d()) {
            return Unit.INSTANCE;
        }
        MutableLiveData<com.tencent.mobileqq.troop.data.v> mutableLiveData2 = this._troopInfoLiveData;
        com.tencent.mobileqq.troop.data.v value = mutableLiveData2.getValue();
        if (value != null) {
            vVar2 = com.tencent.mobileqq.troop.data.v.b(value, c8792a.b(), false, null, 0, c8792a.b().activeMemberNum, null, 0, 0, null, 494, null);
        } else {
            vVar2 = null;
        }
        mutableLiveData2.setValue(vVar2);
        MutableLiveData<String> mutableLiveData3 = this._cacheNTTroopName;
        String str4 = c8792a.b().troopNameFromNT;
        if (str4 != null) {
            str2 = str4;
        }
        mutableLiveData3.postValue(str2);
        TroopInfo b16 = c8792a.b();
        if (QLog.isColorLevel()) {
            short s16 = b16.cGroupOption;
            QLog.i("TroopBasicInfoViewModel", 2, "[handleBatchTroopInfoResult] cGroupOption:" + ((int) s16) + ", troopPrivilegeFlag:" + b16.troopPrivilegeFlag + ", dwGroupFlagExt:" + b16.dwGroupFlagExt + ", isAdmin:" + b16.isOwnerOrAdmin() + ", isOwner:" + b16.isOwner());
        }
        if (vVar.i().isMember()) {
            MutableLiveData<List<String>> mutableLiveData4 = this._troopMemberAvatarLiveData;
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) c8792a.a());
            shuffled = CollectionsKt__CollectionsJVMKt.shuffled(mutableList);
            take = CollectionsKt___CollectionsKt.take(shuffled, 3);
            mutableLiveData4.setValue(take);
            TroopMemberExtInfoRepo troopMemberExtInfoRepo = TroopMemberExtInfoRepo.INSTANCE;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(c8792a.a());
            Unit unit = Unit.INSTANCE;
            ITroopMemberExtInfoRepoApi.a.a(troopMemberExtInfoRepo, str, arrayList, true, null, null, null, 48, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v10, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v6, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v8, types: [T, java.lang.Object, java.lang.String] */
    public final void N2(a.e troopAvatarListResult, String troopUin) {
        Context context;
        boolean z16;
        Object obj;
        int collectionSizeOrDefault;
        List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f> mutableList;
        boolean z17;
        boolean z18;
        boolean z19 = true;
        if (!troopAvatarListResult.d()) {
            QLog.e("TroopBasicInfoViewModel", 1, "handleTroopAvatarResult, fail");
            return;
        }
        if (troopAvatarListResult.a() == 0) {
            Iterator<T> it = troopAvatarListResult.c().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((TroopClipPic) obj).type == 1) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            TroopClipPic troopClipPic = (TroopClipPic) obj;
            if (troopClipPic == null) {
                troopClipPic = new TroopClipPic();
                troopClipPic.f203184id = com.tencent.mobileqq.troop.avatar.a.f294527k;
                troopClipPic.type = 1;
            }
            this._troopTroopClipPicInfo.setValue(troopClipPic);
            List<TroopClipPic> c16 = troopAvatarListResult.c();
            ArrayList<TroopClipPic> arrayList = new ArrayList();
            for (Object obj2 : c16) {
                if (((TroopClipPic) obj2).type == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(obj2);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (TroopClipPic troopClipPic2 : arrayList) {
                com.tencent.mobileqq.troop.avatar.a info = com.tencent.mobileqq.troop.avatar.a.b(troopClipPic2, null);
                Intrinsics.checkNotNullExpressionValue(info, "info");
                arrayList2.add(new com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f(v2(info, troopUin), troopClipPic2));
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
            if (mutableList.isEmpty()) {
                mutableList.add(new com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f("https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/XeGeNJ7x.png", null));
            }
            this._troopCoverLiveData.setValue(mutableList);
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = troopAvatarListResult.b();
        int a16 = troopAvatarListResult.a();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            context = peekAppRuntime.getApplicationContext();
        } else {
            context = null;
        }
        if (context == null) {
            return;
        }
        if (((CharSequence) objectRef.element).length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (a16 != 1 && a16 != 2) {
                if (a16 != 19) {
                    if (a16 == 65) {
                        ?? string = context.getString(R.string.dpi);
                        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026vatarwall_0x88d_time_out)");
                        objectRef.element = string;
                    }
                } else {
                    ?? string2 = context.getString(R.string.dph);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026l_0x88d_not_group_number)");
                    objectRef.element = string2;
                }
            } else {
                ?? string3 = context.getString(R.string.dpj);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(com.te\u2026all_0x88d_troopuin_error)");
                objectRef.element = string3;
            }
        }
        if (((CharSequence) objectRef.element).length() != 0) {
            z19 = false;
        }
        if (z19) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopBasicInfoViewModel$handleTroopAvatarCoverResult$2(this, objectRef, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void U2(AppInterface appInterface) {
        appInterface.addObserver(this.troopLiveStatusObserver);
        appInterface.addObserver(this.fireMemberObserver);
        appInterface.addObserver(this.troopEssenceMsgObserver);
        appInterface.addObserver(this.troopGameObserver);
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).registerTroopInfoChangedObserver(null, this.troopInfoObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void k3(AppInterface appInterface) {
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).unregisterTroopInfoChangedObserver(this.troopInfoObserver);
        appInterface.removeObserver(this.troopLiveStatusObserver);
        appInterface.removeObserver(this.troopEssenceMsgObserver);
        appInterface.removeObserver(this.fireMemberObserver);
        appInterface.removeObserver(this.troopGameObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o2(boolean hok, com.tencent.mobileqq.troop.data.v troopInfoWrapper) {
        boolean isTroopMDGameCardEnabled;
        if (hok) {
            isTroopMDGameCardEnabled = troopInfoWrapper.i().isTroopHOKGameCardEnabled();
        } else {
            isTroopMDGameCardEnabled = troopInfoWrapper.i().isTroopMDGameCardEnabled();
        }
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        boolean isHomeworkTroop = troopInfoWrapper.i().isHomeworkTroop();
        if (QLog.isColorLevel()) {
            QLog.d("TroopBasicInfoViewModel", 1, "troopGameCardEnabled(hok=" + hok + "):" + isTroopMDGameCardEnabled + ", isStudyMode:" + studyModeSwitch + ", isHwTroop:" + isHomeworkTroop);
        }
        if (isTroopMDGameCardEnabled && !studyModeSwitch && !isHomeworkTroop) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p2(com.tencent.mobileqq.troop.data.v vVar, Continuation<? super Unit> continuation) {
        TroopBasicInfoViewModel$fetchBachTroopInfo$1 troopBasicInfoViewModel$fetchBachTroopInfo$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        TroopBasicInfoViewModel troopBasicInfoViewModel;
        String K2;
        if (continuation instanceof TroopBasicInfoViewModel$fetchBachTroopInfo$1) {
            troopBasicInfoViewModel$fetchBachTroopInfo$1 = (TroopBasicInfoViewModel$fetchBachTroopInfo$1) continuation;
            int i16 = troopBasicInfoViewModel$fetchBachTroopInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                troopBasicInfoViewModel$fetchBachTroopInfo$1.label = i16 - Integer.MIN_VALUE;
                obj = troopBasicInfoViewModel$fetchBachTroopInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = troopBasicInfoViewModel$fetchBachTroopInfo$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    vVar = (com.tencent.mobileqq.troop.data.v) troopBasicInfoViewModel$fetchBachTroopInfo$1.L$1;
                    troopBasicInfoViewModel = (TroopBasicInfoViewModel) troopBasicInfoViewModel$fetchBachTroopInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    TroopCardRepo troopCardRepo = this.repo;
                    String K22 = K2();
                    String str = vVar.i().troopowneruin;
                    if (str == null) {
                        str = "";
                    }
                    boolean isMember = vVar.i().isMember();
                    troopBasicInfoViewModel$fetchBachTroopInfo$1.L$0 = this;
                    troopBasicInfoViewModel$fetchBachTroopInfo$1.L$1 = vVar;
                    troopBasicInfoViewModel$fetchBachTroopInfo$1.label = 1;
                    obj = troopCardRepo.j(K22, str, isMember, 0, troopBasicInfoViewModel$fetchBachTroopInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    troopBasicInfoViewModel = this;
                }
                K2 = troopBasicInfoViewModel.K2();
                troopBasicInfoViewModel$fetchBachTroopInfo$1.L$0 = null;
                troopBasicInfoViewModel$fetchBachTroopInfo$1.L$1 = null;
                troopBasicInfoViewModel$fetchBachTroopInfo$1.label = 2;
                if (troopBasicInfoViewModel.M2((a.C8792a) obj, vVar, K2, troopBasicInfoViewModel$fetchBachTroopInfo$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        troopBasicInfoViewModel$fetchBachTroopInfo$1 = new TroopBasicInfoViewModel$fetchBachTroopInfo$1(this, continuation);
        obj = troopBasicInfoViewModel$fetchBachTroopInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = troopBasicInfoViewModel$fetchBachTroopInfo$1.label;
        if (i3 == 0) {
        }
        K2 = troopBasicInfoViewModel.K2();
        troopBasicInfoViewModel$fetchBachTroopInfo$1.L$0 = null;
        troopBasicInfoViewModel$fetchBachTroopInfo$1.L$1 = null;
        troopBasicInfoViewModel$fetchBachTroopInfo$1.label = 2;
        if (troopBasicInfoViewModel.M2((a.C8792a) obj, vVar, K2, troopBasicInfoViewModel$fetchBachTroopInfo$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    private final String v2(com.tencent.mobileqq.troop.avatar.a info, String troopUin) {
        int i3 = info.f294531c;
        QRouteApi api = QRoute.api(ITroopAvatarUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n            ITroopA\u2026Api::class.java\n        )");
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

    @NotNull
    public final LiveData<List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f>> A2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.troopCoverLiveData;
    }

    @NotNull
    public final LiveData<Long> B2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (LiveData) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.troopCreateTimeLiveData;
    }

    @NotNull
    public final LiveData<GroupExtFlameData> C2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (LiveData) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.troopFlameLiveData;
    }

    @Nullable
    public final com.tencent.mobileqq.troop.data.v D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.troop.data.v) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this._troopInfoLiveData.getValue();
    }

    @NotNull
    public final LiveData<String> E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (LiveData) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.troopIntroLiveData;
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.p> F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (LiveData) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.troopMemDistributionLiveData;
    }

    @NotNull
    public final LiveData<List<String>> G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (LiveData) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.troopMemberAvatarLiveData;
    }

    @NotNull
    public final LiveData<Integer> H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (LiveData) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.troopMemberCountLiveData;
    }

    @NotNull
    public final LiveData<String> I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (LiveData) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.troopNameLiveData;
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.q> J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (LiveData) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.troopTagsLiveData;
    }

    @NotNull
    public final String K2() {
        String str;
        TroopInfo i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.troop.data.v value = this._troopInfoLiveData.getValue();
        if (value != null && (i3 = value.i()) != null) {
            str = i3.getTroopUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.r> L2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (LiveData) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.troopUinLiveData;
    }

    public final void O2(@NotNull AppInterface appInterface, @NotNull com.tencent.mobileqq.troop.data.v troopInfoWrapper, boolean isFromGame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, appInterface, troopInfoWrapper, Boolean.valueOf(isFromGame));
            return;
        }
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Intrinsics.checkNotNullParameter(troopInfoWrapper, "troopInfoWrapper");
        U2(appInterface);
        String troopUin = troopInfoWrapper.i().getTroopUin();
        if (troopUin == null) {
            troopUin = "";
        }
        String str = troopUin;
        this.isFromGame = isFromGame;
        this._troopInfoLiveData.setValue(troopInfoWrapper);
        l3();
        boolean P2 = P2();
        if (QLog.isColorLevel()) {
            QLog.i("TroopBasicInfoViewModel", 2, "[initTroopInfo] troopUin:" + str + ", blockedOrDelete:" + P2);
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopBasicInfoViewModel$initTroopInfo$1(P2, this, troopInfoWrapper, str, null), 3, null);
    }

    public final boolean P2() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(K2());
        if (troopInfoFromCache != null && troopInfoFromCache.isNeedInterceptOnBlockTroop()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || this._isTroopDeleteOrBlock) {
            return true;
        }
        return false;
    }

    public final boolean Q2() {
        TroopInfo i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.troop.data.v D2 = D2();
        if (D2 == null || (i3 = D2.i()) == null || !i3.isMember()) {
            return false;
        }
        return true;
    }

    public final void T2(@NotNull AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) appInterface);
        } else {
            Intrinsics.checkNotNullParameter(appInterface, "appInterface");
            k3(appInterface);
        }
    }

    public final void l3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.data.v D2 = D2();
        if (D2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getAllPicFromDb(arrayList, D2.i());
        N2(new a.e(true, 0, "", arrayList), K2());
    }

    public final void m3(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) troopInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        com.tencent.mobileqq.troop.data.v value = this._troopInfoLiveData.getValue();
        if (value == null) {
            return;
        }
        this._troopInfoLiveData.setValue(com.tencent.mobileqq.troop.data.v.b(value, troopInfo, false, null, 0, 0, null, 0, 0, null, 510, null));
    }

    public final void n3(@NotNull String newTroopName) {
        TroopInfo i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) newTroopName);
            return;
        }
        Intrinsics.checkNotNullParameter(newTroopName, "newTroopName");
        com.tencent.mobileqq.troop.data.v D2 = D2();
        if (D2 != null && (i3 = D2.i()) != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopBasicInfoViewModel$updateTroopName$1(this, i3, newTroopName, null), 3, null);
        }
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a> q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (LiveData) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.bottomBtnTypeLiveData;
    }

    @Nullable
    public final String r2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this._cacheNTTroopName.getValue();
    }

    public final boolean s2() {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f> value = this._troopCoverLiveData.getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        if (!value.isEmpty()) {
            if (value.size() == 1) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) value);
                if (!Intrinsics.areEqual(((com.tencent.mobileqq.troop.troopcard.reborn.uimodel.f) first).a(), "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/XeGeNJ7x.png")) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final LiveData<Boolean> t2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (LiveData) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.needShowEssenceGuideLiveData;
    }

    @NotNull
    public final LiveData<Boolean> u2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (LiveData) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.needShowEssenceLiveData;
    }

    @NotNull
    public final LiveData<Boolean> w2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (LiveData) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.showGameCardPart;
    }

    @NotNull
    public final LiveData<Boolean> x2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (LiveData) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.showMetaDreamGameCardPart;
    }

    @NotNull
    public final SharedFlow<String> y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SharedFlow) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return FlowKt.asSharedFlow(this._toastEvent);
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.d> z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.troopAvatarLiveData;
    }
}
