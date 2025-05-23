package com.tencent.open.agent;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class GroupListOpenFrame extends OpenFrame {
    protected XListView E;
    protected RecommendListManager F;
    protected TextView G;
    protected TextView H;
    protected EditText I;
    protected b J;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                GroupListOpenFrame.this.f339903i.I2();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    protected class b extends gp3.a {

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f339840d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f339841e;

            a(int i3, String str) {
                this.f339840d = i3;
                this.f339841e = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Bundle bundle = new Bundle();
                bundle.putInt("group_index", this.f339840d);
                bundle.putString("group_name", this.f339841e);
                GroupListOpenFrame.this.f339904m.j(1, bundle);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.open.agent.GroupListOpenFrame$b$b, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        protected class C9261b {

            /* renamed from: a, reason: collision with root package name */
            public TextView f339843a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f339844b;

            /* renamed from: c, reason: collision with root package name */
            public RelativeLayout f339845c;

            protected C9261b() {
            }
        }

        protected b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return GroupListOpenFrame.this.f339902h.f();
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            C9261b c9261b;
            if (view == null) {
                c9261b = new C9261b();
                GroupListOpenFrame groupListOpenFrame = GroupListOpenFrame.this;
                View inflate = groupListOpenFrame.D.inflate(R.layout.f168468wz, (ViewGroup) groupListOpenFrame.E, false);
                c9261b.f339843a = (TextView) inflate.findViewById(R.id.aek);
                c9261b.f339844b = (TextView) inflate.findViewById(R.id.cxo);
                c9261b.f339845c = (RelativeLayout) inflate.findViewById(R.id.cxn);
                inflate.setTag(c9261b);
                view2 = inflate;
            } else {
                view2 = view;
                c9261b = (C9261b) view.getTag();
            }
            String e16 = GroupListOpenFrame.this.f339902h.e(i3);
            c9261b.f339843a.setText(e16);
            c9261b.f339844b.setText(String.valueOf(GroupListOpenFrame.this.f339902h.c(i3)));
            int i16 = (int) (GroupListOpenFrame.this.f339903i.D0 * 10.0f);
            if (i3 == 0) {
                c9261b.f339845c.setBackgroundResource(R.drawable.common_strip_setting_top);
            } else if (i3 == getCount() - 1) {
                c9261b.f339845c.setBackgroundResource(R.drawable.common_strip_setting_bottom);
            } else {
                c9261b.f339845c.setBackgroundResource(R.drawable.common_strip_setting_middle);
            }
            c9261b.f339845c.setPadding(i16, 0, i16, 0);
            c9261b.f339845c.setOnClickListener(new a(i3, e16));
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }
    }

    public GroupListOpenFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.open.agent.OpenFrame, com.tencent.common.app.InnerFrame
    public void j(Bundle bundle) {
        super.j(bundle);
        com.tencent.open.base.f.a("GroupListOpenFrame", "-->onCreate()");
        super.setContentView(R.layout.byn);
        this.J = new b();
        this.E = (XListView) super.findViewById(R.id.f167137l64);
        LinearLayout linearLayout = (LinearLayout) super.e().getLayoutInflater().inflate(R.layout.f168467wy, (ViewGroup) null);
        linearLayout.findViewById(R.id.btn_cancel_search).setVisibility(8);
        this.G = (TextView) linearLayout.findViewById(R.id.jjd);
        this.H = (TextView) linearLayout.findViewById(R.id.jje);
        RecommendListManager recommendListManager = (RecommendListManager) linearLayout.findViewById(R.id.iya);
        this.F = recommendListManager;
        recommendListManager.setActivity(this.f339903i);
        this.F.b();
        this.E.setSelector(R.color.ajr);
        this.E.addHeaderView(linearLayout);
        this.E.setAdapter((ListAdapter) this.J);
        EditText editText = (EditText) linearLayout.findViewById(R.id.et_search_keyword);
        this.I = editText;
        editText.setOnTouchListener(new a());
    }

    @Override // com.tencent.common.app.InnerFrame
    public void l() {
        this.F.a();
        com.tencent.open.base.f.a("GroupListOpenFrame", "-->onResume()");
        super.l();
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        super.m(bundle);
        com.tencent.open.base.f.a("GroupListOpenFrame", "-->onStart()");
        FriendChooser friendChooser = this.f339903i;
        friendChooser.L2(false, true, "", friendChooser.getString(R.string.a5c));
    }

    @Override // com.tencent.open.agent.OpenFrame
    public void o() {
        if (this.f339902h.h() == 0) {
            this.G.setVisibility(8);
            this.F.setVisibility(8);
        } else {
            this.G.setVisibility(0);
            this.F.setVisibility(0);
            this.F.a();
        }
        this.J.notifyDataSetChanged();
    }

    public void p(String str) {
        this.H.setText(str);
    }
}
