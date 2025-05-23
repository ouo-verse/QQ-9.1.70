package com.tencent.mobileqq.guild.setting.member.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.setting.member.view.o;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.config.AppConst;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j extends BaseAdapter implements CompoundButton.OnCheckedChangeListener, SwipListView.RightIconMenuListener {
    private final GPServiceObserver G;
    private o.a H;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f234723f;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f234724h;

    /* renamed from: i, reason: collision with root package name */
    private final b f234725i;

    /* renamed from: d, reason: collision with root package name */
    private final AppInterface f234721d = ch.l();

    /* renamed from: e, reason: collision with root package name */
    private boolean f234722e = false;

    /* renamed from: m, reason: collision with root package name */
    private final List<IGProUserInfo> f234726m = new ArrayList();
    private final List<c> C = new ArrayList();
    private String D = "0";
    private String E = "0";
    private boolean F = false;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onMemberTopRoleChanged(String str, String str2) {
            IGProUserInfo iGProUserInfo;
            super.onMemberTopRoleChanged(str, str2);
            if (!TextUtils.equals(j.this.D, str) || j.this.F) {
                return;
            }
            for (c cVar : j.this.C) {
                if (cVar.f234728a == 0 && (iGProUserInfo = cVar.f234733f) != null && TextUtils.equals(iGProUserInfo.getTinyId(), str2)) {
                    QLog.d("QQGuildColorMemberListAdapter", 1, "notifyDataSetChanged: onMemberTopRoleChanged, guildId: " + str + ", tinyId: " + str2);
                    j.this.F = true;
                    j.this.notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
        void a();

        void b(List<IGProUserInfo> list);

        void c();

        void d(IGProUserInfo iGProUserInfo, boolean z16);

        void e();

        void f(c cVar);

        void g(c cVar, boolean z16);
    }

    public j(boolean z16, boolean z17, b bVar) {
        a aVar = new a();
        this.G = aVar;
        this.H = new o.a() { // from class: com.tencent.mobileqq.guild.setting.member.view.i
            @Override // com.tencent.mobileqq.guild.setting.member.view.o.a
            public final void a(CompoundButton compoundButton, boolean z18) {
                j.this.onCheckedChanged(compoundButton, z18);
            }
        };
        this.f234724h = z16;
        this.f234723f = z17;
        this.f234725i = bVar;
        ((IGPSService) ch.R0(IGPSService.class)).addObserver(aVar);
    }

    private View h(int i3, View view, ViewGroup viewGroup) {
        View view2;
        o oVar;
        boolean z16;
        if (view == null) {
            oVar = new o(this.f234721d, this.f234725i, this.H);
            view2 = oVar.i(viewGroup);
        } else {
            view2 = view;
            oVar = (o) view.getTag();
        }
        oVar.f234749h = view2;
        c item = getItem(i3);
        if (item != null && item.f234733f != null) {
            Iterator<IGProUserInfo> it = this.f234726m.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getTinyId().equals(item.f234733f.getTinyId())) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            oVar.g(this.D, this.E, item, z16, this.f234722e, this.f234723f, this.f234724h);
            if (this.F && oVar.K.getVisibility() != 0) {
                QLog.i("QQGuildColorMemberListAdapter", 1, "mark hasCachedRoleInfo = false");
                this.F = false;
            }
        }
        return view2;
    }

    private View i(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ejr, (ViewGroup) null);
        }
        c item = getItem(i3);
        TextView textView = (TextView) view.findViewById(R.id.z27);
        if ((this.f234724h || this.f234723f) && j(item)) {
            textView.setText(String.format(BaseApplication.getContext().getString(R.string.f154851fx), item.f234730c, Integer.valueOf(item.f234732e)));
        } else {
            textView.setText(item.f234730c);
        }
        return view;
    }

    private boolean j(c cVar) {
        int i3 = cVar.f234734g;
        if (i3 != 4 && i3 != 2 && i3 != 5 && i3 != 7) {
            return false;
        }
        return true;
    }

    public void e(boolean z16) {
        this.f234726m.clear();
        this.f234722e = z16;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public c getItem(int i3) {
        return this.C.get(i3);
    }

    public List<IGProUserInfo> g() {
        return this.f234726m;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.C.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        c item = getItem(i3);
        if (item != null) {
            return item.f234728a;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        int itemViewType = getItemViewType(i3);
        if (itemViewType == 1) {
            view2 = i(i3, view, viewGroup);
        } else if (itemViewType == 0) {
            view2 = h(i3, view, viewGroup);
        } else if (itemViewType == 3) {
            view2 = new View(viewGroup.getContext());
            view2.setLayoutParams(new AbsListView.LayoutParams(-1, ViewUtils.dip2px(16.0f)));
            view2.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg));
        } else {
            view2 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void k() {
        ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.G);
    }

    public void l(String str, String str2, List<c> list) {
        this.D = str;
        this.E = str2;
        this.C.clear();
        this.C.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (compoundButton.isShown()) {
            IGProUserInfo iGProUserInfo = ((c) compoundButton.getTag()).f234733f;
            if (z16) {
                this.f234726m.add(iGProUserInfo);
            } else {
                this.f234726m.remove(iGProUserInfo);
            }
            this.f234725i.b(this.f234726m);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // com.tencent.widget.SwipListView.RightIconMenuListener
    public void onRightIconMenuShow(View view) {
        int i3;
        View findViewById = view.findViewById(R.id.xw_);
        if (findViewById != null) {
            VideoReport.reportEvent("clck", findViewById, new HashMap());
        }
        if (view.getTag() instanceof o) {
            o oVar = (o) view.getTag();
            if (oVar.H.isShown()) {
                HashMap hashMap = new HashMap();
                hashMap.put("sgrp_member_op_result", 3);
                VideoReport.reportEvent("imp", oVar.H, hashMap);
            }
            if (oVar.G.isShown() && findViewById != null) {
                HashMap hashMap2 = new HashMap();
                if (((c) findViewById.getTag()).c()) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                hashMap2.put("sgrp_member_op_result", Integer.valueOf(i3));
                VideoReport.reportEvent("imp", oVar.G, hashMap2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f234728a;

        /* renamed from: b, reason: collision with root package name */
        public int f234729b;

        /* renamed from: c, reason: collision with root package name */
        public String f234730c;

        /* renamed from: d, reason: collision with root package name */
        public String f234731d;

        /* renamed from: e, reason: collision with root package name */
        public int f234732e;

        /* renamed from: f, reason: collision with root package name */
        public IGProUserInfo f234733f;

        /* renamed from: g, reason: collision with root package name */
        public int f234734g;

        /* renamed from: h, reason: collision with root package name */
        public int f234735h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f234736i;

        /* renamed from: j, reason: collision with root package name */
        public eu f234737j;

        public c(int i3) {
            this.f234729b = AppConst.COMPAT_STATUS_BAR_BACKGROUND_COLOR;
            this.f234734g = 0;
            this.f234736i = false;
            this.f234728a = i3;
        }

        private String a(RoleGroupModel roleGroupModel) {
            if (roleGroupModel.w()) {
                return "\u666e\u901a\u6210\u5458";
            }
            return roleGroupModel.getName();
        }

        public static List<String> b(List<c> list) {
            ArrayList arrayList = new ArrayList();
            for (c cVar : list) {
                if (cVar.f()) {
                    arrayList.add(cVar.f234733f.getTinyId());
                }
            }
            return arrayList;
        }

        private boolean e() {
            IGProUserInfo iGProUserInfo = this.f234733f;
            if (iGProUserInfo != null && this.f234734g == 3 && iGProUserInfo.getUserType() == 1) {
                return true;
            }
            return false;
        }

        public boolean c() {
            if (this.f234734g != 2 && !e()) {
                return false;
            }
            return true;
        }

        public boolean d() {
            if (this.f234734g == 4) {
                return true;
            }
            return false;
        }

        public boolean f() {
            if (this.f234728a == 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "UserInfoItem{mType=" + this.f234728a + ", mColor=" + this.f234729b + ", mTitleName='" + cq.w(this.f234730c, 2) + "', mRoleId='" + this.f234731d + "', mMemberCount=" + this.f234732e + ", mUserInfo=" + this.f234733f + ", mRoleType=" + this.f234734g + '}';
        }

        public c(RoleGroupModel roleGroupModel, int i3) {
            this.f234729b = AppConst.COMPAT_STATUS_BAR_BACKGROUND_COLOR;
            this.f234734g = 0;
            this.f234736i = false;
            this.f234728a = 1;
            this.f234730c = a(roleGroupModel);
            this.f234731d = roleGroupModel.getId();
            this.f234732e = i3;
            this.f234734g = roleGroupModel.getRoleType();
        }

        public c(IGProUserInfo iGProUserInfo, RoleGroupModel roleGroupModel, Boolean bool, int i3) {
            this.f234729b = AppConst.COMPAT_STATUS_BAR_BACKGROUND_COLOR;
            this.f234734g = 0;
            this.f234736i = false;
            this.f234728a = 0;
            this.f234733f = iGProUserInfo;
            this.f234737j = iGProUserInfo.getPersonalMedal();
            this.f234736i = bool.booleanValue();
            this.f234734g = roleGroupModel.getRoleType();
            this.f234735h = roleGroupModel.getIconId();
            if (e()) {
                this.f234729b = i3;
            } else {
                this.f234729b = roleGroupModel.getColor();
            }
        }

        public c() {
            this.f234729b = AppConst.COMPAT_STATUS_BAR_BACKGROUND_COLOR;
            this.f234734g = 0;
            this.f234736i = false;
            this.f234728a = 0;
        }
    }

    @Override // com.tencent.widget.SwipListView.RightIconMenuListener
    public void onRightIconMenuHide(View view) {
    }
}
