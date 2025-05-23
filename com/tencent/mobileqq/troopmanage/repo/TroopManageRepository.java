package com.tencent.mobileqq.troopmanage.repo;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.dh;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickUIInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.handler.TroopPushHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.jointype.event.TroopManageAutoApprovalEvent;
import com.tencent.mobileqq.troop.troopurl.config.TroopUrlConfProcessor;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.troopmanage.ITroopManageApi;
import com.tencent.mobileqq.troopmanage.activity.TroopSetJoinTypeActivity;
import com.tencent.mobileqq.troopmanage.api.ITroopManageService;
import com.tencent.mobileqq.troopmanage.base.TroopManageRemoteHandler;
import com.tencent.mobileqq.troopmanage.event.TroopManageAdminListEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageAuthEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageGetHeadEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageGetSmartEntranceEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageModifyTroopGameCardSwitchEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManagePrettyEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageSetLuckyCharacterSwitchEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageSetTroopEssenceMsgShowEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageSpeechLimitEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageTransferTroopMembersEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageTroopFeedEvent;
import com.tencent.mobileqq.troopmanage.event.TroopSetInviteRobotSwitchEvent;
import com.tencent.mobileqq.troopmanage.pb.PrettyTroopEntry;
import com.tencent.mobileqq.troopmanage.repo.TroopManageRepository;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troop.ab;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.state.data.SquareJSConst;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\njmpsvy|\u007f\u0082\u0001\u0018\u0000 =2\u00020\u0001:\u0001&B\t\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J*\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J$\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0014\u0010\u001d\u001a\u00020\u0014*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\"\u0010\"\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\u0019H\u0016J\u0018\u0010+\u001a\u00020\u00142\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020\u0014H\u0016JK\u00106\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2!\u00105\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u001401H\u0016J\b\u00108\u001a\u000207H\u0016J\u0010\u00109\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u000eH\u0016J\b\u0010:\u001a\u00020\u0014H\u0016J\b\u0010;\u001a\u00020\u0014H\u0016J \u0010=\u001a\u00020\u00142\u0006\u0010!\u001a\u00020 2\u0006\u0010<\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J \u0010A\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u000eH\u0016J\u0010\u0010C\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\u0019H\u0016J\u0016\u0010E\u001a\u00020\u00142\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016JC\u0010J\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u000e2!\u0010I\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\u001401H\u0016J8\u0010Q\u001a\u00020\u00142\u0006\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\u000eH\u0016J=\u0010T\u001a\u00020\u00142\b\u0010?\u001a\u0004\u0018\u00010\u00062\u0006\u0010R\u001a\u00020\u000e2!\u0010I\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u001401H\u0016J=\u0010U\u001a\u00020\u00142\b\u0010?\u001a\u0004\u0018\u00010\u00062\u0006\u0010R\u001a\u00020\u000e2!\u0010I\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u001401H\u0016J\u0010\u0010W\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u0019H\u0016R\u0016\u0010Y\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010XR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00060Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010[R$\u0010`\u001a\u0012\u0012\u0004\u0012\u00020\u00060]j\b\u0012\u0004\u0012\u00020\u0006`^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010_R\u0016\u0010a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\tR\u0016\u0010b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\tR\u001c\u0010f\u001a\n d*\u0004\u0018\u00010c0c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010eR\u0014\u0010i\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010hR\u0014\u0010l\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010kR\u0014\u0010o\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010nR\u0014\u0010r\u001a\u00020p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010qR\u0014\u0010u\u001a\u00020s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010tR\u0014\u0010x\u001a\u00020v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010wR\u0014\u0010{\u001a\u00020y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010zR\u0014\u0010~\u001a\u00020|8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010}R\u0016\u0010\u0081\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bT\u0010\u0080\u0001R\u0017\u0010\u0084\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b'\u0010\u0083\u0001R\u0017\u0010\u0087\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bW\u0010\u0086\u0001\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/repo/TroopManageRepository;", "Lcom/tencent/mobileqq/troopmanage/repo/a;", "Landroid/os/Bundle;", "arguments", "Lcom/tencent/mobileqq/troopmanage/repo/b;", "H", "", "troopUin", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "I", "troopInfo", "currentAccount", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "J", "", "isSuccess", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "isServer", "", "P", "Lcom/tencent/mobileqq/app/QQAppInterface;", "L", "", "", "uinToFlagMap", "M", "open", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "K", "memberUin", "", QCircleDaTongConstant.ElementParamValue.OPERATION, "u", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "p", "Landroidx/lifecycle/LifecycleOwner;", "owner", "from", "j", "l", "isChecked", "", "troopPrivilegeFlag", "privilegeMask", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "callback", "e", "Lcom/tencent/mobileqq/troopmanage/api/ITroopManageService;", DomainData.DOMAIN_NAME, "c", "i", "d", IProfileProtocolConst.PARAM_TROOP_CODE, "r", "updateFromWeb", "groupCode", "autoApprovalSetting", ReportConstant.COSTREPORT_PREFIX, "adminsCount", "t", "troopAdminList", "g", "bSuc", "bAllow", "enable", "failCallback", "k", "isCanSearchByTroopUin", "isCanSearchByKeywords", "onlyInvite", "opType", "isSetFeeSuccess", "isSetSuccess", tl.h.F, "allowUp", "allow", "o", "f", "cGroupOption", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/troopmanage/repo/b;", "mTroopArguments", "", "Ljava/util/List;", "mTroopAdminList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mTransferTroopMembers", "mMaxAdminNum", "mExpectedMaxTroopMemberNum", "Lcom/tencent/biz/troop/b;", "kotlin.jvm.PlatformType", "Lcom/tencent/biz/troop/b;", "mTroopClient", "Lmqq/app/NewIntent;", "Lmqq/app/NewIntent;", "mNewIntent", "com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$m", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageRepository$m;", "troopAdminUpdateObserver", "com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$i", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageRepository$i;", "mTroopObserver", "com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$f", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageRepository$f;", "mTroopGuildPermissionObserver", "com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$g", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageRepository$g;", "mTroopManagerBizObserver", "com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$d", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageRepository$d;", "mTroopEssenceMsgObserver", "com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$e", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageRepository$e;", "mTroopGameObserver", "com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$h", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageRepository$h;", "mTroopManagerObserver", "com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$c", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageRepository$c;", "mFaceReceiverListener", "com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$j", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageRepository$j;", "mTroopRobotObserver", "Lcom/tencent/qqnt/troop/ab;", "Lcom/tencent/qqnt/troop/ab;", "troopInfoChangedObserver", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopManageRepository implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troopmanage.repo.b mTroopArguments;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mTroopAdminList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> mTransferTroopMembers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mMaxAdminNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mExpectedMaxTroopMemberNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.biz.troop.b mTroopClient;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NewIntent mNewIntent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m troopAdminUpdateObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i mTroopObserver;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f mTroopGuildPermissionObserver;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g mTroopManagerBizObserver;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mTroopEssenceMsgObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mTroopGameObserver;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h mTroopManagerObserver;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mFaceReceiverListener;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j mTroopRobotObserver;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ab troopInfoChangedObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/repo/TroopManageRepository$a;", "", "", "KEY_LAST_UPDATE_TIME", "Ljava/lang/String;", "", "OPERATION_DELETE", "I", "OPERATION_SET", "OPERATION_UNSET", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troopmanage.repo.TroopManageRepository$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$b", "Lcom/tencent/qqnt/troopmemberlist/f;", "", "isSuccess", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.qqnt.troopmemberlist.f {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f303199b;

        b(boolean z16) {
            this.f303199b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopManageRepository.this, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.f
        public void a(boolean isSuccess, @NotNull List<? extends TroopMemberInfo> troopMemberList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopMemberList);
            } else {
                Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
                TroopManageRepository.this.P(isSuccess, new ArrayList(troopMemberList), this.f303199b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$c", "Lcom/tencent/mobileqq/troopmanage/base/TroopManageRemoteHandler$b;", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends TroopManageRemoteHandler.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troopmanage.base.TroopManageRemoteHandler.b
        public boolean a(@Nullable List<String> uinList) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uinList)).booleanValue();
            }
            if (uinList != null) {
                i3 = uinList.size();
            } else {
                i3 = 0;
            }
            QLog.d("Q.TroopManageRepository", 1, "onGetHeadResp uinList=" + i3);
            SimpleEventBus.getInstance().dispatchEvent(new TroopManageGetHeadEvent(uinList));
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\"\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$d", "Lcom/tencent/mobileqq/troop/observer/f;", "", "isSuccess", "", "troopUin", "isCheck", "", "f", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d extends com.tencent.mobileqq.troop.observer.f {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageRepository.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.observer.f
        protected void c(boolean isSuccess, @Nullable String troopUin, boolean isCheck) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), troopUin, Boolean.valueOf(isCheck));
                return;
            }
            QLog.d("Q.TroopManageRepository", 1, "onGetEssentialMsgPrivilege isSuccess=" + isSuccess + " troopUin=" + troopUin + " isCheck=" + isCheck);
            if (isSuccess && TextUtils.equals(troopUin, TroopManageRepository.this.mTroopArguments.i().troopUin)) {
                TroopManageRepository.this.d();
            }
        }

        @Override // com.tencent.mobileqq.troop.observer.f
        protected void f(boolean isSuccess, @Nullable String troopUin, boolean isCheck) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUin, Boolean.valueOf(isCheck));
                return;
            }
            if (isSuccess && TextUtils.equals(troopUin, TroopManageRepository.this.mTroopArguments.i().troopUin)) {
                z16 = isCheck;
            } else if (!isCheck) {
                z16 = true;
            }
            QLog.d("Q.TroopManageRepository", 1, "onSetTroopEssenceMsgShowInCardSwitchChange isSuccess=" + isSuccess + " troopUin=" + troopUin + " isCheck=" + isCheck);
            TroopManageRepository.this.d();
            SimpleEventBus.getInstance().dispatchEvent(new TroopManageSetTroopEssenceMsgShowEvent(z16));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$e", "Lcom/tencent/mobileqq/troop/troopgame/api/b;", "", "isSuccess", "", "uin", "errCode", "", "errInfo", "", "onModifyTroopGameCardSwitch", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class e extends com.tencent.mobileqq.troop.troopgame.api.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageRepository.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.api.b
        protected void onModifyTroopGameCardSwitch(boolean isSuccess, long uin, long errCode, @Nullable String errInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Long.valueOf(uin), Long.valueOf(errCode), errInfo);
                return;
            }
            if (TroopManageRepository.this.mTroopArguments.i().troopUin != null && Intrinsics.areEqual(TroopManageRepository.this.mTroopArguments.i().troopUin, String.valueOf(uin))) {
                QLog.d("Q.TroopManageRepository", 1, "onModifyTroopGameCardSwitch, isSuccess=" + isSuccess + " troopUin=" + uin + ", errCode=" + errCode + ", errInfo=" + errInfo);
                TroopManageRepository.this.d();
                SimpleEventBus.getInstance().dispatchEvent(new TroopManageModifyTroopGameCardSwitchEvent(isSuccess));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$f", "Luo4/e;", "", "guildId", "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class f extends uo4.e {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageRepository.this);
            }
        }

        @Override // uo4.e
        public void a(@NotNull String guildId, int permission) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) guildId, permission);
                return;
            }
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (TroopManageRepository.this.mTroopArguments.i().isTroopGuild && TroopManageRepository.this.mTroopArguments.i().troopGuildId != null && TroopManageRepository.this.mTroopArguments.i().troopGuildId.equals(guildId)) {
                TroopManageRepository.this.mTroopArguments.i().troopFeedTalkPermission = permission;
                QLog.d("Q.TroopManageRepository", 1, "onChannelInfoUpdated guildId=" + guildId + ", permission=" + permission);
                SimpleEventBus.getInstance().dispatchEvent(new TroopManageTroopFeedEvent(TroopManageRepository.this.mTroopArguments.i().troopFeedSwitch, TroopManageRepository.this.mTroopArguments.i().troopFeedTalkPermission));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$g", "Lcom/tencent/mobileqq/troop/troopmanager/api/b;", "", "troopUin", "", "troopMemberMax", "", "onNotifyTroopUpgradeSuccess", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class g extends com.tencent.mobileqq.troop.troopmanager.api.b {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageRepository.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(TroopManageRepository this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.K();
        }

        @Override // com.tencent.mobileqq.troop.troopmanager.api.b
        protected void onNotifyTroopUpgradeSuccess(@Nullable String troopUin, int troopMemberMax) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, troopMemberMax);
            } else if (Intrinsics.areEqual(troopUin, TroopManageRepository.this.mTroopArguments.i().troopUin)) {
                TroopManageRepository.this.mExpectedMaxTroopMemberNum = troopMemberMax;
                final TroopManageRepository troopManageRepository = TroopManageRepository.this;
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troopmanage.repo.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopManageRepository.g.b(TroopManageRepository.this);
                    }
                }, 5, null, true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J*\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0007H\u0016\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$h", "Lcom/tencent/mobileqq/troopmanage/base/f;", "Lcom/tencent/mobileqq/troopmanage/pb/PrettyTroopEntry$GetCareTextReply;", "reply", "", "t", ReportConstant.COSTREPORT_PREFIX, "", "isSuccess", "", "data", "o", "", "Lcom/tencent/mobileqq/troopmanage/model/a;", "smartManagerItems", "k", "", QzoneIPCModule.RESULT_CODE, "", "troopUin", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "p", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class h extends com.tencent.mobileqq.troopmanage.base.f {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageRepository.this);
            }
        }

        private final void s(PrettyTroopEntry.GetCareTextReply reply) {
            if (!QVIPPrettyTroopProcessor.get().showCreateIcon || Intrinsics.areEqual(reply.textLeft.get(), "")) {
                return;
            }
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str = reply.textLeft.get();
            Intrinsics.checkNotNullExpressionValue(str, "reply.textLeft.get()");
            String str2 = reply.textRight.get();
            Intrinsics.checkNotNullExpressionValue(str2, "reply.textRight.get()");
            simpleEventBus.dispatchEvent(new TroopManagePrettyEvent(str, str2));
        }

        private final void t(PrettyTroopEntry.GetCareTextReply reply) {
            String str;
            if (reply.report.get().size() > 0) {
                str = reply.report.get().get(0).value.get();
            } else {
                str = "0";
            }
            PrettyTroopEntry.b(TroopManageRepository.this.L(), TroopManageRepository.this.mTroopArguments.i().troopUin, reply.NextReqTime.get(), reply.textLeft.get(), reply.textRight.get(), reply.JumpUrl.get(), str);
        }

        @Override // com.tencent.mobileqq.troopmanage.base.f
        public void k(boolean isSuccess, @Nullable List<com.tencent.mobileqq.troopmanage.model.a> smartManagerItems) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), smartManagerItems);
                return;
            }
            if (smartManagerItems != null) {
                i3 = smartManagerItems.size();
            }
            QLog.d("Q.TroopManageRepository", 1, "onGetSmartManagerEntrance, isSuccess=" + isSuccess + " smartManagerItems.size=" + i3);
            SimpleEventBus.getInstance().dispatchEvent(new TroopManageGetSmartEntranceEvent(isSuccess, smartManagerItems));
        }

        @Override // com.tencent.mobileqq.troopmanage.base.f
        public void o(boolean isSuccess, @Nullable Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), data);
                return;
            }
            QLog.d("Q.TroopManageRepository", 1, "onReceivePrettyTroopInfo, isSuccess=" + isSuccess + " data=" + data);
            if (!isSuccess) {
                SimpleEventBus.getInstance().dispatchEvent(new TroopManagePrettyEvent("", ""));
                return;
            }
            try {
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
                Object obj = ((Object[]) data)[0];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.troopmanage.pb.PrettyTroopEntry.GetCareTextReply");
                PrettyTroopEntry.GetCareTextReply getCareTextReply = (PrettyTroopEntry.GetCareTextReply) obj;
                t(getCareTextReply);
                s(getCareTextReply);
            } catch (ClassCastException e16) {
                SimpleEventBus.getInstance().dispatchEvent(new TroopManagePrettyEvent("", ""));
                QLog.e("Q.TroopManageRepository", 1, e16.getMessage());
            }
        }

        @Override // com.tencent.mobileqq.troopmanage.base.f
        public void p(boolean isSuccess, int resultCode, @Nullable String troopUin, boolean isOpen) {
            BusinessHandler businessHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(isSuccess), Integer.valueOf(resultCode), troopUin, Boolean.valueOf(isOpen));
                return;
            }
            if (!TextUtils.isEmpty(troopUin) && !TextUtils.isEmpty(TroopManageRepository.this.mTroopArguments.i().troopUin) && Intrinsics.areEqual(troopUin, TroopManageRepository.this.mTroopArguments.i().troopUin)) {
                QLog.d("Q.TroopManageRepository", 1, "onSetLuckyCharacterSwitch isSucc=" + isSuccess + ", troopUin=" + troopUin + " , isOpen=" + isOpen);
                if (isSuccess) {
                    int i3 = TroopManageRepository.this.mTroopArguments.h().groupFlagExt4;
                    if (isOpen) {
                        TroopManageRepository.this.mTroopArguments.i().groupFlagExt4 &= -32769;
                        TroopManageRepository.this.mTroopArguments.h().groupFlagExt4 &= -32769;
                    } else {
                        TroopManageRepository.this.mTroopArguments.i().groupFlagExt4 |= 32768;
                        TroopManageRepository.this.mTroopArguments.h().groupFlagExt4 |= 32768;
                    }
                    ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateLuckyCharFlag(TroopManageRepository.this.mTroopArguments.j(), isOpen);
                    if (i3 != TroopManageRepository.this.mTroopArguments.h().groupFlagExt4) {
                        AppInterface e16 = bg.e();
                        ITroopPushHandler iTroopPushHandler = null;
                        if (e16 != null) {
                            businessHandler = e16.getBusinessHandler(TroopPushHandler.class.getName());
                        } else {
                            businessHandler = null;
                        }
                        if (businessHandler instanceof ITroopPushHandler) {
                            iTroopPushHandler = (ITroopPushHandler) businessHandler;
                        }
                        if (iTroopPushHandler != null) {
                            iTroopPushHandler.Y1(TroopManageRepository.this.mTroopArguments.h().getTroopUin(), i3, TroopManageRepository.this.mTroopArguments.h().groupFlagExt4);
                        }
                    }
                }
                SimpleEventBus.getInstance().dispatchEvent(new TroopManageSetLuckyCharacterSwitchEvent(isSuccess, resultCode));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J$\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$i", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", "isSuc", "", "uin", "", "onGetTroopInfoResult", "isSucc", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExt;", "oldTroppInfoExtObj", "onGetTroopInfoExtComplete", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class i extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageRepository.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoExtComplete(boolean isSucc, @Nullable String troopUin, @Nullable GroupExt oldTroppInfoExtObj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSucc), troopUin, oldTroppInfoExtObj);
            } else if (isSucc && Intrinsics.areEqual(TroopManageRepository.this.mTroopArguments.i().troopUin, troopUin)) {
                TroopManageRepository.this.d();
                SimpleEventBus.getInstance().dispatchEvent(new TroopManageModifyTroopGameCardSwitchEvent(true));
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoResult(boolean isSuc, @Nullable String uin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuc), uin);
                return;
            }
            if (isSuc && TroopManageRepository.this.mTroopArguments.i().troopUin != null && TextUtils.equals(uin, TroopManageRepository.this.mTroopArguments.i().troopUin)) {
                TroopInfo troopInfo = TroopManageRepository.this.n().getTroopInfo(TroopManageRepository.this.mTroopArguments.i().troopUin);
                Intrinsics.checkNotNullExpressionValue(troopInfo, "getITroopManageService()\u2026.mTroopInfoData.troopUin)");
                if (troopInfo != TroopManageRepository.this.mTroopArguments.h()) {
                    TroopManageRepository.this.mTroopArguments.v(troopInfo);
                }
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                String str = TroopManageRepository.this.mTroopArguments.i().troopUin;
                Intrinsics.checkNotNullExpressionValue(str, "mTroopArguments.mTroopInfoData.troopUin");
                simpleEventBus.dispatchEvent(new TroopManageAutoApprovalEvent(str, TroopManageRepository.this.mTroopArguments.h().isAutoApprovalOpen()));
                SimpleEventBus.getInstance().dispatchEvent(new TroopManageSpeechLimitEvent(TroopManageRepository.this.mTroopArguments.h().nMsgLimitFreq));
            }
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("onGetTroopInfoResult [%s, %s]", Arrays.copyOf(new Object[]{Boolean.valueOf(isSuc), uin}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.i("Q.TroopManageRepository", 1, format);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$j", "Lct2/b;", "", "success", "", "troopUin", "", "switchValue", "", "errorMsg", "", "f", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class j extends ct2.b {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageRepository.this);
            }
        }

        @Override // ct2.b
        protected void f(boolean success, long troopUin, int switchValue, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(success), Long.valueOf(troopUin), Integer.valueOf(switchValue), errorMsg);
                return;
            }
            if (troopUin != 0 && Intrinsics.areEqual(TroopManageRepository.this.mTroopArguments.j(), String.valueOf(troopUin))) {
                TroopManageRepository.this.d();
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                if (errorMsg == null) {
                    errorMsg = "";
                }
                simpleEventBus.dispatchEvent(new TroopSetInviteRobotSwitchEvent(success, switchValue, errorMsg));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$k", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", IProfileProtocolConst.PARAM_TROOP_CODE, "memberUin", "", QCircleDaTongConstant.ElementParamValue.OPERATION, "", "onSetTroopAdminSuccess", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class k extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageRepository.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onSetTroopAdminSuccess(@Nullable String troopCode, @Nullable String memberUin, byte operation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, troopCode, memberUin, Byte.valueOf(operation));
                return;
            }
            if (TextUtils.equals(TroopManageRepository.this.mTroopArguments.i().troopUin, troopCode) && !TextUtils.isEmpty(memberUin) && operation == 1) {
                com.tencent.mobileqq.troopmanage.base.g gVar = com.tencent.mobileqq.troopmanage.base.g.f303036a;
                String string = TroopManageRepository.this.L().getApplication().getResources().getString(R.string.f_);
                Intrinsics.checkNotNullExpressionValue(string, "getQQAppInterface().appl\u2026.add_troop_admin_success)");
                gVar.c(string);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002W\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0001j\u0002`\fJ-\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0096\u0002\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$l", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "errMsg", "", "", "uin2flagMap", "", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberFlagCallback;", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class l implements Function3<Boolean, String, Map<String, ? extends Integer>, Unit> {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageRepository.this);
            }
        }

        public void a(boolean isSuccess, @NotNull String errMsg, @NotNull Map<String, Integer> uin2flagMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), errMsg, uin2flagMap);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(uin2flagMap, "uin2flagMap");
            TroopManageRepository.this.M(isSuccess, uin2flagMap);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str, Map<String, ? extends Integer> map) {
            a(bool.booleanValue(), str, map);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageRepository$m", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", IProfileProtocolConst.PARAM_TROOP_CODE, "memberUin", "", QCircleDaTongConstant.ElementParamValue.OPERATION, "", "onSetTroopAdminSuccess", "", "errorCode", "onSetTroopAdminFail", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class m extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageRepository.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onSetTroopAdminFail(int errorCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode);
                return;
            }
            QLog.d("Q.TroopManageRepository", 1, "onSetTroopAdminFail, errorCode=" + errorCode);
            SimpleEventBus.getInstance().dispatchEvent(new TroopManageAdminListEvent(errorCode, TroopManageRepository.this.mTroopAdminList, TroopManageRepository.this.mTroopArguments.h().maxAdminNum));
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onSetTroopAdminSuccess(@Nullable String troopCode, @Nullable String memberUin, byte operation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, troopCode, memberUin, Byte.valueOf(operation));
                return;
            }
            QLog.i("Q.TroopManageRepository", 1, "[onSetTroopAdminSuccess] troopCode = " + troopCode + " operation = " + ((int) operation) + " memberUin = " + memberUin);
            String troopUin = TroopManageRepository.this.mTroopArguments.i().troopUin;
            if (TextUtils.equals(troopUin, troopCode) && !TextUtils.isEmpty(memberUin)) {
                if (operation != 0) {
                    if (operation != 1) {
                        if (operation != 2) {
                            return;
                        }
                    } else {
                        TroopManageRepository troopManageRepository = TroopManageRepository.this;
                        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                        troopManageRepository.u(troopUin, memberUin, operation);
                        return;
                    }
                }
                ((ITroopManageApi) QRoute.api(ITroopManageApi.class)).preLoadIntelligentManageItem(TroopManageRepository.this.m().j());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63063);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopManageRepository() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTroopArguments = new com.tencent.mobileqq.troopmanage.repo.b();
        this.mTroopAdminList = new ArrayList();
        this.mTransferTroopMembers = new ArrayList<>();
        this.mTroopClient = com.tencent.biz.troop.b.A();
        this.mNewIntent = new NewIntent(MobileQQ.sMobileQQ, dh.class);
        this.troopAdminUpdateObserver = new m();
        this.mTroopObserver = new i();
        this.mTroopGuildPermissionObserver = new f();
        this.mTroopManagerBizObserver = new g();
        this.mTroopEssenceMsgObserver = new d();
        this.mTroopGameObserver = new e();
        this.mTroopManagerObserver = new h();
        this.mFaceReceiverListener = new c();
        this.mTroopRobotObserver = new j();
        this.troopInfoChangedObserver = new ab() { // from class: com.tencent.mobileqq.troopmanage.repo.c
            @Override // com.tencent.qqnt.troop.ab
            public final void a(TroopInfo troopInfo) {
                TroopManageRepository.S(TroopManageRepository.this, troopInfo);
            }
        };
    }

    private final com.tencent.mobileqq.troopmanage.repo.b H(Bundle arguments) {
        com.tencent.mobileqq.troopmanage.repo.b bVar = new com.tencent.mobileqq.troopmanage.repo.b();
        bVar.z(arguments);
        String string = arguments.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "arguments.getString(AppC\u2026stants.Key.TROOP_UIN, \"\")");
        bVar.x(string);
        bVar.s(arguments.getBoolean(AppConstants.Key.KEY_QIDIAN_PRIVATE_TROOP, false));
        bVar.q(arguments.getBoolean(AppConstants.Key.KEY_CUSTOMED_GAME_TROOP, false));
        String string2 = arguments.getString("uin", "");
        Intrinsics.checkNotNullExpressionValue(string2, "arguments.getString(\n   \u2026.Key.UIN,\n            \"\")");
        bVar.o(string2);
        com.tencent.mobileqq.troop.troopurl.config.a a16 = TroopUrlConfProcessor.a();
        Intrinsics.checkNotNullExpressionValue(a16, "loadConfig()");
        String string3 = arguments.getString("autoApprovalUrl", a16.f301842b);
        Intrinsics.checkNotNullExpressionValue(string3, "arguments.getString(\"aut\u2026nfigBean.autoApprovalUrl)");
        bVar.n(string3);
        bVar.u(arguments.getBoolean("frequencyLimitVisible", a16.f301843c));
        IRuntimeService runtimeService = L().getRuntimeService(ITroopHonorService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getQQAppInterface().getR\u2026va, ProcessConstant.MAIN)");
        bVar.t(((ITroopHonorService) runtimeService).isGrayTroopHonor(bVar.j()));
        String string4 = arguments.getString(ITroopUtilsApi.TROOP_MANAGE_EDIT_CURRENT_UIN, "");
        Intrinsics.checkNotNullExpressionValue(string4, "arguments.getString(\n   \u2026RENT_UIN,\n            \"\")");
        bVar.p(string4);
        bVar.y(arguments.getInt(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, 2));
        bVar.A(arguments.getInt("page_status", 2));
        bVar.v(I(bVar.j()));
        bVar.r(bVar.h().isHomeworkTroop());
        if (arguments.getBoolean("troop_manage_from_jump_action", false)) {
            bVar.s(bVar.h().isQidianPrivateTroop());
            bVar.q(bVar.h().isKingBattleTroop());
        }
        bVar.w(J(arguments, bVar.h(), bVar.j(), bVar.b()));
        return bVar;
    }

    private final TroopInfo I(String troopUin) {
        TroopInfo troopInfo = n().getTroopInfo(troopUin);
        Intrinsics.checkNotNullExpressionValue(troopInfo, "getITroopManageService().getTroopInfo(troopUin)");
        if (troopInfo.isOnlyTroopMemberInviteOption()) {
            troopInfo.setOnlyTroopMemberInviteOption(false);
            troopInfo.cGroupOption = (short) 2;
        }
        return troopInfo;
    }

    private final TroopInfoData J(Bundle arguments, TroopInfo troopInfo, String troopUin, String currentAccount) {
        TroopInfoData troopInfoData = new TroopInfoData();
        troopInfoData.troopUin = troopUin;
        troopInfoData.isMember = true;
        troopInfoData.updateForTroopChatSetting(troopInfo, L().getApplication().getResources(), currentAccount);
        troopInfoData.troopLocation = arguments.getString(AppConstants.Key.FORWARD_LOCATION, "");
        troopInfoData.troopLat = arguments.getInt(AppConstants.Key.FORWARD_LATITUDE, 0);
        troopInfoData.troopLon = arguments.getInt(AppConstants.Key.FORWARD_LONGITUDE, 0);
        troopInfoData.cityId = arguments.getInt(AppConstants.Key.FORWARD_CITYID, 0);
        troopInfoData.troopTypeExt = troopInfo.troopTypeExt;
        troopInfoData.mTroopPrivilegeFlag = (int) troopInfo.troopPrivilegeFlag;
        troopInfoData.mTroopNeedPayNumber = troopInfo.mTroopNeedPayNumber;
        troopInfoData.nGroupFlagExt = (int) troopInfo.dwGroupFlagExt;
        troopInfoData.isTroopGuild = arguments.getBoolean(ITroopUtilsApi.TROOP_MANAGE_IS_GUILD, false);
        troopInfoData.troopGuildId = arguments.getString(ITroopUtilsApi.TROOP_MANAGE_GUILD_ID);
        troopInfoData.troopGuildChannelId = arguments.getString(ITroopUtilsApi.TROOP_MANAGE_CHANNEL_ID);
        troopInfoData.troopFeedTalkPermission = arguments.getInt(ITroopUtilsApi.TROOP_MANAGE_GUILD_FEED_PERMISSION, -1);
        troopInfoData.troopFeedSwitch = arguments.getBoolean(ITroopUtilsApi.TROOP_MANAGE_GUILD_FEED_SWITCH, true);
        return troopInfoData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopMaxAdminNum(this.mTroopArguments.i().troopUin, false, "Q.TroopManageRepository", null, new Function2<Boolean, TroopInfo, Unit>() { // from class: com.tencent.mobileqq.troopmanage.repo.TroopManageRepository$fetchTroopMaxMemberNum$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageRepository.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                invoke(bool.booleanValue(), troopInfo);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull TroopInfo troopInfo) {
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), troopInfo);
                    return;
                }
                Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
                QLog.d("Q.TroopManageRepository", 1, "fetchTroopMaxMemberNum isSuccess=" + z16 + " troopUin=" + troopInfo.troopuin + " troopMemberMax=" + troopInfo.wMemberMax);
                if (!z16 || TroopManageRepository.this.mTroopArguments.i().troopUin == null) {
                    return;
                }
                b bVar = TroopManageRepository.this.mTroopArguments;
                TroopInfo troopInfo2 = TroopManageRepository.this.n().getTroopInfo(TroopManageRepository.this.mTroopArguments.i().troopUin);
                Intrinsics.checkNotNullExpressionValue(troopInfo2, "getITroopManageService()\u2026.mTroopInfoData.troopUin)");
                bVar.v(troopInfo2);
                if (Intrinsics.areEqual(troopInfo.troopuin, TroopManageRepository.this.mTroopArguments.i().troopUin)) {
                    i3 = TroopManageRepository.this.mExpectedMaxTroopMemberNum;
                    if (i3 == troopInfo.wMemberMax) {
                        TroopManageRepository.this.mTroopArguments.h().wMemberMax = troopInfo.wMemberMax;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQAppInterface L() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return (QQAppInterface) peekAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(boolean isSuccess, Map<String, Integer> uinToFlagMap) {
        if (!isSuccess) {
            SimpleEventBus.getInstance().dispatchEvent(new TroopManageTransferTroopMembersEvent(false, null));
            return;
        }
        this.mTransferTroopMembers.clear();
        Iterator<T> it = uinToFlagMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            this.mTransferTroopMembers.add(entry.getKey() + "|" + entry.getValue());
        }
        QLog.d("Q.TroopManageRepository", 1, "handleGetTransferTroopMembersSuccess list.size=" + this.mTransferTroopMembers.size() + " lTroopUin=" + this.mTroopArguments.i().troopUin);
        SimpleEventBus.getInstance().dispatchEvent(new TroopManageTransferTroopMembersEvent(true, this.mTransferTroopMembers));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(TroopManageRepository this$0, Function1 failCallback, boolean z16, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(failCallback, "$failCallback");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
        boolean z17 = true;
        QLog.d("Q.TroopManageRepository", 1, "onUploadAlbumSetting isSucc=" + z16);
        if ((this$0.mTroopArguments.h().troopPrivilegeFlag & 1) != 0) {
            z17 = false;
        }
        if (z16) {
            if (z17) {
                this$0.mTroopArguments.h().troopPrivilegeFlag |= 1;
            } else {
                this$0.mTroopArguments.h().troopPrivilegeFlag &= -2;
            }
            this$0.mTroopArguments.i().updateForTroopChatSetting(this$0.mTroopArguments.h(), this$0.L().getApplication().getResources(), this$0.mTroopArguments.b());
            return;
        }
        failCallback.invoke(Boolean.valueOf(z17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(TroopManageRepository this$0, Function1 failCallback, boolean z16, int i3, String str) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(failCallback, "$failCallback");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
        if ((this$0.mTroopArguments.h().troopPrivilegeFlag & 2) == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16) {
            if (z17) {
                this$0.mTroopArguments.h().troopPrivilegeFlag |= 2;
            } else {
                this$0.mTroopArguments.h().troopPrivilegeFlag &= -3;
            }
            this$0.mTroopArguments.i().updateForTroopChatSetting(this$0.mTroopArguments.h(), this$0.L().getApplication().getResources(), this$0.mTroopArguments.b());
            return;
        }
        failCallback.invoke(Boolean.valueOf(z17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(boolean isSuccess, List<? extends TroopMemberInfo> troopMemberList, boolean isServer) {
        QLog.i("Q.TroopManageRepository", 1, "[onFetchMemberListData] isSuccess:" + isSuccess + ", isServer:" + isServer + ", size:" + troopMemberList.size());
        if (isSuccess) {
            if (isServer) {
                com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
                String str = this.mTroopArguments.i().troopUin;
                if (str == null) {
                    str = "";
                }
                com.tencent.mobileqq.troop.config.a.x(aVar, "key_last_update_time" + str, System.currentTimeMillis(), false, 4, null);
            }
            List<TroopMemberNickUIInfo> b16 = com.tencent.mobileqq.troopmanage.base.b.b(troopMemberList);
            if (b16 == null) {
                return;
            }
            this.mTroopAdminList.clear();
            for (TroopMemberNickUIInfo adminNickInfo : b16) {
                Intrinsics.checkNotNullExpressionValue(adminNickInfo, "adminNickInfo");
                this.mTroopAdminList.add(adminNickInfo.getUin());
            }
            SimpleEventBus.getInstance().dispatchEvent(new TroopManageAdminListEvent(0, this.mTroopAdminList, this.mTroopArguments.h().maxAdminNum));
        }
    }

    private final void Q(TroopInfo troopInfo, boolean z16) {
        long j3;
        if (z16) {
            j3 = troopInfo.dwGroupFlagExt3 | 1048576;
        } else {
            j3 = troopInfo.dwGroupFlagExt3 & (-1048577);
        }
        troopInfo.dwGroupFlagExt3 = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 callback, boolean z16, TroopManageRepository this$0, long j3, long j16, boolean z17, int i3, String errMsg) {
        long j17;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.d("Q.TroopManageRepository", 1, "setTroopPrivilegeFlag errorCode=" + i3 + ", errMsg:" + errMsg);
        if (i3 != 0) {
            callback.invoke(Boolean.valueOf(!z16));
            return;
        }
        TroopInfo h16 = this$0.mTroopArguments.h();
        if (j3 != 0) {
            j17 = this$0.mTroopArguments.h().dwAppPrivilegeFlag | j16;
        } else {
            j17 = this$0.mTroopArguments.h().dwAppPrivilegeFlag & (~j16);
        }
        h16.dwAppPrivilegeFlag = j17;
        this$0.mTroopArguments.h().troopPrivilegeFlag = this$0.mTroopArguments.h().dwAppPrivilegeFlag;
        this$0.mTroopArguments.i().mTroopPrivilegeFlag = (int) this$0.mTroopArguments.h().troopPrivilegeFlag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(TroopManageRepository this$0, TroopInfo newTroopInfo) {
        short s16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newTroopInfo, "newTroopInfo");
        short s17 = this$0.mTroopArguments.i().cGroupOption;
        if (Intrinsics.areEqual(newTroopInfo.getTroopUin(), this$0.mTroopArguments.i().troopUin) && (s16 = newTroopInfo.cGroupOption) != s17) {
            this$0.q(s16);
        }
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    @NotNull
    public Bundle a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bundle) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mTroopArguments.l();
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void b(@NotNull Bundle arguments) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arguments);
            return;
        }
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        boolean z17 = false;
        if (this.mTroopArguments.j().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z18 = this.mTroopArguments.i().isTroopGuild;
        QLog.d("Q.TroopManageRepository", 1, "onCreated(recreating=" + z16 + ") arguments=" + arguments);
        com.tencent.mobileqq.troopmanage.repo.b H = H(arguments);
        this.mTroopArguments = H;
        if (!z18 && H.i().isTroopGuild) {
            z17 = true;
        }
        if (z17) {
            this.mTroopClient.k0();
            this.mTroopClient.f(this.mTroopGuildPermissionObserver);
        }
        if (this.mNewIntent.getObserver() != null) {
            return;
        }
        this.mNewIntent.setObserver(new k());
        this.mTroopClient.p();
        this.mTroopClient.f(this.mTroopObserver);
        this.mTroopClient.f(this.mTroopEssenceMsgObserver);
        this.mTroopClient.f(this.mTroopManagerBizObserver);
        QQAppInterface L = L();
        L.addObserver(this.mTroopObserver);
        L.addObserver(this.mTroopGameObserver);
        L.addObserver(this.mTroopManagerObserver);
        L.addObserver(this.mTroopRobotObserver);
        L.registObserver(this.troopAdminUpdateObserver);
        n().getTroopManageRemoteHandler().e(this.mFaceReceiverListener);
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).registerTroopInfoChangedObserver(null, this.troopInfoChangedObserver);
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void c(boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, isChecked);
        } else {
            this.mTroopClient.C0(this.mTroopArguments.i().troopUin, isChecked);
        }
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        com.tencent.mobileqq.troopmanage.repo.b bVar = this.mTroopArguments;
        TroopInfo troopInfo = n().getTroopInfo(this.mTroopArguments.j());
        Intrinsics.checkNotNullExpressionValue(troopInfo, "getITroopManageService()\u2026TroopArguments.mTroopUin)");
        bVar.v(troopInfo);
        this.mTroopArguments.i().updateForTroopInfo(this.mTroopArguments.h(), this.mTroopArguments.b());
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void e(final boolean isChecked, @NotNull String troopUin, final long troopPrivilegeFlag, final long privilegeMask, @NotNull final Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(isChecked), troopUin, Long.valueOf(troopPrivilegeFlag), Long.valueOf(privilegeMask), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopPrivilegeFlag(null, troopUin, troopPrivilegeFlag, privilegeMask, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troopmanage.repo.e
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i3, String str) {
                TroopManageRepository.R(Function1.this, isChecked, this, troopPrivilegeFlag, privilegeMask, z16, i3, str);
            }
        });
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void f(@Nullable String groupCode, boolean allowUp, @NotNull final Function1<? super Boolean, Unit> failCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, groupCode, Boolean.valueOf(allowUp), failCallback);
        } else {
            Intrinsics.checkNotNullParameter(failCallback, "failCallback");
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyUploadTroopAlbum(null, groupCode, allowUp, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troopmanage.repo.f
                @Override // com.tencent.qqnt.troop.e
                public final void onResult(boolean z16, int i3, String str) {
                    TroopManageRepository.N(TroopManageRepository.this, failCallback, z16, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void g(@NotNull List<String> troopAdminList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) troopAdminList);
            return;
        }
        Intrinsics.checkNotNullParameter(troopAdminList, "troopAdminList");
        this.mTroopAdminList.clear();
        this.mTroopAdminList.addAll(troopAdminList);
        SimpleEventBus.getInstance().dispatchEvent(new TroopManageAdminListEvent(0, this.mTroopAdminList, this.mTroopArguments.h().maxAdminNum));
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void h(boolean isCanSearchByTroopUin, boolean isCanSearchByKeywords, boolean onlyInvite, int opType, boolean isSetFeeSuccess, boolean isSetSuccess) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Boolean.valueOf(isCanSearchByTroopUin), Boolean.valueOf(isCanSearchByKeywords), Boolean.valueOf(onlyInvite), Integer.valueOf(opType), Boolean.valueOf(isSetFeeSuccess), Boolean.valueOf(isSetSuccess));
            return;
        }
        QLog.d("Q.TroopManageRepository", 1, "updateTroopAuthenticationFromActivityResult");
        this.mTroopArguments.h().setOnlyTroopMemberInviteOption(onlyInvite);
        this.mTroopArguments.h().cGroupOption = (short) opType;
        if (this.mTroopArguments.h().isOnlyTroopMemberInviteOption()) {
            this.mTroopArguments.h().troopPrivilegeFlag |= 67108864;
        }
        this.mTroopArguments.i().updateForTroopChatSetting(this.mTroopArguments.h(), L().getApplication().getResources(), this.mTroopArguments.b());
        if (!isSetFeeSuccess && isSetSuccess) {
            q(this.mTroopArguments.h().cGroupOption);
        }
        if (isSetFeeSuccess || isSetSuccess) {
            com.tencent.mobileqq.troopmanage.base.g gVar = com.tencent.mobileqq.troopmanage.base.g.f303036a;
            String string = L().getApplication().getResources().getString(R.string.uiy);
            Intrinsics.checkNotNullExpressionValue(string, "getQQAppInterface().appl\u2026.qqstr_troopman_1fc11807)");
            gVar.c(string);
            if (this.mTroopArguments.h().isNeedClearAutoApproval()) {
                Q(this.mTroopArguments.h(), false);
                ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateTroopAutoApproval(this.mTroopArguments.j(), false);
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                String str = this.mTroopArguments.i().troopUin;
                Intrinsics.checkNotNullExpressionValue(str, "mTroopArguments.mTroopInfoData.troopUin");
                simpleEventBus.dispatchEvent(new TroopManageAutoApprovalEvent(str, this.mTroopArguments.h().isAutoApprovalOpen()));
            }
        }
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        ITroopMemberExtInfoRepoApi iTroopMemberExtInfoRepoApi = (ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class);
        String str = this.mTroopArguments.i().troopUin;
        Intrinsics.checkNotNullExpressionValue(str, "mTroopArguments.mTroopInfoData.troopUin");
        iTroopMemberExtInfoRepoApi.fetchCanTransferTroopMember(str, null, new l());
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void j(@NotNull LifecycleOwner owner, @NotNull String from) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) owner, (Object) from);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(from, "from");
        com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
        String str = this.mTroopArguments.i().troopUin;
        if (str == null) {
            str = "";
        }
        long l3 = com.tencent.mobileqq.troop.config.a.l(aVar, "key_last_update_time" + str, 0L, false, 4, null);
        long currentTimeMillis = System.currentTimeMillis();
        String troopUin = this.mTroopArguments.h().getTroopUin();
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.i("Q.TroopManageRepository", 1, "[fetchTroopAdminList] troopUin is empty");
            return;
        }
        if (l3 != 0 && (l3 <= 0 || Math.abs(currentTimeMillis - l3) <= MiniBoxNoticeInfo.MIN_5)) {
            z17 = false;
        } else {
            z17 = true;
        }
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(troopUin, owner, z17, from, new b(z17));
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void k(boolean bSuc, @NotNull String troopUin, boolean bAllow, @NotNull Function1<? super Boolean, Unit> failCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Boolean.valueOf(bSuc), troopUin, Boolean.valueOf(bAllow), failCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(failCallback, "failCallback");
        QLog.d("Q.TroopManageRepository", 1, "[onSetEnableHistoryForNewMember] bSuc:" + bSuc + ", troopUin:" + troopUin);
        if (bSuc) {
            if (!Utils.p(troopUin, this.mTroopArguments.i().troopUin)) {
                return;
            }
            if (bAllow) {
                this.mTroopArguments.h().isAllowHistoryMsgFlag = 1;
                return;
            } else {
                this.mTroopArguments.h().isAllowHistoryMsgFlag = 0;
                return;
            }
        }
        failCallback.invoke(Boolean.valueOf(this.mTroopArguments.h().isHistoryMsgReadEnableForNewMember()));
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (ea.K1()) {
            n().getTroopManageHandler().G2(this.mTroopArguments.i().troopUin);
        }
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    @NotNull
    public com.tencent.mobileqq.troopmanage.repo.b m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.troopmanage.repo.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mTroopArguments;
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    @NotNull
    public ITroopManageService n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ITroopManageService) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        IRuntimeService runtimeService = L().getRuntimeService(ITroopManageService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getQQAppInterface().getR\u2026ssConstant.MAIN\n        )");
        return (ITroopManageService) runtimeService;
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void o(@Nullable String groupCode, boolean allowUp, @NotNull final Function1<? super Boolean, Unit> failCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, groupCode, Boolean.valueOf(allowUp), failCallback);
        } else {
            Intrinsics.checkNotNullParameter(failCallback, "failCallback");
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyUploadTroopFile(null, groupCode, allowUp, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troopmanage.repo.d
                @Override // com.tencent.qqnt.troop.e
                public final void onResult(boolean z16, int i3, String str) {
                    TroopManageRepository.O(TroopManageRepository.this, failCallback, z16, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.d("Q.TroopManageRepository", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        if (this.mNewIntent.getObserver() == null) {
            return;
        }
        this.mTroopClient.n0(this.mTroopObserver);
        this.mTroopClient.n0(this.mTroopEssenceMsgObserver);
        this.mTroopClient.n0(this.mTroopManagerBizObserver);
        this.mTroopClient.n0(this.mTroopGuildPermissionObserver);
        QQAppInterface L = L();
        L.removeObserver(this.mTroopObserver);
        L.removeObserver(this.mTroopGameObserver);
        L.removeObserver(this.mTroopManagerObserver);
        L.removeObserver(this.mTroopRobotObserver);
        L.unRegistObserver(this.troopAdminUpdateObserver);
        this.mTroopClient.O0();
        this.mTroopClient.q();
        n().getTroopManageRemoteHandler().i(this.mFaceReceiverListener);
        this.mNewIntent.setObserver(null);
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).unregisterTroopInfoChangedObserver(this.troopInfoChangedObserver);
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mMaxAdminNum;
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void q(int cGroupOption) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, cGroupOption);
            return;
        }
        QLog.d("Q.TroopManageRepository", 1, "updateTroopAuthentication cGroupOption=" + cGroupOption);
        this.mTroopArguments.i().cGroupOption = (short) cGroupOption;
        this.mTroopArguments.i().troopAuthen = TroopSetJoinTypeActivity.Aj(L().getApplicationContext(), this.mTroopArguments.i());
        if (this.mTroopArguments.e()) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String string = L().getApplication().getResources().getString(R.string.i7b);
            Intrinsics.checkNotNullExpressionValue(string, "getQQAppInterface().appl\u2026_option_need_verify_only)");
            simpleEventBus.dispatchEvent(new TroopManageAuthEvent(string));
            return;
        }
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        String str = this.mTroopArguments.i().troopAuthen;
        if (str == null) {
            str = "";
        }
        simpleEventBus2.dispatchEvent(new TroopManageAuthEvent(str));
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void r(byte operation, @NotNull String troopCode, @NotNull String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Byte.valueOf(operation), troopCode, memberUin);
            return;
        }
        Intrinsics.checkNotNullParameter(troopCode, "troopCode");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        this.mNewIntent.putExtra("command", 0);
        this.mNewIntent.putExtra(QCircleDaTongConstant.ElementParamValue.OPERATION, operation);
        this.mNewIntent.putExtra(AppConstants.Key.TROOP_CODE, troopCode);
        this.mNewIntent.putExtra("troop_member_uin", memberUin);
        L().startServlet(this.mNewIntent);
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void s(boolean updateFromWeb, long groupCode, boolean autoApprovalSetting) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(updateFromWeb), Long.valueOf(groupCode), Boolean.valueOf(autoApprovalSetting));
            return;
        }
        if (updateFromWeb && Intrinsics.areEqual(String.valueOf(groupCode), this.mTroopArguments.j())) {
            com.tencent.mobileqq.troopmanage.repo.b bVar = this.mTroopArguments;
            TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(this.mTroopArguments.j());
            if (troopInfoFromCache == null) {
                troopInfoFromCache = new TroopInfo(this.mTroopArguments.j());
            }
            bVar.v(troopInfoFromCache);
            Q(this.mTroopArguments.h(), autoApprovalSetting);
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateTroopAutoApproval(this.mTroopArguments.j(), autoApprovalSetting);
            SimpleEventBus.getInstance().dispatchEvent(new TroopManageAutoApprovalEvent(this.mTroopArguments.j(), this.mTroopArguments.h().isAutoApprovalOpen()));
        }
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void t(int adminsCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, adminsCount);
            return;
        }
        com.tencent.mobileqq.troopmanage.repo.b bVar = this.mTroopArguments;
        TroopInfo troopInfo = n().getTroopInfo(this.mTroopArguments.j());
        Intrinsics.checkNotNullExpressionValue(troopInfo, "getITroopManageService()\u2026TroopArguments.mTroopUin)");
        bVar.v(troopInfo);
        this.mTroopArguments.i().updateForTroopChatSetting(this.mTroopArguments.h(), L().getApplication().getResources(), this.mTroopArguments.b());
    }

    @Override // com.tencent.mobileqq.troopmanage.repo.a
    public void u(@NotNull String troopUin, @Nullable String memberUin, byte operation) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, memberUin, Byte.valueOf(operation));
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (memberUin != null && memberUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !this.mTroopAdminList.contains(memberUin)) {
            this.mTroopAdminList.add(memberUin);
        }
        QLog.d("Q.TroopManageRepository", 1, "onSetTroopAdminSuccess, troopUin=" + troopUin + " memberUin=" + memberUin + ", admin size=" + this.mTroopAdminList.size());
        ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchTroopAdmin(troopUin, null, null);
        SimpleEventBus.getInstance().dispatchEvent(new TroopManageAdminListEvent(0, this.mTroopAdminList, this.mTroopArguments.h().maxAdminNum));
        com.tencent.mobileqq.troopmanage.base.b.g(n(), this.mTroopArguments.h(), memberUin, troopUin, operation);
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(troopUin, memberUin, true, null, "troop-mng-repo-set-admin", null);
    }
}
