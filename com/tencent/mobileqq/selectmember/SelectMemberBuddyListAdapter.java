package com.tencent.mobileqq.selectmember;

import Wallet.PfaFriend;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcircle.api.IQCircleFollowApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopRobotApi;
import com.tencent.mobileqq.troop.troopcreate.RelationTroopEntity;
import com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import com.tencent.robot.api.IRobotDiscoveryApi;
import com.tencent.robot.troop.discovery.LaunchSourceType;
import com.tencent.robot.troop.discovery.TroopRobotDiscoveryLaunchArgs;
import com.tencent.widget.AbsListView;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import vd2.GroupInfo;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SelectMemberBuddyListAdapter extends com.tencent.mobileqq.selectmember.adapter.a implements View.OnClickListener, View.OnLongClickListener, od2.a, IToPayManager.a {
    static IPatchRedirector $redirector_;
    private final AppInterface C;
    private final ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> D;
    private final SparseArray<ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>> E;
    private final SparseArray<ArrayList<Object>> F;
    private AbsListView.OnScrollListener G;
    private final View.OnClickListener H;
    private ExpandableListView I;
    private IToPayManager J;
    private IPhoneContactService K;
    private boolean L;
    private final boolean M;
    private boolean N;
    private final boolean P;
    private final ArrayList<String> Q;
    private ArrayList<RobotCoreInfo> R;
    private boolean S;
    private RelationFriendsTroopViewHelper T;
    private final int U;
    private final int V;
    private com.tencent.mobileqq.troop.api.c W;
    private hx3.b X;
    g Y;
    ArrayList<TroopMemberInfo> Z;

    /* renamed from: a0, reason: collision with root package name */
    private final View.OnClickListener f285738a0;

    /* renamed from: i, reason: collision with root package name */
    protected SelectMemberActivity f285739i;

    /* renamed from: m, reason: collision with root package name */
    private final Context f285740m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.selectmember.SelectMemberBuddyListAdapter$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass1 implements hx3.b {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberBuddyListAdapter.this);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (eVar.a() != 0) {
                if (SelectMemberBuddyListAdapter.this.I != null && SelectMemberBuddyListAdapter.this.L) {
                    SelectMemberBuddyListAdapter.this.I.expandGroup(0);
                }
                SelectMemberBuddyListAdapter.super.notifyDataSetChanged();
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(eVar) { // from class: com.tencent.mobileqq.selectmember.SelectMemberBuddyListAdapter.1.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.qqnt.ntrelation.friendsinfo.bean.e f285742d;

                {
                    this.f285742d = eVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) eVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ArrayList b16 = this.f285742d.b();
                    String currentAccountUin = SelectMemberBuddyListAdapter.this.C.getCurrentAccountUin();
                    Iterator it = b16.iterator();
                    while (it.hasNext()) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) it.next();
                        if (bVar.d() != ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getSpecialCareCategoryId()) {
                            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> b17 = bVar.b();
                            if (SelectMemberBuddyListAdapter.this.W != null) {
                                SelectMemberBuddyListAdapter.this.W.a(b17);
                            }
                            ArrayList arrayList = new ArrayList();
                            Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it5 = b17.iterator();
                            while (it5.hasNext()) {
                                com.tencent.qqnt.ntrelation.friendsinfo.bean.d next = it5.next();
                                if (next != null && (SelectMemberBuddyListAdapter.this.f285739i.mShowMyself || !next.x().equals(currentAccountUin))) {
                                    if (!SelectMemberBuddyListAdapter.this.f285739i.mUinsToHide.contains(next.x())) {
                                        arrayList.add(next);
                                    }
                                }
                            }
                            if (SelectMemberBuddyListAdapter.this.W == null || !arrayList.isEmpty()) {
                                SelectMemberBuddyListAdapter.this.D.add(bVar);
                                SelectMemberBuddyListAdapter.this.E.put(bVar.d(), arrayList);
                            }
                        }
                    }
                    SelectMemberBuddyListAdapter.this.v();
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.selectmember.SelectMemberBuddyListAdapter.1.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) RunnableC85661.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (SelectMemberBuddyListAdapter.this.I != null && SelectMemberBuddyListAdapter.this.L) {
                                SelectMemberBuddyListAdapter.this.I.expandGroup(0);
                            }
                            SelectMemberBuddyListAdapter.super.notifyDataSetChanged();
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f285747d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f285748e;

        a(String str, Context context) {
            this.f285747d = str;
            this.f285748e = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SelectMemberBuddyListAdapter.this, str, context);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (TextUtils.isEmpty(this.f285747d)) {
                QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 1, "[addRobotInviteLayout]: onClick, troop uin is null");
            } else {
                ((IRobotDiscoveryApi) QRoute.api(IRobotDiscoveryApi.class)).launchTroopRobotDiscoveryPage(new TroopRobotDiscoveryLaunchArgs(this.f285748e, this.f285747d, LaunchSourceType.UNKNOWN));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements BubblePopupWindow.OnDismissListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberBuddyListAdapter.this);
            }
        }

        @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberBuddyListAdapter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).startGroupManager((Activity) SelectMemberBuddyListAdapter.this.f285740m);
                ReportController.o(SelectMemberBuddyListAdapter.this.C, "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f285752a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f285753b;

        /* renamed from: c, reason: collision with root package name */
        public CheckBox f285754c;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class e extends com.tencent.mobileqq.selectmember.f {
        static IPatchRedirector $redirector_;
        public ImageView E;
        public TextView F;
        public TextView G;
        public TextView H;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f285755a;

        public f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.f285755a = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        boolean f285756d;

        /* renamed from: e, reason: collision with root package name */
        protected IFaceDecoder f285757e;

        public g(Context context, AppInterface appInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SelectMemberBuddyListAdapter.this, context, appInterface);
                return;
            }
            this.f285756d = false;
            IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
            this.f285757e = iQQAvatarService;
            iQQAvatarService.setDecodeTaskCompletionListener(this);
        }

        private Bitmap c(String str, int i3, byte b16, int i16) {
            IFaceDecoder iFaceDecoder = this.f285757e;
            if (iFaceDecoder == null) {
                return null;
            }
            Bitmap bitmapFromCacheFrom = iFaceDecoder.getBitmapFromCacheFrom(i3, str, i16);
            if (bitmapFromCacheFrom != null) {
                return bitmapFromCacheFrom;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 4, "requestDecodeFace, uin[" + str + "]");
            }
            this.f285757e.requestDecodeFace(str, i3, true, b16);
            return BaseImageUtil.getDefaultFaceBitmap();
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                IFaceDecoder iFaceDecoder = this.f285757e;
                if (iFaceDecoder != null) {
                    iFaceDecoder.destory();
                    this.f285757e = null;
                }
            } catch (Exception unused) {
                this.f285757e = null;
            }
            this.f285756d = true;
        }

        public Bitmap b(TroopMemberInfo troopMemberInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopMemberInfo);
            }
            return c(troopMemberInfo.memberuin, 1, (byte) 0, 0);
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 4, "onDecodeTaskCompleted, uin[" + str + "]");
            }
            if (!this.f285756d) {
                SelectMemberBuddyListAdapter.this.b(str, bitmap);
            }
        }
    }

    public SelectMemberBuddyListAdapter(Context context, AppInterface appInterface, ExpandableListView expandableListView, View.OnClickListener onClickListener, boolean z16) {
        super(context, appInterface, expandableListView);
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, expandableListView, onClickListener, Boolean.valueOf(z16));
            return;
        }
        this.D = new ArrayList<>();
        this.E = new SparseArray<>();
        this.F = new SparseArray<>();
        this.K = null;
        this.L = true;
        this.N = true;
        this.Q = new ArrayList<>();
        this.R = new ArrayList<>();
        this.X = new AnonymousClass1();
        this.Y = null;
        this.f285738a0 = new c();
        SelectMemberActivity selectMemberActivity = (SelectMemberActivity) context;
        this.f285739i = selectMemberActivity;
        int i3 = selectMemberActivity.mSubType;
        if (i3 != 0 && i3 != 1) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.P = z17;
        if (selectMemberActivity.getIntent() != null) {
            this.N = this.f285739i.getIntent().getBooleanExtra(ISelectMemberActivityConstants.PARAM_SHOW_ROBOT_GROUP, true);
        }
        F();
        this.J = (IToPayManager) QRoute.api(IToPayManager.class);
        this.f285740m = context;
        this.C = appInterface;
        this.H = onClickListener;
        this.K = (IPhoneContactService) appInterface.getRuntimeService(IPhoneContactService.class, "");
        this.L = z16;
        this.I = expandableListView;
        ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(appInterface, new RecentContactListener() { // from class: com.tencent.mobileqq.selectmember.SelectMemberBuddyListAdapter.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectMemberBuddyListAdapter.this);
                }
            }

            @Override // com.tencent.relation.common.nt.listener.RecentContactListener
            public void onResult(@NonNull List<RecentUser> list) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                } else if (SelectMemberBuddyListAdapter.this.I != null) {
                    SelectMemberBuddyListAdapter.this.I.post(new Runnable() { // from class: com.tencent.mobileqq.selectmember.SelectMemberBuddyListAdapter.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                SelectMemberBuddyListAdapter.this.notifyDataSetChanged();
                            }
                        }
                    });
                }
            }
        }, false);
        if (!this.f285739i.mDonotNeedContacts) {
            this.K.addListener(this);
        }
        this.U = (int) al.a(context, 12.0f);
        this.V = (int) al.a(context, 9.0f);
        DeviceInfoMonitor.getModel().equals("Lenovo A366t");
        this.M = false;
    }

    private View B(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        com.tencent.mobileqq.selectmember.d dVar;
        if (view == null) {
            view = LayoutInflater.from(this.f285740m).inflate(R.layout.act, viewGroup, false);
            dVar = new com.tencent.mobileqq.selectmember.d();
            dVar.f187212f = (ImageView) view.findViewById(R.id.icon);
            dVar.f285963i = (TextView) view.findViewById(R.id.f5e);
            dVar.C = (CheckBox) view.findViewById(R.id.axa);
            dVar.E = view.findViewById(R.id.kab);
            View.OnClickListener onClickListener = this.H;
            if (onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
            view.setTag(dVar);
        } else {
            dVar = (com.tencent.mobileqq.selectmember.d) view.getTag();
            dVar.f285963i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        Object child = getChild(i3, i16);
        PhoneContact phoneContact = (PhoneContact) child;
        dVar.D = child;
        dVar.f187210d = phoneContact.mobileCode;
        c(dVar, null);
        View view2 = dVar.E;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        dVar.f187212f.setImageDrawable(null);
        dVar.f285963i.setText(phoneContact.name);
        if (this.f285739i.isResultListContainFriend(dVar.f187210d)) {
            dVar.C.setChecked(true);
        } else {
            dVar.C.setChecked(false);
        }
        if (this.f285739i.mUinsSelectedDefault != null && !"0".equals(phoneContact.uin) && this.f285739i.mUinsSelectedDefault.contains(phoneContact.uin)) {
            dVar.C.setEnabled(false);
        } else {
            dVar.C.setEnabled(true);
        }
        if (AppSetting.f99565y && dVar.C.isEnabled()) {
            if (dVar.C.isChecked()) {
                view.setContentDescription(phoneContact.name + HardCodeUtil.qqStr(R.string.t9q));
            } else {
                view.setContentDescription(phoneContact.name + HardCodeUtil.qqStr(R.string.t_4));
            }
        }
        return view;
    }

    private View C(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        e eVar;
        if (view != null && !(view.getTag() instanceof com.tencent.mobileqq.selectmember.d)) {
            eVar = (e) view.getTag();
            eVar.f285963i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            view = LayoutInflater.from(this.f285740m).inflate(R.layout.f168420vn, viewGroup, false);
            eVar = new e();
            eVar.f187212f = (ImageView) view.findViewById(R.id.icon);
            eVar.E = (ImageView) view.findViewById(R.id.ccn);
            eVar.f285963i = (TextView) view.findViewById(R.id.text1);
            eVar.F = (TextView) view.findViewById(R.id.g4_);
            eVar.H = (TextView) view.findViewById(R.id.g3t);
            eVar.G = (TextView) view.findViewById(R.id.g4j);
            eVar.f285964m = (TextView) view.findViewById(R.id.text2);
            view.setTag(eVar);
            View.OnClickListener onClickListener = this.H;
            if (onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
        }
        Object child = getChild(i3, i16);
        eVar.D = child;
        eVar.f187210d = Long.toString(((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoUin(child));
        eVar.f285963i.setTextColor(this.f285740m.getResources().getColorStateList(R.color.skin_black));
        if (((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).isPublicAccountInfoLooker(child)) {
            eVar.H.setVisibility(0);
            eVar.f285963i.setVisibility(8);
            eVar.E.setVisibility(8);
            eVar.f187212f.setImageDrawable(null);
            eVar.F.setVisibility(8);
            eVar.G.setVisibility(8);
            eVar.f285964m.setVisibility(8);
        } else {
            eVar.H.setVisibility(8);
            eVar.f285963i.setVisibility(0);
            eVar.f285964m.setVisibility(0);
            String publicAccountInfoName = ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoName(child);
            long publicAccountInfoCertifiedGrade = ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoCertifiedGrade(child);
            String publicAccountInfoSummary = ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoSummary(child);
            eVar.f285963i.setText(publicAccountInfoName);
            if (publicAccountInfoCertifiedGrade > 0) {
                eVar.E.setVisibility(0);
                eVar.E.setBackgroundResource(R.drawable.br7);
            } else {
                eVar.E.setVisibility(8);
            }
            eVar.f285964m.setText(publicAccountInfoSummary);
            c(eVar, null);
            eVar.F.setVisibility(8);
            eVar.G.setVisibility(8);
        }
        if (AppSetting.f99565y) {
            view.setContentDescription(eVar.f285963i.getText());
        }
        return view;
    }

    private ArrayList<RobotCoreInfo> D() {
        int size;
        ac robotService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getRobotService();
        if (robotService == null) {
            return null;
        }
        ArrayList<RobotCoreInfo> allRobotFriendsFromCache = robotService.getAllRobotFriendsFromCache();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getRobotCoreInfo: size=");
        if (allRobotFriendsFromCache == null) {
            size = 0;
        } else {
            size = allRobotFriendsFromCache.size();
        }
        sb5.append(size);
        QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 1, sb5.toString());
        return allRobotFriendsFromCache;
    }

    private View E(int i3, int i16, View view) {
        if (view != null) {
            return view;
        }
        f fVar = (f) getChild(i3, i16);
        Context context = this.f285740m;
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelOffset(R.dimen.f158565j4));
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        int dpToPx = ViewUtils.dpToPx(20.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams2.leftMargin = ViewUtils.dpToPx(19.0f);
        layoutParams2.gravity = 16;
        imageView.setLayoutParams(layoutParams2);
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.lkd));
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        layoutParams3.leftMargin = ViewUtils.dpToPx(19.0f);
        textView.setLayoutParams(layoutParams3);
        textView.setText(R.string.f224916k8);
        textView.setTextSize(0, ViewUtils.dpToPx(17.0f));
        textView.setTextColor(context.getResources().getColor(R.color.qui_common_text_link));
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        linearLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        linearLayout.setOnClickListener(new a(fVar.f285755a, context));
        VideoReport.setElementId(linearLayout, "em_group_choose_more_robot");
        VideoReport.setElementClickPolicy(linearLayout, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(linearLayout, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(linearLayout, EndExposurePolicy.REPORT_NONE);
        return linearLayout;
    }

    private void F() {
        ArrayList<RobotCoreInfo> D = D();
        if (D != null && this.P) {
            Iterator<RobotCoreInfo> it = D.iterator();
            while (it.hasNext()) {
                RobotCoreInfo next = it.next();
                if (!next.allowAddGroup) {
                    this.Q.add(String.valueOf(next.robotUin));
                } else {
                    this.R.add(next);
                }
            }
        }
    }

    private int G(int i3, int i16) {
        if (this.D.get(i3).d() == 1002) {
            return 1;
        }
        if (this.D.get(i3).d() == 1008) {
            return 2;
        }
        if (getChild(i3, i16) instanceof f) {
            return 3;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.D.clear();
        this.E.clear();
        SparseArray<ArrayList<Object>> sparseArray = new SparseArray<>();
        this.T.h(this.D, sparseArray);
        ArrayList<Object> arrayList = sparseArray.get(1008);
        if (arrayList != null) {
            this.F.put(1008, new ArrayList<>(new ArrayList(Arrays.asList((Entity[]) arrayList.toArray(new Entity[0])))));
        }
        ArrayList<Object> arrayList2 = sparseArray.get(1007);
        if (arrayList2 != null) {
            this.E.put(1007, new ArrayList<>(Arrays.asList((com.tencent.qqnt.ntrelation.friendsinfo.bean.d[]) arrayList2.toArray(new com.tencent.qqnt.ntrelation.friendsinfo.bean.d[0]))));
        }
        SelectMemberActivity selectMemberActivity = this.f285739i;
        if (selectMemberActivity.mEntrance == 11 && selectMemberActivity.mType == 1) {
            r();
        }
        if (this.f285739i.mEntrance == 33) {
            w();
        } else {
            u();
        }
        int i3 = this.f285739i.mEntrance;
        if (i3 == 42 || i3 == 41) {
            q();
        }
        t();
        s();
    }

    private void I() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.f285739i.mEntrance == 42) {
            hashMap.put("ext1", "2");
        } else {
            hashMap.put("ext1", "1");
        }
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(41).setSubActionType(1).setThrActionType(1).setExtras(hashMap));
    }

    private void J(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    private void q() {
        ArrayList arrayList;
        Map<GroupInfo, List<Entity>> circleFriendMap = ((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).getCircleFriendMap();
        if (circleFriendMap != null && !circleFriendMap.isEmpty()) {
            Iterator<Map.Entry<GroupInfo, List<Entity>>> it = circleFriendMap.entrySet().iterator();
            int i3 = 1100;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<GroupInfo, List<Entity>> next = it.next();
                if (i3 >= 1150) {
                    QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 1, "[addCircleFriendList] current group id is max, not append.");
                    break;
                }
                String groupName = next.getKey().getGroupName();
                List<Entity> value = next.getValue();
                if (value != null && !value.isEmpty()) {
                    if (value instanceof ArrayList) {
                        arrayList = (ArrayList) value;
                    } else {
                        arrayList = new ArrayList(value);
                    }
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
                    bVar.l(groupName);
                    bVar.j(i3);
                    bVar.k(arrayList.size());
                    this.D.add(bVar);
                    this.F.put(bVar.d(), new ArrayList<>(arrayList));
                    i3++;
                }
            }
            I();
        }
    }

    private void r() {
        if (this.Z == null) {
            this.Z = new ArrayList<>();
        }
        String stringExtra = this.f285739i.mIntent.getStringExtra("group_name");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
        bVar.j(1006);
        bVar.l(stringExtra);
        bVar.k(this.Z.size());
        this.D.add(bVar);
        this.F.put(bVar.d(), new ArrayList<>(this.Z));
        if (QLog.isDevelopLevel()) {
            QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, "addCurGroup, mGroupmembers[" + this.Z.size() + "]");
        }
    }

    private void s() {
        if (this.X != null) {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryCacheInfoV2(RelationListReqType.NORMAL, false, "FriendTeamListInnerFrameBuddyListAdapter", false, this.X);
        }
        ExpandableListView expandableListView = this.I;
        if (expandableListView != null && this.L) {
            expandableListView.expandGroup(0);
        }
    }

    private void t() {
        List<PhoneContact> bindNonfriendList;
        SelectMemberActivity selectMemberActivity = this.f285739i;
        if (!selectMemberActivity.mOnlyFriends && !selectMemberActivity.mDonotNeedContacts) {
            int selfBindState = this.K.getSelfBindState();
            if ((this.K.isBindContactOk() || selfBindState == 8) && (bindNonfriendList = this.K.getBindNonfriendList()) != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bindNonfriendList);
                if (!arrayList.isEmpty()) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
                    bVar.j(1002);
                    bVar.l(this.f285740m.getString(R.string.csf));
                    bVar.k(1);
                    this.D.add(bVar);
                    this.F.put(bVar.d(), new ArrayList<>(arrayList));
                }
            }
        }
    }

    private void u() {
        ArrayList arrayList = new ArrayList(this.f285739i.mUinsToHide);
        arrayList.addAll(this.Q);
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> recentFriends = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getRecentFriends(Integer.MAX_VALUE, this.f285739i.mFilterRobot, arrayList);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList2 = new ArrayList<>();
        if (recentFriends != null) {
            arrayList2 = new ArrayList<>(recentFriends);
        }
        com.tencent.mobileqq.troop.api.c cVar = this.W;
        if (cVar != null) {
            cVar.a(arrayList2);
        }
        if (!bl.b(arrayList2)) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
            bVar.j(1003);
            bVar.l(this.f285740m.getString(R.string.f173057gz1));
            bVar.k(arrayList2.size());
            this.D.add(bVar);
            this.E.put(bVar.d(), arrayList2);
            return;
        }
        QLog.e("FriendTeamListInnerFrameBuddyListAdapter", 1, "addRecentGroup recent group is empty!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        String str;
        if (!this.N) {
            return;
        }
        ArrayList<? extends Object> arrayList = new ArrayList<>(this.R);
        com.tencent.mobileqq.troop.api.c cVar = this.W;
        if (cVar != null) {
            cVar.a(arrayList);
        }
        SelectMemberActivity selectMemberActivity = this.f285739i;
        if (selectMemberActivity != null && selectMemberActivity.getIntent() != null && this.f285739i.getIntent().getExtras() != null) {
            str = this.f285739i.getIntent().getExtras().getString(ISelectMemberActivityConstants.PARAM_GROUPCODE);
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && ((ITroopRobotApi) QRoute.api(ITroopRobotApi.class)).couldInviteTroopRobot(str)) {
            arrayList.add(new f(str));
        }
        if (this.W == null || !arrayList.isEmpty()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
            bVar.j(1012);
            bVar.l(this.f285740m.getString(R.string.f222106cm));
            bVar.k(arrayList.size());
            bVar.n((byte) 0);
            this.D.add(bVar);
            this.F.put(bVar.d(), arrayList);
        }
    }

    private void w() {
        boolean z16;
        ArrayList arrayList;
        if (!this.S) {
            z16 = true;
            this.S = true;
        } else {
            z16 = false;
        }
        HashMap<String, Object> topayList = this.J.getTopayList(this, z16, 0, 0);
        Object obj = topayList.get("recommend");
        if (obj != null) {
            arrayList = (ArrayList) obj;
        } else {
            arrayList = null;
        }
        Object obj2 = topayList.get("tips");
        if (obj2 != null) {
            this.f285739i.mTopayTips = (ArrayList) obj2;
        }
        if (arrayList != null) {
            String currentAccountUin = this.C.getCurrentAccountUin();
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList2 = new ArrayList<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                PfaFriend pfaFriend = (PfaFriend) it.next();
                if (pfaFriend != null) {
                    try {
                        String str = pfaFriend.uin;
                        if (str != null && !str.equals(currentAccountUin) && !this.f285739i.mUinsToHide.contains(pfaFriend.uin)) {
                            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(pfaFriend.uin), "FriendTeamListInnerFrameBuddyListAdapter");
                            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(friendsSimpleInfoWithUid.getUid(), "FriendTeamListInnerFrameBuddyListAdapter") && !com.tencent.mobileqq.selectmember.util.a.m(this.C, friendsSimpleInfoWithUid.x())) {
                                arrayList2.add(friendsSimpleInfoWithUid);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
                bVar.j(1003);
                bVar.l(this.f285740m.getString(R.string.bcb));
                bVar.k(arrayList2.size());
                this.D.add(bVar);
                this.E.put(bVar.d(), arrayList2);
            }
        }
    }

    private void x(d dVar, int i3) {
        boolean z16 = false;
        dVar.f285754c.setVisibility(0);
        if (i3 == 0) {
            if (this.f285924f.isGroupExpanded(dVar.f285752a)) {
                i3 = 2;
            } else {
                i3 = 1;
            }
        }
        CheckBox checkBox = dVar.f285754c;
        if (i3 == 2) {
            z16 = true;
        }
        checkBox.setChecked(z16);
    }

    private View z(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        com.tencent.mobileqq.selectmember.d dVar;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.f285740m).inflate(R.layout.act, viewGroup, false);
            dVar = new com.tencent.mobileqq.selectmember.d();
            dVar.f187212f = (ImageView) view.findViewById(R.id.icon);
            dVar.f285963i = (TextView) view.findViewById(R.id.f5e);
            dVar.C = (CheckBox) view.findViewById(R.id.axa);
            dVar.E = view.findViewById(R.id.kab);
            View.OnClickListener onClickListener = this.H;
            if (onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
            view.findViewById(R.id.k8u).setVisibility(8);
            view.setTag(dVar);
        } else {
            dVar = (com.tencent.mobileqq.selectmember.d) view.getTag();
            dVar.f285963i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        Object child = getChild(i3, i16);
        dVar.D = child;
        dVar.F = getGroupId(i3);
        if (child instanceof TroopMemberInfo) {
            TroopMemberInfo troopMemberInfo = (TroopMemberInfo) child;
            if (this.Y == null) {
                this.Y = new g(this.f285739i, this.C);
            }
            dVar.f187210d = troopMemberInfo.memberuin;
            str = troopMemberInfo.nickInfo.getShowName();
            c(dVar, this.Y.b(troopMemberInfo));
        } else if (child instanceof RobotCoreInfo) {
            RobotCoreInfo robotCoreInfo = (RobotCoreInfo) child;
            dVar.f187210d = String.valueOf(robotCoreInfo.robotUin);
            str = robotCoreInfo.name;
            c(dVar, null);
        } else if (child instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) child;
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(dVar2.x());
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            aVar.d(uidFromUin);
            str = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
            dVar.f187210d = dVar2.x();
            c(dVar, null);
        } else if (child instanceof Friends) {
            Friends friends = (Friends) child;
            str = com.tencent.mobileqq.selectmember.util.a.f(friends);
            dVar.f187210d = friends.uin;
            c(dVar, null);
        } else {
            QLog.e("FriendTeamListInnerFrameBuddyListAdapter", 1, "getBuddyChildView can not handle item type");
            str = "";
        }
        if (dVar.E != null) {
            if (com.tencent.mobileqq.selectmember.util.a.n(this.C, dVar.f187210d)) {
                dVar.E.setVisibility(0);
            } else {
                dVar.E.setVisibility(8);
            }
        }
        dVar.f187212f.setImageDrawable(null);
        dVar.f285963i.setText(str);
        ArrayList<String> arrayList = this.f285739i.mUinsSelectedDefault;
        if (arrayList != null && arrayList.contains(dVar.f187210d)) {
            dVar.C.setChecked(true);
            dVar.C.setEnabled(false);
        } else if (this.f285739i.isResultListContainFriend(dVar.f187210d)) {
            dVar.C.setChecked(true);
            dVar.C.setEnabled(true);
        } else {
            dVar.C.setChecked(false);
            dVar.C.setEnabled(true);
        }
        if (AppSetting.f99565y && dVar.C.isEnabled()) {
            if (dVar.C.isChecked()) {
                view.setContentDescription(str + HardCodeUtil.qqStr(R.string.t9y));
            } else {
                view.setContentDescription(str + HardCodeUtil.qqStr(R.string.t9b));
            }
        }
        return view;
    }

    public com.tencent.qqnt.ntrelation.friendsinfo.bean.b A(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) iPatchRedirector.redirect((short) 24, (Object) this, j3);
        }
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = this.D.get(i3);
            if (bVar.d() == j3) {
                return bVar;
            }
        }
        return null;
    }

    @Override // od2.a
    public void B7(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, j3);
        }
    }

    public void K(ArrayList<TroopMemberInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) arrayList);
        } else {
            this.Z = arrayList;
        }
    }

    public void L(RelationFriendsTroopViewHelper relationFriendsTroopViewHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) relationFriendsTroopViewHelper);
        } else {
            this.T = relationFriendsTroopViewHelper;
        }
    }

    @Override // od2.a
    public void L1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "onUpdateContactList, " + i3);
        }
        notifyDataSetChanged();
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            super.notifyDataSetChanged();
        }
    }

    @Override // od2.a
    public void T2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        }
    }

    @Override // od2.a
    public void Ug(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            notifyDataSetChanged();
        }
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) view, i3);
            return;
        }
        d dVar = (d) view.getTag();
        if (dVar == null) {
            dVar = new d();
            view.findViewById(R.id.dv_).setVisibility(0);
            dVar.f285753b = (TextView) view.findViewById(R.id.group_name);
            view.setTag(dVar);
        }
        dVar.f285753b.setText(((com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getGroup(i3)).f());
        if (this.I != null) {
            ((CheckBox) view.findViewById(R.id.dv_)).setChecked(this.I.isGroupExpanded(i3));
        }
    }

    @Override // com.tencent.mobileqq.selectmember.adapter.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (!this.f285739i.mDonotNeedContacts) {
            this.K.removeListener(this);
        }
        if (this.f285739i.mEntrance == 33) {
            this.J.removeObserver(this.C);
        }
        g gVar = this.Y;
        if (gVar != null) {
            gVar.a();
            this.Y = null;
        }
        this.I = null;
        this.X = null;
        super.destroy();
    }

    @Override // od2.a
    public void e7(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "onRecommendCountChanged count=" + i3);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 >= this.D.size()) {
            QLog.e("FriendTeamListInnerFrameBuddyListAdapter", 1, "getChild groupPosition out of index");
            return null;
        }
        int d16 = this.D.get(i3).d();
        ArrayList<Object> arrayList = this.F.get(d16);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList2 = this.E.get(d16);
        if (arrayList != null && i16 < arrayList.size() && i16 >= 0) {
            return arrayList.get(i16);
        }
        if (arrayList2 != null && i16 < arrayList2.size() && i16 >= 0) {
            return arrayList2.get(i16);
        }
        if (arrayList2 != null) {
            str = String.valueOf(arrayList2.size());
        } else {
            str = "null";
        }
        QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 1, "getChild error, ntFriendSimpleInfoArrayList size = " + str + ",childPosition = " + i16 + "\uff0cgroupPosition = " + i3);
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        Object child = getChild(i3, i16);
        if (child instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d) {
            try {
                return Long.parseLong(((com.tencent.qqnt.ntrelation.friendsinfo.bean.d) child).x());
            } catch (Throwable th5) {
                if (!QLog.isColorLevel()) {
                    return 0L;
                }
                QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 2, QLog.getStackTraceString(th5));
                return 0L;
            }
        }
        if (((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).isPublicAccountInfoInstance(child)) {
            return ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoUin(child);
        }
        if (child instanceof TroopMemberInfo) {
            try {
                return Long.parseLong(((TroopMemberInfo) child).memberuin);
            } catch (Throwable th6) {
                if (!QLog.isColorLevel()) {
                    return 0L;
                }
                QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 2, QLog.getStackTraceString(th6));
                return 0L;
            }
        }
        if (!(child instanceof RelationTroopEntity)) {
            return 0L;
        }
        return this.T.g(((RelationTroopEntity) child).troopInfo.troopuin).longValue();
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return G(i3, i16);
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        View C;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), view, viewGroup);
        }
        TraceUtils.traceBegin("getChildView");
        if (G(i3, i16) == 0) {
            C = z(i3, i16, z16, view, viewGroup);
        } else if (G(i3, i16) == 1) {
            C = B(i3, i16, z16, view, viewGroup);
        } else if (G(i3, i16) == 2) {
            C = this.T.e(i3, i16, view, viewGroup, this.f285739i, this.H, (RelationTroopEntity) getChild(i3, i16));
        } else if (G(i3, i16) == 3) {
            C = E(i3, i16, view);
        } else {
            C = C(i3, i16, z16, view, viewGroup);
        }
        TraceUtils.traceEnd();
        return C;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        if (this.D.size() <= i3 || (bVar = this.D.get(i3)) == null) {
            return 0;
        }
        if (this.F.get(bVar.d()) != null) {
            return this.F.get(bVar.d()).size();
        }
        if (this.E.get(bVar.d()) == null) {
            return 0;
        }
        return this.E.get(bVar.d()).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> arrayList = this.D;
        if (arrayList == null) {
            QLog.e("FriendTeamListInnerFrameBuddyListAdapter", 1, "getGroup is error! mNTCategoryInfoList or groupPosition is invalid!");
            return new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
        }
        int size = arrayList.size();
        if (i3 >= size) {
            QLog.e("FriendTeamListInnerFrameBuddyListAdapter", 1, "getGroup out of index groupPosition: " + i3 + " size: " + size);
            return new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
        }
        return this.D.get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.D.size();
    }

    @Override // com.tencent.mobileqq.selectmember.adapter.a, android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this, i3)).longValue();
        }
        Object group = getGroup(i3);
        if (group != null && (group instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.b)) {
            return ((com.tencent.qqnt.ntrelation.friendsinfo.bean.b) group).d();
        }
        return super.getGroupId(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view != null) {
            dVar = (d) view.getTag();
        } else {
            view = LayoutInflater.from(this.f285740m).inflate(R.layout.f168569acs, viewGroup, false);
            dVar = new d();
            dVar.f285753b = (TextView) view.findViewById(R.id.group_name);
            dVar.f285754c = (CheckBox) view.findViewById(R.id.dv_);
            view.setTag(dVar);
            view.setOnClickListener(this);
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getGroup(i3);
        dVar.f285752a = i3;
        dVar.f285753b.setText(bVar.f());
        if (!z16) {
            i16 = 1;
        }
        x(dVar, i16);
        if (AppSetting.f99565y) {
            if (z16) {
                view.setContentDescription(bVar.f() + HardCodeUtil.qqStr(R.string.t9u));
            } else {
                view.setContentDescription(bVar.f() + HardCodeUtil.qqStr(R.string.t9l));
            }
        }
        view.setOnLongClickListener(this);
        return view;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return R.layout.f167797hu;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
    }

    @Override // android.widget.BaseExpandableListAdapter
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            J(new Runnable() { // from class: com.tencent.mobileqq.selectmember.SelectMemberBuddyListAdapter.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectMemberBuddyListAdapter.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        SelectMemberBuddyListAdapter.this.H();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) view);
        } else {
            d dVar = (d) view.getTag();
            if (this.f285924f.isGroupExpanded(dVar.f285752a)) {
                this.f285924f.collapseGroup(dVar.f285752a);
            } else {
                try {
                    this.f285924f.expandGroup(dVar.f285752a);
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getGroup(dVar.f285752a);
                    if (bVar.d() == 1003) {
                        if (this.f285739i.mSubType == 0) {
                            ReportController.o(this.C, "CliOper", "", "", "0X8005442", "0X8005442", 1, 0, "", "", "", "");
                        } else {
                            ReportController.o(this.C, "CliOper", "", "", "0X8005442", "0X8005442", 2, 0, "", "", "", "");
                        }
                    } else if (bVar.d() == 1002) {
                        if (this.f285739i.mSubType == 0) {
                            ReportController.o(this.C, "CliOper", "", "", "0X8005444", "0X8005444", 1, 0, "", "", "", "");
                        } else {
                            ReportController.o(this.C, "CliOper", "", "", "0X8005444", "0X8005444", 2, 0, "", "", "", "");
                        }
                    } else if (bVar.d() == 0) {
                        if (this.f285739i.mSubType == 0) {
                            ReportController.o(this.C, "CliOper", "", "", "0X8005443", "0X8005443", 1, 0, "", "", "", "");
                        } else {
                            ReportController.o(this.C, "CliOper", "", "", "0X8005443", "0X8005443", 2, 0, "", "", "", "");
                        }
                    } else if (this.f285739i.mSubType == 0) {
                        ReportController.o(this.C, "CliOper", "", "", "0X8005445", "0X8005445", 1, 0, "", "", "", "");
                    } else {
                        ReportController.o(this.C, "CliOper", "", "", "0X8005445", "0X8005445", 2, 0, "", "", "", "");
                    }
                } catch (Throwable unused) {
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) view)).booleanValue();
        } else {
            com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
            aVar.a(0, this.f285740m.getResources().getString(R.string.bof));
            ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).showAsDropDown(view, aVar, this.f285738a0, new b());
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.IToPayManager.a
    public void onRefreshTopayList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
            return;
        }
        SelectMemberActivity selectMemberActivity = this.f285739i;
        if (selectMemberActivity != null && !selectMemberActivity.isFinishing()) {
            notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.adapter.a, com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        super.onScroll(absListView, i3, i16, i17);
        AbsListView.OnScrollListener onScrollListener = this.G;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.adapter.a, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) absListView, i3);
            return;
        }
        super.onScrollStateChanged(absListView, i3);
        AbsListView.OnScrollListener onScrollListener = this.G;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
    }

    public void y(boolean z16, String str, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, arrayList);
        } else if (z16) {
            this.W = ((ITroopRobotApi) QRoute.api(ITroopRobotApi.class)).initTroopRobotInviteFilter(str, arrayList);
        }
    }
}
