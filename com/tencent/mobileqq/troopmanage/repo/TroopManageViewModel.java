package com.tencent.mobileqq.troopmanage.repo;

import GROUP.MessageRemindRsp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.access.ITroopManageAccessHandlerApi;
import com.tencent.mobileqq.troop.jointype.event.TroopAutoApprovalSettingUpdate;
import com.tencent.mobileqq.troop.jointype.event.TroopManageAutoApprovalEvent;
import com.tencent.mobileqq.troopmanage.api.ITroopManageService;
import com.tencent.mobileqq.troopmanage.event.TroopManageAdminListEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageAuthEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageGetHeadEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageGetSmartEntranceEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageGetTroopTypeEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageModifyTroopGameCardSwitchEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManagePrettyEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageSetLuckyCharacterSwitchEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageSetTroopEssenceMsgShowEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageSpeechLimitEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageTransferTroopMembersEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageTroopFeedEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageUpdateSmartManagerSettingEvent;
import com.tencent.mobileqq.troopmanage.event.TroopSetInviteRobotSwitchEvent;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IGuildTroopApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0081\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0082\u0001B\u0010\u0012\u0006\u0010-\u001a\u00020(\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b`\tH\u0016J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012JI\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00050\u0018J\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u000fJ\b\u0010\"\u001a\u0004\u0018\u00010!J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010'\u001a\u00020\u000fR\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00107\u001a\b\u0012\u0004\u0012\u000202018\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u000208018\u0006\u00a2\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u00106R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020<018\u0006\u00a2\u0006\f\n\u0004\b=\u00104\u001a\u0004\b>\u00106R\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020@018\u0006\u00a2\u0006\f\n\u0004\bA\u00104\u001a\u0004\bB\u00106R\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020D018\u0006\u00a2\u0006\f\n\u0004\bE\u00104\u001a\u0004\bF\u00106R\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020H018\u0006\u00a2\u0006\f\n\u0004\bI\u00104\u001a\u0004\bJ\u00106R\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020L018\u0006\u00a2\u0006\f\n\u0004\bM\u00104\u001a\u0004\bN\u00106R\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020P018\u0006\u00a2\u0006\f\n\u0004\bQ\u00104\u001a\u0004\bR\u00106R\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020T018\u0006\u00a2\u0006\f\n\u0004\bU\u00104\u001a\u0004\bV\u00106R\u001d\u0010[\u001a\b\u0012\u0004\u0012\u00020X018\u0006\u00a2\u0006\f\n\u0004\bY\u00104\u001a\u0004\bZ\u00106R\u001d\u0010_\u001a\b\u0012\u0004\u0012\u00020\\018\u0006\u00a2\u0006\f\n\u0004\b]\u00104\u001a\u0004\b^\u00106R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020`018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u00104R\u001d\u0010f\u001a\b\u0012\u0004\u0012\u00020c018\u0006\u00a2\u0006\f\n\u0004\bd\u00104\u001a\u0004\be\u00106R\u001d\u0010i\u001a\b\u0012\u0004\u0012\u00020\u0012018\u0006\u00a2\u0006\f\n\u0004\bg\u00104\u001a\u0004\bh\u00106R\u001d\u0010m\u001a\b\u0012\u0004\u0012\u00020j018\u0006\u00a2\u0006\f\n\u0004\bk\u00104\u001a\u0004\bl\u00106R\u001d\u0010q\u001a\b\u0012\u0004\u0012\u00020n018\u0006\u00a2\u0006\f\n\u0004\bo\u00104\u001a\u0004\bp\u00106R\u001d\u0010t\u001a\b\u0012\u0004\u0012\u00020#018\u0006\u00a2\u0006\f\n\u0004\br\u00104\u001a\u0004\bs\u00106R\u001d\u0010z\u001a\u0004\u0018\u00010u8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u0014\u0010~\u001a\u00020{8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010}\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/os/Bundle;", "arguments", "L1", "M1", "", "isChecked", "l2", "", "S1", "troopUin", "", "troopPrivilegeFlag", "privilegeMask", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "callback", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/mobileqq/troopmanage/api/ITroopManageService;", "T1", "j2", "LGROUP/MessageRemindRsp;", "W1", "", "N1", "Q1", "m2", "k2", "Lcom/tencent/mobileqq/troopmanage/repo/a;", "i", "Lcom/tencent/mobileqq/troopmanage/repo/a;", "X1", "()Lcom/tencent/mobileqq/troopmanage/repo/a;", "repository", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "receiverRegistered", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troopmanage/event/TroopManageGetSmartEntranceEvent;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "getSmartEntrance", "Lcom/tencent/mobileqq/troopmanage/event/TroopManageUpdateSmartManagerSettingEvent;", "D", "c2", "smartManageSetting", "Lcom/tencent/mobileqq/troopmanage/event/TroopManageAdminListEvent;", "E", "U1", "manageAdminList", "Lcom/tencent/mobileqq/troop/jointype/event/TroopManageAutoApprovalEvent;", UserInfo.SEX_FEMALE, "O1", "autoApproval", "Lcom/tencent/mobileqq/troopmanage/event/TroopManageSpeechLimitEvent;", "G", "d2", "speechLimit", "Lcom/tencent/mobileqq/troopmanage/event/TroopManageTroopFeedEvent;", "H", "f2", "troopFeed", "Lcom/tencent/mobileqq/troopmanage/event/TroopManageSetTroopEssenceMsgShowEvent;", "I", "b2", "setTroopEssenceMsgShow", "Lcom/tencent/mobileqq/troopmanage/event/TroopManageModifyTroopGameCardSwitchEvent;", "J", "getModifyTroopGameCardSwitch", "modifyTroopGameCardSwitch", "Lcom/tencent/mobileqq/troopmanage/event/TroopManageTransferTroopMembersEvent;", "K", "e2", "transferTroopMember", "Lcom/tencent/mobileqq/troopmanage/event/TroopManagePrettyEvent;", "L", "i2", "troopPretty", "Lcom/tencent/mobileqq/troopmanage/event/TroopManageSetLuckyCharacterSwitchEvent;", "M", ICustomDataEditor.STRING_ARRAY_PARAM_2, "setLuckyCharacterSwitch", "Lcom/tencent/mobileqq/troopmanage/event/TroopManageGetHeadEvent;", "N", "getHead", "Lcom/tencent/mobileqq/troopmanage/event/TroopManageGetTroopTypeEvent;", "P", "getGetTroopType", "getTroopType", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, SemanticAttributes.DbSystemValues.H2, "troopNameRule", "Lcom/tencent/mobileqq/troopmanage/event/TroopManageAuthEvent;", BdhLogUtil.LogTag.Tag_Req, "g2", "troopManageAuth", "Lcom/tencent/mobileqq/troopmanage/event/TroopSetInviteRobotSwitchEvent;", ExifInterface.LATITUDE_SOUTH, "getInviteRobotSwitch", "inviteRobotSwitch", "T", "P1", "flameSwitchStatus", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;", "U", "Lkotlin/Lazy;", "Z1", "()Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;", "searchWayViewModel", "Landroid/content/BroadcastReceiver;", "V", "Landroid/content/BroadcastReceiver;", "mReceiver", "<init>", "(Lcom/tencent/mobileqq/troopmanage/repo/a;)V", "W", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopManageViewModel extends ViewModel implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageGetSmartEntranceEvent> getSmartEntrance;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageUpdateSmartManagerSettingEvent> smartManageSetting;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageAdminListEvent> manageAdminList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageAutoApprovalEvent> autoApproval;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageSpeechLimitEvent> speechLimit;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageTroopFeedEvent> troopFeed;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageSetTroopEssenceMsgShowEvent> setTroopEssenceMsgShow;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageModifyTroopGameCardSwitchEvent> modifyTroopGameCardSwitch;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageTransferTroopMembersEvent> transferTroopMember;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManagePrettyEvent> troopPretty;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageSetLuckyCharacterSwitchEvent> setLuckyCharacterSwitch;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageGetHeadEvent> getHead;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageGetTroopTypeEvent> getTroopType;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> troopNameRule;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopManageAuthEvent> troopManageAuth;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopSetInviteRobotSwitchEvent> inviteRobotSwitch;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> flameSwitchStatus;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchWayViewModel;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final BroadcastReceiver mReceiver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a repository;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean receiverRegistered;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troopmanage/repo/TroopManageViewModel$b", "Lcs2/a;", "", "switchStatus", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements cs2.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageViewModel.this);
            }
        }

        @Override // cs2.a
        public void a(int switchStatus) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, switchStatus);
            } else {
                TroopManageViewModel.this.P1().postValue(Integer.valueOf(switchStatus));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63074);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopManageViewModel(@NotNull a repository) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(repository, "repository");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) repository);
            return;
        }
        this.repository = repository;
        QLog.d("TroopManageViewModel", 1, "init(" + hashCode() + "), repository=" + repository.hashCode());
        this.getSmartEntrance = new MutableLiveData<>();
        this.smartManageSetting = new MutableLiveData<>();
        this.manageAdminList = new MutableLiveData<>();
        this.autoApproval = new MutableLiveData<>();
        this.speechLimit = new MutableLiveData<>();
        this.troopFeed = new MutableLiveData<>();
        this.setTroopEssenceMsgShow = new MutableLiveData<>();
        this.modifyTroopGameCardSwitch = new MutableLiveData<>();
        this.transferTroopMember = new MutableLiveData<>();
        this.troopPretty = new MutableLiveData<>();
        this.setLuckyCharacterSwitch = new MutableLiveData<>();
        this.getHead = new MutableLiveData<>();
        this.getTroopType = new MutableLiveData<>();
        this.troopNameRule = new MutableLiveData<>();
        this.troopManageAuth = new MutableLiveData<>();
        this.inviteRobotSwitch = new MutableLiveData<>();
        this.flameSwitchStatus = new MutableLiveData<>();
        lazy = LazyKt__LazyJVMKt.lazy(TroopManageViewModel$searchWayViewModel$2.INSTANCE);
        this.searchWayViewModel = lazy;
        this.mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel$mReceiver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                if (intent != null) {
                    str = intent.getAction();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual("action_update_smart_manager_setting_status", str)) {
                    int intExtra = intent.getIntExtra("id", -1);
                    boolean booleanExtra = intent.getBooleanExtra("isSet", false);
                    QLog.d("TroopManageViewModel", 1, "update smart manager setting status, id=" + intExtra + " isSet=" + booleanExtra);
                    SimpleEventBus.getInstance().dispatchEvent(new TroopManageUpdateSmartManagerSettingEvent(intExtra, booleanExtra));
                }
            }
        };
    }

    public final void L1(@NotNull Bundle arguments) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) arguments);
            return;
        }
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        QLog.d("TroopManageViewModel", 1, "onCreated(" + hashCode() + ") repository=" + this.repository.hashCode() + " arguments=" + arguments.hashCode());
        this.repository.b(arguments);
        if (this.receiverRegistered) {
            return;
        }
        this.receiverRegistered = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_update_smart_manager_setting_status");
        BaseApplication.getContext().registerReceiver(this.mReceiver, intentFilter);
    }

    public final void M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        QLog.d("TroopManageViewModel", 1, "onDestroy(" + hashCode() + ")");
        this.repository.onDestroy();
        if (!this.receiverRegistered) {
            return;
        }
        this.receiverRegistered = false;
        try {
            BaseApplication.getContext().unregisterReceiver(this.mReceiver);
        } catch (IllegalArgumentException e16) {
            QLog.e("TroopManageViewModel", 1, "unregisterReceiver exception", e16);
        }
    }

    public final int N1() {
        List emptyList;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        String administrator = this.repository.m().h().Administrator;
        if (TextUtils.isEmpty(administrator)) {
            return 0;
        }
        Intrinsics.checkNotNullExpressionValue(administrator, "administrator");
        List<String> split = new Regex("\\|").split(administrator, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        int i3 = 0;
        for (String str : (String[]) array) {
            if (!TextUtils.isEmpty(str)) {
                i3++;
            }
        }
        return i3;
    }

    @NotNull
    public final MutableLiveData<TroopManageAutoApprovalEvent> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.autoApproval;
    }

    @NotNull
    public final MutableLiveData<Integer> P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.flameSwitchStatus;
    }

    public final void Q1() {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.repository.m().j());
            if (longOrNull != null) {
                ((ITroopManageAccessHandlerApi) QRoute.api(ITroopManageAccessHandlerApi.class)).getFlameSwitchStatus(longOrNull.longValue(), new b());
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 31, (Object) this);
    }

    @NotNull
    public final MutableLiveData<TroopManageGetSmartEntranceEvent> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.getSmartEntrance;
    }

    @NotNull
    public final String S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return ("https://qun.qq.com/m/qun/activedata/active.html?_wv=3&_wwv=128&gc=" + this.repository.m().j()) + "&src=2";
    }

    @NotNull
    public final ITroopManageService T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (ITroopManageService) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.repository.n();
    }

    @NotNull
    public final MutableLiveData<TroopManageAdminListEvent> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.manageAdminList;
    }

    @Nullable
    public final MessageRemindRsp W1() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (MessageRemindRsp) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        if (!QVIPPrettyTroopProcessor.get().showCreateIcon) {
            return null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null || !this.repository.m().h().checkFlagExt4(3)) {
            return null;
        }
        return TroopManager.t(qQAppInterface, this.repository.m().j());
    }

    @NotNull
    public final a X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.repository;
    }

    @Nullable
    public final com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return (com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b) this.searchWayViewModel.getValue();
    }

    @NotNull
    public final MutableLiveData<TroopManageSetLuckyCharacterSwitchEvent> a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.setLuckyCharacterSwitch;
    }

    @NotNull
    public final MutableLiveData<TroopManageSetTroopEssenceMsgShowEvent> b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.setTroopEssenceMsgShow;
    }

    @NotNull
    public final MutableLiveData<TroopManageUpdateSmartManagerSettingEvent> c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.smartManageSetting;
    }

    @NotNull
    public final MutableLiveData<TroopManageSpeechLimitEvent> d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.speechLimit;
    }

    @NotNull
    public final MutableLiveData<TroopManageTransferTroopMembersEvent> e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.transferTroopMember;
    }

    @NotNull
    public final MutableLiveData<TroopManageTroopFeedEvent> f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.troopFeed;
    }

    @NotNull
    public final MutableLiveData<TroopManageAuthEvent> g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.troopManageAuth;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopManageUpdateSmartManagerSettingEvent.class, TroopManageAdminListEvent.class, TroopManageAutoApprovalEvent.class, TroopManageSpeechLimitEvent.class, TroopManageTroopFeedEvent.class, TroopManageSetTroopEssenceMsgShowEvent.class, TroopManageModifyTroopGameCardSwitchEvent.class, TroopManageTransferTroopMembersEvent.class, TroopManagePrettyEvent.class, TroopManageGetSmartEntranceEvent.class, TroopManageSetLuckyCharacterSwitchEvent.class, TroopManageGetHeadEvent.class, TroopManageGetTroopTypeEvent.class, TroopManageAuthEvent.class, TroopSetInviteRobotSwitchEvent.class, TroopAutoApprovalSettingUpdate.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 21, (Object) this);
    }

    @NotNull
    public final MutableLiveData<String> h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.troopNameRule;
    }

    @NotNull
    public final MutableLiveData<TroopManagePrettyEvent> i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.troopPretty;
    }

    public final boolean j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return NetworkUtil.isNetworkAvailable(BaseApplication.getContext());
    }

    public final boolean k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        String j3 = this.repository.m().j();
        if (!this.repository.m().i().isTroopGuild) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopManageViewModel", 2, "needShowTroopFeedConfig return false, troopUin:" + j3 + " not TroopGuild");
            }
            return false;
        }
        if (!((IGuildTroopApi) QRoute.api(IGuildTroopApi.class)).isNeedHideTroopGuildEntrance()) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopManageViewModel", 2, "needShowTroopFeedConfig return true, troopUin:" + j3 + " isTroopGuild remoteConfigValue false");
            }
            return true;
        }
        if (this.repository.m().i().troopFeedSwitch) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopManageViewModel", 2, "needShowTroopFeedConfig return true, troopUin:" + j3 + " isTroopGuild remoteConfigValue true, switchValue true");
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopManageViewModel", 2, "needShowTroopFeedConfig return false, troopUin:" + j3 + " isTroopGuild remoteConfigValue true, but switchValue false");
        }
        return false;
    }

    public final void l2(boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, isChecked);
        } else {
            this.repository.c(isChecked);
        }
    }

    public final void m2(boolean isChecked) {
        Long longOrNull;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.repository.m().j());
            if (longOrNull != null) {
                long longValue = longOrNull.longValue();
                ITroopManageAccessHandlerApi iTroopManageAccessHandlerApi = (ITroopManageAccessHandlerApi) QRoute.api(ITroopManageAccessHandlerApi.class);
                if (isChecked) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                iTroopManageAccessHandlerApi.setFlameSwitch(longValue, i3);
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 32, (Object) this, isChecked);
    }

    public final void n2(boolean isChecked, @NotNull String troopUin, long troopPrivilegeFlag, long privilegeMask, @NotNull Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Boolean.valueOf(isChecked), troopUin, Long.valueOf(troopPrivilegeFlag), Long.valueOf(privilegeMask), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.repository.e(isChecked, troopUin, troopPrivilegeFlag, privilegeMask, callback);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) event);
            return;
        }
        if (event instanceof TroopManageUpdateSmartManagerSettingEvent) {
            this.smartManageSetting.postValue(event);
            return;
        }
        if (event instanceof TroopManageAdminListEvent) {
            this.manageAdminList.postValue(event);
            return;
        }
        if (event instanceof TroopManageAutoApprovalEvent) {
            this.autoApproval.postValue(event);
            return;
        }
        if (event instanceof TroopManageSpeechLimitEvent) {
            this.speechLimit.postValue(event);
            return;
        }
        if (event instanceof TroopManageTroopFeedEvent) {
            this.troopFeed.postValue(event);
            return;
        }
        if (event instanceof TroopManageSetTroopEssenceMsgShowEvent) {
            this.repository.m().h().groupExt.essentialMsgSwitch = ((TroopManageSetTroopEssenceMsgShowEvent) event).getResult() ? 1 : 0;
            this.setTroopEssenceMsgShow.postValue(event);
            return;
        }
        if (event instanceof TroopManageModifyTroopGameCardSwitchEvent) {
            this.modifyTroopGameCardSwitch.postValue(event);
            return;
        }
        if (event instanceof TroopManageTransferTroopMembersEvent) {
            this.transferTroopMember.postValue(event);
            return;
        }
        if (event instanceof TroopManagePrettyEvent) {
            this.troopPretty.postValue(event);
            return;
        }
        if (event instanceof TroopManageGetSmartEntranceEvent) {
            this.getSmartEntrance.postValue(event);
            return;
        }
        if (event instanceof TroopManageSetLuckyCharacterSwitchEvent) {
            this.setLuckyCharacterSwitch.postValue(event);
            return;
        }
        if (event instanceof TroopManageGetHeadEvent) {
            this.getHead.postValue(event);
            return;
        }
        if (event instanceof TroopManageGetTroopTypeEvent) {
            this.getTroopType.postValue(event);
            return;
        }
        if (event instanceof TroopManageAuthEvent) {
            this.troopManageAuth.postValue(event);
            return;
        }
        if (event instanceof TroopSetInviteRobotSwitchEvent) {
            this.inviteRobotSwitch.postValue(event);
        } else if (event instanceof TroopAutoApprovalSettingUpdate) {
            TroopAutoApprovalSettingUpdate troopAutoApprovalSettingUpdate = (TroopAutoApprovalSettingUpdate) event;
            this.repository.s(troopAutoApprovalSettingUpdate.getUpdateFromWeb(), troopAutoApprovalSettingUpdate.getGroupCode(), troopAutoApprovalSettingUpdate.getAutoApprovalSetting());
        }
    }
}
