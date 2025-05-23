package com.tencent.mobileqq.selectfriend.relationlist.normal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.selectfriend.relationlist.ForwardItemView;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectfriend.relationlist.vm.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes35.dex */
public class NormalListAdapter extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private Context f285582d;

    /* renamed from: h, reason: collision with root package name */
    private b f285585h;

    /* renamed from: e, reason: collision with root package name */
    private List<SharedNode> f285583e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private boolean f285584f = false;

    /* renamed from: i, reason: collision with root package name */
    private final View.OnClickListener f285586i = new a();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof ForwardItemView) {
                NormalListAdapter.this.f285585h.e(((ForwardItemView) view).I, NormalListAdapter.this.f285584f);
            }
        }
    }

    public NormalListAdapter(Context context, b bVar) {
        this.f285582d = context;
        this.f285585h = bVar;
    }

    public void d(boolean z16) {
        this.f285585h.c(z16, new Function1<List<SharedNode>, Unit>() { // from class: com.tencent.mobileqq.selectfriend.relationlist.normal.NormalListAdapter.1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(final List<SharedNode> list) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.selectfriend.relationlist.normal.NormalListAdapter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NormalListAdapter.this.f285583e = list;
                        NormalListAdapter.this.notifyDataSetChanged();
                    }
                });
                return null;
            }
        });
    }

    public void e(boolean z16, boolean z17) {
        if (this.f285584f == z16) {
            return;
        }
        this.f285584f = z16;
        if (z17) {
            return;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f285583e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f285583e.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i3) {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (QLog.isColorLevel()) {
            QLog.d("NormalListAdapter", 2, "notifyDataSetChanged() called");
        }
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        ForwardItemView forwardItemView;
        k kVar;
        if (view == null) {
            forwardItemView = new ForwardItemView(this.f285582d);
            kVar = new k();
            forwardItemView.setTag(kVar);
        } else {
            forwardItemView = (ForwardItemView) view;
            kVar = (k) forwardItemView.getTag();
        }
        SharedNode sharedNode = (SharedNode) getItem(i3);
        kVar.f187210d = sharedNode.getKey();
        kVar.f187211e = sharedNode.getAvatarType();
        kVar.f187212f = forwardItemView.f285543i.s();
        forwardItemView.a(sharedNode, this.f285585h.a(sharedNode), this.f285584f, this.f285585h.d(sharedNode));
        forwardItemView.setOnClickListener(this.f285586i);
        return forwardItemView;
    }
}
