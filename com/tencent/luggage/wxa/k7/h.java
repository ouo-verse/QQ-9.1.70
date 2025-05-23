package com.tencent.luggage.wxa.k7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.wxa.i3.x;
import com.tencent.luggage.wxa.mo.a0;
import com.tencent.luggage.wxa.ok.j;
import com.tencent.luggage.wxa.ok.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B!\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\u0006\u0010\u0010\u001a\u00020\u0015J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/luggage/wxa/k7/h;", "Lcom/tencent/luggage/wxa/ok/j;", "Lcom/tencent/luggage/wxa/ok/l;", "", "can", "", "setCanShowHideAnimation", "Lkotlin/Function0;", "block", "c", "", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "", "icon", "name", "a", "Landroid/view/View;", "getView", "cancelPendingInputEvents", "listener", "Lcom/tencent/luggage/wxa/k7/h$a;", "isGame", "b", "Landroid/content/Context;", "Landroid/content/Context;", "ctx", "Z", "Lcom/tencent/luggage/wxa/k7/h$a;", "loadingSplash", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "appBrandIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "appBrandTypeDesc", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "brandLayout", "Lcom/tencent/luggage/wxa/c5/e;", "runtime", "<init>", "(Landroid/content/Context;Lcom/tencent/luggage/wxa/c5/e;Z)V", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class h implements j, l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context ctx;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isGame;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final a loadingSplash;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ImageView appBrandIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView appBrandTypeDesc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public LinearLayout brandLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/luggage/wxa/k7/h$a;", "Lcom/tencent/luggage/wxa/ok/c;", "Landroid/view/View$OnClickListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/luggage/wxa/c5/e;", "c0", "Lcom/tencent/luggage/wxa/c5/e;", "runtime", "", "d0", "Z", "isGame", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;Lcom/tencent/luggage/wxa/c5/e;Z)V", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
    @SuppressLint({"ViewConstructor"})
    /* loaded from: classes8.dex */
    public static final class a extends com.tencent.luggage.wxa.ok.c {

        /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
        public final com.tencent.luggage.wxa.c5.e runtime;

        /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
        public final boolean isGame;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.k7.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class ViewOnClickListenerC6367a implements View.OnClickListener {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View.OnClickListener f131780b;

            public ViewOnClickListenerC6367a(View.OnClickListener onClickListener) {
                this.f131780b = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.tencent.luggage.wxa.c5.e eVar;
                if (!a.this.f136558a0 && (eVar = a.this.runtime) != null) {
                    x xVar = x.f129431a;
                    String k3 = eVar.S().k();
                    Intrinsics.checkNotNullExpressionValue(k3, "initConfig.wxaLaunchInstanceId");
                    x.a(xVar, k3, x.d.CLOSE_BEFORE_START, null, 4, null);
                }
                this.f131780b.onClick(view);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Context ctx, @Nullable com.tencent.luggage.wxa.c5.e eVar, boolean z16) {
            super(ctx);
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            this.runtime = eVar;
            this.isGame = z16;
            if (eVar != null) {
                super.a(eVar);
                super.setWindowAndroid(eVar.n0());
            }
        }

        @Override // com.tencent.luggage.wxa.ok.c
        public View.OnClickListener q() {
            return new ViewOnClickListenerC6367a(super.q());
        }
    }

    public h(@NotNull Context ctx, @Nullable com.tencent.luggage.wxa.c5.e eVar, boolean z16) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.ctx = ctx;
        this.isGame = z16;
        this.loadingSplash = new a(ctx, eVar, z16);
        View view = getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = ctx.getResources().getDimensionPixelSize(R.dimen.bif);
        this.appBrandIcon = new ImageView(ctx);
        this.appBrandTypeDesc = new TextView(ctx);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) ctx.getResources().getDimension(R.dimen.bht), (int) ctx.getResources().getDimension(R.dimen.bht));
        layoutParams2.gravity = 17;
        this.appBrandIcon.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        layoutParams3.leftMargin = (int) ctx.getResources().getDimension(R.dimen.bgc);
        this.appBrandTypeDesc.setTextSize(0, ctx.getResources().getDimension(R.dimen.bp9));
        this.appBrandTypeDesc.setTextColor(ContextCompat.getColor(ctx, R.color.anv));
        this.appBrandTypeDesc.setLayoutParams(layoutParams3);
        this.appBrandTypeDesc.setGravity(17);
        Constructor declaredConstructor = LinearLayout.class.getDeclaredConstructor(Context.class);
        declaredConstructor.setAccessible(true);
        View view2 = (View) declaredConstructor.newInstance(frameLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        LinearLayout linearLayout = (LinearLayout) view2;
        linearLayout.setOrientation(1);
        Class cls = Integer.TYPE;
        Constructor declaredConstructor2 = FrameLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor2.setAccessible(true);
        ViewGroup.LayoutParams lp5 = (ViewGroup.LayoutParams) declaredConstructor2.newInstance(-1, -1);
        Intrinsics.checkNotNullExpressionValue(lp5, "lp");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) lp5;
        layoutParams4.width = -1;
        layoutParams4.height = -2;
        layoutParams4.gravity = 81;
        layoutParams4.leftMargin = a0.a(ctx, 16);
        layoutParams4.rightMargin = a0.a(ctx, 16);
        layoutParams4.bottomMargin = a0.a(ctx, 16);
        linearLayout.setLayoutParams(lp5);
        Constructor declaredConstructor3 = LinearLayout.class.getDeclaredConstructor(Context.class);
        declaredConstructor3.setAccessible(true);
        View view3 = (View) declaredConstructor3.newInstance(linearLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(view3, "view");
        LinearLayout linearLayout2 = (LinearLayout) view3;
        Constructor declaredConstructor4 = LinearLayout.LayoutParams.class.getDeclaredConstructor(cls, cls);
        declaredConstructor4.setAccessible(true);
        ViewGroup.LayoutParams lp6 = (ViewGroup.LayoutParams) declaredConstructor4.newInstance(-1, -1);
        Intrinsics.checkNotNullExpressionValue(lp6, "lp");
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) lp6;
        layoutParams5.width = -2;
        layoutParams5.height = -2;
        layoutParams5.bottomMargin = a0.a(ctx, 8);
        layoutParams5.gravity = 1;
        linearLayout2.setLayoutParams(lp6);
        this.brandLayout = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.addView(this.appBrandIcon, 0);
        linearLayout2.addView(this.appBrandTypeDesc, 1);
        linearLayout2.setVisibility(8);
        linearLayout.addView(view3);
        Constructor declaredConstructor5 = TextView.class.getDeclaredConstructor(Context.class);
        declaredConstructor5.setAccessible(true);
        View view4 = (View) declaredConstructor5.newInstance(linearLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(view4, "view");
        TextView textView = (TextView) view4;
        a0.c(textView, "gameAddiction");
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(ContextCompat.getColor(ctx, R.color.bwx));
        textView.setText(ctx.getString(R.string.f1639124e));
        textView.setGravity(17);
        textView.setVisibility(8);
        linearLayout.addView(view4);
        frameLayout.addView(view2);
        b();
    }

    public final int a(boolean isGame) {
        return (isGame && com.tencent.luggage.wxa.h6.l.f126905a.c()) ? R.drawable.ogc : (!isGame || com.tencent.luggage.wxa.h6.l.f126905a.c()) ? (isGame || !com.tencent.luggage.wxa.h6.l.f126905a.c()) ? R.drawable.ogd : R.drawable.oge : R.drawable.ogb;
    }

    public final void b() {
        LinearLayout linearLayout = this.brandLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("brandLayout");
            linearLayout = null;
        }
        int i3 = 0;
        linearLayout.setVisibility(0);
        this.appBrandIcon.setImageResource(a(this.isGame));
        View a16 = a0.a(getView(), "gameAddiction");
        if (!this.isGame) {
            i3 = 8;
        }
        a16.setVisibility(i3);
        if (this.isGame) {
            com.tencent.luggage.wxa.ok.g.a(this.ctx, true);
            this.appBrandTypeDesc.setText(this.ctx.getString(R.string.f242267u4));
        } else {
            this.appBrandTypeDesc.setText(this.ctx.getString(R.string.f242257u3));
        }
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void c(Function0 block) {
        this.loadingSplash.c(block);
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void cancelPendingInputEvents() {
        this.loadingSplash.cancelPendingInputEvents();
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public View getView() {
        View view = this.loadingSplash.getView();
        Intrinsics.checkNotNullExpressionValue(view, "loadingSplash.view");
        return view;
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public /* synthetic */ void setAppServiceType(int i3) {
        o31.b.a(this, i3);
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void setCanShowHideAnimation(boolean can) {
        this.loadingSplash.setCanShowHideAnimation(can);
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void setProgress(int progress) {
        this.loadingSplash.setProgress(progress);
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void a(String icon, String name) {
        this.loadingSplash.a(icon, name);
    }

    @Override // com.tencent.luggage.wxa.ok.l
    public void a(Function0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.loadingSplash.a(listener);
    }

    /* renamed from: a, reason: from getter */
    public final a getLoadingSplash() {
        return this.loadingSplash;
    }
}
