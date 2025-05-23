package com.tencent.aelight.camera.ae.camera.ui.poi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends RecyclerView.Adapter<b> {

    /* renamed from: d, reason: collision with root package name */
    private LayoutInflater f63248d;

    /* renamed from: e, reason: collision with root package name */
    private Context f63249e;

    /* renamed from: f, reason: collision with root package name */
    private c f63250f;

    /* renamed from: h, reason: collision with root package name */
    private d f63251h;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<c> f63252i = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.poi.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class ViewOnClickListenerC0546a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f63253d;

        ViewOnClickListenerC0546a(int i3) {
            this.f63253d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            a aVar = a.this;
            aVar.f63250f = aVar.f63252i.get(this.f63253d);
            if (a.this.f63250f != null) {
                str = a.this.f63250f.f63260a;
            } else {
                str = "";
            }
            if (a.this.f63251h != null) {
                a.this.f63251h.a(str);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        private Context f63255d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f63256e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f63257f;

        /* renamed from: h, reason: collision with root package name */
        public View f63258h;

        public b(View view, Context context) {
            super(view);
            this.f63255d = context;
            this.f63257f = (ImageView) view.findViewById(R.id.rwd);
            this.f63256e = (TextView) view.findViewById(R.id.rwe);
            this.f63258h = view.findViewById(R.id.f163769rx1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        String f63260a;

        /* renamed from: b, reason: collision with root package name */
        int f63261b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, int i3) {
            this.f63260a = str;
            this.f63261b = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    interface d {
        void a(String str);
    }

    public a(Context context) {
        this.f63248d = LayoutInflater.from(context);
        this.f63249e = context;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<c> arrayList = this.f63252i;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return super.getItemId(i3);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i3) {
        bVar.f63256e.setVisibility(0);
        bVar.f63257f.setVisibility(0);
        int i16 = this.f63252i.get(i3).f63261b;
        bVar.f63256e.setText(this.f63252i.get(i3).f63260a);
        bVar.f63258h.setOnClickListener(new ViewOnClickListenerC0546a(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new b(this.f63248d.inflate(R.layout.dla, viewGroup, false), this.f63249e);
    }

    public void u(d dVar) {
        this.f63251h = dVar;
    }

    public void v(List<c> list) {
        this.f63252i.clear();
        this.f63252i.addAll(list);
        notifyDataSetChanged();
    }
}
