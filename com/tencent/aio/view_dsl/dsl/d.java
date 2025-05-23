package com.tencent.aio.view_dsl.dsl;

import android.view.View;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\u000f\u001a\u00020\n*\u00020\t2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "", "value", "getOnClick", "(Landroid/view/View;)Lkotlin/jvm/functions/Function1;", "a", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", NodeProps.ON_CLICK, "Landroid/widget/ProgressBar;", "", "getProgressDrawable_res", "(Landroid/widget/ProgressBar;)I", "b", "(Landroid/widget/ProgressBar;I)V", "progressDrawable_res", "core_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class d {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    static final class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1 f69961d;

        a(Function1 function1) {
            this.f69961d = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) function1);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) v3);
            } else {
                Function1 function1 = this.f69961d;
                Intrinsics.checkNotNullExpressionValue(v3, "v");
                function1.invoke(v3);
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    public static final void a(@NotNull View onClick, @NotNull Function1<? super View, Unit> value) {
        Intrinsics.checkNotNullParameter(onClick, "$this$onClick");
        Intrinsics.checkNotNullParameter(value, "value");
        onClick.setOnClickListener(new a(value));
    }

    public static final void b(@NotNull ProgressBar progressDrawable_res, int i3) {
        Intrinsics.checkNotNullParameter(progressDrawable_res, "$this$progressDrawable_res");
        progressDrawable_res.setProgressDrawable(ContextCompat.getDrawable(progressDrawable_res.getContext(), i3));
    }
}
