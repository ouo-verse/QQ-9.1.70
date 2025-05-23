package com.tencent.mobileqq.troop.teamup.home.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ts2.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lts2/l;", "invoke", "()Lts2/l;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes19.dex */
final class MediaDisplayView$foldViewBinding$2 extends Lambda implements Function0<l> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Context $context;
    final /* synthetic */ MediaDisplayView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaDisplayView$foldViewBinding$2(Context context, MediaDisplayView mediaDisplayView) {
        super(0);
        this.$context = context;
        this.this$0 = mediaDisplayView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) mediaDisplayView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MediaDisplayView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
        Function0<Unit> h16 = this$0.h();
        if (h16 != null) {
            h16.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final l invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (l) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        l f16 = l.f(LayoutInflater.from(this.$context), this.this$0);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        LinearLayout linearLayout = f16.f437426d;
        final MediaDisplayView mediaDisplayView = this.this$0;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.home.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaDisplayView$foldViewBinding$2.b(MediaDisplayView.this, view);
            }
        });
        return f16;
    }
}
