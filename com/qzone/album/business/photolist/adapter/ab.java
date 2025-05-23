package com.qzone.album.business.photolist.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ab extends RecyclerView.Adapter<b> implements View.OnClickListener {
    private List<a> C;
    private v D;

    /* renamed from: m, reason: collision with root package name */
    private Context f42667m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends RecyclerView.ViewHolder {
        LinearLayout E;
        AsyncImageView F;
        TextView G;
        View H;

        public b(View view) {
            super(view);
            this.E = (LinearLayout) view.findViewById(R.id.dq8);
            this.F = (AsyncImageView) view.findViewById(R.id.icon);
            this.G = (TextView) view.findViewById(R.id.title);
            this.H = view.findViewById(R.id.f165961y81);
        }
    }

    public ab(Context context) {
        this.f42667m = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<a> list = this.C;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public a i0(int i3) {
        List<a> list = this.C;
        if (list != null && !list.isEmpty()) {
            if (i3 >= 0 && i3 < this.C.size()) {
                return this.C.get(i3);
            }
            QZLog.w("TitleBarMoreOperationAdapter", 1, "invalid position, " + i3);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i3) {
        String str;
        List<a> list = this.C;
        if (list == null || list.size() == 0) {
            return;
        }
        bVar.E.setTag(Integer.valueOf(i3));
        if (!TextUtils.isEmpty(this.C.get(i3).f42671d)) {
            bVar.F.setAsyncImage(this.C.get(i3).f42671d);
        } else if (this.C.get(i3).f42670c != null) {
            bVar.F.setImageDrawable(this.C.get(i3).f42670c);
        } else {
            bVar.F.setImageResource(R.drawable.g9z);
        }
        bVar.G.setTextColor(this.C.get(i3).f42669b);
        bVar.G.setText(this.C.get(i3).f42668a);
        bVar.H.setVisibility(this.C.get(i3).f42673f ? 0 : 8);
        HashMap hashMap = new HashMap();
        hashMap.put("tool_name", this.C.get(i3).f42668a);
        if (this.C.get(i3).f42673f) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_red_tips", str);
        fo.c.o(bVar.E, "em_qz_tool_box_float_icon", new fo.b().l(hashMap).i(i3 + ""));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        b bVar = new b(LayoutInflater.from(this.f42667m).inflate(R.layout.bih, viewGroup, false));
        bVar.E.setOnClickListener(this);
        return bVar;
    }

    public void l0(List<a> list) {
        this.C = list;
    }

    public void m0(v vVar) {
        this.D = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.D != null) {
            this.D.onItemClick(view, ((Integer) view.getTag()).intValue());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f42668a;

        /* renamed from: b, reason: collision with root package name */
        public int f42669b;

        /* renamed from: c, reason: collision with root package name */
        public Drawable f42670c;

        /* renamed from: d, reason: collision with root package name */
        public String f42671d;

        /* renamed from: e, reason: collision with root package name */
        public String f42672e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f42673f;

        public a(String str, int i3, Drawable drawable) {
            this.f42668a = str;
            this.f42669b = i3;
            this.f42670c = drawable;
            this.f42671d = null;
        }

        public a(String str, int i3, String str2, String str3) {
            this.f42668a = str;
            this.f42669b = i3;
            this.f42671d = str2;
            this.f42670c = null;
            this.f42672e = str3;
        }
    }
}
