package com.tencent.luggage.wxa.k5;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.luggage.setting.ui.WxaSettingUserInfoRevokeActivity;
import com.tencent.luggage.wxa.g6.r;
import com.tencent.luggage.wxa.g6.t;
import com.tencent.luggage.wxa.hn.fi;
import com.tencent.luggage.wxa.k5.f;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002R!\u0010\u0015\u001a\u00020\u000f8@X\u0080\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/luggage/wxa/k5/n;", "Lcom/tencent/luggage/wxa/g6/r;", "", "g", "", "b", "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Lcom/tencent/luggage/wxa/k5/a;", "actionBarType", "a", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/luggage/wxa/k5/f;", "Lkotlin/Lazy;", "l", "()Lcom/tencent/luggage/wxa/k5/f;", "getViewModel$luggage_standalone_mode_ext_release$annotations", "()V", "viewModel", "c", "Lcom/tencent/luggage/wxa/k5/a;", "curActionBarType", "Landroid/widget/Button;", "d", "Landroid/widget/Button;", "k", "()Landroid/widget/Button;", "setMManageBtn", "(Landroid/widget/Button;)V", "mManageBtn", "Lcom/tencent/luggage/wxa/g6/t;", "controller", "<init>", "(Lcom/tencent/luggage/wxa/g6/t;)V", "e", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class n extends r {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Lazy viewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public a curActionBarType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Button mManageBtn;

    @NotNull
    private static final Class<WxaSettingUserInfoRevokeActivity> ACTIVITY_CLASS = WxaSettingUserInfoRevokeActivity.class;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f131588a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.DEFAULT.ordinal()] = 1;
            iArr[a.WITH_TITLE.ordinal()] = 2;
            f131588a = iArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements MenuItem.OnMenuItemClickListener {
        public c() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            n.this.finish();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Observer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f131590a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f131591b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.k5.e f131592c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LinearLayoutManager f131593d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.k5.e f131594a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LinearLayoutManager f131595b;

            public a(com.tencent.luggage.wxa.k5.e eVar, LinearLayoutManager linearLayoutManager) {
                this.f131594a = eVar;
                this.f131595b = linearLayoutManager;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.k5.e eVar = this.f131594a;
                boolean z16 = true;
                if (this.f131595b.findLastCompletelyVisibleItemPosition() < this.f131594a.getNUM_BACKGOURND_ICON() - 1) {
                    z16 = false;
                }
                eVar.a(z16);
            }
        }

        public d(RecyclerView recyclerView, n nVar, com.tencent.luggage.wxa.k5.e eVar, LinearLayoutManager linearLayoutManager) {
            this.f131590a = recyclerView;
            this.f131591b = nVar;
            this.f131592c = eVar;
            this.f131593d = linearLayoutManager;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(fi fiVar) {
            w.d("MicroMsg.AppBrandUserInfoRevokePage", "onChanged#initContentArea");
            if (!com.tencent.luggage.wxa.rk.a.f139822a.a(fiVar)) {
                w.f("MicroMsg.AppBrandUserInfoRevokePage", "onChanged#initContentArea, rawUsageInfo is null or invalid");
            } else {
                this.f131590a.post(new a(this.f131592c, this.f131593d));
                this.f131591b.l().c().removeObserver(this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements com.tencent.luggage.wxa.k5.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f131596a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f131597b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends RecyclerView.OnScrollListener {

            /* renamed from: a, reason: collision with root package name */
            public int f131598a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n f131599b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f131600c;

            public a(n nVar, int i3) {
                this.f131599b = nVar;
                this.f131600c = i3;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
                com.tencent.luggage.wxa.k5.a aVar;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i3, i16);
                int i17 = this.f131598a + i16;
                this.f131598a = i17;
                n nVar = this.f131599b;
                if (i17 <= this.f131600c) {
                    aVar = com.tencent.luggage.wxa.k5.a.DEFAULT;
                } else {
                    aVar = com.tencent.luggage.wxa.k5.a.WITH_TITLE;
                }
                nVar.a(aVar);
            }
        }

        public e(RecyclerView recyclerView, n nVar) {
            this.f131596a = recyclerView;
            this.f131597b = nVar;
        }

        @Override // com.tencent.luggage.wxa.k5.d
        public final void a(int i3) {
            this.f131596a.addOnScrollListener(new a(this.f131597b, i3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function0 {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.k5.f invoke() {
            f.b bVar = com.tencent.luggage.wxa.k5.f.f131477h;
            n nVar = n.this;
            Intent intent = nVar.getIntent();
            Intrinsics.checkNotNull(intent);
            String stringExtra = intent.getStringExtra("appid");
            if (stringExtra == null) {
                stringExtra = "";
            }
            return (com.tencent.luggage.wxa.k5.f) bVar.a(nVar, stringExtra).get(com.tencent.luggage.wxa.k5.f.class);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull t controller) {
        super(controller);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(controller, "controller");
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new f());
        this.viewModel = lazy;
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void b() {
        super.b();
        if (!j()) {
            return;
        }
        m();
        o();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public int g() {
        return R.layout.dyr;
    }

    public final boolean j() {
        boolean z16;
        Intent intent = getIntent();
        Intrinsics.checkNotNull(intent);
        String stringExtra = intent.getStringExtra("appid");
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return true;
        }
        w.f("MicroMsg.AppBrandUserInfoRevokePage", "checkContextOnCreateEarly, appId is empty");
        finish();
        return false;
    }

    /* renamed from: k, reason: from getter */
    public final Button getMManageBtn() {
        return this.mManageBtn;
    }

    public final com.tencent.luggage.wxa.k5.f l() {
        return (com.tencent.luggage.wxa.k5.f) this.viewModel.getValue();
    }

    public final void m() {
        setBackBtn(new c());
        a(a.DEFAULT);
        getWindow().setNavigationBarColor(ContextCompat.getColor(getContext(), R.color.agv));
        this.mManageBtn = (Button) findViewById(R.id.ywq);
    }

    public final void o() {
        RecyclerView recyclerView;
        View findViewById = findViewById(R.id.f115316vp);
        if (findViewById instanceof RecyclerView) {
            recyclerView = (RecyclerView) findViewById;
        } else {
            recyclerView = null;
        }
        if (recyclerView == null) {
            w.f("MicroMsg.AppBrandUserInfoRevokePage", "initContentArea, findViewById return null");
            finish();
            return;
        }
        recyclerView.setFadingEdgeLength(getContext().getResources().getDimensionPixelOffset(R.dimen.bce));
        recyclerView.setVerticalFadingEdgeEnabled(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        com.tencent.luggage.wxa.k5.e eVar = new com.tencent.luggage.wxa.k5.e(this, new e(recyclerView, this));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(eVar);
        com.tencent.luggage.wxa.jl.c.f131190l.a(recyclerView, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : true, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
        l().c().observe(this, new d(recyclerView, this, eVar, linearLayoutManager));
    }

    public final void p() {
        w.d("MicroMsg.AppBrandUserInfoRevokePage", "showActionbarDefault");
        setTitle("");
        hideActionbarLine();
        setActionBarColor(ContextCompat.getColor(getContext(), R.color.agv));
    }

    public final void q() {
        w.d("MicroMsg.AppBrandUserInfoRevokePage", "showActionbarWithTitle");
        setTitle(R.string.z2g);
        showActionbarLine();
        setActionBarColor(ContextCompat.getColor(getContext(), R.color.agr));
    }

    public final void a(a actionBarType) {
        if (this.curActionBarType == actionBarType) {
            return;
        }
        int i3 = b.f131588a[actionBarType.ordinal()];
        if (i3 == 1) {
            p();
        } else if (i3 == 2) {
            q();
        }
        this.curActionBarType = actionBarType;
    }
}
