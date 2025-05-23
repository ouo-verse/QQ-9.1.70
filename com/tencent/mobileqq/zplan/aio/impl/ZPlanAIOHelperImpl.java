package com.tencent.mobileqq.zplan.aio.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.api.IAIOApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.event.EmotionPanelMsgIntent;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper;
import com.tencent.mobileqq.zplan.aio.IZPlanHeadEffectUtil;
import com.tencent.mobileqq.zplan.aio.a;
import com.tencent.mobileqq.zplan.aio.headeffect.manager.ZPlanHeadEffectManager;
import com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance;
import com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrancesAdapter;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.easteregg.w;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper;
import com.tencent.mobileqq.zplan.emoticon.grayTip.ZPlanEmoticonGrayTipManager;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.emoticon.report.ZPlanEmoticonReport;
import com.tencent.mobileqq.zplan.model.ZPlanHeadEffectFlag;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.state.data.SquareJSConst;
import com.tencent.widget.XPanelContainer;
import common.config.service.QzoneConfig;
import fi3.bq;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import le3.ApiPanelEventHandler;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

@Metadata(d1 = {"\u0000\u00db\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001^\u0018\u0000 f2\u00020\u0001:\u0002ghB\u0007\u00a2\u0006\u0004\bd\u0010eJ0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J0\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0016\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%H\u0016J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%2\u0006\u0010)\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010&\u001a\u00020%H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0019\u0010.\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b.\u0010/J\u0018\u00101\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00100\u001a\u00020\fH\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\b\u00104\u001a\u000203H\u0016J\u0010\u00106\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\bH\u0016J<\u00109\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J&\u0010<\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020H0G2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\"0\u00162\u0006\u0010B\u001a\u00020\"2\u0006\u0010D\u001a\u00020C2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0EH\u0016J\u0018\u0010M\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\u0006H\u0016R\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010X\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\"\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010]R\u0014\u0010_\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010b\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010c\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/impl/ZPlanAIOHelperImpl;", "Lcom/tencent/mobileqq/zplan/aio/IZPlanAIOHelper;", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/common/app/AppInterface;", "app", "", "uin", "", "scaleChatType", "Landroid/os/Bundle;", "bundle", "", "openMiniFriendMsgAIO", "openMiniTroopMsgAIO", "", "handleAIOShowFirstState", "tryCreateHeadEffectManager", "handleAIOShowState", "handleAIOPauseState", "handleAIODestroyState", "prepareZPlanInfoAndRecordActions", "", SquareJSConst.Params.PARAMS_UIN_LIST, "requireUserZPlanInfo", "", "baseChatPie", "init", "oldPanel", "newPanel", "onPanelChanged", "onAioDoubleTap", "", "bubbleId", "Landroid/view/View;", "getHeadEffectFullView", "onHeadEffectEnd", "Lcom/tencent/mobileqq/data/MessageRecord;", "message", "Lcom/tencent/mobileqq/zplan/model/ZPlanHeadEffectFlag;", "getFlag", "flag", "setFlag", "setUnread", "Lcom/tencent/mobileqq/zplan/easteregg/w;", "getEasterEggPagManager", "hasRequestZPlanInfo", "(Ljava/lang/String;)Ljava/lang/Boolean;", "hasRequest", "setRequestZPlanInfoFlag", "getTag", "", "interestedIn", "state", "onMoveToState", "entranceType", "uinType", "openMiniMsgAIO", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "showEmoticonGrayTipsIfNeed", "Landroid/content/Context;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "behindViews", "popupParent", "Lle3/a;", "handler", "Lkotlinx/coroutines/channels/ReceiveChannel;", "drawerIsOpened", "Lkotlin/Pair;", "Lug3/a;", "generatePanelViewAndAdapter", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "tabName", "openPanel", "La61/c;", "chatPie", "La61/c;", "Lee3/a;", "eventHandler", "Lee3/a;", "Lcom/tencent/mobileqq/zplan/aio/a;", "aioAvatarJudge", "Lcom/tencent/mobileqq/zplan/aio/a;", "Lje3/a;", "headEffectManager", "Lje3/a;", "effectManager", "Lcom/tencent/mobileqq/zplan/easteregg/w;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "com/tencent/mobileqq/zplan/aio/impl/ZPlanAIOHelperImpl$e", "zplanRequestObserver", "Lcom/tencent/mobileqq/zplan/aio/impl/ZPlanAIOHelperImpl$e;", "Lcom/tencent/widget/XPanelContainer$f;", "panelListener", "Lcom/tencent/widget/XPanelContainer$f;", "<init>", "()V", "Companion", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAIOHelperImpl implements IZPlanAIOHelper {
    public static final String TAG = "[zplan][ZPlanAIOHelperImpl]";
    private static ge3.a fullscreenMemeListener;
    private com.tencent.mobileqq.zplan.aio.a aioAvatarJudge;
    private a61.c chatPie;
    private w effectManager;
    private je3.a headEffectManager;
    private volatile ee3.a eventHandler = new ee3.a();
    private volatile ConcurrentHashMap<String, Boolean> hasRequestZPlanInfo = new ConcurrentHashMap<>();
    private final e zplanRequestObserver = new e();
    private final XPanelContainer.f panelListener = new XPanelContainer.f() { // from class: com.tencent.mobileqq.zplan.aio.impl.b
        @Override // com.tencent.widget.XPanelContainer.f
        public final void a(int i3, int i16) {
            ZPlanAIOHelperImpl.panelListener$lambda$0(ZPlanAIOHelperImpl.this, i3, i16);
        }
    };

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/impl/ZPlanAIOHelperImpl$a;", "Lkotlin/Function0;", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements Function0<Unit> {
        public void a() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            ZplanDataRepository zplanDataRepository = ZplanDataRepository.f334898a;
            String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
            boolean z16 = false;
            String str = ZplanDataRepository.l(zplanDataRepository, currentAccountUin, false, 2, null).appearanceKey;
            ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
            String C1 = zPlanFeatureSwitch.C1();
            boolean isLowPerfDevice = DeviceInfoUtils.isLowPerfDevice();
            long X = ah.X();
            long N0 = zPlanFeatureSwitch.N0();
            QLog.i(ZPlanAIOHelperImpl.TAG, 1, "prepareZPlanInfoAndRecordActions, appearanceKey = " + str + ", officialAppearanceKey = " + C1 + ", lowPerfDevice = " + isLowPerfDevice + ", availableMemory = " + X);
            boolean z17 = (str.length() > 0) && !Intrinsics.areEqual(str, C1);
            if (!isLowPerfDevice && X >= N0) {
                z16 = true;
            }
            if (z17 && z16) {
                ZPlanEmoticonUtil.f333176e.Z(ZPlanFeatureSwitch.Q1());
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aio/impl/ZPlanAIOHelperImpl$c", "Lcom/tencent/qqnt/troopmemberlist/f;", "", "isSuccess", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.qqnt.troopmemberlist.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f331051a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanAIOHelperImpl f331052b;

        c(String str, ZPlanAIOHelperImpl zPlanAIOHelperImpl) {
            this.f331051a = str;
            this.f331052b = zPlanAIOHelperImpl;
        }

        @Override // com.tencent.qqnt.troopmemberlist.f
        public void a(boolean isSuccess, List<? extends TroopMemberInfo> troopMemberList) {
            List mutableListOf;
            Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(this.f331051a);
            for (TroopMemberInfo troopMemberInfo : troopMemberList) {
                String memberuin = troopMemberInfo.memberuin;
                if (memberuin != null) {
                    Intrinsics.checkNotNullExpressionValue(memberuin, "memberuin");
                    mutableListOf.add(troopMemberInfo.memberuin);
                }
            }
            this.f331052b.requireUserZPlanInfo(mutableListOf);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aio/impl/ZPlanAIOHelperImpl$e", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.mobileqq.zplan.servlet.b {
        e() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            List<String> emptyList;
            if (type == 6) {
                ee3.a aVar = ZPlanAIOHelperImpl.this.eventHandler;
                a61.c cVar = ZPlanAIOHelperImpl.this.chatPie;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatPie");
                    cVar = null;
                }
                QQAppInterface qQAppInterface = cVar.f25577b;
                aVar.h(qQAppInterface != null ? qQAppInterface.getCurrentAccountUin() : null);
                return;
            }
            if (type == 7) {
                if (data instanceof Boolean) {
                    ZPlanAIOHelperImpl.this.eventHandler.i(((Boolean) data).booleanValue());
                }
            } else {
                if (type != 27405) {
                    return;
                }
                try {
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String?>");
                    emptyList = (List) data;
                } catch (Throwable th5) {
                    QLog.e(ZPlanAIOHelperImpl.TAG, 1, "PROFILE_APPEARANCE_KEY exception", th5);
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                ee3.a aVar2 = ZPlanAIOHelperImpl.this.eventHandler;
                a61.c cVar2 = ZPlanAIOHelperImpl.this.chatPie;
                if (cVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatPie");
                    cVar2 = null;
                }
                QQAppInterface qQAppInterface2 = cVar2.f25577b;
                aVar2.f(qQAppInterface2 != null ? qQAppInterface2.getCurrentAccountUin() : null, emptyList);
            }
        }
    }

    private final void handleAIODestroyState() {
        a61.c cVar = this.chatPie;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
            cVar = null;
        }
        QQAppInterface qQAppInterface = cVar.f25577b;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.zplanRequestObserver);
        }
        fullscreenMemeListener = null;
        je3.a aVar = this.headEffectManager;
        if (aVar != null) {
            aVar.destroy();
        }
        this.headEffectManager = null;
        this.hasRequestZPlanInfo.clear();
    }

    private final void handleAIOPauseState() {
        ZPlanEmoticonReport.f333324a.m();
        ConcurrentHashMap<String, Boolean> concurrentHashMap = this.hasRequestZPlanInfo;
        a61.c cVar = this.chatPie;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
            cVar = null;
        }
        QQAppInterface qQAppInterface = cVar.f25577b;
        TypeIntrinsics.asMutableMap(concurrentHashMap).remove(qQAppInterface != null ? qQAppInterface.getCurrentUin() : null);
    }

    private final void handleAIOShowFirstState() {
        a61.c cVar = this.chatPie;
        a61.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
            cVar = null;
        }
        QQAppInterface qQAppInterface = cVar.f25577b;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.zplanRequestObserver);
        }
        a61.c cVar3 = this.chatPie;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
            cVar3 = null;
        }
        XPanelContainer l3 = cVar3.l();
        if (l3 != null) {
            l3.setOnGoingToShowPanelListener(this.panelListener);
        }
        a61.c cVar4 = this.chatPie;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
        } else {
            cVar2 = cVar4;
        }
        QQMessageFacade messageFacade = cVar2.f25577b.getMessageFacade();
        Intrinsics.checkNotNullExpressionValue(messageFacade, "chatPie.app.messageFacade");
        fullscreenMemeListener = new ie3.a(messageFacade);
        if (((IZPlanHeadEffectUtil) QRoute.api(IZPlanHeadEffectUtil.class)).enable("aio")) {
            tryCreateHeadEffectManager();
        }
    }

    private final void handleAIOShowState() {
        prepareZPlanInfoAndRecordActions();
    }

    private final boolean openMiniFriendMsgAIO(Fragment fragment, AppInterface app, String uin, int scaleChatType, Bundle bundle) {
        IRuntimeService runtimeService = app.getRuntimeService(IFriendNameService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        String friendName = ((IFriendNameService) runtimeService).getFriendName(uin);
        String str = friendName == null ? "" : friendName;
        QLog.i(TAG, 1, "openMiniMsgAIO-openFriendAIO " + com.tencent.mobileqq.qcall.g.b(uin) + ", name: " + str);
        ((IAIOApi) QRoute.api(IAIOApi.class)).startChatAndRecordTask(fragment, uin, 0, str, bundle, scaleChatType);
        return true;
    }

    private final boolean openMiniTroopMsgAIO(Fragment fragment, AppInterface app, String uin, int scaleChatType, Bundle bundle) {
        IRuntimeService runtimeService = app.getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(uin);
        String str = findTroopInfo != null ? findTroopInfo.troopname : null;
        String str2 = str == null ? "" : str;
        QLog.i(TAG, 1, "openMiniMsgAIO-openTroopAIO " + com.tencent.mobileqq.qcall.g.b(uin) + ", name: " + str2);
        ((IAIOApi) QRoute.api(IAIOApi.class)).startChatAndRecordTask(fragment, uin, 1, str2, bundle, scaleChatType);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void panelListener$lambda$0(ZPlanAIOHelperImpl this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.eventHandler.a(i3, i16);
    }

    private final void prepareZPlanInfoAndRecordActions() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAIOHelperImpl.prepareZPlanInfoAndRecordActions$lambda$5(ZPlanAIOHelperImpl.this);
            }
        }, 160, null, true, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareZPlanInfoAndRecordActions$lambda$5(ZPlanAIOHelperImpl this$0) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a61.c cVar = this$0.chatPie;
        a61.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
            cVar = null;
        }
        QQAppInterface qQAppInterface = cVar.f25577b;
        if (qQAppInterface == null) {
            return;
        }
        if (!((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(Constant.FROM_ID_START_ACTIVITY, qQAppInterface.getLongAccountUin())) {
            QLog.i(TAG, 1, "prepareZPlanInfoAndRecordActions, emoticonSceneShow: false");
            return;
        }
        if (!ZPlanFeatureSwitch.f369852a.T()) {
            QLog.i(TAG, 1, "prepareZPlanInfoAndRecordActions, enableRecordMemeOnEnterAIO: false");
            return;
        }
        a61.c cVar3 = this$0.chatPie;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
        } else {
            cVar2 = cVar3;
        }
        SessionInfo sessionInfo = cVar2.f25589n;
        if (sessionInfo == null) {
            return;
        }
        int i3 = sessionInfo.f179555d;
        String str = sessionInfo.f179557e;
        boolean z16 = i3 == 1 || i3 == 3000;
        QLog.i(TAG, 1, "handleAIOShowState, session:" + str + ", isTroop:" + z16);
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        if (!z16) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{currentAccountUin, str});
            this$0.requireUserZPlanInfo(listOf);
        } else {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(str, null, false, TAG, new c(currentAccountUin, this$0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requireUserZPlanInfo(List<String> uinList) {
        ZPlanEmoticonUtil.f333176e.X(uinList, new a());
    }

    private final void tryCreateHeadEffectManager() {
        ZPlanHeadEffectManager zPlanHeadEffectManager = new ZPlanHeadEffectManager();
        a61.c cVar = this.chatPie;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
            cVar = null;
        }
        zPlanHeadEffectManager.j(cVar);
        this.headEffectManager = zPlanHeadEffectManager;
        w createZPlanAvatarEasterEggManager = ((IZPlanApi) QRoute.api(IZPlanApi.class)).createZPlanAvatarEasterEggManager();
        createZPlanAvatarEasterEggManager.c(new d());
        this.effectManager = createZPlanAvatarEasterEggManager;
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public Pair<View, ug3.a> generatePanelViewAndAdapter(Context context, CoroutineScope scope, List<? extends View> behindViews, View popupParent, ApiPanelEventHandler handler, ReceiveChannel<Boolean> drawerIsOpened) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(behindViews, "behindViews");
        Intrinsics.checkNotNullParameter(popupParent, "popupParent");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(drawerIsOpened, "drawerIsOpened");
        SpaceEntrancesAdapter spaceEntrancesAdapter = new SpaceEntrancesAdapter(SpaceEntrance.INSTANCE.b(context, scope, behindViews, popupParent, handler), scope, drawerIsOpened);
        bq g16 = bq.g(LayoutInflater.from(context));
        g16.f399141b.setAdapter(spaceEntrancesAdapter);
        ConstraintLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(LayoutInflater.f\u2026           root\n        }");
        return new Pair<>(root, spaceEntrancesAdapter);
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    /* renamed from: getEasterEggPagManager, reason: from getter */
    public w getEffectManager() {
        return this.effectManager;
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public ZPlanHeadEffectFlag getFlag(MessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
        je3.a aVar = this.headEffectManager;
        if (aVar != null) {
            return aVar.getFlag(message);
        }
        return ZPlanHeadEffectFlag.NONE;
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public View getHeadEffectFullView(long bubbleId) {
        je3.a aVar = this.headEffectManager;
        if (aVar != null) {
            return aVar.getHeadEffectFullView(bubbleId);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public String getTag() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public Boolean hasRequestZPlanInfo(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return this.hasRequestZPlanInfo.get(uin);
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public void init(Object baseChatPie) {
        Intrinsics.checkNotNullParameter(baseChatPie, "baseChatPie");
        this.chatPie = (a61.c) baseChatPie;
        a61.c cVar = this.chatPie;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
            cVar = null;
        }
        this.aioAvatarJudge = new com.tencent.mobileqq.zplan.aio.a(new a.Param(cVar));
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public void onHeadEffectEnd(long bubbleId) {
        je3.a aVar = this.headEffectManager;
        if (aVar != null) {
            aVar.onHeadEffectEnd(bubbleId);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public void onPanelChanged(int oldPanel, int newPanel) {
        this.eventHandler.g(oldPanel, newPanel);
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public boolean openMiniMsgAIO(Fragment fragment, String uin, int entranceType, int uinType, int scaleChatType, Bundle bundle) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i(TAG, 1, "openMiniMsgAio, " + com.tencent.mobileqq.qcall.g.b(uin) + ", entranceType: " + entranceType + ", uinType: " + uinType);
        if (fragment == null) {
            QLog.e(TAG, 1, "openMiniMsgAio failed, fragment null.");
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return false;
        }
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        bundle2.putInt(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, entranceType);
        if (uinType == 0) {
            return openMiniFriendMsgAIO(fragment, appInterface, uin, scaleChatType, bundle2);
        }
        if (uinType != 1) {
            QLog.e(TAG, 1, "openMiniMsgAIO failed, uinType invalid: " + uinType);
            return false;
        }
        return openMiniTroopMsgAIO(fragment, appInterface, uin, scaleChatType, bundle2);
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public void openPanel(com.tencent.aio.api.runtime.a aioContext, String tabName) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        com.tencent.mvi.base.route.j e16 = aioContext.e();
        if (e16 == null) {
            return;
        }
        if (tabName.length() == 0) {
            tabName = "\u52a8\u4f5c";
        }
        ((IZPlanEmoticonInfoHelper) QRoute.api(IZPlanEmoticonInfoHelper.class)).setEmoticonNextOpenPage(tabName);
        e16.h(new EmotionPanelMsgIntent.SetEmotionPanelDefaultType(17));
        e16.h(new PanelContainerMsgIntent.ShowPanelMsgIntent(TAG, 1001, false, 0, 12, null));
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public void setFlag(MessageRecord message, ZPlanHeadEffectFlag flag) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(flag, "flag");
        je3.a aVar = this.headEffectManager;
        if (aVar != null) {
            aVar.setFlag(message, flag);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public void setRequestZPlanInfoFlag(String uin, boolean hasRequest) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.hasRequestZPlanInfo.put(uin, Boolean.valueOf(hasRequest));
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public ZPlanHeadEffectFlag setUnread(MessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
        je3.a aVar = this.headEffectManager;
        if (aVar != null) {
            a61.c cVar = this.chatPie;
            a61.c cVar2 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatPie");
                cVar = null;
            }
            int i3 = cVar.f25589n.f179555d;
            a61.c cVar3 = this.chatPie;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatPie");
            } else {
                cVar2 = cVar3;
            }
            return aVar.a(i3, message, cVar2.f25589n);
        }
        return ZPlanHeadEffectFlag.NONE;
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public void showEmoticonGrayTipsIfNeed(MessageRecord message, com.tencent.mobileqq.activity.aio.p sessionInfo, AppInterface app) {
        ZPlanEmoticonGrayTipManager.f333111a.f(message, sessionInfo, app);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/aio/impl/ZPlanAIOHelperImpl$d", "Lcom/tencent/mobileqq/zplan/easteregg/w$a;", "", "bubbleId", "", "a", "(Ljava/lang/Long;)V", "d", "b", "", "msgCode", "c", "(Ljava/lang/Long;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements w.a {
        d() {
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.w.a
        public void c(Long bubbleId, int msgCode) {
            je3.a aVar;
            if (bubbleId == null || (aVar = ZPlanAIOHelperImpl.this.headEffectManager) == null) {
                return;
            }
            aVar.onHeadEffectEnd(bubbleId.longValue());
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.w.a
        public void d(Long bubbleId) {
            je3.a aVar;
            if (bubbleId == null || (aVar = ZPlanAIOHelperImpl.this.headEffectManager) == null) {
                return;
            }
            aVar.onHeadEffectEnd(bubbleId.longValue());
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.w.a
        public void a(Long bubbleId) {
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.w.a
        public void b(Long bubbleId) {
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public int[] interestedIn() {
        return new int[]{9, 10, 11, 15};
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper, com.tencent.mobileqq.activity.aio.z
    public void onMoveToState(int state) {
        if (state != 15) {
            switch (state) {
                case 9:
                    handleAIOShowFirstState();
                    return;
                case 10:
                    handleAIOShowState();
                    return;
                case 11:
                    handleAIOPauseState();
                    return;
                default:
                    return;
            }
        }
        handleAIODestroyState();
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper
    public void onAioDoubleTap() {
    }
}
