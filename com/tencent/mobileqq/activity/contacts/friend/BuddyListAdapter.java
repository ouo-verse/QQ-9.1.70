package com.tencent.mobileqq.activity.contacts.friend;

import QQService.EVIPSPEC;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.adapter.ai;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.j;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.friend.alphabet.api.INTFriendApi;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.bp;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import com.tencent.widget.TraceUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BuddyListAdapter extends ai implements View.OnClickListener, View.OnLongClickListener, c.b, SwipPinnedHeaderExpandableListView.SwipListListener {
    static IPatchRedirector $redirector_;
    public static final f Z;
    private ArrayList<Object> C;
    private SparseArray<List<com.tencent.mobileqq.activity.contacts.base.c>> D;
    private SparseIntArray E;
    private final StatusManager F;
    private final FriendsManager G;
    private int H;
    private AbsListView.OnScrollListener I;
    private final View.OnClickListener J;
    public int K;
    private boolean L;
    private IPhoneContactService M;
    private final boolean N;
    private final int P;
    private boolean Q;
    private volatile boolean R;
    private d S;
    private e T;
    private com.tencent.mobileqq.activity.contacts.friend.b U;
    private SimpleTextView V;
    private SimpleTextView W;
    private int X;
    private final View.OnClickListener Y;

    /* renamed from: i, reason: collision with root package name */
    final BaseActivity f181557i;

    /* renamed from: m, reason: collision with root package name */
    private final QQAppInterface f181558m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Groups f181563d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f181564e;

        a(Groups groups, ActionSheet actionSheet) {
            this.f181563d = groups;
            this.f181564e = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BuddyListAdapter.this, groups, actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            int id5 = view.getId();
            if (id5 != 1) {
                if (id5 == 2) {
                    GroupManagerActivity.startGroupManager(BuddyListAdapter.this.f181557i.getActivity());
                    ReportController.o(BuddyListAdapter.this.f181558m, "dc00898", "", "", "0X800C11A", "0X800C11A", 0, 0, "", "", "", "");
                }
            } else {
                ((INTFriendApi) QRoute.api(INTFriendApi.class)).startFriendPermissionSetting(BuddyListAdapter.this.f181557i, this.f181563d.group_id);
            }
            this.f181564e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f181566d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Friends f181567e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f181568f;

        b(boolean z16, Friends friends, ActionSheet actionSheet) {
            this.f181566d = z16;
            this.f181567e = friends;
            this.f181568f = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BuddyListAdapter.this, Boolean.valueOf(z16), friends, actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (!NetworkUtil.isNetworkAvailable(BuddyListAdapter.this.f181557i)) {
                QQToast.makeText(BuddyListAdapter.this.f181557i, 1, R.string.b3j, 0).show();
            } else {
                FriendListHandler friendListHandler = (FriendListHandler) BuddyListAdapter.this.f181558m.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                if (friendListHandler == null) {
                    return;
                }
                if (this.f181566d) {
                    friendListHandler.setSpecialCareSwitch(1, new String[]{this.f181567e.uin}, new boolean[]{false});
                    ReportController.o(BuddyListAdapter.this.f181558m, "dc00898", "", "", "0X800808B", "0X800808B", 0, 0, "", "", "", "");
                } else {
                    friendListHandler.setSpecialCareSwitch(1, new String[]{this.f181567e.uin}, new boolean[]{true});
                    ReportController.o(BuddyListAdapter.this.f181558m, "dc00898", "", "", "0X800808A", "0X800808A", 0, 0, "", "", "", "");
                }
            }
            this.f181568f.superDismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BuddyListAdapter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                GroupManagerActivity.startGroupManager(BuddyListAdapter.this.f181557i);
                ReportController.o(BuddyListAdapter.this.f181558m, "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<BuddyListAdapter> f181571d;

        public d(BuddyListAdapter buddyListAdapter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) buddyListAdapter);
            } else {
                this.f181571d = new WeakReference<>(buddyListAdapter);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                BuddyListAdapter buddyListAdapter = this.f181571d.get();
                if (buddyListAdapter != null) {
                    buddyListAdapter.onClick(view);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static class e implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<BuddyListAdapter> f181572d;

        public e(BuddyListAdapter buddyListAdapter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) buddyListAdapter);
            } else {
                this.f181572d = new WeakReference<>(buddyListAdapter);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                BuddyListAdapter buddyListAdapter = this.f181572d.get();
                if (buddyListAdapter != null) {
                    z16 = buddyListAdapter.onLongClick(view);
                } else {
                    z16 = false;
                }
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class f implements Comparator<com.tencent.mobileqq.activity.contacts.base.c> {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public int a(Friends friends) {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) friends)).intValue();
            }
            int a16 = com.tencent.mobileqq.friend.status.b.a(friends.detalStatusFlag, friends.iTermType);
            if (a16 != 6 && a16 != 0) {
                i3 = 65536;
            } else {
                i3 = 131072;
            }
            int i17 = 16384;
            if (!SimpleUIUtil.getSimpleUISwitch()) {
                if (friends.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
                    i17 = 0;
                } else if (friends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
                    i17 = 4096;
                } else if (friends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
                    i17 = 8192;
                } else if (friends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
                    i17 = 12288;
                }
            }
            if (a16 != 1) {
                if (a16 != 2) {
                    if (a16 != 3 && a16 != 4) {
                        if (a16 != 7) {
                            i16 = ((int) friends.getLastLoginType()) | i17;
                        }
                    } else {
                        i16 = i17 | 1;
                    }
                }
                i16 = i17 | 3;
            } else {
                i16 = i17 | 2;
            }
            return i16 | i3;
        }

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.activity.contacts.base.c cVar, com.tencent.mobileqq.activity.contacts.base.c cVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) cVar2)).intValue();
            }
            Friends friends = (Friends) cVar.f181505e;
            Friends friends2 = (Friends) cVar2.f181505e;
            int a16 = a(friends);
            int a17 = a(friends2);
            if (a16 == a17) {
                return j.a(friends.mComparePartInt, friends.mCompareSpell, friends2.mComparePartInt, friends2.mCompareSpell);
            }
            return a16 - a17;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68065);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            Z = new f();
        }
    }

    public BuddyListAdapter(BaseActivity baseActivity, QQAppInterface qQAppInterface, SwipPinnedHeaderExpandableListView swipPinnedHeaderExpandableListView, View.OnClickListener onClickListener) {
        super(baseActivity, qQAppInterface, swipPinnedHeaderExpandableListView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseActivity, qQAppInterface, swipPinnedHeaderExpandableListView, onClickListener);
            return;
        }
        this.C = new ArrayList<>();
        this.D = new SparseArray<>();
        this.E = new SparseIntArray();
        this.H = 0;
        this.L = true;
        this.M = null;
        this.Q = true;
        this.R = false;
        this.X = -1;
        this.Y = new c();
        this.S = new d(this);
        this.T = new e(this);
        this.f181557i = baseActivity;
        this.f181558m = qQAppInterface;
        this.F = (StatusManager) qQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
        this.G = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.M = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        this.J = onClickListener;
        this.P = (int) al.a(baseActivity, 12.0f);
        notifyDataSetChanged();
        DeviceInfoMonitor.getModel().equals("Lenovo A366t");
        this.N = false;
    }

    private void p(com.tencent.mobileqq.troop.adapter.contact.a aVar, Groups groups, int i3, boolean z16, int i16) {
        String str;
        if (aVar == null) {
            return;
        }
        boolean z17 = true;
        if (!aVar.f293798b.isChecked()) {
            aVar.f293798b.setChecked(true);
        }
        StringBuilder sb5 = aVar.f293803g;
        if (AppSetting.f99565y) {
            if (sb5 == null) {
                sb5 = new StringBuilder(24);
            } else {
                sb5.delete(0, sb5.length());
            }
            sb5.append(groups.group_name + " \u5206\u7ec4");
        }
        aVar.f293797a = i3;
        aVar.f293800d.setText(groups.group_name);
        aVar.f293801e.setVisibility(8);
        aVar.f293799c.setVisibility(8);
        aVar.f293798b.setVisibility(0);
        int i17 = this.E.get(groups.group_id);
        int childrenCount = getChildrenCount(i3);
        if (groups.group_id == 1005) {
            SimpleTextView simpleTextView = aVar.f293802f;
            if (simpleTextView != null) {
                simpleTextView.setText(childrenCount + "");
            }
            if (AppSetting.f99565y) {
                sb5.append("\u5171" + childrenCount + "\u4e2a\u5e38\u7528\u7fa4\u804a");
            }
        } else {
            SimpleTextView simpleTextView2 = aVar.f293802f;
            if (simpleTextView2 != null) {
                if (this.N) {
                    str = "%d / %d";
                } else {
                    str = "%d/%d";
                }
                simpleTextView2.setText(String.format(str, Integer.valueOf(i17), Integer.valueOf(childrenCount)));
            }
            if (AppSetting.f99565y) {
                sb5.append("\u5728\u7ebf" + i17 + "\u4eba\uff0c\u5171" + childrenCount + "\u4eba");
            }
        }
        if (i16 == 0) {
            if (this.f187112f.isGroupExpanded(aVar.f293797a)) {
                i16 = 2;
            } else {
                i16 = 1;
            }
        }
        CheckBox checkBox = aVar.f293798b;
        if (i16 != 2) {
            z17 = false;
        }
        checkBox.setChecked(z17);
        if (AppSetting.f99565y) {
            if (aVar.f293798b.isChecked()) {
                sb5.append(" \u5df2\u5c55\u5f00");
            } else {
                sb5.append(" \u5df2\u6298\u53e0");
            }
            SimpleTextView simpleTextView3 = aVar.f293802f;
            if (simpleTextView3 != null) {
                simpleTextView3.setContentDescription(sb5.toString());
            }
            AccessibilityUtil.n(aVar.f293798b, false);
        }
        if (groups.group_id == 1002 && this.M.getSelfBindState() == this.M.getSelfBindState()) {
            if (z16) {
                this.W = aVar.f293802f;
                return;
            } else {
                this.V = aVar.f293802f;
                return;
            }
        }
        SimpleTextView simpleTextView4 = this.W;
        SimpleTextView simpleTextView5 = aVar.f293802f;
        if (simpleTextView4 == simpleTextView5) {
            this.W = null;
        }
        if (this.V == simpleTextView5) {
            this.V = null;
        }
    }

    private boolean r() {
        return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("fix8980Contacts_80593740", Boolean.TRUE).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(ArrayList<Object> arrayList, SparseArray<List<com.tencent.mobileqq.activity.contacts.base.c>> sparseArray, SparseIntArray sparseIntArray) {
        List<Groups> list;
        String str;
        char c16;
        Groups groups;
        ArrayList arrayList2;
        AppRuntime runtime;
        ArrayList arrayList3 = arrayList;
        Groups groups2 = new Groups();
        groups2.group_id = 1004;
        groups2.group_name = this.f181557i.getString(R.string.f172976g92);
        int i3 = 1;
        groups2.group_friend_count = 1;
        groups2.seqid = (byte) 0;
        arrayList3.add(groups2);
        ArrayList arrayList4 = new ArrayList();
        FriendsManager friendsManager = (FriendsManager) this.f181558m.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsManager != null) {
            list = friendsManager.C0();
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("BuddyListAdapter", 2, "FriendManager is null");
            }
            list = null;
        }
        if (list == null || list.size() == 0) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("group list is ");
                if (list == null) {
                    str = "null";
                } else {
                    str = GlobalUtil.DEF_STRING;
                }
                sb5.append(str);
                QLog.d("BuddyListAdapter", 2, sb5.toString());
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            arrayList3.remove(groups2);
        }
        Iterator<Groups> it = list.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            Groups next = it.next();
            arrayList3.add(next);
            new ArrayList();
            ArrayList<Friends> M = friendsManager.M(String.valueOf(next.group_id));
            if (com.tencent.relation.common.utils.e.f364767a.a()) {
                QLog.d("BuddyListAdapter", i3, "loadData filter robot");
                Iterator<Friends> it5 = M.iterator();
                while (it5.hasNext()) {
                    Friends next2 = it5.next();
                    ArrayList arrayList5 = arrayList4;
                    if (next2.robotVersion != 0 || next2.robotType != 0) {
                        it5.remove();
                        next.group_friend_count -= i3;
                    }
                    arrayList4 = arrayList5;
                }
            }
            ArrayList arrayList6 = arrayList4;
            ArrayList arrayList7 = new ArrayList(M.size());
            Iterator<Friends> it6 = M.iterator();
            com.tencent.mobileqq.activity.contacts.base.c cVar = null;
            int i17 = 0;
            while (it6.hasNext()) {
                Friends next3 = it6.next();
                Friends friends = next3;
                Iterator<Friends> it7 = it6;
                FriendsManager friendsManager2 = friendsManager;
                int a16 = com.tencent.mobileqq.friend.status.b.a(friends.detalStatusFlag, friends.iTermType);
                Iterator<Groups> it8 = it;
                SpecialCareInfo O = this.G.O(friends.uin);
                if (O != null && O.globalSwitch != 0) {
                    groups = groups2;
                    arrayList2 = arrayList6;
                    arrayList2.add(com.tencent.mobileqq.activity.contacts.base.b.b(4, next3, this.f181558m, this.f181557i));
                    if (a16 != 0 && a16 != 6) {
                        i16++;
                    }
                } else {
                    groups = groups2;
                    arrayList2 = arrayList6;
                }
                int i18 = i16;
                if (friends.gathtertype == 1) {
                    i16 = i18;
                    arrayList6 = arrayList2;
                    it6 = it7;
                    friendsManager = friendsManager2;
                    it = it8;
                    groups2 = groups;
                } else {
                    if (a16 != 0 && a16 != 6) {
                        i17++;
                    }
                    com.tencent.mobileqq.activity.contacts.base.c b16 = com.tencent.mobileqq.activity.contacts.base.b.b(0, next3, this.f181558m, this.f181557i);
                    b16.m(this);
                    try {
                        runtime = BaseApplicationImpl.getApplication().getRuntime();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    if (runtime != null) {
                        if (friends.uin.equals(runtime.getAccount())) {
                            i16 = i18;
                            cVar = b16;
                            arrayList6 = arrayList2;
                            it6 = it7;
                            friendsManager = friendsManager2;
                            it = it8;
                            groups2 = groups;
                        }
                        arrayList7.add(b16);
                        i16 = i18;
                        arrayList6 = arrayList2;
                        it6 = it7;
                        friendsManager = friendsManager2;
                        it = it8;
                        groups2 = groups;
                    } else {
                        i16 = i18;
                        arrayList6 = arrayList2;
                        it6 = it7;
                        friendsManager = friendsManager2;
                        it = it8;
                        groups2 = groups;
                    }
                }
            }
            Groups groups3 = groups2;
            FriendsManager friendsManager3 = friendsManager;
            Iterator<Groups> it9 = it;
            ArrayList arrayList8 = arrayList6;
            w(arrayList7);
            if (cVar != null) {
                arrayList7.add(0, cVar);
            }
            sparseIntArray.put(next.group_id, i17);
            sparseArray.put(next.group_id, arrayList7);
            if (QLog.isColorLevel()) {
                c16 = 2;
                QLog.d("BuddyListAdapter", 2, "groupId: " + next.group_id + " num: " + M.size());
            } else {
                c16 = 2;
            }
            arrayList4 = arrayList8;
            friendsManager = friendsManager3;
            it = it9;
            groups2 = groups3;
            i3 = 1;
            arrayList3 = arrayList;
        }
        ArrayList arrayList9 = arrayList4;
        w(arrayList9);
        sparseIntArray.put(1004, i16);
        sparseArray.put(1004, arrayList9);
        groups2.group_friend_count = arrayList9.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        String string = this.f181558m.getApp().getSharedPreferences(this.f181558m.getAccount(), 0).getString("700_sp_key_last_expanded", "700_sp_key_last_expanded");
        if (QLog.isColorLevel()) {
            QLog.d("BuddyListAdapter", 2, "readExpand=" + string);
        }
        HashSet hashSet = new HashSet();
        if ("700_sp_key_last_expanded".equalsIgnoreCase(string)) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.C.size()) {
                    break;
                }
                if (getGroupType(i3) == 0) {
                    Groups groups = (Groups) this.C.get(i3);
                    if (groups.group_friend_count > 0) {
                        hashSet.add(Integer.valueOf(groups.group_id));
                        break;
                    }
                }
                i3++;
            }
            if (hashSet.size() == 0) {
                this.Q = true;
            }
        } else if (!TextUtils.isEmpty(string)) {
            for (String str : string.split("_")) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException unused) {
                }
            }
        }
        for (int i16 = 0; i16 < this.C.size(); i16++) {
            if (getGroupType(i16) == 0 && hashSet.contains(Integer.valueOf(((Groups) this.C.get(i16)).group_id))) {
                this.f187112f.expandGroup(i16);
            }
        }
    }

    private void v() {
        Object tag;
        int childCount = this.f187112f.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f187112f.getChildAt(i3);
            if (childAt != null && (tag = childAt.getTag()) != null && (tag instanceof BuddyListFriends.a)) {
                BuddyListFriends.a aVar = (BuddyListFriends.a) tag;
                if (TextUtils.isEmpty(aVar.f181512i.getText().toString())) {
                    Object obj = aVar.f181513m;
                    if (obj instanceof Friends) {
                        q((Friends) obj, aVar);
                    }
                }
            }
        }
    }

    private void w(List<com.tencent.mobileqq.activity.contacts.base.c> list) {
        try {
            Collections.sort(list, Z);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("BuddyListAdapter", 2, "", e16);
            }
        }
    }

    private void x() {
        SharedPreferences.Editor edit;
        StringBuffer stringBuffer = new StringBuffer();
        int groupCount = getGroupCount();
        if (groupCount <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("BuddyListAdapter", 2, "no data. don't save group");
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < groupCount; i3++) {
            if (getGroupType(i3) == 0) {
                Groups groups = (Groups) getGroup(i3);
                if (this.f187112f.isGroupExpanded(i3)) {
                    stringBuffer.append(groups.group_id);
                    stringBuffer.append("_");
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        if (QLog.isColorLevel()) {
            QLog.d("BuddyListAdapter", 2, "saveExpanded=" + stringBuffer.toString());
        }
        SharedPreferences sharedPreferences = this.f181558m.getApp().getSharedPreferences(this.f181558m.getAccount(), 0);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString("700_sp_key_last_expanded", stringBuffer.toString()).commit();
    }

    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            super.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c.b
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.H;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) view, i3);
            return;
        }
        Groups groups = (Groups) getGroup(i3);
        if (!(view.getTag() instanceof com.tencent.mobileqq.troop.adapter.contact.a)) {
            aVar = new com.tencent.mobileqq.troop.adapter.contact.a();
            aVar.f293798b = (CheckBox) view.findViewById(R.id.dv_);
            SingleLineTextView singleLineTextView = (SingleLineTextView) view.findViewById(R.id.group_name);
            aVar.f293800d = singleLineTextView;
            singleLineTextView.setDefaultTextColor(-8355712);
            aVar.f293801e = (SingleLineTextView) view.findViewById(R.id.f167055ka1);
            SimpleTextView simpleTextView = (SimpleTextView) view.findViewById(R.id.contact_count);
            aVar.f293802f = simpleTextView;
            simpleTextView.setDefaultTextColor(1711276032);
            aVar.f293799c = (ProgressBar) view.findViewById(R.id.f165958dx0);
            view.setTag(aVar);
        } else {
            aVar = (com.tencent.mobileqq.troop.adapter.contact.a) view.getTag();
        }
        p(aVar, groups, i3, true, 0);
        aVar.f293800d.setTypeface(Typeface.SANS_SERIF);
        if (ThemeUtil.isNowThemeIsDefaultCache(this.f181558m, false) && !QUITokenResUtil.useQUIToken()) {
            aVar.f293802f.setTextColor(-5196865);
        } else {
            aVar.f293802f.setTextColor(this.f181557i.getResources().getColorStateList(QUITokenResUtil.getResId(R.color.skin_gray2_theme_version2, R.color.qui_common_text_secondary)));
        }
        Resources resources = view.getResources();
        if (QUITokenResUtil.useQUIToken() && resources != null) {
            view.setBackground(resources.getDrawable(R.drawable.jis, null));
        }
    }

    @Override // com.tencent.mobileqq.adapter.ai
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        x();
        OldMutualMarkLogicHelper.a(this.f181558m);
        super.destroy();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        List<com.tencent.mobileqq.activity.contacts.base.c> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (getGroupType(i3) != 0 || (list = this.D.get(((Groups) this.C.get(i3)).group_id)) == null) {
            return null;
        }
        return list.get(i16);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        Object child = getChild(i3, i16);
        if (child instanceof Friends) {
            try {
                return Long.parseLong(((Friends) child).uin);
            } catch (Throwable th5) {
                if (!QLog.isColorLevel()) {
                    return 0L;
                }
                QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(th5));
                return 0L;
            }
        }
        if (child instanceof PublicAccountInfo) {
            return ((PublicAccountInfo) child).uin;
        }
        if (!(child instanceof PhoneContact)) {
            return 0L;
        }
        try {
            return Long.parseLong(((PhoneContact) child).mobileNo);
        } catch (Throwable th6) {
            if (!QLog.isColorLevel()) {
                return 0L;
            }
            QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(th6));
            return 0L;
        }
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (getGroupType(i3) == 0) {
            if (((Groups) this.C.get(i3)).group_id == 1002) {
                return 1;
            }
            return 0;
        }
        return 99;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 6;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        View a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), view, viewGroup);
        }
        if (QLog.isDebugVersion()) {
            TraceUtils.traceBegin("getChildView");
        }
        com.tencent.mobileqq.activity.contacts.base.c cVar = (com.tencent.mobileqq.activity.contacts.base.c) getChild(i3, i16);
        if (cVar == null) {
            a16 = null;
        } else {
            a16 = cVar.a(i3, i16, view, viewGroup, this.J);
        }
        if (a16 != null) {
            c((c.C7154c) a16.getTag(), null);
            View.OnClickListener onClickListener = this.J;
            if (onClickListener != null) {
                a16.setOnClickListener(onClickListener);
            }
            a16.setOnLongClickListener(this.T);
        }
        if (QLog.isDebugVersion()) {
            TraceUtils.traceEnd();
        }
        return a16;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, i3)).intValue();
        }
        if (getGroupType(i3) == 1) {
            return 0;
        }
        List<com.tencent.mobileqq.activity.contacts.base.c> list = this.D.get(((Groups) this.C.get(i3)).group_id);
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        return this.C.get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.C.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this, i3)).longValue();
        }
        if (getGroupType(i3) == 0) {
            return ((Groups) getGroup(i3)).group_id;
        }
        return 1000L;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3)).intValue();
        }
        if (i3 >= 0 && i3 < this.C.size()) {
            if (this.C.get(i3) instanceof String) {
                return 1;
            }
            return 0;
        }
        QLog.e("BuddyListAdapter", 1, "getGroupType illegal, groupPosition =" + i3 + ", size=" + this.C.size());
        return 1;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        int i16;
        SingleLineTextView singleLineTextView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (View) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Boolean.valueOf(z16), view, viewGroup);
        }
        if (getGroupType(i3) == 1) {
            if (view == null) {
                view = LayoutInflater.from(this.f181557i).inflate(QUITokenResUtil.getResId(R.layout.f167795hs, R.layout.e3y), viewGroup, false);
                singleLineTextView = (SingleLineTextView) view.findViewById(R.id.k7c);
                if (singleLineTextView != null) {
                    singleLineTextView.setDefaultTextColor(-8355712);
                    view.setTag(singleLineTextView);
                }
            } else {
                singleLineTextView = (SingleLineTextView) view.getTag();
            }
            if (singleLineTextView != null) {
                singleLineTextView.setText("");
            }
        } else {
            Groups groups = (Groups) getGroup(i3);
            if (view == null) {
                view = LayoutInflater.from(this.f181557i).inflate(QUITokenResUtil.getResId(R.layout.f167798hv, R.layout.e3z), viewGroup, false);
                aVar = new com.tencent.mobileqq.troop.adapter.contact.a();
                aVar.f293800d = (SingleLineTextView) view.findViewById(R.id.group_name);
                aVar.f293798b = (CheckBox) view.findViewById(R.id.dv_);
                SimpleTextView simpleTextView = (SimpleTextView) view.findViewById(R.id.contact_count);
                aVar.f293802f = simpleTextView;
                simpleTextView.setDefaultTextColor(1711276032);
                aVar.f293799c = (ProgressBar) view.findViewById(R.id.f165958dx0);
                aVar.f293801e = (SingleLineTextView) view.findViewById(R.id.f167055ka1);
                view.setTag(aVar);
            } else {
                aVar = (com.tencent.mobileqq.troop.adapter.contact.a) view.getTag();
            }
            com.tencent.mobileqq.troop.adapter.contact.a aVar2 = aVar;
            if (ThemeUtil.isNowThemeIsDefaultCache(this.f181558m, false) && !QUITokenResUtil.useQUIToken()) {
                aVar2.f293802f.setTextColor(-5196865);
            } else {
                aVar2.f293802f.setTextColor(this.f181557i.getResources().getColorStateList(QUITokenResUtil.getResId(R.color.skin_gray2_theme_version2, R.color.qui_common_text_secondary)));
            }
            view.setOnClickListener(this.S);
            view.setOnLongClickListener(this.T);
            if (r()) {
                view.setContentDescription(null);
            }
            if (z16) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            p(aVar2, groups, i3, false, i16);
        }
        return view;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return QUITokenResUtil.getResId(R.layout.f167798hv, R.layout.e3z);
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
    public void hideMenuPop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        }
    }

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
    public void interceptTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            FrameHelperActivity.gj(!z16, "BuddyListAdapter");
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public boolean needHideBackgroundGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // android.widget.BaseExpandableListAdapter
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BuddyListAdapter", 2, "notifyDataSetChanged");
        }
        com.tencent.mobileqq.activity.contacts.report.d.n("fetch_local_data_start_time");
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyListAdapter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                SparseArray sparseArray = new SparseArray();
                SparseIntArray sparseIntArray = new SparseIntArray();
                try {
                    BuddyListAdapter.this.s(arrayList, sparseArray, sparseIntArray);
                    com.tencent.mobileqq.activity.contacts.report.d.n("fetch_local_data_end_time");
                } catch (OutOfMemoryError e16) {
                    QLog.e("BuddyListAdapter", 1, "notifyDataSetChanged error oom ", e16);
                }
                ThreadManager.getUIHandler().post(new Runnable(arrayList, sparseArray, sparseIntArray) { // from class: com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ArrayList f181559d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ SparseArray f181560e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ SparseIntArray f181561f;

                    {
                        this.f181559d = arrayList;
                        this.f181560e = sparseArray;
                        this.f181561f = sparseIntArray;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, arrayList, sparseArray, sparseIntArray);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("BuddyListAdapter", 2, "notifyDataSetChanged out ThreadManager");
                        }
                        BuddyListAdapter.this.C = this.f181559d;
                        BuddyListAdapter.this.D = this.f181560e;
                        BuddyListAdapter.this.E = this.f181561f;
                        ((FPSPinnedHeaderExpandableListView) ((ai) BuddyListAdapter.this).f187112f).hideCurShowingRightView();
                        BuddyListAdapter.super.notifyDataSetChanged();
                        if (Contacts.mStartRelationTabShowTime != 0) {
                            com.tencent.relation.common.report.a.c(Contacts.RELATION_TAB_SHOWTIME, System.currentTimeMillis() - Contacts.mStartRelationTabShowTime, true, null);
                            Contacts.mStartRelationTabShowTime = 0L;
                        }
                        if (BuddyListAdapter.this.Q) {
                            BuddyListAdapter.this.Q = false;
                            BuddyListAdapter.this.u();
                            if (BuddyListAdapter.this.U != null) {
                                BuddyListAdapter.this.U.a();
                            }
                        }
                        com.tencent.mobileqq.activity.contacts.report.d.n("refresh_ui_time");
                    }
                });
            }
        }, null, true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        } else {
            com.tencent.mobileqq.troop.adapter.contact.a aVar = (com.tencent.mobileqq.troop.adapter.contact.a) view.getTag();
            boolean isGroupExpanded = this.f187112f.isGroupExpanded(aVar.f293797a);
            if (r()) {
                if (isGroupExpanded) {
                    str = "\u5df2\u6298\u53e0";
                } else {
                    str = "\u5df2\u5c55\u5f00";
                }
                view.setContentDescription(str);
                view.sendAccessibilityEvent(4);
            }
            if (isGroupExpanded) {
                this.f187112f.collapseGroup(aVar.f293797a);
            } else {
                this.f187112f.expandGroup(aVar.f293797a);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z16;
        Object tag;
        Object obj;
        int i3;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) view)).booleanValue();
        } else {
            boolean z17 = false;
            if (!u.a().b() && this.L && (tag = view.getTag()) != null) {
                if (tag instanceof com.tencent.mobileqq.troop.adapter.contact.a) {
                    com.tencent.mobileqq.troop.adapter.contact.a aVar = (com.tencent.mobileqq.troop.adapter.contact.a) tag;
                    int i16 = aVar.f293797a;
                    Groups groups = (Groups) this.C.get(i16);
                    ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f181557i, null);
                    actionSheet.setMainTitle(String.format(this.f181557i.getString(R.string.f225416lk), aVar.f293800d.getText()));
                    if (getChildrenCount(i16) > 0) {
                        actionSheet.addButton(R.string.f225366lf, 1, 1);
                    }
                    actionSheet.addButton(R.string.f1384609m, 1, 2);
                    actionSheet.addCancelButton(R.string.cancel);
                    actionSheet.setOnButtonClickListener(new a(groups, actionSheet));
                    actionSheet.show();
                    ReportController.o(this.f181558m, "dc00898", "", "", "0X800C110", "0X800C110", 0, 0, "", "", "", "");
                } else if ((tag instanceof c.C7154c) && (obj = ((c.C7154c) tag).f181513m) != null && (obj instanceof Friends)) {
                    ActionSheet actionSheet2 = (ActionSheet) ActionSheetHelper.createDialog(this.f181557i, null);
                    QQAppInterface qQAppInterface = this.f181558m;
                    if (qQAppInterface != null) {
                        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
                        Friends friends = (Friends) obj;
                        if (friendsManager != null) {
                            SpecialCareInfo O = friendsManager.O(friends.uin);
                            if (!this.f181558m.getCurrentUin().equals(friends.uin)) {
                                if (O != null && O.globalSwitch != 0) {
                                    z17 = true;
                                }
                                if (z17) {
                                    i3 = R.string.a9d;
                                } else {
                                    i3 = R.string.a9e;
                                }
                                actionSheet2.addButton(i3);
                                actionSheet2.addCancelButton(R.string.cancel);
                                actionSheet2.setOnButtonClickListener(new b(z17, friends, actionSheet2));
                                try {
                                    actionSheet2.show();
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                z16 = true;
            }
            z16 = false;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    @Override // com.tencent.mobileqq.adapter.ai, com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        super.onScroll(absListView, i3, i16, i17);
        AbsListView.OnScrollListener onScrollListener = this.I;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
    }

    @Override // com.tencent.mobileqq.adapter.ai, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) absListView, i3);
            return;
        }
        this.H = i3;
        super.onScrollStateChanged(absListView, i3);
        if (i3 == 0) {
            v();
            oy3.a.a().c("list_g_contacts", false);
        } else {
            oy3.a.a().b("list_g_contacts");
        }
        AbsListView.OnScrollListener onScrollListener = this.I;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
        if (i3 != 0) {
            ApngImage.pauseByTag(3);
        }
        if (i3 == 0) {
            ApngImage.playByTag(3);
        }
    }

    String q(Friends friends, BuddyListFriends.a aVar) {
        FriendsManager friendsManager;
        boolean z16;
        RichStatus richStatus;
        boolean z17;
        boolean z18;
        String str;
        int i3;
        boolean z19;
        String str2 = null;
        if (this.F == null || (friendsManager = this.G) == null) {
            return null;
        }
        ExtensionInfo H = friendsManager.H(friends.uin);
        int i16 = 0;
        if (H != null && !TextUtils.isEmpty(H.feedContent)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (H != null) {
            if (this.H != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            richStatus = com.tencent.mobileqq.richstatus.c.f(H, z19);
        } else {
            richStatus = null;
        }
        if (richStatus != null && richStatus != RichStatus.getEmptyStatus() && !richStatus.isEmpty()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && !TextUtils.isEmpty(richStatus.actionText)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16 && (H.feedTime > H.richTime || !z17)) {
            str = new String(H.feedContent);
            aVar.f181512i.setCompoundDrawables(null, null);
            if (H.feedType == 2) {
                aVar.D.setVisibility(0);
                if (!TextUtils.isEmpty(H.feedPhotoUrl)) {
                    bp.a(aVar.D, H.feedPhotoUrl, this.f181557i.getResources().getDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                } else {
                    aVar.D.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                }
                aVar.E.setVisibility(8);
                aVar.F.setVisibility(8);
            } else {
                aVar.E.setVisibility(0);
                ImageView imageView = aVar.E;
                if (H.feedType == 1) {
                    i3 = R.drawable.f162391gm3;
                } else {
                    i3 = R.drawable.f162389gm1;
                }
                imageView.setBackgroundResource(i3);
                URLImageView uRLImageView = aVar.F;
                if (!H.feedHasPhoto) {
                    i16 = 8;
                }
                uRLImageView.setVisibility(i16);
                aVar.D.setVisibility(8);
                aVar.D.setImageDrawable(null);
            }
        } else {
            if (z18) {
                richStatus.enableSummaryCached = friends.isFriend();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f181557i.getResources(), this.F.K(richStatus.actionId, 200));
                int i17 = this.P;
                bitmapDrawable.setBounds(0, 0, Math.round(((bitmapDrawable.getIntrinsicWidth() * 1.0f) / bitmapDrawable.getIntrinsicHeight()) * i17), i17);
                aVar.f181512i.setCompoundDrawables(bitmapDrawable, null);
            } else if (!z17) {
                richStatus = RichStatus.getEmptyStatus();
                aVar.f181512i.setCompoundDrawables(null, null);
            }
            String actionAndData = richStatus.getActionAndData();
            String plainText = richStatus.getPlainText();
            aVar.F.setVisibility(8);
            aVar.E.setVisibility(8);
            aVar.D.setVisibility(8);
            aVar.D.setImageDrawable(null);
            str2 = actionAndData;
            str = plainText;
        }
        if (H == null) {
            aVar.F.setVisibility(8);
            aVar.E.setVisibility(8);
        }
        aVar.f181512i.setExtendText(str2, 1);
        aVar.f181512i.setText(str);
        return str;
    }

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
    public boolean supportSwip(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) view)).booleanValue();
        }
        if (!this.L) {
            return false;
        }
        if (view.getTag() instanceof BuddyListFriends.a) {
            Object obj = ((BuddyListFriends.a) view.getTag()).f181513m;
            if (obj instanceof Friends) {
                Friends friends = (Friends) obj;
                if (friends.uin.equals(this.f181558m.getCurrentAccountUin()) || Utils.G(friends.uin)) {
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            x();
            OldMutualMarkLogicHelper.a(this.f181558m);
        }
    }

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
    public void updateCurShowRightView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) view);
            return;
        }
        int i3 = -1;
        if (view != null) {
            Object tag = view.getTag(-1);
            if (tag instanceof Integer) {
                i3 = ((Integer) tag).intValue();
            }
        }
        this.K = i3;
    }

    public void y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.L = z16;
        }
    }

    public void z(com.tencent.mobileqq.activity.contacts.friend.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) bVar);
        } else {
            this.U = bVar;
        }
    }
}
