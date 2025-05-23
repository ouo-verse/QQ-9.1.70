package com.tencent.luggage.wxa.k5;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.setting.ui.WxaSettingPrivacyUseRecordActivity;
import com.tencent.luggage.wxa.g6.p;
import com.tencent.luggage.wxa.g6.r;
import com.tencent.luggage.wxa.g6.t;
import com.tencent.luggage.wxa.hn.ge;
import com.tencent.luggage.wxa.hn.hi;
import com.tencent.luggage.wxa.hn.ii;
import com.tencent.luggage.wxa.hn.ji;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mobileqq.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0003\f\u0005\u0012B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\f\u0010\u0005\u001a\u00020\u0007*\u00020\u000bH\u0002J\u0015\u0010\f\u001a\u0004\u0018\u00010\u0002*\u00020\u000bH\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/luggage/wxa/k5/k;", "Lcom/tencent/luggage/wxa/g6/r;", "", "g", "", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "j", "k", "l", "Lcom/tencent/luggage/wxa/hn/ge;", "a", "(Lcom/tencent/luggage/wxa/hn/ge;)Ljava/lang/Integer;", "", "Ljava/lang/String;", "username", "Landroid/app/ProgressDialog;", "c", "Landroid/app/ProgressDialog;", "loadingDialog", "Lcom/tencent/luggage/wxa/g6/t;", "controller", "<init>", "(Lcom/tencent/luggage/wxa/g6/t;)V", "d", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class k extends r {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public String username;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public ProgressDialog loadingDialog;

    @NotNull
    private static final Class<WxaSettingPrivacyUseRecordActivity> ACTIVITY_CLASS = WxaSettingPrivacyUseRecordActivity.class;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f131542a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f131543b;

        /* renamed from: c, reason: collision with root package name */
        public final TextView f131544c;

        /* renamed from: d, reason: collision with root package name */
        public final View f131545d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.dyd, parent, false));
            Intrinsics.checkNotNullParameter(parent, "parent");
            this.f131542a = (TextView) this.itemView.findViewById(R.id.f80134an);
            this.f131543b = (TextView) this.itemView.findViewById(R.id.f26020ce);
            this.f131544c = (TextView) this.itemView.findViewById(R.id.f97395k_);
            this.f131545d = this.itemView.findViewById(R.id.t_j);
        }

        public final View a() {
            return this.f131545d;
        }

        public final TextView b() {
            return this.f131543b;
        }

        public final TextView c() {
            return this.f131542a;
        }

        public final TextView d() {
            return this.f131544c;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements MenuItem.OnMenuItemClickListener {
        public d() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            k.this.finish();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements LoadMoreRecyclerView.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.i5.b f131547a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f131548b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f131549c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f131550d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public Object f131551a;

            /* renamed from: b, reason: collision with root package name */
            public Object f131552b;

            /* renamed from: c, reason: collision with root package name */
            public Object f131553c;

            /* renamed from: d, reason: collision with root package name */
            public Object f131554d;

            /* renamed from: e, reason: collision with root package name */
            public Object f131555e;

            /* renamed from: f, reason: collision with root package name */
            public Object f131556f;

            /* renamed from: g, reason: collision with root package name */
            public Object f131557g;

            /* renamed from: h, reason: collision with root package name */
            public Object f131558h;

            /* renamed from: i, reason: collision with root package name */
            public int f131559i;

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f131560j;

            /* renamed from: k, reason: collision with root package name */
            public final /* synthetic */ k f131561k;

            /* renamed from: l, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.i5.b f131562l;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ b f131563m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Ref.ObjectRef objectRef, k kVar, com.tencent.luggage.wxa.i5.b bVar, b bVar2, Continuation continuation) {
                super(2, continuation);
                this.f131560j = objectRef;
                this.f131561k = kVar;
                this.f131562l = bVar;
                this.f131563m = bVar2;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f131560j, this.f131561k, this.f131562l, this.f131563m, continuation);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                Ref.ObjectRef objectRef;
                com.tencent.luggage.wxa.i5.b bVar;
                k kVar;
                b bVar2;
                Object a16;
                Ref.ObjectRef objectRef2;
                Ref.ObjectRef objectRef3;
                com.tencent.luggage.wxa.i5.b bVar3;
                com.tencent.luggage.wxa.i5.b bVar4;
                k kVar2;
                b bVar5;
                b bVar6;
                ge geVar;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f131559i;
                if (i3 != 0) {
                    if (i3 == 1) {
                        bVar5 = (b) this.f131558h;
                        k kVar3 = (k) this.f131557g;
                        objectRef2 = (Ref.ObjectRef) this.f131556f;
                        bVar3 = (com.tencent.luggage.wxa.i5.b) this.f131555e;
                        bVar6 = (b) this.f131554d;
                        kVar2 = (k) this.f131553c;
                        objectRef3 = (Ref.ObjectRef) this.f131552b;
                        bVar4 = (com.tencent.luggage.wxa.i5.b) this.f131551a;
                        try {
                            ResultKt.throwOnFailure(obj);
                            kVar = kVar3;
                            a16 = obj;
                        } catch (Exception e16) {
                            e = e16;
                            bVar2 = bVar6;
                            kVar = kVar2;
                            objectRef = objectRef3;
                            bVar = bVar4;
                            w.f("WMPF.FloatWindowSetting", "onLoadMore, fetch fail since " + e);
                            geVar = null;
                            objectRef2 = objectRef;
                            bVar3 = bVar;
                            bVar5 = bVar2;
                            k.b(bVar3, objectRef2, kVar, bVar5, geVar);
                            return Unit.INSTANCE;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    objectRef = this.f131560j;
                    Integer num = (Integer) objectRef.element;
                    if (num == null) {
                        w.d("WMPF.FloatWindowSetting", "onLoadMore, fetchToken is null, not need");
                        return Unit.INSTANCE;
                    }
                    bVar = this.f131562l;
                    kVar = this.f131561k;
                    bVar2 = this.f131563m;
                    try {
                        com.tencent.luggage.wxa.i5.e eVar = com.tencent.luggage.wxa.i5.e.f129480b;
                        String str = kVar.username;
                        if (str == null) {
                            str = "";
                        }
                        int intValue = num.intValue();
                        this.f131551a = bVar;
                        this.f131552b = objectRef;
                        this.f131553c = kVar;
                        this.f131554d = bVar2;
                        this.f131555e = bVar;
                        this.f131556f = objectRef;
                        this.f131557g = kVar;
                        this.f131558h = bVar2;
                        this.f131559i = 1;
                        a16 = com.tencent.luggage.wxa.i5.e.a(eVar, str, intValue, 0, this, 4, null);
                        if (a16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef2 = objectRef;
                        objectRef3 = objectRef2;
                        bVar3 = bVar;
                        bVar4 = bVar3;
                        kVar2 = kVar;
                        bVar5 = bVar2;
                        bVar6 = bVar5;
                    } catch (Exception e17) {
                        e = e17;
                        w.f("WMPF.FloatWindowSetting", "onLoadMore, fetch fail since " + e);
                        geVar = null;
                        objectRef2 = objectRef;
                        bVar3 = bVar;
                        bVar5 = bVar2;
                        k.b(bVar3, objectRef2, kVar, bVar5, geVar);
                        return Unit.INSTANCE;
                    }
                }
                geVar = (ge) a16;
                k.b(bVar3, objectRef2, kVar, bVar5, geVar);
                return Unit.INSTANCE;
            }
        }

        public e(com.tencent.luggage.wxa.i5.b bVar, k kVar, Ref.ObjectRef objectRef, b bVar2) {
            this.f131547a = bVar;
            this.f131548b = kVar;
            this.f131549c = objectRef;
            this.f131550d = bVar2;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.c
        public final void a(LoadMoreRecyclerView loadMoreRecyclerView, RecyclerView.Adapter adapter) {
            if (this.f131547a.b()) {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f131548b), null, null, new a(this.f131549c, this.f131548b, this.f131547a, this.f131550d, null), 3, null);
            } else {
                w.d("WMPF.FloatWindowSetting", "onLoadMore, loading is not shown");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends SuspendLambda implements Function2 {
        public final /* synthetic */ Ref.ObjectRef C;
        public final /* synthetic */ b D;
        public final /* synthetic */ LoadMoreRecyclerView E;

        /* renamed from: a, reason: collision with root package name */
        public Object f131564a;

        /* renamed from: b, reason: collision with root package name */
        public Object f131565b;

        /* renamed from: c, reason: collision with root package name */
        public Object f131566c;

        /* renamed from: d, reason: collision with root package name */
        public Object f131567d;

        /* renamed from: e, reason: collision with root package name */
        public Object f131568e;

        /* renamed from: f, reason: collision with root package name */
        public Object f131569f;

        /* renamed from: g, reason: collision with root package name */
        public Object f131570g;

        /* renamed from: h, reason: collision with root package name */
        public Object f131571h;

        /* renamed from: i, reason: collision with root package name */
        public Object f131572i;

        /* renamed from: j, reason: collision with root package name */
        public Object f131573j;

        /* renamed from: k, reason: collision with root package name */
        public int f131574k;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.i5.b f131576m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(com.tencent.luggage.wxa.i5.b bVar, Ref.ObjectRef objectRef, b bVar2, LoadMoreRecyclerView loadMoreRecyclerView, Continuation continuation) {
            super(2, continuation);
            this.f131576m = bVar;
            this.C = objectRef;
            this.D = bVar2;
            this.E = loadMoreRecyclerView;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new f(this.f131576m, this.C, this.D, this.E, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00d6  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            b bVar;
            Ref.ObjectRef objectRef;
            b bVar2;
            LoadMoreRecyclerView loadMoreRecyclerView;
            com.tencent.luggage.wxa.i5.b bVar3;
            k kVar;
            Object a16;
            com.tencent.luggage.wxa.i5.b bVar4;
            k kVar2;
            Ref.ObjectRef objectRef2;
            LoadMoreRecyclerView loadMoreRecyclerView2;
            LoadMoreRecyclerView loadMoreRecyclerView3;
            b bVar5;
            Ref.ObjectRef objectRef3;
            ge geVar;
            k kVar3;
            com.tencent.luggage.wxa.i5.b bVar6;
            ProgressDialog progressDialog;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f131574k;
            ProgressDialog progressDialog2 = null;
            if (i3 != 0) {
                if (i3 == 1) {
                    loadMoreRecyclerView2 = (LoadMoreRecyclerView) this.f131573j;
                    b bVar7 = (b) this.f131572i;
                    objectRef2 = (Ref.ObjectRef) this.f131571h;
                    kVar2 = (k) this.f131570g;
                    bVar4 = (com.tencent.luggage.wxa.i5.b) this.f131569f;
                    loadMoreRecyclerView = (LoadMoreRecyclerView) this.f131568e;
                    bVar2 = (b) this.f131567d;
                    objectRef = (Ref.ObjectRef) this.f131566c;
                    kVar = (k) this.f131565b;
                    bVar3 = (com.tencent.luggage.wxa.i5.b) this.f131564a;
                    try {
                        ResultKt.throwOnFailure(obj);
                        bVar = bVar7;
                        a16 = obj;
                    } catch (Exception e16) {
                        e = e16;
                        w.f("WMPF.FloatWindowSetting", "initContentArea, fetch fail since " + e);
                        loadMoreRecyclerView3 = loadMoreRecyclerView;
                        bVar5 = bVar2;
                        objectRef3 = objectRef;
                        geVar = null;
                        kVar3 = kVar;
                        bVar6 = bVar3;
                        k.b(bVar6, kVar3, objectRef3, bVar5, loadMoreRecyclerView3, geVar);
                        progressDialog = k.this.loadingDialog;
                        if (progressDialog == null) {
                        }
                        progressDialog2.dismiss();
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                com.tencent.luggage.wxa.i5.b bVar8 = this.f131576m;
                k kVar4 = k.this;
                Ref.ObjectRef objectRef4 = this.C;
                bVar = this.D;
                LoadMoreRecyclerView loadMoreRecyclerView4 = this.E;
                try {
                    com.tencent.luggage.wxa.i5.e eVar = com.tencent.luggage.wxa.i5.e.f129480b;
                    String str = kVar4.username;
                    if (str == null) {
                        str = "";
                    }
                    this.f131564a = bVar8;
                    this.f131565b = kVar4;
                    this.f131566c = objectRef4;
                    this.f131567d = bVar;
                    this.f131568e = loadMoreRecyclerView4;
                    this.f131569f = bVar8;
                    this.f131570g = kVar4;
                    this.f131571h = objectRef4;
                    this.f131572i = bVar;
                    this.f131573j = loadMoreRecyclerView4;
                    this.f131574k = 1;
                    a16 = com.tencent.luggage.wxa.i5.e.a(eVar, str, 0, 0, this, 6, null);
                    if (a16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bVar4 = bVar8;
                    kVar2 = kVar4;
                    objectRef2 = objectRef4;
                    objectRef = objectRef2;
                    bVar2 = bVar;
                    loadMoreRecyclerView2 = loadMoreRecyclerView4;
                    loadMoreRecyclerView = loadMoreRecyclerView2;
                    kVar = kVar2;
                    bVar3 = bVar4;
                } catch (Exception e17) {
                    e = e17;
                    objectRef = objectRef4;
                    bVar2 = bVar;
                    loadMoreRecyclerView = loadMoreRecyclerView4;
                    bVar3 = bVar8;
                    kVar = kVar4;
                    w.f("WMPF.FloatWindowSetting", "initContentArea, fetch fail since " + e);
                    loadMoreRecyclerView3 = loadMoreRecyclerView;
                    bVar5 = bVar2;
                    objectRef3 = objectRef;
                    geVar = null;
                    kVar3 = kVar;
                    bVar6 = bVar3;
                    k.b(bVar6, kVar3, objectRef3, bVar5, loadMoreRecyclerView3, geVar);
                    progressDialog = k.this.loadingDialog;
                    if (progressDialog == null) {
                    }
                    progressDialog2.dismiss();
                    return Unit.INSTANCE;
                }
            }
            loadMoreRecyclerView3 = loadMoreRecyclerView2;
            geVar = (ge) a16;
            objectRef3 = objectRef2;
            bVar6 = bVar4;
            bVar5 = bVar;
            kVar3 = kVar2;
            k.b(bVar6, kVar3, objectRef3, bVar5, loadMoreRecyclerView3, geVar);
            progressDialog = k.this.loadingDialog;
            if (progressDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
            } else {
                progressDialog2 = progressDialog;
            }
            progressDialog2.dismiss();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerView f131577a;

        public g(LoadMoreRecyclerView loadMoreRecyclerView) {
            this.f131577a = loadMoreRecyclerView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f131577a.scrollToPosition(0);
            this.f131577a.a(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull t controller) {
        super(controller);
        Intrinsics.checkNotNullParameter(controller, "controller");
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public int g() {
        return R.layout.dyb;
    }

    public final boolean j() {
        boolean z16;
        Intent intent = getIntent();
        Intrinsics.checkNotNull(intent);
        String stringExtra = intent.getStringExtra("username");
        this.username = stringExtra;
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return true;
        }
        w.f("WMPF.FloatWindowSetting", "checkContextOnCreateEarly, username is empty");
        finish();
        return false;
    }

    public final void k() {
        setBackBtn(new d());
        setTitle(R.string.z4u);
        hideActionbarLine();
        setActionBarColor(ContextCompat.getColor(getContext(), R.color.agv));
        getWindow().setNavigationBarColor(ContextCompat.getColor(getContext(), R.color.agv));
    }

    public final void l() {
        LoadMoreRecyclerView loadMoreRecyclerView = (LoadMoreRecyclerView) findViewById(R.id.b9s);
        if (loadMoreRecyclerView == null) {
            w.f("WMPF.FloatWindowSetting", "initContentArea, useRecordContentArea is null");
            finish();
            return;
        }
        loadMoreRecyclerView.setPadding(0, com.tencent.luggage.wxa.kn.a.c(getContext(), R.dimen.bht), 0, 0);
        com.tencent.luggage.wxa.i5.b bVar = new com.tencent.luggage.wxa.i5.b(loadMoreRecyclerView, R.string.z4s);
        loadMoreRecyclerView.setLoadingView(bVar.a());
        loadMoreRecyclerView.a(false);
        com.tencent.luggage.wxa.jl.c.f131190l.a(loadMoreRecyclerView, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : true, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
        b bVar2 = new b();
        loadMoreRecyclerView.setAdapter(bVar2);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        loadMoreRecyclerView.setOnLoadingStateChangedListener(new e(bVar, this, objectRef, bVar2));
        ProgressDialog progressDialog = this.loadingDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
            progressDialog = null;
        }
        progressDialog.show();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new f(bVar, objectRef, bVar2, loadMoreRecyclerView, null), 3, null);
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.loadingDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
            progressDialog = null;
        }
        progressDialog.dismiss();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void b() {
        super.b();
        p.a aVar = p.f126564o;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        p a16 = aVar.a(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ProgressDialog f16 = a16.f(context2);
        f16.setIndeterminate(true);
        this.loadingDialog = f16;
        if (j()) {
            k();
            l();
        }
    }

    public static final void a(LoadMoreRecyclerView loadMoreRecyclerView, k kVar) {
        w.d("WMPF.FloatWindowSetting", "showEmptyView");
        loadMoreRecyclerView.setPadding(0, 0, 0, 0);
        View inflate = LayoutInflater.from(kVar.getContext()).inflate(R.layout.dyc, (ViewGroup) loadMoreRecyclerView, false);
        if (inflate != null) {
            loadMoreRecyclerView.b(inflate);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f131539a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final SimpleDateFormat f131540b;

        /* renamed from: c, reason: collision with root package name */
        public final SimpleDateFormat f131541c;

        public b() {
            Locale locale = Locale.US;
            this.f131540b = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, locale);
            this.f131541c = new SimpleDateFormat("MM/dd HH:mm", locale);
        }

        public final void a(List fetchedUseRecordList) {
            Intrinsics.checkNotNullParameter(fetchedUseRecordList, "fetchedUseRecordList");
            int size = this.f131539a.size();
            int size2 = fetchedUseRecordList.size();
            w.d("WMPF.FloatWindowSetting", "appendFetchedUseRecordList, posInsert: " + size + ", insertCount: " + size2);
            this.f131539a.addAll(fetchedUseRecordList);
            notifyItemRangeInserted(size, size2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.f131539a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(ViewGroup parent, int i3) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            return new c(parent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(c holder, int i3) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            try {
                hi hiVar = (hi) this.f131539a.get(i3);
                Intrinsics.checkNotNullExpressionValue(hiVar, "try {\n                  \u2026 return\n                }");
                TextView c16 = holder.c();
                if (c16 != null) {
                    ii iiVar = hiVar.f127820e;
                    c16.setText(iiVar != null ? iiVar.f127908e : null);
                }
                TextView d16 = holder.d();
                if (d16 != null) {
                    d16.setText(a(hiVar.f127821f));
                }
                TextView b16 = holder.b();
                if (b16 != null) {
                    ji jiVar = hiVar.f127819d;
                    String str = jiVar != null ? jiVar.f127968e : null;
                    if (!(str == null || str.length() == 0)) {
                        b16.setVisibility(0);
                        b16.setText(b16.getContext().getString(R.string.z4t, str));
                    } else {
                        b16.setVisibility(8);
                    }
                }
                View a16 = holder.a();
                if (a16 == null) {
                    return;
                }
                a16.setVisibility(i3 != this.f131539a.size() - 1 ? 4 : 0);
            } catch (Exception e16) {
                w.f("WMPF.FloatWindowSetting", "onBindViewHolder, get useRecord fail since " + e16 + ", position: " + i3);
            }
        }

        public final String a(long j3) {
            long j16 = j3 * 1000;
            return DateUtils.isToday(j16) ? this.f131540b.format(new Date(j16)) : this.f131541c.format(new Date(j16));
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Integer] */
    public static final void b(com.tencent.luggage.wxa.i5.b bVar, k kVar, Ref.ObjectRef objectRef, b bVar2, LoadMoreRecyclerView loadMoreRecyclerView, ge geVar) {
        if (geVar != null) {
            LinkedList linkedList = geVar.f127716e;
            if (!(linkedList == null || linkedList.isEmpty())) {
                bVar.a(kVar.b(geVar));
                objectRef.element = kVar.a(geVar);
                LinkedList linkedList2 = geVar.f127716e;
                Intrinsics.checkNotNullExpressionValue(linkedList2, "resp.record_list");
                bVar2.a(linkedList2);
                loadMoreRecyclerView.post(new g(loadMoreRecyclerView));
                return;
            }
        }
        w.d("WMPF.FloatWindowSetting", "onFirstTimesFetched, resp is empty");
        a(loadMoreRecyclerView, kVar);
    }

    public final Integer a(ge geVar) {
        Object lastOrNull;
        if (b(geVar)) {
            LinkedList record_list = geVar.f127716e;
            Intrinsics.checkNotNullExpressionValue(record_list, "record_list");
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) record_list);
            hi hiVar = (hi) lastOrNull;
            if (hiVar != null) {
                return Integer.valueOf(hiVar.f127821f);
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Integer] */
    public static final void b(com.tencent.luggage.wxa.i5.b bVar, Ref.ObjectRef objectRef, k kVar, b bVar2, ge geVar) {
        if (geVar != null) {
            LinkedList linkedList = geVar.f127716e;
            if (!(linkedList == null || linkedList.isEmpty())) {
                bVar.a(kVar.b(geVar));
                objectRef.element = kVar.a(geVar);
                LinkedList linkedList2 = geVar.f127716e;
                Intrinsics.checkNotNullExpressionValue(linkedList2, "resp.record_list");
                bVar2.a(linkedList2);
                return;
            }
        }
        w.d("WMPF.FloatWindowSetting", "onSecondTimesFetched, resp is empty");
        bVar.a(false);
        objectRef.element = null;
    }

    public final boolean b(ge geVar) {
        return 1 == geVar.f127717f;
    }
}
