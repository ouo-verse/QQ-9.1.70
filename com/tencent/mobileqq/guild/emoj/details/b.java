package com.tencent.mobileqq.guild.emoj.details;

import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.GuildEmojiDetailsData;
import com.tencent.mobileqq.guild.util.n;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static String F = "TopTabAdapter";

    /* renamed from: m, reason: collision with root package name */
    private List<c> f217899m = new ArrayList();
    private int C = 0;
    private InterfaceC7733b D = null;
    private pi1.a E = null;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f217900d;

        a(int i3) {
            this.f217900d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d(b.F, 4, "onClick onClickPosition: ", Integer.valueOf(this.f217900d));
            ((Vibrator) view.getContext().getSystemService("vibrator")).vibrate(20L);
            b.this.m0(this.f217900d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.emoj.details.b$b, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC7733b {
        void a(int i3, String str, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f217902a;

        /* renamed from: b, reason: collision with root package name */
        public int f217903b;

        /* renamed from: c, reason: collision with root package name */
        public int f217904c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d extends RecyclerView.ViewHolder {
        LinearLayout E;
        public ImageView F;
        public TextView G;

        public d(View view) {
            super(view);
            this.E = null;
            this.F = null;
            this.G = null;
            this.E = (LinearLayout) view.findViewById(R.id.b9w);
            this.F = (ImageView) view.findViewById(R.id.icon);
            this.G = (TextView) view.findViewById(R.id.f164816ty4);
        }
    }

    private String j0(int i3) {
        if (i3 > 999) {
            return "999+";
        }
        if (i3 < 0) {
            return "0";
        }
        return String.valueOf(i3);
    }

    private void o0(int i3, d dVar) {
        if (this.C == i3) {
            dVar.E.setSelected(true);
        } else {
            dVar.E.setSelected(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f217899m.size();
    }

    public List<c> k0() {
        return this.f217899m;
    }

    public List<c> l0(ArrayList<GuildEmojiDetailsData.b> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator<GuildEmojiDetailsData.b> it = arrayList.iterator();
        while (it.hasNext()) {
            GuildEmojiDetailsData.b next = it.next();
            c cVar = new c();
            cVar.f217904c = next.f216402c;
            cVar.f217903b = next.f216401b;
            arrayList2.add(cVar);
        }
        return arrayList2;
    }

    public void m0(int i3) {
        if (this.D != null) {
            c cVar = this.f217899m.get(i3);
            this.D.a(i3, cVar.f217902a, cVar.f217903b);
        }
        this.C = i3;
        notifyDataSetChanged();
    }

    public void n0(String str, int i3) {
        int i16;
        Iterator<c> it = this.f217899m.iterator();
        while (it.hasNext()) {
            c next = it.next();
            int g16 = n.g(str, i3);
            if (next.f217903b == i3 && next.f217902a.equals(String.valueOf(g16))) {
                it.remove();
            }
        }
        int size = this.f217899m.size();
        int i17 = this.C;
        if (size <= i17) {
            i16 = this.f217899m.size() - 1;
        } else if (i17 == 0) {
            i16 = 0;
        } else {
            i16 = i17 - 1;
        }
        if (i16 < 0) {
            pi1.a aVar = this.E;
            if (aVar != null) {
                aVar.Z();
                return;
            }
            return;
        }
        m0(i16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (!(viewHolder instanceof d)) {
            return;
        }
        c cVar = this.f217899m.get(i3);
        d dVar = (d) viewHolder;
        if (!TextUtils.isEmpty(cVar.f217902a)) {
            dVar.F.setImageDrawable(n.b(Integer.valueOf(cVar.f217902a).intValue(), cVar.f217903b));
        }
        dVar.G.setText(j0(cVar.f217904c));
        o0(i3, dVar);
        dVar.E.setOnClickListener(new a(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eme, viewGroup, false));
    }

    public void p0(pi1.a aVar) {
        this.E = aVar;
    }

    public void q0(InterfaceC7733b interfaceC7733b) {
        this.D = interfaceC7733b;
    }

    public void r0(List list) {
        if (list == null) {
            return;
        }
        this.f217899m.clear();
        this.f217899m.addAll(list);
        notifyDataSetChanged();
    }

    public void s0(String str, int i3, int i16) {
        int g16 = n.g(str, i3);
        if (g16 == -1) {
            return;
        }
        for (c cVar : this.f217899m) {
            if (cVar.f217902a.equals(String.valueOf(g16)) && cVar.f217903b == i3) {
                cVar.f217904c = i16;
            }
        }
        notifyDataSetChanged();
    }
}
