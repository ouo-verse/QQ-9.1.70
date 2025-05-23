package a53;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends RecyclerView.Adapter<a> {

    /* renamed from: f, reason: collision with root package name */
    public static int f25547f;

    /* renamed from: d, reason: collision with root package name */
    private List<d53.b> f25548d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f25549e;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View C;
        public View D;
        public ImageView E;

        /* renamed from: d, reason: collision with root package name */
        public int f25550d;

        /* renamed from: e, reason: collision with root package name */
        public View f25551e;

        /* renamed from: f, reason: collision with root package name */
        public View f25552f;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f25553h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f25554i;

        /* renamed from: m, reason: collision with root package name */
        public LinearLayout f25555m;

        public a(View view, int i3) {
            super(view);
            boolean z16;
            int i16;
            this.f25550d = i3;
            this.f25551e = view;
            this.f25552f = view.findViewById(R.id.f65903_7);
            this.f25553h = (ImageView) view.findViewById(R.id.f65893_6);
            this.f25554i = (TextView) view.findViewById(R.id.f65933__);
            this.f25555m = (LinearLayout) view.findViewById(R.id.f65923_9);
            this.C = view.findViewById(R.id.f65883_5);
            this.D = view.findViewById(R.id.f65843_1);
            ImageView imageView = (ImageView) view.findViewById(R.id.f65863_3);
            this.E = imageView;
            int i17 = b.f25547f;
            if (i17 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                imageView.setImageResource(i17);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Resources resources = view.getResources();
            if (z16) {
                i16 = R.dimen.d_k;
            } else {
                i16 = R.dimen.d_l;
            }
            layoutParams.height = resources.getDimensionPixelSize(i16);
            view.setLayoutParams(layoutParams);
            this.D.setVisibility(z16 ? 0 : 8);
        }

        private void c(d53.a aVar) {
            if (aVar != null && this.f25550d == 1) {
                ViewGroup.LayoutParams layoutParams = this.f25551e.getLayoutParams();
                layoutParams.width = (int) aVar.f393031b;
                layoutParams.height = (int) aVar.f393032c;
                this.f25551e.setLayoutParams(layoutParams);
                this.f25552f.setPadding(0, (int) aVar.f393033d, 0, 0);
                ViewGroup.LayoutParams layoutParams2 = this.f25553h.getLayoutParams();
                layoutParams2.width = (int) aVar.f393034e;
                layoutParams2.height = (int) aVar.f393035f;
                this.f25553h.setLayoutParams(layoutParams2);
                float f16 = aVar.f393030a;
                if (f16 > 0.25f) {
                    float f17 = (f16 - 0.25f) / 0.75f;
                    this.f25554i.setAlpha(f17);
                    this.f25555m.setAlpha(0.6f * f17);
                    float f18 = aVar.f393030a;
                    float f19 = f18 + ((1.0f - f18) * 0.25f);
                    this.f25555m.setPivotX(r5.getWidth() / 2);
                    this.f25555m.setPivotY(0.0f);
                    this.f25555m.setScaleX(f19);
                    this.f25555m.setScaleY(f19);
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.C.getLayoutParams();
                    layoutParams3.width = (int) aVar.f393031b;
                    layoutParams3.topMargin = (int) (aVar.f393036g * f17);
                    this.C.setLayoutParams(layoutParams3);
                } else {
                    this.f25554i.setAlpha(0.0f);
                    this.f25555m.setAlpha(0.0f);
                }
                float f26 = aVar.f393030a;
                if (f26 > 0.75f) {
                    this.D.setAlpha((f26 - 0.75f) / 0.25f);
                } else {
                    this.D.setAlpha(0.0f);
                }
            }
        }

        public void b(d53.b bVar, int i3, boolean z16) {
            if (bVar == null) {
                return;
            }
            this.f25554i.setText(bVar.f393038b);
            e53.b.a(this.f25555m, bVar.f393039c);
            a53.a.i(this.f25553h, bVar.f393037a, true);
            c(bVar.f393040d);
            b.p();
        }
    }

    public b(Context context) {
        this.f25549e = context;
    }

    static /* bridge */ /* synthetic */ b53.a p() {
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d53.b> list = this.f25548d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i3) {
        aVar.b(this.f25548d.get(i3), i3, true);
        EventCollector.getInstance().onRecyclerBindViewHolder(aVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(this.f25549e).inflate(R.layout.hfz, viewGroup, false), 0);
    }

    public void s(int i3) {
        f25547f = i3;
    }

    public void setData(List<d53.b> list) {
        this.f25548d = list;
        notifyDataSetChanged();
    }

    public void t(b53.a aVar) {
    }
}
