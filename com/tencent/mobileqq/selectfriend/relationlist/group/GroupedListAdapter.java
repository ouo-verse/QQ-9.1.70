package com.tencent.mobileqq.selectfriend.relationlist.group;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.selectfriend.relationlist.ForwardItemView;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectfriend.relationlist.d;
import com.tencent.mobileqq.selectfriend.relationlist.e;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes35.dex */
public class GroupedListAdapter extends PinnedHeaderExpandableListView.ExpandableListAdapter implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name */
    protected Context f285570e;

    /* renamed from: f, reason: collision with root package name */
    protected float f285571f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f285572h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.selectfriend.relationlist.vm.b f285573i;

    /* renamed from: m, reason: collision with root package name */
    protected ExpandableListView f285574m;

    /* renamed from: d, reason: collision with root package name */
    protected List<d> f285569d = new ArrayList();
    protected View.OnClickListener C = new a();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof ForwardItemView) {
                GroupedListAdapter.this.f285573i.e(((ForwardItemView) view).I, GroupedListAdapter.this.f285572h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public TextView f285578a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f285579b;

        /* renamed from: c, reason: collision with root package name */
        public int f285580c;

        /* renamed from: d, reason: collision with root package name */
        public CheckBox f285581d;

        protected b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class c extends k {
    }

    public GroupedListAdapter(Context context, ExpandableListView expandableListView, boolean z16, com.tencent.mobileqq.selectfriend.relationlist.vm.b bVar) {
        this.f285574m = null;
        this.f285574m = expandableListView;
        this.f285570e = context;
        this.f285572h = z16;
        this.f285571f = context.getResources().getDisplayMetrics().density;
        this.f285573i = bVar;
    }

    private void c(b bVar, int i3) {
        bVar.f285581d.setVisibility(0);
        if (i3 == 0) {
            i3 = this.f285574m.isGroupExpanded(bVar.f285580c) ? 2 : 1;
        }
        bVar.f285581d.setChecked(i3 == 2);
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View view, int i3) {
        b bVar = (b) view.getTag();
        if (bVar == null) {
            bVar = new b();
            bVar.f285578a = (TextView) view.findViewById(R.id.group_name);
            bVar.f285579b = (TextView) view.findViewById(R.id.contact_count);
            view.findViewById(R.id.dv_).setVisibility(0);
            view.setTag(bVar);
        }
        d dVar = (d) getGroup(i3);
        bVar.f285578a.setText(dVar.a());
        bVar.f285579b.setText(dVar.b());
        ((CheckBox) view.findViewById(R.id.dv_)).setChecked(this.f285574m.isGroupExpanded(i3));
    }

    public List<SharedNode> d(int i3) {
        return ((d) getGroup(i3)).c();
    }

    public void e(boolean z16) {
        this.f285573i.b(z16, new Function1<List<d>, Unit>() { // from class: com.tencent.mobileqq.selectfriend.relationlist.group.GroupedListAdapter.1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List<d> list) {
                if (list == null) {
                    GroupedListAdapter.this.f285569d = new ArrayList();
                } else {
                    GroupedListAdapter.this.f285569d = list;
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.selectfriend.relationlist.group.GroupedListAdapter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GroupedListAdapter.this.notifyDataSetChanged();
                    }
                });
                return null;
            }
        });
    }

    public void f(boolean z16, boolean z17) {
        if (this.f285572h == z16) {
            return;
        }
        this.f285572h = z16;
        if (z17) {
            return;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        return d(i3).get(i16);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        return 0L;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        ForwardItemView forwardItemView;
        c cVar;
        if (view == null) {
            forwardItemView = new ForwardItemView(this.f285570e);
            cVar = new c();
            forwardItemView.setTag(cVar);
        } else {
            forwardItemView = (ForwardItemView) view;
            cVar = (c) forwardItemView.getTag();
        }
        Object child = getChild(i3, i16);
        if (!(child instanceof SharedNode)) {
            return forwardItemView;
        }
        SharedNode sharedNode = (SharedNode) child;
        cVar.f187210d = sharedNode.getKey();
        forwardItemView.a(sharedNode, this.f285573i.a(sharedNode), this.f285572h, e.f285562a.g(sharedNode));
        forwardItemView.setOnClickListener(this.C);
        return forwardItemView;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        if (d(i3) == null) {
            return 0;
        }
        return d(i3).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        return this.f285569d.get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f285569d.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        return 0L;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        return R.layout.f167797hu;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        return true;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public boolean isEmpty() {
        return this.f285569d == null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = (b) view.getTag();
        if (this.f285574m.isGroupExpanded(bVar.f285580c)) {
            this.f285574m.collapseGroup(bVar.f285580c);
        } else {
            this.f285574m.expandGroup(bVar.f285580c);
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        b bVar;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.f285570e).inflate(R.layout.f167797hu, viewGroup, false);
            bVar = new b();
            bVar.f285578a = (TextView) view.findViewById(R.id.group_name);
            bVar.f285579b = (TextView) view.findViewById(R.id.contact_count);
            bVar.f285581d = (CheckBox) view.findViewById(R.id.dv_);
            view.setTag(bVar);
            view.setOnClickListener(this);
        } else {
            bVar = (b) view.getTag();
        }
        d dVar = (d) getGroup(i3);
        bVar.f285578a.setText(dVar.a());
        bVar.f285579b.setText(dVar.b());
        bVar.f285580c = i3;
        c(bVar, z16 ? 2 : 1);
        if (AppSetting.f99565y) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(dVar.a());
            sb5.append("\uff0c\uff0c");
            if (bVar.f285581d.isChecked()) {
                str = "\u5df2\u5c55\u5f00";
            } else {
                str = "\u5df2\u6298\u53e0";
            }
            sb5.append(str);
            AccessibilityUtil.c(view, sb5.toString(), null);
            bVar.f285581d.setImportantForAccessibility(2);
        }
        return view;
    }
}
