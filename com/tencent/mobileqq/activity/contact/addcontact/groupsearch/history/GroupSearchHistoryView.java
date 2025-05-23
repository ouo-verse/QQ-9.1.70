package com.tencent.mobileqq.activity.contact.addcontact.groupsearch.history;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.search.prompt.history.j;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.api.IGroupSearchHistoryManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;
import kn2.d;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GroupSearchHistoryView extends FrameLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private final d C;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f181192d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f181193e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f181194f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.activity.contact.addcontact.groupsearch.history.a f181195h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f181196i;

    /* renamed from: m, reason: collision with root package name */
    private List<String> f181197m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class a implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<GroupSearchHistoryView> f181198a;

        a(GroupSearchHistoryView groupSearchHistoryView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupSearchHistoryView);
            } else {
                this.f181198a = new WeakReference<>(groupSearchHistoryView);
            }
        }

        @Override // kn2.d
        public void a(@NonNull List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            GroupSearchHistoryView groupSearchHistoryView = this.f181198a.get();
            if (groupSearchHistoryView != null) {
                groupSearchHistoryView.e(list);
            }
        }
    }

    public GroupSearchHistoryView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void b(@NonNull Context context) {
        LayoutInflater.from(context).inflate(R.layout.h6j, (ViewGroup) this, true);
        this.f181192d = (RecyclerView) findViewById(R.id.ijs);
        this.f181193e = (TextView) findViewById(R.id.f81204dj);
        this.f181194f = (TextView) findViewById(R.id.f80804cg);
        this.f181193e.setOnClickListener(this);
        this.f181194f.setOnClickListener(this);
        this.f181195h = new com.tencent.mobileqq.activity.contact.addcontact.groupsearch.history.a();
        this.f181192d.setLayoutManager(new SafeLinearLayoutManager(context, 1, false));
        this.f181192d.setAdapter(this.f181195h);
        IGroupSearchHistoryManager iGroupSearchHistoryManager = (IGroupSearchHistoryManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGroupSearchHistoryManager.class, "");
        e(iGroupSearchHistoryManager.getGroupSearchHistory());
        iGroupSearchHistoryManager.register(this.C);
    }

    private void c() {
        List<String> subList;
        com.tencent.mobileqq.activity.contact.addcontact.groupsearch.history.a aVar = this.f181195h;
        if (this.f181197m.size() <= 10) {
            subList = this.f181197m;
        } else {
            subList = this.f181197m.subList(0, 10);
        }
        aVar.setDatas(subList);
    }

    private void d() {
        List<String> subList;
        com.tencent.mobileqq.activity.contact.addcontact.groupsearch.history.a aVar = this.f181195h;
        if (this.f181197m.size() <= 2) {
            subList = this.f181197m;
        } else {
            subList = this.f181197m.subList(0, 2);
        }
        aVar.setDatas(subList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<String> list) {
        this.f181197m = list;
        g();
    }

    private void f() {
        if (this.f181197m.size() <= 2) {
            this.f181193e.setVisibility(8);
            this.f181194f.setVisibility(8);
        } else {
            if (this.f181196i) {
                this.f181193e.setVisibility(8);
                this.f181194f.setVisibility(0);
                TextView textView = this.f181194f;
                c.c(textView, "em_bas_search_clear_search_record", null, textView.hashCode());
                return;
            }
            this.f181193e.setVisibility(0);
            this.f181194f.setVisibility(8);
            TextView textView2 = this.f181193e;
            c.c(textView2, "em_bas_all_search_history", null, textView2.hashCode());
        }
    }

    private void g() {
        List<String> list = this.f181197m;
        if (list != null && !list.isEmpty()) {
            setVisibility(0);
            if (this.f181196i) {
                c();
            } else {
                d();
            }
            f();
            return;
        }
        this.f181196i = false;
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            if (view == this.f181194f) {
                ((IGroupSearchHistoryManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGroupSearchHistoryManager.class, "")).clear();
                e(null);
            } else if (view == this.f181193e) {
                this.f181196i = true;
                g();
            }
            post(new j());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setOnItemClickListener(com.tencent.mobileqq.activity.contact.addcontact.groupsearch.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
            return;
        }
        com.tencent.mobileqq.activity.contact.addcontact.groupsearch.history.a aVar = this.f181195h;
        if (aVar != null) {
            aVar.j0(dVar);
        }
    }

    public GroupSearchHistoryView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public GroupSearchHistoryView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.C = new a(this);
            b(context);
        }
    }
}
