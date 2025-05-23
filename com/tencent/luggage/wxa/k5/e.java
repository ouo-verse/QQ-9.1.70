package com.tencent.luggage.wxa.k5;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.luggage.wxa.g6.p;
import com.tencent.luggage.wxa.hn.fi;
import com.tencent.luggage.wxa.k5.b;
import com.tencent.luggage.wxa.k5.g;
import com.tencent.luggage.wxa.mo.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.v;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.ui.WxaDefaultIcon;
import com.tencent.mm.ui.widget.menu.MMPopupMenu;
import com.tencent.mobileqq.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.k5.n f131441a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.k5.c f131442b;

    /* renamed from: c, reason: collision with root package name */
    public final q f131443c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f131444d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f131445e;

    /* renamed from: f, reason: collision with root package name */
    public ProgressDialog f131446f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Observer {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(fi rawUsageInfo) {
            w.d("MicroMsg.AppBrandUserInfoRevokePage", "onChanged#usageInfoObservable");
            if (!com.tencent.luggage.wxa.rk.a.f139822a.a(rawUsageInfo)) {
                w.f("MicroMsg.AppBrandUserInfoRevokePage", "onChanged#usageInfoObservable, rawUsageInfo is null or invalid");
                return;
            }
            e eVar = e.this;
            Intrinsics.checkNotNullExpressionValue(rawUsageInfo, "rawUsageInfo");
            eVar.f131442b = new com.tencent.luggage.wxa.k5.c(rawUsageInfo);
            e.this.notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Observer {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(com.tencent.luggage.wxa.i5.f fVar) {
            w.d("MicroMsg.AppBrandUserInfoRevokePage", "onChanged#pageModeObservable, pageMode: " + fVar);
            if (fVar == null) {
                w.f("MicroMsg.AppBrandUserInfoRevokePage", "onChanged#pageModeObservable, pageMode is null");
            } else {
                e.this.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Observer {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f131450a;

            static {
                int[] iArr = new int[com.tencent.luggage.wxa.i5.g.values().length];
                iArr[com.tencent.luggage.wxa.i5.g.DOING.ordinal()] = 1;
                iArr[com.tencent.luggage.wxa.i5.g.SUCCESS.ordinal()] = 2;
                iArr[com.tencent.luggage.wxa.i5.g.FAILURE.ordinal()] = 3;
                f131450a = iArr;
            }
        }

        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(com.tencent.luggage.wxa.i5.g gVar) {
            w.d("MicroMsg.AppBrandUserInfoRevokePage", "onChanged#revokeStateObservable, revokeState: " + gVar);
            if (gVar == null) {
                w.d("MicroMsg.AppBrandUserInfoRevokePage", "onChanged#revokeStateObservable, revokeState is null");
                return;
            }
            int i3 = a.f131450a[gVar.ordinal()];
            if (i3 == 1) {
                e.this.d();
            } else if (i3 == 2) {
                e.this.c();
            } else if (i3 == 3) {
                e.this.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f131451a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.i5.f.values().length];
            iArr[com.tencent.luggage.wxa.i5.f.NORMAL.ordinal()] = 1;
            iArr[com.tencent.luggage.wxa.i5.f.MANAGE.ordinal()] = 2;
            f131451a = iArr;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k5.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class ViewOnCreateContextMenuListenerC6358e implements View.OnCreateContextMenuListener {
        public ViewOnCreateContextMenuListenerC6358e() {
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            e.this.a(contextMenu);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements u {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f131454b;

        public f(Function0 function0) {
            this.f131454b = function0;
        }

        @Override // com.tencent.luggage.wxa.mo.u
        public final void a(MenuItem menuItem, int i3) {
            e.this.a(menuItem, this.f131454b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends MMPopupMenu {

        /* renamed from: i0, reason: collision with root package name */
        public final /* synthetic */ View f131455i0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(View view, Context context) {
            super(context);
            this.f131455i0 = view;
        }

        @Override // com.tencent.mm.ui.widget.menu.MMPopupMenu, android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            ViewParent parent = this.f131455i0.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            this.f131455i0.setBackgroundResource(R.color.ajr);
            super.onDismiss();
        }

        @Override // com.tencent.mm.ui.widget.menu.MMPopupMenu
        public boolean show() {
            ViewParent parent = this.f131455i0.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            this.f131455i0.setBackgroundResource(R.drawable.f160308ja2);
            return super.show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements com.tencent.luggage.wxa.mo.p {
        public h() {
        }

        @Override // com.tencent.luggage.wxa.mo.p
        public final void a(com.tencent.luggage.wxa.mo.h hVar) {
            e.this.a(hVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements u {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.i5.h f131458b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f131459a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.i5.h f131460b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar, com.tencent.luggage.wxa.i5.h hVar) {
                super(0);
                this.f131459a = eVar;
                this.f131460b = hVar;
            }

            public final void a() {
                this.f131459a.f131441a.l().a(this.f131460b);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public i(com.tencent.luggage.wxa.i5.h hVar) {
            this.f131458b = hVar;
        }

        @Override // com.tencent.luggage.wxa.mo.u
        public final void a(MenuItem menuItem, int i3) {
            e eVar = e.this;
            eVar.a(menuItem, new a(eVar, this.f131458b));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k5.g f131461a;

        public j(com.tencent.luggage.wxa.k5.g gVar) {
            this.f131461a = gVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i3;
            LinearLayout b16 = ((g.a) this.f131461a).b();
            if (b16 != null) {
                if (1 < ((g.a) this.f131461a).c().getLineCount()) {
                    i3 = 48;
                } else {
                    i3 = 16;
                }
                b16.setGravity(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k5.g f131463b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.k5.g f131464a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.tencent.luggage.wxa.k5.g gVar) {
                super(0);
                this.f131464a = gVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                int y16 = ((int) ((g.a) this.f131464a).d().getY()) + ((g.a) this.f131464a).d().getMeasuredHeight();
                w.d("MicroMsg.AppBrandUserInfoRevokePage", "invoke#measuredHeightResolver, titleHeight: " + y16);
                return Integer.valueOf(y16);
            }
        }

        public k(com.tencent.luggage.wxa.k5.g gVar) {
            this.f131463b = gVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.this.f131443c.a(new a(this.f131463b));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f131465a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k5.b f131466b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k5.g f131467c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(com.tencent.luggage.wxa.k5.b bVar, com.tencent.luggage.wxa.k5.g gVar, Continuation continuation) {
            super(2, continuation);
            this.f131466b = bVar;
            this.f131467c = gVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new l(this.f131466b, this.f131467c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            String str;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f131465a;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (com.tencent.luggage.wxa.lo.i.g()) {
                    str = ((b.c) this.f131466b).a().c().f128275h;
                } else {
                    str = ((b.c) this.f131466b).a().c().f128274g;
                }
                if (str == null) {
                    str = ((b.c) this.f131466b).a().c().f128274g;
                }
                if (str != null) {
                    ImageView d16 = ((g.d) this.f131467c).d();
                    this.f131465a = 1;
                    if (v.a(str, d16, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f131468a;

        public m(Function0 function0) {
            this.f131468a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f131468a.invoke();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.this.f131441a.l().d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k5.g f131470a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f131471b;

        public o(com.tencent.luggage.wxa.k5.g gVar, e eVar) {
            this.f131470a = gVar;
            this.f131471b = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Button a16 = ((g.b) this.f131470a).a();
            if (a16 != null) {
                a16.setVisibility(0);
            }
            int height = this.f131471b.f131441a.getWindow().getDecorView().getHeight();
            View view = this.f131470a.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            int i3 = com.tencent.luggage.wxa.bb.a.a(view)[1];
            int measuredHeight = this.f131470a.itemView.getMeasuredHeight();
            w.d("MicroMsg.AppBrandUserInfoRevokePage", "fixManageAreaAtScreenBottom, windowHeight: " + height + ", manageAreaY: " + i3 + ", manageAreaHeight: " + measuredHeight);
            int i16 = height - (i3 + measuredHeight);
            if (i16 > 0) {
                this.f131470a.itemView.setPadding(0, i16, 0, 0);
            }
            this.f131471b.f131445e = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class p extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k5.b f131473b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(com.tencent.luggage.wxa.k5.b bVar) {
            super(0);
            this.f131473b = bVar;
        }

        public final void a() {
            e.this.a(((b.c) this.f131473b).a());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class q {

        /* renamed from: a, reason: collision with root package name */
        public boolean f131474a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k5.d f131475b;

        public q(com.tencent.luggage.wxa.k5.d dVar) {
            this.f131475b = dVar;
        }

        public final void a(Function0 measuredHeightResolver) {
            Intrinsics.checkNotNullParameter(measuredHeightResolver, "measuredHeightResolver");
            if (this.f131474a) {
                return;
            }
            this.f131475b.a(((Number) measuredHeightResolver.invoke()).intValue());
            this.f131474a = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.this.f131441a.l().d();
        }
    }

    public e(com.tencent.luggage.wxa.k5.n host, com.tencent.luggage.wxa.k5.d titleHeightMeasureListener) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(titleHeightMeasureListener, "titleHeightMeasureListener");
        this.f131441a = host;
        this.f131443c = new q(titleHeightMeasureListener);
        host.l().c().observe(host, new a());
        host.l().a().observe(host, new b());
        host.l().b().observe(host, new c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        com.tencent.luggage.wxa.k5.c cVar = this.f131442b;
        if (cVar != null) {
            return cVar.a();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        try {
            com.tencent.luggage.wxa.k5.c cVar = this.f131442b;
            if (cVar == null) {
                w.f("MicroMsg.AppBrandUserInfoRevokePage", "getItemViewType, curUsageInfo is null");
                return super.getItemViewType(i3);
            }
            com.tencent.luggage.wxa.k5.b a16 = cVar.a(i3);
            if (a16 instanceof b.a) {
                return 0;
            }
            if (a16 instanceof b.c) {
                return 1;
            }
            if (a16 instanceof b.C6357b) {
                return 2;
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e16) {
            w.f("MicroMsg.AppBrandUserInfoRevokePage", "getItemViewType, position: " + i3 + " fail since " + e16);
            return super.getItemViewType(i3);
        }
    }

    public final void b() {
        w.d("MicroMsg.AppBrandUserInfoRevokePage", "showRevokeFailureToast");
        a();
    }

    public final void c() {
        w.d("MicroMsg.AppBrandUserInfoRevokePage", "showRevokeSuccessToast");
        a();
    }

    public final void d() {
        w.d("MicroMsg.AppBrandUserInfoRevokePage", "showRevokingDialog");
        a();
        p.a aVar = com.tencent.luggage.wxa.g6.p.f126564o;
        Context context = this.f131441a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "host.context");
        com.tencent.luggage.wxa.g6.p a16 = aVar.a(context);
        Context context2 = this.f131441a.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "host.context");
        ProgressDialog f16 = a16.f(context2);
        f16.setIndeterminate(true);
        f16.setCancelable(true);
        f16.show();
        this.f131446f = f16;
    }

    public final void e() {
        com.tencent.luggage.wxa.i5.f fVar = (com.tencent.luggage.wxa.i5.f) this.f131441a.l().a().getValue();
        if (fVar == null) {
            w.f("MicroMsg.AppBrandUserInfoRevokePage", "onBindViewHolder, pageMode is null");
            return;
        }
        Button mManageBtn = this.f131441a.getMManageBtn();
        if (mManageBtn != null) {
            mManageBtn.setVisibility(0);
        }
        int i3 = d.f131451a[fVar.ordinal()];
        if (i3 == 1) {
            Button mManageBtn2 = this.f131441a.getMManageBtn();
            if (mManageBtn2 != null) {
                mManageBtn2.setText(R.string.z5a);
            }
            Button mManageBtn3 = this.f131441a.getMManageBtn();
            if (mManageBtn3 != null) {
                mManageBtn3.setBackgroundResource(R.drawable.jeo);
            }
            Button mManageBtn4 = this.f131441a.getMManageBtn();
            if (mManageBtn4 != null) {
                mManageBtn4.setTextColor(ContextCompat.getColorStateList(this.f131441a.getContext(), R.color.cyu));
            }
        } else if (i3 == 2) {
            Button mManageBtn5 = this.f131441a.getMManageBtn();
            if (mManageBtn5 != null) {
                mManageBtn5.setText(R.string.z5c);
            }
            Button mManageBtn6 = this.f131441a.getMManageBtn();
            if (mManageBtn6 != null) {
                mManageBtn6.setBackgroundResource(R.drawable.jeg);
            }
            Button mManageBtn7 = this.f131441a.getMManageBtn();
            if (mManageBtn7 != null) {
                mManageBtn7.setTextColor(ContextCompat.getColorStateList(this.f131441a.getContext(), R.color.bdm));
            }
        }
        Button mManageBtn8 = this.f131441a.getMManageBtn();
        if (mManageBtn8 != null) {
            mManageBtn8.setOnClickListener(new r());
        }
    }

    public final void a(boolean z16) {
        w.d("MicroMsg.AppBrandUserInfoRevokePage", "configManageArea, fixAtScreenBottom: " + z16);
        if (this.f131442b == null) {
            w.d("MicroMsg.AppBrandUserInfoRevokePage", "configManageArea, curUsageInfo is null");
        } else {
            this.f131444d = Boolean.valueOf(z16);
            notifyItemChanged(r0.a() - 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.k5.g onCreateViewHolder(ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (i3 == 0) {
            return new g.a(parent);
        }
        if (i3 == 1) {
            return new g.d(parent);
        }
        if (i3 == 2) {
            return new g.c(parent);
        }
        if (i3 != 3) {
            w.f("MicroMsg.AppBrandUserInfoRevokePage", "onCreateViewHolder, viewType: " + i3 + ", are you kidding me?");
            return new g.d(parent);
        }
        return new g.b(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(com.tencent.luggage.wxa.k5.g holder, int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(holder, "holder");
        try {
            com.tencent.luggage.wxa.k5.c cVar = this.f131442b;
            if (cVar == null) {
                w.f("MicroMsg.AppBrandUserInfoRevokePage", "onBindViewHolder, curUsageInfo is null");
                return;
            }
            com.tencent.luggage.wxa.k5.b a16 = cVar.a(i3);
            if (holder instanceof g.a) {
                if (!(a16 instanceof b.a)) {
                    w.f("MicroMsg.AppBrandUserInfoRevokePage", "onBindViewHolder, flattenedItem is not header");
                    return;
                }
                g.a aVar = (g.a) holder;
                if (aVar.a() != null) {
                    AppBrandSimpleImageLoader.instance().attach(aVar.a(), ((b.a) a16).a().f127727f, WxaDefaultIcon.get(), WxaIconTransformation.INSTANCE);
                }
                TextView c16 = aVar.c();
                if (c16 != null) {
                    c16.setText(((b.a) a16).a().f127726e);
                    c16.post(new j(holder));
                }
                TextView d16 = aVar.d();
                if (d16 != null) {
                    d16.post(new k(holder));
                    return;
                }
                return;
            }
            if (holder instanceof g.d) {
                if (!(a16 instanceof b.c)) {
                    w.f("MicroMsg.AppBrandUserInfoRevokePage", "onBindViewHolder, flattenedItem is not UserInfo");
                    return;
                }
                com.tencent.luggage.wxa.i5.f fVar = (com.tencent.luggage.wxa.i5.f) this.f131441a.l().a().getValue();
                if (fVar == null) {
                    w.f("MicroMsg.AppBrandUserInfoRevokePage", "onBindViewHolder, pageMode is null");
                    return;
                }
                p pVar = new p(a16);
                g.d dVar = (g.d) holder;
                TextView e16 = dVar.e();
                if (e16 != null) {
                    e16.setText(((b.c) a16).a().c().f128272e);
                }
                b.c cVar2 = (b.c) a16;
                String str = cVar2.a().c().f128276i;
                if (str == null || str.length() == 0) {
                    TextView c17 = dVar.c();
                    if (c17 != null) {
                        c17.setVisibility(8);
                    }
                } else {
                    TextView c18 = dVar.c();
                    if (c18 != null) {
                        c18.setText(cVar2.a().c().f128276i);
                    }
                    TextView c19 = dVar.c();
                    if (c19 != null) {
                        c19.setVisibility(0);
                    }
                }
                TextView f16 = dVar.f();
                if (f16 != null) {
                    f16.setVisibility(7 == cVar2.a().c().f128273f ? 0 : 8);
                }
                ImageView d17 = dVar.d();
                if (d17 != null) {
                    d17.setPadding(0, 0, 0, 0);
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f131441a), null, null, new l(a16, holder, null), 3, null);
                    d17.setImportantForAccessibility(2);
                }
                e();
                int i17 = d.f131451a[fVar.ordinal()];
                if (i17 == 1) {
                    LinearLayout b16 = dVar.b();
                    if (b16 != null) {
                        b16.setVisibility(8);
                    }
                    View view = holder.itemView;
                    Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                    a(view, pVar);
                    return;
                }
                if (i17 != 2) {
                    return;
                }
                if (7 == cVar2.a().c().f128273f) {
                    LinearLayout b17 = dVar.b();
                    if (b17 != null) {
                        b17.setVisibility(8);
                    }
                } else {
                    LinearLayout b18 = dVar.b();
                    if (b18 != null) {
                        b18.setVisibility(0);
                    }
                    Button a17 = dVar.a();
                    if (a17 != null) {
                        a17.setOnClickListener(new m(pVar));
                    }
                }
                View view2 = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
                a(view2);
                return;
            }
            if (holder instanceof g.c) {
                if (!(a16 instanceof b.C6357b)) {
                    w.f("MicroMsg.AppBrandUserInfoRevokePage", "onBindViewHolder, flattenedItem is not PluginTitle");
                    return;
                }
                TextView a18 = ((g.c) holder).a();
                if (a18 == null) {
                    return;
                }
                a18.setText(this.f131441a.getContext().getString(R.string.z5d, ((b.C6357b) a16).a()));
                return;
            }
            if (holder instanceof g.b) {
                com.tencent.luggage.wxa.i5.f fVar2 = (com.tencent.luggage.wxa.i5.f) this.f131441a.l().a().getValue();
                if (fVar2 == null) {
                    w.f("MicroMsg.AppBrandUserInfoRevokePage", "onBindViewHolder, pageMode is null");
                    return;
                }
                g.b bVar = (g.b) holder;
                Button a19 = bVar.a();
                if (a19 != null) {
                    int i18 = d.f131451a[fVar2.ordinal()];
                    if (i18 == 1) {
                        i16 = R.string.z5a;
                    } else {
                        if (i18 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        i16 = R.string.z5c;
                    }
                    a19.setText(i16);
                }
                Button a26 = bVar.a();
                if (a26 != null) {
                    a26.setOnClickListener(new n());
                }
                Boolean bool = this.f131444d;
                if (this.f131445e || bool == null) {
                    return;
                }
                if (bool.booleanValue()) {
                    holder.itemView.post(new o(holder, this));
                } else {
                    Button a27 = bVar.a();
                    if (a27 != null) {
                        a27.setVisibility(0);
                    }
                }
                this.f131445e = true;
            }
        } catch (Exception unused) {
            w.f("MicroMsg.AppBrandUserInfoRevokePage", "onBindViewHolder, position: " + i3 + ", flattenedItem is null");
        }
    }

    public final void a(View view, Function0 function0) {
        g gVar = new g(view, view.getContext());
        gVar.registerPopupMenu(view, new ViewOnCreateContextMenuListenerC6358e(), new f(function0));
        view.setTag(gVar);
    }

    public final void a(View view) {
        if (view.getTag() instanceof MMPopupMenu) {
            view.setOnTouchListener(null);
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
        }
    }

    public final void a(com.tencent.luggage.wxa.i5.h hVar) {
        p.a aVar = com.tencent.luggage.wxa.g6.p.f126564o;
        Context context = this.f131441a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "host.context");
        com.tencent.luggage.wxa.g6.p a16 = aVar.a(context);
        Context context2 = this.f131441a.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "host.context");
        com.tencent.luggage.wxa.g6.f a17 = a16.a(context2, 1, false);
        TextView textView = new TextView(this.f131441a.getContext());
        textView.setMinHeight(com.tencent.luggage.wxa.kn.a.c(this.f131441a.getContext(), R.dimen.biw));
        int c16 = com.tencent.luggage.wxa.kn.a.c(this.f131441a.getContext(), R.dimen.c5r);
        textView.setPadding(c16, 0, c16, 0);
        textView.setGravity(17);
        textView.setTextColor(ContextCompat.getColor(this.f131441a.getContext(), R.color.b9y));
        textView.setTextSize(0, com.tencent.luggage.wxa.kn.a.d(this.f131441a.getContext(), R.dimen.bpe));
        Context context3 = this.f131441a.getContext();
        Object[] objArr = new Object[1];
        String str = hVar.c().f128272e;
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "usageInfo.desc ?: \"\"");
        }
        objArr[0] = str;
        textView.setText(context3.getString(R.string.z5e, objArr));
        a17.a(textView);
        a17.a(new h());
        a17.a(new i(hVar));
        a17.a();
    }

    public final void a(ContextMenu contextMenu) {
        if (contextMenu != null) {
            contextMenu.add(0, 0, 0, this.f131441a.getContext().getString(R.string.z5g));
        }
    }

    public final void a(MenuItem menuItem, Function0 function0) {
        if ((menuItem != null && menuItem.getGroupId() == 0) && menuItem.getItemId() == 0) {
            function0.invoke();
        } else {
            w.f("MicroMsg.AppBrandUserInfoRevokePage", "onRevokeMenuClick, not revoke menu");
        }
    }

    public final void a() {
        ProgressDialog progressDialog = this.f131446f;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        this.f131446f = null;
    }
}
