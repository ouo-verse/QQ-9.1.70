package com.tencent.luggage.wxa.ub;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Vibrator;
import android.util.Property;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.luggage.wxa.jl.c;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements com.tencent.luggage.wxa.ml.m {

    /* renamed from: l0, reason: collision with root package name */
    public static final h f142177l0 = new h(null);
    public TextView C;
    public Button D;
    public Button E;
    public View F;
    public FrameLayout G;
    public View H;
    public View I;
    public TextView J;
    public TextView K;
    public View L;
    public CheckBox M;
    public TextView N;
    public View O;
    public List P;
    public boolean Q;
    public Integer R;
    public com.tencent.luggage.wxa.ml.r S;
    public i T;
    public Function0 U;
    public h.a V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a, reason: collision with root package name */
    public final Context f142178a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f142179a0;

    /* renamed from: b, reason: collision with root package name */
    public n f142180b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f142181b0;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f142182c;

    /* renamed from: c0, reason: collision with root package name */
    public String f142183c0;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f142184d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f142185d0;

    /* renamed from: e, reason: collision with root package name */
    public final o f142186e;

    /* renamed from: e0, reason: collision with root package name */
    public String f142187e0;

    /* renamed from: f, reason: collision with root package name */
    public View f142188f;

    /* renamed from: f0, reason: collision with root package name */
    public String f142189f0;

    /* renamed from: g, reason: collision with root package name */
    public FrameLayout f142190g;

    /* renamed from: g0, reason: collision with root package name */
    public String f142191g0;

    /* renamed from: h, reason: collision with root package name */
    public ScrollView f142192h;

    /* renamed from: h0, reason: collision with root package name */
    public String f142193h0;

    /* renamed from: i, reason: collision with root package name */
    public k f142194i;

    /* renamed from: i0, reason: collision with root package name */
    public String f142195i0;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f142196j;

    /* renamed from: j0, reason: collision with root package name */
    public int f142197j0;

    /* renamed from: k, reason: collision with root package name */
    public TextView f142198k;

    /* renamed from: k0, reason: collision with root package name */
    public int f142199k0;

    /* renamed from: l, reason: collision with root package name */
    public TextView f142200l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f142201m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ViewParent parent = d.this.f142188f.getParent();
            if (parent != null) {
                d dVar = d.this;
                int g16 = dVar.g();
                if (g16 != 1 && g16 != 3) {
                    int b16 = com.tencent.luggage.wxa.kn.a.b(dVar.f142178a) - com.tencent.luggage.wxa.kn.a.a(z.c(), 60);
                    if (dVar.f142188f.getHeight() > b16) {
                        dVar.f142188f.getLayoutParams().height = Math.min(b16, dVar.f142188f.getHeight());
                        dVar.f142188f.requestLayout();
                        return;
                    }
                    return;
                }
                if (dVar.f142188f.getLayoutParams().height != -2) {
                    dVar.f142188f.getLayoutParams().height = -2;
                    dVar.f142188f.requestLayout();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (d.this.G.getHeight() > 0) {
                d.this.F.getLayoutParams().height = d.this.G.getHeight();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f142205b;

        public c(List list) {
            this.f142205b = list;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.this.a((j) this.f142205b.get(0));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ub.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class ViewOnClickListenerC6795d implements View.OnClickListener {
        public ViewOnClickListenerC6795d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.this.c(1);
            d.this.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.this.cancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f142209b;

        public f(List list) {
            this.f142209b = list;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.this.M.setChecked(!d.this.M.isChecked());
            List list = this.f142209b;
            d dVar = d.this;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a(dVar.M.isChecked());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.this.c(3);
            d.this.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public interface a {
            void a(String str, boolean z16, int i3);
        }

        public h() {
        }

        public /* synthetic */ h(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum i {
        Normal,
        SingleMode,
        SingleVoiceMode
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public boolean f142215a;

        /* renamed from: b, reason: collision with root package name */
        public final String f142216b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f142217c;

        /* renamed from: d, reason: collision with root package name */
        public final String f142218d;

        /* renamed from: e, reason: collision with root package name */
        public int f142219e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f142220f;

        public j(boolean z16, String title, ArrayList sampleWordings, String templateId, int i3) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(sampleWordings, "sampleWordings");
            Intrinsics.checkNotNullParameter(templateId, "templateId");
            this.f142215a = z16;
            this.f142216b = title;
            this.f142217c = sampleWordings;
            this.f142218d = templateId;
            this.f142219e = i3;
        }

        public final boolean a() {
            return this.f142215a;
        }

        public final ArrayList b() {
            return this.f142217c;
        }

        public final String c() {
            return this.f142218d;
        }

        public final String d() {
            return this.f142216b;
        }

        public final void a(boolean z16) {
            this.f142220f = z16;
        }

        public final void b(boolean z16) {
            this.f142215a = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k extends RecyclerView.Adapter {

        /* renamed from: d, reason: collision with root package name */
        public static final a f142221d = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public List f142222a;

        /* renamed from: b, reason: collision with root package name */
        public final d f142223b;

        /* renamed from: c, reason: collision with root package name */
        public final List f142224c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public TextView f142225a;

            /* renamed from: b, reason: collision with root package name */
            public WeImageView f142226b;

            /* renamed from: c, reason: collision with root package name */
            public MMSwitchBtn f142227c;

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class a extends Lambda implements Function0 {
                public a() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke() {
                    b.this.c().setSlideAnimationEnabled(false);
                    return Boolean.valueOf(b.this.c().isCheck());
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(View item) {
                super(item);
                Intrinsics.checkNotNullParameter(item, "item");
                View findViewById = this.itemView.findViewById(R.id.bg6);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.desc)");
                this.f142225a = (TextView) findViewById;
                View findViewById2 = this.itemView.findViewById(R.id.vds);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.force_notify_iv)");
                this.f142226b = (WeImageView) findViewById2;
                View findViewById3 = this.itemView.findViewById(R.id.f911254b);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.switchBtn_force)");
                MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById3;
                this.f142227c = mMSwitchBtn;
                c.a.a(com.tencent.luggage.wxa.jl.c.f131190l, mMSwitchBtn, Switch.class, null, false, null, Boolean.FALSE, null, new a(), null, null, null, null, null, MessageHandlerConstants.NOTIFY_TYPE_TRIBE_TMP, null);
            }

            public final TextView a() {
                return this.f142225a;
            }

            public final WeImageView b() {
                return this.f142226b;
            }

            public final MMSwitchBtn c() {
                return this.f142227c;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public TextView f142229a;

            /* renamed from: b, reason: collision with root package name */
            public MMSwitchBtn f142230b;

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class a extends Lambda implements Function0 {
                public a() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke() {
                    c.this.b().setSlideAnimationEnabled(false);
                    return Boolean.valueOf(c.this.b().isCheck());
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(View item) {
                super(item);
                Intrinsics.checkNotNullParameter(item, "item");
                View findViewById = this.itemView.findViewById(R.id.bg6);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.desc)");
                this.f142229a = (TextView) findViewById;
                View findViewById2 = this.itemView.findViewById(R.id.f911154a);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.switchBtn)");
                MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById2;
                this.f142230b = mMSwitchBtn;
                c.a.a(com.tencent.luggage.wxa.jl.c.f131190l, mMSwitchBtn, Switch.class, null, false, null, Boolean.FALSE, null, new a(), null, null, null, null, null, MessageHandlerConstants.NOTIFY_TYPE_TRIBE_TMP, null);
            }

            public final TextView a() {
                return this.f142229a;
            }

            public final MMSwitchBtn b() {
                return this.f142230b;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ub.d$k$d, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6796d implements MMSwitchBtn.ISwitch {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RecyclerView.ViewHolder f142233b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f142234c;

            public C6796d(RecyclerView.ViewHolder viewHolder, int i3) {
                this.f142233b = viewHolder;
                this.f142234c = i3;
            }

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.ISwitch
            public final void onStatusChange(boolean z16) {
                k.this.a(z16, this.f142233b, this.f142234c);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class e implements MMSwitchBtn.ISwitch {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RecyclerView.ViewHolder f142236b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f142237c;

            public e(RecyclerView.ViewHolder viewHolder, int i3) {
                this.f142236b = viewHolder;
                this.f142237c = i3;
            }

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.ISwitch
            public final void onStatusChange(boolean z16) {
                k.this.a(z16, this.f142236b, this.f142237c);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class f implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f142238a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f142239b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f142240c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RecyclerView.ViewHolder f142241d;

            public f(j jVar, k kVar, int i3, RecyclerView.ViewHolder viewHolder) {
                this.f142238a = jVar;
                this.f142239b = kVar;
                this.f142240c = i3;
                this.f142241d = viewHolder;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ((l) this.f142238a).c(!r8.e());
                this.f142239b.a(this.f142240c, ((l) this.f142238a).e(), true, (b) this.f142241d, (j) this.f142239b.a().get(this.f142240c));
            }
        }

        public k(List items, d dialog) {
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            this.f142222a = items;
            this.f142223b = dialog;
            ArrayList arrayList = new ArrayList();
            this.f142224c = arrayList;
            List list = this.f142222a;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (((j) obj).a()) {
                    arrayList2.add(obj);
                }
            }
            arrayList.addAll(arrayList2);
            this.f142223b.d(this.f142224c.size());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.f142222a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            if (this.f142222a.get(i3) instanceof l) {
                return 2;
            }
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int i3) {
            int i16;
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof c) {
                c cVar = (c) holder;
                cVar.a().setText(((j) this.f142222a.get(i3)).d());
                cVar.b().setCheck(((j) this.f142222a.get(i3)).a());
                cVar.b().setSwitchListener(new C6796d(holder, i3));
                return;
            }
            if (holder instanceof b) {
                b bVar = (b) holder;
                bVar.c().setCheck(((j) this.f142222a.get(i3)).a());
                bVar.a().setText(((j) this.f142222a.get(i3)).d());
                WeImageView b16 = bVar.b();
                if (((j) this.f142222a.get(i3)).a()) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                b16.setVisibility(i16);
                bVar.c().setSwitchListener(new e(holder, i3));
                j jVar = (j) this.f142222a.get(i3);
                if (jVar instanceof l) {
                    a(i3, ((l) jVar).e(), false, bVar, (j) this.f142222a.get(i3));
                    bVar.b().setOnClickListener(new f(jVar, this, i3, holder));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i3 == 2) {
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hrb, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026notify_item_layout, null)");
                return new b(inflate);
            }
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.hrc, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context).inf\u2026be_msg_item_layout, null)");
            return new c(inflate2);
        }

        public final List a() {
            return this.f142222a;
        }

        public final void a(int i3, boolean z16, boolean z17, b bVar, j jVar) {
            int color;
            o oVar;
            n nVar = this.f142223b.f142180b;
            if (nVar != null) {
                nVar.a(com.tencent.luggage.wxa.ub.e.SWITCH_FORCE_NOTIFY, z16, jVar, z17);
            }
            if (z17) {
                if (z16) {
                    Object systemService = this.f142223b.f142178a.getSystemService("vibrator");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
                    ((Vibrator) systemService).vibrate(10L);
                    o oVar2 = this.f142223b.f142186e;
                    if (oVar2 != null) {
                        oVar2.a(this.f142223b.f142178a, true);
                    }
                } else if (bVar.c().isCheck() && (oVar = this.f142223b.f142186e) != null) {
                    oVar.a(this.f142223b.f142178a, false);
                }
            }
            if (z16) {
                color = bVar.b().getContext().getResources().getColor(R.color.f157976ct0);
            } else {
                color = bVar.b().getContext().getResources().getColor(R.color.aiq);
            }
            bVar.b().setImageDrawable(com.tencent.luggage.wxa.lo.m.a(bVar.itemView.getContext().getResources().getDrawable(z16 ? R.raw.f169362dc : R.raw.f169373dn), color));
            bVar.b().setIconColor(color);
        }

        public final void a(boolean z16, RecyclerView.ViewHolder holder, int i3) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof c) {
                c cVar = (c) holder;
                cVar.b().setCheck(z16);
                ((j) this.f142222a.get(i3)).b(cVar.b().isCheck());
                if (((j) this.f142222a.get(i3)).a()) {
                    this.f142224c.add(this.f142222a.get(i3));
                } else {
                    this.f142224c.remove(this.f142222a.get(i3));
                }
                this.f142223b.d(this.f142224c.size());
                return;
            }
            if (holder instanceof b) {
                b bVar = (b) holder;
                bVar.c().setCheck(z16);
                a(i3, bVar, true);
            }
        }

        public final void a(int i3, b bVar, boolean z16) {
            ((j) this.f142222a.get(i3)).b(bVar.c().isCheck());
            if (z16) {
                bVar.b().setVisibility(bVar.c().isCheck() ? 0 : 8);
            }
            j jVar = (j) this.f142222a.get(i3);
            if (jVar.a()) {
                this.f142224c.add(jVar);
            } else {
                this.f142224c.remove(jVar);
                if (z16 && (jVar instanceof l)) {
                    l lVar = (l) jVar;
                    lVar.c(false);
                    a(i3, lVar.e(), true, bVar, (j) this.f142222a.get(i3));
                }
            }
            this.f142223b.d(this.f142224c.size());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l extends j {

        /* renamed from: g, reason: collision with root package name */
        public boolean f142242g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(boolean z16, String title, ArrayList sampleWordings, String templateId, boolean z17, int i3) {
            super(z16, title, sampleWordings, templateId, i3);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(sampleWordings, "sampleWordings");
            Intrinsics.checkNotNullParameter(templateId, "templateId");
            this.f142242g = z17;
        }

        public final void c(boolean z16) {
            this.f142242g = z16;
        }

        public final boolean e() {
            return this.f142242g;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m extends j {

        /* renamed from: g, reason: collision with root package name */
        public final String f142243g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f142244h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(boolean z16, String title, ArrayList sampleWordings, String templateId, String voiceMediaUrl, int i3) {
            super(z16, title, sampleWordings, templateId, i3);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(sampleWordings, "sampleWordings");
            Intrinsics.checkNotNullParameter(templateId, "templateId");
            Intrinsics.checkNotNullParameter(voiceMediaUrl, "voiceMediaUrl");
            this.f142243g = voiceMediaUrl;
        }

        public final void c(boolean z16) {
            this.f142244h = z16;
        }

        public final boolean e() {
            return this.f142244h;
        }

        public final String f() {
            return this.f142243g;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface n {
        void a(int i3, List list);

        void a(com.tencent.luggage.wxa.ub.e eVar, boolean z16, j jVar, boolean z17);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface o {
        void a(Context context, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class p extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        public final int f142245a = 2;

        /* renamed from: b, reason: collision with root package name */
        public final int f142246b = com.tencent.luggage.wxa.kn.a.a(z.c(), 40);

        /* renamed from: c, reason: collision with root package name */
        public final Paint f142247c;

        public p(d dVar) {
            Paint paint = new Paint();
            this.f142247c = paint;
            paint.setColor(dVar.f142178a.getResources().getColor(R.color.bhw));
            paint.setStyle(Paint.Style.FILL);
            paint.setFlags(1);
            paint.setStrokeWidth(2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildAdapterPosition(view) == 0) {
                int i3 = this.f142245a;
                outRect.set(0, i3, 0, i3);
            } else {
                outRect.set(0, 0, 0, this.f142245a);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas c16, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(c16, "c");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.onDraw(c16, parent, state);
            float paddingLeft = parent.getPaddingLeft();
            float width = parent.getWidth() - parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                ViewGroup.LayoutParams layoutParams = parent.getChildAt(i3).getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                float bottom = r0.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + this.f142245a;
                if (i3 == 0) {
                    float top = (r0.getTop() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) - this.f142245a;
                    c16.drawLine(paddingLeft, top, width, top, this.f142247c);
                }
                c16.drawLine(paddingLeft, bottom, width, bottom, this.f142247c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class q implements MMSwitchBtn.ISwitch {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f142248a;

        public q(m mVar) {
            this.f142248a = mVar;
        }

        @Override // com.tencent.mm.ui.widget.MMSwitchBtn.ISwitch
        public final void onStatusChange(boolean z16) {
            this.f142248a.c(z16);
            this.f142248a.b(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class r implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f142249a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f142250b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f142251a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j3) {
                super(0);
                this.f142251a = j3;
            }

            public final void a() {
                com.tencent.luggage.wxa.xb.a.f144656a.a(this.f142251a);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public r(m mVar, d dVar) {
            this.f142249a = mVar;
            this.f142250b = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            long a16 = com.tencent.luggage.wxa.xb.a.f144656a.a(this.f142249a.f());
            this.f142250b.U = new a(a16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class s extends Lambda implements Function0 {
        public s() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final View invoke() {
            View view = new View(d.this.f142178a);
            view.setBackgroundColor(d.this.f142178a.getResources().getColor(R.color.bhw));
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
            return view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class t implements ViewTreeObserver.OnGlobalLayoutListener {
        public t() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.this.f142188f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (d.this.T == i.Normal) {
                d dVar = d.this;
                dVar.a(dVar.P);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class u extends AnimatorListenerAdapter {
        public u() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Integer num = d.this.R;
            if (num != null) {
                d dVar = d.this;
                View findViewById = dVar.F.findViewById(num.intValue());
                if (findViewById != null) {
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(it)");
                    ((LinearLayout) dVar.F.findViewById(R.id.b8q)).removeView(findViewById);
                }
            }
            com.tencent.luggage.wxa.jl.a.a(d.this.f142188f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.this.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class w implements ViewTreeObserver.OnGlobalLayoutListener {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends AnimatorListenerAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f142257a;

            public a(d dVar) {
                this.f142257a = dVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                com.tencent.luggage.wxa.jl.a.a(this.f142257a.F);
            }
        }

        public w() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.this.F.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            d.this.a(true, (Animator.AnimatorListener) new a(d.this));
        }
    }

    public d(Context context, List items, n nVar, boolean z16, boolean z17, o oVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(items, "items");
        this.f142178a = context;
        this.f142180b = nVar;
        this.f142182c = z16;
        this.f142184d = z17;
        this.f142186e = oVar;
        View inflate = LayoutInflater.from(context).inflate(R.layout.hre, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026msg_request_dialog, null)");
        this.f142188f = inflate;
        this.P = new ArrayList();
        i iVar = i.Normal;
        this.T = iVar;
        this.W = "";
        this.X = "";
        this.Y = "";
        this.Z = "";
        this.f142181b0 = true;
        this.f142183c0 = "";
        this.f142185d0 = true;
        this.f142187e0 = "";
        this.f142189f0 = "";
        this.f142191g0 = "";
        this.f142193h0 = "";
        this.f142195i0 = "";
        View findViewById = this.f142188f.findViewById(R.id.xvx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.item_list_container)");
        this.f142190g = (FrameLayout) findViewById;
        View findViewById2 = this.f142188f.findViewById(R.id.iig);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.scroll_view)");
        this.f142192h = (ScrollView) findViewById2;
        View findViewById3 = this.f142188f.findViewById(R.id.d_m);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.icon_iv)");
        this.f142196j = (ImageView) findViewById3;
        View findViewById4 = this.f142188f.findViewById(R.id.by);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.action)");
        this.f142198k = (TextView) findViewById4;
        View findViewById5 = this.f142188f.findViewById(R.id.bg6);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.desc)");
        this.f142201m = (TextView) findViewById5;
        View findViewById6 = this.f142188f.findViewById(R.id.jm8);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.tip)");
        this.C = (TextView) findViewById6;
        View findViewById7 = this.f142188f.findViewById(R.id.stq);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.app_name_tv)");
        this.f142200l = (TextView) findViewById7;
        View findViewById8 = this.f142188f.findViewById(R.id.bjv);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R.id.dialog_cancel)");
        this.D = (Button) findViewById8;
        View findViewById9 = this.f142188f.findViewById(R.id.uhx);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R.id.dialog_ok)");
        this.E = (Button) findViewById9;
        View findViewById10 = this.f142188f.findViewById(R.id.f793349h);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mRootView.findViewById(R.id.sample_root)");
        this.F = findViewById10;
        View findViewById11 = this.f142188f.findViewById(R.id.f793449i);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mRootView.findViewById(R.id.sample_view_title)");
        this.N = (TextView) findViewById11;
        View findViewById12 = this.f142188f.findViewById(R.id.ui5);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mRootView.findViewById(R.id.dialog_view_container)");
        this.G = (FrameLayout) findViewById12;
        View findViewById13 = this.f142188f.findViewById(R.id.f164989ui4);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "mRootView.findViewById(R.id.dialog_view)");
        this.H = findViewById13;
        View findViewById14 = this.f142188f.findViewById(R.id.tzu);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "mRootView.findViewById(R.id.close_wiv)");
        this.I = findViewById14;
        findViewById14.setContentDescription(context.getString(R.string.ywe));
        View findViewById15 = this.f142188f.findViewById(R.id.smy);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "mRootView.findViewById(R.id.always_keep_tv)");
        this.J = (TextView) findViewById15;
        View findViewById16 = this.f142188f.findViewById(R.id.zwr);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "mRootView.findViewById(R\u2026_type_always_keep_layout)");
        this.L = findViewById16;
        View findViewById17 = this.f142188f.findViewById(R.id.smx);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "mRootView.findViewById(R.id.always_keep_checkbox)");
        this.M = (CheckBox) findViewById17;
        View findViewById18 = this.f142188f.findViewById(R.id.smz);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "mRootView.findViewById(R.id.always_reject_tv)");
        this.K = (TextView) findViewById18;
        View findViewById19 = this.f142188f.findViewById(R.id.f100005rb);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "mRootView.findViewById(R.id.top_sample)");
        this.O = findViewById19;
        this.f142188f.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.G.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        this.P.addAll(items);
        if (z16) {
            this.T = i.SingleMode;
            this.f142190g.setVisibility(8);
            this.O.setVisibility(0);
            this.O.setOnClickListener(new c(items));
        } else if (z17) {
            this.T = i.SingleVoiceMode;
            Object obj = items.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mm.msgsubscription.ui.SubscribeMsgRequestDialog.ItemWithVoice");
            a((m) obj);
        } else {
            this.T = iVar;
            a(items);
        }
        this.E.setOnClickListener(new ViewOnClickListenerC6795d());
        this.D.setOnClickListener(new e());
        this.L.setOnClickListener(new f(items));
        this.K.setOnClickListener(new g());
        this.f142199k0 = 2;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean b() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean c() {
        return false;
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        onCancel();
        dismiss();
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        com.tencent.luggage.wxa.ml.r rVar = this.S;
        if (rVar != null) {
            rVar.b(this);
        }
        h();
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public View getContentView() {
        return this.f142188f;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public int getPosition() {
        return this.f142199k0;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onCancel() {
        f();
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onShown() {
        com.tencent.luggage.wxa.jl.a.a(this.f142188f);
    }

    public final void d(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f142193h0 = value;
        this.D.setText(value);
    }

    public final void e(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f142189f0 = value;
        this.f142201m.setText(value);
        this.f142201m.setContentDescription(this.f142189f0);
    }

    public final void f(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.W = value;
    }

    public final void g(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f142191g0 = value;
        this.E.setText(value);
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Y = str;
    }

    public final void i(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f142195i0 = value;
        this.C.setText(value);
        this.C.setVisibility(this.f142195i0.length() == 0 ? 8 : 0);
    }

    public final void c(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.X = value;
        this.f142200l.setText(value);
        a(this.f142200l);
    }

    public final void f(int i3) {
        this.f142199k0 = i3;
        if (i3 == 1) {
            this.f142188f.findViewById(R.id.ui6).setBackground(ContextCompat.getDrawable(this.f142178a, R.drawable.loh));
        } else {
            if (i3 != 2) {
                return;
            }
            this.f142188f.findViewById(R.id.ui6).setBackground(ContextCompat.getDrawable(this.f142178a, R.drawable.log));
        }
    }

    public void h() {
        Function0 function0 = this.U;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void b(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.Z = value;
        this.L.setVisibility(0);
        this.J.setText(this.Z);
    }

    public final boolean d() {
        return this.M.isChecked();
    }

    public final int g() {
        Object systemService = this.f142178a.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        return ((WindowManager) systemService).getDefaultDisplay().getRotation();
    }

    public final void d(int i3) {
        this.E.setEnabled(i3 != 0);
    }

    public final void e(int i3) {
        this.f142197j0 = i3;
    }

    public final void c(int i3) {
        com.tencent.luggage.wxa.tn.w.d("SubscribeMsgRequestDialog", "dispatchEvent " + i3);
        n nVar = this.f142180b;
        if (nVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.P);
            Unit unit = Unit.INSTANCE;
            nVar.a(i3, arrayList);
        }
    }

    public final boolean e() {
        if (!this.Q) {
            return false;
        }
        a(false, (Animator.AnimatorListener) new u());
        this.Q = false;
        return true;
    }

    public final void f() {
        c(2);
    }

    public final void a(h.a aVar) {
        this.V = aVar;
    }

    public final void b(boolean z16) {
        this.f142185d0 = z16;
        this.K.setVisibility(z16 ? 0 : 8);
    }

    public final void a(boolean z16) {
        this.f142179a0 = z16;
        this.M.setChecked(z16);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void b(int i3) {
        a(i3);
    }

    public final void a(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f142187e0 = value;
        this.f142198k.setText(value);
        a(this.f142198k);
    }

    public final void a(TextView textView) {
        textView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        textView.getPaint().setStrokeWidth(0.8f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [T, android.view.View] */
    public final void a(m mVar) {
        this.f142190g.removeAllViews();
        LinearLayout linearLayout = new LinearLayout(this.f142178a);
        linearLayout.setBackgroundColor(0);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        View inflate = LayoutInflater.from(this.f142178a).inflate(R.layout.hrh, (ViewGroup) null);
        ?? findViewById = inflate.findViewById(R.id.j95);
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById;
        mMSwitchBtn.setVisibility(0);
        objectRef.element = findViewById;
        if (mMSwitchBtn != null) {
            mMSwitchBtn.setCheck(false);
        }
        MMSwitchBtn mMSwitchBtn2 = (MMSwitchBtn) objectRef.element;
        if (mMSwitchBtn2 != null) {
            mMSwitchBtn2.setSwitchListener(new q(mVar));
        }
        WeImageView weImageView = (WeImageView) inflate.findViewById(R.id.xdh);
        weImageView.setVisibility(8);
        String f16 = mVar.f();
        if (!(f16 == null || f16.length() == 0)) {
            weImageView.setVisibility(0);
            weImageView.setOnClickListener(new r(mVar, this));
        }
        ((TextView) inflate.findViewById(R.id.bg6)).setText(this.f142178a.getString(R.string.zfb));
        s sVar = new s();
        int applyDimension = (int) TypedValue.applyDimension(1, 56.0f, this.f142178a.getResources().getDisplayMetrics());
        linearLayout.addView((View) sVar.invoke());
        linearLayout.addView(inflate, new ViewGroup.LayoutParams(-1, applyDimension));
        linearLayout.addView((View) sVar.invoke());
        this.f142190g.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
    }

    public final void a(List list) {
        RecyclerView recyclerView = new RecyclerView(this.f142178a);
        this.f142190g.removeAllViews();
        this.f142190g.addView(recyclerView, new ViewGroup.LayoutParams(-1, -2));
        k kVar = new k(list, this);
        this.f142194i = kVar;
        recyclerView.setAdapter(kVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f142178a));
        recyclerView.addItemDecoration(new p(this));
    }

    public final void a(j jVar) {
        if (this.Q) {
            return;
        }
        View a16 = com.tencent.luggage.wxa.wb.c.a(com.tencent.luggage.wxa.wb.c.f144167a, this.f142178a, jVar.b(), 0, 4, (Object) null);
        a16.setId(View.generateViewId());
        this.R = Integer.valueOf(a16.getId());
        ((LinearLayout) this.F.findViewById(R.id.b8q)).addView(a16);
        this.F.setVisibility(0);
        this.N.setText(this.Y);
        this.I.setOnClickListener(new v());
        this.F.getViewTreeObserver().addOnGlobalLayoutListener(new w());
        h.a aVar = this.V;
        if (aVar != null) {
            aVar.a(jVar.c(), jVar.a(), this.P.indexOf(jVar));
        }
        this.Q = true;
    }

    public final void a(boolean z16, Animator.AnimatorListener animatorListener) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (z16) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.G, (Property<FrameLayout, Float>) View.TRANSLATION_X, 0.0f, -r7.getWidth()).setDuration(200L);
            duration.setInterpolator(new com.tencent.luggage.wxa.vb.a());
            Unit unit = Unit.INSTANCE;
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.F, (Property<View, Float>) View.TRANSLATION_X, r7.getWidth(), 0.0f).setDuration(200L);
            duration2.setInterpolator(new com.tencent.luggage.wxa.vb.a());
            animatorSet.playTogether(duration, duration2);
        } else {
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.G, (Property<FrameLayout, Float>) View.TRANSLATION_X, -r7.getWidth(), 0.0f).setDuration(200L);
            duration3.setInterpolator(new com.tencent.luggage.wxa.vb.a());
            Unit unit2 = Unit.INSTANCE;
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(this.F, (Property<View, Float>) View.TRANSLATION_X, 0.0f, r7.getWidth()).setDuration(200L);
            duration4.setInterpolator(new com.tencent.luggage.wxa.vb.a());
            animatorSet.playTogether(duration3, duration4);
        }
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
        animatorSet.start();
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean a() {
        return e();
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void a(com.tencent.luggage.wxa.ml.r rVar) {
        AppBrandSimpleImageLoader.instance().attach(this.f142196j, this.W, this.f142197j0, new com.tencent.mm.modelappbrand.image.b());
        this.S = rVar;
        a(g());
    }

    public final void a(int i3) {
        com.tencent.luggage.wxa.ub.a.f142165a.a(i3, this.f142188f);
        if (i3 != 1 && i3 != 3) {
            if (this.G.indexOfChild(this.H) == -1) {
                ViewParent parent = this.H.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.H);
                }
                this.G.addView(this.H);
                this.f142192h.setVisibility(8);
            }
        } else if (this.f142192h.indexOfChild(this.H) == -1) {
            ViewParent parent2 = this.H.getParent();
            if (parent2 != null) {
                ((ViewGroup) parent2).removeView(this.H);
            }
            this.f142192h.addView(this.H);
            this.f142192h.setVisibility(0);
        }
        this.f142188f.getViewTreeObserver().addOnGlobalLayoutListener(new t());
    }
}
