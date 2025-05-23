package com.tencent.mobileqq.cardcontainer.template.demo;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.cardcontainer.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u00012\u00020\u0002:\u0001\u001eB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/demo/DemoCardView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mobileqq/cardcontainer/d;", "", "i", "f", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "data", "Lcom/tencent/mobileqq/cardcontainer/e;", "host", "d", "Landroid/view/View;", "getView", "Lcom/tencent/mobileqq/cardcontainer/template/demo/a;", "Lcom/tencent/mobileqq/cardcontainer/template/demo/a;", "cardData", "e", "Lcom/tencent/mobileqq/cardcontainer/e;", "cardViewHost", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "titleBar", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "title", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class DemoCardView extends RelativeLayout implements com.tencent.mobileqq.cardcontainer.d {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a cardData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.cardcontainer.e cardViewHost;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout titleBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView title;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/demo/DemoCardView$a;", "", "", "BUTTON_HEIGHT", "I", "BUTTON_PADDING", "CARD_WIDTH", "", "TAG", "Ljava/lang/String;", "TITLE_BAR_HEIGHT", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.template.demo.DemoCardView$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DemoCardView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            i();
            f();
        }
    }

    private final void f() {
        Button button = new Button(getContext());
        button.setId(View.generateViewId());
        button.setText("Close");
        ab.d(button, 10.0f);
        button.setBackgroundColor(-7829368);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.cardcontainer.template.demo.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DemoCardView.g(DemoCardView.this, view);
            }
        });
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, cVar.b(26));
        layoutParams.addRule(12);
        button.setPadding(cVar.b(12), 0, cVar.b(12), 0);
        layoutParams.bottomMargin = cVar.b(8);
        Unit unit = Unit.INSTANCE;
        addView(button, layoutParams);
        Button button2 = new Button(getContext());
        button2.setId(View.generateViewId());
        button2.setText("Jump");
        ab.d(button2, 10.0f);
        button2.setBackgroundColor(-7829368);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.cardcontainer.template.demo.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DemoCardView.h(DemoCardView.this, view);
            }
        });
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, cVar.b(26));
        layoutParams2.addRule(2, button.getId());
        button2.setPadding(cVar.b(12), 0, cVar.b(12), 0);
        layoutParams2.bottomMargin = cVar.b(6);
        addView(button2, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(DemoCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.cardcontainer.e eVar = this$0.cardViewHost;
        com.tencent.mobileqq.cardcontainer.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardViewHost");
            eVar = null;
        }
        eVar.F8();
        com.tencent.mobileqq.cardcontainer.e eVar3 = this$0.cardViewHost;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardViewHost");
        } else {
            eVar2 = eVar3;
        }
        eVar2.Ie("[custom report data]");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DemoCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.cardcontainer.e eVar = this$0.cardViewHost;
        com.tencent.mobileqq.cardcontainer.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardViewHost");
            eVar = null;
        }
        eVar.aa("do jump action for demo card");
        com.tencent.mobileqq.cardcontainer.e eVar3 = this$0.cardViewHost;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardViewHost");
        } else {
            eVar2 = eVar3;
        }
        eVar2.G2("custom report data");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.titleBar = frameLayout;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.qqnt.base.utils.c.f353052a.b(40));
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        Unit unit = Unit.INSTANCE;
        addView(frameLayout, layoutParams);
        TextView textView = new TextView(getContext());
        this.title = textView;
        textView.setText("Card Title");
        FrameLayout frameLayout2 = this.titleBar;
        TextView textView2 = null;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            frameLayout2 = null;
        }
        TextView textView3 = this.title;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        } else {
            textView2 = textView3;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(0, 10, 0, 10);
        frameLayout2.addView(textView2, layoutParams2);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.cardcontainer.template.demo.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DemoCardView.j(DemoCardView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DemoCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getContext(), "Card clicked", 0).show();
        com.tencent.mobileqq.cardcontainer.e eVar = this$0.cardViewHost;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardViewHost");
            eVar = null;
        }
        eVar.nc(2, "[custom report data]");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            d.a.a(this);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    public void d(@NotNull com.tencent.mobileqq.cardcontainer.data.a data, @NotNull com.tencent.mobileqq.cardcontainer.e host) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, (Object) host);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(host, "host");
        this.cardViewHost = host;
        a aVar = (a) data;
        this.cardData = aVar;
        TextView textView = this.title;
        FrameLayout frameLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        a aVar2 = this.cardData;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardData");
            aVar2 = null;
        }
        textView.setText(aVar2.l());
        FrameLayout frameLayout2 = this.titleBar;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.setBackgroundColor(aVar.t());
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    @NotNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this;
    }
}
