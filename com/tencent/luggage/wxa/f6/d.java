package com.tencent.luggage.wxa.f6;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.g6.p;
import com.tencent.luggage.wxa.mo.p;
import com.tencent.luggage.wxa.mo.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.io.FilenameUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    public static final a f125332i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Function1 f125333a;

    /* renamed from: b, reason: collision with root package name */
    public int f125334b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f125335c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f125336d;

    /* renamed from: e, reason: collision with root package name */
    public ViewPager f125337e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f125338f;

    /* renamed from: g, reason: collision with root package name */
    public final Set f125339g;

    /* renamed from: h, reason: collision with root package name */
    public final Set f125340h;

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
    public static final class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f125363a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f125364b;

        public c(Function1 function1, com.tencent.luggage.wxa.tk.i iVar) {
            this.f125363a = function1;
            this.f125364b = iVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f125363a.invoke(this.f125364b.f141499a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.f6.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class ViewOnLongClickListenerC6200d implements View.OnLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f125365a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f125366b;

        public ViewOnLongClickListenerC6200d(Function1 function1, com.tencent.luggage.wxa.tk.i iVar) {
            this.f125365a = function1;
            this.f125366b = iVar;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            this.f125365a.invoke(this.f125366b.f141499a);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function1 {
        public e() {
            super(1);
        }

        public final void a(Uri uri) {
            d.this.f125333a.invoke(d.this);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Uri) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function1 {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements p {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f125369a;

            public a(int i3) {
                this.f125369a = i3;
            }

            @Override // com.tencent.luggage.wxa.mo.p
            public final void a(com.tencent.luggage.wxa.mo.h hVar) {
                hVar.add(this.f125369a, R.string.f242337ua);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements u {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f125370a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f125371b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Uri f125372c;

            public b(int i3, d dVar, Uri uri) {
                this.f125370a = i3;
                this.f125371b = dVar;
                this.f125372c = uri;
            }

            @Override // com.tencent.luggage.wxa.mo.u
            public final void a(MenuItem menuItem, int i3) {
                if (menuItem.getItemId() == this.f125370a) {
                    this.f125371b.a(this.f125372c);
                }
            }
        }

        public f() {
            super(1);
        }

        public final void a(Uri uri) {
            p.a aVar = com.tencent.luggage.wxa.g6.p.f126564o;
            Context context = d.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            com.tencent.luggage.wxa.g6.p b16 = aVar.b(context);
            Context context2 = d.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            com.tencent.luggage.wxa.g6.f a16 = b16.a(context2, 1, false);
            d dVar = d.this;
            a16.a(new a(1));
            a16.a(new b(1, dVar, uri));
            a16.a();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Uri) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends PagerAdapter {
        public g() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int i3, Object object) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(object, "object");
            container.removeView((View) d.this.f125336d.get(i3));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            ArrayList arrayList = d.this.f125335c;
            Intrinsics.checkNotNull(arrayList);
            return arrayList.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int i3) {
            Intrinsics.checkNotNullParameter(container, "container");
            container.addView((View) d.this.f125336d.get(i3));
            Object obj = d.this.f125336d.get(i3);
            Intrinsics.checkNotNullExpressionValue(obj, "mViews[position]");
            return obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(object, "object");
            return Intrinsics.areEqual(object, view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f125375a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f125376b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f125377c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Uri f125378d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f125379a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Uri f125380b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Context f125381c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Uri uri, Context context, Continuation continuation) {
                super(2, continuation);
                this.f125380b = uri;
                this.f125381c = context;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f125380b, this.f125381c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                boolean z16;
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f125379a == 0) {
                    ResultKt.throwOnFailure(obj);
                    String b16 = com.tencent.luggage.wxa.bo.e.b(FilenameUtils.getExtension(this.f125380b.toString()));
                    boolean z17 = true;
                    if (b16 != null && b16.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        InputStream a16 = x.a(this.f125380b);
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            com.tencent.luggage.wxa.x9.a.decodeStream(a16, null, options);
                            String str = options.outMimeType;
                            CloseableKt.closeFinally(a16, null);
                            if (str != null && str.length() != 0) {
                                z17 = false;
                            }
                            if (!z17) {
                                b16 = com.tencent.luggage.wxa.bo.e.a(str);
                            }
                        } finally {
                        }
                    }
                    if (b16 == null) {
                        b16 = "";
                    }
                    String toPath = com.tencent.luggage.wxa.bo.b.b(b16);
                    v k3 = new v(toPath).k();
                    Intrinsics.checkNotNull(k3);
                    k3.w();
                    x.a(this.f125380b.toString(), toPath);
                    com.tencent.luggage.wxa.bo.b.a(x.b(toPath, false), this.f125381c);
                    Intrinsics.checkNotNullExpressionValue(toPath, "toPath");
                    return toPath;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Context context, d dVar, Uri uri, Continuation continuation) {
            super(2, continuation);
            this.f125376b = context;
            this.f125377c = dVar;
            this.f125378d = uri;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new i(this.f125376b, this.f125377c, this.f125378d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f125375a;
            try {
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    a aVar = new a(this.f125378d, this.f125376b, null);
                    this.f125375a = 1;
                    obj = BuildersKt.withContext(io5, aVar, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Toast.makeText(this.f125376b, this.f125377c.getContext().getString(R.string.zwx, com.tencent.luggage.wxa.bo.b.d((String) obj)), 0).show();
            } catch (Exception e16) {
                w.b("Luggage.WMPFPreviewView", "requestSaveToDisk(uri:" + this.f125378d + ") exception=" + e16);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, String[] urls, int i3, Function1 onDismiss) {
        super(context);
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        this.f125333a = onDismiss;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Arrays.copyOf(urls, urls.length));
        this.f125335c = arrayListOf;
        this.f125334b = i3;
        this.f125336d = new ArrayList();
        LayoutInflater.from(context).inflate(R.layout.f167551dr0, (ViewGroup) this, true);
        this.f125339g = new LinkedHashSet();
        this.f125340h = new LinkedHashSet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002e, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r0);
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAttachedToWindow() {
        Integer num;
        List filterNotNull;
        super.onAttachedToWindow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("url.size: ");
        ArrayList arrayList = this.f125335c;
        Integer num2 = null;
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        sb5.append(num);
        w.d("Luggage.WMPFPreviewView", sb5.toString());
        ArrayList arrayList2 = this.f125335c;
        if (arrayList2 != null && filterNotNull != null) {
            Iterator it = filterNotNull.iterator();
            while (it.hasNext()) {
                this.f125336d.add(a((String) it.next(), new e(), new f()));
            }
        }
        this.f125337e = (ViewPager) findViewById(R.id.kwk);
        TextView textView = (TextView) findViewById(R.id.f108746dy);
        this.f125338f = textView;
        Intrinsics.checkNotNull(textView);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(this.f125334b + 1);
        sb6.append('/');
        ArrayList arrayList3 = this.f125335c;
        if (arrayList3 != null) {
            num2 = Integer.valueOf(arrayList3.size());
        }
        sb6.append(num2);
        textView.setText(sb6.toString());
        ViewPager viewPager = this.f125337e;
        Intrinsics.checkNotNull(viewPager);
        viewPager.setAdapter(new g());
        ViewPager viewPager2 = this.f125337e;
        Intrinsics.checkNotNull(viewPager2);
        viewPager2.addOnPageChangeListener(new h());
        ViewPager viewPager3 = this.f125337e;
        Intrinsics.checkNotNull(viewPager3);
        viewPager3.setCurrentItem(this.f125334b, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator it = this.f125339g.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
        this.f125339g.clear();
        Iterator it5 = this.f125340h.iterator();
        while (it5.hasNext()) {
            Job job = (Job) ((WeakReference) it5.next()).get();
            if (job != null) {
                Intrinsics.checkNotNullExpressionValue(job, "get()");
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
        this.f125340h.clear();
    }

    public final View a(String str, Function1 function1, Function1 function12) {
        Job launch$default;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168239ff3, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        View findViewById = frameLayout.findViewById(R.id.g2e);
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        c cVar = new c(function1, iVar);
        ViewOnLongClickListenerC6200d viewOnLongClickListenerC6200d = new ViewOnLongClickListenerC6200d(function12, iVar);
        frameLayout.setOnClickListener(cVar);
        frameLayout.setOnLongClickListener(viewOnLongClickListenerC6200d);
        if (URLUtil.isNetworkUrl(str)) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(com.tencent.luggage.wxa.mn.a.a(this), null, null, new b(str, this, iVar, cVar, viewOnLongClickListenerC6200d, frameLayout, findViewById, null), 3, null);
            this.f125340h.add(new WeakReference(launch$default));
        } else {
            if (str.length() > 0) {
                com.tencent.luggage.wxa.n6.c cVar2 = new com.tencent.luggage.wxa.n6.c(getContext());
                cVar2.setImage(com.tencent.luggage.wxa.n6.a.a(str));
                findViewById.setVisibility(8);
                frameLayout.addView(cVar2);
                cVar2.setOnClickListener(cVar);
                cVar2.setOnLongClickListener(viewOnLongClickListenerC6200d);
                iVar.f141499a = cVar2.getSourceUri();
            }
        }
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);
        return frameLayout;
    }

    public final void a(Uri uri) {
        if (uri == null) {
            return;
        }
        Context applicationContext = getContext().getApplicationContext();
        if (ContextCompat.checkSelfPermission(getContext(), QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            BuildersKt__Builders_commonKt.launch$default(com.tencent.luggage.wxa.mn.a.a(this), null, null, new i(applicationContext, this, uri, null), 3, null);
        } else {
            Toast.makeText(applicationContext, R.string.zwy, 0).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements ViewPager.OnPageChangeListener {
        public h() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            Integer num;
            TextView textView = d.this.f125338f;
            if (textView != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(i3 + 1);
                sb5.append('/');
                ArrayList arrayList = d.this.f125335c;
                if (arrayList != null) {
                    num = Integer.valueOf(arrayList.size());
                } else {
                    num = null;
                }
                sb5.append(num);
                textView.setText(sb5.toString());
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public Object f125341a;

        /* renamed from: b, reason: collision with root package name */
        public Object f125342b;

        /* renamed from: c, reason: collision with root package name */
        public int f125343c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f125344d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ d f125345e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f125346f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f125347g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ View.OnLongClickListener f125348h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f125349i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ View f125350j;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v f125351a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(v vVar) {
                super(0);
                this.f125351a = vVar;
            }

            public final void a() {
                this.f125351a.d();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, d dVar, com.tencent.luggage.wxa.tk.i iVar, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, FrameLayout frameLayout, View view, Continuation continuation) {
            super(2, continuation);
            this.f125344d = str;
            this.f125345e = dVar;
            this.f125346f = iVar;
            this.f125347g = onClickListener;
            this.f125348h = onLongClickListener;
            this.f125349i = frameLayout;
            this.f125350j = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.f125344d, this.f125345e, this.f125346f, this.f125347g, this.f125348h, this.f125349i, this.f125350j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            v vVar;
            Ref.ObjectRef objectRef;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f125343c;
            if (i3 != 0) {
                if (i3 == 1) {
                    objectRef = (Ref.ObjectRef) this.f125342b;
                    vVar = (v) this.f125341a;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                vVar = new v(com.tencent.luggage.wxa.f6.h.INSTANCE.a(), String.valueOf(this.f125344d.hashCode()));
                this.f125345e.f125339g.add(new a(vVar));
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = "";
                CoroutineDispatcher io5 = Dispatchers.getIO();
                C6198b c6198b = new C6198b(this.f125344d, vVar, objectRef2, null);
                this.f125341a = vVar;
                this.f125342b = objectRef2;
                this.f125343c = 1;
                Object withContext = BuildersKt.withContext(io5, c6198b, this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                obj = withContext;
            }
            if (((Boolean) obj).booleanValue()) {
                if (Intrinsics.areEqual(objectRef.element, "image/gif")) {
                    ImageView imageView = new ImageView(this.f125345e.getContext());
                    com.bumptech.glide.b.u(imageView).o(new File(vVar.g())).p0(imageView);
                    this.f125346f.f141499a = Uri.fromFile(new File(vVar.g()));
                    imageView.setOnClickListener(this.f125347g);
                    imageView.setOnLongClickListener(this.f125348h);
                    this.f125349i.addView(imageView);
                } else {
                    com.tencent.luggage.wxa.n6.c cVar = new com.tencent.luggage.wxa.n6.c(this.f125345e.getContext());
                    String b16 = x.b(vVar.g(), false);
                    Intrinsics.checkNotNull(b16);
                    cVar.setImage(com.tencent.luggage.wxa.n6.a.a(b16));
                    this.f125346f.f141499a = cVar.getSourceUri();
                    cVar.setOnClickListener(this.f125347g);
                    cVar.setOnLongClickListener(this.f125348h);
                    this.f125349i.addView(cVar);
                }
            }
            this.f125350j.setVisibility(8);
            return Unit.INSTANCE;
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.f6.d$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6198b extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public Object f125352a;

            /* renamed from: b, reason: collision with root package name */
            public Object f125353b;

            /* renamed from: c, reason: collision with root package name */
            public Object f125354c;

            /* renamed from: d, reason: collision with root package name */
            public int f125355d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f125356e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ v f125357f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f125358g;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.f6.d$b$b$a */
            /* loaded from: classes8.dex */
            public static final class a extends Lambda implements Function1 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ CronetLogic.CronetHttpsCreateResult f125359a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(CronetLogic.CronetHttpsCreateResult cronetHttpsCreateResult) {
                    super(1);
                    this.f125359a = cronetHttpsCreateResult;
                }

                public final void a(Throwable th5) {
                    CronetLogic.cancelCronetTask(this.f125359a.taskId);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((Throwable) obj);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6198b(String str, v vVar, Ref.ObjectRef objectRef, Continuation continuation) {
                super(2, continuation);
                this.f125356e = str;
                this.f125357f = vVar;
                this.f125358g = objectRef;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C6198b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C6198b(this.f125356e, this.f125357f, this.f125358g, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                Continuation intercepted;
                Object coroutine_suspended2;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f125355d;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    String str = this.f125356e;
                    v vVar = this.f125357f;
                    Ref.ObjectRef objectRef = this.f125358g;
                    this.f125352a = str;
                    this.f125353b = vVar;
                    this.f125354c = objectRef;
                    this.f125355d = 1;
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                    cancellableContinuationImpl.initCancellability();
                    com.tencent.luggage.wxa.h6.e eVar = com.tencent.luggage.wxa.h6.e.f126875a;
                    String g16 = vVar.g();
                    Intrinsics.checkNotNullExpressionValue(g16, "filePath.absolutePath");
                    cancellableContinuationImpl.invokeOnCancellation(new a(CronetLogic.startCronetDownloadTask(eVar.a(str, g16), new C6199b(str, cancellableContinuationImpl, objectRef))));
                    obj = cancellableContinuationImpl.getResult();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (obj == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(this);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.f6.d$b$b$b, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6199b implements CronetLogic.CronetTaskCallback {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f125360a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ CancellableContinuation f125361b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ Ref.ObjectRef f125362c;

                public C6199b(String str, CancellableContinuation cancellableContinuation, Ref.ObjectRef objectRef) {
                    this.f125360a = str;
                    this.f125361b = cancellableContinuation;
                    this.f125362c = objectRef;
                }

                /* JADX WARN: Type inference failed for: r7v5, types: [T, java.lang.Object, java.lang.String] */
                @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
                public int onCronetReceiveHeader(CronetLogic.ResponseHeader header, int i3, String str) {
                    boolean equals;
                    Intrinsics.checkNotNullParameter(header, "header");
                    w.d("Luggage.WMPFPreviewView", "onCronetReceiveHeader, url:" + this.f125360a + ", status_code:" + i3);
                    CronetLogic.HeaderMap[] headerMapArr = header.headers;
                    Intrinsics.checkNotNullExpressionValue(headerMapArr, "header.headers");
                    int length = headerMapArr.length;
                    for (int i16 = 0; i16 < length; i16++) {
                        CronetLogic.HeaderMap headerMap = headerMapArr[i16];
                        equals = StringsKt__StringsJVMKt.equals(headerMap.key, "Content-Type", true);
                        if (equals) {
                            Ref.ObjectRef objectRef = this.f125362c;
                            ?? r75 = headerMap.value;
                            Intrinsics.checkNotNullExpressionValue(r75, "contentTypeItem.value");
                            objectRef.element = r75;
                            return 0;
                        }
                    }
                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                }

                @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
                public void onCronetTaskCompleted(String filekey, CronetLogic.CronetTaskResult result, String str) {
                    boolean z16;
                    Intrinsics.checkNotNullParameter(filekey, "filekey");
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (result.errorCode == 0 && 200 == result.statusCode) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    w.d("Luggage.WMPFPreviewView", "onCronetTaskCompleted url:" + this.f125360a + ", code:" + result.errorCode + ", statusCode:" + result.statusCode);
                    this.f125361b.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
                }

                @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
                public void onCronetReceiveChunkedData(CronetLogic.ChunkedData chunkedData, long j3) {
                }

                @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
                public void onCronetReceiveUploadProgress(long j3, long j16) {
                }

                @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
                public void onDownloadProgressChanged(String str, CronetLogic.CronetDownloadProgress cronetDownloadProgress) {
                }
            }
        }
    }
}
