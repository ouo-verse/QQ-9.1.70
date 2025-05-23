package com.tencent.mobileqq.guild.setting.member.oldmemberlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.lifecycle.Observer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends BaseAdapter implements SwipListView.RightIconMenuListener {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<a02.a> f234640d;

    /* renamed from: e, reason: collision with root package name */
    private final List<C7903a> f234641e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final QQGuildMemberListViewModel f234642f;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.mobileqq.guild.setting.member.view.b f234643h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.setting.member.oldmemberlist.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C7903a {

        /* renamed from: a, reason: collision with root package name */
        public int f234644a;

        /* renamed from: b, reason: collision with root package name */
        public IGProUserInfo f234645b;
    }

    public a(a02.a aVar, QQGuildMemberListViewModel qQGuildMemberListViewModel, com.tencent.mobileqq.guild.setting.member.view.b bVar) {
        this.f234642f = qQGuildMemberListViewModel;
        this.f234643h = bVar;
        this.f234640d = new WeakReference<>(aVar);
        qQGuildMemberListViewModel.U1().observe(aVar.getViewLifecycleOwner(), new Observer() { // from class: b02.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                com.tencent.mobileqq.guild.setting.member.oldmemberlist.a.this.h((List) obj);
            }
        });
        qQGuildMemberListViewModel.a2().observe(aVar.getViewLifecycleOwner(), new Observer() { // from class: b02.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                com.tencent.mobileqq.guild.setting.member.oldmemberlist.a.this.i((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(List list) {
        m(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(List list) {
        n(list);
        notifyDataSetChanged();
    }

    private void l(IGProUserInfo iGProUserInfo) {
        for (int i3 = 0; i3 < this.f234641e.size(); i3++) {
            C7903a c7903a = this.f234641e.get(i3);
            if (iGProUserInfo.getTinyId().equals(c7903a.f234645b.getTinyId())) {
                this.f234641e.remove(c7903a);
                return;
            }
        }
    }

    private void m(List<IGProUserInfo> list) {
        Iterator<IGProUserInfo> it = list.iterator();
        while (it.hasNext()) {
            l(it.next());
        }
    }

    private void n(List<IGProUserInfo> list) {
        for (IGProUserInfo iGProUserInfo : list) {
            for (C7903a c7903a : this.f234641e) {
                if (iGProUserInfo.getTinyId().equals(c7903a.f234645b.getTinyId())) {
                    c7903a.f234645b = iGProUserInfo;
                }
            }
        }
    }

    public void c(List<IGProUserInfo> list) {
        for (IGProUserInfo iGProUserInfo : list) {
            C7903a c7903a = new C7903a();
            c7903a.f234645b = iGProUserInfo;
            c7903a.f234644a = 0;
            this.f234641e.add(c7903a);
        }
    }

    public QBaseActivity d() {
        if (this.f234640d.get() == null) {
            return null;
        }
        return this.f234640d.get().getHostActivity();
    }

    public AppInterface e() {
        if (this.f234640d.get() == null) {
            return null;
        }
        return this.f234640d.get().getAppInterface();
    }

    @Override // android.widget.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C7903a getItem(int i3) {
        if (this.f234641e.size() > i3) {
            return this.f234641e.get(i3);
        }
        return null;
    }

    public QQGuildMemberListViewModel g() {
        return this.f234642f;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f234641e.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b(this);
            view2 = bVar.d(viewGroup);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        bVar.f234647e = view2;
        C7903a item = getItem(i3);
        if (item != null && item.f234645b != null) {
            bVar.b(i3, this.f234642f.getGuildInfo().getGuildID(), item, false);
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void j(List<IGProUserInfo> list) {
        if (this.f234640d.get() == null) {
            return;
        }
        this.f234640d.get().U3(list);
    }

    public void k(IGProUserInfo iGProUserInfo, boolean z16) {
        if (d() != null) {
            this.f234643h.a(d(), iGProUserInfo, z16);
        }
    }

    public void o(IGProUserInfo iGProUserInfo) {
        this.f234642f.a2().setValue(Collections.singletonList(iGProUserInfo));
    }

    @Override // com.tencent.widget.SwipListView.RightIconMenuListener
    public void onRightIconMenuShow(View view) {
        View findViewById = view.findViewById(R.id.xw_);
        int i3 = 1;
        if (findViewById == null) {
            QLog.w("Guild.userl.QQGuildMemberListAdapter", 1, "onRightIconMenuShow but manageView is null");
            return;
        }
        VideoReport.reportEvent("clck", findViewById, new HashMap());
        if (view.getTag() instanceof b) {
            b bVar = (b) view.getTag();
            if (bVar.D.isShown()) {
                HashMap hashMap = new HashMap();
                hashMap.put("sgrp_member_op_result", 3);
                VideoReport.reportEvent("imp", bVar.D, hashMap);
            }
            if (bVar.C.isShown()) {
                HashMap hashMap2 = new HashMap();
                if (((C7903a) findViewById.getTag()).f234645b.getUserType() == 1) {
                    i3 = 2;
                }
                hashMap2.put("sgrp_member_op_result", Integer.valueOf(i3));
                VideoReport.reportEvent("imp", bVar.C, hashMap2);
            }
        }
    }

    public void setData(List<IGProUserInfo> list) {
        this.f234641e.clear();
        c(list);
        notifyDataSetChanged();
    }

    @Override // com.tencent.widget.SwipListView.RightIconMenuListener
    public void onRightIconMenuHide(View view) {
    }
}
