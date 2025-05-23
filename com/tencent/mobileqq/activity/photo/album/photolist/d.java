package com.tencent.mobileqq.activity.photo.album.photolist;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCommonUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends RecyclerView.Adapter<com.tencent.mobileqq.activity.photo.album.photolist.a> {
    static IPatchRedirector $redirector_;
    private static SoftReference<Drawable> L;
    Resources C;
    Drawable D;
    public ArrayList<LocalMediaInfo> E;
    ColorDrawable F;
    PeakFragmentActivity G;
    f<? extends OtherCommonData> H;
    public int I;
    public int J;
    int K;

    /* renamed from: m, reason: collision with root package name */
    public LayoutInflater f184282m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f184283d;

        /* renamed from: e, reason: collision with root package name */
        CheckBox f184284e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        public void a(CheckBox checkBox) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) checkBox);
            } else {
                this.f184284e = checkBox;
            }
        }

        public void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f184283d = i3;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            } else {
                f<? extends OtherCommonData> fVar = d.this.H;
                if (fVar != null) {
                    fVar.J(view, this.f184283d, this.f184284e);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public int f184286d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int itemViewType = d.this.getItemViewType(this.f184286d);
                d dVar = d.this;
                f<? extends OtherCommonData> fVar = dVar.H;
                if (fVar != null) {
                    if (itemViewType != 0) {
                        if (itemViewType != 1) {
                            if (itemViewType == 2) {
                                fVar.c(view, this.f184286d);
                            }
                        } else {
                            fVar.p(view, this.f184286d);
                        }
                    } else if (dVar.k0().isSingleMode) {
                        d.this.H.l(view, this.f184286d);
                    } else {
                        d.this.H.R(d.this.H.k(view, this.f184286d));
                        QAlbumUtil.anim(d.this.G, true, true);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public d(f<? extends OtherCommonData> fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
            return;
        }
        this.E = new ArrayList<>();
        this.F = new ColorDrawable(570425344);
        this.H = fVar;
        if (fVar != null) {
            PeakFragmentActivity peakFragmentActivity = fVar.f184309d;
            this.G = peakFragmentActivity;
            this.f184282m = peakFragmentActivity.getLayoutInflater();
            this.C = this.G.getResources();
        }
        if (this.D == null) {
            this.D = l0();
        }
        this.K = this.C.getDimensionPixelSize(R.dimen.f159225xv);
        int i3 = (this.C.getDisplayMetrics().widthPixels - (this.K * 2)) / o0().f184304o;
        this.I = i3;
        this.J = i3;
    }

    private com.tencent.mobileqq.activity.photo.album.photolist.a i0(a aVar) {
        View inflate = this.f184282m.inflate(R.layout.azc, (ViewGroup) null);
        com.tencent.mobileqq.activity.photo.album.photolist.a aVar2 = new com.tencent.mobileqq.activity.photo.album.photolist.a(inflate);
        inflate.setLayoutParams(new AbsListView.LayoutParams(this.I, this.J));
        aVar2.F = (ImageView) inflate.findViewById(R.id.fq6);
        aVar2.E = (ImageView) inflate.findViewById(R.id.f166509fp4);
        aVar2.G = (ImageView) inflate.findViewById(R.id.fui);
        aVar2.H = (ImageView) inflate.findViewById(R.id.fqa);
        aVar2.M = inflate.findViewById(R.id.fq8);
        aVar2.J = (NumberCheckBox) inflate.findViewById(R.id.fq9);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f166505h54);
        aVar2.I = imageView;
        imageView.setVisibility(8);
        if (k0().maxSelectNum > 100) {
            aVar2.J.setTextSize(10.0f);
        }
        aVar2.P = aVar;
        View view = aVar2.M;
        if (view != null) {
            view.setOnClickListener(aVar);
        }
        inflate.setTag(aVar2);
        if (!k0().isSingleMode) {
            aVar2.M.setVisibility(0);
        }
        return aVar2;
    }

    private com.tencent.mobileqq.activity.photo.album.photolist.a j0(a aVar) {
        View inflate = this.f184282m.inflate(R.layout.b4l, (ViewGroup) null);
        com.tencent.mobileqq.activity.photo.album.photolist.a aVar2 = new com.tencent.mobileqq.activity.photo.album.photolist.a(inflate);
        inflate.setLayoutParams(new AbsListView.LayoutParams(this.I, this.J));
        aVar2.F = (ImageView) inflate.findViewById(R.id.fq6);
        aVar2.L = (TextView) inflate.findViewById(R.id.fqb);
        aVar2.G = (ImageView) inflate.findViewById(R.id.fui);
        aVar2.H = (ImageView) inflate.findViewById(R.id.fqa);
        aVar2.M = inflate.findViewById(R.id.fq8);
        aVar2.J = (NumberCheckBox) inflate.findViewById(R.id.fq9);
        if (k0().maxSelectNum > 100) {
            aVar2.J.setTextSize(10.0f);
        }
        aVar2.P = aVar;
        View view = aVar2.M;
        if (view != null) {
            view.setOnClickListener(aVar);
        }
        inflate.setTag(aVar2);
        if (!k0().isSingleMode && o0().f184293d) {
            aVar2.M.setVisibility(0);
        }
        return aVar2;
    }

    private Drawable l0() {
        SoftReference<Drawable> softReference = L;
        if (softReference != null) {
            Drawable drawable = softReference.get();
            if (drawable == null) {
                Drawable drawable2 = BaseApplication.getContext().getResources().getDrawable(R.drawable.asd);
                L = new SoftReference<>(drawable2);
                return drawable2;
            }
            return drawable;
        }
        Drawable drawable3 = BaseApplication.getContext().getResources().getDrawable(R.drawable.asd);
        L = new SoftReference<>(drawable3);
        return drawable3;
    }

    public static void s0() {
        L = new SoftReference<>(BaseApplication.getContext().getResources().getDrawable(R.drawable.asd));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.E.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        return QAlbumUtil.getMediaType(this.E.get(i3));
    }

    PhotoCommonBaseData k0() {
        f<? extends OtherCommonData> fVar = this.H;
        if (fVar != null) {
            return fVar.f184310e;
        }
        return null;
    }

    public LocalMediaInfo m0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return this.E.get(i3);
    }

    public List<LocalMediaInfo> n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e o0() {
        f<? extends OtherCommonData> fVar = this.H;
        if (fVar != null) {
            return fVar.f184312h;
        }
        return null;
    }

    public TextView p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TextView) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        TextView textView = new TextView(this.G);
        textView.setGravity(17);
        textView.setTextSize(10.0f);
        textView.setTextColor(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setSize(QAlbumCommonUtil.dp2px(30.0f, this.C), QAlbumCommonUtil.dp2px(18.0f, this.C));
        gradientDrawable.setCornerRadii(new float[]{QAlbumCommonUtil.dp2px(2.0f, this.C), QAlbumCommonUtil.dp2px(2.0f, this.C), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(1291845632);
        textView.setBackgroundDrawable(gradientDrawable);
        return textView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, i3);
            return;
        }
        aVar.Q.f184286d = aVar.getAdapterPosition();
        int itemViewType = getItemViewType(i3);
        if (itemViewType != 1) {
            if (itemViewType != 2) {
                this.H.z(aVar, i3);
                return;
            } else {
                this.H.y(aVar, i3);
                return;
            }
        }
        this.H.A(aVar, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.activity.photo.album.photolist.a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        com.tencent.mobileqq.activity.photo.album.photolist.a j06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.activity.photo.album.photolist.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        a aVar = new a();
        if (i3 != 1) {
            if (i3 != 2) {
                j06 = i0(aVar);
            } else {
                View inflate = this.f184282m.inflate(R.layout.gw9, (ViewGroup) null);
                inflate.setLayoutParams(new AbsListView.LayoutParams(this.I, this.J));
                j06 = new com.tencent.mobileqq.activity.photo.album.photolist.a(inflate);
            }
        } else {
            j06 = j0(aVar);
        }
        b bVar = new b();
        j06.Q = bVar;
        ImageView imageView = j06.F;
        if (imageView != null) {
            imageView.setOnClickListener(bVar);
        } else {
            j06.itemView.setOnClickListener(bVar);
        }
        return j06;
    }

    public void t0(List<LocalMediaInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
            return;
        }
        this.E.clear();
        if (list != null && list.size() != 0) {
            if (!o0().f184306q && QAlbumUtil.getMediaType(list.get(0)) == 2) {
                list.remove(0);
            }
            this.E.addAll(list);
            notifyDataSetChanged();
        }
    }
}
