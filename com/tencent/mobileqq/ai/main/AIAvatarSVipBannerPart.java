package com.tencent.mobileqq.ai.main;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ai.QuickLiveData;
import com.tencent.mobileqq.ai.main.AIAvatarMainViewModel;
import com.tencent.mobileqq.ai.main.AIAvatarSVipBannerPart;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/ai/main/AIAvatarSVipBannerPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/ai/main/a;", "info", "", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "d", "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "vm", "e", "Landroid/view/View;", "bannerLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "bannerText", tl.h.F, "bannerArrow", "Lcom/tencent/mobileqq/ai/main/AIAvatarSVipBannerPart$a;", "i", "B9", "()Lcom/tencent/mobileqq/ai/main/AIAvatarSVipBannerPart$a;", "svipIconSpan", "<init>", "()V", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIAvatarSVipBannerPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View bannerLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView bannerText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View bannerArrow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy svipIconSpan;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015JR\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/ai/main/AIAvatarSVipBannerPart$a;", "Lcom/tencent/mobileqq/widget/VerticalCenterImageSpan;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "text", "", "start", "end", "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "Landroid/graphics/Paint;", "paint", "", "draw", "Landroid/graphics/drawable/Drawable;", "drawable", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a extends VerticalCenterImageSpan {
        static IPatchRedirector $redirector_;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Drawable drawable) {
            super(drawable);
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable);
            }
        }

        @Override // com.tencent.mobileqq.widget.VerticalCenterImageSpan, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, canvas, text, Integer.valueOf(start), Integer.valueOf(end), Float.valueOf(x16), Integer.valueOf(top), Integer.valueOf(y16), Integer.valueOf(bottom), paint);
                return;
            }
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            Drawable drawable = getDrawable();
            canvas.save();
            canvas.translate(x16, ((((bottom - top) - drawable.getBounds().bottom) / 2) + top) - ViewUtils.dip2px(0.5f));
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public AIAvatarSVipBannerPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIAvatarMainViewModel>() { // from class: com.tencent.mobileqq.ai.main.AIAvatarSVipBannerPart$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarSVipBannerPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AIAvatarMainViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIAvatarMainViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AIAvatarMainViewModel.Companion companion = AIAvatarMainViewModel.INSTANCE;
                    Fragment hostFragment = AIAvatarSVipBannerPart.this.getHostFragment();
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    return companion.a(hostFragment);
                }
            });
            this.vm = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.ai.main.AIAvatarSVipBannerPart$svipIconSpan$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarSVipBannerPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final AIAvatarSVipBannerPart.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIAvatarSVipBannerPart.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    int spToPx = ViewUtils.spToPx(45.0f);
                    int spToPx2 = ViewUtils.spToPx(20.0f);
                    Drawable drawable = AIAvatarSVipBannerPart.this.getContext().getDrawable(R.drawable.npf);
                    if (drawable == null) {
                        return null;
                    }
                    drawable.setBounds(0, 0, spToPx, spToPx2);
                    return new AIAvatarSVipBannerPart.a(drawable);
                }
            });
            this.svipIconSpan = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final a B9() {
        return (a) this.svipIconSpan.getValue();
    }

    private final AIAvatarMainViewModel C9() {
        return (AIAvatarMainViewModel) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0097  */
    /* JADX WARN: Type inference failed for: r11v8, types: [android.view.View] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E9(final com.tencent.mobileqq.ai.main.a info) {
        boolean z16;
        View view;
        View view2;
        View view3;
        SpannableStringBuilder spannableStringBuilder;
        int indexOf$default;
        TextView textView;
        a B9;
        boolean z17;
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        boolean isSVip = VasUtil.getSignedService(f16).getVipStatus().isSVip();
        TextView textView2 = null;
        if (info == null) {
            ?? r112 = this.bannerLayout;
            if (r112 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            } else {
                textView2 = r112;
            }
            textView2.setVisibility(8);
            return;
        }
        View view4 = this.bannerLayout;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            view4 = null;
        }
        view4.setVisibility(0);
        if (info.b() != 99) {
            if (info.c().length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if (!z16 && !isSVip) {
                    View view5 = this.bannerArrow;
                    if (view5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bannerArrow");
                        view5 = null;
                    }
                    view5.setVisibility(0);
                    View view6 = this.bannerLayout;
                    if (view6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
                        view6 = null;
                    }
                    view6.setEnabled(true);
                    View view7 = this.bannerLayout;
                    if (view7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
                        view7 = null;
                    }
                    view7.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ai.main.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view8) {
                            AIAvatarSVipBannerPart.F9(AIAvatarSVipBannerPart.this, info, view8);
                        }
                    });
                } else {
                    view = this.bannerLayout;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
                        view = null;
                    }
                    view.setOnClickListener(null);
                    view2 = this.bannerArrow;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bannerArrow");
                        view2 = null;
                    }
                    view2.setVisibility(8);
                    view3 = this.bannerLayout;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
                        view3 = null;
                    }
                    view3.setEnabled(false);
                }
                if (!isSVip) {
                    spannableStringBuilder = new SpannableStringBuilder("\u4f60\u662f\u5c0a\u8d35\u7684 SVIP \u5168\u573a\u6a21\u677f\u514d\u8d39\u4f7f\u7528");
                } else if (info.a() > 0) {
                    spannableStringBuilder = new SpannableStringBuilder().append((CharSequence) "\u4eca\u65e5\u8fd8\u5269").append((CharSequence) String.valueOf(info.a())).append((CharSequence) "\u6b21\uff0c\u5f00\u901a SVIP \u53ef\u65e0\u9650\u6b21\u4f7f\u7528");
                } else {
                    spannableStringBuilder = new SpannableStringBuilder("\u4eca\u65e5\u6b21\u6570\u5df2\u7528\u5b8c\uff0c\u5f00\u901a SVIP \u53ef\u65e0\u9650\u6b21\u4f7f\u7528");
                }
                Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "this");
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spannableStringBuilder, "SVIP", 0, false, 6, (Object) null);
                if (indexOf$default > 0 && (B9 = B9()) != null) {
                    spannableStringBuilder.setSpan(B9, indexOf$default, indexOf$default + 4, 18);
                }
                textView = this.bannerText;
                if (textView != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bannerText");
                } else {
                    textView2 = textView;
                }
                textView2.setText(spannableStringBuilder);
            }
        }
        z16 = false;
        if (!z16) {
        }
        view = this.bannerLayout;
        if (view == null) {
        }
        view.setOnClickListener(null);
        view2 = this.bannerArrow;
        if (view2 == null) {
        }
        view2.setVisibility(8);
        view3 = this.bannerLayout;
        if (view3 == null) {
        }
        view3.setEnabled(false);
        if (!isSVip) {
        }
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "this");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spannableStringBuilder, "SVIP", 0, false, 6, (Object) null);
        if (indexOf$default > 0) {
            spannableStringBuilder.setSpan(B9, indexOf$default, indexOf$default + 4, 18);
        }
        textView = this.bannerText;
        if (textView != null) {
        }
        textView2.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(AIAvatarSVipBannerPart this$0, com.tencent.mobileqq.ai.main.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(this$0.getContext(), aVar.c());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.sfn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026vatar_svip_banner_layout)");
        this.bannerLayout = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            findViewById = null;
        }
        View findViewById2 = findViewById.findViewById(R.id.sfo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "bannerLayout.findViewByI\u2026_avatar_svip_banner_text)");
        this.bannerText = (TextView) findViewById2;
        View view = this.bannerLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            view = null;
        }
        View findViewById3 = view.findViewById(R.id.sfm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "bannerLayout.findViewByI\u2026avatar_svip_banner_arrow)");
        this.bannerArrow = findViewById3;
        E9(null);
        QuickLiveData<com.tencent.mobileqq.ai.main.a> Q1 = C9().Q1();
        LifecycleOwner viewLifecycleOwner = getHostFragment().getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.ai.main.a, Unit> function1 = new Function1<com.tencent.mobileqq.ai.main.a, Unit>() { // from class: com.tencent.mobileqq.ai.main.AIAvatarSVipBannerPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarSVipBannerPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    AIAvatarSVipBannerPart.this.E9(aVar);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                }
            }
        };
        Q1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.ai.main.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIAvatarSVipBannerPart.D9(Function1.this, obj);
            }
        });
    }
}
