package com.tencent.mobileqq.aio.input.fullscreen.entry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.aio.input.fullscreen.entry.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import w71.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lw71/d;", "invoke", "()Lw71/d;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class FullScreenBtnVBDelegate$mFullScreenBtnBinding$2 extends Lambda implements Function0<d> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ FullScreenBtnVBDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenBtnVBDelegate$mFullScreenBtnBinding$2(FullScreenBtnVBDelegate fullScreenBtnVBDelegate) {
        super(0);
        this.this$0 = fullScreenBtnVBDelegate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fullScreenBtnVBDelegate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FullScreenBtnVBDelegate this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("FullScreenBtnVB", 1, "[onClick]: change fullScreenMode");
        this$0.m(a.C7267a.f189624d);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final d invoke() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.this$0.hasInit = true;
        context = this.this$0.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        d g16 = d.g(LayoutInflater.from(context), null, false);
        final FullScreenBtnVBDelegate fullScreenBtnVBDelegate = this.this$0;
        RelativeLayout root = g16.getRoot();
        com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(bVar.b(23), bVar.b(23));
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = bVar.b(0);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bVar.b(12);
        layoutParams.topToTop = 0;
        layoutParams.rightToRight = 0;
        root.setLayoutParams(layoutParams);
        g16.getRoot().setVisibility(8);
        g16.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.input.fullscreen.entry.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FullScreenBtnVBDelegate$mFullScreenBtnBinding$2.b(FullScreenBtnVBDelegate.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          }\n            }");
        return g16;
    }
}
