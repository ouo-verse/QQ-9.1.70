package com.tencent.relation.common.widget.squaredIndicator;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.widget.MutualMarkIcon;
import com.tencent.mobileqq.mutualmark.widget.detailcard.MutualMarkDetailListHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e extends RecyclerView.Adapter<a> {
    static IPatchRedirector $redirector_;
    private List<MutualMarkModel> C;
    private MutualMarkDetailListHelper D;
    private com.tencent.mobileqq.mutualmark.util.a E;
    private int F;
    private WeakReference<View.OnClickListener> G;

    /* renamed from: m, reason: collision with root package name */
    private final Context f364873m;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        private View E;
        public MutualMarkIcon F;
        public ImageView G;
        public RelativeLayout H;
        public TextView I;
        public TextView J;
        public long K;
        public String L;

        public a(@NonNull View view, int i3) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, view, Integer.valueOf(i3));
                return;
            }
            this.K = 0L;
            this.L = "";
            this.E = view;
            if (i3 == 2) {
                this.H = (RelativeLayout) view.findViewById(R.id.zeo);
                this.I = (TextView) view.findViewById(R.id.f99155p1);
                this.J = (TextView) view.findViewById(R.id.f165265cj4);
                if (!FontSettingManager.isFontSizeNormal()) {
                    FontSettingManager.resetViewSize2Normal(e.this.f364873m, this.I);
                    FontSettingManager.resetViewSize2Normal(e.this.f364873m, this.J);
                    return;
                }
                return;
            }
            MutualMarkIcon mutualMarkIcon = (MutualMarkIcon) view.findViewById(R.id.zlf);
            this.F = mutualMarkIcon;
            this.G = (ImageView) mutualMarkIcon.findViewById(R.id.zlc);
        }
    }

    public e(Context context, List<MutualMarkModel> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, list, Integer.valueOf(i3));
            return;
        }
        new ArrayList();
        this.E = null;
        this.f364873m = context;
        this.C = list;
        this.F = i3;
        this.E = new com.tencent.mobileqq.mutualmark.util.a(context);
    }

    private boolean l0(a aVar, MutualMarkModel mutualMarkModel) {
        if (aVar.K == mutualMarkModel.D && !TextUtils.isEmpty(aVar.L) && aVar.L.equals(mutualMarkModel.f252159h)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(int i3, a aVar, MutualMarkModel mutualMarkModel, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.D = new MutualMarkDetailListHelper(this.f364873m, this.C, i3);
        int[] iArr = new int[2];
        aVar.E.getLocationInWindow(iArr);
        if (aVar.E.getParent() instanceof RecyclerView) {
            this.D.x((RecyclerView) aVar.E.getParent());
        }
        this.D.z(iArr[0], iArr[1], aVar.E.getMeasuredWidth(), aVar.E.getMeasuredHeight(), mutualMarkModel, this.f364873m);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(View view) {
        View.OnClickListener onClickListener;
        EventCollector.getInstance().onViewClickedBefore(view);
        WeakReference<View.OnClickListener> weakReference = this.G;
        if (weakReference != null && (onClickListener = weakReference.get()) != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.C.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        if (i3 != getNUM_BACKGOURND_ICON() - 1) {
            return 1;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull final a aVar, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar, i3);
            return;
        }
        if (i3 >= 0 && i3 < getNUM_BACKGOURND_ICON()) {
            if (getItemViewType(i3) == 1) {
                final MutualMarkModel mutualMarkModel = this.C.get(i3);
                boolean l06 = l0(aVar, mutualMarkModel);
                aVar.K = mutualMarkModel.D;
                aVar.L = mutualMarkModel.f252159h;
                aVar.F.i(mutualMarkModel, i3, l06);
                aVar.F.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.relation.common.widget.squaredIndicator.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        e.this.m0(i3, aVar, mutualMarkModel, view);
                    }
                });
                AccessibilityUtil.p(aVar.E, mutualMarkModel.E);
                return;
            }
            if (this.F == 0) {
                aVar.I.setVisibility(8);
                aVar.J.setText(this.f364873m.getResources().getString(R.string.f238407jo));
                AccessibilityUtil.p(aVar.E, HardCodeUtil.qqStr(R.string.f238407jo));
            } else {
                aVar.I.setVisibility(0);
                aVar.I.setText(this.f364873m.getResources().getString(R.string.f2321873v, Integer.valueOf(this.F)));
                aVar.J.setText(this.f364873m.getResources().getString(R.string.f2321973w));
                AccessibilityUtil.p(aVar.E, this.f364873m.getResources().getString(R.string.f2321873v, Integer.valueOf(this.F)) + HardCodeUtil.qqStr(R.string.f2321973w));
            }
            aVar.H.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.relation.common.widget.squaredIndicator.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.this.n0(view);
                }
            });
        }
    }

    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        MutualMarkDetailListHelper mutualMarkDetailListHelper = this.D;
        if (mutualMarkDetailListHelper != null) {
            return mutualMarkDetailListHelper.l(this.f364873m);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        if (i3 == 1) {
            i16 = R.layout.gz7;
        } else {
            i16 = R.layout.gz4;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i16, viewGroup, false);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) inflate.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = this.E.d();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = this.E.d();
        inflate.setLayoutParams(layoutParams);
        return new a(inflate, i3);
    }

    public void q0(List<MutualMarkModel> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list, i3);
            return;
        }
        this.F = i3;
        this.C.clear();
        this.C.addAll(list);
        notifyDataSetChanged();
        MutualMarkDetailListHelper mutualMarkDetailListHelper = this.D;
        if (mutualMarkDetailListHelper != null) {
            mutualMarkDetailListHelper.r(new ArrayList<>(list));
        }
    }

    public void r0(WeakReference<View.OnClickListener> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) weakReference);
        } else {
            this.G = weakReference;
        }
    }
}
