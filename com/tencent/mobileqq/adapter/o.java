package com.tencent.mobileqq.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.ar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes10.dex */
public class o extends com.tencent.mobileqq.adapter.c implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    public static int M;
    protected HashMap<Integer, String> C;
    protected QQAppInterface D;
    protected Context E;
    protected ar F;
    protected float G;
    protected boolean H;
    private boolean I;
    private boolean J;
    protected d K;
    protected View.OnClickListener L;

    /* renamed from: i, reason: collision with root package name */
    protected List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> f187223i;

    /* renamed from: m, reason: collision with root package name */
    protected HashMap<Integer, ArrayList<Object>> f187224m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements hx3.c<Boolean> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ hx3.c f187225a;

        a(hx3.c cVar) {
            this.f187225a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this, (Object) cVar);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            o oVar = o.this;
            if (oVar.H) {
                oVar.g();
            }
            hx3.c cVar = this.f187225a;
            if (cVar != null) {
                cVar.onUpdateResult(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                o.this.K.b(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f187228a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f187229b;

        /* renamed from: c, reason: collision with root package name */
        public int f187230c;

        /* renamed from: d, reason: collision with root package name */
        public CheckBox f187231d;

        protected c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface d {
        boolean a(String str, int i3);

        void b(View view);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class e extends k {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        public Object f187232i;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69510);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            M = 1003;
        }
    }

    public o(Context context, ExpandableListView expandableListView, QQAppInterface qQAppInterface, List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> list, d dVar, boolean z16, hx3.c<Boolean> cVar, boolean z17) {
        super(context, qQAppInterface, expandableListView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, expandableListView, qQAppInterface, list, dVar, Boolean.valueOf(z16), cVar, Boolean.valueOf(z17));
            return;
        }
        this.f187224m = new HashMap<>();
        this.C = new HashMap<>();
        this.I = false;
        this.J = true;
        this.L = new b();
        this.D = qQAppInterface;
        this.E = context;
        this.K = dVar;
        this.H = z16;
        this.I = z17;
        this.G = context.getResources().getDisplayMetrics().density;
        ar arVar = new ar(context);
        this.F = arVar;
        float f16 = this.G;
        arVar.c((int) (f16 * 100.0f), (int) (f16 * 100.0f));
        o(list, false, new a(cVar));
        Intent intent = ((ForwardFriendListActivity) this.E).getIntent();
        if (intent != null) {
            this.J = intent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_SHOW_ROBOT_GROUP, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        List<Object> bindNonfriendListInObject;
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.D.getRuntimeService(IPhoneContactService.class, "");
        int selfBindState = iPhoneContactService.getSelfBindState();
        if ((iPhoneContactService.isBindContactOk() || selfBindState == 8) && (bindNonfriendListInObject = iPhoneContactService.getBindNonfriendListInObject()) != null) {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.addAll(bindNonfriendListInObject);
            if (!arrayList.isEmpty()) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
                bVar.j(1002);
                bVar.l(this.E.getString(R.string.csf));
                bVar.k(1);
                bVar.n((byte) 0);
                this.f187223i.add(bVar);
                this.f187224m.put(Integer.valueOf(bVar.d()), arrayList);
            }
        }
    }

    private void h() {
        com.tencent.qqnt.kernel.api.ac robotService;
        int i3;
        if (!this.J || (robotService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getRobotService()) == null) {
            return;
        }
        ArrayList<RobotCoreInfo> allRobotFriendsFromCache = robotService.getAllRobotFriendsFromCache();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("addRobotGroup: size=");
        if (allRobotFriendsFromCache != null) {
            i3 = allRobotFriendsFromCache.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        QLog.i("ForwardSelectionFriendListAdapter", 1, sb5.toString());
        if (allRobotFriendsFromCache == null) {
            allRobotFriendsFromCache = new ArrayList<>();
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
        bVar.j(1012);
        bVar.l(this.E.getString(R.string.f222106cm));
        bVar.k(allRobotFriendsFromCache.size());
        bVar.n((byte) 0);
        this.f187223i.add(bVar);
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<RobotCoreInfo> it = allRobotFriendsFromCache.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.f187224m.put(Integer.valueOf(bVar.d()), arrayList);
    }

    private void i(c cVar, int i3) {
        boolean z16 = false;
        cVar.f187231d.setVisibility(0);
        if (i3 == 0) {
            if (this.f187153f.isGroupExpanded(cVar.f187230c)) {
                i3 = 2;
            } else {
                i3 = 1;
            }
        }
        CheckBox checkBox = cVar.f187231d;
        if (i3 == 2) {
            z16 = true;
        }
        checkBox.setChecked(z16);
    }

    public static int m() {
        return M;
    }

    private ArrayList<Object> n() {
        return l(((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentListFromCacheInObject());
    }

    public static void p(int i3) {
        M = i3;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view, i3);
            return;
        }
        c cVar = (c) view.getTag();
        if (cVar == null) {
            cVar = new c();
            cVar.f187228a = (TextView) view.findViewById(R.id.group_name);
            cVar.f187229b = (TextView) view.findViewById(R.id.contact_count);
            view.findViewById(R.id.dv_).setVisibility(0);
            view.setTag(cVar);
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getGroup(i3);
        cVar.f187228a.setText(bVar.f());
        cVar.f187229b.setText(String.valueOf(bVar.e()));
        ((CheckBox) view.findViewById(R.id.dv_)).setChecked(this.f187153f.isGroupExpanded(i3));
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return k(i3).get(i16);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00cf  */
    @Override // android.widget.ExpandableListAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        ForwardRecentItemView forwardRecentItemView;
        e eVar;
        int i17;
        String str;
        String str2;
        String valueOf;
        ResultRecord resultRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view == null) {
            forwardRecentItemView = new ForwardRecentItemView(this.E);
            eVar = new e();
            forwardRecentItemView.setTag(eVar);
        } else {
            forwardRecentItemView = (ForwardRecentItemView) view;
            eVar = (e) forwardRecentItemView.getTag();
        }
        Object child = getChild(i3, i16);
        if (child instanceof PhoneContact) {
            PhoneContact phoneContact = (PhoneContact) child;
            str2 = phoneContact.name;
            valueOf = phoneContact.mobileCode;
            if (TextUtils.isEmpty(valueOf)) {
                valueOf = phoneContact.mobileNo;
            } else {
                int indexOf = valueOf.indexOf("|");
                if (indexOf > -1) {
                    valueOf = valueOf.substring(0, indexOf);
                }
            }
            eVar.f187211e = 11;
            i18 = 1006;
        } else if (child instanceof RobotCoreInfo) {
            RobotCoreInfo robotCoreInfo = (RobotCoreInfo) child;
            valueOf = String.valueOf(robotCoreInfo.robotUin);
            eVar.f187211e = 1;
            str2 = robotCoreInfo.name;
        } else {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) child;
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            aVar.d(dVar.getUid());
            String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
            String x16 = dVar.x();
            eVar.f187211e = 1;
            i17 = 0;
            str = x16;
            str2 = nameWithConfig;
            eVar.f187212f = forwardRecentItemView.f187013m;
            eVar.f187210d = str;
            eVar.f187232i = child;
            boolean a16 = this.K.a(str, i17);
            boolean l3 = com.tencent.mobileqq.troop.utils.k.l(this.D, str);
            resultRecord = forwardRecentItemView.J;
            if (resultRecord == null) {
                resultRecord = new ResultRecord();
            }
            ResultRecord resultRecord2 = resultRecord;
            resultRecord2.init(str, str2, i17, "", "");
            forwardRecentItemView.b(str2, "", null, resultRecord2, this.H, a16, l3);
            c(eVar, null);
            forwardRecentItemView.setOnClickListener(this.L);
            return forwardRecentItemView;
        }
        i17 = i18;
        str = valueOf;
        eVar.f187212f = forwardRecentItemView.f187013m;
        eVar.f187210d = str;
        eVar.f187232i = child;
        boolean a162 = this.K.a(str, i17);
        boolean l36 = com.tencent.mobileqq.troop.utils.k.l(this.D, str);
        resultRecord = forwardRecentItemView.J;
        if (resultRecord == null) {
        }
        ResultRecord resultRecord22 = resultRecord;
        resultRecord22.init(str, str2, i17, "", "");
        forwardRecentItemView.b(str2, "", null, resultRecord22, this.H, a162, l36);
        c(eVar, null);
        forwardRecentItemView.setOnClickListener(this.L);
        return forwardRecentItemView;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        if (k(i3) == null) {
            return 0;
        }
        return k(i3).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return this.f187223i.get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f187223i.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        c cVar;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view == null) {
            view = LayoutInflater.from(this.E).inflate(R.layout.f167797hu, viewGroup, false);
            cVar = new c();
            cVar.f187228a = (TextView) view.findViewById(R.id.group_name);
            cVar.f187229b = (TextView) view.findViewById(R.id.contact_count);
            cVar.f187231d = (CheckBox) view.findViewById(R.id.dv_);
            view.setTag(cVar);
            view.setOnClickListener(this);
        } else {
            cVar = (c) view.getTag();
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getGroup(i3);
        cVar.f187228a.setText(bVar.f());
        cVar.f187229b.setText(String.valueOf(getChildrenCount(i3)));
        cVar.f187230c = i3;
        if (z16) {
            i16 = 2;
        }
        i(cVar, i16);
        if (AppSetting.f99565y) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(bVar.f());
            sb5.append("\uff0c\uff0c");
            if (cVar.f187231d.isChecked()) {
                str = "\u5df2\u5c55\u5f00";
            } else {
                str = "\u5df2\u6298\u53e0";
            }
            sb5.append(str);
            AccessibilityUtil.c(view, sb5.toString(), null);
            cVar.f187231d.setImportantForAccessibility(2);
        }
        return view;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return R.layout.f167797hu;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.f187223i == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<Object> j(ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList, int i3) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar;
        AppRuntime peekAppRuntime;
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArrayList) iPatchRedirector.redirect((short) 12, (Object) this, (Object) arrayList, i3);
        }
        ArrayList<Object> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            arrayList2.addAll(arrayList);
            Iterator<Object> it = arrayList2.iterator();
            while (it.hasNext()) {
                try {
                    dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) it.next();
                    peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                if (!((ITroopRobotService) peekAppRuntime.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(dVar.x()) && dVar.f() == i3) {
                    if (Utils.G(dVar.x())) {
                        it.remove();
                    } else if (TextUtils.equals(dVar.x(), peekAppRuntime.getCurrentAccountUin()) && (context = this.E) != null && (context instanceof ForwardFriendListActivity)) {
                        Intent intent = ((ForwardFriendListActivity) context).getIntent();
                        boolean z16 = false;
                        if (intent != null) {
                            z16 = intent.getBooleanExtra("choose_friend_isForConfess", false);
                        }
                        if (z16) {
                            it.remove();
                        }
                    }
                }
                it.remove();
            }
        }
        return arrayList2;
    }

    public List<Object> k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return this.f187224m.get(Integer.valueOf(((com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getGroup(i3)).d()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<Object> l(List<Object> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this, (Object) list);
        }
        if (list != null && list.size() != 0) {
            ArrayList<Object> arrayList = new ArrayList<>();
            for (Object obj : list) {
                if (obj instanceof RecentUser) {
                    RecentUser recentUser = (RecentUser) obj;
                    if (!Utils.J(recentUser.uin) && recentUser.getType() == 0 && !Utils.I(recentUser.uin)) {
                        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(recentUser.uin);
                        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "ForwardSelectionFriendListAdapter")) {
                            arrayList.add(((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "ForwardSelectionFriendListAdapter"));
                        }
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    public void o(List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> list, boolean z16, hx3.c<Boolean> cVar) {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, list, Boolean.valueOf(z16), cVar);
            return;
        }
        this.f187223i = list;
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> allFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("ForwardSelectionFriendListAdapter");
        ListIterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> listIterator = this.f187223i.listIterator();
        while (listIterator.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b next = listIterator.next();
            if (next.d() == ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getSpecialCareCategoryId()) {
                listIterator.remove();
            } else {
                if (next.d() == m() && !this.f187224m.containsKey(Integer.valueOf(m()))) {
                    ArrayList<Object> n3 = n();
                    this.f187224m.put(Integer.valueOf(m()), n3);
                    if (n3 == null) {
                        size = 0;
                    } else {
                        size = n3.size();
                    }
                    next.k(size);
                } else {
                    this.f187224m.put(Integer.valueOf(next.d()), j((ArrayList) allFriend, next.d()));
                }
                this.C.put(Integer.valueOf(next.d()), next.f());
            }
        }
        h();
        if (z16) {
            super.notifyDataSetChanged();
        }
        if (cVar != null) {
            cVar.onUpdateResult(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view);
        } else {
            c cVar = (c) view.getTag();
            if (this.f187153f.isGroupExpanded(cVar.f187230c)) {
                this.f187153f.collapseGroup(cVar.f187230c);
            } else {
                this.f187153f.expandGroup(cVar.f187230c);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
