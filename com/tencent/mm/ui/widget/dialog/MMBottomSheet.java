package com.tencent.mm.ui.widget.dialog;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.luggage.wxa.mo.h;
import com.tencent.luggage.wxa.mo.i;
import com.tencent.luggage.wxa.mo.j;
import com.tencent.luggage.wxa.mo.k;
import com.tencent.luggage.wxa.mo.l;
import com.tencent.luggage.wxa.mo.m;
import com.tencent.luggage.wxa.mo.n;
import com.tencent.luggage.wxa.mo.p;
import com.tencent.luggage.wxa.mo.q;
import com.tencent.luggage.wxa.mo.s;
import com.tencent.luggage.wxa.mo.t;
import com.tencent.luggage.wxa.mo.u;
import com.tencent.luggage.wxa.mo.w;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMBottomSheet implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int BOTTOM_SHEET_STYLE_GRID = 0;
    public static final int BOTTOM_SHEET_STYLE_LIST = 1;
    public static final int BOTTOM_SHEET_STYLE_LIST_CHECKBOX = 2;
    public static ArrayList U0 = new ArrayList();
    public boolean A0;
    public boolean B0;
    public u C;
    public boolean C0;
    public u D;
    public boolean D0;
    public u E;
    public boolean E0;
    public MoreShareCallBack F;
    public boolean F0;
    public MoreShareCallBack G;
    public int G0;
    public CancelBtnCallBack H;
    public boolean H0;
    public h I;
    public int I0;
    public h J;
    public int J0;
    public h K;
    public boolean K0;
    public h L;
    public boolean L0;
    public h M;
    public RecyclerView.SmoothScroller M0;
    public View N;
    public RecyclerView.SmoothScroller N0;
    public Boolean O;
    public boolean O0;
    public LinearLayout P;
    public boolean P0;
    public LinearLayout Q;
    public boolean Q0;
    public LinearLayout R;
    public String R0;
    public LinearLayout S;
    public MMBottomSheetInitConfig S0;
    public CustomScrollView T;
    public boolean T0;
    public View U;
    public View V;
    public TextView W;
    public TextView X;
    public RecycleViewAdapter Y;
    public RecycleViewAdapter Z;

    /* renamed from: a, reason: collision with root package name */
    public IDismissCallBack f152930a;

    /* renamed from: a0, reason: collision with root package name */
    public RecycleViewAdapter f152931a0;

    /* renamed from: b, reason: collision with root package name */
    public IShowCallBack f152932b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f152933b0;

    /* renamed from: c, reason: collision with root package name */
    public IZeroRecyclerViewShowCallBack f152934c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f152935c0;

    /* renamed from: d, reason: collision with root package name */
    public Dialog f152936d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f152937d0;

    /* renamed from: e, reason: collision with root package name */
    public Context f152938e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f152939e0;

    /* renamed from: f, reason: collision with root package name */
    public p f152940f;

    /* renamed from: f0, reason: collision with root package name */
    public TextView f152941f0;

    /* renamed from: g, reason: collision with root package name */
    public p f152942g;

    /* renamed from: g0, reason: collision with root package name */
    public RecyclerView f152943g0;

    /* renamed from: h, reason: collision with root package name */
    public p f152944h;

    /* renamed from: h0, reason: collision with root package name */
    public RecyclerView f152945h0;

    /* renamed from: i, reason: collision with root package name */
    public p f152946i;

    /* renamed from: i0, reason: collision with root package name */
    public int f152947i0;

    /* renamed from: j, reason: collision with root package name */
    public p f152948j;

    /* renamed from: j0, reason: collision with root package name */
    public BottomSheetBehavior f152949j0;

    /* renamed from: k, reason: collision with root package name */
    public u f152950k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f152951k0;

    /* renamed from: l, reason: collision with root package name */
    public u f152952l;

    /* renamed from: l0, reason: collision with root package name */
    public int f152953l0;

    /* renamed from: m, reason: collision with root package name */
    public u f152954m;

    /* renamed from: m0, reason: collision with root package name */
    public View f152955m0;
    public ViewGroup mZeroLayoutContainer;
    public ViewStub mZeroLayoutStub;
    public RecyclerView mZeroRecyclerView;

    /* renamed from: n0, reason: collision with root package name */
    public ViewTreeObserver f152956n0;

    /* renamed from: o0, reason: collision with root package name */
    public ImageView f152957o0;

    /* renamed from: p0, reason: collision with root package name */
    public ImageView f152958p0;

    /* renamed from: q0, reason: collision with root package name */
    public ImageView f152959q0;

    /* renamed from: r0, reason: collision with root package name */
    public ImageView f152960r0;

    /* renamed from: s0, reason: collision with root package name */
    public TextView f152961s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f152962t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f152963u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f152964v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f152965w0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f152966x0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f152967y0;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f152968z0;
    public h zeroLineMenu;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface CancelBtnCallBack {
        void onClick();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IDismissCallBack {
        void onDismiss();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IShowCallBack {
        void onShow();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IZeroRecyclerViewShowCallBack {
        void onShow();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface MoreShareCallBack {
        void onClick();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class RecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f152989a;

        /* renamed from: b, reason: collision with root package name */
        public AdapterView.OnItemClickListener f152990b;

        /* renamed from: c, reason: collision with root package name */
        public AdapterView.OnItemLongClickListener f152991c;

        /* renamed from: d, reason: collision with root package name */
        public h f152992d;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
            public Button C;

            /* renamed from: a, reason: collision with root package name */
            public TextView f152999a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f153000b;

            /* renamed from: c, reason: collision with root package name */
            public WeImageView f153001c;

            /* renamed from: d, reason: collision with root package name */
            public ImageView f153002d;

            /* renamed from: e, reason: collision with root package name */
            public ImageView f153003e;

            /* renamed from: f, reason: collision with root package name */
            public RadioButton f153004f;

            /* renamed from: g, reason: collision with root package name */
            public ImageView f153005g;

            /* renamed from: h, reason: collision with root package name */
            public LinearLayout f153006h;

            /* renamed from: i, reason: collision with root package name */
            public View f153007i;

            /* renamed from: j, reason: collision with root package name */
            public View f153008j;

            /* renamed from: k, reason: collision with root package name */
            public View f153009k;

            /* renamed from: l, reason: collision with root package name */
            public View f153010l;

            /* renamed from: m, reason: collision with root package name */
            public View f153011m;

            public ViewHolder(View view) {
                super(view);
                this.f153002d = null;
                view.setOnClickListener(this);
                view.setOnLongClickListener(this);
                this.f152999a = (TextView) view.findViewById(R.id.title);
                this.f153001c = (WeImageView) view.findViewById(R.id.icon);
                this.f153006h = (LinearLayout) view.findViewById(R.id.root);
                this.f153007i = view.findViewById(R.id.zq_);
                this.f153008j = view.findViewById(R.id.i4v);
                this.f153009k = view.findViewById(R.id.f98765nz);
                this.f153011m = view.findViewById(R.id.f82494h1);
                this.C = (Button) view.findViewById(R.id.f82114g0);
                if (MMBottomSheet.this.f152939e0) {
                    this.f153003e = (ImageView) view.findViewById(R.id.xde);
                    if (MMBottomSheet.this.f152931a0 != null && MMBottomSheet.this.f152931a0.getItemCount() > 0) {
                        Log.i("MicroMsg.MMBottomSheet", "set icon longClickable");
                        this.f153003e.setLongClickable(true);
                        this.f153003e.setOnLongClickListener(this);
                        this.f153003e.setOnClickListener(this);
                        View view2 = this.f153011m;
                        if (view2 != null) {
                            view2.setOnClickListener(this);
                        }
                        Button button = this.C;
                        if (button != null) {
                            button.setOnClickListener(this);
                        }
                    }
                    this.f153002d = (ImageView) view.findViewById(R.id.xdc);
                    this.f153010l = (ImageView) view.findViewById(R.id.xdf);
                }
                if (MMBottomSheet.this.f152935c0) {
                    this.f153004f = (RadioButton) view.findViewById(R.id.f69993k9);
                }
                if (MMBottomSheet.this.f152935c0 || MMBottomSheet.this.f152937d0) {
                    this.f153000b = (TextView) view.findViewById(R.id.bg6);
                    this.f153005g = (ImageView) view.findViewById(R.id.bmt);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdapterView.OnItemClickListener onItemClickListener = RecycleViewAdapter.this.f152990b;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(null, view, getPosition(), getPosition());
                }
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                AdapterView.OnItemLongClickListener onItemLongClickListener = RecycleViewAdapter.this.f152991c;
                if (onItemLongClickListener != null) {
                    onItemLongClickListener.onItemLongClick(null, view, getPosition(), getPosition());
                    return true;
                }
                return false;
            }
        }

        public RecycleViewAdapter(boolean z16) {
            this.f152989a = z16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = this.f152992d.size();
            if (!this.f152989a || !MMBottomSheet.this.O0) {
                size += MMBottomSheet.this.J.size();
            }
            if (MMBottomSheet.this.f152933b0) {
                if (!this.f152989a || !MMBottomSheet.this.O0) {
                    return size + 1;
                }
                return size;
            }
            return size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            if (i3 >= 0 && i3 < this.f152992d.size()) {
                MenuItem item = this.f152992d.getItem(i3);
                if ((item instanceof i) && !((i) item).e()) {
                    return 1;
                }
                return 0;
            }
            if (MMBottomSheet.this.J.size() > 0 && i3 < this.f152992d.size() + MMBottomSheet.this.J.size()) {
                return 2;
            }
            if (MMBottomSheet.this.f152933b0 && i3 == this.f152992d.size() + MMBottomSheet.this.J.size()) {
                return 3;
            }
            return 0;
        }

        public void setMenu(h hVar) {
            this.f152992d = hVar;
        }

        public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
            this.f152990b = onItemClickListener;
        }

        public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
            this.f152991c = onItemLongClickListener;
        }

        /* JADX WARN: Removed duplicated region for block: B:104:0x0371  */
        /* JADX WARN: Removed duplicated region for block: B:179:0x060b  */
        /* JADX WARN: Removed duplicated region for block: B:189:0x0661  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x031e  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0376  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x038d  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x03ca  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x03e1  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x03f9  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onBindViewHolder(final ViewHolder viewHolder, int i3) {
            int i16;
            int i17;
            int i18;
            TextView textView;
            int i19;
            int i26;
            ImageView imageView;
            ImageView imageView2;
            View view;
            if (i3 < this.f152992d.size()) {
                if (MMBottomSheet.this.G0 >= this.f152992d.size()) {
                    MMBottomSheet.this.G0 = 0;
                }
                i iVar = (i) this.f152992d.getItemList().get(i3);
                MMBottomSheet.x(MMBottomSheet.this);
                viewHolder.f152999a.setText(iVar.getTitle());
                if (TextUtils.isEmpty(iVar.getTitle()) && !TextUtils.isEmpty(iVar.f())) {
                    viewHolder.f152999a.setText(iVar.f());
                    iVar.a(TextUtils.TruncateAt.END);
                }
                viewHolder.f152999a.setEllipsize(iVar.m());
                if (MMBottomSheet.this.f152939e0 && this.f152992d.size() > 5) {
                    viewHolder.f152999a.setLines(2);
                }
                if (iVar.getIcon() != null) {
                    viewHolder.f153001c.setVisibility(0);
                    viewHolder.f153001c.setImageDrawable(iVar.getIcon());
                    if (MMBottomSheet.this.f152935c0) {
                        viewHolder.f153001c.setIconColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.ajr));
                    } else if (iVar.d() == 0) {
                        viewHolder.f153001c.setIconColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.ajr));
                    } else {
                        viewHolder.f153001c.setIconColor(iVar.d());
                    }
                } else {
                    MMBottomSheet.A(MMBottomSheet.this);
                    if (TextUtils.isEmpty(iVar.n())) {
                        if (MMBottomSheet.this.E0) {
                            viewHolder.f153001c.setVisibility(4);
                        } else {
                            viewHolder.f153001c.setVisibility(8);
                        }
                    } else {
                        viewHolder.f153003e.setVisibility(0);
                        MMBottomSheet.B(MMBottomSheet.this);
                    }
                }
                if (iVar.o()) {
                    viewHolder.f153010l.setVisibility(0);
                    viewHolder.f153010l.postDelayed(new Runnable() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.RecycleViewAdapter.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewHolder.f153010l, com.tencent.luggage.wxa.c8.c.f123400v, 0.2f, 0.0f);
                            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.RecycleViewAdapter.1.1
                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(@NonNull Animator animator) {
                                    viewHolder.f153010l.setVisibility(8);
                                    viewHolder.f153010l.setAlpha(0.2f);
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationCancel(@NonNull Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationRepeat(@NonNull Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationStart(@NonNull Animator animator) {
                                }
                            });
                            ofFloat.setDuration(300L);
                            ofFloat.start();
                        }
                    }, 1500L);
                }
                iVar.g();
                MMBottomSheet.D(MMBottomSheet.this);
                if (iVar.c()) {
                    if (MMBottomSheet.this.O.booleanValue() || MMBottomSheet.this.L0) {
                        viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.czn));
                    } else {
                        viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.b9w));
                    }
                    if (MMBottomSheet.this.f152939e0) {
                        if (MMBottomSheet.this.O.booleanValue() || MMBottomSheet.this.L0) {
                            viewHolder.f153001c.setIconColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.anw));
                            ImageView imageView3 = viewHolder.f153003e;
                            if (imageView3 != null) {
                                imageView3.setBackgroundResource(R.drawable.lgl);
                            }
                        } else {
                            viewHolder.f153001c.setIconColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.anv));
                        }
                        ImageView imageView4 = viewHolder.f153003e;
                        if (imageView4 != null) {
                            imageView4.setAlpha(128);
                        }
                    } else {
                        viewHolder.f153001c.setAlpha(77);
                        viewHolder.f153006h.setBackgroundResource(R.color.ajr);
                    }
                } else {
                    viewHolder.f153001c.setAlpha(255);
                    ImageView imageView5 = viewHolder.f153003e;
                    if (imageView5 != null) {
                        imageView5.setAlpha(255);
                    }
                    if (MMBottomSheet.this.O.booleanValue() || MMBottomSheet.this.L0) {
                        viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.anp));
                        if (MMBottomSheet.this.f152937d0 && (textView = viewHolder.f153000b) != null) {
                            textView.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.anl));
                        }
                        if (MMBottomSheet.this.f152939e0) {
                            if (iVar.d() == MMBottomSheet.this.f152938e.getResources().getColor(R.color.ar9)) {
                                viewHolder.f153001c.setIconColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.anp));
                            }
                            ImageView imageView6 = viewHolder.f153003e;
                            if (imageView6 != null) {
                                imageView6.setBackgroundResource(R.drawable.lgl);
                            }
                        }
                    } else if (MMBottomSheet.this.f152939e0) {
                        viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.b9x));
                    } else {
                        viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.b9v));
                    }
                    if (iVar.l() != 0) {
                        viewHolder.f152999a.setTextColor(iVar.l());
                    }
                }
                viewHolder.f153001c.setEnableColorFilter(iVar.e());
                if (viewHolder.f153000b != null) {
                    if (iVar.a() != null && iVar.a().length() > 0) {
                        viewHolder.f153000b.setVisibility(0);
                        viewHolder.f153000b.setText(iVar.a());
                        if (MMBottomSheet.this.f152935c0) {
                            viewHolder.f153000b.setMovementMethod(LinkMovementMethod.getInstance());
                        }
                        if (iVar.b() != 0) {
                            viewHolder.f153000b.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(iVar.b()));
                        }
                    } else {
                        i19 = 8;
                        viewHolder.f153000b.setVisibility(8);
                        if (MMBottomSheet.this.f152935c0) {
                            i26 = 0;
                        } else {
                            if (!iVar.c()) {
                                viewHolder.f153000b.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.b9x));
                                i26 = 0;
                                viewHolder.f153004f.setVisibility(0);
                                if (MMBottomSheet.this.G0 == i3) {
                                    viewHolder.f153004f.setChecked(true);
                                } else {
                                    viewHolder.f153004f.setChecked(false);
                                }
                            } else {
                                viewHolder.f153004f.setVisibility(i19);
                                viewHolder.f153000b.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.b9w));
                                i26 = 0;
                            }
                            viewHolder.f153005g.setVisibility(i26);
                        }
                        if (viewHolder.f153007i != null) {
                            if (iVar.j()) {
                                viewHolder.f153007i.setVisibility(i26);
                            } else {
                                viewHolder.f153007i.setVisibility(8);
                            }
                        }
                        if (viewHolder.f153008j != null) {
                            if (iVar.k()) {
                                if (!TextUtils.isEmpty(iVar.a()) && (view = viewHolder.f153009k) != null) {
                                    view.setVisibility(0);
                                } else {
                                    viewHolder.f153008j.setVisibility(0);
                                }
                            } else {
                                viewHolder.f153008j.setVisibility(8);
                            }
                        }
                        if (MMBottomSheet.this.f152937d0 && MMBottomSheet.this.L0) {
                            if (iVar.d() != 0) {
                                viewHolder.f153001c.setIconColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.anp));
                            }
                            imageView2 = viewHolder.f153005g;
                            if (imageView2 != null) {
                                imageView2.setBackgroundColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.akk));
                            }
                        }
                        imageView = viewHolder.f153002d;
                        if (imageView != null) {
                            imageView.setVisibility(8);
                        }
                        MMBottomSheet.I(MMBottomSheet.this);
                    }
                }
                i19 = 8;
                if (MMBottomSheet.this.f152935c0) {
                }
                if (viewHolder.f153007i != null) {
                }
                if (viewHolder.f153008j != null) {
                }
                if (MMBottomSheet.this.f152937d0) {
                    if (iVar.d() != 0) {
                    }
                    imageView2 = viewHolder.f153005g;
                    if (imageView2 != null) {
                    }
                }
                imageView = viewHolder.f153002d;
                if (imageView != null) {
                }
                MMBottomSheet.I(MMBottomSheet.this);
            } else {
                if (MMBottomSheet.this.J.size() <= 0 || i3 >= this.f152992d.size() + MMBottomSheet.this.J.size()) {
                    if (MMBottomSheet.this.f152933b0) {
                        if (!TextUtils.isEmpty(MMBottomSheet.this.R0)) {
                            viewHolder.f152999a.setText(MMBottomSheet.this.R0);
                        } else {
                            viewHolder.f152999a.setText(R.string.zfy);
                        }
                        MMBottomSheet.O(MMBottomSheet.this);
                        viewHolder.f153001c.setImageResource(R.raw.f169300bv);
                        if (viewHolder.f153002d != null) {
                            MMBottomSheet.P(MMBottomSheet.this);
                            viewHolder.f153002d.setVisibility(8);
                        }
                        if (MMBottomSheet.this.P0) {
                            viewHolder.f153006h.setAlpha(MMBottomSheet.this.Q0 ? 1.0f : 0.3f);
                            viewHolder.f153001c.setIconColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.ajr));
                            viewHolder.f153001c.setAlpha(255);
                            ImageView imageView7 = viewHolder.f153003e;
                            if (imageView7 != null) {
                                imageView7.setAlpha(255);
                            }
                            if (MMBottomSheet.this.O.booleanValue() || MMBottomSheet.this.L0) {
                                viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.anl));
                            } else if (MMBottomSheet.this.f152939e0) {
                                viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.b9x));
                            } else {
                                viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.b9v));
                            }
                        }
                    }
                } else {
                    i iVar2 = (i) MMBottomSheet.this.J.getItemList().get(i3 - this.f152992d.size());
                    viewHolder.f152999a.setText(iVar2.getTitle());
                    if (MMBottomSheet.this.G0 >= this.f152992d.size() + MMBottomSheet.this.J.size()) {
                        i16 = 0;
                        MMBottomSheet.this.G0 = 0;
                    } else {
                        i16 = 0;
                    }
                    if (iVar2.getIcon() != null) {
                        viewHolder.f153001c.setVisibility(i16);
                        viewHolder.f153001c.setImageDrawable(iVar2.getIcon());
                    } else {
                        viewHolder.f153001c.setVisibility(8);
                    }
                    if (!MMBottomSheet.this.O0) {
                        if (iVar2.c()) {
                            if (MMBottomSheet.this.O.booleanValue() || MMBottomSheet.this.L0) {
                                viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.czn));
                            } else {
                                viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.b9w));
                            }
                            viewHolder.f153006h.setBackgroundResource(R.color.ajr);
                        } else if (MMBottomSheet.this.O.booleanValue() || MMBottomSheet.this.L0) {
                            viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.anp));
                            viewHolder.f153006h.setBackgroundResource(R.drawable.lkb);
                        } else {
                            TextView textView2 = viewHolder.f152999a;
                            textView2.setTextColor(textView2.getTextColors());
                            viewHolder.f153006h.setBackgroundResource(R.drawable.lka);
                        }
                    } else {
                        viewHolder.f153006h.setAlpha(iVar2.c() ? 0.3f : 1.0f);
                        if (iVar2.d() == 0) {
                            viewHolder.f153001c.setIconColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.ajr));
                        } else {
                            viewHolder.f153001c.setIconColor(iVar2.d());
                        }
                        viewHolder.f153001c.setTag(iVar2);
                        iVar2.a(new n() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.RecycleViewAdapter.2
                            @Override // com.tencent.luggage.wxa.mo.n
                            public void onIconSet(@NonNull i iVar3) {
                                Object tag = viewHolder.f153001c.getTag();
                                if ((tag instanceof i) && iVar3.equals((i) tag)) {
                                    viewHolder.f153001c.setVisibility(0);
                                    viewHolder.f153001c.setImageDrawable(iVar3.getIcon());
                                }
                            }
                        });
                        viewHolder.f153001c.setAlpha(255);
                        ImageView imageView8 = viewHolder.f153003e;
                        if (imageView8 != null) {
                            imageView8.setAlpha(255);
                        }
                        MMBottomSheet.K(MMBottomSheet.this);
                        if (MMBottomSheet.this.O.booleanValue() || MMBottomSheet.this.L0) {
                            viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.anl));
                        } else if (MMBottomSheet.this.f152939e0) {
                            viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.b9x));
                        } else {
                            viewHolder.f152999a.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.b9v));
                        }
                    }
                    if (viewHolder.f153000b != null) {
                        if (iVar2.a() != null) {
                            viewHolder.f153000b.setVisibility(0);
                            viewHolder.f153000b.setText(iVar2.a());
                            if (iVar2.b() != 0) {
                                viewHolder.f153000b.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(iVar2.b()));
                            }
                        } else {
                            i17 = 8;
                            viewHolder.f153000b.setVisibility(8);
                            if (MMBottomSheet.this.f152935c0) {
                                if (!iVar2.c()) {
                                    viewHolder.f153000b.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.b9x));
                                    i18 = 0;
                                    viewHolder.f153004f.setVisibility(0);
                                    if (MMBottomSheet.this.G0 == i3) {
                                        viewHolder.f153004f.setChecked(true);
                                    } else {
                                        viewHolder.f153004f.setChecked(false);
                                    }
                                } else {
                                    viewHolder.f153004f.setVisibility(i17);
                                    viewHolder.f153000b.setTextColor(MMBottomSheet.this.f152938e.getResources().getColor(R.color.b9w));
                                    i18 = 0;
                                }
                                viewHolder.f153005g.setVisibility(i18);
                            }
                            if (viewHolder.f153002d != null) {
                                MMBottomSheet.L(MMBottomSheet.this);
                                viewHolder.f153002d.setVisibility(8);
                            }
                        }
                    }
                    i17 = 8;
                    if (MMBottomSheet.this.f152935c0) {
                    }
                    if (viewHolder.f153002d != null) {
                    }
                }
            }
            if (!MMBottomSheet.this.f152937d0 || MMBottomSheet.this.K0) {
                return;
            }
            viewHolder.f153001c.setVisibility(8);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new ViewHolder(MMBottomSheet.this.f152965w0 == 0 ? LayoutInflater.from(MMBottomSheet.this.f152938e).inflate(R.layout.fjv, viewGroup, false) : MMBottomSheet.this.f152965w0 == 2 ? LayoutInflater.from(MMBottomSheet.this.f152938e).inflate(R.layout.fjw, viewGroup, false) : LayoutInflater.from(MMBottomSheet.this.f152938e).inflate(R.layout.fjx, viewGroup, false));
        }
    }

    public MMBottomSheet(Context context, int i3, boolean z16) {
        this(context, i3, z16, new MMBottomSheetInitConfig());
    }

    public static /* synthetic */ k A(MMBottomSheet mMBottomSheet) {
        mMBottomSheet.getClass();
        return null;
    }

    public static /* synthetic */ l B(MMBottomSheet mMBottomSheet) {
        mMBottomSheet.getClass();
        return null;
    }

    public static /* synthetic */ m D(MMBottomSheet mMBottomSheet) {
        mMBottomSheet.getClass();
        return null;
    }

    public static /* synthetic */ s I(MMBottomSheet mMBottomSheet) {
        mMBottomSheet.getClass();
        return null;
    }

    public static /* synthetic */ m K(MMBottomSheet mMBottomSheet) {
        mMBottomSheet.getClass();
        return null;
    }

    public static /* synthetic */ j L(MMBottomSheet mMBottomSheet) {
        mMBottomSheet.getClass();
        return null;
    }

    public static /* synthetic */ k O(MMBottomSheet mMBottomSheet) {
        mMBottomSheet.getClass();
        return null;
    }

    public static /* synthetic */ j P(MMBottomSheet mMBottomSheet) {
        mMBottomSheet.getClass();
        return null;
    }

    public static /* synthetic */ w T(MMBottomSheet mMBottomSheet) {
        mMBottomSheet.getClass();
        return null;
    }

    public static void addInLandscapeAdjustMap(Class<? extends Activity> cls) {
        if (!U0.contains(cls)) {
            U0.add(cls);
        }
    }

    public static /* synthetic */ t o(MMBottomSheet mMBottomSheet) {
        mMBottomSheet.getClass();
        return null;
    }

    public static /* synthetic */ q x(MMBottomSheet mMBottomSheet) {
        mMBottomSheet.getClass();
        return null;
    }

    public void addItem(h hVar, u uVar) {
        this.J = hVar;
        this.f152952l = uVar;
    }

    public void addItem2MainOnly(h hVar, u uVar, m mVar) {
        this.O0 = true;
        this.J = hVar;
        this.f152952l = uVar;
        a(hVar);
    }

    public boolean available() {
        Context context = this.f152938e;
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        if (((Activity) context).isFinishing() || ((Activity) this.f152938e).isDestroyed()) {
            return false;
        }
        return true;
    }

    public void customMoreIcon(@NonNull MoreShareCallBack moreShareCallBack, @NonNull String str, @Nullable k kVar, @Nullable j jVar, @Nullable w wVar) {
        this.f152933b0 = true;
        this.F = moreShareCallBack;
        this.P0 = true;
        this.R0 = str;
        a(wVar);
    }

    public void dismissDestroy(boolean z16) {
        this.B0 = z16;
    }

    public void enableMoreIconClick(boolean z16) {
        this.Q0 = z16;
    }

    public int getBottomSheetStyle() {
        return this.f152965w0;
    }

    public Dialog getDialog() {
        return this.f152936d;
    }

    public boolean getHasTitle() {
        return this.f152966x0;
    }

    public MMBottomSheetInitConfig getInitConfig() {
        return this.S0;
    }

    public int getMaxVisibleItemCount() {
        LinearLayoutManager linearLayoutManager;
        int width;
        View childAt;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.f152939e0) {
            RecyclerView recyclerView = this.mZeroRecyclerView;
            if (recyclerView != null) {
                linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            } else {
                RecyclerView recyclerView2 = this.f152943g0;
                if (recyclerView2 != null) {
                    linearLayoutManager = (LinearLayoutManager) recyclerView2.getLayoutManager();
                } else {
                    RecyclerView recyclerView3 = this.f152945h0;
                    if (recyclerView3 != null) {
                        linearLayoutManager = (LinearLayoutManager) recyclerView3.getLayoutManager();
                    }
                }
            }
            if (linearLayoutManager != null && (width = linearLayoutManager.getWidth()) != 0 && (childAt = linearLayoutManager.getChildAt(0)) != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams()) != null) {
                return width / (childAt.getWidth() + marginLayoutParams.leftMargin);
            }
        }
        return 0;
    }

    @Nullable
    public View getRootView() {
        return this.N;
    }

    public TextView getTitleTextView() {
        return this.f152961s0;
    }

    public View getView() {
        tryShow();
        ViewGroup.LayoutParams layoutParams = this.N.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        ViewParent parent = this.N.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.N);
        }
        return this.N;
    }

    public Window getWindow() {
        Dialog dialog = this.f152936d;
        if (dialog != null) {
            return dialog.getWindow();
        }
        return null;
    }

    public h getmMenu() {
        return this.I;
    }

    public void hideCancelBtn(boolean z16) {
        LinearLayout linearLayout = this.R;
        if (linearLayout == null) {
            return;
        }
        if (z16) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
        }
    }

    @MainThread
    public void hideDefaultZeroMenuTitleView() {
        TextView textView = this.f152941f0;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void hideNavigationFullScreen(boolean z16) {
        this.D0 = z16;
    }

    public void hideStatusBar(boolean z16) {
        this.f152968z0 = z16;
    }

    public void hideTextTitleView(boolean z16) {
        LinearLayout linearLayout = this.P;
        if (linearLayout == null) {
            return;
        }
        if (z16) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
        }
    }

    public void initSelectedItem(int i3) {
        this.G0 = i3;
    }

    public boolean isDarkBg() {
        return this.O.booleanValue();
    }

    public boolean isHideNavigationFullScreen() {
        return this.D0;
    }

    public boolean isHideStatusBar() {
        return this.f152968z0;
    }

    public boolean isLightStatusBar() {
        return this.f152967y0;
    }

    public boolean isShowing() {
        Dialog dialog = this.f152936d;
        if (dialog != null && dialog.isShowing()) {
            return true;
        }
        return false;
    }

    public void moreIconShow(boolean z16, MoreShareCallBack moreShareCallBack) {
        this.f152933b0 = z16;
        this.F = moreShareCallBack;
    }

    public void notifyChange() {
        RecycleViewAdapter recycleViewAdapter;
        if (this.f152936d != null) {
            this.C0 = false;
            if (this.J != null && (recycleViewAdapter = this.Y) != null) {
                recycleViewAdapter.notifyDataSetChanged();
            }
            RecycleViewAdapter recycleViewAdapter2 = this.Z;
            if (recycleViewAdapter2 != null) {
                recycleViewAdapter2.notifyDataSetChanged();
            }
            RecycleViewAdapter recycleViewAdapter3 = this.f152931a0;
            if (recycleViewAdapter3 != null) {
                if (recycleViewAdapter3.getItemCount() == 0) {
                    a(8);
                }
                this.f152931a0.notifyDataSetChanged();
            }
            this.f152936d.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.14
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    RecyclerView recyclerView;
                    MMBottomSheet mMBottomSheet = MMBottomSheet.this;
                    if (mMBottomSheet.f152932b != null && !mMBottomSheet.C0) {
                        MMBottomSheet.this.f152932b.onShow();
                    }
                    MMBottomSheet mMBottomSheet2 = MMBottomSheet.this;
                    if (mMBottomSheet2.f152934c != null && !mMBottomSheet2.C0 && (recyclerView = MMBottomSheet.this.mZeroRecyclerView) != null && recyclerView.getVisibility() == 0) {
                        MMBottomSheet.this.f152934c.onShow();
                    }
                }
            });
            if (this.f152930a != null) {
                this.f152936d.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.15
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (!MMBottomSheet.this.C0) {
                            MMBottomSheet.this.f152930a.onDismiss();
                        }
                    }
                });
            } else {
                this.f152936d.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.16
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        MMBottomSheet.this.g();
                        if (!MMBottomSheet.this.B0) {
                            MMBottomSheet.this.f152936d = null;
                        }
                    }
                });
            }
            if (this.S0.getIsNeedShowDialog()) {
                this.f152936d.show();
            }
        }
    }

    public void notifyMenuItemInsert(int i3) {
        int size = this.I.size();
        RecycleViewAdapter recycleViewAdapter = this.Y;
        if (recycleViewAdapter != null && i3 >= 0 && i3 < size) {
            recycleViewAdapter.notifyItemInserted(i3);
        }
    }

    public void observerMoreShareClick(MoreShareCallBack moreShareCallBack) {
        this.G = moreShareCallBack;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.f152955m0;
            if (view != null && (view.isShown() || view.getVisibility() == 0)) {
                if (isShowing()) {
                    if (this.f152951k0 != d() || this.f152953l0 != b()) {
                        tryHide();
                        return;
                    }
                    return;
                }
                return;
            }
            tryHide();
        }
    }

    public void releaseContext() {
        Dialog dialog = this.f152936d;
        if (dialog != null) {
            dialog.setCancelMessage(null);
            this.f152936d.setDismissMessage(null);
            this.f152936d.setOnShowListener(null);
            setOnBottomSheetShowListener(null);
            setCancelBtnClickListener(null);
            setOnBottomSheetDismissListener(null);
        }
        this.f152938e = null;
    }

    public void scrollMenuToPosition(int i3) {
        RecyclerView.SmoothScroller smoothScroller;
        RecyclerView recyclerView = this.f152943g0;
        if (recyclerView != null && recyclerView.getLayoutManager() != null && (smoothScroller = this.M0) != null) {
            smoothScroller.setTargetPosition(i3);
            this.f152943g0.getLayoutManager().startSmoothScroll(this.M0);
        }
    }

    public void setBackgroundColor(@ColorInt int i3) {
        ImageView imageView;
        View view = this.N;
        if (view != null) {
            view.setBackgroundColor(i3);
        }
        Boolean valueOf = Boolean.valueOf(com.tencent.luggage.wxa.lo.m.a(i3));
        this.O = valueOf;
        if (valueOf.booleanValue() && (imageView = this.f152957o0) != null) {
            imageView.setImageDrawable(this.f152938e.getResources().getDrawable(R.color.bgl));
        }
    }

    public void setBackgroundDimAmount(float f16) {
        Dialog dialog = this.f152936d;
        if (dialog != null && dialog.getWindow() != null) {
            this.f152936d.getWindow().setDimAmount(f16);
        }
    }

    public void setCancelBtnClickListener(CancelBtnCallBack cancelBtnCallBack) {
        this.H = cancelBtnCallBack;
    }

    public void setCancelBtnText(String str) {
        TextView textView;
        if (this.R != null && (textView = this.W) != null) {
            textView.setText(str);
        }
    }

    public void setCancelBtnTextColor(int i3) {
        TextView textView;
        if (this.R != null && (textView = this.W) != null) {
            textView.setTextColor(i3);
        }
    }

    public void setCancelOutSize(boolean z16) {
        Dialog dialog = this.f152936d;
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(z16);
            this.f152936d.setCancelable(z16);
            Dialog dialog2 = this.f152936d;
            if (dialog2 instanceof NewBottomSheetDialog) {
                ((NewBottomSheetDialog) dialog2).setWindowCloseOnTouchOutside(z16);
            }
        }
    }

    @MainThread
    public void setDefaultZeroMenuTitleView(@StringRes int i3) {
        if (this.mZeroLayoutContainer == null) {
            c();
        }
        if (this.f152941f0 == null) {
            this.f152941f0 = (TextView) this.N.findViewById(R.id.f126037no);
        }
        TextView textView = this.f152941f0;
        if (textView != null) {
            textView.setVisibility(0);
            this.f152941f0.setText(i3);
            if (this.L0) {
                this.f152941f0.setTextColor(this.f152938e.getResources().getColor(R.color.anp));
            } else {
                this.f152941f0.setTextColor(this.f152938e.getResources().getColor(R.color.ar9));
            }
        }
    }

    public void setFooterView(View view) {
        LinearLayout linearLayout = this.Q;
        if (linearLayout != null) {
            if (view == null) {
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.setVisibility(0);
            this.Q.removeAllViews();
            this.Q.setGravity(17);
            this.Q.addView(view, -1, -2);
        }
    }

    public void setItemsOnlyAdded2Main(boolean z16) {
        this.O0 = z16;
    }

    @TargetApi(23)
    public void setLightStatusBar(boolean z16) {
        this.f152967y0 = z16;
    }

    public void setNewLandscapeMaxWidth(int i3) {
        this.J0 = i3;
    }

    public void setNewLandscapeTitleHeight(int i3) {
        this.I0 = i3;
    }

    public void setOnBottomSheetDismissListener(IDismissCallBack iDismissCallBack) {
        this.f152930a = iDismissCallBack;
    }

    public void setOnBottomSheetShowListener(IShowCallBack iShowCallBack) {
        this.f152932b = iShowCallBack;
    }

    public void setOnBottomSheetZeroRecyclerViewShowListener(IZeroRecyclerViewShowCallBack iZeroRecyclerViewShowCallBack) {
        this.f152934c = iZeroRecyclerViewShowCallBack;
    }

    public void setOnCreateFooterMenuListener(p pVar) {
        this.f152948j = pVar;
    }

    public void setOnCreateHeaderMenuListener(p pVar) {
        this.f152946i = pVar;
    }

    public void setOnCreateMenuListener(p pVar) {
        this.f152940f = pVar;
    }

    public void setOnCreateSecondMenuListener(p pVar) {
        this.f152942g = pVar;
    }

    public void setOnFooterMenuSelectedListener(u uVar) {
        this.E = uVar;
    }

    public void setOnHeaderMenuSelectedListener(u uVar) {
        this.D = uVar;
    }

    public void setOnMenuSelectedListener(u uVar) {
        this.f152950k = uVar;
    }

    public void setOnSecondMenuSelectedListener(u uVar) {
        this.f152954m = uVar;
    }

    public void setOnZeroMenuSelectedListener(u uVar) {
        this.C = uVar;
    }

    public void setOnZeroSecondMenuListener(p pVar) {
        this.f152944h = pVar;
    }

    public void setSimpleTextTitleView(CharSequence charSequence, int i3) {
        LinearLayout linearLayout = this.P;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.P.removeAllViews();
            this.P.setGravity(i3);
            View inflate = LayoutInflater.from(this.f152938e).inflate(R.layout.fjy, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.f166992jq2);
            textView.setText(charSequence);
            textView.setGravity(i3 | 80);
            if (this.L0) {
                textView.setTextColor(this.f152938e.getResources().getColor(R.color.anp));
            }
            this.P.addView(inflate, -1, -2);
        }
    }

    public void setTextTitleView(CharSequence charSequence, int i3) {
        setTextTitleView(charSequence, i3, 0);
    }

    public void setTitleTextViewPaddingBottom(int i3) {
        TextView textView = this.f152961s0;
        if (textView != null) {
            textView.setPadding(textView.getPaddingLeft(), this.f152961s0.getPaddingTop(), this.f152961s0.getPaddingRight(), i3);
        }
    }

    public void setTitleView(View view) {
        setTitleView(view, false);
    }

    public MMBottomSheet showAlwaysDark(boolean z16) {
        this.L0 = z16;
        View view = this.N;
        if (view != null) {
            if (z16) {
                if (this.f152965w0 == 0) {
                    view.setBackgroundResource(R.drawable.m0o);
                    TextView textView = this.W;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    TextView textView2 = this.X;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                } else {
                    view.setBackgroundResource(R.drawable.m0m);
                    TextView textView3 = this.W;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                    TextView textView4 = this.X;
                    if (textView4 != null) {
                        textView4.setVisibility(8);
                    }
                }
                this.V.setBackgroundColor(this.f152938e.getResources().getColor(R.color.aqq));
                this.W.setTextColor(this.f152938e.getResources().getColor(R.color.anp));
                this.W.setBackgroundResource(R.drawable.jkg);
                this.X.setTextColor(this.f152938e.getResources().getColor(R.color.anp));
                this.X.setBackgroundResource(R.drawable.jkg);
                ImageView imageView = this.f152958p0;
                if (imageView != null) {
                    imageView.setBackgroundColor(this.f152938e.getResources().getColor(R.color.akk));
                }
                ImageView imageView2 = this.f152959q0;
                if (imageView2 != null) {
                    imageView2.setBackgroundColor(this.f152938e.getResources().getColor(R.color.akk));
                }
                TextView textView5 = this.f152941f0;
                if (textView5 != null) {
                    textView5.setTextColor(this.f152938e.getResources().getColor(R.color.anp));
                }
            } else {
                view.setBackgroundResource(R.drawable.m0p);
                TextView textView6 = this.f152941f0;
                if (textView6 != null) {
                    textView6.setTextColor(this.f152938e.getResources().getColor(R.color.ar9));
                }
            }
        }
        return this;
    }

    public void showBottomSheetAlways(boolean z16) {
        this.A0 = z16;
    }

    public void showIconAlways(boolean z16) {
        this.E0 = z16;
    }

    public MMBottomSheet showIconInListStyle(boolean z16) {
        this.K0 = z16;
        return this;
    }

    public void showTitleDividerAlways(boolean z16) {
        this.F0 = z16;
    }

    public void showZeroMenuView() {
        if (this.zeroLineMenu.size() > 0 && this.mZeroLayoutContainer == null) {
            c();
            a(0);
        }
    }

    public void tryHide() {
        com.tencent.luggage.wxa.lo.n.c("MicroMsg.MMBottomSheet", "tryHide mBottomSheetDialog:%s, mBehavior:%s, mContext:%s", this.f152936d, this.f152949j0, this.f152938e);
        if (this.f152936d != null) {
            BottomSheetBehavior bottomSheetBehavior = this.f152949j0;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(true);
            }
            if (this.f152938e instanceof Activity) {
                com.tencent.luggage.wxa.lo.n.c("MicroMsg.MMBottomSheet", " cannot dismiss !", new Object[0]);
                Context context = this.f152938e;
                if (context != null && !((Activity) context).isFinishing() && !((Activity) this.f152938e).isDestroyed()) {
                    this.f152936d.dismiss();
                    return;
                }
                return;
            }
            this.f152936d.dismiss();
        }
    }

    public void tryShow() {
        RecycleViewAdapter recycleViewAdapter;
        boolean z16;
        View view;
        View view2;
        boolean z17 = false;
        this.C0 = false;
        this.f152951k0 = d();
        this.f152953l0 = b();
        p pVar = this.f152940f;
        if (pVar != null) {
            pVar.a(this.I);
        }
        p pVar2 = this.f152942g;
        if (pVar2 != null) {
            pVar2.a(this.K);
        }
        p pVar3 = this.f152944h;
        if (pVar3 != null) {
            pVar3.a(this.zeroLineMenu);
            if (this.zeroLineMenu.size() > 0 && this.mZeroLayoutContainer == null) {
                c();
            }
        }
        p pVar4 = this.f152946i;
        if (pVar4 != null) {
            pVar4.a(this.L);
        }
        p pVar5 = this.f152948j;
        if (pVar5 != null) {
            pVar5.a(this.M);
        }
        if (this.f152936d != null) {
            e();
            if (this.f152939e0) {
                if (this.K.size() > 0) {
                    this.f152958p0.setVisibility(8);
                    this.f152945h0.setVisibility(0);
                }
                this.f152959q0.setVisibility(0);
                View view3 = this.V;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
                TextView textView = this.W;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                TextView textView2 = this.X;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                if (this.zeroLineMenu.size() > 0) {
                    a(0);
                    View view4 = this.V;
                    if (view4 != null) {
                        view4.setVisibility(8);
                    }
                }
                int size = this.L.size();
                int i3 = R.id.z3o;
                if (size > 0) {
                    LinearLayout linearLayout = this.P;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                        this.P.removeAllViews();
                        this.P.setGravity(17);
                    }
                    View inflate = View.inflate(this.f152938e, R.layout.e0p, null);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.eq9);
                    final int i16 = 0;
                    while (i16 < this.L.size()) {
                        i iVar = (i) this.L.getItemList().get(i16);
                        if (iVar.i()) {
                            view2 = View.inflate(this.f152938e, R.layout.e0m, null);
                        } else {
                            View inflate2 = View.inflate(this.f152938e, R.layout.e0o, null);
                            WeImageView weImageView = (WeImageView) inflate2.findViewById(R.id.z5x);
                            TextView textView3 = (TextView) inflate2.findViewById(R.id.eqi);
                            TextView textView4 = (TextView) inflate2.findViewById(i3);
                            weImageView.setImageDrawable(iVar.getIcon());
                            weImageView.setIconColor(iVar.d());
                            textView3.setText(iVar.getTitle());
                            if (iVar.a() != null) {
                                textView4.setVisibility(0);
                                textView4.setText(iVar.a());
                            }
                            inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.9
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view5) {
                                    if (MMBottomSheet.this.D != null && i16 < MMBottomSheet.this.L.size()) {
                                        MMBottomSheet.this.D.a(MMBottomSheet.this.L.getItem(i16), i16);
                                    }
                                    if (!MMBottomSheet.this.A0) {
                                        MMBottomSheet.this.tryHide();
                                    }
                                }
                            });
                            view2 = inflate2;
                        }
                        linearLayout2.addView(view2);
                        i16++;
                        i3 = R.id.z3o;
                    }
                    this.P.addView(inflate);
                }
                if (this.M.size() > 0) {
                    LinearLayout linearLayout3 = this.S;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(0);
                        this.S.removeAllViews();
                        this.S.setGravity(17);
                    }
                    View inflate3 = View.inflate(this.f152938e, R.layout.e0l, null);
                    LinearLayout linearLayout4 = (LinearLayout) inflate3.findViewById(R.id.eq9);
                    for (final int i17 = 0; i17 < this.M.size(); i17++) {
                        i iVar2 = (i) this.M.getItemList().get(i17);
                        if (iVar2.i()) {
                            view = View.inflate(this.f152938e, R.layout.e0j, null);
                        } else {
                            View inflate4 = View.inflate(this.f152938e, R.layout.e0k, null);
                            WeImageView weImageView2 = (WeImageView) inflate4.findViewById(R.id.z5x);
                            TextView textView5 = (TextView) inflate4.findViewById(R.id.eqi);
                            TextView textView6 = (TextView) inflate4.findViewById(R.id.z3o);
                            weImageView2.setImageDrawable(iVar2.getIcon());
                            weImageView2.setIconColor(iVar2.d());
                            textView5.setText(iVar2.getTitle());
                            if (iVar2.a() != null) {
                                textView6.setVisibility(0);
                                textView6.setText(iVar2.a());
                            }
                            inflate4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.10
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view5) {
                                    if (MMBottomSheet.this.E != null && i17 < MMBottomSheet.this.M.size()) {
                                        MMBottomSheet.this.E.a(MMBottomSheet.this.M.getItem(i17), i17);
                                    }
                                    if (!MMBottomSheet.this.A0) {
                                        MMBottomSheet.this.tryHide();
                                    }
                                }
                            });
                            view = inflate4;
                        }
                        linearLayout4.addView(view);
                    }
                    LinearLayout linearLayout5 = this.S;
                    if (linearLayout5 != null) {
                        linearLayout5.addView(inflate3);
                    }
                } else {
                    LinearLayout linearLayout6 = this.S;
                    if (linearLayout6 != null) {
                        linearLayout6.setVisibility(8);
                    }
                }
                int c16 = o.c(this.f152938e, R.dimen.cbv);
                int c17 = o.c(this.f152938e, R.dimen.bht);
                if ((this.f152966x0 && this.P.getVisibility() == 0) || this.zeroLineMenu.size() > 0) {
                    c16 = o.a(this.f152938e, 0);
                }
                RecyclerView recyclerView = this.f152943g0;
                recyclerView.setPadding(recyclerView.getPaddingLeft(), c16, this.f152943g0.getPaddingRight(), this.f152943g0.getPaddingBottom());
                LinearLayout linearLayout7 = this.S;
                if (linearLayout7 != null && linearLayout7.getVisibility() == 0) {
                    LinearLayout linearLayout8 = this.S;
                    linearLayout8.setPadding(0, linearLayout8.getPaddingTop(), this.S.getPaddingRight(), c17);
                    RecyclerView recyclerView2 = this.f152945h0;
                    recyclerView2.setPadding(recyclerView2.getPaddingLeft(), this.f152945h0.getPaddingTop(), this.f152945h0.getPaddingRight(), c17);
                } else if (d()) {
                    RecyclerView recyclerView3 = this.f152945h0;
                    recyclerView3.setPadding(recyclerView3.getPaddingLeft(), this.f152945h0.getPaddingTop(), this.f152945h0.getPaddingRight(), c17);
                } else {
                    RecyclerView recyclerView4 = this.f152945h0;
                    recyclerView4.setPadding(recyclerView4.getPaddingLeft(), this.f152945h0.getPaddingTop(), this.f152945h0.getPaddingRight(), this.f152945h0.getPaddingBottom());
                }
                RecyclerView recyclerView5 = this.mZeroRecyclerView;
                if (recyclerView5 != null) {
                    recyclerView5.setPadding(recyclerView5.getPaddingLeft(), 0, this.mZeroRecyclerView.getPaddingRight(), this.mZeroRecyclerView.getPaddingBottom());
                }
                this.T.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                if (this.T.getChildAt(0) != null && this.f152955m0 != null) {
                    Rect rect = new Rect();
                    this.f152955m0.getWindowVisibleDisplayFrame(rect);
                    if (this.T.getChildAt(0).getMeasuredHeight() + o.c(this.f152938e, R.dimen.biw) > rect.bottom) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        this.U.setVisibility(0);
                    }
                }
            } else {
                this.f152943g0.setPadding(0, 0, 0, 0);
            }
            if (this.J != null && (recycleViewAdapter = this.Y) != null) {
                recycleViewAdapter.notifyDataSetChanged();
            }
            RecycleViewAdapter recycleViewAdapter2 = this.Z;
            if (recycleViewAdapter2 != null) {
                recycleViewAdapter2.notifyDataSetChanged();
            }
            RecycleViewAdapter recycleViewAdapter3 = this.f152931a0;
            if (recycleViewAdapter3 != null) {
                recycleViewAdapter3.notifyDataSetChanged();
            }
            this.f152936d.getWindow().addFlags(Integer.MIN_VALUE);
            if (this.f152967y0) {
                f();
            }
            if (this.f152968z0) {
                this.f152936d.getWindow().addFlags(1024);
            }
            if (this.D0) {
                this.f152936d.getWindow().setFlags(8, 8);
                this.f152936d.getWindow().addFlags(131200);
                this.f152936d.getWindow().getDecorView().setSystemUiVisibility(4102);
            } else {
                this.f152936d.getWindow().clearFlags(8);
                this.f152936d.getWindow().clearFlags(131072);
                this.f152936d.getWindow().clearFlags(128);
                this.f152936d.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            BottomSheetBehavior bottomSheetBehavior = this.f152949j0;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(false);
            }
            if (this.f152930a != null) {
                this.f152936d.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.11
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        MMBottomSheet mMBottomSheet = MMBottomSheet.this;
                        if (mMBottomSheet.f152930a != null && !mMBottomSheet.C0) {
                            MMBottomSheet.this.f152930a.onDismiss();
                        }
                        if (MMBottomSheet.this.f152936d != null) {
                            DialogLeakFix.clearReferencesOnDismiss(MMBottomSheet.this.f152936d);
                        }
                    }
                });
            }
            this.f152936d.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.12
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    RecyclerView recyclerView6;
                    MMBottomSheet mMBottomSheet = MMBottomSheet.this;
                    if (mMBottomSheet.f152932b != null && !mMBottomSheet.C0) {
                        MMBottomSheet.this.f152932b.onShow();
                    }
                    MMBottomSheet mMBottomSheet2 = MMBottomSheet.this;
                    if (mMBottomSheet2.f152934c != null && !mMBottomSheet2.C0 && (recyclerView6 = MMBottomSheet.this.mZeroRecyclerView) != null && recyclerView6.getVisibility() == 0) {
                        MMBottomSheet.this.f152934c.onShow();
                    }
                }
            });
            View view5 = this.f152955m0;
            if (view5 != null) {
                if (this.f152956n0 == null) {
                    z17 = true;
                }
                ViewTreeObserver viewTreeObserver = view5.getViewTreeObserver();
                this.f152956n0 = viewTreeObserver;
                if (z17) {
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                    Object obj = this.f152938e;
                    if (obj instanceof LifecycleOwner) {
                        ((LifecycleOwner) obj).getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.13
                            @Override // androidx.lifecycle.LifecycleEventObserver
                            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                                if (event == Lifecycle.Event.ON_DESTROY) {
                                    MMBottomSheet.this.g();
                                    lifecycleOwner.getLifecycle().removeObserver(this);
                                }
                            }
                        });
                    }
                }
            }
            Context context = this.f152938e;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && this.S0.getIsNeedShowDialog()) {
                if (this.f152951k0 && a(((Activity) this.f152938e).getClass())) {
                    a(this.f152938e);
                }
                this.f152936d.show();
            }
        }
    }

    public MMBottomSheet(Context context, int i3, boolean z16, MMBottomSheetInitConfig mMBottomSheetInitConfig) {
        this.O = Boolean.FALSE;
        this.f152933b0 = false;
        this.f152935c0 = false;
        this.f152937d0 = false;
        this.f152939e0 = false;
        this.f152951k0 = false;
        this.f152962t0 = 4;
        this.f152963u0 = 12;
        this.f152964v0 = 6;
        this.A0 = false;
        this.B0 = false;
        this.C0 = false;
        this.D0 = false;
        this.E0 = false;
        this.G0 = 0;
        this.H0 = false;
        this.I0 = 0;
        this.J0 = 0;
        this.K0 = false;
        this.L0 = false;
        this.M0 = null;
        this.N0 = null;
        this.O0 = false;
        this.P0 = false;
        this.Q0 = true;
        this.R0 = null;
        this.T0 = false;
        this.f152965w0 = i3;
        this.f152938e = context;
        this.f152966x0 = z16;
        this.F0 = false;
        this.S0 = mMBottomSheetInitConfig;
        if (context instanceof Activity) {
            this.f152955m0 = ((ViewGroup) ((Activity) context).getWindow().getDecorView()).findViewById(android.R.id.content);
        }
        b(this.f152938e);
    }

    public final int b() {
        Context context = this.f152938e;
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        return 0;
    }

    public final void c() {
        com.tencent.luggage.wxa.lo.n.c("MicroMsg.MMBottomSheet", "initZeroMenuView!!", new Object[0]);
        this.mZeroLayoutContainer = (ViewGroup) this.mZeroLayoutStub.inflate();
        ImageView imageView = (ImageView) this.N.findViewById(R.id.f126027nn);
        this.f152960r0 = imageView;
        if (this.L0) {
            imageView.setBackgroundColor(this.f152938e.getResources().getColor(R.color.akk));
        }
        RecyclerView recyclerView = (RecyclerView) this.N.findViewById(R.id.tav);
        this.mZeroRecyclerView = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.N0 = a(this.mZeroRecyclerView);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(true);
        this.f152931a0 = recycleViewAdapter;
        recycleViewAdapter.setMenu(this.zeroLineMenu);
        this.f152931a0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                if (i3 >= MMBottomSheet.this.zeroLineMenu.size()) {
                    return;
                }
                i iVar = (i) MMBottomSheet.this.zeroLineMenu.getItemList().get(i3);
                if (iVar != null && iVar.c()) {
                    return;
                }
                if (i3 < MMBottomSheet.this.zeroLineMenu.size() && MMBottomSheet.this.C != null) {
                    MMBottomSheet.this.C.a(MMBottomSheet.this.zeroLineMenu.getItem(i3), i3);
                }
                if (!MMBottomSheet.this.A0) {
                    MMBottomSheet.this.tryHide();
                }
                MMBottomSheet.this.C0 = true;
                MMBottomSheet.this.f152931a0.notifyDataSetChanged();
            }
        });
        this.f152931a0.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.7
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                if (i3 >= MMBottomSheet.this.zeroLineMenu.size()) {
                    return false;
                }
                i iVar = (i) MMBottomSheet.this.zeroLineMenu.getItemList().get(i3);
                if (iVar != null && iVar.c()) {
                    return false;
                }
                if (i3 < MMBottomSheet.this.zeroLineMenu.size()) {
                    MMBottomSheet.o(MMBottomSheet.this);
                }
                MMBottomSheet.this.f152931a0.notifyDataSetChanged();
                return false;
            }
        });
        this.mZeroRecyclerView.setAdapter(this.f152931a0);
        this.mZeroRecyclerView.setOverScrollMode(1);
        if (this.f152965w0 == 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f152938e);
            linearLayoutManager.setOrientation(0);
            this.mZeroRecyclerView.setLayoutManager(linearLayoutManager);
        }
    }

    public final boolean d() {
        Context context = this.f152938e;
        return context != null && context.getResources().getConfiguration().orientation == 2;
    }

    public final void e() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.N.getLayoutParams();
        this.I.size();
        if (!this.f152933b0 && this.J.size() > 0) {
            this.J.size();
        }
        if (this.f152951k0 && this.f152955m0 != null) {
            Rect rect = new Rect();
            this.f152955m0.getWindowVisibleDisplayFrame(rect);
            if (this.H0) {
                layoutParams.width = (int) ((rect.right * 1.0f) / 2.0f);
                int i3 = this.J0;
                if (i3 != 0) {
                    layoutParams.width = i3;
                }
                if (com.tencent.luggage.wxa.lo.q.g(this.f152938e)) {
                    layoutParams.height = rect.bottom - com.tencent.luggage.wxa.lo.q.f(this.f152938e);
                } else {
                    layoutParams.height = rect.bottom;
                }
            } else {
                layoutParams.width = Math.min(rect.right, rect.bottom);
                int i16 = this.J0;
                if (i16 != 0) {
                    layoutParams.width = i16;
                }
            }
        }
        this.N.setLayoutParams(layoutParams);
    }

    public final void f() {
        Dialog dialog = this.f152936d;
        if (dialog != null) {
            dialog.getWindow().getDecorView().setSystemUiVisibility(9216);
            this.f152936d.getWindow().setStatusBarColor(0);
        }
    }

    public void g() {
        ViewTreeObserver viewTreeObserver = this.f152956n0;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f152956n0 = this.f152955m0.getViewTreeObserver();
            }
            this.f152956n0.removeGlobalOnLayoutListener(this);
            this.f152956n0 = null;
        }
    }

    public void setTextTitleView(CharSequence charSequence, int i3, int i16) {
        LinearLayout linearLayout = this.P;
        if (linearLayout == null || !this.f152966x0) {
            return;
        }
        linearLayout.setVisibility(0);
        this.P.removeAllViews();
        this.P.setGravity(i3);
        View inflate = LayoutInflater.from(this.f152938e).inflate(R.layout.fjy, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.f166992jq2);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bmt);
        if (this.f152937d0) {
            imageView.setVisibility(0);
        }
        this.f152961s0 = textView;
        textView.setText(charSequence);
        if (i16 != 0) {
            textView.setTextSize(0, i16);
        }
        textView.setGravity(i3 | 80);
        if (this.L0) {
            textView.setTextColor(this.f152938e.getResources().getColor(R.color.anp));
            imageView.setBackgroundColor(this.f152938e.getResources().getColor(R.color.akk));
        }
        this.P.addView(inflate, -1, -2);
    }

    public void setTitleView(View view, int i3, boolean z16) {
        if (view == null) {
            return;
        }
        this.f152966x0 = true;
        ImageView imageView = this.f152957o0;
        if (imageView != null) {
            imageView.setVisibility(z16 ? 4 : 0);
        }
        LinearLayout linearLayout = this.P;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.P.removeAllViews();
            this.P.setGravity(17);
            this.P.addView(view, -1, -2);
        }
    }

    public final void b(Context context) {
        ImageView imageView;
        this.I = new h(context);
        this.J = new h(context);
        this.K = new h(context);
        this.zeroLineMenu = new h(context);
        this.L = new h(context);
        this.M = new h(context);
        if (this.H0) {
            this.f152936d = new CustomSheetDialog(context);
        } else {
            this.f152936d = new NewBottomSheetDialog(context, R.style.f173406a03);
        }
        View inflate = View.inflate(context, R.layout.fju, null);
        this.N = inflate;
        this.P = (LinearLayout) inflate.findViewById(R.id.tat);
        this.Q = (LinearLayout) this.N.findViewById(R.id.tam);
        this.R = (LinearLayout) this.N.findViewById(R.id.taj);
        this.V = this.N.findViewById(R.id.tlk);
        this.S = (LinearLayout) this.N.findViewById(R.id.tan);
        this.W = (TextView) this.N.findViewById(R.id.tll);
        this.X = (TextView) this.N.findViewById(R.id.tlm);
        this.T = (CustomScrollView) this.N.findViewById(R.id.u8i);
        this.U = this.N.findViewById(R.id.vrz);
        this.f152957o0 = (ImageView) this.N.findViewById(R.id.uh6);
        this.f152958p0 = (ImageView) this.N.findViewById(R.id.f166241z43);
        this.f152959q0 = (ImageView) this.N.findViewById(R.id.f166243z45);
        this.R.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MMBottomSheet.this.tryHide();
                if (MMBottomSheet.this.H != null) {
                    MMBottomSheet.this.H.onClick();
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.N.findViewById(R.id.taq);
        this.f152943g0 = recyclerView;
        recyclerView.setHasFixedSize(true);
        if (this.f152943g0.getItemAnimator() != null) {
            this.f152943g0.getItemAnimator().setAddDuration(100L);
        }
        RecyclerView recyclerView2 = (RecyclerView) this.N.findViewById(R.id.tas);
        this.f152945h0 = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        this.mZeroLayoutStub = (ViewStub) this.N.findViewById(R.id.taw);
        this.M0 = a(this.f152943g0);
        boolean d16 = d();
        this.f152951k0 = d16;
        int i3 = this.f152965w0;
        if (i3 == 0) {
            this.f152939e0 = true;
            if (d16) {
                this.f152962t0 = 7;
                this.f152963u0 = 14;
                this.f152947i0 = o.c(this.f152938e, R.dimen.bdr) + o.c(this.f152938e, R.dimen.cbv);
            } else {
                this.f152947i0 = o.c(this.f152938e, R.dimen.bdq) + o.c(this.f152938e, R.dimen.cbv);
            }
            if (this.f152966x0) {
                this.f152947i0 += o.c(this.f152938e, R.dimen.cbv);
            }
            this.R.setVisibility(0);
            if (this.N != null) {
                if (this.H0 && d()) {
                    this.N.setBackgroundColor(this.f152938e.getResources().getColor(R.color.agt));
                } else {
                    this.N.setBackgroundResource(R.drawable.m0n);
                }
            }
            this.T.setOnScrollChangeListener(new CustomScrollView.a() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.2
                @Override // com.tencent.mm.ui.base.CustomScrollView.a
                public void onScrollChange(ScrollView scrollView, int i16, int i17, int i18, int i19) {
                    if (scrollView.getChildAt(0).getMeasuredHeight() - (scrollView.getHeight() + scrollView.getScrollY()) < 50) {
                        MMBottomSheet.this.U.setVisibility(8);
                    } else {
                        MMBottomSheet.this.U.setVisibility(0);
                    }
                }
            });
        } else if (i3 == 2) {
            this.f152935c0 = true;
            int c16 = o.c(this.f152938e, R.dimen.c5q);
            if (this.f152951k0) {
                this.f152964v0 = 2;
                this.f152947i0 = ((int) (c16 * 2.5d)) + o.c(this.f152938e, R.dimen.c5l);
            } else {
                this.f152964v0 = 3;
                this.f152947i0 = ((int) (c16 * 3.5d)) + o.c(this.f152938e, R.dimen.c5l);
            }
            if (this.f152966x0) {
                this.f152947i0 += o.a(this.f152938e, 88);
            }
        } else {
            this.f152937d0 = true;
            int c17 = o.c(this.f152938e, R.dimen.c5t);
            if (this.f152951k0) {
                this.f152964v0 = 4;
                this.f152947i0 = ((int) (c17 * 4.5d)) + o.c(this.f152938e, R.dimen.c5l);
            } else {
                this.f152964v0 = 6;
                this.f152947i0 = ((int) (c17 * 6.5d)) + o.c(this.f152938e, R.dimen.c5l);
            }
            if (this.f152966x0) {
                this.f152947i0 += o.c(this.f152938e, R.dimen.cbv);
            }
            LinearLayout linearLayout = this.R;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        }
        if (this.f152966x0 && (imageView = this.f152957o0) != null && this.F0) {
            imageView.setVisibility(0);
        }
        if (this.f152965w0 == 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f152938e);
            linearLayoutManager.setOrientation(0);
            this.f152943g0.setLayoutManager(linearLayoutManager);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.f152938e);
            linearLayoutManager2.setOrientation(0);
            this.f152945h0.setLayoutManager(linearLayoutManager2);
        } else {
            this.f152943g0.setLayoutManager(new LinearLayoutManager(this.f152938e));
        }
        this.f152943g0.setFocusable(false);
        this.f152943g0.setItemViewCacheSize(20);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(false);
        this.Y = recycleViewAdapter;
        recycleViewAdapter.setMenu(this.I);
        this.Y.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i16, long j3) {
                if (i16 < MMBottomSheet.this.I.size()) {
                    i iVar = (i) MMBottomSheet.this.I.getItemList().get(i16);
                    if (iVar != null && !iVar.c()) {
                        if (MMBottomSheet.this.f152950k != null) {
                            MMBottomSheet.this.f152950k.a(iVar, i16);
                        } else {
                            iVar.q();
                        }
                    } else {
                        return;
                    }
                } else if (MMBottomSheet.this.J.size() > 0 && i16 < MMBottomSheet.this.I.size() + MMBottomSheet.this.J.size()) {
                    i iVar2 = (i) MMBottomSheet.this.J.getItem(i16 - MMBottomSheet.this.I.size());
                    if (iVar2 != null && !iVar2.c()) {
                        if (MMBottomSheet.this.f152952l != null) {
                            MMBottomSheet.this.f152952l.a(iVar2, i16);
                        } else {
                            iVar2.q();
                        }
                    } else {
                        return;
                    }
                } else if (MMBottomSheet.this.Q0) {
                    MMBottomSheet.this.a();
                } else {
                    return;
                }
                if (!MMBottomSheet.this.A0) {
                    MMBottomSheet.this.tryHide();
                }
                MMBottomSheet.this.C0 = true;
                MMBottomSheet.this.G0 = i16;
                MMBottomSheet.this.Y.notifyDataSetChanged();
            }
        });
        this.f152943g0.setAdapter(this.Y);
        this.f152943g0.setOverScrollMode(1);
        RecycleViewAdapter recycleViewAdapter2 = new RecycleViewAdapter(true);
        this.Z = recycleViewAdapter2;
        recycleViewAdapter2.setMenu(this.K);
        this.Z.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i16, long j3) {
                if (i16 >= MMBottomSheet.this.K.size()) {
                    return;
                }
                i iVar = (i) MMBottomSheet.this.K.getItemList().get(i16);
                if (iVar != null && iVar.c()) {
                    return;
                }
                if (i16 < MMBottomSheet.this.K.size() && MMBottomSheet.this.f152954m != null) {
                    MMBottomSheet.this.f152954m.a(MMBottomSheet.this.K.getItem(i16), i16);
                }
                if (!MMBottomSheet.this.A0) {
                    MMBottomSheet.this.tryHide();
                }
                MMBottomSheet.this.C0 = true;
                MMBottomSheet.this.Z.notifyDataSetChanged();
            }
        });
        this.f152945h0.setAdapter(this.Z);
        this.f152945h0.setOverScrollMode(1);
        Dialog dialog = this.f152936d;
        if (dialog != null) {
            dialog.setContentView(this.N);
        }
        Dialog dialog2 = this.f152936d;
        if (dialog2 != null) {
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (MMBottomSheet.this.f152956n0 != null) {
                        if (!MMBottomSheet.this.f152956n0.isAlive()) {
                            MMBottomSheet mMBottomSheet = MMBottomSheet.this;
                            mMBottomSheet.f152956n0 = mMBottomSheet.f152955m0.getViewTreeObserver();
                        }
                        MMBottomSheet.this.f152956n0.removeGlobalOnLayoutListener(MMBottomSheet.this);
                        MMBottomSheet.this.f152956n0 = null;
                    }
                    if (MMBottomSheet.this.f152936d != null) {
                        DialogLeakFix.clearReferencesOnDismiss(MMBottomSheet.this.f152936d);
                    }
                    if (!MMBottomSheet.this.B0) {
                        MMBottomSheet.this.f152936d = null;
                    }
                }
            });
        }
    }

    public final LinearSmoothScroller a(final RecyclerView recyclerView) {
        return new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.tencent.mm.ui.widget.dialog.MMBottomSheet.8
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 1.0f / displayMetrics.densityDpi;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i3) {
                RecyclerView recyclerView2 = recyclerView;
                if (recyclerView2 != null && recyclerView2.getLayoutManager() != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                    return ((LinearLayoutManager) MMBottomSheet.this.f152943g0.getLayoutManager()).computeScrollVectorForPosition(i3);
                }
                return super.computeScrollVectorForPosition(i3);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int getHorizontalSnapPreference() {
                return -1;
            }
        };
    }

    public final void a(w wVar) {
        RecyclerView recyclerView;
        if (this.T0 || (recyclerView = this.f152943g0) == null || wVar == null) {
            return;
        }
        recyclerView.addOnScrollListener(new MenuItemVisibleHelper());
        this.T0 = true;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class MenuItemVisibleHelper extends RecyclerView.OnScrollListener {
        MenuItemVisibleHelper() {
        }

        public final void a(RecyclerView recyclerView) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
                    i a16 = a(findFirstVisibleItemPosition);
                    if (a16 == null) {
                        if (findFirstVisibleItemPosition == MMBottomSheet.this.I.size() + MMBottomSheet.this.J.size()) {
                            MMBottomSheet.T(MMBottomSheet.this);
                        }
                    } else {
                        a16.h();
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            a(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            a(recyclerView);
        }

        public final i a(int i3) {
            if (i3 < 0) {
                return null;
            }
            if (i3 < MMBottomSheet.this.I.size()) {
                return (i) MMBottomSheet.this.I.getItemList().get(i3);
            }
            if (MMBottomSheet.this.J.size() <= 0 || i3 >= MMBottomSheet.this.I.size() + MMBottomSheet.this.J.size()) {
                return null;
            }
            return (i) MMBottomSheet.this.J.getItem(i3 - MMBottomSheet.this.I.size());
        }
    }

    public void setTitleView(View view, boolean z16) {
        if (view == null) {
            return;
        }
        this.f152966x0 = true;
        ImageView imageView = this.f152957o0;
        if (imageView != null) {
            imageView.setVisibility(z16 ? 4 : 0);
        }
        LinearLayout linearLayout = this.P;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.P.removeAllViews();
            this.P.setGravity(17);
            this.P.addView(view, -1, -2);
        }
    }

    public final void a(h hVar) {
        List<MenuItem> itemList;
        if (this.T0 || this.f152943g0 == null || hVar == null || (itemList = hVar.getItemList()) == null || itemList.isEmpty()) {
            return;
        }
        for (MenuItem menuItem : itemList) {
            if (menuItem instanceof i) {
                ((i) menuItem).h();
            }
        }
    }

    public final void a() {
        this.F.onClick();
        MoreShareCallBack moreShareCallBack = this.G;
        if (moreShareCallBack != null) {
            moreShareCallBack.onClick();
        }
    }

    public static boolean a(Class cls) {
        for (int i3 = 0; i3 < U0.size(); i3++) {
            if (((Class) U0.get(i3)).isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public final void a(Context context) {
        int min = Math.min(com.tencent.luggage.wxa.lo.q.b(context).y, com.tencent.luggage.wxa.lo.q.b(context).x);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.width = min;
            attributes.gravity = 1;
        }
        window.setAttributes(attributes);
    }

    public void setFooterMenuIconCreator(k kVar) {
    }

    public void setHeaderMenuIconCreator(k kVar) {
    }

    public void setIconBadgeCreator(@Nullable j jVar) {
    }

    public void setIconCreator(k kVar) {
    }

    public void setImageLoader(l lVar) {
    }

    public void setOnCreateMenuViewListener(q qVar) {
    }

    public void setOnGetViewlistener(s sVar) {
    }

    public void setOnZeroMenuLongSelectedListener(t tVar) {
    }

    public void setTitleCreator(m mVar) {
    }

    public final void a(int i3) {
        RecyclerView recyclerView = this.mZeroRecyclerView;
        if (recyclerView == null || this.mZeroLayoutContainer == null) {
            return;
        }
        recyclerView.setVisibility(i3);
        ImageView imageView = this.f152960r0;
        if (imageView != null) {
            if (i3 != 0) {
                this.mZeroLayoutContainer.setVisibility(4);
                this.f152960r0.setVisibility(4);
            } else {
                imageView.setVisibility(0);
                this.mZeroLayoutContainer.setVisibility(0);
            }
        }
    }

    public MMBottomSheet(Context context, boolean z16, int i3) {
        this(context, z16, i3, new MMBottomSheetInitConfig());
    }

    public MMBottomSheet(Context context, boolean z16, int i3, MMBottomSheetInitConfig mMBottomSheetInitConfig) {
        this.O = Boolean.FALSE;
        this.f152933b0 = false;
        this.f152935c0 = false;
        this.f152937d0 = false;
        this.f152939e0 = false;
        this.f152951k0 = false;
        this.f152962t0 = 4;
        this.f152963u0 = 12;
        this.f152964v0 = 6;
        this.A0 = false;
        this.B0 = false;
        this.C0 = false;
        this.D0 = false;
        this.E0 = false;
        this.F0 = false;
        this.G0 = 0;
        this.I0 = 0;
        this.J0 = 0;
        this.K0 = false;
        this.L0 = false;
        this.M0 = null;
        this.N0 = null;
        this.O0 = false;
        this.P0 = false;
        this.Q0 = true;
        this.R0 = null;
        this.T0 = false;
        this.f152965w0 = i3;
        this.f152938e = context;
        this.H0 = z16;
        this.S0 = mMBottomSheetInitConfig;
        if (context instanceof Activity) {
            this.f152955m0 = ((ViewGroup) ((Activity) context).getWindow().getDecorView()).findViewById(android.R.id.content);
        }
        b(this.f152938e);
    }
}
