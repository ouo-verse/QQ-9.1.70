package com.tencent.mobileqq.troop.createNewTroop;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopcreate.RelationTroopEntity;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateContactDataProvider;
import com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ContactListAdapter extends com.tencent.mobileqq.troop.widget.b implements View.OnClickListener, View.OnLongClickListener, od2.a {
    static IPatchRedirector $redirector_;
    private ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> C;
    private SparseArray<ArrayList<Object>> D;
    private long E;
    protected NewTroopContactView F;
    private AbsListView.OnScrollListener G;
    private ExpandableListView H;
    private boolean I;
    RelationFriendsTroopViewHelper J;
    private Drawable K;
    private Drawable L;
    private final ArrayList<String> M;
    private ArrayList<RobotCoreInfo> N;
    private final Handler P;
    private final View.OnClickListener Q;
    private final View.OnClickListener R;

    /* renamed from: i, reason: collision with root package name */
    private final Context f294692i;

    /* renamed from: m, reason: collision with root package name */
    private final AppInterface f294693m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactListAdapter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).startGroupManager((Activity) ContactListAdapter.this.f294692i);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f294698a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f294699b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f294700c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f294701d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c extends d {
        static IPatchRedirector $redirector_;
        public View D;
        public long E;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class d extends k {
        static IPatchRedirector $redirector_;
        public Object C;

        /* renamed from: i, reason: collision with root package name */
        public TextView f294702i;

        /* renamed from: m, reason: collision with root package name */
        public CheckBox f294703m;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ContactListAdapter(NewTroopContactView newTroopContactView, AppInterface appInterface, final ExpandableListView expandableListView, boolean z16) {
        super(newTroopContactView.f300107d, appInterface, expandableListView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, newTroopContactView, appInterface, expandableListView, Boolean.valueOf(z16));
            return;
        }
        this.C = new ArrayList<>();
        this.D = new SparseArray<>();
        this.E = 0L;
        this.I = true;
        ArrayList<String> arrayList = new ArrayList<>();
        this.M = arrayList;
        this.N = new ArrayList<>();
        this.P = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.troop.createNewTroop.a
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean u16;
                u16 = ContactListAdapter.this.u(message);
                return u16;
            }
        });
        this.Q = new a();
        this.R = new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ContactListAdapter.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object obj;
                String str;
                boolean G;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick");
                    c cVar = (c) view.getTag();
                    if (cVar != null && cVar.f294703m != null && (obj = cVar.C) != null) {
                        if (obj instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d) {
                            str = ((com.tencent.qqnt.ntrelation.friendsinfo.bean.d) obj).m();
                        } else if (obj instanceof PhoneContact) {
                            str = ((PhoneContact) obj).name;
                        } else if (obj instanceof RelationTroopEntity) {
                            ContactListAdapter.this.F.H(((RelationTroopEntity) obj).troopInfo.troopuin);
                        } else {
                            str = "";
                        }
                        if (cVar.f294703m.isEnabled()) {
                            if (cVar.f187210d.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                                G = ContactListAdapter.this.F.G(cVar.f187210d, str, 4, "-1");
                            } else {
                                G = ContactListAdapter.this.F.G(cVar.f187210d, str, 0, "-1");
                            }
                            if (QLog.isDevelopLevel()) {
                                QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick = " + G);
                            }
                            if (cVar.E == 1007) {
                                ContactListAdapter.this.J.k();
                            }
                            cVar.f294703m.setChecked(G);
                            if (AppSetting.f99565y) {
                                if (cVar.f294703m.isChecked()) {
                                    view.setContentDescription(cVar.f294702i.getText().toString() + HardCodeUtil.qqStr(R.string.ukm));
                                } else {
                                    view.setContentDescription(cVar.f294702i.getText().toString() + HardCodeUtil.qqStr(R.string.ul_));
                                }
                            }
                            ContactListAdapter.this.B();
                            if (AppSetting.f99565y) {
                                view.postDelayed(new Runnable(view) { // from class: com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter.2.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ View f294695d;

                                    {
                                        this.f294695d = view;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) view);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                        } else {
                                            this.f294695d.sendAccessibilityEvent(8);
                                        }
                                    }
                                }, 2000L);
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.F = newTroopContactView;
        this.f294692i = newTroopContactView.f300107d;
        this.f294693m = appInterface;
        this.I = z16;
        this.H = expandableListView;
        r();
        ArrayList arrayList2 = new ArrayList(this.F.f294719m);
        arrayList2.addAll(arrayList);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getRecentFriendsAsync(Integer.MAX_VALUE, false, arrayList2, new Consumer() { // from class: com.tencent.mobileqq.troop.createNewTroop.b
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ContactListAdapter.this.v(expandableListView, (List) obj);
            }
        });
    }

    private View l(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        c cVar;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.f294692i).inflate(R.layout.act, viewGroup, false);
            cVar = new c();
            cVar.f187212f = (ImageView) view.findViewById(R.id.icon);
            cVar.f294702i = (TextView) view.findViewById(R.id.f5e);
            cVar.f294703m = (CheckBox) view.findViewById(R.id.axa);
            cVar.D = view.findViewById(R.id.kab);
            View.OnClickListener onClickListener = this.R;
            if (onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
            view.findViewById(R.id.k8u).setVisibility(8);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
            cVar.f294702i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        Object child = getChild(i3, i16);
        if (child instanceof RobotCoreInfo) {
            RobotCoreInfo robotCoreInfo = (RobotCoreInfo) child;
            cVar.f187210d = String.valueOf(robotCoreInfo.robotUin);
            str = robotCoreInfo.name;
            c(cVar, null);
        } else if (child instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) child;
            cVar.f187210d = dVar.x();
            str = dVar.m();
        } else {
            str = "";
        }
        cVar.E = getGroupId(i3);
        cVar.C = child;
        c(cVar, null);
        if (cVar.D != null) {
            if (((ITroopRobotService) this.f294693m.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(cVar.f187210d)) {
                cVar.D.setVisibility(0);
            } else {
                cVar.D.setVisibility(8);
            }
        }
        cVar.f187212f.setImageDrawable(null);
        cVar.f294702i.setText(str);
        if (this.F.A(cVar.f187210d)) {
            cVar.f294703m.setChecked(true);
        } else {
            cVar.f294703m.setChecked(false);
        }
        ArrayList<String> arrayList = this.F.f294714i;
        if (arrayList != null && arrayList.contains(cVar.f187210d)) {
            cVar.f294703m.setEnabled(false);
        } else {
            cVar.f294703m.setEnabled(true);
        }
        if (AppSetting.f99565y && cVar.f294703m.isEnabled()) {
            if (cVar.f294703m.isChecked()) {
                view.setContentDescription(str + HardCodeUtil.qqStr(R.string.ukm));
            } else {
                view.setContentDescription(str + HardCodeUtil.qqStr(R.string.ul_));
            }
        }
        return view;
    }

    private View m(View view, ViewGroup viewGroup, Context context, View.OnClickListener onClickListener, Entity entity) {
        c cVar;
        int i3;
        RelationTroopEntity relationTroopEntity = (RelationTroopEntity) entity;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.act, viewGroup, false);
            cVar = new c();
            cVar.f187212f = (ImageView) view.findViewById(R.id.icon);
            cVar.f294702i = (TextView) view.findViewById(R.id.f5e);
            cVar.f294703m = (CheckBox) view.findViewById(R.id.axa);
            cVar.D = view.findViewById(R.id.kab);
            if (onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
            view.findViewById(R.id.k8u).setVisibility(8);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
            cVar.f294702i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        cVar.f294703m.setVisibility(8);
        cVar.D.setVisibility(8);
        cVar.C = relationTroopEntity;
        TroopInfo troopInfo = relationTroopEntity.troopInfo;
        cVar.f187210d = troopInfo.troopuin;
        if (troopInfo.hasSetTroopHead()) {
            i3 = 4;
        } else {
            i3 = 113;
        }
        cVar.f187212f.setImageDrawable(FaceDrawable.getFaceDrawable(this.f294693m, i3, relationTroopEntity.troopInfo.troopuin, 3, FaceDrawable.getDefaultDrawable(4, 3), FaceDrawable.getDefaultDrawable(4, 3)));
        cVar.f294702i.setText(relationTroopEntity.troopInfo.getTroopDisplayName());
        return view;
    }

    private Drawable o(boolean z16) {
        if (z16) {
            if (this.K == null) {
                this.K = ContextCompat.getDrawable(this.f294692i, R.drawable.skin_indicator_expanded);
            }
            return this.K;
        }
        if (this.L == null) {
            this.L = ContextCompat.getDrawable(this.f294692i, R.drawable.skin_indicator_unexpanded);
        }
        return this.L;
    }

    private View p(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = LayoutInflater.from(this.f294692i).inflate(R.layout.act, viewGroup, false);
            cVar = new c();
            cVar.f187212f = (ImageView) view.findViewById(R.id.icon);
            cVar.f294702i = (TextView) view.findViewById(R.id.f5e);
            cVar.f294703m = (CheckBox) view.findViewById(R.id.axa);
            cVar.D = view.findViewById(R.id.kab);
            View.OnClickListener onClickListener = this.R;
            if (onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
            cVar.f294702i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        Object child = getChild(i3, i16);
        PhoneContact phoneContact = (PhoneContact) child;
        cVar.C = child;
        cVar.f187210d = phoneContact.mobileCode;
        c(cVar, null);
        View view2 = cVar.D;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        cVar.f187212f.setImageDrawable(null);
        cVar.f294702i.setText(phoneContact.name);
        if (this.F.A(cVar.f187210d)) {
            cVar.f294703m.setChecked(true);
        } else {
            cVar.f294703m.setChecked(false);
        }
        if (this.F.f294714i != null && !"0".equals(phoneContact.uin) && this.F.f294714i.contains(phoneContact.uin)) {
            cVar.f294703m.setEnabled(false);
        } else {
            cVar.f294703m.setEnabled(true);
        }
        if (AppSetting.f99565y && cVar.f294703m.isEnabled()) {
            if (cVar.f294703m.isChecked()) {
                view.setContentDescription(phoneContact.name + HardCodeUtil.qqStr(R.string.ukm));
            } else {
                view.setContentDescription(phoneContact.name + HardCodeUtil.qqStr(R.string.ul_));
            }
        }
        return view;
    }

    private ArrayList<RobotCoreInfo> q() {
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
        QLog.i("createNewTroop.ContactListAdapter", 1, sb5.toString());
        return allRobotFriendsFromCache;
    }

    private void r() {
        ArrayList<RobotCoreInfo> q16 = q();
        if (q16 == null) {
            return;
        }
        Iterator<RobotCoreInfo> it = q16.iterator();
        while (it.hasNext()) {
            RobotCoreInfo next = it.next();
            if (!next.allowAddGroup) {
                this.M.add(String.valueOf(next.robotUin));
            } else {
                this.N.add(next);
            }
        }
    }

    private int s(int i3, int i16) {
        if (this.C.get(i3).d() == 1002) {
            return 1;
        }
        if (this.C.get(i3).d() == 1008) {
            return 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(long j3) {
        ITroopCreateContactDataProvider.a loadContactData = ((ITroopCreateContactDataProvider) QRoute.api(ITroopCreateContactDataProvider.class)).loadContactData(this.f294692i, this.N, this.F.f294719m);
        if (QLog.isColorLevel()) {
            QLog.d("createNewTroop.ContactListAdapter", 2, "loadData: end seq=" + j3 + ", time=" + loadContactData.b() + ", lastTime=" + this.E);
        }
        this.P.obtainMessage(1, loadContactData).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean u(Message message) {
        if (message.what == 1) {
            z((ITroopCreateContactDataProvider.a) message.obj);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(ExpandableListView expandableListView, List list) {
        expandableListView.post(new Runnable() { // from class: com.tencent.mobileqq.troop.createNewTroop.e
            @Override // java.lang.Runnable
            public final void run() {
                ContactListAdapter.this.notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        try {
            this.H.expandGroup(0);
        } catch (Exception e16) {
            QLog.e("createNewTroop.ContactListAdapter", 1, "addGroupFriend: ", e16);
        }
    }

    private void y() {
        final long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("createNewTroop.ContactListAdapter", 2, "loadData: start ");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.createNewTroop.d
            @Override // java.lang.Runnable
            public final void run() {
                ContactListAdapter.this.t(currentTimeMillis);
            }
        }, 16, null, false);
    }

    private void z(ITroopCreateContactDataProvider.a aVar) {
        if (aVar.b() > this.E) {
            this.C = new ArrayList<>();
            SparseArray<ArrayList<Object>> c16 = aVar.c();
            this.D = c16;
            this.J.h(this.C, c16);
            this.C.addAll(aVar.a());
            super.notifyDataSetChanged();
            if (QLog.isColorLevel()) {
                QLog.d("createNewTroop.ContactListAdapter", 2, "onNotifyDataChanged: ");
            }
            if (this.H != null && this.I && this.C.size() > 0) {
                this.P.post(new Runnable() { // from class: com.tencent.mobileqq.troop.createNewTroop.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContactListAdapter.this.x();
                    }
                });
            }
        }
    }

    public void A(RelationFriendsTroopViewHelper relationFriendsTroopViewHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) relationFriendsTroopViewHelper);
        } else {
            this.J = relationFriendsTroopViewHelper;
        }
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            super.notifyDataSetChanged();
        }
    }

    @Override // od2.a
    public void B7(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
        }
    }

    @Override // od2.a
    public void L1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("createNewTroop.ContactListAdapter", 2, "onUpdateContactList, " + i3);
        }
        notifyDataSetChanged();
    }

    @Override // od2.a
    public void T2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        }
    }

    @Override // od2.a
    public void Ug(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            notifyDataSetChanged();
        }
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) view, i3);
            return;
        }
        b bVar = (b) view.getTag();
        if (bVar == null) {
            bVar = new b();
            view.findViewById(R.id.dv_).setVisibility(0);
            bVar.f294699b = (TextView) view.findViewById(R.id.group_name);
            view.setTag(bVar);
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar2 = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getGroup(i3);
        bVar.f294699b.setText(bVar2.f());
        bVar.f294700c.setText(String.valueOf(bVar2.e()));
        ((CheckBox) view.findViewById(R.id.dv_)).setChecked(this.H.isGroupExpanded(i3));
    }

    @Override // od2.a
    public void e7(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("createNewTroop.ContactListAdapter", 2, "onRecommendCountChanged count=" + i3);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return this.D.get(this.C.get(i3).d()).get(i16);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        Object child = getChild(i3, i16);
        if (child instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d) {
            try {
                return Long.parseLong(((com.tencent.qqnt.ntrelation.friendsinfo.bean.d) child).x());
            } catch (Throwable th5) {
                if (!QLog.isColorLevel()) {
                    return 0L;
                }
                QLog.i("createNewTroop.ContactListAdapter", 2, QLog.getStackTraceString(th5));
                return 0L;
            }
        }
        if (!(child instanceof RelationTroopEntity)) {
            return 0L;
        }
        return this.J.g(((RelationTroopEntity) child).troopInfo.troopuin).longValue();
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return s(i3, i16);
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), view, viewGroup);
        }
        TraceUtils.traceBegin("getChildView");
        if (s(i3, i16) == 0) {
            view2 = l(i3, i16, z16, view, viewGroup);
        } else if (s(i3, i16) == 1) {
            view2 = p(i3, i16, z16, view, viewGroup);
        } else if (s(i3, i16) == 2) {
            view2 = m(view, viewGroup, this.f294692i, this.R, (RelationTroopEntity) getChild(i3, i16));
        } else {
            QLog.e("createNewTroop.ContactListAdapter", 1, "getChildView: error type groupPosition=" + i3 + ", childPosition=" + i16);
            view2 = null;
        }
        TraceUtils.traceEnd();
        return view2;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = this.C.get(i3);
        if (bVar != null && this.D.get(bVar.d()) != null) {
            return this.D.get(this.C.get(i3).d()).size();
        }
        return 0;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        if (i3 >= this.C.size()) {
            return new com.tencent.qqnt.ntrelation.friendsinfo.bean.b();
        }
        return this.C.get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.C.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, i3)).longValue();
        }
        return ((com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getGroup(i3)).d();
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f294692i).inflate(R.layout.fzk, viewGroup, false);
            bVar = new b();
            bVar.f294699b = (TextView) view.findViewById(R.id.group_name);
            bVar.f294700c = (TextView) view.findViewById(R.id.contact_count);
            bVar.f294701d = (ImageView) view.findViewById(R.id.dv_);
            view.setTag(bVar);
            view.setOnClickListener(this);
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar2 = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getGroup(i3);
        bVar.f294698a = i3;
        bVar.f294699b.setText(bVar2.f());
        bVar.f294700c.setText(String.valueOf(bVar2.e()));
        bVar.f294701d.setImageDrawable(o(z16));
        if (AppSetting.f99565y) {
            if (z16) {
                view.setContentDescription(bVar2.f() + HardCodeUtil.qqStr(R.string.l1p));
            } else {
                view.setContentDescription(bVar2.f() + HardCodeUtil.qqStr(R.string.l26));
            }
        }
        return view;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return R.layout.f167797hu;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
    }

    public com.tencent.qqnt.ntrelation.friendsinfo.bean.b n(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) iPatchRedirector.redirect((short) 30, (Object) this, j3);
        }
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = this.C.get(i3);
            if (bVar.d() == j3) {
                return bVar;
            }
        }
        return null;
    }

    @Override // android.widget.BaseExpandableListAdapter
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            y();
            super.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) view);
        } else {
            b bVar = (b) view.getTag();
            if (this.f302506f.isGroupExpanded(bVar.f294698a)) {
                this.f302506f.collapseGroup(bVar.f294698a);
            } else {
                try {
                    this.f302506f.expandGroup(bVar.f294698a);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) view)).booleanValue();
        } else {
            com.tencent.biz.qqcircle.richframework.widget.menu.c cVar = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
            cVar.a(0, this.f294692i.getResources().getString(R.string.bof));
            com.tencent.biz.qqcircle.richframework.widget.menu.a.c(view, cVar, this.Q, new BubblePopupWindow.c() { // from class: com.tencent.mobileqq.troop.createNewTroop.c
                @Override // com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow.c
                public final void onDismiss() {
                    ContactListAdapter.w();
                }
            });
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.widget.b, com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        super.onScroll(absListView, i3, i16, i17);
        AbsListView.OnScrollListener onScrollListener = this.G;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
    }

    @Override // com.tencent.mobileqq.troop.widget.b, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) absListView, i3);
            return;
        }
        super.onScrollStateChanged(absListView, i3);
        AbsListView.OnScrollListener onScrollListener = this.G;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w() {
    }
}
