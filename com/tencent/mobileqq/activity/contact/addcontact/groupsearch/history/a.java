package com.tencent.mobileqq.activity.contact.addcontact.groupsearch.history;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.c;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.api.IGroupSearchHistoryManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends BaseListViewAdapter<String> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private d f181199m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.groupsearch.history.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class ViewOnClickListenerC7152a extends RecyclerView.ViewHolder implements View.OnClickListener {
        static IPatchRedirector $redirector_;
        private final TextView E;
        private final ImageView F;
        String G;

        public ViewOnClickListenerC7152a(@NonNull View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) view);
                return;
            }
            this.E = (TextView) view.findViewById(R.id.f81014d1);
            ImageView imageView = (ImageView) view.findViewById(R.id.f80994cz);
            this.F = imageView;
            view.setOnClickListener(this);
            imageView.setOnClickListener(this);
        }

        private void l(String str, int i3) {
            HashMap hashMap = new HashMap();
            hashMap.put("serial_number", Integer.valueOf(i3));
            hashMap.put("search_query", str);
            c.c(this.itemView, "em_bas_search_history_terms", hashMap, str.hashCode());
            c.c(this.F, "em_bas_search_history_delete_button", hashMap, str.hashCode());
        }

        public void m(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                this.itemView.setVisibility(8);
                this.G = null;
            } else {
                this.itemView.setVisibility(0);
                this.G = str;
                this.E.setText(str);
                l(str, i3);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else if (view == this.F) {
                ((IGroupSearchHistoryManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGroupSearchHistoryManager.class, "")).delete(this.G);
            } else if (view == this.itemView && a.this.f181199m != null) {
                a.this.f181199m.a(this.G, 10);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void j0(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
        } else {
            this.f181199m = dVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder, i3);
        } else if (viewHolder instanceof ViewOnClickListenerC7152a) {
            ((ViewOnClickListenerC7152a) viewHolder).m(getItem(i3), i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        return new ViewOnClickListenerC7152a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.h6i, viewGroup, false));
    }
}
