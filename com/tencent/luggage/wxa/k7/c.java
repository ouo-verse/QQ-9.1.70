package com.tencent.luggage.wxa.k7;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.mo.a0;
import com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mobileqq.R;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public static final a f131757b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final SparseIntArray f131758c = new SparseIntArray();

    /* renamed from: a, reason: collision with root package name */
    public final Context f131759a;

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
    public static final class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f131760a;

        public b(Function0 function0) {
            this.f131760a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f131760a.invoke();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k7.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class ViewOnClickListenerC6366c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f131761a;

        public ViewOnClickListenerC6366c(Function0 function0) {
            this.f131761a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f131761a.invoke();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f131762a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.s6.h f131763b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TextView f131764c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f131765a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ double f131766b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ TextView f131767c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(double d16, TextView textView, Continuation continuation) {
                super(2, continuation);
                this.f131766b = d16;
                this.f131767c = textView;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f131766b, this.f131767c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                boolean z16;
                boolean z17;
                boolean z18;
                String format;
                boolean isBlank;
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f131765a == 0) {
                    ResultKt.throwOnFailure(obj);
                    double d16 = this.f131766b;
                    if (d16 == 0.0d) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        Context context = this.f131767c.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        format = a0.e(context, R.string.f242497uq);
                    } else {
                        if (d16 == -1.0d) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            Context context2 = this.f131767c.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "context");
                            format = a0.e(context2, R.string.f242477uo);
                        } else {
                            if (d16 == -2.0d) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (z18) {
                                format = "";
                            } else {
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                Context context3 = this.f131767c.getContext();
                                Intrinsics.checkNotNullExpressionValue(context3, "context");
                                format = String.format(a0.e(context3, R.string.f242517us), Arrays.copyOf(new Object[]{String.valueOf(this.f131766b)}, 1));
                                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                            }
                        }
                    }
                    isBlank = StringsKt__StringsJVMKt.isBlank(format);
                    if (isBlank) {
                        this.f131767c.setVisibility(8);
                    } else {
                        this.f131767c.setVisibility(0);
                        this.f131767c.setText(format);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.tencent.luggage.wxa.s6.h hVar, TextView textView, Continuation continuation) {
            super(2, continuation);
            this.f131763b = hVar;
            this.f131764c = textView;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new d(this.f131763b, this.f131764c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f131762a;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                String str = this.f131763b.getRuntime().S().G;
                Intrinsics.checkNotNullExpressionValue(str, "page.runtime.initConfig.username");
                this.f131762a = 1;
                obj = com.tencent.luggage.wxa.s6.a.a(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            double doubleValue = ((Number) obj).doubleValue();
            MainCoroutineDispatcher main = Dispatchers.getMain();
            a aVar = new a(doubleValue, this.f131764c, null);
            this.f131762a = 2;
            if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.s6.h f131769b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.tencent.luggage.wxa.s6.h hVar) {
            super(0);
            this.f131769b = hVar;
        }

        public final void a() {
            WxaProfileActivity.Companion companion = WxaProfileActivity.INSTANCE;
            Context context = c.this.f131759a;
            String appId = this.f131769b.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "page.appId");
            companion.show(context, appId, this.f131769b.getRuntime().S().f130793e0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context ctx) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.f131759a = ctx;
        a(ctx);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setPage(@NotNull com.tencent.luggage.wxa.s6.h page) {
        String e16;
        boolean z16;
        int i3;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(page, "page");
        String appId = page.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "page.appId");
        int i16 = 8;
        if (a(appId) == 1) {
            a0.a(this, "trading_guarantee_icon").setVisibility(0);
        } else {
            a0.a(this, "trading_guarantee_icon").setVisibility(8);
        }
        e eVar = new e(page);
        View a16 = a0.a(this, "icon");
        AppBrandSimpleImageLoader.instance().attach((ImageView) a0.a(a16, "icon"), page.getRuntime().j0().f125957c, R.drawable.ojy, new WxaIconTransformation());
        a16.setOnClickListener(new b(eVar));
        a0.a(this, "name_area").setOnClickListener(new ViewOnClickListenerC6366c(eVar));
        TextView textView = (TextView) a0.a(this, "name");
        textView.getPaint().setFakeBoldText(true);
        textView.setText(page.getRuntime().j0().f125955a);
        TextView textView2 = (TextView) a0.a(this, "debug_type_desc");
        int a17 = page.getRuntime().j0().a();
        if (a17 != 1) {
            if (a17 != 2) {
                e16 = null;
            } else {
                e16 = a0.e(this.f131759a, R.string.ywo);
            }
        } else {
            e16 = a0.e(this.f131759a, R.string.ywp);
        }
        textView2.setText(e16);
        if (e16 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(e16);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                textView2.setVisibility(i3);
                ImageView imageView = (ImageView) a0.a(this, "original_label");
                if (page.getRuntime().S().f125814g == 1) {
                    i16 = 0;
                }
                imageView.setVisibility(i16);
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new d(page, (TextView) a0.a(this, LocalPhotoFaceInfo.SCORE), null), 3, null);
            }
        }
        z16 = true;
        if (!z16) {
        }
        textView2.setVisibility(i3);
        ImageView imageView2 = (ImageView) a0.a(this, "original_label");
        if (page.getRuntime().S().f125814g == 1) {
        }
        imageView2.setVisibility(i16);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new d(page, (TextView) a0.a(this, LocalPhotoFaceInfo.SCORE), null), 3, null);
    }

    public final int a(String str) {
        n0.d g16;
        n0.d.a aVar;
        SparseIntArray sparseIntArray = f131758c;
        int i3 = sparseIntArray.get(str.hashCode(), Integer.MIN_VALUE);
        if (Integer.MIN_VALUE != i3) {
            return i3;
        }
        try {
            n0 a16 = o0.a().a(str, "dynamicInfo");
            if (a16 == null || (g16 = a16.g()) == null || (aVar = g16.f125894a) == null) {
                return 0;
            }
            int i16 = aVar.M;
            sparseIntArray.put(str.hashCode(), i16);
            return i16;
        } catch (Exception unused) {
            w.b("Luggage.WxaMenuHeader", "getTradingGuaranteeFlag by ContentProvider with appId:" + str + ", get exception");
            return 0;
        }
    }

    public final void a(Context context) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        setGravity(16);
        setPadding(0, 0, 0, a0.c(context, R.dimen.bht));
        Unit unit = Unit.INSTANCE;
        setLayoutParams(layoutParams);
        setOrientation(1);
        Constructor declaredConstructor = LinearLayout.class.getDeclaredConstructor(Context.class);
        declaredConstructor.setAccessible(true);
        View view = (View) declaredConstructor.newInstance(getContext());
        Intrinsics.checkNotNullExpressionValue(view, "view");
        LinearLayout linearLayout = (LinearLayout) view;
        int a16 = a0.a(context, 68);
        Class cls = Integer.TYPE;
        Constructor declaredConstructor2 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor2.setAccessible(true);
        ViewGroup.LayoutParams lp5 = (ViewGroup.LayoutParams) declaredConstructor2.newInstance(-1, Integer.valueOf(a16));
        Intrinsics.checkNotNullExpressionValue(lp5, "lp");
        linearLayout.setLayoutParams(lp5);
        a0.b(linearLayout, a0.c(context, R.dimen.bh9));
        linearLayout.setGravity(8388627);
        linearLayout.setOrientation(1);
        Constructor declaredConstructor3 = LinearLayout.class.getDeclaredConstructor(Context.class);
        declaredConstructor3.setAccessible(true);
        View view2 = (View) declaredConstructor3.newInstance(linearLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        LinearLayout linearLayout2 = (LinearLayout) view2;
        Constructor declaredConstructor4 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor4.setAccessible(true);
        ViewGroup.LayoutParams lp6 = (ViewGroup.LayoutParams) declaredConstructor4.newInstance(-1, -2);
        Intrinsics.checkNotNullExpressionValue(lp6, "lp");
        linearLayout2.setLayoutParams(lp6);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(8388627);
        Constructor declaredConstructor5 = RelativeLayout.class.getDeclaredConstructor(Context.class);
        declaredConstructor5.setAccessible(true);
        View view3 = (View) declaredConstructor5.newInstance(linearLayout2.getContext());
        Intrinsics.checkNotNullExpressionValue(view3, "view");
        RelativeLayout relativeLayout = (RelativeLayout) view3;
        Constructor declaredConstructor6 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor6.setAccessible(true);
        ViewGroup.LayoutParams lp7 = (ViewGroup.LayoutParams) declaredConstructor6.newInstance(0, -2);
        Intrinsics.checkNotNullExpressionValue(lp7, "lp");
        ((LinearLayout.LayoutParams) lp7).weight = 1.0f;
        relativeLayout.setLayoutParams(lp7);
        relativeLayout.setGravity(80);
        Constructor declaredConstructor7 = ImageView.class.getDeclaredConstructor(Context.class);
        declaredConstructor7.setAccessible(true);
        View view4 = (View) declaredConstructor7.newInstance(relativeLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(view4, "view");
        ImageView imageView = (ImageView) view4;
        a0.c(imageView, "icon");
        int c16 = a0.c(context, R.dimen.bi8);
        int c17 = a0.c(context, R.dimen.bi8);
        Constructor declaredConstructor8 = RelativeLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor8.setAccessible(true);
        ViewGroup.LayoutParams lp8 = (ViewGroup.LayoutParams) declaredConstructor8.newInstance(Integer.valueOf(c16), Integer.valueOf(c17));
        Intrinsics.checkNotNullExpressionValue(lp8, "lp");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) lp8;
        layoutParams2.setMarginEnd(a0.c(context, R.dimen.bj8));
        layoutParams2.addRule(9, -1);
        layoutParams2.addRule(10, -1);
        imageView.setLayoutParams(lp8);
        relativeLayout.addView(view4);
        Constructor declaredConstructor9 = LinearLayout.class.getDeclaredConstructor(Context.class);
        declaredConstructor9.setAccessible(true);
        View view5 = (View) declaredConstructor9.newInstance(relativeLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(view5, "view");
        LinearLayout linearLayout3 = (LinearLayout) view5;
        a0.c(linearLayout3, "name_area");
        Constructor declaredConstructor10 = RelativeLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor10.setAccessible(true);
        ViewGroup.LayoutParams lp9 = (ViewGroup.LayoutParams) declaredConstructor10.newInstance(-2, 0);
        Intrinsics.checkNotNullExpressionValue(lp9, "lp");
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) lp9;
        layoutParams3.addRule(1, 3226745);
        layoutParams3.addRule(6, 3226745);
        layoutParams3.addRule(8, 3226745);
        linearLayout3.setLayoutParams(lp9);
        linearLayout3.setGravity(16);
        Constructor declaredConstructor11 = TextView.class.getDeclaredConstructor(Context.class);
        declaredConstructor11.setAccessible(true);
        View view6 = (View) declaredConstructor11.newInstance(linearLayout3.getContext());
        Intrinsics.checkNotNullExpressionValue(view6, "view");
        TextView textView = (TextView) view6;
        a0.c(textView, "name");
        Constructor declaredConstructor12 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor12.setAccessible(true);
        ViewGroup.LayoutParams lp10 = (ViewGroup.LayoutParams) declaredConstructor12.newInstance(-1, -1);
        Intrinsics.checkNotNullExpressionValue(lp10, "lp");
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) lp10;
        layoutParams4.width = 0;
        layoutParams4.height = -2;
        layoutParams4.weight = 1.0f;
        textView.setLayoutParams(lp10);
        textView.setGravity(8388627);
        Context context2 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        textView.setTextColor(a0.b(context2, R.color.c7u));
        Context context3 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        textView.setTextSize(0, a0.c(context3, R.dimen.bp9));
        textView.setTypeface(textView.getTypeface(), 1);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout3.addView(view6);
        Constructor declaredConstructor13 = ImageView.class.getDeclaredConstructor(Context.class);
        declaredConstructor13.setAccessible(true);
        View view7 = (View) declaredConstructor13.newInstance(linearLayout3.getContext());
        Intrinsics.checkNotNullExpressionValue(view7, "view");
        ImageView imageView2 = (ImageView) view7;
        a0.c(imageView2, "trading_guarantee_icon");
        Constructor declaredConstructor14 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor14.setAccessible(true);
        ViewGroup.LayoutParams lp11 = (ViewGroup.LayoutParams) declaredConstructor14.newInstance(-1, -1);
        Intrinsics.checkNotNullExpressionValue(lp11, "lp");
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) lp11;
        Context context4 = imageView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        layoutParams5.width = a0.c(context4, R.dimen.bht);
        Context context5 = imageView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        layoutParams5.height = a0.c(context5, R.dimen.bht);
        layoutParams5.gravity = 16;
        Context context6 = imageView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "context");
        layoutParams5.setMarginStart(a0.c(context6, R.dimen.bpd));
        imageView2.setLayoutParams(lp11);
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView2.setBackgroundResource(R.drawable.m9j);
        imageView2.setVisibility(8);
        linearLayout3.addView(view7);
        Constructor declaredConstructor15 = TextView.class.getDeclaredConstructor(Context.class);
        declaredConstructor15.setAccessible(true);
        View view8 = (View) declaredConstructor15.newInstance(linearLayout3.getContext());
        Intrinsics.checkNotNullExpressionValue(view8, "view");
        TextView textView2 = (TextView) view8;
        a0.c(textView2, "debug_type_desc");
        Constructor declaredConstructor16 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor16.setAccessible(true);
        ViewGroup.LayoutParams lp12 = (ViewGroup.LayoutParams) declaredConstructor16.newInstance(-1, -1);
        Intrinsics.checkNotNullExpressionValue(lp12, "lp");
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) lp12;
        layoutParams6.width = -2;
        layoutParams6.height = -2;
        Context context7 = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context7, "context");
        layoutParams6.setMarginStart(a0.c(context7, R.dimen.bde));
        textView2.setLayoutParams(lp12);
        Context context8 = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context8, "context");
        a0.b(textView2, a0.c(context8, R.dimen.bde));
        Context context9 = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context9, "context");
        a0.c(textView2, a0.c(context9, R.dimen.bde));
        Context context10 = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context10, "context");
        a0.d(textView2, a0.c(context10, R.dimen.blb));
        Context context11 = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context11, "context");
        a0.a(textView2, a0.c(context11, R.dimen.blb));
        textView2.setGravity(17);
        textView2.setVisibility(8);
        textView2.setText("develop");
        Context context12 = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context12, "context");
        textView2.setBackground(a0.d(context12, R.drawable.m77));
        Context context13 = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context13, "context");
        textView2.setTextSize(0, a0.a(context13, 9));
        Context context14 = textView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context14, "context");
        textView2.setTextColor(a0.b(context14, R.color.d0s));
        linearLayout3.addView(view8);
        Constructor declaredConstructor17 = ImageView.class.getDeclaredConstructor(Context.class);
        declaredConstructor17.setAccessible(true);
        View view9 = (View) declaredConstructor17.newInstance(linearLayout3.getContext());
        Intrinsics.checkNotNullExpressionValue(view9, "view");
        ImageView imageView3 = (ImageView) view9;
        a0.c(imageView3, "original_label");
        Constructor declaredConstructor18 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor18.setAccessible(true);
        ViewGroup.LayoutParams lp13 = (ViewGroup.LayoutParams) declaredConstructor18.newInstance(-1, -1);
        Intrinsics.checkNotNullExpressionValue(lp13, "lp");
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) lp13;
        layoutParams7.width = -2;
        layoutParams7.height = -2;
        layoutParams7.gravity = 16;
        Context context15 = imageView3.getContext();
        Intrinsics.checkNotNullExpressionValue(context15, "context");
        layoutParams7.setMarginStart(a0.c(context15, R.dimen.bde));
        imageView3.setLayoutParams(lp13);
        imageView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView3.setVisibility(8);
        Context context16 = imageView3.getContext();
        Intrinsics.checkNotNullExpressionValue(context16, "context");
        imageView3.setMinimumWidth(a0.c(context16, R.dimen.bi8));
        Context context17 = imageView3.getContext();
        Intrinsics.checkNotNullExpressionValue(context17, "context");
        imageView3.setMinimumHeight(a0.a(context17, 14));
        imageView3.setBackgroundResource(R.drawable.m9g);
        linearLayout3.addView(view9);
        Constructor declaredConstructor19 = WeImageView.class.getDeclaredConstructor(Context.class);
        declaredConstructor19.setAccessible(true);
        View view10 = (View) declaredConstructor19.newInstance(linearLayout3.getContext());
        Intrinsics.checkNotNullExpressionValue(view10, "view");
        WeImageView weImageView = (WeImageView) view10;
        Constructor declaredConstructor20 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor20.setAccessible(true);
        ViewGroup.LayoutParams lp14 = (ViewGroup.LayoutParams) declaredConstructor20.newInstance(-1, -1);
        Intrinsics.checkNotNullExpressionValue(lp14, "lp");
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) lp14;
        Context context18 = weImageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context18, "context");
        layoutParams8.width = a0.a(context18, 10);
        Context context19 = weImageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context19, "context");
        layoutParams8.height = a0.a(context19, 20);
        layoutParams8.topMargin = 1;
        Context context20 = weImageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context20, "context");
        layoutParams8.leftMargin = a0.a(context20, 2);
        weImageView.setLayoutParams(lp14);
        Context context21 = weImageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context21, "context");
        weImageView.setIconColor(a0.b(context21, R.color.bvi));
        weImageView.setBackgroundResource(R.drawable.m8q);
        linearLayout3.addView(view10);
        relativeLayout.addView(view5);
        Constructor declaredConstructor21 = TextView.class.getDeclaredConstructor(Context.class);
        declaredConstructor21.setAccessible(true);
        View view11 = (View) declaredConstructor21.newInstance(relativeLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(view11, "view");
        TextView textView3 = (TextView) view11;
        a0.c(textView3, LocalPhotoFaceInfo.SCORE);
        Constructor declaredConstructor22 = RelativeLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor22.setAccessible(true);
        ViewGroup.LayoutParams lp15 = (ViewGroup.LayoutParams) declaredConstructor22.newInstance(-1, -1);
        Intrinsics.checkNotNullExpressionValue(lp15, "lp");
        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) lp15;
        layoutParams9.width = -2;
        layoutParams9.height = -2;
        layoutParams9.addRule(18, 1233317313);
        layoutParams9.addRule(3, 1233317313);
        textView3.setLayoutParams(lp15);
        textView3.setGravity(8388627);
        Context context22 = textView3.getContext();
        Intrinsics.checkNotNullExpressionValue(context22, "context");
        textView3.setTextColor(a0.b(context22, R.color.aiq));
        Context context23 = textView3.getContext();
        Intrinsics.checkNotNullExpressionValue(context23, "context");
        textView3.setTextSize(0, a0.a(context23, 12));
        relativeLayout.addView(view11);
        linearLayout2.addView(view3);
        Constructor declaredConstructor23 = LinearLayout.class.getDeclaredConstructor(Context.class);
        declaredConstructor23.setAccessible(true);
        View view12 = (View) declaredConstructor23.newInstance(linearLayout2.getContext());
        Intrinsics.checkNotNullExpressionValue(view12, "view");
        LinearLayout linearLayout4 = (LinearLayout) view12;
        a0.c(linearLayout4, "status_ll");
        Constructor declaredConstructor24 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor24.setAccessible(true);
        ViewGroup.LayoutParams lp16 = (ViewGroup.LayoutParams) declaredConstructor24.newInstance(-1, -1);
        Intrinsics.checkNotNullExpressionValue(lp16, "lp");
        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) lp16;
        layoutParams10.width = -2;
        Context context24 = linearLayout4.getContext();
        Intrinsics.checkNotNullExpressionValue(context24, "context");
        layoutParams10.height = a0.a(context24, 24);
        Context context25 = linearLayout4.getContext();
        Intrinsics.checkNotNullExpressionValue(context25, "context");
        layoutParams10.leftMargin = a0.a(context25, 30);
        Context context26 = linearLayout4.getContext();
        Intrinsics.checkNotNullExpressionValue(context26, "context");
        layoutParams10.rightMargin = a0.a(context26, 16);
        linearLayout4.setLayoutParams(lp16);
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(16);
        Context context27 = linearLayout4.getContext();
        Intrinsics.checkNotNullExpressionValue(context27, "context");
        a0.b(linearLayout4, a0.a(context27, 6));
        Context context28 = linearLayout4.getContext();
        Intrinsics.checkNotNullExpressionValue(context28, "context");
        a0.c(linearLayout4, a0.a(context28, 6));
        linearLayout4.setVisibility(8);
        Constructor declaredConstructor25 = ImageView.class.getDeclaredConstructor(Context.class);
        declaredConstructor25.setAccessible(true);
        View view13 = (View) declaredConstructor25.newInstance(linearLayout4.getContext());
        Intrinsics.checkNotNullExpressionValue(view13, "view");
        ImageView imageView4 = (ImageView) view13;
        a0.c(imageView4, "status_icon");
        Context context29 = imageView4.getContext();
        Intrinsics.checkNotNullExpressionValue(context29, "context");
        a0.b(imageView4, a0.a(context29, 2));
        Constructor declaredConstructor26 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor26.setAccessible(true);
        ViewGroup.LayoutParams lp17 = (ViewGroup.LayoutParams) declaredConstructor26.newInstance(-1, -1);
        Intrinsics.checkNotNullExpressionValue(lp17, "lp");
        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) lp17;
        layoutParams11.width = -2;
        layoutParams11.height = -2;
        imageView4.setLayoutParams(lp17);
        Context context30 = imageView4.getContext();
        Intrinsics.checkNotNullExpressionValue(context30, "context");
        imageView4.setMinimumWidth(a0.a(context30, 14));
        Context context31 = imageView4.getContext();
        Intrinsics.checkNotNullExpressionValue(context31, "context");
        imageView4.setMinimumHeight(a0.a(context31, 14));
        linearLayout4.addView(view13);
        Constructor declaredConstructor27 = TextView.class.getDeclaredConstructor(Context.class);
        declaredConstructor27.setAccessible(true);
        View view14 = (View) declaredConstructor27.newInstance(linearLayout4.getContext());
        Intrinsics.checkNotNullExpressionValue(view14, "view");
        TextView textView4 = (TextView) view14;
        a0.c(textView4, "status_desc");
        Constructor declaredConstructor28 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor28.setAccessible(true);
        ViewGroup.LayoutParams lp18 = (ViewGroup.LayoutParams) declaredConstructor28.newInstance(-1, -1);
        Intrinsics.checkNotNullExpressionValue(lp18, "lp");
        LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) lp18;
        layoutParams12.width = -2;
        layoutParams12.height = -2;
        Context context32 = textView4.getContext();
        Intrinsics.checkNotNullExpressionValue(context32, "context");
        layoutParams12.leftMargin = a0.a(context32, 3);
        textView4.setLayoutParams(lp18);
        textView4.setGravity(8388627);
        Context context33 = textView4.getContext();
        Intrinsics.checkNotNullExpressionValue(context33, "context");
        textView4.setTextColor(a0.b(context33, R.color.d0q));
        Context context34 = textView4.getContext();
        Intrinsics.checkNotNullExpressionValue(context34, "context");
        textView4.setTextSize(0, a0.a(context34, 12));
        textView4.setSingleLine();
        textView4.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout4.addView(view14);
        linearLayout2.addView(view12);
        linearLayout.addView(view2);
        addView(view);
        Constructor declaredConstructor29 = ImageView.class.getDeclaredConstructor(Context.class);
        declaredConstructor29.setAccessible(true);
        View view15 = (View) declaredConstructor29.newInstance(getContext());
        Intrinsics.checkNotNullExpressionValue(view15, "view");
        ImageView imageView5 = (ImageView) view15;
        a0.c(imageView5, "menu_line");
        Constructor declaredConstructor30 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor30.setAccessible(true);
        ViewGroup.LayoutParams lp19 = (ViewGroup.LayoutParams) declaredConstructor30.newInstance(-1, -1);
        Intrinsics.checkNotNullExpressionValue(lp19, "lp");
        LinearLayout.LayoutParams layoutParams13 = (LinearLayout.LayoutParams) lp19;
        layoutParams13.width = -1;
        Context context35 = imageView5.getContext();
        Intrinsics.checkNotNullExpressionValue(context35, "context");
        layoutParams13.height = a0.c(context35, R.dimen.c5l);
        Context context36 = imageView5.getContext();
        Intrinsics.checkNotNullExpressionValue(context36, "context");
        imageView5.setBackgroundColor(a0.b(context36, R.color.arg));
        Context context37 = imageView5.getContext();
        Intrinsics.checkNotNullExpressionValue(context37, "context");
        layoutParams13.leftMargin = a0.a(context37, 12);
        imageView5.setLayoutParams(lp19);
        addView(view15);
    }
}
