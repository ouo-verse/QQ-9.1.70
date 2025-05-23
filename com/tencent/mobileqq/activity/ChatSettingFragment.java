package com.tencent.mobileqq.activity;

import MQQ.GetRoamToastRsp;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.richframework.util.RFWNetworkUtils;
import com.tencent.biz.webviewplugin.NTJuBaoUtil;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.biz.webviewplugin.O3ReportUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.a;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.f;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.g;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.stranger.a;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.stranger.d;
import com.tencent.mobileqq.activity.newsetting.business.view.c2c.C2CChatSettingView;
import com.tencent.mobileqq.activity.newsetting.business.view.c2c.StrangerChatSettingView;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.fragment.QIphoneStatusTitleBarFragment;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendFaceApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.matchfriend.report.api.IMatchFriendJubaoApi;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.service.IProfileCardBlacklistService;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.IColdPalaceUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.robot.api.IRobotTempApi;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi;
import com.tencent.mobileqq.zplan.couple.ZPlanCoupleSwitchChgSource;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.aio.helper.api.IAIOGetHandlerClzApi;
import com.tencent.qqnt.aio.settings.NTFriendSettingHelper;
import com.tencent.qqnt.chathistory.api.IChatHistoryApi;
import com.tencent.qqnt.chats.api.IStrangerChatsApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRemoveFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.ResetRobotConversationRq;
import com.tencent.qqnt.kernel.nativeinterface.RobotAIOEvent;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotRemoveFriendRequest;
import com.tencent.qqnt.kernel.nativeinterface.RobotTTSList;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.robot.api.IRobotExtApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.aio.tts.api.IRobotTtsApi;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.timbre.api.IRobotTimbreSettingApi;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.remote.ServiceConst;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DebugKt;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ChatSettingFragment extends QIphoneStatusTitleBarFragment implements View.OnClickListener, com.tencent.mobileqq.qqexpand.chat.d, com.tencent.mobileqq.pad.f {
    static IPatchRedirector $redirector_;
    private static final boolean Y1;
    public static final /* synthetic */ int Z1 = 0;
    private a.C7178a A0;
    private final RecyclerView.OnScrollListener A1;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b B0;
    private boolean B1;
    private FriendListHandler C;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b C0;
    private boolean C1;
    private Bundle D;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b D0;
    private boolean D1;
    private QQAppInterface E;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b E0;
    ExpandObserver E1;
    private QBaseActivity F;
    private d.a F0;
    private long F1;
    private boolean G;
    private com.tencent.mobileqq.activity.newsetting.custom.config.b G0;
    private IKernelRobotListener G1;
    private QQProgressDialog H;
    private com.tencent.mobileqq.activity.newsetting.custom.item.a H0;
    private com.tencent.mobileqq.activity.recent.msgbox.a H1;
    private StrangerChatSettingView I;
    private com.tencent.mobileqq.activity.newsetting.custom.item.a I0;
    private com.tencent.mobileqq.activity.recent.msgbox.h I1;
    private int J;
    private com.tencent.mobileqq.activity.newsetting.custom.item.c J0;
    private final com.tencent.relation.common.servlet.b J1;
    private String K;
    private com.tencent.mobileqq.activity.newsetting.custom.item.c K0;
    private long K1;
    private String L;
    private com.tencent.mobileqq.activity.newsetting.custom.item.c L0;
    TextView L1;
    private String M;
    private View M0;
    RichStatus M1;
    private String N;
    ViewGroup N0;
    private com.tencent.mobileqq.app.cn N1;
    TextView O0;
    private SVIPObserver O1;
    private String P;
    TextView P0;
    private Dialog P1;
    private String Q;
    private String Q0;
    MqqHandler Q1;
    private String R;
    private String R0;
    com.tencent.mobileqq.app.ar R1;
    private int S;
    private int S0;
    ProfileCardObserver S1;
    private boolean T;
    private boolean T0;
    private com.tencent.mobileqq.app.cy T1;
    private boolean U;
    IQvipSpecialSoundManager U0;
    com.tencent.mobileqq.app.bs U1;
    private String V;
    private com.tencent.mobileqq.activity.newsetting.custom.item.d<View> V0;
    private com.tencent.mobileqq.zplan.api.b V1;
    protected boolean W;
    private com.tencent.mobileqq.activity.newsetting.custom.item.b W0;
    final Runnable W1;
    private String X;
    private boolean X0;
    private com.tencent.mobileqq.richstatus.e X1;
    private String Y;
    private boolean Y0;
    private String Z;
    private boolean Z0;

    /* renamed from: a0, reason: collision with root package name */
    private int f175326a0;

    /* renamed from: a1, reason: collision with root package name */
    private boolean f175327a1;

    /* renamed from: b0, reason: collision with root package name */
    private String f175328b0;

    /* renamed from: b1, reason: collision with root package name */
    private String f175329b1;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.mobileqq.matchfriend.utils.d f175330c0;

    /* renamed from: c1, reason: collision with root package name */
    private boolean f175331c1;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f175332d0;

    /* renamed from: d1, reason: collision with root package name */
    private String f175333d1;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f175334e0;

    /* renamed from: e1, reason: collision with root package name */
    private String f175335e1;

    /* renamed from: f0, reason: collision with root package name */
    private float f175336f0;

    /* renamed from: f1, reason: collision with root package name */
    private QQProgressDialog f175337f1;

    /* renamed from: g0, reason: collision with root package name */
    private String f175338g0;

    /* renamed from: g1, reason: collision with root package name */
    private Dialog f175339g1;

    /* renamed from: h0, reason: collision with root package name */
    private final HashMap<String, String> f175340h0;

    /* renamed from: h1, reason: collision with root package name */
    private boolean f175341h1;

    /* renamed from: i0, reason: collision with root package name */
    private f.b f175342i0;

    /* renamed from: i1, reason: collision with root package name */
    private boolean f175343i1;

    /* renamed from: j0, reason: collision with root package name */
    private f.a f175344j0;

    /* renamed from: j1, reason: collision with root package name */
    private int f175345j1;

    /* renamed from: k0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f175346k0;

    /* renamed from: k1, reason: collision with root package name */
    private boolean f175347k1;

    /* renamed from: l0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f175348l0;

    /* renamed from: l1, reason: collision with root package name */
    private boolean f175349l1;

    /* renamed from: m0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f175350m0;

    /* renamed from: m1, reason: collision with root package name */
    private Dialog f175351m1;

    /* renamed from: n0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f175352n0;

    /* renamed from: n1, reason: collision with root package name */
    private QQCustomDialog f175353n1;

    /* renamed from: o0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f175354o0;

    /* renamed from: o1, reason: collision with root package name */
    private boolean f175355o1;

    /* renamed from: p0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f175356p0;

    /* renamed from: p1, reason: collision with root package name */
    private C2CChatSettingView f175357p1;

    /* renamed from: q0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f175358q0;

    /* renamed from: q1, reason: collision with root package name */
    private boolean f175359q1;

    /* renamed from: r0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f175360r0;

    /* renamed from: r1, reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f175361r1;

    /* renamed from: s0, reason: collision with root package name */
    private g.b f175362s0;

    /* renamed from: s1, reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f175363s1;

    /* renamed from: t0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f175364t0;

    /* renamed from: t1, reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f175365t1;

    /* renamed from: u0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f175366u0;

    /* renamed from: u1, reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f175367u1;

    /* renamed from: v0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f175368v0;

    /* renamed from: v1, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f175369v1;

    /* renamed from: w0, reason: collision with root package name */
    private a.C7175a f175370w0;

    /* renamed from: w1, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f175371w1;

    /* renamed from: x0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.e f175372x0;

    /* renamed from: x1, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f175373x1;

    /* renamed from: y0, reason: collision with root package name */
    private ImageView f175374y0;

    /* renamed from: y1, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f175375y1;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f175376z0;

    /* renamed from: z1, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.k f175377z1;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.ChatSettingFragment$29, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass29 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ ChatSettingFragment this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQAppInterface qQAppInterface = this.this$0.E;
                String str = this.this$0.K;
                String str2 = this.this$0.M;
                ChatSettingFragment chatSettingFragment = this.this$0;
                QQUtils.e(qQAppInterface, str, str2, 0, chatSettingFragment.Q1, 500, "0", chatSettingFragment.J);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                ((l71.a) ChatSettingFragment.this.E.getBusinessHandler(BusinessHandlerFactory.FILTER_MSG_BOX_HANDLER)).l(Long.parseLong(ChatSettingFragment.this.K));
            } catch (Exception unused) {
                QLog.e("ChatSettingFragment", 1, "showFilterMsgNoticeDialog(): the uin is not Long");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ChatSettingFragment.this.zm();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e extends com.tencent.mobileqq.app.cn {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.cn
        public void b(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
            } else if (obj != null) {
                ((Integer) obj).intValue();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class f extends SVIPObserver {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onGetRoamToast(boolean z16, GetRoamToastRsp getRoamToastRsp) {
            String str;
            int i3;
            int indexOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), getRoamToastRsp);
                return;
            }
            if (ChatSettingFragment.this.N0 == null) {
                return;
            }
            if (z16 && getRoamToastRsp != null && !TextUtils.isEmpty(getRoamToastRsp.sToast) && ((ISVIPHandler) ChatSettingFragment.this.E.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).shouldShowToast(getRoamToastRsp)) {
                String str2 = getRoamToastRsp.sToast;
                int indexOf2 = str2.indexOf(35);
                if (indexOf2 >= 0 && (indexOf = str2.indexOf(35, (i3 = indexOf2 + 1))) >= 0) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) str2, 0, indexOf2);
                    spannableStringBuilder.append((CharSequence) str2, i3, indexOf);
                    spannableStringBuilder.append((CharSequence) str2, indexOf + 1, str2.length());
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-12541697), indexOf2, indexOf - 1, 33);
                    str2 = spannableStringBuilder;
                }
                ChatSettingFragment.this.O0.setText(str2);
                ChatSettingFragment.this.N0.setTag(getRoamToastRsp);
                ChatSettingFragment.this.N0.setVisibility(0);
                ReportController.o(ChatSettingFragment.this.E, "dc00898", "", "", "0X8009E31", "0X8009E31", 0, 0, "", "", "", "");
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onGetRoamToast: ");
                sb5.append(z16);
                sb5.append(",");
                if (getRoamToastRsp == null) {
                    str = "null";
                } else {
                    str = getRoamToastRsp.sToast;
                }
                sb5.append(str);
                QLog.d("ChatSettingFragment", 2, sb5.toString());
            }
            ChatSettingFragment.this.N0.setVisibility(8);
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onGetRoamType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class g extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, i3);
            } else {
                super.onScrollStateChanged(recyclerView, i3);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                super.onScrolled(recyclerView, i3, i16);
                ChatSettingFragment.this.Gm(i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f175406d;

        h(String str) {
            this.f175406d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ChatSettingFragment.this.f175355o1 = false;
                ChatSettingFragment.this.Bm(this.f175406d, true);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ChatSettingFragment.this.Bj(false);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class j extends MqqHandler {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 18) {
                if (i3 != 16711681) {
                    boolean z18 = false;
                    int i16 = 0;
                    boolean z19 = false;
                    boolean z26 = true;
                    switch (i3) {
                        case 32:
                            if (ChatSettingFragment.this.J == 1006) {
                                if (TextUtils.isEmpty(ChatSettingFragment.this.f175335e1)) {
                                    ChatSettingFragment.this.f175327a1 = false;
                                } else {
                                    String m06 = com.tencent.mobileqq.utils.ac.m0(ChatSettingFragment.this.E, ChatSettingFragment.this.f175335e1);
                                    if (TextUtils.isEmpty(m06)) {
                                        ChatSettingFragment.this.f175327a1 = false;
                                    } else {
                                        ChatSettingFragment.this.f175327a1 = true;
                                        ChatSettingFragment.this.f175329b1 = m06;
                                    }
                                }
                            }
                            ShieldMsgManger shieldMsgManger = (ShieldMsgManger) ChatSettingFragment.this.E.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
                            if (shieldMsgManger != null && !TextUtils.isEmpty(ChatSettingFragment.this.f175329b1)) {
                                ChatSettingFragment chatSettingFragment = ChatSettingFragment.this;
                                chatSettingFragment.Y0 = shieldMsgManger.h(chatSettingFragment.f175329b1);
                            }
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("handleMessage, shieldMsgManger=");
                                if (shieldMsgManger == null) {
                                    z18 = true;
                                }
                                sb5.append(z18);
                                QLog.d("ChatSettingActivity.nearby", 2, sb5.toString());
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("ChatSettingActivity.nearby", 2, "handleMessage, REFRESH_STRANGER_SHIELD_BUTTON, mIsShield=" + ChatSettingFragment.this.Y0 + ", mIsFollowed=" + ChatSettingFragment.this.W + ", mShieldEnable=" + ChatSettingFragment.this.f175327a1);
                            }
                            ChatSettingFragment.this.Tl();
                            return;
                        case 33:
                            ChatSettingFragment.this.Sl();
                            return;
                        case 34:
                            ChatSettingFragment.this.Hm();
                            return;
                        case 35:
                            if (((String) message.obj).equals(ChatSettingFragment.this.K)) {
                                boolean j3 = FriendsStatusUtil.j(ChatSettingFragment.this.E, ChatSettingFragment.this.K, ChatSettingFragment.this.J);
                                if (ChatSettingFragment.this.f175350m0 != null && j3 != ChatSettingFragment.this.f175350m0.W()) {
                                    ChatSettingFragment.this.f175350m0.e0(null);
                                    ChatSettingFragment.this.f175350m0.a0(j3);
                                    ChatSettingFragment.this.f175350m0.e0(ChatSettingFragment.this.f175361r1);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 36:
                            String str = (String) message.obj;
                            if (ChatSettingFragment.this.f175354o0 != null && str.equals(ChatSettingFragment.this.K)) {
                                if (message.arg1 == 1) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (z16 != ChatSettingFragment.this.f175354o0.W()) {
                                    ChatSettingFragment.this.f175354o0.e0(null);
                                    com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = ChatSettingFragment.this.f175354o0;
                                    if (message.arg1 == 1) {
                                        z19 = true;
                                    }
                                    bVar.a0(z19);
                                    ChatSettingFragment.this.km();
                                    ChatSettingFragment.this.f175354o0.e0(ChatSettingFragment.this.f175365t1);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 37:
                            String str2 = (String) message.obj;
                            if (ChatSettingFragment.this.f175352n0 != null && str2.equals(ChatSettingFragment.this.K)) {
                                if (message.arg1 == 1) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (z17 != ChatSettingFragment.this.f175352n0.W()) {
                                    ChatSettingFragment.this.f175352n0.e0(null);
                                    com.tencent.mobileqq.activity.newsetting.custom.config.b bVar2 = ChatSettingFragment.this.f175352n0;
                                    if (message.arg1 != 1) {
                                        z26 = false;
                                    }
                                    bVar2.a0(z26);
                                    ChatSettingFragment.this.hm();
                                    com.tencent.mobileqq.activity.newsetting.custom.config.b bVar3 = ChatSettingFragment.this.f175354o0;
                                    if (ChatSettingFragment.this.f175352n0.W() || ChatSettingFragment.this.f175348l0.W()) {
                                        i16 = 8;
                                    }
                                    bVar3.h0(i16);
                                    ChatSettingFragment.this.f175352n0.e0(ChatSettingFragment.this.f175363s1);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                ChatSettingFragment.this.finish();
                return;
            }
            ChatSettingFragment.this.Ej((String) message.obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class k extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetComment(boolean z16, String str, String str2, byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, Byte.valueOf(b16));
                return;
            }
            if (z16) {
                if (ChatSettingFragment.this.J == 0 && ChatSettingFragment.this.K != null && ChatSettingFragment.this.K.equals(str) && str2 != null && !ChatSettingFragment.this.Q0.equals(str2)) {
                    if (ChatSettingFragment.this.H != null && ChatSettingFragment.this.H.isShowing() && !ChatSettingFragment.this.getQBaseActivity().isFinishing()) {
                        ChatSettingFragment.this.notifyUser(R.string.bwa, 2);
                        ChatSettingFragment.this.H.dismiss();
                    }
                    ChatSettingFragment.this.Q0 = str2;
                    ChatSettingFragment.this.gm(str2);
                    ChatSettingFragment.this.M = str2;
                    return;
                }
                return;
            }
            if (ChatSettingFragment.this.J == 0) {
                if (ChatSettingFragment.this.H != null && ChatSettingFragment.this.H.isShowing() && !ChatSettingFragment.this.getQBaseActivity().isFinishing()) {
                    ChatSettingFragment.this.H.dismiss();
                }
                ChatSettingFragment chatSettingFragment = ChatSettingFragment.this;
                chatSettingFragment.gm(chatSettingFragment.Q0);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetHiddenChatSwitch(boolean z16, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), objArr);
                return;
            }
            if (objArr != null && objArr.length >= 2) {
                String[] strArr = (String[]) objArr[0];
                boolean[] zArr = (boolean[]) objArr[1];
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "res:", Boolean.valueOf(z16), " len1:", Integer.valueOf(strArr.length), " len2:", Integer.valueOf(zArr.length));
                }
                if (z16) {
                    for (int i3 = 0; i3 < strArr.length; i3++) {
                        String str = strArr[i3];
                        boolean z17 = zArr[i3];
                        if (str.equals(ChatSettingFragment.this.K)) {
                            ChatSettingFragment.this.f175352n0.e0(null);
                            ChatSettingFragment.this.f175352n0.a0(z17);
                            ChatSettingFragment.this.km();
                            ChatSettingFragment.this.f175352n0.e0(ChatSettingFragment.this.f175363s1);
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "uin:", str, " switch:", Boolean.valueOf(z17));
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            QLog.e(LogTag.TAG_HIDDEN_CHAT, 1, "data not right");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), obj);
                return;
            }
            QLog.i("ChatSettingFragment", 1, "onUpdateDelFriend isSuccess: " + z16 + " object: " + obj);
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
                return;
            }
            if (z16 && TextUtils.equals(str, ChatSettingFragment.this.K)) {
                ChatSettingFragment chatSettingFragment = ChatSettingFragment.this;
                chatSettingFragment.Q0 = chatSettingFragment.Qj(chatSettingFragment.K);
                if (ChatSettingFragment.this.Q0 == null) {
                    ChatSettingFragment.this.Q0 = "";
                }
                ChatSettingFragment chatSettingFragment2 = ChatSettingFragment.this;
                chatSettingFragment2.gm(chatSettingFragment2.Q0);
                ChatSettingFragment.this.Hm();
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendShieldFlag(long j3, boolean z16, boolean z17, boolean z18, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ChatSettingFragment.this.Kj();
                ChatSettingFragment.this.Sl();
                if (z17) {
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    ChatSettingFragment.this.Kl(str, 1);
                    return;
                }
                if (ChatSettingFragment.this.K.endsWith(j3 + "")) {
                    if (z16) {
                        ChatSettingFragment.this.notifyUser(R.string.hjw, 1);
                        return;
                    } else {
                        ChatSettingFragment.this.notifyUser(R.string.hju, 1);
                        return;
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateHotFriendLevel(boolean z16, ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), arrayList);
                return;
            }
            super.onUpdateHotFriendLevel(z16, arrayList);
            if (ChatSettingFragment.this.J == 0 && z16 && arrayList != null && arrayList.contains(ChatSettingFragment.this.K)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ChatSettingFragment", 2, "onUpdateHotFriendLevel");
                }
                ChatSettingFragment.this.Hm();
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateSignature(boolean z16, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), strArr);
                return;
            }
            if (z16 && strArr != null) {
                ChatSettingFragment chatSettingFragment = ChatSettingFragment.this;
                if (chatSettingFragment.L1 != null && chatSettingFragment.J == 0 && !TextUtils.isEmpty(ChatSettingFragment.this.K)) {
                    for (String str : strArr) {
                        if (ChatSettingFragment.this.K.equals(str)) {
                            ChatSettingFragment chatSettingFragment2 = ChatSettingFragment.this;
                            chatSettingFragment2.im(chatSettingFragment2.Rj(chatSettingFragment2.K), ChatSettingFragment.this.L1);
                            return;
                        }
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateStrangerRichStatus(boolean z16, String[] strArr, Map<String, RichStatus> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), strArr, map);
                return;
            }
            ChatSettingFragment chatSettingFragment = ChatSettingFragment.this;
            if (chatSettingFragment.L1 != null && !TextUtils.isEmpty(chatSettingFragment.K) && map != null && map.containsKey(ChatSettingFragment.this.K)) {
                ChatSettingFragment chatSettingFragment2 = ChatSettingFragment.this;
                chatSettingFragment2.im(map.get(chatSettingFragment2.K), ChatSettingFragment.this.L1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class l extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean z16, Object obj) {
            Card card;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (obj instanceof Card) {
                card = (Card) obj;
            } else {
                card = null;
            }
            if (z16 && card != null) {
                if (ChatSettingFragment.this.J == 0 && ChatSettingFragment.this.K.equals(card.uin)) {
                    String F = com.tencent.mobileqq.utils.ac.F(ChatSettingFragment.this.E, ChatSettingFragment.this.K);
                    if (!TextUtils.isEmpty(F) && !F.equals(ChatSettingFragment.this.M)) {
                        ChatSettingFragment.this.M = F;
                    }
                }
                ChatSettingFragment chatSettingFragment = ChatSettingFragment.this;
                if (chatSettingFragment.L1 != null && !TextUtils.isEmpty(chatSettingFragment.K) && ChatSettingFragment.this.K.equals(card.uin)) {
                    ChatSettingFragment chatSettingFragment2 = ChatSettingFragment.this;
                    chatSettingFragment2.im(chatSettingFragment2.Rj(chatSettingFragment2.K), ChatSettingFragment.this.L1);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class m extends com.tencent.mobileqq.app.cy {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.cy
        protected void a(boolean z16, List<Long> list) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list);
                return;
            }
            if (ChatSettingFragment.this.f175331c1) {
                ChatSettingFragment.this.f175331c1 = false;
                ChatSettingFragment.this.Kj();
                Context context = ChatSettingFragment.this.getContext();
                ChatSettingFragment chatSettingFragment = ChatSettingFragment.this;
                if (z16) {
                    i3 = R.string.hk8;
                } else {
                    i3 = R.string.hjw;
                }
                QQToast.makeText(context, 2, chatSettingFragment.getString(i3), 0).show();
                if (QLog.isColorLevel()) {
                    QLog.d("ChatSettingActivity.nearby", 2, "onAddShieldList, isSuccess=" + z16 + ", mShieldByThis=" + ChatSettingFragment.this.f175331c1 + ", mShieldUin=" + ChatSettingFragment.this.f175329b1 + ", mIsShield=" + ChatSettingFragment.this.Y0);
                }
                if (z16) {
                    ShieldMsgManger shieldMsgManger = (ShieldMsgManger) ChatSettingFragment.this.E.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
                    if (shieldMsgManger != null && !TextUtils.isEmpty(ChatSettingFragment.this.f175329b1)) {
                        ChatSettingFragment chatSettingFragment2 = ChatSettingFragment.this;
                        chatSettingFragment2.Y0 = shieldMsgManger.h(chatSettingFragment2.f175329b1);
                    }
                    ChatSettingFragment.this.Tl();
                    if (ChatSettingFragment.this.Y0) {
                        ChatSettingFragment chatSettingFragment3 = ChatSettingFragment.this;
                        chatSettingFragment3.W = false;
                        chatSettingFragment3.Rl();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ChatSettingActivity.nearby", 2, "onAddShieldList, mIsShield=" + ChatSettingFragment.this.Y0 + ", mIsFollowed=" + ChatSettingFragment.this.W);
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ChatSettingActivity.nearby", 2, "onAddShieldList, mShieldByThis=" + ChatSettingFragment.this.f175331c1);
            }
        }

        @Override // com.tencent.mobileqq.app.cy
        protected void c(boolean z16, List<Long> list) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), list);
                return;
            }
            if (ChatSettingFragment.this.f175331c1) {
                ChatSettingFragment.this.f175331c1 = false;
                ChatSettingFragment.this.Kj();
                Context context = ChatSettingFragment.this.getContext();
                ChatSettingFragment chatSettingFragment = ChatSettingFragment.this;
                if (z16) {
                    i3 = R.string.hjv;
                } else {
                    i3 = R.string.hju;
                }
                QQToast.makeText(context, 2, chatSettingFragment.getString(i3), 0).show();
                if (QLog.isColorLevel()) {
                    QLog.d("ChatSettingActivity.nearby", 2, "onDeleteShieldList, isSuccess=" + z16);
                }
                if (!z16) {
                    ChatSettingFragment.this.notifyUser(R.string.hju, 1);
                    return;
                }
                ShieldMsgManger shieldMsgManger = (ShieldMsgManger) ChatSettingFragment.this.E.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
                if (shieldMsgManger != null && !TextUtils.isEmpty(ChatSettingFragment.this.f175329b1)) {
                    ChatSettingFragment chatSettingFragment2 = ChatSettingFragment.this;
                    chatSettingFragment2.Y0 = shieldMsgManger.h(chatSettingFragment2.f175329b1);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ChatSettingActivity.nearby", 2, "onDeleteShieldList, mIsShield=" + ChatSettingFragment.this.Y0);
                }
                ChatSettingFragment.this.Tl();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class n extends com.tencent.mobileqq.app.bs {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onInsertIntoBlackList(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (ChatSettingFragment.this.f175331c1) {
                ChatSettingFragment.this.f175331c1 = false;
                ChatSettingFragment.this.Kj();
                if (QLog.isColorLevel()) {
                    QLog.d("ChatSettingActivity.nearby", 2, "onInsertIntoBlackList, isSuccess=" + z16);
                }
                if (!z16) {
                    ChatSettingFragment.this.notifyUser(R.string.hjw, 1);
                    return;
                }
                if (str != null && str.equals(ChatSettingFragment.this.f175329b1)) {
                    ChatSettingFragment.this.Y0 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ChatSettingActivity.nearby", 2, "onInsertIntoBlackList, mIsShield=" + ChatSettingFragment.this.Y0);
                }
                ChatSettingFragment.this.Tl();
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onRemoveFromBlackList(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
                return;
            }
            if (ChatSettingFragment.this.f175331c1) {
                ChatSettingFragment.this.f175331c1 = false;
                if (QLog.isColorLevel()) {
                    QLog.d("ChatSettingActivity.nearby", 2, "onRemoveFromBlackList, isSuccess=" + z16);
                }
                ChatSettingFragment.this.Kj();
                if (!z16) {
                    ChatSettingFragment.this.notifyUser(R.string.hjw, 1);
                    return;
                }
                if (str != null && str.equals(ChatSettingFragment.this.f175329b1)) {
                    ChatSettingFragment.this.Y0 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ChatSettingActivity.nearby", 2, "onRemoveFromBlackList, mIsShield=" + ChatSettingFragment.this.Y0);
                }
                ChatSettingFragment.this.Tl();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class o extends ExpandObserver {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void s(boolean z16, String str, int i3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Boolean.valueOf(z17));
            } else if (TextUtils.equals(str, ChatSettingFragment.this.K)) {
                ((IAioColdPalaceHelper) QRoute.api(IAioColdPalaceHelper.class)).doOnReqThrowToColdPalace(ChatSettingFragment.this.E, ChatSettingFragment.this.F, z16, i3, str, z17, ChatSettingFragment.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class p implements com.tencent.mobileqq.richstatus.e {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.e
        public void onGetIcon(int i3, int i16, Bitmap bitmap) {
            RichStatus richStatus;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
                return;
            }
            ChatSettingFragment chatSettingFragment = ChatSettingFragment.this;
            TextView textView = chatSettingFragment.L1;
            if (textView != null && (richStatus = chatSettingFragment.M1) != null && richStatus.actionId == i3 && bitmap != null && i16 == 200) {
                chatSettingFragment.im(richStatus, textView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class q implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ChatSettingFragment.this.finish();
            if (ChatSettingFragment.this.P1 != null && ChatSettingFragment.this.P1.isShowing()) {
                ChatSettingFragment.this.P1.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class r implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (ChatSettingFragment.this.P1 != null && ChatSettingFragment.this.P1.isShowing()) {
                ChatSettingFragment.this.P1.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class s implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f175418d;

        s(View view) {
            this.f175418d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this, (Object) view);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ChatSettingFragment.this.Jj(this.f175418d);
                ReportController.o(ChatSettingFragment.this.E, "CliOper", "", "", "0X80040F1", "0X80040F1", 0, 0, "", "", "", "");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class t implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class u implements Function1<String, Unit> {
        static IPatchRedirector $redirector_;

        u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).jumpJuBaoReport(ChatSettingFragment.this.getContext(), ChatSettingFragment.this.K, ChatSettingFragment.this.Q, ChatSettingFragment.this.P, str);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class v extends com.tencent.mobileqq.activity.recent.msgbox.a {
        static IPatchRedirector $redirector_;

        v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.msgbox.a, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            super.onUpdate(i3, z16, obj);
            if (i3 == 0) {
                QQToast.makeText(BaseApplication.getContext(), R.string.f2038851e, 0).show();
                if (ChatSettingFragment.this.f175370w0 != null && ChatSettingFragment.this.f175370w0.U() != null) {
                    ChatSettingFragment.this.f175370w0.U().g(8);
                }
                if (ChatSettingFragment.this.J0 != null) {
                    ChatSettingFragment.this.J0.g(8);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class w extends com.tencent.mobileqq.activity.recent.msgbox.h {
        static IPatchRedirector $redirector_;

        w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.msgbox.h, mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (i3 == 1) {
                if (ChatSettingFragment.this.zk()) {
                    if (ChatSettingFragment.this.f175370w0 != null && ChatSettingFragment.this.f175370w0.U() != null) {
                        ChatSettingFragment.this.f175370w0.U().g(0);
                    }
                    if (ChatSettingFragment.this.J0 != null) {
                        ChatSettingFragment.this.J0.g(0);
                        return;
                    }
                    return;
                }
                if (ChatSettingFragment.this.f175370w0 != null && ChatSettingFragment.this.f175370w0.U() != null) {
                    ChatSettingFragment.this.f175370w0.U().g(8);
                }
                if (ChatSettingFragment.this.J0 != null) {
                    ChatSettingFragment.this.J0.g(8);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66826);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            Y1 = AppSetting.f99565y;
        }
    }

    public ChatSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.G = false;
        this.W = false;
        this.f175328b0 = "";
        this.f175332d0 = false;
        this.f175334e0 = false;
        this.f175340h0 = new HashMap<>();
        this.f175376z0 = false;
        this.S0 = 0;
        this.T0 = false;
        this.X0 = false;
        this.Y0 = false;
        this.Z0 = false;
        this.f175327a1 = true;
        this.f175329b1 = "";
        this.f175331c1 = false;
        this.f175333d1 = "";
        this.f175335e1 = "";
        this.f175341h1 = false;
        this.f175343i1 = false;
        this.f175347k1 = false;
        this.f175349l1 = false;
        this.f175355o1 = true;
        this.f175359q1 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("chat_setting_hide_extra_settings_for_self_9095", true);
        this.f175361r1 = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ChatSettingFragment.this.il(compoundButton, z16);
            }
        };
        this.f175363s1 = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.z
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ChatSettingFragment.this.jl(compoundButton, z16);
            }
        };
        this.f175365t1 = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.ak
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ChatSettingFragment.this.kl(compoundButton, z16);
            }
        };
        this.f175367u1 = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.av
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ChatSettingFragment.this.ll(compoundButton, z16);
            }
        };
        this.f175369v1 = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.bg
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ChatSettingFragment.this.ml(compoundButton, z16);
            }
        };
        this.f175371w1 = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.bh
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ChatSettingFragment.this.nl(compoundButton, z16);
            }
        };
        this.f175373x1 = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.bi
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ChatSettingFragment.this.ol(compoundButton, z16);
            }
        };
        this.f175375y1 = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.bj
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ChatSettingFragment.this.pl(compoundButton, z16);
            }
        };
        this.f175377z1 = new com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.k() { // from class: com.tencent.mobileqq.activity.bk
            @Override // com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.k
            public final void a(View view) {
                ChatSettingFragment.this.ql(view);
            }
        };
        this.A1 = new g();
        this.B1 = true;
        this.C1 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("chat_setting_special_care_hidden_switch_9150_121563346", false);
        this.D1 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("chat_setting_delete_friend_hidden_switch_9150_121563346", false);
        this.E1 = new o();
        this.F1 = Long.MIN_VALUE;
        this.G1 = new IKernelRobotListener() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
            public /* synthetic */ void onRobotAIOEventChanged(RobotAIOEvent robotAIOEvent) {
                com.tencent.qqnt.kernel.nativeinterface.bk.a(this, robotAIOEvent);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
            public /* synthetic */ void onRobotCoreInfoChanged(RobotCoreInfo robotCoreInfo) {
                com.tencent.qqnt.kernel.nativeinterface.bk.b(this, robotCoreInfo);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
            public /* synthetic */ void onRobotFeatureChanged(GroupRobotProfile groupRobotProfile) {
                com.tencent.qqnt.kernel.nativeinterface.bk.c(this, groupRobotProfile);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
            public /* synthetic */ void onRobotFriendListChanged() {
                com.tencent.qqnt.kernel.nativeinterface.bk.d(this);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
            public /* synthetic */ void onRobotListChanged() {
                com.tencent.qqnt.kernel.nativeinterface.bk.e(this);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
            public void onRobotProfileChanged(GroupRobotProfile groupRobotProfile) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) groupRobotProfile);
                } else {
                    RFWThreadManager.getInstance().runOnUiThread(new Runnable(groupRobotProfile) { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.4.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ GroupRobotProfile f175397d;

                        {
                            this.f175397d = groupRobotProfile;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) groupRobotProfile);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ChatSettingFragment.this.sl(this.f175397d);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
            public /* synthetic */ void onRobotTabListChanged(String str) {
                com.tencent.qqnt.kernel.nativeinterface.bk.g(this, str);
            }
        };
        this.H1 = new v();
        this.I1 = new w();
        this.J1 = new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, boolean z16, Object obj) {
                int i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                int i17 = 2;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                    return;
                }
                if (i3 == 8) {
                    QLog.i("ChatSettingFragment", 1, "NOTIFY_TYPE_SET_USER_SHIELD is success " + z16 + " mIsShield is " + obj);
                    if (z16) {
                        ChatSettingFragment.this.Y0 = ((Boolean) obj).booleanValue();
                    }
                    if (!z16) {
                        i17 = 1;
                    }
                    if (z16) {
                        if (ChatSettingFragment.this.Y0) {
                            i16 = R.string.hk8;
                        } else {
                            i16 = R.string.hjv;
                        }
                    } else if (ChatSettingFragment.this.Y0) {
                        i16 = R.string.hju;
                    } else {
                        i16 = R.string.hjw;
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(i16, i17) { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.10.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f175379d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f175380e;

                        {
                            this.f175379d = i16;
                            this.f175380e = i17;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass10.this, Integer.valueOf(i16), Integer.valueOf(i17));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ChatSettingFragment.this.notifyUser(this.f175379d, this.f175380e);
                                if (ChatSettingFragment.this.C0 != null) {
                                    ChatSettingFragment.this.C0.a0(ChatSettingFragment.this.Y0);
                                    return;
                                }
                                return;
                            }
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    });
                    return;
                }
                if (i3 == 7) {
                    QLog.i("ChatSettingFragment", 1, "NOTIFY_TYPE_GET_USER_SHIELD is success " + z16 + " mIsShield is " + obj);
                    if (z16) {
                        ChatSettingFragment.this.Y0 = ((Boolean) obj).booleanValue();
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.10.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass10.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else if (ChatSettingFragment.this.C0 != null) {
                                    ChatSettingFragment.this.C0.a0(ChatSettingFragment.this.Y0);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i3 == 12) {
                    QLog.i("ChatSettingFragment", 1, "NOTIFY_TYPE_GET_IS_FRIEND is success " + z16 + " isFriend is " + obj);
                    if (z16) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(((Boolean) obj).booleanValue()) { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.10.3
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ boolean f175383d;

                            {
                                this.f175383d = r6;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass10.this, Boolean.valueOf(r6));
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                int i18;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (ChatSettingFragment.this.H0 != null) {
                                    com.tencent.mobileqq.activity.newsetting.custom.item.a aVar = ChatSettingFragment.this.H0;
                                    if (this.f175383d) {
                                        i18 = 8;
                                    } else {
                                        i18 = 0;
                                    }
                                    aVar.g(i18);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i3 == 13) {
                    if (!z16) {
                        ChatSettingFragment.this.notifyUser(R.string.c5o, 1);
                        return;
                    }
                    Object[] objArr = (Object[]) obj;
                    boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
                    String str = (String) objArr[1];
                    if (!booleanValue) {
                        ChatSettingFragment.this.Kl(str, 1);
                    } else {
                        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).launchAddFriend(ChatSettingFragment.this.getContext(), Long.parseLong(ChatSettingFragment.this.K), ChatSettingFragment.this.f175328b0);
                    }
                }
            }
        };
        this.K1 = 0L;
        this.N1 = new e();
        this.O1 = new f();
        this.Q1 = new j();
        this.R1 = new k();
        this.S1 = new l();
        this.T1 = new m();
        this.U1 = new n();
        this.V1 = new com.tencent.mobileqq.zplan.api.b() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.28
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
                }
            }

            @Override // com.tencent.mobileqq.zplan.api.b
            public void onResult(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                } else if (((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).hasAvatarFeature()) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.28.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass28.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else if (ChatSettingFragment.this.f175366u0 != null) {
                                ChatSettingFragment.this.f175366u0.a0(((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleAvatarSwitchState(ChatSettingFragment.this.K));
                                ChatSettingFragment.this.f175366u0.h0(0);
                            }
                        }
                    });
                }
            }
        };
        this.W1 = new Runnable() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.33
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (ChatSettingFragment.this.f175374y0 != null) {
                    QLog.i("ChatSettingFragment", 1, "mFriendTimesBubble dismiss on 3000ms.");
                    ChatSettingFragment.this.f175374y0.setVisibility(8);
                    ChatSettingFragment.this.f175374y0 = null;
                }
            }
        };
        this.X1 = new p();
    }

    private void Aj() {
        this.F.addObserver(this.R1);
        this.F.addObserver(this.U1);
        this.F.addObserver(this.T1);
        this.F.addObserver(this.S1);
        this.F.addObserver(this.N1);
        this.F.addObserver(this.O1);
        this.F.addObserver(this.E1);
        this.F.addObserver(this.H1);
        this.F.addObserver(this.J1);
        this.E.registObserver(this.I1);
        this.E.setHandler(ChatSettingFragment.class, this.Q1);
        StatusManager statusManager = (StatusManager) this.E.getManager(QQManagerFactory.STATUS_MANAGER);
        if (statusManager != null) {
            statusManager.C(this.X1);
        }
    }

    private boolean Ak() {
        if (this.E != null && !TextUtils.isEmpty(this.K)) {
            return ((ITroopRobotService) this.E.getRuntimeService(ITroopRobotService.class, "")).isRobotUin(this.K);
        }
        return false;
    }

    private void Am(com.tencent.mobileqq.activity.newsetting.custom.config.b bVar, boolean z16) {
        if (z16) {
            bVar.h0(0);
        } else {
            bVar.h0(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj(boolean z16) {
        this.f175353n1.dismiss();
        ReportController.o(this.E, "dc00898", "", "", "0X800C00C", "0X800C00C", 0, 0, "", "", "", "");
    }

    private boolean Bk(View view) {
        d.a aVar = this.F0;
        if (aVar == null) {
            return false;
        }
        if (!Fk(aVar.U(), view) && !Fk(this.F0.S(), view)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Bl(TroopMemberNickInfo troopMemberNickInfo) {
        Im(Wj(troopMemberNickInfo));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm(String str, boolean z16) {
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            ((FriendListHandler) this.E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend("ChatSettingFragment", str, (byte) 2, 1);
            Il(str);
        } else {
            notifyUser(R.string.ajl, 1);
        }
        this.f175353n1.dismiss();
    }

    private boolean Cj(String str) {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ChatSettingFragment");
    }

    private boolean Ck(int i3) {
        if (i3 == 1009 || i3 == 1036 || i3 == 10002 || i3 == 10004 || i3 == 10010 || i3 == 10019 || i3 == 10007 || i3 == 10008) {
            return true;
        }
        switch (i3) {
            case 1000:
            case 1001:
            case 1002:
            case 1003:
            case 1004:
            case 1005:
            case 1006:
                return true;
            default:
                switch (i3) {
                    case 1022:
                    case 1023:
                    case 1024:
                    case 1025:
                        return true;
                    default:
                        switch (i3) {
                            case 1044:
                            case 1045:
                            case 1046:
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Cl(TempChatInfo tempChatInfo) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(tempChatInfo.groupCode, this.K, this.F, "ChatSettingFragment", new Function1() { // from class: com.tencent.mobileqq.activity.be
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Bl;
                Bl = ChatSettingFragment.this.Bl((TroopMemberNickInfo) obj);
                return Bl;
            }
        });
    }

    private void Cm(final String str) {
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            com.tencent.qqnt.kernel.api.ac h16 = com.tencent.qqnt.msg.f.h();
            if (h16 != null) {
                RobotRemoveFriendRequest robotRemoveFriendRequest = new RobotRemoveFriendRequest();
                try {
                    robotRemoveFriendRequest.robotUin = Long.parseLong(str);
                } catch (NumberFormatException unused) {
                    QLog.e("ChatSettingFragment", 1, "sureDelRobot parse uin=" + str);
                }
                h16.removeFriend(robotRemoveFriendRequest, new IRemoveFriendCallback() { // from class: com.tencent.mobileqq.activity.bf
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IRemoveFriendCallback
                    public final void onResult(int i3, String str2) {
                        ChatSettingFragment.this.yl(str, i3, str2);
                    }
                });
            }
        } else {
            notifyUser(R.string.ajl, 1);
        }
        this.f175353n1.dismiss();
    }

    private void Dj() {
        boolean z16;
        ChatSettingFragment chatSettingFragment;
        int i3 = 0;
        if (((com.tencent.mobileqq.qqexpand.manager.e) this.E.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).J() > 0 && ((IColdPalaceUtils) QRoute.api(IColdPalaceUtils.class)).getSvrShowGrayTipEntry(this.E)) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = this.E0;
        if (!z16) {
            i3 = 8;
        }
        bVar.h0(i3);
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar2 = this.E0;
        if (z16) {
            chatSettingFragment = this;
        } else {
            chatSettingFragment = null;
        }
        bVar2.x(chatSettingFragment);
    }

    private boolean Dk(com.tencent.mobileqq.activity.newsetting.custom.config.a aVar, View view) {
        if (aVar != null && view != null) {
            return aVar.L(view);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Dl(int i3, String str, final TempChatInfo tempChatInfo) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.bb
            @Override // java.lang.Runnable
            public final void run() {
                ChatSettingFragment.this.Cl(tempChatInfo);
            }
        });
    }

    private void Dm(GroupRobotProfile groupRobotProfile) {
        ArrayList<TtsInfo> arrayList;
        if (this.f175358q0 == null) {
            return;
        }
        RobotTTSList robotTTSList = groupRobotProfile.ttsList;
        if (robotTTSList != null && (arrayList = robotTTSList.ttsList) != null && !arrayList.isEmpty()) {
            this.f175358q0.f0(((IRobotTtsApi) QRoute.api(IRobotTtsApi.class)).calculateCurrentTtsName(this.K, robotTTSList));
            this.f175358q0.h0(0);
        } else {
            this.f175358q0.h0(8);
            QLog.i("ChatSettingFragment", 1, "updateChatTimbre empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ej(String str) {
        long j3;
        long j16;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("del_record_his_9160", true)) {
            return;
        }
        List<MessageRecord> Q = this.E.getMessageFacade().Q(this.K, this.J);
        if (Q != null && !Q.isEmpty()) {
            if (Q.get(Q.size() - 1).isSendFromLocal()) {
                j3 = Q.get(Q.size() - 1).time + 2;
            } else {
                j3 = Q.get(Q.size() - 1).time;
            }
        } else {
            j3 = 0;
        }
        this.E.getMessageFacade().q(this.K, this.J);
        this.E.getMessageFacade().m0(this.K, this.J);
        this.E.getFileManagerDataCenter().Y(this.K, this.J);
        if (str != null) {
            try {
                j16 = Long.parseLong(str);
            } catch (Exception e16) {
                e16.printStackTrace();
                j16 = 0;
            }
            long max = Math.max(j16, j3);
            if (max > 0) {
                this.E.getMsgCache().A(this.K, this.J, max);
            }
        }
        MqqHandler handler = this.E.getHandler(Conversation.class);
        Message obtainMessage = handler.obtainMessage(1017);
        obtainMessage.obj = this.K;
        obtainMessage.arg1 = this.J;
        handler.sendMessage(obtainMessage);
    }

    private boolean Ek(com.tencent.mobileqq.activity.newsetting.custom.config.b bVar, View view) {
        if (bVar != null && view != null) {
            return bVar.X(view);
        }
        return false;
    }

    private void El(QQProAvatarView qQProAvatarView, int i3, String str) {
        boolean z16;
        long uin = getUin();
        if (uin == 0) {
            z16 = ((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar("" + uin);
        } else {
            z16 = false;
        }
        qQProAvatarView.x(i3, str, new e.a().e(!z16).a());
    }

    private void Em(GroupRobotProfile groupRobotProfile) {
        if (this.f175344j0 == null) {
            return;
        }
        boolean z16 = this.D.getBoolean("KEY_IS_FROM_SCALE_CHAT", false);
        RobotBaseInfo robotBaseInfo = groupRobotProfile.robotData;
        if (robotBaseInfo != null && robotBaseInfo.allowedAddGroup && !QidianManager.P(this.E, this.K) && !z16) {
            QLog.i("ChatSettingFragment", 1, "updateCreateDiscussion VISIBLE");
            this.f175344j0.R(0);
        } else {
            QLog.i("ChatSettingFragment", 1, "updateCreateDiscussion GONE");
            this.f175344j0.R(8);
        }
    }

    private void Fj(String str) {
        this.f175353n1 = DialogUtil.createCustomDialog(getActivity(), 0, Nj(), "", R.string.cancel, R.string.f171151ok, new h(str), new i());
    }

    private boolean Fk(com.tencent.mobileqq.activity.newsetting.custom.item.d dVar, View view) {
        if (dVar != null && view != null) {
            return dVar.b(view);
        }
        return false;
    }

    private void Fl() {
        try {
            this.B1 = ((IFeatureRuntimeService) this.E.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("del_chat_histroy_new_ui_8898");
            QLog.i("ChatSettingFragment", 1, "loadSwitch " + this.B1);
        } catch (Exception e16) {
            QLog.e("ChatSettingFragment", 1, "loadSwitch", e16);
        }
    }

    private static void Fm(hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> bVar) {
        if (bVar == null) {
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        eVar.d(-1);
        bVar.onQueryResult(eVar);
    }

    private void Gj() {
        if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            if (System.currentTimeMillis() - this.K1 < 500) {
                return;
            } else {
                this.K1 = System.currentTimeMillis();
            }
        }
        QLog.i("ChatSettingFragment", 1, "[createDiscussion] start");
        Intent intent = new Intent();
        intent.putExtra("param_type", 3000);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 1001);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.K);
        intent.putStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 29);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ADD_PASSED_MEMBERS_TO_RESULT_SET, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, (100 - arrayList.size()) - 1);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(getQBaseActivity(), intent, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gk(DialogInterface dialogInterface, int i3) {
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        this.f175355o1 = z16;
    }

    private String Gl() {
        if (this.L == null) {
            return null;
        }
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        aVar.d(this.L);
        return ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gm(int i3) {
        ImageView imageView = this.f175374y0;
        if (imageView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin -= i3;
        this.f175374y0.setLayoutParams(layoutParams);
    }

    private void Hj(final String str) {
        this.f175353n1 = DialogUtil.createDialogWithCheckBox(getContext(), 0, Nj(), null, getString(R.string.f175402yg), true, getString(R.string.cancel), getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.af
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatSettingFragment.this.Gk(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.ag
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatSettingFragment.this.Hk(str, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.ah
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatSettingFragment.this.Ik(dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hk(String str, DialogInterface dialogInterface, int i3) {
        Bm(str, true);
    }

    private void Hl(Class cls, String str) {
        MqqHandler handler;
        if (this.E != null && !TextUtils.isEmpty(str) && (handler = this.E.getHandler(cls)) != null) {
            handler.removeMessages(16711681);
            handler.sendMessage(handler.obtainMessage(16711681, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hm() {
        com.tencent.mobileqq.activity.newsetting.custom.item.d<MutualMarkIconsView> V;
        f.b bVar = this.f175342i0;
        if (bVar == null) {
            V = null;
        } else {
            V = bVar.V();
        }
        if (V == null) {
            return;
        }
        if (this.J == 0) {
            V.c(new g71.a() { // from class: com.tencent.mobileqq.activity.ax
                @Override // g71.a
                public final void a(Object obj) {
                    ChatSettingFragment.this.zl((MutualMarkIconsView) obj);
                }
            });
        } else {
            V.c(new g71.a() { // from class: com.tencent.mobileqq.activity.ay
                @Override // g71.a
                public final void a(Object obj) {
                    ((MutualMarkIconsView) obj).setVisibility(8);
                }
            });
        }
    }

    private void Ij(final String str) {
        this.f175353n1 = DialogUtil.createCustomDialog(getContext(), 0, "", getString(R.string.f222986f0), R.string.cancel, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.al
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatSettingFragment.this.Jk(str, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.am
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatSettingFragment.this.Kk(dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ik(DialogInterface dialogInterface, int i3) {
        Bj(true);
    }

    private void Il(String str) {
        Hl(ChatActivity.class, str);
        Hl(ChatSettingFragment.class, str);
        Hl(((IAIOGetHandlerClzApi) QRoute.api(IAIOGetHandlerClzApi.class)).getC2CDelFriendHelperClz(), str);
        ReportController.o(this.E, "dc00898", "", "", "0X800C00B", "0X800C00B", 1, 0, "", "", "", "");
    }

    private void Im(String str) {
        d.a aVar = this.F0;
        if (aVar != null && aVar.S() != null) {
            this.F0.S().j(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jj(View view) {
        int l3;
        com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) this.E.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.d("ChatSettingFragment", 1, "deleteStrangerChatHistory but service is null");
            return;
        }
        int i3 = this.J;
        if (i3 == 1003) {
            l3 = 1;
        } else {
            l3 = com.tencent.nt.adapter.session.c.l(i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatSettingFragment", 1, String.format("deleteStrangerChatHistory chatType: %s, uid: %s", Integer.valueOf(l3), this.L));
        }
        if (!com.tencent.nt.adapter.session.g.a(l3) && l3 != 1 && l3 != 105) {
            QLog.i("ChatSettingFragment", 1, "deleteStrangerChatHistory is return! chatType is invalid!");
        } else {
            msgService.clearMsgRecords(new Contact(l3, this.L, ""), new IClearMsgRecordsCallback(view) { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.17
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ View f175385a;

                {
                    this.f175385a = view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this, (Object) view);
                    }
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback
                public void onResult(int i16, String str, long j3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i16), str, Long.valueOf(j3));
                    } else if (i16 != 0) {
                        QLog.d("ChatSettingFragment", 1, "deleteStrangerChatHistory fail, result: ", Integer.valueOf(i16), ", errMsg: ", str);
                    } else {
                        this.f175385a.post(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.17.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass17.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    ChatSettingFragment chatSettingFragment = ChatSettingFragment.this;
                                    chatSettingFragment.rm(2, chatSettingFragment.getString(R.string.f170326mf));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jk(String str, DialogInterface dialogInterface, int i3) {
        Cm(str);
    }

    private void Jl() {
        MqqHandler handler;
        QQAppInterface qQAppInterface = this.E;
        if (qQAppInterface != null && (handler = qQAppInterface.getHandler(Conversation.class)) != null) {
            handler.sendEmptyMessage(1009);
        }
    }

    private void Jm() {
        String str;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("chat_setting_qidian_nick_fix_switch", true)) {
            String str2 = this.M;
            if (str2 != null && !str2.equals(this.K)) {
                QLog.d("ChatSettingFragment", 4, "updateQidianNickName curName: " + str2);
                Im(str2);
                return;
            }
            QidianExternalInfo q16 = ((QidianManager) this.E.getManager(QQManagerFactory.QIDIAN_MANAGER)).q(this.K);
            if (q16 != null) {
                str = q16.nickname;
            } else {
                str = null;
            }
            QLog.d("ChatSettingFragment", 4, "updateQidianNickName qidian extInfo name: " + str);
            if (!TextUtils.isEmpty(str)) {
                Im(str);
                return;
            }
        }
        Im(com.tencent.mobileqq.utils.ac.H(this.E, this.K));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kj() {
        QQProgressDialog qQProgressDialog = this.f175337f1;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.f175337f1.cancel();
                this.f175337f1 = null;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kk(DialogInterface dialogInterface, int i3) {
        Bj(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kl(String str, int i3) {
        QQToast.makeText(BaseApplication.getContext(), i3, str, 0).show();
    }

    private void Km(GroupRobotProfile groupRobotProfile) {
        String str;
        if (this.f175360r0 == null) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[updateResetChat]: canResetHistory ");
            if (groupRobotProfile != null) {
                str = String.valueOf(groupRobotProfile.canResetHistory);
            } else {
                str = "null";
            }
            sb5.append(str);
            QLog.i("ChatSettingFragment", 4, sb5.toString());
        }
        if (groupRobotProfile != null && groupRobotProfile.canResetHistory) {
            this.f175360r0.h0(0);
        } else {
            this.f175360r0.h0(8);
        }
    }

    private void Lj() {
        Dialog dialog = this.f175339g1;
        if (dialog != null && dialog.isShowing()) {
            try {
                this.f175339g1.cancel();
                this.f175339g1 = null;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Lm, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void sl(GroupRobotProfile groupRobotProfile) {
        RobotBaseInfo robotBaseInfo;
        if (this.f175347k1) {
            return;
        }
        if (groupRobotProfile != null && (robotBaseInfo = groupRobotProfile.robotData) != null) {
            String valueOf = String.valueOf(robotBaseInfo.robotUin);
            if (!TextUtils.isEmpty(valueOf) && valueOf.equals(this.K)) {
                String name = groupRobotProfile.robotData.getName();
                if (!TextUtils.isEmpty(name)) {
                    Im(name);
                }
                Em(groupRobotProfile);
                Dm(groupRobotProfile);
                Km(groupRobotProfile);
                return;
            }
            QLog.i("ChatSettingFragment", 1, "updateRobotProfile robotUin equals false.");
            return;
        }
        QLog.e("ChatSettingFragment", 1, "updateRobotProfile robotProfile null.");
    }

    private String Mj() {
        com.tencent.qqnt.kernel.api.m b16;
        if (TextUtils.isEmpty(this.L) || (b16 = com.tencent.qqnt.msg.f.b()) == null) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.L);
        Map<String, String> buddyRemark = b16.getBuddyRemark(arrayList);
        if (buddyRemark == null) {
            return "";
        }
        return buddyRemark.get(this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Mk(int i3, String str) {
        QLog.i("ChatSettingFragment", 1, "[clearMsg][setMsgRead]: result= " + i3 + " errMsg= " + str);
    }

    private void Ml(String str, int i3) {
        if (!RFWNetworkUtils.isNetworkAvailable(getContext())) {
            QQToast.makeText(getContext(), getResources().getString(R.string.ii5), 0).show();
            return;
        }
        com.tencent.qqnt.kernel.api.ac h16 = com.tencent.qqnt.msg.f.h();
        if (h16 == null) {
            return;
        }
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getContext(), null, true);
        this.f175339g1 = showLoadingDialog;
        showLoadingDialog.show();
        ResetRobotConversationRq resetRobotConversationRq = new ResetRobotConversationRq();
        resetRobotConversationRq.uid = str;
        resetRobotConversationRq.chatType = i3;
        resetRobotConversationRq.isRestHistory = true;
        h16.resetConversation(resetRobotConversationRq, new ICommandCbCallback() { // from class: com.tencent.mobileqq.activity.ba
            @Override // com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback
            public final void onResult(int i16, String str2, CommandCbRsp commandCbRsp) {
                ChatSettingFragment.this.rl(i16, str2, commandCbRsp);
            }
        });
    }

    private void Mm() {
        String Mj = Mj();
        if (!TextUtils.isEmpty(Mj)) {
            Im(Mj);
        } else {
            Om();
        }
    }

    private String Nj() {
        int i3;
        if (this.T) {
            return getString(R.string.f222986f0);
        }
        if (com.tencent.mobileqq.mutualmark.c.l(this.E, this.K, true)) {
            i3 = R.string.zli;
        } else {
            i3 = R.string.f175412yh;
        }
        return HardCodeUtil.qqStr(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nk(DialogInterface dialogInterface, int i3) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_c2c_clearmsg_setread_9160", true)) {
            com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) this.E.getRuntimeService(IKernelService.class, "")).getMsgService();
            String str = this.L;
            if (msgService != null && str != null) {
                msgService.setMsgRead(new Contact(1, str, ""), new IOperateCallback() { // from class: com.tencent.mobileqq.activity.aj
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i16, String str2) {
                        ChatSettingFragment.Mk(i16, str2);
                    }
                });
            }
        }
        NTFriendSettingHelper.f352067a.u(new NTFriendSettingHelper.a(this.E, this.K, this.L, ((QQCustomDialog) dialogInterface).getCheckBoxState(), 0));
        ReportController.o(this.E, "dc00898", "", "", "0X800A363", "0X800A363", 0, 0, "1", "", "", "");
    }

    private void Nl(Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getStringExtra("result");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            if (!str.equals(this.Q0)) {
                FriendListHandler friendListHandler = this.C;
                if (friendListHandler != null) {
                    friendListHandler.setFriendComment(this.K, str, false);
                    this.S0 |= 1;
                    gm(str);
                    qk(getString(R.string.f170715zr));
                    this.H.show();
                    return;
                }
                notifyUser(R.string.bw_, 1);
                return;
            }
            notifyUser(R.string.bvs, 0);
            return;
        }
        notifyUser(R.string.cjl, 1);
    }

    private void Nm() {
        String str;
        if (this.f175362s0 != null) {
            String string = getString(R.string.f172976g92);
            String j06 = this.f175362s0.j0();
            if (!TextUtils.isEmpty(j06)) {
                string = string + j06;
            }
            if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getSpecialCareGlobalSwitch(this.L, "ChatSettingFragment")) {
                this.f175362s0.f0(getString(R.string.hbd));
                str = string + getString(R.string.hbd);
            } else {
                this.f175362s0.f0(getString(R.string.hbe));
                str = string + getString(R.string.hbe);
            }
            this.f175362s0.c0(str);
        }
    }

    private String Oj() {
        if (this.E != null && this.T) {
            return getString(R.string.f223036f5);
        }
        return getString(R.string.f169994bz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ok(DialogInterface dialogInterface, int i3) {
        ReportController.o(this.E, "dc00898", "", "", "0X800A363", "0X800A363", 1, 0, "1", "", "", "");
    }

    private void Ol(Intent intent) {
        if (intent == null) {
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf((int) intent.getByteExtra("result", (byte) 0))), "ChatSettingFragment");
        if (friendsSimpleInfoWithUid == null) {
            return;
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getCategoryInfoWithCategoryId(friendsSimpleInfoWithUid.f(), "ChatSettingFragment", new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b>() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.20
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                } else if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(eVar) { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.20.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ com.tencent.qqnt.ntrelation.friendsinfo.bean.e f175389d;

                        {
                            this.f175389d = eVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass20.this, (Object) eVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                ChatSettingFragment.this.em(((com.tencent.qqnt.ntrelation.friendsinfo.bean.b) this.f175389d.b().get(0)).f());
                            }
                        }
                    });
                }
            }
        });
    }

    private void Om() {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        int l3 = com.tencent.nt.adapter.session.c.l(this.J);
        if (l3 == 100) {
            com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "")).getMsgService();
            if (msgService == null) {
                return;
            }
            msgService.getTempChatInfo(100, this.L, new IGetTempChatInfoCallback() { // from class: com.tencent.mobileqq.activity.ai
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
                public final void onResult(int i3, String str, TempChatInfo tempChatInfo) {
                    ChatSettingFragment.this.Dl(i3, str, tempChatInfo);
                }
            });
            return;
        }
        if (l3 == 104) {
            Im(this.M);
            return;
        }
        if (l3 == 102) {
            Jm();
            return;
        }
        String Gl = Gl();
        if (TextUtils.isEmpty(Gl)) {
            Gl = com.tencent.mobileqq.utils.ac.H(qQAppInterface, this.K);
        }
        Im(Gl);
    }

    private String Pj() {
        if (this.E != null && this.T) {
            return getString(R.string.f222526dr);
        }
        return getString(R.string.ak8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Pk(int i3, boolean z16, String str) {
        boolean z17;
        this.f175349l1 = true;
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            ((IStrangerChatsApi) QRoute.api(IStrangerChatsApi.class)).notifyChatsListTopChanged(this.L, z16);
            return;
        }
        if (z16) {
            hk(i3, str);
        } else {
            gk(i3, str);
        }
        this.G0.e0(null);
        this.G0.a0(!z16);
        this.G0.e0(this.f175369v1);
    }

    private void Pl() {
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotProfileInfoFromLocal(this.K, "", new IGetGroupRobotProfileCallback() { // from class: com.tencent.mobileqq.activity.p
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                ChatSettingFragment.this.tl(i3, str, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Qj(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ChatSettingFragment");
        if (friendsSimpleInfoWithUid == null) {
            return null;
        }
        if (friendsSimpleInfoWithUid.r() != null) {
            str2 = friendsSimpleInfoWithUid.r();
        }
        if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(friendsSimpleInfoWithUid.p())) {
            return friendsSimpleInfoWithUid.p();
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qk(final boolean z16, final int i3, final String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.az
            @Override // java.lang.Runnable
            public final void run() {
                ChatSettingFragment.this.Pk(i3, z16, str);
            }
        });
    }

    private void Ql() {
        ((IWebProcessManagerService) QQStoryContext.a().getRuntimeService(IWebProcessManagerService.class, ProcessConstant.MULTI)).startWebProcessUnderStrategy(18, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RichStatus Rj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ChatSettingFragment");
        if (friendsSimpleInfoWithUid == null) {
            return null;
        }
        return com.tencent.mobileqq.richstatus.c.h(friendsSimpleInfoWithUid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Rk(ImageView imageView) {
        int tokenRes;
        if (QQTheme.isNowThemeSimpleNight()) {
            tokenRes = TokenResUtils.getTokenRes(R.drawable.o2b, R.drawable.juu);
        } else {
            tokenRes = TokenResUtils.getTokenRes(R.drawable.skin_icon_discussion_add, R.drawable.juu);
        }
        imageView.setImageResource(tokenRes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rl() {
        String string = getString(R.string.a2l);
        if (this.J == 10007) {
            string = getString(R.string.f1373806p);
        }
        this.H0.j(string);
        this.H0.e(string);
    }

    private void Sj(String str, hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> bVar) {
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                Fm(bVar);
                return;
            }
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ChatSettingFragment");
        if (friendsSimpleInfoWithUid == null) {
            if (bVar != null) {
                Fm(bVar);
                return;
            }
            return;
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getCategoryInfoWithCategoryId(friendsSimpleInfoWithUid.f(), "ChatSettingFragment", bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Sk(String str, TextView textView) {
        AccessibilityUtil.c(textView, str, Button.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sl() {
        if (this.f175348l0 == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.K)) {
            this.T0 = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isShieldFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.K), "ChatSettingFragment");
        }
        this.f175348l0.a0(this.T0);
        ((IProfileCardBlacklistService) this.E.getRuntimeService(IProfileCardBlacklistService.class, "all")).reportItemEvent("imp", ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, ProfileCardBlacklistReportConst.ELEM_ID_EM_BLOCK_USER_SWITCH, Vj(), new HashMap<String, String>() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.18
            static IPatchRedirector $redirector_;

            {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
                    return;
                }
                if (ChatSettingFragment.this.T0) {
                    str = "1";
                } else {
                    str = "2";
                }
                put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, str);
            }
        });
        if (AppSetting.f99565y) {
            this.f175348l0.c0(getString(R.string.a2p));
        }
        if (this.f175362s0 == null) {
            return;
        }
        km();
    }

    private List<String> Tj() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_aio_profile");
        arrayList.add("em_kl_new_chat_page_block_btn");
        arrayList.add("em_kl_new_friends_btn");
        arrayList.add("em_kl_new_report_btn");
        arrayList.add("em_kl_set_top");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Tk(TextView textView) {
        AccessibilityUtil.c(textView, getString(R.string.f169994bz), Button.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tl() {
        if (QLog.isColorLevel()) {
            QLog.d("ChatSettingActivity.nearby", 2, "refreshShieldButton, mCurType=" + this.J + ", mIsShield=" + this.Y0);
        }
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = this.C0;
        if (bVar != null) {
            bVar.a0(this.Y0);
            if (AppSetting.f99565y) {
                this.C0.c0(getString(R.string.a2p));
            }
        }
    }

    private Map<String, Object> Uj() {
        HashMap hashMap = new HashMap();
        String str = this.Y;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        hashMap.put("kl_new_to_openid", str);
        String str3 = this.X;
        if (str3 != null) {
            str2 = str3;
        }
        hashMap.put("kl_new_from_openid", str2);
        if (!TextUtils.isEmpty(this.f175328b0)) {
            hashMap.put("recom_trace", this.f175328b0);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Uk(ImageView imageView) {
        com.tencent.mobileqq.vip.api.c.a().setVipCardDrawable(imageView, this.K);
    }

    private void Ul() {
        this.F.removeObserver(this.R1);
        this.F.removeObserver(this.U1);
        this.F.removeObserver(this.T1);
        this.F.removeObserver(this.S1);
        this.F.removeObserver(this.N1);
        this.F.removeObserver(this.O1);
        this.F.removeObserver(this.E1);
        this.F.removeObserver(this.H1);
        this.F.removeObserver(this.J1);
        this.E.unRegistObserver(this.I1);
        this.E.removeHandler(ChatSettingFragment.class);
        StatusManager statusManager = (StatusManager) this.E.getManager(QQManagerFactory.STATUS_MANAGER);
        if (statusManager != null) {
            statusManager.b0(this.X1);
        } else {
            this.X1 = null;
        }
        ((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).unRegisterAIOWhiteListListener(this.V1);
        this.V1 = null;
    }

    private HashMap<String, String> Vj() {
        return new HashMap<String, String>() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.19
            static IPatchRedirector $redirector_;

            {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
                    return;
                }
                put("to_uin", ChatSettingFragment.this.K);
                if (ChatSettingFragment.this.J == 0) {
                    str = "1";
                } else {
                    str = "2";
                }
                put("is_qq_fri", str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Vk(TextView textView) {
        ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(textView, this.K, true);
    }

    private void Vl(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING);
        hashMap.put("pgid", ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING);
        hashMap.putAll(Vj());
        HashMap hashMap2 = new HashMap(hashMap);
        hashMap2.put("cur_pg", hashMap);
        hashMap2.put("dt_eid", str);
        hashMap2.put("eid", str);
        VideoReport.reportEvent("clck", hashMap2);
    }

    private String Wj(TroopMemberNickInfo troopMemberNickInfo) {
        String str;
        if (troopMemberNickInfo != null) {
            str = troopMemberNickInfo.getShowName(false, true);
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return com.tencent.mobileqq.utils.ac.H((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), this.K);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Wk(ImageView imageView) {
        com.tencent.mobileqq.vip.api.c.a().setVipCardDrawable(imageView, this.K);
    }

    private void Wl(String str) {
        Xl(str, "");
    }

    private void Xj() {
        ReportController.o(this.E, "dc00898", "", "", "0X800A17C", "0X800A17C", 1, 0, "", "", "", "");
        QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(getContext(), 230, null, HardCodeUtil.qqStr(R.string.ypg), HardCodeUtil.qqStr(R.string.lhy), false, HardCodeUtil.qqStr(R.string.cancel), HardCodeUtil.qqStr(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatSettingFragment.Lk(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatSettingFragment.this.Nk(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatSettingFragment.this.Ok(dialogInterface, i3);
            }
        });
        com.tencent.mobileqq.simpleui.c.j(createDialogWithCheckBox, 1000);
        createDialogWithCheckBox.show();
        Wl("0X800C037");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Xk(QQProAvatarView qQProAvatarView) {
        El(qQProAvatarView, 1, this.K);
    }

    private void Xl(String str, String str2) {
        ReportController.o(this.E, "dc00898", "", "", str, str, 0, 0, str2, "", "", "");
    }

    private void Yj(CompoundButton compoundButton, boolean z16) {
        String str;
        int i3;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            notifyUser(R.string.b3j, 1);
            this.f175354o0.e0(null);
            this.f175354o0.a0(true ^ compoundButton.isChecked());
            this.f175354o0.e0(this.f175365t1);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatSettingFragment", 2, "mDoNotDisturb switch, now value=", Boolean.valueOf(compoundButton.isChecked()));
        }
        NTFriendSettingHelper.f352067a.P(new NTFriendSettingHelper.a(this.E, this.K, this.L, compoundButton.isChecked(), 0), true);
        km();
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        Xl("0X800C032", str);
        QQAppInterface qQAppInterface = this.E;
        if (compoundButton.isChecked()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, i3, "0", "0", "", "");
        com.tencent.qqnt.notification.report.h.x(ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, "em_bas_friend_message_not_disturb", Boolean.valueOf(z16), this.f175340h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Yk(int i3, String str, final boolean z16) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.an
            @Override // java.lang.Runnable
            public final void run() {
                ChatSettingFragment.this.Zk(z16);
            }
        });
    }

    private void Yl(String str) {
        ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.37
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f175395d;

            {
                this.f175395d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                String str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                int i3 = 2;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    String str3 = "";
                    if (ChatSettingFragment.this.f175366u0 != null && (ChatSettingFragment.this.f175366u0.K() instanceof x.b.d)) {
                        str3 = (String) ((x.b.d) ChatSettingFragment.this.f175366u0.K()).getText();
                    }
                    if (ChatSettingFragment.this.f175366u0 != null && (ChatSettingFragment.this.f175366u0.O() instanceof x.c.f)) {
                        z16 = ((x.c.f) ChatSettingFragment.this.f175366u0.O()).getIsChecked();
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        str2 = "on";
                    } else {
                        str2 = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                    }
                    if (ChatSettingFragment.this.f175376z0) {
                        i3 = 3;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                    hashMap.put("zplan_action_type", this.f175395d);
                    hashMap.put(SquareReportConst.Key.KEY_ZPLAN_PG_ID, ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING);
                    hashMap.put("zplan_eid", "em_zplan_friend_time_switch");
                    hashMap.put("zplan_btn_text", str3);
                    hashMap.put("zplan_imp_switch_type", str2);
                    if ("click".equals(this.f175395d)) {
                        hashMap.put("zplan_switch_type", Integer.toString(i3));
                    }
                    VideoReport.reportEvent("ev_zplan_toast_total", hashMap);
                } catch (Throwable th5) {
                    QLog.e("ChatSettingFragment", 1, "reportFriendTime failed.", th5);
                }
            }
        }, 16, null, true);
    }

    private void Zj(CompoundButton compoundButton, boolean z16) {
        Yj(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zk(boolean z16) {
        if (!this.f175349l1 && z16 != this.G0.W()) {
            this.G0.e0(null);
            this.G0.a0(z16);
            this.G0.e0(this.f175369v1);
        }
    }

    private void Zl(boolean z16) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_set_top", Integer.valueOf(z16 ? 1 : 0));
        hashMap.put("to_uin", this.L);
        this.f175330c0.e("em_kl_set_top", hashMap);
    }

    private void ak(CompoundButton compoundButton, boolean z16) {
        QLog.i("ChatSettingFragment", 1, "handleFriendTimeCheckedChange, friendUin: " + this.K + ", isChecked: " + z16);
        ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).setCoupleAvatarSwitchState(this.K, z16, ZPlanCoupleSwitchChgSource.CHAT_SETTING);
        Yl("click");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.31
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (ChatSettingFragment.this.f175374y0 != null) {
                    QLog.i("ChatSettingFragment", 1, "mFriendTimesBubble dismiss on switch checked.");
                    ChatSettingFragment.this.f175374y0.setVisibility(8);
                    ChatSettingFragment.this.f175374y0 = null;
                }
            }
        });
    }

    private void am() {
        HashMap hashMap = new HashMap();
        hashMap.put("is_set_top", Integer.valueOf(this.G0.W() ? 1 : 0));
        hashMap.put("to_uin", this.L);
        this.f175330c0.g("em_kl_set_top", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bk, reason: merged with bridge method [inline-methods] */
    public void ql(View view) {
        ImageView b16 = vg3.e.f441630a.b(this.E, getContext(), this.K, this.f175357p1, view);
        this.f175374y0 = b16;
        if (b16 == null) {
            Yl("imp");
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.32
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (ChatSettingFragment.this.f175374y0 != null) {
                    ChatSettingFragment.this.f175357p1.addView(ChatSettingFragment.this.f175374y0);
                    ChatSettingFragment.this.f175374y0.setVisibility(0);
                    ChatSettingFragment.this.f175376z0 = true;
                    QQAppInterface qQAppInterface = ChatSettingFragment.this.E;
                    if (qQAppInterface != null) {
                        ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).setSettingBubbleShownMark(qQAppInterface.getCurrentUin());
                    }
                }
            }
        });
        Yl("imp");
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.W1, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bl(int i3, String str, final GroupRobotProfile groupRobotProfile) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.bd
            @Override // java.lang.Runnable
            public final void run() {
                ChatSettingFragment.this.al(groupRobotProfile);
            }
        });
    }

    private void bm() {
        String str;
        this.f175340h0.put("to_uin", this.K);
        HashMap<String, String> hashMap = this.f175340h0;
        if (this.J == 0) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("is_qq_fri", str);
        com.tencent.qqnt.notification.report.h.p(ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, this.f175340h0);
    }

    private boolean ck(boolean z16) {
        if (!((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable(ITroopUtilApi.HIDDEN_CHAT_DISABLE_OPEN_ON_STUDY_MODE, false) || !z16 || com.tencent.mobileqq.studymode.g.a() != 2) {
            return false;
        }
        QQToast.makeText(getContext(), 0, R.string.f2050054f, 0).show();
        this.f175352n0.e0(null);
        this.f175352n0.a0(false);
        this.f175352n0.e0(this.f175363s1);
        return true;
    }

    private void cm() {
        com.tencent.qqnt.notification.report.h.t(ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, this.f175340h0);
    }

    private void dk(CompoundButton compoundButton, boolean z16) {
        String str;
        int i3;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            notifyUser(R.string.b3j, 1);
            this.f175352n0.e0(null);
            this.f175352n0.a0(!compoundButton.isChecked());
            this.f175352n0.e0(this.f175363s1);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatSettingFragment", 2, "mHiddenChat switch, now value=", Boolean.valueOf(compoundButton.isChecked()));
        }
        if (ck(z16)) {
            return;
        }
        if (z16) {
            com.tencent.mobileqq.app.hiddenchat.a.c(this.E).f(getQBaseActivity());
        }
        km();
        this.C.setHiddenChat(new String[]{this.K}, new boolean[]{z16}, new int[]{this.J});
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        Xl("0X800C031", str);
        QQAppInterface qQAppInterface = this.E;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A348", "0X800A348", 1, i3, "0", "0", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dl(QQProAvatarView qQProAvatarView) {
        El(qQProAvatarView, 32, this.K);
    }

    private void dm() {
        boolean k3 = FriendsStatusUtil.k(this.K, this.E);
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = this.f175354o0;
        if (bVar != null) {
            bVar.e0(null);
            this.f175354o0.a0(k3);
            hm();
            this.f175354o0.e0(this.f175365t1);
            if (AppSetting.f99565y) {
                this.f175354o0.c0(getString(R.string.iur));
            }
        }
    }

    private void ek(boolean z16) {
        String str;
        int i3;
        NTFriendSettingHelper.f352067a.S(new NTFriendSettingHelper.a(this.E, this.K, this.L, z16, this.J));
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        Xl("0X800C030", str);
        QQAppInterface qQAppInterface = this.E;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i3, "0", "0", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void el(QQProAvatarView qQProAvatarView) {
        El(qQProAvatarView, 11, this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void em(String str) {
        TextView textView = this.P0;
        if (textView != null && str != null) {
            textView.setText(str);
        }
    }

    private void fk(CompoundButton compoundButton, boolean z16) {
        int i3;
        String str;
        QQAppInterface qQAppInterface = this.E;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, i3, "0", "0", "", "");
        ((IProfileCardBlacklistService) this.E.getRuntimeService(IProfileCardBlacklistService.class)).reportItemEvent("clck", ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, ProfileCardBlacklistReportConst.ELEM_ID_EM_BLOCK_USER_SWITCH, Vj(), new HashMap<String, String>(z16) { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.30
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$isChecked;

            {
                String str2;
                this.val$isChecked = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ChatSettingFragment.this, Boolean.valueOf(z16));
                    return;
                }
                if (z16) {
                    str2 = "1";
                } else {
                    str2 = "2";
                }
                put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_CLICK, str2);
            }
        });
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        Xl("0X800C034", str);
        boolean z17 = this.T0;
        if (z17 != z16) {
            if (z17) {
                ReportController.o(this.E, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "1", "", "");
            } else {
                ReportController.o(this.E, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "0", "", "");
            }
            xm();
            km();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fl(QQProAvatarView qQProAvatarView) {
        qQProAvatarView.setImageDrawable(((IMatchFriendFaceApi) QRoute.api(IMatchFriendFaceApi.class)).getMatchFriendFaceDrawable(this.E, this.Z));
    }

    private void fm() {
        int i3;
        if (this.f175352n0 != null) {
            boolean h16 = com.tencent.mobileqq.app.nthiddenchat.b.h(this.K, this.J, this.E);
            QLog.d(LogTag.TAG_HIDDEN_CHAT, 1, "ChatSettingActivity setFriendHiddenChatForm :" + h16 + "uin: " + this.K);
            this.f175352n0.e0(null);
            this.f175352n0.a0(h16);
            hm();
            com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = this.f175354o0;
            if (bVar != null && this.f175348l0 != null) {
                if (!this.f175352n0.W() && !this.f175348l0.W()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                bVar.h0(i3);
            }
            this.f175352n0.e0(this.f175363s1);
        }
    }

    private long getUin() {
        try {
            return Long.parseLong(this.K);
        } catch (NumberFormatException e16) {
            QLog.w("ChatSettingFragment", 1, "id is not a valid , uin: " + this.K + " id: " + this.L + " mCurType:" + this.J, e16);
            try {
                return Long.parseLong(this.L);
            } catch (NumberFormatException e17) {
                QLog.w("ChatSettingFragment", 1, "id is not a valid 2, uin: " + this.K + " id: " + this.L + " mCurType:" + this.J, e17);
                return 0L;
            }
        }
    }

    private void gk(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("ChatSettingFragment", 2, "handleStrangerCancelTopTips result:" + i3 + ", msg:" + str);
        }
        QQToastUtil.showQQToast(1, R.string.f201034tq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gl(QQProAvatarView qQProAvatarView) {
        El(qQProAvatarView, 1, this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(String str) {
        f.b bVar = this.f175342i0;
        if (bVar != null && bVar.U() != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f175342i0.U().j(str);
            } else {
                this.f175342i0.U().j(com.tencent.mobileqq.utils.ac.F(this.E, this.K));
            }
        }
    }

    private void hk(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("ChatSettingFragment", 2, "handleStrangerSetTopTips result:" + i3 + ", msg:" + str);
        }
        if (i3 == 3000) {
            QQToastUtil.showQQToast(0, str);
        } else {
            QQToastUtil.showQQToast(1, R.string.f201074tu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hl(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void ik(CompoundButton compoundButton, boolean z16) {
        String str;
        if (this.Y0 != z16) {
            QQAppInterface qQAppInterface = this.E;
            String str2 = "1";
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", str, "", "");
            int i3 = this.J;
            if (i3 == 1044 || i3 == 1045) {
                HashMap hashMap = new HashMap();
                if (!z16) {
                    str2 = "2";
                }
                hashMap.put("button", str2);
                hashMap.put("frompage", String.valueOf(from()));
                hashMap.put("to_uid", this.K);
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#block_page#block", true, -1L, -1L, hashMap, true, true);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ChatSettingActivity.nearby", 2, "onCheckedChanged, isCheck=" + z16);
            }
            zm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void il(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        ek(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im(RichStatus richStatus, TextView textView) {
        Bitmap g16;
        this.M1 = richStatus;
        this.L1 = textView;
        if (richStatus != null && textView != null) {
            CharSequence spannableString = richStatus.toSpannableString(null);
            if (!TextUtils.isEmpty(richStatus.actionText)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
                spannableStringBuilder.insert(0, (CharSequence) "[S] ");
                StatusManager statusManager = (StatusManager) this.E.getManager(QQManagerFactory.STATUS_MANAGER);
                if (statusManager != null) {
                    g16 = statusManager.K(richStatus.actionId, 200);
                } else {
                    g16 = com.tencent.mobileqq.util.j.g(getResources(), R.drawable.bwk);
                }
                com.tencent.mobileqq.widget.bo boVar = new com.tencent.mobileqq.widget.bo(getResources(), g16, false, false);
                int textSize = (int) ((textView.getTextSize() * 1.1f) + 0.5f);
                boVar.setBounds(0, 0, textSize, textSize);
                OffsetableImageSpan offsetableImageSpan = new OffsetableImageSpan(boVar, 0);
                offsetableImageSpan.setOffset(-0.1f);
                spannableStringBuilder.setSpan(offsetableImageSpan, 0, 3, 17);
                textView.setVisibility(0);
                textView.setText(spannableStringBuilder);
                return;
            }
            if (!TextUtils.isEmpty(spannableString)) {
                textView.setVisibility(0);
                textView.setText(spannableString);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    private void jk(CompoundButton compoundButton, final boolean z16) {
        ((IStrangerChatsApi) QRoute.api(IStrangerChatsApi.class)).doSetTopOrNot(this.L, z16, new com.tencent.qqnt.chats.api.c() { // from class: com.tencent.mobileqq.activity.aw
            @Override // com.tencent.qqnt.chats.api.c
            public final void onResult(int i3, String str) {
                ChatSettingFragment.this.Qk(z16, i3, str);
            }
        });
        Zl(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void jl(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        dk(compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private void jm() {
        QQAppInterface qQAppInterface = this.E;
        if (qQAppInterface != null && qQAppInterface.getCurrentUin().equals(this.K)) {
            g.b bVar = this.f175362s0;
            if (bVar != null) {
                bVar.h0(8);
            }
            com.tencent.mobileqq.activity.newsetting.custom.config.b bVar2 = this.f175354o0;
            if (bVar2 != null) {
                bVar2.h0(8);
            }
            com.tencent.mobileqq.activity.newsetting.custom.config.b bVar3 = this.f175352n0;
            if (bVar3 != null) {
                bVar3.h0(8);
            }
            com.tencent.mobileqq.activity.newsetting.custom.config.b bVar4 = this.f175348l0;
            if (bVar4 != null) {
                bVar4.h0(8);
            }
            a.C7175a c7175a = this.f175370w0;
            if (c7175a != null) {
                c7175a.R(8);
            }
            com.tencent.mobileqq.activity.newsetting.custom.config.b bVar5 = this.f175356p0;
            if (bVar5 != null) {
                bVar5.h0(8);
            }
            com.tencent.mobileqq.activity.newsetting.custom.config.b bVar6 = this.f175366u0;
            if (bVar6 != null) {
                bVar6.h0(8);
            }
        }
    }

    private void kk(CompoundButton compoundButton, boolean z16) {
        if (this.Z0 != z16) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatSettingActivity.nearby", 2, "onCheckedChanged, isCheck=" + z16);
            }
            zm();
            this.Z0 = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void kl(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Zj(compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km() {
        boolean z16;
        boolean z17 = true;
        boolean z18 = !this.f175348l0.W();
        if (z18 && !this.f175352n0.W()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || this.f175354o0.W()) {
            z17 = false;
        }
        Am(this.f175362s0, z18);
        Am(this.f175354o0, z16);
        Am(this.f175356p0, z17);
        this.D.getBoolean("KEY_IS_FROM_SCALE_CHAT", false);
        if (this.f175359q1) {
            jm();
        }
    }

    private boolean lk() {
        if (this.J == 1001) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ll(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        fk(compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private void lm(String str) {
        if (this.f175353n1 == null) {
            if (this.T) {
                Ij(str);
            } else if (((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList()) {
                pm(str);
            } else if (com.tencent.relation.common.config.toggle.c.I.g(false)) {
                Fj(str);
            } else {
                Hj(str);
            }
            QQCustomDialog qQCustomDialog = this.f175353n1;
            if (qQCustomDialog != null) {
                qQCustomDialog.setTitleMutiLine();
            }
        }
        QQCustomDialog qQCustomDialog2 = this.f175353n1;
        if (qQCustomDialog2 != null && !qQCustomDialog2.isShowing()) {
            this.f175353n1.show();
            ReportController.o(this.E, "dc00898", "", "", "0X800C00A", "0X800C00A", 0, 0, "", "", "", "");
        }
    }

    private void mk() {
        boolean z16;
        this.K = this.D.getString("uin", "");
        this.L = this.D.getString("KEY_UID", "");
        String string = this.D.getString("uinname");
        this.M = string;
        if (string == null) {
            this.M = this.K;
        }
        try {
            Long.valueOf(this.K);
        } catch (NumberFormatException unused) {
            this.K = "0";
            QLog.i("ChatSettingFragment", 1, "[initBaseData]: initBaseData, uin is invalid");
        }
        this.J = this.D.getInt("uintype", -1);
        this.W = this.D.getBoolean(AppConstants.Key.FOLLOW_FLAG, false);
        this.T = Ak();
        this.U = xk();
        if (this.J == 0 && !Cj(this.K)) {
            this.J = 1003;
        }
        if (this.J == 1046) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f175343i1 = z16;
        if (z16) {
            this.X = this.D.getString("key_match_friend_self_open_id");
            this.Y = this.D.getString("key_match_friend_open_id");
            this.Z = this.D.getString("key_match_friend_avatar_url");
            this.f175326a0 = this.D.getInt("key_match_friend_source", 0);
            this.f175328b0 = this.D.getString("recom_trace", "");
            com.tencent.mobileqq.matchfriend.utils.d dVar = new com.tencent.mobileqq.matchfriend.utils.d(getQBaseActivity());
            this.f175330c0 = dVar;
            dVar.c("pg_kl_new_chat_page_setting", Uj());
            this.f175330c0.b(Tj());
            this.f175330c0.i(Uj());
        }
        int i3 = this.J;
        if (1 == i3 || 1000 == i3 || 1004 == i3) {
            this.V = this.D.getString("troop_uin");
        }
        this.f175345j1 = this.D.getInt(AppConstants.Key.ADD_FRIEND_SOURCE_ID, BuddySource.DEFAULT);
        this.f175338g0 = this.D.getString(AppConstants.Key.REAL_TROOP_UIN);
        this.U0 = VasUtil.getService().getSpecialSoundManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ml(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        jk(compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private void mm() {
        DialogUtil.createCustomDialog(getContext(), 230).setMessage(HardCodeUtil.qqStr(R.string.kgl)).setPositiveButton(android.R.string.ok, new d()).setNegativeButton(17039360, new c()).show();
    }

    private void nk() {
        if (!this.D.getBoolean("KEY_IS_FROM_SCALE_CHAT", false)) {
            return;
        }
        this.f175344j0.R(8);
        this.f175352n0.h0(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void nl(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        ik(compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private void nm() {
        ReportController.o(this.E, "dc00898", "", "", "0X800B6B9", "0X800B6B9", 0, 0, "", "", "", "");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(getActivity(), 1, R.string.zzx, 0).show();
            return;
        }
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(getContext(), 230).setMessage(getResources().getString(R.string.f199094oh)).setPositiveButton(getResources().getString(R.string.f199084og), new b()).setNegativeButton(getResources().getString(R.string.f199074of), new a());
        negativeButton.show();
        ((TextView) negativeButton.findViewById(R.id.dialogText)).setGravity(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUser(int i3, int i16) {
        QQToast.makeText(BaseApplication.getContext(), i16, i3, 0).show();
    }

    private void ok() {
        boolean z16;
        C2CChatSettingView c2CChatSettingView = (C2CChatSettingView) ((QIphoneStatusTitleBarFragment) this).mContentView.findViewById(R.id.tkk);
        this.f175357p1 = c2CChatSettingView;
        if (c2CChatSettingView == null) {
            return;
        }
        boolean z17 = false;
        try {
            com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
            bVar.l(this.F.getWindow());
            bVar.a(this.f175357p1.getChildAt(0), RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        } catch (Exception e16) {
            QLog.e("ChatSettingFragment", 1, "initFriendView " + e16);
        }
        C2CChatSettingView c2CChatSettingView2 = this.f175357p1;
        if (c2CChatSettingView2 != null && c2CChatSettingView2.j() != null) {
            this.f175357p1.j().addOnScrollListener(this.A1);
        }
        this.f175342i0 = this.f175357p1.s().l();
        QLog.d("CSG-ChatSettingFragment", 1, "[loadFriendView] mFriendInfo:" + this.f175342i0);
        f.a k3 = this.f175357p1.s().k();
        this.f175344j0 = k3;
        this.V0 = k3.T();
        com.tencent.mobileqq.activity.newsetting.custom.item.b S = this.f175344j0.S();
        this.W0 = S;
        S.c(new g71.a() { // from class: com.tencent.mobileqq.activity.x
            @Override // g71.a
            public final void a(Object obj) {
                ChatSettingFragment.Rk((ImageView) obj);
            }
        });
        this.f175346k0 = this.f175357p1.q().j();
        com.tencent.mobileqq.activity.newsetting.custom.config.b q16 = this.f175357p1.u().q();
        this.f175350m0 = q16;
        q16.a0(FriendsStatusUtil.j(this.E, this.K, this.J));
        this.f175350m0.e0(this.f175361r1);
        com.tencent.mobileqq.activity.newsetting.custom.config.b k16 = this.f175357p1.u().k();
        this.f175352n0 = k16;
        k16.e0(this.f175363s1);
        com.tencent.mobileqq.activity.newsetting.custom.config.b m3 = this.f175357p1.u().m();
        this.f175354o0 = m3;
        m3.e0(this.f175365t1);
        this.f175356p0 = this.f175357p1.u().o();
        this.f175358q0 = (com.tencent.mobileqq.activity.newsetting.custom.config.b) this.f175357p1.o().b();
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar2 = (com.tencent.mobileqq.activity.newsetting.custom.config.b) this.f175357p1.o().a();
        this.f175360r0 = bVar2;
        bVar2.h0(8);
        if (this.C1) {
            this.f175362s0 = this.f175357p1.u().s();
            this.f175357p1.t().j().h0(8);
        } else {
            this.f175362s0 = this.f175357p1.t().j();
            this.f175357p1.u().s().h0(8);
        }
        this.f175364t0 = this.f175357p1.p().j();
        com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.e r16 = this.f175357p1.r();
        this.f175372x0 = r16;
        this.f175366u0 = r16.j();
        this.f175366u0.a0(((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleAvatarSwitchState(this.K));
        this.f175366u0.e0(this.f175375y1);
        this.f175372x0.l(this.f175377z1);
        a.C7175a j3 = this.f175357p1.k().j();
        this.f175370w0 = j3;
        if (this.D1) {
            j3.T().g(8);
        }
        this.f175348l0 = this.f175357p1.v().j();
        this.N0 = this.f175357p1.w();
        this.O0 = this.f175357p1.x();
        this.f175368v0 = this.f175357p1.l().j();
        this.M0 = this.f175357p1.n();
        this.f175348l0.e0(this.f175367u1);
        if (SimpleModeHelper.B()) {
            this.f175370w0.T().k(Color.parseColor("#FF5967"));
        }
        final String Pj = Pj();
        String Oj = Oj();
        if (AppSetting.f99565y) {
            this.f175368v0.c0(getString(R.string.ake));
            this.f175368v0.b0(Button.class.getName());
            this.f175370w0.T().c(new g71.a() { // from class: com.tencent.mobileqq.activity.y
                @Override // g71.a
                public final void a(Object obj) {
                    ChatSettingFragment.Sk(Pj, (TextView) obj);
                }
            });
            this.f175370w0.S().c(new g71.a() { // from class: com.tencent.mobileqq.activity.aa
                @Override // g71.a
                public final void a(Object obj) {
                    ChatSettingFragment.this.Tk((TextView) obj);
                }
            });
            this.f175342i0.T().e(getString(R.string.bwi));
            this.W0.e(getString(R.string.f170088fk));
            this.f175346k0.c0(getString(R.string.f170724a12) + " " + getString(R.string.f170723a11));
            this.f175364t0.c0(getString(R.string.hfe));
            this.f175366u0.c0(getString(R.string.f225286l8));
            this.f175362s0.c0(getString(R.string.f172976g92));
            this.f175356p0.c0(getString(R.string.f171149iv3) + getString(R.string.f173111vr2));
            this.f175358q0.c0(getString(R.string.cz4));
            this.f175354o0.c0(getString(R.string.iur));
            this.f175352n0.c0(getString(R.string.iwm));
            this.f175348l0.c0(getString(R.string.a2q));
            this.f175350m0.c0(getString(R.string.d4j));
            this.f175370w0.T().e(getString(R.string.ak8));
            this.f175370w0.U().e("\u4ece\u8fc7\u6ee4\u6d88\u606f\u79fb\u51fa");
            this.f175370w0.S().e(Oj);
        }
        this.f175344j0.x(this);
        this.W0.f(this);
        this.f175346k0.x(this);
        this.f175364t0.x(this);
        this.f175342i0.X().f(this);
        this.f175362s0.x(this);
        this.f175356p0.x(this);
        this.f175358q0.x(this);
        this.f175358q0.h0(8);
        this.f175342i0.x(this);
        this.f175342i0.S().f(this);
        this.f175342i0.U().f(this);
        this.f175368v0.x(this);
        this.M0.setOnClickListener(this);
        this.N0.setOnClickListener(this);
        this.f175370w0.T().f(this);
        this.f175370w0.S().f(this);
        this.f175360r0.x(this);
        String Qj = Qj(this.K);
        this.Q0 = Qj;
        if (Qj == null) {
            this.Q0 = "";
        }
        gm(this.Q0);
        if (this.Q0 != null) {
            this.f175342i0.U().j(this.Q0);
        }
        int[] d16 = ff.j.d(this.E, this.K);
        boolean g16 = ff.j.g(d16[0]);
        if (g16 && com.tencent.mobileqq.vip.api.c.a().isGrayVipIcon(d16[1])) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (g16) {
            this.f175342i0.X().c(new g71.a() { // from class: com.tencent.mobileqq.activity.ab
                @Override // g71.a
                public final void a(Object obj) {
                    ChatSettingFragment.this.Uk((ImageView) obj);
                }
            });
        }
        ff.j.b.c(this.E, this.K, "VIA_AIO_CHATSETTINGS").d();
        short q17 = com.tencent.mobileqq.utils.ff.q(this.E, this.K);
        if (QLog.isColorLevel()) {
            QLog.d("ChatSettingFragment", 2, "bindView: vip=" + ((int) q17));
        }
        int i3 = q17 >> 8;
        if (i3 > 0 && !SimpleUIUtil.getSimpleUISwitch() && !z16) {
            this.f175342i0.U().c(new g71.a() { // from class: com.tencent.mobileqq.activity.ac
                @Override // g71.a
                public final void a(Object obj) {
                    ChatSettingFragment.this.Vk((TextView) obj);
                }
            });
        }
        if (i3 > 1 && !SimpleUIUtil.getSimpleUISwitch()) {
            if (!g16) {
                this.f175342i0.X().c(new g71.a() { // from class: com.tencent.mobileqq.activity.ad
                    @Override // g71.a
                    public final void a(Object obj) {
                        ChatSettingFragment.this.Wk((ImageView) obj);
                    }
                });
            }
            this.f175342i0.U().i(com.tencent.mobileqq.utils.ff.m(1));
            this.f175342i0.X().g(0);
        } else {
            this.f175342i0.U().i(com.tencent.mobileqq.utils.ff.m(0));
            this.f175342i0.X().i(null);
            this.f175342i0.X().g(8);
        }
        if (this.K != null) {
            this.f175342i0.S().c(new g71.a() { // from class: com.tencent.mobileqq.activity.ae
                @Override // g71.a
                public final void a(Object obj) {
                    ChatSettingFragment.this.Xk((QQProAvatarView) obj);
                }
            });
        }
        Sj(this.K, new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b>() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatSettingFragment.this);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                if (eVar == null || eVar.a() != 0 || eVar.b() == null || eVar.b().isEmpty()) {
                    ChatSettingFragment.this.R0 = "";
                } else {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar3 = eVar.b().get(0);
                    ChatSettingFragment.this.R0 = bVar3.f();
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatSettingFragment.3.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (ChatSettingFragment.this.R0 == null) {
                            ChatSettingFragment.this.R0 = "";
                        }
                        ChatSettingFragment chatSettingFragment = ChatSettingFragment.this;
                        chatSettingFragment.em(chatSettingFragment.R0);
                    }
                });
            }
        });
        if (this.T) {
            this.f175342i0.W().g(0);
        } else {
            this.f175342i0.W().g(8);
        }
        tk();
        if (!zk()) {
            this.f175370w0.U().g(8);
        }
        if (Utils.G(this.K)) {
            this.f175362s0.h0(8);
            this.f175348l0.h0(8);
            TempGetProfileDetailProcessor tempGetProfileDetailProcessor = (TempGetProfileDetailProcessor) ProfileServiceUtils.getBusinessProcessor(this.E, TempGetProfileDetailProcessor.class);
            if (tempGetProfileDetailProcessor != null) {
                tempGetProfileDetailProcessor.getBabyQSwitch();
            }
        }
        nk();
        if (QidianManager.P(this.E, this.K) || this.T) {
            this.f175344j0.R(8);
        }
        if (this.E != null) {
            Sl();
            Hm();
            dm();
        }
        if (yk()) {
            this.f175364t0.h0(8);
        }
        fm();
        jm();
        if (((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList()) {
            this.f175348l0.h0(8);
        }
        boolean hasAvatarFeature = ((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).hasAvatarFeature();
        boolean z18 = this.D.getBoolean("KEY_IS_FROM_SCALE_CHAT", false);
        if (ForegroundNotifyManager.b(this.E).p() || z18) {
            z17 = true;
        }
        QLog.i("ChatSettingFragment", 1, "checkNeedShowFriendTime, hasFeature: " + hasAvatarFeature + ", isMiniAIO: " + z17);
        if (!hasAvatarFeature || z17 || this.T) {
            this.f175366u0.h0(8);
            if (!z17 && !this.T) {
                ((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).registerAIOWhiteListListener(this.V1);
            }
        }
        this.f175370w0.T().j(Pj);
        this.f175370w0.S().j(Oj);
        if (this.T) {
            sk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ol(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        kk(compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private void pk() {
        this.C = (FriendListHandler) this.E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pl(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        ak(compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private void pm(final String str) {
        this.f175353n1 = DialogUtil.createCustomDialog(getContext(), 0, "", getString(R.string.zli), R.string.cancel, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.at
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatSettingFragment.this.ul(str, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.au
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatSettingFragment.this.vl(dialogInterface, i3);
            }
        });
    }

    private void qk(String str) {
        QQProgressDialog qQProgressDialog = new QQProgressDialog(getContext());
        this.H = qQProgressDialog;
        qQProgressDialog.setContentView(R.layout.bwu);
        if (str != null && !"".equals(str.trim())) {
            this.H.setMessage(str);
        } else {
            this.H.setMessage(getString(R.string.hex));
        }
    }

    private void qm(final String str, final int i3) {
        String str2;
        String str3 = this.M;
        if (str3 != null && !str3.isEmpty() && !this.M.equals(this.K)) {
            str2 = this.M;
        } else {
            str2 = "\u667a\u80fd\u4f53";
        }
        DialogUtil.createCustomDialog(getContext(), 0, null, getResources().getString(R.string.f223056f7, str2), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                ChatSettingFragment.this.wl(str, i3, dialogInterface, i16);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                ChatSettingFragment.xl(dialogInterface, i16);
            }
        }).show();
    }

    private void rk() {
        if (this.J == 1046) {
            ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).getUserShield(this.E, Long.parseLong(this.K));
            ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).getIsFriend(this.E, this.Y);
            ((IStrangerChatsApi) QRoute.api(IStrangerChatsApi.class)).fetchOneSetTopStatus(this.L, new com.tencent.qqnt.chats.api.d() { // from class: com.tencent.mobileqq.activity.bl
                @Override // com.tencent.qqnt.chats.api.d
                public final void onResult(int i3, String str, boolean z16) {
                    ChatSettingFragment.this.Yk(i3, str, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void rl(int i3, String str, CommandCbRsp commandCbRsp) {
        QLog.i("ChatSettingFragment", 1, "[resetConversation]: result is " + i3 + " errMsg is " + str + " response is " + commandCbRsp);
        Lj();
        ((IRobotExtApi) QRoute.api(IRobotExtApi.class)).handleOnBackendReply(MobileQQ.sMobileQQ, commandCbRsp.status, commandCbRsp.promptType, commandCbRsp.promptText, commandCbRsp.promptIcon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rm(int i3, String str) {
        if (this.f175334e0) {
            return;
        }
        if (i3 == -1) {
            QQToast.makeText(getContext(), str, 0).show();
        } else {
            QQToast.makeText(getContext(), i3, str, 0).show();
        }
    }

    private void sk() {
        com.tencent.qqnt.kernel.api.ac robotService;
        g.b bVar = this.f175362s0;
        if (bVar != null) {
            bVar.h0(8);
            this.f175362s0.k0(true);
        }
        a.C7175a c7175a = this.f175370w0;
        if (c7175a != null) {
            c7175a.T().g(0);
        }
        QQAppInterface qQAppInterface = this.E;
        if (qQAppInterface != null && (robotService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class)).getRobotService()) != null) {
            this.F1 = robotService.addKernelRobotListener(this.G1);
        }
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).fetchRobotProfileInfo(this.K, "", new IGetGroupRobotProfileCallback() { // from class: com.tencent.mobileqq.activity.bc
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                ChatSettingFragment.this.bl(i3, str, groupRobotProfile);
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0039. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0159 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0066 A[FALL_THROUGH, PHI: r2 r11
  0x0066: PHI (r2v15 int) = (r2v14 int), (r2v14 int), (r2v16 int), (r2v16 int) binds: [B:15:0x0033, B:58:0x0064, B:17:0x0039, B:55:0x005c] A[DONT_GENERATE, DONT_INLINE]
  0x0066: PHI (r11v17 int) = (r11v12 int), (r11v18 int), (r11v12 int), (r11v20 int) binds: [B:15:0x0033, B:58:0x0064, B:17:0x0039, B:55:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void sm() {
        int i3;
        int i16;
        String str;
        int i17;
        Intent startAddFriend;
        int i18 = this.J;
        int i19 = 0;
        String str2 = null;
        if (i18 != 1009) {
            if (i18 != 1010) {
                int i26 = 1;
                if (i18 != 1036) {
                    if (i18 != 10004) {
                        if (i18 != 10010) {
                            if (i18 != 10007) {
                                if (i18 != 10008) {
                                    int i27 = 12;
                                    i3 = 3008;
                                    switch (i18) {
                                        case 1000:
                                            str2 = this.D.getString("troop_uin");
                                            i3 = 3004;
                                            break;
                                        case 1001:
                                            i3 = 3007;
                                            break;
                                        case 1002:
                                            i16 = 0;
                                            str = null;
                                            i3 = 3003;
                                            break;
                                        case 1003:
                                            i3 = 3071;
                                            break;
                                        case 1004:
                                            str2 = this.D.getString("troop_uin");
                                            i3 = 3005;
                                            break;
                                        case 1005:
                                            i16 = i27;
                                            str = str2;
                                            break;
                                        case 1006:
                                            i3 = 3006;
                                            i16 = i27;
                                            str = str2;
                                            break;
                                        default:
                                            i27 = 11;
                                            i26 = 2;
                                            switch (i18) {
                                                case 1021:
                                                    str = null;
                                                    i16 = 2;
                                                    i3 = 3003;
                                                    break;
                                                case 1022:
                                                    i3 = 3041;
                                                case 1023:
                                                    break;
                                                case 1024:
                                                    i3 = 3072;
                                                    break;
                                                default:
                                                    switch (i18) {
                                                        case 1044:
                                                        case 1045:
                                                            i19 = this.D.getInt("subId", 0);
                                                            i3 = 3094;
                                                            break;
                                                        case 1046:
                                                            i19 = com.tencent.mobileqq.matchfriend.utils.e.a(this.f175326a0);
                                                            i3 = 3094;
                                                            break;
                                                        default:
                                                            i3 = BuddySource.DEFAULT;
                                                            break;
                                                    }
                                            }
                                    }
                                    if (i3 != 3007) {
                                        if (!LBSHandler.D2(this.E, this.K)) {
                                            om();
                                            return;
                                        }
                                    } else if (i3 == 3019 && !com.tencent.mobileqq.dating.f.a(this.E, this.K)) {
                                        om();
                                        return;
                                    }
                                    i17 = this.J;
                                    if (i17 == 3 && i17 != 4000 && i17 != 1006) {
                                        if (i17 == 10007) {
                                            startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(getContext(), 3, this.N, str, i3, i16, this.M, this.R, null, getString(R.string.button_back), null);
                                        } else {
                                            startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(getContext(), 1, this.K, str, i3, i16, this.M, null, null, getString(R.string.button_back), null);
                                        }
                                    } else {
                                        startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(getContext(), 2, this.f175335e1, null, i3, i16, this.M, null, null, getString(R.string.button_back), null);
                                    }
                                    if (i3 == 3094 && startAddFriend != null) {
                                        startAddFriend.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 3);
                                    }
                                    if (startAddFriend == null) {
                                        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(getContext(), startAddFriend);
                                        return;
                                    }
                                    return;
                                }
                                i3 = 3050;
                            } else {
                                str2 = this.D.getString("appid");
                                this.N = this.D.getString("openid");
                                i3 = 3016;
                                i19 = 101;
                            }
                        } else {
                            i3 = 3076;
                            i19 = 6;
                        }
                    } else {
                        i3 = 3043;
                    }
                    i16 = 3;
                    str = str2;
                    if (i3 != 3007) {
                    }
                    i17 = this.J;
                    if (i17 == 3) {
                    }
                    startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(getContext(), 2, this.f175335e1, null, i3, i16, this.M, null, null, getString(R.string.button_back), null);
                    if (i3 == 3094) {
                        startAddFriend.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 3);
                    }
                    if (startAddFriend == null) {
                    }
                } else {
                    i3 = 3099;
                }
                str = null;
                i16 = i26;
                if (i3 != 3007) {
                }
                i17 = this.J;
                if (i17 == 3) {
                }
                startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(getContext(), 2, this.f175335e1, null, i3, i16, this.M, null, null, getString(R.string.button_back), null);
                if (i3 == 3094) {
                }
                if (startAddFriend == null) {
                }
            } else {
                i3 = 3019;
            }
        } else {
            i3 = 3013;
        }
        i16 = i19;
        str = str2;
        if (i3 != 3007) {
        }
        i17 = this.J;
        if (i17 == 3) {
        }
        startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(getContext(), 2, this.f175335e1, null, i3, i16, this.M, null, null, getString(R.string.button_back), null);
        if (i3 == 3094) {
        }
        if (startAddFriend == null) {
        }
    }

    private void tk() {
        SharedPreferences sharedPreferences = this.E.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
        if (sharedPreferences.getBoolean(AppConstants.Preferences.SPECIAL_CARE_CHAT_SETTING, true) && !com.tencent.mobileqq.activity.specialcare.e.p(this.K, this.E)) {
            this.f175362s0.l0(getResources().getDrawable(R.drawable.skin_tips_new), QCircleDaTongConstant.ElementParamValue.NEW);
            return;
        }
        boolean z16 = sharedPreferences.getBoolean(AppConstants.Preferences.SPECIAL_CARE_RED_POINT_ONE, false);
        sharedPreferences.getBoolean(AppConstants.Preferences.SPECIAL_CARE_RED_POINT_TWO, false);
        if (z16) {
            this.f175362s0.l0(getResources().getDrawable(R.drawable.skin_tips_dot), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tl(int i3, String str, final GroupRobotProfile groupRobotProfile) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.w
            @Override // java.lang.Runnable
            public final void run() {
                ChatSettingFragment.this.sl(groupRobotProfile);
            }
        });
    }

    private void tm() {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(getContext()), null);
        m3.putExtra("uin", this.K);
        m3.putExtra("uinname", this.M);
        m3.putExtra("uintype", this.J);
        m3.putExtra("isNeedUpdate", this.f175332d0);
        startActivity(m3);
    }

    private void uk() {
        int i3;
        Bundle bundle;
        int i16;
        boolean z16;
        int i17;
        Bundle bundle2;
        StrangerChatSettingView strangerChatSettingView = (StrangerChatSettingView) ((QIphoneStatusTitleBarFragment) this).mContentView.findViewById(R.id.f88564xe);
        this.I = strangerChatSettingView;
        this.F0 = strangerChatSettingView.j().j();
        this.B0 = this.I.p().j();
        com.tencent.mobileqq.activity.newsetting.custom.config.b<?, ?> j3 = this.I.o().j();
        this.G0 = j3;
        if (this.f175343i1) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        j3.h0(i3);
        if (this.f175343i1) {
            this.G0.a0(((IStrangerChatsApi) QRoute.api(IStrangerChatsApi.class)).isTop(this.L));
            this.G0.e0(this.f175369v1);
            am();
        }
        this.C0 = this.I.n().j();
        this.D0 = this.I.m().j();
        com.tencent.mobileqq.activity.newsetting.custom.config.b j16 = this.I.q().j();
        this.E0 = j16;
        j16.h0(8);
        this.H0 = this.I.l().j().U();
        this.I0 = this.I.l().j().S();
        this.I.l().k().R(8);
        a.C7178a j17 = this.I.l().j();
        this.A0 = j17;
        this.J0 = j17.T();
        this.K0 = this.A0.W();
        com.tencent.mobileqq.activity.newsetting.custom.item.c V = this.A0.V();
        this.L0 = V;
        V.g(8);
        this.D0.h0(8);
        if (lk()) {
            this.C0.h0(8);
        }
        if (this.J == 1036) {
            if (Cj(this.K)) {
                this.H0.g(8);
                this.I0.g(0);
                this.I0.f(this);
                this.C0.h0(8);
            }
            this.B0.h0(8);
        } else {
            this.B0.h0(0);
            this.H0.g(0);
            this.I0.g(8);
        }
        int i18 = this.J;
        if (i18 == 1044 || i18 == 1045) {
            this.K0 = this.I.l().j().W();
            Dj();
        }
        if (this.T) {
            this.H0.g(8);
            this.B0.h0(8);
            this.K0.j(Oj());
        }
        if (this.f175343i1) {
            this.C0.h0(0);
            this.B0.h0(8);
            this.D0.h0(8);
            this.H0.g(8);
            this.K0 = this.I.l().j().W();
        } else if (((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList()) {
            this.C0.h0(8);
        }
        if (!zk()) {
            this.J0.g(8);
        }
        if (AppSetting.f99565y) {
            this.F0.O(getString(R.string.bwi));
            this.B0.c0(getString(R.string.a2m));
            this.C0.c0(getString(R.string.a2q));
            this.D0.c0(getString(R.string.a2q));
            this.H0.e(getString(R.string.a2l));
            this.K0.e(getString(R.string.f169995c2));
            this.J0.e("\u4ece\u8fc7\u6ee4\u6d88\u606f\u79fb\u51fa");
        }
        if (this.J == 10004) {
            this.F0.O("");
            this.F0.T().g(8);
            this.F0.T().c(new g71.a() { // from class: com.tencent.mobileqq.activity.ao
                @Override // g71.a
                public final void a(Object obj) {
                    ((ImageView) obj).setVisibility(8);
                }
            });
        } else {
            this.F0.x(this);
        }
        if (this.J == 1006 && (bundle2 = this.D) != null && bundle2.getBoolean("isShieldMsgSwitchUnClickable", false)) {
            this.C0.h0(8);
        } else {
            this.C0.a0(true);
            this.C0.e0(this.f175371w1);
        }
        this.B0.x(this);
        this.K0.f(this);
        this.J0.f(this);
        this.F0.x(this);
        this.F0.S().f(this);
        this.F0.U().f(this);
        this.H0.f(this);
        int i19 = this.J;
        if (i19 != 1010 && (i19 != 1022 || ((i17 = this.f175345j1) != 3007 && i17 != 2007 && i17 != 4007 && i17 != 3019 && i17 != 2019))) {
            if (i19 == 1006) {
                this.F0.U().c(new g71.a() { // from class: com.tencent.mobileqq.activity.aq
                    @Override // g71.a
                    public final void a(Object obj) {
                        ChatSettingFragment.this.el((QQProAvatarView) obj);
                    }
                });
            } else if (this.f175343i1) {
                this.F0.U().c(new g71.a() { // from class: com.tencent.mobileqq.activity.ar
                    @Override // g71.a
                    public final void a(Object obj) {
                        ChatSettingFragment.this.fl((QQProAvatarView) obj);
                    }
                });
            } else {
                this.F0.U().c(new g71.a() { // from class: com.tencent.mobileqq.activity.as
                    @Override // g71.a
                    public final void a(Object obj) {
                        ChatSettingFragment.this.gl((QQProAvatarView) obj);
                    }
                });
            }
        } else {
            this.F0.U().c(new g71.a() { // from class: com.tencent.mobileqq.activity.ap
                @Override // g71.a
                public final void a(Object obj) {
                    ChatSettingFragment.this.dl((QQProAvatarView) obj);
                }
            });
        }
        this.f175329b1 = this.K;
        if (this.J == 10007 && this.D != null) {
            this.K0 = this.I.l().j().W();
            this.F0.S().g(8);
            this.F0.U().g(8);
            this.F0.R(8);
            this.C0.h0(8);
            this.D0.h0(0);
            this.D0.e0(this.f175373x1);
            this.f175329b1 = this.D.getString("account");
            this.N = this.D.getString("openid");
            this.P = this.D.getString(AppConstants.Key.KEY_GAME_MSG_FRIEND_ROLEID);
            this.Q = this.D.getString(AppConstants.Key.KEY_GAME_MSG_MY_ROLEID);
            this.S = this.D.getInt(AppConstants.Key.KEY_GAME_CHATPIE_HASHCODE, 0);
            boolean z17 = this.D.getBoolean(AppConstants.Key.KEY_GAME_IS_SHILED, false);
            this.Z0 = z17;
            this.D0.a0(z17);
            this.R = this.D.getString(AppConstants.Key.KEY_GAME_MSG);
            this.H0.j(getString(R.string.f1373806p));
            if (Cj(this.f175329b1)) {
                this.H0.g(8);
            }
        }
        int i26 = this.J;
        if ((i26 == 1000 || i26 == 1004) && (bundle = this.D) != null) {
            this.f175333d1 = bundle.getString("troop_uin");
        }
        if (this.J == 1006) {
            String str = this.K;
            this.f175335e1 = str;
            if (TextUtils.isEmpty(str)) {
                this.f175327a1 = false;
            } else {
                String m06 = com.tencent.mobileqq.utils.ac.m0(this.E, this.f175335e1);
                if (TextUtils.isEmpty(m06)) {
                    this.f175327a1 = false;
                } else {
                    this.f175327a1 = true;
                    this.f175329b1 = m06;
                }
            }
        }
        ShieldMsgManger shieldMsgManger = (ShieldMsgManger) this.E.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
        if (shieldMsgManger != null && !TextUtils.isEmpty(this.f175329b1)) {
            this.Y0 = shieldMsgManger.h(this.f175329b1);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initStrangerView, shieldMsgManger=");
            if (shieldMsgManger == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("ChatSettingActivity.nearby", 2, sb5.toString());
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatSettingActivity.nearby", 2, "initStrangerView, curType=" + this.J + ", mShieldUin=" + this.f175329b1 + ", mIsShield=" + this.Y0 + ", mShieldEnable=" + this.f175327a1);
        }
        if (Ck(this.J)) {
            this.K0.g(0);
        } else {
            this.K0.g(8);
        }
        Mm();
        this.f175341h1 = true;
        Tl();
        String[] strArr = {this.K};
        if (this.C == null) {
            pk();
        }
        int i27 = this.J;
        if (i27 != 1010 && i27 != 10004 && (i27 != 1022 || ((i16 = this.f175345j1) != 3007 && i16 != 2007 && i16 != 4007 && i16 != 3019 && i16 != 2019))) {
            FriendListHandler friendListHandler = this.C;
            if (friendListHandler != null) {
                friendListHandler.getStrangerRichStatus(strArr, false);
            }
        } else {
            FriendListHandler friendListHandler2 = this.C;
            if (friendListHandler2 != null) {
                friendListHandler2.getStrangerRichStatus(strArr, true);
            }
        }
        int i28 = this.J;
        if (i28 == 1044 || i28 == 1045 || i28 == 10008) {
            this.F0.R(8);
        }
        if (this.J == 10019) {
            this.H0.g(8);
            this.F0.R(8);
            this.B0.h0(8);
            this.C0.h0(0);
            this.L0.j(getString(R.string.f207095_3));
            this.L0.g(0);
        }
        if (this.J == 10008) {
            this.H0.g(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ul(String str, DialogInterface dialogInterface, int i3) {
        Bm(str, false);
    }

    private void um() {
        IConfigProxy iConfigProxy = VasLongToggle.VAS_BGSHOP_KRCONFIG;
        if (iConfigProxy.isEnable(false)) {
            String stringData = iConfigProxy.getStringData("");
            if (!TextUtils.isEmpty(stringData)) {
                HashMap hashMap = new HashMap();
                hashMap.put("frienduin", this.K);
                hashMap.put("uintype", String.valueOf(this.J));
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openKuiklySchema(getContext(), stringData, hashMap);
                return;
            }
        }
        Intent intent = new Intent();
        intent.putExtra(VasWebviewConstants.KEY_VAS_USE_PREWEBVIEW, true);
        intent.putExtra("chatbg_intent_frinedUin", this.K);
        intent.putExtra("uintype", this.J);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("bg_replace_entrance", 62);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
        intent.putExtra("show_right_close_button", false);
        intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_AIO_BACKGROUND_SETTING);
        VasWebviewUtil.openQQBrowserWithoutAD(getContext(), VasWebviewUtil.addEntryParamToUrl(IndividuationUrlHelper.getMarketUrl(getContext(), "background", ""), 46), 33554432L, intent, true, 1);
    }

    private void vk() {
        TextView textView;
        if (!AppSetting.t(getContext())) {
            return;
        }
        try {
            this.f211171vg = (NavBarCommon) this.titleRoot.findViewById(R.id.rlCommenTitle);
            onCreateLeftView();
            Bundle arguments = getArguments();
            if (arguments == null) {
                return;
            }
            if (arguments.getBoolean("hide_title_left_arrow", false) && (textView = this.leftView) != null) {
                textView.setBackgroundDrawable(null);
            }
            onCreateCenterView();
            onCreateRightView();
            setLeftViewName(arguments);
            this.f211171vg.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatSettingFragment.hl(view);
                }
            });
        } catch (Exception e16) {
            QLog.d("ChatSettingFragment", 1, e16.getMessage(), e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vl(DialogInterface dialogInterface, int i3) {
        Bj(false);
    }

    private void vm() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            return;
        }
        ((IChatHistoryApi) QRoute.api(IChatHistoryApi.class)).jumpChatHistoryActivity(qBaseActivity, new com.tencent.qqnt.chathistory.api.a(1, this.L, this.M, 0));
    }

    private void wk() {
        this.f175336f0 = getResources().getDisplayMetrics().density;
        int i3 = this.J;
        if (i3 != 0) {
            if (i3 != 1 && i3 != 2 && i3 != 3000) {
                uk();
            }
        } else {
            ok();
        }
        setTitle(getResources().getString(R.string.a1l));
        setLeftViewName(R.string.f170549u3);
        if (this.titleRoot != null && !AppSetting.t(getContext())) {
            this.titleRoot.setFitsSystemWindows(false);
            this.titleRoot.setPadding(0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wl(String str, int i3, DialogInterface dialogInterface, int i16) {
        Ml(str, i3);
    }

    private void wm() {
        AllInOne allInOne = new AllInOne(this.K, 1);
        allInOne.nickname = com.tencent.mobileqq.utils.ac.B(this.E, this.K);
        int i3 = this.J;
        if (3000 != i3) {
            allInOne.preWinUin = this.K;
            allInOne.preWinType = i3;
        }
        allInOne.lastActivity = 5;
        allInOne.profileEntryType = 61;
        allInOne.reportExtra = NewReportPlugin.G(this.K, i3);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 2);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 22);
        if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", allInOne.reportExtra));
        }
        ProfileUtils.openProfileCardForResult(getQBaseActivity(), allInOne, 3);
    }

    private boolean xk() {
        return false;
    }

    private void xm() {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            notifyUser(R.string.b3j, 1);
            this.f175348l0.a0(this.T0);
        } else if (this.J == 0) {
            NTFriendSettingHelper.f352067a.N(new NTFriendSettingHelper.a(this.E, this.K, this.L, !this.T0, 0));
        }
    }

    private boolean yk() {
        if (this.T && this.E != null && !((IRobotTempApi) QRoute.api(IRobotTempApi.class)).hasSetCustomChatBackground(getContext(), this.E.getCurrentUin(), this.K)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yl(String str, int i3, String str2) {
        QLog.d("ChatSettingFragment", 1, "removeFriend robotUin=" + str + " result=" + i3);
        if (i3 == 0) {
            notifyUser(R.string.f223026f4, 2);
            Il(str);
            com.tencent.mobileqq.tts.data.g.h().f(str);
            QLog.i("ChatSettingFragment", 1, "remove robot ttsuin=" + str);
            return;
        }
        notifyUser(R.string.f222976ez, 1);
    }

    private void ym() {
        Serializable serializable;
        int i3;
        AllInOne allInOne = new AllInOne(this.K, 46);
        allInOne.f260789pa = 19;
        String F = com.tencent.mobileqq.utils.ac.F(this.E, this.K);
        allInOne.nickname = F;
        if (TextUtils.isEmpty(F) || allInOne.nickname.equals(this.K)) {
            allInOne.nickname = this.M;
        }
        allInOne.preWinUin = this.K;
        int i16 = this.J;
        allInOne.preWinType = i16;
        allInOne.uid = this.L;
        allInOne.lastActivity = 5;
        allInOne.profileEntryType = 61;
        if (i16 != 1000) {
            if (i16 != 1001) {
                if (i16 != 1009) {
                    if (i16 != 1010) {
                        if (i16 != 1044 && i16 != 1045) {
                            if (i16 != 4000) {
                                if (i16 != 10002) {
                                    if (i16 != 10008) {
                                        if (i16 != 10010) {
                                            switch (i16) {
                                                case 1003:
                                                    allInOne.f260789pa = 70;
                                                    break;
                                                case 1004:
                                                    allInOne.f260789pa = 47;
                                                    allInOne.discussUin = this.f175333d1;
                                                    break;
                                                case 1005:
                                                    allInOne.f260789pa = 2;
                                                    break;
                                                case 1006:
                                                    break;
                                                default:
                                                    switch (i16) {
                                                        case 1020:
                                                            allInOne.f260789pa = 58;
                                                            break;
                                                        case 1021:
                                                            allInOne.f260789pa = 72;
                                                            break;
                                                        case 1022:
                                                            allInOne.f260789pa = 27;
                                                            break;
                                                        case 1023:
                                                            allInOne.f260789pa = 74;
                                                            break;
                                                    }
                                            }
                                        } else {
                                            allInOne.f260789pa = 117;
                                        }
                                    } else {
                                        allInOne.f260789pa = 115;
                                    }
                                } else {
                                    allInOne.f260789pa = 86;
                                }
                            }
                            allInOne.f260789pa = 34;
                        } else {
                            allInOne.f260789pa = 96;
                        }
                    } else {
                        allInOne.f260789pa = 76;
                    }
                } else {
                    allInOne.f260789pa = 57;
                }
            } else {
                allInOne.f260789pa = 42;
            }
        } else {
            allInOne.f260789pa = 22;
            String str = this.f175333d1;
            allInOne.troopUin = str;
            allInOne.troopCode = str;
        }
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.K), "ChatSettingFragment")) {
            allInOne.f260789pa = 1;
        }
        Bundle G = NewReportPlugin.G(this.K, this.J);
        allInOne.reportExtra = G;
        QLog.i("NewReportPlugin", 2, String.format("start-profile: %s pa: %s", G, Integer.valueOf(allInOne.f260789pa)));
        int i17 = this.J;
        if (i17 != 10004 && i17 != 1010 && (i17 != 1022 || ((i3 = this.f175345j1) != 3007 && i3 != 2007 && i3 != 4007 && i3 != 3019 && i3 != 2019))) {
            if (i17 != 1044 && i17 != 1045) {
                if (i17 == 1046) {
                    ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterProfileCard(this.E, getContext(), Long.parseLong(this.K), this.f175326a0, 3);
                    com.tencent.mobileqq.matchfriend.utils.d dVar = this.f175330c0;
                    if (dVar != null) {
                        dVar.d("em_aio_profile");
                        return;
                    }
                    return;
                }
                if (this.D.containsKey(IProfileCardConst.KEY_WZRY_DATA) && (serializable = this.D.getSerializable(IProfileCardConst.KEY_WZRY_DATA)) != null) {
                    allInOne.extras.putSerializable(IProfileCardConst.KEY_WZRY_DATA, serializable);
                }
                ProfileUtils.openProfileCardForResult(getQBaseActivity(), allInOne, 3);
                return;
            }
            ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).startExtendFriendCardOnClickAvatar(getContext(), this.K, 22);
            return;
        }
        Intent intent = new Intent();
        int i18 = this.J;
        if (i18 == 10002) {
            intent.putExtra("frome_where", 22);
        } else if (i18 == 1010) {
            allInOne.profileEntryType = 13;
        } else {
            allInOne.profileEntryType = 30;
        }
        intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
        if (Utils.p(this.K, this.E.getCurrentAccountUin())) {
            intent.putExtra("param_mode", 2);
        } else {
            intent.putExtra("param_mode", 3);
        }
        RouteUtils.startActivityForResult(getContext(), intent, "/nearby/people/profile", 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zk() {
        if (TextUtils.isEmpty(this.E.getAccount())) {
            QLog.e("ChatSettingFragment", 1, "isNeedShowFilterMsgView() called, getAccount() is null");
            return false;
        }
        ITempMsgBoxManager iTempMsgBoxManager = (ITempMsgBoxManager) this.E.getRuntimeService(ITempMsgBoxManager.class, "");
        if (iTempMsgBoxManager != null && iTempMsgBoxManager.isBelongToFilterBox(this.K, 0)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zl(MutualMarkIconsView mutualMarkIconsView) {
        mutualMarkIconsView.j(this.E, this.K, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zm() {
        long j3;
        String str;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            notifyUser(R.string.b3j, 1);
            this.C0.a0(this.Y0);
            return;
        }
        if (this.J == 1046) {
            ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).setUserShield(this.E, Long.parseLong(this.K), !this.Y0);
            if (this.f175330c0 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("kl_new_switch_status", Integer.valueOf(1 ^ (this.Y0 ? 1 : 0)));
                this.f175330c0.e("em_kl_new_chat_page_block_btn", hashMap);
                return;
            }
            return;
        }
        ShieldMsgManger shieldMsgManger = (ShieldMsgManger) this.E.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
        int i3 = 2;
        if (shieldMsgManger != null) {
            try {
                j3 = Long.parseLong(this.f175329b1);
            } catch (Exception unused) {
                j3 = 0;
            }
            String str2 = "";
            if (j3 > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(j3));
                if (QLog.isColorLevel()) {
                    QLog.d("ChatSettingActivity.nearby", 2, "startStangerShield, tuin=" + j3 + ", mIsShield=" + this.Y0 + ", mIsFollowed=" + this.W);
                }
                if (this.Y0) {
                    shieldMsgManger.m(this.J, arrayList);
                } else {
                    if (this.W) {
                        if (ChatActivityUtils.f175163c.size() > 5) {
                            ChatActivityUtils.f175163c.poll();
                        }
                        ChatActivityUtils.f175163c.offer(j3 + "");
                    }
                    shieldMsgManger.k(this.J, arrayList);
                }
                this.f175331c1 = true;
            } else {
                rm(1, HardCodeUtil.qqStr(R.string.khm));
            }
            QQAppInterface qQAppInterface = this.E;
            boolean z16 = this.Y0;
            if (z16) {
                str = "cancel_aio";
            } else {
                str = "block_aio";
            }
            String str3 = str;
            if (!z16) {
                if (this.W) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
            }
            ReportController.o(qQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", str3, 0, 0, "1", "1", str2, "");
        }
        if (this.J == 1003) {
            if (this.Y0) {
                String str4 = this.K;
                if (str4 != null && str4.length() > 0) {
                    this.E.getMsgHandler().S2(this.K);
                    this.f175331c1 = true;
                }
            } else {
                String str5 = this.K;
                if (str5 != null && str5.length() > 0) {
                    this.E.getMsgHandler().o4(this.K);
                    this.f175331c1 = true;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ChatSettingActivity.nearby", 2, "startStangerShield, mCurUin=" + this.K + ", mIsShield=" + this.Y0 + ", mShieldByThis=" + this.f175331c1);
            }
        }
        if (this.J == 10007) {
            if (this.Y0) {
                i3 = 4;
            }
            ((IGameMsgUnissoHandlerApi) QRoute.api(IGameMsgUnissoHandlerApi.class)).addOrShieldFriend(this.S, i3, this.P, this.Q, "");
        }
        if (this.J == 1010) {
            if (this.Y0) {
                ReportController.o(this.E, "CliOper", "", this.f175329b1, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
            } else {
                ReportController.o(this.E, "CliOper", "", this.f175329b1, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
            }
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.d
    public Dialog B1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Dialog) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.f175351m1;
    }

    public void Ll(BaseQQAppInterface baseQQAppInterface, Context context, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, baseQQAppInterface, context, Integer.valueOf(i3), str);
        } else {
            ((IAioColdPalaceHelper) QRoute.api(IAioColdPalaceHelper.class)).doOnBanishColdPalaceClick(baseQQAppInterface, context, i3, str, this);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.d
    public void Se(Dialog dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) dialog);
        } else {
            this.f175351m1 = dialog;
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.d
    public void de() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            ((IAioColdPalaceHelper) QRoute.api(IAioColdPalaceHelper.class)).doOnColdPalaceLimitConfirm(this.E, getQBaseActivity(), this.J, this.K, this);
        }
    }

    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        boolean z16 = true;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101658", true)) {
            if (!AppSetting.t(this.F) || !(this.F instanceof SplashActivity)) {
                z16 = false;
            }
        } else {
            z16 = AppSetting.t(this.F);
        }
        if (z16) {
            QBaseActivity qBaseActivity = getQBaseActivity();
            if (qBaseActivity != null) {
                com.tencent.mobileqq.pad.m.e(qBaseActivity);
                return;
            }
            return;
        }
        this.F.finish();
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.d
    public int from() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneStatusTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.J == 0) {
            return R.layout.fdz;
        }
        return R.layout.ffm;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneStatusTitleBarFragment
    protected int getTitleLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.e4y;
    }

    void hm() {
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar;
        int i3;
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar2 = this.f175352n0;
        int i16 = 0;
        if (bVar2 != null && this.f175354o0 != null && this.f175348l0 != null) {
            com.tencent.mobileqq.activity.newsetting.custom.config.b bVar3 = this.f175356p0;
            if (!bVar2.W() && !this.f175354o0.W() && !this.f175348l0.W()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            bVar3.h0(i3);
        }
        g.b bVar4 = this.f175362s0;
        if (bVar4 != null && (bVar = this.f175352n0) != null) {
            if (bVar.W()) {
                i16 = 8;
            }
            bVar4.h0(i16);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.chat.d
    public void i5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            ((IAioColdPalaceHelper) QRoute.api(IAioColdPalaceHelper.class)).doOnColdPalaceLimitCancel(this);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneStatusTitleBarFragment
    protected void initTitle(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        View findViewById = this.titleRoot.findViewById(R.id.rlCommenTitle);
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
        findViewById.getLayoutParams().height += statusBarHeight;
        findViewById.setPadding(findViewById.getPaddingLeft(), statusBarHeight, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
    }

    public void om() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (this.P1 == null) {
            this.P1 = LBSHandler.N2(getContext(), getString(R.string.cgk), new q(), new r());
        }
        Dialog dialog = this.P1;
        if (dialog != null && !dialog.isShowing()) {
            this.P1.show();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        this.f175334e0 = false;
        if (-1 == i16) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 5) {
                                if (i3 == 1003) {
                                    Nl(intent);
                                    return;
                                }
                                return;
                            }
                            finish();
                            return;
                        }
                        if (intent != null) {
                            this.W = intent.getBooleanExtra(AppConstants.Key.FOLLOW_FLAG, false);
                            Rl();
                            return;
                        }
                        return;
                    }
                    int intExtra = intent.getIntExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, -1);
                    if (intExtra != 0) {
                        if (intExtra == 1) {
                            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(getContext()), null);
                            String stringExtra = intent.getStringExtra("roomId");
                            m3.putExtra("uin", stringExtra);
                            m3.putExtra("uintype", 3000);
                            m3.putExtra("uinname", com.tencent.mobileqq.utils.ac.p(this.E, getQBaseActivity().getApplicationContext(), stringExtra));
                            m3.putExtra("isBack2Root", true);
                            startActivity(m3);
                            finish();
                            return;
                        }
                        return;
                    }
                    ReportController.o(this.E, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
                    TroopUtils.e(getContext(), intent.getStringExtra("roomId"), true);
                    return;
                }
                tm();
                finish();
                return;
            }
            Ol(intent);
            return;
        }
        if (i16 == 0 && 3 == i3 && intent != null && intent.getBooleanExtra("finchat", false)) {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneStatusTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (!(activity instanceof SplashActivity)) {
            finish();
            return true;
        }
        SplashActivity splashActivity = (SplashActivity) activity;
        if (splashActivity.getqFragmentStackManager() == null) {
            return false;
        }
        splashActivity.getqFragmentStackManager().p();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.C7175a c7175a;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else if (!Dk(this.f175344j0, view) && !Fk(this.W0, view)) {
            if (Ek(this.f175346k0, view)) {
                vm();
                ReportController.o(this.E, "dc00898", "", "", "0X800A0AC", "0X800A0AC", 0, 0, "", "", "", "");
                ReportController.o(this.E, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "0", "", "", "");
                Wl("0X800C02F");
            } else if (Ek(this.f175364t0, view)) {
                um();
                ReportController.o(this.E, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
                Wl("0X800C036");
            } else if (Ek(this.B0, view)) {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 0, (String) null, HardCodeUtil.qqStr(R.string.ypg), R.string.cancel, R.string.f171151ok, new s(view), new t());
                com.tencent.mobileqq.simpleui.c.j(createCustomDialog, 1000);
                createCustomDialog.show();
            } else if (Ek(this.f175368v0, view)) {
                Xj();
            } else {
                f.b bVar = this.f175342i0;
                if (bVar != null && (Fk(bVar.T(), view) || Fk(this.f175342i0.S(), view) || Fk(this.f175342i0.U(), view))) {
                    wm();
                    Wl("0X800C02D");
                } else {
                    f.b bVar2 = this.f175342i0;
                    if (bVar2 != null && Fk(bVar2.X(), view)) {
                        ff.j.b.c(this.E, this.K, "VIA_AIO_CHATSETTINGS").onTouch(view, null);
                    } else {
                        a.C7175a c7175a2 = this.f175370w0;
                        if (c7175a2 != null && Fk(c7175a2.T(), view)) {
                            Wl("0X800C038");
                            lm(this.K);
                        } else if (Ek(this.f175362s0, view)) {
                            SharedPreferences sharedPreferences = this.E.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
                            sharedPreferences.edit().putBoolean(AppConstants.Preferences.SPECIAL_CARE_CHAT_SETTING, false).commit();
                            if (sharedPreferences.getBoolean(AppConstants.Preferences.SPECIAL_CARE_RED_POINT_ONE, false)) {
                                sharedPreferences.edit().putBoolean(AppConstants.Preferences.SPECIAL_CARE_RED_POINT_ONE, false).commit();
                            }
                            this.f175362s0.l0(null, null);
                            com.tencent.mobileqq.activity.specialcare.h.b(getQBaseActivity(), this.K, this.L, 2);
                            Xl("0X800C035", !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getSpecialCareGlobalSwitch(this.L, "ChatSettingFragment") ? "2" : "1");
                            ReportController.o(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "0", "", "", "");
                            com.tencent.qqnt.notification.report.h.x(ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, "em_bas_best_friend_care", null, this.f175340h0);
                        } else if (Ek(this.f175356p0, view)) {
                            Intent intent = new Intent();
                            intent.putExtra("uin", this.K);
                            intent.putExtra("uintype", this.J);
                            MessageNotificationSettingFragment.hi(getQBaseActivity(), intent);
                            Wl("0X800C033");
                            com.tencent.qqnt.notification.report.h.x(ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, "em_bas_friend_message_notification_settings", null, this.f175340h0);
                        } else if (Ek(this.f175358q0, view)) {
                            ((IRobotTimbreSettingApi) QRoute.api(IRobotTimbreSettingApi.class)).startRobotTimbreSetting(requireContext(), this.K, this.L, 0L);
                        } else {
                            ViewGroup viewGroup = this.N0;
                            if (view == viewGroup) {
                                GetRoamToastRsp getRoamToastRsp = (GetRoamToastRsp) viewGroup.getTag();
                                if (getRoamToastRsp != null) {
                                    ReportController.o(this.E, "dc00898", "", "", "0X8009E32", "0X8009E32", 0, 0, "", "", "", "");
                                    Intent intent2 = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
                                    intent2.putExtra("url", getRoamToastRsp.sUrl);
                                    intent2.putExtra("isShowAd", false);
                                    startActivity(intent2);
                                }
                            } else if (view == this.M0) {
                                GetRoamToastRsp getRoamToastRsp2 = (GetRoamToastRsp) viewGroup.getTag();
                                if (getRoamToastRsp2 != null) {
                                    ReportController.o(this.E, "dc00898", "", "", "0X8009E77", "0X8009E77", 0, 0, "", "", "", "");
                                    ((ISVIPHandler) this.E.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).closeToast(getRoamToastRsp2);
                                }
                                this.N0.setVisibility(8);
                            } else {
                                a.C7175a c7175a3 = this.f175370w0;
                                if (c7175a3 != null && Fk(c7175a3.S(), view)) {
                                    if (this.J == 10008) {
                                        ReportController.o(this.E, "dc00898", "", "", "0X800ADC7", "0X800ADC7", 0, 0, "", "", "", "");
                                    }
                                    O3ReportUtil.j(getQBaseActivity(), this.J, this.K, this.E.getCurrentAccountUin());
                                    Wl("0X800C039");
                                } else if (!Dk(this.F0, view) && !Bk(view)) {
                                    if (Fk(this.H0, view)) {
                                        int i3 = this.J;
                                        if (1036 == i3 && this.Y0) {
                                            mm();
                                        } else if (1044 == i3 || 1045 == i3) {
                                            String valueOf = String.valueOf(this.D.getInt("subId", 0));
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("frompage", valueOf);
                                            hashMap.put("to_uid", this.K);
                                            hashMap.put(ServiceConst.PARA_SESSION_ID, ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).getSessionId(this.E.getCurrentAccountUin(), this.K));
                                            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_setting_page#add_friends_all", true, -1L, -1L, hashMap, true, true);
                                            sm();
                                        } else if (i3 == 1046) {
                                            ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).getCanAddFriend(this.E, this.Y);
                                            com.tencent.mobileqq.matchfriend.utils.d dVar = this.f175330c0;
                                            if (dVar != null) {
                                                dVar.d("em_kl_new_friends_btn");
                                            }
                                        } else {
                                            sm();
                                            ReportController.o(this.E, "CliOper", "", "", "0X80040F2", "0X80040F2", 0, 0, "", "", "", "");
                                        }
                                    } else if (Fk(this.I0, view)) {
                                        lm(this.K);
                                    } else if (Fk(this.K0, view)) {
                                        ReportController.o(this.E, "CliOper", "", "", "0X80040F3", "0X80040F3", 0, 0, "", "", "", "");
                                        if (Ck(this.J)) {
                                            int i16 = this.J;
                                            if (i16 == 10007) {
                                                Pair<String, String> e16 = ((IMessageFacade) this.E.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().e(this.K);
                                                if (e16 != null) {
                                                    Bundle bundle = new Bundle();
                                                    bundle.putString("chatuin", this.K);
                                                    bundle.putInt("chattype", 10007);
                                                    NTJuBaoUtil.b(null, (String) e16.first, this.K, 25095, bundle, new u());
                                                    if (QLog.isColorLevel()) {
                                                        QLog.i("tinyPairForGame", 2, "from=" + ((String) e16.first) + ", to=" + ((String) e16.second));
                                                    }
                                                }
                                            } else if (i16 == 1046) {
                                                if (com.tencent.biz.webviewplugin.ad.f97536a.a()) {
                                                    ((IMatchFriendJubaoApi) QRoute.api(IMatchFriendJubaoApi.class)).jumpMatchFriendJuBao(this.E, getActivity(), "10133", this.K, this.M);
                                                } else {
                                                    ((IMatchFriendJubaoApi) QRoute.api(IMatchFriendJubaoApi.class)).startMatchFriendJubaoByScene(this.E, getContext(), IMatchFriendJubaoApi.From.AIO, this.K, null, null);
                                                }
                                                com.tencent.mobileqq.matchfriend.utils.d dVar2 = this.f175330c0;
                                                if (dVar2 != null) {
                                                    dVar2.d("em_kl_new_report_btn");
                                                }
                                            } else {
                                                if (i16 == 1001) {
                                                    try {
                                                        ((INearbyReportHelper) QRoute.api(INearbyReportHelper.class)).reportNearbyJubao(Long.parseLong(this.K), 2);
                                                    } catch (Throwable unused) {
                                                        QLog.e("reportNearbyJubao", 2, "parseFailed");
                                                    }
                                                }
                                                QBaseActivity qBaseActivity = getQBaseActivity();
                                                int i17 = this.J;
                                                String str = this.K;
                                                String currentAccountUin = this.E.getCurrentAccountUin();
                                                String str2 = this.f175338g0;
                                                O3ReportUtil.k(qBaseActivity, i17, str, currentAccountUin, str2 != null ? str2 : "");
                                            }
                                        }
                                        int i18 = this.J;
                                        if (i18 == 1044 || i18 == 1045) {
                                            HashMap hashMap2 = new HashMap();
                                            hashMap2.put("to_uid", this.K);
                                            hashMap2.put("frompage", String.valueOf(from()));
                                            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#complaint_page#complaint", true, -1L, -1L, hashMap2, true, true);
                                        }
                                    } else if (!Fk(this.J0, view) && ((c7175a = this.f175370w0) == null || !Fk(c7175a.U(), view))) {
                                        if (Ek(this.E0, view)) {
                                            Ll(this.E, getContext(), this.J, this.K);
                                        } else if (Ek(this.f175360r0, view)) {
                                            qm(this.L, com.tencent.nt.adapter.session.c.l(this.J));
                                        }
                                    } else {
                                        nm();
                                    }
                                } else {
                                    ym();
                                }
                            }
                        }
                    }
                }
            }
        } else {
            Gj();
            ReportController.o(this.E, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, "", "", "", "");
            ReportController.o(this.E, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_clk", 0, 0, "", "", "", "");
            Wl("0X800C02E");
            Vl("em_group_start_new_chat");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        QBaseActivity qBaseActivity = getQBaseActivity();
        this.F = qBaseActivity;
        this.E = (QQAppInterface) qBaseActivity.getAppRuntime();
        this.D = getArguments();
        pk();
        Aj();
        Fl();
        mk();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.tencent.qqnt.kernel.api.ac robotService;
        com.tencent.mobileqq.matchfriend.utils.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDestroy();
        this.f175347k1 = true;
        MqqHandler mqqHandler = this.Q1;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
        }
        try {
            QQProgressDialog qQProgressDialog = this.H;
            if (qQProgressDialog != null && qQProgressDialog.isShowing() && !getQBaseActivity().isFinishing()) {
                this.H.dismiss();
                this.H = null;
            }
            Dialog dialog = this.P1;
            if (dialog != null && dialog.isShowing()) {
                this.P1.dismiss();
                this.P1 = null;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        Ul();
        this.f175341h1 = false;
        QQCustomDialog qQCustomDialog = this.f175353n1;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f175353n1.dismiss();
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.W1);
        com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.e eVar = this.f175372x0;
        if (eVar != null) {
            eVar.k();
            this.f175372x0 = null;
        }
        if (this.f175343i1 && (dVar = this.f175330c0) != null) {
            dVar.j(Uj());
        }
        if (this.T && (robotService = ((IKernelService) this.E.getRuntimeService(IKernelService.class)).getRobotService()) != null) {
            robotService.removeKernelRobotListener(this.F1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroyView();
            cm();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.f175334e0 = true;
        Jl();
        ApngImage.pauseAll();
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        MqqHandler mqqHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f175334e0 = false;
        MqqHandler mqqHandler2 = this.Q1;
        if (mqqHandler2 != null) {
            if (this.f175341h1) {
                mqqHandler2.removeMessages(32);
                this.Q1.sendEmptyMessageDelayed(32, 200L);
            }
            if (this.J == 0) {
                this.Q1.removeMessages(33);
                this.Q1.sendEmptyMessageDelayed(33, 200L);
            }
        }
        super.onResume();
        ApngImage.playByTag(27);
        Nm();
        if (this.J == 0 && (mqqHandler = this.Q1) != null && !mqqHandler.hasMessages(34)) {
            this.Q1.sendEmptyMessageDelayed(34, com.tencent.mobileqq.mutualmark.oldlogic.a.h() * 1000);
        }
        ViewGroup viewGroup = this.N0;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            ((ISVIPHandler) this.E.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getRoamToast();
        }
        fm();
        vk();
        Mm();
        if (this.T) {
            Pl();
        }
        if (this.f175359q1) {
            jm();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onStart();
        if (this.G) {
            doOnRestart();
        }
        if (this.J == 0 && this.f175346k0 != null) {
            ((com.tencent.mobileqq.apollo.handler.b) this.E.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).j2(new String[]{this.E.getCurrentAccountUin()}, new int[]{42255});
        }
        this.G = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        wk();
        rk();
        Ql();
        ReportController.o(this.E, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_exp", 0, 0, "", "", "", "");
        Wl("0X800C02C");
        bm();
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            QLog.d("ChatSettingFragment", 1, "qOnNewIntent");
        }
    }

    private void doOnRestart() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Lk(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void xl(DialogInterface dialogInterface, int i3) {
    }
}
