package com.tencent.mobileqq.mutualmark.widget.detailcard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.widget.util.b;
import com.tencent.mobileqq.mutualmark.widget.util.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.annimation.scaleview.QUIScaleViewLayout;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends RecyclerView.Adapter<C8131a> {
    static IPatchRedirector $redirector_;
    private final Context C;
    private final MutualMarkDetailListHelper D;

    /* renamed from: m, reason: collision with root package name */
    private final ArrayList<MutualMarkModel> f252364m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.mutualmark.widget.detailcard.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C8131a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        private View E;
        public ImageView F;
        public ImageView G;
        private ImageView H;
        private ImageView I;
        public com.tencent.mobileqq.mutualmark.widget.util.d J;
        public com.tencent.mobileqq.mutualmark.widget.util.a K;
        private MutualMarkModel L;
        private i M;
        private b.InterfaceC8135b N;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.mutualmark.widget.detailcard.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class C8132a implements b.InterfaceC8135b {
            static IPatchRedirector $redirector_;

            C8132a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) C8131a.this);
                }
            }

            @Override // com.tencent.mobileqq.mutualmark.widget.util.b.InterfaceC8135b
            public void onAnimationEnd() {
                com.tencent.mobileqq.mutualmark.widget.detailcard.b k3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (C8131a.this.M == null) {
                    k3 = null;
                } else {
                    k3 = C8131a.this.M.k();
                }
                if (k3 == null) {
                    return;
                }
                QUIButton g16 = k3.g();
                if (g16 != null && HardCodeUtil.qqStr(R.string.f13825092).equals(g16.getText())) {
                    com.tencent.mobileqq.mutualmark.widget.util.c.a(k3.h().getContext(), new c.a(k3.h(), HardCodeUtil.qqStr(R.string.zma), 49, 3));
                    ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_tag_detail", "em_interact_tag_wear_tips", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagProfileData());
                }
                com.tencent.mobileqq.mutualmark.widget.util.b.e().h(null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.mutualmark.widget.detailcard.a$a$b */
        /* loaded from: classes15.dex */
        public class b implements Animation.AnimationListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) C8131a.this);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                    return;
                }
                C8131a c8131a = C8131a.this;
                if (c8131a.K != null && c8131a.E != null) {
                    C8131a c8131a2 = C8131a.this;
                    c8131a2.K.d(c8131a2.E.findViewById(R.id.zkv));
                }
            }
        }

        public C8131a(@NonNull @NotNull View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) view);
                return;
            }
            this.J = new com.tencent.mobileqq.mutualmark.widget.util.d();
            this.K = new com.tencent.mobileqq.mutualmark.widget.util.a();
            this.L = null;
            this.N = new C8132a();
            this.E = view;
            i iVar = new i(a.this.C, view);
            this.M = iVar;
            iVar.r(a.this.D);
            this.M.s(this.J);
            this.F = (ImageView) view.findViewById(R.id.f166369zl3);
            this.G = (ImageView) view.findViewById(R.id.f166370zl4);
            this.H = (ImageView) view.findViewById(R.id.zl6);
            this.I = (ImageView) view.findViewById(R.id.zl5);
            this.J.g(this.H).h(this.I);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.zkz);
            QUIScaleViewLayout qUIScaleViewLayout = (QUIScaleViewLayout) view.findViewById(R.id.zkx);
            qUIScaleViewLayout.bringToFront();
            relativeLayout.bringChildToFront(qUIScaleViewLayout);
            relativeLayout.updateViewLayout(qUIScaleViewLayout, qUIScaleViewLayout.getLayoutParams());
            p();
        }

        private void p() {
            this.K.a((QUIShimmerImageView) this.E.findViewById(R.id.zkv), (QUIScaleViewLayout) this.E.findViewById(R.id.zkx), this.E.getContext().getResources().getColor(R.color.cpf));
        }

        public MutualMarkModel o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MutualMarkModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.L;
        }

        @SuppressLint({"UseCompatLoadingForDrawables"})
        public void q(MutualMarkModel mutualMarkModel, int i3) {
            com.tencent.mobileqq.mutualmark.widget.detailcard.b k3;
            QUIButton g16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) mutualMarkModel, i3);
                return;
            }
            i iVar = this.M;
            if (iVar != null) {
                iVar.q(new MutualMarkModel(mutualMarkModel));
            }
            this.E.setTag(this);
            MutualMarkModel mutualMarkModel2 = this.L;
            if (mutualMarkModel2 != null && mutualMarkModel2.D == 44 && mutualMarkModel.f252157e == MutualMarkModel.f252153c0 && ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isNewerGuideMode()) {
                com.tencent.mobileqq.mutualmark.widget.util.b.e().h(this.N);
                com.tencent.mobileqq.mutualmark.widget.util.b.e().f252451d = true;
                this.J.i("mutual_mark_lottie/confetti_frist.json");
            }
            if (this.L != null && a.this.D != null && !this.L.N && mutualMarkModel.N) {
                MutualMarkDetailListHelper unused = a.this.D;
                MutualMarkDetailListHelper.f252334l = true;
            }
            MutualMarkModel mutualMarkModel3 = this.L;
            if (mutualMarkModel3 != null) {
                long j3 = mutualMarkModel3.D;
                if ((j3 == 44 || (j3 == com.tencent.mobileqq.mutualmark.widget.util.b.e().f252452e && mutualMarkModel.D == com.tencent.mobileqq.mutualmark.widget.util.b.e().f252452e)) && !this.L.M && mutualMarkModel.M && com.tencent.mobileqq.mutualmark.widget.util.b.e().f252451d) {
                    com.tencent.mobileqq.mutualmark.widget.util.b.e().f252451d = false;
                    ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).showHalfScreenView(a.this.C, mutualMarkModel.f252159h, HardCodeUtil.qqStr(R.string.f158661q8), HardCodeUtil.qqStr(R.string.f161841yt), null);
                    com.tencent.mobileqq.mutualmark.widget.util.b.e().f252452e = -1L;
                    if (a.this.D != null) {
                        a.this.D.k(a.this.C);
                        return;
                    }
                    return;
                }
            }
            MutualMarkModel mutualMarkModel4 = this.L;
            if (mutualMarkModel4 != null && mutualMarkModel4.D == mutualMarkModel.D && !mutualMarkModel4.M && mutualMarkModel.M && !com.tencent.mobileqq.mutualmark.widget.util.b.e().f252451d) {
                this.K.c(new b());
            }
            this.L = new MutualMarkModel(mutualMarkModel);
            if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getUnsafeLocalCache("Is_New_Open_Lighted") != 1 && !com.tencent.mobileqq.mutualmark.widget.util.b.e().f252451d && mutualMarkModel.N && ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isNewerGuideMode()) {
                ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setUnsafeLocalCache("Is_New_Open_Lighted", 1);
                i iVar2 = this.M;
                if (iVar2 == null) {
                    k3 = null;
                } else {
                    k3 = iVar2.k();
                }
                if (k3 != null && (g16 = k3.g()) != null && HardCodeUtil.qqStr(R.string.f13825092).equals(g16.getText())) {
                    com.tencent.mobileqq.mutualmark.widget.util.c.a(k3.h().getContext(), new c.a(k3.h(), HardCodeUtil.qqStr(R.string.zma), 49, 3));
                    com.tencent.mobileqq.mutualmark.widget.util.b.e().f252451d = true;
                    com.tencent.mobileqq.mutualmark.widget.util.b.e().f252452e = mutualMarkModel.D;
                    ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_tag_detail", "em_interact_tag_wear_tips", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagProfileData());
                }
            }
        }
    }

    public a(Context context, MutualMarkDetailListHelper mutualMarkDetailListHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) mutualMarkDetailListHelper);
            return;
        }
        this.f252364m = new ArrayList<>();
        this.C = context;
        this.D = mutualMarkDetailListHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f252364m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull C8131a c8131a, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) c8131a, i3);
        } else {
            c8131a.q(this.f252364m.get(i3), i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C8131a onCreateViewHolder(@NotNull ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (C8131a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup, i3);
        }
        return new C8131a(LayoutInflater.from(this.C).inflate(R.layout.f168824gz1, viewGroup, false));
    }

    public void m0(ArrayList<MutualMarkModel> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
            return;
        }
        this.f252364m.clear();
        this.f252364m.addAll(arrayList);
        notifyDataSetChanged();
    }
}
