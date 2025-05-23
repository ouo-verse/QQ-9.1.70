package com.tencent.mobileqq.activity.contact.addcontact.groupsearch.guess;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.c;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends BaseListViewAdapter<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private d f181185m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.groupsearch.guess.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class ViewOnClickListenerC7151a extends RecyclerView.ViewHolder implements View.OnClickListener {
        static IPatchRedirector $redirector_;
        private final TextView E;
        private final TextView F;
        private b G;

        public ViewOnClickListenerC7151a(@NonNull View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) view);
                return;
            }
            this.E = (TextView) view.findViewById(R.id.f80964cw);
            this.F = (TextView) view.findViewById(R.id.f80944cu);
            view.setOnClickListener(this);
        }

        private void l(b bVar, int i3) {
            HashMap hashMap = new HashMap();
            hashMap.put("serial_number", Integer.valueOf(i3));
            hashMap.put("search_query_text", bVar.f181186a);
            hashMap.put("trans_info", bVar.f181191f);
            c.c(this.itemView, "em_bas_guess_you_want_search", hashMap, bVar.hashCode());
        }

        private void o() {
            b bVar = this.G;
            if (bVar != null && !TextUtils.isEmpty(bVar.f181187b) && !TextUtils.isEmpty(this.G.f181188c) && !TextUtils.isEmpty(this.G.f181189d)) {
                try {
                    int parseColor = Color.parseColor(this.G.f181188c);
                    int parseColor2 = Color.parseColor(this.G.f181189d);
                    this.F.setVisibility(0);
                    this.F.setText(this.G.f181187b);
                    this.F.setTextColor(parseColor);
                    this.F.setBackground(ad.f(parseColor2, 3, 16, 16));
                    return;
                } catch (IllegalArgumentException e16) {
                    QLog.w("GroupSearchGuessListAdapter", 1, "[setupTag] e: " + e16);
                    return;
                }
            }
            this.F.setVisibility(8);
        }

        public void m(b bVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, i3);
                return;
            }
            if (bVar != null && !TextUtils.isEmpty(bVar.f181186a)) {
                this.itemView.setVisibility(0);
                this.G = bVar;
                this.E.setText(bVar.f181186a);
                o();
                l(bVar, i3);
                return;
            }
            this.itemView.setVisibility(8);
            this.G = null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else if (view == this.itemView && a.this.f181185m != null) {
                a.this.f181185m.a(this.G.f181186a, 11);
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
            this.f181185m = dVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder, i3);
        } else if (viewHolder instanceof ViewOnClickListenerC7151a) {
            ((ViewOnClickListenerC7151a) viewHolder).m(getItem(i3), i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        return new ViewOnClickListenerC7151a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.h6g, viewGroup, false));
    }
}
