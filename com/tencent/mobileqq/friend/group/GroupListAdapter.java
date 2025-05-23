package com.tencent.mobileqq.friend.group;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.adapter.ai;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.utils.h;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import com.tencent.widget.TraceUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GroupListAdapter extends ai implements View.OnClickListener, View.OnLongClickListener, c.b, SwipPinnedHeaderExpandableListView.SwipListListener {
    private final StatusManager C;
    private final FriendsManager D;
    private int E;
    private AbsListView.OnScrollListener F;
    private final View.OnClickListener G;
    public int H;
    private boolean I;
    private IPhoneContactService J;
    private final boolean K;
    private boolean L;
    private a M;
    private b N;
    private ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> P;
    private com.tencent.mobileqq.activity.contacts.friend.b Q;
    private SimpleTextView R;
    private SimpleTextView S;

    /* renamed from: i, reason: collision with root package name */
    final BaseActivity f211634i;

    /* renamed from: m, reason: collision with root package name */
    private final QQAppInterface f211635m;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    static class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<GroupListAdapter> f211637d;

        public a(GroupListAdapter groupListAdapter) {
            this.f211637d = new WeakReference<>(groupListAdapter);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupListAdapter groupListAdapter = this.f211637d.get();
            if (groupListAdapter != null) {
                groupListAdapter.onClick(view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    static class b implements View.OnLongClickListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<GroupListAdapter> f211638d;

        public b(GroupListAdapter groupListAdapter) {
            this.f211638d = new WeakReference<>(groupListAdapter);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            GroupListAdapter groupListAdapter = this.f211638d.get();
            if (groupListAdapter != null) {
                return groupListAdapter.onLongClick(view);
            }
            return false;
        }
    }

    public GroupListAdapter(BaseActivity baseActivity, QQAppInterface qQAppInterface, SwipPinnedHeaderExpandableListView swipPinnedHeaderExpandableListView, View.OnClickListener onClickListener) {
        super(baseActivity, qQAppInterface, swipPinnedHeaderExpandableListView);
        this.E = 0;
        this.I = true;
        this.J = null;
        this.L = true;
        this.P = new ArrayList<>();
        this.M = new a(this);
        this.N = new b(this);
        this.f211634i = baseActivity;
        this.f211635m = qQAppInterface;
        this.C = (StatusManager) qQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
        this.D = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.J = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        this.G = onClickListener;
        notifyDataSetChanged();
        DeviceInfoMonitor.getModel().equals("Lenovo A366t");
        this.K = false;
    }

    private void g(com.tencent.mobileqq.troop.adapter.contact.a aVar, com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar, int i3, boolean z16, int i16) {
        if (aVar != null && bVar != null) {
            if (!aVar.f293798b.isChecked()) {
                aVar.f293798b.setChecked(true);
            }
            String f16 = bVar.f();
            StringBuilder sb5 = aVar.f293803g;
            if (AppSetting.f99565y) {
                if (sb5 == null) {
                    sb5 = new StringBuilder(24);
                } else {
                    sb5.delete(0, sb5.length());
                }
                sb5.append(f16 + " \u5206\u7ec4");
            }
            aVar.f293797a = i3;
            aVar.f293800d.setText(f16);
            aVar.f293801e.setVisibility(8);
            aVar.f293799c.setVisibility(8);
            aVar.f293798b.setVisibility(0);
            int d16 = bVar.d();
            int g16 = bVar.g();
            int childrenCount = getChildrenCount(i3);
            if (d16 == 1005) {
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
                    simpleTextView2.setText(String.format(this.K ? "%d / %d" : "%d/%d", Integer.valueOf(g16), Integer.valueOf(childrenCount)));
                }
                if (AppSetting.f99565y) {
                    sb5.append("\u5728\u7ebf" + g16 + "\u4eba\uff0c\u5171" + childrenCount + "\u4eba");
                }
            }
            if (i16 == 0) {
                i16 = this.f187112f.isGroupExpanded(aVar.f293797a) ? 2 : 1;
            }
            aVar.f293798b.setChecked(i16 == 2);
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
            if (d16 == 1002 && this.J.getSelfBindState() == this.J.getSelfBindState()) {
                if (z16) {
                    this.S = aVar.f293802f;
                    return;
                } else {
                    this.R = aVar.f293802f;
                    return;
                }
            }
            SimpleTextView simpleTextView4 = this.S;
            SimpleTextView simpleTextView5 = aVar.f293802f;
            if (simpleTextView4 == simpleTextView5) {
                this.S = null;
            }
            if (this.R == simpleTextView5) {
                this.R = null;
                return;
            }
            return;
        }
        QLog.d("GroupListAdapter", 2, "tag == null || ntCategoryInfo == null");
    }

    private void k() {
        String string = h.e(this.f211634i, this.f211635m.getAccount()).getString("700_sp_key_last_expanded", "700_sp_key_last_expanded");
        if (QLog.isColorLevel()) {
            QLog.d("GroupListAdapter", 2, "readExpand=" + string);
        }
        HashSet hashSet = new HashSet();
        if ("700_sp_key_last_expanded".equalsIgnoreCase(string)) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.P.size()) {
                    break;
                }
                if (getGroupType(i3) == 0) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = this.P.get(i3);
                    if (bVar.e() > 0) {
                        hashSet.add(Integer.valueOf(bVar.d()));
                        break;
                    }
                }
                i3++;
            }
            if (hashSet.size() == 0) {
                this.L = true;
            }
        } else if (!TextUtils.isEmpty(string)) {
            for (String str : string.split("_")) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("GroupListAdapter", 2, "expand: " + str + "nfe\uff1a" + e16.toString());
                    }
                }
            }
        }
        for (int i16 = 0; i16 < this.P.size(); i16++) {
            if (getGroupType(i16) == 0 && hashSet.contains(Integer.valueOf(this.P.get(i16).d()))) {
                this.f187112f.expandGroup(i16);
            }
        }
    }

    private void l() {
        final StringBuffer stringBuffer = new StringBuffer();
        int groupCount = getGroupCount();
        if (groupCount <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("GroupListAdapter", 2, "no data. don't save group");
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < groupCount; i3++) {
            if (getGroupType(i3) == 0) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getGroup(i3);
                if (this.f187112f.isGroupExpanded(i3)) {
                    stringBuffer.append(bVar.d());
                    stringBuffer.append("_");
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        if (QLog.isColorLevel()) {
            QLog.d("GroupListAdapter", 2, "saveExpanded=" + stringBuffer.toString());
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.friend.group.GroupListAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit;
                GroupListAdapter groupListAdapter = GroupListAdapter.this;
                SharedPreferences e16 = h.e(groupListAdapter.f211634i, groupListAdapter.f211635m.getAccount());
                if (e16 == null || (edit = e16.edit()) == null) {
                    return;
                }
                edit.putString("700_sp_key_last_expanded", stringBuffer.toString()).commit();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c.b
    public int a() {
        return this.E;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getGroup(i3);
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
        g(aVar, bVar, i3, true, 0);
        aVar.f293800d.setTypeface(Typeface.SANS_SERIF);
        if (ThemeUtil.isNowThemeIsDefaultCache(this.f211635m, false) && !QUITokenResUtil.useQUIToken()) {
            aVar.f293802f.setTextColor(-5196865);
        } else {
            aVar.f293802f.setTextColor(this.f211634i.getResources().getColorStateList(QUITokenResUtil.getResId(R.color.skin_gray2_theme_version2, R.color.qui_common_text_secondary)));
        }
        Resources resources = view.getResources();
        if (!QUITokenResUtil.useQUIToken() || resources == null) {
            return;
        }
        view.setBackground(resources.getDrawable(R.drawable.jis, null));
    }

    @Override // com.tencent.mobileqq.adapter.ai
    public void destroy() {
        l();
        super.destroy();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        if (getGroupType(i3) == 0) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = this.P.get(i3);
            if (bVar == null) {
                QLog.d("GroupListAdapter", 2, "null == ntCategoryInfo");
                return null;
            }
            ArrayList<String> c16 = bVar.c();
            if (c16 != null && !c16.isEmpty() && c16.size() > i16) {
                String str = c16.get(i16);
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                QLog.d("GroupListAdapter", 2, "uid is empty");
                return null;
            }
            QLog.d("GroupListAdapter", 2, "uidList empty");
        }
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        Object child = getChild(i3, i16);
        if (child instanceof Friends) {
            try {
                return Long.parseLong(((Friends) child).uin);
            } catch (Throwable th5) {
                if (!QLog.isColorLevel()) {
                    return 0L;
                }
                QLog.i("GroupListAdapter", 2, QLog.getStackTraceString(th5));
                return 0L;
            }
        }
        if (child instanceof PublicAccountInfo) {
            return ((PublicAccountInfo) child).uin;
        }
        if (child instanceof PhoneContact) {
            try {
                return Long.parseLong(((PhoneContact) child).mobileNo);
            } catch (Throwable th6) {
                if (!QLog.isColorLevel()) {
                    return 0L;
                }
                QLog.i("GroupListAdapter", 2, QLog.getStackTraceString(th6));
                return 0L;
            }
        }
        if (child instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d) {
            try {
                return Long.parseLong(((com.tencent.qqnt.ntrelation.friendsinfo.bean.d) child).x());
            } catch (Throwable th7) {
                if (!QLog.isColorLevel()) {
                    return 0L;
                }
                QLog.i("GroupListAdapter", 2, QLog.getStackTraceString(th7));
                return 0L;
            }
        }
        if (!(child instanceof String)) {
            return 0L;
        }
        try {
            return Long.parseLong(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid((String) child));
        } catch (Throwable th8) {
            if (!QLog.isColorLevel()) {
                return 0L;
            }
            QLog.i("GroupListAdapter", 2, QLog.getStackTraceString(th8));
            return 0L;
        }
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i3, int i16) {
        if (getGroupType(i3) == 0) {
            return this.P.get(i3).d() == 1002 ? 1 : 0;
        }
        return 99;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        return 6;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        TraceUtils.traceBegin("getChildView");
        View a16 = new GroupListFriend(this.f211635m, this.f211634i, (String) getChild(i3, i16)).a(i3, i16, view, viewGroup, this.G);
        if (a16 != null) {
            c((c.C7154c) a16.getTag(), null);
            View.OnClickListener onClickListener = this.G;
            if (onClickListener != null) {
                a16.setOnClickListener(onClickListener);
            }
        }
        TraceUtils.traceEnd();
        return a16;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        if (getGroupType(i3) == 1) {
            return 0;
        }
        return this.P.get(i3).e();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        if (i3 >= this.P.size()) {
            return null;
        }
        return this.P.get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.P.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        if (getGroupType(i3) == 0) {
            return this.P.get(i3).d();
        }
        return 1000L;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupType(int i3) {
        int size = this.P.size();
        if (i3 >= 0 && i3 < size) {
            return this.P.get(i3) instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.b ? 0 : 1;
        }
        QLog.e("GroupListAdapter", 1, "getGroupType illegal, groupPosition =" + i3 + ", size=" + size);
        return 1;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupTypeCount() {
        return 2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        SingleLineTextView singleLineTextView;
        if (getGroupType(i3) == 1) {
            if (view == null) {
                view = LayoutInflater.from(this.f211634i).inflate(QUITokenResUtil.getResId(R.layout.f167795hs, R.layout.e3y), viewGroup, false);
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
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) getGroup(i3);
            if (view != null && (view.getTag() instanceof com.tencent.mobileqq.troop.adapter.contact.a)) {
                aVar = (com.tencent.mobileqq.troop.adapter.contact.a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f211634i).inflate(QUITokenResUtil.getResId(R.layout.f167798hv, R.layout.e3z), viewGroup, false);
                aVar = new com.tencent.mobileqq.troop.adapter.contact.a();
                aVar.f293800d = (SingleLineTextView) view.findViewById(R.id.group_name);
                aVar.f293798b = (CheckBox) view.findViewById(R.id.dv_);
                SimpleTextView simpleTextView = (SimpleTextView) view.findViewById(R.id.contact_count);
                aVar.f293802f = simpleTextView;
                simpleTextView.setDefaultTextColor(1711276032);
                aVar.f293799c = (ProgressBar) view.findViewById(R.id.f165958dx0);
                aVar.f293801e = (SingleLineTextView) view.findViewById(R.id.f167055ka1);
                view.setTag(aVar);
            }
            com.tencent.mobileqq.troop.adapter.contact.a aVar2 = aVar;
            if (ThemeUtil.isNowThemeIsDefaultCache(this.f211635m, false) && !QUITokenResUtil.useQUIToken()) {
                aVar2.f293802f.setTextColor(-5196865);
            } else {
                aVar2.f293802f.setTextColor(this.f211634i.getResources().getColorStateList(QUITokenResUtil.getResId(R.color.skin_gray2_theme_version2, R.color.qui_common_text_secondary)));
            }
            view.setOnClickListener(this.M);
            view.setOnLongClickListener(this.N);
            view.setBackground(this.f211634i.getResources().getDrawable(R.drawable.jis));
            g(aVar2, bVar, i3, false, z16 ? 2 : 1);
        }
        return view;
    }

    public ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> h() {
        return this.P;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    public void i() {
        ((FPSPinnedHeaderExpandableListView) this.f187112f).hideCurShowingRightView();
        super.notifyDataSetChanged();
        if (Contacts.mStartRelationTabShowTime != 0) {
            com.tencent.relation.common.report.a.c(Contacts.RELATION_TAB_SHOWTIME, System.currentTimeMillis() - Contacts.mStartRelationTabShowTime, true, null);
            Contacts.mStartRelationTabShowTime = 0L;
        }
        if (this.L) {
            this.L = false;
            k();
            com.tencent.mobileqq.activity.contacts.friend.b bVar = this.Q;
            if (bVar != null) {
                bVar.a();
            }
        }
        com.tencent.mobileqq.activity.contacts.report.d.n("refresh_ui_time");
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        return true;
    }

    public void j() {
        l();
    }

    public void m(ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> arrayList) {
        this.P = arrayList;
    }

    public void n(com.tencent.mobileqq.activity.contacts.friend.b bVar) {
        this.Q = bVar;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public boolean needHideBackgroundGroup() {
        return true;
    }

    public void o() {
        super.notifyDataSetChanged();
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> arrayList = this.P;
        if (arrayList == null || arrayList.size() == 0) {
            com.tencent.mobileqq.activity.contacts.report.d.f181714a.i(RelationListReqType.NORMAL, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar = (com.tencent.mobileqq.troop.adapter.contact.a) view.getTag();
        if (this.f187112f.isGroupExpanded(aVar.f293797a)) {
            this.f187112f.collapseGroup(aVar.f293797a);
        } else {
            this.f187112f.expandGroup(aVar.f293797a);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return c.INSTANCE.b(view, this.I, this.f211634i, this.P, this, this.f211635m);
    }

    @Override // com.tencent.mobileqq.adapter.ai, com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        super.onScroll(absListView, i3, i16, i17);
        AbsListView.OnScrollListener onScrollListener = this.F;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
    }

    @Override // com.tencent.mobileqq.adapter.ai, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        this.E = i3;
        super.onScrollStateChanged(absListView, i3);
        if (i3 == 0) {
            oy3.a.a().c("list_g_contacts", false);
        } else {
            oy3.a.a().b("list_g_contacts");
        }
        AbsListView.OnScrollListener onScrollListener = this.F;
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

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
    public boolean supportSwip(View view) {
        if (!this.I) {
            return false;
        }
        if (!(view.getTag() instanceof BuddyListFriends.a)) {
            return true;
        }
        Object obj = ((BuddyListFriends.a) view.getTag()).f181513m;
        if (!(obj instanceof Friends)) {
            return true;
        }
        Friends friends = (Friends) obj;
        return (friends.uin.equals(this.f211635m.getCurrentAccountUin()) || Utils.G(friends.uin)) ? false : true;
    }

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
    public void interceptTouchEvent(boolean z16) {
        FrameHelperActivity.gj(!z16, "GroupListAdapter");
    }

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
    public void updateCurShowRightView(View view) {
        int i3 = -1;
        if (view != null) {
            Object tag = view.getTag(-1);
            if (tag instanceof Integer) {
                i3 = ((Integer) tag).intValue();
            }
        }
        this.H = i3;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        return QUITokenResUtil.getResId(R.layout.f167798hv, R.layout.e3z);
    }

    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener
    public void hideMenuPop() {
    }
}
