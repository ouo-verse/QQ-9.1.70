package com.tencent.mobileqq.activity.contacts.guild;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.activity.contacts.troop.a;
import com.tencent.mobileqq.adapter.ai;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ContactsGuildAdapter extends ai implements Handler.Callback, View.OnClickListener, ExpandableListView.OnGroupClickListener {
    private final List<com.tencent.mobileqq.activity.contacts.guild.b> C;
    private final List<com.tencent.mobileqq.activity.contacts.guild.b> D;
    private final WeakReferenceHandler E;
    private final List<com.tencent.mobileqq.activity.contacts.guild.b>[] F;
    protected HashSet<Integer> G;
    protected int[] H;
    protected int[] I;
    protected int[] J;
    private QQAppInterface K;
    private Context L;
    private int M;
    private int N;

    /* renamed from: i, reason: collision with root package name */
    private final List<com.tencent.mobileqq.activity.contacts.guild.b> f181599i;

    /* renamed from: m, reason: collision with root package name */
    private final List<com.tencent.mobileqq.activity.contacts.guild.b> f181600m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.contacts.guild.ContactsGuildAdapter$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ContactsGuildAdapter this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.K != null) {
                this.this$0.s(((IGPSService) this.this$0.K.getRuntimeService(IGPSService.class, "")).getGuildList());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f181605d;

        a(int i3) {
            this.f181605d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ContactsGuildAdapter contactsGuildAdapter = ContactsGuildAdapter.this;
            contactsGuildAdapter.H[this.f181605d] = 2;
            contactsGuildAdapter.notifyDataSetChanged();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f181607d;

        b(TextView textView) {
            this.f181607d = textView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 3) {
                        this.f181607d.setAlpha(1.0f);
                        return false;
                    }
                    return false;
                }
                this.f181607d.setAlpha(1.0f);
                return false;
            }
            this.f181607d.setAlpha(0.5f);
            return false;
        }
    }

    private View n(int i3) {
        View inflate = LayoutInflater.from(this.L).inflate(R.layout.c1m, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.f165265cj4);
        String str = HardCodeUtil.qqStr(R.string.l36) + this.J[i3] + ")";
        textView.setText(str);
        inflate.setOnClickListener(new a(i3));
        inflate.setOnTouchListener(new b(textView));
        inflate.setContentDescription(str + HardCodeUtil.qqStr(R.string.l2f));
        return inflate;
    }

    private boolean p(int i3, int i16) {
        if (i3 > 0) {
            int[] iArr = this.I;
            if (i3 < iArr.length && i16 > iArr[i3]) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void r(IGProGuildInfo iGProGuildInfo) {
        int i3;
        if (iGProGuildInfo == null) {
            QLog.e("ContactsGuildAdapter", 1, "onClickForGuildInfo guildInfo is null");
            return;
        }
        if (this.K == null) {
            QLog.e("ContactsGuildAdapter", 1, "onClickForGuildInfo app is null");
            return;
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildInTab(this.L, iGProGuildInfo.getGuildID(), "", null);
        if (iGProGuildInfo.getUserType() == 2) {
            i3 = 1;
        } else if (iGProGuildInfo.getUserType() == 1) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        new q(this.K).i("dc00899").a("Sgrp_mber").f("mber_list_page").d("clk").b(iGProGuildInfo.getShowNumber(), String.valueOf(i3)).g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(List<IGProGuildInfo> list) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        if (list != null) {
            for (IGProGuildInfo iGProGuildInfo : list) {
                if (QLog.isColorLevel()) {
                    QLog.d("ContactsGuildAdapter", 2, "guildInfo:", iGProGuildInfo);
                }
                com.tencent.mobileqq.activity.contacts.guild.b bVar = new com.tencent.mobileqq.activity.contacts.guild.b(iGProGuildInfo);
                if (iGProGuildInfo.isTop()) {
                    arrayList.add(bVar);
                }
                if (iGProGuildInfo.getUserType() == 2) {
                    arrayList4.add(bVar);
                } else if (iGProGuildInfo.getUserType() == 1) {
                    arrayList3.add(bVar);
                } else if (iGProGuildInfo.getUserType() == 0) {
                    arrayList2.add(bVar);
                }
                RecentUser findRecentUserByUin = this.K.getRecentUserProxy().findRecentUserByUin(iGProGuildInfo.getGuildID(), 10014);
                if (findRecentUserByUin != null) {
                    long j3 = findRecentUserByUin.lastmsgtime;
                    if (j3 > 0) {
                        bVar.f181610b = j3;
                    }
                }
                bVar.f181611c = ChnToSpell.d(iGProGuildInfo.getGuildName(), 2);
            }
            com.tencent.mobileqq.activity.contacts.guild.a aVar = new com.tencent.mobileqq.activity.contacts.guild.a();
            Collections.sort(arrayList, aVar);
            Collections.sort(arrayList2, aVar);
            Collections.sort(arrayList4, aVar);
            Collections.sort(arrayList3, aVar);
        }
        this.E.post(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.guild.ContactsGuildAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                ContactsGuildAdapter.this.f181599i.clear();
                ContactsGuildAdapter.this.f181599i.addAll(arrayList);
                ContactsGuildAdapter.this.D.clear();
                ContactsGuildAdapter.this.D.addAll(arrayList2);
                ContactsGuildAdapter.this.C.clear();
                ContactsGuildAdapter.this.C.addAll(arrayList3);
                ContactsGuildAdapter.this.f181600m.clear();
                ContactsGuildAdapter.this.f181600m.addAll(arrayList4);
                ContactsGuildAdapter.this.notifyDataSetChanged();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void t(int i3) {
        int i16;
        int i17 = 0;
        if (i3 >= 0) {
            List<com.tencent.mobileqq.activity.contacts.guild.b>[] listArr = this.F;
            if (i3 < listArr.length) {
                int size = listArr[i3].size();
                if (i3 != 0) {
                    if (i3 == 1 || i3 == 2 || i3 == 3) {
                        i17 = l(this.F[i3]);
                    }
                } else {
                    this.H[i3] = 3;
                }
                i16 = i17;
                i17 = size;
                if (i17 > 10) {
                    this.H[i3] = 3;
                } else {
                    int[] iArr = this.H;
                    if (iArr[i3] == 0) {
                        iArr[i3] = 1;
                    }
                }
                if (i17 > 10) {
                    i16 = i17;
                } else if (i16 < 10) {
                    i16 = 10;
                }
                this.I[i3] = i16;
                this.J[i3] = i17 - i16;
            }
        }
        i16 = 0;
        if (i17 > 10) {
        }
        if (i17 > 10) {
        }
        this.I[i3] = i16;
        this.J[i3] = i17 - i16;
    }

    private void u(IGProGuildInfo iGProGuildInfo, a.C7160a c7160a, int i3, int i16, View view) {
        if (iGProGuildInfo == null) {
            return;
        }
        c7160a.f187114d = iGProGuildInfo.getGuildID();
        c7160a.f181513m = iGProGuildInfo;
        c7160a.f187115e = 4;
        c7160a.J = p(i3, i16);
        c7160a.F.setVisibility(8);
        c7160a.D.setText(iGProGuildInfo.getGuildName());
        if (AppSetting.f99565y) {
            c7160a.leftView.setContentDescription(c7160a.D.getText());
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        URLDrawable drawable = URLDrawable.getDrawable(iGProGuildInfo.getAvatarUrl(0), obtain);
        int f16 = BaseAIOUtils.f(56.0f, c7160a.f187116f.getResources());
        drawable.setTag(new int[]{f16, f16});
        drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306323c);
        c7160a.f187116f.setImageDrawable(drawable);
        view.setOnClickListener(this);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        return i16;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        a.C7160a c7160a;
        if (i16 == getChildrenCount(i3) - 1 && this.H[i3] == 1) {
            return n(i3);
        }
        if (view != null && (view.getTag() instanceof a.C7160a)) {
            c7160a = (a.C7160a) view.getTag();
        } else {
            view = LayoutInflater.from(this.L).inflate(R.layout.c1n, (ViewGroup) null);
            view.setMinimumHeight(this.M);
            c7160a = new a.C7160a();
            c7160a.leftView = view;
            c7160a.D = (TextView) view.findViewById(R.id.text1);
            c7160a.E = (TextView) view.findViewById(R.id.text2);
            QQProAvatarView qQProAvatarView = (QQProAvatarView) view.findViewById(R.id.icon);
            c7160a.f187116f = qQProAvatarView;
            qQProAvatarView.setEnableMask(false);
            c7160a.G = (ImageView) view.findViewById(R.id.enc);
            c7160a.F = (ImageView) view.findViewById(R.id.j1v);
            c7160a.H = (TextView) view.findViewById(R.id.f166334f21);
            c7160a.I = (ImageView) view.findViewById(R.id.jxg);
            c7160a.D.setTextColor(view.getResources().getColorStateList(R.color.skin_black_theme_version2));
            view.setTag(c7160a);
        }
        a.C7160a c7160a2 = c7160a;
        c7160a2.C = i3;
        com.tencent.mobileqq.activity.contacts.guild.b child = getChild(i3, i16);
        if (child != null) {
            u(child.f181609a, c7160a2, i3, i16, view);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        int i16;
        if (i3 >= 0) {
            List<com.tencent.mobileqq.activity.contacts.guild.b>[] listArr = this.F;
            if (i3 < listArr.length) {
                int size = listArr[i3].size();
                if (i3 == 0) {
                    size = this.F[i3].size();
                    this.H[i3] = 3;
                }
                if (this.H[i3] == 1 && (i16 = this.I[i3]) < size) {
                    size = i16 + 1;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ContactsGuildAdapter", 2, "getChildrenCount count:" + size + "  groupPosition:" + i3);
                }
                return size;
            }
            return 0;
        }
        return 0;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        List<com.tencent.mobileqq.activity.contacts.guild.b>[] listArr = this.F;
        if (i3 < listArr.length) {
            return listArr[i3];
        }
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return 4;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        return i3;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.L).inflate(R.layout.f167798hv, viewGroup, false);
            aVar = new com.tencent.mobileqq.troop.adapter.contact.a();
            SingleLineTextView singleLineTextView = (SingleLineTextView) view.findViewById(R.id.group_name);
            aVar.f293800d = singleLineTextView;
            singleLineTextView.setDefaultTextColor(-8355712);
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
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.N));
        if (ThemeUtil.isNowThemeIsDefaultCache(this.K, false)) {
            aVar.f293802f.setTextColor(-5196865);
        } else {
            aVar.f293802f.setTextColor(this.L.getResources().getColorStateList(R.color.skin_gray2_theme_version2));
        }
        k(aVar, i3, z16);
        view.setOnClickListener(this);
        return view;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        return 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 255) {
            notifyDataSetChanged();
            return false;
        }
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void k(com.tencent.mobileqq.troop.adapter.contact.a aVar, int i3, boolean z16) {
        String str;
        int i16;
        int i17;
        String str2;
        if (aVar != null) {
            int size = this.F[i3].size();
            if (i3 >= 0 && i3 < this.F.length) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                str = this.L.getResources().getString(R.string.f142670k0);
                                i16 = l(this.F[i3]);
                            }
                        } else {
                            str = this.L.getResources().getString(R.string.f142680k1);
                            i16 = l(this.F[i3]);
                        }
                    } else {
                        str = this.L.getResources().getString(R.string.f142660jz);
                        i16 = l(this.F[i3]);
                    }
                    if (size <= 10) {
                        i17 = size;
                    } else if (i16 < 10) {
                        i17 = 10;
                    } else {
                        i17 = i16;
                    }
                    if (size <= 10) {
                        this.H[i3] = 3;
                    } else {
                        int[] iArr = this.H;
                        if (iArr[i3] == 0) {
                            iArr[i3] = 1;
                            notifyDataSetChanged();
                        }
                    }
                    if (size == i16) {
                        this.H[i3] = 2;
                    }
                    this.I[i3] = i17;
                    this.J[i3] = size - i17;
                    if (this.H[i3] == 1) {
                        str2 = i17 + "/" + size;
                    } else {
                        str2 = "" + size;
                    }
                    StringBuilder sb5 = aVar.f293803g;
                    if (AppSetting.f99565y) {
                        if (sb5 == null) {
                            sb5 = new StringBuilder(24);
                        } else {
                            sb5.delete(0, sb5.length());
                        }
                        sb5.append(str + " \u5206\u7ec4");
                    }
                    aVar.f293797a = i3;
                    aVar.f293800d.setText(str);
                    aVar.f293801e.setVisibility(8);
                    aVar.f293799c.setVisibility(8);
                    aVar.f293798b.setVisibility(0);
                    aVar.f293802f.setText(str2);
                    if (AppSetting.f99565y) {
                        sb5.append("\u5171" + size + "\u4e2a" + str);
                    }
                    aVar.f293798b.setChecked(z16);
                    if (AppSetting.f99565y) {
                        if (aVar.f293798b.isChecked()) {
                            sb5.append(" \u5df2\u5c55\u5f00");
                        } else {
                            sb5.append(" \u5df2\u6298\u53e0");
                        }
                        aVar.f293802f.setContentDescription(sb5.toString());
                        AccessibilityUtil.n(aVar.f293798b, false);
                        return;
                    }
                    return;
                }
                str = this.L.getResources().getString(R.string.f142690k2);
                this.H[i3] = 3;
                i16 = 0;
                if (size <= 10) {
                }
                if (size <= 10) {
                }
                if (size == i16) {
                }
                this.I[i3] = i17;
                this.J[i3] = size - i17;
                if (this.H[i3] == 1) {
                }
                StringBuilder sb52 = aVar.f293803g;
                if (AppSetting.f99565y) {
                }
                aVar.f293797a = i3;
                aVar.f293800d.setText(str);
                aVar.f293801e.setVisibility(8);
                aVar.f293799c.setVisibility(8);
                aVar.f293798b.setVisibility(0);
                aVar.f293802f.setText(str2);
                if (AppSetting.f99565y) {
                }
                aVar.f293798b.setChecked(z16);
                if (AppSetting.f99565y) {
                }
            }
            str = "";
            i16 = 0;
            if (size <= 10) {
            }
            if (size <= 10) {
            }
            if (size == i16) {
            }
            this.I[i3] = i17;
            this.J[i3] = size - i17;
            if (this.H[i3] == 1) {
            }
            StringBuilder sb522 = aVar.f293803g;
            if (AppSetting.f99565y) {
            }
            aVar.f293797a = i3;
            aVar.f293800d.setText(str);
            aVar.f293801e.setVisibility(8);
            aVar.f293799c.setVisibility(8);
            aVar.f293798b.setVisibility(0);
            aVar.f293802f.setText(str2);
            if (AppSetting.f99565y) {
            }
            aVar.f293798b.setChecked(z16);
            if (AppSetting.f99565y) {
            }
        }
    }

    protected int l(List<com.tencent.mobileqq.activity.contacts.guild.b> list) {
        int i3 = 0;
        if (this.K == null) {
            return 0;
        }
        for (com.tencent.mobileqq.activity.contacts.guild.b bVar : list) {
            if (bVar != null && bVar.f181610b > 0) {
                i3++;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactsGuildAdapter", 2, "getActiveTroopCount activeTroopCount:" + i3);
        }
        return i3;
    }

    @Override // android.widget.ExpandableListAdapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.activity.contacts.guild.b getChild(int i3, int i16) {
        List<com.tencent.mobileqq.activity.contacts.guild.b> list;
        List<com.tencent.mobileqq.activity.contacts.guild.b>[] listArr = this.F;
        if (i3 >= listArr.length || (list = listArr[i3]) == null || list.size() <= i16) {
            return null;
        }
        return list.get(i16);
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public boolean needHideBackgroundGroup() {
        return true;
    }

    protected void o(com.tencent.mobileqq.troop.adapter.contact.a aVar) {
        int i3;
        int i16 = 0;
        if (this.F.length == 1) {
            i3 = 0;
        } else {
            i3 = aVar.f293797a;
        }
        if (this.f187112f.isGroupExpanded(i3)) {
            this.f187112f.collapseGroup(i3);
            this.G.remove(Integer.valueOf(i3));
        } else {
            for (int i17 = 0; i17 < this.F.length; i17++) {
                if (this.f187112f.isGroupExpanded(i17)) {
                    this.f187112f.collapseGroup(i17);
                    this.G.remove(Integer.valueOf(i17));
                }
            }
            this.f187112f.expandGroup(i3);
            this.G.add(Integer.valueOf(i3));
        }
        while (true) {
            int[] iArr = this.H;
            if (i16 < iArr.length) {
                if (iArr[i16] == 2) {
                    iArr[i16] = 1;
                }
                i16++;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag();
        if (tag instanceof com.tencent.mobileqq.troop.adapter.contact.a) {
            q((com.tencent.mobileqq.troop.adapter.contact.a) tag);
        } else if (tag instanceof a.C7160a) {
            r((IGProGuildInfo) ((a.C7160a) tag).f181513m);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j3) {
        Object tag = view.getTag();
        if (tag instanceof com.tencent.mobileqq.troop.adapter.contact.a) {
            o((com.tencent.mobileqq.troop.adapter.contact.a) tag);
            return true;
        }
        if (tag instanceof a.C7160a) {
            r((IGProGuildInfo) ((a.C7160a) tag).f181513m);
            return true;
        }
        return true;
    }

    protected void q(com.tencent.mobileqq.troop.adapter.contact.a aVar) {
        o(aVar);
        t(aVar.f293797a);
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
    }
}
