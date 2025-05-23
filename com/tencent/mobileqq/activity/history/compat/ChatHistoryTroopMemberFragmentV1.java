package com.tencent.mobileqq.activity.history.compat;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troop.ITroopMemberOperationRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.PinnedDividerSwipListView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import tencent.im.oidb.cmd0x406.cmd0x406$GroupFeeMember;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f$Range;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f$ReqBody;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f$RspBody;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a$UserInfo;

/* compiled from: P */
@Deprecated
/* loaded from: classes33.dex */
public class ChatHistoryTroopMemberFragmentV1 extends QBaseFragment implements AdapterView.OnItemClickListener, IndexView.b, IndexView.a, Handler.Callback, IHistoryBridgeInterface {

    /* renamed from: d2, reason: collision with root package name */
    protected static double f182558d2 = 10.0d;

    /* renamed from: e2, reason: collision with root package name */
    private static int f182559e2 = 1000;
    protected DiscussionHandler A0;
    protected PinnedDividerSwipListView C;
    private View C0;
    private boolean D0;
    protected QQAppInterface E1;
    protected View F1;
    private IHistoryBridgeInterface.b G1;
    protected boolean J;
    protected boolean K;
    protected boolean L;
    protected String N0;
    public Dialog O1;
    protected String P0;
    protected String Q0;
    protected Dialog V;
    protected View W;
    private boolean W0;
    protected TextView X;
    protected ImageView Y;
    protected ImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    protected TextView f182560a0;

    /* renamed from: b0, reason: collision with root package name */
    protected TextView f182563b0;

    /* renamed from: c0, reason: collision with root package name */
    protected LinearLayout f182566c0;

    /* renamed from: d0, reason: collision with root package name */
    protected TextView f182569d0;

    /* renamed from: e0, reason: collision with root package name */
    protected LinearLayout f182571e0;

    /* renamed from: f0, reason: collision with root package name */
    protected QUISearchBar f182573f0;

    /* renamed from: g0, reason: collision with root package name */
    protected EditText f182575g0;

    /* renamed from: h0, reason: collision with root package name */
    protected RelativeLayout f182577h0;

    /* renamed from: i0, reason: collision with root package name */
    protected View f182579i0;

    /* renamed from: j0, reason: collision with root package name */
    protected RelativeLayout f182581j0;

    /* renamed from: j1, reason: collision with root package name */
    protected RelativeLayout f182582j1;

    /* renamed from: k0, reason: collision with root package name */
    protected XListView f182583k0;

    /* renamed from: k1, reason: collision with root package name */
    protected RelativeLayout f182584k1;

    /* renamed from: l1, reason: collision with root package name */
    protected ProgressBar f182586l1;

    /* renamed from: m0, reason: collision with root package name */
    protected y f182587m0;

    /* renamed from: m1, reason: collision with root package name */
    protected TextView f182588m1;

    /* renamed from: n0, reason: collision with root package name */
    protected View f182589n0;

    /* renamed from: o0, reason: collision with root package name */
    protected IndexView f182591o0;

    /* renamed from: o1, reason: collision with root package name */
    private String[] f182592o1;

    /* renamed from: p0, reason: collision with root package name */
    protected Drawable f182593p0;

    /* renamed from: p1, reason: collision with root package name */
    private String[] f182594p1;

    /* renamed from: q0, reason: collision with root package name */
    protected String f182595q0;

    /* renamed from: r0, reason: collision with root package name */
    public TroopInfo f182597r0;

    /* renamed from: r1, reason: collision with root package name */
    private long[] f182598r1;

    /* renamed from: s1, reason: collision with root package name */
    private long[] f182600s1;

    /* renamed from: t0, reason: collision with root package name */
    protected DiscussionInfo f182601t0;

    /* renamed from: t1, reason: collision with root package name */
    private long[] f182602t1;

    /* renamed from: u0, reason: collision with root package name */
    protected LayoutInflater f182603u0;

    /* renamed from: v0, reason: collision with root package name */
    protected ActionSheet f182605v0;

    /* renamed from: w0, reason: collision with root package name */
    protected View f182607w0;

    /* renamed from: x1, reason: collision with root package name */
    public int f182610x1;

    /* renamed from: z0, reason: collision with root package name */
    protected List<DiscussionMemberInfo> f182613z0;
    protected boolean D = false;
    boolean E = false;
    public String F = "";
    protected String G = "";
    protected String H = "";
    protected String I = "";
    protected String M = "";
    protected String N = "";
    protected boolean P = false;
    protected int Q = 0;
    protected int R = 0;
    protected float S = 1.5f;
    public List<w> T = new ArrayList();
    protected ListAdapter U = null;

    /* renamed from: l0, reason: collision with root package name */
    protected List<w> f182585l0 = new ArrayList();

    /* renamed from: s0, reason: collision with root package name */
    protected TroopInfoData f182599s0 = new TroopInfoData();

    /* renamed from: x0, reason: collision with root package name */
    protected boolean f182609x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    protected boolean f182611y0 = false;
    protected List<String> B0 = new ArrayList();
    protected List<String> E0 = new ArrayList();
    protected List<String> F0 = new ArrayList();
    protected ArrayList<String> G0 = new ArrayList<>();
    protected int H0 = 0;
    protected boolean I0 = false;
    public int J0 = 0;
    protected String K0 = null;
    protected int L0 = -1;
    protected String M0 = null;
    protected int O0 = Integer.MAX_VALUE;
    protected int R0 = 0;
    protected long S0 = 0;
    protected long T0 = 0;
    protected String U0 = "2";
    protected String V0 = "https://qun.qq.com/qunpay/gifts/rank_list.html?troopUin=%1$s&_wv=1031&_bid=2204";
    private boolean X0 = false;
    private boolean Y0 = false;
    public final String Z0 = TroopMemberListActivity.PARAM_SEQ_NAME;

    /* renamed from: a1, reason: collision with root package name */
    public final String f182561a1 = TroopMemberListActivity.PARAM_SEQ_DAYS;

    /* renamed from: b1, reason: collision with root package name */
    public final String f182564b1 = TroopMemberListActivity.PARAM_DELETED_UINS;

    /* renamed from: c1, reason: collision with root package name */
    private long f182567c1 = 0;

    /* renamed from: d1, reason: collision with root package name */
    private List<oidb_cmd0x74f$Range> f182570d1 = new ArrayList();

    /* renamed from: e1, reason: collision with root package name */
    private ArrayList<String> f182572e1 = new ArrayList<>();

    /* renamed from: f1, reason: collision with root package name */
    private ArrayList<String> f182574f1 = new ArrayList<>();

    /* renamed from: g1, reason: collision with root package name */
    private ArrayList<String> f182576g1 = new ArrayList<>();

    /* renamed from: h1, reason: collision with root package name */
    private ArrayList<String> f182578h1 = new ArrayList<>();

    /* renamed from: i1, reason: collision with root package name */
    private ArrayList<String> f182580i1 = new ArrayList<>();

    /* renamed from: n1, reason: collision with root package name */
    protected ArrayList<String> f182590n1 = new ArrayList<>();

    /* renamed from: q1, reason: collision with root package name */
    private DecimalFormat f182596q1 = new DecimalFormat("#.##");

    /* renamed from: u1, reason: collision with root package name */
    private boolean f182604u1 = true;

    /* renamed from: v1, reason: collision with root package name */
    private boolean f182606v1 = false;

    /* renamed from: w1, reason: collision with root package name */
    private String f182608w1 = HardCodeUtil.qqStr(R.string.kej);

    /* renamed from: y1, reason: collision with root package name */
    public int f182612y1 = 0;

    /* renamed from: z1, reason: collision with root package name */
    public int f182614z1 = 0;
    public int A1 = 0;
    public int B1 = 50;
    public boolean C1 = true;
    private boolean D1 = false;
    protected boolean H1 = false;
    protected String I1 = "";
    public View.OnClickListener J1 = new a();
    public View.OnClickListener K1 = new p();
    protected int L1 = 0;
    protected ActionSheet.OnButtonClickListener M1 = new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1.10

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1$10$a */
        /* loaded from: classes33.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
                chatHistoryTroopMemberFragmentV1.K = false;
                chatHistoryTroopMemberFragmentV1.Y.setVisibility(0);
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV12 = ChatHistoryTroopMemberFragmentV1.this;
                if (chatHistoryTroopMemberFragmentV12.J0 != 22) {
                    chatHistoryTroopMemberFragmentV12.Z.setVisibility(0);
                }
                ChatHistoryTroopMemberFragmentV1.this.X.setVisibility(8);
                ChatHistoryTroopMemberFragmentV1.this.f182569d0.setVisibility(8);
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV13 = ChatHistoryTroopMemberFragmentV1.this;
                chatHistoryTroopMemberFragmentV13.f182569d0 = (TextView) chatHistoryTroopMemberFragmentV13.findViewById(R.id.ivTitleBtnLeft);
                ChatHistoryTroopMemberFragmentV1.this.f182569d0.setVisibility(0);
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV14 = ChatHistoryTroopMemberFragmentV1.this;
                chatHistoryTroopMemberFragmentV14.f182569d0.setOnClickListener(chatHistoryTroopMemberFragmentV14.K1);
                ListAdapter listAdapter = ChatHistoryTroopMemberFragmentV1.this.U;
                if (listAdapter != null) {
                    listAdapter.k();
                }
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            int i16 = (ChatHistoryTroopMemberFragmentV1.this.W0 || i3 < 5) ? i3 : i3 + 1;
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
            if (chatHistoryTroopMemberFragmentV1.L) {
                if (i3 == 0) {
                    chatHistoryTroopMemberFragmentV1.P1.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ChatHistoryTroopMemberFragmentV1.this.Di();
                        }
                    }, 320L);
                } else if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "mOnActionSheetClickListener.OnClick, error : which = " + i3 + ", troopUin = " + ChatHistoryTroopMemberFragmentV1.this.G);
                }
            } else if (chatHistoryTroopMemberFragmentV1.J0 == 9) {
                if (i16 == 0) {
                    chatHistoryTroopMemberFragmentV1.J = true;
                    chatHistoryTroopMemberFragmentV1.V1 = "";
                    chatHistoryTroopMemberFragmentV1.X.setVisibility(0);
                    ChatHistoryTroopMemberFragmentV1.this.Y.setVisibility(8);
                    ChatHistoryTroopMemberFragmentV1.this.Z.setVisibility(8);
                    ListAdapter listAdapter = ChatHistoryTroopMemberFragmentV1.this.U;
                    if (listAdapter != null) {
                        listAdapter.k();
                    }
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV12 = ChatHistoryTroopMemberFragmentV1.this;
                    ReportController.o(chatHistoryTroopMemberFragmentV12.E1, "P_CliOper", "Grp_pay", "", "un_pay_list", "Clk_del", 0, 0, chatHistoryTroopMemberFragmentV12.G, chatHistoryTroopMemberFragmentV12.U0, "", "");
                }
            } else if (i16 == 0) {
                chatHistoryTroopMemberFragmentV1.jj();
            } else if (i16 != 1) {
                if (i16 == 2) {
                    chatHistoryTroopMemberFragmentV1.P1.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1.10.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ChatHistoryTroopMemberFragmentV1.this.Di();
                        }
                    }, 320L);
                } else if (i16 == 3) {
                    chatHistoryTroopMemberFragmentV1.K = true;
                    chatHistoryTroopMemberFragmentV1.X.setVisibility(0);
                    ChatHistoryTroopMemberFragmentV1.this.ej();
                    ChatHistoryTroopMemberFragmentV1.this.Y.setVisibility(8);
                    ChatHistoryTroopMemberFragmentV1.this.Z.setVisibility(8);
                    ChatHistoryTroopMemberFragmentV1.this.f182569d0.setVisibility(8);
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV13 = ChatHistoryTroopMemberFragmentV1.this;
                    chatHistoryTroopMemberFragmentV13.f182569d0 = (TextView) chatHistoryTroopMemberFragmentV13.findViewById(R.id.ivTitleBtnLeftButton);
                    ChatHistoryTroopMemberFragmentV1.this.f182569d0.setVisibility(0);
                    ChatHistoryTroopMemberFragmentV1.this.f182569d0.setText(HardCodeUtil.qqStr(R.string.j6l));
                    ChatHistoryTroopMemberFragmentV1.this.f182569d0.setOnClickListener(new a());
                    ListAdapter listAdapter2 = ChatHistoryTroopMemberFragmentV1.this.U;
                    if (listAdapter2 != null) {
                        listAdapter2.k();
                    }
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV14 = ChatHistoryTroopMemberFragmentV1.this;
                    chatHistoryTroopMemberFragmentV14.oi("Clk_del", chatHistoryTroopMemberFragmentV14.U0, "");
                }
            } else if (!TextUtils.isEmpty(chatHistoryTroopMemberFragmentV1.F)) {
                Intent intent = new Intent();
                intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 30);
                intent.putExtra("group_uin", ChatHistoryTroopMemberFragmentV1.this.G);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, ChatHistoryTroopMemberFragmentV1.this.F);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 30);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 4);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 30);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 30);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 3);
                ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(ChatHistoryTroopMemberFragmentV1.this.vi(), intent);
                ChatHistoryTroopMemberFragmentV1.this.vi().overridePendingTransition(R.anim.f154454a3, 0);
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV15 = ChatHistoryTroopMemberFragmentV1.this;
                ReportController.o(chatHistoryTroopMemberFragmentV15.E1, "dc00899", "Grp_mber", "", "mber_list", "clk_Add", 0, 0, chatHistoryTroopMemberFragmentV15.G, "", "", "");
            }
            ActionSheet actionSheet = ChatHistoryTroopMemberFragmentV1.this.f182605v0;
            if (actionSheet == null || !actionSheet.isShowing()) {
                return;
            }
            ChatHistoryTroopMemberFragmentV1.this.f182605v0.dismiss();
        }
    };
    private Handler N1 = new Handler(Looper.getMainLooper(), this);
    protected Handler P1 = new f(Looper.getMainLooper());
    public View.OnClickListener Q1 = new g();
    protected double R1 = 0.0d;
    private int S1 = -1;
    private long T1 = 0;
    private int U1 = 0;
    protected String V1 = "";
    protected String W1 = "";
    public View.OnClickListener X1 = new h();
    public ct2.b Y1 = new i();
    public com.tencent.mobileqq.troop.troopsetting.api.b Z1 = new j();

    /* renamed from: a2, reason: collision with root package name */
    public com.tencent.mobileqq.troop.observer.g f182562a2 = new k();

    /* renamed from: b2, reason: collision with root package name */
    public com.tencent.mobileqq.troop.observer.h f182565b2 = new com.tencent.mobileqq.troop.observer.h() { // from class: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1.22
        @Override // com.tencent.mobileqq.troop.observer.h
        protected void a(final boolean z16, final String str, final boolean z17, final String str2, final String str3, final boolean z18) {
            ChatHistoryTroopMemberFragmentV1.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1.22.1
                @Override // java.lang.Runnable
                public void run() {
                    ChatHistoryTroopMemberFragmentV1.this.oj(z16, str, z17, 0, 0, str2, str3, z18);
                }
            });
        }
    };

    /* renamed from: c2, reason: collision with root package name */
    public com.tencent.mobileqq.troop.onlinemember.api.b f182568c2 = new com.tencent.mobileqq.troop.onlinemember.api.b() { // from class: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1.23
        @Override // com.tencent.mobileqq.troop.onlinemember.api.b
        protected void c(boolean z16, String str, final List<String> list) {
            if (z16 && TextUtils.equals(str, ChatHistoryTroopMemberFragmentV1.this.G) && ChatHistoryTroopMemberFragmentV1.this.L1 == 1 && list != null) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ListAdapter listAdapter;
                        if (ChatHistoryTroopMemberFragmentV1.this.vi().isFinishing() || (listAdapter = ChatHistoryTroopMemberFragmentV1.this.U) == null) {
                            return;
                        }
                        listAdapter.I = list;
                        listAdapter.k();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.troop.onlinemember.api.b
        protected void d(boolean z16, String str, final List<oidb_0xa2a$UserInfo> list) {
            if (z16 && TextUtils.equals(str, ChatHistoryTroopMemberFragmentV1.this.G) && ChatHistoryTroopMemberFragmentV1.this.L1 == 8 && list != null) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1.23.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ListAdapter listAdapter;
                        if (ChatHistoryTroopMemberFragmentV1.this.vi().isFinishing() || (listAdapter = ChatHistoryTroopMemberFragmentV1.this.U) == null) {
                            return;
                        }
                        listAdapter.J = list;
                        listAdapter.k();
                    }
                });
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class SearchDialogDismissRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<ChatHistoryTroopMemberFragmentV1> f182632d;

        public SearchDialogDismissRunnable(ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1) {
            this.f182632d = new WeakReference<>(chatHistoryTroopMemberFragmentV1);
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentActivity vi5;
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = this.f182632d.get();
            if (chatHistoryTroopMemberFragmentV1 == null || (vi5 = chatHistoryTroopMemberFragmentV1.vi()) == null) {
                return;
            }
            chatHistoryTroopMemberFragmentV1.f182611y0 = false;
            int i3 = -chatHistoryTroopMemberFragmentV1.W.getHeight();
            chatHistoryTroopMemberFragmentV1.f182571e0.offsetTopAndBottom(i3);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i3, 0.0f);
            translateAnimation.setDuration(300L);
            chatHistoryTroopMemberFragmentV1.f182571e0.startAnimation(translateAnimation);
            ((InputMethodManager) vi5.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(vi5.getWindow().peekDecorView().getWindowToken(), 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements View.OnClickListener {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1$a$a, reason: collision with other inner class name */
        /* loaded from: classes33.dex */
        class ViewOnClickListenerC7167a implements View.OnClickListener {
            ViewOnClickListenerC7167a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
                chatHistoryTroopMemberFragmentV1.K = false;
                chatHistoryTroopMemberFragmentV1.X.setText(R.string.f170869aw3);
                ChatHistoryTroopMemberFragmentV1.this.X.setVisibility(0);
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV12 = ChatHistoryTroopMemberFragmentV1.this;
                chatHistoryTroopMemberFragmentV12.X.setOnClickListener(chatHistoryTroopMemberFragmentV12.J1);
                ChatHistoryTroopMemberFragmentV1.this.X.setEnabled(true);
                ChatHistoryTroopMemberFragmentV1.this.f182569d0.setVisibility(8);
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV13 = ChatHistoryTroopMemberFragmentV1.this;
                chatHistoryTroopMemberFragmentV13.f182569d0 = (TextView) chatHistoryTroopMemberFragmentV13.findViewById(R.id.ivTitleBtnLeft);
                ChatHistoryTroopMemberFragmentV1.this.f182569d0.setVisibility(0);
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV14 = ChatHistoryTroopMemberFragmentV1.this;
                chatHistoryTroopMemberFragmentV14.f182569d0.setOnClickListener(chatHistoryTroopMemberFragmentV14.K1);
                ListAdapter listAdapter = ChatHistoryTroopMemberFragmentV1.this.U;
                if (listAdapter != null) {
                    listAdapter.k();
                }
            }
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
            chatHistoryTroopMemberFragmentV1.K = true;
            chatHistoryTroopMemberFragmentV1.f182569d0.setVisibility(8);
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV12 = ChatHistoryTroopMemberFragmentV1.this;
            chatHistoryTroopMemberFragmentV12.f182569d0 = (TextView) chatHistoryTroopMemberFragmentV12.findViewById(R.id.ivTitleBtnLeftButton);
            ChatHistoryTroopMemberFragmentV1.this.f182569d0.setVisibility(0);
            ChatHistoryTroopMemberFragmentV1.this.f182569d0.setText(HardCodeUtil.qqStr(R.string.j6l));
            ChatHistoryTroopMemberFragmentV1.this.f182569d0.setOnClickListener(new ViewOnClickListenerC7167a());
            ChatHistoryTroopMemberFragmentV1.this.ej();
            ListAdapter listAdapter = ChatHistoryTroopMemberFragmentV1.this.U;
            if (listAdapter != null) {
                listAdapter.k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(ChatHistoryTroopMemberFragmentV1.this.U.H);
            ChatHistoryTroopMemberFragmentV1.this.hj(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
            chatHistoryTroopMemberFragmentV1.P1.postDelayed(new SearchDialogDismissRunnable(chatHistoryTroopMemberFragmentV1), 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
            if (chatHistoryTroopMemberFragmentV1.J0 == 11) {
                ReportController.o(chatHistoryTroopMemberFragmentV1.E1, "CliOper", "", "", "0X8006216", "0X8006216", 0, 0, "", "", "", "");
            }
            ChatHistoryTroopMemberFragmentV1.this.O1.cancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class f extends Handler {
        f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TroopInfo troopInfo;
            if (ChatHistoryTroopMemberFragmentV1.this.vi() == null || ChatHistoryTroopMemberFragmentV1.this.vi().isFinishing()) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "handleMessage,msg.what:" + message.what);
            }
            boolean z16 = true;
            switch (message.what) {
                case 1:
                    break;
                case 2:
                    ChatHistoryTroopMemberFragmentV1.this.stopTitleProgress();
                    break;
                case 3:
                case 4:
                case 10:
                default:
                    return;
                case 5:
                    ChatHistoryTroopMemberFragmentV1.this.stopTitleProgress();
                    return;
                case 6:
                    ListAdapter listAdapter = ChatHistoryTroopMemberFragmentV1.this.U;
                    if (listAdapter != null) {
                        List<w> list = listAdapter.H;
                        if (list != null) {
                            list.clear();
                        }
                        ChatHistoryTroopMemberFragmentV1.this.U.k();
                    }
                    Dialog dialog = ChatHistoryTroopMemberFragmentV1.this.V;
                    if (dialog != null && dialog.isShowing()) {
                        ChatHistoryTroopMemberFragmentV1.this.V.dismiss();
                    }
                    QQToast.makeText(ChatHistoryTroopMemberFragmentV1.this.vi(), ChatHistoryTroopMemberFragmentV1.this.getString(R.string.ajw), 0).show(ChatHistoryTroopMemberFragmentV1.this.W.getHeight());
                    ChatHistoryTroopMemberFragmentV1.this.ej();
                    return;
                case 7:
                    Dialog dialog2 = ChatHistoryTroopMemberFragmentV1.this.V;
                    if (dialog2 != null && dialog2.isShowing()) {
                        ChatHistoryTroopMemberFragmentV1.this.V.dismiss();
                    }
                    QQToast.makeText(ChatHistoryTroopMemberFragmentV1.this.vi(), ChatHistoryTroopMemberFragmentV1.this.getString(R.string.ajv), 0).show(ChatHistoryTroopMemberFragmentV1.this.W.getHeight());
                    return;
                case 8:
                    Object[] objArr = (Object[]) message.obj;
                    ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).inviteMember(ChatHistoryTroopMemberFragmentV1.this.getActivity(), ChatHistoryTroopMemberFragmentV1.this.G, ((Boolean) objArr[0]).booleanValue(), (ArrayList) objArr[1], 1);
                    return;
                case 9:
                    ListAdapter listAdapter2 = ChatHistoryTroopMemberFragmentV1.this.U;
                    if (listAdapter2 != null) {
                        listAdapter2.k();
                        return;
                    }
                    return;
                case 11:
                    TroopInfo troopInfo2 = (TroopInfo) message.obj;
                    String str = troopInfo2.troopowneruin;
                    if (str != null) {
                        ChatHistoryTroopMemberFragmentV1.this.M = str;
                    }
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
                    if (!chatHistoryTroopMemberFragmentV1.E1.getCurrentAccountUin().equals(troopInfo2.troopowneruin) && ((troopInfo = ChatHistoryTroopMemberFragmentV1.this.f182597r0) == null || !troopInfo.isOwnerOrAdmin())) {
                        z16 = false;
                    }
                    chatHistoryTroopMemberFragmentV1.D = z16;
                    TroopInfo troopInfo3 = ChatHistoryTroopMemberFragmentV1.this.f182597r0;
                    if (troopInfo3 != null && troopInfo3.isOwner()) {
                        ChatHistoryTroopMemberFragmentV1.this.U0 = "0";
                    } else {
                        TroopInfo troopInfo4 = ChatHistoryTroopMemberFragmentV1.this.f182597r0;
                        if (troopInfo4 != null && troopInfo4.isOwnerOrAdmin()) {
                            ChatHistoryTroopMemberFragmentV1.this.U0 = "1";
                        }
                    }
                    ListAdapter listAdapter3 = ChatHistoryTroopMemberFragmentV1.this.U;
                    if (listAdapter3 != null) {
                        listAdapter3.k();
                        return;
                    }
                    return;
                case 12:
                    synchronized (ChatHistoryTroopMemberFragmentV1.this) {
                        ChatHistoryTroopMemberFragmentV1.this.S1--;
                        List list2 = (List) message.obj;
                        if (list2 != null || ChatHistoryTroopMemberFragmentV1.this.J0 == 14) {
                            if (ChatHistoryTroopMemberFragmentV1.this.f182582j1.getVisibility() == 0) {
                                ChatHistoryTroopMemberFragmentV1.this.P1.removeMessages(13);
                                double min = Math.min(((message.arg1 * 1.0d) / ChatHistoryTroopMemberFragmentV1.this.U1) + 0.9d, 1.0d);
                                int i3 = (int) (100.0d * min);
                                if (i3 > ChatHistoryTroopMemberFragmentV1.this.f182586l1.getProgress()) {
                                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV12 = ChatHistoryTroopMemberFragmentV1.this;
                                    chatHistoryTroopMemberFragmentV12.ij((int) (ChatHistoryTroopMemberFragmentV1.this.U1 * min), chatHistoryTroopMemberFragmentV12.U1, i3);
                                }
                            }
                            if (list2 != null) {
                                ChatHistoryTroopMemberFragmentV1.this.T.addAll(list2);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "handleMessage, mJobCount left:" + ChatHistoryTroopMemberFragmentV1.this.S1 + "mATroopMemberList.size():" + ChatHistoryTroopMemberFragmentV1.this.T.size());
                            }
                            if (ChatHistoryTroopMemberFragmentV1.this.S1 <= 0) {
                                ChatHistoryTroopMemberFragmentV1.this.f182606v1 = true;
                            }
                            if (ChatHistoryTroopMemberFragmentV1.this.f182606v1 && ChatHistoryTroopMemberFragmentV1.this.f182604u1) {
                                if (ChatHistoryTroopMemberFragmentV1.this.T.isEmpty()) {
                                    return;
                                }
                                ChatHistoryTroopMemberFragmentV1.this.stopTitleProgress();
                                if (QLog.isColorLevel()) {
                                    QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "handleMessage real totalTime:" + (System.currentTimeMillis() - ChatHistoryTroopMemberFragmentV1.this.T1) + "start refreshUI");
                                }
                                if (ChatHistoryTroopMemberFragmentV1.this.E1.getProxyManager() != null) {
                                    ChatHistoryTroopMemberFragmentV1.this.E1.getProxyManager().notifyRefreshTroopMember();
                                }
                                message.obj = ChatHistoryTroopMemberFragmentV1.this.U.g();
                                ChatHistoryTroopMemberFragmentV1.this.aj(message);
                            }
                            return;
                        }
                        return;
                    }
                case 13:
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV13 = ChatHistoryTroopMemberFragmentV1.this;
                    double d16 = chatHistoryTroopMemberFragmentV13.R1 + ChatHistoryTroopMemberFragmentV1.f182558d2;
                    chatHistoryTroopMemberFragmentV13.R1 = d16;
                    if (d16 > chatHistoryTroopMemberFragmentV13.f182586l1.getProgress()) {
                        ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV14 = ChatHistoryTroopMemberFragmentV1.this;
                        if (chatHistoryTroopMemberFragmentV14.R1 >= 90.0d || chatHistoryTroopMemberFragmentV14.U1 <= 0) {
                            return;
                        }
                        ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV15 = ChatHistoryTroopMemberFragmentV1.this;
                        int i16 = (int) chatHistoryTroopMemberFragmentV15.R1;
                        double d17 = chatHistoryTroopMemberFragmentV15.U1;
                        ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV16 = ChatHistoryTroopMemberFragmentV1.this;
                        chatHistoryTroopMemberFragmentV16.ij((int) ((d17 * chatHistoryTroopMemberFragmentV16.R1) / 100.0d), chatHistoryTroopMemberFragmentV16.U1, i16);
                        Handler handler = ChatHistoryTroopMemberFragmentV1.this.P1;
                        handler.sendMessageDelayed(handler.obtainMessage(13), 800L);
                        return;
                    }
                    return;
                case 14:
                    ChatHistoryTroopMemberFragmentV1.this.f182582j1.setVisibility(0);
                    return;
                case 15:
                    Dialog dialog3 = ChatHistoryTroopMemberFragmentV1.this.V;
                    if (dialog3 == null || !dialog3.isShowing()) {
                        return;
                    }
                    ChatHistoryTroopMemberFragmentV1.this.V.dismiss();
                    return;
            }
            ChatHistoryTroopMemberFragmentV1.this.aj(message);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag instanceof com.tencent.mobileqq.troop.widget.e) {
                com.tencent.mobileqq.troop.widget.e eVar = (com.tencent.mobileqq.troop.widget.e) tag;
                int i3 = eVar.position;
                if (eVar.isFromSearchList) {
                    com.tencent.imcore.message.report.a.h(ChatHistoryTroopMemberFragmentV1.this.E1, 8, 2);
                    ChatHistoryTroopMemberFragmentV1.this.ni((w) ChatHistoryTroopMemberFragmentV1.this.f182587m0.getItem(i3));
                    Dialog dialog = ChatHistoryTroopMemberFragmentV1.this.O1;
                    if (dialog != null && dialog.isShowing()) {
                        ChatHistoryTroopMemberFragmentV1.this.O1.dismiss();
                    }
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
                    if (chatHistoryTroopMemberFragmentV1.J0 == 11) {
                        ReportController.o(chatHistoryTroopMemberFragmentV1.E1, "CliOper", "", "", "0X8006218", "0X8006218", 0, 0, "", "", "", "");
                        return;
                    }
                    return;
                }
                ChatHistoryTroopMemberFragmentV1.this.ni((w) ChatHistoryTroopMemberFragmentV1.this.U.getItem(i3));
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV12 = ChatHistoryTroopMemberFragmentV1.this;
                if (chatHistoryTroopMemberFragmentV12.J0 == 11) {
                    ReportController.o(chatHistoryTroopMemberFragmentV12.E1, "CliOper", "", "", "0X8006219", "0X8006219", 0, 0, "", "", "", "");
                }
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV13 = ChatHistoryTroopMemberFragmentV1.this;
                if (chatHistoryTroopMemberFragmentV13.J0 == 18) {
                    ReportController.o(chatHistoryTroopMemberFragmentV13.E1, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_clk", 0, 0, chatHistoryTroopMemberFragmentV13.G, "", "", "");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w wVar;
            Object tag = view.getTag();
            if (tag instanceof com.tencent.mobileqq.troop.widget.e) {
                if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "mOnKickOutBtnClickListener onclick");
                }
                int id5 = view.getId();
                com.tencent.mobileqq.troop.widget.e eVar = (com.tencent.mobileqq.troop.widget.e) tag;
                int i3 = eVar.position;
                boolean z16 = eVar.isFromSearchList;
                if (z16) {
                    wVar = (w) ChatHistoryTroopMemberFragmentV1.this.f182587m0.getItem(i3);
                } else {
                    wVar = (w) ChatHistoryTroopMemberFragmentV1.this.U.getItem(i3);
                }
                String str = wVar.f182667a;
                MemberRole memberRole = wVar.M;
                boolean z17 = false;
                boolean z18 = memberRole == MemberRole.OWNER;
                boolean z19 = memberRole == MemberRole.ADMIN;
                boolean equals = ChatHistoryTroopMemberFragmentV1.this.E1.getCurrentAccountUin().equals(ChatHistoryTroopMemberFragmentV1.this.M);
                if ((equals && !str.equals(ChatHistoryTroopMemberFragmentV1.this.E1.getCurrentAccountUin())) || (!equals && !z18 && !z19)) {
                    z17 = true;
                }
                if (id5 == R.id.bf9) {
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
                    if (chatHistoryTroopMemberFragmentV1.J0 == 20) {
                        chatHistoryTroopMemberFragmentV1.ni(wVar);
                        return;
                    }
                    if (chatHistoryTroopMemberFragmentV1.K) {
                        if (chatHistoryTroopMemberFragmentV1.U.H.contains(wVar)) {
                            ChatHistoryTroopMemberFragmentV1.this.U.H.remove(wVar);
                        } else if (z17) {
                            ChatHistoryTroopMemberFragmentV1.this.U.H.add(wVar);
                        }
                        ChatHistoryTroopMemberFragmentV1.this.ej();
                        ChatHistoryTroopMemberFragmentV1.this.U.notifyDataSetChanged();
                        return;
                    }
                    if (z16) {
                        if (chatHistoryTroopMemberFragmentV1.W1.equals(str)) {
                            return;
                        }
                        eVar.troopMember.b(true);
                        if (!TextUtils.isEmpty(ChatHistoryTroopMemberFragmentV1.this.W1)) {
                            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV12 = ChatHistoryTroopMemberFragmentV1.this;
                            com.tencent.mobileqq.troop.widget.e si5 = chatHistoryTroopMemberFragmentV12.si(chatHistoryTroopMemberFragmentV12.W1, z16);
                            if (si5 != null) {
                                si5.troopMember.c(true);
                            }
                        }
                        ChatHistoryTroopMemberFragmentV1.this.W1 = str;
                        return;
                    }
                    if (chatHistoryTroopMemberFragmentV1.V1.equals(str)) {
                        return;
                    }
                    eVar.troopMember.b(true);
                    if (!TextUtils.isEmpty(ChatHistoryTroopMemberFragmentV1.this.V1)) {
                        ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV13 = ChatHistoryTroopMemberFragmentV1.this;
                        com.tencent.mobileqq.troop.widget.e si6 = chatHistoryTroopMemberFragmentV13.si(chatHistoryTroopMemberFragmentV13.V1, z16);
                        if (si6 != null) {
                            si6.troopMember.c(true);
                        }
                    }
                    ChatHistoryTroopMemberFragmentV1.this.V1 = str;
                    return;
                }
                if (id5 == R.id.ixj) {
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV14 = ChatHistoryTroopMemberFragmentV1.this;
                    if (chatHistoryTroopMemberFragmentV14.K) {
                        if (chatHistoryTroopMemberFragmentV14.U.H.contains(wVar)) {
                            ChatHistoryTroopMemberFragmentV1.this.U.H.remove(wVar);
                        } else if (z17) {
                            ChatHistoryTroopMemberFragmentV1.this.U.H.add(wVar);
                        }
                        ChatHistoryTroopMemberFragmentV1.this.ej();
                        ChatHistoryTroopMemberFragmentV1.this.U.notifyDataSetChanged();
                    }
                    if (z16) {
                        ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV15 = ChatHistoryTroopMemberFragmentV1.this;
                        com.tencent.mobileqq.troop.widget.e si7 = chatHistoryTroopMemberFragmentV15.si(chatHistoryTroopMemberFragmentV15.W1, z16);
                        if (si7 != null) {
                            si7.troopMember.c(true);
                            ChatHistoryTroopMemberFragmentV1.this.W1 = "";
                        }
                        ChatHistoryTroopMemberFragmentV1.this.f182587m0.notifyDataSetChanged();
                        return;
                    }
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV16 = ChatHistoryTroopMemberFragmentV1.this;
                    com.tencent.mobileqq.troop.widget.e si8 = chatHistoryTroopMemberFragmentV16.si(chatHistoryTroopMemberFragmentV16.V1, z16);
                    if (si8 != null) {
                        si8.troopMember.c(true);
                        ChatHistoryTroopMemberFragmentV1.this.V1 = "";
                        return;
                    }
                    return;
                }
                if (id5 == R.id.f164668ai4 && ChatHistoryTroopMemberFragmentV1.this.J) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "delBtn onClick, uin=" + str);
                    }
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV17 = ChatHistoryTroopMemberFragmentV1.this;
                    int i16 = chatHistoryTroopMemberFragmentV17.J0;
                    if (i16 == 1) {
                        chatHistoryTroopMemberFragmentV17.Hi(str);
                        return;
                    }
                    if (i16 == 13) {
                        w bj5 = chatHistoryTroopMemberFragmentV17.bj(str);
                        ChatHistoryTroopMemberFragmentV1.this.G0.add(str);
                        ChatHistoryTroopMemberFragmentV1.this.U.k();
                        if (ChatHistoryTroopMemberFragmentV1.this.O1.isShowing()) {
                            if (bj5 != null) {
                                ChatHistoryTroopMemberFragmentV1.this.f182585l0.remove(bj5);
                            }
                            ChatHistoryTroopMemberFragmentV1.this.f182587m0.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    if (i16 == 21) {
                        w bj6 = chatHistoryTroopMemberFragmentV17.bj(str);
                        ChatHistoryTroopMemberFragmentV1.this.G0.add(str);
                        ChatHistoryTroopMemberFragmentV1.this.U.k();
                        if (ChatHistoryTroopMemberFragmentV1.this.O1.isShowing()) {
                            if (bj6 != null) {
                                ChatHistoryTroopMemberFragmentV1.this.f182585l0.remove(bj6);
                            }
                            ChatHistoryTroopMemberFragmentV1.this.f182587m0.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(wVar);
                    ChatHistoryTroopMemberFragmentV1.this.hj(arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class j extends com.tencent.mobileqq.troop.troopsetting.api.b {
        j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(String str, w wVar) {
            ChatHistoryTroopMemberFragmentV1.this.bj(str);
            synchronized (ChatHistoryTroopMemberFragmentV1.this.getActivity()) {
                ChatHistoryTroopMemberFragmentV1.this.T.add(wVar);
                ChatHistoryTroopMemberFragmentV1.this.P1.sendEmptyMessage(9);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(final String str, TroopMemberInfo troopMemberInfo) {
            FriendsManager friendsManager = (FriendsManager) ChatHistoryTroopMemberFragmentV1.this.E1.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (troopMemberInfo == null || friendsManager == null) {
                return;
            }
            final w li5 = ChatHistoryTroopMemberFragmentV1.this.li(troopMemberInfo, friendsManager);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.r
                @Override // java.lang.Runnable
                public final void run() {
                    ChatHistoryTroopMemberFragmentV1.j.this.n(str, li5);
                }
            });
        }

        @Override // com.tencent.mobileqq.troop.troopsetting.api.b
        protected void e(String str, final String str2, String str3) {
            if (ChatHistoryTroopMemberFragmentV1.this.G.equals(str)) {
                ITroopMemberListRepoApi iTroopMemberListRepoApi = (ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class);
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
                iTroopMemberListRepoApi.fetchTroopMemberInfo(chatHistoryTroopMemberFragmentV1.G, str2, false, chatHistoryTroopMemberFragmentV1, "ChatHistoryTroopMemberFragmentV1", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.activity.history.compat.q
                    @Override // com.tencent.qqnt.troopmemberlist.g
                    public final void a(TroopMemberInfo troopMemberInfo) {
                        ChatHistoryTroopMemberFragmentV1.j.this.o(str2, troopMemberInfo);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(ChatHistoryTroopMemberFragmentV1.this.vi(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
            ChatHistoryTroopMemberFragmentV1.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putString(VasH5PayUtil.SERVICENAME, HardCodeUtil.qqStr(R.string.kdc));
            bundle.putString(VasH5PayUtil.SERVICECODE, "CJCLUBT");
            bundle.putString(VasH5PayUtil.OFFERID, "1450000516");
            bundle.putInt(VasH5PayUtil.OPENMONTH, 3);
            bundle.putString(VasH5PayUtil.PAY_URL, VasH5PayUtil.H5_PAY_URL + "mvip.pt.vipsite.tqtips_chengyuan");
            bundle.putString(VasH5PayUtil.VIPTYPE, "svip");
            bundle.putString(VasH5PayUtil.SENDUIN, ChatHistoryTroopMemberFragmentV1.this.E1.getCurrentAccountUin());
            VasH5PayUtil.openClubPay(ChatHistoryTroopMemberFragmentV1.this.vi(), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class o implements View.OnTouchListener {
        o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
            if (chatHistoryTroopMemberFragmentV1.J0 == 15 && chatHistoryTroopMemberFragmentV1.f182580i1.size() > 0) {
                Intent intent = new Intent();
                intent.putExtra(TroopMemberListActivity.PARAM_DELETED_UINS, ChatHistoryTroopMemberFragmentV1.this.f182580i1);
                ChatHistoryTroopMemberFragmentV1.this.vi().setResult(-1, intent);
                TroopInfo troopInfo = ChatHistoryTroopMemberFragmentV1.this.f182597r0;
                int i3 = (troopInfo == null || !troopInfo.isOwner()) ? 1 : 0;
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV12 = ChatHistoryTroopMemberFragmentV1.this;
                ReportController.o(chatHistoryTroopMemberFragmentV12.E1, "dc00899", "Grp_mber", "", "mber_list", "del_inacmem", 0, 0, chatHistoryTroopMemberFragmentV12.G, "" + i3, "1", ChatHistoryTroopMemberFragmentV1.this.f182580i1.toString());
            }
            ChatHistoryTroopMemberFragmentV1.this.vi().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(ChatHistoryTroopMemberFragmentV1.this.vi(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
            ChatHistoryTroopMemberFragmentV1.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatHistoryTroopMemberFragmentV1.this.ii();
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
            chatHistoryTroopMemberFragmentV1.oi("Clk_find", chatHistoryTroopMemberFragmentV1.U0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class t implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f182661d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f182662e;

        t(int i3, int i16) {
            this.f182661d = i3;
            this.f182662e = i16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(ChatHistoryTroopMemberFragmentV1.this.vi(), (Class<?>) com.tencent.mobileqq.troop.memberlist.c.class);
            intent.putExtra("troop_uin", ChatHistoryTroopMemberFragmentV1.this.G);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 15);
            intent.putExtra(TroopMemberListActivity.PARAM_SEQ_DAYS, ChatHistoryTroopMemberFragmentV1.this.f182574f1);
            intent.putExtra(TroopMemberListActivity.PARAM_SEQ_NAME, ChatHistoryTroopMemberFragmentV1.this.f182572e1);
            intent.putExtra(AppConstants.Key.TROOP_INFO_MEMBER_NUM, this.f182661d);
            ChatHistoryTroopMemberFragmentV1.this.startActivityForResult(intent, 4);
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
            ReportController.o(chatHistoryTroopMemberFragmentV1.E1, "dc00899", "Grp_mber", "", "mber_list", "clk_inacentry", 0, 0, chatHistoryTroopMemberFragmentV1.G, "" + this.f182662e, "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class u implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InputMethodManager f182664d;

        u(InputMethodManager inputMethodManager) {
            this.f182664d = inputMethodManager;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f182664d.hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatHistoryTroopMemberFragmentV1.this.O1.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class x implements Comparator<w> {

        /* renamed from: d, reason: collision with root package name */
        int f182693d;

        /* renamed from: e, reason: collision with root package name */
        boolean f182694e;

        public x(int i3, boolean z16) {
            this.f182693d = i3;
            this.f182694e = z16;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(w wVar, w wVar2) {
            int i3 = this.f182693d;
            if (i3 == 0) {
                return wVar.f182670d.compareToIgnoreCase(wVar2.f182670d);
            }
            if (i3 == 2) {
                long j3 = wVar.f182687u;
                long j16 = wVar2.f182687u;
                if (j3 == j16) {
                    return 0;
                }
                return j3 > j16 ? this.f182694e ? -1 : 1 : this.f182694e ? 1 : -1;
            }
            if (i3 == 3) {
                long j17 = wVar.f182685s;
                long j18 = wVar2.f182685s;
                if (j17 == j18) {
                    return 0;
                }
                return j17 > j18 ? this.f182694e ? -1 : 1 : this.f182694e ? 1 : -1;
            }
            if (i3 != 1) {
                if (i3 != 8) {
                    return 0;
                }
                int i16 = wVar.L;
                int i17 = wVar2.L;
                return i16 == i17 ? wVar.f182670d.compareToIgnoreCase(wVar2.f182670d) : i17 - i16;
            }
            int i18 = wVar.N.realLevel;
            int i19 = wVar2.N.realLevel;
            if (i18 != i19) {
                return i18 < i19 ? 1 : -1;
            }
            int compareToIgnoreCase = wVar.f182669c.compareToIgnoreCase(wVar2.f182669c);
            if (compareToIgnoreCase == 0) {
                return 0;
            }
            return compareToIgnoreCase > 0 ? 1 : -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class z implements Comparator<w> {
        public z() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(w wVar, w wVar2) {
            return wVar.f182673g.compareToIgnoreCase(wVar2.f182673g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ai(boolean z16, int i3, ArrayList<String> arrayList) {
        QLog.d("ChatHistoryTroopMemberFragmentV1", 1, "[handleDeleteTroopMember] isSuc:" + z16 + ", code:" + i3 + ", size:" + arrayList.size());
        if (!z16) {
            if (i3 == 2) {
                Handler handler = this.P1;
                handler.sendMessage(handler.obtainMessage(15));
                return;
            } else {
                Handler handler2 = this.P1;
                handler2.sendMessage(handler2.obtainMessage(7));
                return;
            }
        }
        if (arrayList.size() > 0) {
            this.H1 = true;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                bj(it.next());
            }
            if (this.J0 == 15) {
                this.f182580i1 = arrayList;
            }
            Handler handler3 = this.P1;
            handler3.sendMessage(handler3.obtainMessage(6));
        }
    }

    private void Ci() {
        Dialog dialog = new Dialog(vi());
        this.O1 = dialog;
        dialog.setCanceledOnTouchOutside(true);
        this.O1.requestWindowFeature(1);
        this.O1.getWindow().setSoftInputMode(36);
        this.O1.setContentView(R.layout.f168950hg3);
        WindowManager.LayoutParams attributes = this.O1.getWindow().getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = -1;
        attributes.windowAnimations = android.R.style.Animation;
        attributes.gravity = 51;
        this.O1.getWindow().setBackgroundDrawable(new ColorDrawable());
        InputMethodManager inputMethodManager = (InputMethodManager) vi().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (ImmersiveUtils.isSupporImmersive() == 1 && Build.VERSION.SDK_INT < 24) {
            this.O1.getWindow().addFlags(67108864);
            new SystemBarCompact(this.O1, true, getResources().getColor(R.color.skin_color_title_immersive_bar)).init();
            View findViewById = this.O1.findViewById(R.id.root);
            findViewById.setFitsSystemWindows(true);
            findViewById.setPadding(0, ImmersiveUtils.getScreenHeight(), 0, 0);
        }
        XListView xListView = (XListView) this.O1.findViewById(R.id.searchList);
        this.f182583k0 = xListView;
        xListView.setBackgroundDrawable(getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard_bg));
        this.f182583k0.setDividerHeight(0);
        this.f182585l0.clear();
        y yVar = new y(this.f182585l0);
        this.f182587m0 = yVar;
        this.f182583k0.setAdapter((android.widget.ListAdapter) yVar);
        this.f182583k0.setOnTouchListener(new u(inputMethodManager));
        EditText editText = (EditText) this.O1.findViewById(R.id.f66003_g);
        this.f182575g0 = editText;
        editText.addTextChangedListener(new aa());
        this.f182589n0 = this.O1.findViewById(R.id.root);
        this.f182579i0 = this.O1.findViewById(R.id.f166412fa0);
        RelativeLayout relativeLayout = (RelativeLayout) this.O1.findViewById(R.id.result_layout);
        this.f182581j0 = relativeLayout;
        relativeLayout.setOnClickListener(new v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ei() {
        return this.X0 || this.Y0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gi() {
        boolean z16;
        int i3 = this.J0;
        boolean z17 = i3 == 3 || i3 == 2 || i3 == 14;
        TroopInfo troopInfo = this.f182597r0;
        if (troopInfo != null) {
            long j3 = troopInfo.dwGroupClassExt;
            if (j3 == 10009 || j3 == 10010 || j3 == 10011) {
                z16 = true;
                return z17 && z16;
            }
        }
        z16 = false;
        if (z17) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ii(TroopMemberInfo troopMemberInfo) {
        eu.g("Grp_edu", "teachermsg", "showsomeone", 0, 0, this.f182599s0.troopUin, eu.a(troopMemberInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ji(long j3, boolean z16, List list) {
        Ui(z16, new ArrayList(list), j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ki() {
        ((gt2.a) this.E1.getBusinessHandler(BusinessHandlerFactory.TROOP_FEE_HANDLER)).j1(this.G, this.K0, this.L0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Li() {
        int i3 = this.J0;
        if (i3 == 1 || i3 == 11 || i3 == 16) {
            Object[] wi5 = wi(this.G);
            Handler handler = this.P1;
            handler.sendMessage(handler.obtainMessage(1, wi5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mi(List list, long j3, boolean z16, List list2) {
        HashMap hashMap = new HashMap();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            TroopMemberInfo troopMemberInfo = (TroopMemberInfo) it.next();
            hashMap.put(troopMemberInfo.memberuin, troopMemberInfo);
        }
        ArrayList arrayList = new ArrayList();
        FriendsManager friendsManager = (FriendsManager) this.E1.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            TroopMemberInfo troopMemberInfo2 = (TroopMemberInfo) hashMap.get((String) it5.next());
            if (troopMemberInfo2 != null) {
                arrayList.add(li(troopMemberInfo2, friendsManager));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "[getMemberListFromUins] cost:" + (System.currentTimeMillis() - j3));
        }
        Handler handler = this.P1;
        handler.sendMessage(handler.obtainMessage(2, new Object[]{arrayList}));
        Yi(list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oi(boolean z16, final List list) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.f
            @Override // java.lang.Runnable
            public final void run() {
                ChatHistoryTroopMemberFragmentV1.this.Ni(list);
            }
        });
        Yi(list);
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "getTroopMemberFromDB, queryTime:" + (currentTimeMillis - this.T1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Pi(boolean z16, List list) {
        ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((TroopMemberInfo) it.next()).memberuin);
        }
        Message obtainMessage = this.P1.obtainMessage();
        obtainMessage.what = 8;
        obtainMessage.obj = new Object[]{Boolean.valueOf(this.D), arrayList2};
        this.P1.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ri(List list, int i3, int i16) {
        Vi(list.subList(i3, i16), i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Si(List list, CheckBox checkBox, Dialog dialog, View view) {
        mi(list, checkBox, dialog);
    }

    private void Ui(boolean z16, final List<TroopMemberInfo> list, long j3) {
        Object valueOf;
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Thread id:");
            sb5.append(Thread.currentThread().getId());
            sb5.append(",threadName:");
            sb5.append(Thread.currentThread().getName());
            sb5.append("|onUpdateTroopGetMemberList:");
            sb5.append(z16);
            sb5.append("|troopMemberInfoList size:");
            if (list == null) {
                valueOf = "";
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            sb5.append(valueOf);
            sb5.append("|time:");
            sb5.append((currentTimeMillis - j3) / 1000);
            sb5.append(ReportConstant.COSTREPORT_PREFIX);
            String sb6 = sb5.toString();
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryTroopMemberFragmentV1", 2, sb6);
            }
        }
        if (z16) {
            try {
                getActivity().getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME + this.E1.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.G, System.currentTimeMillis()).commit();
                this.P1.removeMessages(1);
                int i3 = this.J0;
                if (i3 != 13 && i3 != 21) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            ChatHistoryTroopMemberFragmentV1.this.Qi(list);
                        }
                    });
                } else {
                    Xi(list, this.E0);
                }
                Handler handler = this.P1;
                handler.sendMessage(handler.obtainMessage(5, Boolean.valueOf(z16)));
                Yi(list);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "onUpdateTroopGetMemberList:" + e16);
                    return;
                }
                return;
            }
        }
        int i16 = this.J0;
        if (i16 != 13 && i16 != 21) {
            zi(this.G);
        } else {
            yi(this.G, this.E0);
        }
        Handler handler2 = this.P1;
        handler2.sendMessage(handler2.obtainMessage(5, Boolean.valueOf(z16)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Wi, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public synchronized void Qi(final List<TroopMemberInfo> list) {
        this.T.clear();
        this.R1 = 0.0d;
        this.S1 = -1;
        this.U1 = 0;
        if (list != null && !list.isEmpty()) {
            try {
                int size = list.size();
                this.U1 = size;
                int i3 = f182559e2;
                this.S1 = (size / i3) + (size % i3 == 0 ? 0 : 1);
                for (final int i16 = 0; i16 < size; i16 += f182559e2) {
                    final int min = Math.min((f182559e2 + i16) - 1, size);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            ChatHistoryTroopMemberFragmentV1.this.Ri(list, i16, min);
                        }
                    }, 16, null, true);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "getTroopMemberFromDBIfNeeded, listSize:" + size + "|mJobCount:" + this.S1);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "getTroopMemberFromDBIfNeeded:" + e16);
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "troopMemberInfoList == null || troopMemberInfoList.isEmpty()");
        }
        this.P1.post(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1.17
            @Override // java.lang.Runnable
            public void run() {
                ChatHistoryTroopMemberFragmentV1.this.stopTitleProgress();
            }
        });
    }

    private void Xi(List<TroopMemberInfo> list, List<String> list2) {
        HashMap hashMap = new HashMap();
        for (TroopMemberInfo troopMemberInfo : list) {
            hashMap.put(troopMemberInfo.memberuin, troopMemberInfo);
        }
        ArrayList arrayList = new ArrayList();
        FriendsManager friendsManager = (FriendsManager) this.E1.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            TroopMemberInfo troopMemberInfo2 = (TroopMemberInfo) hashMap.get(it.next());
            if (troopMemberInfo2 != null) {
                arrayList.add(li(troopMemberInfo2, friendsManager));
            }
        }
        Handler handler = this.P1;
        handler.sendMessage(handler.obtainMessage(2, new Object[]{arrayList}));
    }

    private void Yi(List<TroopMemberInfo> list) {
        TroopInfo findTroopInfo = ((ITroopInfoService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.G);
        if (findTroopInfo == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        for (TroopMemberInfo troopMemberInfo : list) {
            String str = troopMemberInfo.memberuin;
            if (str != null && !"".equals(str.trim())) {
                MemberRole memberRole = troopMemberInfo.role;
                if (memberRole == MemberRole.OWNER) {
                    findTroopInfo.troopowneruin = troopMemberInfo.memberuin;
                } else if (memberRole == MemberRole.ADMIN && !troopMemberInfo.memberuin.trim().equals(findTroopInfo.troopowneruin)) {
                    sb5.append(troopMemberInfo.memberuin);
                    sb5.append("|");
                }
            }
        }
        findTroopInfo.Administrator = sb5.toString();
        Message obtainMessage = this.P1.obtainMessage();
        obtainMessage.what = 11;
        obtainMessage.obj = findTroopInfo;
        this.P1.sendMessage(obtainMessage);
        if (QLog.isColorLevel()) {
            QLog.i("ChatHistoryTroopMemberFragmentV1", 2, findTroopInfo.Administrator);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ej() {
        int size = this.U.H.size();
        if (size > 0) {
            String format = MessageFormat.format(HardCodeUtil.qqStr(R.string.kdv), Integer.valueOf(size));
            this.X.setEnabled(true);
            this.X.setText(format);
            this.X.setOnClickListener(new b());
            return;
        }
        this.X.setEnabled(false);
        this.X.setText(HardCodeUtil.qqStr(R.string.ke7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View findViewById(int i3) {
        return this.F1.findViewById(i3);
    }

    public static void fj(Resources resources, com.tencent.mobileqq.troop.widget.e eVar, w wVar) {
        try {
            if (SimpleUIUtil.getSimpleUISwitch()) {
                eVar.tvName.setTextColor(resources.getColorStateList(R.color.qui_common_text_primary, null));
                return;
            }
            if (((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getBigClubFlag(wVar.G) != 0) {
                eVar.tvName.setTextColor(resources.getColor(R.color.skin_red_theme_version2));
                return;
            }
            int vipTypeByFlag = ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getVipTypeByFlag(wVar.F);
            if (vipTypeByFlag != 1) {
                if (vipTypeByFlag == 2) {
                    eVar.tvName.setTextColor(resources.getColor(R.color.skin_red_theme_version2));
                    return;
                } else if (vipTypeByFlag != 3) {
                    if (vipTypeByFlag != 4) {
                        eVar.tvName.setTextColor(resources.getColorStateList(R.color.qui_common_text_primary, null));
                        return;
                    } else {
                        eVar.tvName.setTextColor(resources.getColor(R.color.skin_red_theme_version2));
                        return;
                    }
                }
            }
            eVar.tvName.setTextColor(resources.getColor(R.color.skin_red_theme_version2));
        } catch (Throwable unused) {
            eVar.tvName.setTextColor(resources.getColorStateList(R.color.qui_common_text_primary, null));
        }
    }

    private void gj() {
        TroopInfo troopInfo;
        TroopInfo troopInfo2 = this.f182597r0;
        boolean z16 = (troopInfo2 != null && troopInfo2.isOwnerOrAdmin()) || ((troopInfo = this.f182597r0) != null && troopInfo.isOwner());
        if (this.L || !z16) {
            return;
        }
        int i3 = this.J0;
        if ((i3 == 0 || i3 == 17) && System.currentTimeMillis() > this.f182567c1) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1.6
                @Override // java.lang.Runnable
                public void run() {
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
                    ChatHistoryTroopMemberFragmentV1.ui(chatHistoryTroopMemberFragmentV1.E1, Long.valueOf(chatHistoryTroopMemberFragmentV1.G).longValue(), new a());
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1$6$a */
                /* loaded from: classes33.dex */
                class a extends ProtoUtils.TroopProtocolObserver {
                    a() {
                    }

                    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
                    public void onResult(int i3, byte[] bArr, Bundle bundle) {
                        if (i3 != 0 || bArr == null) {
                            return;
                        }
                        try {
                            oidb_cmd0x74f$RspBody oidb_cmd0x74f_rspbody = new oidb_cmd0x74f$RspBody();
                            oidb_cmd0x74f_rspbody.mergeFrom(bArr);
                            if (oidb_cmd0x74f_rspbody.uint32_ret_code.get() == 0 && oidb_cmd0x74f_rspbody.bool_display_entrance.get()) {
                                ChatHistoryTroopMemberFragmentV1.this.f182570d1 = oidb_cmd0x74f_rspbody.range.get();
                                ChatHistoryTroopMemberFragmentV1.this.gi();
                                ChatHistoryTroopMemberFragmentV1.this.f182567c1 = oidb_cmd0x74f_rspbody.uint64_next_pull_time.get();
                            }
                        } catch (Exception unused) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "initListView, get0x74f\uff1afailed");
                            }
                        }
                    }
                }
            }, 8, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj(final List<w> list) {
        if (list.size() < 1) {
            return;
        }
        final Dialog dialog = new Dialog(vi(), R.style.qZoneInputDialog);
        dialog.setContentView(R.layout.f167936ng);
        ((TextView) dialog.findViewById(R.id.dialogTitle)).setText(getString(R.string.akq));
        TextView textView = (TextView) dialog.findViewById(R.id.dialogText);
        final CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.checkBoxConfirm);
        if (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.addRule(14);
            textView.setLayoutParams(layoutParams);
        }
        if (checkBox.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) checkBox.getLayoutParams();
            layoutParams2.addRule(14);
            checkBox.setLayoutParams(layoutParams2);
        }
        boolean z16 = !this.D && this.f182599s0.allowMemberKick == 1;
        ((TextView) dialog.findViewById(R.id.dialogTitle)).setText(getString(R.string.c0g));
        textView.setVisibility(8);
        checkBox.setText(getString(R.string.h0e));
        if (z16) {
            checkBox.setVisibility(8);
        }
        TextView textView2 = (TextView) dialog.findViewById(R.id.dialogLeftBtn);
        TextView textView3 = (TextView) dialog.findViewById(R.id.dialogRightBtn);
        textView2.setText(17039360);
        textView3.setText(android.R.string.ok);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.history.compat.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistoryTroopMemberFragmentV1.Ti(dialog, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.history.compat.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistoryTroopMemberFragmentV1.this.Si(list, checkBox, dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(int i3, int i16, int i17) {
        int i18 = this.J0;
        if (i18 != 20 && i18 != 21) {
            this.f182588m1.setText(String.format(HardCodeUtil.qqStr(R.string.kdl), Integer.valueOf(i3), Integer.valueOf(i16)));
        } else {
            this.f182588m1.setText(String.format(HardCodeUtil.qqStr(R.string.keg), Integer.valueOf(i17)));
        }
        this.f182586l1.setProgress(i17);
    }

    private void mj() {
        View findViewById;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        View view = this.C0;
        if (view == null || this.f182591o0 == null || (findViewById = view.findViewById(R.id.i_n)) == null || !(findViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()) == null) {
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (this.f182591o0.getVisibility() == 0) {
            marginLayoutParams.rightMargin = (int) (displayMetrics.density * 26.0f);
        } else {
            marginLayoutParams.rightMargin = (int) (displayMetrics.density * 18.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(boolean z16, String str, boolean z17, int i3, int i16, String str2, String str3, boolean z18) {
        String str4;
        String str5;
        Object obj;
        RelativeLayout relativeLayout;
        boolean z19 = false;
        boolean z26 = (this.J0 != 3 || this.D || this.R == 1) ? false : true;
        if (!this.D && z18 && (relativeLayout = this.f182577h0) != null) {
            TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_name);
            String string = getString(R.string.i7z);
            textView.setText(string);
            TextView textView2 = (TextView) this.f182577h0.findViewById(R.id.i6q);
            textView2.setText("");
            ((ImageView) this.f182577h0.findViewById(R.id.dvo)).setBackgroundDrawable(BaseImageUtil.getDefaultTroopFaceDrawableNew());
            ImageView imageView = (ImageView) this.f182577h0.findViewById(R.id.g6d);
            imageView.setVisibility(8);
            if (z26) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new l());
                textView2.setTextSize(12.0f);
            }
            this.f182577h0.setOnClickListener(new m(string));
            if (!Ei()) {
                this.f182577h0.setVisibility(0);
                this.f182577h0.setEnabled(false);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "onGetAtAllRemianCountInfo:" + z16 + ", " + str + ", " + z17 + ", " + i3 + ", " + str2 + ", " + str3);
        }
        if (this.f182577h0 != null && (obj = this.f182593p0) != null) {
            ((Animatable) obj).stop();
            this.f182593p0 = null;
            ((TextView) this.f182577h0.findViewById(R.id.i6q)).setCompoundDrawables(null, null, null, null);
        }
        RelativeLayout relativeLayout2 = this.f182577h0;
        if (relativeLayout2 == null || relativeLayout2.getVisibility() == 8) {
            return;
        }
        this.f182577h0.setEnabled(true);
        if (!z16 || str == null) {
            return;
        }
        ((TextView) this.f182577h0.findViewById(R.id.tv_name)).setTextColor(getResources().getColor(R.color.qui_common_text_primary));
        TextView textView3 = (TextView) this.f182577h0.findViewById(R.id.i6q);
        String qqStr = HardCodeUtil.qqStr(R.string.kdf);
        Button button = (Button) this.f182577h0.findViewById(R.id.fdi);
        button.setVisibility(8);
        button.setOnClickListener(new n());
        int currentUserVipType = ((ISVIPHandler) this.E1.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType();
        if (this.J0 == 11) {
            if (!str.equals(this.F)) {
                return;
            }
            this.Q = i16;
            if (z17 && i3 > 0) {
                z19 = true;
            }
            this.P = z19;
            if (z19) {
                String str6 = HardCodeUtil.qqStr(R.string.keq) + i3 + HardCodeUtil.qqStr(R.string.kf8);
                this.N = str6;
                textView3.setText(str6);
                str5 = qqStr + "," + this.N;
            } else if (i3 == 0) {
                this.N = HardCodeUtil.qqStr(R.string.kex);
                str5 = qqStr + ",\u5269\u4f590\u6b21";
                textView3.setText("\u5269\u4f590\u6b21");
            } else {
                this.N = "";
                str5 = qqStr + "," + HardCodeUtil.qqStr(R.string.keo);
                textView3.setText("");
            }
            if (this.f182591o0.getVisibility() == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                layoutParams.rightMargin = BaseAIOUtils.f(20.0f, getResources());
                textView3.setLayoutParams(layoutParams);
            }
        } else {
            if (!str.equals(this.G)) {
                return;
            }
            this.P = z17;
            this.N = str3;
            if (TextUtils.isEmpty(str2)) {
                QLog.e("ChatHistoryTroopMemberFragmentV1", 1, "updateUIForAtAllRemainedCount remainTips empty");
                return;
            }
            if (this.P || currentUserVipType == 3) {
                str4 = str2;
            } else {
                button.setVisibility(0);
                str4 = str2 + ",\n\u8d85\u7ea7\u4f1a\u5458\u53ef\u7ee7\u7eed\u4f7f\u7528";
                textView3.setGravity(21);
                textView3.setLineSpacing(this.S * 5.0f, 1.0f);
                int length = (int) (HardCodeUtil.qqStr(R.string.kfe).length() * 12 * this.S);
                new DisplayMetrics();
                float f16 = getResources().getDisplayMetrics().widthPixels;
                float f17 = this.S;
                int i17 = (int) ((f16 - (227.0f * f17)) - (f17 * 5.0f));
                if (length > i17) {
                    textView3.setSingleLine(false);
                    textView3.setLines(2);
                    textView3.setWidth(i17);
                    textView3.setEllipsize(TextUtils.TruncateAt.END);
                }
            }
            SpannableString spannableString = new SpannableString(str4);
            String trim = Pattern.compile("[^0-9]").matcher(str4).replaceAll("").trim();
            if (!TextUtils.isEmpty(trim)) {
                int indexOf = str4.indexOf(trim);
                spannableString.setSpan(new ForegroundColorSpan(-48606), indexOf, trim.length() + indexOf, 33);
            }
            if (str4.contains(HardCodeUtil.qqStr(R.string.key))) {
                int indexOf2 = str4.indexOf(HardCodeUtil.qqStr(R.string.kd8));
                spannableString.setSpan(new ForegroundColorSpan(-48606), indexOf2, HardCodeUtil.qqStr(R.string.kfb).length() + indexOf2, 33);
            }
            textView3.setText(spannableString);
            str5 = qqStr + "," + str4;
        }
        this.f182577h0.setContentDescription(str5);
    }

    private void pi() {
        final long currentTimeMillis = System.currentTimeMillis();
        QLog.i("ChatHistoryTroopMemberFragmentV1", 1, "[fetchTroopMemberInner] troopUin: " + this.G + ", troopCode: " + this.F);
        qi(true, "server", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.activity.history.compat.m
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z16, List list) {
                ChatHistoryTroopMemberFragmentV1.this.Ji(currentTimeMillis, z16, list);
            }
        });
    }

    private void qi(boolean z16, String str, com.tencent.qqnt.troopmemberlist.f fVar) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(this.G, this, z16, "ChatHistoryTroopMemberFragmentV1-" + str, fVar);
    }

    private void startTitleProgress() {
        this.f182584k1.setVisibility(8);
        ij(0, this.U1, 0);
        this.P1.sendEmptyMessageDelayed(14, 800L);
    }

    public static void ui(QQAppInterface qQAppInterface, long j3, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        oidb_cmd0x74f$ReqBody oidb_cmd0x74f_reqbody = new oidb_cmd0x74f$ReqBody();
        oidb_cmd0x74f_reqbody.uint64_group_code.set(j3);
        ProtoUtils.j(qQAppInterface, troopProtocolObserver, oidb_cmd0x74f_reqbody.toByteArray(), "OidbSvc.0x74f_1", 1871, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FragmentActivity vi() {
        return getActivity();
    }

    protected void Di() {
        qi(false, "inviteMember", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.activity.history.compat.d
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z16, List list) {
                ChatHistoryTroopMemberFragmentV1.this.Pi(z16, list);
            }
        });
        oi("Clk_invite", this.U0, "");
    }

    protected boolean Fi() {
        return this.J0 == 19;
    }

    protected void Hi(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "kickOutDiscussionMember:" + str);
        }
        try {
            if (this.V == null) {
                Dialog dialog = new Dialog(vi(), R.style.qZoneInputDialog);
                this.V = dialog;
                dialog.setContentView(R.layout.account_wait);
                Dialog dialog2 = this.V;
                boolean z16 = true;
                if (this.J0 == 1) {
                    z16 = false;
                }
                dialog2.setCancelable(z16);
                ((TextView) this.V.findViewById(R.id.dialogText)).setText(getString(R.string.f170846at4));
            }
            this.V.show();
            this.A0.e4(Long.parseLong(this.F), Long.valueOf(str).longValue());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "kickOutDiscussionMember:" + e16.toString());
            }
        }
    }

    protected void Zi(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.W1 = "";
        this.f182585l0.clear();
        this.f182589n0.getLayoutParams().height = -1;
        if (str != null && str.trim().length() != 0) {
            this.f182583k0.setVisibility(0);
            String lowerCase = str.toLowerCase();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ITroopRobotService iTroopRobotService = (ITroopRobotService) this.E1.getRuntimeService(ITroopRobotService.class, "all");
            synchronized (this) {
                for (int i3 = 0; i3 < this.T.size(); i3++) {
                    w wVar = this.T.get(i3);
                    if (!this.D1 || !iTroopRobotService.isRobotUin(wVar.f182667a)) {
                        wVar.f182672f = "";
                        wVar.f182673g = "";
                        if (!lowerCase.equalsIgnoreCase(wVar.f182680n) && !lowerCase.equalsIgnoreCase(wVar.f182683q) && !lowerCase.equalsIgnoreCase(wVar.f182682p)) {
                            if (!lowerCase.equalsIgnoreCase(wVar.f182677k) && !lowerCase.equalsIgnoreCase(wVar.f182679m) && !lowerCase.equalsIgnoreCase(wVar.f182678l)) {
                                if (!lowerCase.equalsIgnoreCase(wVar.f182674h) && !lowerCase.equalsIgnoreCase(wVar.f182676j) && !lowerCase.equalsIgnoreCase(wVar.f182675i)) {
                                    if (lowerCase.equals(wVar.f182667a)) {
                                        if (!this.L) {
                                            wVar.f182672f = wVar.f182667a;
                                            arrayList.add(wVar);
                                        }
                                    } else {
                                        if (wVar.f182680n.toLowerCase().indexOf(lowerCase) != 0 && wVar.f182683q.toLowerCase().indexOf(lowerCase) != 0 && wVar.f182682p.toLowerCase().indexOf(lowerCase) != 0) {
                                            if (wVar.f182677k.toLowerCase().indexOf(lowerCase) != 0 && wVar.f182679m.toLowerCase().indexOf(lowerCase) != 0 && wVar.f182678l.toLowerCase().indexOf(lowerCase) != 0) {
                                                if (wVar.f182674h.toLowerCase().indexOf(lowerCase) != 0 && wVar.f182676j.toLowerCase().indexOf(lowerCase) != 0 && wVar.f182675i.toLowerCase().indexOf(lowerCase) != 0) {
                                                    if (wVar.f182667a.indexOf(lowerCase) == 0) {
                                                        if (!this.L) {
                                                            String str2 = wVar.f182667a;
                                                            wVar.f182672f = str2;
                                                            wVar.f182673g = str2;
                                                            arrayList2.add(wVar);
                                                        }
                                                    } else {
                                                        if (wVar.f182680n.toLowerCase().indexOf(lowerCase) <= 0 && wVar.f182683q.toLowerCase().indexOf(lowerCase) <= 0 && wVar.f182682p.toLowerCase().indexOf(lowerCase) <= 0) {
                                                            if (wVar.f182677k.toLowerCase().indexOf(lowerCase) <= 0 && wVar.f182679m.toLowerCase().indexOf(lowerCase) <= 0 && wVar.f182678l.toLowerCase().indexOf(lowerCase) <= 0) {
                                                                if (wVar.f182674h.toLowerCase().indexOf(lowerCase) <= 0 && wVar.f182676j.toLowerCase().indexOf(lowerCase) <= 0 && wVar.f182675i.toLowerCase().indexOf(lowerCase) <= 0) {
                                                                    if (wVar.f182667a.indexOf(lowerCase) > 0 && !this.L) {
                                                                        wVar.f182672f = wVar.f182667a;
                                                                        arrayList3.add(wVar);
                                                                    }
                                                                }
                                                                wVar.f182672f = wVar.f182674h;
                                                                arrayList3.add(wVar);
                                                            }
                                                            wVar.f182672f = wVar.f182677k;
                                                            arrayList3.add(wVar);
                                                        }
                                                        wVar.f182672f = wVar.f182680n;
                                                        arrayList3.add(wVar);
                                                    }
                                                }
                                                wVar.f182672f = wVar.f182674h;
                                                wVar.f182673g = wVar.f182675i;
                                                arrayList2.add(wVar);
                                            }
                                            wVar.f182672f = wVar.f182677k;
                                            wVar.f182673g = wVar.f182678l;
                                            arrayList2.add(wVar);
                                        }
                                        wVar.f182672f = wVar.f182680n;
                                        wVar.f182673g = wVar.f182682p;
                                        arrayList2.add(wVar);
                                    }
                                }
                                wVar.f182672f = wVar.f182674h;
                                arrayList.add(wVar);
                            }
                            wVar.f182672f = wVar.f182677k;
                            arrayList.add(wVar);
                        }
                        wVar.f182672f = wVar.f182680n;
                        arrayList.add(wVar);
                    }
                }
            }
            Collections.sort(arrayList2, new z());
            this.f182585l0.addAll(arrayList);
            this.f182585l0.addAll(arrayList2);
            this.f182585l0.addAll(arrayList3);
            if (this.f182585l0.isEmpty()) {
                this.f182579i0.setVisibility(0);
            } else {
                this.f182579i0.setVisibility(8);
            }
            this.f182587m0.notifyDataSetChanged();
            long currentTimeMillis2 = System.currentTimeMillis();
            com.tencent.imcore.message.report.a.g(this.E1, 8, 2);
            if (QLog.isColorLevel()) {
                QLog.i("ChatHistoryTroopMemberFragmentV1", 2, "refreshSearchResultList:" + lowerCase + "," + (currentTimeMillis2 - currentTimeMillis) + "," + this.f182585l0.size() + "," + this.T.size());
                return;
            }
            return;
        }
        this.f182583k0.setVisibility(8);
        this.f182579i0.setVisibility(8);
        this.f182587m0.notifyDataSetChanged();
    }

    protected w bj(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "removeItem:" + str);
        }
        synchronized (this) {
            for (int i3 = 0; i3 < this.T.size(); i3++) {
                w wVar = this.T.get(i3);
                if (wVar != null && wVar.f182667a.equals(str)) {
                    return this.T.remove(i3);
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x050f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void dj(com.tencent.mobileqq.troop.widget.e eVar, w wVar, boolean z16, boolean z17) {
        String str;
        boolean z18;
        StringBuffer stringBuffer;
        TroopMemberNewLevelView troopMemberNewLevelView;
        TroopMemberNewLevelView troopMemberNewLevelView2;
        TextView textView;
        int i3;
        TroopMemberNewLevelView troopMemberNewLevelView3;
        int i16;
        TroopMemberNewLevelView troopMemberNewLevelView4;
        boolean z19;
        TroopMemberNewLevelView troopMemberNewLevelView5;
        TroopMemberNewLevelView troopMemberNewLevelView6;
        if (z16) {
            str = this.W1;
        } else {
            str = this.V1;
        }
        eVar.isFromSearchList = z16;
        eVar.troopMember.setVisibility(0);
        eVar.divider.setVisibility(8);
        eVar.feedback.setVisibility(8);
        eVar.f187213h.x(1, wVar.f182667a, new e.a().e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(wVar.f182667a)).a());
        if (this.L1 == 1) {
            if (!wVar.E) {
                eVar.f187213h.setAlpha(0.647f);
            } else {
                eVar.f187213h.setAlpha(1.0f);
            }
        } else {
            eVar.f187213h.setAlpha(1.0f);
        }
        fj(getResources(), eVar, wVar);
        if (this.J0 == 13 && z16) {
            String str2 = wVar.f182669c + "(" + wVar.f182667a + ")";
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(-7829368), wVar.f182669c.length(), str2.length(), 18);
            eVar.tvName.setText(spannableString);
        } else if (z17) {
            SpannableString j3 = new com.tencent.mobileqq.text.c(wVar.f182674h, 16).j();
            eVar.tvName.setText(j3);
            com.tencent.mobileqq.vas.f.q(this.E1, eVar.tvName, j3);
        } else {
            SpannableString j16 = new com.tencent.mobileqq.text.c(wVar.f182669c, 16).j();
            eVar.tvName.setText(j16);
            com.tencent.mobileqq.vas.f.q(this.E1, eVar.tvName, j16);
        }
        if (z17 && eVar.remark != null) {
            eVar.remark.setText(HardCodeUtil.qqStr(R.string.kd_) + wVar.f182677k);
        }
        eVar.f187210d = wVar.f182667a;
        eVar.f187211e = 1;
        eVar.identity.setText("");
        if (this.J0 == 9 && (troopMemberNewLevelView6 = eVar.troopMemberNewLevelView) != null) {
            troopMemberNewLevelView6.setVisibility(8);
        }
        eVar.kickoutBtn.setOnClickListener(this.X1);
        eVar.delIcon.setOnClickListener(this.X1);
        eVar.troopMember.setOnClickListener(this.Q1);
        eVar.kickoutBtn.setTag(eVar);
        eVar.delIcon.setTag(eVar);
        eVar.troopMember.setTag(eVar);
        eVar.slideLeftContent.setTag(eVar);
        if (!this.J && !this.K) {
            if (this.J0 == 21) {
                eVar.slideLeftContent.setOnClickListener(null);
                eVar.slideLeftContent.setClickable(false);
            } else {
                eVar.slideLeftContent.setOnClickListener(null);
                eVar.slideLeftContent.setClickable(false);
            }
        } else {
            eVar.slideLeftContent.setOnClickListener(this.X1);
            eVar.slideLeftContent.setClickable(true);
            if (this.K) {
                eVar.troopMember.setOnClickListener(null);
            }
        }
        int i17 = this.J0;
        if (i17 != 1 && i17 != 13) {
            TextUtils.isEmpty(wVar.A);
            MemberRole memberRole = wVar.M;
            boolean z26 = memberRole == MemberRole.OWNER;
            boolean z27 = memberRole == MemberRole.ADMIN;
            boolean equals = this.E1.getCurrentAccountUin().equals(wVar.f182667a);
            boolean z28 = z26 && equals;
            if (this.J0 == 5) {
                eVar.mUniqueTitle.setVisibility(0);
                TroopMemberNewLevelView troopMemberNewLevelView7 = eVar.troopMemberNewLevelView;
                if (troopMemberNewLevelView7 != null) {
                    troopMemberNewLevelView7.setVisibility(8);
                }
                eVar.honorView.setVisibility(8);
                com.tencent.mobileqq.troop.troopmemberlevel.a troopMemberRankItem_Unique = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem_Unique(this.f182597r0, wVar.N);
                if (troopMemberRankItem_Unique != null && (troopMemberNewLevelView5 = eVar.troopMemberNewLevelView) != null) {
                    troopMemberNewLevelView5.setTroopMemberNewLevel(troopMemberRankItem_Unique);
                }
            } else {
                TroopInfo troopInfo = this.f182597r0;
                if (((troopInfo != null ? troopInfo.isQidianPrivateTroop() : false) || this.E) && Fi() && !wVar.f182667a.equals(this.E1.getCurrentAccountUin())) {
                    eVar.mRightArrow.setVisibility(0);
                }
                TroopMemberNewLevelView troopMemberNewLevelView8 = eVar.troopMemberNewLevelView;
                if (troopMemberNewLevelView8 != null) {
                    troopMemberNewLevelView8.setVisibility(8);
                    com.tencent.mobileqq.troop.troopmemberlevel.a troopMemberRankItem = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem(this.f182597r0, wVar.N);
                    if (troopMemberRankItem == null) {
                        return;
                    } else {
                        eVar.troopMemberNewLevelView.setTroopMemberNewLevel(troopMemberRankItem);
                    }
                }
                ITroopHonorService iTroopHonorService = (ITroopHonorService) this.E1.getRuntimeService(ITroopHonorService.class, "");
                if (iTroopHonorService.isSupportTroopHonor(this.G)) {
                    TroopMemberInfo troopMemberInfo = wVar.N;
                    List<com.tencent.mobileqq.troop.honor.config.a> convertToHonorList = iTroopHonorService.convertToHonorList(troopMemberInfo.honorList, Byte.valueOf(troopMemberInfo.mHonorRichFlag));
                    if (convertToHonorList != null && convertToHonorList.size() > 0) {
                        eVar.honorView.setHonorList(convertToHonorList, 2);
                        eVar.honorView.setVisibility(0);
                        i16 = 8;
                    } else {
                        eVar.honorView.setHonorList(null);
                        i16 = 8;
                        eVar.honorView.setVisibility(8);
                    }
                } else {
                    i16 = 8;
                    eVar.honorView.setHonorList(null);
                    eVar.honorView.setVisibility(8);
                }
                if (this.E && (troopMemberNewLevelView4 = eVar.troopMemberNewLevelView2) != null) {
                    troopMemberNewLevelView4.setVisibility(i16);
                    if (z26) {
                        com.tencent.mobileqq.troop.troopmemberlevel.a aVar = new com.tencent.mobileqq.troop.troopmemberlevel.a();
                        aVar.f300596g = true;
                        aVar.f300595f = false;
                        aVar.f300590a = 300;
                        aVar.f300593d = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(aVar.f300590a);
                        aVar.f300597h = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTextColor(aVar.f300590a);
                        aVar.f300592c = HardCodeUtil.qqStr(R.string.upl);
                        eVar.troopMemberNewLevelView2.setTroopMemberNewLevel(aVar);
                    } else if (z27) {
                        com.tencent.mobileqq.troop.troopmemberlevel.a aVar2 = new com.tencent.mobileqq.troop.troopmemberlevel.a();
                        aVar2.f300596g = true;
                        aVar2.f300595f = false;
                        aVar2.f300590a = 301;
                        aVar2.f300593d = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(aVar2.f300590a);
                        aVar2.f300597h = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTextColor(aVar2.f300590a);
                        aVar2.f300592c = HardCodeUtil.qqStr(R.string.upa);
                        eVar.troopMemberNewLevelView2.setTroopMemberNewLevel(aVar2);
                    }
                }
                int i18 = this.J0;
                if (i18 != 9 && i18 != 12) {
                    String str3 = wVar.f182667a;
                    if (str3 != null && str3.equals(this.E1.getCurrentAccountUin())) {
                        eVar.identity.setText(getString(R.string.cfm));
                    } else {
                        eVar.identity.setText("");
                    }
                }
            }
            ITroopRobotService iTroopRobotService = (ITroopRobotService) this.E1.getRuntimeService(ITroopRobotService.class, "all");
            boolean z29 = iTroopRobotService != null && iTroopRobotService.isRobotUin(wVar.f182667a);
            if (this.J) {
                if (this.J0 != 21 && (z26 || ((!z28 && z27) || (!z28 && z29)))) {
                    eVar.delIcon.setVisibility(8);
                    eVar.troopMember.c(false);
                } else {
                    eVar.delIcon.setVisibility(0);
                    eVar.delIconInner.setBackgroundResource(R.drawable.bxk);
                    if (str.equals(wVar.f182667a)) {
                        eVar.troopMember.b(false);
                    } else {
                        eVar.troopMember.c(false);
                    }
                }
            } else {
                if (this.K) {
                    if (z26 || (!z28 && z27) || equals) {
                        eVar.delIcon.setVisibility(8);
                    } else {
                        eVar.delIcon.setVisibility(0);
                        if (this.U.H.contains(wVar)) {
                            eVar.delIconInner.setBackgroundResource(R.drawable.list_checkbox_selected);
                            z19 = true;
                            z18 = z19;
                        } else {
                            eVar.delIconInner.setBackgroundResource(R.drawable.list_checkbox);
                        }
                    }
                    z19 = false;
                    z18 = z19;
                } else if (this.J0 == 20) {
                    eVar.delIcon.setVisibility(0);
                    if (wVar.f182667a != null && this.U.G.contains(wVar)) {
                        eVar.delIconInner.setBackgroundResource(R.drawable.list_checkbox_selected);
                        z18 = true;
                    } else {
                        eVar.delIconInner.setBackgroundResource(R.drawable.list_checkbox);
                    }
                } else {
                    eVar.delIcon.setVisibility(8);
                    eVar.troopMember.c(false);
                }
                if (eVar.mRobotMsk != null) {
                    ITroopRobotService iTroopRobotService2 = (ITroopRobotService) this.E1.getRuntimeService(ITroopRobotService.class, "all");
                    if (iTroopRobotService2 != null && iTroopRobotService2.isRobotUin(wVar.f182667a)) {
                        eVar.mRobotMsk.setVisibility(0);
                        TroopMemberNewLevelView troopMemberNewLevelView9 = eVar.troopMemberNewLevelView;
                        if (troopMemberNewLevelView9 != null) {
                            if (wVar.N.role == MemberRole.ADMIN) {
                                com.tencent.mobileqq.troop.troopmemberlevel.a aVar3 = new com.tencent.mobileqq.troop.troopmemberlevel.a();
                                aVar3.f300596g = true;
                                aVar3.f300595f = false;
                                aVar3.f300590a = 301;
                                aVar3.f300593d = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(aVar3.f300590a);
                                aVar3.f300597h = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTextColor(aVar3.f300590a);
                                aVar3.f300592c = HardCodeUtil.qqStr(R.string.upa);
                                eVar.troopMemberNewLevelView.setTroopMemberNewLevel(aVar3);
                            } else {
                                i3 = 8;
                                troopMemberNewLevelView9.setVisibility(8);
                                troopMemberNewLevelView3 = eVar.troopMemberNewLevelView2;
                                if (troopMemberNewLevelView3 != null) {
                                    troopMemberNewLevelView3.setVisibility(i3);
                                }
                            }
                        }
                        i3 = 8;
                        troopMemberNewLevelView3 = eVar.troopMemberNewLevelView2;
                        if (troopMemberNewLevelView3 != null) {
                        }
                    } else {
                        eVar.mRobotMsk.setVisibility(8);
                    }
                }
                stringBuffer = new StringBuffer();
                stringBuffer.append(eVar.tvName.getText().toString());
                if (z17 && (textView = eVar.remark) != null) {
                    stringBuffer.append(textView.getText());
                }
                troopMemberNewLevelView = eVar.troopMemberNewLevelView;
                if (troopMemberNewLevelView != null && troopMemberNewLevelView.getVisibility() == 0) {
                    stringBuffer.append(eVar.troopMemberNewLevelView.getContentDescription());
                }
                troopMemberNewLevelView2 = eVar.troopMemberNewLevelView2;
                if (troopMemberNewLevelView2 != null && troopMemberNewLevelView2.getVisibility() == 0) {
                    stringBuffer.append(eVar.troopMemberNewLevelView2.getContentDescription());
                }
                if (eVar.honorView.getVisibility() == 0) {
                    stringBuffer.append(eVar.honorView.a());
                }
                if (eVar.delIcon.getVisibility() == 0 && this.K) {
                    stringBuffer.append(!z18 ? "\u5df2\u9009\u4e2d" : "\u672a\u9009\u4e2d");
                }
                eVar.slideLeftContent.setContentDescription(stringBuffer.toString());
            }
        } else {
            eVar.tvName.setContentDescription(getString(R.string.atr) + eVar.tvName.getText().toString());
            eVar.delIconInner.setBackgroundResource(R.drawable.bxk);
            int i19 = this.J0;
            if (i19 == 13) {
                eVar.delIcon.setVisibility(0);
            } else if (i19 == 21) {
                eVar.delIcon.setVisibility(0);
            } else {
                String str4 = this.M;
                if (str4 != null && !wVar.f182667a.equals(str4)) {
                    eVar.delIcon.setVisibility(0);
                } else {
                    eVar.delIcon.setVisibility(8);
                    eVar.troopMember.c(false);
                }
            }
            if (str.equals(wVar.f182667a)) {
                eVar.troopMember.b(false);
            } else {
                eVar.troopMember.c(false);
            }
            eVar.delIcon.setContentDescription(String.format(getString(R.string.at6), eVar.tvName.getText().toString()));
            eVar.kickoutBtn.setContentDescription(getString(R.string.at5));
        }
        z18 = false;
        if (eVar.mRobotMsk != null) {
        }
        stringBuffer = new StringBuffer();
        stringBuffer.append(eVar.tvName.getText().toString());
        if (z17) {
            stringBuffer.append(textView.getText());
        }
        troopMemberNewLevelView = eVar.troopMemberNewLevelView;
        if (troopMemberNewLevelView != null) {
            stringBuffer.append(eVar.troopMemberNewLevelView.getContentDescription());
        }
        troopMemberNewLevelView2 = eVar.troopMemberNewLevelView2;
        if (troopMemberNewLevelView2 != null) {
            stringBuffer.append(eVar.troopMemberNewLevelView2.getContentDescription());
        }
        if (eVar.honorView.getVisibility() == 0) {
        }
        if (eVar.delIcon.getVisibility() == 0) {
            stringBuffer.append(!z18 ? "\u5df2\u9009\u4e2d" : "\u672a\u9009\u4e2d");
        }
        eVar.slideLeftContent.setContentDescription(stringBuffer.toString());
    }

    public int getTitleBarHeight() {
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        return false;
    }

    protected void hi() {
        if (this.U != null && QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, String.format("checkShowCharIndexView item: %s, other: %s, char: %s", Integer.valueOf(this.U.L), Integer.valueOf(this.U.M), Integer.valueOf(this.U.K)));
        }
        int visibility = this.f182591o0.getVisibility();
        if (this.L1 == 0) {
            int i3 = this.J0;
            if (i3 == 11) {
                ListAdapter listAdapter = this.U;
                if (listAdapter != null && listAdapter.L > 6 && listAdapter.K > 1) {
                    this.f182591o0.setVisibility(0);
                }
            } else if (i3 != 0 && i3 != 18) {
                ListAdapter listAdapter2 = this.U;
                if (listAdapter2 != null && listAdapter2.L >= this.B1 && listAdapter2.K > 1) {
                    this.f182591o0.setVisibility(0);
                } else {
                    this.f182591o0.setVisibility(4);
                }
            } else {
                ListAdapter listAdapter3 = this.U;
                if (listAdapter3 != null && listAdapter3.L + listAdapter3.M >= this.B1 && listAdapter3.K > 1) {
                    this.f182591o0.setVisibility(0);
                } else {
                    this.f182591o0.setVisibility(4);
                }
            }
        } else {
            this.f182591o0.setVisibility(4);
        }
        if (visibility != this.f182591o0.getVisibility()) {
            mj();
        }
    }

    protected void ii() {
        if (this.J0 == 11) {
            ReportController.o(this.E1, "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
        }
        com.tencent.imcore.message.report.a.f(this.E1, 8, 2);
        ReportController.o(this.E1, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 7, 0, "", "", "", "");
        int height = this.W.getHeight();
        float f16 = -height;
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, f16);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        this.f182571e0.startAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, f16, 0.0f);
        translateAnimation2.setDuration(300L);
        translateAnimation.setAnimationListener(new c(translateAnimation, translateAnimation2, height));
        this.O1.setOnDismissListener(new d());
        this.f182575g0.setText("");
        this.f182575g0.setSelection(0);
        this.f182575g0.requestFocus();
        ((TextView) this.O1.findViewById(R.id.f658039x)).setOnClickListener(new e());
        this.f182585l0.clear();
        this.f182587m0.notifyDataSetChanged();
        this.f182611y0 = true;
    }

    @Override // com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface
    public Object invoke(int i3, Object... objArr) {
        return null;
    }

    protected void ji() {
        if (this.V == null) {
            Dialog dialog = new Dialog(vi(), R.style.qZoneInputDialog);
            this.V = dialog;
            dialog.setContentView(R.layout.account_wait);
            this.V.setCancelable(this.J0 != 1);
            ((TextView) this.V.findViewById(R.id.dialogText)).setText(getString(R.string.hex));
        }
    }

    protected void jj() {
        String str = "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.G;
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(vi(), IPublicAccountBrowser.ROUTE_NAME);
        activityURIRequest.extra().putString("url", str);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "showMemberDstribute:" + str);
        }
        oi("Clk_mberdist", this.U0, "");
    }

    public w ki(DiscussionMemberInfo discussionMemberInfo, FriendsManager friendsManager) {
        String str;
        w wVar = new w();
        wVar.f182667a = discussionMemberInfo.memberUin.trim();
        Friends u16 = friendsManager != null ? friendsManager.u(discussionMemberInfo.memberUin) : null;
        String discussionMemberName = discussionMemberInfo.getDiscussionMemberName();
        wVar.f182669c = discussionMemberName;
        wVar.f182670d = ChnToSpell.d(discussionMemberName, 2);
        wVar.b(ChnToSpell.d(wVar.f182669c, 1));
        if (u16 != null && u16.isFriend() && (str = u16.remark) != null && str.length() > 0) {
            wVar.i(u16.remark);
            wVar.d(ChnToSpell.d(wVar.f182677k, 1));
            wVar.g(ChnToSpell.d(wVar.f182677k, 2));
        } else {
            String str2 = discussionMemberInfo.inteRemark;
            if (str2 != null && str2.length() > 0) {
                wVar.i(discussionMemberInfo.inteRemark);
                wVar.d(ChnToSpell.d(discussionMemberInfo.inteRemark, 1));
                wVar.g(ChnToSpell.d(discussionMemberInfo.inteRemark, 2));
            }
        }
        String str3 = discussionMemberInfo.memberName;
        if (str3 != null && str3.length() > 0) {
            wVar.k(discussionMemberInfo.memberName);
            wVar.e(ChnToSpell.d(discussionMemberInfo.memberName, 1));
            wVar.h(ChnToSpell.d(discussionMemberInfo.memberName, 2));
        }
        return wVar;
    }

    void kj() {
        ViewStub viewStub;
        if (this.W0 || (viewStub = (ViewStub) findViewById(R.id.k1_)) == null) {
            return;
        }
        ((LinearLayout) viewStub.inflate().findViewById(R.id.k1a)).setOnTouchListener(new o());
    }

    public w li(TroopMemberInfo troopMemberInfo, FriendsManager friendsManager) {
        String str;
        w wVar = new w();
        wVar.f182667a = troopMemberInfo.memberuin.trim();
        wVar.f182668b = troopMemberInfo.memberUid.trim();
        Friends u16 = friendsManager != null ? friendsManager.u(troopMemberInfo.memberuin) : null;
        String showName = troopMemberInfo.nickInfo.getUIInfo(true, true).getShowName();
        wVar.f182669c = showName;
        wVar.f182670d = ChnToSpell.d(showName, 2);
        wVar.b(ChnToSpell.d(wVar.f182669c, 1));
        String str2 = troopMemberInfo.friendnick;
        if (str2 != null && str2.length() > 0) {
            wVar.a(troopMemberInfo.friendnick);
            wVar.c(ChnToSpell.d(troopMemberInfo.friendnick, 1));
            wVar.f(ChnToSpell.d(troopMemberInfo.friendnick, 2));
        }
        if (u16 != null && u16.isFriend() && (str = u16.remark) != null && str.length() > 0) {
            wVar.i(u16.remark);
            wVar.d(ChnToSpell.d(wVar.f182677k, 1));
            wVar.g(ChnToSpell.d(wVar.f182677k, 2));
            wVar.j(u16.remark);
        } else {
            String str3 = troopMemberInfo.autoremark;
            if (str3 != null && str3.length() > 0) {
                if (this.L && troopMemberInfo.autoremark.equals(troopMemberInfo.memberuin)) {
                    String str4 = TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
                    wVar.i(str4);
                    wVar.d(ChnToSpell.d(str4, 1));
                    wVar.g(ChnToSpell.d(str4, 2));
                } else {
                    wVar.i(troopMemberInfo.autoremark);
                    wVar.d(ChnToSpell.d(troopMemberInfo.autoremark, 1));
                    wVar.g(ChnToSpell.d(troopMemberInfo.autoremark, 2));
                }
            }
        }
        String str5 = troopMemberInfo.troopColorNick;
        if (str5 != null && str5.length() > 0) {
            wVar.k(troopMemberInfo.troopColorNick);
            wVar.e(ChnToSpell.d(troopMemberInfo.troopnick, 1));
            wVar.h(ChnToSpell.d(troopMemberInfo.troopnick, 2));
        }
        wVar.f182687u = troopMemberInfo.last_active_time;
        wVar.f182685s = troopMemberInfo.join_time;
        wVar.f182690x = troopMemberInfo.titleId;
        wVar.f182691y = troopMemberInfo.credit_level;
        wVar.f182692z = troopMemberInfo.isTroopFollowed;
        wVar.C = troopMemberInfo.mIsShielded;
        TroopMemberSpecialTitleInfo troopMemberSpecialTitleInfo = troopMemberInfo.specialTitleInfo;
        if (troopMemberSpecialTitleInfo != null && !troopMemberSpecialTitleInfo.isExpired()) {
            wVar.A = troopMemberInfo.getSpecialTitleStr();
            wVar.B = troopMemberInfo.specialTitleInfo.getExpireTimeSec();
        }
        wVar.F = troopMemberInfo.mVipType;
        wVar.G = troopMemberInfo.mBigClubVipType;
        wVar.M = troopMemberInfo.role;
        wVar.N = troopMemberInfo;
        return wVar;
    }

    protected List<w> lj(List<w> list) {
        int size = list.size();
        if (size > 0) {
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                w wVar = list.get(i3);
                if (wVar.M == MemberRole.OWNER) {
                    list.remove(i3);
                    list.add(0, wVar);
                    break;
                }
                i3++;
            }
            int i16 = 1;
            for (int i17 = 1; i17 < size; i17++) {
                w wVar2 = list.get(i17);
                if (wVar2.M == MemberRole.ADMIN && wVar2.f182690x == 332) {
                    list.remove(i17);
                    list.add(i16, wVar2);
                    i16++;
                }
            }
            for (int i18 = 1; i18 < size; i18++) {
                w wVar3 = list.get(i18);
                if (wVar3.M == MemberRole.ADMIN && wVar3.f182690x == 333) {
                    list.remove(i18);
                    list.add(i16, wVar3);
                    i16++;
                }
            }
            int i19 = i16;
            while (i16 < size) {
                w wVar4 = list.get(i16);
                if (wVar4.f182690x == 332) {
                    list.remove(i16);
                    list.add(i19, wVar4);
                    i19++;
                }
                i16++;
            }
            int i26 = i19;
            while (i19 < size) {
                w wVar5 = list.get(i19);
                if (wVar5.f182690x == 333) {
                    list.remove(i19);
                    list.add(i26, wVar5);
                    i26++;
                }
                i19++;
            }
            int i27 = i26;
            while (i26 < size) {
                w wVar6 = list.get(i26);
                if (wVar6.M == MemberRole.ADMIN) {
                    list.remove(i26);
                    list.add(i27, wVar6);
                    i27++;
                }
                i26++;
            }
        }
        return list;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.I0 = true;
        try {
            this.P1.removeCallbacksAndMessages(null);
        } catch (Exception unused) {
        }
        try {
            this.E1.removeObserver(this.Z1);
            this.E1.removeObserver(this.f182568c2);
            this.E1.removeObserver(this.Y1);
            this.E1.removeObserver(this.f182562a2);
            this.E1.removeObserver(this.f182565b2);
        } catch (Exception unused2) {
        }
        y yVar = this.f182587m0;
        if (yVar != null) {
            yVar.destroy();
        }
        Dialog dialog = this.V;
        if (dialog != null && dialog.isShowing()) {
            this.V.dismiss();
        }
        ListAdapter listAdapter = this.U;
        if (listAdapter != null) {
            listAdapter.destroy();
        }
        ActionSheet actionSheet = this.f182605v0;
        if (actionSheet != null && actionSheet.isShowing()) {
            this.f182605v0.dismiss();
        }
        Dialog dialog2 = this.O1;
        if (dialog2 == null || !dialog2.isShowing()) {
            return;
        }
        this.O1.dismiss();
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        if ("$".equals(str)) {
            this.C.setSelection(0);
            return;
        }
        int i3 = this.U.i(str);
        if (i3 != -1) {
            PinnedDividerSwipListView pinnedDividerSwipListView = this.C;
            pinnedDividerSwipListView.setSelection(i3 + pinnedDividerSwipListView.getHeaderViewsCount());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        vi().getWindow().setSoftInputMode(16);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        this.F1.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.qui_common_bg_bottom_standard_bg));
        this.F1.invalidate();
        QLog.d("ChatHistoryTroopMemberFragmentV1", 1, "onPostThemeChanged: update Token UI");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            vi().getWindow().setSoftInputMode(48);
        } catch (Exception unused) {
        }
        View view = this.W;
        if (view != null) {
            view.destroyDrawingCache();
            this.W.requestLayout();
            this.W.invalidate();
        }
        ReportController.o(this.E1, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 7, 0, "", "", "", "");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String str;
        TroopInfo troopInfo;
        TroopInfo k3;
        super.onViewCreated(view, bundle);
        this.E1 = (QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime();
        Bundle arguments = getArguments();
        this.G = arguments.getString(IGroupTeamWorkHandler.KEY_GROUP_CODE);
        this.H = arguments.getString(AppConstants.Key.TROOP_INFO_NAME);
        this.I = arguments.getString("troop_gift_from");
        this.f182595q0 = arguments.getString(AppConstants.LeftViewText.LEFTVIEWTEXT);
        this.J0 = 18;
        this.K0 = arguments.getString("param_troop_fee_project_id");
        this.L0 = arguments.getInt("param_troop_fee_entrance_type", -1);
        this.I1 = arguments.getString("callback");
        int i3 = 0;
        this.X0 = arguments.getBoolean("param_troop_send_apollo_msg", false);
        this.Y0 = arguments.getBoolean("param_troop_send_zplan_msg", false);
        this.U1 = arguments.getInt(AppConstants.Key.TROOP_INFO_MEMBER_NUM, 0);
        this.L1 = arguments.getInt("sort_type", 0);
        this.O0 = arguments.getInt("param_pick_max_num", this.O0);
        this.f182590n1 = arguments.getStringArrayList("param_pick_selected_list");
        this.E0 = arguments.getStringArrayList("param_delete_filter_member_list");
        this.F0 = arguments.getStringArrayList("param_hide_filter_member_list");
        this.f182610x1 = arguments.getInt("param_pick_max_num_exceeds_wording", R.string.f171400er0);
        this.N0 = arguments.getString("param_pick_title_string", this.N0);
        this.D1 = arguments.getBoolean("param_filter_robot", false);
        if (this.J0 == 17) {
            new com.tencent.mobileqq.statistics.q(this.E1).i("dc00899").a("Grp_online").f("mber_list").d("exp_onlineList").c(1).b(this.G).g();
        }
        if (this.J0 == 22) {
            eu.g("Grp_idol", "mber_list", "exp", 0, 0, this.G);
        }
        if (this.J0 == 9 && TextUtils.isEmpty(this.K0) && QLog.isColorLevel()) {
            QLog.e("ChatHistoryTroopMemberFragmentV1.troop.troop_fee", 2, "TextUtils.isEmpty(mTroopFeeProjectId)");
        }
        if (this.J0 == 14) {
            this.L1 = 7;
            this.f182604u1 = false;
        }
        this.R = arguments.getInt("param_chat_mode", 0);
        this.M0 = arguments.getString("custom_title_name");
        String string = arguments.getString(ISelectMemberActivityConstants.PARAM_FROM);
        if (string != null) {
            try {
                this.J0 = Integer.parseInt(string);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "doOnCreate, troopCode=" + this.G + " troopUin=" + this.F + " from=" + this.J0);
        }
        TroopManager troopManager = (TroopManager) this.E1.getManager(QQManagerFactory.TROOP_MANAGER);
        this.L = troopManager.V(this.G);
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "doOnCreate, mIsQidianPrivateTroop = " + this.L + ", mTroopUin = " + this.G);
        }
        if (this.U1 == 0 && (k3 = troopManager.k(this.G)) != null) {
            this.U1 = k3.wMemberNum;
        }
        try {
            this.C1 = ThemeUtil.isDefaultTheme();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (this.J0 == 15) {
            this.L1 = 6;
            this.f182578h1 = arguments.getStringArrayList(TroopMemberListActivity.PARAM_SEQ_DAYS);
            this.f182576g1 = arguments.getStringArrayList(TroopMemberListActivity.PARAM_SEQ_NAME);
        }
        int i16 = this.L1;
        if (i16 == 1 || i16 == 8) {
            ((com.tencent.mobileqq.troop.onlinemember.api.a) this.E1.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_MEMBER_HANDLER)).i0(this.G);
        }
        this.A0 = (DiscussionHandler) this.E1.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        this.f182603u0 = vi().getLayoutInflater();
        this.S = getResources().getDisplayMetrics().density;
        TroopManager troopManager2 = (TroopManager) this.E1.getManager(QQManagerFactory.TROOP_MANAGER);
        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) this.E1.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (troopManager2 != null && nVar != null) {
            int i17 = this.J0;
            if (i17 != 1 && i17 != 11 && i17 != 16) {
                TroopInfo k16 = troopManager2.k(this.G);
                this.f182597r0 = k16;
                this.f182599s0.troopUin = this.G;
                this.E = k16 != null && k16.isHomeworkTroop();
                this.f182599s0.updateForTroopInfo(this.f182597r0, this.E1.getCurrentAccountUin());
                TroopInfo troopInfo2 = this.f182597r0;
                if (troopInfo2 != null) {
                    this.F = troopInfo2.troopcode;
                    this.W0 = TroopInfo.hasPayPrivilege(troopInfo2.troopPrivilegeFlag, 32);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e("ChatHistoryTroopMemberFragmentV1", 2, "doOnCreate, mTroopInfo is null");
                    }
                    vi().finish();
                    return;
                }
            } else {
                this.f182601t0 = nVar.h(this.G);
                this.F = this.G;
            }
            if (this.J0 == 5 && (troopInfo = this.f182597r0) != null && !troopInfo.isTroopOwner(this.E1.getCurrentAccountUin())) {
                getActivity().finish();
                return;
            }
            this.E1.addObserver(this.Z1, true);
            this.E1.addObserver(this.f182568c2, true);
            this.E1.addObserver(this.Y1, true);
            this.E1.addObserver(this.f182562a2, true);
            this.E1.addObserver(this.f182565b2, true);
            if (Ei() && this.J0 == 3) {
                this.L1 = 2;
            }
            if (this.J0 != 1) {
                this.J = false;
                TroopInfo troopInfo3 = this.f182597r0;
                if (troopInfo3 != null) {
                    String str2 = troopInfo3.troopowneruin;
                    if (str2 != null) {
                        this.M = str2;
                    }
                    this.D = troopInfo3.isOwnerOrAdmin();
                } else if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "doOnCreate, mTroopInfo==null");
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "doOnCreate, mTroopInfo admin:   owner:" + this.M);
                }
            }
            if (this.J0 == 21) {
                this.J = true;
            }
            TroopInfo troopInfo4 = this.f182597r0;
            if (troopInfo4 != null && troopInfo4.isKingBattleTroop()) {
                this.D0 = true;
            }
            String[] stringArray = getResources().getStringArray(R.array.f155256c7);
            if (!this.D0) {
                this.f182592o1 = stringArray;
            } else {
                this.f182592o1 = new String[stringArray.length + 1];
                int length = stringArray.length;
                int i18 = 0;
                int i19 = 0;
                while (i18 < length) {
                    this.f182592o1[i19] = stringArray[i18];
                    i18++;
                    i19++;
                }
                this.f182592o1[i19] = getResources().getString(R.string.vts);
            }
            String[] stringArray2 = getResources().getStringArray(R.array.f155255c6);
            if (!this.D0) {
                this.f182594p1 = stringArray2;
            } else {
                this.f182594p1 = new String[stringArray2.length + 1];
                int length2 = stringArray2.length;
                int i26 = 0;
                while (i3 < length2) {
                    this.f182594p1[i26] = stringArray2[i3];
                    i3++;
                    i26++;
                }
                this.f182594p1[i26] = getResources().getString(R.string.vtt);
            }
            Bi();
            ri();
            cj();
            int i27 = this.J0;
            String str3 = "1";
            if (i27 == 0) {
                str = "0";
            } else if (i27 == 2) {
                str = "3";
            } else if (i27 == 3) {
                str = "2";
            } else if (i27 == 4) {
                str = "1";
            } else {
                str = "4";
            }
            TroopInfo troopInfo5 = this.f182597r0;
            if (troopInfo5 != null && troopInfo5.isOwner()) {
                str3 = "0";
            } else {
                TroopInfo troopInfo6 = this.f182597r0;
                if (troopInfo6 == null || !troopInfo6.isOwnerOrAdmin()) {
                    str3 = "2";
                }
            }
            this.U0 = str3;
            oi("exp", str, str3);
            if (this.J0 == 14) {
                kj();
            }
            if (this.J0 == 18) {
                ReportController.o(this.E1, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_exp", 0, 0, this.G, "", "", "");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "doOnCreate, app.getManager(QQAppInterface.FRIEND_MANAGER) is null");
        }
        vi().finish();
    }

    @Override // com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface
    public void q8(IHistoryBridgeInterface.b bVar) {
        this.G1 = bVar;
    }

    protected void ri() {
        Runnable runnable;
        startTitleProgress();
        int i3 = this.J0;
        if (i3 == 9) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.i
                @Override // java.lang.Runnable
                public final void run() {
                    ChatHistoryTroopMemberFragmentV1.this.Ki();
                }
            }, 128, null, true);
            return;
        }
        if (i3 != 15 && i3 != 1 && i3 != 11 && i3 != 16) {
            Handler handler = this.P1;
            handler.sendMessage(handler.obtainMessage(13));
            runnable = null;
        } else {
            runnable = new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.j
                @Override // java.lang.Runnable
                public final void run() {
                    ChatHistoryTroopMemberFragmentV1.this.Li();
                }
            };
        }
        int i16 = this.J0;
        if (i16 != 11 && i16 != 1 && i16 != 16 && NetworkUtil.isNetworkAvailable(getActivity())) {
            this.f182609x0 = true;
            this.S0 = System.currentTimeMillis();
            pi();
        }
        if (runnable != null) {
            ThreadManagerV2.excute(runnable, 32, null, true);
        }
    }

    void stopTitleProgress() {
        this.P1.removeMessages(14);
        RelativeLayout relativeLayout = this.f182582j1;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.f182582j1.setVisibility(8);
    }

    protected synchronized Object[] wi(String str) {
        int i3;
        DiscussionInfo discussionInfo;
        this.T.clear();
        try {
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "getDiscussionMemberFromDB, uin:" + str);
            }
            long currentTimeMillis = System.currentTimeMillis();
            FriendsManager friendsManager = (FriendsManager) this.E1.getManager(QQManagerFactory.FRIENDS_MANAGER);
            this.f182613z0 = ((com.tencent.mobileqq.app.n) this.E1.getManager(QQManagerFactory.DISCUSSION_MANAGER)).m(str);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "getDiscussionMemberFromDB, queryTime:" + (currentTimeMillis2 - currentTimeMillis));
            }
            List<DiscussionMemberInfo> list = this.f182613z0;
            if (list != null) {
                i3 = list.size();
                for (int i16 = 0; i16 < i3; i16++) {
                    DiscussionMemberInfo discussionMemberInfo = this.f182613z0.get(i16);
                    if (discussionMemberInfo != null) {
                        String str2 = discussionMemberInfo.memberUin;
                        if (str2 != null && str2.trim().length() > 0 && !discussionMemberInfo.memberUin.trim().equalsIgnoreCase("0")) {
                            if ((this.J0 != 2 || !discussionMemberInfo.memberUin.equals(this.M)) && (this.J0 != 1 || (discussionInfo = this.f182601t0) == null || !discussionMemberInfo.memberUin.equals(discussionInfo.inheritOwnerUin))) {
                                this.T.add(ki(discussionMemberInfo, friendsManager));
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "getDiscussionMemberFromDB, continued:" + discussionMemberInfo.memberUin);
                        }
                    }
                }
                if (this.E1.getProxyManager() != null) {
                    this.E1.getProxyManager().notifyRefreshTroopMember();
                }
            } else {
                i3 = 0;
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "getDiscussionMemberFromDB, TotalTime:" + (currentTimeMillis3 - currentTimeMillis) + ", listSize:" + this.T.size() + ", dbSize:" + i3);
            }
            Object[] g16 = this.U.g();
            if (g16 == null || g16.length != 3) {
                return null;
            }
            return new Object[]{g16[0], g16[1], g16[2]};
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "getDiscussionMemberFromDB:" + e16.toString());
            }
            return null;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "getDiscussionMemberFromDB:" + e17.toString());
            }
            return null;
        }
    }

    public String xi(long j3, Calendar calendar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList2.size() != 0 && arrayList.size() != 0) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j3 * 1000);
            int i3 = (((calendar.get(1) - calendar2.get(1)) * 365) + calendar.get(6)) - calendar2.get(6);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                if (i3 >= Integer.parseInt(arrayList.get(size))) {
                    return arrayList2.get(size);
                }
            }
        }
        return null;
    }

    protected synchronized void yi(String str, final List<String> list) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberUinListInfo(str, list, false, this, "ChatHistoryTroopMemberFragmentV1", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.activity.history.compat.p
                @Override // com.tencent.qqnt.troopmemberlist.f
                public final void a(boolean z16, List list2) {
                    ChatHistoryTroopMemberFragmentV1.this.Mi(list, currentTimeMillis, z16, list2);
                }
            });
        } catch (NumberFormatException unused) {
            QLog.e("ChatHistoryTroopMemberFragmentV1", 1, "[getMemberListFromUins] groupUin parese error");
        }
    }

    protected synchronized void zi(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "getTroopMemberFromDB, uin:" + str);
        }
        this.T1 = System.currentTimeMillis();
        qi(false, QZoneAppCtrlUploadFileLogic.DB_PATH, new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.activity.history.compat.e
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z16, List list) {
                ChatHistoryTroopMemberFragmentV1.this.Oi(z16, list);
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class i extends ct2.b {
        i() {
        }

        @Override // ct2.b
        protected void b(String str, String str2, String str3) {
            String str4;
            if (str == null || (str4 = ChatHistoryTroopMemberFragmentV1.this.f182597r0.troopuin) == null || !str.equals(str4)) {
                return;
            }
            ChatHistoryTroopMemberFragmentV1.this.bj(str2);
            Handler handler = ChatHistoryTroopMemberFragmentV1.this.P1;
            handler.sendMessage(handler.obtainMessage(9));
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class k extends com.tencent.mobileqq.troop.observer.g {
        k() {
        }

        @Override // com.tencent.mobileqq.troop.observer.g
        protected void a(boolean z16, List<cmd0x406$GroupFeeMember> list) {
            if (!z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryTroopMemberFragmentV1.troop.troop_fee", 2, "onGetTroopFeeMemberList : isSuccess=" + z16);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (cmd0x406$GroupFeeMember cmd0x406_groupfeemember : list) {
                w wVar = new w();
                wVar.f182667a = cmd0x406_groupfeemember.uint64_uin.get() + "";
                wVar.f182669c = cmd0x406_groupfeemember.string_nick_name.get();
                arrayList.add(wVar);
            }
            ChatHistoryTroopMemberFragmentV1.this.H0 = list.size();
            Handler handler = ChatHistoryTroopMemberFragmentV1.this.P1;
            handler.sendMessage(handler.obtainMessage(1, new Object[]{arrayList}));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class m implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f182652d;

        m(String str) {
            this.f182652d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
            if (chatHistoryTroopMemberFragmentV1.P && !chatHistoryTroopMemberFragmentV1.Ei()) {
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV12 = ChatHistoryTroopMemberFragmentV1.this;
                int i3 = chatHistoryTroopMemberFragmentV12.J0;
                if ((i3 == 11 && chatHistoryTroopMemberFragmentV12.Q > 0) || i3 == 3) {
                    Intent intent = chatHistoryTroopMemberFragmentV12.getActivity().getIntent();
                    intent.putExtra("member_uin", "0");
                    intent.putExtra("member_display_name", this.f182652d);
                    ChatHistoryTroopMemberFragmentV1.this.getActivity().setResult(-1, intent);
                    ChatHistoryTroopMemberFragmentV1.this.getActivity().finish();
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV13 = ChatHistoryTroopMemberFragmentV1.this;
                    if (chatHistoryTroopMemberFragmentV13.J0 == 11) {
                        ReportController.o(chatHistoryTroopMemberFragmentV13.E1, "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
                        return;
                    }
                    return;
                }
                QQToast.makeText(chatHistoryTroopMemberFragmentV12.vi(), HardCodeUtil.qqStr(R.string.kf5), 0).show(ChatHistoryTroopMemberFragmentV1.this.W.getHeight());
                return;
            }
            if (!TextUtils.isEmpty(ChatHistoryTroopMemberFragmentV1.this.N)) {
                QQToast.makeText(ChatHistoryTroopMemberFragmentV1.this.vi(), ChatHistoryTroopMemberFragmentV1.this.N, 0).show(ChatHistoryTroopMemberFragmentV1.this.W.getHeight());
            } else {
                QQToast.makeText(ChatHistoryTroopMemberFragmentV1.this.vi(), HardCodeUtil.qqStr(R.string.kdg), 0).show(ChatHistoryTroopMemberFragmentV1.this.W.getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class r implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f182658d;

        r(String str) {
            this.f182658d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
            if (chatHistoryTroopMemberFragmentV1.P && !chatHistoryTroopMemberFragmentV1.Ei()) {
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV12 = ChatHistoryTroopMemberFragmentV1.this;
                int i3 = chatHistoryTroopMemberFragmentV12.J0;
                if ((i3 == 11 && chatHistoryTroopMemberFragmentV12.Q > 0) || i3 == 3) {
                    Intent intent = chatHistoryTroopMemberFragmentV12.getActivity().getIntent();
                    intent.putExtra("member_uin", "0");
                    intent.putExtra("member_display_name", this.f182658d);
                    ChatHistoryTroopMemberFragmentV1.this.getActivity().setResult(-1, intent);
                    ChatHistoryTroopMemberFragmentV1.this.getActivity().finish();
                    ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV13 = ChatHistoryTroopMemberFragmentV1.this;
                    if (chatHistoryTroopMemberFragmentV13.J0 == 11) {
                        ReportController.o(chatHistoryTroopMemberFragmentV13.E1, "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
                        return;
                    }
                    return;
                }
                QQToast.makeText(chatHistoryTroopMemberFragmentV12.vi(), HardCodeUtil.qqStr(R.string.kf7), 0).show(ChatHistoryTroopMemberFragmentV1.this.W.getHeight());
                return;
            }
            if (!TextUtils.isEmpty(ChatHistoryTroopMemberFragmentV1.this.N)) {
                QQToast.makeText(ChatHistoryTroopMemberFragmentV1.this.vi(), ChatHistoryTroopMemberFragmentV1.this.N, 0).show(ChatHistoryTroopMemberFragmentV1.this.W.getHeight());
            } else {
                QQToast.makeText(ChatHistoryTroopMemberFragmentV1.this.vi(), HardCodeUtil.qqStr(R.string.ke8), 0).show(ChatHistoryTroopMemberFragmentV1.this.W.getHeight());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class w {
        public String A;
        public int F;
        public int G;
        public int L;
        public MemberRole M;
        public TroopMemberInfo N;

        /* renamed from: a, reason: collision with root package name */
        public String f182667a;

        /* renamed from: b, reason: collision with root package name */
        public String f182668b;

        /* renamed from: y, reason: collision with root package name */
        public long f182691y;

        /* renamed from: z, reason: collision with root package name */
        public boolean f182692z;

        /* renamed from: c, reason: collision with root package name */
        public String f182669c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f182670d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f182671e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f182672f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f182673g = "";

        /* renamed from: h, reason: collision with root package name */
        public String f182674h = "";

        /* renamed from: i, reason: collision with root package name */
        public String f182675i = "";

        /* renamed from: j, reason: collision with root package name */
        public String f182676j = "";

        /* renamed from: k, reason: collision with root package name */
        public String f182677k = "";

        /* renamed from: l, reason: collision with root package name */
        public String f182678l = "";

        /* renamed from: m, reason: collision with root package name */
        public String f182679m = "";

        /* renamed from: n, reason: collision with root package name */
        public String f182680n = "";

        /* renamed from: o, reason: collision with root package name */
        public int f182681o = 0;

        /* renamed from: p, reason: collision with root package name */
        public String f182682p = "";

        /* renamed from: q, reason: collision with root package name */
        public String f182683q = "";

        /* renamed from: r, reason: collision with root package name */
        public String f182684r = "";

        /* renamed from: s, reason: collision with root package name */
        public long f182685s = 0;

        /* renamed from: t, reason: collision with root package name */
        public String f182686t = "";

        /* renamed from: u, reason: collision with root package name */
        public long f182687u = 0;

        /* renamed from: v, reason: collision with root package name */
        public String f182688v = "";

        /* renamed from: w, reason: collision with root package name */
        public String f182689w = "";

        /* renamed from: x, reason: collision with root package name */
        public int f182690x = 0;
        public int B = 0;
        public boolean C = false;
        public boolean D = false;
        public boolean E = false;
        public int H = 0;
        public String I = "";
        public String J = "";
        public String K = "";

        public void a(String str) {
            if (str == null) {
                str = "";
            }
            this.f182674h = str;
        }

        public void b(String str) {
            if (str == null) {
                str = "";
            }
            this.f182671e = str;
        }

        public void c(String str) {
            if (str == null) {
                str = "";
            }
            this.f182676j = str;
        }

        public void d(String str) {
            if (str == null) {
                str = "";
            }
            this.f182679m = str;
        }

        public void e(String str) {
            if (str == null) {
                str = "";
            }
            this.f182683q = str;
        }

        public void f(String str) {
            if (str == null) {
                str = "";
            }
            this.f182675i = str;
        }

        public void g(String str) {
            if (str == null) {
                str = "";
            }
            this.f182678l = str;
        }

        public void h(String str) {
            if (str == null) {
                str = "";
            }
            this.f182682p = str;
        }

        public void i(String str) {
            if (str == null) {
                str = "";
            }
            this.f182677k = str;
        }

        public void j(String str) {
            if (str == null) {
                str = "";
            }
            this.f182684r = str;
        }

        public void k(String str) {
            if (str == null) {
                str = "";
            }
            this.f182680n = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class y extends com.tencent.mobileqq.adapter.j {
        public List<w> F;

        public y(List<w> list) {
            super(ChatHistoryTroopMemberFragmentV1.this.vi(), ChatHistoryTroopMemberFragmentV1.this.E1, ChatHistoryTroopMemberFragmentV1.this.f182583k0, 1, true);
            this.F = list;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public int getCount() {
            List<w> list = this.F;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            if (!ChatHistoryTroopMemberFragmentV1.this.Gi()) {
                return 0;
            }
            w wVar = this.F.get(i3);
            return (!TextUtils.isEmpty(wVar.f182680n) || TextUtils.isEmpty(wVar.f182684r) || TextUtils.isEmpty(wVar.f182674h) || wVar.f182674h.equals(wVar.f182684r)) ? 0 : 1;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            com.tencent.mobileqq.troop.widget.e eVar;
            int itemViewType = getItemViewType(i3);
            if (view == null) {
                if (itemViewType == 0) {
                    view = ChatHistoryTroopMemberFragmentV1.this.f182603u0.inflate(R.layout.c1x, viewGroup, false);
                    eVar = new com.tencent.mobileqq.troop.widget.e(view, false);
                } else {
                    view = ChatHistoryTroopMemberFragmentV1.this.f182603u0.inflate(R.layout.c1z, viewGroup, false);
                    eVar = new com.tencent.mobileqq.troop.widget.e(view, true);
                }
                view.setTag(eVar);
            } else {
                eVar = (com.tencent.mobileqq.troop.widget.e) view.getTag();
            }
            eVar.position = i3;
            w wVar = this.F.get(i3);
            ChatHistoryTroopMemberFragmentV1.this.dj(eVar, wVar, true, itemViewType == 1);
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
            if (chatHistoryTroopMemberFragmentV1.J0 == 12) {
                if (chatHistoryTroopMemberFragmentV1.U.G.contains(wVar)) {
                    eVar.selectedIcon.setVisibility(0);
                } else {
                    eVar.selectedIcon.setVisibility(8);
                }
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public Object getItem(int i3) {
            if (i3 < 0 || i3 >= this.F.size()) {
                return null;
            }
            return this.F.get(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ti(Dialog dialog, View view) {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi() {
        if (this.C0 != null) {
            return;
        }
        View inflate = vi().getLayoutInflater().inflate(R.layout.c1w, (ViewGroup) this.C, false);
        this.C0 = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.dj6);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000);
        for (oidb_cmd0x74f$Range oidb_cmd0x74f_range : this.f182570d1) {
            this.f182574f1.add(String.valueOf(oidb_cmd0x74f_range.uint32_days.get()));
            this.f182572e1.add(oidb_cmd0x74f_range.string_name.get());
        }
        int i3 = 0;
        for (w wVar : this.T) {
            if (wVar.f182687u == 0) {
                wVar.f182687u = wVar.f182685s;
            }
            if (!TextUtils.isEmpty(xi(wVar.f182687u, calendar, this.f182574f1, this.f182572e1))) {
                i3++;
            }
        }
        textView.setText(i3 + "");
        TroopInfo troopInfo = this.f182597r0;
        int i16 = (troopInfo == null || !troopInfo.isOwner()) ? 1 : 0;
        this.C0.setOnClickListener(new t(i3, i16));
        mj();
        this.C.addHeaderView(this.C0);
        ReportController.o(this.E1, "dc00899", "Grp_mber", "", "mber_list", "exp_inacmem", 0, 0, this.G, "" + i16, "", "");
    }

    private void mi(List<w> list, CheckBox checkBox, Dialog dialog) {
        String str;
        com.tencent.qqnt.bean.b bVar = new com.tencent.qqnt.bean.b();
        bVar.troopUin = this.G;
        bVar.isBlack = checkBox.isChecked();
        for (int i3 = 0; i3 < list.size(); i3++) {
            w wVar = list.get(i3);
            if (wVar != null) {
                if (!TextUtils.isEmpty(wVar.f182668b)) {
                    bVar.a(wVar.f182668b, wVar.f182667a);
                } else if (!TextUtils.isEmpty(wVar.f182667a)) {
                    bVar.b(wVar.f182667a);
                }
            }
        }
        ((ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class)).deleteTroopMember(bVar, this, "ChatHistoryTroopMemberFragmentV1", new com.tencent.qqnt.troop.c() { // from class: com.tencent.mobileqq.activity.history.compat.n
            @Override // com.tencent.qqnt.troop.c
            public final void a(boolean z16, int i16, ArrayList arrayList) {
                ChatHistoryTroopMemberFragmentV1.this.Ai(z16, i16, arrayList);
            }
        });
        String str2 = this.U0;
        if (checkBox.isChecked()) {
            str = "0";
        } else {
            str = "1";
        }
        ReportController.o(this.E1, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.G, str2, str, "");
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        ji();
        this.V.show();
    }

    protected void Bi() {
        View inflate = vi().getLayoutInflater().inflate(R.layout.f169147c20, (ViewGroup) this.C, false);
        this.f182573f0 = (QUISearchBar) inflate.findViewById(R.id.iir);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.f164294rc);
        this.f182577h0 = relativeLayout;
        relativeLayout.setVisibility(8);
        TextView textView = (TextView) this.f182577h0.findViewById(R.id.tv_name);
        this.R0 = ((LinearLayout.LayoutParams) textView.getLayoutParams()).leftMargin;
        int i3 = this.J0;
        boolean z16 = i3 == 3 && this.D && this.R != 1;
        boolean z17 = i3 == 11 && this.D;
        if (z16 || z17) {
            String string = getString(R.string.i7z);
            textView.setText(string);
            TextView textView2 = (TextView) this.f182577h0.findViewById(R.id.i6q);
            textView2.setText("");
            ((ImageView) this.f182577h0.findViewById(R.id.dvo)).setBackgroundDrawable(BaseImageUtil.getDefaultTroopFaceDrawableNew());
            ImageView imageView = (ImageView) this.f182577h0.findViewById(R.id.g6d);
            imageView.setVisibility(8);
            if (z16) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new q());
                textView2.setTextSize(12.0f);
            }
            this.f182577h0.setOnClickListener(new r(string));
            if (!Ei()) {
                this.f182577h0.setVisibility(0);
                this.f182577h0.setEnabled(false);
            }
            mt2.a aVar = (mt2.a) this.E1.getBusinessHandler(BusinessHandlerFactory.TROOP_MESSAGE_HANDLER);
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                QQToast.makeText(vi(), 1, R.string.f171137ci2, 0).show(getTitleBarHeight());
            } else {
                DiscussionHandler discussionHandler = this.A0;
                if (discussionHandler != null && this.J0 == 11) {
                    discussionHandler.getAtAllRemainCountInfo(this.E1.getCurrentAccountUin(), this.F);
                } else if (aVar != null) {
                    aVar.getAtAllRemainCountInfo(this.E1.getCurrentAccountUin(), this.G);
                }
                Drawable drawable = getResources().getDrawable(R.drawable.common_loading6);
                this.f182593p0 = drawable;
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                ((Animatable) this.f182593p0).start();
            }
        }
        this.f182573f0.getInputWidget();
        this.f182573f0.getCancelView().setVisibility(8);
        int i16 = this.J0;
        if (i16 == 19) {
            this.C.addHeaderView(vi().getLayoutInflater().inflate(R.layout.c1v, (ViewGroup) this.C, false));
        } else if (i16 != 9 && i16 != 15) {
            this.C.addHeaderView(inflate);
        }
        ListAdapter listAdapter = new ListAdapter();
        this.U = listAdapter;
        this.C.setAdapter((android.widget.ListAdapter) listAdapter);
        int i17 = this.J0;
        if (i17 == 19 || i17 == 21) {
            this.f182573f0.setVisibility(8);
        }
        int i18 = this.J0;
        if (i18 != 9 && i18 != 19) {
            Ci();
        }
        this.f182573f0.getInputWidget().setClickable(false);
        this.f182573f0.setOnClickListener(new s());
        this.f182591o0.setIndex(new String[]{"$", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"});
        this.f182591o0.setOnIndexChangedListener(this);
        if (this.J0 == 11) {
            this.f182591o0.setOnIndexChangedListener2(this);
        }
    }

    public void nj(int[] iArr) {
        ListAdapter listAdapter;
        int i3;
        if (iArr == null || iArr.length == 0 || (listAdapter = this.U) == null || listAdapter.L + listAdapter.M > 16) {
            return;
        }
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        while (true) {
            if (i18 >= iArr.length) {
                break;
            }
            int i19 = (iArr[i18] - iArr[i18 - 1]) - 1;
            if (i19 > 0) {
                int i26 = i16 + this.f182614z1;
                int i27 = (this.A1 * i19) + i26;
                if (i27 > this.f182612y1) {
                    do {
                        i19--;
                        i3 = (this.f182614z1 * i19) + i26;
                        if (i3 <= this.f182612y1) {
                            break;
                        }
                    } while (i19 > 0);
                    i17 += i19;
                    i16 = i3;
                } else {
                    i17 += i19;
                    i16 = i27;
                }
            }
            i18++;
        }
        int i28 = i17 + 1;
        if (i16 + this.A1 > this.f182612y1) {
            this.B1 = i28;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ChatHistoryTroopMemberFragmentV1", 2, String.format("updateMaxItemCount, max: %s", Integer.valueOf(this.B1)));
        }
    }

    protected void oi(String str, String str2, String str3) {
        String str4;
        try {
            if (QLog.isColorLevel()) {
                QLog.i("ChatHistoryTroopMemberFragmentV1", 2, "doReport, actionName=" + str + " ext2=" + str2 + " ext3=" + str3 + " from=" + this.J0);
            }
            int i3 = this.J0;
            if (i3 != 1 && i3 != 11) {
                if (i3 == 9) {
                    if (this.L0 == 1) {
                        str4 = "suc_pay_list";
                    } else {
                        str4 = "un_pay_list";
                    }
                    ReportController.o(this.E1, "P_CliOper", "Grp_pay", "", str4, str, 0, 0, this.G, str3, "", "");
                    return;
                }
                ReportController.o(this.E1, "P_CliOper", "Grp_mber", "", "mber_list", str, 0, 0, this.G, str2, str3, "");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatHistoryTroopMemberFragmentV1", 2, "doReport:" + e16.toString());
            }
        }
    }

    protected com.tencent.mobileqq.troop.widget.e si(String str, boolean z16) {
        ViewGroup viewGroup;
        com.tencent.mobileqq.troop.widget.e eVar;
        String str2;
        if (z16) {
            viewGroup = this.f182583k0;
        } else {
            viewGroup = this.C;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt.getTag() != null && (childAt.getTag() instanceof com.tencent.mobileqq.troop.widget.e) && (str2 = (eVar = (com.tencent.mobileqq.troop.widget.e) childAt.getTag()).f187210d) != null && str2.equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "findListItemHolderByUin:" + i3);
                }
                return eVar;
            }
        }
        return null;
    }

    private void Vi(List<TroopMemberInfo> list, int i3) {
        List<String> list2;
        MemberRole memberRole;
        if (list == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "processConvertTroopMemberInfo2AtTroopMember, processIndex:" + i3);
        }
        ArrayList arrayList = new ArrayList();
        FriendsManager friendsManager = (FriendsManager) this.E1.getManager(QQManagerFactory.FRIENDS_MANAGER);
        ITroopRobotService iTroopRobotService = (ITroopRobotService) this.E1.getRuntimeService(ITroopRobotService.class, "all");
        int size = list.size();
        for (int i16 = 0; i16 < size; i16++) {
            TroopMemberInfo troopMemberInfo = list.get(i16);
            if (troopMemberInfo != null) {
                if (Utils.M(troopMemberInfo.memberuin)) {
                    if ((this.J0 != 2 || ((memberRole = troopMemberInfo.role) != MemberRole.OWNER && memberRole != MemberRole.ADMIN)) && (((list2 = this.F0) == null || !list2.contains(troopMemberInfo.memberuin)) && ((this.J0 != 20 || !iTroopRobotService.isRobotUin(troopMemberInfo.memberuin)) && !troopMemberInfo.memberuin.equals("50000000")))) {
                        arrayList.add(li(troopMemberInfo, friendsManager));
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "processConvertTroopMemberInfo2AtTroopMember, continued, tmi.memberuin:" + troopMemberInfo.memberuin);
                }
            }
        }
        Message obtainMessage = this.P1.obtainMessage(12, arrayList);
        obtainMessage.arg1 = i3;
        this.P1.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(Message message) {
        if (message == null) {
            return;
        }
        RelativeLayout relativeLayout = this.f182582j1;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f182582j1.setVisibility(8);
        }
        if (this.f182584k1.getVisibility() == 8) {
            this.f182584k1.setVisibility(0);
        }
        Object[] objArr = (Object[]) message.obj;
        if (objArr != null && objArr.length == 3) {
            ListAdapter listAdapter = this.U;
            if (listAdapter != null) {
                listAdapter.D = (LinkedHashMap) objArr[0];
            }
            if (listAdapter != null) {
                listAdapter.E = (int[]) objArr[1];
            }
            if (listAdapter != null) {
                listAdapter.F = (String[]) objArr[2];
            }
            QLog.d(".troop.troopManagerVASH", 2, "obj.length==3, refreshUI List count: ", Integer.valueOf(this.T.size()));
        } else if (objArr != null && objArr.length == 1) {
            synchronized (this) {
                this.T.clear();
                this.T.addAll((List) objArr[0]);
                QLog.d(".troop.troopManagerVASH", 2, "refreshUI List count: ", Integer.valueOf(this.T.size()));
            }
        }
        if (this.T.size() != 0) {
            gj();
            hi();
            ListAdapter listAdapter2 = this.U;
            if (listAdapter2 != null) {
                listAdapter2.notifyDataSetChanged();
                this.U.k();
            } else {
                ListAdapter listAdapter3 = new ListAdapter();
                this.U = listAdapter3;
                this.C.setAdapter((android.widget.ListAdapter) listAdapter3);
            }
            this.C.setVisibility(0);
        }
        if (!this.f182609x0 || this.J0 == 11) {
            stopTitleProgress();
        }
    }

    protected void cj() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rlCommenTitle);
        if (viewGroup != null) {
            IphoneTitleBarActivity.setLayerType(viewGroup);
        }
        View findViewById = findViewById(R.id.jo9);
        if (findViewById != null) {
            IphoneTitleBarActivity.setLayerType(findViewById);
        }
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        if (textView != null) {
            IphoneTitleBarActivity.setLayerType(textView);
        }
    }

    protected void ti() {
        this.f182571e0 = (LinearLayout) findViewById(R.id.k09);
        View findViewById = findViewById(R.id.jo9);
        this.W = findViewById;
        findViewById.setVisibility(8);
        this.f182560a0 = (TextView) findViewById(R.id.ivTitleName);
        this.f182563b0 = (TextView) findViewById(R.id.f165889ds3);
        this.f182566c0 = (LinearLayout) findViewById(R.id.asq);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.f182569d0 = textView;
        int i3 = this.J0;
        if (i3 == 3 || i3 == 11) {
            textView.setVisibility(8);
            TextView textView2 = (TextView) findViewById(R.id.ivTitleBtnLeftButton);
            this.f182569d0 = textView2;
            textView2.setVisibility(0);
        }
        this.X = (TextView) findViewById(R.id.ivTitleBtnRightText);
        this.Y = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
        this.C = (PinnedDividerSwipListView) findViewById(R.id.f167018k05);
        this.f182591o0 = (IndexView) findViewById(R.id.djh);
        this.f182607w0 = findViewById(R.id.i5n);
        this.f182584k1 = (RelativeLayout) findViewById(R.id.ebu);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ef7);
        this.f182582j1 = relativeLayout;
        this.f182586l1 = (ProgressBar) relativeLayout.findViewById(R.id.d7z);
        this.f182588m1 = (TextView) this.f182582j1.findViewById(R.id.efr);
        this.Y.setContentDescription(getString(R.string.epf));
        ImageView imageView = (ImageView) findViewById(R.id.dsn);
        this.Z = imageView;
        imageView.setBackgroundResource(R.drawable.qb_troop_member_list_sort);
        this.Z.setContentDescription(getString(R.string.i5r));
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class TroopAdmin implements Parcelable {
        public static final Parcelable.Creator<TroopAdmin> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public String f182633d;

        /* renamed from: e, reason: collision with root package name */
        public short f182634e;

        /* renamed from: f, reason: collision with root package name */
        public String f182635f;

        /* renamed from: h, reason: collision with root package name */
        public String f182636h;

        /* compiled from: P */
        /* loaded from: classes33.dex */
        class a implements Parcelable.Creator<TroopAdmin> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TroopAdmin createFromParcel(Parcel parcel) {
                return new TroopAdmin(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TroopAdmin[] newArray(int i3) {
                return new TroopAdmin[i3];
            }
        }

        TroopAdmin(Parcel parcel) {
            this.f182633d = parcel.readString();
            this.f182634e = (short) parcel.readInt();
            this.f182635f = parcel.readString();
            this.f182636h = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof TroopAdmin)) {
                return false;
            }
            TroopAdmin troopAdmin = (TroopAdmin) obj;
            String str = this.f182633d;
            if (str != null) {
                return str.equals(troopAdmin.f182633d);
            }
            return false;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f182633d);
            parcel.writeInt(this.f182634e);
            parcel.writeString(this.f182635f);
            parcel.writeString(this.f182636h);
        }

        public TroopAdmin() {
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hzz, viewGroup, false);
        this.F1 = inflate;
        ti();
        return inflate;
    }

    @Override // com.tencent.mobileqq.widget.IndexView.a
    public void onIndexChanged(String str, int i3) {
        if ("$".equals(str)) {
            if (this.J0 == 11 && i3 == 1) {
                ReportController.o(this.E1, "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
                return;
            }
            return;
        }
        if (this.J0 == 11 && i3 == 0) {
            ReportController.o(this.E1, "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class ListAdapter extends com.tencent.mobileqq.adapter.e {
        public LinkedHashMap<String, List<w>> D;
        public int[] E;
        public String[] F;
        public List<w> G;
        public List<w> H;
        protected List<String> I;
        protected List<oidb_0xa2a$UserInfo> J;
        public int K;
        public int L;
        public int M;
        public String N;

        public ListAdapter() {
            super(ChatHistoryTroopMemberFragmentV1.this.vi(), ChatHistoryTroopMemberFragmentV1.this.E1, ChatHistoryTroopMemberFragmentV1.this.C, true);
            String string;
            this.D = new LinkedHashMap<>();
            this.E = new int[0];
            this.F = new String[0];
            this.G = new ArrayList();
            this.H = new ArrayList();
            this.K = 0;
            this.L = 0;
            this.M = 0;
            int i3 = ChatHistoryTroopMemberFragmentV1.this.J0;
            if (i3 != 1 && i3 != 11) {
                string = ChatHistoryTroopMemberFragmentV1.this.getString(i3 == 5 ? R.string.dvl : R.string.i8s);
            } else {
                string = ChatHistoryTroopMemberFragmentV1.this.getString(R.string.f170845at3);
            }
            this.N = string;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            int i16 = ChatHistoryTroopMemberFragmentV1.this.J0;
            if (i16 == 9 || i16 == 19) {
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            int[] iArr = this.E;
            if (iArr.length <= 0 || this.F.length <= 0) {
                return;
            }
            int binarySearch = Arrays.binarySearch(iArr, i3);
            if (binarySearch < 0) {
                binarySearch = (-(binarySearch + 1)) - 1;
            }
            List<w> list = this.D.get(this.F[binarySearch]);
            if (list != null && list.size() > 1) {
                ((TextView) view).setText(this.F[binarySearch] + ChatHistoryTroopMemberFragmentV1.this.getString(R.string.iha, Integer.valueOf(list.size())));
            } else {
                ((TextView) view).setText(this.F[binarySearch]);
            }
            if (ChatHistoryTroopMemberFragmentV1.this.C1) {
                view.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            } else {
                view.setBackgroundResource(R.drawable.skin_group_list_sub_entry);
            }
            view.setPadding((int) (ChatHistoryTroopMemberFragmentV1.this.S * 10.0f), 0, 0, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:73:0x0174 A[Catch: all -> 0x09d7, TryCatch #0 {, blocks: (B:4:0x001d, B:6:0x0024, B:7:0x0050, B:9:0x0056, B:11:0x0066, B:15:0x0074, B:17:0x007a, B:23:0x0082, B:27:0x00e0, B:31:0x00ec, B:33:0x00f0, B:35:0x00f4, B:37:0x00fe, B:38:0x0101, B:40:0x0107, B:42:0x010b, B:43:0x010e, B:45:0x011e, B:47:0x0126, B:48:0x0129, B:50:0x012f, B:52:0x0133, B:54:0x0139, B:59:0x0144, B:61:0x0149, B:63:0x0151, B:65:0x0156, B:67:0x015a, B:70:0x0161, B:71:0x016d, B:73:0x0174, B:77:0x0189, B:83:0x0191, B:85:0x0197, B:86:0x019f, B:89:0x01b0, B:91:0x01b9, B:94:0x0092, B:96:0x0096, B:98:0x009e, B:99:0x00a1, B:101:0x00a7, B:103:0x00af, B:105:0x00b7, B:106:0x00bc, B:108:0x00c2, B:110:0x00ca, B:112:0x00d2, B:114:0x01ec, B:116:0x0204, B:118:0x020a, B:120:0x0914, B:149:0x0221, B:150:0x0237, B:152:0x023d, B:154:0x0245, B:155:0x0254, B:157:0x025a, B:159:0x0261, B:160:0x0270, B:162:0x0276, B:164:0x027d, B:165:0x028c, B:167:0x0292, B:169:0x02a9, B:170:0x02b0, B:171:0x02ae, B:172:0x02b3, B:174:0x02b9, B:177:0x02d6, B:179:0x02e0, B:181:0x0304, B:184:0x0308, B:186:0x0311, B:187:0x0332, B:190:0x033f, B:191:0x035e, B:193:0x0364, B:195:0x0372, B:196:0x037a, B:198:0x0382, B:200:0x038c, B:203:0x0398, B:205:0x03a2, B:207:0x03aa, B:209:0x03c7, B:212:0x03ca, B:216:0x03d3, B:218:0x03dd, B:220:0x03e0, B:221:0x03f4, B:223:0x03fa, B:225:0x0408, B:227:0x0410, B:228:0x0414, B:229:0x0429, B:231:0x0431, B:232:0x043b, B:235:0x0443, B:240:0x044f, B:242:0x0462, B:244:0x0472, B:246:0x04ab, B:249:0x04ae, B:252:0x04b6, B:253:0x04d5, B:255:0x04db, B:257:0x04e9, B:258:0x04f1, B:260:0x04f9, B:262:0x0503, B:265:0x050f, B:267:0x0519, B:269:0x0521, B:271:0x053e, B:274:0x0541, B:277:0x0549, B:278:0x0565, B:280:0x056b, B:316:0x0579, B:320:0x0583, B:322:0x0589, B:324:0x058d, B:326:0x0595, B:327:0x059c, B:283:0x05a7, B:285:0x05ac, B:292:0x05b4, B:294:0x05bd, B:296:0x05c1, B:298:0x05c7, B:306:0x05d6, B:303:0x05de, B:288:0x05e2, B:331:0x05ee, B:333:0x0601, B:334:0x060d, B:336:0x0613, B:338:0x0628, B:339:0x0637, B:340:0x0630, B:341:0x063a, B:343:0x064a, B:344:0x0656, B:346:0x0666, B:349:0x0677, B:351:0x069b, B:353:0x06b0, B:356:0x06b9, B:358:0x06c2, B:360:0x06d6, B:362:0x06d9, B:365:0x06dc, B:368:0x06e5, B:370:0x06ee, B:372:0x0702, B:374:0x0705, B:377:0x0708, B:380:0x0711, B:382:0x071a, B:384:0x072e, B:386:0x0731, B:389:0x0734, B:390:0x073c, B:392:0x0742, B:394:0x0752, B:396:0x0762, B:397:0x076c, B:399:0x0772, B:400:0x077c, B:402:0x0782, B:403:0x078c, B:405:0x079c, B:408:0x07ac, B:410:0x07bf, B:412:0x07c6, B:414:0x07de, B:415:0x07e6, B:417:0x07ec, B:424:0x07fc, B:420:0x0808, B:427:0x080c, B:429:0x0812, B:430:0x0825, B:432:0x082b, B:435:0x0843, B:436:0x0864, B:438:0x086a, B:440:0x0876, B:453:0x0880, B:455:0x088a, B:456:0x0892, B:446:0x089c, B:448:0x08a2, B:449:0x08aa, B:460:0x08b4, B:462:0x08b9, B:464:0x08c1, B:466:0x08dd, B:469:0x08e0, B:471:0x08e6, B:472:0x08fe), top: B:3:0x001d }] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0197 A[Catch: all -> 0x09d7, TryCatch #0 {, blocks: (B:4:0x001d, B:6:0x0024, B:7:0x0050, B:9:0x0056, B:11:0x0066, B:15:0x0074, B:17:0x007a, B:23:0x0082, B:27:0x00e0, B:31:0x00ec, B:33:0x00f0, B:35:0x00f4, B:37:0x00fe, B:38:0x0101, B:40:0x0107, B:42:0x010b, B:43:0x010e, B:45:0x011e, B:47:0x0126, B:48:0x0129, B:50:0x012f, B:52:0x0133, B:54:0x0139, B:59:0x0144, B:61:0x0149, B:63:0x0151, B:65:0x0156, B:67:0x015a, B:70:0x0161, B:71:0x016d, B:73:0x0174, B:77:0x0189, B:83:0x0191, B:85:0x0197, B:86:0x019f, B:89:0x01b0, B:91:0x01b9, B:94:0x0092, B:96:0x0096, B:98:0x009e, B:99:0x00a1, B:101:0x00a7, B:103:0x00af, B:105:0x00b7, B:106:0x00bc, B:108:0x00c2, B:110:0x00ca, B:112:0x00d2, B:114:0x01ec, B:116:0x0204, B:118:0x020a, B:120:0x0914, B:149:0x0221, B:150:0x0237, B:152:0x023d, B:154:0x0245, B:155:0x0254, B:157:0x025a, B:159:0x0261, B:160:0x0270, B:162:0x0276, B:164:0x027d, B:165:0x028c, B:167:0x0292, B:169:0x02a9, B:170:0x02b0, B:171:0x02ae, B:172:0x02b3, B:174:0x02b9, B:177:0x02d6, B:179:0x02e0, B:181:0x0304, B:184:0x0308, B:186:0x0311, B:187:0x0332, B:190:0x033f, B:191:0x035e, B:193:0x0364, B:195:0x0372, B:196:0x037a, B:198:0x0382, B:200:0x038c, B:203:0x0398, B:205:0x03a2, B:207:0x03aa, B:209:0x03c7, B:212:0x03ca, B:216:0x03d3, B:218:0x03dd, B:220:0x03e0, B:221:0x03f4, B:223:0x03fa, B:225:0x0408, B:227:0x0410, B:228:0x0414, B:229:0x0429, B:231:0x0431, B:232:0x043b, B:235:0x0443, B:240:0x044f, B:242:0x0462, B:244:0x0472, B:246:0x04ab, B:249:0x04ae, B:252:0x04b6, B:253:0x04d5, B:255:0x04db, B:257:0x04e9, B:258:0x04f1, B:260:0x04f9, B:262:0x0503, B:265:0x050f, B:267:0x0519, B:269:0x0521, B:271:0x053e, B:274:0x0541, B:277:0x0549, B:278:0x0565, B:280:0x056b, B:316:0x0579, B:320:0x0583, B:322:0x0589, B:324:0x058d, B:326:0x0595, B:327:0x059c, B:283:0x05a7, B:285:0x05ac, B:292:0x05b4, B:294:0x05bd, B:296:0x05c1, B:298:0x05c7, B:306:0x05d6, B:303:0x05de, B:288:0x05e2, B:331:0x05ee, B:333:0x0601, B:334:0x060d, B:336:0x0613, B:338:0x0628, B:339:0x0637, B:340:0x0630, B:341:0x063a, B:343:0x064a, B:344:0x0656, B:346:0x0666, B:349:0x0677, B:351:0x069b, B:353:0x06b0, B:356:0x06b9, B:358:0x06c2, B:360:0x06d6, B:362:0x06d9, B:365:0x06dc, B:368:0x06e5, B:370:0x06ee, B:372:0x0702, B:374:0x0705, B:377:0x0708, B:380:0x0711, B:382:0x071a, B:384:0x072e, B:386:0x0731, B:389:0x0734, B:390:0x073c, B:392:0x0742, B:394:0x0752, B:396:0x0762, B:397:0x076c, B:399:0x0772, B:400:0x077c, B:402:0x0782, B:403:0x078c, B:405:0x079c, B:408:0x07ac, B:410:0x07bf, B:412:0x07c6, B:414:0x07de, B:415:0x07e6, B:417:0x07ec, B:424:0x07fc, B:420:0x0808, B:427:0x080c, B:429:0x0812, B:430:0x0825, B:432:0x082b, B:435:0x0843, B:436:0x0864, B:438:0x086a, B:440:0x0876, B:453:0x0880, B:455:0x088a, B:456:0x0892, B:446:0x089c, B:448:0x08a2, B:449:0x08aa, B:460:0x08b4, B:462:0x08b9, B:464:0x08c1, B:466:0x08dd, B:469:0x08e0, B:471:0x08e6, B:472:0x08fe), top: B:3:0x001d }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object[] g() {
            long j3;
            LinkedHashMap linkedHashMap;
            char c16;
            long j16;
            Iterator<w> it;
            String str;
            int i3;
            long currentTimeMillis = System.currentTimeMillis();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            ITroopRobotService iTroopRobotService = (ITroopRobotService) ChatHistoryTroopMemberFragmentV1.this.E1.getRuntimeService(ITroopRobotService.class, "all");
            synchronized (ChatHistoryTroopMemberFragmentV1.this) {
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
                int i16 = chatHistoryTroopMemberFragmentV1.L1;
                if (i16 == 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    this.L = 0;
                    this.K = 0;
                    this.M = 0;
                    Iterator<w> it5 = ChatHistoryTroopMemberFragmentV1.this.T.iterator();
                    while (it5.hasNext()) {
                        w next = it5.next();
                        if (iTroopRobotService.isRobotUin(next.f182667a)) {
                            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV12 = ChatHistoryTroopMemberFragmentV1.this;
                            it = it5;
                            int i17 = chatHistoryTroopMemberFragmentV12.J0;
                            j16 = currentTimeMillis;
                            if (i17 != 5 && i17 != 2 && !chatHistoryTroopMemberFragmentV12.D1) {
                                arrayList6.add(next);
                            }
                        } else {
                            j16 = currentTimeMillis;
                            it = it5;
                            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV13 = ChatHistoryTroopMemberFragmentV1.this;
                            int i18 = chatHistoryTroopMemberFragmentV13.J0;
                            if (i18 == 12 || i18 == 20) {
                                String str2 = chatHistoryTroopMemberFragmentV13.Q0;
                                if (str2 != null && str2.contains(next.f182667a)) {
                                    arrayList5.add(next);
                                }
                                String str3 = ChatHistoryTroopMemberFragmentV1.this.P0;
                                if (str3 != null && str3.contains(next.f182667a) && !this.G.contains(next)) {
                                    this.G.add(next);
                                }
                                ArrayList<String> arrayList7 = ChatHistoryTroopMemberFragmentV1.this.f182590n1;
                                if (arrayList7 != null && arrayList7.contains(next.f182667a) && !this.G.contains(next)) {
                                    this.G.add(next);
                                    ChatHistoryTroopMemberFragmentV1.this.f182590n1.remove(next.f182667a);
                                }
                            }
                            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV14 = ChatHistoryTroopMemberFragmentV1.this;
                            int i19 = chatHistoryTroopMemberFragmentV14.J0;
                            if (i19 != 13 && i19 != 21) {
                                if (!chatHistoryTroopMemberFragmentV14.E && (next.f182692z || chatHistoryTroopMemberFragmentV14.B0.contains(next.f182667a))) {
                                    arrayList.add(next);
                                }
                                if (!ChatHistoryTroopMemberFragmentV1.this.E && next.C) {
                                    arrayList4.add(next);
                                }
                                if (!next.f182667a.equals(ChatHistoryTroopMemberFragmentV1.this.E1.getCurrentAccountUin()) && next.f182691y == 1) {
                                    arrayList2.add(next);
                                }
                            }
                            MemberRole memberRole = next.M;
                            if (memberRole != MemberRole.OWNER && memberRole != MemberRole.ADMIN) {
                                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV15 = ChatHistoryTroopMemberFragmentV1.this;
                                if (!chatHistoryTroopMemberFragmentV15.E || ((i3 = next.f182690x) != 332 && i3 != 333)) {
                                    if (chatHistoryTroopMemberFragmentV15.J0 == 5 && !TextUtils.isEmpty(next.A)) {
                                        arrayList3.add(next);
                                    } else {
                                        String str4 = next.f182670d;
                                        if (str4 != null && str4.length() != 0) {
                                            str = next.f182670d.substring(0, 1);
                                            if (str.length() == 1) {
                                                char charAt = str.charAt(0);
                                                str = (('A' > charAt || charAt > 'Z') && ('a' > charAt || charAt > 'z')) ? "#" : str.toUpperCase();
                                            }
                                            if (linkedHashMap2.get(str) == null) {
                                                linkedHashMap2.put(str, new ArrayList());
                                            }
                                            this.L++;
                                            ((List) linkedHashMap2.get(str)).add(next);
                                        }
                                        str = "#";
                                        if (str.length() == 1) {
                                        }
                                        if (linkedHashMap2.get(str) == null) {
                                        }
                                        this.L++;
                                        ((List) linkedHashMap2.get(str)).add(next);
                                    }
                                }
                            }
                            arrayList3.add(next);
                            if (QLog.isColorLevel()) {
                                QLog.d("zivonchen", 2, "constructHashStruct uin = " + next.f182667a + ", name = " + next.f182674h + ", level = " + next.f182690x);
                            }
                        }
                        it5 = it;
                        currentTimeMillis = j16;
                    }
                    j3 = currentTimeMillis;
                    x xVar = new x(0, true);
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    int i26 = ChatHistoryTroopMemberFragmentV1.this.J0;
                    if (i26 == 19) {
                        if (arrayList3.size() > 0) {
                            Collections.sort(arrayList3, xVar);
                            ChatHistoryTroopMemberFragmentV1.this.lj(arrayList3);
                            linkedHashMap3.put(ChatHistoryTroopMemberFragmentV1.this.f182608w1, arrayList3);
                        }
                    } else if (i26 == 21) {
                        this.K = 0;
                        Collections.sort(arrayList3, xVar);
                        linkedHashMap3.put(HardCodeUtil.qqStr(R.string.kd7), ChatHistoryTroopMemberFragmentV1.this.T);
                    } else {
                        if (arrayList.size() > 0 && ChatHistoryTroopMemberFragmentV1.this.J0 != 12) {
                            Collections.sort(arrayList, xVar);
                            linkedHashMap3.put(ChatHistoryTroopMemberFragmentV1.this.getString(R.string.hor), arrayList);
                        }
                        if (arrayList4.size() > 0 && ChatHistoryTroopMemberFragmentV1.this.J0 != 3) {
                            Collections.sort(arrayList4, xVar);
                            linkedHashMap3.put(ChatHistoryTroopMemberFragmentV1.this.getString(R.string.i8e), arrayList4);
                        }
                        if (arrayList2.size() > 0 && ChatHistoryTroopMemberFragmentV1.this.J0 != 3) {
                            Collections.sort(arrayList2, xVar);
                            linkedHashMap3.put(ChatHistoryTroopMemberFragmentV1.this.getString(R.string.f170807af3), arrayList2);
                        }
                        if (arrayList3.size() > 0) {
                            Collections.sort(arrayList3, xVar);
                            this.M += arrayList3.size();
                            ChatHistoryTroopMemberFragmentV1.this.lj(arrayList3);
                            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV16 = ChatHistoryTroopMemberFragmentV1.this;
                            linkedHashMap3.put(chatHistoryTroopMemberFragmentV16.E ? chatHistoryTroopMemberFragmentV16.f182608w1 : this.N, arrayList3);
                        }
                        if (arrayList6.size() > 0) {
                            Collections.sort(arrayList6, xVar);
                            this.M += arrayList6.size();
                            linkedHashMap3.put(ChatHistoryTroopMemberFragmentV1.this.getString(R.string.i8u), arrayList6);
                        }
                        for (char c17 = 'A'; c17 <= 'Z'; c17 = (char) (c17 + 1)) {
                            if (linkedHashMap2.get(String.valueOf(c17)) != null) {
                                this.K++;
                                Collections.sort((List) linkedHashMap2.get(String.valueOf(c17)), xVar);
                                linkedHashMap3.put(String.valueOf(c17), (List) linkedHashMap2.get(String.valueOf(c17)));
                            }
                        }
                        if (linkedHashMap2.get("#") != null) {
                            this.K++;
                            Collections.sort((List) linkedHashMap2.get("#"), xVar);
                            linkedHashMap3.put("#", (List) linkedHashMap2.get("#"));
                        }
                        linkedHashMap2.clear();
                    }
                    linkedHashMap2 = linkedHashMap3;
                } else {
                    j3 = currentTimeMillis;
                    if (i16 == 2) {
                        String[] stringArray = chatHistoryTroopMemberFragmentV1.getResources().getStringArray(R.array.f155251c2);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000);
                        for (w wVar : ChatHistoryTroopMemberFragmentV1.this.T) {
                            if (TextUtils.isEmpty(wVar.f182688v)) {
                                wVar.f182688v = j(stringArray, wVar.f182687u, calendar);
                            }
                            if (linkedHashMap2.get(wVar.f182688v) == null) {
                                linkedHashMap2.put(wVar.f182688v, new ArrayList());
                            }
                            ((List) linkedHashMap2.get(wVar.f182688v)).add(wVar);
                        }
                        linkedHashMap = new LinkedHashMap();
                        for (int length = stringArray.length - 1; length >= 0; length--) {
                            if (linkedHashMap2.get(stringArray[length]) != null) {
                                Collections.sort((List) linkedHashMap2.get(stringArray[length]), new x(2, false));
                                String str5 = stringArray[length];
                                linkedHashMap.put(str5, (List) linkedHashMap2.get(str5));
                            }
                        }
                        linkedHashMap2.clear();
                    } else if (i16 == 6) {
                        if (chatHistoryTroopMemberFragmentV1.f182578h1.size() == 0) {
                            return null;
                        }
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000);
                        for (w wVar2 : ChatHistoryTroopMemberFragmentV1.this.T) {
                            if (TextUtils.isEmpty(wVar2.f182688v)) {
                                if (wVar2.f182687u == 0) {
                                    wVar2.f182687u = wVar2.f182685s;
                                }
                                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV17 = ChatHistoryTroopMemberFragmentV1.this;
                                wVar2.f182688v = chatHistoryTroopMemberFragmentV17.xi(wVar2.f182687u, calendar2, chatHistoryTroopMemberFragmentV17.f182578h1, ChatHistoryTroopMemberFragmentV1.this.f182576g1);
                            }
                            if (linkedHashMap2.get(wVar2.f182688v) == null) {
                                linkedHashMap2.put(wVar2.f182688v, new ArrayList());
                            }
                            if (!TextUtils.isEmpty(wVar2.f182688v)) {
                                ((List) linkedHashMap2.get(wVar2.f182688v)).add(wVar2);
                            }
                        }
                        linkedHashMap = new LinkedHashMap();
                        for (int size = ChatHistoryTroopMemberFragmentV1.this.f182576g1.size() - 1; size >= 0; size--) {
                            if (linkedHashMap2.get(ChatHistoryTroopMemberFragmentV1.this.f182576g1.get(size)) != null) {
                                Collections.sort((List) linkedHashMap2.get(ChatHistoryTroopMemberFragmentV1.this.f182576g1.get(size)), new x(2, false));
                                linkedHashMap.put((String) ChatHistoryTroopMemberFragmentV1.this.f182576g1.get(size), (List) linkedHashMap2.get(ChatHistoryTroopMemberFragmentV1.this.f182576g1.get(size)));
                            }
                        }
                        linkedHashMap2.clear();
                    } else if (i16 == 3) {
                        String[] stringArray2 = chatHistoryTroopMemberFragmentV1.getResources().getStringArray(R.array.f155252c3);
                        Calendar calendar3 = Calendar.getInstance();
                        calendar3.setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000);
                        for (w wVar3 : ChatHistoryTroopMemberFragmentV1.this.T) {
                            if (TextUtils.isEmpty(wVar3.f182686t)) {
                                wVar3.f182686t = h(stringArray2, wVar3.f182685s, calendar3);
                            }
                            if (linkedHashMap2.get(wVar3.f182686t) == null) {
                                linkedHashMap2.put(wVar3.f182686t, new ArrayList());
                            }
                            ((List) linkedHashMap2.get(wVar3.f182686t)).add(wVar3);
                        }
                        linkedHashMap = new LinkedHashMap();
                        for (int length2 = stringArray2.length - 1; length2 >= 0; length2--) {
                            if (linkedHashMap2.get(stringArray2[length2]) != null) {
                                Collections.sort((List) linkedHashMap2.get(stringArray2[length2]), new x(3, false));
                                String str6 = stringArray2[length2];
                                linkedHashMap.put(str6, (List) linkedHashMap2.get(str6));
                            }
                        }
                        linkedHashMap2.clear();
                    } else if (i16 == 1) {
                        ArrayList arrayList8 = new ArrayList();
                        ArrayList arrayList9 = new ArrayList();
                        ArrayList arrayList10 = new ArrayList();
                        ArrayList arrayList11 = new ArrayList();
                        for (w wVar4 : ChatHistoryTroopMemberFragmentV1.this.T) {
                            if (iTroopRobotService.isRobotUin(wVar4.f182667a)) {
                                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV18 = ChatHistoryTroopMemberFragmentV1.this;
                                int i27 = chatHistoryTroopMemberFragmentV18.J0;
                                if (i27 != 5 && i27 != 2 && !chatHistoryTroopMemberFragmentV18.D1) {
                                    List<String> list = this.I;
                                    if (list != null && list.contains(wVar4.f182667a)) {
                                        arrayList8.add(wVar4);
                                        wVar4.E = true;
                                    } else {
                                        arrayList11.add(wVar4);
                                        wVar4.E = false;
                                    }
                                }
                            } else {
                                List<String> list2 = this.I;
                                if (list2 != null && list2.contains(wVar4.f182667a)) {
                                    wVar4.E = true;
                                    MemberRole memberRole2 = wVar4.M;
                                    if (memberRole2 != MemberRole.OWNER && memberRole2 != MemberRole.ADMIN) {
                                        if (ChatHistoryTroopMemberFragmentV1.this.E) {
                                            int i28 = wVar4.f182690x;
                                            if (i28 != 332 && i28 != 333) {
                                            }
                                        }
                                        arrayList10.add(wVar4);
                                    }
                                    arrayList9.add(wVar4);
                                } else {
                                    wVar4.E = false;
                                    arrayList11.add(wVar4);
                                }
                            }
                        }
                        linkedHashMap2.clear();
                        Collections.sort(arrayList8, new x(1, false));
                        if (arrayList8.size() > 0) {
                            linkedHashMap2.put(ChatHistoryTroopMemberFragmentV1.this.getString(R.string.i8u), arrayList8);
                        }
                        if (arrayList9.size() > 0) {
                            Collections.sort(arrayList9, new x(1, false));
                            ChatHistoryTroopMemberFragmentV1.this.lj(arrayList9);
                            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV19 = ChatHistoryTroopMemberFragmentV1.this;
                            linkedHashMap2.put(chatHistoryTroopMemberFragmentV19.E ? chatHistoryTroopMemberFragmentV19.getString(R.string.cnz) : chatHistoryTroopMemberFragmentV19.getString(R.string.cny), arrayList9);
                        }
                        Collections.sort(arrayList10, new x(1, false));
                        if (arrayList10.size() > 0) {
                            linkedHashMap2.put(ChatHistoryTroopMemberFragmentV1.this.getString(R.string.i8q), arrayList10);
                        }
                        Collections.sort(arrayList11, new x(1, false));
                        if (arrayList11.size() > 0) {
                            linkedHashMap2.put(ChatHistoryTroopMemberFragmentV1.this.getString(R.string.i8p), arrayList11);
                        }
                    } else if (i16 == 7) {
                        ArrayList arrayList12 = new ArrayList();
                        ArrayList arrayList13 = new ArrayList();
                        ArrayList arrayList14 = new ArrayList();
                        ArrayList arrayList15 = new ArrayList();
                        int size2 = ChatHistoryTroopMemberFragmentV1.this.T.size();
                        HashMap hashMap = new HashMap(size2);
                        for (int i29 = 0; i29 < size2; i29++) {
                            w wVar5 = ChatHistoryTroopMemberFragmentV1.this.T.get(i29);
                            wVar5.H = 0;
                            hashMap.put(wVar5.f182667a, wVar5);
                        }
                        if (ChatHistoryTroopMemberFragmentV1.this.f182598r1 != null) {
                            for (int i36 = 0; i36 < ChatHistoryTroopMemberFragmentV1.this.f182598r1.length; i36++) {
                                w wVar6 = (w) hashMap.remove(String.valueOf(ChatHistoryTroopMemberFragmentV1.this.f182598r1[i36]));
                                if (wVar6 != null) {
                                    arrayList12.add(wVar6);
                                }
                            }
                        }
                        if (ChatHistoryTroopMemberFragmentV1.this.f182600s1 != null) {
                            for (int i37 = 0; i37 < ChatHistoryTroopMemberFragmentV1.this.f182600s1.length; i37++) {
                                w wVar7 = (w) hashMap.remove(String.valueOf(ChatHistoryTroopMemberFragmentV1.this.f182600s1[i37]));
                                if (wVar7 != null) {
                                    arrayList13.add(wVar7);
                                }
                            }
                        }
                        if (ChatHistoryTroopMemberFragmentV1.this.f182602t1 != null) {
                            for (int i38 = 0; i38 < ChatHistoryTroopMemberFragmentV1.this.f182602t1.length; i38++) {
                                w wVar8 = (w) hashMap.remove(String.valueOf(ChatHistoryTroopMemberFragmentV1.this.f182602t1[i38]));
                                if (wVar8 != null) {
                                    arrayList14.add(wVar8);
                                }
                            }
                        }
                        Iterator it6 = hashMap.entrySet().iterator();
                        while (it6.hasNext()) {
                            arrayList15.add((w) ((Map.Entry) it6.next()).getValue());
                        }
                        Collections.sort(arrayList12, new x(2, true));
                        if (!arrayList12.isEmpty()) {
                            linkedHashMap2.put(HardCodeUtil.qqStr(R.string.kdj), arrayList12);
                        }
                        if (!arrayList13.isEmpty()) {
                            linkedHashMap2.put(HardCodeUtil.qqStr(R.string.kf6), arrayList13);
                        }
                        if (!arrayList14.isEmpty()) {
                            linkedHashMap2.put(HardCodeUtil.qqStr(R.string.ke9), arrayList14);
                        }
                        Collections.sort(arrayList15, new x(2, true));
                        if (!arrayList15.isEmpty()) {
                            linkedHashMap2.put(HardCodeUtil.qqStr(R.string.kd5), arrayList15);
                        }
                    } else if (i16 == 8) {
                        ArrayList arrayList16 = new ArrayList();
                        ArrayList arrayList17 = new ArrayList();
                        HashMap hashMap2 = new HashMap();
                        List<oidb_0xa2a$UserInfo> list3 = this.J;
                        if (list3 != null) {
                            int size3 = list3.size();
                            for (int i39 = 0; i39 < size3; i39++) {
                                oidb_0xa2a$UserInfo oidb_0xa2a_userinfo = this.J.get(i39);
                                hashMap2.put(String.valueOf(oidb_0xa2a_userinfo.uin.get()), oidb_0xa2a_userinfo);
                            }
                        }
                        for (w wVar9 : ChatHistoryTroopMemberFragmentV1.this.T) {
                            oidb_0xa2a$UserInfo oidb_0xa2a_userinfo2 = (oidb_0xa2a$UserInfo) hashMap2.get(wVar9.f182667a);
                            if (oidb_0xa2a_userinfo2 != null) {
                                arrayList16.add(wVar9);
                                wVar9.L = oidb_0xa2a_userinfo2.score.get();
                            } else {
                                arrayList17.add(wVar9);
                            }
                        }
                        if (arrayList16.size() > 0) {
                            Collections.sort(arrayList16, new x(8, false));
                            linkedHashMap2.put(HardCodeUtil.qqStr(R.string.ke5), arrayList16);
                        }
                        if (arrayList17.size() > 0) {
                            Collections.sort(arrayList17, new x(8, false));
                            linkedHashMap2.put(HardCodeUtil.qqStr(R.string.kdy), arrayList17);
                        }
                    } else if (i16 == 4) {
                        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                        String[] stringArray3 = ChatHistoryTroopMemberFragmentV1.this.getResources().getStringArray(R.array.f155247bx);
                        String qqStr = HardCodeUtil.qqStr(R.string.kda);
                        for (w wVar10 : ChatHistoryTroopMemberFragmentV1.this.T) {
                            int i46 = wVar10.f182690x;
                            if (i46 >= 10000) {
                                i46 -= 10000;
                            }
                            if (i46 >= 321 && i46 <= 327) {
                                String str7 = stringArray3[i46 - 321];
                                if (linkedHashMap4.get(str7) == null) {
                                    linkedHashMap4.put(str7, new ArrayList());
                                }
                                ((List) linkedHashMap4.get(str7)).add(wVar10);
                            } else {
                                if (linkedHashMap4.get(qqStr) == null) {
                                    linkedHashMap4.put(qqStr, new ArrayList());
                                }
                                ((List) linkedHashMap4.get(qqStr)).add(wVar10);
                            }
                        }
                        for (int length3 = stringArray3.length - 1; length3 >= 0; length3--) {
                            if (linkedHashMap4.get(stringArray3[length3]) != null) {
                                Collections.sort((List) linkedHashMap4.get(stringArray3[length3]), new x(0, false));
                                String str8 = stringArray3[length3];
                                linkedHashMap2.put(str8, (List) linkedHashMap4.get(str8));
                            }
                        }
                        if (linkedHashMap4.get(qqStr) != null) {
                            Collections.sort((List) linkedHashMap4.get(qqStr), new x(0, false));
                            linkedHashMap2.put(qqStr, (List) linkedHashMap4.get(qqStr));
                        }
                        hl0.a.b(null, "846", "205607", "", "84601", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD);
                    }
                    linkedHashMap2 = linkedHashMap;
                }
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV110 = ChatHistoryTroopMemberFragmentV1.this;
                if (chatHistoryTroopMemberFragmentV110.L) {
                    linkedHashMap2.remove(chatHistoryTroopMemberFragmentV110.getString(R.string.hor));
                }
                int size4 = linkedHashMap2.keySet().size();
                int[] iArr = new int[size4];
                String[] strArr = new String[size4];
                Iterator it7 = linkedHashMap2.keySet().iterator();
                if (size4 == 0) {
                    return new Object[0];
                }
                iArr[0] = 0;
                for (int i47 = 1; i47 < size4; i47++) {
                    iArr[i47] = iArr[i47] + iArr[i47 - 1] + ((List) linkedHashMap2.get(it7.next())).size() + 1;
                }
                Iterator it8 = linkedHashMap2.keySet().iterator();
                int i48 = 0;
                while (it8.hasNext()) {
                    strArr[i48] = (String) it8.next();
                    i48++;
                }
                ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV111 = ChatHistoryTroopMemberFragmentV1.this;
                if (chatHistoryTroopMemberFragmentV111.J0 == 0) {
                    chatHistoryTroopMemberFragmentV111.nj(iArr);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    c16 = 2;
                    QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "constructHashStruct, time:" + (currentTimeMillis2 - j3) + ", sortType:" + ChatHistoryTroopMemberFragmentV1.this.L1 + ", listSize:" + ChatHistoryTroopMemberFragmentV1.this.T.size());
                } else {
                    c16 = 2;
                }
                Object[] objArr = new Object[3];
                objArr[0] = linkedHashMap2;
                objArr[1] = iArr;
                objArr[c16] = strArr;
                return objArr;
            }
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public int getCount() {
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
            if (chatHistoryTroopMemberFragmentV1.J0 == 9) {
                List<w> list = chatHistoryTroopMemberFragmentV1.T;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            int[] iArr = this.E;
            if (iArr.length == 0) {
                return 0;
            }
            return iArr[iArr.length - 1] + this.D.get(this.F[r2.length - 1]).size() + 1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            if (ChatHistoryTroopMemberFragmentV1.this.J0 == 9) {
                return 0;
            }
            return R.layout.f168255qg;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public Object getItem(int i3) {
            if (ChatHistoryTroopMemberFragmentV1.this.J0 == 9) {
                if (i3 < 0 || i3 > r0.T.size() - 1) {
                    return null;
                }
                return ChatHistoryTroopMemberFragmentV1.this.T.get(i3);
            }
            int binarySearch = Arrays.binarySearch(this.E, i3);
            if (binarySearch >= 0) {
                return null;
            }
            return this.D.get(this.F[(-(binarySearch + 1)) - 1]).get((i3 - this.E[r0]) - 1);
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            int binarySearch;
            if (!ChatHistoryTroopMemberFragmentV1.this.Gi() || (binarySearch = Arrays.binarySearch(this.E, i3)) >= 0) {
                return 0;
            }
            int i16 = (-(binarySearch + 1)) - 1;
            w wVar = this.D.get(this.F[i16]).get((i3 - this.E[i16]) - 1);
            return (!TextUtils.isEmpty(wVar.f182680n) || TextUtils.isEmpty(wVar.f182684r) || TextUtils.isEmpty(wVar.f182674h) || wVar.f182674h.equals(wVar.f182684r)) ? 0 : 1;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            com.tencent.mobileqq.troop.widget.e eVar;
            IndexView indexView;
            int itemViewType = getItemViewType(i3);
            if (view == null) {
                if (itemViewType == 0) {
                    view = ChatHistoryTroopMemberFragmentV1.this.f182603u0.inflate(R.layout.c1x, viewGroup, false);
                    eVar = new com.tencent.mobileqq.troop.widget.e(view, false);
                } else {
                    view = ChatHistoryTroopMemberFragmentV1.this.f182603u0.inflate(R.layout.c1z, viewGroup, false);
                    eVar = new com.tencent.mobileqq.troop.widget.e(view, true);
                }
                view.setTag(eVar);
            } else {
                eVar = (com.tencent.mobileqq.troop.widget.e) view.getTag();
            }
            eVar.position = i3;
            eVar.f187210d = "";
            ChatHistoryTroopMemberFragmentV1 chatHistoryTroopMemberFragmentV1 = ChatHistoryTroopMemberFragmentV1.this;
            if (chatHistoryTroopMemberFragmentV1.J0 == 9) {
                ChatHistoryTroopMemberFragmentV1.this.dj(eVar, chatHistoryTroopMemberFragmentV1.T.get(i3), false, false);
            } else {
                int binarySearch = Arrays.binarySearch(this.E, i3);
                if (binarySearch < 0) {
                    int i16 = (-(binarySearch + 1)) - 1;
                    w wVar = this.D.get(this.F[i16]).get((i3 - this.E[i16]) - 1);
                    if (wVar.D) {
                        SpannableString j3 = new com.tencent.mobileqq.text.c(wVar.f182669c, 16).j();
                        eVar.tvName.setText(j3);
                        com.tencent.mobileqq.vas.f.q(ChatHistoryTroopMemberFragmentV1.this.E1, eVar.tvName, j3);
                        eVar.f187213h.setImageResource(R.drawable.device_search_icon);
                        eVar.troopMember.setOnClickListener(ChatHistoryTroopMemberFragmentV1.this.Q1);
                    } else {
                        ChatHistoryTroopMemberFragmentV1.this.dj(eVar, wVar, false, itemViewType == 1);
                    }
                    if (ChatHistoryTroopMemberFragmentV1.this.J0 == 12) {
                        if (this.G.contains(wVar)) {
                            eVar.selectedIcon.setVisibility(0);
                        } else {
                            eVar.selectedIcon.setVisibility(8);
                        }
                    }
                    if (ChatHistoryTroopMemberFragmentV1.this.K) {
                        eVar.addFrdLayout.setVisibility(8);
                    }
                } else {
                    eVar.troopMember.c(false);
                    eVar.troopMember.setVisibility(8);
                    eVar.feedback.setVisibility(8);
                    eVar.selectedIcon.setVisibility(8);
                    eVar.troopMember.setOnClickListener(null);
                    int i17 = ChatHistoryTroopMemberFragmentV1.this.J0;
                    if (i17 != 9 && i17 != 19) {
                        eVar.divider.setVisibility(0);
                        List<w> list = this.D.get(this.F[binarySearch]);
                        if (list != null) {
                            if (ChatHistoryTroopMemberFragmentV1.this.getString(R.string.i8u).equals(String.valueOf(this.F[binarySearch]))) {
                                eVar.divider.setText(String.valueOf(this.F[binarySearch]));
                            } else {
                                eVar.divider.setText(String.valueOf(this.F[binarySearch]) + ChatHistoryTroopMemberFragmentV1.this.getString(R.string.iha, Integer.valueOf(list.size())));
                            }
                        }
                    } else {
                        eVar.divider.setVisibility(8);
                    }
                    if (ChatHistoryTroopMemberFragmentV1.this.J0 == 12) {
                        List<w> list2 = this.D.get(this.F[binarySearch]);
                        int i18 = (i3 - this.E[binarySearch]) - 1;
                        if (i18 >= 0 && i18 < list2.size()) {
                            if (this.G.contains(list2.get(i18))) {
                                eVar.selectedIcon.setVisibility(0);
                            } else {
                                eVar.selectedIcon.setVisibility(8);
                            }
                        }
                    }
                    eVar.troopMember.setContentDescription("");
                }
            }
            if (eVar.rightSpace != null && (indexView = ChatHistoryTroopMemberFragmentV1.this.f182591o0) != null) {
                if (indexView.getVisibility() == 0) {
                    eVar.rightSpace.setVisibility(0);
                } else {
                    eVar.rightSpace.setVisibility(8);
                }
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        public String h(String[] strArr, long j3, Calendar calendar) {
            Calendar calendar2 = Calendar.getInstance();
            if (j3 > 0) {
                calendar2.setTimeInMillis(j3 * 1000);
            } else {
                calendar2.set(1, 2012);
                calendar2.set(2, 5);
                calendar2.set(5, 1);
            }
            int i3 = (((calendar.get(1) - calendar2.get(1)) * 365) + calendar.get(6)) - calendar2.get(6);
            if (i3 <= 0) {
                return strArr[0];
            }
            if (i3 <= 7) {
                return strArr[1];
            }
            if (i3 <= 30) {
                return strArr[2];
            }
            if (i3 <= 90) {
                return strArr[3];
            }
            if (i3 <= 180) {
                return strArr[4];
            }
            if (i3 <= 365) {
                return strArr[5];
            }
            if (i3 <= 730) {
                return strArr[6];
            }
            if (i3 <= 1095) {
                return strArr[7];
            }
            if (i3 <= 1825) {
                return strArr[8];
            }
            if (i3 <= 2555) {
                return strArr[9];
            }
            if (i3 <= 3650) {
                return strArr[10];
            }
            return strArr[11];
        }

        public int i(String str) {
            if (this.F != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = this.F;
                    if (i3 >= strArr.length) {
                        i3 = -1;
                        break;
                    }
                    if (strArr[i3].equals(str)) {
                        break;
                    }
                    i3++;
                }
                if (i3 >= 0) {
                    return this.E[i3];
                }
            }
            return -1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            return ChatHistoryTroopMemberFragmentV1.this.J0 != 9 && Arrays.binarySearch(this.E, i3) >= 0;
        }

        public void k() {
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "mAdapter.notifyDataSetChanged2()");
            }
            QLog.d(".troop.troopManagerVASH", 2, "notifyDataSetChanged2 List count: ", Integer.valueOf(ChatHistoryTroopMemberFragmentV1.this.T.size()));
            Object[] g16 = g();
            if (g16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ChatHistoryTroopMemberFragmentV1", 2, "constructHashStruct result == null!");
                    return;
                }
                return;
            }
            if (g16.length >= 3) {
                this.D = (LinkedHashMap) g16[0];
                this.E = (int[]) g16[1];
                this.F = (String[]) g16[2];
                ChatHistoryTroopMemberFragmentV1.this.vi().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.history.compat.ChatHistoryTroopMemberFragmentV1.ListAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ListAdapter.this.notifyDataSetChanged();
                    }
                });
                return;
            }
            if (g16.length == 0) {
                int i3 = ChatHistoryTroopMemberFragmentV1.this.J0;
                if (i3 == 13 || i3 == 21) {
                    this.D.clear();
                    this.E = new int[0];
                    this.F = new String[0];
                    notifyDataSetChanged();
                }
            }
        }

        public String j(String[] strArr, long j3, Calendar calendar) {
            if (j3 == 0) {
                return strArr[7];
            }
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j3 * 1000);
            int i3 = (((calendar.get(1) - calendar2.get(1)) * 365) + calendar.get(6)) - calendar2.get(6);
            if (i3 <= 0) {
                return strArr[0];
            }
            if (i3 <= 7) {
                return strArr[1];
            }
            if (i3 <= 30) {
                return strArr[2];
            }
            if (i3 <= 90) {
                return strArr[3];
            }
            if (i3 <= 180) {
                return strArr[4];
            }
            if (i3 <= 365) {
                return strArr[5];
            }
            return strArr[6];
        }
    }

    protected void ni(w wVar) {
        String str;
        if (wVar != null && wVar.D) {
            this.U.G.clear();
            Intent intent = new Intent();
            intent.putExtra("result", new JSONArray().toString());
            vi().setResult(-1, intent);
            ReportController.o(this.E1, "P_CliOper", "Grp_work", "", OperateCustomButton.OPERATE_CREATE, "Clk_none", 0, 0, this.G, "", "", "");
            vi().finish();
            return;
        }
        if (wVar == null || (str = wVar.f182667a) == null) {
            return;
        }
        IHistoryBridgeInterface.b bVar = this.G1;
        if (bVar != null) {
            bVar.invoke(0, str, wVar.f182669c);
        }
        ReportController.o(this.E1, "CliOper", "", "", "0X800A596", "0X800A596", 1, 0, "", "", "", "");
        if (this.J0 == 18) {
            com.tencent.imcore.message.report.a.i(this.E1, 9, 2);
            com.tencent.imcore.message.report.a.j(this.E1, 8, 2);
        }
        if (this.J0 == 19) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(this.f182599s0.troopUin, this.E1.getCurrentAccountUin(), false, this, "ChatHistoryTroopMemberFragmentV1", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.activity.history.compat.h
                @Override // com.tencent.qqnt.troopmemberlist.g
                public final void a(TroopMemberInfo troopMemberInfo) {
                    ChatHistoryTroopMemberFragmentV1.this.Ii(troopMemberInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f182641d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TranslateAnimation f182642e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f182643f;

        c(TranslateAnimation translateAnimation, TranslateAnimation translateAnimation2, int i3) {
            this.f182641d = translateAnimation;
            this.f182642e = translateAnimation2;
            this.f182643f = i3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (animation == this.f182641d) {
                ChatHistoryTroopMemberFragmentV1.this.O1.show();
                ChatHistoryTroopMemberFragmentV1.this.f182571e0.setAnimation(null);
                ChatHistoryTroopMemberFragmentV1.this.W.setVisibility(8);
            } else if (animation == this.f182642e) {
                ChatHistoryTroopMemberFragmentV1.this.f182571e0.setAnimation(null);
                ChatHistoryTroopMemberFragmentV1.this.f182571e0.offsetTopAndBottom(this.f182643f);
                ChatHistoryTroopMemberFragmentV1.this.f182571e0.requestLayout();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class aa implements TextWatcher {
        protected aa() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ChatHistoryTroopMemberFragmentV1.this.Zi(ChatHistoryTroopMemberFragmentV1.this.f182575g0.getText().toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
    }
}
