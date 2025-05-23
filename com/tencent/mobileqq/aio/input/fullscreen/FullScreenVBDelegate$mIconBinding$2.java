package com.tencent.mobileqq.aio.input.fullscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.fullscreen.f;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lw71/e;", "invoke", "()Lw71/e;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class FullScreenVBDelegate$mIconBinding$2 extends Lambda implements Function0<w71.e> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ FullScreenVBDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenVBDelegate$mIconBinding$2(FullScreenVBDelegate fullScreenVBDelegate) {
        super(0);
        this.this$0 = fullScreenVBDelegate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fullScreenVBDelegate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FullScreenVBDelegate this$0, View view) {
        int A;
        Context context;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S(1);
        A = this$0.A();
        int i3 = 20 - A;
        if (i3 <= 0) {
            context = this$0.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            QQToast.makeText(context, R.string.yrc, 0).show();
        } else {
            this$0.Y(new f.g(i3));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FullScreenVBDelegate this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S(2);
        this$0.Y(f.e.f189637d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(FullScreenVBDelegate this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S(3);
        this$0.Y(f.C7268f.f189638d);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final w71.e invoke() {
        Context context;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (w71.e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.this$0.mBindingInitialized = true;
        context = this.this$0.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        w71.e g16 = w71.e.g(LayoutInflater.from(context), null, false);
        final FullScreenVBDelegate fullScreenVBDelegate = this.this$0;
        LinearLayout root = g16.getRoot();
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.bottomToBottom = 0;
        com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bVar.b(30);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bVar.b(12);
        root.setLayoutParams(layoutParams);
        ImageView imageView = g16.f444788e;
        z16 = fullScreenVBDelegate.mIsSupportPicAbility;
        Boolean valueOf = Boolean.valueOf(z16);
        imageView.setVisibility(0);
        if (((View) au.a(valueOf, imageView)) == null) {
            imageView.setVisibility(8);
        }
        g16.f444788e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.input.fullscreen.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FullScreenVBDelegate$mIconBinding$2.d(FullScreenVBDelegate.this, view);
            }
        });
        ImageView imageView2 = g16.f444785b;
        z17 = fullScreenVBDelegate.mIsSupportCameraAbility;
        Boolean valueOf2 = Boolean.valueOf(z17);
        imageView2.setVisibility(0);
        if (((View) au.a(valueOf2, imageView2)) == null) {
            imageView2.setVisibility(8);
        }
        g16.f444785b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.input.fullscreen.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FullScreenVBDelegate$mIconBinding$2.e(FullScreenVBDelegate.this, view);
            }
        });
        fullScreenVBDelegate.b0(g16.f444786c, true);
        g16.f444786c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.input.fullscreen.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FullScreenVBDelegate$mIconBinding$2.f(FullScreenVBDelegate.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026)\n            }\n        }");
        return g16;
    }
}
